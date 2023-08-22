
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	href="<c:url value='/webResources/css/timepicki.css'/>">
<link rel="stylesheet" charset="utf-8" type="text/css"
	href="<c:url value='/webResources/css/general/loader.css'/>"></link>
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
<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
<script type="text/javascript" charset="utf-8"
	src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
<script type="text/javascript" charset="utf-8"
	src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
<jsp:include page="header.jsp" />

<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/util/js/plataforma_operativa/plataforma_operativa.js'/>"></script>
<script type="text/javascript" 
	src="<c:url value='/webResources/plataforma_operativa/util/js/plataforma_operativa/combos_reporte.js'/>"></script>
<script type="text/javascript"  
	src="<c:url value='/webResources/plataforma_operativa/util/js/plataforma_operativa/seleccion_parametros.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAgente.jsp">
			<jsp:param name="encabezado" value="0" />
			<jsp:param name="menuPrimario" value="1" />
			<jsp:param name="menuSecundario" value="1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
			var _VAR = '${cVar}';
			var context = '${pageContext.request.contextPath}';
			var rolesSession = "${sessionScope.roles}"
			var areasSession = "${employeeType}"
			var idRolesSession = "${idRoles}";
		</script>
		<div class="container mtb-2">
			<div class="row">
				<div class="col-xs-12">
					<jsp:include page="menu.jsp" />
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title">
								Plataforma de Servicios Operativa <span class="navBarMinerva" id="navBarMinerva"
									hidden="true"></span>
							</h3>
						</div>
						<div class="panel-body">
							<div class="minerva-row">
								<form:form modelAttribute="plataformaOperativaForm" id="minervaForm"
									class="form-inline">
									<!-- Formulario de Módulo, Proceso, Subproceso y consulta -->
									<jsp:include page="controlesConsulta.jsp"></jsp:include>
									<!-- Formulario de fechas, NSS, CURP, ID PROCESAR -->
									<jsp:include page="seleccionParametros.jsp"></jsp:include>
									<div id="divBtnMinervaConsultar" align="center" hidden="true">
										</br> </br>
										<!-- 				<button id="btnRegresarCombosMinerva" type="button" class="btn btn-primary btn-default" onclick="regresarCombos();">Regresar</button> -->
										<button id="btnConsultaMinerva" type="button"
											class="btn btn-primary btn-default"
											onclick="consultarReporte();">Consultar</button>
									</div>
									<div id="frame" style="min-height: 300px;">
										<iframe
										id="frameExterno" frameborder="0" width="100%" style="min-height: 300px;"></iframe>
									</div>
									<!-- RESULTADOS -->
									<div id="divMinervaResultados" align="center" hidden="true">
										<table class="form-control">
											<tr>
												<td align="center" id="nomReporte"></td>
											</tr>
										</table>
										<br>
										<table>
											<tr>
												<td align="center"><label for="tituloMinerva"
													class="control-label" style="font-color: #00395A;">&nbsp;</label>
												</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
											</tr>
										</table>
										<div id="idDivTblCons" class="table-responsive"></div>
										<nav id="paginador" hidden="true"></nav>

										<div>
											<div id="idDivTblResul"
												class="table-responsive minerva-table"
												style="overflow: hidden;">
												<table id="tabResultadoCons" border="1"
													class="table table-bordered table-striped">
												</table>
												<div id="pager"></div>
											</div>
										</div>
									</div>
									<div id="divBtnMinervaExportar" align="center" hidden="true">
										</br>
										<button id="btnExportarMinerva" type="button"
											class="btn btn-primary btn-default"
											onclick="exportaResultadoProt();">Exportar</button>
										<button id="btnExportarPdfMinerva" type="button"
											class="btn btn-primary btn-default"
											onclick="exportaResultadoPlantilla();">Exportar
											Detalle</button>
										<button id="btnExportarRegresarMinerva" type="button"
											class="btn btn-primary btn-default"
											onclick="regresarSeleccionParametros();">Regresar</button>
									</div>
								</form:form>
							</div>

							<div id="idDivDialo" style="position: relative">
								<jsp:include page="dialogs.jsp" />
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="../generales/footerAgente.jsp" />

	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/mensajes.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/timepicki.js'/>"></script>
	<script type="text/javascript">
		$('#timepicker1').timepicki({
			show_meridian : false,
			min_hour_value : 0,
			max_hour_value : 12,
			overflow_minutes : true,
			increase_direction : 'up',
			disable_keyboard_mobile : true,
			start_time : [ "00", "00" ]
		});
	</script>
	<jsp:include page="../generales/modals.jsp" />
</body>