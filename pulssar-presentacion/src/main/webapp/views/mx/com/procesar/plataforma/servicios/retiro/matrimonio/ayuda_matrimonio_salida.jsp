<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.CalculoTipoRetiro" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <title>Menu</title>
	<meta charset="utf-8" />
	<![if IE]>
			<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='../webResources/css/general/main_ie.css'/>" />
	  <![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/modal_window.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='../webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
</head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
FolioEntrada folio = datos.getFolio();
CalculoTipoRetiro calculoTipoRetiro = (CalculoTipoRetiro) session.getAttribute("calculoTipoRetiro");
%>
<body>
	<input type="hidden" id="mensaje" value = "${mensaje}"/>
	<jsp:include page="../../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Ayuda por Matrimonio" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "2" />
	</jsp:include>

   <div class="wrapper">
  <div class="Container">
    <div class="Container">
	<div class="Layout__M">
	
      <!-- Inicia Wrapper -->
        <div class="wrapper">
          <div class="Title__Container">
            <h1>Ayuda por Matrimonio</h1>
          </div>

          <div class="Container">
			   <div class="Layout__M">
			      <div class="Line">
			         <p></p>
			      </div>
			      <div class="Datos_Container">
			         <div class="DatosBack"><strong>NSS: </strong> ${datos.nss}</div>
			         <div class="DatosBack"><strong>CURP: </strong>  ${datos.datosCertificables.curp}</div>
			         <div class="DatosBack"><strong>NOMBRE TRABAJADOR: </strong> ${datos.datosCertificables.nombre}</div>
			         <div class="DatosBack"><strong>APELLIDO PATERNO: </strong> ${datos.datosCertificables.apellidoPaterno}</div>
			         <div class="DatosBack"><strong>APELLIDO MATERNO: </strong> ${datos.datosCertificables.apellidoMaterno}</div>
			         <div class="DatosBack"><strong>MONTO DISPOSICION: </strong> ${calculoTipoRetiro.montoADisponerA}</div>
			      </div>
			      <div class="ContainerButtons">
			         <button class="Submitx" id="formaPagoModal" style="margin: 20px">Forma Pago</button>
			         <button class="Submitx_disabled" id="btnSolicitar" disabled style="margin: 20px">Continuar</button>
			      </div>
			   </div>
			</div>
		<div class="push"></div>
        </div>
      <!-- Finaliza Wrapper -->
	
    </div>
	</div>
  </div>
  
	<form:form class="ModalFooter" modelAttribute="parametrosRetiroParcialCalculoImss" method="post" id="tipoRetiro" action="${pageContext.request.contextPath}/private/tipoRetiroMatrimonio.do">
		<input type="hidden" id="formaPago" name="formaPago" />
		<input type="hidden" id="claveBanco" name="claveBanco" />
		<input type="hidden" id="cuentaClabe" name="cuentaClabe" />
	</form:form>
  
	<form:form class="ModalFooter" method="post" id="guardarCalculo" action="${pageContext.request.contextPath}/private/guardarCalculo.do" modelAttribute="parametrosRetiroParcialCalculoImss">

	</form:form>
	
  <jsp:include page="modalTipoRetiroMatrimonio.jsp" />
  
  
<div class="push"></div>
	</div>
	<jsp:include page="../../generales/footerAgente.jsp" />
	<jsp:include page="../../generales/modals.jsp" />

<script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/blockui/jquery.blockUI.js'/>"></script>
<script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/funcionesGenerales.js'/>"></script>
<script type="text/javascript">
var parametroForm;
var context;
$(document).ready(function() {
	console.log("1");
	jsonInstiticionesBancarias = '${jsonInstitucionBancaria}';	
	parametroForm = "#folioMatrimonio";
	context = '${pageContext.request.contextPath}';	
});
</script>	

<script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/clabe.min.js'/>"></script>
<script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/ayuda_matrimonio_salida.js'/>"></script>
<script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/modaltiporetiromatrimonio.js'/>"></script>
<script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/table_retiros_matrimonio.js'/>"></script>

		

	

</body>
</html>
