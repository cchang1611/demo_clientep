/**
 * ModificacionUsuario.java Fecha de creación: 21/12/2020, Copyright (c) 2020
 * Procesar S A de C V. Todos los derechos reservados. Este software es información
 * confidencial, propiedad del Procesar S A de C V. Esta información confidencial no deberá ser
 * divulgada y solo se podrá utilizar de acuerdo a los términos que determine la propia
 * empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;


/**
 * Clase que almacena la respuesta de la modificacion de un usuario
 * 
 * @author dbarbosa
 * @version 1.0
 * @since 21/12/2020
 */
public class ModificacionUsuario implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2911929543460730875L;

	/**
	 * Modelo vista controlador
	 */
	private ModelAndView modeloVista;
	
	/**
	 * Lista sucursales
	 */
	private List<Combo> listaSucursales;
	
	/**
	 * lista zonas
	 */
	private List<Combo> listaZonas;
	
	/**
	 * lista descripcion zona
	 */
	private List<Combo> listaDescripcionZona;
	
	/**
	 * Lista oficina
	 */
	List<Combo> listaOficina;
	
	/**
	 * Respuesta 
	 */
	private RespuestaServicio respuesta;

	/**
	 * @return the modeloVista
	 */
	public ModelAndView getModeloVista() {
		return modeloVista;
	}

	/**
	 * @param modeloVista the modeloVista to set
	 */
	public void setModeloVista(ModelAndView modeloVista) {
		this.modeloVista = modeloVista;
	}

	/**
	 * @return the listaSucursales
	 */
	public List<Combo> getListaSucursales() {
		return listaSucursales;
	}

	/**
	 * @param listaSucursales the listaSucursales to set
	 */
	public void setListaSucursales(List<Combo> listaSucursales) {
		this.listaSucursales = listaSucursales;
	}

	/**
	 * @return the listaZonas
	 */
	public List<Combo> getListaZonas() {
		return listaZonas;
	}

	/**
	 * @param listaZonas the listaZonas to set
	 */
	public void setListaZonas(List<Combo> listaZonas) {
		this.listaZonas = listaZonas;
	}

	/**
	 * @return the listaDescripcionZona
	 */
	public List<Combo> getListaDescripcionZona() {
		return listaDescripcionZona;
	}

	/**
	 * @param listaDescripcionZona the listaDescripcionZona to set
	 */
	public void setListaDescripcionZona(List<Combo> listaDescripcionZona) {
		this.listaDescripcionZona = listaDescripcionZona;
	}

	/**
	 * @return the listaOficina
	 */
	public List<Combo> getListaOficina() {
		return listaOficina;
	}

	/**
	 * @param listaOficina the listaOficina to set
	 */
	public void setListaOficina(List<Combo> listaOficina) {
		this.listaOficina = listaOficina;
	}

	/**
	 * @return the respuesta
	 */
	public RespuestaServicio getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(RespuestaServicio respuesta) {
		this.respuesta = respuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModificacionUsuario [modelo=");
		builder.append(modeloVista);
		builder.append(", listaSucursales=");
		builder.append(listaSucursales);
		builder.append(", listaZonas=");
		builder.append(listaZonas);
		builder.append(", listaDescripcionZona=");
		builder.append(listaDescripcionZona);
		builder.append(", listaOficina=");
		builder.append(listaOficina);
		builder.append(", respuesta=");
		builder.append(respuesta);
		builder.append("]");
		return builder.toString();
	}
}