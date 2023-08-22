/**
 * ZonaHoraSucursalRepository.java
 * Fecha de creaci�n: Sep 9, 2020
 *
 * Copyright (c) 2020 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Procesar S A de C V. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ZonaHoraSucursal;

/**
 * Repositorio para la tabla PSER_TR_ZONA_HOR_SUCURSAL
 * @author Isidro Hernandez Vega (ihernanv@inet.procesar.com.mx)
 */
public interface ZonaHoraSucursalRepository extends JpaRepository<ZonaHoraSucursal, Long> {
	
	/**
	 * Consulta por cve de Sucursal
	 */
	ZonaHoraSucursal findByChCveSuc(String cveSucursal);
	
}