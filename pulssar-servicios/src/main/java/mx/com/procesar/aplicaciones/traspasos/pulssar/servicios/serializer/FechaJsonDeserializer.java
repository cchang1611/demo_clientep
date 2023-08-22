/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;

/**
 * deserializa una cadena de localdate de java 8 [2020, 05, 03, 12, 20, 20] [2020, 05, 03] a fecha
 * @author jcgarces
 *
 */
public class FechaJsonDeserializer<T> extends JsonDeserializer<T> {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(FechaJsonDeserializer.class);
	
	/*
	 * (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		logger.info("Serializar {}, {}", p, ctxt);
		ObjectCodec oc = p.getCodec();
		JsonNode nodo = oc.readTree(p);
		List<Integer> valores = new ArrayList<>(); 
		Iterator<?> it = nodo.iterator();
		while (it.hasNext()) {
			IntNode in = (IntNode)it.next();
			valores.add(in.asInt());
		}
		int i = 0;
		GregorianCalendar gc = new GregorianCalendar();
		if(valores.size() == 6) {
			// fecha y hora
			gc = new GregorianCalendar(valores.get(i++), valores.get(i++), valores.get(i++), valores.get(i++), valores.get(i++), valores.get(i++));
			logger.info("deserialize valor variable auxiliar i {}", i);
		} else if(valores.size() == 3) {
			// solo fecha
			gc = new GregorianCalendar(valores.get(i++), valores.get(i++), valores.get(i++));
			logger.info("deserialize valor variable auxiliar i {}", i);
		}
		return (T)gc.getTime();
	}

}
