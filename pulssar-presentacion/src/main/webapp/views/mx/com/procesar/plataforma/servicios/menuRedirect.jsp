<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Home</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/index.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templatemo_style.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/flexslider.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/font-awesome.css'/>"></link>
	
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick-theme.min.css'/>" ></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick.css'/>" ></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carousel/slick_carousel.css'/>" ></link>
	
	<!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bob/bootstrap.min.css'/>" ></link>

    <!-- Bootstrap icons -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bob/bootstrap-icons.css'/>" ></link>
    
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bob/main.css'/>" ></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bob/stylo.css'/>" ></link>
	
	<link charset="utf-8" rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="utf-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/autocomplete/chosen.css'/>"></link>
	<script type="text/javascript" src="<c:url value='/webResources/js/autocomplete/jquery-1.12.4.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/plugins.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/main.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/menu_configuracion.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/general/menu_configuracionpaperless.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/ceroPapel.js'/>"></script>
	
</head>
<body>
	<jsp:include page="generales/headGeneral.jsp"></jsp:include>
	
	<div>
		<jsp:include page="generales/headGeneral.jsp"></jsp:include>
		<jsp:include page="generales/headerPrincipalBOB.jsp">
			<jsp:param name="encabezado" value="1" />
		</jsp:include>
		<script type="text/javascript" charset="UTF-8">
			var _FLUJO = "${respuesta.flujo}";
		</script>
		<script type="text/javascript">
			function ejecutaLogin(url, cvRolFederado){
				var $form = $('#fm_login');
						$form.attr('action', url);
						$("#clavePerfilFederado").val(cvRolFederado);
						$form.submit();
			};
		</script>
	
		<div style="display: none;">
			<form:form id="fm_login" name="formulario" method="post" modelAttribute="usuario">
				<input type="text" path="usComparador" name="user" value="${usComparador}" hidden="hidden" />
				<input type="text" path="pwComparador" name="pwd" value="${pwComparador}" hidden="hidden" />
				<input type="text" path="clavePerfilFederado" id="clavePerfilFederado" name="clavePerfilFederado" value="" hidden="hidden" />
			</form:form>
		</div>
 	</div> 
	
    <div class="wrapper" style="min-height: 54%;"> 
    	<seccion>
			<div class="Container">
				    			
				    <br />
				    <br />
				
				    <!--OPCIONES PORTALYCOMPARADOR-->
					
					<c:choose>
						<c:when test="${!empty menuOpciones}">
							<div id="modu" class="container-fluid">
								<div class="row">
									<c:set var="idSection" scope="session" value=""/>
									<c:forEach items="${menuOpciones}" var="opcion" varStatus="indice">
										<c:if test="${indice.index gt 0}">
											<c:set var="idSection" scope="session" value="2"/>
										</c:if>
										<div id="section${idSection}" class="col-md">
							                <img id="iconi_${opcion.descripcion}" src="/pulssar/webResources/img/${opcion.imagenMenu}" class="#" alt="..." style="width: 70px"/>
							                <h5>
							                    <i>
							                        ${opcion.descripcion}
							                    </i>
							                </h5>
							                <button id="botoni_${opcion.descripcion}" type="button" class="btn btn-primary btn-lg" onclick="ejecutaLogin( '${opcion.urlLogin}' , '${opcion.perfilFederados.clavePerfil}' );">ENTRAR</button>
							            </div>
									</c:forEach>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<c:out value="No tiene menu asignado al rol." />
						</c:otherwise>
					</c:choose>
					
				    <p id="center">Donde podrás realizar diversos trámites para el retiro de los trabajadores.</p>
		</div>
		</seccion>	
	</div>
	<jsp:include page="generales/footerPrincipal.jsp" />
</body>
</html>
