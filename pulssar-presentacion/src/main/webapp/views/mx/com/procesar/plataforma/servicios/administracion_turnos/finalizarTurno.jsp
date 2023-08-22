<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Menu</title>
<meta charset="ISO-8859-1" />
<![if IE]>
	<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
<![endif]>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="shortcut icon"              href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>

	<script src="<c:url value='/webResources/js/jquery-3.0.0.min.js'/>"></script>
	<script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
		var _MENSAJE = "${respuesta.mensaje}";
	</script>
</head>
<body>

	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<!-- Inicia Wrapper -->
	<div class="wrapper">
		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle" value="Turno" />
			<jsp:param name="menuActivo" value="1" />
		</jsp:include>
		<br />		
		<form:form id="fm_finalizarTurno" action="actualizarTurno.do" modelAttribute="adminTurno" method="POST">
			<div class="Container">
				<div class="Layout__XL">
					<div class="Title"><p>FINALIZAR TURNO</p></div>
					<div class="Datos_Container">
						<div class="Form__Group">
							<div id="folioServicio" class="DatosBack"><strong>TURNO</strong> : <strong>${adminTurno.folioServicio}</strong> </div>
						</div>						
						<div class="Form__Group">
							<div class="DatosBack">
								<input type='checkbox'id="checkCancelar" /> ABANDONO DE TURNO
								<input type="hidden" id="cancelar" name='cancelar' value='0'/>
							</div>
						</div>
						<div class="Form__Group">
							<div class="DatosBack">
								<label class="LabelText" for="usuario">ASIGNAR SERVICIOS *</label>
							</div>
							<div class="DatosBack_Scroll">		
								<div id="ulCheckBox">
									<ul id="ulCheckServicios">					
										<c:forEach items="${listaServicios}" var="servicio">
											<li><input type='checkbox' name='listaServicios' value='${servicio.clave}' /> ${servicio.descripcion}</li>
											<br />
										</c:forEach>							
									</ul>
								</div>
							</div>
						</div>
						<div class="Form__Group">
							<div class="DatosBack">
								<label class="LabelText" for="usuario">Folio de Atención:</label>
								<input class="Inputxxl" type="text" id="folioAtencion" name="folioAtencion" placeholder="Folio de Atención" data-not-null="0" data-nombre="Folio de Atención" maxlength="40" noPaste="true" />
							</div>
						</div>
					</div>
					<div class="ContainerButtonsCenter">
						<input class="Submitx" type="button" id="submitAceptar" value="Aceptar"/>
						<input class="Submitx" type="button" id="submitCancelar" value="Cancelar"/>
					</div>
				</div>
			</div>
		</form:form>
		<div class="push"></div>
		<br />
	</div>
    <jsp:include page="../generales/footerPrincipal.jsp" />
    <jsp:include page="modal.jsp" />
	<script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/finalizarTurno.js'/>"></script>
</body>
</html>
