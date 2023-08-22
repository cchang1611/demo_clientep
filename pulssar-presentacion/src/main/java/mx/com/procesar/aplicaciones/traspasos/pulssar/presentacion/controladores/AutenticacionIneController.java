/**
 * AutenticacionINEController.java
 * Fecha de creación: May 25, 2021 11:16:44 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lowagie.text.Element;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarAutenticacionIneService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenerarPdfTipoEntradaEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CoordenadasPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaAutenticacionIne;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaGenerarPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaHuella;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GenerarPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellaDactilar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ws.NotificarAutenticacionEntrada;

/**
 * Clase AutenticacionINEController
 *
 * @author Williams Alejandro Martínez (walejand)
 * @version 1.0
 */
@Controller
public class AutenticacionIneController {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(AutenticacionIneController.class);

	/**
	 * Atributo generadorPdfsService
	 */
	@Autowired
	private GeneradorPdfsService generadorPdfsService;

	/**
	 * Atributo rutaPdf
	 */
	@Value("${ruta.pdf.autenticacion.ine}")
	private String rutaPdf;

	/**
	 * Atributo rutaGuardarPdfEnvio
	 */
	@Value("${url.ruta.digitaliza}")
	private String rutaGuardarPdfEnvio;

	/**
	 * Inyeccion de expediente servicio
	 */
	@Autowired
	private ExpedienteServicioService expedienteServicio;
	
	/**
	 * Inyeccion validarAutenticacionIneService
	 */
	@Autowired
	private ValidarAutenticacionIneService validarAutenticacionIneService;
	
	/**
	 * Metodo autenticacionIne
	 * 
	 * @param request
	 * @param response
	 * @param consulta
	 * @return
	 * @throws IOException
	 */
	@PostMapping(value = "/private/autenticacionIne.do")
	public ModelAndView autenticacionIne(HttpServletRequest request, EntradaAutenticacionIne consulta)
			throws IOException {
		logger.info(">>> Autenticacion INE Entrada {}", consulta);
		EntradaConsulta consultaPrinc = (EntradaConsulta) request.getSession().getAttribute("consulta");
		ModelAndView model = new ModelAndView(NavegacionEnum.AUTENTICACION_POR_INE_PDF.getNavegacion());
		
		FolioEntrada folio = (FolioEntrada) request.getSession().getAttribute("folio");

		model.addObject(Constants.FOLIO, folio);
		GenerarPdf generarPdf = new GenerarPdf();
		List<EntradaGenerarPdf> entrada = new ArrayList<>();


		logger.info(">>> Se construyen PDF con coordenadas para los atributos {}", consulta);
		StringBuilder nombreBuilder = new StringBuilder();
		nombreBuilder.append(consulta.getNombre()).append(" ").append(consulta.getApellidoPaterno()).append(" ")
				.append(consulta.getApellidoMaterno());

		logger.info("Fecha {}", LocalDate.now());
		EntradaGenerarPdf fecha = new EntradaGenerarPdf();
		fecha.setCoordenadas(new CoordenadasPdf(450F, 625F));
		fecha.setValor(LocalDate.now().toString());
		fecha.setElemento(Element.ALIGN_LEFT);
		entrada.add(fecha);

		logger.info("Folio {}", folio);
		EntradaGenerarPdf foliopdf = new EntradaGenerarPdf();
		foliopdf.setCoordenadas(new CoordenadasPdf(450F, 595F));
		foliopdf.setValor(folio.getFolio());
		foliopdf.setElemento(Element.ALIGN_LEFT);
		entrada.add(foliopdf);

		logger.info("Nombre {}", nombreBuilder);
		EntradaGenerarPdf nombre = new EntradaGenerarPdf();
		nombre.setCoordenadas(new CoordenadasPdf(270F, 427F));
		nombre.setValor(nombreBuilder.toString());
		nombre.setElemento(Element.ALIGN_LEFT);
		entrada.add(nombre);

		logger.info("CURP {}", consulta.getCurp());
		EntradaGenerarPdf curp = new EntradaGenerarPdf();
		curp.setCoordenadas(new CoordenadasPdf(120F, 407F));
		curp.setValor(consulta.getCurp());
		curp.setElemento(Element.ALIGN_LEFT);
		entrada.add(curp);

		logger.info("NombreFirma {}", nombreBuilder);
		EntradaGenerarPdf nombreFirma = new EntradaGenerarPdf();
		nombreFirma.setCoordenadas(new CoordenadasPdf(200F, 112F));
		nombreFirma.setValor(nombreBuilder.toString());
		nombreFirma.setElemento(Element.ALIGN_LEFT);
		entrada.add(nombreFirma);

		generarPdf.setEntrada(entrada);
		generarPdf.setRutaPdf(rutaPdf);

		logger.info("Generar PDF con la plantilla {}", rutaPdf);
		byte[] bytePdf = generadorPdfsService.generarPdf(generarPdf);

		logger.info("Guardar PDF en la ruta {}", rutaGuardarPdfEnvio);
		StringBuilder ruta = new StringBuilder(rutaGuardarPdfEnvio);
		generadorPdfsService.guardarArchivo(bytePdf, ruta.append(folio.getFolio()).append(".pdf").toString());

		logger.info("Obtener parametro de reintetos para consulta de imagenes");
		Parametro parametro = expedienteServicio
				.obtenerValorParametro(ServiciosConstants.PARAMETRO_INTENTOS_CONSULTA_IMAGENES);

		String base64 = Base64Utils.encodeToString(bytePdf);
		model.addObject("pdfPlantilla", base64);
		model.addObject("requestAutenticacionIne", consulta);
		model.addObject("folioClave", folio.getFolio());
		model.addObject("intentos", parametro);
		model.addObject("servicio", "21");
		model.addObject("tipoSolicitante", consultaPrinc.getCvTipoSolicitante());
		return model;
	}

	/**
	 * Metodo autenticacionIneFirmarPdf
	 * 
	 * @param request
	 * @param consulta
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/private/autenticacionIneFirmarPdf.do", method = { RequestMethod.POST })
	public ModelAndView autenticacionIneFirmarPdf(HttpServletRequest request, EntradaAutenticacionIne consulta)
			throws IOException {
		logger.info(">>> Firmar Autenticacion INE Entrada {}", consulta);
		FolioEntrada folio  = (FolioEntrada) request.getSession().getAttribute("folio");
		
		ModelAndView model = new ModelAndView(NavegacionEnum.AUTENTICACION_POR_INE_PDF_FIRMADO.getNavegacion());
		model.addObject(Constants.FOLIO, folio);
		GenerarPdf generarPdf = new GenerarPdf();
		List<EntradaGenerarPdf> entrada = new ArrayList<>();

		logger.info("Firma");
		EntradaGenerarPdf firma = new EntradaGenerarPdf();
		firma.setCoordenadas(new CoordenadasPdf(250F, 120F));
		firma.setValor(consulta.getFirma());
		firma.setElemento(Element.ALIGN_LEFT);
		firma.setGenerarPdfTipoEntrada(GenerarPdfTipoEntradaEnum.IMAGEN);
		firma.setWidth(155F);
		firma.setHeight(50F);
		entrada.add(firma);

		generarPdf.setEntrada(entrada);

		StringBuilder rutaGenerar = new StringBuilder(rutaGuardarPdfEnvio);
		generarPdf.setRutaPdf(rutaGenerar.append(folio.getFolio()).append(".pdf").toString());

		logger.info("Generar PDF con la plantilla {}", generarPdf.getRutaPdf());
		byte[] bytePdf = generadorPdfsService.generarPdf(generarPdf);

		logger.info("Guardar PDF en la ruta {}", rutaGuardarPdfEnvio);
		StringBuilder rutaGuardar = new StringBuilder(rutaGuardarPdfEnvio);
		generadorPdfsService.guardarArchivo(bytePdf,
				rutaGuardar.append(folio.getFolio()).append(".pdf").toString());

		String base64 = Base64Utils.encodeToString(bytePdf);
		model.addObject("pdfPlantilla", base64);
		return model;
	}

	/**
	 * Metodo autenticacionIneValidacionDatos
	 * 
	 * @param request
	 * @param consulta
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/private/autenticacionIneValidacionDatos.do", method = { RequestMethod.POST })
	public ModelAndView autenticacionIneValidacionDatos(HttpServletRequest request, EntradaAutenticacionIne consulta)
			throws IOException {
		logger.info(">>> Validacion de datos Entrada {}", consulta);
		FolioEntrada folio  = (FolioEntrada) request.getSession().getAttribute("folio");
		
		ModelAndView model = new ModelAndView(NavegacionEnum.AUTENTICACION_POR_INE_VALIDACION_DATOS.getNavegacion());
		model.addObject(Constants.FOLIO, folio);

		logger.info("Validar aviso de privacidad {}", consulta.getAvisoPrivacidad());
		if (!consulta.getAvisoPrivacidad()) {
			// Validar aviso de privacidad
			return new ModelAndView("redirect:/private/autenticacionIneFirmarPdf.do");
		}

		return model;
	}
	
	/**
	 * redireccionarBiometrico
	 * @param redAttr
	 * @param entrada
	 * @param request
	 * @return
	 */
	@PostMapping(value="/private/redireccionaIneHuellas")
	public ModelAndView redireccionarBiometrico(RedirectAttributes redAttr, NotificarAutenticacionEntrada entrada, HttpServletRequest request) {
		logger.info(">>> redireccionarVisor {}", entrada);
		request.getSession().setAttribute("ine", entrada);
		request.getSession().setAttribute("notificarAutenticacionEntrada", entrada);
		EntradaConsulta entradaConsulta = (EntradaConsulta) request.getSession().getAttribute("consulta");
		EntradaHuella datosINE = new EntradaHuella();
		datosINE.setCurp("PEMJ900925HSLRDS03");
		datosINE.setCurpEmpleado("BAID880119HDFRBV04");
		datosINE.setUriHuellas("redireccionaIneOK");
		redAttr.addFlashAttribute("datosINE", datosINE);
		redAttr.addFlashAttribute("consulta", entradaConsulta);
		return new ModelAndView("redirect:/private/obtenerHuellasINE.do");
	}
	/**
	 * Metodo redireccionarIneOk
	 * @param redAttr
	 * @param request
	 * @return
	 */
	@PostMapping(value="/private/redireccionaIneOK")
	public ModelAndView redireccionarIneOk(RedirectAttributes redAttr, HttpServletRequest request) {
		NotificarAutenticacionEntrada notificarAutenticacionEntrada = (NotificarAutenticacionEntrada) request.getSession()
				.getAttribute("notificarAutenticacionEntrada");
		HuellaDactilar huellaDactilar = (HuellaDactilar)request.getSession().getAttribute(ParametrosConstants.HUELLA_VERIFICACION_INE);
		logger.info(">>> redireccionaIneOK {}", huellaDactilar);
		String respuesta = validarAutenticacionIneService.validarIne(notificarAutenticacionEntrada, huellaDactilar);
		ModelAndView model;
		if(StringUtils.isBlank(respuesta)){
			EntradaConsulta consulta = (EntradaConsulta)request.getSession().getAttribute("consulta");
			redAttr.addFlashAttribute("consulta", consulta);
			model = new ModelAndView("redirect:/private/consultaPrincipal.do");
		} else {
			FolioEntrada folio  = (FolioEntrada) request.getSession().getAttribute("folio");
			model = new ModelAndView(NavegacionEnum.AUTENTICACION_POR_INE_VALIDACION_DATOS.getNavegacion());
			model.addObject("error", respuesta);
			model.addObject(Constants.FOLIO, folio);
		}
		return model;
	}
}
