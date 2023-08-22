/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.opensaml.xml.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolPerfilFederados;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioNickPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioRol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioNickPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioRolRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo.UsuarioBanamex;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DirectorioUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolPulssarPerfilAccesarService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuariosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.EncriptacionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Controlador pra dispositivos coppel
 * @author dhernand
 * 
 */
@Controller
@RequestMapping(value = {"/public"})
public class BanamexController {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(BienvenidoController.class);
	
	/**
	 * url comparador
	 */
	@Value("${url.comparador.acceso}")
	private String rutaComparador;
	
	/**
	 * Inyeccion de utileria
	 */
	@Value("${css.configurables}")
	private String cssConfigurable;
	
	/**
	 * Inyeccion de utileria
	 */
	@Value("${usuarios.federados.a552}")
	private String keyFederados;
	
	/**
	 * Utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * servicio de catalogo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * servicio de catalogo roles
	 */
	@Autowired
	private RolesService servicioRol;
	
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
	 * Repositorio de usuarios Rol usuario
	 */
	@Autowired
	private EncriptacionUtils encriptacionUtils;
	
	/**
	 * Utileria Cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Utileria Fechas
	 */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/**
	 * Servicio roles
	 */
	@Autowired
	private RolesService servicioRoles;
	
	/**
	 * Inyeccion de servicio Directorio
	 */
	@Autowired
	private DirectorioUsuarioService servicioDirectorio;
	
	/**
	 * Inyeccion de servicio de rolPulssarPerfilAccesarService
	 */
	@Autowired
	private RolPulssarPerfilAccesarService rolPulssarPerfilAccesarService;
	
	/**
	 * Pagina de acceso a banamex
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/A552/accesar.do", method = {RequestMethod.POST})
	public ModelAndView accesoPortal(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView model = new ModelAndView(NavegacionEnum.LOGIN_ERROR_BANAMEX.getNavegacion());
		String error = null;
		try {
			logger.info("Obteniendo Usuario Banamex para login");
			String samlResponseLectura = obtenerRequestBufferReader(request);
			logger.info("Cadena SamlResponse Reader : {}", samlResponseLectura);
			
			String samlResponseParam = request.getParameter(AgenteConstants.PARAMETRO_SAMLRESPONSE);
			logger.info("Parametro SamlResponse {}", samlResponseParam);
			
			String samlResponseHeader = request.getHeader(AgenteConstants.PARAMETRO_SAMLRESPONSE);
			logger.info("Encabezado SamlResponse {}", samlResponseHeader);
			
			Object samlObject = request.getAttribute(AgenteConstants.PARAMETRO_SAMLRESPONSE);
			String samlResponseAttribute = samlObject != null ? (String)samlObject : null;
			logger.info("Atributo SamlResponse {}", samlResponseAttribute) ;
			
			String samlRespuesta = validarRequest(samlResponseLectura, samlResponseParam, samlResponseHeader, samlResponseAttribute);
			
			byte[] baseDecodificadaResponse = Base64.decode(samlRespuesta);
			
			ByteArrayInputStream entradaArray = new ByteArrayInputStream(baseDecodificadaResponse);
			DocumentBuilderFactory documentoFactory = DocumentBuilderFactory.newInstance();
			documentoFactory.setNamespaceAware(true);
			DocumentBuilder docContructor = documentoFactory.newDocumentBuilder();
			
			Document doc = docContructor.parse(entradaArray);
			Element elemento = doc.getDocumentElement();

			NodeList listaNode = elemento.getChildNodes();
			Map<String, String> datosBanamex = new HashMap<>();
			obtenerUsuarioDsGroup(listaNode, datosBanamex);
			
			StreamResult result = new StreamResult(new StringWriter());
			TransformerFactory.newInstance().newTransformer() .transform(new DOMSource(elemento), result);
			String samlRequest = result.getWriter().toString();
			logger.info("SAMLResponse XML: {}", samlRequest);
			logger.info("Datos Para Loggin {}", datosBanamex.toString());
			
			validarDatosObtenidos(datosBanamex);
			String usuarioBanamex = datosBanamex.get(AgenteConstants.CLAVE_USUARIO_BANAMEX);
			String rol = datosBanamex.get(AgenteConstants.ROL_USUARIO_BANAMEX);
			UsuarioBanamex usuarioBnmx = new UsuarioBanamex(usuarioBanamex, rol, Boolean.FALSE);		
            List<RolPerfilFederados> listaCvRol = rolPulssarPerfilAccesarService.encontrarRolesPerfiles(usuarioBnmx.getRol());
			
			logger.info("Rol valido para login user {}", usuarioBanamex);
			
			logger.info("Asignando rol de usuario para comparador");
			UsuarioPulssar usuarioP = obtenerUsuarioBanamex(usuarioBanamex);
            agregarRolUsuarioBanamex(usuarioP, usuarioBanamex, listaCvRol.get(0).getRolPulssar().getClaveRol());
				
			logger.info("Obteniendo url comparador de banamex:");
            for (RolPerfilFederados rolPerfil : listaCvRol) {
                logger.info("URL recuperadas [ rol: {} , url:{} ]", rolPerfil.getPerfilFederados().getClavePerfil(), rolPerfil.getUrlLogin());
			}
			validarRolUsuarioOUD(usuarioBanamex);
			
			String usuarioComparador = encriptacionUtils.obtieneEncriptacion(usuarioBanamex, keyFederados);
			String password = encriptacionUtils.obtieneEncriptacion(this.cambiarPasswordOUD(usuarioBanamex), keyFederados);
			
            // componente de redireccion segun configuracion
            logger.info("redireccion a pantalla intermedia usuario: {}", usuarioComparador);
            model = new ModelAndView(NavegacionEnum.LOGIN_AUX.getNavegacion());
            model.addObject("nombreUsuario", rolPulssarPerfilAccesarService.obtenerNombreUsuario(usuarioBnmx.getUsuario()));
            model.addObject("usComparador", usuarioComparador);
            model.addObject("pwComparador", password);
            model.addObject("menuOpciones", listaCvRol);
		} catch(IOException ioe) {
			logger.error("IOException accesoPortal ", ioe);
			error = "Se presento un problema en la conexión del comparador";
		} catch (ParserConfigurationException pce) {
			logger.error("ParserConfigurationException accesoPortal ", pce);
			error = "Error en la transformación de los datos de entrada";
    } catch (BusinessException be) {
        	logger.error("BusinessException accesoPortal ", be);
        	RespuestaServicio respuesta = servicioCatalogo.obtenerRespuesta(null, be.getCodigo(), PdfConstants.BANAMEX, NumerosConstants.INT_DOS, null);
        	error = StringUtils.replace(respuesta.getMensaje(), "{dato}", be.getMessage());
        	error = StringUtils.replace(error, "{perfil}", be.getMessage());
		} catch (Exception e) {
        	logger.error("Exception accesoPortal ", e);
        	error = "Error no controlado en el login";
		}
		
		if(!utileriaValidador.validarVacio(error)) {
			model.addObject("error", error);
			request.getSession().setAttribute(ParametrosConstants.USUARIO_ORGANIZACION, PdfConstants.BANAMEX);
		}
		request.getSession().setAttribute(ParametrosConstants.STILO_CONFIGURACION, cssConfigurable);
		
		return model;
	}
	
	/**
	 * Metodo encargado de cambiar el password del oud}
	 * @param usuarioOUD
	 * @throws NoSuchAlgorithmException 
	 */
	private String cambiarPasswordOUD(String usuarioOUD) throws NoSuchAlgorithmException {
		logger.info("cambiarPasswordOUD [usuarioOUD:{}, keyFederados:{}, fechaActual:{}  ]", usuarioOUD, keyFederados, utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FOLIO_SERVICIO));
		MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(utileriaCadena.obtenerCadenaConcatenada(true, usuarioOUD, keyFederados, utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FOLIO_SERVICIO)).getBytes());
	    byte[] digest = md.digest();
	    String cadenaPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();
	    servicioDirectorio.recuperaContrasenia(usuarioOUD, cadenaPassword);
	    return cadenaPassword;
	}
	
	/**
	 * Metodo encargado de obtener el request correcto
	 * 
	 * @param reqParam
	 * @param reqHead
	 * @param reqAttri
	 * @return
	 */
	private String validarRequest(String reader, String reqParam, String reqHead, String reqAttri) {
		String valor = reader;
		if(reqParam != null) {
			valor = reqParam;
		} else if(reqHead != null) {
			valor = reqHead;
		} else if(reqAttri != null) {
			valor = reqAttri;
		}
		return valor;
		
	}
	
	/**
	 * Metodo encargado de obtener la lectura del buffer del request
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	private String obtenerRequestBufferReader(HttpServletRequest request) throws IOException  {
		StringBuffer lecturaBuffer = new StringBuffer();
		String samlResponseLectura = "";
		String lineaLectura = null;
		BufferedReader lectura = request.getReader();
		
		while((lineaLectura = lectura.readLine()) != null) {
			lecturaBuffer.append(lineaLectura);
			lecturaBuffer.append(AgenteConstants.CADENA_SEPARACION_A552);
		}
		logger.info("Lectura Request: {}", lecturaBuffer.toString());
		
		if(!utileriaValidador.validarObjetoNulo(lecturaBuffer.toString())) {
			String cadenaEntrada = lecturaBuffer.toString();
			String[] splitCadena = cadenaEntrada.split(AgenteConstants.CADENA_SEPARACION_A552);
			for(int i = 0; i < splitCadena.length; i++) {
				if(splitCadena[i].contains(AgenteConstants.PARAMETRO_SAMLRESPONSE)) {
					StringBuilder cadenaSaml = new StringBuilder();
					cadenaSaml.append(AgenteConstants.PARAMETRO_SAMLRESPONSE);
					cadenaSaml.append(ExpresionesConstants.CADENA_IGUAL);
					
					String dato = StringUtils.replace(splitCadena[i], cadenaSaml.toString(), ExpresionesConstants.VACIO);
					samlResponseLectura = URLDecoder.decode(dato, StandardCharsets.UTF_8.name());
				}
			}
		}
		return samlResponseLectura;
	}
	
	/**
	 * Metodo encargado de validar los valores de NameID y DSGroupde Banamex
	 * 
	 * @param nodeList
	 * @param datos
	 */
	private void obtenerUsuarioDsGroup(NodeList nodeList, Map<String, String> datos) {
		Node nodeSaml = null;
		Element elementSaml = null;
		for(int i = 0; i < nodeList.getLength(); i ++) {
			nodeSaml = nodeList.item(i);
			
			if(nodeSaml.getNodeType() == Node.ELEMENT_NODE) {
				elementSaml = (Element) nodeSaml.getChildNodes();
				NodeList nodeListElement = elementSaml.getChildNodes();
				if(elementSaml.getNodeName().contains("saml:Subject")) {
					Element elementID = (Element) elementSaml.getChildNodes();
					NodeList nodeListID = elementID.getChildNodes();
					obtenerNameID(nodeListID, datos);
				}
				if(elementSaml.getNodeName().contains("saml:AttributeStatement")) {
					Element elementID = (Element) elementSaml.getChildNodes();
					NodeList nodeListID = elementID.getChildNodes();
					validarDSGroup(nodeListID, datos);
				}
				if(nodeListElement.getLength() > 1) {
					obtenerUsuarioDsGroup(nodeListElement, datos);
				}
			}
		}
	}
	
	/**
	 * Metodo encargado de obtener el NameID de banamex
	 * 
	 * @param nodeList
	 * @param datos
	 */
	private void obtenerNameID(NodeList nodeList, Map<String, String> datos) {
		Node nodeSaml = null;
		Element elementSaml = null;
		for(int i = 0; i < nodeList.getLength(); i ++) {
			nodeSaml = nodeList.item(i);
			if(nodeSaml.getNodeName().contains("text")) {
				String value = nodeSaml.getNodeValue();
				datos.put(AgenteConstants.CLAVE_USUARIO_BANAMEX, value.trim());
			}
			
			if(nodeSaml.getNodeType() == Node.ELEMENT_NODE) {
				elementSaml = (Element) nodeSaml.getChildNodes();
				NodeList nodeListElement = elementSaml.getChildNodes();
				if(elementSaml.getNodeName().contains("NameID")) {
					obtenerNameID(nodeListElement, datos);
				}
			}
		}
	}
	
	/**
	 * Metodo encargado de obtener el DS_Group
	 * 
	 * @param nodeList
	 * @param datos
	 */
	private void validarDSGroup(NodeList nodeList, Map<String, String> datos) {
		Node nodeSaml = null;
		for(int i = 0; i < nodeList.getLength(); i ++) {
			nodeSaml = nodeList.item(i);
			NamedNodeMap namedNodeMap = nodeSaml.getAttributes();
			for(int j = 0; j < namedNodeMap.getLength(); j++) {
				Node nodeAttibute = namedNodeMap.item(j);
				if(nodeAttibute.getNodeValue().contains("ds_groups")) {
					obtenerDSGroup(nodeList, datos);
				}
			}
		}
	}
	
	/**
	 * Metodo encargado de obtener el DS_Group
	 * 
	 * @param nodeList
	 * @param datos
	 */
	private void obtenerDSGroup(NodeList nodeList, Map<String, String> datos) {
		Node nodeSaml = null;
		Element elementSaml = null;
		for(int i = 0; i < nodeList.getLength(); i ++) {
			nodeSaml = nodeList.item(i);
			if(nodeSaml.getNodeName().contains("text")) {
				String value = nodeSaml.getNodeValue();
				datos.put(AgenteConstants.ROL_USUARIO_BANAMEX, value.trim());
			}
			
			if(nodeSaml.getNodeType() == Node.ELEMENT_NODE) {
				elementSaml = (Element) nodeSaml.getChildNodes();
				NodeList nodeListElement = elementSaml.getChildNodes();
				obtenerDSGroup(nodeListElement, datos);
			}
		}
	}
	
	/**
	 * Metodo encargado de validar los datos obtenidos de banamex
	 * 
	 * @param datosBanamex
	 */
	private void validarDatosObtenidos(Map<String, String> datosBanamex) {
		if(datosBanamex.size() < 2) {
			String datoFaltante = "Usuario y Perfil";
			String user = datosBanamex.get(AgenteConstants.CLAVE_USUARIO_BANAMEX);
			String rol = datosBanamex.get(AgenteConstants.ROL_USUARIO_BANAMEX);
			if(user != null || rol != null) {
				datoFaltante = "Perfil";
				if(user == null) {
					datoFaltante = "Usuario";
				}
			}
			throw new BusinessException(datoFaltante, BusinessErrorEnum.FALTA_USUARIO_GROUP.getClave());
		}
	}

	/**
	 * Metodo encargado de obtener el usuario de banamex
	 * 
	 * @param usuario
	 * @return
	 */
	private UsuarioPulssar obtenerUsuarioBanamex(String usuario) {
		List<UsuarioNickPulssar> listaNickUsuario = repositorioUsuarioNick.findByNickUsuarioAndEstatus(usuario, NumerosConstants.INT_UNO);
		UsuarioPulssar usuarioP = null;
		if(utileriaValidador.validarListaVacia(listaNickUsuario)) {
			List<UsuarioPulssar> listaUsuarios = repositorioUsuario.findUsuarioActivo(usuario, RegistroUsuarioConstants.ESTATUS_USUARIOS);
			if(utileriaValidador.validarListaVacia(listaNickUsuario)) {
				throw new BusinessException(BusinessErrorEnum.ERROR_USUARIO_NO_EXISTE);
			}
			usuarioP = listaUsuarios.get(NumerosConstants.INT_CERO);
		} else {
			UsuarioNickPulssar usuarioN = listaNickUsuario.get(NumerosConstants.INT_CERO);
			usuarioP = repositorioUsuario.findOne(usuarioN.getIdentificadorUsuario());
		}
		
		return usuarioP;
	}
	
	/**
	 * Metodo encargado de agregar el rol del usuario banamex
	 * 
	 * @param usuarioBanamex
	 * @param rol
	 */
	@Transactional
	private void agregarRolUsuarioBanamex(UsuarioPulssar usuarioBanamex, String userLdap, String rol) {
		logger.info("Validando Rol [{}] del usuario {}", rol, userLdap);
		UsuarioRol lstRoles = repositorioUsuarioRol.findRolesByIdAndRol(usuarioBanamex.getIdentificador(), rol, NumerosConstants.INT_UNO);
		if(utileriaValidador.validarObjetoNulo(lstRoles)) {
			logger.info("Insertando rol usuario {} {}", rol, usuarioBanamex.toString());
			
			Calendar calendario = Calendar.getInstance();
			Date fecha = calendario.getTime();
			UsuarioRol rolUsuario = new UsuarioRol();
			rolUsuario.setEstatus(NumerosConstants.INT_UNO);
			rolUsuario.setFecha(fecha);
			RolesCatalogo rolCatalogo= servicioRoles.buscarRolPorRolClaveAfore(rol, PdfConstants.BANAMEX);
			rolUsuario.setRolUsuario(rolCatalogo);
			rolUsuario.setIdentificadorUsuario(usuarioBanamex.getIdentificador());
			rolUsuario.setUsuarioModificador(RegistroUsuarioConstants.USUARIO_FEDERADOS_PORTAL);
			repositorioUsuarioRol.saveAndFlush(rolUsuario);
			
			servicioDirectorio.activaDesactivaUsuario(userLdap, true);
			servicioDirectorio.asignarRoles(userLdap, Arrays.asList(UsuariosEnum.USUARIOS));
		}
		
		validarRolesActivos(userLdap, usuarioBanamex.getIdentificador(), rol);
	}
	
	/**
	 * Metodo encargado de validar los roles activos
	 * 
	 * @param userRol
	 * @param rol
	 */
	@Transactional
	private void validarRolesActivos(String usuario, Long idUsuarioRol, String rol) {
		Date fecha = Calendar.getInstance().getTime();
		List<UsuarioRol> roles = repositorioUsuarioRol.findRolesById(idUsuarioRol, NumerosConstants.INT_UNO);
		if(!utileriaValidador.validarListaVacia(roles)) {
			logger.info("Roles asignados a usuario {} {} {}", usuario, idUsuarioRol, roles.size());
			for(UsuarioRol userRol : roles) {
				if(!userRol.getRolUsuario().getClaveRol().equals(rol)) {
					logger.info("Roles a eliminar {} {} ", userRol, usuario);
					UsuarioRol rolUpdate = new UsuarioRol();
					rolUpdate.setIdentificadorUsuarioRol(userRol.getIdentificadorUsuarioRol());
					rolUpdate.setRolUsuario(userRol.getRolUsuario());
					rolUpdate.setIdentificadorUsuario(userRol.getIdentificadorUsuario());
					rolUpdate.setEstatus(NumerosConstants.INT_CERO);
					rolUpdate.setFecha(fecha);
					rolUpdate.setUsuarioModificador(RegistroUsuarioConstants.USUARIO_FEDERADOS_PORTAL);
					repositorioUsuarioRol.saveAndFlush(rolUpdate);
				}
			}
		}
	}
	
	
	/**
	 * Metodo encargado de validar el rol de usuario en el oud de procesar
	 * 
	 * @param usuarioLdap
	 */
	private void validarRolUsuarioOUD(String usuarioLdap) {
		logger.info("Validando rol OUD {}", usuarioLdap);
		String roles = servicioDirectorio.consultarRolesOID(usuarioLdap);
		if(utileriaValidador.validarObjetoNulo(roles)) {
			throw new BusinessException(BusinessErrorEnum.ERROR_USUARIO_NO_EXISTE);
		}
	}
}