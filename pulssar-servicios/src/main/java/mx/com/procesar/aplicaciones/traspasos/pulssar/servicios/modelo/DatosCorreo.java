package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CorreoEnum;

/**
 * Clase Datos Correo para el envio de correo
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class DatosCorreo implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -1142981470161171387L;
	
	/**
	 * Correo Enum
	 */
	private CorreoEnum datosCorreo;
	
	/**
	 * url conexion
	 */
	private String urlServicio;
	
	/**
	 * Correo destino
	 */
	private String correo;
	
	/**
	 * Fecha de envio de correo
	 */
	private String fecha;
	
	/**
	 * Folio de Servicio
	 */
	private String folio;
	
	/**
	 * Nombre del usuario
	 */
	private String nombre;
	
	/**
	 * usuario
	 */
	private String usuario;
	
	/**
	 * password
	 */
	private String contrasenia;
	
	/**
	 * liga del tipo de correo
	 */
	private String ligaServicio;
	
	/**
	 * codigo
	 */
	private String codigo;
	
	/**
	 * codigo mensaje
	 */
	private String codigoMsn;
	
    /**
     * Archivo
     */
	private ByteArrayOutputStream archivo;

	/**
	 * @return the urlServicio
	 */
	public String getUrlServicio() {
		return urlServicio;
	}

	/**
	 * @param urlServicio the urlServicio to set
	 */
	public void setUrlServicio(String urlServicio) {
		this.urlServicio = urlServicio;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correos the correos to set
	 */
	public void setCorreo(String correos) {
		this.correo = correos;
	}

	/**
	 * @return the datosCorreo
	 */
	public CorreoEnum getDatosCorreo() {
		return datosCorreo;
	}

	/**
	 * @param datosCorreo the datosCorreo to set
	 */
	public void setDatosCorreo(CorreoEnum datosCorreo) {
		this.datosCorreo = datosCorreo;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * @return the ligaServicio
	 */
	public String getLigaServicio() {
		return ligaServicio;
	}

	/**
	 * @param ligaServicio the ligaServicio to set
	 */
	public void setLigaServicio(String ligaServicio) {
		this.ligaServicio = ligaServicio;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the codigoMsn
	 */
	public String getCodigoMsn() {
		return codigoMsn;
	}

	/**
	 * @param codigoMsn the codigoMsn to set
	 */
	public void setCodigoMsn(String codigoMsn) {
		this.codigoMsn = codigoMsn;
	}
	
	/**
	 * @return the archivo
	 */
	public ByteArrayOutputStream getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(ByteArrayOutputStream archivo) {
		this.archivo = archivo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosCorreo [datosCorreo=");
		builder.append(datosCorreo);
		builder.append(", urlServicio=");
		builder.append(urlServicio);
		builder.append(", correo=");
		builder.append(correo);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", contrasenia=");
		builder.append(contrasenia);
		builder.append(", ligaServicio=");
		builder.append(ligaServicio);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", codigoMsn=");
		builder.append(codigoMsn);
		builder.append(", archivo=");
		builder.append(archivo);
		builder.append("]");
		return builder.toString();
	}

	
}