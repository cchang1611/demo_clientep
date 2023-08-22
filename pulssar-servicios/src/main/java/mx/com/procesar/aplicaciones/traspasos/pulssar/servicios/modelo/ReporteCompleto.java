package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ParametroReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteGenerico;



/**
 * Clase de reporte contemplando Parametros y SubConsultas
 * 
 * @author hjramire
 * @version 1.0
 * @since 15/01/2020, 12:19:19
 */
public class ReporteCompleto implements Serializable {

	/**
	 * Identificacion de Serializacion
	 */
	private static final long serialVersionUID = -7665802539041949865L;

	/**
	 * Reporte Padre
	 */
	private ReporteGenerico reporte;

	/**
	 * lista de SubReportes
	 */
	private List<ReporteGenerico> listaSubreportes;

	/**
	 * lista de Parametros
	 */
	private List<ParametroReporte> listaParametros;

	/**
	 * @return the reporte
	 */
	public ReporteGenerico getReporte() {
		return reporte;
	}

	/**
	 * @param reporte
	 *            the reporte to set
	 */
	public void setReporte(ReporteGenerico reporte) {
		this.reporte = reporte;
	}

	/**
	 * @return the listaSubreportes
	 */
	public List<ReporteGenerico> getListaSubreportes() {
		return listaSubreportes;
	}

	/**
	 * @param listaSubreportes
	 *            the listaSubreportes to set
	 */
	public void setListaSubreportes(List<ReporteGenerico> listaSubreportes) {
		this.listaSubreportes = listaSubreportes;
	}

	/**
	 * @return the listaParametros
	 */
	public List<ParametroReporte> getListaParametros() {
		return listaParametros;
	}

	/**
	 * @param listaParametros
	 *            the listaParametros to set
	 */
	public void setListaParametros(List<ParametroReporte> listaParametros) {
		this.listaParametros = listaParametros;
	}

}
