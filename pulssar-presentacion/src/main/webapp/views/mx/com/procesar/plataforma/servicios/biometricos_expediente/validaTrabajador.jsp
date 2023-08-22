<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Validación de Trabajador</title>
	<meta charset="utf-8"></meta>
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" src="https://java.com/js/dtjava.js"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="4" />
		<jsp:param name="menuTitle" value="Validaci&oacute;n de Trabajador" />
		<jsp:param name="menuPrimario" value = "3" />
		<jsp:param name="menuSecundario" value = "3" />
	</jsp:include>
	<script type="text/javascript">
		var _VAR = '${cVar}';
		var _FLUJO = '${respuesta.flujo}';
		var _PAG = '${redirec}';
		var _WEBSOCKET = '${socket}';
		var _WEBAFORE = '${pulssarUP.aforeUsuario}';
		var _WEBJNLP = '${jnlpAfore}';
	</script>
	
	<div class="wrapper">
		<section>
			<form:form id="fm_validaHuellas" modelAttribute="modelValida" action="huellas.do" method="POST">
				<div class="Title__Container">
					<h1>Verificación de Trabajador</h1>
				</div>
				<c:choose>
					<c:when test="${respuesta.flujo == 3}">
					<div class="Container">
							<div class="Layout__XL">
								<div class="Title" >
									<p>Empleado no validado</p>
								</div>
								<div class="Datos_Container">
									<div class="row_container">
										<div class="Datosxxl"><strong>El proceso de verificación de trabajador requiere que se haya validado el empleado primero, inicie proceso de validación de empleado:</strong></div>
									</div>
									<div class="ContainerButtonsCenter">
										<c:choose>
											<c:when test = "${not empty cambioJnlp && cambioJnlp == '1' && fn:contains('578,530', stiloOrg)}">
												<a class="Submitxl" id="btnHuella" href="" onclick="ejecucionJavaLauncher();">INICIAR PROCESO</a>
											</c:when>
											<c:otherwise>
												<input id="btnHuella" class="Submitxl" type="button" value="INICIAR PROCESO" />
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
							<form:input type="hidden" id="idBiometrico" path="biometricos" />
						</div>
					</c:when>
					<c:when test="${respuesta.flujo == 4}">
						<div class="Container">
							<div class="Layout__XL">
								<div class="Title" >
									<p>Empleado validado</p>
								</div>
								<div class="Datos_Container">
									<div class="row_container">
										<div class="Datosxxl"><strong>Curp Empleado: </strong> ${curpEmpleado}</div>
										<div class="Datosxxl"><strong>Fecha Validación: </strong> ${fechaValidacion}</div>
										<div class="Datosxxl"><strong>Vigencia: </strong> ${fechaVigencia}</div>
									</div>
								</div>
								<div class="Title" >
									<p>Trabajador no validado</p>
								</div>
								<div class="Datos_Container">
									<div class="row_container">
										<div class="Datosxxl"><strong>Para verificar al trabajador se seleccionarán por defecto las 4 huellas con mejor calidad:</strong></div>
									</div>
									<div class="Section">
										<div class="Footprints_Section">
											<canvas id='the-canvas'></canvas>
										</div>
									</div>
									<div class="ContainerButtonsCenter">
										<c:choose>
											<c:when test = "${not empty cambioJnlp && cambioJnlp == '1' && fn:contains('578,530', stiloOrg)}">
												<a class="Submitxl" id="btnHuella" href="" onclick="ejecucionJavaLauncher();">INICIAR PROCESO</a>
											</c:when>
											<c:otherwise>
												<input id="btnHuella" class="Submitxl" type="button" value="VERIFICAR TRABAJADOR" />
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
							<form:input type="hidden" id="idBiometrico" path="biometricos" />
						</div>
					</c:when>
					<c:otherwise>
						<div class="Container">
							<div class="Layout__XL">
								<div class="Title" >
									<p>Empleado validado</p>
								</div>
								<div class="Datos_Container">
									<div class="row_container">
										<div class="Datosxxl"><strong>Curp Empleado: </strong> ${curpEmpleado}</div>
										<div class="Datosxxl"><strong>Fecha Validación: </strong> ${fechaValidacion}</div>
										<div class="Datosxxl"><strong>Vigencia: </strong> ${fechaVigencia}</div>
									</div>
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</form:form>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
	<script type="text/javascript">
		compatibilidadPdf("${imagenHuellas}");
	</script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/wsServicioTrabE.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/verificacionTrabajador.js'/>"></script>
	<c:if test="${pulssarUP.aforeUsuario == 568}">
		<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dispositivos/${pulssarUP.aforeUsuario}/wsServicioCoppel.js'/>"></script>
	</c:if>
</body>
</html>
