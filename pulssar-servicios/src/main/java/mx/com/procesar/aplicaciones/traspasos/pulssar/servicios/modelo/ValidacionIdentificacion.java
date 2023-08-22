package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Datos de la respuesta de la validacion de la identificacion del deep dive
 * @author jcgarces
 *
 */
public class ValidacionIdentificacion implements Serializable{
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -6475312800615345325L;

	/**
	 * ID de la entidad
	 */
	private Long id;
	
	/**
	 * ID de la recepción del expediente
	 */
	private ArchivoRecibido archivoRecibido;
	
	/**
	 * Codigo de estatus
	 */
	private String codigoRespuesta;
	
	/**
	 * Mensaje
	 */
	private String mensaje;
	
	/**
	 * Similitud del rostro
	 */
	private BigDecimal similitudRostro;
	
	/**
	 * Similitud del nombre
	 */
	private BigDecimal similitudNombre;
	
	/**
	 * Nombre
	 */
	private String nombre;
	
	/**
	 * Apellido1
	 */
	private String apellido1;
	
	/**
	 * Apellido2
	 */
	private String apellido2;
	
	/**
	 * CURP
	 */
	private String curp;
	
	/**
	 * Sexo
	 */
	private String sexo;
	
	/**
	 * Fecha de nacimiento
	 */
	private List<String> fechaNacimiento;
	
	/**
	 * ano emision
	 */
	private String anioEmision;
	
	/**
	 * Vigencia
	 */
	private String anioVigencia;
	
	/**
	 * ocr de identificacion
	 */
	private String ocr;
	
	/**
	 * fecha de control
	 */
	private List<String> fechaControl;
	
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
	 * @return the archivoRecibido
	 */
	public ArchivoRecibido getArchivoRecibido() {
		return archivoRecibido;
	}

	/**
	 * @param archivoRecibido the archivoRecibido to set
	 */
	public void setArchivoRecibido(ArchivoRecibido archivoRecibido) {
		this.archivoRecibido = archivoRecibido;
	}

	/**
	 * @return the codigoRespuesta
	 */
	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	/**
	 * @param codigoRespuesta the codigoRespuesta to set
	 */
	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the similitudRostro
	 */
	public BigDecimal getSimilitudRostro() {
		return similitudRostro;
	}

	/**
	 * @param similitudRostro the similitudRostro to set
	 */
	public void setSimilitudRostro(BigDecimal similitudRostro) {
		this.similitudRostro = similitudRostro;
	}

	/**
	 * @return the similitudNombre
	 */
	public BigDecimal getSimilitudNombre() {
		return similitudNombre;
	}

	/**
	 * @param similitudNombre the similitudNombre to set
	 */
	public void setSimilitudNombre(BigDecimal similitudNombre) {
		this.similitudNombre = similitudNombre;
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
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public List<String> getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(List<String> fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the anioEmision
	 */
	public String getAnioEmision() {
		return anioEmision;
	}

	/**
	 * @param anioEmision the anioEmision to set
	 */
	public void setAnioEmision(String anioEmision) {
		this.anioEmision = anioEmision;
	}

	/**
	 * @return the anioVigencia
	 */
	public String getAnioVigencia() {
		return anioVigencia;
	}

	/**
	 * @param anioVigencia the anioVigencia to set
	 */
	public void setAnioVigencia(String anioVigencia) {
		this.anioVigencia = anioVigencia;
	}
	
	/**
	 * @return the ocr
	 */
	public String getOcr() {
		return ocr;
	}

	/**
	 * @param ocr the ocr to set
	 */
	public void setOcr(String ocr) {
		this.ocr = ocr;
	}

	/**
	 * @return the fechaControl
	 */
	public List<String> getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(List<String> fechaControl) {
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
		builder.append("ValidacionIdentificacion [id=");
		builder.append(id);
		builder.append(", archivoRecibido=");
		builder.append(archivoRecibido == null ? null : archivoRecibido.getId());
		builder.append(", codigoRespuesta=");
		builder.append(codigoRespuesta);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", similitudRostro=");
		builder.append(similitudRostro);
		builder.append(", similitudNombre=");
		builder.append(similitudNombre);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido1=");
		builder.append(apellido1);
		builder.append(", apellido2=");
		builder.append(apellido2);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", anioEmision=");
		builder.append(anioEmision);
		builder.append(", anioVigencia=");
		builder.append(anioVigencia);
		builder.append(", ocr=");
		builder.append(ocr);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append("]");
		return builder.toString();
	}
	
	

}
