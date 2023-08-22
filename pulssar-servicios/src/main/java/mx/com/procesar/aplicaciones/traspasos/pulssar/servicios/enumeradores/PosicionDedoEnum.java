package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Archivo html para el envio de correo electronico
 * 
 * @author dbarbosa
 * @version 1.0
 */
public enum PosicionDedoEnum {
	
	/**
	 * dedo 1
	 */
	DEDO_1(1, "PULGAR DERECHO", "pulgar_derecho.png"),
	
	/**
	 * dedo 2
	 */
	DEDO_2(2, "ÍNDICE DERECHO", "indice_derecho.png"),
	
	/**
	 * dedo 3
	 */
	DEDO_3(3, "MEDIO DERECHO", "medio_derecho.png"),
	
	/**
	 * dedo 4
	 */
	DEDO_4(4, "ANULAR DERECHO", "anular_derecho.png"),
	
	/**
	 * dedo 5
	 */
	DEDO_5(5, "MEÑIQUE DERECHO", "menique_derecho.png"),
	
	/**
	 * dedo 6
	 */
	DEDO_6(6, "PULGAR IZQUIERDO", "pulgar_izquierdo.png"),
	
	/**
	 * dedo 7
	 */
	DEDO_7(7, "ÍNDICE IZQUIERDO", "indice_izquierdo.png"),
	
	/**
	 * dedo 8
	 */
	DEDO_8(8, "MEDIO IZQUIERDO", "medio_izquierdo.png"),
	
	/**
	 * dedo 9
	 */
	DEDO_9(9, "ANULAR IZQUIERDO", "anular_izquierdo.png"),
	
	/**
	 * dedo 10
	 */
	DEDO_10(10, "MEÑIQUE IZQUIERDO", "menique_izquierdo.png"),
	
	/**
	 * MANO DERECHA
	 */
	MANO_DERECHA(11, "MANO DERECHA", "mano_derecha.png"),
	
	/**
	 * MANO IZQUIERDA
	 */
	MANO_IZQUIERDA(12, "MANO IZQUIERDA", "mano_izquierda.png"),
	
	/**
	 * dedo error
	 */
	DEDO_0(0, "ERROR", "");

	/**
	 * Posicion dedo
	 */
	private final Integer dedo;
	
	/**
	 * Descripcion dedo
	 */
	private final String descripcion;
	
	/**
	 * imagen
	 */
	private final String imagen;

	/**
	 * Constructor
	 * 
	 * @param asunto
	 * @param nombreArchivo
	 */
	private PosicionDedoEnum(final Integer dedo, final String descripcion, final String imagen) {
		this.dedo = dedo;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}
	
	/**
	 * @param clave
	 */
	public static PosicionDedoEnum obtenerDedo(Integer dedo) {
		PosicionDedoEnum dedoBusqueda = PosicionDedoEnum.DEDO_0;
		
		for (PosicionDedoEnum e : PosicionDedoEnum.values()) {
			if (e.getDedo() == dedo) {
				dedoBusqueda = e;
			}
		}
		return dedoBusqueda;
	}
	
	/**
	 * @return the dedo
	 */
	public Integer getDedo() {
		return dedo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
}