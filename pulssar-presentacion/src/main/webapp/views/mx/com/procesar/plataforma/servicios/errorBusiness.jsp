<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link id="colors" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/main.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/afore/datos_generales.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/afore/datos_complementarios.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/afore/pestana.css'/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value='/webResources/css/afore/pestana_renapo.css'/>" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/afore/pestana_renapo.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/afore/tooltip.css'/>" />
  
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/jquery.dataTables.min.css'/>">
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/admin/styles_table.css'/>">
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana_despegable.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana_despegablecurp.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana_despegablerenapo.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
 
  <!-- plugin de validacion -->
  <script type="text/javascript" src="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.min.js'/>"></script>
	
  <script type="text/javascript" src="<c:url value='/webResources/js/jquery.validate.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/validator.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/datosCertificados.js'/>"></script>

  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick-theme.min.css'/>"/>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick.css'/>"/>


<title>Error inesperado</title>
</head>
<body>
	 <jsp:include page="generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Modificaci&oacute;n de Datos" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>

	<h4 style="color: red; text-align: center;">${mensaje}</h4>
	<jsp:include page="generales/footerAgente.jsp" />

</body>
</html>
