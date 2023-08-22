package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

public class DatosExpedienteGenerico {

	
	/**
	 * curp
	 */
	private String tipoSolicitante;

	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * Nss
	 */
	private String nss;
	
	/**
	 * nombre
	 */
	private String nombre;
	
	/**
	 * apellido paterno
	 */
	private String apellidoPaterno;
	
	/**
	 * apellido materno
	 */
	private String apellidoMaterno;
	
	/**
	 * calle
	 */
	private String calle;
	
	/**
	 * no exterior
	 */
	private String noExterior;
	
	/**
	 * no interior
	 */
	private String noInterior;
	
	/**
	 * colonia
	 */
	private String colonia;
	
	/**
	 * municipio
	 */
	private String municipio;
	
	/**
	 * entidad federativa
	 */
	private String entidadFed;
	
	/**
	 * codigo postal
	 */
	private String codigoPostal;
	
	/**
	 * afiliacion
	 */
	private String tipoAfiliacion;
	
	/**
	 * @return the tipoSolicitante
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	/**
	 * @param tipoSolicitante the tipoSolicitante to set
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return the noExterior
	 */
	public String getNoExterior() {
		return noExterior;
	}

	/**
	 * @param noExterior the noExterior to set
	 */
	public void setNoExterior(String noExterior) {
		this.noExterior = noExterior;
	}

	/**
	 * @return the noInterior
	 */
	public String getNoInterior() {
		return noInterior;
	}

	/**
	 * @param noInterior the noInterior to set
	 */
	public void setNoInterior(String noInterior) {
		this.noInterior = noInterior;
	}

	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the entidadFed
	 */
	public String getEntidadFed() {
		return entidadFed;
	}

	/**
	 * @param entidadFed the entidadFed to set
	 */
	public void setEntidadFed(String entidadFed) {
		this.entidadFed = entidadFed;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the tipoAfiliacion
	 */
	public String getTipoAfiliacion() {
		return tipoAfiliacion;
	}

	/**
	 * @param tipoAfiliacion the tipoAfiliacion to set
	 */
	public void setTipoAfiliacion(String tipoAfiliacion) {
		this.tipoAfiliacion = tipoAfiliacion;
	}

	/**
	 * to string
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("DatosExpediente [");
		cadena.append("tipoSolicitante =");
		cadena.append(tipoSolicitante);
		cadena.append("curp =");
		cadena.append(curp);
		cadena.append("nss =");
		cadena.append(nss);
		cadena.append("nombre =");
		cadena.append(nombre);
		cadena.append("apellidoPaterno =");
		cadena.append(apellidoPaterno);
		cadena.append("apellidoMaterno =");
		cadena.append(apellidoMaterno);
		cadena.append("calle =");
		cadena.append(calle);
		cadena.append("noExterior =");
		cadena.append(noExterior);
		cadena.append("noInterior =");
		cadena.append(noInterior);
		cadena.append("colonia =");
		cadena.append(colonia);
		cadena.append("municipio =");
		cadena.append(municipio);
		cadena.append("entidadFed =");
		cadena.append(entidadFed);
		cadena.append("codigoPostal =");
		cadena.append(codigoPostal);
		cadena.append("tipoAfiliacion =");
		cadena.append(tipoAfiliacion);
		cadena.append("]");
		
		return cadena.toString();
	}
}
