package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ParametroOperativoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaToken;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaJson;

/**
 * Clase que implementa los servicios de de guardado de datos del token de usuario en la BDNSAR
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since
 */
@Service
public class ParametroOperativoServiceImpl implements ParametroOperativoService {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ParametroOperativoServiceImpl.class);

    /**
     * Objeto utilizado para la invocacion del servicio rest de gurdado de datos del Token
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Url del servicio de guardado de token
     */
    @Value("${url.plataforma.servicios.guardado.token}")
    private String urlServicio;

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ParametroOperativoService#guardarTokenUsuario(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaToken)
     */
    @Override
    public RespuestaJson guardarTokenUsuario(DatosEntradaToken datosToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        LOGGER.info(ExpresionesConstants.URL_ACTUALIZAR, urlServicio);
        HttpEntity<DatosEntradaToken> entity = new HttpEntity<>(datosToken, httpHeaders);
        ResponseEntity<RespuestaJson> response = null;
        try {
            response = restTemplate.exchange(urlServicio, HttpMethod.POST, entity, RespuestaJson.class);
        } catch(Exception e) {
            LOGGER.error("Error al invocar el servicio rest: ", e);
        }
        RespuestaJson respuesta = null;
        if (response != null) {
            respuesta = response.getBody();
        } else {
            LOGGER.error("El servicio retorno una respuesta nula");
        }
        LOGGER.info("Se obtiene la siguiente respuesta de servicio: {}", respuesta);
        return respuesta;
    }

}
