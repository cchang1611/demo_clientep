package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ProcesoDerechoCargadoEntrada;


/**
 * Respuesta del tramite
 * @author RARREOLA
 *
 */
/**
 * TODO [Agregar documentacion de la clase]
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Oct 21, 2021
 */
public class RespuestaTramite implements Serializable {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 409562416990852033L;

	
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
	 * Mensaje de error
	 */
	private String mensaje;

	/**
	 * Titulo del error
	 */
	private String titulo;

	/**
	 * Flujo del mensaje
	 */
	private int flujo;

	/**
	 * Objeto de respuesta
	 */
	private Object obRespuesta;

	/**
	 * Lista de objectos
	 */
	private List<?> lstObRespuesta;

	/**
	 * Flujo del mensaje
	 */
	private Map<String, Object> mapObject;

	/**
	 * mapString
	 */
	private Map<String, String> mapString;
	
	/**
	 * Objeto
	 */
	private ProcesoDerechoCargadoEntrada procesoNocargado;
	
	
	/**
	 * Lista de objectos
	 */
	private List<?> lstObRespuestaDos;
	/**
	 * lstObIcefas
	 */
	private List<DatosIcefaTrabajador> lstObIcefas;
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the flujo
	 */
	public int getFlujo() {
		return flujo;
	}

	/**
	 * @param flujo
	 *            the flujo to set
	 */
	public void setFlujo(int flujo) {
		this.flujo = flujo;
	}

	/**
	 * @return the obRespuesta
	 */
	public Object getObRespuesta() {
		return obRespuesta;
	}

	/**
	 * @param obRespuesta
	 *            the obRespuesta to set
	 */
	public void setObRespuesta(Object obRespuesta) {
		this.obRespuesta = obRespuesta;
	}

	/**
	 * @return the lstObRespuesta
	 */
	public List<?> getLstObRespuesta() {
		return lstObRespuesta;
	}

	/**
	 * @param lstObRespuesta
	 *            the lstObRespuesta to set
	 */
	public void setLstObRespuesta(List<?> lstObRespuesta) {
		this.lstObRespuesta = lstObRespuesta;
	}

	/**
	 * @return the mapObject
	 */
	public Map<String, Object> getMapObject() {
		return mapObject;
	}

	/**
	 * @param mapObject
	 *            the mapObject to set
	 */
	public void setMapObject(Map<String, Object> mapObject) {
		this.mapObject = mapObject;
	}

	
	
	/**
	 * @return el atributo mapString
	 */
	public Map<String, String> getMapString() {
		return mapString;
	}

	/**
	 * @param mapString parametro mapString a actualizar
	 */
	public void setMapString(Map<String, String> mapString) {
		this.mapString = mapString;
	}

	/**
	 * @return el atributo numeroFolio
	 */
	public String getNumeroFolio() {
		return numeroFolio;
	}

	/**
	 * @param numeroFolio parametro numeroFolio a actualizar
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
	 * @param numeroUnidad parametro numeroUnidad a actualizar
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
	 * @param nombre parametro nombre a actualizar
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
	 * @param fechaSolicitud parametro fechaSolicitud a actualizar
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
	 * @param nss parametro nss a actualizar
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
	 * @param rfc parametro rfc a actualizar
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
	 * @param apellidoMaterno parametro apellidoMaterno a actualizar
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
	 * @param fechaNacimiento parametro fechaNacimiento a actualizar
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
	 * @param genero parametro genero a actualizar
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
	 * @param curp parametro curp a actualizar
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
	 * @param lada parametro lada a actualizar
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
	 * @param telefono parametro telefono a actualizar
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
	 * @param extension parametro extension a actualizar
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
	 * @param claveCelular parametro claveCelular a actualizar
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
	 * @param ladaCelular parametro ladaCelular a actualizar
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
	 * @param celular parametro celular a actualizar
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
	 * @param companiaCelular parametro companiaCelular a actualizar
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
	 * @param email parametro email a actualizar
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
	 * @param calle parametro calle a actualizar
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
	 * @param colonia parametro colonia a actualizar
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
	 * @param numeroExterior parametro numeroExterior a actualizar
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
	 * @param numeroInterior parametro numeroInterior a actualizar
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
	 * @param codigoPostal parametro codigoPostal a actualizar
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
	 * @param pais parametro pais a actualizar
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
	 * @param poblacion parametro poblacion a actualizar
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
	 * @param entidadFederativa parametro entidadFederativa a actualizar
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
	 * @param delegacionMunicipio parametro delegacionMunicipio a actualizar
	 */
	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}

	/**
	 * @return el atributo formaEntrega
	 */
	public String getFormaEntrega() {
		return formaEntrega;
	}

	/**
	 * @param formaEntrega parametro formaEntrega a actualizar
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
	 * @param asesorado parametro asesorado a actualizar
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
	 * @param nombreAsesor parametro nombreAsesor a actualizar
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
	 * @param curpAsesor parametro curpAsesor a actualizar
	 */
	public void setCurpAsesor(String curpAsesor) {
		this.curpAsesor = curpAsesor;
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
	 * @return el atributo procesoNocargado
	 */
	public ProcesoDerechoCargadoEntrada getProcesoNocargado() {
		return procesoNocargado;
	}

	/**
	 * @param procesoNocargado parametro procesoNocargado a actualizar
	 */
	public void setProcesoNocargado(ProcesoDerechoCargadoEntrada procesoNocargado) {
		this.procesoNocargado = procesoNocargado;
	}
	
	
	

	/**
	 * @return the lstObRespuestaDos
	 */
	public List<?> getLstObRespuestaDos() {
		return lstObRespuestaDos;
	}

	/**
	 * @param lstObRespuestaDos the lstObRespuestaDos to set
	 */
	public void setLstObRespuestaDos(List<?> lstObRespuestaDos) {
		this.lstObRespuestaDos = lstObRespuestaDos;
	}

	/**
	 * @return el atributo lstObIcefas
	 */
	public List<DatosIcefaTrabajador> getLstObIcefas() {
		return lstObIcefas;
	}

	/**
	 * @param lstObIcefas parametro lstObIcefas a actualizar
	 */
	public void setLstObIcefas(List<DatosIcefaTrabajador> lstObIcefas) {
		this.lstObIcefas = lstObIcefas;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RespuestaTramite [numeroFolio=");
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
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", flujo=");
		builder.append(flujo);
		builder.append(", obRespuesta=");
		builder.append(obRespuesta);
		builder.append(", lstObRespuesta=");
		builder.append(lstObRespuesta);
		builder.append(", mapObject=");
		builder.append(mapObject);
		builder.append(", mapString=");
		builder.append(mapString);
		builder.append(", procesoNocargado=");
		builder.append(procesoNocargado);
		builder.append(", lstObRespuestaDos=");
		builder.append(lstObRespuestaDos);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
