<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <title>Menu</title>
  <meta charset="utf-8" />
  <![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
  <![endif]>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/afore/salarios_y_saldos.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/afore/ventana_modal.css'/>">
  
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
 	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Certificaci&oacute;n" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "2" />
	</jsp:include>

   <div class="Container">

    <div class="Title__Container">
      <h1>Certificaci&oacute;n</h1>
    </div>

    <div class="Container">

      <div class="Colum2">
        <div class="Title">
          <p></p>
        </div>
        <div class="Datos_Container">
          <div class="row_container">
            <div class="Datos"><strong>ENTIDAD DE ORIGEN:</strong> ${salida.entidadOrigen}</div>
            <div class="Datos"><strong>TIPO DE TRÁMITE:</strong> ${salida.tipoDeTramite}</div>
            <div class="Datos"><strong>NSS:</strong> ${salida.nss}</div>
            <div class="Datos"><strong>CURP:</strong> ${salida.curp}</div>
            <div class="Datos"><strong>NOMBRE TRABAJADOR IMSS:</strong> ${salida.nombreTrabajadorImss}</div>
            <div class="Datos"><strong>NOMBRE TRABAJADOR PROCANASE:</strong> ${salida.nombreTrabajadorProcanase}</div>
            <div class="Datos"><strong>NOMBRE TRABAJADOR:</strong> ${salida.nombreTrabajador}</div>
            <div class="Datos"><strong>APELLIDO PATERNO:</strong> ${salida.apellidoPaterno}</div>
            <div class="Datos"><strong>APELLIDO MATERNO:</strong> ${salida.apellidoMaterno}</div>
            
            <div class="Datos"><strong>TIPO DE PRESTACIÓN:</strong> ${salida.tipoDePrestacion}</div>
            <div class="Datos"><strong>FECHA DE MATRIMONIO DESEMPLEO:</strong> ${salida.fechaMatrimonioDesempleo}</div>
            <div class="Datos"><strong>FECHA NOTIFICACIÓN IMSS:</strong> ${salida.fechaNotificacionImss}</div>
            <div class="Datos"><strong>FECHA CONCLUSIÓN VIGENCIA:</strong> ${salida.fechaConclusionVigencia}</div>
            <div class="Datos"><strong>NÚMERO DE RESOLUCIÓN:</strong> ${salida.numeroResolucion}</div>
            <div class="Datos"><strong>DIAGNOSTICO CUENTA INDIVIDUAL:</strong> ${salida.descDiagnosticoCuentaIndividual}</div>
            <div class="Datos"><strong>TIPO DE TRABAJADOR APORTACIÓN CUOTA SOCIAL:</strong> ${salida.tipoTrabajadorAportacionCuotaSocial}</div>
            <div class="Datos"><strong>SBC TIPO A:</strong> ${salida.sbcTipoA}</div>
            <div class="Datos"><strong>SBC TIPO B:</strong> ${salida.sbcTipoB}</div>
            <div class="Datos"><strong>ID PAGO COMPLEMENTARIO:</strong> ${salida.idPagoComplementario}</div>
            <div class="Datos"><strong>MONTO PAGADO RETIRO ORIGINAL:</strong> ${salida.montoPagadoRetiroOriginal}</div>
            
            <div class="Datos"><strong>SALDO ANTERIOR PAGO RETIRO ORIGINAL:</strong> ${salida.saldoAnteriorPagoRetiroOriginal}</div>
            <div class="Datos"><strong>FOLIO OPERACIÓN IMSS:</strong> ${salida.folioOperacionIMSS}</div>
            <div class="Datos"><strong>DELEGACIÓN:</strong> ${salida.delegacion}</div>
            <div class="Datos"><strong>SUB DELEGACIÓN:</strong> ${salida.subdelegacion}</div>
            <div class="Datos"><strong>FECHA PREST TRÁMITE:</strong> ${salida.fechaPrestTramite}</div>
            <div class="Datos"><strong>FECHA BAJA TRABAJADOR:</strong> ${salida.fechaBajaTrabajador}</div>
            <div class="Datos"><strong>NÚMERO CONSECUTIVO PROCESAR:</strong> ${salida.numeroConsecutivoProcesar}</div>
            <div class="Datos"><strong>TOTAL RESOLUCIONES PROCESAR:</strong> ${salida.totalResolucionesProcesar}</div>
            <div class="Datos"><strong>CLAVE ADMINISTRACIÓN ACTUAL:</strong> ${salida.claveAdminActual}</div>
            
            
            <div class="Datos"><strong>ORIGEN:</strong> ${salida.origen}</div>
            <div class="Datos"><strong>ID SOLICITANTE:</strong> ${salida.idSolicitante}</div>
            <div class="Datos"><strong>CURP SOLICITANTE:</strong> ${salida.curpSolicitante}</div>
            <div class="Datos"><strong>SELLO TRABAJADOR:</strong> ${salida.selloTrabajador}</div>
            <div class="Datos"><strong>CURP AGENTE DE SERVICIO:</strong> ${salida.curpAgenteServicio}</div>
            
            
          </div>
        </div>
      </div>

    </div>
    

        
        
  </div>

 <jsp:include page="../generales/footerAgente.jsp" />


  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/ayudaDesempleo.js'/>"></script>
</body>
</html>
