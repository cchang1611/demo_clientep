<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>


    <iframe name="iframeSubirArchivo" id="iframeSubirArchivo" width="0px" height="0px" frameborder="0"></iframe>
    <c:url value="/private/vistaPreviaPdfAdjuntadoIssste.do" var="urlVistaPriviaPdfAdjuntadoLocal"/>
    <form:form action="${urlVistaPriviaPdfAdjuntadoLocal}" method="post" enctype="multipart/form-data" id="frmVistaPreviaPdf" target="frameVistaPreviaPdf">
    </form:form>  
    
    
    
    
<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/manejoFirma568.js'/>"></script>
			
			<script type="text/javascript">
			    $(document).ready(function() {
			    signValue = 0;
			    	<c:if test="${contieneFirmaEmpleado=='true'}">
			    		agregarEtiquetaBoton("Firma Trabajador");
			    		agregarIdFirma(FIRMA_TRABAJADOR);
			    		signValue = 1;
		      		</c:if>
			  
			 		<c:if test="${contieneFirmaAgente=='true'}">
			 			agregarEtiquetaBoton("Firma Agente");
			 			agregarIdFirma(FIRMA_ASESOR);
			 			signValue = 2;
		      		</c:if>   		
			    	
			    	$("#btnFirma").click(function(){
			    		console.log("btnFirma click - ini ");
			    		SignInicio(signValue);
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