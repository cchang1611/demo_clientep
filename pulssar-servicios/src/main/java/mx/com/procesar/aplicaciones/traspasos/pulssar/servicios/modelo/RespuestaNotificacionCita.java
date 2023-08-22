package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * POJO de respuesta de datos para la cita
 * 
 * @author mahernan
 *
 */
public class RespuestaNotificacionCita implements Serializable {

	/**
	 * serial version
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Oct 30, 2019
	 */
	private static final long serialVersionUID = -7499002840931983993L;
	/**
	 * Estatus del envío (1=Enviado exitoso, 0=Enviado con error)
	 */
	private Long estatusEnvio;
	/**
	 * Motivo rechazo
	 */
	private String detalleError;  
	/**
	 * Mapa de respuesta
	 * @author Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 */
	private List<?> listaRespuesta;
	/**
	 * @return the estatusEnvio
	 */
	public Long getEstatusEnvio() {
		return estatusEnvio;
	}
	/**
	 * @param estatusEnvio the estatusEnvio to set
	 */
	public void setEstatusEnvio(Long estatusEnvio) {
		this.estatusEnvio = estatusEnvio;
	}
	/**
	 * @return the chDetalleError
	 */
	public String getDetalleError() {
		return detalleError;
	}
	/**
	 * @param chDetalleError the chDetalleError to set
	 */
	public void setDetalleError(String detalleError) {
		this.detalleError = detalleError;
	}
	
	/**
	 * @return the listaRespuesta
	 */
	public List<?> getListaRespuesta() {
		return listaRespuesta;
	}
//	/**
//	 * @return the listaRespuesta
//	 */
//	public List<?> getListaRespuestaMapper(Class<?> clas) {
//		ObjectMapper mapper = new ObjectMapper();
//		return mapper.convertValue(listaRespuesta, List<clas>.getClass());
//	}
	/**
	 * @param listaRespuesta the listaRespuesta to set
	 */
	public void setListaRespuesta(List<?> listaRespuesta) {
		this.listaRespuesta = listaRespuesta;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @Author: Ricardo Alcantara Ramirez (RALCANTA@inet.procesar.com.mx)
	 * Oct 30, 2019
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RespuestaNotificacionCita [estatusEnvio=");
		builder.append(estatusEnvio);
		builder.append(", detalleError=");
		builder.append(detalleError);
		builder.append(", listaRespuesta=");
		builder.append(listaRespuesta);
		builder.append("]");
		return builder.toString();
	}
}
