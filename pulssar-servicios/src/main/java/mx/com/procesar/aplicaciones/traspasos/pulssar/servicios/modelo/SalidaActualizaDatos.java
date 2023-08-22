package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.objetoscomunes.SSNROP;

/**
 * @author medoming
 *
 */
public class SalidaActualizaDatos implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 1944030924473445948L;
	
	/**
	 * ssnrop
	 */
	private SSNROP ssnrop;
	
	/**
	 * objetoRespuesta
	 */
	private DatosSalidaModificacion objetoRespuesta;
	
	/**
	 * rechazosBloque
	 */
	private List<RechazoBloque> rechazosBloque;
	
	/**
	 * resultadoActualizacion
	 */
	private String resultadoActualizacion;

	/**
	 * @return ssnrop
	 */
	public SSNROP getSsnrop() {
		return ssnrop;
	}

	/**
	 * @param ssnrop the ssnrop to set
	 */
	public void setSsnrop(SSNROP ssnrop) {
		this.ssnrop = ssnrop;
	}

	/**
	 * @return rechazosBloque
	 */
	public List<RechazoBloque> getRechazosBloque() {
		return rechazosBloque;
	}

	/**
	 * @param rechazosBloque the rechazosBloque to set
	 */
	public void setRechazosBloque(List<RechazoBloque> rechazosBloque) {
		this.rechazosBloque = rechazosBloque;
	}

	/**
	 * @return objetoRespuesta
	 */
	public DatosSalidaModificacion getObjetoRespuesta() {
		return objetoRespuesta;
	}

	/**
	 * @param objetoRespuesta the objetoRespuesta to set
	 */
	public void setObjetoRespuesta(DatosSalidaModificacion objetoRespuesta) {
		this.objetoRespuesta = objetoRespuesta;
	}

	public String getResultadoActualizacion() {
		return resultadoActualizacion;
	}

	public void setResultadoActualizacion(String resultadoActualizacion) {
		this.resultadoActualizacion = resultadoActualizacion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalidaActualizaDatos [ssnrop=");
		builder.append(ssnrop);
		builder.append(", objetoRespuesta=");
		builder.append(objetoRespuesta);
		builder.append(", rechazosBloque=");
		builder.append(rechazosBloque);
		builder.append(", resultadoActualizacion=");
		builder.append(resultadoActualizacion);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
