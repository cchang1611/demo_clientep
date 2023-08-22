package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaPlataformaServiciosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExcelPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaFoliosConsultaOperativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaFoliosConsultaOperativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 * Consultas plataforma servicios
 * @author RARREOLA
 *
 */
@Service
public class ConsultaPlataformaServiciosServiceImpl implements ConsultaPlataformaServiciosService{
	
	/**
	 * log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultaPlataformaServiciosServiceImpl.class);
	
	/**
	 * template para los llamados REST
	 */
	@Autowired
	private RestTemplate restTemplate;

	
	/**
	 * uriConsultaFoliosOperativa
	 */
	@Value("${comunes.folios.consultaOperativa}")
	private String uriConsultaFoliosOperativa;
	
	
	/**
	 * Inyeccion de utileria fecha
	 */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;

	/**
	 * Folios consulta operativa
	 * @param entrada
	 * @return
	 */
	@Override
	public List<SalidaFoliosConsultaOperativa> foliosConsultaOperativa(EntradaPlataformaServicios consulta, String claveServicio, String datoServicio) {
		List<SalidaFoliosConsultaOperativa> respuestaGenerica = null;
		EntradaFoliosConsultaOperativa entrada = setearInformacion(consulta, claveServicio, datoServicio);
		
		
		try{
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<EntradaFoliosConsultaOperativa> entidadFolio = new HttpEntity<>(entrada, headerMedia);
			
			logger.info(uriConsultaFoliosOperativa);
			logger.info("Peticion generacion de folios consulta operativa {}", entrada.toString());

			ResponseEntity<String> respuesta = restTemplate.exchange(uriConsultaFoliosOperativa, HttpMethod.POST, entidadFolio, String.class);
			
			if(respuesta.getBody() != null) {
				JsonUtilsImpl<SalidaFoliosConsultaOperativa> json = new JsonUtilsImpl<>();
				respuestaGenerica  = json.parseJsonToObjectList(respuesta.getBody(), SalidaFoliosConsultaOperativa.class);
			}
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio a mostrar folios consulta operativa", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		
		return respuestaGenerica;
	}
	/**
	 * Metodo 
	 * @return
	 */
	private List<Long> obtenerParametro() {
		
			List<Parametro> lparametro = servicioCatalogo.obtenerParametro(ActivacionConstants.PARAMETRO_PLATAFORMA, null);
			
			List<Long> listaUsuarios = new ArrayList<>();
			for(Parametro objeto: lparametro){
				listaUsuarios.add(Long.valueOf(objeto.getChValorParametro()));
			
			}
		
		return listaUsuarios;
	}

	/**
	 * Setear informacion
	 * @param consulta
	 * @return
	 */
	private EntradaFoliosConsultaOperativa setearInformacion(EntradaPlataformaServicios consulta, String claveServicio, String datoServicio) {
		EntradaFoliosConsultaOperativa entrada = new EntradaFoliosConsultaOperativa();
		List<String> listaUsuarios = new ArrayList<>();
		List<String> listaFolios = new ArrayList<>();
		List<String> listaAfores = new ArrayList<>();
		String[] usuariosTextArea;
		String[] foliosTextArea;
		entrada.setClaveServicios(claveServicio);
		entrada.setIdUsuariosPulssar(obtenerParametro());
		if(consulta.getAfore()!= null){
			for(int i = 0; i < consulta.getAfore().length; i++){
				listaAfores.add(consulta.getAfore()[i]);
			}
			if(!listaAfores.contains(ActivacionConstants.TODOS)){
				entrada.setClaveOrganizacion(listaAfores);
			}
		}
		entrada.setFechaFin(consulta.getFechaFin());
		entrada.setFechaInicio(consulta.getFechaInicio());
		
		if(Strings.isNotBlank(consulta.getUsuarios())){
			usuariosTextArea = consulta.getUsuarios().split(ExpresionesConstants.SALTO);
			for(int i = 0; i < usuariosTextArea.length; i++){
				String texto = usuariosTextArea[i].replaceAll(ExpresionesConstants.DIAGONAL_R, ExpresionesConstants.VACIO);
				listaUsuarios.add(texto);
			}
			entrada.setUsuarios(listaUsuarios);
		}
		if(Strings.isNotBlank(consulta.getFoliosPulssar())){
			foliosTextArea = consulta.getFoliosPulssar().split(ExpresionesConstants.SALTO);
			for(int i = 0; i < foliosTextArea.length; i++){
				String texto = foliosTextArea[i].replaceAll(ExpresionesConstants.DIAGONAL_R, ExpresionesConstants.VACIO);
				listaFolios.add(texto);
			}
			entrada.setFolioPulssar(listaFolios);
		}
		
		if(ActivacionConstants.CERO_ST.equals(consulta.getResultadoOperacion()) || Strings.isBlank(consulta.getResultadoOperacion())){
			entrada.setResultadoOperacion(ActivacionConstants.TODOS);
		}else{
			entrada.setResultadoOperacion(consulta.getResultadoOperacion());
		}
		
		if(datoServicio != null) {
			entrada.setIdentificadorMDD(false);
			if(NumerosConstants.C_UNO.equals(datoServicio)) {
				entrada.setIdentificadorMDD(true);
			}
		}
		return entrada;
	}

	

	/**
	 * Seteo de informacion
	 * @param listas
	 * @return
	 */
	@Override
	public List<DatosExcelPlataformaServicios> seteoInformacion(List<SalidaFoliosConsultaOperativa> listas) {
		List<DatosExcelPlataformaServicios> listasResultado = null;
		DatosExcelPlataformaServicios nuevo;
		if(listas!=null && !listas.isEmpty()){
			listasResultado = new ArrayList<>();
			int i = 0;
			for(SalidaFoliosConsultaOperativa objeto: listas){
				nuevo = new DatosExcelPlataformaServicios();
				nuevo.setFechaGeneracionFolio(utileriaFecha.convertirFechaACadena(objeto.getFechaGeneracion(), ActivacionConstants.FORMATO_YYYY_MM_DD_HH_MM_SS));
				nuevo.setClaveAfore(objeto.getClaveOrganizacion());
				if(Strings.isNotBlank(objeto.getDiagnostico())){
					nuevo.setDiagnostico(objeto.getDiagnostico());
				}else{
					nuevo.setDiagnostico(ExpresionesConstants.VACIO);
				}
				
				nuevo.setFolioPulssar(objeto.getChFolio());
				if(Strings.isNotBlank(objeto.getResultadoOperacion())){
					nuevo.setResultadoOperacion(objeto.getResultadoOperacion());
				}else{
					nuevo.setResultadoOperacion(ExpresionesConstants.VACIO);
				}
				
				
				nuevo.setUsuario(objeto.getClaveAgente());
				seleccionarColor(nuevo, i);
				listasResultado.add(nuevo);
				i++;
				
			}
		}
		
		return listasResultado;
	}


	/**
	 * Seleccionar color
	 * @param nuevo
	 * @param i
	 */
	private void seleccionarColor(DatosExcelPlataformaServicios nuevo, int i) {
		if(i% 2 == 0){
			nuevo.setColor(ActivacionConstants.COLOR_AZUL);
		}else{
			nuevo.setColor(ActivacionConstants.COLOR_AMARILLO);
		}
	}

	/**
	 * Generar el nombre del excel
	 * @return
	 */
	@Override
	public String generarNombreExcel() {
		StringBuilder nombre = new StringBuilder();
		String nombreExcel;
		
		String fechaCadena = utileriaFecha.convertirFechaACadena(new Date(), ActivacionConstants.FORMATO_YYYYMMDDHH_MM_SS);
		String fechaNueva = fechaCadena.replaceAll(ExpresionesConstants.DOS_PUNTOS, ExpresionesConstants.VACIO);
		fechaNueva = fechaNueva.replaceAll(ExpresionesConstants.ESPACIO, ExpresionesConstants.VACIO);
		nombreExcel = nombre.append(ActivacionConstants.NOMBRE_EXCEL).append(fechaNueva).append(ActivacionConstants.FORMATO_EXCEL).toString();
		return nombreExcel;
	}

	/**
	 * exportar a xlsx
	 * @return
	 * @throws JRException
	 */
	@Override
	public byte[] exportarAExcel(JasperPrint jasperPrint,  ByteArrayOutputStream output) throws JRException{
		JRXlsxExporter exporterXLSX = new JRXlsxExporter(); 
		exporterXLSX.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporterXLSX.setExporterOutput(new SimpleOutputStreamExporterOutput(output));
		SimpleXlsxReportConfiguration configuracion = new SimpleXlsxReportConfiguration();
		configuracion.setOnePagePerSheet(false);
		configuracion.setDetectCellType(true);
		configuracion.setRemoveEmptySpaceBetweenColumns(true);
		exporterXLSX.setConfiguration(configuracion);
		exporterXLSX.exportReport();
		return output.toByteArray();
	}
	
	
	
	/**
	 * generar reporte usando Stream
	 * @param ruta parametros stream
	 * @throws JRException
	 */
	@Override
	public JasperPrint generarReporteStream(byte[] bs, Map<String,Object> parametros, InputStream stream) throws JRException{
		try {
			ByteArrayInputStream jsonDataStream= new ByteArrayInputStream(bs);
			JsonDataSource ds= new JsonDataSource(jsonDataStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(stream);			
			return JasperFillManager.fillReport(jasperReport,parametros,ds);
		}catch(Exception e) {
			logger.error("error al generarReporteStream",e);
			throw e;
		}
	}
	
	/**
	 * Remover afore sici
	 */
	@Override
	public List<Combo> removerAforeSici(List<Combo> lAfores) {
		List<Combo> nuevaLista = new ArrayList<>();
		Combo obj;
		for(Combo objeto:lAfores){
//			obj = new Combo();
			if(!objeto.getClave().equals(ActivacionConstants.CLAVE_SICI)){
				obj = objeto;
				nuevaLista.add(obj);
			}
		}
		return nuevaLista;
	}

}
