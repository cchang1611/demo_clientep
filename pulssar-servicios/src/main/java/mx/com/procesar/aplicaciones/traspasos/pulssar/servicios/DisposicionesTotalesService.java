package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;

public interface DisposicionesTotalesService {

	/**
	 *  validarMarcaOperativa
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param procesar
	 * @param datosExpediente 
	 *  @return
	 */

	boolean validarMarcaOperativa(Long procesar, DatosExpediente datosExpediente,List<String> claves);

	
	/**
	 *  validarMarcaOperativa por separado
	 *  @param procesar
	 * 	@param datosExpediente 
	 *  @return
	 */

	boolean validarMarcaOperativaExpediente(Long procesar, DatosExpediente datosExpediente,List<String> claves);
}
