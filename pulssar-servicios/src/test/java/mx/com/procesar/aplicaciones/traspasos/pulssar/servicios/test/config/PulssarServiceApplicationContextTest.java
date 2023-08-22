/**
 * ServiceApplicationContext.java
 * Fecha de creaciï¿½n: 07/03/2016, 11:49:56
 *
 * Copyright (c) 2016 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaciï¿½n confidencial, propiedad del
 * Procesar S A de C V. Esta informaciï¿½n confidencial
 * no deberï¿½ ser divulgada y solo se podrï¿½ utilizar de acuerdo
 * a los tï¿½rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.IretTcDiagnostico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargado;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RecaTrFactura;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ResolucionParcial;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ResolucionReti;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RetiroParcialCalculoImss;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.RetiroParcialCalculoImssList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Afore;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AforeAgente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.AgentePromotor;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CURPStruct;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoReintegroSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoIret;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CitaNotificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConfirmacionMontoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaCusSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultaHistoricoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ConsultarKardexSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CurpDuplicada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosAgente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntidadFederativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EstatusExpediente;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Icefa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ListaIcefasDisponiblesSaldo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Nacionalidad;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NotificarParcialidadPagoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NsarBeneficiario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NsarBeneficiarioPK;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NsarDomicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NsarDomicilioPK;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.NsarMunicipio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Pais;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametroList;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosSalidaMarca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parentesco;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Participante;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.PersonaSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecaudadoraTV;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReferenciaTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReferenciaTrabajadorPK;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaEstatusServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaNotificacionCita;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicioRetiroParcialCalculo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaValidarDigitoVerificador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SalidaGenerica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sexo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudDisposicionParcialRespuesta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Subcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TelefonoTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TipoTelefono;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Usuario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidarSolicitudCertificacionAforeSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;


/**
 * Clase de Contexto de Spring para Servicios
 * @author Rodolfo Damiï¿½n Rojas Rodrï¿½guez (rdrojas@inet.procesar.com.mx)
 * @version 1.0
 * @since 
 */
@Configuration
@ComponentScan(includeFilters = {@Filter(type = FilterType.ANNOTATION, value = Service.class),
		@Filter(type = FilterType.ANNOTATION, value = Component.class) }, 
	basePackages = {"mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl",
			"mx.com.procesar.aplicaciones.traspasos.pulssar.turnos.servicios.impl",
			"mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl"})
@EnableTransactionManagement
public class PulssarServiceApplicationContextTest{

	/**
	 * Bloque estï¿½tico para definir las propiedades del sistema
	 */
	static {
		System.setProperty("mx.com.procesar.configuracion.properties", "src/test/resources");
		System.setProperty("log4j.configuratioFile", "file:/src/test/resources/log4j2/log4j2.properties");
	}
	
	/**
	 * Contador para consulta de afores
	 */
	private int contador = 0;
	
	/**
	 * Crea en retsTemplate
	 * 
	 * @author dbarbosa
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate() {
			@SuppressWarnings({ "unchecked", "null", "static-access" })
			@Override
			public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity,
					Class<T> responseType, Object... uriVariables) throws RestClientException {
				T t = null;
				if(method == HttpMethod.GET) { 					
					if(url.contains("usuarios/v1/usuarios/")){
						Map<String, Object> atributo = new LinkedHashMap<>();
						atributo.put("mail", "juan_071996@hotmail.com");
						atributo.put("mobile", "2431241008");
						Usuario usuario = new Usuario();
						usuario.setUsername("1602075135");
						usuario.setNombre("Miguel");
						usuario.setApellidoPaterno("Hernandez");
						usuario.setApellidoMaterno("Rodriguez");
						usuario.setActivo(false);
						usuario.setPrimeraVez("true");
						usuario.setAtributos(atributo);
						
//						ResponseEntity<String> respuesta = new ResponseEntity<String>(HttpStatus.OK);
//						URI uri = URI.create(url);
//						t = (T) respuesta.created(uri).header("respuesta", "respuesta").body(usuario);
						
						ResponseEntity<Usuario> respuesta = new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
						t = (T) respuesta;
						
					}
					if(url.contains("usuarios/v1/usuarios/david19@gmail.com/")){
						Map<String, Object> atributo = new LinkedHashMap<>();
						atributo.put("mail", "david19@gmail.com");
						atributo.put("mobile", "5578987898");
						Usuario usuario = new Usuario();
						usuario.setUsername("david19@gmail.com");
						usuario.setNombre("David");
						usuario.setApellidoPaterno("Prueba");
						usuario.setApellidoMaterno("Prueba");
						usuario.setActivo(false);
						usuario.setAtributos(atributo);
						
//						ResponseEntity<String> respuesta = new ResponseEntity<String>(HttpStatus.OK);
//						URI uri = URI.create(url);
//						t = (T) respuesta.created(uri).header("respuesta", "respuesta").body(usuario);
						
						ResponseEntity<Usuario> respuesta = new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
						t = (T) respuesta;
					}
					if(url.contains("usuarios/v1/usuarios/david1919@gmail.com/")){
						t = null;
					}
					if(url.contains("87587689878")){
//						ResponseEntity<String> respuesta = new ResponseEntity<String>(HttpStatus.OK);
//						URI uri = URI.create(url);
//						t = (T) respuesta.created(uri).header("respuesta", "respuesta").body("");						
						
						String dato = "";
						ResponseEntity<String> respuesta = new ResponseEntity<String>(dato,HttpStatus.OK);
						t = (T) respuesta;						
					}
					if(url.contains("/roles")){				
//						ResponseEntity<String> respuesta = new ResponseEntity<String>(HttpStatus.OK);
//						t = (T) respuesta;
						
						String dato = "";
						ResponseEntity<String> respuesta = new ResponseEntity<String>(dato,HttpStatus.OK);
						t = (T) respuesta;	
					}
					if(url.contains("nuevoPulssar")){
//						ResponseEntity<String> respuesta = new ResponseEntity<String>(HttpStatus.OK);
//						URI uri = URI.create(url);
//						t = (T) respuesta.created(uri).header("respuesta", "respuesta").body("ADMINISTRADORES");
						
						String dato = "ADMINISTRADORES";
						ResponseEntity<String> respuesta = new ResponseEntity<String>(dato,HttpStatus.OK);
						t = (T) respuesta;	
					}
					if(url.contains("userName")){
						t = null;
					}
					if(url.contains("3436543454")){
						t = null;
					}
				
				} 
				if(method == HttpMethod.POST) {
					if(url.contains("portalservicios/v1/folio")){
						if(requestEntity.getBody().toString().contains("ROSA831608MDFMMM06")){
							HttpHeaders header = new HttpHeaders();
							String datos = "{\"idUsuario\":\"15\",\"sucursal\":\" \",\"folio\":\"C0000015201905280008\",\"operacion\":\"C\",\"curp\":null,\"nss\":\"ROSA831608MDFMMM06\",\"descripcion\":\"\",\"servicio\":\"C\",\"proceso\":\"\",\"idFolio\":\"143\",\"estatus\":null,\"resultadoOperacion\":\"02\",\"motivoRechazo\":\"F001\",\"tiempoLlegada\":\"2019-05-28 19:36:56\",\"idFolioPadre\":null}";
							header.add("Content-Type", "application/json;charset=UTF-8");
							t = (T) new ResponseEntity<String>(datos,header,HttpStatus.OK);
						} else if(requestEntity.getBody().toString().contains("ROSA831608MDFMMM19")){
							HttpHeaders header = new HttpHeaders();
							String datos = "{\"idUsuario\":\"15\",\"sucursal\":\" \",\"folio\":\"C0000015201905280007\",\"operacion\":\"C\",\"curp\":\"ROSA831608MDFMMM19\",\"nss\":\"12345678958\",\"descripcion\":\"\",\"servicio\":\"C\",\"proceso\":\"\",\"idFolio\":\"143\",\"estatus\":null,\"resultadoOperacion\":\"02\",\"motivoRechazo\":\"null\",\"tiempoLlegada\":\"2019-05-28 19:36:56\",\"idFolioPadre\":null}";
							header.add("Content-Type", "application/json;charset=UTF-8");
							t = (T) new ResponseEntity<String>(datos,header,HttpStatus.OK);
						}else if(requestEntity.getBody().toString().contains("12344455567")){
							HttpHeaders header = new HttpHeaders();
							String datos = "{\"idUsuario\":\"15\",\"sucursal\":\" \",\"folio\":\"C0000015201905280007\",\"operacion\":\"C\",\"curp\":\"ROSA831608MDFMMM19\",\"nss\":\"12344455567\",\"descripcion\":\"\",\"servicio\":\"C\",\"proceso\":\"\",\"idFolio\":\"143\",\"estatus\":null,\"resultadoOperacion\":\"02\",\"motivoRechazo\":\"null\",\"tiempoLlegada\":\"2019-05-28 19:36:56\",\"idFolioPadre\":null}";
							header.add("Content-Type", "application/json;charset=UTF-8");
							t = (T) new ResponseEntity<String>(datos,header,HttpStatus.OK);
						} else{
							HttpHeaders header = new HttpHeaders();
							String datos = "{\"idUsuario\":\"15\",\"sucursal\":\" \",\"folio\":\"C0000015201905280007\",\"operacion\":\"C\",\"curp\":null,\"nss\":\"12345678958\",\"descripcion\":\"\",\"servicio\":\"C\",\"proceso\":\"\",\"idFolio\":\"143\",\"estatus\":null,\"resultadoOperacion\":\"01\",\"motivoRechazo\":\"null\",\"tiempoLlegada\":\"2019-05-28 19:36:56\",\"idFolioPadre\":null}";
							header.add("Content-Type", "application/json;charset=UTF-8");
							t = (T) new ResponseEntity<String>(datos,header,HttpStatus.OK);
						}
					}
					
					
					if(requestEntity.getBody().toString().contains("PUBA831608MDFMMM06")){
						HttpHeaders header = new HttpHeaders();
						String datos = "{\"idUsuario\":\"15\",\"sucursal\":\" \",\"folio\":\"C0000015201905280008\",\"operacion\":\"C\",\"curp\":\"PUBA831608MDFMMM06\",\"nss\":\"11111222223\",\"descripcion\":\"\",\"servicio\":\"C\",\"proceso\":\"\",\"idFolio\":\"143\",\"estatus\":null,\"resultadoOperacion\":\"02\",\"motivoRechazo\":\"F001\",\"tiempoLlegada\":\"2019-05-28 19:36:56\",\"idFolioPadre\":null}";
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<String>(datos,header,HttpStatus.OK);
					}else if(requestEntity.getBody().toString().contains("1000000000000001")){
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						Date fechaInicio = null;
						try {
							fechaInicio = simpleDateFormat.parse("28/11/2019 09:00:00");
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						CitaNotificacion citaNotificacion = new CitaNotificacion();
						citaNotificacion.setCodigoCita("00001");
						citaNotificacion.setCurp("BACG620329MPLRRD00");
						citaNotificacion.setFechaInicio(fechaInicio);
						List<CitaNotificacion> listaRespuesta = Lists.newArrayList(citaNotificacion);
						
						RespuestaNotificacionCita notificacionCita = new RespuestaNotificacionCita();
						notificacionCita.setListaRespuesta(listaRespuesta);
						
						ResponseEntity<RespuestaNotificacionCita> respuesta = new ResponseEntity<RespuestaNotificacionCita>(notificacionCita,HttpStatus.OK);
						t = (T) respuesta;
						
					}

					if(url.contains("/solicitudcus/consulta")){
						ConsultaCusSalida sldCus = new ConsultaCusSalida();
						if(requestEntity.getBody().toString().contains("BACG620329MPLRRD01")){
							sldCus.setCodigo("01");
							ResponseEntity<ConsultaCusSalida> respuesta = new ResponseEntity<>(sldCus,HttpStatus.OK);
							t = (T) respuesta;
							
						}else if(requestEntity.getBody().toString().contains("BACG620329MPLRR000")){
							ResponseEntity<ConsultaCusSalida> respuesta = new ResponseEntity<>(sldCus,HttpStatus.OK);
							t = (T) respuesta;
							
						}
					}
									
					
					if(url.contains("/folio/")){
						HttpHeaders header = new HttpHeaders();
						String datos = "{\"idUsuario\":\"null\",\"sucursal\":\"null\",\"folio\":\"null\",\"operacion\":\"null\",\"curp\":null,\"nss\":\"null\",\"descripcion\":\"null\",\"servicio\":\"null\",\"proceso\":\"null\",\"idFolio\":\"null\",\"estatus\":null,\"resultadoOperacion\":\"01\",\"motivoRechazo\":\"Folio cerrado correctamente\",\"tiempoLlegada\":\"null\",\"idFolioPadre\":null}";
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<String>(datos,header,HttpStatus.OK);
					}
					if(requestEntity.getBody().toString().contains("453")){
						t= null;
					}
					if(url.contains("/mensaje/envio")){
						String datos = "\"respuesta\":{\"codigo\":\"200\",\"id\":\"279_190530_171154_5IQU\",\"mensaje\":\"SMS ENVIADO\"";
						t = (T) new ResponseEntity<>(datos,HttpStatus.OK);
					}
					if(url.contains("validarSolicitudCertificacionAfore")){
						ValidarSolicitudCertificacionAforeSalida salida = new ValidarSolicitudCertificacionAforeSalida();
						salida.setApellidoMaterno("hgui");
						salida.setApellidoPaterno("guygyug");
						ResponseEntity<ValidarSolicitudCertificacionAforeSalida> respuesta = new ResponseEntity<ValidarSolicitudCertificacionAforeSalida>(salida,HttpStatus.OK);
						t = (T) respuesta;
					}
					if(url.contains("/retiros/v1/certificados")){
						SolicitudDisposicionParcialRespuesta salida = new SolicitudDisposicionParcialRespuesta();
						salida.setNumeroResolucion("numero");
//						salida.setDescripcionEstatus("descripcion");
//						salida.setDiagnostico("diagnostico");
						ResponseEntity<SolicitudDisposicionParcialRespuesta> respuesta = new ResponseEntity<SolicitudDisposicionParcialRespuesta>(salida,HttpStatus.OK); 
						t = (T) respuesta;
					}
					if(url.contains("/tiporetiro/a/")){
						CalculoTipoRetiro salida = new CalculoTipoRetiro();
						salida.setCalculoA("CalculoA");
						salida.setCalculoB("CalculoB");
						ResponseEntity<CalculoTipoRetiro> respuesta = new ResponseEntity<CalculoTipoRetiro>(salida,HttpStatus.OK);
						t = (T) respuesta;
					}
					if(url.contains("/comunesPulssar/saldosPreliminares")){
						DatosSaldos datos = new DatosSaldos();
						datos.setMotivoRechazo("G001");
						ResponseEntity<DatosSaldos> respuesta = new ResponseEntity<DatosSaldos>(datos,HttpStatus.OK);
						t = (T) respuesta;
					}
					
					if(requestEntity.getBody().toString().contains("CU")){
						DatosSaldos datos = new DatosSaldos();
						ResponseEntity<DatosSaldos> respuesta = new ResponseEntity<DatosSaldos>(datos,HttpStatus.OK);
						t = (T) respuesta;
					}
					
					if(url.contains("/v1/archivos")){
						String dato = "dato";
						ResponseEntity<String> respuesta = new ResponseEntity<String>(dato,HttpStatus.OK);
						t = (T) respuesta;
					}
					
					if(requestEntity.toString().contains("claveExeption")){
						throw new RuntimeException("error archivos");
					}
					
					if(url.contains("foliocomplementario/guardarDatos")){
						ResponseEntity<String> respuesta = new ResponseEntity<String>(HttpStatus.OK);
						t = (T) respuesta;
					}
					
					if(requestEntity.getBody().toString().contains("Exception")){
						throw new RuntimeException("error folio complementario");
					}
					
					
					if(url.contains("/retiro/pagos/notificacionPagos")){
						if(requestEntity.getBody().toString().contains("02")){
						HttpHeaders header = new HttpHeaders();
						NotificarParcialidadPagoSalida salida = new NotificarParcialidadPagoSalida();
						salida.setMotivoRechazo("Eror de Notificiacion ");
						salida.setResultadoOperacion("02");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<NotificarParcialidadPagoSalida>(salida,header,HttpStatus.OK);
					}else{ 
						HttpHeaders header = new HttpHeaders();
						NotificarParcialidadPagoSalida salida = new NotificarParcialidadPagoSalida();
						salida.setMotivoRechazo("Notificacion Correcto");
						salida.setResultadoOperacion("01");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<NotificarParcialidadPagoSalida>(salida,header,HttpStatus.OK);
					}
				  }
					
					if(url.contains("/parcialidad/actualizar/")){
						if(requestEntity.getBody().toString().contains("02")){
						HttpHeaders header = new HttpHeaders();
						RespuestaEstatusServicio salida = new RespuestaEstatusServicio();
						salida.setCodigo(400);
						salida.setMensaje("Ocurrio un Error al Actualizar Parcialidades");
						salida.setResultado("02");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<RespuestaEstatusServicio>(salida,header,HttpStatus.OK);
					} else { 
						HttpHeaders header = new HttpHeaders();
						RespuestaEstatusServicio salida = new RespuestaEstatusServicio();
						salida.setCodigo(400);
						salida.setMensaje("Ocurrio un Error al Actualizar Parcialidades");
						salida.setResultado("02");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<RespuestaEstatusServicio>(salida,header,HttpStatus.OK);
					}
				  }
					if(url.contains("/v1/786/reintegrosemanasimss/historico")){
						if(requestEntity.getBody().toString().contains("35048615740")){
						HttpHeaders header = new HttpHeaders();
						ConsultaHistoricoSalida salida = new ConsultaHistoricoSalida();
						salida.setNss("35048615740");
						salida.setClaveAfore("538");
						salida.setTipoPrestacion("06");
						salida.setImportePesosReintegrar(new BigDecimal(5456));
						salida.setNumeroResolucion("33");
						salida.setNombre("AMARO$ZALDIVAR$MARTIN");
						salida.setDiasDescontados(1176);
						salida.setValorDiaReintegrar(new BigDecimal(12.71));
						salida.setNumeroMaximoSemanas(0);
						salida.setDiagnostico("000");
						salida.setOrigen(3);
						
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<ConsultaHistoricoSalida>(salida,header,HttpStatus.OK);
					} else { 
						HttpHeaders header = new HttpHeaders();
						RespuestaEstatusServicio salida = new RespuestaEstatusServicio();
						salida.setCodigo(400);
						salida.setMensaje("Ocurrio al realizar la consulta historica");
						salida.setResultado("02");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<RespuestaEstatusServicio>(salida,header,HttpStatus.OK);
					}
				  }
				    
				
					if(url.contains("/v1/786/reintegrosemanasimss/calculo")){
						if(requestEntity.getBody().toString().contains("35048615740")){
						HttpHeaders header = new HttpHeaders();
						CalculoReintegroSalida salida = new CalculoReintegroSalida();
						salida.setClaveAfore("35048615740");
						salida.setTipoPrestacion("06");
						salida.setImportePesosReintegrar(new BigDecimal(5456));
						salida.setNumeroResolucion("561383");
						salida.setNombre("AMARO$ZALDIVAR$MARTIN");
						salida.setDiasDescontados(1176);
						salida.setValorDiaReintegrar(new BigDecimal(12.71));
						salida.setNumeroMaximoSemanas(0);
						salida.setDiagnostico("000");
						salida.setOrigen(3);
						
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<CalculoReintegroSalida>(salida,header,HttpStatus.OK);
					} else { 
						HttpHeaders header = new HttpHeaders();
						RespuestaEstatusServicio salida = new RespuestaEstatusServicio();
						salida.setCodigo(400);
						salida.setMensaje("Ocurrio al realizar el Calculo");
						salida.setResultado("02");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<RespuestaEstatusServicio>(salida,header,HttpStatus.OK);
					}
				  }
					
					if(url.contains("/v1/786/reintegrosemanasimss/confirmacion")){
						if(requestEntity.getBody().toString().contains("35048615740")){
						HttpHeaders header = new HttpHeaders();
						ConfirmacionMontoSalida salida = new ConfirmacionMontoSalida();
						salida.setClaveAfore("35048615740");
						salida.setTipoPrestacion("06");
						salida.setImportePesosReintegrar(new BigDecimal(5456));
						salida.setNumeroResolucion("561383");
						salida.setNombre("AMARO$ZALDIVAR$MARTIN");
						salida.setDiasDescontados(1176);
						salida.setValorDiaReintegrar(new BigDecimal(12.71));
						salida.setNumeroMaximoSemanas(0);
						salida.setDiagnostico("000");
						salida.setOrigen(3);
						
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<ConfirmacionMontoSalida>(salida,header,HttpStatus.OK);
					} else { 
						HttpHeaders header = new HttpHeaders();
						RespuestaEstatusServicio salida = new RespuestaEstatusServicio();
						salida.setCodigo(400);
						salida.setMensaje("Ocurrio al realizar la confirmacion");
						salida.setResultado("02");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<RespuestaEstatusServicio>(salida,header,HttpStatus.OK);
					}
				  }
					
					if(url.contains("retiroParcial/imss/")){
						if(requestEntity.getBody().toString().contains("20800")){
						HttpHeaders header = new HttpHeaders();
						RespuestaServicioRetiroParcialCalculo salida =new RespuestaServicioRetiroParcialCalculo();
						salida.setCodigo(200);
						salida.setMensaje("Se guardo correctamente Retiro Parcial");
						salida.setResultado("01");
						
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<RespuestaServicioRetiroParcialCalculo>(salida,header,HttpStatus.OK);
					} else { 
						HttpHeaders header = new HttpHeaders();
						RespuestaEstatusServicio salida = new RespuestaEstatusServicio();
						salida.setCodigo(400);
						salida.setMensaje("Error al guardar el cálculo de retiro parcial");
						salida.setResultado("02");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<RespuestaEstatusServicio>(salida,header,HttpStatus.BAD_REQUEST);
					}
				  }
				}
				
				if(method == HttpMethod.PUT){
					if(url.contains("usuarios/v1/usuarios")){
						ResponseEntity<String> respuesta = new ResponseEntity<String>(HttpStatus.NO_CONTENT);
						t = (T) respuesta;
					}
					if(url.contains("password=nuevo123")){
						ResponseEntity<String> respuesta = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//						respuesta.badRequest();
						t = (T) respuesta;
					}
					if(url.contains("usuarios/v1/usuarios/1000123456/password?password=")){
						if(url.contains("guguyygiu&passwordNuevo=guguyygiu")){
							throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Error controlado", "Contraseña no coincide".getBytes(), Charset.defaultCharset());
						} else if(url.contains("guguyygi&passwordNuevo=guguyygiu")) {
							throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Error controlado");
						}
					}
					if(url.contains("recuperar@gmail.com")){
						throw new RuntimeException("Recuperar Contrasenia");
					}
					if(url.contains("/retiro/pagos/notificacionPagos")){
						if(requestEntity.getBody().toString().contains("02")){
						HttpHeaders header = new HttpHeaders();
						NotificarParcialidadPagoSalida salida = new NotificarParcialidadPagoSalida();
						salida.setMotivoRechazo("Eror de Notificiacion ");
						salida.setResultadoOperacion("02");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<NotificarParcialidadPagoSalida>(salida,header,HttpStatus.INTERNAL_SERVER_ERROR);
					}else{ 
						HttpHeaders header = new HttpHeaders();
						NotificarParcialidadPagoSalida salida = new NotificarParcialidadPagoSalida();
						salida.setMotivoRechazo("Notificacion Correcto");
						salida.setResultadoOperacion("01");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<NotificarParcialidadPagoSalida>(salida,header,HttpStatus.OK);
					}
				  }
					
					if(url.contains("notificacionTipoRetiro")){
						if(requestEntity.getBody().toString().contains("02")){
						HttpHeaders header = new HttpHeaders();
						RespuestaServicioRetiroParcialCalculo salida = new RespuestaServicioRetiroParcialCalculo();
						salida.setCodigo(2);
						salida.setMensaje("Eror de Notificiacion");
						salida.setResultado("02");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<RespuestaServicioRetiroParcialCalculo>(salida,header,HttpStatus.BAD_REQUEST);
					}else{ 
						HttpHeaders header = new HttpHeaders();
						NotificarParcialidadPagoSalida salida = new NotificarParcialidadPagoSalida();
						salida.setMotivoRechazo("Notificacion Correcto");
						salida.setResultadoOperacion("01");
						header.add("Content-Type", "application/json;charset=UTF-8");
						t = (T) new ResponseEntity<NotificarParcialidadPagoSalida>(salida,header,HttpStatus.OK);
					}
				  }

				}
				return (ResponseEntity<T>) t;
			}
			@Override
			public <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables)
					throws RestClientException {
				T t = null;
				if(request instanceof AforeAgente) {
					AforeAgente entrada = (AforeAgente) request;
					t = obtenerRespuestaCus(url, entrada);
				}
				if(request.toString().contains("34658674534")){
					t = obtesRespuestaAgente();
				}
				
				if(request.toString().contains("9536853476347")){
					throw new RuntimeException("Agente");
				}
				
				
				
				
				return t;
			}

			@SuppressWarnings("unchecked")
			@Override
			public <T> T getForObject(String url, Class<T> responseType, Object... urlVariables)
					throws RestClientException {
				T t = null;
				if(url.contains("trabajador/nss")){ 
					 t = obtenerRespuestaPersona(url); 
				}
				if(url.contains("entidadFederativa/claveCorta/")){
					t = obtenerEntidad(url);
				}
				if(url.contains("/catalogo/parametro/")){
					t = obtenerParametro(url);
				}
				if(url.contains("/catalogo/parametroPose/T00098")){
					t = obtenerParametro2(url);
				}
				
				if(url.contains("/catalogo/parametro/57894")){
					return (T)"";
				}
				if(url.contains("/catalogo/parametro/57895/S01")){
					throw new RuntimeException("Parametro");
				}
				if(url.contains("/catalogo/listaIcefa/")){
					t = obtenerIcefa(url);
				}
				if(url.contains("/catalogo/listaIcefa/65")){
					t = (T)"";
				}
				if(url.contains("/catalogo/listaIcefa/5")){
					throw new RuntimeException("Icefas");
				}
				if(url.contains("/catalogo/afores/")){
					if(contador == 0) {
						t = obtenerRespuestaConsultaAfore(url);
						contador++;
					}  else if(contador == 1) {
						t = (T) "";
						contador++;
					} else {
						contador = 0;
						throw new RuntimeException("Afore");
					}
				}
				if(url.contains("/catalogo/nacionalidad/1")){
					t = obtenerNacionalidad(url);
				}
				if(url.contains("/catalogo/nacionalidad/8")){
					throw new RuntimeException("Nacionalidad");
				}
				if(url.contains("trabajador/curp/BAI88")){
					throw new RuntimeException("Curp trabajador");
				}
				if(url.contains("trabajador/curp/BAID880119HDFRBV05")){
					List<PersonaSalida> respuesta = new ArrayList<>();
					JsonUtilsImpl<String> json = new JsonUtilsImpl<>();
					t = (T) json.parseListObjectToJson(respuesta);
				}
				if(url.contains("QUES762309MDFMMM06")){
					t = obtenerPersonaError2(url);
				}
				if(url.contains("trabajador/curp/BAID880119HDFRBV19")){
					t = obtenerRespuestaPersonaNacionalidad1(url);
				}
				if(url.contains("trabajador/curp/BAID880119HDFRBV04")){
					t = obtenerRespuestaPersonaNacionalidad(url);
				}
				if(url.contains("/comunesPulssar/expediente/")){
					t = obtenerExpediente(url);
				}
				if(url.contains("/validar/consultarMarcas")){
					t = obtenerMarcas(url);
				}
				if(url.contains("valida/curp/") || url.contains("valida/nss/")){
					t = obtenerDatosPersona(url);
				}
				if(url.contains("/renapo/curp/")){
					t = obtenerRenapo(url);
				}
				if(url.contains("/kardex/consulta/")){
					t = consultaKardex(url);
				}
				if(url.contains("/trabajador/curpDuplicada/")){
					t = consultaCurpDuplicada(url);
				}
				if(url.contains("/catalogo/estatus/")){
					t = consultarEstatus(url);
				}
				if(url.contains("recertificacion/idprocesar/123456")) {
					t = (T) "12/15/2019";
				}
				if(url.contains("recertificacion/idprocesar/12345678")) {
					throw new RuntimeException("Recertificacion");
				}
				if(url.contains("T02418")){
					t = obtenerParametroRoles(url);
				}
				
				if(url.contains("solicitantes/02,03,04")){
					t = (T) 	"{\"cvTipoSolicitante\":\"02\",\"chTipoSolicitante\":\"BENEFICIARIO\",\"fechaControl\":1498156642000,\"usuarioModificador\":\"GERENCIA MODELADO\"},{\"cvTipoSolicitante\":\"03\",\"chTipoSolicitante\":\"REPRESENTANTE LEGAL\",\"fechaControl\":1498156642000,\"usuarioModificador\":\"GERENCIA MODELADO\"},{\"cvTipoSolicitante\":\"04\",\"chTipoSolicitante\":\"CURADOR\",\"fechaControl\":1498156642000,\"usuarioModificador\":\"GERENCIA MODELADO\"}";
				}
				
				if(url.contains("solicitantes/")){
					t = (T) 	"{\"cvTipoSolicitante345\":\"02\",\"chTipoSolicitante\":\"BENEFICIARIO\",\"fechaControl\":1498156642000,\"usuarioModificador\":\"GERENCIA MODELADO\"},{\"cvTipoSolicitante\":\"03\",\"chTipoSolicitante\":\"REPRESENTANTE LEGAL\",\"fechaControl\":1498156642000,\"usuarioModificador\":\"GERENCIA MODELADO\"},{\"cvTipoSolicitante\":\"04\",\"chTipoSolicitante\":\"CURADOR\",\"fechaControl\":1498156642000,\"usuarioModificador\":\"GERENCIA MODELADO\"}";
				}
				
				if(url.contains("solicitantes/02")){
					throw new RuntimeException("solicitante");
				}
				
				if(url.contains("solicitantes/03")){
					t = null;
				}
				
				if(url.contains("/docRequerido/01")){
					String resultado = "{\"documentoRequerido\":{\"claveTipoProceso\":\"01\",\"claveTipoDocDigital\":\"08\",\"tipoDocumentoDigital\":{\"claveTipoDocumentoDigital\":\"08\","
							+ "\"descripcionDocumentoDigitla\":\"IDENTIFICACION\",\"usuarioModificador\":\"MIGRACION\",\"fechaControl\":1455069084000},\"numeroObligatorio\":1,\"numeroMesesVigencia\":120,"
							+ "\"usuarioModificador\":\"MIGRACION\",\"fechaControl\":1425005418000},\"descripcion\":\"IDENTIFICACION\"},{\"documentoRequerido\":{\"claveTipoProceso\":\"01\",\"claveTipoDocDigital\":\"15\","
							+ "\"tipoDocumentoDigital\":{\"claveTipoDocumentoDigital\":\"15\",\"descripcionDocumentoDigitla\":\"COMPROBANTE DE DOMICILIO\",\"usuarioModificador\":\"MIGRACION\","
							+ "\"fechaControl\":1455069085000},\"numeroObligatorio\":1,\"numeroMesesVigencia\":60,\"usuarioModificador\":\"MIGRACION\",\"fechaControl\":1425005418000},\"descripcion\":\"COMPROBANTE DE DOMICILIO\"},{\"documentoRequerido\":{\"claveTipoProceso\":\"01\","
							+ "\"claveTipoDocDigital\":\"31\",\"tipoDocumentoDigital\":{\"claveTipoDocumentoDigital\":\"31\",\"descripcionDocumentoDigitla\":\"FOTOGRAFIA DEL TRABAJADOR\",\"usuarioModificador\":\"MIGRACION\","
							+ "\"fechaControl\":1455069086000},\"numeroObligatorio\":1,\"numeroMesesVigencia\":60,\"usuarioModificador\":\"MIGRACION\",\"fechaControl\":1425005418000},\"descripcion\":\"FOTOGRAFIA DEL TRABAJADOR\"},{\"documentoRequerido\":{\"claveTipoProceso\":\"01\","
							+ "\"claveTipoDocDigital\":\"40\",\"tipoDocumentoDigital\":{\"claveTipoDocumentoDigital\":\"40\",\"descripcionDocumentoDigitla\":\"FIRMA AUTOGRAFA DIGITALIZADA\",\"usuarioModificador\":\"MIGRACION\",\"fechaControl\":1455069087000},\"numeroObligatorio\":0,\"numeroMesesVigencia\":60,"
							+ "\"usuarioModificador\":\"MIGRACION\",\"fechaControl\":1425005418000},\"descripcion\":\"FIRMA AUTOGRAFA DIGITALIZADA\"}";
					t = (T) resultado;
				}
				if(url.contains("/docRequerido/02")){
					t = null;
				}
				if(url.contains("/docRequerido/03")){
					throw new RuntimeException("tipoDocumeno");
				}
				if(url.contains("/retiro/pagos/parcialRetiro/63")){
					t = obtenerParcialidad(url);
				}
				if(url.contains("/retiro/pagos/parcialRetiro/1")){
					t = obtenerParcialidadNulo(url);
				}
				if(url.contains("/retiro/pagos/parcialRetiro/3")){
					throw new RuntimeException("Error al consultar las Parcialidaddes");
					
				}
				if(url.contains("/retiro/pagos/parcialRetiroEstatus/63")){
					t = obtenerParcialidad(url);
				}
				if(url.contains("/retiro/pagos/parcialRetiroEstatus/1")){
					t = obtenerParcialidadNulo(url);
				}
				if(url.contains("/retiro/pagos/parcialRetiroEstatus/3")){
					throw new RuntimeException("Error al consultar las Parcialidaddes Estatus dos");
					
				}
				
				if(url.contains("validar/consultaMarcaOperativaMatrizConvivencia/63/1601")){
					t =  validarMarcasConvivencia(url);
				}
				if(url.contains("validar/consultaMarcaOperativaMatrizConvivencia/0/1704")){
					
					t =  validarMarcasConvivenciaRestexception(url);
				}
				
				if(url.contains("consultaIretClavePension")){
					t =  (T) catalogoClavePension(url);
				}
				if(url.contains("consultaIretTipoPension")){
					t =  (T) catalogoTipoPension(url);
				}
				if(url.contains("consultaIretTipoPrestacion")){
					t =  (T) catalogoTipoPrestacaion(url);
				}
				if(url.contains("consultaIretTipoRetiro")){
					t =  (T) catalogoTipoRetiro(url);
				}
				if(url.contains("consultaIretTipoSeguro")){
					t =  (T) catalogoTipoSeguro(url);
				}
				if(url.contains("consultaIretDiagnostico/0002/0003/DM101/1")){
					t =  consultarDiagnostico(url);
				}
				
				if(url.contains("resolucionReti/consultarResolucionReti?idProcesar =1&claveTipoOperacion =2&claveProceso=4")){
					t =  consultarResolucion(url);
				
				}
				
				if(url.contains("resolucionReti/consultarResolucionReti?")){
					t =  consultarResolucionNulo(url);
					
				}
				
				if(url.contains("/factura/consultarFacturaReca/03?")){
					t = obtenerSalariosNulo(url);
				}
				if(url.contains("/factura/consultarFacturaReca/0?")){
					throw new RuntimeException("Error al consultar los salarios");
					
				}
				if(url.contains("/validacion/digitoVerificador/002352789012345678")){
					t = validarDigito(url);
				}
				
				if(url.contains("/validacion/digitoVerificador/002456789632541870")){
					throw new RuntimeException("Error al validar digito verificador");
					
				}
			  
				if(url.contains("derechoSubcuenta/obtenerDerechoSubcuentaPorIdMatrizDerecho/1")){
					t = (T) obtenerSubCuentaMatriz(url);
				}		
  				
				if(url.contains("derechoCarga/1")){
					t = (T) consultarDerechoCargado(url);
				}
				
				if(url.contains("recaudadoraTv/obtenerRecaudadoraTvPorNrp/Cr5675")){
					t =   (T) consultarNrp(url);
				}
				
				if(url.contains("recaudadoraTv/obtenerRecaudadoraTvPorNrp/null")){
					throw new RuntimeException("Error al validar NRP");
					
				}
				
				
				return t; 
			}
			
			/**
			 * Test para la consulta Resolucion
			 * @param url
			 * @return
			 */
			@SuppressWarnings("unchecked")
			private <T> T consultarResolucion(String url) {
				ResolucionReti resolucion=new ResolucionReti();
				resolucion.setClaveProceso("002");
				resolucion.setClaveAseguradora("001");
				resolucion.setClaveTipoOperacion("003");
				resolucion.setFechaCargaDatamart(new Date());
				resolucion.setIdResolucion(2l);
				resolucion.setPorcentajeValuacion(9l);
				resolucion.setSemanasCotizacion(10l);
				resolucion.setUsuarioModificador("PRUEBA");
				resolucion.setSecuenciaPension("001");
				
			return (T) resolucion;
			}
			
			/**
			 * Test para la consulta Resolucion Nulo
			 * @param url
			 * @return
			 */
			@SuppressWarnings("unchecked")
			private <T> T consultarResolucionNulo(String url) {
				ResolucionReti resolucion=new ResolucionReti();
				
			return (T) resolucion;
			}
			
			/**
			 * Test parcialiddes nulo
			 * @param url
			 * @return
			 */
			@SuppressWarnings("unchecked")
			private <T> T obtenerParcialidadNulo(String url) {
				RetiroParcialCalculoImssList listaPagoParcialidades = new RetiroParcialCalculoImssList();
				return (T) listaPagoParcialidades;
			}
			
			/**
			 * Test obtenerSalariosNulo nulo
			 * @param url
			 * @return
			 */
			@SuppressWarnings("unchecked")
			private <T> T obtenerSalariosNulo(String url) {
				List<RecaTrFactura> listaPagoParcialidades = new ArrayList<>();
				return (T) listaPagoParcialidades;
			}
			
			/**
			 * Test consultar diagnostico
			 * @param url
			 * @return
			 */
			@SuppressWarnings("unchecked")
			private <T> T consultarDiagnostico(String url) {
				IretTcDiagnostico dianostico= new IretTcDiagnostico();
				dianostico.setCveProceso("002");
				dianostico.setCveTipoOperacion("0003");
				dianostico.setDescDiagnostico("descripcion");
				dianostico.setActivo(1l);
				return (T) dianostico;
			}
			
			/**
			 * Valida digito verificador
			 * @param url
			 * @return
			 */
			@SuppressWarnings("unchecked")
			private <T> T validarDigito(String url) {
				RespuestaValidarDigitoVerificador digito= new RespuestaValidarDigitoVerificador();
				digito.setResultadoDeLaOperacion("01");
				digito.setDiagnosticoDeRecepcion("Exitoso");
				return (T) digito;
			}
			
			/**
			 * Test catalogo Tipo seguro
			 * @param url
			 * @return
			 */
			private List<CatalogoIret> catalogoTipoSeguro(String url) {
				List<CatalogoIret> listaCat = new ArrayList<>();
				CatalogoIret cat = new CatalogoIret();
				cat.setClave("A3");
				cat.setDescripcion("DOC FDG");
				listaCat.add(cat);
				return  listaCat; 
			}
		/**
		   * Test catalogo tipo retiro
		   * @param url
		   * @return
		   */
			private List<CatalogoIret> catalogoTipoRetiro(String url) {
				List<CatalogoIret> listaCat = new ArrayList<>();
				CatalogoIret cat = new CatalogoIret();
				cat.setClave("A2");
				cat.setDescripcion("DOC FDG");
				listaCat.add(cat);
				return  listaCat; 
			}
			/**
			 * Test catalogo tipo prestacion
			 * @param url
			 * @return
			 */
			private List<CatalogoIret> catalogoTipoPrestacaion(String url) {
				List<CatalogoIret> listaCat = new ArrayList<>();
				CatalogoIret cat = new CatalogoIret();
				cat.setClave("A1");
				cat.setDescripcion("DOC bg");
				listaCat.add(cat);
				return  listaCat; 
			}
			/**
			 * Test catalogo tipo Pension
			 * @param url
			 * @return
			 */
			private List<CatalogoIret> catalogoTipoPension(String url) {
				List<CatalogoIret> listaCat = new ArrayList<>();
				CatalogoIret cat = new CatalogoIret();
				cat.setClave("B");
				cat.setDescripcion("DOC SFS");
				listaCat.add(cat);
				return  listaCat; 
			}
			/**
			 * Test Catalogo clave pension
			 * @param url
			 * @return
			 */
			private List<CatalogoIret> catalogoClavePension(String url) { 
				List<CatalogoIret> listaCat = new ArrayList<>();
				CatalogoIret cat = new CatalogoIret();
				cat.setClave("A");
				cat.setDescripcion("TIPO DESC");
				listaCat.add(cat);
				return  listaCat; 
			}
			
			/**
			 * Test pra validacion marcas
			 */
			@SuppressWarnings({ "hiding", "unchecked" })
			private <T> T validarMarcasConvivencia(String url) {
				List<String> lista = new ArrayList<>();
				String afore = "556";
				lista.add(afore);
				ParametrosSalidaMarca marca = new ParametrosSalidaMarca();
				marca.setClaveProceso("456");
				marca.setDescripcionProceso("marca");
				
				return (T) marca;
			}
			
			@SuppressWarnings({ "hiding", "unchecked" })
			private <T> T validarMarcasConvivenciaRestexception(String url) {
				List<String> lista = new ArrayList<>();
				String afore = "0";
				lista.add(afore);
				ParametrosSalidaMarca marca = null;
				return (T) marca;
			}
			
			@SuppressWarnings("unchecked")
			private <T> T obtenerDatosPersona(String url) {
				//Persona
				List<PersonaSalida> respuesta = new ArrayList<>();
				PersonaSalida persona = new PersonaSalida();
				//Telefono
				TelefonoTrabajador telefono = new TelefonoTrabajador();
				List<TelefonoTrabajador> listaTelefono = new ArrayList<>();
				TipoTelefono tipoTelefono = new TipoTelefono();
				//Domicilio
				List<NsarDomicilio> listaDomicilio = new ArrayList<>();
				NsarDomicilioPK iddomicilio = new NsarDomicilioPK();
				NsarDomicilio domicilio = new NsarDomicilio();
				NsarMunicipio municipio = new NsarMunicipio();
				EntidadFederativa entidad = new EntidadFederativa();
				Pais pais = new Pais();
				pais.setDescripcion("pais");
				entidad.setDescripcion("entidad");
				entidad.setPais(pais);
				municipio.setDescripcion("municipio");
				municipio.setEntidadFederativa(entidad);
				//Parentesco
				Parentesco parentesco = new Parentesco();
				BigDecimal decimal = new BigDecimal(15);
				String resultado = null;
				parentesco.setDescripcion("primo");
				//Beneficiario
				List<NsarBeneficiario> listaBeneficiario = new ArrayList<>();
				NsarBeneficiario beneficiario = new NsarBeneficiario();
				NsarBeneficiarioPK id = new NsarBeneficiarioPK();
				id.setCurp("curp");
				beneficiario.setNombre("nombre");
				beneficiario.setApellidoPaterno("paterno");
				beneficiario.setApellidoMaterno("materno");
				beneficiario.setParentesco(parentesco);
				beneficiario.setId(id);
				//Referencia
				List<ReferenciaTrabajador> listaReferencia = new ArrayList<>();
				ReferenciaTrabajador referencia = new ReferenciaTrabajador();
				ReferenciaTrabajadorPK idR = new ReferenciaTrabajadorPK();
				id.setCurp("curp");
				referencia.setId(idR);
				referencia.setNombre("nombre");
				referencia.setApellidoPaterno("apellido p");
				referencia.setApellidoMaterno("materno");
				referencia.setTelefono("telefono");
				referencia.setParentesco(parentesco);
				listaReferencia.add(referencia);
				//Participante
				Participante participante = new Participante();
				participante.setRfc("rfc");
				//Sexo
				Sexo sexo = new Sexo();
				sexo.setClaveGenero("M");
				sexo.setDescripcionGenero("Mujer");
				//Afore
				Afore afore = new Afore();
				//Entidad nacimiento
				EntidadFederativa nacimiento = new EntidadFederativa();
				nacimiento.setDescripcion("nacimiento");

				//Beneficiarios
				beneficiario.setNombre("joel");
				beneficiario.setApellidoPaterno("Onofre");
				beneficiario.setApellidoPaterno("Cabrera");
				beneficiario.setParentesco(parentesco);
				beneficiario.setPorcentaje(decimal);
				listaBeneficiario.add(beneficiario);
				//Parentesco
				parentesco.setDescripcion("Tio");
				referencia.setNombre("ernesto");
				referencia.setApellidoPaterno("Mendez");
				referencia.setApellidoMaterno("Torres");
				listaReferencia.add(referencia);
				referencia.setParentesco(parentesco);
				participante.setChCorreoElectronico("jmguti@gmail.com");
				participante.setRfc("07gt25ga");
				//Domicilio
				iddomicilio.setIdTipoDomicilio(1L);
				domicilio.setId(iddomicilio);
				domicilio.setCalle("16 de septiembre");
				domicilio.setCiudad("puebla");
				domicilio.setCodigoPostal("74400");
				domicilio.setColonia("jardines");
				domicilio.setNumeroExterior("4");
				domicilio.setNumeroInterior("158");
				domicilio.setNsarMunicipio(municipio);
				listaDomicilio.add(domicilio);
				//Telefono
				tipoTelefono.setClaveTipoTelefono("01");
				telefono.setTipoTelefono(tipoTelefono);
				telefono.setNumeroTelefono("2434368583");
				tipoTelefono.setClaveTipoTelefono("03");
				telefono.setTipoTelefono(tipoTelefono);
				telefono.setNumeroTelefono("2434368583");
//					telefono.setParticipante(participante);
				listaTelefono.add(telefono);
				//Afore
				afore.setActivo(1);
				afore.setClaveAfore("556");
				afore.setDescripcionAfore("AFORE AZTECA");
				afore.setId(854171786476L);
				afore.setFechaControl(new Date());
				afore.setUsuarioModificador("CULMINACION");
				afore.setTelefonoAfore("018001121313");
				afore.setTipoAdministracion("A");
				//Persona
				persona.setIdProcesar(108672854689L);
				persona.setAfore(afore);
				persona.setApellidoPaterno("gutierrez");
				persona.setApellidoMaterno("Gadea");
				persona.setNombre("jose");
				persona.setTipoAfiliacion("2");
				persona.setFechaAutTraspaso(new Date());
				persona.setFechaInicioAfore(new Date());
				persona.setNss("34947380688");
				persona.setCurp("ROSA831608MDFMMM06");
				persona.setSexo(sexo);
				persona.setDocumentoProbatorio("1");
				persona.setFolioDocProbatorio("0102302012901234");
				persona.setCurpRaiz("ROSA831608MDFMMM07");
				persona.setClaveGiro("08");
				persona.setGradoEstudios("04");
				persona.setOcupacion("54");
				persona.setTipoAdmin("01");
				persona.setTipoRegimen("73");
				persona.setFechaInicioCotizacion(new Date());
				persona.setPeriodoPagoReingreso(new Date());
				persona.setFechaPrimeraAfiliacion(new Date());
				persona.setVencimientoBonoRendi(new Date());
				persona.setEntidadNacimiento(nacimiento);
				persona.setNacionalidad(1L);
				persona.setPerfilSeguridad(1L);
				persona.setIdTipoDoctoProbatorio(3L);
				persona.setTelefonoList(listaTelefono);
				persona.setDomicilioList(listaDomicilio);
				persona.setReferenciaList(listaReferencia);
				persona.setBeneficiarioList(listaBeneficiario);
				persona.setParticipante(participante);
				respuesta.add(persona);
				persona.setIdProcesar(108672854688L);
				respuesta.add(persona);
				JsonUtilsImpl<String> json = new JsonUtilsImpl<>();
				resultado = json.parseListObjectToJson(respuesta);

				return (T)resultado;
				
			}
			
			/**
			 *  Test para obtenr SubCuentas Matriz
			 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
			 *  @param url
			 *  @return
			 */
			private List<DerechoSubcuenta> obtenerSubCuentaMatriz(String url) {
				List<DerechoSubcuenta> respuestaCta = new ArrayList<>();
				DerechoSubcuenta derechSubCuenta = new DerechoSubcuenta();
				Subcuenta subcuenta = new Subcuenta();
				subcuenta.setClave("12");
				subcuenta.setDescripcion("desc");
				subcuenta.setSubcuentaSaldo("100");
				derechSubCuenta.setChUsuarioModificador("Prueba");
				derechSubCuenta.setCvEstatusVivienda("01");
				
				derechSubCuenta.setFcControl(new Date());
				derechSubCuenta.setIdDerechoSubCuenta(1l);
				derechSubCuenta.setChUsuarioModificador("Prueba");
				derechSubCuenta.setIdMatrizDerecho(1l);
				derechSubCuenta.setCvSubCuenta(subcuenta);
				respuestaCta.add(derechSubCuenta);
				return  respuestaCta; 
			}
			
					
			/**
			 * 
			 *  Test consultarDerechoCargado
			 *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
			 *  @param url
			 *  @return
			 */
			private List<ProcesoDerechoCargado> consultarDerechoCargado(String url) {
				List<ProcesoDerechoCargado> respuesta = new ArrayList<>();
				ProcesoDerechoCargado cargado = new ProcesoDerechoCargado();
				cargado.setCvTipoPension("A");
				cargado.setCvTipoRegimen("V");
				cargado.setDescTipoRetiro("ret");
				cargado.setCvTipoPension("C");
				cargado.setCvTipoPrestacion("00");
				cargado.setDescTipoRegimen("desc");
				cargado.setDescTipoPrestacion("des");
				cargado.setDescTipoRegimen("ab");
				cargado.setDescTipoRetiro("f");
				
				
				respuesta.add(cargado);
				return  respuesta; 
			}
			
			/**
			 * 
			 */
			private RecaudadoraTV consultarNrp(String url) {
				RecaudadoraTV respuesta = new RecaudadoraTV();
				respuesta.setChCveOperacion("cv");
				respuesta.setChFolio("fol");
				respuesta.setChPeriodoPago("pag");
				respuesta.setChRfcPatron("rfc");
				respuesta.setChSucursal("01");
				respuesta.setChUsuarioModificador("Prueba");
				respuesta.setCvEstadoTv("cvE");
				respuesta.setCvTipoPago("cvPago");
				respuesta.setFcControl(new Date());
				respuesta.setIdArchivo(1l);
				respuesta.setNrp("Cr5675");
				respuesta.setIdArchivo(1l);
				
				return respuesta; 
			}
			
		};
	}
	/**
	 * Servicio cus
	 */
	@SuppressWarnings("unchecked")
	public <T> T obtenerRespuestaCus(String url, AforeAgente agente) {
		AgentePromotor respuesta = new AgentePromotor();
		if(url.contains(ServiciosConstants.SERVICIO_AGENTE)) {
			DatosAgente datos = new DatosAgente();
			datos.setClaveAfore("556");
			datos.setClaveAgente("1234567890");
			datos.setNombreAgente("PRUEBA");
			datos.setApePaternoAgente("PRUEBA");
			datos.setApeMaternoAgente("PRUEBA");
			datos.setCurpAgente("012345678912345678");
			respuesta.setDatosAgente(datos);
		}
		return (T)respuesta;
	}
	
	/**
	 * Busqueda de agente promotor
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T obtesRespuestaAgente() {
		AgentePromotor agente = new AgentePromotor();
		agente.setCodigoOperacion("A09");
		return (T) agente;
	}
	
	/**
	 * Servicio cus
	 */
	@SuppressWarnings("unchecked")
	public <T> T obtenerRespuestaPersona(String url) {
		//Persona
		List<PersonaSalida> respuesta = new ArrayList<>();
		PersonaSalida persona = new PersonaSalida();
		//Telefono
		TelefonoTrabajador telefono = new TelefonoTrabajador();
		List<TelefonoTrabajador> listaTelefono = new ArrayList<>();
		TipoTelefono tipoTelefono = new TipoTelefono();
		//Domicilio
		List<NsarDomicilio> listaDomicilio = new ArrayList<>();
		NsarDomicilioPK iddomicilio = new NsarDomicilioPK();
		NsarDomicilio domicilio = new NsarDomicilio();
		NsarMunicipio municipio = new NsarMunicipio();
		EntidadFederativa entidad = new EntidadFederativa();
		Pais pais = new Pais();
		pais.setDescripcion("pais");
		entidad.setDescripcion("entidad");
		entidad.setPais(pais);
		municipio.setDescripcion("municipio");
		municipio.setEntidadFederativa(entidad);
		//Parentesco
		Parentesco parentesco = new Parentesco();
		BigDecimal decimal = new BigDecimal(15);
		String resultado = null;
		parentesco.setDescripcion("primo");
		//Beneficiario
		List<NsarBeneficiario> listaBeneficiario = new ArrayList<>();
		NsarBeneficiario beneficiario = new NsarBeneficiario();
		NsarBeneficiarioPK id = new NsarBeneficiarioPK();
		id.setCurp("curp");
		beneficiario.setNombre("nombre");
		beneficiario.setApellidoPaterno("paterno");
		beneficiario.setApellidoMaterno("materno");
		beneficiario.setParentesco(parentesco);
		beneficiario.setId(id);
		//Referencia
		List<ReferenciaTrabajador> listaReferencia = new ArrayList<>();
		ReferenciaTrabajador referencia = new ReferenciaTrabajador();
		ReferenciaTrabajadorPK idR = new ReferenciaTrabajadorPK();
		id.setCurp("curp");
		referencia.setId(idR);
		referencia.setNombre("nombre");
		referencia.setApellidoPaterno("apellido p");
		referencia.setApellidoMaterno("materno");
		referencia.setTelefono("telefono");
		referencia.setParentesco(parentesco);
		listaReferencia.add(referencia);
		//Participante
		Participante participante = new Participante();
		participante.setRfc("rfc");
		//Sexo
		Sexo sexo = new Sexo();
		sexo.setClaveGenero("M");
		sexo.setDescripcionGenero("Mujer");
		//Afore
		Afore afore = new Afore();
		//Entidad nacimiento
		EntidadFederativa nacimiento = new EntidadFederativa();
		nacimiento.setDescripcion("nacimiento");

		if(url.contains("trabajador/nss")) {
			//Beneficiarios
			beneficiario.setNombre("joel");
			beneficiario.setApellidoPaterno("Onofre");
			beneficiario.setApellidoPaterno("Cabrera");
			beneficiario.setParentesco(parentesco);
			beneficiario.setPorcentaje(decimal);
			listaBeneficiario.add(beneficiario);
			//Parentesco
			parentesco.setDescripcion("Tio");
			referencia.setNombre("ernesto");
			referencia.setApellidoPaterno("Mendez");
			referencia.setApellidoMaterno("Torres");
			listaReferencia.add(referencia);
			referencia.setParentesco(parentesco);
			participante.setChCorreoElectronico("jmguti@gmail.com");
			participante.setRfc("07gt25ga");
			//Domicilio
			iddomicilio.setIdTipoDomicilio(1L);
			domicilio.setId(iddomicilio);
			domicilio.setCalle("16 de septiembre");
			domicilio.setCiudad("puebla");
			domicilio.setCodigoPostal("74400");
			domicilio.setColonia("jardines");
			domicilio.setNumeroExterior("4");
			domicilio.setNumeroInterior("158");
			domicilio.setNsarMunicipio(municipio);
			listaDomicilio.add(domicilio);
			//Telefono
			tipoTelefono.setClaveTipoTelefono("01");
			telefono.setTipoTelefono(tipoTelefono);
			telefono.setNumeroTelefono("2434368583");
			tipoTelefono.setClaveTipoTelefono("03");
			telefono.setTipoTelefono(tipoTelefono);
			telefono.setNumeroTelefono("2434368583");
//			telefono.setParticipante(participante);
			listaTelefono.add(telefono);
			//Afore
			afore.setActivo(1);
			afore.setClaveAfore("556");
			afore.setDescripcionAfore("AFORE AZTECA");
			afore.setId(854171786476L);
			afore.setFechaControl(new Date());
			afore.setUsuarioModificador("CULMINACION");
			afore.setTelefonoAfore("018001121313");
			afore.setTipoAdministracion("A");
			//Persona
			persona.setIdProcesar(108672854689L);
			persona.setAfore(afore);
			persona.setApellidoPaterno("gutierrez");
			persona.setApellidoMaterno("Gadea");
			persona.setNombre("jose");
			persona.setTipoAfiliacion("2");
			persona.setFechaAutTraspaso(new Date());
			persona.setFechaInicioAfore(new Date());
			persona.setNss("34947380688");
			persona.setCurp("ROSA831608MDFMMM06");
			persona.setSexo(sexo);
			persona.setDocumentoProbatorio("1");
			persona.setFolioDocProbatorio("0102302012901234");
			persona.setCurpRaiz("ROSA831608MDFMMM07");
			persona.setClaveGiro("08");
			persona.setGradoEstudios("04");
			persona.setOcupacion("54");
			persona.setTipoAdmin("01");
			persona.setTipoRegimen("73");
			persona.setFechaInicioCotizacion(new Date());
			persona.setPeriodoPagoReingreso(new Date());
			persona.setFechaPrimeraAfiliacion(new Date());
			persona.setVencimientoBonoRendi(new Date());
			persona.setEntidadNacimiento(nacimiento);
			persona.setNacionalidad(1L);
			persona.setPerfilSeguridad(1L);
			persona.setIdTipoDoctoProbatorio(3L);
			persona.setTelefonoList(listaTelefono);
			persona.setDomicilioList(listaDomicilio);
			persona.setReferenciaList(listaReferencia);
			persona.setBeneficiarioList(listaBeneficiario);
			persona.setParticipante(participante);
			respuesta.add(persona);
			JsonUtilsImpl<String> json = new JsonUtilsImpl<>();
			 resultado = json.parseListObjectToJson(respuesta);
		}

		return (T)resultado;
	}
	/**
	 * Test para consultar tipo afiliacion 1
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T obtenerPersonaError2(String url) {
		//Persona
		List<PersonaSalida> respuesta = new ArrayList<>();
		PersonaSalida persona = new PersonaSalida();
		List<TelefonoTrabajador> listaTelefono = new ArrayList<>();
		//Domicilio
		List<NsarDomicilio> listaDomicilio = new ArrayList<>();
		NsarMunicipio municipio = new NsarMunicipio();
		EntidadFederativa entidad = new EntidadFederativa();
		Pais pais = new Pais();
		pais.setDescripcion("pais");
		entidad.setDescripcion("entidad");
		entidad.setPais(pais);
		municipio.setDescripcion("municipio");
		municipio.setEntidadFederativa(entidad);
		//Parentesco
		Parentesco parentesco = new Parentesco();
		String resultado = null;
		parentesco.setDescripcion("primo");
		//Beneficiario
		List<NsarBeneficiario> listaBeneficiario = new ArrayList<>();
		NsarBeneficiario beneficiario = new NsarBeneficiario();
		NsarBeneficiarioPK id = new NsarBeneficiarioPK();
		id.setCurp("curp");
		beneficiario.setNombre("nombre");
		beneficiario.setApellidoPaterno("paterno");
		beneficiario.setApellidoMaterno("materno");
		beneficiario.setParentesco(parentesco);
		beneficiario.setId(id);
		//Referencia
		List<ReferenciaTrabajador> listaReferencia = new ArrayList<>();
		ReferenciaTrabajador referencia = new ReferenciaTrabajador();
		ReferenciaTrabajadorPK idR = new ReferenciaTrabajadorPK();
		id.setCurp("curp");
		referencia.setId(idR);
		referencia.setNombre("nombre");
		referencia.setApellidoPaterno("apellido p");
		referencia.setApellidoMaterno("materno");
		referencia.setTelefono("telefono");
		referencia.setParentesco(parentesco);
		listaReferencia.add(referencia);
		//Participante
		Participante participante = new Participante();
		participante.setRfc("rfc");
		//Sexo
		Sexo sexo = new Sexo();
		sexo.setClaveGenero("M");
		sexo.setDescripcionGenero("Mujer");
		//Afore
		Afore afore = new Afore();
		afore.setActivo(1);
		afore.setClaveAfore("556");
		afore.setDescripcionAfore("AFORE AZTECA");
		afore.setId(854171786476L);
		afore.setFechaControl(new Date());
		afore.setUsuarioModificador("CULMINACION");
		afore.setTelefonoAfore("018001121313");
		afore.setTipoAdministracion("A");
		//Entidad nacimiento
		EntidadFederativa nacimiento = new EntidadFederativa();
		nacimiento.setDescripcion("nacimiento");
		
		//Persona
		persona.setIdProcesar(123456L);
		persona.setAfore(afore);
		persona.setApellidoPaterno("gutierrez");
		persona.setApellidoMaterno("Gadea");
		persona.setNombre("jose");
		persona.setTipoAfiliacion("1");
		persona.setFechaAutTraspaso(new Date());
		persona.setFechaInicioAfore(new Date());
		persona.setNss("34947380688");
		persona.setCurp("ROSA831608MDFMMM06");
		persona.setSexo(sexo);
		persona.setDocumentoProbatorio("1");
		persona.setFolioDocProbatorio("0102302012901234");
		persona.setCurpRaiz("ROSA831608MDFMMM07");
		persona.setClaveGiro("08");
		persona.setGradoEstudios("04");
		persona.setOcupacion("54");
		persona.setTipoAdmin("01");
		persona.setTipoRegimen("73");
		persona.setFechaInicioCotizacion(new Date());
		persona.setPeriodoPagoReingreso(new Date());
		persona.setFechaPrimeraAfiliacion(new Date());
		persona.setVencimientoBonoRendi(new Date());
		persona.setEntidadNacimiento(nacimiento);
		persona.setNacionalidad(5L);
		persona.setPerfilSeguridad(1L);
		persona.setIdTipoDoctoProbatorio(3L);
		persona.setTelefonoList(listaTelefono);
		persona.setDomicilioList(listaDomicilio);
		persona.setReferenciaList(listaReferencia);
		persona.setBeneficiarioList(listaBeneficiario);
		persona.setParticipante(participante);
		respuesta.add(persona);
		JsonUtilsImpl<String> json = new JsonUtilsImpl<>();
		 resultado = json.parseListObjectToJson(respuesta);
		return (T) resultado;
	}
	
	/**
	 * Servicio cus
	 */
	@SuppressWarnings("unchecked")
	public <T> T obtenerRespuestaPersonaNacionalidad(String url) {
		//Persona
		List<PersonaSalida> respuesta = new ArrayList<>();
		PersonaSalida persona = new PersonaSalida();
		List<TelefonoTrabajador> listaTelefono = new ArrayList<>();
		//Domicilio
		List<NsarDomicilio> listaDomicilio = new ArrayList<>();
		NsarMunicipio municipio = new NsarMunicipio();
		EntidadFederativa entidad = new EntidadFederativa();
		Pais pais = new Pais();
		pais.setDescripcion("pais");
		entidad.setDescripcion("entidad");
		entidad.setPais(pais);
		municipio.setDescripcion("municipio");
		municipio.setEntidadFederativa(entidad);
		//Parentesco
		Parentesco parentesco = new Parentesco();
		String resultado = null;
		parentesco.setDescripcion("primo");
		//Beneficiario
		List<NsarBeneficiario> listaBeneficiario = new ArrayList<>();
		NsarBeneficiario beneficiario = new NsarBeneficiario();
		NsarBeneficiarioPK id = new NsarBeneficiarioPK();
		id.setCurp("curp");
		beneficiario.setNombre("nombre");
		beneficiario.setApellidoPaterno("paterno");
		beneficiario.setApellidoMaterno("materno");
		beneficiario.setParentesco(parentesco);
		beneficiario.setId(id);
		//Referencia
		List<ReferenciaTrabajador> listaReferencia = new ArrayList<>();
		ReferenciaTrabajador referencia = new ReferenciaTrabajador();
		ReferenciaTrabajadorPK idR = new ReferenciaTrabajadorPK();
		id.setCurp("curp");
		referencia.setId(idR);
		referencia.setNombre("nombre");
		referencia.setApellidoPaterno("apellido p");
		referencia.setApellidoMaterno("materno");
		referencia.setTelefono("telefono");
		referencia.setParentesco(parentesco);
		listaReferencia.add(referencia);
		//Participante
		Participante participante = new Participante();
		participante.setRfc("rfc");
		//Sexo
		Sexo sexo = new Sexo();
		sexo.setClaveGenero("M");
		sexo.setDescripcionGenero("Mujer");
		//Afore
		Afore afore = new Afore();
		afore.setActivo(1);
		afore.setClaveAfore("556");
		afore.setDescripcionAfore("AFORE AZTECA");
		afore.setId(854171786476L);
		afore.setFechaControl(new Date());
		afore.setUsuarioModificador("CULMINACION");
		afore.setTelefonoAfore("018001121313");
		afore.setTipoAdministracion("A");
		
		//Persona
		persona.setIdProcesar(123456L);
		persona.setAfore(afore);
		persona.setApellidoPaterno("gutierrez");
		persona.setApellidoMaterno("Gadea");
		persona.setNombre("jose");
		persona.setTipoAfiliacion("2");
		persona.setFechaAutTraspaso(new Date());
		persona.setFechaInicioAfore(new Date());
		persona.setNss("34947380688");
		persona.setCurp("ROSA831608MDFMMM06");
		persona.setSexo(sexo);
		persona.setDocumentoProbatorio("1");
		persona.setFolioDocProbatorio("0102302012901234");
		persona.setCurpRaiz("ROSA831608MDFMMM07");
		persona.setClaveGiro("08");
		persona.setGradoEstudios("04");
		persona.setOcupacion("54");
		persona.setTipoAdmin("01");
		persona.setTipoRegimen("73");
		persona.setFechaInicioCotizacion(new Date());
		persona.setPeriodoPagoReingreso(new Date());
		persona.setFechaPrimeraAfiliacion(new Date());
		persona.setVencimientoBonoRendi(new Date());
		persona.setEntidadNacimiento(null);
		persona.setNacionalidad(5L);
		persona.setPerfilSeguridad(1L);
		persona.setIdTipoDoctoProbatorio(3L);
		persona.setTelefonoList(listaTelefono);
		persona.setDomicilioList(listaDomicilio);
		persona.setReferenciaList(listaReferencia);
		persona.setBeneficiarioList(listaBeneficiario);
		persona.setParticipante(participante);
		respuesta.add(persona);
		JsonUtilsImpl<String> json = new JsonUtilsImpl<>();
		 resultado = json.parseListObjectToJson(respuesta);

		return (T)resultado;
	}
	
	/**
	 * Servicio cus
	 */
	@SuppressWarnings("unchecked")
	public <T> T obtenerRespuestaPersonaNacionalidad1(String url) {
		//Persona
		List<PersonaSalida> respuesta = new ArrayList<>();
		PersonaSalida persona = new PersonaSalida();
		//Telefono
		List<TelefonoTrabajador> listaTelefono = new ArrayList<>();
		//Domicilio
		List<NsarDomicilio> listaDomicilio = new ArrayList<>();
		NsarMunicipio municipio = new NsarMunicipio();
		EntidadFederativa entidad = new EntidadFederativa();
		Pais pais = new Pais();
		pais.setDescripcion("pais");
		entidad.setDescripcion("entidad");
		entidad.setPais(pais);
		municipio.setDescripcion("municipio");
		municipio.setEntidadFederativa(entidad);
		//Parentesco
		Parentesco parentesco = new Parentesco();
		String resultado = null;
		parentesco.setDescripcion("primo");
		//Beneficiario
		List<NsarBeneficiario> listaBeneficiario = new ArrayList<>();
		NsarBeneficiario beneficiario = new NsarBeneficiario();
		NsarBeneficiarioPK id = new NsarBeneficiarioPK();
		id.setCurp("curp");
		beneficiario.setNombre("nombre");
		beneficiario.setApellidoPaterno("paterno");
		beneficiario.setApellidoMaterno("materno");
		beneficiario.setParentesco(parentesco);
		beneficiario.setId(id);
		//Referencia
		List<ReferenciaTrabajador> listaReferencia = new ArrayList<>();
		ReferenciaTrabajador referencia = new ReferenciaTrabajador();
		ReferenciaTrabajadorPK idR = new ReferenciaTrabajadorPK();
		id.setCurp("curp");
		referencia.setId(idR);
		referencia.setNombre("nombre");
		referencia.setApellidoPaterno("apellido p");
		referencia.setApellidoMaterno("materno");
		referencia.setTelefono("telefono");
		referencia.setParentesco(parentesco);
		listaReferencia.add(referencia);
		//Participante
		Participante participante = new Participante();
		participante.setRfc("rfc");
		//Sexo
		Sexo sexo = new Sexo();
		sexo.setClaveGenero("M");
		sexo.setDescripcionGenero("Mujer");
		//Afore
		Afore afore = new Afore();
		afore.setActivo(1);
		afore.setClaveAfore("556");
		afore.setDescripcionAfore("AFORE AZTECA");
		afore.setId(854171786476L);
		afore.setFechaControl(new Date());
		afore.setUsuarioModificador("CULMINACION");
		afore.setTelefonoAfore("018001121313");
		afore.setTipoAdministracion("A");
		//Entidad nacimiento
		EntidadFederativa nacimiento = new EntidadFederativa();
		nacimiento.setDescripcion("nacimiento");
		
		//Persona
		persona.setIdProcesar(12345678L);
		persona.setAfore(afore);
		persona.setApellidoPaterno("gutierrez");
		persona.setApellidoMaterno("Gadea");
		persona.setNombre("jose");
		persona.setTipoAfiliacion("2");
		persona.setFechaAutTraspaso(new Date());
		persona.setFechaInicioAfore(new Date());
		persona.setNss("34947380688");
		persona.setCurp("ROSA831608MDFMMM06");
		persona.setSexo(sexo);
		persona.setDocumentoProbatorio("1");
		persona.setFolioDocProbatorio("0102302012901234");
		persona.setCurpRaiz("ROSA831608MDFMMM07");
		persona.setClaveGiro("08");
		persona.setGradoEstudios("04");
		persona.setOcupacion("54");
		persona.setTipoAdmin("01");
		persona.setTipoRegimen("73");
		persona.setFechaInicioCotizacion(new Date());
		persona.setPeriodoPagoReingreso(new Date());
		persona.setFechaPrimeraAfiliacion(new Date());
		persona.setVencimientoBonoRendi(new Date());
		persona.setEntidadNacimiento(nacimiento);
		persona.setPerfilSeguridad(1L);
		persona.setIdTipoDoctoProbatorio(3L);
		persona.setTelefonoList(listaTelefono);
		persona.setDomicilioList(listaDomicilio);
		persona.setReferenciaList(listaReferencia);
		persona.setBeneficiarioList(listaBeneficiario);
		persona.setParticipante(participante);
		respuesta.add(persona);
		JsonUtilsImpl<String> json = new JsonUtilsImpl<>();
		 resultado = json.parseListObjectToJson(respuesta);

		return (T)resultado;
	}
	
	/**
	 * servicio consultar Roles
	 */
	@SuppressWarnings("unchecked")
	public <T> T obtenerRespuestaConsultaAfore(String url){
		List<Afore> respuesta = new ArrayList<>();
		Afore afore = new Afore();
		String resultado = new String();
		afore.setActivo(1);
		afore.setClaveAfore("556");
		afore.setDescripcionAfore("AFORE AZTECA");
		afore.setId(854171786476L);
		afore.setFechaControl(new Date());
		afore.setUsuarioModificador("CULMINACION");
		afore.setTelefonoAfore("018001121313");
		afore.setTipoAdministracion("A");
		respuesta.add(afore);
		JsonUtilsImpl<String> json = new JsonUtilsImpl<>();
		resultado = json.parseListObjectToJson(respuesta);
		return (T)resultado;
	}
	/**
	 * Obtener Entidad
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T obtenerEntidad(String url) {
		EntidadFederativa entidad = new EntidadFederativa();
		entidad.setDescripcion("puebla");
		return (T)entidad;
	}
	/**
	 * busqueda de parametro
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T obtenerParametro(String url) {
		Parametro parametro = new Parametro();
		List<Parametro> listaParametro = new ArrayList<>();
		parametro.setCvParametro("P02100");
		parametro.setChValorParametro("!");
		listaParametro.add(parametro);
		JsonUtilsImpl<String> json = new JsonUtilsImpl<>();
		String respuesta = json.parseListObjectToJson(listaParametro);
		return (T)respuesta;
	}
	/**
	 * busqueda de parametro
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T obtenerParametro2(String url) {
		Parametro parametro = new Parametro();
		List<Parametro> listaParametro = new ArrayList<>();
		parametro.setCvParametro("T00098");
		parametro.setChValorParametro("568,552");
		listaParametro.add(parametro);
		ParametroList lst = new ParametroList();
		lst.setListaParametros(listaParametro);
		
		JsonUtilsImpl<String> json = new JsonUtilsImpl<>();
		String respuesta = json.parseObjectToJson(lst);
		return (T)respuesta;
	}
	
	/**
	 * obtener icefa
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T obtenerIcefa(String url) {
		Icefa icefa = new Icefa();
		List<Icefa> listaIcefa = new ArrayList<>();
		icefa.setClaveIcefa("002");
		icefa.setDescripcionIcefa("BANAMEX");
		listaIcefa.add(icefa);
		JsonUtilsImpl<String> json = new JsonUtilsImpl<>();
		String respuesta = json.parseListObjectToJson(listaIcefa);
		return (T) respuesta;
	}
	
	/**
	 * obtener nacionalidad
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T obtenerNacionalidad(String url) {
		Nacionalidad nacionalidad = new Nacionalidad();
		nacionalidad.setId(1L);
		nacionalidad.setCvNacionalidad("1");
		nacionalidad.setChDescripcion("MEXICANA:MEXICO");
		nacionalidad.setChValorDespliegue("MEX");
		nacionalidad.setFechaControl(new Date());
		nacionalidad.setUsuarioModificador("PRUEBA");
		return (T) nacionalidad;
	}
	
	/**
	 * Obtener expediente
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T obtenerExpediente(String url) {
		String[] arreglo = null;
		SalidaGenerica salida = new SalidaGenerica();
		HashMap<String, Object> linken = new LinkedHashMap<>();
		linken.put("estatusExpedienteIdentificacion", "05");
		linken.put("claveExpedienteIdentificacion", null);
		linken.put("tipoIDE", null);
		linken.put("fechaIDE", 1553752800000L);
		linken.put("expedienteMovil", "1");
		linken.put("estatusEnrolamiento", "05");
		linken.put("calidadHuellas", null);
		linken.put("fechaEnrolamiento", null);
		linken.put("listaHuellas", arreglo);
//		Object objeto = linken;
		salida.setCodigoOperacion("1");
		salida.setMensaje("OK");
		salida.setResponse(linken);
		return (T) salida;
	}
	
	/**
	 * obtener marcas
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T obtenerMarcas(String url) {
		List<String> lista = new ArrayList<>();
		String afore = "556";
		lista.add(afore);
		ParametrosSalidaMarca marca = new ParametrosSalidaMarca();
		marca.setClaveProceso("456");
		marca.setDescripcionProceso("marca");
		JsonUtilsImpl<ParametrosSalidaMarca> json = new JsonUtilsImpl<>();
		String resultado = json.parseObjectToJson(marca);
		return (T) resultado;
	}
	
	/**
	 * obtener renapo
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T obtenerRenapo(String url) {
		String curps = "curp,curp";		
		String[] historica = curps.split(",");;
		CURPStruct curp = new CURPStruct();
		curp.setNombres("nombre");
		curp.setApellido1("paterno");
		curp.setApellido2("materno");
		curp.setCurp("ROSA831608MDFMMM07");
		curp.setFechNac("16/11/1996");
		curp.setCveEntidadNac("DF");
		curp.setSexo("M");
		curp.setCurpHistoricas(historica);
		
		return (T) curp;
	}
	
	/**
	 * consultar kardex
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T consultaKardex(String url) {
		String clave = "002";
		List<String> listaIcefa = new ArrayList<>();
		listaIcefa.add(clave);
		ListaIcefasDisponiblesSaldo lista = new ListaIcefasDisponiblesSaldo();
		lista.setIcefasDisponible(listaIcefa);
		ConsultarKardexSalida kardex = new ConsultarKardexSalida();	
		kardex.setNombreImss("nombreImss");
		kardex.setCurp("ROSA831608MDFMMM07");
		kardex.setDiagnosticoProcesar("049");
		kardex.setResultadoOperacion("02");
		kardex.setPeriodoPago("17/05/2000");
		kardex.setIndicadorRetiroDesempleo("0");
		kardex.setSalarioDiarioIntegrado("mil");
		kardex.setListaIcefasDisponiblesSaldo(lista);
		return (T)kardex;
	}
	
	/**
	 * curp duplicada
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T consultaCurpDuplicada(String url){
		String clave = "999";
		List<String> lista = new ArrayList<>();
		lista.add(clave);
		CurpDuplicada curp = new CurpDuplicada();
		curp.setCodigoOperacion("01");
		curp.setClaveAfore(lista);
		return (T) curp;
		
	}
	
	/**
	 * consultar estatus
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T consultarEstatus(String url) {
		EstatusExpediente estatus = new EstatusExpediente();
		estatus.setClaveEstatusExp("5");
		estatus.setChDescripcionExp("expediente");
		estatus.setChUsuarioModificador("prueba");
		estatus.setFechaControl(new Date());
		return (T) estatus;
	}
	
	@SuppressWarnings("unchecked")
	private <T> T obtenerParametroRoles(String url) {
		String cadenaRol = "{\"idParametro\":\"8082\",\"cvParametro\":\"T02418\",\"chParametro\":\"PR01\",\"chValorParametro\":\"01,02,03,04\",\"fechaModificacion\":\"1559140692000\",\"usuarioModificacion\":\"PLATAFORMA_SERVICIO\"},{\"idParametro\":\"8083\",\"cvParametro\":\"T02418\",\"chParametro\":\"PR02\",\"chValorParametro\":\"03,04\",\"fechaModificacion\":\"1559140692000\",\"usuarioModificacion\":\"PLATAFORMA_SERVICIO\"},{\"idParametro\":\"8084\",\"cvParametro\":\"T02418\",\"chParametro\":\"PR03\",\"chValorParametro\":\"05\",\"fechaModificacion\":\"1559140692000\",\"usuarioModificacion\":\"PLATAFORMA_SERVICIO\"},{\"idParametro\":\"8085\",\"cvParametro\":\"T02418\",\"chParametro\":\"PR04\",\"chValorParametro\":\"03,04,05\",\"fechaModificacion\":\"1559140692000\",\"usuarioModificacion\":\"PLATAFORMA_SERVICIO\"}";
		return (T) cadenaRol;
	}
	
	/**
	 * Consulta Parcialidad
	 * @param url
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> T obtenerParcialidad(String url) {
		RetiroParcialCalculoImssList listaPagoParcialidades = new RetiroParcialCalculoImssList();
		RetiroParcialCalculoImss retiro = new RetiroParcialCalculoImss();
		RetiroParcialCalculoImss retiro2 = new RetiroParcialCalculoImss();
		RetiroParcialCalculoImss retiro3 = new RetiroParcialCalculoImss();
		List<RetiroParcialCalculoImss> listaRetiroParcial = new ArrayList<>();
		ResolucionParcial resolucion = new ResolucionParcial();
		ResolucionParcial resolucion1 = new ResolucionParcial();
		ResolucionParcial resolucion2 = new ResolucionParcial();
		resolucion.setId(19641473l);
		resolucion.setNumeroResolucion("254354");
		
		resolucion1.setId(19641473l);
		resolucion1.setNumeroResolucion("254354");
		
		resolucion2.setId(19641473l);
		resolucion2.setNumeroResolucion("254354");
		 
		retiro.setIdRetiroParcialCalculo(82l);
		retiro.setCuenta("898765432");
		retiro.setCuentaClabe("002000000000000000");
		retiro.setFormaPago("1");
		retiro.setClaveBanco("002");
		retiro.setEstatus(1);
		retiro.setFechaPago(new Date());
		retiro.setParcialidad(1);
		retiro.setIdResolucionParcial(19641473l);
		
		retiro2.setIdRetiroParcialCalculo(83l);
		retiro2.setCuenta("898765432");
		retiro2.setCuentaClabe("002000000000000000");
		retiro2.setFormaPago("1");
		retiro2.setClaveBanco("002");
		retiro2.setEstatus(1);
		retiro2.setFechaPago(new Date());
		retiro2.setParcialidad(2);
		retiro2.setIdResolucionParcial(19641473l);
		
		retiro3.setIdRetiroParcialCalculo(84l);
		retiro3.setCuenta("898765432");
		retiro3.setCuentaClabe("002000000000000000");
		retiro3.setFormaPago("1");
		retiro3.setClaveBanco("002");
		retiro3.setEstatus(1);
		retiro3.setFechaPago(new Date());
		retiro3.setParcialidad(3);
		retiro3.setIdResolucionParcial(19641473l);
		
		listaRetiroParcial.add(retiro);
		listaRetiroParcial.add(retiro2);
		listaRetiroParcial.add(retiro3);
		listaPagoParcialidades.setListaRetiroParcial(listaRetiroParcial);

		return (T) listaPagoParcialidades;
	}
	
	
}