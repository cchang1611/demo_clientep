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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarExpedienteServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JsonUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@Service
public class SolicitudDisposicionServiceImpl implements SolicitudDisposicionService {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(SolicitudDisposicionServiceImpl.class);
	/**
	 * tipoRetiro
	 */
	@Value("${solicitud.retiro.imss.uri}")
	private String uriSolicitudRetiroDesempleoImss;
	/**
	 * servicio
	 */
	@Autowired
	private RestTemplate restService;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion dependencia JsonUtils
	 */
	@Autowired
	private JsonUtils jsonUtils;

      /**
  	 * Ruta url de carpeta de expediente
  	 */
  	@Value("${ruta.carpeta.expediente}")
  	private String urlRutaExpedientes;
	 
	 /**
	 * uri solicitud retiro issste
	 */
	@Value("${uri.solicitud.retiro.desempleo.issste.uri}")
	private String urisolicitudRetiroDesempleoIssste;	

	 /**
	  * Inyeccion dependencia ValidarExpedienteServicio
	  */
	 @Autowired
	 private ValidarExpedienteServicio validarExpedienteService;
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionService#generarExpedientes(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss)
	 */
	@Override
	public String generarExpedientes(DatosTrabajador datos, UsuarioLogin user, RetiroDesempleoImss retiroDesempleoImss) {

		String respuesta;
        int i = 0;
        respuesta = validarExpedienteService.validarExpedienteServicio(datos.getFolio().getFolioHijo(), datos, user, retiroDesempleoImss);
        logger.info("respuesta{}>>>:{}", i, respuesta);
  
		return respuesta;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionService#solicitudDisposicion(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador, java.lang.String, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin, java.lang.String, java.lang.String)
	 */
	@Override
	public SolicitudDisposicionParcialRespuesta solicitudDisposicion(DatosTrabajador trabajador, String curp,
			RetiroDesempleoImss retiroDesempleoImss, UsuarioLogin user, String folio, String origen) {
	      
        SolicitudDisposicionParcial dispParcial = new SolicitudDisposicionParcial();
		dispParcial.setFolioCliente(folio);
		dispParcial.setFolioTramiteProcesar(folio);
		dispParcial.setNss(trabajador.getNss());
		dispParcial.setNombreTrabajador(trabajador.getDatosCertificables().getNombre());
		dispParcial.setApellidoPaterno(trabajador.getDatosCertificables().getApellidoPaterno());
		dispParcial.setApellidoMaterno(trabajador.getDatosCertificables().getApellidoMaterno());
		dispParcial.setTipoRetiro("I");
		if ("matrimonio_imss".equals(origen)) {
			dispParcial.setTipoPrestacion("07");
		} else {
			dispParcial.setTipoPrestacion("06");
		}
		dispParcial.setNumeroResolucion(retiroDesempleoImss.getNumeroResolucion());
		dispParcial.setClaveAdminActual(trabajador.getClaveAfore());
		dispParcial.setCurpTrabajador(trabajador.getDatosCertificables().getCurp());
		dispParcial.setSelloTrabajador(retiroDesempleoImss.getSelloTrabajador());
		dispParcial.setCurpAgenteServicio(curp);
		dispParcial.setIdSolicitante(trabajador.getTipoSolicitante());
		dispParcial.setCurpSolicitante(trabajador.getDatosCertificables().getCurp());
		if (trabajador.getTipoSolicitante().equals("01")) {
			dispParcial.setCurpSolicitante(trabajador.getDatosCertificables().getCurp());
		} else {
			dispParcial.setCurpSolicitante(trabajador.getCurpSolicitante());
		}
		dispParcial.setIndicadorOrigenTramite("01");
		dispParcial.setCurpFuncionarioAutorizado(curp);
//		dispParcial.setSelloFuncionarioAutorizado(trabajador.getSello().getCurpEmpleado());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("idServicio", "758");
		headers.set("idCliente", "35");
		headers.set("idEbusiness", "12");

		HttpEntity<SolicitudDisposicionParcial> entity = new HttpEntity<>(dispParcial, headers);

		logger.error("json entrada solicitudDisposicion: {}", jsonUtils.parseObjectToJson(entity));
		ResponseEntity<SolicitudDisposicionParcialRespuesta> respuesta = restService.exchange(uriSolicitudRetiroDesempleoImss,  HttpMethod.POST, entity, SolicitudDisposicionParcialRespuesta.class);
		
        SolicitudDisposicionParcialRespuesta salidasolicitud = respuesta.getBody();
		
		logger.error("salida Solicitar RetiroImss: {}", salidasolicitud);
		
		if(utileriaValidador.validarObjetoNulo(salidasolicitud)) {
			logger.error("salida Solicitar Retiro Imss error, no se pudo generar la certificacion");
		}
    return salidasolicitud;
	}
	


}
