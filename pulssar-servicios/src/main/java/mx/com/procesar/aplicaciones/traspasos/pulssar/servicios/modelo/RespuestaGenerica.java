package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Objeto Respuesta del servicio
 * 
 * @author FGARCIAF FEB 04, 2020
 */
public class RespuestaGenerica implements Serializable {

	/**
	 * seial version
	 * 
	 * @author FGARCIAF FEB 04, 2020
	 */
	private static final long serialVersionUID = -2134273621169989141L;

	/**
	 * Mensaje de error
	 */
	private String mensaje;

	/**
	 * Titulo del error
	 */
	private String titulo;

	/**
	 * Flujo del mensaje
	 */
	private int flujo;

	/**
	 * Objeto de respuesta
	 */
	private Object obRespuesta;

	/**
	 * Lista de objectos
	 */
	private List<?> lstObRespuesta;

	/**
	 * Flujo del mensaje
	 */
	private Map<String, Object> mapObject;
	
	/**
	 * Constructor
	 */
	public RespuestaGenerica() {
		
	}
	
    /**
     * Constructor
     * @param mensaje
     * @param titulo
     * @param flujo
     */
    public RespuestaGenerica(String mensaje,String titulo, int flujo) {
		this.mensaje = mensaje;
		this.titulo = titulo;
		this.flujo = flujo;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the flujo
	 */
	public int getFlujo() {
		return flujo;
	}

	/**
	 * @param flujo
	 *            the flujo to set
	 */
	public void setFlujo(int flujo) {
		this.flujo = flujo;
	}

	/**
	 * @return the obRespuesta
	 */
	public Object getObRespuesta() {
		return obRespuesta;
	}

	/**
	 * @param obRespuesta
	 *            the obRespuesta to set
	 */
	public void setObRespuesta(Object obRespuesta) {
		this.obRespuesta = obRespuesta;
	}

	/**
	 * @return the lstObRespuesta
	 */
	public List<?> getLstObRespuesta() {
		return lstObRespuesta;
	}

	/**
	 * @param lstObRespuesta
	 *            the lstObRespuesta to set
	 */
	public void setLstObRespuesta(List<?> lstObRespuesta) {
		this.lstObRespuesta = lstObRespuesta;
	}

	/**
	 * @return the mapObject
	 */
	public Map<String, Object> getMapObject() {
		return mapObject;
	}

	/**
	 * @param mapObject
	 *            the mapObject to set
	 */
	public void setMapObject(Map<String, Object> mapObject) {
		this.mapObject = mapObject;
	}

	/**
	 * Imprime la cadena del Objeto creado
	 * 
	 * @return strRespuesta
	 */
	@Override
	public String toString() {
		StringBuilder strRespuesta = new StringBuilder();
		strRespuesta.append("Respuesta [");
		if (mensaje != null) {
			strRespuesta.append("mensaje=");
			strRespuesta.append(mensaje);
		}
		if (titulo != null) {
			strRespuesta.append(", ");
			strRespuesta.append("titulo=");
			strRespuesta.append(titulo);
		}
		strRespuesta.append(", ");
		strRespuesta.append("flujo=");
		strRespuesta.append(flujo);
		if (obRespuesta != null) {
			strRespuesta.append(", ");
			strRespuesta.append("obRespuesta=");
			strRespuesta.append(obRespuesta);
		}
		if (lstObRespuesta != null) {
			strRespuesta.append(", ");
			strRespuesta.append("lstObRespuesta=");
			strRespuesta.append(lstObRespuesta.size());
		}
		if (mapObject != null) {
			strRespuesta.append(", ");
			strRespuesta.append("mapObject=");
			strRespuesta.append(mapObject.size());
		}

		strRespuesta.append("]");
		return strRespuesta.toString();
	}
}
