package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosUsuariosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ModuloReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PlataformasPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RolesModuloAccesoIP;

/**
 * Servicio que consume los metodo de Catalogo Usuario Service
 * @author dbarbosa
 *
 */
@Service
public class CatalogoUsuarioServiceImpl extends BaseServiceImpl implements CatalogoUsuarioService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PlataformasPulssar> obtenerPlataformas() {
		return restServiceClientUtils.ejecutarServicioGetObjetos(uriComunes, ServiciosUsuariosConstants.CATALOGO_PLATAFORMA, PlataformasPulssar.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RolesCatalogo> obtenerRolesAdministracion(String cvRol, String cvAfore, String plataforma, Integer isAdmin) {
		String url = String.format(ServiciosUsuariosConstants.CATALOGO_ROLES_ADMINISTRADOR, cvRol, cvAfore, plataforma, isAdmin);
		return restServiceClientUtils.ejecutarServicioGetObjetos(uriComunes, url, RolesCatalogo.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RolesModuloAccesoIP obtenerRolModuloAcceso(String cvRol, String cvAfore, String plataforma) {
		String url = String.format(ServiciosUsuariosConstants.CATALOGO_ROL_MODULO_ACCESO, cvRol, cvAfore, plataforma);
		return restServiceClientUtils.ejecutarServicioGet(uriComunes, url, RolesModuloAccesoIP.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ModuloReporte> obtenerModuloReportes() {
		logger.info("Se los diferentes modulos para las pantallas SICI");
		List<ModuloReporte> modulos = null;
		try {
			modulos =  restServiceClientUtils.ejecutarServicioGetObjetos(uriComunes, ServiciosUsuariosConstants.CATALOGO_MODULO_REPORTES, ModuloReporte.class);
		} catch (Exception e) {
			logger.error("Se presento un problema en la consulta de modulo de reportes", e);
		}
		return modulos;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RolesCatalogo> obtenerRolesAdministracion(String cvRol, String cvAfore) {
		String url = String.format(ServiciosUsuariosConstants.CATALOGO_ROLES_ADMINISTRADOR_MODIFICACION, cvRol, cvAfore);
		return restServiceClientUtils.ejecutarServicioGetObjetos(uriComunes, url, RolesCatalogo.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RolesModuloAccesoIP obtenerRolModuloAccesoModificacion(String cvRol, String cvAfore) {
		String url = String.format(ServiciosUsuariosConstants.CATALOGO_ROL_MODULO_ACCESO_MODIFICACION, cvRol, cvAfore);
		return restServiceClientUtils.ejecutarServicioGet(uriComunes, url, RolesModuloAccesoIP.class);
	}
}