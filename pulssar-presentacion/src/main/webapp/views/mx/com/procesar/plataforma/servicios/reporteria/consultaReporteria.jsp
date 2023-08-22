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
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/reporteria/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
    <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bootstrap_tables_dynamic.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/dataTables.bootstrap.min.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>	
		
	
	 <script type="text/javascript" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	 <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
	 <script type="text/javascript" src="<c:url value='/webResources/js/reporteria/consultarReporteria.js'/>"></script>
	 <script type="text/javascript" src=" <c:url value='/webResources/js/reporteria/jquery.dataTables.min.js' />"></script>
  	 <script type="text/javascript" src="<c:url value='/webResources/js/reporteria/dataTables.bootstrap.min.js' />"></script>
	
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
			var _FLUJO = "${respuesta.flujo}";
		</script>
      
	  <br/>
	  
	  <!-- inicia seccion resumen de movimientos -->
	 <form:form id="fm_reporteria" action="descargarReporteria.do" modelAttribute="consultaReporteria" method="POST" >
	  <div class="Container">
	    <div class="Layout__XL">
	    
	        <div style="overflow-x: auto;">
	          <table id="reporteriaTabla" class="table table-striped table-bordered" style="width:100%">
	           <thead> 
		            <tr class="RowHeader">
		              <th>No</th>
		              <th>Fecha</th>
		              <th>Curp del Cliente</th>
		              <th>Nombre del Cliente</th>
		              <th>Con cita o sin cita</th>
		              <th>CUS</th>
		              <th>Estatus de la Cita</th>
		              <th>Turno Asignado</th>
		              <th>Estatus de Turno</th>
		              <th>Servicio Solicitado</th>
		              <th>Hora de llegada del cliente</th>
		              <th>Hora de inicio de atención</th>
		              <th>Hora fin de atención</th>
		              <th>Tiempo de espera</th>
		              <th>Tiempo de atención</th>
		              <th>Nombre del ejecutivo que atendió</th>
		              <th>Nombre de CARE donde asistió</th>
		              <th># CARE</th>
		              <th>No. trámites realizados</th>
		              <th>Folio de Atención</th>
		            </tr>
	            </thead>
	            <tbody>
	            <c:forEach items="${listaReporteria}" var="reporteria" varStatus="index">
		            
		          <c:if test="${index.count % 2 !=0}"> 
		            <tr class="Row1">
		          </c:if>   
		          <c:if test="${index.count%2 ==0}">  
		            <tr class="Row2">
		          </c:if> 
		          	  <td>${index.count}</td> 
		              <td>${reporteria.fecha}</td>
		              <td>${reporteria.curpCliente}</td>
		              <td>${reporteria.nombreCompleto}</td>
		              <td>${reporteria.indicadorCita}</td>
		              <td>${reporteria.cus}</td>
		              <td>${reporteria.estatusCita}</td>
		              <td>${reporteria.turnoAsignado}</td>
		              <td>${reporteria.estatusTurno}</td>
		              <td>${reporteria.servicioSolicitado }</td>
		              <td>${reporteria.horaLlegada}</td>
		              <td>${reporteria.horaInicioAtencion}</td>
		              <td>${reporteria.horaFinAtencion}</td>
		              <td>${reporteria.tiempoEspera}</td>
		              <td>${reporteria.tiempoAtencion}</td>
		              <td>${reporteria.nombreUsuario}</td>
		              <td>${reporteria.nombreCareAsistio}</td>
		              <td>${reporteria.numeroCare}</td>
		              <td>${reporteria.numeroTramites}</td>
		              <td>${reporteria.folioAtencion}</td>
		            </tr>
	     		</c:forEach>
	            </tbody>
	          </table>
	        </div>
	        
	        
	        
	        <form:hidden path="fechaInicio" value="${fechaInicioFormato}"/>
	        <form:hidden path="fechaFin" value="${fechaFinFormato}"/>
	        <form:hidden path="tipoCliente" value="${consultaReporteria.tipoCliente}"/>
	        <form:hidden path="servicio" value="${consultaReporteria.servicio}"/>
	        <form:hidden path="numeroSucursal" value="${consultaReporteria.numeroSucursal}"/>

	        
	        
	        <div class="Layout__M">
			  <div class="ContainerButtons">
			    <input id="btnDescargar" class="Submitxl" type="submit" value="Exportar Archivo">
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