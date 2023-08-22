package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteBitacora;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.PresentacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.PlataformaOperativaExcelUtil;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaExcel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;



/**
 * Implementación de la interfaz para la confección de estilos para Excel en POI 3.17.
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 27/07/2020
 */
@Component("plataformaOperativaExcelUtilImpl")
public class PlataformaOperativaExcelUtilImpl implements PlataformaOperativaExcelUtil {

    /**
     * Utileria para el manejo de fechas
     */
    @Autowired
    private FechaUtils fechaUtils;

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see
	 * mx.com.procesar.servicios.traspasos.plataforma.operativa.exposicion.utilerias.PlataformaOperativaExcelUtil#
	 * setColor(org.apache.poi.hssf.usermodel.HSSFWorkbook, int, int, int, int)
	 */
	@Override
	public void colocarColor(HSSFWorkbook wb, int idColor, int red, int green, int blue) {
		HSSFPalette palette = wb.getCustomPalette();
		palette.setColorAtIndex((short) idColor, (byte) red, (byte) green, (byte) blue);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see
	 * mx.com.procesar.servicios.traspasos.plataforma.operativa.exposicion.utilerias.PlataformaOperativaExcelUtil#
	 * getCellStyle(org.apache.poi.hssf.usermodel.HSSFWorkbook, int, int,
	 * org.apache.poi.ss.usermodel.HorizontalAlignment,
	 * org.apache.poi.ss.usermodel.VerticalAlignment, boolean, int)
	 */
	@Override
	public HSSFCellStyle obtenerEstiloDeCelda(HSSFWorkbook wb, int fontColor, int bgColor,
		HorizontalAlignment hAlignment, VerticalAlignment vAlignment, boolean wrapText,
		int borderColor) {
		HSSFCellStyle returnValue = obtenerEstiloDeCeldaDos(wb, fontColor, -1, bgColor, wrapText);
		agregarBorde(returnValue, borderColor);
		return returnValue;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see
	 * mx.com.procesar.servicios.traspasos.plataforma.operativa.exposicion.utilerias.PlataformaOperativaExcelUtil#
	 * addBorder(org.apache.poi.hssf.usermodel.HSSFCellStyle, int)
	 */
	@Override
	public void agregarBorde(HSSFCellStyle style, int color) {
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBottomBorderColor((short) color);
		style.setLeftBorderColor((short) color);
		style.setRightBorderColor((short) color);
		style.setTopBorderColor((short) color);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see
	 * mx.com.procesar.servicios.traspasos.plataforma.operativa.exposicion.utilerias.PlataformaOperativaExcelUtil#
	 * getCellStyle(org.apache.poi.hssf.usermodel.HSSFWorkbook, int, int, int, boolean)
	 */
	@Override
	public HSSFCellStyle obtenerEstiloDeCeldaDos(HSSFWorkbook wb, int fontColor, int fontSize,
		int bgColor, boolean wrapText) {
		HSSFCellStyle returnValue = wb.createCellStyle();
		if (-1 != bgColor) {
			returnValue.setFillForegroundColor((short) bgColor);
			returnValue.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}

		returnValue.setAlignment(HorizontalAlignment.CENTER);
		if (fontColor != -1 || fontSize != -1) {
			HSSFFont font = wb.createFont();
			if (fontColor != -1){
				font.setColor((short) fontColor);
			}
			if (fontSize != -1) {
				font.setFontHeightInPoints((short) fontSize);
			}
			returnValue.setFont(font);
		}
		returnValue.setWrapText(wrapText);
		returnValue.setVerticalAlignment(VerticalAlignment.CENTER);
		return returnValue;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo declara
	 * (non-Javadoc)
	 * @see
	 * mx.com.procesar.servicios.traspasos.plataforma.operativa.exposicion.utilerias.PlataformaOperativaExcelUtil#
	 * setColumnsSize(org.apache.poi.hssf.usermodel.HSSFSheet, int[])
	 */
	@Override
	public void colocarTamanioColumna(HSSFSheet sheet, int[] colWidth) {
		for (short i = 0; i < colWidth.length; i++) {
			sheet.setColumnWidth(i, colWidth[i] * 256);// en 256avos de caracter = colWidth[i] caracteres
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * mx.com.procesar.servicios.traspasos.plataforma.operativa.exposicion.utilerias.PlataformaOperativaExcelUtil#
	 * exportaExcel(mx.com.procesar.servicios.traspasos.plataforma.operativa.exposicion.modelo.
	 * RespuestaPlataformaOperativa)
	 */
	@Override
    public HSSFWorkbook exportaExcel(RespuestaExcel respuestaExcel) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(PresentacionConstants.SHEET);
		sheet.setDefaultColumnWidth(30);
		colocarColor(wb, IndexedColors.BLUE.getIndex(), 0, 57, 90);

		HSSFCell celda;
		int indColumna = 0;
		int regActual = 1;
		HSSFRow rowTituloReporte = sheet.createRow(0);
		celda = rowTituloReporte.createCell(indColumna);
		celda.setCellType(CellType.STRING);
		celda.setCellValue(null == respuestaExcel.getNombreReporte()? " " : respuestaExcel.getNombreReporte());
		celda.setCellStyle(estiloDatos(wb));
		
		
		HSSFRow rowEncabezado = sheet.createRow(regActual + 1);
		for (String nombreColumna : respuestaExcel.getNombreColumnas()) {
			celda = rowEncabezado.createCell(indColumna);
			celda.setCellType(CellType.STRING);
			celda.setCellValue(nombreColumna.trim());
			celda.setCellStyle(estiloEncabezadoColumnasCentro(wb));
			indColumna++;
		}
		int regDatos = 3;
		HSSFCell celdaDato;
		JsonNode jsonData = new ObjectMapper().readTree(respuestaExcel.getConsulta());
		Iterator<JsonNode> resp = jsonData.elements();
		while (resp.hasNext()) {
			JsonNode jsonNode = resp.next();
			HSSFRow rowdatos = sheet.createRow(regDatos + 1);
			rowdatos.setRowNum(regDatos);
			indColumna = 0;
			for (String llaveMapa : respuestaExcel.getNombreColumnas()) {
				celdaDato = rowdatos.createCell(indColumna);
				celdaDato.setCellType(CellType.STRING);
				celdaDato.setCellValue("null".equals(jsonNode.get(llaveMapa).asText()) ? "" : jsonNode.get(llaveMapa.trim()).asText());
				indColumna++;
			}
			regDatos++;
		}		
		
		for (int i = 0; i < jsonData.size(); i++) {
			sheet.autoSizeColumn(i);
		}
		return wb;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * mx.com.procesar.servicios.traspasos.plataforma.operativa.exposicion.utilerias.PlataformaOperativaExcelUtil#
	 * exportaBitacoraExcel(java.util.List)
	 */
	@Override
    public HSSFWorkbook exportaBitacoraExcel(List<ReporteBitacora> bitacoraExcel) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(PresentacionConstants.SHEET);
		sheet.setDefaultColumnWidth(30);
		colocarColor(wb, IndexedColors.BLUE.getIndex(), 0, 57, 90);

		int regActual = 1;
		HSSFRow rowEncabezado = sheet.createRow(regActual + 1);

		// ENCABEZADOS
        HSSFCell celdaIdReporte = rowEncabezado.createCell(0);
        celdaIdReporte.setCellType(CellType.STRING);
        celdaIdReporte.setCellValue("ID Reporte");
        celdaIdReporte.setCellStyle(estiloEncabezadoColumnasCentro(wb));

        HSSFCell celdaNombreReporte = rowEncabezado.createCell(1);
        celdaNombreReporte.setCellType(CellType.STRING);
        celdaNombreReporte.setCellValue("Nombre de Reporte");
        celdaNombreReporte.setCellStyle(estiloEncabezadoColumnasCentro(wb));

        HSSFCell celdaUsuarioRegistrado = rowEncabezado.createCell(2);
        celdaUsuarioRegistrado.setCellType(CellType.STRING);
        celdaUsuarioRegistrado.setCellValue("Usuario Registrado");
        celdaUsuarioRegistrado.setCellStyle(estiloEncabezadoColumnasCentro(wb));

        HSSFCell celdaIpUsuario = rowEncabezado.createCell(3);
        celdaIpUsuario.setCellType(CellType.STRING);
        celdaIpUsuario.setCellValue("IP Del Usuario");
        celdaIpUsuario.setCellStyle(estiloEncabezadoColumnasCentro(wb));

        HSSFCell celdaFechaEjecucion = rowEncabezado.createCell(4);
        celdaFechaEjecucion.setCellType(CellType.STRING);
        celdaFechaEjecucion.setCellValue("Fecha De Ejecución");
        celdaFechaEjecucion.setCellStyle(estiloEncabezadoColumnasCentro(wb));

        HSSFCell celdaParametrosBusqueda = rowEncabezado.createCell(5);
        celdaParametrosBusqueda.setCellType(CellType.STRING);
        celdaParametrosBusqueda.setCellValue("Parámetros De Búsqueda");
        celdaParametrosBusqueda.setCellStyle(estiloEncabezadoColumnasCentro(wb));

        HSSFCell celdaExportado = rowEncabezado.createCell(6);
        celdaExportado.setCellType(CellType.STRING);
        celdaExportado.setCellValue("Fue exportado");
        celdaExportado.setCellStyle(estiloEncabezadoColumnasCentro(wb));

        HSSFCell celdaUsuarioAplicativo = rowEncabezado.createCell(7);
        celdaUsuarioAplicativo.setCellType(CellType.STRING);
        celdaUsuarioAplicativo.setCellValue("Usuario Aplicativo");
        celdaUsuarioAplicativo.setCellStyle(estiloEncabezadoColumnasCentro(wb));

		// DATOS
		int regDatos = 3;
		HSSFCell celdaDato;
		HSSFRow rowdatos = sheet.createRow(regDatos + 1);
		for (int i = 0; i < bitacoraExcel.size(); i++) {
			regDatos++;
			rowdatos.setRowNum(regDatos);
			for (int j = 0; j < 8; j++) {
				celdaDato = rowdatos.createCell(0);
				celdaDato.setCellType(CellType.STRING);
				celdaDato.setCellValue(bitacoraExcel.get(i).getIdReporteGenerico());

				celdaDato = rowdatos.createCell(1);
				celdaDato.setCellType(CellType.STRING);
				celdaDato.setCellValue(bitacoraExcel.get(i).getNombreReporte());

				celdaDato = rowdatos.createCell(2);
				celdaDato.setCellType(CellType.STRING);
				celdaDato.setCellValue(bitacoraExcel.get(i).getUsuario());

				celdaDato = rowdatos.createCell(3);
				celdaDato.setCellType(CellType.STRING);
				celdaDato.setCellValue(bitacoraExcel.get(i).getIpOrigen());

				celdaDato = rowdatos.createCell(4);
				celdaDato.setCellType(CellType.STRING);
                celdaDato.setCellValue(
                    fechaUtils.convertirFechaACadena(bitacoraExcel.get(i).getFechaEjecucion(), PresentacionConstants.FORMATO_TMSTP));

				celdaDato = rowdatos.createCell(5);
				celdaDato.setCellType(CellType.STRING);
				celdaDato.setCellValue(bitacoraExcel.get(i).getParametros());

				celdaDato = rowdatos.createCell(6);
				celdaDato.setCellType(CellType.STRING);
				celdaDato.setCellValue(bitacoraExcel.get(i).getReporteExportado());

				celdaDato = rowdatos.createCell(7);
				celdaDato.setCellType(CellType.STRING);
				celdaDato.setCellValue(bitacoraExcel.get(i).getUsuarioModificador());
			}
		}

		for (int i = 0; i < bitacoraExcel.size(); i++) {
			sheet.autoSizeColumn(i);
		}
		return wb;
	}
	
	/**
	 * Método que setea el estilo del encabezado de las columnas.
	 * @param wb HSSFWorkbook
	 * @return HSSFCellStyle
	 */
	private HSSFCellStyle estiloEncabezadoColumnasCentro(HSSFWorkbook wb){
		HSSFCellStyle estiloEncabezadoColumnasCentro = obtenerEstiloDeCelda(wb, IndexedColors.WHITE.getIndex(), IndexedColors.BLUE.getIndex(),
				HorizontalAlignment.CENTER, VerticalAlignment.CENTER, true, IndexedColors.BLACK.getIndex());
		HSSFFont font = wb.getFontAt(estiloEncabezadoColumnasCentro.getFontIndex());
		font.setBold(true);
		font.setFontHeightInPoints((short) 9);
		return estiloEncabezadoColumnasCentro;
	}
	
	/**
	 * Método que setea el estilo de la celda.
	 * @param wb HSSFWorkbook
	 * @return HSSFCellStyle
	 */
	private HSSFCellStyle estiloDatos(HSSFWorkbook wb){
		HSSFCellStyle estiloDatos = obtenerEstiloDeCelda(wb, IndexedColors.BLACK.getIndex(),
			IndexedColors.WHITE.getIndex(), HorizontalAlignment.LEFT, VerticalAlignment.CENTER, true,
			IndexedColors.BLACK.getIndex());
		HSSFFont font = wb.getFontAt(estiloDatos.getFontIndex());
		font.setFontHeightInPoints((short) 9);
		return estiloDatos;
	}
	
	
}