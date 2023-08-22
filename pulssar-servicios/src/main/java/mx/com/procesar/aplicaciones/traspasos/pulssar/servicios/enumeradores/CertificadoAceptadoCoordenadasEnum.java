package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;
public enum CertificadoAceptadoCoordenadasEnum {

	
	TEST("test", 0, 0),
	NOMBRE("nombre", 510, 412),
	APELLIDO_PAT("apellidoPaterno", 150, 412),
	APELLIDO_MAT("apellidoMaterno", 330, 412),
	FOLIO("folio", 600, 554),
	NSS("nss", 150, 346),
	CURP("curp", 480, 346),
	NOMBRE_COMPLETO("nombreCompleto", 320, 97),
	
	NUM_RESOLUCION("numResolucion", 320, 97),
	FECHA_INICIO("fechaInicio", 320, 97),
	FECHA_FIN("fechaFin", 320, 97),
	INCISO("inciso", 320, 97),
	;
	
	
	/**
	 * Clave
	 */
	private String nombre;
	/**
	 * Valor
	 */
	private int x;
	
	private int y;

	/**
	 * @param tipo
	 * @param nombre
	 * @param x
	 * @param y
	 */
	private CertificadoAceptadoCoordenadasEnum(String nombre, int x, int y) {
		this.nombre = nombre;
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	public static CertificadoAceptadoCoordenadasEnum obtenCoordenadas(String clave) {
		CertificadoAceptadoCoordenadasEnum regreso = TEST;
        
        for (CertificadoAceptadoCoordenadasEnum e : CertificadoAceptadoCoordenadasEnum.values()) {
        	if (e.getNombre().equals(clave)) {
                regreso = e;
            }
        }
        
        return regreso;
	}

	
}
