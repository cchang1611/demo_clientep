<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Menu</title>
<meta charset="ISO-8859-1" />
<![if IE]>
<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
<![endif]>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="shortcut icon"              href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>

	<script src="<c:url value='/webResources/js/jquery-3.0.0.min.js'/>"></script>
	<script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript">
		var _FLUJO   = "${respuesta.flujo}";
		var _TITULO  = "${respuesta.titulo}";
		var _MENSAJE = "${respuesta.mensaje}";
	</script>
</head>
<body>

	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>

	<!-- Inicia Wrapper -->
	<div class="wrapper">

		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle"  value="Turno" />
			<jsp:param name="menuActivo" value="1" />
		</jsp:include>

		<br />
		
		<form:form id="fm_validaTurno" action="validarTurno.do" modelAttribute="commandValidarTurno" method="POST">
		  <div class="Container">
		    <div class="Layout__L">
		        <div class="Title">Clientes con Cita</div>
		        <div class="Datos_Container">
		        <div class="Form__Group">
		          <label class="LabelText" for="usuario">Cus:</label>
		          <form:input id="id__cus__valida" name="cus" path="cus" class="Inputxxl" type="text" placeholder="USUARIO" maxlength="16" />
		        </div>
		      </div>
		
		      <div class="Title">Clientes sin Cita</div>
		      <div class="Datos_Container">
		      <div class="Form__Group">
		        <label class="LabelText" for="usuario">Curp:</label>
		        <form:input id="id__curp_valida" path="curp" class="Inputxxl" type="text" placeholder="CURP" maxlength="18" />
		        <br /><label class="Labeltexterror" id="labelErrorCurpValida" style="display:none;"></label>
		      </div>
		      <div class="Form__Group">
		        <label class="LabelText" for="usuario">NSS:</label>
		        <form:input id="id__nss_valida" path="nss" class="Inputxxl" type="text" placeholder="NSS" maxlength="11" />
		        <br /><label class="Labeltexterror" id="labelErrorNssValida" style="display:none;"></label>
		      </div>
		    </div>
		    <div class="Form__Group">
		      <div class="ContainerButtonsCenter">
		        <input id="id_botonValidaTurno"  class="Submitx" value="Aceptar">
		        <a id="id__botonHome"    class="Submitx">Cancelar</a>
		      </div>
		    </div>
		    </div>
		  </div>
		</form:form>

		<div class="push"></div>
		<br />

	</div>

    <jsp:include page="../generales/footerPrincipal.jsp" />

	<!-- Finaliza Wrapper -->

	<jsp:include page="modal.jsp"></jsp:include>

	<script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/menu_configuracion.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/administracion_turnos.js'/>"></script>

</body>
</html>
