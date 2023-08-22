package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.NodeList;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujosEntrada;

/**
 * 
 * Interfaz Codigo para la generacion de codigos y contrasenias
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public interface CodigoUtils {
	
	/**
	 * Metodo encargado de generar un folio
	 * 
	 * @return
	 */
	String generarFolioServicio();
	
	/**
	 * Metodo encargado de generar un codigo de activacion
	 * 
	 * @return
	 */
	String generarCodigoActivacion();
	
	/**
	 * Metodo encargado de reconstruir la contrasenia a enviar
	 * 
	 * @param cadena
	 * @return
	 */
	public String generarContrasenia();
	
	 /**
	    * Metodo que transforma una lista de nodos xml en una cadena
	    * 
	     * @autor Ricardo Y. Ceron Romero (ryoceron@inet.procesar.com.mx)
	    * @param nl
	    * @return
	    * @throws TransformerFactoryConfigurationError
	    * @throws TransformerException
	    */
	String generarCadenaError(NodeList nl);
	
	/**
	 * Vacio
	 * 
	 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 * @param value
	 * @return
	 */
	boolean esVacio(Object value);
	
	/**
	 * @param cadena
	 * @return
	 */
	String obtenerCadena(Object cadena);
	
	/**
	 * @param objeto
	 * @return
	 */
	boolean validarObjeto(Object objeto);
	
	/**
	 * Genera Xml de Constancia
	 * 
	 * @author María Elena Domínguez Domínguez (medoming@procesar.com)
	 * @param entrada
	 * @return
	 */
	String generaXmlEntrada(FlujosEntrada entrada);
}