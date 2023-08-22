package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoPulssar;

/**
 * Repositorio para el manejo del catalogo de rechazos
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface RechazoPulssarRepository extends JpaRepository<RechazoPulssar, Long> {
	
	/**
	 * Metodo encargado de obtener la descripcion del rechazo
	 * 
	 * @param clave
	 * @param estatus
	 * @return
	 */
	RechazoPulssar findByClaveRechazoAndClaveOrganizacionAndEstatus(String clave, String claveOrganizacion, Integer estatus);
}