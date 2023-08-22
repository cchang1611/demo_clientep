/**
 * DatosEntradaToken.java
 * Fecha de creación: 04/03/2021, 13:54:53
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase que contiene los datos necesarios para la generacion del token requerido para el manejo de la sesion
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Marzo de 2021
 */
public class DatosEntradaToken implements Serializable {

    /**
     * Atributo de Serializacion
     */
    private static final long serialVersionUID = -2862201922430680133L;

    /**
     * Token generado para obtrener los datos de la sesion
     */
    private String token;

    /**
     * Cadena en formato Json que contiene los datos del usuario
     */
    private String jsonUsuario;

    /**
     * Usuario que realiza la inserciond el registro
     */
    private String usuarioModificador;
    /**
     *
     * M&eacute;todo getter utilizado para obtener la referencia del atributo <b>token</b>
     * @return el atributo token
     */
    public String getToken() {
        return token;
    }

    /**
     * M&eacute;todo setter que asigna una referencia al atributo <b>token</b>
     * @param token parametro <b>token</b> a actualizar
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     * M&eacute;todo getter utilizado para obtener la referencia del atributo <b>jsonUsuario</b>
     * @return el atributo jsonUsuario
     */
    public String getJsonUsuario() {
        return jsonUsuario;
    }

    /**
     * M&eacute;todo setter que asigna una referencia al atributo <b>jsonUsuario</b>
     * @param jsonUsuario parametro <b>jsonUsuario</b> a actualizar
     */
    public void setJsonUsuario(String jsonUsuario) {
        this.jsonUsuario = jsonUsuario;
    }

    /**
     *
     * M&eacute;todo getter utilizado para obtener la referencia del atributo <b>usuarioModificador</b>
     * @return el atributo usuarioModificador
     */
    public String getUsuarioModificador() {
        return usuarioModificador;
    }

    /**
     * M&eacute;todo setter que asigna una referencia al atributo <b>usuarioModificador</b>
     * @param usuarioModificador parametro <b>usuarioModificador</b> a actualizar
     */
    public void setUsuarioModificador(String usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
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
        builder.append("DatosEntradaToken [token=")
            .append(token)
            .append(", jsonUsuario=")
            .append(jsonUsuario)
            .append(", usuarioModificador=")
            .append(usuarioModificador)
            .append("]");
        return builder.toString();
    }

}
