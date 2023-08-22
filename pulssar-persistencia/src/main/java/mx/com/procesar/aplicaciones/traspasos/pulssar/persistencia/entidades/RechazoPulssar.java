package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PSER_TC_RECHAZO_PULSSAR")
@SequenceGenerator(name = "SEQ_RECHAZO_PULSSAR", sequenceName = "PSER_SEQ_RECHAZO_PULSSAR", allocationSize = 1)
public class RechazoPulssar implements Serializable {
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 3980412052196135058L;
	
	/**
	 * identificador rechazo
	 */
	@Id
	@Column(name="ID_RECHAZO_PULSSAR")
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_RECHAZO_PULSSAR")
	private Long identificadorRechazo;
	
	/**
	 * clave rechazo
	 */
	@Column(name="CV_RECHAZO_PULSSAR")
	private String claveRechazo;
	
	/**
	 * clave organizacion
	 */
	@Column(name="CV_ORGANIZACION")
	private String claveOrganizacion;
	
	/**
	 * titulo mensaje
	 */
	@Column(name="CH_TITULO_MENSAJE")
	private String tituloMensaje;
	
	/**
	 * mensaje
	 */
	@Column(name="CH_MENSAJE")
	private String mensaje;
	
	/**
	 * estatus
	 */
	@Column(name="NU_ESTATUS")
	private Integer estatus;
	
	/**
	 * fecha control
	 */
	@Column(name="FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	/**
	 * usuario modificador
	 */
	@Column(name="CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;
	
	/**
	 * @return the identificadorRechazo
	 */
	public Long getIdentificadorRechazo() {
		return identificadorRechazo;
	}

	/**
	 * @param identificadorRechazo the identificadorRechazo to set
	 */
	public void setIdentificadorRechazo(Long identificadorRechazo) {
		this.identificadorRechazo = identificadorRechazo;
	}

	/**
	 * @return the claveRechazo
	 */
	public String getClaveRechazo() {
		return claveRechazo;
	}

	/**
	 * @param claveRechazo the claveRechazo to set
	 */
	public void setClaveRechazo(String claveRechazo) {
		this.claveRechazo = claveRechazo;
	}

	/**
	 * @return the claveOrganizacion
	 */
	public String getClaveOrganizacion() {
		return claveOrganizacion;
	}

	/**
	 * @param claveOrganizacion the claveOrganizacion to set
	 */
	public void setClaveOrganizacion(String claveOrganizacion) {
		this.claveOrganizacion = claveOrganizacion;
	}

	/**
	 * @return the tituloMensaje
	 */
	public String getTituloMensaje() {
		return tituloMensaje;
	}

	/**
	 * @param tituloMensaje the tituloMensaje to set
	 */
	public void setTituloMensaje(String tituloMensaje) {
		this.tituloMensaje = tituloMensaje;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
		builder.append("RechazoPulssar [identificadorRechazo=");
		builder.append(identificadorRechazo);
		builder.append(", claveRechazo=");
		builder.append(claveRechazo);
		builder.append("claveOrganizacion=");
		builder.append(claveOrganizacion);
		builder.append(", tituloMensaje=");
		builder.append(tituloMensaje);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
}