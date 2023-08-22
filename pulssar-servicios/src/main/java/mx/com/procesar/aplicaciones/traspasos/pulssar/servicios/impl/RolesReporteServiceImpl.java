package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.RolesReporteRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolesReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;

/**
 * Implementacion de consulta de Roles
 * @author EMARTINEZ
 */
@Service
public class RolesReporteServiceImpl implements RolesReporteService {

	/**
	 * Inyeccion de repositorio procesoRepository
	 */
	@Autowired
	private RolesReporteRepository rolesReporteRepository;

	/**
	 * Metodo para obtener los modulos por idRol
	 */
	@Override
	public List<RolReporte> obtenerIdModuloReporte(String idRoles) {
		return rolesReporteRepository.encontrarModulosPorIdRol(idRoles, ServiciosConstants.CONST_CATALOGO_ACTIVO);
	}
}