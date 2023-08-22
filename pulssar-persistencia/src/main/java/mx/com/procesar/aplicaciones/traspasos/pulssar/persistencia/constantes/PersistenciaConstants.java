package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.constantes;




public final class PersistenciaConstants {
	/**
	 * Query generico
	 */
	public static final String QUERY_GENERICO = "SELECT usuarioPulssar FROM UsuarioPulssar usuarioPulssar WHERE usuarioPulssar.claveOrganizacion = :clave AND usuarioPulssar.estatus IN :estatus ";
	/**
	 * Query usuario
	 */
	public static final String QUERY_USUARIO = " AND usuarioPulssar.usuario = :usuario";
	/**
	 * Query nombre
	 */
	public static final String QUERY_NOMBRE = " AND usuarioPulssar.nombre = :nombre AND usuarioPulssar.estatus IN :estatus AND usuarioPulssar.claveOrganizacion = :clave";
	/**
	 * Query apellido paterno
	 */
	public static final String QUERY_APELLIDO_PATERNO = " AND usuarioPulssar.apellidoPaterno = :apellidoPaterno";
	/**
	 * Query apellido materno
	 */
	public static final String QUERY_APELLIDO_MATERNO = " AND usuarioPulssar.apellidoMaterno = :apellidoMaterno";
	/**
	 * Query email
	 */
	public static final String QUERY_EMAIL = " AND usuarioPulssar.email = :email";
	/**
	 * Query celular
	 */
	public static final String QUERY_CELULAR = "AND usuarioPulssar.celular = :celular";
	/**
	 * Query usuario
	 */
	public static final String USUARIO = "usuario";
	/**
	 * Query nombre
	 */
	public static final String NOMBRE = "nombre";
	/**
	 * apellido paterno
	 */
	public static final String APELLIDO_PATERNO = "apellidoPaterno";
	/**
	 * apellido materno
	 */
	public static final String APELLIDO_MATERNO = "apellidoMaterno";
	/**
	 * email
	 */
	public static final String EMAIL = "email";
	/**
	 * celular
	 */
	public static final String CELULAR = "celular";
	/**
	 * estatus
	 */
	public static final String ESTATUS = "estatus";
	/**
	 * clave
	 */
	public static final String CLAVE = "clave";
	
//	public static final List<String> ESTATUS_USUARIO = new ArrayList<>();
//	
//	static{
//		ESTATUS_USUARIO.add(EstatusUsuarioEnum.USUARIO_ACTIVO.getEstatusUsuario());
//		ESTATUS_USUARIO.add(EstatusUsuarioEnum.USUARIO_ACTIVO_CAMBIO_PASSWORD.getEstatusUsuario());
//	}

}
