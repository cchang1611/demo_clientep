package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CalculoTipoRetiro implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -8475756823528791234L;
	/**
	 * sbc TipoA salarioBaseCotizacion
	 */
	private String sbcTipoA;
	/**
	 * sbcTipoB
	 */
	private String sbcTipoB;
	/**
	 * montoADisponer sbcTipoA * 30 ( UMA * 10 )
	 */
	private String montoADisponerA;
	/**
	 * montoADisponer sbcTipob * 90
	 */
	private String montoADisponerB;
	/**
	 * uma parametro
	 */
	private String uma;

	/**
	 * calculoA
	 */
	private String calculoA;
	/**
	 * calculoSBC
	 */
	private String calculoB;
	/**
	 * calculoPorcentaje
	 */
	private String calculoPorcentaje;

	/**
	 * saldos
	 */
	private List<String> seisMensualidades;
	
	/**
	 * primerMensualidad
	 */
	private List<String> dosMensualidades;
	
	/**
	 * seis mensualidades iguales
	 */
	private List<String> seisMensualidadesIguales;
	
	/**
	 * una mensualidad
	 */
	private String unaMensualidad;	
	
	/**
	 * getSbcTipoA
	 * 
	 * @return
	 */
	public String getSbcTipoA() {
		return sbcTipoA;
	}

	/**
	 * setSbcTipoA
	 * 
	 * @param sbcTipoA
	 */
	public void setSbcTipoA(String sbcTipoA) {
		this.sbcTipoA = sbcTipoA;
	}

	/**
	 * getMontoADisponerA
	 * 
	 * @return
	 */
	public String getMontoADisponerA() {
		return truncarDecimal(montoADisponerA, 2);
	}

	/**
	 * setMontoADisponerA
	 * 
	 * @param montoADisponerA
	 */
	public void setMontoADisponerA(String montoADisponerA) {
		this.montoADisponerA = montoADisponerA;
	}

	/**
	 * getUma
	 * 
	 * @return
	 */
	public String getUma() {
		return uma;
	}

	/**
	 * setUma
	 * 
	 * @param uma
	 */
	public void setUma(String uma) {
		this.uma = uma;
	}

	/**
	 * getSbcTipoB
	 * 
	 * @return
	 */
	public String getSbcTipoB() {
		return sbcTipoB;
	}

	/**
	 * setSbcTipoB
	 * 
	 * @param sbcTipoB
	 */
	public void setSbcTipoB(String sbcTipoB) {
		this.sbcTipoB = sbcTipoB;
	}

	/**
	 * getMontoADisponerB
	 * 
	 * @return
	 */
	public String getMontoADisponerB() {
		return truncarDecimal(montoADisponerB, 2);
	}

	/**
	 * setMontoADisponerB
	 * 
	 * @param montoADisponerB
	 */
	public void setMontoADisponerB(String montoADisponerB) {
		this.montoADisponerB = montoADisponerB;
	}

	/**
	 * getCalculoA
	 * 
	 * @return
	 */
	public String getCalculoA() {
		return calculoA;
	}

	/**
	 * setCalculoA
	 * 
	 * @param calculoA
	 */
	public void setCalculoA(String calculoA) {
		this.calculoA = calculoA;
	}

	/**
	 * getCalculoB
	 * 
	 * @return
	 */
	public String getCalculoB() {
		return calculoB;
	}

	/**
	 * setCalculoB
	 * 
	 * @param calculoB
	 */
	public void setCalculoB(String calculoB) {
		this.calculoB = calculoB;
	}

	/**
	 * getCalculoPorcentaje
	 * @return
	 */
	public String getCalculoPorcentaje() {
		return calculoPorcentaje;
	}

	/**
	 * setCalculoPorcentaje
	 * @param calculoPorcentaje
	 */
	public void setCalculoPorcentaje(String calculoPorcentaje) {
		this.calculoPorcentaje = calculoPorcentaje;
	}

	/**
	 *  getSeisMensualidades
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public List<String> getSeisMensualidades() {
		return seisMensualidades;
	}

	/**
	 *  setSeisMensualidades
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param seisMensualidades
	 */
	public void setSeisMensualidades(List<String> seisMensualidades) {
		this.seisMensualidades = seisMensualidades;
	}

	/**
	 *  getDosMensualidades
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @return
	 */
	public List<String> getDosMensualidades() {
		return dosMensualidades;
	}

	/**
	 *  setDosMensualidades
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param dosMensualidades
	 */
	public void setDosMensualidades(List<String> dosMensualidades) {
		this.dosMensualidades = dosMensualidades;
	}

	/**
	 * @return el atributo seisMensualidadesIguales
	 */
	public List<String> getSeisMensualidadesIguales() {
		return seisMensualidadesIguales;
	}

	/**
	 * @param seisMensualidadesIguales parametro seisMensualidadesIguales a actualizar
	 */
	public void setSeisMensualidadesIguales(List<String> seisMensualidadesIguales) {
		this.seisMensualidadesIguales = seisMensualidadesIguales;
	}

	/**
	 * @return el atributo unaMensualidad
	 */
	public String getUnaMensualidad() {
		return truncarDecimal(unaMensualidad, 2);
	}

	/**
	 * @param unaMensualidad parametro unaMensualidad a actualizar
	 */
	public void setUnaMensualidad(String unaMensualidad) {
		this.unaMensualidad = unaMensualidad;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	/**
	 * Truncado de decimales
	 * @param x
	 * @param numeroDecimales
	 * @return
	 */
	private String truncarDecimal(String x, Integer numeroDecimales) {
		String resultado = "0.00";
		if(x!=null) {
			BigDecimal bd = new BigDecimal(String.valueOf(x)).setScale(numeroDecimales, BigDecimal.ROUND_FLOOR);
			resultado = bd.toString();
		}
		return resultado;
	}
}

