package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CorreoCorporativo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.CorreoCorporativoPK;

/**
 * Repositorio para el manejo de correo corporativo
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface CorreoCorporativoRepository extends JpaRepository<CorreoCorporativo, CorreoCorporativoPK> {
	
	/**
	 * Metodo encargado de validar el correo corporativo ingresado 
	 * 
	 * @return
	 */
	List<CorreoCorporativo> findByClaveOrganizacionAndEmailAndEstatus(String organizacion, String email, Integer status);
	
	/**
	 * Metodo encargado de buscar correo corporativo por organizacion
	 * @param organizacion
	 * @return
	 */
	List<CorreoCorporativo> findByClaveOrganizacion(String organizacion);
	/**
	 * Metodo encargado de verificar existencia de correo
	 * @param organizacion
	 * @param email
	 * @return
	 */
	List<CorreoCorporativo> findByClaveOrganizacionAndEmail(String organizacion, String email);
}