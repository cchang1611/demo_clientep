<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Reimpresion de Documentos</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datos_generales.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tooltip.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <!-- plugin de validacion -->
  <script type="text/javascript" src="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/reimpresion_documentos/reimpresion_documentos.js'/>"></script>
	
</head>
<body>

	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Reimpresi&oacute;n de Documentos" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	<div class="wrapper_reimpresion">
		<section>
			<div class="Title__Container">
				<h1>Reimpresi&oacute;n de Documentos</h1>
			</div>
			<div class="Container" height="400px">
			   <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="5" id="g-table">
                 <tbody>
                <tr class="Title espacio" style="cursor: pointer;" onclick="direccionarModuloReimpresion('${menuReimpresion.consentimientoEnrolamiento}')">
                  <td style="padding-left: 30px;">Consentimiento de Enrolamiento</td>
                   <td > 
                   		<div class="Icon_Check_initial">
							<img  class="IconImg" src="../webResources/img/correo.png" alt="icon_ok" />
						</div>
                   </td>
                   <td >   
                   		<div class="Icon_Check_initial">
                   		    <img class="IconImg" src="../webResources/img/impresora.png" alt="icon_menu"/>
						</div>
                   </td>
                </tr>
                <tr class="Title espacio"  style="cursor: pointer;" onclick="direccionarModuloReimpresion('${menuReimpresion.solicitudModificacionDatos}')">
                  <td style="padding-left: 30px;">Solicitud de modificación de datos</td>
                  <td> 
                   		<div class="Icon_Check_initial">
							<img  class="IconImg" src="../webResources/img/correo.png" alt="icon_ok"/>
						</div>
                   </td>
                   <td> 
                   		<div class="Icon_Check_initial">
                   			<img class="IconImg" src="../webResources/img/impresora.png" alt="icon_menu"/>
						</div>
                   </td>
                </tr>
                <tr class="Title espacio" style="cursor: pointer;" onclick="direccionarModuloReimpresion('${menuReimpresion.permanencia}')">
                  <td style="padding-left: 30px;">Permanencia</td>
                  <td> 
                   		<div class="Icon_Check_initial">                	
							<img class="IconImg" src="../webResources/img/correo.png" alt="icon_ok"/>
						</div>
                   </td>
                   <td> 
                   		<div class="Icon_Check_initial">
                   			<img  class="IconImg" src="../webResources/img/impresora.png" alt="icon_menu"/>
						</div>
                   </td>
                </tr>
                <tr class="Title espacio" style="cursor: pointer;" onclick="obtieneSaldosYMovimientos()">
                  <td style="padding-left: 30px;">Saldos y Movimientos</td>
                   <td> 
                   		<div class="Icon_Check_initial">
							<img class="IconImg" src="../webResources/img/correo.png" alt="icon_ok"/>
						</div>
                   </td>
                  <td> 
                   		<div class="Icon_Check_initial">
                   			<img  class="IconImg" src="../webResources/img/impresora.png" alt="icon_menu"/>
						</div>
                   </td>
                </tr>
                </tbody>
              </table>
			</div>			
		</section>
		
		<!-- div class="push"></div-->
		
	</div>
	<jsp:include page="../menus/menuConsulta.jsp" />
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<script src="<c:url value='/webResources/js/cargaRefBen.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>

	
	
	
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
