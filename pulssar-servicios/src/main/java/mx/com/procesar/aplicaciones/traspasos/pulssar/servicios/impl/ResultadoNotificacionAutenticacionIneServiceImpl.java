package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ResultadoNotificacionAutenticacionIneService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AutenticacionIne;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosAutenticacionIne;

/**
 * Servicio que consume los metodo de notificacion autenticacion ine
 * @author ANOSORIO
 *
 */
@Service
public class ResultadoNotificacionAutenticacionIneServiceImpl extends BaseServiceImpl implements ResultadoNotificacionAutenticacionIneService {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AutenticacionIne validarResultadoAutenticacionIne(String curp) {
		AutenticacionIne autenticacionIne = null;
		try {
			String uri = ServiciosConstants.URI_CONSULTA_RESULTADO_AUTENTICA_INE;
			uri = StringUtils.replace(uri, "{curp}", curp);
			logger.error("La ruta de la peticion es: {}", uri);
			
			AutenticacionIne resultado = restServiceClientUtils.ejecutarServicioGet(uriComunes, uri, AutenticacionIne.class);
			if (!validadorUtils.validarObjetoNulo(resultado) && !validadorUtils.validarObjetoNulo(resultado.getId())){
				autenticacionIne = resultado;
			}
		} catch (Exception e) {
			logger.error("Error al obtener el objeto de autenticacion Ine ", e);
		}
		return autenticacionIne;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void guardarDetalleAdicionalAutenticacionIne(Long idUsuario, String afore, String curp) {
		try {
			DatosAutenticacionIne entrada = new DatosAutenticacionIne();
			entrada.setCurpTrabajadorConsultar(curp);
			entrada.setCvAfore(afore);
			entrada.setUsuario(idUsuario);
			
			restServiceClientUtils.ejecutarServicioPut(uriComunesTransaccional, ServiciosConstants.URI_GUARDAR_DETALLE_RESULTADO_AUTENTICA_INE, entrada, String.class);
		} catch (Exception e) {
			logger.error("Error al obtener el objeto de autenticacion Ine ", e);
		}
	}
}