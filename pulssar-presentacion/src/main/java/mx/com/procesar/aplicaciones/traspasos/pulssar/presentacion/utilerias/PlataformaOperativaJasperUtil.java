package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias;

import java.io.BufferedOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaPdfPlataformaOperativa;
import net.sf.jasperreports.engine.JRException;

/**
 * Clase de utilería para la generación de Exceles con Plantillas Jasper
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 27/07/2020
 */
public interface PlataformaOperativaJasperUtil {

    /**
     * Utileria que realiza la carga de la plantilla
     * @author Arturo Eduardo de la Cruz Perez
     * @param request
     * @param output
     * @param respuestaPdfPlataformaOperativa
     * @param nombreReporte
     * @param outputStream
     * @throws JRException
     */
    void generaReporteConPlatilla(HttpServletRequest request, BufferedOutputStream output,
        RespuestaPdfPlataformaOperativa respuestaPdfPlataformaOperativa, String nombreReporte, ServletOutputStream outputStream)
        throws JRException;

}
