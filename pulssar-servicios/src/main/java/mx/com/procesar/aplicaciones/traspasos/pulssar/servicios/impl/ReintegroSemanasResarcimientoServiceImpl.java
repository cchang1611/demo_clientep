/**
 * ReintegroSemanasResarcimientoServiceImpl.java
 * Fecha de creación: Jan 3, 2020, 2:38:34 PM
 *
 * Copyright (c) 2020 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_FECHA_RENAPO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants.VACIO;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GuardarArchivosReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReintegroSemanasResarcimientoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResarcimientoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ReintegroEstatusEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionReintegro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaMontoReintegrar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;

/**
 * implementacion de servicios de reintegro semanas resarcimiento
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Jan 3, 2020
 */
@Service
public class ReintegroSemanasResarcimientoServiceImpl implements ReintegroSemanasResarcimientoService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ReintegroSemanasResarcimientoServiceImpl.class);

	/**
	 * Mnesaje validacion de monto maximo
	 */
	public static final String MSJ_MAXIMO_REINTEGRAR = "El número de semanas capturadas para el cálculo es mayor al número máximo de semanas permitidas para el reintegro";

	/**
	 * Codigo para identificar la respuesta rechazada en el folio
	 */
	public static final String RESPUESTA_RECHAZADA = "02";

	/**
	 * Notificacion
	 */
	@Autowired
	private NotificacionReintegroService notificacionReintegroService;

	/**
	 * Solicitud
	 */
	@Autowired
	private SolicitudReintegroService solicitudReintegroService;

	/**
	 * Resarcimiento
	 */
	@Autowired
	private ResarcimientoService resarcimientoService;

	/**
	 * Service de archivos
	 */
	@Autowired
	private GuardarArchivosReintegroService guardarArchivosReintegroService;

	/**
	 * utilidades de fechas
	 */
	@Autowired
	private FechaUtils fechaUtils;

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasResarcimientoService#consultarHistoricoRetiros(mx.com.
	 * procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public void consultarHistoricoRetiros(SolicitudReintegroResarcimiento entrada) {
		logger.info("Datos entrada consultarHistoricoRetiros: nss={}, clave afore: {}",
				entrada.getTrabajador().getNss(), entrada.getTrabajador().getClaveAfore());

		List<RespuestaHistoricoRetiros> salida = resarcimientoService
				.obtenerResarcimiento(entrada.getTrabajador().getNss(), entrada.getTrabajador().getClaveAfore());
		entrada.setLstHistoricos(salida);
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasResarcimientoService#obtenerCalculoMontoReintegrar(mx.com
	 * .procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * CalculoMontoReintegrar)
	 */
	@Override
	public BaseRespuesta<RespuestaMontoReintegrar> obtenerCalculoMontoReintegrar(CalculoMontoReintegrar entrada,
			SolicitudReintegroResarcimiento solicitud) {
		logger.info("datos de entrada obtenerCalculoMontoReintegrar: {}", entrada);

		RespuestaHistoricoRetiros historicoCalcular = new RespuestaHistoricoRetiros();
		for (RespuestaHistoricoRetiros historico : solicitud.getLstHistoricos()) {
			if (entrada.getNumeroResolucion().equals(historico.getNumeroResolucion())) {
				historicoCalcular = historico;
			}
		}

		Integer noMaxSemanasDisponibles = Integer.valueOf(historicoCalcular.getSemanasRestantes());
		Integer semanasReintegrar = Integer.valueOf(entrada.getNumeroSemanasReintegrar());

		if (noMaxSemanasDisponibles < semanasReintegrar) {
			return new BaseRespuesta<>(RESPUESTA_RECHAZADA, MSJ_MAXIMO_REINTEGRAR, null);
		}

		return resarcimientoService.obtenerCalculoMontoReintegrar(entrada);
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasResarcimientoService#consultarHistoricoConfirmacion(mx.
	 * com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public void consultarHistoricoConfirmacion(SolicitudReintegroResarcimiento entrada) {
		List<SolicitudReintegroEntrada> salida = solicitudReintegroService
				.buscarSolicitudes(entrada.getTrabajador().getNss());

		for (SolicitudReintegroEntrada confirmacion : salida) {
			String fechaStr = fechaUtils.convertirFechaACadena(confirmacion.getFechaRetiro(), FORMATO_FECHA_RENAPO);
			confirmacion.setFechaRetiroVista(fechaStr == null ? VACIO : fechaStr);
		}

		entrada.setLstConfirmacion(salida);
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasResarcimientoService#generarLineaCaptura(mx.com.procesar.
	 * aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public BaseRespuesta<byte[]> generarLineaCaptura(SolicitudReintegroResarcimiento entrada) {
		logger.info("datos de entrada obtenerCalculoMontoReintegrar: {}", entrada);

		BaseRespuesta<byte[]> salida = solicitudReintegroService.generarDatosReferencia(entrada);

		logger.info("datos de salida obtenerCalculoMontoReintegrar: {}", salida);
		return salida;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasResarcimientoService#consultarDocumentosRequeridos(mx.com
	 * .procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public void consultarDocumentosRequeridos(SolicitudReintegroResarcimiento entrada) {
		guardarArchivosReintegroService.consultarDocumentosRequeridos(entrada);

		// obtener item selecionado
		for (SolicitudReintegroEntrada c : entrada.getLstConfirmacion()) {
			if (entrada.getResolucion().equals(c.getNumeroResolucion())
					&& entrada.getNumeroReintegro().equals(c.getNumeroReintegro().toString())) {
				entrada.setSemanasReintegrar(c.getSemanasReintegrar());
				entrada.setMontoTotalReintegrar(c.getMontoTotalReintegrar());
			}
		}
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasResarcimientoService#obtenerArchivos(java.util.Map,
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public RespuestaServicio obtenerArchivos(Map<String, MultipartFile> archivos,
			SolicitudReintegroResarcimiento entrada) {
		RespuestaServicio salida = guardarArchivosReintegroService.obtenerArchivos(archivos, entrada);

		if (salida.getFlujo() == 0) {
			SolicitudReintegroEntrada solicitud = solicitudReintegroService
					.buscarSolicitudes(entrada.getNumeroReintegro(), entrada.getResolucion());
			solicitud.setEstatusReintegro(ReintegroEstatusEnum.ENVIADO.getClave());
			solicitud.setMascaraArchivo(guardarArchivosReintegroService.generarMascaraArchivo(entrada));
			solicitudReintegroService.guardarSolicitud(solicitud);

			NotificacionReintegro notificacion = notificacionReintegroService
					.buscarNotificacion(entrada.getNumeroReintegro(), entrada.getResolucion());
			notificacion.setEstatusReintegro(ReintegroEstatusEnum.ENVIADO.getClave());
			notificacion.setMascaraArchivo(guardarArchivosReintegroService.generarMascaraArchivo(entrada));
			notificacionReintegroService.notificarReintegro(notificacion);
		}

		return salida;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ReintegroSemanasResarcimientoService#generarNotificacionHistorico(mx.com.
	 * procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public void generarNotificacionHistorico(SolicitudReintegroResarcimiento entrada) {
		notificacionReintegroService.notificarReintegro(entrada);
		solicitudReintegroService.guardarSolicitud(entrada);
	}

}
