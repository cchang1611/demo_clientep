package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoCargadoSalida;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ProcesoDerechoNoCargado;

public interface ConsultarProcesoDerechoNoCargadoService {
     
	List<ProcesoDerechoCargadoSalida> consultarDerechoNoCargado(ProcesoDerechoNoCargado entradaDatos);
}
