/**
 * EnumConverter.java
 * Fecha de creaci�n: 16/12/2015, 17:51:38
 *
 * Copyright (c) 2015 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
//package mx.com.procesar.aplicaciones.traspasos.pulssar.convertidores;
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.convertidores;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.AttributeConverter;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.convertidores.excepciones.ConvertidorEnumException;


/**
 * Convertidor Generico de Enumeraciones
 * @author Rodolfo Damian Rojas Rodriguez (rdrojas@inet.procesar.com.mx)
 * @version 1.0
 * @param <E>
 */
public abstract class EnumConverter<E extends Enum<E>> implements AttributeConverter<E, Object> {

	/**
	 * Nombre de metodo Values
	 */
	private static final String METHOD_VALUES = "values";
	/**
	 * Nombre de metodo getClave
	 */
	private static final String METHOD_GETCLAVE = "getClave";
	/**
	 * Clase Enum
	 */
	private Class<E> enumClass;
	
	/**
	 *  Constructor por Clase Enum como parametro
	 *  @author Rodolfo Damian Rojas Rodriguez (rdrojas@inet.procesar.com.mx)
	 *  @param enumClass
	 */
	public EnumConverter(Class<E> enumClass) {
		this.enumClass = enumClass;
	}

	/* La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn
	 */
	@Override
	public Object convertToDatabaseColumn(E eEnum) {
		Object valor = null;
		Class<?>[] noparams = {};
		Method dms;
		
		if(eEnum != null) {
			
			try {
				dms = enumClass.getMethod(METHOD_GETCLAVE, noparams);
				valor = dms.invoke(eEnum, new Object[0]);
			} catch(NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new ConvertidorEnumException("Error al convertir Enumeracion a Objeto", e);
			}
			
		}
		
		return valor;
	}
	
	/* La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToEntityAttribute
	 */
	@Override
	public E convertToEntityAttribute(Object dbValue) {
		E eEnum = null;
		Class<?>[] noparams = {};
		Method method;
		
		if(dbValue != null) {
			try {
				method = enumClass.getMethod(METHOD_VALUES, noparams);
				Object[] enums = (Object[]) method.invoke(enumClass, new Object[0]);
				
				eEnum = obtenerEnumeracion(dbValue, noparams, enums);
			} catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new ConvertidorEnumException("Error al convertir Objeto a Enumeracion", e);
			}
		}
		
		return eEnum;
	}

	/**
	 *  Metodo que obtiene la enumeracion requerida
	 *  Rodolfo Damian Rojas Rodriguez (rdrojas@inet.procesar.com)
	 *  @param dbValue
	 *  @param noparams
	 *  @param enums
	 *  @return
	 *  @throws NoSuchMethodException
	 *  @throws IllegalAccessException
	 *  @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	private E obtenerEnumeracion(Object dbValue, Class<?>[] noparams, Object[] enums)
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		E eEnum = null;
		Method method;
		Object clave;
		
		for (Object value : enums) {
			method = value.getClass().getMethod(METHOD_GETCLAVE, noparams);
			clave = method.invoke(value, new Object[0]);
			
			if (clave.toString().equals(dbValue.toString())) {
				eEnum = (E) value;
				break;
			}
		}
		
		return eEnum;
	}
}