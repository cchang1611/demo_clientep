package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;


/**
 * Clase que contiene lista de Actuarios Autorizados
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 8, 2021
 */
public class ActuarioList implements Serializable{

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = -1258886898945673073L;

	/**
	 * listaActuario
	 */
	private List<Actuario> listaActuario;

	/**
	 * @return el atributo listaActuario
	 */
	public List<Actuario> getListaActuario() {
		return listaActuario;
	}

	/**
	 * @param listaActuario parametro listaActuario a actualizar
	 */
	public void setListaActuario(List<Actuario> listaActuario) {
		this.listaActuario = listaActuario;
	}
	
	
}
