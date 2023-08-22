package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;

/**
 * Archivo html para el envio de correo electronico
 * 
 * @author dbarbosa
 * @version 1.0
 */
public enum GeneroEnum {
	
	/**
	 * Genero Masculino
	 */
	MASCULINO("M", ExpresionesConstants.C_MASCULINO),
	
	/**
	 * Genero Femenino
	 */
	FEMENINO("F", ExpresionesConstants.C_FEMENINO),
	
	/**
	 * Genero Hombre
	 */
	HOMBRE("H", ExpresionesConstants.C_MASCULINO),
	
	/**
	 * Genero Mujer
	 */
	MUJER("M", ExpresionesConstants.C_FEMENINO),
	
	/**
	 * Genero Hombre
	 */
	THOMBRE("HOMBRE", ExpresionesConstants.C_MASCULINO),
	
	/**
	 * Genero Mujer
	 */
	TMUJER("MUJER", ExpresionesConstants.C_FEMENINO);
	
	/**
	 * Asunto
	 */
	private final String genero;
	
	/**
	 * Nombre del archivo
	 */
	private final String dscripcion;
	
	/**
	 * Constructor
	 * 
	 * @param asunto
	 * @param nombreArchivo
	 */
	private GeneroEnum(final String genero, final String dscripcion) {
		this.genero = genero;
		this.dscripcion = dscripcion;
	}
	
	/**
	 * @param clave
	 */
	public static GeneroEnum obtenerGenero(String clave) {
		GeneroEnum regreso = MASCULINO;
		
		for (GeneroEnum e : GeneroEnum.values()) {
			if (e.getGenero().equals(clave)) {
				regreso = e;
			}
		}
		return regreso;
	}
	
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @return the dscripcion
	 */
	public String getDscripcion() {
		return dscripcion;
	}
}