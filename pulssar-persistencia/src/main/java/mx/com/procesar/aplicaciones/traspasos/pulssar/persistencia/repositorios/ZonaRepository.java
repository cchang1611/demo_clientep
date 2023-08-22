package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Zona;

/**
 * Repositorio para tabla de zona
 * @author dbarbosa
 *
 */
public interface ZonaRepository extends JpaRepository<Zona, Long> {
	
}