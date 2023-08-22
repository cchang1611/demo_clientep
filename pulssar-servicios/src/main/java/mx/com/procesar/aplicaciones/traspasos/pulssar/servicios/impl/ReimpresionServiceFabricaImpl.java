package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionServiceFabrica;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReimpresionServiceSaldosYMovimientos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.MenuReimpresionSaldosYMovimientosEnum;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;


/**
 * ReimpresionServiceImpl
 * @author jmordone
 *
 */
@Service
public class ReimpresionServiceFabricaImpl implements ReimpresionServiceFabrica{
	
	/**
	 * consentimiento
	 */
	@Qualifier("consentimiento")
	@Autowired
	private ReimpresionService consentimiento;
	
	/**
	 * solicitudModificacionDatos
	 */
	@Qualifier("modificacionDatos")
	@Autowired
	private ReimpresionService solicitudModificacionDatos;
	
	/**
	 * permanencia
	 */
	@Qualifier("permanencia")
	@Autowired
	private ReimpresionService permanencia;
	
	/**
	 * reimpresionServiceSaldosYMovimientos
	 */
	@Autowired
	private ReimpresionServiceSaldosYMovimientos reimpresionServiceSaldosYMovimientos;
	
	/**
	 * obtenerServicioReimpresion
	 */
	@Override
	public ReimpresionService obtenerServicioReimpresion(Integer tramite) {
		MenuReimpresionEnum servicio=MenuReimpresionEnum.obtenerDescripcion(tramite);
		ReimpresionService reimpresionService = null;
			switch (servicio) {
			case CONSENTIMENTO_ENROLAMIENTO:
				reimpresionService=consentimiento;
			break;
			case SOLICITUD_MODIFICACION_DATOS:
				reimpresionService=solicitudModificacionDatos;
			break;
			case PERMANENCIA:
				reimpresionService=permanencia;
			break;
			default:
			break;
		}
		return reimpresionService;
	}
	
	/**
	 * obtenerArchivoPorTramiteSaldosMovimientos
	 */
	@Override
	public DatosArchivos obtenerArchivoPorTramiteSaldosMovimientos(Integer modulo, DatosTrabajador trabajador,UsuarioLogin user) {
		DatosArchivos datosArchivo=new DatosArchivos();
		MenuReimpresionSaldosYMovimientosEnum servicio=MenuReimpresionSaldosYMovimientosEnum.obtenerDescripcion(modulo);
		
		switch (servicio) {
			case RESUMEN_SALDOS:
				datosArchivo=reimpresionServiceSaldosYMovimientos.obtenerArchivosReimpresion(trabajador,servicio.getTipoDocumento(),user);
			break;
			case ESTADOS_DE_CUENTA:
				datosArchivo=reimpresionServiceSaldosYMovimientos.obtenerArchivosReimpresion(trabajador,servicio.getTipoDocumento(),user);
			break;
			case DETALLE_DE_MOVIMIENTO:
				datosArchivo=reimpresionServiceSaldosYMovimientos.obtenerArchivosReimpresion(trabajador,servicio.getTipoDocumento(),user);
			break;
			default:
			break;
		}

		return datosArchivo;
	}

}
