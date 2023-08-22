package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

public class BanderaDatosModificadosDomicilios {

	/**
	 * Modificacion calle
	 */
	private boolean isModificadoCalle;
	
	/**
	 * Modificacion no exterior;
	 */
	private boolean isModificadoNoExterior;
	
	/**
	 * Modificacion no interior
	 */
	private boolean isModificadoNoInterior;
	
	/**
	 * Modificacion colonia
	 */
	private boolean isModificadoColonia;
	
	/**
	 * Modificacion municipio
	 */
	private boolean isModificadoMunicipio;
	
	/**
	 * Modificacion codigo postal
	 */
	private boolean isModificadoCodigoPostal;
	
	/**
	 * Modificacion entidad federativa
	 */
	private boolean isModificadoEntidadFederativa;
	
	/**
	 * Modificacion pais
	 */
	private boolean isModificadoPais;
	
	/**
	 * Modificacion telefono fijo
	 */
	private boolean isModificadoTelefonoFijo;
	
	/**
	 * Modificacion telefono celular
	 */
	private boolean isModificadoCelular;
	
	/**
	 * Modificacion correo electronico
	 */
	private boolean isModificadoCorreoElectronico;

	/**
	 * @return the isModificadoCalle
	 */
	public boolean isModificadoCalle() {
		return isModificadoCalle;
	}

	/**
	 * @param isModificadoCalle the isModificadoCalle to set
	 */
	public void setModificadoCalle(boolean isModificadoCalle) {
		this.isModificadoCalle = isModificadoCalle;
	}

	/**
	 * @return the isModificadoNoExterior
	 */
	public boolean isModificadoNoExterior() {
		return isModificadoNoExterior;
	}

	/**
	 * @param isModificadoNoExterior the isModificadoNoExterior to set
	 */
	public void setModificadoNoExterior(boolean isModificadoNoExterior) {
		this.isModificadoNoExterior = isModificadoNoExterior;
	}

	/**
	 * @return the isModificadoNoInterior
	 */
	public boolean isModificadoNoInterior() {
		return isModificadoNoInterior;
	}

	/**
	 * @param isModificadoNoInterior the isModificadoNoInterior to set
	 */
	public void setModificadoNoInterior(boolean isModificadoNoInterior) {
		this.isModificadoNoInterior = isModificadoNoInterior;
	}

	/**
	 * @return the isModificadoColonia
	 */
	public boolean isModificadoColonia() {
		return isModificadoColonia;
	}

	/**
	 * @param isModificadoColonia the isModificadoColonia to set
	 */
	public void setModificadoColonia(boolean isModificadoColonia) {
		this.isModificadoColonia = isModificadoColonia;
	}

	/**
	 * @return the isModificadoMunicipio
	 */
	public boolean isModificadoMunicipio() {
		return isModificadoMunicipio;
	}

	/**
	 * @param isModificadoMunicipio the isModificadoMunicipio to set
	 */
	public void setModificadoMunicipio(boolean isModificadoMunicipio) {
		this.isModificadoMunicipio = isModificadoMunicipio;
	}

	/**
	 * @return the isModificadoCodigoPostal
	 */
	public boolean isModificadoCodigoPostal() {
		return isModificadoCodigoPostal;
	}

	/**
	 * @param isModificadoCodigoPostal the isModificadoCodigoPostal to set
	 */
	public void setModificadoCodigoPostal(boolean isModificadoCodigoPostal) {
		this.isModificadoCodigoPostal = isModificadoCodigoPostal;
	}

	/**
	 * @return the isModificadoEntidadFederativa
	 */
	public boolean isModificadoEntidadFederativa() {
		return isModificadoEntidadFederativa;
	}

	/**
	 * @param isModificadoEntidadFederativa the isModificadoEntidadFederativa to set
	 */
	public void setModificadoEntidadFederativa(boolean isModificadoEntidadFederativa) {
		this.isModificadoEntidadFederativa = isModificadoEntidadFederativa;
	}

	/**
	 * @return the isModificadoPais
	 */
	public boolean isModificadoPais() {
		return isModificadoPais;
	}

	/**
	 * @param isModificadoPais the isModificadoPais to set
	 */
	public void setModificadoPais(boolean isModificadoPais) {
		this.isModificadoPais = isModificadoPais;
	}

	/**
	 * @return the isModificadoTelefonoFijo
	 */
	public boolean isModificadoTelefonoFijo() {
		return isModificadoTelefonoFijo;
	}

	/**
	 * @param isModificadoTelefonoFijo the isModificadoTelefonoFijo to set
	 */
	public void setModificadoTelefonoFijo(boolean isModificadoTelefonoFijo) {
		this.isModificadoTelefonoFijo = isModificadoTelefonoFijo;
	}

	/**
	 * @return the isModificadoCelular
	 */
	public boolean isModificadoCelular() {
		return isModificadoCelular;
	}

	/**
	 * @param isModificadoCelular the isModificadoCelular to set
	 */
	public void setModificadoCelular(boolean isModificadoCelular) {
		this.isModificadoCelular = isModificadoCelular;
	}

	/**
	 * @return the isModificadoCorreoElectronico
	 */
	public boolean isModificadoCorreoElectronico() {
		return isModificadoCorreoElectronico;
	}

	/**
	 * @param isModificadoCorreoElectronico the isModificadoCorreoElectronico to set
	 */
	public void setModificadoCorreoElectronico(boolean isModificadoCorreoElectronico) {
		this.isModificadoCorreoElectronico = isModificadoCorreoElectronico;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BanderaDatosModificadosDomicilios [isModificadoCalle=");
		builder.append(isModificadoCalle);
		builder.append(", isModificadoNoExterior=");
		builder.append(isModificadoNoExterior);
		builder.append(", isModificadoNoInterior=");
		builder.append(isModificadoNoInterior);
		builder.append(", isModificadoColonia=");
		builder.append(isModificadoColonia);
		builder.append(", isModificadoMunicipio=");
		builder.append(isModificadoMunicipio);
		builder.append(", isModificadoCodigoPostal=");
		builder.append(isModificadoCodigoPostal);
		builder.append(", isModificadoEntidadFederativa=");
		builder.append(isModificadoEntidadFederativa);
		builder.append(", isModificadoPais=");
		builder.append(isModificadoPais);
		builder.append(", isModificadoTelefonoFijo=");
		builder.append(isModificadoTelefonoFijo);
		builder.append(", isModificadoCelular=");
		builder.append(isModificadoCelular);
		builder.append(", isModificadoCorreoElectronico=");
		builder.append(isModificadoCorreoElectronico);
		builder.append("]");
		return builder.toString();
	}

	
	
}
