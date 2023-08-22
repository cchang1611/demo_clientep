/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * Respuesta del servicio de registro de expediente
 * @author jcgarces
 *
 */
public class RespuestaExpediente implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7117893342217747877L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * id del archivo recibido
	 */
	private Long idArchivoRecibido;
	
	/**
	 * nombre del archivo
	 */
	private Long numeroDocumentosRechazados;

	/**
	 * clave d ediagnostico
	 */
	private String diagnostico;

	/**
	 * estatus
	 */
	private Integer estatus;
	
	/**
	 * respuesta de los expedientes
	 */
	private List<RespuestaExpedienteDetalle> expedientes;
	
	/**
	 * documentos rechazados
	 */
	private List<DocumentoRechazado> documentosRechazados;

	/**
	 * fecha de control
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaControl;
	
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
	 * @return the idArchivoRecibido
	 */
	public Long getIdArchivoRecibido() {
		return idArchivoRecibido;
	}

	/**
	 * @param idArchivoRecibido the idArchivoRecibido to set
	 */
	public void setIdArchivoRecibido(Long idArchivoRecibido) {
		this.idArchivoRecibido = idArchivoRecibido;
	}

	/**
	 * @return the numeroDocumentosRechazados
	 */
	public Long getNumeroDocumentosRechazados() {
		return numeroDocumentosRechazados;
	}

	/**
	 * @param numeroDocumentosRechazados the numeroDocumentosRechazados to set
	 */
	public void setNumeroDocumentosRechazados(Long numeroDocumentosRechazados) {
		this.numeroDocumentosRechazados = numeroDocumentosRechazados;
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
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
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
	 * @return the expedientes
	 */
	public List<RespuestaExpedienteDetalle> getExpedientes() {
		if(this.expedientes == null) {
			this.expedientes = new ArrayList<>();
		}
		return expedientes;
	}

	/**
	 * @param expedientes the expedientes to set
	 */
	public void setExpedientes(List<RespuestaExpedienteDetalle> expedientes) {
		for(RespuestaExpedienteDetalle actual : expedientes) {
			agregarExpediente(actual);
		}
		
	}
	
	/**
	 * agrega un expediente a la lista
	 */
	public void agregarExpediente(RespuestaExpedienteDetalle expediente) {
		if(!getExpedientes().contains(expediente) && expediente != null && !StringUtils.isEmpty(expediente.getNombre()) ) {
			getExpedientes().add(expediente);
		}
		
	}

	/**
	 * @return the documentosRechazados
	 */
	public List<DocumentoRechazado> getDocumentosRechazados() {
		if(documentosRechazados == null) {
			documentosRechazados = new ArrayList<>();
		}
		return documentosRechazados;
	}

	/**
	 * @param documentosRechazados the documentosRechazados to set
	 */
	public void setDocumentosRechazados(List<DocumentoRechazado> documentosRechazados) {
		
		this.documentosRechazados = documentosRechazados;
	}
	
	/**
	 * agrega un documento rechazado a la lista
	 * @param documentoRechazado
	 */
	public void agregarDocumentoRechazado(DocumentoRechazado documentoRechazado) {
		if(documentoRechazado != null && !getDocumentosRechazados().contains(documentoRechazado)) {
			documentoRechazado.setRespuestaExpediente(this);
			getDocumentosRechazados().add(documentoRechazado);
		}
		
	}

}
