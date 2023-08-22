<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <title>Menu</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
FolioEntrada folio = datos.getFolio();
%>
<body>
	<input type="hidden" id="mensaje" value = "${mensaje}"/>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Ayuda de Desempleo" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "2" />
	</jsp:include>

   <div class="wrapper">
  <div class="Container">

    <div class="Title__Container">
      <h1>Ayuda por Desempleo</h1>
    </div>

    <div class="Container">
	<div class="Layout__M">
      <form:form id="formSalida" method="post" action="${pageContext.request.contextPath}/private/solicitaCertificado.do" modelAttribute="salida">
        <div class="Line"></div>
        <div class="Datos_Container">
         	 <div class="DatosBack"><strong>CUS:</strong><p id="cusid">${retiroDesempleoImss.cus}</p></div> 
         	<%-- <div class="DatosBack"><strong>CUS:</strong><p id="cusid">${cus}</p></div> --%>
			 <c:if test="${botoncus == true}">
	            <div class="ContainerButtons">
	              <input id="btnCus" class="Submitx" type="button" value="Generar CUS"/><br/>
	            </div>
	        </c:if> 
            <div class="DatosBack"><strong>NSS:</strong> ${datos.nss}</div>
            <div class="DatosBack"><strong>CURP:</strong> ${datos.datosCertificables.curp}</div>
            <div class="DatosBack"><strong>NOMBRE DEL TRABAJADOR:</strong> ${datos.datosCertificables.nombre}</div>
            <div class="DatosBack"><strong>APELLIDO PATERNO:</strong> ${datos.datosCertificables.apellidoPaterno}</div>
            <div class="DatosBack"><strong>APELLIDO MATERNO:</strong> ${datos.datosCertificables.apellidoMaterno}</div>
            <div class="DatosBack"><strong>TIPO DE PRESTACIÓN:</strong> RETIRO POR DESEMPLEO</div>
        </div>
         <div class="Line"></div>
        <div class="Datos_Container">
            <div class="DatosBack"><strong>SELLO TRABAJADOR:</strong>
	            <c:if test="${datos.sello != null}">
					<p id="selloid"> ${datos.sello.id}</p>
	            </c:if>
            </div>
            <div class="DatosBack"><strong>CURP AGENTE SERVICIO:</strong> <%= usuario.getCurpAgente()%></div>
        </div>
  	    <c:if test = "${datos.claveAfore == '568'}">
	        <div class="Line"></div>
	       	<div class="Datos_Container">
				<label class="LabelTextEdit" for="Telefonia">Telefonía móvil:</label>
	           	<select class="Select" id="telefonia"  name="telefonia" data-not-null="0" data-nombre="Telefonia">
					<option value="">Seleccione la Telefonía móvil</option>
					<c:forEach var="telefonias" items="${telefonias}">
						<option value="${telefonias.chValorParametro}">${telefonias.chValorParametro}</option>	
					</c:forEach>
				</select>								
	        </div>
	    </c:if>
        <div class="ContainerButtonsCenter">
        <!-- intecarmbiar condiciones ya que estan asi para probar solamente -->
        	<c:if test="${botoncertdisabled == true}">
	        	<input id="btnSolicitar" class="Submitxl" type="button" value="Solicitar Certificado" />	
           	</c:if>          	
        	<c:if test="${botonImpresion == true}">
          		<input id="btnSolicitar" class="Submit" type="button" value="Imprimir" />
           	</c:if>          	
        </div>
   			<input id="selloTrabajador" type="hidden" name="selloTrabajador"
				value="${datos.sello.id}" />
   			<input id="cus" type="hidden" name="cus"
				value="${retiroDesempleoImss.cus}" />
			<input type="hidden" id="folioHidden" name="folio"
				value="${folio.folio}" />
			<input type="hidden" id="idFolioHidden" name="idFolio"
				value="${folio.idFolio}" />
			<input type="hidden" id="afore" name="afore" value="${datos.claveAfore}" />
				
	</form:form>
    </div>
	</div>
  </div>
<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
  

  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/ayudaDesempleo.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
</body>
</html>
