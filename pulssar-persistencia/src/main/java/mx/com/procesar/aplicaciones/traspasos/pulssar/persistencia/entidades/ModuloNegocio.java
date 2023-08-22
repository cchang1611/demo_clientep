package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Definicion de catalogo para Modulo de negocio
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 10:00:49
 */
@Entity
@Table(name = "PSER_TC_MODULO_REPORTE")
public class ModuloNegocio implements Serializable {

	/**
	 * identificador de serializacion
	 */
	private static final long serialVersionUID = 6191453888784369928L;

	/**
	 * Identificador de módulo.
	 */
	@Id
	@Column(name = "ID_MODULO_REPORTE")
	private Long idModulo;

	/**
	 * Nombre corto del Módulo.
	 */
	@Column(name = "CH_NOMBRE_MODULO_REP")
	private String nombreModulo;

	/**
	 * Bandera que define estado del modulo 1 Activo 0 Inactivo
	 */
	@Column(name = "NU_ACTIVO")
	private Integer activo;

	/**
	 * Fecha de ultima modificación
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "FC_CONTROL")
	private Date fcControl;

	/**
	 * Usuario de ultima modificación
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

	/**
	 * Constructor sin argumentos
	 * 
	 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
	 */
	public ModuloNegocio() {
		// Constructor vacio
	}

	/**
	 * @return el atributo idModulo
	 */
	public Long getIdModulo() {
		return idModulo;
	}

	/**
	 * @param idModulo
	 *            parametro idModulo a actualizar
	 */
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	/**
	 * @return el atributo nombreModulo
	 */
	public String getNombreModulo() {
		return nombreModulo;
	}

	/**
	 * @param nombreModulo
	 *            parametro nombreModulo a actualizar
	 */
	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

	/**
	 * @return el atributo fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl
	 *            parametro fcControl a actualizar
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/**
	 * @return el atributo usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador
	 *            parametro usuarioModificador a actualizar
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModuloNegocio [idModulo=");
		builder.append(idModulo);
		builder.append(", nombreModulo=");
		builder.append(nombreModulo);
		builder.append(", activo=");
		builder.append(activo);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}