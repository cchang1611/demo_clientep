package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.OperativoProcesarConstants.URI_ROL_AUTENTICADO_OPERATIVO_PROCESAR;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaPlataformaServiciosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExcelPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteConsultaPlataforma;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaFoliosConsultaOperativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * Consulta plataforma servicios
 * @author RARREOLA
 *
 */
@Controller
@RequestMapping(value = URI_ROL_AUTENTICADO_OPERATIVO_PROCESAR)
public class ConsultaPlataformaServiciosController {
	
	/**
	 * Logger;
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultaPlataformaServiciosController.class);
	
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ConversionUtils utileriaConversion;
	
	/**
	 * ConsultaPlataformaServiciosService
	 */
	@Autowired
	private ConsultaPlataformaServiciosService consultaPlataformaServiciosService;
	
	/**
	 * Vista captura plataforma servicios
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = "/capturaPlataformaServicios.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mostrarCapturaPlataformaServicios(@RequestParam(value = "servicio") String servicio, @RequestParam(value = "dato", required = false) String dato, HttpServletRequest request) {
		logger.info("Inicio consulta trabajador");
		ModelAndView model = new ModelAndView(NavegacionEnum.CONSULTA_PLATAFORMA_SERVICIOS.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_PLATAFORMA_SERVICIOS, new EntradaPlataformaServicios());
		RespuestaServicio respuesta = new RespuestaServicio();
		List<Combo> lAfores = null;
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String claveServicio = servicio;
		try {
			lAfores = utileriaConversion.obtenerComboOrganizacion(servicioCatalogo.obtenerOrganizaciones(), Arrays.asList(ActivacionConstants.CLAVE_PROCESAR));
			lAfores = consultaPlataformaServiciosService.removerAforeSici(lAfores);
			model = utileriaConversion.agregarComboAModel(model, ActivacionConstants.COMBO_AFORES, lAfores, null);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.VALIDAR_FILTROS_PLATAFORMA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_UNO, null);
			model.addObject(ActivacionConstants.RESPUESTA, respuesta);
			model.addObject(ActivacionConstants.CLAVE_SERVICIO, claveServicio);
			if(dato != null) {
				model.addObject(ActivacionConstants.EXTRA_CLAVE_SERVICIO, dato);
				request.getSession().setAttribute(ActivacionConstants.EXTRA_CLAVE_SERVICIO, dato);
			}
			request.getSession().setAttribute(ActivacionConstants.CLAVE_SERVICIO, claveServicio);
		} catch (BusinessException be) {
			logger.error("consultaTrabajador: Se presento un problema al mostrar los campos de consulta el trabajador", be);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a la consulta", e);
		}
		
		return model;
	}
	
	
	/**
	 * Vista datos plataforma servicios
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mostrarDatosPlataformaServicios.do", method = {RequestMethod.POST})
	public ModelAndView mostrarDatosPlataformaServicios(HttpServletRequest request, HttpServletResponse response, @ModelAttribute EntradaPlataformaServicios consulta) {
		logger.info("Inicio validacion de consulta Trabajador");
		ModelAndView model = new ModelAndView(NavegacionEnum.RESPUESTA_PLATAFORMA_SERVICIOS.getNavegacion(), ParametrosConstants.FORMULARIO_CONSULTA_PLATAFORMA_SERVICIOS, new EntradaPlataformaServicios());
		RespuestaServicio respuesta = new RespuestaServicio();
		
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		String claveServicio = (String) request.getSession().getAttribute(ActivacionConstants.CLAVE_SERVICIO);
		String datoServicio = (String) request.getSession().getAttribute(ActivacionConstants.EXTRA_CLAVE_SERVICIO);
		
		try {
			List<SalidaFoliosConsultaOperativa> resultados = consultaPlataformaServiciosService.foliosConsultaOperativa(consulta, claveServicio, datoServicio);
			List<DatosExcelPlataformaServicios> listas = consultaPlataformaServiciosService.seteoInformacion(resultados);
			model = model.addObject(ActivacionConstants.LISTA_CONSULTA, listas);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.EXCEL_PLATAFORMA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_UNO, null);
			model = model.addObject(ActivacionConstants.RESPUESTA, respuesta);
			request.getSession().setAttribute(ActivacionConstants.LISTA_EXCEL, listas);
			model.addObject(ActivacionConstants.CLAVE_SERVICIO, claveServicio);
			if(datoServicio != null) {
				model.addObject(ActivacionConstants.EXTRA_CLAVE_SERVICIO, datoServicio);
			}
		} catch (BusinessException be) {
			logger.error("BusinessException: Se presento un problema en la consulta delos datos de la plataforma servicios {}", be.getCodigo(), be);
		} catch(Exception e) {
			logger.error("ExcepcionSe presento un problema al mostrar los datos de la plataforma servicios", e);
		}
		
		return model;
	}
	
	
	
	/**
	 * Exporta reporte seguimiento registro a excel 
	 * @param request
	 * @param resp
	 * @throws IOException
	 */
	
	@RequestMapping(value = "/exportarExcelPlataformaServicios.do",method = {RequestMethod.GET,RequestMethod.POST})
	public void exportarExcelPlataformaServicios(HttpServletRequest request, HttpServletResponse resp, HttpServletResponse response) throws IOException{
		logger.error("exportarExcelPlataformaServicios");
		try {
			String nombreExcel = (String) request.getSession().getAttribute(ActivacionConstants.NOMBRE_EXCEL_SESSION);
			List<DatosExcelPlataformaServicios> listasResultados  = (List<DatosExcelPlataformaServicios>) request.getSession().getAttribute("listasExcel");
			ReporteConsultaPlataforma objeto = new ReporteConsultaPlataforma();
			InputStream inputStream =request.getSession().getServletContext().getResourceAsStream("webResources/jasper/reporteConsultaPlataforma/reporteConsultaPlataforma.jrxml");
			Map<String,Object>parametros =  new HashMap<>();
			objeto.setListasResultados(listasResultados);
			JsonUtilsImpl<ReporteConsultaPlataforma> json = new JsonUtilsImpl<>();
			String jsonDatos= json.parseObjectToJson(objeto);
			JasperPrint jasperPrint = consultaPlataformaServiciosService.generarReporteStream(jsonDatos.getBytes(StandardCharsets.UTF_8),parametros,inputStream);
			byte[] bytes = consultaPlataformaServiciosService.exportarAExcel(jasperPrint,new ByteArrayOutputStream());
			response.setContentType(ActivacionConstants.APPLICATION_XLSX);
			response.setContentLength(bytes.length);
			response.setHeader(ActivacionConstants.CONTENT_DISPOSITION, ActivacionConstants.ATTACHMENT+nombreExcel);
			ServletOutputStream servletOutputStream = response.getOutputStream();
			servletOutputStream.write(bytes, 0, bytes.length);
			servletOutputStream.flush();
			servletOutputStream.close();
			
		}catch (BusinessException be) {
			logger.error("BusinessException: Se presento un problema al generar el excel de la plataforma servicios {}", be.getCodigo(), be);
		}catch(Exception e) {
			logger.error("ExcepcionSe presento un problema  al generar el excel de la plataforma servicios", e);
		}
		logger.info("Termina generacion de reporte plataforma servicios");
	}
	
	/**
	 * Generar el nombre del excel
	 * @author rarreola
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/generarNombreExcel.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio generarNombreExcel(HttpServletRequest request) {
		logger.info("Generar el nombre del excel");
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario(ActivacionConstants.CLAVE_PROCESAR);
		try {
			String nombreExcel = consultaPlataformaServiciosService.generarNombreExcel();
			request.getSession().setAttribute(ActivacionConstants.NOMBRE_EXCEL_SESSION, nombreExcel);
			respuesta.setDatos(nombreExcel);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
		} catch (BusinessException be) {
			logger.error("consultaEstatusCeroPapel: Se presento un problema al consultar el estatus de cero papel", be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_SEIS, null);
		} catch (Exception e) {
			logger.error("El servicio presento un problema al momento de acceder a la consulta", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}

}
