<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page
	import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Menu</title>
<meta charset="utf-8" />
<![if IE]>
<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet"
	href="<c:url value='/webResources/css/general/main_ie.css'/>" />
<![endif]>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/1.5.8/slick-theme.min.css'/>">
	<link rel="stylesheet" type="text/css"
		href="<c:url value='/webResources/css/1.5.8/slick.css'/>">
		<link rel="stylesheet" type="text/css"
			href="<c:url value='/webResources/css/general/container.css'/>"></link>
		<link rel="stylesheet" type="text/css"
			href="<c:url value='/webResources/css/general/carousel/slick_carousel_administrador.css'/>">
			<link rel="shortcut icon"
				href="<c:url value='/webResources/img/favicon.ico'/>"></link>
			<link
				href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap"
				rel="stylesheet"></link>

			<script type="text/javascript" charset="UTF-8"
				src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
			<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<%
	DatosTrabajador datos = (DatosTrabajador) session.getAttribute("datos");
	String tipoAfiliacion = datos.getTipoAfiliacion();
	boolean imss = (tipoAfiliacion.equals("2") || tipoAfiliacion.equals("3")) ? true : false;
	boolean issste = (tipoAfiliacion.equals("3") || tipoAfiliacion.equals("4") || tipoAfiliacion.equals("5"))
			? true : false;
%>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<input type="hidden" id="mensajeError" value="${error}" />
		<jsp:include page="../generales/headerAgente.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle" value="Retiro Parcial" />
			<jsp:param name="menuPrimario" value="2" />
			<jsp:param name="menuSecundario" value="2" />
			<jsp:param name="menuInactivo" value="1" />
		</jsp:include>

		<div class="Banner__Container">
			<div class="Banner__Thumbnail">
				<img src="../webResources/img/slide4.jpg">
					<div class="Banner__TextContainer">
						<h1 class="Banner__TitleContainer">Reintegro de recursos por
							un retiro parcial por desempleo</h1>
					</div>
			</div>
		</div>

		<div class="Container">
			<div class="MenuContainer">
				<!-- inicia carrusel general -->
				<div class="slick-carousel">
					<a href="" class="CarrouselMenu__ThumbContainer">
						<div class="CarrouselMenu__TitlePrimary">Retiro Parcial</div>
					</a> 
					<a href="reintegroRecursos.do" onkeyup=""
						class="CarrouselMenu__ThumbContainer">
						<div class="Icon">
							<img class="IconImgMenu2"
								src="../webResources/img/solicitud_reintegro.png" alt="icon_menu" />
						</div>
						<div class="CarrouselMenu__Title" style="font-size: 13px;">
							Reintegro de Recursos<br> por un Retiro Parcial<br> por
									Desempleo 
						</div>
					</a> 
					<a href="confirmarReintegroRecursos.do"
						class="CarrouselMenu__ThumbContainer">
						<div class="Icon">
							<img class="IconImgMenu2"
								src="../webResources/img/confirmacion_reintegro.png" alt="icon_menu" />
						</div>
						<div class="CarrouselMenu__Title" style="font-size: 13px;">Confirmación
							de Reintegro de Recursos por un Retiro Parcial</div>
					</a>

				</div>
				<!-- termina carrusel general -->
			</div>
		</div>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/modals.jsp" />
	<jsp:include page="../generales/footerAgente.jsp" />

	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/slick.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/slick_carousel_administrador.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/subMenuRetiroParcial.js'/>"></script>
</body>
</html>
