/**
 * VisorExpedientesIdentificacionMovilServiceImpl.java
 * Fecha de creación: Feb 10, 2021 10:58:51 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidaActividadService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.VisorExpedientesIdentificacionMovilService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DetalleExpedientes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaVisorExpedientesIdentificacionMovil;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteTipoProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Imagen;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaConsultaVisorExpedienteMovil;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoProcesoExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.DesCompresorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
@Service
public class VisorExpedientesIdentificacionMovilServiceImpl implements VisorExpedientesIdentificacionMovilService {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(VisorExpedientesIdentificacionMovilService.class);

	/**
	 * Atributo urlVisorExpedientes
	 */
	@Value("${servicio.visor.expediente.idetificacion.movil}")
	private String urlVisorExpedientes;

	
	/**
	 * Atributo urlVisorExpedientes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * Atributo restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Atributo rechazoService
	 */
	@Autowired
	private RechazoService rechazoService;
	
	
	/**
	 * restServiceClientUtils
	 */
	@Autowired
	private RestServiceClientUtils restServiceClientUtils;
	
	/**
	 * Atributo desCompresorUtils
	 */
	@Autowired
	private DesCompresorUtils desCompresorUtils;
	
	/**
	 * Atributo validadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	
	
	/**
	 * Atributo validaActividadService
	 */
	@Autowired
	private ValidaActividadService validaActividadService;


	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * VisorExpedientesIdentificacionMovilService#consultaExpediente(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public byte[] consultaExpediente(String tipoServicio, String claveAfore, String curp, String tipoExpediente) {

		logger.info(urlVisorExpedientes, claveAfore, curp, tipoExpediente);
		SalidaConsultaVisorExpedienteMovil salida = restTemplate.getForEntity(urlVisorExpedientes, SalidaConsultaVisorExpedienteMovil.class, tipoServicio,
				claveAfore, curp, tipoExpediente).getBody();

		logger.info("Respuesta {}", salida);
		if (salida == null) {
			throw new BusinessException("Existe un problema con el servicio, intenta más tarde.");
		}

		if ("02".equals(salida.getResultadoOperacion())) {
			RechazoPulssar rechazo = rechazoService.obtenerRechazo(salida.getDiagnostico(), "999");
			throw new BusinessException(
					"No se encontraron resultados para los criterios capturados/seleccionados, por el siguiente motivo: "
							.concat(rechazo.getMensaje()));
		}

		if ("600".equals(salida.getDiagnostico())) {
			throw new BusinessException(
					"No se encontraron resultados para los criterios capturados/seleccionados, por el siguiente motivo: 600 no existe expediente");
		}

		return salida.getArchivo();
	}

	
	/**
	 * obtenerExpedientes
	 * @param tipoServicio
	 * @param claveAfore
	 * @param curp
	 * @param tipoExpediente
	 * @return
	 */
	@Override
	public SalidaConsultaVisorExpedienteMovil obtenerExpedientes(String tipoServicio, String claveAfore, String curp, String tipoExpediente,String fecha) {
		SalidaConsultaVisorExpedienteMovil salidaConsultaVisorExpedienteMovil= null;
		EntradaVisorExpedientesIdentificacionMovil entrada= new EntradaVisorExpedientesIdentificacionMovil();
		String url=null;
		StringBuilder sb=new StringBuilder();
		entrada.setClaveAfore(claveAfore.trim());
		entrada.setCurp(curp.trim());		
		entrada.setTipoExpediente(tipoExpediente.trim());
		entrada.setTipoServicio(tipoServicio.trim());
		if(fecha!=null && !fecha.isEmpty()) {
			entrada.setFechaOperacionExpe(fecha.trim());
		}	
		sb.append(uriComunes);
		sb.append(ServiciosConstants.CONSULTA_EXPEDIENTE);
		
		url=sb.toString();
		try {
			logger.error("obtenerExpedientePorFecha ::{}",url);
			logger.error("peticion  ::{}",entrada);
			salidaConsultaVisorExpedienteMovil = restServiceClientUtils.ejecutarServicioPost(url,entrada ,SalidaConsultaVisorExpedienteMovil.class);
			if (salidaConsultaVisorExpedienteMovil == null) {
				logger.error("salida ConsultaVisorExpedienteMovil nula sin datos ::{}",url);
				throw new BusinessException(ServiciosConstants.MENSAJE_INTENTE_MAS_TARDE);
			}
			logger.error("salida ConsultaVisorExpedienteMovil resultado de la operacion ::{}",salidaConsultaVisorExpedienteMovil.getResultadoOperacion());
			logger.error("salida ConsultaVisorExpedienteMovil diagnostico ::{}",salidaConsultaVisorExpedienteMovil.getDiagnostico());
			if (ServiciosConstants.RESULTADO_RECHAZO.equals(salidaConsultaVisorExpedienteMovil.getResultadoOperacion())) {
				RechazoPulssar rechazo = rechazoService.obtenerRechazo(salidaConsultaVisorExpedienteMovil.getDiagnostico(), ServiciosConstants.DIAGNOSTICO_RECHAZO);
				throw new BusinessException(
						ServiciosConstants.MENSAJE_NO_SE_ENCONTRARON_RESULATDOS
								.concat(rechazo.getMensaje()));
			}

			if (ServiciosConstants.DIAGNOSTICO_NO_EXISTEN_EXPEDIENTES.equals(salidaConsultaVisorExpedienteMovil.getDiagnostico())) {
				throw new BusinessException(
						ServiciosConstants.MENSAJE_NO_EXISTEN_EXPEDIENTES);
			}		
			
		}catch(BusinessException e) {
			throw new BusinessException(e.getMessage());
		}catch(Exception e) {
			logger.error("Error en obtenerExpedientes: ",e);
			throw new BusinessException(ServiciosConstants.MENSAJE_INTENTE_MAS_TARDE);
		}
		return salidaConsultaVisorExpedienteMovil;
		
	}



	/**
	 * obtenerExpedienteTipoProceso
	 * @param claveExpediente
	 * @return
	 */
	@Override
	public ExpedienteTipoProceso obtenerExpedienteTipoProceso(String claveExpediente) {
		ExpedienteTipoProceso expedienteTipoProceso= null;
		StringBuilder url= new StringBuilder();
		url.append(uriComunes);
		url.append(ServiciosConstants.TIPO_PROCESO_EXPEDIENTE);
		url.append(claveExpediente);
		
		try {
			expedienteTipoProceso =restServiceClientUtils.ejecutarServicioGet(ExpresionesConstants.VACIO, url.toString(), ExpedienteTipoProceso.class);
			
		}catch(Exception e) {
			logger.error("Error en obtener expediente ",e);
			throw new BusinessException("Existe un problema con el servicio, intenta más tarde.");
		}
		return expedienteTipoProceso;
		
	}
	
	/**
	 * convertirObjetoJson
	 */
	@Override
	public <T> String convertirObjetoJson(T obj) {
		ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
		mapper.writer().withDefaultPrettyPrinter();
		String json = null;
		try {
			json = mapper.writeValueAsString(obj);
		} catch (Exception jsonEx) {
			logger.error("Ocurrio un error al crear el json del objeto.", jsonEx);
		}
		return json;
	}
	
	/**
	 * obtenerListaDetalle
	 */
	@Override
	public List<DetalleExpedientes> obtenerListaDetalle(SalidaConsultaVisorExpedienteMovil salidaConsultaVisorExpedienteMovil) {
		List<DetalleExpedientes> listaDetalle= new ArrayList<>();
		DetalleExpedientes detalleExpedientes= new DetalleExpedientes();
		ExpedienteTipoProceso expedienteTipoProceso= null;
		StringBuilder sb = new StringBuilder();
		try {
			if(salidaConsultaVisorExpedienteMovil.getDetalleExpedientes()!=null && salidaConsultaVisorExpedienteMovil.getDetalleExpedientes().length>0) {
				for (DetalleExpedientes detalleExpediente : salidaConsultaVisorExpedienteMovil.getDetalleExpedientes()) {
					detalleExpedientes.setChFechaOperacion(detalleExpediente.getChFechaOperacion());
					detalleExpedientes.setCvTipoProceso(detalleExpediente.getCvTipoProceso());
					expedienteTipoProceso=obtenerExpedienteTipoProceso(detalleExpediente.getCvTipoProceso());
					if(expedienteTipoProceso!=null) {
						sb.append(detalleExpediente.getCvTipoProceso());
						sb.append(ExpresionesConstants.GUION);
						sb.append(expedienteTipoProceso.getChDescripcionProceso());
						sb.append(ExpresionesConstants.ESPACIO);
						sb.append(detalleExpedientes.getChFechaOperacion()!=null?formatoFechaCadena(detalleExpedientes.getChFechaOperacion()):"");
					}else {
						sb.append(detalleExpediente.getCvTipoProceso());
					}
					detalleExpedientes.setDescripcionExpediente(sb.toString());
					listaDetalle.add(detalleExpedientes);
					sb = new StringBuilder();
					detalleExpedientes= new DetalleExpedientes();
				}
			}
		
		}catch(Exception e) {
			logger.error("Error en obtenerListaDetalle: ",e);
			throw new BusinessException("Existe un problema con el servicio, intenta más tarde.");
		}
	
		return listaDetalle;
		
	}
	
	/**
	 * obtenerListaImagenes
	 */
	@Override
	public List<Imagen> obtenerListaImagenes(byte [] archivoEntrada ) {
		Map<String, byte[]> lstDocumentos=null;
		List<Imagen> listaImagenes=null;
		try {
			lstDocumentos = desCompresorUtils.descomprimirMultipart(archivoEntrada);
			listaImagenes=generarComboDocumentos(lstDocumentos);
		} catch (Exception e) {		
			logger.error("Error en obtener expediente ",e);
			throw new BusinessException("Existe un problema con el servicio, intenta más tarde.");
		}
			
	
		return listaImagenes;
	}
	
	/**
	 * Generar combo documentos
	 * 
	 * @param lstDocumentos
	 * @return
	 */
	@Override
	public List<Imagen> generarComboDocumentos(Map<String, byte[]> lstDocumentos) {
		List<Imagen> salida = new ArrayList<>();

		for (Entry<String, byte[]> entry : lstDocumentos.entrySet()) {
			Imagen e = new Imagen();
			logger.info("Array de nombre 1 {}", entry.getKey());
			e.setByteArchivo(Base64Utils.encodeToString(entry.getValue()));
			String[] extension = entry.getKey().split("\\.");
			logger.info("length de nombre {}", extension.length);
			e.setExtension(extension[extension.length - 1]);
			e.setNombreArchivo(entry.getKey());
			salida.add(e);
		}

		return salida;
	}
	
	/**
	 * obtenerTipoServicio
	 */
	@Override
	public String obtenerTipoServicio(String roleActual) {
		String tipoServicio=null;
		if (roleActual.equals(ServiciosConstants.CLAVE_OPERATIVO_CORE)) {
			tipoServicio = ServiciosConstants.TIPO_SERVICIO_EXPEDIENTE_03;
		}else {
			tipoServicio = ServiciosConstants.TIPO_SERVICIO_EXPEDIENTE_02;
		}
		return tipoServicio;
		
	}
	
	/**
	 * validaCamposExpediente
	 */
	@Override
	public void validaCamposExpediente(String afore,String curp,String tipoExpediente) {
		if (validadorUtils.validarVacio(afore)
				|| validadorUtils.validarVacio(curp)
				|| validadorUtils.validarVacio(tipoExpediente)) {
			throw new BusinessException(
					ServiciosConstants.MENSAJE_CAPTURA);
		}
		if (!new Integer(18).equals(curp.length())) {
			throw new BusinessException(ServiciosConstants.MENSAJE_CURP);
		}
		String enServicio = validaActividadService.validarActividadServicio(ServiciosConstants.PARAMETRO_ACTIVIDAD_SERVICIO, new Date());
		if (ServiciosConstants.FUERA_HORARIO_SERVCIO.equals(enServicio)) {
			throw new BusinessException(ServiciosConstants.MENSAJE_SOLICITUD_FUERA_SERVICIO);
		}
	}
	
	/**
	 * validarListaImagenes
	 */
	@Override
	public void validarListaImagenes(List<Imagen> listaImagenes,List<DetalleExpedientes> listaDetalle) {
		if(listaImagenes.isEmpty() && listaDetalle.isEmpty()) {
			throw new BusinessException(ServiciosConstants.MENSAJE_NO_EXISTEN_EXPEDIENTES_A_MOSTRAR);
		}
	}
	
	/**
	 * listaExpedienteFiltrada
	 * @param listaEntrada
	 * @return
	 */
	@Override
	public List<TipoProcesoExpediente> listaExpedienteFiltrada(List<TipoProcesoExpediente> listaEntrada){
		List<TipoProcesoExpediente> listaProcesoFiltro=new ArrayList<>();
		for (TipoProcesoExpediente tipoProcesoExpediente : listaEntrada) {
			if(ServiciosConstants.EXPEDIENTE_01.equals(tipoProcesoExpediente.getClaveTipoProceso()) || ServiciosConstants.EXPEDIENTE_77.equals(tipoProcesoExpediente.getClaveTipoProceso()) 
					|| ServiciosConstants.EXPEDIENTE_78.equals(tipoProcesoExpediente.getClaveTipoProceso())) {
				listaProcesoFiltro.add(tipoProcesoExpediente);
			}
		}
		return listaProcesoFiltro;
		
	}
	
	/**
	 * formatoFechaCadena
	 * @param fechaEntrada
	 * @return
	 */
	private String formatoFechaCadena(String fechaEntrada) {
		StringBuilder fechaSalida= new StringBuilder();	
		if(!fechaEntrada.isEmpty()) {
			fechaSalida.append(fechaEntrada.substring(6, 8));
			fechaSalida.append(ExpresionesConstants.DIAGONAL);
			fechaSalida.append(fechaEntrada.substring(4, 6));
			fechaSalida.append(ExpresionesConstants.DIAGONAL);
			fechaSalida.append(fechaEntrada.substring(0, 4));
		}
		return fechaSalida.toString();
		
	}
	
	/**
	 * obtenerNombreExpediente
	 * @param tipoExpediente
	 * @return
	 */
	@Override
	public String obtenerNombreExpediente(String tipoExpediente) {
		ExpedienteTipoProceso expedienteTipoProceso=null;
		String descripcionExpediente=ExpresionesConstants.VACIO;
		if(tipoExpediente!=null && !tipoExpediente.isEmpty()) {
			expedienteTipoProceso=obtenerExpedienteTipoProceso(tipoExpediente);
			descripcionExpediente=expedienteTipoProceso!=null?expedienteTipoProceso.getChDescripcionProceso():ExpresionesConstants.VACIO;
		}
		return descripcionExpediente;
		
	}
}
