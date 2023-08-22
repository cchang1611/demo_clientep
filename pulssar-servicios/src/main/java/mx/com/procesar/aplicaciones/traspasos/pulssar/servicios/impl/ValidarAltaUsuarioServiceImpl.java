
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CorreoCorporativo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioNickPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.CodigoUsuarioRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.CorreoCorporativoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioNickPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AgenteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CorreoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DirectorioUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MensajeService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarAltaUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarDatosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.CorreoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CorreoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.EstatusUsuarioEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.RolesEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCorreo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
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
public class ValidarAltaUsuarioServiceImpl implements ValidarAltaUsuarioService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ValidarAltaUsuarioServiceImpl.class);
	
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
	private CorreoCorporativoRepository repositorioCorreo;
	
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
	 * Inyeccion repositorio CodigoUsuario 
	 */
	@Autowired
	private CodigoUsuarioRepository repositorioCodigo;
	
	/**
	 * Inyeccion service catalogo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion Servicio validar datos
	 */
	@Autowired
	private ValidarDatosService servicioValidaDatos;
	
	/**
	 * Inyeccion Servicio agente
	 */
	@Autowired
	private AgenteService servicioAgente;
	
	/**
	 * Key seguridad
	 */
	@Value("${key.seguridad.encriptacion.usuario}")
	private String keySeguridadEncriptacion;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerUsuarioAcceSAR(DatosRegistro datosRegistro, boolean isConfirmaCel) {
		logger.info("Se obtiene el usuario para la plataforma {}", datosRegistro.toString());
		servicioValidaDatos.validarDatos(datosRegistro, isConfirmaCel);
		String usuarioAcceSAR = datosRegistro.getNickUsuario();
		if (!utileriaValidador.validarVacio(datosRegistro.getNickUsuario()) || !utileriaValidador.validarVacio(datosRegistro.getNumeroAgente())) {
			logger.info("Se valida el agente, {}", datosRegistro.getNumeroAgente());
			if(!utileriaValidador.validarVacio(datosRegistro.getNumeroAgente())) {
				servicioAgente.validarAgentePromotor(datosRegistro, false);
			}
		} else {
			logger.info("El usuario se genera por medio del correo, {}", datosRegistro.getCorreo());
			datosRegistro.setNumeroAgente(datosRegistro.getCorreo());
			usuarioAcceSAR = datosRegistro.getCorreo();
		}
		
		if(utileriaValidador.validarVacio(usuarioAcceSAR)) {
			usuarioAcceSAR = datosRegistro.getNumeroAgente();
		}
		
		return usuarioAcceSAR;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validarAltaUsuariosAcceSAR(String usuario, String correo, String celular, String claveAfore, String password, boolean isUsuarioNick) {
		logger.info("Proceso de Alta de usuario del Pulssar, {}", usuario);
		String passAuxiliar = password;
		this.validarUsuario(usuario, correo, celular, RegistroUsuarioConstants.ESTATUS_USUARIO, claveAfore, isUsuarioNick);
		if(utileriaValidador.validarVacio(passAuxiliar)) {
			passAuxiliar = utileriaCodigo.generarContrasenia();
		}
		return passAuxiliar;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarUsuarioOUD_Roles(DatosRegistro datosRegistro, String usuario, String password, List<UsuariosEnum> roles, boolean isActivo) {
		logger.info("Inicia proceso de registro de usuario OUD y asignacion de Roles: {} :: {}", datosRegistro, usuario);
		servicioDirectorio.registrarUsuario(datosRegistro, usuario, password, isActivo);
		servicioDirectorio.asignarRoles(usuario, roles);
		logger.info("Finaliza OUD");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CodigoUsuario validarAltaEmail_Codigo(String userName, DatosRegistro registro, UsuarioLogin user) {
		logger.info("Validar el envio de codigo por correo y/o mensaje");
		String codigo = utileriaCodigo.generarCodigoActivacion();
		CorreoEnum archivoCorreo = CorreoEnum.ARCHIVO_ALTA_USUARIO;
		String smsCodigo = CorreoConstants.LEYENDA_CON_CODIGO;
		String codigoEmail = codigo;
		
		if(!utileriaValidador.validarVacio(registro.getCelular())) {
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_MENSAJE, "");
			String parametroMensaje = utileriaValidador.obtenerValorParametro(listaParametro, RegistroUsuarioConstants.TIPO_SMS_ALTA, RegistroUsuarioConstants.MENSAJE_SMS);
			String mensajeSms = parametroMensaje.replace(RegistroUsuarioConstants.SMS_CODIGO, codigo);
			servicioMensaje.enviarMensaje(mensajeSms, utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCelular(), ExpresionesConstants.VACIO));
			smsCodigo = CorreoConstants.LEYENDA_SIN_CODIGO;
			codigoEmail = AgenteConstants.INICIALIZA_VACIO;
		}
		
		CodigoUsuario codigoUsuario = this.obtenerCodigoUsuario(codigo, RegistroUsuarioConstants.TIPO_CODIGO_ALTA, user.getUsuario(), user.getDatoUsuario());
		this.construirCorreo(archivoCorreo, registro, codigoUsuario.getFolio(), userName, codigoEmail, smsCodigo);
		
		return codigoUsuario;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarCorreoAdministrador(String username, String afore) {
		logger.info("El usuario {} se registro por medio del portal de servicios, afore {}", username, afore);
		List<UsuarioPulssar> usuariosAdmin = repositorioUsuario.findUsuariosAdministradores(afore, EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario(), RolesEnum.ADMINISTRADOR_AFORE.getRol(),  NumerosConstants.INT_UNO);
		if(utileriaValidador.validarListaVacia(usuariosAdmin)) {
			logger.info("Afore sin administradores activos {}", afore);
			throw new BusinessException(BusinessErrorEnum.AFORE_SIN_ADMIN);
		}			
		
		for(UsuarioPulssar usuario : usuariosAdmin) {
			DatosRegistro correo = new DatosRegistro();
			correo.setCorreo(usuario.getEmail());
			correo.setNombre(usuario.getNombre());
			correo.setApellidoPaterno(usuario.getApellidoPaterno());
			correo.setApellidoMaterno(usuario.getApellidoMaterno());
			correo.setClaveAfore(afore);
			this.construirCorreo(CorreoEnum.ARCHIVO_ASIGNACION_PERFIL, correo, null, username, null, null);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarAdministradorAfore(DatosRegistro datosUsuario) {
		if(!ActivacionConstants.CLAVE_PROCESAR.equals(datosUsuario.getClaveAfore())) {
			logger.info("Se realiza la validacion del administrador de afore >> {}", datosUsuario.toString());
			List<UsuarioPulssar> usuariosAdmin = repositorioUsuario.findUsuariosAdministradores(datosUsuario.getClaveAfore(), EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario(), RolesEnum.ADMINISTRADOR_AFORE.getRol(),  NumerosConstants.INT_UNO);
			if(utileriaValidador.validarListaVacia(usuariosAdmin)) {
				logger.info("Afore sin administradores activos {}", datosUsuario.getClaveAfore());
				throw new BusinessException(BusinessErrorEnum.AFORE_SIN_ADMIN);
			}
		}
	}
	
	/**
	 * Metodo encargado de obtener la url enviada en el correo
	 * 
	 * @param afore
	 * @return
	 */
	@Override
	public String obtenerUrlPaginaPlataforma(String afore) {
		List<Parametro> lstParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_URL_PLATAFORMA, AgenteConstants.PARAMETRO_CH_CORREO);
		Parametro parametro = lstParametro.get(NumerosConstants.INT_CERO);
		String valorcontexto = servicioCatalogo.obtenerRedireccionAfore(afore);
		
		return utileriaCadena.obtenerCadenaConcatenada(true, parametro.getChValorParametro(), 
				utileriaValidador.validarVacio(valorcontexto) ? AgenteConstants.INICIALIZA_VACIO : valorcontexto.trim());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarListaUsuariosCodigo(String cadena, String valor, List<UsuarioPulssar> listaUsuarios, String tipoCodigo, BusinessErrorEnum error) {
		if(!utileriaValidador.validarListaVacia(listaUsuarios)) {
			for(UsuarioPulssar usuarioPulsar : listaUsuarios) {
				List<CodigoUsuario> listaConsultaCodigo = repositorioCodigo.findByIdUsuarioAndTipoCodigo(usuarioPulsar.getIdentificador(), tipoCodigo);
				utileriaValidador.validarLista(usuarioPulsar, listaConsultaCodigo, cadena, valor, error);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarCelularEmail(String cadena, BusinessErrorEnum error, Integer tipo) {
		List<UsuarioPulssar> usuarios;
		if(!utileriaValidador.validarVacio(cadena)) {
			if(NumerosConstants.INT_UNO == tipo) {
				usuarios = repositorioUsuario.findByCelular(cadena, RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE);
			} else {
				usuarios = repositorioUsuario.findByEmail(cadena, RegistroUsuarioConstants.ESTATUS_USUARIO_AGENTE);
			}
			
			if(!utileriaValidador.validarListaVacia(usuarios)) {
				logger.info("Ya existe un usuario con la informacion proporcionada {}", cadena);
				throw new BusinessException(error);
			}
		}
	}
	
	/**
	 * Metodo encargado de construir Cor
	 * @param archivoCorreo
	 * @param registro
	 * @param folio
	 * @param userName
	 * @param codigoEmail
	 * @param smsCodigo
	 */
	private void construirCorreo(CorreoEnum archivoCorreo, DatosRegistro registro, String folio, String userName, String codigoEmail, String smsCodigo) {
		String fecha = utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_CORREO);
		DatosCorreo correoAlta = new DatosCorreo();
		correoAlta.setDatosCorreo(archivoCorreo);
		correoAlta.setCorreo(utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getCorreo(), ExpresionesConstants.VACIO));
		correoAlta.setFecha(fecha);
		correoAlta.setNombre(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
				utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
				utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getApellidoMaterno(), ExpresionesConstants.VACIO)));
		correoAlta.setUsuario(userName);
		
		if(!utileriaValidador.validarVacio(folio)) {
			correoAlta.setCodigo(codigoEmail);
			correoAlta.setCodigoMsn(smsCodigo);
			String key = utileriaCadena.obtenerCadenaConcatenada(true, userName, AgenteConstants.COMA, folio, AgenteConstants.COMA, RegistroUsuarioConstants.TIPO_CODIGO_ALTA);
			String keyConcatenada = encriptacionUtils.obtieneEncriptacion(key, keySeguridadEncriptacion);
			correoAlta.setLigaServicio(keyConcatenada);
		}
		
		correoAlta.setUrlServicio(this.obtenerUrlPaginaPlataforma(registro.getClaveAfore()));
		
		servicioCorreo.envioCorreo(correoAlta, registro.getClaveAfore());
	}
	
	/**
	 * Metodo encargado de obtener el codigo de usuario
	 * @param codigo
	 * @param tipoCodigo
	 * @param user
	 * @param isGuardar
	 * @param idUsuario
	 * @return
	 */
	private CodigoUsuario obtenerCodigoUsuario(String codigo, String tipoCodigo, String user, Long idUsuario) {
		List<Parametro> listaParametroDias = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_CODIGO, "");
		String dias = utileriaValidador.obtenerValorParametro(listaParametroDias,RegistroUsuarioConstants.DIAS_VIGENCIA, NumerosConstants.INT_UNO.toString());
		
		int dia = Integer.parseInt(dias);
		Date fechaCodigo = new Date();
		Date fechaVigencia = utileriaFecha.sumaDias(fechaCodigo, dia);
		
		CodigoUsuario codigoUsuario = new CodigoUsuario();
		codigoUsuario.setCodigo(codigo);
		codigoUsuario.setEstatus(NumerosConstants.INT_CERO);
		codigoUsuario.setFechaVigencia(fechaVigencia);
		codigoUsuario.setFechaUso(null);
		codigoUsuario.setFolio(utileriaCodigo.generarFolioServicio());
		codigoUsuario.setTipoCodigo(tipoCodigo);
		codigoUsuario.setFecha(fechaCodigo);
		codigoUsuario.setUsuario(user);
		codigoUsuario.setIntentos(NumerosConstants.INT_CERO);
		
		return codigoUsuario;
	}
	
	/**
	 * Metodo encargado de registrar un usuario que se registro
	 * por medio del portal de servicios
	 * 
	 * @param registro
	 */
	private String registrarAgentes(DatosRegistro registro, boolean tipoActivacion, List<UsuariosEnum> roles) {
		String usuarioValidar = registro.getNumeroAgente().trim();
		if(!utileriaValidador.validarVacio(registro.getNickUsuario())) {
			String auxiliarUsuario = registro.getNickUsuario().trim();
			registro.setNumeroAgente(auxiliarUsuario);
		}
//		servicioDirectorio.registrarUsuario(registro, tipoActivacion);
		servicioDirectorio.asignarRoles(registro.getNumeroAgente(), roles);
		registro.setNumeroAgente(usuarioValidar);
		String fecha = utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_CORREO);
		String estatus;
		String paramCaracter = AgenteConstants.PARAMETRO_MENSAJE;
		if(utileriaValidador.validarVacio(registro.getNickUsuario())) {
			logger.info("El agente {} se registro por medio del portal de servicios", registro.getNumeroAgente());
			List<UsuarioPulssar> usuariosAdmin = repositorioUsuario.findUsuariosAdministradores(registro.getClaveAfore(), EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario(), RolesEnum.ADMINISTRADOR_AFORE.getRol(),  NumerosConstants.INT_UNO);
			if(utileriaValidador.validarListaVacia(usuariosAdmin)) {
				logger.info("Afore sin administradores activos {}", registro.getClaveAfore());
				throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
			}			
			
			for(UsuarioPulssar usuario : usuariosAdmin) {
				DatosCorreo correoRegistro = new DatosCorreo();
				correoRegistro.setDatosCorreo(CorreoEnum.ARCHIVO_ASIGNACION_PERFIL);
				correoRegistro.setCorreo(usuario.getEmail());
				correoRegistro.setFecha(fecha);
				correoRegistro.setNombre(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
						utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
						utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getApellidoMaterno(), ExpresionesConstants.VACIO)));
				correoRegistro.setUsuario(registro.getNumeroAgente());
				correoRegistro.setLigaServicio(ExpresionesConstants.VACIO);
				servicioCorreo.envioCorreo(correoRegistro, registro.getClaveAfore());
			}
			estatus = EstatusUsuarioEnum.USUARIO_INACTIVO.getEstatusUsuario();
		} else {
			if(!utileriaValidador.validarVacio(registro.getCelular())){
				List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(paramCaracter, "");
				String parametroMensaje = utileriaValidador.obtenerValorParametro(listaParametro, RegistroUsuarioConstants.TIPO_SMS_RECUPERACION, RegistroUsuarioConstants.MENSAJE_SMS_USUARIO_PASSWORD);
				String mensajeSms = parametroMensaje.replace(RegistroUsuarioConstants.SMS_USUARIO, registro.getNickUsuario());
				mensajeSms = mensajeSms.replace(RegistroUsuarioConstants.SMS_PASSWORD, registro.getPassword());
				servicioMensaje.enviarMensaje(mensajeSms, registro.getCelular());				
			}else{
				DatosCorreo correoRegistro = new DatosCorreo();
				correoRegistro.setDatosCorreo(CorreoEnum.ARCHIVO_RECUPERA_DATOS);
				correoRegistro.setCorreo(registro.getCorreo());
				correoRegistro.setFecha(fecha);
				correoRegistro.setNombre(utileriaCadena.obtenerCadenaConcatenada(false, utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getNombre(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO,
						utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getApellidoPaterno(), ExpresionesConstants.VACIO), ExpresionesConstants.ESPACIO, 
						utileriaCadena.obtenerContenidoCadenaSinEspacios(registro.getApellidoMaterno(), ExpresionesConstants.VACIO)));
				correoRegistro.setUsuario(registro.getNickUsuario());
				correoRegistro.setContrasenia(registro.getPassword());
				correoRegistro.setLigaServicio(ExpresionesConstants.VACIO);
				servicioCorreo.envioCorreo(correoRegistro, registro.getClaveAfore());
			}
				
			estatus = EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario();
			
		}
		return estatus;
	}
	
	/**
	 * Metodo encargado de validar si existe un usuario
	 * 
	 * @param usuario
	 * @param afore
	 */
	private void validarUsuario(String usuario, String correo, String celular, List<String> estatus, String organizacion, boolean isUsuarioNick) {
		logger.info("Se realiza la validacion del usuario {} correo {} celular {}",usuario, correo, celular);
		UsuarioPulssar usuarioP = this.obtenerUsuario(usuario, estatus, isUsuarioNick);
		List<UsuarioPulssar> listaUsuarios = new ArrayList<>();
		if(!utileriaValidador.validarObjetoNulo(usuarioP)) {
			listaUsuarios.add(usuarioP);
		}
		this.validarListaUsuariosCodigo(RegistroUsuarioConstants.CADENA_USUARIO, usuario, listaUsuarios, RegistroUsuarioConstants.TIPO_CODIGO_ALTA, BusinessErrorEnum.ERROR_USUARIO_EXISTENTE);
		
		logger.info("Se realiza la validacion del correo {} y celular {}", correo, celular);
		if(!utileriaValidador.validarVacio(celular)) {
			List<UsuarioPulssar> usuariosCelular = repositorioUsuario.findByCelular(celular.trim(), estatus);
			this.validarListaUsuariosCodigo(RegistroUsuarioConstants.CADENA_CELULAR, celular, usuariosCelular, RegistroUsuarioConstants.TIPO_CODIGO_ALTA, BusinessErrorEnum.ERROR_CELULAR_EXISTENTE);
			this.validarCelularEmail(celular, BusinessErrorEnum.ERROR_CELULAR_EXISTENTE, NumerosConstants.INT_UNO);
		}
	
		if(!utileriaValidador.validarVacio(correo)) {
			List<UsuarioPulssar> usuariosCorreo = repositorioUsuario.findByEmail(correo.trim(), estatus);
			this.validarListaUsuariosCodigo(RegistroUsuarioConstants.CADENA_CORREO, correo, usuariosCorreo, RegistroUsuarioConstants.TIPO_CODIGO_ALTA, BusinessErrorEnum.ERROR_CORREO_EXISTENTE);
			this.validarCelularEmail(correo, BusinessErrorEnum.ERROR_CORREO_EXISTENTE, NumerosConstants.INT_DOS);
			
			String dominioCorreo = this.obtenerDominio(correo);
			List<CorreoCorporativo> listaCorreos = repositorioCorreo.findByClaveOrganizacionAndEmailAndEstatus(organizacion, dominioCorreo, NumerosConstants.INT_UNO);
			if(utileriaValidador.validarListaVacia(listaCorreos)) {
				throw new BusinessException(BusinessErrorEnum.ERROR_CORREO_CORPORATIVO_INVALIDO);
			}
		}
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
	 * metodo que valida obtiene el dominio de un correo electronico
	 * @param correo
	 * @return
	 */
	private String obtenerDominio(String correo) {
		String dominio = correo.substring(correo.indexOf(ExpresionesConstants.ARROBA));
		if (!utileriaValidador.validarVacio(dominio)) {
			logger.info("dominio a validar {} ", dominio);
			return dominio.toUpperCase();
		}
		throw new GenericException(GenericErrorEnum.ESTRUCTURA_INCORRECTA_CORREO);
	}
}