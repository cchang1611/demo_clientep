package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDocumentoPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
/**
 * Interfaz para generar Solicitud Retiro Parcial Matrimonio
 * @author ANOSORIO
 *
 */
public interface SolicitudRetiroParcialMatrimonioService {

	/**
	 * Metodo para generar Solicitud Retiro Parcial Matrimonio
	 * @param entrada
	 * @param datosTrabajador
	 * @param datos
	 * @param user 
	 * @return
	 */
	byte[] generaSolicitudPdf(SolicitarCertificacionMatrimonioEntrada entrada,DatosTrabajador datosTrabajador,DatosDocumentoPdf datos, RetiroDesempleoImss retiroMatrimonioImss, String firmaEmpleado, String firmaAgente, EntradaConsulta consulta, UsuarioLogin user);


}
