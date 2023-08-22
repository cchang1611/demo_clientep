package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Organizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.SucursalAfore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Actuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Afore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BiomTipoSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentoCompletoRequerido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentoDigitalAforeSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentosRequerido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativaList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCatalogoCodigoPostal;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Genero;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GiroNegocio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GradoEstudios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Icefa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ModuloReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Nacionalidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NsarMunicipio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Ocupacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Pais;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parentesco;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaCatalogoCodigoPostal;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoDoctoProbatorio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoProcesoExpediente;

/**
 * interfaz para el manejo de la organizacion
 *  
 * @author dbarbosa
 * @version 1.0
 */
public interface CatalogoService {
	
	/**
	 * Obtiene la lista de afores activas
	 * 
	 */
	List<Afore> obtenerAfores();
	
	/**
	 * Obtiene lista de parametro
	 * @return
	 */
	List<Parametro> obtenerParametro(String clave, String desc);
	
	/**
	 * Metodo encargado obtener el mensaje de un codigo
	 * 
	 * @param codigo
	 * @param registro
	 * @param flujo
	 * @return
	 */
	RespuestaServicio obtenerRespuesta(DatosRegistro registro, String codigo, String claveAfore, Integer flujo, String minutos);
	
	/**
	 * Obtiene lista de organizacion
	 */
	List<Organizacion> obtenerOrganizaciones();
	/**
	 * obtiene lista de string de icefa
	 * @param clave
	 * @return
	 */
	List<Icefa> obtenerIcefa(String clave);
	
	/**
	 * Obtine objeto de nacionalidad 
	 * @param idNacionalidad
	 * @return
	 */
	Nacionalidad obtenerNacionalidad(Long idNacionalidad);
	
	/**
	 * Obtener parametros por clave parametro
	 * @param claveParametro
	 * @return
	 */
	List<Parametro> obtenerParametroDdbpose(String claveParametro); 
	
	/**
	 * Obtiene los parametros por la clave y descripción. Ésto se logra
	 * obtneiendo la consulta de {@code obtenerParametroDdbpose} y filtrandolos
	 * por la descripción del parámetro.
	 * 
	 * @param claveParametro
	 *            La clave del parámetro
	 * @param descripcionParametro
	 *            La descripción del parámetro.
	 * 
	 * @return Los paremetros consultaso por clave y descripción.
	 * 
	 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
	 */
	List<Parametro> obtenerParametroDdbpose(String claveParametro, String descripcionParametro);
	
	/**
	 * obtiene lista de tip solicitante
	 * @return
	 */
	List<BiomTipoSolicitante> obtenerTipoSolicitante(String claveSolicitante);

	/**
	 * Obtener parametros por clave parametro
	 * @param claveParametro
	 * @return
	 */
	List<Nacionalidad> obtenerNacionalidades(); 
	
	/**
	 * Obtener tipos de doctos probatorios
	 * @return
	 */
	List<TipoDoctoProbatorio> obtenerTiposDoctos();
	
	/**
	 * Obtener Ocupaciones
	 * @return
	 */
	List<Ocupacion> obtenerOcupaciones();
	
	/**
	 * Obtener GiroNegocio
	 * @return
	 */
	List<GiroNegocio> obtenerGirosNegocios();
	
	/**
	 * Obtener GradoEstudios
	 * @return
	 */
	List<GradoEstudios> obtenerGradoEstudios();
	
	/**
	 * Obtener Pais
	 * @return
	 */
	List<Pais> obtenerPaises();
	
	/**
	 * Obtener Municipios
	 * @return
	 */
	List<NsarMunicipio> obtenerMunicipios();
	
	/**
	 * Obtener Parentescos
	 * @return
	 */
	List<Parentesco> obtenerParentescos();
	
	/**
	 * Obtener Entidades federativas
	 * @return
	 */
	List<EntidadFederativa> obtenerEntidades();

	/**
	 * Metodo encargado de obtenr lista de documento completo requerido
	 * @param servicioTipoDocumento
	 * @return
	 */
	List<DocumentoCompletoRequerido> obtenerTipoDocumento(String servicioTipoDocumento);
	
	/**
	 * Obtener Nacionalidad por clave
	 * @param cvNacionalidad
	 * @author medoming
	 */
	Nacionalidad obtenerNacionalidadPorClave(String cvNacionalidad);

	/**
	 * Obtener Municipios por Clave Entidad Federativa
	 * @param claveEntidad
	 * @author medoming
	 */
	List<NsarMunicipio> obtenerMunicipiosPorEntidad(String claveEntidad);
	
	/**
	 * Metodo encargado de obtener los subdocumentos
	 * 
	 * @param claveAfore
	 * @param estatus
	 * @param claveDocumento
	 * @return
	 */
	DocumentoDigitalAforeSalida obtenerSubDocumentos(String claveAfore, String claveDocumento);
	
	/**
	 * Obtiene la lista de las sucursales
	 * 
	 */
	List<SucursalAfore> obtenerSucursales(String claveAfore);
	
	/**
	 * Obtener entidadFederativa por clave
	 * @param claveEntidadFederativa
	 * @return
	 */
	EntidadFederativa obtenerEntidadFederativa(String claveEntidadFederativa);
	/**
	 * Metodo encargado de obtener datos de entidad federativa
	 * @param claveCorta
	 * @return
	 */
	EntidadFederativa obtenerEntidad(String claveCorta);
	
	/**
	 * Metodo encargado de obtener la url del redireccionamiento de una afore
	 * 
	 * @param claveAfore
	 * @return
	 */
	String obtenerRedireccionAfore(String claveAfore);
	
	/**
	 * Metodo encargado de consultar codigo postal
	 * @param entrada
	 * @return
	 */
	SalidaCatalogoCodigoPostal consultarCatalogoCodigoPostal(EntradaCatalogoCodigoPostal entrada);
	
	/**
	 * Consultar documento requerido por clave aforeo
	 * 
	 * @param claveAfore
	 * @return
	 */
	List<DocumentosRequerido> consultarDocumentosRequeridosPorClaveAfore(String claveAfore);
	
	/**
	 * Servicio que consulta nacionalidad por valor de despliegue
	 * @param claveCorta
	 * @return
	 */
	Nacionalidad obtenerNacionalidadPorClaveCorta(String claveCorta);
	
	/**
	 * Servicio que consulta catalogo genero
	 * @return
	 */
	List<Genero> obtenerCatalogoGenero();
	
	/**
	 * Servicio que consulta catalogo Entidad Federativa
	 * @return
	 */
	EntidadFederativaList obtenerCatalogoEntidadFederativa();
	
	/**
	 * Busca los tipos de procesos en base a una lista
	 * 
	 * @param idTipoProceso
	 * @return
	 */
	List<TipoProcesoExpediente> buscarTipoProceso(List<String> idTipoProceso);
    
	/**
	 * Consulta Catalogo de Actuarios Autorizados 
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 *  @return
	 */
	List<Actuario> obtenerActuarios();
	
	/**
	 * Obtiene lista de modulos de reporte
	 * @return
	 */
	List<ModuloReporte> obtenerModuloReportes();
	
	/**
	 * Consulta de ip para acceso a SICI
	 * @param ip
	 * @param afore
	 * @return
	 */
	boolean validarIPAccesoSICI(String ip, String afore);
	
	/**
	 * consultaValorParametro
	 * @param parametro
	 * @param claveParametro
	 * @return
	 */
	String consultaValorParametro(String parametro, String claveParametro);
	
	/**
	 * obtenerEntidadFederativaComunes
	 * @param claveEntidadFederativa
	 * @return
	 */
	EntidadFederativa obtenerEntidadFederativaComunes(String claveEntidadFederativa);
}