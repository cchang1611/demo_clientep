package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoSeguroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
/**
 * Servicio que implenta la consulta catalogo
 * @author ANOSORIO
 *
 */
@Service
public class CatalogoTipoSeguroServiceImpl implements CatalogoTipoSeguroService{

	/**
	 * Inyeccion de servicio tipo solicitante 
	 */
	@Value("${url.consulta.iret.tipoSeguro}")
	private String urlCatalogoTipoSeguro;
	
	
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
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoSeguroService#consultaTipoSeguro()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoIret> consultaTipoSeguro() {
		String urltipoSeguro = utileriaCadena.obtenerCadenaConcatenada(true, urlCatalogoTipoSeguro, null);
		return servicioCliente.getForObject(urltipoSeguro, List.class);
	}

	
}
