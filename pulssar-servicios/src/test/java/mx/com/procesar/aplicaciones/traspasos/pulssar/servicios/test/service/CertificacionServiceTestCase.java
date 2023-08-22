package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.TipoRetiroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidarSolicitudCertificacionAforeSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Test para validar servicio de certificacion
 * @author JMGUTIER
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class CertificacionServiceTestCase {
	
	/**
	 * Inyeccion de servicio certificacion
	 */
	@Autowired
	private SolicitudDisposicionService servicioSolicitud;
	
	/**
	 * Inyeccion de servicio calculo tipo retiro
	 */
	@Autowired
	private TipoRetiroService servicioTipoRetiro;

	/**
	 * Test para validar certificado
	 */
	@Test
	public void testValidarCertificado() {
		ValidarSolicitudCertificacionAforeSalida valida = new ValidarSolicitudCertificacionAforeSalida();
		DatosTrabajador datos = new DatosTrabajador();
		FolioEntrada folio = new FolioEntrada();
		folio.setFolio("folio");
		datos.setFolio(folio);
		valida.setNss("nss");
		valida.setNombreTrabajador("nombre");
		valida.setApellidoPaterno("APaterno");
		valida.setApellidoMaterno("AMaterno");
		valida.setTipoTramite("Tipo tramite");
		valida.setTipoPrestacion("Tipo Presentacion");
		valida.setNumeroResolucion("numero");
		valida.setClaveAdminActual("556");
		valida.setSelloTrabajador("sello");
		valida.setCurpAgenteServicio("CURPAGENTE");
		valida.setIdSolicitante("ID");
		valida.setCurpSolicitante("CURPSOLICITANTE");
		/*SolicitudDisposicionParcial  respuesta = servicioSolicitud.solicitudDisposicion(valida, datos);
		assertNotNull(respuesta);*/
	}
	
	/**
	 * Test para obtener tipo retiro
	 */
	@Test
	public void testoSolicitudDisposicionSalida() {
		SolicitudDisposicionParcial disposicion = new SolicitudDisposicionParcial();
		disposicion.setFolioCliente("folio");
		disposicion.setNss("nss");
		disposicion.setNombreTrabajador("nombre");
		disposicion.setApellidoPaterno("apellido paterno");
		disposicion.setApellidoMaterno("apellido materno");
		disposicion.setTipoRetiro("tipo retiro");
		disposicion.setTipoPrestacion("tipo prestacion");
		disposicion.setNumeroResolucion("132435465453432");
		disposicion.setClaveAdminActual("clave admin acutal");
		disposicion.setCurpTrabajador("curp");
		disposicion.setSelloTrabajador("sello"); 
		disposicion.setCurpAgenteServicio("agente");
		disposicion.setCurpFuncionarioAutorizado("saddfgfhg");
		disposicion.setSelloFuncionarioAutorizado("wderstdryt");
		disposicion.setIdSolicitante("3232232");
		disposicion.setCurpSolicitante("dwefcdccewcecwwc");
		
//		SolicitudDisposicionParcialRespuesta respuesta = servicioSolicitud.solicitudDisposicionSalida(disposicion);
		
//		assertNotNull(respuesta);
	}
	
	@Test
	public void testObtenerTipoRetiro() throws IllegalArgumentException, IllegalAccessException{
		DatosSaldos saldos = new DatosSaldos();
		ValidarSolicitudCertificacionAforeSalida salida = new ValidarSolicitudCertificacionAforeSalida();
		salida.setSbcTipoA("tipoA");
		salida.setSbcTipoB("tipoB");
		saldos.setSaldoSar92("saldo92");
		saldos.setSaldoCesantiaVejez("saldoCensantia");
		
//		CalculoTipoRetiro respuesta = servicioTipoRetiro.obtenerTipoRetiro(salida, saldos);
//		assertNotNull(respuesta);
	}

}
