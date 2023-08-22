<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Modificacion de Contrasena</title>
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/jquery.realperson.css'/>"></link>
	<link charset="UTF-8" rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="UTF-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery-3.0.0.min.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.plugin.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.realperson.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="3" />
			<jsp:param name="menuTitle" value="Cambio de Contrase&ntilde;a" />
			<jsp:param name="menuActivo" value = "2" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
		</script>
		
		<section>
			<form:form method="POST" id="fm_cambio" modelAttribute="modificarPassword" action="ejecutarModificarPassword.do" accept-charset="ISO-8859-1">
				<div class="Container">
					<div class="Layout__M">
						<div class="Datos_Container">
							<div class="Form__Group">
								<label class="LabelText" for="usuario">Contrase&ntilde;a Nueva: *</label>
								<form:input id="contrasenia" class="Inputxxl" type="password" name="password" path="password" data-not-null="0" placeholder="Password Nuevo" data-nombre="Contrase&ntilde;a Nueva" data-contrasenia="0" maxlength="13" noPaste="true" />
							</div>
							<div class="Form__Group">
								<label class="LabelText" for="usuario">Confirmar Contrase&ntilde;a Nueva: *</label>
								<form:input id="confirmaContrasenia" class="Inputxxl" type="password" name="confirmarPassword" path="confirmarPassword" placeholder="Confirmar Password Nueva" data-nombre="Confirma Contrase&ntilde;a Nueva" data-confirm="confirmaContrasenia" data-contrasenia="0" maxlength="13" noPaste="true" />
							</div>
							<div class="Form__Group">
								<label class="LabelText" for="usuario">Por favor ingresa las siguientes letras desplegadas:</label>
								<div class="Form__Captcha">
									<div id="captcha" class="Form__Group Captcha">
										<input class="Inputxxl" id="defaultReal" type="text" name="defaultReal" data-captcha="0" data-alfanumerico-space="0">
									</div>
								</div>
							</div>
							<div class="ContainerButtons">
								<input id="btnAceptar" class="Submit" type="submit" value="Aceptar">
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</section>
		<div class="push"></div>
	<jsp:include page="../generales/footerPrincipal.jsp" />
	</div>
	
	<script src="<c:url value='/webResources/js/cambioPassword.js'/>"></script>
	<script src="<c:url value='/webResources/js/captcha.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
