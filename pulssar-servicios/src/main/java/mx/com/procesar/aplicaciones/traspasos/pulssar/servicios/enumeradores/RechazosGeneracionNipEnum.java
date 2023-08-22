/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * Describe los motivos de rechazo asociados a una solicitud de Generaciónde NIP
 * @author malopezt
 * @since 25/02/2022
 */
public enum RechazosGeneracionNipEnum {

	/** C03 */
	MOTIVO_C03("C03", "No est!s registrado con ninguna AFORE"),
	
	/** G04*/
	MOTIVO_G04("G04", "No est!s registrado con la AFORE solicitante"),
	
	/** 02Q*/
	MOTIVO_02Q("02Q", "Error al generar la petici!n de generaci!n de NIP"),
	
	/** 862*/
	MOTIVO_862("862", "El NSS enviado es incorrecto"),
	
	/** B66*/
	MOTIVO_B66("B66", "Inconsistencias en la base de datos con tu CURP"),
	
	/** 015*/
	MOTIVO_015("015", "El NSS no se encuentra registrado en base de datos"),
	
	/** A16*/
	MOTIVO_A16("A16", "Correo electr!nico asociado a otro usuario en base de datos"),
	
	/** F19*/
	MOTIVO_F19("F19", "N!mero celular asociado a otro usuario en base de datos"),
	
	/** D55*/
	MOTIVO_D55("D55", "No cuenta con Expediente de Identificaci!n"),
	
	/** D96*/
	MOTIVO_D96("D96", "No cuenta con un Expediente Biom!trico"),
	
	/** A49*/
	MOTIVO_A49("A49", "Indicador de generaci!n inv!lido"),
	
	/** A56*/
	MOTIVO_A56("A56", "La CURP del Ahorrador cuenta con un NIP relacionado"),
	
	/** F93*/
	MOTIVO_F93("F93", "El Ahorrador no cuenta con expediente m!vil");
	
	/** Motivo de rechazo */
	private String motivo;
	
	/** Descripción asociada al rechazo*/
	private String descripcion;
	
	/** Constructor*/
	private RechazosGeneracionNipEnum(final String motivo, final String descripcion) {
		this.motivo = motivo;
		this.descripcion = descripcion;
	}
	
	/**
	 * Obtiene el Enum asociado al parámetro pasado.
	 * Devuelve nulo ni no encuentra un elemento asociado
	 * @param motivo
	 * @return
	 */
	public static RechazosGeneracionNipEnum obtenerMotivoEnum(String motivo) {
		RechazosGeneracionNipEnum regreso = null;
		if (motivo != null) {
			for (RechazosGeneracionNipEnum e : RechazosGeneracionNipEnum.values()) {
				if (e.getMotivo().equals(motivo)) {
					regreso = e;
				}
			}
		}
		return regreso;
	}


	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}


	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
}
