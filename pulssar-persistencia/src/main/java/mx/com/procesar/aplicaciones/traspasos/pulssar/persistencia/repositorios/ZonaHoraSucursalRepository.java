/**
 * ZonaHoraSucursalRepository.java
 * Fecha de creación: Sep 9, 2020
 *
 * Copyright (c) 2020 Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
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