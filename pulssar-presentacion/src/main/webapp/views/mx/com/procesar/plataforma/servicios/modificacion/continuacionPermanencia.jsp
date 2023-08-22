<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <title>Datos Generales del Trabajador</title>
  <meta charset="utf-8">
  <![if IE]>
	<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
  <![endif]>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datos_generales.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carousel/slick_carousel.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/jquery.dataTables.min.css'/>">
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <!-- plugin de validacion -->
  <script type="text/javascript" src="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.min.js'/>"></script>
	
  <script type="text/javascript" src="<c:url value='/webResources/js/jquery.validate.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
<%--   <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/datosCertificados.js'/>"></script> --%>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/permanencia.js'/>"></script>
  

  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick-theme.min.css'/>"/>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick.css'/>"/>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tooltip.css'/>"></link>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
  <jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Continuacion de permanencia" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	 <form:form id="fm_datosConsulta" method="POST" modelAttribute="commandConsulta" action="actualizarDatos.do">
	  	 <form:input id="idProcesar" type="hidden" name="idProcesar" path="idProcesar" value="${idProcesar}" />			 
		 <form:input id="idCurpConsulta" type="hidden" name="curp" path="curp" value="${curpBusqueda}" />
		 <form:input id="idNssConsulta" type="hidden" name="nss" path="nss" value="${nssBusqueda}" />
		 <form:input id="claveConsulta" type="hidden" name="cvTipoSolicitante" path="cvTipoSolicitante" value="${cvTipoSolicitanteBusqueda}" />
		 <form:input id="timepicker1" type="hidden" name="timepicker1" path="timerPicker" value="${timerPikerBusqueda}" />
	</form:form>
	<div>
		<section>
		<div class="Container" id="idSeccionContinuarPermanencia">
		<div>
		
			<div style="height: 500px;  width:900px;background: #0C3741;">
				<table width="100%" border="0" cellspacing="10" cellpadding="0">
				<tbody>
					<tr>
						<td align="center" valign="middle">
							<p>&nbsp;</p>
							<p>
								<img src="/pulssar/webResources/img/paloma.png" style="height: 200px; width:200px" />
							</p>
							<p align="center">&nbsp;</p>
						</td>
					</tr>
					</br>
					<tr>
						<td align="center" valign="middle"><p>
								<strong style="color: white; font-size: 30px;">CONTINUAR PERMANENCIA</strong>
							</p></td>
					</tr>
					</tbody>
					</table>
			</div>
					
			<div class="ContainerButtonsCenter" align="center">
				<input id="btnPermanencia" class="Submitxl" type="button" value="CONTINUAR"/>
			</div>
		</div>				
	</div>
	<jsp:include page="../modificacion/resConstanciaOk.jsp" />
	<div class="Container_None" id="idSeccionBotonRegresarAInicio">
		<div style="text-align: center;">
			<input id="btnRegresarAInicio" type="button" class="Submit" value="IR A INICIO"/>
		</div>	
	</div>
	</section>
	<div class="push"></div>
</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
</body>
</html>
