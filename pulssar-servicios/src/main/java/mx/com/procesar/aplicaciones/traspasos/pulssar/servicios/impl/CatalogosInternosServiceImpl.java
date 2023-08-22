package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Oficina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Zona;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.AforeZonaOficinaRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogosInternosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Clase para la consulta de catalogos internos del proyecto
 *  
 * @author dbarbosa
 * @version 1.0
 */
@Service
public class CatalogosInternosServiceImpl implements CatalogosInternosService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CatalogosInternosServiceImpl.class);
	
	/**
	 * Repositorio afore zona
	 */
	@Autowired
	private AforeZonaOficinaRepository repositorioAforeZona;
	
	/**
	 * Utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Utileria cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Combo> obtenerZonas(String afore) {
		logger.info("Se realiza la busqueda de zonas de la afore {}", afore);
		List<Combo> zonas = null;
		try {
			if(!utileriaValidador.validarVacio(afore)) {
				List<String> aforeOficina = repositorioAforeZona.findByZonasPorAfore(afore, Arrays.asList(NumerosConstants.INT_UNO));
				if(!utileriaValidador.validarListaVacia(aforeOficina)) {
					Combo registroCombo;
					zonas = new ArrayList<>();
					for(String zona : aforeOficina) {
						registroCombo = new Combo();
						Integer numZona = Integer.parseInt(zona);
						registroCombo.setClave(zona);
						registroCombo.setDescripcion(utileriaCadena.obtenerCadenaConcatenada(false, ServiciosConstants.ZONA, ExpresionesConstants.ESPACIO, String.valueOf(numZona)));
						zonas.add(registroCombo);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en obtener zonas", e);
		}
		return zonas;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Combo> obtenerDescripcionesZonas(String afore, String claveZona) {
		logger.info("Se realiza la busqueda de las descripciones de la zona elegida {} y la afore {}", claveZona, afore);
		List<Combo> descZonas = null;
		try {
			if(!utileriaValidador.validarVacio(afore) && !utileriaValidador.validarVacio(claveZona)) {
				List<Zona> aforeOficina = repositorioAforeZona.findByDescripcionZona(afore, claveZona, Arrays.asList(NumerosConstants.INT_UNO));
				if(!utileriaValidador.validarListaVacia(aforeOficina)) {
					descZonas = new ArrayList<>();
					Combo registroCombo;
					for(Zona zona : aforeOficina) {
						registroCombo = new Combo();
						registroCombo.setClave(String.valueOf(zona.getIdZona()));
						registroCombo.setDescripcion(zona.getDescripcion());
						descZonas.add(registroCombo);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en obtener descripcion de zonas", e);
		}
		return descZonas;
	}

	@Override
	public List<Combo> obtenerOficinas(String afore, Long zona) {
		logger.info("Se realiza la busqueda de las oficinas, id_descripcionzona {} y la afore {}", zona, afore);
		List<Combo> oficinas = null;
		try {
			if(!utileriaValidador.validarVacio(afore) && !utileriaValidador.validarObjetoNulo(zona)) {
				List<Oficina> aforeOficina = repositorioAforeZona.findByOficinasPorAforeyZona(afore, zona, Arrays.asList(NumerosConstants.INT_UNO));
				if(!utileriaValidador.validarListaVacia(aforeOficina)) {
					oficinas = new ArrayList<>();
					Combo registroCombo;
					for(Oficina office : aforeOficina) {
						registroCombo = new Combo();
						registroCombo.setClave(office.getClave());
						registroCombo.setDescripcion(office.getDescripcion());
						oficinas.add(registroCombo);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Se presenta un error no controlado en obtener oficinas", e);
		}
		return oficinas;
	}
	
	/**
	 * Obtener combo sucursal 
	 * @param claveAfore
	 * @return
	 */
	@Override
	public List<Combo> obtenerZonasOficina(String claveAfore, String claveZona, Integer flujo) {
		List<Combo> listaCombo;
		if(flujo.compareTo(NumerosConstants.INT_CERO) == NumerosConstants.INT_CERO) {
			listaCombo = this.obtenerZonas(claveAfore);
		} else if(flujo.compareTo(NumerosConstants.INT_UNO) == NumerosConstants.INT_CERO) {
			listaCombo = this.obtenerDescripcionesZonas(claveAfore, claveZona);
		} else {
			listaCombo = this.obtenerOficinas(claveAfore, Long.parseLong(claveZona));
		}
		return listaCombo;
	}
}