package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Enumeraci�n que contiene los flujos existentes para la <b>Administraci�n de
 * Turnos</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public enum FlujoAdministracionTurnosEnum {

	/**
	 * Flujo exito del flujo.
	 */
	EXITOSO(1),
	
	/**
	 * Flujo para un error de negocio.
	 */
	ERROR_NEGOCIO(2),
	
	/**
	 * Flujo para la sesi�n caducada.
	 */
	SESION_CADUCADA(3),
	
	/**
	 * Flujo para un error inesperado.
	 */
	ERROR_INESPERADO(4),
	
	/**
	 * Flujo para un error inesperado con mensaje de error.
	 */
	ERROR_INESPERADO_MENSAJE(5),
	
	/**
	 * Flujo para un registro de Turno exitoso.
	 */
	EXITOSO_REGISTRO_TURNO(10);

	/**
	 * Determina la clave del flujo.
	 */
	private int clave;


	/**
	 * Constructor publico de la Enumeraci�n para los <b>Flujos de adnistraci�n
	 * de Turnos</b>.
	 */
	private FlujoAdministracionTurnosEnum(int clave) {
		
		this.clave = clave;
	}

	/**
	 * @return the clave
	 */
	public int getClave() {
		return clave;
	}

}
