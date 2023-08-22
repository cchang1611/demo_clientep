package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

/**
 * Clase de persistencia para obtener tipo
 * 
 * @author DGSANCHE
 * @version 1.0
 */
public class RolReporteTipo implements Serializable {

    /**
     * serial version
     */
    private static final long serialVersionUID = 860276322773778216L;

    /**
     * Id TipoReporte
     */
    private Long idTipoReporte;

    /**
     * Nombre TipoReporte
     */
    private String nombreTipoReporte;

    /**
     * @param idTipoReporte
     * @param nombreTipoReporte
     */
    public RolReporteTipo(Long idTipoReporte, String nombreTipoReporte) {
        super();
        this.idTipoReporte = idTipoReporte;
        this.nombreTipoReporte = nombreTipoReporte;
    }

    /**
     * @return the idTipoReporte
     */
    public Long getIdTipoReporte() {
        return idTipoReporte;
    }

    /**
     * @param idTipoReporte
     *            the idTipoReporte to set
     */
    public void setIdTipoReporte(Long idTipoReporte) {
        this.idTipoReporte = idTipoReporte;
    }

    /**
     * @return the nombreTipoReporte
     */
    public String getNombreTipoReporte() {
        return nombreTipoReporte;
    }

    /**
     * @param nombreTipoReporte
     *            the nombreTipoReporte to set
     */
    public void setNombreTipoReporte(String nombreTipoReporte) {
        this.nombreTipoReporte = nombreTipoReporte;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTipoReporte == null) ? 0 : idTipoReporte.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
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
        RolReporteTipo other = (RolReporteTipo) obj;
        if (idTipoReporte == null) {
            if (other.idTipoReporte != null)
                return false;
        } else if (!idTipoReporte.equals(other.idTipoReporte))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RolReporteTipo [idTipoReporte=");
        builder.append(idTipoReporte);
        builder.append(", nombreTipoReporte=");
        builder.append(nombreTipoReporte);
        builder.append("]");
        return builder.toString();
    }

}
