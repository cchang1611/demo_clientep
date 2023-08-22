package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.BitacoraReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteBitacora;

/**
 * Repositorio de Bitacora de Reportes
 * 
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 20/07/2020
 */
public interface BitacoraRepository extends JpaRepository<BitacoraReporte, Long> {

    /**
     * Método encargado de llevar el conteo de ejecuciones de reportes por usuario.
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param idReporte
     * @param usuario
     * @return int
     * @since 20/07/2020
     */
    @Query(name = "contadorejecucionConsultaPorUsuario")
    int contadorEjecucionReportePorUsuario(Long idReporte, String usuario);

    /**
     * Consulta que realiza la búsqueda de información con base a un rango de
     * fechas.
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param fechaInicial
     * @param fechaFinal
     * @return List<ReporteBitacora>
     * @since 20/07/2020
     */
    @Query(name = "consultaPorRangoFechas")
    List<ReporteBitacora> consultarPorRangoFechas(String fechaInicial, String fechaFinal);

    /**
     * Consulta que realiza la búsqueda de información con base al ID de tipo
     * reporte.
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param usuario
     * @return List<ReporteBitacora>
     * @since 20/07/220
     */
    @Query(name = "consultaPorUsuario")
    List<ReporteBitacora> consultarPorUsuario(String usuario);

    /**
     * Consulta que realiza la búsqueda de información con base a la IP del Usuario
     * registrada.
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param usuario
     * @return List<ReporteBitacora>
     * @since 20/07/2020
     */
    @Query(name = "consultaPorIpUsuario")
    List<ReporteBitacora> consultarPorIpUsuario(String usuario);
}
