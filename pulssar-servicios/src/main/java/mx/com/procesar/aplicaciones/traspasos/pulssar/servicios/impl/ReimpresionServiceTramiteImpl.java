package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionServiceFabrica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;

/**
 * ReimpresionServiceTramiteImpl
 * @author jmordone
 *
 */
@Component
public class ReimpresionServiceTramiteImpl{
	

	/**
	 * reimpresionServiceFabrica
	 */
	@Autowired
	private ReimpresionServiceFabrica reimpresionServiceFabrica;
	
	/**
	 * reimpresionTramitesService
	 */
	@Autowired
	private ReimpresionTramitesService reimpresionTramitesService;
	
	
	/**
	 * Obtiene lista de rutas de archivos mediante el folio procesar
	 * Nota: Se modifica la extraccion del servicio mediante DeserializationFeature y evitar un array list exception 
	 * cuando existe 
	 * un solo elemento de la lista de entrada
	 * @param folioProcesar
	 * @return
	 */
	public DatosArchivos obtenerArchivos(DatosTrabajador trabajador,Integer tramite){
		DatosArchivos listaArchivos=null;
		try {
		  ReimpresionService reimpresionService=reimpresionServiceFabrica.obtenerServicioReimpresion(tramite);
		  listaArchivos=reimpresionService.obtenerArchivosReimpresion(trabajador);
		} catch (Exception e) {		
			throw new BusinessException("Existe un problema con la extracción o la lectura del archivo",e);
		}
		return listaArchivos;
	}
	
	/**
	 * enviarCorreoReimpresion
	 */
	public RespuestaServicio enviarCorreoReimpresion(DatosArchivos datos,DatosTrabajador trabajador,Integer tramite, String folioProcesar,Integer modulo,String claveAgente)  {
		RespuestaServicio respuestaServicio =new RespuestaServicio();
		if(datos!=null && !datos.getByteArchivo().isEmpty()) {
		   ReimpresionService reimpresionService=reimpresionServiceFabrica.obtenerServicioReimpresion(tramite);		
		   respuestaServicio = reimpresionService.enviarCorreoReimpresion(datos,trabajador,folioProcesar,modulo,claveAgente);
		}
		return respuestaServicio;
	}

	/**
	 * obtieneExistenciaCorreoElectronico
	 * @param trabajador
	 * @return
	 */
	public RespuestaServicio obtenerExistenciaCorreoElectronico(DatosTrabajador trabajador,Integer tramite) {	
		ReimpresionService reimpresionService=reimpresionServiceFabrica.obtenerServicioReimpresion(tramite);
		return reimpresionService.obtenerExistenciaCorreoElectronico(trabajador);
	}
    
	/**
	 * guardarBitacoraImpresion
	 */
	public void guardarBitacoraImpresion(DatosArchivos datos,Integer modulo,String claveAgente) {
		reimpresionTramitesService.guardarBitacoraImpresionEnvio(FormatoConstants.INDICATIVO_IMPRESION,
				reimpresionTramitesService.obtenerTipoClaveDocumento(modulo),datos.getIdSegTramite(),claveAgente);
	}
}
