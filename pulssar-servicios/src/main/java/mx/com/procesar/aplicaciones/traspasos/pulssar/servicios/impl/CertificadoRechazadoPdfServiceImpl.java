package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lowagie.text.Element;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CertificadoRechazadoPdfService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CertificadoRechazoCoordenadasEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

@Service
public class CertificadoRechazadoPdfServiceImpl implements CertificadoRechazadoPdfService {

	private static final Logger logger = LoggerFactory.getLogger(CertificadoRechazadoPdfServiceImpl.class);
	
	@Value("${ruta.pdf.reporte.rechazado}")
	private String ruta;


	@Override
	public byte[] generaReporte(DatosTrabajador trabajador, UsuarioLogin usuarioLogin) {
		logger.info("Metodo executeGeneraReporte");
		logger.info("Ruta Archivo pdf: {}", ruta);
		ByteArrayOutputStream outStreams = new ByteArrayOutputStream();
		PdfStamper stamper;
		BaseFont baseFont;
		PdfContentByte contentByte;
		Calendar cal = Calendar.getInstance();
		byte[] bytes = null;
		try {
			InputStream pdfTemplateStream = new FileInputStream(ruta);
			PdfReader reader = new PdfReader(pdfTemplateStream);

			CertificadoRechazoCoordenadasEnum nombre = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.NOMBRE);
			CertificadoRechazoCoordenadasEnum apellidoPat = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.APELLIDO_PAT);
			CertificadoRechazoCoordenadasEnum apellidoMat = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.APELLIDO_MAT);
			CertificadoRechazoCoordenadasEnum folio = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.FOLIO);
			CertificadoRechazoCoordenadasEnum nss = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.NSS);
			CertificadoRechazoCoordenadasEnum curp = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.CURP);
			CertificadoRechazoCoordenadasEnum nombreCompleto = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.NOMBRE_COMPLETO);
			CertificadoRechazoCoordenadasEnum diaMes = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.DIA_MES);
			CertificadoRechazoCoordenadasEnum mes = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.MES);
			CertificadoRechazoCoordenadasEnum anio = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.ANIO);
			CertificadoRechazoCoordenadasEnum nombreFuncionario = CertificadoRechazoCoordenadasEnum.obtenCoordenadas(PdfConstants.NOMBRE_FUNCIONARIO);
			

			stamper = new PdfStamper(reader, outStreams);

			baseFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

			contentByte = stamper.getOverContent(1);

			// Color de fuente
			contentByte.saveState();
			contentByte.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL);
			contentByte.setFontAndSize(baseFont, 10f);
			contentByte.beginText();
			
			String diaStr =  Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
			diaStr = StringUtils.leftPad(diaStr, 2, "0");
			
			String mesStr = Integer.toString(cal.get(Calendar.MONTH));
			mesStr = StringUtils.leftPad(mesStr, 2, "0");

			contentByte.showTextAligned(Element.ALIGN_LEFT, diaStr, diaMes.getX(), diaMes.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, mesStr, mes.getX(), mes.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, Integer.toString(cal.get(Calendar.YEAR)), anio.getX(), anio.getY(), 0);
			
			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getDatosCertificables().getNombre(), nombre.getX(), nombre.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getDatosCertificables().getApellidoPaterno(), apellidoPat.getX(), apellidoPat.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getDatosCertificables().getApellidoMaterno(), apellidoMat.getX(), apellidoMat.getY(), 0);

			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getNss(), nss.getX(), nss.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getDatosCertificables().getCurp(), curp.getX(), curp.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, trabajador.getNombreTrabajador(), nombreCompleto.getX(), nombreCompleto.getY(), 0);
			contentByte.showTextAligned(Element.ALIGN_LEFT, usuarioLogin.getNombre(), nombreFuncionario.getX(), nombreFuncionario.getY(), 0);

			contentByte.setFontAndSize(baseFont, 9f);
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
