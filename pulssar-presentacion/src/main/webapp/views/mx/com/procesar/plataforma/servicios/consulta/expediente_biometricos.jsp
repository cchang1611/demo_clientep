<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Expediente Biométrico</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
	  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Consulta del Trabajador" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "4" />
	</jsp:include>
	<script type="text/javascript">
		var _REFERENCIAS = "";
		var _BENEFICIARIOS = "";
		var _MARCAS = "${marcas}";
		var _FLUJO="";
		var _CURPS = "";
	</script>
	
	<div class="wrapper">
		<section>
			<div class="Title__Container">
				<h1>Expediente Biométrico</h1>
			</div>
			
			<div class="Container">
				<div class="Layout__XL">
					<div class="Title">
						<p>Expediente Biométrico</p>
					</div>
					<div class="Datos_Container">
						<div class="Section">
							<div style="width: 100%; max-width: 480px;">
								<div class="Datosxxl" id="idCurp"><strong>CURP DEL TRABAJADOR: </strong> ${expediente.curpTrabajador}</div>
								<div class="Datosxxl" id="idRol"><strong>ROL DE LA CURP: </strong> ${expediente.rolCurp} </div>
								<div class="Datosxxl" id="idEstatusE"><strong>ESTATUS EXPEDIENTE: </strong> ${expediente.descEstatusEnrolamiento}</div>
								<div class="Datosxxl" id="idFcEnrolamiento"><strong>FECHA DE ENROLAMIENTO: </strong> ${expediente.fechaEnrolamiento}</div>
								<div class="Datosxxl" id="idAfore"><strong>AFORE: </strong> ${expediente.descAforeEnrolamiento}</div>
								<div class="Datosxxl" id="idExcepciones"><strong>CUENTA CON EXCEPCIONES: </strong> ${expediente.excepcion}</div>
								<div class="Datosxxl" id="idDispositivo"><strong>NO. SERIE DISPOSITIVO: </strong> ${expediente.dispositivo}</div>
							</div>
							<div style="width: 100%; max-width: 480px;">
								<div class="Datosxxl" id="idFecha"><strong>FECHA DE CONSULTA: </strong> ${expediente.fechaConsulta}</div>
								<div class="Datosxxl" id="idCurpEmpleado"><strong>CURP DEL EMPLEADO: </strong> ${expediente.curpAgente}</div>
								<div class="Footprints_Section">
									<canvas id='the-canvas' style="height:280px; width:520px;"></canvas>
								</div>
							</div>
						</div>
					</div>
					<c:if test="${not empty expediente.huellasTrabajador}">
						<div class="Datos_Container">
							<div class="Section">
								<table width="100%" border="0" cellspacing="0" cellpadding="5" style="width: 100%; max-width: 780px;">
									<tbody>
										<tr class="RowHeader">
											<th>POSICI&Oacute;N</th>
											<th>DEDO</th>
											<th>CALIDAD</th>
											<th>EXCEPCI&Oacute;N</th>
										</tr>
										<c:forEach items="${expediente.huellasTrabajador}" var="huella" varStatus="loopCounter">
											<c:choose>
												<c:when test="${loopCounter.index % 2 == 0}">
													<tr class="Row1">
												</c:when>
												<c:otherwise>
													<tr class="Row2">
												</c:otherwise>
											</c:choose>
												<td><c:out value="${huella.posicionDedo}" /></td>
												<td><c:out value="${huella.descripcionDedo}" /></td>
												<c:if test="${not empty huella.calidadHuella}">
													<c:choose>
														<c:when test = "${huella.calidadHuella == 1}"> <c:set var="bColorTd" value="back01"/> </c:when>
														<c:when test = "${huella.calidadHuella == 2}"> <c:set var="bColorTd" value="back02"/> </c:when>
														<c:when test = "${huella.calidadHuella == 3}"> <c:set var="bColorTd" value="back03"/> </c:when>
														<c:when test = "${huella.calidadHuella == 4}"> <c:set var="bColorTd" value="back04"/> </c:when>
														<c:otherwise> <c:set var="bColorTd" value="back05"/></c:otherwise>
													</c:choose>
													<td class="<c:out value = '${bColorTd}' />">
												</c:if>
												<c:if test="${empty huella.calidadHuella}"><td></c:if>
													<c:out value="${huella.calidadHuella}" /></td>
												<td style="max-width:50%;"><c:out value="${huella.motivo}" />&nbsp;<c:out value="${huella.descripcionMotivo}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</c:if>
				</div>
			</div>
			<jsp:include page="../menus/menuConsulta.jsp" />
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<div class="Pestana" id="pestanaMarcas">
		<div class="PestanaContainer">
		  <a href="#" id="titulo" onclick="mostrar('detalle')" class="PestanaTitle">
			<p>Marcas Operativas</p>
		  </a>
		  <div id="detalle" class="PestanaTableContainer">
			<div class="PestanaTitleContainer">Descripción</div>
			<div class="PestanasCarousel" id="marcasTrabajador">
			</div>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
		compatibilidadPdf("${expediente.imagenHuellas}");
	</script>
	<script src="<c:url value='/webResources/js/cargaRefBen.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
</body>
</html>
