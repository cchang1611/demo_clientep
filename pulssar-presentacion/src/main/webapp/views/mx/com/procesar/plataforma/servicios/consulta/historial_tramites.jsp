<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Historial Tramites</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	
  
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  
	<script src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bootstrap_tables_dynamic.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/dataTables.bootstrap.min.css'/>"></link>
	<script src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
	<script src="<c:url value='/webResources/js/dataTables.bootstrap.min.js'/>"></script>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Historial de Tr&aacute;mites" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "5" />
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
				<h1>Historial de Tr&aacute;mites</h1>
			</div>

		<div class="Container">


			<div class="Layout__XL">
				<form name="table" method="post" action="#">
					<div style="overflow-x: auto;">
						<table id="tablaFolios" class="table table-striped table-bordered">
						<thead>
							<tr class="RowHeader">
								<th>Status</th>
								<th>Folio</th>
								<th>Tr&aacute;mite</th>
								<th>Fecha</th>
								<th>Fecha Conclusi&oacute;n</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${folios}" var="folios" varStatus="stat">
								<tr>
									<td><c:out value="${folios.estatusPadre}"/></td>
<%-- 									<c:choose> --%>
<%-- 										<c:when test="${folios.folioHijo == 'Si'}"> --%>
											<td><a href="historialTramitesDetalle.do?id=<c:out value='${folios.idFolioPulssar}'/>"><c:out value="${folios.chFolio}" /></a></td>
<%-- 										</c:when> --%>
<%-- 										<c:otherwise> --%>
<%-- 											<td><c:out value="${folios.chFolio}" /></td> --%>
<%-- 										</c:otherwise> --%>
<%-- 									</c:choose> --%>
									<td><c:out value="${folios.descripcionServicio}" /></td>
									<td><c:out value="${folios.fechaLlegada}" /></td>
									<td><c:out value="${folios.fechaCierre}" /></td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</form>
			</div>


		</div>



		<jsp:include page="../menus/menuConsulta.jsp" />
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<script src="<c:url value='/webResources/js/historialTramites.js'/>"></script>
</body>
</html>
