package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolPerfilFederados;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioNickPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.UsuarioPulssar;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.RolPerfilFederadosRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioNickPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.UsuarioPulssarRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolPulssarPerfilAccesarService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ExpresionesConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.NumerosConstants;

/**
 * Implementacion de servicios para la entidad de Rol Pulssar Vs Perfil Accesar
 * @author hjramire
 * @version 1.0
 * @since Oct 26, 2021
 */
@Service
public class RolPulssarPerfilAccesarServiceImpl implements RolPulssarPerfilAccesarService {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RolPulssarPerfilAccesarServiceImpl.class);


    /**
     * Servicio de consulta de perfiles de accesar
     */
    @Autowired
    private RolPerfilFederadosRepository rolPerfilFederadosRepository;

    @Autowired
    private UsuarioNickPulssarRepository nickPulssarRepository;

    @Autowired
    private UsuarioPulssarRepository usuarioPulssarRepository;

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolPulssarPerfilAccesarService#
     * recuperarListaRolesPerfiles(java.lang.String)
     */
    @Override
    public List<RolPerfilFederados> encontrarRolesPerfiles(String clavePerfil) {
        LOGGER.info("Se obtuvo la siguiente clave de perfil: {}", clavePerfil);

        return rolPerfilFederadosRepository.encontrarRolesPerfil(clavePerfil);
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolPulssarPerfilAccesarService#
     * obtenerNombreUsuario(java.lang.String)
     */
    @Override
    public String obtenerNombreUsuario(String nickName) {
        String nombreUsuario = "";
        try {
            UsuarioNickPulssar datosNickName = nickPulssarRepository.findByIdUsuarioAndEstatus(nickName, NumerosConstants.INT_UNO);
            UsuarioPulssar usuario = usuarioPulssarRepository.getOne(datosNickName.getIdentificadorUsuario());
            nombreUsuario = new StringBuilder(usuario.getNombre()).append(ExpresionesConstants.ESPACIO)
                .append(usuario.getApellidoPaterno())
                .append(ExpresionesConstants.ESPACIO)
                .append(usuario.getApellidoMaterno())
                .toString();
        } catch(Exception e) {
            LOGGER.error("Error al obtener los datos del usuario con NickName: {}", nickName, e);
        }
        return nombreUsuario;
    }

}