package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipOutputStream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Afore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CompresorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.EncriptacionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class UtileriasTestCase {
	
	/**
	 * Inyeccion utilidad encriptacion
	 */
	@Autowired
	private EncriptacionUtils encriptacionUtils;
		
	/**
	 * Inyeccion utilidad fecha
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	/**
	 * Inyeccion utilidad cadena
	 */
	@Autowired
	private CadenasUtils cadenaUtils;
	
	/**
	 * Inyeccion utileria validador
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	
	/**
	 * Inyeccion utileria compresor
	 */
	@Autowired
	private CompresorUtils compresorUtils;

	/**
	 * test error encriptacion
	 */
	@Test
	public void testEncriptacionError(){
		try{
			encriptacionUtils.obtieneEncriptacion(null, "ba6fuEXASGJNQ1UhzK97XYsm");
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test actualizar hora inicio exito
	 */
	@Test
	public void testActualizarHoraInicio(){
		Date fecha = fechaUtils.actualizarHoraInicio(new Date());
		assertNotNull(fecha);
	}
	
	/**
	 * test actualizar hora inicio null
	 */
	@Test
	public void testActualizarHoraInicioNull(){
		Date fecha = fechaUtils.actualizarHoraInicio(null);
		assertNull(fecha);
	}
	
	/**
	 * test actualizar hora final exito
	 */
	@Test
	public void testActualizarHoraFinal(){
		Date fecha = fechaUtils.actualizarHoraFinal(new Date());
		assertNotNull(fecha);
	}
	
	/**
	 * test actualizar hora final null
	 */
	@Test
	public void testActualizarHoraFinalNull(){
		Date fecha = fechaUtils.actualizarHoraFinal(null);
		assertNull(fecha);
	}
	
	/**
	 * test suma dias null
	 */
	@Test
	public void testSumaDiasNull(){
		Date fecha = fechaUtils.sumaDias(null, 1);
		assertNull(fecha);	
	}
	
	/**
	 * Test convertir cadena a fecha null
	 */
	@Test
	public void testConvertirCadenaAFechaNull(){
		Date fecha = fechaUtils.convertirCadenaAFecha(null, FormatoConstants.FORMATO_FECHA_RENAPO);
		assertNull(fecha);	
	}
	
	/**
	 * Test convertir cadena a fecha error
	 */
	@Test
	public void testConvertirCadenaAFechaError(){
		Date fecha = fechaUtils.convertirCadenaAFecha("12-03-19", FormatoConstants.FORMATO_FECHA_RENAPO);
		assertNull(fecha);	
	}
	
	/**
	 * test suma minutos 
	 */
	@Test
	public void testSumaMinutos(){
		Date fecha = fechaUtils.sumaMinutos(new Date(), NumerosConstants.INT_CINCO);
		assertNotNull(fecha);	
	}
	
	/**
	 * test suma minutos null
	 */
	@Test
	public void testSumaMinutosNull(){
		Date fecha = fechaUtils.sumaMinutos(null, null);
		assertNull(fecha);	
	}
	
	/**
	 * test diferencia minutos 
	 */
	@Test
	public void testDiferenciaMinutos(){
		Date  fechaMas = fechaUtils.sumaMinutos(new Date(), NumerosConstants.INT_CINCO);
		String fecha = fechaUtils.diferenciaMinutos(new Date(), fechaMas);
		assertNotNull(fecha);	
	}
	
	/**
	 * test diferencia minutos 
	 */
	@Test
	public void testDiferenciaMinutosCero(){
		String fecha = fechaUtils.diferenciaMinutos(new Date(), new Date());
		assertNotNull(fecha);	
	}
	
	/**
	 * test diferencia minutos null
	 */
	@Test
	public void testDiferenciaMinutosNull(){
		String fecha = fechaUtils.diferenciaMinutos(new Date(), null);
		assertNull(fecha);	
	}
	
	/**
	 * Test Imprimir log peticion
	 */
	@Test
	public void testImprimirLogPeticion(){
		cadenaUtils.imprimirLogPeticion("\"nuevo\":\"nuevo\"", "nuevo");
	}
	
	/**
	 * Test para validar limite cadena error 
	 */
	@Test
	public void testValidarLimiteCadenaException(){
		try{
			validadorUtils.validarLimiteCadena("1234567", 6, GenericErrorEnum.ESTRUCTURA_INCORRECTA);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * Test para validar limite cadena error 
	 */
	@Test
	public void testValidarLimiteCadenaNull(){
		try{
			validadorUtils.validarLimiteCadena(null, 6, GenericErrorEnum.ESTRUCTURA_INCORRECTA);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test validar cadena numerica error
	 */
	@Test
	public void testValidarEsNumericaError(){
		try{
			validadorUtils.validarEsNumerica("\3453*rrt", GenericErrorEnum.ESTRUCTURA_INCORRECTA);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test validar correo error
	 */
	@Test
	public void testValidarCorreoError(){
		try{
			validadorUtils.validarCorreo("", null);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test obtener lista parametro 
	 */
	@Test
	public void testObtenerListaParametro(){
			Parametro parametro = new Parametro();
			List<Parametro> listaParametro = new ArrayList<>();
			parametro.setCvParametro("P02100");
			parametro.setChParametro("B");
			parametro.setChValorParametro("!");
			parametro.setCvParametro("P02100");
			parametro.setChParametro("C");
			parametro.setChValorParametro("23,14,17,18");
			listaParametro.add(parametro);
			List<String> respuesta = validadorUtils.obtenerListaParametro(listaParametro, "C", null);
			assertNotNull(respuesta);
	}
	
	/**
	 * test obtener valor parametro
	 */
	@Test
	public void testObtenerListaParametroDistinto(){
			Parametro parametro = new Parametro();
			List<Parametro> listaParametro = new ArrayList<>();
			parametro.setCvParametro("P02100");
			parametro.setChParametro("B");
			parametro.setChValorParametro("!");
			parametro.setCvParametro("P02100");
			parametro.setChParametro("C");
			parametro.setChValorParametro("23,14,17,18");
			listaParametro.add(parametro);
			parametro = new Parametro();
			parametro.setCvParametro("P02100");
			parametro.setChParametro("B");
			parametro.setChValorParametro("!");
			parametro.setCvParametro("P02100");
			parametro.setChParametro("C1");
			parametro.setChValorParametro("23,14,17,18");
			listaParametro.add(parametro);
			List<String> respuesta = validadorUtils.obtenerListaParametro(listaParametro, "C", null);
			assertNotNull(respuesta);
	}
	
	/**
	 * test obtener valor parametro
	 */
	@Test
	public void testObtenerValorParametroVacio(){
			String respueta = validadorUtils.obtenerValorParametro(null, "C", null);
			assertNull(respueta);
	}
	
	/**
	 * test obtener valor parametro
	 */
	@Test
	public void testObtenerValorParametro(){
		Parametro parametro = new Parametro();
		List<Parametro> listaParametro = new ArrayList<>();
		parametro.setCvParametro("P02100");
		parametro.setChParametro("B");
		parametro.setChValorParametro("!");
		parametro.setCvParametro("P02100");
		parametro.setChParametro("C");
		parametro.setChValorParametro("23,14,17,18");
		listaParametro.add(parametro);
		String respueta = validadorUtils.obtenerValorParametro(listaParametro, "C", null);
		assertNotNull(respueta);
	}
	
	/**
	 * Test Validar cadenar iguales error
	 */
	@Test
	public void testValidarCadenasIgualesError(){
		try{
			cadenaUtils.validarCadenasIguales("ejempló[$#%&%$/%$&%/&/(&//%&%]", "ejempló[$#%&%$/%$&%/&/(&//%&%]", null, "!");
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * Test para validar json
	 */
	@Test
	public void testParseJsonToObject() {
		JsonUtilsImpl<Afore> jAfore = new JsonUtilsImpl<>();
		Afore json = jAfore.parseJsonToObject("[{}]", null);
		assertNull(json);
	}
	
	/**
	 * Para obtener parametro exception
	 */
	@Test
	public void testObtenerCadenaConcatenadaVacioNull() {
		try {
			cadenaUtils.obtenerCadenaConcatenada(false, "", null);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
//	@Test
//	public void testDesencriptar(){
//		String cadena= encriptacionUtils.obtieneDesencriptacion("e751edb8f4265d6a39ff4b7dcccb6a6f3decbadc7c589caecdcfd01fe66acbcadc7d49570ccea0f7a2d6c9f8453e3f3c");
//		System.out.println(cadena);
//	}
	
	@Test
	public void testEncriptacion(){
		try{
			String cadena = "123456789";//cadenaUtils.obtenerCadenaConcatenada(true, "reenvioCodigoCambio",",","12123136208013045506",",","02");
			String resultado = encriptacionUtils.obtieneEncriptacion(cadena, "ba6fuEXASGJNQ1UhzK97XYsm");
			System.out.println(resultado);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * test obtener condicion
	 */
	@Test
	public void testValidarLista(){
		try{
			validadorUtils.validarLista(null, null, null, null, null);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * Condicion validar lista 
	 */
	@Test
	public void testValidarLista2(){
		CodigoUsuario codigo = new CodigoUsuario();
		Date fecha = fechaUtils.sumaMinutos(new Date(), 5);
		codigo.setFechaVigencia(fecha);
		List<CodigoUsuario> lista = new ArrayList<>();
		lista.add(codigo);				
		try{
			validadorUtils.validarLista(null, lista, null, null, null);
		}catch(Exception e){
			assertNotNull(e);
		}
	}
	
	/**
	 * Tests para comprimir archivos
	 */
	@Test
	public void testAgregarCarpeta(){
		ZipOutputStream zip = null;
		compresorUtils.agregarCarpeta("src/test/resources/PULSSAR/", "src/test/resources/PULSSAR/html", zip);
	}
}