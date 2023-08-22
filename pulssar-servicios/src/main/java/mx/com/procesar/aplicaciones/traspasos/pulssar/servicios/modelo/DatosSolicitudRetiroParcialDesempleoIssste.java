/**
 * DatosSolicitudRetiroParcialDesempleoIssste.java
 * Fecha de creación: Nov 4, 2019, 7:26:53 PM
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

/**
 * datos para la solicitud disposicion parcail issste
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Nov 4, 2019
 */
public class DatosSolicitudRetiroParcialDesempleoIssste {
	/**
	 * numero de folio
	 */
	private String numeroFolio;

	/**
	 * ventanilla
	 */
	private String ventanilla;

	/**
	 * nombre trabajador
	 */
	private String nombre;

	/**
	 * apellido paterno
	 */
	private String apellidoPaterno;

	/**
	 * apellido materno
	 */
	private String apellidoMaterno;

	/**
	 * curp
	 */
	private String curp;

	/**
	 * nss
	 */
	private String nss;

	/**
	 * nti
	 */
	private String nti;

	/**
	 * rfc
	 */
	private String rfc;

	/**
	 * calle
	 */
	private String calle;

	/**
	 * colonia
	 */
	private String colonia;

	/**
	 * numero exterior
	 */
	private String numeroExterior;

	/**
	 * número interior
	 */
	private String numeroInterior;

	/**
	 * código postal
	 */
	private String codigoPostal;

	/**
	 * poblacion
	 */
	private String ciudad;

	/**
	 * entidad federativa
	 */
	private String entidadFederativa;

	/**
	 * delegacion o municipio
	 */
	private String delegacionMunicipio;

	/**
	 * datos de contacto uno
	 */
	private DatosContactoIssste contactoUno;

	/**
	 * datos de contacto dos
	 */
	private DatosContactoIssste contactoDos;

	/**
	 * celular
	 */
	private String celular;

	/**
	 * email
	 */
	private String email;

	/**
	 * bandera autoriza recibir estado de cuenta
	 */
	private boolean autorizaRecibirEstadoCuenta;

	/**
	 * bandera autoriza recibir informacion por mensajes sms
	 */
	private boolean autorizaRecibirMensajesSms;

	/**
	 * bandera autoriza recibir información de difusión
	 */
	private boolean autorizaRecibirInformacion;

	/**
	 * solicitud de servicio
	 */
	private String solicitudServicio;

	/**
	 * documentacion entregada
	 */
	private String documentacionEntregada;

	/**
	 * datos del beneficiario
	 */
	private DatosBeneficiarioIssste beneficiario;

	/**
	 * nombre del agente
	 */
	private String nombreAgente;

	/**
	 * firma del trabajador
	 */
	private String firmaTrabajador;

	/**
	 * firma del agente
	 */
	private String firmaAgente;
	
	/**
	 * nombre del archivo
	 */
	private String nombreArchivo;

	/**
	 * @return el atributo numeroFolio
	 */
	public String getNumeroFolio() {
		return numeroFolio;
	}

	/**
	 * @param numeroFolio
	 *            parametro numeroFolio a actualizar
	 */
	public void setNumeroFolio(String numeroFolio) {
		this.numeroFolio = numeroFolio;
	}

	/**
	 * @return el atributo ventanilla
	 */
	public String getVentanilla() {
		return ventanilla;
	}

	/**
	 * @param ventanilla
	 *            parametro ventanilla a actualizar
	 */
	public void setVentanilla(String ventanilla) {
		this.ventanilla = ventanilla;
	}

	/**
	 * @return el atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            parametro nombre a actualizar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el atributo apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno
	 *            parametro apellidoPaterno a actualizar
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
	 * @param apellidoMaterno
	 *            parametro apellidoMaterno a actualizar
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return el atributo curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp
	 *            parametro curp a actualizar
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss
	 *            parametro nss a actualizar
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return el atributo nti
	 */
	public String getNti() {
		return nti;
	}

	/**
	 * @param nti
	 *            parametro nti a actualizar
	 */
	public void setNti(String nti) {
		this.nti = nti;
	}

	/**
	 * @return el atributo rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc
	 *            parametro rfc a actualizar
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return el atributo calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle
	 *            parametro calle a actualizar
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return el atributo colonia
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * @param colonia
	 *            parametro colonia a actualizar
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * @return el atributo numeroExterior
	 */
	public String getNumeroExterior() {
		return numeroExterior;
	}

	/**
	 * @param numeroExterior
	 *            parametro numeroExterior a actualizar
	 */
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	/**
	 * @return el atributo numeroInterior
	 */
	public String getNumeroInterior() {
		return numeroInterior;
	}

	/**
	 * @param numeroInterior
	 *            parametro numeroInterior a actualizar
	 */
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	/**
	 * @return el atributo codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal
	 *            parametro codigoPostal a actualizar
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return el atributo ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad
	 *            parametro ciudad a actualizar
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return el atributo entidadFederativa
	 */
	public String getEntidadFederativa() {
		return entidadFederativa;
	}

	/**
	 * @param entidadFederativa
	 *            parametro entidadFederativa a actualizar
	 */
	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	/**
	 * @return el atributo delegacionMunicipio
	 */
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}

	/**
	 * @param delegacionMunicipio
	 *            parametro delegacionMunicipio a actualizar
	 */
	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}

	/**
	 * @return el atributo contactoUno
	 */
	public DatosContactoIssste getContactoUno() {
		return contactoUno;
	}

	/**
	 * @param contactoUno
	 *            parametro contactoUno a actualizar
	 */
	public void setContactoUno(DatosContactoIssste contactoUno) {
		this.contactoUno = contactoUno;
	}

	/**
	 * @return el atributo contactoDos
	 */
	public DatosContactoIssste getContactoDos() {
		return contactoDos;
	}

	/**
	 * @param contactoDos
	 *            parametro contactoDos a actualizar
	 */
	public void setContactoDos(DatosContactoIssste contactoDos) {
		this.contactoDos = contactoDos;
	}

	/**
	 * @return el atributo celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular
	 *            parametro celular a actualizar
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return el atributo email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            parametro email a actualizar
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return el atributo autorizaRecibirEstadoCuenta
	 */
	public boolean isAutorizaRecibirEstadoCuenta() {
		return autorizaRecibirEstadoCuenta;
	}

	/**
	 * @param autorizaRecibirEstadoCuenta
	 *            parametro autorizaRecibirEstadoCuenta a actualizar
	 */
	public void setAutorizaRecibirEstadoCuenta(boolean autorizaRecibirEstadoCuenta) {
		this.autorizaRecibirEstadoCuenta = autorizaRecibirEstadoCuenta;
	}

	/**
	 * @return el atributo autorizaRecibirMensajesSms
	 */
	public boolean isAutorizaRecibirMensajesSms() {
		return autorizaRecibirMensajesSms;
	}

	/**
	 * @param autorizaRecibirMensajesSms
	 *            parametro autorizaRecibirMensajesSms a actualizar
	 */
	public void setAutorizaRecibirMensajesSms(boolean autorizaRecibirMensajesSms) {
		this.autorizaRecibirMensajesSms = autorizaRecibirMensajesSms;
	}

	/**
	 * @return el atributo autorizaRecibirInformacion
	 */
	public boolean isAutorizaRecibirInformacion() {
		return autorizaRecibirInformacion;
	}

	/**
	 * @param autorizaRecibirInformacion
	 *            parametro autorizaRecibirInformacion a actualizar
	 */
	public void setAutorizaRecibirInformacion(boolean autorizaRecibirInformacion) {
		this.autorizaRecibirInformacion = autorizaRecibirInformacion;
	}

	/**
	 * @return el atributo solicitudServicio
	 */
	public String getSolicitudServicio() {
		return solicitudServicio;
	}

	/**
	 * @param solicitudServicio
	 *            parametro solicitudServicio a actualizar
	 */
	public void setSolicitudServicio(String solicitudServicio) {
		this.solicitudServicio = solicitudServicio;
	}

	/**
	 * @return el atributo documentacionEntregada
	 */
	public String getDocumentacionEntregada() {
		return documentacionEntregada;
	}

	/**
	 * @param documentacionEntregada
	 *            parametro documentacionEntregada a actualizar
	 */
	public void setDocumentacionEntregada(String documentacionEntregada) {
		this.documentacionEntregada = documentacionEntregada;
	}

	/**
	 * @return el atributo beneficiario
	 */
	public DatosBeneficiarioIssste getBeneficiario() {
		return beneficiario;
	}

	/**
	 * @param beneficiario
	 *            parametro beneficiario a actualizar
	 */
	public void setBeneficiario(DatosBeneficiarioIssste beneficiario) {
		this.beneficiario = beneficiario;
	}

	/**
	 * @return el atributo nombreAgente
	 */
	public String getNombreAgente() {
		return nombreAgente;
	}

	/**
	 * @param nombreAgente
	 *            parametro nombreAgente a actualizar
	 */
	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

	/**
	 * @return el atributo firmaTrabajador
	 */
	public String getFirmaTrabajador() {
		return firmaTrabajador;
	}

	/**
	 * @param firmaTrabajador
	 *            parametro firmaTrabajador a actualizar
	 */
	public void setFirmaTrabajador(String firmaTrabajador) {
		this.firmaTrabajador = firmaTrabajador;
	}

	/**
	 * @return el atributo firmaAgente
	 */
	public String getFirmaAgente() {
		return firmaAgente;
	}

	/**
	 * @param firmaAgente
	 *            parametro firmaAgente a actualizar
	 */
	public void setFirmaAgente(String firmaAgente) {
		this.firmaAgente = firmaAgente;
	}
	

	/**
	 * @return el atributo nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo parametro nombreArchivo a actualizar
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	/**
	 * regresa el nombre completo del trabajador
	 * 
	 * @return
	 */
	public String getNombreCompleto() {
		StringBuilder nombreCompleto = new StringBuilder(nombre);
		nombreCompleto.append(" ").append(apellidoPaterno);

		if (apellidoMaterno != null && !apellidoMaterno.trim().equals("")) {
			nombreCompleto.append(" ").append(apellidoMaterno);
		}

		return nombreCompleto.toString();
	}	

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosSolicitudRetiroParcialDesempleoIssste [numeroFolio=");
		builder.append(numeroFolio);
		builder.append(", ventanilla=");
		builder.append(ventanilla);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", nti=");
		builder.append(nti);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", calle=");
		builder.append(calle);
		builder.append(", colonia=");
		builder.append(colonia);
		builder.append(", numeroExterior=");
		builder.append(numeroExterior);
		builder.append(", numeroInterior=");
		builder.append(numeroInterior);
		builder.append(", codigoPostal=");
		builder.append(codigoPostal);
		builder.append(", ciudad=");
		builder.append(ciudad);
		builder.append(", entidadFederativa=");
		builder.append(entidadFederativa);
		builder.append(", delegacionMunicipio=");
		builder.append(delegacionMunicipio);
		builder.append(", contactoUno=");
		builder.append(contactoUno);
		builder.append(", contactoDos=");
		builder.append(contactoDos);
		builder.append(", celular=");
		builder.append(celular);
		builder.append(", email=");
		builder.append(email);
		builder.append(", autorizaRecibirEstadoCuenta=");
		builder.append(autorizaRecibirEstadoCuenta);
		builder.append(", autorizaRecibirMensajesSms=");
		builder.append(autorizaRecibirMensajesSms);
		builder.append(", autorizaRecibirInformacion=");
		builder.append(autorizaRecibirInformacion);
		builder.append(", solicitudServicio=");
		builder.append(solicitudServicio);
		builder.append(", documentacionEntregada=");
		builder.append(documentacionEntregada);
		builder.append(", beneficiario=");
		builder.append(beneficiario);
		builder.append(", nombreAgente=");
		builder.append(nombreAgente);
		builder.append(", firmaTrabajador=");
		builder.append(firmaTrabajador);
		builder.append(", firmaAgente=");
		builder.append(firmaAgente);
		builder.append(", nombreArchivo=");
		builder.append(nombreArchivo);
		builder.append("]");
		return builder.toString();
	}



}
