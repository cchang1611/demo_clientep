package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Metodo de parseo de objetos a Json y visceversa
 * 
 * @author cmejia 08-10-2015
 * 
 */
public interface JsonUtils {

	/**
	 * convierte ena cadena JSON a objeto de la clase T
	 * @param json
	 * @param typeParamClass
	 * @return
	 */
	<T> T parseJsonToObject(String json, Class<T> typeParamClass);
	
	/**
	 * convierte un alista de objetos a su correspondiente cadena JSON
	 * @param objs
	 * @return
	 * @throws JsonProcessingException 
	 */
	<T> String parseListObjectToJson(List<T> objs);

	/**
	 * 
	 * Este metodo parsea un objeto a un String con formato JSON
	 * 
	 * @param obj el objeto que se quiere parsear a formato JSON
	 * @return un String con formato JSON del objeto parseado
	 * @throws JsonProcessingException 
	 */
	<T> String parseObjectToJson(T obj);
	
	/**
	 * 
	 * Este metodo parsea un objeto a un String con formato JSON
	 * 
	 * @param obj el objeto que se quiere parsear a formato JSON
	 * @return un String con formato JSON del objeto parseado
	 * @throws JsonProcessingException 
	 */
	<T> String parseObjectToJsonSC(T obj);
	
	/**
	 * Conviente una cadena json de arreglo a una lista del objeto de la clase T
	 *  
	 * @param json
	 * @param typeClass
	 * @return
	 */
	<T> List<T> parseJsonToObjectList(String json, Class<T> typeClass);

	/**
	 * Metodo para tranformar una lista de objetos en una lista Pojo
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Oct 31, 2019
	 * @param Lista objetos
	 * @param tipo de clase
	 * @return lista del tipo de clase
	 * @throws JsonProcessingException 
	 */
	<T> List<T> parseListObjectToListPojo(List<T> lstObjs, Class<T> typeClass);
	
	/**
	 * convierte objeto a xml
	 * @param obj
	 * @return
	 */
	<T> String convertirObjetoAXml(T obj);
}