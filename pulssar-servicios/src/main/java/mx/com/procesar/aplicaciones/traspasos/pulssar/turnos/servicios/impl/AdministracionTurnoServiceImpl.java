package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.emptyToNull;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.CLAVE_PARAMETRO_ADMINISTRACION_TURNOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_CON_CITA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_CON_CITA_PREAVISO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_SIN_CITA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_SIN_CITA_PREAVISO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.ESTATUS_ROL_EN_ATENCION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.PAGINA_REGISTRO_CON_LIMITE_TIEMPO_EN_ESPERA_MAYOR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.PAGINA_REGISTRO_SIN_LIMITE_TIEMPO_EN_ESPERA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.PAGINA_REGISTRO_URL_REFERENCIA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.PRIMER_ELEMENTO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.RELACION_COLOR_REGISTRO_REGISTRO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.TIPO_CON_CITA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.TIPO_DE_CITAS_EXISTENTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.TIPO_SIN_CITA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.ERROR_NEGOCIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.EXITOSO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum.ERROR_ADMINISTRACION_TURNO_EN_ATENCION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum.ERROR_TURNO_NO_ASIGANADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum.EXCEPTION_GENERICA;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoValidaCitaEsar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Turno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ZonaHoraSucursal;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.TurnoRegistrado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.TurnoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ZonaHoraSucursalRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarPersonaCertificablesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AdministracionTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CitaNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PersonaSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAdministracionTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.builder.RespuestaAdministracionTurnoBuilder;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.RespuestaUtilsImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.AdministracionTurnoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.CitaAgendaService;

/**
 * <p>
 * Implementa los servicios para <b>Administración de Turnos</b>.
 * </p>
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
@Service
public class AdministracionTurnoServiceImpl implements AdministracionTurnoService {

	/**
	 * Logger para el servicio para la <b>Administración de Turnos</b>. 
	 */
	private static final Logger LOG = LoggerFactory.getLogger(AdministracionTurnoServiceImpl.class);
	
	/**
	 * Servicio para el manejo de catalogos.
	 */
	@Autowired
	private CatalogoService catalogoService;
	
	/**
	 * Utileria para el manejo de fechas.
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	/**
	 * Utileria para el manejo de vaalidaciones.
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	
	/**
	 * Repositorio para las operaciones sobre <b>Administración de Turnos</b>.
	 */
	@Autowired
	private TurnoRepository turnoRepository;
	
	/**
	 * Inyeccion del servicio de ConsultarPersonaCertificablesService
	 */
	@Autowired
	private ConsultarPersonaCertificablesService personaService;
	
	/**
	 * Servicio que expone las operaciones de consulta para el Usuario.
	 */
	@Autowired
	private CusService cusService;
	
	/**
	 * Servicio encargado de las operacionees con la cita agendada.
	 */
	@Autowired
	private CitaAgendaService citaAgendaService;
	
	/**
	 * Inyeccion de servicio de rechazo
	 */
	@Autowired
	RechazoService rechazoService;
	
	/**
	 * Inyeccion de servicio de respuesta
	 */
	@Autowired
	RespuestaUtilsImpl respuestaUtils;
	
	/**
	 * Repositorio para las operaciones sobre <b>Administración de Turnos</b>.
	 */
	@Autowired
	private ZonaHoraSucursalRepository zonaHoraSucursalRepository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Respuesta construirRespuestaTurnosRegistrados(final String claveOrgaizacion,
			final Long idUsuario, final String sucursal) {
		
		// Validacion de los parametros obligatorios.
		final String claveOrganizacionLocal = checkNotNull(emptyToNull(claveOrgaizacion), "La organización / Afore es requerido");
		final Long identificadorUsuarioEnSesion      = checkNotNull(idUsuario, "La usuario es requerido");
		final String sucursalLocal          = checkNotNull(emptyToNull(sucursal), "La sucursal es requerido");
		
		Respuesta respuesta = new Respuesta();
		RespuestaAdministracionTurnoBuilder citasBuilder = new RespuestaAdministracionTurnoBuilder();
		boolean indicadorTurnoEnAtencion = Boolean.FALSE;
		
			
		final String limiteEnMinutosDeTurnoConCita = obtenerValorParamtro(CLAVE_PARAMETRO_ADMINISTRACION_TURNOS, DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_CON_CITA);
		final String limiteEnMinutosDeTurnoSinCita = obtenerValorParamtro(CLAVE_PARAMETRO_ADMINISTRACION_TURNOS, DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_SIN_CITA);
		
		final String indicadorEnMinutosPreavisoTurnoConCita = obtenerValorParamtro(CLAVE_PARAMETRO_ADMINISTRACION_TURNOS, DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_CON_CITA_PREAVISO);
	    final String indicadorEnMinutosPreavisoTurnoSinCita = obtenerValorParamtro(CLAVE_PARAMETRO_ADMINISTRACION_TURNOS, DESCRIPCION_PARAMETRO_LIMITE_MINUTOS_DE_TURNO_SIN_CITA_PREAVISO);
		

		indicadorTurnoEnAtencion = validarUsuarioConTurnoEnAtencion(identificadorUsuarioEnSesion);
		
		if(indicadorTurnoEnAtencion) {
			respuesta = construirRespuesta(ERROR_ADMINISTRACION_TURNO_EN_ATENCION.getClave(), claveOrganizacionLocal);
		}
	    
		final List<TurnoRegistrado> turnosConCita = buscarTurnosRegistrados(TIPO_CON_CITA,  sucursalLocal);
		final List<TurnoRegistrado> turnosSinCita = buscarTurnosRegistrados(TIPO_SIN_CITA,  sucursalLocal);
		
		citasBuilder.limiteEnMinutosDeTurnoConCita(limiteEnMinutosDeTurnoConCita)
				.limiteEnMinutosDeTurnoSinCita(limiteEnMinutosDeTurnoSinCita)
				.turnosConCita(turnosConCita).turnosSinCita(turnosSinCita)
				.indicadorEnMinutosPreavisoTurnoConCita(indicadorEnMinutosPreavisoTurnoConCita)
				.indicadorEnMinutosPreavisoTurnoSinCita(indicadorEnMinutosPreavisoTurnoSinCita);
		
		RespuestaAdministracionTurno respuestaAdministracion = citasBuilder.build();
		agregarMetaInformacionEnTablas(respuestaAdministracion , indicadorTurnoEnAtencion);
		
		respuesta.setObjetoRespuesta(respuestaAdministracion);
		respuesta.setFlujo(EXITOSO.getClave());
		
		return respuesta;
		
	}
	
	/**
	 * {@inheritDoc}
	 * @param indicadorTurnoEnAtencion 
	 */
	@Override
	public List<TurnoRegistrado> buscarTurnosRegistrados(final String tipoCita,
			final String numeroSucursal) {
		
		// Valida la obligatoridad de los campos.
		checkNotNull(emptyToNull(tipoCita), "El campo Tipo de Cita es obligatorio");
		checkNotNull(numeroSucursal,        "El campo Numero de Sucursal de Registro es obligatorio");
		checkArgument(TIPO_DE_CITAS_EXISTENTE.contains(tipoCita), "El tipo de cita es invalido");
		
		Calendar hoy = GregorianCalendar.getInstance();
		
		Date diaConHoraInicial = fechaUtils.actualizarHoraInicio(hoy.getTime());
		List<TurnoRegistrado> respuesta = turnoRepository.buscarTurnosRegistradosPorFechaRegistoYTipoCitaYSucursal(tipoCita,
				diaConHoraInicial, numeroSucursal);
		
		LOG.debug("Turnos encontrados: {}", respuesta.size());
		
		return respuesta;
	}
	
	/**
	 * <p>
	 * Obtiene el valor del parámetro a través de su clave.
	 * </p>
	 * 
	 * @param clave Clave para el parámetro a buscar.
	 * @param descripcion Descripción del parámetro a buscar.
	 * 
	 * @return El valor del parametro encontrado.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private String obtenerValorParamtro(final String clave, final String descripcion) {

		checkNotNull(emptyToNull(clave),       "El campo Clave Parametro es obligatorio");
		checkNotNull(emptyToNull(descripcion), "El campo Descripcion Parametro es obligatorio");

		final List<Parametro> parametros = catalogoService.obtenerParametroDdbpose(clave, descripcion);

		if (parametros.isEmpty()) {

			throw new GenericException(EXCEPTION_GENERICA,
					String.format("El parametro con clave %s y descripcio %s inexistente", 
							clave, descripcion));
		}

		return parametros.get(PRIMER_ELEMENTO).getChValorParametro();
	}
	
	/**
	 * Agrega la meta información necesaria para mostrar colores, urls en los
	 * campos referentes a los cuadros.
	 * 
	 * @param respuesta Respuesta de los Turnos Registrados.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 * @param indicadorTurnoEnAtencion 
	 */
	private void agregarMetaInformacionEnTablas(final RespuestaAdministracionTurno respuesta,
			final boolean indicadorTurnoEnAtencion) {
		
		
		final Long limiteEnMinutosDeTurnoConCita = Long.valueOf(checkNotNull(respuesta.getLimiteEnMinutosDeTurnoConCita()));
		final Long limiteEnMinutosDeTurnoSinCita = Long.valueOf(checkNotNull(respuesta.getLimiteEnMinutosDeTurnoSinCita()));
		
		final Long indicadorEnMinutosPreavisoTurnoConCita = Long.valueOf(checkNotNull(respuesta.getIndicadorEnMinutosPreavisoTurnoConCita()));
		final Long indicadorEnMinutosPreavisoTurnoSinCita = Long.valueOf(checkNotNull(respuesta.getIndicadorEnMinutosPreavisoTurnoSinCita()));
		
		checkArgument(limiteEnMinutosDeTurnoConCita >= indicadorEnMinutosPreavisoTurnoConCita, "Los minutos deben ser mayor al preaviso para los registros con cita");
		checkArgument(limiteEnMinutosDeTurnoSinCita >= indicadorEnMinutosPreavisoTurnoSinCita, "Los minutos deben ser mayor al preaviso para los registros sin cita");
		
		final Long limiteRealEnMinutosDeTurnoConCita = limiteEnMinutosDeTurnoConCita - indicadorEnMinutosPreavisoTurnoConCita;
		final Long limiteRealEnMinutosDeTurnoSinCita = limiteEnMinutosDeTurnoSinCita - indicadorEnMinutosPreavisoTurnoSinCita;
		
		final List<TurnoRegistrado> informacionTablaConCita = generarMetaInformacionParaRegistroDePagina(
				respuesta.getTurnosConCita(), limiteRealEnMinutosDeTurnoConCita, indicadorTurnoEnAtencion);
		final List<TurnoRegistrado> informacionTablaSinCita = generarMetaInformacionParaRegistroDePagina(
				respuesta.getTurnosSinCita(), limiteRealEnMinutosDeTurnoSinCita, indicadorTurnoEnAtencion);
		
		respuesta.setTurnosConCita(informacionTablaConCita);
		respuesta.setTurnosSinCita(informacionTablaSinCita);
	}
	
	/**
	 * Permite generar la meta información por registro y de la pantalla como
	 * por ejemplo la URL y los colores con los que se deberan de mostrar el
	 * texto para el registro.
	 * 
	 * @param turnosParaTransformar
	 *            Lista base con la cual se le anexará la información
	 * @param timpoLimiteEnEspera
	 *            Tiempo limiete en la que clente debera estar en espera
	 * @return Una lista con la información con los meta información requerida
	 *         para la pantalla.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 * @param indicadorTurnoEnAtencion 
	 */
	private List<TurnoRegistrado> generarMetaInformacionParaRegistroDePagina(
			final List<TurnoRegistrado> turnosParaTransformar, final Long timpoLimiteEnEspera, final boolean indicadorTurnoEnAtencion) {
		
		return Lists.newArrayList(
				Collections2.transform(turnosParaTransformar, new Function<TurnoRegistrado, TurnoRegistrado>() {

					private int contador = 1;
					
					@Override
					public TurnoRegistrado apply(TurnoRegistrado turno) {
						
						TurnoRegistrado nuevoElemento = new TurnoRegistrado();
						nuevoElemento.setFolioServicio(turno.getFolioServicio());
						nuevoElemento.setNombreTrabajador(turno.getNombreTrabajador());
						nuevoElemento.setHorasEspera(turno.getHorasEspera());
						Integer v= Integer.parseInt(turno.getMinutosEspera()) > 0 ? Integer.parseInt(turno.getMinutosEspera()): 0;			
						nuevoElemento.setMinutosEspera(v.toString());
						nuevoElemento.setHoraRegistro(turno.getHoraRegistro());
						nuevoElemento.setAutorizadoCss(indicadorTurnoEnAtencion? "": "autorizado");
						
						// Generación para la información para la pagina
						final double minutosTranscurridosDesdeRegistro = Double.valueOf(turno.getMinutosEspera());
						final double minutosLimiteDelRegistro = Double.valueOf(timpoLimiteEnEspera);
						final String FolioDeAtencion = turno.getFolioServicio();
						
						final String estiloClass = minutosTranscurridosDesdeRegistro < minutosLimiteDelRegistro
								? PAGINA_REGISTRO_CON_LIMITE_TIEMPO_EN_ESPERA_MAYOR
								: PAGINA_REGISTRO_SIN_LIMITE_TIEMPO_EN_ESPERA;
						final String url = new StringBuilder(PAGINA_REGISTRO_URL_REFERENCIA).append(FolioDeAtencion).toString();
						nuevoElemento.setEstiloCss(estiloClass);
						nuevoElemento.setEstiloRegistroCss(RELACION_COLOR_REGISTRO_REGISTRO.get(contador++ % 2));
						nuevoElemento.setUrl(url);
						
						return nuevoElemento;
					}
				})
			);
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.AdministracionTurnoService#validarDatosCita(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AdministracionTurno)
	 */
	@Override
	public AdministracionTurno validarDatosCita(AdministracionTurno asgTurno) {
		AdministracionTurno respuesta = new AdministracionTurno();
		ConsultaCusSalida salidaCus = null;
		LOG.error("Entro a validarDatosCita los datos son: {} \n", asgTurno);
		if (!validadorUtils.isEmpty(asgTurno.getCus())) {
			
			salidaCus = cusService.consultaCus(asgTurno.getCurp(), Long.parseLong(asgTurno.getCus()), TurnoConstants.ESTATUS_UNO);
			
			// Obtiene el numero completo de la sucursal. Éste se compone de clave de la afore
			// más el numero de la sucursal.
			if(validadorUtils.isEmpty(salidaCus.getRespuesta()) || !TurnoConstants.CODIGO_EXITOSO.equals(salidaCus.getCodigo()) ) {
				throw new BusinessException(BusinessErrorEnum.CUS_NO_ENCONTRADO);
			}
			String idServicio = salidaCus.getRespuesta().get(TurnoConstants.CONSTANTE_TIPO_SERVICIO)
					.substring(salidaCus.getRespuesta().get(TurnoConstants.CONSTANTE_TIPO_SERVICIO).length()-2, 
							salidaCus.getRespuesta().get(TurnoConstants.CONSTANTE_TIPO_SERVICIO).length());
			if (TurnoConstants.CLAVE_TIPO_SERVICIO_03.equals(idServicio)) {
				idServicio = TurnoConstants.CLAVE_TIPO_SERVICIO_02;
			}
			
			List<CitaNotificacion> citaSalida = validarCitaVigente(idServicio, asgTurno);
			
			if (!validadorUtils.isEmpty(citaSalida)) {
				asgTurno.setCurp(validarCusCurp(salidaCus.getRespuesta().get(TurnoConstants.CONSTANTE_CURP), citaSalida));
				respuesta = obtenerDatosTrabajador(asgTurno, salidaCus, citaSalida.get(0), TurnoConstants.FLAG_TIPO_CITA);
				respuesta.setFechaCitaCusTexto(
						fechaUtils.convertirFechaACadena(respuesta.getFechaCitaCus(), FormatoConstants.FORMATO_SERVICIO_FOLIO)
					);
			}else{
				throw new BusinessException(BusinessErrorEnum.CITA_NO_ENCONTRADO);
			}
		}else if(!validadorUtils.isEmpty(asgTurno.getCurp()) || !validadorUtils.isEmpty(asgTurno.getNss())){
			respuesta = obtenerDatosTrabajador(asgTurno, null, null, TurnoConstants.FLAG_TIPO_SIN_CITA);
			
		}else{
			respuesta.setIndicadorTipoCita(TurnoConstants.FLAG_TIPO_SIN_DATOS_CITA);
		}	
		
		return respuesta;
	}

	/**
	 * MEtodo para validar la curp asociada a la cus
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Apr 22, 2020
	 * @param curp
	 * @param citaSalida
	 * @return
	 */
	private String validarCusCurp(String curp, List<CitaNotificacion> citaSalida) {
		LOG.error("Validacion de la curp asociada a la cus: : Curp: {}, List: {} ",curp, citaSalida );
		String curpAsociada = curp;
		for (CitaNotificacion citaNotificacion : citaSalida) {
			LOG.error("Se valida : curp: {}, lstCurp: {}", curp, citaNotificacion.getCurp());
				if (citaNotificacion.getCurp().equals(curp)) {
					return curpAsociada;
				}
			}
		
		throw new BusinessException(BusinessErrorEnum.CITA_NO_ENCONTRADO);
	}

	/**
	 * Metodo que realiza el filtro de los datos para validar el servicio y la fecha 
	 * @return
	 */
	protected List<CitaNotificacion> validarCitaVigente(final String idServicio, AdministracionTurno turno) {
		final String sucursal = turno.getNumeroSucursal();
		turno.setNumeroSucursal(new StringBuilder(turno.getClaveOrganizacion()).append("-")
				.append(turno.getNumeroSucursal()).toString());
		List<CitaNotificacion> citaSalida = citaAgendaService.obtenerDatosCita(turno.getNumeroSucursal());
		LOG.error("Log-Los datos de la Cita del Dia son: {}", citaSalida);
		LOG.error("Log-Los datos de la Turno a comparar son: servicio {}, turno: {}", idServicio, turno);
		List<CitaNotificacion> respuestaCita = null;
		if (!validadorUtils.isEmpty(citaSalida)) {
			respuestaCita = Lists.newArrayList(
					Iterables.filter(citaSalida, new Predicate<CitaNotificacion>() {
						@Override
						public boolean apply(CitaNotificacion cita) {
							LOG.error("\n validacion de servicio: {}", StringUtils.equals(cita.getIdentificadorServicio(),idServicio));
							LOG.error("\n validacion de idSucursal: {}", StringUtils.equals(cita.getIdentificadorSucursal(), sucursal));
							LOG.error("\n validacion de fecha inicio cita: {}, fechahora actual: {} \n fecha After es: {}", cita.getFechaInicio(), getFechaHoraAnticipacion(sucursal), cita.getFechaInicio().after(getFechaHoraAnticipacion(sucursal)));
							return StringUtils.equals(cita.getIdentificadorServicio(),idServicio) && StringUtils.equals(cita.getIdentificadorSucursal(), sucursal) && cita.getFechaInicio().after(getFechaHoraAnticipacion(sucursal));
						}
					})
					);
		}
		
		return respuestaCita;
	}
	
	/**
	 * se resta la fecha 15 min menos para la tonlerancia
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Apr 24, 2020
	 * @param sucursal 
	 * @return
	 */
	private Date getFechaHoraAnticipacion(String sucursal) {
		Integer valorHoras = this.obtenterDiferenciaHoras(sucursal);
		LOG.error("\n\n****** Horas a restar para sucursal: {}", valorHoras);
		Calendar cal = Calendar.getInstance();
		LOG.error("\n\n****** Fecha actual ==             : {}",new Date());
		cal.setTime(new Date());
		cal.set(Calendar.HOUR, cal.get(Calendar.HOUR)+valorHoras);
		LOG.error("\n\n****** Fecha actual restando horas : {}",cal.getTime());
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)-15);
		LOG.error("\n\n****** Fecha resta 15 min menos    : {}",cal.getTime());
		return cal.getTime();		
	}
	
	/**
	 * Metodo para que relaiza el mappeo de los datos que se presentaran en la vista.
	 * @Author: Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Sep 20, 2019
	 * @param AdministracionTurno, ConsultaCusSalida, CitaNotificacion, Integer flagTipoCita 
	 * @return {@link AdministracionTurno}
	 */
	@Override
	public AdministracionTurno obtenerDatosTrabajador(AdministracionTurno entrada, ConsultaCusSalida salidaCus, CitaNotificacion citaSalida, Integer flagTipoCita) {
		EntradaConsulta datosEntrada = new EntradaConsulta();
		AdministracionTurno salidaFilas = new AdministracionTurno();
		datosEntrada.setNss(entrada.getNss());
		datosEntrada.setCurp(entrada.getCurp());
		LOG.error("Entro a obtenerDatosTrabajador los datos son: {} \n", datosEntrada);
				
		List<PersonaSalida> listaPersonas = personaService.validarDatosTrabajador(datosEntrada);
		LOG.error("El tamano de la lista de persona son: {} ", listaPersonas.size());
		if (TurnoConstants.INT_TAMANIO_LIST_PERSONA < listaPersonas.size()) {
			LOG.error("El tamaño de la lista es mayor error: {} ", BusinessErrorEnum.TRABAJADOR_DUPLICADO.getClave());
			throw new BusinessException(BusinessErrorEnum.TRABAJADOR_DUPLICADO);			
		}else if(validadorUtils.validarListaVacia(listaPersonas)) {
			LOG.error("No hay datos :: error: {} ", BusinessErrorEnum.TRABAJADOR_NO_ENCONTRADO.getClave());
			throw new BusinessException(BusinessErrorEnum.TRABAJADOR_NO_ENCONTRADO);
		}
		PersonaSalida persona = listaPersonas.get(0);
		LOG.error("Log-Los datos de la persona son: {}\n",persona);
		
		List<CodigoValidaCitaEsar> lstCodigoCita = citaAgendaService.obtenerDatosCodigoCita(persona.getCurp(), TurnoConstants.ESTATUS_INT_UNO);
		
		if (TurnoConstants.FLAG_TIPO_CITA.equals(flagTipoCita)) {
			salidaFilas.setCus(salidaCus.getRespuesta().get("cus"));
			salidaFilas.setFechaCitaCus(citaSalida.getFechaInicio());
		}
		if (!validadorUtils.isEmpty(lstCodigoCita)) {
			salidaFilas.setCorreoElectronico(lstCodigoCita.get(0).getCorreo());
			salidaFilas.setNumeroCelular(lstCodigoCita.get(0).getNuTelefono());
		}
		
		salidaFilas.setCurp(persona.getCurp());
		salidaFilas.setNss(persona.getNss());
		salidaFilas.setNombre(persona.getNombre().trim());
		salidaFilas.setApellidoPaterno(persona.getApellidoPaterno().trim());
		salidaFilas.setApellidoMaterno(!validadorUtils.isEmpty(persona.getApellidoMaterno()) ? persona.getApellidoMaterno().trim() : "");
		salidaFilas.setIndicadorTipoCita(flagTipoCita);
		return salidaFilas;
	}
	
	/**
	 * Valida que un usuario no cuente con registros en atenión.
	 * 
	 * @param idUsuario
	 *            Identificador de USuario
	 * @return Verdadero si cuenta con turno en atención.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private boolean validarUsuarioConTurnoEnAtencion(final Long idUsuario) {

		Calendar ahora = GregorianCalendar.getInstance();
		Date fechaHoy = fechaUtils.actualizarHoraInicio(ahora.getTime());

		List<Turno> turnosEnAtencion = turnoRepository.buscarPorIdUsuarioYEstatusYFechaRegistro(idUsuario,
				ESTATUS_ROL_EN_ATENCION, fechaHoy);
		
		return turnosEnAtencion.isEmpty() ? Boolean.FALSE : Boolean.TRUE;
	}

	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.TurnoService#obtenerTurno(java.lang.String, java.lang.String, java.lang.String, java.util.Date)
	 */
	@Override
	public Respuesta obtenerTurno(Long idUsuario, String claveAfore, String sucursal) {

		Respuesta respuesta = new Respuesta();
		Calendar ahora = GregorianCalendar.getInstance();
		Date fechaHoy = fechaUtils.actualizarHoraInicio(ahora.getTime());
		LOG.info("RespuestaAdministracionTurno. Obtener Turno. usuario: {}, claveAfore: {}, sucursal: {}", idUsuario, claveAfore, sucursal);
		
		LOG.info("RespuestaAdministracionTurno. Busqueda de turno en estatus {} ", ESTATUS_ROL_EN_ATENCION);
		List<Turno> turnosRegistrados = turnoRepository.buscarTurnoPorUsuarioSucursalFecha(idUsuario, ESTATUS_ROL_EN_ATENCION, sucursal, fechaHoy);
		
		if (!validadorUtils.validarListaVacia(turnosRegistrados)){
			Turno turno = turnosRegistrados.get(PRIMER_ELEMENTO);
			LOG.info("RespuestaAdministracionTurno. Turno a actualizar {} ", turno.toString());
			
			AdministracionTurno adminTurno = new AdministracionTurno();
			adminTurno.setIdentificadorTurno(turno.getId()); 
			adminTurno.setFolioServicio(turno.getFolioServicio());		
			
			respuesta.setFlujo(EXITOSO.getClave());
			respuesta.setObjetoRespuesta(adminTurno);
			
		}else{	
			LOG.info("RespuestaAdministracionTurno. No tiene un turno asignado para atencion usuario: {} ", idUsuario);
			respuesta = construirRespuesta(ERROR_TURNO_NO_ASIGANADO.getClave(), claveAfore);
			respuesta.setFlujo(ERROR_NEGOCIO.getClave());
		}		
		
		return respuesta;
	}

	/**
	 * Construye la respuesta del servicio.
	 * 
	 * @param claveAfore
	 * @return
	 */
	private Respuesta construirRespuesta(final String codigo, final String claveAfore) {
		
		Respuesta respuesta;
		RechazoPulssar respuestaMensaje;
		respuestaMensaje = rechazoService.obtenerRechazo(codigo, claveAfore);
		respuesta = respuestaUtils.obtenerRespuesta(ERROR_NEGOCIO.getClave(), respuestaMensaje.getTituloMensaje(), respuestaMensaje.getMensaje());
		return respuesta;
	}

	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.AdministracionTurnoService#obtenterDiferenciaHoras(java.lang.String)
	 */
	@Override
	public Integer obtenterDiferenciaHoras(String sucursal) {
		LOG.error("\n**Consultando si existe la Sucursal en la tabla de las zonas horarias: {}", sucursal);
		// Variable de horas
		Integer horasMenos = 0;
		ZonaHoraSucursal zonaHoraSucursal = new ZonaHoraSucursal();
		try {
			// Consulta por sucursal
			zonaHoraSucursal = zonaHoraSucursalRepository.findByChCveSuc(sucursal);
			
			LOG.error("\n**Datos de la sucursal en la tabla de diferencia de horas: {}", sucursal);
			// Validacion de existencia en BD
			if (zonaHoraSucursal != null) {
				horasMenos = zonaHoraSucursal.getNuDiferenciaHoras();
			}
		} catch (Exception e) {
			LOG.info("\n**Algo salio mal al consultar la zona horaria de la susrcursal: {}", e);
			LOG.error("\n**Algo salio mal al consultar la zona horaria de la susrcursal: {}", e);
		}
		return horasMenos;
	}
}
