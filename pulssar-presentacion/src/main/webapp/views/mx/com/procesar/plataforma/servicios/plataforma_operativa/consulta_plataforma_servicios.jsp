<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Consulta Plataforma Servicios</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	 <script src="<c:url value='/webResources/js/jquery-3.0.0.min.js'/>"></script>
	 <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datepiker/datepiker.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datepiker/datepiker2.css'/>"></link>
	 <script src="<c:url value='/webResources/js/datepiker.js'/>"></script>
	<script src="<c:url value='/webResources/js/datepiker2.js'/>"></script>	
	
	 <link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/consultaPlataformaServicios.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/webResources/js/datepiker.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/webResources/js/datepiker2.js'/>"></script>
</head>

<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Consulta de Servicios" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "9" />
	</jsp:include>
	<script type="text/javascript">		
	       var _TITULO = "${respuesta.titulo}";
	       var _MENSAJE = "${respuesta.mensaje}";
	       var _CLAVE_SERVICIO = "${claveServicioPlataforma}";
	</script>
	
	<div class="wrapper">
		<section>
			<div class="Title__Container">
				<h1>Consulta Plataforma Servicios</h1>
			</div>
			
			<div class="Container">
				<div class="Layout__M">
				<form:form id="fm_datosConsultaPlataforma" method="POST" modelAttribute="consulta" action="mostrarDatosPlataformaServicios.do">
				 <div class="Line">
                     <p></p>
                  </div>
					 <div class="Datos_Container">
					  <div class="Form__Group">
	                    <label class="LabelText" for="usuario"><b>Afore:</b></label>
	                   <c:if test="${not empty afores}">
										<div class="Form__Group">
											<form:select id="claveAfore"  class="Select_Multiple" name="afore" path="afore" data-not-null="0" data-nombre="Afore" multiple="true">
											     <!--  <option value="0">Seleccione una AFORE</option>-->
											     <option value="todos">TODAS</option>
												 <form:options items="${afores}" itemValue="clave" itemLabel="descripcion"/>
												</form:select>
												<center><span id="spanAfores" class="error_span">Seleccionar la(s) afore(s) a consultar.</span></center>
											</div>
					 </c:if>
                  </div>
                  <div class="Form__Group">
                    <label class="LabelText" for="usuario"><b>Usuario:</b></label>
                    <form:textarea class="Textarea" id="textAreaUsuarios" path="usuarios" rows="4" cols="50" onchange="deshabilitarBotones()"/>
                  </div>
                  <div class="Form__Group">
                    <label class="LabelText" for="usuario"><b>Folio Pulssar:</b></label>
                    <form:textarea class="Textarea" id="textFoliosPulssar" path="foliosPulssar" rows="4" cols="50"  onchange="deshabilitarBotones()"/>
                  </div>
                  <div class="Form__Group">
                    <label class="LabelText" for="usuario"><b>Resultado de la Operación:</b></label>
                    <form:select id="idResultado" path="resultadoOperacion" class="Select" onchange="deshabilitarBotones()">
								            <option value="0">Seleccione una opción</option>
								            <option value="01">ACEPTADO</option>
								            <option value="02">RECHAZADO</option>
				   </form:select>
                  </div>
                  <div class="Form__Group">
                    <label class="LabelText" for="usuario"><b>Periodo de la Consulta:</b></label>
                  </div>
                  <div class="Form__Group">
                    <label class="LabelText" for="usuario">Fecha Inicio:</label>
                    <form:input class="Inputxxl" type="text" value="" id="fchInicio"  placeholder="FECHA INICIO" data-nombre="fecha inicio" name="fechaInicio" path="fechaInicio"  min="2020-01-01" max="2020-01-01" readonly="readonly"/>
                    <center><span id="spanFechaIn" class="error_span">Fecha de periodo incorrecta, favor de validar</span></center> 
                  </div>
                  <div class="Form__Group">
                    <label class="LabelText" for="usuario">Fecha Fin:</label>
                    <form:input class="Inputxxl" type="text" value="" id="fchFin"  placeholder="FECHA FIN" data-nombre="fecha fin" name="fechaFin" path="fechaFin"  min="2020-01-01" max="2020-01-01"  readonly="readonly"/>
                    <center><span id="spanFechaFin" class="error_span">Fecha de periodo incorrecta, favor de validar</span></center>
                  </div>
                </div>
	                <div class="ContainerButtons">
	                  <input id="btnConsultarCaptura" class="Submitx" type="button" value="BUSCAR" />
					  <a  href="#" onclick="limpiar()" class="Submitx">LIMPIAR</a>
	                  <a href="subMenuConsultaServicios.do" class="Submitx">Regresar</a>
	                </div>
			   </form:form>
			 </div>
		</div>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
