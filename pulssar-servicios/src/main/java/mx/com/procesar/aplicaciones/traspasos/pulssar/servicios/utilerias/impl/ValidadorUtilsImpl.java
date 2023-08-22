package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Componente de utileria de validaciones valida datos nulos valida datos
 * obligatorios
 * 
 * @author dbarbosa
 * @version 1.0
 */
@Component
public class ValidadorUtilsImpl implements ValidadorUtils {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ValidadorUtilsImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarObjetosObligatorios(List<Object> parametro) {
		for (Object objeto : parametro) {
			if (this.validarObjetoNulo(objeto)) {
				throw new GenericException(GenericErrorEnum.PARAMETRO_NULO);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validarObjetoNulo(Object objeto) {
		return objeto == null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validarVacio(String cadena) {
		return this.validarObjetoNulo(cadena) || cadena.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validarListaVacia(List<?> lstObjeto) {
		return this.validarObjetoNulo(lstObjeto) || lstObjeto.isEmpty() || lstObjeto.size() < NumerosConstants.INT_UNO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarLimiteCadena(String cadena, Integer limite, GenericErrorEnum error) {
		if (this.validarVacio(cadena) || limite.intValue() < cadena.length()) {
			throw new GenericException(error);
		}
	}

	@Override
	public boolean validarEsNumerica(String cadena, GenericErrorEnum error) {
		Pattern p = Pattern.compile(ExpresionesConstants.EXPRESION_NUMEROS);
		Matcher matcher = p.matcher(cadena);
		boolean isNumber = true;
		if (!matcher.find()) {
			isNumber = false;
			if(!this.validarObjetoNulo(error)) {
				throw new GenericException(error);
			}
		}
		return isNumber;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarCorreo(String correo, GenericErrorEnum error) {
		Pattern p = Pattern.compile(ExpresionesConstants.EXPRESION_CORREO_ELECTRONICO);
		Matcher matcher = p.matcher(correo);

		if (!matcher.find()) {
			throw new GenericException(error);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarLista(UsuarioPulssar usuarios, List<CodigoUsuario> codigo, String cadena, String valor, BusinessErrorEnum error) {
		Date fechaHoy = new Date();
		if(!this.validarObjetoNulo(usuarios) && this.validarListaVacia(codigo)) {
			logger.info("El {} {} se encuentra registrado.", cadena, valor);
			throw new BusinessException(error);
		}
		if(!this.validarListaVacia(codigo)) {
			CodigoUsuario codUsuario = codigo.get(NumerosConstants.INT_CERO);
			if(NumerosConstants.INT_CERO == codUsuario.getEstatus() && fechaHoy.before(codUsuario.getFechaVigencia())) {
				logger.info("Error al registrar tiene un codigo de activacion vigente");
				throw new BusinessException(BusinessErrorEnum.FECHA_CODIGO_VIGENTE);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> obtenerListaParametro(List<Parametro> listaParametro, String chParametro, List<String> valor) {
		List<String> auxValor = valor;
		if(!this.validarListaVacia(listaParametro)) {
			for(Parametro parametro : listaParametro) {
				if(chParametro.equals(parametro.getChParametro())) {
					String valorParametro = parametro.getChValorParametro();
					String[] arreglo = valorParametro.split(AgenteConstants.COMA);
					auxValor = Arrays.asList(arreglo);
				}
			}
		}
		return auxValor;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerValorParametro(List<Parametro> listaParametro, String chParametro, String valor) {
		String auxValor = valor;
		if(!this.validarListaVacia(listaParametro)) {
			for(Parametro parametro : listaParametro) {
				if(this.validarObjetoNulo(chParametro)) {
					auxValor = parametro.getChValorParametro();
				} else if(chParametro.equals(parametro.getChParametro())) {
					auxValor = parametro.getChValorParametro();
				}
			}
		}
		return auxValor;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> obtenerListaChParametro(List<Parametro> listaParametro, String chValorParametro, List<String> valor) {
		List<String> auxValor = valor;
		if(!this.validarListaVacia(listaParametro)) {
			auxValor = new ArrayList<>();
			for(Parametro parametro : listaParametro) {
				if(chValorParametro.equals(parametro.getChValorParametro())) {
					String valorParametro = parametro.getChParametro();
					auxValor.add(valorParametro);
				}
			}
		}
		return auxValor;
	}
	
	
	/*
	 * (non-Javadoc) Expedido por la intefaz
	 * Oct 31, 2019
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils#isEmpty(java.lang.Object)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean isEmpty(Object value) {

		boolean isEmpty = value == null;
		if (!isEmpty) {
			if (value.getClass().isArray()) {
				isEmpty = validaListaVacia(value);
			} else if (value instanceof String) {
				String string = (String) value;
				isEmpty = string.trim().isEmpty();
			} else if (value instanceof Number) {
				Number number = (Number) value;
				isEmpty = number.equals(0);
			} else if (value instanceof Date) {
				Date dates = (Date) value;
				isEmpty = dates.toString().isEmpty();
			} else if (value instanceof Collection<?>) {
				Collection<?> collection = (Collection<?>) value;
				isEmpty = collection.isEmpty();
			} else if (value instanceof Map) {
				isEmpty = ((Map) value).isEmpty();
			}
		}

		return isEmpty;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarFormato(String valor, String formato, String diagnostico) throws BusinessException {
		logger.info("validando dato {} formato {}", valor, formato);
		if(!valor.matches(formato)){
			throw new BusinessException(diagnostico);
		}
	}

	/**
	 * valida si el arreglo es vacio o nulo
	 * 
	 * @param Object 
	 * @return boolean
	 */
	private static boolean validaListaVacia(Object value) {

		boolean isEmpty = true;
		if (value instanceof byte[]) {
			byte[] bytes = (byte[]) value;
			isEmpty = bytes.length == 0;
		} else if (value instanceof char[]) {
			char[] chars = (char[]) value;
			isEmpty = chars.length == 0;
		} else if (value instanceof boolean[]) {
			boolean[] booleans = (boolean[]) value;
			isEmpty = booleans.length == 0;
		} else if (value instanceof short[]) {
			short[] shorts = (short[]) value;
			isEmpty = shorts.length == 0;
		} else if (value instanceof int[]) {
			int[] ints = (int[]) value;
			isEmpty = ints.length == 0;
		} else if (value instanceof long[]) {
			long[] longs = (long[]) value;
			isEmpty = longs.length == 0;
		} else if (value instanceof float[]) {
			float[] floats = (float[]) value;
			isEmpty = floats.length == 0;
		} else if (value instanceof double[]) {
			double[] doubles = (double[]) value;
			isEmpty = doubles.length == 0;
		} else if (value instanceof Object[]) {
			Object[] array = (Object[]) value;
			isEmpty = array.length == 0;
		}

		return isEmpty;
	}
}