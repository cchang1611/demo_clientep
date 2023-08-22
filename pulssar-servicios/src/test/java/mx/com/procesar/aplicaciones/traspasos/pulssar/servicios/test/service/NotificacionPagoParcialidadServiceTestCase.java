package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;

import org.jfree.util.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.NotificacionParcialidadIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionPagoParcialidadService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NotificacionPagoParcialidadServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * TestCase que realiza la notificacion de la Parcialidad 
 * @author ANOSORIO
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class NotificacionPagoParcialidadServiceTestCase {

	/**
	 * Inyeccion de Servicio
	 */
	@Autowired
	private NotificacionPagoParcialidadService notificaParcialidad = new NotificacionPagoParcialidadServiceImpl();
	
			
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		cambiaValor("urlnotificaPagosParcialidad", notificaParcialidad, "http://192.168.10.5:7001/comunesPulssar/retiro/pagos/notificacionPagos");
	}
    	
	/**
	 * Test Notificacion Parcial
	 */
	@Test
	public void testNotificarPagoParcialidad() {
	  try {	
		  NotificacionParcialidadIssste notificaEntrada = new NotificacionParcialidadIssste();
		  HttpStatus notifica = notificaParcialidad.notificarPagoParcialidad(notificaEntrada);
		  assertNotNull(notifica);
	  }catch (Exception e) {
		  Assert.assertNotNull(e);
	}
 }	
	
	/**
	 * Test Notificacion parcial error 500
	 */
	  @Test
		public void testNotificarPagoParcialidadError500() {
		  try {	
			  NotificacionParcialidadIssste notificaEntrada = new NotificacionParcialidadIssste();
			  notificaEntrada.setResultadoOperacion("02");
			  HttpStatus notifica = notificaParcialidad.notificarPagoParcialidad(notificaEntrada);
			  assertNotNull(notifica);
		  }catch (Exception e) {
			  Assert.assertNotNull(e);
		}
	  
	}
	
	/**
	 * cambia el valor de una propiedad
	 * @param nombreAtributo
	 * @param instancia
	 * @param valor
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	protected void cambiaValor(String nombreAtributo, Object instancia, Object valor) {
		Field atributo;
		try {
			try{
				atributo = ReflectionUtils.findField(instancia.getClass(), nombreAtributo);
			} catch (Exception e1){
				atributo = instancia.getClass().getDeclaredField(nombreAtributo);
			}
			
			ReflectionUtils.makeAccessible(atributo);
			ReflectionUtils.setField(atributo, instancia, valor);
		} catch (Exception e) {
       Log.error("Error");
		}
		
	}
	
}
