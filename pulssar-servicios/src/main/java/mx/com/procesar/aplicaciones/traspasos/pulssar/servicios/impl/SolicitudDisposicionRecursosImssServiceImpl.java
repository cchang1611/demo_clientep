package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.util.Strings;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionRecursosImssService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaTramite;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CodigoUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils;
/**
 * Solicitud disposicion recursos imss
 * @author RARREOLA
 *
 */
@Service
public class SolicitudDisposicionRecursosImssServiceImpl implements SolicitudDisposicionRecursosImssService{

	/**
	 * utilerias codigoUtils
	 */
	@Autowired
	private CodigoUtils codigoUtils;

	
	@Autowired
	private PdfUtils pdfUtils;
	

	
	
	/**
	 * soliitud imss
	 */
	@Override
	public void agregarSolicitudImss(RespuestaTramite disposicionTotal, DatosTrabajador trabajador,
			PDDocument pdfDocument) throws IOException {
		int numeroPagina = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es","MX"));
		StringBuilder builder = new StringBuilder();
		if(!codigoUtils.validarObjeto(disposicionTotal)) {
			agregrDatosAfiliado( disposicionTotal, trabajador,  pdfDocument,  numeroPagina);
			 agregarDomicilioParAmbiente(disposicionTotal,trabajador,pdfDocument,numeroPagina);
			 agregarDatosDescripcionDerecho( disposicionTotal,  pdfDocument, numeroPagina);
			  agregarDatosBeneficiario(disposicionTotal,  pdfDocument, numeroPagina);
//			pdfUtils.agregarTexto(builder
//					.append(codigoUtils.esVacio(trabajador.getDatosCertificables().getApellidoPaterno())
//							? ExpresionesConstants.VACIO : trabajador.getDatosCertificables().getApellidoPaterno())
//					.append(ExpresionesConstants.ESPACIO)
//					.append(codigoUtils.esVacio(trabajador.getDatosCertificables().getApellidoMaterno()) ? ExpresionesConstants.VACIO
//							: trabajador.getDatosCertificables().getApellidoMaterno())
//					.append(ExpresionesConstants.ESPACIO)
//					.append(codigoUtils.esVacio(trabajador.getDatosCertificables().getNombre()) ? ExpresionesConstants.VACIO
//							: trabajador.getDatosCertificables().getNombre())
//					.toString(), pdfDocument, 1, 245, 660, null);
//			  pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getCuentaClabe()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getCuentaClabe(), pdfDocument, 1, 430, 540, null);
				
		  
		  
		 
		   
		}
		pdfUtils.agregarTexto(sdf.format(Calendar.getInstance().getTime()), pdfDocument, numeroPagina, 271, 693, null);
		
	}
	
	/**
	 * Agrega coordenadas datos afiliado 
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregrDatosAfiliado(RespuestaTramite disposicionTotal,DatosTrabajador trabajador, PDDocument pdfDocument, int numeroPagina) throws IOException {
		pdfUtils.agregarTexto(trabajador.getNss()  == null ? ExpresionesConstants.VACIO : trabajador.getNss(), pdfDocument, numeroPagina, 27, 651, null);
		pdfUtils.agregarTexto(trabajador.getDatosCertificables().getCurp()  == null ? ExpresionesConstants.VACIO : trabajador.getDatosCertificables().getCurp(), pdfDocument, numeroPagina, 212, 651, null);
		pdfUtils.agregarTexto(trabajador.getDatosNoCertificables().getRfc()  == null ? ExpresionesConstants.VACIO : trabajador.getDatosNoCertificables().getRfc() , pdfDocument, numeroPagina, 403, 651, null);
		pdfUtils.agregarTexto(trabajador.getDatosCertificables().getNombre()  == null ? ExpresionesConstants.VACIO : trabajador.getDatosCertificables().getNombre(), pdfDocument, numeroPagina, 27, 626, null);
		pdfUtils.agregarTexto(trabajador.getDatosCertificables().getApellidoPaterno()  == null ? ExpresionesConstants.VACIO : trabajador.getDatosCertificables().getApellidoPaterno(), pdfDocument, numeroPagina, 212, 626, null);
		pdfUtils.agregarTexto(trabajador.getDatosCertificables().getApellidoMaterno()  == null ? ExpresionesConstants.VACIO : trabajador.getDatosCertificables().getApellidoMaterno(), pdfDocument, numeroPagina, 403, 626, null);
		pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getFechaNacimiento() == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getFechaNacimiento(), pdfDocument, numeroPagina, 27, 601, null);
	}
	
	
	/**
	 * Agrega coordenadas domicilio par ambiente
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregarDomicilioParAmbiente(RespuestaTramite disposicionTotal, DatosTrabajador trabajador, PDDocument pdfDocument, int numeroPagina) throws IOException {
		StringBuilder calle = new StringBuilder();
		StringBuilder calleVal = new StringBuilder();
		StringBuilder numEVal = new StringBuilder();
		String calleV = null;
		String numE = null;
		
		if(Strings.isNotBlank(disposicionTotal.getCalle())){
			calleV = calleVal.append(disposicionTotal.getCalle()).append(ExpresionesConstants.ESPACIO).toString();
		}
		
		if(Strings.isNotBlank(disposicionTotal.getNumeroExterior())){
			numE = numEVal.append(disposicionTotal.getNumeroExterior()).append(ExpresionesConstants.ESPACIO).toString();
			
		}
		pdfUtils.agregarTexto(calle.append(disposicionTotal.getCalle()  == null ? ExpresionesConstants.VACIO : calleV).append(disposicionTotal.getNumeroExterior()  == null ? ExpresionesConstants.VACIO : numE).append(disposicionTotal.getNumeroInterior()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getNumeroInterior()).toString(), pdfDocument, numeroPagina, 27, 556, null);
		setearDatosDom(disposicionTotal,   pdfDocument, numeroPagina);
		setearDatosDomi(disposicionTotal,  trabajador, pdfDocument, numeroPagina);
		setearDatosDomicilio( trabajador, pdfDocument, numeroPagina);
	}

	/**
	 * Datos domicilio
	 * @param entradaParams
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	private void setearDatosDomicilio( DatosTrabajador trabajador, PDDocument pdfDocument, int numeroPagina)
			throws IOException {
		pdfUtils.agregarTexto(trabajador.getDatosComplementarios().getTelefonos().getCelular() == null ? ExpresionesConstants.VACIO : trabajador.getDatosComplementarios().getTelefonos().getCelular(), pdfDocument, numeroPagina, 331, 506, null);
		pdfUtils.agregarTexto(trabajador.getDatosComplementarios().getTelefonos().getExtension() == null ? ExpresionesConstants.VACIO : trabajador.getDatosComplementarios().getTelefonos().getExtension(), pdfDocument, numeroPagina, 434, 506, null);
		pdfUtils.agregarTexto(trabajador.getDatosComplementarios().getTelefonos().getTelefonoFijo()  == null ? ExpresionesConstants.VACIO : trabajador.getDatosComplementarios().getTelefonos().getTelefonoFijo(), pdfDocument, numeroPagina, 501, 506, null);
	}

	/**
	 * Datos domicilio
	 * 
	 * @param entradaParams
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	private void setearDatosDomi(RespuestaTramite disposicionTotal, DatosTrabajador trabajador, PDDocument pdfDocument, int numeroPagina)
			throws IOException {
		pdfUtils.agregarTexto(disposicionTotal.getPais()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getPais(), pdfDocument, numeroPagina, 501, 530, null);
		pdfUtils.agregarTexto(disposicionTotal.getEntidadFederativa()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getEntidadFederativa(), pdfDocument, numeroPagina, 27, 506, null);
		pdfUtils.agregarTexto(trabajador.getDatosComplementarios().getTelefonos().getTelefonoLaboral()  == null ? ExpresionesConstants.VACIO : trabajador.getDatosComplementarios().getTelefonos().getTelefonoLaboral() , pdfDocument, numeroPagina, 237, 506, null);
	}

	/**
	 * Datos dom
	 * @param entradaParams
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	private void setearDatosDom(RespuestaTramite disposicionTotal, PDDocument pdfDocument, int numeroPagina)
			throws IOException {
		pdfUtils.agregarTexto(disposicionTotal.getColonia()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getColonia(), pdfDocument, numeroPagina, 27, 530, null);
		pdfUtils.agregarTexto(disposicionTotal.getCodigoPostal()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getCodigoPostal() , pdfDocument, numeroPagina, 237, 530, null);
		pdfUtils.agregarTexto(disposicionTotal.getDelegacionMunicipio()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getDelegacionMunicipio(), pdfDocument, numeroPagina, 330, 530, null);
	}
	
	
	/**
	 * Agrega coordenadas descripcion derecho
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregarDatosDescripcionDerecho(RespuestaTramite disposicionTotal,  PDDocument pdfDocument, int numeroPagina) throws IOException {
		validarCadenaRetiro(disposicionTotal,   pdfDocument, numeroPagina);
		validarCadenaSeguro(disposicionTotal,    pdfDocument, numeroPagina);
		validarCadenaTipoPencion(disposicionTotal,  pdfDocument, numeroPagina);
		validarCadenaTipoPrestacion(disposicionTotal,  pdfDocument, numeroPagina);
		setearValorClaveRegimen(disposicionTotal,  pdfDocument, numeroPagina);
		pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getNumeroResolucion()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getNumeroResolucion(), pdfDocument, numeroPagina, 27, 424, null);
		pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getSecuenciaPension()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getSecuenciaPension(), pdfDocument, numeroPagina, 237, 424, null);
		setearDatosDescDerecho(disposicionTotal, pdfDocument, numeroPagina);
		if(Strings.isNotBlank(disposicionTotal.getProcesoNocargado().getCveDocProbatorio())){
			validarCadenaDocProbatorio( disposicionTotal, pdfDocument,  numeroPagina);
		}
		
//		String montoRcv = disposicionTotal.getProcesoNocargado().getMontoTotalRcv();
//		String montoViv = disposicionTotal.getProcesoNocargado().getMontoTotalViv();
//		montoRcv = montoRcv.replace(ExpresionesConstants.SIGNO_PESOS, ExpresionesConstants.VACIO);
//		montoViv = montoViv.replace(ExpresionesConstants.SIGNO_PESOS, ExpresionesConstants.VACIO);
//		Double sumaLiq = Double.valueOf(montoRcv)+Double.valueOf(montoViv);
		StringBuilder bui = new StringBuilder();
//		String sum = bui.append(ExpresionesConstants.SIGNO_PESOS).append(sumaLiq).toString();
//		pdfUtils.agregarTexto(sumaLiq.toString()  == null ? ExpresionesConstants.VACIO : sum, pdfDocument, numeroPagina, 434, 374, null);
		pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getFolioInfonavit()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getFolioInfonavit(), pdfDocument, numeroPagina, 434, 400, null);
		pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getPorcentajeValuacion()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getPorcentajeValuacion().toString(), pdfDocument, numeroPagina, 237, 374, null);
		
	}

	/**
	 * Desc dercho
	 * @param entradaParams
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	private void setearDatosDescDerecho(RespuestaTramite disposicionTotal, PDDocument pdfDocument,
			int numeroPagina) throws IOException {
		pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getFcInicioPension()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getFcInicioPension() , pdfDocument, numeroPagina, 330, 424, null);
		pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getFcEmisionResolucion()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getFcEmisionResolucion(), pdfDocument, numeroPagina, 433, 424, null);
		pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getSemanasCotizadas()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getSemanasCotizadas().toString(), pdfDocument, numeroPagina, 27, 375, null);
	}

	/**
	 * Clave regimen
	 * @param entradaParams
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	private void setearValorClaveRegimen(RespuestaTramite disposicionTotal, PDDocument pdfDocument,
			int numeroPagina) throws IOException {
			
		pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getCvTipoRegimen()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCvTipoRegimen(), pdfDocument, numeroPagina, 527, 460, null);
		
	}
	/**
	 * Cortar cadena
	 * @param Cadena
	 * @return
	 * @throws IOException 
	 */
	private void validarCadenaTipoPrestacion(RespuestaTramite disposicionTotal,  PDDocument pdfDocument, int numeroPagina) throws IOException{
		StringBuilder tipoPresPrimerParte = new StringBuilder();
		String cadenaNueva;
		int posicionEspacio;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(!codigoUtils.esVacio(disposicionTotal.getProcesoNocargado().getDescTipoPrestacion()) && disposicionTotal.getProcesoNocargado().getDescTipoPrestacion().length()> 19){
			String cadena = disposicionTotal.getProcesoNocargado().getDescTipoPrestacion();
			 posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_TRES, lista);
			 if(lista.size() < 2){
				 posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_DOS, lista);
				 if(posicionEspacio == 0){
						posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_UNO, lista);
					}
			 }
			 cadenaNueva = cadena.substring(NumerosConstants.INT_CERO, posicionEspacio);
			 if(cadenaNueva.length() > 19){
				 posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_DOS, lista);
				 cadenaNueva = cadena.substring(NumerosConstants.INT_CERO, posicionEspacio);
			 }
			 pdfUtils.agregarTexto(tipoPresPrimerParte.append(disposicionTotal.getProcesoNocargado().getCvTipoPrestacion()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCvTipoPrestacion()).append(ActivacionConstants.GUION_RESTA).append(disposicionTotal.getProcesoNocargado().getDescTipoPrestacion()  == null ? ExpresionesConstants.VACIO :  cadenaNueva).toString(), pdfDocument, numeroPagina, 435, 460, null);
			 cadenaNueva = cadena.substring(posicionEspacio);
			 tipoPrestacionSegundoParrafo(pdfDocument, numeroPagina, cadenaNueva, lista, disposicionTotal.getProcesoNocargado().getCvTipoPrestacion());
			
		}else{
			pdfUtils.agregarTexto(tipoPresPrimerParte.append(disposicionTotal.getProcesoNocargado().getCvTipoPrestacion()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCvTipoPrestacion()).append(ActivacionConstants.GUION_RESTA).append(disposicionTotal.getProcesoNocargado().getDescTipoPrestacion()  == null ? ExpresionesConstants.VACIO :  disposicionTotal.getProcesoNocargado().getDescTipoPrestacion()).toString(), pdfDocument, numeroPagina, 435, 460, null);
			
			
		}	
	}

	

	/**
	 * Tipo prestacion parrafo
	 * @param pdfDocument
	 * @param numeroPagina
	 * @param cadenaNueva
	 * @param lista
	 * @throws IOException
	 */
	protected void tipoPrestacionSegundoParrafo(PDDocument pdfDocument, int numeroPagina, String cadenaNueva,
			List<Integer> lista, String clave) throws IOException {
		int posicionEspacio;
		String cadenaNuevaA = cadenaNueva;
		if(cadenaNuevaA.length()> 18){
			if(ActivacionConstants.TIPO_PRES.equals(clave)){
				pdfUtils.agregarTexto(cadenaNuevaA, pdfDocument, numeroPagina, 435, 452, null);
			}else{
				posicionEspacio = contarEspacios(cadenaNuevaA, NumerosConstants.INT_TRES, lista);
				String nuevaDos = cadenaNuevaA.substring(NumerosConstants.INT_CERO, posicionEspacio);
				pdfUtils.agregarTexto(nuevaDos, pdfDocument, numeroPagina, 435, 452, null);
				cadenaNuevaA = cadenaNuevaA.substring(posicionEspacio);
				pdfUtils.agregarTexto(cadenaNuevaA, pdfDocument, numeroPagina, 435, 446, null); 
			}
			
		}else{
			pdfUtils.agregarTexto(cadenaNuevaA, pdfDocument, numeroPagina, 435, 452, null);
		}
	}


	
	
	/**
	 * Cortar cadena
	 * @param Cadena
	 * @return
	 * @throws IOException 
	 */
	private void validarCadenaTipoPencion(RespuestaTramite disposicionTotal,   PDDocument pdfDocument, int numeroPagina) throws IOException{
		StringBuilder tipoPenPrimerParte = new StringBuilder();
		String cadenaNueva;
		int posicionEspacio;
	
		if(!codigoUtils.esVacio(disposicionTotal.getProcesoNocargado().getDescTipoPension()) && disposicionTotal.getProcesoNocargado().getDescTipoPension().length()> 20){
			String cadena = disposicionTotal.getProcesoNocargado().getDescTipoPension();
			List<Integer> lista = new ArrayList<>();
			lista.add(NumerosConstants.INT_CERO);
			posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_TRES, lista);
			if(lista.size() < 2){
				posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_DOS, lista);
				
				if(posicionEspacio == 0){
					posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_UNO, lista);
				}
			}
			 cadenaNueva = cadena.substring(NumerosConstants.INT_CERO, posicionEspacio);
			 pdfUtils.agregarTexto(tipoPenPrimerParte.append(disposicionTotal.getProcesoNocargado().getCvTipoPension()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCvTipoPension()).append(ActivacionConstants.GUION_RESTA).append(disposicionTotal.getProcesoNocargado().getDescTipoPension()  == null ? ExpresionesConstants.VACIO :  cadenaNueva).toString(), pdfDocument, numeroPagina, 331, 460, null);
			cadenaNueva = cadena.substring(posicionEspacio);
			pdfUtils.agregarTexto(cadenaNueva, pdfDocument, numeroPagina, 331, 453, null);
		}else{
			pdfUtils.agregarTexto(tipoPenPrimerParte.append(disposicionTotal.getProcesoNocargado().getCvTipoPension()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCvTipoPension()).append(ActivacionConstants.GUION_RESTA).append(disposicionTotal.getProcesoNocargado().getDescTipoPension()  == null ? ExpresionesConstants.VACIO :  disposicionTotal.getProcesoNocargado().getDescTipoPension()).toString(), pdfDocument, numeroPagina, 331, 460, null);
			
		}	
	}
	
	
	
	/**
	 * Cortar cadena
	 * @param Cadena
	 * @return
	 * @throws IOException 
	 */
	private void validarCadenaDocProbatorio(RespuestaTramite disposicionTotal,  PDDocument pdfDocument, int numeroPagina) throws IOException{
		String cadenaNueva;
		StringBuilder docPrimerParte = new StringBuilder();
		int posicionEspacio;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(disposicionTotal.getProcesoNocargado().getDesDocProbatorio().length()> 20){
			String cadena = disposicionTotal.getProcesoNocargado().getDesDocProbatorio();
			 posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_TRES, lista);
			 cadenaNueva = cadena.substring(NumerosConstants.INT_CERO, posicionEspacio);
			 pdfUtils.agregarTexto(docPrimerParte.append(NumerosConstants.C_CERO.equals(disposicionTotal.getProcesoNocargado().getCveDocProbatorio()) ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCveDocProbatorio()).append(NumerosConstants.C_CERO.equals(disposicionTotal.getProcesoNocargado().getCveDocProbatorio()) ? ExpresionesConstants.VACIO : ActivacionConstants.GUION_RESTA).append(NumerosConstants.C_CERO.equals(disposicionTotal.getProcesoNocargado().getCveDocProbatorio()) ? ExpresionesConstants.VACIO  : cadenaNueva).toString(), pdfDocument, numeroPagina, 331, 375, NumerosConstants.C_CERO);
			 cadenaNueva = cadena.substring(posicionEspacio);
			pdfUtils.agregarTexto(cadenaNueva, pdfDocument, numeroPagina, 331, 368, null);
		}else{
			pdfUtils.agregarTexto(docPrimerParte.append(NumerosConstants.C_CERO.equals(disposicionTotal.getProcesoNocargado().getCveDocProbatorio()) ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCveDocProbatorio()).append(NumerosConstants.C_CERO.equals(disposicionTotal.getProcesoNocargado().getCveDocProbatorio()) ? ExpresionesConstants.VACIO : ActivacionConstants.GUION_RESTA).append(NumerosConstants.C_CERO.equals(disposicionTotal.getProcesoNocargado().getCveDocProbatorio()) ? ExpresionesConstants.VACIO :  disposicionTotal.getProcesoNocargado().getDesDocProbatorio()).toString(), pdfDocument, numeroPagina, 331, 375, NumerosConstants.C_CERO);
			
			
		}	
	}
	
	/**
	 * Cortar cadena
	 * @param Cadena
	 * @return
	 * @throws IOException 
	 */
	private void validarCadenaRetiro(RespuestaTramite disposicionTotal,  PDDocument pdfDocument, int numeroPagina) throws IOException{
		StringBuilder retiroPrimerParte = new StringBuilder();
		String cadenaNueva;
		int posicionEspacio;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(!codigoUtils.validarObjeto(disposicionTotal.getProcesoNocargado().getDescTipoRetiro()) &&
				disposicionTotal.getProcesoNocargado().getDescTipoRetiro().length()> 49){
			String cadena = disposicionTotal.getProcesoNocargado().getDescTipoRetiro();
			 posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_SEIS, lista);
			 cadenaNueva = cadena.substring(NumerosConstants.INT_CERO, posicionEspacio);
			 pdfUtils.agregarTexto(retiroPrimerParte.append(disposicionTotal.getProcesoNocargado().getCvTipoRetiro()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCvTipoRetiro()).append(ActivacionConstants.GUION_RESTA).append(disposicionTotal.getProcesoNocargado().getDescTipoRetiro()  == null ? ExpresionesConstants.VACIO :  cadenaNueva).toString(), pdfDocument, numeroPagina, 27, 460, null);
			 cadenaNueva = cadena.substring(posicionEspacio);
			 validarTercerRenglonRetiro(pdfDocument, numeroPagina, cadenaNueva, disposicionTotal.getProcesoNocargado().getCvTipoRetiro());
		}else{
			pdfUtils.agregarTexto(retiroPrimerParte.append(disposicionTotal.getProcesoNocargado().getCvTipoRetiro()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCvTipoRetiro()).append(ActivacionConstants.GUION_RESTA).append(disposicionTotal.getProcesoNocargado().getDescTipoRetiro()  == null ? ExpresionesConstants.VACIO :  disposicionTotal.getProcesoNocargado().getDescTipoRetiro() ).toString(), pdfDocument, numeroPagina, 27, 460, null);
			
		}	
	}

	/**
	 * Retiro
	 * @param pdfDocument
	 * @param numeroPagina
	 * @param cadenaNueva
	 * @throws IOException
	 */
	protected void validarTercerRenglonRetiro(PDDocument pdfDocument, int numeroPagina, String cadenaNueva, String clave)
			throws IOException {
		int posicionEspacio;
		String cadenaNuevaAux = cadenaNueva;
		String cadenaNuevaDos;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(cadenaNuevaAux.length()> 50){
				posicionEspacio = seleccionarPosicion(clave, cadenaNuevaAux, lista);
				cadenaNuevaDos = cadenaNuevaAux.substring(NumerosConstants.INT_CERO, posicionEspacio);
				pdfUtils.agregarTexto(cadenaNuevaDos, pdfDocument, numeroPagina, 27, 453, null);
				cadenaNuevaAux = cadenaNuevaAux.substring(posicionEspacio);
				validarCuartoRenglonRetiro(pdfDocument, numeroPagina, cadenaNuevaAux);
			}else{
				pdfUtils.agregarTexto(cadenaNuevaAux, pdfDocument, numeroPagina, 27, 453, null);
			}
	}

	/**
	 * Seleccionar posicion
	 * @param clave
	 * @param cadenaNuevaAux
	 * @param lista
	 * @return
	 */
	private int seleccionarPosicion(String clave, String cadenaNuevaAux, List<Integer> lista) {
		int posicionEspacio;
		if(ActivacionConstants.Q_RETIRO.equals(clave)){
			posicionEspacio = contarEspacios(cadenaNuevaAux, NumerosConstants.INT_SIETE, lista);
		}else{
			posicionEspacio = contarEspacios(cadenaNuevaAux, NumerosConstants.INT_OCHO, lista);
		}
		return posicionEspacio;
	}
	
	
	/**
	 * Retiro
	 * @param pdfDocument
	 * @param numeroPagina
	 * @param cadenaNueva
	 * @throws IOException
	 */
	private void validarCuartoRenglonRetiro(PDDocument pdfDocument, int numeroPagina, String cadenaNueva)
			throws IOException {
		int posicionEspacio;
		String cadenaNuevaDo;
		String cadenaNuevaAu = cadenaNueva;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(cadenaNuevaAu.length()> 49){
				posicionEspacio = contarEspacios(cadenaNuevaAu, NumerosConstants.INT_OCHO, lista);
				cadenaNuevaDo = cadenaNuevaAu.substring(NumerosConstants.INT_CERO, posicionEspacio);
				pdfUtils.agregarTexto(cadenaNuevaDo, pdfDocument, numeroPagina, 27, 447, null);
				cadenaNuevaAu = cadenaNuevaAu.substring(posicionEspacio);
				pdfUtils.agregarTexto(cadenaNuevaAu, pdfDocument, numeroPagina, 27, 441, null);
			}else{
				pdfUtils.agregarTexto(cadenaNuevaAu, pdfDocument, numeroPagina, 27, 447, null);
			}
	}
	
	
	/**
	 * Cortar cadena
	 * @param Cadena
	 * @return
	 * @throws IOException 
	 */
	private void validarCadenaSeguro(RespuestaTramite disposicionTotal,   PDDocument pdfDocument, int numeroPagina) throws IOException{
		StringBuilder seguroPrimerParte = new StringBuilder();
		String cadenaNueva;
		int posicionEspacio;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(!codigoUtils.esVacio(disposicionTotal.getProcesoNocargado().getDescTipoSeguro()) && disposicionTotal.getProcesoNocargado().getDescTipoSeguro().length()> 24){
			 String cadena = disposicionTotal.getProcesoNocargado().getDescTipoSeguro();	
			 posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_TRES, lista);
			 cadenaNueva = cadena.substring(NumerosConstants.INT_CERO, posicionEspacio);
			 pdfUtils.agregarTexto(seguroPrimerParte.append(disposicionTotal.getProcesoNocargado().getCvTipoSeguro()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCvTipoSeguro()).append(ActivacionConstants.GUION_RESTA).append(disposicionTotal.getProcesoNocargado().getDescTipoSeguro()  == null ? ExpresionesConstants.VACIO :  cadenaNueva).toString(), pdfDocument, numeroPagina, 237, 460, null);
			  cadenaNueva = cadena.substring(posicionEspacio);
			  validarTercerRenglonSeguro(pdfDocument, numeroPagina, cadenaNueva);
		}else{
			pdfUtils.agregarTexto(seguroPrimerParte.append(disposicionTotal.getProcesoNocargado().getCvTipoSeguro()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getCvTipoSeguro()).append(ActivacionConstants.GUION_RESTA).append(disposicionTotal.getProcesoNocargado().getDescTipoSeguro()  == null ? ExpresionesConstants.VACIO :  disposicionTotal.getProcesoNocargado().getDescTipoSeguro()).toString(), pdfDocument, numeroPagina, 237, 460, null);
			
		}	
	}

	/**
	 * Tercer parrafo seguro
	 * @param pdfDocument
	 * @param numeroPagina
	 * @param cadenaNueva
	 * @throws IOException
	 */
	private void validarTercerRenglonSeguro(PDDocument pdfDocument, int numeroPagina, String cadenaNueva)
			throws IOException {
		String cadenaNuevaD;
		int posicionEspacio;
		String cadenaNuevaAux = cadenaNueva;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(cadenaNuevaAux.length()> 30){
			posicionEspacio = contarEspacios(cadenaNuevaAux, NumerosConstants.INT_CUATRO, lista);
			cadenaNuevaD = cadenaNuevaAux.substring(NumerosConstants.INT_CERO, posicionEspacio);
			pdfUtils.agregarTexto(cadenaNuevaD, pdfDocument, numeroPagina, 237, 453, null);
			cadenaNuevaAux = cadenaNuevaAux.substring(posicionEspacio);
			validarCuartoRenglonSeguro(pdfDocument, numeroPagina,  cadenaNuevaAux);
		}else{
			pdfUtils.agregarTexto(cadenaNuevaAux, pdfDocument, numeroPagina, 237, 453, null);
		}
	}
	
	
	/**
	 * Tercer parrafo seguro
	 * @param pdfDocument
	 * @param numeroPagina
	 * @param cadenaNueva
	 * @throws IOException
	 */
	private void validarCuartoRenglonSeguro(PDDocument pdfDocument, int numeroPagina, String cadenaNueva)
			throws IOException {
		String cadenaNuevaN;
		int posicionEsp;
		String cadenaNuevaAux = cadenaNueva;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(cadenaNuevaAux.length()> 38){
			posicionEsp = contarEspacios(cadenaNuevaAux, NumerosConstants.INT_SEIS, lista);
			cadenaNuevaN = cadenaNuevaAux.substring(NumerosConstants.INT_CERO, posicionEsp);
			pdfUtils.agregarTexto(cadenaNuevaN, pdfDocument, numeroPagina, 237, 446, null);
			cadenaNuevaAux = cadenaNuevaAux.substring(posicionEsp);
			pdfUtils.agregarTexto(cadenaNuevaAux, pdfDocument, numeroPagina, 237, 439, null);
			
		}else{
			pdfUtils.agregarTexto(cadenaNuevaAux, pdfDocument, numeroPagina, 237, 446, null);
		}
	}
	

	/**
	 * Contar espacios
	 * @param cadena
	 * @param posicionPar
	 * @return
	 */
	protected int contarEspacios(String cadenaN, int posicionPar, List<Integer> lista) {
		int cantidadEspaciosN = 0;
		int posicion = 0;
		for(int i=0; i<cadenaN.length(); i++){
			if(cadenaN.charAt(i) == ActivacionConstants.ESPACIO_CHAR){
				cantidadEspaciosN++;
			}
			
			if(cantidadEspaciosN == posicionPar){
				posicion = i;
				lista.add(cantidadEspaciosN);
				break;
			}
		}
		return posicion;
	}
	
	
	
	/**
	 * Agrega coordenadas descripcion derecho
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregarDatosBeneficiario(RespuestaTramite disposicionTotal,  PDDocument pdfDocument, int numeroPagina) throws IOException {
		StringBuilder builder = new StringBuilder();
		if(disposicionTotal.getProcesoNocargado().getBeneficiarios()!=null){
			pdfUtils.agregarTexto(builder.append(disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getNombre()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getNombre()).append(ExpresionesConstants.ESPACIO).append(disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getApellidoPaterno()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getApellidoPaterno()).append(ExpresionesConstants.ESPACIO).append(disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getApellidoMaterno()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getApellidoMaterno()).toString(), pdfDocument, numeroPagina, 27, 70, null);
			pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getCurp()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getCurp(), pdfDocument, numeroPagina, 208, 70, null);
			pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getPorcentaje()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getPorcentaje(), pdfDocument, numeroPagina, 330, 70, null);
			pdfUtils.agregarTexto(disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getRfc()  == null ? ExpresionesConstants.VACIO : disposicionTotal.getProcesoNocargado().getBeneficiarios().get(0).getRfc(), pdfDocument, numeroPagina, 500, 70, null);
		}
	}
	
	
	
	/**
	 *  Obtiene la plantilla
	 * @param resource
	 * @return
	 * @throws IOException
	 */
	protected PDDocument obtenerPlantilla(String resource) throws IOException {
    	return PDDocument.load(new File(resource));
	}

	
	
    

}
