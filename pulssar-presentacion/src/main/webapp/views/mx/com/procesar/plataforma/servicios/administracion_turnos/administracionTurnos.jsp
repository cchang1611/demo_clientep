<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Menu</title>
<meta charset="ISO-8859-1" />
<![if IE]>
<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet"
	href="<c:url value='/webResources/css/general/main_ie.css'/>" />
<![endif]>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
		var _FLUJO   = "${respuesta.flujo}";
		var _TITULO  = "${respuesta.titulo}";
		var _MENSAJE = "${respuesta.mensaje}";
	</script>
</head>
<body>

	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>

	<!-- Inicia Wrapper -->
	<div class="wrapper">

		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle"
				value="Administraci&oacute;n<br /> de Turnos" />
			<jsp:param name="menuActivo" value="1" />
		</jsp:include>

		<br />

		<div class="Container">
			<div class="Layout__XL">
				<div class="Form__Group">
					<label class="Title__Label" for="usuario">Clientes con Cita (M&aacute;ximo ${respuesta.objetoRespuesta.limiteEnMinutosDeTurnoConCita} min)</label>
				</div>

				<table id="turnosConCitaId" class="Tablexl" cellspacing="5">
					<tr class="RowHeader">
						<th width="20%" class="folio">Turnos en Fila</th>
						<th width="60%">Nombre / Paterno del Cliente</th>
						<th width="20%">Tiempo de Espera</th>
					</tr>
					<tbody>
						<c:choose>
							<c:when test="${respuesta.objetoRespuesta.turnosConCita.size() > 0}">
								<c:forEach var="registroDeTabla" items="${respuesta.objetoRespuesta.turnosConCita}">
									<tr class="Row__1">
										<td class="${registroDeTabla.estiloCss} ${registroDeTabla.autorizadoCss} folio">${registroDeTabla.folioServicio}</td>
										<td class="${registroDeTabla.estiloCss}">${registroDeTabla.nombreTrabajador}</td>
										<td class="${registroDeTabla.estiloCss}">${registroDeTabla.minutosEspera}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr class="Row__1">
									<th colspan="3">Sin turnos registrados</th>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>

		<br />

		<div class="Container">
			<div class="Layout__XL">
				<div class="Form__Group">
					<label class="Title__Label" for="usuario">Clientes sin Cita (M&aacute;ximo ${respuesta.objetoRespuesta.limiteEnMinutosDeTurnoSinCita} min)</label>
				</div>

				<table id="turnosSinCitaId" class="Tablexl" cellspacing="5">
					<tr class="RowHeader">
						<th width="20%">Turnos en Fila</th>
						<th width="60%">Nombre / Paterno del Cliente</th>
						<th width="20%">Tiempo de Espera</th>
					</tr>
					<c:choose>
						<c:when test="${respuesta.objetoRespuesta.turnosSinCita.size() > 0}">
							<c:forEach var="registroDeTabla" items="${respuesta.objetoRespuesta.turnosSinCita}">
								<tr class="Row__1">
									<td class="${registroDeTabla.estiloCss} ${registroDeTabla.autorizadoCss} folio">${registroDeTabla.folioServicio}</td>
									<td class="${registroDeTabla.estiloCss}">${registroDeTabla.nombreTrabajador}</td>
									<td class="${registroDeTabla.estiloCss}">${registroDeTabla.minutosEspera}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr class="Row__1">
								<th colspan="3">Sin turnos registrados</th>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>

		<div class="push"></div>
		<br />

	</div>

    <jsp:include page="../generales/footerPrincipal.jsp" />

	<!-- Finaliza Wrapper -->

	<!-- Ventana modal para la finalización para los turnos.  -->
	<div id="finalizaTurnoModal" class="Modal">
		<div class="ModalContainer">
			<div class="ModalHeader">
				<h2 class="ModalTitle">Solicitud exitosa</h2>
				<a id="botonCerrarModal" href="#" class="ModalButton">X</a>
			</div>
			<form:form id="fm_actualizarTurnoEnAtencion" action="actualizarTurnoEnAtencion.do" modelAttribute="commandTurnoEnAtencion" method="POST">
				<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="../webResources/img/ok_icon.png" alt="icon_alert" />
				</div>
				<div id="mensajeModal" class="Modal__AlertText">Vuelva a seleccionar un turno.</div>
				<form:hidden path="folioServicio" />
				<form:hidden path="diferenciaHora"/>
				<div class="ModalFooter">
					<input id="submitActualizarTurnoEnAtencion" class="Submit" type="submit" value="Continuar">
					<input id="cancelar"                        class="Submit"               value="Cancelar">
				</div>
			</form:form>
		</div>
	</div>
	<!-- Ventana modal para la finalización para los turnos.  -->
	
	<!-- Ventana modal para la finalización para los turnos.  -->
	<div id="pendientePorFinalizarModal" class="Modal">
		<div class="ModalContainer">
			<div class="ModalHeader">
				<h2 class="ModalTitle">${respuesta.titulo}</h2>
				<a id="botonCerrarModal" href="#" class="ModalButton">X</a>
			</div>
			<div id="mensajeModal" class="Modal__Text">${respuesta.mensaje}</div>
			<div class="ContainerButtonsCenter">
				<a id="btnExitoAceptar"    class="Submitx">Aceptar</a>
			</div>
		</div>
	</div>
	<!-- Ventana modal para la finalización para los turnos.  -->

	<jsp:include page="modal.jsp" />

	<script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/menu_configuracion.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/administracion_turnos.js'/>"></script>

</body>
</html>
