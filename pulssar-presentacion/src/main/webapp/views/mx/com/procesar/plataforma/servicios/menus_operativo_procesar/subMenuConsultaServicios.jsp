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
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick-theme.min.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carousel/slick_carousel_administrador.css'/>">
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<input type="hidden" id="mensajeError" value="${error}" />
		<jsp:include page="../generales/headerAgente.jsp">
			<jsp:param name="encabezado" value="3" />
			<jsp:param name="menuTitle" value="Consulta Servicios" />
			<jsp:param name="menuPrimario" value = "3" />
			<jsp:param name="menuSecundario" value = "1" />
		</jsp:include>
		
		<section>
			<div class="Container">
				<div class="MenuContainer">
					<div class="slick-carousel">
						<a href="menu.do" class="CarrouselMenu__ThumbContainer" >
							<div class="CarrouselMenu__TitlePrimary">Consulta Servicios</div>
						</a>
						<a href="capturaPlataformaServicios.do?servicio=C" class="CarrouselMenu__ThumbContainer" >
							<div class="Icon">
								<img class="IconImgMenu" src="../webResources/img/consultatrabajador.jpg" alt="icon_menu">
							</div>
							<div class="CarrouselMenu__Title">Consulta del Trabajador</div>
						</a>
						<a href="capturaPlataformaServicios.do?servicio=S21" class="CarrouselMenu__ThumbContainer" >
							<div class="Icon">
								<img class="IconImgMenu" src="../webResources/img/ceropapel.jpg" alt="icon_menu">
							</div>
							<div class="CarrouselMenu__Title">Cero Papel</div>
						</a>
						<a href="capturaPlataformaServicios.do?servicio=S4&dato=1" class="CarrouselMenu__ThumbContainer" >
							<div class="Icon">
								<img class="IconImgMenu" src="../webResources/img/modificaciondatos.jpg" alt="icon_menu">
							</div>
							<div class="CarrouselMenu__Title">Modificación de Datos</div>
						</a>
						<a href="capturaPlataformaServicios.do?servicio=S4&dato=2" class="CarrouselMenu__ThumbContainer" >
							<div class="Icon">
								<img class="IconImgMenu" src="../webResources/img/permanencia.png" alt="icon_menu">
							</div>
							<div class="CarrouselMenu__Title">Permanencia</div>
						</a>
						
						<a href="consultaServiciosSolicitudTraspaso.do" class="CarrouselMenu__ThumbContainer" >
							<div class="Icon">
								<img class="IconImgMenu" src="../webResources/img/consultatrabajador.jpg" alt="icon_menu">
							</div>
							<div class="CarrouselMenu__Title">Consulta Certificación  de Solicitudes de Traspasos</div>
						</a>
						
					</div>
				</div>
			</div>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/slick.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/slick_carousel_administrador.js'/>"></script>
</body>
</html>
