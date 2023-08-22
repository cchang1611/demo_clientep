package mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Representa la entidad de Menu Pagina, mapeado a la tabla PSER_TC_MENU_PAGINA
 * @author SRUBALCA
 */
@Entity
@Table(name = "PSER_TC_MENU_PAGINA")
public class MenuPagina implements Serializable{

	/**
	 * Serial de la clase
	 */
	private static final long serialVersionUID = 4302738039778258364L;
	
	/**
	 * Identificador del menu.
	 */
	@Id
	@Column(name = "ID_MENU_PAGINA")
	private Long identificadorMenu;
	
	/**
	 * Identificador de la pagina.
	 */
	@Id
	@Column(name = "NU_PAGINA__PRINCIPAL")
	private Long paginaPrincipal;	
	
	/**
	 * Ruta del submenu.
	 */
	@Column(name = "CH_RUTA")
	private String chRutaMenu;
	
	/**
	 * Nombre del menu.
	 */
	@Column(name = "CH_DESC_MENU_PAGINA")
	private String chDescMenuPagina;
	
	/**
	 * Imagen del menu.
	 */
	@Column(name = "CH_IMAGEN")
	private String chImagen;
	
	/**
	 * Fecha de ultima modificacion.
	 */
	@Column(name = "FC_CONTROL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fcControl;
	
	/**
	 * Usuario Modificador.
	 */
	@Column(name = "CH_USUARIO_MODIFICADOR")
	private String chUsuarioModificador;

	/**
	 * @return the identificadorMenu
	 */
	public Long getIdentificadorMenu() {
		return identificadorMenu;
	}

	/**
	 * @param identificadorMenu the identificadorMenu to set
	 */
	public void setIdentificadorMenu(Long identificadorMenu) {
		this.identificadorMenu = identificadorMenu;
	}

	/**
	 * @return the paginaPrincipal
	 */
	public Long getPaginaPrincipal() {
		return paginaPrincipal;
	}

	/**
	 * @param paginaPrincipal the paginaPrincipal to set
	 */
	public void setPaginaPrincipal(Long paginaPrincipal) {
		this.paginaPrincipal = paginaPrincipal;
	}

	/**
	 * @return the chRutaMenu
	 */
	public String getChRutaMenu() {
		return chRutaMenu;
	}

	/**
	 * @param chRutaMenu the chRutaMenu to set
	 */
	public void setChRutaMenu(String chRutaMenu) {
		this.chRutaMenu = chRutaMenu;
	}

	/**
	 * @return the chDescMenuPagina
	 */
	public String getChDescMenuPagina() {
		return chDescMenuPagina;
	}

	/**
	 * @param chDescMenuPagina the chDescMenuPagina to set
	 */
	public void setChDescMenuPagina(String chDescMenuPagina) {
		this.chDescMenuPagina = chDescMenuPagina;
	}

	/**
	 * @return the chImagen
	 */
	public String getChImagen() {
		return chImagen;
	}

	/**
	 * @param chImagen the chImagen to set
	 */
	public void setChImagen(String chImagen) {
		this.chImagen = chImagen;
	}

	/**
	 * @return the fcControl
	 */
	public Date getFcControl() {
		return fcControl;
	}

	/**
	 * @param fcControl the fcControl to set
	 */
	public void setFcControl(Date fcControl) {
		this.fcControl = fcControl;
	}

	/**
	 * @return the chUsuarioModificador
	 */
	public String getChUsuarioModificador() {
		return chUsuarioModificador;
	}

	/**
	 * @param chUsuarioModificador the chUsuarioModificador to set
	 */
	public void setChUsuarioModificador(String chUsuarioModificador) {
		this.chUsuarioModificador = chUsuarioModificador;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuPagina [");
		if (identificadorMenu != null) {
			builder.append("identificadorMenu=");
			builder.append(identificadorMenu);
			builder.append(", ");
		}
		if (paginaPrincipal != null) {
			builder.append("paginaPrincipal=");
			builder.append(paginaPrincipal);
			builder.append(", ");
		}
		if (chRutaMenu != null) {
			builder.append("chRutaMenu=");
			builder.append(chRutaMenu);
			builder.append(", ");
		}
		if (chDescMenuPagina != null) {
			builder.append("chDescMenuPagina=");
			builder.append(chDescMenuPagina);
			builder.append(", ");
		}
		if (chImagen != null) {
			builder.append("chImagen=");
			builder.append(chImagen);
			builder.append(", ");
		}
		if (fcControl != null) {
			builder.append("fcControl=");
			builder.append(fcControl);
			builder.append(", ");
		}
		if (chUsuarioModificador != null) {
			builder.append("chUsuarioModificador=");
			builder.append(chUsuarioModificador);
		}
		builder.append("]");
		return builder.toString();
	}
}
