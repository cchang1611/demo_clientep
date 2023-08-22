<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
	<link rel="stylesheet" type="text/css" href="<f:url value='/webResources/css/general/modal_window.css'/>"></link>
	<section>
		<div id="loginErrorModal" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloAlerta"></h2>
					<a href="#" class="ModalButton">X</a>
				</div>
				<div class="Modal__IconAlert">
					<img class="IconAlert" src="<f:url value='/webResources/img/warning.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeAlerta"> </div>
			</div>
		</div>
		<div id="exitoModalCambio" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 id="tituloAlertaCambio" class="ModalTitle">${respuesta.titulo}</h2>
				</div>
				<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="<f:url value='/webResources/img/ok_icon.png'/>" alt="icon_alert" />
				</div>
				<div id="mensajeAlertaCambio" class="Modal__AlertText">
					${respuesta.mensaje}
				</div>
				<div>
					<form class="ModalFooter">
					  <input id="btnExitoCambio" class="Submit" type="submit" value="Continuar"/>
					</form>
				</div>
			</div>
		</div>
		<div id="exitoModalAceptar" class="Modal">
		     <div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloExito">${respuesta.titulo}</h2>
					<a href="#" class="ModalButton" id="btnExitoM">X</a>
				</div>
				<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="<f:url value='/webResources/img/ok_icon.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeExito">
					${respuesta.mensaje}
				</div>
			</div>
		</div>
		<div id="exitoModal" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloExito">${respuesta.titulo}</h2>
					<a href="#" class="ModalButton" id="btnExitoM">X</a>
				</div>
				<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="<f:url value='/webResources/img/ok_icon.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeExito">
					${respuesta.mensaje}
				</div>
			</div>
		</div>
		<div id="errorModal" class="Modal">
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
				
			</div>
		</div>
		<div id="modalActExp" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader" id="tituloActExp">
				</div>
				<div class="Modal__Admiracion">
					<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeActExp">
				</div>
			</div>
		</div>
		<div id="modalLoader" class="Modal">
			<div class="Modal__Loader">
				<div id="contenedor">
					<div class="loader" id="loader">Loading...</div>
				</div>
			</div>
		</div>
		<div id="modalLoaderX" class="Modal">
			<div class="ModalHeaderLoader">
				<a id="btnLoaderX" href="#" class="ModalButtonLoader">X</a>
			</div>
			<div class="Modal__Loader">
				<div id="contenedor">
					<div class="loader" id="loader">Loading...</div>
				</div>
			</div>
		</div>
		
	</section>
</body>
</html>
