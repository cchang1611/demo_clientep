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
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/header.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/footer.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>">
  <link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
  <link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
		<input id="origen" type="hidden" name="origen"
			value="${origen}" />
		<input type="hidden" id="idFolioHidden" name="idFolioHidden"
			value="${folio.idFolio}" />

	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Ayuda de Desempleo" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "2" />
	</jsp:include>

   <div class="wrapper">

    <div class="Title__Container">
      <h1>Servicio Genera CUS</h1>
    </div>


      <div class="Layout__L">
        <div class="Title">
          <p>Datos del Titular</p>
        </div>
        <div class="Datos_Container">
         	<div class="DatosBack"><strong>SERVICIO GENERA CUS:</strong>01 - SUCURSAL</div>
			<div class="DatosBack"><strong>CURP TITULAR:</strong> ${trabajador.datosCertificables.curp}</div>
			<div class="DatosBack"><strong>NSS TITULAR:</strong> ${trabajador.nss}</div>
			<div class="DatosBack"><strong>RFC TITULAR:</strong> ${trabajador.datosNoCertificables.rfc}</div>
			<div class="DatosBack"><strong>NOMBRE TITULAR:</strong> ${trabajador.datosCertificables.nombre}</div>
			<div class="DatosBack"><strong>APELLIDO PATERNO TITULAR:</strong> ${trabajador.datosCertificables.apellidoPaterno}</div>
			<div class="DatosBack"><strong>APELLIDO MATERNO TITULAR:</strong> ${trabajador.datosCertificables.apellidoMaterno}</div>
			<div class="DatosBack"><strong>FECHA NACIMIENTO:</strong> ${trabajador.datosCertificables.fechaNacimiento}</div>
			<div class="DatosBack"><strong>N&Uacute;MERO CELULAR TITULAR:</strong> ${trabajador.datosComplementarios.telefonos.celular}</div>
			<div class="DatosBack"><strong>N&Uacute;MERO FIJO TITULAR:</strong> ${trabajador.datosComplementarios.telefonos.telefonoFijo}</div>
<!-- 			<div class="Datos"><strong>REGIMEN PENSI&Oacute;N TITULAR:</strong> OXOXOXOXOXOXOXOXOXOXOXOXOXOXOXOXOXOXOXOX</div> -->
        </div>
        <div class="Title">
           <p>DATOS DEL CIUDADANO</p>
        </div>
		<div class="Datos_Container">
         	<div class="DatosBack"><strong>ROL CIUDADANO:</strong> 01</div>
<%-- 			<div class="Datos"><strong>CURP CIUDADANO:</strong> ${trabajador.datosCertificables.curp}</div> --%>
<%-- 			<div class="Datos"><strong>NOMBRE CIUDADANO:</strong> ${trabajador.datosCertificables.nombre}</div> --%>
<%-- 			<div class="Datos"><strong>APELLIDO PATERNO CIUDADANO:</strong> ${trabajador.datosCertificables.apellidoPaterno}</div> --%>
<%-- 			<div class="Datos"><strong>APELLIDO MATERNO CIUDADANO:</strong> ${trabajador.datosCertificables.apellidoMaterno}</div> --%>
        </div>
        <div class="Title">
                  <p>DATOS AGENTE DE SERVICIO</p>
                </div>
                <div class="Datos_Container">
                    <div class="DatosBack"><strong>CURP AGENTE DE SERVICIO:</strong> ${user.curpAgente}</div>
                    <div class="DatosBack"><strong>NOMBRE AGENTE DE SERVICIO:</strong> ${user.soloNombre}</div>
                    <div class="DatosBack"><strong>APELLIDO PATERNO AGENTE DE SERVICIO:</strong>  ${user.apellidoPaterno}</div>
                    <div class="DatosBack"><strong>APELLIDO MATERNO AGENTE DE SERVICIO:</strong>  ${user.apellidoMaterno}</div>
                    <div class="DatosBack"><strong>N&Uacute;MERO AGENTE DE SERVICIO:</strong>   ${user.usuario}</div>
                </div>
                <div class="Title">
                  <p>DATOS SOLICITUD</p>
                </div>
                <div class="Datos_Container">
                    <div class="DatosBack"><strong>ORIGEN SOLICITUD:</strong>01</div>
                    <div class="DatosBack"><strong>AFORE:</strong>${user.aforeUsuario} </div>
                    <div class="DatosBack"><strong>FECHA DE LA CITA:</strong> ${fechaCita}</div>
                    <div class="DatosBack"><strong>HORARIO DE LA CITA:</strong> ${horarioCita}</div>
                </div>
        
        <div class="ContainerButtonsCenter">
	        <!-- intecarmbiar condiciones ya que estan asi para probar solamente -->
	        <input id="btnSolicitar" class="Submitxl" type="button" value="Generar CUS" >
	        <input id="btnSiguiente" class="Submitxl" type="button" value="Siguiente" >
        </div>
      </div>
        <div class="push"></div>
  </div>

	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
  

  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/generar_cus.js'/>"></script>
</body>
</html>
