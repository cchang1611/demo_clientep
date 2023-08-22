/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;

/**
 * Simple Transporte Servicio de Persistencia - Notificación
 * @author malopezt
 * @since 2022/02/22
 */
public class NotificacionNipServicio implements Serializable {

	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -20220222022600L;

	/** Folio Pulsar */
	private String cveAfore;
	
	/** Folio Pulsar */
	private String folioPulssar;
	
	/** Apellido paterno*/
	private String apPaterno;
	
	/** Apellido materno*/
	private String apMaterno;
	
	/** Nombres*/
	private String nombre;
	
	/** curp */
	private String curp;
	
	/** nss */
	private String nss;
	
	/** Correo electrónico*/
	private String correo;
	
	/** Teléfono celular */
	private String numeroCelular;
	
	/** identificador de autorizacion */
	private short autorizacion;
	
	/** Corresponde a la fecha de la solicitud enviada como dato de entrada del servicio*/
	private String fechaGeneracionNip;
	
	/** Respuesta entregada por el servicio de generaciónde Nip */
	private String confirmacion;
	
	/** Motivo de rechazo entregada por el servicio de generaciónde Nip */
	private String motivoRechazo;
	
	/** Descripción de rechazo del servicio de generaciónde Nip */
	private String descripcionRechazo;
	
	/** Usuario modificador */
	private String usuarioModificador;
	
	/** Nombre afore */
	private String nombreAfore;
	
	/** Clave agente Servicio */
	private String cveAgenteServicio;
	
	/** Sucursal */
	private String sucursal;
	
	/** Sobrecarga común*/
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("{NotificacionNipEntrada:[cveAfore:").append(cveAfore).append(", ");
		sb.append("folioPulssar:").append(folioPulssar).append(", ");
		sb.append("curp:").append(curp).append(", ");
		sb.append("usuarioModificador:").append(usuarioModificador).append(", ");
		sb.append("confirmacion:").append(confirmacion).append(", ");
		sb.append("motivoRechazo:").append(motivoRechazo).append(", ");
		sb.append("descripcionRechazo:").append(descripcionRechazo).append("]}");
		
		return sb.toString();
	}

	/**
	 * @return the cveAfore
	 */
	public String getCveAfore() {
		return cveAfore;
	}

	/**
	 * @return the folioPulssar
	 */
	public String getFolioPulssar() {
		return folioPulssar;
	}

	/**
	 * @return the apPaterno
	 */
	public String getApPaterno() {
		return apPaterno;
	}

	/**
	 * @return the apMaterno
	 */
	public String getApMaterno() {
		return apMaterno;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @return the numeroCelular
	 */
	public String getNumeroCelular() {
		return numeroCelular;
	}

	/**
	 * @return the autorizacion
	 */
	public short getAutorizacion() {
		return autorizacion;
	}

	/**
	 * @return the fechaGeneracionNip
	 */
	public String getFechaGeneracionNip() {
		return fechaGeneracionNip;
	}

	/**
	 * @return the confirmacion
	 */
	public String getConfirmacion() {
		return confirmacion;
	}

	/**
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @return the descripcionRechazo
	 */
	public String getDescripcionRechazo() {
		return descripcionRechazo;
	}

	/**
	 * @param cveAfore the cveAfore to set
	 */
	public void setCveAfore(String cveAfore) {
		this.cveAfore = cveAfore;
	}

	/**
	 * @param folioPulssar the folioPulssar to set
	 */
	public void setFolioPulssar(String folioPulssar) {
		this.folioPulssar = folioPulssar;
	}

	/**
	 * @param apPaterno the apPaterno to set
	 */
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	/**
	 * @param apMaterno the apMaterno to set
	 */
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @param numeroCelular the numeroCelular to set
	 */
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	/**
	 * @param autorizacion the autorizacion to set
	 */
	public void setAutorizacion(short autorizacion) {
		this.autorizacion = autorizacion;
	}

	/**
	 * @param fechaGeneracionNip the fechaGeneracionNip to set
	 */
	public void setFechaGeneracionNip(String fechaGeneracionNip) {
		this.fechaGeneracionNip = fechaGeneracionNip;
	}

	/**
	 * @param confirmacion the confirmacion to set
	 */
	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}

	/**
	 * @param motivoRechazo the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * @param descripcionRechazo the descripcionRechazo to set
	 */
	public void setDescripcionRechazo(String descripcionRechazo) {
		this.descripcionRechazo = descripcionRechazo;
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
	 * @return the nombreAfore
	 */
	public String getNombreAfore() {
		return nombreAfore;
	}

	/**
	 * @return the cveAgenteServicio
	 */
	public String getCveAgenteServicio() {
		return cveAgenteServicio;
	}

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param nombreAfore the nombreAfore to set
	 */
	public void setNombreAfore(String nombreAfore) {
		this.nombreAfore = nombreAfore;
	}

	/**
	 * @param cveAgenteServicio the cveAgenteServicio to set
	 */
	public void setCveAgenteServicio(String cveAgenteServicio) {
		this.cveAgenteServicio = cveAgenteServicio;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
}
