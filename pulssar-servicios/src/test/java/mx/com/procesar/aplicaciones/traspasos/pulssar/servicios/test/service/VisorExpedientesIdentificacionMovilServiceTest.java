package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.http.RequestMethod;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.VisorExpedientesIdentificacionMovilService;

/**
 * VisorExpedientesIdentificacionMovilServiceTest
 * @author jmordone
 *
 */

public class VisorExpedientesIdentificacionMovilServiceTest extends BaseTestCase {
	
	/**
	 * visorExpedientesIdentificacionMovilService
	 */
	@Autowired
	private VisorExpedientesIdentificacionMovilService visorExpedientesIdentificacionMovilService;
	
	/**
	 * servidor mock
	 */
	static WireMockServer wm ;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		if(wm == null) {
			wm = new WireMockServer(options().port(9999));
		}
		wm.start();
		
		// monioreo de capa de trasporte
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if(wm.isRunning()) {
			wm.stop();
			wm.shutdownServer();
		}
	}

	 @Before	
	 public void setUpBefore() {
		cambioMock(visorExpedientesIdentificacionMovilService,"uriComunes");  
		  
	 }
		    
	 @After
	 public void setUpAfter() {
	    cambio(visorExpedientesIdentificacionMovilService,"uriComunes");
	  }
			
     /**
      * obtenerExpedientesTest
      */
	 @Test
	 public void obtenerExpedientesTest() {
		String folio="{\"resultadoOperacion\":\"01\",\"diagnostico\":\"\",\"descripcion\":\"OK\"}";
		super.crearStub(wm, "/comunesPulssar/visorExpedientesIdentificacionMovil/V2/consultaExpediente", 200, folio, RequestMethod.POST);
		visorExpedientesIdentificacionMovilService.obtenerExpedientes("02", "578", "MELN780703MDFNNN06", "tipoExpediente", null);
	 }
	 
	 @Test
	 public void obtenerExpedientesNullTest() {
		String folio=null;
		super.crearStub(wm, "/comunesPulssar/visorExpedientesIdentificacionMovil/V2/consultaExpediente", 200, folio, RequestMethod.POST);
		try {
			visorExpedientesIdentificacionMovilService.obtenerExpedientes("02", "578", "MELN780703MDFNNN06", "tipoExpediente", null);
		}catch(Exception e) {
			assertNotNull(e);
		}
	 }
	 
	 @Test
	 public void obtenerExpedientesRehazoTest() {
		String folio="{\"resultadoOperacion\":\"02\",\"diagnostico\":\"\",\"descripcion\":\"OK\"}";
		super.crearStub(wm, "/comunesPulssar/visorExpedientesIdentificacionMovil/V2/consultaExpediente", 200, folio, RequestMethod.POST);
		try {
			visorExpedientesIdentificacionMovilService.obtenerExpedientes("02", "578", "MELN780703MDFNNN06", "tipoExpediente", null);
		}catch(Exception e) {
			assertNotNull(e);
		}
	 }
	 
	 @Test
	 public void obtenerExpedientesRehazoDiagnosticoTest() {
		String folio="{\"resultadoOperacion\":\"01\",\"diagnostico\":\"600\",\"descripcion\":\"OK\"}";
		super.crearStub(wm, "/comunesPulssar/visorExpedientesIdentificacionMovil/V2/consultaExpediente", 200, folio, RequestMethod.POST);
		try {
			visorExpedientesIdentificacionMovilService.obtenerExpedientes("02", "578", "MELN780703MDFNNN06", "tipoExpediente", null);
		}catch(Exception e) {
			assertNotNull(e);
		}
		
	 }
	 
	 @Test
	 public void obtenerExpedientesErrorTest() {
		String folio="{\"resultadoOperacion\":\"01\",\"diagnostico\":\"600\",\"descripcion\":\"OK\"}";
		super.crearStub(wm, "/comunesPulssar/visorExpedientesIdentificacionMovil/V2/consultaExpediente", 500, folio, RequestMethod.POST);
		try {
			visorExpedientesIdentificacionMovilService.obtenerExpedientes("02", "578", "MELN780703MDFNNN06", "tipoExpediente", null);
		}catch(Exception e) {
			assertNotNull(e);
		}
	 }
}
