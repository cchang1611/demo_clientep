package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;

/**
 * interfaz servicio ValidaRegistroService para validar el registro de un
 * usuario
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public interface ValidarDatosService {

	/**
	 * Metodo encargado de validar los datos de
	 * para un registro de usuario 
	 * 
	 * @param datosRegistro
	 */
	void validarDatos(DatosRegistro datosRegistro, boolean isConfirmaCel);
	
	/**
	 * Metodo encargado de validar los datos de entrada para uso de codigo
	 * 
	 * @param datosRegistro
	 */
	void validarDatosActivar(DatosRegistro datosRegistro);
}
