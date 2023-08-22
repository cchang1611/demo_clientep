package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CorreoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaReimpresion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;

/**
 * Reimpresion Tramites Service
 * @author jmordone
 *
 */
public interface ReimpresionTramitesService {
    
	/**
	 * obtenerPdfPorClave
	 * @param listaDeArchivosExtraidosPorZip
	 * @return
	 */
	DatosArchivos obtenerPdfPorClave(List<DatosArchivos> listaDeArchivosExtraidosPorZip,Integer tipoTramite);
	
	/**
	 * guardarBitacoraImpresionEnvio
	 * @param trabajador
	 * @param envioOImpresion
	 * @param folioPulsar
	 */
	void guardarBitacoraImpresionEnvio(String envioOImpresion,String tipoTramite,String idSeguimiento,String claveAgente);
	
	
	/**
	 * obtenerTipoClaveDocumento
	 * @param modulo
	 * @return
	 */
	String obtenerTipoClaveDocumento(Integer modulo);
	
	/**
	 * obtenerTramitesConcluidos
	 * @param tramitesConcluidosEntrada
	 * @return
	 */
	TramitesConcluidos obtenerTramitesConcluidos(TramitesConcluidosEntrada tramitesConcluidosEntrada);
	
	/**
	 * convertirJsonObjeto
	 * @param json
	 * @param typeParamClass
	 * @return
	 */
	<T> T convertirJsonObjeto(String json, Class<T> typeParamClass);
	
	/**
	 * obtenerMensajeSinDatos
	 * @return
	 */
	DatosArchivos obtenerMensajeSinDatos();
	
	
	/**
	 * obtenerMensajeSinRespuestaAfore
	 * @return
	 */
	DatosArchivos obtenerMensajeSinRespuestaAfore();
	
	/**
	 * convertirObjetoToJson
	 * @param typeParamClass
	 * @return
	 */
	 String convertirObjetoToJson(Object typeParamClass);
	 
	/**
	 * Metodo que registra peticion para reimpresion de documentos
	 * @param entradaTramiteConcluido
	 * @return
	 */
	RespuestaReimpresion registraProcesoConcluidoReinpresion(TramitesConcluidos entradaTramiteConcluido);
	
	/**
	 * obtenerFolioProcesarPorCurp
	 * @param curp
	 * @param claveAfore
	 * @return
	 */
	String obtenerFolioProcesarPorCurp(String curp, String claveAfore);
	
	/**
	 * enviarCorreoReimpresion
	 * @return
	 */
	RespuestaServicio enviarCorreoReimpresion(DatosArchivos datos,DatosTrabajador trabajador,String folioProcesar,String modulo,CorreoEnum correoEnum,String claveAgente);
	
	/**
	 * obtieneExistenciaCorreoElectronico
	 * @param trabajador
	 * @return
	 */
	 RespuestaServicio obtenerExistenciaCorreoElectronico(DatosTrabajador trabajador);
	
	/**
	 * envioNotificacionTramites
	 * @param tramitesConcluidosEntrada
	 * @return
	 */
	RespuestaServicioNotificacion envioNotificacionTramites(TramitesConcluidosEntrada tramitesConcluidosEntrada);
	
	/**
	 * obtenerTramitesConcluidos
	 * @param curp
	 * @param folioProcesar
	 * @param organizacion
	 * @param subTipoSolicitante
	 * @param tipoSolicitante
	 * @return
	 */
	TramitesConcluidos llenarTramitesConcluidos(String curp,String folioProcesar,String organizacion,
			String tipoSolicitante);
	
}
