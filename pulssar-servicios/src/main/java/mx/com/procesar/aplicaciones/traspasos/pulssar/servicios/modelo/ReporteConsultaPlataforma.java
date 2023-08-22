package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Reporte plataforma
 * @author RARREOLA
 *
 */
public class ReporteConsultaPlataforma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lista
	 */
	private List<DatosExcelPlataformaServicios> listasResultados;

	/**
	 * @return the listasResultados
	 */
	public List<DatosExcelPlataformaServicios> getListasResultados() {
		return listasResultados;
	}

	/**
	 * @param listasResultados the listasResultados to set
	 */
	public void setListasResultados(List<DatosExcelPlataformaServicios> listasResultados) {
		this.listasResultados = listasResultados;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
	
	

}
