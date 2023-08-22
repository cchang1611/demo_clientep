/**
 * PdfUtils.java
 * Fecha de creación: 02/10/2019, 11:42:16
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * Utilerias para la creacion y manejo de PDFs
 * 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 02/10/2019
 */
public interface PdfUtils {

	/**
	 * Metodo de seteo de texto
	 * 
	 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 * @param texto
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @throws IOException
	 */
	void agregarTexto(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY) throws IOException;

	/**
	 * Agrega el texto
	 * @param texto
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @throws IOException
	 */
	void agregarTexto(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, String var) throws IOException; 
		
		
	/**
	 * @param imagenCadena
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @param ancho
	 * @param alto
	 * @throws IOException
	 */
	void agregarFirma(String imagenCadena, PDDocument pdfDocument, int numPagina, float posX, float posY, int ancho, int alto) throws IOException;

	/**
	 * @param imagenCadena
	 * @param anchoFijo
	 * @param altoFijo
	 * @return
	 * @throws IOException
	 */
	BufferedImage obtenerImagenTamano(String imagenCadena, int anchoFijo, int altoFijo) throws IOException;

	/**
	 * 
	 * Agrega texto al archivo PDF con espacio entre palabras y letras
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param texto
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @param espaciadoLetra
	 * @param espaciadoPalabra
	 * @throws IOException
	 */
	void agregarTextoConEspaciado(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, float espaciadoLetra, float espaciadoPalabra, int fontSize) throws IOException;
	/**
	 * 
	 * Agrega texto al archivo PDF con espacio entre palabras y letras
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param texto
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @throws IOException
	 */
	void agregarTextoConEspaciado(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY) throws IOException;

	/**
	 * 
	 * Agrega texto al archivo PDF con espacio entre palabras y letras
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param texto
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @param espaciadoLetra
	 * @throws IOException
	 */
	void agregarTextoConEspaciado(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, float espaciadoLetra) throws IOException;

	/**
	 * 
	 * agrega texto al archivo PDF
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param texto
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @throws IOException
	 */
	void agregarTextoLeyenda(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, float fontSize) throws IOException;

	/**
	 * 
	 * agrega una imagen al documento PDF
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param imagenCadena
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @throws IOException
	 */
	void agregarImagen(String imagenCadena, PDDocument pdfDocument, int numPagina, float posX, float posY) throws IOException;


	/**
	 * @param imagenCadena
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @throws IOException
	 */
	void agregarImagen(BufferedImage imagenCadena, PDDocument pdfDocument, int numPagina, float posX, float posY)
			throws IOException;

	/**
	 * @param texto
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @param fontsize
	 * @throws IOException
	 */
	void agregarTexto(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, int fontsize)
			throws IOException;

	/**
	 * @param texto
	 * @param pdfDocument
	 * @param numPagina
	 * @param posX
	 * @param posY
	 * @param espaciadoLetra
	 * @param fontSize
	 * @throws IOException
	 */
	void agregarTextoConEspaciado(String texto, PDDocument pdfDocument, int numPagina, float posX, float posY, float espaciadoLetra, int fontSize) throws IOException;

	

}
