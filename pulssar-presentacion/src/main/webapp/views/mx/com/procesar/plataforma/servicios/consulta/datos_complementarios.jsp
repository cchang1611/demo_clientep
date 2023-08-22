<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Datos Complementarios</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
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
		<jsp:param name="menuInactivo" value = "2" />
	</jsp:include>
	<script type="text/javascript">		
		var _REFERENCIAS = "${referencias}";
		var _BENEFICIARIOS = "${beneficiarios}";
		var _MARCAS = "${marcas}";
		var _FLUJO="";
		var _CURPS = "";
	</script>
	
	<div class="wrapper">
		<section>
			<div class="Title__Container">
				<h1>Datos Complementarios</h1>
			</div>
			
			<div class="Container">
				<div class="Layout__XL">
					<div class="Title">Dirección Particular</div>
					<div class="Datos_Container">
						<div class="row_container">
							 <div class="Datos" id="idPcalle"><strong>Calle:</strong> ${domParticular.calle}</div> 
							<div class="Datos" id="idPnoExterior"><strong>no.ext:</strong> ${domParticular.noExterior}</div>
							<div class="Datos" id="idPnoInterior"><strong>no.int:</strong> ${domParticular.noInterior}</div>
							<div class="Datos" id="idPcolonia"><strong>Colonia:</strong> ${domParticular.colonia}</div> 
							
							
						</div>
						<div class="row_container">
							<div class="Datos" id="idPmunicipio"><strong>Municipio:</strong> ${domParticular.municipio}</div>
							<div class="Datos" id="idPentFederativa"><strong>Ent Fed:</strong> ${domParticular.entidadFederativa}</div>
							<div class="Datos" id="idPcodigo"><strong>C.P:</strong> ${domParticular.codigoPostal}</div>
						</div>
						
						<div class="row_container">
						   <div class="Datos" id="idPfechaControl"></div>
						   <div class="Datos" id="idPfechaControl"></div>
						   <div class="Datos" id="idPfechaControl"></div>
						   <div class="Datos" id="idPfechaControl" style="position:relative;width:300px;padding:10px;" ><strong>Fecha de modificacion de los datos:</strong> ${domParticular.fechaControl}</div>
						</div>
					</div>
					<div class="Title">Dirección Laboral</div>
					<div class="Datos_Container">
						<div class="row_container">
							<div class="Datos" id="idLcalle"><strong>Calle:</strong> ${domLaboral.calle}</div>
							<div class="Datos" id="idLnoExterior"><strong>no.ext:</strong> ${domLaboral.noExterior}</div>
							<div class="Datos" id="idLnoInterior"><strong>no.int:</strong> ${domLaboral.noInterior}</div>
							<div class="Datos" id="idLcolonia"><strong>Colonia:</strong> ${domLaboral.colonia}</div>
						</div>
						<div class="row_container">
							<div class="Datos" id="idLmunicipio"><strong>Municipio:</strong> ${domLaboral.municipio}</div>
							<div class="Datos" id="idLentFederativa"><strong>Ent Fed:</strong> ${domLaboral.entidadFederativa}</div>
							<div class="Datos" id="idLcodigo"><strong>C.P:</strong> ${domLaboral.codigoPostal}</div>
						</div>
						<div class="row_container">
						   <div class="Datos" id="idPfechaControl"></div>
						   <div class="Datos" id="idPfechaControl"></div>
						   <div class="Datos" id="idPfechaControl"></div>
						   <div class="Datos" id="idPfechaControl" style="position:relative;width:300px;padding:10px;" ><strong>Fecha de modificacion de los datos:</strong> ${domParticular.fechaControl}</div>
						</div>
					</div>
					<div class="Title">Datos de contacto</div>
					<div class="Datos_Container">
						<div class="row_container">
							<div class="Datos" id="idTelefonoFijo"><strong>Teléfono Fijo:</strong> ${contacto.telefonoFijo}</div>
							<div class="Datos" id="idTelefonoCelular"><strong>Celular:</strong> ${contacto.celular}</div>
							<div class="Datos" id="idEmail"><strong>Correo Electrónico:</strong> <span class="Correo"> ${correo}</span></div>
						</div>
						<div class="row_container">
							<div class="Datos" id="idTelefonoLaboral"><strong>Telefono Laboral:</strong> ${contacto.telefonoLaboral}</div>
							<div class="Datos" id="idExt"><strong>Ext.:</strong> ${contacto.extension}</div>
						</div>
						<div class="row_container">
						   <div class="Datos" id="idPfechaControl"></div>
						   <div class="Datos" id="idPfechaControl"></div>
						   <div class="Datos" id="idPfechaControl"></div>
						   <div class="Datos" id="idPfechaControl" style="position:relative;width:300px;padding:10px;" ><strong>Fecha de modificacion de los datos:</strong> ${fechaControl}</div>
						</div>
					</div>
					<div class="Title">Referencias</div>
					<div class="Datos_Container" id="referenciasTrabajador"></div>
					<div class="Title">Beneficiarios</div>
					<div class="Datos_Container" id="beneficiariosTrabajador"></div>
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
