package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Organizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Servicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.Usuarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.UsuariosModificar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo.UsuarioControlador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Afore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BiomTipoSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentoCompletoRequerido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * interfaz de la utileria de validaciones: valida datos nulos valida datos
 * obligatorios valida la estructura de datos de entrada
 * 
 * @author dbarbosa
 * @version 1.0
 */
public interface ConversionUtils {

	/**
	 * Metodo encargado de recuperar el combo de las afores
	 * 
	 * @param listAfore
	 * @return
	 */
	List<Combo> obtenerComboAfores(List<Afore> listAfore);
	
	/**
	 * Metodo encargado de recuperar el combo de organizaciones
	 * @param listaOrganizacion
	 * @param claveOrganizacion
	 * @return
	 */
	List<Combo> obtenerComboOrganizacion(List<Organizacion> listaOrganizacion , List<String> claveOrganizacion);
	
	/**
	 * Metodo encargado de obtener lso roles de usuario
	 * 
	 * @param listaRoles
	 * @return
	 */
	List<Combo> obtenerRolesUsuario(List<RolesCatalogo> listaRoles);
	
	/**
	 * Metodo para obtener el combo generico
	 * @param listaGenerica
	 * @param nombreClave
	 * @param nombreDescripcion
	 * @return
	 */
	List<Combo> obtenerCatalogoGenerico(List<?> listaGenerica, String nombreClave, String nombreDescripcion);
	
	/**
	 * Metodo encargado de agregar la respuesta al model
	 * @param model
	 * @param respuesta
	 */
	ModelAndView agregarRespuestaModel(ModelAndView model, RespuestaServicio respuesta);
	
	/**
	 * Metodo encargado de obtener la imagen y nombre del usaurio
	 * 
	 * @param model
	 * @param user
	 * @return
	 */
	ModelAndView obtenerImagenNombreUsuario(ModelAndView model, UsuarioLogin user);
	
	/**
	 * Metodo encargado de agregar la respuesta al model
	 * @param model
	 * @param respuesta
	 */
	ModelAndView agregarComboAModel(ModelAndView model, String clave, List<Combo> combos, String claveAfore);
	
	/**
	 * Meotdo encargado de mapear los valors de usuario
	 * 
	 * @param listaUsuarios
	 * @return
	 */
	List<UsuarioControlador> mapearUsuariosAjax(List<Usuarios> listaUsuarios);
	
	/**
	 * Meotdo encargado de mapear los valors de usuario
	 * 
	 * @param listaUsuarios
	 * @return
	 */
	List<UsuarioControlador> mapearUsuariosAjaxModifica(List<UsuariosModificar> listaUsuarios);
	
	/**
	 * Metodo encargado de recuperar el combo de tipo solicitante
	 * @param listSolicitante
	 * @return
	 */
	List<Combo> obtenerComboTipoSolicitante(List<BiomTipoSolicitante> listSolicitante);
	
	/**
	 * Metodo encagrdo de obtener los objeto de combo para los documentos obligatorios y no obligatorios
	 * Se excluye la solicitud de modificacion de datos para el caso de los documentos al modificar los datos de un trabajador
	 * @param documentos
	 * @param comboObligatorios
	 * @param comboNoObligatorios
	 */
	void obtenerComboDocumentosModificacionDatosSinSolicitudDeModificacion(List<DocumentoCompletoRequerido> documentos, List<Combo> comboObligatorios, 
			List<Combo> comboNoObligatorios, UsuarioLogin user);
	
	/**
	 * Metodo encargado de recuperar los tipo de servicio
	 * @return
	 */
	List<Combo> obtenerComboTipoServicio(List<Servicio> listaServicio);
	
	/**
	 * Metodo para modificar una fecha dependiedno de las opciones enviadas
	 * @param opcion - 1:semanas, 2:dias, 3:meses 
	 * @param cantidad- numero>0 : se aumentara, numero<0 se restara
	 * @param fecha   - fecha a modificar
	 * @return
	 */
	Date modificarFecha(Integer opcion, Integer cantidad, Date fecha);
	
	/**
	 * Genear Respuesta Pdf
	 * 
	 * @param archivo
	 * @param bytes
	 * @param response
	 */
	void imprimirReporte(byte[] bytes, HttpServletResponse response);
}