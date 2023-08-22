/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.BitacoraReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BitacoraService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * clase de prueba para servicio de bitacora
 * 
 * @author hjramire
 * @version 1.0
 * @since 12/02/2020, 18:58:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class BitacoraServiceTestCase {

	/**
	 * Definicion de Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(BitacoraServiceTestCase.class);
	
	/**
	 * Cadena de contenido para archivo de prueba
	 */
	private static final String CONTENIDO_ARCHIVO_PRUEBA = "13806224229,62735509374,04866240395,04664901784,72008010109,92048550906,63805707625,14905800554,49836405396,39876706449,04735735922,24887206563,03927424337,84937524860,62715200168,04016609572,54795638482,63866808650,32968057813,92887004875,03148804051,54321678901,92967810869,89975231255,78965425879,54321678901,12345678002,55544328998,31715301813,35048615740,09876543210,39170190301,92877012986,54743603359,09876543210,11785982189,09876543210,12345678900,00001000002,54321678901,35048615740,01005800998,00001000003,23543168301,42906605516,39977521861,01038100572,89098158374,49846111935,01047905003,09876543210,83885804902,52897024783,11139009366,98653241072,11775976167,12345678932,11936607701,01563861119,90977946111,28967712168,39108601574,64846200158,64846706774,75856633146,78038217614,01048422024,01907132367,06836516846,01695119329,23816207981,47957965594,22222222222,06705270590,04008032320,31907216233,90897013398,20907216400,92876962538,16885300869,16008508935,31007908705,31906722009,16876313244,32997621035,04885823221,33996913670,41835100730,61916908413,43876515164,33745514845,65037907774,11967509776,72876828657,53937606936,20916107921,11916923615,01876912120,07876805669,";

	/**
	 * Instancia del servicio de Reporte de Bitacora de consultas
	 */
	@Autowired
	private BitacoraService bitacoraReporteService;

	/**
	 * Prueba NumConsultaEnDiaPorUsuario
	 * 
	 * @author hjramire void
	 * @since 12/02/2020, 18:58:36
	 */
	@Test
	public void testConsultarNumPorUsuarioEnDia() {
		try {
			int numeroReg = bitacoraReporteService.consultarNumPorUsuarioEnDia(1L, "hjmramire");

			if (numeroReg < 0) {
				fail("Prueba Incorrecta testConsultarNumPorUsuarioEnDia");
			}
			Assert.assertTrue("Prueba testConsultarNumPorUsuarioEnDia Correcta", true);
		} catch (Exception e) {
			logger.error("Error en prueba testConsultarNumPorUsuarioEnDia {}", e);
			fail("Prueba Incorrecta testConsultarNumPorUsuarioEnDia");
		}
	}

	/**
	 * Prueba RegistraBitacora
	 * 
	 * @author hjramire void
	 * @since 12/02/2020, 19:01:05
	 */
	@Test
	@Transactional(propagation=Propagation.REQUIRED, transactionManager="transactionManager")
	public void testRegistrarBitacora() {
		Map<String, String> param = new HashMap<>();
		param.put("fcInicial", "01/01/2017");
		param.put("fcFinal", "01/06/2018");
		param.put("nss", "12345678901");
		param.put("curp", "");
		param.put("idProcesar", "");
		try {
			bitacoraReporteService.registrarBitacora(1L, "hjramire", "192.168.0.1", param);
		} catch (Exception e) {
			logger.error("Error en prueba testRegistrarBitacora{}", e);
			fail("Prueba Incorrecta testRegistrarBitacora");
		}
	}

	/**
	 * Prueba RegistraBitacora
	 * 
	 * @author hjramire void
	 * @since 12/02/2020, 19:01:45
	 */
	@Test
	@Transactional(propagation=Propagation.REQUIRED, transactionManager="transactionManager")
	public void testRegistraBitacoraTruncado() {
		StringBuilder curps = new StringBuilder();
		curps.append(
				CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA)
				.append(CONTENIDO_ARCHIVO_PRUEBA);

		Map<String, String> param = new HashMap<>();
		param.put("fcInicial", "01/01/2017");
		param.put("fcFinal", "01/06/2018");
		param.put("nss", "12345678901");
		param.put("curp", curps.toString());
		param.put("idProcesar", "");
		try {
			bitacoraReporteService.registrarBitacora(1L, "hjramire", "192.168.0.1", param);
		} catch (Exception e) {
			logger.error("Error en prueba testRegistraBitacoraTruncado {}", e);
			fail("Prueba Incorrecta testRegistraBitacoraTruncado");
		}

	}

	/**
	 * Prueba ActualizabanderaExportacion
	 * 
	 * @author hjramire void
	 * @since 12/02/2020, 19:03:19
	 */
	@Test
	@Transactional(propagation=Propagation.REQUIRED, transactionManager="transactionManager")
	public void testActualizarBanderaExportacionBitacoraReporteInt() {
		BitacoraReporte bitacoraReporte = new BitacoraReporte();
		bitacoraReporte.setIdBitacoraReporte(100L);
		bitacoraReporte.setIdReporteGenerico(2L);
		bitacoraReporte.setUsuario("hjramire");
		bitacoraReporte.setIpOrigen("192.168.1.1");
		bitacoraReporte.setFechaEjecucion(new Date());
		bitacoraReporte.setFcControl(new Date());
		bitacoraReporte.setParametros("nss = N/A");
		bitacoraReporte.setUsuarioModificador("Sistema Minerva");

		try {
			bitacoraReporteService.actualizarBanderaExportacion(bitacoraReporte, 1);
		} catch (Exception e) {
			logger.error("Error en prueba testActualizarBanderaExportacionBitacoraReporteInt {}", e);
			fail("Prueba Incorrecta testActualizarBanderaExportacionBitacoraReporteInt");
		}
	}

	/**
	 * Prueba ConsultaPorRangoFechas
	 * 
	 * @author hjramire void
	 * @since 12/02/2020, 19:03:30
	 */
	@Test
	public void testConsultarPorRangoFechas() {
		try {
			bitacoraReporteService.consultarPorRangoFechas("01/01/2017", "01/01/2018");
		} catch (Exception e) {
			logger.error("Error en prueba testConsultarPorRangoFechas {}", e);
			fail("Prueba Incorrecta testConsultarPorRangoFechas");
		}
	}

	/**
	 * Prueba ConsultaPorUsuario
	 * 
	 * @author hjramire void
	 * @since 12/02/2020, 19:04:27
	 */
	@Test
	public void testConsultarPorUsuario() {
		try {
			bitacoraReporteService.consultarPorUsuario("hjramire");
		} catch (Exception e) {
			logger.error("Error en prueba testConsultarPorUsuario {}", e);
			fail("Prueba Incorrecta testConsultarPorUsuario");
		}
	}

	/**
	 * Prueba ConsultaPorIpUsuario
	 * 
	 * @author hjramire void
	 * @since 12/02/2020, 19:05:11
	 */
	@Test
	public void testConsultarPorIpUsuario() {
		try {
			bitacoraReporteService.consultarPorIpUsuario("192.168.1.1");
		} catch (Exception e) {
			logger.error("Error en prueba testConsultarPorIpUsuario {}", e);
			fail("Prueba Incorrecta testConsultarPorIpUsuario");
		}
	}

	/**
	 * Prueba de servicio de ActualizarBanderaExportacion
	 * 
	 * @author hjramire void
	 * @since 12/02/2020, 19:05:43
	 */
	@Test
	@Transactional(propagation=Propagation.REQUIRED, transactionManager="transactionManager")
	public void testActualizarBanderaExportacionLongInt() {
		try {
			bitacoraReporteService.actualizarBanderaExportacion(295L, 1);
		} catch (Exception e) {
			logger.error("Error en prueba testActualizarBanderaExportacionLongInt {}", e);
			fail("Prueba Incorrecta testActualizarBanderaExportacionLongInt");
		}
	}

}
