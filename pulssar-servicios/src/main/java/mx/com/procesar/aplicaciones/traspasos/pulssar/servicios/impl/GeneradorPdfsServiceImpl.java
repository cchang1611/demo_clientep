/**
 * GeneradorPdfsServiceImpl.java
 * Fecha de creación: Oct 4, 2019, 4:46:30 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PREFIJO_ARCHIVO_TEMPORAL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.SUFIJO_ARCHIVO_TEMPORAL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_CERO;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.google.common.io.Files;
import com.lowagie.text.Annotation;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BanortePdfService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelPdfService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PeisPdfService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionRecursosImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenerarPdfTipoEntradaEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaGenerarPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.GenerarPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaTramite;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CodigoUtils;

/**
 * implementacion de los servicios para generar los PDF's
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Oct 4, 2019
 */
@Service
public class GeneradorPdfsServiceImpl implements GeneradorPdfsService {
	/**
	 * logger de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(GeneradorPdfsServiceImpl.class);

	/**
	 * Tamaño de la fuente
	 */
	public static final Float FUENTE_TAMANO = 10F;
	
	/**
	 * ruta donde se depositaran los pdf
	 */
	@Value("${ruta.carpeta.expediente}")
	private String rutaDestino;

	/**
	 * ruta donde se obtienen pdfs
	 */
	@Value("${ruta.archivos.docs}")
	private String rutaDocs;
	
	/**
	 * urlGenerarPdf
	 */
	@Value("${url.generar.pdf.comunes.pulssar}")
	private String urlGenerarPdf;

	/**
	 * utilerias codigoUtils
	 */
	@Autowired
	private CodigoUtils codigoUtils;
	
	
	/**
	 * llenado pdf banorte
	 */
	@Autowired
	private BanortePdfService bnrtService;

	/**
	 * llenado pdf coppel
	 */
	@Autowired
	private CoppelPdfService cpplService;

	/**
	 * llenado pdf peis
	 */
	@Autowired
	private PeisPdfService peisService;

	/**
	 * SolicitudDisposicionRecursosImssService
	 */
	@Autowired
	private SolicitudDisposicionRecursosImssService dispTotalesImss;
	
	/*  La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService#generarSolicitudRetiroParcialDesempleo(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo, java.lang.String, java.lang.Boolean)
	 */
	@Override
	public byte[] generarSolicitudRetiroParcialDesempleo(DatosSolicitudRetiroParcialDesempleo solicitud, String afore, Boolean flujo532) {
		PDDocument pdfDocument = null;

		try {
			String path;

			if (PdfConstants.BANORTE.equals(afore)) {
				path = StringUtils.join(rutaDocs, afore, PdfConstants.SEPARADOR_FECHA, PdfConstants.RP_IMSS);
				pdfDocument = obtenerPlantilla(path);
				bnrtService.agregarSolicitudRetiroParcialDesempleoPaginaUnoBanorte(solicitud, pdfDocument);
			}
			if (PdfConstants.COPPEL.equals(afore)) {
				path = StringUtils.join(rutaDocs, afore, PdfConstants.SEPARADOR_FECHA, PdfConstants.RP_IMSS);
				pdfDocument = obtenerPlantilla(path);
				cpplService.agregarSolicitudRetiroPorDesempleoPaginaUnoCoppel(solicitud, pdfDocument);
				cpplService.agregarSolicitudRetiroPorDesempleoPaginaDosCoppel(solicitud, pdfDocument, flujo532);
			}
			if (PdfConstants.PEIS.equals(afore)) {
				path = StringUtils.join(rutaDocs, afore, PdfConstants.SEPARADOR_FECHA, PdfConstants.RP_IMSS);
				pdfDocument = obtenerPlantilla(path);
				//peisService.agregarSolicitudRetiroParcialDesempleoPaginaUno(solicitud, pdfDocument);
				peisService.agregarSolicitudRetiroParcialDesempleoPaginaDos(solicitud, pdfDocument);
			}
			boolean salvar;

			if (PdfConstants.BANORTE.equals(afore)) {
				salvar = true;
			} else {
				salvar = !codigoUtils.esVacio(solicitud.getFirmaEmpleado()) && !codigoUtils.esVacio(solicitud.getFirmaAgente());
			}

			return obtenerPdf(pdfDocument, salvar, solicitud.getNombreArchivo());
		} catch (Exception e) {
			logger.error("Error al generar la solicitud de retiro parcial de desempleo:", e);
			return new byte[0];
		} finally {
			cerrarPlantilla(pdfDocument);
		}
	}

	
	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService#generarSolicitudRetiroParcialDesempleoIssste(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste, java.lang.String)
	 */
	@Override
	public byte[] generarSolicitudRetiroParcialDesempleoIssste(DatosSolicitudRetiroParcialDesempleoIssste solicitud, String afore) {
		PDDocument pdfDocument = null;
		String path;
		try {

			if (PdfConstants.BANORTE.equals(afore)) {
				path = StringUtils.join(rutaDocs, afore, PdfConstants.SEPARADOR_FECHA, PdfConstants.RP_ISSSTE);
				pdfDocument = obtenerPlantilla(path);
				bnrtService.generarSolicitudDisposicionParcialIsssteBanorte(solicitud, pdfDocument, INT_CERO);
			}
			if (PdfConstants.PEIS.equals(afore)) {
				path = StringUtils.join(rutaDocs, afore, PdfConstants.SEPARADOR_FECHA, PdfConstants.RP_ISSSTE);
				pdfDocument = obtenerPlantilla(path);
				peisService.generarSolicitudDisposicionParcialIssste(solicitud, pdfDocument, INT_CERO);
			}
			boolean salvar;
			if (PdfConstants.BANORTE.equals(afore)) {
				salvar = true;
			} else {
				salvar = !codigoUtils.esVacio(solicitud.getFirmaTrabajador()) && !codigoUtils.esVacio(solicitud.getFirmaAgente());
			}

			return obtenerPdf(pdfDocument, salvar, solicitud.getNombreArchivo());
		} catch (Exception e) {
			logger.error("Error al generar la solicitud de retiro parcial de desempleo:", e);
			return new byte[0];
		} finally {
			cerrarPlantilla(pdfDocument);
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService#generaSolicitudIssstePdf(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste)
	 */
	@Override
	public byte[] generaSolicitudIssstePdf(DatosGeneralesDispIssste entradaParams) {
		logger.info("Imp - generaSolicitudPdf");
		PDDocument pdfDocument = null;
		try {
			String path = null;
//			if (PdfConstants.BANORTE.equals(entradaParams.getAforeTrabajador())) {
				path = StringUtils.join(rutaDocs, entradaParams.getAforeTrabajador(), PdfConstants.SEPARADOR_FECHA, ActivacionConstants.DISPOSICION_TOTAL_ISSSTE);
				pdfDocument = obtenerPlantilla(path);
				entradaParams.setNombreArchivo(ActivacionConstants.PDF_NOMBRE_ISSSTE);
//				dispTotalesIssste.agregarSolicitudIssste(entradaParams, pdfDocument);
//			}
			return obtenerPdf(pdfDocument, false, entradaParams.getNombreArchivo());
		} catch (Exception e) {
			logger.error("Error al generar la solicitud de retiro parcial por Matrimonio:", e);
			return new byte[0];
		} finally {
			cerrarPlantilla(pdfDocument);
		}
	}
	
	
	/**
	 * 
	 * obtiene la plantilla
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param resource
	 * @return
	 * @throws IOException
	 */
	private PDDocument obtenerPlantilla(String resource) throws IOException {
		return PDDocument.load(new File(resource));
	}


	/**
	 * 
	 * genera y envia el pdf generado
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param pdDocument
	 * @return
	 * @throws IOException
	 * @throws COSVisitorException
	 * @throws Exception
	 */
	protected byte[] obtenerPdf(PDDocument pdDocument, boolean salvar, String nombreArchivo) throws IOException {
		File archivoTemporal = File.createTempFile(PREFIJO_ARCHIVO_TEMPORAL, SUFIJO_ARCHIVO_TEMPORAL);
		pdDocument.save(archivoTemporal);
		int tamanoArchivo = (int) archivoTemporal.length();
		int bytesLeidos = 0;
		byte[] contenido = new byte[tamanoArchivo];

		if (salvar && nombreArchivo != null && !nombreArchivo.isEmpty()) {
			StringBuilder ruta = new StringBuilder(rutaDestino);
			ruta.append(File.separator);
			File archivoPdf = new File(ruta.toString(), nombreArchivo);
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
	 * 
	 * se cierra el pdf de la plantilla
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param pdfDocument
	 */
	private void cerrarPlantilla(PDDocument pdfDocument) {
		if (pdfDocument != null) {
			try {
				pdfDocument.close();
			} catch (IOException e) {
				logger.error("Error al cerrar la plantilla", e);
			}
		}
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService
	 * #guardarArchivoServidor(byte[], java.lang.String)
	 */
	@Override
	public File guardarArchivoServidor(byte[] contenidoArchivo, String nombreArchivo) throws IOException {
		StringBuilder nombreCompleto = new StringBuilder(rutaDestino);
		nombreCompleto.append(File.separator).append(nombreArchivo);
		File archivo = new File(nombreCompleto.toString());

		try (BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(archivo))) {
			salida.write(contenidoArchivo);
		}

		return archivo;
	}


	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService
	 * #generarPdf(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * GenerarPdf)
	 */
	@Override
	public byte[] generarPdf(GenerarPdf generarPdf) {
		try {

			ByteArrayOutputStream outStreams = new ByteArrayOutputStream();
			InputStream pdfTemplateStream = new FileInputStream(generarPdf.getRutaPdf());
			PdfReader reader = new PdfReader(pdfTemplateStream);
			PdfStamper stamper = new PdfStamper(reader, outStreams);
			PdfContentByte contentByte = stamper.getOverContent(1);

			// Fuentes
			BaseFont baseFont = BaseFont.createFont(BaseFont.TIMES_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			contentByte.setRGBColorStroke(0, 0, 0);
			contentByte.setRGBColorFill(0, 0, 0);
			contentByte.saveState();
			contentByte.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL);
			contentByte.setFontAndSize(baseFont, 12f);
			contentByte.beginText();

			for (EntradaGenerarPdf a : generarPdf.getEntrada()) {

				if (GenerarPdfTipoEntradaEnum.IMAGEN.equals(a.getGenerarPdfTipoEntrada())) {
					Image image = Image.getInstance(Base64Utils.decodeFromString(a.getValor()));
					image.scaleAbsolute(a.getWidth(), a.getHeight());
					image.setAbsolutePosition(a.getCoordenadas().getX(), a.getCoordenadas().getY());
					image.setAnnotation(new Annotation(0, 0, 0, 0, 3));
					contentByte.addImage(image);
				} else {
					contentByte.showTextAligned(a.getElemento(), a.getValor(), a.getCoordenadas().getX(), a.getCoordenadas().getY(), 0);					
				}

			}

			// Close
			stamper.close();
			outStreams.close();
			pdfTemplateStream.close();
			reader.close();
			contentByte.closePath();

			return outStreams.toByteArray();
		} catch (Exception e) {
			logger.error("Error", e);
		}

		return new byte[0];
	}


	/* La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService#guardarArchivo(byte[], java.lang.String)
	 */
	@Override
	public File guardarArchivo(byte[] contenidoArchivo, String rutaNombreArchivo) throws IOException {
		File archivo = new File(rutaNombreArchivo);

		try (BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(archivo))) {
			salida.write(contenidoArchivo);
		}

		return archivo;
	}


	/**
	 * generar solicitud imss
	 */
	@Override
	public byte[] generaSolicitudImssPdf(RespuestaTramite disposicionTotal, DatosTrabajador trabajador) {
		
		logger.info("Imp - generaSolicitudPdf");
		PDDocument pdfDocument = null;
		try {
			String path = null;
//			if (PdfConstants.BANORTE.equals(trabajador.getClaveAfore())) {
				path = StringUtils.join(rutaDocs,trabajador.getClaveAfore(), PdfConstants.SEPARADOR_FECHA, ActivacionConstants.PDF_DISPOSICION_TOTAL_IMSS);
				pdfDocument = obtenerPlantilla(path);
				disposicionTotal.setNombreArchivo(PdfConstants.ARCHIVO_SALIDA_IMSS);
				dispTotalesImss.agregarSolicitudImss(disposicionTotal, trabajador, pdfDocument);
//			}
			return obtenerPdf(pdfDocument, false, disposicionTotal.getNombreArchivo());
		} catch (Exception e) {
			logger.error("Error al generar la solicitud de imss:", e);
			return new byte[0];
		} finally {
			cerrarPlantilla(pdfDocument);
		}
	}

}
