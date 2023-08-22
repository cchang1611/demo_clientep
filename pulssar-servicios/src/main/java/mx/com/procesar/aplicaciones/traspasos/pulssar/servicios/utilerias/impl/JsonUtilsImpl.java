/**
 * Esta utilidad permite realizar operaciones de parseo entre entidades JSON y
 * clases java
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JsonUtils;

/**
 * Metodo de parseo de objetos a Json y visceversa
 * 
 * @author cmejia 08-10-2015
 * 
 */
@Component("jsonUtil")
public class JsonUtilsImpl<T> implements JsonUtils {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(JsonUtilsImpl.class);
	
	/**
	 * constante para log
	 */
	private static final String ERROR = "Ocurrio un error al procesar : ";
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.servicios.biometricos.biometricos4h.utilerias.JsonUtil#parseObjectToJson(java.lang.Object)
	 */
	@Override
	public <T> String parseObjectToJsonSC(T obj) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter();
		String json = null;
		try {
			json = mapper.writeValueAsString(obj);
			StringBuilder cadenaJson = new StringBuilder();
			cadenaJson.append(json);
			json =  cadenaJson.toString();
		} catch (JsonProcessingException jsonEx) {
			logger.error("Ocurrio un error al crear el json del objeto parseObjectToJsonSC", jsonEx);
		}
		return json;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.servicios.biometricos.biometricos4h.utilerias.JsonUtil#parseObjectToJson(java.lang.Object)
	 */
	@Override
	public <T> String parseObjectToJson(T obj) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter();
		String json = null;
		try {
			json = mapper.writeValueAsString(obj);
			StringBuilder cadenaJson = new StringBuilder();
			cadenaJson.append("[");
			cadenaJson.append(json);
			cadenaJson.append("]");
			json =  cadenaJson.toString();
		} catch (JsonProcessingException jsonEx) {
			logger.error("Ocurrio un error al crear el json del objeto parseObjectToJson", jsonEx);
		}
		return json;
	}

	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.servicios.biometricos.biometricos4h.utilerias.JsonUtil#parseJsonToObject(java.lang.String, java.lang.Class)
	 */
	@Override
	public <T> T parseJsonToObject(String json, Class<T> typeParamClass) {
		String jsonLocal = removeArray(json);
		ObjectMapper mapper = new ObjectMapper();
		T obj = null;
		try {
			obj = mapper.readValue(jsonLocal.getBytes(), typeParamClass);
		} catch (Exception ex) {
			logger.info("Ocurrio un error al : ", ex);
		}
		return obj;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> List<T> parseJsonToObjectList(String json, Class<T> typeClass) {
		ObjectMapper mapper = new ObjectMapper();
		List<T> regreso = null;
		
		try {
			JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, typeClass);
			regreso =  mapper.readValue(json.getBytes(Charset.forName(CharEncoding.UTF_8)), type);
		} catch (IOException e) {
		logger.info("Ocurrio un error al convertir json: ", e);
		}
		return regreso;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.servicios.biometricos.biometricos4h.utilerias.JsonUtil#parseListObjectToJson(java.util.List)
	 */

	@Override
	public <T> String parseListObjectToJson(List<T> objs) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter();
		String json = "";
		try {			
			if(objs != null && !objs.isEmpty()){
				for (T t : objs) {
					json += mapper.writeValueAsString(t).concat(",");
				}
			}

		} catch (JsonProcessingException jsonEx) {
			logger.error("Ocurrio un error al crear el json del objeto parseListObjectToJson", jsonEx);
		}
		json = "[" + json + "]";
		json = StringUtils.replace(json, "},]", "}]");

		return json;
	}
	
	/**
	 * elimina arreglo
	 * @param value
	 * @return
	 */
	private String removeArray(String value) {

		String res = "";
		if (value != null && !value.trim().isEmpty()) {
			for (int i = 0; i < value.trim().length(); i++) {
				if (!(value.charAt(i) == '[' && i == 0) && !(value.charAt(i) == ']' && i == value.trim().length() - 1)) {
					res = res + value.charAt(i);
				}
			}
		}
		return res;
	}

	/*
	 * (non-Javadoc) Expedido por la intefaz
	 * Oct 31, 2019
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JsonUtils#parseListObjectToListPojo(java.util.List, java.lang.Class)
	 */
	@Override
	public <T> List<T> parseListObjectToListPojo(List<T> lstObjs, Class<T> typeClass) {
		String json = parseListObjectToJson(lstObjs);
		logger.info("El json convertir: {}",json);
		return parseJsonToObjectList(json, typeClass);
	}
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.servicios.traspasos.portalservicios.utilerias.JsonUtil#parseObjectToXml(java.lang.Object)
	 */
	@Override
	public <T> String convertirObjetoAXml(T obj) {
		ObjectMapper objectMapper = new XmlMapper();
		String regreso = null;
		try {
			regreso =  objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.info(ERROR, e);
		}
		return regreso;
	}
}
