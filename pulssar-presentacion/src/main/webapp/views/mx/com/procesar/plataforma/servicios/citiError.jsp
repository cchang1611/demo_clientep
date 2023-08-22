<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Cierre Consulta</title>
	<![if IE]>
		<link id="colorsIE" type="text/css" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templatemo_style.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/index.css'/>"></link>
	<link rel="shortcut icon" charset="utf-8" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="utf-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery-3.0.0.min.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.plugin.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.realperson.js'/>"></script>
</head>
<body>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
		var _URLAFORE = "${respuesta.mensaje}";
	</script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/logoutCoppel.js'/>"></script>
	<div class="wrapper" id="cierreVentana" style="display:none;">
		<jsp:include page="generales/headerPrincipal.jsp">
			<jsp:param name="aforeCiti" value="1" />
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="titulo" value="ERROR ACCESO" />
		</jsp:include>
		<jsp:include page="generales/headGeneral.jsp"></jsp:include>
		<section>
			<div class="Container">
				<div class="Layout__M">
					<div class="Datos_Container">
						<div class="ContainerButtonsCenter">
							<c:if test="${not empty error}">
								<h1 class="Title__Label">Error: ${error}</h1>
							</c:if>
							<c:if test="${empty error}">
								<h1 class="Title__Label">El usuario se cerró con éxito.</h1>
							</c:if>
						</div>
						<a href="${urlBanamex}" class="Submitxl"> Finaliza </a>
					</div>
				</div>
			</div>
		</section>
		<div class="push"></div>
	</div>
	<div id="cierreFooter" style="display:none;">
		<jsp:include page="generales/footerPrincipal.jsp" />
	</div>
</body>
</html>
