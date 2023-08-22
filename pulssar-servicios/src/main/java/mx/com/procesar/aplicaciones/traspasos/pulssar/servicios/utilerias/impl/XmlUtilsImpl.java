/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.XmlUtils;

/**
 * Clase de utilerias para XML
 * @author dhernand
 *
 */
@Component
public class XmlUtilsImpl implements XmlUtils{
	
	/**
	 * Revisar la interface 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.XmlUtils#convertirObjetoXml(java.lang.Object)
	 */
	@Override
	public String convertirObjetoXml(Object obj) throws JAXBException {
		// Create JAXB Context
		JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());

		// Create Marshaller
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// Required formatting??
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Print XML String to Console
		StringWriter sw = new StringWriter();

		// Write XML to StringWriter
		jaxbMarshaller.marshal(obj, sw);

		// Verify XML Content
		return sw.toString();
	 
	}

}
