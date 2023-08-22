package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Menu Reimpresion Enum
 * @author jmordone
 *
 */
public enum MenuReimpresionEnum {
	
	/**
	 * Consentimiento enrolamiento
	 */
	CONSENTIMENTO_ENROLAMIENTO(1,"Consentimiento Enrolamiento","CE"),
	
	/**
	 * Solciitud modificacion de datos
	 */
	SOLICITUD_MODIFICACION_DATOS(2,"Solicitud Modificación de Datos","MDD"),
	
	/**
	 * Permanencia
	 */
	PERMANENCIA(3,"Permanencia","P"),
	
	/**
	 * Saldos y movimientos
	 */
	SALDOS_MOVIMIENTOS(4,"Saldos y Movimientos","SM");
	
	/**
	 * Nombre del archivo
	 */
	private final Integer idMenuReimpresion;
	
	/**
	 * Descripcion
	 */
	private final String descripcion;
	
	/**
	 * Descripcion
	 */
	private final String claveDocumento;

	/**
	 * Constructor
	 * 
	 * @param asunto
	 * @param nombreArchivo
	 */
	private MenuReimpresionEnum(final Integer idMenuReimpresion,final String descripcion,final String claveDocumento) {
		this.idMenuReimpresion = idMenuReimpresion;
		this.descripcion = descripcion;
		this.claveDocumento=claveDocumento;
	}

	/**
	 * @return the idMenuReimpresion
	 */
	public Integer getIdMenuReimpresion() {
		return idMenuReimpresion;
	}
	
	
	
	/**
	 * @return the descripcio
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	

	/**
	 * @return the claveDocumento
	 */
	public String getClaveDocumento() {
		return claveDocumento;
	}

	/**
	 * @param clave
	 */
	public static MenuReimpresionEnum obtenerDescripcion(final Integer idMenu) {
		MenuReimpresionEnum regreso = null;
		for (final MenuReimpresionEnum e : MenuReimpresionEnum.values()) {
			if (e.getIdMenuReimpresion().equals(idMenu)) {
				regreso = e;
				break;
			}
		}
		return regreso;
	}
}