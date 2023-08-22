package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase encargada del objeto de expediente de identificacion
 * @author DBARBOSA
 *
 */
public class DatosIdenExpediente implements Serializable {
	
	/**
	 * serial number
	 */
	private static final long serialVersionUID = 5316201501251692845L;
	
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
	 * curp Solicitante
	 */
	private String curpSolicitante;
	
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
	 * @return the curpSolicitante
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}

	/**
	 * @param curpSolicitante the curpSolicitante to set
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosIdenExpediente [tipoSolicitante=");
		builder.append(tipoSolicitante);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", calle=");
		builder.append(calle);
		builder.append(", noExterior=");
		builder.append(noExterior);
		builder.append(", noInterior=");
		builder.append(noInterior);
		builder.append(", colonia=");
		builder.append(colonia);
		builder.append(", municipio=");
		builder.append(municipio);
		builder.append(", entidadFed=");
		builder.append(entidadFed);
		builder.append(", codigoPostal=");
		builder.append(codigoPostal);
		builder.append(", tipoAfiliacion=");
		builder.append(tipoAfiliacion);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append("]");
		return builder.toString();
	}

	
}