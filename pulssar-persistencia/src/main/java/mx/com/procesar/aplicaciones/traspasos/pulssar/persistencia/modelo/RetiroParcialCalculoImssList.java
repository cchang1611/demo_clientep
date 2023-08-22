package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo;

import java.io.Serializable;
import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RetiroParcialCalculoImss;

public class RetiroParcialCalculoImssList implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private List<RetiroParcialCalculoImss> listaRetiroParcial;
	

	public List<RetiroParcialCalculoImss> getListaRetiroParcial() {
		return listaRetiroParcial;
	}

	public void setListaRetiroParcial(List<RetiroParcialCalculoImss> listaRetiroParcial) {
		this.listaRetiroParcial = listaRetiroParcial;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RetiroParcialCalculoImssList [listaRetiroParcial=");
		builder.append(listaRetiroParcial);
		builder.append("]");
		return builder.toString();
	}


	


}
