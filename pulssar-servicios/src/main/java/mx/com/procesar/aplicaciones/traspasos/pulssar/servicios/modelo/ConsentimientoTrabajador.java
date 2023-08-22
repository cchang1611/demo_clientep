/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * consentimeitno de trabajador
 * @author jcgarces
 *
 */
public class ConsentimientoTrabajador implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -3465075822126816266L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * id del folio pulssar
	 */
	private Long idFolioPulssar;
	
	/**
	 * ruta del archivo
	 */
	private String rutaArchivo;
	
	/**
	 * Estado del PDF 1 Activo, 0 Inactivo
	 */
	private Integer estatus;
	
	/**
	 * fecha de control
	 */
	private String fechaControl;
	
	/**
	 * usuario modificador
	 */
	private String usuarioModificador;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the idFolioPulssar
	 */
	public Long getIdFolioPulssar() {
		return idFolioPulssar;
	}

	/**
	 * @param idFolioPulssar the idFolioPulssar to set
	 */
	public void setIdFolioPulssar(Long idFolioPulssar) {
		this.idFolioPulssar = idFolioPulssar;
	}

	/**
	 * @return the rutaArchivo
	 */
	public String getRutaArchivo() {
		return rutaArchivo;
	}

	/**
	 * @param rutaArchivo the rutaArchivo to set
	 */
	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
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
	public String getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(String fechaControl) {
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
		builder.append("ConsentimientoTrabajador [id=");
		builder.append(id);
		builder.append(", idFolioPulssar=");
		builder.append(idFolioPulssar);
		builder.append(", rutaArchivo=");
		builder.append(rutaArchivo);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}

}
