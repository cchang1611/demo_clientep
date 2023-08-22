/**

 * MatrimonioLineaServiceImpl.java
 * Fecha de creación: Aug 12, 2020 5:10:16 PM
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

import java.math.BigDecimal;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MatrimonioLineaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MatrimonioLinea;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Peticion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendienteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaEstatusServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Clase para
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
@Service
public class MatrimonioLineaServiceImpl implements MatrimonioLineaService {

	
	
	private static final Logger logger = LoggerFactory.getLogger(MatrimonioLineaServiceImpl.class);
	
	
	/**
	 * Atributo restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Atributo url
	 */
	@Value("${url.consulta.obtener.matrimonio.linea}")
	private String url;
	
	/**
	 * folioService
	 */
	@Autowired
	private FolioService folioService;
	
	/**
	 * urlAGM
	 */
	@Value("${url.consulta.agm}")
	private String urlAGM;
	
	
	/**
	 * urlMontoMatrimonio
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * Inyeccion de url para notificacionTipoRetiro
	 */
	@Value("${uri.notificacion.tipo.retiro}")
	private String urlNotificacionTipoRetiro;
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Autowired
	private CadenasUtils utileriaCadenas;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * MatrimonioLineaService#buscarTramitesMatrimonio(java.lang.String)
	 */
	@Override
	public MatrimonioLinea buscarTramitesMatrimonio(String nss) {
		return restTemplate.getForObject(url, MatrimonioLinea.class, nss);
	}


	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MatrimonioLineaService#validarAyudaGastosMatrimonio(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin)
	 */
	@Override
	public SolicitarCertificacionMatrimonioSalida validarCertificado(DatosTrabajador trabajador, UsuarioLogin user, RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>> retiroMatrimonioImss, String folio, SolicitudDisposicionParcial entradaOp12, SolicitarCertificacionMatrimonioEntrada entradaCertificacion   ) {

		logger.info("datosTrabajador: {}", trabajador);
		entradaCertificacion.setFolioCliente(entradaCertificacion.getFolioTramiteProcesar());
		entradaCertificacion.setNombreTrabajador(trabajador.getDatosCertificables().getNombre());
		entradaCertificacion.setApellidoPaternoTrabajador(trabajador.getDatosCertificables().getApellidoPaterno());
		entradaCertificacion.setApellidoMaternoTrabajador(trabajador.getDatosCertificables().getApellidoMaterno());
		entradaCertificacion.setNss(trabajador.getNss());
		entradaCertificacion.setCurpTrabajador(trabajador.getDatosCertificables().getCurp());
		entradaCertificacion.setTipoPrestacion(trabajador.getTipoDePrestacion());
		entradaCertificacion.setTipoSolicitante(trabajador.getTipoSolicitante());
		entradaCertificacion.setCurpSolicitante(trabajador.getDatosCertificables().getCurp());
		entradaCertificacion.setCurpAgenteServicio(user.getCurpAgente());
		/*campos fijos*/
		entradaCertificacion.setOrigenTramite("01");
		entradaCertificacion.setTipoPrestacion("07");
		/*Campos que no llegan de la pantalla*/
		if("01".equals(trabajador.getTipoSolicitante())) {
			entradaCertificacion.setSelloTrabajador(Long.toString(trabajador.getSello().getId()));
		}
		entradaCertificacion.setAfore(user.getAforeUsuario());
		/**/
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		DateTime jt = dtf.parseDateTime(entradaCertificacion.getFechaMatrimonio());
		DateTimeFormatter dtfOut = DateTimeFormat.forPattern("yyyy/MM/dd");
		entradaCertificacion.setFechaMatrimonio(dtfOut.print(jt));

		SolicitarCertificacionMatrimonioSalida salidacertificacion = new SolicitarCertificacionMatrimonioSalida();

		salidacertificacion.setMontoDisposicion(trabajador.getSalariosIcefas().getSalario());
		salidacertificacion.setMotivoRechazo(ServiciosConstants.RESPUESTA_532);

		folioService.cerrarFolio(retiroMatrimonioImss.getIdFolio(), null);
		
		FolioEntrada folioOp12 = crearFolio(trabajador, user.getDatoUsuario().toString(), "S", "S18", "S18P5", "SUC1", ServiciosConstants.TIEMPO_LLEGADA, "O");
		retiroMatrimonioImss.setFolio12(folioService.generarNuevoFolio(folioOp12));
		
		/**aqui se condicionaria en caso de que el diagnostico de la certificacion 
		 * fuera igual o distinto a 532 pero por ahora solo sera 532
		 */
		String calc = obtenerMontoRetiroMatrimonio(trabajador.getSalariosIcefas().getSalario());
		salidacertificacion.setMontoDisposicion(calc);
		
		prepararOpPendiente07(retiroMatrimonioImss,  entradaCertificacion, salidacertificacion, trabajador, user);
		prepararOpPendiente12(entradaOp12, trabajador, user, retiroMatrimonioImss, folio);
		
		return salidacertificacion;
	}
	
	/**
	 *  consultarMatrimonio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param agmConyuge
	 *  @return
	 */
	public SolicitarCertificacionMatrimonioSalida consultarMatrimonio(SolicitarCertificacionMatrimonioEntrada agmConyuge ) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("idServicio", "842");
		headers.set("idCliente", "86");
		headers.set("idEbusiness", "12");
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<SolicitarCertificacionMatrimonioEntrada> entity = new HttpEntity<>(agmConyuge, headers);
		logger.info("agmConyuge: {}", agmConyuge);
		logger.info("agm entity: {}", entity);
		ResponseEntity<SolicitarCertificacionMatrimonioSalida> response = restTemplate.exchange(urlAGM, HttpMethod.POST,
				entity, SolicitarCertificacionMatrimonioSalida.class);
		SolicitarCertificacionMatrimonioSalida respuesta = response.getBody();
		logger.info("agm respuesta: {}", respuesta);
		return respuesta;
		
	}
	
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MatrimonioLineaService#obtenerMontoRetiroMatrimonio(java.lang.String)
	 */
	public String obtenerMontoRetiroMatrimonio(String salarioMinimo) {
		Double calculo = 0d;
		StringBuilder uriOMR = new StringBuilder(uriComunes);
		uriOMR.append("calcularMontoAPagar/");
		uriOMR.append(salarioMinimo);
		try{
			calculo = restTemplate.getForObject(uriOMR.toString(), Double.class);
		}catch(Exception e) {
			logger.error("error", e.getMessage());
		}
		
		return calculo.toString();
	}
	
	
	/**
	 *  prepararOpPendiente07
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param agmConyuge
	 *  @param datosTrabajador
	 *  @param user
	 */
	private void prepararOpPendiente07(RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>> retiroMatrimonioImss,  SolicitarCertificacionMatrimonioEntrada entradaCertificacion, SolicitarCertificacionMatrimonioSalida salidacertificacion, DatosTrabajador datosTrabajador, UsuarioLogin user) {

		ProcesoPendienteEntrada<Peticion<SolicitarCertificacionMatrimonioEntrada>> procesoPendienteOp07 = new ProcesoPendienteEntrada<>();
		Peticion<SolicitarCertificacionMatrimonioEntrada> peticion07 = new Peticion<>();
		// Proceso pendiente para Op07
		procesoPendienteOp07.setAfore(user.getAforeUsuario());
		procesoPendienteOp07.setCurp(datosTrabajador.getDatosCertificables().getCurp());
		procesoPendienteOp07.setCurpEmpleado(user.getCurpAgente());
		procesoPendienteOp07.setCurpNueva(null);
		procesoPendienteOp07.setFlujo(null);
		procesoPendienteOp07.setIdFolioPulssar(retiroMatrimonioImss.getIdFolio());
		procesoPendienteOp07.setProceso("09");
		procesoPendienteOp07.setSolicitante(datosTrabajador.getTipoSolicitante());
		peticion07.setFoliohijo(retiroMatrimonioImss.getFolio12().getIdFolio());
		peticion07.setPeticion(entradaCertificacion);
		
		procesoPendienteOp07.setPeticion(peticion07);
		procesoPendienteOp07.setIdProcesar(datosTrabajador.getProcesar());
		salidacertificacion.setResultadoOperacion("01");
		//TODO falta este campo en la salida de certificacion de MAtrimonio?
		//retiroMatrimonioImss.setDiagnostico(salidacertificacion.getDiagnosticoProcesar());
//		datosTrabajador.getSalariosIcefas().setSalario("123");
		retiroMatrimonioImss.setSbcTipoA(datosTrabajador.getSalariosIcefas().getSalario());
		retiroMatrimonioImss.setSbcTipoB(datosTrabajador.getSalariosIcefas().getSalario());
		retiroMatrimonioImss.setPeticion07(procesoPendienteOp07);
		
	}
	
	
	/**
	 *  prepararOpPendiente12
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param trabajador
	 *  @param user
	 *  @param folio
	 */
	private void prepararOpPendiente12(SolicitudDisposicionParcial entradaOp12, DatosTrabajador trabajador, UsuarioLogin user, RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>> retiroMatrimonioImss, String folio) {
		
		entradaOp12.setFolioTramiteProcesar(folio);
		entradaOp12.setFolioCliente(folio);
		entradaOp12.setNss(trabajador.getNss());
		entradaOp12.setNombreTrabajador(trabajador.getDatosCertificables().getNombre());
		entradaOp12.setApellidoPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
		entradaOp12.setApellidoMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
		entradaOp12.setTipoRetiro("I");
		entradaOp12.setTipoPrestacion("07");
		entradaOp12.setClaveAdminActual(trabajador.getClaveAfore());
		entradaOp12.setCurpTrabajador(trabajador.getDatosCertificables().getCurp());
		entradaOp12.setSelloTrabajador(String.valueOf(retiroMatrimonioImss.getSelloTrabajador()));
		entradaOp12.setCurpAgenteServicio(user.getCurpAgente());
		entradaOp12.setIdSolicitante(trabajador.getTipoSolicitante());
		if (trabajador.getTipoSolicitante().equals("01")) {
			entradaOp12.setCurpSolicitante(trabajador.getDatosCertificables().getCurp());
		} else {
			entradaOp12.setCurpSolicitante(trabajador.getCurpSolicitante());
		}
		entradaOp12.setIndicadorOrigenTramite("01");
		entradaOp12.setCurpFuncionarioAutorizado(user.getCurpAgente());
		entradaOp12.setNumeroResolucion(null);

		// Proceso pendiente para Op12
		ProcesoPendienteEntrada<SolicitudDisposicionParcial> procesoPendienteOp12 = new ProcesoPendienteEntrada<>();
		procesoPendienteOp12.setAfore(user.getAforeUsuario());
		procesoPendienteOp12.setCurp(trabajador.getDatosCertificables().getCurp());
		procesoPendienteOp12.setCurpEmpleado(user.getCurpAgente());
		procesoPendienteOp12.setCurpNueva(null);
		/**
		 * 0 por que siempre se va a mandar como 532
		 */
		procesoPendienteOp12.setFlujo("0");
		procesoPendienteOp12.setIdFolioPulssar(retiroMatrimonioImss.getFolio12().getIdFolio());
		procesoPendienteOp12.setProceso("10");
		procesoPendienteOp12.setSolicitante(trabajador.getTipoSolicitante());
		procesoPendienteOp12.setPeticion(entradaOp12);
		procesoPendienteOp12.setIdProcesar(trabajador.getProcesar());
		retiroMatrimonioImss.setPeticion12(procesoPendienteOp12);
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MatrimonioLineaService#generarFolio(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador)
	 */
	@Override
	public FolioEntrada crearFolio(DatosTrabajador dt, String... param) {
		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(Long.valueOf(param[0]));
		folio.setOperacion(param[1]);
		folio.setServicio(param[2]);
		folio.setProceso(param[3]);
		folio.setSucursal(param[4]);
		folio.setNss(dt.getNss());
		folio.setCurp(dt.getDatosCertificables().getCurp());
		folio.setTiempoLlegada(param[5]);
		folio.setOrigen(param[6]);

		return folio;
	}


	@Override
	public void notificarTipoRetiroMatrimonio(DatosTrabajador trabajador, String resolucion, String folio, ParametrosRetiroParcialCalculoImss calculoEntrada) {
		NotificacionTipoRetiro notificacionTipoRetiro = new NotificacionTipoRetiro();
		notificacionTipoRetiro.setAfore(trabajador.getClaveAfore());
		notificacionTipoRetiro.setCurp(trabajador.getDatosCertificables().getCurp());
		notificacionTipoRetiro.setFolio(folio);
		notificacionTipoRetiro.setFolioAdministradora(folio);
		notificacionTipoRetiro.setNss(trabajador.getNss());
		notificacionTipoRetiro.setNumeroResolucion(resolucion);
		notificacionTipoRetiro.setClaveBanco(calculoEntrada.getClaveBanco());
		notificacionTipoRetiro.setCuentaClabe(calculoEntrada.getCuentaClabe());
		notificacionTipoRetiro.setDiagnosticoRecepcion("001");
		notificacionTipoRetiro.setFechaControl(new Date());
		notificacionTipoRetiro.setFechaProcesamiento(new Date());
		notificacionTipoRetiro.setImporteAutorizado(calculoEntrada.getMontoCalculoA());
		notificacionTipoRetiro.setMontoA(calculoEntrada.getMontoCalculoA());

		notificacionTipoRetiro.setNumeroCuenta(calculoEntrada.getCuenta());
		notificacionTipoRetiro.setNumNotificado(BigDecimal.ZERO);
		
		notificacionTipoRetiro.setNumParcialidades(1);
		notificacionTipoRetiro.setTipoPago(calculoEntrada.getFormaPago());
//		notificacionTipoRetiro.setTipoRetiroSeleccion(calculoEntrada.getTipoRetiro());
		notificacionTipoRetiro.setUsuarioModificador("NOTIFICACIONES_PULSSAR");
		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true, urlNotificacionTipoRetiro);
			logger.info(ExpresionesConstants.URL_ACTUALIZAR,urlServicio);
			HttpEntity<NotificacionTipoRetiro> entity = new HttpEntity<>(notificacionTipoRetiro, httpHeaders);
			logger.info("Entrada: {}", entity);
			ResponseEntity<RespuestaEstatusServicio> response = restTemplate.exchange(urlServicio, HttpMethod.PUT, entity, RespuestaEstatusServicio.class);
			logger.info(ExpresionesConstants.RESPUESTA_ACTUALIZAR,response);
			if (utileriaValidador.validarObjetoNulo(response.getBody())) {
				logger.error(ExpresionesConstants.DESCRIPCION_EXCEPCION, "Respuesta nula");
			}
		} catch (Exception e) {
			logger.error(ExpresionesConstants.DESCRIPCION_EXCEPCION, urlNotificacionTipoRetiro, e);
		}
		logger.info("Datos Salida respuesta servicio notificacionTiporetiro:{}",notificacionTipoRetiro);
	}

	
}
