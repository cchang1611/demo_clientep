package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Definicion de entidad bitacora para la ejecucion de reportes
 * 
 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
 * @version 1.0
 * @since
 */
@Entity
public class RolReporte implements Serializable {

	/**
	 * Identificador de Serializacion
	 */
	private static final long serialVersionUID = -6501474555719113350L;


	/**
	 * Identificador unico de modulo de reporte
	 */
	@Id
	@Column(name = "ID_MODULO_REPORTE")
	private Long idModulo;
	
	/**
	 * Nombre del modulo de reporte
	 */
	@Column(name = "CH_NOMBRE_MODULO_REP")
	private String nombreModulo;

	/**
	 * @return the idModulo
	 */
	public Long getIdModulo() {
		return idModulo;
	}

	/**
	 * @param idModulo the idModulo to set
	 */
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	/**
	 * @return the nombreModulo
	 */
	public String getNombreModulo() {
		return nombreModulo;
	}

	/**
	 * @param nombreModulo the nombreModulo to set
	 */
	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

    /*
     * La documentación de este método se encuentra en la clase o interface que
     * lo declara (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RolReporte [idModulo=");
        builder.append(idModulo);
        builder.append(", nombreModulo=");
        builder.append(nombreModulo);
        builder.append("]");
        return builder.toString();
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
		result = prime * result + ((idModulo == null) ? 0 : idModulo.hashCode());
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
        RolReporte other = (RolReporte) obj;
        if (idModulo == null) {
            if (other.idModulo != null)
                return false;
        } else if (!idModulo.equals(other.idModulo))
            return false;
        return true;
    }
}