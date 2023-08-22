package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
 * Parametros Entrada Disposicion imss 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Jun 3, 2021
 */
public class ParametroEntrada implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = -5915545748620139133L;
	
	/**
	 * nss
	 */
	private String nss;
	
	/**
	 * secuenciaPension
	 */
	private String secuenciaPension;
	

	/**
	 * tramiteProcesar
	 */
	private String tramiteProcesar;

	/**
	 * @return el atributo nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss parametro nss a actualizar
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return el atributo secuenciaPension
	 */
	public String getSecuenciaPension() {
		return secuenciaPension;
	}

	/**
	 * @param secuenciaPension parametro secuenciaPension a actualizar
	 */
	public void setSecuenciaPension(String secuenciaPension) {
		this.secuenciaPension = secuenciaPension;
	}

	


	/**
	 * @return el atributo tramiteProcesar
	 */
	public String getTramiteProcesar() {
		return tramiteProcesar;
	}

	/**
	 * @param tramiteProcesar parametro tramiteProcesar a actualizar
	 */
	public void setTramiteProcesar(String tramiteProcesar) {
		this.tramiteProcesar = tramiteProcesar;
	}
	

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParametroEntrada [nss=");
		builder.append(nss);
		builder.append(", secuenciaPension=");
		builder.append(secuenciaPension);
		builder.append(", tramiteProcesar=");
		builder.append(tramiteProcesar);
		builder.append("]");
		return builder.toString();
	}
    
	
	
}
