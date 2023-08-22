/**
 * PlataformaOperativaExcelUtilTestCase.java
 * Fecha de creación: 19/05/2021, 16:14:23
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteBitacora;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.PlataformaOperativaExcelUtil;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl.PlataformaOperativaExcelUtilImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaExcel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;

/**
 * Clase que contiene las pruebas unitarias del servicio de generacion de reportes en excel
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Mayo 2021
 */
public class PlataformaOperativaExcelUtilTestCase {

    /**
     * Referencia a MinervaExcelUtilImpl.
     */
    @InjectMocks
    private PlataformaOperativaExcelUtil plataformaOperativaExcelUtil = new PlataformaOperativaExcelUtilImpl();

    /**
     * Utileria para el manejo de fechas
     */
    @Mock
    private FechaUtils fechaUtils;

    /**
     * Metodo de inicializacion de clases
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Prueba Set Color
     */
    @Test
    public void testSetColor() {
        plataformaOperativaExcelUtil.colocarColor(new HSSFWorkbook(), 1, 44, 44, 44);
        assertTrue(true);
    }

    /**
     * Prueba Get Cell Style
     */
    @Test
    public void testGetCellStyleHSSFWorkbookIntIntHorizontalAlignmentVerticalAlignmentBooleanInt() {
        plataformaOperativaExcelUtil.obtenerEstiloDeCelda(new HSSFWorkbook(), 1, 2, HorizontalAlignment.CENTER,
            VerticalAlignment.CENTER, true, 10);
        assertTrue(true);
    }

    /**
     * Prueba Get Cell Style Positivos
     */
    @Test
    public void testGetCellStylePositivos() {
        plataformaOperativaExcelUtil.obtenerEstiloDeCeldaDos(new HSSFWorkbook(), 1, 2, 1, false);
        assertTrue(true);
    }

    /**
     * Prueba Get Cell Style Negativo
     */
    @Test
    public void testGetCellStyleNegativo() {
        plataformaOperativaExcelUtil.obtenerEstiloDeCeldaDos(new HSSFWorkbook(), -1, -2, -10, false);
        assertTrue(true);
    }

    /**
     * Prueba Set Column Size
     */
    @Test
    public void testSetColumnsSize() {
        try {
            HSSFWorkbook book = new HSSFWorkbook();
            HSSFSheet hoja = book.createSheet("prueba");
            int[] i = { 1, 2, 3, 4 };
            plataformaOperativaExcelUtil.colocarTamanioColumna(hoja, i);
            book.close();
        } catch(IOException e) {
            fail("Prueba Incorrecta");
        }
        assertTrue(true);
    }

    /**
     * Prueba Exporta Excel
     */
    @Test
    public void testExportaExcel() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> mapa = new HashMap<>();
        mapa.put("Col1", "null");
        mapa.put("Col2", "Val2");
        mapa.put("Col3", "Val3");
        List<Map<String, String>> consulta = new ArrayList<>();
        consulta.add(mapa);
        String[] nombreColumnas = { "Col1", "Col2", "Col3" };
        RespuestaExcel respuestaExcel = new RespuestaExcel();
        try {
            respuestaExcel.setNombreReporte("ReporteDummy");
            respuestaExcel.setConsulta(mapper.writeValueAsString(consulta));
            respuestaExcel.setNombreColumnas(nombreColumnas);
            Assert.assertNotNull(plataformaOperativaExcelUtil.exportaExcel(respuestaExcel));
        } catch(Exception e) {
            fail("Error en prueba testExportaExcel");
        }

    }

    /**
     * Prueba Exporta Bitacora Excel
     */
    @Test
    public void testExportaBitacoraExcel() {
        ReporteBitacora reporte = new ReporteBitacora();
        reporte.setFcControl(new Date());
        reporte.setFechaEjecucion(new Date());
        reporte.setIdBitacoraReporte(1L);
        reporte.setIdReporteGenerico(2L);
        reporte.setIpOrigen("192.168.9.41");
        reporte.setNombreReporte("Prueba reporte");
        reporte.setParametros("nss||curp");
        reporte.setReporteExportado("1");
        reporte.setUsuario("oegonzal");
        reporte.setUsuarioModificador("minerva");
        List<ReporteBitacora> bitacoraExcel = new ArrayList<>();
        bitacoraExcel.add(reporte);
        Assert.assertNotNull(plataformaOperativaExcelUtil.exportaBitacoraExcel(bitacoraExcel));
    }

    /**
     * Prueba Exporta Bitacora Excel fecha nula
     */
    @Test
    public void testExportaBitacoraExcelFechaNula() {
        ReporteBitacora reporte = new ReporteBitacora();
        reporte.setFcControl(new Date());
        reporte.setIdBitacoraReporte(1L);
        reporte.setIdReporteGenerico(2L);
        reporte.setIpOrigen("192.168.9.41");
        reporte.setNombreReporte("Prueba reporte");
        reporte.setParametros("nss||curp");
        reporte.setReporteExportado("1");
        reporte.setUsuario("oegonzal");
        reporte.setUsuarioModificador("minerva");
        List<ReporteBitacora> bitacoraExcel = new ArrayList<>();
        bitacoraExcel.add(reporte);
        Assert.assertNotNull(plataformaOperativaExcelUtil.exportaBitacoraExcel(bitacoraExcel));
    }

}
