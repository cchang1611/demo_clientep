package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Expediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellasDactilares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Interfaz para el proceso de huellas
 * @author DBARBOSA
 */
public interface HuellasService {
	
	/**
	 * Metodo encargado de enviar las huellas a recepcion de arhivos de manera asincrona
	 * 
	 * @param user
	 * @param folioHijo
	 * @param flagsExpediente
	 * @param curp
	 * @param clave
	 * @param huellas
	 */
	void procesarHuellasRecibidas(UsuarioLogin user, Folio folioHijo, Expediente flagsExpediente, String curp, String clave, HuellasDactilares huellas);
	
	/**
	 * Metodo encargado de validar la respuesta del folio
	 * 
	 * @param folio
	 */
	RespuestaServicio validarRespuestaFolio(String folio);
	
	/**
	 * Metodo encargado de guardar las huellas
	 * 
	 * @param cadenaHuellas
	 */
	void guardarHuellaIE(String cadenaHuellas);
	
	/**
	 * Obtiene la ruta donde se guardo el archivo zip
	 * 
	 * @param folioCurp
	 * @return
	 */
	String validarRespuestaHuellas(String folioCurp);
}
