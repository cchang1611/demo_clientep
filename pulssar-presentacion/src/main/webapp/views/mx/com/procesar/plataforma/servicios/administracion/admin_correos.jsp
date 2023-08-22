<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Gestion de Correos Corporativos</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link charset="UTF-8" rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="UTF-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script charset="UTF-8" type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script charset="UTF-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script charset="UTF-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="3" />
			<jsp:param name="menuTitle" value="Administraci&oacute;n de Correos Corporativos" />
			<jsp:param name="menuActivo" value = "1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
		</script>
		
		<section>
			<form:form  method="POST" id="fm_correo" modelAttribute="consultaCorreo" action="editaCorreo.do">
				<div class="Container">
					<div class="Layout__XL">
						<c:if test="${not empty afores}">
							<div class="Datos_Container">
								<div class="Form__Box01">
									<div class="Form">
										<label class="LabelText" for="usuario">Afore: </label>
									</div>
									<div class="Form__BoxChild">
										<form:select id="claveOrganizacion" class="Select" name="clave" path="clave" data-not-null="0" data-nombre="Organizacion">
											<option value="">Seleccione su AFORE</option>
											<form:options items="${afores}" itemValue="clave" itemLabel="descripcion"/>
										</form:select>
									</div>
								</div>
							</div>
						</c:if>
						<div class="Section">
							<div class="Aside__Col03">
								<div class="Datos_Container">
									<div class="Form__Group">
										<label class="LabelText" for="usuario">Correo(s): </label>
										<div class="Checkbox__Area" id="ulCheckBox">
											${correosCorporativos}
										</div>
									</div>
								</div>
							</div>
							<div class="Aside__Col04">
								<div class="Datos_Container">
									<div class="Form__Group">
										<label class="LabelText" for="usuario">Nuevo Correo: </label>
										<form:input class="Inputxxl" type="text" name="email" path="email" placeholder="Dominio" data-alfa-punto="0" data-nombre="Correo" maxlength="50" />
									</div>
									<div class="ContainerButtonsCenter">
										<input id="btnRegistro" class="Submit" type="submit" value="Guardar">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAdmin.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/consultaCorreo.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
