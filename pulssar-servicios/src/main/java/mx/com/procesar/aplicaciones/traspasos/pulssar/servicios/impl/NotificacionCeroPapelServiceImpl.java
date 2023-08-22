package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionCeroPapelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Notificacion cero service
 * @author RARREOLA
 *
 */
@Service
public class NotificacionCeroPapelServiceImpl implements NotificacionCeroPapelService{
	
	
	/**
	 * Logger
	 */
	private static final Logger logger =  LoggerFactory.getLogger(NotificacionCeroPapelServiceImpl.class);
	
	/**
	 * dependencia clienteServicio
	 */
	@Autowired
	private RestTemplate clienteServicio;
	
	/**
	 * dependencia catalogo
	 */
	@Autowired
	private CatalogoServiceImpl servicioCatalogo;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * uriGuardarCeroPapel
	 */
	@Value("${comunes.guardar.notificacionCeroPapel}")
	private String uriGuardarNotificacionCeroPapel;

	/**
	 * Guardar datos de cero papel
	 * @param principalCeroPapel
	 */
	@Async
	@Override
	public void guardarDatosNotificacionCeroPapel(EntradaCeroPapel entradaCeroPapel, String tipoAfiliacion) {
		try{
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_TIPO_AFILIACION, "");
			String valor = utileriaValidador.obtenerValorParametro(listaParametro, AgenteConstants.TIPO_AFILIACION_ISSSTE, AgenteConstants.AFILIACION_ISSSTE);
			
			if(valor.contains(tipoAfiliacion)) {
				entradaCeroPapel.setNss(null);
			}
			
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<EntradaCeroPapel> entidadFolio = new HttpEntity<>(entradaCeroPapel, headerMedia);
			
			logger.info(uriGuardarNotificacionCeroPapel);
			logger.info("Peticion generacion de cero papel {}", entradaCeroPapel.toString());

			clienteServicio.put(uriGuardarNotificacionCeroPapel, entidadFolio);
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio de guardar los datos de  cero papel", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		
	}

}
