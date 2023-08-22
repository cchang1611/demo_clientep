package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ExpedienteServicioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RecepcionArchivosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Archivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CatalogoDocumentoRequerido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosBaseCurp;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCertificables;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpedienteGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Domicilio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaModificacion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaPermanencia;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;

@Service
public class DocumentosGenericoServiceImpl implements DocumentosGenericoService{

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DocumentosGenericoServiceImpl.class);
	
	
	/**
	 * utileriaCadena
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * utileriaValidador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;
	
	/**
	 * restTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * recepcionArchivosService
	 */
	@Autowired
	private RecepcionArchivosService recepcionArchivosService;
	
	/**
	 * utileriaFecha
	 */
	@Autowired
	private FechaUtils utileriaFecha;
	
	/**
	 * Url documentos genericos
	 */
	@Value("${comunes.documentos.generico}")
	private String documentosUrl;
	
	/**
	 * documentosAdicionalUrl
	 */
	@Value("${comunes.documento.adicional.generico}")
	private String documentosAdicionalUrl;
	
	/**
	 * Url de consumo de comunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;
	
	/**
	 * urlRutaExpedientes
	 */
	@Value("${ruta.carpeta.expediente}")
	private String urlRutaExpedientes;
	
	/**
	 * Inyeccion de expediente
	 */
	@Autowired
	private ExpedienteService servicioExpediente;
	
	/**
	 * Inyeccion de expediente servicio
	 */
	@Autowired
	private ExpedienteServicioService expedienteServicio;
	

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService#obtenerDatosExpediente(java.lang.Object)
	 */
	@Override
	public DatosExpedienteGenerico obtenerDatosExpediente(Object datosPersonales) {
		DatosExpedienteGenerico datos = null;
		if(!utileriaValidador.validarObjetoNulo(datosPersonales)) {
			datos = new DatosExpedienteGenerico();
			String tipoSolicitante = "";
			String curp = "";
			String nss = "";
			String nombre = "";
			String apellidoPaterno = "";
			String apellidoMaterno = "";
			
			if(datosPersonales instanceof DatosTrabajador) {
				DatosTrabajador trabajador = (DatosTrabajador) datosPersonales;
				DatosCertificables datosCer = trabajador.getDatosCertificables();
				curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosCer.getCurp(), ExpresionesConstants.VACIO);
				nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getNss(), ExpresionesConstants.VACIO);
				nombre = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosCer.getNombre(), ExpresionesConstants.VACIO);
				apellidoPaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosCer.getApellidoPaterno(), ExpresionesConstants.VACIO);
				apellidoMaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosCer.getApellidoMaterno(), ExpresionesConstants.VACIO);
				tipoSolicitante = utileriaCadena.obtenerContenidoCadenaSinEspacios(trabajador.getTipoSolicitante(), ExpresionesConstants.VACIO);
			} else if(datosPersonales instanceof EntradaModificacion) {
				EntradaModificacion entradaModificacion = (EntradaModificacion) datosPersonales;
				DatosBaseCurp datosBase = entradaModificacion.getDatosBaseCurp();
				curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getCurpNueva(), ExpresionesConstants.VACIO);
				nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaModificacion.getNss(), ExpresionesConstants.VACIO);
				nombre = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getNombreTrabajador(), ExpresionesConstants.VACIO);
				apellidoPaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getApellidoPaterno(), ExpresionesConstants.VACIO);
				apellidoMaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getApellidoMaterno(), ExpresionesConstants.VACIO);
				tipoSolicitante = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosBase.getTipoSolicitante(), ExpresionesConstants.VACIO);
			} else if(datosPersonales instanceof EntradaPermanencia) {
				EntradaPermanencia entradaPermanencia = (EntradaPermanencia) datosPersonales;
				curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getCurpTrabajador(), ExpresionesConstants.VACIO);
				nss = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getNssTrabajador(), ExpresionesConstants.VACIO);
				nombre = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getNombreTrabajador(), ExpresionesConstants.VACIO);
				apellidoPaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getApellidoPaterno(), ExpresionesConstants.VACIO);
				apellidoMaterno = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getApellidoPaterno(), ExpresionesConstants.VACIO);
				tipoSolicitante = utileriaCadena.obtenerContenidoCadenaSinEspacios(entradaPermanencia.getTipoSolicitante(), ExpresionesConstants.VACIO);
			}
			
			datos.setTipoSolicitante(tipoSolicitante);
			datos.setCurp(curp);
			datos.setNss(nss);
			datos.setNombre(nombre);
			datos.setApellidoPaterno(apellidoPaterno);
			datos.setApellidoMaterno(apellidoMaterno);
		}
		return datos;
	}
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService#obtenerDatosExpediente(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosExpedienteGenerico, java.lang.Object)
	 */
	@Override
	public DatosExpedienteGenerico obtenerDatosExpediente(DatosExpedienteGenerico datosExpe, Object datosDomicilio) {
		DatosExpedienteGenerico auxiliar = datosExpe;
		String calle = "";
		String noExterior = "";
		String noInterior = "";
		String colonia = "";
		String municipio = "";
		String entidad = "";
		String codigoPostal = "";
		
		if(datosDomicilio instanceof DatosTrabajador) {
			DatosTrabajador trabajador = (DatosTrabajador) datosDomicilio;
			Domicilio domicilio = trabajador.getDatosComplementarios().getParticular();
			if(!isEmpty(domicilio)) {
				calle = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCalle(), ExpresionesConstants.VACIO);
				noExterior = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNoExterior(), ExpresionesConstants.VACIO);
				noInterior = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getNoInterior(), ExpresionesConstants.VACIO);
				colonia = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getColonia(), ExpresionesConstants.VACIO);
				municipio = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getMunicipio(), ExpresionesConstants.VACIO);
				entidad = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getEntidadFederativa(), ExpresionesConstants.VACIO);
				codigoPostal = utileriaCadena.obtenerContenidoCadenaSinEspacios(domicilio.getCodigoPostal(), ExpresionesConstants.VACIO);
			}
		}
		
		datosExpe.setCalle(calle);
		datosExpe.setNoExterior(noExterior);
		datosExpe.setNoInterior(noInterior);
		datosExpe.setColonia(colonia);
		datosExpe.setMunicipio(municipio);
		datosExpe.setEntidadFed(entidad);
		datosExpe.setCodigoPostal(codigoPostal);
		
		return auxiliar;
	}
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService#obtenerTipoDocumento(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Combo> obtenerTipoDocumento(String claveTipoProceso, String afore) {
		logger.info("Se obtiene la lista de tipo documento completo");
		try {
			String urlDocumentos = StringUtils.join(documentosUrl, "/", claveTipoProceso, "/", afore);
			ResponseEntity<List<Combo>> respuestaSalida = restTemplate.exchange(urlDocumentos, HttpMethod.GET, null, new ParameterizedTypeReference<List<Combo>>() {});
			
			if(!isEmpty(respuestaSalida) && !isEmpty(respuestaSalida.getBody())) {
				return respuestaSalida.getBody();
			}
		} catch (Exception e) {
			logger.error("obtenerTipoDocumento -> Se presenta un error al obtener Documentos", e);
		}
		return new ArrayList<>();
	}

	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService#obtenerTipoDocumentoAdicional(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Combo> obtenerTipoDocumentoAdicional(String docAdicional, String afore) {
		logger.info("Se obtiene documento adicional");
		try {
			String urlDocumentos = StringUtils.join(documentosAdicionalUrl, "/", docAdicional, "/", afore);
			ResponseEntity<List<Combo>> respuestaSalida = restTemplate.exchange(urlDocumentos, HttpMethod.GET, null, new ParameterizedTypeReference<List<Combo>>() {});
			logger.info("Se obtiene documento adicional: {}", respuestaSalida);
			
			if(!isEmpty(respuestaSalida) && !isEmpty(respuestaSalida.getBody())) {
				return respuestaSalida.getBody();
			}
		} catch (Exception e) {
			logger.error("obtenerTipoDocumentoAdicional -> Se presenta un error al obtener Documentos", e);
		}
		return new ArrayList<>();
	}

    /* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService#verificarSiEsValido(java.util.List, java.util.Map)
	 */
	@Override
	public boolean verificarSiEsValido(List<Combo> docs, Map<String, MultipartFile> multipart) {
		for (Combo combo : docs) {
			if (combo.getBandera() == 1) {
				for (Combo subd : combo.getSubDocumentos()) {
					if (multipart.containsKey(subd.getClave()) && multipart.get(subd.getClave()).getSize() > 0) {
						return true;
					}
				}
			}
		}
		
		throw new BusinessException("Adjunte al menos un documento Obligatorio");
		
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService#obtenerComboRetiros(java.lang.String, java.lang.String)
	 */
	@Override
	public Map<String, List<Combo>> obtenerComboRetiros(String claveTipoProceso, String afore) {
		List<Combo> list = obtenerTipoDocumentoRetiros(claveTipoProceso, afore);
		List<Combo> obligatorios = new ArrayList<>();
		List<Combo> noObligatorios = new ArrayList<>();
		HashMap<String, List<Combo>> map = new HashMap<>();
		
		for (Combo c : list) {
			if (c.getBandera() == 1) {
				obligatorios.add(c);
			} else {
				noObligatorios.add(c);
			}
		}
		
		map.put("obligatorios", obligatorios);
		map.put("noObligatorios", noObligatorios);
		
		return map;
	}

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService#obtenerTipoDocumentoRetiros(java.lang.String, java.lang.String)
	 */
	@Override
	public List<Combo> obtenerTipoDocumentoRetiros(String claveTipoProceso, String afore) {
		logger.info("Se obtiene la lista de tipo documento completo");
		List<Combo> combos = new ArrayList<>();
		try {
			String urlDocumentos = StringUtils.join(uriComunes, "catalogo/catalogoDocumentoRequerido/", claveTipoProceso, "/", afore);
			ResponseEntity<List<CatalogoDocumentoRequerido>> respuestaSalida = restTemplate.exchange(urlDocumentos, HttpMethod.GET, null, new ParameterizedTypeReference<List<CatalogoDocumentoRequerido>>() {});
			logger.info("resultado: {}", respuestaSalida);
			if(!isEmpty(respuestaSalida) && !isEmpty(respuestaSalida.getBody())) {
				List<CatalogoDocumentoRequerido> lista = respuestaSalida.getBody();
				for(CatalogoDocumentoRequerido doc : lista){
					Combo combo = new Combo();
					combo.setBandera(doc.getNuObligatorio());
					combo.setClave(doc.getCvTipoDocDigital());
					combo.setClaveDocumento(doc.getCvTipoProceso());
					combo.setDescripcion(doc.getChDescDocDigital());
					List<Combo> subCombo = new ArrayList<>();
					subCombo.add(combo);
					combo.setSubDocumentos(subCombo);
					combos.add(combo);
				}
			}
		} catch (Exception e) {
			logger.error("obtenerTipoDocumentoAdicional -> Se presenta un error al obtener Documentos", e);
		}
		logger.info("combos: {}", combos);
				return combos;
	}
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService#obtenerCombo(java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
	 */
	@Override
	public Map<String, List<Combo>> obtenerCombo(String tipoDocumento, String afore, String exclusion, String [] adicional) {
		List<Combo> list = obtenerTipoDocumento(tipoDocumento, afore);
		List<Combo> obligatorios = new ArrayList<>();
		List<Combo> noObligatorios = new ArrayList<>();
		HashMap<String, List<Combo>> map = new HashMap<>();
		
		for(Combo c: list) {
			if(c.getClave().equals(exclusion)) {
				ArrayList<Combo> temp = new ArrayList<>();
				temp.add(c);
				map.put("exclusion", temp);
			} else if(c.getBandera() == 1) {
				obligatorios.add(c);
			}else {
				noObligatorios.add(c);
			}
		}
		
		if(!utileriaValidador.validarObjetoNulo(adicional)) {
			logger.info("adicional length: {}", adicional.length);
			
			logger.info("adicional length: {} , {}", adicional[0], adicional[1]);
			for(int i= 0; i< adicional.length; i=i+2){
				List<Combo> comboAd = obtenerTipoDocumentoAdicional(adicional[i], afore); 
				if(!comboAd.isEmpty() && comboAd.iterator().hasNext()) {
					
					Combo adic = comboAd.iterator().next();
					if("1".equals(adicional[i+1])) {
						adic.setBandera(1);
						obligatorios.add(adic);
					}else {
						adic.setBandera(0);
						noObligatorios.add(adic);
					}
					map.put("adicional", comboAd);
				}
			}
		}
		
		map.put("obligatorios", obligatorios);
		map.put("noObligatorios", noObligatorios);
		
		return map;
	}
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ArchivosUtils#obtenerDocumentos(java.util.List, org.springframework.web.multipart.MultipartHttpServletRequest)
	 */
	public Map<String, MultipartFile> limpiarYValidarMultipart(Map<String, MultipartFile> multipart) {
		Map<String, MultipartFile> multiCln = new  HashMap<>();
		for(Entry<String, MultipartFile> entry : multipart.entrySet()) {
			if(entry.getValue().getSize() != 0 ) {
				String extension =  entry.getValue().getOriginalFilename().substring(entry.getValue().getOriginalFilename().indexOf(AgenteConstants.PUNTO));
				Integer maximoTamanio = 1 * 1024 * 1024;
				Integer minimoTamanio = 2 * 1024;
				Integer tamanio = Integer.valueOf((int) entry.getValue().getSize());
				if(extension.contains(GeneradorPdfConstants.EXTENSIONES_ACEPTADAS)){
					throw new BusinessException("G024");
				}
				if(tamanio > maximoTamanio || tamanio < minimoTamanio){
					throw new BusinessException("G025");
				}
				
				multiCln.put(entry.getKey(), entry.getValue());
			}
		}
		return multiCln;
	}
	
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DocumentosGenericoService#verificarArchivos(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Folio, java.util.Map, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos, java.util.List, java.lang.String)
	 */
	@Override
	public RespuestaServicio verificarArchivos(Folio folio, Map<String, MultipartFile> archivos, EnvioArchivos datosRecepcion, List<Combo> comboObligatorios, String fotografia, byte [] pdf) {
		logger.info("Se contruye la peticion de archivo {}, {}, {}", datosRecepcion.getTipoArchivo(), datosRecepcion.getCurpTrabajador(), datosRecepcion.getCurpEmpleado());
		RespuestaServicio respuestaServicio = null;
		try {
			String ruta = recepcionArchivosService.verificarRuta(datosRecepcion.getCurpTrabajador(), urlRutaExpedientes);
			String fecha = utileriaFecha.convertirFechaACadena(new Date(), FormatoConstants.FORMATO_FECHA_ARCHIVOS);

			for (Combo docs : comboObligatorios) {
				int i = 1;
				if (!utileriaValidador.validarListaVacia(docs.getSubDocumentos())) {
					for (Combo subDocs : docs.getSubDocumentos()) {
						if (!ObjectUtils.isEmpty(archivos))
							i = armarArchivo(archivos, subDocs.getClave(), subDocs.getClaveDocumento(), ruta, fecha, datosRecepcion, i);
					}
				} else {
					if (!ObjectUtils.isEmpty(archivos))
						i = armarArchivo(archivos, docs.getClave(), docs.getClaveDocumento(), ruta, fecha, datosRecepcion, i);
				}
			}
			
			logger.info("pdf vacio al armar archivo? {},", ObjectUtils.isEmpty(pdf));
			armarArchivo(Base64Utils.encodeToString(pdf), "62", ruta, fecha, datosRecepcion, "pdf");
			
			if (!utileriaValidador.isEmpty(fotografia)) {
				armarArchivo(fotografia, "31", ruta, fecha, datosRecepcion, "PNG");
				
			}

			String resultado = recepcionArchivosService.generarZip(ruta);
			recepcionArchivosService.eliminarDirectorio(new File(ruta));
			recepcionArchivosService.eliminarDirectorio(new File(utileriaCadena.obtenerCadenaConcatenada(true, ruta, ExpresionesConstants.EXTENSION_ZIP)));

			Archivos objetoArchivo = new Archivos();
			objetoArchivo.setClaveAfore(datosRecepcion.getClaveAfore());
			objetoArchivo.setFolioTramiteProcesar(datosRecepcion.getFolio());
			objetoArchivo.setCurpEmpleado(datosRecepcion.getCurpEmpleado());
			objetoArchivo.setCurpTrabajador(datosRecepcion.getCurpTrabajador());
			objetoArchivo.setTipoArchivos(ServiciosConstants.CLAVE_DOCUMENTOS_DIGITALIZADOS);
			objetoArchivo.setTipoExpediente(datosRecepcion.getProceso());

			respuestaServicio = recepcionArchivosService.enviarArchivoRecepcion(folio, objetoArchivo, resultado, ServiciosConstants.RUTA_EXPEDIENTE);
//			respuestaServicio = new RespuestaServicio();
//			respuestaServicio.setFlujo(1);
		} catch (FileNotFoundException fnfe) {
			logger.error("Ocurrio FileNotFoundException", fnfe);
			respuestaServicio = recepcionArchivosService.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		} catch (IOException ioe) {
			logger.error("Ocurrio IOException", ioe);
			respuestaServicio = recepcionArchivosService.obtenerRespuesta(GenericErrorEnum.EXCEPTION_GENERICA.getClave(), datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		} catch (GenericException ge) {
			logger.error("Ocurrio IOException", ge);
			respuestaServicio = recepcionArchivosService.obtenerRespuesta(ge.getCodigo(), datosRecepcion.getClaveAfore(), NumerosConstants.INT_DOS);
		}
		return respuestaServicio;
	}
	

	/**
	 * @param valor
	 * @param clave
	 * @param ruta
	 * @param fecha
	 * @param datosRecepcion
	 * @throws IOException
	 */
	private void armarArchivo(String valor, String clave, String ruta,
			String fecha, EnvioArchivos datosRecepcion, String extension) throws IOException {
			String folio = datosRecepcion.getFolioIdentificacion();
			if (!StringUtils.isEmpty(folio) && folio.length() > 3) {
				folio = folio.substring(datosRecepcion.getFolioIdentificacion().length() - 3);
			}
			String renombre = utileriaCadena.obtenerCadenaConcatenada(true, datosRecepcion.getClaveAfore(),
					datosRecepcion.getProceso(), datosRecepcion.getCurpTrabajador(), datosRecepcion.getTipoTrabajador(),
					clave, "1", fecha, folio, AgenteConstants.PUNTO, extension);
			logger.info(renombre);
			File rutaSalida = new File(
					utileriaCadena.obtenerCadenaConcatenada(true, ruta, ActivacionConstants.DIAGONAL, renombre));
			FileOutputStream salida = new FileOutputStream(rutaSalida);
			salida.write(DatatypeConverter.parseBase64Binary(valor));
			salida.close();
	}
	
	
	/**
	 * Metodo encargado de armar el arcvhio para el zip
	 * 
	 * @param auxiliarValue
	 * @param auxiliar
	 * @param clave
	 * @param ruta
	 * @param fecha
	 * @param datosRecepcion
	 * @param contador
	 * @return
	 * @throws IOException
	 */
	private int armarArchivo(Map<String, MultipartFile> auxiliarValue, String auxiliar, String clave, String ruta, String fecha, EnvioArchivos datosRecepcion, int contador) throws IOException {
		String nombreArchivo = utileriaCadena.obtenerCadenaConcatenada(true, auxiliar);
		MultipartFile archivo = auxiliarValue.get(nombreArchivo);
		if (!utileriaValidador.validarObjetoNulo(archivo)) {
			String extension = FilenameUtils.getExtension(archivo.getOriginalFilename());
			String folio = datosRecepcion.getFolioIdentificacion();
			if (!StringUtils.isEmpty(folio) && folio.length() > 3) {
				folio = folio.substring(datosRecepcion.getFolioIdentificacion().length() - 3);
			}
			String renombre = utileriaCadena.obtenerCadenaConcatenada(true, datosRecepcion.getClaveAfore(),
					datosRecepcion.getProceso(), datosRecepcion.getCurpTrabajador(), datosRecepcion.getTipoTrabajador(),
					clave, String.valueOf(contador), fecha, folio, AgenteConstants.PUNTO, extension.toLowerCase());
			logger.info(renombre);
			File rutaSalida = new File(
					utileriaCadena.obtenerCadenaConcatenada(true, ruta, ActivacionConstants.DIAGONAL, renombre));
			FileOutputStream salida = new FileOutputStream(rutaSalida);
			salida.write(archivo.getBytes());
			salida.close();
			contador++;
		}
		return contador;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerCurpGenericoRecepcionImagenes(String cvProcesoFormulario,String cvTipoSolicitante,String bandera13,String banderaPermanencia,DatosTrabajador datosTrabajador,EntradaModificacion entradaModificacion,EntradaPermanencia entradaPermanencia) {
		String curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getDatosCertificables().getCurp(), ExpresionesConstants.VACIO);
		if("40".equals(cvProcesoFormulario)) {
			curp = utileriaCadena.obtenerContenidoCadenaSinEspacios(datosTrabajador.getDatosCertificables().getCurp(), ExpresionesConstants.VACIO);
		}else if(servicioExpediente.obtenerProcesoExpediente(cvTipoSolicitante).equals(cvProcesoFormulario)) {
			if(!utileriaValidador.validarVacio(bandera13)) {
				curp = entradaModificacion.getDatosBaseCurp().getCurpNueva();
			}else if(!utileriaValidador.validarVacio(banderaPermanencia)) {
				curp = entradaPermanencia.getCurpTrabajador();
			}
			
		}else if(expedienteServicio.obtenerProcesoExpedienteServicio(cvTipoSolicitante).equals(cvProcesoFormulario)) {
				curp = entradaModificacion.getDatosBaseCurp().getCurpNueva();
		}
		return curp;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerFolioHijoGenericoRecepcionImagenes(String cvProcesoFormulario,FolioEntrada folioEntrada,Folio folioHijo) {
		String chFolioHijo = null;
		if("40".equals(cvProcesoFormulario)) {
//			chFolioHijo = folioEntrada.getFolioHijo();
			chFolioHijo = servicioExpediente.obtenerValoresPantalla(folioEntrada.getFolioHijo(), null);
		}else {
			chFolioHijo = servicioExpediente.obtenerValoresPantalla(folioHijo.getChFolio(), null);

		}
		return chFolioHijo;

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String obtenerCvTipoProcesoGenericoRecepcionImagenes(String cvProcesoFormulario,String cvTipoSolicitante) {
		String cvTipoProceso = "40";
		if(servicioExpediente.obtenerProcesoExpediente(cvTipoSolicitante).equals(cvProcesoFormulario)) {
			cvTipoProceso = servicioExpediente.obtenerProcesoExpediente(cvTipoSolicitante);
		}else if(expedienteServicio.obtenerProcesoExpedienteServicio(cvTipoSolicitante).equals(cvProcesoFormulario)) {
			cvTipoProceso = expedienteServicio.obtenerProcesoExpedienteServicio(cvTipoSolicitante);
		}
		return cvTipoProceso;
	}
	
	
	
	
}
