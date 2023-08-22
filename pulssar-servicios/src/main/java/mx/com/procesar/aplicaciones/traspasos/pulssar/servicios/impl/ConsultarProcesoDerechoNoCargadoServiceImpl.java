package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargadoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoNoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarProcesoDerechoNoCargadoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * 
 * Servicio implementa ConsultarProcesoDerechoNoCargado
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Feb 17, 2021
 */
@Service
public class ConsultarProcesoDerechoNoCargadoServiceImpl implements ConsultarProcesoDerechoNoCargadoService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConsultarProcesoDerechoNoCargadoServiceImpl.class);
		
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * dependencia clienteServicio
	 */
	@Autowired
	private RestTemplate clienteServicio;
	
	 
	
    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarProcesoDerechoNoCargadoService#consultarDerechoNoCargado(mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoNoCargado)
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProcesoDerechoCargadoSalida> consultarDerechoNoCargado(ProcesoDerechoNoCargado entradaDatos) {
		List<ProcesoDerechoCargadoSalida> respuesta = null;
		StringBuilder url = new StringBuilder();
		url.append(uriComunes).append(ExpresionesConstants.DERECHO_NO_CARGADO).append(ActivacionConstants.DIAGONAL).append(ExpresionesConstants.CONSULTA_NO_CARGADO).toString();
		logger.info("url consultarDerechoNoCargado {}",url);
		
		try {
			respuesta =clienteServicio.postForObject(url.toString(), entradaDatos, List.class);
			JsonUtilsImpl<ProcesoDerechoCargadoSalida> json = new JsonUtilsImpl<>();
			respuesta  = json.parseListObjectToListPojo((List<ProcesoDerechoCargadoSalida>) respuesta, ProcesoDerechoCargadoSalida.class);  
			}catch (Exception e) {
			logger.error("Ocurrio un error en consultarDerechoNoCargado: {}",e);
		}
		return respuesta;
		
	}
}
