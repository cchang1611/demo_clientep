package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;

/**
 * Repositorio para el manejo de la relacion de submenus 
 *  @author srubalca
 * @version 1.0
 */
public interface MenuPaginaRepository extends JpaRepository<MenuPagina, Long>{
	
	/**
	 * Consulta para obtener las rutas del los submenus
	 * @param paginaPrincipal
	 * @param cvOrganizacion
	 * @param cvRolPulssar
	 * @return
	 */
	@Query("SELECT menuPagina FROM MenuPagina menuPagina "
			+ " INNER JOIN RolMenu rolMenu ON rolMenu.identificadorMenu = menuPagina.identificadorMenu "
			+ " INNER JOIN RolesCatalogo rol ON rol.identificadorRol = rolMenu.identificadorRol "
			+ " WHERE rol.claveRol = :claveRol AND rol.claveAfore = :claveAfore AND menuPagina.paginaPrincipal = :paginaPrincipal AND rolMenu.activo = 1"
			+ " ORDER BY menuPagina.identificadorMenu ")
	List<MenuPagina> findByClaveRolClaveAfore(@Param("claveRol") String claveRol, @Param("claveAfore") String claveAfore,
			@Param("paginaPrincipal") Long paginaPrincipal);
	
	
	/**
	 * Consulta para obtener las rutas de los submenus
	 * @param paginaPrincipal
	 * @param cvOrganizacion
	 * @param cvRolPulssar
	 * @return
	 */
	@Cacheable(value="cacheBuscarPorIdentificadorRolUrl", key="#root.targetClass+#root.methodName+#p0+#p1")
	@Query("SELECT menuPagina FROM MenuPagina menuPagina "
			+ " INNER JOIN RolMenu rolMenu ON rolMenu.identificadorMenu = menuPagina.identificadorMenu "
			+ " INNER JOIN RolesCatalogo rol ON rol.identificadorRol = rolMenu.identificadorRol "
			//+ " WHERE rolMenu.identificadorRol = :identificadorRol  AND menuPagina.chRutaMenu LIKE CONCAT('%',:url,'%') "
			+ " WHERE rolMenu.identificadorRol = :identificadorRol  AND menuPagina.chRutaMenu = :url "
			+ " ORDER BY menuPagina.identificadorMenu ")
	List<MenuPagina> buscarPorIdentificadorRolUrl(@Param("identificadorRol") Long claveRol, @Param("url") String url);
	
	
	
	/**
	 * Consulta para obtener las rutas de los submenus
	 * @param paginaPrincipal
	 * @param cvOrganizacion
	 * @param cvRolPulssar
	 * @return
	 */
    @Cacheable(value="cacheBuscarPorIdentificadoresRoles", key="#root.targetClass+#root.methodName+#p0")
	@Query("SELECT menuPagina FROM MenuPagina menuPagina WHERE menuPagina.identificadorMenu IN "
			+ " (SELECT menuPagina.identificadorMenu FROM MenuPagina menuPagina  INNER JOIN RolMenu rolMenu ON "
			+ " rolMenu.identificadorMenu = menuPagina.identificadorMenu "
			+ " INNER JOIN RolesCatalogo rol ON rol.identificadorRol = rolMenu.identificadorRol "
			+ " WHERE rolMenu.identificadorRol IN :identificadorRoles ) "
			+ " ORDER BY menuPagina.identificadorMenu ")
	List<MenuPagina> buscarPorIdentificadorRoles(@Param("identificadorRoles") List<Long> identificadorRoles);
    
    /**
     * Consulta url
     * @param url
     * @return
     */
    @Cacheable(value="cacheBuscarUrl", key="#root.targetClass+#root.methodName+#p0+#p1")
	@Query("SELECT menuPagina FROM MenuPagina menuPagina "
			+ " WHERE menuPagina.chRutaMenu = :url")
    MenuPagina buscarUrl(@Param("url") String url);
    
    
    
	/**
	 * Consulta para obtener las rutas de los submenus
	 * @param paginaPrincipal
	 * @param cvOrganizacion
	 * @param cvRolPulssar
	 * @return
	 */
    //@Cacheable(value="cacheBuscarPorIdentificadoresRoles", key="#root.targetClass+#root.methodName+#p0")
	@Query("SELECT menuPagina FROM MenuPagina menuPagina WHERE menuPagina.identificadorMenu IN "
			+ " (SELECT menuPagina.identificadorMenu FROM MenuPagina menuPagina  INNER JOIN RolMenu rolMenu ON "
			+ " rolMenu.identificadorMenu = menuPagina.identificadorMenu "
			+ " INNER JOIN RolesCatalogo rol ON rol.identificadorRol = rolMenu.identificadorRol "
			+ " WHERE rolMenu.identificadorRol IN :identificadorRoles AND rol.claveAfore = :claveAfore ) "
			+ " ORDER BY menuPagina.identificadorMenu ")
	List<MenuPagina> buscarPorIdentificadorRolesLista(@Param("identificadorRoles") List<Long> identificadorRoles, @Param("claveAfore") String claveAfore);
    
    
    /**
     * Todas las urls
     * @param identificadorRoles
     * @param claveAfore
     * @return
     */
    List<MenuPagina> findAll();


    /**
	 * Consulta para obtener las rutas del menus de la afore 552
	 * @param paginaPrincipal
	 * @param cvOrganizacion
	 * @param cvRolPulssar
	 * @return
	 */
	@Query("SELECT DISTINCT menuPagina FROM MenuPagina menuPagina "
			+ " INNER JOIN RolMenu rolMenu ON rolMenu.identificadorMenu = menuPagina.identificadorMenu "
			+ " INNER JOIN RolesCatalogo rol ON rol.identificadorRol = rolMenu.identificadorRol "
			+ " WHERE rol.claveAfore = :claveAfore AND rolMenu.activo = 1"
			+ " ORDER BY menuPagina.identificadorMenu ")
	List<MenuPagina> findByClaveAfore(@Param("claveAfore") String claveAfore);
	
    /**
	 * Consulta para obtener las rutas del los submenus por rol
	 * @param paginaPrincipal
	 * @param cvOrganizacion
	 * @param cvRolPulssar
	 * @return
	 */
	@Query("SELECT menuPagina FROM MenuPagina menuPagina "
			+ " INNER JOIN RolMenu rolMenu ON rolMenu.identificadorMenu = menuPagina.identificadorMenu "
			+ " INNER JOIN RolesCatalogo rol ON rol.identificadorRol = rolMenu.identificadorRol "
			+ " WHERE rol.claveRol = :claveRol AND rol.claveAfore = :claveAfore AND rolMenu.activo = 1"
			+ " ORDER BY menuPagina.identificadorMenu ")
	List<MenuPagina> findByClaveRolClaveAfore(@Param("claveRol") String claveRol, @Param("claveAfore") String claveAfore);
	
	/**
	 * Consulta de idmenu
	 * 
	 * @param idMenu
	 * @return
	 */
	@Query("SELECT menuPagina FROM MenuPagina menuPagina "
			+ " WHERE menuPagina.identificadorMenu IN :idMenu "
			+ " ORDER BY menuPagina.identificadorMenu ASC")
	List<MenuPagina> findByIdentficadorMenu(@Param("idMenu") List<Long> idMenu);
}
