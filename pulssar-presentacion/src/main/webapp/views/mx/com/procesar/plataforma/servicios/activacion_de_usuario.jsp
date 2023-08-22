<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Activacion de Usuario</title>
	<![if IE]>
		<link id="colorsIE" type="text/css" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templatemo_style.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/index.css'/>"></link>
	<link rel="shortcut icon" charset="utf-8" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="utf-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.plugin.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.realperson.js'/>"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="generales/headGeneral.jsp"></jsp:include>
		<jsp:include page="generales/headerPrincipal.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="titulo" value="ACTIVACI&Oacute;N DE USUARIO" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
		</script>
		
		<section>
			<form:form id="fm_activa" method="POST" modelAttribute="usuarioActiva" action="guardarActivacion.do" accept-charset="ISO-8859-1">
				<div class="Container">
					<div class="Layout__M">
						<div class="Datos_Container">
							<div class="Form__Group">
								<label class="LabelText" for="usuario">Usuario: *</label>
								<form:input class="Inputxxl" type="text" name="numeroAgente" path="nickUsuario" placeholder="Usuario" data-nombre="Usuario" data-not-null="0" data-usuario="0" maxlength="50" noPaste="true" />
							</div>
							<div class="Form__Group">
								<label class="LabelText" for="usuario">Contrase&ntilde;a: *</label>
								<form:input id="contrasenia" class="Inputxxl" type="password" name="password" path="password" data-not-null="0" placeholder="Password" data-nombre="Password" data-contrasenia="0" maxlength="13" noPaste="true" />
							</div>
							<div class="Form__Group">
								<label class="LabelText" for="usuario">Confirmar Contrase&ntilde;a: *</label>
								<form:input id="confirmaContrasenia" class="Inputxxl" type="password" name="confirmarPassword" path="confirmarPassword" placeholder="Confirmar Password" data-nombre="Confirma Password" data-confirm="confirmaContrasenia" data-contrasenia="0" maxlength="13" noPaste="true" />
							</div>
							<div class="Form__Group">
								<label class="LabelText" for="usuario">C&oacute;digo de confirmaci&oacute;n: *
									<form:input id="codigo" class="Input_small" type="text" name="codigo" path="codigo" placeholder="XXXX" data-numeros="0" maxlength="4" noPaste="true" />
								</label>
							</div>
							<div class="Form__Group">
								<label class="LabelText" for="usuario">Por favor ingresa las siguientes letras desplegadas:</label>
								<div class="Form__Captcha">
									<div id="captcha" class="Form__Group Captcha">
										<input class="Inputxxl" id="defaultReal" type="text" name="defaultReal" data-captcha="0" data-alfanumerico-space="0">
									</div>
								</div>
							</div>
							<div class="ContainerButtonsCenter">
								<input id="aceptar" class="Submit" type="submit" value="ACTIVAR">
							</div>
							<div id="enlaceActivacion" class="Form__Group">
								<p class="Login__Parrafo">No te ha llegado tu c&oacute;digo, da clic <a class="Login__Forget" href="#" id="reenviarActivacion">aqu&iacute;</a></p>
							 </div>
						 </div>
					</div>
				</div>
			</form:form>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="generales/footerPrincipal.jsp" />
	
	<script src="<c:url value='/webResources/js/activaCodigo.js'/>"></script>
	<script src="<c:url value='/webResources/js/captcha.js'/>"></script>
	<jsp:include page="generales/modals.jsp" />
</body>
</html>
