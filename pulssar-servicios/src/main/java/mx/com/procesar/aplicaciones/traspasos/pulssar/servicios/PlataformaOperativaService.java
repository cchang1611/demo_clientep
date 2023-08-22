package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosConsultaPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaJson;

/**
 * Interfaz que define los metodos del servicio de consulta de reportes y solicitudes
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Mayo 2021
 */
public interface PlataformaOperativaService {

    /**
     * Metodo que obtiene la informacion requerida para el llenado de reportes normales
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     * @param usuarioLogueado Usuario que inicio sesion en el portal
     * @param nombreReporte nombre del reporte que se desea generar
     * @param fechaInicio Rango inferior de la consulta
     * @param fechaFin Rango superior de la consulta
     * @param nss nss de la consulta
     * @param curp curp utilizada como filtro para la consulra
     * @param idProcesar Identificador del trabajador
     * @return Objeto con los datos obtenidos al ejecutar el reporte con los datos recibidos
     */
	ResponseEntity<RespuestaJson> consultaReporte(String usuarioLogueado, String nombreReporte, String fechaInicio, String fechaFin, String nss, String curp, String idProcesar);

    /**
     * Metodo que retorna un objeto que contiene los datos de un reporte en formato Jasper
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     * @param params Objeto que contiene los datos a consultar
     * @return Objeto con los datos obtenidos al ejecutar el reporte con los datos recibidos
     */
	ResponseEntity<RespuestaJson> consultaReporteJasper(Map<String,String> params);

    /**
     * Metodo que consulta un reporte masivo
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     * @param usuarioLogueado Usuario que inicio sesion en el portal
     * @param datosConsultaMasiva Objeto con los datos de la consulta
     * @return Objeto con los datos obtenidos al ejecutar el reporte con los datos recibidos
     */
	ResponseEntity<RespuestaJson> consultaMasivos(String usuarioLogueado, DatosConsultaPlataformaServicios datosConsultaMasiva);

    /**
     * Metodo que realiza la consulta de solicitudes de generacion de reportes
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     * @param areas Area del reporte
     * @param numSolicitudSel Numero de solicitud
     * @param idEstado Estado de la solicitud
     * @param fechaInicio Rango inferior de la consulta
     * @param fechaFin Rango superior de la consulta
     * @return Objeto con los datos obtenidos al ejecutar el reporte con los datos recibidos
     */
	ResponseEntity<RespuestaJson> consultaSolicitud(String areas, String numSolicitudSel, String idEstado, String fechaInicio, String fechaFin);
}	
 