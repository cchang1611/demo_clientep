package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase Datos Correo para el envio de correo
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class Renapo implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 2630807884360048086L;
	/**
	 * Nombre Renapo
	 */
	private String nombre;
	/**
	 * Apellido Paterno Renapo
	 */
	private String apellidoPaterno;
	/**
	 * Fecha de envio de correo
	 */
	private String apellidoMaterno;
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * fecha de nacimiento
	 */
	private String fechaNacmiento;
	/**	
	 * entidad de nacimiento
	 */
	private String entidadNacimiento;
	/**	
	 * Clave de Entidad Nacimiento
	 */
	private String cveEntidadNacimiento;
	/**
	 * sexo
	 */
	private String sexo;
	
	/**
	 * ncaionalidad
	 */
	private String nacionalidad;
	
	/**
	 * Curps historicas
	 */
	private List<String> listaCurpHistoricas;
	
	/**
	 * Curps historicas
	 */
	private String curpsHistoricas;
	/**
	 * Bandera diferencias renapo Nombre
	 */
	private Integer banderaNombre;
	/**
	 * Bandera Apellido Paterno
	 */
	private Integer banderaApellidoPaterno;
	/**
	 * Bandera Apellido Materno
	 */
	private Integer banderaApellidoMaterno;
	/**
	 * Bandera diferencias renapo Nombre
	 */
	private Integer banderaCurp;
	/**
	 * Bandera diferencias renapo genero
	 */
	private Integer banderaGenero;
	/**
	 * Bandera diferencias renapo Fecha nacimiento
	 */
	private Integer banderaFechaNacimiento;
	/**
	 * Bandera diferencias renapo Entidad nacimiento;
	 */
	private Integer banderaEntidadNacimiento;
	/**
	 * Bandera Existe CURP en RENAPO
	 */
	private Integer banderaNoExisteCurp;
	
	/**
	 * Bandera direncias nacionalidad
	 */
	private Integer banderaNacionalidad;
	
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
	 * @return the banderaNombre
	 */
	public Integer getBanderaNombre() {
		return banderaNombre;
	}

	/**
	 * @param banderaNombre the banderaNombre to set
	 */
	public void setBanderaNombre(Integer banderaNombre) {
		this.banderaNombre = banderaNombre;
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
	 * @return the banderaCurp
	 */
	public Integer getBanderaCurp() {
		return banderaCurp;
	}

	/**
	 * @param banderaCurp the banderaCurp to set
	 */
	public void setBanderaCurp(Integer banderaCurp) {
		this.banderaCurp = banderaCurp;
	}

	/**
	 * @return the fechaNacmiento
	 */
	public String getFechaNacmiento() {
		return fechaNacmiento;
	}

	/**
	 * @param fechaNacmiento the fechaNacmiento to set
	 */
	public void setFechaNacmiento(String fechaNacmiento) {
		this.fechaNacmiento = fechaNacmiento;
	}

	/**
	 * @return the entidadNacimiento
	 */
	public String getEntidadNacimiento() {
		return entidadNacimiento;
	}

	/**
	 * @param entidadNacimiento the entidadNacimiento to set
	 */
	public void setEntidadNacimiento(String entidadNacimiento) {
		this.entidadNacimiento = entidadNacimiento;
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
	 * @return the listaCurpHistoricas
	 */
	public List<String> getListaCurpHistoricas() {
		return listaCurpHistoricas;
	}

	/**
	 * @param listaCurpHistoricas the listaCurpHistoricas to set
	 */
	public void setListaCurpHistoricas(List<String> listaCurpHistoricas) {
		this.listaCurpHistoricas = listaCurpHistoricas;
	}

	/**
	 * @return the curpsHistoricas
	 */
	public String getCurpsHistoricas() {
		return curpsHistoricas;
	}

	/**
	 * @param curpsHistoricas the curpsHistoricas to set
	 */
	public void setCurpsHistoricas(String curpsHistoricas) {
		this.curpsHistoricas = curpsHistoricas;
	}

	/**
	 * @return the banderaGenero
	 */
	public Integer getBanderaGenero() {
		return banderaGenero;
	}

	/**
	 * @param banderaGenero the banderaGenero to set
	 */
	public void setBanderaGenero(Integer banderaGenero) {
		this.banderaGenero = banderaGenero;
	}

	/**
	 * @return the banderaFechaNacimiento
	 */
	public Integer getBanderaFechaNacimiento() {
		return banderaFechaNacimiento;
	}

	/**
	 * @param banderaFechaNacimiento the banderaFechaNacimiento to set
	 */
	public void setBanderaFechaNacimiento(Integer banderaFechaNacimiento) {
		this.banderaFechaNacimiento = banderaFechaNacimiento;
	}

	/**
	 * @return the banderaEntidadNacimiento
	 */
	public Integer getBanderaEntidadNacimiento() {
		return banderaEntidadNacimiento;
	}

	/**
	 * @param banderaEntidadNacimiento the banderaEntidadNacimiento to set
	 */
	public void setBanderaEntidadNacimiento(Integer banderaEntidadNacimiento) {
		this.banderaEntidadNacimiento = banderaEntidadNacimiento;
	}

	public Integer getBanderaApellidoPaterno() {
		return banderaApellidoPaterno;
	}

	public void setBanderaApellidoPaterno(Integer banderaApellidoPaterno) {
		this.banderaApellidoPaterno = banderaApellidoPaterno;
	}

	public Integer getBanderaApellidoMaterno() {
		return banderaApellidoMaterno;
	}

	public void setBanderaApellidoMaterno(Integer banderaApellidoMaterno) {
		this.banderaApellidoMaterno = banderaApellidoMaterno;
	}
	
	public Integer getBanderaNoExisteCurp() {
		return banderaNoExisteCurp;
	}

	public void setBanderaNoExisteCurp(Integer banderaNoExisteCurp) {
		this.banderaNoExisteCurp = banderaNoExisteCurp;
	}
	
	public String getCveEntidadNacimiento() {
		return cveEntidadNacimiento;
	}

	public void setCveEntidadNacimiento(String cveEntidadNacimiento) {
		this.cveEntidadNacimiento = cveEntidadNacimiento;
	}

	/**
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * @return the banderaNacionalidad
	 */
	public Integer getBanderaNacionalidad() {
		return banderaNacionalidad;
	}

	/**
	 * @param banderaNacionalidad the banderaNacionalidad to set
	 */
	public void setBanderaNacionalidad(Integer banderaNacionalidad) {
		this.banderaNacionalidad = banderaNacionalidad;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Renapo [nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", fechaNacmiento=");
		builder.append(fechaNacmiento);
		builder.append(", entidadNacimiento=");
		builder.append(entidadNacimiento);
		builder.append(", cveEntidadNacimiento=");
		builder.append(cveEntidadNacimiento);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", listaCurpHistoricas=");
		builder.append(listaCurpHistoricas);
		builder.append(", curpsHistoricas=");
		builder.append(curpsHistoricas);
		builder.append(", nacionalidad=");
		builder.append(nacionalidad);
		builder.append(", banderaNombre=");
		builder.append(banderaNombre);
		builder.append(", banderaApellidoPaterno=");
		builder.append(banderaApellidoPaterno);
		builder.append(", banderaApellidoMaterno=");
		builder.append(banderaApellidoMaterno);
		builder.append(", banderaCurp=");
		builder.append(banderaCurp);
		builder.append(", banderaGenero=");
		builder.append(banderaGenero);
		builder.append(", banderaFechaNacimiento=");
		builder.append(banderaFechaNacimiento);
		builder.append(", banderaEntidadNacimiento=");
		builder.append(banderaEntidadNacimiento);
		builder.append(", banderaNoExisteCurp=");
		builder.append(banderaNoExisteCurp);
		builder.append(", banderaNacionalidad=");
		builder.append(banderaNacionalidad);
		builder.append("]");
		return builder.toString();
	}
	
}