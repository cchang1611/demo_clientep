<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" />
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Home</title>
<meta charset="utf-8" />
<![if IE]>
<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet"
	href="<c:url value='/webResources/css/general/main_ie.css'/>" />
<![endif]>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" charset="utf-8" type="text/css"
	href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
<link rel="stylesheet" charset="utf-8" type="text/css"
	href="<c:url value='/webResources/css/general/templates.css'/>"></link>
<link rel="stylesheet" charset="utf-8" type="text/css"
	href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
<link rel="stylesheet" charset="utf-8" type="text/css"
	href="<c:url value='/webResources/css/general/container.css'/>"></link>
<link rel="stylesheet" charset="utf-8" type="text/css"
	href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>

<!--  <link rel="stylesheet" charset="utf-8" type="text/css"
	href="<c:url value='/webResources/css/general/tables.css'/>"></link>  -->

<link charset="utf-8" rel="shortcut icon"
	href="<c:url value='/webResources/img/favicon.ico'/>"></link>
<link charset="utf-8"
	href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap"
	rel="stylesheet"></link>
<script type="text/javascript" charset="UTF-8"
	src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
<script type="text/javascript" charset="utf-8"
	src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
<script type="text/javascript" charset="utf-8"
	src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
<jsp:include page="../plataforma_operativa/header.jsp" />
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAgente.jsp">
			<jsp:param name="encabezado" value="1" />
			<jsp:param name="menuPrimario" value="1" />
			<jsp:param name="menuSecundario" value="1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
			var _VAR = '${cVar}';
			var context = '${pageContext.request.contextPath}';
		</script>
		<div class="container mtb-2">
			<div class="row">
				<div class="col-xs-12">
				<jsp:include page="../plataforma_operativa/menu.jsp" />
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								MASIVOS <span class="navBarMinerva" id="navBarMinerva"
									hidden="true"></span>
							</h3>
						</div>
						<div class="panel-body">
							<div class="minerva-row">
								<div id="menuMinervaMasivos">
									<ul id="navTab" class="nav nav-tabs">
										<li class="active"><a data-toggle="tab" href="#solicitud"
											onclick="changeModuloMasivo(-1); inicializaFormulario();">Solicitud
												de Reporte</a></li>
										<li><a data-toggle="tab" href="#estado"
											onclick="inicializarFormularioSolicitud();">Estado de
												solicitud</a></li>
									</ul>

									<div class="tab-content">

										<div id="solicitud" class="tab-pane well active">
											<jsp:include page="parametrosMasivas.jsp"></jsp:include>
										</div>

										<div id="estado" class="tab-pane well fade">
											<jsp:include page="estadoSolicitud.jsp"></jsp:include>
										</div>

									</div>
								</div>
							</div>
							<div id="idDivDialo" style="position: relative">
								<jsp:include page="../plataforma_operativa/dialogs.jsp" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>