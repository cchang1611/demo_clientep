package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioComplemento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAlta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;

/**
 * Interface de Recepcion de archivos
 * 
 * @author DBARBOSA
 *
 */
public interface RecepcionArchivosService {
	
	/**
	 * Metodo encargado de genrar zip con archivos 
	 * @param folio
	 * @param arregloArchivos
	 * @param datosRecepcion
	 * @param comboObligatorios
	 * @param fotografia
	 * @return
	 */
	RespuestaServicio verificarArchivos(Folio folio, Map<String, Map<String, MultipartFile>> arregloArchivos, EnvioArchivos datosRecepcion, List<Combo> comboObligatorios, String fotografia);
	
	
	/**
	 * Metodo encargado de generar zip cor archivos digitalizados
	 * @param folio
	 * @param datosRecepcion
	 * @param rutaZip
	 * @return RespuestaServicio
	 */
	RespuestaServicio enviarArchivosDigitalizados(Folio folio, EnvioArchivos datosRecepcion, String rutaZip);
	
	/**
	 * Metodo encargado de guardar datos de folio complementario
	 * @param folio
	 */
	void guardarDatosFolioComplementario(FolioComplemento folio);
	
	/**
	 * Metodo encargado de obtener sub documentos
	 * @param clave
	 * @return
	 */
	public List<String> obtenerParametroSub(String clave);

	/**
	 * Servicio para recepcion de archivos
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param archivos
	 *  @param carpetaMap
	 *  @return
	 */
	public RespuestaAlta capturarArchivos(Archivos archivos, String carpeta, Map<String, String> arregloArchivos);
	/**
	 * Metodo para la recepcion de archivos
	 * @param arregloArchivos
	 * @param datosRecepcion
	 * @param claveSub
	 * @return
	 */
	public RespuestaServicio recepcionarArchivos(Map<String,String> arregloArchivos ,EnvioArchivos datosRecepcion,String claveSub);
	
	/**
	 * Metodo encargado de validar si finalizo correctamente el servicio
	 * 
	 * @param folio
	 * @param tipo
	 * @param afore
	 * @param dato
	 * @param flujo
	 * @param clave
	 * @return
	 */
	RespuestaServicio validarRecepcionArchivo(Folio folio, String tipo, String afore, String dato, String flujo, String clave, FlujoModificacion flujoMod);
	
	/**
	 * Metodo encargado de guardar y enviar la peticion a recepcion de archivos
	 * 
	 * @param archivos
	 * @return
	 */
	RespuestaServicio enviarArchivoRecepcion(Folio folio, Archivos oArchivos, String archivoBase64, String ruta);
	
	/**
	 * Metodo encargado de eliminar directorios o archivos
	 * 
	 * @param borrar
	 */
	void eliminarDirectorio(File borrar);
	
	/**
	 * Metodo encargado de cosnultar informacion de recepcion de archivos
	 * @param folio
	 * @param tipo
	 * @return
	 */
	ArchivoRecibido validarRecepcionArchivoModificacion(Folio folio, String tipo);

	/**
	 * Metodo encargado de genrar zip y regresar base 64 del mismo
	 * @param ruta
	 * @return
	 * @throws FileNotFoundException
	 */
	String generarZip(String ruta) throws FileNotFoundException;

	/**
	 * Metodo encargado de verificar existencia de ruta
	 * @param trabajador
	 * @return
	 */
	String verificarRuta(String curp, String urlRutaExpe);

	/**
	 * Metodo encargado de obtner la respuesta de la recepcion de archivos
	 * 
	 * @param respuesta
	 */
	RespuestaServicio validarRespuestaRecepcionArchivos(RespuestaAlta respuesta, String claveAfore);

	/**
	 * Metodo encargado de consultar la respuesta
	 * @param clave
	 * @param afore
	 * @param flujo
	 * @return
	 */
	RespuestaServicio obtenerRespuesta(String clave, String afore, int flujo);

	/**
	 * Metodo encargado de validar el nombre del archivo de la carpeta de expediente
	 * 
	 * @param oArchivos
	 * @return
	 */
	String obtenerArchivoZipExpediente(Archivos oArchivos, String ruta);

	/**
	 * metodo que valida existencia de recepcion de expedientes por portal
	 * @param curp
	 * @param proceso
	 * @param claveAfore
	 * @param resultadoOperacion
	 * @return
	 */
	ArchivoRecibido validaExistenciaRecepcionExpediente(String curp, String proceso, String claveAfore,String resultadoOperacion);
	
	 /**
	 *  enviarArchivosDigitalizados
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param folio
	 *  @param ruta
	 *  @param datosRecepcion
	 *  @return
	 */
	RespuestaServicio enviarArchivosDigitalizados(Folio folio, String ruta, EnvioArchivos datosRecepcion);
	/**
	 * Metodo encargado de guardar y enviar la peticion a recepcion de archivos
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param folio
	 *  @param oArchivos
	 *  @return
	 */
	RespuestaServicio enviarArchivoRecepcion(Folio folio, Archivos oArchivos);
	
	/**
	 * Metodo para generar ruta para expedientes
	 * @param oArchivos
	 * @param ruta
	 * @return
	 */
	String obtenerArchivoZipExpedienteRuta(Archivos oArchivos, String ruta);
}