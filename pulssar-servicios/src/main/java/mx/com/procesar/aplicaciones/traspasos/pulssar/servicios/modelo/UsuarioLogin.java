package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * clase que contiene los atributos para la respuesta de los servicios
 * 
 * @author DBARBOSA
 * @version 1.0
 */
public class UsuarioLogin implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -1066523354154716032L;

	/**
	 * tipo de flujo
	 */
	private int flujo;
	
	/**
	 * identificador
	 */
	private Long datoUsuario;
	
	/**
	 * usuario
	 */
	private String usuario;
	
	/**
	 * solo Nombre
	 */
	private String soloNombre;
	
	/**
	 * apellido Paterno
	 */
	private String apellidoPaterno;
	
	/**
	 * apellido Materno
	 */
	private String apellidoMaterno;
	
	/**
	 * nombre completo
	 */
	private String nombre;
	
	/**
	 * afore usaurio
	 */
	private String aforeUsuario;
	
	/**
	 * foto
	 */
	private String foto;
	
	/**
	 * Roles
	 */
	private List<Rol> roles;
	
	/**
	 * estatus
	 */
	private String estatus;
	
	/**
	 * Curp del agente
	 */
	private String curpAgente;
	
	/**
	 * Curp del agente
	 */
	private List<String> tipoAgente;
	
	/**
	 * usuario numero de agente 
	 */
	private String usuarioAgente;
	
	/**
	 * Sucursal del usuario
	 */
	private String sucursal;
	
	/**
	 * Dedo sello empleado
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String dedoSello;
	
	/**
	 * motivo falta huella
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String motivoSinHuella;
	
	/**
	 * codigo fata huella
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String codigoFaltaDedo;
	
	/**
	 * @return the flujo
	 */
	public int getFlujo() {
		return flujo;
	}

	/**
	 * @param flujo the flujo to set
	 */
	public void setFlujo(int flujo) {
		this.flujo = flujo;
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
	 * @return el atributo soloNombre
	 */
	public String getSoloNombre() {
		return soloNombre;
	}

	/**
	 * @param soloNombre parametro soloNombre a actualizar
	 */
	public void setSoloNombre(String soloNombre) {
		this.soloNombre = soloNombre;
	}

	/**
	 * @return el atributo apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno parametro apellidoPaterno a actualizar
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return el atributo apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidomaterno parametro apellidoMaterno a actualizar
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the aforeUsuario
	 */
	public String getAforeUsuario() {
		return aforeUsuario;
	}

	/**
	 * @param aforeUsuario the aforeUsuario to set
	 */
	public void setAforeUsuario(String aforeUsuario) {
		this.aforeUsuario = aforeUsuario;
	}

	/**
	 * @return the roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * @return the datoUsuario
	 */
	public Long getDatoUsuario() {
		return datoUsuario;
	}

	/**
	 * @param datoUsuario the datoUsuario to set
	 */
	public void setDatoUsuario(Long datoUsuario) {
		this.datoUsuario = datoUsuario;
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
	 * @return the curpAgente
	 */
	public String getCurpAgente() {
		return curpAgente;
	}

	/**
	 * @param curpAgente the curpAgente to set
	 */
	public void setCurpAgente(String curpAgente) {
		this.curpAgente = curpAgente;
	}

	/**
	 * @return the tipoAgente
	 */
	public List<String> getTipoAgente() {
		return tipoAgente;
	}

	/**
	 * @param tipoAgente the tipoAgente to set
	 */
	public void setTipoAgente(List<String> tipoAgente) {
		this.tipoAgente = tipoAgente;
	}

	/**
	 * @return the usuarioAgente
	 */
	public String getUsuarioAgente() {
		return usuarioAgente;
	}

	/**
	 * @param usuarioAgente the usuarioAgente to set
	 */
	public void setUsuarioAgente(String usuarioAgente) {
		this.usuarioAgente = usuarioAgente;
	}
	
		/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	
	/**
	 * @return the dedoSello
	 */
	public String getDedoSello() {
		return dedoSello;
	}

	/**
	 * @param dedoSello the dedoSello to set
	 */
	public void setDedoSello(String dedoSello) {
		this.dedoSello = dedoSello;
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

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioLogin [flujo=");
		builder.append(flujo);
		builder.append(", datoUsuario=");
		builder.append(datoUsuario);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", soloNombre=");
		builder.append(soloNombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", aforeUsuario=");
		builder.append(aforeUsuario);
		builder.append(", foto=");
		builder.append(foto);
		builder.append(", roles=");
		builder.append(roles);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", curpAgente=");
		builder.append(curpAgente);
		builder.append(", tipoAgente=");
		builder.append(tipoAgente);
		builder.append(", usuarioAgente=");
		builder.append(usuarioAgente);
		builder.append(", sucursal=");
		builder.append(sucursal);
		builder.append(", dedoSello=");
		builder.append(dedoSello);
		builder.append(", motivoSinHuella=");
		builder.append(motivoSinHuella);
		builder.append(", codigoFaltaDedo=");
		builder.append(codigoFaltaDedo);
		builder.append("]");
		return builder.toString();
	}

}