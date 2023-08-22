package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.File;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerValorMapaService;
/**
 * Servicio para eliminar archivos y directorios
 * @author ANOSORIO
 *
 */
@Service
public class ObtenerValorMapaServiceImpl implements ObtenerValorMapaService{
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ObtenerValorMapaServiceImpl.class);
	
	
	  /**
  	 * Ruta url de carpeta de expediente
  	 */
  	@Value("${ruta.carpeta.expediente}")
  	private String urlRutaExpedientes;
		
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerValorMapaService#recorrerListadoMapa(java.util.Map)
	 */
	@Override
	public void recorrerListadoMapa(Map<String, String> arregloArchivos) {
		String nombreArchivoPdf;
		for(Map.Entry<String,String> valoresMapa : arregloArchivos.entrySet()) {
			nombreArchivoPdf = valoresMapa.getValue();
			String ficheroPdf = new StringBuilder().append(urlRutaExpedientes).append(nombreArchivoPdf).toString();	 
			eliminarArchivoPdf(ficheroPdf);
				
		 }
		
	}

	
	/**
	 * Metodo para borrar archivos pdf con respecto a la ruta origen
	 * @param nombreArchivo
	 * @return
	 */
	protected void eliminarArchivoPdf(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		try {
		 if(archivo.delete()){  
			  logger.info("Se elimino archivo pdf's:{}",nombreArchivo);
		   }
		}catch (NullPointerException e) {
			logger.error("Ocurrio un error al Eliminar archivos:{}",e);
		}	
		archivo.delete();
		archivo.deleteOnExit();
		logger.info("Salida:Se eliminaron archivo pdf's ");	
	}
	
	/**
	 * Metodo encargado de elimnar un directorio
	 * @param borrar
	 */
	@Override
	public void borrarDirectorio(File borrar) {
		if (borrar.isDirectory()) {
			try{
				for (File listFile : borrar.listFiles()) {
					borrarisDirectorio(listFile);
				}
			} catch(NullPointerException e) {
				logger.error("Se presento un error al eliminar el directorio", e); 
			}
		} 
		borrar.delete();
		logger.info("Salida :Se elimino el directorio");
	}

    /**
     * Metodo que valida Si existe directorio para borrar
     * @param listFile
     */
	protected void borrarisDirectorio(File listFile) {
		if (listFile.isFile()) {
			listFile.delete();
		} else { 
			if (listFile.isDirectory()) {
				borrarDirectorio(listFile);
				listFile.delete();
				}	
		}
		
	}
	
	
}
