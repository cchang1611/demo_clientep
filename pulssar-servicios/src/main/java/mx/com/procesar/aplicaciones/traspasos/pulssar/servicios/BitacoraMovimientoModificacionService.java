package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BitacoraMovimientoEntrada;

/**
 * Interface de bitacora movimiento
 * @author JMGUTIEG
 *
 */
public interface BitacoraMovimientoModificacionService {

	/**
	 * Metodo que guarda movimiento en modificacion
	 * @param entradaBitacora
	 */
	void guaradarMovimientoModificacion(BitacoraMovimientoEntrada entradaBitacora);

	/**
	 * Metodo que genera objeto bitacora modificacion
	 * @param cvProceso
	 * @param descripcion
	 * @param diagnostico
	 * @param flujo
	 * @param nss
	 * @param curp
	 * @param folioPadre
	 * @param folioHijo
	 * @param resultado
	 */
	void generaObjetoModificacion(String cvProceso, String descripcion, String diagnostico, String flujo, String nss,
			String curp, String folioPadre, String folioHijo, String resultado);

}
