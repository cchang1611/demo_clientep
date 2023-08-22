/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CorreoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.CorreoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCorreo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;

/**
 * Implementacion del envio de correo electronico
 * 
 * @author DBARBOSA
 */
@Service
public class CorreoServiceImpl implements CorreoService {
	
	/**
	 * Referencia hacia Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CorreoServiceImpl.class);
	
	/**
	 * Referencia al service JavaMailSender
	 */
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * Ruta imagenes
	 */
	@Value("${ruta.archivos.html}")
	private String rutaArchivosHtml;
	
	/**
	 * Ruta imagenes
	 */
	@Value("${ruta.imagenes}")
	private String rutaImagenes;
	
	/**
	 * Ruta imagenes organizacion
	 */
	@Value("${correo.from}")
	private String correoFrom;
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void envioCorreo(DatosCorreo datosCorreo, String afore) {
		final MimeMessage mensaje = mailSender.createMimeMessage();

		try {
			logger.info("Preparando mensaje");
			final MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

			logger.info("Seteando valores principales correo");
			helper.setTo(datosCorreo.getCorreo());
			helper.setSubject(datosCorreo.getDatosCorreo().getAsunto());
			helper.setFrom(correoFrom);
			
			if(datosCorreo.getArchivo()!=null) {
				InputStream is=new ByteArrayInputStream(datosCorreo.getArchivo().toByteArray());
				DataSource attachment=new ByteArrayDataSource(is, "application/octet-stream");
				helper.addAttachment(datosCorreo.getNombre().concat(".pdf"),attachment);
			}
			logger.info("Seteando cuerpo del correo html");
			Map<String, String> mapaImagenes = new HashMap<>();
			helper.setText(this.obtenerCuerpoCorreo(datosCorreo, mapaImagenes, afore), true);

			logger.info("Envio de imagenes");
			this.agregarCID(mapaImagenes, helper);

			this.mailSender.send(mensaje);
			logger.info("Se finaliza el envio del correo");
			
		} catch(GenericException e) {
			logger.error("GenericException :: ", e);
			
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		} catch(Exception e) {
			
			logger.error("Exception no controlada:: ", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}
	
	/**
	 * Metodo encargado de obtener el cuerpo del correo, actualizar las variables
	 * y agregar las imagenes del html
	 * 
	 * @param datos
	 * @param mapaImagenes
	 * @param afore
	 * @return
	 * @throws IOException 
	 */
	private String obtenerCuerpoCorreo(DatosCorreo datos, Map<String, String> mapaImagenes, String afore) throws IOException {
		String contenido = this.obtenerCorreo(datos.getDatosCorreo().getNombreArchivo());
		contenido = this.actualizarVariables(contenido, datos);
		contenido = this.limpiarCadenaHtml(contenido);
		
		mapaImagenes.put(CorreoConstants.IMAGEN_AFORE, utileriaCadena.obtenerCadenaConcatenada(true, afore, CorreoConstants.EXTENSION_JPG));
		mapaImagenes.put(CorreoConstants.IMAGEN_ACCESAR, utileriaCadena.obtenerCadenaConcatenada(true, CorreoConstants.LOGO_ACCESAR, CorreoConstants.EXTENSION_PNG));
		
		return contenido;
	}
	
	/**
	 * Proceso encargo de agregar las imagenes del html
	 * @param mapImagenes
	 * @param mensaje
	 * @throws MessagingException
	 */
	private void agregarCID(Map<String, String> mapImagenes, MimeMessageHelper mensaje) throws MessagingException {
		StringBuilder pathImagenes;
		for (Map.Entry<String, String> keyimg: mapImagenes.entrySet()) {
			pathImagenes = new StringBuilder().append(rutaImagenes);
			mensaje.addInline(keyimg.getKey(), new FileSystemResource(pathImagenes.append(mapImagenes.get(keyimg.getKey())).toString()));		
		}
		
	}
	
	/**
	 * Obtiene el contenido del archivo
	 * 
	 * @param archivo
	 * @return
	 * @throws IOException
	 */
	private String obtenerCorreo(String archivo) throws IOException {
		StringBuilder sBuilder = new StringBuilder();
		String achivo = utileriaCadena.obtenerCadenaConcatenada(true, rutaArchivosHtml, archivo);
		BufferedReader buffer = null;
		try {
			String linea;
			
			logger.info("Realiza la lectura del archivo html");
			Path ruta = Paths.get(achivo); 
			buffer = Files.newBufferedReader(ruta, Charset.forName("UTF-8"));
			
			while((linea = buffer.readLine()) != null) {
				sBuilder.append(linea);
			}
			logger.info("Se finaliza la lectura del archivo correctamente.");
			buffer.close();
			return sBuilder.toString();
		} catch(IOException ioe) {
			logger.error("IOException en la lectura del archivo.", ioe);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		} finally {
			if (buffer != null) {
				buffer.close();
			}
		}
	}	
	
	/**
	 * Metodo encargado en actualizar las variables html con los datos de entrada
	 * 
	 * @param contenido
	 * @param datos
	 * @return
	 */
	private String actualizarVariables(String contenido, DatosCorreo datos) {
		String mensaje = contenido;
		
		mensaje = StringUtils.replace(mensaje, CorreoConstants.FECHA, escapeHtml(datos.getFecha()));
		mensaje = StringUtils.replace(mensaje, CorreoConstants.NOMBRE, escapeHtml(datos.getNombre()));
		mensaje = StringUtils.replace(mensaje, CorreoConstants.FOLIO, escapeHtml(datos.getFolio()));
		mensaje = StringUtils.replace(mensaje, CorreoConstants.USUARIO, escapeHtml(datos.getUsuario()));
		mensaje = StringUtils.replace(mensaje, CorreoConstants.URL_SERVICIO, escapeHtml(datos.getLigaServicio()));
		mensaje = StringUtils.replace(mensaje, CorreoConstants.CLAVE_SEC, escapeHtml(datos.getContrasenia()));
		mensaje = StringUtils.replace(mensaje, CorreoConstants.CODIGO, escapeHtml(datos.getCodigo()));
		mensaje = StringUtils.replace(mensaje, CorreoConstants.CODIGO_SMS, escapeHtml(datos.getCodigoMsn()));
		mensaje = StringUtils.replace(mensaje, CorreoConstants.URL_PLATAFORMA, escapeHtml(datos.getUrlServicio()));
		
		return mensaje;
	}
		
	/**
	 * Metodo encargado de limpiar variables del contenido de correo
	 */
	private String limpiarCadenaHtml(String cadena) {
		String auxiliarCadena = cadena.replace("á", "&aacute;");
		auxiliarCadena = auxiliarCadena.replace("é", "&eacute;");
		auxiliarCadena = auxiliarCadena.replace("í", "&iacute;");
		auxiliarCadena = auxiliarCadena.replace("ó", "&oacute;");
		auxiliarCadena = auxiliarCadena.replace("ú", "&uacute;");
		auxiliarCadena = auxiliarCadena.replace("Á", "&Aacute;");
		auxiliarCadena = auxiliarCadena.replace("É", "&Eacute;");
		auxiliarCadena = auxiliarCadena.replace("Í", "&Iacute;");
		auxiliarCadena = auxiliarCadena.replace("Ó", "&Oacute;");
		auxiliarCadena = auxiliarCadena.replace("Ú", "&Uacute;");
		auxiliarCadena = auxiliarCadena.replace("ñ", "&ntilde;");
		auxiliarCadena = auxiliarCadena.replace("Ñ", "&Ntilde;");
		return auxiliarCadena;
	}
	
	
}