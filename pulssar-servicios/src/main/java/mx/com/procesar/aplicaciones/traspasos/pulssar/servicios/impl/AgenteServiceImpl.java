package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.AgenteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgentePromotorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AforeAgente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AgentePromotor;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Servicio que consume los metodo de Agente Service
 * @author ANOSORIO
 *
 */
@Service
public class AgenteServiceImpl implements AgenteService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(AgenteServiceImpl.class);
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Autowired
	private CadenasUtils utileriaCadenas;
	
	/**
	 * Inyeccion servicio catalogo 
	 */
	@Autowired 
	private CatalogoService servicioCatalogo;
	
	/**
	 * Cliente
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	/**
	 * Inyeccion utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Value("${url.servicio.comunes}")
	private String servicioComunes;
	
	/**
	 * Metodo encargado de invocar el servicio de busqueda de Agente 
	 * 
	 * @param datosRegistro
	 * @return
	 */
	@Override
	public AgentePromotor validarAgentePromotor(DatosRegistro datosRegistro, boolean isFoto) {
		logger.info("Metodo encargado de realizar el consumo de la consulta del agente :: {}", datosRegistro);
		AforeAgente aforeAgente = new AforeAgente(); 
		aforeAgente.setClaveAfore(datosRegistro.getClaveAfore());
		aforeAgente.setClaveAgente(datosRegistro.getNumeroAgente());
		aforeAgente.setFotoAgente(isFoto);
		aforeAgente.setNombreAgente(datosRegistro.getNombre());
		aforeAgente.setApellidoPaterno(datosRegistro.getApellidoPaterno());
		aforeAgente.setApellidoMaterno(utileriaCadenas.obtenerContenidoCadenaSinEspacios(datosRegistro.getApellidoMaterno(), null));
		List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_ESTADO_AGENTE, "");
		aforeAgente.setTipoAgente(utileriaValidador.obtenerValorParametro(listaParametro, AgentePromotorConstants.CLAVE_AGENTE_PARAM, AgentePromotorConstants.CLAVES_AGENTE_PROMOTOR));
		
		String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true, servicioComunes, ServiciosConstants.SERVICIO_AGENTE, ServiciosConstants.METODO_CONSULTA_AGENTE);
		logger.info("Servicio consulta de usuario url :: {} >> datos :: {}", urlServicio, aforeAgente);
		AgentePromotor agente = servicioCliente.postForObject(urlServicio, aforeAgente, AgentePromotor.class);
		logger.info("Respuesta servicio Agente :: {}", agente);
		if(!utileriaValidador.validarVacio(agente.getCodigoOperacion())) {
			throw new BusinessException(BusinessErrorEnum.EXCEPTION_SERVICIO_AGENTE, agente.getCodigoOperacion());
		} 
		return agente;
	}
}