package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Mapeado a la tabla RETI_TC_DIAGNOSTICO
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Mar 6, 2019
 */
public class Diagnostico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * identificador
	 */
	private Long idDiagnostico;

	/**
	 * Clave única del diagnóstico.
	 */
	private String codigoDiagnostico;

	/**
	 * Clave única del proceso.
	 */
	private String claveProceso;
	/**
	 * Clave única del catálogo de tipos de operación.
	 */
	private String claveTipoOperacion;
	/**
	 * Clave única de la entidad origen.
	 */
	private String claveTipoEntidad;
	/**
	 * Descripción del diagnóstico.
	 */
	private String descDiagnostico;
	/**
	 * Campo que identifica si en diagnóstico esta activo a no. 0 No Activo 1
	 * Activo
	 */
	private int activo;
	/**
	 * Observaciones del diagnostico.
	 */
	private String observacionesDiagnostico;
	/**
	 * Fecha de última modificación del registro
	 */
	private Date fechaModificacion;
	/**
	 * Usuario/Programa o Ente que hizo la última modificación del registro.
	 */
	private String usuarioModificador;
	/**
	 * Código interno de identificación de diagnóstico.
	 */
	private String codigoInternoDiagnostico;

	public Diagnostico() {

	}

	/**
	 * Constructor para query de busqueda
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param id
	 * @param diagnostico
	 * @param descDiagnostico
	 */
	public Diagnostico(Long idDiagnostico, String diagnostico, String descDiagnostico) {
		this.idDiagnostico = idDiagnostico;
		this.codigoDiagnostico = diagnostico;
		this.descDiagnostico = descDiagnostico;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return el id del Diagnostico
	 */
	public Long getIdDiagnostico() {
		return idDiagnostico;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param id
	 *            del diagnostico
	 */
	public void setIdDiagnostico(Long idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Clave única del proceso.
	 */
	public String getClaveProceso() {
		return claveProceso;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Clave
	 *            única del proceso.
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Clave única del catálogo de tipos de operación.
	 */
	public String getClaveTipoOperacion() {
		return claveTipoOperacion;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Clave
	 *            única del catálogo de tipos de operación.
	 */
	public void setClaveTipoOperacion(String claveTipoOperacion) {
		this.claveTipoOperacion = claveTipoOperacion;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Clave única de la entidad origen.
	 */
	public String getClaveTipoEntidad() {
		return claveTipoEntidad;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Clave
	 *            única de la entidad origen.
	 */
	public void setClaveTipoEntidad(String claveTipoEntidad) {
		this.claveTipoEntidad = claveTipoEntidad;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Descripción del diagnóstico.
	 */
	public String getDescDiagnostico() {
		return descDiagnostico;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Descripción
	 *            del diagnóstico.
	 */
	public void setDescDiagnostico(String descDiagnostico) {
		this.descDiagnostico = descDiagnostico;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return identifica si en diagnóstico esta activo a no. 0 No Activo 1
	 *         Activo
	 */
	public int getActivo() {
		return activo;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param identifica
	 *            si en diagnóstico esta activo a no. 0 No Activo 1 Activo
	 */
	public void setActivo(int activo) {
		this.activo = activo;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Observaciones del diagnostico.
	 */
	public String getObservacionesDiagnostico() {
		return observacionesDiagnostico;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Observaciones
	 *            del diagnostico.
	 */
	public void setObservacionesDiagnostico(String observacionesDiagnostico) {
		this.observacionesDiagnostico = observacionesDiagnostico;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Fecha de última modificación del registro
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Fecha
	 *            de última modificación del registro
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Usuario/Programa o Ente que hizo la última modificación del
	 *         registro.
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Usuario/Programa
	 *            o Ente que hizo la última modificación del registro.
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Código interno de identificación de diagnóstico.
	 */
	public String getCodigoInternoDiagnostico() {
		return codigoInternoDiagnostico;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Código
	 *            interno de identificación de diagnóstico.
	 */
	public void setCodigoInternoDiagnostico(String codigoInternoDiagnostico) {
		this.codigoInternoDiagnostico = codigoInternoDiagnostico;
	}

	/**
	 * Obtencion codigo_diagnostico
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return
	 */
	public String getCodigoDiagnostico() {
		return codigoDiagnostico;
	}

	/**
	 * set codigo_diagnostico
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param codigoDiagnostico
	 */
	public void setCodigoDiagnostico(String codigoDiagnostico) {
		this.codigoDiagnostico = codigoDiagnostico;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Diagnostico [ idDiagnostico=");
		builder.append(idDiagnostico);
		builder.append(", diagnostico=");
		builder.append(codigoDiagnostico);
		builder.append(", claveProceso=");
		builder.append(claveProceso);
		builder.append(", claveTipoOperacion=");
		builder.append(claveTipoOperacion);
		builder.append(", claveTipoEntidad=");
		builder.append(claveTipoEntidad);
		builder.append(", descDiagnostico=");
		builder.append(descDiagnostico);
		builder.append(", activo=");
		builder.append(activo);
		builder.append(", observacionesDiagnostico");
		builder.append(observacionesDiagnostico);
		builder.append(", fechaModificacion=");
		builder.append(fechaModificacion);
		builder.append(", usuarioModificador");
		builder.append(usuarioModificador);
		builder.append(", codigoInternoDiagnostico=");
		builder.append(codigoInternoDiagnostico + " ]");

		return builder.toString();
	}
}
