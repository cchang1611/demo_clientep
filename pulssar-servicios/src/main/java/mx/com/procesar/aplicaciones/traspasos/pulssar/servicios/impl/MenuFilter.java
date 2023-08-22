package mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.impl;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.RegistroUsuarioConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;



/**
 * Filtro que controla el boton menu mediante la validacion si el trabjador pertenece a la misma afore
 * @author jmordone
 *
 */
public class MenuFilter implements Filter {
	
	/**
	 * modulos a validar
	 */
	private static final String MODULOS="amenu.do,reimpresionDocumento.do,datosIcefas.do,datosSaldos.do,historialTramites.do";
	
	/**
	 * Aplication context
	 */
	@SuppressWarnings("unused")
	private AnnotationConfigWebApplicationContext context;
	
   /**
    * constructor
    * @param context
   */
	public MenuFilter(AnnotationConfigWebApplicationContext context){
		this.context = context;

	}
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(MenuFilter.class);

	/**
	 * init
	 * @param filterConfig
	 * @throws ServletException
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {	
		logger.info("Metodo init filtro menu");
	}

	/**
	 * doFilter
	 * @param req
	 * @param resp
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		    HttpServletRequest request = (HttpServletRequest) req;
		    HttpServletResponse response = (HttpServletResponse) resp;
	    	String requestURI = request.getRequestURI();   
	    	Boolean accesoMenu=null;
	    	if(request.getSession().getAttribute(ServiciosConstants.BANDERA_AFORE_DIFERENTE)!=null) {
	    		 accesoMenu= (Boolean) request.getSession().getAttribute(ServiciosConstants.BANDERA_AFORE_DIFERENTE);
	    	}
		  
		    if(!validaExistenciaModulo(requestURI)) {
		    	 chain.doFilter(req, resp);	 
		    }else {
		    	if(accesoMenu==null) {
				    request.getSession().removeAttribute(ServiciosConstants.BANDERA_AFORE_DIFERENTE);
			    	redireccionar(request, response,ServiciosConstants.CONSULTA_PRINCIPAL);
	    		}else {
	    			if(!accesoMenu) {
	    				request.getSession().removeAttribute(ServiciosConstants.BANDERA_AFORE_DIFERENTE);		
	    				redireccionar(request, response,ServiciosConstants.CONSULTA_PRINCIPAL);			    		
	    			}else {
	    				 chain.doFilter(req, resp);	
	    			}
	    		}
		    }
	}

	/**
	 * destroy
	 */
	@Override
	public void destroy() {
		logger.info("Metodo destroy en filter");
		
	}
	
	/**
	 * validaExistenciaModulo
	 * @param url
	 * @return
	 */
	private Boolean validaExistenciaModulo(String url) {
		Boolean existeModulo=Boolean.FALSE;
		String[] modulos=MODULOS.split(RegistroUsuarioConstants.COMA);
		for (String modulo : modulos) {
			if(url.contains(modulo)) {
				existeModulo=Boolean.TRUE;
				break;
			}
		}
		return existeModulo;
		
	}

	/**
	 * redireccionar
	 * @param request
	 * @param response
	 * @param url
	 * @throws ServletException
	 * @throws IOException
	 */
	private void redireccionar(HttpServletRequest request,HttpServletResponse response,String url) throws ServletException, IOException {
		String urlNueva = url.replace(request.getContextPath(), "");
		request.getRequestDispatcher(urlNueva).forward(request, response);
	}
	
}