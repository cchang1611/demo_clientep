package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.databind.JsonNode;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.BitacoraReporte;



/**
 * Clase que almancena los datos de respuesta para mostrar los reportes.
 * 
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 27/07/2020
 */
public class RespuestaPlataformaOperativa implements Serializable {

	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 7090659848358389770L;

	/**
	 * Lista de consultas
	 */
	private transient JsonNode consulta;

	/**
	 * Nombre de las columnas de la consulta.
	 */
	private String[] nombreColumnas;

	/**
	 * Número de las columnas
	 */
	private int tamanioColumnas;

	/**
	 * Dirección IP del usuario que ingresó al sistema.
	 */
	private String ipUsuario;

	/**
	 * bitacora de reporte registrada
	 */
	private BitacoraReporte bitacoraReporte;

	/**
	 * bandera que determina si existe configuracion de reporte
	 */
	private String nombreReporteJasper;

	/**
	 * Nombre del Reporte
	 */
	private String nombreReporte;

	/**
	 * @return el atributo bitacoraReporte
	 */
	public BitacoraReporte getBitacoraReporte() {
		return bitacoraReporte;
	}

	/**
	 * @param bitacoraReporte
	 *            parametro bitacoraReporte a actualizar
	 */
	public void setBitacoraReporte(BitacoraReporte bitacoraReporte) {
		this.bitacoraReporte = bitacoraReporte;
	}

	/**
	 * Constructor por defecto.
	 */
	public RespuestaPlataformaOperativa() {
		// Vacio por defecto.
	}

	/**
	 * @return the consulta
	 */
	public JsonNode getConsulta() {
		return consulta;
	}

	/**
	 * @param consulta
	 *            the consulta to set
	 */
	public void setConsulta(JsonNode consulta) {
		this.consulta = consulta;
	}

	/**
	 * @return the nombreColumnas
	 */
	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	/**
	 * @param nombreColumnas
	 *            the nombreColumnas to set
	 */
	public void setNombreColumnas(String[] nombreColumnas) {
		this.nombreColumnas = nombreColumnas;
	}

	/**
	 * @return the tamanioColumnas
	 */
	public int getTamanioColumnas() {
		return tamanioColumnas;
	}

	/**
	 * @param tamanioColumnas
	 *            the tamanioColumnas to set
	 */
	public void setTamanioColumnas(int tamanioColumnas) {
		this.tamanioColumnas = tamanioColumnas;
	}

	/**
	 * @return el atributo ipUsuario ipUsuario
	 */
	public String getIpUsuario() {
		return ipUsuario;
	}

	/**
	 * @param ipUsuario
	 *            parametro ipUsuario a actualizar ipUsuario
	 */
	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	/**
	 * @return el atributo nombreReporte nombreReporte
	 */
	public String getNombreReporte() {
		return nombreReporte;
	}

	/**
	 * @param nombreReporte
	 *            parametro nombreReporte a actualizar nombreReporte
	 */
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}

	/**
	 * @return the nombreReporteJasper
	 */
	public String getNombreReporteJasper() {
		return nombreReporteJasper;
	}

	/**
	 * @param nombreReporteJasper
	 *            the nombreReporteJasper to set
	 */
	public void setNombreReporteJasper(String nombreReporteJasper) {
		this.nombreReporteJasper = nombreReporteJasper;
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
		builder.append("RespuestaPlataformaOperativa [consulta=");
		builder.append(consulta);
		builder.append(", nombreColumnas=");
		builder.append(Arrays.toString(nombreColumnas));
		builder.append(", tamanioColumnas=");
		builder.append(tamanioColumnas);
		builder.append(", ipUsuario=");
		builder.append(ipUsuario);
		builder.append(", bitacoraReporte=");
		builder.append(bitacoraReporte);
		builder.append(", nombreReporte=");
		builder.append(nombreReporte);
		builder.append("]");
		return builder.toString();
	}

}