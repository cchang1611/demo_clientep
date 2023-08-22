/**
 * PerfilFederados.java Fecha de creación: 02/12/2021, 17:21:52 Copyright (c) 2021 Procesar S A
 * de C V. Todos los derechos reservados. Este software es información confidencial, propiedad
 * del Procesar S A de C V. Esta información confidencial no deberá ser divulgada y solo se
 * podrá utilizar de acuerdo a los términos que determine la propia empresa.
 */
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
 * Entidad que mapea el catálogo de perfiles de federados.
 * @author Victorino Hern&aacute;ndez Ruiz (vhernand@procesar.com)
 * @version 1.0
 * @since Diciembre de 2021
 */
@Entity
@Table(name = "PSER_TC_PERFIL_FEDERADOS")
public class PerfilFederados implements Serializable {

    /**
     * Atributo de serializacion
     */
    private static final long serialVersionUID = 6604744223764691766L;

    /**
     * Clave de perfil de federados.
     */
    @Id
    @Column(name = "CV_PERFIL_FEDERADOS")
    private String clavePerfil;

    /**
     * Descripción de perfil federados.
     */
    @Column(name = "CH_DESC_PERFIL_FEDERADOS")
    private String descripcionPerfil;

    /**
     * Fecha de última modificación del registro.
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FC_CONTROL")
    private Date fechaModificacion;

    /**
     * Usuario/Programa o Ente que hizo la última modificación del registro.
     */
    @Column(name = "CH_USUARIO_MODIFICADOR")
    private String usuarioModificador;

    /**
     * Getter que devuelve el valor del atributo clavePerfil
     * @return Valor del atributo clavePerfil
     */
    public String getClavePerfil() {
        return clavePerfil;
    }

    /**
     * Setter que asigna valor al atributo clavePerfil
     * @param clavePerfil valor que se le desea asignar al atributo clavePerfil
     */
    public void setClavePerfil(String clavePerfil) {
        this.clavePerfil = clavePerfil;
    }

    /**
     * Getter que devuelve el valor del atributo descripcionPerfil
     * @return Valor del atributo descripcionPerfil
     */
    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    /**
     * Setter que asigna valor al atributo descripcionPerfil
     * @param descripcionPerfil valor que se le desea asignar al atributo descripcionPerfil
     */
    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }

    /**
     * Getter que devuelve el valor del atributo fechaModificacion
     * @return Valor del atributo fechaModificacion
     */
    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * Setter que asigna valor al atributo fechaModificacion
     * @param fechaModificacion valor que se le desea asignar al atributo fechaModificacion
     */
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    /**
     * Getter que devuelve el valor del atributo usuarioModificador
     * @return Valor del atributo usuarioModificador
     */
    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    /**
     * Setter que asigna valor al atributo usuarioModificador
     * @param usuarioModificador valor que se le desea asignar al atributo usuarioModificador
     */
    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PerfilFederados [clavePerfil=");
        builder.append(clavePerfil);
        builder.append(", descripcionPerfil=");
        builder.append(descripcionPerfil);
        builder.append(", fechaModificacion=");
        builder.append(fechaModificacion);
        builder.append(", usuarioModificador=");
        builder.append(usuarioModificador);
        builder.append("]");
        return builder.toString();
    }

}
