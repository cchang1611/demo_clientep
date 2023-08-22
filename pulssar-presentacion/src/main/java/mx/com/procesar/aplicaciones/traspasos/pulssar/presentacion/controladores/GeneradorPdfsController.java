/**
 * GeneradorPdfsController.java
 * Fecha de creación: Oct 4, 2019, 6:02:03 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ARCHIVO_SIN_CONTENIDO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_ARCHIVO_GENERADO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_CONTIENE_FIRMA_AGENTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_CONTIENE_FIRMA_EMPLEADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_DATOS_SOLICITUD_MATRIMONIO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_METODO_PAGINA_SIGUIENTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_SOLICITA_FIRMAS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_URL_PAGINA_SIGUIENTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_URL_PDF;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CLAVE_FIRMA_AGENTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CLAVE_FIRMA_EMPLEADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CLAVE_PROCESO_RETIROS_PARCIALES_IMSS_LINEA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CLAVE_TIPO_ARCHIVO_IDENTIFICACION_OFICIAL_SERVICIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CLAVE_TIPO_ARCHIVO_SOLICITUD_TRABAJADOR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CONSECUTIVO_1;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.DISPOSICION_TOTAL_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.DISPOSICION_TOTAL_ISSSTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ERROR_ADJUNTAR_ARCHIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ERROR_ARCHIVO_MAYOR_UN_MEGA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.EXTENSION_PDF;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ID_PDF_SOLICITUD_RETIRO_DESEMPLEO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ID_PDF_SOLICITUD_RETIRO_MATRIMONIO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PDF_CONTENT_TYPE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.UN_KILOBYTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.UN_MEGABYTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.URL_PDF_ADJUNTAR_ARCHIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.URL_PDF_MOSTRAR_VENTANA_GENERAL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.URL_PDF_SOLICITUD_RETIRO_DESEMPLEO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.URL_PDF_SOLICITUD_RETIRO_MATRIMONIO_IMSS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.URL_VISTA_PREVIA_PDF_ADJUNTADO_IMSS;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.PdfGeneradorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudRetiroParcialMatrimonioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDocumentoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNombreArchivoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialMatrimonio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaTramite;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.GeneradorPdfUtils;
/**
 * controller para la generación de los PDF's
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Oct 4, 2019
 */
@Controller
public class GeneradorPdfsController extends GeneradorPdfsBaseController{
	/**
	 * log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(GeneradorPdfsController.class);

	/**
	 * mapeo para indicar si el PDF contiene las firmas de de empleado y agente
	 */
	protected static final Map<Integer, Map<String, Boolean>> mapaFirmas = new HashMap<>();

	
	/**
	 * servicios para generar los PDF's
	 */
	@Autowired
	private GeneradorPdfsService generadorPdfsService;

	/**
	 * servicio de utilidades para generar PDF's
	 */
	@Autowired
	private GeneradorPdfUtils generadorPdfUtils;
	
	
	/**
	 * SolicitudRetiroParcialMatrimonioService
	 */
	@Autowired
	private SolicitudRetiroParcialMatrimonioService solicitudService;
	
	
	/**
	 * folioService
	 */
	@Autowired
	private FolioService folioService;
	
	/**
	 * pdfUtils
	 */
	@Autowired
	private PdfGeneradorUtils pdfUtils;

	static {
		Map<String, Boolean> mapaSolicitudRetiro = new HashMap<>();
		mapaSolicitudRetiro.put(CLAVE_FIRMA_EMPLEADO, Boolean.TRUE);
		mapaSolicitudRetiro.put(CLAVE_FIRMA_AGENTE, Boolean.TRUE);
		mapaFirmas.put(ID_PDF_SOLICITUD_RETIRO_DESEMPLEO_IMSS, mapaSolicitudRetiro);	
		mapaFirmas.put(ID_PDF_SOLICITUD_RETIRO_MATRIMONIO_IMSS, mapaSolicitudRetiro);
		mapaFirmas.put(DISPOSICION_TOTAL_ISSSTE, mapaSolicitudRetiro);
		mapaFirmas.put(DISPOSICION_TOTAL_IMSS, mapaSolicitudRetiro);
	}

	
	/**
	 * 
	 * muestra la venta con la plantilla indicada
	 * 
	 * /private/pdf/id/{pdfId}
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param pdfId
	 * @param model
	 * @return
	 */
	@GetMapping(value = URL_PDF_MOSTRAR_VENTANA_GENERAL)
	public ModelAndView mostrarVentana(@PathVariable int pdfId, Model model, HttpServletRequest request) {
		logger.info("entro a ventana general id Pdf: {}", pdfId);
		DatosDocumentoPdf datosPdf = (DatosDocumentoPdf) request.getSession().getAttribute(ParametrosConstants.DATOS_PDF);
		logger.info("entro a ventana general id Pdf: {}", datosPdf);
		
		guardarSesionDatosPdf(pdfId, datosPdf, request);
		request.getSession().removeAttribute(ParametrosConstants.DATOS_PDF);
		request.getSession().removeAttribute(ATRIBUTO_ARCHIVO_GENERADO_IMSS);
		request.getSession().setAttribute(ATRIBUTO_URL_PDF, obtenerUrlSalida(pdfId));
		Map<String, Boolean> mapa = mapaFirmas.get(pdfId);
		request.getSession().setAttribute(ATRIBUTO_CONTIENE_FIRMA_EMPLEADO, mapa.get(CLAVE_FIRMA_EMPLEADO));
		request.getSession().setAttribute(ATRIBUTO_CONTIENE_FIRMA_AGENTE, mapa.get(CLAVE_FIRMA_AGENTE));
		request.getSession().setAttribute(ATRIBUTO_URL_PAGINA_SIGUIENTE, datosPdf.getUrlPaginaSiguiente());
		request.getSession().setAttribute(ATRIBUTO_METODO_PAGINA_SIGUIENTE, obtenerMetodoPaginaSiguiente(datosPdf.getMetodoPaginaSiguiente()));
		request.getSession().setAttribute(ATRIBUTO_SOLICITA_FIRMAS, solicitaFirmas(mapa.get(CLAVE_FIRMA_EMPLEADO), mapa.get(CLAVE_FIRMA_AGENTE)));
		
		return new ModelAndView(NavegacionEnum.FORWARD_UPLD_DOCTOS_GENERICO.getNavegacion());
	}
	
	/**
	 * 
	 *  envia el metodo evitando que este este vacío
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param metodo
	 *  @return
	 */
	protected String obtenerMetodoPaginaSiguiente(String metodo) {
		if(metodo==null||metodo.trim().isEmpty()) {
			return HttpMethod.GET.toString();
		}
		
		return metodo;
	}
	
	/**
	 * 
	 *  define si el pdf solicita firmas
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param valorBanderas
	 *  @return
	 */
	protected boolean solicitaFirmas(Boolean... valorBanderas) {
		for(Boolean valor: valorBanderas) {
			if(valor.booleanValue()) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 *  se guarda en sesion el contenido del pdf
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param pdfId
	 *  @param datosPdf
	 *  @param request
	 */
	private void guardarSesionDatosPdf(int pdfId, DatosDocumentoPdf datosPdf, HttpServletRequest request) {
		if(pdfId == ID_PDF_SOLICITUD_RETIRO_DESEMPLEO_IMSS){
			DatosSolicitudRetiroParcialDesempleo datosPdfSolicitud = (DatosSolicitudRetiroParcialDesempleo) datosPdf.getDatos();
			datosPdfSolicitud.setFechaNacimiento(generadorPdfUtils.obtenerFechaNacimientoFormatoPdf(datosPdfSolicitud.getFechaNacimiento()));
			request.getSession().setAttribute(ParametrosConstants.DATOS_ESPECIFICOS_PDF, datosPdfSolicitud);
			logger.info("datos del pdf: {}", datosPdfSolicitud);
			request.getSession().setAttribute(ParametrosConstants.ID_PDF_ACTUAL, pdfId);
		}
	}
	
	/**
	 * 
	 * envia el PDF para la solicitud de retiro de desempleo
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud
	 * @param response
	 * @throws IOException
	 * @
	 */
	@GetMapping(value = URL_PDF_SOLICITUD_RETIRO_DESEMPLEO_IMSS)
	public void generarSolicitudRetiroParcialDesempleo(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.getSession().removeAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_IMSS);
		request.getSession().removeAttribute(ParametrosConstants.NOMBRES_ARCHIVOS);
		procesarSolicitudRetiroParcialDesempleo(null, null, request, response);
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping(value = URL_PDF_SOLICITUD_RETIRO_MATRIMONIO_IMSS)
	public void generarSolicitudRetiroParcialMatrimonio(HttpServletRequest request, HttpServletResponse response, @ModelAttribute RetiroDesempleoImss retiroMatrimonioImss) throws IOException {
		request.getSession().removeAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_IMSS);
		request.getSession().removeAttribute(ParametrosConstants.NOMBRES_ARCHIVOS);
		procesarSolicitudRetiroParcialMatrimonio(null, null, request, response);
	}	
	
	/**
	 * 
	 *  envia el PDF para la solicitud de retiro de desempleo
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param firmaEmpleado
	 *  @param firmaAgente
	 *  @param request
	 *  @param response
	 */
	@PostMapping(value = URL_PDF_SOLICITUD_RETIRO_DESEMPLEO_IMSS)
	public void generarSolicitudRetiroParcialDesempleo(@RequestParam String firmaEmpleado,
			@RequestParam String firmaAgente, HttpServletRequest request, HttpServletResponse response) {
		procesarSolicitudRetiroParcialDesempleo(firmaEmpleado, firmaAgente, request, response);
	}
	
	
	
	/**
	 * @param firmaEmpleado
	 * @param firmaAgente
	 * @param request
	 * @param response
	 */
	@PostMapping(value = URL_PDF_SOLICITUD_RETIRO_MATRIMONIO_IMSS)
	public void generarSolicitudRetiroMatrimonio(@RequestParam String firmaEmpleado,
			@RequestParam String firmaAgente, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute RetiroDesempleoImss retiroMatrimonioImss) {
		procesarSolicitudRetiroParcialMatrimonio(firmaEmpleado, firmaAgente, request, response);
	}

	/**
	 * 
	 * envia el PDF de la solicitud de retiro de disposicion parcial por desemepleo del IMSS
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param firmaEmpleado
	 * @param firmaAgente
	 * @param response
	 */
	private void procesarSolicitudRetiroParcialDesempleo(String firmaEmpleado, String firmaAgente,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession sesion = request.getSession();
		ParametrosRetiroParcialCalculoImss calculo = (ParametrosRetiroParcialCalculoImss) sesion.getAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS);
		DatosSolicitudRetiroParcialDesempleo solicitud = (DatosSolicitudRetiroParcialDesempleo) sesion.getAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_IMSS);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
		Boolean flujo532 = (Boolean) request.getSession().getAttribute(ParametrosConstants.SESSION_RESPUESTA_532);
		RetiroDesempleoImss retiroDesempleoImss = (RetiroDesempleoImss) request.getSession().getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
		
		String afore = trabajador.getClaveAfore();
		if (solicitud == null) {
			solicitud = (DatosSolicitudRetiroParcialDesempleo) request.getSession().getAttribute(ParametrosConstants.DATOS_ESPECIFICOS_PDF);
			logger.info("datos del documento pdf: {}", solicitud);
			String nombreArchivo = obtenerNombreArchivoSolicitudRetiroParcialDesempleoImss(request, CLAVE_TIPO_ARCHIVO_SOLICITUD_TRABAJADOR, calculo.getFolioHijo());
			solicitud.setNombreArchivo(nombreArchivo);
			guardarNombresArchivosSesion(request, CLAVE_TIPO_ARCHIVO_SOLICITUD_TRABAJADOR, nombreArchivo);
			sesion.setAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_IMSS, solicitud);
		}

		solicitud.setFirmaEmpleado(firmaEmpleado);
		solicitud.setFirmaAgente(firmaAgente);
		solicitud.setNumeroUnidad(ObjectUtils.isEmpty(objetoCoppel)? "" : objetoCoppel.getNumeroTienda());
		solicitud.setCompaniaCelular(retiroDesempleoImss.getTelefonia());
		
		sesion.setAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_IMSS, solicitud);
		logger.info("datos de la solicitud: {}", solicitud);

		byte[] pdf = generadorPdfsService.generarSolicitudRetiroParcialDesempleo(solicitud, afore, flujo532);
		request.getSession().setAttribute(GeneradorPdfConstants.PDF_SESION, ArrayUtils.toObject(pdf));
		if(StringUtils.isNotEmpty(firmaEmpleado) && StringUtils.isNotEmpty(firmaAgente)) {
			pdfUtils.generarPdfLocal(request, pdf, trabajador.getClaveAfore(), solicitud.getNumeroFolio(), "4062");
		}
		enviarPdf(pdf, response);
	}
	
	
	/**
	 * @param firmaEmpleado
	 * @param firmaAgente
	 * @param request
	 * @param response
	 */
	private void procesarSolicitudRetiroParcialMatrimonio(String firmaEmpleado, String firmaAgente, HttpServletRequest request, HttpServletResponse response) {
		HttpSession sesion = request.getSession();
		ParametrosRetiroParcialCalculoImss calculo = (ParametrosRetiroParcialCalculoImss) sesion.getAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		request.getSession().removeAttribute(ParametrosConstants.DATOS_ESPECIFICOS_PDF);
		SolicitarCertificacionMatrimonioEntrada agmConyuge = (SolicitarCertificacionMatrimonioEntrada) request.getSession().getAttribute("agmCertEntrada");
		RetiroDesempleoImss retiroMatrimonioImss = (RetiroDesempleoImss) request.getSession().getAttribute(ParametrosConstants.DATOS_RETIRO_PARCIAL_IMSS);
		DatosDocumentoPdf  datosPdf = (DatosDocumentoPdf) request.getSession().getAttribute(ParametrosConstants.DATOS_PDF_MATRIMONIO);
		DatosSolicitudRetiroParcialMatrimonio solicitud = (DatosSolicitudRetiroParcialMatrimonio) sesion.getAttribute(ATRIBUTO_DATOS_SOLICITUD_MATRIMONIO_IMSS);
		EntradaCoppel objetoCoppel = (EntradaCoppel) request.getSession().getAttribute(ParametrosConstants.SESSION_EXTRAS_COPPEL);
		EntradaConsulta consulta = (EntradaConsulta) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS_FOLIO_ACTIVO);
		String nombreArchivo = obtenerNombreArchivoSolicitudRetiroParcialDesempleoImss(request,	CLAVE_TIPO_ARCHIVO_SOLICITUD_TRABAJADOR, calculo.getFolioHijo());
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		
		guardarNombresArchivosSesion(request, CLAVE_TIPO_ARCHIVO_SOLICITUD_TRABAJADOR, nombreArchivo);

		solicitud.setFirmaEmpleado(firmaEmpleado);
		solicitud.setFirmaAgente(firmaAgente);
		solicitud.setNumeroUnidad(ObjectUtils.isEmpty(objetoCoppel)? "" : objetoCoppel.getNumeroTienda());
		solicitud.setCompaniaCelular(retiroMatrimonioImss.getTelefonia());
		
		sesion.setAttribute(ATRIBUTO_DATOS_SOLICITUD_MATRIMONIO_IMSS, solicitud);
		
		byte[] pdf =  solicitudService.generaSolicitudPdf(agmConyuge, trabajador, datosPdf, retiroMatrimonioImss, firmaEmpleado, firmaAgente, consulta, user);
		request.getSession().setAttribute(GeneradorPdfConstants.PDF_SESION, ArrayUtils.toObject(pdf));
		if(StringUtils.isNotEmpty(firmaEmpleado) && StringUtils.isNotEmpty(firmaAgente)) {
			logger.error("se guarda documento en sesion SolicitudRetiroParcialMatrimonio");
			pdfUtils.generarPdfLocal(request, pdf, trabajador.getClaveAfore(), solicitud.getNumeroFolio(), "4062");
		}
		
		enviarPdf(pdf, response);
	}
	
	/**
	 * 
	 * obtener la url del pdf a mostrar
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param pdfId
	 * @return
	 */
	private String obtenerUrlSalida(int pdfId) {

		if(pdfId == ID_PDF_SOLICITUD_RETIRO_DESEMPLEO_IMSS){
			return URL_PDF_SOLICITUD_RETIRO_DESEMPLEO_IMSS;
		} else if (pdfId == ID_PDF_SOLICITUD_RETIRO_MATRIMONIO_IMSS){
			return URL_PDF_SOLICITUD_RETIRO_MATRIMONIO_IMSS;
		} else if (pdfId == DISPOSICION_TOTAL_ISSSTE){
			return GeneradorPdfConstants.URL_PDF_SOLICITUD_DISPOSICION_ISSSTE;
		} else if (pdfId == DISPOSICION_TOTAL_IMSS){
			return GeneradorPdfConstants.URL_PDF_SOLICITUD_DISPOSICION_IMSS;
		} else {
			return "";
		}
	}
	
	/**
	 * 
	 *  obtiene el nombre del archivo pdf de la solicitud de retiro parcial
	 *  por desempleo del IMSS
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param request
	 *  @return
	 */
	protected String obtenerNombreArchivoSolicitudRetiroParcialDesempleoImss(HttpServletRequest request, String claveTipoArchivo, String folioHijo) {
		DatosNombreArchivoPdf datosNombre = new DatosNombreArchivoPdf();
		DatosTrabajador datosTrabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		
		if(datosTrabajador!=null) {
			datosNombre.setClaveAfore(datosTrabajador.getClaveAfore());
			
			if(datosTrabajador.getDatosCertificables()!=null) {
				datosNombre.setCurp(datosTrabajador.getDatosCertificables().getCurp());	
			}
			
			String afiliacion = obtenerTipoAfiliacion(datosTrabajador.getTipoAfiliacion());            
            datosNombre.setTipoTrabajador(afiliacion);

			datosNombre.setFolioArchivo(folioHijo);
			
		}
		
		
		datosNombre.setConsecutivo(CONSECUTIVO_1);
		datosNombre.setFechaOperacion(new Date());
		datosNombre.setClaveProceso(CLAVE_PROCESO_RETIROS_PARCIALES_IMSS_LINEA);
		datosNombre.setClaveTipoArchivo(claveTipoArchivo);
		datosNombre.setExtension(EXTENSION_PDF);
		return generadorPdfUtils.obtenerNombreArchivoPdf(datosNombre);
	}
	
	/**
     * Metodo que obtiene el tipo de afiliacion del trabajador
     * @param afiliacion
     * @return
     */
	protected String obtenerTipoAfiliacion(String afiliacion) {
		String respuesta = "0";
		if (GeneradorPdfConstants.AFILIACION_IMSS.contains(afiliacion)) {
			respuesta = "1";
		} else if (GeneradorPdfConstants.AFILIACION_ISSSTE.contains(afiliacion)) {
			respuesta = "2";
		}
		
		return respuesta;
	}	
	
	/**
	 * 
	 *  se encarga de subir el archivo al servidor
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param archivo
	 *  @param modelo
	 *  @param request
	 *  @return
	 */
	@PostMapping(value=URL_PDF_ADJUNTAR_ARCHIVO)
	public String adjuntarPdf(@RequestParam MultipartFile archivo, ModelMap modelo, HttpServletRequest request) {
		logger.info("entro en adjuntarPdf");
		int respuesta = 0;
		String mensaje = null;
		String nombreArchivo = "";
		int idPdf = (int) request.getSession().getAttribute(ParametrosConstants.ID_PDF_ACTUAL);
		ParametrosRetiroParcialCalculoImss calculo = (ParametrosRetiroParcialCalculoImss) request.getSession()
				.getAttribute(ParametrosConstants.PARAMETROS_RETIRO_PARCIAL_CALCULO_IMSS);

		if(idPdf == ID_PDF_SOLICITUD_RETIRO_DESEMPLEO_IMSS){
			nombreArchivo = obtenerNombreArchivoSolicitudRetiroParcialDesempleoImss(request, CLAVE_TIPO_ARCHIVO_IDENTIFICACION_OFICIAL_SERVICIO, calculo.getFolioHijo());
		}
		
		if(!archivo.isEmpty()) {
			logger.info("tamano archivo: {}", archivo.getSize());
			if(archivo.getSize()>UN_MEGABYTE) {
				mensaje = ERROR_ARCHIVO_MAYOR_UN_MEGA;
			}else {
				try {
					File archivoGenerado = generadorPdfsService.guardarArchivoServidor(archivo.getBytes(), nombreArchivo);
					request.getSession().setAttribute(ATRIBUTO_ARCHIVO_GENERADO_IMSS, archivoGenerado);
					guardarNombresArchivosSesion(request, CLAVE_TIPO_ARCHIVO_IDENTIFICACION_OFICIAL_SERVICIO, nombreArchivo);
					respuesta = 1;
				} catch (IOException e) {
					logger.error(ERROR_ADJUNTAR_ARCHIVO, e);
					mensaje = ERROR_ADJUNTAR_ARCHIVO;
				}
				
			}
		} else {
			mensaje = ARCHIVO_SIN_CONTENIDO;
		}

		modelo.put(ParametrosConstants.CODIGO_RESPUESTA, respuesta);
		modelo.put(ParametrosConstants.MENSAJE_RESPUESTA, mensaje);
		return NavegacionEnum.RESPUESTA_ADJUNTAR_ARCHIVO.getNavegacion();
	}
	
	/**
	 * 
	 *  se guarda en sesion los nombre de archivo
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param request
	 *  @param claveTipoArchivo
	 *  @param nombreArchivo
	 */
	protected void guardarNombresArchivosSesion(HttpServletRequest request, String claveTipoArchivo, String nombreArchivo) {
		@SuppressWarnings("unchecked")
		Map<String, String> mapaNombresArchivo = (Map<String, String>) request.getSession().getAttribute(ParametrosConstants.NOMBRES_ARCHIVOS);
		
		if(mapaNombresArchivo==null) {
			mapaNombresArchivo = new HashMap<>();			
		}
		
		mapaNombresArchivo.put(claveTipoArchivo, nombreArchivo);
		request.getSession().setAttribute(ParametrosConstants.NOMBRES_ARCHIVOS, mapaNombresArchivo);
	}
	
	/**
	 * 
	 *  muestra la vista previa del archivo adjuntado
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param request
	 *  @param response
	 */
	@PostMapping(value=URL_VISTA_PREVIA_PDF_ADJUNTADO_IMSS)
	public void generarVistaPreviaArchivoAdjuntado(HttpServletRequest request, HttpServletResponse response) {
		File archivo = (File) request.getSession().getAttribute(ATRIBUTO_ARCHIVO_GENERADO_IMSS);
		
		if(archivo!=null) {
			response.setContentType(PDF_CONTENT_TYPE);
			try (FileInputStream entrada = new FileInputStream(archivo)){
				ServletOutputStream salida = response.getOutputStream();
				
				byte[] buffer = new byte[UN_KILOBYTE];
				while(entrada.read(buffer)!=-1) {
					salida.write(buffer);
				}
				
				salida.flush();
				request.getSession().removeAttribute(ATRIBUTO_ARCHIVO_GENERADO_IMSS);
			} catch (IOException e) {
				logger.error("error al generar la vista previa del archivo adjuntado", e);
			}
			
			
		}else {
			logger.error("No se encontro archivo adjuntado");
		}
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping(value = "/private/pdf/solicitudDisposicionIssste")
	private void generarPdfBanorte(HttpServletRequest request, HttpServletResponse response, String firmaEmpleado, String firmaAgente) throws IOException {
		DatosGeneralesDispIssste entradaParams = (DatosGeneralesDispIssste) request.getSession().getAttribute("datosGeneralesDispIssste");
        DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
        UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		folioService.cerrarFolio(trabajador.getFolio().getIdFolio(), null);
		FolioEntrada folioGenera = new FolioEntrada();
		folioGenera.setIdUsuario(user.getDatoUsuario());
		folioGenera.setOperacion(ActivacionConstants.OPERACION_S);
		folioGenera.setServicio(ActivacionConstants.SERVICIO_DISPOSICION_ISSTE_S14);
		folioGenera.setProceso(ActivacionConstants.PROCESO_DISPOSICION_ISSTES14P3);
		folioGenera.setSucursal(ActivacionConstants.SUCURSAL);
		folioGenera.setNss(trabajador.getNss());
		folioGenera.setCurp(trabajador.getDatosCertificables().getCurp());
		folioGenera.setTiempoLlegada(Constants.TIEMPO_LLEGADA);
		folioGenera.setOrigen(ActivacionConstants.ORIGEN);
		folioGenera = folioService.generarFolio(folioGenera);
		request.getSession().setAttribute("folioEntrada", folioGenera);
		request.getSession().setAttribute("folio", folioGenera);
		entradaParams.setFolioSol(folioGenera.getFolio());
		request.getSession().setAttribute("datosGeneralesDispIssste", entradaParams);
		trabajador.setFolio(folioGenera);
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		byte[] pdf =  generadorPdfsService.generaSolicitudIssstePdf(entradaParams);
		
		logger.info("se guarda documento en sesion generarPdfBanortes");
		request.getSession().setAttribute(GeneradorPdfConstants.PDF_SESION, ArrayUtils.toObject(pdf));
		enviarPdf(pdf, response);
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@GetMapping(value = "/private/pdf/solicitudDisposicionImss")
	private void generarPdfBanorteImss(HttpServletRequest request, HttpServletResponse response, String firmaEmpleado, String firmaAgente) throws IOException {
        DatosTrabajador trabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
        RespuestaTramite disposicionTotal   = (RespuestaTramite) request.getSession().getAttribute(ActivacionConstants.FORMULARIO_NO_CARGADO);	
		
 
		request.getSession().setAttribute(ParametrosConstants.REQUEST_DATOS, trabajador);
		
		byte[] pdf =  generadorPdfsService.generaSolicitudImssPdf(disposicionTotal, trabajador);
		
		logger.info("se guarda documento en sesion generarPdfBanorteImss");
		request.getSession().setAttribute(GeneradorPdfConstants.PDF_SESION, ArrayUtils.toObject(pdf));
		enviarPdf(pdf, response);
	}
}
