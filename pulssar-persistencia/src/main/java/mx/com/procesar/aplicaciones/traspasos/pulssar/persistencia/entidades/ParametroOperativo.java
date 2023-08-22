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


/**
 * Representa la tabla PSER_TR_PARAMETRO_OPERATIVO
 * 
 * @author Arturo Eduardo de la Cruz Perez
 */
@Entity
@Table(name = "PSER_TR_PARAMETRO_OPERATIVO")
@SequenceGenerator(name = "SEQ_PARAM_OPERATIVO", sequenceName = "PSER_SEQ_PARAM_OPERATIVO", initialValue = 1, allocationSize = 1)
public class ParametroOperativo implements Serializable {
	


	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 2085327502045829246L;

	/**
	 * Identificador unico de registro.
	 */
	@Id
	@Column(name = "ID_PARAMETRO_OPERATIVO")
	@GeneratedValue(generator = "SEQ_PARAM_OPERATIVO", strategy = GenerationType.SEQUENCE)
    private Long idParametroOperativo;
	
	/**
	 * Token.
	 */
	@Column(name = "CH_TOKEN")
	private String token;
	
	/**
	 * Parametros
	 */
	@Column(name = "CH_PARAMETRO")
	private String parametros;
	
	/**
	 * Fecha de control
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcControl;
	
	/**
	 * Usuario modificador
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String usuarioModificador;

    /**
     *
     * M&eacute;todo getter utilizado para obtener la referencia del atributo <b>idParametroOperativo</b>
     * @return el atributo idParametroOperativo
     */
    public Long getIdParametroOperativo() {
        return idParametroOperativo;
    }

    /**
     * M&eacute;todo setter que asigna una referencia al atributo <b>idParametroOperativo</b>
     * @param idParametroOperativo parametro <b>idParametroOperativo</b> a actualizar
     */
    public void setIdParametroOperativo(Long idParametroOperativo) {
        this.idParametroOperativo = idParametroOperativo;
    }

    /**
     * @return the token
     */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the parametros
	 */
	public String getParametros() {
		return parametros;
	}

	/**
	 * @param parametros the parametros to set
	 */
	public void setParametros(String parametros) {
		this.parametros = parametros;
	}

	/**
	 * @return the fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl the fcControl to set
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
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
        builder.append("ParametroOperativo [idParametroOperativo=");
        builder.append(idParametroOperativo);
		builder.append(", token=");
		builder.append(token);
		builder.append(", parametros=");
		builder.append(parametros);
		builder.append("]");
		return builder.toString();
	}
}