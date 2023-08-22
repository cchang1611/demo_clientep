package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;

public class RespuestaSesion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9124619345831614403L;
	
	
	private RespuestaPdfPlataformaOperativa respuestaPdfPlataformaOperativa;
	private RespuestaExcel respuestaExcel;

	public RespuestaPdfPlataformaOperativa getRespuestaPdfPlataformaOperativa() {
		return respuestaPdfPlataformaOperativa;
	}

	public void setRespuestaPdfPlataformaOperativa(RespuestaPdfPlataformaOperativa respuestaPdfPlataformaOperativa) {
		this.respuestaPdfPlataformaOperativa = respuestaPdfPlataformaOperativa;
	}

	public RespuestaExcel getRespuestaExcel() {
		return respuestaExcel;
	}

	public void setRespuestaExcel(RespuestaExcel respuestaExcel) {
		this.respuestaExcel = respuestaExcel;
	}

}
