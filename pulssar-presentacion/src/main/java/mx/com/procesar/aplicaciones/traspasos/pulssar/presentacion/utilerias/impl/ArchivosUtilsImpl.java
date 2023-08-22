package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ArchivosUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.GeneradorPdfsService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudRetiroParcialMatrimonioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.AgenteConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.BusinessErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Combo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.SolicitarCertificacionMatrimonioEntrada;

@Component
public class ArchivosUtilsImpl implements ArchivosUtils{

	
	@Autowired
	private GeneradorPdfsService generadorPdfsService;
	
	@Value("${ruta.carpeta.expediente}")
	private String rutaTExpediente;
	
	
	@Autowired
	private SolicitudRetiroParcialMatrimonioService matService;
	
	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.ArchivosUtils#obtenerDocumentos(java.util.List, org.springframework.web.multipart.MultipartHttpServletRequest)
	 */
	public Map<String, Map<String, MultipartFile>> obtenerDocumentos(List<Combo> combo, Map<String, MultipartFile> multipart, Map<String, Map<String, MultipartFile>> arregloArchivos) {
		for (Combo docs : combo) {
			for (Combo subdocs : docs.getSubDocumentos()) {
				for (String keys : multipart.keySet()) {
					if (multipart.get(keys).getSize() != NumerosConstants.INT_CERO.longValue()) {
						if (keys.equals(subdocs.getClave())) {
							Map<String, MultipartFile> auxiliarArchivo;
							if (arregloArchivos.containsKey(subdocs.getClave())) {
								auxiliarArchivo = arregloArchivos.get(subdocs.getClave());
								auxiliarArchivo.put(keys, multipart.get(keys));
							} else {
								auxiliarArchivo = new HashMap<>();
								auxiliarArchivo.put(keys, multipart.get(keys));
							}
							this.validarTamanioExtension(auxiliarArchivo);
							arregloArchivos.put(subdocs.getClave(), auxiliarArchivo);
						}
					}
				}
			}
		}
		return arregloArchivos;
	}

	private void validarTamanioExtension(Map<String, MultipartFile> auxiliarArchivo){
		for(String auxarchivo : auxiliarArchivo.keySet()){
			MultipartFile archivo = auxiliarArchivo.get(auxarchivo);
			String extension = archivo.getOriginalFilename().substring(archivo.getOriginalFilename().indexOf(AgenteConstants.PUNTO));
			Integer maximoTamanio = 1 * 1024 * 1024;
			Integer minimoTamanio = 2 * 1024;
			Integer tamanio = Integer.valueOf((int) archivo.getSize());
			if(extension.contains(ParametrosConstants.EXTENSIONES_ACEPTADAS)){
				throw new BusinessException(BusinessErrorEnum.ARCHIVO_NO_PERMITIDO);
			}
			if(tamanio > maximoTamanio || tamanio < minimoTamanio){
				throw new BusinessException(BusinessErrorEnum.ARCHIVO_TAMANIO_NO_PERMITIDO);
			}
		}
	}
	
	/**
	 * Renombrado de archivo 
	 */
	public String obtenerProcesoExpediente(String solicitante) {
		String tipo = ServiciosConstants.PROCESO_TIPO_SOLICITANTE_REPRESENTANTE;
		if(ServiciosConstants.PROCESO_TIPO_SOLICITANTE_TITULAR.equals(solicitante)) {
			tipo = ServiciosConstants.PROCESO_TIPO_SOLICITANTE_TITULAR;
		} else if(ServiciosConstants.PROCESO_TIPO_SOLICITANTE_BENEFICIARIO.equals(solicitante)) {
			tipo = ServiciosConstants.PROCESO_TIPO_SOLICITANTE_BENEFICIARIO;
		}
		return tipo;
	}

	@Override
	public MockMultipartFile getArchivoExclusionIssste(List<Combo> exclusion, DatosSolicitudRetiroParcialDesempleoIssste sol, String afore) throws IOException {
		byte [] contenidoPdf = generadorPdfsService.generarSolicitudRetiroParcialDesempleoIssste(sol, afore);
		return  new MockMultipartFile(sol.getNombreArchivo(), sol.getNombreArchivo(), "application/pdf", contenidoPdf);
	}

	

	@Override
	public MockMultipartFile getArchivoExclusionMatrimonioImss(DatosTrabajador datosTrabajador)throws IOException {
		byte [] contenidoPdf = matService.generaSolicitudPdf(null, datosTrabajador,  null,null, null, null,null, null);
		return  new MockMultipartFile("generaSolicitudPdfSalida.pdf", "generaSolicitudPdfSalida.pdf", "application/pdf", contenidoPdf);
	}

	
	
	
}
