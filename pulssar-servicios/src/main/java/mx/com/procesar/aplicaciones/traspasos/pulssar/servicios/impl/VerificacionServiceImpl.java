/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.VerificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Expediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellasDactilares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PeticionTomaHuellaCoppel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.XmlUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ZipUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * Servicio de Verificacion de huellas 
 * @author dhernand
 *
 */
@Service
public class VerificacionServiceImpl implements VerificacionService {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(VerificacionServiceImpl.class);
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private FolioService servicioFolio;
	
	/**
	 * Inyeccion de servicio recepcion de archivos
	 */
	@Autowired
	private RecepcionArchivosService servicioArchivos;
	
	/**
	 * Utileria de xml
	 */
	@Autowired
	private XmlUtils xmlUtils;

	/**
	 * Utileria del zip
	 */
	@Autowired
	private ZipUtils zipUtils;
	
	/**
	 * Metod para la generacion la peticion de una huella
	 */
	@Override
	public PeticionTomaHuellaCoppel generarPeticionUnaHuella(UsuarioLogin user,Folio folio) {
		PeticionTomaHuellaCoppel peticion = new PeticionTomaHuellaCoppel();		
		peticion.setCurp(user.getCurpAgente());
		peticion.setNss("12345678910");
		peticion.setFolioProcesar(folio.getChFolio());
		peticion.setTipoPersona(PeticionTomaHuellaCoppel.EMPLEADO);
		peticion.setTipoToma(PeticionTomaHuellaCoppel.UN_DEDO);
		return peticion;
	}
	
	/**
	 * Genera el folio Hijo
	 * @param user
	 * @return
	 */
	@Override
	public Folio obtenerFolioHijo(UsuarioLogin user) {
		return obtenerFolioHijo(user.getCurpAgente(),user.getDatoUsuario());
	}

	
	/**
	 * Genera el folio hijo
	 * @param curp
	 * @param idUsuario
	 * @return
	 */
	private Folio obtenerFolioHijo(String curp,Long idUsuario) {		
		FolioEntrada folioEntrada = servicioFolio.llenarObjetoFolioEntrada(curp, null, 
				ServiciosConstants.DESCRIPCION_SERVICIO_VERIFICACION_HUELLA, ServiciosConstants.FOLIO_OPERACION_SERVICIO, ServiciosConstants.HORA_LLEGADA_CERO);
		return  servicioFolio.obtenerFolio(folioEntrada, idUsuario, ServiciosConstants.SUCURSAL_FOLIO_DEFAULT, 
				ServiciosConstants.FOLIO_SERVICIO_VERIFICACION_1_HUELLA, ServiciosConstants.FOLIO_PROCESO_VERIFICACION_1_HUELLA);		
	}
	
	/**
	 * Verificar la interface 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.VerificacionService#validaEmpleadoVistaJson(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Expediente)
	 */
	@Override
	public RespuestaServicio validaEmpleadoVistaJson(Folio folioHijo, UsuarioLogin user, Expediente expediente) throws Exception {
		logger.info("Metodo encargado de realizar la peticion para la validacion de las huellas del empleado");
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(NumerosConstants.INT_UNO);
		String cadenaDecodificada = URLDecoder.decode(expediente.getBiometricos(), RegistroUsuarioConstants.UTF_8);
		JsonUtilsImpl<HuellasDactilares> jsonUtils = new JsonUtilsImpl<>();
		HuellasDactilares parseJsonToObject = jsonUtils.parseJsonToObject(cadenaDecodificada, HuellasDactilares.class);
		String xml = xmlUtils.convertirObjetoXml(parseJsonToObject/*, HuellasDactilares.class*/);
		byte[] bytes = zipUtils.generaZipEntry(xml, user.getCurpAgente().concat(".xml"));
		String cadenaDecodificada64 = Base64Utils.encodeToString(bytes);		
		Archivos objetoArchivo = generarPeticionRecepcionArchivo(folioHijo,user);

		respuesta = servicioArchivos.enviarArchivoRecepcion(folioHijo, objetoArchivo, cadenaDecodificada64,	ServiciosConstants.RUTA_HUELLA);
		return respuesta;
	}
	
	
	/**
	 * Genera la peticion para la recepcion de archivos
	 * @param folioHijo
	 * @param user
	 * @return
	 */
	private Archivos generarPeticionRecepcionArchivo(Folio folioHijo,UsuarioLogin user) {
		Archivos objetoArchivo = new Archivos();
		objetoArchivo.setClaveAfore(user.getAforeUsuario());
		objetoArchivo.setFolioTramiteProcesar(folioHijo.getChFolio());
		objetoArchivo.setFolioCliente(folioHijo.getChFolio().substring(NumerosConstants.INT_UNO));
		objetoArchivo.setCurpEmpleado(user.getCurpAgente());
		objetoArchivo.setTipoArchivos(ServiciosConstants.CLAVE_VERIFICACION_HUELLAS_1);
		return objetoArchivo;
	}
	
	
}
