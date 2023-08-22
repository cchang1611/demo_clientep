<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<head>
  <title>Menu</title>
  <meta charset="utf-8" />
  <![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
  <![endif]>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
  
  <link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
  <link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bootstrap_tables_dynamic.css'/>"></link>  
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/dataTables.bootstrap.min.css'/>"></link>
  	<script src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
	<script src="<c:url value='/webResources/js/dataTables.bootstrap.min.js'/>"></script>
</head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
FolioEntrada folio = datos.getFolio();
%>

<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<input type="hidden" id="mensaje" value = "${mensaje}"/>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Ayuda de Desempleo" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	<div class="wrapper">
		<div class="Title__Container">
		  <h1>Solicitud Parcial ISSSTE <br>Operaci&oacute;n 52</h1>
		</div>
			<form:form method="post" action="${pageContext.request.contextPath}/private/solicitudParcialIsssteSalida.do" id="retiroDesempleoIssste" modelAttribute="retiroDesempleoIssste">

			<input id="secuenciaPension" type="hidden" name="secuenciaPension"
				value="${resolucion.secuenciaPension}" />
			<input id="numeroConcesion" type="hidden" name="numeroConcesion"
				value="${resolucion.numeroConcesion}" />
			<input id="selloTrabajador" type="hidden" name="selloTrabajador"
				value="${retiroDesempleoIssste.selloTrabajador}" />
			<input id="resultadoOperacion" type="hidden" name="resultadoOperacion"
				value="${resultadoOperacion}" />
			<input id="mensaje" type="hidden" name="mensaje"
				value="${mensaje}" />
			<input id="jsonInstitucionBancaria" type="hidden" name="jsonInstitucionBancaria"
				value="${jsonInstitucionBancaria}" />
			<input id="folioPadre" type="hidden" name="folioPadre"
				value="${folio.folio}" />
			<input type="hidden" id="idFolioHidden" name="idFolio"
				value="${folio.idFolio}" />
				

		  <div class="Layout__L">
			<div class="Line"></div>
			<div class="Datos_Container">
				 <div class="DatosBack"><strong>CUS:</strong><p id="cusid">${retiroDesempleoIssste.cus}</p></div> 
				
				<div class="DatosBack"><strong>CV AFORE:</strong> ${datos.claveAfore}</div>
				<div class="DatosBack"><strong>CURP:</strong> ${datos.datosCertificables.curp}</div>
				<div class="DatosBack"><strong>NSS:</strong> ${datos.nss}</div>
				<div class="DatosBack"><strong>SECUENCIA PENSI&oacute;N:</strong> ${resolucion.secuenciaPension}</div>
				<div class="DatosBack"><strong>NOMBRE:</strong> ${datos.datosCertificables.nombre}</div>
				<div class="DatosBack"><strong>APELLIDO PATERNO:</strong> ${datos.datosCertificables.apellidoPaterno}</div>
				<div class="DatosBack"><strong>APELLIDO MATERNO:</strong> ${datos.datosCertificables.apellidoMaterno}</div>
				<div class="DatosBack"><strong>TIPO PRESTACI&Oacute;N:</strong>05</div>
				<div class="DatosBack"><strong>R&Eacute;GIMEN:</strong>${resolucion.iretMatrizDerecho.claveTipoRegimen}</div>
				<div class="DatosBack"><strong>TIPO RETIRO:</strong> F</div>
				<!-- div class="DatosBack"><strong>MONTO DISPONER:</strong>${montoDisponer}</div-->
				<div class="DatosBack"><strong>N&Uacute;MERO CONCESI&Oacute;N:</strong> ${resolucion.numeroConcesion}</div>
				<div class="DatosBack"><strong>SELLO TRABAJADOR:</strong><p id="selloid"> ${retiroDesempleoIssste.selloTrabajador}</p>
				</div>
				<div class="DatosBack"><strong>CURP AGENTE:</strong> <%= usuario.getCurpAgente()%></div>
				<div class="DatosBack"><strong>CURP SOLICITANTE:</strong> ${datos.datosCertificables.curp}</div>
				<div class="DatosBack"><strong>TIPO SOLICITANTE:</strong> 1</div>
				<div class="DatosBack"><strong>NÚMERO ISSSTE:</strong> ${resolucion.numeroIssste}</div>
			<c:if test="${boton == true}">
				<div style="display: flex; justify-content:center; align-items:center;">
					<input id="montoad" class="Submitx" type="button" value="Monto" />
				</div>
			</c:if>
			  </div>
			</div>


			<div class="ContainerButtonsCenter">
			<c:if test="${boton == true}">
			
				<input id="btnPago" class="Submit" type="button" value="Forma de pago" onclick="mostrarPopupFormaPago()"/>
				<input id="btnSolicitar" class=Submit_disabled type="submit" value="Siguiente" disabled="disabled" />
			</c:if>
			</div>
		<jsp:include page="../retiro/modalTipoRetiro.jsp" />	
    	</form:form>
		<c:if test="${boton == false}">
    		<div class="ContainerButtonsCenter">
			<form:form id="fm_datosConsulta" method="POST" modelAttribute="commandConsulta" action="actualizarDatos.do">
        		<form:input id="idCurpConsultaaa" type="hidden"  path="curp" value="${commandConsulta.curp}" />
                <form:input id="idNssConsultaaa" type="hidden"  path="nss" value="${commandConsulta.nss}" />
                <form:input id="claveConsultaaa" type="hidden"  path="cvTipoSolicitante" value="${commandConsulta.cvTipoSolicitante}" />
                <form:input id="timepicker11" type="hidden"  path="timerPicker" value="${commandConsulta.timerPicker}" />
            </form:form>
            </div>
  		</c:if>
		<div class="push"></div>
	</div>
	<div id="seccionModalPdf"></div>

	<jsp:include page="../retiro/modalMontoDisponer.jsp" />
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
  
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/ventanaPdfs.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/solicitudParcialIssste.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modaltiporetiro.js'/>"></script>
  <script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
  <script type="text/javascript">
  	URL_MODAL_PDF='<c:url value="/private/generarPdfSolicitudDisposicionParcialIssste"/>';
	jsonInstiticionesBancarias = '${jsonInstitucionBancaria}';	
	var parametroForm = "#retiroDesempleoIssste";
	var tipo = '${tipoTramite}';
</script>	

</body>
</html>
