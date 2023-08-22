<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page
	import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Visor de Imágenes de Expedientes</title>
  <meta charset="utf-8" />
	<!--[if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/loader.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	
	
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
  <script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/dispositivos/530/tablet.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAgente.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle" value="Identifica a tu Cliente" />
			<jsp:param name="menuPrimario" value="3" />
			<jsp:param name="menuSecundario" value="1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
			var _VAR = '${cVar}';
			var context = '${pageContext.request.contextPath}';
			var _OBLIGSEL = '${selloObligatorio}';

			//Constantes para firmas
			var FOLIOPADRE = "${folioClave}";
			var SERVICIO = "${servicio}";
			var NSS = "${datos.nss}";
			var CURP = "${requestAutenticacionIne.curp}";
			var SOLICITANTE = "${tipoSolicitante}";
			var INTENTOS = "${intentos.chValorParametro}";
		</script>
		<input type="hidden" id="mensajeError" value="${error}" />
		
		<!-- Inicia Wrapper -->
          <div class="Title__Container">
            <h1>Datos del Solicitante Documento</h1>
          </div>
          <div class="Container">
            <div class="Layout__XL">
            <form id="formAutenticacionIneFirmarPdf" action="./autenticacionIneValidacionDatos.do" method="post">
              <div class="Line">
                <p></p>
              </div>
              <div class="Datos_Container">
                <div class="Modal__Alertpdf ">
                  <iframe src="data:application/pdf;base64,${pdfPlantilla}" width="90%" height="500px"></iframe>
                </div>
                <div class="Form__Group">
                  <input required type="checkbox" name="avisoPrivacidad" id="avisoPrivacidad" value="1"/>
			        <label for="check" class="LabelText" for="usuario">
			          Aceptar el aviso de privacidad (Consultar Aviso de Privacidad)
			        </label>
                </div>
              </div>
              <div class="ContainerButtons">
                <input id="btnFirmarPdfAutenticacioIne" class="Submit" type="submit" value="Continuar" />
              </div>
              </form>
              </div>
            </div>
          <!-- finaliza titulo seccion -->
          <div class="push"></div>
      <!-- Finaliza Wrapper -->
		
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/mensajes.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/timepicki.js'/>"></script>
	<script type="text/javascript">
		$('#timepicker1').timepicki({
			show_meridian:false,
			min_hour_value:0,
			max_hour_value:12,
			overflow_minutes:true,
			increase_direction:'up',
			disable_keyboard_mobile: true,
			start_time: ["00", "00"]
		});
	</script>
	<jsp:include page="../generales/modals.jsp" />

	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/autenticacionIne.js'/>"></script>
</body>
</html>
