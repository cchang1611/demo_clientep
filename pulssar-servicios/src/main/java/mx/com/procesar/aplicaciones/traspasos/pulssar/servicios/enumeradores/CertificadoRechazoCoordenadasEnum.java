package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

public enum CertificadoRechazoCoordenadasEnum {

	
	TEST("test", 0, 0),
	NOMBRE("nombre", 510, 430),
	APELLIDO_PAT("apellidoPaterno", 120, 430),
	APELLIDO_MAT("apellidoMaterno", 330, 430),
	FOLIO("folio", 555, 535),
	NSS("nss", 150, 367),
	CURP("curp", 480, 367),
	NOMBRE_COMPLETO("nombreCompleto", 330, 140),
	DIA_MES("diaMes", 570, 497),
	MES("mes", 600, 497),
	ANIO("anio", 630, 497),
	NOMBRE_FUNCIONARIO("nombreFuncionario", 80, 140)
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
	private CertificadoRechazoCoordenadasEnum(String nombre, int x, int y) {
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
	
	public static CertificadoRechazoCoordenadasEnum obtenCoordenadas(String clave) {
		CertificadoRechazoCoordenadasEnum regreso = TEST;
        
        for (CertificadoRechazoCoordenadasEnum e : CertificadoRechazoCoordenadasEnum.values()) {
        	if (e.getNombre().equals(clave)) {
                regreso = e;
            }
        }
        
        return regreso;
	}

	
}
