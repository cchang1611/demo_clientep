package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.math.BigDecimal;

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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarReintegroSemanasHistoricoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.InicializarHeadersService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaHistoricoEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaHistoricoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * 
 * @author ANOSORIO
 *
 */
@Service
public class ConsultarReintegroSemanasHistoricoServiceImpl implements ConsultarReintegroSemanasHistoricoService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarReintegroSemanasHistoricoServiceImpl.class);

	/**
	 * Inyeccion de url para consulta de expediente por proceso
	 */
	@Value("${url.consultar.reintegro.recursos}")
	private String urlConsultaReintegroRecursos;
	
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
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarReintegroSemanasHistoricoService#consultarHistorico(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaHistoricoEntrada, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador)
	 */
	@Override
	public ConsultaHistoricoSalida consultarHistorico(DatosTrabajador trabajador) {
		logger.info("Datos Entrada consultarHistorico: {} ",trabajador);
		HttpHeaders headers;
		ConsultaHistoricoEntrada contrato =new ConsultaHistoricoEntrada();	
		headers =headersService.inicializarCabeceras();
		contrato.setNss(trabajador.getNss());
		contrato.setImportePesosReintegrar(new BigDecimal(444));
		contrato.setNumeroResolucion("33");
		contrato.setTipoPrestacion(trabajador.getTipoDePrestacion());
		contrato.setClaveAfore(trabajador.getClaveAfore());
		contrato.setOrigen(trabajador.getOrigen().intValue());
		
		String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true,urlConsultaReintegroRecursos);
		logger.info("Url Historico:{}",urlServicio);
		
	
		HttpEntity<ConsultaHistoricoEntrada> entidadConsulta = new HttpEntity<>(contrato, headers);
		
		ResponseEntity<ConsultaHistoricoSalida> respuestaSalida = restService.exchange(urlServicio,HttpMethod.POST,entidadConsulta,ConsultaHistoricoSalida.class);
		ConsultaHistoricoSalida respuesHistorico = respuestaSalida.getBody();
		logger.info("Respuesta consultarHistorico:{}",respuesHistorico); 
		
		if(utileriaValidador.isEmpty(respuesHistorico)) {
			logger.error("Error,al consultar el historico");
			
		 }
		return respuesHistorico;
		
	}

	
}
