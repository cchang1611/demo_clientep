package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RespuestaDeepDiveService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidacionDomicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidacionIdentificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * interfaz servicio para la validación del sello
 * 
 * @author dbarbosa
 * @version 1.0
 */
@Service
public class RespuestaDeepDiveServiceImpl implements RespuestaDeepDiveService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RespuestaDeepDiveServiceImpl.class);

	/**
	 * Inyeccion utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion de rest
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	/**
	 * ValidacionIdentificacion y domicilio 
	 */
	@Value("#{propiedades['url.validacion.identificacion.domicilio']}")
	private String urlValidaIdentificacionDomicilio;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidacionDomicilio consultarRespuestaDeepDiveDomicilio(String afore, String curp, String tipoArchivo, String tipoExpediente) {
		try {
			ResponseEntity<String> respuestaServicio = this.consultarValidacionDeepDive("domicilio", afore, curp, tipoArchivo, tipoExpediente);
			if(respuestaServicio.getStatusCode() == HttpStatus.OK && !utileriaValidador.validarObjetoNulo(respuestaServicio.getBody())) {
				JsonUtilsImpl<ValidacionDomicilio> jsonDomicilio = new JsonUtilsImpl<>();
				List<ValidacionDomicilio> lstDomicilio = jsonDomicilio.parseJsonToObjectList(respuestaServicio.getBody(), ValidacionDomicilio.class);
				if(!utileriaValidador.validarListaVacia(lstDomicilio)) {
					return lstDomicilio.get(NumerosConstants.INT_CERO);
				}
			}
		} catch (Exception e) {
			logger.info("Error al consulta la respuesta de deep dive domicilio: curp {} afore {} archivo{} expediente{}.", curp, afore, tipoArchivo, tipoExpediente, e);
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidacionIdentificacion consultarRespuestaDeepDiveIdentificacion(String afore, String curp, String tipoArchivo, String tipoExpediente) {
		try {
			ResponseEntity<String> respuestaServicio = this.consultarValidacionDeepDive("identificacion", afore, curp, tipoArchivo, tipoExpediente);
			JsonUtilsImpl<ValidacionIdentificacion> jsonIdentificacion = new JsonUtilsImpl<>();
			List<ValidacionIdentificacion> lstIdentificacion = jsonIdentificacion.parseJsonToObjectList(respuestaServicio.getBody(), ValidacionIdentificacion.class);
			if(!utileriaValidador.validarListaVacia(lstIdentificacion)) {
				return lstIdentificacion.get(NumerosConstants.INT_CERO);
			}
		} catch (Exception e) {
			logger.info("Error al consulta la respuesta de deep dive identificacion: curp {} afore {} archivo{} expediente{}.", curp, afore, tipoArchivo, tipoExpediente, e);
		}
		return null;
	}
	
	/**
	 * Metodo encargado de armar la url del servicio de deep dive
	 * 
	 * @param servicio
	 * @param afore
	 * @param curp
	 * @param tipoArchivo
	 * @param tipoExpediente
	 * @return
	 */
	private ResponseEntity<String> consultarValidacionDeepDive(String servicio, String afore, String curp, String tipoArchivo, String tipoExpediente) {
		ResponseEntity<String> respuestaServicio = null;
		try {
			String urlServicio = new String(urlValidaIdentificacionDomicilio);
			urlServicio = urlServicio.replace("{servicio}", servicio);
			urlServicio = urlServicio.replace("{claveAfore}", afore);
			urlServicio = urlServicio.replace("{curp}", curp);
			urlServicio = urlServicio.replace("{tipoArchivo}", tipoArchivo);
			urlServicio = urlServicio.replace("{tipoExpediente}", tipoExpediente);
			
			HttpHeaders headerAutorizacionUsuarios = new HttpHeaders();
			headerAutorizacionUsuarios.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> httpEntidad = new HttpEntity<>(headerAutorizacionUsuarios);
			
			respuestaServicio = servicioCliente.exchange(urlServicio, HttpMethod.GET, httpEntidad, String.class);
		} catch (Exception e) {
			logger.info("Error al consulta la respuesta de deep dive {}: curp {} afore {} archivo{} expediente{}.", servicio, curp, afore, tipoArchivo, tipoExpediente, e);
		}
		return respuestaServicio;
	}
}