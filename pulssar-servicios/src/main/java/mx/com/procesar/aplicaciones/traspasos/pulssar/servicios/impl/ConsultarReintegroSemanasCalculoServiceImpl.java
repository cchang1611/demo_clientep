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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarReintegroSemanasCalculoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.InicializarHeadersService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoReintegroSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaHistoricoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;


/**
 * Servicio que implementa el calculo -semanas a pagar
 * @author ANOSORIO
 *
 */
@Service
public class ConsultarReintegroSemanasCalculoServiceImpl implements ConsultarReintegroSemanasCalculoService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarReintegroSemanasCalculoServiceImpl.class);

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
	@Value("${url.realiza.calculo.reintegro.recursos}")
	private String urlrealizaCalcularReintegroRecursos;
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarReintegroSemanasCalculoService#realizarCalculoReintegro(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaHistoricoSalida)
	 */
	@Override
	public CalculoReintegroSalida realizarCalculoReintegro(ConsultaHistoricoSalida consultaHistorico) {
		logger.info("Parametros de Entrada: {}",consultaHistorico);
		HttpHeaders headers;
		CalculoReintegroSalida datosSalida= new CalculoReintegroSalida();
		headers = headersService.inicializarCabeceras();	
		datosSalida.setNss(consultaHistorico.getNss());
		datosSalida.setClaveAfore(consultaHistorico.getClaveAfore());
		datosSalida.setTipoPrestacion(consultaHistorico.getTipoPrestacion());
		datosSalida.setImportePesosReintegrar(consultaHistorico.getImportePesosReintegrar());
		datosSalida.setNumeroResolucion(consultaHistorico.getNumeroResolucion());
		datosSalida.setNombre(consultaHistorico.getNombre());
		datosSalida.setDiasDescontados(consultaHistorico.getDiasDescontados());
		datosSalida.setValorDiaReintegrar(consultaHistorico.getValorDiaReintegrar());
		datosSalida.setNumeroMaximoSemanas(consultaHistorico.getNumeroMaximoSemanas());
		datosSalida.setDiagnostico(consultaHistorico.getDiagnostico());
		datosSalida.setOrigen(consultaHistorico.getOrigen());
		logger.info("Valores datosSalida:{}",datosSalida);
		String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true,urlrealizaCalcularReintegroRecursos);
		logger.info("Url Calculo:{}",urlServicio);
		HttpEntity<CalculoReintegroSalida> entidadConsulta = new HttpEntity<>(datosSalida, headers);
		ResponseEntity<CalculoReintegroSalida> respuestaSalida = restService.exchange(urlServicio,HttpMethod.POST,entidadConsulta,CalculoReintegroSalida.class);
		CalculoReintegroSalida respuestaCalculo = respuestaSalida.getBody();
		logger.info("Respuesta Calculo Reintegro:{}",respuestaCalculo); 
		if(utileriaValidador.isEmpty(respuestaCalculo)) {
			logger.error("Error,al realizar el Calculo Semanas ");
		 }
		return respuestaCalculo;
	}
     
	
}
