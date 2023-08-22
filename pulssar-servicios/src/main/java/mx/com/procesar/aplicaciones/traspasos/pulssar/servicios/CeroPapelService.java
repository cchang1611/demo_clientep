package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCeroPapel;


/**
 * Interface de cero papel
 * @author RARREOLA
 *
 */
public interface CeroPapelService {
	
	
	/**
	 * Guardar datos de cero papel
	 * @param principalCeroPapel
	 */
	Long guardarDatosCeroPapel(EntradaCeroPapel entradaCeroPapel);
	
	
	
	/**
	 * Consulta estatus cero
	 * @param idProcesar
	 * @return
	 */
	CeroPapel consultaEstatusCeroPapel(Long idProcesar);
	
	
}
