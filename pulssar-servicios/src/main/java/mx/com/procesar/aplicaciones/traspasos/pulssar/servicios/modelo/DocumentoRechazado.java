/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * documento rechazado por el expediente
 * @author jcgarces
 *
 */
public class DocumentoRechazado implements Serializable{
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = 1516769789084205348L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * nombre del archivo
	 */
	private String nombre;
	
	/**
	 * clave d ediagnostico
	 */
	private String diagnostico;

	
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DocumentoRechazado [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", respuestaExpediente=");
		builder.append(respuestaExpediente);
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
		DocumentoRechazado other = (DocumentoRechazado) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				regreso = Boolean.FALSE;
			}
		} else if (!nombre.equals(other.nombre)) {
			regreso = Boolean.FALSE;
		}
		return regreso;
	}

}
