<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Descarga de usuarios</title>
	<meta charset="utf-8" />
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
		
	
	<script charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>

 <script type="text/javascript" src="<c:url value='/webResources/js/datepiker.js'/>"></script>
 <script type="text/javascript" src="<c:url value='/webResources/js/datepiker2.js'/>"></script>
 
 
</head>
<body>
<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="3" />
			<jsp:param name="menuTitle" value="Descarga archivo de respuesta" />
			<jsp:param name="menuSecundario" value = "2" />
			<jsp:param name="menuActivo" value = "1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
			console.log(_FLUJO);
			console.log("${respuesta.titulo}");
			console.log("${respuesta.mensaje}");
			
		</script>
		

 <!-- inicia seccion baja de usuario -->
    <form action="obtenerArchivoUser.do" id="fm_descargaTramites" method="post" >
      <div class="Container">
        <div class="Layout__M">
          <div class="Title">Fecha de Carga</div>
            <div class="Datos_Container">
              <div class="Form__Group">
				<input class="Inputxxl" type="text" value="" id="datepicker" name="" placeholder="INGRESA LA FECHA" data-nombre="fecha inicio" data-not-null-fecha="0" min="2020-01-01" max="2020-01-01" readonly="readonly" style="width: 25%;">                
              </div>
            </div>
          
            <div class="ContainerButtonsCenter">
	            <input class="Submitx" type="submit" value="Consultar" id="idButtonConsultar">
	            <a href="cargaUsuarios.do" class="Submitx">Regresar</a>
            </div>
            <br>
          </div>
    	</div>
    	<input id="fechaBusqueda" name="fechaBusqueda" path="fechaBusqueda" type="hidden"/> 
	</form>



		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAdmin.jsp" />
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/descargaMasivaUsuarios.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/file_upload.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>