/**
 * CombosCatalogosPlataformaServicios.java Fecha de creación: 14/06/2018, 17:14:40 Copyright
 * (c) 2018 Procesar S A de C V. Todos los derechos reservados. Este software es información
 * confidencial, propiedad del Procesar S A de C V. Esta información confidencial no deberá ser
 * divulgada y solo se podrá utilizar de acuerdo a los términos que determine la propia
 * empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo;

import java.io.Serializable;
import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteSubProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteTipo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SubProcesoNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.TipoReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteCompleto;

/**
 * Clase que almacena los catálogos necesarios a cargar para la seleección del tipo de reporte
 * a consultar.
 * @author Oscar Enrique González García (oegonzal@inet.procesar.com.mx)
 * @version 1.0
 * @since 03/01/2020, 10:01:25
 */
public class CombosCatalogosPlataformaServicios implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 420630412147482876L;

	/**
	 * Módulos
	 */
	private List<RolReporte> modulos;

	/**
	 * Procesos
	 */
	private List<ProcesoNegocio> procesos;

	/**
	 * Procesos por idModulo y idRolPulssar
	 */
	private List<RolReporteProceso> proceso;

	/**
	 * Tipos Reporte
	 */
	private List<TipoReporte> tiposReporte;

	/**
	 * Tipo Reporte
	 */
	private List<RolReporteTipo> tipoReporte;

	/**
	 * Sub Procesos
	 */
	private List<SubProcesoNegocio> subprocesos;

	/**
	 * Sub Proceso
	 */
	private List<RolReporteSubProceso> subproceso;

	/**
	 * Reporte Generico
	 */
	private List<ReporteGenerico> reporteGenerico;

	/**
	 * Reporte Generico Completo
	 */
	private List<ReporteCompleto> reporteCompleto;

	/**
	 * @return the tipoReporte
	 */
	public List<RolReporteTipo> getTipoReporte() {
		return tipoReporte;
	}

	/**
	 * @param tipoReporte the tipoReporte to set
	 */
	public void setTipoReporte(List<RolReporteTipo> tipoReporte) {
		this.tipoReporte = tipoReporte;
	}

	/**
	 * @return el atributo modulos modulos
	 */
	public List<RolReporte> getModulos() {
		return modulos;
	}

	/**
	 * @param modulos parametro modulos a actualizar modulos
	 */
	public void setModulos(List<RolReporte> modulos) {
		this.modulos = modulos;
	}

	/**
	 * @return el atributo procesos procesos
	 */
	public List<ProcesoNegocio> getProcesos() {
		return procesos;
	}

	/**
	 * @param procesos parametro procesos a actualizar procesos
	 */
	public void setProcesos(List<ProcesoNegocio> procesos) {
		this.procesos = procesos;
	}

	/**
	 * @return el atributo subprocesos subprocesos
	 */
	public List<SubProcesoNegocio> getSubprocesos() {
		return subprocesos;
	}

	/**
	 * @param subprocesos parametro subprocesos a actualizar subprocesos
	 */
	public void setSubprocesos(List<SubProcesoNegocio> subprocesos) {
		this.subprocesos = subprocesos;
	}

	/**
	 * @return el atributo tiposReporte tiposReporte
	 */
	public List<TipoReporte> getTiposReporte() {
		return tiposReporte;
	}

	/**
	 * @param tiposReporte parametro tiposReporte a actualizar tiposReporte
	 */
	public void setTiposReporte(List<TipoReporte> tiposReporte) {
		this.tiposReporte = tiposReporte;
	}

	/**
	 * @return el atributo reporteGenerico reporteGenerico
	 */
	public List<ReporteGenerico> getReporteGenerico() {
		return reporteGenerico;
	}

	/**
	 * @param reporteGenerico parametro reporteGenerico a actualizar reporteGenerico
	 */
	public void setReporteGenerico(List<ReporteGenerico> reporteGenerico) {
		this.reporteGenerico = reporteGenerico;
	}

	/**
	 * @return the proceso
	 */
	public List<RolReporteProceso> getProceso() {
		return proceso;
	}

	/**
	 * @param proceso the proceso to set
	 */
	public void setProceso(List<RolReporteProceso> proceso) {
		this.proceso = proceso;
	}

	/**
	 * @return the subproceso
	 */
	public List<RolReporteSubProceso> getSubproceso() {
		return subproceso;
	}

	/**
	 * @param subproceso the subproceso to set
	 */
	public void setSubproceso(List<RolReporteSubProceso> subproceso) {
		this.subproceso = subproceso;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CombosCatalogosPlataformaServicios [modulos=");
		builder.append(modulos);
		builder.append(", procesos=");
		builder.append(procesos);
		builder.append(", proceso=");
		builder.append(proceso);
		builder.append(", tiposReporte=");
		builder.append(tiposReporte);
		builder.append(", tipoReporte=");
		builder.append(tipoReporte);
		builder.append(", subprocesos=");
		builder.append(subprocesos);
		builder.append(", subproceso=");
		builder.append(subproceso);
		builder.append(", reporteGenerico=");
		builder.append(reporteGenerico);
		builder.append(", reporteCompleto=");
		builder.append(reporteCompleto);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the reporteCompleto
	 */
	public List<ReporteCompleto> getReporteCompleto() {
		return reporteCompleto;
	}

	/**
	 * @param reporteCompleto the reporteCompleto to set
	 */
	public void setReporteCompleto(List<ReporteCompleto> reporteCompleto) {
		this.reporteCompleto = reporteCompleto;
	}

}