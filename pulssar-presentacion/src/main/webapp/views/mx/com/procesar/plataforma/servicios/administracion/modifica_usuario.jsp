<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Datos Generales del Trabajador</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link charset="UTF-8" rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="UTF-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script charset="UTF-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script charset="UTF-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="3" />
			<jsp:param name="menuTitle" value="Modifica Datos de Usuario" />
			<jsp:param name="menuActivo" value = "1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
		</script>
		
		<section>
			<form:form id="fm_editaUser" method="POST" modelAttribute="editaUsuario" action="editaUsuario.do" accept-charset="ISO-8859-1">
				<div class="Container">
					<div class="Section">
						<div class="Aside__Col01">
							<div class="Datos_Container">
								<div class="Form__Group">
									<label class="LabelText" for="usuario">Usuario: </label>
									<form:input class="Inputxxl" type="text" name="nickUsuario" path="nickUsuario" disabled="true"/>
								</div>
								<div class="Form__Group">
									<label class="LabelText" for="usuario">Nombre: *</label>
									<form:input class="Inputxxl" type="text" name="nombre" path="nombre" placeholder="Nombre" data-not-null="0" data-nombre="Nombre" data-alfanumerico-space="0" maxlength="40" noPaste="true" />
								</div>
								<div class="Form__Group">
									<label class="LabelText" for="usuario">Apellido Paterno: *</label>
									<form:input class="Inputxxl" type="text" name="apellidoPaterno" path="apellidoPaterno" placeholder="Apellido Paterno" data-not-null="0" data-nombre="Apellido Paterno" data-alfanumerico-space="0" maxlength="40" noPaste="true" />
								</div>
								<div class="Form__Group">
									<label class="LabelText" for="usuario">Apellido Materno:</label>
									<form:input class="Inputxxl" type="text" name="apellidoMaterno" path="apellidoMaterno" placeholder="Apellido Materno" data-alfanumerico-space="0" maxlength="40" noPaste="true" />
								</div>
						<c:choose>
							<c:when test = "${not empty lzonas || not empty lmodulos}">
										<div class="Form__Group">
											<label class="LabelText" for="usuario">Celular: </label>
											<form:input id="celular" class="Inputxxl" type="text" name="celular" path="celular" placeholder="Celular" data-nombre="Celular" maxlength="10" noPaste="true" />
										</div>
										<div class="Form__Group">
											<label class="LabelText" for="usuario">Correo Electr&oacute;nico: *(?)</label>
											<form:input id="email" class="Inputxxl" type="text" name="correo" path="correo" placeholder="Correo" data-nombre="Correo Electr&oacute;nico" data-email="0" maxlength="50" noPaste="true" />
										</div>
									</div>
								</div>
								<div class="Aside__Col02">
									<div class="Datos_Container">
							</c:when>
							<c:otherwise>
									</div>
								</div>
								<div class="Aside__Col02">
									<div class="Datos_Container">
										<div class="Form__Group">
											<label class="LabelText" for="usuario">Celular: </label>
											<form:input id="celular" class="Inputxxl" type="text" name="celular" path="celular" placeholder="Celular" data-nombre="Celular" maxlength="10" noPaste="true" />
										</div>
										<div class="Form__Group">
											<label class="LabelText" for="usuario">Correo Electr&oacute;nico: *(?)</label>
											<form:input id="email" class="Inputxxl" type="text" name="correo" path="correo" placeholder="Correo" data-nombre="Correo Electr&oacute;nico" data-email="0" maxlength="50" noPaste="true" />
										</div>
							</c:otherwise>
						</c:choose>
								<div class="Form__Group">
									<c:choose>
										<c:when test="${sessionScope.stiloOrg == '552'}">
											<label class="LabelText" for="usuario">CARE: </label>
										</c:when>
										<c:otherwise>
											<label class="LabelText" for="usuario">Selecciona tu Sucursal: </label>
										</c:otherwise>
									</c:choose>	
									<form:select id="claveSucursal" class="Select" name="claveSucursal" path="claveSucursal" data-nombre="Sucursal">
										<option value="">Seleccione su SUCURSAL</option>
										<form:options items="${listaSucursales}" itemValue="clave" itemLabel="descripcion"/>
									</form:select>
								</div>
								<c:if test = "${not empty lzonas}">
									<div class="Form__Group">
										<label class="LabelText" for="usuario">N&uacute;mero de la Zona: *</label>
										<form:select id="claveZona" class="Select" name="claveZona" path="claveZona" data-not-null="0" data-nombre="Zona">
										<option value="">Seleccione su ZONA</option>
										<form:options items="${lzonas}" itemValue="clave" itemLabel="descripcion"/>
										</form:select>
									</div>
									<div class="Form__Group">
										<label class="LabelText" for="usuario">Nombre de la Zona: *</label>
										<form:select id="nombreZona" class="Select" name="nombreZona" path="nombreZona" data-not-null="0" data-nombre="Nombre Zona">
											<option value="">Seleccione la DESCRIPCI&Oacute;N</option>
											<c:if test = "${not empty ldesczona}">
												<form:options items="${ldesczona}" itemValue="clave" itemLabel="descripcion"/>
											</c:if>
										</form:select>
									</div>
									<div class="Form__Group">
										<label class="LabelText" for="usuario">Nombre de la Oficina: *</label>
										<form:select id="claveOficina" class="Select" name="claveOficina" path="claveOficina" data-not-null="0" data-nombre="Oficina">
											<option value="">Seleccione su OFICINA</option>
											<c:if test = "${not empty loficinas}">
												<form:options items="${loficinas}" itemValue="clave" itemLabel="descripcion"/>
											</c:if>
										</form:select>
									</div>
								</c:if>
								<div class="Form__Group">
									<label class="LabelText" for="usuario">Perfil(es): *</label>
									<div class="Checkbox__Area" id="ulCheckBox">
										<ul class='Checkbox__List'>
											<c:forEach items="${roles}" var="rol">
												<c:choose>
													<c:when test="${rol.bandera == 0}">
														<li class='Checkbox__Li'><input type='radio' name='checkRoles' value='${rol.clave}' onchange="cambioRol();" /> ${rol.descripcion}</li>
													</c:when>
													<c:otherwise>
														<li class='Checkbox__Li'><input type='radio' name='checkRoles' value='${rol.clave}' onchange="cambioRol();" checked /> ${rol.descripcion}</li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</ul>
									</div>
								</div>
								<c:choose>
									<c:when test = "${flagmodulo == 2}">
										<div class="Form__Group" id="divModuloReporte" style="display : none">
									</c:when>
									<c:otherwise>
										<div class="Form__Group" id="divModuloReporte" style="display : block">
									</c:otherwise>
								</c:choose>
								<c:if test = "${not empty lmodulos}">
									<label class="LabelText" for="usuario">M&oacute;dulo Reporte: *</label>
									<div class="Checkbox__Area" id="ulCheckBoxModulo">
										<ul class='Checkbox__List'>
											<c:forEach items="${lmodulos}" var="modulo">
												<c:choose>
													<c:when test="${modulo.bandera == 0}">
														<li class='Checkbox__Li'><input type='checkbox' name='checkModulo' value='${modulo.clave}' /> ${modulo.descripcion}</li>
													</c:when>
													<c:otherwise>
														<li class='Checkbox__Li'><input type='checkbox' name='checkModulo' value='${modulo.clave}' checked /> ${modulo.descripcion}</li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</ul>
									</div>
								</c:if>
								</div>
								<div class="ContainerButtonsCenter">
									<input id="btnRegistro" class="Submit" type="submit" value="Guardar">
								</div>
							</div>
						</div>
					</div>
					<form:input path="claveAfore" id="claveAfore" type="hidden"/>
				</div>
			</form:form>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAdmin.jsp" />
	
	<script src="<c:url value='/webResources/js/usuariosEdita.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
