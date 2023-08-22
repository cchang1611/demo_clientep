/**
 * PlataformaOperativaUtil.java Fecha de creación: 27/01/2021, 23:02:29 Copyright (c) 2021
 * Procesar S A de C V. Todos los derechos reservados. Este software es información
 * confidencial, propiedad del Procesar S A de C V. Esta información confidencial no deberá ser
 * divulgada y solo se podrá utilizar de acuerdo a los términos que determine la propia
 * empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias;

import java.util.List;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;

/**
 * Clase que contiene los metodos de utileria del modulo de la plataforma operativa
 * @author Victorino Hern&aacute;ndez Ruiz (vhernand@procesar.com)
 * @version 1.0
 * @since 27/01/2021
 */
public interface PlataformaOperativaUtil {

  /**
   * Metodo que convierte la clave del rol del Pulssar al tipo de entidad requerida por las
   * pantallas del SICI, esta utileria realiza las siguientes conversiones
   * <ul>
   * <li>Si la clave de organizacion es 04, se retorna la entidad 01 + clave Afore (Afore)</li>
   * <li>Si la clave de organizacion es 06, se retorna la entidad 05 + clave (CONSAR)</li>
   * <li>Si la clave de organizacion es 07, se retorna la entidad 04 + clave null (Instituto)
   * </li>
   * <li>Si la clave de organizacion es 08, se retorna la entidad 04 + clave 001(IMSS)</li>
   * <li>Si la clave de organizacion es 09, se retorna la entidad 04 + clave 003(ISSSTE)</li>
   * <li>Si la clave de organizacion es 10, se retorna la entidad 04 + clave 002(INFONAVIT)
   * </li>
   * <li>Si la clave de organizacion es 11, se retorna la entidad 01 + clave 006 (Aseguradora)
   * </li>
   * <li>Si la clave de organizacion no 12, se retorna la entidad + clave (Entidad Rec)</li>
   * <li>Si la clave de organizacion es 13, se retorna la entidad 03 + clave null (Procesar)
   * </li>
   * <li>En caso conttrario se retorna nulo</li>
   * </ul>
   * @author Victorino Hern&aacute;ndez Ruiz (vhernand@procesar.com)
   * @param roles Listado de roles del usuario
   * @return Cadena con la clave de entidad equivalente
   */
  String convertirClaveRolATipoEntidad(List<Rol> roles);

    /**
     * Metodo que covierte una cadena de elementos separados por coma a lista
     * @author Victorino Hern&aacute;ndez Ruiz (vhernand@procesar.com)
     * @param cadenaElementos
     * @return Lista que contiene los elementos de la cadena
     */
    List<String> convertirCadenaALista(String cadenaElementos);

    /**
     * Metodo que recibe una lista con los modulos asiganados al rol y otra con los que tiene
     * permitido ver. Devuelve una lista de los modulos asignados y que tiene permitido
     * acceder, es decir cuyos identificadores se encuentran en las dos listas
     * @author Victorino Hern&aacute;ndez Ruiz (vhernand@procesar.com)
     * @param modulosAsigandosBD Modulos asiganados por base de datos al usuario
     * @param listaModulosAsignadosOID Modulos que tiene asignados por OID
     */
    void eliminarModulosNoPermitidos(List<RolReporte> modulosAsigandosBD, List<String> listaModulosAsignadosOID);

    /**
     * Metodo que convierte una lista de cadenas a una de la clase Long, si algun elemento no
     * puede ser convertido, se ignora
     * @author Victorino Hern&aacute;ndez Ruiz (vhernand@procesar.com)
     * @param listaCadenas Lista de cadenas a convertir
     * @return Lista de Longs resultante de la conversion
     */
    List<Long> convertirALong(List<String> listaCadenas);
}
