package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.turnos.test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Servicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.TipoServicioService;

/**
 * Clase de prueba para {@link TipoServicioService}
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
public class TipoServicioServiceTestCase extends BaseTestCase {
	
	/**
	 * Servicio a probar.
	 */
	@Autowired
	private TipoServicioService tipoServicioService;
	
	/**
	 * Permite probar el happy path.
	 */
	@Test
	@Rollback
	public void testBuscarServiciosTurnos() {
		
		List<Servicio> resultado = tipoServicioService.buscarServiciosTurnos();
		
		assertNotNull(resultado);
		assertEquals(6, resultado.size());
	}

}
