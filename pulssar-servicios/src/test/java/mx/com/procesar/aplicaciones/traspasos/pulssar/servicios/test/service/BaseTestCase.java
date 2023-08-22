package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationWmContextTest;

/**
 * base de los test case. contiene metodos y atributos usados en varios test
 * case
 * 
 * @author jcgarces
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationWmContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public abstract class BaseTestCase extends BaseMockTestCase {


	/**
	 * logger
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Ruta donde se encuentra el archivo zip a validar.
	 */
	protected java.lang.String RUTA = new StringBuilder(
			"src/test/resources/nist/").toString();

	public void cambioMock(Object object,String campo ) {
    	String valor= cambio(object,campo,"lbint-devl.procesar.net", "localhost:9999");
    	ReflectionTestUtils.setField(object,campo,valor);
    }
    public void cambioMock6690(Object object,String campo ) {
    	String valor= cambio(object,campo,"172.21.66.90", "localhost:9999");
    	ReflectionTestUtils.setField(object,campo,valor);
    }
    
    public void cambio(Object object,String campo) {
    	String valor= cambio(object,campo, "localhost:9999","lbint-devl.procesar.net");
    	ReflectionTestUtils.setField(object,campo,valor);
    }
    
    public void cambio6690(Object object,String campo) {
    	String valor= cambio(object,campo, "localhost:9999","172.21.66.90");
    	ReflectionTestUtils.setField(object,campo,valor);
    }
	
    public String cambio(Object object,String campo, String valor,String nuevoValor) {
    	String sCampo = (String)ReflectionTestUtils.getField(object,campo);
    	return sCampo.replaceAll(valor, nuevoValor);
    }
	
}
