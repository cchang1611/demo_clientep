package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.emptyToNull;
import static com.google.common.base.Strings.padStart;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_SERVICIO_FOLIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.CLAVE_PARAMETRO_ADMINISTRACION_TURNOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.DESCRIPCION_PARAMETRO_SMS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.ESTATUS_CANCELADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.ESTATUS_FINALIZADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.ESTATUS_ROL_EN_ATENCION;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.ESTATUS_ROL_REGISTRADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.PRIMER_ELEMENTO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.RELACION_INDICADOR_TIPO_CITA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.USUARIO_MODIFICADOR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.ERROR_INESPERADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.EXITOSO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.FlujoAdministracionTurnosEnum.EXITOSO_REGISTRO_TURNO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum.EXCEPTION_GENERICA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum.PARAMETRO_NULO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum.FINALIZA_REGISTRO_TURNO;
import static org.apache.commons.lang3.StringUtils.substring;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.FolioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Turno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.TurnoEstatus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.TurnoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MensajeService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AdministracionTurno;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Respuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.RespuestaUtilsImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.AsignaTurnoService;

/**
 * Implementa los servicios para las operaciones para la <b>Asignación de
 * Turnos</b>.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 */
@Service
public class AsignaTurnoServiceImpl implements AsignaTurnoService {
	
	/**
	 * Logger para el servicio para la <b>Asignacion de Turnos</b>.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(AsignaTurnoServiceImpl.class);
	
	/**
	 * Servicio para el menejo de mensajeriSa.
	 */
	@Autowired
	private MensajeService mensajeService;
	
	/**
	 * Servicio para el manejo del Folio Pulssar.
	 */
	@Autowired
	private FolioService folioService;
	
	/**
	 * Utileria para el manejo de fechas.
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	/**
	 * Repositorio para las operaciones sobre <b>Administración de Turnos</b>.
	 */
	@Autowired
	private TurnoRepository turnoRepository;
	
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
	 * Servicio para el manejo de catalogos.
	 */
	@Autowired
	private CatalogoService catalogoService;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public synchronized Respuesta crearCita(final AdministracionTurno asignaTurno) {
		
		// Realiza la validación de los datos obligatorios.
		validarDatosClientesConCita(asignaTurno);
		
		// Crea los objetos necesarios para respuesta.
		Respuesta respuesta = new Respuesta();
		RechazoPulssar respuestaMensaje = new RechazoPulssar();
		
		// Recolecta los datos requeridos para realizar la operación.
		final String claveAfore         = asignaTurno.getClaveOrganizacion();
		final Integer indicadorTipoCita = asignaTurno.getIndicadorTipoCita();
		final String claveTipoCita      = RELACION_INDICADOR_TIPO_CITA.get(indicadorTipoCita);
		
		// Prepara los datos para crear el turno.
		Turno turnoConCita = crearTurnoBasadoEnAsignaTurno(asignaTurno);
		agregarTipoCitaEnTurno(turnoConCita, claveTipoCita);
		agregarFolioServicioEnTurno(turnoConCita, claveTipoCita, asignaTurno.getNumeroSucursal());
		
		// Se restan las horas 
		turnoConCita.setFechaRegistro(calcularHoraSucursal(turnoConCita.getFechaRegistro(), asignaTurno.getDiferenciaHora()));
		
		// Crea el turno.
		Turno turnoConCitaRegistrado = turnoRepository.save(turnoConCita);
		
		// Obtiene el mensaje de exito cuando se crea el turno.
		respuestaMensaje = rechazoService.obtenerRechazo(FINALIZA_REGISTRO_TURNO.getClave(), claveAfore);
		respuesta = respuestaUtils.obtenerRespuesta(EXITOSO.getClave(), respuestaMensaje.getTituloMensaje(), respuestaMensaje.getMensaje());
		
		// Completa la respuesta de exito
		respuesta.setFlujo(EXITOSO_REGISTRO_TURNO.getClave());
		respuesta.setObjetoRespuesta(turnoConCitaRegistrado.getFolioServicio());
		respuesta.setMensaje(new StringBuilder(respuesta.getMensaje()).append(turnoConCitaRegistrado.getFolioServicio()).toString());
		
		// Envia la notificación via SMS.
		enviarNotificacion(turnoConCitaRegistrado);
		
		return respuesta;
	}
	
	/**
	 * Metodo que valida si se tiene que restar horas al registro segun la sucursal
	 * donde se este realizando el tramite
	 * @param integer 
	 * @param date 
	 * @param turnoConCita
	 * @param horas 
	 */
	private Date calcularHoraSucursal(Date fecha, Integer horas) {
		LOG.error("\n** Fecha a actualizar es: {}", fecha);
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.HOUR, horas);
        LOG.error("\n** La fecha actualizada es: {}", calendar.getTime());
        return calendar.getTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Respuesta actualizarCitaEnAtencion(String sucursal, String folioServicio, Long idUsuario, Integer horas) {
	
		Respuesta respuestaCita = new Respuesta();
		
		// Recolecta los datos requeridos para realizar la operación.
		Calendar hoy                          = GregorianCalendar.getInstance();
		Date diaConHoraInicial                = fechaUtils.actualizarHoraInicio(hoy.getTime());
		UsuarioPulssar entidadUsuarioEnSesion = new UsuarioPulssar();
		entidadUsuarioEnSesion.setIdentificador(idUsuario);
		
		// Catalogos o relaciones con tablas.
		TurnoEstatus claveEstatus = new TurnoEstatus();
		claveEstatus.setId(ESTATUS_ROL_EN_ATENCION);
		
		// Le asigna al turno los datos a actualizar.
		Turno turnoActualizar = consultaTurnoRegistrado(sucursal, folioServicio, diaConHoraInicial);
		turnoActualizar.setClaveEstatus(claveEstatus);
		turnoActualizar.setFechaControl(hoy.getTime());
		turnoActualizar.setUsuario(entidadUsuarioEnSesion);
		turnoActualizar.setUsuarioModificador(USUARIO_MODIFICADOR);
		// Se actualiza la hora segun el valor del parametro horas
		turnoActualizar.setFechaInicioAtencion(calcularHoraSucursal(new Date(), horas));
		
		turnoRepository.save(turnoActualizar);
		
		// No sucede ningún error por lo tanto se considera un flujo exitoso. 
		respuestaCita.setFlujo(EXITOSO.getClave());
		
		return respuestaCita;
	}
	
	/**
	 * Valida los datos obligatorios de los parámetros de entrada al Servicio
	 * en el escenario de clientes con cita. 
	 * 
	 * @param asignaTurno Los datos base para la Asignacion de Turnos.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private void validarDatosClientesConCita(final AdministracionTurno asignaTurno) {
		
		try {
			
			checkNotNull(asignaTurno, "El parametro asignaTurno es requerido");
			
			checkNotNull(emptyToNull(asignaTurno.getCurp()),               "En registro de la cita la curp del cliente es requerido");
			checkNotNull(emptyToNull(asignaTurno.getNombre()),             "En registro de la cita el nombre del cliente es requerido");
			checkNotNull(emptyToNull(asignaTurno.getApellidoPaterno()),    "En registro de la cita el apellido paterno del cliente es requerido");
			checkNotNull(emptyToNull(asignaTurno.getSolicitante()),        "En registro de la cita el solicitante es requerido");
			checkNotNull(emptyToNull(asignaTurno.getServicioSolicitado()), "En registro de la cita el servicioSolicitado es requerido");
			
			checkNotNull(asignaTurno.getIndicadorTipoCita(), "En registro de la cita el Indicador de Tipo de Turno es requerido");
		}
		catch (Exception e) {
			
			LOG.error("Error en asiganar el turno: ", e);
			throw new GenericException(PARAMETRO_NULO, e.getMessage());
		}
	}
	
	/**
	 * Crea un objeto de un {@link Turno} basico respecto a los datos de
	 * {@link AdministracionTurno}.
	 * 
	 * @param asignaTurno Los datos base para la Asignacion de Turnos.
	 * 
	 * @return Un objeto básico para aturnos.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private Turno crearTurnoBasadoEnAsignaTurno(AdministracionTurno asignaTurno) {
		
		Turno turnoBase = new Turno();
		
		Date fechaCitaCus = fechaUtils.convertirCadenaAFecha(asignaTurno.getFechaCitaCusTexto(),
				FORMATO_SERVICIO_FOLIO);
		
		turnoBase.setCus(asignaTurno.getCus());
		turnoBase.setFechaCitaCus(fechaCitaCus);
		
		turnoBase.setNss(asignaTurno.getNss());
		turnoBase.setCurp(asignaTurno.getCurp());
		turnoBase.setNombreTrabajador(asignaTurno.getNombre());
		turnoBase.setApellidoPaternoTrabajador(asignaTurno.getApellidoPaterno());
		turnoBase.setApellidoMaternoTrabajador(
				emptyToNull(asignaTurno.getApellidoMaterno()) == null ? " " : asignaTurno.getApellidoMaterno());
		
		turnoBase.setCorreo(asignaTurno.getCorreoElectronico());
		turnoBase.setCelular(asignaTurno.getNumeroCelular());
		turnoBase.setClaveAfore(asignaTurno.getClaveOrganizacion());
		
		turnoBase.setIdServicioSolicitado(Long.valueOf(asignaTurno.getServicioSolicitado()));
		
		turnoBase.setFechaRegistro(new Date());
		turnoBase.setFechaControl(new Date());
		turnoBase.setUsuarioModificador(USUARIO_MODIFICADOR);
		
		// Catalogos o relaciones con tablas.
		TurnoEstatus claveEstatus = new TurnoEstatus();
		claveEstatus.setId(ESTATUS_ROL_REGISTRADO);
		
		turnoBase.setClaveEstatus(claveEstatus);
		
		// Consultamos el usuario para crear la relacion.
		UsuarioPulssar entidadUsuarioEnSesion = new UsuarioPulssar();
		entidadUsuarioEnSesion.setIdentificador(asignaTurno.getIdUsuario());
		turnoBase.setUsuario(entidadUsuarioEnSesion);
		
		final String numeroSucursal = asignaTurno.getNumeroSucursal();
		
		crearFolioPulsar(turnoBase, numeroSucursal);
		asignaTurno.setNumeroSucursal(numeroSucursal);
		
		return turnoBase;
	}
	
	/**
	 * Agrega el tipo de cita al turno a registrar.
	 * 
	 * @param turno
	 *            Los datos base para la Asignacion de Turnos.
	 * 
	 * @param tipoCita
	 *            Un turno con el tipo de cita.
	 *            
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private void agregarTipoCitaEnTurno(Turno turno, final String tipoCita) {
		
		turno.setClaveTipoCita(tipoCita);
	}
	
	/**
	 * <p>
	 * Agrega el consecutivo del Folio de Atención del último registrado. En
	 * caso de que no existan registros de turnos para el día actual asigana el
	 * valor por defecto (XX<b>0001</b>).
	 * </p>
	 * 
	 * @param turno
	 *            El turno con el nuevo Folio de Atención.
	 * @param sucursal 
	 */
	private void agregarFolioServicioEnTurno(Turno turno, final String tipoCita, String sucursal) {

		Calendar ahora = GregorianCalendar.getInstance();
		Date diaConHoraInicial = fechaUtils.actualizarHoraInicio(ahora.getTime());
		
		List<Turno> turnosRegistrados = turnoRepository.buscarUltimoTurnoRegistrado(sucursal,
				diaConHoraInicial);
		
		String nuevoFolioServicio = null;
		
		if(turnosRegistrados.isEmpty()) {
			nuevoFolioServicio = new StringBuilder(tipoCita).append("0001").toString();
		}
		else {
			
			Turno ultimoTurnoRegistrado = turnosRegistrados.get(PRIMER_ELEMENTO);
			final String ultimoFolioRegistrado = ultimoTurnoRegistrado.getFolioServicio();
			final String valorNumericoFolioRegistrado = substring(ultimoFolioRegistrado, 2);
			
			int enteroFolioRegistrado = new Integer(valorNumericoFolioRegistrado);
			
			final String nuevoValorNumericoFolio = padStart(String.valueOf(++enteroFolioRegistrado), 4, '0');
			nuevoFolioServicio = new StringBuilder(tipoCita).append(nuevoValorNumericoFolio).toString();
		}
		
		turno.setFolioServicio(nuevoFolioServicio);
	}
	
	/**
	 * Servicio para el envío de notificaciones en asignación de Turno.
	 * 
	 * @param turno Los datos base para la Asignacion de Turnos.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private void enviarNotificacion(final Turno turno) {

		final String numeroCelular = turno.getCelular();

		if (StringUtils.isNotBlank(numeroCelular)) {
			
			final String folioAtencion = turno.getFolioServicio();
			
			final String mensajeDeTexto = obtenerValorParamtro(CLAVE_PARAMETRO_ADMINISTRACION_TURNOS,
					DESCRIPCION_PARAMETRO_SMS);
			final String mensajeDeTextoConFolioServicio = String.format(mensajeDeTexto, folioAtencion);

			mensajeService.enviarMensaje(mensajeDeTextoConFolioServicio, numeroCelular);
		}
	}
	
	/**
	 * Permite crear el folio Pulssar con base a los datos del turno al turno a
	 * crear.
	 * 
	 * @param asignaTurno
	 *            Turno a crear.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 * @param numeroSucursal 
	 */
	private void crearFolioPulsar(final Turno turnoBase, String numeroSucursal) {
		
		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(turnoBase.getUsuario().getIdentificador());
		folio.setOperacion("S");
		folio.setServicio("S1");
		folio.setProceso("S1P1");
		folio.setCurp(turnoBase.getCurp());
		folio.setNss(turnoBase.getNss());
		folio.setSucursal(numeroSucursal);
		
		folio.setTiempoLlegada("00:00");
		
		folio = folioService.generarFolio(folio);
		final Long nuevoFolioCreado = Long.valueOf(folio.getIdFolio());
		
		// Inmediatamente cerramos el folio.
		folioService.cerrarFolio(nuevoFolioCreado, null);
		
		// Crea la relación al Folio Pulssar
		FolioPulssar folioPulssar = new FolioPulssar();
		folioPulssar.setId(nuevoFolioCreado);
		turnoBase.setFolioPulssar(folioPulssar);
	}
	
	/**
	 * Permite consultar los Turnos a través del Folio de Servicio y un día.
	 * @param sucursal 
	 * @param folioServicio
	 *            Folio de Servicio.
	 * 
	 * @return Los turnos encontrados.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	private Turno consultaTurnoRegistrado(String sucursal, final String folioServicio, final Date diaConHoraInicial) {
		
		List<Turno> turnos = turnoRepository.buscarTurnoPorFolioSucursalFecha(sucursal, folioServicio, diaConHoraInicial);
		
		// Filtra los estatus registrados.
		List<Turno> turnosRegistrados = Lists.newArrayList(Collections2.filter(turnos, new Predicate<Turno>() {

			@Override
			public boolean apply(Turno turno) {
				final TurnoEstatus estatus = turno.getClaveEstatus();
				return StringUtils.equals(estatus.getId(), ESTATUS_ROL_REGISTRADO);
			}
		}));

		if(turnosRegistrados.isEmpty()) {
			
			LOG.error(new StringBuilder("No encontro el turno con el folio").append(folioServicio).toString());
			throw new GenericException(EXCEPTION_GENERICA);
		}
		
		return turnosRegistrados.get(PRIMER_ELEMENTO);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Respuesta actualizarTurno(AdministracionTurno administracionTurno, String claveAfore, Integer horas) {
		
		Respuesta respuesta = new Respuesta();
		RechazoPulssar respuestaMensaje = new RechazoPulssar();
		
		try {
			
			LOG.info("AsignaTurnoServiceImpl. Actualizar Turno. {}", administracionTurno.toString());
			
			Calendar hoy = GregorianCalendar.getInstance();
			
			Turno turnoActualizar = turnoRepository.findOne(administracionTurno.getIdentificadorTurno());
			
			TurnoEstatus claveEstatus = new TurnoEstatus();
			
			if (NumerosConstants.INT_CERO.equals(administracionTurno.getCancelar())) {
				turnoActualizar.setClaveServiciosRealizados(administracionTurno.getListaServicios().toString());
				turnoActualizar.setFolioAtencion(administracionTurno.getFolioAtencion());
				claveEstatus.setId(ESTATUS_FINALIZADO);
			}else{
				claveEstatus.setId(ESTATUS_CANCELADO);		
			}			

			turnoActualizar.setClaveEstatus(claveEstatus);	
			// Se actualiza la hora segun el valor del parametro horas
			turnoActualizar.setFechaFinAtencion(calcularHoraSucursal(new Date(), horas));
			turnoActualizar.setFechaControl(hoy.getTime());	
			turnoActualizar.setUsuarioModificador(USUARIO_MODIFICADOR);
			
			turnoRepository.save(turnoActualizar);
			
			respuestaMensaje = rechazoService.obtenerRechazo(MensajesExitoEnum.FINALIZAR_TURNO.getClave(), claveAfore);
			//String mensaje = StringUtils.replace(respuestaMensaje.getMensaje(), RESPUESTA_TURNO, turnoActualizar.getFolioServicio());
			//respuestaMensaje.setMensaje(mensaje);
			respuesta = respuestaUtils.obtenerRespuesta(EXITOSO.getClave(), respuestaMensaje.getTituloMensaje(), respuestaMensaje.getMensaje());
		}
		catch (Exception e) {			
			LOG.error("AsignaTurnoServiceImpl. Actualizar Turno. Exception: ", e);
			respuestaMensaje = rechazoService.obtenerRechazo(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), claveAfore);
			respuesta = respuestaUtils.obtenerRespuesta(ERROR_INESPERADO.getClave(), respuestaMensaje.getTituloMensaje(), respuestaMensaje.getMensaje());
		}
		
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

		checkNotNull(emptyToNull(clave),       "El campo clave Parametro es obligatorio");
		checkNotNull(emptyToNull(descripcion), "El campo descripcion Parametro es obligatorio");

		final List<Parametro> listaParametros = catalogoService.obtenerParametroDdbpose(clave, descripcion);

		if (listaParametros.isEmpty()) {

			throw new GenericException(EXCEPTION_GENERICA,
					String.format("El parametro con clave %s y descripcio %s es inexistente", 
							clave, descripcion));
		}

		return listaParametros.get(PRIMER_ELEMENTO).getChValorParametro();
	}

}
