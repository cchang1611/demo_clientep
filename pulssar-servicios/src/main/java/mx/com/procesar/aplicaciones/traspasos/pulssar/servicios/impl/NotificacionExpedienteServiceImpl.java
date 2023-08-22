package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBeneficiarioTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBeneficiarioTrabajadorSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosParticulares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSalidaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DomicilioLaboral;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaNotificacionActualiza;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaNotificacionPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Referencias;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaActualizaDatos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaNotificacionActualiza;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaNotificacionPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Service notifocacion expediente
 * @author JMGUTIEG
 *
 */
@Service
public class NotificacionExpedienteServiceImpl implements NotificacionExpedienteService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(NotificacionExpedienteServiceImpl.class);
	
	@Value("${url.notificionExpediente}")
	private String urlNorificacionExpediente;
	
	/**
	 * rest template
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Inyeccion de dependencia validadorUtils
	 */
    @Autowired
	private ValidadorUtils validadorUtils;
    
	/**
	 * Inyeccion de servicio catalgoo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * cadena utilidad
	 */
	@Autowired
	private CadenasUtils cadenaUtils;
	
	/**
	 * Inyeccion de dependencia fechaUtils
	 */
    @Autowired
	private FechaUtils fechaUtils;
    
	
	/**
	 * {@inheritDoc}
	 */
    @Async
	@Override
	public void envioNotificacionActualiza(SalidaActualizaDatos salidaActualizaDatos, DatosTrabajador datosTrabajador,Folio folio,FlujoModificacion flujoModificacion) {
		SalidaNotificacionActualiza salidaNotificacionActualiza = new SalidaNotificacionActualiza();
		try {
			logger.error("urlNorificacionExpediente:::: {}", urlNorificacionExpediente);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
			JsonUtilsImpl<EntradaNotificacionActualiza> json = new JsonUtilsImpl<>();
			String jsonRequest = json.parseObjectToJsonSC(mapEntradaNotificacionActualiza(salidaActualizaDatos, datosTrabajador,folio,flujoModificacion));
			HttpEntity<String> entity = new HttpEntity<>(jsonRequest,headers);
			logger.error("Peticion envioNotificacionActualiza:::: {}", jsonRequest);
			ResponseEntity<String> response = restTemplate.exchange(urlNorificacionExpediente, HttpMethod.PUT, entity,String.class);
			
			if(!validadorUtils.validarObjetoNulo(response)){
				logger.error("La respuesta de notificacionExpedienteActualiza {} ", response.getBody());
				JsonUtilsImpl<SalidaNotificacionActualiza> jsonSalida = new JsonUtilsImpl<>();
				salidaNotificacionActualiza = jsonSalida.parseJsonToObject(response.getBody(), SalidaNotificacionActualiza.class);
			}else{
				salidaNotificacionActualiza.setResultadoOperacion("02");
				logger.error("Error: Se presento un error inesperado en el servicio de notificacion actualiza.");
			}
			
		}catch (HttpClientErrorException ex) {
			salidaNotificacionActualiza.setResultadoOperacion("02");
			logger.error("Se presento problema en el servicio de notificaciones actualiza", ex);
		} catch (Exception e){
			salidaNotificacionActualiza.setResultadoOperacion("02");
			logger.error("Error en notificacion actualiza", e);
		}
		logger.error("resultadoOperacion Notificacion Actualiza {}", salidaNotificacionActualiza.getResultadoOperacion());
	}
    
    /**
     * {@inheritDoc}
     */
    @Async
	@Override
	public void envioNotificacionPermanencia(DatosSalidaPermanencia salidaPermanencia, EntradaPermanencia entradaPermanencia,Folio folio,FlujoModificacion flujoModificacion) {
		SalidaNotificacionPermanencia salidaNotificacionPermanencia = new SalidaNotificacionPermanencia();
		try {
			logger.error("urlNorificacionExpediente:::: {}", urlNorificacionExpediente);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
			JsonUtilsImpl<EntradaNotificacionPermanencia> json = new JsonUtilsImpl<>();
			String jsonRequest = json.parseObjectToJsonSC(mapEntradaNotificacionPermanencia(salidaPermanencia, entradaPermanencia,folio,flujoModificacion));
			HttpEntity<String> entity = new HttpEntity<>(jsonRequest,headers);
			logger.error("Peticion envioNotificacionPermanencia :::: {}", jsonRequest);
			ResponseEntity<String> response = restTemplate.exchange(urlNorificacionExpediente, HttpMethod.POST, entity,String.class);
			
			if(!validadorUtils.validarObjetoNulo(response)){
				logger.error("La respuesta de notificacionExpedientePermanencia {} ", response.getBody());
				JsonUtilsImpl<SalidaNotificacionPermanencia> jsonSalida = new JsonUtilsImpl<>();
				salidaNotificacionPermanencia = jsonSalida.parseJsonToObject(response.getBody(), SalidaNotificacionPermanencia.class);
			}else{
				salidaNotificacionPermanencia.setResultadoOperacion("02");
				logger.error("Error: Se presento un error inesperado en el servicio de notificacion permanencia.");
			}
			
		}catch (HttpClientErrorException ex) {
			salidaNotificacionPermanencia.setResultadoOperacion("02");
			logger.error("Se presento problema en el servicio de notificacion permanencia.", ex);
		} catch (Exception e){
			salidaNotificacionPermanencia.setResultadoOperacion("02");
			logger.error("Error en notificacion permanencia", e);
		}
		logger.error("resultadoOperacion Notificacion Permanencia {}", salidaNotificacionPermanencia.getResultadoOperacion());
	}
	
    /**
     * Map entrada notificacion permanencia
     * @param salidaPermanencia
     * @param entradaPermanencia
     * @param folio
     * @return
     */
	private EntradaNotificacionPermanencia mapEntradaNotificacionPermanencia(DatosSalidaPermanencia salidaPermanencia, EntradaPermanencia entradaPermanencia,Folio folio,FlujoModificacion flujoModificacion) {
		logger.error("entrada mapEntradaNotificacionPermanencia : {} {}",salidaPermanencia,entradaPermanencia);
		String paramCaracter = AgenteConstants.CARACTER_HOMOLOGADO;
		List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
		String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;
		if(!validadorUtils.validarListaVacia(listaParametro)) {
			caracterHomologado = listaParametro.get(NumerosConstants.INT_CERO).getChValorParametro();
		}

		DatosParticulares datosParticulares = validaEntradaDatosParticulares(entradaPermanencia, caracterHomologado);
		DomicilioLaboral domicilioLaboral = validaDomicilioLaboralPermanencia(entradaPermanencia, caracterHomologado);
		Referencias referencias = validaReferenciasPermanencia(entradaPermanencia, caracterHomologado);
		Beneficiarios beneficiarios = validaBeneficiariosPermanencia(entradaPermanencia, caracterHomologado);
		EntradaNotificacionPermanencia entradaNotificacionPermanencia = new EntradaNotificacionPermanencia();
		entradaNotificacionPermanencia.setAfore(entradaPermanencia.getEntidadOrigen());
		entradaNotificacionPermanencia.setFolioCliente(folio.getChFolio());
		entradaNotificacionPermanencia.setEntidadOrigen(entradaPermanencia.getEntidadOrigen());
		entradaNotificacionPermanencia.setCurpTrabajador(entradaPermanencia.getCurpTrabajador());
		entradaNotificacionPermanencia.setNssTrabajador(entradaPermanencia.getNssTrabajador());
		entradaNotificacionPermanencia.setRfc(entradaPermanencia.getRfc());
		entradaNotificacionPermanencia.setApellidoPaterno(eliminarAcentos(entradaPermanencia.getApellidoPaterno(), caracterHomologado));
		entradaNotificacionPermanencia.setApellidoMaterno(eliminarAcentos(entradaPermanencia.getApellidoMaterno(),caracterHomologado));
		entradaNotificacionPermanencia.setNombreTrabajador(eliminarAcentos(entradaPermanencia.getNombreTrabajador(),caracterHomologado));
		
		if(entradaPermanencia.getFechaDeNacimiento().contains("-")) {
			entradaNotificacionPermanencia.setFechaDeNacimiento(fechaUtils.ObtenerFechas(entradaPermanencia.getFechaDeNacimiento()));
		}else {
			entradaNotificacionPermanencia.setFechaDeNacimiento(entradaPermanencia.getFechaDeNacimiento());
		}
		logger.error("fecha de nacimiento mapeo notificacion: {}", entradaNotificacionPermanencia.getFechaDeNacimiento());
		entradaNotificacionPermanencia.setGenero(entradaPermanencia.getGenero());
		entradaNotificacionPermanencia.setEntidadFederativaDeNacimiento(entradaPermanencia.getEntidadFederativaDeNacimiento());
		entradaNotificacionPermanencia.setNacionalidad(entradaPermanencia.getNacionalidad());
		entradaNotificacionPermanencia.setOcupacionOProfesionTrabajador(entradaPermanencia.getOcupacionOProfesionTrabajador());
		entradaNotificacionPermanencia.setActividadOGiroNegocioTrabajador(entradaPermanencia.getActividadOGiroNegocioTrabajador());
		entradaNotificacionPermanencia.setNivelDeEstudioTrabajador(entradaPermanencia.getNivelDeEstudioTrabajador());
		entradaNotificacionPermanencia.setCurpSolicitante(entradaPermanencia.getCurpSolicitante());
		entradaNotificacionPermanencia.setTipoSolicitante(entradaPermanencia.getTipoSolicitante());
		entradaNotificacionPermanencia.setDatosParticulares(datosParticulares);
		entradaNotificacionPermanencia.setDomicilioLaboral(domicilioLaboral);
		entradaNotificacionPermanencia.setReferencias(referencias);
		entradaNotificacionPermanencia.setBeneficiarios(beneficiarios);
		entradaNotificacionPermanencia.setRespuestaServicio(salidaPermanencia);

		if(!validadorUtils.validarObjetoNulo(entradaNotificacionPermanencia.getRespuestaServicio())) {
			String diagnoticoRecepcion = validarDiagnostico(entradaNotificacionPermanencia.getRespuestaServicio().getDiagnosticoDeRecepcion());
			entradaNotificacionPermanencia.getRespuestaServicio().setDiagnosticoDeRecepcion(diagnoticoRecepcion);
		}
		
		if(!validadorUtils.validarObjetoNulo(flujoModificacion)) {
			entradaNotificacionPermanencia.setFolioOrigen(cadenaUtils.obtenerContenidoCadenaSinEspacios(flujoModificacion.getFolioPulssarOrigen(), null));
		}
		
		return entradaNotificacionPermanencia;
	}
	
	/**
	 * Metodo para mapeo entrada notificacion actualiza
	 * @param salidaActualizaDatos
	 * @param datosTrabajador
	 * @param folio
	 * @return
	 */
	private EntradaNotificacionActualiza mapEntradaNotificacionActualiza(SalidaActualizaDatos salidaActualizaDatos, DatosTrabajador datosTrabajador,Folio folio,FlujoModificacion flujoModificacion) {
		EntradaNotificacionActualiza entradaNotificacionActualiza = new EntradaNotificacionActualiza();

		entradaNotificacionActualiza.setAfore(datosTrabajador.getClaveAfore());
		entradaNotificacionActualiza.setFolioCliente(folio.getChFolio());
		entradaNotificacionActualiza.setEntidadOrigen(salidaActualizaDatos.getObjetoRespuesta().getEntidadOrigen());
		entradaNotificacionActualiza.setIndicadorEnrolamiento(validadorUtils.isEmpty(salidaActualizaDatos.getObjetoRespuesta().getDatosBaseCurp().getIndicadorEnrolamiento()) ? null : Long.valueOf(salidaActualizaDatos.getObjetoRespuesta().getDatosBaseCurp().getIndicadorEnrolamiento()));
		if(validadorUtils.isEmpty(datosTrabajador.getDatosCertificables().getCurp())) {
			entradaNotificacionActualiza.setCurp(salidaActualizaDatos.getObjetoRespuesta().getDatosBaseCurp().getCurpNueva());
		}else {
			entradaNotificacionActualiza.setCurp(cadenaUtils.asignarValor(datosTrabajador.getDatosCertificables().getCurp()));
		}
		entradaNotificacionActualiza.setNss(salidaActualizaDatos.getObjetoRespuesta().getNss());
		entradaNotificacionActualiza.setDatosBaseCurp(salidaActualizaDatos.getObjetoRespuesta().getDatosBaseCurp());
		entradaNotificacionActualiza.setDatosDomicilioParticularTrabajador(salidaActualizaDatos.getObjetoRespuesta().getDatosDomicilioParticularTrabajador());
		entradaNotificacionActualiza.setDatosDomicilioLaboralTrabajador(salidaActualizaDatos.getObjetoRespuesta().getDatosDomicilioLaboralTrabajador());
		entradaNotificacionActualiza.setDatosReferenciasTrabajador(salidaActualizaDatos.getObjetoRespuesta().getDatosReferenciasTrabajador());
		entradaNotificacionActualiza.setListaBeneficiariosTrabajador(salidaActualizaDatos.getObjetoRespuesta().getListaBeneficiariosTrabajador());
	
		String diagnosticoBaseCurp = validarDiagnostico(entradaNotificacionActualiza.getDatosBaseCurp().getDiagnosticoDeRecepcion());	
		entradaNotificacionActualiza.getDatosBaseCurp().setDiagnosticoDeRecepcion(diagnosticoBaseCurp);
		
		if(!validadorUtils.validarObjetoNulo(entradaNotificacionActualiza.getDatosDomicilioParticularTrabajador())) {
			String diagnosticoDomicilioParticular = validarDiagnostico(entradaNotificacionActualiza.getDatosDomicilioParticularTrabajador().getDiagnosticoDeRecepcion());
			entradaNotificacionActualiza.getDatosDomicilioParticularTrabajador().setDiagnosticoDeRecepcion(diagnosticoDomicilioParticular);
		}
		if(!validadorUtils.validarObjetoNulo(entradaNotificacionActualiza.getDatosDomicilioLaboralTrabajador())) {
			String diagnosticoDomicilioLaboral = validarDiagnostico(entradaNotificacionActualiza.getDatosDomicilioLaboralTrabajador().getDiagnosticoDeRecepcion());
			entradaNotificacionActualiza.getDatosDomicilioLaboralTrabajador().setDiagnosticoDeRecepcion(diagnosticoDomicilioLaboral);
		}

		if(!validadorUtils.validarObjetoNulo(entradaNotificacionActualiza.getDatosReferenciasTrabajador())) {
			String diagnosticoReferencias = validarDiagnostico(entradaNotificacionActualiza.getDatosReferenciasTrabajador().getDiagnosticoDeRecepcion());
			entradaNotificacionActualiza.getDatosReferenciasTrabajador().setDiagnosticoDeRecepcion(diagnosticoReferencias);
		}		

		if(!validadorUtils.validarObjetoNulo(entradaNotificacionActualiza.getListaBeneficiariosTrabajador()) && !validadorUtils.validarListaVacia(entradaNotificacionActualiza.getListaBeneficiariosTrabajador().getBeneficiario())) {
				List<DatosBeneficiarioTrabajadorSalida> listaBeneficiarios = entradaNotificacionActualiza.getListaBeneficiariosTrabajador().getBeneficiario();
				for(int i = 0; i < listaBeneficiarios.size(); i++) {
					String diagnosticoBeneficiarios = validarDiagnostico(listaBeneficiarios.get(i).getDiagnosticoDeRecepcion());
					entradaNotificacionActualiza.getListaBeneficiariosTrabajador().getBeneficiario().get(i).setDiagnosticoDeRecepcion(diagnosticoBeneficiarios);
				}
		}
		
		if(!validadorUtils.validarObjetoNulo(flujoModificacion)) {
			entradaNotificacionActualiza.setFolioOrigen(cadenaUtils.obtenerContenidoCadenaSinEspacios(flujoModificacion.getFolioPulssarOrigen(), null));
		}
		
		if(ModificacionTrabajadorConstants.FLUJO_9B.equals(salidaActualizaDatos.getObjetoRespuesta().getDatosBaseCurp().getFlujoDeValidacion())) {
			entradaNotificacionActualiza.setIndicadorAceptaFlujo(NumerosConstants.L_UNO);
		}
		
		entradaNotificacionActualiza.setMovBeneficiario(salidaActualizaDatos.getObjetoRespuesta().getDatosBaseCurp().getMovimientoBeneficiario());

		return entradaNotificacionActualiza;
	}
	
	/**
	 * Metodo que acorta diagnostico a 3 posiciones
	 * @param diagnosticoEntrada
	 * @return
	 */
	public String validarDiagnostico(String diagnosticoEntrada) {
		String diagnostico = diagnosticoEntrada;
		return diagnostico.substring(0,3);
	}
	
	/**
	 * Metodo que valida caracteres especiales datos particulares permanencia
	 * @param entradaPermanencia
	 * @param caracterHomologado
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public DatosParticulares validaEntradaDatosParticulares(EntradaPermanencia entradaPermanencia,String caracterHomologado) {
		DatosParticulares datosParticulares = null;
		if(!validadorUtils.validarObjetoNulo(entradaPermanencia.getDatosParticulares())) {
			datosParticulares = new DatosParticulares();
			datosParticulares.setCalle(eliminarAcentos(entradaPermanencia.getDatosParticulares().getCalle(), caracterHomologado));
			datosParticulares.setNumeroExterior(entradaPermanencia.getDatosParticulares().getNumeroExterior());
			datosParticulares.setNumeroInterior(entradaPermanencia.getDatosParticulares().getNumeroInterior());
			datosParticulares.setColonia(eliminarAcentos(entradaPermanencia.getDatosParticulares().getColonia(), caracterHomologado));
			datosParticulares.setDelegacionOMunicipio(eliminarAcentos(entradaPermanencia.getDatosParticulares().getDelegacionOMunicipio(), caracterHomologado));
			datosParticulares.setCodigoPostal(entradaPermanencia.getDatosParticulares().getCodigoPostal());
			datosParticulares.setEntidadFederativa(eliminarAcentos(entradaPermanencia.getDatosParticulares().getEntidadFederativa(), caracterHomologado));
			datosParticulares.setPais(entradaPermanencia.getDatosParticulares().getPais());
			datosParticulares.setIndicadorDeTelefono1(entradaPermanencia.getDatosParticulares().getIndicadorDeTelefono1());
			datosParticulares.setTelefono1(entradaPermanencia.getDatosParticulares().getTelefono1());
			datosParticulares.setExtension1(entradaPermanencia.getDatosParticulares().getExtension1());
			datosParticulares.setIndicadorDeTelefono2(entradaPermanencia.getDatosParticulares().getIndicadorDeTelefono2());
			datosParticulares.setTelefono2(entradaPermanencia.getDatosParticulares().getTelefono2());
			datosParticulares.setExtension2(entradaPermanencia.getDatosParticulares().getExtension2());
			datosParticulares.setCorreoElectronicoDelTrabajador(entradaPermanencia.getDatosParticulares().getCorreoElectronicoDelTrabajador());
			datosParticulares.setClaveEntidad(entradaPermanencia.getDatosParticulares().getClaveEntidad());
		}
		return datosParticulares;
	}
	
	/**
	 * Metodo que valida caracteres espciales en domicilio laboral permanencia
	 * @param entradaPermanencia
	 * @param caracterHomologado
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public DomicilioLaboral validaDomicilioLaboralPermanencia(EntradaPermanencia entradaPermanencia,String caracterHomologado) {
		DomicilioLaboral domicilioLaboral = null;		
		if(!validadorUtils.validarObjetoNulo(entradaPermanencia.getDomicilioLaboral())) {
			domicilioLaboral = new DomicilioLaboral();
			domicilioLaboral.setCalle(eliminarAcentos(entradaPermanencia.getDomicilioLaboral().getCalle(), caracterHomologado));
			domicilioLaboral.setNumeroExterior(entradaPermanencia.getDomicilioLaboral().getNumeroExterior());
			domicilioLaboral.setNumeroInterior(entradaPermanencia.getDomicilioLaboral().getNumeroInterior());
			domicilioLaboral.setColonia(eliminarAcentos(entradaPermanencia.getDomicilioLaboral().getColonia(), caracterHomologado));
			domicilioLaboral.setDelegacionOMunicipio(eliminarAcentos(entradaPermanencia.getDomicilioLaboral().getDelegacionOMunicipio(), caracterHomologado));
			domicilioLaboral.setCodigoPostal(entradaPermanencia.getDomicilioLaboral().getCodigoPostal());
			domicilioLaboral.setEntidadFederativa(eliminarAcentos(entradaPermanencia.getDomicilioLaboral().getEntidadFederativa(), caracterHomologado));
			domicilioLaboral.setPais(entradaPermanencia.getDomicilioLaboral().getPais());
		}
		return domicilioLaboral;
	}
	
	/**
	 * Metodo que valida caracteres especiales referencias permanencia
	 * @param entradaPermanencia
	 * @param caracterHomologado
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public Referencias validaReferenciasPermanencia(EntradaPermanencia entradaPermanencia,String caracterHomologado){
		Referencias referencias = null;
		if(!validadorUtils.validarObjetoNulo(entradaPermanencia.getReferencias())) {
			referencias = new Referencias();
			referencias.setApellidoPaternoDeReferencia1(eliminarAcentos(entradaPermanencia.getReferencias().getApellidoPaternoDeReferencia1(), caracterHomologado));
			referencias.setApellidoMaternoDeReferencia1(eliminarAcentos(entradaPermanencia.getReferencias().getApellidoMaternoDeReferencia1(), caracterHomologado));
			referencias.setNombreDeReferencia1(eliminarAcentos(entradaPermanencia.getReferencias().getNombreDeReferencia1(), caracterHomologado));
			referencias.setCurpDeReferencia1(entradaPermanencia.getReferencias().getCurpDeReferencia1());
			referencias.setTelefonoDeReferencia1(entradaPermanencia.getReferencias().getTelefonoDeReferencia1());
			referencias.setParentescoORelacionDeReferencia1(entradaPermanencia.getReferencias().getParentescoORelacionDeReferencia1());
			referencias.setApellidoPaternoDeReferencia2(eliminarAcentos(entradaPermanencia.getReferencias().getApellidoPaternoDeReferencia2(), caracterHomologado));
			referencias.setApellidoMaternoDeReferencia2(eliminarAcentos(entradaPermanencia.getReferencias().getApellidoMaternoDeReferencia2(), caracterHomologado));
			referencias.setNombreDeReferencia2(eliminarAcentos(entradaPermanencia.getReferencias().getNombreDeReferencia2(), caracterHomologado));
			referencias.setCurpDeReferencia2(entradaPermanencia.getReferencias().getCurpDeReferencia2());
			referencias.setTelefonoDeReferencia2(entradaPermanencia.getReferencias().getTelefonoDeReferencia2());
			referencias.setParentescoORelacionDeReferencia2(entradaPermanencia.getReferencias().getParentescoORelacionDeReferencia2());
		}
		return referencias;
	}
	
	/**
	 * Metodo que valida Beneficiarios permanencia
	 * @param entradaPermanencia
	 * @param caracterHomologado
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Override
	public Beneficiarios validaBeneficiariosPermanencia(EntradaPermanencia entradaPermanencia,String caracterHomologado) {
		Beneficiarios beneficiarios = null;
		List<DatosBeneficiarioTrabajador> listaBeneficiarios = new ArrayList<>();
		if(!validadorUtils.validarObjetoNulo(entradaPermanencia.getBeneficiarios()) && !validadorUtils.validarListaVacia(entradaPermanencia.getBeneficiarios().getBeneficiario())) {
				for(DatosBeneficiarioTrabajador beneficiario : entradaPermanencia.getBeneficiarios().getBeneficiario()) {
					DatosBeneficiarioTrabajador datosBeneficiario = new DatosBeneficiarioTrabajador();
					datosBeneficiario.setApellidoPaternoDeBeneficiario(eliminarAcentos(beneficiario.getApellidoPaternoDeBeneficiario(),caracterHomologado));
					datosBeneficiario.setApellidoMaternoDeBeneficiario(eliminarAcentos(beneficiario.getApellidoMaternoDeBeneficiario(),caracterHomologado));
					datosBeneficiario.setNombreDeBeneficiario(eliminarAcentos(beneficiario.getNombreDeBeneficiario(),caracterHomologado));
					datosBeneficiario.setCurpDeBeneficiario(beneficiario.getCurpDeBeneficiario());
					datosBeneficiario.setParentescoORelacion(beneficiario.getParentescoORelacion());
					datosBeneficiario.setPorcentajeDeBeneficiario(beneficiario.getPorcentajeDeBeneficiario());
					listaBeneficiarios.add(datosBeneficiario);
				}
				beneficiarios = new Beneficiarios();
				 beneficiarios.setBeneficiario(listaBeneficiarios);
		}
		return beneficiarios;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String eliminarAcentos(String entrada, String homologado) {
		String salida = entrada;
		String caracter = null;
		StringBuilder cadena = new StringBuilder();
		try {
			char[] caracterCodificar = salida.toCharArray();
			for (char c : caracterCodificar) {
				caracter = String.valueOf(c);
				boolean caracterMatcher = this.validaCaracterEspecial(String.valueOf(c));
				
				if (!caracterMatcher) {
					caracter = homologado;
				}
				cadena.append(caracter);
			}
		}catch (Exception e) {
			logger.error("Ocurrio un problema al eliminar acento: {}",e);
			return null;
		}

		return cadena.toString();
	}

	/**
	 * metodo que valida caracteres especiales sin conversion de URLEncoder
	 * 
	 * @param cadena
	 * @return
	 */
	private boolean validaCaracterEspecial(String cadena) {
		Pattern patron = Pattern.compile(AgenteConstants.EXP_REGULAR_VALIDA_CARACTER_BLANCO);
		Matcher mat = patron.matcher(cadena);
		return mat.matches();
	}

}
