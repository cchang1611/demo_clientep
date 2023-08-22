package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivoZipService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CorreoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BiomTrArchivo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaReimpresion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;

/**
 * ReimpresionServiceImpl
 * @author jmordone
 *
 */
@Qualifier("consentimiento")
@Service
public class ReimpresionServiceConsentimientoImpl implements ReimpresionService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ReimpresionServiceConsentimientoImpl.class);

	/**
	 * urlComunes
	 */
	@Value("${uri.comunes}")
	private String urlComunes;
	
	/**
	 * urlComunes
	 */
	@Value("${url.ruta.archivos.consentimiento}")
	private String rutaArchivosConsentimiento;
	
	/**
	 * restServiceClientUtils
	 */
	@Autowired
	private RestServiceClientUtils restServiceClientUtils;
	
	/**
	 * Inyeccion de servicio Correo
	 */
	@Autowired
	private ArchivoZipService archivoZipService;
	
	/**
	 * reimpresionTramitesService
	 */
	@Autowired
	private ReimpresionTramitesService reimpresionTramitesService;
	
	/**
	 * Obtiene lista de rutas de archivos mediante el folio procesar
	 * Nota: Se modifica la extraccion del servicio mediante DeserializationFeature y evitar un array list exception 
	 * cuando existe 
	 * un solo elemento de la lista de entrada
	 * @param folioProcesar
	 * @return
	 */
	
	@Override
	public DatosArchivos obtenerArchivosReimpresion(DatosTrabajador trabajador) throws IOException {
		logger.error("Inicia extracción de archivo consentimiento:: {}",trabajador.getDatosCertificables().getCurp());
		DatosArchivos datosArchivos;
		RespuestaReimpresion respuesta=null;
		List<BiomTrArchivo> archivo = obtenerArchivos(trabajador.getDatosCertificables().getCurp());	
		if(archivo==null ||archivo.isEmpty()) {
			logger.error("No existe ruta de consentimiento:: {}",trabajador.getDatosCertificables().getCurp());
			return reimpresionTramitesService.obtenerMensajeSinDatos();
		}
		logger.error("Se obtiene ruta de consentimiento:: {}",archivo);
		datosArchivos=generarListaArchivosZip(archivo);
		datosArchivos.setFolioProcesar(reimpresionTramitesService.obtenerFolioProcesarPorCurp(trabajador.getDatosCertificables().getCurp(),trabajador.getClaveAfore()));
		if(datosArchivos.getByteArchivo()==null || datosArchivos.getByteArchivo().isEmpty()) {
			logger.error("No existe expediente consentimiento:: {}",trabajador.getDatosCertificables().getCurp());
			return reimpresionTramitesService.obtenerMensajeSinDatos();
		}
		respuesta=reimpresionTramitesService.registraProcesoConcluidoReinpresion(reimpresionTramitesService.llenarTramitesConcluidos(trabajador.getDatosCertificables().getCurp(),
				trabajador.getFolio().getFolio(), trabajador.getClaveAfore(),FormatoConstants.SOLICITANTE_TITULAR));
		if(respuesta!=null && respuesta.getResultadoOperacion().equals(FormatoConstants.RESULTADO_OPERACION_ACEPTADO)) {
			datosArchivos.setIdSegTramite(respuesta.getResultado());
		}
		return datosArchivos;
	}
	
	/**
	 * enviarCorreoReimpresion
	 */
	@Override
	public RespuestaServicio enviarCorreoReimpresion(DatosArchivos datos,DatosTrabajador trabajador,String folioProcesar,Integer modulo,String claveAgente)  {
		String claveDocumento = reimpresionTramitesService.obtenerTipoClaveDocumento(modulo);
		return reimpresionTramitesService.enviarCorreoReimpresion(datos, trabajador, folioProcesar, claveDocumento,CorreoEnum.ARCHIVO_REIMPRESION,claveAgente);	
	}

	/**
	 * obtieneExistenciaCorreoElectronico
	 * @param trabajador
	 * @return
	 */
	@Override
	public RespuestaServicio obtenerExistenciaCorreoElectronico(DatosTrabajador trabajador) {	
		return reimpresionTramitesService.obtenerExistenciaCorreoElectronico(trabajador);
	}
    /**
     * obtenerArchivos
     * @param folioProcesar
     * @return
     */
	private List<BiomTrArchivo> obtenerArchivos(String curp) {
		List<BiomTrArchivo> respuesta = null;
		StringBuilder url= new StringBuilder();
		url.append(urlComunes);
		url.append(ServiciosConstants.CONSULTA_ARCHIVO_BIOMETRICO);
		url.append(curp);
		try {	
		    logger.error("La ruta del llamado del servicio obtenerArchivosConsentimiento :: {}",url);
		    respuesta = restServiceClientUtils.ejecutarServicioGetObjetosList(url.toString(), BiomTrArchivo.class);
		
		} catch (Exception e) {
			throw new BusinessException("Existe en la obtencion del servicio : obtenerArchivos",e);
		}
		return respuesta;
	}
	
	/**
	 * generarListaArchivosZip
	 * @param listaRutasDeArchivoPorServicio
	 * @return
	 * @throws IOException
	 */
	private DatosArchivos generarListaArchivosZip(List<BiomTrArchivo> listaRutasDeArchivoPorServicio) throws IOException {
		List<DatosArchivos> listaDeArchivosExtraidosPorZipOFilenet=new ArrayList<>();
		for (BiomTrArchivo archivoRecibido : listaRutasDeArchivoPorServicio) {
			listaDeArchivosExtraidosPorZipOFilenet= listaDeArchivosExtraidos(archivoRecibido);	
		}
		return reimpresionTramitesService.obtenerPdfPorClave(listaDeArchivosExtraidosPorZipOFilenet,MenuReimpresionEnum.CONSENTIMENTO_ENROLAMIENTO.getIdMenuReimpresion()); 			
	}
	
	/**
	 * listaDeArchivosExtraidos
	 * @param archivoRecibido
	 * @return
	 * @throws IOException
	 */
	private List<DatosArchivos> listaDeArchivosExtraidos (BiomTrArchivo archivoRecibido) throws IOException {
		 StringBuilder rutaArchivoCompleta= new StringBuilder();
		 String segundaRuta="";
		 try {
			 rutaArchivoCompleta.append(rutaArchivosConsentimiento);
			 rutaArchivoCompleta.append(archivoRecibido.getChNombreArchivo());
			 logger.error("Se obtiene primera ruta de consentimiento:: {}",rutaArchivoCompleta.toString());
			 return obtenerArchivo(rutaArchivoCompleta);
		 }catch(GenericException e) {
			 logger.error("Error al obtener primera ruta de consentimiento :: {}",e);
			 try {
				 rutaArchivoCompleta= new StringBuilder();
				 segundaRuta=archivoRecibido.getChNombreArchivo().replace(FormatoConstants.FS_PROCESADO, FormatoConstants.RUTA_ARCHIVO_CONSENTIMIENTO2);
				 rutaArchivoCompleta.append(rutaArchivosConsentimiento);
				 rutaArchivoCompleta.append(segundaRuta);
				 logger.error("Se obtiene segunda ruta de consentimiento:: {}",rutaArchivoCompleta.toString());
				 return obtenerArchivo(rutaArchivoCompleta);
			 }catch(Exception error) {
				 throw new BusinessException("Existe un error en la apertura del zip",error);
			 }		 
		 } 
	}
	
	/**
	 * Obtiene los archivos de consentimiento
	 * @param rutaArchivoCompleta
	 * @return
	 * @throws IOException
	 */
	private  List<DatosArchivos> obtenerArchivo(StringBuilder rutaArchivoCompleta) throws IOException {		 
		 ZipInputStream zipInput = archivoZipService.abrirZipConsentimiento(rutaArchivoCompleta.toString());
		 return archivoZipService.listar(zipInput);
	}
	
}
