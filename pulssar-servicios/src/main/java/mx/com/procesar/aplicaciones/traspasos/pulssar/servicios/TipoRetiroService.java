package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.BusinessException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoTipoRetiro;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosSaldos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RetiroDesempleoImss;

public interface TipoRetiroService {

	
	/**
	 *  obtener calculo Tipo Retiro
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param tipoRetiro
	 *  @param saldos
	 *  @return
	 *  @throws IllegalAccessException 
	 */
	public CalculoTipoRetiro obtenerTipoRetiro(RetiroDesempleoImss tipoRetiro, DatosSaldos saldos) throws IllegalAccessException;
	
	/**
	 *  obtenerTipoRetiroMatrimonio
	 *  @author Hugo Cesar Garza Montoya (hcgarzam@procesar.com)
	 *  @param fechaMatrimonio
	 *  @return
	 */
	public CalculoTipoRetiro obtenerTipoRetiroMatrimonio(String fechaMatrimonio) throws BusinessException;
}
