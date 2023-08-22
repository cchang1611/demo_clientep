package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionAutenticacionIneService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AutenticacionIne;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionAutenticacionIne;
/**
 * Notificacion cero service
 * @author dbarbosa
 *
 */
@Service
public class NotificacionAutenticacionIneServiceImpl extends BaseServiceImpl implements NotificacionAutenticacionIneService {

	/**
	 * Guardar datos de cero papel
	 * @param principalCeroPapel
	 */
	@Async
	@Override
	public void guardarDatosNotificacionAutenticacionIne(AutenticacionIne autentica, String usuario, String folio) {
		try {
			NotificacionAutenticacionIne notificacion = new NotificacionAutenticacionIne();
			notificacion.setChUsuario(usuario);
			notificacion.setChFolio(folio);
			notificacion.setChAfore(autentica.getCvAfore());
			notificacion.setIdAutenticacionIne(1L);//TODOS
			notificacion.setChCurpTrabajador(autentica.getCurpTrabajador());
			notificacion.setChTipoSolicitante(autentica.getTipoSolicitante());
			notificacion.setIdUsuarioPulssar(autentica.getUsuario());
			notificacion.setChDiagnosticoProcesar(autentica.getResultadoIne());
			
			restServiceClientUtils.ejecutarServicioPut(uriComunesNotificacion, ServiciosConstants.SERVICIO_NOTIFICACION_INE, notificacion, NotificacionAutenticacionIne.class);
		} catch (Exception e) {
			logger.error("Error al moento de mandar la notificacion ", e);
		}
		
	}
}
