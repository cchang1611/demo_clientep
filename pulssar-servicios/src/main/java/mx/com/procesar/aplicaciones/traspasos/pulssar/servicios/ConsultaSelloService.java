package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SelloVirtualEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.VerificacionSello;

public interface ConsultaSelloService {
	
	/**
	 * Obtener Sello Trabajador
	 * @param curpEmpleado
	 * @param curpTrabajador
	 * @param claveAfore
	 * @return
	 */
	Sello obtenerSelloTrabajador(String curpEmpleado, String curpTrabajador, String claveAfore);
	
	/**
	 * Obtener Sello Empleado
	 * @param curpEmpleado
	 * @param claveAfore
	 * @return
	 */
	Sello obtenerSelloEmpleado(String curpEmpleado, String claveAfore);

	
	/**
	 *  guardarSello
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param sello
	 *  @return
	 */
	void guardarSello(Long sello, String proceso);
	
	/**
	 * Metodo que consulta sello para seguir flujo de modificacion de datos
	 * @param curpEmpleado
	 * @param curpTrabajador
	 * @param claveAfore
	 * @return
	 */
	VerificacionSello consultarSelloFlujoModificacion(String curpEmpleado, String curpTrabajador, String claveAfore);
	
	/***
	 * Metodo que genera sello virtual
	 * @param entrada
	 * @return
	 */
	SalidaGenerica generarSelloVirtual(SelloVirtualEntrada entrada);
	
	/**
	 * Servicio encargado de actualizar el sello a utilizado
	 * @param agente
	 * @param idSello
	 */
	void actualizarSelloProspecto(String agente, Long idSello);
}
