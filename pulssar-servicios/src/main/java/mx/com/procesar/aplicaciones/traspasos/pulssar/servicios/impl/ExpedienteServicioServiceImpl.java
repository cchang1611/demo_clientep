package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Annotation;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ConsultaSelloService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.EstatusExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.FolioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ModificacionTrabajadorService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.NotificacionExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MensajesExitoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ArchivoRecibido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BanderaDatosModificadosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BanderaDatosModificadosDomicilios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.BanderaDatosModificadosReferencias;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Beneficiario;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBeneficiarioTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosComplementarios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosNoCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitud;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudModificacionPdf;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DetalleRecepcionImagenes;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Domicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaSolicitante;
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
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Telefono;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.VerificacionSello;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.LectorArchivoUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;

@Service
public class ExpedienteServicioServiceImpl implements ExpedienteServicioService{
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ExpedienteServicioServiceImpl.class);
	/**
	 * Inyeccion de servicio
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	/**
	 * Ruta Plantilla de Solicitud de Modificacion de Datos
	 */
	@Value("${ruta.plantilla.solicitud.modificacion.datos}")
	private String rutaPlantillaSolicitudModificacionDatos;
	
	/**
	 * Ruta Plantilla de Solicitud de Modificacion de Datos para banorte
	 */
	@Value("${ruta.plantilla.solicitud.modificacion.datos.banorte}")
	private String rutaPlantillaBanorte;
	
	/**
	 * Ruta Plantilla de Solicitud de Modificacion de Datos para banorte
	 */
	@Value("${ruta.plantilla.solicitud.modificacion.datos.coppel}")
	private String rutaPlantillaCoppel;
	
	/**
	 * Ruta  donde se escribe los archivos
	 */
	@Value("${url.ruta.expediente.servicio}")
	private String urlRutaExpedienteServicio;
	/**
	 * Id cliente
	 */
	@Value("#{propiedades['archivos.idCliente']}")
	private String idCliente;
	/**
	 * Id servicio
	 */
	@Value("#{propiedades['archivos.idServicio']}")
	private String idServicio;
	/**
	 * Id business
	 */
	@Value("#{propiedades['archivos.idEbusiness']}")
	private String idEbusiness;
	/**
	 * Tipo de autenticacion
	 */
	@Value("#{propiedades['autenticacion.archivos.autenticacion']}")
	private String tipoAutenticacion;
	/**
	 * Usuario 
	 */
	@Value("#{propiedades['autenticacion.archivos.usuario']}")
	private String usuarioArchivos;	
	/**
	 * Password
	 */
	@Value("#{propiedades['autenticacion.archivos.password']}")
	private String passwordArchivos;
	/**
	 * Inyeccion de rest
	 */
	@Autowired
	private RestTemplate servicioCliente;
	/**
	 * Ruta url servicio sms
	 */
	@Value("${url.recepcion.archivos}")
	private String urlRecepcionArchivos;
	/**
	 * Inyeccion de utileria compresor
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * Inyeccion de dependencia fechaUtils
	 */
    @Autowired
	private FechaUtils fechaUtils;
    
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private RecepcionArchivosService servicioArchivos;
	
	/**
	 * Ruta url servicio digitaliza banorte
	 */
	@Value("${url.ruta.digitaliza.banorte}")
	private String urlDigitalizaBanorte;
	
	/**
	 * url comunes
	 */
	@Value("${uri.comunes}")
	private String urlComunes;
	
	/**
	 * Utilidad Lector
	 */
	@Autowired
	private LectorArchivoUtils lectorUtils;
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CatalogoService servicioCatalogo;
	
	 /**
     * Inyeccion expedienteService
     */
     @Autowired
     private EstatusExpedienteService expedienteService;
     
     /**
      * ConsultaSelloProxyService
      */
     @Autowired
 	private ConsultaSelloService consultaSelloService;
     
 	/**
 	 * url comunes
 	 */
 	@Value("${url.ruta.digitaliza}")
 	private String urlDigitaliza;
 	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private FolioService servicioFolio;
	
	/**
	 * Notificacio de actualizacion de datos
	 */
	@Autowired
	private NotificacionExpedienteService notificacionExpedienteService; 
	
	/***
	 * Modificacion trabajador service
	 */
	@Autowired
	private ModificacionTrabajadorService modificacionTrabajadorService;
     
	

	/**
	 * Genera el pdf de la solicitud de modificacion de datos
	 */
	@Override
	public DatosSolicitudModificacionPdf generarSolicitudDatosPDFPeis(FlujosEntrada flujoEntrada , DatosTrabajador datosTrabajador, EntradaModificacion datosModificacion, BanderaDatosModificadosCertificables banderaDatosModif, String fechaNacimientoModificada, String entidadFederativaNacimientoModificada, String nacionalidadModificada,EntradaModificacion objetoModificacion,UsuarioLogin user) throws DocumentException, IOException {
		byte[] contenido = null;
		String contenidoSolicModif = null;
		PdfReader plantilla = null;
		PdfStamper stamperPlantilla = null;
		int index ;
		DatosSolicitudModificacionPdf result = new DatosSolicitudModificacionPdf();
		logger.info(ExpresionesConstants.ENTRADA_DATOS_TRABAJADOR,datosTrabajador);
		logger.info(ExpresionesConstants.ENTRADA_DATOS_MODIFICACION,datosModificacion) ;
		logger.info(ExpresionesConstants.BANDERA_DATOS_MODIFICACION,banderaDatosModif);
		logger.info(ExpresionesConstants.OBJETO_MODIFICACION,objetoModificacion);
		
		try{
			//Ruta Destino
			String urlEnvio = generarUrlGuardadoArchivos(user.getAforeUsuario(), "46");

			String rutaTemporalParaEscribir = utileriaCadena.obtenerCadenaConcatenada(true, urlEnvio, banderaDatosModif.getFolioPadre().getChFolio(), "4669", ExpresionesConstants.EXTENSION_PDF);
			logger.info("Ruta solicitud peis : {}",rutaTemporalParaEscribir);
			plantilla = new PdfReader(rutaPlantillaSolicitudModificacionDatos);
			stamperPlantilla = new PdfStamper(plantilla, new FileOutputStream(rutaTemporalParaEscribir));
			
			PdfContentByte canvas = stamperPlantilla.getOverContent(1);
			BaseFont baseFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			
			 configurarPropiedadesTexto(canvas,baseFont,7f);
			String fechaRecepcionSolicitud = fechaUtils.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_RENAPO);
			
			String domicilioParticularTrabajadorPais = regresarPaisParticular(datosModificacion);
			String domicilioLaboralTrabajadorPais = regresarPaisLaboral(datosModificacion);
			String ocupacionOProfesionTrabajador = regresarOcupacion(datosModificacion);
			String actividadOGiroNegocioTrabajador = regresaraGiro(datosModificacion);
			String nivelDeEstudioTrabajador = regresarNivelEstudios(datosModificacion);
			result.setNumeroPaginas(2);

			//Ejemplo de entrada 16 MADRINA
			String parentescoORelacionDeReferencia1 = ExpresionesConstants.VACIO;
			String parentescoORelacionDeReferencia2 = ExpresionesConstants.VACIO;
			if(datosModificacion.getDatosReferenciasTrabajador() != null){
				index = datosModificacion.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia1().indexOf(ExpresionesConstants.ESPACIO);
				parentescoORelacionDeReferencia1 = datosModificacion.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia1().substring(index++);
				
				index = datosModificacion.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia2().indexOf(ExpresionesConstants.ESPACIO);
				parentescoORelacionDeReferencia2 = datosModificacion.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia2().substring(index++);
			}		
			
			String folioSolicitud = generarFolioSolicitud(banderaDatosModif.getFolioSolicitud());

			
			canvas.showTextAligned(Element.ALIGN_LEFT, folioSolicitud, 495, 750, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, fechaRecepcionSolicitud, 430, 678, 0);
			
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getNombre()== null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getNombre(), 135, 640, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getApellidoPaterno() == null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getApellidoPaterno(), 135, 625, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getApellidoMaterno() == null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getApellidoMaterno(), 135, 610, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getFechaNacimiento() == null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getFechaNacimiento(), 135, 595, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getEntidadNacimiento() == null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getEntidadNacimiento(), 135, 580, 0);
			
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getCurp()== null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getCurp(), 425, 640, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getNss()== null ? ExpresionesConstants.VACIO : datosTrabajador.getNss(), 425, 625, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosNoCertificables().getRfc()== null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosNoCertificables().getRfc(), 425, 610, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getGenero()==null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getGenero(), 425, 595, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getNacionalidad()== null ? ExpresionesConstants.VACIO : datosTrabajador.getNacionalidad(), 425, 580, 0);
			
			canvas.showTextAligned(Element.ALIGN_CENTER, banderaDatosModif.isModificacionDatosCertificables() ? "X" : ExpresionesConstants.VACIO, 43, 560, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, banderaDatosModif.isModificadoCurp() ? "X" : ExpresionesConstants.VACIO, 37, 527, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, banderaDatosModif.isModificadoRfc() ? "X" : ExpresionesConstants.VACIO, 37, 514, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, banderaDatosModif.isModificadoApellidoPaterno() ? "X" : ExpresionesConstants.VACIO, 37, 499, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, banderaDatosModif.isModificadoApellidoMaterno() ? "X" : ExpresionesConstants.VACIO, 37, 485, 0);	
			canvas.showTextAligned(Element.ALIGN_CENTER, banderaDatosModif.isModificadoNombre() ? "X" : ExpresionesConstants.VACIO, 37, 471, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, banderaDatosModif.isModificadoFechaNacimiento() ? "X" : ExpresionesConstants.VACIO, 37, 457, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, banderaDatosModif.isModificadoSexo() ? "X" : ExpresionesConstants.VACIO, 37, 443, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, banderaDatosModif.isModificadoEntidadNacimiento() ? "X" : ExpresionesConstants.VACIO, 37, 429, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, banderaDatosModif.isModificadoNacionalidad() ? "X" : ExpresionesConstants.VACIO, 37, 415, 0);
			
			if(banderaDatosModif.isModificadoCurp()){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getCurp()== null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getCurp().toUpperCase(), 145, 527, 0);
			}else{
				canvas.showTextAligned(Element.ALIGN_LEFT, ExpresionesConstants.VACIO, 145, 527, 0);
			}
			if(banderaDatosModif.isModificadoRfc()){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosNoCertificables().getRfc()==null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosNoCertificables().getRfc().toUpperCase(), 145, 514, 0);
			}else{
				canvas.showTextAligned(Element.ALIGN_LEFT, ExpresionesConstants.VACIO , 145, 514, 0);
			}
			if(banderaDatosModif.isModificadoApellidoPaterno()){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getApellidoPaterno()== null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getApellidoPaterno().toUpperCase(), 145, 499, 0);
			}else{
				canvas.showTextAligned(Element.ALIGN_LEFT, ExpresionesConstants.VACIO, 145, 499, 0);
			}
			if(banderaDatosModif.isModificadoApellidoMaterno()){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getApellidoMaterno()== null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getApellidoMaterno().toUpperCase(), 145, 484, 0);
			}else{
				canvas.showTextAligned(Element.ALIGN_LEFT, ExpresionesConstants.VACIO, 145, 484, 0);
			}
			if(banderaDatosModif.isModificadoNombre()){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getNombre()== null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getNombre().toUpperCase(), 145, 470, 0);
			}else{
				canvas.showTextAligned(Element.ALIGN_LEFT, ExpresionesConstants.VACIO, 145, 470, 0);
			}
			if(banderaDatosModif.isModificadoFechaNacimiento()){
				String fechaNacimientoTrabajador = null;
				if(!utileriaValidador.validarVacio(datosTrabajador.getDatosCertificables().getFechaNacimiento())) {
					Date fechaNacimientoModificadaDate =  fechaUtils.convertirCadenaAFecha(datosTrabajador.getDatosCertificables().getFechaNacimiento(),  FormatoConstants.FORMATO_FECHA_NACIMIENTO) ;
					fechaNacimientoTrabajador = fechaUtils.convertirFechaACadena(fechaNacimientoModificadaDate, FormatoConstants.FORMATO_FECHA_RENAPO);
				}

	
				canvas.showTextAligned(Element.ALIGN_LEFT, fechaNacimientoTrabajador == null ? ExpresionesConstants.VACIO : fechaNacimientoTrabajador, 145, 456, 0);
			}else{
				canvas.showTextAligned(Element.ALIGN_LEFT, ExpresionesConstants.VACIO, 145, 456, 0);
			}
			if(banderaDatosModif.isModificadoSexo()){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getGenero() == null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getGenero(), 145, 442, 0);
			}else{
				canvas.showTextAligned(Element.ALIGN_LEFT, ExpresionesConstants.VACIO, 145, 442, 0);
			}
			if(banderaDatosModif.isModificadoEntidadNacimiento()){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getEntidadNacimiento() == null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getEntidadNacimiento(), 145, 427, 0);
			}else{
				canvas.showTextAligned(Element.ALIGN_LEFT, ExpresionesConstants.VACIO, 145, 427, 0);
			}
			if(banderaDatosModif.isModificadoNacionalidad()){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getNacionalidad() == null ? ExpresionesConstants.VACIO : datosTrabajador.getNacionalidad(), 145, 413, 0);
			}else{
				canvas.showTextAligned(Element.ALIGN_LEFT, ExpresionesConstants.VACIO, 145, 413, 0);
			}
			
			if(!utileriaValidador.validarVacio(fechaNacimientoModificada)) {
				String fechaNacimientoNueva = fechaNacimientoModificada;
				Date fechaNacimientoModificadaDate =  fechaUtils.convertirCadenaAFecha(fechaNacimientoNueva,  FormatoConstants.FORMATO_FECHA_NACIMIENTO) ;
				fechaNacimientoNueva = fechaUtils.convertirFechaACadena(fechaNacimientoModificadaDate, FormatoConstants.FORMATO_FECHA_RENAPO);
				canvas.showTextAligned(Element.ALIGN_LEFT, fechaNacimientoNueva , 425, 456, 0);
			}
			
			canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getCurpNueva(), 425, 527, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getRfc(), 425, 514, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getApellidoPaterno().toUpperCase() , 425, 499, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getApellidoMaterno().toUpperCase(), 425, 484, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getNombreTrabajador().toUpperCase() , 425, 470, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getSexo().toUpperCase() , 425, 442, 0); 
			canvas.showTextAligned(Element.ALIGN_LEFT, entidadFederativaNacimientoModificada, 425, 427, 0); 
			canvas.showTextAligned(Element.ALIGN_LEFT, nacionalidadModificada , 425, 413, 0); 
			
			if(datosModificacion.getDatosDomicilioParticularTrabajador() != null){	
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getCalle().toUpperCase(), 126, 375, 0); 
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getColonia().toUpperCase(), 126, 360, 0); 
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getDelegacionOMunicipio() , 126, 345, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getEntidadFederativa() , 126, 331, 0);
				
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getNumeroExterior() , 410, 375, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getNumeroInterior() , 523, 375, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getCodigoPostal() , 410, 360, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, domicilioParticularTrabajadorPais , 410, 346, 0); 
				
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getTelefono1() , 180, 295, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getExtension1() , 305, 295, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getTelefono2() , 180, 280, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getExtension2() , 305, 280, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getCorreoElectronicoDelTrabajador() , 90, 265, 0);
			}
			
			if(datosModificacion.getDatosDomicilioLaboralTrabajador() != null){	
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getCalle().toUpperCase() , 126 , 198, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getColonia().toUpperCase(), 126 , 183, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getDelegacionOMunicipio() , 126 , 168, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getEntidadFederativa() , 126 , 154, 0);
				
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getNumeroExterior(), 410 , 198, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getNumeroInterior(), 523 , 198, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getCodigoPostal(), 410 , 183, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, domicilioLaboralTrabajadorPais , 410 , 168, 0); 
			}
			
			canvas.showTextAligned(Element.ALIGN_LEFT, ocupacionOProfesionTrabajador, 90 , 118, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, actividadOGiroNegocioTrabajador, 130 , 103, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, nivelDeEstudioTrabajador, 130 , 88, 0);
			
			canvas.endText();
			canvas.restoreState();
			canvas.saveState();
			
			canvas = stamperPlantilla.getOverContent(2);
			baseFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			
			configurarPropiedadesTexto(canvas, baseFont,7f);
			
			
			canvas.showTextAligned(Element.ALIGN_LEFT, folioSolicitud, 495, 750, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, fechaRecepcionSolicitud, 430, 678, 0);
						
			if(datosModificacion.getDatosReferenciasTrabajador() != null){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getNombreDeReferencia1().toUpperCase(), 118 , 625, 0);  
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getApellidoPaternoDeReferencia1().toUpperCase(), 118 , 610, 0); 
				canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.obtenerContenidoCadenaSinEspacios(datosModificacion.getDatosReferenciasTrabajador().getApellidoMaternoDeReferencia1(),ExpresionesConstants.VACIO).toUpperCase(), 118 , 595, 0); 
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getCurpDeReferencia1(), 118 , 580, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, parentescoORelacionDeReferencia1, 118 , 565, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getTelefonoDeReferencia1(), 118 , 550, 0);
			
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getNombreDeReferencia2().toUpperCase(), 410 , 625, 0);  
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getApellidoPaternoDeReferencia2().toUpperCase(), 410 , 610, 0); 
				canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.obtenerContenidoCadenaSinEspacios(datosModificacion.getDatosReferenciasTrabajador().getApellidoMaternoDeReferencia2(),ExpresionesConstants.VACIO).toUpperCase(), 410 , 595, 0); 
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getCurpDeReferencia2(), 410 , 580, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, parentescoORelacionDeReferencia2, 410 , 565, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getTelefonoDeReferencia2(), 410 , 550, 0);
			}	
			canvas.endText();
			canvas.restoreState();
			canvas.saveState();
			
			canvas = stamperPlantilla.getOverContent(2);
			baseFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			
			configurarPropiedadesTexto(canvas, baseFont,7f);
			
			
			if(datosModificacion.getListaBeneficiariosTrabajador() != null){
				List<DatosBeneficiarioTrabajador> listaBeneficiarios = datosModificacion.getListaBeneficiariosTrabajador().getBeneficiario();
				if(!utileriaValidador.validarListaVacia(listaBeneficiarios)){
					regresarBeneficiariosPeis(listaBeneficiarios, canvas);
				}	
			}
			
			canvas.showTextAligned(Element.ALIGN_LEFT, flujoEntrada != null && flujoEntrada.getFlujoValidacion() != null ? flujoEntrada.getFlujoValidacion() : ExpresionesConstants.VACIO, 60 ,230 , 0);
			canvas.showTextAligned(Element.ALIGN_LEFT,  !utileriaValidador.isEmpty(datosModificacion.getDatosBaseCurp().getSelloVoluntadTramite())  ? datosModificacion.getDatosBaseCurp().getSelloVoluntadTramite() : ExpresionesConstants.VACIO, 60 ,190 , 0);

			canvas.showTextAligned(Element.ALIGN_CENTER, utileriaCadena.obtenerCadenaConcatenada(false, objetoModificacion.getDatosBaseCurp().getApellidoPaterno(),ExpresionesConstants.ESPACIO,utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getApellidoMaterno()),ExpresionesConstants.ESPACIO,objetoModificacion.getDatosBaseCurp().getNombreTrabajador()), 430, 95, 0);
			canvas.showTextAligned(Element.ALIGN_CENTER, utileriaCadena.obtenerCadenaConcatenada(false, user.getApellidoPaterno(),ExpresionesConstants.ESPACIO,user.getApellidoMaterno(),ExpresionesConstants.ESPACIO,user.getSoloNombre()), 135, 95, 0);
			
			if(!utileriaValidador.validarVacio(datosModificacion.getFirmaAgente())) {
				Image image = Image.getInstance(Base64Utils.decodeFromString(datosModificacion.getFirmaAgente()));
				image.scaleAbsolute(155, 40);
				image.setAbsolutePosition(100, 110);
				image.setAnnotation(new Annotation(0, 0, 0, 0, 3));
				canvas.addImage(image);
			}
			
			if(!utileriaValidador.validarVacio(datosModificacion.getFirmaTrabajador())) {
				Image image = Image.getInstance(Base64Utils.decodeFromString(datosModificacion.getFirmaTrabajador()));
				image.scaleAbsolute(155, 40);
				image.setAbsolutePosition(400, 110);
				image.setAnnotation(new Annotation(0, 0, 0, 0, 3));
				canvas.addImage(image);
			}
			
			canvas.endText();
			canvas.restoreState();
			canvas.saveState();
			
			stamperPlantilla.close();
			plantilla.close();
			
			//Para escribir
			File archivoTemporal = new File(rutaTemporalParaEscribir);

			int tamanoArchivo = (int) archivoTemporal.length();
			int bytesLeidos = 0;
			contenido = new byte[tamanoArchivo];
			
			try (FileInputStream entrada = new FileInputStream(archivoTemporal)) {
				bytesLeidos = entrada.read(contenido);
			}

			if (bytesLeidos != tamanoArchivo) {
				logger.error(ExpresionesConstants.ERROR_LEER_TEMPORAL);
				throw new GenericException(ExpresionesConstants.ERROR_LEER_TEMPORAL);
			}
			
			result.setContenidoBytes(contenido);
			// Fin para generar los bytes del archivo total
			
			contenidoSolicModif = DatatypeConverter.printBase64Binary(contenido);
			FileOutputStream salida = new FileOutputStream(archivoTemporal);
			salida.write(DatatypeConverter.parseBase64Binary(contenidoSolicModif));
			salida.close();
			
			result.setRuta(contenidoSolicModif);
			result.setContenido(contenidoSolicModif);
			
		}catch(Exception e){
			if(stamperPlantilla != null){
				stamperPlantilla.close();
			}
			if(plantilla != null){
				plantilla.close();
			}	
			logger.error(ExpresionesConstants.ERROR_INESPERADO_PDF, e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return result;
	}
	
	
	/**
	 * Enviar los documentos adicionales obligatorios y no obligatorios
	 * @throws IOException 
	 */
	@Override
	public RespuestaServicio enviarArchivos(Map<String, Map<String, MultipartFile>> arregloArchivos, String solicitudModificacionDatosPdf ,EnvioArchivos datosRecepcion,Long idFolioHijo) throws IOException {
		logger.info("Inicio - enviarArchivos");
		logger.info("datosRecepcion: {}",datosRecepcion);
		RespuestaServicio respuestaServicio = null;
		FileOutputStream salida = null;
		try {
			String rutaArchivos = generarUrlGuardadoArchivosExpediente(datosRecepcion.getClaveAfore(), datosRecepcion.getProceso());
			String ruta = servicioArchivos.verificarRuta(datosRecepcion.getCurpTrabajador(),rutaArchivos);
			String fecha = fechaUtils.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_ARCHIVOS);
			logger.info("Se escribe los archivos adicionales en directorio");
			for(Map.Entry<String, Map<String, MultipartFile>> documento : arregloArchivos.entrySet()) {
				String llaveMap = documento.getKey();
				Map<String, MultipartFile> auxiliarValue = documento.getValue();
				
				int indice = 1;	
				for(String auxiliarArchivo : auxiliarValue.keySet()) {
					MultipartFile archivo = auxiliarValue.get(auxiliarArchivo);
					String extension = archivo.getOriginalFilename().substring(archivo.getOriginalFilename().indexOf(AgenteConstants.PUNTO));
					String renombre = utileriaCadena.obtenerCadenaConcatenada(true, datosRecepcion.getClaveAfore(), datosRecepcion.getProceso(), datosRecepcion.getCurpTrabajador(), datosRecepcion.getTipoTrabajador(), llaveMap, String.valueOf(indice), fecha,  datosRecepcion.getFolioIdentificacion(),extension.toLowerCase());
					File rutaSalida = new File(utileriaCadena.obtenerCadenaConcatenada(true, ruta,  ActivacionConstants.DIAGONAL, renombre));
					salida = new FileOutputStream(rutaSalida);
					salida.write(archivo.getBytes());
					salida.close();
					indice++;
				}
			}
			
			logger.info("Se escribe la solicitud de modificacion de datos en directorio");		
			String llaveMap = "69";
			String renombre = utileriaCadena.obtenerCadenaConcatenada(true, datosRecepcion.getClaveAfore(), datosRecepcion.getProceso(), datosRecepcion.getCurpTrabajador(), datosRecepcion.getTipoTrabajador(), llaveMap, "1", fecha,  datosRecepcion.getFolioIdentificacion() ,ExpresionesConstants.EXTENSION_PDF);
			File rutaSalida = new File(utileriaCadena.obtenerCadenaConcatenada(true, ruta,  ActivacionConstants.DIAGONAL, renombre));
			salida = new FileOutputStream(rutaSalida);
			salida.write(DatatypeConverter.parseBase64Binary(solicitudModificacionDatosPdf));
			salida.close();
			respuestaServicio = procesarSolicituModificacionDatos(datosRecepcion, ruta, fecha, solicitudModificacionDatosPdf, salida);
			
		} catch (FileNotFoundException fnfe) {
			servicioFolio.cerrarFolio(idFolioHijo, 2);
			logger.error("Ocurrio FileNotFoundException", fnfe);
			respuestaServicio = servicioArchivos.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
			
		} catch (IOException ioe) {
			servicioFolio.cerrarFolio(idFolioHijo, 2);
			logger.error("Ocurrio IOException", ioe);
			respuestaServicio = servicioArchivos.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
				
		} catch (GenericException ge) {
			servicioFolio.cerrarFolio(idFolioHijo, 2);
			logger.error("Ocurrio GenericException", ge);
			respuestaServicio = servicioArchivos.obtenerRespuesta(ge.getCodigo(), datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
			
		} catch (Exception e) {
			servicioFolio.cerrarFolio(idFolioHijo, 2);
			logger.error("Ocurrio un error inesperado " , e);
			respuestaServicio = servicioArchivos.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),  datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		}finally {
			if(!utileriaValidador.validarObjetoNulo(salida)) {
				salida.close();
			}
		}
		logger.info("Fin EnviarArchivos respuestaServicio: {}",respuestaServicio);
		return respuestaServicio;
	}
	
	/**
	 * Servicio de envio archivo zip 
	 */
	@Override
	public RespuestaAlta capturarArchivos(Archivos archivos, String ruta) {
		logger.info("Inicio- capturarArchivos");
		try {			
			HttpHeaders headerMedia = new HttpHeaders();
			headerMedia.setContentType(MediaType.APPLICATION_JSON);
			headerMedia.add("idCliente", idCliente);
			headerMedia.add("idServicio", idServicio);
			headerMedia.add("idEbusiness", idEbusiness);
			
			JsonUtilsImpl<Archivos> jsonEntrada = new JsonUtilsImpl<>();
			String resultadoJson = jsonEntrada.parseObjectToJsonSC(archivos);
		
			
			HttpEntity<String> entidadConsulta = new HttpEntity<>(resultadoJson, headerMedia);
			
			logger.info("Se ejecuta la recepcion de archivos {}, {}, {}", archivos.getCurpTrabajador(), archivos.getTipoArchivos(), archivos.getTipoExpediente());

			ResponseEntity<String> resultadoArchivos = servicioCliente.exchange(urlRecepcionArchivos, HttpMethod.POST, entidadConsulta, String.class);
			if(!utileriaValidador.validarVacio(resultadoArchivos.getBody())) {
				logger.info("La respuesta al servicio {} {} {}", archivos.getCurpTrabajador(), archivos.getTipoArchivos(), resultadoArchivos.getBody());
				JsonUtilsImpl<RespuestaAlta> resultado = new JsonUtilsImpl<>();
				return resultado.parseJsonToObject(resultadoArchivos.getBody(), RespuestaAlta.class);
				
			}
		} catch (Exception e) {
			logger.error("Se presneto un problema en el servicio de recepcion de archivos {}", urlRecepcionArchivos, e);
			if(!utileriaValidador.validarVacio(ruta)) {
				servicioArchivos.eliminarDirectorio(new File(ruta));
				servicioArchivos.eliminarDirectorio(new File(utileriaCadena.obtenerCadenaConcatenada(true, ruta, ExpresionesConstants.EXTENSION_ZIP)));
			}
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return null;
	}	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatosSolicitudModificacionPdf generarSolicitudDatosPDFBanorte(DatosTrabajador datosTrabajador, EntradaModificacion datosModificacion, BanderaDatosModificadosCertificables banderaDatosModif, String fechaNacimientoModificada, String entidadFederativaNacimientoModificada, String nacionalidadModificada,EntradaModificacion objetoModificacion,UsuarioLogin user) throws DocumentException, IOException {
		byte[] contenido = null;
		String contenidoSolicModif = null;
		PdfReader plantilla = null;
		PdfStamper stamperPlantilla = null;
		int index ;
		DatosSolicitudModificacionPdf result = new DatosSolicitudModificacionPdf();
		logger.info(ExpresionesConstants.ENTRADA_DATOS_TRABAJADOR,datosTrabajador);
		logger.info(ExpresionesConstants.ENTRADA_DATOS_MODIFICACION,datosModificacion) ;
		logger.info(ExpresionesConstants.BANDERA_DATOS_MODIFICACION,banderaDatosModif);
		logger.info(ExpresionesConstants.OBJETO_MODIFICACION,objetoModificacion);
		Referencia referencia1 = null;
		Referencia referencia2 = null;
		
		try{
			//Ruta Destino
			String tipoProcesoSolicitante = obtenerProcesoExpedienteServicio(datosTrabajador.getTipoSolicitante());
			//Ruta Destino
			String urlEnvio = generarUrlGuardadoArchivos(user.getAforeUsuario(), tipoProcesoSolicitante);
			String rutaTemporalParaEscribir = utileriaCadena.obtenerCadenaConcatenada(true, urlEnvio, banderaDatosModif.getFolioPadre().getChFolio(), tipoProcesoSolicitante,"69", ExpresionesConstants.EXTENSION_PDF);
			result.setRutaPdf(rutaTemporalParaEscribir);
			logger.error("Ruta solicitud banorte : {}",rutaTemporalParaEscribir);
			DatosComplementarios datosComplementarios = datosTrabajador.getDatosComplementarios();
			Domicilio particular = datosComplementarios.getParticular();
			Domicilio laboral = datosComplementarios.getLaboral();
			Telefono telefonos = datosComplementarios.getTelefonos();
			DatosNoCertificables datosNoCertificables = datosTrabajador.getDatosNoCertificables();
			if(!utileriaValidador.validarListaVacia(datosTrabajador.getDatosComplementarios().getListaReferencias())){
				 referencia1 = datosTrabajador.getDatosComplementarios().getListaReferencias().get(0);
				 referencia2 = datosTrabajador.getDatosComplementarios().getListaReferencias().get(1);
			}
			
			result.setNumeroPaginas(1);
			logger.info("referencias {} {}",referencia1,referencia2);
			logger.error("ruta banorte:: {}",rutaPlantillaBanorte);
			plantilla = new PdfReader(rutaPlantillaBanorte);
			stamperPlantilla = new PdfStamper(plantilla, new FileOutputStream(rutaTemporalParaEscribir));
			
			PdfContentByte canvas = stamperPlantilla.getOverContent(1);
			BaseFont baseFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			
			configurarPropiedadesTexto(canvas, baseFont,9f);
			
			String fechaRecepcionSolicitud = obtenerFechaEnFormato();
			
			String domicilioParticularTrabajadorPais = regresarPaisParticular(datosModificacion);
			String domicilioLaboralTrabajadorPais = regresarPaisLaboral(datosModificacion);
		
			String folioSolicitud = generarFolioSolicitud(banderaDatosModif.getFolioSolicitud());
			
			//Ejemplo de entrada 16 MADRINA
			String parentescoORelacionDeReferencia1 = ExpresionesConstants.VACIO;
			String parentescoORelacionDeReferencia2 = ExpresionesConstants.VACIO;
			if(datosModificacion.getDatosReferenciasTrabajador() != null){
				index = datosModificacion.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia1().indexOf(ExpresionesConstants.ESPACIO);
				parentescoORelacionDeReferencia1 = datosModificacion.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia1().substring(index++);
				
				index = datosModificacion.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia2().indexOf(ExpresionesConstants.ESPACIO);
				parentescoORelacionDeReferencia2 = datosModificacion.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia2().substring(index++);
			}	
			
			//Ejemplo de entrada 62 TRABAJADORES DE APOYO EN ACTIVIDADES ADMINISTRATIVAS
			String ocupacionOProfesionTrabajador = ExpresionesConstants.VACIO;
			if(!datosModificacion.getDatosBaseCurp().getOcupacionOProfesionTrabajador().isEmpty() && !datosModificacion.getDatosBaseCurp().getOcupacionOProfesionTrabajador().contains(ExpresionesConstants.TEXTO_SELECCIONE)){
				String[] partes = datosModificacion.getDatosBaseCurp().getOcupacionOProfesionTrabajador().split(ExpresionesConstants.ESPACIO);
				ocupacionOProfesionTrabajador = partes[0];
			}	
			
			//Ejemplo de entrada 12 ADMINISTRACION PUBLICA
			String actividadOGiroNegocioTrabajador = ExpresionesConstants.VACIO;
			if(!datosModificacion.getDatosBaseCurp().getActividadOGiroNegocioTrabajador().isEmpty() && !datosModificacion.getDatosBaseCurp().getActividadOGiroNegocioTrabajador().contains(ExpresionesConstants.TEXTO_SELECCIONE)){
				String[] partes = datosModificacion.getDatosBaseCurp().getActividadOGiroNegocioTrabajador().split(ExpresionesConstants.ESPACIO);
				actividadOGiroNegocioTrabajador = partes[0];
			}	
			
			//Ejemplo de entrada 05 CARRERA PROFESIONAL
			String nivelDeEstudioTrabajador = ExpresionesConstants.VACIO;
			if(!datosModificacion.getDatosBaseCurp().getNivelDeEstudioTrabajador().isEmpty() && !datosModificacion.getDatosBaseCurp().getNivelDeEstudioTrabajador().contains(ExpresionesConstants.TEXTO_SELECCIONE)){
				String[] partes = datosModificacion.getDatosBaseCurp().getNivelDeEstudioTrabajador().split(ExpresionesConstants.ESPACIO);
				nivelDeEstudioTrabajador = partes[0];
			}	
			
			
			canvas.showTextAligned(Element.ALIGN_LEFT, folioSolicitud, 485, 760, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, fechaRecepcionSolicitud, 510, 738, 0);
			
			canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getNss(),ExpresionesConstants.VACIO), 35, 705, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getCurpNueva().toUpperCase(), 245, 705, 0);
			
			if(!utileriaCadena.asignarValor(datosTrabajador.getDatosNoCertificables().getRfc()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getRfc()))){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getRfc().toUpperCase(), 475, 705, 0);
			}
			
			canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getApellidoPaterno().toUpperCase() , 100, 690, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.obtenerContenidoCadenaSinEspacios(datosModificacion.getDatosBaseCurp().getApellidoMaterno(), ExpresionesConstants.VACIO).toUpperCase(), 400, 690, 0);		
			canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getNombreTrabajador().toUpperCase() , 100, 675, 0);
			
			Date fechaNacimientoModificadaDate =  fechaUtils.convertirCadenaAFecha(datosModificacion.getDatosBaseCurp().getFechaDeNacimiento(),  FormatoConstants.FORMATO_SERVICIO_MODIFICACION) ;
			String fechaConFormato = fechaUtils.convertirFechaACadena(fechaNacimientoModificadaDate, FormatoConstants.FORMATO_FECHA_NACIMIENTO);
			canvas.showTextAligned(Element.ALIGN_LEFT, fechaConFormato , 80, 658, 0);			
			canvas.showTextAligned(Element.ALIGN_LEFT, "FEMENINO".equalsIgnoreCase(datosModificacion.getDatosBaseCurp().getSexo()) ? "X" : ExpresionesConstants.VACIO , 60, 640, 0); 
			canvas.showTextAligned(Element.ALIGN_LEFT, "MASCULINO".equalsIgnoreCase(datosModificacion.getDatosBaseCurp().getSexo()) ? "X" : ExpresionesConstants.VACIO , 88, 640, 0); 
			
			String entidadFederativaNacimiento = datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento().substring(datosModificacion.getDatosBaseCurp().getEntidadFederativaDeNacimiento().indexOf(ExpresionesConstants.ESPACIO)); 
			canvas.showTextAligned(Element.ALIGN_LEFT, entidadFederativaNacimiento, 248, 655, 0); 
			canvas.showTextAligned(Element.ALIGN_LEFT, nacionalidadModificada , 472, 655, 0); 
			
			BanderaDatosModificadosDomicilios modificacionDomicilioParticular = new BanderaDatosModificadosDomicilios();
			modificacionDomicilioParticular.setModificadoCalle(true);
			modificacionDomicilioParticular.setModificadoColonia(true);
			modificacionDomicilioParticular.setModificadoMunicipio(true);
			modificacionDomicilioParticular.setModificadoEntidadFederativa(true);
			modificacionDomicilioParticular.setModificadoNoExterior(true);
			modificacionDomicilioParticular.setModificadoNoInterior(true);
			modificacionDomicilioParticular.setModificadoCodigoPostal(true);
			modificacionDomicilioParticular.setModificadoPais(true);
			modificacionDomicilioParticular.setModificadoTelefonoFijo(true);
			modificacionDomicilioParticular.setModificadoCelular(true);
			modificacionDomicilioParticular.setModificadoCorreoElectronico(true);

			if(datosModificacion.getDatosDomicilioParticularTrabajador() != null){
					if(utileriaValidador.validarObjetoNulo(particular)){
						particular = new Domicilio();
					}
					
					if(utileriaValidador.validarObjetoNulo(telefonos)){
						telefonos = new Telefono();
					}
					
				
				
				if(!utileriaCadena.asignarValor(particular.getCalle()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getCalle()))){
					modificacionDomicilioParticular.setModificadoCalle(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getCalle().toUpperCase(), 50, 610, 0); 
				}
				if(!utileriaCadena.asignarValor(particular.getColonia()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getColonia()))){
					modificacionDomicilioParticular.setModificadoColonia(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getColonia().toUpperCase(), 350, 600, 0); 
				}
				if(!utileriaCadena.asignarValor(particular.getMunicipio()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getDelegacionOMunicipio()))){
					modificacionDomicilioParticular.setModificadoMunicipio(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getDelegacionOMunicipio() , 126, 585, 0);
				}
				
				if(!utileriaCadena.asignarValor(particular.getEntidadFederativa()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getEntidadFederativa()))){
					modificacionDomicilioParticular.setModificadoEntidadFederativa(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getEntidadFederativa() , 375, 572, 0);
				}
				
				if(!utileriaCadena.asignarValor(particular.getNoExterior()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getNumeroExterior()))){
					modificacionDomicilioParticular.setModificadoNoExterior(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getNumeroExterior() , 100, 600, 0);
				}
				
				if(!utileriaCadena.asignarValor(particular.getNoInterior()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getNumeroInterior()))){
					modificacionDomicilioParticular.setModificadoNoInterior(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getNumeroInterior() , 250, 600, 0);
				}
				
				if(!utileriaCadena.asignarValor(particular.getCodigoPostal()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getCodigoPostal()))){
					modificacionDomicilioParticular.setModificadoCodigoPostal(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getCodigoPostal() , 375, 585, 0);
				}
				if(!utileriaCadena.asignarValor(particular.getClavePais()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getPais()))){
					modificacionDomicilioParticular.setModificadoPais(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, domicilioParticularTrabajadorPais , 464, 585, 0); 
				}
				
				if(!utileriaCadena.asignarValor(telefonos.getTelefonoFijo()).equalsIgnoreCase(objetoModificacion.getDatosDomicilioParticularTrabajador().getTelefono1())){
					modificacionDomicilioParticular.setModificadoTelefonoFijo(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getTelefono1() , 90, 545, 0);
				}
				if(!utileriaCadena.asignarValor(telefonos.getCelular()).equalsIgnoreCase(objetoModificacion.getDatosDomicilioParticularTrabajador().getTelefono2())){
					modificacionDomicilioParticular.setModificadoCelular(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getTelefono2() , 450, 545, 0);
				}
				if(!utileriaCadena.asignarValor(datosComplementarios.getCorreoElectronico()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getCorreoElectronicoDelTrabajador()))){
					modificacionDomicilioParticular.setModificadoCorreoElectronico(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getCorreoElectronicoDelTrabajador() , 95, 560, 0);
				}
			}
			
			
			BanderaDatosModificadosDomicilios modificacionDomicilioLaboral = new BanderaDatosModificadosDomicilios();
			modificacionDomicilioLaboral.setModificadoCalle(true);
			modificacionDomicilioLaboral.setModificadoColonia(true);
			modificacionDomicilioLaboral.setModificadoMunicipio(true);
			modificacionDomicilioLaboral.setModificadoEntidadFederativa(true);
			modificacionDomicilioLaboral.setModificadoNoExterior(true);
			modificacionDomicilioLaboral.setModificadoNoInterior(true);
			modificacionDomicilioLaboral.setModificadoCodigoPostal(true);
			modificacionDomicilioLaboral.setModificadoPais(true);
			if(datosModificacion.getDatosDomicilioLaboralTrabajador() != null){	
				
				if(utileriaValidador.validarObjetoNulo(laboral)){
					laboral = new Domicilio();
				}

				
				if(!utileriaCadena.asignarValor(laboral.getCalle()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioLaboralTrabajador().getCalle()))){
					modificacionDomicilioLaboral.setModificadoCalle(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getCalle().toUpperCase() , 50 , 512, 0);
				}
				
				if(!utileriaCadena.asignarValor(laboral.getColonia()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioLaboralTrabajador().getColonia()))){
					modificacionDomicilioLaboral.setModificadoColonia(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getColonia().toUpperCase(), 350 , 500, 0);
				}
				
				if(!utileriaCadena.asignarValor(laboral.getMunicipio()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioLaboralTrabajador().getDelegacionOMunicipio()))){
					modificacionDomicilioLaboral.setModificadoMunicipio(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getDelegacionOMunicipio() , 126 , 485, 0);
				}
				
				if(!utileriaCadena.asignarValor(laboral.getEntidadFederativa()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioLaboralTrabajador().getEntidadFederativa()))){
					modificacionDomicilioLaboral.setModificadoEntidadFederativa(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getEntidadFederativa() , 375 , 470, 0);
				}
				
				if(!utileriaCadena.asignarValor(laboral.getNoExterior()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioLaboralTrabajador().getNumeroExterior()))){
					modificacionDomicilioLaboral.setModificadoNoExterior(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getNumeroExterior(), 100 , 498, 0);
				}
				
				if(!utileriaCadena.asignarValor(laboral.getNoInterior()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioLaboralTrabajador().getNumeroInterior()))){
					modificacionDomicilioLaboral.setModificadoNoInterior(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getNumeroInterior(), 250 , 498, 0);
				}
				
				if(!utileriaCadena.asignarValor(laboral.getCodigoPostal()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioLaboralTrabajador().getCodigoPostal()))){
					modificacionDomicilioLaboral.setModificadoCodigoPostal(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioLaboralTrabajador().getCodigoPostal(), 375 , 485, 0);
				}
				
				if(!utileriaCadena.asignarValor(laboral.getClavePais()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioLaboralTrabajador().getPais()))){
					modificacionDomicilioLaboral.setModificadoPais(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, domicilioLaboralTrabajadorPais , 464 , 485, 0); 
				}
			}
			
			if(utileriaValidador.validarObjetoNulo(datosNoCertificables)){
				datosNoCertificables = new DatosNoCertificables();
			}
			
			if(!utileriaCadena.asignarValor(datosNoCertificables.getClaveOcupacion()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getOcupacionOProfesionTrabajador()))){
				banderaDatosModif.setModificadoOcupacion(false);
				canvas.showTextAligned(Element.ALIGN_LEFT, ocupacionOProfesionTrabajador, 490 , 640, 0);
			}
			if(!utileriaCadena.asignarValor(datosNoCertificables.getClaveGiro()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getActividadOGiroNegocioTrabajador()))){
				banderaDatosModif.setModificadoActividadEconomica(false);
				canvas.showTextAligned(Element.ALIGN_LEFT, actividadOGiroNegocioTrabajador, 350 , 640, 0);
			}
			if(!utileriaCadena.asignarValor(datosNoCertificables.getEstudios()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getNivelDeEstudioTrabajador()))){
				banderaDatosModif.setModificadoNivelEstudios(false);
				canvas.showTextAligned(Element.ALIGN_LEFT, nivelDeEstudioTrabajador, 175 , 640, 0);
			}
			
			BanderaDatosModificadosReferencias modificacionReferencia1 = new BanderaDatosModificadosReferencias();
			modificacionReferencia1.setModificacionCurp(true);
			modificacionReferencia1.setModificacionNombre(true);
			modificacionReferencia1.setModificacionApellidoPaterno(true);
			modificacionReferencia1.setModificacionApellidoMaterno(true);
			modificacionReferencia1.setModificacionTelefono(true);
			modificacionReferencia1.setModificacionParentesco(true);
			BanderaDatosModificadosReferencias modificacionReferencia2 = new BanderaDatosModificadosReferencias();
			modificacionReferencia2.setModificacionCurp(true);
			modificacionReferencia2.setModificacionNombre(true);
			modificacionReferencia2.setModificacionApellidoPaterno(true);
			modificacionReferencia2.setModificacionApellidoMaterno(true);
			modificacionReferencia2.setModificacionTelefono(true);
			modificacionReferencia2.setModificacionParentesco(true);
			if(datosModificacion.getDatosReferenciasTrabajador() != null){

				if(utileriaValidador.validarObjetoNulo(referencia1)){
					referencia1 = new Referencia();
				}
				
				if(utileriaValidador.validarObjetoNulo(referencia2)){
					referencia2 = new Referencia();
				}
				
				if(!utileriaCadena.asignarValor(referencia1.getNombre()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getNombreDeReferencia1()))){
					modificacionReferencia1.setModificacionNombre(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getNombreDeReferencia1().toUpperCase(), 115 , 410, 0);  
				}
				
				if(!utileriaCadena.asignarValor(referencia1.getApellidoPaterno()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getApellidoPaternoDeReferencia1()))){
					modificacionReferencia1.setModificacionApellidoPaterno(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getApellidoPaternoDeReferencia1().toUpperCase(), 115 , 425, 0); 
				}
				
				if(!utileriaCadena.asignarValor(referencia1.getApellidoMaterno()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getApellidoMaternoDeReferencia1()))){
					modificacionReferencia1.setModificacionApellidoMaterno(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getApellidoMaternoDeReferencia1().toUpperCase(), 400 , 425, 0); 
				}
				
				if(!utileriaCadena.asignarValor(referencia1.getCurp()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getCurpDeReferencia1()))){
					modificacionReferencia1.setModificacionCurp(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getCurpDeReferencia1(), 110 , 395, 0);
				}
				
				if(!utileriaCadena.asignarValor(referencia1.getClaveParentesco()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia1()))){
					modificacionReferencia1.setModificacionParentesco(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, parentescoORelacionDeReferencia1, 325 , 395, 0);
				}
				if(!utileriaCadena.asignarValor(referencia1.getTelefono()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getTelefonoDeReferencia1()))){
					modificacionReferencia1.setModificacionTelefono(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getTelefonoDeReferencia1(),  460, 395, 0);
				}
			
				if(!utileriaCadena.asignarValor(referencia2.getNombre()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getNombreDeReferencia2()))){
					modificacionReferencia2.setModificacionNombre(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getNombreDeReferencia2().toUpperCase(), 115 , 365, 0);  
				}
				
				if(!utileriaCadena.asignarValor(referencia2.getApellidoPaterno()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getApellidoPaternoDeReferencia2()))){
					modificacionReferencia2.setModificacionApellidoPaterno(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getApellidoPaternoDeReferencia2().toUpperCase(), 115 , 378, 0); 
				}
				
				if(!utileriaCadena.asignarValor(referencia2.getApellidoMaterno()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getApellidoMaternoDeReferencia2()))){
					modificacionReferencia2.setModificacionApellidoMaterno(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getApellidoMaternoDeReferencia2().toUpperCase(), 400 , 378, 0); 
				}
				
				if(!utileriaCadena.asignarValor(referencia2.getCurp()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getCurpDeReferencia2()))){
					modificacionReferencia2.setModificacionCurp(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getCurpDeReferencia2(), 110 , 352, 0);
				}
				
				if(!utileriaCadena.asignarValor(referencia2.getClaveParentesco()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getParentescoORelacionDeReferencia2()))){
					modificacionReferencia2.setModificacionParentesco(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, parentescoORelacionDeReferencia2, 330 , 352, 0);
				}
				
				if(!utileriaCadena.asignarValor(referencia2.getTelefono()).equals(utileriaCadena.asignarValor(objetoModificacion.getDatosReferenciasTrabajador().getTelefonoDeReferencia2()))){
					modificacionReferencia2.setModificacionTelefono(false);
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosReferenciasTrabajador().getTelefonoDeReferencia2(), 460 , 352, 0);
				}
			}
			
			Boolean respuestaCambios = validaArregloCambiosBeneficiarios(datosComplementarios, datosModificacion.getListaBeneficiariosTrabajador(),datosModificacion,null);
			logger.info("validaArregloCambiosBeneficiarios {}",respuestaCambios);
			canvas.showTextAligned(Element.ALIGN_LEFT, Boolean.FALSE.equals(respuestaCambios) ? "X" : ExpresionesConstants.VACIO , 230, 735, 0); 

			Boolean respuestaCertificables = validarReportablesBanorte(banderaDatosModif);
			logger.info("validarReportablesBanorte {}",respuestaCertificables);
			canvas.showTextAligned(Element.ALIGN_LEFT, Boolean.FALSE.equals(respuestaCertificables) ? "X" : ExpresionesConstants.VACIO , 19, 735, 0); 

			boolean resultadoParticularUno = validarDatosNoCertificablesDomiciliUno(modificacionDomicilioParticular);
			logger.info("validarDatosNoCertificablesDomiciliUno {}",resultadoParticularUno);
			boolean resultadoParticularDos = validarDatosNoCertificablesDomicilioParticularDos(modificacionDomicilioParticular);
			logger.info("validarDatosNoCertificablesDomicilioParticularDos {}",resultadoParticularDos);
			boolean resultadoLaboralUno = validarDatosNoCertificablesDomiciliUno(modificacionDomicilioLaboral);
			logger.info("validarDatosNoCertificablesDomiciliUno {}",resultadoLaboralUno);
			boolean resultadoLaboralDos = validarDatosNoCertificablesDomicilioLaboralDos(modificacionDomicilioLaboral);
			logger.info("validarDatosNoCertificablesDomicilioLaboralDos {}",resultadoLaboralDos);
			boolean resultadoReferenciaUno = validarDatosReferencia(modificacionReferencia1);
			logger.info("validarDatosReferencia {}",resultadoReferenciaUno);
			boolean resultadoReferenciaDos = validarDatosReferencia(modificacionReferencia2);
			logger.info("validarDatosReferencia {}",resultadoReferenciaDos);
			
			Boolean validacionNoCertificables = validarResultadosNoCertificablesBanorte(resultadoParticularUno, resultadoParticularDos, resultadoLaboralUno, resultadoLaboralDos, resultadoReferenciaUno, resultadoReferenciaDos);
			logger.info("validarResultadosNoCertificablesBanorte {}",validacionNoCertificables);
			canvas.showTextAligned(Element.ALIGN_LEFT, Boolean.FALSE.equals(validacionNoCertificables) ? "X" : ExpresionesConstants.VACIO , 125, 735, 0); 

			
			canvas.showTextAligned(Element.ALIGN_CENTER, utileriaCadena.obtenerCadenaConcatenada(false, objetoModificacion.getDatosBaseCurp().getApellidoPaterno(),
					ExpresionesConstants.ESPACIO,utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getApellidoMaterno()),ExpresionesConstants.ESPACIO,objetoModificacion.getDatosBaseCurp().getNombreTrabajador()), 410, 200, 0);
			
			canvas.showTextAligned(Element.ALIGN_CENTER, utileriaCadena.obtenerCadenaConcatenada(false, user.getApellidoPaterno(),ExpresionesConstants.ESPACIO,user.getApellidoMaterno(),ExpresionesConstants.ESPACIO,user.getSoloNombre()), 110, 200, 0);
			
		if(!utileriaValidador.validarVacio(datosModificacion.getFirmaAgente())) {
			Image image = Image.getInstance(Base64Utils.decodeFromString(datosModificacion.getFirmaAgente()));
			image.scaleAbsolute(145, 30);
			image.setAbsolutePosition(70, 210);
			image.setAnnotation(new Annotation(0, 0, 0, 0, 3));
			canvas.addImage(image);
		}
		
		if(!utileriaValidador.validarVacio(datosModificacion.getFirmaTrabajador())) {
			Image image = Image.getInstance(Base64Utils.decodeFromString(datosModificacion.getFirmaTrabajador()));
			image.scaleAbsolute(145, 30);
			image.setAbsolutePosition(370, 210);
			image.setAnnotation(new Annotation(0, 0, 0, 0, 3));
			canvas.addImage(image);
		}
			
			canvas.endText();
			canvas.restoreState();
			canvas.saveState();
			

			
			stamperPlantilla.close();
			plantilla.close();
			
			//Para escribir
			File archivoTemporal = new File(rutaTemporalParaEscribir);


			int tamanoArchivo = (int) archivoTemporal.length();
			int bytesLeidos = 0;
			contenido = new byte[tamanoArchivo];
			
			try (FileInputStream entrada = new FileInputStream(archivoTemporal)) {
				bytesLeidos = entrada.read(contenido);
			}

			if (bytesLeidos != tamanoArchivo) {
				logger.error(ExpresionesConstants.ERROR_LEER_TEMPORAL);
				throw new GenericException(ExpresionesConstants.ERROR_LEER_TEMPORAL);
			}
			
			result.setContenidoBytes(contenido);
			// Fin para generar los bytes del archivo total
			//Cadena base 64 oara mostrar en pdf.js
			contenidoSolicModif = DatatypeConverter.printBase64Binary(contenido);
			FileOutputStream salida = new FileOutputStream(archivoTemporal);
			salida.write(DatatypeConverter.parseBase64Binary(contenidoSolicModif));
			salida.close();
			
			result.setRuta(contenidoSolicModif);
			result.setContenido(contenidoSolicModif);
			
		}catch(Exception e){
			if(stamperPlantilla != null){
				stamperPlantilla.close();
			}
			if(plantilla != null){
				plantilla.close();
			}	
			logger.error(ExpresionesConstants.ERROR_INESPERADO_PDF, e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatosSolicitudModificacionPdf generarSolicitudDatosPDFCoppel(DatosTrabajador datosTrabajador, EntradaModificacion datosModificacion, BanderaDatosModificadosCertificables banderaDatosModif, String fechaNacimientoModificada, String entidadFederativaNacimientoModificada, String nacionalidadModificada,EntradaModificacion objetoModificacion,UsuarioLogin user,EntradaSolicitante entradaSolicitante,String banderaCheck) throws DocumentException, IOException {
		byte[] contenido = null;
		String contenidoSolicModif = null;
		PdfReader plantilla = null;
		PdfStamper stamperPlantilla = null;
		DatosSolicitudModificacionPdf result = new DatosSolicitudModificacionPdf();
		logger.info(ExpresionesConstants.ENTRADA_DATOS_TRABAJADOR,datosTrabajador);
		logger.info(ExpresionesConstants.ENTRADA_DATOS_MODIFICACION,datosModificacion) ;
		logger.info(ExpresionesConstants.BANDERA_DATOS_MODIFICACION,banderaDatosModif);
		logger.info(ExpresionesConstants.OBJETO_MODIFICACION,objetoModificacion);
		Referencia referencia1 = null;
		Referencia referencia2 = null;
		FileOutputStream salida = null;
		
		try{
			//Ruta Destino
			String urlEnvio = generarUrlGuardadoArchivos(user.getAforeUsuario(), "46");

			String rutaTemporalParaEscribir = utileriaCadena.obtenerCadenaConcatenada(true,urlEnvio, banderaDatosModif.getFolioPadre().getChFolio(), "4669", ExpresionesConstants.EXTENSION_PDF);
			logger.info("Ruta solicitud coppel : {}",rutaTemporalParaEscribir);
			DatosCertificables datosCertificables = datosTrabajador.getDatosCertificables();
			DatosComplementarios datosComplementarios = datosTrabajador.getDatosComplementarios();
			Domicilio particular = datosComplementarios.getParticular();
			Telefono telefonos = datosComplementarios.getTelefonos();
			DatosNoCertificables datosNoCertificables = datosTrabajador.getDatosNoCertificables();
			if(!utileriaValidador.validarListaVacia(datosTrabajador.getDatosComplementarios().getListaReferencias())){
				 referencia1 = datosTrabajador.getDatosComplementarios().getListaReferencias().get(0);
				 referencia2 = datosTrabajador.getDatosComplementarios().getListaReferencias().get(1);
			}
			
			result.setNumeroPaginas(1);
			logger.info("referencias {} {}",referencia1,referencia2);
			
			plantilla = new PdfReader(rutaPlantillaCoppel);
			stamperPlantilla = new PdfStamper(plantilla, new FileOutputStream(rutaTemporalParaEscribir));
			
			PdfContentByte canvas = stamperPlantilla.getOverContent(1);
			BaseFont baseFont = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			
			configurarPropiedadesTexto(canvas, baseFont,8f);
		
			
			String fechaRecepcionSolicitud = obtenerFechaEnFormato();
			
			String domicilioParticularTrabajadorPais = regresarPaisParticular(datosModificacion);
			String ocupacionOProfesionTrabajador = regresarOcupacion(datosModificacion);
			String actividadOGiroNegocioTrabajador = regresaraGiro(datosModificacion);
			String nivelDeEstudioTrabajador = regresarNivelEstudios(datosModificacion);
			
			canvas.showTextAligned(Element.ALIGN_LEFT, banderaDatosModif.getFolioPadre().getChFolio(), 490, 757, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, fechaRecepcionSolicitud, 510, 744, 0);
			
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getNombre()== null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getNombre(), 105, 665, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getApellidoPaterno() == null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getApellidoPaterno(), 105, 700, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getApellidoMaterno() == null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getApellidoMaterno(), 105, 685, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getDatosCertificables().getCurp()== null ? ExpresionesConstants.VACIO : datosTrabajador.getDatosCertificables().getCurp(), 353, 700, 0);
			canvas.showTextAligned(Element.ALIGN_LEFT, datosTrabajador.getNss()== null ? ExpresionesConstants.VACIO : datosTrabajador.getNss(), 353, 685, 0);
			

			if(!utileriaCadena.asignarValor(datosCertificables.getCurp()).equalsIgnoreCase(objetoModificacion.getDatosBaseCurp().getCurpNueva())){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getCurpNueva(), 353, 605, 0);

			}
			
			if(!utileriaCadena.asignarValor(datosTrabajador.getDatosNoCertificables().getRfc()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getRfc()))){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getRfc().toUpperCase(), 353, 590, 0);
			}
			
			if(!datosCertificables.getApellidoPaterno().equalsIgnoreCase(objetoModificacion.getDatosBaseCurp().getApellidoPaterno())){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getApellidoPaterno().toUpperCase() , 95, 635, 0);
			}
			if(!utileriaCadena.asignarValor(datosCertificables.getApellidoMaterno()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getApellidoMaterno()))){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getApellidoMaterno().toUpperCase(), 95, 620, 0);
			}
			
			if(!datosCertificables.getNombre().equalsIgnoreCase(objetoModificacion.getDatosBaseCurp().getNombreTrabajador())){
				canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getNombreTrabajador().toUpperCase() , 86, 605, 0);
			}
			
			Date fechaNacimientoModificadaDate =  fechaUtils.convertirCadenaAFecha(datosCertificables.getFechaNacimiento(),  FormatoConstants.FORMATO_FECHA_NACIMIENTO) ;
			String fechaNacimientoTrabajador = fechaUtils.convertirFechaACadena(fechaNacimientoModificadaDate, FormatoConstants.FORMATO_SERVICIO_MODIFICACION);
			fechaNacimientoTrabajador = utileriaValidador.validarVacio(fechaNacimientoTrabajador) ?  "0000-00-00" : fechaNacimientoTrabajador;
			String fechaNacimientoBD = fechaUtils.ObtenerFechas(fechaNacimientoTrabajador);
			String fechaNacimientoModificacion = fechaUtils.ObtenerFechas(objetoModificacion.getDatosBaseCurp().getFechaDeNacimiento());
			if(!fechaNacimientoBD.equalsIgnoreCase(fechaNacimientoModificacion)){
				canvas.showTextAligned(Element.ALIGN_LEFT, fechaNacimientoModificada , 110, 590, 0);
			}
			
			canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosBaseCurp().getSexo().toUpperCase(), 353, 635, 0); 
			canvas.showTextAligned(Element.ALIGN_LEFT, entidadFederativaNacimientoModificada, 110, 570, 0); 
			canvas.showTextAligned(Element.ALIGN_LEFT, nacionalidadModificada , 370, 620, 0); 
			
			if(datosModificacion.getDatosDomicilioParticularTrabajador() != null){
					if(utileriaValidador.validarObjetoNulo(particular)){
						particular = new Domicilio();
					}
					
					if(utileriaValidador.validarObjetoNulo(telefonos)){
						telefonos = new Telefono();
					}
					
				
				
				if(!utileriaCadena.asignarValor(particular.getCalle()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getCalle()))){
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getCalle().toUpperCase(), 65, 540, 0); 
				}
				if(!utileriaCadena.asignarValor(particular.getColonia()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getColonia()))){
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getColonia().toUpperCase(), 350, 540, 0); 
				}
				if(!utileriaCadena.asignarValor(particular.getMunicipio()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getDelegacionOMunicipio()))){
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getDelegacionOMunicipio() ,50, 525, 0);
				}
				
				if(!utileriaCadena.asignarValor(particular.getEntidadFederativa()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getEntidadFederativa()))){
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getEntidadFederativa() ,230,525, 0);
				}
				
				if(!utileriaCadena.asignarValor(particular.getNoExterior()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getNumeroExterior()))){
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getNumeroExterior() , 230, 540, 0);
				}
				
				if(!utileriaCadena.asignarValor(particular.getNoInterior()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getNumeroInterior()))){
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getNumeroInterior() , 300, 540, 0);
				}
				
				if(!utileriaCadena.asignarValor(particular.getCodigoPostal()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getCodigoPostal()))){
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getCodigoPostal() , 450, 525, 0);
				}
				if(!utileriaCadena.asignarValor(particular.getClavePais()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getPais()))){
					canvas.showTextAligned(Element.ALIGN_LEFT, domicilioParticularTrabajadorPais , 350, 525, 0); 
				}
				
				if(!utileriaCadena.asignarValor(telefonos.getTelefonoFijo()).equalsIgnoreCase(objetoModificacion.getDatosDomicilioParticularTrabajador().getTelefono1())){
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getTelefono1() , 75, 430, 0);
				}
				if(!utileriaCadena.asignarValor(telefonos.getCelular()).equalsIgnoreCase(objetoModificacion.getDatosDomicilioParticularTrabajador().getTelefono2())){
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getTelefono2() , 75, 415, 0);
				}
				if(!utileriaCadena.asignarValor(datosComplementarios.getCorreoElectronico()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosDomicilioParticularTrabajador().getCorreoElectronicoDelTrabajador()))){
					canvas.showTextAligned(Element.ALIGN_LEFT, datosModificacion.getDatosDomicilioParticularTrabajador().getCorreoElectronicoDelTrabajador() , 390, 430, 0);
				}
			}
			
			if(utileriaValidador.validarObjetoNulo(datosNoCertificables)){
				datosNoCertificables = new DatosNoCertificables();
			}
			
			if(!utileriaCadena.asignarValor(datosNoCertificables.getClaveOcupacion()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getOcupacionOProfesionTrabajador()))){
				StringBuilder nuevaOcupacionUno = new StringBuilder();
				StringBuilder nuevaOcupacionDos = new StringBuilder();
				String[] arregeloOcupacion = ocupacionOProfesionTrabajador.split(" ");
				Integer longitudOcupacion = arregeloOcupacion.length;
				logger.info("longitudOcupacion: {}",longitudOcupacion);
				if(arregeloOcupacion.length > 11) {
					for (int i = 0; i < arregeloOcupacion.length; i++) {
						if(i <= 9) {
							nuevaOcupacionUno.append(utileriaCadena.obtenerCadenaConcatenada(false, arregeloOcupacion[i]," "));
						}else {
							nuevaOcupacionDos.append(utileriaCadena.obtenerCadenaConcatenada(false, arregeloOcupacion[i]," "));
						}
					}
					canvas.showTextAligned(Element.ALIGN_LEFT, nuevaOcupacionUno.toString(),100 , 350, 0);
					canvas.showTextAligned(Element.ALIGN_LEFT, nuevaOcupacionDos.toString(),100 , 340, 0);

				}else {
					canvas.showTextAligned(Element.ALIGN_LEFT, ocupacionOProfesionTrabajador,100 , 350, 0);
				}
			}
			if(!utileriaCadena.asignarValor(datosNoCertificables.getClaveGiro()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getActividadOGiroNegocioTrabajador()))){
				canvas.showTextAligned(Element.ALIGN_LEFT, actividadOGiroNegocioTrabajador,100 , 380, 0);
			}
			if(!utileriaCadena.asignarValor(datosNoCertificables.getEstudios()).equalsIgnoreCase(utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getNivelDeEstudioTrabajador()))){
				canvas.showTextAligned(Element.ALIGN_LEFT, nivelDeEstudioTrabajador,100 , 365, 0);
			}
			
			if("01".equals(datosTrabajador.getTipoSolicitante())) {
				canvas.showTextAligned(Element.ALIGN_CENTER, utileriaCadena.obtenerCadenaConcatenada(false, objetoModificacion.getDatosBaseCurp().getApellidoPaterno(),
						ExpresionesConstants.ESPACIO,utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getApellidoMaterno()),ExpresionesConstants.ESPACIO,objetoModificacion.getDatosBaseCurp().getNombreTrabajador()), 450, 90, 0);
			}
			canvas.showTextAligned(Element.ALIGN_CENTER, utileriaCadena.obtenerCadenaConcatenada(false, user.getApellidoPaterno(),ExpresionesConstants.ESPACIO,user.getApellidoMaterno(),ExpresionesConstants.ESPACIO,user.getSoloNombre()), 150, 90, 0);

			if(!utileriaValidador.validarVacio(banderaCheck)) {
				canvas.showTextAligned(Element.ALIGN_CENTER, "Trabajador decidió no designar Beneficiarios", 120, 295, 0);
			}
			if(!utileriaValidador.validarObjetoNulo(datosModificacion.getListaBeneficiariosTrabajador())){
				List<DatosBeneficiarioTrabajador> listaBeneficiarios = datosModificacion.getListaBeneficiariosTrabajador().getBeneficiario();
				if(!utileriaValidador.validarListaVacia(listaBeneficiarios)){		
					regresarBeneficiariosCoppel(listaBeneficiarios, canvas,datosComplementarios.getListaBeneficiario());
				}	
			}
			
			if(!"01".equals(datosTrabajador.getTipoSolicitante())) {
				canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(entradaSolicitante.getDatosGeneralesSolicitante().getApellidoPaterno()).toUpperCase(), 25 , 190, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(entradaSolicitante.getDatosGeneralesSolicitante().getApellidoMaterno()).toUpperCase(), 120 , 190, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(entradaSolicitante.getDatosGeneralesSolicitante().getNombre()).toUpperCase(), 210 , 190, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(obtenerFiguraTercero(datosTrabajador.getTipoSolicitante())), 330 , 190, 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(entradaSolicitante.getDatosGeneralesSolicitante().getCurp()), 450 , 190, 0);
				canvas.showTextAligned(Element.ALIGN_CENTER, utileriaCadena.obtenerCadenaConcatenada(false, entradaSolicitante.getDatosGeneralesSolicitante().getApellidoPaterno(),
						ExpresionesConstants.ESPACIO,utileriaCadena.asignarValor(entradaSolicitante.getDatosGeneralesSolicitante().getApellidoMaterno()),ExpresionesConstants.ESPACIO,entradaSolicitante.getDatosGeneralesSolicitante().getNombre()), 450, 90, 0);
			}
					
 		if(!utileriaValidador.validarVacio(datosModificacion.getFirmaAgente())) {
			Image image = Image.getInstance(Base64Utils.decodeFromString(datosModificacion.getFirmaAgente()));
			image.scaleAbsolute(145, 30);
			image.setAbsolutePosition(86, 110);
			image.setAnnotation(new Annotation(0, 0, 0, 0, 3));
			canvas.addImage(image);
		}
		
		if(!utileriaValidador.validarVacio(datosModificacion.getFirmaTrabajador())) {
			Image image = Image.getInstance(Base64Utils.decodeFromString(datosModificacion.getFirmaTrabajador()));
			image.scaleAbsolute(145, 30);
			image.setAbsolutePosition(390, 110);
			image.setAnnotation(new Annotation(0, 0, 0, 0, 3));
			canvas.addImage(image);
		}
			
			canvas.endText();
			canvas.restoreState();
			canvas.saveState();
			

			
			stamperPlantilla.close();
			plantilla.close();
			
			//Para escribir
			File archivoTemporal = new File(rutaTemporalParaEscribir);

			//Generando Imagen
//			PDDocument documento = PDDocument.load(archivoTemporal);
//			PDFRenderer renderer = new PDFRenderer(documento);
//			ByteArrayOutputStream outputfile = new ByteArrayOutputStream();
			
			//Pagina 1
//			BufferedImage image1 = renderer.renderImageWithDPI(NumerosConstants.INT_CERO, 300);
//			ImageIO.write(image1, "png", outputfile);
			
//			outputfile.flush();
//			byte[] imagenByte1 = outputfile.toByteArray();
//			outputfile.close();

			

//			String imagenSolicModifPagina1 = DatatypeConverter.printBase64Binary(imagenByte1);
//			result.setPagina1(imagenSolicModifPagina1);

			int tamanoArchivo = (int) archivoTemporal.length();
			int bytesLeidos = 0;
			contenido = new byte[tamanoArchivo];
			
			try (FileInputStream entrada = new FileInputStream(archivoTemporal)) {
				bytesLeidos = entrada.read(contenido);
			}
			result.setContenidoBytes(contenido);
			if (bytesLeidos != tamanoArchivo) {
				logger.error(ExpresionesConstants.ERROR_LEER_TEMPORAL);
				throw new GenericException(ExpresionesConstants.ERROR_LEER_TEMPORAL);
			}
			// Fin para generar los bytes del archivo total
			
			contenidoSolicModif = DatatypeConverter.printBase64Binary(contenido);
			salida = new FileOutputStream(archivoTemporal);
			salida.write(DatatypeConverter.parseBase64Binary(contenidoSolicModif));
			salida.close();
			result.setRuta(contenidoSolicModif);
			result.setContenido(contenidoSolicModif);
			
		}catch(Exception e){
			if(stamperPlantilla != null){
				stamperPlantilla.close();
			}
			if(plantilla != null){
				plantilla.close();
			}	
			logger.error(ExpresionesConstants.ERROR_INESPERADO_PDF, e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}finally {
			if(salida != null) {
				salida.close();
			}
		}
		return result;

	}
	
	/**
	 * Metodo que obtiene fecha actual en formato
	 * @return
	 */
	private String obtenerFechaEnFormato(){
		return fechaUtils.convertirFechaACadena(new Date(), ExpresionesConstants.FORMATO_FEHCA_GUION);
	}
	
	/**
	 * Metodo que configura propiedades para texto
	 * @param canvas
	 * @param baseFont
	 * @param tamanioLetra
	 * @throws DocumentException
	 * @throws IOException
	 */
	private void configurarPropiedadesTexto(PdfContentByte canvas,BaseFont baseFont,Float tamanioLetra){		
		canvas.setRGBColorStroke(0,0,0);
		canvas.setRGBColorFill(0,0,0);
		canvas.saveState();
		canvas.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL);
		canvas.setFontAndSize(baseFont, tamanioLetra);
		canvas.beginText();
	}
	
	/**
	 * Metodo que regresa pais de direccion particular
	 * @param datosModificacion
	 * @return
	 */
	private String regresarPaisParticular(EntradaModificacion datosModificacion){
		//Ejemplo de entrada MEX MEXICO
		String domicilioParticularTrabajadorPais = ExpresionesConstants.VACIO;
		if(datosModificacion.getDatosDomicilioParticularTrabajador() != null){
			domicilioParticularTrabajadorPais = datosModificacion.getDatosDomicilioParticularTrabajador().getPais().substring(datosModificacion.getDatosDomicilioParticularTrabajador().getPais().indexOf(ExpresionesConstants.ESPACIO)); 
			logger.info("info regresarPaisParticular:: {}",domicilioParticularTrabajadorPais);
		}
		return domicilioParticularTrabajadorPais;
		
	}
	
	/**
	 * Metodo que regresa pais de direccion laboral
	 * @param datosModificacion
	 * @return
	 */
	private String regresarPaisLaboral(EntradaModificacion datosModificacion){
		//Ejemplo de entrada MEX MEXICO
		String  domicilioLaboralTrabajadorPais = ExpresionesConstants.VACIO;
		if(datosModificacion.getDatosDomicilioLaboralTrabajador() != null){
			domicilioLaboralTrabajadorPais = datosModificacion.getDatosDomicilioLaboralTrabajador().getPais().substring(datosModificacion.getDatosDomicilioLaboralTrabajador().getPais().indexOf(ExpresionesConstants.ESPACIO)); 
			logger.info("info regresarPaisLaboral:: {}",domicilioLaboralTrabajadorPais);
		}
		return domicilioLaboralTrabajadorPais;	
	}
	
	/**
	 * Metodo que regresa ocupacion
	 * @param datosModificacion
	 * @return
	 */
	private String regresarOcupacion(EntradaModificacion datosModificacion){
		//Ejemplo de entrada 62 TRABAJADORES DE APOYO EN ACTIVIDADES ADMINISTRATIVAS
		String ocupacionOProfesionTrabajador = ExpresionesConstants.VACIO;
		if(!datosModificacion.getDatosBaseCurp().getOcupacionOProfesionTrabajador().isEmpty() && !datosModificacion.getDatosBaseCurp().getOcupacionOProfesionTrabajador().contains(ExpresionesConstants.TEXTO_SELECCIONE)){
			ocupacionOProfesionTrabajador = datosModificacion.getDatosBaseCurp().getOcupacionOProfesionTrabajador().substring(datosModificacion.getDatosBaseCurp().getOcupacionOProfesionTrabajador().indexOf(ExpresionesConstants.ESPACIO)); 
			logger.info("info regresarOcupacion:: {}",ocupacionOProfesionTrabajador);
		}
		return ocupacionOProfesionTrabajador;	
	}
	
	/**
	 * Metodo que regresa giro
	 * @param datosModificacion
	 * @return
	 */
	private String regresaraGiro(EntradaModificacion datosModificacion){
		//Ejemplo de entrada 12 ADMINISTRACION PUBLICA
		String actividadOGiroNegocioTrabajador = ExpresionesConstants.VACIO;
		if(!datosModificacion.getDatosBaseCurp().getActividadOGiroNegocioTrabajador().isEmpty() && !datosModificacion.getDatosBaseCurp().getActividadOGiroNegocioTrabajador().contains(ExpresionesConstants.TEXTO_SELECCIONE)){
			actividadOGiroNegocioTrabajador = datosModificacion.getDatosBaseCurp().getActividadOGiroNegocioTrabajador().substring(datosModificacion.getDatosBaseCurp().getActividadOGiroNegocioTrabajador().indexOf(ExpresionesConstants.ESPACIO)); 
			logger.info("info regresaraGiro:: {}",actividadOGiroNegocioTrabajador);					
		}
		return actividadOGiroNegocioTrabajador;	
	}
	
	/**
	 * Metodo que regresa nivel de estudios
	 * @param datosModificacion
	 * @return
	 */
	private String regresarNivelEstudios(EntradaModificacion datosModificacion){
		//Ejemplo de entrada 05 CARRERA PROFESIONAL
		String nivelDeEstudioTrabajador = ExpresionesConstants.VACIO;
		if(!datosModificacion.getDatosBaseCurp().getNivelDeEstudioTrabajador().isEmpty() && !datosModificacion.getDatosBaseCurp().getNivelDeEstudioTrabajador().contains(ExpresionesConstants.TEXTO_SELECCIONE)){
			nivelDeEstudioTrabajador = datosModificacion.getDatosBaseCurp().getNivelDeEstudioTrabajador().substring(datosModificacion.getDatosBaseCurp().getNivelDeEstudioTrabajador().indexOf(ExpresionesConstants.ESPACIO)); 
			logger.info("info regresarNivelEstudios:: {}",nivelDeEstudioTrabajador);
		}
		return nivelDeEstudioTrabajador;
	}
	
	/**
	 * Metodo que regresa beneficiarios peis
	 * @param listaBeneficiarios
	 * @param canvas
	 */
	private void regresarBeneficiariosPeis(List<DatosBeneficiarioTrabajador> listaBeneficiarios,PdfContentByte canvas){
			for (int i = 0; i < listaBeneficiarios.size(); i++) {	
				canvas.showTextAligned(Element.ALIGN_LEFT, listaBeneficiarios.get(i).getApellidoPaternoDeBeneficiario().toUpperCase(), 60 , 490 - (15* i), 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.obtenerContenidoCadenaSinEspacios(listaBeneficiarios.get(i).getApellidoMaternoDeBeneficiario(),ExpresionesConstants.VACIO).toUpperCase(), 190 , 490 - (15* i), 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, listaBeneficiarios.get(i).getNombreDeBeneficiario().toUpperCase(), 310 , 490 - (15* i), 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, listaBeneficiarios.get(i).getCurpDeBeneficiario(), 410 , 490 - (15* i), 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, listaBeneficiarios.get(i).getParentescoORelacion() , 505 , 490 - (15* i), 0);
				canvas.showTextAligned(Element.ALIGN_LEFT, listaBeneficiarios.get(i).getPorcentajeDeBeneficiario(), 565 , 490 - (15* i), 0);
			}			
	}
	
	/**
	 * Metodo que regresa beneficiarios coppel
	 * @param listaBeneficiarios
	 * @param canvas
	 */
	private void regresarBeneficiariosCoppel(List<DatosBeneficiarioTrabajador> listaBeneficiarios,PdfContentByte canvas,List<Beneficiario> beneficiarios){
		List<DatosBeneficiarioTrabajador> listaNuevoBeneficiario = new ArrayList<>();
		Integer tamanioListaFormulario = listaBeneficiarios.size();
		if(utileriaValidador.validarListaVacia(beneficiarios)) {
			for (int i = 0; i < listaBeneficiarios.size(); i++) {	
				agregaBeneficiariosCanvas(canvas, i, listaBeneficiarios);

			}
		}else {
			JsonUtilsImpl<String> jsonBd = new JsonUtilsImpl<>();
			String listaBdJson = jsonBd.parseListObjectToJson(beneficiarios);
			int i = 0;
			List<DatosBeneficiarioTrabajador> nuevaLista = new ArrayList<>();
			for(Beneficiario beneficiario : beneficiarios) {
					for(DatosBeneficiarioTrabajador datosBeneficiariosFormulario : listaBeneficiarios) {
						boolean valorContains = listaBdJson.contains(datosBeneficiariosFormulario.getCurpDeBeneficiario());
						if(!valorContains) {
							
							boolean existeRegistro = listaNuevoBeneficiario.contains(datosBeneficiariosFormulario);
							if(!existeRegistro) {
								listaNuevoBeneficiario.add(datosBeneficiariosFormulario);
							}
							logger.info("curp no existe: {}",listaNuevoBeneficiario);
						}
						DatosBeneficiarioTrabajador datosBeneficiarios = new DatosBeneficiarioTrabajador();					
						 llenadoObjetoBeneficiario(beneficiario, datosBeneficiarios, datosBeneficiariosFormulario, i,listaBeneficiarios.size());
						if(validarObjetoBeneficiario(datosBeneficiarios)) {
							nuevaLista.add(datosBeneficiarios);
						}
						 i++;
						 
					} 
				}
			
				for(DatosBeneficiarioTrabajador datosBeneficiarioNuevo : listaNuevoBeneficiario) {
					nuevaLista.add(datosBeneficiarioNuevo);
				}
			
				if (i < tamanioListaFormulario) {
					 validarLLenadoBeneficiarioFaltante(i, listaBeneficiarios, nuevaLista);
				}
				for (int e = 0; e < nuevaLista.size(); e++) {	
					agregaBeneficiariosCanvas(canvas, e, nuevaLista);
				}

			}
			

	}
	
	
	private List<DatosBeneficiarioTrabajador> validarLLenadoBeneficiarioFaltante(int i,List<DatosBeneficiarioTrabajador> listaBeneficiarios,List<DatosBeneficiarioTrabajador> nuevaLista) {
		for (int j = i; j < listaBeneficiarios.size(); j++) {	
			DatosBeneficiarioTrabajador datosBeneficiarios = new DatosBeneficiarioTrabajador();
			llenarFaltanteBeneficiario(datosBeneficiarios, j, listaBeneficiarios);
			nuevaLista.add(datosBeneficiarios);
		}
		return nuevaLista;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerProcesoExpedienteServicio(String tipoSolicitante) {
		String tipoProcesoSolicitante = null;
		if(ExpresionesConstants.TIPO_SOLICITANTE_TITULAR.equals(tipoSolicitante.trim())){
			tipoProcesoSolicitante = "46";
		}else if(ExpresionesConstants.TIPO_SOLICITANTE_BENEFICIARIO.equals(tipoSolicitante.trim())){
			tipoProcesoSolicitante = "47";
		}else if(ExpresionesConstants.TIPO_SOLICITANTE_REPRESENTANTE_LEGAL.equals(tipoSolicitante.trim())){
			tipoProcesoSolicitante = "46";
		}else if(ExpresionesConstants.TIPO_SOLICITANTE_CURADOR.equals(tipoSolicitante.trim())){
			tipoProcesoSolicitante = "46";
		}
		return tipoProcesoSolicitante;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generarFolioSolicitud(Folio folio) {	
		return folio.getChFolio().substring(10, 20);		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DatosSolicitud recuperarFirmasProceso(String folioPadre,RecepcionImagenes recepcionImagenes) throws IOException {
		DetalleRecepcionImagenes detalleFirmaTrabajador = null;
		DetalleRecepcionImagenes detalleFirmaAgente = null;
		String firmaTrabajador = null;
		String firmaAgente = null;
		DatosSolicitud datosSolicitud = new DatosSolicitud();
		
		Integer numeroArchivos = recepcionImagenes.getDetalleRecepcionImagen().size();
		datosSolicitud.setNumeroArchivos(numeroArchivos);
		for(DetalleRecepcionImagenes detalle : recepcionImagenes.getDetalleRecepcionImagen()) {
			if("40".equals(detalle.getTipoDocumentoDigital()) && NumerosConstants.INT_TRES.equals(detalle.getTipoImagen())) {
				detalleFirmaTrabajador = detalle;
			}else if("40".equals(detalle.getTipoDocumentoDigital()) && NumerosConstants.INT_CUATRO.equals(detalle.getTipoImagen())) {
				detalleFirmaAgente = detalle;
			}
		}
		
		if(!utileriaValidador.validarObjetoNulo(detalleFirmaAgente) && !utileriaValidador.validarObjetoNulo(detalleFirmaTrabajador)) {
			String rutaFirmaTrabajador = utileriaCadena.obtenerCadenaConcatenada(true, detalleFirmaTrabajador.getRuta(),detalleFirmaTrabajador.getMascara());
			firmaTrabajador = lectorUtils.obtenerContenidoArchivo(rutaFirmaTrabajador);

			String rutaFirmaAgente = utileriaCadena.obtenerCadenaConcatenada(true, detalleFirmaAgente.getRuta(),detalleFirmaAgente.getMascara());			
			firmaAgente = lectorUtils.obtenerContenidoArchivo(rutaFirmaAgente);

		}else {
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
		}
		
		
		datosSolicitud.setFirmaTrabajador(firmaTrabajador);
		datosSolicitud.setFirmaAgente(firmaAgente);
		
		return datosSolicitud;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public RespuestaServicio enviarSolicitudBanorte(EnvioArchivos datosRecepcion,String rutaZip) throws IOException {
		logger.info("Inicio - enviarArchivos");
		logger.info("datosRecepcion: {}",datosRecepcion);
		RespuestaServicio respuestaServicio = null;
		FileOutputStream salida = null;
		try {
			respuestaServicio = procesarSolicituModificacionDatosRecepcionImagenes(datosRecepcion, rutaZip);      
			
		} catch (FileNotFoundException fnfe) {
			logger.error("Ocurrio FileNotFoundException", fnfe);
			respuestaServicio = servicioArchivos.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
			
		} catch (IOException ioe) {
			logger.error("Ocurrio IOException", ioe);
			respuestaServicio = servicioArchivos.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
				
		} catch (GenericException ge) {
			logger.error("Ocurrio GenericException", ge);
			respuestaServicio = servicioArchivos.obtenerRespuesta(ge.getCodigo(), datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
			
		} catch (Exception e) {
			logger.error("Ocurrio un error inesperado " , e);
			respuestaServicio = servicioArchivos.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(),  datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		}finally {
			if(salida != null) {
				salida.close();
			}
		}
		logger.info("Fin EnviarArchivos respuestaServicio: {}",respuestaServicio);
		return respuestaServicio;
	}
	
	/**
	 * Metodo que procesa solicitud de modificacion de datos
	 * @param datosRecepcion
	 * @param ruta
	 * @param fecha
	 * @param solicitudModificacionDatosPdf
	 * @param salida
	 * @return
	 * @throws IOException
	 */
	private RespuestaServicio procesarSolicituModificacionDatos(EnvioArchivos datosRecepcion,String ruta,String fecha,String solicitudModificacionDatosPdf,FileOutputStream salida) throws IOException {
		
		logger.info("Generando Zip..");
		Archivos objetoArchivo = new Archivos();

		String resultado = servicioArchivos.generarZip(ruta);
		objetoArchivo.setClaveAfore(datosRecepcion.getClaveAfore());
		objetoArchivo.setFolioTramiteProcesar(datosRecepcion.getFolio());
		objetoArchivo.setCurpEmpleado(datosRecepcion.getCurpEmpleado());
		objetoArchivo.setCurpTrabajador(datosRecepcion.getCurpTrabajador());
		objetoArchivo.setTipoArchivos(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
		objetoArchivo.setTipoExpediente(datosRecepcion.getProceso());
		generaProcesoZip(objetoArchivo, ruta, resultado);
		logger.info("Capturar Archivos");
		RespuestaAlta respuesta = this.capturarArchivos(objetoArchivo, ruta);
		logger.info("Respuesta Alta: {}",respuesta);
		servicioArchivos.eliminarDirectorio(new File(ruta));
		servicioArchivos.eliminarDirectorio(new File(utileriaCadena.obtenerCadenaConcatenada(true, ruta, ExpresionesConstants.EXTENSION_ZIP)));

		 return servicioArchivos.validarRespuestaRecepcionArchivos(respuesta, datosRecepcion.getClaveAfore());
	}
	
	/**
	 * Metodo que valida datos recibidos 
	 * @param objetoImagen
	 * @param datosRecepcion
	 * @param fecha
	 * @param ruta
	 * @throws IOException
	 */
	private void validarArchivosRecibidos(ImagenWrapper objetoImagen,EnvioArchivos datosRecepcion,String fecha,String ruta) throws IOException {
		FileOutputStream salida = null;
		if(!utileriaValidador.validarObjetoNulo(objetoImagen) && !utileriaValidador.validarListaVacia(objetoImagen.getImagenes())) {
			int indice = 1;
			for(ImagenDocumento archivo : objetoImagen.getImagenes()) {
				String extension = archivo.getNombreDocumento().substring(archivo.getNombreDocumento().indexOf(AgenteConstants.PUNTO));
				String renombre = utileriaCadena.obtenerCadenaConcatenada(true, datosRecepcion.getClaveAfore(), datosRecepcion.getProceso(), datosRecepcion.getCurpTrabajador(), datosRecepcion.getTipoTrabajador(), archivo.getClaveTipoDocumento(), String.valueOf(indice), fecha,  datosRecepcion.getFolioIdentificacion(),extension.toLowerCase());
				File rutaSalida = new File(utileriaCadena.obtenerCadenaConcatenada(true, ruta,  ActivacionConstants.DIAGONAL, renombre));
				salida = new FileOutputStream(rutaSalida);
				salida.write(DatatypeConverter.parseBase64Binary(archivo.getContenidoDocumento()));
				salida.close();
				indice++;
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Parametro obtenerValorParametro(String cvParametro) {
		logger.info("entrada obtenerValorParametro:: {}",cvParametro);
		Parametro parametro = null;
		try {
			List<Parametro> listaParametro = servicioCatalogo.obtenerParametroDdbpose(cvParametro);
			if(!utileriaValidador.validarListaVacia(listaParametro)) {
				parametro = listaParametro.get(NumerosConstants.INT_CERO);
			}
			logger.info("respuesta obtenerValorParametro:: {}",parametro);
		}catch (Exception e) {
			logger.error("Ocurrio un problema controlado obtenerValorParametro: {}",e);
		}
		return parametro;
	}
	
	/**
	 * Metodo para validar objeto beneficiario
	 * @param datosBeneficiario
	 * @return
	 */
	private Boolean validarObjetoBeneficiario(DatosBeneficiarioTrabajador datosBeneficiario) {
		Boolean validacion = false;
		if(!utileriaValidador.validarVacio(datosBeneficiario.getApellidoPaternoDeBeneficiario()) || 
				!utileriaValidador.validarVacio(datosBeneficiario.getApellidoMaternoDeBeneficiario()) || 
				!utileriaValidador.validarVacio(datosBeneficiario.getCurpDeBeneficiario()) || 
				!utileriaValidador.validarVacio(datosBeneficiario.getParentescoORelacion()) || 
				!utileriaValidador.validarVacio(datosBeneficiario.getPorcentajeDeBeneficiario())) {
			validacion = true;
		}
		return validacion;
	}
	
	/**
	 * Metodo para llenar objeto beneficiario
	 * @param beneficiario
	 * @param datosBeneficiarios
	 * @param listaBeneficiarios
	 * @param i
	 * @return
	 */
	private DatosBeneficiarioTrabajador llenadoObjetoBeneficiario(Beneficiario beneficiario,DatosBeneficiarioTrabajador datosBeneficiarios,DatosBeneficiarioTrabajador datosBeneficiariosExistentes,int i,int tamanioLista) {
		
			if(beneficiario.getCurp().equals(datosBeneficiariosExistentes.getCurpDeBeneficiario())) {
				if(!beneficiario.getApellidoPaterno().equals(datosBeneficiariosExistentes.getApellidoPaternoDeBeneficiario())) {
					datosBeneficiarios.setApellidoPaternoDeBeneficiario(datosBeneficiariosExistentes.getApellidoPaternoDeBeneficiario());
					datosBeneficiarios.setApellidoMaternoDeBeneficiario(datosBeneficiariosExistentes.getApellidoMaternoDeBeneficiario());
					datosBeneficiarios.setNombreDeBeneficiario(datosBeneficiariosExistentes.getNombreDeBeneficiario());
		
				}
				if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiario.getApellidoMaterno(),ExpresionesConstants.VACIO).equals(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBeneficiariosExistentes.getApellidoMaternoDeBeneficiario(),ExpresionesConstants.VACIO))) {
					datosBeneficiarios.setApellidoMaternoDeBeneficiario(datosBeneficiariosExistentes.getApellidoMaternoDeBeneficiario());
					datosBeneficiarios.setApellidoPaternoDeBeneficiario(datosBeneficiariosExistentes.getApellidoPaternoDeBeneficiario());
					datosBeneficiarios.setNombreDeBeneficiario(datosBeneficiariosExistentes.getNombreDeBeneficiario());
		
				}					
				if(!beneficiario.getNombre().equals(datosBeneficiariosExistentes.getNombreDeBeneficiario())) {
					datosBeneficiarios.setNombreDeBeneficiario(datosBeneficiariosExistentes.getNombreDeBeneficiario());
					datosBeneficiarios.setApellidoPaternoDeBeneficiario(datosBeneficiariosExistentes.getApellidoPaternoDeBeneficiario());
					datosBeneficiarios.setApellidoMaternoDeBeneficiario(datosBeneficiariosExistentes.getApellidoMaternoDeBeneficiario());
				}
				
				if(!utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiario.getParentesco(),ExpresionesConstants.VACIO).equals(utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBeneficiariosExistentes.getParentescoORelacion(),ExpresionesConstants.VACIO))) {
					datosBeneficiarios.setParentescoORelacion(datosBeneficiariosExistentes.getParentescoORelacion());
					datosBeneficiarios.setApellidoPaternoDeBeneficiario(datosBeneficiariosExistentes.getApellidoPaternoDeBeneficiario());
					datosBeneficiarios.setApellidoMaternoDeBeneficiario(datosBeneficiariosExistentes.getApellidoMaternoDeBeneficiario());
					datosBeneficiarios.setNombreDeBeneficiario(datosBeneficiariosExistentes.getNombreDeBeneficiario());
				}
				if(!beneficiario.getPorcentaje().equals(datosBeneficiariosExistentes.getPorcentajeDeBeneficiario())) {
					datosBeneficiarios.setPorcentajeDeBeneficiario(datosBeneficiariosExistentes.getPorcentajeDeBeneficiario());
					datosBeneficiarios.setApellidoPaternoDeBeneficiario(datosBeneficiariosExistentes.getApellidoPaternoDeBeneficiario());
					datosBeneficiarios.setApellidoMaternoDeBeneficiario(datosBeneficiariosExistentes.getApellidoMaternoDeBeneficiario());
					datosBeneficiarios.setNombreDeBeneficiario(datosBeneficiariosExistentes.getNombreDeBeneficiario());
				}
			}
		return datosBeneficiarios;
	}
	
	/**
	 * Metodo para llenar beneficiarios faltantes
	 * @param datosBeneficiarios
	 * @param j
	 * @param listaBeneficiarios
	 * @return
	 */
	private DatosBeneficiarioTrabajador llenarFaltanteBeneficiario(DatosBeneficiarioTrabajador datosBeneficiarios,int j,List<DatosBeneficiarioTrabajador> listaBeneficiarios) {
		datosBeneficiarios.setApellidoPaternoDeBeneficiario(listaBeneficiarios.get(j).getApellidoPaternoDeBeneficiario());
		datosBeneficiarios.setApellidoMaternoDeBeneficiario(listaBeneficiarios.get(j).getApellidoMaternoDeBeneficiario());
		datosBeneficiarios.setNombreDeBeneficiario(listaBeneficiarios.get(j).getNombreDeBeneficiario());
		datosBeneficiarios.setCurpDeBeneficiario(listaBeneficiarios.get(j).getCurpDeBeneficiario());
		datosBeneficiarios.setParentescoORelacion(listaBeneficiarios.get(j).getParentescoORelacion());
		datosBeneficiarios.setPorcentajeDeBeneficiario(listaBeneficiarios.get(j).getPorcentajeDeBeneficiario());
		return datosBeneficiarios;
	}
	
	/**
	 * Metodo para agregar beneficiarios a canvas
	 * @param canvas
	 * @param e
	 * @param nuevaLista
	 */
	private void agregaBeneficiariosCanvas(PdfContentByte canvas,int e,List<DatosBeneficiarioTrabajador> nuevaLista) {
		canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(nuevaLista.get(e).getApellidoPaternoDeBeneficiario()).toUpperCase(), 25 , 295 - (15* e), 0);
		canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(nuevaLista.get(e).getApellidoMaternoDeBeneficiario()).toUpperCase(), 120 , 295 - (15* e), 0);
		canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(nuevaLista.get(e).getNombreDeBeneficiario()).toUpperCase(), 220 , 295 - (15* e), 0);
		canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(nuevaLista.get(e).getCurpDeBeneficiario()), 400 , 295 - (15* e), 0);
		canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(nuevaLista.get(e).getParentescoORelacion()), 310 , 295 - (15* e), 0);
		canvas.showTextAligned(Element.ALIGN_LEFT, utileriaCadena.asignarValor(nuevaLista.get(e).getPorcentajeDeBeneficiario()), 520 , 295 - (15* e), 0);
	}
	
	/**
	 * Metodo que genera zip en ruta
	 * @param objetoArchivo
	 * @param ruta
	 * @param archivoBase64
	 * @throws IOException
	 */
	private String generaProcesoZip(Archivos objetoArchivo,String ruta,String archivoBase64) throws IOException {
		String nombreZip = servicioArchivos.obtenerArchivoZipExpedienteRuta(objetoArchivo, ruta);
		File fArchivo = new File(nombreZip);
		FileOutputStream salidaArchivo = new FileOutputStream(fArchivo);
		byte[] decoder = Base64Utils.decodeFromString(archivoBase64);
		salidaArchivo.write(decoder);
		logger.info("Archivo almacenado {}", nombreZip);
		salidaArchivo.close();
		objetoArchivo.setContenidoArchivo(nombreZip);
		return nombreZip;
	}
	
/**
 * {@inheritDoc}
 */
	@Override
	public RespuestaServicio validarEstatusExpediente(EntradaModificacion entradaModificacion,String cveProceso,String cvAfore,String folio) {
		ArchivoRecibido	archivoRecibido = null;
		RespuestaServicio respuestaServicio = null;
		String respuesta = "01"; 
		ExpedienteDetail respuestaExpediente = expedienteService.consultarExpedienteProceso(entradaModificacion.getDatosBaseCurp().getCurpNueva(), cvAfore, cveProceso,ServiciosConstants.EXPEDIENTE_INCOMPLETO_TEMPORAL);
		if(utileriaValidador.validarObjetoNulo(respuestaExpediente)) {
			archivoRecibido = expedienteService.consultarEstatusExpediente(folio,ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS, ServiciosConstants.CLAVE_02);
			if(!utileriaValidador.validarObjetoNulo(archivoRecibido)) {
				respuesta = "02";
			}
		}		
		if(utileriaValidador.validarObjetoNulo(respuestaExpediente) && utileriaValidador.validarObjetoNulo(archivoRecibido)) {
			respuesta = "03";
		}
		
		respuestaServicio = validarRespuestaEstatusExpediente(respuesta, cvAfore);
		return respuestaServicio;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public RespuestaServicio validarRespuestaEstatusExpediente(String respuesta, String claveAfore) {
		RespuestaServicio respuestaServicio = null;
		if(ServiciosConstants.RESULTADO_OK.equals(respuesta)) {
			respuestaServicio = servicioArchivos.obtenerRespuesta(MensajesExitoEnum.EXPEDIENTE_ENVIADO.getClave(), claveAfore,NumerosConstants.INT_UNO);
		}else if (ServiciosConstants.RESULTADO_NOK.equals(respuesta)) {
			respuestaServicio = servicioArchivos.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), claveAfore,NumerosConstants.INT_DOS);
		}else if("03".equals(respuesta)) {
			respuestaServicio = servicioArchivos.obtenerRespuesta(MensajesExitoEnum.EXPEDIENTE_ENVIADO.getClave(), claveAfore, NumerosConstants.INT_TRES);
		}
		

		return respuestaServicio;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String obtenerFiguraTercero(String tipoSolicitante) {
		String tipoProcesoSolicitante = null;
		if(ExpresionesConstants.TIPO_SOLICITANTE_TITULAR.equals(tipoSolicitante.trim())){
			tipoProcesoSolicitante = "TITULAR";
		}else if(ExpresionesConstants.TIPO_SOLICITANTE_BENEFICIARIO.equals(tipoSolicitante.trim())){
			tipoProcesoSolicitante = "BENEFICIARIO";
		}else if(ExpresionesConstants.TIPO_SOLICITANTE_REPRESENTANTE_LEGAL.equals(tipoSolicitante.trim())){
			tipoProcesoSolicitante = "REPRESENTANTE LEGAL";
		}else if(ExpresionesConstants.TIPO_SOLICITANTE_CURADOR.equals(tipoSolicitante.trim())){
			tipoProcesoSolicitante = "CURADOR";
		}
		return tipoProcesoSolicitante;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String validarIgualdadRfc(DatosTrabajador trabajador,EntradaModificacion objetoModificacion) {
		String respuesta = NumerosConstants.C_CERO;
		String rfcActual = utileriaCadena.asignarValor(trabajador.getDatosNoCertificables().getRfc());
		String rfcNueva =utileriaCadena.asignarValor(objetoModificacion.getDatosBaseCurp().getRfc());
		if(!rfcActual.equalsIgnoreCase(rfcNueva) && rfcNueva.length() == 13) {
			respuesta = NumerosConstants.C_UNO;
		}
		return respuesta;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String consultaSelloSolicitud(UsuarioLogin user,String curp,String tipoSolicitante) {
		String sello = null;
		VerificacionSello verificacion = consultaSelloService.consultarSelloFlujoModificacion(user.getCurpAgente(),curp,user.getAforeUsuario());
		if(ExpresionesConstants.TIPO_SOLICITANTE_TITULAR.equals(tipoSolicitante) && !utileriaValidador.validarObjetoNulo(verificacion) && !utileriaValidador.validarObjetoNulo(verificacion.getSello())) {
			sello = String.valueOf(verificacion.getSello().getId());
		}
		return sello;

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean validaArregloCambiosBeneficiarios(DatosComplementarios datosComplementarios,ListaBeneficiariosTrabajador listaBeneficiariosTrabajador,EntradaModificacion entradaModificacion,String banderaValidacion) {
		Boolean resultado = true;
		Integer tamanioArregloBd = NumerosConstants.INT_CERO;
		Integer tamanioArregloFormulario = NumerosConstants.INT_CERO;
		List<Beneficiario> listaBeneficiarios = datosComplementarios.getListaBeneficiario();
		entradaModificacion.getDatosBaseCurp().setMovimientoBeneficiario(NumerosConstants.C_TRES);
		
		String caracterHomologado = modificacionTrabajadorService.consultarCaracterHomologado();
		
		if(!utileriaValidador.validarObjetoNulo(listaBeneficiarios)) {
			tamanioArregloBd = listaBeneficiarios.size();
		}
		
		if(!utileriaValidador.validarObjetoNulo(listaBeneficiariosTrabajador)) {
			tamanioArregloFormulario = listaBeneficiariosTrabajador.getBeneficiario().size();
		}
		
		if(!tamanioArregloBd.equals(tamanioArregloFormulario)) {
			resultado = false;
		}
		
		if(tamanioArregloBd.equals(tamanioArregloFormulario) && tamanioArregloBd > NumerosConstants.INT_CERO && tamanioArregloFormulario > NumerosConstants.INT_CERO) {
			List<DatosBeneficiarioTrabajador> listaBeneficiarioBd = new ArrayList<>();
			for(Beneficiario beneficiarioBd : listaBeneficiarios) {
				
				String nombreBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioBd.getNombre(), ExpresionesConstants.VACIO);
				nombreBd = notificacionExpedienteService.eliminarAcentos(nombreBd, caracterHomologado);
				
				String apellidoPaternoBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioBd.getApellidoPaterno(), ExpresionesConstants.VACIO);
				apellidoPaternoBd = notificacionExpedienteService.eliminarAcentos(apellidoPaternoBd, caracterHomologado);
				
				String apellidoMaternoBd = utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioBd.getApellidoMaterno(), ExpresionesConstants.VACIO);
				apellidoMaternoBd = notificacionExpedienteService.eliminarAcentos(apellidoMaternoBd, caracterHomologado);
				
				DatosBeneficiarioTrabajador beneficiario = new DatosBeneficiarioTrabajador();
				beneficiario.setCurpDeBeneficiario(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioBd.getCurp(),ExpresionesConstants.VACIO));
				beneficiario.setNombreDeBeneficiario(nombreBd);
				beneficiario.setApellidoPaternoDeBeneficiario(apellidoPaternoBd);
				beneficiario.setApellidoMaternoDeBeneficiario(utileriaValidador.isEmpty(apellidoMaternoBd) ? null : apellidoMaternoBd);
				beneficiario.setParentescoORelacion(utileriaValidador.isEmpty(beneficiarioBd.getParentesco()) ? null : utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioBd.getParentesco(),ExpresionesConstants.VACIO));
				if(!utileriaValidador.isEmpty(banderaValidacion)) {
					beneficiario.setParentescoORelacion(utileriaValidador.isEmpty(beneficiarioBd.getClaveParentesco()) ? null : utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioBd.getClaveParentesco(),ExpresionesConstants.VACIO));
				}
				beneficiario.setPorcentajeDeBeneficiario(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioBd.getPorcentaje(),ExpresionesConstants.VACIO));
				listaBeneficiarioBd.add(beneficiario);
			}
			
			List<DatosBeneficiarioTrabajador> listaBeneficiarioFormulario = new ArrayList<>();
			for(DatosBeneficiarioTrabajador beneficiarioFormulario : listaBeneficiariosTrabajador.getBeneficiario()) {
				
				String nombreFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioFormulario.getNombreDeBeneficiario(), ExpresionesConstants.VACIO);
				nombreFormulario = notificacionExpedienteService.eliminarAcentos(nombreFormulario, caracterHomologado);
				
				String apellidoPaternoFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioFormulario.getApellidoPaternoDeBeneficiario(), ExpresionesConstants.VACIO);
				apellidoPaternoFormulario = notificacionExpedienteService.eliminarAcentos(apellidoPaternoFormulario, caracterHomologado);
				
				String apellidoMaternoFormulario = utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioFormulario.getApellidoMaternoDeBeneficiario(), ExpresionesConstants.VACIO);
				apellidoMaternoFormulario = notificacionExpedienteService.eliminarAcentos(apellidoMaternoFormulario, caracterHomologado);
				
				DatosBeneficiarioTrabajador beneficiario = new DatosBeneficiarioTrabajador();
				beneficiario.setCurpDeBeneficiario(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioFormulario.getCurpDeBeneficiario(),ExpresionesConstants.VACIO));
				beneficiario.setNombreDeBeneficiario(nombreFormulario);
				beneficiario.setApellidoPaternoDeBeneficiario(apellidoPaternoFormulario);
				beneficiario.setApellidoMaternoDeBeneficiario(utileriaValidador.isEmpty(apellidoMaternoFormulario) ? null : apellidoMaternoFormulario);
				beneficiario.setParentescoORelacion(utileriaValidador.isEmpty(beneficiarioFormulario.getParentescoORelacion()) ? null : utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioFormulario.getParentescoORelacion(),ExpresionesConstants.VACIO));
				beneficiario.setPorcentajeDeBeneficiario(utileriaCadena.obtenerContenidoCadenaSinEspacios(beneficiarioFormulario.getPorcentajeDeBeneficiario(),ExpresionesConstants.VACIO));
				listaBeneficiarioFormulario.add(beneficiario);
			}
						
			JsonUtilsImpl<String> jsonBd = new JsonUtilsImpl<>();
			String listaBdJson = jsonBd.parseListObjectToJson(listaBeneficiarioBd);
			logger.info("json beneficiarios bd banorte {}",listaBdJson);
			
			
			JsonUtilsImpl<String> jsonFormulario = new JsonUtilsImpl<>();
			String listaFormularioJson = jsonFormulario.parseListObjectToJson(listaBeneficiarioFormulario);
			logger.info("json beneficiarios formulario banorte {}",listaFormularioJson);			
			
			resultado = listaFormularioJson.equals(listaBdJson);
			
			if(!resultado) {
				entradaModificacion.getDatosBaseCurp().setMovimientoBeneficiario(NumerosConstants.C_DOS);
			}
			logger.info("respuesta comparacion beneficiarios {}", resultado);
		}
		
		if(!resultado) {
			entradaModificacion.getDatosBaseCurp().setMovimientoBeneficiario(NumerosConstants.C_DOS);
		}
		logger.info("respuesta comparacion beneficiarios {}", resultado);
		
		if(tamanioArregloFormulario.equals(NumerosConstants.INT_CERO) && !tamanioArregloBd.equals(NumerosConstants.INT_CERO)) {
			entradaModificacion.getDatosBaseCurp().setMovimientoBeneficiario(NumerosConstants.C_UNO);
		}
		return resultado;
	}
	
	/**
	 * Metodo que valida dator certificables o reportables de banorte
	 * @param banderasModificacion
	 * @return
	 */
	private Boolean validarReportablesBanorte(BanderaDatosModificadosCertificables banderasModificacion) {
		Boolean resultado = true;
		if(banderasModificacion.isModificacionDatosCertificables() || !banderasModificacion.isModificadoNivelEstudios() || !banderasModificacion.isModificadoActividadEconomica() || !banderasModificacion.isModificadoOcupacion()) {
			resultado = false;
		}
		return resultado;
	}
	
	/**
	 * Metodo que valida cambios en domicilio particular o laboral bloque uno
	 * @param modificacionDomicilios
	 * @return
	 */
	private boolean validarDatosNoCertificablesDomiciliUno(BanderaDatosModificadosDomicilios modificacionDomicilios) {
		boolean resultado = true;
		if(!modificacionDomicilios.isModificadoCalle() || !modificacionDomicilios.isModificadoNoExterior() || !modificacionDomicilios.isModificadoNoInterior() || !modificacionDomicilios.isModificadoColonia() || !modificacionDomicilios.isModificadoMunicipio()) {
			resultado = false;
		}
		return resultado;
	}
	
	/**
	 * Metodo que valida cambios domicilio partocular bloque dos
	 * @param modificacionDomicilios
	 * @return
	 */
	private boolean validarDatosNoCertificablesDomicilioParticularDos(BanderaDatosModificadosDomicilios modificacionDomicilios) {
		boolean resultado = true;
		if(!modificacionDomicilios.isModificadoCodigoPostal() || !modificacionDomicilios.isModificadoEntidadFederativa() || !modificacionDomicilios.isModificadoPais() ||!modificacionDomicilios.isModificadoTelefonoFijo() || !modificacionDomicilios.isModificadoCelular() || !modificacionDomicilios.isModificadoCorreoElectronico()) {
			resultado = false;
		}
		return resultado;
	}
	
	/**
	 * Metodo que valida cambios domicilio laboral bloque dos
	 * @param modificacionDomicilios
	 * @return
	 */
	private boolean validarDatosNoCertificablesDomicilioLaboralDos(BanderaDatosModificadosDomicilios modificacionDomicilios) {
		boolean resultado = true;
		if(!modificacionDomicilios.isModificadoCodigoPostal() || !modificacionDomicilios.isModificadoEntidadFederativa() || !modificacionDomicilios.isModificadoPais()) {
			resultado = false;
		}
		return resultado;
	}
	
	/**
	 * Metodo que valida cambios referencias uno y dos
	 * @param modificacionReferencias
	 * @return
	 */
	private boolean validarDatosReferencia(BanderaDatosModificadosReferencias modificacionReferencias) {
		boolean resultado = true;
		if(!modificacionReferencias.isModificacionCurp() || !modificacionReferencias.isModificacionNombre() || !modificacionReferencias.isModificacionApellidoPaterno() || !modificacionReferencias.isModificacionApellidoMaterno() || !modificacionReferencias.isModificacionTelefono() || !modificacionReferencias.isModificacionParentesco()) {
			resultado = false;
		}
		return resultado;
	}
	
	/**
	 * Metodo que valida resultado validacion no certificables banorte
	 * @param resultadoParticularUno
	 * @param resultadoParticularDos
	 * @param resultadoLaboralUno
	 * @param resultadoLaboralDos
	 * @param resultadoReferenciaUno
	 * @param resultadoReferenciaDos
	 * @return
	 */
	private Boolean validarResultadosNoCertificablesBanorte(boolean resultadoParticularUno,boolean resultadoParticularDos,boolean resultadoLaboralUno,boolean resultadoLaboralDos,boolean resultadoReferenciaUno,boolean resultadoReferenciaDos){
		Boolean resultado = true;
		if(!resultadoParticularUno || !resultadoParticularDos || !resultadoLaboralUno || !resultadoLaboralDos || !resultadoReferenciaUno || !resultadoReferenciaDos) {
			resultado = false;
		}
		return resultado;
		
	}


	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * ExpedienteServicioService#recuperarFirmasProcesoGenerico(java.lang.String,
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * RecepcionImagenes)
	 */
	@Override
	public DatosSolicitud recuperarFirmasProcesoGenerico(String folioPadre, RecepcionImagenes recepcionImagenes)
			throws IOException {
		DetalleRecepcionImagenes detalleFirmaTrabajador = null;
		String firmaTrabajador = null;
		DatosSolicitud datosSolicitud = new DatosSolicitud();

		Integer numeroArchivos = recepcionImagenes.getDetalleRecepcionImagen().size();
		datosSolicitud.setNumeroArchivos(numeroArchivos);
		for (DetalleRecepcionImagenes detalle : recepcionImagenes.getDetalleRecepcionImagen()) {
			detalleFirmaTrabajador = detalle;
		}

		if (!utileriaValidador.validarObjetoNulo(detalleFirmaTrabajador)) {
			String rutaFirmaTrabajador = utileriaCadena.obtenerCadenaConcatenada(true, detalleFirmaTrabajador.getRuta(),
					detalleFirmaTrabajador.getMascara());
			firmaTrabajador = lectorUtils.obtenerContenidoArchivo(rutaFirmaTrabajador);
		}
		datosSolicitud.setFirmaTrabajador(firmaTrabajador);

		return datosSolicitud;
	}
	
	/**
	 * Metodo que procesa solicitud de modificacion de datos
	 * @param datosRecepcion
	 * @param rutaZip
	 * @return
	 * @throws IOException
	 */
	private RespuestaServicio procesarSolicituModificacionDatosRecepcionImagenes(EnvioArchivos datosRecepcion,String rutaZip) throws IOException {
		
		logger.info("Entrando procesarSolicituModificacionDatosRecepcionImagenes");
		Archivos objetoArchivo = new Archivos();

		objetoArchivo.setClaveAfore(datosRecepcion.getClaveAfore());
		objetoArchivo.setFolioTramiteProcesar(datosRecepcion.getFolio());
		objetoArchivo.setCurpEmpleado(datosRecepcion.getCurpEmpleado());
		objetoArchivo.setCurpTrabajador(datosRecepcion.getCurpTrabajador());
		objetoArchivo.setTipoArchivos(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
		objetoArchivo.setTipoExpediente(datosRecepcion.getProceso());
		objetoArchivo.setContenidoArchivo(rutaZip);

		logger.info("Capturar Archivos procesarSolicituModificacionDatosRecepcionImagenes; {}",objetoArchivo);
		RespuestaAlta respuesta = this.capturarArchivos(objetoArchivo, null);
		logger.info("Respuesta Alta procesarSolicituModificacionDatosRecepcionImagenes: {}",respuesta);

		 return servicioArchivos.validarRespuestaRecepcionArchivos(respuesta, datosRecepcion.getClaveAfore());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generarUrlGuardadoArchivos(String afore,String proceso) {
		Parametro parametroRuta = this.obtenerValorParametro(ActivacionConstants.RUTA_GUARDADO_ARCHIVOS);
		String urlEnvio = parametroRuta.getChValorParametro();
		logger.error("ruta inicial generarUrlGuardadoArchivos: {}",urlEnvio);
		urlEnvio = urlEnvio.replace(ExpresionesConstants.AFORE_SUSTITUCION, afore);
		urlEnvio = urlEnvio.replace(ExpresionesConstants.PROCESO_SUSTITUCION, proceso);
		
		logger.error("ruta final generarUrlGuardadoArchivos: {}",urlEnvio);
		return urlEnvio;

	}
	
	/**
	 * Metodo para guardar archivos de expediente
	 * @param afore
	 * @param proceso
	 * @return
	 */
	private String generarUrlGuardadoArchivosExpediente(String afore,String proceso) {
		Parametro parametro = this.obtenerValorParametro(ActivacionConstants.PARAMETRO_CLAVE_RUTA_ARCHIVOS_EXPEDIENTE);
		String urlExpediente = parametro.getChValorParametro();
		logger.error("ruta inicial generarUrlGuardadoArchivos: {}",urlExpediente);
		urlExpediente = urlExpediente.replace(ExpresionesConstants.AFORE_SUSTITUCION, afore);
		urlExpediente = urlExpediente.replace(ExpresionesConstants.PROCESO_SUSTITUCION, proceso);
		logger.error("ruta final generarUrlGuardadoArchivos: {}",urlExpediente);
		return urlExpediente;
	}
	
	
}
