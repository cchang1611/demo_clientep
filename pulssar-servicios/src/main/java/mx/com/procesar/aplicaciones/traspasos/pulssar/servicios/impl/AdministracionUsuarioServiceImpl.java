
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.BloqueoUsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CorreoCorporativo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioNickPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioRol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.Usuarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.UsuariosConsultaRol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.UsuariosModificar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.BloqueoUsuarioPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.CodigoUsuarioRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.CorreoCorporativoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.MenuPaginaRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioNickPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioRolRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AgenteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CorreoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DirectorioUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MensajeService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarAltaUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarDatosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.CorreoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RolesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CorreoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.EstatusUsuarioEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.RolesEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AgentePromotor;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCorreo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosOrganizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CodigoUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.EncriptacionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion de la administracion de usuarios
 * 
 * @author DBARBOSA
 */
@Service
public class AdministracionUsuarioServiceImpl implements AdministracionUsuarioService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(AdministracionUsuarioServiceImpl.class);
	
	/**
	 * Inyeccion de repositorio usuario
	 */
	@Autowired
	private UsuarioPulssarRepository repositorioUsuario;
	
	/**
	 * Inyeccion de repositorio nickname
	 */
	@Autowired
	private UsuarioNickPulssarRepository repositorioUsuarioNick;
	
	/**
	 * Repositorio de usuarios Rol usuario
	 */
	@Autowired
	private UsuarioRolRepository repositorioUsuarioRol;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de utileria codigo
	 */
	@Autowired
	private CodigoUtils utileriaCodigo;
	
	/**
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inyeccion de utileria fecha
	 */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/**
	 * Inyeccion de servicio Directorio
	 */
	@Autowired
	private DirectorioUsuarioService servicioDirectorio;
	
	/**
	 * Inyeccion de servicio Mensaje
	 */
	@Autowired
	private MensajeService servicioMensaje;
	
	/**
	 * Inyeccion de servicio Correo
	 */
	@Autowired
	private CorreoService servicioCorreo;
	
	/**
	 * Inyeccion utileria encriptacion
	 */
	@Autowired
	private EncriptacionUtils encriptacionUtils;
	
	/**
	 * Servicio roles
	 */
	@Autowired
	private RolesService servicioRoles;
	
	/**
	 * Inyeccion repositorio CodigoUsuario 
	 */
	@Autowired
	private CodigoUsuarioRepository repositorioCodigo;
	
	/**
	 * Inyeccion de repositorio rechazo
	 */
	@Autowired
	private CodigoUsuarioRepository persistenciaCodigo;
	
	/**
	 * Inyeccion service catalogo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion de servicio validador
	 */
	@Autowired
	private ValidarDatosService servicioValidarDatos;
	
	/**
	 * Inyeccion repositorio correo
	 */
	@Autowired
	private CorreoCorporativoRepository repositorioCorreoCorporativo;
	
	/**
	 * Inyeccion repositorio bloqueo usuario
	 */
	@Autowired
	private BloqueoUsuarioPulssarRepository repositorioBloqueoUsuario;;
	
	/**
	 * Inyeccion repositorio menu pagina
	 */
	@Autowired
	private MenuPaginaRepository menuPaginaRepository;
	
	/**
	 * Inyeccion de servicio registro
	 */
	@Autowired
	private AgenteService servicioAgente;
	
	/**
	 * Inyeccion de servicio registro
	 */
	@Autowired
	private ValidarAltaUsuarioService servicioValidarAlta;
	
	/**
	 * Key seguridad
	 */
	@Value("${key.seguridad.encriptacion.usuario}")
	private String keySeguridadEncriptacion;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public RespuestaServicio recuperarContrasenia(DatosRegistro usuario) {
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioPulssar usuarioPulssar = null;
		String auxiliarAfore = ActivacionConstants.CLAVE_PROCESAR;
		String parametroDias = AgenteConstants.PARAMETRO_CODIGO;
		String paramCaracter = AgenteConstants.PARAMETRO_MENSAJE;
		try {
			usuarioPulssar = this.obtenerUsuario(usuario.getNickUsuario(), RegistroUsuarioConstants.ESTATUS_USUARIOS, false);
			if(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario().equals(usuarioPulssar.getEstatus())) {
				logger.info("Usuario se encuentra inactivo {}", usuario.getNickUsuario());
				throw new BusinessException(BusinessErrorEnum.ERROR_USUARIO_NO_ACTIVO);
			}
			
			List<CodigoUsuario> resultadoCodigo = this.validarListaUsuariosCodigo(Arrays.asList(usuarioPulssar), RegistroUsuarioConstants.TIPO_CODIGO_RECUPERACION);
			this.validarCodigoUsuario(resultadoCodigo, usuarioPulssar);
			
			this.validarCorreoTelefono(usuario.getCelular(), usuario.getCorreo(), usuarioPulssar);
			
			String contrasenia = utileriaCodigo.generarContrasenia();
			servicioDirectorio.recuperaContrasenia(usuario.getNickUsuario(), contrasenia);
			
			String mensajeOK = MensajesExitoEnum.RECUPERACION_CONTRASENIA_CORREO_CORRECTAMENTE.getClave();
			String mensajeSms = "";
			CodigoUsuario codigoUsuario = null;
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
			String estatusUsuarioPulssar = EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario();
			if(utileriaValidador.validarVacio(usuarioPulssar.getEmail())) {
				String parametroMensajeNS = utileriaValidador.obtenerValorParametro(listaParametro, RegistroUsuarioConstants.TIPO_SMS_NUEVO_PASSWORD, RegistroUsuarioConstants.MENSAJE_SMS_PASSWORD);
				mensajeSms = parametroMensajeNS.replace(RegistroUsuarioConstants.SMS_PASSWORD, contrasenia);
				mensajeOK = MensajesExitoEnum.RECUPERACION_CONTRASENIA_CELULAR_CORRECTAMENTE.getClave();
			} else {
				String parametroMensajeC = utileriaValidador.obtenerValorParametro(listaParametro, RegistroUsuarioConstants.TIPO_SMS_ALTA, RegistroUsuarioConstants.MENSAJE_SMS);
				String codigo = utileriaCodigo.generarCodigoActivacion();
				String smsCodigo = CorreoConstants.LEYENDA_CON_CODIGO;
				String codigoEmail = codigo;
				CorreoEnum archivoCorreo = CorreoEnum.ARCHIVO_RECUPERA_PASSWORD;;
				if(!utileriaValidador.validarVacio(usuarioPulssar.getCelular())) {
					mensajeSms = parametroMensajeC.replace(RegistroUsuarioConstants.SMS_CODIGO, codigo);
					smsCodigo = CorreoConstants.LEYENDA_SIN_CODIGO;
					codigoEmail = AgenteConstants.INICIALIZA_VACIO;
				}
				
				List<Parametro> listaParametroDias = servicioCatalogo.obtenerParametro(parametroDias, "");
				String dias = utileriaValidador.obtenerValorParametro(listaParametroDias,RegistroUsuarioConstants.DIAS_VIGENCIA, NumerosConstants.INT_UNO.toString());
				int dia = Integer.parseInt(dias);
				Date fechaCodigo = new Date();
				Date fechaVigencia = utileriaFecha.sumaDias(fechaCodigo, dia);
				
				String fecha = utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_CORREO);
				DatosCorreo correoCambio = new DatosCorreo();
				correoCambio.setDatosCorreo(archivoCorreo);
				correoCambio.setCorreo(usuarioPulssar.getEmail());
				correoCambio.setFecha(fecha);
				String folio = utileriaCodigo.generarFolioServicio();
				correoCambio.setFolio(folio);
				correoCambio.setCodigo(codigoEmail);
				correoCambio.setNombre(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioPulssar.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
						utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioPulssar.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
						utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioPulssar.getApellidoMaterno(), ExpresionesConstants.VACIO)));
				correoCambio.setContrasenia(contrasenia);
				String key = utileriaCadena.obtenerCadenaConcatenada(true, usuarioPulssar.getUsuario(), AgenteConstants.COMA, folio, AgenteConstants.COMA, RegistroUsuarioConstants.TIPO_CODIGO_RECUPERACION);
				String keyConcatenada = encriptacionUtils.obtieneEncriptacion(key, keySeguridadEncriptacion);
				correoCambio.setLigaServicio(keyConcatenada);
				correoCambio.setCodigoMsn(smsCodigo);
				correoCambio.setUrlServicio(servicioValidarAlta.obtenerUrlPaginaPlataforma(usuarioPulssar.getClaveOrganizacion()));
				servicioCorreo.envioCorreo(correoCambio, usuarioPulssar.getClaveOrganizacion());
				
				codigoUsuario = new CodigoUsuario();
				codigoUsuario.setCodigo(codigo);
				codigoUsuario.setEstatus(NumerosConstants.INT_CERO);
				codigoUsuario.setFechaVigencia(fechaVigencia);
				codigoUsuario.setFechaUso(null);
				codigoUsuario.setFolio(folio);
				codigoUsuario.setTipoCodigo(RegistroUsuarioConstants.TIPO_CODIGO_RECUPERACION);
				codigoUsuario.setFecha(fechaCodigo);
				codigoUsuario.setIdentificadorUsuario(usuarioPulssar.getIdentificador());
				codigoUsuario.setUsuario(RegistroUsuarioConstants.USUARIO_RECUPERACION);
				codigoUsuario.setIntentos(NumerosConstants.INT_CERO);
			}
			
			usuarioPulssar.setEstatus(estatusUsuarioPulssar);
			usuarioPulssar.setFecha(new Date());
			usuarioPulssar.setUsuarioModificador(RegistroUsuarioConstants.USUARIO_RECUPERACION);
			repositorioUsuario.saveAndFlush(usuarioPulssar);
			
			if(!utileriaValidador.validarVacio(usuarioPulssar.getCelular())) {
				servicioMensaje.enviarMensaje(mensajeSms, usuarioPulssar.getCelular());
			}
			if(!utileriaValidador.validarObjetoNulo(codigoUsuario)) {
				persistenciaCodigo.saveAndFlush(codigoUsuario);
			}
			
			servicioDirectorio.reiniciarIntentos(usuario.getNickUsuario());
			respuesta = servicioCatalogo.obtenerRespuesta(null, mensajeOK, usuarioPulssar.getClaveOrganizacion(), NumerosConstants.INT_UNO,null);
		} catch(BusinessException be) {
			logger.error("BusinessException recuperarContrasenia", be);
			if(!utileriaValidador.validarObjetoNulo(usuarioPulssar)) {
				auxiliarAfore = usuarioPulssar.getClaveOrganizacion();
			}
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), auxiliarAfore, NumerosConstants.INT_DOS,null);
		} catch(Exception e) {
			logger.error("Exception no controlada en recuperarContrasenia", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), auxiliarAfore, NumerosConstants.INT_DOS,null);
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio reenviarCorreoPassword(String usuario){
		RespuestaServicio respuesta = new RespuestaServicio();
		String auxiliarAfore = ActivacionConstants.CLAVE_PROCESAR;
		UsuarioPulssar usuarioPulssar = null;
		CodigoUsuario codigo = null;
		BusinessErrorEnum error = null;
		try{
			if(!utileriaValidador.validarVacio(usuario)){
				usuarioPulssar = this.obtenerUsuario(usuario, RegistroUsuarioConstants.ESTATUS_USUARIOS, false);
				codigo = this.validarCodigo(usuarioPulssar);
				 error = this.validarEstatusCodigo(codigo, codigo.getFolio(), RegistroUsuarioConstants.TIPO_CODIGO_RECUPERACION, usuarioPulssar.getIdentificador(), new Date());
				if(utileriaValidador.validarObjetoNulo(error)){
					respuesta = this.validacionReenvioCorreoCelular(usuario, usuarioPulssar, codigo,auxiliarAfore);
				}else{
					throw new BusinessException(error);
				}
				
			}else{
				respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.USUARIO_NO_CAPTURADO.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS, null);
			}
		} catch(BusinessException be) {
			logger.error("BusinessException recuperarContrasenia", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), auxiliarAfore, NumerosConstants.INT_DOS,null);
		} catch(Exception e) {
			logger.error("Exception no controlada en recuperarContrasenia", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), auxiliarAfore, NumerosConstants.INT_DOS,null);
		}
		return respuesta;	
	}
	
	/**
	 * Metodo encargado de validar vacio de lista codigo
	 * @param usuarioPulssar
	 * @return
	 */
	private CodigoUsuario validarCodigo(UsuarioPulssar usuarioPulssar){
		CodigoUsuario codigo = null;
		if(!utileriaValidador.validarObjetoNulo(usuarioPulssar)){
			List<CodigoUsuario> resultadoCodigo = this.validarListaUsuariosCodigo(Arrays.asList(usuarioPulssar), RegistroUsuarioConstants.TIPO_CODIGO_RECUPERACION);
			if(!utileriaValidador.validarListaVacia(resultadoCodigo)){
				codigo = resultadoCodigo.get(NumerosConstants.INT_CERO);
			}
		}
		return codigo;
	}
	
	/**
	 * Metodo encargado de validar el reenvio de correo
	 * @param usuario
	 * @param usuarioPulssar
	 * @param codigo
	 * @return
	 */
	private RespuestaServicio validacionReenvioCorreoCelular(String usuario,UsuarioPulssar usuarioPulssar,CodigoUsuario codigo,String auxiliarAfores){
		RespuestaServicio respuesta = new RespuestaServicio();
		String mensajeOK = MensajesExitoEnum.RECUPERACION_CONTRASENIA_CORREO_CORRECTAMENTE.getClave();
		String contrasenia = utileriaCodigo.generarContrasenia();
		servicioDirectorio.recuperaContrasenia(usuario, contrasenia);
		
		if(!utileriaValidador.validarVacio(usuarioPulssar.getEmail())) {
			String smsCodigo = CorreoConstants.LEYENDA_CON_CODIGO;
			String codigoEmail = codigo.getCodigo();
			
			if(!utileriaValidador.validarVacio(usuarioPulssar.getCelular())) {
				smsCodigo = CorreoConstants.LEYENDA_SIN_CODIGO;
				codigoEmail = AgenteConstants.INICIALIZA_VACIO; 
			}
			
			String fecha = utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_CORREO);
			DatosCorreo correoCambio = new DatosCorreo();
			correoCambio.setDatosCorreo(CorreoEnum.ARCHIVO_RECUPERA_PASSWORD);
			correoCambio.setCorreo(usuarioPulssar.getEmail());
			correoCambio.setFecha(fecha);
			correoCambio.setFolio(codigo.getFolio());
			correoCambio.setNombre(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioPulssar.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
					utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioPulssar.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
					utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioPulssar.getApellidoMaterno(), ExpresionesConstants.VACIO)));
			correoCambio.setContrasenia(contrasenia);
			correoCambio.setCodigo(codigoEmail);
			correoCambio.setCodigoMsn(smsCodigo);
			String key = utileriaCadena.obtenerCadenaConcatenada(true, usuarioPulssar.getUsuario(), AgenteConstants.COMA, codigo.getFolio(), AgenteConstants.COMA, RegistroUsuarioConstants.TIPO_CODIGO_RECUPERACION);
			String keyConcatenada = encriptacionUtils.obtieneEncriptacion(key, keySeguridadEncriptacion);
			correoCambio.setLigaServicio(keyConcatenada);
			correoCambio.setUrlServicio(servicioValidarAlta.obtenerUrlPaginaPlataforma(auxiliarAfores));
			servicioCorreo.envioCorreo(correoCambio, usuarioPulssar.getClaveOrganizacion());
		} else if(!utileriaValidador.validarVacio(usuarioPulssar.getCelular())) {
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_MENSAJE, "");
			String parametroMensajeNS = utileriaValidador.obtenerValorParametro(listaParametro, RegistroUsuarioConstants.TIPO_SMS_NUEVO_PASSWORD, RegistroUsuarioConstants.MENSAJE_SMS_PASSWORD);
			String mensajeSms = parametroMensajeNS.replace(RegistroUsuarioConstants.SMS_PASSWORD, contrasenia);
			mensajeOK = MensajesExitoEnum.RECUPERACION_CONTRASENIA_CELULAR_CORRECTAMENTE.getClave();
			
			servicioMensaje.enviarMensaje(mensajeSms, usuarioPulssar.getCelular());
		}
		respuesta = servicioCatalogo.obtenerRespuesta(null, mensajeOK, auxiliarAfores, NumerosConstants.INT_UNO, null);
		
		return respuesta;
	}
	/**
	 * Metodo encargado de validar el codigo de usuario
	 * 
	 * @param resultadoCodigo
	 * @param usuarioPulssar
	 */
	private void validarCodigoUsuario(List<CodigoUsuario> resultadoCodigo, UsuarioPulssar usuarioPulssar) {
		if(!utileriaValidador.validarListaVacia(resultadoCodigo)) {
			CodigoUsuario codigoU = resultadoCodigo.get(NumerosConstants.INT_CERO);
			Date fecha = new Date();
			if(NumerosConstants.INT_CERO == codigoU.getEstatus() && fecha.before(codigoU.getFechaVigencia())) {
				throw new BusinessException(BusinessErrorEnum.FECHA_CODIGO_VIGENTE);
			} else {
				this.validarEstatusCodigo(codigoU, null, codigoU.getTipoCodigo(), usuarioPulssar.getIdentificador(), fecha);
			}
		}
		
		BusinessErrorEnum errorBloqueoUsuario = this.validarBloqueoUsuario(usuarioPulssar);
		if(!utileriaValidador.validarObjetoNulo(errorBloqueoUsuario)){
			throw new BusinessException(errorBloqueoUsuario);
		}
	}
	
	/**
	 * Metodo encargado de validar bloqueo de usuario
	 * @param usuarioPulssar
	 * @return
	 */

	private BusinessErrorEnum validarBloqueoUsuario(UsuarioPulssar usuarioPulssar) {
		BusinessErrorEnum error = null;
		if(EstatusUsuarioEnum.USUARIO_BLOQUEADO.getEstatusUsuario().equals(usuarioPulssar.getEstatus())) {
			List<BloqueoUsuarioPulssar> listaBloqueo = repositorioBloqueoUsuario.findByIdentificadorUsuarioOrderByIdentificadorBloqueoDesc(usuarioPulssar.getIdentificador());
			if(!utileriaValidador.validarListaVacia(listaBloqueo)) {
				BloqueoUsuarioPulssar bloqueo = listaBloqueo.get(NumerosConstants.INT_CERO);
				if(!utileriaValidador.validarObjetoNulo(bloqueo.getFcVigencia())) {
					error = this.verificarBloqueoUsuario(bloqueo,usuarioPulssar);
				}
			}
		}
		return error;		
	}
	
	/**
	 * 
	 * @param bloqueo
	 * @param usuarioPulssar
	 * @return
	 */
	@Transactional
	private BusinessErrorEnum verificarBloqueoUsuario(BloqueoUsuarioPulssar bloqueo,UsuarioPulssar usuarioPulssar){
		Date fechaHoy = new Date();
		BusinessErrorEnum error = null;
		 if(RegistroUsuarioConstants.ESTATUS_BLOQUEO_PRIMER_BLOQUEO.equals(bloqueo.getEstatus())){
			if(fechaHoy.after(bloqueo.getFcVigencia())) {
				bloqueo.setIntentos(NumerosConstants.INT_CERO);
				this.asignarValoresBloqueo(bloqueo, RegistroUsuarioConstants.USUARIO_BLOQUEO);				
				usuarioPulssar.setEstatus(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
				repositorioUsuario.saveAndFlush(usuarioPulssar);
			} else {
				error = BusinessErrorEnum.USUARIO_BLOQUEADO_TEMPORALMENTE;
			}
		 }else if(RegistroUsuarioConstants.ESTATUS_BLOQUEO_SEGUNDO_BLOQUEO.equals(bloqueo.getEstatus())){
			error = BusinessErrorEnum.USUARIO_BLOQUEADO_PERMANENTE;
		 }
		return error;
	}

	/**
	 * Se realiza la validacion del 
	 * @param celular
	 * @param correo
	 * @param usuarioPulssar
	 * @return
	 */
	private void validarCorreoTelefono(String celular, String correo, UsuarioPulssar usuarioPulssar) {
		String paramCaracter = AgenteConstants.CARACTER_HOMOLOGADO;
		List<Parametro> listaParametro =  servicioCatalogo.obtenerParametro(paramCaracter, "");
		String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;
		if(!utileriaValidador.validarListaVacia(listaParametro)) {
			caracterHomologado = listaParametro.get(0).getChValorParametro();
		}
		
		BusinessErrorEnum error = BusinessErrorEnum.TELEFONO_DISTINTO_REGISTRADO;
		String cadenaBD;
		String cadenaEntrada;
		
		if(!utileriaValidador.validarVacio(celular)) {
			cadenaBD = usuarioPulssar.getCelular();
			cadenaEntrada = celular;
			utileriaCadena.validarCadenasIguales(cadenaEntrada, cadenaBD, error, caracterHomologado);
		}		
		
		if(!utileriaValidador.validarVacio(correo)) {
			cadenaBD = usuarioPulssar.getEmail();
			cadenaEntrada = correo;
			error = BusinessErrorEnum.CORREO_DISTINTO_REGISTRADO;
			utileriaCadena.validarCadenasIguales(cadenaEntrada, cadenaBD, error, caracterHomologado);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cambiarContrasenia(DatosRegistro usuario) {
		UsuarioPulssar usuarioPulssar = this.obtenerUsuario(usuario.getNickUsuario(), RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE, false);
		
		usuario.setNumeroAgente(usuarioPulssar.getUsuario());
		servicioDirectorio.cambioContrasenia(usuario, BusinessErrorEnum.ERROR_USUARIO_EXISTENTE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio activarUsuario(DatosRegistro datosEntrada, String urlKey) {
		RespuestaServicio respuestaActivar = new RespuestaServicio();
		try {
			servicioValidarDatos.validarDatosActivar(datosEntrada);
			if(!datosEntrada.getPassword().equals(datosEntrada.getConfirmarPassword())) {
				throw new GenericException(GenericErrorEnum.PASSWORD_IGUALES);
			}
			
			respuestaActivar = this.validarActivacionUsuario(urlKey, datosEntrada, true);
		} catch(GenericException ge) {
			logger.error("GenericException", ge);
			respuestaActivar = servicioCatalogo.obtenerRespuesta(null, ge.getCodigo(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS,null);
		}
		
		return respuestaActivar;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio validarUsuarioLogin(String usuario, String contexto) {
		logger.error("Entra a (validarUsuarioLogin)");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioPulssar usuarioP = null;
		String minutos = null;
		String auxiliarAfore = ActivacionConstants.CLAVE_PROCESAR;
		String usuarioAfore = "";
		try {
			respuesta.setFlujo(NumerosConstants.INT_CERO);
			List<UsuarioPulssar> listaUsuarios = repositorioUsuario.findUsuarioActivo(usuario, RegistroUsuarioConstants.ESTATUS_USUARIOS);
			usuarioP = this.validarEstatusUsuario(listaUsuarios);
			if(utileriaValidador.validarObjetoNulo(usuarioP)) {
				List<UsuarioNickPulssar> listaNickUsuario = repositorioUsuarioNick.findByNickUsuarioAndEstatus(usuario, NumerosConstants.INT_UNO);
				if(utileriaValidador.validarListaVacia(listaNickUsuario)) {
					throw new BusinessException(BusinessErrorEnum.ERROR_USUARIO_NO_EXISTE);
				}
				UsuarioNickPulssar usuarioN = listaNickUsuario.get(NumerosConstants.INT_CERO);
				usuarioP = repositorioUsuario.findOne(usuarioN.getIdentificadorUsuario());
				usuarioP = this.validarEstatusUsuario(Arrays.asList(usuarioP));
				respuesta.setFlujo(NumerosConstants.INT_UNO);
			} else {
				logger.error("Entra UsuarioPulssar (validarUsuarioLogin) : {}", usuario);
				usuarioAfore = usuarioP.getClaveOrganizacion();
				if(utileriaValidador.validarVacio(contexto)) {
					logger.error("Contexto Vacio (validarUsuarioLogin)");
					List<Parametro> lAforesBloqueo = servicioCatalogo.obtenerParametroDdbpose(AgenteConstants.PARAMETRO_ACCESO_AFORES);
					if(!utileriaValidador.validarListaVacia(lAforesBloqueo) && lAforesBloqueo.get(NumerosConstants.INT_CERO).getChValorParametro().trim().contains(usuarioP.getClaveOrganizacion())) {
						throw new BusinessException(BusinessErrorEnum.NO_ACCESO_PORTAL);
					}
				} else {
					logger.error("Contexto (validarUsuarioLogin) : {}", contexto);
					List<Parametro> lparametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_REDIRECCION, usuarioP.getClaveOrganizacion());
					if(!utileriaValidador.validarListaVacia(lparametro) && !lparametro.get(NumerosConstants.INT_CERO).getChValorParametro().trim().contains(contexto)) {
						throw new BusinessException(BusinessErrorEnum.URL_DISTINTA_USUARIO_LOGIN);
					}
				}
			}
		} catch(BusinessException be) {
			Integer tipoFlujo = NumerosConstants.INT_DOS;
			logger.error("BusinessException validarUsuarioLogin", be);
			if(usuarioP != null) {
				auxiliarAfore = usuarioP.getClaveOrganizacion();
			}
			if(BusinessErrorEnum.ESTATUS_USAURIO_REACTIVADO.getClave().equals(be.getCodigo())) {
				tipoFlujo = NumerosConstants.INT_CINCO;
			}
			if(BusinessErrorEnum.USUARIO_BLOQUEADO_TEMPORALMENTE.getClave().equals(be.getCodigo())){
				List<UsuarioPulssar> usuarioR = repositorioUsuario.findByUsuario(usuario);
				List<BloqueoUsuarioPulssar> listaBloqueo = repositorioBloqueoUsuario.findByIdentificadorUsuarioOrderByIdentificadorBloqueoDesc(usuarioR.get(NumerosConstants.INT_CERO).getIdentificador());
				if(!utileriaValidador.validarListaVacia(listaBloqueo)){
					BloqueoUsuarioPulssar bloqueoUsuarioPulssar = listaBloqueo.get(NumerosConstants.INT_CERO);
					 minutos = utileriaFecha.diferenciaMinutos(new Date(), bloqueoUsuarioPulssar.getFcVigencia());

				}
			}
			String textoUrl = "";
			if(BusinessErrorEnum.NO_ACCESO_PORTAL.getClave().equals(be.getCodigo()) || BusinessErrorEnum.URL_DISTINTA_USUARIO_LOGIN.getClave().equals(be.getCodigo())) {
				List<Parametro> lparametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_REDIRECCION, usuarioAfore);
				textoUrl = StringUtils.replace(AgenteConstants.URL_ACCESAR_CLAVE_AFORE, "{contextoAfore}", utileriaValidador.validarListaVacia(lparametro) ? ExpresionesConstants.DIAGONAL : lparametro.get(NumerosConstants.INT_CERO).getChValorParametro());
			}
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), auxiliarAfore, tipoFlujo,minutos);
			respuesta.setMensaje(utileriaCadena.obtenerCadenaConcatenada(false, respuesta.getMensaje(), ExpresionesConstants.ESPACIO, textoUrl));
		}
		
		logger.error("Respuesta: {}", respuesta);
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsuarioLogin obtenerRolUsuario(String usuario) {
		try {
			Integer flujo = NumerosConstants.INT_CERO;
			UsuarioPulssar usuarioP = this.obtenerUsuario(usuario, RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE, false);
			List<UsuarioRol> listaRoles = repositorioUsuarioRol.findRolesById(usuarioP.getIdentificador(), NumerosConstants.INT_UNO);
			
			UsuarioLogin user = new UsuarioLogin();
			user.setFlujo(flujo);
			user.setDatoUsuario(usuarioP.getIdentificador());
			user.setUsuario(usuarioP.getUsuario());
			user.setNombre(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioP.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
					utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioP.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
					utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioP.getApellidoMaterno(), ExpresionesConstants.VACIO)));
			user.setSoloNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioP.getNombre(), ExpresionesConstants.VACIO));
			user.setApellidoPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioP.getApellidoPaterno(), ExpresionesConstants.VACIO));
			user.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioP.getApellidoMaterno(), ExpresionesConstants.VACIO));
			user.setAforeUsuario(usuarioP.getClaveOrganizacion());
			user.setSucursal(usuarioP.getChSucursal());
			user.setRoles(this.obtenerRolUsuarioLogin(listaRoles));
			user.setEstatus(usuarioP.getEstatus());
			
			AgentePromotor agente = this.obtenerDatosAgente(usuarioP.getUsuario(), usuarioP.getClaveOrganizacion(), listaRoles);
			if(!utileriaValidador.validarObjetoNulo(agente)) {
				user.setFoto(agente.getDatosAgente().getFotoAgente());
				user.setTipoAgente(agente.getDatosAgente().getTipoAgente());
				user.setCurpAgente(agente.getDatosAgente().getCurpAgente());
			}
			if(!usuario.equals(usuarioP.getUsuario())){
				user.setUsuario(usuario);
				user.setUsuarioAgente(usuarioP.getUsuario());
			}
			List<BloqueoUsuarioPulssar> listaBloqueo = repositorioBloqueoUsuario.findByIdentificadorUsuarioOrderByIdentificadorBloqueoDesc(usuarioP.getIdentificador());
			if(!utileriaValidador.validarListaVacia(listaBloqueo)) {
				BloqueoUsuarioPulssar bloqueo = listaBloqueo.get(NumerosConstants.INT_CERO);
				if(RegistroUsuarioConstants.ESTATUS_BLOQUEO.equals(bloqueo.getEstatus()) && NumerosConstants.INT_CERO != bloqueo.getIntentos()) {
					bloqueo.setIntentos(NumerosConstants.INT_CERO);
					repositorioBloqueoUsuario.saveAndFlush(bloqueo);
				} else if(!RegistroUsuarioConstants.ESTATUS_BLOQUEO.equals(bloqueo.getEstatus())) {
					BloqueoUsuarioPulssar bloqueoNuevo = new BloqueoUsuarioPulssar();
					bloqueoNuevo.setIdentificadorUsuario(usuarioP.getIdentificador());
					bloqueoNuevo.setFcVigencia(null);
					bloqueoNuevo.setEstatus(RegistroUsuarioConstants.ESTATUS_BLOQUEO);
					bloqueoNuevo.setIntentos(NumerosConstants.INT_CERO);
					this.asignarValoresBloqueo(bloqueoNuevo, RegistroUsuarioConstants.USUARIO_BLOQUEO);
				}
			}
			return user;
		} catch (BusinessException be) {
			logger.error("Error de negocio en obtenerRolUsuario {}", be.getCodigo(), be);
		}
		return null;
	}
	
	/**
	 * Metodo encargado de obtener la imagen
	 * 
	 * @param usuario
	 * @return
	 */
	@Override
	public AgentePromotor obtenerDatosAgente(String usuario, String afore, List<UsuarioRol> listaRoles) {
		AgentePromotor agente = null;
		int i = 0;
		do {
			if(RolesEnum.AGENTE_VENTANILLA.getRol().equals(listaRoles.get(i).getRolUsuario().getClaveRol())) {
				DatosRegistro registro = new DatosRegistro();
				registro.setClaveAfore(afore);
				registro.setNumeroAgente(usuario);
				agente = servicioAgente.validarAgentePromotor(registro, true);
			}
			i++;
		} while(i < listaRoles.size() && utileriaValidador.validarObjetoNulo(agente));
		
		return agente;
	}
	
	/**
	 * Obtiene los roles asignados
	 * 
	 * @param roles
	 * @return
	 */
	private List<Rol> obtenerRolUsuarioLogin(List<UsuarioRol> roles) {
		List<Rol> listaRoles = new ArrayList<>();
		if(!utileriaValidador.validarListaVacia(roles)) {
			for(UsuarioRol usuarioRol : roles) {
				Rol rol = new Rol();
				rol.setIdRol(usuarioRol.getRolUsuario().getIdentificadorRol());
				rol.setClaveRol(usuarioRol.getRolUsuario().getClaveRol());
				rol.setClaveAfore(usuarioRol.getRolUsuario().getClaveAfore());
				rol.setDescripcionRol(usuarioRol.getRolUsuario().getDescripcionRol());
				listaRoles.add(rol);
			}
		}
		return listaRoles;
	}
	
	
	
	/**
	 * Metodo encargado de obtener el usuario pulssar
	 * 
	 * @param usuario
	 * @return
	 */
	private UsuarioPulssar obtenerUsuario(String usuario, List<String> estatus, boolean isUsuarioExiste) {
		List<UsuarioPulssar> listaUsuarios = repositorioUsuario.findUsuarioActivo(usuario, estatus);
		UsuarioPulssar usuarioPulssar = null;
		if(utileriaValidador.validarListaVacia(listaUsuarios)) {
			List<UsuarioNickPulssar> listaNickUsuario = repositorioUsuarioNick.findByNickUsuarioAndEstatus(usuario, NumerosConstants.INT_UNO);
			if(isUsuarioExiste && !utileriaValidador.validarListaVacia(listaNickUsuario)) {
				throw new BusinessException(BusinessErrorEnum.ERROR_USUARIO_EXISTENTE);
			} else if(!isUsuarioExiste) {
				if(utileriaValidador.validarListaVacia(listaNickUsuario)) {
					logger.info("Usuario inexistente: {}", usuario);
					throw new BusinessException(BusinessErrorEnum.ERROR_USUARIO_NO_EXISTE);
				}
				usuarioPulssar = repositorioUsuario.findOne(listaNickUsuario.get(NumerosConstants.INT_CERO).getIdentificadorUsuario());
			}
		} else {
			usuarioPulssar = listaUsuarios.get(NumerosConstants.INT_CERO);
		}
		
		return usuarioPulssar;
	}
	
	/**
	 * Valida el estatus del usuario
	 * 
	 * @param listaUsuarios
	 * @return
	 */
	private UsuarioPulssar validarEstatusUsuario(List<UsuarioPulssar> listaUsuarios) {
		UsuarioPulssar usuario = null;
		if(!utileriaValidador.validarListaVacia(listaUsuarios)) {
			usuario = listaUsuarios.get(NumerosConstants.INT_CERO);
			if(EstatusUsuarioEnum.USUARIO_REACTIVADO.getEstatusUsuario().equals(usuario.getEstatus())){
				throw new  BusinessException(BusinessErrorEnum.ESTATUS_USAURIO_REACTIVADO);
			}
			if(EstatusUsuarioEnum.USUARIO_BLOQUEADO.getEstatusUsuario().equals(usuario.getEstatus())) {
				List<BloqueoUsuarioPulssar> listaBloqueo = repositorioBloqueoUsuario.findByIdentificadorUsuarioOrderByIdentificadorBloqueoDesc(usuario.getIdentificador());
				if(!utileriaValidador.validarListaVacia(listaBloqueo)){
					BloqueoUsuarioPulssar bloqueoUsuarioPulssar = listaBloqueo.get(NumerosConstants.INT_CERO);
					this.validarFechaEstatusUsuario(bloqueoUsuarioPulssar, usuario);
				} else {
					throw new BusinessException(BusinessErrorEnum.ERROR_USUARIO_NO_ACTIVO);
				}
			} else if(!RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE.contains(usuario.getEstatus())) {
				throw new BusinessException(BusinessErrorEnum.ERROR_USUARIO_NO_ACTIVO);
			}
		}
		return usuario;
	}
	
	/**
	 * Metodo encargado de validar la lista de codigos
	 * 
	 * @param listaUsuarios
	 * @return
	 */
	private List<CodigoUsuario> validarListaUsuariosCodigo(List<UsuarioPulssar> listaUsuarios, String tipoCodigo) {
		List<CodigoUsuario> listaConsultaCodigo = null;
		if(!utileriaValidador.validarListaVacia(listaUsuarios)) {
			listaConsultaCodigo = repositorioCodigo.findByIdUsuarioAndTipoCodigo(listaUsuarios.get(0).getIdentificador(), tipoCodigo);
		}
		return listaConsultaCodigo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UsuarioPulssar> consultarBajaUsuario(String claveOrganizacion,List<String> estatus) {
		return repositorioUsuario.findByOrganizacion(claveOrganizacion,estatus);		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Usuarios> consultarUsuarioSinRol(String claveOrganizacion, String usuarioLogueado, List<String> estatus, boolean isActivo, boolean isAdmin) {
		List<Object[]> listaUsuarios = repositorioUsuario.findUsuariosSinRol(claveOrganizacion, estatus);
		List<Object[]> listaUsuariosRoles = this.obtenerUsuarioSinRol(listaUsuarios, claveOrganizacion, estatus, isAdmin);
		List<Usuarios> lista = null;
		if(!utileriaValidador.validarObjetoNulo(listaUsuariosRoles)) {
			lista = new ArrayList<>();
			Usuarios usuario;
			for(Object[] objeto : listaUsuariosRoles) {
				usuario = new Usuarios(objeto);
				if(!usuario.getUsuario().equals(usuarioLogueado)){
					this.llenarListaUsuarios(lista, usuario, isActivo);
				}
			}
		}
		return lista;
	}
	
	private List<Object[]> obtenerUsuarioSinRol(List<Object[]> listaUsuariosRoles, String claveOrganizacion, List<String> estatus, boolean isAdmin) {
		if(ActivacionConstants.CLAVE_SICI.equals(claveOrganizacion) && isAdmin) {
			List<Object[]> listaUsuarios = repositorioUsuario.findUsuariosSinRolSICI(estatus, RolesEnum.OPERATIVO_AFORE.getRol(), NumerosConstants.INT_UNO);
			if(!utileriaValidador.validarListaVacia(listaUsuarios)) {
				if(!utileriaValidador.validarListaVacia(listaUsuariosRoles)) {
					listaUsuariosRoles.addAll(listaUsuarios);
				} else {
					listaUsuariosRoles = listaUsuarios;
				}
			}
		}
		return listaUsuariosRoles;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Usuarios> consultarUsuariosCodigoVencido(String organizacion, String estatus, Integer estatusCodigo, String  tipoCodigo) {
		Date fechaHoy = new Date();
		List<Object[]> listaUsuarios = repositorioUsuario.findUsuariosSinRol(organizacion, Arrays.asList(estatus));
		List<Usuarios> lista = null;
		if(!utileriaValidador.validarObjetoNulo(listaUsuarios)) {
			lista = new ArrayList<>();
			Usuarios usuario;
			for(Object[] objeto : listaUsuarios) {
				usuario = new Usuarios(objeto);
				List<CodigoUsuario> resultadoCodigo = persistenciaCodigo.findByEstatusAndTipoCodigoOrderByFechaVigenciaDesc(usuario.getIdentificadorUsuario(), Arrays.asList(NumerosConstants.INT_CERO, NumerosConstants.INT_DOS), RegistroUsuarioConstants.TIPO_CODIGO_ALTA);
				if(!utileriaValidador.validarListaVacia(resultadoCodigo)){
					CodigoUsuario codigo = resultadoCodigo.get(NumerosConstants.INT_CERO);
					if(fechaHoy.after(codigo.getFechaVigencia())){
						lista.add(usuario);
					}
				}
			}
		}
		return lista;
	}
	
	/**
	 * Metodo encargado de llenar la lista de usuarios
	 * @param lista
	 * @param usuario
	 * @param isActivo
	 */
	private void llenarListaUsuarios(List<Usuarios> lista, Usuarios usuario, boolean isActivo) {
		if(isActivo) {
			List<UsuarioRol> rolesAsignados = repositorioUsuarioRol.findRolesById(usuario.getIdentificadorUsuario(), NumerosConstants.INT_UNO);
			if(utileriaValidador.validarListaVacia(rolesAsignados)) {
				lista.add(usuario);
			}
		} else {
			lista.add(usuario);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UsuariosModificar> consultarUsuariosRoles(String claveOrganizacion, String usuarioLogueado, Integer estatusRol, List<String> estatus) {
		List<Object[]> listaUsuarios = repositorioUsuario.findUsuariosConRol(claveOrganizacion, estatusRol, estatus);
		if(ActivacionConstants.CLAVE_SICI.equals(claveOrganizacion)) {
			List<Object[]> listaUsuariosSICI = consultarUsuarioOperativoSici(usuarioLogueado, estatusRol, estatus);
			if(!utileriaValidador.validarListaVacia(listaUsuariosSICI)) {
				listaUsuarios.addAll(listaUsuariosSICI);
			}
		}
		
		List<UsuariosModificar> lista = null;
		if(!utileriaValidador.validarObjetoNulo(listaUsuarios)){
			lista = new ArrayList<>();
			UsuariosModificar usuario;
			for(Object[] objeto : listaUsuarios){
				usuario = new UsuariosModificar(objeto);
				if(!usuario.getUsuario().equals(usuarioLogueado)){
					lista.add(usuario);
				}
			}
		}
		return lista;
	}
	
	/**
	 * Metodo encargado de obtener los usuarios de operatvio sici
	 * 
	 * @param usuarioLogueado
	 * @param estatusRol
	 * @param estatus
	 * @return
	 */
	private List<Object[]> consultarUsuarioOperativoSici(String usuarioLogueado, Integer estatusRol, List<String> estatus) {
		List<Object[]> listaUsuarios = repositorioUsuario.findUsuariosConRol(estatusRol, estatus, RolesEnum.OPERATIVO_AFORE.getRol());
		if(utileriaValidador.validarListaVacia(listaUsuarios)) {
			return null;
		}
		return listaUsuarios;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UsuariosModificar> consultarUsuarioModificar(String claveOrganizacion, String usuario, Integer estatusRol, List<String> estatus) {
		List<Object[]> listaUsuarios = repositorioUsuario.findUsuarioModificar(claveOrganizacion, estatusRol, estatus, usuario);
		List<UsuariosModificar> lista = null;
		if(!utileriaValidador.validarListaVacia(listaUsuarios)){
			lista = new ArrayList<>();
			UsuariosModificar usuarioMod;
			for(Object[] objeto : listaUsuarios){
				usuarioMod = new UsuariosModificar(objeto);
				lista.add(usuarioMod);
			}
		} else {
			listaUsuarios = repositorioUsuario.findUsuarioModificarSICI(estatusRol, estatus, usuario, RolesEnum.OPERATIVO_AFORE.getRol());
			if(!utileriaValidador.validarListaVacia(listaUsuarios)){
				lista = new ArrayList<>();
				UsuariosModificar usuarioMod;
				for(Object[] objeto : listaUsuarios){
					usuarioMod = new UsuariosModificar(objeto);
					lista.add(usuarioMod);
				}
			}
		}

		return lista;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio bajaUsuarios(List<String> usuario, String claveAfore, String usuarioBaja) {
		RespuestaServicio respuesta;
		if(!utileriaValidador.validarListaVacia(usuario)){
			int j = 0;
			for(String user : usuario) {
				UsuarioPulssar usuarioP = this.obtenerUsuarioPulssar(RegistroUsuarioConstants.ESTATUS_USUARIO_BAJA, user, claveAfore,NumerosConstants.INT_UNO);
				UsuarioNickPulssar usuarioNickBaja = null;
				if(!utileriaValidador.validarObjetoNulo(usuarioP) && !usuarioP.getUsuario().equals(user)) {
					usuarioNickBaja = repositorioUsuarioNick.findByIdUsuarioAndEstatus(user, NumerosConstants.INT_UNO);
				}
				j+= this.actualizarBajaUsuario(usuarioP, usuarioNickBaja, usuarioBaja);
			}

			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.USUARIOS_BAJA_CORRECTAMENTE.getClave(), claveAfore, NumerosConstants.INT_UNO, null);
			String mensaje = StringUtils.replace(respuesta.getMensaje(), RegistroUsuarioConstants.DATOS_RESPUESTA, String.valueOf(j));
			respuesta.setMensaje(mensaje);
		} else {
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.SELECCION_USUARIOS_BAJA.getClave(), claveAfore, NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * Revisa si un usuario se encuentra en usaurio pulssar o usuario nick
	 * 
	 * @param status
	 * @param usuario
	 * @param claveAfore
	 * @return
	 */
	private UsuarioPulssar obtenerUsuarioPulssar(List<String> status, String usuario, String claveAfore,Integer estatusNick) {
		logger.info("Busqueda de usuario pulssar {} {} {} {}", usuario, status, claveAfore, estatusNick);
		List<UsuarioPulssar> listaUsuariosBaja = repositorioUsuario.findByUsuarioAndEstatus(usuario, claveAfore, status);
		UsuarioPulssar usuarioAuxiliar;
		if(utileriaValidador.validarListaVacia(listaUsuariosBaja)) {
			UsuarioNickPulssar usuarioNick = repositorioUsuarioNick.findByIdUsuarioAndEstatus(usuario, estatusNick);
			usuarioAuxiliar = repositorioUsuario.findOne(usuarioNick.getIdentificadorUsuario());
		} else {
			usuarioAuxiliar = listaUsuariosBaja.get(NumerosConstants.INT_CERO);
		}
		return usuarioAuxiliar;
	}
	
	/**
	 * Metodo encargado de dar de baja un usuario
	 * 
	 * @param usuarioP
	 * @param usuarioNick
	 * @param usuarioBaja
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	private int actualizarBajaUsuario(UsuarioPulssar usuarioP, UsuarioNickPulssar usuarioNick, String usuarioBaja) {
		int valor = 0;
		try {
			if(!utileriaValidador.validarObjetoNulo(usuarioP)) {
				List<UsuarioRol> roles = repositorioUsuarioRol.findRolesById(usuarioP.getIdentificador(), NumerosConstants.INT_UNO);
				
				Date fecha = new Date();
				usuarioP.setEstatus(EstatusUsuarioEnum.USUARIO_BAJA.getEstatusUsuario());
				usuarioP.setFecha(fecha);
				usuarioP.setUsuarioModificador(usuarioBaja);
				repositorioUsuario.saveAndFlush(usuarioP);
				this.obtenerListaRolesOID(usuarioP.getUsuario(), roles);
				
				if(!utileriaValidador.validarObjetoNulo(usuarioNick)) {
					usuarioNick.setEstatus(NumerosConstants.INT_CERO);
					usuarioNick.setFecha(fecha);
					usuarioNick.setUsuarioModificador(usuarioBaja);
					repositorioUsuarioNick.saveAndFlush(usuarioNick);
				}
				
				this.actualizarValoresBajaUsuario(roles, fecha, usuarioBaja);
				valor = 1;
			}
		} catch(Exception e) {
			logger.error("Se presento un problema al momento de dar de baja el usuario {}", usuarioP, e);
		}
		return valor;
	}
	
	/**
	 * Metodo encargado de actualizar los valores de repositorio usuario rol
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	private void actualizarValoresBajaUsuario(List<UsuarioRol> roles, Date fecha, String usuarioBaja) {
		if(!utileriaValidador.validarListaVacia(roles)) {
			for(UsuarioRol rol : roles) {
				rol.setEstatus(NumerosConstants.INT_CERO);
				rol.setFecha(fecha);
				rol.setUsuarioModificador(usuarioBaja);
				repositorioUsuarioRol.saveAndFlush(rol);
			}
		}
	}
	
	/**
	 * Obtener la lista de roles
	 * 
	 * @param cadenaRoles
	 * @return
	 */
	private void obtenerListaRolesOID(String userName, List<UsuarioRol> roles) {
		if(!utileriaValidador.validarListaVacia(roles)) {
			List<UsuariosEnum> usuariosRoles = new ArrayList<>();
//			String parametroRoles = AgenteConstants.PARAMETRO_ROLES;
//			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(parametroRoles, "");
			//TODO
//			List<String> listaRoles = utileriaValidador.obtenerListaParametro(listaParametro, RolesConstants.PARAM_PERFILES_EDITAR_USUARIO_ADMIN, RolesConstants.PERFILES_ALTA_ADMIN);
//			UsuariosEnum usuario;
//			for(UsuarioRol rol : roles) {
//				if(listaRoles.contains(rol.getRolUsuario().getClaveRol())) {
//					usuario = UsuariosEnum.ADMINISTRADORES;
//				} else {
//					usuario = UsuariosEnum.USUARIOS;
//				}
//				
//				if(!usuariosRoles.contains(usuario)) {
//					usuariosRoles.add(usuario);
//				}
//			}
			servicioDirectorio.eliminarRoles(userName, usuariosRoles);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public RespuestaServicio asignarPerfil(List<String> cadenaUsuario, List<String> cadenaRol, List<UsuariosEnum> listaRoles, String claveAfore, String usuarioAsigna) {
		RespuestaServicio respuesta;
		if(!utileriaValidador.validarListaVacia(cadenaUsuario) && !utileriaValidador.validarListaVacia(cadenaRol)) {
			List<String> usuarios = cadenaUsuario;
			List<String> roles = cadenaRol;
			Date fecha = new Date();
			List<UsuarioRol> listaUsuariosRol = new ArrayList<>();
			List<UsuarioPulssar> listaUsuariosPulssar = new ArrayList<>();
			int i = 0;
			for(; i < usuarios.size(); i++) {
				UsuarioPulssar usuarioPulssar = this.obtenerUsuarioPulssar(Arrays.asList(EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario()), usuarios.get(i), claveAfore,NumerosConstants.INT_CERO);
				this.asignarPerfilUsuario(usuarioPulssar, roles, usuarioAsigna, listaUsuariosRol, listaRoles, claveAfore);
				usuarioPulssar.setEstatus(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
				usuarioPulssar.setFecha(fecha);
				usuarioPulssar.setUsuarioModificador(usuarioAsigna);
				listaUsuariosPulssar.add(usuarioPulssar);
				servicioDirectorio.activaDesactivaUsuario(usuarioPulssar.getUsuario(), true);
			}
			repositorioUsuarioRol.save(listaUsuariosRol);
			repositorioUsuario.save(listaUsuariosPulssar);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.PERFIL_ASIGNADO_CORRECTAMENTE.getClave(), claveAfore, NumerosConstants.INT_UNO, null);
			String mensaje = StringUtils.replace(respuesta.getMensaje(), RegistroUsuarioConstants.DATOS_RESPUESTA, String.valueOf(i));
			respuesta.setMensaje(mensaje);
		} else {
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.SELECCION_USUARIO_ROL.getClave(), claveAfore, NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
		
	/**
	 * Metodo encargado de dar de baja un usuario
	 * @param claveAfore
	 * @param usuarioP
	 * @param usuarioNick
	 * @param usuarioBaja
	 */
	private void asignarPerfilUsuario(UsuarioPulssar usuarioPulssar, List<String> roles, String usuarioAsigna, List<UsuarioRol> usuarioRol, List<UsuariosEnum> listaRoles, String claveAfore) {
		if(!utileriaValidador.validarObjetoNulo(usuarioPulssar)) {
			Date fechaAsignacion = new Date();
			UsuarioRol usuario;
			for(int i = 0; i < roles.size(); i++) {
				usuario = new UsuarioRol();
				usuario.setIdentificadorUsuario(usuarioPulssar.getIdentificador());
				usuario.setEstatus(NumerosConstants.INT_UNO);
				usuario.setFecha(fechaAsignacion);
				usuario.setUsuarioModificador(usuarioAsigna);				
				RolesCatalogo rolCatalogo= servicioRoles.buscarRolPorRolClaveAfore(roles.get(i), claveAfore);
				usuario.setRolUsuario(rolCatalogo);
				usuarioRol.add(usuario);
			}
			servicioDirectorio.asignarRoles(usuarioPulssar.getUsuario(), listaRoles);
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public RespuestaServicio modificarDatosUsuario(DatosRegistro usuarioVista, UsuariosModificar usuarioBD, List<String> roles, String claveAfore, String userModifica, String[] modulos) {
		RespuestaServicio respuesta = new RespuestaServicio();
		try {
			String cusuario = utileriaValidador.validarVacio(usuarioBD.getNickUsuario()) ? usuarioBD.getUsuario() : usuarioBD.getNickUsuario();
			String ccorreo = utileriaValidador.validarObjetoNulo(usuarioVista.getCorreo()) ? usuarioBD.getEmail() : usuarioVista.getCorreo();
			boolean isActualiza = false;
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.CARACTER_HOMOLOGADO, "");
			
			if(!utileriaValidador.validarEsNumerica(cusuario, null)) {
				if(utileriaValidador.validarVacio(usuarioBD.getNickUsuario())) {
					String caracterHomologado = ExpresionesConstants.VALOR_PARAMETRO;
					if(!utileriaValidador.validarListaVacia(listaParametro)) {
						caracterHomologado = listaParametro.get(0).getChValorParametro();
					}
					utileriaCadena.validarCadenasIguales(cusuario, ccorreo.trim(), BusinessErrorEnum.ESTRUCTURA_USUARIO_CORREO, caracterHomologado);
				}
			}
			
			if(!usuarioVista.getCelular().trim().equals(usuarioBD.getCelular())) {
				List<UsuarioPulssar> usuarioCelular = repositorioUsuario.findByCelular(usuarioVista.getCelular().trim(), RegistroUsuarioConstants.ESTATUS_USUARIOS);
				servicioValidarAlta.validarListaUsuariosCodigo(RegistroUsuarioConstants.CADENA_CELULAR, usuarioVista.getCelular().trim(), usuarioCelular, RegistroUsuarioConstants.TIPO_CODIGO_ALTA, BusinessErrorEnum.ERROR_CELULAR_EXISTENTE);
				servicioValidarAlta.validarCelularEmail(usuarioVista.getCelular().trim(), BusinessErrorEnum.ERROR_CELULAR_EXISTENTE, NumerosConstants.INT_UNO);
				isActualiza = true;
			}
			
			if(!ccorreo.trim().equals(usuarioBD.getEmail())) {
				List<UsuarioPulssar> usuarioCorreo = repositorioUsuario.findByEmail(usuarioVista.getCorreo().trim(), RegistroUsuarioConstants.ESTATUS_USUARIOS);
				servicioValidarAlta.validarListaUsuariosCodigo(RegistroUsuarioConstants.CADENA_CORREO, ccorreo.trim(), usuarioCorreo, RegistroUsuarioConstants.TIPO_CODIGO_ALTA, BusinessErrorEnum.ERROR_CORREO_EXISTENTE);
				servicioValidarAlta.validarCelularEmail(ccorreo.trim(), BusinessErrorEnum.ERROR_CORREO_EXISTENTE, NumerosConstants.INT_DOS);
				isActualiza = true;
			}
			
			String employeeType = servicioDirectorio.obtenerEmployeeType(cusuario);
			if(!utileriaValidador.validarVacio(employeeType) || !utileriaValidador.validarObjetoNulo(modulos)) {
				isActualiza = true;
			}
			
			servicioDirectorio.actualizarCelularCorreoPerfil(cusuario, ccorreo, usuarioVista.getCelular(), utileriaValidador.validarObjetoNulo(modulos) ? null : Arrays.asList(modulos), isActualiza);
			
			Date fecha = new Date();
			UsuarioPulssar registroUsuario = new UsuarioPulssar();
			registroUsuario.setIdentificador(usuarioBD.getIdentificadorUsuario());
			registroUsuario.setUsuario(usuarioBD.getUsuario());
			registroUsuario.setNombre(usuarioVista.getNombre());
			registroUsuario.setApellidoPaterno(usuarioVista.getApellidoPaterno());
			registroUsuario.setApellidoMaterno(usuarioVista.getApellidoMaterno());
			registroUsuario.setEmail(ccorreo);
			registroUsuario.setCelular(usuarioVista.getCelular());
			registroUsuario.setClaveOrganizacion(usuarioBD.getClaveOrganizacion());
			registroUsuario.setEstatus(usuarioBD.getEstatus());
			registroUsuario.setFecha(fecha);
			registroUsuario.setUsuarioModificador(userModifica);
			registroUsuario.setChSucursal(usuarioVista.getClaveSucursal());
			registroUsuario.setChOficina(usuarioVista.getClaveOficina());
			registroUsuario.setZona(utileriaValidador.validarObjetoNulo(usuarioVista.getNombreZona()) ? null : Long.parseLong(usuarioVista.getNombreZona()));
			
			List<UsuarioRol> rolesUsuario = new ArrayList<>();
			List<RolesCatalogo> lista = servicioRoles.buscarRolPorAfore(claveAfore);
			List<UsuarioRol> rolesAsociados = repositorioUsuarioRol.findRolesById(usuarioBD.getIdentificadorUsuario(), NumerosConstants.INT_UNO);
			rolesUsuario.addAll(this.agregarQuitarRoles(rolesAsociados, roles, fecha, userModifica));
			rolesUsuario.addAll(this.agregarRoles(roles, lista, usuarioBD.getIdentificadorUsuario(), fecha, userModifica, rolesAsociados));
			
			repositorioUsuarioRol.save(rolesUsuario);
			repositorioUsuario.saveAndFlush(registroUsuario);
			
			respuesta = servicioCatalogo.obtenerRespuesta(null ,MensajesExitoEnum.USUARIO_MODIFICADO_CORRECTAMENTE.getClave(), claveAfore, NumerosConstants.INT_UNO, null);
		} catch(BusinessException be) {
			logger.error("BusinessException en modificarDatosUsuario codigo: {}", be.getCodigo(), be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), claveAfore, NumerosConstants.INT_DOS, null);
		} catch (Exception e) {
			logger.error("Exception no controlodara en modificarDatosUsuario", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), claveAfore, NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	
	/**
	 * Metodo encargado de validar la url de la llave
	 * 
	 * @param urlServicio
	 * @return
	 */
	private List<String> obtenerDesencriptacionUrlKey(String urlServicio) {
		String resultado = encriptacionUtils.obtieneDesencriptacion(urlServicio, keySeguridadEncriptacion);
		String[] partes = resultado.split(AgenteConstants.COMA);
		
		if(NumerosConstants.INT_TRES != partes.length) {
			throw new BusinessException(BusinessErrorEnum.URL_DATOS_ERRONEOS);
		}
		
		return Arrays.asList(partes);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio validarActivacionUsuario(String urlServicio, DatosRegistro datosEntrada, boolean isValidarUsuario) {
		RespuestaServicio respuesta = new RespuestaServicio();
		String auxiliarAfore = ActivacionConstants.CLAVE_PROCESAR;
		UsuarioPulssar usuarioP = null;
		try {
			List<String> listaDesencriptada = this.obtenerDesencriptacionUrlKey(urlServicio);
			String estatus = RegistroUsuarioConstants.TIPO_CODIGO_ALTA.equals(listaDesencriptada.get(NumerosConstants.INT_DOS)) ? EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario() : EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario();
			
			String usuario = listaDesencriptada.get(NumerosConstants.INT_CERO);
			
			this.validarDatosIncongruentes(datosEntrada, isValidarUsuario, usuario);
			
			if(!utileriaValidador.validarVacio(usuario)) {
				usuarioP = this.obtenerUsuarioDatos(usuario, estatus);
				CodigoUsuario codigoUsuario = this.validarUrlKey(listaDesencriptada, usuarioP.getIdentificador(), new Date());
				respuesta = this.validarCodigoIngresado(codigoUsuario, listaDesencriptada.get(NumerosConstants.INT_DOS), datosEntrada, codigoUsuario.getIntentos(), usuarioP);
				if(utileriaValidador.validarObjetoNulo(respuesta.getFlujo())) {
					respuesta.setMensaje(usuario);
				}
			} else {
				logger.error("BusinessException: ", "Datos incongruentes");
				throw new BusinessException(BusinessErrorEnum.URL_DATOS_ERRONEOS);
			}
		} catch(BusinessException be){
			logger.error("BusinessException validarActivacionUsuario codigo: {}",be.getCodigo(), be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), this.obtenerClaveOrganizacion(usuarioP, auxiliarAfore), NumerosConstants.INT_DOS, null);
		} catch(GenericException ge){
			logger.error("GenericException codigo: {}", ge.getCodigo(), ge);
			respuesta = servicioCatalogo.obtenerRespuesta(null, ge.getCodigo(), this.obtenerClaveOrganizacion(usuarioP, auxiliarAfore), NumerosConstants.INT_CUATRO, null); 
		} catch (Exception e) {
			logger.error("Exception no controlada en validarActivacionUsuario", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), auxiliarAfore, NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * Metodo encargado de validar datos incongruentes en la url
	 * 
	 * @param datosEntrada
	 * @param isValidarUsuario
	 * @param usuario
	 */
	private void validarDatosIncongruentes(DatosRegistro datosEntrada, boolean isValidarUsuario, String usuario) {
		if(isValidarUsuario && !usuario.equals(datosEntrada.getNickUsuario())) {
			logger.error("BusinessException: ", "Datos incongruentes");
			throw new BusinessException(BusinessErrorEnum.URL_DATOS_ERRONEOS);
		}
	}
	
	/**
	 * Metodo encargado de obtener la clave de afore para la consulta del error
	 * 
	 * @param usuarioP
	 * @param claveAfore
	 * @return
	 */
	private String obtenerClaveOrganizacion(UsuarioPulssar usuarioP, String claveAfore) {
		String auxiliarAfore = claveAfore;
		if(!utileriaValidador.validarObjetoNulo(usuarioP)) {
			auxiliarAfore = usuarioP.getClaveOrganizacion();	
		}
		return auxiliarAfore;
	}
	
	/**
	 * Metodo encargado de obtener el usuario para una activacion o modificacion
	 * @param usuario
	 * @param estatus
	 * @return
	 */
	private UsuarioPulssar obtenerUsuarioDatos(String usuario, String estatus) {
		List<UsuarioPulssar> auxiliarPulssar = repositorioUsuario.findUsuarioByUsuarioAndEstatus(usuario, estatus);
		UsuarioPulssar usuarioP = null;
		if(utileriaValidador.validarListaVacia(auxiliarPulssar)) {
			UsuarioNickPulssar usuarioNick = repositorioUsuarioNick.findByIdUsuarioAndEstatus(usuario, NumerosConstants.INT_UNO);
			if(!utileriaValidador.validarObjetoNulo(usuarioNick)) {
				usuarioP = repositorioUsuario.findOne(usuarioNick.getIdentificadorUsuario());
			}
		} else {
			usuarioP = auxiliarPulssar.get(NumerosConstants.INT_CERO);
		}
		return usuarioP;
	}
	
	/**
	 * Valida el numero de intentos del codigo antes de ser bloqueado
	 * 
	 * @param codigoUsuario
	 * @param datosEntrada
	 */
	private RespuestaServicio validarCodigoIngresado(CodigoUsuario codigoUsuario, String tipo, DatosRegistro datosEntrada, int contador, UsuarioPulssar usuarioP) {
		RespuestaServicio servicioRespuesta = new RespuestaServicio();
		if(!utileriaValidador.validarObjetoNulo(datosEntrada)) {
			Date fechaUso = new Date();
			if(codigoUsuario.getCodigo().equals(datosEntrada.getCodigo())) {
				this.validarTipoCodigo(datosEntrada, tipo);
				this.guardarCodigo(codigoUsuario, NumerosConstants.INT_UNO, contador, datosEntrada.getNickUsuario(), fechaUso);
				this.actualizarUsuarioPulssar(usuarioP, fechaUso);
				servicioRespuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.USUARIO_ACTIVADO_CORRECTAMENTE.getClave(), usuarioP.getClaveOrganizacion(), NumerosConstants.INT_UNO, null);
			} else {
				boolean isBloqueado = this.guardarCodigo(codigoUsuario, NumerosConstants.INT_TRES, contador, datosEntrada.getNickUsuario(), fechaUso);
				if(!isBloqueado) {
					throw new GenericException(GenericErrorEnum.CODIGO_NO_VALIDO);
				}
				throw new BusinessException(BusinessErrorEnum.CODIGO_USUARIO_BLOQUEADO);
			}
		}
		return servicioRespuesta;
	}
	
	/**
	 * Metodo encargado de actualizar el usuario activo
	 * @param usuarioP
	 * @return
	 */
	@Transactional
	private void actualizarUsuarioPulssar(UsuarioPulssar usuarioP, Date fecha) {
		UsuarioPulssar auxiliar = usuarioP;
		auxiliar.setEstatus(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
		auxiliar.setFecha(fecha);
		auxiliar.setUsuarioModificador(RegistroUsuarioConstants.USUARIO_ALTA);
		
		repositorioUsuario.saveAndFlush(auxiliar);
	}
	
	/**
	 * Valida tipo de codigo
	 * 
	 * @param datosEntrada
	 * @param tipo
	 */
	private void validarTipoCodigo(DatosRegistro datosEntrada, String tipo) {
		try {
			servicioDirectorio.activaDesactivaUsuario(datosEntrada.getNickUsuario(), true);
			if(RegistroUsuarioConstants.TIPO_CODIGO_ALTA.equals(tipo)) {
				servicioDirectorio.recuperaContrasenia(datosEntrada.getNickUsuario(), datosEntrada.getPassword());
			} else {
				DatosRegistro auxiliar = new DatosRegistro();
				auxiliar.setNumeroAgente(datosEntrada.getNickUsuario());
				auxiliar.setPasswordActual(datosEntrada.getPasswordActual());
				auxiliar.setPassword(datosEntrada.getPassword());
				servicioDirectorio.cambioContrasenia(auxiliar, BusinessErrorEnum.ERROR_PASSWORD_INCORRECTO);
			}
		} catch(GenericException ge) {
			logger.error("Generic exception {}", ge.getCodigo(), ge);
			throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
		}
	}
	
	/**
	 * Metodo encargado de actualizar el codigo
	 * 
	 * @param codigoUsuario
	 * @param flujo
	 * @param contador
	 * @param usuarioModificador
	 * @param fechaUso
	 */
	@Transactional
	private boolean guardarCodigo(CodigoUsuario codigoUsuario, int flujo, int contador, String usuarioModificador, Date fechaUso) {
		String parametroIntentos = AgenteConstants.PARAMETRO_CODIGO;
		List<Parametro> listaParametroDias = servicioCatalogo.obtenerParametro(parametroIntentos, "");
		String intentos = utileriaValidador.obtenerValorParametro(listaParametroDias, RegistroUsuarioConstants.INTENTOS, NumerosConstants.INT_TRES.toString());
		Integer intento = Integer.parseInt(intentos);
		Integer contadorFinal = contador;
		boolean isBloqueado = false;
		
		if(flujo == NumerosConstants.INT_UNO.intValue()) {
			codigoUsuario.setEstatus(flujo);
			codigoUsuario.setFechaUso(fechaUso);
		} else if(intento.intValue() == contadorFinal) {
			codigoUsuario.setEstatus(flujo);
			isBloqueado = true;
		} else {
			codigoUsuario.setIntentos(++contadorFinal);
		}
		
		codigoUsuario.setFecha(fechaUso);
		codigoUsuario.setUsuario(usuarioModificador);
		persistenciaCodigo.saveAndFlush(codigoUsuario);
		
		return isBloqueado;
	}
	
	/**
	 * Metodo encargado de validar estatus de codigo
	 * 
	 * @param listaDesencriptada
	 * @param idUsuario
	 * @param fechaActual
	 */
	private CodigoUsuario validarUrlKey(List<String> listaDesencriptada, Long idUsuario, Date fechaActual) {
		String folio = listaDesencriptada.get(NumerosConstants.INT_UNO);
		String tipoC = listaDesencriptada.get(NumerosConstants.INT_DOS);
		List<CodigoUsuario> resultadoCodigo = repositorioCodigo.findByIdUsuarioAndFolioAndTipo(idUsuario, folio, tipoC);
		BusinessErrorEnum error;
		if(utileriaValidador.validarListaVacia(resultadoCodigo)) {
			logger.info("Codigo no encontrado: {} {} {}", idUsuario, folio, tipoC);
			error = BusinessErrorEnum.URL_DATOS_ERRONEOS;
		} else {
			error = this.validarEstatusCodigo(resultadoCodigo.get(NumerosConstants.INT_CERO), folio, tipoC, idUsuario, fechaActual);
		}
		
		if(!utileriaValidador.validarObjetoNulo(error)) {
			throw new BusinessException(error);
		}
		
		return resultadoCodigo.get(NumerosConstants.INT_CERO);
	}
	
	/**
	 * Metodo encargado de validar el estatus del codigo
	 * 
	 * @param codigo
	 * @param folio
	 * @param tipoC
	 * @param idUsuario
	 * @param fechaActual
	 * @return
	 */
	@Transactional
	private BusinessErrorEnum validarEstatusCodigo(CodigoUsuario codigo, String folio, String tipoC, Long idUsuario, Date fechaActual) {
		BusinessErrorEnum error = null;
		if(NumerosConstants.INT_CERO == codigo.getEstatus()) {
			if(fechaActual.after(codigo.getFechaVigencia())) {
				codigo.setFechaUso(null);
				codigo.setEstatus(NumerosConstants.INT_DOS);
				codigo.setFecha(new Date());
				codigo.setUsuario(RegistroUsuarioConstants.USUARIO_VENCIDO);
				repositorioCodigo.saveAndFlush(codigo);
				logger.info("Codigo vencido: {} {} {}", idUsuario, folio, tipoC);
				error = BusinessErrorEnum.CODIGO_USUARIO_VENCIDO;
			}
		} else if (NumerosConstants.INT_UNO == codigo.getEstatus()) {
			logger.info("Codigo usuado: {} {}", idUsuario, folio, tipoC);
			error = BusinessErrorEnum.CODIGO_USUARIO_USADO;
		} else if (NumerosConstants.INT_DOS == codigo.getEstatus()) {
			logger.info("Codigo vencido: {} {} {}", idUsuario, folio, tipoC);
			error = BusinessErrorEnum.CODIGO_USUARIO_VENCIDO;
		} else {
			logger.info("Codigo bloqueado: {} {} {}", idUsuario, folio, tipoC);
			error = BusinessErrorEnum.CODIGO_USUARIO_BLOQUEADO;
		}
		
		return error;
	}
	
	/**
	 * Agrega roles a un trabajador
	 * @param rolSeleccionado
	 * @param rol
	 * @param claveAfore
	 * @param usuarioRol
	 */
	private List<UsuarioRol> agregarRoles(List<String> rolSeleccionado, List<RolesCatalogo> roles, Long identificador, Date fecha, String usuarioModifica, List<UsuarioRol> rolesAsociados) {
		List<UsuarioRol> rolesUsuario = new ArrayList<>();
		List<String> rolesNuevos = new ArrayList<>();
		for(UsuarioRol rolUsuario : rolesAsociados) {
			if(!rolSeleccionado.contains(rolUsuario.getRolUsuario().getClaveRol())) {
				for(RolesCatalogo rol : roles) {
					if(rolSeleccionado.contains(rol.getClaveRol()) && !rolesNuevos.contains(rol.getClaveRol())) {
						UsuarioRol usuario = new UsuarioRol();
						usuario.setIdentificadorUsuario(identificador);
						usuario.setEstatus(NumerosConstants.INT_UNO);
						usuario.setFecha(fecha);
						usuario.setUsuarioModificador(usuarioModifica);
						usuario.setRolUsuario(rol);
						rolesUsuario.add(usuario);
						rolesNuevos.add(rol.getClaveRol());
					}
				}
			}
		}
		return rolesUsuario;
	}
	
	/**
	 * Agrega roles a un trabajador
	 * 
	 * @param usuarioRol
	 * @param rolSeleccionado
	 * @param rol
	 */
	private List<UsuarioRol> agregarQuitarRoles(List<UsuarioRol> roles, List<String> rolSeleccionado, Date fecha, String usuarioModifica) {
		List<UsuarioRol> rolesUsuario = new ArrayList<>();
		for(UsuarioRol rol : roles) {
			if(!rolSeleccionado.contains(rol.getRolUsuario().getClaveRol())) {
				rol.setEstatus(NumerosConstants.INT_CERO);
				rol.setFecha(fecha);
				rol.setUsuarioModificador(usuarioModifica);
				rolesUsuario.add(rol);
			}
		}
		return rolesUsuario;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CorreoCorporativo> obtenerCorreosCorporativos(String claveAfore) {
		List<CorreoCorporativo> listaCorreo;
		listaCorreo = repositorioCorreoCorporativo.findByClaveOrganizacion(claveAfore);
		if(utileriaValidador.validarListaVacia(listaCorreo)){
			listaCorreo = null;
		}

		return listaCorreo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CorreoCorporativo> obtenerCorreosExistentes(String claveAfore, String email) {
		List<CorreoCorporativo> listaCorreo;
		listaCorreo = repositorioCorreoCorporativo.findByClaveOrganizacionAndEmail(claveAfore, email);
		if(utileriaValidador.validarListaVacia(listaCorreo)){
			listaCorreo = null;
		}
		return listaCorreo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public RespuestaServicio guardarCorreos(DatosOrganizacion correo, UsuarioLogin usuario, String claveAfore) {
		RespuestaServicio respuesta = new RespuestaServicio();
		String email = correo.getEmail();
		String arroba = ActivacionConstants.ARROBA;
		String correoConcatenado = utileriaCadena.obtenerCadenaConcatenada(true, arroba, email);
		Date fechaActual = new Date();
		try {
			List<CorreoCorporativo> listacorreos = repositorioCorreoCorporativo.findByClaveOrganizacionAndEmailAndEstatus(claveAfore, correoConcatenado, NumerosConstants.INT_UNO);
			
			if(utileriaValidador.validarListaVacia(listacorreos)) {
				CorreoCorporativo registro = new CorreoCorporativo();
				registro.setClaveOrganizacion(claveAfore);
				registro.setEmail(correoConcatenado);
				registro.setEstatus(NumerosConstants.INT_UNO);
				registro.setFecha(fechaActual);
				registro.setUsuario(usuario.getUsuario());
				repositorioCorreoCorporativo.save(registro);
			}
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.CORREO_REGISTRADO_CORRECTAMENTE.getClave(), usuario.getAforeUsuario(), NumerosConstants.INT_UNO, null);
		} catch(Exception e){
			logger.error("error al guardar correo", e);
		}
		
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CorreoCorporativo> listaCorreos(String clave){
		return repositorioCorreoCorporativo.findByClaveOrganizacion(clave);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio editarCorreos(DatosOrganizacion correo, UsuarioLogin usuario, String[] correos, List<CorreoCorporativo> listaCorreos) {
		RespuestaServicio respuesta = new RespuestaServicio();
		Date fechaActual = new Date();
		try {
			if(!utileriaValidador.validarListaVacia(listaCorreos)) {
				for(CorreoCorporativo correoC : listaCorreos) {
					String auxiliarCorreo = null;
					int i = 0;
					do {
						if(correoC.getEmail().equals(correos[i])) {
							auxiliarCorreo = correos[i];
						}
						i++;
					} while(i < correos.length && utileriaValidador.validarObjetoNulo(auxiliarCorreo));
					this.actualizarCorreo(auxiliarCorreo, correoC, fechaActual, usuario.getUsuario());
				}
				respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.CORREO_ACTUALIZADO_CORRECTAMENTE.getClave(), usuario.getAforeUsuario(), NumerosConstants.INT_UNO, null);
			}
		} catch(Exception e) {
			logger.error("Error al actualizar correos corporativos", e);
		}
		return respuesta;
		
	}
	
	/**
	 * Metodo encargado de actualizar el correo en caso de encontrarlo o no
	 * 
	 * @param correoAuxiliar
	 * @param correo
	 */
	@Transactional
	private void actualizarCorreo(String correoAuxiliar, CorreoCorporativo correo, Date fechaActual, String usuario) {
		Integer estatus = NumerosConstants.INT_UNO;
		if(utileriaValidador.validarObjetoNulo(correoAuxiliar)) {
			estatus = NumerosConstants.INT_CERO;
		}
		
		if(estatus != correo.getEstatus()) {
			correo.setEstatus(estatus);
			correo.setFecha(fechaActual);
			correo.setUsuario(usuario);
			repositorioCorreoCorporativo.saveAndFlush(correo);
		}
	}
	
	/**
	 * Metodo encargado de buscar agente
	 */
	@Override
	public AgentePromotor buscarUsuarioNick(String claveAfore, String usuario) {
		DatosRegistro registro = new DatosRegistro();
		AgentePromotor agente = null;
		try{
			List<UsuarioPulssar> lstUsuario = repositorioUsuario.findUsuarioActivo(usuario, RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE);
			UsuarioPulssar resultadoUsuario;
			UsuarioNickPulssar resultadoNick;
			if(utileriaValidador.validarListaVacia(lstUsuario)){
				resultadoNick = repositorioUsuarioNick.findByIdUsuarioAndEstatus(usuario, NumerosConstants.INT_UNO);
				if(utileriaValidador.validarObjetoNulo(resultadoNick)){
					throw new BusinessException(BusinessErrorEnum.NICK_AGENTE_NO_EXISTE);
				}
				resultadoUsuario = repositorioUsuario.findByIdAndEstatus(resultadoNick.getIdentificadorUsuario(), RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE);
			} else {
				resultadoUsuario = lstUsuario.get(NumerosConstants.INT_CERO);
			}
			registro.setClaveAfore(claveAfore);
			registro.setNumeroAgente(resultadoUsuario.getUsuario());		
			agente = servicioAgente.validarAgentePromotor(registro, true);
			agente.setIdentificador(resultadoUsuario.getIdentificador());
		} catch(BusinessException be) {
			logger.error("BusinessException buscarUsuarioNick", be);
			agente = new AgentePromotor();
			agente.setCodigoOperacion(be.getCodigo());
		}
		
		return agente;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void modificarEstatus(UsuarioLogin usuario) {
		UsuarioPulssar usuarioPulssar = null;
		Date fechaHoy = new Date();
		try{
			if(!utileriaValidador.validarObjetoNulo(usuario)){
				usuarioPulssar = this.obtenerUsuarioDatos(usuario.getUsuario(), EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario()); 
				if(!utileriaValidador.validarObjetoNulo(usuarioPulssar)){
					usuarioPulssar.setEstatus(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
					usuarioPulssar.setFecha(fechaHoy);
					usuarioPulssar.setUsuarioModificador(usuario.getUsuario());
					repositorioUsuario.saveAndFlush(usuarioPulssar);					
				}
			}
		}catch(Exception e){
			logger.error("Error al actualizar el estatus del usuario", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public RespuestaServicio buscarBloqueoUsuario(String salidaSpring) {
		BusinessErrorEnum error = BusinessErrorEnum.USUARIO_PASSWORD_INCORRECTO;
		RespuestaServicio respuesta;
		String minutos = null;
		BloqueoUsuarioPulssar usuarioBloqueado = new BloqueoUsuarioPulssar();
		Date fechaVigencia = null;
		String estatusBloqueo = RegistroUsuarioConstants.ESTATUS_BLOQUEO;
		Integer intentos = NumerosConstants.INT_UNO;
		
		String usuario = this.validarMensajeSpring(salidaSpring);
		UsuarioPulssar usuarioPulssar = this.obtenerUsuario(usuario, RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE, false);
		
		List<BloqueoUsuarioPulssar> listaBloqueo = repositorioBloqueoUsuario.findByIdentificadorUsuarioOrderByIdentificadorBloqueoDesc(usuarioPulssar.getIdentificador());
		if(!utileriaValidador.validarListaVacia(listaBloqueo)) {
			String parametroLimite;
			parametroLimite = AgenteConstants.PARAMETRO_LIMITE_INTENTOS;
			List<Parametro> resultadoParametro = servicioCatalogo.obtenerParametro(parametroLimite, "");
			String valorIntentos = utileriaValidador.obtenerValorParametro(resultadoParametro, RegistroUsuarioConstants.BLOQUEADO_TEMPORALMENTE, RegistroUsuarioConstants.INTENTOS_TIEMPO);
			String [] intentosTiempo = valorIntentos.split(AgenteConstants.COMA);
			usuarioBloqueado = listaBloqueo.get(NumerosConstants.INT_CERO);
			intentos = usuarioBloqueado.getIntentos() + NumerosConstants.INT_UNO;
			fechaVigencia = usuarioBloqueado.getFcVigencia();
			Integer limite = Integer.parseInt(intentosTiempo[0]);
			boolean tipoEstatus = false;
			estatusBloqueo = usuarioBloqueado.getEstatus();
			if(RegistroUsuarioConstants.ESTATUS_BLOQUEO_PRIMER_BLOQUEO.equals(usuarioBloqueado.getEstatus())) {
				List<Parametro> resultadoParametroPermanente = servicioCatalogo.obtenerParametro(parametroLimite, "");
				String valorIntentosPermanente = utileriaValidador.obtenerValorParametro(resultadoParametroPermanente, RegistroUsuarioConstants.BLOQUEADO_PERMANENTE, RegistroUsuarioConstants.INTENTOS_PERMANENETE);
				limite = Integer.parseInt(valorIntentosPermanente);
				tipoEstatus = true;
			}
			
			if(intentos >= limite) {
				usuarioBloqueado.setIntentos(intentos);
				usuarioPulssar.setEstatus(EstatusUsuarioEnum.USUARIO_BLOQUEADO.getEstatusUsuario());
				repositorioUsuario.saveAndFlush(usuarioPulssar);
				
				error = BusinessErrorEnum.USUARIO_BLOQUEADO_TEMPORALMENTE;
				estatusBloqueo = RegistroUsuarioConstants.ESTATUS_BLOQUEO_PRIMER_BLOQUEO;
				fechaVigencia = utileriaFecha.sumaMinutos(new Date(), Integer.parseInt(intentosTiempo[1]));
				intentos = 0;
				if(tipoEstatus && !consultaUsuarioAdministrador(usuario)) {
					estatusBloqueo = RegistroUsuarioConstants.ESTATUS_BLOQUEO_SEGUNDO_BLOQUEO;
					fechaVigencia = usuarioBloqueado.getFcVigencia();
					intentos = usuarioBloqueado.getIntentos();
					error = BusinessErrorEnum.USUARIO_BLOQUEADO_PERMANENTE;
				}
			}
		}
		
		usuarioBloqueado.setIdentificadorUsuario(usuarioPulssar.getIdentificador());
		usuarioBloqueado.setFcVigencia(fechaVigencia);
		usuarioBloqueado.setEstatus(estatusBloqueo);
		usuarioBloqueado.setIntentos(intentos);
		this.asignarValoresBloqueo(usuarioBloqueado, RegistroUsuarioConstants.USUARIO_BLOQUEO);
		if(BusinessErrorEnum.USUARIO_BLOQUEADO_TEMPORALMENTE.equals(error)){
			Date fechaHoy = new Date();
			minutos = utileriaFecha.diferenciaMinutos(fechaHoy, usuarioBloqueado.getFcVigencia());
		}
		respuesta = servicioCatalogo.obtenerRespuesta(null, error.getClave(), ActivacionConstants.CLAVE_PROCESAR, NumerosConstants.INT_DOS,minutos);

		
		return respuesta;
	}
	
	/**
	 * Obtiene usuario del mensaje de springSecurity
	 * 
	 * @param salida
	 * @return
	 */
	private String validarMensajeSpring(String salida) {
		String usuario = ExpresionesConstants.VACIO;
		String auxiliarSalida = utileriaCadena.obtenerContenidoCadenaSinEspacios(salida, ExpresionesConstants.VACIO);
		if(auxiliarSalida.contains(ServiciosConstants.CREDENCIALES_USUARIO_VALIDO) || auxiliarSalida.contains(ServiciosConstants.CREDENCIALES_USUARIO_VALIDO_PARAMETRO)) {
			String caracter = ExpresionesConstants.DOS_PUNTOS;
			if(auxiliarSalida.contains(ServiciosConstants.CREDENCIALES_USUARIO_VALIDO_PARAMETRO)) {
				caracter = ExpresionesConstants.TEXTO_CREDENCIALES;
			}
			String[] cadenaSplit = auxiliarSalida.split(caracter);
			usuario = utileriaCadena.obtenerContenidoCadenaSinEspacios(cadenaSplit[NumerosConstants.INT_UNO], ExpresionesConstants.VACIO);
		}
		return usuario;
	}
	
	/**
	 * Metodo encargado de consultar
	 * @param usuario
	 * @param isActivo
	 * @return
	 */
	private boolean consultaUsuarioAdministrador(String usuario) {
		List<Object[]> respuestaUsuario = repositorioUsuario.findUsuariosRoles(usuario);
		boolean superAdmin = false;
		if(!utileriaValidador.validarObjetoNulo(respuestaUsuario)) {
			UsuariosConsultaRol usuarioEcontrado;
			for(Object[] objeto : respuestaUsuario) {
				usuarioEcontrado = new UsuariosConsultaRol(objeto);
				if(RolesEnum.SUPER_ADMINISTRADOR.getRol().equals(usuarioEcontrado.getClaveRol())) {
					superAdmin = true;
				}
			}
		}
		return superAdmin;
	}
	
	/**
	 * Metodo encargado de asignar valores a registro de bloqueo
	 * @param usuarioBloqueado
	 * @param lista
	 * @param fechaVigencia
	 * @param fechaControl
	 * @param estatus
	 * @param intentos
	 * @return
	 */
	@Transactional
	private void asignarValoresBloqueo(BloqueoUsuarioPulssar usuarioBloqueado, String usuario) {
		BloqueoUsuarioPulssar auxiliarUsuario = usuarioBloqueado;
		auxiliarUsuario.setFcControl(new Date());
		auxiliarUsuario.setUsuarioModificador(usuario);
		repositorioBloqueoUsuario.save(auxiliarUsuario);
	}
	
	/**
	 * Metodo encargalo de validar fecha de vigencia de bloqueo y estatus
	 * @param bloqueoUsuarioPulssar
	 * @param listaUsuarios
	 */
	@Transactional
	private void validarFechaEstatusUsuario(BloqueoUsuarioPulssar bloqueoUsuarioPulssar, UsuarioPulssar usuario){
		Date fechaHoy = new Date();
		
		if(RegistroUsuarioConstants.ESTATUS_BLOQUEO_SEGUNDO_BLOQUEO.equals(bloqueoUsuarioPulssar.getEstatus())) {
			throw new BusinessException(BusinessErrorEnum.USUARIO_BLOQUEADO_PERMANENTE);
		} else if(RegistroUsuarioConstants.ESTATUS_BLOQUEO_PRIMER_BLOQUEO.equals(bloqueoUsuarioPulssar.getEstatus())) {
			if(fechaHoy.before(bloqueoUsuarioPulssar.getFcVigencia())) {
				throw new BusinessException(BusinessErrorEnum.USUARIO_BLOQUEADO_TEMPORALMENTE);
			} else {
				usuario.setEstatus(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
				repositorioUsuario.saveAndFlush(usuario);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio reactivarUsuarios(List<String> cadenaUsuario, String claveAfore, String usuarioAsigna) {
		RespuestaServicio respuesta;
		if(!utileriaValidador.validarListaVacia(cadenaUsuario)){
			for(String user : cadenaUsuario){
				UsuarioPulssar usuarioPulssar = this.obtenerUsuarioPulssar(Arrays.asList(EstatusUsuarioEnum.USUARIO_BLOQUEADO.getEstatusUsuario()), user, claveAfore,NumerosConstants.INT_UNO);
				this.validarBloqueoUsuario(usuarioPulssar, usuarioAsigna);
				servicioDirectorio.reiniciarIntentos(usuarioPulssar.getUsuario());
			}
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.USUARIO_DESBLOQUEADO_CORRECTAMENTE.getClave(), claveAfore, NumerosConstants.INT_UNO, null);
		}else{
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.SELECCION_USUARIOS_BAJA.getClave(), claveAfore, NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public RespuestaServicio reenviarAltaUsuario(List<String> usuarios, DatosRegistro registro, UsuarioLogin user) {
		logger.info("Reenvio de credenciales usuario");
		RespuestaServicio respuesta = null;
		String afore = registro.getClaveAfore();
		
		if(utileriaValidador.validarVacio(afore)) {
			afore = user.getAforeUsuario();
		}
		
		int j = 0;
		for(String usuarioReenvio : usuarios) {
			UsuarioPulssar usuarioPulssar = null;
			try {
				usuarioPulssar = this.obtenerUsuarioDatos(usuarioReenvio, EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario());
				if(!utileriaValidador.validarObjetoNulo(usuarioPulssar)) {
					logger.info("Valida el usuario para evitar duplicar usuarios");
					servicioValidarAlta.validarAltaUsuariosAcceSAR(usuarioReenvio, usuarioPulssar.getEmail(), usuarioPulssar.getCelular(), 
							usuarioPulssar.getClaveOrganizacion(), AgenteConstants.INICIALIZA_VACIO, true);
					logger.info("Usuario validado, continua el envio de sms o correo con nuevo codigo");
					CorreoEnum archivoCorreo = CorreoEnum.ARCHIVO_ALTA_USUARIO;
					String codigo = utileriaCodigo.generarCodigoActivacion();
					String smsCodigo = CorreoConstants.LEYENDA_CON_CODIGO;
					String codigoEmail = codigo;
					if(!utileriaValidador.validarVacio(usuarioPulssar.getCelular())) {
						List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_MENSAJE, "");
						String parametroMensaje = utileriaValidador.obtenerValorParametro(listaParametro, RegistroUsuarioConstants.TIPO_SMS_ALTA, RegistroUsuarioConstants.MENSAJE_SMS);		
						String mensajeSms = parametroMensaje.replace(RegistroUsuarioConstants.SMS_CODIGO, codigo);
						servicioMensaje.enviarMensaje(mensajeSms, usuarioPulssar.getCelular());
						smsCodigo = CorreoConstants.LEYENDA_SIN_CODIGO;
						codigoEmail = AgenteConstants.INICIALIZA_VACIO;
					}
					
					List<Parametro> listaParametroDias = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_CODIGO, "");
					String dias = utileriaValidador.obtenerValorParametro(listaParametroDias, RegistroUsuarioConstants.DIAS_VIGENCIA, NumerosConstants.C_UNO);
					int dia = Integer.parseInt(dias);
					Date fechaCodigo = new Date();
					Date fechaVigencia = utileriaFecha.sumaDias(fechaCodigo, dia);
					
					CodigoUsuario codigoUsuario = new CodigoUsuario();
					codigoUsuario.setCodigo(codigo);
					codigoUsuario.setEstatus(NumerosConstants.INT_CERO);
					codigoUsuario.setFechaVigencia(fechaVigencia);
					codigoUsuario.setFechaUso(null);
					codigoUsuario.setFolio(utileriaCodigo.generarFolioServicio());
					codigoUsuario.setTipoCodigo(RegistroUsuarioConstants.TIPO_CODIGO_ALTA);
					codigoUsuario.setFecha(fechaCodigo);
					codigoUsuario.setUsuario(user.getUsuario());
					codigoUsuario.setIntentos(NumerosConstants.INT_CERO);
					
					String fecha = utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_CORREO);
					DatosCorreo correoAlta = new DatosCorreo();
					correoAlta.setDatosCorreo(archivoCorreo);
					correoAlta.setCorreo(usuarioPulssar.getEmail());
					correoAlta.setFecha(fecha);
					correoAlta.setNombre(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioPulssar.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
							utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioPulssar.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
							utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioPulssar.getApellidoMaterno(), ExpresionesConstants.VACIO)));
					correoAlta.setUsuario(usuarioReenvio);
					correoAlta.setCodigo(codigoEmail);
					correoAlta.setCodigoMsn(smsCodigo);
					String key = utileriaCadena.obtenerCadenaConcatenada(true, usuarioReenvio, AgenteConstants.COMA, codigoUsuario.getFolio(), AgenteConstants.COMA, RegistroUsuarioConstants.TIPO_CODIGO_ALTA);
					String keyConcatenada = encriptacionUtils.obtieneEncriptacion(key, keySeguridadEncriptacion);
					correoAlta.setLigaServicio(keyConcatenada);
					correoAlta.setUrlServicio(servicioValidarAlta.obtenerUrlPaginaPlataforma(afore));
					
					servicioCorreo.envioCorreo(correoAlta, afore);
					codigoUsuario.setIdentificadorUsuario(usuarioPulssar.getIdentificador());
					repositorioCodigo.saveAndFlush(codigoUsuario);
					j++;
				}
			} catch(BusinessException be) {
				logger.error("BusinessException reenviarAltaUsuario {}", usuarioReenvio, be);
				if(!utileriaValidador.validarObjetoNulo(usuarioPulssar)) {
					usuarioPulssar.setEstatus(EstatusUsuarioEnum.USUARIO_BAJA.getEstatusUsuario());
					usuarioPulssar.setFecha(new Date());
					usuarioPulssar.setUsuarioModificador(ActivacionConstants.ADMIN_USUARIO_CANCELADO);
					repositorioUsuario.save(usuarioPulssar);
				}
			}
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.CREDENCIALES_REENVIADAS_CORRECTAMENTE.getClave(), afore, NumerosConstants.INT_UNO, null);
			String mensaje = StringUtils.replace(respuesta.getMensaje(), RegistroUsuarioConstants.DATOS_RESPUESTA, String.valueOf(j));
			respuesta.setMensaje(mensaje);
		}
		return respuesta;
	}

	/**
	 * Metodo encargado de validar tipo de bloqueo de usuario
	 * @param usuarioPulssar
	 * @param usuarioAsigna
	 */
	@Transactional
	private void validarBloqueoUsuario(UsuarioPulssar usuarioPulssar, String usuarioAsigna) {
		if(!utileriaValidador.validarObjetoNulo(usuarioPulssar)){
			Date fechaModificacion = new Date();
			List<BloqueoUsuarioPulssar> usuarioBloqueo = repositorioBloqueoUsuario.findByIdentificadorUsuarioOrderByIdentificadorBloqueoDesc(usuarioPulssar.getIdentificador());
			int i = 0;
			boolean isValidado = false;
			do {
				BloqueoUsuarioPulssar usuario = usuarioBloqueo.get(i);
				if(RegistroUsuarioConstants.ESTATUS_BLOQUEO_PRIMER_BLOQUEO.equals(usuario.getEstatus())){
					usuario.setIntentos(NumerosConstants.INT_CERO);
					usuario.setFcControl(fechaModificacion);
					usuario.setUsuarioModificador(usuarioAsigna);
					repositorioBloqueoUsuario.save(usuario);
					usuarioPulssar.setEstatus(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
					usuarioPulssar.setFecha(fechaModificacion);
					usuarioPulssar.setUsuarioModificador(usuarioAsigna);
					repositorioUsuario.saveAndFlush(usuarioPulssar);
					isValidado = true;
				}else if (RegistroUsuarioConstants.ESTATUS_BLOQUEO_SEGUNDO_BLOQUEO.equals(usuario.getEstatus())) {
					usuario = new BloqueoUsuarioPulssar();
					usuario.setIdentificadorUsuario(usuarioPulssar.getIdentificador());
					usuario.setEstatus(RegistroUsuarioConstants.ESTATUS_BLOQUEO);
					usuario.setIntentos(NumerosConstants.INT_CERO);
					usuario.setFcControl(fechaModificacion);
					usuario.setUsuarioModificador(usuarioAsigna);
					repositorioBloqueoUsuario.save(usuario);
					usuarioPulssar.setEstatus(EstatusUsuarioEnum.USUARIO_REACTIVADO.getEstatusUsuario());
					usuarioPulssar.setFecha(fechaModificacion);
					usuarioPulssar.setUsuarioModificador(usuarioAsigna);
					repositorioUsuario.saveAndFlush(usuarioPulssar);
					isValidado = true;
				}
				i++;
			} while(!isValidado && i < usuarioBloqueo.size());
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio reenviarCodigo(DatosRegistro datosUsuario, String urlKey) {
		RespuestaServicio respuesta = new RespuestaServicio();
		String auxiliarAfore = ActivacionConstants.CLAVE_PROCESAR;
		UsuarioPulssar usuarioP;
		
		List<String> listaDesencriptada = this.obtenerDesencriptacionUrlKey(urlKey);
		String estatus = RegistroUsuarioConstants.TIPO_CODIGO_ALTA.equals(listaDesencriptada.get(NumerosConstants.INT_DOS)) ? EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario() : EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario();
		
		String usuario = listaDesencriptada.get(NumerosConstants.INT_CERO);
		
		this.validarDatosIncongruentes(datosUsuario, true, usuario);
		
		if(!utileriaValidador.validarVacio(usuario)) {
			usuarioP = this.obtenerUsuarioDatos(usuario, estatus);
			CodigoUsuario codigoUsuario = this.validarUrlKey(listaDesencriptada, usuarioP.getIdentificador(), new Date());
			if(listaDesencriptada.get(NumerosConstants.INT_UNO).equals(codigoUsuario.getFolio())) {
				String codigo = codigoUsuario.getCodigo();
				if(!utileriaValidador.validarVacio(usuarioP.getCelular())){
					String paramCaracter = AgenteConstants.PARAMETRO_MENSAJE;
					List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
					String parametroMensaje = utileriaValidador.obtenerValorParametro(listaParametro, RegistroUsuarioConstants.TIPO_SMS_ALTA, RegistroUsuarioConstants.MENSAJE_SMS);		
					String mensajeSms = parametroMensaje.replace(RegistroUsuarioConstants.SMS_CODIGO, codigo);
					servicioMensaje.enviarMensaje(mensajeSms, usuarioP.getCelular());					
				}else{
					String fecha = utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_CORREO);
					DatosCorreo correoRegistro = new DatosCorreo();
					correoRegistro.setDatosCorreo(CorreoEnum.ARCHIVO_RECUPERA_CODIGO);
					correoRegistro.setCorreo(usuarioP.getEmail());
					correoRegistro.setFecha(fecha);
					correoRegistro.setNombre(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioP.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
							utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioP.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
							utileriaCadena.obtenerContenidoCadenaSinEspacios(usuarioP.getApellidoMaterno(), ExpresionesConstants.VACIO)));
					correoRegistro.setCodigo(codigo);
					correoRegistro.setLigaServicio(ExpresionesConstants.VACIO);
					servicioCorreo.envioCorreo(correoRegistro, usuarioP.getClaveOrganizacion());
				}
				respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.CODIGO_RENVIADO_CORRECTAMENTE.getClave(), auxiliarAfore, NumerosConstants.INT_UNO, null);
				
			}
		}
		return respuesta;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MenuPagina> redireccionarPagina(String claveRol, String claveAfore) {
		logger.info("RedireccionarPagina claveRol: {} claveAfore: {}", claveRol, claveAfore );
		List<MenuPagina> listaPaginas= menuPaginaRepository.findByClaveRolClaveAfore(claveRol, claveAfore, RolesConstants.MENU_PRINCIPAL);	
		return listaPaginas;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MenuPagina> obtenerMenus(String claveRol, String claveAfore) {
		logger.info("ObtenerMenus claveRol: {} claveAfore: {}", claveRol, claveAfore );
		List<MenuPagina> listaPaginas= menuPaginaRepository.findByClaveRolClaveAfore(claveRol, claveAfore, RolesConstants.MENU_BASICO);	
		return listaPaginas;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MenuPagina> obtenerMenus(String claveRol, String claveAfore, Long menu) {
		logger.info("ObtenerMenus claveRol: {} claveAfore: {} claveAfore: {}", claveRol, claveAfore ,menu);
		return menuPaginaRepository.findByClaveRolClaveAfore(claveRol, claveAfore, menu);
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService#obtenerMenuRol(java.lang.String, java.lang.String)
	 */
	@Override
	public List<MenuPagina> obtenerMenuRol(String claveAfore) {
		logger.info("ObtenerMenus claveAfore: {}", claveAfore );
	return menuPaginaRepository.findByClaveAfore(claveAfore);	
	}
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AdministracionUsuarioService#obtenerMenuRol(java.lang.String, java.lang.String)
	 */
	@Override
	public List<MenuPagina> obtenerMenuRol(String claveRol, String claveAfore) {
		logger.info("ObtenerMenus claveRol: {} claveAfore: {}", claveRol, claveAfore );
	return menuPaginaRepository.findByClaveRolClaveAfore(claveRol, claveAfore);	
	}
	
	/**
	 * menuReimpresion
	 */
	@Override
	public Boolean menuReimpresion(String aforeSesion) {
		Boolean aforeReimpresion= Boolean.FALSE;
		try {
			List<Parametro> parametro=servicioCatalogo.obtenerParametroDdbpose(RegistroUsuarioConstants.CLAVE_MENU_REIMPRESION);
			if(parametro!=null && !parametro.isEmpty()) {
				String[] afore=parametro.get(0).getChValorParametro().split(RegistroUsuarioConstants.COMA);
				List<String> listaAforeMenu=Arrays.asList(afore);
				if(listaAforeMenu.contains(aforeSesion)) {
					aforeReimpresion= Boolean.TRUE;
				}
			}
		}catch(Exception e) {
			logger.error("Error para obtener parametro de reimpresion",e);
		}
	
		return aforeReimpresion;
		
	}
	
	/**
	 * menuReimpresion
	 */
	@Override
	public Boolean menuExpedienteUnicoCoopel(String aforeSesion,String rolPulssar) {
		Boolean aforeReimpresion= Boolean.TRUE;
		try {
			List<Parametro> parametro=servicioCatalogo.obtenerParametroDdbpose(RegistroUsuarioConstants.CLAVE_MENU_EXPE_UNICO_COOPEL);
			if(parametro!=null && !parametro.isEmpty()) {
				String[] afore=parametro.get(0).getChValorParametro().split(RegistroUsuarioConstants.COMA);
				List<String> listaAforeMenu=Arrays.asList(afore);
				if(listaAforeMenu.contains(aforeSesion) && RolesEnum.AGENTE_VENTANILLA.getRol().equals(rolPulssar)) {
					aforeReimpresion= Boolean.FALSE;
				}
			}
		}catch(Exception e) {
			logger.error("Error para obtener parametro de expediente unico",e);
		}
	   
		return aforeReimpresion;
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<MenuPagina> obtenerMenuId(List<Parametro> parametros) {
		logger.info("ObtenerMenus ids>>>{}", parametros);
		return menuPaginaRepository.findByIdentficadorMenu(obtenerIdsMenu(parametros));
	}
	
	/**
	 * Metodo encargado de obtener los idsMenu
	 * 
	 * @param parametros
	 * @return
	 */
	private List<Long> obtenerIdsMenu(List<Parametro> parametros) {
		List<Long> idsMenu = new ArrayList<>();
		if(!utileriaValidador.validarListaVacia(parametros)) {
			for(Parametro param : parametros) {
				idsMenu.add(Long.parseLong(param.getChParametro()));
			}
		}
		return idsMenu;
	}
	
}