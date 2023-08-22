<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<head>
  <title>Menu</title>
  <meta charset="utf-8" />
  <![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
  <![endif]>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
  <link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
  <link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/disposicion_total_imss_expediente_respuesta.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
%>

<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<input type="hidden" id="mensaje" value = "${mensaje}"/>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Solicitud Disposición IMSS" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	<script type="text/javascript"> 
    
	var resultadoOperacion = "${resultadoOperacion}";
 	var descripcion="${descripcion}";
 	

</script>
	<div class="wrapper">
	<div class="DatosBack"><strong>CV AFORE:</strong> ${datos.claveAfore}</div>
				<div class="DatosBack"><strong>CURP:</strong> ${datos.datosCertificables.curp}</div>
				<div class="DatosBack"><strong>NSS:</strong> ${datos.nss}</div>
				<div class="DatosBack"><strong>SECUENCIA PENSI&oacute;N:</strong> ${datosForm.secuenciaPension}</div>
				<div class="DatosBack"><strong>NOMBRE:</strong> ${datos.datosCertificables.nombre}</div>
				<div class="DatosBack"><strong>APELLIDO PATERNO:</strong> ${datos.datosCertificables.apellidoPaterno}</div>
				<div class="DatosBack"><strong>APELLIDO MATERNO:</strong> ${datos.datosCertificables.apellidoMaterno}</div>
				
			    <div class="DatosBack"><strong>R&Eacute;GIMEN:</strong> ${datosForm.cvTipoRegimen} - ${datosForm.descTipoRegimen}</div>
				<div class="DatosBack"><strong>TIPO RETIRO:</strong> ${datosForm.cvTipoRetiro} - ${datosForm.descTipoRetiro}</div>
				<div class="DatosBack"><strong>TIPO SEGURO:</strong> ${datosForm.cvTipoSeguro} - ${datosForm.descTipoSeguro}</div>
				<div class="DatosBack"><strong>TIPO PENSI&oacute;N:</strong> ${datosForm.cvTipoPension} - ${datosForm.descTipoPension}</div>
				<div class="DatosBack"><strong>TIPO PRESTACI&Oacute;N:</strong> ${datosForm.cvTipoPrestacion} - ${datosForm.descTipoPrestacion}</div>
				<div class="DatosBack"><strong>MONTO DISPONER:</strong> ${montoDisponer}</div>
				<div class="DatosBack"><strong>N&Uacute;MERO CONCESI&Oacute;N:</strong> ${datosForm.numeroResolucion}</div>
				<div class="DatosBack"><strong>SELLO TRABAJADOR:</strong> ${datosForm.selloUnico}</div>
				<div class="DatosBack"><strong>CURP AGENTE:</strong> ${datosForm.curpAgenteServicio}</div>
				<div class="DatosBack"><strong>CURP SOLICITANTE:</strong> ${datosForm.curp}</div>
				<div class="DatosBack"><strong>TIPO SOLICITANTE:</strong> ${datosForm.idSolcitante}</div>
				<div class="DatosBack"><strong>FECHA EMISI&Oacute;N PENSI&Oacute;N:</strong> ${datosForm.fcEmisionResolucion}</div>
				<div class="DatosBack"><strong>NUMERO SEMANAS COTIZADAS:</strong> ${datosForm.semanasCotizadas}</div>
				<div class="DatosBack"><strong>FECHA INICIO PENSI&Oacute;N:</strong> ${datosForm.fcInicioPension}</div>
				<div class="DatosBack"><strong>FECHA SOLICITUD:</strong> ${datosForm.fechaSolicitud}</div>
		<div class="push"></div>
	</div>

	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
  
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
  <script type="text/javascript">
  
</script>	

</body>
</html>
