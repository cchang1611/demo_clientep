package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Map;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.BitacoraReporte;


/**
 * Clase que almacena los objetos que serán exportados a PDF por JasperReport.
 * 
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 27/07/2020
 */
public class RespuestaPdfPlataformaOperativa implements Serializable {

	/**
	 * Identificador de serializacion
	 */
	private static final long serialVersionUID = -1327434861412190504L;

	/**
	 * Configuracion de Reporte
	 */
	private ReporteCompleto reporte;

	/**
	 * Lista de parametros de reporte
	 */
	private Map<String, String> parametros;

	/**
	 * Mapa con informacion de consulta y subcuonsultas
	 */
	private Map<String, String> informacionReporte;

	/**
	 * Bitacora de Reporte
	 */
	private BitacoraReporte bitacoraReporte;

	/**
	 * @return the parametros
	 */
	public Map<String, String> getParametros() {
		return parametros;
	}

	/**
	 * @param parametros
	 *            the parametros to set
	 */
	public void setParametros(Map<String, String> parametros) {
		this.parametros = parametros;
	}

	/**
	 * @return the informacionReporte
	 */
	public Map<String, String> getInformacionReporte() {
		return informacionReporte;
	}

	/**
	 * @param informacionReporte
	 *            the informacionReporte to set
	 */
	public void setInformacionReporte(Map<String, String> informacionReporte) {
		this.informacionReporte = informacionReporte;
	}

	/**
	 * @return the reporte
	 */
	public ReporteCompleto getReporte() {
		return reporte;
	}

	/**
	 * @param reporte
	 *            the reporte to set
	 */
	public void setReporte(ReporteCompleto reporte) {
		this.reporte = reporte;
	}

	/**
	 * @return the bitacoraReporte
	 */
	public BitacoraReporte getBitacoraReporte() {
		return bitacoraReporte;
	}

	/**
	 * @param bitacoraReporte
	 *            the bitacoraReporte to set
	 */
	public void setBitacoraReporte(BitacoraReporte bitacoraReporte) {
		this.bitacoraReporte = bitacoraReporte;
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
		builder.append("RespuestaPdfPlataformaOperativa [reporte=");
		builder.append(reporte);
		builder.append(", bitacoraReporte=");
		builder.append(bitacoraReporte);
		builder.append("]");
		return builder.toString();
	}

}
