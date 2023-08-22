package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Permanencia reporte enum
 * @author jmordone
 *
 */
public enum PermanenciaReportesEnum {
	
	/**
	 * AFORE_XXI_BANORTE
	 */
	AFORE_XXI_BANORTE("BANORTE","530","530/RETS046006"),
	
	/**
	 * PROFUTURO_AFORE
	 */
	PROFUTURO_AFORE("PROFUTURO","534","534/RETS046006"),
	
	/**
	 * PRINCIPAL_AFORE
	 */
	PRINCIPAL_AFORE("PRINCIPAL_AFORE","538","538/RETS046006"),
	
	/**
	 * AFORE_SURA
	 */
	AFORE_SURA("SURA","544","544/RETS046006"),
	/**
	 * AFORE_INBURSA
	 */
	AFORE_INBURSA("INBURSA","550","550/RETS046006"),
	/**
	 * CITIBANAMEX_AFORE
	 */
	CITIBANAMEX_AFORE("CITI","552","552/RETS046006"),
	/**
	 * AFORE_AZTECA
	 */
	AFORE_AZTECA("AZTECA","556","556/RETS046006"),
	/**
	 * AFORE_INVERCAP
	 */
	AFORE_INVERCAP("INVERCAP","562","562/RETS046006"),
	/**
	 * AFORE_COPPEL
	 */
	AFORE_COPPEL("COPPEL","568","568/RETS046006"),
	/**
	 * PENSIONISSSTE
	 */
	PENSIONISSSTE("PENSIONISSTE","578","solicitudModificacionDatos");
	
	/**
	 * clave afore
	 */
	private final String nombreAfore;
	/**
	 * clave afore
	 */
	private final String claveAfore;
	
	/**
	 * Descripcion
	 */
	private final String nombreArchivo;

	/**
	 * Constructor
	 * 
	 * @param asunto
	 * @param nombreArchivo
	 */
	private PermanenciaReportesEnum(final String nombreAfore, final String claveAfore,final String nombreArchivo) {
		this.nombreAfore = nombreAfore;
		this.claveAfore = claveAfore;
		this.nombreArchivo = nombreArchivo;
	}
	
	
	/**
	 * @return the nombreAfore
	 */
	public String getNombreAfore() {
		return nombreAfore;
	}


	/**
	 * @return the claveAfore
	 */
	public String getClaveAfore() {
		return claveAfore;
	}

	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param clave
	 */
	public static PermanenciaReportesEnum obtenerArchivo(final String clave) {
		PermanenciaReportesEnum regreso = null;
		for (final PermanenciaReportesEnum e : PermanenciaReportesEnum.values()) {
			if (e.getClaveAfore().equals(clave)) {
				regreso = e;
				break;
			}
		}
		return regreso;
	}
}