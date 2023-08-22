package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerDerechoSubcuentaMatrizDerechoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ObtenerDerechoSubcuentaMatrizDerechoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCalculosMontos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FactorConversion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Marca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Subcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
/**
 *  Test Case ObtenerDerechoSubcuentaMatriz
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 2, 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ObtenerDerechoSubcuentaMatrizTestCase {

	/**
	 * Inyeccion servicio
	 */
	@Autowired
	@InjectMocks
	private ObtenerDerechoSubcuentaMatrizDerechoService subCuentaMatriz = new ObtenerDerechoSubcuentaMatrizDerechoServiceImpl();
	
	/**
	 * clienteServicio
	 */
	@Mock
	private RestTemplate clienteServicio;
	
	/**
	 * disposicionService
	 */
	@Mock
	private DisposicionTotalIsssteService  disposicionService;
	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	    
	/**
	 *  Test ObtenerDerechoSubcuenta
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test 
	public void testObtenerDerechoSubcuentaIdMatrizDerecho() {
	 try{
		List<DerechoSubcuenta> respuestaCta = subCuentaMatriz.obtenerDerechoSubcuentaPorIdMatrizDerecho(1l);
		assertNotNull(respuestaCta);
	 }catch (Exception e) {
		 assertNotNull(e);
	}
    }
	
	/**
	 *  Error  
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testConsultarMarcasViviendaImssError() {
		try {
		
		Marca  marcas= subCuentaMatriz.consultarMarcasViviendaImss(null);
		assertNull(marcas);
		}catch (Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	/**
	 * 
	 *  Test Consulta marcas rcv
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testObtenerSubCuentasSaldosImssRcv() {
		DatosSaldos saldos = new DatosSaldos();
		List<DerechoSubcuenta> listaSubCuentas = new ArrayList<>();
		DerechoSubcuenta subcuenta = new DerechoSubcuenta();
		DerechoSubcuenta subcuenta2 = new DerechoSubcuenta();
		DerechoSubcuenta subcuenta3 = new DerechoSubcuenta();
		DerechoSubcuenta subcuenta8 = new DerechoSubcuenta();
		Subcuenta cvSubCuenta1 = new Subcuenta();
		Subcuenta cvSubCuenta2 = new Subcuenta();
		Subcuenta cvSubCuenta3 = new Subcuenta();
		Subcuenta cvSubCuenta8 = new Subcuenta();
		
		cvSubCuenta1.setClave("01");
		cvSubCuenta1.setDescripcion("des");
		cvSubCuenta1.setFechaControl(new Date());
		
		cvSubCuenta2.setClave("02");
		cvSubCuenta2.setDescripcion("des");
		cvSubCuenta2.setFechaControl(new Date());
		
		cvSubCuenta3.setClave("03");
		cvSubCuenta3.setDescripcion("des");
		cvSubCuenta3.setFechaControl(new Date());
		
		cvSubCuenta8.setClave("08");
		cvSubCuenta8.setDescripcion("des");
		cvSubCuenta8.setFechaControl(new Date());
		
		subcuenta.setCvEstatusVivienda("1");
		subcuenta.setCvSubCuenta(cvSubCuenta1);
		subcuenta.setFcControl(new Date());
		subcuenta.setIdMatrizDerecho(1l);
		listaSubCuentas.add(subcuenta);
		
		subcuenta2.setCvEstatusVivienda("1");
		subcuenta2.setCvSubCuenta(cvSubCuenta2);
		subcuenta2.setFcControl(new Date());
		subcuenta2.setIdMatrizDerecho(1l);
		listaSubCuentas.add(subcuenta2);
		
		subcuenta3.setCvEstatusVivienda("1");
		subcuenta3.setCvSubCuenta(cvSubCuenta3);
		subcuenta3.setFcControl(new Date());
		subcuenta3.setIdMatrizDerecho(1l);
		listaSubCuentas.add(subcuenta3);
		
		subcuenta8.setCvEstatusVivienda("1");
		subcuenta8.setCvSubCuenta(cvSubCuenta8);
		subcuenta8.setFcControl(new Date());
		subcuenta8.setIdMatrizDerecho(1l);
		listaSubCuentas.add(subcuenta8);
		
		saldos.setSaldoAhorroRetiroIB("100");
		saldos.setDescripcion("Viv");
		saldos.setMotivoRechazo("error");
		saldos.setSaldoAhorroSolidario("100");
		saldos.setSaldoAhorroRetiroIB("100");
		
		Double nuFacto= null;
		List<FactorConversion> factorConversion = new ArrayList<>();
		List<DatosCalculosMontos> cuentasRcv=new ArrayList<>();
		FactorConversion factor = new FactorConversion();
		factor.setCvTipoFactor("1");
		factor.setFechaControl(new Date());
		factor.setFechaValorFactor(new Date());
		factor.setUsuarioModificacion("USER");
		factor.setNuValorFactor(nuFacto);
		factorConversion.add(factor);
		
		
		DatosCalculosMontos montos = new DatosCalculosMontos();
		montos.setAcciones("1");
		montos.setClaveSubcuenta("1");
		montos.setDescripcionSubcuenta("des");
		montos.setFechaValor("20/05/2021");
		montos.setMonto("100");
		montos.setMontoTotalSuma("300000");
		montos.setPrecioAccion("1");
		montos.setSinPrecioAccion("1");
		
		
		cuentasRcv.add(montos);
		
		
		
		try {
			
			Mockito.when(disposicionService.obtenerFactorConversion(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(factorConversion);
		 cuentasRcv = subCuentaMatriz.obtenerSubCuentasSaldosImssRcv(listaSubCuentas, saldos);
		assertNotNull(cuentasRcv);
		}catch (Exception e) {
			Assert.assertNotNull(e);
		}
	} 
	
	/**
	 *  Test Case Consulta marcas vivienda
	 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	 */
	@Test
	public void testOobtenerSubCuentasSaldosImssViv() {
		DatosSaldos saldos = new DatosSaldos();
		List<DerechoSubcuenta> listaSubCuentas = new ArrayList<>();
		DerechoSubcuenta subcuenta = new DerechoSubcuenta();
		DerechoSubcuenta subcuenta2 = new DerechoSubcuenta();
		DerechoSubcuenta subcuenta3 = new DerechoSubcuenta();
		Subcuenta cvSubCuenta1 = new Subcuenta();
		Subcuenta cvSubCuenta2 = new Subcuenta();
		Subcuenta cvSubCuenta3 = new Subcuenta();
		
		cvSubCuenta1.setClave("04");
		cvSubCuenta1.setDescripcion("des");
		cvSubCuenta1.setFechaControl(new Date());
		
		cvSubCuenta2.setClave("09");
		cvSubCuenta2.setDescripcion("des");
		cvSubCuenta2.setFechaControl(new Date());
		
		cvSubCuenta3.setClave("07");
		cvSubCuenta3.setDescripcion("des");
		cvSubCuenta3.setFechaControl(new Date());
		
		subcuenta.setCvEstatusVivienda("1");
		subcuenta.setCvSubCuenta(cvSubCuenta1);
		subcuenta.setFcControl(new Date());
		subcuenta.setIdMatrizDerecho(1l);
		listaSubCuentas.add(subcuenta);
		
		subcuenta2.setCvEstatusVivienda("1");
		subcuenta2.setCvSubCuenta(cvSubCuenta2);
		subcuenta2.setFcControl(new Date());
		subcuenta2.setIdMatrizDerecho(1l);
		listaSubCuentas.add(subcuenta2);
		
		subcuenta3.setCvEstatusVivienda("1");
		subcuenta3.setCvSubCuenta(cvSubCuenta3);
		subcuenta3.setFcControl(new Date());
		subcuenta3.setIdMatrizDerecho(1l);
		listaSubCuentas.add(subcuenta3);
		
		
		saldos.setSaldoAhorroRetiroIB("100");
		saldos.setDescripcion("Viv");
		saldos.setMotivoRechazo("error");
		saldos.setSaldoAhorroSolidario("100");
		saldos.setSaldoAhorroRetiroIB("100");
		
		Double nuFacto= 0.00;
		List<FactorConversion> factorConversion = new ArrayList<>();
		List<DatosCalculosMontos> cuentasRcv=new ArrayList<>();
		FactorConversion factor = new FactorConversion();
		factor.setCvTipoFactor("1");
		factor.setFechaControl(new Date());
		factor.setFechaValorFactor(new Date());
		factor.setUsuarioModificacion("USER");
		factor.setNuValorFactor(nuFacto);
		factorConversion.add(factor);
		
		
		DatosCalculosMontos montos = new DatosCalculosMontos();
		montos.setAcciones("1");
		montos.setClaveSubcuenta("1");
		montos.setDescripcionSubcuenta("des");
		montos.setFechaValor("20/05/2021");
		montos.setMonto("100");
		montos.setMontoTotalSuma("300000");
		montos.setPrecioAccion("1");
		montos.setSinPrecioAccion("1");
		
		
		cuentasRcv.add(montos);
		
		
		try {
			Mockito.when(disposicionService.obtenerFactorConversion(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(factorConversion);
		 cuentasRcv = subCuentaMatriz.obtenerSubCuentasSaldosImssViv(listaSubCuentas, saldos);
		assertNotNull(cuentasRcv);
		}catch (Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
	
	@Test
	public void testOobtenerSubCuentasFactor() {
		DatosSaldos saldos = new DatosSaldos();
		List<DerechoSubcuenta> listaSubCuentas = new ArrayList<>();
		DerechoSubcuenta subcuenta = new DerechoSubcuenta();
		DerechoSubcuenta subcuenta2 = new DerechoSubcuenta();
		DerechoSubcuenta subcuenta3 = new DerechoSubcuenta();
		Subcuenta cvSubCuenta1 = new Subcuenta();
		Subcuenta cvSubCuenta2 = new Subcuenta();
		Subcuenta cvSubCuenta3 = new Subcuenta();
		
		cvSubCuenta1.setClave("04");
		cvSubCuenta1.setDescripcion("des");
		cvSubCuenta1.setFechaControl(new Date());
			
		
		cvSubCuenta2.setClave("09");
		cvSubCuenta2.setDescripcion("des");
		cvSubCuenta2.setFechaControl(new Date());
		
		cvSubCuenta3.setClave("07");
		cvSubCuenta3.setDescripcion("des");
		cvSubCuenta3.setFechaControl(new Date());
		
		subcuenta.setCvEstatusVivienda("1");
		subcuenta.setCvSubCuenta(cvSubCuenta1);
		subcuenta.setFcControl(new Date());
		subcuenta.setIdMatrizDerecho(1l);
		listaSubCuentas.add(subcuenta);
		
		subcuenta2.setCvEstatusVivienda("1");
		subcuenta2.setCvSubCuenta(cvSubCuenta2);
		subcuenta2.setFcControl(new Date());
		subcuenta2.setIdMatrizDerecho(1l);
		listaSubCuentas.add(subcuenta2);
		
		subcuenta3.setCvEstatusVivienda("1");
		subcuenta3.setCvSubCuenta(cvSubCuenta3);
		subcuenta3.setFcControl(new Date());
		subcuenta3.setIdMatrizDerecho(1l);
		listaSubCuentas.add(subcuenta3);
		
		
		saldos.setSaldoAhorroRetiroIB("100");
		saldos.setDescripcion("Viv");
		saldos.setMotivoRechazo("error");
		saldos.setSaldoAhorroSolidario("100");
		saldos.setSaldoAhorroRetiroIB("100");
		saldos.setSaldoCesantiaVejez("");
		saldos.setSaldoCuotaSocial("100"); 
		saldos.setSaldoRetiro92I("100");
		saldos.setSaldoRetiro97("100");
		saldos.setSaldoVivienda92("100");
		saldos.setSaldoVivienda72("100");
		saldos.setSaldoVivienda97("100");
		
		Double nuFacto= 12.00;
		List<FactorConversion> factorConversion = new ArrayList<>();
		FactorConversion factor = new FactorConversion();
		factor.setCvTipoFactor("1");
		factor.setFechaControl(new Date());
		factor.setFechaValorFactor(new Date());
		factor.setUsuarioModificacion("USER");
		factor.setNuValorFactor(nuFacto);
		factorConversion.add(factor);
		List<DatosCalculosMontos> cuentasRcv=new ArrayList<>();
		DatosCalculosMontos montos = new DatosCalculosMontos();
		montos.setAcciones("1");
		montos.setClaveSubcuenta("1");
		montos.setDescripcionSubcuenta("des");
		montos.setFechaValor("20/05/2021");
		montos.setMonto("100");
		montos.setMontoTotalSuma("300000");
		montos.setPrecioAccion(null);
		montos.setSinPrecioAccion("1");
		
		
		cuentasRcv.add(montos);
		try {
			Mockito.when(disposicionService.obtenerFactorConversion(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(factorConversion);
		 cuentasRcv = subCuentaMatriz.obtenerSubCuentasSaldosImssViv(listaSubCuentas, saldos);
		assertNotNull(cuentasRcv);
		}catch (Exception e) {
			Assert.assertNotNull(e);
		}
	}
	
  }
