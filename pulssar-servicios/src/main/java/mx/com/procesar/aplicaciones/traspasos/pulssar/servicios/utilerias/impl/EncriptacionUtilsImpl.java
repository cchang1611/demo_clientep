package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.UsuarioErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.EncriptacionUtils;



/**
 * Implementacion de la utileria para la encriptacion
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
@Component("encriptacionUtils")
public class EncriptacionUtilsImpl implements EncriptacionUtils {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(EncriptacionUtilsImpl.class);
	
	/**
	 * Generacion de encriptacion
	 */
	private static final String ENCRIPTACION ="AES/ECB/PKCS5Padding";
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String obtieneEncriptacion(String sinCifrar, String keyEncriptacion) {
    	logger.info(new StringBuilder()
    			.append("Cadena sin cifrar {} ")
    			.append(sinCifrar).toString());
    	try {
			final byte[] bytes = sinCifrar.getBytes(ActivacionConstants.UTF_8);
			final Cipher aes = obtieneCipher(true, keyEncriptacion);
			final byte[] cifrado = aes.doFinal(bytes);
			return this.HexToString(cifrado);
    	} catch (Exception e) {
			logger.error(new StringBuilder().append("\nError al momento de realizar la encriptacion ").append(e).toString());
    		throw new GenericException(UsuarioErrorEnum.EXCEPTION_GENERICA.toString());
    	}
	}
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String obtieneDesencriptacion(String cifrado, String keyEncriptacion) {
    	logger.info(new StringBuilder()
    			.append("Cadena cifrada {}")
    			.append(cifrado).toString());
    	try {
			final Cipher aes = obtieneCipher(false, keyEncriptacion);
			final byte[] bytes = aes.doFinal(StringToHex(cifrado));
			return new String(bytes, ActivacionConstants.UTF_8);
    	} catch (Exception e) {
    		logger.error(new StringBuilder().append("Error al momento de realizar la desencriptacion").append(e).toString());
    		throw new GenericException(UsuarioErrorEnum.EXCEPTION_GENERICA.toString());
    	}
	}
    
    /**
     * Metodo encargado de cifrar
     * 
     * @param paraCifrar
     * @return
     * @throws Exception
     */
    public Cipher obtieneCipher(boolean encriptacion, String keyEncriptacion) throws Exception {
    	final MessageDigest digest = MessageDigest.getInstance(ActivacionConstants.SHA);
    	digest.update(keyEncriptacion.getBytes(ActivacionConstants.UTF_8));
    	final SecretKeySpec key = new SecretKeySpec(digest.digest(), ActivacionConstants.CERO, ActivacionConstants.DIECISEIS, ActivacionConstants.AES);

    	final Cipher aes = Cipher.getInstance(ENCRIPTACION);
    	if(encriptacion) {
    		aes.init(Cipher.ENCRYPT_MODE, key);
    	} else {
    		aes.init(Cipher.DECRYPT_MODE, key);
    	}
    	return aes;
    }
	
    /**
     * Metodo encargado convertir a un cadena el arreglo encriptado
     * 
     * @param paraCifrar
     * @return
     * @throws Exception
     */
	public String HexToString(byte[] arregloEncriptado) {
		StringBuilder textoEncriptado = new StringBuilder();
		for (int i = ActivacionConstants.CERO; i < arregloEncriptado.length; i++) {
			int aux = arregloEncriptado[i] & 0xff;
			if (aux < ActivacionConstants.DIECISEIS) {
				textoEncriptado.append(ActivacionConstants.CERO_ST);
			}
			textoEncriptado.append(Integer.toHexString(aux));
		}
		return textoEncriptado.toString();
	}
	
	/**
	 * Metodo encargado convertir a un arreglo la cadena encriptada 
	 * 
	 * @param encriptado
	 * @return
	 */
	private static byte[] StringToHex(String encriptado) {
		byte[] valorEncriptacion = new byte[encriptado.length() / ActivacionConstants.DOS];
		for (int i = 0; i < valorEncriptacion.length; i++) {
				int inicio = i * ActivacionConstants.DOS;
				String aux = encriptado.substring(inicio, inicio + ActivacionConstants.DOS);
				int v = Integer.parseInt(aux, ActivacionConstants.DIECISEIS);
				valorEncriptacion[i] = (byte) v;
		}
		return valorEncriptacion;
	}
}
