package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Llave compuesta de la persistencia de la tabla EXPE_TC_DOC_REQUERIDO
 * 
 * @author Omar Balbuena Quiñones (OJBALBUE@inet.procesar.com.mx)
 * @version 1.0
 * @since 15/05/2019
 */
public class DocumentoRequeridoPK implements Serializable {

	/**
	 * Serialización
	 */
	private static final long serialVersionUID = 8119130109322244070L;

	/**
	 * claveTipoProceso
	 */
	private String claveTipoProceso;

	/**
	 * claveTipoDocDigital
	 */
	private String claveTipoDocDigital;

	/**
	 * @return el atributo claveTipoProceso
	 */
	public String getClaveTipoProceso() {
		return claveTipoProceso;
	}

	/**
	 * @param claveTipoProceso
	 *            parametro claveTipoProceso a actualizar
	 */
	public void setClaveTipoProceso(String claveTipoProceso) {
		this.claveTipoProceso = claveTipoProceso;
	}

	/**
	 * @return el atributo claveTipoDocDigital
	 */
	public String getClaveTipoDocDigital() {
		return claveTipoDocDigital;
	}

	/**
	 * @param claveTipoDocDigital
	 *            parametro claveTipoDocDigital a actualizar
	 */
	public void setClaveTipoDocDigital(String claveTipoDocDigital) {
		this.claveTipoDocDigital = claveTipoDocDigital;
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DocumentoRequeridoPK [claveTipoProceso=");
		builder.append(claveTipoProceso);
		builder.append(", claveTipoDocDigital=");
		builder.append(claveTipoDocDigital);
		builder.append("]");
		return builder.toString();
	}

}
