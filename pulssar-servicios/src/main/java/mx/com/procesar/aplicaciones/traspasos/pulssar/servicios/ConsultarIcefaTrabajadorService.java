/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosIcefaTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TrabajadorSaldoSar92;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TrabajadorSaldoSarIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TrabajadorSar92;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TrabajadorSarIssste;

/**
 * Interfaz para Obtener Icefas del Trabajador
 * @author lvgonzal
 *
 */
public interface ConsultarIcefaTrabajadorService {
	
	
	
	/**
	 * Metodo encargado de obtener los datos del Trabajador SAR92
	 * @param nss
	 * @param rfc
	 * @param fechaNacimiento
	 * @return
	 */
	List<TrabajadorSar92> obtenerTrabajadorSar92(String nss, String rfc, String fechaNacimiento);
	
	
	/**
	 * Metodo encargado de obtener los datos del Trabajador SARISSSTE
	 * @param curp
	 * @param rfc
	 * @param fechaNacimiento
	 * @return
	 */
	List<TrabajadorSarIssste> obtenerTrabajadorSarIssste(String curp, String rfc, String fechaNacimiento);
	
	
	
	/**
	 * Metodo encargado de obtener los Datos de las Icefas del Trabajador
	 * @param nss
	 * @param curp
	 * @param rfc
	 * @param fechaNacimiento
	 * @return
	 */
	List<DatosIcefaTrabajador> obtenerIcefasTrabajador(String nss, String curp, String rfc, String fechaNacimiento);
	
	/**
	 * Metodo encargado de obtener los Datos de las Icefas del Trabajador Saldo SARES
	 * @param idProcesar
	 * @param fechaNacimiento
	 * @return
	 */
	List<DatosIcefaTrabajador> obtenerIcefasTrabajadorSaldoSares(Long idProcesar, String fechaNacimiento);
	
	/**
	 * Metodo encargado de obtener los datos del Trabajador Saldo SAR92
	 * @param idProcesar
	 * @param fechaNacimiento
	 * @return
	 */
	List<TrabajadorSaldoSar92> obtenerIcefasTrabajadorSaldoSar92(Long idProcesar, String fechaNacimiento);
		
	/**
	 * Metodo encargado de obtener los datos del Trabajador SARISSSTE
	 * @param idProcesar
	 * @param fechaNacimiento
	 * @return
	 */
	List<TrabajadorSaldoSarIssste> obtenerIcefasTrabajadorSaldoSarIssste(Long idProcesar, String fechaNacimiento);

}
