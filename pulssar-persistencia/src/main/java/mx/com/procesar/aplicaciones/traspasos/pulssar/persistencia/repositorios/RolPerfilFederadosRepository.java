/**
 * RolPerfilFederadosRepository.java
 * Fecha de creación: 02/12/2021, 19:43:50
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolPerfilFederados;

/**
 * Interfaz que define los metodos del repositorio de datos ala entidad de Roles por perfil de
 * usuarios federados
 * @author Victorino Hern&aacute;ndez Ruiz (vhernand@procesar.com)
 * @version 1.0
 * @since Diciembre de
 */
public interface RolPerfilFederadosRepository extends JpaRepository<RolPerfilFederados, Long> {

    /**
     * Metodo que obtiene el listado de rooes asignados a un perfil
     * @author Victorino Hern&aacute;ndez Ruiz (vhernand@procesar.com)
     * @param clavePerfil Clave del perfil
     * @return Listado de roles asignados al perfil
     */
    @Query(
        value = "SELECT rpf FROM RolPerfilFederados rpf JOIN rpf.perfilFederados pf WHERE UPPER(pf.descripcionPerfil) = UPPER(:descripcionPerfil) ORDER BY rpf.idRolPerfil",
        nativeQuery = false)
    List<RolPerfilFederados> encontrarRolesPerfil(@Param("descripcionPerfil") String clavePerfil);

}
