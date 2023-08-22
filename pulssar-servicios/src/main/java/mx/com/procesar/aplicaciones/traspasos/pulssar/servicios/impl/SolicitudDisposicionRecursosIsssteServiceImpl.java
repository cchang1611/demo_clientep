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

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudDisposicionRecursosIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosGeneralesDispIssste;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CodigoUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PdfUtils;
/**
 * Solicitud disposicion recursos issste
 * @author RARREOLA
 *
 */
@Service
public class SolicitudDisposicionRecursosIsssteServiceImpl implements SolicitudDisposicionRecursosIsssteService{

	/**
	 * utilerias codigoUtils
	 */
	@Autowired
	private CodigoUtils codigoUtils;

	
	@Autowired
	private PdfUtils pdfUtils;
	
	
	
	 /**
     * Establece las coordenadas de los campos
     * @param entrada
     * @param pdfDocument
     * @param datosTrabajador
     * @param datosPagoBanco
     * @throws IOException
     */
	public void agregarSolicitudIssste(DatosGeneralesDispIssste entradaParams,PDDocument pdfDocument)  throws IOException {
		int numeroPagina = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("es","MX"));
		StringBuilder builder = new StringBuilder();
		if(!codigoUtils.validarObjeto(entradaParams)) {
		   agregrDatosAfiliado(entradaParams,pdfDocument,numeroPagina);
		   agregarDomicilioParAmbiente(entradaParams,pdfDocument,numeroPagina);
		   agregarDatosDescripcionDerecho(entradaParams, pdfDocument, numeroPagina);
		   agregarDatosBeneficiario(entradaParams,  pdfDocument, numeroPagina);
		   pdfUtils.agregarTexto(builder.append(entradaParams.getApellidoPaterno()  == null ? ExpresionesConstants.VACIO : entradaParams.getApellidoPaterno()).append(ExpresionesConstants.ESPACIO).append(entradaParams.getApellidoMaterno()  == null ? ExpresionesConstants.VACIO : entradaParams.getApellidoMaterno()).append(ExpresionesConstants.ESPACIO).append(entradaParams.getNombre()  == null ? ExpresionesConstants.VACIO : entradaParams.getNombre()).toString(), pdfDocument, 1, 245, 716, null);
		   agregarDatosPlanPrivado(entradaParams, pdfDocument, numeroPagina);
		}
		pdfUtils.agregarTexto(sdf.format(Calendar.getInstance().getTime()), pdfDocument, numeroPagina, 271, 692, null);
	
	}
	
	/**
	 * Agrega coordenadas datos afiliado 
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregrDatosAfiliado(DatosGeneralesDispIssste entradaParams, PDDocument pdfDocument, int numeroPagina) throws IOException {
		pdfUtils.agregarTexto(entradaParams.getNss()  == null ? ExpresionesConstants.VACIO : entradaParams.getNss(), pdfDocument, numeroPagina, 27, 651, null);
		pdfUtils.agregarTexto(entradaParams.getCurp()  == null ? ExpresionesConstants.VACIO : entradaParams.getCurp(), pdfDocument, numeroPagina, 212, 651, null);
		pdfUtils.agregarTexto(entradaParams.getRfc()  == null ? ExpresionesConstants.VACIO : entradaParams.getRfc() , pdfDocument, numeroPagina, 403, 651, null);
		pdfUtils.agregarTexto(entradaParams.getNombre()  == null ? ExpresionesConstants.VACIO : entradaParams.getNombre(), pdfDocument, numeroPagina, 27, 626, null);
		pdfUtils.agregarTexto(entradaParams.getApellidoPaterno()  == null ? ExpresionesConstants.VACIO : entradaParams.getApellidoPaterno(), pdfDocument, numeroPagina, 212, 626, null);
		pdfUtils.agregarTexto(entradaParams.getApellidoMaterno()  == null ? ExpresionesConstants.VACIO : entradaParams.getApellidoMaterno(), pdfDocument, numeroPagina, 403, 626, null);
		pdfUtils.agregarTexto(entradaParams.getFechaNacimiento()  == null ? ExpresionesConstants.VACIO : entradaParams.getFechaNacimiento(), pdfDocument, numeroPagina, 27, 601, null);
	}
	
	
	/**
	 * Agrega coordenadas domicilio par ambiente
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregarDomicilioParAmbiente(DatosGeneralesDispIssste entradaParams, PDDocument pdfDocument, int numeroPagina) throws IOException {
		StringBuilder calle = new StringBuilder();
		StringBuilder calleVal = new StringBuilder();
		StringBuilder numEVal = new StringBuilder();
		String calleV = null;
		String numE = null;
		if(Strings.isNotBlank(entradaParams.getCalle())){
			calleV = calleVal.append(entradaParams.getCalle()).append(ExpresionesConstants.ESPACIO).toString();
		}
		
		if(Strings.isNotBlank(entradaParams.getNumeroExterior())){
			numE = numEVal.append(entradaParams.getNumeroExterior()).append(ExpresionesConstants.ESPACIO).toString();
			
		}
		pdfUtils.agregarTexto(calle.append(entradaParams.getCalle()  == null ? ExpresionesConstants.VACIO : calleV).append(entradaParams.getNumeroExterior()  == null ? ExpresionesConstants.VACIO : numE).append(entradaParams.getNumeroInterior()  == null ? ExpresionesConstants.VACIO : entradaParams.getNumeroInterior()).toString(), pdfDocument, numeroPagina, 27, 553, null);
		setearDatosDom(entradaParams, pdfDocument, numeroPagina);
		setearDatosDomi(entradaParams, pdfDocument, numeroPagina);
		setearDatosDomicilio(entradaParams, pdfDocument, numeroPagina);
	}

	/**
	 * Datos domicilio
	 * @param entradaParams
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	private void setearDatosDomicilio(DatosGeneralesDispIssste entradaParams, PDDocument pdfDocument, int numeroPagina)
			throws IOException {
		pdfUtils.agregarTexto(entradaParams.getCelular() == null ? ExpresionesConstants.VACIO : entradaParams.getCelular(), pdfDocument, numeroPagina, 331, 505, null);
		pdfUtils.agregarTexto(entradaParams.getExtension()  == null ? ExpresionesConstants.VACIO : entradaParams.getExtension(), pdfDocument, numeroPagina, 434, 505, null);
		pdfUtils.agregarTexto(entradaParams.getTelefono()   == null ? ExpresionesConstants.VACIO : entradaParams.getTelefono(), pdfDocument, numeroPagina, 501, 505, null);
	}

	/**
	 * Datos domicilio
	 * 
	 * @param entradaParams
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	private void setearDatosDomi(DatosGeneralesDispIssste entradaParams, PDDocument pdfDocument, int numeroPagina)
			throws IOException {
		pdfUtils.agregarTexto(entradaParams.getPais()  == null ? ExpresionesConstants.VACIO : entradaParams.getPais(), pdfDocument, numeroPagina, 501, 531, null);
		pdfUtils.agregarTexto(entradaParams.getEntidadFederativa()  == null ? ExpresionesConstants.VACIO : entradaParams.getEntidadFederativa(), pdfDocument, numeroPagina, 27, 505, null);
		pdfUtils.agregarTexto(entradaParams.getTelefonoLaboral()  == null ? ExpresionesConstants.VACIO : entradaParams.getTelefonoLaboral() , pdfDocument, numeroPagina, 237, 505, null);
	}

	/**
	 * Datos dom
	 * @param entradaParams
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	private void setearDatosDom(DatosGeneralesDispIssste entradaParams, PDDocument pdfDocument, int numeroPagina)
			throws IOException {
		pdfUtils.agregarTexto(entradaParams.getColonia()  == null ? ExpresionesConstants.VACIO : entradaParams.getColonia(), pdfDocument, numeroPagina, 27, 530, null);
		pdfUtils.agregarTexto(entradaParams.getCodigoPostal()  == null ? ExpresionesConstants.VACIO : entradaParams.getCodigoPostal() , pdfDocument, numeroPagina, 237, 530, null);
		pdfUtils.agregarTexto(entradaParams.getDelegacionMunicipio()  == null ? ExpresionesConstants.VACIO : entradaParams.getDelegacionMunicipio(), pdfDocument, numeroPagina, 330, 530, null);
	}
	
	
	/**
	 * Agrega coordenadas descripcion derecho
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregarDatosDescripcionDerecho(DatosGeneralesDispIssste entradaParams, PDDocument pdfDocument, int numeroPagina) throws IOException {
		validarCadenaRetiro(entradaParams,   pdfDocument, numeroPagina);
		validarCadenaSeguro(entradaParams,   pdfDocument, numeroPagina);
		validarCadenaTipoPencion(entradaParams, pdfDocument, numeroPagina);
		validarCadenaTipoPrestacion(entradaParams, pdfDocument, numeroPagina);
		setearValorClaveRegimen(entradaParams, pdfDocument, numeroPagina);
		pdfUtils.agregarTexto(entradaParams.getNumeroResolucion()  == null ? ExpresionesConstants.VACIO : entradaParams.getNumeroResolucion(), pdfDocument, numeroPagina, 27, 424, null);
		pdfUtils.agregarTexto(entradaParams.getNumeroIssste()  == null ? ExpresionesConstants.VACIO : entradaParams.getNumeroIssste(), pdfDocument, numeroPagina, 27, 399, null);
		pdfUtils.agregarTexto(entradaParams.getSecuenciaPension()  == null ? ExpresionesConstants.VACIO : entradaParams.getSecuenciaPension(), pdfDocument, numeroPagina, 237, 424, null);
		setearDatosDescDerecho(entradaParams, pdfDocument, numeroPagina);
		validarCadenaDocProbatorio( entradaParams, pdfDocument,  numeroPagina);
		String montoRcv = entradaParams.getMontoTotalRcv();
		String montoViv = entradaParams.getMontoTotalViv();
		montoRcv = montoRcv.replace(ExpresionesConstants.SIGNO_PESOS, ExpresionesConstants.VACIO);
		montoViv = montoViv.replace(ExpresionesConstants.SIGNO_PESOS, ExpresionesConstants.VACIO);
		Double sumaLiq = Double.valueOf(montoRcv)+Double.valueOf(montoViv);
		StringBuilder bui = new StringBuilder();
		String sum = bui.append(ExpresionesConstants.SIGNO_PESOS).append(sumaLiq).toString();
		pdfUtils.agregarTexto(sumaLiq.toString()  == null ? ExpresionesConstants.VACIO : sum, pdfDocument, numeroPagina, 434, 374, null);
	
	}

	/**
	 * Desc dercho
	 * @param entradaParams
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	private void setearDatosDescDerecho(DatosGeneralesDispIssste entradaParams, PDDocument pdfDocument,
			int numeroPagina) throws IOException {
		pdfUtils.agregarTexto(entradaParams.getClavePension()  == null ? ExpresionesConstants.VACIO : entradaParams.getClavePension(), pdfDocument, numeroPagina, 237, 399, null);
		pdfUtils.agregarTexto(entradaParams.getFechaInicioPension()  == null ? ExpresionesConstants.VACIO : entradaParams.getFechaInicioPension(), pdfDocument, numeroPagina, 330, 424, null);
		pdfUtils.agregarTexto(entradaParams.getFechaEmisionPension()  == null ? ExpresionesConstants.VACIO : entradaParams.getFechaEmisionPension(), pdfDocument, numeroPagina, 433, 424, null);
		pdfUtils.agregarTexto(entradaParams.getNumeroSemanasCotizadas()  == null ? ExpresionesConstants.VACIO : entradaParams.getNumeroSemanasCotizadas(), pdfDocument, numeroPagina, 27, 375, null);
	}

	/**
	 * Clave regimen
	 * @param entradaParams
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	private void setearValorClaveRegimen(DatosGeneralesDispIssste entradaParams, PDDocument pdfDocument,
			int numeroPagina) throws IOException {
		if(Strings.isNotBlank(entradaParams.getClaveRegimenPlan())){
			pdfUtils.agregarTexto(entradaParams.getClaveRegimenPlan()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveRegimenPlan(), pdfDocument, numeroPagina, 527, 460, null);
		}else{
			pdfUtils.agregarTexto(entradaParams.getClaveRegimen()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveRegimen(), pdfDocument, numeroPagina, 527, 460, null);
			
		}
	}
	/**
	 * Cortar cadena
	 * @param Cadena
	 * @return
	 * @throws IOException 
	 */
	private void validarCadenaTipoPrestacion(DatosGeneralesDispIssste entradaParams,  PDDocument pdfDocument, int numeroPagina) throws IOException{
		StringBuilder tipoPresPrimerParte = new StringBuilder();
		String cadenaNueva;
		int posicionEspacio;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(entradaParams.getDescTipoPrestacion().length()> 20){
			String cadena = entradaParams.getDescTipoPrestacion();
			 posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_TRES, lista);
			 cadenaNueva = cadena.substring(NumerosConstants.INT_CERO, posicionEspacio);
			 pdfUtils.agregarTexto(tipoPresPrimerParte.append(entradaParams.getClaveTipoPrestacion()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveTipoPrestacion()).append(ActivacionConstants.GUION_RESTA).append(entradaParams.getDescTipoPrestacion()  == null ? ExpresionesConstants.VACIO :  cadenaNueva).toString(), pdfDocument, numeroPagina, 435, 460, null);
			cadenaNueva = cadena.substring(posicionEspacio);
			
			if(cadenaNueva.length()> 20){
				posicionEspacio = contarEspacios(cadenaNueva, NumerosConstants.INT_TRES, lista);
				String nuevaDos = cadenaNueva.substring(NumerosConstants.INT_CERO, posicionEspacio);
				pdfUtils.agregarTexto(nuevaDos, pdfDocument, numeroPagina, 435, 452, null);
				cadenaNueva = cadenaNueva.substring(posicionEspacio);
				pdfUtils.agregarTexto(cadenaNueva, pdfDocument, numeroPagina, 435, 446, null); 
			}else{
				pdfUtils.agregarTexto(cadenaNueva, pdfDocument, numeroPagina, 435, 452, null);
			}
		}else{
			pdfUtils.agregarTexto(tipoPresPrimerParte.append(entradaParams.getClaveTipoPrestacion()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveTipoPrestacion()).append(ActivacionConstants.GUION_RESTA).append(entradaParams.getDescTipoPrestacion()  == null ? ExpresionesConstants.VACIO :  entradaParams.getDescTipoPrestacion()).toString(), pdfDocument, numeroPagina, 435, 460, null);
			
			
		}	
	}
	
	
	/**
	 * Cortar cadena
	 * @param Cadena
	 * @return
	 * @throws IOException 
	 */
	private void validarCadenaTipoPencion(DatosGeneralesDispIssste entradaParams,  PDDocument pdfDocument, int numeroPagina) throws IOException{
		StringBuilder tipoPenPrimerParte = new StringBuilder();
		String cadenaNueva;
		int posicionEspacio;
		if(entradaParams.getDescTipoPension().length()> 20){
			String cadena = entradaParams.getDescTipoPension();
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
			 pdfUtils.agregarTexto(tipoPenPrimerParte.append(entradaParams.getClaveTipoPension()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveTipoPension()).append(ActivacionConstants.GUION_RESTA).append(entradaParams.getDescTipoPension()  == null ? ExpresionesConstants.VACIO :  cadenaNueva).toString(), pdfDocument, numeroPagina, 331, 460, null);
			cadenaNueva = cadena.substring(posicionEspacio);
			pdfUtils.agregarTexto(cadenaNueva, pdfDocument, numeroPagina, 331, 453, null);
		}else{
			pdfUtils.agregarTexto(tipoPenPrimerParte.append(entradaParams.getClaveTipoPension()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveTipoPension()).append(ActivacionConstants.GUION_RESTA).append(entradaParams.getDescTipoPension()  == null ? ExpresionesConstants.VACIO :  entradaParams.getDescTipoPension()).toString(), pdfDocument, numeroPagina, 331, 460, null);
			
		}	
	}
	
	
	
	/**
	 * Cortar cadena
	 * @param Cadena
	 * @return
	 * @throws IOException 
	 */
	private void validarCadenaDocProbatorio(DatosGeneralesDispIssste entradaParams,  PDDocument pdfDocument, int numeroPagina) throws IOException{
		String cadenaNueva;
		StringBuilder docPrimerParte = new StringBuilder();
		int posicionEspacio;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(entradaParams.getDescDocProbatorio().length()> 20){
			String cadena = entradaParams.getDescDocProbatorio();
			 posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_TRES, lista);
			 cadenaNueva = cadena.substring(NumerosConstants.INT_CERO, posicionEspacio);
			 pdfUtils.agregarTexto(docPrimerParte.append(NumerosConstants.C_CERO.equals(entradaParams.getClaveDocProbatorio()) ? ExpresionesConstants.VACIO : entradaParams.getClaveDocProbatorio()).append(NumerosConstants.C_CERO.equals(entradaParams.getClaveDocProbatorio()) ? ExpresionesConstants.VACIO : ActivacionConstants.GUION_RESTA).append(NumerosConstants.C_CERO.equals(entradaParams.getClaveDocProbatorio()) ? ExpresionesConstants.VACIO  : cadenaNueva).toString(), pdfDocument, numeroPagina, 331, 375, NumerosConstants.C_CERO);
			 cadenaNueva = cadena.substring(posicionEspacio);
			pdfUtils.agregarTexto(cadenaNueva, pdfDocument, numeroPagina, 331, 368, null);
		}else{
			pdfUtils.agregarTexto(docPrimerParte.append(NumerosConstants.C_CERO.equals(entradaParams.getClaveDocProbatorio()) ? ExpresionesConstants.VACIO : entradaParams.getClaveDocProbatorio()).append(NumerosConstants.C_CERO.equals(entradaParams.getClaveDocProbatorio()) ? ExpresionesConstants.VACIO : ActivacionConstants.GUION_RESTA).append(NumerosConstants.C_CERO.equals(entradaParams.getClaveDocProbatorio()) ? ExpresionesConstants.VACIO :  entradaParams.getDescDocProbatorio()).toString(), pdfDocument, numeroPagina, 331, 375, NumerosConstants.C_CERO);
			
			
		}	
	}
	
	/**
	 * Cortar cadena
	 * @param Cadena
	 * @return
	 * @throws IOException 
	 */
	private void validarCadenaRetiro(DatosGeneralesDispIssste entradaParams,  PDDocument pdfDocument, int numeroPagina) throws IOException{
		StringBuilder retiroPrimerParte = new StringBuilder();
		String cadenaNueva;
		int posicionEspacio;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(entradaParams.getDescRetiro().length()> 55){
			String cadena = entradaParams.getDescRetiro();
			 posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_SIETE, lista);
			 cadenaNueva = cadena.substring(NumerosConstants.INT_CERO, posicionEspacio);
			 pdfUtils.agregarTexto(retiroPrimerParte.append(entradaParams.getClaveRetiro()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveRetiro()).append(ActivacionConstants.GUION_RESTA).append(entradaParams.getDescRetiro()  == null ? ExpresionesConstants.VACIO :  cadenaNueva).toString(), pdfDocument, numeroPagina, 27, 460, null);
			 cadenaNueva = cadena.substring(posicionEspacio);
			 validarTercerRenglonRetiro(pdfDocument, numeroPagina, cadenaNueva);
		}else{
			pdfUtils.agregarTexto(retiroPrimerParte.append(entradaParams.getClaveRetiro()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveRetiro()).append(ActivacionConstants.GUION_RESTA).append(entradaParams.getDescRetiro()  == null ? ExpresionesConstants.VACIO :  entradaParams.getDescRetiro() ).toString(), pdfDocument, numeroPagina, 27, 460, null);
			
		}	
	}

	/**
	 * Retiro
	 * @param pdfDocument
	 * @param numeroPagina
	 * @param cadenaNueva
	 * @throws IOException
	 */
	private void validarTercerRenglonRetiro(PDDocument pdfDocument, int numeroPagina, String cadenaNueva)
			throws IOException {
		int posicionEspacio;
		String cadenaNuevaAux = cadenaNueva;
		String cadenaNuevaDos;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(cadenaNuevaAux.length()> 55){
				posicionEspacio = contarEspacios(cadenaNuevaAux, NumerosConstants.INT_OCHO, lista);
				cadenaNuevaDos = cadenaNuevaAux.substring(NumerosConstants.INT_CERO, posicionEspacio);
				pdfUtils.agregarTexto(cadenaNuevaDos, pdfDocument, numeroPagina, 27, 453, null);
				cadenaNuevaAux = cadenaNuevaAux.substring(posicionEspacio);
				validarCuartoRenglonRetiro(pdfDocument, numeroPagina, cadenaNuevaAux);
			}else{
				pdfUtils.agregarTexto(cadenaNuevaAux, pdfDocument, numeroPagina, 27, 453, null);
			}
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
		String cadenaNuevaDos;
		String cadNuevaAux = cadenaNueva;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(cadNuevaAux.length()> 55){
				posicionEspacio = contarEspacios(cadNuevaAux, NumerosConstants.INT_OCHO, lista);
				cadenaNuevaDos = cadNuevaAux.substring(NumerosConstants.INT_CERO, posicionEspacio);
				pdfUtils.agregarTexto(cadenaNuevaDos, pdfDocument, numeroPagina, 27, 447, null);
				cadNuevaAux = cadNuevaAux.substring(posicionEspacio);
				pdfUtils.agregarTexto(cadNuevaAux, pdfDocument, numeroPagina, 27, 441, null);
			}else{
				pdfUtils.agregarTexto(cadNuevaAux, pdfDocument, numeroPagina, 27, 447, null);
			}
	}
	
	
	/**
	 * Cortar cadena
	 * @param Cadena
	 * @return
	 * @throws IOException 
	 */
	private void validarCadenaSeguro(DatosGeneralesDispIssste entradaParams,  PDDocument pdfDocument, int numeroPagina) throws IOException{
		StringBuilder seguroPrimerParte = new StringBuilder();
		String cadenaNueva;
		int posicionEspacio;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(entradaParams.getDescSeguro().length()> 24){
			 String cadena = entradaParams.getDescSeguro();	
			 posicionEspacio = contarEspacios(cadena, NumerosConstants.INT_TRES, lista);
			 cadenaNueva = cadena.substring(NumerosConstants.INT_CERO, posicionEspacio);
			 pdfUtils.agregarTexto(seguroPrimerParte.append(entradaParams.getClaveSeguro()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveSeguro()).append(ActivacionConstants.GUION_RESTA).append(entradaParams.getDescSeguro()  == null ? ExpresionesConstants.VACIO :  cadenaNueva).toString(), pdfDocument, numeroPagina, 237, 460, null);
			  cadenaNueva = cadena.substring(posicionEspacio);
			  validarTercerRenglonSeguro(pdfDocument, numeroPagina, cadenaNueva);
		}else{
			pdfUtils.agregarTexto(seguroPrimerParte.append(entradaParams.getClaveSeguro()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveSeguro()).append(ActivacionConstants.GUION_RESTA).append(entradaParams.getDescSeguro()  == null ? ExpresionesConstants.VACIO :  entradaParams.getDescSeguro()).toString(), pdfDocument, numeroPagina, 237, 460, null);
			
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
		String cadenaNuevaDos;
		int posicionEspacio;
		String cadenaNueAux = cadenaNueva;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(cadenaNueAux.length()> 30){
			posicionEspacio = contarEspacios(cadenaNueAux, NumerosConstants.INT_CUATRO, lista);
			cadenaNuevaDos = cadenaNueAux.substring(NumerosConstants.INT_CERO, posicionEspacio);
			pdfUtils.agregarTexto(cadenaNuevaDos, pdfDocument, numeroPagina, 237, 453, null);
			cadenaNueAux = cadenaNueAux.substring(posicionEspacio);
			validarCuartoRenglonSeguro(pdfDocument, numeroPagina,  cadenaNueAux);
		}else{
			pdfUtils.agregarTexto(cadenaNueAux, pdfDocument, numeroPagina, 237, 453, null);
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
		String cadenaNuevaDos;
		int posicionEspacio;
		String cadenaNuevaA = cadenaNueva;
		List<Integer> lista = new ArrayList<>();
		lista.add(NumerosConstants.INT_CERO);
		if(cadenaNuevaA.length()> 38){
			posicionEspacio = contarEspacios(cadenaNuevaA, NumerosConstants.INT_SEIS, lista);
		    cadenaNuevaDos = cadenaNuevaA.substring(NumerosConstants.INT_CERO, posicionEspacio);
			pdfUtils.agregarTexto(cadenaNuevaDos, pdfDocument, numeroPagina, 237, 446, null);
			cadenaNuevaA = cadenaNuevaA.substring(posicionEspacio);
			pdfUtils.agregarTexto(cadenaNuevaA, pdfDocument, numeroPagina, 237, 439, null);
			
		}else{
			pdfUtils.agregarTexto(cadenaNuevaA, pdfDocument, numeroPagina, 237, 446, null);
		}
	}
	

	/**
	 * Contar espacios
	 * @param cadena
	 * @param posicionPar
	 * @return
	 */
	protected int contarEspacios(String cadena, int posicionPar, List<Integer> lista) {
		int cantidadEspacios = 0;
		int posicion = 0;
		for(int j=0; j<cadena.length(); j++){
			if(cadena.charAt(j) == ActivacionConstants.ESPACIO_CHAR){
				cantidadEspacios++;
			}
			
			if(cantidadEspacios == posicionPar){
				posicion = j;
				lista.add(cantidadEspacios);
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
	protected void agregarDatosBeneficiario(DatosGeneralesDispIssste entradaParams, PDDocument pdfDocument, int numeroPagina) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		if(entradaParams.getBeneficiariosDatos()!=null){
			pdfUtils.agregarTexto(builder.append(entradaParams.getBeneficiariosDatos().get(0).getNombre()  == null ? ExpresionesConstants.VACIO : entradaParams.getBeneficiariosDatos().get(0).getNombre()).append(ExpresionesConstants.ESPACIO).append(entradaParams.getBeneficiariosDatos().get(0).getApellidoPaterno()  == null ? ExpresionesConstants.VACIO : entradaParams.getBeneficiariosDatos().get(0).getApellidoPaterno()).append(ExpresionesConstants.ESPACIO).append(entradaParams.getBeneficiariosDatos().get(0).getApellidoMaterno()  == null ? ExpresionesConstants.VACIO : entradaParams.getBeneficiariosDatos().get(0).getApellidoMaterno()).toString(), pdfDocument, numeroPagina, 27, 80, null);
			pdfUtils.agregarTexto(entradaParams.getBeneficiariosDatos().get(0).getCurp()  == null ? ExpresionesConstants.VACIO : entradaParams.getBeneficiariosDatos().get(0).getCurp(), pdfDocument, numeroPagina, 208, 80, null);
			pdfUtils.agregarTexto(entradaParams.getBeneficiariosDatos().get(0).getPorcentaje()  == null ? ExpresionesConstants.VACIO : entradaParams.getBeneficiariosDatos().get(0).getPorcentaje(), pdfDocument, numeroPagina, 330, 80, null);
			pdfUtils.agregarTexto(entradaParams.getBeneficiariosDatos().get(0).getRfc()  == null ? ExpresionesConstants.VACIO : entradaParams.getBeneficiariosDatos().get(0).getRfc(), pdfDocument, numeroPagina, 490, 80, null);
		}
	}
	
	
	/**
	 * Agrega coordenadas descripcion derecho
	 * @param datosTrabajador
	 * @param pdfDocument
	 * @param numeroPagina
	 * @throws IOException
	 */
	protected void agregarDatosPlanPrivado(DatosGeneralesDispIssste entradaParams, PDDocument pdfDocument, int numeroPagina) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		if(Strings.isNotBlank(entradaParams.getClaveRegimenPlan())){
			pdfUtils.agregarTexto(entradaParams.getClaveRegimenPlan()  == null ? ExpresionesConstants.VACIO : entradaParams.getClaveRegimenPlan(), pdfDocument, numeroPagina, 140, 226, null);
			if(Strings.isNotBlank(entradaParams.getNumeroPlanPensiones()) && Strings.isNotBlank(entradaParams.getActuario())){
				pdfUtils.agregarTexto(builder.append(entradaParams.getNumeroPlanPensiones()).append(ActivacionConstants.GUION_RESTA).append(entradaParams.getActuario()).toString(), pdfDocument, numeroPagina, 330, 233, null);
			}else{
				pdfUtils.agregarTexto(entradaParams.getNumeroPlanPensiones()  == null ? ExpresionesConstants.VACIO : entradaParams.getNumeroPlanPensiones(), pdfDocument, numeroPagina, 330, 233, null);
				pdfUtils.agregarTexto(entradaParams.getActuario()  == null ? ExpresionesConstants.VACIO : entradaParams.getActuario(), pdfDocument, numeroPagina, 330, 233, null);

			}
			
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
