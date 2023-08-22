/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.xml.bind.JAXBException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DigitalizacionCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHuellasCoppel;

/**
 * Servicion Coppel
 * @author dhernand
 *
 */
public interface CoppelService {

	
	/**
	 * Genera peticion padFirma	
	 * @return
	 */
	LinkedHashMap<String,String> generarPeticionPadFirma();
	/**
	 *  generar Peticion Digitalizacion
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @return digitalizacionCoppel
	 */
	LinkedHashMap<String,String> generarPeticionDigitalizacion(DigitalizacionCoppel digitalizacionCoppel, String origen);
	
	/**
	 * Metodo encargado de validar los datos obligatorios para la consulta 
	 * 
	 * @param usuario
	 * @param curp
	 * @param nss
	 * @param tipoSolicitante
	 * @param timePicker
	 */
	void validarDatosObligatoriosConsulta(String usuario, String curp, String nss, String tipoSolicitante, String timePicker);
	
	/**
	 * Metodo encargado de validar los datos de la curp solicitante
	 * 
	 * @param tipoSolicitante
	 * @param curpSolicitante
	 * @param nombre
	 * @param apellidoPaterno
	 * @param apellidoMaterno
	 * @return
	 */
	EntradaConsulta validarDatosCurpSolicitante(String tipoSolicitante, String curpSolicitante, String nombre, String apellidoPaterno, String apellidoMaterno);
	
	/**
	 * Metodo encargado de guardar las huella Coppel
	 * 
	 * @param curp
	 * @param huellas
	 * @param tipoPersona
	 * @throws JAXBException, IOException
	 * @return
	 */
	String guadarHuellasCoppel(String curp, RespuestaHuellasCoppel huellas, String tipoPersona, String clave) throws JAXBException, IOException;
	
	/**
	 * Metodo encargado de validar los datos obligatorios para la consulta 
	 * 
	 * @param idSesion
	 * @param direccionUrl
	 * @param numTienda
	 */
	void validarDatosObligatoriosCoppel(String idSesion, String direccionUrl, String numTienda);
}
