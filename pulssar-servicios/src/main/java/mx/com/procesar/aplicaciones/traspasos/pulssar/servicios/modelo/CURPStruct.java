/**
 * CURPStruct.java
 * Fecha de creación: 20/05/2019, 17:45:34
 *
 * Copyright (c) 2019 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Respuesta consulta RENAPO
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since 20/05/2019
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "CURPStruct")
public class CURPStruct implements Serializable {
	
	/**
	 * serial ID
	 */
	private static final long serialVersionUID = -4728886879664052156L;

	/**
	 * CURP
	 */
	@JsonProperty("CURP")
	private String curp;
	/**
	 * apellido1
	 */
	@JsonProperty("apellido1")
	private String apellido1;
	/**
	 * apellido2
	 */
	@JsonProperty("apellido2")
	private String apellido2;
	/**
	 * nombres
	 */
	@JsonProperty("nombres")
	private String nombres;
	/**
	 * sexo
	 */
	@JsonProperty("sexo")
	private String sexo;
	/**
	 * fecha Nacimiento
	 */
	@JsonProperty("fechNac")
	private String fechNac;
	/**
	 * nacionalidad
	 */
	@JsonProperty("nacionalidad")
	private String nacionalidad;
	/**
	 * documento Probatorio
	 */
	@JsonProperty("docProbatorio")
	private String docProbatorio;
	/**
	 * anio Reg
	 */
	@JsonProperty("anioReg")
	private String anioReg;
	/**
	 * foja
	 */
	@JsonProperty("foja")
	private String foja;
	/**
	 * tomo
	 */
	@JsonProperty("tomo")
	private String tomo;
	/**
	 * libro
	 */
	@JsonProperty("libro")
	private String libro;
	/**
	 * numero Acta
	 */
	@JsonProperty("numActa")
	private String numActa;
	/**
	 * crip
	 */
	@JsonProperty("CRIP")
	private String crip;
	/**
	 * numero Entidad Reg
	 */
	@JsonProperty("numEntidadReg")
	private String numEntidadReg;
	/**
	 * clave Municipio Reg
	 */
	@JsonProperty("cveMunicipioReg")
	private String cveMunicipioReg;
	/**
	 * numero Reg Extranjeros
	 */
	@JsonProperty("NumRegExtranjeros")
	private String numRegExtranjeros;
	/**
	 * folio Carta
	 */
	@JsonProperty("FolioCarta")
	private String folioCarta;
	/**
	 * clave Entidad Nacimineot
	 */
	@JsonProperty("cveEntidadNac")
	private String cveEntidadNac;
	/**
	 * Clave Entidad Emisora
	 */
	@JsonProperty("cveEntidadEmisora")
	private String cveEntidadEmisora;
	/**
	 * status Curp
	 */
	@JsonProperty("statusCurp")
	private String statusCurp;
	/**
	 * curp Historicas
	 */
	@JsonProperty("curpHistoricas")
	private String[] curpHistoricas;
	/**
	 * @return el atributo curp
	 */
	public String getCurp() {
		return curp;
	}
	/**
	 * @param curp parametro curp a actualizar
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	/**
	 * @return el atributo apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}
	/**
	 * @param apellido1 parametro apellido1 a actualizar
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	/**
	 * @return el atributo apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}
	/**
	 * @param apellido2 parametro apellido2 a actualizar
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	/**
	 * @return el atributo nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres parametro nombres a actualizar
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return el atributo sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo parametro sexo a actualizar
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return el atributo fechNac
	 */
	public String getFechNac() {
		return fechNac;
	}
	/**
	 * @param fechNac parametro fechNac a actualizar
	 */
	public void setFechNac(String fechNac) {
		this.fechNac = fechNac;
	}
	/**
	 * @return el atributo nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/**
	 * @param nacionalidad parametro nacionalidad a actualizar
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	/**
	 * @return el atributo docProbatorio
	 */
	public String getDocProbatorio() {
		return docProbatorio;
	}
	/**
	 * @param docProbatorio parametro docProbatorio a actualizar
	 */
	public void setDocProbatorio(String docProbatorio) {
		this.docProbatorio = docProbatorio;
	}
	/**
	 * @return el atributo anioReg
	 */
	public String getAnioReg() {
		return anioReg;
	}
	/**
	 * @param anioReg parametro anioReg a actualizar
	 */
	public void setAnioReg(String anioReg) {
		this.anioReg = anioReg;
	}
	/**
	 * @return el atributo foja
	 */
	public String getFoja() {
		return foja;
	}
	/**
	 * @param foja parametro foja a actualizar
	 */
	public void setFoja(String foja) {
		this.foja = foja;
	}
	/**
	 * @return el atributo tomo
	 */
	public String getTomo() {
		return tomo;
	}
	/**
	 * @param tomo parametro tomo a actualizar
	 */
	public void setTomo(String tomo) {
		this.tomo = tomo;
	}
	/**
	 * @return el atributo libro
	 */
	public String getLibro() {
		return libro;
	}
	/**
	 * @param libro parametro libro a actualizar
	 */
	public void setLibro(String libro) {
		this.libro = libro;
	}
	/**
	 * @return el atributo numActa
	 */
	public String getNumActa() {
		return numActa;
	}
	/**
	 * @param numActa parametro numActa a actualizar
	 */
	public void setNumActa(String numActa) {
		this.numActa = numActa;
	}
	/**
	 * @return el atributo crip
	 */
	public String getCrip() {
		return crip;
	}
	/**
	 * @param crip parametro crip a actualizar
	 */
	public void setCrip(String crip) {
		this.crip = crip;
	}
	/**
	 * @return el atributo numEntidadReg
	 */
	public String getNumEntidadReg() {
		return numEntidadReg;
	}
	/**
	 * @param numEntidadReg parametro numEntidadReg a actualizar
	 */
	public void setNumEntidadReg(String numEntidadReg) {
		this.numEntidadReg = numEntidadReg;
	}
	/**
	 * @return el atributo cveMunicipioReg
	 */
	public String getCveMunicipioReg() {
		return cveMunicipioReg;
	}
	/**
	 * @param cveMunicipioReg parametro cveMunicipioReg a actualizar
	 */
	public void setCveMunicipioReg(String cveMunicipioReg) {
		this.cveMunicipioReg = cveMunicipioReg;
	}
	/**
	 * @return el atributo numRegExtranjeros
	 */
	public String getNumRegExtranjeros() {
		return numRegExtranjeros;
	}
	/**
	 * @param numRegExtranjeros parametro numRegExtranjeros a actualizar
	 */
	public void setNumRegExtranjeros(String numRegExtranjeros) {
		this.numRegExtranjeros = numRegExtranjeros;
	}
	/**
	 * @return el atributo folioCarta
	 */
	public String getFolioCarta() {
		return folioCarta;
	}
	/**
	 * @param folioCarta parametro folioCarta a actualizar
	 */
	public void setFolioCarta(String folioCarta) {
		this.folioCarta = folioCarta;
	}
	/**
	 * @return el atributo cveEntidadNac
	 */
	public String getCveEntidadNac() {
		return cveEntidadNac;
	}
	/**
	 * @param cveEntidadNac parametro cveEntidadNac a actualizar
	 */
	public void setCveEntidadNac(String cveEntidadNac) {
		this.cveEntidadNac = cveEntidadNac;
	}
	/**
	 * @return el atributo cveEntidadEmisora
	 */
	public String getCveEntidadEmisora() {
		return cveEntidadEmisora;
	}
	/**
	 * @param cveEntidadEmisora parametro cveEntidadEmisora a actualizar
	 */
	public void setCveEntidadEmisora(String cveEntidadEmisora) {
		this.cveEntidadEmisora = cveEntidadEmisora;
	}
	/**
	 * @return el atributo statusCurp
	 */
	public String getStatusCurp() {
		return statusCurp;
	}
	/**
	 * @param statusCurp parametro statusCurp a actualizar
	 */
	public void setStatusCurp(String statusCurp) {
		this.statusCurp = statusCurp;
	}
	
	/**
	 * @return the curpHistoricas
	 */
	public String[] getCurpHistoricas() {
		return curpHistoricas;
	}
	/**
	 * @param curpHistoricas the curpHistoricas to set
	 */
	public void setCurpHistoricas(String[] curpHistoricas) {
		this.curpHistoricas = curpHistoricas;
	}
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CURPStruct [curp=");
		builder.append(curp);
		builder.append(", apellido1=");
		builder.append(apellido1);
		builder.append(", apellido2=");
		builder.append(apellido2);
		builder.append(", nombres=");
		builder.append(nombres);
		builder.append(", sexo=");
		builder.append(sexo);
		builder.append(", fechNac=");
		builder.append(fechNac);
		builder.append(", nacionalidad=");
		builder.append(nacionalidad);
		builder.append(", docProbatorio=");
		builder.append(docProbatorio);
		builder.append(", anioReg=");
		builder.append(anioReg);
		builder.append(", foja=");
		builder.append(foja);
		builder.append(", tomo=");
		builder.append(tomo);
		builder.append(", libro=");
		builder.append(libro);
		builder.append(", numActa=");
		builder.append(numActa);
		builder.append(", crip=");
		builder.append(crip);
		builder.append(", numEntidadReg=");
		builder.append(numEntidadReg);
		builder.append(", cveMunicipioReg=");
		builder.append(cveMunicipioReg);
		builder.append(", numRegExtranjeros=");
		builder.append(numRegExtranjeros);
		builder.append(", folioCarta=");
		builder.append(folioCarta);
		builder.append(", cveEntidadNac=");
		builder.append(cveEntidadNac);
		builder.append(", cveEntidadEmisora=");
		builder.append(cveEntidadEmisora);
		builder.append(", statusCurp=");
		builder.append(statusCurp);
		builder.append(", curpHistoricas=");
		builder.append(curpHistoricas);
		builder.append("]");
		return builder.toString();
	}

}
