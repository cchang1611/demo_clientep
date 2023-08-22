<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Carga de usuarios</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>

	<link charset="UTF-8" rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="UTF-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	 <style type="text/css">
 .Button__FileError {
    width: 40px;
    height: 40px;
    background: #ab2727;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 4px;
    font-size: 20px;
    color: white;
    cursor: pointer;
    margin-top: 0px;
    margin-left: 10px;
    margin-right: 10px;
    margin-bottom: 10px;
}
 </style>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="3" />
			<jsp:param name="menuTitle" value="Carga del archivo de alta de usuarios" />
<%-- 			<jsp:param name="menuPrimario" value = "2" /> --%>
			<jsp:param name="menuSecundario" value = "2" />
			<jsp:param name="menuActivo" value = "1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
			console.log(_FLUJO);
			console.log("${respuesta.titulo}");
			console.log("${respuesta.mensaje}");
		</script>
		
		<div class="push"></div>
		
		<section>
			<form action="cargaExcelUsuarios.do" id="formUploadAjax" method="post"
					enctype="multipart/form-data">
				<div class="Container">
					<div class="Layout__XL">
						<div class="Datos_Container">
	<!-- 						<div class="Line"></div> -->
						  <div class="Datos_Containerflex">
			                  <div class="ContainerButtonsCenter" style="width: 70%;">
			                    <div class="file-upload" style="width: 65%;">
			                      <div class="file-select">
			                        <div class="file-select-button" id="fileName">Buscar</div>
			                        <div class="file-select-name" id="noFile">Archivo no seleccionado...</div>
			                        <input type="file" name="chooseFile" id="chooseFile">
			                      </div>
			                   </div>
			                    <div class="ContainerButtonsCenter">
			                      <input type="button" class="Button__FileError" id="borrar" value=X>
			                      <input id="idArchivo" class="Submit" type="submit" value="Cargar Archivo" style="width: 175px;">
			                      <a href="cargaUsuarios.do" class="Submitx" style="margin-top: 0px;">Regresar</a>
			                    </div>
			                  </div>
			              </div>
			              
			              
			              
						</div>
					</div>
				</div>
			</form>
		</section>
		<div class="push"></div>
		
		<div id="errorModalUsuarios" class="Modal">
			<div class="ModalContainer">
				<div id="errorModalHeader" class="ModalHeader">
				<h2 class="ModalTitle" id="tituloError" style="font-size: 25px;">${respuesta.titulo}</h2>
				<a href="#" class="ModalButton" id="btnErrorM">X</a>
				</div>
				<div class="Modal__IconAlert">
					<img class="IconAlert" src="<c:url value='/webResources/img/warning.png'/>" alt="icon_alert" />
				</div>
				<div id="mensajeErrorModal" class="Modal__AlertText">
					<p style="margin-bottom: 10px;font-size: 19px;text-align: justify;">${respuesta.mensaje}</p>
					
					<c:if test="${not empty respuesta.lstObRespuesta}">
					
					<textarea class="textAreaStyle" rows="10" cols="60" style="font-size: 14px;margin-bottom: 10px;"><c:forEach items="${respuesta.lstObRespuesta}" var="mnsErrores"><c:out value="${mnsErrores}" /></c:forEach>
					</textarea>
					<p style="margin-bottom: 10px;font-size: 13px;">Favor de ingresar un nuevo archivo que cumpla con todos los criterios.</p>
					
					</c:if>
					
				</div>
			</div>
		</div>
		
	</div>
	<jsp:include page="../generales/footerAdmin.jsp" />
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/cargaMasivaUsuarios.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/file_upload.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>