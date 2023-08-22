package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_CONTIENE_FIRMA_AGENTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_CONTIENE_FIRMA_EMPLEADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_ISSSTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_METODO_PAGINA_SIGUIENTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_SOLICITA_FIRMAS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_URL_PAGINA_SIGUIENTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_URL_PDF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.Base64Utils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FabricaFolioComplementoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneracionZipService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ProcesoPendienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionImagenesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RechazoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosIdenExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaRecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioComplemento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenDocumento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenWrapper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Peticion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Feb 18, 2020
 */
@RestController
public class DocumentosGenericoController extends BaseController{

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DocumentosGenericoController.class);


	/**
	 * servicioCatalogo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * service
	 */
	@Autowired
	private DocumentosGenericoService service;
	
	/**
	 * utileriaValidador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * servicioArchivos
	 */
	@Autowired
	private RecepcionArchivosService servicioArchivos;

	/**
	 * Inyeccion de expediente
	 */
	@Autowired
	private ExpedienteService servicioExpediente;
	
	
	/**
	 * RecepcionImagenesService
	 */
	@Autowired
	private RecepcionImagenesService recepcionImagenesService;
	/**
	 * fabricaFolioComplementoService
	 */
	@Autowired
	private FabricaFolioComplementoService fabricaFolioComplementoService;
	/**
	 * generacionZipService
	 */
	@Autowired
	private GeneracionZipService generacionZipService;
	
	/**
	 * Inyeccion de expediente servicio
	 */
	@Autowired
	private ExpedienteServicioService expedienteServicio;
	
	/**
	 * Inyeccion servicio proceso pendiente
	 */
	@Autowired
	private ProcesoPendienteService serviceProcesoPendiente;
	
	/**
	 * Inyeccion dependencia RechazoService
	 */
	@Autowired
	private RechazoService rechazoService;
	
	/**
	 *  generarSolicitudDisposicionParcial
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param request
	 *  @param map
	 *  @param ra
	 *  @return
	 */
	@GetMapping(value="/private/upldDocumentosGen")
	public ModelAndView uploadDocumentosGen(HttpServletRequest request, ModelMap map) {

		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String exclusion = (String) request.getSession().getAttribute(ParametrosConstants.DOC_OBLIG_A_QUITAR);
		String [] adicional = (String[]) request.getSession().getAttribute(ParametrosConstants.DOC_ADICIONAL);
		String tipoDocumento = (String) request.getSession().getAttribute(ParametrosConstants.TIPO_DOCUMENTO);
		String origen = (String) request.getSession().getAttribute(ParametrosConstants.ORIGEN);
		FlujoModificacion flujo = (FlujoModificacion) request.getSession().getAttribute(ParametrosConstants.SESION_FLUJO_MODIFICACION);
		ModelAndView modelnView;
		try {
			String pasoCuatroRetiro = (String) request.getSession().getAttribute(ParametrosConstants.PASO_CUATRO_RETIROS);
//			if(!utileriaValidador.validarVacio(pasoCuatroRetiro)) {
//				throw new BusinessException(BusinessErrorEnum.ACCION_ILEGAL_DETECTADA);//Pendiente clave
//			}
			
			Map<String, List<Combo>> docs = service.obtenerCombo(tipoDocumento, user.getAforeUsuario(), exclusion, adicional);
			
			request.getSession().setAttribute(ParametrosConstants.EXCLUSION, docs.get(ParametrosConstants.EXCLUSION));
			request.getSession().setAttribute(ParametrosConstants.ADICIONAL, docs.get(ParametrosConstants.ADICIONAL));
			request.getSession().setAttribute(ParametrosConstants.OBLIGATORIOS, docs.get(ParametrosConstants.OBLIGATORIOS));
			request.getSession().setAttribute(ParametrosConstants.NO_OBLIGATORIOS, docs.get(ParametrosConstants.NO_OBLIGATORIOS));
			
			
			switch(origen) {
				case Constants.MATRIMONIO:
					origen = Constants.MATRIMONIO;
					break;
				case Constants.TOTAL_ISSSTE:
					break;
				case Constants.TOTAL_IMSS:
					break;
				default:
					origen = Constants.DESEMPLEO;
					break;
			}
	
			
			modelnView = new ModelAndView(NavegacionEnum.UPLD_DOCTOS_GENERICO.getNavegacion());
			FolioEntrada folio = (FolioEntrada) request.getSession().getAttribute("folioEntrada");
			modelnView.addObject("afore", trabajador.getClaveAfore());
			modelnView.addObject("origen", origen);
			modelnView.addObject(ParametrosConstants.EXCLUSION, docs.get(ParametrosConstants.EXCLUSION));
			modelnView.addObject(ParametrosConstants.TRABAJADOR, trabajador);
			modelnView.addObject("folio", folio);
			modelnView.addObject(ATRIBUTO_URL_PDF, (String) request.getSession().getAttribute(ATRIBUTO_URL_PDF));
			modelnView.addObject(ATRIBUTO_CONTIENE_FIRMA_EMPLEADO, (Boolean) request.getSession().getAttribute(ATRIBUTO_CONTIENE_FIRMA_EMPLEADO));
			modelnView.addObject(ATRIBUTO_CONTIENE_FIRMA_AGENTE, (Boolean) request.getSession().getAttribute(ATRIBUTO_CONTIENE_FIRMA_AGENTE));
			modelnView.addObject(ATRIBUTO_SOLICITA_FIRMAS, (Boolean) request.getSession().getAttribute(ATRIBUTO_SOLICITA_FIRMAS));
			modelnView.addObject(ATRIBUTO_URL_PAGINA_SIGUIENTE, (String) request.getSession().getAttribute(ATRIBUTO_URL_PAGINA_SIGUIENTE));
			modelnView.addObject(ATRIBUTO_METODO_PAGINA_SIGUIENTE, (String) request.getSession().getAttribute(ATRIBUTO_METODO_PAGINA_SIGUIENTE));
			
			
			
			if(PdfConstants.COPPEL.equals(trabajador.getClaveAfore())) {
				EntradaRecepcionImagenes entradaRecepcion = new EntradaRecepcionImagenes();
				DatosIdenExpediente datosExpediente = servicioExpediente.obtenerDatosExpediente(trabajador, flujo);
				String folioDocumento = servicioExpediente.obtenerValoresPantalla(folio.getFolioHijo(), null);
				String tipoTrabajador = servicioExpediente.obtenerValoresPantalla(null, datosExpediente.getTipoAfiliacion());
				
				modelnView.addObject(ParametrosConstants.FOLIO_DOCUMENTO, folioDocumento);
				request.getSession().setAttribute(ParametrosConstants.FOLIO_DOCUMENTOS, folioDocumento);
				modelnView.addObject(ParametrosConstants.PARAMETRO_TIPO_TRABAJADOR, tipoTrabajador);
				modelnView.addObject("tipoSolicitante", trabajador.getTipoSolicitante()); 
				modelnView.addObject("tipoProceso", "40");
				modelnView.addObject("nssProceso", trabajador.getNss() ); 
				modelnView.addObject("curpProceso", trabajador.getDatosCertificables().getCurp()); 
				modelnView.addObject("entradaRecepcionImagenes",entradaRecepcion);
				modelnView.addObject("urlSiguiente", "/private/enviarDigitalizacion.do");
				
			}
			request.getSession().setAttribute(ParametrosConstants.PASO_CUATRO_RETIROS, NumerosConstants.C_CUATRO);
		}catch (BusinessException be) {
			logger.error("Ocurrio una excepcion en solicitaCertificado {}",be);
			RechazoPulssar rechazo = rechazoService.obtenerRechazo(be.getCodigo(), user.getAforeUsuario());
			map.addAttribute(Constants.ERROR, rechazo.getMensaje());
			modelnView = new ModelAndView(NavegacionEnum.SUB_MENU_RETIRO_PARCIAL.getNavegacion());
		}

		return modelnView;
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@PostMapping(value = "/private/enviarArchivos", produces = { "application/json" })
	public Map<String, String> capturarArchivos(HttpServletRequest request, MultipartHttpServletRequest requestMultipart) {
		HashMap<String, String> response = new HashMap<>();
		Map<String, MultipartFile> arregloArchivos = new HashMap<>();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		FolioEntrada folioEntrada = (FolioEntrada) request.getSession().getAttribute("folioEntrada");
		String destino = (String) request.getSession().getAttribute(Constants.DESTINO);
		List<Combo> obligatorios = (List<Combo>) request.getSession().getAttribute(ParametrosConstants.OBLIGATORIOS);
		List<Combo> noObligatorios = (List<Combo>) request.getSession().getAttribute(ParametrosConstants.NO_OBLIGATORIOS);
		String tipoDocumento = (String) request.getSession().getAttribute("tipoDocumento");
		String origen = (String) request.getSession().getAttribute(ParametrosConstants.ORIGEN);
		SolicitarCertificacionMatrimonioEntrada agmConyuge = (SolicitarCertificacionMatrimonioEntrada) request.getSession().getAttribute("agmCertEntrada");
		RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>>  retiroMatrimonioImss =
				(RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>>) request.getSession().getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
		
		try {
			Map<String, MultipartFile> multipart = requestMultipart.getFileMap();


			List<Combo> docs = new ArrayList<>();
					
			CollectionUtils.addAll(docs, obligatorios);
			CollectionUtils.addAll(docs, noObligatorios);

			service.verificarSiEsValido(docs, multipart);
					
			Byte[] pdf = (Byte[]) request.getSession().getAttribute(GeneradorPdfConstants.PDF_SESION);
			
			if(ObjectUtils.isEmpty(pdf)) {
				throw new BusinessException("Documento no esta en sesion");
			}
			

			arregloArchivos = service.limpiarYValidarMultipart(multipart);		
					
			

			String cuentaClabe = (String) request.getSession().getAttribute("cuentaClabe");
			
			FolioComplemento folioComp = fabricaFolioComplementoService.enviarArchivosGenerico(folioEntrada.getIdFolio(), user, trabajador, cuentaClabe);
			folioComp.setTipoProceso(tipoDocumento);
			if(!trabajador.getTipoSolicitante().equals("01")){
				EntradaConsulta entradaConsulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.SESSION_USUARIO_COPPEL);
				logger.info("entradaConsulta: {}", entradaConsulta);
				folioComp.setCurpSolicitante(entradaConsulta.getCurpSolicitante());

				FolioComplemento folioCompParticipante = fabricaFolioComplementoService.generarFolioParticipante(folioEntrada.getIdFolio(), user, trabajador, entradaConsulta);
				folioCompParticipante.setTipoProceso("04");
				servicioArchivos.guardarDatosFolioComplementario(folioCompParticipante);
			}
			
			if(Constants.MATRIMONIO.equals(origen)) {
				folioComp.setNombreConyuge(agmConyuge.getNombreConyuge());
				folioComp.setSexo("1".equals(agmConyuge.getSexoConyuge().toString()) ? "H":"M");
				DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
				DateTime jt = dtf.parseDateTime(agmConyuge.getFechaMatrimonio());
				folioComp.setFechaMatrimonio(jt.toDate());
			}
			servicioArchivos.guardarDatosFolioComplementario(folioComp);

			DatosCertificables datosCertificables = trabajador.getDatosCertificables();
			EnvioArchivos datosRecepcion = fabricaFolioComplementoService.generarDatosRecepcion(user, datosCertificables.getCurp(), folioEntrada.getFolioHijo(), trabajador.getTipoAfiliacion(),tipoDocumento);

			String fotografia;
			if("01".equals(trabajador.getTipoSolicitante())){
				fotografia = trabajador.getImagen();
			} else {
				fotografia = null;
			}
			RespuestaServicio respuestaServicio = service.verificarArchivos(null, arregloArchivos, datosRecepcion, docs, fotografia, ArrayUtils.toPrimitive(pdf));
			logger.info("respuestaServicioPrueba: {}", respuestaServicio);
			if(respuestaServicio.getFlujo()!= 1){
				response.put("error", respuestaServicio.getMensaje());
			}
			limpiaSesion(request); 
		} catch (BusinessException e) {
			logger.error("Se presento un problema al capturar archivos ", e);
			response.put("error", e.getMessage());
		} catch (Exception e) {
			logger.error("Se presento un problema al capturar archivos ", e);
			RespuestaServicio respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			response.put("error", respuesta.getMensaje());
		}
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		request.getSession().setAttribute(ParametrosConstants.TERMINO_FLUJO, true);
		response.put(Constants.DESTINO, destino);
		logger.info("origen: {}",origen);
		if(Constants.DESEMPLEO.equals(origen) || Constants.MATRIMONIO.equals(origen)){
			RetiroDesempleoImss retiroDesempleoImss = (RetiroDesempleoImss) request.getSession()
					.getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
			if(utileriaValidador.isEmpty(retiroDesempleoImss.getPeticion07())) {
				serviceProcesoPendiente.insertarProcesoPendiente(retiroDesempleoImss.getPeticion12());
			} else {
				serviceProcesoPendiente.insertarProcesoPendiente(retiroDesempleoImss.getPeticion07());
				serviceProcesoPendiente.insertarProcesoPendiente(retiroDesempleoImss.getPeticion12());
			}			
		}

		return response;
	}
	
	
	@PostMapping(value="/private/enviarDigitalizacion.do")
	public ModelAndView capturarArchivosDigitalizacion(HttpServletRequest request) {
		HashMap<String, String> response = new HashMap<>();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		String folioDocumentos = (String) request.getSession().getAttribute(ParametrosConstants.FOLIO_DOCUMENTOS);
		ParametrosRetiroParcialCalculoImss calculo = (ParametrosRetiroParcialCalculoImss) request.getSession()
				.getAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS);
		String rutaZip = (String) request.getSession().getAttribute("destinoArchivo");
		String origen = (String) request.getSession().getAttribute(ParametrosConstants.ORIGEN);
		SolicitarCertificacionMatrimonioEntrada agmConyuge = (SolicitarCertificacionMatrimonioEntrada) request.getSession().getAttribute("agmCertEntrada");
		RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>>  retiroMatrimonioImss =
				(RetiroDesempleoImss<Peticion<SolicitarCertificacionMatrimonioEntrada>>) request.getSession().getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);

		
		try {
			String cuentaClabe = (String) request.getSession().getAttribute("cuentaClabe");
			FolioComplemento folioComp = fabricaFolioComplementoService.enviarArchivosGenerico(calculo.getIdFolio(), user, trabajador, cuentaClabe);
			folioComp.setTipoProceso("40");
			EntradaConsulta entradaConsulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.SESSION_USUARIO_COPPEL);
			logger.info("entradaConsulta: {}", entradaConsulta);
			if(!entradaConsulta.getCvTipoSolicitante().equals("01")){
				folioComp.setCurpSolicitante(entradaConsulta.getCurpSolicitante());
				FolioComplemento folioCompParticipante = fabricaFolioComplementoService.generarFolioParticipante(calculo.getIdFolio(), user, trabajador, entradaConsulta);
				folioCompParticipante.setTipoProceso("04");
				servicioArchivos.guardarDatosFolioComplementario(folioCompParticipante);
			}
			logger.info("origen:{},agmConyuge{}, folioComp:{}", origen, agmConyuge, folioComp);
			if(Constants.MATRIMONIO.equals(origen)) {
				folioComp.setNombreConyuge(agmConyuge.getNombreConyuge().concat(" ").concat(agmConyuge.getApellidoMaternoTrabajador()).concat(" ").concat(agmConyuge.getApellidoPaternoTrabajador()));
				folioComp.setSexo("1".equals(agmConyuge.getSexoConyuge().toString()) ? "H":"M");
				DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy/MM/dd");
				DateTime jt = dtf.parseDateTime(agmConyuge.getFechaMatrimonio());
				folioComp.setFechaMatrimonio(jt.toDate());
			}
			
			servicioArchivos.guardarDatosFolioComplementario(folioComp);

			DatosCertificables datosCertificables = trabajador.getDatosCertificables();
			datosCertificables.getCurp();
			EnvioArchivos datosRecepcion = new EnvioArchivos();
			datosRecepcion.setClaveAfore(user.getAforeUsuario());
			datosRecepcion.setCurpEmpleado(user.getCurpAgente());
			datosRecepcion.setCurpTrabajador(datosCertificables.getCurp());
			datosRecepcion.setFolio(calculo.getFolioHijo());
			datosRecepcion.setFolioIdentificacion(folioDocumentos);
			datosRecepcion.setProceso("40");
			datosRecepcion.setTipoArchivo(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
			String tipoTrabajador = servicioExpediente.obtenerValoresPantalla(null, trabajador.getTipoAfiliacion());
			datosRecepcion.setTipoTrabajador(tipoTrabajador);

			RespuestaServicio respuesta = servicioArchivos.enviarArchivosDigitalizados(null, datosRecepcion, rutaZip);

			logger.info("respuestaServicioPrueba: {}", respuesta);
			if (respuesta.getFlujo() != 1) {
				response.put("error", respuesta.getMensaje());
			}
			limpiaSesion(request);
		} catch (BusinessException e) {
			logger.error("Se presento un problema al capturar archivos ", e);
			response.put("error", e.getMessage());
		} catch (Exception e) {
			logger.error("Se presento un problema al capturar archivos ", e);
			RespuestaServicio respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
			response.put("error", respuesta.getMensaje());
		}
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		request.getSession().setAttribute(ParametrosConstants.TERMINO_FLUJO, true);
		ParametrosRetiroParcialCalculoImss parametrosRetiroParcialCalculoImss = (ParametrosRetiroParcialCalculoImss)request.getSession().getAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS);
		String destino = (String) request.getSession().getAttribute(Constants.DESTINO);
		ModelAndView model = new ModelAndView("/mx/com/procesar/plataforma/servicios/generales/visorDocumentosEspera");
		model.addObject("parametrosRetiroParcialCalculoImss", parametrosRetiroParcialCalculoImss);
		model.addObject(Constants.DESTINO, destino);
		logger.info("origen: {}",origen);
		if(Constants.DESEMPLEO.equals(origen) || Constants.MATRIMONIO.equals(origen)){
			RetiroDesempleoImss retiroDesempleoImss = (RetiroDesempleoImss) request.getSession()
					.getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
			if(utileriaValidador.isEmpty(retiroDesempleoImss.getPeticion07())) {
				serviceProcesoPendiente.insertarProcesoPendiente(retiroDesempleoImss.getPeticion12());
			} else {
				serviceProcesoPendiente.insertarProcesoPendiente(retiroDesempleoImss.getPeticion07());
				serviceProcesoPendiente.insertarProcesoPendiente(retiroDesempleoImss.getPeticion12());
			}			
		}
		/*aqui*/
		return model;

	}
	/**
	 * @param request
	 */
	private void limpiaSesion(HttpServletRequest request) {
		request.getSession().removeAttribute(ParametrosConstants.EXCLUSION);
		request.getSession().removeAttribute(ParametrosConstants.ADICIONAL);
		request.getSession().removeAttribute(ATRIBUTO_URL_PDF);
		request.getSession().removeAttribute(ATRIBUTO_CONTIENE_FIRMA_EMPLEADO);
		request.getSession().removeAttribute(ATRIBUTO_CONTIENE_FIRMA_AGENTE);
		request.getSession().removeAttribute(ATRIBUTO_SOLICITA_FIRMAS);
		request.getSession().removeAttribute(ATRIBUTO_URL_PAGINA_SIGUIENTE);
		request.getSession().removeAttribute(ATRIBUTO_METODO_PAGINA_SIGUIENTE);
		request.getSession().removeAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_ISSSTE);
		request.getSession().removeAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_IMSS);
	}
	
	/**
	 * Generico para la recepcion de imagenes
	 * @param request
	 * @param map
	 * @param entradaRecepcionImagenes
	 * @return
	 */
	@GetMapping(value="/private/recepcionImagenesGenerico.do")
	public ModelAndView recuperarImagenes(HttpServletRequest request, ModelMap map, @ModelAttribute("entradaRecepcionImagenes")  EntradaRecepcionImagenes entradaRecepcionImagenes ){
		logger.info("Incia Recepcion Imagenes para Visualizador: folio = {} proceso = {} estatus = {}", entradaRecepcionImagenes.getFolioPadre(), entradaRecepcionImagenes.getTipoProceso(), entradaRecepcionImagenes.getEstatusRecepcion());
		
		UsuarioLogin usuario = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		FolioEntrada folioEntrada = (FolioEntrada) request.getSession().getAttribute("folioEntrada");
		ModelAndView model = new ModelAndView(NavegacionEnum.VISOR_IMAGENES_RETIRO.getNavegacion());
		ImagenWrapper wrapper = new ImagenWrapper();
		String radioTipoTrabajador = request.getParameter("tipo");
		request.getSession().removeAttribute(ParametrosConstants.SESSION_TIPO_TRABAJADOR_RADIO);
		List<ImagenDocumento> documentos = null;
		
		Folio folioHijo = (Folio) request.getSession().getAttribute(ParametrosConstants.REQUEST_FOLIO_HIJO);
		String bandera13 =(String)request.getSession().getAttribute(ParametrosConstants.BANDERA_13);
		String banderaP = (String)request.getSession().getAttribute(ParametrosConstants.BANDERA_PERMANENCIA);
		EntradaModificacion entradaModificacion = (EntradaModificacion)request.getSession().getAttribute(ParametrosConstants.ENTRADA_MODIFICACION_DATOS_13PLUS);
		EntradaPermanencia entradaPermanencia = (EntradaPermanencia)request.getSession().getAttribute(ParametrosConstants.ENTRADA_PERMANENCIA);
		Byte[] tmp = (Byte[]) request.getSession().getAttribute(GeneradorPdfConstants.PDF_SESION);

		String curp = null;
		String chFolioHijo = null;
		String cvTipoProceso = null;
		
		curp = service.obtenerCurpGenericoRecepcionImagenes(entradaRecepcionImagenes.getTipoProceso(), trabajador.getTipoSolicitante(), bandera13, banderaP, trabajador, entradaModificacion, entradaPermanencia);
		chFolioHijo = service.obtenerFolioHijoGenericoRecepcionImagenes(entradaRecepcionImagenes.getTipoProceso(), folioEntrada, folioHijo);
		RecepcionImagenes imagenes = recepcionImagenesService.consultarRecepcionImagenes(entradaRecepcionImagenes.getFolioPadre(), entradaRecepcionImagenes.getTipoProceso(), entradaRecepcionImagenes.getEstatusRecepcion());
		if(!utileriaValidador.validarListaVacia(imagenes.getDetalleRecepcionImagen())) {
			logger.info("Inicio -Se recuperan imagenes del folio: {}", entradaRecepcionImagenes.getFolioPadre());
			documentos = recepcionImagenesService.obtenerDocumentos(imagenes, usuario.getAforeUsuario());
			logger.info("Fin - Se recuperan imagenes del folio: {}", entradaRecepcionImagenes.getFolioPadre());
			
			wrapper.setImagenes(documentos);
		}
		
		cvTipoProceso = service.obtenerCvTipoProcesoGenericoRecepcionImagenes(entradaRecepcionImagenes.getTipoProceso(), trabajador.getTipoSolicitante());
		EnvioArchivos datosRecepcion = fabricaFolioComplementoService.generarDatosRecepcion(usuario, curp, chFolioHijo, trabajador.getTipoAfiliacion(),cvTipoProceso);
		if(entradaRecepcionImagenes.getTipoProceso().equals("40")){
			ImagenDocumento imgDoc = new ImagenDocumento();
			imgDoc.setContenidoDocumento(Base64Utils.encodeToString(ArrayUtils.toPrimitive(tmp)));
			imgDoc.setClaveTipoDocumento("62");
			imgDoc.setNombreDocumento("solicitud.pdf");
			wrapper.getImagenes().add(imgDoc);
			if(!utileriaValidador.validarVacio(trabajador.getImagen())){
				imgDoc = new ImagenDocumento();
				imgDoc.setContenidoDocumento(trabajador.getImagen());
				imgDoc.setClaveTipoDocumento("31");
				imgDoc.setNombreDocumento("fotografia.png");
				wrapper.getImagenes().add(imgDoc);
			}
		}else if(entradaRecepcionImagenes.getTipoProceso().equals(expedienteServicio.obtenerProcesoExpedienteServicio(trabajador.getTipoSolicitante()))) {
			ImagenDocumento imgDoc = new ImagenDocumento();
			imgDoc.setContenidoDocumento(Base64Utils.encodeToString(ArrayUtils.toPrimitive(tmp)));
			imgDoc.setClaveTipoDocumento("69");
			imgDoc.setNombreDocumento("solicitud.pdf");
			wrapper.getImagenes().add(imgDoc);
		}
		
		try {
			String rutaDestino = generacionZipService.validarArchivosRecibidos(wrapper, datosRecepcion);
			request.getSession().setAttribute("destinoArchivo", rutaDestino);
			List<ImagenDocumento> documentosFiltrados = recepcionImagenesService.filtrarDocumentos(documentos, usuario.getAforeUsuario(), imagenes);
			wrapper = new ImagenWrapper();
			wrapper.setImagenes(documentosFiltrados);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		request.getSession().setAttribute(ParametrosConstants.SESSION_ENTRADA_IMAGENES, entradaRecepcionImagenes);
		request.getSession().setAttribute(ParametrosConstants.SESSION_TIPO_TRABAJADOR_RADIO, radioTipoTrabajador);
		model.addObject(Constants.DESTINO, entradaRecepcionImagenes.getUrlSiguiente());
		model.addObject("imagenesDoctos", wrapper);
		return model;
		
	}

}
