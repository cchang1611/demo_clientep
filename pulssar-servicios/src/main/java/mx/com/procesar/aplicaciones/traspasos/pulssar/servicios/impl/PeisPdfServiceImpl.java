package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants.ESPACIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants.EXPRESION_REGULAR_VACIO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ENTERO_1;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ENTERO_2;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ENTERO_4;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ESPACIADO_LETRA_4_7;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ESPACIADO_LETRA_5_1;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.ESPACIADO_PALABRA_2_4;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_100;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_108;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_129;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_138;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_155;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_172;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_184;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_232;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_240;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_270;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_286;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_297;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_309;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_352;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_42;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_430;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_478;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_495;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_520;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_528;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_540;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_555;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_618;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_675;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_72;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_85;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.IUSACELL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.LONGITUD_26;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.MARCA_MAYUSCULA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.MARCA_MINUSCULA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.MODALIDAD_RETIRO_A;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.MODALIDAD_RETIRO_B;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.MOVISTAR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.NEXTEL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.OPCION_FEMENINO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.OPCION_MASCULINO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.OTRA_COMPANIA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PAGO_ORDEN_PAGO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PAGO_TRANSFERENCIA_BANCARIA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.TELCEL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.UNEFON;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_CERO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants.INT_UNO;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PeisPdfService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PdfConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CodigoUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

@Service
public class PeisPdfServiceImpl implements PeisPdfService {

	
	/**
	 * logger de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(PeisPdfServiceImpl.class);
	
	/**
	 * PdfUtils
	 */
	@Autowired
	private PdfUtils pdfUtil;

	/**
	 * utilerias codigoUtils
	 */
	@Autowired
	private CodigoUtils codigoUtils;

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PeisPdfService#
	 * agregarSolicitudRetiroParcialDesempleoPaginaUno(mx.com.procesar.aplicaciones.
	 * traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo,
	 * org.apache.pdfbox.pdmodel.PDDocument)
	 */
	public void agregarSolicitudRetiroParcialDesempleoPaginaUno(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException {
		int numeroPagina = 0;

		pdfUtil.agregarTexto(solicitud.getNombre(), pdfDocument, numeroPagina, FLOAT_430, FLOAT_309);
		pdfUtil.agregarTexto(solicitud.getApellidos(), pdfDocument, numeroPagina, FLOAT_430, FLOAT_286);
		pdfUtil.agregarTexto(solicitud.getNombreCompleto(), pdfDocument, numeroPagina, FLOAT_478, FLOAT_138);

		String[] datosFecha = obtenerDatosFecha(solicitud.getFechaSolicitud());

		if (datosFecha.length == 3) {
			pdfUtil.agregarTexto(datosFecha[0], pdfDocument, numeroPagina, FLOAT_495, FLOAT_100);// dia firma
			pdfUtil.agregarTexto(datosFecha[ENTERO_1], pdfDocument, numeroPagina, FLOAT_555, FLOAT_100);// mes firma
			pdfUtil.agregarTexto(datosFecha[ENTERO_2], pdfDocument, numeroPagina, FLOAT_618, FLOAT_100);// anio firma
		}

		pdfUtil.agregarImagen(solicitud.getFirmaEmpleado(), pdfDocument, numeroPagina, FLOAT_540, FLOAT_85);
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PeisPdfService#
	 * agregarSolicitudRetiroParcialDesempleoPaginaDos(mx.com.procesar.aplicaciones.
	 * traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo,
	 * org.apache.pdfbox.pdmodel.PDDocument)
	 */
	@Override
	public void agregarSolicitudRetiroParcialDesempleoPaginaDos(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException, ParseException {
		int numeroPagina = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(solicitud.getFechaNacimiento()));
		
		
		pdfUtil.agregarTextoConEspaciado(solicitud.getNumeroFolio(), pdfDocument, numeroPagina, 465f, 705f, 2.4f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getNumeroUnidad(), pdfDocument, numeroPagina, 400f, 680f, 4.2f);
		pdfUtil.agregarTextoConEspaciado(corregirAnioFechaConFormato(solicitud.getFechaSolicitud()), pdfDocument, numeroPagina, FLOAT_520, 685f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getNombre(), pdfDocument, numeroPagina, 28f, 658f, ESPACIADO_LETRA_5_1, ESPACIADO_PALABRA_2_4, 7);
		pdfUtil.agregarTextoConEspaciado(solicitud.getApellidoPaterno(), pdfDocument, numeroPagina, 28f, 636f, 4.2f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getApellidoMaterno(), pdfDocument, numeroPagina, 319f, 636f, 4.2f);
		
		pdfUtil.agregarTextoConEspaciado(solicitud.getNss(), pdfDocument, numeroPagina, 28f, 615f, 4.2f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getRfc(), pdfDocument, numeroPagina, 177f, 615f, 4.3f);
		
		
		
		pdfUtil.agregarTextoConEspaciado(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)), pdfDocument, numeroPagina, 341f, 615f, ESPACIADO_LETRA_4_7);
		pdfUtil.agregarTextoConEspaciado(StringUtils.leftPad(Integer.toString(cal.get(Calendar.MONTH)+1), 2, "0"), pdfDocument, numeroPagina, 371f, 615f, ESPACIADO_LETRA_4_7);
		pdfUtil.agregarTextoConEspaciado(Integer.toString(cal.get(Calendar.YEAR)), pdfDocument, numeroPagina, 401f, 615f,  ESPACIADO_LETRA_4_7);

		
		if (OPCION_FEMENINO.equals(solicitud.getGenero())) {
			pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 569f, 619f); // marca en femenino
		} else if (OPCION_MASCULINO.equals(solicitud.getGenero())) {
			pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 541f, 619f); // marca en masculino
		}

		
		pdfUtil.agregarTextoConEspaciado(solicitud.getCurp(), pdfDocument, numeroPagina, 28f, 582f, 4.3f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getLada(), pdfDocument, numeroPagina, 280f, 582f, 4f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getTelefono(), pdfDocument, numeroPagina, 307f, 582f, 4.2f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getExtension(), pdfDocument, numeroPagina, 400f, 582f, 4.2f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getClaveCelular(), pdfDocument, numeroPagina, 279f, 559f, 4.7f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getLadaCelular(), pdfDocument, numeroPagina, 322f, 559f, 4.7f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getCelular(), pdfDocument, numeroPagina, 356f, 559f, 4.3f);
		
		
		marcarCompaniaCelular(solicitud, pdfDocument);
		pdfUtil.agregarTextoConEspaciado(solicitud.getEmail(), pdfDocument, numeroPagina, 122f, 533f, 4.3f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getCalle(), pdfDocument, numeroPagina, 28f, 492f, 4.3f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getColonia(), pdfDocument, numeroPagina, 28f, 470f, 4.3f );
		pdfUtil.agregarTextoConEspaciado(solicitud.getNumeroExterior(), pdfDocument, numeroPagina, 318f, 492f, 4.3f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getNumeroInterior(), pdfDocument, numeroPagina, 365f, 492f, 4.3f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getCodigoPostal(), pdfDocument, numeroPagina, 414f, 492f, 4.3f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getPais(), pdfDocument, numeroPagina, 462f, 492f, 4.3f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getEntidadFederativa(), pdfDocument, numeroPagina, 318f, 470f, 4.3f);
		
		pdfUtil.agregarTextoConEspaciado(solicitud.getPoblacion(), pdfDocument, numeroPagina, 318f, 447f, 4.3f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getDelegacionMunicipio(), pdfDocument, numeroPagina, 28f, 447f, 4.3f);
		agregarFormaPago(solicitud, pdfDocument);
		agregarModalidadRetiro(solicitud, pdfDocument);
		pdfUtil.agregarTextoConEspaciado(solicitud.getNombreCompleto(), pdfDocument, numeroPagina, 28f, 280f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getNombreAsesor(), pdfDocument, numeroPagina, 28f, 120f, 1f);
		pdfUtil.agregarTextoConEspaciado(solicitud.getCurpAsesor(), pdfDocument, numeroPagina, 127f, 110f, 4.3f);
		
		pdfUtil.agregarFirma(solicitud.getFirmaEmpleado(), pdfDocument, numeroPagina, 28f, 285f, 100, 35);
		pdfUtil.agregarFirma(solicitud.getFirmaAgente(), pdfDocument, numeroPagina, 28f, 125f, 86, 30);

	}

	
	/*  La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PeisPdfService#generarSolicitudDisposicionParcialIssste(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste, org.apache.pdfbox.pdmodel.PDDocument, int)
	 */
	@Override //y mas alto mas arriba x mas alto mas a la drecha
	public void generarSolicitudDisposicionParcialIssste(DatosSolicitudRetiroParcialDesempleoIssste solicitud, PDDocument pdfDocument, int numeroPagina) throws IOException {
		
		
		pdfUtil.agregarTextoConEspaciado(solicitud.getNumeroFolio(), pdfDocument, numeroPagina, 473f, 780f);
		
		//generar codigo de barras
		BufferedImage cb = null;  
				try{
					cb = generaCodigoBarras(solicitud.getNumeroFolio());
				}catch(Exception e) {
					logger.error(e.getMessage());
				}
		pdfUtil.agregarImagen(cb, pdfDocument, numeroPagina, 375f, 67f);
				
				
		pdfUtil.agregarTexto(solicitud.getVentanilla(), pdfDocument, numeroPagina, FLOAT_172, FLOAT_675, 9);
		pdfUtil.agregarTexto(solicitud.getNombre(), pdfDocument, numeroPagina, FLOAT_129, 685f, 9);
		pdfUtil.agregarTexto(solicitud.getApellidoPaterno(), pdfDocument, numeroPagina, FLOAT_129, 665f, 9);
		pdfUtil.agregarTexto(solicitud.getApellidoMaterno(), pdfDocument, numeroPagina, FLOAT_129, 647f, 9);
		pdfUtil.agregarTexto(solicitud.getCurp(), pdfDocument, numeroPagina, 435f, 685f, 9);
		pdfUtil.agregarTexto(solicitud.getNss(), pdfDocument, numeroPagina, 435f, 666f, 9);
		pdfUtil.agregarTexto(solicitud.getNti(), pdfDocument, numeroPagina, 435f, 650f, 9);
		pdfUtil.agregarTexto(solicitud.getRfc(), pdfDocument, numeroPagina, FLOAT_129, 628f, 9);
		pdfUtil.agregarTexto(solicitud.getCalle(), pdfDocument, numeroPagina, FLOAT_129, 592f);
		pdfUtil.agregarTexto(solicitud.getNumeroExterior(), pdfDocument, numeroPagina, 405f, 590f, 9);
		pdfUtil.agregarTexto(solicitud.getNumeroInterior(), pdfDocument, numeroPagina, FLOAT_528, 590f, 9);
		pdfUtil.agregarTexto(solicitud.getColonia(), pdfDocument, numeroPagina, FLOAT_129, 573f, 9);
		pdfUtil.agregarTexto(solicitud.getCiudad(), pdfDocument, numeroPagina, 405f, 573f, 9);
		pdfUtil.agregarTexto(solicitud.getDelegacionMunicipio(), pdfDocument, numeroPagina, FLOAT_129, 555f, 9);
		pdfUtil.agregarTexto(solicitud.getCodigoPostal(), pdfDocument, numeroPagina, 460f, 555f, 9);
		pdfUtil.agregarTexto(solicitud.getEntidadFederativa(), pdfDocument, numeroPagina, FLOAT_129, 537f, 9);

		if (solicitud.getContactoUno() != null) {
			pdfUtil.agregarTexto(solicitud.getContactoUno().getLada(), pdfDocument, numeroPagina, FLOAT_108, 500f, 9);
			pdfUtil.agregarTexto(solicitud.getContactoUno().getTelefono(), pdfDocument, numeroPagina, FLOAT_155, 500f, 9);
			pdfUtil.agregarTexto(solicitud.getContactoUno().getExtension(), pdfDocument, numeroPagina, FLOAT_240, 500f, 9);
			pdfUtil.agregarTexto(solicitud.getContactoUno().getHorarioAtencion(), pdfDocument, numeroPagina, FLOAT_352, 500f, 9);
		}

		if (solicitud.getContactoDos() != null) {
			pdfUtil.agregarTexto(solicitud.getContactoDos().getLada(), pdfDocument, numeroPagina, FLOAT_108, 485f, 9);
			pdfUtil.agregarTexto(solicitud.getContactoDos().getTelefono(), pdfDocument, numeroPagina, FLOAT_155, 485f, 9);
			pdfUtil.agregarTexto(solicitud.getContactoDos().getExtension(), pdfDocument, numeroPagina, FLOAT_240, 485f, 9);
			pdfUtil.agregarTexto(solicitud.getContactoDos().getHorarioAtencion(), pdfDocument, numeroPagina, FLOAT_352, 485f, 9);
		}
		if (solicitud.isAutorizaRecibirEstadoCuenta()) {
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 545, 513f);
		}

		if (solicitud.isAutorizaRecibirMensajesSms()) {
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 545, 490f);
		}

		if (solicitud.isAutorizaRecibirInformacion()) {
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 545, 470f);
		}

		pdfUtil.agregarTexto(solicitud.getCelular(), pdfDocument, numeroPagina, FLOAT_72, 474f, 7);
		pdfUtil.agregarTexto(solicitud.getEmail(), pdfDocument, numeroPagina, FLOAT_184, 474f, 7);
		pdfUtil.agregarTexto(solicitud.getSolicitudServicio(), pdfDocument, numeroPagina, FLOAT_42, 444f, 9);
		pdfUtil.agregarTexto(solicitud.getDocumentacionEntregada(), pdfDocument, numeroPagina, FLOAT_42, 414f, 9);

		if (solicitud.getBeneficiario() != null) {
			pdfUtil.agregarTexto(solicitud.getBeneficiario().getNombre() , pdfDocument, numeroPagina, FLOAT_42, 350f, 9);
			pdfUtil.agregarTexto(solicitud.getBeneficiario().getBanco(), pdfDocument, numeroPagina, 290f, 350f, 9);
			pdfUtil.agregarTexto(solicitud.getBeneficiario().getCuenta(), pdfDocument, numeroPagina, 400f, 350f, 9);
			pdfUtil.agregarFirma(solicitud.getBeneficiario().getFirma() , pdfDocument, numeroPagina, 490f, 330f, 100, 35);
		}

		String nombre = solicitud.getNombreAgente();
		List<String> partesNombre;

		if (nombre != null && !nombre.isEmpty()) {
			if (nombre.length() <= LONGITUD_26) {
				pdfUtil.agregarTexto(solicitud.getNombreAgente(), pdfDocument, numeroPagina, FLOAT_42, 210f, 9);
			} else {
				partesNombre = partirNombre(nombre, LONGITUD_26);
				pdfUtil.agregarTexto(partesNombre.get(INT_CERO), pdfDocument, numeroPagina, FLOAT_42, 220f, 9);
				pdfUtil.agregarTexto(partesNombre.get(INT_UNO), pdfDocument, numeroPagina, FLOAT_42, 210f, 9);
			}
		}

		nombre = solicitud.getNombreCompleto();

		if (nombre != null && !nombre.isEmpty()) {
			if (nombre.length() <= LONGITUD_26) {
				pdfUtil.agregarTexto(solicitud.getNombreCompleto(), pdfDocument, numeroPagina, FLOAT_232, 210f, 9);
			} else {
				partesNombre = partirNombre(nombre, LONGITUD_26);
				pdfUtil.agregarTexto(partesNombre.get(INT_CERO), pdfDocument, numeroPagina, FLOAT_232, 220f, 9);
				pdfUtil.agregarTexto(partesNombre.get(INT_UNO), pdfDocument, numeroPagina, FLOAT_232, 210f, 9);
			}
		}
		
		

		pdfUtil.agregarFirma(solicitud.getFirmaAgente(), pdfDocument, numeroPagina, FLOAT_108, 235f, 100, 35);
		pdfUtil.agregarFirma(solicitud.getFirmaTrabajador(), pdfDocument, numeroPagina, FLOAT_297, 235f, 100, 35);

	}
	
	
	private BufferedImage generaCodigoBarras(String folio) throws OutputException, BarcodeException {
		Barcode barcode= BarcodeFactory.createCode128(folio);
		
		barcode.setResolution(150);
		barcode.setBarWidth(1);
		barcode.setBarHeight(4);
		barcode.setDrawingText(false) ;
		barcode.setDrawingQuietSection(false);
		
		return BarcodeImageHandler.getImage(barcode);
		
	}
	
	
	/**
	 * 
	 * marca la compañia a la que pertenece el celular de la solicitud de retiro
	 * parcial por desempleo
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud
	 * @param pdfDocument
	 * @throws IOException
	 */
	private void marcarCompaniaCelular(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException {
		int numeroPagina = 0;

		if (solicitud.getCompaniaCelular() == null) {
			return;
		}

		switch (solicitud.getCompaniaCelular()) {
		case TELCEL:
			pdfUtil.agregarTextoConEspaciado(MARCA_MINUSCULA, pdfDocument, numeroPagina, 452f, 585f);// telcel
			break;
		case IUSACELL:
			pdfUtil.agregarTextoConEspaciado(MARCA_MINUSCULA, pdfDocument, numeroPagina, 507f, 585f);// iusacell
			break;
		case UNEFON:
			pdfUtil.agregarTextoConEspaciado(MARCA_MINUSCULA, pdfDocument, numeroPagina, 562f, 585f);// unefon
			break;
		case MOVISTAR:
			pdfUtil.agregarTextoConEspaciado(MARCA_MINUSCULA, pdfDocument, numeroPagina, 452f, 567f);// movistar
			break;
		case NEXTEL:
			pdfUtil.agregarTextoConEspaciado(MARCA_MINUSCULA, pdfDocument, numeroPagina, 507f, 567f);// nextel
			break;
		case OTRA_COMPANIA:
			pdfUtil.agregarTextoConEspaciado(MARCA_MINUSCULA, pdfDocument, numeroPagina, 562f, 567f);// otros
			break;
		default:
			return;
		}
	}

	/**
	 * 
	 * se obtienen la fecha en una arreglo de strings
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param fecha
	 * @return
	 */
	private String[] obtenerDatosFecha(String fecha) {
		if (codigoUtils.esVacio(fecha) || !fecha.matches("^\\d{2}/\\d{2}/\\d{2,4}$")) {
			return new String[0];
		}

		String[] datosFecha = fecha.split(PdfConstants.SEPARADOR_FECHA);

		if (datosFecha[ENTERO_2].length() == ENTERO_4) {
			datosFecha[ENTERO_2] = datosFecha[ENTERO_2].substring(ENTERO_2);
		}

		return datosFecha;

	}

	/**
	 * 
	 * corige si es necesario, el año en dos digitos
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param fecha
	 * @return
	 */
	protected String corregirAnioFechaConFormato(String fecha) {
		if (codigoUtils.esVacio(fecha) || !fecha.matches("^\\d{2}/\\d{2}/\\d{2,4}$")) {
			return "";
		}

		String[] datosFecha = fecha.split(PdfConstants.SEPARADOR_FECHA);

		if (datosFecha[ENTERO_2].length() == ENTERO_4) {
			StringBuilder fechaCorregida = new StringBuilder(fecha.substring(0, fecha.lastIndexOf(PdfConstants.SEPARADOR_FECHA) + ENTERO_1));
			fechaCorregida.append(datosFecha[2].substring(ENTERO_2));
			return fechaCorregida.toString();
		}

		return fecha;
	}

	/**
	 * 
	 * agrega la forma de pago de la solicitud de retiro parcial por desempleo
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud
	 * @param pdfDocument
	 * @throws IOException
	 */
	private void agregarFormaPago(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException {
		int numeroPagina = 0;

		if (solicitud.getFormaPago() == null) {
			return;
		}

		switch (solicitud.getFormaPago()) {
		case PAGO_TRANSFERENCIA_BANCARIA:
			pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 35f, 400f);// transferencia bancaria
			pdfUtil.agregarTextoConEspaciado(solicitud.getInstitucionBancaria(), pdfDocument, numeroPagina, 115f, 410f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getNumeroSucursalBancaria(), pdfDocument, numeroPagina, 115f, 400f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getClabe(), pdfDocument, numeroPagina, 147f, 386f, 3.2f);
			break;
		case PAGO_ORDEN_PAGO:
			pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 35f, 367f);// orden de pago
			pdfUtil.agregarTextoConEspaciado(solicitud.getReferenciaPago(), pdfDocument, numeroPagina, 115f, 350f);
			break;
		/*case PAGO_CHEQUES:
			pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 17f, 368f);// cheques
			pdfUtil.agregarTextoConEspaciado(solicitud.getReferenciaPago(), pdfDocument, numeroPagina, FLOAT_90, FLOAT_343);
			break;
		case PAGO_OTROS:
			pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 17f, 354f);// otros
			pdfUtil.agregarTextoConEspaciado(solicitud.getOtroMedioPago(), pdfDocument, numeroPagina, FLOAT_90, FLOAT_329);
			break;*/
		default:
			return;
		}

	}

	/**
	 * 
	 * agrega los datos la modalidad de retiro
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param solicitud
	 * @param pdfDocument
	 * @throws IOException
	 */
	private void agregarModalidadRetiro(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException {
		int numeroPagina = 0;

		if (MODALIDAD_RETIRO_A.equals(solicitud.getModalidadRetiro())) {
			pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 387, 396f);// modalida a
		} else if (MODALIDAD_RETIRO_B.equals(solicitud.getModalidadRetiro())) {
			pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 570, 396f);// modalida b

			//if (FORMA_ENTREGA_SEIS_PAGOS.equals(solicitud.getFormaEntrega())) {
				//pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 468f, 397f);// seis pagos
				// proporcionales
			//} else if (FORMA_ENTREGA_PRIMER_PAGO_30_DIAS.equals(solicitud.getFormaEntrega())) {
				//pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 535f, 397f);// primer pago en 30 dias
			//}

		}

		if (solicitud.isAsesorado()) {
			pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 482f, 259f);// asesorado, si
		} else {
			pdfUtil.agregarTextoConEspaciado(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 546f, 259f);// asesorado, no
		}

	}

	/**
	 * 
	 * divide el nombre completo en dos de acuerdo a un limite
	 * 
	 * @author Jose Alberto Castillo Moctezuma (jacastil@inet.procesar.com.mx)
	 * @param nombre
	 * @param longitudLimite
	 * @return
	 */
	protected List<String> partirNombre(String nombre, int longitudLimite) {
		String[] datosNombre = nombre.split(EXPRESION_REGULAR_VACIO);
		List<String> nombreEnPartes = new ArrayList<>();
		StringBuilder cadena = new StringBuilder();

		for (String dato : datosNombre) {
			if ((dato.length() + cadena.length()) > longitudLimite) {
				nombreEnPartes.add(cadena.toString());
				cadena = new StringBuilder();
			}

			cadena.append(dato).append(ESPACIO);
		}

		if (cadena.length() > INT_CERO) {
			nombreEnPartes.add(cadena.toString());
		}

		return nombreEnPartes;
	}

}
