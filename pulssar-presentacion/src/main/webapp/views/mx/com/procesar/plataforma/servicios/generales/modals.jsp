<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<f:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<f:url value='/webResources/css/general/loader.css'/>"></link>
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
				<div id="btnExitoContinuar" style="display:none;">
					<form class="ModalFooter">
					  <input id="btnExitoCambio" class="Submit" type="submit" value="Continuar"/>
					</form>
				</div>
			</div>
		</div>
		<div id="errorModal" class="Modal">
			<div class="ModalContainer">
				<div id="errorModalHeader" class="ModalHeader">
				<h2 class="ModalTitle" id="tituloError">${respuesta.titulo}</h2>
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
				<div id="botonInfoAutenticacion" style="display:none;" class="ContainerButtonsCenter">
					  <a href="https://${webAutenticaPeis}" id="btnInfoAutentica" class="Submitx" target="_blank">Continuar</a>
				</div>
				<div id="botonesInfoModal" style="display:none;">
					<form class="ModalFooter">
					  <input id="btnInfoModal" class="Submit" type="button" value="Continuar"/>
					</form>
				</div>
				<div id="btnInfoModals" style="display:none;">
					<form class="ModalFooter">
					  <input id="btnInfoBiom" class="Submit" type="button" value="Continuar"/>
					</form>
				</div>
				<div id="botonesInfoModalDoble" style="display:none;">
					<form class="ModalFooter">
					  <input id="btnInfoModalContinuar" class="Submit" type="button" value="Continuar" />
					  <input id="btnInfoModalCancelar" class="Submit"  type="button" value="Cancelar" />
					</form>
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
				<div class="Modal__AlertText" id="mensajeActExp"></div>
				<div id="botonesModalActExp" style="display:none;">
					<form class="ModalFooter">
					  <input id="btnModalActExpContinuar" class="Submit" type="button" value="Continuar" />
					  <input id="btnModalActExpCancelar" class="Submit"  type="button" value="Cancelar" />
					</form>
				</div>
			</div>
		</div>
		<div id="modalLoader" class="Modal">
			<div class="Modal__Loader">
				<div id="contenedor">
					<div class="loader" id="loader"></div>
					<div class="loaderText" id="loaderText">Cargando...</div>
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
		<div id="modalConfirmacion" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader" id="tituloConfirmacion">
				</div>
				<div class="Modal__Admiracion">
					<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeconfirmacion"></div>
				<div id="botonesModalConfirmacion">
					<form class="ModalFooter">
					  <input id="btnModalConfirmacionAceptar" class="Submit" type="button" value="Aceptar" />
					  <input id="btnModalConfirmacionCancelar" class="Submit"  type="button" value="Cancelar" />
					</form>
				</div>
			</div>
		</div>	
		<div id="curpFaltante" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 class="ModalTitle">Ingrese Curp</h2>
				</div>
				<form id="form_curpFaltante" action="modificaTrabajador.do" method="post" onsubmit="return validacionCurpFaltante(this)">
				<div class="Modal__Hora">
					<input class="curpFaltante" id="curpFaltante" type="text" name="curpFaltante" maxlength="18" required="required"/>
				</div>
				<div class="ModalFooter">
					<span id="errorCurpFaltante" class="Labeltexterror"></span>	
				</div>			
				<div class="ModalFooter">
				    <button id="btbContinuarCurp" type="submit" class="Submit">CONTINUAR</button>
				</div>
				</form>
			</div>
		</div>
		<div id="miModalConsultaPlataforma" class="Modal">
		    <div class="ModalContainer">
		      <div class="ModalHeader">
		      <h2 class="ModalTitle" id="plataformaTitulo">${_TITULO}</h2>
		      <a href="#" class="ModalButton">X</a>
		      </div>
		      <center>
				<div class="Modal__AlertText" id="plataformaMensaje">
				       ${_MENSAJE}
				</div>
				</center>
		        <div class="ContainerButtonsCenter">
					 <a  href="#" onclick="" class="Submitx">ACEPTAR</a>
				</div>
		    </div>
		  </div>
	<div id="miModalResultadoPlataforma" class="Modal">
      <div class="ModalContainer" style="background-color: #E0e0e0;">
        <div class="ModalHeader">
        <h2 class="ModalTitle" id="plataformaResultadoMensaje">${_MENSAJE}</h2>
        <a href="#" class="ModalButton">X</a>
        </div>
        <div class="Modal_Container" >
          <div class="Modal__Text">
            <div>
              <div class="Form__Group">
                <div class="fa-download">
					<input class="Inputxxl" type="text" name="nombArchivo" value="" placeholder="Nombre Archivo" id="nombArchivo" 
					style="font-size: 15px; text-align: left;">
                </div>
              </div>
          </div>
        </div>
      </div>
        <div class="ContainerButtonsCenter">
		   <a  href="exportarExcelPlataformaServicios.do" onclick="cerrarModalExcel()" class="Submitx">ACEPTAR</a>
            <a href="#" class="Submitx">Cancelar</a>
        </div>
    </div>
   </div>
    <div id="miModalPlanPrivado" class="Modal">
      <div class="ModalContainer" style="background-color: #E0e0e0;">
        <div class="ModalHeader">
        <h2 class="ModalTitle" id=""></h2>
        </div>
        <div class="Modal_Container" >
           <center>
				<div class="Modal__AlertText" id="mensaje">
				      No existe Relación Laboral
				</div>
				</center>
      </div>
        <div class="ContainerButtonsCenter">
		   <a  href="#" onclick="mostrarModalEleccion()" class="Submitx">ACEPTAR</a>
        </div>
    </div>
   </div>
   <div id="miModalFechaNac" class="Modal">
      <div class="ModalContainer" style="background-color: #E0e0e0;">
        <div class="ModalHeader">
        <h2 class="ModalTitle" id=""></h2>
        </div>
        <div class="Modal_Container" >
           <center>
				<div class="Modal__AlertText" id="mensaje">
				      El Trabajador no cuenta con la Edad Requerida para el Trámite
				</div>
				</center>
      </div>
        <div class="ContainerButtonsCenter">
		   <a  href="menuDisposicionTotal.do"  class="Submitx" id="botonFechaNac">ACEPTAR</a>
        </div>
    </div>
   </div>
   	<div id="errorValidarMarcaModal" class="Modal">
			<div class="ModalContainer">
				<div class="ModalHeader">
				<h2 class="ModalTitle" id="tituloError">${respuesta.titulo}</h2>
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
						      <a  href="#"  class="Submitx" id="btnModalMarcaAceptar" >ACEPTAR</a>
					    </div>
					</form>
				</div>
			</div>
		</div>
		
<!-- Modal Confirmación -->
      <div id="modalSolicitud9B" class="Modal">
        <div class="ModalContainer">
          <div class="ModalHeader">
          <h2 id="tituloModalSolicitud9B" class="ModalTitle"></h2>
          <a href="#" class="ModalButton">X</a>
          </div>
          <div class="Modal_Container">
			<div class="Modal__Admiracion">
              <img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
            </div>
            <div id="mensajeModalSolicitud9B" class="Modal__AlertText" style="width:50%;">
            </div>
          </div>
          <div>
            <div class="ModalFooter">
              <div class="ContainerButtonsCenter">
                <a id="continuarModalSolicitud9B" onclick="continuarSolicitudFlujo9B()" class="Submitx">Continuar</a>
                <a id="cancelarModalSolicitud9B" onclick="cancelarSolicitudFlujo9B()" class="Submitx">Cancelar</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- Modal Confirmación -->

      <!-- Modal Confirmación -->
      <div id="modalConfirmacion9B" class="Modal">
        <div class="ModalContainer">
          <div class="ModalHeader">
          <h2 id="tituloModalConfirmacion9B" class="ModalTitle"></h2>
<!--           <a href="#" class="ModalButton">X</a> -->
          </div>
          <div class="Modal_Container">
			<div class="Modal__Admiracion">
              <img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
            </div>
            <div id="mensajeModalConfirmacion9B" class="Modal__AlertText" style="width:50%;">
            </div>
          </div>
          <div>
            <div class="ModalFooter">
              <div class="ContainerButtonsCenter">
                <a id="continuarModalConfirmacion9B" onclick="continuarConfirmacionModal()" class="Submitx">Continuar</a>
                <a id="candelarModalConfirmacion9B" onclick="cancelarSolicitudFlujo9B()" class="Submitx">Cancelar</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      <div id="modalValidaCorreo" class="Modal" style="display:none;">
			<div class="ModalContainer">
				<div class="ModalHeader" id="tituloActExpValidaCorreo">
				</div>
				<div class="Modal__Admiracion">
					<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeActExpValidaCorreo"></div>
				<div id="botonesModalActExp" >
					<form class="ModalFooter">
					  
					  <input id="btnModalValidaCorreoSi" class="Submit" type="button" value="Si" />
					  <input id="btnModalValidaCorreoNo" class="Submit"  type="button" value="No" />
					</form>
				</div>
			</div>
	 </div>
	  <div id="modalValidaCorreoSaldos" class="Modal" style="display:none;">
			<div class="ModalContainer">
				<div class="ModalHeader" id="tituloActExpValidaCorreoSaldos">
				</div>
				<div class="Modal__Admiracion">
					<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeActExpValidaCorreoSaldos"></div>
				<div id="botonesModalActExp" >
					<form class="ModalFooter">
					  
					  <input id="btnModalValidaCorreoSiSaldos" class="Submit" type="button" value="Si" />
					  <input id="btnModalValidaCorreoNoSaldos" class="Submit"  type="button" value="No" />
					</form>
				</div>
			</div>
	 </div>
	  <div id="modalValidaCorreoImpresion" class="Modal" style="display:none;">
			<div class="ModalContainer">
				<div class="ModalHeader" id="tituloActExpValidaCorreoImpresion">
				</div>
				<div class="Modal__Admiracion">
					<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
				</div>
				<div class="Modal__AlertText" id="mensajeActExpValidaCorreoImpresion"></div>
				<div id="botonesModalActExp" >
					<form class="ModalFooter">
					  
					  <input id="btnModalValidaCorreoSiImpresion" class="Submit" type="button" value="Si" />
					  <input id="btnModalValidaCorreoNoImpresion" class="Submit"  type="button" value="No" />
					</form>
				</div>
			</div>
	 </div>
	
	<div id="exitoModalCambioCorreo" class="Modal" style="display:none;">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 id="tituloAlertaCambioCorreo" class="ModalTitle"></h2>
				</div>
				<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="<f:url value='/webResources/img/ok_icon.png'/>" alt="icon_alert" />
				</div>
				<div id="mensajeAlertaCambioCorreo" class="Modal__AlertText">
					
				</div>
				<div>
					<form class="ModalFooter">
					  <input id="btnExitoCambioCorreo" class="Submit" type="submit" value="Aceptar"/>
					</form>
				</div>
			</div>
	  </div>
	  <div id="infoModalReimpresion" class="Modal" style="display:none;">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 id="tituloAlertaCambioImpresion" class="ModalTitle"></h2>
				</div>
				<div class="Modal__IconAlertOK">
					<img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
				</div>
				<div id="mensajeAlertaCambioImpresion" class="Modal__AlertText">				
				</div>
				<div>
					<form class="ModalFooter">
					  <input id="btnInfoModalReimpresion" class="Submit" type="submit" value="Aceptar"/>
					</form>
				</div>
			</div>
	  </div>
	  <div id="errorModalReimpresion" class="Modal" style="display:none;">
			<div class="ModalContainer">
				<div class="ModalHeader">
				<h2 class="ModalTitle" id="tituloErrorReimpresion">${respuesta.titulo}</h2>
				<a href="#" class="ModalButton" id="btnErrorMReimpresion">X</a>
				</div>
				<div class="Modal__IconAlert">
					<img class="IconAlert" src="<f:url value='/webResources/img/warning.png'/>" alt="icon_alert" />
				</div>
				<div id="mensajeErrorModalReimpresion" class="Modal__AlertText">
					${respuesta.mensaje}
				</div>
			</div>
		</div>
      <!-- Modal Confirmación -->

      <!-- Modal Confirmación -->
      <div id="modalCancelacion9B" class="Modal">
        <div class="ModalContainer">
          <div class="ModalHeader">
          <h2 id="tituloModalCancelacion9B" class="ModalTitle"></h2>
          <a href="#" id="cerrarModalCancelacion9B" onclick="cerrarModalCancelar9B()" class="ModalButton">X</a>
          </div>
          <div class="Modal_Container">
			<div class="Modal__Admiracion">
              <img class="IconAlert" src="<f:url value='/webResources/img/icon_informativo.png'/>" alt="icon_alert" />
            </div>
            <div id="mensajeModalCancelacion9B" class="Modal__AlertText" style="width:50%;">
            </div>
          </div>
          <div>
            <div class="ModalFooter">
<!--               <div class="ContainerButtonsCenter"> -->
<!--                 <a id="btnCancelacion9B" class="Submitx">Continuar</a> -->
<!--                 <a href="modales_windows.html" class="Submitx">Cancelar</a> -->
<!--               </div> -->
            </div>
          </div>
        </div>
      </div>
      <!-- Modal Confirmación -->
      
      <!-- Modal de Aviso de privacidad -->
	  <div class="Modal" id="modalAvisoPrivPdf" style="display: none;">
		<div class="ModalContainerpdf">
			<div class="ModalHeader">
				<h2 class="ModalTitle">Aviso de Privacidad</h2>
				<a href="#" class="ModalButton" id="botonCerrarModal" onclick="ocultarAvisoPriv();">X</a>
			</div>
			<div class="Modal__Alertpdf">
				<div class="Datos_Container">
					<f:url value="${urlAvisoPrivacidad}" var="urlPdfAvisoPrivLocal"/>
					<iframe src="${urlPdfAvisoPrivLocal}" width="90%" height="500px" id="frameAvisoPrivPdf" style="display: none;"></iframe>
				</div>
			</div>
			
			<div class="ModalFooter">
               	<div class="ContainerButtons" id="contenedorPdf">
               		<a  href="#"  class="Submitx" id="btnModalAvisoPrivAceptar" onclick="ocultarAvisoPriv();"/>ACEPTAR</a>
               	</div>						
			</div>
		</div>
	</div>	
	<!-- Fin Modal de Aviso de privacidad -->
		<div id="errorTabModal" class="Modal">
			<div class="ModalContainer">
				<div id="errorTabModalHeader" class="ModalHeader">
				<h2 class="ModalTitle" id="tituloTabError">${respuesta.titulo}</h2>
				<a href="#" class="ModalButton" id="btnErrorM">X</a>
				</div>
				<div class="Modal__IconAlert">
					<img class="IconAlert" src="<f:url value='/webResources/img/warning.png'/>" alt="icon_alert" />
				</div>
				<div id="mensajeErrorTabModal" class="Modal__AlertText">
					${respuesta.mensaje}
				</div>
			</div>
		</div>
		
		<div id="errorModalUser" class="Modal">
			<div class="ModalContainer">
				<div id="errorModalHeader" class="ModalHeader">
				<h2 class="ModalTitle" id="tituloErrorUser"></h2>
				<a href="#" class="ModalButton" id="btnErrorM">X</a>
				</div>
				<div class="Modal__IconAlert">
					<img class="IconAlert" src="<f:url value='/webResources/img/warning.png'/>" alt="icon_alert" />
				</div>
				<div id="mensajeErrorModalUser" class="Modal__AlertText">
				</div>
			</div>
		</div>
		
	</section>
</body>
</html>
