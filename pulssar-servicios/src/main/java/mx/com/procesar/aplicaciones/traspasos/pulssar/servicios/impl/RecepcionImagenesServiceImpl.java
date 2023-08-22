package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionImagenesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DetalleRecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenDocumento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.LectorArchivoUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion de servicio de recepcion de imagenes
 * 
 * @author JMGUTIEG
 *
 */
@Service("recepcionImagenesService")
public class RecepcionImagenesServiceImpl implements RecepcionImagenesService {

	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RecepcionImagenesServiceImpl.class);

	/**
	 * Inyeccion de rest
	 */
	@Autowired
	private RestTemplate servicioCliente;

	/**
	 * url comunes
	 */
	@Value("${uri.comunes}")
	private String urlComunes;

	/**
	 * Inyeccion servicio de catalogos
	 */
	@Autowired
	private CatalogoService catalogoService;

	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private CadenasUtils utileriaCadena;

	/**
	 * dependencia utilidad validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/**
	 * Inyeccion de utileria LectorArchivoUtils
	 */
	@Autowired
	private LectorArchivoUtils lectorArchivoUtils;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RecepcionImagenes consultarRecepcionImagenes(String folioPadre, String cvProceso, String estatus) {
		logger.info("parametro entrada consultarRecepcionImagenes: {} {} {}", folioPadre, cvProceso, estatus);

		String url = utileriaCadena.obtenerCadenaConcatenada(true, urlComunes,
				ServiciosConstants.SERVICIO_CONSULTA_RECEPCION_IMAGENES, folioPadre, ExpresionesConstants.DIAGONAL,
				cvProceso, ExpresionesConstants.DIAGONAL, estatus);
		logger.info("url consultarRecepcionImagenes: {}", url);
		RecepcionImagenes respuesta = servicioCliente.getForObject(url, RecepcionImagenes.class);
		logger.info("respuesta consultarRecepcionImagenes: {}", respuesta);

		return respuesta;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * RecepcionImagenesService#obtenerDocumentos(mx.com.procesar.aplicaciones.
	 * traspasos.pulssar.servicios.modelo.RecepcionImagenes, java.lang.String)
	 */
	@Override
	public List<ImagenDocumento> obtenerDocumentos(RecepcionImagenes imagenRecibida, String cveAfore) {
		logger.info("url consultarRecepcionImagenes: {}", imagenRecibida);

		ArrayList<ImagenDocumento> documentosRecibidos = new ArrayList<>();
		try {
			List<Parametro> archivosExcluidos = catalogoService.obtenerParametroDdbpose(ServiciosConstants.T00035,utileriaCadena.obtenerCadenaConcatenada(true, cveAfore, ServiciosConstants.COMA,imagenRecibida.getClaveTipoProceso()));
			
			for (DetalleRecepcionImagenes detalleImagen : imagenRecibida.getDetalleRecepcionImagen()) {
				
				Parametro documentoExcluido = new Parametro();
				
				documentoExcluido.setChValorParametro(detalleImagen.getTipoDocumentoDigital());
				
				if (!archivosExcluidos.contains(documentoExcluido)) {
					ImagenDocumento imagenDocumento = new ImagenDocumento();
					
					String contenidoArchivo = lectorArchivoUtils.obtenerContenidoArchivo(utileriaCadena.obtenerCadenaConcatenada(true, detalleImagen.getRuta(), detalleImagen.getMascara()));
					
					if (!utileriaValidador.validarVacio(contenidoArchivo)) {
						
						imagenDocumento.setClaveTipoDocumento(detalleImagen.getTipoDocumentoDigital());
						imagenDocumento.setTipoImagenDocumento(Integer.toString(detalleImagen.getTipoImagen()));
						imagenDocumento.setNombreDocumento(renombrarArchivo(detalleImagen.getMascara(), detalleImagen.getTipoArchivo()));
						imagenDocumento.setContenidoDocumento(contenidoArchivo);

						documentosRecibidos.add(imagenDocumento);
					}
				}
			}
//		} catch (IOException e) {
//			logger.error("IOException", e);
//			throw new BusinessException(BusinessErrorEnum.EXCEPTION_GENERICA);
		} catch (Exception e) {
			logger.error("Se presento un problema en el servicio de Recuperacion de Imagenes ", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return documentosRecibidos;
	}
	
	/**
	 * Metodo para renombrar la mascara del archivo para recepcion de imagenes
	 * @param mascaraArchvo
	 * @param extension
	 * @return
	 */
	private String renombrarArchivo(String mascaraArchivo, String extension) {
		logger.info("renombre mascara {} {}", mascaraArchivo, extension);
		String[] datosMascara = mascaraArchivo.split(ServiciosConstants.PUNTO_ESCAPE);
		String renombreArchivo = utileriaCadena.obtenerCadenaConcatenada(true,datosMascara[NumerosConstants.INT_CERO], ServiciosConstants.PUNTO, extension);
		logger.info("archivo renombrado {}", renombreArchivo);
		
		return renombreArchivo;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ImagenDocumento> filtrarDocumentos(List<ImagenDocumento> imagenRecibida, String cveAfore,RecepcionImagenes imagenes) {
		logger.info("url consultarRecepcionImagenes: {}", imagenRecibida);

		ArrayList<ImagenDocumento> documentosRecibidos = new ArrayList<>();
		try {
			List<Parametro> archivosExcluidos = catalogoService.obtenerParametroDdbpose(ServiciosConstants.T00035,utileriaCadena.obtenerCadenaConcatenada(true, cveAfore, ServiciosConstants.COMA,imagenes.getClaveTipoProceso()));
			
			for (ImagenDocumento detalleImagen : imagenRecibida) {
				
				Parametro documentoExcluido = new Parametro();
				
				documentoExcluido.setChValorParametro(detalleImagen.getClaveTipoDocumento());
				
				if (!archivosExcluidos.contains(documentoExcluido)) {
					ImagenDocumento imagenDocumento = new ImagenDocumento();					
						imagenDocumento.setClaveTipoDocumento(detalleImagen.getClaveTipoDocumento());
						imagenDocumento.setTipoImagenDocumento(detalleImagen.getTipoImagenDocumento());
						imagenDocumento.setNombreDocumento(detalleImagen.getNombreDocumento());
						imagenDocumento.setContenidoDocumento(detalleImagen.getContenidoDocumento());

						documentosRecibidos.add(imagenDocumento);
				}
			}
		} catch (Exception e) {
			logger.error("Se presento un problema en el servicio de Recuperacion de Imagenes ", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return documentosRecibidos;
	}
}
