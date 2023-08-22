package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Menu Reimpresion Enum
 * @author jmordone
 *
 */
public enum MenuReimpresionSaldosYMovimientosEnum {
	
	/**
	 * Resumen de saldos
	 */
	RESUMEN_SALDOS(1,"Resumen de saldos","01"),
	
	/**
	 * Estados de cuenta
	 */
	ESTADOS_DE_CUENTA(2,"Estados de cuenta","02"),
	
	/**
	 * Destalle del movimiento
	 */
	DETALLE_DE_MOVIMIENTO(3,"Detalle de movimiento","03");
	
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
	private final String tipoDocumento;

	/**
	 * Constructor
	 * 
	 * @param asunto
	 * @param nombreArchivo
	 */
	private MenuReimpresionSaldosYMovimientosEnum(final Integer idMenuReimpresion,final String descripcion,
			final String tipoDocumento) {
		this.idMenuReimpresion = idMenuReimpresion;
		this.descripcion = descripcion;
		this.tipoDocumento = tipoDocumento;
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
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param clave
	 */
	public static MenuReimpresionSaldosYMovimientosEnum obtenerDescripcion(final Integer idMenu) {
		MenuReimpresionSaldosYMovimientosEnum regreso = null;
		for (final MenuReimpresionSaldosYMovimientosEnum e : MenuReimpresionSaldosYMovimientosEnum.values()) {
			if (e.getIdMenuReimpresion().equals(idMenu)) {
				regreso = e;
				break;
			}
		}
		return regreso;
	}
}