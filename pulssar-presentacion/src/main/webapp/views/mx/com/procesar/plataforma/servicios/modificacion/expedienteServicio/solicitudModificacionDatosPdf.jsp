<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <title>Datos Generales del Trabajador</title>
  <meta charset="utf-8">
  <![if IE]>
	<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
  <![endif]>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datos_generales.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carousel/slick_carousel.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/jquery.dataTables.min.css'/>">
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
  <!-- plugin de validacion -->
  <script type="text/javascript" src="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.min.js'/>"></script>
	
  <script type="text/javascript" src="<c:url value='/webResources/js/jquery.validate.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/validator.js'/>"></script>
<%--   <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/datosCertificados.js'/>"></script> --%>

  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick-theme.min.css'/>"/>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick.css'/>"/>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/beneficiarios.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/expedienteServicio/expedienteServicio.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/dispositivos/530/tablet.js'/>"></script>
  <script type="text/javascript">	
		var AFORE = "${pulssarUP.aforeUsuario}"
		var FOLIOPADRE = "${folioPadreModificacion.chFolio}"
		var SERVICIO = "${procesoModificacion}"
		var NSS = "${nssProceso}"
		var CURP = "${curpProceso}"
		var SOLICITANTE = "${tipoSolicitante}"
		var _FLUJO = "${respuesta.flujo}";
		var INTENTOS = "${intentos.chValorParametro}";
		var IDFOLIO_HIJO = "${folioHijo.idFolioPulssar}";
		var AGENTE = "${agente}";
		var AMBIENTE = "${ambienteBanorte}";
		var CURPSOLICITANTE = "${curpSolicitante}";
		var CAMBIORFC = "${cambioRfc}";		
		var IDSESION = "${eUserCoppel.idSession}";	
		var FLUJODIGITALIZADOR = "${flujoDigitalizador}";
		var BANDERA9B = "${banderaFlujo9B}";
		
		
	//se obtiene valor para ocultar el boton de descarga para ciertas afores asignadas enn un parametro
	//Autor: Ricardo alcantara ramirez 19/04/22
		function descargaOpc() {
			obtenerParametro(2);
// 			$("#divDescargar").show();			
// 			alert("valor paramaetro: "+valor)
// 			if (valor) {
// 				$("#divDescargar").hide();
// 			}
		}
		
		
 </script>
 
   <c:choose>
         
         <c:when test = "${stiloOrg == '568'}">
            <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/expedienteServicio/firmasExpedienteServicio_topaz.js'/>"></script>
            <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dispositivos/568/digitalizacion.js'/>"></script>           
         </c:when>
         
         <c:otherwise>
            <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/expedienteServicio/firmasExpedienteServicio.js'/>"></script>
         </c:otherwise>
      </c:choose>  
  
  
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tooltip.css'/>"></link>
</head>
<body onload="obtenerParametro(2)">
	<jsp:include page="../../generales/headGeneral.jsp"></jsp:include>
  <jsp:include page="../../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Expediente de Servicio de Modificaci&oacute;n de Datos" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	

	<div class="wrapper">
		<section>
			<div id="botonesPdf" class="ContainerButtonsCenter" alingn="center" style="text-align: center;">
            	<input id="prevbutton" class="Submit" type="button" value="Pag. Anterior" disabled="disabled"/>
            	<input id="nextbutton" class="Submit" type="button" value="Pag. Siguiente" disabled="disabled"/>
				<input id="zoominbutton" class="Submit" type="button" value="Zoom +" />
				<input id="zoomoutbutton" class="Submit" type="button" value="Zoom -"/>
			</div>
		<div class="Container" id="idSeccionSolicitudModifDatosPdf">
		<div>
			<div id="resultadoPdf" style="height: 500px;  width:900px;  overflow: auto; background: #0C3741;">

				<table>
				        <tr><td><canvas id='the-canvas'></canvas></td></tr>
				
         
 					<tr><td><canvas id='cnv' name='cnv' height='100' style='max-width: 400; display:none;' ></canvas></td></tr> 
				</table>
			</div>
			<canvas id='cnv' name='cnv' height='100' style='max-width: 400; display:none;' ></canvas>					
			<div class="ContainerButtonsCenter" align="center">
	 <c:choose>
         
         <c:when test = "${stiloOrg == '530'}">
         	      <input id="btnSolicitarFirmas" class="Submitxl" type="button" value="SOLICITAR ARCHIVOS" />
         </c:when>
         <c:otherwise>
         	<input id="btnFirmarTrabajador" class="Submitxl" type="button" value="FIRMA DEL TRABAJADOR" />
			<input id="btnAgenteFirma" class="Submitxl" type="button" value="FIRMA DEL AGENTE" style="display: none" />
         </c:otherwise>
     </c:choose>
     <c:choose>
            <c:when test = "${stiloOrg == '568'}">
				<input id="btnRecepcionImgCop" class="Submitxl" type="button" value="DIGITALIZAR" style="display: none" />
         	</c:when>
         	<c:otherwise>
				<input id="btnContinuar" class="Submitxl" type="button" value="CONTINUAR" style="display: none" />
			</c:otherwise>
				
	</c:choose>
			</div>
			<div class="ContainerButtonsCenter" align="center">
				<input id="btnRegresarModifDatos" class="Submit" type="button" value="REGRESAR"/>
				
				<div id="divDescargar">
					<input id="btnDescargar" class="Submit" type="button" onclick="downloadPDF();" value="DESCARGAR"/>
				</div> 
<!-- 				<br></br> -->
<!-- 				<button onclick="descargaOpc()" type="button">click</button> -->
			</div>
		</div>				
	</div>
	</section>
		<form:form id="fm_recepcionImagenes" method="GET" modelAttribute="entradaRecepcionImagenes" action="recepcionImagenesGenerico.do">
<%--  			<form:input id="idFolioPadre" type="hidden" name="folioPadre" path="folioPadre" value="folio" /> --%>
 			<form:input id="idFolioPadre" type="hidden" name="folioPadre" path="folioPadre" value="${folioPadreModificacion.chFolio}" />
 			<form:input id="idFolioHijo" type="hidden" name="folioHijo" path="folioHijo" value="${folioHijo.chFolio}" />
 			<form:input id="idTipoProceso" type="hidden" name="tipoProceso" path="tipoProceso" value="${procesoModificacion}"/>
 			<form:input id="idEstatusRecepcion" type="hidden" name="estatusRecepcion" path="estatusRecepcion" value="1" />
			<form:input id="idUrlSiguiente" type="hidden" name="urlSiguiente" path="urlSiguiente" value="private/enviarSolicitudBan.do" />
		</form:form>
	<div class="push"></div>
</div>
	<jsp:include page="../../generales/footerAgente.jsp" />
	<jsp:include page="../../generales/modals.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript">
	  var contextoSistema = "${pageContext.request.contextPath}";
	</script>
</body>
</html>
