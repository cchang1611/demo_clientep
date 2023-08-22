package mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.controladores;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteSubProceso;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.RolReporteTipo;
import mx.com.procesar.aplicaciones.traspasos.pulssar.persistencia.entidades.SolicitudReporte;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.ParametrosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.constantes.PresentacionConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.excepciones.PlataformaOperativaWebException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo.CombosCatalogosPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.PlataformaOperativaExcelUtil;
import mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.utilerias.PlataformaOperativaJasperUtil;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.BitacoraService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.DirectorioUsuarioService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ParametroOperativoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.PlataformaOperativaService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteGenericoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteProcesoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteSubProcesosService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.ReporteTipoService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.RolesReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.SolicitudReporteService;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.PlataformaOperativaConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.constantes.ServiciosConstants;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.excepciones.PlataformaServiciosOperativaServiceException;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosConsultaPlataformaServicios;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosEntradaToken;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ReporteCompleto;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaExcel;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaJson;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.RespuestaPdfPlataformaOperativa;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.Rol;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.CadenasUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.FechaUtils;
import mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.utilerias.PlataformaOperativaUtil;

/**
 * Controlador para generacion de reportes online
 * @author Oscar Enrique González García (oegonzal@inet.procesar.com.mx)
 * @version 1.0
 * @since 03/01/2020, 09:05:50
 */
@Controller
@RequestMapping(value = { "/private" })
public class PlataformaOperativaController {

    /**
     * Log de la clase
     */
    private static final Logger LOG = LoggerFactory.getLogger(PlataformaOperativaController.class);

    /**
     * Instancia a la utilería de exceles.
     */
    @Autowired
    private PlataformaOperativaExcelUtil plataformaOperativaExcelUtil;

    /**
     * Instancia a utilceria de Reportes Jasper
     */
    @Autowired
    private PlataformaOperativaJasperUtil plataformaOperativaJasperUtil;

    /**
     * Servicio de solicitud de reporte
     */
    @Autowired
    private ReporteGenericoService reporteGenericoService;

    /**
     * Servicio de consulta de datos del usuario
     */
    @Autowired
    private DirectorioUsuarioService directorioUsuarioService;

    /**
     * Servicio para obtener el subprocesos por idRol y idproceso.
     */
    @Autowired
    private ReporteSubProcesosService reporteSubProcesoService;

    /**
     * Servicio para obtener el tipo de reporte por idRol y idSubproceso.
     */
    @Autowired
    private ReporteTipoService reporteTipoService;

    /**
     * Servicio para obtener los reportes genericos por idModulo y idReporteGenerico.
     */
    @Autowired
    private ReporteProcesoService reporteProcesoService;

    /**
     * Servicio para obtener los módulos por idRol.
     */
    @Autowired
    private RolesReporteService rolesReporteService;

    /**
     * Servicio de la plataforma operativa
     */
    @Autowired
    private PlataformaOperativaService plataformaOperativaService;

    /**
     * Referencia al servicio de consulta de solicitudes
     */
    @Autowired
    private SolicitudReporteService solicitudReporteService;

    /**
     * Utileria general de la plataforma de servicios
     */
    @Autowired
    private PlataformaOperativaUtil plataformaOperativaUtil;

    /**
     * Utileria de conversion de fechas
     */
    @Autowired
    private FechaUtils fechaUtils;

    /**
     * Referencia a servicio de bitacora
     */
    @Autowired
    private BitacoraService bitacoraService;

    /**
     * Referencia a parametro operativo service
     */
    @Autowired
    private ParametroOperativoService parametroOperativoService;

    /**
     * Referencia para clase de utileria
     */
    @Autowired
    private CadenasUtils cadenasUtils;

    /**
     * Método que da acceso al sistema Plataforma de Servicios Operativos
     * @author Oscar Enrique González García (oegonzal@inet.procesar.com.mx)
     * @param request
     * @param model
     * @return Cadena correpondiente al mapping del incio de la plataforma de servicio
     */
    @RequestMapping(value = { "/plataforma-operativa.do" }, method = RequestMethod.GET)
    public String iniciaPlataformaServicios(HttpServletRequest request, Model model) {
        LOG.info("Ingresando a Plataforma de servicios operativos");
        model.addAttribute(PresentacionConstants.PLATAFORMA_OPERATIVA_FORM, new DatosConsultaPlataformaServicios());
        UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
        LOG.info("Recuperando info de usuario -> {} {}", user.getSoloNombre(), user.getAforeUsuario());
        String roles = directorioUsuarioService.consultarRolesOID(user.getUsuario());
        model.addAttribute("employeeType", directorioUsuarioService.obtenerEmployeeType(user.getUsuario()));
        model.addAttribute("roles", roles);
        List<String> listaidRoles = new ArrayList<>();
        for (Rol idRoles : user.getRoles()) {
            listaidRoles.add(idRoles.getClaveRol());
        }

        model.addAttribute(PresentacionConstants.ID_ROLES, listaidRoles);
        LOG.info("Obtiene lista Roles {}", listaidRoles);
        return PresentacionConstants.PLATAFORMA_OPERATIVA;
    }

    /**
     * Prueba redireccion a pantalla SICI
     * @param request
     * @param model
     * @param idReporte
     * @return Clase que envuelve el resultado del servicio
     * @throws IOException
     */
    @GetMapping(value = "/plataforma-operativa/consultaDetallada")
    public ResponseEntity<RespuestaJson> consultaDetallada(HttpServletRequest request, Model model, @Param("idReporte") String idReporte) throws IOException {
        LOG.info("Ingresando a consulta detallada");
        UsuarioLogin user = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
        String roles = directorioUsuarioService.consultarRolesOID(user.getUsuario());
        model.addAttribute("employeeType", directorioUsuarioService.obtenerEmployeeType(user.getUsuario()));
        model.addAttribute("roles", roles);
        RespuestaJson respuesta = new RespuestaJson();

        StringBuilder token = new StringBuilder();
        token.append(idReporte).append(new Date().getTime());
        LOG.info("Token generado after-> {}", token);

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", user.getSoloNombre());
        parametros.put("cveAfore", user.getAforeUsuario());
        parametros.put("apellidoPaterno", user.getApellidoPaterno());
        parametros.put("apellidoMaterno", user.getApellidoMaterno());
        parametros.put("idUsuario", "");
        String tipoEntidad = plataformaOperativaUtil.convertirClaveRolATipoEntidad(user.getRoles());
        parametros.put("tipoEntidad", tipoEntidad);
        parametros.put("usuarioModificador", user.getUsuario());
        parametros.put("politicas", "1");
        parametros.put("area", user.getAforeUsuario());
        parametros.put("fechaUltimoLogin", fechaUtils.convertirFechaACadena(new Date(), PlataformaOperativaConstants.FORMATO_FECHA_SICI));
        parametros.put("fechaAlta", fechaUtils.convertirFechaACadena(new Date(), PlataformaOperativaConstants.FORMATO_FECHA_SICI_GUION));
        parametros.put("primeraVez", "1");
        parametros.put("usuarioActivo", user.getEstatus());

        ObjectMapper maper = new ObjectMapper();
        String jsonParametros = maper.writeValueAsString(parametros);

        LOG.info("Parametro Operativo JSON {}", jsonParametros);

        try {
            DatosEntradaToken datosToken = new DatosEntradaToken();
            datosToken.setJsonUsuario(jsonParametros);
            datosToken.setToken(token.toString());
            datosToken.setUsuarioModificador(user.getUsuario());
            RespuestaJson resultado = parametroOperativoService.guardarTokenUsuario(datosToken);
            respuesta.setDatos(resultado.getDatos());
            respuesta.setExito(PresentacionConstants.RESPUESTA_EXITO);
        } catch(Exception e) {
            LOG.error("Error al redireccionar reporte", e);
            respuesta.setDatos(null);
            respuesta.setExito(PresentacionConstants.RESPUESTA_ERROR);
            respuesta.setMensaje(PresentacionConstants.MSG_ERROR_CONSULTA_INFORMACION);
        }
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    /**
     * Metodo que obtiene el catálogo de módulos.
     * @author Oscar Enrique González García (oegonzal@inet.procesar.com.mx)
     * @param request
     * @param model
     * @return Clase que envuelve la respuesta del servicio
     * @since 03/01/2020, 09:05:32
     */
    @RequestMapping(value = "/plataforma-operativa/obtenerModulos", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<RespuestaJson> obtenerModulos(HttpServletRequest request, Model model) {
        RespuestaJson respuesta = new RespuestaJson();
        CombosCatalogosPlataformaServicios combos = new CombosCatalogosPlataformaServicios();
        try {
            String idRoles = request.getParameter(PresentacionConstants.ID_ROLES);
            String idsModulos = request.getParameter(PresentacionConstants.AREAS);
            LOG.info("listaModulos {}", idsModulos);
            List<String> listaRoles;
            listaRoles = Arrays.asList(idRoles);
            LOG.info("listaRoles {}", listaRoles);
            List<RolReporte> modulos;
            modulos = new ArrayList<>(consultarListaModulos(idRoles));

            LOG.info("el tamaño de la lista modulos es {} ", modulos.size());
            if (!modulos.isEmpty()) {
                List<String> listaModulosAsignados = plataformaOperativaUtil.convertirCadenaALista(idsModulos);
                request.getSession().setAttribute(PresentacionConstants.MODULOS_USUARIO, idsModulos);
                plataformaOperativaUtil.eliminarModulosNoPermitidos(modulos, listaModulosAsignados);
                combos.setModulos(new ArrayList<>(modulos));
                combos.setProcesos(null);
                combos.setSubprocesos(null);
                combos.setTiposReporte(null);
                combos.setReporteGenerico(null);
                respuesta.setDatos(combos);
                respuesta.setExito(PresentacionConstants.RESPUESTA_EXITO);
            } else {
                respuesta.setDatos(null);
                respuesta.setExito(PresentacionConstants.RESPUESTA_ERROR);
                respuesta.setMensaje("El catálogo de Módulos está vacío.");
            }
        } catch(Exception e) {
            LOG.error("Error al obtener lista de modulos: {}", e);
            respuesta.setDatos(null);
            respuesta.setExito(PresentacionConstants.RESPUESTA_ERROR);
            respuesta.setMensaje(PresentacionConstants.MSG_ERROR_CONSULTA_INFORMACION);
        }

        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    /**
     * @param idRoles Identificador de los roles de usuario
     * @return Conjunto de roles del reporte
     * @throws PlataformaServiciosOperativaServiceException Método que va cargando los roles a
     *         una lista.
     */
    public Set<RolReporte> consultarListaModulos(String idRoles) throws PlataformaServiciosOperativaServiceException {
        List<String> listaRoles;
        listaRoles = Arrays.asList(idRoles.split(","));
        LOG.info("listaRoles {}", listaRoles);
        Set<RolReporte> modulos = new HashSet<>();
        for (String idRol : listaRoles) {
            idRol = cadenasUtils.eliminarCorchetes(idRol);
            LOG.info("idRol {}", idRol);
            modulos.addAll(rolesReporteService.obtenerIdModuloReporte(idRol));
        }
        return modulos;
    }

    /**
     * Método que va cargando los combos.
     * @author Hector Joaquin Ramirez Ortiz (hjramire@inet.procesar.com.mx)
     * @param request
     * @param model
     * @param idRoles
     * @param idModulo
     * @param idProceso
     * @param idSubProceso
     * @param idTipoConsulta
     * @return Objeto que envuelve la respuesta del servicio
     */
    @RequestMapping(value = "/plataforma-operativa/obtenerReportes", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<RespuestaJson> getTipoReporte(HttpServletRequest request, Model model,
        @RequestParam(name = PresentacionConstants.ID_ROLES, required = false) String idRoles,
        @RequestParam(name = PresentacionConstants.ID_MODULO, required = false) String idModulo,
        @RequestParam(name = PresentacionConstants.ID_PROCESO, required = false) String idProceso,
        @RequestParam(name = PresentacionConstants.ID_SUB_PROCESO, required = false) String idSubProceso,
        @RequestParam(name = PresentacionConstants.ID_TIPO_CONSULTA, required = false) String idTipoConsulta) {
        RespuestaJson respuesta = new RespuestaJson();
        CombosCatalogosPlataformaServicios combos = new CombosCatalogosPlataformaServicios();
        try {
            String modulosAsignados = (String) request.getSession().getAttribute(PresentacionConstants.MODULOS_USUARIO);
            if (null != idModulo) {
                List<RolReporteProceso> idProcesoNegocio = reporteProcesoService.recuperaIdProcesoNegocios(idRoles, Long.parseLong(idModulo), modulosAsignados);
                combos.setProceso(idProcesoNegocio);
                LOG.info("combos.setProcesos(procesos);   {}", idProcesoNegocio);
            }
            if (idProceso != null) {
                List<RolReporteSubProceso> subproceso = reporteSubProcesoService.recuperarSubprocesosPorIdProceso(idRoles, Long.parseLong(idProceso));
                combos.setSubproceso(subproceso);
                LOG.info("combos.setProcesos(subProcesos);   {}", subproceso);

                List<RolReporteTipo> tipoReporte;
                for (RolReporteSubProceso idSubProcesoInterno : subproceso) {
                    tipoReporte = reporteTipoService.recuperarTipoDeReporteIdSubproceso(idRoles, idSubProcesoInterno.getIdSubProceso());
                    combos.setTipoReporte(tipoReporte);
                }
            }
            if (idSubProceso != null && idTipoConsulta != null) {
                if (PresentacionConstants.CERO_CADENA.equals(idTipoConsulta)) {
                    List<ReporteCompleto> reporteCompleto = reporteGenericoService.obtenerListaReportesPorSubprocesoTipoReporte(Long.parseLong(idSubProceso),
                        new Long(idTipoConsulta), PresentacionConstants.INT_BANDERA_SERVICIO_LINEA, idRoles);
                    combos.setReporteCompleto(reporteCompleto);
                } else {
                    List<ReporteCompleto> reporteCompleto = reporteGenericoService.obtenerListaReportesPorSubprocesoTipoReporte(Long.parseLong(idSubProceso),
                        Long.parseLong(idTipoConsulta), PresentacionConstants.INT_BANDERA_SERVICIO_LINEA, idRoles);
                    combos.setReporteCompleto(reporteCompleto);
                }
            }

        } catch(Exception e) {
            LOG.error("Error al obtener lista de reportes: {}", e);
            respuesta.setDatos(null);
            respuesta.setExito(PresentacionConstants.RESPUESTA_ERROR);
            respuesta.setMensaje(PresentacionConstants.MSG_ERROR_CONSULTA_INFORMACION);
        }
        respuesta.setDatos(combos);
        respuesta.setExito(PresentacionConstants.RESPUESTA_EXITO);

        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    /**
     * Método que consulta el tipo de reporte seleccionado.
     * @author Oscar Enrique González García (oegonzal@inet.procesar.com.mx)
     * @param request
     * @param nombreReporte
     * @param fechaInicio
     * @param fechaFin
     * @param nss
     * @param curp
     * @param idProcesar
     * @return Objeto que envuelve el la respuesta del servicio
     */
    @RequestMapping(value = "/plataforma-operativa/consultaReporte", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<RespuestaJson> consultaReporte(HttpServletRequest request,
        @RequestParam(name = PresentacionConstants.NOMBRE_REPORTE, defaultValue = "") String nombreReporte,
        @RequestParam(name = PresentacionConstants.FECHA_INICIAL) String fechaInicio,
        @RequestParam(name = PresentacionConstants.FECHA_FINAL, defaultValue = "") String fechaFin,
        @RequestParam(name = PresentacionConstants.NSS, defaultValue = "") String nss,
        @RequestParam(name = PresentacionConstants.CURP, defaultValue = "") String curp,
        @RequestParam(name = PresentacionConstants.ID_PROCESAR, defaultValue = "") String idProcesar) {
        ResponseEntity<RespuestaJson> retorno = null;
        RespuestaJson respuestaJson = new RespuestaJson();
        UsuarioLogin usuarioLogueado = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);

        try {
            retorno = plataformaOperativaService.consultaReporte(usuarioLogueado.getUsuario(), nombreReporte, fechaInicio, fechaFin, nss, curp, idProcesar);
            if (retorno != null && (PresentacionConstants.RESPUESTA_EXITO.equals(retorno.getBody().getExito()))) {
                request.getSession().setAttribute(PresentacionConstants.RESPUESTA1, retorno.getBody().getRespuestaSesion().getRespuestaExcel());
                return new ResponseEntity<>(retorno.getBody(), HttpStatus.OK);
            } else {
                respuestaJson.setExito(PresentacionConstants.RESPUESTA_ERROR);
                respuestaJson.setDatos(null);
                respuestaJson.setMensaje(PresentacionConstants.MSG_CONSULTA_SIN_INFORMACION);

                return new ResponseEntity<>(respuestaJson, HttpStatus.OK);
            }

        } catch(Exception e) {
            respuestaJson.setExito(PresentacionConstants.RESPUESTA_ERROR);
            respuestaJson.setDatos(null);
            respuestaJson.setMensaje("Ocurrio un error al recuperar la informacion solicitada.");
            LOG.error("Error al consultar el reporte", e);
            return new ResponseEntity<>(respuestaJson, HttpStatus.OK);
        }
    }

    /**
     * Método que inicia la exportación en Excel del reporte.
     * @author Oscar Enrique González García (oegonzal@inet.procesar.com.mx)
     * @param request
     * @param response
     */
    @RequestMapping(value = "/plataforma-operativa/descargaReporte", method = RequestMethod.GET)
    @ResponseBody
    public void decargaReporte(HttpServletRequest request, HttpServletResponse response) {

        StringBuilder nombreArchivo = new StringBuilder();

        RespuestaExcel respuestaExcel = (RespuestaExcel) request.getSession().getAttribute(PresentacionConstants.RESPUESTA1);

        nombreArchivo.append(respuestaExcel.getNombreReporte().replace(" ", "_"));

        String strFechaAtual = fechaUtils.convertirFechaACadena(new Date(), PresentacionConstants.FORMATO_FECHA_JASPER);

        LOG.info("fechaCadena: {}", strFechaAtual);

        nombreArchivo.append(strFechaAtual.replace(" ", "_"));
        nombreArchivo.append(PresentacionConstants.EXTENSION_XLS);

        response.setContentType(PresentacionConstants.CONTENT_TYPE_XLS);
        response.setHeader(PresentacionConstants.CONTENT_DISPOSITION, PresentacionConstants.ATTACHMENT.concat(nombreArchivo.toString()));
        response.setHeader(PresentacionConstants.SET_COOKIE, PresentacionConstants.FILE_DOWNLOAD_PATH_COOKIE);
        try(BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {

            HSSFWorkbook workbook = plataformaOperativaExcelUtil.exportaExcel(respuestaExcel);
            if (workbook instanceof HSSFWorkbook) {
                workbook.write(response.getOutputStream());
                response.getOutputStream().flush();
                response.getOutputStream().close();
            }
            output.write(respuestaExcel.getConsulta().getBytes());
            bitacoraService.actualizarBanderaExportacion(respuestaExcel.getBitacoraReporte(), 1);
        } catch(Exception exception) {
            LOG.error("Ocurrió un error al intentar descargar el Excel: ", exception);
        } finally {
            respuestaExcel.setConsulta(null);
        }
    }

    /**
     * Metodo que recupera la informacion de acuerdo al reporte seleccionado
     * @author hjramire
     * @param request
     * @param nombreReporte
     * @return ResponseEntity<Object>
     * @since 16/01/2020, 19:55:18
     */
    @RequestMapping(value = "/plataforma-operativa/consultaReporteJasper", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<RespuestaJson> consultaReporteJasper(HttpServletRequest request,
        @RequestParam(name = PresentacionConstants.NOMBRE_REPORTE, defaultValue = "") String nombreReporte) {
        ResponseEntity<RespuestaJson> retorno;

        Map<String, String> params = new HashMap<>();
        for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            String name = entry.getKey();
            String value = entry.getValue()[0];
            params.put(name, value);
        }
        UsuarioLogin usuarioLogueado = (UsuarioLogin) request.getSession().getAttribute(ParametrosConstants.ADMIN_PANTALLA);
        params.put(ServiciosConstants.USUARIO_LOGUEADO, usuarioLogueado.getUsuario());
        retorno = plataformaOperativaService.consultaReporteJasper(params);
        if (PresentacionConstants.RESPUESTA_EXITO.equals(retorno.getBody().getExito())) {
            request.getSession().setAttribute(PresentacionConstants.RESPUESTA_JASPER,
                retorno.getBody().getRespuestaSesion().getRespuestaPdfPlataformaOperativa());
            return new ResponseEntity<>(retorno.getBody(), retorno.getStatusCode());
        } else {
            return new ResponseEntity<>(retorno.getBody(), retorno.getStatusCode());
        }
    }

    /**
     * Metodo que realiza la generacion de reporte con plantilla de Jasper
     * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/plataforma-operativa/descargaReportePlantilla")
    @ResponseBody
    public void exportaReporteGenericoPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fechaActual = fechaUtils.convertirFechaACadena(new Date(), PresentacionConstants.FORMATO_FECHA_JASPER);
        RespuestaPdfPlataformaOperativa respuestaExport =
            (RespuestaPdfPlataformaOperativa) request.getSession().getAttribute(PresentacionConstants.RESPUESTA_JASPER);

        StringBuilder nombreArchivo = new StringBuilder();
        nombreArchivo.append(respuestaExport.getReporte().getReporte().getNombreReporte().toUpperCase())
            .append("_")
            .append(fechaActual)
            .append(PresentacionConstants.EXTENSION_XLS);
        response.setContentType(PresentacionConstants.CONTENT_TYPE_XLS);
        response.setHeader(PresentacionConstants.CONTENT_DISPOSITION, PresentacionConstants.ATTACHMENT.concat(nombreArchivo.toString()));
        response.setHeader(PresentacionConstants.SET_COOKIE, PresentacionConstants.FILE_DOWNLOAD_PATH_COOKIE);
        response.getOutputStream();
        response.flushBuffer();

        try(BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream())) {
            plataformaOperativaJasperUtil.generaReporteConPlatilla(request, output, respuestaExport, nombreArchivo.toString(), response.getOutputStream());
            bitacoraService.actualizarBanderaExportacion(respuestaExport.getBitacoraReporte(), 1);
        } catch(Exception ex) {
            LOG.error("Ocurrió un error al intentar descargar el Reporte.", ex);
            response.sendError(PresentacionConstants.ENTERO_ERROR_DESCARGA_ARCHIVO_303, "Ocurrió un error al intentar descargar el Reporte");
        }
    }

    /**
     * Metodo que permite la descarga de archivos correspondientes a un reporte masivo
     * @author VHERNAND
     * @param request peticion recibida con los parametros necesarios para la descarga
     * @param response respuesta con el outputstream del archivo a ser descargado
     * @param idSolicitudReporte
     * @param numeroSolicitud
     */
    @GetMapping(value = "/plataforma-operativa/descargaReporteMasivo")
    public void descargarArchivo(HttpServletRequest request, HttpServletResponse response, @RequestParam("idSolicitudReporte") Long idSolicitudReporte,
        @RequestParam("numeroSolicitud") String numeroSolicitud) {
        LOG.info("Ingresando a descargar reporte masivo");
        try {
            LOG.info("idSolicitudReporte {}", idSolicitudReporte);
            if (idSolicitudReporte != null && response != null) {
                SolicitudReporte informacionSolicitud = solicitudReporteService.recuperarSolicitudPorId(idSolicitudReporte);
                if (numeroSolicitud != null && numeroSolicitud.equals(informacionSolicitud.getNumeroSolicitud())) {
                    String path = informacionSolicitud.getRutaArchivoReporte() + informacionSolicitud.getNombreArchivoReporte();
                    obtenerArchivoRespuesta(path, response, informacionSolicitud.getNombreArchivoReporte());
                    LOG.info("El archivo se descargo correctamente");
                    // Registrar movimiento en bitacora
                    bitacoraService.actualizarBanderaExportacion(informacionSolicitud.getIdBitacora(), 1);
                    LOG.info("El archivo descargado {}, se ha eliminado del FileSystem", path);
                    FileUtils.deleteQuietly(new File(path));
                } else {
                    LOG.info("No se enocontro la informacion del reporte");
                }
            }
        } catch(Exception e) {
            LOG.error("|Ocurrio un error al intentar obtener la informacion del archivo|", e);
        }
    }

    /**
     * Metodo que permite cargar en el objeto de sesion el archivo a descargar
     * @author HECTOR JOAQUIN RAMIREZ ORTIZ (HJRAMIRE@procesar.com.mx)
     * @param path
     * @param response
     * @param nombreArchivo
     * @throws PlataformaOperativaWebException
     */
    private void obtenerArchivoRespuesta(String path, HttpServletResponse response, String nombreArchivo) throws PlataformaOperativaWebException {
        try(InputStream inputStream = new FileInputStream(path)) {
            response.setContentType(PresentacionConstants.CONTENT_TYPE);
            response.setHeader(PresentacionConstants.SET_COOKIE, PresentacionConstants.FILE_DOWNLOAD_PATH_COOKIE);
            response.setHeader(PresentacionConstants.CONTENT_DISPOSITION, PresentacionConstants.ATTACHMENT.concat(nombreArchivo));
            FileCopyUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch(Exception io) {
            throw new PlataformaOperativaWebException("|Ocurrio un error al intentar descargar el archivo de Reportes|", io);
        }
    }
}