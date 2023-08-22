package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;




/**
 * clase que contiene los atributos de Salida del servicio de Persona
 * 
 * @author OJBALBUE
 * @version 1.0
 */
public class PersonaSalida implements Serializable {

	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 2004315395046723948L;

	/**
	 * idProcesar
	 */
	private Long idProcesar;

	/**
	 * OBJ afore
	 */
	private Afore afore;
	
	/**
	 * OBJ participante
	 */
	private Participante participante;

	/**
	 * apellidoMaterno
	 */
	private String apellidoMaterno;

	/**
	 * apellidoPaterno
	 */
	private String apellidoPaterno;

	/**
	 * nombre
	 */
	private String nombre;

	/**
	 * tipoAfiliacion
	 */
	private String tipoAfiliacion;

	/**
	 * fechaAutTraspaso
	 */
	private Date fechaAutTraspaso;

	/**
	 * fechaInicioAfore
	 */
	private Date fechaInicioAfore;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * curp
	 */
	private String curp;

	/**
	 * fechaNacimiento
	 */
	private Date fechaNacimiento;

	/**
	 * sexo
	 */
	private Sexo sexo;

	/**
	 * documentoProbatorio
	 */
	private String documentoProbatorio;

	/**
	 * folioDocProbatorio
	 */
	private String folioDocProbatorio;

	/**
	 * curpRaiz
	 */
	private String curpRaiz;

	/**
	 * claveGiro
	 */
	private String claveGiro;

	/**
	 * gradoEstudios
	 */
	private String gradoEstudios;

	/**
	 * ocupacion
	 */
	private String ocupacion;

	/**
	 * tipoAdmin
	 */
	private String tipoAdmin;

	/**
	 * tipoRegimen
	 */
	private String tipoRegimen;

	/**
	 * fechaInicioCotizacion
	 */
	private Date fechaInicioCotizacion;

	/**
	 * periodoPagoReingreso
	 */
	private Date periodoPagoReingreso;

	/**
	 * fechaPrimeraAfiliacion
	 */
	private Date fechaPrimeraAfiliacion;

	/**
	 * vencimientoBonoRendi
	 */
	private Date vencimientoBonoRendi;

	/**
	 * entidadNacimiento
	 */
	private EntidadFederativa entidadNacimiento;

	/**
	 * nacionalidad
	 */
	private Long nacionalidad;

	/**
	 * perfilSeguridad
	 */
	private Long perfilSeguridad;

	/**
	 * idTipoDoctoProbatorio
	 */
	private Long idTipoDoctoProbatorio;

	/**
	 * telefonoList
	 */
	private List<TelefonoTrabajador> telefonoList;

	/**
	 * referenciaList
	 */
	private List<ReferenciaTrabajador> referenciaList;

	/**
	 * referenciaList
	 */
	private List<NsarBeneficiario> beneficiarioList;

	/**
	 * domicilioList
	 */
	private List<NsarDomicilio> domicilioList;

	/**
	 * @return the idProcesar
	 */
	public Long getIdProcesar() {
		return idProcesar;
	}

	/**
	 * @param idProcesar
	 *            the idProcesar to set
	 */
	public void setIdProcesar(Long idProcesar) {
		this.idProcesar = idProcesar;
	}

	/**
	 * @return the afore
	 */
	public Afore getAfore() {
		return afore;
	}

	/**
	 * @param afore
	 *            the afore to set
	 */
	public void setAfore(Afore afore) {
		this.afore = afore;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno
	 *            the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *            the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the tipoAfiliacion
	 */
	public String getTipoAfiliacion() {
		return tipoAfiliacion;
	}

	/**
	 * @param tipoAfiliacion
	 *            the tipoAfiliacion to set
	 */
	public void setTipoAfiliacion(String tipoAfiliacion) {
		this.tipoAfiliacion = tipoAfiliacion;
	}

	/**
	 * @return the fechaAutTraspaso
	 */
	public Date getFechaAutTraspaso() {
		return fechaAutTraspaso;
	}

	/**
	 * @param fechaAutTraspaso
	 *            the fechaAutTraspaso to set
	 */
	public void setFechaAutTraspaso(Date fechaAutTraspaso) {
		this.fechaAutTraspaso = fechaAutTraspaso;
	}

	/**
	 * @return the fechaInicioAfore
	 */
	public Date getFechaInicioAfore() {
		return fechaInicioAfore;
	}

	/**
	 * @param fechaInicioAfore
	 *            the fechaInicioAfore to set
	 */
	public void setFechaInicioAfore(Date fechaInicioAfore) {
		this.fechaInicioAfore = fechaInicioAfore;
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss
	 *            the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp
	 *            the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the telefonoList
	 */
	public List<TelefonoTrabajador> getTelefonoList() {
		return telefonoList;
	}

	/**
	 * @param telefonoList
	 *            the telefonoList to set
	 */
	public void setTelefonoList(List<TelefonoTrabajador> telefonoList) {
		this.telefonoList = telefonoList;
	}

	/**
	 * @return the referenciaList
	 */
	public List<ReferenciaTrabajador> getReferenciaList() {
		return referenciaList;
	}

	/**
	 * @param referenciaList
	 *            the referenciaList to set
	 */
	public void setReferenciaList(List<ReferenciaTrabajador> referenciaList) {
		this.referenciaList = referenciaList;
	}

	/**
	 * @return the beneficiarioList
	 */
	public List<NsarBeneficiario> getBeneficiarioList() {
		return beneficiarioList;
	}

	/**
	 * @param beneficiarioList
	 *            the beneficiarioList to set
	 */
	public void setBeneficiarioList(List<NsarBeneficiario> beneficiarioList) {
		this.beneficiarioList = beneficiarioList;
	}

	/**
	 * @return the domicilioList
	 */
	public List<NsarDomicilio> getDomicilioList() {
		return domicilioList;
	}

	/**
	 * @param domicilioList
	 *            the domicilioList to set
	 */
	public void setDomicilioList(List<NsarDomicilio> domicilioList) {
		this.domicilioList = domicilioList;
	}

	/**
	 * @return the documentoProbatorio
	 */
	public String getDocumentoProbatorio() {
		return documentoProbatorio;
	}

	/**
	 * @param documentoProbatorio
	 *            the documentoProbatorio to set
	 */
	public void setDocumentoProbatorio(String documentoProbatorio) {
		this.documentoProbatorio = documentoProbatorio;
	}

	/**
	 * @return the folioDocProbatorio
	 */
	public String getFolioDocProbatorio() {
		return folioDocProbatorio;
	}

	/**
	 * @param folioDocProbatorio
	 *            the folioDocProbatorio to set
	 */
	public void setFolioDocProbatorio(String folioDocProbatorio) {
		this.folioDocProbatorio = folioDocProbatorio;
	}

	/**
	 * @return the curpRaiz
	 */
	public String getCurpRaiz() {
		return curpRaiz;
	}

	/**
	 * @param curpRaiz
	 *            the curpRaiz to set
	 */
	public void setCurpRaiz(String curpRaiz) {
		this.curpRaiz = curpRaiz;
	}

	/**
	 * @return the claveGiro
	 */
	public String getClaveGiro() {
		return claveGiro;
	}

	/**
	 * @param claveGiro
	 *            the claveGiro to set
	 */
	public void setClaveGiro(String claveGiro) {
		this.claveGiro = claveGiro;
	}

	/**
	 * @return the gradoEstudios
	 */
	public String getGradoEstudios() {
		return gradoEstudios;
	}

	/**
	 * @param gradoEstudios
	 *            the gradoEstudios to set
	 */
	public void setGradoEstudios(String gradoEstudios) {
		this.gradoEstudios = gradoEstudios;
	}

	/**
	 * @return the ocupacion
	 */
	public String getOcupacion() {
		return ocupacion;
	}

	/**
	 * @param ocupacion
	 *            the ocupacion to set
	 */
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	/**
	 * @return the tipoAdmin
	 */
	public String getTipoAdmin() {
		return tipoAdmin;
	}

	/**
	 * @param tipoAdmin
	 *            the tipoAdmin to set
	 */
	public void setTipoAdmin(String tipoAdmin) {
		this.tipoAdmin = tipoAdmin;
	}

	/**
	 * @return the tipoRegimen
	 */
	public String getTipoRegimen() {
		return tipoRegimen;
	}

	/**
	 * @param tipoRegimen
	 *            the tipoRegimen to set
	 */
	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}

	/**
	 * @return the fechaInicioCotizacion
	 */
	public Date getFechaInicioCotizacion() {
		return fechaInicioCotizacion;
	}

	/**
	 * @param fechaInicioCotizacion
	 *            the fechaInicioCotizacion to set
	 */
	public void setFechaInicioCotizacion(Date fechaInicioCotizacion) {
		this.fechaInicioCotizacion = fechaInicioCotizacion;
	}

	/**
	 * @return the periodoPagoReingreso
	 */
	public Date getPeriodoPagoReingreso() {
		return periodoPagoReingreso;
	}

	/**
	 * @param periodoPagoReingreso
	 *            the periodoPagoReingreso to set
	 */
	public void setPeriodoPagoReingreso(Date periodoPagoReingreso) {
		this.periodoPagoReingreso = periodoPagoReingreso;
	}

	/**
	 * @return the fechaPrimeraAfiliacion
	 */
	public Date getFechaPrimeraAfiliacion() {
		return fechaPrimeraAfiliacion;
	}

	/**
	 * @param fechaPrimeraAfiliacion
	 *            the fechaPrimeraAfiliacion to set
	 */
	public void setFechaPrimeraAfiliacion(Date fechaPrimeraAfiliacion) {
		this.fechaPrimeraAfiliacion = fechaPrimeraAfiliacion;
	}

	/**
	 * @return the vencimientoBonoRendi
	 */
	public Date getVencimientoBonoRendi() {
		return vencimientoBonoRendi;
	}

	/**
	 * @param vencimientoBonoRendi
	 *            the vencimientoBonoRendi to set
	 */
	public void setVencimientoBonoRendi(Date vencimientoBonoRendi) {
		this.vencimientoBonoRendi = vencimientoBonoRendi;
	}
	/**
	 * @return the nacionalidad
	 */
	public Long getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad
	 *            the nacionalidad to set
	 */
	public void setNacionalidad(Long nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * @return the perfilSeguridad
	 */
	public Long getPerfilSeguridad() {
		return perfilSeguridad;
	}

	/**
	 * @param perfilSeguridad
	 *            the perfilSeguridad to set
	 */
	public void setPerfilSeguridad(Long perfilSeguridad) {
		this.perfilSeguridad = perfilSeguridad;
	}

	/**
	 * @return the idTipoDoctoProbatorio
	 */
	public Long getIdTipoDoctoProbatorio() {
		return idTipoDoctoProbatorio;
	}

	/**
	 * @param idTipoDoctoProbatorio
	 *            the idTipoDoctoProbatorio to set
	 */
	public void setIdTipoDoctoProbatorio(Long idTipoDoctoProbatorio) {
		this.idTipoDoctoProbatorio = idTipoDoctoProbatorio;
	}
	

	/**
	 * @return the participante
	 */
	public Participante getParticipante() {
		return participante;
	}

	/**
	 * @param participante the participante to set
	 */
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	/**
	 * @return the entidadNacimiento
	 */
	public EntidadFederativa getEntidadNacimiento() {
		return entidadNacimiento;
	}

	/**
	 * @param entidadNacimiento the entidadNacimiento to set
	 */
	public void setEntidadNacimiento(EntidadFederativa entidadNacimiento) {
		this.entidadNacimiento = entidadNacimiento;
	}

	/**
	 * @return the sexo
	 */
	public Sexo getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonaSalida [idProcesar=");
		builder.append(idProcesar);
		builder.append(", afore=");
		builder.append(afore);
		builder.append(", participante=");
		builder.append(participante);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", tipoAfiliacion=");
		builder.append(tipoAfiliacion);
		builder.append(", fechaAutTraspaso=");
		builder.append(fechaAutTraspaso);
		builder.append(", fechaInicioAfore=");
		builder.append(fechaInicioAfore);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", documentoProbatorio=");
		builder.append(documentoProbatorio);
		builder.append(", folioDocProbatorio=");
		builder.append(folioDocProbatorio);
		builder.append(", curpRaiz=");
		builder.append(curpRaiz);
		builder.append(", claveGiro=");
		builder.append(claveGiro);
		builder.append(", gradoEstudios=");
		builder.append(gradoEstudios);
		builder.append(", ocupacion=");
		builder.append(ocupacion);
		builder.append(", tipoAdmin=");
		builder.append(tipoAdmin);
		builder.append(", tipoRegimen=");
		builder.append(tipoRegimen);
		builder.append(", fechaInicioCotizacion=");
		builder.append(fechaInicioCotizacion);
		builder.append(", periodoPagoReingreso=");
		builder.append(periodoPagoReingreso);
		builder.append(", fechaPrimeraAfiliacion=");
		builder.append(fechaPrimeraAfiliacion);
		builder.append(", vencimientoBonoRendi=");
		builder.append(vencimientoBonoRendi);
		builder.append(", entidadNacimiento=");
		builder.append(entidadNacimiento);
		builder.append(", nacionalidad=");
		builder.append(nacionalidad);
		builder.append(", perfilSeguridad=");
		builder.append(perfilSeguridad);
		builder.append(", idTipoDoctoProbatorio=");
		builder.append(idTipoDoctoProbatorio);
		builder.append(", telefonoList=");
		builder.append(telefonoList);
		builder.append(", referenciaList=");
		builder.append(referenciaList);
		builder.append(", beneficiarioList=");
		builder.append(beneficiarioList);
		builder.append(", domicilioList=");
		builder.append(domicilioList);
		builder.append("]");
		return builder.toString();
	}


}
