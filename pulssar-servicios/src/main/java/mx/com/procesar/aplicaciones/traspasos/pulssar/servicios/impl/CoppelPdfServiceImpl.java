package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_108;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_141;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_21;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_22;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_28;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.FLOAT_588;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.IUSACELL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.MARCA_MAYUSCULA;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.MODALIDAD_RETIRO_A;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.MODALIDAD_RETIRO_B;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.MOVISTAR;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.NEXTEL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.OPCION_FEMENINO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.OPCION_MASCULINO;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.PAGO_TRANSFERENCIA_BANCARIA_COPPEL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.TELCEL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.UNEFON;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.GeneradorPdfConstants.VENTANILLA;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelPdfService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils;

@Service
public class CoppelPdfServiceImpl implements CoppelPdfService {

	/**
	 * logger de la clase
	 */
	private static final Logger logger = LoggerFactory.getLogger(CoppelPdfServiceImpl.class);

	/**
	 * PdfUtils
	 */
	@Autowired
	PdfUtils pdfUtil;

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelPdfService#
	 * agregarSolicitudRetiroPorDesempleoPaginaUnoCoppel(mx.com.procesar.
	 * aplicaciones.traspasos.pulssar.servicios.modelo.
	 * DatosSolicitudRetiroParcialDesempleo, org.apache.pdfbox.pdmodel.PDDocument)
	 */
	@Override
	public void agregarSolicitudRetiroPorDesempleoPaginaUnoCoppel(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException {
		int numPagina = 0;

		
		pdfUtil.agregarTexto(solicitud.getNombre(), pdfDocument, numPagina, 417, 330);
		pdfUtil.agregarTexto(solicitud.getApellidoPaterno() + " " + solicitud.getApellidoMaterno(), pdfDocument, numPagina, 417, 298);

		String dia = StringUtils.leftPad(Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)), 2, "0");
		String mes = StringUtils.leftPad(Integer.toString(Calendar.getInstance().get(Calendar.MONTH) + 1), 2, "0");
		String anio = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));

		pdfUtil.agregarTexto(dia, pdfDocument, numPagina, 490, 129f);
		pdfUtil.agregarTexto(mes, pdfDocument, numPagina, 570, 129f);
		pdfUtil.agregarTexto(anio, pdfDocument, numPagina, 630, 129f);

		pdfUtil.agregarFirma(solicitud.getFirmaEmpleado(), pdfDocument, numPagina, 500f, 185.0f, 100, 35);
		
		String apellidos = StringUtils.join(solicitud.getApFirma(), StringUtils.SPACE, solicitud.getAmFirma());
		pdfUtil.agregarTextoConEspaciado(solicitud.getNombreFirma(), pdfDocument, numPagina, 500f, 175f);
		pdfUtil.agregarTextoConEspaciado(apellidos, pdfDocument, numPagina, 500f, 165f);
		
		
		/**
		 * ---------PARA LA HOJA 2 PERO NO AMERITO OTRO METODO-----------
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "MX"));
		pdfUtil.agregarTexto(sdf.format(Calendar.getInstance().getTime()), pdfDocument, 2, 275, 530f);
		
	}

	/*
	 * La documentación de este método se encuentra en la clase o interface que lo
	 * declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.CoppelPdfService#
	 * agregarSolicitudRetiroPorDesempleoPaginaDosCoppel(mx.com.procesar.
	 * aplicaciones.traspasos.pulssar.servicios.modelo.
	 * DatosSolicitudRetiroParcialDesempleo, org.apache.pdfbox.pdmodel.PDDocument,
	 * java.lang.Boolean)
	 */
	@Override
	public void agregarSolicitudRetiroPorDesempleoPaginaDosCoppel(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument, Boolean flujo532) throws IOException {
		int numPagina = 1;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es", "MX"));
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(solicitud.getFechaNacimiento()));

			String diaNac = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
			String mesNac = String.valueOf(cal.get(Calendar.MONTH) + 1);
			String anioNac = String.valueOf(cal.get(Calendar.YEAR));
			String calle = StringUtils.isEmpty(solicitud.getCalle()) ? "" : solicitud.getCalle();
			String numExt = StringUtils.isEmpty(solicitud.getNumeroExterior()) ? "" : solicitud.getNumeroExterior();
			String numInt = StringUtils.isEmpty(solicitud.getNumeroInterior()) ? "" : solicitud.getNumeroInterior();

			pdfUtil.agregarTexto(solicitud.getNumeroFolio(), pdfDocument, numPagina, 455f, 708f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getNumeroUnidad(), pdfDocument, numPagina, 395f, 683f, 4.2f);
			pdfUtil.agregarTexto(sdf.format(Calendar.getInstance().getTime()), pdfDocument, numPagina, 522f, 686f);
			
			
			pdfUtil.agregarTextoConEspaciado(solicitud.getNombre(), pdfDocument, numPagina, FLOAT_22, 662f, 5f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getApellidoPaterno(), pdfDocument, numPagina, FLOAT_22, 639f, 4.3f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getApellidoMaterno(), pdfDocument, numPagina, 312f, 639f, 4.3f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getNss(), pdfDocument, numPagina, FLOAT_22, 617.5f, 4.5f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getRfc(), pdfDocument, numPagina, 172f, 617.5f, 4.5f);
			pdfUtil.agregarTextoConEspaciado(StringUtils.leftPad(diaNac, 2, "0"), pdfDocument, numPagina, 336f, 617.5f, 4.5f);
			pdfUtil.agregarTextoConEspaciado(StringUtils.leftPad(mesNac, 2, "0"), pdfDocument, numPagina, 365f, 617.5f, 4.5f);
			pdfUtil.agregarTextoConEspaciado(anioNac, pdfDocument, numPagina, 395f, 617.5f, 4.5f);
			
			
			if (OPCION_MASCULINO.equals(solicitud.getGenero())) {
				pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numPagina, 532f, 623f);
			} else if (OPCION_FEMENINO.equals(solicitud.getGenero())) {
				pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numPagina, 559f, 623f);
			}
				
				
				
				
				
				
				
				
			pdfUtil.agregarTextoConEspaciado(solicitud.getCurp(), pdfDocument, numPagina, 21, 586f, 4.3f);
			
			if(StringUtils.length(solicitud.getTelefono())==10 && StringUtils.isBlank(solicitud.getLada())) {
				String lada = StringUtils.substring(solicitud.getTelefono(), 0, 2);
				String telefono = StringUtils.substring(solicitud.getTelefono(), 2);
				pdfUtil.agregarTextoConEspaciado(lada, pdfDocument, numPagina, 275, 583f, 4.3f);
				pdfUtil.agregarTextoConEspaciado(telefono, pdfDocument, numPagina, 308, 583f, 4.3f);
			}else {
				pdfUtil.agregarTextoConEspaciado(solicitud.getLada(), pdfDocument, numPagina, 275, 583f, 4.3f);
				pdfUtil.agregarTextoConEspaciado(solicitud.getTelefono(), pdfDocument, numPagina, 308, 583f, 4.3f);
			}
			
			pdfUtil.agregarTextoConEspaciado(solicitud.getExtension(), pdfDocument, numPagina, 391, 583f, 4.5f);
			
			
			/**
			--- esto ya no existe >:c 
			pdfUtil agregarTextoConEspaciado(solicitud getClaveCelular(), pdfDocument, numPagina, FLOAT_277, 585.5f, 4.5f)
			pdfUtil agregarTextoConEspaciado(solicitud getLadaCelular(), pdfDocument, numPagina, FLOAT_320, 586f, 4.5f) 
			*/
			
			pdfUtil.agregarTextoConEspaciado(solicitud.getCelular(), pdfDocument, numPagina, 350, 562f, 4.3f);
			marcarCompaniaCelularCoppel(solicitud.getCompaniaCelular(), pdfDocument);
			
			
			
			
			
			
			
			pdfUtil.agregarTextoConEspaciado(solicitud.getEmail(), pdfDocument, numPagina, 116, 535, 4.2f);
			
			
			
			

			pdfUtil.agregarTextoConEspaciado(calle, pdfDocument, numPagina, FLOAT_21, 496f, 4.3f);
			pdfUtil.agregarTextoConEspaciado(numExt, pdfDocument, numPagina, 311, 496f, 4.3f);
			pdfUtil.agregarTextoConEspaciado(numInt, pdfDocument, numPagina, 360, 496f, 4.3f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getCodigoPostal(), pdfDocument, numPagina, 407, 496f, 4.3f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getPais(), pdfDocument, numPagina, 455, 496f, 4.3f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getColonia(), pdfDocument, numPagina, FLOAT_21, 474f, 4.3f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getEntidadFederativa(), pdfDocument, numPagina, 311, 474f, 4.3f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getDelegacionMunicipio(), pdfDocument, numPagina, FLOAT_21, 451f, 4.3f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getPoblacion(), pdfDocument, numPagina, 311, 451f, 4.3f);
			
			
			agregarFormaPagoCoppel(solicitud.getFormaPago(), solicitud.getInstitucionBancaria(), solicitud.getNumeroSucursalBancaria(), solicitud.getClabe(), solicitud.getReferenciaPago(), solicitud.getOtroMedioPago(), pdfDocument);
			agregarModalidadRetiroCoppel(solicitud.getModalidadRetiro(), solicitud.getFormaEntrega(), solicitud.isAsesorado(), pdfDocument);
			
			
			
			pdfUtil.agregarTextoConEspaciado(solicitud.getNombreFirma(), pdfDocument, numPagina, 25f, 282f);
			String apellidos = StringUtils.join(solicitud.getApFirma(), StringUtils.SPACE, solicitud.getAmFirma());
			pdfUtil.agregarTextoConEspaciado(apellidos, pdfDocument, numPagina, 25f, 272f);
			pdfUtil.agregarFirma(solicitud.getFirmaEmpleado(), pdfDocument, numPagina, 165.0f, 272.0f, 100, 35);
			
			
			
			
			pdfUtil.agregarTextoConEspaciado(solicitud.getNombreAsesor(), pdfDocument, numPagina, 25f, 102f);
			pdfUtil.agregarTextoConEspaciado(solicitud.getCurpAsesor(), pdfDocument, numPagina, 122f, 92f, 4.3f);
			pdfUtil.agregarFirma(solicitud.getFirmaAgente(), pdfDocument, numPagina, 165.0f, 100.0f, 100, 35);
			
			
			
			
			if (flujo532) {
				pdfUtil.agregarTextoLeyenda("La solicitud de retiro estará sujeto a la respuesta del IMSS y se podrá obtener una vez que el servicio esté disponible", pdfDocument, 2, 15, 378, 8.1f);

			}

		} catch (Exception e) {
			logger.error("Error llenado datos afore COPPEL, pagina 2: ", e);
		}

	}

	/**
	 * 
	 * agrega la forma de pago de la solicitud de retiro parcial por desempleo
	 * Coppel
	 * 
	 * @author Manuel González Valdez (mgonzava@inet.procesar.com.mx)
	 * @param formaPago
	 * @param institucionBancaria
	 * @param numeroSucursalBancaria
	 * @param clabe
	 * @param referenciaPago
	 * @param otroMedioPago
	 * @param pdfDocument
	 * @throws IOException
	 */
	protected void agregarFormaPagoCoppel(String formaPago, String institucionBancaria, String numeroSucursalBancaria,
			String clabe, String referenciaPago, String otroMedioPago, PDDocument pdfDocument) throws IOException {
		int numeroPagina = 1;

		if (formaPago == null) {
			return;
		}

		switch (formaPago) {
		case PAGO_TRANSFERENCIA_BANCARIA_COPPEL:
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, FLOAT_28, 402f);// transferencia bancaria
			pdfUtil.agregarTextoConEspaciado(institucionBancaria, pdfDocument, numeroPagina, 148f, 412f, 0.5f);
			pdfUtil.agregarTextoConEspaciado(numeroSucursalBancaria, pdfDocument, numeroPagina, 170f, 401f, 0.5f);
			pdfUtil.agregarTextoConEspaciado(clabe, pdfDocument, numeroPagina, FLOAT_141, 387f, 3.2f);
			break;
		//ORDEN DE PAGO PARA EL NUEVO PDF
		case VENTANILLA:
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, FLOAT_28, 369f);// orden de pago
			pdfUtil.agregarTextoConEspaciado("CAJAS COPPEL", pdfDocument, numeroPagina, FLOAT_108, 358f, 0.5f);
			break;
		default:
			return;
		}

	}

	/**
	 * 
	 * marca la compañia a la que pertenece el celular de la solicitud de retiro
	 * parcial por desempleo Coppel
	 * 
	 * @author Manuel González Valdez (mgonzava@inet.procesar.com.mx)
	 * @param companiaCelular
	 * @param pdfDocument
	 * @throws IOException
	 */
	protected void marcarCompaniaCelularCoppel(String companiaCelular, PDDocument pdfDocument) throws IOException {
		int numeroPagina = 1;

		if (companiaCelular == null) {
			return;
		}

		switch (companiaCelular.toLowerCase()) {
		case TELCEL:
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 445f, FLOAT_588);// telcel
			break;
		case IUSACELL:
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 500f, FLOAT_588);// iusacell
			break;
		case UNEFON:
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 555f, FLOAT_588);// unefon
			break;
		case MOVISTAR:
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 445f, 568);// movistar
			break;
		case NEXTEL:
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 500f, 568);// nextel
			break;
		default:
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 555f, 568);// otros
			return;
		}
	}

	/**
	 * 
	 * agrega los datos la modalidad de retiro Coppel
	 * 
	 * @author Manuel González Valdez (mgonzava@inet.procesar.com.mx)
	 * @param modalidadRetiro
	 * @param formaEntrega
	 * @param asesorado
	 * @param pdfDocument
	 * @throws IOException
	 */
	protected void agregarModalidadRetiroCoppel(String modalidadRetiro, String formaEntrega, Boolean asesorado, PDDocument pdfDocument) throws IOException {
		int numeroPagina = 1;

		if (MODALIDAD_RETIRO_A.equals(modalidadRetiro)) {
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 387f, 399f);// modalida a
		} else if (MODALIDAD_RETIRO_B.equals(modalidadRetiro)) {
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 572f, 399f);// modalida b

			//if (FORMA_ENTREGA_SEIS_PAGOS.equals(formaEntrega)) {
				//pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, FLOAT_420_8, 347f);// seis pagos
																									// proporcionales
			//} else if (FORMA_ENTREGA_PRIMER_PAGO_30_DIAS.equals(formaEntrega)) {
				//pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, FLOAT_420_8, 332f);// primer pago en 30 dias
			//}

		}

		if (asesorado) {
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 499f, 281f);// asesorado, si
		} else {
			pdfUtil.agregarTexto(MARCA_MAYUSCULA, pdfDocument, numeroPagina, 563f, 281f);// asesorado, no
		}

	}

}
