<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Obtener huellas validación INE</title>
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
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Obtener huellas Trabajador" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
	</jsp:include>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
		var _DATOS = "${datos}";
		var _URLFINAL = "${urlFinal}";
		var _WEBAFORE = '${pulssarUP.aforeUsuario}';
		var _WEBJNLP = '${jnlpAfore}';
	</script>
	
	<div class="wrapper">
		<section>
			<form:form id="fm_Biometrico" modelAttribute="expeBiom" action="#" method="POST">
				<div class="Title__Container">
					<h1>Obtener Huellas</h1>
				</div>
				<div class="Container">
					<div class="Layout__XL">
						<div class="Title" >
							<p id="tituloContenedor">Huellas del trabajador</p>
						</div>
						<div class="Container">
						<div class="Layout__XL">
							<div class="Datos_Container">
								<div class="row_container">
									<div class="Datosxxl"><strong>Curp Empleado: </strong> ${curpEmpleado}</div>
									<c:if test = "${not empty curp}">
										<div class="Datosxxl"><strong>Curp Trabajador: </strong> ${curp}</div>
									</c:if>
									<c:if test = "${not empty nss}">
										<div class="Datosxxl"><strong>NSS Trabajador: </strong> ${nss}</div>
									</c:if>
								</div>
								<div class="Section">
									<div class="Footprints_Section">
										<canvas id='the-canvas'></canvas>
									</div>
								</div>
								<div class="row_container">
									<c:if test = "${not empty datos}">
										<object id="MyActiveEnrolador" width="690" height="280" classid="clsid:B5B966D7-AFE8-4EEB-8972-CEF7F115AD9B" codebase="http://192.168.1.61/biometricosar/webResources/jnlp/BanorteBiomX.cab">
												Este texto se mostrará si se abre la página con un browser no compatible o si el ActiveX no está instalado correctamente.
										</object>
										<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dispositivos/530/activeXBanote.js'/>"></script>
									</c:if>
								</div>
							</div>
						</div>
					</div>
					</div>
				</div>
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
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/obtenerHuellas.js'/>"></script>
</body>
</html>
