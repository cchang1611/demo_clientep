/**
 * FabricaFolioComplementoService.java
 * Fecha de creación: Aug 26, 2021, 8:45:54 PM
 *
 * Copyright (c) 2021 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EnvioArchivos;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioComplemento;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;

/**
 * Servicio FabricaFolioComplemento
 * @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
 * @version 1.0
 * @since Aug 26, 2021
 */
public interface FabricaFolioComplementoService {
	
	/**
	 *  enviarArchivosGenerico
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param folio
	 *  @param user
	 *  @param trabajador
	 *  @param cuentaClabe
	 *  @return
	 */
	FolioComplemento enviarArchivosGenerico(Long folio, UsuarioLogin user, DatosTrabajador trabajador, String cuentaClabe);
	
	/**
	 *  generarDatosRecepcion
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param user
	 *  @param curp
	 *  @param folio
	 *  @param tipoAfiliacion
	 *  @return
	 */
	EnvioArchivos generarDatosRecepcion(UsuarioLogin user, String curp, String folio, String tipoAfiliacion,String cvTipoProceso);
	/**
	 *  TODO [Agregar documentacion al método]
	 *  @author Jose Manuel Cabrera Cardenas (jmcabrer@procesar.com)
	 *  @param folio
	 *  @param user
	 *  @param trabajador
	 *  @param entradaConsulta
	 *  @return
	 */
	FolioComplemento generarFolioParticipante(Long folio, UsuarioLogin user, DatosTrabajador trabajador, EntradaConsulta entradaConsulta);
}
