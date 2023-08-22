package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;
/**
 * Enumeracion TipoRetiroCoopelEnum
 *
 */
public enum TipoRetiroCoopelEnum {

	/**
	 * Retiro parcial por desempleo imss
	 */
	RETIRO_PARCIAL_POR_DESEMPLEO_IMSS("desempleo_imss","06"),
	
	/**
	 * Retiro parcial por desempleo issste
	 */
	RETIRO_PARCIAL_POR_DESEMPLEO_ISSSTE("desempleo_issste","07"),
	
	/**
	 * Retiro parcial por matrimonio imss
	 */
	
	RETIRO_PARCIAL_POR_MATRIMONIO_IMSS("matrimonio_imss","09");
	
	/**
	 * Strng clave
	 */
	private String nombreRetiro;
	
	
	/**
	 * Strng clave
	 */
	private String claveRetiro;
		
	/**
	 * @return the nombreRetiro
	 */
	public String getNombreRetiro() {
		return nombreRetiro;
	}
	/**
	 * @return the claveRetiro
	 */
	public String getClaveRetiro() {
		return claveRetiro;
	}

	/**
	 * @param nombreRetiro
	 * @param claveRetiro
	 */
	private TipoRetiroCoopelEnum(String nombreRetiro, String claveRetiro) {
		this.nombreRetiro = nombreRetiro;
		this.claveRetiro = claveRetiro;
	}
	/**
	 * @param clave
	 */
	public static TipoRetiroCoopelEnum obtenerClave(final String nombreRet) {
		TipoRetiroCoopelEnum regreso = null;
		for (final TipoRetiroCoopelEnum e : TipoRetiroCoopelEnum.values()) {
			if (e.getNombreRetiro().equals(nombreRet)) {
				regreso = e;
				break;
			}
		}
		return regreso;
	}
}
