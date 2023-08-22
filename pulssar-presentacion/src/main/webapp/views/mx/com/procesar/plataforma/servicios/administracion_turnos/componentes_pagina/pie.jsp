<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link id="colors" charset="utf-8" rel="stylesheet" type="text/css" href="<d:url value='/webResources/css/general/main.css'/>"></link>
</head>
<body>

  <!-- Inicia Footer -->
  <div class="Footer">
		<div class="Footer__Container">
				<div class="Footer__Services">
					<p class="Footer__Title">Servicios</p>
						<%-- <c:forEach items="${sessionScope.menuUsuario}" var="menuFooter" varStatus="counter" end="3">
							<p><a class="FooterLink" href="${menuFooter.chRutaMenu}">${menuFooter.chDescMenuPagina}</a></p>
						</c:forEach> --%>
					</div>		
			<div class="Footer__Suport">
				<p class="Footer__Title">Soporte</p>
			</div>
		</div>
		<div class="Footer__Legacy">
			<a class="Footer__LegacyLink">Mapa de Sitio</a>
			<a class="Footer__LegacyLink"> / Aviso de Privacidad</a>
		</div>
	</div>
  <!-- Termina Footer -->

</body>
</html>