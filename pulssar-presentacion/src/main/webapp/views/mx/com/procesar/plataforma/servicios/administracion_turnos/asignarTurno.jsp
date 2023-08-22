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
		console.log("${commandAsiganarTurno.indicadorTipoCita}")
	</script>
</head>
<body>

	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>

	<!-- Inicia Wrapper -->
	<div class="wrapper">

		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle"  value="Turno" />
			<jsp:param name="menuActivo" value="1" />
		</jsp:include>

		<br />
		
		<form:form id="fm_asiganarTurno" action="asignarTurno.do" modelAttribute="commandAsiganarTurno" method="POST">
		  <div class="Container">
		    <div class="Layout__L">
		    <div class="Title">
		      <p>ASIGNAR TURNO</p>
		    </div>
		      <div class="Datos_Container">
		      
		      	<!-- Solo se muestra para el indicador para Clientes con Cita. -->
		      	<c:if test="${commandAsiganarTurno.indicadorTipoCita == 1}">
			        <div id="id__cusEtiqueta"     class="DatosBack"><strong>CUS:</strong>${commandAsiganarTurno.cus}</div>
			        <div id="id__horaCusEtiqueta" class="DatosBack"><strong>FECHA Y HORA DE LA CITA:</strong>${commandAsiganarTurno.fechaCitaCusTexto}</div>
				</c:if>
		        <div class="DatosBack">
		          <label class="LabelText" for="usuario">Curp:</label>
		          <form:input id="id__curp" class="Inputxxl" path="curp" type="text" placeholder="Curp" disabled="true" maxlength="18" />
		          <br /><label class="Labeltexterror" id="labelErrorCurp" style="display:none;"></label>
		        </div>
		
		        <div class="DatosBack">
		          <label class="LabelText" for="usuario">NSS:</label>
		          <form:input id="id__nss" class="Inputxxl" path="nss" type="text" placeholder="NSS" disabled="true" maxlength="11" />
		          <br /><label class="Labeltexterror" id="labelErrorNss" style="display:none;"></label>
		        </div>
		
		        <div class="DatosBack">
		          <label class="LabelText" for="usuario">Nombre:</label>
		          <form:input id="id__nombre" class="Inputxxl" path="nombre" type="text" placeholder="Nombre" disabled="true" maxlength="50" />
		          <br /><label class="Labeltexterror" id="labelErrorNombre" style="display:none;"></label>
		        </div>
		
		        <div class="DatosBack">
		          <label class="LabelText" for="usuario">Apellido Paterno:</label>
		          <form:input id="id__apellidoPaterno" class="Inputxxl" path="apellidoPaterno" type="text" placeholder="Apellido Paterno" disabled="true" maxlength="50" />
		          <br /><label class="Labeltexterror" id="labelErrorApPaterno" style="display:none;"></label>
		        </div>
		
		        <div class="DatosBack">
		          <label class="LabelText" for="usuario">Apellido Materno:</label>
		          <form:input id="id__apellidoMAterno" class="Inputxxl" path="apellidoMaterno" type="text" placeholder="Apellido Materno" disabled="true" maxlength="50" />
		        </div>
		
		        <div class="DatosBack">
		          <label class="LabelText" for="usuario">Correo Electrónico:</label>
		          <form:input id="id__correo" class="Inputxxl" path="correoElectronico" type="text" placeholder="Correo Electrónico" disabled="true" maxlength="50" />
		          <br /><label class="Labeltexterror" id="labelErrorCorreo" style="display:none;"></label>
		        </div>
		
		        <div class="DatosBack">
		          <label class="LabelText" for="usuario">Número de Celular:</label>
		          <form:input id="id__celular" class="Inputxxl" path="numeroCelular" type="text" placeholder="Número de Celular" disabled="true" maxlength="10" />
		          <br /><label class="Labeltexterror" id="labelErrorCelular" style="display:none;"></label>
		        </div>
		        
		        <div class="DatosBack">
		          <label class="LabelText" for="usuario">Servicio Solicitado:</label>
		          <form:select id="id__servicioSolicitado" path="servicioSolicitado" class="Select">
		            <option value="">-- Seleccione Una opción --</option>
		            <form:options items="${listaServicios}" itemValue="clave" itemLabel="descripcion"/>
		          </form:select>
		          <br /><label class="Labeltexterror" id="labelErrorServicios" style="display:none;"></label>
		          <br>
		        </div>
		        <div class="DatosBack">
		          <label class="LabelText" for="usuario">Persona que solicita el Trámite:</label>
		          <form:select id="id__solicitante" path="solicitante" class="Select">
		            <option value="">-- Seleccione Una opción --</option>
		            <option value="01">Titular</option>
		            <option value="02">Beneficiario</option>
		          </form:select><br>
		          <br /><label class="Labeltexterror" id="labelErrorSolicitante" style="display:none;"></label>
		        </div>
		      </div>
		      
		      <div class="ContainerButtonsCenter">
		        <a id="id__asignarTurno" class="Submitx">Asignar</a>
		        <a id="id__botonHome"    class="Submitx">Cancelar</a>
		      </div>
		      </div>
		    </div>
		    
		    
		    <!-- Ventana modal para la confirmación de asignación de turnos.  -->
			<div id="confirmacionRegistroTurno" class="Modal">
				<div class="ModalContainer">
					<div class="ModalHeader">
						<h2 class="ModalTitle"></h2>
						<a id="botonCerrarModal" href="#" class="ModalButton">X</a>
					</div>
					<div class="Modal__IconAlertOK">
						<img class="IconAlert" src="../webResources/img/ok_icon.png" alt="icon_alert" />
					</div>
					<div id="mensajeModal" class="Modal__AlertText">¿Desea registrar un turno?</div>
					<div class="ModalFooter">
						<input id="submitRegistroTurno" class="Submit" type="submit" value="Aceptar">
						<input id="cancelar"            class="Submit"               value="Cancelar">
						
					</div>
				</div>
			</div>
			<!-- Ventana modal para la confirmación de asignación de turnos. -->
		    
		    <form:hidden path="cus" />
		    <form:hidden path="fechaCitaCusTexto" />
		    <form:hidden id="id__indicadorTipoCita" path="indicadorTipoCita" />
		    <form:hidden path="diferenciaHora"/>
		    
		</form:form>

		<div class="push"></div>
		<br />

	</div>

   <jsp:include page="../generales/footerPrincipal.jsp" />
	<!-- Finaliza Wrapper -->

	<jsp:include page="modal.jsp"></jsp:include>

	<script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/menu_configuracion.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/asignar_turno.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/administracion_turnos.js'/>"></script>

</body>
</html>
