<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>

<%@ page
	import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.enumeradores.ReintegroEstatusEnum"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Reintegro de recursos por un retiro parcial por desempleo</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/container.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/templates.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/tables.css'/>"></link>


<link rel="shortcut icon"
	href="<c:url value='/webResources/img/favicon.ico'/>"></link>
<link
	href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap"
	rel="stylesheet"></link>
<script type="text/javascript" charset="UTF-8"
	src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
<script type="text/javascript" charset="UTF-8"
	src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
<script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
<script type="text/javascript"
	src="<c:url value="/webResources/js/reintegroRecursosDesempleo.js"/>"></script>

</head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
FolioEntrada folio = datos.getFolio();
%>
<body>
	<input type="hidden" id="mensaje" value="${mensaje}" />
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle"
			value="Reintegro de recursos por un retiro parcial por desempleo" />
		<jsp:param name="menuPrimario" value="2" />
		<jsp:param name="menuSecundario" value="2" />
		<jsp:param name="menuInactivo" value="2" />
	</jsp:include>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
	</script>
	<!-- Inicia Wrapper -->
	<div class="wrapper">
		<div class="Title__Container">
			<h1>
				Confirmación Reintegro de recursos por un retiro
				<p>parcial por desempleo</p>
			</h1>
		</div>

		<div class="Container">
			<div class="Layout__XL" style="width: 90%;">

				<div class="Title">
					<p>Confirmación</p>
				</div>

				<div class="Datos_Container">
					<table id="tableConfirmarReintegro">
				  		<tbody>
					  	<c:choose>
					  		<c:when test="${empty solicitud.lstConfirmacion}">
					  			<tr>
					  				<th>
					  					<td>NO SE ENCONTRO HIST&Oacute;RICO CONFIRMACI&Oacute;N</td>
					  				</th>
					  			</tr>
					  		</c:when>
					  		<c:otherwise>
					  			<tr class="RowHeader">
					  				<th>N&Uacute;MERO DE RESOLUCI&Oacute;N</th>
					  				<th>VALOR DEL DÍA</th>
					  				<th>NÚMERO DE PARCIALIDAD</th>
					  				<th>SEMANAS POR REINTEGRAR</th>
					  				<th>MONTO TOTAL A REINTEGRAR</th>
					  				<th>FECHA DE ESTATUS</th>
					  				<th>ESTATUS DE CONFIRMACIÓN</th>
					  				<th>COMPROBANTE ADJUNTO</th>
					  			</tr>			  						  				
					  		
					  			<c:forEach items="${solicitud.lstConfirmacion}" var="retiro" varStatus="numRen">
					  				<tr class="Row${numRen.index%2==0?"1":"2"} renglonHistorico" data-indice="${numRen.index}">
					  					<td>${retiro.numeroResolucion}</td>
					  					<td>$ ${retiro.valorIntegrar}</td>
					  					<td>${retiro.numeroReintegro}</td>
					  					<td>${retiro.semanasReintegrar}</td>
					  					<td>$ ${retiro.montoTotalReintegrar}</td>
					  					<td>${retiro.fechaRetiroVista}</td>
					  					
					  					<td>
						  					<c:choose>
										        <c:when test="${retiro.estatusReintegro == '01'}">Registrado</c:when>
										        <c:when test="${retiro.estatusReintegro == '02'}">Enviado</c:when>
										        <c:when test="${retiro.estatusReintegro == '03'}">Aceptado</c:when>
										        <c:when test="${retiro.estatusReintegro == '04'}">Rechazado</c:when>
										        <c:otherwise>undefined</c:otherwise>
										    </c:choose>
					  					</td>
					  					<td>
											<c:choose>
										        <c:when test="${retiro.estatusReintegro == '01'}">
										        	<button class="Submitxl" onclick="submitAdjuntar('${retiro.numeroResolucion}', '${retiro.numeroReintegro}')">Adjuntar</button>
										        </c:when>
										        <c:otherwise>
										        	<button disabled class="Submit_disabled" onclick="submitAdjuntar('${retiro.numeroResolucion}', '${retiro.numeroReintegro}')">Adjuntar</button>
										        </c:otherwise>
										    </c:choose>
					  					</td>
					  				</tr>
					  			</c:forEach>			  		
					  		</c:otherwise>
					  	</c:choose>			  			
				  		</tbody>
				  	</table>
				</div>
			</div>
		</div>
		<!-- finaliza titulo seccion -->
		<div class="push"></div>
	</div>

	<!-- Finaliza Wrapper -->
	<div class="push"></div>

	<!-- finaliza Ventana Modal 2 -->
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
	
	<form id="formAdjuntar" action="documentosReintegroRecursos.do" method="get">
	 <input id="inputResolucion" name="resolucion" type="hidden"/>
	 <input id="inputNumeroReintegro" name="numeroReintegro" type="hidden"/>
	</form>
	
</body>
</html>
