package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;

/**
 * Clase de persistencia para obtener subprocesos
 * 
 * @author DGSANCHE
 * @version 1.0
 */
public class RolReporteSubProceso implements Serializable {

    /**
     * serial version
     */
    private static final long serialVersionUID = 860276322773778216L;

    /**
     * Id SubProceso
     */
    private Long idSubProceso;

    /**
     * Nomgbre SubProceso
     */
    private String nombreSubProceso;

    /**
     * @param idSubProceso
     * @param nombreSubProceso
     */
    public RolReporteSubProceso(Long idSubProceso, String nombreSubProceso) {
        super();
        this.idSubProceso = idSubProceso;
        this.nombreSubProceso = nombreSubProceso;
    }

    /**
     * @return the idSubProceso
     */
    public Long getIdSubProceso() {
        return idSubProceso;
    }

    /**
     * @param idSubProceso the idSubProceso to set
     */
    public void setIdSubProceso(Long idSubProceso) {
        this.idSubProceso = idSubProceso;
    }

    /**
     * @return the nombreSubProceso
     */
    public String getNombreSubProceso() {
        return nombreSubProceso;
    }

    /**
     * @param nombreSubProceso the nombreSubProceso to set
     */
    public void setNombreSubProceso(String nombreSubProceso) {
        this.nombreSubProceso = nombreSubProceso;
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
        result = prime * result + ((idSubProceso == null) ? 0 : idSubProceso.hashCode());
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
        RolReporteSubProceso other = (RolReporteSubProceso) obj;
        if (idSubProceso == null) {
            if (other.idSubProceso != null)
                return false;
        } else if (!idSubProceso.equals(other.idSubProceso))
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
        builder.append("RolReporteSubProceso [idSubProceso=");
        builder.append(idSubProceso);
        builder.append(", nombreSubProceso=");
        builder.append(nombreSubProceso);
        builder.append("]");
        return builder.toString();
    }

}
