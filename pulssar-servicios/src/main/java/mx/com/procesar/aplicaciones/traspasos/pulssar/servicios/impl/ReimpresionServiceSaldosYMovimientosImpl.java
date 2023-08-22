package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionServiceSaldosYMovimientos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CorreoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaReimpresion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.arquitecturasw.datatypes.tiposcomunesprocesar.IDSSNS;
import mx.com.procesar.serviciosinternos.saldosmovimientos.reimpresiondocumento.ReimpresionDocumento;
import mx.com.procesar.serviciosinternos.saldosmovimientos.reimpresiondocumento.ReimpresionDocumentoPort;
import mx.com.procesar.serviciosinternos.saldosmovimientos.reimpresiondocumento.solicitarreimpresion.SolicitarReimpresionContrato;
import mx.com.procesar.serviciosinternos.saldosmovimientos.reimpresiondocumento.solicitarreimpresion.SolicitarReimpresionEntrada;
import mx.com.procesar.serviciosinternos.saldosmovimientos.reimpresiondocumento.solicitarreimpresion.SolicitarReimpresionRespuesta;

/**
 * ReimpresionServiceImpl
 * @author jmordone
 *
 */
@Service
public class ReimpresionServiceSaldosYMovimientosImpl implements ReimpresionServiceSaldosYMovimientos{
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ReimpresionServiceSaldosYMovimientosImpl.class);
	
	/**
	 * endPointReimpresion
	 */
	@Value("${url.soap.endpoint.reimpresion.documentos}")
	private String endPointReimpresion;
	
	/**
	 * idClienteReimpresion
	 */
	@Value("${url.soap.idssn.reimpresion.idcliente}")
	private Integer idClienteReimpresion;
	
	/**
	 * idServicioReimpresion
	 */
	@Value("${url.soap.idssn.reimpresion.idservicio}")
	private Integer idServicioReimpresion;
	
	/**
	 * idServicioReimpresion
	 */
	@Value("${url.soap.idssn.reimpresion.idbuisness}")
	private Integer idBuisnessReimpresion;
	
	/**
	 * reimpresionTramitesService
	 */
	@Autowired
	private ReimpresionTramitesService reimpresionTramitesService;
	
	/**
	 * Obtiene archivo reimpresion saldos y movimientos
	 */
	@Override
	public DatosArchivos obtenerArchivosReimpresion(DatosTrabajador trabajador,String tipoDoumento,UsuarioLogin user)  {
		DatosArchivos datosArchivos = new DatosArchivos();
		RespuestaReimpresion respuesta=null;
		SolicitarReimpresionRespuesta solicitarReimpresionRespuesta =obtenerRespuesta(trabajador.getDatosCertificables().getCurp(),trabajador.getClaveAfore(),tipoDoumento,user.getUsuario());	
		if(solicitarReimpresionRespuesta.getObjetoRespuesta().getResultadoOperacionAfore().equals(FormatoConstants.RECHAZO_REIMPRESION_SERVICIO)) {
			datosArchivos.setErrorArchivo(Boolean.TRUE);
			datosArchivos.setMensajeError(FormatoConstants.ERROR_SIN_INFO);
			datosArchivos.setClaveError(FormatoConstants.ERROR_CLAVE_SIN_INFO);
			return datosArchivos;
		}
		if(solicitarReimpresionRespuesta.getObjetoRespuesta().getImagen()==null
				|| solicitarReimpresionRespuesta.getObjetoRespuesta().getImagen().isEmpty()) {
			return reimpresionTramitesService.obtenerMensajeSinDatos();
		}
		datosArchivos=llenarDatosArchivo(solicitarReimpresionRespuesta);
		respuesta=reimpresionTramitesService.registraProcesoConcluidoReinpresion(reimpresionTramitesService.llenarTramitesConcluidos(trabajador.getDatosCertificables().getCurp(),
				trabajador.getFolio().getFolio(), trabajador.getClaveAfore(), FormatoConstants.SOLICITANTE_TITULAR));
		if(respuesta!=null && respuesta.getResultadoOperacion().equals(FormatoConstants.RESULTADO_OPERACION_ACEPTADO)) {
			datosArchivos.setIdSegTramite(respuesta.getResultado());
		}
		return datosArchivos;
	}
	
	/**
	 * llenarDatosArchivo
	 * @param solicitarReimpresionRespuesta
	 * @return
	 */
	private DatosArchivos llenarDatosArchivo(SolicitarReimpresionRespuesta solicitarReimpresionRespuesta) {
		DatosArchivos datosArchivo = new DatosArchivos();
		datosArchivo.setByteArchivo(solicitarReimpresionRespuesta.getObjetoRespuesta().getImagen());
		datosArchivo.setNombreArchivo(solicitarReimpresionRespuesta.getObjetoRespuesta().getNombreImagen());
		return datosArchivo;
		
	}
	
	/**
	 * Entrada servicio reimpresion
	 * @param curp
	 * @param afore
	 * @param tipoDoumento
	 * @return
	 */
	private SolicitarReimpresionEntrada entrada(String curp,String afore,String tipoDoumento,String user) {
		SolicitarReimpresionEntrada solicitarReimpresionEntrada = new SolicitarReimpresionEntrada();
		solicitarReimpresionEntrada.setAfore(afore);
		solicitarReimpresionEntrada.setClaveServicio(FormatoConstants.SOLICITUD_REIMPRESION);
		solicitarReimpresionEntrada.setTipoDocto(tipoDoumento);
		solicitarReimpresionEntrada.setCurp(curp);
		//solicitarReimpresionEntrada.setUsuario(user);
		logger.error("Peticion servicio soap reimpresion saldos y movimientos:{}",reimpresionTramitesService.convertirObjetoToJson(solicitarReimpresionEntrada));
		return solicitarReimpresionEntrada;
	}

	/**
	 * Idssn de la reimpresion
	 * @return
	 */
	private IDSSNS idssn() {
		IDSSNS idssn = new IDSSNS();
		idssn.setIdCliente(idClienteReimpresion);
		idssn.setIdEbusiness(idBuisnessReimpresion);
		idssn.setIdServicio(idServicioReimpresion);
		return idssn;
		
	}
	
	/**
	 * Obtiene respuesta reimpresion
	 * @param curp
	 * @param afore
	 * @param tipoDoumento
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private SolicitarReimpresionRespuesta obtenerRespuesta(String curp,String afore,String tipoDoumento,String user) {
		ReimpresionDocumentoPort puerto= null;
		ReimpresionDocumento reimpresionDocumento;
		SolicitarReimpresionContrato solicitarReimpresionContrato= new SolicitarReimpresionContrato();
		SolicitarReimpresionRespuesta solicitarReimpresionRespuesta = null;
		Long inicio=0L;
		long diferecia=0L;
		try {
			reimpresionDocumento = new ReimpresionDocumento(new URL(endPointReimpresion), new QName(FormatoConstants.QNAME_REIMPRESION,FormatoConstants.QNAME_REIMPRESION_RE));
			puerto= reimpresionDocumento.getReimpresionDocumentoPort();
//			((BindingProvider)puerto).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endPointReimpresion);
//			((BindingProvider)puerto).getRequestContext().put("com.sun.xml.ws.connect.timeout", 10000);
//			((BindingProvider)puerto).getRequestContext().put("com.sun.xml.ws.request.timeout", 10000);
			Map requestContext = ((BindingProvider) puerto).getRequestContext();
			requestContext.put("com.sun.xml.ws.connect.timeout", 10000);
			requestContext.put("com.sun.xml.ws.connect.timeout", 10000);
			requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endPointReimpresion);
			solicitarReimpresionContrato.setIdssn(idssn());
			solicitarReimpresionContrato.setCuerpo(entrada(curp,afore,tipoDoumento,user));
			inicio = System.currentTimeMillis();
			logger.error("****Inicia conteo segundos*******:{}",inicio);
			solicitarReimpresionRespuesta=puerto.solicitarReimpresion(solicitarReimpresionContrato);
			if(solicitarReimpresionRespuesta==null) {
				logger.error("****Respuesta resultado operacion documento nulo*******");
				throw new BusinessException("Existe un problema con el servicio, intenta más tarde.");
			}
			logger.error("****Respuesta resultado operacion reimpresion documento*******:{}",solicitarReimpresionRespuesta.getObjetoRespuesta().getResultadoOperacionAfore());
			logger.error("****Respuesta diagnostico operacion reimpresion documento*******:{}",solicitarReimpresionRespuesta.getObjetoRespuesta().getDiagnosticoAfore());
		} catch (Exception e) {
			throw new BusinessException("Existe un problema con el servicio, intenta más tarde.",e);
		}finally {
			Long fin = System.currentTimeMillis();
			diferecia=(fin - inicio) /1000;
			logger.error("****Difrencia conteo segundos*******:{}",diferecia);	
		}
		if(diferecia>10) {
			logger.error("****Se a superado el tiempo del servicio*******:{}",diferecia);	
			throw new BusinessException("Supera tiempo del servicio.");
		}
		return solicitarReimpresionRespuesta;
		
	}
	/** 
	 * Verificar la interface o clase que lo define
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionServiceSaldosYMovimientos#enviarCorreoReimpresion(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador, java.lang.String, java.lang.Integer)
	 */
	@Override
	public RespuestaServicio enviarCorreoReimpresion(DatosArchivos datos,DatosTrabajador trabajador, String folioProcesar,Integer modulo,String claveAgente) {
		RespuestaServicio respuesta = new RespuestaServicio();
		if(datos!=null && !datos.getByteArchivo().isEmpty()) {
			respuesta = reimpresionTramitesService.enviarCorreoReimpresion(datos, trabajador, folioProcesar, MenuReimpresionEnum.SALDOS_MOVIMIENTOS.getClaveDocumento(),CorreoEnum.ARCHIVO_REIMPRESION_SALDOS_MOVIMIENTOS,claveAgente);
		}
		return respuesta;
	}

	/**
	 * obtieneExistenciaCorreoElectronico
	 * @param trabajador
	 * @return
	 */
	@Override
	public RespuestaServicio obtenerExistenciaCorreoElectronico(DatosTrabajador trabajador) {	
		return reimpresionTramitesService.obtenerExistenciaCorreoElectronico(trabajador);	
	}
	
	/**
	 * guardarBitacoraImpresion
	 */
	@Override
	public void guardarBitacoraImpresion(DatosArchivos datos,Integer modulo,String claveAgente) {
		reimpresionTramitesService.guardarBitacoraImpresionEnvio(FormatoConstants.INDICATIVO_IMPRESION, 
				MenuReimpresionEnum.SALDOS_MOVIMIENTOS.getClaveDocumento(),datos.getIdSegTramite(),claveAgente);
	}
   
}
