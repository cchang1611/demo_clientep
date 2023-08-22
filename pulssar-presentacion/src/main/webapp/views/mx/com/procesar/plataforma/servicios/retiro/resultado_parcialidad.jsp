<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Pago por Parcialidad</title>
	 <meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/bootstrap.min.js'/>"></script>	
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/bootstrap.js'/>"></script>								
					
				<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/accordion.js'/>"></script>
				<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pagoPorParcialidad.js'/>"></script>	
			 <%--  <script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
			  <script src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>  --%>
	
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	
</head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
FolioEntrada folio = datos.getFolio();
%>
<body>
	<input type="hidden" id="mensaje" value = "${mensaje}"/>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="PAGO POR PARCIALIDAD" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	<script type="text/javascript"> 
    
	var _FLUJO = "${respuesta.flujo}";
	
</script>
 <!-- Inicia Wrapper -->
        <div class="wrapper">
             <div class="Title__Container">
                    <!-- <h1>Pago de parcialidad <br>de retiro por desempleo</h1> -->
             </div> 	
        </div> <!-- wrapper -->
		
		
	  <script type="text/javascript">
	/* 	jsonInstiticionesBancarias = '${jsonInstitucionBancaria}'; */	
	</script>
  <!-- finaliza Ventana Modal 2 -->
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/notificaModals.jsp" />
	
	
 <%--  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script> --%>
 
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>

</body>
</html>
