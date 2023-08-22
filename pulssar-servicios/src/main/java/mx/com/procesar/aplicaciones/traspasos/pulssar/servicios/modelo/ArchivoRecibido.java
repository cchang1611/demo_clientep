/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * archivos recibidor para conformatr expediente o huellas para enrolar o verificar identidad del trabajador
 * @author jcgarces
 *
 */
public class ArchivoRecibido implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -1328235996935878190L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * clave de afore
	 */
	private String claveAfore;
	
	/**
	 * folio de la afore cliente
	 */
	private String folioCliente;
	
	/**
	 * folio pulssar
	 */
	private Folio folioPulsar;
	
	/**
	 * curp empleado
	 */
	private String curpEmpleado;
	
	/**
	 * curp trabajador
	 */
	private String curpTrabajador;
	
	/**
	 * tipo de archivo
	 */
	private CatalogoTipoArchivoRecibido tipoArchivo;
	
	/**
	 * ruta del archivo en el file system. la ruta es apartir del punto de montaje indicado en las propiedades
	 */
	private String rutaArchivo;
	
	/**
	 * tipo de proceso o expediente
	 */
	private String tipoProceso;

	/**
	 * resultado de la operacion
	 */
	private String resultadoOperacion;

	/**
	 * dignostico de rechazo
	 */
	private String diagnostico;
	
	/**
	 * dignostico de rechazo
	 */
	private String motivoRechazo;
	
	/**
	 * etapa del proceso
	 */
	private EtapaArchivoRecibido etapa;
	
	/**
	 * fecha de operacion del archivo
	 */
	private List<String> fechaOperacion;
	
	/**
	 * folio de proceso del expediente
	 */
	private String folio;
	
	/**
	 * folio recibido en la peticion
	 */
	private String folioProcesarRecibido;
	
	/**
	 * tipo de archivo recibido ern la peticion
	 */
	private String tipoArchivoRecibido;
	
	
	/**
	 * documentos del expediente
	 */
	@JsonIgnore
	private List<RevisionVisualIdentificacion> revisionManual;
	
	/**
	 * respuesta validacion identificacion
	 */
	@JsonIgnore
	private List<ValidacionIdentificacion> validacionIdentificacion;
	
	/**
	 * respuesta validacion identificacion
	 */
	@JsonIgnore
	private List<ValidacionDomicilio> validacionDomiclio;
	
	/**
	 * fecha de control
	 */
	private List<String> fechaControl;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the curpEmpleado
	 */
	public String getCurpEmpleado() {
		return curpEmpleado;
	}

	/**
	 * @param curpEmpleado the curpEmpleado to set
	 */
	public void setCurpEmpleado(String curpEmpleado) {
		this.curpEmpleado = curpEmpleado;
	}

	/**
	 * @return the curpTrabajador
	 */
	public String getCurpTrabajador() {
		return curpTrabajador;
	}

	/**
	 * @param curpTrabajador the curpTrabajador to set
	 */
	public void setCurpTrabajador(String curpTrabajador) {
		this.curpTrabajador = curpTrabajador;
	}

	/**
	 * @return the tipoArchivo
	 */
	public CatalogoTipoArchivoRecibido getTipoArchivo() {
		return tipoArchivo;
	}

	/**
	 * @param tipoArchivo the tipoArchivo to set
	 */
	public void setTipoArchivo(CatalogoTipoArchivoRecibido tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	/**
	 * @return the rutaArchivo
	 */
	public String getRutaArchivo() {
		return rutaArchivo;
	}

	/**
	 * @param rutaArchivo the rutaArchivo to set
	 */
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	/**
	 * @return the tipoProceso
	 */
	public String getTipoProceso() {
		return tipoProceso;
	}

	/**
	 * @param tipoProceso the tipoProceso to set
	 */
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	/**
	 * @return the fechaControl
	 */
	public List<String> getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(List<String> fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return the resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * @param resultadoOperacion the resultadoOperacion to set
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	/**
	 * @return the diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @param motivoRechazo the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * @return the etapa
	 */
	public EtapaArchivoRecibido getEtapa() {
		return etapa;
	}

	/**
	 * @param etapa the etapa to set
	 */
	public void setEtapa(EtapaArchivoRecibido etapa) {
		this.etapa = etapa;
	}

	/**
	 * @return the fechaOperacion
	 */
	public List<String> getFechaOperacion() {
		return fechaOperacion;
	}

	/**
	 * @param fechaOperacion the fechaOperacion to set
	 */
	public void setFechaOperacion(List<String> fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the folioPulsar
	 */
	public Folio getFolioPulsar() {
		if(folioPulsar == null) {
			folioPulsar = new Folio();
		}
		return folioPulsar;
	}

	/**
	 * @param folioPulsar the folioPulsar to set
	 */
	public void setFolioPulsar(Folio folioPulsar) {
		this.folioPulsar = folioPulsar;
	}

	/**
	 * @return the folioCliente
	 */
	public String getFolioCliente() {
		return folioCliente;
	}

	/**
	 * @param folioCliente the folioCliente to set
	 */
	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
	}

	/**
	 * @return the revisionManual
	 */
	public List<RevisionVisualIdentificacion> getRevisionManual() {
		if(revisionManual == null) {
			revisionManual = new ArrayList<>();
		}
		return revisionManual;
	}

	/**
	 * @param revisionManual the revisionManual to set
	 */
	public void setRevisionManual(List<RevisionVisualIdentificacion> revisionManual) {
		this.revisionManual = revisionManual;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArchivoRecibido [id=");
		builder.append(id);
		builder.append(", claveAfore=");
		builder.append(claveAfore);
		builder.append(", folioCliente=");
		builder.append(folioCliente);
		builder.append(", folioPulsar=");
		builder.append(folioPulsar);
		builder.append(", curpEmpleado=");
		builder.append(curpEmpleado);
		builder.append(", curpTrabajador=");
		builder.append(curpTrabajador);
		builder.append(", tipoArchivo=");
		builder.append(tipoArchivo);
		builder.append(", rutaArchivo=");
		builder.append(rutaArchivo);
		builder.append(", tipoProceso=");
		builder.append(tipoProceso);
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", motivoRechazo=");
		builder.append(motivoRechazo);
		builder.append(", etapa=");
		builder.append(etapa);
		builder.append(", fechaOperacion=");
		builder.append(fechaOperacion);
		builder.append(", folio=");
		builder.append(folio);
		builder.append(", folioProcesarRecibido=");
		builder.append(folioProcesarRecibido);
		builder.append(", tipoArchivoRecibido=");
		builder.append(tipoArchivoRecibido);
		builder.append(", revisionManual=");
		builder.append(revisionManual);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the folioProcesarRecibido
	 */
	public String getFolioProcesarRecibido() {
		return folioProcesarRecibido;
	}

	/**
	 * @param folioProcesarRecibido the folioProcesarRecibido to set
	 */
	public void setFolioProcesarRecibido(String folioProcesarrecibido) {
		this.folioProcesarRecibido = folioProcesarrecibido;
	}

	/**
	 * @return the tipoArchivoRecibido
	 */
	public String getTipoArchivoRecibido() {
		return tipoArchivoRecibido;
	}

	/**
	 * @param tipoArchivoRecibido the tipoArchivoRecibido to set
	 */
	public void setTipoArchivoRecibido(String tipoArchivoRecibido) {
		this.tipoArchivoRecibido = tipoArchivoRecibido;
	}
	
	
}
