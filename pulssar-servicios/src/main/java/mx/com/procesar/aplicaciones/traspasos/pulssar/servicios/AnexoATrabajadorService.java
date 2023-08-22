package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AnexoATrabajadorIssste;

/**
 * Interfaz para anexo trabajador
 * @author JMGUTIEG
 *
 */
public interface AnexoATrabajadorService {
	
	/**
	 * Metodo encargado de consultar anexo por curp
	 * @param curp
	 * @return
	 */
	List<AnexoATrabajadorIssste> consultaAnexoTrabajador(String curp);

}
