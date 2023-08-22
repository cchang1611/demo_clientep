package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios;

import java.util.List;
import java.util.Map;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.BitacoraReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.ReporteBitacora;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;

/**
 * Definicion de servicios de operaciones sobre repositorio Bitacora de Reportes
 * 
 * @author Arturo Eduardo de la Cruz Perez
 * @version 1.0
 * @since 26/08/2020
 */
public interface BitacoraService {

    /**
     * Verifica si el usuario ya cumplio con le limite de ejecucion de un Reporte
     * por dia
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param idReporte
     * @param usuario
     * @return int
     * @throws PlataformaServiciosOperativaServiceException
     * @since 26/08/2020
     */
    int consultarNumPorUsuarioEnDia(Long idReporte, String usuario) throws PlataformaServiciosOperativaServiceException;

    /**
     * Metodo que registra una bitacora por por cada reporte ejecutado
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param idReporte
     * @param usuario
     * @param ipOrigen
     * @param params
     * @return
     * @throws PlataformaServiciosOperativaServiceException
     *             BitacoraReporte
     * @since 26/08/2020
     */
    BitacoraReporte registrarBitacora(Long idReporte, String usuario, String ipOrigen, Map<String, String> params)
        throws PlataformaServiciosOperativaServiceException;

    /**
     * Metodo que actualiza la bandera de exportacion de la bitacora reporte
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param bitacora
     * @param nuevoEstado
     * @throws PlataformaServiciosOperativaServiceException
     * @since 26/08/2020
     */
    void actualizarBanderaExportacion(BitacoraReporte bitacora, int nuevoEstado) throws PlataformaServiciosOperativaServiceException;

    /**
     * Metodo que actualiza la bandera de exportacion de la bitacora reporte
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param idBitacora
     * @param nuevoEstado
     * @throws PlataformaServiciosOperativaServiceException
     *             void
     * @since 26/08/2020
     */
    void actualizarBanderaExportacion(Long idBitacora, int nuevoEstado) throws PlataformaServiciosOperativaServiceException;

    /**
     * Método que realiza la consulta por un rango de fechas en la bitácora.
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param fechaInicial
     * @param fechaFinal
     * @return List<ReporteBitacora>
     * @throws PlataformaServiciosOperativaServiceException
     * @since 26/08/2020
     */
    List<ReporteBitacora> consultarPorRangoFechas(String fechaInicial, String fechaFinal)
        throws PlataformaServiciosOperativaServiceException;

    /**
     * Método que realiza la consulta por el nombre de usuario registrado en
     * bitácora.
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param usuario
     * @return
     * @throws PlataformaServiciosOperativaServiceException
     *             List<ReporteBitacora>
     * @since 26/08/2020
     */
    List<ReporteBitacora> consultarPorUsuario(String usuario) throws PlataformaServiciosOperativaServiceException;

    /**
     * Método que realiza la consulta por la IP registrada en bitácora.
     * 
     * @author Arturo Eduardo de la Cruz Perez
     * @param ipUsuario
     * @return List<ReporteBitacora>
     * @throws PlataformaServiciosOperativaServiceException
     * @since 26/08/2020
     */
    List<ReporteBitacora> consultarPorIpUsuario(String ipUsuario) throws PlataformaServiciosOperativaServiceException;

}