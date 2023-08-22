package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static org.apache.commons.lang.StringUtils.replace;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.ArrayList;
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PreConsultaTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PersonaSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@Service
public class PreConsultaTrabajadorServiceImpl implements PreConsultaTrabajadorService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(PreConsultaTrabajadorServiceImpl.class);
	
	/**
	 * Inyeccion dependencia validadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	/**
	 * uriPreConsultaCurp
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * uriPreConsultaCurp
	 */
	@Value("${uri.comunes.preconsulta.curp}")
	private String uriPreConsultaCurp;
	
	/**
	 * uriPreConsultaNssCurp
	 */
	@Value("${uri.comunes.preconsulta.nsscurp}")
	private String uriPreConsultaNssCurp;
	
	/**
	 * restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PreConsultaTrab ajadorService#getPreconsulta(java.lang.String, java.lang.String)
	 */
	@Override
	public List<PersonaSalida> getPersonaConsulta(String nss,String curp) {
		List<PersonaSalida> persona;
		if (isNotBlank(nss)) {

			if (isNotBlank(curp)) {
				persona = preconsultaNssCurp(nss, curp);
				logger.error("preConsultaTrabajador POR : nss y curp = {} , {}", nss, curp);
			} else {
				persona = preconsultaNss(nss);
				logger.error("preConsultaTrabajador POR : nss = {} ", nss);
			}
		} else {
			persona = preconsultaCurp(curp);
			logger.error("preConsultaTrabajador POR : curp = {}", curp);
		}
		if (ObjectUtils.isEmpty(persona)) {
			persona = new ArrayList<>();
		}
		return persona;
	}
	
	
	/** 
	 * Verificar la interface o clase que lo define
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PreConsultaTrabajadorService#getPersonaConsulta(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<PersonaSalida> getPersonaConsulta(String nss,String curp,String afore){
		List<PersonaSalida> persona;
		if(isNotBlank(nss)) {
			logger.info("preConsultaTrabajador : nss = {} curp = {} afore = {}", nss, curp, afore);
			persona = preconsultaCurpNss(nss, curp, afore);
		} else {
			logger.info("preConsultaTrabajador : nss = {} curp = null afore = {}", nss, afore);
			persona = preconsultaCurp(curp, afore);
		} 
		if(ObjectUtils.isEmpty(persona)) {
			persona=new ArrayList<>();
		}
		return persona;
	}
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PreConsultaTrabajadorService#preconsultaCurp(java.lang.String, java.lang.String)
	 */
	public List<PersonaSalida> preconsultaCurp(String curp, String afore) {
		
		String uri = uriPreConsultaCurp;
		uri = replace(uri, "{curp}", curp);
		uri = replace(uri, "{afore}", afore);
		logger.info(uri);
		ResponseEntity<List<PersonaSalida>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonaSalida>>() {});
		
		return isEmpty(response.getBody()) ? null : response.getBody();
	}
	
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PreConsultaTrabajadorService#preconsultaCurpNss(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<PersonaSalida> preconsultaCurpNss(String nss, String curp, String afore) {
		
		logger.error("################## PRECONSULTA CURP - NSS - AFORE #############################");
		String uri = uriPreConsultaNssCurp;
		uri = replace(uri, "{nss}", nss);
		if(validadorUtils.isEmpty(curp)){
			uri = replace(uri, "/curp/{curp}", "");
		} else {
			uri = replace(uri, "{curp}", curp);
		}
		uri = replace(uri, "{afore}", afore);
		logger.info(uri);
		ResponseEntity<List<PersonaSalida>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonaSalida>>() {});
		
		return isEmpty(response.getBody()) ? null : response.getBody();
	}
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PreConsultaTrabajadorService#preconsultaCurp(java.lang.String)
	 */
	public List<PersonaSalida> preconsultaCurp(String curp) {
		logger.error("################## PRECONSULTA CURP #############################");
		StringBuilder ruta = new StringBuilder();
		String uri = uriComunes;
		ruta.append(uri);
		ruta.append("/trabajador/V2/curp/");
		ruta.append(curp);

		logger.error("URL Consulta CURP: {}",ruta);
		ResponseEntity<List<PersonaSalida>> response = restTemplate.exchange(ruta.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonaSalida>>() {});

		return isEmpty(response.getBody()) ? null : response.getBody();
	}
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PreConsultaTrabajadorService#preconsultaNss(java.lang.String)
	 */
	public List<PersonaSalida> preconsultaNss(String nss) {
		logger.error("################## PRECONSULTA NSS #############################");
		StringBuilder ruta = new StringBuilder();
		String uri = uriComunes;
		ruta.append(uri);
		ruta.append("/trabajador/V2/nss/");
		ruta.append(nss);

		logger.error("URL Consulta NSS: {}",uri);
		ResponseEntity<List<PersonaSalida>> response = restTemplate.exchange(ruta.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonaSalida>>() {});

	
		return isEmpty(response.getBody()) ? null : response.getBody();
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PreConsultaTrabajadorService#preconsultaNssCurp(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<PersonaSalida> preconsultaNssCurp(String nss, String curp) {
		logger.error("################## PRECONSULTA NSS CURP#############################");
		StringBuilder ruta = new StringBuilder();
		String uri = uriComunes;
		ruta.append(uri);
		ruta.append("/trabajador/V2/nss/");
		ruta.append(nss);
		ruta.append("/curp/");
		ruta.append(curp);

		logger.error("URL Consulta NSS-CURP: {}",uri);
		ResponseEntity<List<PersonaSalida>> response = restTemplate.exchange(ruta.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonaSalida>>() {});

	
		return isEmpty(response.getBody()) ? null : response.getBody();
	}

	
}
