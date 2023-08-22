package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

public class RespuestaExpedienteDetalle implements Serializable{
	/**
	 * serial
	 */
	private static final long serialVersionUID = -4904459615014779800L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * nombre del expediente
	 */
	private String nombre;
	
	/**
	 * Afore
	 */
	private String claveAfore;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * folio afore
	 */
	private String folioAfore;
	
	/**
	 * clave de diagnostico
	 */
	private String diagnostico;
	
	/**
	 * Clave de la afore
	 */
	private Integer estatus;
	
	/**
	 * documentos del expediente
	 */
	private List<DocumentoExpediente> documentos;
	
	/**
	 * respuesta del expediente
	 */
	private RespuestaExpediente respuestaExpediente;
	
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
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
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
	 * @return the folioAfore
	 */
	public String getFolioAfore() {
		return folioAfore;
	}

	/**
	 * @param folioAfore the folioAfore to set
	 */
	public void setFolioAfore(String folioAfore) {
		this.folioAfore = folioAfore;
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
	 * @return the respuestaExpediente
	 */
	public RespuestaExpediente getRespuestaExpediente() {
		return respuestaExpediente;
	}

	/**
	 * @param respuestaExpediente the respuestaExpediente to set
	 */
	public void setRespuestaExpediente(RespuestaExpediente respuestaExpediente) {
		this.respuestaExpediente = respuestaExpediente;
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
		builder.append("RespuestaExpedienteDetalle [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", folioAfore=");
		builder.append(folioAfore);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", documentos=");
		builder.append(documentos);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Boolean regreso = Boolean.TRUE;
		RespuestaExpedienteDetalle other = (RespuestaExpedienteDetalle) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				regreso = Boolean.FALSE;
			}
		} else if (!nombre.equals(other.nombre)) {
			regreso = Boolean.FALSE;
		}
		return regreso;
	}

	/**
	 * @return the documentos
	 */
	public List<DocumentoExpediente> getDocumentos() {
		if(documentos == null) {
			documentos = new ArrayList<>();
		}
		return documentos;
	}

	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(List<DocumentoExpediente> documentos) {
		this.documentos = documentos;
	}
	
	/**
	 * agrega un documento de expediente
	 * @param documentoExpediente
	 */
	public void agregarDocumento(DocumentoExpediente documentoExpediente) {
		if(documentoExpediente != null && !getDocumentos().contains(documentoExpediente)) {
			documentoExpediente.setExpediente(this);
			getDocumentos().add(documentoExpediente);
		}
	}


}
