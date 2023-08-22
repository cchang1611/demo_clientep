package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivosXlsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.CaracteresConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.MensajeConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCargaMasiva;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioAgente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * archivos excel
 * @Author Ricardo Alcantara Ramirez Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)@procesar.com
 * May 4, 2022
 */
@Service
public class ArchivosXlsServiceImpl implements ArchivosXlsService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ArchivosXlsServiceImpl.class);
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Autowired
	private CadenasUtils utileriaCadenas;
	
	/**
	 * Cliente
	 */
	@Autowired
	private RestServiceClientUtils servicioCliente;
	
	/**
	 * Inyeccion utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Value("${url.servicio.comunes}")
	private String servicioComunes;
	
	/**
	 * Inyeccion utileria cadenas
	 */
	@Value("${url.servicio.usuarios}")
	private String servicioUsuarios;
	
	/**
	 * servicio de catalogo
	 */
	@Autowired
	private CatalogoService catalogoServices;
	

	/* (non-Javadoc)
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * May 5, 2022
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivosXlsService#obtenerDatosExcel(org.springframework.web.multipart.commons.CommonsMultipartFile)
	 */
	@Override
	public Map<String, Object> obtenerDatosExcel(String nomArchivo, InputStream inputfile, UsuarioLogin usuario) {
		
		List<UsuarioAgente> registros = new ArrayList<>();
		Map<String, Object> respuesta = new HashMap<>();
		RespuestaGenerica respuestaRest = new RespuestaGenerica();
		try {
			if (inputfile != null ) {
				logger.info("File es: {}", nomArchivo);
				
				validarAforePermitidas(nomArchivo);
				
				
				InputStream is = inputfile;
				String [] fila = null;
				CSVReader reader = new CSVReaderBuilder(new InputStreamReader(is)).withSkipLines(1).build();
				while ((fila = reader.readNext()) != null) {
					registros.add(new UsuarioAgente(fila[0], fila[1], fila[2], fila[3], fila[4], fila[5], fila[6]));
				}
				reader.close();
				logger.error("el tamaño de la lista es: {}", registros.size());
				validaCantidadRegistro(registros);
				
				DatosCargaMasiva dtoUsuarios = new DatosCargaMasiva();
				dtoUsuarios.setNombreAgente(usuario.getNombre().trim());
				dtoUsuarios.setApellidoPaterno(usuario.getApellidoPaterno().trim());
				dtoUsuarios.setApellidoMaterno(usuario.getApellidoMaterno().trim());
				dtoUsuarios.setClaveAfore(usuario.getAforeUsuario());
				dtoUsuarios.setCorreoElectronico(usuario.getUsuario());
//				dtoUsuarios.setCorreoElectronico("ralcanra@procesar.com");
				dtoUsuarios.setNomArchivo(nomArchivo);
				dtoUsuarios.setLstUsuarioAgentes(registros);
				
				respuestaRest = envioUsuarios(dtoUsuarios);
				
			} else {
				logger.error("\n\nNo se encontro el archivo cargado");
			throw new BusinessException(MensajeConstants.ERROR_USUARIOS_NO_REGISTROS);
			}
		} catch (BusinessException be) {
			logger.error("\nSe encontro un BusinessException obtenerDatosExcel: {}", be);
			respuestaRest.setFlujo(NumerosConstants.INT_DOS);
			respuestaRest.setTitulo(MensajeConstants.ERROR_TITULO_GENERICO);
			respuestaRest.setMensaje(be.getMessage());
			respuestaRest.setLstObRespuesta(null);
		} catch (Exception e) {
			logger.error("\nSe encontro un Exception obtenerDatosExcel: {}", e);
			respuestaRest.setFlujo(NumerosConstants.INT_DOS);
			respuestaRest.setTitulo(MensajeConstants.ERROR_TITULO_GENERICO);
			respuestaRest.setMensaje("");
			respuestaRest.setLstObRespuesta(null);
		} 
		respuesta.put("dtoRespuesta", respuestaRest);
		return respuesta;
	}

	private void validarAforePermitidas(String nomArchivo) {
		String afore = null;
		List<Parametro>  lstParametro = catalogoServices.obtenerParametroDdbpose(ActivacionConstants.PARAMETRO_CARGA_MASIVA_AFORES);
		if (!utileriaValidador.isEmpty(nomArchivo)) {
			String[] array = nomArchivo.split(CaracteresConstants.GUION_BAJO);				
			afore = array[0];
			List<String> lstAfores = Arrays.asList(lstParametro.get(NumerosConstants.INT_CERO).getChValorParametro().split(","));
			if (!lstAfores.contains(afore)) {
				throw new BusinessException(MensajeConstants.ERROR_AFORE_NO_PERMITIDAS);
			}
		}
	}

	/**
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * May 10, 2022
	 * @param agenteUsuario 
	 * @return 
	 */
	private RespuestaGenerica envioUsuarios(DatosCargaMasiva agenteUsuario) {
						
		String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true,servicioUsuarios, ServiciosConstants.URI_SERVICIO_CONTROL_USUARIOS, ServiciosConstants.URL_VALIDAR_CARGA_USUARIOS);
		RespuestaGenerica respuesta = servicioCliente.ejecutarServicioPost(urlServicio, agenteUsuario.getLstUsuarioAgentes(), RespuestaGenerica.class);
		if (!utileriaValidador.isEmpty(respuesta) && NumerosConstants.INT_UNO.equals(respuesta.getFlujo()) && utileriaValidador.validarListaVacia(respuesta.getLstObRespuesta())) {
			respuesta = guardarCargaUsuarios(agenteUsuario);
			if (!utileriaValidador.isEmpty(respuesta) && NumerosConstants.INT_UNO.equals(respuesta.getFlujo())){
				respuesta.setTitulo(MensajeConstants.TITULO_CARGA_USUARIOS);
				respuesta.setMensaje(MensajeConstants.MENSAJE_PROCESO_ARCHIVO);
			}
		}else if(NumerosConstants.INT_UNO.equals(respuesta.getFlujo()) && !utileriaValidador.isEmpty(respuesta.getLstObRespuesta())) {
			respuesta.setFlujo(NumerosConstants.INT_DOS);
			respuesta.setTitulo(MensajeConstants.TITULO_ERROR_CARGA_USUARIOS);
			respuesta.setMensaje(MensajeConstants.MENSAJE_ERROR_PROCESO_ARCHIVO);
		}
		return respuesta;
	}

	/**
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * May 26, 2022
	 * @param registros
	 * @return 
	 */
	@Override
	@Async
	public RespuestaGenerica guardarCargaUsuarios(DatosCargaMasiva registros) {
		logger.error("entro hora: {}", LocalDateTime.now());
		String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true,servicioUsuarios, ServiciosConstants.URI_SERVICIO_CONTROL_USUARIOS, ServiciosConstants.URL_GUARDAR_CARGA_USUARIOS);
		return servicioCliente.ejecutarServicioPost(urlServicio, registros, RespuestaGenerica.class);
	}

	/**
	 * MEtodo para validar el tamaño de los registros en minimo y maximo
	 * @Author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * May 6, 2022
	 * @param registros
	 */
	protected void validaCantidadRegistro(List<UsuarioAgente> registros) {
		if (registros.size()<NumerosConstants.INT_VEINTE) {
			logger.error("El archivo no cumple con el número mínimo de registros");
			throw new BusinessException(MensajeConstants.ERROR_MINIMO_REGISTRO);
		}else if(registros.size()> NumerosConstants.INT_TRECIENTOS){
			throw new BusinessException(MensajeConstants.ERROR_MAXIMO_REGISTRO);
		}
	}

	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivosXlsService#obtenerArchivoUsuarios(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin)
	 */
	@Override
	public DatosCargaMasiva obtenerArchivoUsuarios(String fechaBusqueda, UsuarioLogin user) {
		DatosCargaMasiva registros = new DatosCargaMasiva();
		
		registros.setClaveAfore(user.getAforeUsuario());
		registros.setCorreoElectronico(user.getUsuario());
//		registros.setCorreoElectronico("ralcanra@procesar.com");
		registros.setFechaBusqueda(fechaBusqueda);
		registros.setNombreAgente(user.getNombre());
		registros.setApellidoPaterno(user.getApellidoPaterno());
		registros.setApellidoMaterno(user.getApellidoMaterno());
		
		String urlServicio = utileriaCadenas.obtenerCadenaConcatenada(true,servicioUsuarios, ServiciosConstants.URI_SERVICIO_CONTROL_USUARIOS, ServiciosConstants.URL_ARCHIVO_USUARIOS);
		registros =servicioCliente.ejecutarServicioPost(urlServicio, registros, DatosCargaMasiva.class);
		if (utileriaValidador.isEmpty(registros) || NumerosConstants.INT_DOS.equals(registros.getFlujo())) {
			throw new BusinessException(registros.getMensaje());
		}
		logger.error("byte::: {}",registros.getArchivo().length);
		return registros;
	}

	
}