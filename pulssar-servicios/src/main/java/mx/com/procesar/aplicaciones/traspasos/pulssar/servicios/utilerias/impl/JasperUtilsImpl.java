package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosJasper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.JasperUtils;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * IMPLEMENTACION INTERFAZ CREACION
 * DEL ARCHIVO PDF
 * 
 * @author dbarbosa
 * 
 */
@Component
public class JasperUtilsImpl implements JasperUtils {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(JasperUtilsImpl.class);
	
	/**
	 * Ruta de imagenes
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Ruta de los documentos
	 */
	@Value("${ruta.archivos.docs}")
	private String rutaDocs;
	
	/**
	 * Ruta de imagenes
	 */
	@Value("${ruta.imagenes}")
	private String rutaImagenes;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte[] generarArchivoJasper(DatosJasper datos, String afore) {
		byte[] pdf 						= null;
		Map<String, Object> mapObjects 	= null;
		InputStream reporte 			= null;
		String docJasper = StringUtils.replace(datos.getDocJasper(), "{afore}", afore);
		String path 		= utileriaCadena.obtenerCadenaConcatenada(true, rutaDocs, docJasper);
		
		try {
			mapObjects 	= obtenerParametros(datos.getMapImagenes());
			reporte 	= JRLoader.getFileInputStream(path);
			
			if(mapObjects == null) {
				mapObjects = new HashMap<>();
			}
			
			if(datos.getMapObjects() != null && datos.getMapObjects().size() > 0) {
				mapObjects.putAll(datos.getMapObjects());
			}
			
			if(datos.getoPdf() != null) {
				pdf = JasperRunManager.runReportToPdf(reporte, mapObjects, new JRBeanCollectionDataSource(Arrays.asList(datos.getoPdf())));
			} else {
				pdf = JasperRunManager.runReportToPdf(reporte, mapObjects, new JREmptyDataSource());
			}
		} catch (JRException e) {
			logger.error("Exception al generar pdf", e);
		}
		
		return pdf;
	}

	/**
	 * Obtiene los parametros para la insercion de los valores en el jasper
	 * 
	 * @param imagenes
	 * @param path
	 * @return
	 * @throws JRException
	 */
	private Map<String, Object> obtenerParametros(Map<String, String> imagenes) throws JRException {
		Map<String, Object> mapObjects 	= null;
		InputStream imgInputStream 		= null;
		String pathObject 				= null;
		
		if(imagenes != null && imagenes.size() > 0) {
			mapObjects = new HashMap<String, Object>();
			Iterator<Map.Entry<String, String>> it = imagenes.entrySet().iterator();
			while(it.hasNext()) {
				Map.Entry<String, String> pair  = it.next();
				pathObject = utileriaCadena.obtenerCadenaConcatenada(true, rutaImagenes, pair.getValue());
				imgInputStream = JRLoader.getFileInputStream(pathObject);
				mapObjects.put(pair.getKey(), imgInputStream);
			}
		}
		return mapObjects;
	}
}
