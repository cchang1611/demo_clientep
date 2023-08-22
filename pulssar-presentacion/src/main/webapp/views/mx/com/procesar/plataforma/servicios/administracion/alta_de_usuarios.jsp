<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Alta de Usuarios</title>
	
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link charset="utf-8" rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="utf-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery-3.0.0.min.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.plugin.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="3" />
			<jsp:param name="menuTitle" value="Alta de Usuarios" />
			<jsp:param name="menuActivo" value = "1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
			var _FLAG = "${dato}";
		</script>
		
		<section>
			<form:form id="fm_altaUser" method="POST" modelAttribute="altaUsuario" action="altaUsuario.do" accept-charset="ISO-8859-1">
				<div class="Container">
					<div class="Layout__XL">
						<c:if test="${not empty afores}">
							<div class="Datos_Container">
								<div class="Form__Box01">
									<div class="Form">
										<label class="LabelText" for="afore">Afore: </label>
									</div>
									<div class="Form__BoxChild">
										<form:select id="claveAfore" class="Select" name="claveAfore" path="claveAfore" data-not-null="0" data-nombre="Afore">
										<option value="">Seleccione una AFORE</option>
										<form:options items="${afores}" itemValue="clave" itemLabel="descripcion"/>
										</form:select>
									</div>
								</div>
							</div>
						</c:if>
						<div class="Datos_Container">
							<div class="Form__Box01">
								<div class="Form">
									<label class="LabelText" for="plataforma">Plataforma: </label>
								</div>
								<div class="Form__BoxChild">
									<form:select id="idPlataforma" class="Select" name="idPlataforma" path="idPlataforma" data-not-null="0" data-nombre="Plataforma">
									<option value="">Seleccione una PLATAFORMA</option>
									<form:options items="${plataformas}" itemValue="clave" itemLabel="descripcion"/>
									</form:select>
								</div>
							</div>
						</div>
						<div class="Section">
							<div class="Aside__Col01">
								<div class="Datos_Container">
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
										<c:when test = "${not empty zonas}">
											<div class="Form__Group">
												<label class="LabelText" for="usuario">Celular: </label>
												<form:input id="celular" class="Inputxxl" type="text" name="celular" path="celular" placeholder="Celular" data-nombre="Celular" maxlength="10" noPaste="true" />
											</div>
											<div class="Form__Group">
												<label class="LabelText" for="usuario">Confirma Celular: </label>
												<form:input id="confirmaCelular" class="Inputxxl" type="text" name="confirmarCelular" path="confirmarCelular" data-confirm-no-req="celular" placeholder="Confirma Celular" data-nombre="Confirma Celular" maxlength="10" noPaste="true" />
											</div>
										</c:when>
										<c:otherwise>
											<div id="camposCelular" style="display : none"></div>
										</c:otherwise>
									</c:choose>
									<div class="Form__Group" id="userAgente" style="display : none;">
										<label class="LabelText" for="usuario">N&uacute;mero de Agente: (?)</label>
										<form:input class="Inputxxl" type="text" id="numAgente" name="numeroAgente" path="numeroAgente" placeholder="Numero de Agente" data-nombre="N&uacute;mero de Agente" data-numeros="0" maxlength="10" noPaste="true" />
									</div>
									<div class="Form__Group" id="ipUsuario" style="display : none;">
										<label class="LabelText" for="ipCliente">IP Cliente: </label>
										<form:input class="Inputxxl" type="text" id="ipAccesoUsuario" name="ipAccesoUsuario" path="ipAccesoUsuario" placeholder="IP Cliente" data-ip="0" maxlength="15" />
									</div>
									<div class="Form__Group">
										<label class="LabelText" for="usuario">Perfil: *</label>
										<% int contadorRol = 0; %>
										<div class="Checkbox__Area" id="ulCheckBox">
											<ul class='Checkbox__List' id="ulCheckRoles<%= contadorRol %>">
											<c:forEach items="${roles}" var="rol" varStatus="loopCounter">
												<c:if test="${(loopCounter.index > 0)  && ((loopCounter.index % 6) == 0)}">
													<% ++contadorRol; %>
													</ul><ul class='Checkbox__List' id="ulCheckRoles<%= contadorRol %>">
												</c:if>
													<li class='Checkbox__Li'><input type='radio' name='checkRoles' onchange="cambioRol();" value='${rol.clave}' /> ${rol.descripcion}</li>
											</c:forEach>
											</ul>
										</div>
									</div>
									<div class="Form__Group" id="divModuloReporte" style="display : none">
										<label class="LabelText" for="usuario">Mm&oacute;dulo Reporte: *</label>
										<div class="Checkbox__Area" id="ulCheckBoxModulo">
										</div>
									</div>
								</div>
							</div>
							<div class="Aside__Col02">
								<div class="Datos_Container">
									<c:if test = "${empty zonas}">
										<div id="camposAdicionales" style="display : block">
											<div class="Form__Group">
												<label class="LabelText" for="usuario">Celular: </label>
												<form:input id="celular" class="Inputxxl" type="text" name="celular" path="celular" placeholder="Celular" data-nombre="Celular" maxlength="10" noPaste="true" />
											</div>
											<div class="Form__Group">
												<label class="LabelText" for="usuario">Confirma Celular: </label>
												<form:input id="confirmaCelular" class="Inputxxl" type="text" name="confirmarCelular" path="confirmarCelular" data-confirm-no-req="celular" placeholder="Confirma Celular" data-nombre="Confirma Celular" maxlength="10" noPaste="true" />
											</div>
										</div>
									</c:if>
									<div class="Form__Group">
										<label class="LabelText" for="usuario">Correo Electr&oacute;nico: *(?)</label>
										<form:input id="email" class="Inputxxl" type="text" name="correo" path="correo" placeholder="Email" data-nombre="Correo Electr&oacute;nico" data-email="0" maxlength="50" noPaste="true" />
									</div>	
									<div class="Form__Group">
										<label class="LabelText" for="usuario">Confirma Correo Electr&oacute;nico: *</label>
										<form:input id="confirmaEmail" class="Inputxxl" type="text" name="confirmarCorreo" path="confirmarCorreo" data-confirm="email" placeholder="Confirma Correo Email" data-nombre="Confirma Correo Electr&oacute;nico" data-email="0" maxlength="50" noPaste="true" />
									</div>
									<div id="campoAfores" style="display : none">
										<div class="Form__Group">
											<label class="LabelText" for="usuario">Selecciona afore: </label>								
											<form:select id="cvAfore" class="Select" name="cvAfore" path="cvAfore" data-nombre="Afore" data-not-null="0">
												<option value="">Seleccione afore</option>
												<form:options items="${listaAfores}" itemValue="clave" itemLabel="descripcion"/>
											</form:select>	
										</div>
									</div>
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
									<c:if test = "${empty zonas}">
										<div id="camposZona" style="display : none">
									</c:if>
									<div class="Form__Group">
										<label class="LabelText" for="usuario">N&uacute;mero de la Zona: *</label>
										<form:select id="claveZona" class="Select" name="claveZona" path="claveZona" data-not-null="0" data-nombre="Zona">
										<option value="">Seleccione su ZONA</option>
										<form:options items="${zonas}" itemValue="clave" itemLabel="descripcion"/>
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
									<c:if test = "${empty zonas}">
										</div>
									</c:if>
									<div class="ContainerButtonsCenter">
										<input id="btnLimpiar" class="Submit" type="submit" value="Limpiar">
										<input id="btnRegistro" class="Submit" type="submit" value="Registrar">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAdmin.jsp" />
	
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/usuariosAlta.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
