package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.serializer.FechaJsonDeserializer;
/**
 *  Marcas estatus vivienda 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since May 21, 2021
 */
public class EstatusViviendaMarcaImss implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -3418326108248564037L;

	/**
	 * EmbeddedId id
	 */
	
	private EstatusViviendaMarcaImssPK id;
	
	/**
	 * fechaControl
	 */
	@JsonDeserialize(using = FechaJsonDeserializer.class)
	private Date fechaControl; 
	
	/**
	 * usuarioModificacion
	 */
	
	private String usuarioModificacion;
	
	/**
	 * indicadorVivienda
	 */
	private String indicadorVivienda;

	/**
	 * @return el atributo id
	 */
	public EstatusViviendaMarcaImssPK getId() {
		return id;
	}

	/**
	 * @param id parametro id a actualizar
	 */
	public void setId(EstatusViviendaMarcaImssPK id) {
		this.id = id;
	}

	/**
	 * @return el atributo fechaControl
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl parametro fechaControl a actualizar
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * @return el atributo usuarioModificacion
	 */
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion parametro usuarioModificacion a actualizar
	 */
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return el atributo indicadorVivienda
	 */
	public String getIndicadorVivienda() {
		return indicadorVivienda;
	}

	/**
	 * @param indicadorVivienda parametro indicadorVivienda a actualizar
	 */
	public void setIndicadorVivienda(String indicadorVivienda) {
		this.indicadorVivienda = indicadorVivienda;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EstatusViviendaMarcaImss [id=");
		builder.append(id);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificacion=");
		builder.append(usuarioModificacion);
		builder.append(", indicadorVivienda=");
		builder.append(indicadorVivienda);
		builder.append("]");
		return builder.toString();
	}
	
	
}
