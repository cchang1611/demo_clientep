/**
 * PlataformaOperativaUtilImpl.java Fecha de creación: 27/01/2021, 23:25:36 Copyright (c) 2021
 * Procesar S A de C V. Todos los derechos reservados. Este software es información
 * confidencial, propiedad del Procesar S A de C V. Esta información confidencial no deberá ser
 * divulgada y solo se podrá utilizar de acuerdo a los términos que determine la propia
 * empresa.
 */
package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PlataformaOperativaConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PlataformaOperativaUtil;

/**
 * Clase que implementa los metodos de utileria del modulo de plataforma operativa
 * @author Victorino Hern&aacute;ndez Ruiz (vhernand@procesar.com)
 * @version 1.0
 * @since 27/01/2021
 */
@Component("plataformaOperativaUtil")
public class PlataformaOperativaUtilImpl implements PlataformaOperativaUtil {

    /**
     * Log de la clase
     */
    private static final Logger LOG = LoggerFactory.getLogger(PlataformaOperativaUtilImpl.class);

    /**
     * Mapa con la relacion de clave de rol (pulssar) y clave de entidad (antes SICI)
     */
    @Value("#{${plataforma.operativa.relacion.rol.entidad}}")
    private Map<String, String> mapaRolEntidad;

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.
     * PlataformaOperativaUtil #convertirClaveOrganizacionAEntidad(java.util.List)
     */
    @Override
    public String convertirClaveRolATipoEntidad(List<Rol> roles) {
        String claveEntidad = "";
        if (roles != null && !roles.isEmpty()) {
            Rol rol = roles.get(0);
            if (rol.getClaveRol() != null) {
                claveEntidad = mapaRolEntidad.get(rol.getClaveRol());
            }
        }
        return claveEntidad;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.
     * PlataformaOperativaUtil#convertirCadenaALista(java.lang.String)
     */
    @Override
    public List<String> convertirCadenaALista(String cadenaElementos) {
        List<String> resultado = new ArrayList<>();
        if (cadenaElementos != null && !PlataformaOperativaConstants.CADENA_VACIA.equals(cadenaElementos.trim())) {
            resultado = Arrays.asList(cadenaElementos.split(PlataformaOperativaConstants.CARACTER_COMA));
        }
        return resultado;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.
     * PlataformaOperativaUtil#eliminarModulosNoPermitidos(java.util.List, java.util.List)
     */
    @Override
    public void eliminarModulosNoPermitidos(List<RolReporte> modulosAsigandosBD, List<String> listaModulosAsignadosOID) {
        if (listaModulosAsignadosOID == null || listaModulosAsignadosOID.isEmpty()) {
            if (modulosAsigandosBD != null) {
                // Si no tiene modulos asignados por OID, elimna todos los asignados por BD
                modulosAsigandosBD.clear();
            }
        } else if (modulosAsigandosBD != null) {
            // Tiene modulos asignados por OID, Se procede a remover los que tiene asignados
            // por BD que no pertenecen a los asignados por OID
            List<Long> identificadoresOID = convertirALong(listaModulosAsignadosOID);
            Iterator<RolReporte> iteradorBD = modulosAsigandosBD.iterator();
            while(iteradorBD.hasNext()) {
                RolReporte elementoActual = iteradorBD.next();
                // Si el modulo del elemento actual no se encuentra en el listado de modulos
                // del OID se quita de la lista
                if (!identificadoresOID.contains(elementoActual.getIdModulo())) {
                    iteradorBD.remove();
                }
            }
        }
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.
     * PlataformaOperativaUtil#convertirALong(java.util.List)
     */
    @Override
    public List<Long> convertirALong(List<String> listaCadenas) {
        List<Long> resultado = new ArrayList<>();
        if (listaCadenas != null && !listaCadenas.isEmpty()) {
            for (String cadena : listaCadenas) {
                try {
                    resultado.add(Long.valueOf(cadena.trim()));
                    LOG.info("Se agrega el elemento {} a la lista", cadena);
                } catch(Exception e) {
                    LOG.error("Ocurrio un error al agregar el elemento: {} a la lista", cadena, e);
                }
            }
        }
        return resultado;
    }

}
