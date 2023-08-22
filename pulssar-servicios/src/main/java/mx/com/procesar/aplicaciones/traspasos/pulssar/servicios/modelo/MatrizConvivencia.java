/**
 * MatrizConvivencia.java
 * Fecha de creación: Dec 1, 2020 4:06:52 PM
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
import java.util.Date;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class MatrizConvivencia implements Serializable {

	/**
	 * Atributo serialVersionUID
	 */
	private static final long serialVersionUID = 484392757523964259L;
	
	/**
	 * Identificador de la llave primaria
	 */
	private Long identificadorMatriz;

	/**
	 * Estado de la convivencia
	 */
	private String estado;

	/**
	 * Fecha control
	 */
	private Date fecha;

	/**
	 * Usuario modificador
	 */
	private String usuario;

	/**
	 * Clave del motivo del resultado
	 */
	private String claveMotivoResultado;

	/**
	 * Resultado de la convivencia
	 */
	private String resultado;

	/**
	 * Tipo Proceso Actual
	 */
	private TipoProceso tipoProcesoActual;

	/**
	 * Tipo Proceso Entrante
	 */
	private TipoProceso tipoProcesoEntrante;

	/**
	 * Obtener identificadorMatriz
	 */
	public Long getIdentificadorMatriz() {
		return identificadorMatriz;
	}

	/**
	 * Setear identificadorMatriz
	 */
	public void setIdentificadorMatriz(Long identificadorMatriz) {
		this.identificadorMatriz = identificadorMatriz;
	}

	/**
	 * Obtener estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Setear estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Obtener fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Setear fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtener usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Setear usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtener claveMotivoResultado
	 */
	public String getClaveMotivoResultado() {
		return claveMotivoResultado;
	}

	/**
	 * Setear claveMotivoResultado
	 */
	public void setClaveMotivoResultado(String claveMotivoResultado) {
		this.claveMotivoResultado = claveMotivoResultado;
	}

	/**
	 * Obtener resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * Setear resultado
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * Obtener tipoProcesoActual
	 */
	public TipoProceso getTipoProcesoActual() {
		return tipoProcesoActual;
	}

	/**
	 * Setear tipoProcesoActual
	 */
	public void setTipoProcesoActual(TipoProceso tipoProcesoActual) {
		this.tipoProcesoActual = tipoProcesoActual;
	}

	/**
	 * Obtener tipoProcesoEntrante
	 */
	public TipoProceso getTipoProcesoEntrante() {
		return tipoProcesoEntrante;
	}

	/**
	 * Setear tipoProcesoEntrante
	 */
	public void setTipoProcesoEntrante(TipoProceso tipoProcesoEntrante) {
		this.tipoProcesoEntrante = tipoProcesoEntrante;
	}

	/**
	 * Obtener serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/* La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MatrizConvivencia [identificadorMatriz=");
		builder.append(identificadorMatriz);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", claveMotivoResultado=");
		builder.append(claveMotivoResultado);
		builder.append(", resultado=");
		builder.append(resultado);
		builder.append(", tipoProcesoActual=");
		builder.append(tipoProcesoActual);
		builder.append(", tipoProcesoEntrante=");
		builder.append(tipoProcesoEntrante);
		builder.append("]");
		return builder.toString();
	}

}
