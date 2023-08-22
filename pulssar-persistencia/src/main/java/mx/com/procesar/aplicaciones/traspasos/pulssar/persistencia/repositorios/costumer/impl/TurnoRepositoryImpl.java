package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.costumer.impl;


import static mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.constantes.ReporteriaConstants.CLAVE_TODOS;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.constantes.ReporteriaConstants.INT_MIL;
import static mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.constantes.ReporteriaConstants.REPORTE_WEB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.modelo.ReporteriaDatosConsulta;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.costumer.TurnoRepositoryCustom;

/**
 * Implementacion del Repositorio personalizado para tuno
 * @author EHLUNARA
 *
 */
public class TurnoRepositoryImpl implements TurnoRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	/*
	 * (non-Javadoc)
	 * @see mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.repositorios.costumer.TurnoRepositoryCustom#obtenerReporte(java.util.Date, java.util.Date, java.lang.String, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> obtenerReporte(ReporteriaDatosConsulta datosConsulta) {
		
		StringBuilder sentencia = new StringBuilder(); 
		
		sentencia.append("SELECT T1.FC_REGISTRO, ");
		sentencia.append("T1.CURP, ");
		sentencia.append("TRIM(T1.CH_NOMBRE_TRAB) || ' ' || TRIM(T1.CH_APELLIDO_PATERNO_TRAB) || ' ' ||  TRIM(T1.CH_APELLIDO_MATERNO_TRAB) AS NOMBRE_TRAB, ");
		sentencia.append("CASE WHEN T1.CH_INDICADOR_CITA='FS' THEN 'Sin cita' WHEN T1.CH_INDICADOR_CITA='FC' THEN 'Con cita' END AS INDICADOR_CITA, ");
		sentencia.append("T1.NU_CUS, ");
		sentencia.append("T1.CH_FOLIO_SERVICIO, ");
		sentencia.append("CASE WHEN T1.CV_TURNO_ESTATUS='03' THEN 'Atendido'  WHEN  T1.CV_TURNO_ESTATUS='04' THEN 'Cancelado' END AS ESTATUS_TURNO, ");
		sentencia.append("TS.CH_DESC_SERVICIO, ");
		sentencia.append("T1.FC_REGISTRO AS FC_LLEGADA, ");
		sentencia.append("T1.FC_INICIO_ATENCION, ");
		sentencia.append("T1.FC_FIN_ATENCION, ");
		sentencia.append("TRIM(TU.CH_NOMBRE) || ' ' || TRIM(TU.CH_APELLIDO_PATERNO) || ' ' || TRIM(TU.CH_APELLIDO_MATERNO) AS NOMBRE_USUARIO, ");
		sentencia.append("TFP.CH_SUCURSAL, ");
		sentencia.append("T1.CH_SERVICIOS_REALIZADOS, ");
		sentencia.append("T1.CH_FOLIO_ATENCION, ");
		sentencia.append("CASE WHEN T1.CV_TURNO_ESTATUS IN ('01','02','03') THEN 'Asistido'  WHEN  T1.CV_TURNO_ESTATUS='04' THEN 'Cancelado' END  AS ESTATUS_CITA ");
		
		sentencia.append("FROM PSER_TR_TURNO T1 ");
		sentencia.append("INNER JOIN PSER_TC_SERVICIO TS        ON T1.ID_SERVICIO        = TS.ID_SERVICIO ");
		sentencia.append("INNER JOIN PSER_TR_FOLIO_PULSSAR TFP  ON T1.ID_FOLIO_PULSSAR   = TFP.ID_FOLIO_PULSSAR ");
		sentencia.append("INNER JOIN PSER_TR_USUARIO_PULSSAR TU ON T1.ID_USUARIO_PULSSAR = TU.ID_USUARIO_PULSSAR ");
		
		sentencia.append("WHERE T1.FC_REGISTRO BETWEEN ?1 AND ?2 ");
		sentencia.append("AND T1.CH_INDICADOR_CITA IN ("+datosConsulta.getIndicadorCita()+") ");
		
		if(datosConsulta.getServicio().intValue()!=CLAVE_TODOS.intValue()){
			sentencia.append(" AND T1.ID_SERVICIO=?3 ");
		}
		
		if(datosConsulta.getNumeroSucursal()!=null && datosConsulta.getNumeroSucursal().trim().length()>0){
			sentencia.append(" AND TFP.CH_SUCURSAL LIKE '%"+datosConsulta.getNumeroSucursal()+"%' ");
		}
		
		if(datosConsulta.getTipoReporte().intValue()==REPORTE_WEB.intValue()){
			sentencia.append(" AND ROWNUM <= "+INT_MIL+" ");
		}
		
		sentencia.append(" ORDER BY T1.ID_TURNO ");
		
		Query query = entityManager.createNativeQuery(sentencia.toString())
				.setParameter(1, datosConsulta.getFechaInicio())
				.setParameter(2, datosConsulta.getFechaFin())
		        .setParameter(3, datosConsulta.getServicio());
		
		return query.getResultList();
	}

}
