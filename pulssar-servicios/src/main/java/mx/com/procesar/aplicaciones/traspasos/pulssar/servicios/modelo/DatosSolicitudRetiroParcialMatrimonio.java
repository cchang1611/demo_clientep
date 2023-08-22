/**
 * DatosSolicitudRetiroParcialDesempleo.java
 * Fecha de creación: Jul 19, 2019, 11:08:01 AM
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

import java.io.Serializable;

/**
 * datos de la plantilla 01 solicitud retiro parcial de desempleo
 * 
 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
 * @version 1.0
 * @since Jul 19, 2019
 */
public class DatosSolicitudRetiroParcialMatrimonio implements Serializable{
	/**
	 * serializacion
	 */
	private static final long serialVersionUID = -314863184310483024L;

	/**
	 * numero de folio
	 */
	private String numeroFolio;

	/**
	 * numero de unidad
	 */
	private String numeroUnidad;

	/**
	 * nombre del trabajador
	 */
	private String nombre;

	/**
	 * fecha de la solicitud
	 */
	private String fechaSolicitud;

	/**
	 * nss del trabajador
	 */
	private String nss;

	/**
	 * rfc del trabajador
	 */
	private String rfc;

	/**
	 * apellido paterno del trabajador
	 */
	private String apellidoPaterno;

	/**
	 * apellido materno del trabajador
	 */
	private String apellidoMaterno;

	/**
	 * fecha de nacimiento del trabajador
	 */
	private String fechaNacimiento;

	/**
	 * genero masculino p femenino
	 */
	private String genero;

	/**
	 * curp del trabajador
	 */
	private String curp;

	/**
	 * lada del telefono
	 */
	private String lada;

	/**
	 * telefono del trabajador
	 */
	private String telefono;

	/**
	 * extension del telefono
	 */
	private String extension;

	/**
	 * clave del celular
	 */
	private String claveCelular;

	/**
	 * lada del celular
	 */
	private String ladaCelular;

	/**
	 * celular del trabajdor
	 */
	private String celular;

	/**
	 * compañia del celular
	 */
	private String companiaCelular;

	/**
	 * correo electronico del trabajador
	 */
	private String email;

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
	 * país
	 */
	private String pais;

	/**
	 * poblacion
	 */
	private String poblacion;

	/**
	 * entidad federativa
	 */
	private String entidadFederativa;

	/**
	 * delegacion o municipio
	 */
	private String delegacionMunicipio;

	/**
	 * forma de pago
	 */
	private String formaPago;

	/**
	 * institucion bancaria
	 */
	private String institucionBancaria;

	/**
	 * numero de sucursal
	 */
	private String numeroSucursalBancaria;

	/**
	 * cuenta CLABE
	 */
	private String clabe;

	/**
	 * referencia de pago
	 */
	private String referenciaPago;

	/**
	 * otro medio de pago
	 */
	private String otroMedioPago;

	/**
	 * modalidad de retiro parcial por desempleo A o B
	 */
	private String modalidadRetiro;

	/**
	 * forma de entrega para la modalidad B
	 */
	private String formaEntrega;

	/**
	 * indicador de que fue asesorado
	 */
	boolean asesorado;

	/**
	 * nombre del asesor
	 */
	private String nombreAsesor;

	/**
	 * curp del asesor
	 */
	private String curpAsesor;
	
	/**
	 * firma del empleado
	 */
	private String firmaEmpleado;

	/**
	 * firma del agente
	 */
	private String firmaAgente;
	
	/**
	 * nombre del archivo PDF
	 */
	private String nombreArchivo;
	
	/**
	 * SBC de tramite A
	 */
	private String sbcTramiteA;
	
	/**
	 * SBC de tramite B
	 */
	private String sbcTramiteB;
	
	/**
	 * importe de retiro de tramite A
	 */
	private String importeRetiroTramiteA;
	
	/**
	 * importe de retiro de tramite B
	 */
	private String importeRetiroTramiteB;
	
	/**
	 * nss del cliente
	 */
	private String nssCliente;

	/**
	 * numero de sucursal
	 */
	private String numeroSucursal;
	
	/**
	 * nombre de la sucursal
	 */
	private String nombreSucursal;
	/**
	 * nombreFirma
	 */
	private String nombreFirma;
	/**
	 * apFirma
	 */
	private String apFirma;
	/**
	 * amFirma
	 */
	private String amFirma;

	
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
	 * @return el atributo numeroUnidad
	 */
	public String getNumeroUnidad() {
		return numeroUnidad;
	}

	/**
	 * @param numeroUnidad
	 *            parametro numeroUnidad a actualizar
	 */
	public void setNumeroUnidad(String numeroUnidad) {
		this.numeroUnidad = numeroUnidad;
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
	 * @return el atributo fechaSolicitud
	 */
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud
	 *            parametro fechaSolicitud a actualizar
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
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
	 * @return el atributo fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento
	 *            parametro fechaNacimiento a actualizar
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return el atributo genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero
	 *            parametro genero a actualizar
	 */
	public void setGenero(String genero) {
		this.genero = genero;
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
	 * @return el atributo lada
	 */
	public String getLada() {
		return lada;
	}

	/**
	 * @param lada
	 *            parametro lada a actualizar
	 */
	public void setLada(String lada) {
		this.lada = lada;
	}

	/**
	 * @return el atributo telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            parametro telefono a actualizar
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return el atributo extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension
	 *            parametro extension a actualizar
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return el atributo claveCelular
	 */
	public String getClaveCelular() {
		return claveCelular;
	}

	/**
	 * @param claveCelular
	 *            parametro claveCelular a actualizar
	 */
	public void setClaveCelular(String claveCelular) {
		this.claveCelular = claveCelular;
	}

	/**
	 * @return el atributo ladaCelular
	 */
	public String getLadaCelular() {
		return ladaCelular;
	}

	/**
	 * @param ladaCelular
	 *            parametro ladaCelular a actualizar
	 */
	public void setLadaCelular(String ladaCelular) {
		this.ladaCelular = ladaCelular;
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
	 * @return el atributo companiaCelular
	 */
	public String getCompaniaCelular() {
		return companiaCelular;
	}

	/**
	 * @param companiaCelular
	 *            parametro companiaCelular a actualizar
	 */
	public void setCompaniaCelular(String companiaCelular) {
		this.companiaCelular = companiaCelular;
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
	 * @return el atributo pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais
	 *            parametro pais a actualizar
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return el atributo poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * @param poblacion
	 *            parametro poblacion a actualizar
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
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
	 * @return el atributo formaPago
	 */
	public String getFormaPago() {
		return formaPago;
	}

	/**
	 * @param formaPago
	 *            parametro formaPago a actualizar
	 */
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	/**
	 * @return el atributo institucionBancaria
	 */
	public String getInstitucionBancaria() {
		return institucionBancaria;
	}

	/**
	 * @param institucionBancaria
	 *            parametro institucionBancaria a actualizar
	 */
	public void setInstitucionBancaria(String institucionBancaria) {
		this.institucionBancaria = institucionBancaria;
	}


	/**
	 * @return el atributo numeroSucursalBancaria
	 */
	public String getNumeroSucursalBancaria() {
		return numeroSucursalBancaria;
	}

	/**
	 * @param numeroSucursalBancaria parametro numeroSucursalBancaria a actualizar
	 */
	public void setNumeroSucursalBancaria(String numeroSucursalBancaria) {
		this.numeroSucursalBancaria = numeroSucursalBancaria;
	}

	/**
	 * @return el atributo clabe
	 */
	public String getClabe() {
		return clabe;
	}

	/**
	 * @param clabe
	 *            parametro clabe a actualizar
	 */
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}

	/**
	 * @return el atributo referenciaPago
	 */
	public String getReferenciaPago() {
		return referenciaPago;
	}

	/**
	 * @param referenciaPago
	 *            parametro referenciaPago a actualizar
	 */
	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
	}

	/**
	 * @return el atributo otroMedioPago
	 */
	public String getOtroMedioPago() {
		return otroMedioPago;
	}

	/**
	 * @param otroMedioPago
	 *            parametro otroMedioPago a actualizar
	 */
	public void setOtroMedioPago(String otroMedioPago) {
		this.otroMedioPago = otroMedioPago;
	}

	/**
	 * @return el atributo modalidadRetiro
	 */
	public String getModalidadRetiro() {
		return modalidadRetiro;
	}

	/**
	 * @param modalidadRetiro
	 *            parametro modalidadRetiro a actualizar
	 */
	public void setModalidadRetiro(String modalidadRetiro) {
		this.modalidadRetiro = modalidadRetiro;
	}

	/**
	 * @return el atributo formaEntrega
	 */
	public String getFormaEntrega() {
		return formaEntrega;
	}

	/**
	 * @param formaEntrega
	 *            parametro formaEntrega a actualizar
	 */
	public void setFormaEntrega(String formaEntrega) {
		this.formaEntrega = formaEntrega;
	}

	/**
	 * @return el atributo asesorado
	 */
	public boolean isAsesorado() {
		return asesorado;
	}

	/**
	 * @param asesorado
	 *            parametro asesorado a actualizar
	 */
	public void setAsesorado(boolean asesorado) {
		this.asesorado = asesorado;
	}

	/**
	 * @return el atributo nombreAsesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * @param nombreAsesor
	 *            parametro nombreAsesor a actualizar
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	/**
	 * @return el atributo curpAsesor
	 */
	public String getCurpAsesor() {
		return curpAsesor;
	}

	/**
	 * @param curpAsesor
	 *            parametro curpAsesor a actualizar
	 */
	public void setCurpAsesor(String curpAsesor) {
		this.curpAsesor = curpAsesor;
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
	
	/**
	 * @return el atributo firmaEmpleado
	 */
	public String getFirmaEmpleado() {
		return firmaEmpleado;
	}

	/**
	 * @param firmaEmpleado parametro firmaEmpleado a actualizar
	 */
	public void setFirmaEmpleado(String firmaEmpleado) {
		this.firmaEmpleado = firmaEmpleado;
	}

	
	/**
	 * @return el atributo firmaAgente
	 */
	public String getFirmaAgente() {
		return firmaAgente;
	}

	/**
	 * @param firmaAgente parametro firmaAgente a actualizar
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
	 * @return el atributo sbcTramiteA
	 */
	public String getSbcTramiteA() {
		return sbcTramiteA;
	}

	/**
	 * @param sbcTramiteA parametro sbcTramiteA a actualizar
	 */
	public void setSbcTramiteA(String sbcTramiteA) {
		this.sbcTramiteA = sbcTramiteA;
	}

	/**
	 * @return el atributo sbcTramiteB
	 */
	public String getSbcTramiteB() {
		return sbcTramiteB;
	}

	/**
	 * @param sbcTramiteB parametro sbcTramiteB a actualizar
	 */
	public void setSbcTramiteB(String sbcTramiteB) {
		this.sbcTramiteB = sbcTramiteB;
	}

	/**
	 * @return el atributo importeRetiroTramiteA
	 */
	public String getImporteRetiroTramiteA() {
		return importeRetiroTramiteA;
	}

	/**
	 * @param importeRetiroTramiteA parametro importeRetiroTramiteA a actualizar
	 */
	public void setImporteRetiroTramiteA(String importeRetiroTramiteA) {
		this.importeRetiroTramiteA = importeRetiroTramiteA;
	}

	/**
	 * @return el atributo importeRetiroTramiteB
	 */
	public String getImporteRetiroTramiteB() {
		return importeRetiroTramiteB;
	}

	/**
	 * @param importeRetiroTramiteB parametro importeRetiroTramiteB a actualizar
	 */
	public void setImporteRetiroTramiteB(String importeRetiroTramiteB) {
		this.importeRetiroTramiteB = importeRetiroTramiteB;
	}

	/**
	 * @return el atributo nssCliente
	 */
	public String getNssCliente() {
		return nssCliente;
	}

	/**
	 * @param nssCliente parametro nssCliente a actualizar
	 */
	public void setNssCliente(String nssCliente) {
		this.nssCliente = nssCliente;
	}

	/**
	 * @return el atributo numeroSucursal
	 */
	public String getNumeroSucursal() {
		return numeroSucursal;
	}

	/**
	 * @param numeroSucursal parametro numeroSucursal a actualizar
	 */
	public void setNumeroSucursal(String numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}

	/**
	 * @return el atributo nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * @param nombreSucursal parametro nombreSucursal a actualizar
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	
	/**
	 * regresa los apellidos del trabajador
	 * 
	 * @return
	 */
	public String getApellidos() {
		StringBuilder apellidos = new StringBuilder(apellidoPaterno);

		if (apellidoMaterno != null && !apellidoMaterno.trim().equals("")) {
			apellidos.append(" ").append(apellidoMaterno);
		}

		return apellidos.toString();
	}	

	/**
	 * @return el atributo nombreFirma
	 */
	public String getNombreFirma() {
		return nombreFirma;
	}

	/**
	 * @param nombreFirma parametro nombreFirma a actualizar
	 */
	public void setNombreFirma(String nombreFirma) {
		this.nombreFirma = nombreFirma;
	}

	/**
	 * @return el atributo apFirma
	 */
	public String getApFirma() {
		return apFirma;
	}

	/**
	 * @param apFirma parametro apFirma a actualizar
	 */
	public void setApFirma(String apFirma) {
		this.apFirma = apFirma;
	}

	/**
	 * @return el atributo amFirma
	 */
	public String getAmFirma() {
		return amFirma;
	}

	/**
	 * @param amFirma parametro amFirma a actualizar
	 */
	public void setAmFirma(String amFirma) {
		this.amFirma = amFirma;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosSolicitudRetiroParcialDesempleo [numeroFolio=");
		builder.append(numeroFolio);
		builder.append(", numeroUnidad=");
		builder.append(numeroUnidad);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", fechaSolicitud=");
		builder.append(fechaSolicitud);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", genero=");
		builder.append(genero);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", lada=");
		builder.append(lada);
		builder.append(", telefono=");
		builder.append(telefono);
		builder.append(", extension=");
		builder.append(extension);
		builder.append(", claveCelular=");
		builder.append(claveCelular);
		builder.append(", ladaCelular=");
		builder.append(ladaCelular);
		builder.append(", celular=");
		builder.append(celular);
		builder.append(", companiaCelular=");
		builder.append(companiaCelular);
		builder.append(", email=");
		builder.append(email);
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
		builder.append(", pais=");
		builder.append(pais);
		builder.append(", poblacion=");
		builder.append(poblacion);
		builder.append(", entidadFederativa=");
		builder.append(entidadFederativa);
		builder.append(", delegacionMunicipio=");
		builder.append(delegacionMunicipio);
		builder.append(", formaPago=");
		builder.append(formaPago);
		builder.append(", institucionBancaria=");
		builder.append(institucionBancaria);
		builder.append(", numeroSucursalBancaria=");
		builder.append(numeroSucursalBancaria);
		builder.append(", clabe=");
		builder.append(clabe);
		builder.append(", referenciaPago=");
		builder.append(referenciaPago);
		builder.append(", otroMedioPago=");
		builder.append(otroMedioPago);
		builder.append(", modalidadRetiro=");
		builder.append(modalidadRetiro);
		builder.append(", formaEntrega=");
		builder.append(formaEntrega);
		builder.append(", asesorado=");
		builder.append(asesorado);
		builder.append(", nombreAsesor=");
		builder.append(nombreAsesor);
		builder.append(", curpAsesor=");
		builder.append(curpAsesor);
		builder.append(", firmaEmpleado=");
		builder.append(firmaEmpleado);
		builder.append(", firmaAgente=");
		builder.append(firmaAgente);
		builder.append(", nombreArchivo=");
		builder.append(nombreArchivo);
		builder.append(", sbcTramiteA=");
		builder.append(sbcTramiteA);
		builder.append(", sbcTramiteB=");
		builder.append(sbcTramiteB);
		builder.append(", importeRetiroTramiteA=");
		builder.append(importeRetiroTramiteA);
		builder.append(", importeRetiroTramiteB=");
		builder.append(importeRetiroTramiteB);
		builder.append(", nssCliente=");
		builder.append(nssCliente);
		builder.append(", numeroSucursal=");
		builder.append(numeroSucursal);
		builder.append(", nombreSucursal=");
		builder.append(nombreSucursal);
		builder.append(", nombreFirma=");
		builder.append(nombreFirma);
		builder.append(", apFirma=");
		builder.append(apFirma);
		builder.append(", amFirma=");
		builder.append(amFirma);
		builder.append("]");
		return builder.toString();
	}

}
