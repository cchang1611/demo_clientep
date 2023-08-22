<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <title>Reporteria</title>
  <meta charset="utf-8"/>
  <![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datepiker/datepiker.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datepiker/datepiker2.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
		
  
<!--   <link rel="shortcut icon" href="../../webResources/img/favicon.ico" /> -->
  <script src="<c:url value='/webResources/js/jquery-3.0.0.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
	<script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
  
  <script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/menu_configuracion.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/webResources/js/reporteria/inicioReporteria.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/webResources/js/datepiker.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/webResources/js/datepiker2.js'/>"></script>
 
</head>
<body>

	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	
	 <!-- Inicia Wrapper -->
    <div class="wrapper">
    	
    	  <jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle" value="Reporteria" />
			<jsp:param name="menuActivo" value = "1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${flujo}";
			var fechaLimiteBusqueda="${fechaLimite}";
			var fechaHoy   ="${fechaHoy}";
			var msjBusqueda= "${mensajeBusqueda}";
		</script>
      
	  <br/>
	  
	  
	<form:form id="fm_reporteria" action="consultarReporteria.do" modelAttribute="commandReporteria" method="POST"    >
	  <div class="Container">
	    <div class="Layout__L">
	      <div class="Line"></div>
	        <div class="Datos_Container">
	        <div class="DatosBackReporteria">
	        <div class="Section">
	          <div class="Col01">
	            <label class="LabelText" for="usuario">Fecha Inicio:</label>
	            <form:input class="Inputxxl" type="text" path="fechaInicio"  value="" placeholder="FECHA INICIO" id="fechaInicio" autocomplete="off"/>
	          </div>
	
	          <div class="Col02">
	            <label class="LabelText" for="usuario">Fecha Fin:</label>
	            <form:input class="Inputxxl" type="text" path="fechaFin"  value=""  placeholder="FECHA FIN" id="fechaFin" autocomplete="off" />
	          </div>
	        </div>
	      </div>
	
	        <div class="DatosBackReporteria">
	        <div class="Form__Group">
	          <label class="LabelText" for="usuario">Tipo de Cliente:</label>
	          <form:select id="tipoCliente" path="tipoCliente" class="Select">
	            <option value="">Seleccione</option>
	            <option value="'FS','FC'">Todos</option>
	            <option value="'FC'">Con Cita</option>
	            <option value="'FS'">Sin Cita</option>
	          </form:select>
	        </div>
	      </div>
	        <div class="DatosBackReporteria">
	        <div class="Form__Group">
	          <label class="LabelText" for="usuario">Servicio Solicitado:</label>
	          <form:select id="tipoServicio"  path="servicio" class="Select">
	            <option value="">-- Seleccione--</option>
	             <form:options items="${comboTipoServicio}" itemValue="clave" itemLabel="descripcion"/>
	          </form:select>
	        </div>
	      </div>
	      <c:if test="${banderaMostrar==ES_EJECUTIVO}">
	        <div class="DatosBackReporteria">
	          <strong>Ejecutivo de Atención:</strong> ${commandReporteria.ejecutivoAtencion }
	        </div>
	        <div class="DatosBackReporteria">
	          <strong># CARE:</strong> ${commandReporteria.numeroSucursal}
	          <form:hidden path="numeroSucursal" value="${commandReporteria.numeroSucursal}"/>

	        </div>
	       </c:if> 
	        <div class="Form__Group">
	          <div class="ContainerButtonsCenter">
	            <input id="btnAceptar"  class="Submit" type="button" value="Consultar">
	            <input id="btnCancelar"  class="Submit" type="button" value="Cancelar">
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</form:form>
	  
    <div class="push"></div>
		<br />
    </div>
    <jsp:include page="../generales/footerPrincipal.jsp" />
    <!-- Finaliza Wrapper -->
    
<!--     Modal para sesion caducada -->
    <jsp:include page="../administracion_turnos/modal.jsp"></jsp:include>
    
	
</body>
</html>