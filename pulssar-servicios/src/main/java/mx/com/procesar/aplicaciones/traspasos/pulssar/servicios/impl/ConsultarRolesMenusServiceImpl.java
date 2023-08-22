package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.MenuPagina;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.MenuPaginaRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultarRolesMenusService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ConsultarRolesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaRolesMenu;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaRolesMenuLista;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSalidaRolesUrl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * Servicio que consulta los menus dependiendo al rol
 * @author RARREOLA
 *
 */
@Service
public class ConsultarRolesMenusServiceImpl implements ConsultarRolesMenusService{
	
	/**
	 * MenuPaginaRepository
	 */
	@Autowired
	private MenuPaginaRepository menuPaginaRepository;
	
	/**
	 * ValidadorUtils
	 */
	@Autowired
	private ValidadorUtils validadorUtils;

	/**
	 * Consulta los menus por identificador rol y url
	 * @param identificadorRol
	 * @param url
	 * @return
	 */
	@Override
	public DatosSalidaRolesUrl consultarMenusIdentificadorRolUrl(String identificadorRol, String url) {
		DatosSalidaRolesUrl datosSalidaRolesUrl = new DatosSalidaRolesUrl();
		if(StringUtils.isNoneBlank(identificadorRol) && StringUtils.isNoneBlank(url)){
			List<MenuPagina> lista = menuPaginaRepository.buscarPorIdentificadorRolUrl(Long.valueOf(identificadorRol), url);
			boolean valor = validadorUtils.validarListaVacia(lista);
			if(valor){
				datosSalidaRolesUrl.setEstatusRespuesta(false);
				datosSalidaRolesUrl.setDescripcionError(ConsultarRolesConstants.MENSAJE_INFORMACION_NO_ENCONTRADA);
			}else{
				datosSalidaRolesUrl.setEstatusRespuesta(true);
			}
		}else{
			datosSalidaRolesUrl.setEstatusRespuesta(false);
			datosSalidaRolesUrl.setDescripcionError(ConsultarRolesConstants.MENSAJE_DATOS_OBLIGATORIOS);
		}
		
		return datosSalidaRolesUrl;
	}

	/**
	 * Consulta los menus por identificador rol
	 * @param idRol
	 * @return
	 */
	@Override
	public List<MenuPagina> consultarMenusIdentificadoresRoles(DatosEntradaRolesMenu datosEntradaRolesMenu) {
		return menuPaginaRepository.buscarPorIdentificadorRoles(datosEntradaRolesMenu.getIdentificadoresRoles()); 
		
	}

	/**
	 * Consultar url
	 */
	@Override
	public DatosSalidaRolesUrl consultarUrl(String url) {
		DatosSalidaRolesUrl datosSalidaUrl = new DatosSalidaRolesUrl();
		if(StringUtils.isNoneBlank(url)){
			MenuPagina menu = menuPaginaRepository.buscarUrl(url);
			boolean bandera = validadorUtils.validarObjetoNulo(menu);
			if(bandera){
				datosSalidaUrl.setEstatusRespuesta(false);
				datosSalidaUrl.setDescripcionError(ConsultarRolesConstants.MENSAJE_INFORMACION_NO_ENCONTRADA);
			}else{
				datosSalidaUrl.setEstatusRespuesta(true);
			}
		}else{
			datosSalidaUrl.setEstatusRespuesta(false);
			datosSalidaUrl.setDescripcionError(ConsultarRolesConstants.MENSAJE_DATOS_OBLIGATORIOS);
		}
		
		return datosSalidaUrl;
	}

	/**
	 * Consultar menus
	 * @param identificadoresRoles
	 * @return
	 */
	@Override
	public List<MenuPagina> consultarMenusIdentificadoresRolesLista(DatosEntradaRolesMenuLista identificadoresRoles) {
		
		return menuPaginaRepository.buscarPorIdentificadorRolesLista(identificadoresRoles.getIdentificadoresRoles(), identificadoresRoles.getClaveAfore()); 
	}

	/**
	 * MEnus
	 * @return
	 */
	@Override
	public List<MenuPagina> consultarMenusTodasLista() {
		return menuPaginaRepository.findAll();
	}
	

}
