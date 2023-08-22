package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarReintegroSemanasConfirmacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.InicializarHeadersService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoReintegroSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConfirmacionMontoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Realiza la Confirmacion Semanas Reintegro Recursoss
 * @author ANOSORIO
 *
 */
@Service
public class ConsultarReintegroSemanasConfirmacionServiceImpl implements ConsultarReintegroSemanasConfirmacionService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarReintegroSemanasConfirmacionServiceImpl.class);
	
	/**
	 * servicio
	 */
	@Autowired
	private RestTemplate restService;

	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Autowired
	private CadenasUtils utileriaCadenas;
	
	/**
	 *  Inyeccion headersService
	 */
	@Autowired
	private InicializarHeadersService  headersService;
	
	/**
	 * Inyeccion de url para urlConsultaReintegroRecursos
	 */
	@Value("${url.confirma.reintegro.recursos}")
	private String urlConfirmaReintegroRecursos;
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarReintegroSemanasConfirmacionService#realizarConfirmacionReintegro()
	 */
	@Override
	public ConfirmacionMontoSalida realizarConfirmacionReintegro(CalculoReintegroSalida calculoReintegro) {
		logger.info("Datos entrada realizarConfirmacionReintegro:{}",calculoReintegro);
		HttpHeaders headers;
		ConfirmacionMontoSalida confirmaSalida = new ConfirmacionMontoSalida();
		headers =headersService.inicializarCabeceras();
		confirmaSalida.setNss(calculoReintegro.getNss());
		confirmaSalida.setNumeroResolucion(calculoReintegro.getNumeroResolucion());
		confirmaSalida.setTipoPrestacion(calculoReintegro.getTipoPrestacion());
		confirmaSalida.setDiasDescontados(calculoReintegro.getDiasDescontados());
		confirmaSalida.setValorDiaReintegrar(calculoReintegro.getValorDiaReintegrar());
		confirmaSalida.setImportePesosReintegrar(calculoReintegro.getImportePesosReintegrar());
		confirmaSalida.setDiasCotizacionRecuperados(calculoReintegro.getDiasCotizacionRecuperados());
		confirmaSalida.setMontoMaximoReintegrar(calculoReintegro.getMontoMaximoReintegrar());
		confirmaSalida.setNumeroMaximoSemanas(calculoReintegro.getNumeroMaximoSemanas());
		confirmaSalida.setNumeroSemanasCalculadas(calculoReintegro.getNumeroSemanasCalculadas());
		confirmaSalida.setDiagnostico(calculoReintegro.getDiagnostico());
		confirmaSalida.setOrigen(calculoReintegro.getOrigen());
		String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true,urlConfirmaReintegroRecursos);
		logger.info("Url Confirma:{}",urlServicio);
		
		HttpEntity<ConfirmacionMontoSalida> entidadConsulta = new HttpEntity<>(confirmaSalida, headers);
		
		ResponseEntity<ConfirmacionMontoSalida> respuestaSalida = restService.exchange(urlServicio,HttpMethod.POST,entidadConsulta,ConfirmacionMontoSalida.class);
		
		ConfirmacionMontoSalida respuestaConfirma= respuestaSalida.getBody();
		logger.info("Respuesta Confirma Reintegro:{}",respuestaConfirma); 
		
		if(utileriaValidador.isEmpty(respuestaConfirma)) {
			logger.error("Error,No existen datos ,al realizar la Confirmacion Semanas ");
			
		 }
		
		return respuestaConfirma;
	}

}
