package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AnexoATrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AnexoATrabajadorIssste;

/**
 * Implementacion de servicio anexo trabajador
 * @author JMGUTIEG
 *
 */
@Service
public class AnexoATrabajadorServiceImpl implements AnexoATrabajadorService{

	
	/**
	 * url consulta buscar expediente
	 */
	@Value("${url.consulta.anexo.trabajador}")
	private String urlConsultaAnexoTrabajador;
	
	/**
	 * Rest Template
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(AnexoATrabajadorServiceImpl.class);
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<AnexoATrabajadorIssste> consultaAnexoTrabajador(String curp) {
		logger.info("Entrada consultaAnexoTrabajador :: {}",curp);
		List<AnexoATrabajadorIssste> respuestaAnexo = null;
		try {
			String url = urlConsultaAnexoTrabajador;
			url = url.replace("{curp}", curp);
			
			logger.info("url consultaAnexoTrabajador :: {}",url);
			
			ResponseEntity<List<AnexoATrabajadorIssste>> respuesta = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<AnexoATrabajadorIssste>>(){});
			if(!ObjectUtils.isEmpty(respuesta)) {
				respuestaAnexo = respuesta.getBody();
			}
		}catch (Exception e) {
			logger.error("Ocurrio un error en la consulta de consultaAnexoTrabajador: {}",e);
		}
		logger.info("Salida Respuesta consultaAnexoTrabajador: {}",respuestaAnexo);

		return respuestaAnexo;
	}

}
