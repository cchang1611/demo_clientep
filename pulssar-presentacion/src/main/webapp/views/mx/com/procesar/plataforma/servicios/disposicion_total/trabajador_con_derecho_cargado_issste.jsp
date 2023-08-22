<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
FolioEntrada folio = datos.getFolio();
%>
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
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/header.css'/>"></link>
	<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/main_ie_acce_sar.css'/>"></link> --%>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/footer.css'/>"></link>
	<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/ionicons.min.css'/>"></link> --%>
 

<!--   <link href="https://necolas.github.io/normalize.css/8.0.1/normalize.css" rel="stylesheet"> -->
	
	
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/bootstrap.min.js'/>"></script>	
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/bootstrap.js'/>"></script>								
					
				<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/accordion.js'/>"></script>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/accordion.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>

<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="DISPOCISI&oacute;N TOTAL ISSSTE" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	<script type="text/javascript"> 
    
	var _FLUJO = "${respuesta.flujo}";
 	var estatus="${estatus}";


</script>
<br />
<form id="solicitudTramite" method="POST" action="${pageContext.request.contextPath}/private/solicitudTramite.do">
<input type="hidden" value="${botoncertdisabled}" name="botonAceptar" id="botonAceptar"/> 
          <!-- Inicia Wrapper -->
        <div class="wrapper">
          <div class="Container">
            <div class="Layout__Full">

             <%--  <form action="solicitud_de_tramite.html"> --%>
                <div class="Section">
                  <div class="Aside__Col01">
                    <div class="Datos_Container" >
                       <div class="Form__Group">
                             <label class="LabelTextEdit" for="tipoDisposicion">Tipo de Recursos Disponer:</label> 
                         <select class="Select" id="tipoDisposicion" name="tipoDisposicion" disabled="disabled" onchange="validarCampos()">
				              <option value="">Seleccione una opción</option>
				              <c:forEach items="${tipoDisposicion}" var="disposicion">
									 <option value="${disposicion.idDerecho}"> 
									 <c:out value="${disposicion.descripcionDerecho}"></c:out>
									 </option> 
							    </c:forEach>
                        </select> 
                      </div> 
                    
                      <div class="Form__Group">
                         <label class="LabelTextEdit" for="tipoRetiro">Tipo de Retiro:</label> 
                        <select class="Select" id="tipoRetiro" name="tipoRetiro" disabled="disabled">
				              <option value="">Seleccione una opción</option>
				              <c:forEach items="${tipoRetiro}" var="retiro">
									<option value="${retiro.cvParametro}"><c:out
									value="${retiro.chValorParametro}"></c:out></option>
							    </c:forEach>
                        </select>
                      </div>
                     
                      <div class="Form__Group">
                        <label class="LabelTextEdit" for="nprivadoPension">Número Plan Privado Pensión:</label>
                        <input class="Inputxxl" type="text" name="" value=""  disabled="disabled">

                      </div>
                    </div>
                  </div>

<!-- sSegunda Seccion -->
                  <div class="Aside__Col02">
                    <div class="Datos_Container" >
                      <div class="Form__Group">
                        <label class="LabelTextEdit" for="curp" disabled="disabled"><strong>CURP:</strong> ${datos.datosCertificables.curp}</label>
                      </div>
                      <div class="Form__Group">
                          <label class="LabelTextEdit" for="nrp">NRP:</label>
                          <input class="Inputxxl" type="text" name="" value="" placeholder="NRP" disabled="disabled"/>
                      </div> 
                      
                      
                      <div class="Form__Group">
								<label class="LabelTextEdit" for="rfc" disabled="disabled"><strong>RFC:</strong>${datos.datosNoCertificables.rfc}</label>
	
					 </div> 
                      
                    </div>
                  </div>
                </div>
       
         <div class="ContainerButtonsCenter">
					<c:if test="${botoncertdisabled == true}">	
		 	            <input class="Submit" type="button" id="btnAceptarDispoTotal" value="Aceptar"/>
					</c:if>	
					<c:if test="${botoncertdisabled == false}">
						<input class="Submit" type="button" id="btnSolicitarCusDispoTotal" value="Generar CUS"/>
		 	            <input class="Submit_disabled" type="button" id="btnAceptarDispoTotal" value="Aceptar" disabled="disabled"/>
		             </c:if>
		             
		 </div> 
		 <input type="hidden" name="tipoDisposicion" id="tipoDisposicion" value="${tipoDisposicionList}"/>
		 <input type="hidden" name="fechaInicio" id="fechaInicio" value="${fechaInicio}"/>
		 <input type="hidden" name="fechaEmision" id="fechaEmision" value="${fechaEmision}"/>
		 <%-- <input type="hidden" name="fechaResolucion" id="fechaResolucion" value="${fechaResolucion}"/> --%>
		 <input type="hidden" name="semanasCotizada" id="semanasCotizada" value="${semanasCotizada}"/>
		 
		 
    </div>
      <div class="push"></div>
    </div>
   </div> 
  <!-- Finaliza Wrapper -->

    </form> 
 
 
   <script type="text/javascript">
  	var urlModificarDatos = '<c:url value="/private/modificaTrabajador.do"/>';
  </script>
<input type="hidden" id="direccionamiento" name="direccionamiento" value="${direccionamiento}" />
<jsp:include page="../generales/footerAgente.jsp" />
<jsp:include page="../generales/modals.jsp" />
 
 <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
 <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/generar_cus_dispoTotal.js'/>"></script> 
</body>
</html>
