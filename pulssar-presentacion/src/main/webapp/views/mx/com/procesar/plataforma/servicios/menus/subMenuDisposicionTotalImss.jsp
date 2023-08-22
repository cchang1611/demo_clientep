<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<% 
DatosTrabajador datos =  (DatosTrabajador)session.getAttribute("datos");
String tipoAfiliacion = datos.getTipoAfiliacion();  
boolean imss = (tipoAfiliacion.equals("2") || tipoAfiliacion.equals("3")) ? true : false;
boolean issste = (tipoAfiliacion.equals("3") || tipoAfiliacion.equals("4")|| tipoAfiliacion.equals("5")) ? true : false;
%>
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
		<jsp:include page="../generales/headerAgenteDisposicion.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle" value="" />
			<jsp:param name="menuPrimario" value = "2" />
			<jsp:param name="menuSecundario" value = "2" />
			<jsp:param name="menuInactivo" value = "1" />
		</jsp:include>
		
		<section>
	     	  <div class="Banner__Container">
			<div class="Banner__Thumbnail">
			  <img src="../webResources/img/slide4.jpg">
			  <div class="Banner__TextContainer">
				<h1 class="Banner__TitleContainer">DISPOSICIONES TOTALES</h1>
			  </div>
			</div>
		  </div>

	  <div class="Container">
		<div class="MenuContainer">
				<!-- inicia carrusel general -->
			<div class="slick-carousel">
				<a href="" class="CarrouselMenu__ThumbContainer" >
				  <div class="CarrouselMenu__TitlePrimary">Disposiciones Totales </div>
				</a>
        	<%-- <c:if test='<%= imss %>'> --%>
				<a href="disposicionTotalImss.do" class="CarrouselMenu__ThumbContainer" >
				  <div class="Icon">
					<img class="IconImgMenu" src="../webResources/img/icon_imss.png" alt="icon_menu">
				  </div>
				  <div class="CarrouselMenu__Title">IMSS</div>
				</a>
           <%-- 	</c:if>  --%>
        	<%-- <c:if test='<%= issste %>'> --%>
				<a href="disposicionTotalIssste.do" class="CarrouselMenu__ThumbContainer" >
				  <div class="Icon">
					<img class="IconImgMenu" src="../webResources/img/icon_isste.png" alt="icon_menu">
				  </div>
				  <div class="CarrouselMenu__Title">ISSSTE</div>
				</a>
           <%-- 	</c:if> --%> 
			</div>
		  <!-- termina carrusel general -->
		</div>
	  </div>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/modals.jsp" />
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/slick.min.js'/>"></script>
	 <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/slick_carousel_administrador.js'/>"></script> 
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/subMenuRetiroParcial.js'/>"></script>
</body>
</html>
