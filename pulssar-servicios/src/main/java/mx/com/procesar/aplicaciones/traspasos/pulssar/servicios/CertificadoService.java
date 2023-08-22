package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidarSolicitudCertificacionAforeSalida;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Jun 28, 2019
 */
public interface CertificadoService {

	/**
	 * validar Certificado con datos trabajador
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param datosTrabajador
	 * @param user
	 * @param retiroDesempleoImss
	 * @param folio
	 * @return
	 */
	public ValidarSolicitudCertificacionAforeSalida validarCertificado(DatosTrabajador datosTrabajador,
			UsuarioLogin user, RetiroDesempleoImss retiroDesempleoImss, String folio,
			SolicitudDisposicionParcial entradaOp12, EntradaConsulta entradaConsulta);

}
