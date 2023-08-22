/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * datos de intercambio de portal con expediente
 * @author jcgarces
 *
 */
public class FolioComplemento implements Serializable{
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = -6407527999872454536L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * id folio pulsar padre para azteca, hijo para generico
	 */
	private Long idFolio;
	
	/**
	 * tipo de trabajador Tipo de Trabajador: 1 IMSS, 2 ISSSTE
	 */
	private String tipoTrabajador;
	
	/**
	 * agente promotor
	 */
	private String agentePromotor;
	
	/**
	 * apeelido paterno 
	 */
	private String apellioPaterno;
	
	/**
	 * apellido materno
	 */
	private String apellidoMaterno;
	
	/**
	 * nombre
	 */
	private String nombre;
	
	/**
	 * calle
	 */
	private String calle;
	
	/**
	 * no exterior
	 */
	private String numeroExterior;
	
	/**
	 * numero interior
	 */
	private String numeroInterior;
	
	/**
	 * colonia
	 */
	private String colonia;
	
	/**
	 * municipio
	 */
	private String municipio;
	
	/**
	 * coodigo
	 */
	private String codigo;
	
	/**
	 * entidad federativa
	 */
	private String entidadFederativa;

	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * Tipo de expediente
	 */
	private String tipoProceso;
	
	/**
	 * Folio hijo
	 */
	private Long idFolioHijo;
	
	/**
	 * clave de proceso para riesgo
	 */
	private String claveProcesoRiesgo;

	/**
	 * Fecha de control
	 */
	private Date fechaControl;
	
	/**
	 * Usuario modificador
	 */
	private String usuarioModificador;
	
	/**
	 * tipo Solicitante
	 */
	private String tipoSolicitante;
	
	/**
	 * curp Solicitante
	 */
	private String curpSolicitante;
	/**
	 * cuenta Clabe
	 */
	private String cuentaClabe;
	
	/**
	 * folio procesar origen
	 */
	private String folioProcesarOrigen;

	/**
	 * nombre del conyuge
	 */
	private String nombreConyuge;
	
	/**
	 * fecha de matrimonio
	 */
	private Date fechaMatrimonio;
	
	/**
	 * sexo del conyuge
	 */
	private String sexo;
	
	/**
	 * RFC
	 */
	private String rfc;
	
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
	 * @return the idFolio
	 */
	public Long getIdFolio() {
		return idFolio;
	}

	/**
	 * @param idFolio the idFolio to set
	 */
	public void setIdFolio(Long idFolio) {
		this.idFolio = idFolio;
	}

	/**
	 * @return the tipoTrabajador
	 */
	public String getTipoTrabajador() {
		return tipoTrabajador;
	}

	/**
	 * @param tipoTrabajador the tipoTrabajador to set
	 */
	public void setTipoTrabajador(String tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}

	/**
	 * @return the agentePromotor
	 */
	public String getAgentePromotor() {
		return agentePromotor;
	}

	/**
	 * @param agentePromotor the agentePromotor to set
	 */
	public void setAgentePromotor(String agentePromotor) {
		this.agentePromotor = agentePromotor;
	}

	/**
	 * @return the apellioPaterno
	 */
	public String getApellioPaterno() {
		return apellioPaterno;
	}

	/**
	 * @param apellioPaterno the apellioPaterno to set
	 */
	public void setApellioPaterno(String apellioPaterno) {
		this.apellioPaterno = apellioPaterno;
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
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return the numeroExterior
	 */
	public String getNumeroExterior() {
		return numeroExterior;
	}

	/**
	 * @param numeroExterior the numeroExterior to set
	 */
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	/**
	 * @return the numeroInterior
	 */
	public String getNumeroInterior() {
		return numeroInterior;
	}

	/**
	 * @param numeroInterior the numeroInterior to set
	 */
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the entidadFederativa
	 */
	public String getEntidadFederativa() {
		return entidadFederativa;
	}

	/**
	 * @param entidadFederativa the entidadFederativa to set
	 */
	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
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
	 * @return the tipoProceso
	 */
	public String getTipoProceso() {
		return tipoProceso;
	}

	/**
	 * @param tipoProceso the tipoProceso to set
	 */
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	/**
	 * @return the idFolioHijo
	 */
	public Long getIdFolioHijo() {
		return idFolioHijo;
	}

	/**
	 * @param idFolioHijo the idFolioHijo to set
	 */
	public void setIdFolioHijo(Long idFolioHijo) {
		this.idFolioHijo = idFolioHijo;
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
	 * @return the claveProcesoRiesgo
	 */
	public String getClaveProcesoRiesgo() {
		return claveProcesoRiesgo;
	}

	/**
	 * @param claveProcesoRiesgo the claveProcesoRiesgo to set
	 */
	public void setClaveProcesoRiesgo(String claveProcesoRiesgo) {
		this.claveProcesoRiesgo = claveProcesoRiesgo;
	}

	/**
	 * @return the tipoSolicitante
	 */
	public String getTipoSolicitante() {
		return tipoSolicitante;
	}

	/**
	 * @param tipoSolicitante the tipoSolicitante to set
	 */
	public void setTipoSolicitante(String tipoSolicitante) {
		this.tipoSolicitante = tipoSolicitante;
	}

	/**
	 * @return the curpSolicitante
	 */
	public String getCurpSolicitante() {
		return curpSolicitante;
	}

	/**
	 * @param curpSolicitante the curpSolicitante to set
	 */
	public void setCurpSolicitante(String curpSolicitante) {
		this.curpSolicitante = curpSolicitante;
	}

	/**
	 * @return the cuentaClabe
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}

	/**
	 * @param cuentaClabe the cuentaClabe to set
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}

	/**
	 * @return the folioProcesarOrigen
	 */
	public String getFolioProcesarOrigen() {
		return folioProcesarOrigen;
	}

	/**
	 * @param folioProcesarOrigen the folioProcesarOrigen to set
	 */
	public void setFolioProcesarOrigen(String folioProcesarOrigen) {
		this.folioProcesarOrigen = folioProcesarOrigen;
	}

	/**
	 * @return el atributo rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc parametro rfc a actualizar
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	
	/**
	 * @return
	 */
	public String getNombreConyuge() {
		return nombreConyuge;
	}

	/**
	 * @param nombreConyuge
	 */
	public void setNombreConyuge(String nombreConyuge) {
		this.nombreConyuge = nombreConyuge;
	}

	/**
	 * @return
	 */
	public Date getFechaMatrimonio() {
		return fechaMatrimonio;
	}

	/**
	 * @param fechaMatrimonio
	 */
	public void setFechaMatrimonio(Date fechaMatrimonio) {
		this.fechaMatrimonio = fechaMatrimonio;
	}

	/**
	 * @return
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexoConyuge
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FolioComplemento [id=");
		builder.append(id);
		builder.append(", idFolio=");
		builder.append(idFolio);
		builder.append(", tipoTrabajador=");
		builder.append(tipoTrabajador);
		builder.append(", agentePromotor=");
		builder.append(agentePromotor);
		builder.append(", apellioPaterno=");
		builder.append(apellioPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", calle=");
		builder.append(calle);
		builder.append(", numeroExterior=");
		builder.append(numeroExterior);
		builder.append(", numeroInterior=");
		builder.append(numeroInterior);
		builder.append(", colonia=");
		builder.append(colonia);
		builder.append(", municipio=");
		builder.append(municipio);
		builder.append(", codigo=");
		builder.append(codigo);
		builder.append(", entidadFederativa=");
		builder.append(entidadFederativa);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", tipoProceso=");
		builder.append(tipoProceso);
		builder.append(", idFolioHijo=");
		builder.append(idFolioHijo);
		builder.append(", claveProcesoRiesgo=");
		builder.append(claveProcesoRiesgo);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", tipoSolicitante=");
		builder.append(tipoSolicitante);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", cuentaClabe=");
		builder.append(cuentaClabe);
		builder.append(", folioProcesarOrigen=");
		builder.append(folioProcesarOrigen);
		builder.append(", nombreConyuge=");
		builder.append(nombreConyuge);
		builder.append(", fechaMatrimonio=");
		builder.append(fechaMatrimonio);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append("]");
		return builder.toString();
	}

	
	
}
