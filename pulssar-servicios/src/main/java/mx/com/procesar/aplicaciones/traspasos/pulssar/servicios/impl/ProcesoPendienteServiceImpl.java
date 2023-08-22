package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoPendienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendiente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendienteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramiteComparadorInformacionGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

@Service
public class ProcesoPendienteServiceImpl implements ProcesoPendienteService{

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProcesoPendienteServiceImpl.class);
	
	
	/**
	 * Inyeccion de rest
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	
	
	/**
	 * url de servicio para proceso pendiente
	 */
	@Value("${url.proceso.pendiente}")
	private String urlProcesoPendiente;
	
	/**
	 * 
	 */
	@Value("${url.solicitud.comparador.generico}")
	private String urlsolicitudComparadorG;
	
	/**
	 * Inyeccion de dependencia validadorUtils
	 */
    @Autowired
	private ValidadorUtils validadorUtils;
    
	/**
	 * url comunes
	 */
	@Value("${uri.comunes}")
	private String urlComunes;
	
	/**
	 * url comunes transaccional
	 */
	@Value("${uri.comunes.transaccional}")
	private String urlComunesTransaccional;

	/**
	 * Invocacion al servicio de proceso pendiente
	 */ 
	@Override
	public <T> void insertarProcesoPendiente(ProcesoPendienteEntrada<T> procesoPendiente) {
		logger.error("Entrando a proceso pendiente");
		logger.error("Entrada Bitacora: {}",procesoPendiente);
		ResponseEntity<String> respuesta = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		logger.error("url bitacora Proceso pendiente: {} ",urlProcesoPendiente);
          try{
		   HttpEntity<ProcesoPendienteEntrada<T>> entity = new HttpEntity<>(procesoPendiente,headers);
			respuesta = servicioCliente.exchange(urlProcesoPendiente, HttpMethod.POST,entity,String.class);
			logger.error("Respuesta de Proceso pendiente: {} ",respuesta);
		}catch(Exception e){
			logger.error("Se presento un problema al insertar proceso pendiente",e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> RespuestaSolicitud insertarProcesoSolicitudComparador(TramiteComparadorInformacionGenerico<T> solicitud){
		RespuestaSolicitud salida = null;
		logger.info("Entrada proceso solicitud comparador {}",solicitud);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		logger.error("Url insercion solicitud comparador generico: {}",urlsolicitudComparadorG);
		HttpEntity<TramiteComparadorInformacionGenerico<T>> entity = new HttpEntity<>(solicitud,headers);
		ResponseEntity<String> response =servicioCliente.exchange(urlsolicitudComparadorG, HttpMethod.POST,entity,String.class);
		logger.error("Respuesta insertarProcesoSolicitudComparador: {}",response);
		if(!validadorUtils.validarObjetoNulo(response) && !validadorUtils.isEmpty(response.getBody())) {
			JsonUtilsImpl<RespuestaSolicitud> jsonSalida = new JsonUtilsImpl<>();
			salida = jsonSalida.parseJsonToObject(response.getBody(), RespuestaSolicitud.class);
		}

		return salida;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProcesoPendiente consultaProcesoPendienteIdfolio(String idFolio,String estatus) {
		ProcesoPendiente respuesta = null;
		String url = null;
		try {
			url = urlComunes.concat("procesoPendiente/consultaProcesoPendienteIdFolio/{idFolio}/{estatus}");
			url = url.replace("{idFolio}", idFolio);
			url = url.replace("{estatus}", estatus);
			logger.error("URL consultaProcesoPendienteIdfolio {}",url);
	
			 respuesta = servicioCliente.getForObject(url, ProcesoPendiente.class);
			logger.info("Respuesta consultarRegistroProcesosPendientes: {}",respuesta);
		}catch(Exception e){
			logger.error("Ocurrio un error en consultarRegistroProcesosPendientes: {}",e);
		}
		return respuesta;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoPendienteService#eliminarProcesoPendiente(java.lang.String, java.lang.String)
	 */
	@Override
	public void eliminarProcesoPendiente(String curp, String procesos) {
		StringBuilder sb = new StringBuilder(urlComunesTransaccional);
		sb.append("procesoPendiente/").append(curp).append("/").append(procesos);
		logger.info("URL eliminarProcesoPendiente {}",sb);
		try {
			servicioCliente.delete(sb.toString());
			logger.info("Respuesta eliminarProcesoPendiente OK");
		} catch (Exception e) {
			logger.error("Ocurrio un error en eliminarProcesoPendiente: {}", e);
		}
	}
}
