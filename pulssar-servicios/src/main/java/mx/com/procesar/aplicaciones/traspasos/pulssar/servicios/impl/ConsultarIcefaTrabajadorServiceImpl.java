/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants.FORMATO_SERVICIO;
import static org.springframework.util.ObjectUtils.isEmpty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarIcefaTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosIcefaTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TrabajadorSaldoSar92;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TrabajadorSaldoSarIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TrabajadorSar92;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TrabajadorSarIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Clase que implementa la interfaz para obtener Icefas del Trabajador
 * @author lvgonzal
 *
 */
@Service
public class ConsultarIcefaTrabajadorServiceImpl implements ConsultarIcefaTrabajadorService{
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(SaldosPreliminaresServiceImpl.class);
	
	/**
	 * Inyeccion de servicio Sar 92
	 */
	@Value("${uri.comunes.trabajador.sar92}")
	private String uriServicioTrabajadorSar92;
	
	/**
	 * Inyeccion de servicio SarISSSTE
	 */
	@Value("${uri.comunes.trabajador.sarissste}")
	private String uriServicioTrabajadorSarissste;
	
	/**
	 * url servicio Trabajador Saldo SAR92
	 */
	@Value("${uri.comunes.trabajador.saldo.sar92}")
	private String uriServicioTrabajadorSaldoSar92;
	
	/**
	 * url servicio Trabajador Saldo SARISSSTE
	 */
	@Value("${uri.comunes.trabajador.saldo.sarissste}")
	private String uriServicioTrabajadorSaldoSarissste;
	
	/**
	 * Inyeccion service catalogo
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	/**
	 * dependencia utilidad validador
	 */
	@Autowired 
	private ValidadorUtils utileriaValidador;
		
	/**
	 * utilidades de fechas
	 */
	@Autowired
	private FechaUtils fechaUtils;
	
	/**
	 * restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;


	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ConsultarIcefaTrabajadorService#obtenerIcefasTrabajadorSar92(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public List<TrabajadorSar92> obtenerTrabajadorSar92(String nss, String rfc, String fechaNacimiento) {
		StringBuilder uri = new StringBuilder(uriServicioTrabajadorSar92);
		
		if(!StringUtils.isBlank(nss)) {
			uri.append("nss=").append(nss).append("&");
		}
		if(!StringUtils.isBlank(rfc)) {
			uri.append("rfc=").append(rfc).append("&");
		}
		if(!StringUtils.isBlank(fechaNacimiento)) {
			uri.append("fechaNacimiento=").append(fechaNacimiento);
		}
					
		logger.info(uri.toString());
		
		ResponseEntity<List<TrabajadorSar92>> response = restTemplate.exchange(uri.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TrabajadorSar92>>() {
				});
		
		return isEmpty(response.getBody()) ? null : response.getBody();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ConsultarIcefaTrabajadorService#obtenerIcefasTrabajadorSarIssste(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public List<TrabajadorSarIssste> obtenerTrabajadorSarIssste(String curp, String rfc, String fechaNacimiento) {
		
		StringBuilder uri = new StringBuilder(uriServicioTrabajadorSarissste);
		
		if(!StringUtils.isBlank(curp)) {
			uri.append("curp=").append(curp).append("&");
		}
		if(!StringUtils.isBlank(rfc)) {
			uri.append("rfc=").append(rfc).append("&");
		}
		if(!StringUtils.isBlank(fechaNacimiento)) {
			uri.append("fechaNacimiento=").append(fechaNacimiento);
		}
		
		logger.info(uri.toString());
		
		ResponseEntity<List<TrabajadorSarIssste>> response = restTemplate.exchange(uri.toString(), HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TrabajadorSarIssste>>() {
				});
		
		return isEmpty(response.getBody()) ? null : response.getBody();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ConsultarIcefaTrabajadorService#obtenerIcefasTrabajador(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public List<DatosIcefaTrabajador> obtenerIcefasTrabajador(String nss, String curp, String rfc, String fechaNacimiento) {
		
		logger.info("Se Obtienen Icefas del Trabajador: nss = {} curp = {} rfc = {} fecha= {}", nss, curp, rfc, fechaNacimiento );
		List<DatosIcefaTrabajador> listaIcefas = new ArrayList<>();
		
		List<Parametro> listaParametros = servicioCatalogo.obtenerParametro(ServiciosConstants.PARAMETRO_INDICADOR_SALDO_ICEFA, null);
		
		Parametro parametro = listaParametros.get(NumerosConstants.INT_CERO);
		
		BigDecimal montoIndicadorSaldo = new BigDecimal(parametro.getChValorParametro());
		
		List<TrabajadorSar92> trabajadoresSar92 = obtenerTrabajadorSar92(nss, rfc, fechaNacimiento);
		
        List<TrabajadorSarIssste> trabajadoresSarissste = obtenerTrabajadorSarIssste(curp, rfc, fechaNacimiento);
        
        if(!utileriaValidador.validarListaVacia(trabajadoresSar92)) {
        	for(TrabajadorSar92 trabajadorSar92 : trabajadoresSar92) {
        		if (!trabajadorSar92.getIcefa().startsWith(NumerosConstants.C_CINCO)) {
        			DatosIcefaTrabajador icefaTrabajador = new DatosIcefaTrabajador();
					icefaTrabajador.setNombreTrabajador(trabajadorSar92.getNombreTrabajador());
					icefaTrabajador.setFechaNacimiento(trabajadorSar92.getFechaNacimiento());
					icefaTrabajador.setRfc(trabajadorSar92.getRfc());
					icefaTrabajador.setNss(trabajadorSar92.getNss());
					icefaTrabajador.setCurp(trabajadorSar92.getCurp());
					icefaTrabajador.setIcefa(trabajadorSar92.getIcefa());
					icefaTrabajador.setControlInterno(trabajadorSar92.getControlInterno());
					icefaTrabajador.setNombreBanco(trabajadorSar92.getBancoIcefa().getDescripcionIcefa());
					icefaTrabajador.setNombrePatron(trabajadorSar92.getNombrePatron());
					icefaTrabajador.setRfcPatron(trabajadorSar92.getRfcPatronal());
					icefaTrabajador.setSituacionLegal(trabajadorSar92.getClaveCriterioSar92());
					icefaTrabajador.setIndicadorSaldo(obtenerIndicadorSaldosSar92(trabajadorSar92.getSaldoSar92().getSaldoActualImss(), trabajadorSar92.getSaldoSar92().getSaldoActualInfonavit(), montoIndicadorSaldo));
					listaIcefas.add(icefaTrabajador);
        		}
        	}
        }
		
        if(!utileriaValidador.validarListaVacia(trabajadoresSarissste)) {
        	for(TrabajadorSarIssste trabajadorSarissste : trabajadoresSarissste) {
        		if (!trabajadorSarissste.getEntidadOrigen().startsWith(NumerosConstants.C_CINCO)) {
        			DatosIcefaTrabajador icefaTrabajador = new DatosIcefaTrabajador();
        			icefaTrabajador.setNombre(trabajadorSarissste.getNombre());
        			icefaTrabajador.setApellidoPaterno(trabajadorSarissste.getPrimerApellido());
        			icefaTrabajador.setApellidoMaterno(trabajadorSarissste.getSegundoApellido());
					icefaTrabajador.setNombreTrabajador(trabajadorSarissste.getNombreIcefa());
					icefaTrabajador.setFechaNacimiento(fechaUtils.convertirFechaACadena(trabajadorSarissste.getFechaNacimiento(), FORMATO_SERVICIO));
					icefaTrabajador.setRfc(trabajadorSarissste.getRfc());
					icefaTrabajador.setNss(trabajadorSarissste.getNss());
					icefaTrabajador.setCurp(trabajadorSarissste.getCurp());
					icefaTrabajador.setIcefa(trabajadorSarissste.getEntidadOrigen());
					icefaTrabajador.setControlInterno(trabajadorSarissste.getControlInterno());
					icefaTrabajador.setNombreBanco(trabajadorSarissste.getBancoIcefa().getDescripcionIcefa());
					icefaTrabajador.setNombrePatron(trabajadorSarissste.getNombrePatron());
					icefaTrabajador.setRfcPatron(trabajadorSarissste.getRfcPatronal());
					icefaTrabajador.setSituacionLegal(trabajadorSarissste.getSaldoSarIssste().getCriterio());
					icefaTrabajador.setIndicadorSaldo(obtenerIndicadorSaldosSarissste(trabajadorSarissste.getSaldoSarIssste().getSaldoActualSar(), trabajadorSarissste.getSaldoSarIssste().getSaldoActualVivienda(), montoIndicadorSaldo));
					listaIcefas.add(icefaTrabajador);
        		}
        	}
        }
		
		return listaIcefas;
	}
	
	/**
	 * Obtener Indicador de Saldo para Trabajador SAR92
	 * @param saldos
	 * @return
	 */
	private String obtenerIndicadorSaldosSar92(BigDecimal saldoActualImss, BigDecimal saldoActualInfonavit, BigDecimal montoIndicador) {
		logger.info(
				"Se Obtienen Indicador Saldo Icefas del Trabajador: montoIndicador = {} Saldo SAR = {} Saldo Vivienda = {} ",
				montoIndicador, saldoActualImss, saldoActualInfonavit);
		String indicadorSaldos = null;
		
		
		if((saldoActualImss.compareTo(montoIndicador) < 0) && (saldoActualInfonavit.compareTo(montoIndicador) < 0)){
			indicadorSaldos = ServiciosConstants.SIN_INDICADOR_SALDO;
		} else {
			indicadorSaldos = ServiciosConstants.CON_INDICADOR_SALDO;
		}
		return indicadorSaldos;
	}
	
	/**
	 * Obtener Indicador de Saldo para Trabajador SAISSSTE
	 * @return
	 */
	private String obtenerIndicadorSaldosSarissste(BigDecimal saldoActualSar, BigDecimal saldoActualVivienda, BigDecimal montoIndicador) {
		logger.info(
				"Se Obtienen Indicador Saldo Icefas del Trabajador: montoIndicador = {} Saldo SAR = {} Saldo Vivienda = {} ",
				montoIndicador, saldoActualSar, saldoActualVivienda);
		String indicadorSaldos = null;
				
		if( (saldoActualSar.compareTo(montoIndicador) < 0 ) && (saldoActualVivienda.compareTo(montoIndicador) < 0)){
			indicadorSaldos = ServiciosConstants.SIN_INDICADOR_SALDO;
		} else {
			indicadorSaldos = ServiciosConstants.CON_INDICADOR_SALDO;
		}
		
		return indicadorSaldos;	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ConsultarIcefaTrabajadorService#obtenerIcefasTrabajadorSaldoSar92(java.lang.
	 * Long, java.lang.String)
	 */
	@Override
	public List<TrabajadorSaldoSar92> obtenerIcefasTrabajadorSaldoSar92(Long idProcesar, String fechaNacimiento) {
		StringBuilder uri = new StringBuilder(uriServicioTrabajadorSaldoSar92);

		uri.append("idProcesar=").append(idProcesar).append("&");

		if (!StringUtils.isBlank(fechaNacimiento)) {
			uri.append("fechaNacimiento=").append(fechaNacimiento);
		}

		logger.info(uri.toString());

		ResponseEntity<List<TrabajadorSaldoSar92>> response = restTemplate.exchange(uri.toString(), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<TrabajadorSaldoSar92>>() {
				});

		return isEmpty(response.getBody()) ? null : response.getBody();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ConsultarIcefaTrabajadorService#obtenerIcefasTrabajadorSaldoSarIssste(java.
	 * lang.Long, java.lang.String)
	 */
	@Override
	public List<TrabajadorSaldoSarIssste> obtenerIcefasTrabajadorSaldoSarIssste(Long idProcesar, String fechaNacimiento) {
		StringBuilder uri = new StringBuilder(uriServicioTrabajadorSaldoSarissste);

		uri.append("idProcesar=").append(idProcesar).append("&");

		if (!StringUtils.isBlank(fechaNacimiento)) {
			uri.append("fechaNacimiento=").append(fechaNacimiento);
		}

		logger.info(uri.toString());

		ResponseEntity<List<TrabajadorSaldoSarIssste>> response = restTemplate.exchange(uri.toString(), HttpMethod.GET,
				null, new ParameterizedTypeReference<List<TrabajadorSaldoSarIssste>>() {
				});

		return isEmpty(response.getBody()) ? null : response.getBody();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ConsultarIcefaTrabajadorService#obtenerIcefasTrabajadorSaldoSares(java.lang.
	 * Long, java.lang.String)
	 */
	@Override
	public List<DatosIcefaTrabajador> obtenerIcefasTrabajadorSaldoSares(Long idProcesar, String fechaNacimiento) {
		logger.info("Se Obtienen Icefas del Trabajador Saldo Sares: idProcesar = {} fecha= {}", idProcesar, fechaNacimiento );
		List<DatosIcefaTrabajador> listaIcefas = new ArrayList<>();
		
		List<Parametro> listaParametros = servicioCatalogo.obtenerParametro(ServiciosConstants.PARAMETRO_INDICADOR_SALDO_ICEFA, null);
		
		Parametro parametro = listaParametros.get(NumerosConstants.INT_CERO);
		
		BigDecimal montoIndicadorSaldo = new BigDecimal(parametro.getChValorParametro());
		
		List<TrabajadorSaldoSar92> icefatrabajadorSaldoSar92 = obtenerIcefasTrabajadorSaldoSar92(idProcesar, fechaNacimiento);
		
		List<TrabajadorSaldoSarIssste> icefatrabajadorSaldoSarIssste = obtenerIcefasTrabajadorSaldoSarIssste(idProcesar, fechaNacimiento);
		
		 if(!utileriaValidador.validarListaVacia(icefatrabajadorSaldoSar92)) {
	        	for(TrabajadorSaldoSar92 trabajadorSar92 : icefatrabajadorSaldoSar92) {
	        		if (!trabajadorSar92.getIcefa().startsWith(NumerosConstants.C_CINCO)) {
	        			DatosIcefaTrabajador icefaTrabajador = new DatosIcefaTrabajador();
						icefaTrabajador.setNombreTrabajador(trabajadorSar92.getNombreTrabajador());
						icefaTrabajador.setFechaNacimiento(trabajadorSar92.getFechaNacimiento());
						icefaTrabajador.setRfc(trabajadorSar92.getRfc());
						icefaTrabajador.setNss(trabajadorSar92.getNss());
						icefaTrabajador.setCurp(trabajadorSar92.getCurp());
						icefaTrabajador.setIcefa(trabajadorSar92.getIcefa());
						icefaTrabajador.setControlInterno(trabajadorSar92.getControlInterno());
						icefaTrabajador.setNombreBanco(trabajadorSar92.getDescripcionIcefa());
						icefaTrabajador.setNombrePatron(trabajadorSar92.getNombrePatron());
						icefaTrabajador.setRfcPatron(trabajadorSar92.getRfcPatronal());
						icefaTrabajador.setSituacionLegal(trabajadorSar92.getClaveCriterioSar92());
						icefaTrabajador.setIndicadorSaldo(obtenerIndicadorSaldosSar92(trabajadorSar92.getSaldoActualImss(), trabajadorSar92.getSaldoActualInfonavit(), montoIndicadorSaldo));
						listaIcefas.add(icefaTrabajador);
	        		}
	        	}
	        }
			
	        if(!utileriaValidador.validarListaVacia(icefatrabajadorSaldoSarIssste)) {
	        	for(TrabajadorSaldoSarIssste trabajadorSarissste : icefatrabajadorSaldoSarIssste) {
	        		if (!trabajadorSarissste.getEntidadOrigen().startsWith(NumerosConstants.C_CINCO)) {
	        			DatosIcefaTrabajador icefaTrabajador = new DatosIcefaTrabajador();
	        			icefaTrabajador.setNombre(trabajadorSarissste.getNombre());
	        			icefaTrabajador.setApellidoPaterno(trabajadorSarissste.getPrimerApellido());
	        			icefaTrabajador.setApellidoMaterno(trabajadorSarissste.getSegundoApellido());
						icefaTrabajador.setNombreTrabajador(trabajadorSarissste.getNombreIcefa());
						icefaTrabajador.setFechaNacimiento(fechaUtils.convertirFechaACadena(trabajadorSarissste.getFechaNacimiento(), FORMATO_SERVICIO));
						icefaTrabajador.setRfc(trabajadorSarissste.getRfc());
						icefaTrabajador.setNss(trabajadorSarissste.getNss());
						icefaTrabajador.setCurp(trabajadorSarissste.getCurp());
						icefaTrabajador.setIcefa(trabajadorSarissste.getEntidadOrigen());
						icefaTrabajador.setControlInterno(trabajadorSarissste.getControlInterno());
						icefaTrabajador.setNombreBanco(trabajadorSarissste.getDescripcionIcefa());
						icefaTrabajador.setNombrePatron(trabajadorSarissste.getNombrePatron());
						icefaTrabajador.setRfcPatron(trabajadorSarissste.getRfcPatronal());
						icefaTrabajador.setSituacionLegal(trabajadorSarissste.getCriterio());
						icefaTrabajador.setIndicadorSaldo(obtenerIndicadorSaldosSarissste(trabajadorSarissste.getSaldoActualSar(), trabajadorSarissste.getSaldoActualVivienda(), montoIndicadorSaldo));
						listaIcefas.add(icefaTrabajador);
	        		}
	        	}
	        }
		
		return listaIcefas;
	}

}
