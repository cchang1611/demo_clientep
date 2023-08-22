package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase de la sucursal Afore
 *  @author srubalca
 */

public class SucursalAfore implements Serializable{

	/**
	 * Serial de la clase
	 */
	private static final long serialVersionUID = -2822119728849604008L;
	
	/**
	 * identificador sucursal
	 */
	private Long idSucursal;
	
	/**
	 * clave de la afore
	 */
	private String claveAfore;

	/**
	 * Clave del establecimiento
	 */
	private String claveEstablecimiento;

	/**
	 * Tipo establecimiento
	 */
	private String tipoEstablecimiento;

	/**
	 * Clave zona metropolitana
	 */
	private String claveZona;

	/**
	 * Clave entidad Federativa
	 */
	private String claveEntidadFederativa;

	/**
	 * Clave delegacion o municipio
	 */
	private String claveMunicipio;

	/**
	 * Clave Inegi
	 */
	private String claveInegi;

	/**
	 * Clave Ciudad
	 */
	private String claveCiudad;

	/**
	 * Calle
	 */
	private String calle;

	/**
	 * Numero
	 */
	private String numero;

	/**
	 * Colonia
	 */
	private String colonia;

	/**
	 * Codigo Postal
	 */
	private String codigoPostal;

	/**
	 * Latitud
	 */
	private String latitud;

	/**
	 * Longitud
	 */
	private String longuitud;

	/**
	 * Telefono
	 */
	private Long telefono; 

	/**
	 * Telefono Publico
	 */
	private Long telefonoPublico;

	/**
	 * N√∫mero de ejecutivos en sucursal que exclusivamente atienden servicios distintos al traspaso
	 */
	private Integer numeroEjecutivosNoTraspasos;

	/**
	 * N√∫mero de ejecutivos en sucursal que exclusivamente realizan registros y traspasos
	 */
	private Integer numeroEjecutivosTraspasos;

	/**
	 * N√∫mero de ejecutivos en sucursal que atienden servicios y realizan registros y traspasos
	 */
	private Integer numeroEjecutivosOtroServicio;

	/**
	 * Dias de Atencion
	 */
	private String diasAtencion;

	/**
	 * Horario de atencion entre semana
	 */
	private String horarioAtencion;

	/**
	 * Horario de atencion fin de semana
	 */
	private String horarioAtencionFinSemana;

	/**
	 * Numero de horas semanal
	 */
	private Integer horaSemanal;

	/**
	 * Numero de solicitudes
	 */
	private Integer numeroSolicitudes;

	/**
	 * Facilidades
	 */
	private String facilidades;

	/**
	 * Servicios Ofrecidos
	 */
	private String serviciosOfrecidos;
	/**
	 * Fecha Contron
	 */
	private Date fechaControl;
	/**
	 * usuarioModificacion
	 */
	private String usuarioModificador;
	
	/**
	 * Servicio segun catalogo
	 */
	private String servicio;
	
	/**
	 * Numero de tramites
	 */
	private Integer tramites;
	
	/**
	 * Fecha planeada de inicio de cierre de sucursal. Äù
	 */
	private String fechaCierreInicial;
	
	/**
	 * Fecha planeada de fin de cierre de sucursal. Äù
	 */
	private String fechaCierreFinal;
	
	/**
	 * chFechaCierreInicial
	 */
	private String claveAforeSucursal;
	
	/**
	 * chFechaCierreInicial
	 */
	private String claveSucursal;
	
	/**
	 * chFechaCierreInicial
	 */
	private String nombreSucursal;
	
	/**
	 * @return the idSucursal
	 */
	public Long getIdSucursal() {
		return idSucursal;
	}

	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(Long idSucursal) {
		this.idSucursal = idSucursal;
	}

	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @param claveAfore the claveAfore to set
	 */
	public void setClaveAfore(String claveAfore) {
		this.claveAfore = claveAfore;
	}

	/**
	 * @return the claveEstablecimiento
	 */
	public String getClaveEstablecimiento() {
		return claveEstablecimiento;
	}

	/**
	 * @param claveEstablecimiento the claveEstablecimiento to set
	 */
	public void setClaveEstablecimiento(String claveEstablecimiento) {
		this.claveEstablecimiento = claveEstablecimiento;
	}

	/**
	 * @return the tipoEstablecimiento
	 */
	public String getTipoEstablecimiento() {
		return tipoEstablecimiento;
	}

	/**
	 * @param tipoEstablecimiento the tipoEstablecimiento to set
	 */
	public void setTipoEstablecimiento(String tipoEstablecimiento) {
		this.tipoEstablecimiento = tipoEstablecimiento;
	}

	/**
	 * @return the claveZona
	 */
	public String getClaveZona() {
		return claveZona;
	}

	/**
	 * @param claveZona the claveZona to set
	 */
	public void setClaveZona(String claveZona) {
		this.claveZona = claveZona;
	}

	/**
	 * @return the claveEntidadFederativa
	 */
	public String getClaveEntidadFederativa() {
		return claveEntidadFederativa;
	}

	/**
	 * @param claveEntidadFederativa the claveEntidadFederativa to set
	 */
	public void setClaveEntidadFederativa(String claveEntidadFederativa) {
		this.claveEntidadFederativa = claveEntidadFederativa;
	}

	/**
	 * @return the claveMunicipio
	 */
	public String getClaveMunicipio() {
		return claveMunicipio;
	}

	/**
	 * @param claveMunicipio the claveMunicipio to set
	 */
	public void setClaveMunicipio(String claveMunicipio) {
		this.claveMunicipio = claveMunicipio;
	}

	/**
	 * @return the claveInegi
	 */
	public String getClaveInegi() {
		return claveInegi;
	}

	/**
	 * @param claveInegi the claveInegi to set
	 */
	public void setClaveInegi(String claveInegi) {
		this.claveInegi = claveInegi;
	}

	/**
	 * @return the claveCiudad
	 */
	public String getClaveCiudad() {
		return claveCiudad;
	}

	/**
	 * @param claveCiudad the claveCiudad to set
	 */
	public void setClaveCiudad(String claveCiudad) {
		this.claveCiudad = claveCiudad;
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
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
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the latitud
	 */
	public String getLatitud() {
		return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	/**
	 * @return the longuitud
	 */
	public String getLonguitud() {
		return longuitud;
	}

	/**
	 * @param longuitud the longuitud to set
	 */
	public void setLonguitud(String longuitud) {
		this.longuitud = longuitud;
	}

	/**
	 * @return the telefono
	 */
	public Long getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the telefonoPublico
	 */
	public Long getTelefonoPublico() {
		return telefonoPublico;
	}

	/**
	 * @param telefonoPublico the telefonoPublico to set
	 */
	public void setTelefonoPublico(Long telefonoPublico) {
		this.telefonoPublico = telefonoPublico;
	}

	/**
	 * @return the numeroEjecutivosNoTraspasos
	 */
	public Integer getNumeroEjecutivosNoTraspasos() {
		return numeroEjecutivosNoTraspasos;
	}

	/**
	 * @param numeroEjecutivosNoTraspasos the numeroEjecutivosNoTraspasos to set
	 */
	public void setNumeroEjecutivosNoTraspasos(Integer numeroEjecutivosNoTraspasos) {
		this.numeroEjecutivosNoTraspasos = numeroEjecutivosNoTraspasos;
	}

	/**
	 * @return the numeroEjecutivosTraspasos
	 */
	public Integer getNumeroEjecutivosTraspasos() {
		return numeroEjecutivosTraspasos;
	}

	/**
	 * @param numeroEjecutivosTraspasos the numeroEjecutivosTraspasos to set
	 */
	public void setNumeroEjecutivosTraspasos(Integer numeroEjecutivosTraspasos) {
		this.numeroEjecutivosTraspasos = numeroEjecutivosTraspasos;
	}

	/**
	 * @return the numeroEjecutivosOtroServicio
	 */
	public Integer getNumeroEjecutivosOtroServicio() {
		return numeroEjecutivosOtroServicio;
	}

	/**
	 * @param numeroEjecutivosOtroServicio the numeroEjecutivosOtroServicio to set
	 */
	public void setNumeroEjecutivosOtroServicio(Integer numeroEjecutivosOtroServicio) {
		this.numeroEjecutivosOtroServicio = numeroEjecutivosOtroServicio;
	}

	/**
	 * @return the diasAtencion
	 */
	public String getDiasAtencion() {
		return diasAtencion;
	}

	/**
	 * @param diasAtencion the diasAtencion to set
	 */
	public void setDiasAtencion(String diasAtencion) {
		this.diasAtencion = diasAtencion;
	}

	/**
	 * @return the horarioAtencion
	 */
	public String getHorarioAtencion() {
		return horarioAtencion;
	}

	/**
	 * @param horarioAtencion the horarioAtencion to set
	 */
	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	/**
	 * @return the horarioAtencionFinSemana
	 */
	public String getHorarioAtencionFinSemana() {
		return horarioAtencionFinSemana;
	}

	/**
	 * @param horarioAtencionFinSemana the horarioAtencionFinSemana to set
	 */
	public void setHorarioAtencionFinSemana(String horarioAtencionFinSemana) {
		this.horarioAtencionFinSemana = horarioAtencionFinSemana;
	}

	/**
	 * @return the horaSemanal
	 */
	public Integer getHoraSemanal() {
		return horaSemanal;
	}

	/**
	 * @param horaSemanal the horaSemanal to set
	 */
	public void setHoraSemanal(Integer horaSemanal) {
		this.horaSemanal = horaSemanal;
	}

	/**
	 * @return the numeroSolicitudes
	 */
	public Integer getNumeroSolicitudes() {
		return numeroSolicitudes;
	}

	/**
	 * @param numeroSolicitudes the numeroSolicitudes to set
	 */
	public void setNumeroSolicitudes(Integer numeroSolicitudes) {
		this.numeroSolicitudes = numeroSolicitudes;
	}

	/**
	 * @return the facilidades
	 */
	public String getFacilidades() {
		return facilidades;
	}

	/**
	 * @param facilidades the facilidades to set
	 */
	public void setFacilidades(String facilidades) {
		this.facilidades = facilidades;
	}

	/**
	 * @return the serviciosOfrecidos
	 */
	public String getServiciosOfrecidos() {
		return serviciosOfrecidos;
	}

	/**
	 * @param serviciosOfrecidos the serviciosOfrecidos to set
	 */
	public void setServiciosOfrecidos(String serviciosOfrecidos) {
		this.serviciosOfrecidos = serviciosOfrecidos;
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
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	/**
	 * @return the tramites
	 */
	public Integer getTramites() {
		return tramites;
	}

	/**
	 * @param tramites the tramites to set
	 */
	public void setTramites(Integer tramites) {
		this.tramites = tramites;
	}

	/**
	 * @return the fechaCierreInicial
	 */
	public String getFechaCierreInicial() {
		return fechaCierreInicial;
	}

	/**
	 * @param fechaCierreInicial the fechaCierreInicial to set
	 */
	public void setFechaCierreInicial(String fechaCierreInicial) {
		this.fechaCierreInicial = fechaCierreInicial;
	}

	/**
	 * @return the fechaCierreFinal
	 */
	public String getFechaCierreFinal() {
		return fechaCierreFinal;
	}

	/**
	 * @param fechaCierreFinal the fechaCierreFinal to set
	 */
	public void setFechaCierreFinal(String fechaCierreFinal) {
		this.fechaCierreFinal = fechaCierreFinal;
	}

	/**
	 * @return the claveAforeSucursal
	 */
	public String getClaveAforeSucursal() {
		return claveAforeSucursal;
	}

	/**
	 * @param claveAforeSucursal the claveAforeSucursal to set
	 */
	public void setClaveAforeSucursal(String claveAforeSucursal) {
		this.claveAforeSucursal = claveAforeSucursal;
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
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Sobrescritura del metodo toString()
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("SucursalAfore [idSucursal=");
		cadena.append(idSucursal);
		cadena.append(", claveAfore=");
		cadena.append(claveAfore);
		cadena.append(", claveEstablecimiento=");
		cadena.append(claveEstablecimiento);
		cadena.append(", tipoEstablecimiento=");
		cadena.append(tipoEstablecimiento);
		cadena.append(", claveZona=");
		cadena.append(claveZona);
		cadena.append(", claveEntidadFederativa=");
		cadena.append(claveEntidadFederativa);
		cadena.append(", claveMunicipio=");
		cadena.append(claveMunicipio);
		cadena.append(", claveInegi=");
		cadena.append(claveInegi);
		cadena.append(", claveCiudad=");
		cadena.append(claveCiudad);
		cadena.append(", calle=");
		cadena.append(calle);
		cadena.append(", numero=");
		cadena.append(numero);
		cadena.append(", colonia=");
		cadena.append(colonia);
		cadena.append(", codigoPostal=");
		cadena.append(codigoPostal);
		cadena.append(", latitud=");
		cadena.append(latitud);
		cadena.append(", longuitud=");
		cadena.append(longuitud);
		cadena.append(", telefono=");
		cadena.append(telefono);
		cadena.append(", telefonoPublico=");
		cadena.append(telefonoPublico);
		cadena.append(", numeroEjecutivosNoTraspasos=");
		cadena.append(numeroEjecutivosNoTraspasos);
		cadena.append(", numeroEjecutivosTraspasos=");
		cadena.append(numeroEjecutivosTraspasos);
		cadena.append(", numeroEjecutivosOtroServicio=");
		cadena.append(numeroEjecutivosOtroServicio);
		cadena.append(", diasAtencion=");
		cadena.append(diasAtencion);
		cadena.append(", horarioAtencion=");
		cadena.append(horarioAtencion);
		cadena.append(", horarioAtencionFinSemana=");
		cadena.append(horarioAtencionFinSemana);
		cadena.append(", horaSemanal=");
		cadena.append(horaSemanal);
		cadena.append(", numeroSolicitudes=");
		cadena.append(numeroSolicitudes);
		cadena.append(", facilidades=");
		cadena.append(facilidades);
		cadena.append(", serviciosOfrecidos=");
		cadena.append(serviciosOfrecidos);
		cadena.append(", fechaControl=");
		cadena.append(fechaControl);
		cadena.append(", usuarioModificador=");
		cadena.append(usuarioModificador);
		cadena.append(", servicio=");
		cadena.append(servicio);
		cadena.append(", tramites=");
		cadena.append(tramites);
		cadena.append(", fechaCierreInicial=");
		cadena.append(fechaCierreInicial);
		cadena.append(", fechaCierreFinal=");
		cadena.append(fechaCierreFinal);
		cadena.append(", claveAforeSucursal=");
		cadena.append(claveAforeSucursal);
		cadena.append(", claveSucursal=");
		cadena.append(claveSucursal);
		cadena.append(", nombreSucursal=");
		cadena.append(nombreSucursal);
		cadena.append("]");
		return cadena.toString();
	}
}
