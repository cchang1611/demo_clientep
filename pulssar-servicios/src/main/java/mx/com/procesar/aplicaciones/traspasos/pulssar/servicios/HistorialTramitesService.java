package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioProcesoEstatus;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioSalida;

public interface HistorialTramitesService {

	
	List<FolioSalida> consultarFoliosPadre(String nss, String curp);
	
	List<FolioSalida> consultarFolioHijo(String idProcesar);
	
	public List<FolioProcesoEstatus> consultarGruposEstatus(String idFolio, String cveOrganizacion);
}
