/**
 * FechaUtilsImpl.java
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
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;


import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.C_CERO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_DIEZ;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_MIL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_SESENTA;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.joda.time.Interval;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Utileria de fechas
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
@Component
public class FechaUtilsImpl implements FechaUtils {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(FechaUtilsImpl.class);
	
	/**
	 * Inyeccion de Utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtilsImpl utileriaCadena;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String convertirFechaACadena(final Date fecha, final String formato) {
		String valor = null;
		if (!utileriaValidador.validarObjetoNulo(fecha)) {
			final Format formater = new SimpleDateFormat(formato, new Locale(FormatoConstants.LOCALE_ES, FormatoConstants.CIUDAD_MX));
			valor = formater.format(fecha);
			if(validarFechaNula(fecha)) {
				valor = null;
			}
		}
		return valor;
	}
	
	/**
	 * Metodo encargado de limpiar las fechas nulas
	 * @param fecha
	 * @return
	 */
	private boolean validarFechaNula(Date fecha) {
		boolean esNula = true;
		final Format formater = new SimpleDateFormat(FormatoConstants.FORMATO_DDMMYYYY, new Locale(FormatoConstants.LOCALE_ES, FormatoConstants.CIUDAD_MX));
		String fechaAuxiliar = formater.format(fecha);
		if(!FormatoConstants.FECHA_NULA.equals(fechaAuxiliar)) {
			esNula = false;
		}
		return esNula;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date convertirCadenaAFecha(final String fecha, final String formato) {
		final SimpleDateFormat sf = new SimpleDateFormat(formato, new Locale(FormatoConstants.LOCALE_ES, FormatoConstants.CIUDAD_MX));
		Date auxiliarFecha = null;
		try {
			
			if (utileriaValidador.validarVacio(fecha)) {
				return null;
			}
			auxiliarFecha = sf.parse(fecha);
		} catch (ParseException e) {
			logger.error("Error al convertir la fecha: {} {}",e.getMessage(), e);
		}
			
		return auxiliarFecha;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date actualizarHoraInicio(final Date fechaI) {
		if (utileriaValidador.validarObjetoNulo(fechaI)) {
			return null;
		}
		final Calendar calFechaI = Calendar.getInstance();
		calFechaI.setTime(fechaI);
		calFechaI.set(Calendar.HOUR_OF_DAY, 0);
		calFechaI.set(Calendar.MINUTE, 0);
		calFechaI.set(Calendar.SECOND, 0);
		calFechaI.set(Calendar.MILLISECOND, 0);
		return calFechaI.getTime();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date actualizarHoraFinal(final Date fecha) {
		if (utileriaValidador.validarObjetoNulo(fecha)) {
			return null;
		}
		final Calendar calFecha = Calendar.getInstance();
		calFecha.setTime(fecha);
		calFecha.set(Calendar.HOUR_OF_DAY, 23);
		calFecha.set(Calendar.MINUTE, 59);
		calFecha.set(Calendar.SECOND, 59);
		calFecha.set(Calendar.MILLISECOND, 0);
		return calFecha.getTime();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String convertirLongGregorianoACadena(final Object fecha, final String formato) {
		if (utileriaValidador.validarObjetoNulo(fecha)) {
			return null;
		}
		Long fechaEnrolamiento = (Long) fecha;
		GregorianCalendar calendarioGregoriano = new GregorianCalendar();
		calendarioGregoriano.setTimeInMillis(fechaEnrolamiento);
		
		final Format formater = new SimpleDateFormat(formato, new Locale(FormatoConstants.LOCALE_ES, FormatoConstants.CIUDAD_MX));
		return formater.format(calendarioGregoriano.getTime());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date sumaDias(final Date fecha, final Integer dias) {
		if (fecha == null) {
			return null;
		}
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date sumaMinutos(final Date fecha, final Integer minutos){
		if(fecha == null){
			return null;
		}
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.MINUTE, minutos);
		return calendar.getTime();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String diferenciaMinutos(final Date fechaHoy, final Date fechaVigencia){
		if(fechaVigencia == null){
			return null;
		}
		long resta =  fechaVigencia.getTime() - fechaHoy.getTime();
		int minutos = (int) TimeUnit.MINUTES.convert(resta, TimeUnit.MILLISECONDS);
		if(minutos == 0) {
			minutos = 1;
		}
		return String.valueOf(minutos);
	}
	
	@Override
	public String ObtenerFechas(String fecha){
		String fechaString;
		logger.error("Entra a convertir fecha :::: {}",fecha);
		fechaString=fecha.replace("-","");
		return fechaString;
		
	}
	
	@Override
	public String convertirFechas(String fecha){
		String fechaString;
		logger.error("Entra a convertir fecha :::: {}",fecha);
		if( fecha !="" && fecha != null ){
			Long nuevaFecha = Long.parseLong(fecha);
			Date date = new Date(nuevaFecha);
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
			fechaString = format.format(date);
			logger.error(fechaString);
		}else{
			fechaString="";
		}
		return fechaString;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils#obtenerDiferenciaTiempo(java.util.Date, java.util.Date)
	 */
	@Override
	public String obtenerDiferenciaTiempo(Date fechaInicio, Date fechaFin) {
		
		if (utileriaValidador.validarObjetoNulo(fechaInicio) || utileriaValidador.validarObjetoNulo(fechaFin)) {
			return "";
		}
		
			long dif= fechaFin.getTime()-fechaInicio.getTime();
			long difSegundos=dif/INT_MIL%INT_SESENTA;
			long difMinutos=dif/(INT_SESENTA*INT_MIL)%INT_SESENTA;
			long difHoras   = dif/(INT_SESENTA*INT_SESENTA*INT_MIL);
			
			StringBuilder fechaCompleta = new StringBuilder(); 
			
			if(difHoras<INT_DIEZ){
				fechaCompleta.append(C_CERO+String.valueOf(difHoras)).append(":");
			}else{
				fechaCompleta.append(difHoras).append(":");
			}
			
			if(difMinutos<INT_DIEZ){
				fechaCompleta.append(C_CERO+String.valueOf(difMinutos)).append(":");
			}else{
				fechaCompleta.append(difMinutos).append(":");
			}
			
			if(difSegundos<INT_DIEZ){
				fechaCompleta.append(C_CERO+String.valueOf(difSegundos));
			}else{
				fechaCompleta.append(difSegundos);
			}
			
			
			return fechaCompleta.toString();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerFechaActualFormato(Date fecha) {
		String fechaCadena;
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			 fechaCadena = formatoFecha.format(fecha);
		return fechaCadena; 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String calcularTiempoTranscurrido(Date fechaInicial,Date fechaFinal) {
		String intervaloFechas = null;
	try {
			String horasFinal = null;
			String minutosFinal = null;
			Interval intervalo = new Interval(fechaInicial.getTime(), fechaFinal.getTime());
			Period periodo = intervalo.toPeriod();
			int horas = periodo.getHours();
			int minutos = periodo.getMinutes();
			String horasString = String.valueOf(horas);
			String minutosString = String.valueOf(minutos);

			if(horasString.length() > 1) {
				horasFinal = horasString;
			}else {
				horasFinal = utileriaCadena.obtenerCadenaConcatenada(true, "0",horasString);
			}
			
			if(minutosString.length() > 1) {
				minutosFinal = minutosString;
			}else {
				minutosFinal = utileriaCadena.obtenerCadenaConcatenada(true, "0",minutosString);
			}
			intervaloFechas = utileriaCadena.obtenerCadenaConcatenada(true, horasFinal,":",minutosFinal);
			logger.info("resultado intervalo de fechas: {},{}",horasFinal,minutosFinal);
		}catch (Exception e) {
			logger.error("Ocurrio un error al calcular el intervalo de fechas: {}",e);
			intervaloFechas = "00:00";

		}
		return intervaloFechas;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils#convertirLongAFechaCadena(java.lang.Long, java.lang.String)
	 */
	@Override
	public String convertirLongAFechaCadena(Long fecha, final String formato) {
		if (utileriaValidador.validarObjetoNulo(fecha)) {
			return null;
		}
		final Format formater = new SimpleDateFormat(formato, new Locale(FormatoConstants.LOCALE_ES, FormatoConstants.CIUDAD_MX));
		Date d = new Date(fecha);
		return formater.format(d);
	}
	
}