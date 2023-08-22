<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="h"%>
<%@ page import='java.util.*' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<body>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<h:url value='/webResources/css/normalize.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<h:url value='/webResources/css/general/header.css'/>"></link>
	<script type="text/javascript" charset="utf-8" src="<h:url value='/webResources/js/general/menu_configuracion.js'/>"></script>
	
	<header>
		<div class="Header">
			<div class="Header__LogoContainer">
				<img class="Logo" src="" id="imgHeader" alt="logo"/>
			</div>
			<div class="Header__MenuContainer">
				<h:if test="${param.encabezado != '1'}">
					<h:if test="${param.menuActivo == '1'}">
						<a href="${sessionScope.menuPrincipal}" class="Header__ButtonMenuContainer">
							<img class="Header__ButtonMenuIcon" src="../webResources/img/menu_icon.png" alt="icon_menu">
							<p>Menú</p>
						</a>
					</h:if>
				</h:if>
				<h:if test="${param.menuActivo != '1'}">
					<div class="Header__ButtonMenuContainer"></div>
				</h:if>
				<a href="logout.do" class="Header__ButtonClockContainer">
					<img class="Header__ButtonClockIcon" src="../webResources/img/logout_icon.png" alt="icon_menu"/>
					<p>Finalizar Sesión</p>
				</a>
			</div>
			<div class="Header__UserContainer">
				<div class="Header__UserImageContainer">
					<div class="Header__UserImage">
						<h:choose>
							<h:when test="${not empty imagen}">
								<img class="Header__UserImg" src="../webResources/img/user_photo.jpg" alt="Imagen del Agente Promotor" />
							</h:when>
							<h:otherwise>
								<img class="Header__UserImg" src="../webResources/img/user_photo.jpg" 
								alt="Imagen del Agente Promotor no encontrada" />
							</h:otherwise>
						</h:choose>
					</div>
				</div>
				<div class="Header__RegistrateLoginText">
					<p class="Header__RegistrateLoginTitle">Bienvenido</p>
					<p>${nombreUsuario}</p>
				</div>
			</div>
			<div class="dropdown">
				<div class="dropbtn" onclick="myFunction()">
				</div>
				<div id="myDropdown" class="dropdown-content">
					<a href="logout.do">Cerrar Sesión</a>
				</div>
			</div>
		</div>
		
		<h:choose>
			<h:when test="${param.encabezado == '1' or param.encabezado == '2'}">
				<div class="Banner__Container">
					<div class="Banner__Thumbnail">
						<h:choose>
							<h:when test="${sessionScope.stiloOrg == '552' || sessionScope.stiloOrg == '530'}">
								<img src="../webResources/img/slide4-${sessionScope.stiloOrg}.jpg" />
							</h:when>
							<h:otherwise>
								<img src="../webResources/img/slide4.jpg" />
							</h:otherwise>
						</h:choose>
						<div class="Banner__TextContainer">
							<h1 class="Banner__TitleContainer">${param.menuTitle}</h1>
						</div>
					</div>
				</div>
			</h:when>
			<h:otherwise>
				<div class="Title__Container">
					<h1><h:out value="${param.menuTitle}" escapeXml="false" /></h1>
				</div>
			</h:otherwise>
		</h:choose>
	</header>
</body>
</html>
