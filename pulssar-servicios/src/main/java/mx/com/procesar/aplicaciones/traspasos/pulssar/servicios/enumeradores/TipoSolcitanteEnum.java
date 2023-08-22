package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * TipoSolcitante Enum
 * @author jmordone
 *
 */
public enum TipoSolcitanteEnum {
	
	/**
	 * TITULAR_MODIFICADOR_DATOS
	 */
	TITULAR_MODIFICADOR_DATOS("01","Modificación de datos","46"),
	
	/**
	 * BENEFICIARIO_MODIFICADOR_DATOS
	 */
	BENEFICIARIO_MODIFICADOR_DATOS("02","Modificación de datos del beneficiario ","47");
	
	/**
	 * idClaveSolicitante
	 */
	private final String idClaveSolicitante;
	
	/**
	 *descripcionTipoProceso
	 */
	private final String descripcionTipoProceso;
	
	/**
	 * claveTipoProceso
	 */
	private final String claveTipoProceso;

	/**
	 * Constructor
	 * 
	 * @param asunto
	 * @param nombreArchivo
	 */
	private TipoSolcitanteEnum(final String idClaveSolicitante,final String descripcionTipoProceso,final String claveTipoProceso) {
		this.idClaveSolicitante = idClaveSolicitante;
		this.descripcionTipoProceso = descripcionTipoProceso;
		this.claveTipoProceso=claveTipoProceso;
	}

	

	/**
	 * @return the idClaveSolicitante
	 */
	public String getIdClaveSolicitante() {
		return idClaveSolicitante;
	}



	/**
	 * @return the descripcionTipoProceso
	 */
	public String getDescripcionTipoProceso() {
		return descripcionTipoProceso;
	}



	/**
	 * @return the claveTipoProceso
	 */
	public String getClaveTipoProceso() {
		return claveTipoProceso;
	}



	/**
	 * @param clave
	 */
	public static TipoSolcitanteEnum obtenerTipoSolicitante(final String idClaveSolicitante) {
		TipoSolcitanteEnum regreso = null;
		for (final TipoSolcitanteEnum e : TipoSolcitanteEnum.values()) {
			if (e.getIdClaveSolicitante().equals(idClaveSolicitante)) {
				regreso = e;
				break;
			}
		}
		return regreso;
	}
}