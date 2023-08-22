package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.util.ArrayList;
import java.util.List;

public class EntidadFederativaList {
	
	private List<EntidadFederativa> entidadesFederativas;

	public EntidadFederativaList() {
		
		this.entidadesFederativas = new ArrayList<>();
	}

	public List<EntidadFederativa> getEntidadesFederativas() {
		return entidadesFederativas;
	}

	public void setEntidadesFederativas(List<EntidadFederativa> entidadesFederativas) {
		this.entidadesFederativas = entidadesFederativas;
	}

}
