/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * documentos aceptados en el expediente
 * @author jcgarces
 *
 */
public class DocumentoExpediente implements Serializable {
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = 8185194083459303524L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * numero de documentos
	 */
	private String numeroProceso;
	
	/**
	 * nombre documento
	 */
	private String nombreDocumento;
	
	/**
	 * tipo Documento
	 */
	private String tipoDocumento;
	
	/**
	 * clave d ediagnostico
	 */
	private String diagnostico;

	/**
	 * Clave de la afore
	 */
	private Integer estatus;
	
	/**
	 * respuesta del expediente
	 */
	private RespuestaExpedienteDetalle expediente;
	
	/**
	 * fecha de control
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaControl;
	
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
	 * @return the numeroProceso
	 */
	public String getNumeroProceso() {
		return numeroProceso;
	}

	/**
	 * @param numeroProceso the numeroProceso to set
	 */
	public void setNumeroProceso(String numeroProceso) {
		this.numeroProceso = numeroProceso;
	}

	/**
	 * @return the nombreDocumento
	 */
	public String getNombreDocumento() {
		return nombreDocumento;
	}

	/**
	 * @param nombreDocumento the nombreDocumento to set
	 */
	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the expediente
	 */
	public RespuestaExpedienteDetalle getExpediente() {
		return expediente;
	}

	/**
	 * @param expediente the expediente to set
	 */
	public void setExpediente(RespuestaExpedienteDetalle expediente) {
		this.expediente = expediente;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
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
		builder.append("DocumentoExpediente [id=");
		builder.append(id);
		builder.append(", numeroProceso=");
		builder.append(numeroProceso);
		builder.append(", nombreDocumento=");
		builder.append(nombreDocumento);
		builder.append(", tipoDocumento=");
		builder.append(tipoDocumento);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}
