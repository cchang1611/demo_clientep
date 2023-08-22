package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo;

import java.io.Serializable;

/**
 * informacion de la huella dactilar o motivo sin huella
 * @author jcgarces
 *
 */
public class RespuestaHuella implements Serializable{
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7136434021565075324L;

	/** 
	 * id de dedo
	 */
	private String trabajador;

	/** 
	 * id de dedo
	 */
	private String idDedo;
	
	/**
	 * tipo persona
	 */
	private String tipoPersona;
	
	/**
	 * motivo sin huella. solo si no se envia huella
	 */
	private String motivoSinHuella;
	
	/**
	 * codigoFaltaDedo codigo por falta de dedo
	 */
	private String codigoFaltaDedo;
	
	/**
	 * fecha de captura
	 */
	private String fechaCaptura;
	
	/**
	 * huella en base 64
	 */
	private String huella64;
	
	/**
	 * hash de la huella
	 */
	private String huellaHash;
	
	/**
	 * calidad de la huella
	 */
	private String calidadHuella;
	
	/**
	 * id dispositivo
	 */
	private String idDevice;
	
	/**
	 * perfil de adquisiscion
	 */
	private String perfilAdquisicionHuella;
	
	/**
	 * calidad Imagen
	 */
	private String calidadImagen;
	
	/**
	 * resolucion de la captura
	 */
	private String resolucionCaptura;
	
	/**
	 * unidade s de escala
	 */
	private String unidadesEscala;

	/**
	 * @return the idDedo
	 */
	public String getIdDedo() {
		return idDedo;
	}
	
	/**
	 * @return the trabajador
	 */
	public String getTrabajador() {
		return trabajador;
	}

	/**
	 * @param trabajador the trabajador to set
	 */
	public void setTrabajador(String trabajador) {
		this.trabajador = trabajador;
	}

	/**
	 * @param idDedo the idDedo to set
	 */
	public void setIdDedo(String idDedo) {
		this.idDedo = idDedo;
	}

	/**
	 * @return the tipoPersona
	 */
	public String getTipoPersona() {
		return tipoPersona;
	}

	/**
	 * @param tipoPersona the tipoPersona to set
	 */
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	/**
	 * @return the motivoSinHuella
	 */
	public String getMotivoSinHuella() {
		return motivoSinHuella;
	}

	/**
	 * @param motivoSinHuella the motivoSinHuella to set
	 */
	public void setMotivoSinHuella(String motivoSinHuella) {
		this.motivoSinHuella = motivoSinHuella;
	}

	/**
	 * @return the codigoFaltaDedo
	 */
	public String getCodigoFaltaDedo() {
		return codigoFaltaDedo;
	}

	/**
	 * @param codigoFaltaDedo the codigoFaltaDedo to set
	 */
	public void setCodigoFaltaDedo(String codigoFaltaDedo) {
		this.codigoFaltaDedo = codigoFaltaDedo;
	}

	/**
	 * @return the fechaCaptura
	 */
	public String getFechaCaptura() {
		return fechaCaptura;
	}

	/**
	 * @param fechaCaptura the fechaCaptura to set
	 */
	public void setFechaCaptura(String fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	/**
	 * @return the huella64
	 */
	public String getHuella64() {
		return huella64;
	}

	/**
	 * @param huella64 the huella64 to set
	 */
	public void setHuella64(String huella64) {
		this.huella64 = huella64;
	}

	/**
	 * @return the huellaHash
	 */
	public String getHuellaHash() {
		return huellaHash;
	}

	/**
	 * @param huellaHash the huellaHash to set
	 */
	public void setHuellaHash(String huellaHash) {
		this.huellaHash = huellaHash;
	}

	/**
	 * @return the calidadHuella
	 */
	public String getCalidadHuella() {
		return calidadHuella;
	}

	/**
	 * @param calidadHuella the calidadHuella to set
	 */
	public void setCalidadHuella(String calidadHuella) {
		this.calidadHuella = calidadHuella;
	}

	/**
	 * @return the idDevice
	 */
	public String getIdDevice() {
		return idDevice;
	}

	/**
	 * @param idDevice the idDevice to set
	 */
	public void setIdDevice(String idDevice) {
		this.idDevice = idDevice;
	}

	/**
	 * @return the perfilAdquisicionHuella
	 */
	public String getPerfilAdquisicionHuella() {
		return perfilAdquisicionHuella;
	}

	/**
	 * @param perfilAdquisicionHuella the perfilAdquisicionHuella to set
	 */
	public void setPerfilAdquisicionHuella(String perfilAdquisicionHuella) {
		this.perfilAdquisicionHuella = perfilAdquisicionHuella;
	}

	/**
	 * @return the calidadImagen
	 */
	public String getCalidadImagen() {
		return calidadImagen;
	}

	/**
	 * @param calidadImagen the calidadImagen to set
	 */
	public void setCalidadImagen(String calidadImagen) {
		this.calidadImagen = calidadImagen;
	}

	/**
	 * @return the resolucionCaptura
	 */
	public String getResolucionCaptura() {
		return resolucionCaptura;
	}

	/**
	 * @param resolucionCaptura the resolucionCaptura to set
	 */
	public void setResolucionCaptura(String resolucionCaptura) {
		this.resolucionCaptura = resolucionCaptura;
	}

	/**
	 * @return the unidadesEscala
	 */
	public String getUnidadesEscala() {
		return unidadesEscala;
	}

	/**
	 * @param unidadesEscala the unidadesEscala to set
	 */
	public void setUnidadesEscala(String unidadesEscala) {
		this.unidadesEscala = unidadesEscala;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HuellaDactilar [idDedo=");
		builder.append(idDedo);
		builder.append(", trabajador=");
		builder.append(trabajador);
		builder.append(", tipoPersona=");
		builder.append(tipoPersona);
		builder.append(", motivoSinHuella=");
		builder.append(motivoSinHuella);
		builder.append(", codigoFaltaDedo=");
		builder.append(codigoFaltaDedo);
		builder.append(", fechaCaptura=");
		builder.append(fechaCaptura);
		builder.append(", huellaHash=");
		builder.append(huellaHash);
		builder.append(", calidadHuella=");
		builder.append(calidadHuella);
		builder.append(", idDevice=");
		builder.append(idDevice);
		builder.append(", perfilAdquisicionHuella=");
		builder.append(perfilAdquisicionHuella);
		builder.append(", calidadImagen=");
		builder.append(calidadImagen);
		builder.append(", resolucionCaptura=");
		builder.append(resolucionCaptura);
		builder.append(", unidadesEscala=");
		builder.append(unidadesEscala);
		builder.append("]");
		return builder.toString();
	}

}
