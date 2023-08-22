/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contiene la cita registrada para un trabajador para la <b>Administracion de
 * Filas y citas - Citibnamex</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public class TurnoRegistrado implements Serializable {

	/**
	 * Serializacion de la clase.
	 */
	private static final long serialVersionUID = -2796767595366561610L;

	/**
	 * Folio de atención asignado al Trabajador.
	 */
	private String folioServicio;

	/**
	 * Nombre completo del Trabjador.
	 */
	private String nombreTrabajador;

	/**
	 * Muestra la hora de registro del trabajador.
	 */
	private String horaRegistro;
	
	/**
	 * Minutos transcurridos en espera desde el registro de la cita del
	 * Trabajador.
	 */
	private String minutosEspera;

	/**
	 * Horas transcurridos en espera desde el registro de la cita del
	 * Trabajador.
	 */
	private String horasEspera;
	
	/**
	 * Estilo que se mostrara en la pantalla segun el rango de entrada.
	 */
	private String estiloRegistroCss;
	
	/**
	 * Estilo que se mostrara en la pantalla segun el rango de entrada.
	 */
	private String estiloCss;
	
	/**
	 * Url del registro.
	 */
	private String url;
	
	/**
	 * Estilo que si es autorizado el usuario o no.
	 */
	private String autorizadoCss;
	
	/**
	 * Constructor publico.
	 */
	public TurnoRegistrado() {
		super();
	}
	
	/**
	 * Constructor publico.
	 */
	public TurnoRegistrado(String folioServicio, String nombreTrabajador, String horaRegistro, String minutosEspera,
			String horasEspera) {
		
		super();
		this.folioServicio = folioServicio;
		this.nombreTrabajador = nombreTrabajador;
		this.horaRegistro = horaRegistro;
		this.minutosEspera = minutosEspera;
		this.horasEspera = horasEspera;
	}

	/**
	 * @return the folioAtencion
	 */
	public String getFolioServicio() {
		return folioServicio;
	}

	/**
	 * @param folioServicio
	 *            the folioAtencion to set
	 */
	public void setFolioServicio(String folioServicio) {
		this.folioServicio = folioServicio;
	}

	/**
	 * @return the nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador
	 *            the nombreTrabajador to set
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}

	/**
	 * @return the minutosEspera
	 */
	public String getHoraRegistro() {
		return horaRegistro;
	}

	/**
	 * @param minutosEspera
	 *            the minutosEspera to set
	 */
	public void setHoraRegistro(String minutosEspera) {
		this.horaRegistro = minutosEspera;
	}
	
	/**
	 * @return the minutosEspera
	 */
	public String getMinutosEspera() {
		return minutosEspera;
	}

	/**
	 * @param minutosEspera
	 *            the minutosEspera to set
	 */
	public void setMinutosEspera(String minutosEspera) {
		this.minutosEspera = minutosEspera;
	}

	/**
	 * @return the horasEspera
	 */
	public String getHorasEspera() {
		return horasEspera;
	}

	/**
	 * @param horasEspera
	 *            the horasEspera to set
	 */
	public void setHorasEspera(String horasEspera) {
		this.horasEspera = horasEspera;
	}
	
	/**
	 * @return the estiloCss
	 */
	public String getEstiloCss() {
		return estiloCss;
	}

	/**
	 * @param estiloCss the estiloCss to set
	 */
	public void setEstiloCss(String estiloCss) {
		this.estiloCss = estiloCss;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the autorizadoCss
	 */
	public String getAutorizadoCss() {
		return autorizadoCss;
	}

	/**
	 * @param autorizadoCss the autorizadoCss to set
	 */
	public void setAutorizadoCss(String autorizadoCss) {
		this.autorizadoCss = autorizadoCss;
	}
	
	/**
	 * @return the estiloRegistroCss
	 */
	public String getEstiloRegistroCss() {
		return estiloRegistroCss;
	}

	/**
	 * @param estiloRegistroCss the estiloRegistroCss to set
	 */
	public void setEstiloRegistroCss(String estiloRegistroCss) {
		this.estiloRegistroCss = estiloRegistroCss;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
