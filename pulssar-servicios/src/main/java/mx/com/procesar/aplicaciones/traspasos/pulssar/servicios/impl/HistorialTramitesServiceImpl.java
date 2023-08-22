package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.HistorialTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioProcesoEstatus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@Service
public class HistorialTramitesServiceImpl implements HistorialTramitesService {

	private static final Logger logger = LoggerFactory.getLogger(HistorialTramitesServiceImpl.class);
	
	@Autowired
	private RestTemplate rest;

	@Value("${comunes.folios.padre}")
	private String urlFolioPadre;
	
	@Value("${comunes.folios.hijo}")
	private String urlFolioHijo;

	@Value("${comunes.folios.grupos}")
	private String urlGrupos;
	/**
	 * Inyeccion dependencia ValidadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;	
	
	@Override
	public List<FolioSalida> consultarFoliosPadre(String nss, String curp) {
		StringBuilder sb = new StringBuilder(urlFolioPadre);
		if(!validadorUtils.isEmpty(nss)){
			sb.append("nss=").append(nss).append("&");
		}
		if(!validadorUtils.isEmpty(curp)){
			sb.append("curp=").append(curp);
		}
		
		ArrayList<FolioSalida> filtrados = new ArrayList<>();
		logger.info("FoliosPadre -> {} ", sb);
		try {
			ResponseEntity<List<FolioSalida>> folios =  rest.exchange(sb.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<FolioSalida>>(){});
			if(CollectionUtils.isNotEmpty(folios.getBody())) {
				filtrados = (ArrayList<FolioSalida>) folios.getBody();
				
				
			}
		} catch (Exception e) {
			logger.error("Ocurrio un error al consultar Folio Padre {}", e);
		}
		return filtrados;
	}


	@Override
	public List<FolioSalida> consultarFolioHijo(String idProcesar) {
		String strb = urlFolioHijo;
		strb = StringUtils.replace(strb, "{idFolio}", idProcesar);
		logger.info("urlFolioHijo -> {} ", strb);
		List<FolioSalida> procesos = new ArrayList<>();
		try {
			ResponseEntity<List<FolioSalida>> response =  rest.exchange(strb, HttpMethod.GET, null, new ParameterizedTypeReference<List<FolioSalida>>(){});
			procesos = response.getBody();
		} catch (RestClientException e) {
			logger.error("Ocurrio un error al consultar Folio hijo {}", e);
		} catch (BusinessException e) {
			throw e;
		}
		
		return procesos;
	}


	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.HistorialTramitesService#consultarGruposEstatus(java.lang.String, java.lang.String)
	 */
	@Override
	public List<FolioProcesoEstatus> consultarGruposEstatus(String idFolio, String cveOrganizacion) {
		String strb = urlGrupos;
		strb = StringUtils.replace(strb, "{idFolio}", idFolio).replace("{cveOrganizacion}", cveOrganizacion);
		logger.info("urlGrupos -> {} ", strb);
		List<FolioProcesoEstatus> grupos = new ArrayList<>();
		try {
			ResponseEntity<List<FolioProcesoEstatus>> response =  rest.exchange(strb, HttpMethod.GET, null, new ParameterizedTypeReference<List<FolioProcesoEstatus>>(){});
			grupos = response.getBody();
			
			if(!grupos.isEmpty()){
				for(FolioProcesoEstatus x:grupos) {
					if(x.getStatusProceso() == null) {
						x.setStatusProceso(-1L);
					}
				}
			}
		} catch (RestClientException e) {
			logger.error("Ocurrio un error al consultar grupos {}", e);
		} catch (BusinessException e) {
			throw e;
		}
		
		return grupos;
	}

	
	
	
	
}
