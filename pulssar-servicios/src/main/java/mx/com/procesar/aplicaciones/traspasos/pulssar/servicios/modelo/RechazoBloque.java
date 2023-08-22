package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.util.HashMap;
import java.util.List;

public class RechazoBloque {
	
	private String bloque;
	
	private String estatus;
	
	private List<HashMap<String,String>> rechazos;

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public List<HashMap<String,String>> getRechazos() {
		return rechazos;
	}

	public void setRechazos(List<HashMap<String,String>> rechazos) {
		this.rechazos = rechazos;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RechazoBloque [bloque=");
		builder.append(bloque);
		builder.append(", estatus=");
		builder.append(estatus);
		builder.append(", rechazos=");
		builder.append(rechazos);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
