package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

/**
 * 
 * interfaz utileriaEncriptacion para encriptar informacion para link de activacion
 * @author esolanor
 * @version 1.0
 * @since
 */
public interface EncriptacionUtils {
	
	/**
	 *  metodo obtieneEncriptacion encripta el texto
	 *  
	 *  @param sinCifrar
	 *  @return
	 */
	String obtieneEncriptacion(String sinCifrar, String keyEncriptacion);
	
	/**
	 * metodo obtieneDesencriptacion desencripta el texto
	 * 
	 * @param cifrado
	 * @return
	 */
	String obtieneDesencriptacion(String cifrado, String keyEncriptacion);
}
