/**
 * ReintegroSemanasFlujosFoliosServicesImpl.java
 * Fecha de creación: May 11, 2020 12:32:35 PM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReintegroSemanasFlujosFoliosServices;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;

/**
 * Clase para crear y cerrar folios
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
@Service
public class ReintegroSemanasFlujosFoliosServicesImpl implements ReintegroSemanasFlujosFoliosServices {

	/**
	 * Servicio de Folio
	 */
	@Autowired
	private FolioService folioService;

	/**
	 * Atributo TIEMPO_LLEGADA
	 */
	private static final String TIEMPO_LLEGADA = "00:00";

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasFlujosFoliosServices#generarFolioPadreHistorico(mx.com.
	 * procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public void generarFolioPadreHistorico(SolicitudReintegroResarcimiento entrada) {
		generarFolio(entrada, "S13P1");
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasFlujosFoliosServices#generarFolioHijoDosHistorico(mx.com.
	 * procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public void generarFolioHijoDosHistorico(SolicitudReintegroResarcimiento entrada) {
		folioService.cerrarFolio(entrada.getTrabajador().getFolio().getIdFolio(), null);
		generarFolio(entrada, "S13P2");
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasFlujosFoliosServices#generarFolioHijoTresHistorico(mx.com
	 * .procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public void generarFolioHijoTresHistorico(SolicitudReintegroResarcimiento entrada) {
		folioService.cerrarFolio(entrada.getTrabajador().getFolio().getIdFolio(), null);
		generarFolio(entrada, "S13P3");
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasFlujosFoliosServices#cerrarFolioRechazado(mx.com.procesar
	 * .aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public void cerrarFolioRechazado(SolicitudReintegroResarcimiento entrada) {
		folioService.cerrarFolio(entrada.getTrabajador().getFolio().getIdFolioPadre(), 3);
	}

	/**
	 * @param entrada
	 * @param proceso
	 */
	private void generarFolio(SolicitudReintegroResarcimiento entrada, String proceso) {
		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(Long.valueOf(entrada.getUsuarioLogin().getDatoUsuario()));
		folio.setOperacion("S");
		folio.setServicio("S13");
		folio.setProceso(proceso);
		folio.setSucursal("SUC1");
		folio.setNss(entrada.getTrabajador().getNss());
		folio.setCurp(entrada.getTrabajador().getDatosCertificables().getCurp());
		folio.setTiempoLlegada(TIEMPO_LLEGADA);
		folio.setOrigen("O");
		folio.addFolios(entrada.getTrabajador().getFolio().getFolio());
		FolioEntrada folioRespuesta = folioService.generarFolio(folio);
		entrada.getTrabajador().setFolio(folioRespuesta);
	}
}
