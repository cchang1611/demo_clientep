package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarDatosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosRegistro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * implementacion servicio ValidaRegistroService para validar el registro de un
 * usuario
 * 
 * @author OJBALBUE
 * @version 1.0
 */
@Service
public class ValidarDatosServiceImpl implements ValidarDatosService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ValidarDatosServiceImpl.class);

	/**
	 * Inyeccion utileria
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarDatos(DatosRegistro datosRegistro, boolean isConfirmaCel) {
		List<Object> camposEntrada = new ArrayList<>();
		
		this.obtenerRequeridos(datosRegistro, camposEntrada, isConfirmaCel);
		utileriaValidador.validarObjetosObligatorios(camposEntrada);
		this.validarEstructura(datosRegistro);

		logger.info("Finaliza validar datos de entrada");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validarDatosActivar(DatosRegistro datosRegistro) {
		List<Object> camposEntrada = new ArrayList<>();
		
		this.obtenerRequeridoCodigoConfirmacion(datosRegistro, camposEntrada);
		utileriaValidador.validarObjetosObligatorios(camposEntrada);

		logger.info("Finaliza validar datos de entrada de alta de usaurio");
	}
	
	private void obtenerRequeridoCodigoConfirmacion(DatosRegistro datosRegistro, List<Object> camposEntrada) {
		camposEntrada.add(datosRegistro.getNickUsuario());
		camposEntrada.add(datosRegistro.getPassword());
		camposEntrada.add(datosRegistro.getConfirmarPassword());
		camposEntrada.add(datosRegistro.getCodigo());
	}

	/**
	 * Metodo encargado de obtener los valores requeridos para un
	 * registro de usuario
	 * 
	 * @param datosRegistro
	 */
	private void obtenerRequeridos(DatosRegistro datosRegistro, List<Object> camposEntrada, boolean isAltaServicio) {
		camposEntrada.add(datosRegistro.getNombre());
		camposEntrada.add(datosRegistro.getApellidoPaterno());
		if(isAltaServicio) {
			camposEntrada.add(datosRegistro.getCorreo());
			camposEntrada.add(datosRegistro.getConfirmarCorreo());
		}
		if(!utileriaValidador.validarVacio(datosRegistro.getPassword())) {
			camposEntrada.add(datosRegistro.getPassword());
			camposEntrada.add(datosRegistro.getConfirmarPassword());
		}
		if(!utileriaValidador.validarVacio(datosRegistro.getCelular())) {
			camposEntrada.add(datosRegistro.getCelular());
			if(isAltaServicio) {
				camposEntrada.add(datosRegistro.getConfirmarCelular());
			}
		}
		camposEntrada.add(datosRegistro.getClaveAfore());
	}

	/**
	 * Metodo encargado de validar la estructura de los campos de entrada
	 * 
	 * 
	 * @param datosRegistro
	 */
	private void validarEstructura(DatosRegistro datosRegistro) {
		this.validarEstructuraNombre(datosRegistro);
		if(!utileriaValidador.validarVacio(datosRegistro.getCelular())){
			this.validarEstructuraTelefono(datosRegistro);
		}
		this.validarEstructuraCorreo(datosRegistro);
	}

	/**
	 * Metodo encargado de validar al estructura de los campos del nombre del
	 * registro de usuario
	 * 
	 * TODO: Falta especificar cuales son los caracteres especiales permitidos
	 * 
	 * @param datosRegistro
	 */
	private void validarEstructuraNombre(DatosRegistro datosRegistro) {
		utileriaValidador.validarLimiteCadena(datosRegistro.getNombre(), NumerosConstants.INT_CINCUENTA, GenericErrorEnum.ESTRUCTURA_INCORRECTA);
		utileriaValidador.validarLimiteCadena(datosRegistro.getApellidoPaterno(), NumerosConstants.INT_CINCUENTA, GenericErrorEnum.ESTRUCTURA_INCORRECTA);

		if (!utileriaValidador.validarVacio(datosRegistro.getApellidoMaterno())) {
			utileriaValidador.validarLimiteCadena(datosRegistro.getApellidoMaterno(), NumerosConstants.INT_CINCUENTA, GenericErrorEnum.ESTRUCTURA_INCORRECTA);
		}
	}

	/**
	 * Metodo que realiza las validaciones en los campos de telefono
	 * 
	 * @param datosRegistro
	 */
	private void validarEstructuraTelefono(DatosRegistro datosRegistro) {
		utileriaValidador.validarEsNumerica(datosRegistro.getCelular(), GenericErrorEnum.ESTRUCTURA_INCORRECTA);
		
		int tamanioCelular = datosRegistro.getCelular().length();
		if (NumerosConstants.INT_DIEZ != tamanioCelular || (!utileriaValidador.validarVacio(datosRegistro.getConfirmarCelular()) && !datosRegistro.getCelular().equals(datosRegistro.getConfirmarCelular()))) {
			throw new GenericException(GenericErrorEnum.ESTRUCTURA_INCORRECTA);
		}
	}

	/**
	 * Metodo que realiza las validaciones en los campos de correo electronico
	 * del usuario
	 * 
	 * @param datosRegistro
	 */
	private void validarEstructuraCorreo(DatosRegistro datosRegistro) {
		if(!utileriaValidador.validarVacio(datosRegistro.getCorreo())) {
			utileriaValidador.validarCorreo(datosRegistro.getCorreo(), GenericErrorEnum.ESTRUCTURA_INCORRECTA);
	
			if (!utileriaValidador.validarVacio(datosRegistro.getConfirmarCorreo()) && !datosRegistro.getCorreo().equals(datosRegistro.getConfirmarCorreo())) {
				throw new GenericException(GenericErrorEnum.ESTRUCTURA_INCORRECTA);
			}
		}
	}
}