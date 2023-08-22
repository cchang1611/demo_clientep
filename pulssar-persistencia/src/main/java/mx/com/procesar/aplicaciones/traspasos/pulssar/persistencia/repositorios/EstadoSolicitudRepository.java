package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.EstadoSolicitud;



/**
 * Repositorio para catalogo de estados de solicitud
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 12:17:21
 */
public interface EstadoSolicitudRepository extends JpaRepository<EstadoSolicitud, Long> {

}
