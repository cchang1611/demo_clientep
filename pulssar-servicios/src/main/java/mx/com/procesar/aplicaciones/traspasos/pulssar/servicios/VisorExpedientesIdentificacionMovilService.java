/**
 * VisorExpedientesIdentificacionMovilService.java
 * Fecha de creación: Feb 10, 2021 10:58:08 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;
import java.util.Map;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DetalleExpedientes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteTipoProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Imagen;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaConsultaVisorExpedienteMovil;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoProcesoExpediente;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public interface VisorExpedientesIdentificacionMovilService {

	/**
	 * Consulta documetos de expediente
	 * 
	 * @param claveAfore
	 * @param curp
	 */
	public byte[] consultaExpediente(String tipoServicio, String claveAfore, String curp, String tipoExpediente);
	

	
	/**
	 * obtenerExpedientes
	 * @param tipoServicio
	 * @param claveAfore
	 * @param curp
	 * @param tipoExpediente
	 * @return
	 */
	SalidaConsultaVisorExpedienteMovil obtenerExpedientes(String tipoServicio, String claveAfore, String curp, String tipoExpediente,String fecha);
	
	/**
	 * obtenerExpedienteTipoProceso
	 * @param claveExpediente
	 * @return
	 */
	ExpedienteTipoProceso obtenerExpedienteTipoProceso(String claveExpediente);
	
	/**
	 * convierte objeto a json
	 * @param obj
	 * @return
	 */
	 <T> String convertirObjetoJson(T obj);
	 
	 /**
	  * obtenerListaDetalle
	  * @param salidaConsultaVisorExpedienteMovil
	  * @return
	  */
	 List<DetalleExpedientes> obtenerListaDetalle(SalidaConsultaVisorExpedienteMovil salidaConsultaVisorExpedienteMovil);
	
	 /**
	  * obtenerListaImagenes
	  * @return
	  */
	 List<Imagen> obtenerListaImagenes(byte [] archivoEntrada );
	 
	 /**
	  * obtenerTipoServicio
	  * @param roleActual
	  * @return
	  */
	 String obtenerTipoServicio(String roleActual);
	 
	 /**
	  * validaCamposExpediente
	  * @param afore
	  * @param curp
	  * @param tipoExpediente
	  */
	 void validaCamposExpediente(String afore,String curp,String tipoExpediente);
	 
	 /**
	  * validarListaImagenes
	  * @param listaImagenes
	  * @param listaDetalle
	  */
	 void validarListaImagenes(List<Imagen> listaImagenes,List<DetalleExpedientes> listaDetalle);
	 
	 /**
	  * listaExpedienteFiltrada
	  * @param listaEntrada
	  * @return
	  */
	 List<TipoProcesoExpediente> listaExpedienteFiltrada(List<TipoProcesoExpediente> listaEntrada);
	 
	 /**
	  * generarComboDocumentos
	  * @param lstDocumentos
	  * @return
	  */
	 List<Imagen> generarComboDocumentos(Map<String, byte[]> lstDocumentos);
	 
	 
	 /**
	  * obtenerNombreExpediente
	  * @param tipoExpediente
	  * @return
	  */
	 String obtenerNombreExpediente(String tipoExpediente);
}
