<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page
	import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Visor de Imágenes de Expedientes</title>
  <meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/loader.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	
	
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
  <script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	
	<!-- carrusel Visor  -->
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carrousel_visor.css'/>"></link>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
	
	<!-- Zoom Visor  -->
  <link rel="stylesheet" charset="utf-8" type="text/css"  href="<c:url value='/webResources/css/general/jquery.magnify.css'/>"></link>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.magnify.js'/>"></script>
  
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/subMenuConsultaExpediente.js'/>"></script>
  <link rel="stylesheet" charset="utf-8" type="text/css" href="<f:url value='/webResources/css/general/modal_window.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<f:url value='/webResources/css/general/loader.css'/>"></link>
  
  <style>
	  a#cancelarImagenCarrusel {
	    display: none;
	  }
  </style>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<input type="hidden" id="mensajeError" value="${error}" />
		<jsp:include page="../generales/headerAgente.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle" value="Consulta Expediente" />
			<jsp:param name="menuPrimario" value="2" />
			<jsp:param name="menuSecundario" value="2" />
			<jsp:param name="menuInactivo" value="1" />
		</jsp:include>
		<script type="text/javascript">
			var AFORE = "${pulssarUP.aforeUsuario}";
			var urlSalir = "${urlSalir}";
			var mostrarModalCarrusel = "${mostrarModalCarrusel}";
		 	var respuestaAceptadaVisorDoc = function(){};
		 	var respuestaCancelarVisorDoc = function(){};
		</script>

		<div class="Banner__Container">
			<div class="Banner__Thumbnail">
				<img src="../webResources/img/slide4.jpg">
					<div class="Banner__TextContainer">
						<h1 class="Banner__TitleContainer">Visor de Imágenes de Expedientes</h1>
					</div>
			</div>
		</div>

		<div class="Container">
			<div class="Layout__M">

        <div class="Title">
          <p>Consulta de Expediente</p>
        </div>

<%-- <form action="./consultaExpedienteDinamico.do" method="get">  --%>
        <div class="Datos_Container">
        <c:choose>
        <c:when test="${lstAfore != null && datos.datosCertificables.curp == null}">
          <div class="Form__Group">
            <label class="LabelTextEdit" for="usuario">Afore:</label>
             <select id="comboAfore" class="Select" name="afore" required>
              <option selected disabled value="-1">Seleccione una Opción</option>
              <c:forEach items="${lstAfore}" var="afore">
			   	<option value="${afore.claveAfore}">${afore.descripcionAfore}</option>
			  </c:forEach>
            </select>
          </div>
          <div class="Form__Group">
            <label class="LabelText" for="usuario">CURP:</label>
            <input id="campoCurp" class="Inputxxl" type="text" name="curp" value="" placeholder="Capturar CURP" required/>
          </div>
        </c:when>
   		<c:otherwise>
   		  <div class="Form__Group">
            <label class="LabelText" for="usuario">CURP:</label>  
              <input id="campoCurp" class="Inputxxl" type="text" name="curp" value="${datos.datosCertificables.curp}" placeholder="Capturar CURP" required disabled/>
          </div>
     	</c:otherwise>
     	</c:choose>
          <div class="Form__Group">
            <label class="LabelTextEdit" for="usuario">Tipo de Expediente:</label>
            <select id="tipoExpedienteCombo"; class="Select" name="tipoExpediente" required ">
              <option selected disabled value="-1">Seleccione una Opción</option>
              <c:forEach items="${lstTipoExpediente}" var="tipoProceso">
			   	<option value="${tipoProceso.claveTipoProceso}">${tipoProceso.claveTipoProceso} ${tipoProceso.descripcionTipoProceso}</option>
			  </c:forEach>
            </select>
          </div>
          <div class="ContainerButtonsCenter">
          	<input class="Submitx" type="button" value="Salir" id="salir"/>
             <!-- <input class="Submitx" type="submit" value="Consultar" id="btnConsultar" />  -->
            <input class="Submitx" type="button" value="Consultar" id="btnConsultaBoton" onclick="consultaExpediente('${lstAfore}','${datos.datosCertificables.curp}');"/>
          </div>
        </div>
        <%--    </form>  --%>
       </div>
		</div>
		<div class="push"></div>
	</div>
	 <div id="exitoModalAceptarVisor" class="Modal" >
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 id="tituloExitoAceptarVisor" class="ModalTitle"></h2>
					<a style="cursor: pointer;" onclick="ocultarDiv();" class="ModalButton" id="btnExitoM">X</a>
				</div>
				<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="../webResources/img/error.png" alt="icon_alert" />
				</div>
				<div id="mensajeExitoAceptarVisor" class="Modal__AlertText">
					
				</div>
				<div>
					<form class="ModalFooter">
					  <input class="Submit" type="button" onclick="ocultarDiv();" value="Aceptar"/>
					</form>
				</div>
			</div>
		</div>
	<jsp:include page="../generales/footerAgente.jsp" />

	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/slick.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/slick_carousel_administrador.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/subMenuRetiroParcial.js'/>"></script>
</body>
</html>
