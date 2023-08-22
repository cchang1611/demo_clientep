package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.HuellasService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaHuella;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellaDactilar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.HuellasDactilares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

/**
 * 
 * Servicio rest para validar usuario , obtener roles, obtener menus Pagina

 * @author Edgar Gerardo Ramirez Morales (gramirez@procesar.com)
 * @version 1.0
 * @since Jan 28, 2020
 */
@Controller
public class GuardarHuellasIEController {

	/**
	 * Log
	 */
	private static final Logger logger = LoggerFactory.getLogger(GuardarHuellasIEController.class);

	/**
	 * Inyeccion servicio Administracion
	 */
	@Autowired
	private HuellasService huellaService;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * Usuario
	 */
	@Value("#{propiedades['ruta.archivos.recepcion']}")
	private String rutaRecepcion;
	
	/**
	 * Utils
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * 
	 * Metodo encargado de guardar las huellas de IE
	 * 
	 * @author Edgar Gerardo Ramirez Morales (gramirez@procesar.com)
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/private/guardarHuellaIE.do", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public RespuestaServicio guardarHuellasIE(@RequestBody String salida) {
		logger.info("Se almacenan las huellas de IE {}", salida);
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(NumerosConstants.INT_UNO);
		huellaService.guardarHuellaIE(salida);
		return respuesta;
	}
	
	/**
	 * Vista para la obtencio de la firma en el acuse
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/obtenerIERespuesta.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio validarRespuestaIE(HttpServletRequest request, @RequestParam("peticion") String peticion) {
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		try {
			logger.info("valor de peticion {}", peticion);
			String conversionPeticion = StringUtils.replace(peticion, "'", "\"");
			JsonUtilsImpl<EntradaHuella> utileriaJson = new JsonUtilsImpl<>();
			EntradaHuella datoJson = utileriaJson.parseJsonToObject(conversionPeticion, EntradaHuella.class);
			StringBuilder folioCurp = new StringBuilder();
			folioCurp.append(datoJson.getFolio());
			folioCurp.append((datoJson.getCurp() == null || datoJson.getCurp().isEmpty()) ? datoJson.getCurpEmpleado() : datoJson.getCurp());
			String valor = huellaService.validarRespuestaHuellas(folioCurp.toString());
			if(valor.contains("SHuellas")) {
				respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.NO_CAPTURARON_HUELLAS.getClave(), user.getAforeUsuario(), NumerosConstants.INT_CUATRO, null);
			} else if(!valor.equals("")) {
				respuesta.setMensaje(valor);
				respuesta.setFlujo(NumerosConstants.INT_UNO);
			} else {
				respuesta.setFlujo(NumerosConstants.INT_CINCO);
			}
		} catch (Exception e) {
			logger.error("Error en la obtencion de IE huellas", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * Vista para la obtencio de la firma en el acuse
	 * @author DBARBOSA
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/private/obtenerHuellasTrabajador.do" }, method = {RequestMethod.GET }, produces = { "application/json" })
	@ResponseBody
	public RespuestaServicio obtenerHuellasTrabajador(HttpServletRequest request, @RequestParam("peticion") String peticion) {
		RespuestaServicio respuesta = new RespuestaServicio();
		UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
		try {
			logger.info("valor de peticion {}", peticion);
			String conversionPeticion = StringUtils.replace(peticion, "'", "\"");
			JsonUtilsImpl<EntradaHuella> utileriaJson = new JsonUtilsImpl<>();
			EntradaHuella datoJson = utileriaJson.parseJsonToObject(conversionPeticion, EntradaHuella.class);
			StringBuilder folioCurp = new StringBuilder();
			folioCurp.append(datoJson.getFolio());
			folioCurp.append((datoJson.getCurp() == null || datoJson.getCurp().isEmpty()) ? datoJson.getCurpEmpleado() : datoJson.getCurp());
			String valor = huellaService.validarRespuestaHuellas(folioCurp.toString());
			if(valor.contains("SHuellas")) {
				respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.NO_CAPTURARON_HUELLAS.getClave(), user.getAforeUsuario(), NumerosConstants.INT_CUATRO, null);
			} else if(!valor.equals("")) {
				List<HuellaDactilar> huellas = obtenerArreglohuellas(valor, folioCurp.toString());
				request.getSession().setAttribute(ParametrosConstants.HUELLA_VERIFICACION_INE, huellas.get(NumerosConstants.INT_CERO));
				respuesta.setFlujo(NumerosConstants.INT_UNO);
			} else {
				respuesta.setFlujo(NumerosConstants.INT_CINCO);
			}
		} catch (Exception e) {
			logger.error("Error en la obtencion de IE huellas", e);
			respuesta = servicioCatalogo.obtenerRespuesta(null, BusinessErrorEnum.EXCEPTION_GENERICA.getClave(), user.getAforeUsuario(), NumerosConstants.INT_DOS, null);
		}
		return respuesta;
	}
	
	/**
	 * Metodo encargado de obtener la cadena de las huellas
	 * 
	 * @param cadena
	 * @param folioCurp
	 * @return
	 * @throws IOException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 * @throws JAXBException 
	 */
	private List<HuellaDactilar> obtenerArreglohuellas(String cadena, String folioCurp) throws IOException, JAXBException  {
		String rutaSalida = utileriaCadena.obtenerCadenaConcatenada(true, rutaRecepcion);
		String ruta = cadena;
		String name = "";
		ZipFile zipFile = new ZipFile(ruta);
		System.out.println (zipFile.getName () + "Número de archivos compartidos" + zipFile.size ());
		ZipEntry zipentry = null;
		Enumeration<?> e = zipFile.entries ();
		while (e.hasMoreElements ()) {
			zipentry  = (ZipEntry) e.nextElement();
			if (zipentry.isDirectory ()) {
				File file = new File(rutaSalida + zipentry.getName());
				file.mkdir (); // Crear carpeta				
			} else {
				InputStream input = zipFile.getInputStream (zipentry); // Obtener la secuencia del archivo actual
				File f = new File (utileriaCadena.obtenerCadenaConcatenada(true, rutaSalida, zipentry.getName())); // Crea el archivo actual
				if(zipentry.getName().contains(".xml")) {
					name = utileriaCadena.obtenerCadenaConcatenada(true, rutaSalida,zipentry.getName());
				}
				FileOutputStream fout = new FileOutputStream (f); // Declarar una secuencia de salida
				int bytes;
				while((bytes = input.read()) !=-1 ) {
					fout.write(bytes); // Genera un nuevo archivo a partir de la salida del flujo de lectura
				}
				input.close();
				fout.close();
				System.err.println (zipentry.getName () + "Descompresión exitosa ...");
			}
		}
		zipFile.close();
		JAXBContext jaxbContext = JAXBContext.newInstance(HuellasDactilares.class);
		Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
		HuellasDactilares huellas = (HuellasDactilares) jaxbUnMarshaller.unmarshal(new File(name));
		
		this.eliminarDirectorio(new File(ruta));
		this.eliminarDirectorio(new File(name));
		return huellas.getHuellaDactilar();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param borrar
	 */
	private void eliminarDirectorio(File borrar) {
		if (borrar.isDirectory()) {
			try {
				for (File listFile : borrar.listFiles()) {
					if (listFile.isFile()) {
						listFile.delete();
						listFile.deleteOnExit();
					} else {
						if (listFile.isDirectory()) {
							eliminarDirectorio(listFile);
							listFile.delete();
							listFile.deleteOnExit();
						}
					}
				}
			} catch (NullPointerException e) {
				logger.error("Se presento un error al eliminar el directorio", e);
			}
		}
		borrar.delete();
		borrar.deleteOnExit();
	}
}