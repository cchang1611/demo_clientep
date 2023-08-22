/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Clase encargada de obtener los datos de Icefas del trabajador
 * @author lvgonzal
 *
 */
public class DatosIcefaTrabajador implements Serializable{

	/**
	 * Sarial ID
	 */
	private static final long serialVersionUID = -4652200738432546151L;
	
	/**
	 * nombre
	 */
	private String nombre;
	
	/**
	 * apellidoPaterno
	 */
	private String apellidoPaterno;
	
	/**
	 * apellidoMaterno
	 */
	private String apellidoMaterno;
	
	/**
	 * nombreTrabajador
	 */
	private String nombreTrabajador;
	
	/**
	 * fechaNacimiento
	 */
	private String fechaNacimiento;
	
	/**
	 * rfc
	 */
	private String rfc;
	
	/**
	 * nss
	 */
	private String nss;
		
	/**
	 * curp
	 */
	private String curp;
	
	/**
	 * icefa
	 */
	private String icefa ;
	
	/**
	 * controlInterno
	 */
	private String controlInterno;
	
	/**
	 * nombreBanco
	 */
	private String nombreBanco;
	
	/**
	 * nombrePatron
	 */
	private String nombrePatron;
	
	/**
	 * rfcPatron
	 */
	private String rfcPatron;
	
	/**
	 * situacionLegal
	 */
	private String situacionLegal;
	
	/**
	 * movimientoRealizado
	 */
	private String movimientoRealizado;
	
	/**
	 * movimientoActual
	 */
	private String movimientoActual;
	
	/**
	 * indicadorSaldo
	 */
	private String indicadorSaldo;

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
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
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
	 * @return the icefa
	 */
	public String getIcefa() {
		return icefa;
	}

	/**
	 * @param icefa the icefa to set
	 */
	public void setIcefa(String icefa) {
		this.icefa = icefa;
	}

	/**
	 * @return the controlInterno
	 */
	public String getControlInterno() {
		return controlInterno;
	}

	/**
	 * @param controlInterno the controlInterno to set
	 */
	public void setControlInterno(String controlInterno) {
		this.controlInterno = controlInterno;
	}

	/**
	 * @return the nombreBanco
	 */
	public String getNombreBanco() {
		return nombreBanco;
	}

	/**
	 * @param nombreBanco the nombreBanco to set
	 */
	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	/**
	 * @return the nombrePatron
	 */
	public String getNombrePatron() {
		return nombrePatron;
	}

	/**
	 * @param nombrePatron the nombrePatron to set
	 */
	public void setNombrePatron(String nombrePatron) {
		this.nombrePatron = nombrePatron;
	}

	/**
	 * @return the rfcPatron
	 */
	public String getRfcPatron() {
		return rfcPatron;
	}

	/**
	 * @param rfcPatron the rfcPatron to set
	 */
	public void setRfcPatron(String rfcPatron) {
		this.rfcPatron = rfcPatron;
	}

	/**
	 * @return the situacionLegal
	 */
	public String getSituacionLegal() {
		return situacionLegal;
	}

	/**
	 * @param situacionLegal the situacionLegal to set
	 */
	public void setSituacionLegal(String situacionLegal) {
		this.situacionLegal = situacionLegal;
	}

	/**
	 * @return the movimientoRealizado
	 */
	public String getMovimientoRealizado() {
		return movimientoRealizado;
	}

	/**
	 * @param movimientoRealizado the movimientoRealizado to set
	 */
	public void setMovimientoRealizado(String movimientoRealizado) {
		this.movimientoRealizado = movimientoRealizado;
	}

	/**
	 * @return the movimientoActual
	 */
	public String getMovimientoActual() {
		return movimientoActual;
	}

	/**
	 * @param movimientoActual the movimientoActual to set
	 */
	public void setMovimientoActual(String movimientoActual) {
		this.movimientoActual = movimientoActual;
	}

	/**
	 * @return the indicadorSaldo
	 */
	public String getIndicadorSaldo() {
		return indicadorSaldo;
	}

	/**
	 * @param indicadorSaldo the indicadorSaldo to set
	 */
	public void setIndicadorSaldo(String indicadorSaldo) {
		this.indicadorSaldo = indicadorSaldo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosIcefaTrabajador [nombre=");
		builder.append(nombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", nombreTrabajador=");
		builder.append(nombreTrabajador);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", rfc=");
		builder.append(rfc);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", icefa=");
		builder.append(icefa);
		builder.append(", controlInterno=");
		builder.append(controlInterno);
		builder.append(", nombreBanco=");
		builder.append(nombreBanco);
		builder.append(", nombrePatron=");
		builder.append(nombrePatron);
		builder.append(", rfcPatron=");
		builder.append(rfcPatron);
		builder.append(", situacionLegal=");
		builder.append(situacionLegal);
		builder.append(", movimientoRealizado=");
		builder.append(movimientoRealizado);
		builder.append(", movimientoActual=");
		builder.append(movimientoActual);
		builder.append(", indicadorSaldo=");
		builder.append(indicadorSaldo);
		builder.append("]");
		return builder.toString();
	}
	
}
