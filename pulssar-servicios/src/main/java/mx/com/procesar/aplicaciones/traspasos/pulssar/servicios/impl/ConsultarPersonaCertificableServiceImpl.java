package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CanaseService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPersonaCertificablesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteRecertificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResolucionParcialService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RespuestaDeepDiveService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SaldosPreliminaresService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ArchivosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GeneroEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Afore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CURPStruct;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultarKardexSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CurpDuplicada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosConsultaSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosHuellas;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNoCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSalariosIcefas;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Domicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EstatusExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Icefa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.InfoHuellas;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Nacionalidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NsarBeneficiario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NsarDomicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosSalidaMarca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PersonaSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Referencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReferenciaTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Renapo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Telefono;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TelefonoTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidacionDomicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidacionIdentificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;
/**
 * 
 * @author JMGUTIER
 *
 */
@Service
public class ConsultarPersonaCertificableServiceImpl implements ConsultarPersonaCertificablesService {
	
	/**
	 * Logger
	 */
	private static final Logger logger =  LoggerFactory.getLogger(ConsultarPersonaCertificableServiceImpl.class);
	
	/**
	 * recuperacion de valor servicio valida persona
	 */
	@Value("${validacion.persona.wsdl.nss}")
	private String consultaPersonaNss;
	
	/**
	 * recuperacion de valor servicio valida persona
	 */
	@Value("${validacion.persona.wsdl.curp}")
	private String consultaPersonaCurp;
	
	/**
	 * uriIdProcesar
	 */
	@Value("${uri.comunes.buscar.idprocesar}")
	private String uriIdProcesar;
	
	/**
	 * recuperacion de valor servicio valida expediente
	 */
	@Value("${validacion.expediente.wsdl}")
	private String consultaExpediente;
	/**
	 * recuperacion de marcas
	 */
	@Value("${validacion.marcas.wsdl}")
	private String consultaMarcas;
	/**
	 * recuperacion de valor servicio valida decimo transitorio
	 */
	@Value("${validacion.decimo.wsdl}")
	private String consultaDecimo;
	/**
	 * recuperacion de valor servicio valida curp duplicada
	 */
	@Value("${validacion.curpduplicada.wsdl}")
	private String consultaCurpDuplicada;
	/**
	 * recuperacion de valor servicio valida curp duplicada
	 */
	@Value("${validacion.kardex.wsdl}")
	private String kardexUri;
	
	/**
	 * recuperacion de valor servicio valida curp duplicada
	 */
	@Value("${agente.promotor.uri}")
	private String uriAgenteFoto;
	
	/**
	 * recuperacion de valor servicio valida curp duplicada
	 */
	@Value("${validacion.persona.wsdl.foto}")
	private String uriFotoPersona;
	
	/**
	 * recuperacion de informacion de renapo
	 */
	@Value("${comunes.obtener.renapo.uri}")
	private String uriRenapo;
	
	/**
	 * dependencia clienteServicio
	 */
	@Autowired
	private RestTemplate clienteServicio;
	/**
	 * dependencia cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * dependencia utilidad fecha
	 */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/**
	 * dependencia utilidad validador
	 */
	@Autowired 
	private ValidadorUtils validadorUtilidad;
	/**
	 * servicio folio
	 */
	@Autowired
	private FolioService servicioFolio;
	
	/**
	 * Inyeccion de servicio catalgoo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion de servicio catalgoo
	 */
	@Autowired
	private SaldosPreliminaresService servicioSaldos;
	
	/**
	 * Inyeccion de servicio catalgoo
	 */
	@Autowired
	private ExpedienteService servicioExpediente;
	
	/**
	 * recuperacion de valor de entidad federativa
	 */
	@Value("${validacion.entidad.descripcion}")
	private String entidadFedDescripcion;

	/**
	 * recuperacion valor de servicio de tipo de expediente
	 */
	@Value("${validacion.expediente.estatus}")
	private String consultaEstatusExpediente;
	
	/**
	 * recuperacion de valor de servicio afore activo
	 */
	@Value("${validacion.afore.activo}")
	private String consultaAforeActivo;
	
	/**
	 * recuperacion de consulta tipo proceso
	 */
	@Value("${validacion.consulta.proceso}")
	private String consultaTipoProceso;
	
	/**
	 * recuperacion de entidad federativa
	 */
	@Value("${validacion.entidad.claveCorta}")
	private String consultarEntidad;
	
	/**
	 * recuperacion de valor servicio valida persona
	 */
	@Value("${validacion.persona.curp.nss}")
	private String consultaPersonaCurpNss;
	
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * servicio consulta salario
	 */
	@Value("${servicio.salario.nss}")
	private String urlServicioSalario;
	
	
	/**
	 * Inyeccion de servicio catalgoo
	 */
	@Autowired
	private RespuestaDeepDiveService servicioRespuestas;
	/**
	 * inyeccion dependencia CanaseService
	 */
	@Autowired
	private CanaseService canaseService;
	/**
	 * inyeccion dependencia ExpedienteRecertificacionService
	 */
	@Autowired
	private ExpedienteRecertificacionService expedienteRecertificacionService;	
	/**
	 * inyeccion dependencia ResolucionParcialService
	 */
	@Autowired
	private ResolucionParcialService resolucionParcialService;
	
	/**
     * Inyeccion de service expediente
     */
    @Autowired
    private EstatusExpedienteService expedienteService;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatosTrabajador consultarPersona(EntradaConsulta datosEntrada, Long idUser, String curpAgente, String sucursal) {
		logger.info("Metodo encargado de validar las huellas del trabajador validarTrabajadorConsulta");
		DatosTrabajador trabajador = new DatosTrabajador();
		try {
			this.validarDatosEntrada(datosEntrada);
			//CONSULTA PERSONA
			List<PersonaSalida> listaPersonas = consultarTrabajador(datosEntrada);
			
			//VALIDACION PERSONA VS AFORE

			Map<String,Object> obtenerPersonaValida=obtenerPersonaValida(listaPersonas, datosEntrada.getClaveAfore());

			PersonaSalida persona = (listaPersonas != null && !listaPersonas.isEmpty() ? listaPersonas.get(0) : null );
			String valoresExtras = servicioCatalogo.consultaValorParametro(NumerosConstants.C_UNO, AgenteConstants.PARAMETRO_AFORES_PROSPECTOS);
			
			if(valoresExtras != null && !valoresExtras.contains(datosEntrada.getClaveAfore())) {
				obtenerPersonaValida = obtenerPersonaValida(listaPersonas, datosEntrada.getClaveAfore());
				
				if(obtenerPersonaValida.get(ServiciosConstants.PERSONA)!=null) {
					 persona = (PersonaSalida) obtenerPersonaValida.get(ServiciosConstants.PERSONA);
				}else {
					throw new BusinessException(BusinessErrorEnum.TRABAJADOR_AFORE_DISTINTA);
				}
				
				trabajador.setExisteTrabajador((Boolean) obtenerPersonaValida.get(ServiciosConstants.EXISTE_PERSONA));
				
			}else {
				
				obtenerPersonaValida.put(ServiciosConstants.PERSONA, persona);
				obtenerPersonaValida.put(ServiciosConstants.EXISTE_PERSONA, Boolean.TRUE);
				trabajador.setExisteTrabajador((persona != null));
			}
			
			logger.info("Revisa los datos de entrada para el folio nss :: {} -- curp :: {}", datosEntrada.getNss(), datosEntrada.getCurp());
			String curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosEntrada.getCurp(), persona.getCurp(),null);
			String nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosEntrada.getNss(), persona.getNss(),null);
			
			//GENERACION FOLIO
			logger.info("Obtiene el folio de consulta de la persona {} {}", curp, nss);
			trabajador.setFolio(generarFolio(datosEntrada, idUser, curp, nss, sucursal));
			
			logger.info("Asignando datos principales al objeto principal {} {}", curp, nss);
			trabajador.setNss(utileriaCadena.obtenerContenidoCadenaSinEspacios(nss, ExpresionesConstants.VACIO));
			trabajador.setNombreTrabajador(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(persona.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
					utileriaCadena.obtenerContenidoCadenaSinEspacios(persona.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
					utileriaCadena.obtenerContenidoCadenaSinEspacios(persona.getApellidoMaterno(), ExpresionesConstants.VACIO)));
			trabajador.setClaveAfore(persona.getAfore().getClaveAfore());
			trabajador.setProcesar(persona.getIdProcesar());
			trabajador.setNacionalidad(this.obtenerNacionalidad(persona.getNacionalidad()));
			trabajador.setTipoAfiliacion(persona.getTipoAfiliacion());
			//DATOS CERTIFICABLES
			logger.info("Asignando datos certificables {} {}", curp, nss);
			trabajador.setDatosCertificables(this.obtenerDatosCertificables(persona));
			//DATOS NO CERTIFICABLES
			logger.info("Asignando datos no certificables {} {}", curp, nss);
			trabajador.setDatosNoCertificables(obtenerDatosNoCertificables(persona));
			//DATOS COMPLEMENTARIOS (OPCION DEL MENU)
			logger.info("Asignando datos complementarios {} {}", curp, nss);
			trabajador.setDatosComplementarios(this.obtenerDatosComplementarios(persona));
			//DATOS EXPEDIENTE
			trabajador.setDatosExpediente(this.validarExpediente(curp, trabajador.getClaveAfore(), null, null, curpAgente));
		} catch (BusinessException be) {
			logger.error("Error de negocio.", be);
			this.cerrarFolio(trabajador.getFolio());
			throw new BusinessException(BusinessErrorEnum.obtenerError(be.getCodigo()));
		}
		return trabajador;
	}
	
	/**
	 * Obtiene al trabajador
	 * @return
	 */
	private List<PersonaSalida> consultarTrabajador(EntradaConsulta datosEntrada) {
		String solicitud = this.obtenerUrlConsulta(datosEntrada);
		logger.info("url consultarPersona {}",solicitud);
		List<PersonaSalida> listaPersonas = this.invocarServicioConsultaPersona(solicitud, datosEntrada);
		logger.info("Se obtuvo respuesta de la consulta del trabajador {} {}", datosEntrada.getCurp(), datosEntrada.getNss());
		if(validadorUtilidad.validarObjetoNulo(listaPersonas) || validadorUtilidad.validarListaVacia(listaPersonas)) {
			throw new BusinessException(BusinessErrorEnum.TRABAJADOR_NO_ENCONTRADO);
		}
		return listaPersonas;
	}
	
	/**
	 * Obtiene los datos No certificables
	 */
	private DatosNoCertificables obtenerDatosNoCertificables(PersonaSalida persona) {
		DatosNoCertificables datosNC = new DatosNoCertificables();
		datosNC.setRfc(utileriaCadena.obtenerContenidoCadenaSinEspacios(persona.getParticipante().getRfc(),ExpresionesConstants.VACIO));
		datosNC.setClaveTipoDocProbatorio(persona.getIdTipoDoctoProbatorio());
		datosNC.setClaveOcupacion(persona.getOcupacion());
		datosNC.setClaveGiro(persona.getClaveGiro());
		datosNC.setEstudios(persona.getGradoEstudios());
		datosNC.setClaveNacionalidad(persona.getNacionalidad());
		return datosNC;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatosTrabajador obtenerDatosAdicionales(DatosTrabajador auxiliarTrabajador, boolean aforesDistintas) {
		DatosTrabajador trabajador = auxiliarTrabajador;
		
		String curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(auxiliarTrabajador.getDatosCertificables().getCurp(), null); 
		String nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(auxiliarTrabajador.getNss(), null);
		//MARCAS OPERATIVAS
		trabajador.setMarcas(this.consultarMarca(trabajador.getProcesar()));
		//CURPS DUPLICADAS
		trabajador.setAforesDuplicadas(this.consultarCurpDuplicada(curp, trabajador.getProcesar(), auxiliarTrabajador.getClaveAfore()));
		//IMAGEN DEL TRABAJADOR
		String aforeImagen = obtenerAforeImagen(trabajador.getDatosExpediente(), trabajador.getClaveAfore());
		trabajador.setImagen(this.obtenerImagenTrabajador(curp, aforeImagen));
		//DATOS RECERTIFICACION
		trabajador.setCertificado(expedienteRecertificacionService.obtenerDatoRecertificacion(trabajador.getProcesar()));
		//INDICADOR RETIRO DESEMPLEO
		trabajador.setFechaDesempleo(resolucionParcialService.obtenerResolucionParcial(trabajador.getProcesar(), "06"));
		//INDICADOR RETIRO MATRIMONIO
		trabajador.setFechaMatrimonio(resolucionParcialService.obtenerResolucionParcial(trabajador.getProcesar(), "07"));
		if(!aforesDistintas) {
			//SUELDOS Y SALARIOS
			ConsultarKardexSalida kardex = this.consultarKardex(trabajador.getClaveAfore(), curp, nss);
			trabajador = this.obtenerValoresIcefas(trabajador, kardex);
			//DATOS RENAPO
			trabajador.setRenapo(this.obtenerDatosRenapo(trabajador));
			//SALDOS Y SALARIOS
			trabajador.setSaldos(servicioSaldos.obtenerSaldosPreliminares(curp, nss, auxiliarTrabajador.getClaveAfore()));
			//DATOS CANASE
			trabajador.setCanase(canaseService.consultarCanase(trabajador.getNss()));
		}
		
		return trabajador;
	}
	
	/**
	 * Metodo encargado de validar los datos de expediente
	 * 
	 * @param expediente
	 * @param aforeConsulta
	 * @return
	 */
	private String obtenerAforeImagen(DatosExpediente expediente, String aforeConsulta) {
		logger.info("Obteniendo afore consulta imagen trabajador: afore consulta >> {}", aforeConsulta);
		String aforeImagen = aforeConsulta;
		if(expediente != null && expediente.getAforeIdentificacion() != null) {
			aforeImagen = expediente.getAforeIdentificacion().isEmpty() ? aforeConsulta : expediente.getAforeIdentificacion();
			logger.info("Afore expediente >> {}", aforeImagen);
		}
		return aforeImagen;
	}
	
	/**
	 * Obtener la nacionalidad del trabajador
	 * @param id
	 * @return
	 */
	protected String obtenerNacionalidad(Long id) {
		String nacionalidad = ExpresionesConstants.VACIO;
		
		if(!validadorUtilidad.validarObjetoNulo(id)) {
			Nacionalidad nacional = servicioCatalogo.obtenerNacionalidad(id);
			if(!validadorUtilidad.validarObjetoNulo(nacional)) {
				String[] cadenaNacional = nacional.getChDescripcion().split(ExpresionesConstants.DOS_PUNTOS);
				nacionalidad = cadenaNacional[NumerosConstants.INT_CERO];
				
			}
		}
		
		return nacionalidad;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cerrarFolio(FolioEntrada folio) {
		try {
			if(!validadorUtilidad.validarObjetoNulo(folio)) {
				servicioFolio.cerrarFolio(folio.getIdFolio(), null);
			}
		} catch(Exception e) {
			logger.error("Error no controlado al cerrar folio", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA.getClave()); 
		}
	}
	/**
	 * Generar folio de consulta
	 * @param datosEntrada
	 * @param user
	 * @return
	 */
	private FolioEntrada generarFolio(EntradaConsulta datosEntrada, Long idUser, String curp, String nss, String sucursal){
		FolioEntrada entrada = new FolioEntrada();
		entrada.setIdUsuario(idUser);
		entrada.setOperacion(ServiciosConstants.FOLIO_OPERACION_CONSULTA);
		entrada.setServicio(ServiciosConstants.FOLIO_SERVICIO_CONSULTA);
		entrada.setCurp(utileriaCadena.obtenerContenidoCadenaSinEspacios(curp, null));
		entrada.setNss(utileriaCadena.obtenerContenidoCadenaSinEspacios(nss, null));
		entrada.setSucursal(sucursal);
		entrada.setTiempoLlegada((datosEntrada.getTimerPicker() == null ? "00:00" : datosEntrada.getTimerPicker()));
		
		FolioEntrada respuesta = servicioFolio.generarFolio(entrada);
		
		if(ServiciosConstants.RESULTADO_NOK.equals(respuesta.getResultado())) {
			servicioFolio.cerrarFolio(respuesta.getIdFolio(), null);
			respuesta = servicioFolio.generarFolio(entrada);
		}
		return respuesta;
	}
	
	/**
	 * Metodo encagardo de obtener la persona valida
	 * 
	 * @param listaPersonas
	 * @param afore
	 * @return
	 */
	protected Map<String,Object> obtenerPersonaValida(List<PersonaSalida> listaPersonas, String afore) {
		Map<String,Object> mapaExistePersona=new HashMap<>();
		PersonaSalida persona = null;
		int i = 0;
		do {
			PersonaSalida personaSalida = listaPersonas.get(i);
			logger.info("Se valida que se encuentre en la misma afore {} - persona {}", afore, personaSalida.getAfore().getClaveAfore());
			if(afore.equals(personaSalida.getAfore().getClaveAfore())) {
				persona = personaSalida;
				mapaExistePersona.put(ServiciosConstants.PERSONA, persona);
				mapaExistePersona.put(ServiciosConstants.EXISTE_PERSONA, Boolean.TRUE);
				break;
			}
			i++;
		} while(i < listaPersonas.size() && validadorUtilidad.validarObjetoNulo(persona));
		
		if(persona == null) {
			mapaExistePersona.put(ServiciosConstants.PERSONA, null);
			mapaExistePersona.put(ServiciosConstants.EXISTE_PERSONA, null);
		}
		
		return mapaExistePersona;
	}
	
	/**
	 * Obtener la consulta de persona
	 * @return
	 */
	private List<PersonaSalida> invocarServicioConsultaPersona(String urlServicioConsulta, EntradaConsulta datosEntrada) {
		List<PersonaSalida> lista = new ArrayList<>(); 
		try {
			logger.info("Se realiza la consulta del trabajador {} {}", datosEntrada.getNss(), datosEntrada.getCurp());
			if(StringUtils.contains(urlServicioConsulta, "idProcesar")) {
				logger.info("consulta por id procesar");

				PersonaSalida respuesta = clienteServicio.getForObject(urlServicioConsulta, PersonaSalida.class);
				lista.add(respuesta);
				return lista;
			}
			ResponseEntity<List<PersonaSalida>> respuesta = clienteServicio.exchange(urlServicioConsulta, HttpMethod.GET, null, new ParameterizedTypeReference<List<PersonaSalida>>(){});
			if(!ObjectUtils.isEmpty(respuesta)) {
				return respuesta.getBody();
			}
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio de consulta persona{} {}", datosEntrada.getNss(), datosEntrada.getCurp(), e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return lista;
	}

	/**
	 * MEtodo que realiza para obtener la lista de persona
	 * @Author: Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Nov 11, 2019
	 * @param urlServicioConsulta
	 * @param datosEntrada
	 * @return String Json(Lista Persona)
	 */
	private String invocarServicioConsultaListaPersona(String urlServicioConsulta, EntradaConsulta datosEntrada) {
		String respuesta = null;
		try {
			logger.error("Log-Se realiza la consulta del trabajador: nss:{} curp:{}", datosEntrada.getNss(), datosEntrada.getCurp());
			respuesta = clienteServicio.getForObject(urlServicioConsulta, String.class);  
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio de consulta persona:: url: {} nss:{} curp:{},\n ERROR:: {}", urlServicioConsulta, datosEntrada.getNss(), datosEntrada.getCurp(), e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return respuesta;
	}
	
	/**
	 * Metodo encargado de validar que uno de los parametros sea valido
	 * 
	 * @param entrada
	 * @return
	 */
	private RespuestaServicio validarDatosEntrada(EntradaConsulta entrada) {
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(NumerosConstants.INT_UNO);
		if(validadorUtilidad.validarVacio(entrada.getNss()) && validadorUtilidad.validarVacio(entrada.getCurp())) {
			throw new BusinessException(BusinessErrorEnum.DATOS_NO_CAPTURADOS);
		}
		
		if(validadorUtilidad.validarVacio(entrada.getTimerPicker()) && !entrada.getClaveAfore().equals(ServiciosConstants.CLAVE_CONSAR)) {
			throw new BusinessException(BusinessErrorEnum.HORARIO_NO_CAPTURADO);
		}
		return respuesta;
	}
	
	/**
	 * Metodo encargado de obtener la url de consulta
	 * 
	 * @param datosEntrada
	 * @return
	 */
	private String obtenerUrlConsulta(EntradaConsulta datosEntrada) {
		String solicitud = consultaPersonaCurp;
		String uri = uriIdProcesar;
		if(StringUtils.isNotEmpty(datosEntrada.getIdProcesar())) {
			return StringUtils.replace(uri, "{idProcesar}", datosEntrada.getIdProcesar());			
		}
		
		String curp = datosEntrada.getCurp();
		if (!validadorUtilidad.validarVacio(datosEntrada.getNss())) {
			solicitud = utileriaCadena.obtenerCadenaConcatenada(true, consultaPersonaNss, datosEntrada.getNss());
			curp = ExpresionesConstants.VACIO;
			if(!validadorUtilidad.validarVacio(datosEntrada.getCurp())) {
				solicitud = utileriaCadena.obtenerCadenaConcatenada(true, solicitud, ServiciosConstants.DIAGONAL_CURP);
				curp = datosEntrada.getCurp();
			}
		}
		
		solicitud = utileriaCadena.obtenerCadenaConcatenada(true, solicitud, curp);
		return solicitud;
	}
	
	/**
	 * Metodo encargado de obtener los datos completmentarios del trabajador
	 * 
	 * @return
	 */
	private DatosCertificables obtenerDatosCertificables(PersonaSalida persona) {
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setIdTipoDoctoProbatorio(persona.getIdTipoDoctoProbatorio());
		datosCertificables.setCurp(persona.getCurp());
		datosCertificables.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(persona.getNombre(), ExpresionesConstants.VACIO));
		datosCertificables.setApellidoPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(persona.getApellidoPaterno(), ExpresionesConstants.VACIO));
		datosCertificables.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(persona.getApellidoMaterno(), ExpresionesConstants.VACIO));
		datosCertificables.setFechaNacimiento(utileriaFecha.convertirFechaACadena(persona.getFechaNacimiento(), FormatoConstants.FORMATO_FECHA_NACIMIENTO));
		datosCertificables.setClaveGenero(persona.getSexo().getClaveGenero());
		datosCertificables.setGenero(persona.getSexo().getDescripcionGenero());
		datosCertificables.setEntidadNacimiento("");
		if(!validadorUtilidad.validarObjetoNulo(persona.getEntidadNacimiento())){
			datosCertificables.setClaveEntidadN(persona.getEntidadNacimiento().getChCvEntidadFederativa());
			datosCertificables.setEntidadNacimiento(persona.getEntidadNacimiento().getDescripcion());
		}
		return datosCertificables;
	}
	
	/**
	 * Metodo encargado de obtener los datos completmentarios del trabajador
	 * 
	 * @return
	 */
	private DatosComplementarios obtenerDatosComplementarios(PersonaSalida persona) {
		DatosComplementarios datosComplementarios = new DatosComplementarios();
		datosComplementarios.setParticular(this.obtenerDomicilio(persona.getDomicilioList(), NumerosConstants.INT_DOS));//PARTICULAR
		datosComplementarios.setLaboral(this.obtenerDomicilio(persona.getDomicilioList(), NumerosConstants.INT_UNO));//LABORAL
		datosComplementarios.setTelefonos(this.obtenerTelefonos(persona.getTelefonoList()));
		datosComplementarios.setListaReferencias(this.obtenerReferenciasTrabajador(persona.getReferenciaList()));
		datosComplementarios.setListaBeneficiario(this.obtenerBeneficiarios(persona.getBeneficiarioList()));
		datosComplementarios.setCorreoElectronico(persona.getParticipante().getChCorreoElectronico());
		datosComplementarios.setClaveOcupacion(persona.getOcupacion());
		datosComplementarios.setFechaControl(new SimpleDateFormat(FormatoConstants.FORMATO_FECHA_RENAPO).format(persona.getParticipante().getFcControl()));
	return datosComplementarios;
	}
	
	/**
	 * Metodo encargado de obtener el domicilio
	 * 
	 * @return
	 */
	protected Domicilio obtenerDomicilio(List<NsarDomicilio> domicilios, int tipo) {
		Domicilio domicilioTrabajador = null;
		if(!validadorUtilidad.validarListaVacia(domicilios)) {
			domicilioTrabajador = this.validarDomicilio(domicilios, tipo);
			
		}
		
		return domicilioTrabajador;
	}
	
	/**
	 * Metodo encargado de validar la lista de domicilios
	 * 
	 * @param domicilios
	 * @param tipo
	 * @return
	 */
	protected Domicilio validarDomicilio(List<NsarDomicilio> domicilios, int tipo) {
		Domicilio domicilioTrabajador = null;
		int i = 0;
		do {
			NsarDomicilio domicilio = domicilios.get(i);
			int value = (int) domicilio.getId().getIdTipoDomicilio();
			
			if(value == tipo) {
				domicilioTrabajador = new Domicilio();
				domicilioTrabajador.setCalle(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCalle(), ExpresionesConstants.VACIO));
				domicilioTrabajador.setNoExterior(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNumeroExterior(), ExpresionesConstants.VACIO));
				domicilioTrabajador.setNoInterior(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNumeroInterior(), ExpresionesConstants.VACIO));
				domicilioTrabajador.setColonia(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getColonia(), ExpresionesConstants.VACIO));
				domicilioTrabajador.setCodigoPostal(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCodigoPostal(), ExpresionesConstants.VACIO));
				domicilioTrabajador.setFechacontrol(new SimpleDateFormat(FormatoConstants.FORMATO_FECHA_RENAPO).format(domicilio.getFechaControl()) );
				if(!validadorUtilidad.validarObjetoNulo(domicilio.getNsarMunicipio())) {
					domicilioTrabajador.setClaveMunicipio(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNsarMunicipio().getClaveMunicipio(),ExpresionesConstants.VACIO));
					domicilioTrabajador.setMunicipio(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNsarMunicipio().getDescripcion(), ExpresionesConstants.VACIO));
					domicilioTrabajador.setClaveEntidadFed(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNsarMunicipio().getEntidadFederativa().getClaveCorta(), ExpresionesConstants.VACIO));
					domicilioTrabajador.setEntidadFederativa(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNsarMunicipio().getEntidadFederativa().getDescripcion(), ExpresionesConstants.VACIO));
					domicilioTrabajador.setClavePais(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNsarMunicipio().getEntidadFederativa().getPais().getClavePais(), ExpresionesConstants.VACIO));
					domicilioTrabajador.setPais(utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNsarMunicipio().getEntidadFederativa().getPais().getDescripcion(), ExpresionesConstants.VACIO));
				}
			}
			
			i++;
		} while(i < domicilios.size() && validadorUtilidad.validarObjetoNulo(domicilioTrabajador));
		
		return domicilioTrabajador;
	}
	
	/**
	 * Metodo encargado e obtener la referencia del trabajador
	 * 
	 * @return
	 */
	protected List<Referencia> obtenerReferenciasTrabajador(List<ReferenciaTrabajador> referencias) {
		List<Referencia> listaReferencia = null;
		if(!validadorUtilidad.validarListaVacia(referencias)) {
			listaReferencia = new ArrayList<>();
			Referencia referencia;
			for(ReferenciaTrabajador referenciaTrab : referencias) {
				referencia = new Referencia();
				referencia.setCurp(utileriaCadena.obtenerContenidoCadenaSinEspacios(referenciaTrab.getId().getCurp(), ExpresionesConstants.VACIO));
				referencia.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(referenciaTrab.getNombre(), ExpresionesConstants.VACIO));
				referencia.setApellidoPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(referenciaTrab.getApellidoPaterno(), ExpresionesConstants.VACIO));
				referencia.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(referenciaTrab.getApellidoMaterno(), ExpresionesConstants.VACIO));
				referencia.setTelefono(utileriaCadena.obtenerContenidoCadenaSinEspacios(referenciaTrab.getTelefono(), ExpresionesConstants.VACIO));
				referencia.setClaveParentesco(utileriaCadena.obtenerContenidoCadenaSinEspacios(referenciaTrab.getParentesco().getClaveParentesco(), ExpresionesConstants.VACIO));
				referencia.setParentesco(utileriaCadena.obtenerContenidoCadenaSinEspacios(referenciaTrab.getParentesco().getDescripcion(), ExpresionesConstants.VACIO));
				referencia.setFechaControl(new SimpleDateFormat(FormatoConstants.FORMATO_FECHA_RENAPO).format(referenciaTrab.getFechaModificacion()));
				listaReferencia.add(referencia);
			}
		}
		return listaReferencia;
	}
	
	/**
	 * Metodo encargado de obtener los telefono del trabajador
	 * 
	 * @param telefonos
	 * @return
	 */
	protected Telefono obtenerTelefonos(List<TelefonoTrabajador> telefonos) {
		Telefono telefono = new Telefono();
		
		if(!validadorUtilidad.validarListaVacia(telefonos) && telefonos.size() > NumerosConstants.INT_UNO) {
			Collections.sort(telefonos, new Comparator<TelefonoTrabajador>() {
				/**
				 * Ordenar telefonos
				 */
				@Override
				public int compare(TelefonoTrabajador o1, TelefonoTrabajador o2) {
					return o1.getIdTelefono().compareTo(o2.getIdTelefono());
				}
			});
		}
		telefono.setCelular(asignarTelefonoTrabajador(telefonos, NumerosConstants.INT_CERO));
		telefono.setTelefonoFijo(asignarTelefonoTrabajador(telefonos, NumerosConstants.INT_UNO));		
		if(NumerosConstants.INT_TRES <= telefonos.size()) {
			TelefonoTrabajador telefonoTrab = telefonos.get(NumerosConstants.INT_DOS);
			telefono.setTelefonoLaboral(telefonoTrab.getNumeroTelefono());
			telefono.setExtension(telefonoTrab.getExtensionTelefonica());
		}
		
		return telefono;
	}
	
	/**
	 * Asina el telefono en caso de no encontrar
	 * 
	 * @param lTelefonos
	 * @param numAuxiliar
	 * @return
	 */
	protected String asignarTelefonoTrabajador(List<TelefonoTrabajador> lTelefonos, int numAuxiliar) {
		String valorTelefono = ExpresionesConstants.VACIO;
		if(!validadorUtilidad.validarListaVacia(lTelefonos) && numAuxiliar < lTelefonos.size()) {
				TelefonoTrabajador telefono = lTelefonos.get(numAuxiliar);
				valorTelefono = telefono.getNumeroTelefono();
		}
		return valorTelefono;
	}
	
	/**
	 * Metodo encargado e obtener la referencia del trabajador
	 * 
	 * @return
	 */
	protected List<Beneficiario> obtenerBeneficiarios(List<NsarBeneficiario> beneficiarios) {
		List<Beneficiario> listaBeneficiarios = null;
		if(!validadorUtilidad.validarListaVacia(beneficiarios)) {
			listaBeneficiarios = new ArrayList<>();
			Beneficiario beneficiario;
			for(NsarBeneficiario beneficiarioTrab : beneficiarios) {
				beneficiario = new Beneficiario();
				beneficiario.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioTrab.getNombre(), ExpresionesConstants.VACIO));
				beneficiario.setApellidoPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioTrab.getApellidoPaterno(), ExpresionesConstants.VACIO));
				beneficiario.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioTrab.getApellidoMaterno(), ExpresionesConstants.VACIO));
				if(!validadorUtilidad.validarObjetoNulo(beneficiarioTrab.getParentesco())) {
					beneficiario.setClaveParentesco(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioTrab.getParentesco().getClaveParentesco(), ExpresionesConstants.VACIO));
					beneficiario.setParentesco(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioTrab.getParentesco().getDescripcion(), ExpresionesConstants.VACIO));
				}
				beneficiario.setPorcentaje(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioTrab.getPorcentaje().toString(), ExpresionesConstants.VACIO));
				beneficiario.setCurp(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioTrab.getId().getCurp(), ExpresionesConstants.VACIO));
				beneficiario.setFechaControl(new SimpleDateFormat(FormatoConstants.FORMATO_FECHA_RENAPO).format(beneficiarioTrab.getFechaControl()));
				listaBeneficiarios.add(beneficiario);
			}
		}
		return listaBeneficiarios;
	}
	
	/**
	 * Metodo encargado de consultar el expediente del trabajador titular
	 * 
	 * @param curp
	 * @param afore
	 * @return
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public DatosExpediente validarExpediente(String curp, String afore, String statusExpActual, String statusBiomActual, String curpAgente) {
		DatosExpediente expediente = null;
		try {//EXISTE LA CURP
			if(!validadorUtilidad.validarVacio(curp)) {
				//CONSULTA EL EXPEDIENTES
				String url = utileriaCadena.obtenerCadenaConcatenada(true, consultaExpediente, curp);
				logger.info("Expediente url: " + url);
				SalidaGenerica expedienteResultado = clienteServicio.getForObject(url, SalidaGenerica.class);
				
				SalidaGenerica salida = new SalidaGenerica();
				salida.setMensaje(expedienteResultado.getMensaje());
				LinkedHashMap<String, Object> linked =(LinkedHashMap<String, Object>) expedienteResultado.getResponse();
				
				logger.info("Seteando datos de expediente {} {}", curp, afore);
				expediente = new DatosExpediente();
				expediente.setCurpTrabajador(curp);
				expediente.setFechaConsulta(utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_NACIMIENTO));
				expediente.setCurpAgente(curpAgente);
				expediente.setEstatusExpedienteIdentificacion(this.obtenerValorLinked(linked.get("estatusExpedienteIdentificacion"), ExpresionesConstants.VACIO));
				expediente.setDescEstatusExpedienteIdentificacion(this.validarEstatusExpedienteIdentificacion(linked.get("estatusExpedienteIdentificacion")));
				expediente.setAforeIdentificacion(this.obtenerValorLinked(linked.get("claveAforeExpIdentificacion"), ExpresionesConstants.VACIO));
				expediente.setDescAforeIdentificacion(this.obtenerValorLinked(linked.get("descAforeExpIdentificacion"), ExpresionesConstants.VACIO));
				expediente.setFechaConformacion(utileriaFecha.convertirLongGregorianoACadena(linked.get("fechaConformacion"), FormatoConstants.FORMATO_FECHA_NACIMIENTO));
				expediente.setExpedienteMovil(this.validarAforeMovil(linked.get("expedienteMovil")));
				expediente.setAforeMovil(this.obtenerValorLinked(linked.get("claveAforeExpMovil"), ExpresionesConstants.VACIO));
				expediente.setDescAforeMovil(this.obtenerValorLinked(linked.get("descAforeExpMovil"), ExpresionesConstants.VACIO));
				expediente.setEstatusEnrolamiento(this.obtenerValorLinked(linked.get("estatusEnrolamiento"), ExpresionesConstants.VACIO));
				expediente.setDescEstatusEnrolamiento(this.validarEstatusEnrolamiento(linked.get("estatusEnrolamiento")));
				expediente.setFechaEnrolamiento(utileriaFecha.convertirLongGregorianoACadena(linked.get("fechaEnrolamiento"), FormatoConstants.FORMATO_FECHA_NACIMIENTO));
				expediente.setAforeEnrolamiento(this.obtenerValorLinked(linked.get("claveAforeExpBiometrico"), ExpresionesConstants.VACIO));
				expediente.setDescAforeEnrolamiento(this.obtenerValorLinked(linked.get("descAforeExpBiometrico"), ExpresionesConstants.VACIO));
				
				expediente.setRol(this.obtenerValorLinked(linked.get("rol"), ExpresionesConstants.VACIO));
				expediente.setDescripcionRol(this.obtenerValorLinked(linked.get("rolCurp"), ExpresionesConstants.VACIO));
				//LA BUSQUEDA DE LOS EXPEDIENTE FUE POR CURP HISTORICA
				expediente.setBanderaCurpHistorica(consultaPorCurpHistorica(linked.get("curpHistoricaConsultada")));
				//CURP POR LA QUE SE CONSULTO LOS EXPEDIENTES
				expediente.setCurpHistorica(this.obtenerValorLinked(linked.get("curpConsultada"), ExpresionesConstants.VACIO));
				//OBTIENE INFORMACION DE LAS HUELLAS
				logger.info("Validando huellas del expediente {} {}", curp, afore);
				expediente = asignarInformacionHuellas(expediente,linked.get("listaHuellas"),curp);
				logger.info("Validando estatus de los expedientes {} {}", curp, afore);
				// EXPEDIENTES IDENTIFICACION
				expediente.setBanderaExpedienteIdentifiacion(obtenerEstatusExpediente(expediente.getEstatusExpedienteIdentificacion()));
				// EXPEDIENTE BIOMENTRICO
				expediente.setBanderaEnrolamiento(obtenerEstatusExpedienteEnrolamiento(expediente.getEstatusEnrolamiento()));
				//FECHA IDENTIFICACION
				expediente.setFechaIDE(obtenerFechaIdentificacion(expediente.getBanderaExpedienteIdentifiacion(),utileriaFecha.convertirLongGregorianoACadena(linked.get("fechaIDE"), FormatoConstants.FORMATO_FECHA_NACIMIENTO)));
				//CALIDAD DE HUELLAS
				logger.info("Obteniendo las mejoras huellas del trabajador {} {}", curp, afore);
				expediente.setDedosCalidad(servicioExpediente.obtenerDedosMejorCalidad(expediente.getHuellasTrabajador(), curp, expediente.getBanderaEnrolamiento()));
				expediente.setImagenHuellas(servicioExpediente.obtenerPDFHuellas(expediente.getHuellasTrabajador(), curp,  expediente.getBanderaEnrolamiento(), expediente.getDedosCalidad()));
				
				logger.info("Se obtiene la validacion de domicilio e identificacion del ocr {} {}", curp, afore);				
				//VALIDACION OCR DOMICILIO
				expediente=obtenerSimilitudDomicilio(expediente,curp, afore);
				//VALIDACION OCR NOMBRE Y ROSTRO
				expediente=obtenerSimilitudIdentificacion(expediente,curp, afore);
				
				expediente.setConsultaExpediente(esExpedienteConsulta(statusExpActual,expediente.getEstatusExpedienteIdentificacion()));
				expediente.setConsultaBiometrico(esExpedienteConsulta(statusExpActual,expediente.getEstatusEnrolamiento()));
				logger.info("Expediente {}", expediente.toString());
			}
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio de expediente {}", curp, e);
		}
 		return expediente;
	}
	
	/**
	 * Expediente de consulta
	 * @param statusExpActual
	 * @param estuasExpediente
	 * @return
	 */
	private boolean esExpedienteConsulta(String statusExpActual,String estuasExpediente) {
		return (!validadorUtilidad.validarObjetoNulo(statusExpActual) && !statusExpActual.equals(estuasExpediente)); 
	}
	
	/**
	 * Obtiene la fecha de identificación
	 * @param banderaExpediente
	 * @param fecha
	 * @return
	 */
	private String obtenerFechaIdentificacion(Integer banderaExpediente, String fecha) {
		return NumerosConstants.INT_CERO == banderaExpediente?"":fecha;
	}
	
	/**
	 * Obtiene el estatus del expediente
	 * @param estatus
	 * @return
	 */
	private Integer obtenerEstatusExpediente(String estatus) {		
		Integer estatusExpediente=NumerosConstants.INT_CERO;//SIN EXPEDIENTE
		if(NumerosConstants.C_CINCO.equals(estatus)) {//PERMANENTE
			estatusExpediente = NumerosConstants.INT_UNO;
		}		
		else if(ServiciosConstants.EXPEDIENTE_INCOMPLETO_TEMPORAL.contains(estatus)) {
			estatusExpediente = NumerosConstants.INT_DOS;
		}
		return estatusExpediente;
	}
	
	/**
	 * Obtiene el estatus del expediente
	 * @param estatus
	 * @return
	 */
	private Integer obtenerEstatusExpedienteEnrolamiento(String estatus) {
		Integer estatusExpediente=NumerosConstants.INT_CERO;//SIN EXPEDIENTE
		String valoresExtras = servicioCatalogo.consultaValorParametro(NumerosConstants.C_DOS, AgenteConstants.PARAMETRO_ENROLAMIENTO_NO_PERMANENTE);//EXPEDIENTES VALIDOS
		if(NumerosConstants.C_CINCO.equals(estatus)) {//PERMANENTE
			estatusExpediente = NumerosConstants.INT_UNO;
		}
		else if(valoresExtras != null && valoresExtras.contains(estatus)) {
			estatusExpediente = NumerosConstants.INT_DOS;
		}
		return estatusExpediente;
	}
	
	/**
	 * Valida si la consulta fue por CURP historica
	 */
	private Integer consultaPorCurpHistorica(Object bandera) {
		Integer consultaCurpHistorica = NumerosConstants.INT_CERO;
		if(!validadorUtilidad.validarObjetoNulo(bandera)) {
			boolean valorBandera = (boolean) bandera;
			consultaCurpHistorica = valorBandera ? NumerosConstants.INT_UNO : NumerosConstants.INT_CERO;
		}
		return consultaCurpHistorica;
	}
	
	/**
	 * Asigna la informacion de huellas
	 * @param expediente
	 * @param linkedLista
	 * @param curp
	 * @return
	 */
	private DatosExpediente asignarInformacionHuellas(DatosExpediente expediente,Object linkedLista,String curp) {
		InfoHuellas infoHuellas =obtenerInfoHuellas( linkedLista, curp);
		expediente.setHuellasTrabajador(infoHuellas.getHuellasTrabajador());
		expediente.setExcepcion(infoHuellas.getExcepcion());
		expediente.setDispositivo(infoHuellas.getDispositivo());
		return expediente;
		
	}
	
	/**
	 * Obtien la informacion de las huellas
	 * @param linkedLista
	 * @param curp
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private InfoHuellas obtenerInfoHuellas(Object linkedLista,String curp) {
		InfoHuellas infoHuellas = new InfoHuellas();
		String dispositivo = null;
		List<DatosHuellas> datosHuellasTrab = null;
		String cuentaConExcepciones = null;
		if(!validadorUtilidad.validarObjetoNulo(linkedLista)) {
			logger.info("Obteniendo huellas del trabajador {}", curp);
			ArrayList<LinkedHashMap<String,	Object>> linkedHuellas = (ArrayList) linkedLista;
			datosHuellasTrab = new ArrayList<>();
			DatosHuellas auxiliarHuellas;
			cuentaConExcepciones = "NO";
			LinkedHashMap<String, Object> objetoAuxiliar;
			for(int i = 0 ; i < linkedHuellas.size(); i++) {
				objetoAuxiliar = linkedHuellas.get(i);
				auxiliarHuellas = new DatosHuellas();
				auxiliarHuellas.setPosicionDedo((Integer) objetoAuxiliar.get("posicionDedo"));
				auxiliarHuellas.setCalidadHuella((Integer) objetoAuxiliar.get("calidadHuella"));
				auxiliarHuellas.setCodigoFaltaDedo((String) objetoAuxiliar.get("codigoFaltaDedo"));
				String motivo = (String) objetoAuxiliar.get("motivoExcepcion");
				auxiliarHuellas.setMotivo(motivo);
				if(!validadorUtilidad.validarObjetoNulo(motivo)) {
					cuentaConExcepciones = "SI";
				}
				auxiliarHuellas.setDescripcionMotivo((String) objetoAuxiliar.get("descripcionMotivo"));
				String auxDispositivo = (String) objetoAuxiliar.get("dispositivo");
				if(!validadorUtilidad.validarObjetoNulo(auxDispositivo)) {
					dispositivo = auxDispositivo;
				}
				datosHuellasTrab.add(auxiliarHuellas);
			}
		}
		infoHuellas.setHuellasTrabajador(datosHuellasTrab);
		infoHuellas.setExcepcion(cuentaConExcepciones);
		logger.info("Resultado de huellas {} {}", curp, infoHuellas.toString());
		infoHuellas.setDispositivo(dispositivo);
		return infoHuellas;
	}
	
	
	/**
	 * Similitud Domicilio
	 * @param expediente
	 * @param afore
	 * @param curp
	 * @return
	 */
	private DatosExpediente obtenerSimilitudDomicilio(DatosExpediente expediente,String curp,String afore) {
		DatosExpediente auxiliarExpediente = expediente;
		auxiliarExpediente.setSimilitudDomicilio(ExpresionesConstants.SIGLAS_NO_APLICA);
		ValidacionDomicilio dom = servicioRespuestas.consultarRespuestaDeepDiveDomicilio(afore, curp, ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS, ServiciosConstants.PROCESO_TIPO_SOLICITANTE_TITULAR);
		if(!validadorUtilidad.validarObjetoNulo(dom)) {
			auxiliarExpediente.setSimilitudDomicilio(this.obtenerValorSimilitud(dom, dom.getSimilitudDomicilio(), dom.getCodigoRespuesta()));
		}
		return auxiliarExpediente;
	}
	
	/**
	 * Similitud Nombre y rostro
	 * @param expediente
	 * @param afore
	 * @param curp
	 * @return
	 */
	private DatosExpediente obtenerSimilitudIdentificacion(DatosExpediente expediente, String curp,String afore) {
		DatosExpediente auxiliarExpediente = expediente;
		auxiliarExpediente.setSimilitudNombre(ExpresionesConstants.SIGLAS_NO_APLICA);
		auxiliarExpediente.setSimilitudRostro(ExpresionesConstants.SIGLAS_NO_APLICA);
		ValidacionIdentificacion iden = servicioRespuestas.consultarRespuestaDeepDiveIdentificacion(afore, curp, ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS, ServiciosConstants.PROCESO_TIPO_SOLICITANTE_TITULAR);
		if(!validadorUtilidad.validarObjetoNulo(iden)) {
			auxiliarExpediente.setSimilitudNombre(this.obtenerValorSimilitud(iden, iden.getSimilitudNombre(), iden.getCodigoRespuesta()));
			auxiliarExpediente.setSimilitudRostro(this.obtenerValorSimilitud(iden, iden.getSimilitudRostro(), iden.getCodigoRespuesta()));
		}
		return auxiliarExpediente;
	}
	
	
	/**
	 * Metodo encargado de obtener el valor de la similitud
	 * 
	 * @param auxObjeto
	 * @param datoPorcentaje
	 * @param codigoRespuesta
	 * @return
	 */
	protected String obtenerValorSimilitud(Object auxObjeto, BigDecimal datoPorcentaje, String codigoRespuesta) {
		String datoSimilitud;
		BigDecimal valor = datoPorcentaje;
		if(validadorUtilidad.validarObjetoNulo(valor)) {
			datoSimilitud = codigoRespuesta;
		} else {
			datoSimilitud = utileriaCadena.obtenerCadenaConcatenada(false, this.redondearDecimales(datoPorcentaje, NumerosConstants.INT_DOS), ExpresionesConstants.SIGNO_PORCENTAJE);
		}
		return datoSimilitud;
	}
	
	/**
	 * Redondeo de decimales de un numero
	 * 
	 * @param valorInicial
	 * @param numeroDecimales
	 * @return
	 */
	public String redondearDecimales(BigDecimal valorInicial, int numeroDecimales) {
		double parteEntera;
		double resultado;
		resultado = valorInicial.doubleValue();
		parteEntera = Math.floor(resultado);
		resultado = (resultado-parteEntera) * Math.pow(10, numeroDecimales);
		resultado = Math.round(resultado);
		resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
		return String.valueOf(resultado);
	}
	
	/**
	 * Metodo encargado de obtener una cadena de un objeto
	 * 
	 * @param objeto
	 * @param valorAuxiliar
	 * @return
	 */
	protected String obtenerValorLinked(Object objeto, String valorAuxiliar) {
		String auxiliar = valorAuxiliar;
		if(!validadorUtilidad.validarObjetoNulo(objeto)) {
			auxiliar = (String) objeto;
		}
		return auxiliar.trim();
	}
	
	/**
	 * Metodo encargado de validar el estatus del expediente
	 * 
	 * @param objetoEstatus
	 * @return
	 */
	private String validarEstatusEnrolamiento(Object objetoEnrolamiento) {
		String valorEnrolamiento = ServiciosConstants.TEXTO_SIN_ENROLAMIENTO;
		try {
			if(!validadorUtilidad.validarObjetoNulo(objetoEnrolamiento)) {
				String estatusExpediente = (String) objetoEnrolamiento;
				if(!ServiciosConstants.VALOR_SERVICIO_00.equals(estatusExpediente)) {
					int value = Integer.parseInt(estatusExpediente);
					String urlEstatus = utileriaCadena.obtenerCadenaConcatenada(true, consultaEstatusExpediente, String.valueOf(value));
					EstatusExpediente resultadoEstatus = clienteServicio.getForObject(urlEstatus, EstatusExpediente.class);
					valorEnrolamiento = validadorUtilidad.validarObjetoNulo(resultadoEstatus) ? ServiciosConstants.TEXTO_SIN_ENROLAMIENTO : resultadoEstatus.getChDescripcionExp().trim();
				}
			}
		} catch(Exception e) {
			logger.error("Error al obtener el estatus del enrolamiento", e);
		}
		return valorEnrolamiento.toUpperCase();
	}
	
	/**
	 * Metodo encargado de validar el estatus del expediente
	 * 
	 * @param objetoEstatus
	 * @return
	 */
	private String validarEstatusExpedienteIdentificacion(Object objetoEstatus) {
		String valorEstatus = ServiciosConstants.TEXTO_SIN_EXPEDIENTE;
		try {
			if(!validadorUtilidad.validarObjetoNulo(objetoEstatus)) {
				String estatusExpediente = (String) objetoEstatus;
				if(!ServiciosConstants.VALOR_SERVICIO_00.equals(estatusExpediente)) {
					int value = Integer.parseInt(estatusExpediente);
					String urlEstatus = utileriaCadena.obtenerCadenaConcatenada(true, consultaEstatusExpediente, String.valueOf(value));
					EstatusExpediente resultadoEstatus = clienteServicio.getForObject(urlEstatus, EstatusExpediente.class);
					valorEstatus = validadorUtilidad.validarObjetoNulo(resultadoEstatus) ? ServiciosConstants.TEXTO_SIN_EXPEDIENTE : resultadoEstatus.getChDescripcionExp().trim();
				}
			}
		} catch(Exception e) {
			logger.error("Error al obtener el estatus del expediente", e);
		}
		return valorEstatus.toUpperCase();
	}
	
	/**
	 * Metodo encargado de obtener la afore
	 * 
	 * @param objetoTipo
	 * @return
	 */
	private String validarAfore(Object objetoTipo) {
		String valorAfore = ServiciosConstants.TEXTO_SIN_TIPOIDE;
		try {
			if(!validadorUtilidad.validarObjetoNulo(objetoTipo)) {
				String claveAfore = (String) objetoTipo;
				String urlAfore = utileriaCadena.obtenerCadenaConcatenada(true, consultaAforeActivo, claveAfore);
				Afore respuestaAfore = clienteServicio.getForObject(urlAfore, Afore.class);
				
				valorAfore = validadorUtilidad.validarObjetoNulo(respuestaAfore) ? ServiciosConstants.TEXTO_SIN_TIPOIDE : respuestaAfore.getDescripcionAfore().trim();
			}
		} catch(Exception e) {
			logger.error("Error al obtener la afore", e);
		}
		return valorAfore.toUpperCase();
	}
	
	/**
	 * Metodo encargado de obtener la afore
	 * 
	 * @param objetoTipo
	 * @return
	 */
	private String validarAforeMovil(Object objetoMovil) {
		String valorMovil = ServiciosConstants.TEXTO_SIN_APP_MOVIL;
		if(!validadorUtilidad.validarObjetoNulo(objetoMovil)) {
			String appMovil = (String)objetoMovil;
			if(!ServiciosConstants.VALOR_SERVICIO_0.equals(appMovil)) {
				valorMovil = ServiciosConstants.TEXTO_CON_APP_MOVIL;
			}
		}
		return valorMovil.toUpperCase();
	}
	
	/**
	 * consultar marca
	 * @param idprocesar
	 * @return consulta marcas;
	 */
	protected List<String> consultarMarca(Long idprocesar) {
		logger.info("Consulta de Marcas {}", idprocesar);
		List<String> marcasTrabajador = new ArrayList<>();
		try {
			StringBuilder marcas = new StringBuilder();
			marcas.append(consultaMarcas);
			marcas.append(idprocesar);
			String marcaResultado = clienteServicio.getForObject(marcas.toString(), String.class);
			
			marcasTrabajador = this.obtenerMarcas(marcaResultado);
		} catch(Exception e) {
			logger.error("Se produjo un error al consulta las marcas del trabajador {} ", idprocesar, e);
		}
		return marcasTrabajador;
	}
	
	/**
	 * Metodo encargado de validar la respuesta de marcas
	 * 
	 * @param marcaResultado
	 * @return
	 */
	private List<String> obtenerMarcas(String marcaResultado) {
		List<String> marcasTrabajador = new ArrayList<>();
		if(!validadorUtilidad.validarVacio(marcaResultado)) {
			JsonUtilsImpl<ParametrosSalidaMarca> utileriaJson = new JsonUtilsImpl<>();
			List<ParametrosSalidaMarca> listaMarcas = utileriaJson.parseJsonToObjectList(marcaResultado, ParametrosSalidaMarca.class);
			if(!validadorUtilidad.validarListaVacia(listaMarcas)) {
				for(ParametrosSalidaMarca marca : listaMarcas) {
					marcasTrabajador.add(marca.getDescripcionProceso());
				}
			}
		}
		return marcasTrabajador;
	}
	
	/**
	 * 
	 * @param curp
	 * @param idProcesar
	 * @return consulta duplicidad de curp
	 */
	public List<String> consultarCurpDuplicada(String curp, Long idProcesar, String claveAfore) {
		List<String> aforesTrabajador = new ArrayList<>();
		try {
			logger.info("Consutla de Curp Duplicada {}", curp);
			if(!validadorUtilidad.validarVacio(curp)) {
				String servicio = utileriaCadena.obtenerCadenaConcatenada(true, consultaCurpDuplicada, curp, ExpresionesConstants.DIAGONAL, String.valueOf(idProcesar));
				CurpDuplicada curpSalida = clienteServicio.getForObject(servicio, CurpDuplicada.class);
				if(!validadorUtilidad.validarObjetoNulo(curpSalida) && ServiciosConstants.RESULTADO_OK.equals(curpSalida.getCodigoOperacion())
						&& !validadorUtilidad.validarListaVacia(curpSalida.getClaveAfore())) {
					aforesTrabajador = this.obtenerValoresCurpDuplicada(curpSalida, claveAfore);
				}
			}
		} catch(Exception e) {
			logger.error("Se produjo un error al consultar las curps duplicadas para el trabajador {} {}", curp, idProcesar, e);
		}
		return aforesTrabajador;
	}
	
	/**
	 * Metodo encargado de obtener los Valores de Curp Duplicada
	 * 
	 * @param curpSalida
	 * @param claveAfore
	 * @return
	 */
	private List<String> obtenerValoresCurpDuplicada(CurpDuplicada curpSalida, String claveAfore) {
		List<String> aforesTrabajador = new ArrayList<>();
		for(String clave : curpSalida.getClaveAfore()) {
			if(!claveAfore.equals(clave)){
				aforesTrabajador.add(this.validarAfore(clave));
			}
		}
		return aforesTrabajador;
	}
	
	/**
	 * Metodo encargado de obtener la imagen del trabajador
	 * 
	 * @param curp
	 * @param claveAfore
	 * @return
	 */
	protected String obtenerImagenTrabajador(String curp, String claveAfore) {
		String valorImagen = ExpresionesConstants.VACIO;
		try {
			logger.info("Se obtiene la imagen del trabajador: {} {}", curp, claveAfore);
			if(!validadorUtilidad.validarVacio(curp)) {
				String servicio = utileriaCadena.obtenerCadenaConcatenada(true, uriFotoPersona, curp, ExpresionesConstants.DIAGONAL, claveAfore, ExpresionesConstants.DIAGONAL, ServiciosConstants.CLAVES_PROCESO_FOTO, ExpresionesConstants.DIAGONAL);
				String imagen = clienteServicio.getForObject(servicio, String.class);
				
				if(!validadorUtilidad.validarObjetoNulo(imagen)) {
					valorImagen = imagen;
				}
			}
		} catch(Exception e) {
			logger.error("Se produjo un error al consultar la imagen del trabajador {} {} {}", curp, claveAfore, ServiciosConstants.CLAVES_PROCESO_FOTO, e);
		}
		return valorImagen;
	}
	
	/**
	 * Metodo encargado de validar lo de kardex
	 * @param datos
	 * @param kardexConsulta
	 * @return
	 */
	private DatosTrabajador obtenerValoresIcefas(DatosTrabajador datos, ConsultarKardexSalida kardexConsulta) {
		logger.info("Se obtienen los valores de indicador retiro, nombre imss, periodo y salario: {}", datos.getDatosCertificables().getCurp());
		DatosTrabajador auxiliar = datos;
		DatosSalariosIcefas salarios = new DatosSalariosIcefas();
		auxiliar.setNombreImss(ExpresionesConstants.VACIO);
		salarios.setListaIcefas(new ArrayList<String>());
		salarios.setPeriodo(ExpresionesConstants.VACIO);
		salarios.setIndicador(NumerosConstants.INT_CERO);
		
		if(!validadorUtilidad.validarObjetoNulo(kardexConsulta)) {
			auxiliar.setNombreImss(utileriaCadena.obtenerContenidoCadenaSinEspacios(kardexConsulta.getNombreImss(), ExpresionesConstants.VACIO));
			salarios = this.obtenerDatosSalarios_Icefas(kardexConsulta, datos.getTipoAfiliacion(), datos.getProcesar());
		} else {
			List<String> salarioPeriodoImss = obtenerPeriodoSalario(kardexConsulta, datos.getTipoAfiliacion(), datos.getProcesar());
			salarios.setPeriodo(salarioPeriodoImss.get(NumerosConstants.INT_CERO));
			salarios.setSalario(salarioPeriodoImss.get(NumerosConstants.INT_UNO));
		}
		
		auxiliar.setSalariosIcefas(salarios);
		return auxiliar;
	}
	
	/**
	 * Obtener Datos de la icefa
	 * 
	 * @param kardexConsulta
	 * @return
	 */
	private DatosSalariosIcefas obtenerDatosSalarios_Icefas(ConsultarKardexSalida kardexConsulta, String tipoAfiliacion, Long idProcesar) {
		DatosSalariosIcefas salarios = new DatosSalariosIcefas();
		
		Integer valorIndicador = NumerosConstants.INT_CERO;
		if(!validadorUtilidad.validarVacio(kardexConsulta.getIndicadorRetiroDesempleo()) && NumerosConstants.C_UNO.equals(kardexConsulta.getIndicadorRetiroDesempleo())) {
			logger.info("Se obtiene el valor del indicador de desempleo {}", kardexConsulta.getIndicadorRetiroDesempleo());
			valorIndicador = NumerosConstants.INT_UNO;
		}
		salarios.setIndicador(valorIndicador);
		
		List<String> datos = this.obtenerPeriodoSalario(kardexConsulta, tipoAfiliacion, idProcesar);
		salarios.setPeriodo(datos.get(NumerosConstants.INT_CERO));
		salarios.setSalario(datos.get(NumerosConstants.INT_UNO));
		salarios.setListaIcefas(new ArrayList<String>());
		if(!validadorUtilidad.validarObjetoNulo(kardexConsulta.getListaIcefasDisponiblesSaldo()) && !validadorUtilidad.validarListaVacia(kardexConsulta.getListaIcefasDisponiblesSaldo().getIcefasDisponible())){
			salarios.setListaIcefas(this.obtenerDescripcionesIcefas(kardexConsulta.getListaIcefasDisponiblesSaldo().getIcefasDisponible()));
		}
		
		return salarios;
	}
	
	/**
	 * Metodo encargado de obtener los periodos y salarios
	 * 
	 * @param kardexConsulta
	 * @param tipoAfiliacion
	 * @param nss
	 * @return
	 */
	private List<String> obtenerPeriodoSalario(ConsultarKardexSalida kardexConsulta, String tipoAfiliacion, Long idProcesar) {
		List<String> valoresConsulta = new ArrayList<>();
		List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_TIPO_AFILIACION, "");
		List<String> valoresImss = validadorUtilidad.obtenerListaParametro(listaParametro, AgenteConstants.TIPO_AFILIACION_IMSS, AgenteConstants.VALOR_AFILIACION_IMSS);
		
		String periodoPago = "";
		String salarioIntegrado = "";
		
		if(valoresImss.contains(tipoAfiliacion)) {
			DatosConsultaSaldos aportacion = this.obtenerSalarioTrabajador(idProcesar);
			if(!validadorUtilidad.validarObjetoNulo(aportacion)) {
				periodoPago = aportacion.getPeriodo();
				salarioIntegrado = String.valueOf(aportacion.getSalario());
			}
		} else if(!validadorUtilidad.validarObjetoNulo(kardexConsulta)) {
			periodoPago = utileriaCadena.obtenerContenidoCadenaSinEspacios(kardexConsulta.getPeriodoPago(), ExpresionesConstants.VACIO);
			salarioIntegrado = utileriaCadena.obtenerContenidoCadenaSinEspacios(kardexConsulta.getSalarioDiarioIntegrado(), ExpresionesConstants.VACIO);
		}
		
		if(validadorUtilidad.validarVacio(salarioIntegrado)) {
			salarioIntegrado = "0.00";
		}
		
		valoresConsulta.add(periodoPago);
		valoresConsulta.add(salarioIntegrado);
		
		return valoresConsulta;
	}
	
	/**
	 * Metodo encargado de obtener el salario de trabajador por nss
	 * 
	 * @param nss
	 * @return
	 */
	private DatosConsultaSaldos obtenerSalarioTrabajador(Long idProcesar) {
		logger.info("Consulta del salario idProcesar :: {}", idProcesar);
		DatosConsultaSaldos aportacion = null;
//		if(!validadorUtilidad.validar(idProcesar)) {
//			String servicio = String.format(urlServicioSalario, idProcesar);
			StringBuilder sb = new StringBuilder(uriComunes).append("factura/consultarfacturaid/").append(idProcesar);
//			String url = utileriaCadena.obtenerCadenaConcatenada(true, uriComunes, servicio);
			try {
				logger.info("Peticion :: {}", sb);
				ResponseEntity<DatosConsultaSaldos> respuesta = clienteServicio.getForEntity(sb.toString(), DatosConsultaSaldos.class);
				logger.info("Respuesta :: {}", respuesta);
				if(!validadorUtilidad.validarObjetoNulo(respuesta.getBody())) {
					aportacion = respuesta.getBody();
				}
			} catch (Exception e) {
				logger.error("Se presento un problema en el servicio de consulta de salario {0}", idProcesar, e);
			}
//		}
		return aportacion;
	}
	
	/**
	 * Metodo encargado de obtener las descripciones de icefas
	 * 
	 * @param icefas
	 * @return
	 */
	protected List<String> obtenerDescripcionesIcefas(List<String> icefas) {
		String clave = ExpresionesConstants.VACIO;
		for(int i = 0; i < icefas.size(); i++) {
			if(i != 0) {
				clave = utileriaCadena.obtenerCadenaConcatenada(true, clave, ExpresionesConstants.COMA);
			}
			clave = utileriaCadena.obtenerCadenaConcatenada(true, clave, icefas.get(i));
		}
		
		List<Icefa> listaIcefas = servicioCatalogo.obtenerIcefa(clave);
		List<String> listaFinal = new ArrayList<>();
		if(!validadorUtilidad.validarListaVacia(listaIcefas)) {
			for(Icefa icefa : listaIcefas) {
				if(!listaFinal.contains(icefa.getDescripcionIcefa())) {
					listaFinal.add(icefa.getDescripcionIcefa());
				}
			}
		}
		return listaFinal;
	}
	
	/**
	 * consultar kardex
	 * @param curp
	 * @param nss
	 * @return informacion de kardex
	 */
	public ConsultarKardexSalida consultarKardex(String claveAfore, String curp, String nss) {
		ConsultarKardexSalida kardexConsulta = null;
		try {
			logger.info("consulta Kardex >>>> {} :: {} :: {}", claveAfore, curp, nss);
			if(!validadorUtilidad.validarVacio(curp)) {
				String urlConsultaKardex = utileriaCadena.obtenerCadenaConcatenada(true, kardexUri, claveAfore, ExpresionesConstants.DIAGONAL, curp);
				logger.info("Se realiza la consulta del kardex: {}", urlConsultaKardex);
				if(!validadorUtilidad.validarVacio(nss)) {
					urlConsultaKardex = utileriaCadena.obtenerCadenaConcatenada(true, urlConsultaKardex, ExpresionesConstants.DIAGONAL, nss);
				}
				
				kardexConsulta = clienteServicio.getForObject(urlConsultaKardex, ConsultarKardexSalida.class);
			}
		}  catch(Exception e) {
			logger.error("Se produjo un error al consultar el kardex del trabajador {} {} {}", curp, claveAfore, nss, e);
		}
		return kardexConsulta;
	}
	
	/**
	 * Validacion de diferencias de Renapo
	 * @param datosRenapo
	 * @param nombreTrabajador
	 * @return
	 */
	protected Integer validarNombreRenapo_Curp(String nombre, String nombreTrabajador, int tipo) {
		Integer valor = NumerosConstants.INT_CERO;
		try {
			logger.info("Validando datos de renapo distinto {} {} {}", tipo, nombre, nombreTrabajador);
			String paramCaracter = AgenteConstants.CARACTER_HOMOLOGADO;
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
			String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;
			if(!validadorUtilidad.validarListaVacia(listaParametro)) {
				caracterHomologado = listaParametro.get(NumerosConstants.INT_CERO).getChValorParametro();
			}
			
			utileriaCadena.validarCadenasIguales(nombreTrabajador, nombre, BusinessErrorEnum.DIFERENCIAS_RENAPO, caracterHomologado);
		} catch (BusinessException be) {
			logger.error("Datos de renapo o imss distinto {} {} {}", tipo, nombre, nombreTrabajador, be);
			valor = NumerosConstants.INT_UNO;
		}
		return valor;
	}
	
	/**
	 * Metodo encargaso de consultar datos de renapo por medio de curp
	 * @param curp
	 * @return
	 */
	protected CURPStruct obtenerDatosCurp(String curp){
		logger.info("Se obtienen datos de curp trabajador");
		CURPStruct renapo = null;
		try{
			if(!validadorUtilidad.validarVacio(curp)) {
				String urlRenapo = utileriaCadena.obtenerCadenaConcatenada(true, uriRenapo, curp); 
				renapo = clienteServicio.getForObject(urlRenapo, CURPStruct.class);
			}
		}catch(Exception e){
			logger.error("Se ha presentado un fallo al consultar datos renapo", e);
		}
		return renapo;
		
	}
	/**
	 * Metodo encarga de obtener datos de renapo
	 * @param curp
	 * @return
	 */
	@Override
	public Renapo obtenerDatosRenapo(DatosTrabajador trabajador){
		logger.info("Inicio se obtienen datos de renapo {}", trabajador.getDatosCertificables().getCurp());
		logger.info(">>Curp: " + trabajador.getDatosCertificables().getCurp());
		logger.info(">>NombreTrabajador:  "  + trabajador.getNombreTrabajador());
		logger.info(">>Sexo: " + trabajador.getDatosCertificables().getGenero());
		logger.info(">>FechaNacimiento:  " + trabajador.getDatosCertificables().getFechaNacimiento());
		logger.info(">>EntidadNacimiento: " + trabajador.getDatosCertificables().getEntidadNacimiento());
		
		CURPStruct datos = null;
		Renapo renapo = new Renapo();
			renapo.setNombre(ExpresionesConstants.VACIO);
			renapo.setApellidoPaterno(ExpresionesConstants.VACIO);
			renapo.setApellidoMaterno(ExpresionesConstants.VACIO);
			renapo.setCurp(ExpresionesConstants.VACIO);
			renapo.setFechaNacmiento(ExpresionesConstants.VACIO);
			renapo.setEntidadNacimiento(ExpresionesConstants.VACIO);
			renapo.setSexo(ExpresionesConstants.VACIO);
			renapo.setCurpsHistoricas(ExpresionesConstants.VACIO);
			renapo.setNacionalidad(ExpresionesConstants.VACIO);
		try{
			datos = this.obtenerDatosCurp(trabajador.getDatosCertificables().getCurp());
			if(!validadorUtilidad.validarObjetoNulo(datos)) {
				renapo.setNombre(datos.getNombres());
				renapo.setApellidoPaterno(datos.getApellido1());
				renapo.setApellidoMaterno(datos.getApellido2());
				renapo.setCurp(datos.getCurp());
				renapo.setNacionalidad(datos.getNacionalidad());
				Date auxiliarFecha = utileriaFecha.convertirCadenaAFecha(datos.getFechNac(), FormatoConstants.FORMATO_FECHA_RENAPO);
				String fechaNacimientoRenapo = utileriaFecha.convertirFechaACadena(auxiliarFecha, FormatoConstants.FORMATO_FECHA_NACIMIENTO);
				renapo.setFechaNacmiento(fechaNacimientoRenapo);
				renapo.setCveEntidadNacimiento(datos.getCveEntidadNac());
				EntidadFederativa entidad = this.obtenerEntidad(datos.getCveEntidadNac());
				renapo.setEntidadNacimiento(validadorUtilidad.validarObjetoNulo(entidad) ? ExpresionesConstants.VACIO : entidad.getDescripcion());
				GeneroEnum genero = GeneroEnum.obtenerGenero(utileriaCadena.obtenerContenidoCadenaSinEspacios(datos.getSexo(), ExpresionesConstants.VACIO));
				renapo.setSexo(genero.getDscripcion());
				String nombreRenapo = utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(datos.getNombres(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
						utileriaCadena.obtenerContenidoCadenaSinEspacios(datos.getApellido1(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
						utileriaCadena.obtenerContenidoCadenaSinEspacios(datos.getApellido2(), ExpresionesConstants.VACIO));
				renapo.setBanderaNombre(this.validarNombreRenapo_Curp(nombreRenapo, trabajador.getNombreTrabajador(), NumerosConstants.INT_UNO));
				renapo.setBanderaCurp(this.validarNombreRenapo_Curp(datos.getCurp(), trabajador.getDatosCertificables().getCurp(), NumerosConstants.INT_DOS));
				renapo.setBanderaGenero(this.validarNombreRenapo_Curp(renapo.getSexo(),trabajador.getDatosCertificables().getGenero(), NumerosConstants.INT_TRES));
				renapo.setBanderaFechaNacimiento(this.validarNombreRenapo_Curp(renapo.getFechaNacmiento(), trabajador.getDatosCertificables().getFechaNacimiento(), NumerosConstants.INT_CUATRO));
				renapo.setBanderaEntidadNacimiento(this.validarNombreRenapo_Curp(renapo.getEntidadNacimiento(), trabajador.getDatosCertificables().getEntidadNacimiento(), NumerosConstants.INT_CINCO));
				if(!validadorUtilidad.validarObjetoNulo(datos.getCurpHistoricas()) && datos.getCurpHistoricas().length > 0) {
					renapo.setListaCurpHistoricas(Arrays.asList(datos.getCurpHistoricas()));
				}
			}
		}catch(Exception e){
			logger.error("Se ha presentado un fallo al cnsultar datos renapo", e);
		}
		
		return renapo;
	}
	
	/**
	 * Metodo encargado de obtener datos de entidad federativa
	 * @param claveCorta
	 * @return
	 */
	private EntidadFederativa obtenerEntidad(String claveCorta) {
		EntidadFederativa entidad = null;
		logger.info("Se obtienen datos de entidad federativa {}", claveCorta);
		try{
			String urlEntidad = utileriaCadena.obtenerCadenaConcatenada(true,consultarEntidad, claveCorta);
			entidad = clienteServicio.getForObject(urlEntidad, EntidadFederativa.class);
		}catch(Exception e){
			logger.error("Ocurrio un error al consultar la entidad {}", claveCorta, e);
		}
		return entidad;
	}
	
	/**
	 * Validar expediente por medio de tipo solicitante
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public DatosExpediente validarExpedienteTipoSolicitante(String curp, String cveAfore, String tipoSolicitante, String curpAgente) { 
    	DatosExpediente expediente = null;
		try {
	    	String url = utileriaCadena.obtenerCadenaConcatenada(true, consultaExpediente, curp, "/", cveAfore, "/", tipoSolicitante);
	    	logger.error("Peticion validarExpedienteTipoSolicitante:::: {}", url);
			SalidaGenerica expedienteResultado = clienteServicio.getForObject(url, SalidaGenerica.class);
			logger.error("La respuesta de validarExpedienteTipoSolicitante {} ", expedienteResultado.getResponse());
			SalidaGenerica salida = new SalidaGenerica();
			salida.setMensaje(expedienteResultado.getMensaje());
			LinkedHashMap<String, Object> linked =(LinkedHashMap<String, Object>) expedienteResultado.getResponse();
			
			expediente = new DatosExpediente();
			expediente.setEstatusExpedienteIdentificacion(this.obtenerValorLinked(linked.get("estatusExpedienteIdentificacion"), ExpresionesConstants.VACIO));
			expediente.setDescEstatusExpedienteIdentificacion(this.validarEstatusExpedienteIdentificacion(linked.get("estatusExpedienteIdentificacion")));
			expediente.setAforeIdentificacion(this.obtenerValorLinked(linked.get("claveAforeExpIdentificacion"), ExpresionesConstants.VACIO));
			expediente.setDescAforeIdentificacion(this.obtenerValorLinked(linked.get("descAforeExpIdentificacion"), ExpresionesConstants.VACIO));
			expediente.setFechaIDE(utileriaFecha.convertirLongGregorianoACadena(linked.get("fechaIDE"), FormatoConstants.FORMATO_FECHA_NACIMIENTO));
			expediente.setFechaConformacion(utileriaFecha.convertirLongGregorianoACadena(linked.get("fechaConformacion"), FormatoConstants.FORMATO_FECHA_NACIMIENTO));
			expediente.setExpedienteMovil(this.validarAforeMovil(linked.get("expedienteMovil")));
			expediente.setAforeMovil(this.obtenerValorLinked(linked.get("claveAforeExpMovil"), ExpresionesConstants.VACIO));
			expediente.setDescAforeMovil(this.obtenerValorLinked(linked.get("descAforeExpMovil"), ExpresionesConstants.VACIO));
			expediente.setEstatusEnrolamiento(this.obtenerValorLinked(linked.get("estatusEnrolamiento"), ExpresionesConstants.VACIO));
			expediente.setDescEstatusEnrolamiento(this.validarEstatusEnrolamiento(linked.get("estatusEnrolamiento")));
			Object linkedLista = linked.get("listaHuellas");
			if(!validadorUtilidad.validarObjetoNulo(linkedLista)) {
				ArrayList<LinkedHashMap<String,	Object>> linkedHuellas = (ArrayList) linkedLista;
				List<DatosHuellas> datosHuellasTrab = new ArrayList<>();
				DatosHuellas auxiliarHuellas;
				LinkedHashMap<String, Object> objetoAuxiliar;
				for(int i = 0 ; i < linkedHuellas.size(); i++) {
					objetoAuxiliar = linkedHuellas.get(i);
					auxiliarHuellas = new DatosHuellas();
					auxiliarHuellas.setPosicionDedo((Integer) objetoAuxiliar.get("posicionDedo"));
					auxiliarHuellas.setCalidadHuella((Integer) objetoAuxiliar.get("calidadHuella"));
					datosHuellasTrab.add(auxiliarHuellas);
				}
				expediente.setHuellasTrabajador(datosHuellasTrab);
			}
			expediente.setFechaEnrolamiento(utileriaFecha.convertirLongGregorianoACadena(linked.get("fechaEnrolamiento"), FormatoConstants.FORMATO_FECHA_NACIMIENTO));
			expediente.setAforeEnrolamiento(this.obtenerValorLinked(linked.get("claveAforeExpBiometrico"), ExpresionesConstants.VACIO));
			expediente.setDescAforeEnrolamiento(this.obtenerValorLinked(linked.get("descAforeExpBiometrico"), ExpresionesConstants.VACIO));
			Object bandera = linked.get("curpHistoricaConsultada");
			if(!validadorUtilidad.validarObjetoNulo(bandera)) {
				boolean valorBandera = (boolean) bandera;
				expediente.setBanderaCurpHistorica(valorBandera ? NumerosConstants.INT_UNO : NumerosConstants.INT_CERO);
			}
			expediente.setCurpHistorica(this.obtenerValorLinked(linked.get("curpConsultada"), ExpresionesConstants.VACIO));
			
			Integer estatusExpediente = NumerosConstants.INT_CERO;
			Integer estatusEnrolamiento = NumerosConstants.INT_CERO;
			
			if(ServiciosConstants.TEXTO_PERMANENTE.equals(expediente.getDescEstatusExpedienteIdentificacion())) {
				estatusExpediente = NumerosConstants.INT_UNO;
			}
			
			if(ServiciosConstants.TEXTO_PERMANENTE.equals(expediente.getDescEstatusEnrolamiento())) {
				estatusEnrolamiento = NumerosConstants.INT_UNO;
			}
			expediente.setBanderaExpedienteIdentifiacion(estatusExpediente);
			expediente.setBanderaEnrolamiento(estatusEnrolamiento);
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio de validacion expediente por tipoSolicitante{}", curp, e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return expediente;
    }

	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPersonaCertificablesService#validarDatosTrabajador(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta)
	 * @Author: Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Sep 19, 2019
	 */
	@Override
	public List<PersonaSalida> validarDatosTrabajador(EntradaConsulta datosEntrada) {
		String solicitud = this.obtenerUrlConsultaCurpNss(datosEntrada);
		String respuestaPersona = this.invocarServicioConsultaListaPersona(solicitud, datosEntrada);
		if(validadorUtilidad.isEmpty(respuestaPersona)) {
			throw new BusinessException(BusinessErrorEnum.TRABAJADOR_NO_ENCONTRADO);
		}
		logger.error("Log-Se obtuvo respuesta de la consulta del trabajador {} {}", datosEntrada.getNss(), datosEntrada.getCurp());
		JsonUtilsImpl<PersonaSalida> utileriaJson = new JsonUtilsImpl<>();
		return utileriaJson.parseJsonToObjectList(respuestaPersona, PersonaSalida.class);
	}

	/**
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Nov 4, 2019
	 * @param datosEntrada
	 * @return
	 */
	private String obtenerUrlConsultaCurpNss(EntradaConsulta datosEntrada) {
		String solicitud = consultaPersonaCurpNss;
		logger.error("Log-La url de la solicitud es: {}",solicitud);
			if(!validadorUtilidad.validarVacio(datosEntrada.getCurp())) {
				solicitud = utileriaCadena.obtenerCadenaConcatenada(true, solicitud, ServiciosConstants.DIAGONAL_CURP, datosEntrada.getCurp());
			}
			if (!validadorUtilidad.validarVacio(datosEntrada.getNss())) {
				solicitud = utileriaCadena.obtenerCadenaConcatenada(true, solicitud, ServiciosConstants.DIAGONAL_NSS, datosEntrada.getNss());
			}
			logger.error("Log-La url final de la solicitud es: {}",solicitud);
		return solicitud;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerParametroAforesModificacion() {
		String valorParametro = null;
		List<Parametro> parametroAfores = servicioCatalogo.obtenerParametroDdbpose("P00017", "P00017");
		if(!validadorUtilidad.isEmpty(parametroAfores)) {
			 valorParametro = parametroAfores.get(0).getChValorParametro();
		}
		return valorParametro;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validarExpedienteEnrolamiento(String curp) {
		boolean isSolicitarEnrolamiento = false;
		if(!validadorUtilidad.validarVacio(curp)) {
			StringBuilder estatusEnrolamiento = new StringBuilder();
			String valoresExtras = servicioCatalogo.consultaValorParametro(NumerosConstants.C_DOS, AgenteConstants.PARAMETRO_ENROLAMIENTO_NO_PERMANENTE);
			estatusEnrolamiento.append(valoresExtras);
			estatusEnrolamiento.append(",5");
			ExpedienteDetail expediente = expedienteService.consultarExpedienteProcesoSinAfore(curp, ArchivosEnum.EXPEDIENTE_BIOMETRICO.getNombreArchivo(), estatusEnrolamiento.toString());
			ExpedienteDetail expedienteBatch = expedienteService.consultarExpedienteProcesoSinAfore(curp, ArchivosEnum.EXPEDIENTE_BIOMETRICO_BATCH.getNombreArchivo(), estatusEnrolamiento.toString());
			if(expediente != null || expedienteBatch != null) {
				isSolicitarEnrolamiento = true;
			}
		}
		return isSolicitarEnrolamiento;
	}
}