package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias;

import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteBitacora;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaExcel;


/**
 * Clase de utilería para la generación de Exceles con POI 3.17.
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 27/07/2020
 */
public interface PlataformaOperativaExcelUtil {

    /**
     * Ajusta en la paleta del documento al color con los valores especificados
     * @param wb
     * @param idColor
     * @param red
     * @param green
     * @param blue
     */
	void colocarColor(HSSFWorkbook wb, int idColor, int red, int green, int blue);

	/**
     * Devuelve un objeto HSSFCellStyle con el estilo para los nombres de columnas de la tabla de
     * los encabezados
     * @param wb
     * @param fontColor
     * @param bgColor
     * @param hAlignment
     * @param vAlignment
     * @param wrapText
     * @param borderColor
     * @return
     */
	HSSFCellStyle obtenerEstiloDeCelda(HSSFWorkbook wb, int fontColor, int bgColor,
		HorizontalAlignment hAlignment, VerticalAlignment vAlignment, boolean wrapText,
		int borderColor);

    /**
     * Agrega al estilo proporcionado un borde con el color especificado
     * @param style
     * @param color
     */
	void agregarBorde(HSSFCellStyle style, int color);

	/**
     * Devuelve un objeto HSSFCellStyle con el estilo para los nombres de columnas de la tabla de
     * resultados
     * @param wb
     * @param fontColor
     * @param fontSize
     * @param bgColor
     * @param wrapText
     * @return
     */
	HSSFCellStyle obtenerEstiloDeCeldaDos(HSSFWorkbook wb, int fontColor, int fontSize,
		int bgColor, boolean wrapText);

	/**
     * Establece los anchos de las columnas de la hoja, colWidth especifica los anchos de las
     * columnas medidos en caracteres
     * @param sheet
     * @param colWidth
     */
	void colocarTamanioColumna(HSSFSheet sheet, int[] colWidth);

	/**
     * Método que realiza la exportación a Excel de un reporte.
     * @param respuestaExcel
     * @return
     * @throws IOException
     */
	HSSFWorkbook exportaExcel(RespuestaExcel respuestaExcel)  throws IOException;
	
	/**
     * Método que realiza la exportación a Excel de la bitácora de accesos de usuarios.
     * @param bitacoraExcel
     * @return
     */
	HSSFWorkbook exportaBitacoraExcel(List<ReporteBitacora> bitacoraExcel);
}
