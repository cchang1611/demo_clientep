package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.TipoRetiroService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;

@Service
public class TipoRetiroServiceImpl implements TipoRetiroService{

	private static final Logger logger = LoggerFactory.getLogger(SolicitudDisposicionServiceImpl.class);
	
	/**
	 * servicio
	 */
	@Autowired
	private RestTemplate servicio;
	
	/**
	 * uriComunes
	 */
	@Value("${uri.comunes}")
	private String uriComunes;	

	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.TipoRetiroService#obtenerTipoRetiro(mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidarSolicitudCertificacionAforeSalida, mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos)
	 */
	@Override
	public CalculoTipoRetiro obtenerTipoRetiro(RetiroDesempleoImss tipoRetiro, DatosSaldos saldos) throws IllegalAccessException {
		logger.info("obtenerTipoRetiro {}", tipoRetiro);
		
		StringBuilder sb = new StringBuilder();
		sb.append(uriComunes);
		sb.append("/tiporetiro").append("/")
		.append(tipoRetiro.getSbcTipoA()).append("/")
		.append(tipoRetiro.getSbcTipoB()).append("/");
		logger.info("saldos {}", saldos);
		BigDecimal saldo =new BigDecimal(saldos.getSaldoCesantiaVejez()).add(new BigDecimal(saldos.getSaldoCuotaSocial())).add(new BigDecimal(saldos.getSaldoRetiro97()));
		sb.append(saldo);
		sb.append("/");
		logger.info("url -> {}", sb);
		logger.info("obtenerTipoRetiro antes de llamar rest {}", sb);
		
		CalculoTipoRetiro retiro = servicio.getForObject(sb.toString(), CalculoTipoRetiro.class);
		
		logger.info("response {}", retiro);
		
		return retiro;
	}

	
	
	/* La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.TipoRetiroService#obtenerTipoRetiroMatrimonio(java.lang.String)
	 */
	@Override
	public CalculoTipoRetiro obtenerTipoRetiroMatrimonio(String fechaMatrimonio) throws BusinessException {
		logger.info("obtenerTipoRetiro {}", fechaMatrimonio);

		fechaMatrimonio =  convertirFechaUmas(fechaMatrimonio);
		 
		StringBuilder sb = new StringBuilder();
		sb.append(uriComunes);
		sb.append("/calcularMontoAPagar").append("/").append(fechaMatrimonio);

		logger.info("url -> {}", sb);
		logger.info("obtenerTipoRetiro antes de llamar rest {}", sb);
		BigDecimal retiro = null;
		try {
			retiro = servicio.getForObject(sb.toString(), BigDecimal.class);
		} catch (Exception e) {
			throw new BusinessException("Error en el servicio 'Consulta de  UMAs' fechaMat " + fechaMatrimonio);
		}

		logger.info("response {}", retiro);

		CalculoTipoRetiro ctr = new CalculoTipoRetiro();
		ctr.setMontoADisponerA(retiro.toString());

		return ctr;
	}
	
	
	/**
	 * @param fechaStr
	 * @return
	 */
	private String convertirFechaUmas(String fechaStr) {
        String formato1 = "dd/MM/yyyy"; // formato 1
        String formato2 = "yyyy/MM/dd"; // formato 2

        // Crear objetos de SimpleDateFormat para los dos formatos
        SimpleDateFormat sdf1 = new SimpleDateFormat(formato1);
        SimpleDateFormat sdf2 = new SimpleDateFormat(formato2);

        String[] fec = StringUtils.split(fechaStr, "/");
        
        //si es mayor a 2 es el anio
        if(!(StringUtils.length(fec[0])>2)) {
        	Date d;
			try {
				d = sdf1.parse(fechaStr);
				fechaStr = sdf2.format(d);
			} catch (ParseException e) {
				logger.error(e.getMessage());
			}
        }
        return fechaStr;
	}
	
	
	
}
