package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.NodeList;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.CaracteresConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.FormatoConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FlujosEntrada;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CodigoUtils;

/**
 * Implementacion para la creacion de codigos, folios y contrasenias
 * del servicio de administracion de usuarios
 * 
 * @author DBARBOSA
 */
@Component
public class CodigoUtilsImpl implements CodigoUtils {
	
	/**
	 * Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CodigoUtilsImpl.class);
	
	/**
	 * Inyeccion de utileria
	 */
	@Autowired
	private CadenasUtils utileriaCadena;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generarFolioServicio() {
		SimpleDateFormat formato = new SimpleDateFormat(FormatoConstants.FORMATO_FOLIO_SERVICIO, new Locale(FormatoConstants.LOCALE_ES));
		String folio = formato.format(new Date());
		
		int inicio = new Random().nextInt(NumerosConstants.INT_QUINCE);
		Integer anioFolio = Integer.valueOf(folio.substring(inicio, inicio + NumerosConstants.INT_DOS));
		folio = utileriaCadena.obtenerCadenaConcatenada(true, String.valueOf(anioFolio), folio.substring(NumerosConstants.INT_DOS));
		folio = agregarDigitosAdicionales(folio, NumerosConstants.INT_QUINCE);
		
		String digitoInicial = String.valueOf(NumerosConstants.INT_UNO);
		int curpInicio = new Random().nextInt(NumerosConstants.INT_CINCO) + NumerosConstants.INT_CUATRO;
		String foliofinal = this.reconstruirSalidaFolioCodigo(utileriaCadena.obtenerCadenaConcatenada(true, folio, this.generarCodigoActivacion(), String.valueOf(curpInicio)), false);

		return utileriaCadena.obtenerCadenaConcatenada(true, digitoInicial, foliofinal);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generarCodigoActivacion() {
		String codigo;
		do {
			codigo = this.obtenerCodigoActivacion();
		} while (NumerosConstants.INT_CUATRO != codigo.length() || codigo.charAt(NumerosConstants.INT_CERO) == CaracteresConstants.CHAR_CERO);
		
		return codigo;
	}
	
	/**
	 * Obtiene un codigo de activacion
	 * 
	 * @return
	 */
	private String obtenerCodigoActivacion() {
		SimpleDateFormat formatoCodigo = new SimpleDateFormat(FormatoConstants.FORMATO_CODIGO_ACTIVACION, new Locale(FormatoConstants.LOCALE_ES));
		String codigo = formatoCodigo.format(new Date());
		
		Integer anio = Integer.valueOf(codigo.substring(NumerosConstants.INT_CERO, NumerosConstants.INT_DOS));
		anio = anio - Integer.valueOf(NumerosConstants.INT_CINCO + new Random().nextInt(NumerosConstants.INT_SEIS));
		
		StringBuilder cadenaBuilder = new StringBuilder();
		cadenaBuilder.append(anio);
		cadenaBuilder.append(codigo.substring(NumerosConstants.INT_DOS));
		codigo = cadenaBuilder.toString();
		codigo = this.agregarDigitosAdicionales(codigo, NumerosConstants.INT_SEIS);
		return this.reconstruirSalidaFolioCodigo(codigo, true);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String generarContrasenia() {
		StringBuilder respuesta = new StringBuilder();
		char[] posicion = CaracteresConstants.ARREGLO_CARACTERES;
		
		Random auxiliarRandom = new Random();
		for (int i = NumerosConstants.INT_CERO; i < NumerosConstants.INT_OCHO; i++) {
			int posicionCaracter = auxiliarRandom.nextInt(NumerosConstants.INT_DIECINUEVE);
			respuesta.append(posicion[posicionCaracter]);
		}
		return respuesta.toString();
	}
	
	/**
	 * Metodo encargado de agregar digitos adicionales a la cadena de generacion
	 * 
	 * @param codigo
	 * @param valorRandom
	 * @return
	 */
	private String agregarDigitosAdicionales(String codigo, Integer valorRandom) {
		StringBuilder cd = new StringBuilder(codigo);
		StringBuilder sbExp = new StringBuilder();
		Random r = new Random();
		
		Double dExp = Math.PI * Math.sqrt(Math.E);
		String strExp = dExp.toString().substring((int) Math.rint(Math.PI));	
		sbExp = sbExp.append(strExp);
		dExp = Math.sqrt(Math.PI / Math.E) / Math.sqrt(Math.E);
		sbExp = sbExp.append(String.valueOf(dExp.intValue()));
		
		int iSum = r.nextInt(sbExp.length()-NumerosConstants.INT_DOS);
		cd.append(sbExp.substring(iSum, iSum + NumerosConstants.INT_DOS));
		
		return cd.toString();
	}
	
	/**
	 * Metodo encargado de reconstruir el folio o codigo a enviar en correo o sms
	 * 
	 * @param cadena
	 * @param isCodigo
	 * @return
	 */
	private String reconstruirSalidaFolioCodigo(String cadena, boolean isCodigo) {
		StringBuilder respuesta = new StringBuilder();
		int limite = NumerosConstants.INT_DIECINUEVE;
		int[] posicion = NumerosConstants.ARREGLO_FOLIO;
		
		if(isCodigo) {
			limite = NumerosConstants.INT_CUATRO;
			posicion = NumerosConstants.ARREGLO_CODIGO;
		}
		
		for (int i = NumerosConstants.INT_CERO; i < limite; i++) {
			respuesta.append(cadena.charAt(posicion[i]));
		}
		return respuesta.toString();
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
    public String generarCadenaError(NodeList nl) {
            
            DOMSource source = new DOMSource();
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            
            try {
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            for (int i = 0; i < nl.getLength(); i++) {
                    source.setNode(nl.item(i));
                    
                           transformer.transform(source, result);
                    
            }
            
            } catch (TransformerException tex) {
                    throw new GenericException("ERROR AL LEER ERROR OSB: ", tex);
            }
            return writer.toString();
    }
	
	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara (non-Javadoc)
	 * 
	 * @see
	 * mx.com.procesar.servicios.traspasos.reprocesamientoenrolamiento.servicios
	 * .utilerias.ReprocesamientoEnrolamientoUtils#isEmpty(java.lang.Object)
	 */
	@Override
	public boolean esVacio(Object valor) {

		boolean esVacio = valor == null;
		if (!esVacio) {
			if (valor instanceof String) {
				String cadena = (String) valor;
				esVacio = cadena.trim().isEmpty();
			} else if (valor instanceof Number) {
				Number numero = (Number) valor;
				esVacio = numero.equals(0);
			} else if (valor instanceof Collection<?>) {
				Collection<?> collection = (Collection<?>) valor;
				esVacio = collection.isEmpty();
			} 
		}

		return esVacio;
	}
	
	@Override
	public String obtenerCadena(Object cadena) {
		Object valor = cadena;
		if(this.validarObjeto(valor)) {
			valor = "";
		} else {
			valor = cadena;
		}
		return String.valueOf(valor);
	}
	
	@Override
	public boolean validarObjeto(Object objeto) {
		boolean isEmpty = objeto == null;
		if (!isEmpty) {
			if (objeto instanceof String) {
				String string = (String) objeto;
				isEmpty = string.trim().isEmpty();
			} else if (objeto instanceof Number) {
				Number number = (Number) objeto;
				isEmpty = number.equals(0);
			} else if (objeto instanceof Collection<?>) {
				Collection<?> collection = (Collection<?>) objeto;
				isEmpty = collection.isEmpty();
			}
		}
		return isEmpty;
	}
	
	@Override
	public String generaXmlEntrada(FlujosEntrada entrada){
		JAXBContext context;
		StringWriter sw = new StringWriter();
		String resultado = null;
		try {
			context = JAXBContext.newInstance(FlujosEntrada.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			QName qName= new QName("comunesPulssar-exposicion/flujos/obtieneFlujo","ENTRADA");
			JAXBElement<FlujosEntrada> entradaOk = new JAXBElement<>(qName,FlujosEntrada.class,entrada);
			marshaller.marshal(entradaOk, sw);
			resultado = sw.toString();
		} catch (JAXBException e) {
			logger.error(new StringBuilder().append("ERROR").append(e).toString());		
		}
		logger.error(new StringBuilder().append("ENTRADA XML").append(resultado).toString());
		return resultado;
	}
}