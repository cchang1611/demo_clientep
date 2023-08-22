package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PersonaSalida;

public interface PreConsultaTrabajadorService {

	/**
	 *  preconsultaCurpNss
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param nss
	 *  @param curp
	 *  @param afore
	 *  @return
	 */
	public List<PersonaSalida> preconsultaNss(String nss);
	
	/**
	 *  preconsultaCurp
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param curp
	 *  @param afore
	 *  @return
	 */
	public List<PersonaSalida> preconsultaCurp(String curp);
	
	/**
	 *  preconsultaCurpNss
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param nss
	 *  @param curp
	 *  @param afore
	 *  @return
	 */
	public List<PersonaSalida> preconsultaNssCurp(String nss, String curp);
	
	/**
	 *  getPreconsulta
	 *  @author Carlos Adrian Morales Hernandez (cmorales@procesar.com)
	 *  @param nss
	 *  @param curp
	 *  @param afore
	 *  @return
	 */
	public List<PersonaSalida> getPersonaConsulta(String nss, String curp);
	
	/**
	 *  getPreconsulta
	 *  @author Carlos Adrian Morales Hernandez (cmorales@procesar.com)
	 *  @param nss
	 *  @param curp
	 *  @param afore
	 *  @return
	 */
	public List<PersonaSalida> getPersonaConsulta(String nss, String curp, String afore);

}
