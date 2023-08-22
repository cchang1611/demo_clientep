/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * lista de huellas recibidas por el servixio de recepcion de archivos
 * @author jcgarces
 *
 */
@XmlRootElement(name="huellasDactilares")
public class HuellasDactilares implements Serializable{
	
	/**
	 * serial
	 */
	private static final long serialVersionUID = -783824331815229594L;
	
	/**
	 * hhuellas datilares 
	 */
	private List<HuellaDactilar> huellaDactilar;

	/**
	 * @return the huellaDactilar
	 */
	public List<HuellaDactilar> getHuellaDactilar() {
		if(huellaDactilar == null){
			huellaDactilar = new ArrayList<>();
		}
		return huellaDactilar;
	}

	/**
	 * @param huellaDactilar the huellaDactilar to set
	 */
	public void setHuellaDactilar(List<HuellaDactilar> huellaDactilar) {
		this.huellaDactilar = huellaDactilar;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HuellasDactilares [huellaDactilar=");
		builder.append(huellaDactilar);
		builder.append("]");
		return builder.toString();
	}


	

}
