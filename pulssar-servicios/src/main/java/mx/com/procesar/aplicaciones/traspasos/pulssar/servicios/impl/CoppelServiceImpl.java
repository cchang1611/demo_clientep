/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.CoppelConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ArchivosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DigitalizacionCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EstructuraHuellasCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellaDactilar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellasDactilares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHuellasCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.XmlUtilsImpl;

/**
 * Servicio de coppel
 * @author dhernand
 *
 */
@Service
public class CoppelServiceImpl implements CoppelService {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CoppelServiceImpl.class);
	/**
	 * Url de la table
	 */
	@Value("#{propiedades['coppel.padfirma.soapData']}")
	private String soapData;
	
	/**
	 * Ambiente tablet
	 */
	@Value("#{propiedades['coppel.padfirma.urlSoap']}")
	private String urlSoap;

	/**
	 * Url de la table
	 */
	@Value("#{propiedades['coppel.digitalizador.soapData']}")
	private String soapDataDigitalizador;
	
	/**
	 * Ambiente tablet
	 */
	@Value("#{propiedades['coppel.digitalizador.urlSoap']}")
	private String urlSoapDigitalizador;
	/**
	 * Ambiente tablet
	 */
	@Value("#{propiedades['coppel.digitalizador.software']}")
	private String digitalitaSw;
	
	/**
	 * Utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Generador de XML
	 */
	@Autowired
	private XmlUtilsImpl xmlUtileria;
	
	/**
	 * Recepcion Archivos
	 */
	@Value("#{propiedades['ruta.archivos.recepcion']}")
	private String rutaRecepcion;
	
	/**
	 * Utileria Fecha
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	/**
	 * Utileria Fecha
	 */
	@Autowired
	private CadenasUtils cadenasUtils;
	
	/**
	 * Inyeccion de expediente servicio
	 */
	@Autowired
	private ExpedienteServicioService expedienteServicio;
	
	/**
	 * Catalogo de servicio
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Genera la peticion para el ipadFirma
	 * @return peticion padFirma
	 */
	public LinkedHashMap<String,String> generarPeticionPadFirma() {
		LinkedHashMap<String,String> peticionPadFirma = new LinkedHashMap<>();
		peticionPadFirma.put(CoppelConstants.SOAP_URL, urlSoap);
		peticionPadFirma.put(CoppelConstants.SOAP_DATA, soapData);
		
		return peticionPadFirma;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelService#generarPeticionDigitalizacion(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DigitalizacionCoppel)
	 */
	@Override
	public LinkedHashMap<String, String> generarPeticionDigitalizacion(DigitalizacionCoppel digitalizacionCoppel, String origen) {
		String banderaIncluyeCampos = NumerosConstants.C_CERO;
		Parametro resultadoParametro = expedienteServicio.obtenerValorParametro(ServiciosConstants.PARAMETRO_INCLUYE_CAMPOS_COPPEL_DIGITA);
		if(!utileriaValidador.validarObjetoNulo(resultadoParametro)) {
			banderaIncluyeCampos = resultadoParametro.getChValorParametro();
		}
		LinkedHashMap<String,String> peticionDigitalizador = new LinkedHashMap<>();
		peticionDigitalizador.put(CoppelConstants.SOAP_URL, urlSoapDigitalizador);
		String peticion = soapDataDigitalizador;
		peticion = peticion.replace("sRuta", digitalitaSw);
		StringBuilder sb = new StringBuilder();
		sb.append(digitalizacionCoppel.getFolioProcesar());
		sb.append(" ");
		sb.append(digitalizacionCoppel.getProceso());
		sb.append(" ");
		sb.append(digitalizacionCoppel.getCurpTitular());
		sb.append(" ");
		sb.append(digitalizacionCoppel.getNssTitular());
		sb.append(" ");
		sb.append(digitalizacionCoppel.getCurpSolicitante());
		sb.append(" ");
		sb.append(digitalizacionCoppel.getTipoSoliciante());
		sb.append(" ");
		sb.append(digitalizacionCoppel.getIdRFCModificado());
		sb.append(" ");
		sb.append(digitalizacionCoppel.getIdSesion());
		sb.append(" ");
		sb.append(digitalizacionCoppel.getPagoBanco());
		if(NumerosConstants.C_UNO.equals(banderaIncluyeCampos)) {
			sb.append(" ");
			if(utileriaValidador.validarObjetoNulo(digitalizacionCoppel.getTipoFlujo())) {
				digitalizacionCoppel.setTipoFlujo(NumerosConstants.C_CERO);
			}
			sb.append(digitalizacionCoppel.getTipoFlujo());
		}
		if(ServiciosConstants.ORIGEN_MATRIMONIO.equals(origen)) {
			sb.append(" ");
			sb.append(ServiciosConstants.DIGITALIZADOR_MATRIMONIO);
		}else {
			sb.append(" ");
			//digitalizacionCoppel.setIdRetParcial(NumerosConstants.C_CERO);
		}
		peticion = peticion.replace("sParametros", sb.toString());
		logger.info("peticion: {}", peticion);
		peticionDigitalizador.put(CoppelConstants.SOAP_DATA, peticion);
		
		return peticionDigitalizador;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarDatosObligatoriosConsulta(String usuario, String curp, String nss, String tipoSolicitante, String timePicker) {
		logger.info("Validar usuario >> {}", usuario);
		validarObligatorio(usuario, BusinessErrorEnum.USUARIO_FALTANTE.getClave());
		utileriaValidador.validarFormato(usuario, ExpresionesConstants.REG_EXP_FORMATO_USUARIO, BusinessErrorEnum.USUARIO_FORMATO_ERROR.getClave());
		
		if(utileriaValidador.validarVacio(curp) && utileriaValidador.validarVacio(nss)) {
			throw new BusinessException(BusinessErrorEnum.CURP_NSS_FALTANTES);
		}
		
		if(!utileriaValidador.validarVacio(curp)) {
			logger.info("Validar curp >> {}", curp);
			validarObligatorio(curp, BusinessErrorEnum.CURP_FALTANTE.getClave());
			utileriaValidador.validarFormato(curp, ExpresionesConstants.REG_EXP_FORMATO_CURP, BusinessErrorEnum.CURP_FORMATO_ERROR.getClave());
		}
		
		if(!utileriaValidador.validarVacio(nss)) {
			logger.info("Validar nss >> {}", nss);
			validarObligatorio(nss, BusinessErrorEnum.NSS_FALTANTE.getClave());
			utileriaValidador.validarFormato(nss, ExpresionesConstants.REG_EXP_FORMATO_NSS, BusinessErrorEnum.NSS_FORMATO_ERROR.getClave());
		}
		
		logger.info("Validar tipoSolicitante >> {}", tipoSolicitante);
		validarObligatorio(tipoSolicitante, BusinessErrorEnum.TIPO_SOLICITANTE_FALTANTE.getClave());
		utileriaValidador.validarFormato(tipoSolicitante, ExpresionesConstants.REG_EXP_FORMATO_TIPO_SOLICITANTE, BusinessErrorEnum.TIPO_SOLICITANTE_FORMATO_ERROR.getClave());
		
		logger.info("Validar timePicker >> {}", timePicker);
		validarObligatorio(timePicker, BusinessErrorEnum.TIME_FALTANTE.getClave());
		utileriaValidador.validarFormato(timePicker, ExpresionesConstants.REG_EXP_FORMATO_TIME_PICKER, BusinessErrorEnum.TIME_FORMATO_ERROR.getClave());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntradaConsulta validarDatosCurpSolicitante(String tipoSolicitante, String curpSolicitante, String nombre, String apellidoPaterno, String apellidoMaterno) {
		EntradaConsulta entrada = new EntradaConsulta();
		
		if(!ActivacionConstants.CV_TIPO_SOLICITANTE_TITULAR.equals(tipoSolicitante)) {
			logger.info("Validar curpSolicitante >> {}", curpSolicitante);
			validarObligatorio(curpSolicitante, BusinessErrorEnum.CURP_SOLICITANTE_FALTANTE.getClave());
			utileriaValidador.validarFormato(curpSolicitante, ExpresionesConstants.REG_EXP_FORMATO_CURP, BusinessErrorEnum.CURP_SOLICITANTE_FORMATO_ERROR.getClave());
			entrada.setCurpSolicitante(curpSolicitante);
			
			logger.info("Validar nombre >> {}", nombre);
			validarObligatorio(nombre, BusinessErrorEnum.NOMBRE_FALTANTE.getClave());
			utileriaValidador.validarFormato(curpSolicitante, ExpresionesConstants.REG_EXP_FORMATO_NOMBRE, BusinessErrorEnum.NOMBRE_FORMATO_ERROR.getClave());
			entrada.setNombre(nombre);
			
			logger.info("Validar apellido paterno >> {}", apellidoPaterno);
			validarObligatorio(apellidoPaterno, BusinessErrorEnum.APELLIDO_PATERNO_FALTANTE.getClave());
			utileriaValidador.validarFormato(apellidoPaterno, ExpresionesConstants.REG_EXP_FORMATO_NOMBRE, BusinessErrorEnum.NOMBRE_FORMATO_ERROR.getClave());
			entrada.setApellidoPaterno(apellidoPaterno);
			
			if(!utileriaValidador.validarVacio(apellidoMaterno)) {
				logger.info("Validar apellido materno >> {}", apellidoPaterno);
				utileriaValidador.validarFormato(apellidoMaterno, ExpresionesConstants.REG_EXP_FORMATO_NOMBRE, BusinessErrorEnum.NOMBRE_FORMATO_ERROR.getClave());
				entrada.setApellidoMaterno(apellidoMaterno);
			}
		}
		
		return entrada;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String guadarHuellasCoppel(String curp, RespuestaHuellasCoppel huellasCoppel, String tipoPersona, String clave) throws JAXBException, IOException  {
		HuellasDactilares oHuellaDactilar = new HuellasDactilares();
		List<HuellaDactilar> huellasDactilares = new ArrayList<>();
		HuellaDactilar huellaDactilar;
		String huellasZip = "";
		int dedoContador = 1;
		if(!utileriaValidador.validarObjetoNulo(huellasCoppel.getHuellasDactilares()) && !utileriaValidador.validarListaVacia(huellasCoppel.getHuellasDactilares().getHuellaDactilar())) {
			for(EstructuraHuellasCoppel huella : huellasCoppel.getHuellasDactilares().getHuellaDactilar()) {
				huellaDactilar = new HuellaDactilar();
				huellaDactilar.setTipoPersona(tipoPersona);
				String dedoMotivo = ExpresionesConstants.VACIO;
				if(utileriaValidador.validarVacio(cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getMotivoSinHuella(), ExpresionesConstants.VACIO))) {
					dedoMotivo = validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getIdDedo(), ExpresionesConstants.VACIO));
					huellaDactilar.setHuella64(validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getHuella64(), ExpresionesConstants.VACIO)));
					huellaDactilar.setHuellaHash(validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getHuellaHash().toUpperCase(), ExpresionesConstants.VACIO))); 
					Date fechaCoppel = fechaUtils.convertirCadenaAFecha(validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huellasCoppel.getFechaCaptura(), ExpresionesConstants.VACIO)), FormatoConstants.FORMATO_HUELLA_COPPEL);
					huellaDactilar.setFechaCaptura(fechaUtils.convertirFechaACadena(fechaCoppel, FormatoConstants.FORMATO_HUELLA));
					huellaDactilar.setIdDevice(validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huellasCoppel.getIdDevice(), ExpresionesConstants.VACIO)));
					huellaDactilar.setAlgoritmoCompresion(validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getAlgoritmoCompresion(), ExpresionesConstants.VACIO)));
					Integer resolucion = NumerosConstants.INT_CERO;
					String resolucionCaptura = validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getResolucionCaptura(), ExpresionesConstants.VACIO));
					if(!resolucionCaptura.equals("500")) {
						resolucion = NumerosConstants.INT_UNO;
					}
					huellaDactilar.setResolucionCaptura(String.valueOf(resolucion));
					huellaDactilar.setUnidadesEscala(validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getUnidadesEscala(), ExpresionesConstants.VACIO)));
					huellaDactilar.setCalidadHuella(validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getCalidadHuella(), ExpresionesConstants.VACIO)));
					huellaDactilar.setPerfilAdquisicionHuella(validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huellasCoppel.getPerfilAdquisicionHuella(), ExpresionesConstants.VACIO)));
				} else {
					dedoMotivo = cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getIdDedo(), ExpresionesConstants.VACIO);
					if(utileriaValidador.validarVacio(dedoMotivo)) {
						dedoMotivo = String.valueOf(dedoContador);
						dedoContador++;
					}
					huellaDactilar.setMotivoSinHuella(validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getMotivoSinHuella(), ExpresionesConstants.VACIO)));
					huellaDactilar.setCodigoFaltaDedo(validarDatoHuella(cadenasUtils.obtenerContenidoCadenaSinEspacios(huella.getCodigoFaltaDedo(), ExpresionesConstants.VACIO)));
				}
				huellaDactilar.setIdDedo(dedoMotivo);
				huellasDactilares.add(huellaDactilar);
			}
			oHuellaDactilar.setHuellaDactilar(huellasDactilares);
			
			String xmlHuellas = xmlUtileria.convertirObjetoXml(oHuellaDactilar);
			
			String valor = servicioCatalogo.consultaValorParametro(ActivacionConstants.PARAMETRO_RUTA_ARCHIVOS_EXPEDIENTE, ActivacionConstants.PARAMETRO_CLAVE_RUTA_ARCHIVOS_EXPEDIENTE);
			valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_AFORE, PdfConstants.COPPEL);
			
			if(ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_1.equals(clave) || ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_4.equals(clave)) {
				String archivo = StringUtils.replace(clave, NumerosConstants.C_CERO, "X");
				valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, archivo);
			} else {
				valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, ArchivosEnum.EXPEDIENTE_BIOMETRICO.getNombreArchivo());
			}
			
			String path = new StringBuilder().append(valor).toString();
			String fileXml = new StringBuilder().append(curp).append(ExpresionesConstants.EXTENSION_XML).toString();
			logger.info("Ruta guardado temporal coppel:::: {}", path);
			
			File archivoXml = new File(new StringBuilder().append(path).append(fileXml).toString());
			BufferedWriter salidaXml = new BufferedWriter(new FileWriter(archivoXml));
			salidaXml.write(xmlHuellas);
			salidaXml.close();
			
			byte[] bufZip = new byte[(int)archivoXml.length()];
			
			File archivoZip = new File(new StringBuilder().append(path).append(curp).append(ExpresionesConstants.EXTENSION_ZIP).toString());
			FileOutputStream archivoSalidaZip = new FileOutputStream(archivoZip);
			ZipOutputStream zipSalida = new ZipOutputStream(archivoSalidaZip);
			ZipEntry nombreArchivoZip = new ZipEntry(fileXml);
			zipSalida.putNextEntry(new ZipEntry(nombreArchivoZip));
			FileInputStream archivoEntrada = new FileInputStream(archivoXml);
			
			int len;
			while ((len = archivoEntrada.read(bufZip)) > 0) {
				zipSalida.write(bufZip, 0, len);
			}
			archivoEntrada.close();
			zipSalida.closeEntry();
			zipSalida.close();
			
			try (FileInputStream zipHuellasFile = new FileInputStream(archivoZip)) {
				byte fileData[] = new byte[(int) archivoZip.length()];
				zipHuellasFile.read(fileData);
				huellasZip = Base64Utils.encodeToString(fileData);
			} catch (Exception ex) {
				logger.error("Error al leer el archivo de zip de huellas", ex);
			}
			archivoXml.delete();
			archivoZip.delete();
		} else {
			throw new BusinessException(BusinessErrorEnum.ERROR_DATOS_FALTANTE_PETICION);
		}
		return huellasZip;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarDatosObligatoriosCoppel(String idSesion, String direccionUrl, String numTienda) {
		validarObligatorio(idSesion, BusinessErrorEnum.ID_SESION_FALTANTE.getClave());
		validarObligatorio(direccionUrl, BusinessErrorEnum.DIRECCION_URL_FALTANTE.getClave());
		validarObligatorio(numTienda, BusinessErrorEnum.NUMERO_TIENDA_FALTANTE.getClave());
	}
	
	/**
	 * Metodo encargado de validar si el dato no se encuentra vacio
	 * 
	 * @param dato
	 * @return
	 */
	private String validarDatoHuella(String dato) {
		if(utileriaValidador.validarVacio(dato)) {
			throw new BusinessException(BusinessErrorEnum.ERROR_DATOS_FALTANTE_PETICION);
		}
		
		return new String(dato);
	}
	
	/**
	 * Metodo encargado de validar la obligatoriedad
	 * 
	 * @param dato
	 */
	private void validarObligatorio(String dato, String error) {
		if(utileriaValidador.validarVacio(dato)) {
			throw new BusinessException(error);
		}
	}
}
