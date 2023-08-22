<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>ICEFAS</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	  <!-- Data Tables Bootstrap Dynamic CSS  and javascript -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bootstrap_tables_dynamic.css'/>"></link>
    <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/dataTables.bootstrap.min.css'/>"></link>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dataTables.bootstrap.min.js'/>"></script>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
  <script>
    $(document).ready(function() {
      $('#idTableIcefas').DataTable({
    "language": {
          "url": "../webResources/js/general/Spanish.json"
        }
      });
    });
 </script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Consulta del Trabajador" />
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
				<h1>ICEFAS</h1>
			</div>

		<div class="Container">
			<div class="Layout__XL">
				<div class="SeccionTable">
					<div style="overflow-x: auto;">
						<c:if test="${empty icefas}">
							<div class="Datos_Container">
								<div class="row_container">
									<div class="Datosxxl">
										<strong>No se encontraron ICEFAS relacionadas a la
											cuenta del Trabajador</strong>
									</div>
								</div>
							</div>
						</c:if>
						<c:choose>
							<c:when test="${not empty icefas}">
								<table id="idTableIcefas" class="table table-striped table-bordered" style="width: 100%">
									<thead>
										<tr class="RowHeader2">
											<th colspan="5">DATOS GENERALES</th>
											<th colspan="5" align="center">DATOS ICEFA</th>
										</tr>
										<tr class="RowHeader">
										    <th>NOMBRE</th>
										    <th>APELLIDO PATERNO</th>
										    <th>APELLIDO MATERNO</th>
											<th>NOMBRE TRABAJADOR EN ICEFA</th>
											<th>FECHA DE NACIMIENTO</th>
											<th>RFC</th>
											<th>NSS</th>
											<th>CURP</th>
											<th>CLAVE ICEFA</th>
											<th>NCI</th>
											<th>NOMBRE DEL BANCO</th>
											<th>NOMBRE DEL PATRON</th>
											<th>RFC DEL PATRON</th>
											<th>CUENTA CON SALDO</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${icefas}" var="icefa"
											varStatus="loopCounter">
											<c:choose>
												<c:when test="${loopCounter.index % 2 == 0}">
													<tr class="Row1">
												</c:when>
												<c:otherwise>
													<tr class="Row2">
												</c:otherwise>
											</c:choose>
											<td><c:out value="${icefa.nombre}" /></td>
											<td><c:out value="${icefa.apellidoPaterno}" /></td>
											<td><c:out value="${icefa.apellidoMaterno}" /></td>
											<td><c:out value="${icefa.nombreTrabajador}" /></td>
											<td><c:out value="${icefa.fechaNacimiento}" /></td>
											<td><c:out value="${icefa.rfc}" /></td>
											<td><c:out value="${icefa.nss}" /></td>
											<td><c:out value="${icefa.curp}" /></td>
											<td><c:out value="${icefa.icefa}" /></td>
											<td><c:out value="${icefa.controlInterno}" /></td>
											<td><c:out value="${icefa.nombreBanco}" /></td>
											<td><c:out value="${icefa.nombrePatron}" /></td>
											<td><c:out value="${icefa.rfcPatron}" /></td>
											<td><c:out value="${icefa.indicadorSaldo}" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:when>
						</c:choose>
					</div>
				</div>
				<div>
                     *Información conformada en las entidades de SAR92 y SARISSSTE (ICEFAS)
                </div>
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
	
	<script src="<c:url value='/webResources/js/cargaRefBen.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
</body>
</html>
