/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipFoliadoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Genera el Folio ligado a la solicitud de generación de NIP
 * @author MALOPEZT
 * @since 2022/02/08
 */
@Service("nipFoliadoService")
public class NipFoliadoServiceImpl implements NipFoliadoService {

	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(NipFoliadoServiceImpl.class);
			
	/**
	 * dependencia cadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * servicio folio
	 */
	@Autowired
	private FolioService servicioFolio;
	
	/** Constante de cierrer de folio, con éxito. */
	private static final int CONSTANTE_CIERRE_FOLIO = 3;
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NipFoliadoService#generarFolio(java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public FolioEntrada generarFolio(String tiempoLlegada, Long idUser,
			String curp, String nss, String sucursal) {

		logger.info("[generarFolio] - Se solicita Folio - Para Generación de Nip");
		FolioEntrada entrada = new FolioEntrada();
		entrada.setIdUsuario(idUser);
		
		//TODO: Solicitar y agregar en código los valores para: FOLIO_OPERACION_CONSULTA y FOLIO_SERVICIO_CONSULTA
		
		entrada.setOperacion(ServiciosConstants.FOLIO_OPERACION_CONSULTA);
		entrada.setServicio(ServiciosConstants.FOLIO_SERVICIO_CONSULTA);
		entrada.setCurp(utileriaCadena.obtenerContenidoCadenaSinEspacios(curp, null));
		entrada.setNss(utileriaCadena.obtenerContenidoCadenaSinEspacios(nss, null));
		entrada.setSucursal(sucursal);
		entrada.setTiempoLlegada(tiempoLlegada);
		
		// TODO: Validar que no tiene un folio sin cerrar la cuenta
//		FolioActivo folioActivo = servicioFolio.consultaFolioActivo(cveServicio, curp, nss, cveProceso);
		
		logger.info("[generarFolio] - Se solicita generación de folio nuevo...");
		FolioEntrada respuesta = servicioFolio.generarFolio(entrada);
		
		// Nota. malopezt. 2022/02/08
		// Se mantien código legado ->  Clase: ConsultarPersonaCertificableServiceImpl/generarFolio
		// Al momento del desarrollo, por tiempo no se profundiza en código preexistente del Servicio de Folio
		// que obliga a Solicitar cerrado y crear neuvamente el Folio.
		if(ServiciosConstants.RESULTADO_NOK.equals(respuesta.getResultado())) {
			logger.warn("[generarFolio] - Folio abierto previamente: {}", respuesta);
			logger.warn("[generarFolio] - Se cierra folio previo: {}, y se abre nuevo", respuesta);
			servicioFolio.cerrarFolio(respuesta.getIdFolio(), null);
			logger.info("[generarFolio] - Se solicita generación de folio nuevo, por Folio prexistente abierto...");
			respuesta = servicioFolio.generarFolio(entrada);
		}
		
		logger.info("[generarFolio] - Se solicita Folio: {} - Para Generación de Nip", respuesta.getFolio());
		return respuesta;
	}

	
	/**
	 * Folio a cerrar
	 * @param folioPorCerrar
	 */
	public void cerrarFolio(FolioEntrada folioPorCerrar){
		servicioFolio.cerrarFolio(folioPorCerrar.getIdFolio(), CONSTANTE_CIERRE_FOLIO);
	}
}
