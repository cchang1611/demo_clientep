/**
 * ReintegroSemanasFlujosFoliosServicesTestCase.java
 * Fecha de creación: Dec 1, 2020 2:02:17 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReintegroSemanasFlujosFoliosServices;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReintegroSemanasFlujosFoliosServicesImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
public class ReintegroSemanasFlujosFoliosServicesTestCase {

	/**
	 * Atributo reintegroSemanasFlujosFoliosServices
	 */
	@InjectMocks
	private ReintegroSemanasFlujosFoliosServices reintegroSemanasFlujosFoliosServices = new ReintegroSemanasFlujosFoliosServicesImpl();

	/**
	 * Servicio de Folio
	 */
	@Mock
	private FolioService folioService;

	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * testCerrarFolioRechazado
	 */
	@Test
	public void testCerrarFolioRechazado() {
		// Prueba
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		trabajador.setClaveAfore("123123");
		FolioEntrada folio = new FolioEntrada();
		folio.setIdFolioPadre(10L);
		trabajador.setFolio(folio);
		entrada.setTrabajador(trabajador);
		reintegroSemanasFlujosFoliosServices.cerrarFolioRechazado(entrada);
	}

	/**
	 * testGenerarFolioHijoDosHistorico
	 */
	@Test
	public void testGenerarFolioHijoDosHistorico() {
		FolioEntrada value = new FolioEntrada();
		value.setIdFolio(10L);
		Mockito.when(folioService.procesarFolio(Mockito.any(FolioEntrada.class), Mockito.any(DatosTrabajador.class)))
				.thenReturn(value);
		// Prueba
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		trabajador.setClaveAfore("123123");
		trabajador.setFolio(value);
		entrada.setTrabajador(trabajador);
		UsuarioLogin usuarioogin = new UsuarioLogin();
		usuarioogin.setDatoUsuario(10L);
		entrada.setUsuarioLogin(usuarioogin);
		reintegroSemanasFlujosFoliosServices.generarFolioHijoDosHistorico(entrada);
	}

	/**
	 * 
	 */
	@Test
	public void testGenerarFolioHijoTresHistorico() {
		FolioEntrada value = new FolioEntrada();
		value.setIdFolio(10L);
		Mockito.when(folioService.procesarFolio(Mockito.any(FolioEntrada.class), Mockito.any(DatosTrabajador.class)))
				.thenReturn(value);
		// Prueba
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		trabajador.setClaveAfore("123123");
		trabajador.setFolio(value);
		entrada.setTrabajador(trabajador);
		UsuarioLogin usuarioogin = new UsuarioLogin();
		usuarioogin.setDatoUsuario(10L);
		entrada.setUsuarioLogin(usuarioogin);
		reintegroSemanasFlujosFoliosServices.generarFolioHijoTresHistorico(entrada);
	}

	/**
	 * testGenerarFolioPadreHistorico
	 */
	@Test
	public void testGenerarFolioPadreHistorico() {
		FolioEntrada value = new FolioEntrada();
		value.setIdFolio(10L);
		Mockito.when(folioService.procesarFolio(Mockito.any(FolioEntrada.class), Mockito.any(DatosTrabajador.class)))
				.thenReturn(value);
		// Prueba
		SolicitudReintegroResarcimiento entrada = new SolicitudReintegroResarcimiento();
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setNss("123");
		trabajador.setClaveAfore("123123");
		trabajador.setFolio(value);
		entrada.setTrabajador(trabajador);
		UsuarioLogin usuarioogin = new UsuarioLogin();
		usuarioogin.setDatoUsuario(10L);
		entrada.setUsuarioLogin(usuarioogin);
		reintegroSemanasFlujosFoliosServices.generarFolioPadreHistorico(entrada);
	}
}
