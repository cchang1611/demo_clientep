package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarMatrizDerechoProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.ValidadorUtils;
/**
 * Valida DerechoMatrizProceso 
 * @author Adrian Nicolas Osorio (ANICOLAS@inet.procesar.com.mx)
 * @version 1.0
 * @since Apr 15, 2021
 */
@Service
public class ValidarMatrizDerechoProcesoServiceImpl implements ValidarMatrizDerechoProcesoService{
	
	/**
	 * Inyeccion de utileria validador
	 */
	@Autowired
	private ValidadorUtils utileriaValidador;

	
	/*
	 * La documentación de este método se encuentra en la clase o interface que
	 * lo declara  (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ValidarMatrizDerechoProcesoService#validarMatrizDerecho(org.springframework.ui.ModelMap, java.util.List)
	 */
	@Override
	public List<String> validarMatrizDerecho(List<String> claves) {
		List<String> temporal = new ArrayList<>();
		if(!utileriaValidador.validarListaVacia(claves) && claves.contains(ExpresionesConstants.cvProceso_402) || claves.contains(ExpresionesConstants.cvProceso_403)){	
    	   	        temporal.add(ExpresionesConstants.cvProceso_402);
	    	      	temporal.add(ExpresionesConstants.cvProceso_403);
	   	 } 
				
		return temporal;
		
	}

}
