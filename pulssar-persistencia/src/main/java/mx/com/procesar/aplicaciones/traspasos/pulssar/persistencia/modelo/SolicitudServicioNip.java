/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;

/**
 * Transferencia de infromarción del negocio al servicio de generación de nip
 * @author MALOPEZT
 * @since 2022/02/04
 */
public class SolicitudServicioNip implements Serializable {

	/** Serial ID*/
	private static final long serialVersionUID = 37274860842676461L;

	/**Indicador de que el ahorrador autorizo la generación del NIP*/
	private String indicadorGeneracion;
	
	/** Clave de la Afore*/
	private String cveAfore;
	
	/** Origen de la petición 
	*	08 AFORE
	*	09 Plataforma de servicios
	*/
	private String idOrigen;
	
	/** Fecha y hora del envío de la información, en formato AAAAMMDD HHMMSS */
	private String fechaSolicitud;
	
	/** Clave Única de Registro de Población del Ahorrador */
	private String curpAhorrador;
	
	/** nss */
	private String nss;
	
	/** Correo electrónico*/
	private String correoElectronico;
	
	/** Teléfono celular */
	private String telefonoCelular;
	
	/** Sobrecarga toString */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ 'indicadorGeneracion' : '").append(indicadorGeneracion).append("',");
		sb.append("'cveAfore' : '").append(cveAfore).append("',");
		sb.append("'idOrigen' : '").append(idOrigen).append("',");
		sb.append("'fechaSolicitud' : '").append(fechaSolicitud).append("',");
		sb.append("'curpAhorrador' : '").append(curpAhorrador).append("',");
		sb.append("'nss' : '").append(nss).append("' ,");
		sb.append("'telefonoCelular' : '").append(telefonoCelular).append("',");
		sb.append("'correoElectronico' : '").append(correoElectronico).append("' }");
		return sb.toString();
	}

	/**
	 * @return the indicadorGeneracion
	 */
	public String getIndicadorGeneracion() {
		return indicadorGeneracion;
	}

	/**
	 * @param indicadorGeneracion the indicadorGeneracion to set
	 */
	public void setIndicadorGeneracion(String indicadorGeneracion) {
		this.indicadorGeneracion = indicadorGeneracion;
	}

	/**
	 * @return the cveAfore
	 */
	public String getCveAfore() {
		return cveAfore;
	}

	/**
	 * @param cveAfore the cveAfore to set
	 */
	public void setCveAfore(String cveAfore) {
		this.cveAfore = cveAfore;
	}

	/**
	 * @return the idOrigen
	 */
	public String getIdOrigen() {
		return idOrigen;
	}

	/**
	 * @param idOrigen the idOrigen to set
	 */
	public void setIdOrigen(String idOrigen) {
		this.idOrigen = idOrigen;
	}

	/**
	 * @return the fechaSolicitud
	 */
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return the curpAhorrador
	 */
	public String getCurpAhorrador() {
		return curpAhorrador;
	}

	/**
	 * @param curpAhorrador the curpAhorrador to set
	 */
	public void setCurpAhorrador(String curpAhorrador) {
		this.curpAhorrador = curpAhorrador;
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
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * @return the telefonoCelular
	 */
	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	/**
	 * @param telefonoCelular the telefonoCelular to set
	 */
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
}
