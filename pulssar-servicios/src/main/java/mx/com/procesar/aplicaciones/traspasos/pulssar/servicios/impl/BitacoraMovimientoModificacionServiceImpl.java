package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BitacoraMovimientoModificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BitacoraMovimientoEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;

/**
 * Implementacion de servicio de bitacora movimiento
 * @author JMGUTIEG
 *
 */
@Service
public class BitacoraMovimientoModificacionServiceImpl implements BitacoraMovimientoModificacionService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(BitacoraMovimientoModificacionServiceImpl.class);
	
	/**
	 * dependencia clienteServicio
	 */
	@Autowired
	private RestTemplate clienteServicio;
	
	/**
	 * url comunes transaccional
	 */
	@Value("${uri.comunes.transaccional}")
	private String urlComunesTransaccional;
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void guaradarMovimientoModificacion(BitacoraMovimientoEntrada entradaBitacora) {
		logger.info("Entrada guaradarMovimientoModificacion {}",entradaBitacora);
		try {
			String url = utileriaCadena.obtenerCadenaConcatenada(true, urlComunesTransaccional,ExpresionesConstants.BITACORA_MOVIMIENTO,ExpresionesConstants.DIAGONAL,ExpresionesConstants.PASO_BITACORA);
			logger.info("url guaradarMovimientoModificacion {}",url);
			clienteServicio.postForObject(url, entradaBitacora, String.class);
		}catch (Exception e) {
			logger.error("Ocurrio un error en guaradarMovimientoModificacion: {}",e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void generaObjetoModificacion(String cvProceso,String descripcion,String diagnostico,String flujo,String nss,String curp,String folioPadre,String folioHijo,String resultado) {
		BitacoraMovimientoEntrada entradaBitacora = new BitacoraMovimientoEntrada();
		entradaBitacora.setCvProceso(cvProceso);
		entradaBitacora.setDescripcion(descripcion);
		entradaBitacora.setDiagnostico(diagnostico);
		entradaBitacora.setFlujo(flujo);
		entradaBitacora.setNss(nss);
		entradaBitacora.setCurp(curp);
		entradaBitacora.setFolioPulsarHijo(folioHijo);
		entradaBitacora.setFolioPulsarPadre(folioPadre);
		entradaBitacora.setResultado(resultado);
		guaradarMovimientoModificacion(entradaBitacora);
	}
}
