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
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			window.history.pushState(null, "", window.location.href);        
		    window.onpopstate = function() {
		        window.history.pushState(null, "", window.location.href);
		    };
		});
	</script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
 	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Ayuda de ${origen}" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "2" />
	</jsp:include>
<div class="wrapper">
   <div class="Container">

    <div class="Title__Container">
      <h1>Solicitud Disposici&oacute;n</h1>
    </div>
		<form:form method="post" action="${pageContext.request.contextPath}/private/solicitudCertificado.do" id="solicitudCertificado" />
    	<form:form method="post" action="${pageContext.request.contextPath}/private/solicituddisposicionsalida.do" modelAttribute="retiroDesempleoImss" id="retiroDesempleoImss">
		<input id="selloTrabajador" type="hidden" name="selloTrabajador"
			value="${retiroDesempleoImss.selloTrabajador}" />
		<input id="numeroResolucion" type="hidden" name="numeroResolucion"
			value="${retiroDesempleoImss.numeroResolucion}" />
		<input id="resultadoOperacion" type="hidden" name="resultadoOperacion"
			value="${retiroDesempleoImss.resultadoOperacion}" />
		<input id="mensajeOperacion" type="hidden" name="mensajeOperacion"
			value="${retiroDesempleoImss.mensajeOperacion}" />
		<input id="afore" type="hidden" name="afore"
			value="${datos.claveAfore}" />
			<input id="origen" type="hidden" name="afore"
			value="${origen}" />
    <div class="Container">

      <div class="Layout__M">
        <div class="Line"></div>
        <div class="Datos_Container">
            <div class="DatosBack"><strong>NSS:</strong> ${datos.nss}</div>
            <div class="DatosBack"><strong>NOMBRE TRABAJADOR:</strong> ${datos.datosCertificables.nombre}</div>
            <div class="DatosBack"><strong>APELLIDO PATERNO:</strong> ${datos.datosCertificables.apellidoPaterno}</div>
            <div class="DatosBack"><strong>APELLIDO MATERNO:</strong> ${datos.datosCertificables.apellidoMaterno}</div>
            <div class="DatosBack"><strong>TIPO DE RETIRO:</strong> RETIRO PARCIAL</div>
            <div class="DatosBack" id="numResolucion"><strong>N&Uacute;MERO RESOLUCI&Oacute;N:</strong> </div>
            <div class="DatosBack"><strong>CLAVE ADMIN ACTUAL:</strong> ${datos.claveAfore}</div>
            <div class="DatosBack"><strong>CURP TRABAJADOR:</strong> ${datos.datosCertificables.curp}</div>
            <div class="DatosBack"><strong>SELLO TRABAJADOR:</strong> ${datos.sello.id}</div>
            <div class="DatosBack"><strong>CURP AGENTE SERVICIO:</strong> ${pulssarUP.curpAgente}</div>
            <div class="DatosBack"><strong>ID SOLICITANTE:</strong> ${datos.tipoSolicitante}</div>
            <div class="DatosBack"><strong>CURP SOLICITANTE:</strong> ${datos.datosCertificables.curp}</div>
        </div>
        <div class="ContainerButtons">
        	 <input id="btnSolicitar" class="Submitxl" type="submit" value="Solicitar Disposici&oacute;n"/><br/>
    	</div>
    	
      </div>
    </div>
		</form:form>
		<c:if test="${boton == false}">
    	<div class="ContainerButtonsCenter">
			<form:form id="fm_datosConsulta" method="POST" modelAttribute="commandConsulta" action="actualizarDatos.do">
        		<form:input id="idCurpConsultaaa" type="hidden"  path="curp" value="${commandConsulta.curp}" />
                <form:input id="idNssConsultaaa" type="hidden"  path="nss" value="${commandConsulta.nss}" />
                <form:input id="claveConsultaaa" type="hidden"  path="cvTipoSolicitante" value="${commandConsulta.cvTipoSolicitante}" />
                <form:input id="timepicker11" type="hidden"  path="timerPicker" value="${commandConsulta.timerPicker}" />
            </form:form>
            </div>
  		</c:if>
    
  </div>
<div class="push"></div>
	</div>
<jsp:include page="../generales/footerAgente.jsp" />
<jsp:include page="../generales/modals.jsp" />


  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/solicitudDisposicion.js'/>"></script>
</body>
</html>
