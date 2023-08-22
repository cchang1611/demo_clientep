package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * clase que contiene los atributos de Entrada del registro de un usuario
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class DatosCargaMasiva implements Serializable {
	
	/**
	 * Serial version
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * May 27, 2022 
	 */
	private static final long serialVersionUID = -1184695491002548245L;

	/**
	 * Confirmación del número de celular
	 */
	private List<UsuarioAgente> lstUsuarioAgentes;

	/**
	 * correo
	 */
	private String correoElectronico;
	
	/**
	 * nombreAgente
	 */
	private String nombreAgente;
	
	/**
	 * ap paterno
	 */
	private String apellidoPaterno;
	
	/**
	 * ap Materno
	 */
	private String apellidoMaterno;
	
	/**
	 * Codigo de activacion
	 */
	private String claveAfore;
	/**
	 * nombre del archivo
	 */
	private String nomArchivo;
	
	/**
	 * fechaBusqueda
	 */
	private String fechaBusqueda;
	/**
	 * archivo 
	 */
	private byte[] archivo;
	/**
	 * se agrega flujo
	 * 1 exito
	 * 2 error 
	 * Jun 30, 2022
	 */
	private int flujo;
	/**
	 * mensaje de error flujo 2
	 * Jun 30, 2022
	 */
	private String mensaje;

	public int getFlujo() {
		return flujo;
	}

	public void setFlujo(int flujo) {
		this.flujo = flujo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the lstUsuarioAgentes
	 */
	public List<UsuarioAgente> getLstUsuarioAgentes() {
		return lstUsuarioAgentes;
	}

	/**
	 * @param lstUsuarioAgentes the lstUsuarioAgentes to set
	 */
	public void setLstUsuarioAgentes(List<UsuarioAgente> lstUsuarioAgentes) {
		this.lstUsuarioAgentes = lstUsuarioAgentes;
	}

	/**
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * @return the nombreAgente
	 */
	public String getNombreAgente() {
		return nombreAgente;
	}

	/**
	 * @param nombreAgente the nombreAgente to set
	 */
	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return the nomArchivo
	 */
	public String getNomArchivo() {
		return nomArchivo;
	}

	/**
	 * @param nomArchivo the nomArchivo to set
	 */
	public void setNomArchivo(String nomArchivo) {
		this.nomArchivo = nomArchivo;
	}

	/**
	 * @return the fechaBusqueda
	 */
	public String getFechaBusqueda() {
		return fechaBusqueda;
	}

	/**
	 * @param fechaBusqueda the fechaBusqueda to set
	 */
	public void setFechaBusqueda(String fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}

	/**
	 * @return the archivo
	 */
	public byte[] getArchivo() {
		return archivo;
	}

	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosCargaMasiva [lstUsuarioAgentes=");
		builder.append(lstUsuarioAgentes);
		builder.append(", correoElectronico=");
		builder.append(correoElectronico);
		builder.append(", nombreAgente=");
		builder.append(nombreAgente);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", nomArchivo=");
		builder.append(nomArchivo);
		builder.append(", fechaBusqueda=");
		builder.append(fechaBusqueda);
		builder.append(", archivo=");
		builder.append(Arrays.toString(archivo));
		builder.append(", flujo=");
		builder.append(flujo);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append("]");
		return builder.toString();
	}

}