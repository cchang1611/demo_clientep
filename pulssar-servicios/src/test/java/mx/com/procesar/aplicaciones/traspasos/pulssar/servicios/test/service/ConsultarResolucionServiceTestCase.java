//package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//import org.jfree.util.Log;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.client.RestTemplate;
//
//import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ResolucionReti;
//import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
//import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
//import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarResolucionService;
//import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
//import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
//import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ConsultarResolucionServiceImpl;
//import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
//import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
//import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
///**
// * Test consulta resolucion
// * @author ANOSORIO
// *
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
//		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
//		PulssarCorreoAplicationContextTest.class })
//public class ConsultarResolucionServiceTestCase {
//
//	/**
//	  * Inyeccion service
//	  */
//   @Autowired
//   @InjectMocks
//	private ConsultarResolucionService resolucionService = new ConsultarResolucionServiceImpl();
//  
//   /**
//    * Inyeccion Mock restTemplate
//    */
//   @Mock
//	private RestTemplate restTemplate;
//   
//   /**
//    * Inyeccion Mock utileriaValidador
//    */
//   @Mock
//   private ValidadorUtils utileriaValidador;
//   
//   /**
//	 * Inicializa los elementos para la prueba.
//	 */
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		
//	
//	}
//   
//	   
//   /**
//    * Test consulta Resolucion 
//    */
//   @Test
//   public void testConsultarResolucion() {
//	   ResolucionReti reti= new ResolucionReti();
//	   try {
//		   Mockito.when(restTemplate.getForObject(Mockito.anyString(),Mockito.eq(ResolucionReti.class))).thenReturn(new ResolucionReti());
//	   reti = resolucionService.consultarResolucion(1l, "2", "4");
//	   assertNotNull(reti);
//	   }catch (Exception e) { 
//		   Log.error("Error Resolucion:{}",e);
//	}
//   }
//  
//   /**
//    * Test Consulta Resolucion Nulo
//    */
//   @Test
//   public void testConsultarResolucionNulo() {
//	   ResolucionReti reti= new ResolucionReti();
//	   try {
//		   Mockito.when(restTemplate.getForObject(Mockito.anyString(),Mockito.eq(ResolucionReti.class))).thenReturn(new ResolucionReti());
//		   Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any(ResolucionReti.class))).thenReturn(Boolean.TRUE);
//		   
//	   reti = resolucionService.consultarResolucion(1l, "3", "6");
//	   assertNotNull(reti);
//	   }catch (Exception e) { 
//		   Log.error("Error Nulo:{}",e);
//	}
//   }
//       
//      
//   /**
//    * Test consulta resolucion excepcion
//    */
//   @Test
//   public void testConsultarResolucionException() {
//   ResolucionReti reti= new ResolucionReti();
//	   try {
//	    Mockito.when(restTemplate.getForObject(Mockito.anyString(),Mockito.eq(ResolucionReti.class)))
//		.thenThrow(new GenericException(GenericErrorEnum.PARAMETRO_NULO));
//	   reti= resolucionService.consultarResolucion(0l, "3", "6");
//	     assertNull(reti);
//		 }catch (Exception e) { 
//			Log.error("Error Exception:{}",e);
//	}
//   }
//   
//  
//   
//  
//  
//}
//
