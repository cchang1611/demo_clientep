package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes;


/**
 * Clase que contiene las constantes(presentacion) para <b>Reporteria
 * Banamex</b>.
 * 
 * @author ERICK HECTOR LUNA RAMIREZ <EHLUNARA@inet.procesar.com.mx>
 *
 */
public final class ReporteriaConstants {
	
	
	/**
	 * Constante que cocntiene la URL de la vista de inicio de
	 * <b>Reporteria</b>.
	 */
	public static final String PAGINA_INICIO_REPORTERIA = "/mx/com/procesar/plataforma/servicios/reporteria/inicioReporteria";
	
	
	/**
	 * Constante que cocntiene la URL de la vista de la consulta de reporteria
	 * <b>Reporteria</b>.
	 */
	public static final String PAGINA_CONSULTA_REPORTERIA = "/mx/com/procesar/plataforma/servicios/reporteria/consultaReporteria";
	
	
	/**
	 * Formato de una fecha 
	 */
	public static final String FORMATO_FECHA              ="dd/MM/yyyy";
	
	/**
	 * OPCION PARA SEMANAS
	 */
	public static final Integer OPCION_SEMANA            =1;
	
	
	/**
	 * OPCION PARA DIAS
	 */
	public static final Integer OPCION_DIAS               =2; 
	
	
	/**
	 * OPCION MES
	 */
	public static final Integer OPCION_MES               =3;
	

	/**
	 * PERFIL DE ADMNISTRADOR AFORE
	 */
	public static final String PERFIL_ADMINISTRADOR_AFORE = "03";
	
	
	
	/**
	 * MOSTRAR INFORMACION DE EJECUTIVO
	 */
	public static final Integer ES_EJECUTIVO=1;
	
	
	/**
	 * LA INFORMACION DE ADMINISTRADOR
	 */
	public static final Integer ES_ADMINISTRADOR=0;
	
	/**
	 * Mensaje de tiempo de busqueda de ejecutivo
	 */
	public static final String MSG_TIEMPO_EJECUTIVO="1 semana";
	
	/**
	 * Mensaje de tiempo de busqueda de administrados
	 */
	public static final String MSG_TIEMPO_ADMINISTRADOR="3 meses";
	
	/**
	 * Semanas que puede consultar el rol ejecutivo
	 */
	public static final Integer SEMANAS_EJECUTIVO=-1;
	
	
	/**
	 * Meses que puede consultar el rol Administrador 
	 */
	public static final Integer MES_ADMINISTRADOR=-3;
	
	
	/**
	 * Valor clave para el combo de servicios de Todos
	 */
	public static final String CLAVE_TODOS="999999";
	
	/**
	 * LEYENDA TODOS para el combo de servicios 
	 */
	public static final String LEYENDA_TODOS="Todos";
	

}
