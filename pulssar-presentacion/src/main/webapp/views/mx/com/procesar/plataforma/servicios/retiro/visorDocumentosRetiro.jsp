<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<![if IE]>
        <link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
    <![endif]>
  <link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/main.css'/>"></link>
  <link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link> 
  <link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>   
  <link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/carrousel_visor.css'/>"></link>
  <link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
  <link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/drag_and_drop.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/header.css'/>"></link>

  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
  
  <!-- Zoom Visor  -->
  <link rel="stylesheet" charset="utf-8" type="text/css"  href="<c:url value='/webResources/css/general/jquery.magnify.css'/>"></link>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.magnify.js'/>"></script>
  
   <!-- recibe respuesta del visor de documentos -->
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/respuestaVisorDocumentos.js'/>"></script>
</head>
<body>
<script type="text/javascript">    
	//var callBackUrl = "${destino}";
    var FOLIOPADRE = "${folioPadreModificacion.chFolio}";
    var SERVICIO = "${entradaImagenes.tipoProceso}";
    var NSS = "${datos.nss}";
    var CURP = "${entradaModificacionDatos13Plus.datosBaseCurp.curpNueva}";
    var SOLICITANTE = "${datos.tipoSolicitante}";
    var IDFOLIO_HIJO = "${folioHijo.idFolioPulssar}";
    var contextoSistema = "${pageContext.request.contextPath}";
    var AFORE = "${pulssarUP.aforeUsuario}";
    
</script>

    <c:set var="imagenesDoc" value="${imagenesDoctos.imagenes}" scope="request"/>
    <jsp:include page="../generales/visorDocumentosBanorte.jsp"/>
   
    <div class="ContainerButtonsCenter">
          <a href="#carruselDocumentosModal" class="Submitx">Mostrar</a>
     </div>
     
     <form:form action="${pageContext.request.contextPath}/${destino}" method="POST" modelAttribute="imagenesDoctos">
     
      <c:forEach items="${imagenesDoctos.imagenes}" var="imagen" varStatus="stat">
      	<form:hidden path="imagenes[${stat.index}].contenidoDocumento" value="${imagen.contenidoDocumento}"/>
      	<form:hidden path="imagenes[${stat.index}].nombreDocumento" value="${imagen.nombreDocumento}"/>
      	<form:hidden path="imagenes[${stat.index}].claveTipoDocumento" value="${imagen.claveTipoDocumento}"/>
      	<form:hidden path="imagenes[${stat.index}].tipoImagenDocumento" value="${imagen.tipoImagenDocumento}"/>
      </c:forEach>
    
     </form:form>
      
      <div class="ContainerButtonsCenter">
      <input id="btnRedigitalizar" class="Submit" type="button" value="Digitalizar" style="display:none;"/>
      </div>
      
     <jsp:include page="../generales/modals.jsp" />
     
</body>
</html>