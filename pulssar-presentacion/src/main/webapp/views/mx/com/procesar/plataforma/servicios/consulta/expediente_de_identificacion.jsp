<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Expediente de Identificación</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Consulta del Trabajador" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "3" />
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
				<h1>Expediente de Identificación</h1>
			</div>
			
			<div class="Container">
				<div class="Layout__XL">
					<div class="Title">
						<p>Expediente de Identificación</p>
					</div>
					<div class="Datos_Container">
						<div class="row_container">
							<div class="Datosxxl" id="idEstatusI"><strong>ESTATUS EXPEDIENTE: </strong> ${expediente.descEstatusExpedienteIdentificacion}</div>
							<div class="Datosxxl" id="idFcIde"><strong>FECHA CONFORMACIÓN: </strong> ${expediente.fechaIDE}</div>
							<div class="Datosxxl" id="idAfore"><strong>AFORE: </strong> ${expediente.descAforeIdentificacion}</div>
						</div>
						
						<div class="Container_Three">
							<div class="row_containerfloat">
								<table>
									<tr class="RowHeader">
										<th>Datos Validados</th>
										<th>Respuesta</th>
									</tr>
									<tr class="Row1" id="idSNombre">
										<td>Nombre</td>
										<td>${expediente.similitudNombre}</td>
									</tr>
									<tr class="Row2" id="idSRostro">
										<td>Rostro</td>
										<td>${expediente.similitudRostro}</td>
									</tr>
									<tr class="Row1" id="idSDomicilio">
										<td>Domicilio</td>
										<td>${expediente.similitudDomicilio}</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<c:if test="${expediente.expedienteMovil != 'NO ACTIVO'}">
						<div class="Title">
							<p>Expediente Móvil</p>
						</div>
						<div class="Datos_Container">
							<div class="row_container">
								<div class="Datosxxl" id="idExpedienteM"><strong>EXPEDIENTE MOVIL:</strong> ${expediente.expedienteMovil}</div>
								<div class="Datosxxl" id="idFechaConformacion"><strong>FECHA CONFORMACIÓN:</strong> ${expediente.fechaConformacion}</div>
								<div class="Datosxxl" id="idAforeMovil"><strong>AFORE:</strong> ${expediente.descAforeMovil}</div>
							</div>
						</div>
					</c:if>
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
