package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.emptyToNull;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.PRIMER_ELEMENTO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.USUARIO_PULSAR_ESTATUS_ACTIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum.EXCEPTION_GENERICA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum.PARAMETRO_NULO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.ConsultaUsuarioService;

/**
 * Implementa las operaciones de consulta para el Usuario
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
@Service
public class ConsultaUsuarioServiceImpl implements ConsultaUsuarioService {
	
	/**
	 * Logger para el servicio para la <b>Consulta de USuario</b>.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(ConsultaUsuarioServiceImpl.class);
	
	/**
	 * Repositorio para las operaciones sobre el usuario pulsar.
	 */
	@Autowired
	private UsuarioPulssarRepository usuarioPulssarRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsuarioPulssar buscarPorOrganizacionYUsuarioSesion(String claveOrganizacion, String usuarioLogueado) {
		
		// Valida los parametros obligatorios.
		validarParametrosEntradaOrganizacionYUsuarioSesion(claveOrganizacion, usuarioLogueado);
		
		// Se crea la lista para los estatus del USuario.
		final List<String> listaEstatusDelUsuario = ImmutableList.of(USUARIO_PULSAR_ESTATUS_ACTIVO).asList();

		List<UsuarioPulssar> listaDeUsuarios = usuarioPulssarRepository.findByUsuarioAndEstatus(claveOrganizacion, listaEstatusDelUsuario);
		
		// En caso de obtener una lista vacia arroja una excepción con 
		// el fin de no obtener excepciones no controladas.
		if (listaDeUsuarios.isEmpty()) {

			throw new GenericException(EXCEPTION_GENERICA,
					String.format("El usuario %s con organizacion %s no se encuentra registrado", usuarioLogueado,
							claveOrganizacion));
		}
		
		// Recupera el primer usuario encontrado denteo de la lista.
		return listaDeUsuarios.get(PRIMER_ELEMENTO);
	}
	
	/**
	 * Valida los paramtros de entrada para la consulta por clave de
	 * Organización y Usuario.
	 * 
	 * @param claveOrganizacion Clave de la Organizaicón
	 * @param usuarioLogueado Usuario en sesión.
	 */
	private void validarParametrosEntradaOrganizacionYUsuarioSesion(final String claveOrganizacion,
			final String usuarioLogueado) {
		
		try {
			checkNotNull(emptyToNull(claveOrganizacion), "El parametro clave de la Organizacion es requerido. ");
			checkNotNull(emptyToNull(usuarioLogueado),   "El parametro usuario es requerido. ");
		}
		catch (Exception e) {
			
			LOG.error("Error en la validacion de los parametros del consulta en el usuario: ", e);
			throw new GenericException(PARAMETRO_NULO, e.getMessage());
		}

	}

}
