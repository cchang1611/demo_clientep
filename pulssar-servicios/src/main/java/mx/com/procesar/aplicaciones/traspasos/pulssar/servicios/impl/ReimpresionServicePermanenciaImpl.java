package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivoZipService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CorreoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.PermanenciaReportesEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.SubTipoSolicitanteEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBeneficiarioTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Permanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils;

/**
 * ReimpresionServiceImpl
 * @author jmordone
 *
 */
@Qualifier("permanencia")
@Service
public class ReimpresionServicePermanenciaImpl implements ReimpresionService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ReimpresionServicePermanenciaImpl.class);

	/**
	 * PdfUtils
	 */
	@Autowired
	private PdfUtils pdfUtil;
	
	/**
	 * Inyeccion de servicio Correo
	 */
	@Autowired
	private ArchivoZipService archivoZipService;
	
	/**
	 * reimpresionTramitesService
	 */
	@Autowired
	private ReimpresionTramitesService reimpresionTramitesService;
	
	/**
	 * Inyeccion de dependencia fechaUtils
	 */
    @Autowired
	private FechaUtils fechaUtils;
	
	/**
	 * rutaDocumentos
	 */
	@Value("${ruta.archivos.docs}")
	private String rutaDocumentos;
	
	/**
	 * ruta donde se depositaran los pdf
	 */
	@Value("${ruta.carpeta.expediente}")
	private String rutaDestino;
	
	/**
	 * rutaDocumentos
	 */
	@Value("${ruta.plantilla.solicitud.permanencia.datos}")
	private String rutaDocumetosPermanencia;
	
	/**
	 * catalogoService
	 */
	@Autowired
	private CatalogoService catalogoService;
	
	/**
	 * Obtiene lista de rutas de archivos mediante el folio procesar
	 * Nota: Se modifica la extraccion del servicio mediante DeserializationFeature y evitar un array list exception 
	 * cuando existe 
	 * un solo elemento de la lista de entrada
	 * @param folioProcesar
	 * @return
	 */
	
	@Override
	public DatosArchivos obtenerArchivosReimpresion(DatosTrabajador trabajador) throws IOException {
		logger.error("Inicia extracción de archivo permanencia:{}",trabajador.getDatosCertificables().getCurp());
		DatosArchivos archivos;
		TramitesConcluidos tramitesConcluidos=reimpresionTramitesService.obtenerTramitesConcluidos(llenarEntradaTramitesConcluidos(trabajador));
		if(tramitesConcluidos==null || tramitesConcluidos.getChPeticion()==null) {
			return reimpresionTramitesService.obtenerMensajeSinDatos();
		}
		Permanencia permanencia=reimpresionTramitesService.convertirJsonObjeto(tramitesConcluidos.getChPeticion(),Permanencia.class);
		archivos=obtenerDatosArchivo(trabajador,permanencia,tramitesConcluidos.getFolioProcesar());	
		if(archivos.getByteArchivo()==null ||archivos.getByteArchivo().isEmpty()) {
			return reimpresionTramitesService.obtenerMensajeSinDatos();
		}
		archivos.setIdSegTramite(tramitesConcluidos.getIdTramite().toString());
		return archivos;
	}
	
	/**
	 * enviarCorreoReimpresion
	 */
	@Override
	public RespuestaServicio enviarCorreoReimpresion(DatosArchivos datos,DatosTrabajador trabajador, String folioProcesar,Integer modulo,String claveAgente)  {
		String claveDocumento = reimpresionTramitesService.obtenerTipoClaveDocumento(modulo);
		return reimpresionTramitesService.enviarCorreoReimpresion(datos, trabajador, folioProcesar, claveDocumento,CorreoEnum.ARCHIVO_REIMPRESION,claveAgente);
	}

	/**
	 * obtieneExistenciaCorreoElectronico
	 * @param trabajador
	 * @return
	 */
	@Override
	public RespuestaServicio obtenerExistenciaCorreoElectronico(DatosTrabajador trabajador) {	
		return reimpresionTramitesService.obtenerExistenciaCorreoElectronico(trabajador);	
	}
   
	
	/**
	 * llenarEntradaTramitesConcludos
	 * @return
	 */
	private TramitesConcluidosEntrada llenarEntradaTramitesConcluidos(DatosTrabajador trabajador) {
		TramitesConcluidosEntrada tramitesConcluidosEntrada = new TramitesConcluidosEntrada();
		tramitesConcluidosEntrada.setAfore(trabajador.getClaveAfore());
		tramitesConcluidosEntrada.setCurp(trabajador.getDatosCertificables().getCurp());
		tramitesConcluidosEntrada.setCvServicio(FormatoConstants.CLAVE_SERVICIO_NUEVA_PERMANENCIA);
		tramitesConcluidosEntrada.setSubTipoSolicitante(SubTipoSolicitanteEnum.PERMANENCIA.getClaveSubTipoSolicitante());
		logger.error("Entrada tramites concluidos permanencia:{}",reimpresionTramitesService.convertirObjetoToJson(tramitesConcluidosEntrada));
		return tramitesConcluidosEntrada;
		
	}
	

	/**
	 * obtenerDatosArchivo
	 * @param trabajador
	 * @return
	 * @throws IOException
	 */
	private DatosArchivos obtenerDatosArchivo(DatosTrabajador trabajador,Permanencia permanencia,String folioHijo) throws IOException {
		DatosArchivos datosArchivos = new DatosArchivos();
		datosArchivos.setByteArchivo(DatatypeConverter.printBase64Binary(modificarPdf(trabajador,permanencia,folioHijo)) );
		datosArchivos.setFormato(FormatoConstants.TIPO_EXTENSION_PDF);
		datosArchivos.setNombreArchivo(trabajador.getClaveAfore());
		datosArchivos.setFolioProcesar(permanencia.getFolioCliente());
		return datosArchivos;
		
	}
	
	/**
	 * obtenerPlantilla
	 * @param resource
	 * @return
	 * @throws IOException
	 */
	public PDDocument obtenerPlantilla(String resource) throws IOException {
		return PDDocument.load(new File(resource));
	}
	
	/**
	 * 
	 * @param trabajador
	 * @return
	 * @throws IOException
	 */
    private byte[] modificarPdf(DatosTrabajador trabajador,Permanencia permanencia,String folio) throws IOException {
    	logger.error("Inicia escritura de pdf permanencia :{}",trabajador.getDatosCertificables().getCurp()); 
    	PDDocument pdfDocument = null;
    	PermanenciaReportesEnum solicitante=PermanenciaReportesEnum.obtenerArchivo(trabajador.getClaveAfore()); 
		try {
			switch (solicitante) {
				case PENSIONISSSTE:
					String folioSolicitud = generarFolioSolicitud(folio);
					String fechaRecepcionSolicitud = fechaUtils.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_RENAPO);
					pdfDocument = obtenerPlantilla(obtenerArchivoPorAfore(solicitante.getNombreArchivo()));
					escribirPdfPensionIssste(permanencia,pdfDocument,folioSolicitud,fechaRecepcionSolicitud);
					escribirPdfPensionIssstePaginaDos(permanencia,pdfDocument,folioSolicitud,fechaRecepcionSolicitud);
				break;
				case CITIBANAMEX_AFORE:
				
				break;
				case AFORE_AZTECA:
				
				break;
				default:
				break;
		}

		}catch(Exception e) {
			throw new BusinessException("Existe un problema con la extracción o la lectura del archivo",e);
		}
		return archivoZipService.obtenerPdfPermanencia(pdfDocument);
    }
    
    
   
    /**
	 * obtenerArchivoPorAfore
	 * @param trabajador
	 * @return
	 */
	private String obtenerArchivoPorAfore(String nombreArchivo) {
		StringBuilder ruta= new StringBuilder();
		ruta.append(rutaDocumetosPermanencia);
		ruta.append(nombreArchivo);
		ruta.append(FormatoConstants.EXTENSION_PDF);
		return ruta.toString();
		
	}
	
	/**
	 * escribirPdfPensionIssste
	 * @param permanencia
	 * @param pdfDocument
	 */
	private void escribirPdfPensionIssste(Permanencia permanencia,PDDocument pdfDocument,String folioSolicitud,String fechaRecepcionSolicitud) {
		int numeroPagina = 0;
		
		try {
			pdfUtil.agregarTexto(folioSolicitud,pdfDocument,numeroPagina, 495, 750);
			pdfUtil.agregarTexto(fechaRecepcionSolicitud,pdfDocument,numeroPagina, 430, 676);
			
			pdfUtil.agregarTexto(permanencia.getCuerpo().getNombreTrabajador(),pdfDocument,numeroPagina, 135, 636);
			pdfUtil.agregarTexto(permanencia.getCuerpo().getApellidoPaterno(),pdfDocument,numeroPagina, 135, 623);
			pdfUtil.agregarTexto(permanencia.getCuerpo().getApellidoMaterno() == null ? ExpresionesConstants.VACIO : permanencia.getCuerpo().getApellidoMaterno(),pdfDocument,numeroPagina, 135, 608);
			pdfUtil.agregarTexto(formatearFechas(permanencia.getCuerpo().getFechaDeNacimiento()),pdfDocument,numeroPagina, 135, 595);
			pdfUtil.agregarTexto(catalogoService.obtenerEntidadFederativaComunes(permanencia.getCuerpo().getEntidadFederativaDeNacimiento()).getDescripcion(),pdfDocument,numeroPagina, 135, 580);
			
			pdfUtil.agregarTexto(permanencia.getCuerpo().getCurpTrabajador(),pdfDocument,numeroPagina, 418, 636);
			pdfUtil.agregarTexto(permanencia.getCuerpo().getNssTrabajador()==null ?ExpresionesConstants.VACIO:permanencia.getCuerpo().getNssTrabajador(), pdfDocument,numeroPagina, 418, 623);
			pdfUtil.agregarTexto(permanencia.getCuerpo().getRfc()== null ? ExpresionesConstants.VACIO : permanencia.getCuerpo().getRfc(),pdfDocument,numeroPagina, 418, 608);
			pdfUtil.agregarTexto(obtenerGeneroFM(permanencia.getCuerpo().getGenero().toString()),pdfDocument,numeroPagina, 418, 595);
			pdfUtil.agregarTexto(permanencia.getCuerpo().getNacionalidad(),pdfDocument,numeroPagina, 418, 580);
			
			
			if(permanencia.getCuerpo().getDatosParticulares() != null){	
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getCalle().toUpperCase(),pdfDocument,numeroPagina, 126, 375); 
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getColonia().toUpperCase(),pdfDocument,numeroPagina, 126, 360); 
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getDelegacionOMunicipio() ,pdfDocument,numeroPagina, 126, 345);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getEntidadFederativa() ,pdfDocument,numeroPagina, 126, 331);
				
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getNumeroExterior()==null?ExpresionesConstants.VACIO: permanencia.getCuerpo().getDatosParticulares().getNumeroExterior() ,pdfDocument,numeroPagina, 410, 375);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getNumeroInterior()==null?ExpresionesConstants.VACIO:permanencia.getCuerpo().getDatosParticulares().getNumeroInterior() ,pdfDocument,numeroPagina, 523, 375);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getCodigoPostal() ,pdfDocument,numeroPagina, 410, 360);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getPais(),pdfDocument,numeroPagina, 410, 346); 
				
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getTelefono1() ,pdfDocument,numeroPagina, 180, 295);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getExtension1() ,pdfDocument,numeroPagina, 305, 295);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getTelefono2() ,pdfDocument,numeroPagina, 180, 280);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getExtension2() ,pdfDocument,numeroPagina, 305, 280);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDatosParticulares().getCorreoElectronicoDelTrabajador() ,pdfDocument,numeroPagina, 90, 265);
			}
			
			if(permanencia.getCuerpo().getDomicilioLaboral() != null){	
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDomicilioLaboral().getCalle().toUpperCase() ,pdfDocument,numeroPagina, 126 , 198);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDomicilioLaboral().getColonia().toUpperCase(),pdfDocument,numeroPagina, 126 , 183);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDomicilioLaboral().getDelegacionOMunicipio() ,pdfDocument,numeroPagina, 126 , 168);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDomicilioLaboral().getEntidadFederativa() ,pdfDocument,numeroPagina, 126 , 154);
				
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDomicilioLaboral().getNumeroExterior()==null?ExpresionesConstants.VACIO:permanencia.getCuerpo().getDomicilioLaboral().getNumeroExterior(),pdfDocument,numeroPagina, 410 , 198);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDomicilioLaboral().getNumeroInterior()==null?ExpresionesConstants.VACIO: permanencia.getCuerpo().getDomicilioLaboral().getNumeroInterior(),pdfDocument,numeroPagina, 523 , 198);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDomicilioLaboral().getCodigoPostal(),pdfDocument,numeroPagina, 410 , 183);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getDomicilioLaboral().getPais(),pdfDocument,numeroPagina, 410 , 168); 
			}
			
			
			pdfUtil.agregarTexto(permanencia.getCuerpo().getOcupacionOProfesionTrabajador()==null?ExpresionesConstants.VACIO:catalogoService.consultaValorParametro(permanencia.getCuerpo().getOcupacionOProfesionTrabajador(),FormatoConstants.OCUPACION_TRABAJADOR),pdfDocument,numeroPagina, 90 , 118);
			pdfUtil.agregarTexto(permanencia.getCuerpo().getActividadOGiroNegocioTrabajador()==null?ExpresionesConstants.VACIO:catalogoService.consultaValorParametro(permanencia.getCuerpo().getActividadOGiroNegocioTrabajador(),FormatoConstants.ACTIVIDAD_GIRO),pdfDocument,numeroPagina, 130 , 103);
			pdfUtil.agregarTexto(permanencia.getCuerpo().getNivelDeEstudioTrabajador()==null?ExpresionesConstants.VACIO:catalogoService.consultaValorParametro(permanencia.getCuerpo().getNivelDeEstudioTrabajador(),FormatoConstants.NIVEL_ESTUDIOS),pdfDocument,numeroPagina, 130 , 88);
			
		
		
		} catch (Exception e) {
			logger.error("Error al escribir pdf issste pagina uno",e);
		}
		
	}
	
	private void escribirPdfPensionIssstePaginaDos(Permanencia permanencia,PDDocument pdfDocument,String folioSolicitud,String fechaRecepcionSolicitud) {
		int numeroPaginaDos = 1;
		try{
			pdfUtil.agregarTexto(folioSolicitud,pdfDocument,numeroPaginaDos, 495, 750);
			pdfUtil.agregarTexto(fechaRecepcionSolicitud,pdfDocument,numeroPaginaDos, 430, 678);
			
			if(permanencia.getCuerpo().getBeneficiarios() != null){
				List<DatosBeneficiarioTrabajador> listaBeneficiarios = permanencia.getCuerpo().getBeneficiarios().getBeneficiario();
				if(!listaBeneficiarios.isEmpty()){
					regresarBeneficiariosPeis(listaBeneficiarios, pdfDocument,numeroPaginaDos);
				}	
			}
			
			if(permanencia.getCuerpo().getReferencias() != null){
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getNombreDeReferencia1().toUpperCase(),pdfDocument,numeroPaginaDos, 114 , 625);  
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getApellidoPaternoDeReferencia1().toUpperCase(),pdfDocument,numeroPaginaDos, 114 , 610); 
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getApellidoMaternoDeReferencia1()==null?ExpresionesConstants.VACIO:permanencia.getCuerpo().getReferencias().getApellidoMaternoDeReferencia1().toUpperCase(),pdfDocument,numeroPaginaDos, 114 , 595); 
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getCurpDeReferencia1(),pdfDocument,numeroPaginaDos, 114 , 580);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getParentescoORelacionDeReferencia1(),pdfDocument,numeroPaginaDos, 114 , 565);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getTelefonoDeReferencia1(),pdfDocument,numeroPaginaDos, 114 , 552);
			
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getNombreDeReferencia2().toUpperCase(),pdfDocument,numeroPaginaDos, 410 , 625);  
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getApellidoPaternoDeReferencia2().toUpperCase(),pdfDocument,numeroPaginaDos, 410 , 610); 
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getApellidoMaternoDeReferencia2()==null?ExpresionesConstants.VACIO :permanencia.getCuerpo().getReferencias().getApellidoMaternoDeReferencia2().toUpperCase(),pdfDocument,numeroPaginaDos, 410 , 595); 
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getCurpDeReferencia2(),pdfDocument,numeroPaginaDos, 410 , 580);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getParentescoORelacionDeReferencia2(),pdfDocument,numeroPaginaDos, 410 , 565);
				pdfUtil.agregarTexto(permanencia.getCuerpo().getReferencias().getTelefonoDeReferencia2(),pdfDocument,numeroPaginaDos, 410 , 552);
			}
			pdfUtil.agregarTexto(permanencia.getSelloVoluntadTrabajador()==null ? ExpresionesConstants.VACIO : permanencia.getSelloVoluntadTrabajador(),pdfDocument,numeroPaginaDos, 60 ,190);
		}catch(Exception e){
			logger.error("Error al escribir pdf issste pagina dos",e);
		}
		
	}
	
	
	/**
	 * Metodo que regresa beneficiarios peis
	 * @param listaBeneficiarios
	 * @param canvas
	 * @throws IOException 
	 */
	private void regresarBeneficiariosPeis(List<DatosBeneficiarioTrabajador> listaBeneficiarios,PDDocument pdfDocument,Integer numeroPaginaDos) throws IOException{
			for (int i = 0; i < listaBeneficiarios.size(); i++) {	
				pdfUtil.agregarTexto(listaBeneficiarios.get(i).getApellidoPaternoDeBeneficiario().toUpperCase(),pdfDocument,numeroPaginaDos, 50 , 490 - (15* i));
				pdfUtil.agregarTexto(listaBeneficiarios.get(i).getApellidoMaternoDeBeneficiario()==null?ExpresionesConstants.VACIO:listaBeneficiarios.get(i).getApellidoMaternoDeBeneficiario(),pdfDocument,numeroPaginaDos, 170 , 490 - (15* i));
				pdfUtil.agregarTexto(listaBeneficiarios.get(i).getNombreDeBeneficiario().toUpperCase(),pdfDocument,numeroPaginaDos, 250 , 490 - (15* i));
				pdfUtil.agregarTexto(listaBeneficiarios.get(i).getCurpDeBeneficiario(),pdfDocument,numeroPaginaDos, 400 , 490 - (15* i));
				pdfUtil.agregarTexto(listaBeneficiarios.get(i).getParentescoORelacion()==null?ExpresionesConstants.VACIO:listaBeneficiarios.get(i).getParentescoORelacion(),pdfDocument,numeroPaginaDos , 535 , 490 - (15* i));
				pdfUtil.agregarTexto(listaBeneficiarios.get(i).getPorcentajeDeBeneficiario(),pdfDocument,numeroPaginaDos, 572 , 490 - (15* i));
			}			
	}
	
	/**
	 * generarFolioSolicitud
	 * @param folio
	 * @return
	 */
	private String generarFolioSolicitud(String folio) {	
		return folio.substring(10, 20);		
	}
   
	
	/**
	 * Da el formato a una fecha
	 * @param formato
	 * @param fecha
	 * @return
	 */

	private String formatearFechas(Date fecha) {
		SimpleDateFormat formatoFinal = new SimpleDateFormat(FormatoConstants.FORMATO_DDMMYYYY);
		String fechaFinal = null;
		if (fecha != null) {
			fechaFinal = formatoFinal.format(fecha);
		}
		return fechaFinal;
	}
	
	/**
	 * Obtiene la descripcion del Genero
	 * 
	 * @param genero
	 * @return Femenino - F <br>
	 *         Masculino - M <br>
	 */
	private String obtenerGeneroFM(String genero) {
		String generoSal = "";
		if (!genero.isEmpty()) {
			if (FormatoConstants.DOS_STR.contentEquals(genero)) {
				generoSal = FormatoConstants.FEMENINO;
			} else if (FormatoConstants.UNO.contentEquals(genero)) {
				generoSal = FormatoConstants.MASCULINO;
			}else {
				generoSal = genero;
			}
		}
		return generoSal;
	}
}
