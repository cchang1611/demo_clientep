package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Organizacion;

/**
 * Repositorio para el manejo de la informacion de organizacion
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface OrganizacionRepository extends JpaRepository<Organizacion, String> {
	
}