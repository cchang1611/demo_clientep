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

	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>

	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/main.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carrousel_visor.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>

	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/drag_and_drop.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/header.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/jquery.magnify.css'/>"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.js'/>"></script>
	
	<script type="text/javascript">
	numeroIntentos = 0;
	
		var context = '${pageContext.request.contextPath}';
		function consultaIntervaloImagenes(){
	var intervalo =	setInterval(function(){
		cosultaRecepcionImagenes(intervalo);
		},30000)
		window.location.href = "#modalLoader";
}

function cosultaRecepcionImagenes(intervalo){
	console.log("entra al proceso de validacion de resultado de generacion de expediente");
	numeroIntentos++;
	console.log(numeroIntentos);
	$.ajax({
		url : 'consultarResultadoRecepcion.do',
		type : "GET",
		contentType : 'application/json',

		data : {
			folio : $("#tipoProceso").val()

		}
	}).success(function(resultadoOperacion) {
	var destino = $('#destino').val();
	console.log("Respuesta: "+ resultadoOperacion + " intento: "+ numeroIntentos);
		if(resultadoOperacion.resultadoOperacion != "02"){
				console.log("enviando submit");
				window.location.href = "#";
				console.log("enviando submit2");
				clearInterval(intervalo);
				console.log("enviando submit3");
				$(location).attr('href', context+destino);
		}else if(numeroIntentos == Number(3)){
				console.log("numero intentos agotado, muestra modal");
				clearInterval(intervalo);
				$(location).attr('href', context+destino);
		}
	})
}
$(document).ready(function() {
consultaIntervaloImagenes();
});		
	</script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<input type="hidden" id="mensaje" value="${mensaje}" />
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuPrimario" value="2" />
		<jsp:param name="menuSecundario" value="2" />
		<jsp:param name="menuInactivo" value="1" />
	</jsp:include>
	<div class="wrapper">


		<div class="Layout__L">
		<form:form action="prueba" method="post" enctype="multipart/form-data" id="frmVistaPreviaPdf" target="frameVistaPreviaPdf" />
			<input id="tipoProceso" type="hidden" name="tipoProceso" value="${parametrosRetiroParcialCalculoImss.folioHijo}" />
			<input id="destino" type="hidden" name="destino" value="${destino}" />
		
    </div>
		<jsp:include page="../generales/footerAgente.jsp" />
		<jsp:include page="../generales/modals.jsp" />
		
	</div>
</body>
</html>