package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RechazoUsuarioPulssar;

/**
 * Repositorio para el manejo de los rechazos
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface RechazoUsuarioPulssarRepository extends JpaRepository<RechazoUsuarioPulssar, Long> {
	
}