/**
 * MatrimonioLineaService.java
 * Fecha de creación: Aug 12, 2020 5:02:05 PM
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrimonioLinea;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Peticion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Clase para 
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
public interface MatrimonioLineaService {
	/**
	 * Buscar Tramites de Matrimonio
	 * 
	 * @param nss
	 * @return
	 */
	MatrimonioLinea buscarTramitesMatrimonio(String nss);


	/**
	 *  validarAyudaGastosMatrimonio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param agmConyuge
	 *  @param trabajador
	 *  @param user
	 *  @return
	 */
	SolicitarCertificacionMatrimonioSalida validarCertificado(DatosTrabajador trabajador, UsuarioLogin user, RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>> retiroMatrimonioImss, String folio, SolicitudDisposicionParcial entradaOp12, SolicitarCertificacionMatrimonioEntrada agmConyuge   );
	
	
	
	/**
	 *  obtenerMontoRetiroMatrimonio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param salarioMinimo
	 *  @return
	 */
	String obtenerMontoRetiroMatrimonio(String salarioMinimo);
	
	
	/**
	 * @param UsuarioLogin
	 * @param DatosTrabajador
	 * @return
	 */
	FolioEntrada crearFolio(DatosTrabajador dt, String... param);
	/**
	 *  consultarMatrimonio
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param agmConyuge
	 *  @return
	 */
	SolicitarCertificacionMatrimonioSalida consultarMatrimonio(SolicitarCertificacionMatrimonioEntrada agmConyuge );

	/**
	 * @param trabajador
	 * @param resolucion
	 * @param folio
	 * @param calculoEntrada
	 */
	void notificarTipoRetiroMatrimonio(DatosTrabajador trabajador, String resolucion, String folio, ParametrosRetiroParcialCalculoImss calculoEntrada);
}
