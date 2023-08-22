package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaExpedienteDetalle;

/**
 * Interfaz para el expediente 
 * @author ANOSORIO
 *
 */
public interface EstatusExpedienteService {

		/**
	 * Metodo encargado de consultar expediente por tipo proceso
	 * @param curp
	 * @param cvAfore
	 * @param cveProceso
	 * @param status
	 */
	public ExpedienteDetail consultarExpedienteProceso(String curp,String cveAfore,String cveProceso,String estatus);
	
	/**
	 * Metodo encargado de consultar estatus de expediente de servicio
	 * @param folio
	 * @param clave
	 * @param rOperacion
	 * @return
	 */
	public ArchivoRecibido consultarEstatusExpediente(String folio,String clave,String rOperacion);
	
	
	/**
	 * Metodo encargado de validar proceso de expediente
	 * @param curp
	 * @param cveProceso
	 * @param estatus
	 * @return
	 */
	public ExpedienteDetail consultarExpedienteProcesoSinAfore(String curp, String cveProceso,String estatus);
	
	/**
	 * Metodo encargado de validar expedientes sin importar afore y solicitante
	 * @param curp
	 * @return
	 */
	public ExpedienteSalida validarRestExpedientes(String curp);
	
	/**
	 * Metodo encargado de consultar expediente por tipo solicitante
	 * @param curp
	 * @param tiposolicitante
	 * @return
	 */
	public ExpedienteSalida validarRestExpedienteTipoSolicitante(String curp, String tiposolicitante);

	/**
	 * Metodo encargado de consultar expediente solicitud
	 * @param cvTipoProceso
	 * @param cvServicio
	 * @param cvAfore
	 * @param curpTrabajador
	 * @param cvEstatusExpe
	 * @return
	 */
	public ExpedienteDetail consultaExpedienteSolicitud(String cvTipoProceso, String cvServicio, String cvAfore,
			String curpTrabajador, String cvEstatusExpe);

	/**
	 * Metodo encargado de consultar servicio respuesta detalle expediente
	 * @param idArchivoRecibido
	 * @author JMGUTIEG
	 * @return
	 */
	List<RespuestaExpedienteDetalle> buscarExpendienteServ(Long idArchivoRecibido);

	/**
	 * Metodo encargado de buscar expediente por parametros
	 * @param curp
	 * @param chFolio
	 * @param chAfore
	 * @param nuEstatus
	 * @param cvTipoProceso
	 * @author JMGUTIEG
	 * @return
	 */
	List<ExpedienteDetail> buscarExpediente(String curp, String chFolio, String chAfore, String nuEstatus,
			String cvTipoProceso);
}
