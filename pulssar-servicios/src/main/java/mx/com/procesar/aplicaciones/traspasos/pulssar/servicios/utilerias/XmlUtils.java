/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import javax.xml.bind.JAXBException;

/**
 * Utileria para el manejo de xml
 * @author dhernand
 *
 */
public interface XmlUtils {

	/**
	 * Convierte un objeto a xml
	 * @param obj
	 * @return
	 * @throws JAXBException
	 */
	String convertirObjetoXml(Object obj) throws JAXBException;

}
