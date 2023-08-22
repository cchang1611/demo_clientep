/**
 * SalidaConsultaVisorExpedienteMovil.java
 * Fecha de creación: Feb 16, 2021 9:01:32 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class SalidaConsultaVisorExpedienteMovil implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = -2196489537446956765L;

	/**
	 * Atributo salida
	 */
	private byte[] archivo;

	/**
	 * Atributo resultadoOperacion
	 */
	private String resultadoOperacion;

	/**
	 * Atributo diagnostico
	 */
	private String diagnostico;

	/**
	 * Atributo descripcion
	 */
	private String descripcion;
		
	/**
	 * Atributo detalleExpedientes
	 */
	private DetalleExpedientes[]  detalleExpedientes;
	
	/**
	 * Atributo detalleExpedientes
	 */
	private List<Imagen>  listaImagenes;
	
	/**
	 * Atributo detalleExpedientes
	 */
	private String  mensajeError;


	/**
	 * Atributo detalleExpedientes
	 */
	private String  nombreExpediente;

	/**
	 * Obtener archivo
	 */
	public byte[] getArchivo() {
		return archivo;
	}

	/**
	 * Setear archivo
	 */
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	/**
	 * Obtener resultadoOperacion
	 */
	public String getResultadoOperacion() {
		return resultadoOperacion;
	}

	/**
	 * Setear resultadoOperacion
	 */
	public void setResultadoOperacion(String resultadoOperacion) {
		this.resultadoOperacion = resultadoOperacion;
	}

	/**
	 * Obtener diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * Setear diagnostico
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * Obtener descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setear descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtener serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Obtener detalleExpedientes
	 */
	public DetalleExpedientes[] getDetalleExpedientes() {
		return detalleExpedientes;
	}

	/**
	 * Setear detalleExpedientes
	 */
	public void setDetalleExpedientes(DetalleExpedientes[] detalleExpedientes) {
		this.detalleExpedientes = detalleExpedientes;
	}
	
	
	/**
	 * @return the listaImagenes
	 */
	public List<Imagen> getListaImagenes() {
		return listaImagenes;
	}

	/**
	 * @param listaImagenes the listaImagenes to set
	 */
	public void setListaImagenes(List<Imagen> listaImagenes) {
		this.listaImagenes = listaImagenes;
	}

	/**
	 * @return the mensajeError
	 */
	public String getMensajeError() {
		return mensajeError;
	}

	/**
	 * @param mensajeError the mensajeError to set
	 */
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

	
	/**
	 * @return the nombreExpediente
	 */
	public String getNombreExpediente() {
		return nombreExpediente;
	}

	/**
	 * @param nombreExpediente the nombreExpediente to set
	 */
	public void setNombreExpediente(String nombreExpediente) {
		this.nombreExpediente = nombreExpediente;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalidaConsultaVisorExpedienteMovil [archivo=");
		builder.append(Arrays.toString(archivo));
		builder.append(", resultadoOperacion=");
		builder.append(resultadoOperacion);
		builder.append(", diagnostico=");
		builder.append(diagnostico);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", detalleExpedientes=");
		builder.append(Arrays.toString(detalleExpedientes));
		builder.append(", listaImagenes=");
		builder.append(listaImagenes);
		builder.append(", mensajeError=");
		builder.append(mensajeError);
		builder.append(", nombreExpediente=");
		builder.append(nombreExpediente);
		builder.append("]");
		return builder.toString();
	}
	
	

}