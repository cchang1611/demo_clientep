package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioEncriptadoPulssar;

/**
 * Repositorio para el manejo de usuarios encriptados
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface UsuarioEncriptadoPulssarRepository  extends JpaRepository<UsuarioEncriptadoPulssar, Long> {

}