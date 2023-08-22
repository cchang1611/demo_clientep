/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

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
import org.springframework.web.client.RestTemplate;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Organizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.OrganizacionRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BiometricoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.CorreoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ArchivosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsentimientoTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosJasper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DetalleRecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPDF;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellaDactilar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellasDactilares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaBase;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JasperUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.LectorArchivoUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Servicio de biometrico
 * @author dbarbosa
 *
 */
@Service
public class BiometricoServiceImpl implements BiometricoService {
	
	/**
	 * 
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(BiometricoServiceImpl.class);
	
	/**
	 * Inyeccion de rest
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	/**
	 * Inyeccion de repositorio
	 */
	@Autowired
	private OrganizacionRepository repositorioOrganizacion;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private JasperUtils utileriaJasper;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Carpeta para archivo temporales
	 */
	@Value("${url.recepcion.archivos.acuse}")
	private String servicioAcuse;
	
	/**
	 * Carpeta consentimiento temporal
	 */
	@Value("${ruta.carpeta.expediente}")
	private String rutaTExpediente;
	
	/**
 	 * url digitaliza
 	 */
 	@Value("${url.ruta.digitaliza}")
 	private String urlDigitaliza;
 	
 	/**
	 * Utilidad Lector
	 */
	@Autowired
	private LectorArchivoUtils lectorUtils;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaBase validarExcepcionPantalla(String curp, String codigo, String tipo, String afore) {
		logger.info("Metodo encargado de obtener las excepciones para biometricos >>> {} : {} : {}", curp, codigo, tipo);
		RespuestaBase respuesta = new RespuestaBase();
		respuesta.setFlujo(NumerosConstants.INT_CERO);
		if(!NumerosConstants.C_NOVENTAYNUEVE.equals(codigo)) {
			List<Parametro> parametro = servicioCatalogo.obtenerParametroDdbpose(ServiciosConstants.PARAMETRO_AFORE_EXCEPCION);
			String parametroAfores = utileriaValidador.obtenerValorParametro(parametro, "AFORES", ExpresionesConstants.VACIO);
			if(!utileriaValidador.isEmpty(parametroAfores) && parametroAfores.contains(afore)) {
				respuesta.setFlujo(NumerosConstants.INT_DOS);
				HuellasDactilares huellas = obtenerArregloHuellas(curp, tipo, 
						NumerosConstants.C_UNO.equals(codigo) ? NumerosConstants.INT_DOS : NumerosConstants.INT_ONCE, codigo);
				respuesta.setRespuesta(huellas);
				RespuestaServicio respuestaServicio = servicioCatalogo.obtenerRespuesta(null, utileriaCadena.obtenerCadenaConcatenada(true, ServiciosConstants.MENSAJE_EXCEPCION_ACUSE, codigo), afore, NumerosConstants.INT_CERO, null);
				respuesta.setMensaje(respuestaServicio.getMensaje());
			}
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generarAcuseBiometrico(EntradaPDF acuse) {
		logger.info("Obtiene la imagen del PDF acuse {}", acuse.toString());
		String pdfAcuse = null;
		try {
			String valor = servicioCatalogo.consultaValorParametro(ActivacionConstants.PARAMETRO_RUTA_ARCHIVOS_EXPEDIENTE, ActivacionConstants.PARAMETRO_CLAVE_RUTA_ARCHIVOS_EXPEDIENTE);
			valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_AFORE, acuse.getCvAfore());
			valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, ArchivosEnum.EXPEDIENTE_BIOMETRICO.getNombreArchivo());
			logger.info("Dato Ruta Acuse Biometrico :: {}", valor);
			String path = utileriaCadena.obtenerCadenaConcatenada(true, valor,
					ExpresionesConstants.PALABRA_ACUSE, acuse.getCurp(), ExpresionesConstants.EXTENSION_PDF);
			File archivoPDF = new File(path);
			logger.info("Ruta del archivo Acuse Biometrico :: {}", path);
			Date fecha = this.crearPDFsAcuse(acuse, archivoPDF);
			
			if(acuse.isExcepcion()) {
				String rutaExcepcion = utileriaCadena.obtenerCadenaConcatenada(true, valor,
						ExpresionesConstants.PALABRA_EXCEPCION, acuse.getCurp(), ExpresionesConstants.EXTENSION_PDF);
				File pdfExcepcion = new File(rutaExcepcion);
				crearPDFExcepcion(acuse, pdfExcepcion, fecha);
			}
			
			pdfAcuse = this.crearAcuseBiometrico(acuse);
			this.enviarConsentimiento(acuse);
		} catch (DocumentException doce) {
			logger.error("Error al cargar el pdf del consentimiento, curp: {} afore: {}", acuse.getCurp(), acuse.getCvAfore(), doce);
		} catch (IOException ioe) {
			logger.error("Error al cargar el pdf del consentimiento, curp: {} afore: {}", acuse.getCurp(), acuse.getCvAfore(), ioe);
		}
		return pdfAcuse;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatosSolicitud recuperarFirmasProceso(RecepcionImagenes recepcionImagenes) throws IOException {
		DetalleRecepcionImagenes detalleFirmaTrabajador = null;
		String firmaTrabajador = null;
		DatosSolicitud datosSolicitud = new DatosSolicitud();
		
		Integer numeroArchivos = recepcionImagenes.getDetalleRecepcionImagen().size();
		datosSolicitud.setNumeroArchivos(numeroArchivos);
		for(DetalleRecepcionImagenes detalle : recepcionImagenes.getDetalleRecepcionImagen()) {
			if("40".equals(detalle.getTipoDocumentoDigital()) && NumerosConstants.INT_TRES.equals(detalle.getTipoImagen())) {
				detalleFirmaTrabajador = detalle;
			}
		}
		
		if(!utileriaValidador.validarObjetoNulo(detalleFirmaTrabajador)) {
			String rutaFirmaTrabajador = utileriaCadena.obtenerCadenaConcatenada(true, detalleFirmaTrabajador.getRuta(),detalleFirmaTrabajador.getMascara());
			firmaTrabajador = lectorUtils.obtenerContenidoArchivo(rutaFirmaTrabajador);

		}else {
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		
		
		datosSolicitud.setFirmaTrabajador(firmaTrabajador);
		
		return datosSolicitud;
	}
	
	/**
	 * Metodo encargado de generar el arreglo de huellas para proceso de excepciones
	 * 
	 * @param curp
	 * @param tipo
	 * @param fin
	 * @param motivo
	 * @return
	 */
	private HuellasDactilares obtenerArregloHuellas(String curp, String tipo, int fin, String codigo) {
		logger.info("Metodo encargado de obtener el arreglo de huellas >>>> {} : {} : {} : {}", curp, tipo, String.valueOf(fin), codigo);
		HuellasDactilares huellasDactilares = new HuellasDactilares();
		List<HuellaDactilar> huellas = new ArrayList<>();
		HuellaDactilar huella;
		for(int i = 1; i < fin; i++) {
			String motivo = NumerosConstants.C_UNO.equals(codigo) ? ServiciosConstants.CODIGO_XX : ServiciosConstants.CODIGO_UP;
			String codigoFormateado = String.format("%03d", Integer.parseInt(codigo));
			
			huella = new HuellaDactilar();
			huella.setIdDedo(String.valueOf(i));
			huella.setTipoPersona(tipo);
			huella.setMotivoSinHuella(motivo);
			huella.setCodigoFaltaDedo(codigoFormateado);
			huellas.add(huella);
		}
		huellasDactilares.setHuellaDactilar(huellas);
		return huellasDactilares;
	}
	
	/**
	 * Crea el archivo PDF con o sin firma
	 * @param trabajador
	 * @param cvAfore
	 * @param imagenFirma
	 * @return
	 * @throws IOException 
	 */
	private Date crearPDFsAcuse(EntradaPDF entrada, File pdfTemp) throws IOException {
		logger.info("Crear archivo pdf acuse {}", entrada);
		DatosJasper datos = new DatosJasper();
		Map<String, String> mapaImagenes = new HashMap<>();
		Map<String, Object> mapaDatos = new HashMap<>();
		
		Organizacion orgAfore = repositorioOrganizacion.findOne(entrada.getCvAfore());
		Date fecha = new Date();
		
		mapaImagenes.put("imagenAfore", utileriaCadena.obtenerCadenaConcatenada(true, entrada.getCvAfore(), CorreoConstants.EXTENSION_JPG));
		mapaDatos.put("logo", entrada.getImagenFirma());
		mapaDatos.put("clave", orgAfore.getClaveOrganizacion());
		mapaDatos.put("nombreAdmin", orgAfore.getDescripcionOrganizacion());
		mapaDatos.put("curp", entrada.getCurp());
		mapaDatos.put("nombre", entrada.getNombreTrabajador());
		mapaDatos.put("fecha", utileriaFecha.convertirFechaACadena(fecha, FormatoConstants.FORMATO_FECHA_NACIMIENTO).toUpperCase());
		
		datos.setDocJasper(ArchivosEnum.ACUSE_ENROLAMIENTO.getNombreArchivo());
		datos.setMapObjects(mapaDatos);
		datos.setMapImagenes(mapaImagenes);
		
		byte[] arregloByte = utileriaJasper.generarArchivoJasper(datos, entrada.getCvAfore());
		
		OutputStream os = new FileOutputStream(pdfTemp);
		os.write(arregloByte);
		logger.info("pdf creado correctamente.");
		os.close();
		return fecha;
	}
	
	/**
	 * Crea el archivo PDF con o sin firma
	 * @param trabajador
	 * @param cvAfore
	 * @param imagenFirma
	 * @return
	 * @throws IOException 
	 */
	private void crearPDFExcepcion(EntradaPDF entrada, File pdfTemp, Date fecha) throws IOException {
		logger.info("Crear archivo excepcion {}", entrada);
		DatosJasper datos = new DatosJasper();
		Map<String, String> mapaImagenes = new HashMap<>();
		Map<String, Object> mapaDatos = new HashMap<>();
		
		mapaImagenes.put("imagenAfore", utileriaCadena.obtenerCadenaConcatenada(true, entrada.getCvAfore(), CorreoConstants.EXTENSION_JPG));
		mapaDatos.put("logo", entrada.getImagenFirma());
		mapaDatos.put("fechaExcepcion", utileriaFecha.convertirFechaACadena(fecha, FormatoConstants.FORMATO_FECHA_CORREO).toUpperCase());
		mapaDatos.put("nombreTrabajador", entrada.getNombreTrabajador());
		mapaDatos.put("curp", entrada.getCurp());
		mapaDatos.put("motivos", entrada.getMotivos());
		mapaDatos.put("nombreAgente", entrada.getNombreAgente());
		mapaDatos.put("claveAgente", entrada.getClaveAgente());
		
		datos.setDocJasper(ArchivosEnum.EXCEPCION_ENROLAMIENTO_JASPER.getNombreArchivo());
		datos.setMapObjects(mapaDatos);
		datos.setMapImagenes(mapaImagenes);
		
		byte[] arregloByte = utileriaJasper.generarArchivoJasper(datos, entrada.getCvAfore());
		
		OutputStream os = new FileOutputStream(pdfTemp);
		os.write(arregloByte);
		logger.info("pdf creado correctamente.");
		os.close();
	}

	/**
	 * Metodo encargado de crear el archivo acuse y devolver el base 64
	 * @param acuse
	 * @throws IOException
	 * @throws DocumentException
	 */
	private String crearAcuseBiometrico(EntradaPDF acuse) throws IOException, DocumentException {
		logger.info("Creacion de Acuse Biometrico");
		String rutaExpediente = servicioCatalogo.consultaValorParametro(ActivacionConstants.PARAMETRO_RUTA_ARCHIVOS_EXPEDIENTE, ActivacionConstants.PARAMETRO_CLAVE_RUTA_ARCHIVOS_EXPEDIENTE);
		rutaExpediente = StringUtils.replace(rutaExpediente, ActivacionConstants.DATO_RUTA_EXPEDIENTE_AFORE, acuse.getCvAfore());
		rutaExpediente = StringUtils.replace(rutaExpediente, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, ArchivosEnum.EXPEDIENTE_BIOMETRICO.getNombreArchivo());
		
		String rutaAcuse = utileriaCadena.obtenerCadenaConcatenada(true, rutaExpediente, ExpresionesConstants.PALABRA_ACUSE, 
				acuse.getCurp(), ExpresionesConstants.EXTENSION_PDF);
		String rutaExcepcion = utileriaCadena.obtenerCadenaConcatenada(true, rutaExpediente, ExpresionesConstants.PALABRA_EXCEPCION, 
				acuse.getCurp(), ExpresionesConstants.EXTENSION_PDF);
		logger.info("Ruta del acuse :: {} --- {}", rutaAcuse, rutaExcepcion);
		String rutaEnvio = servicioCatalogo.consultaValorParametro(ActivacionConstants.PARAMETRO_RUTA_ARCHIVOS_EXPEDIENTE, ActivacionConstants.RUTA_GUARDADO_ARCHIVOS);
		rutaEnvio = StringUtils.replace(rutaEnvio, ActivacionConstants.DATO_RUTA_EXPEDIENTE_AFORE, acuse.getCvAfore());
		rutaEnvio = StringUtils.replace(rutaEnvio, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, ArchivosEnum.EXPEDIENTE_BIOMETRICO.getNombreArchivo());
		String destinoEnvio = utileriaCadena.obtenerCadenaConcatenada(true, rutaEnvio, 
				acuse.getFolio(), ServiciosConstants.SERVICIO_ENROLAMIENTO_DOCUMENTO, ExpresionesConstants.EXTENSION_PDF);
		logger.info("Ruta de Envio :::: {}", destinoEnvio);
		File fileExcepcion = new File(rutaExcepcion);
		File fileAcuse = new File(rutaAcuse);
		
		if(fileExcepcion.isFile()) {
			PdfReader excepcionRead = new PdfReader(rutaExcepcion);
			PdfReader acuseRead = new PdfReader(rutaAcuse);
			PdfStamper stamper = new PdfStamper(acuseRead, new FileOutputStream(destinoEnvio));
			PdfImportedPage page = stamper.getImportedPage(excepcionRead, NumerosConstants.INT_UNO);
			stamper.insertPage(NumerosConstants.INT_DOS, excepcionRead.getPageSize(NumerosConstants.INT_UNO));
			stamper.getUnderContent(NumerosConstants.INT_DOS).addTemplate(page, 0, 0);
			stamper.close();
			excepcionRead.close();
			acuseRead.close();
			fileExcepcion.delete();
			
		} else {
			InputStream origen = new FileInputStream(rutaAcuse);
			OutputStream destino = new FileOutputStream(destinoEnvio);
			
			byte[] buffer = new byte[(int) fileAcuse.length()];
			int tamanio;
			while ((tamanio = origen.read(buffer)) > 0) {
			  destino.write(buffer, 0, tamanio);
			}
			origen.close();
			destino.close();
		}
		fileAcuse.delete();
		
		return obtenerImagenesAcuse(destinoEnvio);
	}
	
	/**
	 * Metodo encargado de obtener las imagenes del acuse
	 * 
	 * @param destino
	 * @return
	 * @throws IOException
	 */
	private String obtenerImagenesAcuse(String destino) throws IOException {
		byte[] arregloArchivo = Files.readAllBytes(Paths.get(destino));
//		List<String> imagenes = new ArrayList<>();
//		PDDocument doc = PDDocument.load(new File(destino));
//		int numPaginas = doc.getNumberOfPages();
//		logger.info("Numero de paginas de pdf para imagenes {}", numPaginas);
//		PDFRenderer renderer = new PDFRenderer(doc);
//		ByteArrayOutputStream outoutFile = null;
//		BufferedImage image = null;
//		byte[] imageByte = null;
//		for (int i = 0; i < numPaginas; i++) {
//			outoutFile = new ByteArrayOutputStream();
//			image = renderer.renderImageWithDPI(i, 300);
//			ImageIO.write(image, "png", outoutFile);
//			
//			outoutFile.flush();
//			imageByte = outoutFile.toByteArray();
//			outoutFile.close();
//			imagenes.add(DatatypeConverter.printBase64Binary(imageByte));
//		}
//		logger.info("imagenes de acuse {}", imagenes);
		
		return DatatypeConverter.printBase64Binary(arregloArchivo);
	}
	/**
	 * Metodo encargado de guardar los byte en PDF
	 * @param bytes
	 * @param pdfTemp
	 * @throws IOException 
	 */
	private void enviarConsentimiento(EntradaPDF entrada) throws IOException { 
		if(entrada.isConsentimiento()) {
			logger.info("Ruta del envio de consentimiento final");
			String rutaEnvio = servicioCatalogo.consultaValorParametro(ActivacionConstants.PARAMETRO_RUTA_ARCHIVOS_EXPEDIENTE, ActivacionConstants.RUTA_GUARDADO_ARCHIVOS);
			rutaEnvio = StringUtils.replace(rutaEnvio, ActivacionConstants.DATO_RUTA_EXPEDIENTE_AFORE, entrada.getCvAfore());
			rutaEnvio = StringUtils.replace(rutaEnvio, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, ArchivosEnum.EXPEDIENTE_BIOMETRICO.getNombreArchivo());
			
			logger.info("Ruta envio consentimiento : {}", rutaEnvio);
			String destinoEnvio = utileriaCadena.obtenerCadenaConcatenada(true, rutaEnvio, entrada.getFolio(), ServiciosConstants.SERVICIO_ENROLAMIENTO_DOCUMENTO, ExpresionesConstants.EXTENSION_PDF);
			logger.info("Ruta envio consentimiento destino: {}", destinoEnvio);
			
			ConsentimientoTrabajador consentimiento = new ConsentimientoTrabajador();
			consentimiento.setIdFolioPulssar(entrada.getIdFolio());
			consentimiento.setRutaArchivo(destinoEnvio);
			consentimiento.setEstatus(NumerosConstants.INT_UNO);
			consentimiento.setFechaControl(utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_CONSENTIMIENTO));
			consentimiento.setUsuarioModificador(RegistroUsuarioConstants.USUARIO_PULSSAR);
			this.guardarAcuseConsentimiento(consentimiento);
		}
	}
	
	/**
	 * Metodo encargado de lanzar la peticion para guardar el acuse
	 * 
	 * @param consentimiento
	 */
	private void guardarAcuseConsentimiento(ConsentimientoTrabajador consentimiento) {
		try {
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			JsonUtilsImpl<ConsentimientoTrabajador> jsonEntrada = new JsonUtilsImpl<>();
			String resultadoJson = jsonEntrada.parseObjectToJsonSC(consentimiento);
			logger.info(resultadoJson);
			
			HttpEntity<String> entidadConsulta = new HttpEntity<>(resultadoJson, headerMedia);
			
			ResponseEntity<String> resultadoArchivos = servicioCliente.exchange(servicioAcuse, HttpMethod.PUT, entidadConsulta, String.class);
			logger.info(resultadoArchivos.getStatusCode().toString());
		} catch (Exception e) {
			logger.error("Error al cargar al guardar acuse", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}
}
