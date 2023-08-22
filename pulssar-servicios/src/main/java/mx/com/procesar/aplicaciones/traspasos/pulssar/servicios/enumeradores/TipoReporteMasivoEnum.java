package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores;

/**
 * enumeracion con tipos de reportes masivos permitidos
 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
 * @version 1.0
 * @since 
 */
public enum TipoReporteMasivoEnum {

	REPORTE_POR_CURP(0), 
	REPORTE_POR_NSS(1), 
	REPORTE_POR_ID_PROCESAR(2), 
	REPORTE_RANGO_FECHAS(-1);

	/**
	 * Clave tipo Reporte
	 */
	private int cvTipoReporte;

	/**
	 * Constructor para asignar el tipo de reporte
	 * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
	 * @param cvTipoReporte
	 */

	TipoReporteMasivoEnum(int cvTipoReporte) {
		this.cvTipoReporte = cvTipoReporte;
	}

	/**
	 * @return el atributo cvTipoReporte
	 */
	public int getCvTipoReporte() {
		return cvTipoReporte;
	}

}
