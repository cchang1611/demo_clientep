package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.GENERO_FEMENINO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.GENERO_MASCULINO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.MARCA_MAYUSCULA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PREFIJO_ARCHIVO_TEMPORAL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.SUFIJO_ARCHIVO_TEMPORAL;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.common.io.Files;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudRetiroParcialMatrimonioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDocumentoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialMatrimonio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CodigoUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils;

/**
 * Servicio que implementa Solcitud RetiroParcial Matrimonio
 * 
 * @author ANOSORIO
 *
 */
@Service
public class SolicitudRetiroParcialMatrimonioServiceImpl implements SolicitudRetiroParcialMatrimonioService {
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(SolicitudRetiroParcialMatrimonioServiceImpl.class);

	/**
	 * Ruta archivo pdf destino
	 */
	@Value("${ruta.carpeta.expediente}")
	private String rutaDestino;

	/**
	 * Ruta archivo pdf origen
	 */
	@Value("${ruta.archivos.docs}")
	private String rutaDocs;

	/**
	 * utilerias codigoUtils
	 */
	@Autowired
	private CodigoUtils codigoUtils;

	@Autowired
	private PdfUtils pdfUtils;

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.servicios.retiros.certificacionoperacion07matrimonio.
	 * servicios.SolicitudRetiroParcialService#generaReporte(mx.com.procesar.
	 * servicios.retiros.certificacionoperacion07matrimonio.servicios.modelo.
	 * SolicitarCertificacionMatrimonioEntrada)
	 */
	@Override
	public byte[] generaSolicitudPdf(SolicitarCertificacionMatrimonioEntrada entrada, DatosTrabajador datosTrabajador, DatosDocumentoPdf datos, RetiroDesempleoImss retiroMatrimonioImss, String firmaEmpleado, String firmaAgente,EntradaConsulta consulta, UsuarioLogin user) {
		logger.info("Imp - generaSolicitudPdf");
		PDDocument pdfDocument = null;

		try {
			String path = null;

			path = StringUtils.join(rutaDocs, datosTrabajador.getClaveAfore(), PdfConstants.SEPARADOR_FECHA, PdfConstants.RP_MIMSSS);
			pdfDocument = obtenerPlantilla(path);
			entrada.setNombreArchivo("generaSolicitudPdfSalida.pdf");
			agregarSolicitudMatrimonio(entrada, pdfDocument, datosTrabajador, datos, firmaEmpleado, firmaAgente, consulta, user);
			return obtenerPdf(pdfDocument, entrada.getNombreArchivo());
		} catch (Exception e) {
			logger.error("Error al generar la solicitud de retiro parcial por Matrimonio:", e);
			return new byte[0];
		} finally {
			cerrarPlantilla(pdfDocument);
		}

	}

	/**
	 * Cierra plantilla
	 * 
	 * @param pdfDocument
	 */
	protected void cerrarPlantilla(PDDocument pdfDocument) {
		logger.info("cerrando plantilla");
		if (pdfDocument != null) {
			try {
				pdfDocument.close();
			} catch (IOException e) {
				logger.error("Error al cerrar la plantilla", e);
			}
		}

	}

	/**
	 * Obtiene el pdf,ruta,destino
	 * 
	 * @param pdfDocument
	 * @param nombreArchivo
	 * @return
	 * @throws IOException
	 */
	protected byte[] obtenerPdf(PDDocument pdfDocument, String nombreArchivo) throws IOException {
		File archivoTemporal = File.createTempFile(PREFIJO_ARCHIVO_TEMPORAL, SUFIJO_ARCHIVO_TEMPORAL);
		pdfDocument.save(archivoTemporal);
		int tamanoArchivo = (int) archivoTemporal.length();
		int bytesLeidos = 0;
		byte[] contenido = new byte[tamanoArchivo];
		String archivoPdfdestino = new StringBuilder().append(nombreArchivo).append(ExpresionesConstants.EXTENSION_PDF).toString();
		if (archivoPdfdestino != null && !archivoPdfdestino.isEmpty()) {
			StringBuilder ruta = new StringBuilder(rutaDestino);
			ruta.append(File.separator);
			File archivoPdf = new File(ruta.toString(), archivoPdfdestino);
			Files.copy(archivoTemporal, archivoPdf);
		}

		try (FileInputStream entrada = new FileInputStream(archivoTemporal)) {
			bytesLeidos = entrada.read(contenido);
		}

		if (bytesLeidos != tamanoArchivo) {
			logger.error("error al leer el archivo temporal del pdf");
			throw new BusinessException("error al leer el archivo temporal del pdf");
		}

		return contenido;
	}

	/**
	 * Establece las coordenadas de los campos
	 * 
	 * @param entrada
	 * @param pdfDocument
	 * @param datosTrabajador
	 * @param datosPagoBanco
	 * @throws IOException
	 */
	private void agregarSolicitudMatrimonio(SolicitarCertificacionMatrimonioEntrada entrada, PDDocument pdfDocument, DatosTrabajador datosTrabajador, DatosDocumentoPdf datos, String firmaEmpleado, String firmaAgente, EntradaConsulta consulta, UsuarioLogin user) throws IOException {
		int numeroPagina = 0;
		DatosSolicitudRetiroParcialMatrimonio datosPdf = (DatosSolicitudRetiroParcialMatrimonio) datos.getDatos();

		agregarDatosPersonales(datosTrabajador,pdfDocument,numeroPagina);
		agregarDatosTrabajadorYAgente(datosTrabajador, consulta, pdfDocument,numeroPagina, user);
		agregarDatosParticular(datosTrabajador, pdfDocument, numeroPagina);
		agregarDatosTipoGenero(datosTrabajador,pdfDocument,numeroPagina);
		agregarDatosConyuge(entrada,pdfDocument,numeroPagina);
		agregarFormaPago(datosPdf.getFormaPago(), datosPdf.getInstitucionBancaria(), datosPdf.getNumeroSucursalBancaria(), datosPdf.getClabe(), datosPdf.getReferenciaPago(), datosPdf.getOtroMedioPago(), pdfDocument);

		// firmas
		pdfUtils.agregarFirma(firmaEmpleado == null ? ExpresionesConstants.VACIO : firmaEmpleado, pdfDocument, numeroPagina, 30.0f, 185.0f, 100, 35);
		pdfUtils.agregarFirma(firmaAgente == null ? ExpresionesConstants.VACIO : firmaAgente, pdfDocument, numeroPagina, 320.0f, 185.0f, 100, 35);

		// fecha de generaicon de solicitud
		Date hoy = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd - MMM - yyyy", new Locale("es", "MX"));
		pdfUtils.agregarTexto(sdf.format(hoy), pdfDocument, numeroPagina + 1, 285, 507, 9);
		pdfUtils.agregarTexto(sdf.format(hoy), pdfDocument, numeroPagina, 485, 687, 11);

		pdfUtils.agregarTexto(datosPdf.getNumeroFolio() == null ? ExpresionesConstants.VACIO : datosPdf.getNumeroFolio(), pdfDocument, numeroPagina, 460, 710, 10);
		pdfUtils.agregarTextoConEspaciado(datosPdf.getNumeroUnidad() == null ? ExpresionesConstants.VACIO : datosPdf.getNumeroUnidad(), pdfDocument, numeroPagina, 395, 684, 1.8f, 11);
	}

	/**
	 * Datos Trabajador
	 * 
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 * @throws ParseException
	 */
	protected void agregarDatosTrabajadorYAgente(DatosTrabajador datosTrabajador,  EntradaConsulta consulta, PDDocument pdfDocument, int numeroPagina, UsuarioLogin user) throws IOException {
		if (!codigoUtils.validarObjeto(datosTrabajador.getDatosCertificables())) {
			// en este orden dia mes anio
			String fechaNacimiento = datosTrabajador.getDatosCertificables().getFechaNacimiento();
			String fechaNac = convertirFechaDate(fechaNacimiento);
			pdfUtils.agregarTextoConEspaciado(fechaNac.substring(0, 2), pdfDocument, numeroPagina, 335, 618, 1.5f, 11);
			pdfUtils.agregarTextoConEspaciado(fechaNac.substring(3, 5), pdfDocument, numeroPagina, 364, 618, 1.5f, 11);
			pdfUtils.agregarTextoConEspaciado(fechaNac.substring(6, 10), pdfDocument, numeroPagina, 393, 618, 1.5f, 11);
			// --------------------------
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosCertificables().getCurp(), pdfDocument, numeroPagina, 21, 585, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getTelefonos().getTelefonoFijo(), pdfDocument, numeroPagina, 272, 585, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getTelefonos().getCelular(), pdfDocument, numeroPagina, 272, 563, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getCorreoElectronico(), pdfDocument, numeroPagina, 114, 535, 1.9f, 11);
			
			boolean isTercero = !"01".equals(datosTrabajador.getTipoSolicitante());
			pdfUtils.agregarTexto(isTercero ? consulta.getNombre() : datosTrabajador.getDatosCertificables().getNombre(), pdfDocument, numeroPagina, 140, 205, 10);
			pdfUtils.agregarTexto(isTercero ? consulta.getApellidoPaterno()  : datosTrabajador.getDatosCertificables().getApellidoPaterno(), pdfDocument, numeroPagina, 140, 195, 10);
			pdfUtils.agregarTexto(isTercero ? consulta.getApellidoMaterno()  : datosTrabajador.getDatosCertificables().getApellidoMaterno(), pdfDocument, numeroPagina, 140, 185, 10);
			
			pdfUtils.agregarTexto(user.getSoloNombre(), pdfDocument, numeroPagina, 430, 208, 10);
			pdfUtils.agregarTexto(user.getApellidoPaterno(), pdfDocument, numeroPagina, 430, 198, 10);
			pdfUtils.agregarTexto(user.getApellidoMaterno(), pdfDocument, numeroPagina, 430, 188, 10);
			
			
			
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosExpediente().getCurpAgente(), pdfDocument, numeroPagina, 409, 175, 1.9f, 11);
		}

	}

	/**
	 * 
	 * @param fechaNacimiento
	 * @return
	 */
	protected String convertirFechaDate(String fechaNacimiento) {
		String fechaSalida;
		Date date = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MMM/yyyy", new Locale("es"));

		try {
			date = formato.parse(fechaNacimiento);
		} catch (ParseException e) {
			logger.error("Error Conversion fecha:{}", e);
		}
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		fechaSalida = dateFormat.format(date);
		return fechaSalida;
	}

	/**
	 * Agrega coordenadas datos Personales
	 * 
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregarDatosPersonales(DatosTrabajador datosTrabajador, PDDocument pdfDocument, int numeroPagina) throws IOException {
		if (!codigoUtils.validarObjeto(datosTrabajador.getDatosCertificables())) {
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosCertificables().getNombre(), pdfDocument, numeroPagina, 21, 661, 2.6f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosCertificables().getApellidoPaterno(), pdfDocument, numeroPagina, 21, 640, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosCertificables().getApellidoMaterno(), pdfDocument, numeroPagina, 311, 640, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getNss(), pdfDocument, numeroPagina, 22, 618, 1.5f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosNoCertificables().getRfc(), pdfDocument, numeroPagina, 170, 618, 1.8f, 11);
		}

	}

	/**
	 * Agrega coordenadas datos tipogenero
	 * 
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregarDatosTipoGenero(DatosTrabajador datosTrabajador, PDDocument pdfDocument, int numeroPagina) throws IOException {
		if (GENERO_FEMENINO.equals(datosTrabajador.getDatosCertificables().getGenero() == null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getGenero())) {
			pdfUtils.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 562, 622);
		} else if (GENERO_MASCULINO.equals(datosTrabajador.getDatosCertificables().getGenero() == null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getGenero())) {
			pdfUtils.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 534, 622);
		}

	}

	/**
	 * Agrega coordenadas datos del conyuge
	 * 
	 * @param entrada
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregarDatosConyuge(SolicitarCertificacionMatrimonioEntrada entrada, PDDocument pdfDocument, int numeroPagina) throws IOException {
		if (!codigoUtils.validarObjeto(entrada)) {
			pdfUtils.agregarTextoConEspaciado(StringUtils.upperCase(entrada.getNombreConyuge()), pdfDocument, numeroPagina, 21, 375, 2.5f, 11);
			pdfUtils.agregarTextoConEspaciado(StringUtils.upperCase(entrada.getApellidoPaternoConyuge()), pdfDocument, numeroPagina, 21, 352, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(StringUtils.upperCase(entrada.getApellidoMaternoConyuge()), pdfDocument, numeroPagina, 311, 352, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(StringUtils.upperCase(entrada.getDescEntidadEmisionActa()), pdfDocument, numeroPagina, 120, 504, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(entrada.getFechaMatrimonio().substring(0, 4), pdfDocument, numeroPagina, 48, 504, 1.3f, 11);
		}
	}

	/**
	 * Agrega coordenadas datos Particular
	 * 
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregarDatosParticular(DatosTrabajador datosTrabajador, PDDocument pdfDocument, int numeroPagina) throws IOException {
		if (!codigoUtils.validarObjeto(datosTrabajador.getDatosComplementarios().getParticular())) {
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getParticular().getCalle(), pdfDocument, numeroPagina, 20, 463, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getParticular().getNoExterior(), pdfDocument, numeroPagina, 312, 463, 1.5f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getParticular().getNoInterior(), pdfDocument, numeroPagina, 359, 463, 1.5f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getParticular().getCodigoPostal(), pdfDocument, numeroPagina, 406, 463, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getParticular().getPais(), pdfDocument, numeroPagina, 457, 463, 1.5f, 11);

			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getParticular().getColonia(), pdfDocument, numeroPagina, 20, 442, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getParticular().getEntidadFederativa(), pdfDocument, numeroPagina, 310, 442, 1.9f, 11);// POBLACION
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getParticular().getMunicipio(), pdfDocument, numeroPagina, 20, 420, 1.9f, 11);
			pdfUtils.agregarTextoConEspaciado(datosTrabajador.getDatosComplementarios().getParticular().getEntidadFederativa(), pdfDocument, numeroPagina, 310, 420, 1.9f, 11);// ENTIDAD FEDERTIVA
		}

	}

	/**
	 * Agrega coordenadas datos forma de pago
	 * 
	 * @param formaPago
	 * @param institucionBancaria
	 * @param numeroSucursalBancaria
	 * @param clabe
	 * @param referenciaPago
	 * @param otroMedioPago
	 * @param pdfDocument
	 * @throws IOException
	 */
	protected void agregarFormaPago(String formaPago, String institucionBancaria, String numeroSucursalBancaria, String clabe, String referenciaPago, String otroMedioPago, PDDocument pdfDocument) throws IOException {
		int numeroPagina = 0;

		if (formaPago == null) {
			return;
		}

		switch (formaPago) {
		
		case "01":
			pdfUtils.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 28, 251f);// transferencia bancaria
			pdfUtils.agregarTexto("PAGO EN CAJAS COPPEL", pdfDocument, numeroPagina, 120, 251f);// transferencia bancaria
			break;
		// transferencia
		case "02":
			pdfUtils.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 28, 311f);// transferencia bancaria
			pdfUtils.agregarTexto(institucionBancaria, pdfDocument, numeroPagina, 108, 320f);
			pdfUtils.agregarTexto(numeroSucursalBancaria, pdfDocument, numeroPagina, 108, 312);
			pdfUtils.agregarTextoConEspaciado(clabe, pdfDocument, numeroPagina, 139, 297, 0.85f, 11);
			break;
		default:
			return;
		}

	}

	/**
	 * Obtiene la plantilla
	 * 
	 * @param resource
	 * @return
	 * @throws IOException
	 */
	protected PDDocument obtenerPlantilla(String resource) throws IOException {
		return PDDocument.load(new File(resource));
	}

}
