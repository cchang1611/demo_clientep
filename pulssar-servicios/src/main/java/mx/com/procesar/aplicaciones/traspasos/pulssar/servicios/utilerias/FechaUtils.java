/**
 * FechaUtils.java
 * Fecha de creacion: 20/12/2016, 20:03:15
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informacion confidencial, propiedad del
 * Procesar S A de C V. Esta informacion confidencial
 * no deberia ser divulgada y solo se podria utilizar de acuerdo
 * a los terminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import java.util.Date;

/**
 * Utileria de fechas
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public interface FechaUtils {

	/**
	 * Metodo que convierte una fecha a un String con el formato indicado
	 * 
	 * @param fecha
	 * @param formato
	 * @return
	 */
	String convertirFechaACadena(Date fecha, String formato);
	
	/**
	 * Metodo que convierte un String de fecha a un objeto Date
	 * 
	 * @param fecha
	 * @param formato
	 * @return
	 */
	Date convertirCadenaAFecha(final String fecha, final String formato);
	
	/**
	 * Metodo que actualiza la hora inicio del dia
	 * 
	 * @param fecha
	 * @return
	 */
	Date actualizarHoraInicio(final Date fecha);
	
	/**
	 * Metodo que actualiza la hora fin del dia
	 * 
	 * @param fecha
	 * @return
	 */
	Date actualizarHoraFinal(final Date fecha);
	
	/**
	 * Metodo encargado de convertir un objeto long gregoriano
	 * a una cadena con el formato indicado
	 * 
	 * @param fecha
	 * @param formato
	 * @return
	 */
	String convertirLongGregorianoACadena(final Object fecha, final String formato);
	
	/**
	 * Metodo encargado de sumar dias a una fecha
	 * @param fecha
	 * @param dias
	 * @return
	 */
	Date sumaDias(final Date fecha, final Integer dias);
	
	/**
	 * Metodo encargado de sumar minutos a una fecha 
	 * @param fecha
	 * @param minutos
	 * @return
	 */
	Date sumaMinutos(final Date fecha,final Integer minutos);
	
	/**
	 * Metodo encargado de obtener minutos 
	 * @param fechaHoy
	 * @param fechaVigencia
	 * @return
	 */
	String diferenciaMinutos(final Date fechaHoy, final Date fechaVigencia);
	
	/**
	 * @param fecha
	 * @return
	 */
	String ObtenerFechas(String fecha);
	
	/**
	 * @param fecha
	 * @return
	 */
	String convertirFechas(String fecha);
	
	/**
	 * Metodo que regresa la diferencia de tiempo entre dos datos tipo Date; 
	 * @param fechaInicio
	 * @param fechaFin
	 * @return
	 */
	String obtenerDiferenciaTiempo(Date fechaInicio,Date fechaFin);
	
	/**
	 * Metodo que obtiene fecha formato especifico
	 * @return
	 */
	String obtenerFechaActualFormato(Date fecha);

	/**
	 * Metodo que calcula tiempo trascurrido entre 2 fechas
	 * @param fechaInicial
	 * @param fechaFinal
	 */
	String calcularTiempoTranscurrido(Date fechaInicial, Date fechaFinal);
	
	/**
	 *  convertir Long A Fecha Cadena
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param fecha
	 *  @param formato
	 *  @return
	 */
	String convertirLongAFechaCadena(Long fecha, String formato);
	
}