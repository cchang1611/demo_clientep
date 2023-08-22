<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<html lang="es">
<head>
<title>Salarios y Saldo</title>
<meta charset="utf-8" />
<![if IE]>
	<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
<![endif]>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <script type="text/javascript">
	var context = '${pageContext.request.contextPath}';
  </script>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/header.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/footer.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>">
  <link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
				<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
				<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/accordion.js'/>"></script>
				<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/ventanaPdfs.js'/>"></script>
				<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/table_retiros.js'/>"></script>
			  <script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
			  <script src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<%
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
 %>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Ayuda de Desempleo" />
		<jsp:param name="menuPrimario" value="2" />
		<jsp:param name="menuSecundario" value="2" />
		<jsp:param name="menuInactivo" value="1" />
	</jsp:include>


    <div class="wrapper">
		<div class="Title__Container">
			<h1>Tipo de Retiro</h1>
		</div>
	<form:form class="ModalFooter" method="post" id="retiroDesempleoImss"
		action="${pageContext.request.contextPath}/private/solicituddisposicion.do">
		<input id="selloTrabajador" type="hidden" name="selloTrabajador"
			value="${salida.selloTrabajador}" />
		<input id="numeroResolucion" type="hidden" name="numeroResolucion"
			value="${salida.numeroResolucion}" />
		<input type="hidden" name="tipoRetiroDesempleo" id="tipoRetiroDesempleo"/>	
		<input type="hidden" id="folio1" name="folio1" value="${folio.folio}" />
		<input type="hidden" id="idFolio" name="idFolio" value="${folio.idFolio}" />
		<input type="hidden" id="folioHijo" name="folioHijo" value="${folio.folioHijo}" />
		<input type="hidden" id="afore" name="afore" value="${datos.claveAfore}" />

		<!-- Inicia seccion -->
		<div class="Container">
			<div class="Layout__XL">
				<div onclick="sectionone()" class="Title_OneOption">
					<div class="Title_Text">Tipo retiro A:</div>
            		<div class="Arrows"></div>
				</div>

				<div id="section_one" class="Container_One">
					<div class="row_containerbox">
							<label class="LabelTextEdit" for="usuario">Monto a
								Disponer $:</label> <input class="InputEdit" type="text" name="montoDispA" id="montoDispA"
								value="${tipoRetiro.montoADisponerA}" /> <label
								class="LabelTextEdit" for="usuario">Salario Base
								Cotizaci&oacute;n $:</label> <input class="InputEdit" type="text"
								name="" value="${tipoRetiro.sbcTipoA}" /> <label
								class="LabelTextEdit" for="usuario">Unidad de Medida SBC
								de Actualizaci&oacute;n (UMA):</label> <input class="InputEdit"
								type="text" name="" value="${tipoRetiro.uma}" /> <label
								class="LabelTextEdit" for="usuario">C&aacute;lculo:</label> <input
								class="InputEdit" type="text" name=""
								value="${tipoRetiro.calculoA}" />
							<div class="ContainerButtons">
								<a id="ligaFormaPagoUno" onclick="sectiontree()" class="Submitx">Forma
									de Pago</a>
							</div>
							<div id="mensajeErrorSectionTree"></div>
					</div>

					<div id="section_tree" class="Section_Tree">					
					</div>					
				</div>


			</div>
			<!-- Layout__XL -->
			<div class="Layout__XL">
				<div id="section" onclick="section_two()" class="Title_TowOption">
					<div class="Title_Text">Tipo retiro B:</div>
            		<div class="Arrows"></div>
				</div>

				<div id="section_two" class="Container_Two">
						<div class="row_containerbox">
							<label class="LabelTextEdit" for="usuario">Monto a
								Disponer $:</label> <input class="InputEdit" type="text" name="montoDispB" id="montoDispB"
								value="${tipoRetiro.montoADisponerB}"> <label
								class="LabelTextEdit" for="usuario">Salario Base
									Cotizaci&oacute;n:</label> <input class="InputEdit" type="text" name=""
								value="${tipoRetiro.sbcTipoB}"> <label
									class="LabelTextEdit" for="usuario">C&aacute;lculo con
										SBC y Semanas Cotizadas:</label> <input class="InputEdit" type="text"
									name="" value="${tipoRetiro.calculoB}"> <label
										class="LabelTextEdit" for="usuario">C&aacute;lculo con
											Porcentaje de (RCV):</label> <input class="InputEdit" type="text"
										name="" value="${tipoRetiro.calculoPorcentaje}">
						</div>

<c:if test="${not empty tipoRetiro.seisMensualidadesIguales}">					
					<div class="Container_Three">
						<div class="row_containerfloat contenedor_mensualidades_seis">
							<table>
								<thead>
									<tr>
										<td colspan="2"><input type="radio" checked name="tipoPlaso" id="tipoPlaso1" value="1"/>
											<label for="tipoPlaso1">Pago en seis mensualidades con montos proporcionales</label>
										</td>
									</tr>
								</thead>
								<tbody>
									<tr class="RowHeader">
										<th>Mensualidad</th>
										<th>Monto</th>
									</tr>
									<c:forEach items="${tipoRetiro.seisMensualidadesIguales}"
										var="mensualidad" varStatus="stat">
										<c:choose>
											<c:when test="${stat.index % 2 == 0}">
												<tr class="Row1">
													<td><c:out value="${stat.index +1}" /></td>
													<td><c:out value="${mensualidad}" /></td>
												</tr>
											</c:when>
											<c:otherwise>
												<tr class="Row2">
													<td><c:out value="${stat.index +1}" /></td>
													<td><c:out value="${mensualidad}" /></td>
												</tr>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
						<div class="row_containerfloat contenedor_mensualidades_seis">
							<table>
									<thead>
										<tr>
											<td colspan="2"><input type="radio" name="tipoPlaso" id="tipoPlaso2" value="2" <c:if test="${empty tipoRetiro.seisMensualidades}">disabled="disabled"</c:if>/>
												<label for="tipoPlaso2">Pago en seis mensualidades con el primer monto de 30 días del último SBC</label>
											</td>
										</tr>
									</thead>
									<tbody>							
									<tr class="RowHeader">
										<th>Mensualidad</th>
										<th>Monto</th>
									</tr>
									<c:choose>
										<c:when test="${!empty tipoRetiro.seisMensualidades}">
										<c:forEach items="${tipoRetiro.seisMensualidades}"
											var="mensualidad" varStatus="stat">
											<c:choose>
												<c:when test="${stat.index % 2 == 0}">
													<tr class="Row1">
														<td><c:out value="${stat.index +1}" /></td>
														<td><c:out value="${mensualidad}" /></td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr class="Row2">
														<td><c:out value="${stat.index +1}" /></td>
														<td><c:out value="${mensualidad}" /></td>
													</tr>
												</c:otherwise>
											</c:choose>
										</c:forEach>										
										</c:when>
										<c:otherwise>
											<tr class="Row1">
												<td colspan="2">NO APLICA</td>
											</tr>
										</c:otherwise>
									</c:choose>
									</tbody>
							</table>
						</div>	
												
						<div class="row_containerfloat contenedor_mensualidades_dos">
							<table>
									<thead>
										<tr>
											<td colspan="2"><input type="radio" name="tipoPlaso" id="tipoPlaso3" value="3" <c:if test="${empty tipoRetiro.dosMensualidades}">disabled="disabled"</c:if>/>
												<label for="tipoPlaso3">Pago en dos mensualidades</label>
											</td>
										</tr>
									</thead>
									<tbody>							
									<tr class="RowHeader">
										<th>Mensualidad</th>
										<th>Monto</th>
									</tr>
									<c:choose>
										<c:when test="${!empty tipoRetiro.dosMensualidades}">
										<c:forEach items="${tipoRetiro.dosMensualidades}"
											var="mensualidad" varStatus="stat">
											<c:choose>
												<c:when test="${stat.index % 2 == 0}">
													<tr class="Row1">
														<td><c:out value="${stat.index +1}" /></td>
														<td><c:out value="${mensualidad}" /></td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr class="Row2">
														<td><c:out value="${stat.index +1}" /></td>
														<td><c:out value="${mensualidad}" /></td>
													</tr>
												</c:otherwise>
											</c:choose>
										</c:forEach>										
										</c:when>
										<c:otherwise>
											<tr class="Row1">
												<td colspan="2">NO APLICA</td>
											</tr>
										</c:otherwise>
									</c:choose>
									</tbody>
							</table>
						</div>	
</c:if>						
						<div class="row_containerfloat contenedor_mensualidades_dos">
							<table>
									<thead>
										<tr>
											<td colspan="2"><input type="radio" checked name="tipoPlaso" id="tipoPlaso4" value="4" <c:if test="${empty tipoRetiro.unaMensualidad}">disabled="disabled"</c:if> />
												<label for="tipoPlaso4">Pago en una mensualidad</label>
											</td>
										</tr>
									</thead>
									<tbody>							
									<tr class="RowHeader">
										<th>Mensualidad</th>
										<th>Monto</th>
									</tr>
									<c:choose>
										<c:when test="${!empty tipoRetiro.unaMensualidad}">
										<c:forEach items="${tipoRetiro.unaMensualidad}"
											var="mensualidad" varStatus="stat">
											<c:choose>
												<c:when test="${stat.index % 2 == 0}">
													<tr class="Row1">
														<td><c:out value="${stat.index +1}" /></td>
														<td><c:out value="${mensualidad}" /></td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr class="Row2">
														<td><c:out value="${stat.index +1}" /></td>
														<td><c:out value="${mensualidad}" /></td>
													</tr>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										</c:when>
										<c:otherwise>
											<tr class="Row1">
												<td colspan="2">NO APLICA</td>
											</tr>
										</c:otherwise>
									</c:choose>
									</tbody>
							</table>
						</div>	

						<div class="row_containerfloat">
						</div>
						<div class="ContainerButtons">
							<a onclick="sectionfour()" class="Submitx" id="ligaFormaPagoDos">Forma de Pago</a>
							<div id="mensajeErrorSectionFour"></div>
						</div>						
					</div>
					</div>

					<div id="section_four" class="Section_Four">
					</div>


					<div class="ContainerButtons">
						<input id="btnSolicitarDep" class="Submitx" type="button" value="Solicitar"/>
					</div>
				</div>
			</div>
		<jsp:include page="../retiro/modalTipoRetiro.jsp" />	
	      <div class="push"></div>
		</div>
		
	</form:form>

	<div id="seccionModalPdf"></div>		
	<!-- Finaliza seccion -->	

	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/accordion.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modaltiporetiro.js'/>"></script>
	<script type="text/javascript">
		jsonInstiticionesBancarias = '${jsonInstitucionBancaria}';	
		var parametroForm = "#retiroDesempleoImss";
	</script>	

	<jsp:include page="../generales/footerAgente.jsp" />
</body>
</html>