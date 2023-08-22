<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import='java.util.*' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin" %>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<meta charset="utf-8" />
</head>
<% 
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
String nombre = usuario.getNombre();
DatosTrabajador trabajadorConsultado = (DatosTrabajador) session.getAttribute("datos");
%>

<body>
<script type="text/javascript">
			var valuePaperless = "${sessionScope.valuePaperless}";
		</script>
     <link rel="stylesheet" type="text/css" href="../webResources/css/general/modal_window.css"></link>
	<link rel="stylesheet" type="text/css" href="../webResources/css/normalize.css"></link>
	<link rel="stylesheet" type="text/css" href="../webResources/css/general/header.css"></link>
	<script src="<c:url value='/webResources/js/general/menu_configuracion.js'/>"></script>
	<script src="<c:url value='/webResources/js/general/menu_configuracionpaperless.js'/>"></script>
	<script src="<c:url value='/webResources/js/ceroPapel.js'/>"></script>
	<header>
		<div class="Header">
			<% if(trabajadorConsultado != null) { %>
				<c:choose>
					<c:when test="${not empty sessionScope.paperlessAfores && fn:contains(sessionScope.paperlessAfores, sessionScope.stiloOrg) && not sessionScope.consultaAgente}" >
						<div class="HeaderPaperless__LogoContainer">
							<img class="LogoPaperless" src="" id="imgHeader" alt="logo"/>
						</div>
						<div class="dropdownPaperless">
							<div class="dropbtnPaperless" onclick="myFunction01()">
								<div class="ButtonPaperless">
									<img class="HeaderPaperless__ButtonMenuPaperless" src="../webResources/img/impresora.png" alt="icon_menu"/>
									<span>Paperless</span>
								</div>
							</div>
							<div id="myDropdownPaperless" class="dropdownPaperless-content">
								<a href="#" id="estatusPaperless">Estatus: 
									<c:choose>
										<c:when test="${not empty sessionScope.valuePaperless && sessionScope.valuePaperless == 'ACTIVO'}" >
											<strong style="color:greenyellow;">ACTIVO</strong>
										</c:when>
										<c:otherwise>
											<strong style="color:red;">INACTIVO</strong>
										</c:otherwise>
									</c:choose>
								</a>
								<a href="#" onclick="activarEstatusCeroPapel()" id="activarEstatusCeroPapel">Activar</a>
								<a href="#" onclick="cancelarEstatusCeroPapel()" id="cancelarEstatusCeroPapel">Cancelar</a>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="Header__LogoContainer">
							<img class="Logo" src="" id="imgHeader" alt="logo"/>
						</div>
					</c:otherwise>
				</c:choose>
			<jsp:include page="paperlessModals.jsp" />
			<% } else { %>
					<div class="Header__LogoContainer">
						<img class="Logo" src="" id="imgHeader" alt="logo"/>
					</div>
			<% } %>
			
			<div class="Header__MenuContainer">
				<c:choose>
						<c:when test="${param.menuPrimario == '1' && sessionScope.stiloOrg != '003'}">
							<a  href="#miClock" class="Header__ButtonMenuContainer">
								<img class="Header__ButtonClockIcon" src="../webResources/img/icon_reloj.png" alt="icon_menu"/>
								<p>Tiempo de Espera</p>
							</a>
						</c:when>
						<c:when test="${param.menuPrimario == '2'}">
							<c:choose>
								<c:when test="${sessionScope.stiloOrg == '999'}">
									<a href="menu.do" class="Header__ButtonMenuContainer">
										<img class="Header__ButtonMenuIcon" src="../webResources/img/menu_icon.png" alt="icon_menu">
										<p>Menú</p>
									</a>
								</c:when>
								<c:when test="${not sessionScope.consultaAgente}">
									<a href="amenu.do" class="Header__ButtonMenuContainer">
										<img class="Header__ButtonMenuIcon" src="../webResources/img/menu_icon.png" alt="icon_menu">
										<p>Menú</p>
									</a>
								</c:when>
								<c:otherwise>
									<div class="Header__ButtonMenuContainer"></div>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:when test="${param.menuPrimario == '3'}">
							<a  href="consultaTrabajador.do" class="Header__ButtonMenuContainer">
					          <img class="Header__ButtonMenuIcon" src="../webResources/img/icon_home.png" alt="icon_menu"/>
					          <p>Home</p>
					        </a>
						</c:when>
						<c:when test="${param.menuPrimario == '4'}">
							<a href="menu.do" class="Header__ButtonMenuContainer">
								<img class="Header__ButtonMenuIcon" src="../webResources/img/menu_icon.png" alt="icon_menu">
								<p>Menú</p>
							</a>
						</c:when>
						<c:otherwise>
							<div class="Header__ButtonMenuContainer"></div>
						</c:otherwise>
				</c:choose>
				<c:choose>
						<c:when test="${param.menuSecundario == '1'}">
							<a href="logout.do" id="sesionLogout" class="Header__ButtonClockContainer">
								<img class="Header__ButtonMenuIcon" src="../webResources/img/logout_icon.png" alt="icon_menu"/>
								<p>Finalizar Sesión</p>
							</a>
						</c:when>
						<c:when test="${param.menuSecundario == '2'}">
							<c:choose>
								<c:when test="${sessionScope.stiloOrg == '999' || sessionScope.stiloOrg == '568'}">
									<a href="logout.do" id="sesionLogout" class="Header__ButtonClockContainer">
										<img class="Header__ButtonMenuIcon" src="../webResources/img/logout_icon.png" alt="icon_menu"/>
										<p>Finalizar Sesión</p>
									</a>
								</c:when>
								<c:when test="${sessionScope.stiloOrg =='003'}">
									<a href="finalizaProcesoConsar.do" class="Header__ButtonClockContainer">
										<img class="Header__ButtonMenuIcon" src="../webResources/img/logout_icon.png" alt="icon_menu"/>
										<p>Finalizar Atención</p>
									</a>
								</c:when>
								<c:otherwise>
									<a href="finalizaProceso.do" class="Header__ButtonClockContainer">
										<img class="Header__ButtonMenuIcon" src="../webResources/img/logout_icon.png" alt="icon_menu"/>
										<p>Finalizar Atención</p>
									</a>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<a href="consultaTrabajador.do" class="Header__ButtonClockContainer">
								<img class="Header__ButtonMenuIcon" src="../webResources/img/logout_icon.png" alt="icon_menu"/>
								<p>Regresar</p>
							</a>
						</c:otherwise>
				</c:choose>
			</div>
			
			<div class="Header__UserContainer">
				<div class="Header__UserImageContainer">
					<div class="Header__UserImage">
						<c:choose>
							<c:when test="${((not empty usuario) and (not empty usuario.foto))}">
								<img class="Header__UserImg" src="../webResources/img/user_photo.jpg" alt="Imagen del Agente Promotor" />
							</c:when>
							<c:otherwise>
								<img class="Header__UserImg" src="../webResources/img/user_photo.jpg" 
								alt="Imagen del Agente Promotor no encontrada" />
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="Header__RegistrateLoginText">
					<p class="Header__RegistrateLoginTitle">Bienvenido</p>
				<p><%= nombre%></p>
				</div>
			</div>
			<div class="dropdown">
				<div class="dropbtn" onclick="myFunction()">
				</div>
				<div id="myDropdown" class="dropdown-content">
					<c:if test="${sessionScope.stiloOrg != '999' && not sessionScope.consultaAgente}">
						<a href="verificarEmpleado.do">Validar Empleado</a>
					</c:if>
					<a href="logout.do">Cerrar Sesión</a>
				</div>
			</div>
		</div>
		
		<c:choose>
			<c:when test="${param.encabezado == '1'}">
				<div class="Banner__Container">
					<div class="Banner__Thumbnail">
						<c:choose>
							<c:when test="${sessionScope.stiloOrg == '552' || sessionScope.stiloOrg == '530'}">
								<img src="../webResources/img/slide4-${sessionScope.stiloOrg}.jpg">
							</c:when>
							<c:otherwise>
								<img src="../webResources/img/slide4.jpg" />
							</c:otherwise>
						</c:choose>
						<div class="Banner__TextContainer">
							<h1 class="Banner__TitleContainer">Identifica a tu cliente</h1>
						</div>
					</div>
				</div>
			</c:when>
			<c:when test="${param.encabezado == '2'}">
				<div class="Menu__Container">
					<div class="Menu__Title">
					  <c:out value="${param.menuTitle}" escapeXml="false" />
					</div>
					<div class="Menu__Folio"><c:if test="${sessionScope.stiloOrg != '999'}"><strong>Folio:</strong>&nbsp;${folio.folio}</c:if></div>
				</div>
			</c:when>
			<c:when test="${param.encabezado == '4'}">
				<div class="Menu__Container">
					<div class="Menu__Title">
					  <c:out value="${param.menuTitle}" escapeXml="false" />
					</div>
					<div class="Menu__Folio"></div>
				</div>
			</c:when>
			<c:when test="${param.encabezado == '5'}">
				<div class="Menu__Container">
					<div class="Menu__Title" style="color:orange">
					  <c:out value="${param.menuTitle}" escapeXml="false" />
					</div>
					<div class="Menu__Folio"></div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="Banner__Container">
					<div class="Banner__Thumbnail">
						<c:choose>
							<c:when test="${sessionScope.stiloOrg == '552' || sessionScope.stiloOrg == '530'}">
								<img src="../webResources/img/slide4-${sessionScope.stiloOrg}.jpg">
							</c:when>
							<c:otherwise>
								<img src="../webResources/img/slide4.jpg" />
							</c:otherwise>
						</c:choose>
						<div class="Banner__TextContainer">
							<h1 class="Banner__TitleContainer">Servicios</h1>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</header>
</body>
</html>
