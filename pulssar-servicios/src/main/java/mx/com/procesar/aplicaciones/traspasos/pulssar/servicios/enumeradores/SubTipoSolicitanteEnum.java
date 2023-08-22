package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Subtipo solicitante enum
 * @author jmordone
 *
 */
public enum SubTipoSolicitanteEnum {
	
	/**
	 * Resumen de saldos
	 */
	MODIFICADOR_DATOS(2,"Modificador de Datos","13"),
	
	/**
	 * Estados de cuenta
	 */
	PERMANENCIA(3,"Permanencia","17");
	
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
	private final String claveSubTipoSolicitante;
	

	/**
	 * Constructor
	 * 
	 * @param asunto
	 * @param nombreArchivo
	 */
	private SubTipoSolicitanteEnum(final Integer idMenuReimpresion,final String descripcion, final String claveSubTipoSolicitante) {
		this.idMenuReimpresion = idMenuReimpresion;
		this.descripcion = descripcion;
		this.claveSubTipoSolicitante=claveSubTipoSolicitante;
	}


	/**
	 * @return the idMenuReimpresion
	 */
	public Integer getIdMenuReimpresion() {
		return idMenuReimpresion;
	}


	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @return the claveSubTipoSolicitante
	 */
	public String getClaveSubTipoSolicitante() {
		return claveSubTipoSolicitante;
	}


	
}