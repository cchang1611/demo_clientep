<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Conformación de Expediente de Identificación</title>
	<meta charset="utf-8"></meta>
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/drag_and_drop.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/solicitud_parcial_upld_generico.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Expediente Identificaci&oacute;n" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
	</jsp:include>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
	</script>
	
	<div class="wrapper">
		<section>
			<div class="Title__Container">
				<h1>Conformación de Expediente de Identificación</h1>
			</div>
			<form id="fm_identificacion" action="guardarArchivoReintegrar.do" method="POST" enctype="multipart/form-data">
				<div class="Container">
					<div class="Layout__XL">
						<div class="Title">
							<p>Documentos Obligatorios</p>
						</div>
						<div class="Datos_Container">
							<div class="row_container">
								<div class="Datosxxl" id="idDocumentos"><strong>Numero de resolución:</strong> ${solicitud.resolucion}</div>
								<div class="Datosxxl" id="idDocumentos"><strong>Numero de reintegro:</strong> ${solicitud.numeroReintegro}</div>
								<div class="Datosxxl" id="idDocumentos"><strong>Semanas por reintegrar:</strong> ${solicitud.semanasReintegrar}</div>
								<div class="Datosxxl" id="idDocumentos"><strong>Monto a reintegrar:</strong> ${solicitud.montoTotalReintegrar}</div>
							</div>
						</div>
						<div class="Container_Four">
							<div class="row_containerfloatOneWitoutMaxWidth">
								<c:if test = "${not empty solicitud.comboObligatorios}">
									<c:forEach items="${solicitud.comboObligatorios}" var="docObligatorios">
										<div class="dropFileForm">
											<input type="hidden" id="hid${docObligatorios.clave}" value="${docObligatorios.descripcion}"/>
											<input id="input${docObligatorios.clave}" name="${docObligatorios.clave}" type="file" class="fileInput" onchange="cambiaNombre(event, '${docObligatorios.clave}')" accept="image/png, image/jpg,image/jpeg, image/tif, image/tif, .pdf"> 
											<label for="input${docObligatorios.clave}" class="fileLabel" ondrop="overrideDefault(event);addFiles(event);"> 
												<i class="fa fa-download fa-5x"></i> 
												<br> <span id="fileLabelText${docObligatorios.clave}">${docObligatorios.descripcion}</span>
												<br> <span id="uploadStatus"></span>
											</label>
										</div>
									</c:forEach>
								</c:if>
							</div>
						</div>
						<c:if test = "${not empty solicitud.comboNoObligatorios}">
							<div class="Title">
								<p>Documentos No Obligatorios</p>
							</div>
							<div class="Container_Four">
								<div class="row_containerfloatOne">
									<c:if test = "${not empty solicitud.comboNoObligatorios}">
											<c:forEach items="${solicitud.comboNoObligatorios}" var="dNObligatorio">
												<div class="dropFileForm">
													<input type="hidden" id="hid${dNObligatorio.clave}" value="${dNObligatorio.descripcion}"/>
													<input id="input${dNObligatorio.clave}" name="${dNObligatorio.clave}" type="file" class="fileInput" onchange="cambiaNombre(event, '${dNObligatorio.clave}')" accept="image/png, image/jpg,image/jpeg, image/tif, image/tif, .pdf"> 
													<label for="input${dNObligatorio.clave}" class="fileLabel" ondrop="overrideDefault(event);addFiles(event);"> 
														<i class="fa fa-download fa-5x"></i> 
														<br> <span id="fileLabelText${dNObligatorio.clave}">${dNObligatorio.descripcion}</span>
														<br> <span id="uploadStatus"></span>
													</label>
												</div>
											</c:forEach>
									</c:if>
								</div>
							</div>
						</c:if>
					</div>
					
					
                
					
					<div style="text-align: center; padding: 20px 0px 0px 0px; width: 100%;">
						<input id="btnIdentificacion" class="Submit" type="submit" value="CONTINUAR">
					</div>
				</div>
				
				<input type="hidden" name="resolucion" value="${solicitud.resolucion}"/>
				<input type="hidden" name="numeroReintegro" value="${solicitud.numeroReintegro}"/>
			</form>
		</section>
		<div class="push"></div>
	</div>
	
	<form id="terminarTramite" action="terminarTramiteConfirmacion.do" method="get">
	</form>
	
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value="/webResources/js/reintegroRecursosDesempleo.js"/>"></script>
</body>
</html>
