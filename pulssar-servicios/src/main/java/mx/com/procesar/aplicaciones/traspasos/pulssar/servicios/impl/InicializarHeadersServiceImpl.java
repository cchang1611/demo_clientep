package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.InicializarHeadersService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
/**
 * Servicio para inicilizar las cabeceras 
 * @author ANOSORIO
 *
 */
@Service
public class InicializarHeadersServiceImpl implements InicializarHeadersService{
    
	
    /*
     * (non-Javadoc)
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.InicializarHeadersService#iniciliazarCabecras()
     */
	@Override
	public HttpHeaders inicializarCabeceras() {
		HttpHeaders headers = new HttpHeaders();	
		headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.set("idServicio",ServiciosConstants.HISTORICO_IDSERVICIO);
	    headers.set("idCliente", ServiciosConstants.HISTORICO_IDCLIENTE);
	    headers.set("idEbusiness", ServiciosConstants.HISTORICO_IDEBUSINESS);
		return headers;
	}
    
	
}
