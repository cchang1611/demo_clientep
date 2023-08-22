package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuentaIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DisposicionIsssteEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioDetalle;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IrecTcSubcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ResolucionDisposicionIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Disposicion total
 * @author RARREOLA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class DisposicionTotalIsssteServiceTestCase {
	
	/**
	 * DisposicionTotalIsssteService
	 */
	@Autowired
	private DisposicionTotalIsssteService disposicionTotalIsssteService;
	
	
	
	
	
	
	/**
	 * Para consultar no cargado issste
	 */
	@Test
	public void testConsultarNoCargadoIssste () {
		try {
			DisposicionIsssteEntrada entrada = new DisposicionIsssteEntrada();
			
			disposicionTotalIsssteService.consultarNoCargadoIssste(entrada);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Para setear datos
	 */
	@Test
	public void testSetearDatosResol() {
		try {
			List<ResolucionDisposicionIssste> lista = new ArrayList<>();
			ResolucionDisposicionIssste objeto = new ResolucionDisposicionIssste();
			objeto.setFechaEmision(new Date());
			objeto.setFechaInicioPension(new Date());
			objeto.setCvTipoRegimen("RO");
			objeto.setCvTipoRetiro("A");
			lista.add(objeto);
			List<Parametro> lparametro = new ArrayList<>();
			Parametro obj = new Parametro();
			obj.setChParametro("RO01");
			obj.setChValorParametro("A,B,C,D,E,G,I,K,M,O");
			lparametro.add(obj);
			disposicionTotalIsssteService.setearDatosResol(lista, lparametro, "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarIsssteRetiroC () {
		try {
			DisposicionIsssteEntrada entrada = new DisposicionIsssteEntrada();
			disposicionTotalIsssteService.consultarIsssteRetiroC(entrada);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	

	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarMatrizDerecho () {
		try {
			disposicionTotalIsssteService.consultarMatrizDerecho("01", "01", "01", "01", "01", "01", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerDerechoSubcuentaPorIdMatrizDerecho () {
		try {
			disposicionTotalIsssteService.obtenerDerechoSubcuentaPorIdMatrizDerecho(123L);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarIsssteRegimenOrdinario() {
		try {
			DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
			DatosTrabajador trabajador = new DatosTrabajador();
			disposicionTotalIsssteService.consultarIsssteRegimenOrdinario(entradaParams);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarIsssteDisposicionTotal() {
		try {
			DatosGeneralesDispIssste entradaParams = new DatosGeneralesDispIssste();
			DatosTrabajador trabajador = new DatosTrabajador();
			disposicionTotalIsssteService.consultarIsssteDisposicionTotal(entradaParams);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	

	/**
	 * Obtener edad del trabajador
	 */
	@Test
	public void testObtenerEdadTrabajador() {
		try {
			
			disposicionTotalIsssteService.obtenerEdadTrabajador("03/agosto/1950");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Obtener retiros
	 */
	@Test
	public void testObtenerRetirosNoCargadoRO() {
		try {
			List<Parametro> lparametro = new ArrayList<>();
			Parametro obj = new Parametro();
			obj.setChParametro("RO01");
			obj.setChValorParametro("A,B,C,D,E,G,I,K,M,O");
			lparametro.add(obj);
			disposicionTotalIsssteService.obtenerTipoRetirosIdSolicitanteNoCargado(lparametro, "RO", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Obtener retiros
	 */
	@Test
	public void testObtenerRetirosNoCargadoDT() {
		try {
			List<Parametro> lparametro = new ArrayList<>();
			Parametro obj = new Parametro();
			obj.setChParametro("DT01");
			obj.setChValorParametro("A,B,C,D,E,G,I,K,M,O");
			lparametro.add(obj);
			disposicionTotalIsssteService.obtenerTipoRetirosIdSolicitanteNoCargado(lparametro, "DT", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Obtener retiros
	 */
	@Test
	public void testObtenerRetirosPlanPrivado() {
		try {
			List<Parametro> lparametro = new ArrayList<>();
			Parametro obj = new Parametro();
			obj.setChParametro("RO01");
			obj.setChValorParametro("A,B,C,D,E,G,I,K,M,O");
			lparametro.add(obj);
			disposicionTotalIsssteService.validarSolicitantesPlanPrivado(lparametro, "01", "RO");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Obtener retiros
	 */
	@Test
	public void testObtenerRetirosPlanPrivadoVacio() {
		try {
			List<Parametro> lparametro = new ArrayList<>();
			Parametro obj = new Parametro();
			obj.setChParametro("RO01");
			obj.setChValorParametro("A,B,C,D,E,G,I,K,M,O");
			lparametro.add(obj);
			disposicionTotalIsssteService.validarSolicitantesPlanPrivado(lparametro, "01",null);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarExistenciaCurp() {
		try {
			disposicionTotalIsssteService.validarCurpExiste("GUHC590806MVZTRR02");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerEstatusViviendaIssste () {
		try {
			List<String> lista = new ArrayList<>();
			disposicionTotalIsssteService.obtenerEstatusViviendaIssste(lista);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testAgruparListaSubcuentas () {
		try {
			List<DerechoSubcuentaIssste> lista = new ArrayList<>();
			DerechoSubcuentaIssste obje = new DerechoSubcuentaIssste();
			IrecTcSubcuenta obj = new IrecTcSubcuenta();
			obj.setCvSubCuenta("02");
			obje.setCvSubCuenta(obj);
			lista.add(obje);
			disposicionTotalIsssteService.agruparListaSubcuentas(lista);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerPrecioAccion () {
		try {
		
			disposicionTotalIsssteService.obtenerPrecioAccion("01", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerFactorConversion () {
		try {
			disposicionTotalIsssteService.obtenerFactorConversion("01", "01", "01");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testObtenerSiefores () {
		try {
			disposicionTotalIsssteService.obtenerSiefores(1L);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	

	/**
	 * Obtener saldos rcv
	 */
	@Test
	public void testObtenerCombinacionSubcuentasSaldosRcv () {
		try {
			List<DerechoSubcuentaIssste> lista = new ArrayList<>();
			DerechoSubcuentaIssste obj = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj2 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj3 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj4 = new DerechoSubcuentaIssste();
			DerechoSubcuentaIssste obj5 = new DerechoSubcuentaIssste();
			IrecTcSubcuenta cvSubCuenta = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta2 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta3 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta4 = new IrecTcSubcuenta();
			IrecTcSubcuenta cvSubCuenta5 = new IrecTcSubcuenta();
			DatosSaldos saldo = new DatosSaldos(); 
			DisposicionIsssteEntrada entradaParams = new DisposicionIsssteEntrada();
			cvSubCuenta.setCvSubCuenta("15");
			cvSubCuenta2.setCvSubCuenta("22");
			cvSubCuenta3.setCvSubCuenta("25");
			cvSubCuenta4.setCvSubCuenta("27");
			cvSubCuenta5.setCvSubCuenta("28");
			obj.setCvSubCuenta(cvSubCuenta);
			obj2.setCvSubCuenta(cvSubCuenta2);
			obj3.setCvSubCuenta(cvSubCuenta3);
			obj4.setCvSubCuenta(cvSubCuenta4);
			obj5.setCvSubCuenta(cvSubCuenta5);
			saldo.setSaldoAportaCompRetiro("200");
			saldo.setSaldoRetiro92I("1234.3");
			saldo.setSaldoRetiroI08("345.5");
			saldo.setSaldoCVI("2000.4");
			saldo.setSaldoAhorroSolidario("3456.77");
			saldo.setSaldoViviendaFI92("54.2");
			saldo.setSaldoFI08("876.5");
			saldo.setSaldoSar92("1500");
			lista.add(obj);
			lista.add(obj2);
			lista.add(obj3);
			lista.add(obj4);
			lista.add(obj5);
			entradaParams.setTipoRecurso("sief");
			disposicionTotalIsssteService.obtenerCombinacionSubcuentasSaldosRcv(lista, saldo, entradaParams);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testConsultarCancelacion() {
		try {
			DatosGeneralesDispIssste entrada = new DatosGeneralesDispIssste();
			entrada.setCurp("4444");
			entrada.setAforeTrabajador("3233");
			entrada.setFolioSol("9876XXXXXXESS ");
			entrada.setNss("23434");
			entrada.setSecuenciaPension("345");
			disposicionTotalIsssteService.consultarCancelacion(entrada);
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	/**
	 * Consultar datos
	 */
	@Test
	public void testValidarCancelacion () {
		try {
			List<FolioSalida> folios = new ArrayList<>();
			List<FolioDetalle> folisoDetalle = new ArrayList<>();
			FolioDetalle obj1 = new FolioDetalle();
			obj1.setIdProceso(365L);
			folisoDetalle.add(obj1);
			FolioSalida obj = new FolioSalida();
			obj.setFolioDetalles(folisoDetalle);
			obj.setIdFolioPulssar(123L);
			folios.add(obj);
			DatosTrabajador trabajador = new DatosTrabajador();
			disposicionTotalIsssteService.validarCancelacion(folios, trabajador, folios, "123");
		} catch(Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
}
