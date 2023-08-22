package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * clase que contiene los atributos de Salida del servicio solicitud disposicion
 * parcial
 * 
 * @author OJBALBUE
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SolicitudDisposicionParcialRespuesta implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * resultado Operacion
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String resultadoOperacion;

    /**
     * Atributo diagnostico Registro Procesar
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String diagnosticoProcesar;

    /**
     * Atributo descripción diagnostico Registro Procesar
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String descripcion;

    /**
     * nss
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String nss;

    /**
     * Atributo numero Resolucion
     */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String numeroResolucion;

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
	 * @return el atributo diagnosticoProcesar
	 */
	public String getDiagnosticoProcesar() {
		return diagnosticoProcesar;
	}

	/**
	 * @param diagnosticoProcesar parametro diagnosticoProcesar a actualizar
	 */
	public void setDiagnosticoProcesar(String diagnosticoProcesar) {
		this.diagnosticoProcesar = diagnosticoProcesar;
	}

	/**
	 * @return el atributo descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion parametro descripcion a actualizar
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss parametro nss a actualizar
	 */
	public void setNss(String nss) {
		this.nss = nss;
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

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SolicitudDisposicionParcialRespuesta [resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", diagnosticoProcesar=");
		builder.append(diagnosticoProcesar);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append("]");
		return builder.toString();
	}
	
}
