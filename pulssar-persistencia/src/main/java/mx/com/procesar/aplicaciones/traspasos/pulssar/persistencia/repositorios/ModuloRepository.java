package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ModuloNegocio;

/**
 * Repositorio de catalogo de Modulo de Negocio
 * 
 * @author hjramire
 * @version 1.0
 * @since 20/12/2019, 12:19:15
 */
public interface ModuloRepository extends JpaRepository<ModuloNegocio, Long> {

    /**
     * Metodo que recupera lista de modulos a partir de lista de ID's
     * 
     * @author hjramire
     * @param ids
     * @return List<ModuloNegocio>
     * @since 03/01/2020, 09:22:27
     */
    @Query("SELECT m FROM ModuloNegocio m WHERE m.idModulo IN :ids ")
    List<ModuloNegocio> findByModulosIds(@Param("ids") List<Long> ids);

    /**
     * Metodo que recuper el total de modulos
     * @author hjramire
     * @return List<ModuloNegocio>
     * @since 12/02/2020, 18:20:01
     */
    @Query("SELECT m FROM ModuloNegocio m")
    List<ModuloNegocio> recuperarTotalModulos();

}
