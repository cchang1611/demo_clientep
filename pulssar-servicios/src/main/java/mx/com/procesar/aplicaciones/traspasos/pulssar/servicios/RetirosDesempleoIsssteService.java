/**
 * RetirosDesempleoIsssteService.java
 * Fecha de creación: 29/08/2019, 17:17:26
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.Map;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificacionCalculoTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Resolucion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Interface Retiros Desempleo Issste
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 
 */
public interface RetirosDesempleoIsssteService {
	
	/**
	 *  Metodo consultar Retiro Desempleo Issste
	 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param idProcesar
	 *  @return
	 */
	Resolucion consultarRetiroDesempleoIssste(Long idProcesar);

	/**
	 *  Metodo de solicitud Disposicion Parcial Issste
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param datos
	 *  @param user
	 *  @param retiroDesempleoIssste
	 *  @param folioEntrada
	 *  @return
	 */
	SolicitudDisposicionParcialSalida solicitarDisposicionParcialIssste(DatosTrabajador datos, UsuarioLogin user, RetiroDesempleoIssste retiroDesempleoIssste, FolioEntrada folioEntrada, String tipoTramite);
	
	/**
	 *  consultar Tipo Retiro
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param resolucion
	 *  @param datosSaldos
	 */
	Map<String, Object> consultarTipoRetiro(Resolucion resolucion, DatosSaldos datosSaldos);
	
	/**
	 *  TODO [Agregar documentacion al método]
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param resolucion
	 *  @param retiroDesempleoIssste
	 *  @param datosSaldos
	 */
	void guardarTipoRetiroIssste(Resolucion resolucion, RetiroDesempleoIssste retiroDesempleoIssste, DatosSaldos datosSaldos);

	/**
	 * 
	 */
	void validarHorarioHabil();

	
	/**
	 * @param procesar
	 * @param trabajador
	 * @param claves
	 * @return
	 */
	String validarIssste(Long procesar, DatosTrabajador trabajador, String claves);

	
	/**
	 * @return
	 */
	 String obtenerParametroOpcionTramite(String claveAfore) ;
	
	
	/**
	 * @param procesar
	 * @param tramite
	 * @return
	 */
	Resolucion consultaTipoTramiteValido(Long procesar, String tramite);

	/**
	 * @param resultado
	 * @param saldos
	 * @return
	 */
	String validarSaldos(String resultado, DatosSaldos saldos);

	/**
	 * @param calculo
	 */
	void guardarCalculoTipoRetiroIssste(NotificacionCalculoTipoRetiro calculo);

	
	/**
	 * @param curp
	 * @return
	 */
	String consultaRegimen(String curp);

	
	/**
	 * @param tramite
	 * @param saldos
	 * @return
	 */
	String validarSaldosPorRegimen(String tramite, DatosSaldos saldos);
}
