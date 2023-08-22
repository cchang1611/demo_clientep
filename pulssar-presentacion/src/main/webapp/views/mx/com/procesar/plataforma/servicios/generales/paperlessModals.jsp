<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pM"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<pM:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<pM:url value='/webResources/css/general/styles_form.css'/>"></link>
	<section>
		<div id="modalConfirmacionPaperless" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloPaperless"></h2>
				</div>
				<center>
				<div class="Modal__AlertText" id="mensajePaperless">
				</div>
				</center>
				<div class="ContainerButtonsCenter">
					<a  href="#" onclick="" class="Submitx">CANCELAR</a>
					<a  href="#" onclick="mostrarCorreoCeroPapel()" class="Submitx">ACTIVAR</a>
				</div>
			</div>
		</div>
		<div id="modalCorreoElectronico" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloCorreoPaperless"></h2>
				</div>
				<center>
				<div class="Modal__AlertText" id="mensajeCorreoPaperless"></div>
				<div  id="correoPaperless"></div>
				 </center>
				 <div class="ContainerButtonsCenter">
					<a href="#" onclick="guardarEstatusActivoCeroPapel()" class="Submitx">SI</a>
					<a href="modificaTrabajador.do" onclick="" class="Submitx">NO</a>
				</div>
			</div>
	    </div>
		<div id="modalNoCorreoPaperless" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloNoCorreoPaperless"></h2>
				</div>
				<center>
				<div class="Modal__AlertText" id="mensajeNoCorreoPaperless"></div>
				</center>
				<div class="ContainerButtonsCenter">
					<a  href="#" onclick="" class="Submitx">CANCELAR</a>
					<a  href="modificaTrabajador.do" onclick="" class="Submitx">ACEPTAR</a>
				</div>
			</div>
		</div>
		<div id="modalCancelarPaperless" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloCancelarPaperless"></h2>
				</div>
				<center>
				<div class="Modal__AlertText" id="mensajeCancelarPaperless"></div>
				</center>
				<div class="ContainerButtonsCenter">
					<a  href="#" onclick="" class="Submitx">CANCELAR</a>
					<a  href="#" onclick="guardarEstatusCancelarCeroPapel()" class="Submitx">ACEPTAR</a>
				</div>
			</div>
		</div>
		<div id="modalConfirmacionPaperless" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloPaperless"></h2>
				</div>
				<center>
				<div class="Modal__AlertText" id="mensajePaperless">
				</div>
				</center>
				 <div class="ContainerButtonsCenter">
					<a  href="#" onclick="" class="Submitx">CANCELAR</a>
					<a  href="#" onclick="mostrarCorreoCeroPapel()" class="Submitx">ACTIVAR</a>
				</div>
			</div>
	    </div>
	    <div id="modalCorreoElectronico" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloCorreoPaperless"></h2>
				</div>
				<center>
				<div class="Modal__AlertText" id="mensajeCorreoPaperless"></div>
				<div  id="correoPaperless"></div>
				 </center>
				 <div class="ContainerButtonsCenter">
					  <a  href="#" onclick="guardarEstatusActivoCeroPapel()" class="Submitx">SI</a>
				<a  href="modificaTrabajador.do" onclick="" class="Submitx">NO</a>
				</div>
			</div>
	    </div>
		<div id="modalNoCorreoPaperless" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloNoCorreoPaperless"></h2>
				</div>
				<center>
				<div class="Modal__AlertText" id="mensajeNoCorreoPaperless"></div>
				</center>
				<div class="ContainerButtonsCenter">
					<a  href="#" onclick="" class="Submitx">CANCELAR</a>
					<a  href="modificaTrabajador.do" onclick="" class="Submitx">ACEPTAR</a>
				</div>
			</div>
		</div>
		<div id="modalCancelarPaperless" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloCancelarPaperless"></h2>
				</div>
				<center>
				<div class="Modal__AlertText" id="mensajeCancelarPaperless"></div>
				</center>
				<div class="ContainerButtonsCenter">
					<a  href="#" onclick="" class="Submitx">CANCELAR</a>
					<a  href="#" onclick="guardarEstatusCancelarCeroPapel()" class="Submitx">ACEPTAR</a>
				</div>
			</div>
		 </div>
	</section>
</body>
</html>
