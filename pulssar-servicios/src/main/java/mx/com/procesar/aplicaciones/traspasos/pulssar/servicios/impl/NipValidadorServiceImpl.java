/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.NipConsultaBUU;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipBUUService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipValidadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.RechazosGeneracionNipEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MALOPEZT
 * @since 27/01/2022
 * Proceos de validaci�n de datos en solicitud de Generaci�n de NIPs
 * RFC: WB00288
 */
@Service("nipValidadorService")
public class NipValidadorServiceImpl implements NipValidadorService {

	/** Registro Log */
	private static final Logger logger = LoggerFactory.getLogger(NipValidadorServiceImpl.class);
	
	/** Constante num�rica: Define �xito en la generaci�n de NIP */
	private static final Integer CONTANTE_EXITO = 1;
	
	/** Constante num�rica: Describe la existencia de un error en la generaci�n de NIP */
	private static final Integer CONTANTE_ERROR = 2;

	private static final String CONSTANTE_NO_NIP_ACTIVO = "01";

	/** Problema de cominicaci�n con la BUU */
	private static final String PROBLEMA_COMUNICACION_BUU = "0000";
	
	/** Mensaje de error gen�rico */
	private static final String MENSAJE_ERROR_GRAL_COMUNICACION_SERVICIO =
			"No se ha obtenido respuesta del servicio de Validaci�n BUU";

	/** Rechazo, indica que ya existe un nip activo */
	private static final String RECHAZO_102 = "102";
	
	/** Utileria de validacion*/
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/** ? Servicio de Catalogo */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Realiza Validaciones de negocio sobre la informaci�n entrante para la generaci�n de NIP.
	 * @param trabajador
	 * @return RespuestaServicio
	 */
	@Override
	public RespuestaServicio validarInformacion(DatosTrabajador trabajador, NipConsultaBUU consultaBUU) {
		
		logger.info("[validarInformacion] - Inicia validaci�n de soliciutd");
		// TODO: Aplicar procesos de validaci�n
		
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(CONTANTE_EXITO);
		try {
			
			// Validaci�n de duplicidad de Curp
			validarDuplicidadCurp(trabajador);
			validarNipNoActivo(consultaBUU);
			validarInformacionComplementariaDeBUU(consultaBUU);
//			try {
			validarExpedientes(trabajador);
//			}catch (Exception e) {
//				logger.error("[validarInformacion]-Error - Validaci�n expedientes: {}", e);
//			}
			
		} catch (BusinessException be) {
			logger.info("[validarInformacion] Error - Falla validaci�n: {}", be.getMessage());
			respuesta.setFlujo(CONTANTE_ERROR);
			respuesta.setMensaje(be.getMessage());
			respuesta.setTitulo("Validaciones generaci�n de NIP");
		}
//		
//		respuesta.setFlujo(2);
//		respuesta.setMensaje("Prueba Error de Validaci�n");
//		respuesta.setTitulo("Validaciones en la generaci�n de NIP");
		return respuesta;
	}

	/** 
	 * Validaci�n de expedientes permanentes (Identificaci�n y enrolamiento)
	 * @param trabajador
	 * @throws BusinessException
	 */
	private void validarExpedientes(DatosTrabajador trabajador) throws BusinessException {
		
		if(!utileriaValidador.validarObjetoNulo(trabajador.getDatosExpediente())) {
			DatosExpediente expediente = trabajador.getDatosExpediente();
			validarEnrolamientoPermanente(expediente);
			validarExpedientePermanenteIdentificacion(expediente);
		}
	}
	
	/**
	 * Validaci�n de enrolamiento permanente
	 */
	private void validarEnrolamientoPermanente(DatosExpediente expediente) throws BusinessException {
		
		logger.info("[validarEnrolamientoPermanente] - BanderaEnrolamiento:{} - EstatusEnrolamiento:{}", 
				expediente.getBanderaEnrolamiento(), expediente.getEstatusEnrolamiento());
		if( !(expediente.getBanderaEnrolamiento().equals(NumerosConstants.INT_UNO) )) {
			//malopezt: 14/02/2022
			// NOTA. Comenta equipo de Caro, que Bandera = 1 indica que Hay enrolamiento y que est� en estado Permanente
//				&& 
//				expediente.getEstatusEnrolamiento().equals(String.valueOf(NumerosConstants.INT_CINCO)))) {
			throw new BusinessException("El usuario no cuenta con enrolamiento permanente");
		}
	}
	
	/**
	 * Validaci�n de expediente de identificaci�n permanente
	 */
	private void validarExpedientePermanenteIdentificacion(DatosExpediente expediente) throws BusinessException {
		
		logger.info("[validarEnrolamientoPermanente] - BanderaExpIdentificacion:{} - EstatusExpIdentificacion:{}", 
				expediente.getBanderaExpedienteIdentifiacion(), expediente.getEstatusExpedienteIdentificacion());
		if( !(expediente.getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_UNO) )) {
			//malopezt: 14/02/2022 
			//NOTA. Comenta equipo de Caro, que Bandera = 1 indica que Hay enrolamiento y que est� en estado Permanente
			// Bandera = hay expediente o enrolamiento pero ene stado temporal
			// Bander = 0 No hay expediente o enrolamiento (seg�n sea el caso
			
//				&& 
//				expediente.getEstatusExpedienteIdentificacion().equals(String.valueOf(NumerosConstants.INT_CINCO)))) {
			throw new BusinessException("El usuario no cuenta con expediente de identificaci�n permanente");
		}
	}

	/**
	 * Determina que no haya duplicidad de curp de acuerdo a la consulta 360.
	 * @param trabajador
	 */
	private void validarDuplicidadCurp(DatosTrabajador trabajador) throws BusinessException {
		// Nota. La consulta 360 devuelve una lista de curps duplicadas.
		// ConsultaPersonaCertificable
		// L�nea: trabajador.setAforesDuplicadas(this.consultarCurpDuplicada(curp, trabajador.getProcesar(), auxiliarTrabajador.getClaveAfore()));
		if (trabajador.getAforesDuplicadas().size() > Integer.valueOf(NumerosConstants.C_CERO)) {
			throw new BusinessException("CURP duplicada en BD");
		}
	}
	
	/**
	 * Validaci�n de existencia de datos Correo y Celular en la BUU
	 * @param curp
	 */
	private void validarInformacionComplementariaDeBUU(NipConsultaBUU consultaBUU) {
		
		if (consultaBUU.getCorreoElectronico() == null || consultaBUU.getTelefono() == null) {
			throw new BusinessException("El trabajador no cuenta con informaci�n asociada a una APP o AFORE Web, por lo que no puede solicitar el NIP para uso de dichos aplicativos");
		} 
	}
	

	/**
	 * Validaci�n cuenta no cuente con Nip Activo.
	 * @param consultaBUU
	 */
	private void validarNipNoActivo(NipConsultaBUU consultaBUU) {
		
		validarComunicacionBUU(consultaBUU);
		if ( (! CONSTANTE_NO_NIP_ACTIVO.equals(consultaBUU.getConfirmacionTransaccion())) && 
				RECHAZO_102.equals(consultaBUU.getMotivoRechazo())) {
			throw new BusinessException("No puede generarse un NIP ya que el trabajador cuenta con un NIP activo /vigente");
		}
		
	}
	
	/** Determina si el error encontrado corresponde a fallo de comunicaci�n BUU */
	private void validarComunicacionBUU(NipConsultaBUU consultaBUU) {
		
		if ( (! CONSTANTE_NO_NIP_ACTIVO.equals(consultaBUU.getConfirmacionTransaccion())) && 
				PROBLEMA_COMUNICACION_BUU.equals(consultaBUU.getMotivoRechazo())) {
			throw new BusinessException(MENSAJE_ERROR_GRAL_COMUNICACION_SERVICIO);
		}
	}
}
