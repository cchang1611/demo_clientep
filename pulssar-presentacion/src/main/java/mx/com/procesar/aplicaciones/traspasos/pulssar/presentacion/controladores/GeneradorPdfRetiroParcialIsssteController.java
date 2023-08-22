/**
 * GeneradorPdfRetiroParcialIsssteController.java
 * Fecha de creación: Nov 19, 2019, 12:34:09 PM
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
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_ARCHIVO_GENERADO_ISSSTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_CONTIENE_FIRMA_AGENTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_CONTIENE_FIRMA_EMPLEADO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_ISSSTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_SOLICITA_FIRMAS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ATRIBUTO_URL_PDF;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CLAVE_PROCESO_RETIROS_PARCIALES_IMSS_LINEA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CLAVE_TIPO_ARCHIVO_IDENTIFICACION_OFICIAL_SERVICIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CLAVE_TIPO_ARCHIVO_SOLICITUD_TRABAJADOR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.CONSECUTIVO_1;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ERROR_ADJUNTAR_ARCHIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ERROR_ARCHIVO_MAYOR_UN_MEGA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.EXTENSION_PDF;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PDF_CONTENT_TYPE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.UN_KILOBYTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.UN_MEGABYTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.URL_PDF_ADJUNTAR_ARCHIVO_ISSSTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.URL_PDF_MOSTRAR_VENTANA_RETIRO_ISSSTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.URL_PDF_SOLICITUD_RETIRO_DESEMPLEO_ISSSTE;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.URL_VISTA_PREVIA_PDF_ADJUNTADO_ISSSTE;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.PdfGeneradorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDocumentoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNombreArchivoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.GeneradorPdfUtils;

/**
 * controlador para generar pdf retiro parcial issste
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Nov 19, 2019
 */
@Controller
public class GeneradorPdfRetiroParcialIsssteController extends GeneradorPdfsBaseController {
	/**
	 * log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(GeneradorPdfRetiroParcialIsssteController.class);
	
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
	 * pdfUtils
	 */
	@Autowired
	private PdfGeneradorUtils pdfUtils;
	
	/**
	 * 
	 * muestra la venta con la plantilla indicada
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param pdfId
	 * @param model
	 * @return
	 */
	@PostMapping(value = URL_PDF_MOSTRAR_VENTANA_RETIRO_ISSSTE)
	public ModelAndView mostrarVentana(Model model,
			HttpServletRequest request) {
		logger.info("entro a ventana general Pdf retiro por desemepleo");
		DatosDocumentoPdf datosPdf = (DatosDocumentoPdf) request.getSession().getAttribute(ParametrosConstants.DATOS_PDF);
		guardarSesionDatosPdf(datosPdf, request);
		request.getSession().removeAttribute(ParametrosConstants.DATOS_PDF);
		request.getSession().setAttribute(ATRIBUTO_URL_PDF, URL_PDF_SOLICITUD_RETIRO_DESEMPLEO_ISSSTE);
		request.getSession().setAttribute(ATRIBUTO_CONTIENE_FIRMA_EMPLEADO, Boolean.TRUE);
		request.getSession().setAttribute(ATRIBUTO_CONTIENE_FIRMA_AGENTE, Boolean.TRUE);
		request.getSession().setAttribute(ATRIBUTO_SOLICITA_FIRMAS, Boolean.TRUE);
		request.getSession().setAttribute(ParametrosConstants.ORIGEN, "desempleo_issste");
		return new ModelAndView(NavegacionEnum.FORWARD_UPLD_DOCTOS_GENERICO.getNavegacion());
	}
	
	/**
	 * 
	 * envia el PDF para la solicitud de retiro de desempleo del ISSSTE
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud
	 * @param response
	 * @throws IOException
	 * @
	 */
	@GetMapping(value = URL_PDF_SOLICITUD_RETIRO_DESEMPLEO_ISSSTE)
	public void generarSolicitudRetiroParcialDesempleoIssste(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("entro obtener retiro desemepleo issste - get");
		request.getSession().removeAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_ISSSTE);
		request.getSession().removeAttribute(ParametrosConstants.NOMBRES_ARCHIVOS);
		procesarSolicitudRetiroParcialDesempleoIssste(null, null, request, response);
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
	@PostMapping(value = URL_PDF_SOLICITUD_RETIRO_DESEMPLEO_ISSSTE)
	public void generarSolicitudRetiroParcialDesempleoIssste(@RequestParam String firmaEmpleado,
			@RequestParam String firmaAgente, HttpServletRequest request, HttpServletResponse response) {
		logger.info("entro obtener retiro desemepleo issste - post");
		procesarSolicitudRetiroParcialDesempleoIssste(firmaEmpleado, firmaAgente, request, response);
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
	private void procesarSolicitudRetiroParcialDesempleoIssste(String firmaTrabajador, String firmaAgente,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession sesion = request.getSession();
		DatosSolicitudRetiroParcialDesempleoIssste solicitud = (DatosSolicitudRetiroParcialDesempleoIssste) sesion
				.getAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_ISSSTE);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);
		if (solicitud == null) {
			solicitud = (DatosSolicitudRetiroParcialDesempleoIssste) request.getSession().getAttribute(ParametrosConstants.DATOS_ESPECIFICOS_PDF);
			logger.info("datos del documento pdf: {}", solicitud);			
			String nombreArchivo = obtenerNombreArchivo(request, CLAVE_TIPO_ARCHIVO_SOLICITUD_TRABAJADOR);
			solicitud.setNombreArchivo(nombreArchivo);
			guardarNombresArchivosSesion(request, CLAVE_TIPO_ARCHIVO_SOLICITUD_TRABAJADOR, nombreArchivo);
			sesion.setAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_ISSSTE, solicitud);
		}

		solicitud.setFirmaTrabajador(firmaTrabajador);
		solicitud.setFirmaAgente(firmaAgente);
		sesion.setAttribute(ATRIBUTO_DATOS_SOLICITUD_DESEMPLEO_ISSSTE, solicitud);
		logger.info("datos de la solicitud: {}", solicitud);

		byte[] pdf = generadorPdfsService.generarSolicitudRetiroParcialDesempleoIssste(solicitud, trabajador.getClaveAfore());
		if(StringUtils.isNotEmpty(firmaTrabajador) && StringUtils.isNotEmpty(firmaAgente)) {
			pdfUtils.generarPdfLocal(request, pdf, trabajador.getClaveAfore(), solicitud.getNumeroFolio(), "4062");
		}
		enviarPdf(pdf, response);
		
		
	}

	/**
	 * 
	 *  se guarda en sesion el contenido del pdf
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param pdfId
	 *  @param datosPdf
	 *  @param request
	 */
	private void guardarSesionDatosPdf(DatosDocumentoPdf datosPdf, HttpServletRequest request) {
		DatosSolicitudRetiroParcialDesempleoIssste datoPdfSolitudIssste = (DatosSolicitudRetiroParcialDesempleoIssste) datosPdf.getDatos();
		request.getSession().setAttribute(ParametrosConstants.DATOS_ESPECIFICOS_PDF, datoPdfSolitudIssste);
		logger.info("datos del pdf: {}", datoPdfSolitudIssste);		
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
	@PostMapping(value=URL_PDF_ADJUNTAR_ARCHIVO_ISSSTE)
	public String adjuntarPdf(@RequestParam MultipartFile archivo, ModelMap modelo, HttpServletRequest request) {
		logger.info("entro en adjuntarPdf issste");
		int respuesta = 0;
		String mensaje = null;
		String nombreArchivo = obtenerNombreArchivo(request, CLAVE_TIPO_ARCHIVO_IDENTIFICACION_OFICIAL_SERVICIO);
		
		if(!archivo.isEmpty()) {
			logger.info("tamano archivo: {}", archivo.getSize());
			if(archivo.getSize()>UN_MEGABYTE) {
				mensaje = ERROR_ARCHIVO_MAYOR_UN_MEGA;
			}else {
				try {
					File archivoGenerado = generadorPdfsService.guardarArchivoServidor(archivo.getBytes(), nombreArchivo);
					request.getSession().setAttribute(ATRIBUTO_ARCHIVO_GENERADO_ISSSTE, archivoGenerado);
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
	 *  obtiene el nombre del archivo pdf de la solicitud de retiro parcial
	 *  por desempleo del IMSS
	 *  @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 *  @param request
	 *  @return
	 */
	protected String obtenerNombreArchivo(HttpServletRequest request, String claveTipoArchivo) {
		DatosNombreArchivoPdf datosNombre = new DatosNombreArchivoPdf();
		DatosTrabajador datosTrabajador = (DatosTrabajador) request.getSession().getAttribute(ParametrosConstants.REQUEST_DATOS);
		
		if(datosTrabajador!=null) {
			datosNombre.setClaveAfore(datosTrabajador.getClaveAfore());
			
			if(datosTrabajador.getDatosCertificables()!=null) {
				datosNombre.setCurp(datosTrabajador.getDatosCertificables().getCurp());	
			}
			
			String afiliacion = obtenerTipoAfiliacion(datosTrabajador.getTipoAfiliacion());            
            datosNombre.setTipoTrabajador(afiliacion);

			
			if(datosTrabajador.getFolio()!=null) {
				datosNombre.setFolioArchivo(datosTrabajador.getFolio().getFolioHijo());	
			}
			
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
	@PostMapping(value=URL_VISTA_PREVIA_PDF_ADJUNTADO_ISSSTE)
	public void generarVistaPreviaArchivoAdjuntado(HttpServletRequest request, HttpServletResponse response) {
		File archivo = (File) request.getSession().getAttribute(ATRIBUTO_ARCHIVO_GENERADO_ISSSTE);
		
		if(archivo!=null) {
			response.setContentType(PDF_CONTENT_TYPE);
			try (FileInputStream entrada = new FileInputStream(archivo)){
				ServletOutputStream salida = response.getOutputStream();
				
				byte[] buffer = new byte[UN_KILOBYTE];
				while(entrada.read(buffer)!=-1) {
					salida.write(buffer);
				}
				
				salida.flush();
				request.getSession().removeAttribute(ATRIBUTO_ARCHIVO_GENERADO_ISSSTE);
			} catch (IOException e) {
				logger.error("error al generar la vista previa del archivo adjuntado", e);
			}
			
			
		}else {
			logger.error("No se encontro archivo adjuntado");
		}
	}	
	
}
