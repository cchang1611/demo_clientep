package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;
import java.util.Date;


/**
 * Representa la entidad de Usuario, mapeado a la tabla TRAN_TR_USUARIO_PULSSAR
 * 
 * @author DBARBOSA
 */
public class UsuariosModificar implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 4447895641778525686L;

	/**
	 * Identificador único de registro.
	 */
	private Long identificadorUsuario;
	
	/**
	 * Usuario de Portal.
	 */
	private String usuario;
	
	/**
	 * nick de usuario
	 */
	private String nickUsuario;
	
	/**
	 * Nombre del usuario.
	 */
	private String nombre;
	
	/**
	 * Apellido Paterno usuario.
	 */
	private String apellidoPaterno;
	
	/**
	 * Apellido Materno usuario.
	 */
	private String apellidoMaterno;
	
	/**
	 * Correo Electrónico.
	 */
	private String email;
	
	/**
	 * Celular del usuario.
	 */
	private String celular;
	
	/**
	 * Identificador de la Organización.
	 */
	private String claveOrganizacion;

	/**
	 * estatus
	 */
	private String estatus;
	
	/**
	 * Fecha de ultima modificación.
	 */
	private Date fecha;
	
	/**
	 * Clave Rol
	 */
	private String claveRol;
	
	/**
	 * Descripcion Rol
	 */
	private String descripcionRol;
	
	/**
	 * Descripcion Rol
	 */
	private String claveSucursal;
	
	/**
	 * Descripcion Rol
	 */
	private String claveOficina;
	
	/**
	 * Descripcion Rol
	 */
	private Long zona;
	
	/**
	 * Constructor por defecto
	 */
	public UsuariosModificar() {
		super();
	}

	/**
	 * Contructor con parametros
	 * 
	 * @param nombre
	 * @param apellidoPaterno
	 * @param apellidoMaterno
	 * @param email
	 */
	public UsuariosModificar(Object[] objeto) {
		super();
		this.identificadorUsuario = (Long) objeto[0];
		this.usuario = (String) objeto[1];
		this.nickUsuario = (String) objeto[2];
		this.nombre = (String) objeto[3];
		this.apellidoPaterno = (String) objeto[4];
		this.apellidoMaterno = (String) objeto[5];
		this.email = (String) objeto[6];
		this.celular = (String) objeto[7];
		this.estatus = (String) objeto[8];
		this.claveOrganizacion = (String) objeto[9];
		this.fecha = (Date) objeto[10];
		this.claveRol = (String) objeto[11];
		this.descripcionRol = (String) objeto[12];
		this.claveSucursal = (String) objeto[13];
		this.claveOficina = (String) objeto[14];
		this.zona = (Long) objeto[15];
	}
	
	/**
	 * @return the identificadorUsuario
	 */
	public Long getIdentificadorUsuario() {
		return identificadorUsuario;
	}

	/**
	 * @param identificadorUsuario the identificadorUsuario to set
	 */
	public void setIdentificadorUsuario(Long identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the nickUsuario
	 */
	public String getNickUsuario() {
		return nickUsuario;
	}

	/**
	 * @param nickUsuario the nickUsuario to set
	 */
	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
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
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the claveOrganizacion
	 */
	public String getClaveOrganizacion() {
		return claveOrganizacion;
	}

	/**
	 * @param claveOrganizacion the claveOrganizacion to set
	 */
	public void setClaveOrganizacion(String claveOrganizacion) {
		this.claveOrganizacion = claveOrganizacion;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the claveRol
	 */
	public String getClaveRol() {
		return claveRol;
	}

	/**
	 * @param claveRol the claveRol to set
	 */
	public void setClaveRol(String claveRol) {
		this.claveRol = claveRol;
	}

	/**
	 * @return the descripcionRol
	 */
	public String getDescripcionRol() {
		return descripcionRol;
	}

	/**
	 * @param descripcionRol the descripcionRol to set
	 */
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}
	
	/**
	 * @return the claveSucursal
	 */
	public String getClaveSucursal() {
		return claveSucursal;
	}

	/**
	 * @param claveSucursal the claveSucursal to set
	 */
	public void setClaveSucursal(String claveSucursal) {
		this.claveSucursal = claveSucursal;
	}

	/**
	 * @return the claveOficina
	 */
	public String getClaveOficina() {
		return claveOficina;
	}

	/**
	 * @param claveOficina the claveOficina to set
	 */
	public void setClaveOficina(String claveOficina) {
		this.claveOficina = claveOficina;
	}

	/**
	 * @return the zona
	 */
	public Long getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(Long zona) {
		this.zona = zona;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuariosModificar [");
		if (identificadorUsuario != null) {
			builder.append("identificadorUsuario=");
			builder.append(identificadorUsuario);
			builder.append(", ");
		}
		if (usuario != null) {
			builder.append("usuario=");
			builder.append(usuario);
			builder.append(", ");
		}
		if (nickUsuario != null) {
			builder.append("nickUsuario=");
			builder.append(nickUsuario);
			builder.append(", ");
		}
		if (nombre != null) {
			builder.append("nombre=");
			builder.append(nombre);
			builder.append(", ");
		}
		if (apellidoPaterno != null) {
			builder.append("apellidoPaterno=");
			builder.append(apellidoPaterno);
			builder.append(", ");
		}
		if (apellidoMaterno != null) {
			builder.append("apellidoMaterno=");
			builder.append(apellidoMaterno);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email=");
			builder.append(email);
			builder.append(", ");
		}
		if (celular != null) {
			builder.append("celular=");
			builder.append(celular);
			builder.append(", ");
		}
		if (claveOrganizacion != null) {
			builder.append("claveOrganizacion=");
			builder.append(claveOrganizacion);
			builder.append(", ");
		}
		if (estatus != null) {
			builder.append("estatus=");
			builder.append(estatus);
			builder.append(", ");
		}
		if (fecha != null) {
			builder.append("fecha=");
			builder.append(fecha);
			builder.append(", ");
		}
		if (claveRol != null) {
			builder.append("claveRol=");
			builder.append(claveRol);
			builder.append(", ");
		}
		if (descripcionRol != null) {
			builder.append("descripcionRol=");
			builder.append(descripcionRol);
			builder.append(", ");
		}
		if (claveSucursal != null) {
			builder.append("claveSucursal=");
			builder.append(claveSucursal);
		}
		if (claveOficina != null) {
			builder.append("claveOficina=");
			builder.append(claveOficina);
		}
		if (zona != null) {
			builder.append("zona=");
			builder.append(zona);
		}
		builder.append("]");
		return builder.toString();
	}	
	
}