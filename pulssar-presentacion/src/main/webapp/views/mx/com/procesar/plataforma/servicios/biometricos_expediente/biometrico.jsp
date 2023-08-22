<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Expediente Biométrico</title>
	<meta charset="utf-8"></meta>
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" src="https://java.com/js/dtjava.js"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Expediente Biom&eacute;trico" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
	</jsp:include>
	<script type="text/javascript">
		var _DATOS = "${docAcuse}";
		var _DATOS_2 = "${docAcuseExcepcion}";
		var _VAR = '${cVar}';
		var _FLUJO = "${respuesta.flujo}";
		var _PAG = '${redirec}';
		var _FUN = '${flujoFun}';
		var _WEBSOCKET = '${socket}';
		var _WEBAFORE = '${pulssarUP.aforeUsuario}';
		var _EXCEP = '${banderaExcepcion}';
		var _WEBJNLP = '${jnlpAfore}';
	</script>
	
	<div class="wrapper">
		<section>
			<form:form id="fm_Biometrico" modelAttribute="expeBiom" action="aplicarExcepcion.do" method="POST">
				<div class="Title__Container">
					<h1>Conformación de Expediente Biométrico</h1>
				</div>
				<div class="Container">
					<div class="Layout__XL">
						<div class="Title" >
							<p id="tituloContenedor">${tituloContenedor}</p>
						</div>
						<div class="Datos_Container">
							<div class="row_container">
								<div class="Datosxxl"><strong id="mensajeDatos">${mensajeDatos}</strong></div>
							</div>
							<div class="row_container">
								<c:choose>
									<c:when test = "${empty docAcuse}">
											<label class="LabelText" for="excepcion">Seleccione una excepci&oacute;n: *</label>
											<form:select id="claveExcep" class="Select" name="claveExcep" path="claveExcep" data-not-null="0" data-nombre="Excepci&oacute;n">
											<option value="0">Seleccione una opci&oacute;n...</option>
											<option value="99">Con/Sin excepciones</option>
											</form:select>
										<div class="ContainerButtonsCenter">
											<input id="btnContinuar" class="Submitxl" type="button" value="INICIAR" />
										</div>
									</c:when>
									<c:otherwise>
										<div id="botonesPdf" class="ContainerButtonsCenter" alingn="center" style="text-align: center;">
											<input id="zoominbutton" class="Submit" type="button" value="Zoom +" />
											<input id="zoomoutbutton" class="Submit" type="button" value="Zoom -"/>
										</div>
										<div class="Container_Three" style="height: 750px;  width:100%;  overflow: auto;">
											<canvas id='the-canvas'></canvas>
											<canvas id='cnv' name='cnv' height='100' style='max-width: 400; display:none;' ></canvas>
										</div>
										<div class="ContainerButtonsCenter">
											<input id="btnTrabajador" class="Submitxl" type="button" value="FIRMA DEL TRABAJADOR" />
											<c:choose>
												<c:when test = "${not empty cambioJnlp && cambioJnlp == '1' && fn:contains('578,530', stiloOrg)}">
													<a class="Submitxl" id="btnCapHuellas" href="" onclick="ejecucionJavaLauncher();" style="display:none">INICIAR PROCESO</a>
												</c:when>
												<c:otherwise>
													<input id="btnCapHuellas"  class="Submitxl" type="submit" value="CAPTURA DE HUELLAS" style="display:none" />
												</c:otherwise>
											</c:choose>
											<c:if test="${banderaExcepcion == 'true'}">
												<input id="btnAgente" class="Submitxl" type="button" value="FIRMA DEL AGENTE" style="display:none" />
												<input id="btnFinaliza" class="Submitxl" type="submit" value="FINALIZA PROCESO" style="display:none" />
												<form:input type="hidden" id="idFirmaTrab" path="firmaTrab" />
											</c:if>
										</div>
										<form:input type="hidden" id="idBiometrico" path="biometricos" />
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/wsServicioTrabE.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/firinicializa.js'/>"></script>
	<script type="text/javascript">
	  var contextoSistema = "${pageContext.request.contextPath}";
	</script>
	<c:choose>
        <c:when test = "${stiloOrg == '568'}">
			<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dispositivos/568/padFirma.js'/>"></script>
			<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dispositivos/568/wsServicioCoppel.js'/>"></script>
        </c:when>
        <c:when test = "${stiloOrg == '530'}">
			<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dispositivos/530/tablet.js'/>"></script>
        </c:when>
        <c:otherwise>
			<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/firvalida.js'/>"></script>
			</c:otherwise>
    </c:choose>  
	
</body>
</html>
