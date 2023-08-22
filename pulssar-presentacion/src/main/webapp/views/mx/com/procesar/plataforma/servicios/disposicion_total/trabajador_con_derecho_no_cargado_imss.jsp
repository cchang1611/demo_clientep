<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title> </title>
	 <meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/bootstrap.min.js'/>"></script>	
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/bootstrap.js'/>"></script>								
					
				<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/accordion.js'/>"></script>
				<%-- <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pagoPorParcialidad.js'/>"></script>	
				<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/estatusPorParcialidad.js'/>"></script>  --%>
				
				<%-- <script src="<c:url value='/webResources/js/pressFormulario.js'/>"></script> --%>
	
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	
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
		<jsp:param name="menuTitle" value="TRABAJADOR CON DERECHO NO CARGADO" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	<script type="text/javascript"> 
    
	var _FLUJO = "${respuesta.flujo}";
 	var estatus="${estatus}";


</script>
        <br>
                  
<form id="" method="POST" action="${pageContext.request.contextPath}/private/solicitudTramite.do" >

               <!-- Inicia Wrapper -->
        <div class="wrapper">
          <div class="Container">
            <div class="Layout__Full">

             <%--  <form action="solicitud_de_tramite.html"> --%>
                <div class="Section">
                  <div class="Aside__Col01">
                    <div class="Datos_Container">
                      <div class="Form__Group">
                        <label class="LabelText" for="usuario">CURP del Trabajador:</label>
                        <input class="Inputxxl" type="text" name="" value="${datos.datosCertificables.curp}">
                      </div>

                      <div class="Form__Group">
                        <label class="LabelText" for="usuario">Nombre del Trabajador:</label>
                        <input class="Inputxxl" type="text" name="" value="${datos.datosCertificables.nombre}" >
                      </div>

                      <div class="Form__Group">
                        <label class="LabelText" for="usuario">Apellido Paterno del Trabajador:</label>
                        <input class="Inputxxl" type="text" name="" value="${datos.datosCertificables.apellidoPaterno}" >
                      </div>

                      <div class="Form__Group">
                        <label class="LabelText" for="usuario">Fecha de Nacimiento:</label>
                        <input class="Inputxxl" type="text" name="" value="${datos.datosCertificables.fechaNacimiento}" >
                      </div>

                      <div class="Form__Group">
                        <label class="LabelText" for="usuario">Género:</label>
                        <input class="Inputxxl" type="text" name="" value="${datos.datosCertificables.genero}" >

                      </div>
                    </div>
                  </div>

                  <div class="Aside__Col02">
                    <div class="Datos_Container">
                      <div class="Form__Group">
                        <label class="LabelText" for="usuario">Entidad de Nacimiento:</label>
                        <input class="Inputxxl" type="text" name="" value="${datos.datosCertificables.entidadNacimiento}">
                       
                      </div>
                      <div class="Form__Group">
                          <label class="LabelText" for="tipoRetiro">Tipo de Retiro::</label> 
                        <select class="Select" id="tipoRetiro" name="tipoRetiro">
				              <option value="">Seleccione una opción</option>
				               <option value="">default</option>
				              <c:forEach items="${tipoRetiro}" var="retiro">
									<option value="${retiro.idParametro}"><c:out
									value="${retiro.idParametro} ${retiro.chValorParametro}"></c:out></option>
							    </c:forEach>
                        </select>
                      </div> 
                      
                      
                      <div class="Form__Group">
								<label class="LabelText" for="tipoSolicitante">Tipo Solicitante:</label>
								<input class="Inputxxl" type="text" name="" value="${solicitante}"/>
	
						</div> 
                  
                      <div class="Form__Group">
                        <label class="LabelText" for="usuario">Régimen:</label>
                         <select class="Select" id="tipoRegimen" name="tipoRegimen">
				              <option value="">Seleccione una opción</option>
				              <option value="">default</option>
				              <c:forEach items="${tipoRegimen}" var="regimen">
									<option value="${regimen.idParametro}"><c:out
									value="${regimen.idParametro} ${regimen.chValorParametro}"></c:out></option>
							    </c:forEach>
						</select>
                      </div>
                      
                    </div>
                  </div>
                </div>
                  <div class="ContainerButtons">
                    <input class="Submit" type="submit" value="Validar">
                    <input class="Submit" type="submit" value="Aceptar">
                  </div>
               <%--  </form> --%>
              </div>
            </div>
          <!-- finaliza titulo seccion -->
          <div class="push"></div>
        </div>
      <!-- Finaliza Wrapper -->
 </form>  
 
 
 
 <jsp:include page="../generales/footerAgente.jsp" /> 
 <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>

</body>
</html>
