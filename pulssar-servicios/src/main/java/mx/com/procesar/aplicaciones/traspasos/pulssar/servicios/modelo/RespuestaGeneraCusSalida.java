package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
/**
* Respuesta genera cus
* @author REARREOL
*
*/
public class RespuestaGeneraCusSalida implements Serializable{
       
       /**
       * Serial
       */
       private static final long serialVersionUID = 1L;

       /**
       * folio servicio
       */
       private String folioServicio;
       
       /**
       * fecga recepcion notificacion
       */
       private String fechaRecepNotificacion;
       
       /**
       * clave unica de servicio
       */
       private String cus;
       
       /**
       * fecha generacion
       */
       private String fechaGeneracion;
       
       /**
       * fecha vigencia
       */
       private String fechaVigencia;
       
       /**
       * resultado operacion
       */
       private String resultadoOperacion;
       
       /**
       * diagnostico procesar
       */
       private String diagnosticoProcesar;

       /**
       * @return the folioServicio
       */
       public String getFolioServicio() {
             return folioServicio;
       }

       /**
       * @param folioServicio the folioServicio to set
       */
       public void setFolioServicio(String folioServicio) {
             this.folioServicio = folioServicio;
       }

       /**
       * @return the fechaRecepNotificacion
       */
       public String getFechaRecepNotificacion() {
             return fechaRecepNotificacion;
       }

       /**
       * @param fechaRecepNotificacion the fechaRecepNotificacion to set
       */
       public void setFechaRecepNotificacion(String fechaRecepNotificacion) {
             this.fechaRecepNotificacion = fechaRecepNotificacion;
       }

       /**
       * @return the cus
       */
       public String getCus() {
             return cus;
       }

       /**
       * @param cus the cus to set
       */
       public void setCus(String cus) {
             this.cus = cus;
       }

       /**
       * @return the fechaGeneracion
       */
       public String getFechaGeneracion() {
             return fechaGeneracion;
       }

       /**
       * @param fechaGeneracion the fechaGeneracion to set
       */
       public void setFechaGeneracion(String fechaGeneracion) {
             this.fechaGeneracion = fechaGeneracion;
       }

       /**
       * @return the fechaVigencia
       */
       public String getFechaVigencia() {
             return fechaVigencia;
       }

       /**
       * @param fechaVigencia the fechaVigencia to set
       */
       public void setFechaVigencia(String fechaVigencia) {
             this.fechaVigencia = fechaVigencia;
       }

       /**
       * @return the resultadoOperacion
       */
       public String getResultadoOperacion() {
             return resultadoOperacion;
       }

       /**
       * @param resultadoOperacion the resultadoOperacion to set
       */
       public void setResultadoOperacion(String resultadoOperacion) {
             this.resultadoOperacion = resultadoOperacion;
       }

       /**
       * @return the diagnosticoProcesar
       */
       public String getDiagnosticoProcesar() {
             return diagnosticoProcesar;
       }

       /**
       * @param diagnosticoProcesar the diagnosticoProcesar to set
       */
       public void setDiagnosticoProcesar(String diagnosticoProcesar) {
             this.diagnosticoProcesar = diagnosticoProcesar;
       }
       
       /* (non-Javadoc)
       * @see java.lang.Object#toString()
       */
       @Override
       public String toString() {
             StringBuilder builder = new StringBuilder();
             builder.append("DatosCusDia [folioServicio=");
             builder.append(folioServicio);
             builder.append(", fechaRecepNotificacion=");
             builder.append(fechaRecepNotificacion);
             builder.append(", cus=");
             builder.append(cus);
             builder.append(", fechaGeneracion=");
             builder.append(fechaGeneracion);
             builder.append(", fechaVigencia=");
             builder.append(fechaVigencia);
             builder.append(", resultadoOperacion=");
             builder.append(resultadoOperacion);
             builder.append(", diagnosticoProcesar=");
             builder.append(diagnosticoProcesar);
             builder.append("]");
             return builder.toString();
       }
       

}
