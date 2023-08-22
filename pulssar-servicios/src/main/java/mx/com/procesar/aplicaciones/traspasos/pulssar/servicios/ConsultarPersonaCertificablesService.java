package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PersonaSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Renapo;

/**
 * Intezfaz de prueba para datos certificados del trabajador 
 * @author JMGUTIER
 *
 */
public interface ConsultarPersonaCertificablesService {
	
	/**
	 * Realiza la consulta principal de persona
	 * 
	 * @param nss
	 * @param curp
	 * @return
	 */
	DatosTrabajador consultarPersona(EntradaConsulta datosEntrada, Long idUser, String curpAgente, String sucursal);
	
	/**
	 * Metodo encargado de cerrar el Folio del trabajador
	 * @param idFolio
	 * @return
	 */
	void cerrarFolio(FolioEntrada folio);
	
	/**
	 * Valida expediente por tipo de solicitante
	 * @param curp
	 * @param cveAfore
	 * @param tipoSolicitante
	 * @return DatosExpediente
	 */
	DatosExpediente validarExpedienteTipoSolicitante(String curp, String cveAfore, String tipoSolicitante, String curpAgente);

	/**
	 * Servicio que valida y obtiene los datos del trabajador para el servicio de filas
	 * @Author: Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Oct 21, 2019
	 * @param datosEntrada
	 * @return
	 */
	List<PersonaSalida> validarDatosTrabajador(EntradaConsulta datosEntrada);
	
	/**
	 * Metodo encargado de obtener los Datos adicionales del trabajador
	 * 
	 * @param auxiliarTrabajador
	 * @return
	 */
	DatosTrabajador obtenerDatosAdicionales(DatosTrabajador auxiliarTrabajador, boolean aforesDistintas);
	
	/**
	 * Metodo encarga de obtener datos de renapo
	 * @param curp
	 * @return
	 */
	Renapo obtenerDatosRenapo(DatosTrabajador trabajador);
	
	/**
	 * Metodo encargado de obtener la consulta de expediente
	 * 
	 * @param curp
	 * @param afore
	 * @param statusExpActual
	 * @param statusBiomActual
	 * @return
	 */
	DatosExpediente validarExpediente(String curp, String afore, String statusExpActual, String statusBiomActual, String curpAgente);

	/**
	 * Metodo encargado de consultar parametros para afores que pueden realizar modificacion de datos
	 * @return
	 */
	String obtenerParametroAforesModificacion();
	
	/**
	 * Metodo encargado de validar el enrolamiento y curp del trabajador
	 * 
	 * @param curp
	 * @return
	 */
	boolean validarExpedienteEnrolamiento(String curp);
}