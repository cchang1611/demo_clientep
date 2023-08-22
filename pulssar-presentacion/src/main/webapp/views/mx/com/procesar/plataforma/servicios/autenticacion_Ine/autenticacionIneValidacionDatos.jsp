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

		</script>
		<input type="hidden" id="mensaje" value="${error}" />
		
		<!-- Inicia Wrapper -->
        <div class="wrapper">
          <div class="Title__Container">
            <h1>Validación de los Datos de Autenticación por INE</h1>
          </div>
             <form id="formAutenticacionIneDatos" action="./redireccionaIneHuellas.do" method="post">
          <div class="Container">
            <div class="Layout__XL">
              <div class="Line">
                <p></p>
              </div>
              <div class="Datos_Container">
                <div class="Datos_Container">
                  <div class="Section">
                    <div style="width: 100%; max-width: 480px;">
                      <div class="DatosBack">
                        <div class="Form__Group">
                          <label class="LabelText" for="usuario">Apellido Paterno:</label>
                          <input required maxlength="32" class="Inputxxl" type="text" name="apellidoPaterno" id="apellidoPaterno" value="" placeholder="Apellido Paterno">
                        </div>
                      </div>
                      <div class="DatosBack">
                        <div class="Form__Group">
                          <label class="LabelText" for="usuario">Apellido Materno:</label>
                          <input class="Inputxxl" maxlength="32" type="text" name="apellidoMaterno" id="apellidoMaterno" value="" placeholder="Apellido Materno">
                        </div>
                      </div>
                      <div class="DatosBack">
                        <div class="Form__Group">
                          <label class="LabelText" for="usuario">Nombre:</label>
                          <input required maxlength="32" class="Inputxxl" type="text" name="nombre" id="nombre" value="" placeholder="Nombre">
                        </div>
                      </div>
                      <div class="DatosBack">
                        <div class="Form__Group">
                          <label class="LabelText" for="usuario">CURP:</label>
                          <input required size="18" class="Inputxxl" type="text" name="curp" id="curp" value="" placeholder="CURP">
                        </div>
                      </div>
                      <div class="DatosBack">
                        <div class="Form__Group">
                          <label class="LabelText" for="usuario">Año de Registro:</label>
                          <input required maxlength="4" class="Inputxxl" type="text" name="anioRegistro" value="" id="anioRegistro" placeholder="Año de Registro">
                        </div>
                      </div>
                      <div class="DatosBack">
                        <div class="Form__Group">
                          <label class="LabelText" for="usuario">Año de Emisión:</label>
                          <input required maxlength="4" class="Inputxxl" type="text" name="anioEmision" value="" id="anioEmision" placeholder="Año de Emisión">
                        </div>
                      </div>
                    </div>
                    <div style="width: 100%; max-width: 480px;">
                      <div class="DatosBack">
                        <div class="Form__Group">
                          <label class="LabelText" for="usuario">OCR:</label>
                          <input required maxlength="13" class="Inputxxl" type="text" name="ocr" value="" id="ocr" placeholder="OCR">
                        </div>
                      </div>
                      <div class="DatosBack">
                        <div class="Form__Group">
                          <label class="LabelText" for="usuario">Clave de Elector:</label>
                          <input required size="18" class="Inputxxl" type="text" name="claveElector" value="" id="claveElector" placeholder="Clave de Elector">
                        </div>
                      </div>
                      <div class="DatosBack">
                        <div class="Form__Group">
                          <label class="LabelText" for="usuario">Número de Emisión de la Credencial:</label>
                          <input required maxlength="2" class="Inputxxl" type="text" name="emision" value="" id="emision" placeholder="Número de Emisión de la Credencial">
                        </div>
                      </div>
                      <div class="DatosBack">
                        <div class="Form__Group">
                          <label class="LabelText" for="usuario">Fecha Firma:</label>
                          <input required class="Inputxxl" type="text" name="fechaFirma" id="fechaFirma" placeholder="Fecha Firma">
                        </div>
                      </div>

                      <div class="DatosBack">
                        <strong>Elección del tipo de credencial de elector:</strong>
                        <input type="radio" name="radio" value="INE"> INE /
                        <input type="radio" name="radio" value="IFE"> IFE
                      </div>
                    </div>
                  </div>
                  <div class="Form__Group">
                    <label class="LabelText" for="usuario" style="color:red;">
                      <strong>
                        La captura de los datos solicitados es obligatoria, favor de verificar*
                      </strong>
                    </label>
                  </div>
                </div>
              </div>
              <div class="ContainerButtons">
				<input id="btnConfirmar" class="Submitx" type="button" value="Confirmar"/>
              </div>
              </div>
             </form>
           </div>
          <!-- finaliza titulo seccion -->
          <div class="push"></div>
        </div>
      <!-- Finaliza Wrapper -->
		
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/autenticacion_ine_datos.js'/>"></script>

	<jsp:include page="../generales/modals.jsp" />

	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dispositivos/530/autenticacionIneValidacionDatos.js'/>"></script>
</body>
</html>
