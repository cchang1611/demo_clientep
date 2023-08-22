<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<%@ page import='java.util.*' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" />
<html>

<body>
	<f:choose>
		<f:when test="${param.organizacion == '552'}">
			<div class="Text">
				<div class="Title_Index">
					<p style="font-size:25px; margin: 10px 0px 20px 0px;">Bienvenidos a</p>
					<strong> CITIBANAMEX</strong>
				</div>
				<div class="Description">
					Donde podrás registrar diversos trámites para el retiro de los trabajadores
					favor ingresa tu USUARIO y CONTRASEÑA para poder gestionar cualquier trámite de una forma fácil y segura.
				</div>
			</div>
		</f:when>
		<f:otherwise>		
			<div class="Text">
				<div class="Title_Index">
					<p style="font-size:25px; margin: 10px 0px 20px 0px;">Bienvenidos a </p>
					<img class="Text__Logo" src="/pulssar/webResources/img/logo_accesar.png"/>
				</div>
				<div class="Description">
					Bienvenidos a AcceSAR donde podrás realizar diversos
					trámites para el retiro de los trabajadores de PROCESAR por favor
					ingresa tu USUARIO y CONTRASEÑA correspondiente para poder gestionar
					cualquier trámite de una forma fácil y segura.
				</div>
			</div>
		</f:otherwise>
	</f:choose>
</body>
</html>