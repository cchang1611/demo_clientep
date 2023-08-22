	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
	<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
	<head>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.css'/>">	    
	<script type="text/javascript" charset="UTF-8"
						src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
						src="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.min.js'/>"></script>	
										
	</head>
	<body>
	<div id="agregaFormaPago" class="Modal" style="display:none; opacity:1; pointer-events:visible;">
		<div class="ModalContainer">
			<div class="ModalHeader">
				<h2 id="tituloFormaPago" class="ModalTitle">Forma de Pago</h2>
				<a href="#" class="ModalButton" onclick="cerrarModal();">X</a>
			</div>
			<div class="ModalText">
				<div class="Container_Section">
					<div class="row_containerbox">
						<div class="Form__Group">
							<label class="LabelTextEdit" for="formaPagoTipoRetiro">Forma de Pago:</label>
							<select class="Select" id="formaPagoTipoRetiro" onkeyup="activar_boton()"  name="formaPagoTipoRetiro" data-not-null="0" data-nombre="Forma de Pago" onchange="activar_boton()">
							<option value="">Seleccione la Forma de Pago</option>
							<c:forEach var="formaPago" items="${formasPago}">
								<option value="${formaPago.chParametro}">${formaPago.chValorParametro}</option>	
							</c:forEach>
							</select>								
						</div> 
						<div id="formaPagoTransferencia">
						 <div class="Form__Group">
							<label class="LabelTextEdit" for="descripcionCtrlInstBancaria">Control Institución Bancaria:</label>
							<input class="InputEdit" type="text" id="descripcionCtrlInstBancaria" data-not-null="0" data-nombre="Control Institución Bancaria" placeholder='Instituci&oacute;n Bancaria' readonly="readonly" required="required" />
							<div id="mensajeErrorInstBancaria"></div>
							<input type="hidden" name="ctrlInstBancariaTipoRetiro" id="ctrlInstBancariaTipoRetiro" />
						</div> 
						<div class="Form__Group">
							<label class="LabelTextEdit" for="clabeTipoRetiro">Clabe:</label>
							
							<input class="InputEdit " type="text" onclick="activar_boton()" name="clabeTipoRetiro"  value="" placeholder="" id="clabeTipoRetiro" data-numeros="0" data-nombre="campo Clabe" required="required" size="18" autocomplete="off" maxlength="18"/>
						    <!--  <div id="mensajeErrorClabe"></div>  -->
						</div>
						<div class="Form__Group">
							<label class="LabelTextEdit" for="cuentaTipoRetiro">Cuenta:</label>
							<input class="InputEdit" type="text" onkeyup="activar_boton()" name="cuentaTipoRetiro" value="" placeholder="" id="cuentaTipoRetiro" data-numeros="0"  data-nombre="campo Cuenta" required="required" size="18" autocomplete="off" maxlength="18"/>
						</div>
						</div>
					</div>
				</div>
			</div>
			<div class="ContainerButtons">
				<!-- <input type="submit" class="Submit" value="Aceptar" id="btnPopupAceptar" /> -->
				 <input type="button" class="Submitx_disabled" id="btnPopupAceptar" value="Aceptar" disabled="disabled"/>
				 <input type="button" class="Submitx" value="Cancelar" id="btnPopupCancelar"/>
			</div>
								
		</div>
	</div>
	</body>
	</html>