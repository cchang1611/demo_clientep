package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;

/**
 * 
 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
 * @version 1.0
 * @since Mar 6, 2019
 */
public class Canase implements Serializable {

	/**
	 * serializacion
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * identificador unico procesar
	 */
	private Long id;

	/**
	 * CLAVE MES DE NACIMIENTO IMSS
	 */
	private String mesNacimiento;

	/**
	 * NOMBRE SEGUN IMSS
	 */
	private String nombreImss;

	/**
	 * Sexo "M" o "F"
	 */
	private String sexo;

	/**
	 * usuario de ultima modificacion
	 */
	private String usuarioModificador;

	/**
	 * CLASIFICACION DEL NSS
	 */
	private String clasificacionNss;

	/**
	 * CLAVE DE REGISTRO POBLACIONAL CURP OFICIAL
	 */
	private String curp;

	/**
	 * CLAVE ULTIMA TRANSACCION PROCANASE
	 */
	private String claveUltimaTransaccion;

	/**
	 * FECHA ALTA EN PROCANASE
	 */
	private Date fechaAlta;

	/**
	 * Fecha de ultima modificacion
	 */
	private Date fechaControl;

	/**
	 * FECHA ULTIMA TRANSACCION PROCANASE
	 */
	private Date fechaUltimaTransaccion;

	/**
	 * identificador de entidad de nacimiento
	 */
	private EntidadFederativa entidadNacimiento;

	/**
	 * NUMERO DE SEGURIDAD SOCIAL OFICIAL NSS
	 */
	private String nss;

	/**
	 * REGISTRO PATRONAL
	 */
	private String registroPatronal;

	/**
	 * PERIODO DE PAGO
	 */
	private String periodoPago;

	/**
	 * SALARIO DIARIO INTEGRADO
	 */
	private BigDecimal salarioDiarioIntegrado;

	/**
	 * NSS_UNIFICADOR
	 */
	private String nssUnificador;

	/**
	 * STATUS DE MARCAS INDICA PROCESOS EFECTUANDOSE
	 */
	private Long statusMarca;

	/**
	 * Registro Federal De Contribuyentes.
	 */
	private String rfc;

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Indeitificador unico procesar
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Identificador
	 *            unico procesar
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return CLAVE MES DE NACIMIENTO IMSS
	 */
	public String getMesNacimiento() {
		String meses [] = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
		String mes = "";
		if(mesNacimiento == null){
			return "";
		} else {
			try {
				Integer parseo = Integer.parseInt(mesNacimiento) - 1;
				if(parseo >= NumerosConstants.INT_CERO) {
					mes = meses[parseo];
				}
			} catch (Exception e) {
				mes = "";
			}
		}
		return mes;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param CLAVE
	 *            MES DE NACIMIENTO IMSS
	 */
	public void setMesNacimiento(String mesNacimiento) {
		this.mesNacimiento = mesNacimiento;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return NOMBRE SEGUN IMSS
	 */
	public String getNombreImss() {
		if(nombreImss == null){
			return "";
		} else {
			return nombreImss;
		}
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param NOMBRE
	 *            SEGUN IMSS
	 */
	public void setNombreImss(String nombreImss) {
		this.nombreImss = nombreImss;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Sexo "M" o "F"
	 */
	public String getSexo() {
		if (sexo != null) {
			if (sexo.equals("M")) {
				sexo = "Masculino";
			}else if(sexo.equals("F")){
				sexo = "Femenino";
			}
		} else {
			sexo = "";
		}
		return sexo;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Sexo
	 *            "M" o "F"
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return usuario de ultima modificacion
	 */
	public String getUsuarioModificador() {
		return usuarioModificador;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param usuario
	 *            de ultima modificacion
	 */
	public void setUsuarioModificador(String usuarioModificador) {
		this.usuarioModificador = usuarioModificador;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return CLASIFICACION DEL NSS
	 */
	public String getClasificacionNss() {
		return clasificacionNss;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param CLASIFICACION
	 *            DEL NSS
	 */
	public void setClasificacionNss(String clasificacionNss) {
		this.clasificacionNss = clasificacionNss;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return CLAVE DE REGISTRO POBLACIONAL CURP OFICIAL
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param CLAVE
	 *            DE REGISTRO POBLACIONAL CURP OFICIAL
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return CLAVE ULTIMA TRANSACCION PROCANASE
	 */
	public String getClaveUltimaTransaccion() {
		return claveUltimaTransaccion;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param CLAVE
	 *            ULTIMA TRANSACCION PROCANASE
	 */
	public void setClaveUltimaTransaccion(String claveUltimaTransaccion) {
		this.claveUltimaTransaccion = claveUltimaTransaccion;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return FECHA ALTA EN PROCANASE
	 */
	public String getFechaAlta() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return fechaAlta == null ? "" : sdf.format(fechaAlta);

//		return fechaAlta;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param FECHA
	 *            ALTA EN PROCANASE
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Fecha de ultima modificacion
	 */
	public Date getFechaControl() {
		return fechaControl;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Fecha
	 *            de ultima modificacion
	 */
	public void setFechaControl(Date fechaControl) {
		this.fechaControl = fechaControl;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return FECHA ULTIMA TRANSACCION PROCANASE
	 */
	public String getFechaUltimaTransaccion() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return fechaUltimaTransaccion == null ? "" : sdf.format(fechaUltimaTransaccion);
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param FECHA
	 *            ULTIMA TRANSACCION PROCANASE
	 */
	public void setFechaUltimaTransaccion(Date fechaUltimaTransaccion) {
		this.fechaUltimaTransaccion = fechaUltimaTransaccion;
	}


	/**
	 * @return el atributo entidadNacimiento
	 */
	public EntidadFederativa getEntidadNacimiento() {
		return entidadNacimiento;
	}

	/**
	 * @param entidadNacimiento parametro entidadNacimiento a actualizar
	 */
	public void setEntidadNacimiento(EntidadFederativa entidadNacimiento) {
		this.entidadNacimiento = entidadNacimiento;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return NUMERO DE SEGURIDAD SOCIAL OFICIAL NSS
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param NUMERO
	 *            DE SEGURIDAD SOCIAL OFICIAL NSS
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return REGISTRO PATRONAL
	 */
	public String getRegistroPatronal() {
		return registroPatronal;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param REGISTRO
	 *            PATRONAL
	 */
	public void setRegistroPatronal(String registroPatronal) {
		this.registroPatronal = registroPatronal;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return PERIODO DE PAGO
	 */
	public String getPeriodoPago() {
		return periodoPago;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param PERIODO
	 *            DE PAGO
	 */
	public void setPeriodoPago(String periodoPago) {
		this.periodoPago = periodoPago;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return SALARIO DIARIO INTEGRADO
	 */
	public BigDecimal getSalarioDiarioIntegrado() {
		return salarioDiarioIntegrado;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param SALARIO
	 *            DIARIO INTEGRADO
	 */
	public void setSalarioDiarioIntegrado(BigDecimal salarioDiarioIntegrado) {
		this.salarioDiarioIntegrado = salarioDiarioIntegrado;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return NSS_UNIFICADOR
	 */
	public String getNssUnificador() {
		return nssUnificador;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param NSS_UNIFICADOR
	 */
	public void setNssUnificador(String nssUnificador) {
		this.nssUnificador = nssUnificador;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return STATUS DE MARCAS INDICA PROCESOS EFECTUANDOSE
	 */
	public Long getStatusMarca() {
		return statusMarca;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param STATUS
	 *            DE MARCAS INDICA PROCESOS EFECTUANDOSE
	 */
	public void setStatusMarca(Long statusMarca) {
		this.statusMarca = statusMarca;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @return Registro Federal De Contribuyentes.
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * 
	 * @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 * @param Registro
	 *            Federal De Contribuyentes.
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Canase [id=");
		builder.append(id);
		builder.append(", mesNacimiento=");
		builder.append(mesNacimiento);
		builder.append(", nombreImss=");
		builder.append(nombreImss);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", usuarioModificador=");
		builder.append(usuarioModificador);
		builder.append(", clasificacionNss=");
		builder.append(clasificacionNss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", claveUltimaTransaccion=");
		builder.append(claveUltimaTransaccion);
		builder.append(", fechaAlta=");
		builder.append(fechaAlta);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append(", fechaUltimaTransaccion=");
		builder.append(fechaUltimaTransaccion);
		builder.append(", entidadNacimiento=");
		builder.append(entidadNacimiento);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", registroPatronal=");
		builder.append(registroPatronal);
		builder.append(", periodoPago=");
		builder.append(periodoPago);
		builder.append(", salarioDiarioIntegrado=");
		builder.append(salarioDiarioIntegrado);
		builder.append(", nssUnificador=");
		builder.append(nssUnificador);
		builder.append(", statusMarca=");
		builder.append(statusMarca);
		builder.append(", rfc=");
		builder.append(rfc + " ]");
		return builder.toString();
	}

}
