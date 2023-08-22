package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoDerechoCargadoEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CancelacionSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametroEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaDisposicionTotalImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
/**
 *  Interfaz DisposicionTotalImssService
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since May 10, 2021
 */
public interface DisposicionTotalImssService {

	
	
	/**
	 *  generarCus
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param user
	 *  @param origen
	 *  @param trabajador
	 */
	public FolioEntrada generarFolio(UsuarioLogin user, String origen, DatosTrabajador trabajador);
	
	/**
	 *  solicitarCus
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param trabajador
	 *  @param user
	 *  @param origen
	 *  @param folioRespuesta
	 *  @return
	 */
	public RespuestaGeneraCusSalida generarCus(DatosTrabajador trabajador, UsuarioLogin user, String origen, Long folioRespuesta);

	/**
	 *  Agrupa subcuentas
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param listaSubCuentas
	 *  @return
	 */
	public List<DerechoSubcuenta> obtenerAgruparSuBcuentas(List<DerechoSubcuenta> listaSubCuentas);
	
	
	
	/**
	 * Cancelacion
	 * @param entrada
	 * @return
	 */
	CancelacionSalida  consultarCancelacion(DatosGeneralesDispIssste entradaParams);
	
	
	
	/**
	 * Validar cancelacion
	 * @param folios
	 * @param trabajador
	 * @param foliosPadres
	 * @param idFolio
	 * @return
	 */
	List<ParametroEntrada>  validarCancelacion(List<FolioSalida> folios, DatosTrabajador trabajador, List<FolioSalida> foliosPadres, String idFolio);

	/**
	 * Validar salida cancelar
	 * @param listas
	 * @return
	 */
	String validarDatosCancel(List<ParametroEntrada> listas);
	
	
	/**
	 * 
	 * @param entradaParams
	 * @return
	 */
	SalidaDisposicionTotalImss consultarImssDisposicionTotal(ProcesoDerechoCargadoEntrada entradaParams, DatosTrabajador trabajador);

	/**
	 *  Datos seteo Cargado 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @param tipoRegimenSol
	 *  @param listaParametro
	 *  @param listaDerechoCargado
	 *  @return
	 */
	public List<ProcesoDerechoCargadoEntrada> setearDerechoCargado(String tipoRegimenSol, List<Parametro> listaParametro,List<ProcesoDerechoCargado> listaDerechoCargado);
	
	/**
	 *  validarPrecondicionesDisposiciones Imss
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param datosExpediente
	 *  @param claves
	 *  @param idProcesar
	 *  @param afore
	 *  @return
	 */
	String validarPrecondicionesDisposicionesImss(DatosExpediente datosExpediente, List<String> claves, Long idProcesar, String afore);
}
