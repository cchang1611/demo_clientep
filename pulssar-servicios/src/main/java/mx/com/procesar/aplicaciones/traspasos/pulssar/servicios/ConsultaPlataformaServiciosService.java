package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExcelPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaFoliosConsultaOperativa;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;



/**
 * Consulta plataforma servicios
 * @author RARREOLA
 *
 */
public interface ConsultaPlataformaServiciosService {
	
	
	/**
	 * Folios consulta operativa
	 * @param entrada
	 * @return
	 */
	List<SalidaFoliosConsultaOperativa> foliosConsultaOperativa(EntradaPlataformaServicios consulta, String claveServicio, String datoServicio);
	

	
	
	/**
	 * Seteo de informacion
	 * @param listas
	 * @return
	 */
	List<DatosExcelPlataformaServicios> seteoInformacion(List<SalidaFoliosConsultaOperativa> listas);
	
	
	
	/**
	 * Generar el nombre del excel
	 * @return
	 */
	String generarNombreExcel();
	
	
	
	
	/** metodo para  generar el JasperPrint en base a un stream
	 *  (gramirez@procesar.com)
	 *  @param bs
	 *  @param parametros
	 *  @param stream
	 *  @return
	 *  @throws JRException
	 */
	JasperPrint generarReporteStream(byte[] bs, Map<String,Object> parametros, InputStream stream) throws JRException;
	
	
	
	/** exportar un JasperReports hacia un  CSV 
	 * (gramirez@procesar.com)
	 *  @param jasperPrint
	 *  @param output
	 *  @return
	 *  @throws JRException
	 */
	byte[] exportarAExcel(JasperPrint jasperPrint, ByteArrayOutputStream output) throws JRException;
	
	
	
	/**
	 * Quitar afore sici
	 * @param lAfores
	 * @return
	 */
	List<Combo> removerAforeSici(List<Combo> lAfores);

}
