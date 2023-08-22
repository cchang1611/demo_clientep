package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.http.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

import static org.apache.commons.lang.StringUtils.replace;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PreConsultaTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PersonaSalida;

public class PreConsultaTrabajadorServiceTestCase extends BaseTestCase {

	/**
	 * preConsultaTrabajadorService
	 */
	@Autowired
	private PreConsultaTrabajadorService preConsultaTrabajadorService;

	/**
	 * servidor mock
	 */
	static WireMockServer wm;

	/**
	 * @throws java.lang.Exception
	 */

	private String curp = "CXCA881204MCSHMN03";
	private String nss = "12099147535";
	private String vacio = "";
	private String afore = "578";
	private List<PersonaSalida> listaPersona = null;
	private String personaJson = "[{\"idProcesar\":2715,\"afore\":{\"activo\":1,\"claveAfore\":\"578\",\"descripcionAfore\":\"PENSIONISSSTE\",\"id\":378704580729,\"fechaControl\":1646954807000,\"usuarioModificador\":\"CULMINACION\",\"telefonoAfore\":\"018004001000\",\"tipoAdministracion\":\"A\"},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"apellidoMaterno\":\"LEON                                    \",\"apellidoPaterno\":\"MENDEZ                                  \",\"nombre\":\"NINEL                                   \",\"tipoAfiliacion\":\"4\",\"fechaAutTraspaso\":1378184400000,\"fechaInicioAfore\":1409720400000,\"nss\":\"           \",\"curp\":\"MELN780703MDFNNN06\",\"fechaNacimiento\":-19245600000,\"sexo\":{\"claveGenero\":\"F\",\"descripcionGenero\":\"FEMENINO\"},\"documentoProbatorio\":\"DOC_PROB_X\",\"folioDocProbatorio\":\"0000002675\",\"curpRaiz\":\"MELN780703MDFNNN\",\"claveGiro\":\"02\",\"gradoEstudios\":\"04\",\"ocupacion\":\"72\",\"tipoAdmin\":\"01\",\"tipoRegimen\":\"RO\",\"fechaInicioCotizacion\":1388556000000,\"periodoPagoReingreso\":1388556000000,\"fechaPrimeraAfiliacion\":1388556000000,\"vencimientoBonoRendi\":1388556000000,\"entidadNacimiento\":{\"id\":10,\"chCvEntidadFederativa\":\"09\",\"descripcion\":\"CIUDAD DE MEXICO\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"DF\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":9},\"nacionalidad\":1,\"perfilSeguridad\":1,\"idTipoDoctoProbatorio\":5,\"telefonoList\":[{\"idTelefono\":1912900272,\"tipoTelefono\":{\"idTipoTelefono\":1,\"claveTipoTelefono\":\"01\",\"descTipoTelefono\":\"PERSONAL\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900273,\"tipoTelefono\":{\"idTipoTelefono\":2,\"claveTipoTelefono\":\"02\",\"descTipoTelefono\":\"CASA\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"},{\"idTelefono\":1912900271,\"tipoTelefono\":{\"idTipoTelefono\":3,\"claveTipoTelefono\":\"03\",\"descTipoTelefono\":\"TRABAJO\",\"fechaControl\":1401339600000,\"usuarioModificador\":\"MIGRACION\"},\"idProcesar\":2715,\"numeroTelefono\":\"999999999999\",\"estatus\":1,\"usuarioModificador\":\"PRUEBA CASA\",\"fechaControl\":1583820000000,\"extensionTelefonica\":\"2222\"}],\"referenciaList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"DUMM110199HDFABC01\"},\"parentesco\":{\"id\":19,\"descripcion\":\"CONOCIDO\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"19\",\"fechaControl\":1410325200000},\"participante\":{\"idProcesar\":2715,\"chCorreoElectronico\":\"correo_prueba2675@pato.com\",\"chUsuarioModificador\":\"Yop =)\",\"fcControl\":1412658000000,\"nuActivo\":1,\"rfc\":\"MELN780703   \"},\"nombre\":\"FULANO\",\"telefono\":\"5555555555\",\"apellidoPaterno\":\"DE\",\"apellidoMaterno\":\"TAL\",\"fechaModificacion\":1478570786000,\"usuarioModificador\":\"LIBERA_TRASP_A_A\"}],\"beneficiarioList\":[{\"id\":{\"idProcesar\":2715,\"curp\":\"XXXX680716HDFVLR00\"},\"apellidoMaterno\":\"NAA\",\"apellidoPaterno\":\"DAVILA\",\"nombre\":\"MAURICIO JAVIER\",\"usuarioModificador\":\"UADCTD1\",\"fechaControl\":1469768400000,\"porcentaje\":100,\"parentesco\":{\"id\":1,\"descripcion\":\"ESPOSO(A)\",\"usuarioModificador\":\"MIGRACION\",\"claveParentesco\":\"01\",\"fechaControl\":1410325200000}}],\"domicilioList\":[{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":1},\"calle\":\"CDA PRUEBA1\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA1\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":4},\"calle\":\"CDA PRUEBA3\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA3\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}},{\"id\":{\"idProcesar\":2715,\"idTipoDomicilio\":2},\"calle\":\"CDA PRUEBA2\",\"ciudad\":\"ESTADO DE MEXICO\",\"codigoPostal\":\"56377\",\"colonia\":\"PRUEBA2\",\"numeroExterior\":\"50\",\"numeroInterior\":\"S\",\"usuarioModificador\":\"BATCH\",\"fechaActualizaTrabajador\":1583215200000,\"fechaControl\":1583215200000,\"nsarMunicipio\":{\"id\":2362,\"descripcion\":\"TECOLUTLA\",\"usuarioModificador\":\"MIGRACION\",\"claveMunicipio\":\"30158\",\"fechaControl\":1401339600000,\"entidadFederativa\":{\"id\":31,\"chCvEntidadFederativa\":\"30\",\"descripcion\":\"VERACRUZ\",\"usuarioModificador\":\"ARGICION\",\"claveCorta\":\"VZ\",\"fechaControl\":1401339600000,\"pais\":{\"id\":139,\"descripcion\":\"MEXICO\",\"usuarioModificador\":\"ARGICION\",\"clavePais\":\"MEX\",\"fechaControl\":1401339600000},\"nuCvEntidadFederativa\":30}}}]}]";
	private String paramNssV2 = "nss/";
	private String paramCurpV2 = "/curp/";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		if (wm == null) {
			wm = new WireMockServer(options().port(9999));
		}
		wm.start();

		// monioreo de capa de trasporte
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if (wm.isRunning()) {
			wm.stop();
			wm.shutdownServer();
		}
	}

	@Before
	public void setUpBefore() {
		cambioMock(preConsultaTrabajadorService, "uriComunes");
		cambioMock(preConsultaTrabajadorService, "uriPreConsultaNssCurp");
		cambioMock(preConsultaTrabajadorService, "uriPreConsultaCurp");

	}

	@After
	public void setUpAfter() {
		cambio(preConsultaTrabajadorService, "uriComunes");
		cambio(preConsultaTrabajadorService, "uriPreConsultaNssCurp");
		cambio(preConsultaTrabajadorService, "uriPreConsultaCurp");
	}

	/**
	 * Test para preconsulta de persona
	 */
	@Test
	public void getPersonaConsultaCAfore() {

		String rutaInicioNss = "/comunesPulssar/trabajador/nss/{nss}/curp/{curp}/afore/{afore}";
		String rutaInicioCurp = "/comunesPulssar/trabajador/curp/{curp}/afore/{afore}";
		String paramCurp = "{curp}";
		String paramNss = "{nss}";
		String paramAfore = "{afore}";

		// preconsulta completa
		String urlTodo = rutaInicioNss;
		urlTodo = replace(urlTodo, paramNss, nss);
		urlTodo = replace(urlTodo, paramCurp, curp);
		urlTodo = replace(urlTodo, paramAfore, afore);

		super.crearStub(wm, urlTodo, 200, personaJson, RequestMethod.GET);
		listaPersona = preConsultaTrabajadorService.getPersonaConsulta(nss, curp, afore);

		assertFalse(listaPersona.isEmpty());

		// preconsulta sin curp
		String urlSCurp = rutaInicioNss;
		urlSCurp = replace(urlSCurp, paramNss, nss);
		urlSCurp = replace(urlSCurp, "/curp/{curp}", "");
		urlSCurp = replace(urlSCurp, paramAfore, afore);

		super.crearStub(wm, urlSCurp, 200, personaJson, RequestMethod.GET);
		listaPersona = preConsultaTrabajadorService.getPersonaConsulta(nss, vacio, afore);

		assertFalse(listaPersona.isEmpty());

		// preconsulta sin nss
		rutaInicioCurp = replace(rutaInicioCurp, paramCurp, curp);
		rutaInicioCurp = replace(rutaInicioCurp, paramAfore, afore);
		super.crearStub(wm, rutaInicioCurp, 200, personaJson, RequestMethod.GET);
		listaPersona = preConsultaTrabajadorService.getPersonaConsulta(vacio, curp, afore);

		assertFalse(listaPersona.isEmpty());

		// preconsulta persona vacia
		super.crearStub(wm, urlTodo, 200, "", RequestMethod.GET);
		listaPersona = preConsultaTrabajadorService.getPersonaConsulta(nss, curp, afore);

		assertTrue(listaPersona.isEmpty());

	}

	/**
	 * Test para preconsulta de persona
	 */
	@Test
	public void getPersonaConsultaSAfore() {
		StringBuilder ruta;
		String rutaInicio = "/comunesPulssar/trabajador/V2/";
		// preconsulta por curp
		ruta = new StringBuilder();
		ruta.append(rutaInicio);
		ruta.append("curp/" + curp);
		super.crearStub(wm, ruta.toString(), 200, personaJson, RequestMethod.GET);
		listaPersona = preConsultaTrabajadorService.getPersonaConsulta(vacio, curp);

		assertFalse(listaPersona.isEmpty());

		// preconsulta por nss
		ruta = new StringBuilder();
		ruta.append(rutaInicio);
		ruta.append(paramNssV2 + nss);
		super.crearStub(wm, ruta.toString(), 200, personaJson, RequestMethod.GET);
		listaPersona = preConsultaTrabajadorService.getPersonaConsulta(nss, vacio);

		assertFalse(listaPersona.isEmpty());

		// preconsulta por nss y curp
		ruta = new StringBuilder();
		ruta.append(rutaInicio);
		ruta.append(paramNssV2 + nss + paramCurpV2 + curp);
		super.crearStub(wm, ruta.toString(), 200, personaJson, RequestMethod.GET);
		listaPersona = preConsultaTrabajadorService.getPersonaConsulta(nss, curp);

		assertFalse(listaPersona.isEmpty());

		// preconsulta persona vacia
		ruta = new StringBuilder();
		ruta.append(rutaInicio);
		ruta.append(paramNssV2 + nss + paramCurpV2 + curp);

		super.crearStub(wm, ruta.toString(), 200, "", RequestMethod.GET);
		listaPersona = preConsultaTrabajadorService.getPersonaConsulta(nss, curp);

		assertTrue(listaPersona.isEmpty());

	}
}