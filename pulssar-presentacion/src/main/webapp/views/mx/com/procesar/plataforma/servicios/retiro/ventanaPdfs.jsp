<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Pdf retiro desemepleo</title>
    
     	
</head>
<body>
	<div class="Modal" id="modalPdf">
		<div class="ModalContainerpdf">
			<div class="ModalHeader">
				<h2 class="ModalTitle"></h2>
				<a href="#" class="ModalButton" id="botonCerrarModal">X</a>
			</div>
			<div class="Modal__Alertpdf ">
				<c:url value="${urlPdf}" var="urlPdfLocal"/>
                <iframe src="${urlPdfLocal}" width="90%" height="500px" name="framePdf" id="framePdf"></iframe>
                <iframe width="90%" height="500px" name="frameVistaPreviaPdf" id="frameVistaPreviaPdf"></iframe>
			</div>
			<div class="ModalFooter">
				<img id="imgAcuse" src="" />
				<canvas id='cnv' name='cnv' height='100' style='max-width: 400; display:none;' ></canvas>				
				
				<c:if test="${solicitaFirmas=='true'}">
                <form:form action="${urlPdfLocal}" method="post" id="frmPdf" target="framePdf">
                	<input type="hidden" id="idFirmaEmpleado" name="firmaEmpleado"/>
                	<input type="hidden" id="idFirmaAgente" name="firmaAgente"/>
					<div class="ContainerButtons">
						<button name="inputtext" type="submit" id="btnFirma" class="Submitx">Firmar</button><br/>
					</div>
                 </form:form>
                 </c:if>
	                 <c:url value="/private/adjuntarPdf.do" var="urlAdjuntarLocal"/>
	                 <form:form action="${urlAdjuntarLocal}" method="post" enctype="multipart/form-data" id="frmAdjuntar" target="iframeSubirArchivo">
                 	<div class="Form__Group">
                 		<div class="file-upload">
	                 		<div class="file-select">
	                 			<div class="file-select-button" id="fileName">Selecciona el tipo de archivo</div>
	                      		<div class="file-select-name" id="noFile">Archivo no seleccionado ...</div>
								<input type="file" name="archivo" id="chooseFile" accept=".pdf" data-not-null="0" data-nombre="Archivo">	                 			
                 			</div>                      		
                 		</div>
                 		<div id="mensajeErrorAdjuntar"></div>
                 	</div>
                 	<div class="ContainerButtons">                 	
                 		<input type="button" value="ADJUNTAR" class="Submitx" id="botonAdjuntar"/>
                 	</div>	
                 </form:form>
               	<div class="ContainerButtons" id="contenedorConfirmarAdjuntado">                 	
               		<input type="button" value="ACEPTAR" class="Submitx" id="botonConfirmarAdjuntar"/>
               		<input type="button" value="REGRESAR" class="Submitx" id="botonSelecArchivo"/>
               	</div>
                 <c:if test="${!empty urlPaginaSiguiente}">
	                 <c:url value="${urlPaginaSiguiente}" var="urlPaginaSiguienteLocal"/>	                
	                 <form:form action="${urlPaginaSiguienteLocal}" id="frmPaginaSiguiente" method="${metodoPaginaSiguiente}">
						<div class="ContainerButtons">
							<button type="submit" id="btnContinuar" class="Submitx">Continuar</button><br/>
						</div>	
	                 </form:form>
	             </c:if>							
			</div>
		</div>
	</div>	
    <iframe name="iframeSubirArchivo" id="iframeSubirArchivo" width="0px" height="0px" frameborder="0"></iframe>  
    <c:url value="/private/vistaPreviaPdfAdjuntadoImss.do" var="urlVistaPriviaPdfAdjuntadoLocal"/>
    <form:form action="${urlVistaPriviaPdfAdjuntadoLocal}" method="post" enctype="multipart/form-data" id="frmVistaPreviaPdf" target="frameVistaPreviaPdf">
    </form:form>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/manejoFirma.js'/>"></script>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/file_upload.js'/>"></script>    
    <script type="text/javascript">
	    $(document).ready(function() {	    	
	    	var indice=1;
	    	
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
				/*	    	
	    		$funciones_generales.validaciones($("#frmAdjuntar"));
				event.preventDefault();
				
				if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
					$("#frmAdjuntar").submit();
				}*/
				
				$("#mensajeErrorAdjuntar").empty();
				
				if($("#chooseFile").val().trim()==""){
					$("#mensajeErrorAdjuntar").append($funciones_generales.mensaje("La captura de  Archivo es requerida"));
					return;
				}
	    		
	    		$("#frmAdjuntar").submit();
	    	});

			/*
	    	$("#btnFirma").click(function(){
	    		console.log("dummy - ini");
	    		var objDummy = {
	    			isSigned: true,
	    			imageData: "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"
	    		};
	    		
	    		obtieneDatos(objDummy, 0, 0);
	    		console.log("dummy - fin");
	    	});
	    	*/
	    	
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
	    	
	    	 	     	
	      	$("#frmPaginaSiguiente").hide();
	      	$("#frmAdjuntar").hide();      		
	      	
	      	var etiquetaBoton1 = obtenerEtiquetaBoton();
	      	
	      	if(etiquetaBoton1.length>0){
	      		$("#btnFirma").html(etiquetaBoton1);
	      		
	      	}
	
			$("#frameVistaPreviaPdf, #contenedorConfirmarAdjuntado").hide();
			$("#botonConfirmarAdjuntar").click(function(){
				$("#contenedorConfirmarAdjuntado").hide();
				$("#frmPaginaSiguiente").show();
			});
			
			$("#botonSelecArchivo").click(function(){
				$("#contenedorConfirmarAdjuntado").hide();
				$("#frmAdjuntar").show();
			});
	    });
	    
     </script>
      
      
</body>
</html>