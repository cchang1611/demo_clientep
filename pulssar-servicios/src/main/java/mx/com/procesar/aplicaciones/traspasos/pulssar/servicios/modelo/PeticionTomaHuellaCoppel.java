/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * @author dhernand
 *
 */
public class PeticionTomaHuellaCoppel implements Serializable{
	

    /**
	 * Serial
	 */
	private static final long serialVersionUID = -2942499986080719024L;

	/**
     * Mano derecha
     */
    public static final String MD = "0";	

    /**
     * Mano izquierda
     */
    public static final String MI = "1";
    
    /**
     * Pulgares
     */
    public static final String PULGARES = "2";
    
    /**
     * 4-4-2
     */
    public static final String CUATRO_CUATRO_DOS = "3";
    
    /**
     * Un dedo
     */
    public static final String UN_DEDO = "4";
    
    /**
     * Enrolador
     */
    public static final String ENROLADOR = "1";
    
    /**
     * Empleado
     */
    public static final String EMPLEADO = "2";
    
    /**
     * Empleado
     */
    public static final String TRABAJADOR = "3";


    
	/**
	 * Folio Procesar
	 */
	private String folioProcesar;
	
	/**
	 * Curp
	 */
	private String curp;
	
	/**
	 * Nss
	 */
	private String nss;
	
	/**
	 * Tipo persona <br>
	 *  1 - Enrolador <br>
	 *  2 - Empleado <br>
	 *  3 - Trabajador<br>
	 */
	private String tipoPersona;
	
	/**
	 * Tipo toma <br>
	 * 0: (MD) <br>
     * 1: (MI)<br>
     * 2: (Pulgares)<br>
     * 3: (4-4-2 )<br>
     * 4: (1 Dedo)<br>
	 */
	private String tipoToma;

	/**
	 * Regresar folioProcesar
	 * @return folioProcesar
	 */
	public String getFolioProcesar() {
		return folioProcesar;
	}

	/**
	 * Asigna folioProcesar
	 * @param  folioProcesar
	 */
	public void setFolioProcesar(String folioProcesar) {
		this.folioProcesar = folioProcesar;
	}

	/**
	 * Regresar curp
	 * @return curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * Asigna curp
	 * @param  curp
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * Regresar nss
	 * @return nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * Asigna nss
	 * @param  nss
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * Regresar tipoPersona
	 * @return tipoPersona
	 */
	public String getTipoPersona() {
		return tipoPersona;
	}

	/**
	 * Asigna tipoPersona
	 * @param  tipoPersona
	 */
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	/**
	 * Regresar tipoToma
	 * @return tipoToma
	 */
	public String getTipoToma() {
		return tipoToma;
	}

	/**
	 * Asigna tipoToma
	 * @param  tipoToma
	 */
	public void setTipoToma(String tipoToma) {
		this.tipoToma = tipoToma;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PeticionTomaHuellaCoppel [folioProcesar=");
		builder.append(folioProcesar);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", tipoPersona=");
		builder.append(tipoPersona);
		builder.append(", tipoToma=");
		builder.append(tipoToma);
		builder.append("]");
		return builder.toString();
	}
	
	
}