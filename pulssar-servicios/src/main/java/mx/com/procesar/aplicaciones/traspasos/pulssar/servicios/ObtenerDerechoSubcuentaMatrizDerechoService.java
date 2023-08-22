package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCalculosMontos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Marca;

/**
 * Interfaz ObtenerDerechoSubcuentaMatrizDerecho
 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 2, 2021
 */
public interface ObtenerDerechoSubcuentaMatrizDerechoService {
 
	/**
	 *  Metodo para obtenerDerechoSubcuenta
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param idMatrizDerecho
	 *  @return
	 */
	List<DerechoSubcuenta> obtenerDerechoSubcuentaPorIdMatrizDerecho(Long idMatrizDerecho);
    
	/**
	 *  Metodo:Consulta marcas Rcv
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param listaSubCuentas
	 *  @param saldos
	 *  @return
	 */
	List<DatosCalculosMontos> obtenerSubCuentasSaldosImssRcv(List<DerechoSubcuenta> listaSubCuentas, DatosSaldos saldos);

    /**
     *  Consulta marcas rcv imss 
     *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
     *  @param tipoProceso
     *  @return
     */
	Marca consultarMarcasViviendaImss(Long idProcesar);

    /**
     *  Consultar marcas vivienda   
     *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
     *  @param listaSubCuentas
     *  @param saldos
     *  @param datos
     *  @return
     */
	List<DatosCalculosMontos> obtenerSubCuentasSaldosImssViv(List<DerechoSubcuenta> listaSubCuentas, DatosSaldos saldos);
}
