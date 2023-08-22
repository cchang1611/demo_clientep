/**
 * GuardarArchivosReintegroServiceImpl.java
 * Fecha de creación: Apr 29, 2020 1:03:14 AM
 *
 * Copyright (c) 2017 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.CLAVE_TIPO_PROCES_REINTEGRO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.CODIGO_FLUJO_ERROR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.CODIGO_FLUJO_OK;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.DOC_NO_OBLIGATORIOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.DOC_OBLIGATORIOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.FOLIO_ARCHIVO_TRABAJADOR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.FORMATO_FECHA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.FORMATO_NOMBRE_ARCHIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.FORMATO_NOMBRE_ARCHIVO_ZIP;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.MSJ_DOCUMENTOS_GUARDADOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.MSJ_DOCUMENTOS_OBLIGATORIOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.MSJ_MEGAS_PERMITIDOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.TAMANIO_MAXIMO_ARCHIVO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ReintegroConstants.TIPO_TRABAJADOR;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CatalogoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GuardarArchivosReintegroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DocumentosRequerido;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujoEntradaArchivo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitudReintegroResarcimiento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CompresorUtils;

/**
 * Clase para guardar los archivos de reintegro
 *
 * @author Williams Alejandro Martínez (WALEJAND)
 * @version 1.0
 */
@Service
public class GuardarArchivosReintegroServiceImpl implements GuardarArchivosReintegroService {

	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(GuardarArchivosReintegroService.class);

	/**
	 * ruta donde se depositaran los archivos
	 */
	@Value("${ruta.carpeta.reintegro.documentos}")
	private String rutaDestino;

	/**
	 * Catalogo service
	 */
	@Autowired
	private CatalogoService catalogoService;

	/**
	 * Atributo compresorUtils
	 */
	@Autowired
	private CompresorUtils compresorUtils;

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * GuardarArchivosReintegroService#consultarDocumentosRequeridos(mx.com.
	 * procesar.aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public void consultarDocumentosRequeridos(SolicitudReintegroResarcimiento entrada) {
		logger.info("Consulta documentos requeridos");
		List<Combo> comboNoObligatorios = new ArrayList<>();
		List<Combo> comboObligatorios = new ArrayList<>();
		List<DocumentosRequerido> lst = catalogoService
				.consultarDocumentosRequeridosPorClaveAfore(entrada.getTrabajador().getClaveAfore());

		for (DocumentosRequerido a : lst) {

			// Obligatorio
			if (DOC_OBLIGATORIOS.equals(a.getNuObligatorio())) {
				Combo e = new Combo();
				e.setDescripcion(a.getChDescDocDigital());
				e.setClave(generarNombreArchivo(entrada, a));
				e.setClaveDocumento(a.getCvTipoDocDigital());
				e.setIdentificadorCombo(1L);
				comboObligatorios.add(e);
			}

			// No obligatorio
			if (DOC_NO_OBLIGATORIOS.equals(a.getNuObligatorio())) {
				Combo e = new Combo();
				e.setDescripcion(a.getChDescDocDigital());
				e.setClave(generarNombreArchivo(entrada, a));
				e.setIdentificadorCombo(1L);
				comboNoObligatorios.add(e);
			}

		}

		entrada.setComboNoObligatorios(comboNoObligatorios);
		entrada.setComboObligatorios(comboObligatorios);
	}

	/**
	 * Generar nombre de archivo
	 * 
	 * @param entrada
	 * @return
	 */
	private String generarNombreArchivo(SolicitudReintegroResarcimiento entrada, DocumentosRequerido documento) {
		return MessageFormat.format(FORMATO_NOMBRE_ARCHIVO,
				new Object[] { entrada.getTrabajador().getClaveAfore(), documento.getCvTipoProceso(),
						entrada.getTrabajador().getRenapo().getCurp(), TIPO_TRABAJADOR, documento.getCvTipoDocDigital(),
						documento.getNuConsecutivo(), new SimpleDateFormat(FORMATO_FECHA).format(new Date()),
						FOLIO_ARCHIVO_TRABAJADOR });
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * GuardarArchivosReintegroService#obtenerArchivos(java.util.Map)
	 */
	@Override
	public RespuestaServicio obtenerArchivos(Map<String, MultipartFile> archivos,
			SolicitudReintegroResarcimiento entrada) {
		RespuestaServicio salida = consultarArchivos(archivos, entrada);

		if (salida.getFlujo() != CODIGO_FLUJO_ERROR) {
			salida = guardarArchivos(archivos, entrada);
		}

		return salida;
	}

	/**
	 * Validar Archivos
	 * 
	 * @param archivos
	 * @param entrada
	 * @return
	 */
	private RespuestaServicio consultarArchivos(Map<String, MultipartFile> archivos,
			SolicitudReintegroResarcimiento entrada) {
		RespuestaServicio salida = validarDocumentosObligatorios(archivos, entrada);

		if (salida.getFlujo() == CODIGO_FLUJO_ERROR) {
			return salida;
		}

		if (archivos == null || archivos.isEmpty()) {
			return salida;
		}

		for (Map.Entry<String, MultipartFile> archivo : archivos.entrySet()) {
			consultarArchivos(archivo, salida);
			if (salida.getFlujo() == CODIGO_FLUJO_ERROR) {
				break;
			}
		}

		return salida;
	}

	/**
	 * @param archivos
	 * @param entrada
	 * @return
	 */
	private RespuestaServicio validarDocumentosObligatorios(Map<String, MultipartFile> archivos,
			SolicitudReintegroResarcimiento entrada) {
		RespuestaServicio salida = new RespuestaServicio();

		for (Combo o : entrada.getComboObligatorios()) {
			if (archivos == null || archivos.get(o.getClave()).isEmpty()) {
				salida.setFlujo(CODIGO_FLUJO_ERROR);
				salida.setMensaje(MSJ_DOCUMENTOS_OBLIGATORIOS);
			}
		}

		return salida;
	}

	/**
	 * Guardar Archivos
	 * 
	 * @param archivos
	 * @param entrada
	 * @return
	 */
	private RespuestaServicio guardarArchivos(Map<String, MultipartFile> archivos,
			SolicitudReintegroResarcimiento entrada) {
		RespuestaServicio salida = new RespuestaServicio();

		List<FlujoEntradaArchivo> lstFlujoEntrada = new ArrayList<>();
		for (Map.Entry<String, MultipartFile> archivo : archivos.entrySet()) {
			if (!archivo.getValue().isEmpty()) {
				lstFlujoEntrada.add(generarFlujoEntrada(archivo));
			}
		}

		// Regresa base64 del zip
		String base64 = generarZip(lstFlujoEntrada, entrada);
		logger.info("Base64 {}", base64);

		salida.setFlujo(CODIGO_FLUJO_OK);
		salida.setMensaje(MSJ_DOCUMENTOS_GUARDADOS);

		return salida;
	}

	/**
	 * Genera zip y lo guarda en la ruta especifica
	 * 
	 * @param lstFlujoEntrada
	 * @param entrada
	 * @return
	 */
	private String generarZip(List<FlujoEntradaArchivo> lstFlujoEntrada, SolicitudReintegroResarcimiento entrada) {
		String nombre = generarMascaraArchivo(entrada);
		String ruta = MessageFormat.format(rutaDestino, new Object[] { nombre.concat(".zip") });

		return compresorUtils.guardarZip(lstFlujoEntrada, ruta);
	}

	/**
	 * Se encarga de validar los archivos cumpla con las especificaciones
	 * 
	 * @param entrada
	 * @param salida
	 */
	private void consultarArchivos(Entry<String, MultipartFile> entrada, RespuestaServicio salida) {
		if (entrada.getValue().isEmpty()) {
			return;
		}

		if (entrada.getValue().getSize() > TAMANIO_MAXIMO_ARCHIVO) {
			salida.setFlujo(CODIGO_FLUJO_ERROR);
			salida.setMensaje(MSJ_MEGAS_PERMITIDOS);
		}
	}

	/**
	 * Guarda los archivos en la ruta especificada
	 * 
	 * @param entrada2
	 * @return
	 */
	private FlujoEntradaArchivo generarFlujoEntrada(Entry<String, MultipartFile> archivo) {
		StringBuilder nombreArchivo = new StringBuilder();
		nombreArchivo.append(archivo.getKey());
		nombreArchivo.append(".");
		nombreArchivo.append(FilenameUtils.getExtension(archivo.getValue().getOriginalFilename()));
		
		return compresorUtils.generarFlujoEntrada(archivo, nombreArchivo.toString());
	}

	/*
	 * La documentacion de este metodo se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.
	 * GuardarArchivosReintegroService#generarMascaraArchivo(mx.com.procesar.
	 * aplicaciones.traspasos.pulssar.servicios.modelo.
	 * SolicitudReintegroResarcimiento)
	 */
	@Override
	public String generarMascaraArchivo(SolicitudReintegroResarcimiento entrada) {
		return MessageFormat.format(FORMATO_NOMBRE_ARCHIVO_ZIP,
				new Object[] { entrada.getTrabajador().getClaveAfore(), CLAVE_TIPO_PROCES_REINTEGRO,
						entrada.getTrabajador().getRenapo().getCurp(), entrada.getResolucion(),
						new SimpleDateFormat(FORMATO_FECHA).format(new Date()), entrada.getNumeroReintegro() });
	}

}
