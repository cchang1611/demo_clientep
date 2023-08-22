<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Impresión</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datos_generales.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tooltip.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/carrousel_visor.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/reimpresion_documentos/conversionPDF.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/reimpresion_documentos/pdf.worker.js'/>"></script>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/reimpresion_documentos/pdf.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/reimpresion_documentos/reimpresion_documentos.js'/>"></script>
</head>
<body>

<meta http-equiv="Access-Control-Allow-Origin" content="*">
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Reimpresi&oacute;n de documentos" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	
	<div class="wrapper_reimpresion">
		<section>
			<div class="Title__Container">
				<h3>${modulo}</h1>
			</div>
			
			<div class="Container" id="salida">
	             <c:choose> 
	                 
	                 <c:when test="${archivos.errorArchivo==false}">              
	                       <div  id="divFrame" >
	                            	<div id="botones"></div> 
	                       </div>            
	              	       <script >creacionIframe('${archivos.byteArchivo}');</script>             	       
	              	 </c:when>	
	              	 <c:otherwise>
	              	      <div style="height:500px;width:700px;background-color:gray;margin-bottom: 80px;" > </div>
	              	 </c:otherwise>              	
				  </c:choose>
				 
			</div>
			 <c:if test="${archivos.errorArchivo==false}">	
			 	 <c:if test="${esSaldosYmovimientos==false}">
			 	 	<div class="botonesReimpresionClass" style="position: relative;top: -40px;margin-bottom: 60px;">	
	    	           <div class="botonesReimpresionCorreoClass">
	    	  	           <form class="ModalFooter">
					  			<input id="btnExitoCambio" onclick="obtieneEmailImpresion('${idModulo}');" class="Submit" style="text-align: center;" value="Enviar"/>
							</form>
	    	  	     
	    	           </div> 
	    		       <div class="botonesReimpresionImpresionClass"  >
				             <form class="ModalFooter">
					  			<input id="btnExitoCambio" onclick="crearImpresion('${idModulo}');" class="Submit" style="text-align: center;" value="Imprimir"/>
							</form>
	    		       </div>
			         </div>
			 	 </c:if>
			 	 <c:if test="${esSaldosYmovimientos==true}">
			 	 	<div class="botonesReimpresionClass" style="position: relative;top: -40px;margin-bottom: 60px;">	
	    	            <div class="botonesReimpresionCorreoClass">
	    	  	          <form class="ModalFooter">
					  			<input id="btnExitoCambio" onclick="obtieneEmailSaldosYMovimientos('${idModulo}');" class="Submit" style="text-align:center;" value="Enviar"/>
						 </form>
	    	           </div> 
	    		       <div class="botonesReimpresionImpresionClass" >
	    		           <form class="ModalFooter">
					  			<input id="btnExitoCambio" onclick="crearImpresionSaldosYMovimientos('${idModulo}');" class="Submit" style="text-align:center;" value="Imprimir"/>
						   </form>
	    		       </div>
			         </div>
			 	 </c:if>
	    	 	
	        </c:if>
			
		</div>
			<input id="errorArchivo" type="text" style="display:none;" value="${archivos.errorArchivo}"></input>
			<input id="mensajeArchivo" type="text" style="display:none;" value="${archivos.mensajeError}"></input>
			<input id="claveError" type="text" style="display:none;" value="${archivos.claveError}"></input>
			<jsp:include page="../menus/menuConsulta.jsp" />
		</section>
		<div class="push"></div>
	</div>
	
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<script src="<c:url value='/webResources/js/cargaRefBen.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	
	<jsp:include page="../generales/modals.jsp" />

</body>
</html>
