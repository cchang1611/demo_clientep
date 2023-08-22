package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;

/**
 * Detalle Recepcion de Imagenes enviadas por la AFORE
 * @author lvgonzal
 * @version 1.0
 * @since 14/07/2020
 */
public class DetalleRecepcionImagenes implements Serializable{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 3413283329705035416L;
	
	/**
	 * ID detalle recepcion de imagenes
	 */
	private Long idDetalleRecepcionImagenes;
		
	/**
	 * tipo de documento digital
	 */
	private String tipoDocumentoDigital;
	
	/**
	 * numero de documento
	 */
	private Integer numeroDocumento;
	
	/**
	 * tipo de imagen
	 */
	private Integer tipoImagen;
	
	/**
	 * mascara archivo
	 */
	private String mascara;
	
	/**
	 * ruta archivo
	 */
	private String ruta;
	
	/**
	 * tipo archivo
	 */
	private String tipoArchivo;
	
	/**
	 * fecha de control
	 */
	@JsonDeserialize(using=FechaJsonDeserializer.class)
	private Date fechaControl;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * @return the idDetalleRecepcionImagenes
	 */
	public Long getIdDetalleRecepcionImagenes() {
		return idDetalleRecepcionImagenes;
	}

	/**
	 * @param idDetalleRecepcionImagenes the idDetalleRecepcionImagenes to set
	 */
	public void setIdDetalleRecepcionImagenes(Long idDetalleRecepcionImagenes) {
		this.idDetalleRecepcionImagenes = idDetalleRecepcionImagenes;
	}

	/**
	 * @return the tipoDocumentoDigital
	 */
	public String getTipoDocumentoDigital() {
		return tipoDocumentoDigital;
	}

	/**
	 * @param tipoDocumentoDigital the tipoDocumentoDigital to set
	 */
	public void setTipoDocumentoDigital(String tipoDocumentoDigital) {
		this.tipoDocumentoDigital = tipoDocumentoDigital;
	}

	/**
	 * @return the numeroDocumento
	 */
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the tipoImagen
	 */
	public Integer getTipoImagen() {
		return tipoImagen;
	}

	/**
	 * @param tipoImagen the tipoImagen to set
	 */
	public void setTipoImagen(Integer tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	/**
	 * @return the mascara
	 */
	public String getMascara() {
		return mascara;
	}

	/**
	 * @param mascara the mascara to set
	 */
	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return the tipoArchivo
	 */
	public String getTipoArchivo() {
		return tipoArchivo;
	}

	/**
	 * @param tipoArchivo the tipoArchivo to set
	 */
	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetalleRecepcionImagenes [idDetalleRecepcionImagenes=");
		builder.append(idDetalleRecepcionImagenes);
		builder.append(", tipoDocumentoDigital=");
		builder.append(tipoDocumentoDigital);
		builder.append(", numeroDocumento=");
		builder.append(numeroDocumento);
		builder.append(", tipoImagen=");
		builder.append(tipoImagen);
		builder.append(", mascara=");
		builder.append(mascara);
		builder.append(", ruta=");
		builder.append(ruta);
		builder.append(", tipoArchivo=");
		builder.append(tipoArchivo);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
}
