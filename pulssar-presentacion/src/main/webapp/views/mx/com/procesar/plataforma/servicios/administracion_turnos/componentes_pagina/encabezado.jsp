<!--
  - Author(s):   @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
  - Date:        08-Octubre-2019
  - Description: Contiene el encabezado de la admistración de turnos. En el encabezado
  -              se muestra los componente para el manejo de sesión e información del
  -              usuario y la Afore.
  -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import='java.util.*' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
  <script type="text/javascript" charset="UTF-8">
    var flujo        = '<%=request.getAttribute("flujo")%>';
    var mensajeError = '<%=request.getAttribute("mensajeError")%>'; 
  </script>
</head>
<body>

	  <!-- Inicia Header -->
    <div class="Header">

      <div class="Header__LogoContainer">
      </div>

      <div class="Header__MenuContainer">

		<!-- ---------------------------------------------------------------- -->
		<!-- La siguiente opción del encabezado no le encuentro funcionalidad -->
		<!-- ---------------------------------------------------------------- -->
		
        <a  href="/pulssar/public/administracionturnos/menu.do" class="Header__ButtonMenuContainer">
          <img class="Header__ButtonMenuIcon" src="../../webResources/img/icon_home.png" alt="icon_menu"/>
          <p>Home</p>
        </a>
        
        <!-- ---------------------------------------------------------------- -->
		<!-- Componente que permite el CIERRE DE SESIÓN.                      -->
		<!-- ---------------------------------------------------------------- -->

        <a  href="${pageContext.request.contextPath}/logout" class="Header__ButtonClockContainer">
          <img class="Header__ButtonClockIcon" src="../../webResources/img/logout_icon.png" alt="icon_menu"/>
          <p>Finalizar Sesi&oacute;n</p>
        </a>

      </div>
      
      <div class="Header__UserContainer">
      
      	<!-- ---------------------------------------------------------------- -->
	    <!-- Componente que muestra la imagen del usuario en sesión en caso de-->
	    <!-- existir, en caso contrario, muestra una imagen por defecto.      -->
	    <!-- ---------------------------------------------------------------- -->

        <div class="Header__UserImageContainer">
          <div class="Header__UserImage">
            <c:choose>
				<c:when test="${not empty imagen}">
					<img class="Header__UserImg" src="data:image/png;base64, ${imagen}" alt="Imagen del Agente Promotor" />
				</c:when>
				<c:otherwise>
					<img class="Header__UserImg" src="../../webResources/img/user_photo.jpg" alt="user_photo" />
				</c:otherwise>
			</c:choose>
          </div>
        </div>
        
        <!-- ---------------------------------------------------------------- -->
	    <!-- Componente que muestra el nombre del Usuario en Sesión           -->
	    <!-- ---------------------------------------------------------------- -->

        <div class="Header__RegistrateLoginText">
          <p class="Header__RegistrateLoginTitle">Bienvenido</p>
          <c:choose>
          	<c:when test="${not empty nombreUsuario}">
          		<p>${nombreUsuario}</p>
          	</c:when>
          	<c:otherwise>
          		<p>Usuario no definido</p>
          	</c:otherwise>
          </c:choose>
        </div>

      </div>

      <div class="dropdown">
        <div class="dropbtn" onclick="myFunction()">
        </div>
        <div id="myDropdown" class="dropdown-content">
        <a href="${requestScope['javax.servlet.forward.request_uri']}">Actualizar Datos</a>
        <a href="${pageContext.request.contextPath}/logout">Cerrar Sesi&oacute;n</a>
        <a href="#">Opcion</a>
      </div>
      </div>
    </div>
  <!-- Finaliza Header -->
  	
</body>
</html>