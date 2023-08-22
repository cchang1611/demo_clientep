package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.BitacoraReporte;


public class RespuestaExcel implements Serializable {

	/**
	 * Identificacion de Serializacion
	 */
	private static final long serialVersionUID = 8438025389817385893L;
	
	/**
	 * Lista de consultas
	 */
	private String consulta;

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
	 * Nombre del Reporte
	 */
	private String nombreReporte;

	/**
	 * @return the consulta
	 */
	public String getConsulta() {
		return consulta;
	}

	/**
	 * @param consulta the consulta to set
	 */
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	/**
	 * @return the nombreColumnas
	 */
	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	/**
	 * @param nombreColumnas the nombreColumnas to set
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
	 * @param tamanioColumnas the tamanioColumnas to set
	 */
	public void setTamanioColumnas(int tamanioColumnas) {
		this.tamanioColumnas = tamanioColumnas;
	}

	/**
	 * @return the ipUsuario
	 */
	public String getIpUsuario() {
		return ipUsuario;
	}

	/**
	 * @param ipUsuario the ipUsuario to set
	 */
	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	/**
	 * @return the bitacoraReporte
	 */
	public BitacoraReporte getBitacoraReporte() {
		return bitacoraReporte;
	}

	/**
	 * @param bitacoraReporte the bitacoraReporte to set
	 */
	public void setBitacoraReporte(BitacoraReporte bitacoraReporte) {
		this.bitacoraReporte = bitacoraReporte;
	}

	/**
	 * @return the nombreReporte
	 */
	public String getNombreReporte() {
		return nombreReporte;
	}

	/**
	 * @param nombreReporte the nombreReporte to set
	 */
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}
	

}
