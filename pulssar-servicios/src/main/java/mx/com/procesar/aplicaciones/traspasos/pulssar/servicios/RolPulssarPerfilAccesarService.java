package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolPerfilFederados;

@Service
public interface RolPulssarPerfilAccesarService {

    List<RolPerfilFederados> encontrarRolesPerfiles(String claveRol);

    String obtenerNombreUsuario(String nickName);
}
