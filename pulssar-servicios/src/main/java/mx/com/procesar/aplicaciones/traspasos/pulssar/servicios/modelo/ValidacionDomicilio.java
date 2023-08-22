/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author jcgarces
 *
 */
public class ValidacionDomicilio implements Serializable{
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7809658250227802096L;

	/**
	 * ID de la entidad
	 */
	private Long id;

	
	/**
	 * ID de la recepción del expediente
	 */
	private ArchivoRecibido archivoRecibido;

	/**
	 * Codigo de estatus
	 */
	private String codigoRespuesta;
	
	/**
	 * similitud domicilio
	 */
	private BigDecimal similitudDomicilio;
	
	/**
	 * entidad federativa
	 */
	private String entidadFederativa;
	
	/**
	 * cp
	 */
	private String cp;
	
	/**
	 * municipio
	 */
	private String municipio;
	
	/**
	 * Numero Exterior
	 */
	private String numeroExterior;
	
	/**
	 * Calle
	 */
	private String calle;
	
	/**
	 * Consistencia Procesar
	 */
	private String consistenciaProcesar;
	
	/**
	 * Consistencia Comprobante
	 */
	private String consistenciaComprobante;
	
	
	/**
	 * fecha de control
	 */
	private List<String> fechaControl;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the archivoRecibido
	 */
	public ArchivoRecibido getArchivoRecibido() {		
		return archivoRecibido;
	}

	/**
	 * @param archivoRecibido the archivoRecibido to set
	 */
	public void setArchivoRecibido(ArchivoRecibido archivoRecibido) {
		this.archivoRecibido = archivoRecibido;
	}

	/**
	 * @return the codigoRespuesta
	 */
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	/**
	 * @param codigoRespuesta the codigoRespuesta to set
	 */
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	/**
	 * @return the similitudDomicilio
	 */
	public BigDecimal getSimilitudDomicilio() {
		return similitudDomicilio;
	}

	/**
	 * @param similitudDomicilio the similitudDomicilio to set
	 */
	public void setSimilitudDomicilio(BigDecimal similitudDomicilio) {
		this.similitudDomicilio = similitudDomicilio;
	}

	/**
	 * @return the entidadFederativa
	 */
	public String getEntidadFederativa() {
		return entidadFederativa;
	}

	/**
	 * @param entidadFederativa the entidadFederativa to set
	 */
	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
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
	 * @return the numeroExterior
	 */
	public String getNumeroExterior() {
		return numeroExterior;
	}

	/**
	 * @param numeroExterior the numeroExterior to set
	 */
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
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
	 * @return the consistenciaProcesar
	 */
	public String getConsistenciaProcesar() {
		return consistenciaProcesar;
	}

	/**
	 * @param consistenciaProcesar the consistenciaProcesar to set
	 */
	public void setConsistenciaProcesar(String consistenciaProcesar) {
		this.consistenciaProcesar = consistenciaProcesar;
	}

	/**
	 * @return the consistenciaComprobante
	 */
	public String getConsistenciaComprobante() {
		return consistenciaComprobante;
	}

	/**
	 * @param consistenciaComprobante the consistenciaComprobante to set
	 */
	public void setConsistenciaComprobante(String consistenciaComprobante) {
		this.consistenciaComprobante = consistenciaComprobante;
	}

	/**
	 * @return the fechaControl
	 */
	public List<String> getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(List<String> fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValidacionDomicilio [id=");
		builder.append(id);
		builder.append(", archivoRecibido=");
		builder.append(archivoRecibido);
		builder.append(", codigoRespuesta=");
		builder.append(codigoRespuesta);
		builder.append(", similitudDomicilio=");
		builder.append(similitudDomicilio);
		builder.append(", entidadFederativa=");
		builder.append(entidadFederativa);
		builder.append(", cp=");
		builder.append(cp);
		builder.append(", municipio=");
		builder.append(municipio);
		builder.append(", numeroExterior=");
		builder.append(numeroExterior);
		builder.append(", calle=");
		builder.append(calle);
		builder.append(", consistenciaProcesar=");
		builder.append(consistenciaProcesar);
		builder.append(", consistenciaComprobante=");
		builder.append(consistenciaComprobante);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}
