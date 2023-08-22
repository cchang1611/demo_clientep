/**
 * 
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.NipFoliadoServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * Verifica: NipFoliadoServiceImpl
 * @author MALOPEZT
 * @since 2022/02/08
 */
public class NipFoliadoServiceTestCase {

	/** Utileria cadenas*/
	@Mock
	private CadenasUtils utileriaCadena;
	
	/** Servicio encargado de generación y cierre de Folios */
	@Mock
	private FolioService servicioFolio;
	
	/** Flujo Rosa - Verifica: NipFoliadoServiceImpl */
	@Test
	public void test_EscenarioRosa() {
		
		//Inicio
		NipFoliadoServiceImpl nipFoliado = new NipFoliadoServiceImpl();
		servicioFolio = Mockito.mock(FolioService.class);
		utileriaCadena = Mockito.mock(CadenasUtils.class);
		ReflectionTestUtils.setField(nipFoliado, "servicioFolio", servicioFolio);
		ReflectionTestUtils.setField(nipFoliado, "utileriaCadena", utileriaCadena);
		String tiempoLlegada = "135415";
		long idUser = 1L;
		String curp = "UNA_CURP";
		String nss = "01234567890";
		String sucursal = "UNA_SUCURSAL";
		
		FolioEntrada salida = new FolioEntrada();
		salida.setCurp(curp);
		salida.setIdUsuario(idUser);
		salida.setNss(nss);
		salida.setResultado(ServiciosConstants.RESULTADO_OK);
		salida.setSucursal(sucursal);
		salida.setIdFolio(1L);
		Mockito.when(servicioFolio.generarFolio((FolioEntrada)Mockito.any())).thenReturn(salida);
		// Ejecución
		nipFoliado.generarFolio(tiempoLlegada, idUser, curp, nss, sucursal);
		// Validaciones
		Mockito.verify(servicioFolio, Mockito.times(1)).generarFolio((FolioEntrada)Mockito.any());
		Mockito.verify(servicioFolio, Mockito.never()).cerrarFolio((Long)Mockito.any(), (Integer)Mockito.any());
		Mockito.verify(utileriaCadena, Mockito.times(1)).obtenerContenidoCadenaSinEspacios(curp, null);
		Mockito.verify(utileriaCadena, Mockito.times(1)).obtenerContenidoCadenaSinEspacios(nss, null);
	}

	/** Flujo Rosa - Verifica: NipFoliadoServiceImpl - resultado No Ok */
	@Test
	public void test_EscenarioRosa_ResultadoFolio_No_OK() {
		
		//Inicio
		NipFoliadoServiceImpl nipFoliado = new NipFoliadoServiceImpl();
		servicioFolio = Mockito.mock(FolioService.class);
		utileriaCadena = Mockito.mock(CadenasUtils.class);
		ReflectionTestUtils.setField(nipFoliado, "servicioFolio", servicioFolio);
		ReflectionTestUtils.setField(nipFoliado, "utileriaCadena", utileriaCadena);
		String tiempoLlegada = "135415";
		long idUser = 1L;
		String curp = "UNA_CURP";
		String nss = "01234567890";
		String sucursal = "UNA_SUCURSAL";
		
		FolioEntrada salida = new FolioEntrada();
		salida.setCurp(curp);
		salida.setIdUsuario(idUser);
		salida.setNss(nss);
		salida.setResultado(ServiciosConstants.RESULTADO_NOK);
		salida.setSucursal(sucursal);
		salida.setIdFolio(1L);
		Mockito.when(servicioFolio.generarFolio((FolioEntrada)Mockito.any())).thenReturn(salida);
		// Ejecución
		nipFoliado.generarFolio(tiempoLlegada, idUser, curp, nss, sucursal);
		// Validaciones
		Mockito.verify(servicioFolio, Mockito.times(2)).generarFolio((FolioEntrada)Mockito.any());
		Mockito.verify(servicioFolio, Mockito.times(1)).cerrarFolio((Long)Mockito.any(), (Integer)Mockito.any());
		Mockito.verify(utileriaCadena, Mockito.times(1)).obtenerContenidoCadenaSinEspacios(curp, null);
		Mockito.verify(utileriaCadena, Mockito.times(1)).obtenerContenidoCadenaSinEspacios(nss, null);
	}
}
