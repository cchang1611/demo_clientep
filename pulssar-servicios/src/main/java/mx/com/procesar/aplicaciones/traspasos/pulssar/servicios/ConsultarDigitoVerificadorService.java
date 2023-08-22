package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaValidarDigitoVerificador;
/**
 * Clase que consulta y valida digito verificador
 * @author ANOSORIO
 *
 */
public interface ConsultarDigitoVerificadorService {

	/**
	 * Metodo consulta digito verificador
	 * @param cuentaClabe
	 * @return
	 */
	RespuestaValidarDigitoVerificador validarDigitoVerificador(String cuentaClabe);

}
