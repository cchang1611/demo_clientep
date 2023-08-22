package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosHuellas;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosIdenExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNoCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPDF;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioComplemento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Interface de Expediente Servicio
 * validaciones de biometrico e identificacion
 * 
 * @author DBARBOSA
 */
public interface ExpedienteService {
	
	/**
	 * Metodo encargado de obtener Imagen desde un PDF
	 * 
	 * @param entrada
	 * @return
	 */
	String obtenerImagenPDF(EntradaPDF entrada);
	
	/**
	 * Metodo encargado de guardar las huellas del trabajador
	 * 
	 * @param valor
	 * @param user
	 * @param trabajador
	 * @param objetoArchivo
	 * @param archivo64
	 * @param folio
	 * @return
	 */
	RespuestaServicio guardarHuellasTrabajador(String valor, UsuarioLogin user, DatosTrabajador trabajador, Archivos objetoArchivo, String archivo64, Folio folio) throws IOException;
	
	/**
	 * Metodo encargado de invocar el envio de archivos
	 * 
	 * @param objetoArchivo
	 */
	void invocarRecepcionArchivos(Archivos objetoArchivo);
	
	/**
	 * Metodo encargado de obtener el documento con la firma del agente por excepcion de enrolamiento
	 * 
	 * @param user
	 * @param trabajador
	 * @param codigo
	 * @param firma
	 * @return
	 */
	String obtenerDocumentoExcepcionFirma(UsuarioLogin user, DatosTrabajador trabajador, String codigo, String firma);
	
	/**
	 * Metodo encargado de obtener el folio y e tipo de trabajador
	 * 
	 * @param folio
	 * @param tipoTrabajador
	 * @return
	 */
	String obtenerValoresPantalla(String folio, String tipoTrabajador);
	
	/**
	 * Metodo encargad de obtener los dedos de mejor calidad
	 * 
	 * @param huellas
	 * @param curp
	 * @param estatusEnRolamiento
	 * @return
	 */
	List<String> obtenerDedosMejorCalidad(List<DatosHuellas> huellas, String curp, Integer estatusEnRolamiento);
	
	/**
	 * Metodo encargado de obtener el PDF con las huellas del trabajador
	 * 
	 * @param huellas
	 * @param curp
	 * @param estatusEnRolamiento
	 * @param lstDedos
	 * @return
	 */
	String obtenerPDFHuellas(List<DatosHuellas> huellas, String curp, Integer estatusEnRolamiento, List<String> lstDedos) throws InvalidPasswordException, IOException;
	
	/**
	 * Metodo encargado de devolver el objeto para la ventana de expediente
	 * 
	 * @param datosPersonales
	 * @return
	 */
	DatosIdenExpediente obtenerDatosExpediente(Object datosPersonales, FlujoModificacion flujo);
	
	/**
	 * Metodo encargado de obtener el objeto de domicilio
	 * 
	 * @param datosExpe
	 * @param datosDomicilio
	 * @return
	 */
	DatosIdenExpediente obtenerDatosExpediente(DatosIdenExpediente datosExpe, Object datosDomicilio);
	
	/**
	 * Metodo encargado de realizar la copio de acuse a la ruta de envio y de base de datos
	 * 
	 * @param curp
	 * @param cvAfore
	 * @param folioPadre
	 * @throws IOException
	 */
	void guardarDocumentoAcuseAfore(String curp, String cvAfore, String folioPadre) throws IOException;

	/**
	 * Metodo que consulta igualdad de rfc en mdd
	 * @param entradaModificacion
	 * @param entradaPermanencia
	 * @param datosNoCertificables
	 * @return
	 */
	String obtenerIndicadorRfc(EntradaModificacion entradaModificacion, EntradaPermanencia entradaPermanencia,DatosNoCertificables datosNoCertificables);

	/**
	 * Metodo encargado de validar el tipo de proceso para expediente
	 * 
	 * @param solicitante
	 * @return
	 */
	String obtenerProcesoExpediente(String solicitante);

	/**
	 * metodo que genera objeto para guardado de folio complemento para solicitante
	 * @param entradaSolicitante
	 * @param folioEntrada
	 * @param tipoTrabajador
	 * @param user
	 * @param tipoProceso
	 * @return
	 */
	FolioComplemento obtenerDatosSolicitanteExpediente(EntradaSolicitante entradaSolicitante, Folio folioEntrada,String tipoTrabajador, UsuarioLogin user,String curpTitular);
}