package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author HUCGARZA
 *
 */
public class NotificacionTipoProcRetiro implements Serializable {

		/**
	 * Serial id
	 */
	private static final long serialVersionUID = -4824393374544679860L;
		/**
		 * id
		 */
		private Long idNotifTipoProcRetiro;
		/**
		 * 
		 */
		private String chFolio;
		/**
		 * 
		 */
		private String chTipoProceso;
		/**
		 * 
		 */
		private Long nuNotificado;
		/**
		 * 
		 */
		private Date fcNotificado;
		/**
		 * 
		 */
		private Date fcControl;
		/**
		 * 
		 */
		private String chUsuarioModificador;
		/**
		 * @return el atributo idNotifTipoProcRetiro
		 */
		public Long getIdNotifTipoProcRetiro() {
			return idNotifTipoProcRetiro;
		}
		/**
		 * @param idNotifTipoProcRetiro parametro idNotifTipoProcRetiro a actualizar
		 */
		public void setIdNotifTipoProcRetiro(Long idNotifTipoProcRetiro) {
			this.idNotifTipoProcRetiro = idNotifTipoProcRetiro;
		}
		/**
		 * @return el atributo chFolio
		 */
		public String getChFolio() {
			return chFolio;
		}
		/**
		 * @param chFolio parametro chFolio a actualizar
		 */
		public void setChFolio(String chFolio) {
			this.chFolio = chFolio;
		}
		/**
		 * @return el atributo chTipoProceso
		 */
		public String getChTipoProceso() {
			return chTipoProceso;
		}
		/**
		 * @param chTipoProceso parametro chTipoProceso a actualizar
		 */
		public void setChTipoProceso(String chTipoProceso) {
			this.chTipoProceso = chTipoProceso;
		}
		/**
		 * @return el atributo nuNotificado
		 */
		public Long getNuNotificado() {
			return nuNotificado;
		}
		/**
		 * @param nuNotificado parametro nuNotificado a actualizar
		 */
		public void setNuNotificado(Long nuNotificado) {
			this.nuNotificado = nuNotificado;
		}
		/**
		 * @return el atributo fcNotificado
		 */
		public Date getFcNotificado() {
			return fcNotificado;
		}
		/**
		 * @param fcNotificado parametro fcNotificado a actualizar
		 */
		public void setFcNotificado(Date fcNotificado) {
			this.fcNotificado = fcNotificado;
		}
		/**
		 * @return el atributo fcControl
		 */
		public Date getFcControl() {
			return fcControl;
		}
		/**
		 * @param fcControl parametro fcControl a actualizar
		 */
		public void setFcControl(Date fcControl) {
			this.fcControl = fcControl;
		}
		/**
		 * @return el atributo chUsuarioModificador
		 */
		public String getChUsuarioModificador() {
			return chUsuarioModificador;
		}
		/**
		 * @param chUsuarioModificador parametro chUsuarioModificador a actualizar
		 */
		public void setChUsuarioModificador(String chUsuarioModificador) {
			this.chUsuarioModificador = chUsuarioModificador;
		}
		/* La documentación de este método se encuentra en la clase o interface que
		 * lo declara  (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("NotificacionTipoProcRetiro [idNotifTipoProcRetiro=");
			builder.append(idNotifTipoProcRetiro);
			builder.append(", chFolio=");
			builder.append(chFolio);
			builder.append(", chTipoProceso=");
			builder.append(chTipoProceso);
			builder.append(", nuNotificado=");
			builder.append(nuNotificado);
			builder.append(", fcNotificado=");
			builder.append(fcNotificado);
			builder.append(", fcControl=");
			builder.append(fcControl);
			builder.append(", chUsuarioModificador=");
			builder.append(chUsuarioModificador);
			builder.append("]");
			return builder.toString();
		}
		
}
