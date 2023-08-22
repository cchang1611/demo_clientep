/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.TurnoConstants.CLAVE_TIPO_SERVICIO_TURNOS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.Servicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.ServicioRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.TipoServicioService;

/**
 * Implementa los servicios para los tipos de servicios.
 * 
 * @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
 *
 */
@Service
public class TipoServicioServiceImpl implements TipoServicioService {

	/**
	 * Reposotorio para las operaciones relacionadas con los Tipos de Servicio.
	 */
	@Autowired
	private ServicioRepository servicioRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.
	 * TipoServicioService#buscarServiciosTurnos()
	 */
	@Override
	public List<Servicio> buscarServiciosTurnos() {
		
		return new ArrayList<>(servicioRepository.findByClaveServicio(CLAVE_TIPO_SERVICIO_TURNOS));
	}

}
