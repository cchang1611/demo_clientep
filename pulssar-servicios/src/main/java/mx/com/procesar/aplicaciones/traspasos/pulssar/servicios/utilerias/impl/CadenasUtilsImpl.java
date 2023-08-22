package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Componente de utileria de validaciones valida datos nulos valida datos
 * obligatorios
 * 
 * @author dbarbosa
 * @version 1.0
 */
@Component
public class CadenasUtilsImpl implements CadenasUtils {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CadenasUtilsImpl.class);
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String conversionCaracteresAscii(String contrasenia) {
		try {
			return URLEncoder.encode(contrasenia, RegistroUsuarioConstants.UTF_8);
		} catch (UnsupportedEncodingException e) {
			logger.error(new StringBuilder().append("EncodeContrasenia . UnsupportedEncodingException ").append(e)
					.toString());
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerContenidoCadenaSinEspacios(String cadena, String valorAuxiliar) {
		String auxiliarCadena = valorAuxiliar;
		if(!utileriaValidador.validarVacio(cadena)) {
			auxiliarCadena = cadena.trim();
		}
		
		return auxiliarCadena;
	}
	
	/**
	 * Verificar la interface o clase que lo define
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils#obtenerContenidoCadenaSinEspacios(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String obtenerContenidoCadenaSinEspacios(String cadena, String valorAuxiliar,String valorDefault) {
		String nuevoValor = obtenerContenidoCadenaSinEspacios(cadena,valorAuxiliar);
		return obtenerContenidoCadenaSinEspacios(nuevoValor,valorDefault);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerCadenaConcatenada(boolean isVacio, String... cadenas) {
		StringBuilder concatenacion = new StringBuilder();
		for(int i = 0; i < cadenas.length; i++) {
			if(isVacio) {
				concatenacion.append(this.obtenerContenidoCadenaSinEspacios(cadenas[i], ExpresionesConstants.VACIO));
			} else {
				concatenacion.append(this.obtenerContenidoCadena(cadenas[i], ExpresionesConstants.VACIO));
			}
		}
		
		return concatenacion.toString();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarCadenasIguales(String cadenaEntrada, String cadenaBD, BusinessErrorEnum error, String homologado) {
		String cadena1 = depuraCadena(cadenaBD, homologado);
		String cadena2 = depuraCadena(cadenaEntrada, homologado);
		logger.info("cadena1... cadena2... homologado... {} {} {}", cadena1, cadena2, homologado);
		if (!cadena1.equals(cadena2)) {
			throw new BusinessException(error);
		}
	}
	
	/**
	 * Metodo encargado de depurar la cadena a comparar
	 * 
	 * @param cadena
	 * @return
	 */
	private String depuraCadena(String cadena, String homologado) {
		String regreso;
		if (!utileriaValidador.validarVacio(cadena)) {
			regreso = this.eliminaCaracteresEspeciales(cadena, homologado);
		} else {
			regreso = "";
		}
		return regreso;
	}

	/**
	 * Metodo que quita los acentos a las vocales.
	 * 
	 * @param cadena
	 * @return
	 */
	private String eliminaCaracteresEspeciales(String cadena, String homologado) {
		try {
			String cadenaRecuperada = this.eliminaEspacios(cadena);
			return this.eliminarAcentos(cadenaRecuperada, homologado);
		} catch (Exception e) {
			logger.error("error <<eliminaCaracteresEspeciales>> ", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}

	/**
	 * Metodo que elimina los espacios en blanco usando una Expresion regular
	 * 
	 * @param cadena
	 * @return String
	 */
	private String eliminaEspacios(String cadena) throws UnsupportedEncodingException {
		String caracter = URLDecoder.decode(cadena, AgenteConstants.UTF_8);
		Pattern p = Pattern.compile(ExpresionesConstants.EXPRESION_REGULAR_VACIO);
		String auxCadena = caracter.toUpperCase(Locale.getDefault());
		Matcher matcher = p.matcher(auxCadena);
		return matcher.replaceAll("");

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String eliminarAcentos(String entrada, String homologado) throws UnsupportedEncodingException {
		String salida = entrada;
		StringBuilder cadena = new StringBuilder();
		char[] caracterCodificar = salida.toCharArray();
		for (char c : caracterCodificar) {
			String caracter = URLEncoder.encode(String.valueOf(c), AgenteConstants.UTF_8);
			boolean caracterMatcher = this.validaCaracterEspecial(caracter);
			
			if (!String.valueOf(c).equals(caracter) || !caracterMatcher) {
				caracter = homologado;
			}
			cadena.append(caracter);
		}
		return cadena.toString();
	}

	/**
	 * metodo que valida caracteres especiales sin conversion de URLEncoder
	 * 
	 * @param cadena
	 * @return
	 */
	private boolean validaCaracterEspecial(String cadena) {
		Pattern patron = Pattern.compile(AgenteConstants.EXP_REGULAR_VALIDA_CARACTER);
		Matcher mat = patron.matcher(cadena);
		return mat.matches();
	}
	
	/**
	 * Valida si las cadenas son iguales
	 * 
	 * @param objJson
	 */
	@Override
	public void imprimirLogPeticion(Object objJson, String mensaje) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objJson);
			logger.info("PETICION: {} {}", mensaje, json);
		} catch(Exception e) {
			logger.error("Error al mapear la salida del objeto imprimirLogPeticion {}", e);
		}
	}
	
	/**
	 * Metodo encargado de obtener solo el valor de la cadena
	 * 
	 * @param cadena
	 * @param valorAuxiliar
	 * @return
	 */
	private String obtenerContenidoCadena(String cadena, String valorAuxiliar) {
		String auxiliarCadena = valorAuxiliar;
		if(!utileriaValidador.validarVacio(cadena)) {
			auxiliarCadena = cadena;
		}
		
		return auxiliarCadena;
	}
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils#armarAforeSucursalInvert(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String armarAforeSucursalInvert(String aforeSucursal, String afore, boolean flag) {
		String valor;
		if (flag) {
			valor = new StringBuilder().append(afore.trim()).append("-").append(aforeSucursal.trim()).toString();
		}else {
			String [] arrayDatos =aforeSucursal.split("-");
			valor = arrayDatos[1];
		}
			
		return valor;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String asignarValor(String value) {
		return value == null ? "" : value.replaceAll("[^\\dA-Za-z-ÿ\\u00f1\\u00d1\\s'('')']", "").trim();
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String eliminarCorchetes(String value) {
        String resultado = value;
        resultado = resultado.replace("[", "");
        resultado = resultado.replace("]", "");
        return resultado;
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.
	 * CadenasUtils#createURL(java.lang.String)
	 */
	@Override
	public URL createURL(String entrada) {
		try {
			return URI.create(entrada).toURL();
		} catch (MalformedURLException e) {
			logger.error("Error al crear la URL {}", e);
		}
		
		return null;
	}
}