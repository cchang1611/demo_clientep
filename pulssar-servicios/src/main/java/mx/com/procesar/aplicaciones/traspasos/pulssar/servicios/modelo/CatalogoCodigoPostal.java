package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Output del servicio de Catalogo
 * 
 * @author JMGUTIEG
 * 
 */
public class CatalogoCodigoPostal implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id del catalogo
	 */
	private String id;

	/**
	 * Nombre del catalogo
	 */
	private String nombre;

	/**
	 * Descripcion del catalogo
	 */
	private String descripcion;

	/**
	 * Estatus del catalogo
	 */
	private String status;

	/**
	 * Campos del catalogo
	 */
	private CodigoPostal campos;

	/**
	 * Constructor
	 */
	public CatalogoCodigoPostal(){

		super();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	

	/**
	 * @return the campos
	 */
	public CodigoPostal getCampos() {
		return campos;
	}

	/**
	 * @param campos the campos to set
	 */
	public void setCampos(CodigoPostal campos) {
		this.campos = campos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CatalogoCodigoPostal [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", status=");
		builder.append(status);
		builder.append(", campos=");
		builder.append(campos);
		builder.append("]");
		return builder.toString();
	}
	
	

//	/**
//	 * Constructor
//	 */
//	public CatalogoCodigoPostal(Map<String, Object> campos){
//
//		super();
//		this.campos = campos;
//	}

//	/**
//	 * Constuctor
//	 * 
//	 * @param id
//	 * @param nombre
//	 * @param descripcion
//	 * @param status
//	 * @param campos
//	 */
//	public CatalogoCodigoPostal(String id, String nombre, String descripcion, String status, Map<String, Object> campos){
//
//		super();
//		this.id = id;
//		this.nombre = nombre;
//		this.descripcion = descripcion;
//		this.status = status;
//		this.campos = campos;
//	}

//	/**
//	 * @return the campos
//	 */
//	public Map<String, Object> getCampos() {
//
//		return campos;
//	}

}
