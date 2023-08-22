package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 *  Datos Diagnpostico
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since May 17, 2021
 */
public class DatosDiagnostico implements Serializable{

	/**
	 * TODO [Agregar documentación del atributo]
	 */
	private static final long serialVersionUID = 292579724107035263L;

	/**
	 * identificador
	 */
	private Long id;
	/**
	 * Clave única del diagnóstico.
	 */
	private String diagnostico;
	/**
	 * Clave única del proceso.
	 */
	private String claveProceso;
	/**
	 * Clave única del catálogo de tipos de operación.
	 */
	private String claveTipoOperacion;
	/**
	 * Descripción del diagnóstico.
	 */
	private String  descDiagnostico;
	
	/**
	 * Codigo interno Diagnostico.
	 */
	private String codigoInternoDiagnostico;
	/**
	 * mensajes de error o informativos
	 */
	private String mensaje;
	/**
	 * @return el atributo id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return el atributo claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}
	/**
	 * @param claveProceso parametro claveProceso a actualizar
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}
	/**
	 * @return el atributo claveTipoOperacion
	 */
	public String getClaveTipoOperacion() {
		return claveTipoOperacion;
	}
	/**
	 * @param claveTipoOperacion parametro claveTipoOperacion a actualizar
	 */
	public void setClaveTipoOperacion(String claveTipoOperacion) {
		this.claveTipoOperacion = claveTipoOperacion;
	}
	/**
	 * @return el atributo descDiagnostico
	 */
	public String getDescDiagnostico() {
		return descDiagnostico;
	}
	/**
	 * @param descDiagnostico parametro descDiagnostico a actualizar
	 */
	public void setDescDiagnostico(String descDiagnostico) {
		this.descDiagnostico = descDiagnostico;
	}
	/**
	 * @return el atributo codigoInternoDiagnostico
	 */
	public String getCodigoInternoDiagnostico() {
		return codigoInternoDiagnostico;
	}
	/**
	 * @param codigoInternoDiagnostico parametro codigoInternoDiagnostico a actualizar
	 */
	public void setCodigoInternoDiagnostico(String codigoInternoDiagnostico) {
		this.codigoInternoDiagnostico = codigoInternoDiagnostico;
	}
	/**
	 * @return el atributo mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje parametro mensaje a actualizar
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosDiagnostico [id=");
		builder.append(id);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", claveProceso=");
		builder.append(claveProceso);
		builder.append(", claveTipoOperacion=");
		builder.append(claveTipoOperacion);
		builder.append(", descDiagnostico=");
		builder.append(descDiagnostico);
		builder.append(", codigoInternoDiagnostico=");
		builder.append(codigoInternoDiagnostico);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
