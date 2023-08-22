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
 * Proceos de validación de datos en solicitud de Generación de NIPs
 * RFC: WB00288
 */
@Service("nipValidadorService")
public class NipValidadorServiceImpl implements NipValidadorService {

	/** Registro Log */
	private static final Logger logger = LoggerFactory.getLogger(NipValidadorServiceImpl.class);
	
	/** Constante numérica: Define Éxito en la generación de NIP */
	private static final Integer CONTANTE_EXITO = 1;
	
	/** Constante numérica: Describe la existencia de un error en la generación de NIP */
	private static final Integer CONTANTE_ERROR = 2;

	private static final String CONSTANTE_NO_NIP_ACTIVO = "01";

	/** Problema de cominicación con la BUU */
	private static final String PROBLEMA_COMUNICACION_BUU = "0000";
	
	/** Mensaje de error genérico */
	private static final String MENSAJE_ERROR_GRAL_COMUNICACION_SERVICIO =
			"No se ha obtenido respuesta del servicio de Validación BUU";

	/** Rechazo, indica que ya existe un nip activo */
	private static final String RECHAZO_102 = "102";
	
	/** Utileria de validacion*/
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/** ? Servicio de Catalogo */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Realiza Validaciones de negocio sobre la información entrante para la generación de NIP.
	 * @param trabajador
	 * @return RespuestaServicio
	 */
	@Override
	public RespuestaServicio validarInformacion(DatosTrabajador trabajador, NipConsultaBUU consultaBUU) {
		
		logger.info("[validarInformacion] - Inicia validación de soliciutd");
		// TODO: Aplicar procesos de validación
		
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(CONTANTE_EXITO);
		try {
			
			// Validación de duplicidad de Curp
			validarDuplicidadCurp(trabajador);
			validarNipNoActivo(consultaBUU);
			validarInformacionComplementariaDeBUU(consultaBUU);
//			try {
			validarExpedientes(trabajador);
//			}catch (Exception e) {
//				logger.error("[validarInformacion]-Error - Validación expedientes: {}", e);
//			}
			
		} catch (BusinessException be) {
			logger.info("[validarInformacion] Error - Falla validación: {}", be.getMessage());
			respuesta.setFlujo(CONTANTE_ERROR);
			respuesta.setMensaje(be.getMessage());
			respuesta.setTitulo("Validaciones generación de NIP");
		}
//		
//		respuesta.setFlujo(2);
//		respuesta.setMensaje("Prueba Error de Validación");
//		respuesta.setTitulo("Validaciones en la generación de NIP");
		return respuesta;
	}

	/** 
	 * Validación de expedientes permanentes (Identificación y enrolamiento)
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
	 * Validación de enrolamiento permanente
	 */
	private void validarEnrolamientoPermanente(DatosExpediente expediente) throws BusinessException {
		
		logger.info("[validarEnrolamientoPermanente] - BanderaEnrolamiento:{} - EstatusEnrolamiento:{}", 
				expediente.getBanderaEnrolamiento(), expediente.getEstatusEnrolamiento());
		if( !(expediente.getBanderaEnrolamiento().equals(NumerosConstants.INT_UNO) )) {
			//malopezt: 14/02/2022
			// NOTA. Comenta equipo de Caro, que Bandera = 1 indica que Hay enrolamiento y que está en estado Permanente
//				&& 
//				expediente.getEstatusEnrolamiento().equals(String.valueOf(NumerosConstants.INT_CINCO)))) {
			throw new BusinessException("El usuario no cuenta con enrolamiento permanente");
		}
	}
	
	/**
	 * Validación de expediente de identificación permanente
	 */
	private void validarExpedientePermanenteIdentificacion(DatosExpediente expediente) throws BusinessException {
		
		logger.info("[validarEnrolamientoPermanente] - BanderaExpIdentificacion:{} - EstatusExpIdentificacion:{}", 
				expediente.getBanderaExpedienteIdentifiacion(), expediente.getEstatusExpedienteIdentificacion());
		if( !(expediente.getBanderaExpedienteIdentifiacion().equals(NumerosConstants.INT_UNO) )) {
			//malopezt: 14/02/2022 
			//NOTA. Comenta equipo de Caro, que Bandera = 1 indica que Hay enrolamiento y que está en estado Permanente
			// Bandera = hay expediente o enrolamiento pero ene stado temporal
			// Bander = 0 No hay expediente o enrolamiento (según sea el caso
			
//				&& 
//				expediente.getEstatusExpedienteIdentificacion().equals(String.valueOf(NumerosConstants.INT_CINCO)))) {
			throw new BusinessException("El usuario no cuenta con expediente de identificación permanente");
		}
	}

	/**
	 * Determina que no haya duplicidad de curp de acuerdo a la consulta 360.
	 * @param trabajador
	 */
	private void validarDuplicidadCurp(DatosTrabajador trabajador) throws BusinessException {
		// Nota. La consulta 360 devuelve una lista de curps duplicadas.
		// ConsultaPersonaCertificable
		// Línea: trabajador.setAforesDuplicadas(this.consultarCurpDuplicada(curp, trabajador.getProcesar(), auxiliarTrabajador.getClaveAfore()));
		if (trabajador.getAforesDuplicadas().size() > Integer.valueOf(NumerosConstants.C_CERO)) {
			throw new BusinessException("CURP duplicada en BD");
		}
	}
	
	/**
	 * Validación de existencia de datos Correo y Celular en la BUU
	 * @param curp
	 */
	private void validarInformacionComplementariaDeBUU(NipConsultaBUU consultaBUU) {
		
		if (consultaBUU.getCorreoElectronico() == null || consultaBUU.getTelefono() == null) {
			throw new BusinessException("El trabajador no cuenta con información asociada a una APP o AFORE Web, por lo que no puede solicitar el NIP para uso de dichos aplicativos");
		} 
	}
	

	/**
	 * Validación cuenta no cuente con Nip Activo.
	 * @param consultaBUU
	 */
	private void validarNipNoActivo(NipConsultaBUU consultaBUU) {
		
		validarComunicacionBUU(consultaBUU);
		if ( (! CONSTANTE_NO_NIP_ACTIVO.equals(consultaBUU.getConfirmacionTransaccion())) && 
				RECHAZO_102.equals(consultaBUU.getMotivoRechazo())) {
			throw new BusinessException("No puede generarse un NIP ya que el trabajador cuenta con un NIP activo /vigente");
		}
		
	}
	
	/** Determina si el error encontrado corresponde a fallo de comunicación BUU */
	private void validarComunicacionBUU(NipConsultaBUU consultaBUU) {
		
		if ( (! CONSTANTE_NO_NIP_ACTIVO.equals(consultaBUU.getConfirmacionTransaccion())) && 
				PROBLEMA_COMUNICACION_BUU.equals(consultaBUU.getMotivoRechazo())) {
			throw new BusinessException(MENSAJE_ERROR_GRAL_COMUNICACION_SERVICIO);
		}
	}
}
