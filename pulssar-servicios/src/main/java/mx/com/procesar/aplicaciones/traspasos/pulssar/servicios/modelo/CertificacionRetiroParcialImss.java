package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase para la entrada de datos
 * @author ANOSORIO
 *
 */
public class CertificacionRetiroParcialImss implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -7753801455105896383L;

	/**
	 * folioDeTramiteProcesar
	 */
	private String cusTrabajador;
	
	/**
	 * folioDeTramiteProcesar
	 */
	private String folioTramiteProcesar;
	
	/**
	 * nss
	 */
	private String nss;
	
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * nombreTrabajador
	 */
	private String nombreTrabajador;
	
	/**
	 * apellidoPaterno
	 */
	private String apellidoPaterno;
	
	/**
	 * apellidoMaterno
	 */
	private String apellidoMaterno;
	
	/**
	 * tipoDePrestacion
	 */
	private String tipoPrestacion;
	
	/**
	 * claveAdminActual
	 */
	private String claveAdminActual;
	
	/**
	 * origen
	 */
	private String origen;
	
	/**
	 * idSolicitante
	 */
	private String idSolicitante;
	
	/**
	 * curpSolicitante
	 */
	private String curpSolicitante;
	
	/**
	 * selloTrabajador
	 */
	private Long selloTrabajador;
	
	/**
	 * curpAgenteServicio
	 */
	private String curpAgenteServicio;

	/**
	 * bandera para evaluar resultado
	 */
	private Boolean resultado;
	
	/**
	 * mensaje de Error 
	 */
	private String errorMensaje;
	
	/**
	 * @return the cusTrabajador
	 */
	public String getCusTrabajador() {
		return cusTrabajador;
	}

	/**
	 * @param cusTrabajador the cusTrabajador to set
	 */
	public void setCusTrabajador(String cusTrabajador) {
		this.cusTrabajador = cusTrabajador;
	}

	/**
	 * @return the folioTramiteProcesar
	 */
	public String getFolioTramiteProcesar() {
		return folioTramiteProcesar;
	}

	/**
	 * @param folioTramiteProcesar the folioTramiteProcesar to set
	 */
	public void setFolioTramiteProcesar(String folioTramiteProcesar) {
		this.folioTramiteProcesar = folioTramiteProcesar;
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss the nss to set
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
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the nombreTrabajador
	 */
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}

	/**
	 * @param nombreTrabajador the nombreTrabajador to set
	 */
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
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
	 * @return the tipoPrestacion
	 */
	public String getTipoPrestacion() {
		return tipoPrestacion;
	}

	/**
	 * @param tipoPrestacion the tipoPrestacion to set
	 */
	public void setTipoPrestacion(String tipoPrestacion) {
		this.tipoPrestacion = tipoPrestacion;
	}

	/**
	 * @return the claveAdminActual
	 */
	public String getClaveAdminActual() {
		return claveAdminActual;
	}

	/**
	 * @param claveAdminActual the claveAdminActual to set
	 */
	public void setClaveAdminActual(String claveAdminActual) {
		this.claveAdminActual = claveAdminActual;
	}

	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @return the idSolicitante
	 */
	public String getIdSolicitante() {
		return idSolicitante;
	}

	/**
	 * @param idSolicitante the idSolicitante to set
	 */
	public void setIdSolicitante(String idSolicitante) {
		this.idSolicitante = idSolicitante;
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
	 * @return the selloTrabajador
	 */
	public Long getSelloTrabajador() {
		return selloTrabajador;
	}

	/**
	 * @param selloTrabajador the selloTrabajador to set
	 */
	public void setSelloTrabajador(Long selloTrabajador) {
		this.selloTrabajador = selloTrabajador;
	}

	/**
	 * @return the curpAgenteServicio
	 */
	public String getCurpAgenteServicio() {
		return curpAgenteServicio;
	}

	/**
	 * @param curpAgenteServicio the curpAgenteServicio to set
	 */
	public void setCurpAgenteServicio(String curpAgenteServicio) {
		this.curpAgenteServicio = curpAgenteServicio;
	}
	
	/**
	 * @return the resultado
	 */
	public Boolean getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}
	
	/**
	 * @return the errorMensaje
	 */
	public String getErrorMensaje() {
		return errorMensaje;
	}

	/**
	 * @param errorMensaje the errorMensaje to set
	 */
	public void setErrorMensaje(String errorMensaje) {
		this.errorMensaje = errorMensaje;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EntradaRetiroParcial [cusTrabajador=");
		builder.append(cusTrabajador);
		builder.append(", folioTramiteProcesar=");
		builder.append(folioTramiteProcesar);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", tipoPrestacion=");
		builder.append(tipoPrestacion);
		builder.append(", claveAdminActual=");
		builder.append(claveAdminActual);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", idSolicitante=");
		builder.append(idSolicitante);
		builder.append(", curpSolicitante=");
		builder.append(curpSolicitante);
		builder.append(", selloTrabajador=");
		builder.append(selloTrabajador);
		builder.append(", curpAgenteServicio=");
		builder.append(curpAgenteServicio);
		builder.append(", resultado=");
		builder.append(resultado);
		builder.append(", errorMensaje=");
		builder.append(errorMensaje);
		builder.append("]");
		return builder.toString();
	}
}
