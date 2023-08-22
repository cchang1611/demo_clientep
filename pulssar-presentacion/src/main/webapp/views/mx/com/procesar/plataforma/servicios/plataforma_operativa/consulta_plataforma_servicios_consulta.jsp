<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Consulta Plataforma Servicios</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<cp:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/general/tabs.css'/>"></link>
		 <link rel="stylesheet" charset="utf-8" type="text/css" href="<cp:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="shortcut icon" href="<cp:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	  <!-- Data Tables Bootstrap Dynamic CSS  and javascript -->
	 <link rel="stylesheet" type="text/css" href="../webResources/css/general/modal_window.css"></link>
    <link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/bootstrap_tables_dynamic.css'/>"></link>
    <link rel="stylesheet" type="text/css" href="<cp:url value='/webResources/css/dataTables.bootstrap.min.css'/>"></link>
    <script type="text/javascript" charset="UTF-8" src="<cp:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
    <script type="text/javascript" charset="utf-8" src="<cp:url value='/webResources/js/resultadoPlataformaServicios.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<cp:url value='/webResources/js/pestana.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<cp:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
    <script type="text/javascript" charset="UTF-8" src="<cp:url value='/webResources/js/dataTables.bootstrap.min.js'/>"></script><script type="text/javascript" charset="utf-8" src="<cp:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	
</head>

<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Consulta de Servicios" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "9" />
	</jsp:include>
	<script type="text/javascript">		
	           var respuestas = "${listas}";
	           var _MENSAJE = "${respuesta.mensaje}";
	           var _CLAVE_SERVICIO = "${claveServicioPlataforma}";
	</script>
	
	<div class="wrapper">
		<section>
			<div class="Title__Container">
				<h1>Consulta Plataforma Servicios</h1>
			</div>
			
			<div class="Container">
				<div class="Layout__XL">
		  <cp:choose>
              <cp:when test="${listas == null}">
                 <center><b>No se encontraron resultados relacionados a los criterios seleccionados/capturados.</b></center>
              </cp:when>
			 <cp:otherwise>
			 <div class="Form__Box">
								<div class="Form">
									<label class="LabelText" for="usuario">Filtro:</label>
								</div>
								<div class="Form__BoxChild">
									<select class="Select" id="sFiltro">
										<option value="">Selecciona una Opción</option>
										<option value="0">Fecha de la generación</option>
										<option value="1">Clave de Afore</option>
										<option value="2">Usuario</option>
										<option value="3">Folio Pulssar</option>
										<option value="4">Resultado de la Operación</option>
										<option value="5">Diagnóstico</option>
									</select>
								</div>
								<div class="Form__BoxChild">
									<input class="Inputxxl SearchInput column_filter" type="text" id="dSearch" disabled="true" />
								</div>
								<div class="Form">
									<input id="btnBuscar" class="Submit Search" type="button" value="Buscar" disabled="true" />
								</div>
							</div>
				<div class="SeccionTable">
		          <div style="overflow-x: auto;">
		            <table id="tablaConsulta" class="table table-striped table-bordered" style="width:100%">
		              <thead>
		                <tr class="RowHeader" style="font-size:12px;">
		                  <th>Fecha / Hora<br>de la generación del Folio</th>
		                  <th>Clave de la Afore</th>
		                  <th>Usuario</th>
		                  <th>Folio Pulssar</th>
		                  <th>Resultado de la Operación</th>
						  <th>Diagnóstico</th>
		                </tr>
		              </thead>
		              <tbody>
			                <cp:forEach items="${listas}" var="listas"
														varStatus="loopCounter">
														<cp:choose>
															<cp:when test="${loopCounter.index % 2 == 0}">
																<tr class="Row1">
															</cp:when>
															<cp:otherwise>
																<tr class="Row2">
															</cp:otherwise>
														</cp:choose>
														<td id="celda1">${listas.fechaGeneracionFolio}</td>
														<td id="celda2">${listas.claveAfore}</td>
														<td id="celda3">${listas.usuario}</td>
														<td id="celda4">${listas.folioPulssar}</td>
														<td id="celda5">${listas.resultadoOperacion}</td>
														<td id="celda6">${listas.diagnostico}</td>
														</tr>
							</cp:forEach>
		              </tbody>
		            </table>
		              </div>
		            </div>
		        </cp:otherwise>	
			</cp:choose>    
				<br></br>
			<br></br>
			<br></br>
			<br></br>
			<div class="ContainerButtonsCenter">
								 <a id="exportarExcel" href="#" onclick="generarNombreExcel()" class="Submitx">EXCEL</a>
								 <cp:choose>
              						<cp:when test="${not empty datoclaveServicioPlataforma}">
                 						<a  href="capturaPlataformaServicios.do?servicio=${claveServicioPlataforma}&dato=${datoclaveServicioPlataforma}" onclick="" class="Submitx">REGRESAR</a>
              						</cp:when>
			 						<cp:otherwise>
								 		<a  href="capturaPlataformaServicios.do?servicio=${claveServicioPlataforma}" onclick="" class="Submitx">REGRESAR</a>
								 	</cp:otherwise>
								 </cp:choose>
							</div>				
				</div>
			</div>
    
  </div>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	<script type="text/javascript" charset="UTF-8" src="<cp:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
