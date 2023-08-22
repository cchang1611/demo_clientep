/**
 * PlataformaOperativaUtilTestCase.java
 * Fecha de creación: 26/05/2021, 12:21:05
 *
 * Copyright (c) 2021 Procesar S A de C V.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Procesar S A de C V. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine la propia empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.utilerias;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPersistenceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.test.config.PulssarPropertiesApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarCorreoAplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.test.config.PulssarServiceApplicationContextTest;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PlataformaOperativaUtil;

/**
 * Clase que contiene las pruebas de la utileria de la pataforma de servicios operativa
 * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
 * @version 1.0
 * @since Mayo 2021
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PulssarPropertiesApplicationContextTest.class, PulssarServiceApplicationContextTest.class,
    PulssarPersistenceApplicationContextTest.class, PulssarCorreoAplicationContextTest.class })
public class PlataformaOperativaUtilTestCase {

    /**
     * Definicion de Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(PlataformaOperativaUtilTestCase.class);

    /**
     * Utileria de la platafora
     */
    @Autowired
    private PlataformaOperativaUtil plataformaOperativaUtil;

    /**
     * Caso de prueba del happy path de metodo de conversion de Clave rol a entidad
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testConvertirClaveRolATipoEntidad() {
        try {
            List<Rol> roles = new ArrayList<>();
            Rol rol = new Rol();
            rol.setClaveRol("04");
            roles.add(rol);
            String resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("01", resultado);
            
            rol.setClaveRol("06");
            resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("05", resultado);
            
            rol.setClaveRol("13");
            resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("03", resultado);
            
            rol.setClaveRol("07");
            resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("04", resultado);
            
            rol.setClaveRol("08");
            resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("04", resultado);
            
            rol.setClaveRol("09");
            resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("04", resultado);
            
            rol.setClaveRol("10");
            roles.add(rol);
            resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("04", resultado);
            
            rol.setClaveRol("11");
            roles.add(rol);
            resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("01", resultado);
            
            rol.setClaveRol("12");
            roles.add(rol);
            resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("07", resultado);
            
        } catch(Exception e) {
            LOG.error("Error en la conversion", e);
            fail("Error en la prueba, no se esperaba excepcion");
        }
    }

    /**
     * Caso de prueba del metodo de conversion de Clave rol a entidad
     * Flujo: Clave de rol nula
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testConvertirClaveRolATipoEntidad_RolNull() {
        try {
            List<Rol> roles = new ArrayList<>();
            Rol rol = new Rol();
            roles.add(rol);
            String resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("", resultado);
        } catch(Exception e) {
            LOG.error("Error en la conversion", e);
            fail("Error en la prueba, no se esperaba excepcion");
        }
    }

    /**
     * Caso de prueba del metodo de conversion de Clave rol a entidad
     * Flujo: Lista de Roles nula
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testConvertirClaveRolATipoEntidad_RolesNull() {
        try {
            List<Rol> roles = null;
            String resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("", resultado);
        } catch(Exception e) {
            LOG.error("Error en la conversion", e);
            fail("Error en la prueba, no se esperaba excepcion");
        }
    }

    /**
     * Caso de prueba del metodo de conversion de Clave rol a entidad
     * Flujo: Lista de Roles vacia
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testConvertirClaveRolATipoEntidad_RolesVacio() {
        try {
            List<Rol> roles = new ArrayList<>();
            String resultado = plataformaOperativaUtil.convertirClaveRolATipoEntidad(roles);
            assertNotNull(resultado);
            assertEquals("", resultado);
        } catch(Exception e) {
            LOG.error("Error en la conversion", e);
            fail("Error en la prueba, no se esperaba excepcion");
        }
    }

    /**
     * Caso de prueba del metodo de conversion de una cadena separada por comas a lista <br>
     * Flujo: Happy Path
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testConvertirCadenaALista() {
        String cadena = "a,b,c,d";
        List<String> lista = plataformaOperativaUtil.convertirCadenaALista(cadena);
        assertTrue(lista != null);
        assertTrue(lista.size() == 4);
    }

    /**
     * Caso de prueba del metodo de conversion de una cadena separada por comas a lista <br>
     * Flujo: Cadena de entrada nula
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testConvertirCadenaALista_ElementosNulos() {
        String cadena = null;
        List<String> lista = plataformaOperativaUtil.convertirCadenaALista(cadena);
        assertTrue(lista != null);
        assertTrue(lista.isEmpty());
    }

    /**
     * Caso de prueba del metodo de conversion de una cadena separada por comas a lista <br>
     * Flujo: Cadena de entrada con espacios
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testConvertirCadenaALista_CadenaEspacios() {
        String cadena = "              ";
        List<String> lista = plataformaOperativaUtil.convertirCadenaALista(cadena);
        assertTrue(lista != null);
        assertTrue(lista.isEmpty());
    }

    /**
     * Caso de prueba del metodo de filtrado de modulos asignados <br>
     * Flujo: Lista de modulos por BD con varios registros <br>
     * Lista de modulos por OID con varios registros <br>
     * <br>
     * Se espera que la lista resultante solo tenga dos elementos y que sean del modulo de retiros
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testEliminarModulosNoPermitidos() {
        List<RolReporte> modulosAsigandosBD = new ArrayList<>();
        Long retiros = 1L;
        Long reca = 2L;
        Long registro = 3L;

        RolReporte rolReporteRetiros = new RolReporte();
        rolReporteRetiros.setIdModulo(retiros);

        RolReporte rolReporteReca = new RolReporte();
        rolReporteReca.setIdModulo(reca);

        RolReporte rolReporteRegistro = new RolReporte();
        rolReporteRegistro.setIdModulo(registro);

        modulosAsigandosBD.add(rolReporteRetiros);
        modulosAsigandosBD.add(rolReporteRetiros);
        modulosAsigandosBD.add(rolReporteReca);
        modulosAsigandosBD.add(rolReporteRegistro);
        modulosAsigandosBD.add(rolReporteRegistro);

        List<String> listaModulosAsignadosOID = Arrays.asList(String.valueOf(retiros));
        plataformaOperativaUtil.eliminarModulosNoPermitidos(modulosAsigandosBD, listaModulosAsignadosOID);
        assertTrue(modulosAsigandosBD.size() == 2);
    }

    /**
     * Caso de prueba del metodo de filtrado de modulos asignados <br>
     * Flujo: Lista de modulos por BD con varios registros <br>
     * Lista de modulos por OID nulos <br>
     * <br>
     * Se espera que la lista resultante este vacia
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testEliminarModulosNoPermitidos_ModulosOIDNulos() {
        List<RolReporte> modulosAsigandosBD = new ArrayList<>();
        Long retiros = 1L;
        Long reca = 2L;
        Long registro = 3L;

        RolReporte rolReporteRetiros = new RolReporte();
        rolReporteRetiros.setIdModulo(retiros);

        RolReporte rolReporteReca = new RolReporte();
        rolReporteReca.setIdModulo(reca);

        RolReporte rolReporteRegistro = new RolReporte();
        rolReporteRegistro.setIdModulo(registro);

        modulosAsigandosBD.add(rolReporteRetiros);
        modulosAsigandosBD.add(rolReporteRetiros);
        modulosAsigandosBD.add(rolReporteReca);
        modulosAsigandosBD.add(rolReporteRegistro);
        modulosAsigandosBD.add(rolReporteRegistro);

        List<String> listaModulosAsignadosOID = null;
        plataformaOperativaUtil.eliminarModulosNoPermitidos(modulosAsigandosBD, listaModulosAsignadosOID);
        assertTrue(modulosAsigandosBD.isEmpty());
    }

    /**
     * Caso de prueba del metodo de filtrado de modulos asignados <br>
     * Flujo: Lista de modulos por BD con varios registros <br>
     * Lista de modulos por OID vacios <br>
     * <br>
     * Se espera que la lista resultante este vacia
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testEliminarModulosNoPermitidos_ModulosOIDVacios() {
        List<RolReporte> modulosAsigandosBD = new ArrayList<>();
        Long retiros = 1L;
        Long reca = 2L;
        Long registro = 3L;

        RolReporte rolReporteRetiros = new RolReporte();
        rolReporteRetiros.setIdModulo(retiros);

        RolReporte rolReporteReca = new RolReporte();
        rolReporteReca.setIdModulo(reca);

        RolReporte rolReporteRegistro = new RolReporte();
        rolReporteRegistro.setIdModulo(registro);

        modulosAsigandosBD.add(rolReporteRetiros);
        modulosAsigandosBD.add(rolReporteRetiros);
        modulosAsigandosBD.add(rolReporteReca);
        modulosAsigandosBD.add(rolReporteRegistro);
        modulosAsigandosBD.add(rolReporteRegistro);

        List<String> listaModulosAsignadosOID = new ArrayList<>();
        plataformaOperativaUtil.eliminarModulosNoPermitidos(modulosAsigandosBD, listaModulosAsignadosOID);
        assertTrue(modulosAsigandosBD.isEmpty());
    }

    /**
     * Caso de prueba del metodo de filtrado de modulos asignados <br>
     * Flujo: Lista de modulos nula <br>
     * Lista de modulos por OID no nula <br>
     * <br>
     * Se espera que la lista resultante sea nula
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testEliminarModulosNoPermitidos_ModulosBDNulos() {
        List<RolReporte> modulosAsigandosBD = null;
        Long retiros = 1L;

        List<String> listaModulosAsignadosOID = Arrays.asList(String.valueOf(retiros));
        plataformaOperativaUtil.eliminarModulosNoPermitidos(modulosAsigandosBD, listaModulosAsignadosOID);
        assertNull(modulosAsigandosBD);
    }

    /**
     * Caso de prueba del metodo de filtrado de modulos asignados <br>
     * Flujo: Lista de modulos nula <br>
     * Lista de modulos por OID nula <br>
     * <br>
     * Se espera que la lista resultante sea nula
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testEliminarModulosNoPermitidos_ModulosBDNulos_OIDNulos() {
        List<RolReporte> modulosAsigandosBD = null;

        List<String> listaModulosAsignadosOID = null;
        plataformaOperativaUtil.eliminarModulosNoPermitidos(modulosAsigandosBD, listaModulosAsignadosOID);
        assertNull(modulosAsigandosBD);
    }

    /**
     * Caso de prueba del metodo de conversion de Cadenas de String a Long <br>
     * Flujo: Lista de cadenas nula <br>
     * <br>
     * Se espera que la lista resultante sea no nula, pero vacia
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testConvertirALong_ListaNula() {

        List<String> listaCadenas = null;
        List<Long> resultado = plataformaOperativaUtil.convertirALong(listaCadenas);
        assertTrue(resultado.isEmpty());
    }

    /**
     * Caso de prueba del metodo de conversion de Cadenas de String a Long <br>
     * Flujo: Lista de cadenas vacia <br>
     * <br>
     * Se espera que la lista resultante sea no nula, pero vacia
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testConvertirALong_ListaVacia() {

        List<String> listaCadenas = new ArrayList<>();
        List<Long> resultado = plataformaOperativaUtil.convertirALong(listaCadenas);
        assertTrue(resultado.isEmpty());
    }

    /**
     * Caso de prueba del metodo de conversion de cadenas de String a Long <br>
     * Flujo: Lista de cadenas con elementos no numericos <br>
     * <br>
     * Se espera que la lista resultante contnega unicamente los elementos numericos
     * @author Victorino Hern&aacute;ndez Ruiz(vhernand@procesar.com)
     */
    @Test
    public void testConvertirALong_ListaElementosNoNumericos() {

        List<String> listaCadenas = Arrays.asList("1 ", "a", "1.0", "2.23", "4", "");
        List<Long> resultado = plataformaOperativaUtil.convertirALong(listaCadenas);
        assertTrue(resultado.size() == 2);
    }

}
