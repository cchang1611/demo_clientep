<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Menu</title>
	<meta charset="utf-8"></meta>
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
	<link href="https://necolas.github.io/normalize.css/8.0.1/normalize.css" rel="stylesheet">

	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>

	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/main.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carrousel_visor.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datos_generales.css'/>"></link>

	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/drag_and_drop.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/header.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/jquery.magnify.css'/>"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pdfExplorer/pdf.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/carrusel_visor.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.magnify.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/respuestaVisorDocumentos.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/file_upload.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/solicitud_parcial_upld_generico.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
		var _FUN = '${flujoFun}';
		var context = '${pageContext.request.contextPath}';
		var contextoSistema = "${pageContext.request.contextPath}";
		var INTENTOS = "2";
		var AFORE = "${pulssarUP.aforeUsuario}";
		var FOLIOHIJO = "${folio.folioHijo}";
		$(document).ready(function() {
			window.history.pushState(null, "", window.location.href);        
		    window.onpopstate = function() {
		        window.history.pushState(null, "", window.location.href);
		    };
		});
	</script>
</head>
<body onload="obtenerParametro(1)">
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<input type="hidden" id="mensaje" value="${mensaje}" />
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Ayuda de ${origen}" />
		<jsp:param name="menuPrimario" value="2" />
		<jsp:param name="menuSecundario" value="2" />
		<jsp:param name="menuInactivo" value="1" />
	</jsp:include>
	<div class="wrapper">
		<div class="Title__Container">
			<h1>Conformación de Expediente</h1>
		</div>
	<input type="hidden" id="foliohijo" value="${folio.folioHijo}" />

		<div class="Layout__L">
			<c:url value="${urlPdf}" var="urlPdfLocal"/>
			<div  id="divFrame" style="top: 10px;" >
				<div id="botones"></div> 
					<iframe class="toPrint" width="900" height="500" name="framePdf" id="framePdf" src="${urlPdfLocal}#toolbar=0"></iframe>
					<iframe width="900" height="500" name="frameVistaPreviaPdf" id="frameVistaPreviaPdf"></iframe>
			</div> 
		              
			<img id="imgAcuse" src="" />
			<canvas id='cnv' name='cnv' height='100' style='max-width: 400; display:none;'></canvas>
		
			<c:if test="${solicitaFirmas=='true'}">
				<form:form action="${urlPdfLocal}" method="post" id="frmPdf" target="framePdf">
					<input type="hidden" id="idFirmaEmpleado" name="firmaEmpleado" />
					<input type="hidden" id="idFirmaAgente" name="firmaAgente" />
					<div class="ContainerButtons">
						<button name="inputtext" type="button" id="btnFirma" class="Submitx">Firmar</button>
						<br />
					</div>
				</form:form>
			</c:if>
		
		
		
		<iframe name="iframeSubirArchivo" id="iframeSubirArchivo" width="0px" height="0px" frameborder="0"></iframe>
		<c:url value="/private/vistaPreviaPdfAdjuntadoIssste.do" var="urlVistaPriviaPdfAdjuntadoLocal"/>
		<form:form action="${urlVistaPriviaPdfAdjuntadoLocal}" method="post" enctype="multipart/form-data" id="frmVistaPreviaPdf" target="frameVistaPreviaPdf" />
   
		<c:choose>
		    <c:when test = "${afore == '568'}">
				<jsp:include page="digitalizacion.jsp">
					<jsp:param name="respuesta" value="${respuesta}"/>
					<jsp:param name="flujoFun" value="${flujoFun}"/>
					<jsp:param name="pageContext" value="${pageContext.request.contextPath}"/>
					<jsp:param name="datos" value="${datos}"/>
					<jsp:param name="folio" value="${folio}"/>
					<jsp:param name="tipoProceso" value="${tipoProceso}"/>
					<jsp:param name="nssProceso" value="${nssProceso}"/>
					<jsp:param name="curpProceso" value="${curpProceso}"/>
					<jsp:param name="tipoSolicitante" value="${tipoSolicitante}"/>
					<jsp:param name="folioHijo" value="${folioHijo}"/>
					<jsp:param name="agente" value="${agente}"/>
					<jsp:param name="cambioRfc" value="${cambioRfc}"/>
					<jsp:param name="urlSiguiente" value="${urlSiguiente}"/>
				</jsp:include>	
	    
				<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/manejoFirma2.js'/>"></script>
		    	<script id="jsFirma" src="<c:url value='/webResources/js/dispositivos/568/padFirma2.js'/>"></script>
		    	<script id="jsFirma" src="<c:url value='/webResources/js/dispositivos/568/digitalizacion2.js'/>"></script>
			</c:when>
			<c:otherwise>
				<c:set var="imagenesDoc" value="${imagenes}" scope="request"/>
				<jsp:include page="../generales/visorDocumentos.jsp"/>		
				<jsp:include page="acordeon.jsp"></jsp:include>
				
				<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/accordion.js'/>"></script>
				<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/manejoFirma.js'/>"></script>
				
				<script type="text/javascript">
					 $(document).ready(function() {
						<c:if test="${contieneFirmaEmpleado=='true'}">
							agregarEtiquetaBoton("Firma Trabajador");
							agregarIdFirma(FIRMA_TRABAJADOR);
						</c:if>
		  
						<c:if test="${contieneFirmaAgente=='true'}">
							agregarEtiquetaBoton("Firma Agente");
							agregarIdFirma(FIRMA_ASESOR);
						</c:if>   		
		    	
				    	$("#btnFirma").click(function(){
				    		console.log("btnFirma click - ini ");
			 			    SignInicio();
				    		console.log("btnFirma click - fin ");    		
				    	});
		    	
				    	$("#botonCerrarModal").click(function(){
				    		cerrarModalPdf();    		
				    	});
		    	
				    	$("#btnContinuar").click(function(){
				    		cerrarModalPdf();    		
				    	});
		    	
				    	$("#botonAdjuntar").click(function(){
							firma();
				    	});
		    	
						function firma(){
						  	$("#iframeSubirArchivo").load(function(){
						  		var iframe = $("#iframeSubirArchivo");
						  		var codigoRespuesta = $("#codigoRespuesta", iframe.contents()).text();
						  		var mensaje = $("#mensajeRespuesta", iframe.contents()).text();
						  		console.log("resultado de adjuntar - codigo: "+codigoRespuesta+", mensaje: "+mensaje);
						  		
						  		$("#mensajeErrorAdjuntar").empty();
						  		
						  		if(codigoRespuesta==1){
						  			console.log("se muestran los botones aceptar y regresar");
						  			$("#framePdf").hide();
						  			$("#frmAdjuntar").hide();
						  			$("#contenedorConfirmarAdjuntado").show();
						  			$("#frameVistaPreviaPdf").show();
						  			$("#frmVistaPreviaPdf").submit();
						  		}else{
						  		console.log("se muestra mensaje de error");
						  			$("#mensajeErrorAdjuntar").append($funciones_generales.mensaje(mensaje));
						  		}
						  	});
						}
		    	
						$("#frmPaginaSiguiente").hide();
				      	$("#frmAdjuntar").hide();      		
		      	
				      	var etiquetaBoton1 = obtenerEtiquetaBoton();
				      	
				      	if(etiquetaBoton1.length>0){
				      		$("#btnFirma").html(etiquetaBoton1);
				      		
				      	}
		
						$("#frameVistaPreviaPdf, #contenedorConfirmarAdjuntado").hide();
						$("#botonConfirmarAdjuntar").click(function(){
							$("#contenedorConfirmarAdjuntado").hide();
							$("#btnContinuar").show();
						});
				
						$("#botonSelecArchivo").click(function(){
							$("#contenedorConfirmarAdjuntado").hide();
							$("#frmAdjuntar").show();
						});
		    	
				    	$("#btnContinuar").click(function(){
				    		$("#retiroDesempleoIssste").submit();
				    	});
		    	 	     	
				      	$("#btnContinuar").hide();
				      	$("#frmAdjuntar").hide(); 
				      	$("#carruselDocumentosModal").hide();
		      	
					});
				</script>
			</c:otherwise>
		</c:choose>
    </div>
		<jsp:include page="../generales/footerAgente.jsp" />
		<jsp:include page="../generales/modals.jsp" />
		
	</div>
</body>
</html>