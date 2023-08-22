<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
	<head>
		<title>Consulta Plataforma Servicios sici</title>
		<meta charset="utf-8" />
		<![if IE]>
			<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<cp:url value='/webResources/css/general/main_ie.css'/>" />
		<![endif]>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/general/universal_setting.css'/>"></link>
		<link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/general/tables.css'/>"></link>
		<link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/general/container.css'/>"></link>
		<link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/general/templates.css'/>"></link>
		<link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/general/tabs.css'/>"></link>
			 <link rel="stylesheet" charset="utf-8" type="text/css" href="<cp:url value='/webResources/css/general/styles_form.css'/>"></link>
		<link rel="shortcut icon" href="<cp:url value='/webResources/img/favicon.ico'/>"></link>
		<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
		  <!-- Data Tables Bootstrap Dynamic CSS  and javascript -->
		 <link rel="stylesheet" type="text/css" href="../webResources/css/general/modal_window.css"></link>
	    <link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/bootstrap_tables_dynamic.css'/>"></link>
	    <link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/dataTables.bootstrap.min.css'/>"></link>
	    <script type="text/javascript" charset="UTF-8" src="<cp:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
		<script type="text/javascript" charset="UTF-8" src="<cp:url value='/webResources/js/pestana.js'/>"></script>
		<script type="text/javascript" charset="UTF-8" src="<cp:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
	    <script type="text/javascript" charset="UTF-8" src="<cp:url value='/webResources/js/dataTables.bootstrap.min.js'/>"></script><script type="text/javascript" charset="utf-8" src="<cp:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	</head>
	<body>
		<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
		<jsp:include page="../generales/headerAgente.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle" value="Consulta de Certificacion Solicitudes Traspasos" />
			<jsp:param name="menuPrimario" value = "2" />
			<jsp:param name="menuSecundario" value = "2" />
			<jsp:param name="menuInactivo" value = "9" />
		</jsp:include>
		<script type="text/javascript">		
		           var _MENSAJE = "${respuesta.mensaje}";
		           var _CLAVE_SERVICIO = "${claveServicioPlataforma}";
		</script>
		<div class="wrapper">
			<section>
			
			<!-- 		
				<div class="Title__Container">
					<h1>Consulta de Certificacion Solicitudes Servicio</h1>
				</div> 
			-->
				<div class="Container">
					<div class="Layout__XL">
					<iframe id="iFrameCertificadsoServicio" 
						frameborder="0"
						style=" overflow:hidden; width:90%; height:450px; position: absolute;"
						src="${url}" scrolling="auto">
					</iframe>
					</div>
				</div>
			</section>
			<div class="push"></div>
		</div>
		
		<jsp:include page="../generales/footerAgente.jsp" />
		<script type="text/javascript" charset="UTF-8" src="<cp:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
		<jsp:include page="../generales/modals.jsp" />
	</body>
</html>