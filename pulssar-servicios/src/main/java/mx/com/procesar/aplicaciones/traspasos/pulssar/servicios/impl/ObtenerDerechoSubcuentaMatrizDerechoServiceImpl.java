package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DisposicionTotalIsssteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerDerechoSubcuentaMatrizDerechoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ActivacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.GenericErrorEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.GenericException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosCalculosMontos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DerechoSubcuenta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FactorConversion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Marca;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl.JsonUtilsImpl;
/**
 *  Servicio que implementa DerechoSubcuentaMatrizDerecho
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Mar 2, 2021
 */
@Service
public class ObtenerDerechoSubcuentaMatrizDerechoServiceImpl implements ObtenerDerechoSubcuentaMatrizDerechoService{
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ObtenerDerechoSubcuentaMatrizDerechoServiceImpl.class);
	
	
	/**
	 * URI uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;

	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador; 

	/**
	 * Inyeccion disposicionService
	 */
	@Autowired
	private DisposicionTotalIsssteService  disposicionService;
	
	/**
	 * dependencia clienteServicio
	 */
	@Autowired
	private RestTemplate clienteServicio;
	
		
	/**
	 * fechaUtils
	 */
	@Autowired
	private FechaUtils fechaUtils;
			
	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerDerechoSubcuentaMatrizDerechoService#obtenerDerechoSubcuentaPorIdMatrizDerecho(java.lang.Long)
	 */
	@Override
	public List<DerechoSubcuenta> obtenerDerechoSubcuentaPorIdMatrizDerecho(Long idMatrizDerecho) {
		List<DerechoSubcuenta> respuestaCta = null;
		StringBuilder url = new StringBuilder();
		try {
		
		url.append(uriComunes).append(ActivacionConstants.DERECHO_SUBCUENTA).append(ActivacionConstants.DIAGONAL).append(ActivacionConstants.DERECHO_SUBCUENTA_ID_MATRIZ).append(ActivacionConstants.DIAGONAL).append(idMatrizDerecho).toString();
		logger.info("Url obtenerDerechoSubcuentaPorIdMatrizDerecho:{}",url);
		String respuesta=  clienteServicio.getForObject(url.toString(),String.class);
		JsonUtilsImpl<DerechoSubcuenta> json = new JsonUtilsImpl<>();
		respuestaCta = json.parseJsonToObjectList(respuesta, DerechoSubcuenta.class);
		}catch(Exception e) {
			logger.error("Se presento un problema en el servicio de consultar los datos de subcuenta por id matriz de derecho", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
			
		}
		
		return respuestaCta;
		
	}


	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerDerechoSubcuentaMatrizDerechoService#consultarMarcasViviendaImss(java.util.List)
	 */
	@Override
	public Marca consultarMarcasViviendaImss(Long idProcesar) {
		Marca respuestaMarcas = null;
		StringBuilder uri = new StringBuilder();
		
		try {
			
		     String url= uri.append(uriComunes).append(ActivacionConstants.MARCAS_VIVIENDA_IMSS).append(ActivacionConstants.DIAGONAL).append(ActivacionConstants.ESTATUS).append(ActivacionConstants.DIAGONAL).append(idProcesar).toString();
		     logger.info("Url consultarMarcasViviendaImss:{}",url);
		     respuestaMarcas= clienteServicio.getForObject(url, Marca.class);

		}catch(Exception e) {
			logger.error("Se presento un problema en el servicio de consultarMarcasViviendaImss", e);
			throw new GenericException(GenericErrorEnum.EXCEPTION_GENERICA);
			
		}
		return respuestaMarcas;
	}
	
	
	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerDerechoSubcuentaMatrizDerechoService#obtenerSubCuentasSaldosImssRcv(java.util.List, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos, mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoNoCargado)
	 */
	@Override
	public List<DatosCalculosMontos> obtenerSubCuentasSaldosImssRcv(List<DerechoSubcuenta> listaSubCuentas,
			DatosSaldos saldos) {
		List<DatosCalculosMontos> listaRcv = null;
		if(!utileriaValidador.isEmpty(listaSubCuentas)) {
		listaRcv = new ArrayList<>();
		    for (DerechoSubcuenta cuentas: listaSubCuentas) {
				  if(ActivacionConstants.SUBCUENTAS_IMSS_RCV.contains(cuentas.getCvSubCuenta().getClave())) {
					   relacionarSaldosSubcuentasRcv(cuentas,saldos,listaRcv);
					 
				  }
			}
		  		 }
	  return listaRcv;
     }

	 /**
	  *  Metodo :Muestra las Subcuentas asociadas
	  *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
	  *  @param cuentas
	  *  @param saldos
	  *  @param listaRcv
	  */
	 private void relacionarSaldosSubcuentasRcv(DerechoSubcuenta cuentas, 
			DatosSaldos saldos,List<DatosCalculosMontos> listaRcv) {
		    DatosCalculosMontos montosRcv;
						
				 if(ActivacionConstants.SUBCUENTA_IMSS_RCV_01 .equals(cuentas.getCvSubCuenta().getClave()) ) {
					 montosRcv= new DatosCalculosMontos();
					 montosRcv.setClaveSubcuenta(cuentas.getCvSubCuenta().getClave());
					 montosRcv.setDescripcionSubcuenta(cuentas.getCvSubCuenta().getDescripcion());
					 montosRcv.setMonto(saldos.getSaldoRetiro97());
					 montosRcv.setAcciones(ExpresionesConstants.VACIO);
					 montosRcv.setPrecioAccion(ExpresionesConstants.VACIO);
					 montosRcv.setFechaValor(ExpresionesConstants.VACIO);
				    	listaRcv.add(montosRcv);
				    	
				    } 
				 if(ActivacionConstants.SUBCUENTA_IMSS_RCV_02.equals(cuentas.getCvSubCuenta().getClave()) ) {
					 montosRcv	= new DatosCalculosMontos();
					 montosRcv.setClaveSubcuenta(cuentas.getCvSubCuenta().getClave());
					 montosRcv.setDescripcionSubcuenta(cuentas.getCvSubCuenta().getDescripcion());
					 montosRcv.setMonto(saldos.getSaldoCesantiaVejez());
					 montosRcv.setAcciones(ExpresionesConstants.VACIO);
					 montosRcv.setPrecioAccion(ExpresionesConstants.VACIO);
					 montosRcv.setFechaValor(ExpresionesConstants.VACIO);
				    	listaRcv.add(montosRcv);
				    	
				    }
				 if(ActivacionConstants.SUBCUENTA_IMSS_RCV_03.equals(cuentas.getCvSubCuenta().getClave()) ) {
					 montosRcv	= new DatosCalculosMontos();
					 montosRcv.setClaveSubcuenta(cuentas.getCvSubCuenta().getClave());
					 montosRcv.setDescripcionSubcuenta(cuentas.getCvSubCuenta().getDescripcion());
					 montosRcv.setMonto(saldos.getSaldoCuotaSocial() );
					 montosRcv.setAcciones(ExpresionesConstants.VACIO);
					 montosRcv.setPrecioAccion(ExpresionesConstants.VACIO); 
					 montosRcv.setFechaValor(ExpresionesConstants.VACIO);
				    	listaRcv.add(montosRcv);
				    	
				    }
				 if(ActivacionConstants.SUBCUENTA_IMSS_RCV_08.equals(cuentas.getCvSubCuenta().getClave()) ) {
					 montosRcv	= new DatosCalculosMontos();
					 montosRcv.setClaveSubcuenta(cuentas.getCvSubCuenta().getClave());
					 montosRcv.setDescripcionSubcuenta(cuentas.getCvSubCuenta().getDescripcion());
					 montosRcv.setMonto(saldos.getSaldoRetiro92I() );
					 montosRcv.setAcciones(ExpresionesConstants.VACIO);
					 montosRcv.setPrecioAccion(ExpresionesConstants.VACIO);
					 montosRcv.setFechaValor(ExpresionesConstants.VACIO);
				    	listaRcv.add(montosRcv);
				    	
				    }
				
			
			
	}

/*
 * La documentación de este método se encuentra en la clase o interface que
 * lo declara  (non-Javadoc)
 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ObtenerDerechoSubcuentaMatrizDerechoService#obtenerSubCuentasSaldosImssViv(java.util.List, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos, mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoNoCargado)
 */
	@Override
	public List<DatosCalculosMontos> obtenerSubCuentasSaldosImssViv(List<DerechoSubcuenta> listaSubCuentas,
			DatosSaldos saldos) {
		    List<DatosCalculosMontos> listaVivienda = null;
		StringBuilder builder = new StringBuilder();
		  if(!utileriaValidador.isEmpty(listaSubCuentas)) {
			    builder.append(NumerosConstants.INT_CERO.toString());
				listaVivienda = new ArrayList<>();
			   for (DerechoSubcuenta derechoSubcuenta : listaSubCuentas) {
				   if(ActivacionConstants.SUBCUENTAS_IMSS_VIVIENDA.contains(derechoSubcuenta.getCvSubCuenta().getClave())) {
			            builder = relacionarSaldosSubcuentasImssVivienda(derechoSubcuenta,saldos,listaVivienda,  builder);
				     }
			   }
			   if(!utileriaValidador.validarListaVacia(listaVivienda)){
				   listaVivienda.get(0).setMontoTotalSuma(builder.toString());
				}
		
		  }     
		return listaVivienda;
		
	}


    /**
     *  Metodo: Que relaciona los saldos con las subcuentas
     *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
     *  @param derechoSubcuenta
     *  @param saldos
     *  @param listaVivienda
     *  @return
     */
	private StringBuilder relacionarSaldosSubcuentasImssVivienda(DerechoSubcuenta derechoSubcuenta,
			 DatosSaldos saldos, List<DatosCalculosMontos> listaVivienda, StringBuilder builder) {
		    StringBuilder builderAux = builder;
		    List<FactorConversion> factorConversion = disposicionService.obtenerFactorConversion(ActivacionConstants.VALOR_AIVS_VIVIENDA, "sief", NumerosConstants.C_DOS);
		   if(ActivacionConstants.SUBCUENTA_IMSS_VIV_04.equals(derechoSubcuenta.getCvSubCuenta().getClave())) {
		   DatosCalculosMontos montosViv = new DatosCalculosMontos();
			   montosViv.setClaveSubcuenta(derechoSubcuenta.getCvSubCuenta().getClave());
			   montosViv.setDescripcionSubcuenta(derechoSubcuenta.getCvSubCuenta().getDescripcion());
			   montosViv.setMonto(saldos.getSaldoVivienda97());
			   validarListaPrecioAccionViviendaImss(montosViv,factorConversion);
			   builderAux = sumarMontoTotal(saldos.getSaldoVivienda97(),  builderAux, montosViv.getSinPrecioAccion());
			   listaVivienda.add(montosViv); 
		   }
		
           if(ActivacionConstants.SUBCUENTA_IMSS_VIV_09.equals(derechoSubcuenta.getCvSubCuenta().getClave())) {
        	DatosCalculosMontos montosViv = new DatosCalculosMontos();
        	   montosViv.setClaveSubcuenta(derechoSubcuenta.getCvSubCuenta().getClave());
        	   montosViv.setDescripcionSubcuenta(derechoSubcuenta.getCvSubCuenta().getDescripcion());
        	   montosViv.setMonto(saldos.getSaldoVivienda92());
        	   validarListaPrecioAccionViviendaImss(montosViv,factorConversion);
        	   builderAux = sumarMontoTotal(saldos.getSaldoVivienda92(),  builderAux, montosViv.getSinPrecioAccion());
        	   listaVivienda.add(montosViv);   
		   }
           
           if(ActivacionConstants.SUBCUENTA_IMSS_VIV_07.equals(derechoSubcuenta.getCvSubCuenta().getClave())) {
           DatosCalculosMontos montosViv = new DatosCalculosMontos();
        	   montosViv.setClaveSubcuenta(derechoSubcuenta.getCvSubCuenta().getClave());
        	   montosViv.setDescripcionSubcuenta(derechoSubcuenta.getCvSubCuenta().getDescripcion());
        	   montosViv.setMonto(saldos.getSaldoVivienda72());
        	   validarListaPrecioAccionViviendaImss(montosViv,factorConversion);
        	   builderAux = sumarMontoTotal(saldos.getSaldoVivienda72(),  builderAux, montosViv.getSinPrecioAccion());
        	   listaVivienda.add(montosViv);   
		   }
           
           
       return builderAux;
		
	}
	
	
	
	/**
	 * Monto total rcv
	 * @param monto
	 * @return
	 */
	protected StringBuilder sumarMontoTotal(String monto, StringBuilder buider, String precioAccion){
		StringBuilder buiderAux = buider;
		if(!ActivacionConstants.SIN_PRECIO_ACCION.equals(precioAccion)){
			if(buiderAux.toString().equals(NumerosConstants.INT_CERO.toString())){
				buiderAux = new StringBuilder();
				buiderAux.append(monto);
			}else{
				Double montoNuevo = Double.valueOf(monto) + Double.valueOf(buiderAux.toString());
				 BigDecimal bd = new BigDecimal(montoNuevo).setScale(NumerosConstants.INT_DOS, RoundingMode.HALF_UP);
				 montoNuevo = bd.doubleValue();
				 buiderAux = new StringBuilder();
				 buiderAux.append(montoNuevo.toString());
			}
		
		}
		
		return buiderAux;
		
	}

    /**
     *  Metodo: Valida Precio Accion Vienda 
     *  @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
     *  @param montosViv
     *  @param factorConversion
     */
	private void validarListaPrecioAccionViviendaImss(DatosCalculosMontos montosViv, List<FactorConversion> factorConversion) {
		if(!utileriaValidador.validarListaVacia(factorConversion)) {
			montosViv.setFechaValor(fechaUtils.convertirFechaACadena(factorConversion.get(0).getFechaValorFactor(), ActivacionConstants.DDMMYYYY));
			montosViv.setPrecioAccion(factorConversion.get(0).getNuValorFactor().toString()== null? null:factorConversion.get(0).getNuValorFactor().toString());
			montosViv.setAcciones(calcularAcciones(montosViv.getMonto(),montosViv.getPrecioAccion(),montosViv));
		}else {
			montosViv.setSinPrecioAccion(ActivacionConstants.SIN_PRECIO_ACCION);
			montosViv.setAcciones(ExpresionesConstants.VACIO);
			montosViv.setFechaValor(ExpresionesConstants.VACIO);	
			
		}
	}
	
	/**
	 * Calcular acciones
	 * @param monto
	 * @param precioAccion
	 * @return
	 */
	protected String calcularAcciones(String monto, String precioAccion, DatosCalculosMontos objetoMontos){
		Double acciones;
		String accionCad= null;
		if(Strings.isNotBlank(precioAccion)){
			Double montoD = Double.valueOf(monto); 
		    Double precioA = Double.valueOf(precioAccion); 
		    acciones = montoD / precioA;
		    if(acciones.toString().indexOf(ActivacionConstants.PUNTO_CHAR) >= 0){
		    	 BigDecimal bd = new BigDecimal(acciones).setScale(2, RoundingMode.HALF_UP);
				 acciones = bd.doubleValue();
		    	accionCad =  extraerAcciones(acciones);
		    	 
		    }else{
		    	 if(acciones.toString().length() > 8){
		    		 accionCad = acciones.toString().substring(0, 8);
				 }
		    }
		  
		}else{
			objetoMontos.setSinPrecioAccion(ActivacionConstants.SIN_PRECIO_ACCION);
			objetoMontos.setAcciones(ExpresionesConstants.VACIO);
		}
		
		return accionCad;
	}
	
	/**
	 * Extraer acciones
	 * @param acciones
	 */
	private String extraerAcciones(Double acciones) {
		StringBuilder buil = new StringBuilder();
		String acc = acciones.toString();
		String[] parts = acc.split(ActivacionConstants.PUNTO_DIAGONAL);
		 String part1 = parts[0];
		 String part2 =  parts[1];
		 if(part1.length() > NumerosConstants.INT_OCHO){
			 part1 = part1.substring(NumerosConstants.INT_CERO, NumerosConstants.INT_OCHO);
		 }
		 
		 if(part2.length() > NumerosConstants.INT_SEIS){
			 part2 = part2.substring(NumerosConstants.INT_CERO, NumerosConstants.INT_SEIS);
		 }
		 
		 
		 return buil.append(part1).append(ActivacionConstants.PUNTO_DOMINIO).append(part2).toString();
	}
}
