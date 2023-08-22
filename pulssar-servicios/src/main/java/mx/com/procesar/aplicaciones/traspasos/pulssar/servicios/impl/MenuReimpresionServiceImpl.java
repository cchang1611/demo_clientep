package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.MenuReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionSaldosYMovimientosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.MenuReimpresion;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaServicio;

/**
 * MenuReimpresionServiceImpl
 * @author jmordone
 *
 */
@Service
public class MenuReimpresionServiceImpl implements MenuReimpresionService{
	
	/**
	 * obtenerMenuReimpresion
	 */
	@Override
	public MenuReimpresion obtenerMenuReimpresion() {
		MenuReimpresion menuReimpresion = new MenuReimpresion();
		menuReimpresion.setConsentimientoEnrolamiento(MenuReimpresionEnum.CONSENTIMENTO_ENROLAMIENTO.getIdMenuReimpresion());
		menuReimpresion.setPermanencia(MenuReimpresionEnum.PERMANENCIA.getIdMenuReimpresion());
		menuReimpresion.setSaldosMovimientos(MenuReimpresionEnum.SALDOS_MOVIMIENTOS.getIdMenuReimpresion());
		menuReimpresion.setSolicitudModificacionDatos(MenuReimpresionEnum.SOLICITUD_MODIFICACION_DATOS.getIdMenuReimpresion());
		return menuReimpresion;
	}
	
	/**
	 * obtenerMenuReimpresion
	 */
	
	@Override
	public List<MenuReimpresionSaldosYMovimientosEnum> obtenerMenuReimpresionSaldosYMovimientos() {
		List<MenuReimpresionSaldosYMovimientosEnum> lista= new ArrayList<>();
		//lista.add(MenuReimpresionSaldosYMovimientosEnum.RESUMEN_SALDOS);
		lista.add(MenuReimpresionSaldosYMovimientosEnum.ESTADOS_DE_CUENTA);
		lista.add(MenuReimpresionSaldosYMovimientosEnum.DETALLE_DE_MOVIMIENTO);
		return lista;
	}
	
	
	/**
	 * obtenerRespuestaCorrecta
	 * @param flujo
	 * @param mensaje
	 * @return
	 */
	@Override
	public RespuestaServicio obtenerRespuestaCorrecta(Integer flujo,String mensaje,String datos) {
		RespuestaServicio respuesta = new RespuestaServicio();
		respuesta.setFlujo(flujo);
		respuesta.setMensaje(mensaje);
		respuesta.setDatos(datos);
		return respuesta;
		
	}
    
}
