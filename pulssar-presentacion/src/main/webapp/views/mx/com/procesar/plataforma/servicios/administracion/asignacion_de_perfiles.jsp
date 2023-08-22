<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Asignación de Perfiles</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/jquery.dataTables.min.css'/>">
	<link charset="UTF-8" rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="UTF-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script charset="UTF-8" src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="3" />
			<jsp:param name="menuTitle" value="Asignaci&oacute;n de perfiles" />
			<jsp:param name="menuActivo" value = "1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
		</script>
		
		<section>
			<form:form method="POST" id="fm_asignacion" modelAttribute="asignaPerfil" action="asignaPerfil.do">
				<div class="Container">
					<div class="Layout__XL">
						<c:if test="${not empty afores}">
							<div class="Datos_Container">
								<div class="Form__Box01">
									<div class="Form">
										<label class="LabelText" for="usuario">Afore: </label>
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
							<div class="Form__Box">
								<div class="Form">
									<label class="LabelText" for="usuario">Filtro:</label>
								</div>
								<div class="Form__BoxChild">
									<select class="Select" id="sFiltro">
										<option value="">Selecciona una Opcion</option>
										<option value="1">Usuario</option>
										<option value="2">Nombre</option>
										<option value="3">Apellido Paterno</option>
										<option value="4">Apellido Materno</option>
										<option value="5">Correo Electrónico</option>
										<option value="6">Celular</option>
									</select>
								</div>
								<div class="Form__BoxChild">
									<input class="Inputxxl SearchInput column_filter" type="text" id="dSearch" disabled="true" />
								</div>
								<div class="Form">
									<input id="btnBuscar" class="Submit Search" type="button" value="Buscar" disabled="true" />
								</div>
							</div>
							<div class="SeccionTable">
								<div style="overflow-x: auto;">
									<table id="tablaAsigna" class="display">
										<thead>
											<tr class="RowHeader">
												<th><input type="checkbox" name="select_all" value="1" id="chboxAll"></th>
												<th>Usuario</th>
												<th>Nombre</th>
												<th>Apellido Paterno</th>
												<th>Apellido Materno</th>
												<th>Correo Electrónico</th>
												<th>Celular</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${usuariosAsigna}" var="usuarios">
												<tr>
													<td></td>
													<c:choose>
														<c:when test="${usuarios.nickUsuario != null}">
															<td><c:out value="${usuarios.nickUsuario}" /></td>
														</c:when>
														<c:otherwise>
															<td><c:out value="${usuarios.usuario}" /></td>
														</c:otherwise>
													</c:choose>
													<td><c:out value="${usuarios.nombre}" /></td>
													<td><c:out value="${usuarios.apellidoPaterno}" /></td>
													<td><c:out value="${usuarios.apellidoMaterno}" /></td>
													<td><c:out value="${usuarios.email}" /></td>
													<td><c:out value="${usuarios.celular}" /></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="Section">
							<div class="Aside__Col03">
								<div class="Datos_Container">
									<label class="LabelText" for="usuario">Perfil(es): *</label>
									<div class="Checkbox__Area" id="ulCheckBox" style="width: 90%;">
										<ul class='Checkbox__List' id="ulCheckRoles">
										<c:forEach items="${roles}" var="rol">
												<li class='Checkbox__Li'><input type='checkbox' name='checkRoles' value='${rol.clave}' /> ${rol.descripcion}</li>
										</c:forEach>
										</ul>
									</div>
								</div>
							</div>
							<div class="Aside__Col04">
								<div class="Datos_Container">
									<div class="ContainerButtonsCenter">
										<input id="btnAsigna" class="Submit Buttons2" type="submit" value="Asignar Perfil"/>
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
	
	<script src="<c:url value='/webResources/js/usuariosAsigna.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>