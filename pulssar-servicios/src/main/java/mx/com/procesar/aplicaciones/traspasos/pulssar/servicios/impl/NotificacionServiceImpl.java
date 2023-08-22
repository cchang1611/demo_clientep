/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionCus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionSolicitudDisposicionIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionTiempoTramiteMod;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionTipoProcRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaEstatusServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioRetiroParcialCalculo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementación del servicio Notificacion 
 * @author mgonzale
 *
 */
@Service
public class NotificacionServiceImpl implements NotificacionService{
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(NotificacionServiceImpl.class);
	
	/**
	 * Inyeccion de url para notificacionTipoRetiro
	 */
	@Value("${uri.notificacion.tipo.retiro}")
	private String urlNotificacionTipoRetiro;
	
	/**
	 * Inyeccion de url para NotificacionCertificacionDesempleo
	 */
	@Value("${uri.notificacion.certificacion.desempleo}")
	private String urlNotificacionCertificacionDesempleo;
	
	/**
	 * Inyeccion de url para NotificacionCertificacionDesempleo
	 */
	@Value("${uri.notificacion.retiro.desempleo}")
	private String urlNotificacionRetiroDesempleo;
 	/**
 	 * uriNotificacionSolicitudDisposicionIssste
 	 */
 	@Value("${uri.guardar.notificacionsolicituddisposicionissste}")
 	private String uriNotificacionSolicitudDisposicionIssste;
	/**
	 * restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Autowired
	private CadenasUtils utileriaCadenas;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * url comunes transaccional
	 */
	@Value("${uri.comunes.transaccional}")
	private String urlComunesTransaccional;
	
	/**
	 * url Notificacion Cus Desempleo
	 */
	@Value("${uri.notificacion.cus.desempleo}")
	private String urlNotificacionCusDesempleo;
	
	
	/**
	 * url Notificacion Cus Desempleo
	 */
	@Value("${uri.notificacion.comunes}")
	private String urlNotificacion;
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService#notificarTipoRetiro(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioRetiroParcialCalculo, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Async
	public void notificarTipoRetiro(ParametrosRetiroParcialCalculoImss entrada, RespuestaServicioRetiroParcialCalculo salida, String nss, String curp, String afore) {
		logger.info("Datos Entrada notificarTipoRetiro:{}\nSalida{}",entrada, salida);
		
		NotificacionTipoRetiro notificacionTipoRetiro = new NotificacionTipoRetiro();
		notificacionTipoRetiro.setAfore(afore);
		notificacionTipoRetiro.setClaveBanco(entrada.getClaveBanco());
		notificacionTipoRetiro.setCuentaClabe(entrada.getCuentaClabe());
		notificacionTipoRetiro.setCurp(curp);
		notificacionTipoRetiro.setDiagnosticoRecepcion("001");
		notificacionTipoRetiro.setFechaControl(new Date());
		notificacionTipoRetiro.setFechaProcesamiento(new Date());
		notificacionTipoRetiro.setFolio(entrada.getFolio());
		notificacionTipoRetiro.setFolioAdministradora(entrada.getFolio());
		notificacionTipoRetiro.setNss(nss);
		notificacionTipoRetiro.setNumeroCuenta(entrada.getCuenta());
		notificacionTipoRetiro.setNumeroResolucion(entrada.getProcesoReferencia());
		notificacionTipoRetiro.setNumNotificado(BigDecimal.ZERO);
		notificacionTipoRetiro.setNumParcialidades(entrada.getNumeroParcialidad());
		notificacionTipoRetiro.setTipoRetiroSeleccion(entrada.getTipoRetiro());
		notificacionTipoRetiro.setUsuarioModificador("NOTIFICACIONES_PULSSAR");
		notificacionTipoRetiro.setTipoPago(entrada.getFormaPago());
		notificacionTipoRetiro.setMontoA(entrada.getMontoCalculoA());
		notificacionTipoRetiro.setMontoB(entrada.getMontoCalculoB());
		if(!utileriaValidador.isEmpty(entrada.getMontoCalculoA())){
			notificacionTipoRetiro.setImporteAutorizado(entrada.getMontoCalculoA());
		} else {
			notificacionTipoRetiro.setImporteAutorizado(entrada.getMontoCalculoB());
			entrada.getTotalSaldos();
			Double porcentajea = (entrada.getSaldoRetiro97() / entrada.getTotalSaldos()) * entrada.getSaldoRetiro97();
			Double porcentajeb = (entrada.getSaldoRcv() / entrada.getTotalSaldos()) * entrada.getSaldoRcv();
			Double porcentajec = (entrada.getSaldoCuotaSocial() / entrada.getTotalSaldos()) * entrada.getSaldoCuotaSocial();
			notificacionTipoRetiro.setImporteRet97(porcentajea);
			notificacionTipoRetiro.setImporteCesVej(porcentajeb);
			notificacionTipoRetiro.setImporteCuotaSocial(porcentajec);
		}
		RespuestaEstatusServicio respuestaEstatus = null;
		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true, urlNotificacionTipoRetiro);
			logger.info(ExpresionesConstants.URL_ACTUALIZAR,urlServicio);
			HttpEntity<NotificacionTipoRetiro> entity = new HttpEntity<>(notificacionTipoRetiro, httpHeaders);
			logger.info("Entrada: {}", entity);
			ResponseEntity<RespuestaEstatusServicio> response = restTemplate.exchange(urlServicio, HttpMethod.PUT, entity, RespuestaEstatusServicio.class);
			logger.info(ExpresionesConstants.RESPUESTA_ACTUALIZAR,response);
			if (utileriaValidador.validarObjetoNulo(response.getBody())) {
				logger.error(ExpresionesConstants.DESCRIPCION_EXCEPCION, uriNotificacionSolicitudDisposicionIssste.concat("Respuesta nula"));
			}
			respuestaEstatus = response.getBody();
		} catch (Exception e) {
			logger.error(ExpresionesConstants.DESCRIPCION_EXCEPCION, urlNotificacionTipoRetiro, e);
			logger.error(ExpresionesConstants.DESCRIPCION_EXCEPCION, uriNotificacionSolicitudDisposicionIssste.concat("Respuesta nula"));
		}
		logger.info("Datos Salida respuesta servicio notificacionTiporetiro:{}",respuestaEstatus);
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService#notificarPeracion52(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialEntrada, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionSolicitudDisposicionIssste, java.lang.String)
	 */
	@Override
	@Async
	public void notificarPeracion52(SolicitudDisposicionParcialEntrada entrada,
			SolicitudDisposicionParcialSalida salida, String folio) {
   		NotificacionSolicitudDisposicionIssste not = new NotificacionSolicitudDisposicionIssste();
		not.setFolio(folio);
		not.setDescDiagnosticoRecepcion(salida.getDescripcionDiagnostico());
		not.setNombre(entrada.getNombreTrabajador());
		not.setApellidoPaterno(entrada.getApellidoPaternoTrabajador());
		not.setApellidoMaterno(entrada.getApellidoMaternoTrabajador());
		not.setSelloTrabajador(entrada.getSelloTrabajador());
		not.setCurpAgenteServ(entrada.getCurpAgente());
		not.setUsuarioModificador("NOTIFICACIONES_PULSSAR");
		not.setFechaControl(new Date());
		not.setNumNotificado(new BigDecimal(0));
		not.setOrigenSolicitud(entrada.getOrigenSolicitud());
		not.setTipoRegimen(entrada.getTipoRegimen());
		not.setTipoPrestacion(entrada.getTipoPrestacion());
		not.setCurp(entrada.getCurp());
		not.setAfore(entrada.getClaveAfore());
		not.setResultadoOperacion(salida.getResultadoOperacion());
		not.setSecuenciaPension(salida.getSecuenciaPension());
		not.setDiagnosticoRecepcion(salida.getClaveDiagnostico());
		not.setTipoRetiro(entrada.getTipoRetiro());
		not.setConcesion(entrada.getNumeroConcesion());
		not.setCurpSolicitante(entrada.getCurp());
		not.setTipoSolicitante("01");
		not.setNss(entrada.getNss());
		not.setNumIssste(entrada.getNumeroIssste());
		not.setTramite("01");
		
		
		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			logger.info(ExpresionesConstants.URL_ACTUALIZAR,uriNotificacionSolicitudDisposicionIssste);
			HttpEntity<NotificacionSolicitudDisposicionIssste> entity = new HttpEntity<>(not, httpHeaders);
			logger.info("Entrada: {}", entity);
			ResponseEntity<RespuestaEstatusServicio> response = restTemplate.exchange(uriNotificacionSolicitudDisposicionIssste, HttpMethod.PUT, entity, RespuestaEstatusServicio.class);
			logger.info(ExpresionesConstants.RESPUESTA_ACTUALIZAR,response);
			if (utileriaValidador.validarObjetoNulo(response.getBody())) {
				logger.error(ExpresionesConstants.DESCRIPCION_EXCEPCION, uriNotificacionSolicitudDisposicionIssste.concat("Respuesta nula"));
			}
		} catch (Exception e) {
			logger.error(ExpresionesConstants.DESCRIPCION_EXCEPCION, uriNotificacionSolicitudDisposicionIssste, e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Async
	public void notificarTiempoTramite(NotificacionTiempoTramiteMod notificacionTiempo) {
		logger.info("Datos Entrada notificarTiempoTramite:{}",notificacionTiempo);
		String urlServicio = null;
		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true, urlComunesTransaccional,"notificacionTiempo","/guardarTiempoTramite");
			logger.info("Url notificarTiempoTramite: {}",urlServicio);
			HttpEntity<NotificacionTiempoTramiteMod> entity = new HttpEntity<>(notificacionTiempo, httpHeaders);
			ResponseEntity<String> response = restTemplate.exchange(urlServicio, HttpMethod.POST, entity, String.class);
			logger.info("Respuesta notificarTiempoTramite: {}",response);
		} catch (Exception e) {
			logger.error("Ocurrio un error en notificarTiempoTramite: {} {}", urlServicio, e);
		}
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService#notificarCus(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Async
	public void notificarCus(RespuestaGeneraCusSalida cus, String afore, String folio, String extra){
		logger.info("Datos Entrada notificarCus:{}\n{}\n{}",cus, afore, folio);
		NotificacionCus notificacionCus = new NotificacionCus();
		notificacionCus.setAfore(afore);
		notificacionCus.setCus(cus.getCus());
		notificacionCus.setFechaGeneracion(cus.getFechaGeneracion());
		notificacionCus.setFechaRecepcionNotificacion(cus.getFechaRecepNotificacion());
		notificacionCus.setFechaVigencia(cus.getFechaVigencia());
		notificacionCus.setFolioProcesar(folio);
		notificacionCus.setNotificado(0L);
		notificacionCus.setFechaControl(new Date());
		notificacionCus.setUsuarioModificador("NOTIFICACIONES_PULSSAR");

		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			logger.info("Notificacion:{}\nurl:{}",notificacionCus, urlNotificacionCusDesempleo);
			HttpEntity<NotificacionCus> entity = new HttpEntity<>(notificacionCus, httpHeaders);
			ResponseEntity<RespuestaEstatusServicio> response = restTemplate.exchange(urlNotificacionCusDesempleo, HttpMethod.PUT, entity, RespuestaEstatusServicio.class);
			logger.info(ExpresionesConstants.RESPUESTA_ACTUALIZAR,response);
			if(!utileriaValidador.validarObjetoNulo(extra)){
				NotificacionTipoProcRetiro notificacionTipoProcRetiro = new NotificacionTipoProcRetiro();
				notificacionTipoProcRetiro.setChFolio(folio);
				notificacionTipoProcRetiro.setChTipoProceso("1");
				notificacionTipoProcRetiro.setChUsuarioModificador("NOTIFICACIONES_PULSSAR");
				notificacionTipoProcRetiro.setFcControl(new Date());
				notificacionTipoProcRetiro.setNuNotificado(0L);
				logger.info("Notificacion exitosa:{}",notificacionCus);
				StringBuilder sb = new StringBuilder(urlNotificacion).append("notificacion/guardarTipoProcRetiro");
				logger.info("Notificacion:{}\nurl:{}",notificacionTipoProcRetiro, sb);
				HttpEntity<NotificacionTipoProcRetiro> entity2 = new HttpEntity<>(notificacionTipoProcRetiro, httpHeaders);
				ResponseEntity<String> response2 = restTemplate.exchange(sb.toString(), HttpMethod.POST, entity2, String.class);
				logger.info(ExpresionesConstants.RESPUESTA_ACTUALIZAR,response2);

			}
		} catch (Exception e) {
			logger.error(ExpresionesConstants.DESCRIPCION_EXCEPCION, urlNotificacionCusDesempleo, e);
		}
	}

}
