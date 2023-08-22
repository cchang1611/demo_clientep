package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoPrestacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
/**
 * Servicio que implementa consulta catalogo TipoPrestacion 
 * @author ANOSORIO
 *
 */
@Service
public class CatalogoTipoPrestacionServiceImpl implements CatalogoTipoPrestacionService{

	/**
	 * Inyeccion de servicio tipo solicitante 
	 */
	@Value("${url.consulta.iret.tipoPrestacion}")
	private String urlCatalogoTipoPrestacion;
	
	
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
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoPrestacionService#consultaTipoPrestacion()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoIret> consultaTipoPrestacion() {
		String urltipoPrestacion = utileriaCadena.obtenerCadenaConcatenada(true, urlCatalogoTipoPrestacion, null);
		return servicioCliente.getForObject(urltipoPrestacion, List.class);
	}

	
}
