package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionServiceFabrica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionServiceSaldosYMovimientos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ReimpresionServiceFabricaImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;


/**
 * ReimpresionServiceFabricaTestCase
 * @author jmordone
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ReimpresionServiceFabricaTestCase {
	
	/**
	 * DisposicionTotalIsssteService
	 */
	@InjectMocks
	private ReimpresionServiceFabrica reimpresionService =new ReimpresionServiceFabricaImpl();
   
    /**
	 * consentimiento
	 */
	@Mock
	private ReimpresionService consentimiento;
	
	/**
	 * solicitudModificacionDatos
	 */
	@Mock
	private ReimpresionService solicitudModificacionDatos;
	
	/**
	 * permanencia
	 */
	@Mock
	private ReimpresionService permanencia;
	
	/**
	 * reimpresionServiceSaldosYMovimientos
	 */
	@Mock
	private ReimpresionServiceSaldosYMovimientos reimpresionServiceSaldosYMovimientos;
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * testObtenerServicioReimpresionConsentimiento
	 */
	@Test
	public void testObtenerServicioReimpresionConsentimiento () {
		ReimpresionService reimpresion=reimpresionService.obtenerServicioReimpresion(1);
		Assert.assertNotNull(reimpresion);
	}
	
	/**
	 * testObtenerServicioReimpresionModificador
	 */
	@Test
	public void testObtenerServicioReimpresionModificador () {
		ReimpresionService reimpresion=reimpresionService.obtenerServicioReimpresion(2);
		Assert.assertNotNull(reimpresion);
	}
	
	/**
	 * testObtenerServicioReimpresionPermanencia
	 */
	@Test
	public void testObtenerServicioReimpresionPermanencia () {
		ReimpresionService reimpresion=reimpresionService.obtenerServicioReimpresion(3);
		Assert.assertNotNull(reimpresion);
	}
	
	/**
	 * testObtenerArchivoPorTramiteSaldosMovimientosResumen
	 */
	@Test
	public void testObtenerArchivoPorTramiteSaldosMovimientosResumen () {
		Mockito.when(reimpresionServiceSaldosYMovimientos.obtenerArchivosReimpresion(datosTrabajador(), Mockito.anyString(),datosUser())).
			thenReturn(datosArchivo());
		DatosArchivos datosArchivo=reimpresionService.obtenerArchivoPorTramiteSaldosMovimientos(1,datosTrabajador(),datosUser());
		Assert.assertNotNull(datosArchivo);
	}
	
	/**
	 * testObtenerArchivoPorTramiteSaldosMovimientosEstado
	 */
	@Test
	public void testObtenerArchivoPorTramiteSaldosMovimientosEstado () {
		Mockito.when(reimpresionServiceSaldosYMovimientos.obtenerArchivosReimpresion(datosTrabajador(), Mockito.anyString(), datosUser())).
			thenReturn(datosArchivo());
		DatosArchivos datosArchivo=reimpresionService.obtenerArchivoPorTramiteSaldosMovimientos(2,datosTrabajador(),datosUser());
		Assert.assertNotNull(datosArchivo);
	}
	
	/**
	 * testObtenerArchivoPorTramiteSaldosMovimientosDetalle
	 */
	@Test
	public void testObtenerArchivoPorTramiteSaldosMovimientosDetalle () {
		Mockito.when(reimpresionServiceSaldosYMovimientos.obtenerArchivosReimpresion(datosTrabajador(), Mockito.anyString(), datosUser())).
			thenReturn(datosArchivo());
		DatosArchivos datosArchivo=reimpresionService.obtenerArchivoPorTramiteSaldosMovimientos(3,datosTrabajador(),datosUser());
		Assert.assertNotNull(datosArchivo);
	}
	
	/**
	 * datosTrabajador
	 * @return
	 */
    private DatosTrabajador datosTrabajador() {
    	DatosTrabajador trabjador = new DatosTrabajador();
    	DatosCertificables certificables= new DatosCertificables();
    	certificables.setCurp("lkslkslks");
    	trabjador.setClaveAfore("s22");
    	trabjador.setDatosCertificables(certificables);
    	trabjador.setFolio(folio());
		return trabjador;
	}
    private UsuarioLogin datosUser() {
    	UsuarioLogin usrLogin = new UsuarioLogin();
    	usrLogin.setUsuario("1508080321");
    	usrLogin.setNombre("Yorch");
    	return usrLogin;
    }

    private FolioEntrada folio() {
    	FolioEntrada FolioEntrada = new FolioEntrada();
    	FolioEntrada.setFolio("sjkkjs");
		return FolioEntrada;
	}

	/**
     * datosArchivo
     * @return
     */
	private DatosArchivos datosArchivo() {
    	DatosArchivos datos = new DatosArchivos();
    	datos.setByteArchivo("ok");
    	return datos;
    	
    }
}
