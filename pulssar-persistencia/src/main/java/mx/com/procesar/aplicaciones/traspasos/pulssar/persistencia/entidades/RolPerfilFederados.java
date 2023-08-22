/**
 * RolPerfilFederados.java Fecha de creación: 02/12/2021, 17:52:55 Copyright (c) 2021 Procesar
 * S A de C V. Todos los derechos reservados. Este software es información confidencial,
 * propiedad del Procesar S A de C V. Esta información confidencial no deberá ser divulgada y
 * solo se podrá utilizar de acuerdo a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que mapea la entidad del rol de perfil federados.
 * @author Victorino Hern&aacute;ndez Ruiz (vhernand@procesar.com)
 * @version 1.0
 * @since Diciembre de 2021
 */
@Entity
@Table(name = "PSER_TR_ROL_PERFIL_FEDERADOS")
public class RolPerfilFederados implements Serializable {

    /**
     * Atributo de Serializacion
     */
    private static final long serialVersionUID = 5019092193720179228L;

    /**
     * Clave única de la entidad de liquidación de SAR92.
     */
    @Id
    @Column(name = "ID_ROL_PERFIL_FEDERADOS")
    private Long idRolPerfil;

    /**
     * ROL Pulssar.
     */
    @OneToOne
    @JoinColumn(name = "ID_ROL_PULSSAR", insertable = false, updatable = false)
    private RolesCatalogo rolPulssar;

    /**
     * Perfil federado asociado al catalogo
     */
    @OneToOne
    @JoinColumn(name = "CV_PERFIL_FEDERADOS", insertable = false, updatable = false)
    private PerfilFederados perfilFederados;

    /**
     * URL a donde se debe redireccionar para hacer el login.
     */
    @Column(name = "CH_URL_LOGIN")
    private String urlLogin;

    /**
     * URL a donde se debe redireccionar para hacer el logout.
     */
    @Column(name = "CH_URL_LOGOUT")
    private String urlLogut;

    /**
     * Cadena que se mostrará en el menu
     */
    @Column(name = "CH_DESCRIPCION")
    private String descripcion;

    /**
     * Nombre de la imagen que se mostrará en el menu
     */
    @Column(name = "CH_IMAGEN_MENU")
    private String imagenMenu;

    /**
     * Fecha de última modificación del registro
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
     * Getter que devuelve el valor del atributo idRolPerfil
     * @return Valor del atributo idRolPerfil
     */
    public Long getIdRolPerfil() {
        return idRolPerfil;
    }

    /**
     * Setter que asigna valor al atributo idRolPerfil
     * @param idRolPerfil valor que se le desea asignar al atributo idRolPerfil
     */
    public void setIdRolPerfil(Long idRolPerfil) {
        this.idRolPerfil = idRolPerfil;
    }

    /**
     * Getter que devuelve el valor del atributo rolPulssar
     * @return Valor del atributo rolPulssar
     */
    public RolesCatalogo getRolPulssar() {
        return rolPulssar;
    }

    /**
     * Setter que asigna valor al atributo rolPulssar
     * @param rolPulssar valor que se le desea asignar al atributo rolPulssar
     */
    public void setRolPulssar(RolesCatalogo rolPulssar) {
        this.rolPulssar = rolPulssar;
    }

    /**
     * Getter que devuelve el valor del atributo perfilFederados
     * @return Valor del atributo perfilFederados
     */
    public PerfilFederados getPerfilFederados() {
        return perfilFederados;
    }

    /**
     * Setter que asigna valor al atributo perfilFederados
     * @param perfilFederados valor que se le desea asignar al atributo perfilFederados
     */
    public void setPerfilFederados(PerfilFederados perfilFederados) {
        this.perfilFederados = perfilFederados;
    }

    /**
     * Getter que devuelve el valor del atributo urlLogin
     * @return Valor del atributo urlLogin
     */
    public String getUrlLogin() {
        return urlLogin;
    }

    /**
     * Setter que asigna valor al atributo urlLogin
     * @param urlLogin valor que se le desea asignar al atributo urlLogin
     */
    public void setUrlLogin(String urlLogin) {
        this.urlLogin = urlLogin;
    }

    /**
     * Getter que devuelve el valor del atributo urlLogut
     * @return Valor del atributo urlLogut
     */
    public String getUrlLogut() {
        return urlLogut;
    }

    /**
     * Setter que asigna valor al atributo urlLogut
     * @param urlLogut valor que se le desea asignar al atributo urlLogut
     */
    public void setUrlLogut(String urlLogut) {
        this.urlLogut = urlLogut;
    }

    /**
     * Getter que devuelve el valor del atributo descripcion
     * @return Valor del atributo descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter que asigna valor al atributo descripcion
     * @param descripcion valor que se le desea asignar al atributo descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Getter que devuelve el valor del atributo imagenMenu
     * @return Valor del atributo imagenMenu
     */
    public String getImagenMenu() {
        return imagenMenu;
    }

    /**
     * Setter que asigna valor al atributo imagenMenu
     * @param imagenMenu valor que se le desea asignar al atributo imagenMenu
     */
    public void setImagenMenu(String imagenMenu) {
        this.imagenMenu = imagenMenu;
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
        builder.append("RolPerfilFederados [idRolPerfil=");
        builder.append(idRolPerfil);
        builder.append(", rolPulssar=");
        builder.append(rolPulssar);
        builder.append(", perfilFederados=");
        builder.append(perfilFederados);
        builder.append(", urlLogin=");
        builder.append(urlLogin);
        builder.append(", urlLogut=");
        builder.append(urlLogut);
        builder.append(", descripcion=");
        builder.append(descripcion);
        builder.append(", imagenMenu=");
        builder.append(imagenMenu);
        builder.append(", fechaModificacion=");
        builder.append(fechaModificacion);
        builder.append(", usuarioModificador=");
        builder.append(usuarioModificador);
        builder.append("]");
        return builder.toString();
    }

}
