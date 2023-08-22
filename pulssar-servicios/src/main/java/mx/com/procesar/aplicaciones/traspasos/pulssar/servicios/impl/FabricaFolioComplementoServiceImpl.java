/**
 * FabricaFolioComplementoServiceImpl.java
 * Fecha de creación: Aug 26, 2021, 8:46:13 PM
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FabricaFolioComplementoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNoCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Domicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioComplemento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

/**
 * servicio FabricaFolioComplemento
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Aug 26, 2021
 */
@Service
public class FabricaFolioComplementoServiceImpl implements FabricaFolioComplementoService {
	
	/**
	 * utileriaValidador
	 */
	@Autowired
	private ValidadorUtils validadorUtils;
	
	/**
	 * utileriaCadena
	 */
	@Autowired
	private CadenasUtils cadenasUtils;

	/**
	 * Inyeccion de expediente
	 */
	@Autowired
	private ExpedienteService expedienteService;

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FabricaFolioComplementoService#enviarArchivosGenerico(java.lang.Long, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador, java.lang.String)
	 */
	@Override
	public FolioComplemento enviarArchivosGenerico(Long folio, UsuarioLogin user, DatosTrabajador trabajador, String cuentaClabe) {
		
		DatosCertificables datosCer = trabajador.getDatosCertificables();
		Domicilio domicilio = trabajador.getDatosComplementarios().getParticular();

		FolioComplemento folioComp = new FolioComplemento();
		folioComp.setIdFolio(folio);
		String tipoTrabajador = expedienteService.obtenerValoresPantalla(null, trabajador.getTipoAfiliacion());
		folioComp.setTipoTrabajador(tipoTrabajador);
		
		String agente = validadorUtils.validarVacio(user.getUsuarioAgente()) ? user.getUsuario() : user.getUsuarioAgente();
		folioComp.setAgentePromotor(agente);
		folioComp.setFechaControl(new Date());
		folioComp.setUsuarioModificador(user.getUsuario());
		folioComp.setApellioPaterno(cadenasUtils.obtenerContenidoCadenaSinEspacios(datosCer.getApellidoPaterno(), null));
		folioComp.setApellidoMaterno(cadenasUtils.obtenerContenidoCadenaSinEspacios(datosCer.getApellidoMaterno(), null));
		folioComp.setNombre(cadenasUtils.obtenerContenidoCadenaSinEspacios(datosCer.getNombre(), null));
		DatosNoCertificables datosNoCertificables = trabajador.getDatosNoCertificables();
		folioComp.setRfc(datosNoCertificables.getRfc());
		if(!isEmpty(domicilio)) {
			folioComp.setCalle(cadenasUtils.obtenerContenidoCadenaSinEspacios(domicilio.getCalle(), null));
			folioComp.setNumeroExterior(cadenasUtils.obtenerContenidoCadenaSinEspacios(domicilio.getNoExterior(), null));
			folioComp.setNumeroInterior(cadenasUtils.obtenerContenidoCadenaSinEspacios(domicilio.getNoInterior(), null));
			folioComp.setColonia(cadenasUtils.obtenerContenidoCadenaSinEspacios(domicilio.getColonia(), null));
			folioComp.setMunicipio(cadenasUtils.obtenerContenidoCadenaSinEspacios(domicilio.getMunicipio(), null));
			folioComp.setCodigo(cadenasUtils.obtenerContenidoCadenaSinEspacios(domicilio.getCodigoPostal(), null));
			folioComp.setEntidadFederativa(cadenasUtils.obtenerContenidoCadenaSinEspacios(domicilio.getClaveEntidadFed(), null));
		}
		
		folioComp.setCurp(cadenasUtils.obtenerContenidoCadenaSinEspacios(datosCer.getCurp(), null));
		folioComp.setCurpSolicitante(cadenasUtils.obtenerContenidoCadenaSinEspacios(datosCer.getCurp(), null));
		folioComp.setTipoSolicitante(trabajador.getTipoSolicitante());
		folioComp.setCuentaClabe(cadenasUtils.obtenerContenidoCadenaSinEspacios(cuentaClabe, null));

		return folioComp;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FabricaFolioComplementoService#generarDatosRecepcion(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public EnvioArchivos generarDatosRecepcion(UsuarioLogin user, String curp, String folio, String tipoAfiliacion,String cvTipoProceso) {
		EnvioArchivos datosRecepcion = new EnvioArchivos();
		datosRecepcion.setClaveAfore(user.getAforeUsuario());
		datosRecepcion.setCurpEmpleado(user.getCurpAgente());
		datosRecepcion.setCurpTrabajador(curp);
		datosRecepcion.setFolio(folio);
		datosRecepcion.setFolioIdentificacion(folio);
		datosRecepcion.setProceso(cvTipoProceso);
		datosRecepcion.setTipoArchivo(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);

		String tipoTrabajador = expedienteService.obtenerValoresPantalla(null, tipoAfiliacion);
		datosRecepcion.setTipoTrabajador(tipoTrabajador);
		return datosRecepcion;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FabricaFolioComplementoService#generarFolioParticipante(java.lang.Long, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta)
	 */
	@Override
	public FolioComplemento generarFolioParticipante(Long folio, UsuarioLogin user, DatosTrabajador trabajador,
			EntradaConsulta entradaConsulta) {
		FolioComplemento folioComp = new FolioComplemento();
		folioComp.setIdFolio(folio);
		String tipoTrabajador = expedienteService.obtenerValoresPantalla(null, trabajador.getTipoAfiliacion());
		folioComp.setTipoTrabajador(tipoTrabajador);
		
		String agente = validadorUtils.validarVacio(user.getUsuarioAgente()) ? user.getUsuario() : user.getUsuarioAgente();
		folioComp.setAgentePromotor(agente);
		folioComp.setFechaControl(new Date());
		folioComp.setUsuarioModificador(user.getUsuario());
		folioComp.setApellioPaterno(cadenasUtils.obtenerContenidoCadenaSinEspacios(entradaConsulta.getApellidoPaterno(), null));
		folioComp.setApellidoMaterno(cadenasUtils.obtenerContenidoCadenaSinEspacios(entradaConsulta.getApellidoMaterno(), null));
		folioComp.setNombre(cadenasUtils.obtenerContenidoCadenaSinEspacios(entradaConsulta.getNombre(), null));
		DatosNoCertificables datosNoCertificables = trabajador.getDatosNoCertificables();
		folioComp.setRfc(datosNoCertificables.getRfc());
		folioComp.setTipoSolicitante(trabajador.getTipoSolicitante());

		return folioComp;
	}

}
