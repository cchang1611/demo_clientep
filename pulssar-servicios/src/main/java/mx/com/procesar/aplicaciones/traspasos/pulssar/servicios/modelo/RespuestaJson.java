package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * RespuestaJson
 * 
 * @author Ariatna Lucelly Lopez Euan (allopez@inet.procesar.com)
 * @version 1.0
 * @since 2017
 */
public class RespuestaJson implements Serializable {

    /**
     * Identificador de Serializacion
     */
    private static final long serialVersionUID = -4919151878992418104L;

    /**
     * Exito
     */
    private Integer exito;

    /**
     * Mensaje
     */
    private String mensaje;

    /**
     * Datos
     */
    private Object datos;

    /**
     * Repsuesta de la sesion
     */
    private RespuestaSesion respuestaSesion;

    /**
     * Constructor por default
     * 
     * @author Ariatna Lucelly Lopez Euan (allopez@inet.procesar.com)
     */
    public RespuestaJson() {
        // Vacio por defecto
    }

    /**
     * @return el atributo exito
     */
    public Integer getExito() {
        return exito;
    }

    /**
     * @param exito
     *            parametro exito a actualizar
     */
    public void setExito(Integer exito) {
        this.exito = exito;
    }

    /**
     * @return el atributo mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje
     *            parametro mensaje a actualizar
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return el atributo datos
     */
    public Object getDatos() {
        return datos;
    }

    /**
     * @param datos
     *            parametro datos a actualizar
     */
    public void setDatos(Object datos) {
        this.datos = datos;
    }

    /**
     *
     * M&eacute;todo getter utilizado para obtener la referencia del atributo <b>respuestaSesion</b>
     * @return el atributo respuestaSesion
     */
    public RespuestaSesion getRespuestaSesion() {
        return respuestaSesion;
    }

    /**
     * M&eacute;todo setter que asigna una referencia al atributo <b>respuestaSesion</b>
     * @param respuestaSesion parametro <b>respuestaSesion</b> a actualizar
     */
    public void setRespuestaSesion(RespuestaSesion respuestaSesion) {
        this.respuestaSesion = respuestaSesion;
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
        builder.append("RespuestaJson [exito=")
            .append(exito)
            .append(", mensaje=")
            .append(mensaje)
            .append(", datos=")
            .append(datos)
            .append(", respuestaSesion=")
            .append(respuestaSesion)
            .append("]");
        return builder.toString();
    }

}