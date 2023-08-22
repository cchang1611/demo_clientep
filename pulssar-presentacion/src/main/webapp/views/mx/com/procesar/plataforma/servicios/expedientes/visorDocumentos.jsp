<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page
	import="mx.com.procesar.aplicaciones.traspasos.pulssar.presentacion.modelo.Imagen"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Visor de Imágenes de Expedientes</title>
  <meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  
  <!-- Estilos carrusel -->
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
  <link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/loader.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/consultarExpedientes/templates.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carrousel_visor.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/consultarExpedientes/loader.css'/>"></link>
 
  <!--Librerias jquery  -->
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  
  <!-- Librerias visor documentos -->
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/consultarExpedientes/pdf.worker.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/consultarExpedientes/pdf.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/consultarExpedientes/consultarExpedientes.js'/>"></script>
  
  
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/consultarExpedientes/movimientoMouse.js'/>"></script>
  <link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
   <!-- Zoom Visor  -->
  <link  rel="stylesheet" href="<c:url value='/webResources/css/general/jquery.magnify.css'/>"></link>
  <script type="text/javascript" src="<c:url value='/webResources/js/jquery.js'/>"></script>
  
  <link rel="stylesheet" charset="utf-8" type="text/css" href="<f:url value='/webResources/css/general/modal_window.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<f:url value='/webResources/css/general/loader.css'/>"></link>
  
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<!-- Paso conversión pdf -->
    <jsp:include page="pasoConversionPdf.jsp"/>
    <jsp:include page="pasoConversionPdf2.jsp"/>
    	<!-- Div loading-spinner para presentar la pantalla de loader0 -->
	<div id="overlay">
		<div class="cv-spinner">
			<span class="spinner"></span>
		</div>
	</div>
	<div class="wrapper" style="min-height: 88%;">
		<input type="hidden" id="mensajeError" value="${error}" />
		<jsp:include page="../generales/headerAgente.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle" value="Visor de Im&aacute;genes de Expedientes" />
			<jsp:param name="menuPrimario" value="2" />
			<jsp:param name="menuSecundario" value="2" />
			<jsp:param name="menuInactivo" value="1" />
		</jsp:include>

        <div class="Title">
          <p>Visor de Imágenes de Expedientes</p>
       
		</div>
	  <div class="Container_Flex"  style="height: 750px;padding-top: 10px;">
		<div class="Asidev01">
		  <div class="Title">Imágenes del trabajador</div>
			<div class="wrapper">
			<c:if test="${activaCarruselUno==true}">
				<div class="Container">
					<div class="Layout__L">
						<div class="Datos_Container">
							<h3 style="display: flex;justify-content: center;align-items: center;">${nombreExpediente}</h3>
							<div class="Container_Carousel">				
								<div class="slideshow-container" id="imagenesCarrusel">	
								    <script>
								        creaImagenesCarrusel('${listaImagenesExpedienteServicio}');
								     </script>
									<a class="prev" onclick="plusSlides(-1)">&#10094;</a> 
									<a	class="next" onclick="plusSlides(1)">&#10095;</a>
								</div>
							</div>
						
						</div>
					</div>
				</div>
			 </c:if>
			 <c:if test="${activaCarruselDos==true}">
				<div class="Container">
					<div class="Layout__L">
						<div class="Datos_Container">
						 <h3 id="carruselDosNombreExpediente" style="display: flex;justify-content: center;align-items: center;"></h3>
							<div class="Container_Carousel02">
								<div class="slideshow-container02" id="imagenesCarrusel2">	
								    <script>
								        creaImagenesSegundoCarrusel();
								     </script>
							
								</div>
							</div>
						
						</div>
					</div>
				</div>
			  </c:if>
			<c:if test="${activaCarruselUno==true}">
			<h3 style="display: flex;justify-content: center;align-items: center;">Botón izquiero recuadro de arriba </h3>
			<h3 style="display: flex;justify-content: center;align-items: center;">Botón derecho recuadro de abajo </h3>
			 </c:if>
	      <div class="Datos_ContainerVisorExpeMovil">
          <div class="ContainerButtonsCenter">
          	<input class="Submitx" type="button" value="Regresar" onclick="regresarPantalla('${banderaClaveRol}');"/>
          </div>
        </div>
			 
			  
			</div> 
			<div class="push"></div>
		
		</div>	
		
		 <div id="asive02" class="Asidev02" style="height:100%;">		  		    
	        		<video controls id="idVideo" style="height: 250px;cursor: pointer;justify-content: center;align-items: center;overflow: hidden;margin-top: 40px;display: none;"> </video>
					 <a id="imgExpand" class="Container__AsidevImg" data-magnify="gallery"  data-caption="Archivo" data-mdl="1" data-group="a" href="">
		          		<img id="imgGran" src="" alt="img_visor" class="img_asidevimg"/>
		        	 </a>
		        
		      	  
					<video controls id="idVideo2" style="height: 250px;cursor: pointer;display: flex;justify-content: center;align-items: center;overflow: hidden;margin-top: 40px;"> </video>  
					<a id="imgExpandTwo" class="Container__AsidevImg" ondrop="drop(event)" ondragover="allowDrop(event)" data-magnify="gallery" data-caption="Archivo" data-mdl="2" data-group="a" href="<c:url value='/webResources/img/ine_reverso.jpg'/>">
		         		 <img id="imgGranTwo" src="" class="img_asidevimg"/>
		        	</a>           		        	      	  		
        </div>
          <div class="Asidev03">
        	<div class="Title">Documentos de Identidad</div>
       			 <div class="Container_Tabs2">
       			 	
       			 	  <div id="Uno" class="tabcontentdos">
       			 	  	 <table width="100%" cellspacing="0" cellpadding="0" id="tablaExpedientes">
       			 	  	  	<tbody>
       			 	  	  		 <c:forEach items="${listaExpedientes}" var="expedientes">
       			 	  	  		  	<tr>
       			 	  	  		  	     <td style="cursor: pointer;width: 0px;"  colspan="2"> <img style="width: 25%;"  src="../webResources/img/signo_mas.jpg" alt="icon_alert" /></td>
                 						 <td colspan="2"> ${expedientes.descripcionExpediente}</td>
                 						 <td style="display: none;" colspan="2"> ${expedientes.cvTipoProceso}</td>
                 						 <td style="display: none;" colspan="2"> ${expedientes.chFechaOperacion}</td>
                 						 <td style="display: none;" colspan="2"> ${afore}</td>
                 						 <td style="display: none;" colspan="2"> ${curp}</td>
                 						 <td style="display: none;" colspan="2"> ${tipoServicio}</td>
                					</tr>
       			 	  	  		 </c:forEach>      	
       			 	  	  	</tbody>
       			 	  	 </table>
       			 	  </div>   			 	
       		     </div>
       	</div>   
      </div>
	</div>
	<c:if test="${banderaError==true}">
	  <div id="exitoModalAceptar" class="Modal" style="opacity: 1;pointer-events:visible;display: block">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 id="tituloExitoAceptar" class="ModalTitle">${respuesta.titulo}</h2>
					<c:if test="${mensajeCaptura==true}">			
					  <a style="cursor: pointer;" onclick="cerrarModalCaptura();" class="ModalButton" id="btnExitoM">X</a>
					</c:if>
					<c:if test="${mensajeCaptura==false}">
					  <a style="cursor: pointer;" onclick="cerrarModal();" class="ModalButton" id="btnExitoM">X</a>
					</c:if>
					
				</div>
				<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="../webResources/img/error.png" alt="icon_alert" />
				</div>
				<div id="mensajeExitoAceptar" class="Modal__AlertText">
					${respuesta.mensaje}
				</div>
				<div>
					<form class="ModalFooter">
					<c:if test="${mensajeCaptura==true}">
					  <input class="Submit" type="button" onclick="cerrarModalCaptura();" value="Aceptar"/>
					</c:if>
					<c:if test="${mensajeCaptura==false}">
					  <input class="Submit" type="button" onclick="cerrarModal();" value="Aceptar"/>
					</c:if>
					</form>
				</div>
			</div>
		</div>
	</c:if>
	 <div id="exitoModalAceptarVisor" class="Modal" >
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 id="tituloExitoAceptarVisor" class="ModalTitle"></h2>
					<a style="cursor: pointer;" onclick="ocultarDiv();" class="ModalButton" id="btnExitoM">X</a>
				</div>
				<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="../webResources/img/error.png" alt="icon_alert" />
				</div>
				<div id="mensajeExitoAceptarVisor" class="Modal__AlertText">
					
				</div>
				<div>
					<form class="ModalFooter">
					  <input class="Submit" type="button" onclick="ocultarDiv();" value="Aceptar"/>
					</form>
				</div>
			</div>
		</div>
	<script>
		function cerrarModal(){
								    			       
					$('#exitoModalAceptar').css("opacity", "0");
					$('#exitoModalAceptar').css("pointer-events", "none");
		}
		function cerrarModalCaptura(){
								    			       
					$('#exitoModalAceptar').css("opacity", "0");
					$('#exitoModalAceptar').css("pointer-events", "none");
					window.location.href="../private/expedienteIdentificacionMovil.do";
		}
		function regresarPantalla(banderaRol){
				if(banderaRol=='true'){
				   window.location.href="../operativoProcesar/subMenuConsultaExpediente.do";
				}else{
				   window.location.href="../private/expedienteIdentificacionMovil.do";
				}				    			     
					
		}
	</script>
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
		
	 <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/consultarExpedientes/accordion.js'/>"></script>
      
     <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/consultarExpedientes/visorImagenes.js'/>"></script>
	<!-- Librerias carrusel  -->
	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/slick.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/slick_carousel_administrador.js'/>"></script>
	 <!-- jQuery CDN -->
        <script src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
        <script src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
      <!-- slick Carousel CDN -->
        <script  src="<c:url value='/webResources/js/slick.min.js'/>"></script>
        <script  src="<c:url value='/webResources/js/consultarExpedientes/index.js'/>"></script>
	<!-- Zoom Images -->
        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
        <script src="<c:url value='/webResources/js/jquery.magnify.js'/>"></script>
	
</body>
</html>