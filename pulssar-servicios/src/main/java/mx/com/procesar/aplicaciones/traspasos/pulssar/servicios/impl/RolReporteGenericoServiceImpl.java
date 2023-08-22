package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteGenerico;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.RolesReporteGenericoRepository;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolReporteGenericoService;



/**
 * Implementacion de servicios de Catalogo de Modulo
 * 
 * @author hjramire
 * @version 1.0
 * @since 03/01/2020, 09:13:42
 */
@Service
public class RolReporteGenericoServiceImpl implements RolReporteGenericoService {

	/**
	 * Log de la clase
	 */
	private static final Logger log = LoggerFactory.getLogger(RolReporteGenericoServiceImpl.class);
	

	/**
	 * Repository para recuperar la lista de reportes genericos a partir del idRol
	 */
	@Autowired
	private RolesReporteGenericoRepository rolesReporteGenericoRepository;


	/**
	 * Metodo para recuperar la lista de reportes genericos a partir del idRol,
	 * tipo de reporte y tipo de flujo
	 * 
	 * @author DGSANCHEZ
	 * @param idRol
	 * @return List<RolReporteGenerico>
	 */
	@Override
	public List<RolReporteGenerico> recuperarIdReportePorRol(String idRoles) {
		log.info("****************** entra a recuperaIdReportePorRol *****");
		
		List<RolReporteGenerico> result = null;
		
		try {
			List<Long> idRolesLista = new ArrayList<>();
			String[] strListaRol = idRoles.split(",");
			for (String rol : strListaRol) {
				   rol = rol.replace("[", "");
				   rol = rol.replace("]", "");
				idRolesLista.add(Long.valueOf(rol));
			}
			result = rolesReporteGenericoRepository.findByIdRol(idRolesLista);			
		} catch (Exception e) {
			log.error("Error al consultar los recuperaIdReportePorRol {}", e);
		}
		
        if (result != null) {
            log.info("numero de lista recuperados prueba: {}", result.size());
        } else {
            log.info("No se hallaron reportes");
        }
	return result;
	}
}
