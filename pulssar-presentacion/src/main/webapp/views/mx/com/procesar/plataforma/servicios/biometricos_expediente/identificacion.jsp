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
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carrousel_visor.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/drag_and_drop.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/icons/ionicons.min.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/expediente.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
	<%-- <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dispositivos/530/tablet.js'/>"></script> --%>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
	<!-- Zoom Visor  -->
  <link rel="stylesheet" charset="utf-8" type="text/css"  href="<c:url value='/webResources/css/general/jquery.magnify.css'/>"></link>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.magnify.js'/>"></script>
  
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
		var _FUN = '${flujoFun}';
		var AFORE = '${datos.claveAfore}'
		var FOLIOPADRE = "${folioPadre.chFolio}"
		var SERVICIO = "${tipoProceso}"
		var NSS = "${nssProceso}"
		var CURP = "${curpProceso}"
		var SOLICITANTE = "${tipoSolicitante}"
		var INTENTOS = "${intentos.chValorParametro}";
		var IDFOLIO_HIJO = "${folioHijo.idFolioPulssar}";
		var AGENTE = "${agente}";
		var AMBIENTE = "${ambienteBanorte}";
		var CAMBIORFC = "${cambioRfc}";
		var IDSESION = "${eUserCoppel.idSession}";
		var FLUJODIGITALIZADOR = "${flujoDigitalizador}";	
		var CURPSOLICITANTE = "${curpSolicitante}";
	</script>
	
	<c:choose>
         
         <c:when test = "${stiloOrg == '568'}">
            <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dispositivos/568/digitalizacion.js'/>"></script>           
         </c:when>
         <c:otherwise>
            <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dispositivos/530/tablet.js'/>"></script>
         </c:otherwise>
      </c:choose>  
	
	<div class="wrapper">
		<section>
			<div class="Title__Container">
				<h1>Conformación de Expediente de Identificación</h1>
			</div>

		<c:if test="${datos.claveAfore == '530' || datos.claveAfore == '568'}">
			<form:form id="fm_recepcionImagen" method="GET" modelAttribute="entradaRecepcionImagenes" action="recepcionImagenesGenerico.do">
				<div class="Container">
					<div class="Layout__XL">
						<div class="Title">
							<p>Digitalización de Documentos para Expediente Electrónico</p>
						</div>
						<div class="Datos_Container">
							<div class="row_container">
								<div class="Datosxxl" id="idDocumentos">
									<strong>Folio Documentos:</strong> ${folioDocumento}
								</div>
								<div class="Datosxxl" id="idTrabajdor">
									<strong>Tipo Trabajador:</strong>
									<c:choose>
										<c:when test="${tipoTrabajador == '0'}">
											<input type="radio" id="tipo" name="tipo" value="1" checked /> IMSS 
											<input type="radio" id="tipo" name="tipo" value="2" /> ISSSTE<br />
										</c:when>
										<c:when test="${tipoTrabajador == '1'}">
											<input type="radio" id="tipo" name="tipo" value="1" checked /> IMSS
											<input type="radio" id="tipo" name="tipo" value="2" disabled="true" /> ISSSTE<br />
										</c:when>
										<c:otherwise>
											<input type="radio" id="tipo" name="tipo" value="1" disabled="true" /> IMSS
											<input type="radio" id="tipo" name="tipo" value="2" checked /> ISSSTE<br />
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
<%-- 						<form:input id="idFolioPadre" type="hidden" name="folioPadre" path="folioPadre" value="folio" /> --%>
						<form:input id="idFolioPadre" type="hidden" name="folioPadre" path="folioPadre" value="${folioPadre.chFolio}" />
						<form:input id="idFolioHijo" type="hidden" name="folioHijo" path="folioHijo" value="${folioHijo.chFolio}" />
						<form:input id="idTipoProceso" type="hidden" name="tipoProceso" path="tipoProceso" value="${tipoProceso}" />
						<form:input id="idEstatusRecepcion" type="hidden" name="estatusRecepcion" path="estatusRecepcion" value="1" />
						<form:input id="idUrlSiguiente" type="hidden" name="urlSiguiente" path="urlSiguiente" value="private/enviarIdentificacionDigitalizacion.do" />

						<c:choose>
							<c:when test="${datos.claveAfore == '530'}">
								<div
									style="text-align: center; padding: 20px 0px 0px 0px; width: 100%;">
									<input id="btnRecepcionImgBan" class="Submit" type="button" value="DIGITALIZAR">
								</div>
							</c:when>
							<c:otherwise>
								<div
									style="text-align: center; padding: 20px 0px 0px 0px; width: 100%;">
									<input id="btnRecepcionImgCop" class="Submit" type="button" value="DIGITALIZAR">
								</div>
							</c:otherwise>

						</c:choose>
					</div>
				</div>
			</form:form>
		</c:if>
			
			<c:if test="${datos.claveAfore != '530' && datos.claveAfore != '568'}">
			<form id="fm_identificacion" action="enviarIdentificacion.do" method="POST" enctype="multipart/form-data">
				<div class="Container">
					<div class="Layout__XL">
						<div class="Title">
							<p>Documentos Obligatorios</p>
						</div>
						<div class="Datos_Container">
							<div class="row_container">
								<div class="Datosxxl" id="idDocumentos"><strong>Folio Documentos:</strong> ${folioDocumento}</div>
								<div class="Datosxxl" id="idTrabajdor"><strong>Tipo Trabajador:</strong>
									<c:choose>
										<c:when test = "${tipoTrabajador == '0'}">
											<input type="radio" name="tipo" value="1" checked /> IMSS 
											<input type="radio" name="tipo" value="2" /> ISSSTE<br/>
										</c:when>
										<c:when test = "${tipoTrabajador == '1'}">
											<input type="radio" name="tipo" value="1" checked /> IMSS
											<input type="radio" name="tipo" value="2" disabled="true" /> ISSSTE<br/>
										</c:when>
										<c:otherwise>
											<input type="radio" name="tipo" value="1" disabled="true" /> IMSS
											<input type="radio" name="tipo" value="2" checked /> ISSSTE<br/>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
						<div class="Datos_Container">
							<div class="accordion js-accordion">
								<c:forEach items="${obligatorios}" var="docObligatorios">
									<div class="accordion__item js-accordion-item">
										<div class="accordion-header js-accordion-header">${docObligatorios.descripcion}</div>
										<div class="accordion-body js-accordion-body">
										<div class="accordion-body__contents" style="text-align:center;">
											<c:forEach items="${docObligatorios.subDocumentos}" var="subdocObligatorios" varStatus="num">       
													<div class="dropFileForm">
														<input type="hidden" id="hid${subdocObligatorios.clave}" value="${subdocObligatorios.descripcion}"/>
														<input id="input${subdocObligatorios.clave}" name="${subdocObligatorios.clave}" type="file" class="fileInput" onchange="cambiaNombre(event, '${subdocObligatorios.clave}')"> 
														<label for="input${subdocObligatorios.clave}" class="fileLabel" ondrop="overrideDefault(event);addFiles(event);"> 
															<i class="fa fa-download fa-5x"></i> 
															<br> <span id="fileLabelText${subdocObligatorios.clave}">${subdocObligatorios.descripcion}</span>
															<br> <span id="uploadStatus"></span>
														</label>
													</div>
											</c:forEach>
										</div>
										</div>
									</div>
								</c:forEach>
							</div>
							<c:if test = "${not empty noObligatorios}">
								<div class="Title">Documentos No Obligatorios</div>
								<div class="accordion js-accordion">
									<c:forEach items="${noObligatorios}" var="dNObligatorio" varStatus="num">
										<div class="accordion__item js-accordion-item">
											<div class="accordion-header js-accordion-header">${dNObligatorio.descripcion}</div>
											<div class="accordion-body js-accordion-body">
											<div class="accordion-body__contents"  style="text-align:center;">
												<c:forEach items="${dNObligatorio.subDocumentos}" var="subdocNoObligatorios" varStatus="num">
													<div class="dropFileForm">
														<input type="hidden" id="hid${subdocNoObligatorios.clave}" value="${subdocNoObligatorios.descripcion}"/>
														<input id="input${subdocNoObligatorios.clave}" name="${subdocNoObligatorios.clave}" type="file" class="fileInput" onchange="cambiaNombre(event, '${subdocNoObligatorios.clave}')" accept="image/png, image/jpg,image/jpeg, image/tif, .pdf"> 
														<label for="input${subdocNoObligatorios.clave}" class="fileLabel" ondrop="overrideDefault(event);addFiles(event);"> 
															<i class="fa fa-download fa-5x"></i> 
															<br> <span id="fileLabelText${subdocNoObligatorios.clave}">${subdocNoObligatorios.descripcion}</span>
															<br> <span id="uploadStatus"></span>
														</label>
													</div>
												</c:forEach>						
											</div>
											</div>
										</div>	
									</c:forEach>
								</div>
							</c:if>
						</div>
					<div style="text-align: center; padding: 20px 0px 0px 0px; width: 100%;">
						<input id="btnIdentificacion" class="Submit" type="button" value="CONTINUAR">
					</div>
				</div>
				</div>
			</form>
			</c:if>
		</section>
		<!-- Pestaña Desplegable Datos Generales -->
		<div class="Pestanadatos">
			<div class="PestanaContainerdatos">
				<div id="detalledatos" class="PestanaTableContainerdatos">
					<div class="PestanasCarouseldatos">
						<div class="ContainerDatosGenerales">
							<div class="ContainerDatosGenerales__Columna2">
								<ul class="ContainerDatosGenerales_Seccion">
									<li class="ContainerDatosGenerales_Datos"><strong>Curp:</strong> ${expediente.curp} </li>
									<li class="ContainerDatosGenerales_Datos"><strong>Nombre:</strong> ${expediente.nombre} </li>
									<li class="ContainerDatosGenerales_Datos"><strong>Apellido Paterno:</strong> ${expediente.apellidoPaterno} </li>
									<li class="ContainerDatosGenerales_Datos"><strong>Apellido Materno:</strong> ${expediente.apellidoMaterno} </li>
								</ul>
								<ul class="ContainerDatosGenerales_Seccion">
								  <li class="ContainerDatosGenerales_Datos"><strong>DOMICILIO</strong></li>
								  <li class="ContainerDatosGenerales_Datos"><strong>Calle:</strong> ${expediente.calle} </li>
								  <li class="ContainerDatosGenerales_Datos"><strong>No. Ext.:</strong> ${expediente.noExterior} </li>
								  <li class="ContainerDatosGenerales_Datos"><strong>No. Int.:</strong> ${expediente.noInterior} </li>
								  <li class="ContainerDatosGenerales_Datos"><strong>Colonia:</strong> ${expediente.colonia} </li>
								  <li class="ContainerDatosGenerales_Datos"><strong>Municipio:</strong> ${expediente.municipio} </li>
								  <li class="ContainerDatosGenerales_Datos"><strong>Ent. Fed.:</strong> ${expediente.entidadFed} </li>
								  <li class="ContainerDatosGenerales_Datos"><strong>C.P.:</strong> ${expediente.codigoPostal} </li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<a href="#" id="titulo" onclick="mostrar('detalledatos')" class="PestanaTitledatos">Datos Identificación</a>
			</div>
		</div>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
	<jsp:include page="../generales/visorDocumentos.jsp"/>	
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/accordion.js'/>"></script>
</body>
</html>
