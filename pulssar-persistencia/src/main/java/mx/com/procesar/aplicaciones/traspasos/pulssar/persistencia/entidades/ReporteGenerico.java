package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Definicion de entidad catalogo de reportes
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 09:50:04
 */
@Entity
@Table(name = "PSER_TC_REPORTE_GENERICO")
public class ReporteGenerico implements Serializable {

	/**
	 * identificador de serializacion
	 */
	private static final long serialVersionUID = 5021842583052073757L;

	/**
	 * Identificador unico del reporte
	 */
	@Id
	@Column(name = "ID_REPORTE_GENERICO")
	private Long idReporteGenerico;

	/**
	 * CLave del subproceso
	 */
	@Column(name = "ID_SUBPROCESO")
	private Long idSubproceso;

	/**
	 * Identificador de tipo de reporte
	 */
	@Column(name = "ID_TIPO_REPORTE")
	private Long idTipoReporte;

	/**
	 * Descripción del Reporte
	 */
	@Column(name = "CH_NOMBRE_REPORTE")
	private String nombreReporte;

	/**
	 * estado del reporte: 1 Activo 0 Inactivo
	 */
	@Column(name = "NU_ACTIVO")
	private int estado;

	/**
	 * Consulta a ejecutar para generar reporte
	 */
	@Column(name = "CH_CONSULTA")
	private String consulta;

	/**
	 * Definicion de esquema de consulta
	 */
	@Column(name = "CH_ESQUEMA")
	private String esquema;

	/**
	 * Encabezado del reporte
	 */
	@Column(name = "CH_ENCABEZADO")
	private String encabezado;

	/**
	 * Identificador NSS.
	 */
	@Column(name = "NU_FILTRO_NSS")
	private int filtroNss;

	/**
	 * Identificador CURP.
	 */
	@Column(name = "NU_FILTRO_CURP")
	private int filtroCurp;

	/**
	 * Identificador de filtro por rango de fechas
	 */
	@Column(name = "NU_FILTRO_RANGO_FC")
	private int filtroRangoFechas;

	/**
	 * Identificador de filtro por id_procesar
	 */
	@Column(name = "NU_FILTRO_ID_PROCESAR")
	private int filtroIdProcesar;

	/**
	 * Fecha de ultima modificación
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcControl;

	/**
	 * Usuario de ultima modificación
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String chUsuarioModificador;

	/**
	 * ID del reporte padre
	 */
	@Column(name = "ID_REPORTE_GENERICO_PADRE")
	private Long idReportePadre;

	/**
	 * Orden de ejecucion
	 */
	@Column(name = "NU_ORDEN")
	private int orden;

	/**
	 * Nombre del archivo reporte
	 */
	@Column(name = "CH_NOMBRE_ARCHIVO_REPORTE")
	private String nombreArchivoJasper;
	
	/**
	 * Valor URL
	 */
	@Column(name = "CH_URL")
	private String urlReporte;

	/**
	 * Constructor sin argumentos
	 * 
	 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
	 */
	public ReporteGenerico() {
		// Constructor vacio
	}

	/**
	 * @return el atributo idReporteGenerico
	 */
	public Long getIdReporteGenerico() {
		return idReporteGenerico;
	}

	/**
	 * @param idReporteGenerico
	 *            parametro idReporteGenerico a actualizar
	 */
	public void setIdReporteGenerico(Long idReporteGenerico) {
		this.idReporteGenerico = idReporteGenerico;
	}

	/**
	 * @return el atributo idSubproceso
	 */
	public Long getIdSubproceso() {
		return idSubproceso;
	}

	/**
	 * @param idSubproceso
	 *            parametro idSubproceso a actualizar
	 */
	public void setIdSubproceso(Long idSubproceso) {
		this.idSubproceso = idSubproceso;
	}

	/**
	 * @return el atributo idTipoReporte
	 */
	public Long getIdTipoReporte() {
		return idTipoReporte;
	}

	/**
	 * @param idTipoReporte
	 *            parametro idTipoReporte a actualizar
	 */
	public void setIdTipoReporte(Long idTipoReporte) {
		this.idTipoReporte = idTipoReporte;
	}

	/**
	 * @return el atributo nombreReporte
	 */
	public String getNombreReporte() {
		return nombreReporte;
	}

	/**
	 * @param nombreReporte
	 *            parametro nombreReporte a actualizar
	 */
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}

	/**
	 * @return el atributo estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            parametro estado a actualizar
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * @return el atributo consulta
	 */
	public String getConsulta() {
		return consulta;
	}

	/**
	 * @param consulta
	 *            parametro consulta a actualizar
	 */
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	/**
	 * @return el atributo encabezado
	 */
	public String getEncabezado() {
		return encabezado;
	}

	/**
	 * @param encabezado
	 *            parametro encabezado a actualizar
	 */
	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}

	/**
	 * @return el atributo filtroNss
	 */
	public int getFiltroNss() {
		return filtroNss;
	}

	/**
	 * @param filtroNss
	 *            parametro filtroNss a actualizar
	 */
	public void setFiltroNss(int filtroNss) {
		this.filtroNss = filtroNss;
	}

	/**
	 * @return el atributo filtroCurp
	 */
	public int getFiltroCurp() {
		return filtroCurp;
	}

	/**
	 * @param filtroCurp
	 *            parametro filtroCurp a actualizar
	 */
	public void setFiltroCurp(int filtroCurp) {
		this.filtroCurp = filtroCurp;
	}

	/**
	 * @return el atributo filtroRangoFechas
	 */
	public int getFiltroRangoFechas() {
		return filtroRangoFechas;
	}

	/**
	 * @param filtroRangoFechas
	 *            parametro filtroRangoFechas a actualizar
	 */
	public void setFiltroRangoFechas(int filtroRangoFechas) {
		this.filtroRangoFechas = filtroRangoFechas;
	}

	/**
	 * @return el atributo filtroIdProcesar
	 */
	public int getFiltroIdProcesar() {
		return filtroIdProcesar;
	}

	/**
	 * @param filtroIdProcesar
	 *            parametro filtroIdProcesar a actualizar
	 */
	public void setFiltroIdProcesar(int filtroIdProcesar) {
		this.filtroIdProcesar = filtroIdProcesar;
	}

	/**
	 * @return el atributo fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl
	 *            parametro fcControl a actualizar
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/**
	 * @return el atributo chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * @param chUsuarioModificador
	 *            parametro chUsuarioModificador a actualizar
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}

	/**
	 * @return el atributo esquema
	 */
	public String getEsquema() {
		return esquema;
	}

	/**
	 * @param esquema
	 *            parametro esquema a actualizar
	 */
	public void setEsquema(String esquema) {
		this.esquema = esquema;
	}

	/**
	 * @return the orden
	 */
	public int getOrden() {
		return orden;
	}

	/**
	 * @param orden
	 *            the orden to set
	 */
	public void setOrden(int orden) {
		this.orden = orden;
	}

	/**
	 * @return the nombreArchivoJasper
	 */
	public String getNombreArchivoJasper() {
		return nombreArchivoJasper;
	}

	/**
	 * @param nombreArchivoJasper
	 *            the nombreArchivoJasper to set
	 */
	public void setNombreArchivoJasper(String nombreArchivoJasper) {
		this.nombreArchivoJasper = nombreArchivoJasper;
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
		builder.append("ReporteGenerico [idReporteGenerico=");
		builder.append(idReporteGenerico);
		builder.append(", idSubproceso=");
		builder.append(idSubproceso);
		builder.append(", idTipoReporte=");
		builder.append(idTipoReporte);
		builder.append(", nombreReporte=");
		builder.append(nombreReporte);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", consulta=");
		builder.append(consulta);
		builder.append(", esquema=");
		builder.append(esquema);
		builder.append(", encabezado=");
		builder.append(encabezado);
		builder.append(", filtroNss=");
		builder.append(filtroNss);
		builder.append(", filtroCurp=");
		builder.append(filtroCurp);
		builder.append(", filtroRangoFechas=");
		builder.append(filtroRangoFechas);
		builder.append(", filtroIdProcesar=");
		builder.append(filtroIdProcesar);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", idReportePadre=");
		builder.append(idReportePadre);
		builder.append(", orden=");
		builder.append(orden);
		builder.append(", nombreArchivoJasper=");
		builder.append(nombreArchivoJasper);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the idReportePadre
	 */
	public Long getIdReportePadre() {
		return idReportePadre;
	}

	/**
	 * @param idReportePadre the idReportePadre to set
	 */
	public void setIdReportePadre(Long idReportePadre) {
		this.idReportePadre = idReportePadre;
	}

	/**
	 * @return the urlReporte
	 */
	public String getUrlReporte() {
		return urlReporte;
	}

	/**
	 * @param urlReporte the urlReporte to set
	 */
	public void setUrlReporte(String urlReporte) {
		this.urlReporte = urlReporte;
	}

}