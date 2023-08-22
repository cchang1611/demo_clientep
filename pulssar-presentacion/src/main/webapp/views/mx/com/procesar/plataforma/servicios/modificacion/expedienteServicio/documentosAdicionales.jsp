<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Conformación de Expediente de Servicio</title>
  	<meta charset="utf-8">
  	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
  	<![endif]>
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
    <link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
  	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datos_generales.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/jquery.dataTables.min.css'/>">
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick-theme.min.css'/>"/>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/jquery.magnify.css'/>"></link>
	<link rel="stylesheet" charset="utf-8"  type="text/css" href="<c:url value='../webResources/css/general/carrousel_visor.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/drag_and_drop.css'/>"></link>	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  	<script type="text/javascript" src="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.min.js'/>"></script>
  	<script type="text/javascript" src="<c:url value='/webResources/js/jquery.validate.min.js'/>"></script>
  	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/expedienteServicio/docsAdicionales.js'/>"></script>
  	<script type="text/javascript" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
  	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
  	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
  	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
  	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.magnify.js'/>"></script>
  	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
<jsp:include page="../../generales/headGeneral.jsp"></jsp:include>
<jsp:include page="../../generales/headerAgente.jsp">
	<jsp:param name="encabezado" value="2" />
	<jsp:param name="menuTitle" value="Modificaci&oacute;n de Datos" />
	<jsp:param name="menuPrimario" value = "2" />
	<jsp:param name="menuSecundario" value = "2" />
	<jsp:param name="menuInactivo" value = "1" />
</jsp:include>
<script type="text/javascript">
	var _FLUJO = "${respuesta.flujo}";
	var AFORE = "${pulssarUP.aforeUsuario}"
</script>
<div class="wrapper">
	<section>
		<div class="Title__Container" id="tituloPantalla">
			<h1>Conformación de Expediente de Servicio</h1>
		</div>
		<input type="hidden" name="nssTrabajajador"  value="${nssTrabajador}" id="nssTrabajajador"/>
		<input type="hidden" name="chTipoSolicitante" value="${chTipoSolicitante}" id="chTipoSolicitante"/>
		<input type="hidden" name="curpTrabajador" value="${curpTrabajador}" id="curpTrabajador"/>
		<input type="hidden" name="nombreTrabajador" value="${nombreTrabajador}" id="nombreTrabajador"/>
		<input type="hidden" name="apellidoPaterno" value="${apellidoPaterno}" id="apellidoPaterno"/>
		<input type="hidden" name="apellidoMaterno" value="${apellidoMaterno}" id="apellidoMaterno"/>
		<form:form id="fm_datosConsulta" method="POST" modelAttribute="commandConsulta" action="actualizarDatos.do">
			<form:input id="idProcesar" type="hidden" name="idProcesar" path="idProcesar" value="${idProcesar}" />			
 			<form:input id="idCurpConsulta" type="hidden" name="curp" path="curp" value="${curpBusqueda}" />
 			<form:input id="idNssConsulta" type="hidden" name="nss" path="nss" value="${nssBusqueda}" />
 			<form:input id="claveConsulta" type="hidden" name="cvTipoSolicitante" path="cvTipoSolicitante" value="${cvTipoSolicitanteBusqueda}" />
 			<form:input id="timepicker1" type="hidden" name="timepicker1" path="timerPicker" value="${timerPikerBusqueda}" />
		</form:form>
		<form id="fm_expedienteServicio" action="enviarArchivosExpedienteServicio.do" method="POST" enctype="multipart/form-data" onsubmit="cargaloader();">
			<div class="Container" id="idSeccionDocumentosAdicionales">
				 <div class="ContainerDatosGenerales">
				 	<table>
				 		<tr>
				 			<td><strong>NSS:</strong></td>
				 			<td><label id="idNssDocsAdic"></label></td>
				 		</tr>
				 		<tr>
				 			<td><strong>CURP:</strong></td>
				 			<td><label id="idCurpDocsAdic"></label></td>
				 		</tr>
				 		<tr>
				 			<td><strong>NOMBRE:</strong></td>
				 			<td><label id="idNombreTrabajadorDocsAdic"></label></td>
				 		</tr>
				 		<tr>
				 			<td><strong>APELLIDO PATERNO:</strong></td>
				 			<td><label id="idApellidoPaternoDocsAdic"></label></td>
				 		</tr>
				 		<tr>
				 			<td><strong>APELLIDO MATERNO:</strong></td>
				 			<td><label id="idApellidoMaternoDocsAdic"></label></td>
				 		</tr>
				 		<tr>
				 			<td><strong>TIPO DE SERVICIO:</strong></td>
				 			<td><label id="idTipoServicioDocsAdic"></label></td>
				 		</tr>
				 		<tr>
				 			<td colspan="2">
				 				<c:if test = "${not empty documentos}">
								 	 <div class="Title">
								 	 	<p>Documentos Obligatorios</p>
								 	 </div>
									 <div class="Container_Four">
										<div class="row_containerfloatOne">
											<c:if test = "${not empty documentos}">
												<table>
													<c:forEach items="${documentos}" var="dObligatorio">
														<tr class="Row1" id="sec${dObligatorio.clave}">
															<td style="width: 5%;"><input type="checkbox" name="chBox${dObligatorio.clave}" value="${dObligatorio.clave}" disabled="true"/></td>
															<td style="width: 55%;">${dObligatorio.descripcion}</td>
															<td style="width: 40%;"><input type="file" name="doc_${dObligatorio.clave}" accept="image/png, image/jpg,image/jpeg, image/tif, .pdf" /></td>
														</tr>	
													</c:forEach>
												</table>
											</c:if>
										</div>
									</div>
								</c:if>	
				 			</td>
				 		</tr>
				 		<tr>
				 			<td colspan="2">
				 				<c:if test = "${not empty documentosN}">
									<div class="Title">
										<p>Documentos No Obligatorios</p>
									</div>
									<div class="Container_Four">
										<div class="row_containerfloatOne">
											<c:if test = "${not empty documentosN}">
												<table>
													<c:forEach items="${documentosN}" var="dNObligatorio">
														<tr class="Row1">
															<td style="width: 5%;"><input type="checkbox" name="chBox${dNObligatorio.clave}" value="${dNObligatorio.clave}" disabled="true"/></td>
															<td style="width: 55%;">${dNObligatorio.descripcion}</td>							
															<td style="width: 40%;"><input type="file" name="doc_${dNObligatorio.clave}" accept="image/png, image/jpg,image/jpeg, image/tif, image/tif, .pdf" /></td>
														</tr>
													</c:forEach>
												</table>
											</c:if>
										</div>
									</div>
								</c:if>	
				 			</td>
				 		</tr>
				 		<tr>
				 			<td colspan="2">
				 				<div style="text-align: center; padding: 20px 0px 0px 0px; width: 100%;">
				 					<input id="btnEnviarExpedienteServicio" class="Submit" type="submit" value="ENVIAR">
				 				</div>
				 			</td>
				 		</tr>
				 	</table>
				 </div>	 
			</div>
		</form>	
	<jsp:include page="../../modificacion/resConstanciaOk.jsp" />
	<div class="Container_None" id="idSeccionBotonRegresarAInicio">
		<div style="text-align: center;">
			<input id="btnRegresarAInicio" type="button" class="Submit" value="IR A INICIO"/>
		</div>	
	</div>
	</section>
	<div class="push"></div>	
</div>
	<jsp:include page="../../generales/footerAgente.jsp" /> 
	<jsp:include page="../../generales/modals.jsp" />
	<jsp:include page="../../generales/visorDocumentos.jsp"/>			
</body>
</html>		