package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;
import java.util.List;

/**
 * 
 * @author ANOSORIO
 *
 */
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

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaExpedienteDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Clase  que consume servicios de validacion Expediente 
 * @author ANOSORIO
 *
 */
@Service
public class EstatusExpedienteServiceImpl implements EstatusExpedienteService{
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(EstatusExpedienteServiceImpl.class);
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Rest Template
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Inyeccion de url para consulta de expediente por proceso
	 */
	@Value("${url.buscar.expediente.proceso}")
	private String urlConsultaExpedienteProceso;
	
	/**
	 * Inyeccion de url para consulta estatus expediente
	 */
	@Value("${url.consulta.estatus.expediente}")
	private String urlCosultaEstatusExpediente;
	
	/**
	 * Inyeccion de url para consulta estatus expediente Servicio
	 */
	@Value("${validacion.expediente.wsdl}")
	private String urlExpedienteServicios;
	
	/**
	 * Inyeccion de url para consulta estatus expediente por tipo solicitante
	 */
	@Value("${validacion.expediente.solicitante.wsdl}")
	private String urlExpedienteTipoSolicitanteServicio;
	
	/**
	 * url consulta expediente solicitud
	 */
	@Value("${url.consulta.expediente.solicitud}")
	private String urlConsultaExpedienteSolicitud;
	
	/**
	 * url consulta expediente detalle
	 */
	@Value("${url.consulta.expediente.detalle}")
	private String urlConsultaExpedienteDetalle;
	
	/**
	 * url consulta buscar expediente
	 */
	@Value("${url.consulta.buscar.expediente}")
	private String urlConsultaBuscarExpediente;
	

	
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpedienteDetail consultarExpedienteProceso(String curp,String cvAfore,String cveProceso,String status) {
		logger.info("Datos Entrada consultarExpedienteProceso : {},{},{},{}",curp,cvAfore,cveProceso,status);
		String url = urlConsultaExpedienteProceso;
		url = url.replace("{curp}", curp);
		url = url.replace("{cveAfore}", cvAfore);
		url = url.replace("{cveProceso}", cveProceso);
		url = url.replace("{estatus}", status);
		SalidaGenerica respuesta = null;
		ObjectMapper mapper = new ObjectMapper();
		                                    
		logger.error("URL consulta estatus expedinete proceso: {}",url);
		try{
			respuesta = restTemplate.getForObject(url, SalidaGenerica.class);
		}catch(Exception e){
			logger.error("Ocurrio un error en la consulta de estatus expediente por proceso: {}",e);
		}
		logger.info("Salida respuesta:{}",respuesta);
		if(utileriaValidador.isEmpty(respuesta)){
			return null;
		}else{
			return mapper.convertValue(respuesta.getResponse(), ExpedienteDetail.class);
		}
	}  

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService#consultarEstatusExpediente(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArchivoRecibido consultarEstatusExpediente(String folio, String clave, String rOperacion) {
		logger.info("Datos Entrada consultarEstatusExpediente : {}, {}, {} ",folio,clave,rOperacion);
		String url = urlCosultaEstatusExpediente;
		url = url.replace("{folio}", folio);
		url = url.replace("{clave}", clave);
		url = url.replace("{rOperacion}", rOperacion);
		ArchivoRecibido respuesta = null;
		logger.error("URL consulta estatus expediente: {}", url);
		try{
			respuesta = restTemplate.getForObject(url, ArchivoRecibido.class);
			if(!utileriaValidador.validarObjetoNulo(respuesta)){
				logger.error("Respuesta de consulta estatus expediente: {}", respuesta);
			}
		}catch(Exception e){
			logger.error("Ocurrio un error en la consulta de estatus de expediente: {}",e);
		}
		logger.info("Salida Respuesta consultarEstatusExpediente: {}",respuesta);
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpedienteDetail consultarExpedienteProcesoSinAfore(String curp, String cveProceso, String estatus) {
		SalidaGenerica respuesta = null;
		ObjectMapper mapper = new ObjectMapper();
		String url = urlExpedienteServicios.concat("consultaEstaus/{curp}/{cveProceso}/{estatus}");
		
		url = url.replace("{curp}", curp);
		url = url.replace("{cveProceso}", cveProceso);
		url = url.replace("{estatus}", estatus);
		logger.error("URL consulta estatus de expedinte {}",url);
		
		try{
			respuesta = restTemplate.getForObject(url, SalidaGenerica.class);
			if(!utileriaValidador.validarObjetoNulo(respuesta)){
				logger.error("Respuesta de consulta estatus expediente proceso: {}", respuesta);
			}
		}catch(Exception e){
			logger.error("Ocurrio un error en la consulta de estatus expediente por proceso: {}",e);
		}
		return mapper.convertValue(respuesta.getResponse(), ExpedienteDetail.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpedienteSalida validarRestExpedientes(String curp) {		
		
		StringBuilder url = new StringBuilder();
		url.append(urlExpedienteServicios);
		url.append(curp);
		logger.info("url consulta expeiente {}",url);
		ObjectMapper mapper = new ObjectMapper();
		SalidaGenerica salidaGenerica = restTemplate.getForObject(url.toString(), SalidaGenerica.class);

		logger.info("salida : {} ",salidaGenerica);
		
		return mapper.convertValue(salidaGenerica.getResponse(), ExpedienteSalida.class);
		
	} 
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpedienteSalida validarRestExpedienteTipoSolicitante(String curp,String tiposolicitante) {
		String url = urlExpedienteTipoSolicitanteServicio;
		url = url.replace("{curp}", curp);
		url = url.replace("{tipoSolicitante}", tiposolicitante);

		logger.info("url consulta validarRestExpedienteTipoSolicitante {}",url);
		ObjectMapper mapper = new ObjectMapper();
		SalidaGenerica salidaGenerica = restTemplate.getForObject(url, SalidaGenerica.class);

		logger.info("salida validarRestExpedienteTipoSolicitante: {} ",salidaGenerica);
		
		return mapper.convertValue(salidaGenerica.getResponse(), ExpedienteSalida.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExpedienteDetail consultaExpedienteSolicitud(String cvTipoProceso, String cvServicio, String cvAfore, String curpTrabajador, String cvEstatusExpe) {
		logger.info("Datos Entrada consultaExpedienteSolicitud : {}, {}, {}, {}, {} ",cvTipoProceso,cvServicio,cvAfore,curpTrabajador,cvEstatusExpe);
		String url = urlConsultaExpedienteSolicitud;
		url = url.replace("{cvTipoProceso}", cvTipoProceso);
		url = url.replace("{cvServicio}", cvServicio);
		url = url.replace("{cvAfore}", cvAfore);
		url = url.replace("{curpTrabajador}", curpTrabajador);
		url = url.replace("{cvEstatusExpe}", cvEstatusExpe);

		ExpedienteDetail respuesta = null;
		logger.error("URL consulta estatus consultaExpedienteSolicitud: {}", url);
		try{
			respuesta = restTemplate.getForObject(url, ExpedienteDetail.class);
			if(!utileriaValidador.validarObjetoNulo(respuesta)){
				logger.error("Respuesta de consulta consultaExpedienteSolicitud: {}", respuesta);
			}
		}catch(Exception e){
			logger.error("Ocurrio un error en la consulta de consultaExpedienteSolicitud: {}",e);
		}
		logger.info("Salida Respuesta consultaExpedienteSolicitud: {}",respuesta);
		return respuesta;
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RespuestaExpedienteDetalle> buscarExpendienteServ(Long idArchivoRecibido) {
		logger.info("Datos Entrada buscarExpendienteServ : {} ",idArchivoRecibido);
		List<RespuestaExpedienteDetalle> respuestaServicio = null;
		try{
			String url = urlConsultaExpedienteDetalle;
			url = url.replace("{idArchivoRecibido}", String.valueOf(idArchivoRecibido));
	
	
			logger.error("URL consulta estatus expediente: {}", url);
		
			ResponseEntity<List<RespuestaExpedienteDetalle>> respuesta = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RespuestaExpedienteDetalle>>(){});
			if(!ObjectUtils.isEmpty(respuesta)) {
				respuestaServicio = respuesta.getBody();
			}
			if(!utileriaValidador.validarObjetoNulo(respuesta)){
				logger.error("Respuesta de consulta buscarExpendienteServ: {}", respuesta);
			}
		}catch(Exception e){
			logger.error("Ocurrio un error en la consulta de buscarExpendienteServ: {}",e);
		}
		logger.info("Salida Respuesta buscarExpendienteServ: {}",respuestaServicio);
		return respuestaServicio;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ExpedienteDetail> buscarExpediente(String curp, String chFolio, String chAfore, String nuEstatus, String cvTipoProceso) {
		logger.info("Datos Entrada buscarExpediente : {}, {}, {}, {}, {} ",curp,chFolio,chAfore,nuEstatus,cvTipoProceso);
		List<ExpedienteDetail> respuestaDetalle = null;
		try{
			String url = urlConsultaBuscarExpediente;
			url = url.replace("{curp}", curp);
			url = url.replace("{chFolio}", chFolio);
			url = url.replace("{chAfore}", chAfore);
			url = url.replace("{nuEstatus}", nuEstatus);
			url = url.replace("{cvTipoProceso}", cvTipoProceso);

	
	
			logger.error("URL consulta buscarExpediente: {}", url);
		
			ResponseEntity<List<ExpedienteDetail>> respuesta = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<ExpedienteDetail>>(){});
			if(!ObjectUtils.isEmpty(respuesta)) {
				respuestaDetalle = respuesta.getBody();
			}
			if(!utileriaValidador.validarObjetoNulo(respuestaDetalle)){
				logger.error("Respuesta de consulta buscarExpediente: {}", respuestaDetalle);
			}
		}catch(Exception e){
			logger.error("Ocurrio un error en la consulta de buscarExpediente: {}",e);
		}
		logger.info("Salida Respuesta buscarExpediente: {}",respuestaDetalle);
		return respuestaDetalle;
	}

}
