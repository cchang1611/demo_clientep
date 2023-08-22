package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.constantes.ReporteriaConstants.REPORTE_WEB;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.constantes.ReporteriaConstants.REPORTE_XLS;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteriaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteriaForm;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteriaInformacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.turnos.test.service.BaseTestCase;



/**
 * Clase de prueba para comprobar las operaciones para el servicio
 * {@link ReporteriaService}.
 * 
 * @author ERICK HECTOR LUNA RAMIREZ <EHLUNARA@inet.procesar.com.mx>
 */
public class ReporteriaServiceTestCase extends BaseTestCase {
	
	
	@Autowired
	private ReporteriaService reporteria;
	
	
	/**
	 * Test para obtener informacion para reporteria para la pagina web(datos limitados a n registros)
	 */
	@Test
	public void consultarReporteriaTestFilasLimitadas(){

		ReporteriaForm formulario = new ReporteriaForm();
		formulario.setFechaInicio(new Date());
		formulario.setFechaFin(new Date());
		formulario.setServicio(1);
		formulario.setTipoCliente("'FS','FC'");
		formulario.setNumeroSucursal(null);
		formulario.setTipoReporte(REPORTE_WEB);
		
		List<ReporteriaInformacion> listaInformacion= reporteria.consultarReporteria(formulario);
		
		assertNotNull(listaInformacion);
		
		
	}
	
	/**
	 * Test para obtener informacion para reporteria(reporte no limitado)
	 */
	@Test
	public void consultarReporteriaTestFilasNoLimitadas(){

		ReporteriaForm formulario = new ReporteriaForm();
		formulario.setFechaInicio(new Date());
		formulario.setFechaFin(new Date());
		formulario.setServicio(1);
		formulario.setTipoCliente("'FS','FC'");
		formulario.setNumeroSucursal(null);
		formulario.setTipoReporte(REPORTE_XLS);
		
		List<ReporteriaInformacion> listaInformacion= reporteria.consultarReporteria(formulario);
		
		assertNotNull(listaInformacion);
		
		
	}
	
	/**
	 *Test para consultar por sucursal vacia
	 */
	@Test
	public void consultarReporteriaTestSucursalVacio(){

		ReporteriaForm formulario = new ReporteriaForm();
		formulario.setFechaInicio(new Date());
		formulario.setFechaFin(new Date());
		formulario.setServicio(1);
		formulario.setTipoCliente("'FS','FC'");
		formulario.setNumeroSucursal("");
		formulario.setTipoReporte(REPORTE_XLS);
		
		List<ReporteriaInformacion> listaInformacion= reporteria.consultarReporteria(formulario);
		
		assertNotNull(listaInformacion);
		
		
	}
	
	
	
	
	/**
	 * Test para obtener información cuando se agrega el numero de sucursal(CARE)
	 */
	@Test
	public void consultarReporteriaTestConSuCursal(){

		ReporteriaForm formulario = new ReporteriaForm();
		formulario.setFechaInicio(new Date());
		formulario.setFechaFin(new Date());
		formulario.setServicio(1);
		formulario.setTipoCliente("'FS','FC'");
		formulario.setNumeroSucursal("1000000000000000");
		formulario.setTipoReporte(REPORTE_WEB);
		
		List<ReporteriaInformacion> listaInformacion= reporteria.consultarReporteria(formulario);
		
		
		
		assertNotNull(listaInformacion);
		
		
	}
	
	/**
	 * Test para verificar cuando se manda el objeto null la lista regresa vacia
	 */
	@Test
	public void consultarReporteriaTestNull(){
		ReporteriaForm formulario = null;
		List<ReporteriaInformacion> listaInformacion= reporteria.consultarReporteria(formulario);
		assertEquals(0, listaInformacion.size());
	}
	
	
	/**
	 * Test para generar el reporte en excel(happy path)
	 */
	@Test
	public void generarReporteriaExcelTest(){
		
		List<ReporteriaInformacion> listaInformacion=new ArrayList<>();
		
		ReporteriaInformacion reporte= new ReporteriaInformacion();
		reporte.setFecha("03/Noviembre/2019");
		reporte.setCurpCliente("TOAI870410HDFRNS00");
		reporte.setNombreCompleto("ERICK HECTOR LUNA RAMIREZ");
		reporte.setIndicadorCita("FS");
		reporte.setCus("30129400380000");
		reporte.setEstatusCita("Asistido");
		reporte.setTurnoAsignado("FS0001");
		reporte.setEstatusTurno("Atendido");
		reporte.setServicioSolicitado("Test Servicio Solicitado");
		reporte.setHoraLlegada("13:00:00");
		reporte.setHoraInicioAtencion("");
		reporte.setHoraFinAtencion("13:30:00");
		reporte.setTiempoEspera("");
		reporte.setTiempoAtencion("00:30:00");
		reporte.setNumeroEjecutivo(new BigDecimal(2122));
		reporte.setNombreCareAsistio("REFORMA");
		reporte.setNumeroCare("21313");
		reporte.setNumeroTramites(2);
		reporte.setFolioAtencion("S0000132201911210014");
		
		listaInformacion.add(reporte);
		
		HSSFWorkbook reporteExcel=reporteria.generarReporteriaExcel(listaInformacion);
		 
		 assertNotNull(reporteExcel);
		
		
	}
	
	/**
	 * Test para verificar el funcionamiento cuando se enevia una lista vacia 
	 */
	@Test
	public void generarReporteriaExcelTestListaVacia(){
		
		List<ReporteriaInformacion> listaInformacion=new ArrayList<>();
		HSSFWorkbook reporteExcel=reporteria.generarReporteriaExcel(listaInformacion);
		assertNotNull(reporteExcel);
		
	}
	
	/**
	 * Test para verificar el funcionamiento cuando se envia una lista null;
	 */
	@Test
	public void generarReporteriaExcelTestListaNull(){
		
		List<ReporteriaInformacion> listaInformacion=null;
		HSSFWorkbook reporteExcel=reporteria.generarReporteriaExcel(listaInformacion);
		assertNotNull(reporteExcel);
		
	}

}
