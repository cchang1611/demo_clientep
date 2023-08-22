package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ActualizaDetalleFolio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioActivoDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioFechas;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion del servicio de folios
 * 
 * @author Omar Balbuena Quinones (OJBALBUE@inet.procesar.com.mx)
 * @version 1.0
 * @since 10/05/2019
 */
@Service
public class FolioServiceImpl implements FolioService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(FolioServiceImpl.class);

	/**
	 * Uri Servicio para generar folio
	 */
	@Value("${comunes.folio.uri}")
	private String urlFolioServicio;
	
	/**
	 * urlFolioPadreActivo
	 */
	@Value("${comunes.folios.consultarSiTieneFolioPadre}")
	private String urlConsultarSiTieneFolioPadre;
	
	/**
	 * urlConsultaFolioActivo
	 */
	@Value("${comunes.folios.consultaFoliosHijoEstatusActivo}")
	private String uriConsultaFoliosHijoEstatusActivo;
	
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * Inyeccion de rest
	 */
	@Autowired
	private RestTemplate servicioCliente;
	
	/**
	 * Servicio consulta folio hijo
	 */
	@Value("${url.consulta.folioPulssarHijo}")
	private String urlConsultaFolioHijo;
	
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * url consulta folio padre por folio hijo
	 */
	@Value("${url.consulta.folio.padre}")
	private String urlConsultaFolioPadre;
	
	/**
	 * url consulta folio detalle
	 */
	@Value("${url.consulta.folio.detalle}")
	private String urlConsultaFolioDetalle;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FolioEntrada generarFolio(FolioEntrada solicitudFolio) {
		FolioEntrada respuestaFolio = null;

		try {
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<FolioEntrada> entidadFolio = new HttpEntity<>(solicitudFolio, headerMedia);
			
			logger.info(urlFolioServicio);
			logger.info("Peticion generacion de folio {}", solicitudFolio);

			ResponseEntity<FolioEntrada> respuesta = servicioCliente.exchange(urlFolioServicio, HttpMethod.POST, entidadFolio, FolioEntrada.class);
			
			logger.info("La respuesta del folio {} ", respuesta.getBody());
			if (utileriaValidador.validarObjetoNulo(respuesta.getBody())) {
				throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
			}
			
			respuestaFolio = respuesta.getBody();
		} catch (Exception e) {
			logger.error("Generar folios:Se presento un problema en el servicio de folios {}", urlFolioServicio, e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}

		return respuestaFolio;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cerrarFolio(Long id, Integer estatus) {
		try {
			if(!utileriaValidador.validarObjetoNulo(id)) {
				String urlCerrarFolio = utileriaCadena.obtenerCadenaConcatenada(true, urlFolioServicio, ExpresionesConstants.DIAGONAL, String.valueOf(id));
				if(!utileriaValidador.validarObjetoNulo(estatus)) {
					urlCerrarFolio = utileriaCadena.obtenerCadenaConcatenada(true, urlCerrarFolio, ServiciosConstants.STATUS_SERVICIO_URL, String.valueOf(estatus));
					logger.info(urlCerrarFolio);
					HttpEntity<String> entidadRegistro = new HttpEntity<>("");
					ResponseEntity<String> respuesta = servicioCliente.exchange(urlCerrarFolio, HttpMethod.PUT, entidadRegistro, String.class);
					logger.info("Respuesta put cierre folio: {}", respuesta.getStatusCode());
				} else {
					logger.info(urlCerrarFolio);
					servicioCliente.delete(urlCerrarFolio);
				}
				
				logger.info("Se cerro correctamente el folio: {} {}", id, estatus);
			} else {
				logger.info("id nulo");
			}
		} catch (Exception e) {
			logger.error("Cerrar folio:Se presento un problema en el servicio de folios {}", urlFolioServicio, e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
	}
	


	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService#generarNuevoFolio(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada)
	 */
	@Override
	public FolioEntrada generarNuevoFolio(FolioEntrada entrada) {
		logger.info("datos generarNuevoFolio: {}\n {}\n {}", entrada);
		FolioEntrada respuesta = generarFolio(entrada);
		if(BusinessErrorEnum.FOLIO_ACTIVO.getClave().equals(respuesta.getMensaje())){
			cerrarFolio(respuesta.getIdFolio(), null);	
			return generarFolio(entrada);
		}
		
		return respuesta;
	}


	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService#cerrarFolio(java.lang.Long, java.lang.Integer, java.lang.String)
	 */
	@Override
	public void cerrarFolio(Long id, Integer estatus, String diagnosticoProcesar) {
		try {
			String urlCerrarFolio = utileriaCadena.obtenerCadenaConcatenada(true, urlFolioServicio, ExpresionesConstants.DIAGONAL, String.valueOf(id),
					ServiciosConstants.STATUS_SERVICIO_URL, String.valueOf(estatus), ExpresionesConstants.SIGNO_INTERROGACION_SIERRE,
					ServiciosConstants.PARAMETRO_MOTIVO, diagnosticoProcesar);
			logger.info("url cerrar folio con motivo: {}", urlCerrarFolio);
			HttpEntity<String> entidadEntrada = new HttpEntity<>("");
			ResponseEntity<String> respuesta = servicioCliente.exchange(urlCerrarFolio, HttpMethod.PUT, entidadEntrada, String.class);
			logger.info("Respuesta put cierre folio con motivo: {}", respuesta.getStatusCode());			
		} catch (Exception e) {
			logger.error("Cerrar folio:Se presento un problema en el servicio de folios {}", urlFolioServicio, e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);			
		}
	}
	
	@Override
	public boolean consultaSiFolioPadreActivo(Long idFolio) {
		String uri = urlConsultarSiTieneFolioPadre.replace(ServiciosConstants.ID_FOLIO_PULSSAR, idFolio.toString());
		logger.info("uri consultaSiFolioPadreActivo {}", uri);
		Long activo = servicioCliente.getForObject(uri, Long.class);
		if(activo == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 *  consultaFolioActivo
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param cveServicio
	 *  @param curp
	 *  @param nss
	 *  @param cveProceso
	 *  @return
	 */
	@Override
	public List<FolioActivoDetalle> consultaFolioActivo(String cveServicio, String curp, String nss, String cveProceso) {
		StringBuilder uri = new StringBuilder(uriConsultaFoliosHijoEstatusActivo);
		if(!StringUtils.isBlank(curp)) {
			uri.append("curp=").append(curp).append("&");
		}
		if(!StringUtils.isBlank(nss)) {
			uri.append("nss=").append(nss);
		}
		String uri2 = uri.toString();
		uri2 = uri2.replace("{cveServicio}", cveServicio);
		uri2 = uri2.replace("{cveProceso}", cveProceso);
		logger.info("uri: {}", uri2);
		ResponseEntity<List<FolioActivoDetalle>> lista =  servicioCliente.exchange(uri2, HttpMethod.GET, null, new ParameterizedTypeReference<List<FolioActivoDetalle>>() {});
		
		if(ObjectUtils.isEmpty(lista.getBody())){
			return new ArrayList<>();
		}
		return lista.getBody();
	}
	
	/**
	 * Metodo encargado de construir el Folio de entrada
	 * 
	 * @param trabajador
	 * @param idUsuario
	 * @return
	 */
	@Override
	public FolioEntrada llenarObjetoFolioEntrada(String curp, String nss, String descripcion, String tipoOperacion, String tLlegada) {
		FolioEntrada folio = new FolioEntrada();
		folio.setCurp(curp);
		folio.setDescripcion(descripcion);
		folio.setNss(nss);
		folio.setOperacion(tipoOperacion);
		folio.setTiempoLlegada(tLlegada);
		
		return folio;
	}
	
	/**
	 * Metodo encargado de obtener el Folio
	 * 
	 * @param folio
	 * @param idUsuario
	 * @param sucursal
	 * @param servicio
	 * @param proceso
	 * @return
	 */
	@Override
	public Folio obtenerFolio(FolioEntrada folio, Long idUsuario, String sucursal, String servicio, String proceso) {
		FolioEntrada auxiliar = folio;
		auxiliar.setIdUsuario(idUsuario);
		auxiliar.setSucursal(sucursal);
		auxiliar.setServicio(servicio);
		auxiliar.setProceso(proceso);
		
		FolioEntrada respuestaFolio = this.generarFolio(auxiliar);
		
		Folio folioHijo;
		if(ServiciosConstants.RESULTADO_NOK.equals(respuestaFolio.getResultado())) {
			Long idFolio = respuestaFolio.getIdFolio();
			if(utileriaValidador.validarObjetoNulo(idFolio)) {
				List<FolioActivoDetalle> lstFolio = this.consultaFolioActivo(servicio, auxiliar.getCurp(), auxiliar.getNss(), proceso);
				if(!utileriaValidador.validarListaVacia(lstFolio)) {
					FolioActivoDetalle folioAuxiliar = lstFolio.get(NumerosConstants.INT_CERO);
					idFolio = folioAuxiliar.getIdFolioPulssar();
				}
			}
			this.cerrarFolio(idFolio, null);
			respuestaFolio = this.generarFolio(auxiliar);
		}
		folioHijo = this.consultarFolioHijo(respuestaFolio.getIdFolio());

		return folioHijo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Folio consultarFolioHijo(Long idFolio) {
		logger.error("Entrando a consulta folioHijo :: consultarFolioHijo");
		String consultaFolioHIjo = StringUtils.replace(urlConsultaFolioHijo, ServiciosConstants.ID_FOLIO_PULSSAR, String.valueOf(idFolio));
		
		logger.info("URL consulta folio hijo: {}", consultaFolioHIjo);
		Folio consultaFolio = servicioCliente.getForObject(consultaFolioHIjo, Folio.class);
		logger.info("Respuesta FolioHijo {}", consultaFolio.toString());
		return consultaFolio;
	}
	
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService#procesarFolio(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador)
	 */
	@Override
	public FolioEntrada procesarFolio(FolioEntrada folio, DatosTrabajador trabajador) {
		
		if (!consultaSiFolioPadreActivo(trabajador.getFolio().getIdFolio())) {
			folio.addFolios(trabajador.getFolio().getFolio());
		}
		
		List<FolioActivoDetalle> foliosAct = consultaFolioActivo(folio.getServicio(), trabajador.getDatosCertificables().getCurp(), trabajador.getNss(), folio.getProceso());

		if (!foliosAct.isEmpty()) {
			cerrarFolio(foliosAct.get(0).getIdFolioPulssar(),3);
//			for (FolioActivoDetalle x : foliosAct) {
//				if (x.getNuEstatus() == 1L) {
//					cerrarFolio(x.getIdFolioPulssar(), 3);
//				}
//			}
		}
		
		
		FolioEntrada folioRespuesta = generarFolio(folio);
		if ("02".equals(folioRespuesta.getResultado())) {
			logger.info("1");
			cerrarFolio(folioRespuesta.getIdFolio(), null);
			logger.info("2");
			folioRespuesta = generarFolio(folio);
		}
		

		
		return folioRespuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FolioFechas consultarFechasFolio(Long idFolio) {
		logger.error("Entrando a consulta folioHijo :: consultarFolioHijo");
		String urlFolioFechas = utileriaCadena.obtenerCadenaConcatenada(true, uriComunes,"foliopulssar/consultaFechasFolio/",String.valueOf(idFolio));
		logger.info("URL consulta consultarFechasFolio: {}", urlFolioFechas);
		FolioFechas consultaFolio = servicioCliente.getForObject(urlFolioFechas, FolioFechas.class);
		logger.info("Respuesta consultarFechasFolio {}", consultaFolio);
		return consultaFolio;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FolioActivo consultarFolioActivo(String curp,String nss,String cveServicio){

		FolioActivo folioActivo = null;
		logger.info("Entrando a consultar folio activo proxy");
		String url = utileriaCadena.obtenerCadenaConcatenada(true, uriComunes,"foliopulssar/consultaFolioActivo/{cveServicio}?");
		url = url.replace("{cveServicio}", cveServicio);
		StringBuilder url2 = new StringBuilder(url);
		if(!StringUtils.isBlank(curp)) {
			url2.append("curp=").append(curp).append("&");
		}
		if(!StringUtils.isBlank(nss)) {
			url2.append("nss=").append(nss);
		}		
		logger.info("URL consulta folio activo: {}",url2);
		folioActivo = servicioCliente.getForObject(url2.toString(), FolioActivo.class);
		logger.info("resultado consultarFolioActivo: {}",folioActivo);
		return folioActivo;		
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Folio consultarFolioPadrePorFolioHijo(String folio) {
		logger.error("Entrando a consulta folioHijo :: consultarFolioHijo");
		String consultaFolioPadre = StringUtils.replace(urlConsultaFolioPadre, "{folioPulssar}", folio);
		
		logger.info("URL consultarFolioPadrePorFolioHijo: {}", consultaFolioPadre);
		Folio consultaFolio = servicioCliente.getForObject(consultaFolioPadre, Folio.class);
		logger.info("Respuesta consultarFolioPadrePorFolioHijo {}", consultaFolio);
		return consultaFolio;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public FolioDetalle consultaFolioDetalle(Long idFolioPulssar) {
		logger.info("Entrando a consulta consultaFolioDetalle:: {}",idFolioPulssar);
		String urlFolioDetalle = StringUtils.replace(urlConsultaFolioDetalle, ServiciosConstants.ID_FOLIO_PULSSAR, String.valueOf(idFolioPulssar));	
		logger.info("URL consultaFolioDetalle: {}", urlFolioDetalle);
		FolioDetalle consultaFolioDetalle = servicioCliente.getForObject(urlFolioDetalle, FolioDetalle.class);
		logger.info("Respuesta consultaFolioDetalle {}", consultaFolioDetalle);
		return consultaFolioDetalle;
	}

	/**
	 * Generar folio de consulta
	 * @param datosEntrada
	 * @param user
	 * @return
	 */
	@Override
	public FolioEntrada generarFolioAutoClose(FolioEntrada solicitudFolio){
		
		FolioEntrada respuesta = this.generarFolio(solicitudFolio);
		
		if(ServiciosConstants.RESULTADO_NOK.equals(respuesta.getResultado())) {
			this.cerrarFolio(respuesta.getIdFolio(), null);
			respuesta = this.generarFolio(solicitudFolio);
		}
		return respuesta;
	}	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actualizarFolio(String folioPadre, String claveServicio,String descripcion) {
		try {
			ActualizaDetalleFolio actualizaDetalleFolio = new ActualizaDetalleFolio();
			actualizaDetalleFolio.setIdFolio(folioPadre);
			actualizaDetalleFolio.setClaveServicio(claveServicio);
			actualizaDetalleFolio.setDescripcion(descripcion);
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			String urlServicio = utileriaCadena.obtenerCadenaConcatenada(true, urlFolioServicio,ServiciosConstants.ACTUALIZA_FOLIO);
			HttpEntity<ActualizaDetalleFolio> entidadActualizaFolio = new HttpEntity<>(actualizaDetalleFolio, headerMedia);
			
			logger.info("url actualizarFolio: {}",urlServicio);
			logger.info("Peticion actualizarFolio {}", entidadActualizaFolio);
	
			ResponseEntity<String> respuesta = servicioCliente.exchange(urlServicio, HttpMethod.PUT, entidadActualizaFolio, String.class);
			logger.info("Respuesta : {}",respuesta);
		}catch (Exception e) {
			logger.error("ocurrio un problema en el servicio actualizarFolio: {}",e);
		}
	}
}