package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * Recepcion de Imagenes enviadas por la AFORE
 * @author lvgonzal
 * @version 1.0
 * @since 13/07/2020
 */

public class RecepcionImagenes implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -5570796512712165349L;
		
	/**
	 * id Recepcion de Imagenes
	 */
	private Long idRecepcionImagenes;
	
	
	/**
	 * Folio ProceSAR
	 */
	private String folioProcesar;
	
	/**
	 * tipo Proceso
	 */
	private String claveTipoProceso;
	
	/**
	 * numero total de documentos requeridos
	 */
	private Integer numeroTotalDoctos;
	
	/**
	 * numero de registros recicbidos
	 */
	private Integer numeroTotalRecibidos;
	
	/**
	 * fechas de recepcion de imagenes
	 */
	@JsonDeserialize(using=FechaJsonDeserializer.class)
	private Date fechaRecepcion;
	
	/**
	 * estatus de la recepcion
	 */
	private Integer estatus;
	
	/**
	 * fecha de control
	 */
	@JsonDeserialize(using=FechaJsonDeserializer.class)
	private Date fechaControl;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;
	

	private List<DetalleRecepcionImagenes> detalleRecepcionImagen;

	
	/**
	 * @return the idRecepcionImagenes
	 */
	public Long getIdRecepcionImagenes() {
		return idRecepcionImagenes;
	}

	/**
	 * @param idRecepcionImagenes the idRecepcionImagenes to set
	 */
	public void setIdRecepcionImagenes(Long idRecepcionImagenes) {
		this.idRecepcionImagenes = idRecepcionImagenes;
	}

	/**
	 * @return the folioProcesar
	 */
	public String getFolioProcesar() {
		return folioProcesar;
	}

	/**
	 * @param folioProcesar the folioProcesar to set
	 */
	public void setFolioProcesar(String folioProcesar) {
		this.folioProcesar = folioProcesar;
	}

	/**
	 * @return the claveTipoProceso
	 */
	public String getClaveTipoProceso() {
		return claveTipoProceso;
	}

	/**
	 * @param claveTipoProceso the claveTipoProceso to set
	 */
	public void setClaveTipoProceso(String claveTipoProceso) {
		this.claveTipoProceso = claveTipoProceso;
	}

	/**
	 * @return the numeroTotalDoctos
	 */
	public Integer getNumeroTotalDoctos() {
		return numeroTotalDoctos;
	}

	/**
	 * @param numeroTotalDoctos the numeroTotalDoctos to set
	 */
	public void setNumeroTotalDoctos(Integer numeroTotalDoctos) {
		this.numeroTotalDoctos = numeroTotalDoctos;
	}

	/**
	 * @return the numeroTotalRecibidos
	 */
	public Integer getNumeroTotalRecibidos() {
		return numeroTotalRecibidos;
	}

	/**
	 * @param numeroTotalRecibidos the numeroTotalRecibidos to set
	 */
	public void setNumeroTotalRecibidos(Integer numeroTotalRecibidos) {
		this.numeroTotalRecibidos = numeroTotalRecibidos;
	}

	/**
	 * @return the fechaRecepcion
	 */
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	/**
	 * @param fechaRecepcion the fechaRecepcion to set
	 */
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	/**
	 * @return the estatus
	 */
	public Integer getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return the usuarioModificador
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * @param usuarioModificador the usuarioModificador to set
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * @return the detalleRecepcionImagen
	 */
	public List<DetalleRecepcionImagenes> getDetalleRecepcionImagen() {
		if(this.detalleRecepcionImagen == null) {
			this.detalleRecepcionImagen = new ArrayList<>();
		}
		return detalleRecepcionImagen;
	}

	/**
	 * @param detalleRecepcionImagen the detalleRecepcionImagen to set
	 */
	public void setDetalleRecepcionImagen(List<DetalleRecepcionImagenes> detalleRecepcionImagen) {
		for(DetalleRecepcionImagenes detalle: detalleRecepcionImagen) {
			agregarDetalleImagenes(detalle);
		}
	}
	
	/**
	 * agrega un detalle de imagenes a la lista
	 */
	public void agregarDetalleImagenes(DetalleRecepcionImagenes detalleImagen) {
		if(!getDetalleRecepcionImagen().contains(detalleImagen) && detalleImagen != null) {
			getDetalleRecepcionImagen().add(detalleImagen);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecepcionImagenes [idRecepcionImagenes=");
		builder.append(idRecepcionImagenes);
		builder.append(", folioProcesar=");
		builder.append(folioProcesar);
		builder.append(", claveTipoProceso=");
		builder.append(claveTipoProceso);
		builder.append(", numeroTotalDoctos=");
		builder.append(numeroTotalDoctos);
		builder.append(", numeroTotalRecibidos=");
		builder.append(numeroTotalRecibidos);
		builder.append(", fechaRecepcion=");
		builder.append(fechaRecepcion);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", detalleRecepcionImagen=");
		builder.append(detalleRecepcionImagen);
		builder.append("]");
		return builder.toString();
	}
	
	
}
