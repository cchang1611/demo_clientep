package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

/**
 * Datos Entrada para la Notificacion
 * @author ANOSORIO
 *
 */
public class NotificarParcialidadPagoEntrada implements Serializable{

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7403697632170264245L;
	
	/**
	 * afore
	 */
	private String afore;
    
	/**
	 * folioTramiteProcesar
	 */
	private String folioTramiteProcesar;
	
	/**
	 * folioCliente
	 */
    private String folioCliente;
    
    /**
     * nss
     */
    private String nss;
    
    /**
     * curp
     */
    private String curp;
    
    /**
     * cveBanco
     */
    private String cveBanco;
    
    /**
     * cuentaClabe
     */
    private String cuentaClabe;
   
    /**
     * numeroCuenta
     */
    private String numeroCuenta;
    
    /**
     * numeroResolucion
     */
    private String numeroResolucion;
   
    /**
     * numeroParcialidades
     */
    private String numeroParcialidades;

	/**
	 * @return the afore
	 */
	public String getAfore() {
		return afore;
	}

	/**
	 * @param afore the afore to set
	 */
	public void setAfore(String afore) {
		this.afore = afore;
	}

	/**
	 * @return the folioTramiteProcesar
	 */
	public String getFolioTramiteProcesar() {
		return folioTramiteProcesar;
	}

	/**
	 * @param folioTramiteProcesar the folioTramiteProcesar to set
	 */
	public void setFolioTramiteProcesar(String folioTramiteProcesar) {
		this.folioTramiteProcesar = folioTramiteProcesar;
	}

	/**
	 * @return the folioCliente
	 */
	public String getFolioCliente() {
		return folioCliente;
	}

	/**
	 * @param folioCliente the folioCliente to set
	 */
	public void setFolioCliente(String folioCliente) {
		this.folioCliente = folioCliente;
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
	 * @return the cveBanco
	 */
	public String getCveBanco() {
		return cveBanco;
	}

	/**
	 * @param cveBanco the cveBanco to set
	 */
	public void setCveBanco(String cveBanco) {
		this.cveBanco = cveBanco;
	}

	/**
	 * @return the cuentaClabe
	 */
	public String getCuentaClabe() {
		return cuentaClabe;
	}

	/**
	 * @param cuentaClabe the cuentaClabe to set
	 */
	public void setCuentaClabe(String cuentaClabe) {
		this.cuentaClabe = cuentaClabe;
	}

	/**
	 * @return the numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * @return the numeroResolucion
	 */
	public String getNumeroResolucion() {
		return numeroResolucion;
	}

	/**
	 * @param numeroResolucion the numeroResolucion to set
	 */
	public void setNumeroResolucion(String numeroResolucion) {
		this.numeroResolucion = numeroResolucion;
	}

	/**
	 * @return the numeroParcialidades
	 */
	public String getNumeroParcialidades() {
		return numeroParcialidades;
	}

	/**
	 * @param numeroParcialidades the numeroParcialidades to set
	 */
	public void setNumeroParcialidades(String numeroParcialidades) {
		this.numeroParcialidades = numeroParcialidades;
	}

	/**
	 * Constructor
	 */
	public NotificarParcialidadPagoEntrada() {
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificarParcialidadPagoEntrada [afore=");
		builder.append(afore);
		builder.append(", folioTramiteProcesar=");
		builder.append(folioTramiteProcesar);
		builder.append(", folioCliente=");
		builder.append(folioCliente);
		builder.append(", nss=");
		builder.append(nss);
		builder.append(", curp=");
		builder.append(curp);
		builder.append(", cveBanco=");
		builder.append(cveBanco);
		builder.append(", cuentaClabe=");
		builder.append(cuentaClabe);
		builder.append(", numeroCuenta=");
		builder.append(numeroCuenta);
		builder.append(", numeroResolucion=");
		builder.append(numeroResolucion);
		builder.append(", numeroParcialidades=");
		builder.append(numeroParcialidades);
		builder.append("]");
		return builder.toString();
	}
   
}
