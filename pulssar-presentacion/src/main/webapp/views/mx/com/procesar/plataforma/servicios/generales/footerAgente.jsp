<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<body>
	<link rel="stylesheet" type="text/css" href="../webResources/css/general/footer.css">
	
	<div class="Footer">
		<div class="Footer__Container">
			<div class="Footer__Services">
				<p class="Footer__Title">Servicios</p>
				<p><a class="FooterLink" href="#">Consulta del Trabajador</a></p>
				<p><a class="FooterLink" href="#">Administración de Folios</a></p>
				<p><a class="FooterLink" href="#">Validación de imágenes de expediente</a></p>
				<p><a class="FooterLink" href="#">Retíros</a></p>
			</div>
			<div class="Footer__Suport">
				<p class="Footer__Title">Soporte</p>
			</div>
		</div>
		<div class="Footer__Legacy">
			<a class="Footer__LegacyLink">Mapa de Sitio</a>
			<h:if test="${configAvisoPrivacidad == '1'}">
				<a class="Footer__LegacyLink" onclick="presentaAvisoPrivacidad();"> / Aviso de Privacidad</a> 
			</h:if>
		</div>
	</div>
</body>
</html>
