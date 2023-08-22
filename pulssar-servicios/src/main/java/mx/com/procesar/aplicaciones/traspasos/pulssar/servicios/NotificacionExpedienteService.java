package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosParticulares;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSalidaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DomicilioLaboral;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Referencias;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaActualizaDatos;

/**
 * Interface para modificacion de datos.
 * 
 * @author jajimene
 * @version 1.0
 */
public interface NotificacionExpedienteService {

	/**
	 * Metodo que envia notificacion 13+
	 * @param salidaActualizaDatos
	 * @param datosTrabajador
	 * @param folio
	 */
	public void envioNotificacionActualiza(SalidaActualizaDatos salidaActualizaDatos, DatosTrabajador datosTrabajador,Folio folio,FlujoModificacion flujoModificacion);
	
	/**
	 * Metodo que envia notificacion permanencia
	 * @param salidaPermanencia
	 * @param entradaPermanencia
	 * @param folio
	 */
	public void envioNotificacionPermanencia(DatosSalidaPermanencia salidaPermanencia, EntradaPermanencia entradaPermanencia,Folio folio,FlujoModificacion flujoModificacion);

	/**
	 * Valida entrada datos particulares permanencia
	 * @param entradaPermanencia
	 * @param caracterHomologado
	 * @return
	 */
	DatosParticulares validaEntradaDatosParticulares(EntradaPermanencia entradaPermanencia, String caracterHomologado);

	/**
	 * Valida domicilio laboral permanencia
	 * @param entradaPermanencia
	 * @param caracterHomologado
	 * @return
	 */
	DomicilioLaboral validaDomicilioLaboralPermanencia(EntradaPermanencia entradaPermanencia,String caracterHomologado);

	/**
	 * valida referencias permanencia
	 * @param entradaPermanencia
	 * @param caracterHomologado
	 * @return
	 */
	Referencias validaReferenciasPermanencia(EntradaPermanencia entradaPermanencia, String caracterHomologado);

	/**
	 * Valida beneficiarios permanencia
	 * @param entradaPermanencia
	 * @param caracterHomologado
	 * @return
	 */
	Beneficiarios validaBeneficiariosPermanencia(EntradaPermanencia entradaPermanencia, String caracterHomologado);

	/**
	 * Metodo encargado de homologar contenido
	 * @param entrada
	 * @param homologado
	 * @return
	 */
	String eliminarAcentos(String entrada, String homologado);
	
}
