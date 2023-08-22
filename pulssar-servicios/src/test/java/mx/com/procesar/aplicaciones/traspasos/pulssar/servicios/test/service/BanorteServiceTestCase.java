package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertEquals;

import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BanorteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.BanorteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * clase de pruebas de la validacion de un registro de usuario
 * 
 * @author dbarbosa
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class BanorteServiceTestCase {

	/**
	 * Dependecia servicioRegistroUsuario
	 */
	@Autowired
	private BanorteService servicioCorreo;
	
	/**
	 * Test encargado de Validar Registro Usuario
	 */
	@Test
	public void testGenerarUrlPeticionTablet() {
		String CONSTANTES = "http://192.168.18.143:80/AforeBridgeTablet/AppBridgeTablet.application?numSol=folio&modRet=01&us=&amb=D&nss=nss&curp=curp&tps=01&tnp=01";
		
		UsuarioLogin usuario = new UsuarioLogin();
		usuario.setDatoUsuario(1l);
		
		Map<String,String> parametros = new Hashtable<>();
	    parametros.put(BanorteConstants.FOLIO,"folio");		
		parametros.put(BanorteConstants.MODALIDAD_TRAMITE,"01");
		parametros.put(BanorteConstants.NSS,"nss");
		parametros.put(BanorteConstants.CURP,"curp");
		parametros.put(BanorteConstants.TIPO_PARENTESCO,"01");		
		parametros.put(BanorteConstants.TRAMITE_NO_PRESENCIAL,"01");		
		
	   String url =servicioCorreo.generarUrlPeticionTablet(parametros, usuario);
	   assertEquals(CONSTANTES, url);
	   
		   
	}
	
}