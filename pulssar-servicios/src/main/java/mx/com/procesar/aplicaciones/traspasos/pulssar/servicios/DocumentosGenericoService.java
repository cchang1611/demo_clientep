package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpedienteGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Feb 21, 2020
 */
public interface DocumentosGenericoService {

	
	/**
	 *  obtenerDatosExpediente
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param datosPersonales
	 *  @return
	 */
	DatosExpedienteGenerico obtenerDatosExpediente(Object datosPersonales);
	
	/**
	 *  obtenerDatosExpediente
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param datosExpe
	 *  @param datosDomicilio
	 *  @return
	 */
	DatosExpedienteGenerico obtenerDatosExpediente(DatosExpedienteGenerico datosExpe, Object datosDomicilio);
	
	
	/**
	 *  obtenerTipoDocumento
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param claveTipoProceso
	 *  @param afore
	 *  @return
	 */
	List<Combo> obtenerTipoDocumento(String claveTipoProceso, String afore);

	
	/**
	 *  obtenerTipoDocumentoAdicional
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param docAdicional
	 *  @param afore
	 *  @return
	 */
	List<Combo> obtenerTipoDocumentoAdicional(String docAdicional, String afore);

	/**
	 *  verificaSiEsValido
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 */
	boolean verificarSiEsValido(List<Combo> docs, Map<String, MultipartFile> multipart) ;
	/**
	 *  Obtencion de combos para los retiros
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param claveTipoProceso
	 *  @param afore
	 *  @return
	 */
	Map<String, List<Combo>> obtenerComboRetiros(String claveTipoProceso, String afore);

	/**
	 *  obtener Tipo Documento Retiros
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param claveTipoProceso
	 *  @param afore
	 *  @return
	 */
	List<Combo> obtenerTipoDocumentoRetiros(String claveTipoProceso, String afore);

	/**
	 *  obtenerCombo
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param claveTipoProceso
	 *  @param afore
	 * @param adicional 
	 *  @return
	 */
	Map<String, List<Combo>> obtenerCombo(String claveTipoProceso, String afore, String exclusion, String [] adicional);
	
	/**
	 * @param multipart
	 * @return
	 */
	public Map<String, MultipartFile> limpiarYValidarMultipart(Map<String, MultipartFile> multipart);
	
	
	/**
	 * @param folio
	 * @param archivos
	 * @param datosRecepcion
	 * @param comboObligatorios
	 * @param fotografia
	 * @return
	 */
	public RespuestaServicio verificarArchivos(Folio folio, Map<String, MultipartFile> archivos, EnvioArchivos datosRecepcion, List<Combo> comboObligatorios, String fotografia, byte[] pdf);
	
	/**
	 * MEtodo encargado de obtener curp dependiendo proceso
	 * @param cvProcesoFormulario
	 * @param cvTipoSolicitante
	 * @param bandera13
	 * @param banderaPermanencia
	 * @param datosTrabajador
	 * @param entradaModificacion
	 * @param entradaPermanencia
	 * @return
	 */
	String obtenerCurpGenericoRecepcionImagenes(String cvProcesoFormulario, String cvTipoSolicitante, String bandera13,
			String banderaPermanencia, DatosTrabajador datosTrabajador, EntradaModificacion entradaModificacion,
			EntradaPermanencia entradaPermanencia);

	/**
	 * Metodo que recupera folio segun proceso
	 * @param cvProcesoFormulario
	 * @param folioEntrada
	 * @param folioHijo
	 * @return
	 */
	String obtenerFolioHijoGenericoRecepcionImagenes(String cvProcesoFormulario, FolioEntrada folioEntrada,
			Folio folioHijo);

	/**
	 * Metodo que recupera cv de proceso 
	 * @param cvProcesoFormulario
	 * @param cvTipoSolicitante
	 * @return
	 */
	String obtenerCvTipoProcesoGenericoRecepcionImagenes(String cvProcesoFormulario, String cvTipoSolicitante);
}
