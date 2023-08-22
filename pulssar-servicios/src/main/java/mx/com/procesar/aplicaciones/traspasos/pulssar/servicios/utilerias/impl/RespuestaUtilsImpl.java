package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import org.springframework.stereotype.Component;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RespuestaUtils;

/**
 * Componente de utileria de respuesta
 * 
 * @author mahernan
 * @version 1.0
 */
@Component
public class RespuestaUtilsImpl implements RespuestaUtils {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Respuesta obtenerRespuesta(Integer flujo, String titulo, String mensaje){
		Respuesta respuesta = new Respuesta();
		respuesta.setFlujo(flujo);
		respuesta.setTitulo(titulo);
		respuesta.setMensaje(mensaje);
		return respuesta;
	}
}