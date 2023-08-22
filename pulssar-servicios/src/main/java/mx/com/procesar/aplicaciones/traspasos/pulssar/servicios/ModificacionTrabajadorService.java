package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseFormulario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivoDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Renapo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaActualizaDatos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.VerificacionSello;

/**
 * interfaz para modificacion de datos
 *  
 * @author MEDOMING
 * @version 1.0
 */
public interface ModificacionTrabajadorService {
	
	/**
	 * Obtener flujo para modificacion de datos
	 * @param datosTrabajador
	 * @param datosExpediente
	 * @return
	 */
	FlujosEntrada obtenerRespuestaFlujo(EntradaModificacion entradaModificacion, DatosTrabajador trabajador, ExpedienteSalida expediente);
	
	/**
	 * Ejecución de Operacion 13
	 * @param datosTrabajador
	 * @return
	 */
	SalidaActualizaDatos ejecutarModificacion(EntradaModificacion entradaModificacion, DatosTrabajador trabajador,String banderaRelanzamiento);
	
	/**
	 * Ejecución de Permanencia
	 * @param entradaPermanencia
	 * @return
	 */
	SalidaPermanencia ejecutarPermanencia(EntradaPermanencia entradaPermanencia);
	
	/**
	 * @param entradaModificacion
	 * @param user
	 * @return
	 */
	String consultarSellos(EntradaModificacion entradaModificacion, UsuarioLogin user,String tipoSolicitante);
	
	/**
	 * Obtiene Datos Renapo
	 * @param trabajador
	 * @return
	 */
	Renapo obtenerDatosRenapo(DatosTrabajador trabajador);
	
	/**
	 * Valida las marcas operativas de un Trabajador
	 * @return
	 */
	RespuestaServicio validarMarcasOperativasTrabajador(Long idProcesar, String cveProceso,Folio folio); 
	
	/**
	 * Valida existencia de expediente biometrico
	 * @param expediente
	 * @param user
	 * @return
	 */
	String validarExpedienteBiometrico(ExpedienteSalida expediente,UsuarioLogin user,DatosTrabajador trabajador,EntradaModificacion entradaModificacion,FlujoModificacion flujoModificacion,String bandera9B);
	
	/**
	 * Valida existencia de expediente de identificacion
	 * @param expediente
	 * @param user
	 * @return
	 */
	String validarExpedienteIdentificacion(ExpedienteSalida expediente,UsuarioLogin user,DatosTrabajador trabajador,EntradaModificacion entradaModificacion,FlujoModificacion flujoModificacion,String bandera9B);
	
	/**
	 * Metodo que relanza solicitud de modificacion de datos en caso de rechazo E83
	 * @param entradaRespuesta
	 * @param entrada
	 * @param trabajador
	 * @return
	 */
	SalidaActualizaDatos validarRespuestaModificacion(SalidaActualizaDatos entradaRespuesta,EntradaModificacion entrada,DatosTrabajador trabajador);
	
	/**
	 * Metodo encargado de validar recepcion de expediente de identificacion
	 * @param folio
	 * @param tipo
	 * @return
	 */
	String consultarRecepcionExpeIdentificacion(Folio folio,String tipo);

	/**
	 * Metodo encargado de validar tipo solicitante y sello 
	 * @param curpEmpleado
	 * @param curpTrabajador
	 * @param claveAfore
	 * @param tipoSolicitante
	 * @return
	 */
	VerificacionSello validaSelloPermanencia(String curpEmpleado, String curpTrabajador, String claveAfore,String tipoSolicitante);

	/**
	 * Metodo encargado de guardas pasos en bitacora
	 * @param controlador
	 * @param entradaModificacion
	 * @param folioPadre
	 */
	void guardarFlujoBitacora(String controlador, EntradaModificacion entradaModificacion, Folio folioPadre,EntradaPermanencia entradaPermanencia,String bandera13,String banderaP);

	/**
	 * Metodo que obtiene diagnostico corto
	 * @param diagnostrico
	 * @return
	 */
	String obtenerDiagnosticoCorto(String diagnostrico);

	/**
	 * Metodo encargado de validar tiempo tramite
	 * @param folioProcesar
	 * @param folioConsulta
	 */
	void notificarTiempoTramite(String folioProcesar, FolioEntrada folioConsulta,String claveAfore);

	/**
	 * Metodo encargado de validar pendiente persona
	 * @param curp
	 * @return
	 */
	Boolean validaPendientePersona(String curp);

	/**
	 * Metodo encargado de validar respuesta de pendiente
	 * @param entrada
	 */
	void validarRespuestaPendiente(Boolean entrada);

	/*
	 * Metodo encargado de consultar folio activo por curp y nss
	 */
	FolioActivoDetalle consultaFolioActivo(String curp, String nss,String claveAfore,boolean banderaValidacionFolioPermanencia);

	/**
	 * Metodo que valida banderas de flujo 13+ o permanencia 
	 * @param controlador
	 * @param bandera13
	 * @param banderaP
	 * @return
	 */
	String validarBanderaFlujo(String controlador, String bandera13, String banderaP);

	/**
	 * Metodo que valida expediente de identificacion al inicio de modificacion en caso de no ser titular 
	 * @param trabajador
	 * @return
	 */
	ExpedienteSalida validarExpedientesNoTitularInicio(DatosTrabajador trabajador);

	/**
	 * Metodo que valida Datos modificacion para solicitud del comparador
	 * @param objetoEntrada
	 * @return
	 */
	EntradaModificacion validaDatosModificacionComparador(EntradaModificacion objetoEntrada);

	/**
	 * Metodo que acorta motivo de rechazo en caso de ser mayor a 3
	 * @param motivoRechazo
	 * @author JMGUTIEG
	 * @return
	 */
	String acortarMotivoRechazo(String motivoRechazo);
	
	/**
	 * Metodo encargado de validar modificacion nombre completo para generar nuevo expe ide , caso permanente coppel
	 * @param datosTrabajador
	 * @param entradaProceso
	 * @return
	 */
	boolean validarNombreCompleto(DatosTrabajador datosTrabajador, Object entradaProceso);

	/**
	 * Valida modificacion de datos base para generar nuevo expe ide , caso permanente coppel
	 * @param datosTrabajador
	 * @param entradaProceso
	 * @return
	 */
	boolean varlidarDatosBaseMasNacionalidad(DatosTrabajador datosTrabajador, Object entradaProceso);

	/**
	 * valida cambios domicilio particular expe ide,caso permanente coppel
	 * @param datosTrabajador
	 * @param entradaProceso
	 * @return
	 */
	boolean validaDomicilio(DatosTrabajador datosTrabajador, Object entradaProceso);
	
	/**
	 * validar cambios rfc , generacion nuevo expe ide,caso permanente coppel
	 * @param datosTrabajador
	 * @param entradaProceso
	 * @return
	 */
	boolean validarCambiosRfc(DatosTrabajador datosTrabajador, Object entradaProceso);

	/**
	 * Metodo encargado de validar respuestas de metodos de validaciones de modificacion
	 * @param validaNombre
	 * @param validaBaseCurp
	 * @param validaDomicilio
	 * @param validaRfc
	 * @return
	 */
	boolean validaActualizacionModificacion(boolean validaNombre, boolean validaBaseCurp, boolean validaDomicilio,boolean validaRfc);

	/**
	 * Metodo encargado de validar cambio de curp caso coppel
	 * @param estatusExpeIde
	 * @param claveAfore
	 * @param trabajador
	 * @param entradaModificacion
	 * @param bandera13
	 * @return
	 */
	String validarCambioCurpCoppel(String estatusExpeIde, String claveAfore, DatosTrabajador trabajador,EntradaModificacion entradaModificacion, String bandera13);
	
	/**
	 * Metodo encargado de validar datos base
	 * @param datosTrabajador
	 * @param entradaModificacion
	 * @return
	 */
	boolean varlidarDatosBase(DatosTrabajador datosTrabajador, EntradaModificacion entradaModificacion);

	/**
	 * Metodo encargado de regresar datos base modificacion seteados de datos base formulario
	 * @param datosBaseFormulario
	 * @return
	 */
	EntradaModificacion regresaDatosBaseModificacion(DatosBaseFormulario datosBaseFormulario);

	/**
	 * Metodo encargado de regresar respuesta de validacion de comparacion datos base curp
	 * @param validaNombre
	 * @param validaDatosBase
	 * @return
	 */
	String regresarRespuestaValidaDatosBase(boolean validaNombre, boolean validaDatosBase);

	/**
	 * Metodo encargado de validar respuesta de servicio marca permanencia
	 * @param respuestaValidacion
	 */
	void validaMarcasProcesoPermanencia(Integer respuestaValidacion);

	/**
	 * Metodo que valida cambio de curp y regresa curp actual o nueva
	 * @param curpActual
	 * @param curpNueva
	 * @return
	 */
	String regresarCurpActualNueva(String curpActual, String curpNueva);

	/**
	 * Metodo que regresa folio padre origen en caso de existir
	 * @param curp
	 * @param proceso
	 * @param claveAfore
	 * @param resultadoOperacion
	 * @return
	 */
	String recuperaFolioPadreOrigen(String curp, String proceso, String claveAfore, String resultadoOperacion,FlujoModificacion flujo);
	
	/**
	 * Metodo encargado de recuperar folio origen por proceso 13+ o permanencia
	 * @param user
	 * @param trabajador
	 * @param bandera13
	 * @param banderaP
	 * @param entradaModificacion
	 * @param entradaPermanencia
	 * @return
	 */
	String recuperarFolioOrigenPorProceso(UsuarioLogin user, DatosTrabajador trabajador, String bandera13,String banderaP, EntradaModificacion entradaModificacion, EntradaPermanencia entradaPermanencia,FlujoModificacion flujo);

	/**
	 * MEtodo encargado de ejecutar proceso E83
	 * @param entrada
	 * @param trabajador
	 * @param estatus
	 * @param respuestaDiagnostico
	 * @param restoDiagnostico
	 * @param respuestaSalidaModificacion
	 * @return
	 */
	SalidaActualizaDatos ejecutaProcesoE83(EntradaModificacion entrada, DatosTrabajador trabajador, String estatus,String respuestaDiagnostico, String restoDiagnostico, SalidaActualizaDatos respuestaSalidaModificacion);

	/**
	 * Metodo encargado de buscar expediente por tipo de expediente 
	 * @param proceso
	 * @param claveAfore
	 * @param curpTrabajador
	 * @param idArchivoRecibido
	 * @return
	 */
	boolean buscarExpedientePorTipo(String proceso, String claveAfore, String curpTrabajador, Long idArchivoRecibido);
	
	/**
	 * Metodo encargado de cerrar folio hijo origen
	 * @param flujoModificacion
	 */
	void cerrarFolioOrigen(FlujoModificacion flujoModificacion);
	
	/**
	 * MEtodo encargado de validar flujo 9b
	 * @param datosTrabajador
	 * @param curpNueva
	 * @param nombre
	 * @param apellidoPaterno
	 * @param apellidoMaterno
	 */
	String validaFlujo9B(DatosTrabajador datosTrabajador, String curpNueva, String nombre, String apellidoPaterno,String apellidoMaterno,String cvAfore);

	/**
	 * Metodo que valida para asignar indicador de enrolamiento
	 * @param banderaFlujo9B
	 * @param estatusEnrolamiento
	 * @return
	 */
	String validarIndicadorEnrolamiento9B(String banderaFlujo9B, String estatusEnrolamiento);

	/**
	 * Metodo que valida para asignar flujo 9B
	 * @param banderaFlujo9B
	 * @return
	 */
	FlujosEntrada asignarFlujoCaso9B(String banderaFlujo9B);

	/**
	 * Metodo encargado de validar estatus expediente
	 * @param flujoModificacion
	 * @param expedienteSalida
	 * @return
	 */
	ExpedienteSalida validarEstatusExpedientes(FlujoModificacion flujoModificacion, ExpedienteSalida expedienteSalida);

	/**
	 * Metodo encargado de validar anexo a para modificacion de datos 
	 * @param curpActual
	 * @param curpNueva
	 * @param apellidoPaternoFormularioLimplio
	 * @param apellidoMaternoFormularioLimpio
	 * @param nombreFormularioLimpio
	 * @param respuestaInicial
	 * @param caracterHomologado
	 * @return
	 */
	String validaConsultaAnexo(String curpActual, String curpNueva, String apellidoPaternoFormularioLimplio,
			String apellidoMaternoFormularioLimpio, String nombreFormularioLimpio, String respuestaInicial,
			String caracterHomologado);

	/**
	 * Metodo encargado de validar expedientes permanentes para flujo 9B
	 * @param trabajador
	 * @param entradaModificacion
	 * @param banderaFlujo9B
	 * @return
	 */
	ExpedienteDetail validaExpedienteEnrolamientoNoTitular9B(DatosTrabajador trabajador, EntradaModificacion entradaModificacion,String banderaFlujo9B);

	/**
	 * Metodo que valida expediente de identificacion para no titular por curp nueva
	 * @param trabajador
	 * @param entradaModificacion
	 * @param respuesta
	 * @param cveProceso
	 * @return
	 */
	ExpedienteDetail validaExpedienteIdentificacionNoTitularCurpNueva(DatosTrabajador trabajador,EntradaModificacion entradaModificacion, ExpedienteDetail respuesta, String cveProceso);

	/**
	 * Metodo encargado de consultar caracter homologado
	 * @return
	 */
	String consultarCaracterHomologado();

	/**
	 * Numero de beneficiarios aceptados
	 * @return
	 */
	Integer obtenerNumeroBeneficiariosPermitido();
	
	/**
	 * metodo que valida si movimiento beneficiario es 3 para vaciar objeto beneficiario
	 * @param entradaModificacion
	 */
	void validaNumeroMovimientoBeneficiario(EntradaModificacion entradaModificacion);

	/**
	 * Metodo que registra solicitudes para modificacion de datos y permanencia 
	 * 
	 * @param entradaModificacion
	 * @param entradaPermanencia
	 * @param diagnostico
	 * @param folioProcesar
	 * @param selloPermanencia
	 */
	void registraSolicitudReimpresionModificacion(EntradaModificacion entradaModificacion,EntradaPermanencia entradaPermanencia, String diagnostico, String folioProcesar, String selloPermanencia);
	
	/**
	 * Metodo que consulta para busqueda y conformacion de expediente
	 * @param datosTrabajador
	 * @param entradaModificacion
	 * @param bandera13
	 * @param controladorEntrante
	 * @param controladorRedireccion
	 * @param claveAfore
	 * @return
	 */
	String validaExpedienteCambioCurp(DatosTrabajador datosTrabajador, EntradaModificacion entradaModificacion,
			String bandera13, String controladorEntrante, String controladorRedireccion, String claveAfore);
	
	/**
	 * Metodo que valida flujo para digitalizador coppel
	 * @param flujoModificacion
	 * @param expedienteSalida
	 * @param entradaModificacion
	 * @param trabajador
	 * @param bandera13
	 * @param banderaFlujo9B
	 * @return
	 */
	String validaFlujoDigitalizador(FlujoModificacion flujoModificacion, ExpedienteSalida expedienteSalida,EntradaModificacion entradaModificacion, DatosTrabajador trabajador,String bandera13,String banderaFlujo9B);

	/**
	 * Metodo encargado de validar resultado de folio detalle y cerrar folio en caso de ser necesario
	 * @param detalleFolioModificacion
	 * @param detalleFolioPermanencia
	 */
	void validaDetalleFolioModifcacionPermanencia(FolioActivoDetalle detalleFolioModificacion,FolioActivoDetalle detalleFolioPermanencia);

	/**
	 * Metodo que valida designacion de beneficiarios
	 * @param listaBeneficiario
	 * @param consulta
	 * @param cvAfore
	 * @return
	 */
	boolean validaBeneficiarioDesignado(List<Beneficiario> listaBeneficiario, EntradaConsulta consulta, String cvAfore);

	/**
	 * 
	 *  Metodo que valida entrada de permanencia por caracteres especiales
	 *  @author Juan Manuel Gutierrez Gadea (jmgutieg@procesar.com)
	 *  @param entradaPermanencia
	 *  @param caracterHomologado
	 *  @return
	 */
	EntradaPermanencia validarEntradaPermanencia(EntradaPermanencia entradaPermanencia);

	/**
	 * 
	 *  Metodo que obtiene bandera para bloquear boton editar
	 *  @author Juan Manuel Gutierrez Gadea (jmgutieg@procesar.com)
	 *  @return
	 */
	String obtenerBotonEditarPermitido();

}
