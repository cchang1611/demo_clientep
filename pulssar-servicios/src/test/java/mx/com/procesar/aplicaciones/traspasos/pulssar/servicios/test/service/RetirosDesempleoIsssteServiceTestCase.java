package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarExpedienteServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.RetirosDesempleoIsssteServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BaseRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.IretMatrizDerecho;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Resolucion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.ValidadorUtilsImpl;

public class RetirosDesempleoIsssteServiceTestCase {

	@InjectMocks
	private RetirosDesempleoIsssteServiceImpl service = new RetirosDesempleoIsssteServiceImpl();

	@Mock
	private RestTemplate restService;

	//@Mock
	//private JsonUtils jsonUtils;
	@Mock
	ValidarExpedienteServicio validarExpedienteService;

	@Mock
	private NotificacionService notificacionService;

	/**
	 * Inicializa los elementos para la prueba.
	 */
	@Before
	public void setUp() {
		ReflectionTestUtils.setField(service, "utileriaValidador", new ValidadorUtilsImpl());
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testObtenerResarcimiento() {
		// ReflectionTestUtils.setField(service, "uriConsultaRetiroDesempleoIssste",
		// "http://lbint-devl.procesar.net/comunesPulssar/retirosParcialesIssste/retirosParciales/");
		BaseRespuesta<Resolucion> body = new BaseRespuesta<>();
		ResponseEntity<BaseRespuesta<Resolucion>> value = new ResponseEntity<BaseRespuesta<Resolucion>>(body,
				HttpStatus.OK);

		Mockito.when(restService.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class),
				Mockito.nullable(HttpEntity.class),
				Mockito.eq(new ParameterizedTypeReference<BaseRespuesta<Resolucion>>() {
				}))).thenReturn(value);

		service.consultarRetiroDesempleoIssste(0l);
	}

//	@Test
//	public void solicitarDisposicionParcialIssste() {
//
//		DatosTrabajador datos = Mockito.mock(DatosTrabajador.class);
//		UsuarioLogin user = Mockito.mock(UsuarioLogin.class);
//		RetiroDesempleoIssste retiroDesempleoIssste = Mockito.mock(RetiroDesempleoIssste.class);
//		DatosCertificables datosCertificables = Mockito.mock(DatosCertificables.class);
//		Mockito.when(datos.getDatosCertificables()).thenReturn(datosCertificables);
//		Mockito.when(datosCertificables.getCurp()).thenReturn("asd");
//		Mockito.when(user.getAforeUsuario()).thenReturn("");
//
//		Mockito.when(validarExpedienteService.validarExpedienteServicio(Mockito.anyString(), Mockito.any(DatosTrabajador.class),
//				Mockito.any(UsuarioLogin.class), Mockito.any(SolicitudDisposicionParcial.class),Mockito.anyBoolean())).thenReturn(null);
//
//		service.solicitarDisposicionParcialIssste(datos, user, retiroDesempleoIssste, "");
//	}

//	@Test
//	public void solicitarDisposicionParcialIsssteStatusVacio() {
//		ReflectionTestUtils.setField(service, "urisolicitudRetiroDesempleoIssste",
//				"http://lbint-devl.procesar.net/comunesPulssar/retirosParcialesIssste/retirosParciales/");
//		ResponseEntity<SolicitudDisposicionParcialSalida> value = new ResponseEntity<>(
//				new SolicitudDisposicionParcialSalida(), HttpStatus.OK);
//
//		Mockito.when(restService.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(HttpMethod.class),
//				ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(SolicitudDisposicionParcialSalida.class)))
//				.thenReturn(value);
//
//		DatosTrabajador datos = Mockito.mock(DatosTrabajador.class);
//		UsuarioLogin user = Mockito.mock(UsuarioLogin.class);
//		RetiroDesempleoIssste retiroDesempleoIssste = Mockito.mock(RetiroDesempleoIssste.class);
//		DatosCertificables datosCertificables = Mockito.mock(DatosCertificables.class);
//
//		Mockito.when(datos.getDatosCertificables()).thenReturn(datosCertificables);
//		Mockito.when(datos.getFolio()).thenReturn(new FolioEntrada());
//		Mockito.when(datosCertificables.getCurp()).thenReturn("asd");
//		Mockito.when(user.getAforeUsuario()).thenReturn("");
//		Mockito.when(retiroDesempleoIssste.getResolucion()).thenReturn(new Resolucion());
//		Mockito.when(validarExpedienteService.validarExpedienteServicio(Mockito.anyString(), Mockito.any(DatosTrabajador.class),
//				Mockito.any(UsuarioLogin.class), Mockito.any(SolicitudDisposicionParcial.class),Mockito.anyBoolean())).thenReturn(null);
//
//		service.solicitarDisposicionParcialIssste(datos, user, retiroDesempleoIssste, "");
//	}

	@Test
	public void consultarTipoRetiro() {

		ReflectionTestUtils.setField(service, "uriConsultaTipoRetiro",
				"http://lbint-devl.procesar.net/comunesPulssar/retirosParcialesIssste/retirosParciales/");

		SalidaGenerica body = new SalidaGenerica();
		body.setCodigoOperacion("01");
		ResponseEntity<SalidaGenerica> value = new ResponseEntity<>(body, HttpStatus.OK);

		Mockito.when(restService.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(HttpMethod.class),
				ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(SalidaGenerica.class))).thenReturn(value);

		Resolucion res = Mockito.mock(Resolucion.class);
		DatosSaldos datos = Mockito.mock(DatosSaldos.class);

		Mockito.when(res.getIretMatrizDerecho()).thenReturn(new IretMatrizDerecho());

		service.consultarTipoRetiro(res, datos);
	}

	@Test
	public void guardarTipoRetiroIssste() {
		ReflectionTestUtils.setField(service, "uriguardaTipoRetiroIssste",
				"http://lbint-devl.procesar.net/comunesPulssar/retirosParcialesIssste/retirosParciales/");

		String body = new String();
		ResponseEntity<String> value = new ResponseEntity<>(body, HttpStatus.OK);

		Mockito.when(restService.exchange(ArgumentMatchers.anyString(), ArgumentMatchers.any(HttpMethod.class),
				ArgumentMatchers.any(HttpEntity.class), ArgumentMatchers.eq(String.class))).thenReturn(value);

		Resolucion resolucion = Mockito.mock(Resolucion.class);
		RetiroDesempleoIssste retiroDesempleoIssste = Mockito.mock(RetiroDesempleoIssste.class);
		DatosSaldos datosSaldos = Mockito.mock(DatosSaldos.class);

		service.guardarTipoRetiroIssste(resolucion, retiroDesempleoIssste, datosSaldos);
	}

}
