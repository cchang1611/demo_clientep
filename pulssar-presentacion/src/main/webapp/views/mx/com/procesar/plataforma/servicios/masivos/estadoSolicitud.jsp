<%@page import="java.util.Date"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/util/js/plataforma_operativa/masivo.js'/>?<%= new Date().getTime() %>"></script>

<style type="text/css">
.maxWidthTd {
	width: 19% !important;
	height: 6em;
	padding: 10px 1px 10px 10px;
	display: inline-block;
}

.maxWidthTd>select {
	width: 80% !important;
	overflow: hidden !important;
	text-overflow: ellipsis;
	white-space: nowrap;
	word-wrap: break-word;
}
table#tablaMinervaSolicitudes td{
	vertical-align:middle !important; 
}
table#tablaMinervaSolicitudes tr{
	border-top: 2px solid transparent;
}
table#tabResultadoDocacuse td{
	vertical-align:middle !important;
	text-align:center !important; 
}

.descarga{
	text-decoration: underline;
	cursor: pointer;
}

.descargaDisabled{
	color: currentColor;
	opacity: 0.5;
	text-decoration: none;
	
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		obtenerSolicitudes();
	
		$('#datetimepicker6a').datetimepicker({
			locale : 'es',
			format : 'DD/MM/YYYY',
			maxDate : new Date(),
			daysOfWeekDisabled : [ 0, 6 ],
			useCurrent : false
		});
		$('#datetimepicker6b').datetimepicker({
			locale : 'es',
			format : 'DD/MM/YYYY',
			maxDate : new Date(),
			daysOfWeekDisabled : [ 0, 6 ],
			useCurrent : false
		//Important! See issue #1075
		});
		$("#datetimepicker6a").on("dp.change", function(e) {
			$('#datetimepicker6b').data("DateTimePicker").minDate(e.date);
			activaBtnConsultaSolicitud();
		});
		$("#datetimepicker6b").on(
				"dp.change",
				function(e) {
					$('#datetimepicker6a').data("DateTimePicker").maxDate(
							e.date);
					var maximoFechaInicio = new Date(e.date);
					var minimoFechaInicio = new Date(maximoFechaInicio
							.getFullYear(), maximoFechaInicio.getMonth(),
							maximoFechaInicio.getDate() - 30);
					$('#datetimepicker6a').data("DateTimePicker").minDate(
							minimoFechaInicio);
					
					activaBtnConsultaSolicitud()
				});
		$("#fechaInicio").keypress(function(evt) {
			evt.preventDefault();
		})
		$("#fechaFin").keypress(function(evt) {
			evt.preventDefault();
		})
	});
	
	function obtenerSolicitudes(){
		url = "${pageContext.request.contextPath}/private/plataforma-operativa/obtenerSolicitudes";
		$.ajax({
			type: "GET",
			contentType: "application/json",
			dataType : 'json',
			url: url,
			timeout: 100000,
			async: false,
			beforeSend : function() {
				bloquearPantalla();
			},
			success: function(data){
				var lista = data.datos;
				var options = CombosMasivos.options(lista, 'idSolicitud', 'numeroSolicitud');
				$("#numSolicitudSel").html(options);
			},
			error: function(e){
				MinervaHelperDialogs.mostrarError(data.mensaje);
			},
			complete : function(){
				desBloquearPantalla();
			}
		});
	};
	
	function consultar(){
	
		var numSolicitudSel = $('#numSolicitudSel').val();
		var idEstadoSel = $('#idEstadoSel').val();
		var fechaInicio = $('#fechaInicio').val();
		var fechaFin = $('#fechaFin').val();
		
		if( ( fechaInicio.trim() == "" && fechaFin.trim() != "" ) 
		||  ( fechaInicio.trim() != "" && fechaFin.trim() == "" ) )
		{
			MinervaHelperDialogs.mostrarError("Debe ingresar el periodo a consultar");
			return;
		}else{
			var data = "?numSolicitudSel=" + numSolicitudSel + 
						"&idEstadoSel=" + idEstadoSel +
						"&fechaInicio=" + fechaInicio + 
						"&fechaFin=" + fechaFin;
		
			var action = "${pageContext.request.contextPath}/private/plataforma-operativa/consultasolicitud"+ data;
			
			$.jgrid.gridUnload("tabResultadoDocacuse");
			
			$.ajax({
					type: "GET",
					url: action,
					contentType: "application/json",
					timeout: 100000,
					async: false,
					beforeSend : function() {
		                    bloquearPantalla();
		            },
					success: function(data)
						{
							console.log("EXITO");
							if(data.exito == 1)
							{	
								listaDetalle = data.datos;
								cargaGrid(listaDetalle);
							}
							else
							{
								MinervaHelperDialogs.mostrarInformacion("No se encontraron solicitudes para la búsqueda");
							}
							$('#consultarBtn').removeAttr('disabled');
						},
					error: function(e)
						{
							MinervaHelperDialogs.mostrarError(e);
							$('#consultarBtn').removeAttr('disabled');
							console.log("ERROR", e);
						},
		            complete : function(){
		                    desBloquearPantalla();
		            }
				});
		}
	}
</script>

<div class="panel panel-default">
	<form id="form-minerva-masivos" class="form-horizontal">
		<div id="divMinervaSolicitudes"  class="panel-info">
			<table id="tablaMinervaSolicitudes" class="table table-striped">
				<div>
					<tr>
						<td class="etiqueta"><label for="numSolicitud" class="control-label">Número de Solicitud:&nbsp;</label></td>
						<td>
							<div class="input-group col-sm-10">
								<select id="numSolicitudSel" class="form-control"
										data-toggle="tooltip" data-placement="right"
										title="Seleccione una opción" name="numSolicitudSel"
										onchange="changeNumSolicitud(); activaBtnConsultaSolicitud();">
									<option value="">-- Seleccione opción --</option>
								</select>
							</div>
						</td>
						
						<td class="etiqueta"><label for="numSolicitud" class="control-label">Estado de Solicitud:&nbsp;</label></td>
						<td>
							<div class="input-group col-sm-10">
								<select id="idEstadoSel" class="form-control"
										data-toggle="tooltip" data-placement="right"
										title="Seleccione una opción" name="idEstadoSel"
										onchange="changeEstado(); activaBtnConsultaSolicitud();">
									<option value="">-- Seleccione opción --</option>
									<c:if test="${ not empty listaEstados }">
										<c:forEach var="estado" items="${ listaEstados }">
											<option value="${ estado.isEstadoSolicitud }">${ estado.descripcion }</option>
										</c:forEach>
									</c:if>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td class="etiqueta"><label for="fechaInicioSel" class="control-label">Fecha Inicial:&nbsp;</label></td>
						<td>
					    	<div class="input-group date col-sm-10" id="datetimepicker6a">		
								<input id="fechaInicio" name="fechaInicio" class="form-control" type="text">
					            <span class="input-group-addon">
					         	  	<span class="glyphicon glyphicon-calendar"></span>
					            </span>
					         </div>
				    	</td>
						
						
						<td class="etiquetaInterna"><label for="fechaFinSel" class="control-label">Fecha Final:&nbsp;</label></td>
				    	<td>
							<div class="input-group date col-sm-10" id="datetimepicker6b">		
								<input id="fechaFin" name="fechaFin" class="form-control" type="text">
					        	<span class="input-group-addon">
					            	<span class="glyphicon glyphicon-calendar"></span>
					            </span>
						    </div>
						</td>
						<td>
							&nbsp
						</td>
					</tr>
				</div>
			</table>
		</div>	
	</form>
	
	<div>
		<div class="form-group" align="center">
				<button id="consultarBtn" type="button"  class="btn btn-primary disabled" onclick="consultar();">Consultar</button>
				<button id="limpiarBtn" type="button"  class="btn btn-primary disabled" onclick="inicializarFormularioSolicitud();">Limpiar</button>
		</div>
	</div>
	
	<div>
		<div id="divResDocAcuse" class="table-responsive minerva-table">
			<table id="tabResultadoDocacuse" border="1" class="table table-bordered table-striped"> </table>
		<div id="pager"></div>
	</div>
</div>
	
	
</div>

