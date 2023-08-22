<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page
	import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Reintegro de recursos por un retiro parcial por desempleo</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/container.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/templates.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/webResources/css/general/tables.css'/>"></link>


<link rel="shortcut icon"
	href="<c:url value='/webResources/img/favicon.ico'/>"></link>
<link
	href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap"
	rel="stylesheet"></link>
<script type="text/javascript" charset="UTF-8"
	src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
<script type="text/javascript" charset="UTF-8"
	src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
<script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
<script type="text/javascript"
	src="<c:url value="/webResources/js/reintegroRecursosDesempleo.js"/>"></script>

</head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
FolioEntrada folio = datos.getFolio();
%>
<body>
	<input type="hidden" id="mensaje" value="${mensaje}" />
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle"
			value="Reintegro de recursos por un retiro parcial por desempleo" />
		<jsp:param name="menuPrimario" value="2" />
		<jsp:param name="menuSecundario" value="2" />
		<jsp:param name="menuInactivo" value="2" />
	</jsp:include>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
	</script>
	<!-- Inicia Wrapper -->
	<div class="wrapper">
		<div class="Title__Container">
			<h1>
				Datos de Referencia
				<p>Reintegro de Recursos</p>
			</h1>
		</div>

		<div class="Container">
			<div class="Layout__XL" style="width: 90%;">

				<div class="Title">
					<p>Confirmación</p>
				</div>

				<div class="Datos_Container" style="text-align: center;">
					<iframe src="./generarDatosReferenciaPdf" style="border: none;min-height: 500px;width: 78%;">
					</iframe>
				</div>

				<div class="ContainerButtons">
					<input style="width: 40%;" class="Submitxl" id="btnCerrarDatosReferenciaPdf" value="Cerrar">
				</div>
			</div>
		</div>
		<!-- finaliza titulo seccion -->
		<div class="push"></div>
	</div>

	<!-- Finaliza Wrapper -->
	<div class="push"></div>

		 <!-- inicia Ventana Modal 2 -->
  <div id="miModal2" class="Modal">
    <div class="ModalContainer">
      <div class="ModalHeader">
      <h2 class="ModalTitle"></h2>
      <a href="#" class="ModalButton">X</a>
      </div>
      <div class="Modal_Container">
        <div class="Modal__Text">
          <p style="font-size:20px;">Muchas gracias, su Folio de Atención es <span class="Linkconcluido">${folio.folio}.</span></p>
          <p style="font-size:15px; padding: 10px;">El pago se realizará en un periodo máximo de <span <span class="Linkconcluido">5</span> días hábiles.</p>
          <p style="font-size:12px; text-align: justify; padding: 10px;">Si requiere información adicional sobre el avance de su trámite,
          favor de comunicarse al Centro de Atención Telefónica: 30 99 80 31 / 01 800 112 13 13
          o acudir a cualquiera de nuestras más de 800 sucursales en la República Mexicana</p>
          <p style="font-size:20px;">A t e n t a m e n t e</p>
          <p style="font-size:15px;">TRÁMITES SAR</p>
          <p style="font-size:12px; text-transform:lowercase;">www.trámitessar.com.mx</p>

        </div>
      </div>
      <div>
        <form class="ModalFooter" action="./amenu.do" method="get">
          <input  class="Submit" type="submit" value="Salir" id="btnContinuar">
        </form>
      </div>
    </div>
  </div>
  <!-- finaliza Ventana Modal 2 -->
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
