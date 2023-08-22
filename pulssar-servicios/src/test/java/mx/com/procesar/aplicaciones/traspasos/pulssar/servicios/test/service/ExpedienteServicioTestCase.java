package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itextpdf.text.DocumentException;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Domicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ListaBeneficiariosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Referencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Telefono;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;

/**
 * Test case solicitud banorte
 * @author JMGUTIEG
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class,
		PulssarServiceApplicationContextTest.class, PulssarPersistenceApplicationContextTest.class,
		PulssarCorreoAplicationContextTest.class })
public class ExpedienteServicioTestCase {
	
	
	
	/**
	 * Injeccion de servicio
	 */
	/**
	 * Inyeccon Servicio
	 */
	@Autowired
	private ExpedienteServicioService servicePrueba;

	/**
	 * test solicitud banorte
	 * @throws DocumentException
	 * @throws IOException
	 */
	@Test
	public void generarSolicitudDatosBanorteTest() throws DocumentException, IOException{ 
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setNss("09876543210");
		datosTrabajador.setNacionalidad("MEXICANA");
		datosTrabajador.setTipoSolicitante("01");
			
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setNombre("GABRIELA");
		datosCertificables.setApellidoPaterno("RIOS");
		datosCertificables.setApellidoMaterno("SANCHEZ");
		datosCertificables.setFechaNacimiento("28/agosto/1965");
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
		baseCurp.setCurpNueva("RISG650228MTLSNB10");
		baseCurp.setRfc("RISG650228M10");
		baseCurp.setApellidoPaterno("RIOZ");
		baseCurp.setApellidoMaterno("SANHEZ");
		baseCurp.setNombreTrabajador("GABRIELE");
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
		folioPadre.setChFolio("00001125485000000045");
		
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
		
				
		//Ejemplo de entrada 29 TLAXCALA7
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
		servicePrueba.generarSolicitudDatosPDFBanorte(datosTrabajador, datosModificacion, banderaDatosModificadosCertificables,"01/03/1996", entidadFederativaNacimientoModificada, nacionalidadModificada,datosModificacion,user);
	}
	
	/**
	 * test solicitud banorte
	 * @throws DocumentException
	 * @throws IOException
	 */
	@Test
	public void generarSolicitudDatosBanorteTestException() throws DocumentException, IOException{ 
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setNss("09876543210");
		datosTrabajador.setNacionalidad("MEXICANA");
		datosTrabajador.setTipoSolicitante("01");
			
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setNombre("GABRIELA");
		datosCertificables.setApellidoPaterno("RIOS");
		datosCertificables.setApellidoMaterno("SANCHEZ");
		datosCertificables.setFechaNacimiento("fecha");
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
		baseCurp.setCurpNueva("RISG650228MTLSNB10");
		baseCurp.setRfc("RISG650228M10");
		baseCurp.setApellidoPaterno("RIOZ");
		baseCurp.setApellidoMaterno("SANHEZ");
		baseCurp.setNombreTrabajador("GABRIELE");
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
		
		Folio folioPadre = new Folio();
		folioPadre.setChFolio("00001125485000000045");
		
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
		
				
		//Ejemplo de entrada 29 TLAXCALA7
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
		servicePrueba.generarSolicitudDatosPDFBanorte(datosTrabajador, datosModificacion, banderaDatosModificadosCertificables,"01/03/1996", entidadFederativaNacimientoModificada, nacionalidadModificada,datosModificacion,user);
	}
	

	/**
	 * test solicitud banorte
	 * @throws DocumentException
	 * @throws IOException
	 */
	@Test
	public void generarSolicitudCoppelTest() throws DocumentException, IOException{ 
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setNss("09876543210");
		datosTrabajador.setNacionalidad("MEXICANA");
		datosTrabajador.setTipoSolicitante("02");
		datosTrabajador.setClaveAfore("538");
			
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setNombre("GABRIELA");
		datosCertificables.setApellidoPaterno("RIOS");
		datosCertificables.setApellidoMaterno("SANCHEZ");
		datosCertificables.setFechaNacimiento("28/junio/1965");
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
		datosModificacion.setFirmaTrabajador("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");
		
		DatosBaseCurp baseCurp = new DatosBaseCurp();
		baseCurp.setCurpNueva("RISG650228MTLSNB02");
		baseCurp.setRfc("RISG650228MT2");
		baseCurp.setApellidoPaterno("RIOZ");
		baseCurp.setApellidoMaterno("SANCHES");
		baseCurp.setNombreTrabajador("GABRIEL");
		baseCurp.setFechaDeNacimiento("1965/02/28");
		baseCurp.setSexo("Femenino");
		baseCurp.setEntidadFederativaDeNacimiento("29 TLAXCALA");
		baseCurp.setNacionalidad("1 MEXICANA:MEXICO");
		baseCurp.setFolioDeLaSolicitud("1909060022");
		baseCurp.setOcupacionOProfesionTrabajador("62 TRABAJADORES DE APOYO EN ACTIVIDADES ADMINISTRATIVAS hjbhjbjb ugujuyjg uhuuhui uiguihui uhuhiuhiu thrthrth");
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
		folioPadre.setChFolio("00001125485000000045");
		
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
		consulta.setApellidoPaterno("paterno");
		consulta.setApellidoMaterno("materno");
		consulta.setNombre("nombre");
		consulta.setCurpSolicitante("curp");
		consulta.setCvTipoSolicitante("02");
		

//		servicePrueba.generarSolicitudDatosPDFCoppel(datosTrabajador, datosModificacion, banderaDatosModificadosCertificables,"01/03/1996", entidadFederativaNacimientoModificada, nacionalidadModificada,datosModificacion,user,consulta,"1");
	}
	
	/**
	 * test solicitud banorte
	 * @throws DocumentException
	 * @throws IOException
	 */
	@Test(expected=GenericException.class)
	public void generarSolicitudCoppelTestException() throws DocumentException, IOException{ 
		
		DatosTrabajador datosTrabajador = new DatosTrabajador();
		datosTrabajador.setNss(null);
		datosTrabajador.setNacionalidad("MEXICANA");
		datosTrabajador.setTipoSolicitante("02");
		datosTrabajador.setClaveAfore(null);
			
		DatosCertificables datosCertificables = new DatosCertificables();
		datosCertificables.setNombre(null);
		datosCertificables.setApellidoPaterno(null);
		datosCertificables.setApellidoMaterno(null);
		datosCertificables.setFechaNacimiento(null);
		datosCertificables.setEntidadNacimiento("TLAXCALA");
		datosCertificables.setCurp(null);
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
		baseCurp.setCurpNueva("RISG650228MTLSNB02");
		baseCurp.setRfc("RISG650228MT2");
		baseCurp.setApellidoPaterno("RIOZ");
		baseCurp.setApellidoMaterno("SANCHES");
		baseCurp.setNombreTrabajador("GABRIEL");
		baseCurp.setFechaDeNacimiento("1965/02/28");
		baseCurp.setSexo("Femenino");
		baseCurp.setEntidadFederativaDeNacimiento("29 TLAXCALA");
		baseCurp.setNacionalidad("1 MEXICANA:MEXICO");
		baseCurp.setFolioDeLaSolicitud("1909060022");
		baseCurp.setOcupacionOProfesionTrabajador("62 TRABAJADORES DE APOYO EN ACTIVIDADES ADMINISTRATIVAS hjbhjbjb ugujuyjg uhuuhui uiguihui uhuhiuhiu thrthrth");
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
		

		Folio folioPadre = new Folio();
		folioPadre.setChFolio("00001125485000000045");
		
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
		consulta.setApellidoPaterno("paterno");
		consulta.setApellidoMaterno("materno");
		consulta.setNombre("nombre");
		consulta.setCurpSolicitante("curp");
		consulta.setCvTipoSolicitante("02");
		

//		servicePrueba.generarSolicitudDatosPDFCoppel(datosTrabajador, datosModificacion, banderaDatosModificadosCertificables,"01/03/1996", entidadFederativaNacimientoModificada, nacionalidadModificada,datosModificacion,user,consulta,"1");
	}

}
