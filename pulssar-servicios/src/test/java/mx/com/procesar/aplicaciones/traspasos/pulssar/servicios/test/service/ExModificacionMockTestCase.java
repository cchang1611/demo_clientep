package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import static org.mockito.ArgumentMatchers.any;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl.ExpedienteServicioServiceImpl;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BanderaDatosModificadosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseCurp;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBeneficiarioTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioLaboralTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosDomicilioParticularTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNoCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosReferenciasTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DetalleRecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Domicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ExpedienteDetail;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenDocumento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ImagenWrapper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ListaBeneficiariosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Parametro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Referencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaAlta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Sello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Telefono;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.VerificacionSello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.LectorArchivoUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ExModificacionMockTestCase {

	/**
	 * Injeccion de servicio
	 */
	@Autowired
	@InjectMocks
	private ExpedienteServicioService serviceExpediente = new ExpedienteServicioServiceImpl();
	
	/**
	 * Inyeccion de directorio
	 */
	@Mock
	private FechaUtils fechaUtils;
	
	/**
	 * Inyeccion de RestTemplate
	 */
	@Autowired
	@Mock
	private RestTemplate servicioCliente;
	
	/**
	 * Inyeccion de utileria compresor
	 */
	@Mock
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de utileria
	 */
	@Mock
	private RecepcionArchivosService servicioArchivos;
	
	/**
	 * Inyeccion de servicio
	 */
	@Mock
	private CadenasUtils utileriaCadena;
	
	/**
	 * Utilidad Lector
	 */
	@Mock
	private LectorArchivoUtils lectorUtils;
	
	/**
	 * Inyeccion de utileria
	 */
	@Mock
	private CatalogoService servicioCatalogo;
	
	 /**
     * Inyeccion expedienteService
     */
	@Mock
     private EstatusExpedienteService expedienteService;
	
    /**
     * ConsultaSelloProxyService
     */
	@Mock
	private ConsultaSelloService consultaSelloService;
	
	/**
	 * Inyeccion de utileria
	 */
	@Mock
	private FolioService servicioFolio;

	
	
	/**
	 * Set up
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	

	/*
	 * INFO: #Entrada Modificacion: EntradaModificacion [entidadOrigen=538, tipoDeMovimiento=1, nss=null, 
	 * curp=RISG650228MTLSNB01, 
	 * datosBaseCurp=DatosBaseCurp [curpNueva=RISG650228MTLSNB01, rfc=RISG650228MTL, 
	 * apellidoPaterno=RIOSs, apellidoMaterno=SANCHEZ, nombreTrabajador=GABRIELA, fechaDeNacimiento=19650228, sexo=2, 
	 * entidadFederativaDeNacimiento=29, nacionalidad=MEX, claveDeTipoDeDocumentoProbatorio=null, 
	 * folioDeLaSolicitud=1909060022, documentoProbatorio=null, folioDeDocumentoProbatorio=null, 
	 * ocupacionOProfesionTrabajador=11, actividadOGiroNegocioTrabajador=12, nivelDeEstudioTrabajador=03, 
	 * flujoDeValidacion=2A, selloVerificacionBiometrica=11111111111111, selloVoluntadTramite=99999999999999, 
	 * indicadorDeDuplicidad=0, indicadorDeServicioBiometrico=0507, curpSolicitante=RISG650228MTLSNB01, 
	 * tipoSolicitante=01], datosDomicilioParticularTrabajador=DatosDomicilioParticularTrabajador [calle=calle4,
	 *  numeroExterior=121, numeroInterior=121, colonia=valle los reyes, delegacionOMunicipio=ALVARO OBREGON, 
	 *  codigoPostal=12345, entidadFederativa=DISTRITO FEDERAL, pais=MEX, indicadorDeTelefono1=000, telefono1=5667777777, 
	 *  extension1=123, indicadorDeTelefono2=000, telefono2=5677889900, extension2=321, 
	 *  correoElectronicoDelTrabajador=chay@gmail.com], 
	 *  datosDomicilioLaboralTrabajador=DatosDomicilioLaboralTrabajador [calle=Calle9, numeroExterior=123, 
	 *  numeroInterior=456, colonia=Pinos, delegacionOMunicipio=IZTACALCO, codigoPostal=98765, 
	 *  entidadFederativa=DISTRITO FEDERAL, pais=MEX], 
	 *  datosReferenciasTrabajador=DatosReferenciasTrabajador [apellidoPaternoDeReferencia1=Perez, 
	 *  apellidoMaternoDeReferencia1=Lirios, nombreDeReferencia1=Luisa, curpDeReferencia1=FRTY890122HDFTJB78, 
	 *  telefonoDeReferencia1=5666778800, parentescoORelacionDeReferencia1=11, apellidoPaternoDeReferencia2=Rojas, 
	 *  apellidoMaternoDeReferencia2=feriz, nombreDeReferencia2=Armando, curpDeReferencia2=MAGO820808HBCRRS01, 
	 *  telefonoDeReferencia2=5666778899, parentescoORelacionDeReferencia2=19], listaBeneficiariosTrabajador=null]
	 *  
	 *  
	 *  DatosTrabajador [nombreTrabajador=GABRIELA RIOS SANCHEZ, nss=09876543210, claveAfore=538, 
	 *  procesar=922868707147, datosCertificables=DatosCertificables [curp=RISG650228MTLSNB01, nombre=GABRIELA, 
	 *  apellidoPaterno=RIOS, apellidoMaterno=SANCHEZ, fechaNacimiento=28/febrero/1965, genero=FEMENINO, 
	 *  entidadNacimiento=TLAXCALA], 
	 *  datosNoCertificables=DatosNoCertificables [rfc=RISG650228MTL, claveNacionalidad=1, 
	 *  claveTipoDocProbatorio=null, folioSolicitud=null, documentoProbatorio=null, folioDocumentoProbatorio=null, 
	 *  claveOcupacion=null, claveGiro=null, estudios=null], 
	 *  datosComplementarios=DatosComplementarios [particular=Domicilio [calle=, noExterior=, noInterior=, 
	 *  colonia=, municipio=null, codigoPostal=, entidadFederativa=null, pais=null], laboral=null, 
	 *  telefonos=Telefono [telefonoFijo=, celular=, telefonoLaboral=null, extension=null], 
	 *  correoElectronico=null, listaReferencias=null, listaBeneficiario=null], 
	 *  datosExpediente=DatosExpediente [estatusExpedienteIdentificacion=5, 
	 *  descEstatusExpedienteIdentificacion=PERMANENTE, aforeIdentificacion=538, 
	 *  descAforeIdentificacion=PRINCIPAL AFORE, tipoIDE=null, fechaIDE=30/octubre/2019, 
	 *  fechaConformacion=null, expedienteMovil=NO ACTIVO, aforeMovil=, descAforeMovil=, estatusEnrolamiento=5, 
	 *  descEstatusEnrolamiento=PERMANENTE, huellasTrabajador=null, fechaEnrolamiento=null, aforeEnrolamiento=538, 
	 *  descAforeEnrolamiento=PRINCIPAL AFORE, banderaExpedienteIdentifiacion=1, banderaEnrolamiento=1, 
	 *  banderaCurpHistorica=0, curpHistorica=RISG650228MTLSNB01], 
	 *  marcas=[CUENTA INDIVIDUAL REINGRESO, RECAUDACION_DEVOLUCION_PAGOS_EN_EXCESO_ISSSTE], 
	 *  aforesDuplicadas=[], nombreImss=, imagen=, 
	 *  renapo=Renapo [banderaNombre=0, banderaGenero=0, banderaFechaNacimiento=0, banderaEntidadNacimiento0,
	 *  nombre=GABRIELA, apellidoPaterno=RIOS, apellidoMaterno=SANCHEZ, curp=RISG650228MTLSNB01, banderaCurp=0, 
	 *  fechaNacmiento=28/febrero/1965, entidadNacimiento=TLAXCALA, sexo=FEMENINO, 
	 *  listaCurpHistoricas=[RISG650218MTLSNB01], curpsHistoricas=RISG650218MTLSNB01<br />], 
	 *  salariosIcefas=DatosSalariosIcefas [periodo=, salario=, indicador=0, listaIcefas=[]], 
	 *  saldos=DatosSaldos [saldoSar92=null, saldoRetiro97=null, saldoCuotaSocial=null, 
	 *  saldoCesantiaVejez=null, saldoVivienda97=null, saldoVivienda97AIVS=null, saldoVivienda92=null, 
	 *  saldoVivienda92AIVS=null, saldoAhorroRetiroIB=null, saldoAportacionesVoluntarias=null, 
	 *  saldoRetiro92I=null, saldoAportaCompRetiro=null, saldoViviendaFI92=null, saldoViviendaFI92AIVS=null, 
	 *  saldoAportaLargoPlazo=null, saldoFI08=null, saldoFI08AIVS=null, saldoRetiroI08=null, saldoCVI=null, 
	 *  saldoAhorroSolidario=null, saldoCuotaSocialI=null, saldoBonoMontoUDIS=null,motivoRechazo=G001,
	 *  descripcion=Por el momento no es posible validar tu solicitud. .], 
	 *  folio=FolioSalida [idUsuario=53, sucursal=SUC, folio=C0000053201910240027, operacion=C, 
	 *  curp=RISG650228MTLSNB01, nss=09876543210, descripcion=null, servicio=C, proceso=null, idFolio=14016, 
	 *  estatus=null, resultado=01, tiempoLlegada=03:03, idFolioPadre=null, folios=null], certificado=0, 
	 *  nacionalidad=MEXICANA, origen=null, claveAdminActual=null, tipoDePrestacion=null, tipoAfiliacion=4, 
	 *  tipoSolicitante=01]
	 *  
	 */
	
	@Test
	public void testGenerarSolicitudDatosPeis() throws DocumentException, IOException{ 
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setNss("09876543210");
		datosTrabajador.setNacionalidad("MEXICANA");
			
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setNombre("GABRIELA");
		datosCertificables.setApellidoPaterno("RIOS");
		datosCertificables.setApellidoMaterno("SANCHEZ");
		datosCertificables.setFechaNacimiento("28/02/1965");
		datosCertificables.setEntidadNacimiento("TLAXCALA");
		datosCertificables.setCurp("RISG650228MTLSNB01");
		datosCertificables.setGenero("FEMENINO");
		datosTrabajador.setDatosCertificables(datosCertificables);
		
		DatosNoCertificables datosNoCertificables = new DatosNoCertificables();
		datosNoCertificables.setRfc("RISG650228MTL");
		datosNoCertificables.setClaveOcupacion("ocupacion");
		datosNoCertificables.setClaveGiro("giro");
		datosNoCertificables.setEstudios("estudios");
		datosTrabajador.setDatosNoCertificables(datosNoCertificables);
		
		EntradaModificacion datosModificacion = new EntradaModificacion();
		datosModificacion.setEntidadOrigen("538");
		datosModificacion.setTipoDeMovimiento("1");//checar Por metodo
		datosModificacion.setCurp("RISG650228MTLSNB01");
		datosModificacion.setNss("94098604922");
		datosModificacion.setFirmaAgente("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");
		datosModificacion.setFirmaTrabajador("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");
		
		DatosBaseCurp baseCurp = new DatosBaseCurp();
		baseCurp.setCurpNueva("RISG650228MTLSNB01");
		baseCurp.setRfc("RISG650228MTL");
		baseCurp.setApellidoPaterno("RIOS");
		baseCurp.setApellidoMaterno("SANCHEZ");
		baseCurp.setNombreTrabajador("GABRIELA");
		baseCurp.setFechaDeNacimiento("1965-02-28");
		baseCurp.setSexo("Femenino");
		baseCurp.setEntidadFederativaDeNacimiento("29 TLAXCALA");
		baseCurp.setNacionalidad("1 MEXICANA:MEXICO");
		baseCurp.setFolioDeLaSolicitud("1909060022");
		baseCurp.setOcupacionOProfesionTrabajador("62 TRABAJADORES DE APOYO EN ACTIVIDADES ADMINISTRATIVAS");
		baseCurp.setActividadOGiroNegocioTrabajador("12 ADMINISTRACION PUBLICA");
		baseCurp.setNivelDeEstudioTrabajador("05 CARRERA PROFESIONAL");
		baseCurp.setFlujoDeValidacion("2A");  //Checar por metodo
		baseCurp.setSelloVerificacionBiometrica("11111111111111");
		baseCurp.setSelloVoluntadTramite("99999999999999");
		baseCurp.setIndicadorDeDuplicidad("0");
		baseCurp.setIndicadorDeServicioBiometrico("0507");
		baseCurp.setCurpSolicitante("RISG650228MTLSNB01");
		baseCurp.setTipoSolicitante("01");
		datosModificacion.setDatosBaseCurp(baseCurp);
		
		DatosDomicilioParticularTrabajador datosDomicilioParticularTrabajador = new DatosDomicilioParticularTrabajador();
		datosDomicilioParticularTrabajador.setCalle("calle4");
		datosDomicilioParticularTrabajador.setNumeroExterior("121");
		datosDomicilioParticularTrabajador.setNumeroInterior("121111");
		datosDomicilioParticularTrabajador.setColonia("valle los reyes");
		datosDomicilioParticularTrabajador.setDelegacionOMunicipio("ALVARO OBREGON");
		datosDomicilioParticularTrabajador.setCodigoPostal("12345");
		datosDomicilioParticularTrabajador.setEntidadFederativa("DISTRITO FEDERAL");
		datosDomicilioParticularTrabajador.setPais("MEX MEXICO");
		datosDomicilioParticularTrabajador.setIndicadorDeTelefono1("000");
		datosDomicilioParticularTrabajador.setTelefono1("5667777777");
		datosDomicilioParticularTrabajador.setExtension1("123");
		datosDomicilioParticularTrabajador.setIndicadorDeTelefono2("000");
		datosDomicilioParticularTrabajador.setTelefono2("5677889900");
		datosDomicilioParticularTrabajador.setExtension2("321");
		datosDomicilioParticularTrabajador.setCorreoElectronicoDelTrabajador("chay@gmail.com");
		datosModificacion.setDatosDomicilioParticularTrabajador(datosDomicilioParticularTrabajador);
		
		DatosDomicilioLaboralTrabajador datosDomicilioLaboralTrabajador = new DatosDomicilioLaboralTrabajador();
		datosDomicilioLaboralTrabajador.setCalle("Calle9");
		datosDomicilioLaboralTrabajador.setNumeroExterior("123");
		datosDomicilioLaboralTrabajador.setNumeroInterior("456");
		datosDomicilioLaboralTrabajador.setColonia("Pinos");
		datosDomicilioLaboralTrabajador.setDelegacionOMunicipio("IZTACALCO");
		datosDomicilioLaboralTrabajador.setCodigoPostal("98765");
		datosDomicilioLaboralTrabajador.setEntidadFederativa("DISTRITO FEDERAL");
		datosDomicilioLaboralTrabajador.setPais("MEX MEXICO");
		datosModificacion.setDatosDomicilioLaboralTrabajador(datosDomicilioLaboralTrabajador);
		
		
		DatosReferenciasTrabajador datosReferenciasTrabajador = new DatosReferenciasTrabajador();
		datosReferenciasTrabajador.setApellidoPaternoDeReferencia1("Perez");
		datosReferenciasTrabajador.setApellidoMaternoDeReferencia1("Lirios");
		datosReferenciasTrabajador.setNombreDeReferencia1("Luisa");
		datosReferenciasTrabajador.setCurpDeReferencia1("FRTY890122HDFTJB78");
		datosReferenciasTrabajador.setTelefonoDeReferencia1("5666778800");
		datosReferenciasTrabajador.setParentescoORelacionDeReferencia1("16 MADRINA");
		
		datosReferenciasTrabajador.setApellidoPaternoDeReferencia2("Rojas");
		datosReferenciasTrabajador.setApellidoMaternoDeReferencia2("feriz");
		datosReferenciasTrabajador.setNombreDeReferencia2("Armando");
		datosReferenciasTrabajador.setCurpDeReferencia2("MAGO820808HBCRRS01");
		datosReferenciasTrabajador.setTelefonoDeReferencia2("5666778899");
		datosReferenciasTrabajador.setParentescoORelacionDeReferencia2("15 PADRINO");
		datosModificacion.setDatosReferenciasTrabajador(datosReferenciasTrabajador);
		
		
		ListaBeneficiariosTrabajador listaBeneficiariosTrabajador = new ListaBeneficiariosTrabajador();
		List<DatosBeneficiarioTrabajador> listabeneficiario = new ArrayList<DatosBeneficiarioTrabajador>();
		
		DatosBeneficiarioTrabajador beneficiario1 = new DatosBeneficiarioTrabajador();
		beneficiario1.setApellidoPaternoDeBeneficiario("Ruiz");
		beneficiario1.setApellidoMaternoDeBeneficiario("Garcia");
		beneficiario1.setCurpDeBeneficiario("PEHG590707MNTXRD15");
		beneficiario1.setNombreDeBeneficiario("Maria Luisa");
		beneficiario1.setParentescoORelacion("06 HERMANO(A)"); //Por Verificar Si es ASi
		beneficiario1.setPorcentajeDeBeneficiario("70");
		listabeneficiario.add(beneficiario1);
		DatosBeneficiarioTrabajador beneficiario2 = new DatosBeneficiarioTrabajador();
		beneficiario2.setApellidoPaternoDeBeneficiario("Perez");
		beneficiario2.setApellidoMaternoDeBeneficiario("Mendez");
		beneficiario2.setCurpDeBeneficiario("JIHO781213HDFMRC07");
		beneficiario2.setNombreDeBeneficiario("Rosa Isela");
		beneficiario2.setParentescoORelacion("03 HIJO(A)"); //Por Verificar Si es Asi
		beneficiario2.setPorcentajeDeBeneficiario("30");
		listabeneficiario.add(beneficiario2);
				
		listaBeneficiariosTrabajador.setBeneficiario(listabeneficiario);
		datosModificacion.setListaBeneficiariosTrabajador(listaBeneficiariosTrabajador);
		
		Folio folioPadre = new Folio();
		folioPadre.setChFolio("convertirFechaACadena");
		
		BanderaDatosModificadosCertificables banderaDatosModificadosCertificables = new BanderaDatosModificadosCertificables();
		banderaDatosModificadosCertificables.setModificadoCurp(true);
		banderaDatosModificadosCertificables.setModificadoRfc(true);
		banderaDatosModificadosCertificables.setModificadoApellidoPaterno(true);
		banderaDatosModificadosCertificables.setModificadoApellidoMaterno(true);
		banderaDatosModificadosCertificables.setModificadoNombre(true);
		banderaDatosModificadosCertificables.setModificadoFechaNacimiento(true);
		banderaDatosModificadosCertificables.setModificadoSexo(true);
		banderaDatosModificadosCertificables.setModificadoEntidadNacimiento(true);
		banderaDatosModificadosCertificables.setModificadoNacionalidad(true);
		banderaDatosModificadosCertificables.setModificacionDatosCertificables(true);
		banderaDatosModificadosCertificables.setFolioPadre(folioPadre);
		banderaDatosModificadosCertificables.setFolioSolicitud(folioPadre);
		
				
		//Ejemplo de entrada 29 TLAXCALA
		int index = datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento().indexOf(" ");
		String entidadFederativaNacimientoModificada  = datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento().substring(index++);
				
		//Ejemplo de entrada: 1 MEXICANA:MEXICO
		String nacionalidadModificada = "";
		String nacionalidadModificadaArreglo[] = datosModificacion.getDatosBaseCurp().getNacionalidad().split(":");
		if(nacionalidadModificadaArreglo!= null && nacionalidadModificadaArreglo.length==2){
			int i = nacionalidadModificadaArreglo[0].indexOf(" ");
			nacionalidadModificada= nacionalidadModificadaArreglo[0].substring(i++);
		}


		FlujosEntrada flujoEntrada = new FlujosEntrada();
		flujoEntrada.setMovimiento("1");
		flujoEntrada.setFlujoValidacion("2A");
		
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario("556");
		user.setApellidoPaterno("paterno");
		user.setApellidoMaterno("materno");
		user.setSoloNombre("nombre");
//		File rutaPdf = FileUtils.getFile("src", "test", "resources","538","rpmimmss.pdf");
//		ReflectionTestUtils.setField(serviceExpediente, "rutaPlantillaSolicitudModificacionDatos",rutaPdf.getPath());
		
		
		
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("rutaPdf");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("01/03/1996");
		Mockito.when(fechaUtils.convertirCadenaAFecha(Mockito.anyString(),Mockito.anyString())).thenReturn(new Date());
		Mockito.when(utileriaValidador.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("valor");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");
		serviceExpediente.generarSolicitudDatosPDFPeis(flujoEntrada,datosTrabajador, datosModificacion, banderaDatosModificadosCertificables,"01/03/1996", entidadFederativaNacimientoModificada, nacionalidadModificada,datosModificacion,user);
		
		banderaDatosModificadosCertificables.setModificadoCurp(false);
		banderaDatosModificadosCertificables.setModificadoRfc(false);
		banderaDatosModificadosCertificables.setModificadoApellidoPaterno(false);
		banderaDatosModificadosCertificables.setModificadoApellidoMaterno(false);
		banderaDatosModificadosCertificables.setModificadoNombre(false);
		banderaDatosModificadosCertificables.setModificadoFechaNacimiento(false);
		banderaDatosModificadosCertificables.setModificadoSexo(false);
		banderaDatosModificadosCertificables.setModificadoEntidadNacimiento(false);
		banderaDatosModificadosCertificables.setModificadoNacionalidad(false);
		banderaDatosModificadosCertificables.setModificacionDatosCertificables(false);
		
		datosCertificables.setNombre(null);
		datosCertificables.setApellidoPaterno(null);
		datosCertificables.setApellidoMaterno(null);
		datosCertificables.setFechaNacimiento(null);
		datosCertificables.setEntidadNacimiento(null);
		datosCertificables.setCurp(null);
		datosCertificables.setGenero(null);
		datosTrabajador.setDatosCertificables(datosCertificables);
		
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("rutaPdf");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("01/03/1996");
		Mockito.when(fechaUtils.convertirCadenaAFecha(Mockito.anyString(),Mockito.anyString())).thenReturn(new Date());
		Mockito.when(utileriaValidador.isEmpty(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("valor");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");
		serviceExpediente.generarSolicitudDatosPDFPeis(flujoEntrada,datosTrabajador, datosModificacion, banderaDatosModificadosCertificables,"01/03/1996", entidadFederativaNacimientoModificada, nacionalidadModificada,datosModificacion,user);
	}
	
	/**
	 * test solicitud banorte
	 * @throws DocumentException
	 * @throws IOException
	 */
	@Test
	public void testGenerarSolicitudDatosBanorte() throws DocumentException, IOException{ 
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setNss("09876543210");
		datosTrabajador.setNacionalidad("MEXICANA");
		datosTrabajador.setTipoSolicitante("01");
			
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setNombre("GABRIELA");
		datosCertificables.setApellidoPaterno("RIOS");
		datosCertificables.setApellidoMaterno("SANCHEZ");
		datosCertificables.setFechaNacimiento("28/02/1965");
		datosCertificables.setEntidadNacimiento("TLAXCALA");
		datosCertificables.setCurp("RISG650228MTLSNB01");
		datosCertificables.setGenero("FEMENINO");
		datosTrabajador.setDatosCertificables(datosCertificables);
		
		DatosNoCertificables datosNoCertificables = new DatosNoCertificables();
		datosNoCertificables.setRfc("RISG650228MTL");
		datosNoCertificables.setClaveOcupacion("ocupacion");
		datosNoCertificables.setClaveGiro("giro");
		datosNoCertificables.setEstudios("estudios");
		datosTrabajador.setDatosNoCertificables(datosNoCertificables);
		
		Domicilio particular = new Domicilio();
		particular.setCalle("calle");
		particular.setNoExterior("3");
		particular.setNoInterior("2");
		particular.setColonia("colonia");
		particular.setMunicipio("municipio");
		particular.setClaveMunicipio("claveMunicipio");
		particular.setCodigoPostal("codigoPostal");
		particular.setClaveEntidadFed("claveEntidadFed");
		particular.setEntidadFederativa("entidadFederativa");
		particular.setClavePais("clavePais");
		particular.setPais("pais");
		particular.setFechacontrol("fechaControl");
		
		
		Domicilio laboral = new Domicilio();
		laboral.setCalle("calle");
		laboral.setNoExterior("3");
		laboral.setNoInterior("2");
		laboral.setColonia("colonia");
		laboral.setMunicipio("municipio");
		laboral.setClaveMunicipio("claveMunicipio");
		laboral.setCodigoPostal("codigoPostal");
		laboral.setClaveEntidadFed("claveEntidadFed");
		laboral.setEntidadFederativa("entidadFederativa");
		laboral.setClavePais("clavePais");
		laboral.setPais("pais");
		laboral.setFechacontrol("fechaControl");
		
		Telefono telefonos = new Telefono();
		telefonos.setTelefonoFijo("telefonoFijo");
		telefonos.setCelular("celular");
		telefonos.setTelefonoLaboral("telefonoLaboral");
		telefonos.setExtension("extension");
		telefonos.setIndicadorDeTelefono1("indicadorDeTelefono1");
		telefonos.setIndicadorDeTelefono2("indicadorDeTelefono2");
		telefonos.setExtension2("extension2");

		Referencia referencia1 = new Referencia();
		referencia1.setCurp("curp");
		referencia1.setNombre("nombre");
		referencia1.setApellidoPaterno("apellidoPaterno");
		referencia1.setApellidoMaterno("apellidoMaterno");
		referencia1.setTelefono("telefono");
		referencia1.setClaveParentesco("claveParentesco");
		referencia1.setParentesco("parentesco");
		referencia1.setFechaControl("fechaControl");
		
		Referencia referencia2 = new Referencia();
		referencia2.setCurp("curp2");
		referencia2.setNombre("nombre2");
		referencia2.setApellidoPaterno("apellidoPaterno2");
		referencia2.setApellidoMaterno("apellidoMaterno2");
		referencia2.setTelefono("telefono2");
		referencia2.setClaveParentesco("claveParentesco2");
		referencia2.setParentesco("parentesco2");
		referencia2.setFechaControl("fechaControl2");
		
		List<Beneficiario> listaBeneficiarioBd = new ArrayList<>();
		Beneficiario beneficiario = new Beneficiario();
		beneficiario.setApellidoPaterno("Ruiz");
		beneficiario.setApellidoMaterno("Garcia");
		beneficiario.setCurp("PEHG590707MNTXRD15");
		beneficiario.setNombre("Maria Luisa");
		beneficiario.setClaveParentesco("06 HERMANO(A)"); //Por Verificar Si es ASi
		beneficiario.setPorcentaje("70");
		listaBeneficiarioBd.add(beneficiario);
		
		Beneficiario beneficiarioB2 = new Beneficiario();
		beneficiarioB2.setApellidoPaterno("Perez");
		beneficiarioB2.setApellidoMaterno("Mendez");
		beneficiarioB2.setCurp("JIHO781213HDFMRC07");
		beneficiarioB2.setNombre("Rosa Isela");
		beneficiarioB2.setClaveParentesco("03 HIJO(A)"); //Por Verificar Si es ASi
		beneficiarioB2.setPorcentaje("30");
		listaBeneficiarioBd.add(beneficiarioB2);
		
		List<Referencia> listaRef = new ArrayList<>();
		listaRef.add(referencia1);
		listaRef.add(referencia2);
		DatosComplementarios complementarios = new DatosComplementarios();
		complementarios.setParticular(particular);
		complementarios.setLaboral(laboral);
		complementarios.setListaReferencias(listaRef);
		complementarios.setTelefonos(telefonos);
		complementarios.setCorreoElectronico("correo");
		complementarios.setListaBeneficiario(listaBeneficiarioBd);
		datosTrabajador.setDatosComplementarios(complementarios);
		
		EntradaModificacion datosModificacion = new EntradaModificacion();
		datosModificacion.setEntidadOrigen("538");
		datosModificacion.setTipoDeMovimiento("1");//checar Por metodo
		datosModificacion.setCurp("RISG650228MTLSNB01");
		datosModificacion.setNss("94098604922");
		datosModificacion.setFirmaAgente("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");
		datosModificacion.setFirmaTrabajador("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");
		
		DatosBaseCurp baseCurp = new DatosBaseCurp();
		baseCurp.setCurpNueva("RISG650228MTLSNB01");
		baseCurp.setRfc("RISG650228MTL");
		baseCurp.setApellidoPaterno("RIOS");
		baseCurp.setApellidoMaterno("SANCHEZ");
		baseCurp.setNombreTrabajador("GABRIELA");
		baseCurp.setFechaDeNacimiento("1965-02-28");
		baseCurp.setSexo("Femenino");
		baseCurp.setEntidadFederativaDeNacimiento("29 TLAXCALA");
		baseCurp.setNacionalidad("1 MEXICANA:MEXICO");
		baseCurp.setFolioDeLaSolicitud("1909060022");
		baseCurp.setOcupacionOProfesionTrabajador("62 TRABAJADORES DE APOYO EN ACTIVIDADES ADMINISTRATIVAS");
		baseCurp.setActividadOGiroNegocioTrabajador("12 ADMINISTRACION PUBLICA");
		baseCurp.setNivelDeEstudioTrabajador("05 CARRERA PROFESIONAL");
		baseCurp.setFlujoDeValidacion("2A");  //Checar por metodo
		baseCurp.setSelloVerificacionBiometrica("11111111111111");
		baseCurp.setSelloVoluntadTramite("99999999999999");
		baseCurp.setIndicadorDeDuplicidad("0");
		baseCurp.setIndicadorDeServicioBiometrico("0507");
		baseCurp.setCurpSolicitante("RISG650228MTLSNB01");
		baseCurp.setTipoSolicitante("01");
		datosModificacion.setDatosBaseCurp(baseCurp);
		
		DatosDomicilioParticularTrabajador datosDomicilioParticularTrabajador = new DatosDomicilioParticularTrabajador();
		datosDomicilioParticularTrabajador.setCalle("calle4");
		datosDomicilioParticularTrabajador.setNumeroExterior("121");
		datosDomicilioParticularTrabajador.setNumeroInterior("121111");
		datosDomicilioParticularTrabajador.setColonia("valle los reyes");
		datosDomicilioParticularTrabajador.setDelegacionOMunicipio("ALVARO OBREGON");
		datosDomicilioParticularTrabajador.setCodigoPostal("12345");
		datosDomicilioParticularTrabajador.setEntidadFederativa("DISTRITO FEDERAL");
		datosDomicilioParticularTrabajador.setPais("MEX MEXICO");
		datosDomicilioParticularTrabajador.setIndicadorDeTelefono1("000");
		datosDomicilioParticularTrabajador.setTelefono1("5667777777");
		datosDomicilioParticularTrabajador.setExtension1("123");
		datosDomicilioParticularTrabajador.setIndicadorDeTelefono2("000");
		datosDomicilioParticularTrabajador.setTelefono2("5677889900");
		datosDomicilioParticularTrabajador.setExtension2("321");
		datosDomicilioParticularTrabajador.setCorreoElectronicoDelTrabajador("chay@gmail.com");
		datosModificacion.setDatosDomicilioParticularTrabajador(datosDomicilioParticularTrabajador);
		
		DatosDomicilioLaboralTrabajador datosDomicilioLaboralTrabajador = new DatosDomicilioLaboralTrabajador();
		datosDomicilioLaboralTrabajador.setCalle("Calle9");
		datosDomicilioLaboralTrabajador.setNumeroExterior("123");
		datosDomicilioLaboralTrabajador.setNumeroInterior("456");
		datosDomicilioLaboralTrabajador.setColonia("Pinos");
		datosDomicilioLaboralTrabajador.setDelegacionOMunicipio("IZTACALCO");
		datosDomicilioLaboralTrabajador.setCodigoPostal("98765");
		datosDomicilioLaboralTrabajador.setEntidadFederativa("DISTRITO FEDERAL");
		datosDomicilioLaboralTrabajador.setPais("MEX MEXICO");
		datosModificacion.setDatosDomicilioLaboralTrabajador(datosDomicilioLaboralTrabajador);
		
		
		DatosReferenciasTrabajador datosReferenciasTrabajador = new DatosReferenciasTrabajador();
		datosReferenciasTrabajador.setApellidoPaternoDeReferencia1("Perez");
		datosReferenciasTrabajador.setApellidoMaternoDeReferencia1("Lirios");
		datosReferenciasTrabajador.setNombreDeReferencia1("Luisa");
		datosReferenciasTrabajador.setCurpDeReferencia1("FRTY890122HDFTJB78");
		datosReferenciasTrabajador.setTelefonoDeReferencia1("5666778800");
		datosReferenciasTrabajador.setParentescoORelacionDeReferencia1("16 MADRINA");
		
		datosReferenciasTrabajador.setApellidoPaternoDeReferencia2("Rojas");
		datosReferenciasTrabajador.setApellidoMaternoDeReferencia2("feriz");
		datosReferenciasTrabajador.setNombreDeReferencia2("Armando");
		datosReferenciasTrabajador.setCurpDeReferencia2("MAGO820808HBCRRS01");
		datosReferenciasTrabajador.setTelefonoDeReferencia2("5666778899");
		datosReferenciasTrabajador.setParentescoORelacionDeReferencia2("15 PADRINO");
		datosModificacion.setDatosReferenciasTrabajador(datosReferenciasTrabajador);
		
		
		ListaBeneficiariosTrabajador listaBeneficiariosTrabajador = new ListaBeneficiariosTrabajador();
		List<DatosBeneficiarioTrabajador> listabeneficiario = new ArrayList<>();
		
		DatosBeneficiarioTrabajador beneficiario1 = new DatosBeneficiarioTrabajador();
		beneficiario1.setApellidoPaternoDeBeneficiario("Ruiz");
		beneficiario1.setApellidoMaternoDeBeneficiario("Garcia");
		beneficiario1.setCurpDeBeneficiario("PEHG590707MNTXRD15");
		beneficiario1.setNombreDeBeneficiario("Maria Luisa");
		beneficiario1.setParentescoORelacion("06 HERMANO(A)"); //Por Verificar Si es ASi
		beneficiario1.setPorcentajeDeBeneficiario("70");
		listabeneficiario.add(beneficiario1);
		DatosBeneficiarioTrabajador beneficiario2 = new DatosBeneficiarioTrabajador();
		beneficiario2.setApellidoPaternoDeBeneficiario("Perez");
		beneficiario2.setApellidoMaternoDeBeneficiario("Mendez");
		beneficiario2.setCurpDeBeneficiario("JIHO781213HDFMRC07");
		beneficiario2.setNombreDeBeneficiario("Rosa Isela");
		beneficiario2.setParentescoORelacion("03 HIJO(A)"); //Por Verificar Si es Asi
		beneficiario2.setPorcentajeDeBeneficiario("30");
		listabeneficiario.add(beneficiario2);
				
		listaBeneficiariosTrabajador.setBeneficiario(listabeneficiario);
		datosModificacion.setListaBeneficiariosTrabajador(listaBeneficiariosTrabajador);
		
		Folio folioPadre = new Folio();
		folioPadre.setChFolio("convertirFechaACadena");
		
		BanderaDatosModificadosCertificables banderaDatosModificadosCertificables = new BanderaDatosModificadosCertificables();
		banderaDatosModificadosCertificables.setModificadoCurp(true);
		banderaDatosModificadosCertificables.setModificadoRfc(true);
		banderaDatosModificadosCertificables.setModificadoApellidoPaterno(true);
		banderaDatosModificadosCertificables.setModificadoApellidoMaterno(true);
		banderaDatosModificadosCertificables.setModificadoNombre(true);
		banderaDatosModificadosCertificables.setModificadoFechaNacimiento(true);
		banderaDatosModificadosCertificables.setModificadoSexo(true);
		banderaDatosModificadosCertificables.setModificadoEntidadNacimiento(true);
		banderaDatosModificadosCertificables.setModificadoNacionalidad(true);
		banderaDatosModificadosCertificables.setModificacionDatosCertificables(true);
		banderaDatosModificadosCertificables.setFolioPadre(folioPadre);
		banderaDatosModificadosCertificables.setFolioSolicitud(folioPadre);
		
				
		//Ejemplo de entrada 29 TLAXCALA
		int index = datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento().indexOf(" ");
		String entidadFederativaNacimientoModificada  = datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento().substring(index++);
				
		//Ejemplo de entrada: 1 MEXICANA:MEXICO
		String nacionalidadModificada = "";
		String nacionalidadModificadaArreglo[] = datosModificacion.getDatosBaseCurp().getNacionalidad().split(":");
		if(nacionalidadModificadaArreglo!= null && nacionalidadModificadaArreglo.length==2){
			int i = nacionalidadModificadaArreglo[0].indexOf(" ");
			nacionalidadModificada= nacionalidadModificadaArreglo[0].substring(i++);
		}


		FlujosEntrada flujoEntrada = new FlujosEntrada();
		flujoEntrada.setMovimiento("1");
		flujoEntrada.setFlujoValidacion("2A");
		
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario("556");
		user.setApellidoPaterno("paterno");
		user.setApellidoMaterno("materno");
		user.setSoloNombre("nombre");		
		
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaValidador.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("rutaPdf");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("07/02/2020");
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("valor");
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("ejemplo");
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("texto");
		Mockito.when(fechaUtils.convertirCadenaAFecha(Mockito.anyString(), Mockito.anyString())).thenReturn(new Date());
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("20201014");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");
		serviceExpediente.generarSolicitudDatosPDFBanorte(datosTrabajador, datosModificacion, banderaDatosModificadosCertificables,"01/03/1996", entidadFederativaNacimientoModificada, nacionalidadModificada,datosModificacion,user);
	}
	
	/**
	 * test captura archivos
	 */
	@Test(expected=GenericException.class)
	public void testCapturarArchivos() {
		String ruta = "ruta";
		Archivos archivos =new Archivos();
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\"resultadoOperacion\":\"01\",\"motivoRechazo\":null}" , HttpStatus.ACCEPTED);
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		serviceExpediente.capturarArchivos(archivos, "ruta");
		
		
		ResponseEntity<String> respuestaNotificacion2 = new ResponseEntity<>(" " , HttpStatus.ACCEPTED);
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion2);
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.TRUE);
		serviceExpediente.capturarArchivos(archivos, "ruta");
		
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenThrow(new RuntimeException());
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn(ruta);
		serviceExpediente.capturarArchivos(archivos, ruta);
	}
	
	/**
	 * test recupera firma proceso
	 * @throws IOException
	 */
	@Test(expected=GenericException.class)
	public void testRecuperarFirmasProceso() throws IOException {
		DetalleRecepcionImagenes detalle1 = new DetalleRecepcionImagenes();
		detalle1.setTipoDocumentoDigital("40");
		detalle1.setTipoImagen(3);
		detalle1.setRuta("ruta");
		detalle1.setMascara("mascara");
		DetalleRecepcionImagenes detalle2 = new DetalleRecepcionImagenes();
		detalle2.setTipoDocumentoDigital("40");
		detalle2.setRuta("ruta");
		detalle2.setTipoImagen(4);
		detalle2.setMascara("mascara");

		List<DetalleRecepcionImagenes> listaDetalle = new ArrayList<>();
		listaDetalle.add(detalle1);
		listaDetalle.add(detalle2);

		RecepcionImagenes recepcionImagenes =new RecepcionImagenes();
		recepcionImagenes.setDetalleRecepcionImagen(listaDetalle);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("cadena");
		Mockito.when(lectorUtils.obtenerContenidoArchivo(Mockito.anyString())).thenReturn("firma");
		serviceExpediente.recuperarFirmasProceso("folioPadre", recepcionImagenes);
		
		
		DetalleRecepcionImagenes detalle3 = new DetalleRecepcionImagenes();
		detalle3.setTipoDocumentoDigital("29");
		detalle3.setTipoImagen(2);
		detalle3.setRuta("ruta");
		detalle3.setMascara("mascara");

		List<DetalleRecepcionImagenes> listaDetalle2 = new ArrayList<>();
		listaDetalle2.add(detalle3);

		RecepcionImagenes recepcionImagenes2 =new RecepcionImagenes();
		recepcionImagenes2.setDetalleRecepcionImagen(listaDetalle2);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("cadena");
		Mockito.when(lectorUtils.obtenerContenidoArchivo(Mockito.anyString())).thenReturn("firma");
		serviceExpediente.recuperarFirmasProceso("folioPadre", recepcionImagenes2);
	}
	
	/**
	 * test envia solicitud banorte
	 * @throws IOException
	 */
	@Test
	public void testEnviarSolicitudBanorte() throws IOException {
		EnvioArchivos datosRecepcion = new EnvioArchivos();
		datosRecepcion.setClaveAfore("afore");
		datosRecepcion.setProceso("proceso");
		datosRecepcion.setCurpTrabajador("curp");
		datosRecepcion.setTipoTrabajador("01");
		datosRecepcion.setFolioIdentificacion("folio");
		ImagenDocumento imagenD = new ImagenDocumento();
		imagenD.setNombreDocumento("nombreDocumento.txt");
		imagenD.setClaveTipoDocumento("clave");
		imagenD.setContenidoDocumento("contenido");
		List<ImagenDocumento> imagenes = new ArrayList<>();
		imagenes.add(imagenD);
		ImagenWrapper objetoImagen = new ImagenWrapper();
		objetoImagen.setImagenes(imagenes);
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\"resultadoOperacion\":\"01\",\"motivoRechazo\":null}" , HttpStatus.ACCEPTED);

		Mockito.when(servicioArchivos.verificarRuta(Mockito.anyString(), Mockito.anyString())).thenReturn("ruta");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("19960705");
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaValidador.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(servicioArchivos.generarZip(Mockito.anyString())).thenReturn("dmFsb3I=");
		Mockito.when(servicioArchivos.obtenerArchivoZipExpediente(any(Archivos.class), Mockito.anyString())).thenReturn("nombre");
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		serviceExpediente.enviarSolicitudBanorte(datosRecepcion, "ruta");
	}
	
	/**
	 * test envia solicitud banorte excepcion file
	 * @throws IOException
	 */
	@Test
	public void testEnviarSolicitudBanorteExcepcionFile() throws IOException {
		EnvioArchivos datosRecepcion = new EnvioArchivos();
		datosRecepcion.setClaveAfore("afore");
		datosRecepcion.setProceso("proceso");
		datosRecepcion.setCurpTrabajador("curp");
		datosRecepcion.setTipoTrabajador("01");
		datosRecepcion.setFolioIdentificacion("folio");
		ImagenDocumento imagenD = new ImagenDocumento();
		imagenD.setNombreDocumento("nombreDocumento.txt");
		imagenD.setClaveTipoDocumento("clave");
		imagenD.setContenidoDocumento("contenido");
		List<ImagenDocumento> imagenes = new ArrayList<>();
		imagenes.add(imagenD);
		ImagenWrapper objetoImagen = new ImagenWrapper();
		objetoImagen.setImagenes(imagenes);

		Mockito.when(servicioArchivos.verificarRuta(Mockito.anyString(), Mockito.anyString())).thenReturn("ruta");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("19960705");
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaValidador.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(servicioArchivos.generarZip(Mockito.anyString())).thenThrow(new FileNotFoundException());
		serviceExpediente.enviarSolicitudBanorte(datosRecepcion, "ruta");
	}
	
	/**
	 * test envia solicitud banorte exception
	 * @throws IOException
	 */
	@Test
	public void testEnviarSolicitudBanorteExcepcionException() throws IOException {
		EnvioArchivos datosRecepcion = new EnvioArchivos();
		datosRecepcion.setClaveAfore("afore");
		datosRecepcion.setProceso("proceso");
		datosRecepcion.setCurpTrabajador("curp");
		datosRecepcion.setTipoTrabajador("01");
		datosRecepcion.setFolioIdentificacion("folio");
		ImagenDocumento imagenD = new ImagenDocumento();
		imagenD.setNombreDocumento("nombreDocumento.txt");
		imagenD.setClaveTipoDocumento("clave");
		imagenD.setContenidoDocumento("contenido");
		List<ImagenDocumento> imagenes = new ArrayList<>();
		imagenes.add(imagenD);
		ImagenWrapper objetoImagen = new ImagenWrapper();
		objetoImagen.setImagenes(imagenes);

		Mockito.when(servicioArchivos.verificarRuta(Mockito.anyString(), Mockito.anyString())).thenReturn("ruta");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("19960705");
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaValidador.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(servicioArchivos.generarZip(Mockito.anyString())).thenThrow(new RuntimeException());
		serviceExpediente.enviarSolicitudBanorte(datosRecepcion, "ruta");
	}
	
	/**
	 * test enviar solicitud banorte generic exception
	 * @throws IOException
	 */
	@Test
	public void testEnviarSolicitudBanorteGenericException() throws IOException {
		EnvioArchivos datosRecepcion = new EnvioArchivos();
		datosRecepcion.setClaveAfore("afore");
		datosRecepcion.setProceso("proceso");
		datosRecepcion.setCurpTrabajador("curp");
		datosRecepcion.setTipoTrabajador("01");
		datosRecepcion.setFolioIdentificacion("folio");
		ImagenDocumento imagenD = new ImagenDocumento();
		imagenD.setNombreDocumento("nombreDocumento.txt");
		imagenD.setClaveTipoDocumento("clave");
		imagenD.setContenidoDocumento("contenido");
		List<ImagenDocumento> imagenes = new ArrayList<>();
		imagenes.add(imagenD);
		ImagenWrapper objetoImagen = new ImagenWrapper();
		objetoImagen.setImagenes(imagenes);
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\"resultadoOperacion\":\"01\",\"motivoRechazo\":null}" , HttpStatus.ACCEPTED);

		Mockito.when(servicioArchivos.verificarRuta(Mockito.anyString(), Mockito.anyString())).thenReturn("ruta");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("19960705");
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaValidador.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(servicioArchivos.generarZip(Mockito.anyString())).thenReturn("dmFsb3I=");
		Mockito.when(servicioArchivos.obtenerArchivoZipExpediente(any(Archivos.class), Mockito.anyString())).thenReturn("nombre");
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(servicioArchivos.validarRespuestaRecepcionArchivos(any(RespuestaAlta.class), Mockito.anyString())).thenThrow(new GenericException(GenericErrorEnum.EXCEPTION_GENERICA));
		serviceExpediente.enviarSolicitudBanorte(datosRecepcion, "ruta");
	}
	
	/**
	 * test obtener proceso expedeinte servicio
	 */
	@Test
	public void testObtenerProcesoExpedienteServicio() {
		serviceExpediente.obtenerProcesoExpedienteServicio("01");
		serviceExpediente.obtenerProcesoExpedienteServicio("02");
		serviceExpediente.obtenerProcesoExpedienteServicio("03");
		serviceExpediente.obtenerProcesoExpedienteServicio("04");
		serviceExpediente.obtenerProcesoExpedienteServicio("10");

	}
	
	/**
	 * test genera folio solicitud
	 */
	@Test
	public void testGenerarFolioSolicitud() {
		Folio folio = new Folio();
		folio.setChFolio("00000000000000000000");
		serviceExpediente.generarFolioSolicitud(folio);
	}
	
	/**
	 * test obtener valor parametro
	 */
	@Test
	public void testObtenerValorParametro(){
		List<Parametro> listaParametro = new ArrayList<>();
		Parametro parametro = new Parametro();
		listaParametro.add(parametro);
		Mockito.when(servicioCatalogo.obtenerParametroDdbpose(Mockito.anyString())).thenReturn(listaParametro);
		Mockito.when(utileriaValidador.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		serviceExpediente.obtenerValorParametro("parametro");
	}
	
	/**
	 * test valida estatus expediente
	 */
	@Test
	public void testValidarEstatusExpediente() {
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setCurpNueva("curp");
		EntradaModificacion entradaModificacion = new EntradaModificacion();
		entradaModificacion.setDatosBaseCurp(datosBase);
		
		Mockito.when(expedienteService.consultarExpedienteProceso(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.FALSE);
		Mockito.when(expedienteService.consultarEstatusExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(new ArchivoRecibido());
		serviceExpediente.validarEstatusExpediente(entradaModificacion, "proceso", "afore", "folio");

	
		Mockito.when(expedienteService.consultarExpedienteProceso(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(new ExpedienteDetail());
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		Mockito.when(expedienteService.consultarEstatusExpediente(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		serviceExpediente.validarEstatusExpediente(entradaModificacion, "proceso", "afore", "folio");
	}
	
	/**
	 * test validar igualdad rfc
	 */
	@Test
	public void testValidarIgualdadRfc() {
		DatosBaseCurp datosBase = new DatosBaseCurp();
		datosBase.setRfc("RFC1234567897");
		DatosNoCertificables noCertificables = new DatosNoCertificables();
		noCertificables.setRfc("RFC1234567897");
		DatosTrabajador trabajador = new DatosTrabajador();
		trabajador.setDatosNoCertificables(noCertificables);
		EntradaModificacion objetoModificacion = new EntradaModificacion();
		objetoModificacion.setDatosBaseCurp(datosBase);
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("RFC1234567897");
		serviceExpediente.validarIgualdadRfc(trabajador, objetoModificacion);
		
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("RFC1234567897","RFC1234567898");
		serviceExpediente.validarIgualdadRfc(trabajador, objetoModificacion);
		
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("RFC1234567897","RFC123456789");
		serviceExpediente.validarIgualdadRfc(trabajador, objetoModificacion);
	}
	
	/**
	 * test consulta sellos solicitud
	 */
	@Test
	public void testConsultaSelloSolicitud() {
		Sello sello = new Sello();
		sello.setId(1L);
		UsuarioLogin user = new UsuarioLogin();
		user.setCurpAgente("curp");
		user.setAforeUsuario("aafore");
		VerificacionSello verificacion = new VerificacionSello();
		verificacion.setSello(sello);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.FALSE);
		Mockito.when(consultaSelloService.consultarSelloFlujoModificacion(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(verificacion);
		serviceExpediente.consultaSelloSolicitud(user, "curp", "01");
		
		verificacion.setSello(null);
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.FALSE,Boolean.TRUE);
		Mockito.when(consultaSelloService.consultarSelloFlujoModificacion(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(verificacion);
		serviceExpediente.consultaSelloSolicitud(user, "curp", "02");
		
		Mockito.when(utileriaValidador.validarObjetoNulo(Mockito.any())).thenReturn(Boolean.TRUE,Boolean.TRUE);
		Mockito.when(consultaSelloService.consultarSelloFlujoModificacion(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(null);
		serviceExpediente.consultaSelloSolicitud(user, "curp", "02");
	}
	
	/**
	 * test enviar archivos
	 * @throws IOException
	 */
	@Test
	public void testEnviarArchivos() throws IOException {
		byte[] arreglo = null;
		MultipartFile file = new MockMultipartFile("nombre.jpg","nombre.jpg","nombre.jpg",arreglo);
		Map<String, MultipartFile> multipart = new HashMap<>();
		multipart.put("01", file);
		
		Map<String, Map<String, MultipartFile>> arregloArchivos = new HashMap<>();
		arregloArchivos.put("01", multipart);
		
		EnvioArchivos datosRecepcion = new EnvioArchivos();		
		datosRecepcion.setClaveAfore("afore");
		datosRecepcion.setProceso("proceso");
		datosRecepcion.setCurpTrabajador("curpT");
		datosRecepcion.setTipoTrabajador("1");
		datosRecepcion.setFolioIdentificacion("folio");
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\"resultadoOperacion\":\"01\",\"motivoRechazo\":null}" , HttpStatus.ACCEPTED);

		
		Mockito.when(servicioArchivos.verificarRuta(Mockito.anyString(), Mockito.anyString())).thenReturn("ruta");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("fecha");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("nombre.pdf");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("nombre");
		Mockito.when(servicioArchivos.generarZip(Mockito.anyString())).thenReturn("zip");
		Mockito.when(servicioArchivos.obtenerArchivoZipExpediente(any(Archivos.class), Mockito.anyString())).thenReturn("nombre");
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(servicioArchivos.validarRespuestaRecepcionArchivos(any(RespuestaAlta.class), Mockito.anyString())).thenReturn(new RespuestaServicio());
		serviceExpediente.enviarArchivos(arregloArchivos, "solicitud", datosRecepcion,1L);
	}
	
	/**
	 * test enviar archivos file exception
	 * @throws IOException
	 */
	@Test
	public void testEnviarArchivosFileException() throws IOException {
		byte[] arreglo = null;
		MultipartFile file = new MockMultipartFile("nombre.jpg","nombre.jpg","nombre.jpg",arreglo);
		Map<String, MultipartFile> multipart = new HashMap<>();
		multipart.put("01", file);
		
		Map<String, Map<String, MultipartFile>> arregloArchivos = new HashMap<>();
		arregloArchivos.put("01", multipart);
		
		EnvioArchivos datosRecepcion = new EnvioArchivos();		
		datosRecepcion.setClaveAfore("afore");
		datosRecepcion.setProceso("proceso");
		datosRecepcion.setCurpTrabajador("curpT");
		datosRecepcion.setTipoTrabajador("1");
		datosRecepcion.setFolioIdentificacion("folio");
		
		
		Mockito.when(servicioArchivos.verificarRuta(Mockito.anyString(), Mockito.anyString())).thenReturn("ruta");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("fecha");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("nombre.pdf");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("nombre");
		Mockito.when(servicioArchivos.generarZip(Mockito.anyString())).thenThrow(new FileNotFoundException());
		Mockito.doNothing().when(servicioFolio).cerrarFolio(Mockito.anyLong(), Mockito.any(Integer.class));
		serviceExpediente.enviarArchivos(arregloArchivos, "solicitud", datosRecepcion,1L);
	}
	
	/**
	 * test enviar archivo exception
	 * @throws IOException
	 */
	@Test
	public void testEnviarArchivoException() throws IOException {
		byte[] arreglo = null;
		MultipartFile file = new MockMultipartFile("nombre.jpg","nombre.jpg","nombre.jpg",arreglo);
		Map<String, MultipartFile> multipart = new HashMap<>();
		multipart.put("01", file);
		
		Map<String, Map<String, MultipartFile>> arregloArchivos = new HashMap<>();
		arregloArchivos.put("01", multipart);
		
		EnvioArchivos datosRecepcion = new EnvioArchivos();		
		datosRecepcion.setClaveAfore("afore");
		datosRecepcion.setProceso("proceso");
		datosRecepcion.setCurpTrabajador("curpT");
		datosRecepcion.setTipoTrabajador("1");
		datosRecepcion.setFolioIdentificacion("folio");

		
		Mockito.when(servicioArchivos.verificarRuta(Mockito.anyString(), Mockito.anyString())).thenReturn("ruta");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("fecha");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("nombre.pdf");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("nombre");
		Mockito.when(servicioArchivos.generarZip(Mockito.anyString())).thenThrow(new RuntimeException());
		Mockito.doNothing().when(servicioFolio).cerrarFolio(Mockito.anyLong(), Mockito.any(Integer.class));
		serviceExpediente.enviarArchivos(arregloArchivos, "solicitud", datosRecepcion,1L);
		
	}
	
	/**
	 * test enviar archivo generic exception
	 * @throws IOException
	 */
	@Test
	public void testEnviarArchivoGenericException() throws IOException {
		byte[] arreglo = null;
		MultipartFile file = new MockMultipartFile("nombre.jpg","nombre.jpg","nombre.jpg",arreglo);
		Map<String, MultipartFile> multipart = new HashMap<>();
		multipart.put("01", file);
		
		Map<String, Map<String, MultipartFile>> arregloArchivos = new HashMap<>();
		arregloArchivos.put("01", multipart);
		
		EnvioArchivos datosRecepcion = new EnvioArchivos();		
		datosRecepcion.setClaveAfore("afore");
		datosRecepcion.setProceso("proceso");
		datosRecepcion.setCurpTrabajador("curpT");
		datosRecepcion.setTipoTrabajador("1");
		datosRecepcion.setFolioIdentificacion("folio");
		ResponseEntity<String> respuestaNotificacion = new ResponseEntity<>("{\"resultadoOperacion\":\"01\",\"motivoRechazo\":null}" , HttpStatus.ACCEPTED);

		
		Mockito.when(servicioArchivos.verificarRuta(Mockito.anyString(), Mockito.anyString())).thenReturn("ruta");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("fecha");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("nombre.pdf");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("nombre");
		Mockito.when(servicioArchivos.generarZip(Mockito.anyString())).thenReturn("zip");
		Mockito.when(servicioArchivos.obtenerArchivoZipExpediente(any(Archivos.class), Mockito.anyString())).thenReturn("nombre");
		Mockito.when(servicioCliente.exchange(Mockito.anyString(), any(HttpMethod.class), any(HttpEntity.class),  Mockito.eq(String.class))).thenReturn(respuestaNotificacion);
		Mockito.when(utileriaValidador.validarVacio(Mockito.anyString())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(servicioArchivos.validarRespuestaRecepcionArchivos(any(RespuestaAlta.class), Mockito.anyString())).thenThrow(new GenericException(GenericErrorEnum.EXCEPTION_GENERICA));
		serviceExpediente.enviarArchivos(arregloArchivos, "solicitud", datosRecepcion,1L);

	}
	
	
	
	
	/**
	 * test solicitud banorte
	 * @throws DocumentException
	 * @throws IOException
	 */
	@Test
	public void testGenerarSolicitudCoppel() throws DocumentException, IOException{ 
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setNss("09876543210");
		datosTrabajador.setNacionalidad("MEXICANA");
		datosTrabajador.setTipoSolicitante("01");
		datosTrabajador.setClaveAfore("568");
			
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setNombre("GABRIELA");
		datosCertificables.setApellidoPaterno("RIOS");
		datosCertificables.setApellidoMaterno("SANCHEZ");
		datosCertificables.setFechaNacimiento("28/02/1965");
		datosCertificables.setEntidadNacimiento("TLAXCALA");
		datosCertificables.setCurp("RISG650228MTLSNB01");
		datosCertificables.setGenero("FEMENINO");
		datosTrabajador.setDatosCertificables(datosCertificables);
		
		DatosNoCertificables datosNoCertificables = new DatosNoCertificables();
		datosNoCertificables.setRfc("RISG650228MTL");
		datosNoCertificables.setClaveOcupacion("ocupacion");
		datosNoCertificables.setClaveGiro("giro");
		datosNoCertificables.setEstudios("estudios");
		datosTrabajador.setDatosNoCertificables(datosNoCertificables);
		
		Domicilio particular = new Domicilio();
		particular.setCalle("calle");
		particular.setNoExterior("3");
		particular.setNoInterior("2");
		particular.setColonia("colonia");
		particular.setMunicipio("municipio");
		particular.setClaveMunicipio("claveMunicipio");
		particular.setCodigoPostal("codigoPostal");
		particular.setClaveEntidadFed("claveEntidadFed");
		particular.setEntidadFederativa("entidadFederativa");
		particular.setClavePais("clavePais");
		particular.setPais("pais");
		particular.setFechacontrol("fechaControl");
		
		
		Domicilio laboral = new Domicilio();
		laboral.setCalle("calle");
		laboral.setNoExterior("3");
		laboral.setNoInterior("2");
		laboral.setColonia("colonia");
		laboral.setMunicipio("municipio");
		laboral.setClaveMunicipio("claveMunicipio");
		laboral.setCodigoPostal("codigoPostal");
		laboral.setClaveEntidadFed("claveEntidadFed");
		laboral.setEntidadFederativa("entidadFederativa");
		laboral.setClavePais("clavePais");
		laboral.setPais("pais");
		laboral.setFechacontrol("fechaControl");
		
		Telefono telefonos = new Telefono();
		telefonos.setTelefonoFijo("telefonoFijo");
		telefonos.setCelular("celular");
		telefonos.setTelefonoLaboral("telefonoLaboral");
		telefonos.setExtension("extension");
		telefonos.setIndicadorDeTelefono1("indicadorDeTelefono1");
		telefonos.setIndicadorDeTelefono2("indicadorDeTelefono2");
		telefonos.setExtension2("extension2");

		Referencia referencia1 = new Referencia();
		referencia1.setCurp("curp");
		referencia1.setNombre("nombre");
		referencia1.setApellidoPaterno("apellidoPaterno");
		referencia1.setApellidoMaterno("apellidoMaterno");
		referencia1.setTelefono("telefono");
		referencia1.setClaveParentesco("claveParentesco");
		referencia1.setParentesco("parentesco");
		referencia1.setFechaControl("fechaControl");
		
		Beneficiario beneficiario1 = new Beneficiario();
		beneficiario1.setCurp("curp");
		beneficiario1.setNombre("nombre");
		beneficiario1.setApellidoPaterno("paterno");
		beneficiario1.setApellidoMaterno("materno");
		beneficiario1.setClaveParentesco("19");
		beneficiario1.setParentesco("CONOCIDO");
		beneficiario1.setPorcentaje("50");
		beneficiario1.setFechaControl("fecha");
		
		Beneficiario beneficiario2 = new Beneficiario();
		beneficiario2.setCurp("curp2");
		beneficiario2.setNombre("nombre2");
		beneficiario2.setApellidoPaterno("pate2rno");
		beneficiario2.setApellidoMaterno("materno2");
		beneficiario2.setClaveParentesco("19");
		beneficiario2.setParentesco("CONOCIDO");
		beneficiario2.setPorcentaje("50");
		beneficiario2.setFechaControl("fecha");
		
		List<Beneficiario> listaBeneficiario = new ArrayList<>();
		listaBeneficiario.add(beneficiario1);
		listaBeneficiario.add(beneficiario2);
		Referencia referencia2 = new Referencia();
		referencia2.setCurp("curp2");
		referencia2.setNombre("nombre2");
		referencia2.setApellidoPaterno("apellidoPaterno2");
		referencia2.setApellidoMaterno("apellidoMaterno2");
		referencia2.setTelefono("telefono2");
		referencia2.setClaveParentesco("claveParentesco2");
		referencia2.setParentesco("parentesco2");
		referencia2.setFechaControl("fechaControl2");
		
		
		
		List<Referencia> listaRef = new ArrayList<>();
		listaRef.add(referencia1);
		listaRef.add(referencia2);
		DatosComplementarios complementarios = new DatosComplementarios();
		complementarios.setParticular(particular);
		complementarios.setLaboral(laboral);
		complementarios.setListaReferencias(listaRef);
		complementarios.setTelefonos(telefonos);
		complementarios.setCorreoElectronico("correo");
		complementarios.setListaBeneficiario(listaBeneficiario);
		datosTrabajador.setDatosComplementarios(complementarios);
		
		EntradaModificacion datosModificacion = new EntradaModificacion();
		datosModificacion.setEntidadOrigen("538");
		datosModificacion.setTipoDeMovimiento("1");//checar Por metodo
		datosModificacion.setCurp("RISG650228MTLSNB01");
		datosModificacion.setNss("94098604922");
		datosModificacion.setFirmaAgente("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");
		datosModificacion.setFirmaTrabajador("iVBORw0KGgoAAAANSUhEUgAAAAkAAAASCAYAAACJgPRIAAAACXBIWXMAAAsTAAALEwEAmpwYAAAKT2lDQ1BQaG90b3Nob3AgSUNDIHByb2ZpbGUAAHjanVNnVFPpFj333vRCS4iAlEtvUhUIIFJCi4AUkSYqIQkQSoghodkVUcERRUUEG8igiAOOjoCMFVEsDIoK2AfkIaKOg6OIisr74Xuja9a89+bN/rXXPues852zzwfACAyWSDNRNYAMqUIeEeCDx8TG4eQuQIEKJHAAEAizZCFz/SMBAPh+PDwrIsAHvgABeNMLCADATZvAMByH/w/qQplcAYCEAcB0kThLCIAUAEB6jkKmAEBGAYCdmCZTAKAEAGDLY2LjAFAtAGAnf+bTAICd+Jl7AQBblCEVAaCRACATZYhEAGg7AKzPVopFAFgwABRmS8Q5ANgtADBJV2ZIALC3AMDOEAuyAAgMADBRiIUpAAR7AGDIIyN4AISZABRG8lc88SuuEOcqAAB4mbI8uSQ5RYFbCC1xB1dXLh4ozkkXKxQ2YQJhmkAuwnmZGTKBNA/g88wAAKCRFRHgg/P9eM4Ors7ONo62Dl8t6r8G/yJiYuP+5c+rcEAAAOF0ftH+LC+zGoA7BoBt/qIl7gRoXgugdfeLZrIPQLUAoOnaV/Nw+H48PEWhkLnZ2eXk5NhKxEJbYcpXff5nwl/AV/1s+X48/Pf14L7iJIEyXYFHBPjgwsz0TKUcz5IJhGLc5o9H/LcL//wd0yLESWK5WCoU41EScY5EmozzMqUiiUKSKcUl0v9k4t8s+wM+3zUAsGo+AXuRLahdYwP2SycQWHTA4vcAAPK7b8HUKAgDgGiD4c93/+8//UegJQCAZkmScQAAXkQkLlTKsz/HCAAARKCBKrBBG/TBGCzABhzBBdzBC/xgNoRCJMTCQhBCCmSAHHJgKayCQiiGzbAdKmAv1EAdNMBRaIaTcA4uwlW4Dj1wD/phCJ7BKLyBCQRByAgTYSHaiAFiilgjjggXmYX4IcFIBBKLJCDJiBRRIkuRNUgxUopUIFVIHfI9cgI5h1xGupE7yAAygvyGvEcxlIGyUT3UDLVDuag3GoRGogvQZHQxmo8WoJvQcrQaPYw2oefQq2gP2o8+Q8cwwOgYBzPEbDAuxsNCsTgsCZNjy7EirAyrxhqwVqwDu4n1Y8+xdwQSgUXACTYEd0IgYR5BSFhMWE7YSKggHCQ0EdoJNwkDhFHCJyKTqEu0JroR+cQYYjIxh1hILCPWEo8TLxB7iEPENyQSiUMyJ7mQAkmxpFTSEtJG0m5SI+ksqZs0SBojk8naZGuyBzmULCAryIXkneTD5DPkG+Qh8lsKnWJAcaT4U+IoUspqShnlEOU05QZlmDJBVaOaUt2ooVQRNY9aQq2htlKvUYeoEzR1mjnNgxZJS6WtopXTGmgXaPdpr+h0uhHdlR5Ol9BX0svpR+iX6AP0dwwNhhWDx4hnKBmbGAcYZxl3GK+YTKYZ04sZx1QwNzHrmOeZD5lvVVgqtip8FZHKCpVKlSaVGyovVKmqpqreqgtV81XLVI+pXlN9rkZVM1PjqQnUlqtVqp1Q61MbU2epO6iHqmeob1Q/pH5Z/YkGWcNMw09DpFGgsV/jvMYgC2MZs3gsIWsNq4Z1gTXEJrHN2Xx2KruY/R27iz2qqaE5QzNKM1ezUvOUZj8H45hx+Jx0TgnnKKeX836K3hTvKeIpG6Y0TLkxZVxrqpaXllirSKtRq0frvTau7aedpr1Fu1n7gQ5Bx0onXCdHZ4/OBZ3nU9lT3acKpxZNPTr1ri6qa6UbobtEd79up+6Ynr5egJ5Mb6feeb3n+hx9L/1U/W36p/VHDFgGswwkBtsMzhg8xTVxbzwdL8fb8VFDXcNAQ6VhlWGX4YSRudE8o9VGjUYPjGnGXOMk423GbcajJgYmISZLTepN7ppSTbmmKaY7TDtMx83MzaLN1pk1mz0x1zLnm+eb15vft2BaeFostqi2uGVJsuRaplnutrxuhVo5WaVYVVpds0atna0l1rutu6cRp7lOk06rntZnw7Dxtsm2qbcZsOXYBtuutm22fWFnYhdnt8Wuw+6TvZN9un2N/T0HDYfZDqsdWh1+c7RyFDpWOt6azpzuP33F9JbpL2dYzxDP2DPjthPLKcRpnVOb00dnF2e5c4PziIuJS4LLLpc+Lpsbxt3IveRKdPVxXeF60vWdm7Obwu2o26/uNu5p7ofcn8w0nymeWTNz0MPIQ+BR5dE/C5+VMGvfrH5PQ0+BZ7XnIy9jL5FXrdewt6V3qvdh7xc+9j5yn+M+4zw33jLeWV/MN8C3yLfLT8Nvnl+F30N/I/9k/3r/0QCngCUBZwOJgUGBWwL7+Hp8Ib+OPzrbZfay2e1BjKC5QRVBj4KtguXBrSFoyOyQrSH355jOkc5pDoVQfujW0Adh5mGLw34MJ4WHhVeGP45wiFga0TGXNXfR3ENz30T6RJZE3ptnMU85ry1KNSo+qi5qPNo3ujS6P8YuZlnM1VidWElsSxw5LiquNm5svt/87fOH4p3iC+N7F5gvyF1weaHOwvSFpxapLhIsOpZATIhOOJTwQRAqqBaMJfITdyWOCnnCHcJnIi/RNtGI2ENcKh5O8kgqTXqS7JG8NXkkxTOlLOW5hCepkLxMDUzdmzqeFpp2IG0yPTq9MYOSkZBxQqohTZO2Z+pn5mZ2y6xlhbL+xW6Lty8elQfJa7OQrAVZLQq2QqboVFoo1yoHsmdlV2a/zYnKOZarnivN7cyzytuQN5zvn//tEsIS4ZK2pYZLVy0dWOa9rGo5sjxxedsK4xUFK4ZWBqw8uIq2Km3VT6vtV5eufr0mek1rgV7ByoLBtQFr6wtVCuWFfevc1+1dT1gvWd+1YfqGnRs+FYmKrhTbF5cVf9go3HjlG4dvyr+Z3JS0qavEuWTPZtJm6ebeLZ5bDpaql+aXDm4N2dq0Dd9WtO319kXbL5fNKNu7g7ZDuaO/PLi8ZafJzs07P1SkVPRU+lQ27tLdtWHX+G7R7ht7vPY07NXbW7z3/T7JvttVAVVN1WbVZftJ+7P3P66Jqun4lvttXa1ObXHtxwPSA/0HIw6217nU1R3SPVRSj9Yr60cOxx++/p3vdy0NNg1VjZzG4iNwRHnk6fcJ3/ceDTradox7rOEH0x92HWcdL2pCmvKaRptTmvtbYlu6T8w+0dbq3nr8R9sfD5w0PFl5SvNUyWna6YLTk2fyz4ydlZ19fi753GDborZ752PO32oPb++6EHTh0kX/i+c7vDvOXPK4dPKy2+UTV7hXmq86X23qdOo8/pPTT8e7nLuarrlca7nuer21e2b36RueN87d9L158Rb/1tWeOT3dvfN6b/fF9/XfFt1+cif9zsu72Xcn7q28T7xf9EDtQdlD3YfVP1v+3Njv3H9qwHeg89HcR/cGhYPP/pH1jw9DBY+Zj8uGDYbrnjg+OTniP3L96fynQ89kzyaeF/6i/suuFxYvfvjV69fO0ZjRoZfyl5O/bXyl/erA6xmv28bCxh6+yXgzMV70VvvtwXfcdx3vo98PT+R8IH8o/2j5sfVT0Kf7kxmTk/8EA5jz/GMzLdsAAAAgY0hSTQAAeiUAAICDAAD5/wAAgOkAAHUwAADqYAAAOpgAABdvkl/FRgAAALFJREFUeNqckqESglAQRc91bHS7XbvdzlfQ6Zqh0+l2O93uB9Dt5GtwcRARR1+7M2f27T2zss3XZ7uyncwxC2ANVLbXc1ALrIDS9nYKUnxVxkSASlLzAg12y4F9xLOk+g0KMAPSiA1QS+o00XYP5BFb4KAPWnYBJsBNM/6eExczQBZxcqd0ALRAMW431HAJZ49JIfQIbPr6kqrfjNs+RdUOKCVdx3suexdAIan9+57uAwDN2FgNPkrftAAAAABJRU5ErkJggg==");
		
		DatosBaseCurp baseCurp = new DatosBaseCurp();
		baseCurp.setCurpNueva("RISG650228MTLSNB01");
		baseCurp.setRfc("RISG650228MTL");
		baseCurp.setApellidoPaterno("RIOS");
		baseCurp.setApellidoMaterno("SANCHEZ");
		baseCurp.setNombreTrabajador("GABRIELA");
		baseCurp.setFechaDeNacimiento("1965-02-28");
		baseCurp.setSexo("Femenino");
		baseCurp.setEntidadFederativaDeNacimiento("29 TLAXCALA");
		baseCurp.setNacionalidad("1 MEXICANA:MEXICO");
		baseCurp.setFolioDeLaSolicitud("1909060022");
		baseCurp.setOcupacionOProfesionTrabajador("62 TRABAJADORES DE APOYO EN ACTIVIDADES ADMINISTRATIVAS");
		baseCurp.setActividadOGiroNegocioTrabajador("12 ADMINISTRACION PUBLICA");
		baseCurp.setNivelDeEstudioTrabajador("05 CARRERA PROFESIONAL");
		baseCurp.setFlujoDeValidacion("2A");  //Checar por metodo
		baseCurp.setSelloVerificacionBiometrica("11111111111111");
		baseCurp.setSelloVoluntadTramite("99999999999999");
		baseCurp.setIndicadorDeDuplicidad("0");
		baseCurp.setIndicadorDeServicioBiometrico("0507");
		baseCurp.setCurpSolicitante("RISG650228MTLSNB01");
		baseCurp.setTipoSolicitante("01");
		datosModificacion.setDatosBaseCurp(baseCurp);
		
		DatosDomicilioParticularTrabajador datosDomicilioParticularTrabajador = new DatosDomicilioParticularTrabajador();
		datosDomicilioParticularTrabajador.setCalle("calle4");
		datosDomicilioParticularTrabajador.setNumeroExterior("121");
		datosDomicilioParticularTrabajador.setNumeroInterior("121111");
		datosDomicilioParticularTrabajador.setColonia("valle los reyes");
		datosDomicilioParticularTrabajador.setDelegacionOMunicipio("ALVARO OBREGON");
		datosDomicilioParticularTrabajador.setCodigoPostal("12345");
		datosDomicilioParticularTrabajador.setEntidadFederativa("DISTRITO FEDERAL");
		datosDomicilioParticularTrabajador.setPais("MEX MEXICO");
		datosDomicilioParticularTrabajador.setIndicadorDeTelefono1("000");
		datosDomicilioParticularTrabajador.setTelefono1("5667777777");
		datosDomicilioParticularTrabajador.setExtension1("123");
		datosDomicilioParticularTrabajador.setIndicadorDeTelefono2("000");
		datosDomicilioParticularTrabajador.setTelefono2("5677889900");
		datosDomicilioParticularTrabajador.setExtension2("321");
		datosDomicilioParticularTrabajador.setCorreoElectronicoDelTrabajador("chay@gmail.com");
		datosModificacion.setDatosDomicilioParticularTrabajador(datosDomicilioParticularTrabajador);
		
		DatosDomicilioLaboralTrabajador datosDomicilioLaboralTrabajador = new DatosDomicilioLaboralTrabajador();
		datosDomicilioLaboralTrabajador.setCalle("Calle9");
		datosDomicilioLaboralTrabajador.setNumeroExterior("123");
		datosDomicilioLaboralTrabajador.setNumeroInterior("456");
		datosDomicilioLaboralTrabajador.setColonia("Pinos");
		datosDomicilioLaboralTrabajador.setDelegacionOMunicipio("IZTACALCO");
		datosDomicilioLaboralTrabajador.setCodigoPostal("98765");
		datosDomicilioLaboralTrabajador.setEntidadFederativa("DISTRITO FEDERAL");
		datosDomicilioLaboralTrabajador.setPais("MEX MEXICO");
		datosModificacion.setDatosDomicilioLaboralTrabajador(datosDomicilioLaboralTrabajador);
		
		
		DatosReferenciasTrabajador datosReferenciasTrabajador = new DatosReferenciasTrabajador();
		datosReferenciasTrabajador.setApellidoPaternoDeReferencia1("Perez");
		datosReferenciasTrabajador.setApellidoMaternoDeReferencia1("Lirios");
		datosReferenciasTrabajador.setNombreDeReferencia1("Luisa");
		datosReferenciasTrabajador.setCurpDeReferencia1("FRTY890122HDFTJB78");
		datosReferenciasTrabajador.setTelefonoDeReferencia1("5666778800");
		datosReferenciasTrabajador.setParentescoORelacionDeReferencia1("16 MADRINA");
		
		datosReferenciasTrabajador.setApellidoPaternoDeReferencia2("Rojas");
		datosReferenciasTrabajador.setApellidoMaternoDeReferencia2("feriz");
		datosReferenciasTrabajador.setNombreDeReferencia2("Armando");
		datosReferenciasTrabajador.setCurpDeReferencia2("MAGO820808HBCRRS01");
		datosReferenciasTrabajador.setTelefonoDeReferencia2("5666778899");
		datosReferenciasTrabajador.setParentescoORelacionDeReferencia2("15 PADRINO");
		datosModificacion.setDatosReferenciasTrabajador(datosReferenciasTrabajador);
		
		
		ListaBeneficiariosTrabajador listaBeneficiariosTrabajador = new ListaBeneficiariosTrabajador();
		List<DatosBeneficiarioTrabajador> listabeneficiario = new ArrayList<DatosBeneficiarioTrabajador>();
		
		DatosBeneficiarioTrabajador beneficiario1T = new DatosBeneficiarioTrabajador();
		beneficiario1T.setApellidoPaternoDeBeneficiario("Ruiz");
		beneficiario1T.setApellidoMaternoDeBeneficiario("Garcia");
		beneficiario1T.setCurpDeBeneficiario("PEHG590707MNTXRD15");
		beneficiario1T.setNombreDeBeneficiario("Maria Luisa");
		beneficiario1T.setParentescoORelacion("06 HERMANO(A)"); //Por Verificar Si es ASi
		beneficiario1T.setPorcentajeDeBeneficiario("70");
		listabeneficiario.add(beneficiario1T);
		DatosBeneficiarioTrabajador beneficiario2T = new DatosBeneficiarioTrabajador();
		beneficiario2T.setApellidoPaternoDeBeneficiario("Perez");
		beneficiario2T.setApellidoMaternoDeBeneficiario("Mendez");
		beneficiario2T.setCurpDeBeneficiario("JIHO781213HDFMRC07");
		beneficiario2T.setNombreDeBeneficiario("Rosa Isela");
		beneficiario2T.setParentescoORelacion("03 HIJO(A)"); //Por Verificar Si es Asi
		beneficiario2T.setPorcentajeDeBeneficiario("30");
		listabeneficiario.add(beneficiario2T);
				
		listaBeneficiariosTrabajador.setBeneficiario(listabeneficiario);
		datosModificacion.setListaBeneficiariosTrabajador(listaBeneficiariosTrabajador);
		
		Folio folioPadre = new Folio();
		folioPadre.setChFolio("convertirFechaACadena");
		
		BanderaDatosModificadosCertificables banderaDatosModificadosCertificables = new BanderaDatosModificadosCertificables();
		banderaDatosModificadosCertificables.setModificadoCurp(true);
		banderaDatosModificadosCertificables.setModificadoRfc(true);
		banderaDatosModificadosCertificables.setModificadoApellidoPaterno(true);
		banderaDatosModificadosCertificables.setModificadoApellidoMaterno(true);
		banderaDatosModificadosCertificables.setModificadoNombre(true);
		banderaDatosModificadosCertificables.setModificadoFechaNacimiento(true);
		banderaDatosModificadosCertificables.setModificadoSexo(true);
		banderaDatosModificadosCertificables.setModificadoEntidadNacimiento(true);
		banderaDatosModificadosCertificables.setModificadoNacionalidad(true);
		banderaDatosModificadosCertificables.setModificacionDatosCertificables(true);
		banderaDatosModificadosCertificables.setFolioPadre(folioPadre);
		banderaDatosModificadosCertificables.setFolioSolicitud(folioPadre);
		
				
		//Ejemplo de entrada 29 TLAXCALA
		int index = datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento().indexOf(" ");
		String entidadFederativaNacimientoModificada  = datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento().substring(index++);
				
		//Ejemplo de entrada: 1 MEXICANA:MEXICO
		String nacionalidadModificada = "";
		String nacionalidadModificadaArreglo[] = datosModificacion.getDatosBaseCurp().getNacionalidad().split(":");
		if(nacionalidadModificadaArreglo!= null && nacionalidadModificadaArreglo.length==2){
			int i = nacionalidadModificadaArreglo[0].indexOf(" ");
			nacionalidadModificada= nacionalidadModificadaArreglo[0].substring(i++);
		}


		FlujosEntrada flujoEntrada = new FlujosEntrada();
		flujoEntrada.setMovimiento("1");
		flujoEntrada.setFlujoValidacion("2A");
		
		UsuarioLogin user = new UsuarioLogin();
		user.setAforeUsuario("556");
		user.setApellidoPaterno("paterno");
		user.setApellidoMaterno("materno");
		user.setSoloNombre("nombre");
		
		EntradaConsulta consulta = new EntradaConsulta();
		
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaValidador.validarListaVacia(Mockito.anyList())).thenReturn(Boolean.FALSE);
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString())).thenReturn("rutaPdf");
		Mockito.when(fechaUtils.convertirFechaACadena(any(Date.class), Mockito.anyString())).thenReturn("07/02/2020");
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("valor");
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("ejemplo");
		Mockito.when(utileriaCadena.asignarValor(Mockito.anyString())).thenReturn("texto");
		Mockito.when(utileriaCadena.asignarValor(ArgumentMatchers.nullable(String.class))).thenReturn("texto");
		Mockito.when(utileriaCadena.asignarValor(ArgumentMatchers.nullable(String.class))).thenReturn("texto");
		Mockito.when(utileriaCadena.asignarValor(ArgumentMatchers.nullable(String.class))).thenReturn("texto");
		Mockito.when(utileriaCadena.asignarValor(ArgumentMatchers.nullable(String.class))).thenReturn("texto");
		Mockito.when(utileriaCadena.asignarValor(ArgumentMatchers.nullable(String.class))).thenReturn("texto");
		Mockito.when(utileriaCadena.asignarValor(ArgumentMatchers.nullable(String.class))).thenReturn("texto");
		Mockito.when(fechaUtils.convertirCadenaAFecha(Mockito.anyString(), Mockito.anyString())).thenReturn(new Date());
		Mockito.when(fechaUtils.ObtenerFechas(Mockito.anyString())).thenReturn("20201014");
		Mockito.when(utileriaCadena.obtenerCadenaConcatenada(Mockito.anyBoolean(), Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn("ruta");
		Mockito.when(utileriaCadena.obtenerContenidoCadenaSinEspacios(Mockito.anyString(), Mockito.anyString())).thenReturn("texto");
//		serviceExpediente.generarSolicitudDatosPDFCoppel(datosTrabajador, datosModificacion, banderaDatosModificadosCertificables,"01/03/1996", entidadFederativaNacimientoModificada, nacionalidadModificada,datosModificacion,user,consulta,null);
	}
	
}
