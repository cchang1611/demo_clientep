<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" />
<html>
<head>
	<title>Bienvenidos</title>
	<meta charset="utf-8"></meta>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"></meta>
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" ></link>
	<![endif]>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/index.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templatemo_style.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/flexslider.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/font-awesome.css'/>"></link>
	<link rel="shortcut icon" charset="utf-8" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="utf-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
		
	<script type="text/javascript" src="<c:url value='/webResources/js/autocomplete/jquery-1.12.4.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/plugins.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/main.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/autocomplete/chosen.css'/>">
	
	<script type="text/javascript">
		$(document).ready(function() {
			window.history.pushState(null, "", window.location.href);        
		    window.onpopstate = function() {
		        window.history.pushState(null, "", window.location.href);
		    };
		});
	</script>

</head>
<body>
	<div class="wrapper">
		<jsp:include page="generales/headGeneral.jsp"></jsp:include>
		<jsp:include page="generales/headerPrincipal.jsp">
			<jsp:param name="encabezado" value="1" />
		</jsp:include>
		<script type="text/javascript" charset="UTF-8">
			var _FLUJO = "${respuesta.flujo}";
			var _IP = "${ipEjemplo}";
			console.log(_IP);
		</script>
		
		<section>
			<div class="Container">
				<div class="Section">
					<jsp:include page="generales/seccionPrincipal.jsp">
						<jsp:param name="organizacion" value="${sessionScope.stiloOrg}" />
					</jsp:include>
					<div class="Login">
						<form:form id="fm_login" name="formulario" method="post" modelAttribute="usuario" action="${pageContext.request.contextPath}/login" accept-charset="ISO-8859-15">
							<div class="Container_Form">						
								<div class="Form__Group">
									<label class="LabelText">USUARIO:*</label>
									<input id="loginUser" class="Inputxxl" type="text" path="j_username" name="j_username" placeholder="USUARIO" data-not-null="0" data-nombre="Usuario" data-usuario="0" maxlength="50" />
								</div>
								<div class="Form__Group">
									<label class="LabelText">CONTRASEÑA: *</label>
									<input id="contraseniaLogin" class="Inputxxl" type="password" path="j_password" name="j_password" placeholder="CONTRASEÑA" data-not-null="0" data-nombre="Contraseña" data-contrasenia="0" maxlength="13" noPaste="true" />
								</div>
								<c:choose>
									<c:when test="${sessionScope.stiloOrg == '552'}">
										<div class="Form__Group">
											<c:choose>
												<c:when test="${sessionScope.stiloOrg == '552'}">
													<label class="LabelText" for="usuario">CARE: </label>
												</c:when>
												<c:otherwise>
													<label class="LabelText" for="usuario">Selecciona tu Sucursal: </label>
												</c:otherwise>
											</c:choose>	
											<div class="AutoComplete__Container">
												<select id="claveSucursal" name="claveSucursal" data-placeholder="CARE" class="chosen-select" size="20" noPaste="true">
													<option value="">Selecciona tu Sucursal:</option>
													<c:forEach items="${sessionScope.listaSucursales}" var="sucursal">
												       <option value="${sucursal.clave}"><c:out	value="${sucursal.descripcion}"></c:out></option>
											        </c:forEach>								
												</select>
											</div>
										</div>				
									</c:when>
								</c:choose>			
								<div class="Form__Group">
									<div class="ContainerButtonsCenter">
										<input id="btnEntrar" class="Submit" type="submit" value="ENTRAR"/>
									</div>
								</div>
								<div class="Form__Group">
									<p class="Login__Parrafo">Ooops olvid&eacute; mi contrase&ntilde;a. Solic&iacute;tala <a class="Login__Forget" href="recupera.do">aqu&iacute;</a></p>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<h2 id="errorSpring" style="display: none;">${SPRING_SECURITY_LAST_EXCEPTION.message}</h2>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="generales/footerPrincipal.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/accesologin.js'/>"></script>
	<jsp:include page="generales/modals.jsp" />
	
	<div id="infoCokies" class="Modal">
		<div class="ModalContainer">
			<div class="ModalHeader">
				<h2 class="ModalTitle">IMPORTANTE</h2>
				<a href="#" class="ModalButton">X</a>
			</div>
			<div class="Modal_Container">
				<div class="Modal__Text">
					<p style="font-size:12px; padding: 10px; text-align:justify;">
					Para ofrecer una mejor experiencia y servicio, de acuerdo a sus h&aacute;bitos de navegaci&oacute;n, este sitio utiliza "cookies" que le permiten obtener informaci&oacute;n de los usuarios que puede ser considerada como datos personales.  Al permanecer navegando en este sitio, Usted acepta expresamente el uso de “cookies”. En cualquier momento, Usted podr&aacute; deshabilitar la funcionalidad de las “cookies” que utilizamos modificando su configuraci&oacute;n a trav&eacute;s de las opciones de su navegador (browser o buscador), pero el hecho de deshabilitar este tipo de tecnolog&iacute;a puede afectar la funcionalidad del sistema, e impedir que este sitio web se muestre correctamente. Le informamos que en ning&uacute;n caso se transferir&aacute;n a terceros los datos personales que se obtienen a trav&eacute;s de estas tecnolog&iacute;as.
					</p>
				</div>
			</div>
			<div>
				<form class="ModalFooter">
				  <input id="btnCookie" class="Submit" type="button" value="Aceptar">
				</form>
			</div>
		</div>
	</div>
		
	<script type="text/javascript" src="<c:url value='/webResources/js/autocomplete/chosen.jquery.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/autocomplete/init.js'/>"></script>
</body>
</html>