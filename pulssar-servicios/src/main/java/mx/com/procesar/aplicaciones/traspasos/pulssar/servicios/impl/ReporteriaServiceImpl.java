package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants.VACIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_FECHA_NACIMIENTO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_HORA_MIN_SEG;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_CATORCE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_CERO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_CINCO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_CUATRO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_DIECIOCHO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_DIECISEIS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_DIECISIETE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_DIEZ;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_DOCE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_DOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_NUEVE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_OCHO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_ONCE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_QUINCE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_SEIS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_SIETE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_TRECE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_TRES;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_UNO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_CITA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_CURP;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_CUS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_ESTATUS_CITA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_ESTATUS_TURNO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_FECHA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_FOLIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_HORA_FIN;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_HORA_INICIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_HORA_LLECADA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_NOMBRE_CARE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_NOMBRE_CLIENTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_NOMBRE_EJECUTIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_NUMERO_CARE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_SERVICIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_TIEMPO_ATENCION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_TIEMPO_ESPERA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_TRAMITES_REALIZADOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.CABECERA_TURNO_ASIGNADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_CURP;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_CUS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_ESTATUS_CITA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_ESTATUS_TURNO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_FIN_ATENCION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_FOLIO_ATENCION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_HORA_LLEGADA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_INDICADOR_CITA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_INI_ATENCION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_NOMBRE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_NOMBRE_USUARIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_NUM_SUC;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_SERVICIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_TRAMITES;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.POSICION_TURNO_ASIGNADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReporteriaConstants.TITULO_HOJA_REPORTERIA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RolesConstants.CLAVE_BANAMEX;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.ReporteriaDatosConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.SucursalAfore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.TurnoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteriaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteriaForm;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteriaInformacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementación para el servicio del modulo de reporteria
 * 
 * @author EHLUNARA
 *
 */
@Service
public class ReporteriaServiceImpl implements ReporteriaService {

	@Autowired
	private TurnoRepository turnoRepositorio;
	
	/**
	 * Utileria para el manejo de fechas.
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	/**
	 * Utileria para validar
	 */
	@Autowired
	private ValidadorUtils validador;
	
	
	/**
	 * Servicio de catalogos
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteriaService#consultarReporteria(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Reporteria)
	 */
	@Transactional
	public List<ReporteriaInformacion> consultarReporteria(
			ReporteriaForm form) {
		
		
		List<ReporteriaInformacion> infoReporteria= new ArrayList<>();
		if(!validador.validarObjetoNulo(form)){
		
			Map<String,String> mapaSucursales=obtenerMapaSucursales();
			
			
			ReporteriaDatosConsulta datosConsulta= parsearDatosConsulta(form);
			List<Object[]> resultado=   turnoRepositorio.obtenerReporte(datosConsulta);
			
			for(Object[] informacion:resultado){
				ReporteriaInformacion reporteria= new ReporteriaInformacion();
				
				String claveSucursal=obtenerCadena(informacion[POSICION_NUM_SUC]);
				
				reporteria.setFecha(validarFechaFormato(informacion[POSICION_HORA_LLEGADA],FORMATO_FECHA_NACIMIENTO ));
				reporteria.setCurpCliente(obtenerCadena(informacion[POSICION_CURP]));
				reporteria.setNombreCompleto(obtenerCadena(informacion[POSICION_NOMBRE]));
				reporteria.setIndicadorCita(obtenerCadena(informacion[POSICION_INDICADOR_CITA]));
				reporteria.setCus(obtenerCadena(informacion[POSICION_CUS]));
				reporteria.setEstatusCita(obtenerCadena(informacion[POSICION_ESTATUS_CITA]));
				reporteria.setTurnoAsignado(obtenerCadena(informacion[POSICION_TURNO_ASIGNADO]));
				reporteria.setEstatusTurno(obtenerCadena(informacion[POSICION_ESTATUS_TURNO]));
				reporteria.setServicioSolicitado(obtenerCadena(informacion[POSICION_SERVICIO]));
				reporteria.setHoraLlegada(validarFechaFormato(informacion[POSICION_HORA_LLEGADA],FORMATO_HORA_MIN_SEG));
				reporteria.setHoraInicioAtencion(validarFechaFormato(informacion[POSICION_INI_ATENCION],FORMATO_HORA_MIN_SEG));
				reporteria.setHoraFinAtencion(validarFechaFormato(informacion[POSICION_FIN_ATENCION], FORMATO_HORA_MIN_SEG));
				reporteria.setTiempoEspera(obtenerDiferenciaTiempo(informacion[POSICION_HORA_LLEGADA],informacion[POSICION_INI_ATENCION]));
				reporteria.setTiempoAtencion(obtenerDiferenciaTiempo(informacion[POSICION_INI_ATENCION],informacion[POSICION_FIN_ATENCION]));
				reporteria.setNombreUsuario(obtenerCadena(informacion[POSICION_NOMBRE_USUARIO]));
				reporteria.setNombreCareAsistio(mapaSucursales.get(claveSucursal)!=null?mapaSucursales.get(claveSucursal):VACIO);
				reporteria.setNumeroCare(claveSucursal);
				reporteria.setNumeroTramites(obtenerNumeroTramites(informacion[POSICION_TRAMITES]));
				reporteria.setFolioAtencion(obtenerCadena(informacion[POSICION_FOLIO_ATENCION]));
				
				
				
				infoReporteria.add(reporteria);
			}
		}
		
		
		return infoReporteria;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteriaService#generarReporteriaExcel(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteriaForm)
	 * @Author: Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Nov 19, 2019
	 */
	@Override
	public HSSFWorkbook generarReporteriaExcel(List<ReporteriaInformacion> listaReporteria) {
		//Metodo para la consulta
		List<ReporteriaInformacion> modelo = listaReporteria;

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(INT_CERO.intValue(), TITULO_HOJA_REPORTERIA);
		String [] headers = new String[]{
				CABECERA_FECHA,
				CABECERA_CURP,
				CABECERA_NOMBRE_CLIENTE,
				CABECERA_CITA,
				CABECERA_CUS,
				CABECERA_ESTATUS_CITA,
				CABECERA_TURNO_ASIGNADO,
				CABECERA_ESTATUS_TURNO, 
				CABECERA_SERVICIO,
				CABECERA_HORA_LLECADA,
				CABECERA_HORA_INICIO,
				CABECERA_HORA_FIN,
				CABECERA_TIEMPO_ESPERA,
				CABECERA_TIEMPO_ATENCION,
				CABECERA_NOMBRE_EJECUTIVO,
				CABECERA_NOMBRE_CARE,
				CABECERA_NUMERO_CARE,
				CABECERA_TRAMITES_REALIZADOS,
				CABECERA_FOLIO

		};
		
		CellStyle headerStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);
		headerStyle.setFont(font);
		
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		HSSFRow headerRow = sheet.createRow(INT_CERO.intValue());
		for (int i = INT_CERO.intValue(); i < headers.length; i++) {
			String header = headers[i];
			HSSFCell cell = headerRow.createCell(i);
			cell.setCellStyle(headerStyle);
			cell.setCellValue(header);
		}
		
		if(modelo!=null && !modelo.isEmpty()){
			int row_uno = INT_UNO.intValue();
			for (ReporteriaInformacion turno : modelo) {
				HSSFRow dataRow = sheet.createRow(row_uno);
				dataRow.createCell(INT_CERO.intValue()).setCellValue(turno.getFecha());
				dataRow.createCell(INT_UNO.intValue()).setCellValue(turno.getCurpCliente());
				dataRow.createCell(INT_DOS.intValue()).setCellValue(turno.getNombreCompleto());
				dataRow.createCell(INT_TRES.intValue()).setCellValue(turno.getIndicadorCita());
				dataRow.createCell(INT_CUATRO.intValue()).setCellValue(turno.getCus());
				dataRow.createCell(INT_CINCO.intValue()).setCellValue(turno.getEstatusCita());
				dataRow.createCell(INT_SEIS).setCellValue(turno.getTurnoAsignado());
				dataRow.createCell(INT_SIETE).setCellValue(turno.getEstatusTurno());
				dataRow.createCell(INT_OCHO).setCellValue(turno.getServicioSolicitado());
				dataRow.createCell(INT_NUEVE).setCellValue(turno.getHoraLlegada());
				dataRow.createCell(INT_DIEZ).setCellValue(turno.getHoraInicioAtencion());
				dataRow.createCell(INT_ONCE).setCellValue(turno.getHoraFinAtencion());
				dataRow.createCell(INT_DOCE).setCellValue(turno.getTiempoEspera());
				dataRow.createCell(INT_TRECE).setCellValue(turno.getTiempoAtencion());
				dataRow.createCell(INT_CATORCE).setCellValue(turno.getNombreUsuario());
				dataRow.createCell(INT_QUINCE).setCellValue(turno.getNombreCareAsistio());
				dataRow.createCell(INT_DIECISEIS).setCellValue(turno.getNumeroCare());
				dataRow.createCell(INT_DIECISIETE).setCellValue(turno.getNumeroTramites());
				dataRow.createCell(INT_DIECIOCHO).setCellValue(turno.getFolioAtencion());
				row_uno++;
			}
		}
		return workbook;
		
	}
	
	/**
	 * Metodo para pasar los datos de un modelo de servicio a un modelo de  persistencia
	 * @param reporteriaForm
	 * @return
	 * 
	 * @author EHLUNARA
	 */
	private ReporteriaDatosConsulta parsearDatosConsulta(ReporteriaForm reporteriaForm){
		ReporteriaDatosConsulta datos= new ReporteriaDatosConsulta();
		
		datos.setFechaInicio(fechaUtils.actualizarHoraInicio(reporteriaForm.getFechaInicio()));
		datos.setFechaFin(fechaUtils.actualizarHoraFinal(reporteriaForm.getFechaFin()));
		datos.setIndicadorCita(reporteriaForm.getTipoCliente());
		datos.setServicio(reporteriaForm.getServicio());
		datos.setNumeroSucursal(reporteriaForm.getNumeroSucursal()!=null?reporteriaForm.getNumeroSucursal():null);
		datos.setTipoReporte(reporteriaForm.getTipoReporte());
		
		return datos;
	}
	
	/**
	 * Metodo que valida que el objeto sea tipo de dato Date y regresa cadena dependiendo el formato
	 * @param objeto -Este objeto debe ser tipo fecha
	 * @param formato- formato de la fecha a retornar
	 * @return
	 */
	private String validarFechaFormato(Object objeto,String formato){
		String fechaTiempo=VACIO;
		if(objeto!=null){
			Date fecha= (Date)objeto;
			fechaTiempo = fechaUtils.convertirFechaACadena(fecha, formato);
		}
		return fechaTiempo;
	}
	
	/**
	 * Metodo para obtener el tiempo en HH:mm:ss
	 * @param fechaInicio - tiempo de inicio
	 * @param fechaFin    - tiempo de termino
	 * @return
	 */
	private String obtenerDiferenciaTiempo(Object fechaInicio,Object fechaFin){
		String resultado=VACIO;
		if(fechaInicio!=null && fechaFin!=null ){
			resultado=fechaUtils.obtenerDiferenciaTiempo((Date)fechaInicio,(Date)fechaFin);
		}
		
		return resultado;
	}
	
	
	
	/**
	 * Metodo para obtener el numero de tramites 
	 * @param objetoTramites -  ejemplo: [1,2,3]  
	 * @return
	 */
	private Integer obtenerNumeroTramites(Object objetoTramites){
		
		Integer resultado=0;
		
		if(objetoTramites!=null && objetoTramites instanceof String ){
			String tramites= (String)objetoTramites;
			String []tramitesArray= tramites.split(",");
			resultado=tramitesArray.length;
		}
		return resultado;
	}
	
	/**
	 * Metodo para obtener le nombre de la sucursal 
	 * @return
	 */
	private Map<String,String> obtenerMapaSucursales(){
		List<SucursalAfore> listaSucursales= new ArrayList<>();
		listaSucursales= servicioCatalogo.obtenerSucursales(CLAVE_BANAMEX);
		Map<String,String> mapaSucursales= new HashMap<>();
		
		if(!validador.validarListaVacia(listaSucursales)){
			for(SucursalAfore sucursal:listaSucursales){
				mapaSucursales.put(StringUtils.defaultString(sucursal.getClaveSucursal())
								  ,StringUtils.defaultString(sucursal.getNombreSucursal()));
			}	
		}
		
		return mapaSucursales;
	}
	
	/**
	 * Metodo para obtener una cadena a partir de un objeto
	 * @param objeto
	 * @return
	 */
	private String obtenerCadena(Object objeto){	
		return objeto!=null?String.valueOf(objeto):VACIO;
	}
	

}
