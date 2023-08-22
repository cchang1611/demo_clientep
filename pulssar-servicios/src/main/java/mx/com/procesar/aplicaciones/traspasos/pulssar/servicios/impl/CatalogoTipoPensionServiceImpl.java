package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoPensionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
/**
 * Servicio implemeta consulta catalogo 
 * @author ANOSORIO
 *
 */
@Service
public class CatalogoTipoPensionServiceImpl implements CatalogoTipoPensionService{

	/**
	 * Inyeccion de servicio tipo solicitante 
	 */
	@Value("${url.consulta.iret.tipoPension}")
	private String urlCatalogoTipoPension;
	
	
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
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoTipoPensionService#consultaTipoPension()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CatalogoIret> consultaTipoPension() {
		String urlTipoPension = utileriaCadena.obtenerCadenaConcatenada(true, urlCatalogoTipoPension, null);
		return servicioCliente.getForObject(urlTipoPension, List.class);
	}

}
