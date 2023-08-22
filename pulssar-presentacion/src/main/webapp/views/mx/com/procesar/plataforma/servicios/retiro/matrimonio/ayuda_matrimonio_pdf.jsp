<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Menu</title>
	<meta charset="utf-8"></meta>
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
	<link href="https://necolas.github.io/normalize.css/8.0.1/normalize.css" rel="stylesheet">
	
<!-- 	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.8/slick-theme.min.css'> -->
<!--   	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.8/slick.css'> -->
  	
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>


	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/main.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carrousel_visor.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datos_generales.css'/>"></link>

	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/drag_and_drop.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/header.css'/>"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
	
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/jquery.magnify.css'/>"></link>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.magnify.js'/>"></script>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/respuestaVisorDocumentos.js'/>"></script>
	
<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
	
	
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
		var _FUN = '${flujoFun}';
		var context = '${pageContext.request.contextPath}';
		var AFORE = "${pulssarUP.aforeUsuario}"
		console.log("Afore es: "+AFORE)
		
	</script>
	
	
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/manejoFirma.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/file_upload.js'/>"></script>
	
      	    
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/solicitud_parcial_upld_generico.js'/>"></script>
</head>
<body onload="obtenerParametro(1)">
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<input type="hidden" id="mensaje" value="${mensaje}" />
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Ayuda por Matrimonio" />
		<jsp:param name="menuPrimario" value="2" />
		<jsp:param name="menuSecundario" value="2" />
		<jsp:param name="menuInactivo" value="1" />
	</jsp:include>
	<div class="wrapper">
		<div class="Title__Container">
			<h1>Solicitud Retiro Parcial Por Matrimonio</h1>
		</div>

		<div class="Layout__L">
			<div  id="divFrame" style="top: 10px;">
				<div id="botones"></div> 
				<iframe class="toPrint" id="framepdf" width="900" name ="framepdf" 
				height="500" title="Reimpresión" oncontextmenu="return false;" src="${pageContext.request.contextPath}/private/generaSolicitudMatrimonioPdf.do"></iframe>
			</div> 
		</div>
		
		
	<jsp:include page="../generales/modals.jsp" />

     
     <br />
     <jsp:include page="../generales/footerAgente.jsp" />
     <jsp:include page="../generales/modals.jsp" />

   <!-- recibe respuesta del visor de documentos -->
  	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/accordion.js'/>"></script>
	</div>
</body>
</html>