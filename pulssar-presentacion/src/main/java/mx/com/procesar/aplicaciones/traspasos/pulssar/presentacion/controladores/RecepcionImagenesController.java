/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionImagenesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaRecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenDocumento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenWrapper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Controlador Recepcion de Imagenes
 * @author lvgonzal
 *
 */
@Controller
@RequestMapping(value = {"/private"})
public class RecepcionImagenesController extends BaseController{
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RecepcionImagenesController.class);
	
	/**
	 * dependencia utilidad validador
	 */
	@Autowired 
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de expediente
	 */
	@Autowired
	private RecepcionImagenesService recepcionImagenesService;
	
	/**
	 * Controlador que recupera loa archivos recibidos para el visualizador
	 * @param request
	 * @param folio
	 * @param proceso
	 * @param estatus
	 * @param urlsiguiente
	 * @return
	 */
	@RequestMapping(value="/recepcionImagenes.do", method = RequestMethod.GET)
	public ModelAndView recuperarImagenes(HttpServletRequest request, ModelMap map, @ModelAttribute("entradaRecepcionImagenes")  EntradaRecepcionImagenes entradaRecepcionImagenes ){
		logger.info("Incia Recepcion Imagenes para Visualizador: folio = {} proceso = {} estatus = {}", entradaRecepcionImagenes.getFolioPadre(), entradaRecepcionImagenes.getTipoProceso(), entradaRecepcionImagenes.getEstatusRecepcion());
		
		UsuarioLogin usuario = new UsuarioLogin();
		usuario = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		ModelAndView model = new ModelAndView(NavegacionEnum.VISOR_IMAGENES.getNavegacion());
		ImagenWrapper wrapper = new ImagenWrapper();
		String radioTipoTrabajador = request.getParameter("tipo");
		request.getSession().removeAttribute(ParametrosConstants.SESSION_TIPO_TRABAJADOR_RADIO);
		
		List<ImagenDocumento> documentos = new ArrayList<>();
		
		RecepcionImagenes imagenes = recepcionImagenesService.consultarRecepcionImagenes(entradaRecepcionImagenes.getFolioPadre(), entradaRecepcionImagenes.getTipoProceso(), entradaRecepcionImagenes.getEstatusRecepcion());
		if(!utileriaValidador.validarListaVacia(imagenes.getDetalleRecepcionImagen())) {
			documentos = recepcionImagenesService.obtenerDocumentos(imagenes, usuario.getAforeUsuario());
			
			wrapper.setImagenes(documentos);
		}
		
		request.getSession().setAttribute(ParametrosConstants.SESSION_ENTRADA_IMAGENES, entradaRecepcionImagenes);
		request.getSession().setAttribute(ParametrosConstants.SESSION_TIPO_TRABAJADOR_RADIO, radioTipoTrabajador);
		model.addObject("destino", entradaRecepcionImagenes.getUrlSiguiente());
		model.addObject("imagenesDoctos", wrapper);
		return model;
		
	}
	
	/**
	 * Metodo que consulta recepcion de imagenes
	 * @param request
	 * @param model
	 * @param folioPadre
	 * @param cvProceso
	 * @param estatus
	 * @return
	 */
	@RequestMapping(value="/consultarRecepcionImagenes.do", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public RecepcionImagenes consultarRecepcionImagenes(HttpServletRequest request,Model model,@RequestParam String folioPadre,@RequestParam String cvProceso,@RequestParam String estatus) {
		logger.info("datos recibidos consultarRecepcionImagenes controlador: {} {} {}",folioPadre,cvProceso,estatus);
		return recepcionImagenesService.consultarRecepcionImagenes(folioPadre, cvProceso, estatus);
	}
	
	/**
	 * @param imgList
	 * @param redAttr
	 * @return
	 */
	@PostMapping(value="/redireccionaimg")
	public String redireccionarVisor( @ModelAttribute("imagenesDoctos") ImagenWrapper imgList, RedirectAttributes redAttr) {
		
		logger.info("datos recibidos : {}",imgList.getImagenes());
		redAttr.addFlashAttribute("wrapper", imgList);
		
		return "redirect:receptorImagen";
	}

}
