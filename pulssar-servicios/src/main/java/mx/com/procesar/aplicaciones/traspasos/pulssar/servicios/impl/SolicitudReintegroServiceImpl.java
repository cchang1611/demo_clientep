/**
 * SolicitudReintegroServiceImpl.java
 * Fecha de creación: Mar 30, 2020 3:12:42 PM
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

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.USER_REGISTRO;

import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarBancoAforeService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ReintegroEstatusEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BancoAfore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GenerarLineaCapturaPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHistoricoRetiros;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;

/**
 * Clase para enviar la solicitud de Reintegro
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
@Service
public class SolicitudReintegroServiceImpl implements SolicitudReintegroService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(SolicitudReintegroService.class);

	/**
	 * url guardar solicitud
	 */
	@Value("${url.reintegro.guardar.solicitud}")
	private String urlGuardarSolicitud;

	/**
	 * Url buscar solicitud
	 */
	@Value("${url.reintegro.buscar.solicitud}")
	private String urlBuscarSolicitud;

	/**
	 * Url buscar solicitud por numero reintegro y resolucion
	 */
	@Value("${url.reintegro.buscar.solicitud.reintegro.resolucion}")
	private String urlBuscarSolicitudReintegroResolucion;

	/**
	 * url generar PDF - generarPdfLineaCaptura
	 */
	@Value("${url.reintegro.generar.linea.captura}")
	private String urlGenerarLineaCaptura;

	/**
	 * template llamado de servicio rest
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Serivicio de consulta de banco por afore
	 */
	@Autowired
	private ConsultarBancoAforeService consultarBancoAforeService;

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * SolicitudReintegroService#guardarSolicitud(mx.com.procesar.aplicaciones.
	 * traspasos.pulssar.servicios.modelo.SolicitudReintegroEntrada)
	 */
	@Override
	public void guardarSolicitud(SolicitudReintegroEntrada entrada) {
		BaseRespuesta<SolicitudReintegroEntrada> salida = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SolicitudReintegroEntrada> entidadEntrada = new HttpEntity<>(entrada, headers);
		ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>> respuesta = restTemplate.exchange(urlGuardarSolicitud,
				HttpMethod.POST, entidadEntrada,
				new ParameterizedTypeReference<BaseRespuesta<SolicitudReintegroEntrada>>() {
				});

		if (respuesta.getBody() != null) {
			logger.info("SolicitudReintegroEntrada: {}", salida);
		}
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * SolicitudReintegroService#guardarSolicitud(mx.com.procesar.aplicaciones.
	 * traspasos.pulssar.servicios.modelo.SolicitudReintegroEntrada)
	 */
	@Override
	public void guardarSolicitud(SolicitudReintegroResarcimiento entrada) {
		SolicitudReintegroEntrada solicitud = new SolicitudReintegroEntrada();
		solicitud.setApellidoMaterno(entrada.getTrabajador().getRenapo().getApellidoMaterno());
		solicitud.setApellidoPaterno(entrada.getTrabajador().getRenapo().getApellidoPaterno());
		solicitud.setCurp(entrada.getTrabajador().getRenapo().getCurp());
		solicitud.setEstatusReintegro(ReintegroEstatusEnum.REGISTRADO.getClave());
		solicitud.setFechaRetiro(entrada.getMontoReintegrar().getFechaRetiro());
		solicitud.setMontoTotalReintegrar(entrada.getMontoReintegrar().getMontoReintegrar());
		solicitud.setNombre(entrada.getTrabajador().getRenapo().getNombre());
		solicitud.setNss(entrada.getTrabajador().getNss());
		solicitud.setNumeroResolucion(entrada.getMontoReintegrar().getNumeroResolucion());
		solicitud.setSemanasReintegrar(Integer.valueOf(entrada.getMontoReintegrar().getNumeroSemanasReintegrar()));
		solicitud.setUsuarioModificador(USER_REGISTRO);
		solicitud.setValorIntegrar(obtenerHistorico(entrada));
		solicitud.setFolioTramSolReint(entrada.getTrabajador().getFolio().getFolio());
		solicitud.setFechaSolicitudReintegro(new Date());

		BaseRespuesta<SolicitudReintegroEntrada> salida = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SolicitudReintegroEntrada> entidadEntrada = new HttpEntity<>(solicitud, headers);
		ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>> respuesta = restTemplate.exchange(urlGuardarSolicitud,
				HttpMethod.POST, entidadEntrada,
				new ParameterizedTypeReference<BaseRespuesta<SolicitudReintegroEntrada>>() {
				});

		if (respuesta.getBody() != null) {
			logger.info("SolicitudReintegroResarcimiento: {}", salida);
		}
	}

	/**
	 * Obtiene el valor del dia a reitengrar
	 * 
	 * @param entrada
	 * @return
	 */
	private Double obtenerHistorico(SolicitudReintegroResarcimiento entrada) {
		String valorDiaReintegrar = null;

		for (RespuestaHistoricoRetiros historico : entrada.getLstHistoricos()) {
			if (historico.getNumeroResolucion().equals(entrada.getMontoReintegrar().getNumeroResolucion())) {
				valorDiaReintegrar = historico.getValorDiaReintegrar();
			}
		}

		return valorDiaReintegrar == null ? null : Double.parseDouble(valorDiaReintegrar);
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * SolicitudReintegroService#generarDatosReferencia(mx.com.procesar.
	 * aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public BaseRespuesta<byte[]> generarDatosReferencia(SolicitudReintegroResarcimiento entrada) {
		BancoAfore consulta = consultarBancoAforeService.consultaClaveAfore(entrada.getTrabajador().getClaveAfore());

		GenerarLineaCapturaPdf solicitud = new GenerarLineaCapturaPdf();
		solicitud.setClaveAfore(entrada.getTrabajador().getClaveAfore());
		solicitud.setCuentaClabe(consulta.getClabe());
		solicitud.setNumeroCuentaBancaria(consulta.getCuentaBancaria());
		solicitud.setNombreBanco(consulta.getNombreBanco());
		solicitud.setApellidoMaterno(entrada.getTrabajador().getRenapo().getApellidoMaterno());
		solicitud.setApellidoPaterno(entrada.getTrabajador().getRenapo().getApellidoPaterno());
		solicitud.setCurp(entrada.getTrabajador().getRenapo().getCurp());
		solicitud.setMontoPesos(entrada.getMontoReintegrar().getMontoReintegrar());
		solicitud.setNombre(entrada.getTrabajador().getRenapo().getNombre());
		solicitud.setNss(entrada.getTrabajador().getNss());
		solicitud.setNumeroResolucion(entrada.getMontoReintegrar().getNumeroResolucion());
		solicitud.setNumeroSemanas(entrada.getMontoReintegrar().getNumeroSemanasReintegrar());

		BaseRespuesta<String> salida = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<GenerarLineaCapturaPdf> construir = new HttpEntity<>(solicitud, headers);
		ResponseEntity<BaseRespuesta<String>> respuesta = restTemplate.exchange(urlGenerarLineaCaptura, HttpMethod.POST,
				construir, new BaseRespuesta<String>().getType());

		if (respuesta.hasBody()) {
			salida = respuesta.getBody();
		}
		
		if(salida == null || salida.getObjetoRespuesta() == null) {
			return null;
		}

		byte[] bytes = DatatypeConverter.parseBase64Binary(salida.getObjetoRespuesta());
		return new BaseRespuesta<>(salida.getDiagnosticoDeRecepcion(), salida.getResultadoDeLaOperacion(), bytes);
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * SolicitudReintegroService#buscarSolicitudes(java.lang.String)
	 */
	@Override
	public List<SolicitudReintegroEntrada> buscarSolicitudes(String entrada) {
		String urlServicio = urlBuscarSolicitud.replace("{nss}", entrada);
		logger.info("url consulta historico retiros: {}", urlServicio);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BaseRespuesta<List<SolicitudReintegroEntrada>>> entidadEntrada = new HttpEntity<>(headers);
		ResponseEntity<BaseRespuesta<List<SolicitudReintegroEntrada>>> respuesta = restTemplate.exchange(urlServicio,
				HttpMethod.GET, entidadEntrada,
				new ParameterizedTypeReference<BaseRespuesta<List<SolicitudReintegroEntrada>>>() {
				});

		if (respuesta.getBody() != null) {
			logger.info("buscarSolicitudes: {}", respuesta);
		}

		return respuesta.getBody().getObjetoRespuesta();
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * SolicitudReintegroService#buscarSolicitudes(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public SolicitudReintegroEntrada buscarSolicitudes(String numeroReintegro, String numeroResolucion) {
		String urlServicio = urlBuscarSolicitudReintegroResolucion.replace("{numeroReintegro}", numeroReintegro)
				.replace("{numeroResolucion}", numeroResolucion);
		logger.info("url buscarNotificacion: {}", urlServicio);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BaseRespuesta<SolicitudReintegroEntrada>> entidadEntrada = new HttpEntity<>(headers);
		ResponseEntity<BaseRespuesta<SolicitudReintegroEntrada>> respuesta = restTemplate.exchange(urlServicio,
				HttpMethod.GET, entidadEntrada,
				new ParameterizedTypeReference<BaseRespuesta<SolicitudReintegroEntrada>>() {
				});

		if (respuesta.getBody() != null) {
			logger.info("BuscarSolicitudReintegroResolucion: {}", respuesta);
		}

		return respuesta.getBody().getObjetoRespuesta();
	}

}
