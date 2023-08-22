package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CertificadoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Peticion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoPendienteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidarSolicitudCertificacionAforeEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidarSolicitudCertificacionAforeSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@Service
public class CertificadoServiceImpl implements CertificadoService {

	private static final Logger logger = LoggerFactory.getLogger(CertificadoServiceImpl.class);

	/**
	 * servicio
	 */
	@Autowired
	private RestTemplate servicio;

	/**
	 * uriValidarCertificadoRetiro
	 */
	@Value("${validacion.certificado.retiro.imss.uri}")
	private String uriValidarCertificadoRetiro;

	/**
	 * Solicitud de cus
	 */
	@Value("${solicitud.cus.uri}")
	private String uriSolicitudCus;

	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/**
	 * folioService
	 */
	@Autowired
	private FolioService folioService;

	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * CertificadoService#validarCertificado(mx.com.procesar.aplicaciones.
	 * traspasos.pulssar.servicios.modelo.DatosTrabajador,
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * UsuarioLogin,
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * RetiroDesempleoImss, java.lang.String)
	 */
	@Override
	public ValidarSolicitudCertificacionAforeSalida validarCertificado(DatosTrabajador datosTrabajador,
			UsuarioLogin user, RetiroDesempleoImss retiroDesempleoImss, String folio,
			SolicitudDisposicionParcial entradaOp12, EntradaConsulta entradaConsulta) {

		ValidarSolicitudCertificacionAforeEntrada entrada = new ValidarSolicitudCertificacionAforeEntrada();

		entrada.setFolioTramiteProcesar(folio);
		entrada.setNss(datosTrabajador.getNss());
		entrada.setCurp(datosTrabajador.getDatosCertificables().getCurp());
		entrada.setTipoPrestacion(datosTrabajador.getTipoDePrestacion());
		entrada.setOrigen(BigInteger.ZERO);
		entrada.setNombreTrabajador(datosTrabajador.getDatosCertificables().getNombre());
		entrada.setApellidoMaterno(datosTrabajador.getDatosCertificables().getApellidoMaterno());
		entrada.setApellidoPaterno(datosTrabajador.getDatosCertificables().getApellidoPaterno());
		entrada.setTipoPrestacion("06");
		entrada.setClaveAdminActual(user.getAforeUsuario());
		entrada.setIdSolicitante(datosTrabajador.getTipoSolicitante());
		if (datosTrabajador.getTipoSolicitante().equals("01")) {
			entrada.setCurpSolicitante(datosTrabajador.getDatosCertificables().getCurp());
			entrada.setSelloTrabajador(Long.valueOf(retiroDesempleoImss.getSelloTrabajador()));
		} else {
			entrada.setCurpSolicitante(entradaConsulta.getCurpSolicitante());
		}
		entrada.setCurpAgenteServicio(user.getCurpAgente());
		entrada.setIndicadorOrigenTramite("01");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("idServicio", "759");
		headers.set("idCliente", "35");
		headers.set("idEbusiness", "12");
		HttpEntity<ValidarSolicitudCertificacionAforeEntrada> entity = new HttpEntity<>(entrada, headers);

		logger.info("Entrada solicitarCertificado: {}", entity);

		ResponseEntity<ValidarSolicitudCertificacionAforeSalida> respuesta = servicio.exchange(
				uriValidarCertificadoRetiro, HttpMethod.POST, entity, ValidarSolicitudCertificacionAforeSalida.class);

		ValidarSolicitudCertificacionAforeSalida salidacertificacion = respuesta.getBody();
		logger.error("salida certificarRetiroImss: {}", salidacertificacion);
//		salidacertificacion.setResultadoOperacion("01");
//		salidacertificacion.setDiagnosticoProcesar("106");
//		salidacertificacion.setNumeroResolucion("123456");
//		salidacertificacion.setSbcTipoA("1");
//		salidacertificacion.setSbcTipoB("2");
//		 salidacertificacion.setDiagnosticoProcesar(ServiciosConstants.RESPUESTA_532);
		if (utileriaValidador.validarObjetoNulo(salidacertificacion)) {
			logger.error("salida certificarRetiroImss error, no se pudo generar la certificacion");
		}
		if ("02".equals(salidacertificacion.getResultadoOperacion())
				&& !ServiciosConstants.RESPUESTA_532.equals(salidacertificacion.getDiagnosticoProcesar())) {
			folioService.cerrarFolio(retiroDesempleoImss.getIdFolio(), 2, salidacertificacion.getDiagnosticoProcesar());
		} else {
			folioService.cerrarFolio(retiroDesempleoImss.getIdFolio(), null);
			FolioEntrada folioOp12 = new FolioEntrada();
			folioOp12.setIdUsuario(user.getDatoUsuario());
			folioOp12.setOperacion("S");
			folioOp12.setServicio("S1");
			folioOp12.setProceso("S1P5");
			folioOp12.setSucursal("SUC1");
			folioOp12.setNss(datosTrabajador.getNss());
			folioOp12.setCurp(datosTrabajador.getDatosCertificables().getCurp());
			folioOp12.setTiempoLlegada(ServiciosConstants.TIEMPO_LLEGADA);
			folioOp12.setOrigen("O");
			folioOp12.setEstatus(0L);
			retiroDesempleoImss.setFolio12(folioService.generarNuevoFolio(folioOp12));
			String numeroResolucion = null;
			String flujo = "1";
			if (ServiciosConstants.RESPUESTA_532.equals(salidacertificacion.getDiagnosticoProcesar())) {

				ProcesoPendienteEntrada<Peticion> procesoPendienteOp07 = new ProcesoPendienteEntrada<>();
				Peticion peticion07 = new Peticion();
				// Proceso pendiente para Op07
				procesoPendienteOp07.setAfore(user.getAforeUsuario());
				procesoPendienteOp07.setCurp(datosTrabajador.getDatosCertificables().getCurp());
				procesoPendienteOp07.setCurpEmpleado(user.getCurpAgente());
				procesoPendienteOp07.setCurpNueva(null);
				procesoPendienteOp07.setFlujo(null);
				procesoPendienteOp07.setIdFolioPulssar(retiroDesempleoImss.getIdFolio());
				procesoPendienteOp07.setProceso("03");
				procesoPendienteOp07.setSolicitante(datosTrabajador.getTipoSolicitante());
				peticion07.setFoliohijo(retiroDesempleoImss.getFolio12().getIdFolio());
				peticion07.setPeticion(entrada);
				procesoPendienteOp07.setPeticion(peticion07);
				procesoPendienteOp07.setIdProcesar(datosTrabajador.getProcesar());
				salidacertificacion.setResultadoOperacion("01");
				retiroDesempleoImss.setDiagnostico(salidacertificacion.getDiagnosticoProcesar());
//				datosTrabajador.getSalariosIcefas().setSalario("123");
				retiroDesempleoImss.setSbcTipoA(datosTrabajador.getSalariosIcefas().getSalario());
				retiroDesempleoImss.setSbcTipoB(datosTrabajador.getSalariosIcefas().getSalario());
				retiroDesempleoImss.setPeticion07(procesoPendienteOp07);
				flujo = "0";
			} else {
//				retiroDesempleoImss.setPeticion07(false);
				retiroDesempleoImss.setNumeroResolucion(salidacertificacion.getNumeroResolucion());
				retiroDesempleoImss.setSbcTipoA(salidacertificacion.getSbcTipoA());
				retiroDesempleoImss.setSbcTipoB(salidacertificacion.getSbcTipoB());
				numeroResolucion = salidacertificacion.getNumeroResolucion();

			}
			// Datos de la Op 12
			entradaOp12.setFolioTramiteProcesar(folio);
			entradaOp12.setFolioCliente(folio);
			entradaOp12.setNss(datosTrabajador.getNss());
			entradaOp12.setNombreTrabajador(datosTrabajador.getDatosCertificables().getNombre());
			entradaOp12.setApellidoPaterno(datosTrabajador.getDatosCertificables().getApellidoPaterno());
			entradaOp12.setApellidoMaterno(datosTrabajador.getDatosCertificables().getApellidoMaterno());
			entradaOp12.setTipoRetiro("I");
			entradaOp12.setTipoPrestacion("06");
			entradaOp12.setNumeroResolucion("");
			entradaOp12.setClaveAdminActual(datosTrabajador.getClaveAfore());
			entradaOp12.setCurpTrabajador(datosTrabajador.getDatosCertificables().getCurp());
			entradaOp12.setSelloTrabajador(String.valueOf(retiroDesempleoImss.getSelloTrabajador()));
			entradaOp12.setCurpAgenteServicio(user.getCurpAgente());
			entradaOp12.setIdSolicitante(datosTrabajador.getTipoSolicitante());
			if (datosTrabajador.getTipoSolicitante().equals("01")) {
				entradaOp12.setCurpSolicitante(datosTrabajador.getDatosCertificables().getCurp());
			} else {
				entradaOp12.setCurpSolicitante(entradaConsulta.getCurpSolicitante());
			}
			entradaOp12.setIndicadorOrigenTramite("01");
			entradaOp12.setCurpFuncionarioAutorizado(user.getCurpAgente());
			entradaOp12.setNumeroResolucion(numeroResolucion);

			// Proceso pendiente para Op12
			ProcesoPendienteEntrada<SolicitudDisposicionParcial> procesoPendienteOp12 = new ProcesoPendienteEntrada<>();
			procesoPendienteOp12.setAfore(user.getAforeUsuario());
			procesoPendienteOp12.setCurp(datosTrabajador.getDatosCertificables().getCurp());
			procesoPendienteOp12.setCurpEmpleado(user.getCurpAgente());
			procesoPendienteOp12.setCurpNueva(null);
			procesoPendienteOp12.setFlujo(flujo);
			procesoPendienteOp12.setIdFolioPulssar(retiroDesempleoImss.getFolio12().getIdFolio());
			procesoPendienteOp12.setProceso("04");
			procesoPendienteOp12.setSolicitante(datosTrabajador.getTipoSolicitante());
			procesoPendienteOp12.setPeticion(entradaOp12);
			procesoPendienteOp12.setIdProcesar(datosTrabajador.getProcesar());
			retiroDesempleoImss.setPeticion12(procesoPendienteOp12);

		}
		return salidacertificacion;
	}
}
