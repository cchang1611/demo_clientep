<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
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
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/nip/amenu.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
	</script>
	<div class="wrapper">
		<jsp:include page="../generales/headerAgente.jsp">
			<jsp:param name="encabezado" value="3" />
			<jsp:param name="menuTitle" value="Carga Masiva de Usuarios" />
			<jsp:param name="menuPrimario" value = "4" />
			<jsp:param name="menuSecundario" value = "2" />
			<jsp:param name="menuInactivo" value = "1" />
		</jsp:include>
		
		<section>
			<div class="Container">
				<div class="MenuContainer">
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${menuUsuario != null}"> --%>
							
<%-- 								<c:if test="${fn:length(menuUsuario) <= 4}"> --%>
									<div class="slick-carousel-min">
<%-- 								</c:if> --%>
<%-- 								<c:if test="${fn:length(menuUsuario) > 4}"> --%>
<!-- 									<div class="slick-carousel"> -->
<%-- 								</c:if> --%>
							
<%-- 								<c:forEach items="${menuUsuario}" var="menu">								 --%>
<%-- 									<a href="${menu.chRutaMenu}" class="CarrouselMenu__ThumbContainer" > --%>
<!-- 										<div class="Icon"> -->
<%-- 											<img class="IconImgMenu" src="${menu.chImagen}" alt="icon_menu"> --%>
<!-- 										</div> -->
<%-- 										<div class="CarrouselMenu__Title">${menu.chDescMenuPagina}</div> --%>
<!-- 									</a> -->
									<a href="/pulssar/admin/usuariosCarga.do" class="CarrouselMenu__ThumbContainer" >
										<div class="Icon">
											<img class="IconImgMenu" src="../webResources/img/userCarga.png" alt="icon_menu">
										</div>
										<div class="CarrouselMenu__Title">Carga de Archivo</div>
									</a>
									<a href="/pulssar/admin/usuariosDescarga.do" class="CarrouselMenu__ThumbContainer" >
										<div class="Icon">
											<img class="IconImgMenu" src="../webResources/img/userDescarga.png" alt="icon_menu">
										</div>
										<div class="CarrouselMenu__Title">Descarga archivo de respuesta</div>
									</a>
									
<%-- 								</c:forEach>								 --%>
							</div>
<%-- 						</c:when> --%>
<%-- 						<c:otherwise> --%>
<%-- 							<c:out value="No tiene menu asignado al rol." /> --%>
<%-- 						</c:otherwise> --%>
<%-- 					</c:choose> --%>

									
<!-- 									<a href="/pulssar/admin/consultaUsuarios.do" class="CarrouselMenu__ThumbContainer" > -->
<!-- 										<div class="Icon"> -->
<!-- 											<img class="IconImgMenu" src="../webResources/img/solicitud_reintegro.png" alt="icon_menu"> -->
<!-- 										</div> -->
<!-- 										<div class="CarrouselMenu__Title">Consulta respuesta archivo</div> -->
<!-- 									</a> -->
									
<!-- 									<a href="/pulssar/admin/consultaControl.do" class="CarrouselMenu__ThumbContainer" > -->
<!-- 										<div class="Icon"> -->
<!-- 											<img class="IconImgMenu" src="../webResources/img/solicitud_reintegro.png" alt="icon_menu"> -->
<!-- 										</div> -->
<!-- 										<div class="CarrouselMenu__Title">Cifras control</div> -->
<!-- 									</a> -->

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
</body>
</html>
