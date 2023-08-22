/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BanorteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.BanorteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Servicio de Banorte
 * @author dhernand
 *
 */
@Service
public class BanorteServiceImpl implements BanorteService{
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(BanorteServiceImpl.class);
	/**
	 * Url de la table
	 */
	@Value("#{propiedades['banorte.tablet.url']}")
	private String urlTablet;
	
	/**
	 * Ambiente tablet
	 */
	@Value("#{propiedades['banorte.tablet.ambiente']}")
	private String ambiente;
	
	/** 
	 * Verificar la interface o clase que lo define
	 * @throws UnsupportedEncodingException 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BanorteService#generarUrlPeticionTablet()
	 */
	@Override
	public String generarUrlPeticionTablet(Map<String,String> parametros,UsuarioLogin usuario){
		StringBuilder url = new StringBuilder();
		String urlPropiedad = urlTablet.trim();
		logger.info("propiedad url banorte: {} propiedad trim: {} ",urlTablet,urlPropiedad);
		url.append(urlPropiedad);
		url.append(BanorteConstants.SIGNO_ADMIRACION);
		url.append(agregarParametros(BanorteConstants.FOLIO,parametros.get(BanorteConstants.FOLIO)));
		
		url.append(BanorteConstants.AMPERSAND);
		url.append(agregarParametros(BanorteConstants.MODALIDAD_TRAMITE,parametros.get(BanorteConstants.MODALIDAD_TRAMITE)));

		url.append(BanorteConstants.AMPERSAND);
		url.append(agregarParametros(BanorteConstants.USUARIO,usuario.getUsuario()));
		
		url.append(BanorteConstants.AMPERSAND);
		url.append(agregarParametros(BanorteConstants.AMBIENTE,ambiente));

		url.append(BanorteConstants.AMPERSAND);
		url.append(agregarParametros(BanorteConstants.NSS,parametros.get(BanorteConstants.NSS)));

		url.append(BanorteConstants.AMPERSAND);
		url.append(agregarParametros(BanorteConstants.CURP,parametros.get(BanorteConstants.CURP)));
		
		url.append(BanorteConstants.AMPERSAND);
		url.append(agregarParametros(BanorteConstants.TIPO_PARENTESCO,parametros.get(BanorteConstants.TIPO_PARENTESCO)));
		
		url.append(BanorteConstants.AMPERSAND);
		url.append(agregarParametros(BanorteConstants.TRAMITE_NO_PRESENCIAL,parametros.get(BanorteConstants.TRAMITE_NO_PRESENCIAL)));
		logger.info("url tablet Banorte: {}",url);
		return url.toString();
	}
	
	/**
	 * Agrega los parametro a la url
	 * @param parametro
	 * @param valor
	 * @return
	 */
	private String agregarParametros(String parametro,String valor) {		
		StringBuilder param = new StringBuilder();
		param.append(parametro);
		param.append(BanorteConstants.IGUAL);
		param.append(valor==null?"":valor);
		return param.toString();
	}
	

}
