package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionSaldosYMovimientosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MenuReimpresion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;

/**
 * Menu reimpresion service
 * @author jmordone
 *
 */
public interface MenuReimpresionService {
     
	/**
	 * obtener Menu Reimpresion
	 * @return
	 */
	MenuReimpresion obtenerMenuReimpresion();
	
	
	/**
	 * obtenerMenuReimpresionSaldosYMovimientos
	 * @return
	 */
	List<MenuReimpresionSaldosYMovimientosEnum> obtenerMenuReimpresionSaldosYMovimientos();
	
	/**
	 * obtenerRespuestaCorrecta
	 * @param flujo
	 * @param mensaje
	 * @return
	 */
	RespuestaServicio obtenerRespuestaCorrecta(Integer flujo,String mensaje,String datos);
	
	
	
}
