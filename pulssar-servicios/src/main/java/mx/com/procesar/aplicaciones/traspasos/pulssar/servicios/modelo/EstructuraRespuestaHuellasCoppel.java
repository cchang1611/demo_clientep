package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase encargada del objeto de entrada para el websocket
 * @author DBARBOSA
 *
 */
public class EstructuraRespuestaHuellasCoppel implements Serializable {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = 7910392434960791863L;

	/**
	 * id Dedo
	 */
	private List<EstructuraHuellasCoppel> huellaDactilar;

	/**
	 * @return the huellaDactilar
	 */
	public List<EstructuraHuellasCoppel> getHuellaDactilar() {
		return huellaDactilar;
	}

	/**
	 * @param huellaDactilar the huellaDactilar to set
	 */
	public void setHuellaDactilar(List<EstructuraHuellasCoppel> huellaDactilar) {
		this.huellaDactilar = huellaDactilar;
	}

	/**
	 * to string
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("EstructuraRespuestaHuellasCoppel [");
		cadena.append(" huellaDactilar =");
		cadena.append(huellaDactilar);
		cadena.append("]");
		
		return cadena.toString();
	}
}