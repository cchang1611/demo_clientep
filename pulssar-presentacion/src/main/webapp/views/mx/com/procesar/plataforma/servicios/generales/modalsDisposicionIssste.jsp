<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<f:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<f:url value='/webResources/css/general/loader.css'/>"></link>
	<script type="text/javascript" charset="utf-8" src="<f:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<section>
		<div id="miModalOpcionCarga" class="Modal">
			<div class="ModalContainer" style="background-color: #E0e0e0;">
				<div class="ModalHeader">
					<h2 class="ModalTitle"></h2>
				</div>
				<div class="Form__Group">
					<label class="Label_longtext" for="usuario">Tipo de Recursos:</label> 
					<select id="tipoRecurso" onchange="validarTipoRecurso()" class="Select_longtext" name="tipoRecurso" path="tipoDisposicion" data-not-null="0" data-nombre="tipoRecurso">
						<option value="0">Seleccione un Tipo de Recurso</option>
						<option value="sief">Trámites por Cuenta Individual</option>
						<option value="banx">Trámites por Décimo Transitorio</option>
					</select>
				</div>
				<div class="Modal_Container">
					<center>
						<div class="Modal__AlertText" id="cargaMensajeIssste">${_MENSAJE}</div>
					</center>
				</div>
				<div class="ContainerButtonsCenter">
					<a href="#" class="Submitx" onclick="deshabilitarOpcionesNoCarga()" id="botonNoCargado">NO CARGADO</a> 
					<a onclick="mostrarModalResolucion()" id="botonCargado" class="Submitx">CARGADO</a> 
					<a href="#" onclick="habilitarNrp()" id="botonPlanPrivado" class="Submitx" >PLAN PRIVADO</a>
				</div>
				<center>
					<span id="spanGargadoNoDatos" class="error_span">El Trabajador no cuenta con un Derecho cargado</span>
				</center>
			</div>
		</div>
	</section>
</body>
</html>
