package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.HuellasService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Expediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellasDactilares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaHuellasCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaHuella;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.XmlUtilsImpl;

/**
 * Clase para la implementación de proceso de huellas
 * 
 * @author DBARBOSA
 *
 */
@Service
public class HuellasServiceImpl implements HuellasService {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(HuellasServiceImpl.class);
	
	/**
	 * Mapa para el almacenamiento de folio enviado
	 */
	private Map<String, RespuestaServicio> respuestaFolio = new HashMap<>();
	
	/**
	 * Mapa para el almacenamiento de folio enviado
	 */
	private Map<String, String> respuestaIE = new HashMap<>();
	
	/**
	 * Servicio de Coppel
	 */
	@Autowired
	private CoppelService servicioCoppel;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private RecepcionArchivosService servicioArchivos;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Generador de XML
	 */
	@Autowired
	private XmlUtilsImpl xmlUtileria;
	
	/**
	 * Recepcion Archivos
	 */
	@Value("#{propiedades['ruta.archivos.recepcion']}")
	private String rutaRecepcion;
	
	/**
	 * {@inheritDoc}
	 */
	@Async
	@Override
	public void procesarHuellasRecibidas(UsuarioLogin user, Folio folioHijo, Expediente flagsExpediente, String curp, String clave, HuellasDactilares huellas) {
		RespuestaServicio respuesta = new RespuestaServicio();
		try {
			String cadenaDecodificada;
			if(PdfConstants.COPPEL.equals(user.getAforeUsuario())) {
				logger.info("Respuesta Coppel: {}", flagsExpediente.getBiometricos());
				JsonUtilsImpl<RespuestaHuellasCoppel> peticionJson = new JsonUtilsImpl<>();
				RespuestaHuellasCoppel respuestaCoppel = peticionJson.parseJsonToObject(flagsExpediente.getBiometricos(), RespuestaHuellasCoppel.class);
				logger.info("Peticion respuesta OK {}", respuestaCoppel.toString());
				
				cadenaDecodificada = servicioCoppel.guadarHuellasCoppel(curp, respuestaCoppel, ServiciosConstants.TIPO_HUELLAS_TRABAJADOR, clave);
			} else if(!utileriaValidador.validarObjetoNulo(flagsExpediente)) {
				logger.info("Respuesta Afore Huella {}: {}", user.getAforeUsuario(), flagsExpediente.getBiometricos());
				if(flagsExpediente.getBiometricos().contains("/DATOS/AT")) {
					File archivoZip = new File(flagsExpediente.getBiometricos());
					FileInputStream imageInFile = new FileInputStream(archivoZip);
					byte fileData[] = new byte[(int) archivoZip.length()];
					imageInFile.read(fileData);
					cadenaDecodificada = Base64Utils.encodeToString(fileData);
					imageInFile.close();
					archivoZip.delete();
				} else {
					cadenaDecodificada = URLDecoder.decode(flagsExpediente.getBiometricos(), RegistroUsuarioConstants.UTF_8);
					
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.BIOMETRICO_RESULTADO_BANORTE, "");
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.FIN_RESPUESTA_HUELLAS, "");
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.RESPUESTA_ZIP_HUELLAS, "");
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.RESPUESTA_ZIP_HUELLASB, "");
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.RESPUESTA_SIN_HUELLAS, "");
					cadenaDecodificada = StringUtils.replace(cadenaDecodificada, ExpresionesConstants.RESPUESTA_HUELLAS_LESIONADAS, "");
				}
			} else {
				cadenaDecodificada = obtenerBase64ZipHuellasExcepcion(huellas, curp);
			}
			
//			if(ServiciosConstants.CLAVE_HUELLAS_DIGITALES.equals(clave)) {
//				Folio folioPadre = servicioFolio.consultarFolioHijo(folioHijo.getIdFolioPulssarPadre());
//				servicioExpediente.guardarDocumentoAcuseAfore(curp, user.getAforeUsuario(), folioPadre.getChFolio());
//			}
			
			Archivos objetoArchivo = new Archivos();
			objetoArchivo.setClaveAfore(user.getAforeUsuario());
			objetoArchivo.setFolioTramiteProcesar(folioHijo.getChFolio());
			objetoArchivo.setFolioCliente(folioHijo.getChFolio().substring(NumerosConstants.INT_UNO));
			objetoArchivo.setCurpEmpleado(user.getCurpAgente());
			objetoArchivo.setCurpTrabajador(curp);
			objetoArchivo.setTipoArchivos(clave);
			
			respuesta = servicioArchivos.enviarArchivoRecepcion(folioHijo, objetoArchivo, cadenaDecodificada, ServiciosConstants.RUTA_HUELLA);
		} catch(Exception e) {
			logger.error("Error en el proceso de huellas recibidas", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		respuestaFolio.put(folioHijo.getChFolio(), respuesta);
	}
	
	/**
	 * Obtener el base 64 de las huellas
	 * @param oHuellaDactilar
	 * @return
	 */
	private String obtenerBase64ZipHuellasExcepcion(HuellasDactilares oHuellaDactilar, String curp) throws JAXBException, IOException {
		String huellasZip = "";
		String xmlHuellas = xmlUtileria.convertirObjetoXml(oHuellaDactilar);
		
		String path = new StringBuilder().append(rutaRecepcion).toString();
		String fileXml = new StringBuilder().append(curp).append(ExpresionesConstants.EXTENSION_XML).toString();
		
		File archivoXml = new File(new StringBuilder().append(path).append(fileXml).toString());
		BufferedWriter salidaXml = new BufferedWriter(new FileWriter(archivoXml));
		salidaXml.write(xmlHuellas);
		salidaXml.close();
		
		byte[] bufZip = new byte[(int)archivoXml.length()];
		
		File archivoZip = new File(new StringBuilder().append(path).append(curp).append(ExpresionesConstants.EXTENSION_ZIP).toString());
		FileOutputStream archivoSalidaZip = new FileOutputStream(archivoZip);
		ZipOutputStream zipSalida = new ZipOutputStream(archivoSalidaZip);
		ZipEntry nombreArchivoZip = new ZipEntry(fileXml);
		zipSalida.putNextEntry(new ZipEntry(nombreArchivoZip));
		FileInputStream archivoEntrada = new FileInputStream(archivoXml);
		
		int len;
		while ((len = archivoEntrada.read(bufZip)) > 0) {
			zipSalida.write(bufZip, 0, len);
		}
		archivoEntrada.close();
		zipSalida.closeEntry();
		zipSalida.close();
		
		try (FileInputStream zipHuellasFile = new FileInputStream(archivoZip)) {
			byte fileData[] = new byte[(int) archivoZip.length()];
			zipHuellasFile.read(fileData);
			huellasZip = Base64Utils.encodeToString(fileData);
		} catch (Exception ex) {
			logger.error("Error al leer el archivo de zip de huellas", ex);
		}
		archivoXml.delete();
		archivoZip.delete();
		return huellasZip;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio validarRespuestaFolio(String folio) {
		RespuestaServicio respuesta = null;
		if(respuestaFolio.containsKey(folio)) {
			respuesta = respuestaFolio.get(folio);
			respuestaFolio.remove(folio);
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Async
	@Override
	public void guardarHuellaIE(String cadenaHuellas) {
		try {
			String respuestaCadena = StringUtils.replace(cadenaHuellas, "'", "\"");
			JsonUtilsImpl<SalidaHuella> peticionJson = new JsonUtilsImpl<>();
			SalidaHuella salidaHuella = peticionJson.parseJsonToObject(respuestaCadena, SalidaHuella.class);
			
			if(!salidaHuella.getCadena().contains("SHuellas")) {
				StringBuilder path = new StringBuilder();
				path.append(rutaRecepcion);
				path.append(salidaHuella.getRespuesta());
				path.append(ExpresionesConstants.EXTENSION_ZIP);
				File fArchivo = new File(path.toString());
				FileOutputStream salidaArchivo = new FileOutputStream(fArchivo);
				byte[] decoder = Base64Utils.decodeFromString(salidaHuella.getCadena());
				salidaArchivo.write(decoder);
				logger.info("Archivo almacenado {}", path.toString());
				salidaArchivo.close();
				
				respuestaIE.put(salidaHuella.getRespuesta(), path.toString());
			} else {
				respuestaIE.put(salidaHuella.getRespuesta(), salidaHuella.getRespuesta());
			}
		} catch (IOException ioe) {
			logger.error("Error al guarde el archivo de huellas IE {}", cadenaHuellas, ioe);
		} catch (Exception e) {
			logger.error("Exception en el guardado de de huellas IE {}", cadenaHuellas, e);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validarRespuestaHuellas(String folioCurp) {
		logger.info("Validar huellas IE");
		String valor = "";
		if(respuestaIE.containsKey(folioCurp)) {
			valor = respuestaIE.get(folioCurp);
			respuestaIE.remove(folioCurp);
		}
		return valor;
	}
}
