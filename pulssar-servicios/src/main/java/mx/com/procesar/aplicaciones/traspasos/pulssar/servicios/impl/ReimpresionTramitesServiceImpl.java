package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang.CharEncoding;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivoZipService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CorreoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MenuReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ClavesDocumentoReimpresionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CorreoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BitacoraEntradaImpresionEnvio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCorreo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaReimpresion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;


/**
 * Reimpresion Tramites Service Impl
 * @author jmordone
 *
 */
@Service
public class ReimpresionTramitesServiceImpl implements ReimpresionTramitesService{
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ReimpresionTramitesServiceImpl.class);
	
	/**
	 * urlComunes
	 */
	@Value("${uri.comunes}")
	private String urlComunes;
	
	/**
	 * urlTransaccional
	 */
	@Value("${uri.comunes.transaccional}")
	private String urlTransaccional;
	
	/**
	 * restServiceClientUtils
	 */
	@Autowired
	private RestServiceClientUtils restServiceClientUtils;
	
	/**
	 * dependencia utilidad validador
	 */
	@Autowired 
	private ValidadorUtils validadorUtils;
	
	/**
	 * Inyeccion de RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Dependencia utileria cadena
	 */
	@Autowired
	private CadenasUtils cadenasUtils;
	
	/**
	 * MenuReimpresionService
	 */
	@Autowired
	private MenuReimpresionService menuReimpresionService;
	
	/**
	 * archivoZipService
	 */
	@Autowired
	private ArchivoZipService archivoZipService;
	
	/**
	 * Inyeccion de servicio Correo
	 */
	@Autowired
	private CorreoService servicioCorreo;
	
	
	/**
	 * obtenerPdfPorClave
	 * @param listaDeArchivosExtraidosPorZipOFilenet
	 * @return
	 */
	@Override
	public DatosArchivos obtenerPdfPorClave(List<DatosArchivos> listaDeArchivosExtraidosPorZip,Integer tipoTramite ) {
		DatosArchivos salida= new DatosArchivos();
		for (DatosArchivos datosArchivos : listaDeArchivosExtraidosPorZip) {
			logger.error("Clave documento a buscar:: {}",obtenerClaveDocumento(datosArchivos.getNombreArchivo(),tipoTramite));
			if(!FormatoConstants.TIPO_EXTENSION_XML.equals(datosArchivos.getFormato()) && 
					obtenerClaveDocumento(datosArchivos.getNombreArchivo(),tipoTramite).equals(obtenerClaveDocumentoPdf(tipoTramite))) {
				salida = datosArchivos;
				break;
			}else {	
				logger.error("No es el archivo para consentimiento o modificador de datos :: {}",datosArchivos.getNombreArchivo().concat(datosArchivos.getFormato()));
			}
		}
		return salida;
		
	}
	
	/**
	 * obtenerClaveDocumentoPdf
	 * @param tramite
	 * @return
	 */
	private String obtenerClaveDocumentoPdf(Integer tramite) {
		MenuReimpresionEnum servicio=MenuReimpresionEnum.obtenerDescripcion(tramite);
		String claveDocumento=null;
		switch (servicio) {
			case CONSENTIMENTO_ENROLAMIENTO:
				claveDocumento=ClavesDocumentoReimpresionEnum.CONSENTIMENTO_ENROLAMIENTO.getClaveDocumento();
		break;
			case SOLICITUD_MODIFICACION_DATOS:
				claveDocumento=ClavesDocumentoReimpresionEnum.SOLICITUD_MODIFICACION_DATOS.getClaveDocumento();
		break;
			default:
		break;
	   }
	  return claveDocumento;
	}
	
	/**
	 * guardarBitacoraImpresionEnvio
	 * @param trabajador
	 * @param envioOImpresion
	 * @param folioPulsar
	 */
	@Override
	public void guardarBitacoraImpresionEnvio(String envioOImpresion,String tipoTramite,String idSeguimiento,String claveAgente) {
		BitacoraEntradaImpresionEnvio bitacoraEntradaImpresionEnvio = new BitacoraEntradaImpresionEnvio();
		bitacoraEntradaImpresionEnvio.setFcControl(new Date());
		bitacoraEntradaImpresionEnvio.setIdSeguimiento(Long.valueOf(idSeguimiento));
		bitacoraEntradaImpresionEnvio.setTipoSolicitud(FormatoConstants.TIPO_SOLICITUD_REIMPRESION);
		bitacoraEntradaImpresionEnvio.setTramiteSeguimiento(tipoTramite);
		bitacoraEntradaImpresionEnvio.setIndicativo(envioOImpresion);
		bitacoraEntradaImpresionEnvio.setUsuarioModificador(FormatoConstants.USUARIO_MODIFICADOR_PULLSAR);
		bitacoraEntradaImpresionEnvio.setClaveAgente(claveAgente);
		guardarBitacoraReimpresion(bitacoraEntradaImpresionEnvio);
	}
	
	
	/**
	 * obtenerTipoClaveDocumento
	 * @param modulo
	 * @return
	 */
	@Override
	public String obtenerTipoClaveDocumento(Integer modulo) {
		MenuReimpresionEnum servicio=MenuReimpresionEnum.obtenerDescripcion(modulo);
		return servicio.getClaveDocumento();
		
	}
	
	/**
	 * obtenerServicioBitacoraReimpresion
	 * @param bitacoraEntradaImpresionEnvio
	 */
	private void guardarBitacoraReimpresion(BitacoraEntradaImpresionEnvio bitacoraEntradaImpresionEnvio) {
		StringBuilder url = new StringBuilder();
		url.append(urlTransaccional);
		url.append(ServiciosConstants.CONSULTA_GUARDAR_BITACORA_REIMPRESION);
		try {
			logger.error("La ruta del llamado del servicio guardarBitacoraReimpresion :: {}",url);
		    restServiceClientUtils.ejecutarServicioPost(url.toString(),bitacoraEntradaImpresionEnvio, String.class);		
		}catch(Exception e) {
			logger.error("Error en  guardarBitacoraReimpresion :: {}",e);
		}
		
	}
	
	/**
	 * obtenerTramitesConcluidos
	 * @param tramitesConcluidosEntrada
	 * @return
	 */
	@Override
	public TramitesConcluidos obtenerTramitesConcluidos(TramitesConcluidosEntrada tramitesConcluidosEntrada) {
		TramitesConcluidos tramitesConcluidos = null;
		StringBuilder url = new StringBuilder();
		url.append(urlComunes);
		url.append(ServiciosConstants.CONSULTA_TRAMITES_CONCLUIDOS);
		try {
			logger.error("La ruta del llamado del servicio obtenerTramitesConcluidos :: {}",url);
			tramitesConcluidos= restServiceClientUtils.ejecutarServicioPost(url.toString(),tramitesConcluidosEntrada, TramitesConcluidos.class);		
		}catch(Exception e) {
			throw new BusinessException("Existe un error al obtener los tramites concluidos",e);
		}
		return tramitesConcluidos;
		
	}
	
	/**
	 * (non-Javadoc)
	 * @see mx.com.procesar.servicios.traspasos.comparador.servicios.ArchivoZipService#obtenerClaveParaDocumentoObligatorio(java.lang.String)
	 */
	private String obtenerClaveDocumento(String cadena,Integer tramite) {
		MenuReimpresionEnum servicio=MenuReimpresionEnum.obtenerDescripcion(tramite);
		String claveDocumento="";
		switch (servicio) {
			case CONSENTIMENTO_ENROLAMIENTO:
				claveDocumento=cadena.substring(FormatoConstants.POSICION_CLAVE_ARCHIVO-1, FormatoConstants.POSICION_CLAVE_ARCHIVO +  1);
		break;
			case SOLICITUD_MODIFICACION_DATOS:
				claveDocumento=cadena.substring(FormatoConstants.POSICION_CLAVE_ARCHIVO, FormatoConstants.POSICION_CLAVE_ARCHIVO +  2);
		break;
			default:
		break;
	   }	
		return claveDocumento;
		
	}
	
	/**
	 * convertirJsonObjeto
	 * @param json
	 * @param typeParamClass
	 * @return
	 */
	@Override	
	public <T> T convertirJsonObjeto(String json, Class<T> typeParamClass) {
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			T obj = null;
			try {
				obj = mapper.readValue(json.getBytes(CharEncoding.UTF_8), typeParamClass);
			} catch (Exception ex) {
				logger.info("Ocurrio un error al : procesar ", ex);
			}
			return obj;
	}
	
	
	/**
	 * obtenerMensajeSinDatos
	 * @return
	 */
	@Override
	public DatosArchivos obtenerMensajeSinDatos() {
		DatosArchivos datosArchivos=new DatosArchivos();
		datosArchivos.setErrorArchivo(Boolean.TRUE);
		datosArchivos.setMensajeError(FormatoConstants.ERROR_SIN_TRAMITE);
		datosArchivos.setClaveError(FormatoConstants.ERROR_CLAVE_SIN_TRAMITE);
		return datosArchivos;
	}
	
	/**
	 * obtenerMensajeSinDatos
	 * @return
	 */
	@Override
	public DatosArchivos obtenerMensajeSinRespuestaAfore() {
		DatosArchivos datosArchivos=new DatosArchivos();
		datosArchivos.setErrorArchivo(Boolean.TRUE);
		datosArchivos.setMensajeError(FormatoConstants.ERROR_SIN_RESPUESTA_AFORE);
		datosArchivos.setClaveError(FormatoConstants.ERROR_SIN_RESPUESTA_AFORE_CLAVE);
		return datosArchivos;
	}
	
	
	/**
	 * convertirJsonObjeto
	 * @param <T>
	 * @param json
	 * @param typeParamClass
	 * @return
	 */
	@Override
	public String convertirObjetoToJson(Object typeParamClass) {
			ObjectMapper mapper = new ObjectMapper();
			String obj = null;
			try {
				obj = mapper.writeValueAsString(typeParamClass);
			} catch (Exception ex) {
				logger.info("Ocurrio un error al : procesar ", ex);
			}
			return obj;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaReimpresion registraProcesoConcluidoReinpresion(TramitesConcluidos entradaTramiteConcluido){
		RespuestaReimpresion respuesta = null;
		try{
			String urlServicio = cadenasUtils.obtenerCadenaConcatenada(true, urlTransaccional,ServiciosConstants.REGISTRA_TRAMITE_CONCLUIDO);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
			logger.error("url registraProcesoConcluidoReinpresion :::: {}", urlServicio);

			HttpEntity<TramitesConcluidos> entity = new HttpEntity<>(entradaTramiteConcluido,headers);
			logger.error("Peticion registraProcesoConcluidoReinpresion :::: {}", entradaTramiteConcluido);
			
			ResponseEntity<RespuestaReimpresion> response = restTemplate.exchange(urlServicio, HttpMethod.POST, entity,RespuestaReimpresion.class);
			if(!validadorUtils.validarObjetoNulo(response)){
				respuesta = response.getBody();
			}
			logger.error("respuesta registraProcesoConcluidoReinpresion :::: {}", respuesta);
		} catch (HttpClientErrorException ex) {
			logger.error("Se presento problema en el registraProcesoConcluidoReinpresion", ex);
		}
		return respuesta;		
	}

	
	/**
	 * obtenerFolioProcesarPorCurp
	 */
	@Override
	public String obtenerFolioProcesarPorCurp(String curp, String claveAfore) {
	    String folioProcesar="";
	    StringBuilder url= new StringBuilder();
	    url.append(ServiciosConstants.URI_OBTENER_FOLIO_PROCESAR);
	    url.append(curp);
	    url.append(ServiciosConstants.DIAGONAL);
	    url.append(claveAfore);  
	    try {
	    	RespuestaGenerica respuesta= restServiceClientUtils.ejecutarServicioGet(urlComunes, url.toString(), RespuestaGenerica.class);
	 	    logger.error("La ruta del llamado del servicio obtenerTramitesConcluidos :: {}",urlComunes.concat(url.toString()));
	 	    if(respuesta.getFlujo()==0) {
	 	    	ObjectMapper mapper= new ObjectMapper();
	 	    	ArchivoRecibido archivo=mapper.convertValue(respuesta.getObRespuesta(), new TypeReference<ArchivoRecibido>() {});
	 	    	folioProcesar=archivo.getFolioProcesarRecibido();
	 	    }
	    }catch(Exception e) {
	    	logger.error("Se presento problema en el registraProcesoConcluidoReinpresion", e);
	    }
	   
		return folioProcesar;
		
	}
	
	/**
	 * enviarCorreoReimpresion
	 */
	@Override
	public RespuestaServicio enviarCorreoReimpresion(DatosArchivos datos,DatosTrabajador trabajador, String folioProcesar,String claveDocumento,CorreoEnum correoEnum,String claveAgente)  {
		logger.error("Inicia envío correo modificador de datos:{}",trabajador.getDatosCertificables().getCurp());
		DatosCorreo correoCambio = new DatosCorreo();
		if(trabajador.getDatosComplementarios().getCorreoElectronico()==null ||trabajador.getDatosComplementarios().getCorreoElectronico().isEmpty()) {
			return menuReimpresionService.obtenerRespuestaCorrecta(FormatoConstants.FLUJO_EMAIL_INEXISTENTE, FormatoConstants.DESCRIPCION_EMAIL_INEXISTENTE,"");
		}
	
		correoCambio.setDatosCorreo(correoEnum);
		correoCambio.setCorreo(trabajador.getDatosComplementarios().getCorreoElectronico());
		correoCambio.setNombre(trabajador.getNombreTrabajador());
		correoCambio.setArchivo(archivoZipService.pdf(DatatypeConverter.parseBase64Binary(datos.getByteArchivo())));
		guardarBitacoraImpresionEnvio(FormatoConstants.INDICATIVO_ENVIO,claveDocumento,datos.getIdSegTramite(),claveAgente);
		servicioCorreo.envioCorreo(correoCambio, trabajador.getClaveAfore());	
		
		return menuReimpresionService.obtenerRespuestaCorrecta(FormatoConstants.FLUJO_CORRECTO_REIMPRESION, FormatoConstants.EXITO_REIMPRESION_CORREO,"");
	}

	/**
	 * obtieneExistenciaCorreoElectronico
	 * @param trabajador
	 * @return
	 */
	@Override
	public RespuestaServicio obtenerExistenciaCorreoElectronico(DatosTrabajador trabajador) {	
		logger.error("Inicia validacion de existencia de correo :{}",trabajador.getDatosCertificables().getCurp());
		StringBuilder sb = new StringBuilder();
		if(trabajador.getDatosComplementarios().getCorreoElectronico()==null || trabajador.getDatosComplementarios().getCorreoElectronico().isEmpty()) {
			return menuReimpresionService.obtenerRespuestaCorrecta(FormatoConstants.FLUJO_EMAIL_INEXISTENTE, FormatoConstants.DESCRIPCION_EMAIL_INEXISTENTE,"");
		}
		sb.append(FormatoConstants.MENSAJE_CORREO_CORRECTO);
		sb.append(" ");
		sb.append(trabajador.getDatosComplementarios().getCorreoElectronico());
		return menuReimpresionService.obtenerRespuestaCorrecta(FormatoConstants.FLUJO_CORRECTO_REIMPRESION, sb.toString(),"");
	}
	
	/**
	 * envioNotificacionTramites
	 */
	@Override
	public RespuestaServicioNotificacion envioNotificacionTramites(TramitesConcluidosEntrada tramitesConcluidosEntrada) {
		RespuestaServicioNotificacion respuestaServicioNotificacion = null;
		StringBuilder url = new StringBuilder();
		url.append(urlComunes);
		url.append(ServiciosConstants.NOTIFICACIONES_TRAMITES_CONCLUIDOS);
		try {
			logger.error("La ruta del llamado del servicio obtenerTramitesConcluidos :: {}",url);
			respuestaServicioNotificacion= restServiceClientUtils.ejecutarServicioPost(url.toString(),tramitesConcluidosEntrada, RespuestaServicioNotificacion.class);		
		}catch(Exception e) {
			logger.error("Existe un error en el envio de notificaciones :{}",e);
		}	
		return respuestaServicioNotificacion;
		
	}
	
	/**
	 * obtenerTramitesConcluidos
	 * @param curp
	 * @param folioProcesar
	 * @param organizacion
	 * @param subTipoSolicitante
	 * @param tipoSolicitante
	 * @return
	 */
	@Override
	public TramitesConcluidos llenarTramitesConcluidos(String curp,String folioProcesar,String organizacion,
			String tipoSolicitante) {
		TramitesConcluidos tramitesConcluidos = new TramitesConcluidos();
		tramitesConcluidos.setCurp(curp);
		tramitesConcluidos.setFcControl(new Date());
		tramitesConcluidos.setFolioProcesar(folioProcesar);
		tramitesConcluidos.setOrganizacion(organizacion);
		tramitesConcluidos.setTipoSolicitante(tipoSolicitante);
		tramitesConcluidos.setUsuarioModificador(FormatoConstants.USUARIO_MODIFICADOR_PULLSAR);
		return tramitesConcluidos;
		
	}
}
