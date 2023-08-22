package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SaldosPreliminaresService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosEntradaSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Clase que implementa la logica del consumo del servicio de
 * 
 * @author DBARBOSA
 * @version 1.0
 */
@Service("trabajadorImssService")
public class SaldosPreliminaresServiceImpl implements SaldosPreliminaresService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(SaldosPreliminaresServiceImpl.class);
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Value("${url.servicio.comunes}")
	private String servicioComunes;
	
	/**
	 * Inyeccion de servico catalogo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;

	/**
	 * Inyeccion de utileria validadro
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion Rest
	 */
	@Autowired
	private RestTemplate clienteServicio;
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Autowired
	private CadenasUtils utileriaCadenas;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatosSaldos obtenerSaldosPreliminares(String curp, String nss, String claveAfore) {
		logger.info("Se obtiene saldos preliminares: {}", curp);
		ParametrosEntradaSaldos entradaSaldos = new ParametrosEntradaSaldos();
		entradaSaldos.setCurp(curp);
		entradaSaldos.setNss(nss);
		entradaSaldos.setAfore(claveAfore);
		DatosSaldos saldos = new DatosSaldos();
		try{
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<ParametrosEntradaSaldos> entity = new HttpEntity<>(entradaSaldos,headers);
			
			String urlServicio = this.validarPeticionIssste(claveAfore, AgenteConstants.PARAMETRO_AFORES_CONSULTA_SALDO, ExpresionesConstants.VACIO);
			logger.info("Se consume el servicio de saldos ::: {}", urlServicio);
			ResponseEntity<DatosSaldos> response = clienteServicio.exchange(urlServicio, HttpMethod.POST, entity, DatosSaldos.class);
			saldos = response.getBody();
			logger.info("Respuesta de saldos ::: {}", saldos);
			if(!utileriaValidador.validarVacio(saldos.getMotivoRechazo())) {
				RespuestaServicio mensajeRechazo = servicioCatalogo.obtenerRespuesta(null, saldos.getMotivoRechazo(), claveAfore, NumerosConstants.INT_DOS, null);
				saldos.setDescripcion(mensajeRechazo.getMensaje());
			}
		} catch (Exception e) {
			logger.error("Se presento problema al consultar saldos preliminares {}", claveAfore, e);
		}
		return saldos;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatosSaldos obtenerSaldos(String curp, String nss, String claveAfore) {
		logger.info("Se obtiene saldos preliminares: {}", curp);
		ParametrosEntradaSaldos entradaSaldos = new ParametrosEntradaSaldos();
		entradaSaldos.setCurp(curp);
		entradaSaldos.setNss(nss);
		entradaSaldos.setAfore(claveAfore);
		DatosSaldos saldos = new DatosSaldos();
		try{
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<ParametrosEntradaSaldos> entity = new HttpEntity<>(entradaSaldos,headers);
			
			String urlServicio = this.validarPeticionIssste(claveAfore, AgenteConstants.PARAMETRO_AFORES_CONSULTA_EXTRA, AgenteConstants.VALOR_SALDOS_PREVIOS_IMSS);
			logger.info("Se consume el servicio de saldos ::: {}", urlServicio);
			ResponseEntity<DatosSaldos> response = clienteServicio.exchange(urlServicio, HttpMethod.POST, entity, DatosSaldos.class);
			saldos = response.getBody();
			logger.info("Respuesta de saldos ::: {}", saldos);
			if(!utileriaValidador.validarVacio(saldos.getMotivoRechazo())) {
				RespuestaServicio mensajeRechazo = servicioCatalogo.obtenerRespuesta(null, saldos.getMotivoRechazo(), claveAfore, NumerosConstants.INT_DOS, null);
				saldos.setDescripcion(mensajeRechazo.getMensaje());
			}
		} catch (Exception e) {
			logger.error("Se presento problema al consultar saldos preliminares {}", claveAfore, e);
		}
		return saldos;
	}
	
	/**
	 * Metodo encargado de validar la peticion a Imss o Issste de saldos
	 * @param claveAfore
	 * @return
	 */
	private String validarPeticionIssste(String claveAfore, String cvParametro, String valor) {
		String urlServicio = AgenteConstants.CLAVE_AFORES_SALDOS_IMSS;
		List<Parametro> parametros = servicioCatalogo.obtenerParametro(cvParametro, null);
		String valueParametro = utileriaValidador.obtenerValorParametro(parametros, claveAfore, valor);
		
		if(!utileriaValidador.validarVacio(valueParametro)) {
			urlServicio = valueParametro;
		} else if(ServiciosConstants.AFORE_PEIS.equals(claveAfore)) {
			urlServicio = AgenteConstants.CLAVE_AFORES_SALDOS_ISSSTE;
		}
		return utileriaCadenas.obtenerCadenaConcatenada(true, servicioComunes, urlServicio);
	}
}