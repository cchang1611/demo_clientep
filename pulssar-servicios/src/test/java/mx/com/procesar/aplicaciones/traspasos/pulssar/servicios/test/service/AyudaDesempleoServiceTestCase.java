package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CertificadoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class AyudaDesempleoServiceTestCase {

	/**
	 * inyeccion ayuda desemplo
	 */
	@Autowired
	private CertificadoService ayudaDesempleoService;
	
	/**
	 * test ValidarSolicitudCertificacionAforeSalida exito
	 */
	@Test
	public void testValidarSolicitudCertificacionAforeSalida() {
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		DatosCertificables datos = new DatosCertificables();
		FolioEntrada folio = new FolioEntrada();
		folio.setFolio("folio");
		datos.setNombre("nombre");
		datos.setApellidoPaterno("APaterno");
		datos.setApellidoMaterno("AMaterno");
		BigInteger big = BigInteger.valueOf(87785L);
		datosTrabajador.setNss("nss");
		datosTrabajador.setTipoDePrestacion("texto");
		datosTrabajador.setClaveAdminActual("556");
		datosTrabajador.setOrigen(big);
		datosTrabajador.setNombreTrabajador("nombre");
		datosTrabajador.setFolio(folio);
		datosTrabajador.setDatosCertificables(datos);
//		ValidarSolicitudCertificacionAforeSalida salida = ayudaDesempleoService.validarCertificado(datosTrabajador);
//		assertNotNull(salida);
	}

}
