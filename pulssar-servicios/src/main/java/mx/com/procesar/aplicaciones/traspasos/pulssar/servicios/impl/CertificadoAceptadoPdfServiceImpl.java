package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lowagie.text.Element;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CertificadoAceptadoPdfService;
import  mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CertificadoAceptadoCoordenadasEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Oct 10, 2019
 */
@Service
public class CertificadoAceptadoPdfServiceImpl implements CertificadoAceptadoPdfService {

	
	private static final Logger logger = LoggerFactory.getLogger(CertificadoAceptadoPdfServiceImpl.class);

	@Value("${ruta.pdf.reporte.aceptado}")
	private String ruta;
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CertificadoDerechoRetiroDesempleoPdf#generaReporte(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador)
	 */
	@Override
	public byte[] generaReporte(DatosTrabajador trabajador, UsuarioLogin login, String fechaInicio, String fechaFin, String inciso, String numResolucion) {
		logger.info("Metodo executeGeneraReporte");
		logger.info("Ruta Archivo pdf: {}", ruta);
		ByteArrayOutputStream outStreams = new ByteArrayOutputStream();
		PdfStamper stamper;
		BaseFont baseFont;
		PdfContentByte contentByte;

		byte[] bytes = null;
		try {
			InputStream pdfTemplateStream = new FileInputStream(ruta);
			PdfReader reader = new PdfReader(pdfTemplateStream);

			CertificadoAceptadoCoordenadasEnum nombre = CertificadoAceptadoCoordenadasEnum.obtenCoordenadas(PdfConstants.NOMBRE);
			CertificadoAceptadoCoordenadasEnum apellidoPat = CertificadoAceptadoCoordenadasEnum.obtenCoordenadas(PdfConstants.APELLIDO_PAT);
			CertificadoAceptadoCoordenadasEnum apellidoMat = CertificadoAceptadoCoordenadasEnum.obtenCoordenadas(PdfConstants.APELLIDO_MAT);
			CertificadoAceptadoCoordenadasEnum folio = CertificadoAceptadoCoordenadasEnum.obtenCoordenadas(PdfConstants.FOLIO);
			CertificadoAceptadoCoordenadasEnum nss = CertificadoAceptadoCoordenadasEnum.obtenCoordenadas(PdfConstants.NSS);
			CertificadoAceptadoCoordenadasEnum curp = CertificadoAceptadoCoordenadasEnum.obtenCoordenadas(PdfConstants.CURP);
			CertificadoAceptadoCoordenadasEnum nombreCompleto = CertificadoAceptadoCoordenadasEnum.obtenCoordenadas(PdfConstants.NOMBRE_COMPLETO);

			stamper = new PdfStamper(reader, outStreams);

			baseFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

			contentByte = stamper.getOverContent(1);

			// Color de fuente
			contentByte.saveState();
			contentByte.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL);
			contentByte.setFontAndSize(baseFont, 10f);
			contentByte.beginText();

			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getDatosCertificables().getNombre(), nombre.getX(), nombre.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getDatosCertificables().getApellidoPaterno(), apellidoPat.getX(), apellidoPat.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getDatosCertificables().getApellidoMaterno(), apellidoMat.getX(), apellidoMat.getY(), 0);

			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getNss(), nss.getX(), nss.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getDatosCertificables().getCurp(), curp.getX(), curp.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getNombreTrabajador(), nombreCompleto.getX(), nombreCompleto.getY(), 0);

			contentByte.setFontAndSize(baseFont, 7f);
			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getFolio().getFolio(), folio.getX(), folio.getY(), 0);

			contentByte.restoreState();

			stamper.close();
			bytes = outStreams.toByteArray();
		} catch (FileNotFoundException e) {
			logger.error("Archivo no encontrado: {}", e);

		} catch (IOException e) {
			logger.error("Error IOException: {}", e);

		} catch (Exception ex) {
			logger.error("Error Exception: {}", ex);

		}
		return bytes;
	}

}
