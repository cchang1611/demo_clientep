/**
 * GeneracionZipServiceImpl.java
 * Fecha de creación: Oct 4, 2021, 10:02:33 PM
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneracionZipService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenDocumento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenWrapper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CompresorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * TODO [Agregar documentacion de la clase]
 * 
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Oct 4, 2021
 */
@Service
public class GeneracionZipServiceImpl implements GeneracionZipService {
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(GeneracionZipServiceImpl.class);

	/**
	 * Inyeccion de utileria compresor
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private FechaUtils utileriaFecha;

	/**
	 * Inyeccion de utileria compresor
	 */
	@Autowired
	private CompresorUtils utileriaCompresor;

	/**
	 * Ruta url de carpeta de expediente
	 */
	@Value("${ruta.carpeta.expediente}")
	private String urlRutaExpedientes;
	
	/**
	 * Catalogo de servicio
	 */
	@Autowired
	private CatalogoService servicioCatalogo;

	/**
	 * Usuario
	 */
	@Value("#{propiedades['ruta.archivos.recepcion.genera.zip']}")
	private String rutaRecepcion;

	@Override
	public String validarArchivosRecibidos(ImagenWrapper objetoImagen, EnvioArchivos datosRecepcion)
			throws IOException {
		FileOutputStream salida = null;
		String ruta = this.verificarRuta(datosRecepcion.getCurpTrabajador(), urlRutaExpedientes);
		String fecha = utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_ARCHIVOS);
		if (!utileriaValidador.validarObjetoNulo(objetoImagen)
				&& !utileriaValidador.validarListaVacia(objetoImagen.getImagenes())) {
			int indice = 1;
			List<String> docs = new ArrayList<>();
			logger.info("lista de imagenes a guardar : {}"+objetoImagen.getImagenes());
			for (ImagenDocumento archivo : objetoImagen.getImagenes()) {
				String extension = archivo.getNombreDocumento()
						.substring(archivo.getNombreDocumento().indexOf(AgenteConstants.PUNTO));

				if (archivo.getClaveTipoDocumento().equals(ServiciosConstants.CLAVE_08)
						|| archivo.getClaveTipoDocumento().equals(ServiciosConstants.CLAVE_81)) {
					if (archivo.getTipoImagenDocumento().equals(NumerosConstants.C_CERO)
							|| utileriaValidador.validarVacio((archivo.getTipoImagenDocumento()))) {
						indice = 1;
					} else {
						indice = Integer.valueOf(archivo.getTipoImagenDocumento());
					}
				} else if (!docs.contains(archivo.getClaveTipoDocumento())) {
					indice = 1;
				}

				StringBuilder renombre = new StringBuilder(datosRecepcion.getClaveAfore())
						.append(datosRecepcion.getProceso()).append(datosRecepcion.getCurpTrabajador())
						.append(datosRecepcion.getTipoTrabajador()).append(archivo.getClaveTipoDocumento())
						.append(String.valueOf(indice)).append(fecha).append(datosRecepcion.getFolioIdentificacion())
						.append(extension.toLowerCase());
				StringBuilder rutaSalidaSb = new StringBuilder(ruta).append(ActivacionConstants.DIAGONAL)
						.append(renombre);
				File rutaSalida = new File(rutaSalidaSb.toString());
				salida = new FileOutputStream(rutaSalida);
				salida.write(DatatypeConverter.parseBase64Binary(archivo.getContenidoDocumento()));
				salida.close();
				docs.add(archivo.getClaveTipoDocumento());
				indice++;
			}
		}

		File carpeta = new File(ruta);
		String parent = carpeta.getPath();
		String nuevoParent = parent.replace("\\\\", "\\\\\\\\");
		StringBuilder destino = new StringBuilder(nuevoParent).append(ExpresionesConstants.EXTENSION_ZIP);
		byte[] resultadoZip = utileriaCompresor.comprimirCarpeta(nuevoParent, destino.toString());
		this.eliminarDirectorio(new File(ruta));

		String valor = servicioCatalogo.consultaValorParametro(ActivacionConstants.PARAMETRO_RUTA_ARCHIVOS_EXPEDIENTE, ActivacionConstants.PARAMETRO_CLAVE_RUTA_ARCHIVOS_EXPEDIENTE);
		valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_AFORE, datosRecepcion.getClaveAfore());
		valor = StringUtils.replace(valor, ActivacionConstants.DATO_RUTA_EXPEDIENTE_PROCESO, datosRecepcion.getProceso());

		StringBuilder rutaDestino = new StringBuilder(valor).append(datosRecepcion.getClaveAfore())
				.append(datosRecepcion.getFolio()).append(datosRecepcion.getCurpEmpleado())
				.append(datosRecepcion.getCurpTrabajador()).append(datosRecepcion.getTipoArchivo())
				.append(datosRecepcion.getProceso())
				.append(fecha).append(ExpresionesConstants.EXTENSION_ZIP);
		logger.info("Ruta del zip :: {}", rutaDestino);
		File fArchivo = new File(rutaDestino.toString());
		FileOutputStream salidaArchivo = new FileOutputStream(fArchivo);
		byte[] decoder = Base64Utils.decodeFromString(Base64Utils.encodeToString(resultadoZip));
		salidaArchivo.write(decoder);
		logger.info("Archivo almacenado {}", rutaDestino);
		salidaArchivo.close();
		return rutaDestino.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	private String verificarRuta(String curp, String urlRutaExpe) {
		File ruta = null;
		StringBuilder sb = new StringBuilder(urlRutaExpe).append(ActivacionConstants.DIAGONAL).append(curp);
		ruta = new File(sb.toString());
		 logger.info("Ruta Expe :: {}", ruta);
		this.eliminarDirectorio(ruta);
		this.eliminarDirectorio(new File(sb.append(".zip").toString()));
		ruta.mkdir();
		return ruta.toString();
	}

	public void eliminarDirectorio(File borrar) {
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
