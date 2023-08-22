package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.Date;

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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaFolioDactilar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SelloProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SelloVirtualEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.VerificacionSello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;


/**
 * @author medoming
 *
 */
@Service
public class ConsultaSelloServiceImpl implements ConsultaSelloService{
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultaSelloServiceImpl.class);
	

	/**
	 * Url Servicio Consulta Sello
	 */
	@Value("${url.sello}")
	private String urlSello;
	
	/**
	 * urlGuardarSello
	 */
	@Value("${url.guardar.sello}")
	private String urlGuardarSello;
	
	/**
	 * Url servicio actualizar folio
	 */
	@Value("${uri.sello.actualizar}")
	private String urlSelloActualizar;
	
	/**
	 * Inyeccion de ValidadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	
	/**
	 * Inyeccion de RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Inyeccion de porpiedad de servicio sello virtual
	 */
	@Value("${servicio.sello.generarSelloVirtual}")
	private String urlServicioSelloVirtual;
	
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloProxyService#obtenerSelloTrabajador(java.lang.String)
	 */
	@Override
	public Sello obtenerSelloTrabajador(String curpEmpleado, String curpTrabajador, String claveAfore){
		VerificacionSello salida;
		String url = new StringBuilder(urlSello).append(ModificacionTrabajadorConstants.SELLO_TRABAJADOR).toString();
		url = url.replace("{curpEmpleado}", curpEmpleado);
		url = url.replace("{curpTrabajador}", curpTrabajador);
		url = url.replace("{claveAfore}", claveAfore);
		
		logger.info("URL consulta Sello Trabajador: {}", url);		
		
		salida = restTemplate.getForObject(url, VerificacionSello.class);
		logger.info("Salida consulta Sello Trabajador: {}", salida);
		if (validadorUtils.validarObjetoNulo(salida) || validadorUtils.validarObjetoNulo(salida.getSello())) {
			throw new BusinessException("EL TRABAJADOR NO CUENTA CON SELLO");
		}

		return salida.getSello();
	}
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloProxyService#obtenerSelloEmpleado(java.lang.String)
	 */
	@Override
	public Sello obtenerSelloEmpleado(String curpEmpleado, String claveAfore){
		VerificacionSello salida;
		String url = new StringBuilder(urlSello).append(ModificacionTrabajadorConstants.SELLO_EMPLEADO).toString();
		url = url.replace("{curpEmpleado}", curpEmpleado);
		url = url.replace("{claveAfore}", claveAfore);
		
		logger.error("URL consulta Sello Empleado: {}", url);
		salida = restTemplate.getForObject(url, VerificacionSello.class);
		if (validadorUtils.validarObjetoNulo(salida) || validadorUtils.validarObjetoNulo(salida.getSello())) {
			throw new BusinessException("EL EMPLEADO NO CUENTA CON SELLO");
		}
		return salida.getSello();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void guardarSello(Long sello, String proceso) {
		SelloProceso sp = new SelloProceso();
		sp.setIdSello(sello);
		sp.setFechaControl(new Date());
		sp.setUsuarioModificador("PortalPulssar");
		sp.setTipoProceso(proceso);
		logger.info("SelloProceso {}" , sp);
		logger.info(urlGuardarSello);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<SelloProceso> entity = new HttpEntity<>(sp, headers);
		try {
			restTemplate.exchange(urlGuardarSello, HttpMethod.POST, entity, new ParameterizedTypeReference<SelloProceso>() {});
		} catch (Exception e) {
			logger.error("Ocurrio un error al guardar sello{}", e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public VerificacionSello consultarSelloFlujoModificacion(String curpEmpleado, String curpTrabajador, String claveAfore){
		VerificacionSello salida = null;
		try {
			String url = new StringBuilder(urlSello).append(ModificacionTrabajadorConstants.SELLO_TRABAJADOR).toString();
			url = url.replace("{curpEmpleado}", curpEmpleado);
			url = url.replace("{curpTrabajador}", curpTrabajador);
			url = url.replace("{claveAfore}", claveAfore);
			
			logger.info("URL consulta Sello Trabajador: {}", url);		
			
			salida = restTemplate.getForObject(url, VerificacionSello.class);
			logger.info("Salida consulta Sello Trabajador: {}", salida);
		}catch (Exception e) {
			logger.error("Ocurrio un error al consultarSelloFlujoModificacion: {}",e);
		}


		return salida;
	}
	
	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.traspasos.plataformaServiciosAzteca.servicios.
	 * SelloTrabajadorProxyService#generarSelloVirtual(mx.com.procesar.servicios.
	 * traspasos.plataformaServiciosAzteca.servicios.modelo.SelloVirtualEntrada)
	 */
	@Override
	public SalidaGenerica generarSelloVirtual(SelloVirtualEntrada entrada) {
		SalidaGenerica salida = null;
		HttpHeaders headers = null;

		try {
			logger.error("Entrada servicio generarSelloVirtual: {}", entrada);

			headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<SelloVirtualEntrada> entity = new HttpEntity<>(entrada, headers);
			ResponseEntity<SalidaGenerica> responseWS = restTemplate.exchange(urlServicioSelloVirtual, HttpMethod.POST,
					entity, SalidaGenerica.class);

			salida = responseWS.getBody();
		} catch (Exception e) {
			logger.error("Ocurrio un error en el servicio de generación del sello virtual: {}", e);
		}

		return salida;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actualizarSelloProspecto(String agente, Long idSello) {
		EntradaFolioDactilar entrada = new EntradaFolioDactilar();
		entrada.setIdSello(idSello);
		entrada.setUsuarioModificador(agente);
		String url = new StringBuilder(urlSelloActualizar).append(ServiciosConstants.RUTA_ACTUALIZAR_SELLO_UTILIZADO).toString();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		logger.info("URL actualizar Sello Trabajador: {} , datos {}", url, entrada);
		HttpEntity<EntradaFolioDactilar> entity = new HttpEntity<>(entrada, headers);
		ResponseEntity<String> responseWS = restTemplate.exchange(url, HttpMethod.POST,
				entity, String.class);
		logger.info("Sello actualizado: {}", entrada);
		logger.info("Respuesta: {}", responseWS);
	}
}