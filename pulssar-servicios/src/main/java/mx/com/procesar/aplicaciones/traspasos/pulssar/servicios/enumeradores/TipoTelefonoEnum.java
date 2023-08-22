package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

public enum TipoTelefonoEnum {
	/**
	 * tipo telefono personal
	 */
	CELULAR("01"),
	/**
	 * tipo telefono casa
	 */
	TELEFONO_CASA("02"),
	/**
	 * tipo telefono trabajo
	 */
	TELEFONO_TRABAJO("03");
	
	String tipoTelefono;
	
	private TipoTelefonoEnum(final String tipoTelefono) {
		// TODO Auto-generated constructor stub
		this.tipoTelefono = tipoTelefono;
	}

	public String getTipoTelefono() {
		return tipoTelefono;
	}
}