package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * Clase que almacena los parámetros de consulta.
 * 
 * @author Oscar Enrique González García (oegonzal@inet.procesar.com.mx)
 * @version 1.0
 * @since Junio 2018
 */
public class DatosConsultaPlataformaServicios implements Serializable {

	/**
	 * Identificador de Serializacion
	 */
	private static final long serialVersionUID = 4408747741451754458L;

	/**
	 * Fecha Inicial
	 */
	private String fechaInicial;

	/**
	 * Fecha Final
	 */
	private String fechaFinal;

	/**
	 * Archivo que se intenta almacenar
	 */
	private MultipartFile archivoProcesar;

	/**
	 * Tipo de Archivo a cargar
	 */
	private String tipoArchivo;

	/**
	 * NSS
	 */
	private String nss;

	/**
	 * CURP
	 */
	private String curp;

	/**
	 * Módulo
	 */
	private String modulo;

	/**
	 * Proceso
	 */
	private String proceso;

	/**
	 * Subproceso
	 */
	private String subProceso;

	/**
	 * tipoReporteMasivo
	 */
	private String tipoReporteMasivo;

	/**
	 * Reporte
	 */
	private String reporte;

	/**
	 * ID PROCESAR
	 */
	private String idProcesar;

	/**
	 * fechaInicialEjec
	 */
	private String fechaInicialEjec;

	/**
	 * fechaFinalEjec
	 */
	private String fechaFinalEjec;

	/**
	 * usuarioConsulta
	 */
	private String usuarioConsulta;

	/**
	 * ipConsulta
	 */
	private String ipUsuarioConsulta;

	/**
	 * @return the fechaInicial
	 */
	public String getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial
	 *            the fechaInicial to set
	 */
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @return the fechaFinal
	 */
	public String getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal
	 *            the fechaFinal to set
	 */
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss
	 *            the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp
	 *            the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the idProcesar
	 */
	public String getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar
	 *            the idProcesar to set
	 */
	public void setIdProcesar(String idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * @return the modulo
	 */
	public String getModulo() {
		return modulo;
	}

	/**
	 * @param modulo
	 *            the modulo to set
	 */
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	/**
	 * @return the proceso
	 */
	public String getProceso() {
		return proceso;
	}

	/**
	 * @param proceso
	 *            the proceso to set
	 */
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	/**
	 * @return the subProceso
	 */
	public String getSubProceso() {
		return subProceso;
	}

	/**
	 * @param subProceso
	 *            the subProceso to set
	 */
	public void setSubProceso(String subProceso) {
		this.subProceso = subProceso;
	}

	/**
	 * @return el atributo fechaInicialEjec fechaInicialEjec
	 */
	public String getFechaInicialEjec() {
		return fechaInicialEjec;
	}

	/**
	 * @param fechaInicialEjec
	 *            parametro fechaInicialEjec a actualizar fechaInicialEjec
	 */
	public void setFechaInicialEjec(String fechaInicialEjec) {
		this.fechaInicialEjec = fechaInicialEjec;
	}

	/**
	 * @return el atributo fechaFinalEjec fechaFinalEjec
	 */
	public String getFechaFinalEjec() {
		return fechaFinalEjec;
	}

	/**
	 * @param fechaFinalEjec
	 *            parametro fechaFinalEjec a actualizar fechaFinalEjec
	 */
	public void setFechaFinalEjec(String fechaFinalEjec) {
		this.fechaFinalEjec = fechaFinalEjec;
	}

	/**
	 * @return el atributo usuarioConsulta usuarioConsulta
	 */
	public String getUsuarioConsulta() {
		return usuarioConsulta;
	}

	/**
	 * @param usuarioConsulta
	 *            parametro usuarioConsulta a actualizar usuarioConsulta
	 */
	public void setUsuarioConsulta(String usuarioConsulta) {
		this.usuarioConsulta = usuarioConsulta;
	}

	/**
	 * @return el atributo ipConsulta ipConsulta
	 */
	public String getIpUsuarioConsulta() {
		return ipUsuarioConsulta;
	}

	/**
	 * @param ipConsulta
	 *            parametro ipConsulta a actualizar ipConsulta
	 */
	public void setIpUsuarioConsulta(String ipUsuarioConsulta) {
		this.ipUsuarioConsulta = ipUsuarioConsulta;
	}

	/**
	 * @return el atributo archivoProcesar
	 */
	public MultipartFile getArchivoProcesar() {
		return archivoProcesar;
	}

	/**
	 * @param archivoProcesar
	 *            parametro archivoProcesar a actualizar
	 */
	public void setArchivoProcesar(MultipartFile archivoProcesar) {
		this.archivoProcesar = archivoProcesar;
	}

	/**
	 * @return el atributo tipoArchivo
	 */
	public String getTipoArchivo() {
		return tipoArchivo;
	}

	/**
	 * @param tipoArchivo
	 *            parametro tipoArchivo a actualizar
	 */
	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	/**
	 * @return el atributo reporte
	 */
	public String getReporte() {
		return reporte;
	}

	/**
	 * @param reporte
	 *            parametro reporte a actualizar
	 */
	public void setReporte(String reporte) {
		this.reporte = reporte;
	}

	/**
	 * @return el atributo tipoReporteMasivo
	 */
	public String getTipoReporteMasivo() {
		return tipoReporteMasivo;
	}

	/**
	 * @param tipoReporteMasivo
	 *            parametro tipoReporteMasivo a actualizar
	 */
	public void setTipoReporteMasivo(String tipoReporteMasivo) {
		this.tipoReporteMasivo = tipoReporteMasivo;
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
		builder.append("DatosConsultaPlataformaServicios [fechaInicial=");
		builder.append(fechaInicial);
		builder.append(", fechaFinal=");
		builder.append(fechaFinal);
		builder.append(", archivoProcesar=");
		builder.append(archivoProcesar);
		builder.append(", tipoArchivo=");
		builder.append(tipoArchivo);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", modulo=");
		builder.append(modulo);
		builder.append(", proceso=");
		builder.append(proceso);
		builder.append(", subProceso=");
		builder.append(subProceso);
		builder.append(", idProcesar=");
		builder.append(idProcesar);
		builder.append(", fechaInicialEjec=");
		builder.append(fechaInicialEjec);
		builder.append(", fechaFinalEjec=");
		builder.append(fechaFinalEjec);
		builder.append(", usuarioConsulta=");
		builder.append(usuarioConsulta);
		builder.append(", ipUsuarioConsulta=");
		builder.append(ipUsuarioConsulta);
		builder.append("]");
		return builder.toString();
	}

}