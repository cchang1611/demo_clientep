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
 * Definicion de entidad catalogo de reportes generico
 * 
 * @author Emartinez
 * @version 1.0
 */
@Entity
@Table(name = "PSER_TR_ROL_REPORTE")
public class RolReporteGenerico implements Serializable {

	/**
	 * identificador de serializacion
	 */
	private static final long serialVersionUID = 5021842583052073757L;

	/**
	 * Identificador unico de rol pol pulsar
	 */
	@Id
    @Column(name = "CV_ROL_PULSSAR")
	private Long idRolPulssar;

	/**
	 * Identificador unico de reporte generico
	 */
	@Column(name = "ID_REPORTE_GENERICO")
	private Long idReporteGenerico;


	/**
	 * Estado del reporte: 1 Activo 0 Inactivo
	 */
	@Column(name = "NU_ACTIVO")
	private int estado;


	/**
	 * Fecha de ultima modificación
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcControl;

	/**
	 * Usuario de ultima modificación
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String chUsuarioModificador;
	
	/**
	 * Constructor sin argumentos
	 * 
	 * @author EMARTINEZ
	 */
	public RolReporteGenerico() {
		// Constructor vacio
	}

	/**
	 * @return the idRolPulssar
	 */
	public Long getIdRolPulssar() {
		return idRolPulssar;
	}

	/**
	 * @param idRolPulssar the idRolPulssar to set
	 */
	public void setIdRolPulssar(Long idRolPulssar) {
		this.idRolPulssar = idRolPulssar;
	}

	/**
	 * @return the idReporteGenerico
	 */
	public Long getIdReporteGenerico() {
		return idReporteGenerico;
	}

	/**
	 * @param idReporteGenerico the idReporteGenerico to set
	 */
	public void setIdReporteGenerico(Long idReporteGenerico) {
		this.idReporteGenerico = idReporteGenerico;
	}

	/**
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
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
	 * @return the chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * @param chUsuarioModificador the chUsuarioModificador to set
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RolReporteGenerico [idRolPulssar=");
        builder.append(idRolPulssar);
        builder.append(", idReporteGenerico=");
        builder.append(idReporteGenerico);
        builder.append(", estado=");
        builder.append(estado);
        builder.append(", fcControl=");
        builder.append(fcControl);
        builder.append(", chUsuarioModificador=");
        builder.append(chUsuarioModificador);
        builder.append("]");
        return builder.toString();
    }

}