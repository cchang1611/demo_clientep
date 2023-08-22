/**
 * PdfUtilsImpl.java
 * Fecha de creación: 02/10/2019, 11:43:26
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ESPACIADO_LETRA_0;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ESPACIADO_PALABRA_0;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.stereotype.Component;

import com.lowagie.text.pdf.codec.Base64;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils;
import net.coobird.thumbnailator.Thumbnails;

/**
 * Utilerias para la creacion y manejo de PDFs
 * 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 02/10/2019
 */
@Component
public class PdfUtilsImpl implements PdfUtils {

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarTexto(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public void agregarTexto(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY) throws IOException {
		if (texto == null || texto.isEmpty()) {
			return;
		}

		PDPage pagina = pdfDocument.getPage(numPagina);
		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pagina, AppendMode.APPEND, Boolean.FALSE, Boolean.TRUE);
		contentStream.beginText();
		contentStream.setFont(PDType1Font.COURIER, 11);
		contentStream.newLineAtOffset(posX, posY);
		contentStream.showText(StringUtils.upperCase(texto));
		contentStream.endText();
		contentStream.close();
	}
	
	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarTexto(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public void agregarTexto(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, int fontsize) throws IOException {
		if (texto == null || texto.isEmpty()) {
			return;
		}

		PDPage pagina = pdfDocument.getPage(numPagina);
		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pagina, AppendMode.APPEND, Boolean.FALSE, Boolean.TRUE);
		contentStream.beginText();
		contentStream.setFont(PDType1Font.COURIER, fontsize);
		contentStream.newLineAtOffset(posX, posY);
		contentStream.showText(StringUtils.upperCase(texto));
		contentStream.endText();
		contentStream.close();
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarTexto(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public void agregarTexto(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, String var) throws IOException {
		if (texto == null || texto.isEmpty()) {
			return;
		}

		PDPage pagina = pdfDocument.getPage(numPagina);
		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pagina, AppendMode.APPEND, Boolean.FALSE, Boolean.TRUE);
		contentStream.beginText();
		if (NumerosConstants.C_CERO.equals(var)) {
			contentStream.setFont(PDType1Font.HELVETICA, NumerosConstants.INT_SEIS);
		} else {
			contentStream.setFont(PDType1Font.HELVETICA, NumerosConstants.INT_SIETE);
		}

		contentStream.newLineAtOffset(posX, posY);
		contentStream.showText(texto);
		contentStream.endText();
		contentStream.close();
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarTexto(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public void agregarFirma(String imagenCadena, PDDocument pdfDocument, int numPagina, float posX, float posY, int ancho, int alto) throws IOException {
		if (imagenCadena == null || imagenCadena.isEmpty()) {
			return;
		}

		PDPage pagina = pdfDocument.getPage(numPagina);
		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pagina, AppendMode.APPEND, Boolean.FALSE);
		BufferedImage bufferImagen = obtenerImagenTamano(imagenCadena, ancho, alto);

		PDImageXObject imagen = LosslessFactory.createFromImage(pdfDocument, bufferImagen);
		contentStream.drawImage(imagen, posX, posY);
		contentStream.close();
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarTexto(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public BufferedImage obtenerImagenTamano(String imagenCadena, int anchoFijo, int altoFijo) throws IOException {
		BufferedImage imagen;
		byte[] imagenByte;

		imagenByte = Base64.decode(imagenCadena);
		imagen = ImageIO.read(new ByteArrayInputStream(imagenByte));

		BufferedImage cropped = cortarImagen(imagen);

		Image tmpd = blancoATransparencia(cropped, new Color(cropped.getRGB(0, 0)));
		BufferedImage imageTrans = imageToBuffered(tmpd, cropped.getWidth(), cropped.getHeight());

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Thumbnails.of(imageTrans).size(anchoFijo, altoFijo).outputFormat("PNG").outputQuality(1).toOutputStream(outputStream);
		byte[] data = outputStream.toByteArray();

		ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
		return ImageIO.read(inputStream);

	}

	/**
	 * @param source
	 * @return
	 */
	private BufferedImage cortarImagen(BufferedImage source) {

		int baseColor = source.getRGB(0, 0);

		int width = source.getWidth();
		int height = source.getHeight();

		int topY = Integer.MAX_VALUE;
		int topX = Integer.MAX_VALUE;
		int bottomY = -1;
		int bottomX = -1;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (toleranciaColor(baseColor, source.getRGB(x, y), 0.0)) {
					if (x < topX)
						topX = x;
					if (y < topY)
						topY = y;
					if (x > bottomX)
						bottomX = x;
					if (y > bottomY)
						bottomY = y;
				}
			}
		}

		BufferedImage destination = new BufferedImage(bottomX - topX + 1, bottomY - topY + 1, BufferedImage.TYPE_INT_ARGB);

		destination.getGraphics().drawImage(source, 0, 0, destination.getWidth(), destination.getHeight(), topX, topY, bottomX, bottomY, null);

		return destination;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarTexto(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public void agregarTextoConEspaciado(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, float espaciadoLetra, float espaciadoPalabra, int fontSize) throws IOException {
		if (texto == null || texto.isEmpty()) {
			return;
		}

		PDPage pagina = pdfDocument.getPage(numPagina);
		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pagina, AppendMode.APPEND, Boolean.FALSE);
		contentStream.beginText();
		//Default 7 
		contentStream.setFont(PDType1Font.COURIER, fontSize);
		contentStream.setCharacterSpacing(espaciadoLetra);
		contentStream.setWordSpacing(espaciadoPalabra);
		contentStream.newLineAtOffset(posX, posY);
		contentStream.showText(StringUtils.upperCase(texto.trim()));
		contentStream.endText();
		contentStream.close();
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarTexto(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public void agregarTextoConEspaciado(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY) throws IOException {
		agregarTextoConEspaciado(texto, pdfDocument, numPagina, posX, posY, ESPACIADO_LETRA_0, ESPACIADO_PALABRA_0, 7);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarTexto(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public void agregarTextoConEspaciado(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, float espaciadoLetra) throws IOException {
		agregarTextoConEspaciado(texto, pdfDocument, numPagina, posX, posY, espaciadoLetra, ESPACIADO_LETRA_0, 7);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarTexto(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public void agregarTextoConEspaciado(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, float espaciadoLetra, int fontSize) throws IOException {
		agregarTextoConEspaciado(texto, pdfDocument, numPagina, posX, posY, espaciadoLetra, ESPACIADO_LETRA_0, fontSize);
	}
	
	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarTextoLeyenda(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument,
	 * int, float, float, float)
	 */
	public void agregarTextoLeyenda(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, float fontSize) throws IOException {
		if (texto == null || texto.isEmpty()) {
			return;
		}

		PDPage pagina = pdfDocument.getPage(numPagina);
		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pagina, AppendMode.APPEND, Boolean.FALSE, Boolean.TRUE);
		contentStream.beginText();
		contentStream.setNonStrokingColor(Color.RED);
		contentStream.setFont(PDType1Font.COURIER, fontSize);
		contentStream.newLineAtOffset(posX, posY);
		contentStream.showText(texto);
		contentStream.endText();
		contentStream.close();
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarImagen(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public void agregarImagen(String imagenCadena, PDDocument pdfDocument, int numPagina, float posX, float posY) throws IOException {
		if (imagenCadena == null || imagenCadena.isEmpty()) {
			return;
		}

		PDPage pagina = pdfDocument.getPage(numPagina);
		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pagina, AppendMode.APPEND, Boolean.FALSE);
		BufferedImage bufferImagen = obtenerImagen(imagenCadena);
		AffineTransform escala = new AffineTransform();
		escala.scale(0.25, 0.25);
		AffineTransformOp operacionEscala = new AffineTransformOp(escala, AffineTransformOp.TYPE_BILINEAR);
		BufferedImage bufferedImagenEscalada = new BufferedImage(bufferImagen.getWidth(), bufferImagen.getHeight(), BufferedImage.TYPE_INT_ARGB);
		bufferedImagenEscalada = operacionEscala.filter(bufferImagen, bufferedImagenEscalada);
		PDImageXObject imagen = LosslessFactory.createFromImage(pdfDocument, bufferedImagenEscalada);
		contentStream.drawImage(imagen, posX, posY);
		contentStream.close();
	}
	
	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils#
	 * agregarImagen(java.lang.String, org.apache.pdfbox.pdmodel.PDDocument, int,
	 * float, float)
	 */
	@Override
	public void agregarImagen(BufferedImage imagenCadena, PDDocument pdfDocument, int numPagina, float posX, float posY) throws IOException {
		if (imagenCadena == null ) {
			return;
		}

		PDPage pagina = pdfDocument.getPage(numPagina);
		PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pagina, AppendMode.APPEND, Boolean.FALSE);
		
		PDImageXObject imagen = LosslessFactory.createFromImage(pdfDocument, imagenCadena);
		contentStream.drawImage(imagen, posX, posY);
		contentStream.close();
	}
	
	
	
	/**
	 * 
	 * obtiene la imagen a partir de la imagen en cadena
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param imagenCadena
	 * @return
	 * @throws IOException
	 */
	private BufferedImage obtenerImagen(String imagenCadena) throws IOException {
		BufferedImage imagen;
		byte[] imagenByte;

		imagenByte = Base64.decode(imagenCadena);
		imagen = ImageIO.read(new ByteArrayInputStream(imagenByte));

		return imagen;
	}

	/**
	 * @param a
	 * @param b
	 * @param tolerancia
	 * @return
	 */
	private boolean toleranciaColor(int a, int b, double tolerancia) {

		int aAlpha = (a & 0xFF000000 >>> 24);
		int aRed = (a & 0x00FF0000 >>> 16);
		int aGreen = (a & 0x0000FF00 >>> 8);
		int aBlue = (a & 0x000000FF);

		int bAlpha = (b & 0xFF000000 >>> 24);
		int bRed = (b & 0x00FF0000 >>> 16);
		int bGreen = (b & 0x0000FF00 >>> 8);
		int bBlue = (b & 0x000000FF);

		double distancia = Math.sqrt((aAlpha - bAlpha) * (aAlpha - bAlpha) + (aRed - bRed) * (aRed - bRed) + (aGreen - bGreen) * (aGreen - bGreen) + (aBlue - bBlue) * (aBlue - bBlue));
		double porcentajeDistancia = distancia / 510.0d;

		return porcentajeDistancia > tolerancia;
	}

	/**
	 * @param image
	 * @param color
	 * @return
	 */
	private Image blancoATransparencia(BufferedImage image, final Color color) {

		ImageFilter filter = new RGBImageFilter() {

			public int markerRGB = color.getRGB() | 0xFFFFFFFF;

			@Override
			public int filterRGB(int x, int y, int rgb) {
				if ((rgb | 0xFF000000) == markerRGB) {
					return 0x00FFFFFF & rgb;
				} else {
					return rgb;
				}
			}
		};
		ImageProducer ip = new FilteredImageSource(image.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}

	/**
	 * @param image
	 * @param width
	 * @param height
	 * @return
	 */
	private BufferedImage imageToBuffered(Image image, int width, int height) {

		BufferedImage dest = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = dest.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return dest;

	}

}
