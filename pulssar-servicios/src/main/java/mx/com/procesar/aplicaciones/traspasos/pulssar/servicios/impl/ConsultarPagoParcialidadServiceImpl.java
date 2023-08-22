package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RetiroParcialCalculoImssList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPagoParcialidadService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Servicio para consumir los pagos por parcialidades
 * @author ANOSORIO
 *
 */
@Service
public class ConsultarPagoParcialidadServiceImpl implements ConsultarPagoParcialidadService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarPagoParcialidadServiceImpl.class);
	/**
	 * Inyeccion de url para consulta de expediente por proceso
	 */
	@Value("${url.buscar.pagos.parcialidad}")
	private String urlConsultaPagoParcialidad;
		
	/**
	 * Rest Template
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPagoParcialidadService#consultarPagoParcialidades(java.lang.String)
	 */ 
	@Override
	public RetiroParcialCalculoImssList consultarPagoParcialidades(String idProcesar) {
		RetiroParcialCalculoImssList listaPagoParcialidades = new RetiroParcialCalculoImssList();
		logger.info("Datos Entrada consultarPagoParcialidades: {} ",idProcesar);
		String url = urlConsultaPagoParcialidad;
		url = url.replace("{idProcesar}", idProcesar);
		logger.info("Url:{}",url);
		try {
			listaPagoParcialidades = restTemplate.getForObject(url, RetiroParcialCalculoImssList.class);
			if(utileriaValidador.validarObjetoNulo(listaPagoParcialidades.getListaRetiroParcial())){
				logger.error("No existen pagos por Parcialidades");
			}
		}catch (Exception e) {
			logger.error("Ocurrio un error en la consulta de Pagos por Parcialidades: {}",e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		
	return listaPagoParcialidades;
	}
}
