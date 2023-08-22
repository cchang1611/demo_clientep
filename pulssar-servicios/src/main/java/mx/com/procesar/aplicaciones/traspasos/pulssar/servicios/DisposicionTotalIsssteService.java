package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AportacionIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CancelacionSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCalculosMontos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuentaIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteCancelacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FactorConversion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IretEstatusViviendaMarca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IretMatrizDerecho;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PrecioAccion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ResolucionDisposicionIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ResolucionDisposicionIsssteVis;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGeneraCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaDisposicionTotalIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Siefore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;



/**
 * Disposicion total issste
 * @author RARREOLA
 *
 */
public interface  DisposicionTotalIsssteService {
	
	
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
	 * Consultar no cargado issste
	 * @param entrada
	 * @return
	 */
	List<DisposicionIsssteSalida> consultarNoCargadoIssste(DisposicionIsssteEntrada entrada);
	
	
	
	
	/**
	 * Metodo para consulta resolucion
	 *  @author rarreola
	 *  @param procesar
	 *  @param l
	 */
	List<ResolucionDisposicionIsssteVis> setearDatosResol(List<ResolucionDisposicionIssste> lista, List<Parametro> lparametro, String tipoSolicitante);
	

	
	/**
	 * Consultar issste retiro c
	 * @param entrada
	 * @return
	 */
	List<DisposicionIsssteSalida> consultarIsssteRetiroC(DisposicionIsssteEntrada entrada);
	
	
	/**
	 * Consultar matriz derecho
	 * @param claveTipoRetiro
	 * @param claveTipoPension
	 * @param claveTipoSeguro
	 * @param claveTipoRegimen
	 * @param clavePension
	 * @param claveTipoPrestacion
	 * @param claveMovimiento
	 * @return
	 */
	IretMatrizDerecho consultarMatrizDerecho( String claveTipoRetiro,
			 String claveTipoPension,  String claveTipoSeguro,
			 String claveTipoRegimen, String clavePension,
			 String claveTipoPrestacion,  String claveMovimiento);
	
	
	
	List<DerechoSubcuentaIssste> obtenerDerechoSubcuentaPorIdMatrizDerecho(Long idMatrizDerecho);
	
	
	
	
	/**
	 * Obtener edad del trabajador
	 * @param fechaNacimiento
	 * @return
	 */
	Integer obtenerEdadTrabajador(String fechaNacimiento);
	
	
	/**
	 * Obtener retiros no cargado
	 * @param lparametro
	 * @param tipoRegimen
	 * @param tipoSolicitante
	 * @return
	 */
	List<String> obtenerTipoRetirosIdSolicitanteNoCargado(List<Parametro> lparametro, String tipoRegimen, String tipoSolicitante);
	
	
	/**
	 * Validar solicitantes plan privado
	 * @param lparametro
	 * @param tipoRegimen
	 * @param tipoSolicitante
	 * @return
	 */
	boolean validarSolicitantesPlanPrivado(List<Parametro> lparametro, String tipoSolicitante,  String tipoRetiro);
	
	
	/**
	 * Validar si curp existe
	 * @param curp
	 * @return
	 */
	BaseRespuesta<AportacionIssste> validarCurpExiste(String curp);
	
	
	
	
	/**
	 * Obtener estatus vivienda issste
	 * @param tipoPRoceso
	 * @return
	 */
	List<IretEstatusViviendaMarca> obtenerEstatusViviendaIssste(List<String> tipoPRoceso);
	
	
	/**
	 * Subcuentas rcv
	 * @param lista
	 * @return
	 */
	List<DatosCalculosMontos> obtenerCombinacionSubcuentasSaldosRcv(List<DerechoSubcuentaIssste>  lista, DatosSaldos saldos, DisposicionIsssteEntrada entradaParams);
	
	
	
	
	/**
	 * Subcuentas rcv
	 * @param lista
	 * @return
	 */
	List<DatosCalculosMontos> obtenerCombinacionSubcuentasSaldosVivienda(List<DerechoSubcuentaIssste>  lista, DatosSaldos saldos, String tipoRecurso);
	
	
	/**
	 * Agrupar lista subcuentas
	 * @param lista
	 * @return
	 */
	List<DerechoSubcuentaIssste>  agruparListaSubcuentas(List<DerechoSubcuentaIssste>  lista);
	
	
	/**
	 * Obtener precio accion
	 * @param claveSiefore
	 * @return
	 */
	List<PrecioAccion> obtenerPrecioAccion(String claveSiefore, String dias);
	
	/**
	 * Obtener factor conversion
	 * @param tipoValor
	 * @return
	 */
	List<FactorConversion> obtenerFactorConversion(String tipoValor, String tipoRecurso, String dias);
	
	/**
	 * Consultar siefores
	 * @return
	 */
	List<Siefore> obtenerSiefores(Long afore);
	
	
	
	 /**
	 * Consultarregimen ordinario
	 * @param entrada
	 * @return
	 */
	SalidaDisposicionTotalIssste consultarIsssteRegimenOrdinario(DatosGeneralesDispIssste entradaParams);
	
	
	
	
	/**
	 * Consultar disposicion total
	 * @param entrada
	 * @return
	 */
	SalidaDisposicionTotalIssste consultarIsssteDisposicionTotal(DatosGeneralesDispIssste entradaParams);

	
	/**
	 * Cancelacion
	 * @param entrada
	 * @return
	 */
	CancelacionSalida  consultarCancelacion(DatosGeneralesDispIssste entradaParams);
	
	
	
	
	/**
	 * @param folio
	 * @param datos
	 * @param usuarioLogin
	 * @param salida
	 * @return
	 */
	String validarExpedienteServicio(String folio,  DatosTrabajador datos, UsuarioLogin usuarioLogin);
	
	
	
	/**
	 * Validar si se realiza la cancelacion
	 * @param servicio
	 */
	List<DisposicionIsssteCancelacion>  validarCancelacion(List<FolioSalida> folios, DatosTrabajador trabajador, List<FolioSalida> foliosPadres, String idFolio);
	
	
	
	/**
	 * Validar datos cancelacion
	 * @param listas
	 * @return
	 */
	String validarDatosCancel(List<DisposicionIsssteCancelacion> listas);

}
