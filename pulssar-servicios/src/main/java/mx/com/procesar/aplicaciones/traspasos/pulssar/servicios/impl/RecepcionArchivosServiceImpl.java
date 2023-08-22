package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerValorMapaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ArchivosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioComplemento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAlta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CompresorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Implementacion de la peticion de la recepcion de archivos para los
 * expedientes
 * 
 * @author DBARBOSA
 *
 */
@Service
public class RecepcionArchivosServiceImpl implements RecepcionArchivosService {
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RecepcionArchivosServiceImpl.class);

	/**
	 * Ruta url servicio sms
	 */
	@Value("${url.recepcion.archivos}")
	private String urlRecepcionArchivos;

	/**
	 * Ruta url de carpeta de expediente
	 */
	@Value("${ruta.carpeta.expediente}")
	private String urlRutaExpedientes;

	/**
	 * Inyeccion de rest
	 */
	@Autowired
	private RestTemplate servicioCliente;

	/**
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;

	/**
	 * Inyeccion de utileria compresor
	 */
	@Autowired
	private CompresorUtils utileriaCompresor;

	/**
	 * Inyeccion de utileria compresor
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private FechaUtils utileriaFecha;

	/**
	 * Id cliente
	 */
	@Value("#{propiedades['archivos.idCliente']}")
	private String idCliente;

	/**
	 * Id servicio
	 */
	@Value("#{propiedades['archivos.idServicio']}")
	private String idServicio;

	/**
	 * Id business
	 */
	@Value("#{propiedades['archivos.idEbusiness']}")
	private String idEbusiness;

	/**
	 * Tipo de autenticacion
	 */
	@Value("#{propiedades['autenticacion.archivos.autenticacion']}")
	private String tipoAutenticacion;

	/**
	 * Usuario
	 */
	@Value("#{propiedades['autenticacion.archivos.usuario']}")
	private String usuarioArchivos;

	/**
	 * Password
	 */
	@Value("#{propiedades['autenticacion.archivos.password']}")
	private String passwordArchivos;

	/**
	 * Ruta url de carpeta de expediente
	 */
	@Value("#{propiedades['ruta.folio.complementario']}")
	private String urlRutaFolioComplementario;

	/**
	 * Catalogo de servicio
	 */
	@Autowired
	private CatalogoService servicioCatalogo;

	/**
	 * Inyeccion recorrerListadoMapaService
	 */
	@Autowired
	private ObtenerValorMapaService recorrerListadoMapaService;

	/**
	 * Variable consulta Recepcion arcvhios
	 */
	@Value("#{propiedades['url.consulta.archivo.recepcion']}")
	private String consultaRecepcionArchivo;

	/**
	 * Usuario
	 */
	@Value("#{propiedades['ruta.archivos.recepcion']}")
	private String rutaRecepcion;

	/**
	 * Usuario
	 */
	@Autowired
	private FolioService servicioFolio;
	
	/**
	 * Usuario
	 */
	@Value("#{propiedades['url.consulta.diagnostico.biom']}")
	private String urlConsultaDiagnosticoBiom;
	
	/**
	 * url consulta servicio recepcion expediente generado portal
	 */
	@Value("#{propiedades['url.consulta.recepcion.expediente.portal']}")
	private String urlRecepcionExpedientePortal;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio verificarArchivos(Folio folio, Map<String, Map<String, MultipartFile>> archivos,
			EnvioArchivos datosRecepcion, List<Combo> comboObligatorios, String fotografia) {
		logger.info("Se contruye la peticion de archivo {}, {}, {}", datosRecepcion.getTipoArchivo(),
				datosRecepcion.getCurpTrabajador(), datosRecepcion.getCurpEmpleado());
		RespuestaServicio respuestaServicio = null;
		try {
			String ruta = this.verificarRuta(datosRecepcion.getCurpTrabajador(), urlRutaExpedientes);
			String fecha = utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_ARCHIVOS);

			for (Combo docs : comboObligatorios) {
				int i = 1;
				if (!utileriaValidador.validarListaVacia(docs.getSubDocumentos())) {
					for (Combo subDocs : docs.getSubDocumentos()) {
						Map<String, MultipartFile> auxiliarValue = archivos.get(subDocs.getClave());
						if (!ObjectUtils.isEmpty(auxiliarValue))
							i = this.armarArchivo(auxiliarValue, subDocs.getClave(), subDocs.getClaveDocumento(), ruta,
									fecha, datosRecepcion, i);
					}
				} else {
					Map<String, MultipartFile> auxiliarValue = archivos.get(docs.getClave());
					if (!ObjectUtils.isEmpty(auxiliarValue))
						i = this.armarArchivo(auxiliarValue, docs.getClave(), docs.getClaveDocumento(), ruta, fecha,
								datosRecepcion, i);
				}
			}
			if(!utileriaValidador.isEmpty(fotografia)){
				armarArchivo(fotografia, "31", ruta, fecha, datosRecepcion);
			}

			String resultado = this.generarZip(ruta);
			this.eliminarDirectorio(new File(ruta));
			this.eliminarDirectorio(
					new File(utileriaCadena.obtenerCadenaConcatenada(true, ruta, ExpresionesConstants.EXTENSION_ZIP)));

			Archivos objetoArchivo = new Archivos();
			objetoArchivo.setClaveAfore(datosRecepcion.getClaveAfore());
			objetoArchivo.setFolioTramiteProcesar(datosRecepcion.getFolio());
			objetoArchivo.setCurpEmpleado(datosRecepcion.getCurpEmpleado());
			objetoArchivo.setCurpTrabajador(datosRecepcion.getCurpTrabajador());
			objetoArchivo.setTipoArchivos(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
			objetoArchivo.setTipoExpediente(datosRecepcion.getProceso());

			respuestaServicio = this.enviarArchivoRecepcion(folio, objetoArchivo, resultado,
					ServiciosConstants.RUTA_EXPEDIENTE);
		} catch (FileNotFoundException fnfe) {
			logger.error("Ocurrio FileNotFoundException", fnfe);
			respuestaServicio = this.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		} catch (IOException ioe) {
			logger.error("Ocurrio IOException", ioe);
			respuestaServicio = this.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		} catch (GenericException ge) {
			logger.error("Ocurrio IOException", ge);
			respuestaServicio = this.obtenerRespuesta(ge.getCodigo(), datosRecepcion.getClaveAfore(),
					NumerosConstants.INT_DOS);
		}
		return respuestaServicio;
	}

	/**
	 * Metodo encargado de armar el arcvhio para el zip
	 * 
	 * @param auxiliarValue
	 * @param auxiliar
	 * @param clave
	 * @param ruta
	 * @param fecha
	 * @param datosRecepcion
	 * @param contador
	 * @return
	 * @throws IOException
	 */
	private int armarArchivo(Map<String, MultipartFile> auxiliarValue, String auxiliar, String clave, String ruta,
			String fecha, EnvioArchivos datosRecepcion, int contador) throws IOException {
		String nombreArchivo = utileriaCadena.obtenerCadenaConcatenada(true, auxiliar);
		MultipartFile archivo = auxiliarValue.get(nombreArchivo);
		if (!utileriaValidador.validarObjetoNulo(archivo)) {
			String extension = FilenameUtils.getExtension(archivo.getOriginalFilename());
			String folio = datosRecepcion.getFolioIdentificacion();
			if (!StringUtils.isEmpty(folio) && folio.length() > 3) {
				folio = folio.substring(datosRecepcion.getFolioIdentificacion().length() - 3);
			}
			String renombre = utileriaCadena.obtenerCadenaConcatenada(true, datosRecepcion.getClaveAfore(),
					datosRecepcion.getProceso(), datosRecepcion.getCurpTrabajador(), datosRecepcion.getTipoTrabajador(),
					clave, String.valueOf(contador), fecha, folio, AgenteConstants.PUNTO, extension.toLowerCase());
			logger.info(renombre);
			File rutaSalida = new File(
					utileriaCadena.obtenerCadenaConcatenada(true, ruta, ActivacionConstants.DIAGONAL, renombre));
			FileOutputStream salida = new FileOutputStream(rutaSalida);
			salida.write(archivo.getBytes());
			salida.close();
			contador++;
		}
		return contador;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio obtenerRespuesta(String clave, String afore, int flujo) {
		return servicioCatalogo.obtenerRespuesta(null, clave, afore, flujo, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio validarRespuestaRecepcionArchivos(RespuestaAlta respuesta, String claveAfore) {
		if (utileriaValidador.validarObjetoNulo(respuesta)) {
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		if (ServiciosConstants.RESULTADO_NOK.equals(respuesta.getResultadoOperacion())) {
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}

		return this.obtenerRespuesta(MensajesExitoEnum.EXPEDIENTE_ENVIADO.getClave(), claveAfore,
				NumerosConstants.INT_UNO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void guardarDatosFolioComplementario(FolioComplemento folio) {
		try {
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON_UTF8);

			JsonUtilsImpl<FolioComplemento> jsonEntrada = new JsonUtilsImpl<>();
			String resultadoJson = jsonEntrada.parseObjectToJsonSC(folio);
			logger.info("Entrada  servicio: {}", resultadoJson);
			HttpEntity<String> entidadRegistro = new HttpEntity<>(resultadoJson, headerMedia);
			ResponseEntity<String> respuesta = servicioCliente.exchange(urlRutaFolioComplementario, HttpMethod.POST,
					entidadRegistro, String.class);
			logger.info("respuesta de registro de datos folio complementario {}", respuesta.getStatusCode());
		} catch (Exception e) {
			logger.error("Se presento un error en captura de datos folioComplementario, ", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generarZip(String ruta) throws FileNotFoundException {
		File carpeta = new File(ruta);
		String parent = carpeta.getPath();
		String nuevoParent = parent.replace("\\\\", "\\\\\\\\");
		String destino = utileriaCadena.obtenerCadenaConcatenada(true, nuevoParent, ExpresionesConstants.EXTENSION_ZIP);
		byte[] resultadoZip = utileriaCompresor.comprimirCarpeta(nuevoParent, destino);
		return Base64Utils.encodeToString(resultadoZip);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String verificarRuta(String curp, String urlRutaExpe) {
		File ruta = null;
		ruta = new File(
				utileriaCadena.obtenerCadenaConcatenada(false, urlRutaExpe, ActivacionConstants.DIAGONAL, curp));
		logger.info("Ruta Expe :: {}", ruta);
		this.eliminarDirectorio(ruta);
		ruta.mkdir();
		return ruta.toString();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param borrar
	 */
	@Override
	public void eliminarDirectorio(File borrar) {
		if (borrar.isDirectory()) {
			try {
				for (File listFile : borrar.listFiles()) {
					if (listFile.isFile()) {
						listFile.delete();
						listFile.deleteOnExit();
					} else {
						if (listFile.isDirectory()) {
							eliminarDirectorio(listFile);
							listFile.delete();
							listFile.deleteOnExit();
						}
					}
				}
			} catch (NullPointerException e) {
				logger.error("Se presento un error al eliminar el directorio", e);
			}
		}
		borrar.delete();
		borrar.deleteOnExit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaAlta capturarArchivos(Archivos archivos, String carpeta, Map<String, String> arregloArchivos) {
		try {
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			headerMedia.add("idCliente", idCliente);
			headerMedia.add("idServicio", idServicio);
			headerMedia.add("idEbusiness", idEbusiness);

			JsonUtilsImpl<Archivos> jsonEntrada = new JsonUtilsImpl<>();
			String resultadoJson = jsonEntrada.parseObjectToJsonSC(archivos);
			logger.info(resultadoJson);

			HttpEntity<String> entidadConsulta = new HttpEntity<>(resultadoJson, headerMedia);

			logger.info("Se ejecuta la recepcion de archivos {}, {}, {}", archivos.getCurpTrabajador(),
					archivos.getTipoArchivos(), archivos.getTipoExpediente());

			ResponseEntity<String> resultadoArchivos = servicioCliente.exchange(urlRecepcionArchivos, HttpMethod.POST,
					entidadConsulta, String.class);
			logger.info("La respuesta al servicio {} ", resultadoArchivos);
			if (!utileriaValidador.validarVacio(resultadoArchivos.getBody())) {
				logger.info("La respuesta al servicio {} {} {}", archivos.getCurpTrabajador(),
						archivos.getTipoArchivos(), resultadoArchivos.getBody());
				JsonUtilsImpl<RespuestaAlta> resultado = new JsonUtilsImpl<>();
				RespuestaAlta respuesta = resultado.parseJsonToObject(resultadoArchivos.getBody(), RespuestaAlta.class);
				return respuesta;
			}
		} catch (Exception e) {
			logger.error("Se presento un problema en el servicio de recepcion de archivos {}", urlRecepcionArchivos, e);

			recorrerListadoMapaService.borrarDirectorio(new File(carpeta));
			recorrerListadoMapaService.borrarDirectorio(new File(
					utileriaCadena.obtenerCadenaConcatenada(true, carpeta, ExpresionesConstants.EXTENSION_ZIP)));
			recorrerListadoMapaService.recorrerListadoMapa(arregloArchivos);

			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return null;
	}

	/**
	 * Obtiene parametro sub documentos
	 */
	@Override
	public List<String> obtenerParametroSub(String clave) {
		String parametroSubDocumentos = ServiciosConstants.PARAMETRO_SUBDOCUMENTOS;
		List<Parametro> listaParametro = null;
		List<String> lista = null;
		try {
			listaParametro = servicioCatalogo.obtenerParametro(parametroSubDocumentos, "");
			lista = utileriaValidador.obtenerListaChParametro(listaParametro, clave, Arrays.asList(""));
			logger.info(lista.toString());
		} catch (Exception e) {
			logger.error("error al obtener parametro de subDocumentos ", e);
		}
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * RecepcionArchivosService#recepcionarArchivos(java.util.Map,
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * EnvioArchivos, java.lang.String)
	 */
	@Override
	public RespuestaServicio recepcionarArchivos(Map<String, String> arregloArchivos, EnvioArchivos datosRecepcion,
			String claveSub) {
		logger.info("Se contruye la peticion de archivo arregloArchivos: datosRecepcion: {}, {}", arregloArchivos,
				datosRecepcion);
		RespuestaServicio respuestaServicio = null;
		OutputStream output = null;
		InputStream input = null;
		String carpeta = null;
		String archivoNombre = null;
		String nombreArchivoPdf = null;
		try {

			for (Map.Entry<String, String> entry : arregloArchivos.entrySet()) {

				nombreArchivoPdf = entry.getValue();
				logger.info("nombrePdf:{}", nombreArchivoPdf);

				carpeta = new StringBuilder().append(urlRutaExpedientes).append(File.separator)
						.append(datosRecepcion.getCurpTrabajador()).toString();
				File directorio = new File(carpeta);
				directorio.mkdir();
				logger.info("existe carpeta?: {}", directorio.exists());
				logger.info("carpeta:{}", directorio);
				String origenFile = new StringBuilder().append(urlRutaExpedientes).append(File.separator)
						.append(nombreArchivoPdf).toString();
				logger.info("origenFile: {}", origenFile);
				// Ruta Origen
				File archivoOrigen = new File(origenFile);
				logger.info("archivoOrigen: {}", archivoOrigen);
				String destinoFile = carpeta;
				logger.info("destinoFile: {}", destinoFile);
				archivoNombre = new StringBuilder().append(urlRutaExpedientes).append(File.separator)
						.append(datosRecepcion.getCurpTrabajador()).append("/").append(nombreArchivoPdf).toString();
				logger.info("archivoNombre:{}", archivoNombre);
				File archivoDestino = new File(carpeta);
				logger.info("archivoDestino: {}", archivoDestino);
				try{
					input = new FileInputStream(archivoOrigen);
					output = new FileOutputStream(archivoNombre);
					byte[] buffer = new byte[1024];
					int length;
					while ((length = input.read(buffer)) > 0) {
						output.write(buffer, 0, length);
					}
				} catch(Exception e){
					logger.error("error en el stream", e);
				}finally{
					if(input != null){
						input.close();
					}
					if(output != null){
						output.close();
					}
				}
			}

			String resultado;
			resultado = this.generarZip(carpeta);
			Archivos objetoArchivo = new Archivos();
			objetoArchivo.setClaveAfore(datosRecepcion.getClaveAfore());
			objetoArchivo.setFolioTramiteProcesar(datosRecepcion.getFolio());
			objetoArchivo.setContenidoArchivo(resultado);
			objetoArchivo.setCurpEmpleado(datosRecepcion.getCurpEmpleado());
			objetoArchivo.setCurpTrabajador(datosRecepcion.getCurpTrabajador());
			objetoArchivo.setTipoArchivos(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
			objetoArchivo.setTipoExpediente(datosRecepcion.getTipoExpediente());
			objetoArchivo.setFolioCliente(datosRecepcion.getFolioProcesar());

			RespuestaAlta respuesta = this.capturarArchivos(objetoArchivo, carpeta, arregloArchivos);

			recorrerListadoMapaService.borrarDirectorio(new File(carpeta));
			recorrerListadoMapaService.borrarDirectorio(new File(
					utileriaCadena.obtenerCadenaConcatenada(true, carpeta, ExpresionesConstants.EXTENSION_ZIP)));
			recorrerListadoMapaService.recorrerListadoMapa(arregloArchivos);

			respuestaServicio = this.validarRespuestaRecepcionArchivos(respuesta, datosRecepcion.getClaveAfore());
			logger.info("Respuesta Servicio:{}", respuestaServicio);
		} catch (FileNotFoundException fnfe) {
			logger.error("Ocurrio FileNotFoundException", fnfe);
			respuestaServicio = this.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		} catch (IOException ioe) {
			logger.error("Ocurrio IOException", ioe);
			respuestaServicio = this.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		} catch (GenericException ge) {
			logger.error("Ocurrio GenericException", ge);
			respuestaServicio = this.obtenerRespuesta(ge.getCodigo(), datosRecepcion.getClaveAfore(),
					NumerosConstants.INT_DOS);
		}

		return respuestaServicio;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio validarRecepcionArchivo(Folio folio, String tipo, String afore, String bucle, String flujo,
			String clave, FlujoModificacion flujoMod) {
		RespuestaServicio respuestaServicio = new RespuestaServicio();
		try {
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> entidadValidacion = new HttpEntity<>(headerMedia);

			String url = consultaRecepcionArchivo;
			url = url.replace("{foliopulssar}", folio.getChFolio());
			url = url.replace("{tipoArchivo}", tipo);
			respuestaServicio.setFlujo(NumerosConstants.INT_TRES);
			logger.info("Peticion de validacion de archivo {}", url);
			ResponseEntity<ArchivoRecibido> respuesta = servicioCliente.exchange(url, HttpMethod.GET, entidadValidacion,
					ArchivoRecibido.class);
			if (!utileriaValidador.validarObjetoNulo(respuesta.getBody())) {
				logger.info(respuesta.getBody().toString());
				ArchivoRecibido archivoRecepcion = respuesta.getBody();
				if (ServiciosConstants.RESULTADO_NOK.equals(archivoRecepcion.getResultadoOperacion())) {
					respuestaServicio = servicioCatalogo.obtenerRespuesta(null,
							BusinessErrorEnum.SOLICITUD_RECHAZADA.getClave(), afore, NumerosConstants.INT_DOS, null);
					RespuestaServicio cambiomensaje = cambiarMensaje(respuestaServicio.getMensaje(), archivoRecepcion.getDiagnostico(), afore, archivoRecepcion.getMotivoRechazo());
					respuestaServicio.setMensaje(cambiomensaje.getMensaje());
					respuestaServicio.setDatos(archivoRecepcion.getDiagnostico());
					if(utileriaValidador.validarObjetoNulo(flujoMod)) {
						servicioFolio.cerrarFolio(folio.getIdFolioPulssar(), NumerosConstants.INT_DOS, 
								archivoRecepcion.getDiagnostico());
					} else {
						flujoMod.setRespuesta(cambiomensaje);
					}
				} else {
					if (flujo.equals(archivoRecepcion.getEtapa().getClave())) {
						respuestaServicio = servicioCatalogo.obtenerRespuesta(null, clave, afore,
								NumerosConstants.INT_UNO, null);
						if(utileriaValidador.validarObjetoNulo(flujoMod)) {
							servicioFolio.cerrarFolio(folio.getIdFolioPulssar(), NumerosConstants.INT_TRES);
						}
					} else {
						Integer valorDatos = Integer.parseInt(bucle);
						if (valorDatos != NumerosConstants.INT_TRES) {
							valorDatos++;
							respuestaServicio.setDatos(valorDatos.toString());
						} else {
							respuestaServicio = servicioCatalogo.obtenerRespuesta(null,
									MensajesExitoEnum.PROCESO_PENDIENTE_EXPEDIENTE.getClave(), afore,
									NumerosConstants.INT_CUATRO, null);
							if(utileriaValidador.validarObjetoNulo(flujoMod)) {
								servicioFolio.cerrarFolio(folio.getIdFolioPulssar(), NumerosConstants.INT_UNO);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			respuestaServicio.setDatos(bucle);
			logger.error("Se presento un problema en la consulta del folio {} y tipo de archivo {}", folio, tipo, e);
		}

		return respuestaServicio;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio enviarArchivoRecepcion(Folio folio, Archivos oArchivos, String archivoBase64,
			String ruta) {
		RespuestaServicio respuesta = new RespuestaServicio();
		String nombreZip = this.obtenerArchivoZipExpediente(oArchivos, ruta);
		File fArchivo = new File(nombreZip);
		try (FileOutputStream salidaArchivo = new FileOutputStream(fArchivo);) {
			byte[] decoder = Base64Utils.decodeFromString(archivoBase64);
			salidaArchivo.write(decoder);
			logger.info("Archivo almacenado {}", nombreZip);
			salidaArchivo.close();
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			oArchivos.setContenidoArchivo(nombreZip);

			RespuestaAlta archivosEnviados = this.capturarArchivos(oArchivos, nombreZip, null);
			if (utileriaValidador.validarObjetoNulo(archivosEnviados)) {
				this.eliminarDirectorio(fArchivo);
				throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
			}
			if (ServiciosConstants.RESULTADO_NOK.equals(archivosEnviados.getResultadoOperacion())) {
				logger.info("La respuesta del envio de archivos fue rechazada {}", oArchivos.toString());
				throw new BusinessException(BusinessErrorEnum.SOLICITUD_RECHAZADA, archivosEnviados.getMotivoRechazo());
			}
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.SOLICITUD_EN_PROCESO.getClave(),
					oArchivos.getClaveAfore(), NumerosConstants.INT_UNO, null);
		} catch (IOException ioe) {
			logger.error("Error al construir el archivo {}", nombreZip, ioe);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					oArchivos.getClaveAfore(), NumerosConstants.INT_DOS, null);
			this.eliminarDirectorio(fArchivo);
		} catch (GenericException ge) {
			logger.error("Error en el servicio de enviar archivo {}", nombreZip, ge);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					oArchivos.getClaveAfore(), NumerosConstants.INT_DOS, null);
		} catch (BusinessException be) {
			logger.error("Business Excepcion de recepion de archivo {} {}", nombreZip, be.getCodigo(), be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.SOLICITUD_RECHAZADA.getClave(),
					oArchivos.getClaveAfore(), NumerosConstants.INT_DOS, null);
			RespuestaServicio res = cambiarMensaje(respuesta.getMensaje(), be.getCodigo(), oArchivos.getClaveAfore(), null);
			respuesta.setMensaje(res.getMensaje());
			servicioFolio.cerrarFolio(folio.getIdFolioPulssar(), NumerosConstants.INT_DOS, be.getCodigo());
		}

		return respuesta;
	}
	
	/**
	 * Metodo encargado de validar el mesaje de rechazo de expediente
	 * 
	 * @param mensaje
	 * @param codigo
	 * @param cvAfore
	 * @return
	 */
	private RespuestaServicio cambiarMensaje(String mensaje, String codigo, String cvAfore, String motivo) {
		RespuestaServicio respuestamensaje = new RespuestaServicio();
		List<String> rechazos = new ArrayList<>();
		rechazos.add(ModificacionTrabajadorConstants.RECHAZO_MESA_CONTROL);
		rechazos.add(ModificacionTrabajadorConstants.RECHAZO_RIESGO_ALTO_IMAGENES);
		if(rechazos.contains(codigo)) {
			String nuevomotivo = utileriaCadena.obtenerCadenaConcatenada(true, "E", codigo);
			if(!utileriaValidador.validarVacio(motivo)) {
				nuevomotivo = motivo;
			}
			respuestamensaje = servicioCatalogo.obtenerRespuesta(null, nuevomotivo, cvAfore, NumerosConstants.INT_DOS, null);
		} else {
			String mensajeBiom = obtenerMensajeBiometrico(codigo);
			respuestamensaje.setTitulo("Solicitud rechazada");
			if(ExpresionesConstants.VACIO.equals(mensajeBiom)) {
				respuestamensaje.setMensaje(StringUtils.replace(mensaje, "{rechazo}", codigo));
			} else {
				respuestamensaje.setMensaje(mensajeBiom);
			}
		}
		return respuestamensaje;
	}
	
	/**
	 * Metodo encargado de obtener el menasje de biometrico
	 * 
	 * @param codigo
	 * @return
	 */
	private String obtenerMensajeBiometrico(String codigo) {
		String valorCodigo = "";
		try {
			String url = utileriaCadena.obtenerCadenaConcatenada(true, urlConsultaDiagnosticoBiom, codigo);
			logger.info("Peticion diagnostico: {}", url);
			String resultadoArchivos = servicioCliente.getForObject(url, String.class);
			
			JsonUtilsImpl<Combo> jsonError = new JsonUtilsImpl<>();
			List<Combo> comboError = jsonError.parseJsonToObjectList(resultadoArchivos, Combo.class);
			if(!utileriaValidador.validarListaVacia(comboError)) {
				valorCodigo = comboError.get(NumerosConstants.INT_CERO).getDescripcion();
			}
		} catch(Exception e) {
			logger.error("Error al consultar el diagnostico de biometrico", e);
		}
		return valorCodigo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerArchivoZipExpediente(Archivos oArchivos, String ruta) {
		String nombre = this.obtenerNombreArchivo(oArchivos);
		String valor = servicioCatalogo.consultaValorParametro(ActivacionConstants.PARAMETRO_RUTA_ARCHIVOS_EXPEDIENTE, ActivacionConstants.PARAMETRO_CLAVE_RUTA_ARCHIVOS_EXPEDIENTE);
		valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_AFORE, oArchivos.getClaveAfore());
		logger.info("Guardado de zip expediente: {} :: {}", valor, oArchivos.getTipoArchivos());
		if(ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_1.equals(oArchivos.getTipoArchivos()) || ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_4.equals(oArchivos.getTipoArchivos())) {
			String archivo = StringUtils.replace(oArchivos.getTipoArchivos(), NumerosConstants.C_CERO, "X");
			valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, archivo);
		} if(oArchivos.getTipoExpediente() != null && !oArchivos.getTipoExpediente().isEmpty()) {
			valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, oArchivos.getTipoExpediente());
		} else {
			valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, ArchivosEnum.EXPEDIENTE_BIOMETRICO.getNombreArchivo());
		}
		
		logger.info("Ruta archivoZip {}", valor);
		String rutaExpediente = utileriaCadena.obtenerCadenaConcatenada(true, valor, nombre);
		logger.info("Ruta expediente {}", rutaExpediente);

		File fArchivo = new File(rutaExpediente);
		if (fArchivo.exists()) {
			rutaExpediente = this.obtenerNombreArchivo(oArchivos);
		}

		return rutaExpediente;
	}

	/**
	 * Metodo encargado de obtener el nombre del archivo
	 * 
	 * @param objetoArchivo
	 * @return
	 */
	private String obtenerNombreArchivo(Archivos archivos) {
		Calendar calendario = Calendar.getInstance(new Locale(FormatoConstants.LOCALE_ES, FormatoConstants.CIUDAD_MX));
		long fecha = calendario.getTimeInMillis();

		String tipoArchivo = utileriaValidador.validarVacio(archivos.getTipoArchivos())
				? ServiciosConstants.VALOR_SERVICIO_00
				: archivos.getTipoArchivos();

		String tipoExpedienteNombre = archivos.getTipoExpediente();
		if (ArchivosEnum.ENROLAMIENTO_TRABAJADOR.getNombreArchivo().equals(tipoArchivo)) {
			tipoExpedienteNombre = ArchivosEnum.EXPEDIENTE_BIOMETRICO.getNombreArchivo();
		} else if (ArchivosEnum.VERIFICACION_EMPLEADO.getNombreArchivo().equals(tipoArchivo)
				|| ArchivosEnum.VERIFICACION_TRABAJADOR_4_HUELLAS.getNombreArchivo().equals(tipoArchivo)) {
			tipoExpedienteNombre = ServiciosConstants.VALOR_SERVICIO_00;
		}

		return utileriaCadena.obtenerCadenaConcatenada(true, archivos.getClaveAfore(),
				archivos.getFolioTramiteProcesar(), archivos.getCurpEmpleado(),
				utileriaCadena.obtenerContenidoCadenaSinEspacios(archivos.getCurpTrabajador(),
						ExpresionesConstants.VACIO),
				tipoArchivo, tipoExpedienteNombre, utileriaCadena
						.obtenerContenidoCadenaSinEspacios(archivos.getFolioCliente(), ExpresionesConstants.VACIO),
				String.valueOf(fecha), ExpresionesConstants.EXTENSION_ZIP);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArchivoRecibido validarRecepcionArchivoModificacion(Folio folio, String tipo) {
		ArchivoRecibido respuesta = null;
		try {

			String url = consultaRecepcionArchivo;
			url = url.replace("{foliopulssar}", folio.getChFolio());
			url = url.replace("{tipoArchivo}", tipo);

			logger.info("Peticion de validacion de archivo {}", url);
			respuesta = servicioCliente.getForObject(url, ArchivoRecibido.class);
			logger.info(
					"Respuesta consulta archivo para modificacion de datos :: validarRecepcionArchivoModificacion: {}",
					respuesta);

		} catch (Exception e) {
			logger.error("Se presento un problema en la consulta del folio {} y tipo de archivo {}", folio, tipo, e);
		}

		return respuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * RecepcionArchivosService#enviarArchivosDigitalizados(mx.com.procesar.
	 * aplicaciones.traspasos.pulssar.servicios.modelo.Folio,
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * EnvioArchivos)
	 */
	@Override
	public RespuestaServicio enviarArchivosDigitalizados(Folio folio, EnvioArchivos datosRecepcion, String rutaZip) {
		logger.info("Inicio - enviarArchivosDigitalizados");
		logger.info("datosRecepcion: {}",datosRecepcion);
		RespuestaServicio respuestaServicio = null;
		
		try {

			Archivos objetoArchivo = new Archivos();
			objetoArchivo.setClaveAfore(datosRecepcion.getClaveAfore());
			objetoArchivo.setFolioTramiteProcesar(datosRecepcion.getFolio());
			objetoArchivo.setCurpEmpleado(datosRecepcion.getCurpEmpleado());
			objetoArchivo.setCurpTrabajador(datosRecepcion.getCurpTrabajador());
			objetoArchivo.setTipoArchivos(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
			objetoArchivo.setTipoExpediente(datosRecepcion.getProceso());
			objetoArchivo.setContenidoArchivo(rutaZip);

			respuestaServicio = ejecutarRecepcionArchivo(folio, objetoArchivo, rutaZip);
			
		} catch (FileNotFoundException fnfe) {
			logger.error("Ocurrio FileNotFoundException", fnfe);
			respuestaServicio = this.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		} catch (IOException ioe) {
			logger.error("Ocurrio IOException", ioe);
			respuestaServicio = this.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		} catch (GenericException ge) {
			logger.error("Ocurrio IOException", ge);
			respuestaServicio = this.obtenerRespuesta(ge.getCodigo(), datosRecepcion.getClaveAfore(),
					NumerosConstants.INT_DOS);
		}
		return respuestaServicio;
	}
	
	/**
	 * Arma el archivo apartir de la fotografia cargada en base64
	 * @param valor
	 * @param clave
	 * @param ruta
	 * @param fecha
	 * @param datosRecepcion
	 * @throws IOException
	 */
	private void armarArchivo(String valor, String clave, String ruta,
			String fecha, EnvioArchivos datosRecepcion) throws IOException {
			String folio = datosRecepcion.getFolioIdentificacion();
			if (!StringUtils.isEmpty(folio) && folio.length() > 3) {
				folio = folio.substring(datosRecepcion.getFolioIdentificacion().length() - 3);
			}
			String renombre = utileriaCadena.obtenerCadenaConcatenada(true, datosRecepcion.getClaveAfore(),
					datosRecepcion.getProceso(), datosRecepcion.getCurpTrabajador(), datosRecepcion.getTipoTrabajador(),
					clave, "1", fecha, folio, AgenteConstants.PUNTO, "PNG");
			logger.info(renombre);
			File rutaSalida = new File(
					utileriaCadena.obtenerCadenaConcatenada(true, ruta, ActivacionConstants.DIAGONAL, renombre));
			FileOutputStream salida = new FileOutputStream(rutaSalida);
			salida.write(DatatypeConverter.parseBase64Binary(valor));
			salida.close();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArchivoRecibido validaExistenciaRecepcionExpediente(String curp,String proceso,String claveAfore,String resultadoOperacion) {
		logger.info("entrada validaExistenciaRecepcionExpediente curp :: {} proceso :: {} afore :: {} resultadoOperacion :: {}",curp,proceso,claveAfore,resultadoOperacion);
		ArchivoRecibido respuesta = null;
		try {

			String url = urlRecepcionExpedientePortal;
			url = url.replace("{curpTrabajador}", curp);
			url = url.replace("{cvProceso}", proceso);
			url = url.replace("{cvAfore}", claveAfore);
			url = url.replace("{rOperacion}", resultadoOperacion);


			logger.info("Peticion de validacion de archivo {}", url);
			respuesta = servicioCliente.getForObject(url, ArchivoRecibido.class);
			logger.info(
					"Respuesta consulta archivo  :: validaExistenciaRecepcionExpediente: {}",
					respuesta);

		} catch (Exception e) {
			logger.error("Se presento un problema en la consulta validaExistenciaRecepcionExpediente curp :: {} proceso :: {} afore :: {} resultadoOperacion :: {} error :: {}",curp,proceso,claveAfore,resultadoOperacion, e);
		}

		return respuesta;
	}

	@Override
	public RespuestaServicio enviarArchivosDigitalizados(Folio folio, String ruta, EnvioArchivos datosRecepcion) {
		logger.info("Se contruye la peticion de archivo {}", datosRecepcion);
		RespuestaServicio respuestaServicio = null;
		
		try {
			Archivos objetoArchivo = new Archivos();
			objetoArchivo.setClaveAfore(datosRecepcion.getClaveAfore());
			objetoArchivo.setFolioTramiteProcesar(datosRecepcion.getFolio());
			objetoArchivo.setCurpEmpleado(datosRecepcion.getCurpEmpleado());
			objetoArchivo.setCurpTrabajador(datosRecepcion.getCurpTrabajador());
			objetoArchivo.setTipoArchivos(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
			objetoArchivo.setTipoExpediente(datosRecepcion.getProceso());

			respuestaServicio = this.enviarArchivoRecepcion(folio, objetoArchivo);
			
		} catch (GenericException ge) {
			logger.error("Ocurrio IOException", ge);
			respuestaServicio = this.obtenerRespuesta(ge.getCodigo(), datosRecepcion.getClaveAfore(),
					NumerosConstants.INT_DOS);
		}
		return respuestaServicio;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService#enviarArchivoRecepcion(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos)
	 */
	@Override
	public RespuestaServicio enviarArchivoRecepcion(Folio folio, Archivos oArchivos) {
		RespuestaServicio respuesta = new RespuestaServicio();
		String nombreZip = this.obtenerArchivoZipExpediente(oArchivos, null);
		try {
			logger.info("Archivo almacenado {}", nombreZip);
			respuesta.setFlujo(NumerosConstants.INT_UNO);
			oArchivos.setContenidoArchivo(nombreZip);

			RespuestaAlta archivosEnviados = this.capturarArchivos(oArchivos, nombreZip, null);
			if (utileriaValidador.validarObjetoNulo(archivosEnviados)) {
				this.eliminarDirectorio(new File(nombreZip));
				throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
			}
			if (ServiciosConstants.RESULTADO_NOK.equals(archivosEnviados.getResultadoOperacion())) {
				logger.info("La respuesta del envio de archivos fue rechazada {}", oArchivos.toString());
				throw new BusinessException(BusinessErrorEnum.SOLICITUD_RECHAZADA, archivosEnviados.getMotivoRechazo());
			}
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.SOLICITUD_EN_PROCESO.getClave(),
					oArchivos.getClaveAfore(), NumerosConstants.INT_UNO, null);
		} catch (GenericException ge) {
			logger.error("Error en el servicio de enviar archivo {}", nombreZip, ge);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					oArchivos.getClaveAfore(), NumerosConstants.INT_DOS, null);
		} catch (BusinessException be) {
			logger.error("Business Excepcion de recepion de archivo {} {}", nombreZip, be.getCodigo(), be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.SOLICITUD_RECHAZADA.getClave(),
					oArchivos.getClaveAfore(), NumerosConstants.INT_DOS, null);
			RespuestaServicio res = cambiarMensaje(respuesta.getMensaje(), be.getCodigo(), oArchivos.getClaveAfore(), null);
			respuesta.setMensaje(res.getMensaje());
			servicioFolio.cerrarFolio(folio.getIdFolioPulssar(), NumerosConstants.INT_DOS, be.getCodigo());
		}

		return respuesta;
	}
	
	/**
	 * Metodo encargado de enviar la Rrcepcion de Archivos para la conformacion del Expediente
	 * @param folio
	 * @param oArchivos
	 * @param rutaZIP
	 * @return RespuestaServicio
	 */
	private RespuestaServicio ejecutarRecepcionArchivo(Folio folio, Archivos oArchivos, String nombreZip) throws IOException {

		logger.info("Entrando ejecutarRecepcionArchivo");
		logger.info("Captura Archivos {}", oArchivos);
		RespuestaServicio respuesta = new RespuestaServicio();

		try {
			RespuestaAlta archivosEnviados = this.capturarArchivos(oArchivos, nombreZip, null);
			if (utileriaValidador.validarObjetoNulo(archivosEnviados)) {
				throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
			}
			if (ServiciosConstants.RESULTADO_NOK.equals(archivosEnviados.getResultadoOperacion())) {
				logger.info("La respuesta del envio de archivos fue rechazada {}", oArchivos.toString());
				throw new BusinessException(BusinessErrorEnum.SOLICITUD_RECHAZADA, archivosEnviados.getMotivoRechazo());
			}
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.SOLICITUD_EN_PROCESO.getClave(),
					oArchivos.getClaveAfore(), NumerosConstants.INT_UNO, null);

		} catch (GenericException ge) {
			logger.error("Error en el servicio de enviar archivo {}", nombreZip, ge);
			respuesta = servicioCatalogo.obtenerRespuesta(null, GenericErrorEnum.EXCEPTION_GENERICA.getClave(),
					oArchivos.getClaveAfore(), NumerosConstants.INT_DOS, null);
		} catch (BusinessException be) {
			logger.error("Business Excepcion de recepion de archivo {} {}", nombreZip, be.getCodigo(), be);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.SOLICITUD_RECHAZADA.getClave(),
					oArchivos.getClaveAfore(), NumerosConstants.INT_DOS, null);
			RespuestaServicio res = cambiarMensaje(respuesta.getMensaje(), be.getCodigo(), oArchivos.getClaveAfore(),
					null);
			respuesta.setMensaje(res.getMensaje());
			servicioFolio.cerrarFolio(folio.getIdFolioPulssar(), NumerosConstants.INT_DOS, be.getCodigo());
		}

		return respuesta;

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerArchivoZipExpedienteRuta(Archivos oArchivos, String ruta) {
		String nombre = this.obtenerNombreArchivo(oArchivos);
		String rutaExpediente = utileriaCadena.obtenerCadenaConcatenada(true,ruta, nombre);

		File fArchivo = new File(rutaExpediente);
		if (fArchivo.exists()) {
			rutaExpediente = this.obtenerNombreArchivo(oArchivos);
		}

		return rutaExpediente;
	}
}