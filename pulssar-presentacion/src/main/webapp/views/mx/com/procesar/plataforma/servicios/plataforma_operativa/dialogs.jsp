<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Mensajes de exito -->
<div id="successModal" class="modal fade" role="dialog"><!-- inicia Modal -->
  <div class="modal-dialog"><!-- caja de dialogo -->
    <!-- content-->
    <div class="modal-content">
      
      <!-- header -->
      <div class="modal-header modal-header-minerva">
         <h4 class="modal-title">PLATAFORMA DE SERVICIOS OPERATIVA</h4>
      </div>
      
      <!-- body -->
      <div class="modal-body">
        <p id="mensajeExito">
        	Algún texto en el cuerpo del modal.
        </p>
      </div>
      
      <!-- footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnSuccess" onclick="">Cerrar</button>
      </div>
      
    </div>
  </div><!-- fin caja de dialogo -->
</div><!-- fin de modal -->

<!-- Mensajes de error para export detalle -->
<div id="errorExportModal" class="modal fade" role="dialog"><!-- inicia Modal -->
  <div class="modal-dialog"><!-- caja de dialogo -->
    <!-- content-->
    <div class="modal-content">
      
      <!-- header -->
      <div class="modal-header btn-danger">
         <h4 class="modal-title">PLATAFORMA DE SERVICIOS OPERATIVA</h4>
      </div>
      
      <!-- body -->
      <div class="modal-body">
        <p id="mensajeExport">
        	Algún texto en el cuerpo del modal.
        </p>
      </div>
      
      <!-- footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnCerrar" onclick="">Cerrar</button>
      </div>
      
    </div>
  </div><!-- fin caja de dialogo -->
</div><!-- fin de modal -->

<!-- Mensajes de error -->
<div id="errorModal" class="modal fade" role="dialog"><!-- inicia Modal -->
  <div id="modalBodyErrorRoot" class="modal-dialog"><!-- caja de dialogo -->
    <!-- content-->
    <div class="modal-content">
      
      <!-- header -->
      <div class="modal-header btn-danger">
         <h4 class="modal-title">PLATAFORMA DE SERVICIOS OPERATIVA</h4>
      </div>
      
      <!-- body -->
      <div class="modal-body" id="modalBodyError" style="">
        <p id="mensajeError">
        	Algún texto en el cuerpo del modal.
        </p>
        <br>
      	<br>
        <p id="trazaError" style="display:none;" class="minerva-traza-error"></p>
      </div>
      
      <!-- footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnError" onclick="">Cerrar</button>
      </div>
      
    </div>
  </div><!-- fin caja de dialogo -->
</div><!-- fin de modal -->
