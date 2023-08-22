package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.Date;

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
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CeroPapelService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ModificacionTrabajadorConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCeroPapel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Implementacion de cero papel
 * @author RARREOLA
 *
 */
@Service
public class CeroPapelServiceImpl implements CeroPapelService {
	
	/**
	 * Logger
	 */
	private static final Logger logger =  LoggerFactory.getLogger(CeroPapelServiceImpl.class);
	

	/**
	 * dependencia clienteServicio
	 */
	@Autowired
	private RestTemplate clienteServicio;
	
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	
	/**
	 * uriConsultaEstatus
	 */
	@Value("${comunes.ceroPapel.consultaEstatus}")
	private String uriConsultaEstatus;
	
	
	
	/**
	 * uriGuardarCeroPapel
	 */
	@Value("${comunes.guardar.ceroPapel}")
	private String uriGuardarCeroPapel;
	
    /**
     * reimpresionTramitesService
     */
	@Autowired
	private ReimpresionTramitesService reimpresionTramitesService;
	
	/**
	 * Guardar datos de cero papel
	 * @param principalCeroPapel
	 */
	@Override
	public Long guardarDatosCeroPapel(EntradaCeroPapel entradaCeroPapel) {
		Long idCeroPapel = null;
		RespuestaServicioNotificacion notificacion=null;
		try{
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<EntradaCeroPapel> entidadFolio = new HttpEntity<>(entradaCeroPapel, headerMedia);
			
			logger.info(uriGuardarCeroPapel);
			logger.info("Peticion generacion de cero papel {}", entradaCeroPapel.toString());

			ResponseEntity<RespuestaGenerica> respuesta = clienteServicio.exchange(uriGuardarCeroPapel, HttpMethod.POST, entidadFolio, RespuestaGenerica.class);
			
			logger.info("La respuesta del cero papel {} ", respuesta.getBody());
			RespuestaGenerica respuestaGenerica = respuesta.getBody();
			
			if(ActivacionConstants.DOS == respuestaGenerica.getFlujo()){
				notificacion=reimpresionTramitesService.envioNotificacionTramites(llenarObjetoTramitesConcluidosEntradas(entradaCeroPapel,FormatoConstants.RESULTADO_OPERACION_RECHAZADO));
				logger.error("Se envio notificacion cero papel respuesta ::{} ", notificacion);
				throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
				
			}
			
			if(!utileriaValidador.validarObjetoNulo(respuestaGenerica)){
				idCeroPapel = Long.parseLong(respuestaGenerica.getMensaje());
			}
			notificacion=reimpresionTramitesService.envioNotificacionTramites(llenarObjetoTramitesConcluidosEntradas(entradaCeroPapel,FormatoConstants.RESULTADO_OPERACION_ACEPTADO));
			logger.error("Se envio notificacion cero papel respuesta ::{} ", notificacion);
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio de guardar los datos de  cero papel", e);
			reimpresionTramitesService.envioNotificacionTramites(llenarObjetoTramitesConcluidosEntradas(entradaCeroPapel,FormatoConstants.RESULTADO_OPERACION_RECHAZADO));
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return idCeroPapel;
	}



	/**
	 * Consulta estatus cero
	 * @param idProcesar
	 * @return
	 */
	@Override
	public CeroPapel consultaEstatusCeroPapel(Long idProcesar) {
		CeroPapel ceroPapel = null; 
		try{
			
			StringBuilder uri = new StringBuilder(uriConsultaEstatus);
			String uriDos = uri.toString();
			String uriNueva = uriDos.replace("{idProcesar}", idProcesar.toString());
			
			logger.info("uri: {}", uriNueva);
			ResponseEntity<CeroPapel> respuesta =  clienteServicio.exchange(uriNueva, HttpMethod.GET, null, new ParameterizedTypeReference<CeroPapel>() {});
			ceroPapel = respuesta.getBody();
			
		} catch(Exception e) {
			logger.error("Se presento un problema en el servicio de consultar los datos de  cero papel", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return ceroPapel;
	}

	/**
	 * llenarObjetoTramitesConcluidosEntradas
	 * @param entradaCeroPapel
	 * @return
	 */
	private TramitesConcluidosEntrada llenarObjetoTramitesConcluidosEntradas(EntradaCeroPapel entradaCeroPapel,String resultadoOperacion) {
		logger.error("Entrada tramites cero papel:{} ", entradaCeroPapel);
		logger.error("Resultado de la operacion:{} ", resultadoOperacion);	
		TramitesConcluidosEntrada entradaTramiteConcluido= new TramitesConcluidosEntrada();
		entradaTramiteConcluido.setAfore(entradaCeroPapel.getAfore());
		entradaTramiteConcluido.setCurp(entradaCeroPapel.getCurp());
		entradaTramiteConcluido.setFolioProcesar(entradaCeroPapel.getFolioCeroPapel());
		entradaTramiteConcluido.setSubTipoSolicitante(entradaCeroPapel.getNuEstatusCeroPapel().toString());
		entradaTramiteConcluido.setResultadoOperacion(resultadoOperacion);
		entradaTramiteConcluido.setTipoSolicitante(ModificacionTrabajadorConstants.TIPO_SOLICITANTE_CERO_PAPEL);
		entradaTramiteConcluido.setUsuarioModificador(ModificacionTrabajadorConstants.CERO_PAPEL_USUARIO);
		entradaTramiteConcluido.setFcControl(new Date());
		logger.error("Peticion tramites cero papel:{} ", entradaTramiteConcluido);
		return entradaTramiteConcluido;
		
	}
}
