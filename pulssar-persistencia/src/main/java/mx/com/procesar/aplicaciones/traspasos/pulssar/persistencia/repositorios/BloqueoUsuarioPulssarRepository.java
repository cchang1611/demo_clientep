package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.BloqueoUsuarioPulssar;

/**
 * Repositorio para tabla de bloqueo usuario 
 * @author JMGUTIER
 *
 */
public interface BloqueoUsuarioPulssarRepository extends JpaRepository<BloqueoUsuarioPulssar, Long>{

	/**
	 * Consulta para buscar registros por identifiacador de usuario 
	 * @param identificador
	 * @return
	 */
	List<BloqueoUsuarioPulssar> findByIdentificadorUsuarioOrderByIdentificadorBloqueoDesc(Long identificador);
}
