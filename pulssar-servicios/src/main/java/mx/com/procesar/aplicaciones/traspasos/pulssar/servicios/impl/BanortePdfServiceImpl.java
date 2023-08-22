package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BanortePdfService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils;

@Service
public class BanortePdfServiceImpl implements BanortePdfService {

	/**
	 * PdfUtils
	 */
	@Autowired
	PdfUtils pdfUtil;
	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BanortePdfService#agregarSolicitudRetiroParcialDesempleoPaginaUnoBanorte(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleo, org.apache.pdfbox.pdmodel.PDDocument)
	 */
	@Override
	public void agregarSolicitudRetiroParcialDesempleoPaginaUnoBanorte(DatosSolicitudRetiroParcialDesempleo solicitud, PDDocument pdfDocument) throws IOException {
		int numeroPagina = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy", new Locale("es","MX"));
		
		pdfUtil.agregarTexto(null/*folio*/, pdfDocument, numeroPagina, 467, 724);
		pdfUtil.agregarTexto(null /*num de unidad*/, pdfDocument, numeroPagina, 403, 697);
		pdfUtil.agregarTexto(sdf.format(Calendar.getInstance().getTime()), pdfDocument, numeroPagina, 517, 702);
		pdfUtil.agregarTexto(solicitud.getNombre(), pdfDocument, numeroPagina, 26, 669);
		pdfUtil.agregarTexto(solicitud.getApellidoPaterno(), pdfDocument, numeroPagina, 26, 642);
		pdfUtil.agregarTexto(solicitud.getApellidoMaterno(), pdfDocument, numeroPagina, 317, 642);
		pdfUtil.agregarTexto(solicitud.getNss(), pdfDocument, numeroPagina, 26, 616);
		pdfUtil.agregarTexto(solicitud.getRfc(), pdfDocument, numeroPagina, 170, 616);
		pdfUtil.agregarTexto(solicitud.getFechaNacimiento(), pdfDocument, numeroPagina, 318, 614);
		
		pdfUtil.agregarTexto(solicitud.getGenero(), pdfDocument, numeroPagina, 533, 626);
		
		pdfUtil.agregarTexto(solicitud.getCurp(), pdfDocument, numeroPagina, 27, 584);
		pdfUtil.agregarTexto(solicitud.getTelefono(), pdfDocument, numeroPagina, 283, 596);
		pdfUtil.agregarTexto(solicitud.getCelular(), pdfDocument, numeroPagina, 283, 581);
		pdfUtil.agregarTexto(solicitud.getEmail(), pdfDocument, numeroPagina, 144, 563);
		pdfUtil.agregarTexto(solicitud.getCalle(), pdfDocument, numeroPagina, 26, 523);
		pdfUtil.agregarTexto(solicitud.getNumeroExterior(), pdfDocument, numeroPagina, 303, 523);
		pdfUtil.agregarTexto(solicitud.getNumeroInterior(), pdfDocument, numeroPagina, 362, 523);
		
		pdfUtil.agregarTexto(solicitud.getCodigoPostal(), pdfDocument, numeroPagina, 424, 523);
		pdfUtil.agregarTexto(solicitud.getPais(), pdfDocument, numeroPagina, 486, 523);
		pdfUtil.agregarTexto(solicitud.getColonia(), pdfDocument, numeroPagina, 26, 495);
		pdfUtil.agregarTexto(solicitud.getEntidadFederativa(), pdfDocument, numeroPagina, 305, 495);
		pdfUtil.agregarTexto(solicitud.getDelegacionMunicipio(), pdfDocument, numeroPagina, 26, 468);
		pdfUtil.agregarTexto(solicitud.getEntidadFederativa(), pdfDocument, numeroPagina, 306, 468);
		
	}

	
	/* (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BanortePdfService#generarSolicitudDisposicionParcialIsssteBanorte(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSolicitudRetiroParcialDesempleoIssste, org.apache.pdfbox.pdmodel.PDDocument, int)
	 */
	@Override
	public void generarSolicitudDisposicionParcialIsssteBanorte(DatosSolicitudRetiroParcialDesempleoIssste solicitud, PDDocument pdfDocument, int numeroPagina) throws IOException {
		Calendar cal = Calendar.getInstance();
		String dia = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		String mes = cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, new Locale("ES", "MX"));
		String anio = Integer.toString(cal.get(Calendar.YEAR));
		StringBuilder sb = new StringBuilder();
		String calle = StringUtils.isEmpty(solicitud.getCalle()) ? "" : solicitud.getCalle();
		String numExt = StringUtils.isEmpty(solicitud.getNumeroExterior()) ? "" : solicitud.getNumeroExterior();
		String numInt = StringUtils.isEmpty(solicitud.getNumeroInterior()) ? "" : solicitud.getNumeroInterior();
		String calleYNum = sb.append(calle).append(" ").append(numExt).append(" ").append(numInt).toString();
		pdfUtil.agregarTexto(null /* agencia */, pdfDocument, numeroPagina, 49, 692);
		pdfUtil.agregarTexto(dia, pdfDocument, numeroPagina, 507, 692);
		pdfUtil.agregarTexto(mes, pdfDocument, numeroPagina, 532, 692);
		pdfUtil.agregarTexto(anio, pdfDocument, numeroPagina, 566, 692);
		pdfUtil.agregarTexto(solicitud.getNss(), pdfDocument, numeroPagina, 164, 652);
		pdfUtil.agregarTexto(solicitud.getCurp(), pdfDocument, numeroPagina, 312, 652);
		pdfUtil.agregarTexto(solicitud.getRfc(), pdfDocument, numeroPagina, 461, 652);
		pdfUtil.agregarTexto(solicitud.getApellidoPaterno(), pdfDocument, numeroPagina, 17, 627);
		pdfUtil.agregarTexto(solicitud.getApellidoMaterno(), pdfDocument, numeroPagina, 313, 627);
		pdfUtil.agregarTexto(solicitud.getNombre(), pdfDocument, numeroPagina, 17, 602);
		pdfUtil.agregarTexto(calleYNum, pdfDocument, numeroPagina, 17, 558);
		pdfUtil.agregarTexto(solicitud.getColonia(), pdfDocument, numeroPagina, 313, 558);
		pdfUtil.agregarTexto(solicitud.getCodigoPostal(), pdfDocument, numeroPagina, 17, 534);
		pdfUtil.agregarTexto(solicitud.getDelegacionMunicipio(), pdfDocument, numeroPagina, 162, 534);
		pdfUtil.agregarTexto(solicitud.getEntidadFederativa(), pdfDocument, numeroPagina, 461, 534);
		pdfUtil.agregarTexto(null/* tel dom */, pdfDocument, numeroPagina, 17, 507);
		pdfUtil.agregarTexto(null/* tel oficina */, pdfDocument, numeroPagina, 197, 507);
		pdfUtil.agregarTexto(null /* extension */, pdfDocument, numeroPagina, 372, 507);

		pdfUtil.agregarImagen(solicitud.getFirmaAgente(), pdfDocument, numeroPagina, 365, 112);
		pdfUtil.agregarImagen(solicitud.getFirmaTrabajador(), pdfDocument, numeroPagina, 70, 112);

	}
	
	
	
	
}
