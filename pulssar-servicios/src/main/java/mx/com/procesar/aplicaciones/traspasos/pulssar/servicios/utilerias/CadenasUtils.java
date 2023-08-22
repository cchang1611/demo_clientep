package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import java.io.UnsupportedEncodingException;
import java.net.URL;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;

/**
 * interfaz de la utileria de cadenas
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface CadenasUtils {
	
	/**
	 * metodo que convierte caracteres especiales en ascii
	 * 
	 * @param contrasenia
	 * @return
	 */
	public String conversionCaracteresAscii(String contrasenia);
	
	/**
	 * Metodo encargado de validar una cadena y devolver un valor en especifico
	 * 
	 * @param contrasenia
	 * @return
	 */
	public String obtenerContenidoCadenaSinEspacios(String cadena, String valorAuxiliar);
	
	/**
	 * Metodo encargado de validar una cadena y devolver un valor en especifico
	 * 
	 * @param contrasenia
	 * @return
	 */
	public String obtenerContenidoCadenaSinEspacios(String cadena, String valorAuxiliar,String valorDefault);
	
	/**
	 * Obtiene una cadena a partir de varios elementos
	 * 
	 * @param cadenas
	 * @return
	 */
	String obtenerCadenaConcatenada(boolean isVacio, String... cadenas);
	
	/**
	 * Valida si las cadenas son iguales
	 * 
	 * @param cadenaBD
	 * @param cadenaEntrada
	 * @param value
	 */
	void validarCadenasIguales(String cadenaEntrada, String cadenaBD, BusinessErrorEnum error, String homologado);
	
	/**
	 * Imprime el log de la peticion del servicio
	 * 
	 * @param objJson
	 * @param mensaje
	 */
	void imprimirLogPeticion(Object objJson, String mensaje);
	
	/**
	 * Utileria que arma y desarma la sucursal con la afore
	 * T-arma afore - sucursal
	 * F- desarma obtiene Sucursal
	 * @param aforeSucursal (Ejemplo: 111-00000 ó 00000)
	 * @param afore (Ejemplo: 111)
	 * @param flag (T ó F)
	 * @return
	 */
	String armarAforeSucursalInvert(String aforeSucursal, String afore, boolean flag);
	
	/**
	 * Valida null y remplaza por espacio 
	 * @param value
	 * @return
	 */
	String asignarValor(String value);

	/**
	 * Elimina los acentos de las palabras
	 * 
	 * @param entrada
	 * @return
	 */
	String eliminarAcentos(String entrada, String homologado) throws UnsupportedEncodingException;
	
	/**
	 * Elimina los corchetes de una cadena
	 * 
	 * @param value
	 * @return value
	 */
	String eliminarCorchetes(String value);
	
	/**
	 * Crear URL en base a Stirng
	 * 
	 * @param value
	 * @return
	 */
	URL createURL(String value);
	
}