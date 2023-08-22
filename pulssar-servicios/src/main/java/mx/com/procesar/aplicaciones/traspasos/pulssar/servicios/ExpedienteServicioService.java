package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BanderaDatosModificadosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudModificacionPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ListaBeneficiariosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAlta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

public interface ExpedienteServicioService {
	
	/**
	 * Metodo que genera pdf de pensionisste
	 * @param flujoEntrada
	 * @param datosTrabajador
	 * @param datosModificacion
	 * @param banderaDatosModif
	 * @param fechaNacimientoModificada
	 * @param entidadFederativaNacimientoModificada
	 * @param nacionalidadModificada
	 * @param objetoModificacion
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public DatosSolicitudModificacionPdf generarSolicitudDatosPDFPeis(FlujosEntrada flujoEntrada , DatosTrabajador datosTrabajador, EntradaModificacion datosModificacion, BanderaDatosModificadosCertificables banderaDatosModif, String fechaNacimientoModificada, String entidadFederativaNacimientoModificada, String nacionalidadModificada,EntradaModificacion objetoModificacion,UsuarioLogin user) throws DocumentException, IOException;

	/**
	 * Metodo encargado de enviar archivos
	 * @param arregloArchivos
	 * @param solicitudModificacionDatosPdf
	 * @param datosRecepcion
	 * @return
	 */
	public RespuestaServicio enviarArchivos(Map<String, Map<String, MultipartFile>> arregloArchivos, String solicitudModificacionDatosPdf ,EnvioArchivos datosRecepcion,Long idFolioHijo)throws IOException;

	/**
	 * Metodo encargado de enviar archivos
	 * @param arregloArchivos
	 * @param solicitudModificacionDatosPdf
	 * @param datosRecepcion
	 * @return
	 */
	public RespuestaAlta capturarArchivos(Archivos archivos, String ruta);
	
	/**
	 * Metodo que genera pdf de banorte
	 * @param flujoEntrada
	 * @param datosTrabajador
	 * @param datosModificacion
	 * @param banderaDatosModif
	 * @param fechaNacimientoModificada
	 * @param entidadFederativaNacimientoModificada
	 * @param nacionalidadModificada
	 * @param objetoModificacion
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public DatosSolicitudModificacionPdf generarSolicitudDatosPDFBanorte(DatosTrabajador datosTrabajador, EntradaModificacion datosModificacion, BanderaDatosModificadosCertificables banderaDatosModif, String fechaNacimientoModificada, String entidadFederativaNacimientoModificada, String nacionalidadModificada,EntradaModificacion objetoModificacion,UsuarioLogin user) throws DocumentException, IOException;

	/**
	 * Metodo que genera pdf de coppel
	 * @param flujoEntrada
	 * @param datosTrabajador
	 * @param datosModificacion
	 * @param banderaDatosModif
	 * @param fechaNacimientoModificada
	 * @param entidadFederativaNacimientoModificada
	 * @param nacionalidadModificada
	 * @param objetoModificacion
	 * @param user
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public DatosSolicitudModificacionPdf generarSolicitudDatosPDFCoppel(DatosTrabajador datosTrabajador, EntradaModificacion datosModificacion,BanderaDatosModificadosCertificables banderaDatosModif, String fechaNacimientoModificada,String entidadFederativaNacimientoModificada, String nacionalidadModificada,EntradaModificacion objetoModificacion, UsuarioLogin user,EntradaSolicitante entradaSolicitante,String banderaCheck) throws DocumentException, IOException;

	/**
	 * obtiene clave de expediente de servicio
	 * @param tipoSolicitante
	 * @return
	 */
	String obtenerProcesoExpedienteServicio(String tipoSolicitante);

	/**
	 * Metodo que regresa folio para solicitud
	 * @param folio
	 * @return
	 */
	String generarFolioSolicitud(Folio folio);

	/**
	 * Metodo encargado de recuperar firmas proceso
	 * @param folioPadre
	 * @param recepcionImagenes
	 * @return
	 * @throws IOException
	 */
	DatosSolicitud recuperarFirmasProceso(String folioPadre,RecepcionImagenes recepcionImagenes) throws IOException;

	/**
	 * Metodo encargado de enviar solicitud de flujo banorte
	 * @param solicitudModificacionDatosPdf
	 * @param datosRecepcion
	 * @return
	 * @throws IOException
	 */
	RespuestaServicio enviarSolicitudBanorte(EnvioArchivos datosRecepcion,String rutaZip)throws IOException;

	/**
	 * Metodo encargado de consultar parametro
	 * @param cvParametro
	 * @return
	 */
	Parametro obtenerValorParametro(String cvParametro);

	/**
	 * Metodo que valida estatus de expediente de servicio
	 * @param entradaModificacion
	 * @param cveProceso
	 * @param cvAfore
	 * @param folio
	 * @return
	 */
	RespuestaServicio validarEstatusExpediente(EntradaModificacion entradaModificacion, String cveProceso, String cvAfore, String folio);

	/**
	 * Metodo que valida igual de rfc
	 * @param trabajador
	 * @param objetoModificacion
	 * @return
	 */
	String validarIgualdadRfc(DatosTrabajador trabajador, EntradaModificacion objetoModificacion);

	/**
	 * Metodo que consulta sello para solicitud mdd
	 * @param user
	 * @param curp
	 * @return
	 */
	String consultaSelloSolicitud(UsuarioLogin user, String curp,String tipoSolicitante);

	/**
	 * Metodo que valida cambios de beneficiario
	 * @param datosComplementarios
	 * @param listaBeneficiariosTrabajador
	 * @return
	 */
	Boolean validaArregloCambiosBeneficiarios(DatosComplementarios datosComplementarios,ListaBeneficiariosTrabajador listaBeneficiariosTrabajador,EntradaModificacion entradaModificacion,String banderaValidacion);

	/**
	 * @param string
	 * @param recepcionImagenes
	 * @return
	 * @throws IOException 
	 */
	DatosSolicitud recuperarFirmasProcesoGenerico(String folioPadre, RecepcionImagenes recepcionImagenes) throws IOException;
	
	
	/**
	 * Metodo para generar ruta de guardado de archivos
	 * @param afore
	 * @param proceso
	 * @return
	 */
	String generarUrlGuardadoArchivos(String afore, String proceso);
}     
  