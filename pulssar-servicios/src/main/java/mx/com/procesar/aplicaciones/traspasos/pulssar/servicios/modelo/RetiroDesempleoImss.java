package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 * Mapeo de la tabla NSAR_TR_TELEFONO
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class RetiroDesempleoImss<T> implements Serializable {

	/**
	 * Serializacion 
	 */
	private static final long serialVersionUID = 225410093923765789L;

	/**
	 * Identificador selloTrabajador
	 */
	private String selloTrabajador;
	/**
	 * Identificador sbcTipoA
	 */
	private String sbcTipoA;
	/**
	 * Identificador sbcTipoB
	 */
	private String sbcTipoB;
	
	/**
	 * numero Resolucion
	 */
	private String numeroResolucion;
	/**
	 * Resultado Operacion
	 */
	private String resultadoOperacion;
	/**
	 * mensaje Operacion
	 */
	private String mensajeOperacion;
	/**
	 * CUS
	 */
	private String cus;
	
	/**
	 * tipo expediente
	 */
	private String tipoExpediente;
	
	/**
	 * mapa con los nombres de archivos para el zip
	 */
	private Map<String, String> nombreArchivo;
	
	/**
	 * folio asignado
	 */
	private String folio;
	
	/**
	 * idfolio asignado
	 */
	private Long idFolio;
	
	/**
	 * Diagagnosticp
	 */
	private String diagnostico;
	/**
	 * telefonia
	 */
	private String telefonia;
	
	/**
	 * peticion07
	 */
	private ProcesoPendienteEntrada<T> peticion07;
	/**
	 * peticion12
	 */
	private ProcesoPendienteEntrada<SolicitudDisposicionParcial> peticion12;
	
	/**
	 * origen de solicitud
	 */
	private String origen;
	
	/**
	 * @return
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * @param origen
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	/**
	 * Folio Operacion 12
	 */
	private FolioEntrada folio12;
	/**
	 * @return el atributo selloTrabajador
	 */
	public String getSelloTrabajador() {
		return selloTrabajador;
	}
	/**
	 * @param selloTrabajador parametro selloTrabajador a actualizar
	 */
	public void setSelloTrabajador(String selloTrabajador) {
		this.selloTrabajador = selloTrabajador;
	}
	/**
	 * @return el atributo sbcTipoA
	 */
	public String getSbcTipoA() {
		return sbcTipoA;
	}
	/**
	 * @param sbcTipoA parametro sbcTipoA a actualizar
	 */
	public void setSbcTipoA(String sbcTipoA) {
		this.sbcTipoA = sbcTipoA;
	}
	/**
	 * @return el atributo sbcTipoB
	 */
	public String getSbcTipoB() {
		return sbcTipoB;
	}
	/**
	 * @param sbcTipoB parametro sbcTipoB a actualizar
	 */
	public void setSbcTipoB(String sbcTipoB) {
		this.sbcTipoB = sbcTipoB;
	}
	/**
	 * @return el atributo numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}
	/**
	 * @param numeroResolucion parametro numeroResolucion a actualizar
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}
	/**
	 * @return el atributo resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}
	/**
	 * @param resultadoOperacion parametro resultadoOperacion a actualizar
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}
	/**
	 * @return el atributo mensajeOperacion
	 */
	public String getMensajeOperacion() {
		return mensajeOperacion;
	}
	/**
	 * @param mensajeOperacion parametro mensajeOperacion a actualizar
	 */
	public void setMensajeOperacion(String mensajeOperacion) {
		this.mensajeOperacion = mensajeOperacion;
	}
	/**
	 * @return el atributo cus
	 */
	public String getCus() {
		return cus;
	}
	/**
	 * @param cus parametro cus a actualizar
	 */
	public void setCus(String cus) {
		this.cus = cus;
	}
	
	/**
	 * @return el atributo tipoExpediente
	 */
	public String getTipoExpediente() {
		return tipoExpediente;
	}
	
	/**
	 * @param tipoExpediente parametro tipoExpediente a actualizar
	 */
	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
	}
	
	/**
	 * @return el atributo nombreArchivo
	 */
	public Map<String, String> getNombreArchivo() {
		return nombreArchivo;
	}
	/**
	 * @param nombreArchivo parametro nombreArchivo a actualizar
	 */
	public void setNombreArchivo(Map<String, String> nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	/**
	 * @return el atributo folio
	 */
	public String getFolio() {
		return folio;
	}
	/**
	 * @param folio parametro folio a actualizar
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}
	/**
	 * @return el atributo idFolio
	 */
	public Long getIdFolio() {
		return idFolio;
	}
	/**
	 * @param idFolio parametro idFolio a actualizar
	 */
	public void setIdFolio(Long idFolio) {
		this.idFolio = idFolio;
	}
	/**
	 * @return el atributo diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}
	/**
	 * @param diagnostico parametro diagnostico a actualizar
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return the telefonia
	 */
	public String getTelefonia() {
		return telefonia;
	}
	/**
	 * @param telefonia the telefonia to set
	 */
	public void setTelefonia(String telefonia) {
		this.telefonia = telefonia;
	}
	
	/**
	 * @return
	 */
	public ProcesoPendienteEntrada<T> getPeticion07() {
		return peticion07;
	}
	/**
	 * @param peticion07
	 */
	public void setPeticion07(ProcesoPendienteEntrada<T> peticion07) {
		this.peticion07 = peticion07;
	}
	/**
	 * @return el atributo peticion12
	 */
	public ProcesoPendienteEntrada<SolicitudDisposicionParcial> getPeticion12() {
		return peticion12;
	}
	/**
	 * @param peticion12 parametro peticion12 a actualizar
	 */
	public void setPeticion12(ProcesoPendienteEntrada<SolicitudDisposicionParcial> peticion12) {
		this.peticion12 = peticion12;
	}
	/**
	 * @return el atributo folio12
	 */
	public FolioEntrada getFolio12() {
		return folio12;
	}
	/**
	 * @param folio12 parametro folio12 a actualizar
	 */
	public void setFolio12(FolioEntrada folio12) {
		this.folio12 = folio12;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}	
}
