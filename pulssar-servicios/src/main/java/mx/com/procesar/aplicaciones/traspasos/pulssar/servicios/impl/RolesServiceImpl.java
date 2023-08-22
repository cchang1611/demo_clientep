package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.RolesCatalogoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RolesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Implementacion de consulta de Roles
 * 
 * @author JMGUTIER
 */
@Service
public class RolesServiceImpl implements RolesService {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(RolesServiceImpl.class);
	
	/**
	 * Inteccion de repositorio Roles
	 */
	@Autowired
	private RolesCatalogoRepository repositorioRoles;
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RolesCatalogo> consultarRoles() {
		logger.info("Obtiene los roles del trabajador");
		List<RolesCatalogo> rolesConsulta = repositorioRoles.findAll();
		if(utileriaValidador.validarListaVacia(rolesConsulta)){
			rolesConsulta = null;
		}
		
		return rolesConsulta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RolesCatalogo> buscarRoles(List<String> roles) {
		logger.info("Obtiene los roles de una lista");
		List<RolesCatalogo> rolesConsulta = repositorioRoles.findRolByRoles(roles);
		if(utileriaValidador.validarListaVacia(rolesConsulta)){
			rolesConsulta = null;
		}		
		return rolesConsulta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RolesCatalogo> buscarRolesPorAfore(List<String> roles, String claveAfore) {
		logger.info("Obtiene los roles de una lista");
		List<RolesCatalogo> rolesConsulta = repositorioRoles.findRolByRolesClaveAfore(roles, claveAfore);
		if(utileriaValidador.validarListaVacia(rolesConsulta)){
			rolesConsulta = null;
		}		
		return rolesConsulta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RolesCatalogo> buscarRolPorAfore(String claveAfore) {
		logger.info("Obtiene los roles del trabajador por afore: {}", claveAfore);
		return repositorioRoles.findRolByAfore(claveAfore);
	}

	@Override
	public RolesCatalogo buscarRolPorRolClaveAfore(String claveRol, String claveAfore) {
		logger.info("BuscarRolCatalogo: claveRol: {} claveAfore: {}", claveRol, claveAfore );
		RolesCatalogo rolesConsulta = repositorioRoles.findRolByClaveRolAfore(claveRol, claveAfore);
		if(utileriaValidador.validarObjetoNulo(rolesConsulta)){
			rolesConsulta = repositorioRoles.findRolByClaveRolAfore(claveRol, RolesConstants.CLAVE_PROCESAR);
		}		
		return rolesConsulta;
	}
	
	@Override
	public Rol obtenerRolPorRolClaveAfore(String claveRol, String claveAfore) {
		logger.info("BuscarRol. Obtiene el objeto Rol");
		Rol respuesta = null;
		RolesCatalogo rolesConsulta = buscarRolPorRolClaveAfore(claveRol, claveAfore);
		if(!utileriaValidador.validarObjetoNulo(rolesConsulta)){
			respuesta= new Rol();
			respuesta.setIdRol(rolesConsulta.getIdentificadorRol());
			respuesta.setClaveRol(rolesConsulta.getClaveRol());			
			respuesta.setDescripcionRol(rolesConsulta.getDescripcionRol());
			respuesta.setClaveAfore(rolesConsulta.getClaveAfore());
		}
		return respuesta;
	}
}