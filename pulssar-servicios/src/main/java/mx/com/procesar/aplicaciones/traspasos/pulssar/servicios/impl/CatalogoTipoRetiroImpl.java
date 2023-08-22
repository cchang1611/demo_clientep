package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoRetiroIretService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
/**
 * Servicio que implementa consulta catalogo tipo retiro
 * @author ANOSORIO
 *
 */
@Service
public class CatalogoTipoRetiroImpl implements CatalogoTipoRetiroIretService{
  
	/**
	 * Inyeccion de servicio tipo solicitante 
	 */
	@Value("${url.consulta.iret.tipoRetiro}")
	private String urlCatalogoTipoRetiro;
	
	
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
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoRetiroIretService#consultaTipoPrestacion()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoIret> consultaTipoRetiro() {
	String urltipoRetiro = utileriaCadena.obtenerCadenaConcatenada(true, urlCatalogoTipoRetiro, null);
	return servicioCliente.getForObject(urltipoRetiro, List.class);
	}

}
