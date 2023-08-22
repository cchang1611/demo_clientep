package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants.DDMMYYYY;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.Constants.KKMM;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.enumeradores.NavegacionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;

/**
 * Controlador Genera Cus
 * 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 08/08/2019
 */
@Controller
public class GeneraCusController {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RetiroDesempleoImssController.class);

	/**
	 * Inyeccion dependencia CusService
	 */
	@Autowired
	private CusService cusService;

	/**
	 * Inyeccion dependencia FolioService
	 */
	@Autowired
	private FolioService folioService;

	/**
	 * Utilerias de fechas
	 */
	@Autowired
	private FechaUtils fechaUtils;

	/**
	 * Metodo de pantalla generacion de cus
	 * 
	 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 * @param request
	 * @param map
	 * @return
	 */
	@GetMapping(value = "/private/generaCus.do")
	public ModelAndView generarCus(HttpServletRequest request, ModelMap map, @ModelAttribute("origen") String origen) {
		logger.info("generarCus con origen: {}", origen);
		Calendar hoy = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DDMMYYYY);
		SimpleDateFormat sdfhora = new SimpleDateFormat(KKMM);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);

		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

		FolioEntrada folio = new FolioEntrada();
		folio.setIdUsuario(Long.valueOf(user.getDatoUsuario()));
		folio.setOperacion("S");
		if (AgenteConstants.TIPO_AFILIACION_IMSS.equals(origen)) {
			folio.setServicio("S1");
			folio.setProceso("S1P2");
		} else {
			folio.setServicio("S6");
			folio.setProceso("S6P2");
		}
		folio.setSucursal("SUC1");
		folio.setNss(trabajador.getNss());
		folio.setCurp(trabajador.getDatosCertificables().getCurp());
		folio.setTiempoLlegada("00:00");
		folio.setOrigen("O");

		FolioEntrada folioRespuesta = folioService.generarFolio(folio);
		map.addAttribute("folio", folioRespuesta);
		map.put("trabajador", trabajador);
		map.put("user", user);
		map.put("fechaCita", sdf.format(hoy.getTime()));
		map.put("horarioCita", sdfhora.format(hoy.getTime()));
		map.put("origen", origen);

		return new ModelAndView(NavegacionEnum.GENERAR_CUS.getNavegacion());
	}

	/**
	 * Constroller de generacion de cus
	 * 
	 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 * @param request
	 * @param map
	 * @return
	 */
	@ResponseBody
	@GetMapping(value = "/private/solicitarCus.do", produces = "application/json")
	public Map<String, String> solicitarCus(HttpServletRequest request, @ModelAttribute("origen") String origen,
			@ModelAttribute("folio") String folio, @ModelAttribute("servicio") String servicio) {
		Calendar hoy = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DDMMYYYY);
		SimpleDateFormat sdfhora = new SimpleDateFormat(KKMM);
		DatosTrabajador trabajador = (DatosTrabajador) request.getSession()
				.getAttribute(ParametrosConstants.REQUEST_DATOS);
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

		Date fechaNacimiento = fechaUtils.convertirCadenaAFecha(trabajador.getDatosCertificables().getFechaNacimiento(),
				"dd/MMM/yyyy");
		EntradaCus entrada = new EntradaCus();
		entrada.setServicioGeneraCus(servicio);
		entrada.setCurpTitular(trabajador.getDatosCertificables().getCurp());
		entrada.setNssTitular(trabajador.getNss());
		entrada.setRfcTitular(trabajador.getDatosNoCertificables().getRfc());
		entrada.setNombreTitular(trabajador.getDatosCertificables().getNombre());
		entrada.setApellidoPaternoTitular(trabajador.getDatosCertificables().getApellidoPaterno());
		entrada.setApellidoMaternoTitular(trabajador.getDatosCertificables().getApellidoMaterno());
		entrada.setFechaNacimiento(sdf.format(fechaNacimiento));
		entrada.setNumeroCelularTitular(trabajador.getDatosComplementarios().getTelefonos().getCelular());
		entrada.setCveAfore(user.getAforeUsuario());
		entrada.setNumeroFijoTitular(trabajador.getDatosComplementarios().getTelefonos().getTelefonoFijo());
		entrada.setRegimenPensionTitular("02");
		entrada.setRolCiudadano("01");
		entrada.setCurpAgenteServicio(user.getCurpAgente());
		entrada.setNombreAgenteServicio(user.getSoloNombre());
		entrada.setApellidoPaternoAgenteServicio(user.getApellidoPaterno());
		entrada.setApellidoMaternoAgenteServicio(user.getApellidoMaterno());
		entrada.setNumeroAgenteServicio(user.getUsuario());
		// 01-IMSS, 02-ISSSTE
		if (AgenteConstants.TIPO_AFILIACION_ISSSTE.equals(origen)) {
			entrada.setInstitutoOtorgoDerecho("02");
		} else {
			entrada.setInstitutoOtorgoDerecho("01");
		}
		entrada.setOrigenSolicitud("01");
		entrada.setCveSucursal("SUC1");
		entrada.setFechaCita(sdf.format(hoy.getTime()));
		entrada.setHorarioCita(sdfhora.format(hoy.getTime()));
		if("04".equals(servicio)){
			entrada.setTipoRetiroTotal("04");
		}

		RespuestaGeneraCusSalida salida = cusService.generarCus(entrada);

		HashMap<String, String> json = new HashMap<>();

		if ("01".equals(salida.getResultadoOperacion())) {
			json.put("correcto", "true");
			json.put("descDiagnostico", "CUS generada correctamente");
		} else {
			json.put("correcto", "false");
			json.put("descDiagnostico", "Error ".concat(salida.getDiagnosticoProcesar() + " al generar la CUS"));
		}
		return json;
	}

}
