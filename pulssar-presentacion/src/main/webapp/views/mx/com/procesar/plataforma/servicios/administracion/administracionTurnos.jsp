<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <title>Menu</title>
  <meta charset="utf-8"/>
  <![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link charset="UTF-8" rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="UTF-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>	
  
<!--   <link rel="shortcut icon" href="../../webResources/img/favicon.ico" /> -->
  <script charset="UTF-8" src="<c:url value='/webResources/js/jquery-3.0.0.min.js'/>"></script>
	<script charset="UTF-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script charset="UTF-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
  
  <script charset="UTF-8" type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/menu_configuracion.js'/>"></script>
  <script charset="UTF-8" type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/administracion_turnos.js'/>"></script>
</head>
<body>
	
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
    
  <!-- Inicia Wrapper -->
    <div class="wrapper">
      
      <jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="3" />
			<jsp:param name="menuTitle" value="Alta de Usuarios" />
			<jsp:param name="menuActivo" value = "1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
		</script>
      
	  <br/>
	  
      <div class="Container">
        <div class="Layout__XL">
          <div class="Form__Group">
            <label class="Title__Label" for="usuario">Clientes con Cita (Máximo ${respuesta.limiteEnMinutosDeTurnoConCita} min)</label>
          </div>
          
          <table id="turnosConCitaId" class="Tablexl" cellspacing="5">
            <tr class="RowHeader">
              <th width="20%" class="folio">Turnos en Fila</th>
              <th width="60%">Nombre / Paterno del Cliente</th>
              <th width="20%">Tiempo de Espera</th>
            </tr>
            <tbody>
	            <c:choose>
	          	<c:when test="${respuesta.turnosConCita.size() > 0}">
	          		<c:forEach var="registroDeTabla" items="${respuesta.turnosConCita}">
	          			<tr class="Row1">
			              <td class="${registroDeTabla.estiloCss} folio">${registroDeTabla.folioAtencion}</td>
			              <td class="${registroDeTabla.estiloCss}">${registroDeTabla.nombreTrabajador}</td>
			              <td class="${registroDeTabla.estiloCss}">${registroDeTabla.horaRegistro}</td>
			            </tr>
	          		</c:forEach>
	          	</c:when>
	          	<c:otherwise>
	          		<tr class="Row1">
	          			<th colspan="3">Sin turnos registrados</th>
	          		</tr>
	          	</c:otherwise>
	          	</c:choose>
          	</tbody>
          </table>
        </div>
      </div>

      <br/>

      <div class="Container">
        <div class="Layout__XL">
          <div class="Form__Group">
            <label class="Title__Label" for="usuario">Clientes sin Cita (Máximo ${respuesta.limiteEnMinutosDeTurnoSinCita} min)</label>
          </div>
          
          <table id="turnosSinCitaId" class="Tablexl" cellspacing="5">
            <tr class="RowHeader">
              <th width="20%">Turnos en Fila</th>
              <th width="60%">Nombre / Paterno del Cliente</th>
              <th width="20%">Tiempo de Espera</th>
            </tr>
            <c:choose>
          	<c:when test="${respuesta.turnosSinCita.size() > 0}">
          		<c:forEach var="registroDeTabla" items="${respuesta.turnosSinCita}">
          			<tr class="Row1">
		              <td class="${registroDeTabla.estiloCss} folio">${registroDeTabla.folioAtencion}</td>
		              <td class="${registroDeTabla.estiloCss}">${registroDeTabla.nombreTrabajador}</td>
		              <td class="${registroDeTabla.estiloCss}">${registroDeTabla.horaRegistro}</td>
		            </tr>
          		</c:forEach>
          	</c:when>
          	<c:otherwise>
          		<tr class="Row1">
          			<th colspan="3">Sin turnos registrados</th>
          		</tr>
          	</c:otherwise>
          	</c:choose>
          </table>
        </div>
      </div>

	  <div class="push"></div>
	  <br/>
	  
    </div>
    
<%--     <jsp:include page="componentes_pagina/pie.jsp"></jsp:include> --%>
    
     <!-- Finaliza Wrapper -->
  
	<!-- Ventana modal para la finalización para los turnos.  -->
	<div id="finalizaTurnoModal" class="Modal">
	    <div class="ModalContainer">
	      <div class="ModalHeader">
	      <h2 class="ModalTitle"></h2>
	      <a id="botonCerrarModal" href="#" class="ModalButton">X</a>
	      </div>
	      <div id="mensajeModal" class="Modal__Text">
	          Vuelva a seleccionar un turno.
	      </div>
	      <a id="linkPantallaFinalizaTurno">link</a>
	      <div class="ModalFooter">
	        <input id="submitFinalizarTurno" class="Submit" type="submit" value="Continuar">
	        <input id="cancelar" class="Submit" type="submit" value="Cancelar">
	      </div>
	    </div>
	</div>
	<!-- finaliza Ventana Modal  -->
	
<%-- 	<jsp:include page="modal.jsp"></jsp:include> --%>

</body>
</html>
