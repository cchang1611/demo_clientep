package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase de los datos certificables del trabajador
 * 
 * @author dbarbosa
 * @version 1.0
 * @since
 */
public class DatosComplementarios implements Serializable {
	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 3247864687660958859L;

	/**
	 * Domicilio Particular
	 */
	private Domicilio particular;
	
	/**
	 * Domicilio Laboral
	 */
	private Domicilio laboral;
	
	/**
	 * Telefono Personal
	 */
	private Telefono telefonos;
	
	/**
	 * Correo electronico
	 */
	private String correoElectronico;
	
	/**
	 * Lista de Referencias
	 */
	private List<Referencia> listaReferencias;
	
	/**
	 * Lista de Beneficiario
	 */
	private List<Beneficiario> listaBeneficiario;
	
	/**
	 * clave ocupacion
	 */
	private String claveOcupacion;
	
	/**
	 * fechacontrol
	 */
	private String fechaControl;
	
	/**
	 * Constructor
	 */
	public DatosComplementarios() {
		super();
		this.particular = new Domicilio();
		this.laboral = new Domicilio();
		this.telefonos = new Telefono();
	}

	/**
	 * @return the particular
	 */
	public Domicilio getParticular() {
		return particular;
	}

	/**
	 * @param particular the particular to set
	 */
	public void setParticular(Domicilio particular) {
		this.particular = particular;
	}

	/**
	 * @return the laboral
	 */
	public Domicilio getLaboral() {
		return laboral;
	}

	/**
	 * @param laboral the laboral to set
	 */
	public void setLaboral(Domicilio laboral) {
		this.laboral = laboral;
	}

	/**
	 * @return the telefonos
	 */
	public Telefono getTelefonos() {
		return telefonos;
	}

	/**
	 * @param telefonos the telefonos to set
	 */
	public void setTelefonos(Telefono telefonos) {
		this.telefonos = telefonos;
	}

	/**
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * @return the listaReferencias
	 */
	public List<Referencia> getListaReferencias() {
		return listaReferencias;
	}

	/**
	 * @param listaReferencias the listaReferencias to set
	 */
	public void setListaReferencias(List<Referencia> listaReferencias) {
		this.listaReferencias = listaReferencias;
	}

	/**
	 * @return the listaBeneficiario
	 */
	public List<Beneficiario> getListaBeneficiario() {
		return listaBeneficiario;
	}

	/**
	 * @param listaBeneficiario the listaBeneficiario to set
	 */
	public void setListaBeneficiario(List<Beneficiario> listaBeneficiario) {
		this.listaBeneficiario = listaBeneficiario;
	}

	/**
	 * @return the claveOcupacion
	 */
	public String getClaveOcupacion() {
		return claveOcupacion;
	}

	/**
	 * @param claveOcupacion the claveOcupacion to set
	 */
	public void setClaveOcupacion(String claveOcupacion) {
		this.claveOcupacion = claveOcupacion;
	}

	
	/**
	 * @return the fechaControl
	 */
	public String getFechaControl() {
		return fechaControl;
	}

	/**
	 * @param fechaControl the fechaControl to set
	 */
	public void setFechaControl(String fechaControl) {
		this.fechaControl = fechaControl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DatosComplementarios [particular=");
		builder.append(particular);
		builder.append(", laboral=");
		builder.append(laboral);
		builder.append(", telefonos=");
		builder.append(telefonos);
		builder.append(", correoElectronico=");
		builder.append(correoElectronico);
		builder.append(", listaReferencias=");
		builder.append(listaReferencias);
		builder.append(", listaBeneficiario=");
		builder.append(listaBeneficiario);
		builder.append(", claveOcupacion=");
		builder.append(claveOcupacion);
		builder.append(", fechaControl=");
		builder.append(fechaControl);
		builder.append("]");
		return builder.toString();
	}

	
}