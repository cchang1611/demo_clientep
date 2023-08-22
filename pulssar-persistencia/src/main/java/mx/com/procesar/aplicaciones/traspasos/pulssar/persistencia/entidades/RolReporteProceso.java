package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

/**
 * Definicion de entidad bitacora para los Procesos
 * 
 * @author DGSANCHEZ
 * @version 1.0
 */
public class RolReporteProceso implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6011668369936845033L;

	/**
	 * identificador unico para IdProceso
	 */
	private Long idProcesoNegocio;
	
	/**
	 * identificador para el nombre del proceso
	 */
	private String nombreProceso;

    /**
     * @param idProcesoNegocio
     * @param nombreProceso
     */
    public RolReporteProceso(Long idProcesoNegocio, String nombreProceso) {
        super();
        this.idProcesoNegocio = idProcesoNegocio;
        this.nombreProceso = nombreProceso;
    }

	/**
	 * @return the idProcesoNegocio
	 */
	public Long getIdProcesoNegocio() {
		return idProcesoNegocio;
	}

	/**
	 * @param idProcesoNegocio the idProcesoNegocio to set
	 */
	public void setIdProcesoNegocio(Long idProcesoNegocio) {
		this.idProcesoNegocio = idProcesoNegocio;
	}

	/**
	 * @return the nombreProceso
	 */
	public String getNombreProceso() {
		return nombreProceso;
	}

	/**
	 * @param nombreProceso the nombreProceso to set
	 */
	public void setNombreProceso(String nombreProceso) {
		this.nombreProceso = nombreProceso;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProcesoNegocio == null) ? 0 : idProcesoNegocio.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolReporteProceso other = (RolReporteProceso) obj;
		if (idProcesoNegocio == null) {
			if (other.idProcesoNegocio != null)
				return false;
		} else if (!idProcesoNegocio.equals(other.idProcesoNegocio))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RolReporteProceso [idProcesoNegocio=");
		builder.append(idProcesoNegocio);
		builder.append(", nombreProceso=");
		builder.append(nombreProceso);
		builder.append("]");
		return builder.toString();
	}
}