package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoClavePensionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
/**
 * Servicio que implementa consulta clavePension
 * @author ANOSORIO
 *
 */
@Service
public class CatalogoClavePensionServiceImpl implements CatalogoClavePensionService{

	/**
	 * Inyeccion de servicio tipo solicitante 
	 */
	@Value("${url.consulta.iret.clavePension}")
	private String urlCatalogoClavePension;
	
	
	/**
	 * Rest Cliente
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	/**
	 * dependencia utilidad cadena
	 */
	@Autowired 
	private CadenasUtils utileriaCadena;
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoClavePensionService#consultaClavePension()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoIret> consultaClavePension() {
		String urltipoSeguro = utileriaCadena.obtenerCadenaConcatenada(true, urlCatalogoClavePension, null);
		return servicioCliente.getForObject(urltipoSeguro, List.class);
	}

}
