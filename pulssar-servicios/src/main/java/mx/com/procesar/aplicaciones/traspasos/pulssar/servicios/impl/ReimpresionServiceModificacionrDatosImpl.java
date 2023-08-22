package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ArchivoZipService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionTramitesService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.CorreoEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.SubTipoSolicitanteEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.TipoSolcitanteEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivosDescargados;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaFilenet;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.TramitesConcluidosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.RestServiceClientUtils;

/**
 * ReimpresionServiceImpl
 * @author jmordone
 *
 */
@Qualifier("modificacionDatos")
@Service
public class ReimpresionServiceModificacionrDatosImpl implements ReimpresionService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ReimpresionServiceModificacionrDatosImpl.class);

	/**
	 * urlFilenet
	 */
	@Value("${url.servicio.filenet.post}")
	private String urlFilenet;
	
	/**
	 * restServiceClientUtils
	 */
	@Autowired
	private RestServiceClientUtils restServiceClientUtils;
	
	/**
	 * archivoZipService
	 */
	@Autowired
	private ArchivoZipService archivoZipService;
	
	/**
	 * reimpresionTramitesService
	 */
	@Autowired
	private ReimpresionTramitesService reimpresionTramitesService;
	
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
		logger.error("Inicia extracción de archivo modificador de datos:{}",trabajador.getDatosCertificables().getCurp());
		DatosArchivos listaRutasDeArchivoPorServicio = null;
		TramitesConcluidos tramitesConcluidos=reimpresionTramitesService.obtenerTramitesConcluidos(llenarEntradaTramitesConcluidos(trabajador));
		if(tramitesConcluidos==null ||  tramitesConcluidos.getTipoSolicitante()==null) {
			return reimpresionTramitesService.obtenerMensajeSinDatos();
		}
		listaRutasDeArchivoPorServicio=listaDeArchivosExtraidosPorFilenet(trabajador,tramitesConcluidos);	
		if(listaRutasDeArchivoPorServicio.getByteArchivo()==null || listaRutasDeArchivoPorServicio.getByteArchivo().isEmpty()) {
			return reimpresionTramitesService.obtenerMensajeSinDatos();
		}
		listaRutasDeArchivoPorServicio.setIdSegTramite(tramitesConcluidos.getIdTramite().toString());
		return listaRutasDeArchivoPorServicio;
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
	 * listaDeArchivosExtraidosPorZipOFilenet
	 * @param archivoRecibido
	 * @return
	 * @throws IOException
	 */
	private DatosArchivos listaDeArchivosExtraidosPorFilenet (DatosTrabajador trabajador,TramitesConcluidos tramitesConcluidos)  {
		  List<DatosArchivos> listaDeArchivosExtraidosPorZip=new ArrayList<>();
		  List<DatosArchivosDescargados> listaDatosArchivosDescargados = obtenerArchivosFilenet(trabajador,tramitesConcluidos);	
		  if (!listaDatosArchivosDescargados.isEmpty()) {
			  listaDeArchivosExtraidosPorZip = obtenerDatosArchivos(listaDatosArchivosDescargados,tramitesConcluidos); 
		  }	 
	   return reimpresionTramitesService.obtenerPdfPorClave(listaDeArchivosExtraidosPorZip,MenuReimpresionEnum.SOLICITUD_MODIFICACION_DATOS.getIdMenuReimpresion());
	}
	
	/**
	 * obtenerArchivosFilenet
	 * @param idFolio
	 * @param curp
	 * @param afore
	 * @param proceso
	 * @return
	 * @throws IOException
	 */
	private List<DatosArchivosDescargados> obtenerArchivosFilenet(DatosTrabajador trabajador,TramitesConcluidos tramitesConcluidos)  {
		List<DatosArchivosDescargados> datosArchivoDescargados= new ArrayList<>();
		StringBuilder url = new StringBuilder();
		url.append(urlFilenet);
		url.append(ServiciosConstants.URL_FILENET);
		try {
			logger.error("Url obtenerArchivosFilenet:{}",urlFilenet);
			byte [] salida=restServiceClientUtils.ejecutarServicioPost(url.toString(),obtenerEntradaFilenet (trabajador,tramitesConcluidos), byte[].class);
			InputStream input = new ByteArrayInputStream(salida);
			datosArchivoDescargados=archivoZipService.llenarDatosZip(input);
		}catch(Exception e) {
			throw new BusinessException("Existe un error en la lectura del servicio Filenet para modificador de datos",e);
		}
		return datosArchivoDescargados;
		
	}	
	
	/**
	 * obtenerDatosArchivos
	 * @param listaDatosArchivosDescargados
	 * @return
	 */
	private List<DatosArchivos> obtenerDatosArchivos(List<DatosArchivosDescargados> listaDatosArchivosDescargados,TramitesConcluidos tramitesConcluidos) {
		List<DatosArchivos> lstArchivos = new ArrayList<>();
		
		for (DatosArchivosDescargados archivoDesc : listaDatosArchivosDescargados) {
			DatosArchivos datos = new DatosArchivos();
			datos.setFormato(archivoDesc.getFormato());
			datos.setByteArchivo(archivoDesc.getByteArchivo());
			datos.setNombreArchivo(archivoDesc.getNombreArchivo());
			datos.setFolioProcesar(tramitesConcluidos.getFolioProcesar());
			lstArchivos.add(datos);
		}
		return lstArchivos;
	}
	
	/**
	 * Entrada filenet
	 * @return
	 */
	private EntradaFilenet obtenerEntradaFilenet (DatosTrabajador trabajador,TramitesConcluidos tramitesConcluidos) {
		EntradaFilenet entradaFilenet  = new EntradaFilenet();
		entradaFilenet.setProceso(obtenerTipoProceso(tramitesConcluidos.getTipoSolicitante()));
		entradaFilenet.setCurp(trabajador.getDatosCertificables().getCurp());
		entradaFilenet.setAfore(trabajador.getClaveAfore());
		logger.error("Peticion obtenerArchivosFilenet:{}",reimpresionTramitesService.convertirObjetoToJson(entradaFilenet));
		return entradaFilenet;
	}
	
	/**
	 * llenarEntradaTramitesConcludos
	 * @return
	 */
	private TramitesConcluidosEntrada llenarEntradaTramitesConcluidos(DatosTrabajador trabajador) {
		TramitesConcluidosEntrada tramitesConcluidosEntrada = new TramitesConcluidosEntrada();
		tramitesConcluidosEntrada.setAfore(trabajador.getClaveAfore());
		tramitesConcluidosEntrada.setCurp(trabajador.getDatosCertificables().getCurp());
		tramitesConcluidosEntrada.setCvServicio(FormatoConstants.CLAVE_SERVICIO_MODIFICADOR_PERMANENCIA);
		tramitesConcluidosEntrada.setSubTipoSolicitante(SubTipoSolicitanteEnum.MODIFICADOR_DATOS.getClaveSubTipoSolicitante());
		logger.error("Entrada tramites concluidos modificador de datos:{}",reimpresionTramitesService.convertirObjetoToJson(tramitesConcluidosEntrada));
		return tramitesConcluidosEntrada;
		
	}
	
	/**
	 * obtenerTipoProceso
	 * @param tipoSolicitante
	 * @return
	 */
	private String obtenerTipoProceso(String tipoSolicitante) {	
		TipoSolcitanteEnum solicitante=TipoSolcitanteEnum.obtenerTipoSolicitante(tipoSolicitante);
	  return solicitante.getClaveTipoProceso();
	}
}
