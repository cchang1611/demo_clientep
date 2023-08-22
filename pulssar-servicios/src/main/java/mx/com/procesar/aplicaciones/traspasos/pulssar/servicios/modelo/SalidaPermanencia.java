package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.objetoscomunes.SSNROP;


public class SalidaPermanencia implements Serializable{

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 2497394265415553411L;

	/**
	 * ssnrop
	 */
	private SSNROP ssnrop;
	
	/**
	 * objetoRespuesta
	 */
	private DatosSalidaPermanencia objetoRespuesta;

	public SSNROP getSsnrop() {
		return ssnrop;
	}

	public void setSsnrop(SSNROP ssnrop) {
		this.ssnrop = ssnrop;
	}

	public DatosSalidaPermanencia getObjetoRespuesta() {
		return objetoRespuesta;
	}

	public void setObjetoRespuesta(DatosSalidaPermanencia objetoRespuesta) {
		this.objetoRespuesta = objetoRespuesta;
	}
	
	
	
	
}
