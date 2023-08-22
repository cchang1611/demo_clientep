<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<f:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<f:url value='/webResources/css/general/loader.css'/>"></link>
	<section>
		<div id="resolucionCarga" class="Modal">
			<div class="ModalContainer">
			<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloAlerta"></h2>
					<a href="#" class="ModalButton">X</a>
			</div>
				<div id="mensajeAlertaCambio" class="Modal__AlertText">
					${respuesta.mensaje}  
				</div>
				<div>
					<form class="ModalFooter">
					<div class="ContainerButtons"> 
					      <a  href="#"  class="Submitx" id="btnDerechoNoCargado" >NO CARGADO</a>
					 	  <a  href="#"  class="Submitx" id="btnDerechoCargado" />CARGADO</a>
						  <a  href="#"  class="Submitx" id="btnPlanPrivado"  />PLAN PRIVADO</a>
						 
				    </div>
					
					</form>
				</div>
				
			</div>
		</div>
		
		<div id="modalConsultarActuario" class="Modal">
			
			<div class="ModalContainer">
			<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloAlerta"></h2>
					<a href="#" class="ModalButton">X</a>
			</div>
				<div id="mensajeAlertaCambio" class="Modal__AlertText">
					${respuesta.mensaje}  
				</div>
				
			</div>
		</div>
		<div id="modalConsultarNss" class="Modal">
			
			<div class="ModalContainer">
			<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloAlerta"></h2>
					<a href="#" class="ModalButton">X</a>
			</div>
				<div id="mensajeAlertaCambio" class="Modal__AlertText">
					${respuesta.mensaje}  
				</div>
				
			</div>
		</div>
		<div id="modalConsultaNrp" class="Modal">
			
			<div class="ModalContainer">
			<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloAlerta"></h2>
					<a href="#" class="ModalButton">X</a>
			</div>
			<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="<f:url value='/webResources/img/ok_icon.png'/>" alt="icon_alert" />
			</div>
				<div id="mensajeAlertaCambio" class="Modal__AlertText">
					${respuesta.mensaje}  
				</div>
			<div>
			<form class="ModalFooter">
				<div class="ContainerButtons"> 		 
					 <input id="btnCargarCombos" class="Submit" type="submit" value="Continuar"/> 
			
						
				</div>
			</form>		
			</div>	
			</div>
		</div>
		<div id="errorValidarNrpModal" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
				<h2 class="ModalTitle" id="tituloError">${respuesta.titulo}</h2>
				<!-- <a href="#" class="ModalButton" id="btnErrorM">X</a> -->
				</div>
				<div class="Modal__IconAlert">
					<img class="IconAlert" src="<f:url value='/webResources/img/warning.png'/>" alt="icon_alert" />
				</div>
				<div id="mensajeErrorModal" class="Modal__AlertText">
					${respuesta.mensaje}
				</div>
				<div>
					<form class="ModalFooter">
						<div class="ContainerButtons"> 
						      <a  href="#"  class="Submitx" id="btnModalAceptar" >ACEPTAR</a>
					    </div>
					</form>
				</div>
			</div>
		</div>
		<div id="modalerrorProcesos" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
				<h2 class="ModalTitle" id="tituloError">${respuesta.titulo}</h2>
				<!-- <a href="#" class="ModalButton" id="btnErrorM">X</a> -->
				</div>
				<div class="Modal__IconAlert">
					<img class="IconAlert" src="<f:url value='/webResources/img/warning.png'/>" alt="icon_alert" />
				</div>
				<div id="mensajeErrorModal" class="Modal__AlertText">
					No esta habilitado para Ventanilla Afore
				</div>
				<div>
					<form class="ModalFooter">
						<div class="ContainerButtons"> 
						      <a  href="#"  class="Submitx" id="btnRedicSubMenuProceso" >ACEPTAR</a>
					    </div>
					</form>
				</div>
			</div>
		</div>
	    <div id="modalIcefasTrabajador" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloInfo"></h2>
					<a href="#" class="ModalButton" id="btnInfoM">X</a>
				</div>
				<div class="Modal__Admiracion">
					<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeInfo">
					Trabajador cuenta con posibles Icefas a Unificar
				</div>
				
			</div>
	     </div> 
	     <div id="modalConDerechoImss" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloInfo"></h2>
					<!-- <a href="#" class="ModalButton" id="btnInfoM">X</a> -->
				</div>
				<div class="Modal__Admiracion">
					<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeInfo">
					El Trabajador cuenta con un Derecho cargado
				</div>
				<div>
					<form class="ModalFooter">
						<div class="ContainerButtons"> 
						      <a  href="#"  class="Submitx" id="btnContinuaTramite" >ACEPTAR</a>
					    </div>
					</form>
				</div>
			</div>
	     </div> 
	     <div id="modalSinDerechoImss" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloInfo"></h2>
					<!-- <a href="#" class="ModalButton" id="btnInfoM">X</a> -->
				</div>
				<div class="Modal__Admiracion">
					<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeInfo">
					El Trabajador no cuenta con un Derecho cargado
				</div>
				<div>
					<form class="ModalFooter">
						<div class="ContainerButtons"> 
						      <a  href="#"  class="Submitx" id="btnNoContinuaTramite" >ACEPTAR</a>
					    </div>
					</form>
				</div>
			</div>
	     </div> 
	      <div id="modalNoHayDerechoAceptado" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloInfo"></h2>
					<!-- <a href="#" class="ModalButton" id="btnInfoM">X</a> -->
				</div>
				<div class="Modal__Admiracion">
					<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeInfo">
					No  hay derecho para plan privado
				</div>
				<div>
					<form class="ModalFooter">
						<div class="ContainerButtons"> 
						      <a  href="#"  class="Submitx" id="btnNoHayDerechoAceptado" >ACEPTAR</a>
					    </div>
					</form>
				</div>
			</div>
	     </div> 
	     <div id="modalAdicionarBeneficiario" class="Modal">
			
			<div class="ModalContainer">
			<div class="ModalHeader">
					<h2 class="ModalTitle" id="tituloAlerta"></h2>
					<a href="#" class="ModalButton">X</a>
			</div>
			<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="<f:url value='/webResources/img/ok_icon.png'/>" alt="icon_alert" />
			</div>
				<div id="mensajeAlertaCambio" class="Modal__AlertText">
					${respuesta.mensaje}  
				</div>
			<div>
				<form class="ModalFooter">
					<div class="ContainerButtons"> 		 
						 <input id="btnCargarDatosTabla" class="Submit" type="submit" value="Continuar"/> 
					</div>
				</form>		
			</div>	
			</div>
		</div>
	</section>
</body>
</html>
