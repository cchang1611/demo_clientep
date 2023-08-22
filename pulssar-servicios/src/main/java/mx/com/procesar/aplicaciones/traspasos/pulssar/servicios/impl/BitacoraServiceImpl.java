package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.BitacoraReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteBitacora;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.BitacoraRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BitacoraService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;

/**
 * Implementacion de servicios de operaciones sobre repositorio Bitacora de
 * Reportes
 * 
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 26/08/2020
 */
@Service
public class BitacoraServiceImpl implements BitacoraService {

	/**
	 * Log de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(BitacoraServiceImpl.class);

	/**
	 * Instancia de rpositorio de Bitacora de Reporte
	 */
	@Autowired
	private BitacoraRepository bitacoraRepository;

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * BitacoraReporteService# validaLimiteDeConsultasPorUsuario(java.lang.Long,
	 * java.lang.String)
	 */
	@Override
	public int consultarNumPorUsuarioEnDia(Long idReporte, String usuario) throws PlataformaServiciosOperativaServiceException {
		logger.info("Inicia consultarNumPorUsuarioEnDia({}, {} )", idReporte, usuario);
		return bitacoraRepository.contadorEjecucionReportePorUsuario(idReporte, usuario);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * BitacoraReporteService# registraBitacora(java.lang.Long, java.lang.String,
	 * java.lang.String, java.util.Map)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public BitacoraReporte registrarBitacora(Long idReporte, String usuario, String ipOrigen,
			Map<String, String> params){
		logger.info("Inicia registrarBitacora({}, {}, {}, {} )", idReporte, usuario, ipOrigen, params);
		Date fechaActual = new Date();
		BitacoraReporte bitacora = new BitacoraReporte();
		bitacora.setIdReporteGenerico(idReporte);
		bitacora.setUsuario(usuario);
		bitacora.setFechaEjecucion(fechaActual);
		bitacora.setParametros(recuperaParametros(params));
		bitacora.setReporteExportado(0);
		bitacora.setFcControl(fechaActual);
		bitacora.setUsuarioModificador("PLATAFORMA_OPERATIVA");
		bitacora.setIpOrigen(ipOrigen);
		return bitacoraRepository.saveAndFlush(bitacora);
	}

	/**
     * Metodo que convierte la lista de parametros en una cadena
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param params
     * @return Cadena con el listado de parametros separados por el caracter -
     */
	private String recuperaParametros(Map<String, String> params) {
		StringBuilder paramsResult = new StringBuilder();
		Set<String> llavesMap = params.keySet();
		for (String keyMap : llavesMap) {
			paramsResult.append(" | [");
			paramsResult.append(keyMap);
			paramsResult.append("- ");
			paramsResult.append(params.get(keyMap).isEmpty() ? "N/A" : params.get(keyMap));
			paramsResult.append("] ");
		}
		int maxLength = 4000 < paramsResult.length() ? 3999 : paramsResult.length();
		return paramsResult.toString().substring(0, maxLength);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * BitacoraReporteService#
	 * actualizabanderaExportacion(mx.com.procesar.aplicaciones.traspasos.pulssar.
	 * persistencia. entidades.BitacoraReporte, int)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizarBanderaExportacion(BitacoraReporte bitacora, int nuevoEstado)
		{
		logger.info("Inicia actualizarBanderaExportacion({}, {} )", bitacora, nuevoEstado);
		bitacora.setReporteExportado(nuevoEstado);
		bitacoraRepository.saveAndFlush(bitacora);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * BitacoraReporteService# consultaPorRangoFechas(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<ReporteBitacora> consultarPorRangoFechas(String fechaInicial, String fechaFinal)
			throws PlataformaServiciosOperativaServiceException {
		logger.info("Inicia consultarPorRangoFechas({}, {} )", fechaInicial, fechaFinal);
		return bitacoraRepository.consultarPorRangoFechas(fechaInicial, fechaFinal);
	}


	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * BitacoraReporteService# consultaPorUsuario(java.lang.String)
	 */
	@Override
	public List<ReporteBitacora> consultarPorUsuario(String usuario) throws PlataformaServiciosOperativaServiceException {
		logger.info("Inicia consultarPorUsuario({}) )", usuario);
		return bitacoraRepository.consultarPorUsuario(usuario);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * BitacoraReporteService# consultaPorIpUsuario(java.lang.String)
	 */
	@Override
	public List<ReporteBitacora> consultarPorIpUsuario(String ipUsuario) throws PlataformaServiciosOperativaServiceException {
		logger.info("Inicia consultarPorIpUsuario({}) )", ipUsuario);
		return bitacoraRepository.consultarPorIpUsuario(ipUsuario);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * BitacoraReporteService# actualizarBanderaExportacion(java.lang.Long, int)
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizarBanderaExportacion(Long idBitacora, int nuevoEstado) {
		logger.info("Inicia actualizarBanderaExportacion({}, {}) )", idBitacora, nuevoEstado);
		BitacoraReporte bitacora = bitacoraRepository.getOne(idBitacora);
		bitacora.setReporteExportado(nuevoEstado);
		bitacoraRepository.saveAndFlush(bitacora);
	}
}