package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosJasper;
import net.sf.jasperreports.engine.JRException;

/**
 * Servicio para la creacion del archivo
 * jasper
 * 
 */
public interface JasperUtils {

	/**
	 * Metodo encargado de generar el archivo pdf desde un archvio jasper
	 * 
	 * @param datos
	 * @param afore
	 * @return
	 * @throws JRException
	 */
	byte[] generarArchivoJasper(DatosJasper datos, String afore);
}
