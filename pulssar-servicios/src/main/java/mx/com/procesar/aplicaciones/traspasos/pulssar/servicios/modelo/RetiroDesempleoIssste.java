package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Map;

/**
 * Objeto de Retiro Desempleo Issste
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 30/08/2019
 */
public class RetiroDesempleoIssste implements Serializable {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -5506071283596395258L;
	/**
	 * sello Trabajador
	 */
	private Long selloTrabajador;
	/**
	 * tipoExpediente
	 */
	private String tipoExpediente;
	/**
	 * claveBanco
	 */
	private String ctrlInstBancariaTipoRetiro;
	/**
	 * claveProceso
	 */
	private String claveProceso;
	/**
	 * cuenta
	 */
	private String cuentaTipoRetiro;
	/**
	 * cuentaClabe
	 */
	private String clabeTipoRetiro;
	/**
	 * formaPago
	 */
	private String formaPagoTipoRetiro;
	/**
	 * saldoRcv
	 */
	private String saldoRcv;
	/**
	 * saldoRetiro08I
	 */
	private String saldoRetiro08I;
	/**
	 * saldoRetiro92I
	 */
	private String saldoRetiro92I;
	/**
	 * tipoOperacion
	 */
	private String tipoOperacion;
	/**
	 * totalSaldos
	 */
	private String totalSaldos;
	/**
	 * Folio Padre
	 */
	private String folioPadre;
	
	/**
	 * Id del folio
	 */
	private Long idFolio;
	/**
	 * mapa con los nombres de archivos para el zip
	 */
	private Map<String, String> nombreArchivo;
	/**
	 * Objeto Resolucion
	 */
	private Resolucion resolucion;
	
	
	/**
	 * CUS
	 */
	private String cus;
	/**
	 * @return el atributo selloTrabajador
	 */
	public Long getSelloTrabajador() {
		return selloTrabajador;
	}
	/**
	 * @param selloTrabajador parametro selloTrabajador a actualizar
	 */
	public void setSelloTrabajador(Long selloTrabajador) {
		this.selloTrabajador = selloTrabajador;
	}
	/**
	 * @return el atributo tipoExpediente
	 */
	public String getTipoExpediente() {
		return tipoExpediente;
	}
	/**
	 * @param tipoExpediente parametro tipoExpediente a actualizar
	 */
	public void setTipoExpediente(String tipoExpediente) {
		this.tipoExpediente = tipoExpediente;
	}
	/**
	 * @return el atributo ctrlInstBancariaTipoRetiro
	 */
	public String getCtrlInstBancariaTipoRetiro() {
		return ctrlInstBancariaTipoRetiro;
	}
	/**
	 * @param ctrlInstBancariaTipoRetiro parametro ctrlInstBancariaTipoRetiro a actualizar
	 */
	public void setCtrlInstBancariaTipoRetiro(String ctrlInstBancariaTipoRetiro) {
		this.ctrlInstBancariaTipoRetiro = ctrlInstBancariaTipoRetiro;
	}
	/**
	 * @return el atributo claveProceso
	 */
	public String getClaveProceso() {
		return claveProceso;
	}
	/**
	 * @param claveProceso parametro claveProceso a actualizar
	 */
	public void setClaveProceso(String claveProceso) {
		this.claveProceso = claveProceso;
	}
	/**
	 * @return el atributo cuentaTipoRetiro
	 */
	public String getCuentaTipoRetiro() {
		return cuentaTipoRetiro;
	}
	/**
	 * @param cuentaTipoRetiro parametro cuentaTipoRetiro a actualizar
	 */
	public void setCuentaTipoRetiro(String cuentaTipoRetiro) {
		this.cuentaTipoRetiro = cuentaTipoRetiro;
	}
	/**
	 * @return el atributo clabeTipoRetiro
	 */
	public String getClabeTipoRetiro() {
		return clabeTipoRetiro;
	}
	/**
	 * @param clabeTipoRetiro parametro clabeTipoRetiro a actualizar
	 */
	public void setClabeTipoRetiro(String clabeTipoRetiro) {
		this.clabeTipoRetiro = clabeTipoRetiro;
	}
	/**
	 * @return el atributo formaPagoTipoRetiro
	 */
	public String getFormaPagoTipoRetiro() {
		return formaPagoTipoRetiro;
	}
	/**
	 * @param formaPagoTipoRetiro parametro formaPagoTipoRetiro a actualizar
	 */
	public void setFormaPagoTipoRetiro(String formaPagoTipoRetiro) {
		this.formaPagoTipoRetiro = formaPagoTipoRetiro;
	}
	/**
	 * @return el atributo saldoRcv
	 */
	public String getSaldoRcv() {
		return saldoRcv;
	}
	/**
	 * @param saldoRcv parametro saldoRcv a actualizar
	 */
	public void setSaldoRcv(String saldoRcv) {
		this.saldoRcv = saldoRcv;
	}
	/**
	 * @return el atributo saldoRetiro08I
	 */
	public String getSaldoRetiro08I() {
		return saldoRetiro08I;
	}
	/**
	 * @param saldoRetiro08I parametro saldoRetiro08I a actualizar
	 */
	public void setSaldoRetiro08I(String saldoRetiro08I) {
		this.saldoRetiro08I = saldoRetiro08I;
	}
	/**
	 * @return el atributo saldoRetiro92I
	 */
	public String getSaldoRetiro92I() {
		return saldoRetiro92I;
	}
	/**
	 * @param saldoRetiro92I parametro saldoRetiro92I a actualizar
	 */
	public void setSaldoRetiro92I(String saldoRetiro92I) {
		this.saldoRetiro92I = saldoRetiro92I;
	}
	/**
	 * @return el atributo tipoOperacion
	 */
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	/**
	 * @param tipoOperacion parametro tipoOperacion a actualizar
	 */
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	/**
	 * @return el atributo totalSaldos
	 */
	public String getTotalSaldos() {
		return totalSaldos;
	}
	/**
	 * @param totalSaldos parametro totalSaldos a actualizar
	 */
	public void setTotalSaldos(String totalSaldos) {
		this.totalSaldos = totalSaldos;
	}
	/**
	 * @return el atributo folioPadre
	 */
	public String getFolioPadre() {
		return folioPadre;
	}
	/**
	 * @param folioPadre parametro folioPadre a actualizar
	 */
	public void setFolioPadre(String folioPadre) {
		this.folioPadre = folioPadre;
	}
	/**
	 * @return el atributo nombreArchivo
	 */
	public Map<String, String> getNombreArchivo() {
		return nombreArchivo;
	}
	/**
	 * @param nombreArchivo parametro nombreArchivo a actualizar
	 */
	public void setNombreArchivo(Map<String, String> nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	/**
	 * @return el atributo idFolio
	 */
	public Long getIdFolio() {
		return idFolio;
	}
	/**
	 * @param idFolio parametro idFolio a actualizar
	 */
	public void setIdFolio(Long idFolio) {
		this.idFolio = idFolio;
	}
	/**
	 * @return el atributo resolucion
	 */
	public Resolucion getResolucion() {
		return resolucion;
	}
	/**
	 * @param resolucion parametro resolucion a actualizar
	 */
	public void setResolucion(Resolucion resolucion) {
		this.resolucion = resolucion;
	}
	
	
	/**
	 * @return the cus
	 */
	public String getCus() {
		return cus;
	}
	/**
	 * @param cus the cus to set
	 */
	public void setCus(String cus) {
		this.cus = cus;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RetiroDesempleoIssste [secuenciaPension=");
		builder.append(", selloTrabajador=");
		builder.append(selloTrabajador);
		builder.append(", tipoExpediente=");
		builder.append(tipoExpediente);
		builder.append(", ctrlInstBancariaTipoRetiro=");
		builder.append(ctrlInstBancariaTipoRetiro);
		builder.append(", claveProceso=");
		builder.append(claveProceso);
		builder.append(", cuentaTipoRetiro=");
		builder.append(cuentaTipoRetiro);
		builder.append(", clabeTipoRetiro=");
		builder.append(clabeTipoRetiro);
		builder.append(", formaPagoTipoRetiro=");
		builder.append(formaPagoTipoRetiro);
		builder.append(", saldoRcv=");
		builder.append(saldoRcv);
		builder.append(", saldoRetiro08I=");
		builder.append(saldoRetiro08I);
		builder.append(", saldoRetiro92I=");
		builder.append(saldoRetiro92I);
		builder.append(", tipoOperacion=");
		builder.append(tipoOperacion);
		builder.append(", totalSaldos=");
		builder.append(totalSaldos);
		builder.append(", folioPadre=");
		builder.append(folioPadre);
		builder.append(", idFolio=");
		builder.append(idFolio);
		builder.append(", nombreArchivo=");
		builder.append(nombreArchivo);
		builder.append(", resolucion=");
		builder.append(resolucion);
		builder.append(", cus=");
		builder.append(cus);
	
		builder.append("]");
		return builder.toString();
	}
	
}
