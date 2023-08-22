package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.utilerias;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.turnos.test.service.BaseTestCase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Metodo de parseo de objetos a Json y visceversa
 * 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { 
		PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, 
		PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class JsonUtilTestCase extends BaseTestCase{

	/**
	 * utileria
	 */
	@Autowired
	private JsonUtilsImpl<DatosUsuario> jsonUtil = new JsonUtilsImpl<>();


	/**
	 * test para convertir objeto a json
	 */
	@Test
	public void testConvertirObjetoJsonSC() {
		DatosUsuario datos = obtenerDatosUsuario();

		String jsonResultado = jsonUtil.parseObjectToJsonSC(datos);
		assertNotNull(jsonResultado);
	}

	/**
	 * test para convertir objeto a json vacio
	 */
	@Test
	public void testConvertirObjetoJsonSC_Vacio() {

		DatosUsuario dto = new DatosUsuario();
		String jsonResultado = jsonUtil.parseObjectToJsonSC(dto);
		assertNotNull(jsonResultado);
	}

	/**
	 *  test para convertir objeto a json nulo
	 */
	@Test
	public void testConvertirObjetoJsonSC_Null() {
		String jsonResultado = jsonUtil.parseObjectToJsonSC(null);
		assertTrue(jsonResultado.equals("null"));
	}

	/**
	 * test para convertir objeto a json
	 */
	@Test
	public void testConvertirObjetoJson() {
		DatosUsuario datos = obtenerDatosUsuario();

		String jsonResultado = jsonUtil.parseObjectToJson(datos);
		assertNotNull(jsonResultado);
	}

	/**
	 * test para convertir objeto a json vacio
	 */
	@Test
	public void testConvertirObjetoJson_Vacio() {

		DatosUsuario dto = new DatosUsuario();
		String jsonResultado = jsonUtil.parseObjectToJson(dto);
		assertNotNull(jsonResultado);
	}

	/**
	 *  test para convertir objeto a json nulo
	 */
	@Test
	public void testConvertirObjetoJson_Null() {
		String jsonResultado = jsonUtil.parseObjectToJson(null);
		assertTrue(jsonResultado.equals("[null]"));
	}

	/**
	 * test para convertir json a objeto
	 */
	@Test
	public void testConvertirJsonObjeto() {

		DatosUsuario datos = obtenerDatosUsuario();
		String jsonResultado = jsonUtil.parseObjectToJson(datos);

		DatosUsuario dto2 = jsonUtil.parseJsonToObject(jsonResultado, DatosUsuario.class);
		assertNotNull(dto2);

	}

	/**
	 * JsonToObject NullPointer
	 */
	@Test
	public void testConvertirJsonObjeto_Null() {
		try {
			DatosUsuario datos = jsonUtil.parseJsonToObject(null, DatosUsuario.class);
			assertNull(datos);
		} catch (NullPointerException ex) {
			assertNotNull(ex);
		}
	}

	/**
	 * JsonToObject vacio
	 */
	@Test
	public void testConvertirJsonObjeto_Vacio() {
		try {
			jsonUtil.parseJsonToObject("", DatosUsuario.class);
		} catch (NullPointerException ex) {
			assertNotNull(ex);
		}
	}

	/**
	 * test para convertir lista de objeto a json 
	 */
	@Test
	public void testConvertirListaObjetosJson() {
		List<DatosUsuario> dtoList = obtenerListaDatosUsuario();

		String jsonResultado = jsonUtil.parseListObjectToJson(dtoList);
		assertNotNull(jsonResultado);
	}

	/**
	 * test para convertir lista de objeto a json vacia
	 */
	@Test
	public void testConvertirListaObjetosJson_vacia() {

		List<DatosUsuario> dtoList = new ArrayList<DatosUsuario>();
		DatosUsuario dto1 = new DatosUsuario();
		dtoList.add(dto1);
		String jsonResultado = jsonUtil.parseListObjectToJson(dtoList);
		assertNotNull(jsonResultado);
	}

	/**
	 * test para convertir lista de objeto a json nula
	 */
	@Test
	public void testConvertirListaObjetosJson_Nulo() {

		try {
			jsonUtil.parseListObjectToJson(null);
		} catch (NullPointerException ex) {
			assertNotNull(ex);
		}
	}

	/**
	 * test para convertir json a lista de objetos
	 */
	@Test
	public void testconvertirJsonListaObjetos(){
		List<DatosUsuario> dtoList = obtenerListaDatosUsuario();

		String jsonResultado = jsonUtil.parseListObjectToJson(dtoList);

		List<DatosUsuario> lista =  jsonUtil.parseJsonToObjectList(jsonResultado, DatosUsuario.class);
		assertNotNull(lista);
	}

	/**
	 * test para convertir json a lista de objetos nulo
	 */
	@Test
	public void testconvertirJsonListaObjetos_Null(){
		try {
			List<DatosUsuario> lista =  jsonUtil.parseJsonToObjectList(null, DatosUsuario.class);
			assertNotNull(lista);
		} catch (NullPointerException ex) {
			assertNotNull(ex);
		}
	}
	
	/**
	 * Metodo para obtener los datos usuario
	 */
	public DatosUsuario obtenerDatosUsuario(){
		DatosUsuario datos = new DatosUsuario();
		datos.setNickUsuario("124235234");
		datos.setNumeroAgente("1602075345");
		datos.setNombre("Miguel");
		datos.setApellidoPaterno("Hernandez");
		datos.setApellidoMaterno("Rodriguez");
		datos.setCelular("1324567890");
		datos.setCorreo("ejemplo@gmail.com");
		datos.setClaveAfore("556");
		return datos;
	}

	/**
	 * Metodo para obtener los datos usuario
	 */
	public List<DatosUsuario> obtenerListaDatosUsuario(){

		List<DatosUsuario> dtoList = new ArrayList<DatosUsuario>();

		DatosUsuario dto1 = new DatosUsuario();
		dto1.setNickUsuario("124235234");
		dto1.setNumeroAgente("1602075345");
		dto1.setNombre("Miguel");
		dto1.setApellidoPaterno("Hernandez");
		dto1.setApellidoMaterno("Rodriguez");
		dto1.setCelular("1324567890");
		dto1.setCorreo("ejemplo@gmail.com");
		dto1.setClaveAfore("556");
		dtoList.add(dto1);

		DatosUsuario dto2 = new DatosUsuario();
		dto2.setNickUsuario("124235234");
		dto2.setNumeroAgente("1602075345");
		dto2.setNombre("Miguel");
		dto2.setApellidoPaterno("Hernandez");
		dto2.setApellidoMaterno("Rodriguez");
		dto2.setCelular("1324567890");
		dto2.setCorreo("ejemplo@gmail.com");
		dto2.setClaveAfore("556");
		dtoList.add(dto2);

		DatosUsuario dto3 = new DatosUsuario();
		dto3.setNickUsuario("124235234");
		dto3.setNumeroAgente("1602075345");
		dto3.setNombre("Miguel");
		dto3.setApellidoPaterno("Hernandez");
		dto3.setApellidoMaterno("Rodriguez");
		dto3.setCelular("1324567890");
		dto3.setCorreo("ejemplo@gmail.com");
		dto3.setClaveAfore("556");
		dtoList.add(dto3);

		return dtoList;

	}


}
