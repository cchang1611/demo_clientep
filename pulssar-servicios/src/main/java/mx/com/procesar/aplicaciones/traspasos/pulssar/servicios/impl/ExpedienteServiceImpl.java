/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.PDFRenderer;
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
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.itextpdf.text.Annotation;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Organizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.OrganizacionRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.CorreoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ArchivosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ExcepcionesEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.PosicionDedoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsentimientoTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseCurp;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioParticularTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosHuellas;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosIdenExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosJasper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNoCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosParticulares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Domicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPDF;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioComplemento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAlta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JasperUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Clase para las implementacion de expediente biometrico e identificacion
 * 
 * @author DBARBOSA
 *
 */
@Service
public class ExpedienteServiceImpl implements ExpedienteService {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ExpedienteServiceImpl.class);
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inyeccion de repositorio
	 */
	@Autowired
	private OrganizacionRepository repositorioOrganizacion;
	
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
	 * Inyeccion de rest
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
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
	 * Carpeta para archivo temporales
	 */
	@Value("${url.recepcion.archivos.acuse}")
	private String servicioAcuse;
	
	/**
	 * Ruta documentos
	 */
	@Value("${ruta.archivos.docs}")
	private String rutaArchivosDocumentos;
	
	/**
	 * Ruta imagenes
	 */
	@Value("${ruta.imagenes}")
	private String rutaImagenes;
	
	/**
	 * Carpeta para archivo temporales
	 */
	@Value("${ruta.carpeta.expediente}")
	private String rutaTExpediente;
	
	/**
	 * Carpeta para archivo temporales
	 */
	@Value("${ruta.carpeta.expediente.consentimiento}")
	private String rutaExpedienteConsentimiento;
	
	/**
 	 * url digitaliza
 	 */
 	@Value("${url.ruta.digitaliza}")
 	private String urlDigitaliza;
	
	/**
	 * {@inheritDoc}}
	 */
	@Override
	public String obtenerImagenPDF(EntradaPDF entrada) {
		logger.info("Obtiene la imagen del PDF acuse {}", entrada.toString());
		String imagenPDF = ExpresionesConstants.VACIO;
		try {
			String path = utileriaCadena.obtenerCadenaConcatenada(true, rutaTExpediente, ExpresionesConstants.DIAGONAL, ExpresionesConstants.PALABRA_ACUSE, 
					entrada.getCurp(), ExpresionesConstants.EXTENSION_PDF);
			File archivoPDF = new File(path);
			
			this.crearPDFAcuse(entrada, archivoPDF);
			this.enviarConsentimiento(entrada);
			
//			PDDocument documento = PDDocument.load(archivoPDF);
//			PDFRenderer renderer = new PDFRenderer(documento);
//			ByteArrayOutputStream outputfile = new ByteArrayOutputStream();
//			
//			BufferedImage image = renderer.renderImage(NumerosConstants.INT_CERO);
//			if(entrada.isResize()) {
//				float iniy = (image.getHeight() * NumerosConstants.INT_VEINTE) / NumerosConstants.INT_SETECIENTOSNOVENTAYDOS;
//				float finy = (image.getHeight() * NumerosConstants.INT_QUINIENTOSOCENTA) / NumerosConstants.INT_SETECIENTOSNOVENTAYDOS;
//				BufferedImage auxiliar = image.getSubimage(NumerosConstants.INT_CERO, Math.round(iniy), image.getWidth(), Math.round(finy));
//				Graphics2D g = auxiliar.createGraphics();
//				g.drawImage(auxiliar, 0, 0, null); 
//				g.dispose();
//				ImageIO.write(auxiliar, ExpresionesConstants.VALOR_PNG, outputfile);
//				image = auxiliar;
//			}
//			ImageIO.write(image, ExpresionesConstants.VALOR_PNG, outputfile);
//			
//			outputfile.flush();
//			byte[] imagenByte = outputfile.toByteArray();
//			outputfile.close();
//			documento.close();
//			
//			imagenPDF = DatatypeConverter.printBase64Binary(imagenByte);
		} catch (IOException e) {
			logger.error("Error al cargar el pdf del consentimiento, curp: {} afore: {}", entrada.getCurp(), entrada.getCvAfore(), e);
		}
		return imagenPDF;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio guardarHuellasTrabajador(String valor, UsuarioLogin user, DatosTrabajador trabajador, Archivos objetoArchivo, String archivo64, Folio folio) throws IOException {
		RespuestaServicio respuesta;
		if(ServiciosConstants.RESULTADO_OK.equals(valor)) {
			String origen = utileriaCadena.obtenerCadenaConcatenada(true, rutaTExpediente, ExpresionesConstants.DIAGONAL, ExpresionesConstants.PALABRA_ACUSE, trabajador.getDatosCertificables().getCurp(), ExpresionesConstants.EXTENSION_PDF);
			String destino = utileriaCadena.obtenerCadenaConcatenada(true, rutaExpedienteConsentimiento, trabajador.getDatosCertificables().getCurp(), ExpresionesConstants.EXTENSION_PDF);
			
			InputStream in = new FileInputStream(origen);
			OutputStream out = new FileOutputStream(destino);
			
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			
			servicioArchivos.eliminarDirectorio(new File(origen));
			
			respuesta = servicioArchivos.enviarArchivoRecepcion(folio, objetoArchivo, archivo64, ServiciosConstants.RUTA_HUELLA);
			if(NumerosConstants.INT_UNO == respuesta.getFlujo()) {
				respuesta.setFlujo(NumerosConstants.INT_VEINTE);
			}
		} else {
			String docExcepcion = this.caidaDatosPDF(user, trabajador, valor, null, null);
			respuesta = servicioCatalogo.obtenerRespuesta(null, MensajesExitoEnum.EXPEDIENTE_ENROLAMIENTO_ERROR.getClave(), user.getAforeUsuario(), NumerosConstants.INT_CUATRO, null);
			respuesta.setDatos(docExcepcion);
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void guardarDocumentoAcuseAfore(String curp, String cvAfore, String folioPadre) throws IOException {
		String rutaExpediente = servicioCatalogo.consultaValorParametro(ActivacionConstants.PARAMETRO_RUTA_ARCHIVOS_EXPEDIENTE, ActivacionConstants.PARAMETRO_CLAVE_RUTA_ARCHIVOS_EXPEDIENTE);
		rutaExpediente = StringUtils.replace(rutaExpediente, ActivacionConstants.DATO_RUTA_EXPEDIENTE_AFORE, cvAfore);
		rutaExpediente = StringUtils.replace(rutaExpediente, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, ArchivosEnum.EXPEDIENTE_BIOMETRICO.getNombreArchivo());
		String origen = utileriaCadena.obtenerCadenaConcatenada(true, rutaExpediente, ExpresionesConstants.DIAGONAL, ExpresionesConstants.PALABRA_ACUSE, curp, ExpresionesConstants.EXTENSION_PDF);
		String destino = utileriaCadena.obtenerCadenaConcatenada(true, rutaExpediente, curp, ExpresionesConstants.EXTENSION_PDF);
		
		String rutaEnvio = servicioCatalogo.consultaValorParametro(ActivacionConstants.PARAMETRO_RUTA_ARCHIVOS_EXPEDIENTE, ActivacionConstants.RUTA_GUARDADO_ARCHIVOS);
		rutaEnvio = StringUtils.replace(rutaEnvio, ActivacionConstants.DATO_RUTA_EXPEDIENTE_AFORE, cvAfore);
		rutaEnvio = StringUtils.replace(rutaEnvio, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, ArchivosEnum.EXPEDIENTE_BIOMETRICO.getNombreArchivo());
		String destinoEnvio = utileriaCadena.obtenerCadenaConcatenada(true, rutaEnvio, cvAfore, ExpresionesConstants.DIAGONAL, folioPadre, ServiciosConstants.SERVICIO_ENROLAMIENTO_DOCUMENTO, ExpresionesConstants.EXTENSION_PDF);
		
		File fileOrigen = new File(origen);
		FileInputStream inputOrigen = new FileInputStream(fileOrigen);
		byte[] arregloOrigen = new byte[(int) fileOrigen.length()];
		inputOrigen.read(arregloOrigen);
		inputOrigen.close();
		
		FileOutputStream fileDestino = new FileOutputStream(destino);
		fileDestino.write(arregloOrigen);
		fileDestino.close();
		
		FileOutputStream fileDestinoEnvio = new FileOutputStream(destinoEnvio);
		fileDestinoEnvio.write(arregloOrigen);
		fileDestinoEnvio.close();
		
		servicioArchivos.eliminarDirectorio(new File(origen));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void invocarRecepcionArchivos(Archivos objetoArchivo) {
		Map<String, String> map = new HashMap<>();
		RespuestaAlta archivosEnviados = servicioArchivos.capturarArchivos(objetoArchivo, null, map);
		if(utileriaValidador.validarObjetoNulo(archivosEnviados)) {
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		if(ServiciosConstants.RESULTADO_NOK.equals(archivosEnviados.getResultadoOperacion())) {
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerDocumentoExcepcionFirma(UsuarioLogin user, DatosTrabajador trabajador, String codigo, String firma) {
		logger.info("Creando PDF con firma Agente, reemplazo de archivos");
		String pathDocDestino = utileriaCadena.obtenerCadenaConcatenada(true, rutaExpedienteConsentimiento, trabajador.getDatosCertificables().getCurp(), ExpresionesConstants.EXTENSION_PDF);
		
		return this.caidaDatosPDF(user, trabajador, codigo, firma, pathDocDestino);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerValoresPantalla(String folio, String tipoTrabajador) {
		if(!utileriaValidador.validarVacio(folio)) {
			return folio.substring(folio.length() - NumerosConstants.INT_TRES);
		}
		
		List<Parametro> listaParametro = servicioCatalogo.obtenerParametro(AgenteConstants.PARAMETRO_TIPO_AFILIACION, "");
		List<String> valoresImss = utileriaValidador.obtenerListaParametro(listaParametro, AgenteConstants.TIPO_AFILIACION_IMSS, AgenteConstants.VALOR_AFILIACION_IMSS);
		List<String> valoresIssste = utileriaValidador.obtenerListaParametro(listaParametro, AgenteConstants.TIPO_AFILIACION_ISSSTE, AgenteConstants.VALOR_AFILIACION_ISSSTE);
		String tipo = NumerosConstants.C_CERO;
		if(valoresImss.contains(tipoTrabajador)) {
			tipo = NumerosConstants.C_UNO;
		} else if(valoresIssste.contains(tipoTrabajador)) {
			tipo = NumerosConstants.C_DOS;
		}
		return tipo;
	}
	/**
	 * {@inheritDoc}
	 **/
	@Override
	public List<String> obtenerDedosMejorCalidad(List<DatosHuellas> huellas, String curp, Integer estatusEnRolamiento) {
		logger.info("Obteniendo huellas de mejor calidad curp ::: {}", curp);
		
		List<String> lstDedos = null;
		if(NumerosConstants.INT_CERO != estatusEnRolamiento && !utileriaValidador.validarListaVacia(huellas)) {
			logger.info("Tiene huellas el trabajador {} realizando mapeo {}", curp, huellas);
			int i = 1;
			List<Integer> auxiliar;
			List<Integer> auxDedos = new ArrayList<>();
			do {
				auxiliar = this.obtenerHuellasValidas(huellas, i);
				i++;
				if(!utileriaValidador.validarListaVacia(auxiliar)) {
					auxDedos.addAll(auxiliar);
				}
			} while(i <= NumerosConstants.INT_CINCO && auxDedos.size() < NumerosConstants.INT_CUATRO);
			
			if(auxDedos.size() > 0) {
				lstDedos = new ArrayList<>();
				for(Integer dedo : auxDedos) {
					if(lstDedos.size() < NumerosConstants.INT_CUATRO) {
						lstDedos.add(String.valueOf(dedo));
					}
				}
			}
		}
		return lstDedos;
	}
	
	/**
	 * {@inheritDoc}
	 * @throws IOException 
	 * @throws InvalidPasswordException 
	 **/
	@Override
	public String obtenerPDFHuellas(List<DatosHuellas> huellas, String curp, Integer estatusEnRolamiento, List<String> lstDedos) throws InvalidPasswordException, IOException {
		logger.info("Obteniendo datos para PDF {}", curp);
		Map<String, Object> mapaDatos = new HashMap<>();
		Map<String, String> mapaImagenes = new HashMap<>();
		
		if(NumerosConstants.INT_CERO == estatusEnRolamiento || utileriaValidador.validarListaVacia(huellas)) {
			mapaDatos.put("manos", "SIN HUELLAS, USUARIO SIN ENROLAMIENTO PREVIO.");
		} else {
			if(!utileriaValidador.validarListaVacia(lstDedos) && lstDedos.size() > NumerosConstants.INT_CERO) {
				for(String dedo : lstDedos) {
					PosicionDedoEnum dedoEnum = PosicionDedoEnum.obtenerDedo(Integer.parseInt(dedo));
					String key = utileriaCadena.obtenerCadenaConcatenada(true, "d", dedo);
					mapaImagenes.put(key, dedoEnum.getImagen());
				}
			} else {
				mapaDatos.put("manos", "NO PRESENTA HUELLAS REGISTRADAS, SE ENROLÓ CON EXCEPCIÓN.");
			}
		}
		
		mapaImagenes.put("imgDerecha", PosicionDedoEnum.MANO_DERECHA.getImagen());
		mapaImagenes.put("imgIzquierda", PosicionDedoEnum.MANO_IZQUIERDA.getImagen());
		
		DatosJasper datos = new DatosJasper();
		
		datos.setDocJasper(ArchivosEnum.HUELLAS_PDF.getNombreArchivo());
		datos.setMapObjects(mapaDatos);
		datos.setMapImagenes(mapaImagenes);
		
		byte[] arregloByte = utileriaJasper.generarArchivoJasper(datos, "");
		
		return DatatypeConverter.printBase64Binary(arregloByte);
	}
	
	/**
	 * MEtodo encargado de obtener las huellas validas de un trabajador
	 * @param huellas
	 * @param calidad
	 * @return
	 */
	private List<Integer> obtenerHuellasValidas(List<DatosHuellas> huellas, int calidad) {
		List<Integer> huellasValidas = new ArrayList<>();
		for(DatosHuellas huella : huellas) {
			if(utileriaValidador.validarVacio(huella.getMotivo()) && huella.getCalidadHuella().intValue() == calidad) {
				huellasValidas.add(huella.getPosicionDedo());
			}
		}
		Collections.sort(huellasValidas);
		return huellasValidas;
	}
	
	/**
	 * Crea el archivo PDF con o sin firma
	 * @param trabajador
	 * @param cvAfore
	 * @param imagenFirma
	 * @return
	 * @throws IOException 
	 */
	private void crearPDFAcuse(EntradaPDF entrada, File pdfTemp) throws IOException {
		DatosJasper datos = new DatosJasper();
		Map<String, String> mapaImagenes = new HashMap<>();
		Map<String, Object> mapaDatos = new HashMap<>();
		
		Organizacion orgAfore = repositorioOrganizacion.findOne(entrada.getCvAfore());
		
		mapaImagenes.put("imagenAfore", utileriaCadena.obtenerCadenaConcatenada(true, entrada.getCvAfore(), CorreoConstants.EXTENSION_JPG));
		mapaDatos.put("logo", entrada.getImagenFirma());
		mapaDatos.put("clave", orgAfore.getClaveOrganizacion());
		mapaDatos.put("nombreAdmin", orgAfore.getDescripcionOrganizacion());
		mapaDatos.put("curp", entrada.getCurp());
		mapaDatos.put("nombre", entrada.getNombreTrabajador());
		mapaDatos.put("fecha", utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_NACIMIENTO).toUpperCase());
		
		datos.setDocJasper(ArchivosEnum.ACUSE_ENROLAMIENTO.getNombreArchivo());
		datos.setMapObjects(mapaDatos);
		datos.setMapImagenes(mapaImagenes);
		
		byte[] arregloByte = utileriaJasper.generarArchivoJasper(datos, entrada.getCvAfore());
		
		OutputStream os = new FileOutputStream(pdfTemp);
		os.write(arregloByte);
		logger.info("pdf creado correctamente.");
		os.close();
	}
	
	/**
	 * Metodo encargado de guardar los byte en PDF
	 * @param bytes
	 * @param pdfTemp
	 * @throws IOException 
	 */
	private void enviarConsentimiento(EntradaPDF entrada) throws IOException { 
		if(entrada.isConsentimiento()) {
			String path = utileriaCadena.obtenerCadenaConcatenada(true, rutaExpedienteConsentimiento, entrada.getCurp(), ExpresionesConstants.EXTENSION_PDF);
			
			ConsentimientoTrabajador consentimiento = new ConsentimientoTrabajador();
			consentimiento.setIdFolioPulssar(entrada.getIdFolio());
			consentimiento.setRutaArchivo(path);
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
	
	/**
	 * Metodo encargado de pamear los datos en el pdf
	 * @param user
	 * @param datos
	 */
	private String caidaDatosPDF(UsuarioLogin user, DatosTrabajador datos, String codigo, String firma, String pathDocDestino) {
		String imagenPDF = ExpresionesConstants.VACIO;
		try {
			String pathDocTemporal = utileriaCadena.obtenerCadenaConcatenada(true, rutaTExpediente, ExpresionesConstants.DIAGONAL, ExpresionesConstants.PALABRA_ACUSE, datos.getDatosCertificables().getCurp(), ExpresionesConstants.EXTENSION_PDF);
			String rutaExcepcion = StringUtils.replace(ArchivosEnum.ACUSE_ENROLAMIENTO_EXCEPCION.getNombreArchivo(), "{afore}", user.getAforeUsuario());
			String rutaTemporal = utileriaCadena.obtenerCadenaConcatenada(true, rutaTExpediente, ExpresionesConstants.DIAGONAL, datos.getDatosCertificables().getCurp(), ExpresionesConstants.EXTENSION_PDF);
			
			PdfReader plantilla = new PdfReader(utileriaCadena.obtenerCadenaConcatenada(true, rutaArchivosDocumentos, rutaExcepcion));
			PdfStamper stamperPlantilla = new PdfStamper(plantilla, new FileOutputStream(rutaTemporal));
			
			PdfContentByte canvas = stamperPlantilla.getOverContent(1);
			BaseFont baseFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			
			canvas.setRGBColorStroke(0,0,0);
			canvas.setRGBColorFill(0,0,0);
			canvas.saveState();
			canvas.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL);
			canvas.setFontAndSize(baseFont, 9f);
			canvas.beginText();
			
			ExcepcionesEnum mensajeExcepcion = ExcepcionesEnum.obtenerMensajeExcepcion(codigo);
			canvas.showTextAligned(Element.ALIGN_LEFT, mensajeExcepcion.getDescripcion().toUpperCase(), 68, 415, 0);
			
			if(!utileriaValidador.validarObjetoNulo(firma)) {
				Image image = Image.getInstance(Base64Utils.decodeFromString(firma));
				image.scaleAbsolute(155, 60);
				image.setAbsolutePosition(75, 272);
				image.setAnnotation(new Annotation(0, 0, 0, 0, 3));
				canvas.addImage(image);
			}
			
			canvas.endText();
			canvas.restoreState();
			canvas.saveState();
			
			baseFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			
			canvas.setRGBColorStroke(0,0,0);
			canvas.setRGBColorFill(0,0,0);
			canvas.saveState();
			canvas.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL);
			canvas.setFontAndSize(baseFont, 7f);
			canvas.beginText();
			
			canvas.showTextAligned(Element.ALIGN_CENTER, datos.getNombreTrabajador().toUpperCase(), 417, 548, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, datos.getDatosCertificables().getCurp().toUpperCase(), 168, 529, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, user.getNombre().toUpperCase(), 152, 264, 0);
			
			canvas.endText();
			canvas.restoreState();
			canvas.saveState();
			
			baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			
			canvas.setRGBColorStroke(0,0,0);
			canvas.setRGBColorFill(0,0,0);
			canvas.saveState();
			canvas.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL);
			canvas.setFontAndSize(baseFont, 7f);
			canvas.beginText();
			
			String fecha = utileriaFecha.convertirFechaACadena(new Date(), "dd MMM yyyy");
			String[] datosFecha = fecha.split(ExpresionesConstants.ESPACIO);
			
			canvas.showTextAligned(Element.ALIGN_CENTER, "TAPACHULA DE CORDOVA Y ORDONEZ".toUpperCase(), 313, 649, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, datosFecha[NumerosConstants.INT_CERO], 417, 649, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, datosFecha[NumerosConstants.INT_UNO].toUpperCase(), 482, 649, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, datosFecha[NumerosConstants.INT_DOS], 545, 649, 0);
			
			canvas.endText();
			canvas.restoreState();
			canvas.saveState();
			
			baseFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			
			canvas.setRGBColorStroke(0,0,0);
			canvas.setRGBColorFill(0,0,0);
			canvas.saveState();
			canvas.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL);
			canvas.setFontAndSize(baseFont, 12f);
			canvas.beginText();
			String agente = utileriaCadena.obtenerContenidoCadenaSinEspacios(user.getUsuario(), user.getUsuarioAgente());
			canvas.showTextAligned(Element.ALIGN_CENTER, agente, 151, 175, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, "X", 69, 492, 0);
			
			canvas.endText();
			canvas.restoreState();
			canvas.saveState();
			
			stamperPlantilla.close();
			plantilla.close();
			
			File archivoTemporal = new File(rutaTemporal);
			PDDocument documento = PDDocument.load(archivoTemporal);
			PDFRenderer renderer = new PDFRenderer(documento);
			ByteArrayOutputStream outputfile = new ByteArrayOutputStream();
			
			BufferedImage image = renderer.renderImage(NumerosConstants.INT_CERO);
			ImageIO.write(image, "png", outputfile);
			
			outputfile.flush();
			byte[] imagenByte = outputfile.toByteArray();
			outputfile.close();
			
			documento.close();
			
			imagenPDF = DatatypeConverter.printBase64Binary(imagenByte);
			
			if(!utileriaValidador.validarObjetoNulo(firma)) {
				InputStream principal = new FileInputStream(pathDocTemporal);
				InputStream excepcion = new FileInputStream(rutaTemporal);
				OutputStream salida = new FileOutputStream(pathDocDestino);
				this.agregarPDFs(Arrays.asList(principal, excepcion), salida, true);
				
				File ficheroPricipal = new File(pathDocTemporal);
				File ficheroExcepcion = new File(rutaTemporal);
				ficheroPricipal.delete();
				ficheroExcepcion.delete();
			}
		}catch (Exception e) {
			logger.error("Error al generar caida de datos", e);
		}
		return imagenPDF;
	}
	
	/**
	 * Metodo encargado de realizar la caida de los datos en el pdf de excepcion
	 * 
	 * @param streamOfPDFFiles
	 * @param outputStream
	 * @param paginate
	 */
	private void agregarPDFs(List<InputStream> streamOfPDFFiles, OutputStream outputStream, boolean paginate) {
		Document document = new Document();
		try {
			List<InputStream> pdfs = streamOfPDFFiles;
			List<PdfReader> readers = new ArrayList<PdfReader>();
			Iterator<InputStream> iteratorPDFs = pdfs.iterator();
			
			while (iteratorPDFs.hasNext()) {
				InputStream pdf = iteratorPDFs.next();
				PdfReader pdfReader = new PdfReader(pdf);
				readers.add(pdfReader);
			}
			
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			document.open();
			PdfContentByte cb = writer.getDirectContent();
 
			PdfImportedPage page;
			int pageOfCurrentReaderPDF = 0;
			Iterator<PdfReader> iteratorPDFReader = readers.iterator();
 
			while (iteratorPDFReader.hasNext()) {
				PdfReader pdfReader = iteratorPDFReader.next();
				while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
					Rectangle rectangle = pdfReader.getPageSizeWithRotation(1);
					document.setPageSize(rectangle);
					document.newPage();
					pageOfCurrentReaderPDF++;
					page = writer.getImportedPage(pdfReader, pageOfCurrentReaderPDF);
					switch (rectangle.getRotation()) {
					case 0:
						cb.addTemplate(page, 1f, 0, 0, 1f, 0, 0);
						break;
					case 90:
						cb.addTemplate(page, 0, -1f, 1f, 0, 0, pdfReader.getPageSizeWithRotation(1).getHeight());
						break;
					case 180:
						cb.addTemplate(page, -1f, 0, 0, -1f, 0, 0);
						break;
					case 270:
						cb.addTemplate(page, 0, 1.0F, -1.0F, 0, pdfReader.getPageSizeWithRotation(1).getWidth(), 0);
						break;
					default:
						break;
					}
					if (paginate) {
						cb.beginText();
						cb.getPdfDocument().getPageSize();
						cb.endText();
					}
				}
				pageOfCurrentReaderPDF = 0;
			}
			outputStream.flush();
			document.close();
			outputStream.close();
		} catch (Exception e) {
			logger.error("Error al generar pdf", e);
		} finally {
			if (document.isOpen())
				document.close();
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException ioe) {
				logger.error("Error IOException", ioe);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatosIdenExpediente obtenerDatosExpediente(Object datosPersonales, FlujoModificacion flujo) {
		DatosIdenExpediente datos = null;
		if(!utileriaValidador.validarObjetoNulo(datosPersonales)) {
			datos = new DatosIdenExpediente();
			String tipoSolicitante = "";
			String curp = "";
			String nss = "";
			String nombre = "";
			String apellidoPaterno = "";
			String apellidoMaterno = "";
			String curpSolicitante = "";
			String tipoAfiliacion = "";
			if(datosPersonales instanceof DatosTrabajador) {
				DatosTrabajador trabajador = (DatosTrabajador) datosPersonales;
				DatosCertificables datosCer = trabajador.getDatosCertificables();
				curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosCer.getCurp(), ExpresionesConstants.VACIO);
				nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getNss(), ExpresionesConstants.VACIO);
				nombre = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosCer.getNombre(), ExpresionesConstants.VACIO);
				apellidoPaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosCer.getApellidoPaterno(), ExpresionesConstants.VACIO);
				apellidoMaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosCer.getApellidoMaterno(), ExpresionesConstants.VACIO);
				tipoSolicitante = utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getTipoSolicitante(), ExpresionesConstants.VACIO);
				curpSolicitante = utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getCurpSolicitante(), ExpresionesConstants.VACIO);
				tipoAfiliacion = utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getTipoAfiliacion(), ExpresionesConstants.VACIO);
			} else if(datosPersonales instanceof EntradaModificacion) {
				EntradaModificacion entradaModificacion = (EntradaModificacion) datosPersonales;
				DatosBaseCurp datosBase = entradaModificacion.getDatosBaseCurp();
				curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getCurpNueva(), ExpresionesConstants.VACIO);
				nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaModificacion.getNss(), ExpresionesConstants.VACIO);
				nombre = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getNombreTrabajador(), ExpresionesConstants.VACIO);
				apellidoPaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getApellidoPaterno(), ExpresionesConstants.VACIO);
				apellidoMaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getApellidoMaterno(), ExpresionesConstants.VACIO);
				tipoSolicitante = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getTipoSolicitante(), ExpresionesConstants.VACIO);
				curpSolicitante = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getCurpSolicitante(), ExpresionesConstants.VACIO);
				tipoAfiliacion = utileriaCadena.obtenerContenidoCadenaSinEspacios(flujo.getTipoAfiliacion(), ExpresionesConstants.VACIO);
			} else if(datosPersonales instanceof EntradaPermanencia) {
				EntradaPermanencia entradaPermanencia = (EntradaPermanencia) datosPersonales;
				curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getCurpTrabajador(), ExpresionesConstants.VACIO);
				nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getNssTrabajador(), ExpresionesConstants.VACIO);
				nombre = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getNombreTrabajador(), ExpresionesConstants.VACIO);
				apellidoPaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getApellidoPaterno(), ExpresionesConstants.VACIO);
				apellidoMaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getApellidoMaterno(), ExpresionesConstants.VACIO);
				tipoSolicitante = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getTipoSolicitante(), ExpresionesConstants.VACIO);
				curpSolicitante = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getCurpSolicitante(), ExpresionesConstants.VACIO);
				tipoAfiliacion = utileriaCadena.obtenerContenidoCadenaSinEspacios(flujo.getTipoAfiliacion(), ExpresionesConstants.VACIO);
			}
			
			datos.setTipoSolicitante(tipoSolicitante);
			datos.setCurp(curp);
			datos.setNss(nss);
			datos.setNombre(nombre);
			datos.setApellidoPaterno(apellidoPaterno);
			datos.setApellidoMaterno(apellidoMaterno);
			datos.setCurpSolicitante(curpSolicitante);
			datos.setTipoAfiliacion(tipoAfiliacion);
		}
		return datos;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatosIdenExpediente obtenerDatosExpediente(DatosIdenExpediente datosExpe, Object datosDomicilio) {
		DatosIdenExpediente auxiliar = datosExpe;
		String calle = "";
		String noExterior = "";
		String noInterior = "";
		String colonia = "";
		String municipio = "";
		String entidad = "";
		String codigoPostal = "";
		
		if(datosDomicilio instanceof DatosTrabajador) {
			DatosTrabajador trabajador = (DatosTrabajador) datosDomicilio;
			Domicilio domicilio = trabajador.getDatosComplementarios().getParticular();
			if(!utileriaValidador.validarObjetoNulo(domicilio)) {
				calle = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCalle(), ExpresionesConstants.VACIO);
				noExterior = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNoExterior(), ExpresionesConstants.VACIO);
				noInterior = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNoInterior(), ExpresionesConstants.VACIO);
				colonia = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getColonia(), ExpresionesConstants.VACIO);
				municipio = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getMunicipio(), ExpresionesConstants.VACIO);
				entidad = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getClaveEntidadFed(), ExpresionesConstants.VACIO);
				codigoPostal = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCodigoPostal(), ExpresionesConstants.VACIO);
			}
		} else if(datosDomicilio instanceof EntradaModificacion) {
			EntradaModificacion trabajador = (EntradaModificacion) datosDomicilio;
			DatosDomicilioParticularTrabajador domicilio = trabajador.getDatosDomicilioParticularTrabajador();
			calle = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCalle(), ExpresionesConstants.VACIO);
			noExterior = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNumeroExterior(), ExpresionesConstants.VACIO);
			noInterior = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNumeroInterior(), ExpresionesConstants.VACIO);
			colonia = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getColonia(), ExpresionesConstants.VACIO);
			municipio = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getDelegacionOMunicipio(), ExpresionesConstants.VACIO);
			entidad = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getClaveEntidad(), ExpresionesConstants.VACIO);

			EntidadFederativa objEntidad = servicioCatalogo.obtenerEntidadFederativa(domicilio.getClaveEntidad());
			if(!utileriaValidador.validarObjetoNulo(objEntidad)) {
				entidad = objEntidad.getClaveCorta();
			}
			codigoPostal = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCodigoPostal(), ExpresionesConstants.VACIO);
		} else if(datosDomicilio instanceof EntradaPermanencia) {
			EntradaPermanencia trabajador = (EntradaPermanencia) datosDomicilio;
			DatosParticulares domicilio = trabajador.getDatosParticulares();
			calle = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCalle(), ExpresionesConstants.VACIO);
			noExterior = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNumeroExterior(), ExpresionesConstants.VACIO);
			noInterior = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNumeroInterior(), ExpresionesConstants.VACIO);
			colonia = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getColonia(), ExpresionesConstants.VACIO);
			municipio = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getDelegacionOMunicipio(), ExpresionesConstants.VACIO);
			entidad = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getClaveEntidad(), ExpresionesConstants.VACIO);
			EntidadFederativa objEntidad = servicioCatalogo.obtenerEntidadFederativa(domicilio.getClaveEntidad());
			if(!utileriaValidador.validarObjetoNulo(objEntidad)) {
				entidad = objEntidad.getClaveCorta();
			}
			codigoPostal = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCodigoPostal(), ExpresionesConstants.VACIO);
		}
		
		datosExpe.setCalle(calle);
		datosExpe.setNoExterior(noExterior);
		datosExpe.setNoInterior(noInterior);
		datosExpe.setColonia(colonia);
		datosExpe.setMunicipio(municipio);
		datosExpe.setEntidadFed(entidad);
		datosExpe.setCodigoPostal(codigoPostal);
		
		return auxiliar;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerIndicadorRfc(EntradaModificacion entradaModificacion,EntradaPermanencia entradaPermanencia,DatosNoCertificables datosNoCertificables) {
		String indicador = null;
		if(!utileriaValidador.validarObjetoNulo(entradaModificacion)) {
			indicador = validarSimilitudRfc(datosNoCertificables.getRfc(), entradaModificacion.getDatosBaseCurp().getRfc());
		}else if(!utileriaValidador.validarObjetoNulo(entradaPermanencia)) {
			indicador = validarSimilitudRfc(datosNoCertificables.getRfc(), entradaPermanencia.getRfc());
		}
		return indicador;			
	}
	
	/**
	 * Metodo que valida respuesta de indicador rfc
	 * @param curpBD
	 * @param curpObjeto
	 * @return
	 */
	private String validarSimilitudRfc(String curpBD,String curpObjeto) {
		String respuesta = NumerosConstants.C_CERO;
		String curpBDValor = utileriaCadena.asignarValor(curpBD);
		String curpObjetoValor = utileriaCadena.asignarValor(curpObjeto);
		if(!curpBDValor.equalsIgnoreCase(curpObjetoValor) && curpObjetoValor.length() == 13) {
			respuesta = NumerosConstants.C_UNO;
		}
		return respuesta;		
	}	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerProcesoExpediente(String solicitante) {
		logger.info("tipoSolicitante: {}",solicitante);
		String tipo = null;
		if(ServiciosConstants.TIPO_SOLICITANTE_TITULAR.equals(solicitante)) {
			tipo = ServiciosConstants.PROCESO_TIPO_SOLICITANTE_TITULAR;
		} else if(ServiciosConstants.TIPO_SOLICITANTE_BENEFICIARIO.equals(solicitante)) {
			tipo = ServiciosConstants.PROCESO_TIPO_SOLICITANTE_BENEFICIARIO;
		} else if(ServiciosConstants.TIPO_SOLICITANTE_REPRESENTANTE_LEGAL.equals(solicitante)){
			tipo = ServiciosConstants.PROCESO_TIPO_SOLICITANTE_REPRESENTANTE;
		} else if(ServiciosConstants.TIPO_SOLICITANTE_CURADOR.equals(solicitante)){
			tipo = ServiciosConstants.PROCESO_TIPO_SOLICITANTE_CURADOR;
		}
		logger.info("Proceso Expediente Identificacion: {}",tipo);
		return tipo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FolioComplemento obtenerDatosSolicitanteExpediente(EntradaSolicitante entradaSolicitante,Folio folioEntrada,String tipoTrabajador,UsuarioLogin user,String curpTitular) {
		String entidadFederativa = "";
		
		FolioComplemento folioComp = new FolioComplemento();
		folioComp.setIdFolio(folioEntrada.getIdFolioPulssar());
		folioComp.setTipoTrabajador(tipoTrabajador);
		String agente = utileriaValidador.validarVacio(user.getUsuarioAgente()) ? user.getUsuario() : user.getUsuarioAgente();
		folioComp.setAgentePromotor(agente);
		folioComp.setFechaControl(new Date());
		folioComp.setUsuarioModificador(user.getUsuario());
		folioComp.setApellioPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getDatosGeneralesSolicitante().getApellidoPaterno(), null));
		folioComp.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getDatosGeneralesSolicitante().getApellidoMaterno(), null));
		folioComp.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getDatosGeneralesSolicitante().getNombre(), null));
		folioComp.setCalle(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getDatosDomicilioSolicitante().getCalle(), null));
		folioComp.setNumeroExterior(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getDatosDomicilioSolicitante().getNumeroExterior(), null));
		folioComp.setNumeroInterior(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getDatosDomicilioSolicitante().getNumeroInterior(), null));
		folioComp.setColonia(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getDatosDomicilioSolicitante().getColonia(), null));
		folioComp.setMunicipio(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getDatosDomicilioSolicitante().getDelegacionOMunicipio(), null));
		folioComp.setCodigo(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getDatosDomicilioSolicitante().getCodigoPostal(), null));
		folioComp.setCurp(utileriaCadena.obtenerContenidoCadenaSinEspacios(curpTitular, null));
		folioComp.setTipoSolicitante(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getTipoSolicitante(), null));
		folioComp.setCurpSolicitante(utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaSolicitante.getDatosGeneralesSolicitante().getCurp(), null));
		entidadFederativa = entradaSolicitante.getDatosDomicilioSolicitante().getClaveEntidad();
		if(NumerosConstants.C_UNO.equals(entradaSolicitante.getTipoProceso())) {
			EntidadFederativa objEntidadMdd = servicioCatalogo.obtenerEntidadFederativa(entradaSolicitante.getDatosDomicilioSolicitante().getClaveEntidad());
			if(!utileriaValidador.validarObjetoNulo(objEntidadMdd)) {
				entidadFederativa = objEntidadMdd.getClaveCorta();
			}
		}else {
			EntidadFederativa objEntidadPerma = servicioCatalogo.obtenerEntidadFederativa(entradaSolicitante.getDatosDomicilioSolicitante().getClaveEntidad());
			if(!utileriaValidador.validarObjetoNulo(objEntidadPerma)) {
				entidadFederativa = objEntidadPerma.getClaveCorta();
			}
		}
		folioComp.setEntidadFederativa(utileriaCadena.obtenerContenidoCadenaSinEspacios(entidadFederativa, null));
		folioComp.setTipoProceso("04");

		return folioComp;
	}
}