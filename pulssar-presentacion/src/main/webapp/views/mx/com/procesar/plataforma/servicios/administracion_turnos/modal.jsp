<!--
  - Author(s):   @author ISAIAS NEFTALI TORRES ANGEL <INTORRES@inet.procesar.com.mx>
  - Date:        08-Octubre-2019
  - Description: Menú correspondiente al Rol del Ejeutivo de atención.
  -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<section>
	<div id="errorModal" class="Modal">
		<div class="ModalContainer">
			<div class="ModalHeader">
			<h2 class="ModalTitle" id="tituloError"></>${respuesta.titulo}</h2>
			<a href="#" class="ModalButton" id="btnErrorM">X</a>
			</div>
			<div class="Modal__IconAlert">
				<img class="IconAlert" src="<f:url value='/webResources/img/warning.png'/>" alt="icon_alert" />
			</div>
			<div id="mensajeErrorModal" class="Modal__AlertText">
				${respuesta.mensaje}
			</div>
		</div>
	</div>
	<div id="infoModal" class="Modal">
		<div class="ModalContainer">
			<div class="ModalHeader">
				<h2 class="ModalTitle" id="tituloInfo">${respuesta.titulo}</h2>
				<a href="#" class="ModalButton" id="btnInfoM">X</a>
			</div>
			<div class="Modal__Admiracion">
				<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
			</div>
			<div class="Modal__AlertText" id="mensajeInfo">
				${respuesta.mensaje}
			</div>
			<div id="botonesInfoModal" style="display:none;">
				<form class="ModalFooter">
				  <input id="btnInfoModal" class="Submit" type="button" value="Continuar"/>
				</form>
			</div>
		</div>
	</div>
	<div id="exitoModalAceptar" class="Modal">
		<div class="ModalContainer">
			<div class="ModalHeader">
				<h2 id="tituloExitoAceptar" class="ModalTitle">${respuesta.titulo}</h2>
			</div>
			<div class="Modal__IconAlertOK">
				<img class="IconAlert" src="<f:url value='/webResources/img/ok_icon.png'/>" alt="icon_alert" />
			</div>
			<div id="mensajeExitoAceptar" class="Modal__AlertText">
				${respuesta.mensaje}
			</div>
			<div>
				<form class="ModalFooter">
				  <input id="btnExitoAceptar" class="Submit" type="button" value="Aceptar"/>
				</form>
			</div>
		</div>
	</div>
</section>
</body>
</html>