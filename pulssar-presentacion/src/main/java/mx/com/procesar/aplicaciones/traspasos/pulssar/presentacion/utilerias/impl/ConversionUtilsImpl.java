package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.OPCION_DIAS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.OPCION_MES;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ReporteriaConstants.OPCION_SEMANA;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Organizacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolesCatalogo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Servicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.Usuarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.UsuariosModificar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo.UsuarioControlador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Afore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BiomTipoSolicitante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentoCompletoRequerido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Componente de utileria de conversion de objetos
 * 
 * @author dbarbosa
 * @version 1.0
 */
@Component
public class ConversionUtilsImpl implements ConversionUtils {
	
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ConversionUtilsImpl.class);
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Combo> obtenerComboAfores(List<Afore> listAfore) {
		logger.info("Se realiza la conversion de las afores {}", listAfore);
		List<Combo> listaCombo = new ArrayList<>();
		if(!utileriaValidador.validarListaVacia(listAfore)) {
			Combo combo;
			for(Afore afore : listAfore) {
				combo = new Combo();
				combo.setClave(afore.getClaveAfore());
				combo.setDescripcion(afore.getDescripcionAfore());
				listaCombo.add(combo);
			}
		}
		return listaCombo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Combo> obtenerComboOrganizacion(List<Organizacion> listaOrganizacion, List<String> claveOrganizacion) {
		logger.info("Se realiza la convercion de las organizaciones {}", listaOrganizacion);
		List<Combo> listaCombo = new ArrayList<>();
		if(!utileriaValidador.validarListaVacia(listaOrganizacion)){
			Combo combo;
			for(Organizacion organizacion : listaOrganizacion) {
				if(!claveOrganizacion.contains(organizacion.getClaveOrganizacion())){
					combo = new Combo();
					combo.setClave(organizacion.getClaveOrganizacion());
					combo.setDescripcion(organizacion.getDescripcionOrganizacion());
					listaCombo.add(combo);
				}
			}
		}
		return listaCombo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UsuarioControlador> mapearUsuariosAjax(List<Usuarios> listaUsuarios) {
		logger.info("Mapeo de usuarios ajax usuarios");
		List<UsuarioControlador> lista = new ArrayList<>();
		if(!utileriaValidador.validarListaVacia(listaUsuarios)){
			UsuarioControlador usuarioControlador;
			for(Usuarios usuario : listaUsuarios) {
				usuarioControlador = new UsuarioControlador();
				String cadenaUsuario = utileriaValidador.validarVacio(usuario.getNickUsuario()) ? usuario.getUsuario() : usuario.getNickUsuario();
				usuarioControlador.setId(utileriaCadena.obtenerContenidoCadenaSinEspacios(cadenaUsuario, ExpresionesConstants.VACIO));
				usuarioControlador.setUsuario(utileriaCadena.obtenerContenidoCadenaSinEspacios(cadenaUsuario, ExpresionesConstants.VACIO));
				usuarioControlador.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getNombre(), ExpresionesConstants.VACIO));
				usuarioControlador.setApellidoPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getApellidoPaterno(), ExpresionesConstants.VACIO));
				usuarioControlador.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getApellidoMaterno(), ExpresionesConstants.VACIO));
				usuarioControlador.setEmail(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getEmail(), ExpresionesConstants.VACIO));
				usuarioControlador.setCelular(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getCelular(), ExpresionesConstants.VACIO));
				lista.add(usuarioControlador);
			}
		}
		return lista;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UsuarioControlador> mapearUsuariosAjaxModifica(List<UsuariosModificar> listaUsuarios) {
		logger.info("Mapeo de usuarios ajax modifica");
		List<UsuarioControlador> lista = new ArrayList<>();
		if(!utileriaValidador.validarListaVacia(listaUsuarios)){
			UsuarioControlador usuarioControlador;
			for(UsuariosModificar usuario : listaUsuarios) {
				usuarioControlador = new UsuarioControlador();
				String cadenaUsuario = utileriaValidador.validarVacio(usuario.getNickUsuario()) ? usuario.getUsuario() : usuario.getNickUsuario();
				usuarioControlador.setId(utileriaCadena.obtenerContenidoCadenaSinEspacios(cadenaUsuario, ExpresionesConstants.VACIO));
				usuarioControlador.setUsuario(utileriaCadena.obtenerContenidoCadenaSinEspacios(cadenaUsuario, ExpresionesConstants.VACIO));
				usuarioControlador.setNombre(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getNombre(), ExpresionesConstants.VACIO));
				usuarioControlador.setApellidoPaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getApellidoPaterno(), ExpresionesConstants.VACIO));
				usuarioControlador.setApellidoMaterno(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getApellidoMaterno(), ExpresionesConstants.VACIO));
				usuarioControlador.setEmail(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getEmail(), ExpresionesConstants.VACIO));
				usuarioControlador.setCelular(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getCelular(), ExpresionesConstants.VACIO));
				usuarioControlador.setDescripcionRol(utileriaCadena.obtenerContenidoCadenaSinEspacios(usuario.getDescripcionRol(), ExpresionesConstants.VACIO));
				lista.add(usuarioControlador);
			}
		}
		return lista;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Combo> obtenerRolesUsuario(List<RolesCatalogo> listaRoles) {
		logger.info("Se realiza la convercion de los roles {}", listaRoles);
		List<Combo> listaCombo = new ArrayList<>();
		if(!utileriaValidador.validarListaVacia(listaRoles)){
			Combo combo;
			for(RolesCatalogo roles : listaRoles) {
				combo = new Combo();
				combo.setIdentificadorCombo(roles.getIdentificadorRol());
				combo.setClave(roles.getClaveRol());
				combo.setDescripcion(roles.getDescripcionRol());
				combo.setBandera(NumerosConstants.INT_CERO);
				listaCombo.add(combo);
			}
		}
		return listaCombo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Combo> obtenerCatalogoGenerico(List<?> listaGenerica, String nombreClave, String nombreDescripcion){
		List<Combo> catalogoGenericoList = new ArrayList<Combo>();
		if(listaGenerica != null && !listaGenerica.isEmpty()) {
			
			Combo registroGenerico;
			for(Object obj : listaGenerica) {
				ObjectMapper mapper = new ObjectMapper();
				Map< String, String> map = mapper.convertValue(obj, Map.class);
				registroGenerico = new Combo();	
				
				Object nombre = map.get(nombreClave);				
				Object descripcion = map.get(nombreDescripcion);
				if( !utileriaValidador.validarObjetoNulo(nombre) && !utileriaValidador.validarObjetoNulo(descripcion) ){
					registroGenerico.setClave(nombre.toString());
					registroGenerico.setDescripcion(descripcion.toString());
					catalogoGenericoList.add(registroGenerico);	
				}								
			}
		}
		return catalogoGenericoList;
	}	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelAndView agregarRespuestaModel(ModelAndView model, RespuestaServicio respuesta) {
		ModelAndView auxiliarModel = model;
		if(respuesta != null) {
			auxiliarModel.addObject("respuesta", respuesta);
		}
		return auxiliarModel;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelAndView obtenerImagenNombreUsuario(ModelAndView model, UsuarioLogin user) {
		ModelAndView auxiliarModel = model;
		if(user != null && user.getNombre() != null) {
			auxiliarModel.addObject("imagen", user.getFoto());
			auxiliarModel.addObject("nombreUsuario", user.getNombre());
		} else {
			auxiliarModel.addObject("imagen", null);
			auxiliarModel.addObject("nombreUsuario", ExpresionesConstants.VACIO);
		}
		return auxiliarModel;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelAndView agregarComboAModel(ModelAndView model, String clave, List<Combo> combos, String claveAfore) {
		ModelAndView auxiliarModel = model;
		if(combos != null) {
			List<Combo> auxiliarCombos = this.obtenerComboAfores(claveAfore, combos);
			auxiliarModel.addObject(clave, auxiliarCombos);
		}
		return auxiliarModel;
	}
	
	/**
	 * Metodo encargado de obtener el combo de la afore seleccionada
	 * @param claveAfore
	 * @return
	 */
	private List<Combo> obtenerComboAfores(String claveAfore, List<Combo> lAfores) {
		List<Combo> lCombo = lAfores;
		if(!utileriaValidador.validarVacio(claveAfore) && !utileriaValidador.validarListaVacia(lAfores)) {
			lCombo = null;
			boolean isEncontrado = false;
			int i = 0;
			lCombo = new ArrayList<>();
			do {
				Combo registro = lAfores.get(i);
				if(claveAfore.equals(registro.getClave())) {
					isEncontrado = true;
					lCombo.add(registro);
				}
				i++;
			} while (i < lAfores.size() && !isEncontrado);
			
			if(!isEncontrado) {
				lCombo = lAfores;
			}
		}
		return lCombo;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Combo> obtenerComboTipoSolicitante(List<BiomTipoSolicitante> listSolicitante) {
		logger.info("Se realiza la conversion de las afores {}", listSolicitante);
		List<Combo> listaCombo = new ArrayList<>();
		if(!utileriaValidador.validarListaVacia(listSolicitante)) {
			Combo combo;
			for(BiomTipoSolicitante solicitante : listSolicitante) {
				combo = new Combo();
				combo.setClave(solicitante.getCvTipoSolicitante());
				combo.setDescripcion(solicitante.getChTipoSolicitante());
				listaCombo.add(combo);
			}
		}
		return listaCombo;
	}

	@Override
	public void obtenerComboDocumentosModificacionDatosSinSolicitudDeModificacion(List<DocumentoCompletoRequerido> documentos, List<Combo> comboObligatorios,
			List<Combo> comboNoObligatorios, UsuarioLogin user) {
		logger.info("Se realiza la conversion de documentos ModificacionDatos{}", documentos);
		if(!utileriaValidador.validarListaVacia(documentos)) {
			Combo combo;
			for(DocumentoCompletoRequerido documento : documentos) {
				combo = new Combo();
				combo.setClave(documento.getDocumentoRequerido().getClaveTipoDocDigital());
				combo.setDescripcion(documento.getDescripcion());
				if(documento.getDocumentoRequerido().getNumeroObligatorio().intValue() == NumerosConstants.INT_UNO 
				    && !documento.getDocumentoRequerido().getClaveTipoDocDigital().equals("69")) {// Se omite el documento obligatorio Solicitud Modificacion de Datos
					comboObligatorios.add(combo);
				} else if (!documento.getDocumentoRequerido().getClaveTipoDocDigital().equals("69")){// Se omite el documento obligatorio Solicitud Modificacion de Datos
					comboNoObligatorios.add(combo);
				}
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils#obtenerTipoServicio(java.util.List)
	 */
	@Override
	public List<Combo> obtenerComboTipoServicio(List<Servicio> listaServicio) {
		List<Combo> listaCombo= new ArrayList<>();
		if(!utileriaValidador.validarListaVacia(listaServicio)) {
			listaCombo=Lists
						.newArrayList(Collections2.transform(listaServicio, new Function<Servicio, Combo>() {
							@Override
							public Combo apply(Servicio tipoServicio) {
								Combo combo = new Combo();
								combo.setClave(String.valueOf(tipoServicio.getId()));
								combo.setDescripcion(tipoServicio.getDescripcionServicio());
				
								
								return combo;
							}
						}));
		}
		return  listaCombo;
	}


	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils#restarFecha(java.lang.Integer, java.util.Date)
	 */
	@Override
	public Date modificarFecha(Integer opcion,Integer cantidad, Date fecha) {
		
		Calendar calendario= Calendar.getInstance();
		
		if(!utileriaValidador.validarObjetoNulo(opcion) && !utileriaValidador.validarObjetoNulo(cantidad)  
			&& !utileriaValidador.validarObjetoNulo(fecha) ){
			
				calendario.setTime(fecha);
				
				if(opcion.intValue()==OPCION_SEMANA.intValue()){
					calendario.add(Calendar.WEEK_OF_YEAR,cantidad);
				}
				else if(opcion.intValue()==OPCION_DIAS.intValue()){
					calendario.add(Calendar.DAY_OF_YEAR, cantidad);
				}
				else if(opcion.intValue()==OPCION_MES.intValue()){
					calendario.add(Calendar.MONTH, cantidad);
				}
		
		}
		
		return calendario.getTime();
	}
	
	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ConversionUtils#imprimirReporte(byte[], javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void imprimirReporte(byte[] bytes, HttpServletResponse response) {
		Boolean status = false;
		if (bytes != null) {
			response.resetBuffer();
			String headerValue = String.format("filename=\"%s\"", "DatosReferencia.pdf");
			response.setHeader("Content-Disposition", headerValue);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			OutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				logger.error("Exception al generar pdf {}", e);
			}

			response.setHeader("Set-Cookie", "fileDownload=".concat(Boolean.toString(status)).concat("; path=/"));
		}

	}
}