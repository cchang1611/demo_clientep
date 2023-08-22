package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;


/**
 * Entidad de la persistencia PSER_TB_IMAGEN_DIAG_RECH.
 * 
 */
public class ImagenDiagnosticoRechazo implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 4096598134178431169L;

	/**
	 * id imagen diagnostico rezhazo
	 */
	private Long idTbImagenDiagRech;

	/**
	 * afore
	 */
	private String chAfore;

	/**
	 * folio procesar
	 */
	private String chFolioProcesar;

	/**
	 * tipo proceso
	 */
	private String chTipoProceso;
	
	/**
	 * tipo
	 */
	private Integer nuTipo;
	
	/**
	 * clave diagnostico imagen
	 */
	private String cvDiagImagenes;

	/**
	 * usuario modificador
	 */
	private String chUsuarioModificador;

	/**
	 * fecha control
	 */
	private Date fcControl;

	/**
	 * @return the idTbImagenDiagRech
	 */
	public Long getIdTbImagenDiagRech() {
		return idTbImagenDiagRech;
	}

	/**
	 * @param idTbImagenDiagRech the idTbImagenDiagRech to set
	 */
	public void setIdTbImagenDiagRech(Long idTbImagenDiagRech) {
		this.idTbImagenDiagRech = idTbImagenDiagRech;
	}

	/**
	 * @return the chAfore
	 */
	public String getChAfore() {
		return chAfore;
	}

	/**
	 * @param chAfore the chAfore to set
	 */
	public void setChAfore(String chAfore) {
		this.chAfore = chAfore;
	}

	/**
	 * @return the chFolioProcesar
	 */
	public String getChFolioProcesar() {
		return chFolioProcesar;
	}

	/**
	 * @param chFolioProcesar the chFolioProcesar to set
	 */
	public void setChFolioProcesar(String chFolioProcesar) {
		this.chFolioProcesar = chFolioProcesar;
	}

	/**
	 * @return the chTipoProceso
	 */
	public String getChTipoProceso() {
		return chTipoProceso;
	}

	/**
	 * @param chTipoProceso the chTipoProceso to set
	 */
	public void setChTipoProceso(String chTipoProceso) {
		this.chTipoProceso = chTipoProceso;
	}

	/**
	 * @return the nuTipo
	 */
	public Integer getNuTipo() {
		return nuTipo;
	}

	/**
	 * @param nuTipo the nuTipo to set
	 */
	public void setNuTipo(Integer nuTipo) {
		this.nuTipo = nuTipo;
	}

	/**
	 * @return the cvDiagImagenes
	 */
	public String getCvDiagImagenes() {
		return cvDiagImagenes;
	}

	/**
	 * @param cvDiagImagenes the cvDiagImagenes to set
	 */
	public void setCvDiagImagenes(String cvDiagImagenes) {
		this.cvDiagImagenes = cvDiagImagenes;
	}

	/**
	 * @return the chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * @param chUsuarioModificador the chUsuarioModificador to set
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}

	/**
	 * @return the fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl the fcControl to set
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ImagenDiagnosticoRechazo [idTbImagenDiagRech=");
		builder.append(idTbImagenDiagRech);
		builder.append(", chAfore=");
		builder.append(chAfore);
		builder.append(", chFolioProcesar=");
		builder.append(chFolioProcesar);
		builder.append(", chTipoProceso=");
		builder.append(chTipoProceso);
		builder.append(", nuTipo=");
		builder.append(nuTipo);
		builder.append(", cvDiagImagenes=");
		builder.append(cvDiagImagenes);
		builder.append(", chUsuarioModificador=");
		builder.append(chUsuarioModificador);
		builder.append(", fcControl=");
		builder.append(fcControl);
		builder.append("]");
		return builder.toString();
	}



}