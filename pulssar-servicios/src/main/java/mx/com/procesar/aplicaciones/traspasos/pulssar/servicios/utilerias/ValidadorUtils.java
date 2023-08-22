package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CodigoUsuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;

/**
 * interfaz de la utileria de validaciones: valida datos nulos valida datos
 * obligatorios valida la estructura de datos de entrada
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface ValidadorUtils {

	/**
	 * Metodo encargado de validar si los objetos no se encuentran nulos
	 * 
	 * @param parametros
	 */
	void validarObjetosObligatorios(List<Object> parametros);

	/**
	 * Validador de objeto nulo
	 * 
	 * @param objeto
	 * @return
	 */
	boolean validarObjetoNulo(Object objeto);

	/**
	 * Metodo encargado de validar si una cadena es vacia
	 * 
	 * @param cadena
	 * @return
	 */
	boolean validarVacio(String cadena);

	/**
	 * Metodo encargado de validar si una lista esta vacia
	 * 
	 * @param listObjeto
	 * @return
	 */
	boolean validarListaVacia(List<?> listObjeto);

	/**
	 * Metodo que valida el tamanio de una cadena
	 * 
	 * @param cadena
	 * @param limite
	 * @param error
	 */
	public void validarLimiteCadena(String cadena, Integer limite, GenericErrorEnum error);

	/**
	 * Metodo que valida si una cadena contiene solo numeros
	 * 
	 * @param cadena
	 * @param error
	 */
	public boolean validarEsNumerica(String cadena, GenericErrorEnum error);

	/**
	 * Metodo que valida si una cadena tiene el formato de correo electronico
	 * 
	 * @param correo
	 * @param error
	 */
	public void validarCorreo(String correo, GenericErrorEnum error);
	
	/**
	 * Realiza la validacion de la lista y manda el mensaje u error correspondiente
	 * 
	 * @param usuarios
	 * @param cadena
	 * @param valor
	 * @param error
	 */
	void validarLista(UsuarioPulssar usuarios,List<CodigoUsuario> codigo, String cadena, String valor, BusinessErrorEnum error);
	
	/**
	 * Tranformar consulta de la base de datos a lista de strings 
	 * @param listaParametro
	 * @param chParametro
	 * @param valor
	 * @return
	 */
	 List<String> obtenerListaParametro(List<Parametro> listaParametro, String chParametro, List<String> valor);
	 
	 
	 /**
	  * obtener valor parametrod esde lista
	  * @param listaParametro
	  * @param chParametro
	  * @param valor
	  * @return
	  */
	 String obtenerValorParametro(List<Parametro> listaParametro, String chParametro, String valor);
	 
	 /**
	  * Obtiene el valor de chparametro
	  * 
	  * @param listaParametro
	  * @param chValorParametro
	  * @param valor
	  * @return
	  */
	 List<String> obtenerListaChParametro(List<Parametro> listaParametro, String chValorParametro, List<String> valor);

	 /**
	  * valida si el objeto esta vacio o nulo
	  * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	  * Oct 31, 2019
	  * @param value
	  * @return
	  */
	boolean isEmpty(Object value);
	
	/**
	 * Metodo encargado de validar el formato de una cadena
	 * 
	 * @param valor
	 * @param formato
	 * @param diagnostico
	 * @throws BusinessException
	 */
	void validarFormato(String valor, String formato, String diagnostico) throws BusinessException;
}