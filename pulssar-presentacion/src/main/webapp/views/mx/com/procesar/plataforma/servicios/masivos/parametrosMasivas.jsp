<%@page import="java.util.Date"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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

table#tablaMasivosMinerva td {
	vertical-align: middle !important;
}

table#tablaMasivosMinerva tr {
	border-top: 2px solid transparent;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		obtenerModulosMasivos();
		inicializaFormulario();

		$('#datetimepicker1').datetimepicker({
			locale : 'es',
			format : 'DD/MM/YYYY',
			daysOfWeekDisabled : [ 0, 6 ],
			maxDate : new Date()
		});
		$('#datetimepicker2').datetimepicker({
			locale : 'es',
			format : 'DD/MM/YYYY',
			maxDate : new Date(),
			daysOfWeekDisabled : [ 0, 6 ],
			useCurrent : true
		});
		$("#datetimepicker1").on("dp.change", function(e) {
			$("#datetimepicker2").data("DateTimePicker").minDate(e.date);
			activaBtnConsultaMasivo();
		});

		$("#datetimepicker2").on("dp.change", function(e) {
			activaBtnConsultaMasivo();
		});

		$("#fechaInicial").keypress(function(evt) {
			evt.preventDefault();
		})
		$("#fechaFinal").keypress(function(evt) {
			evt.preventDefault();
		})
		$('#fechaInicial').bind('copy paste', function(e) {
			e.preventDefault();
			return false;
		});
		$('#fechaFinal').bind('copy paste', function(e) {
			e.preventDefault();
			return false;
		});
	});

	function consultarReporteMasivo() {
		$('#tipoArchivo').attr("disabled", false);
		$('#minervaForm').ajaxSubmit(
				{
					contentType : "multipart/form-data",
					beforeSend : function() {
						bloquearPantalla();
					},
					success : function(data) {
						if (data.exito == 1) {
							MinervaHelperDialogs
									.mostrarInformacion("Numero de Solicitud: "
											+ data.datos)
							obtenerSolicitudes();
						}
					},
					error : function(error) {
						MinervaHelperDialogs.mostrarError(error);
					},
					complete : function() {
						$('#tipoArchivo').attr("disabled", true);
						desBloquearPantalla();
					}
				});
	};

	function obtenerModulosMasivos() {
		var areas = "${employeeType}";
		url = "${pageContext.request.contextPath}/private/plataforma-operativa/obtenerModulos?areas="
				+ areas;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			dataType : 'json',
			url : url,
			timeout : 100000,
			async : false,
			beforeSend : function() {
				bloquearPantalla();
			},
			success : function(data) {
				listaModulos = data.datos.modulos;
				var options = CombosMasivos.options(listaModulos, 'idModulo',
						'nombreModulo');
				$("#moduloMasivo").html(options);
			},
			error : function(e) {
				MinervaHelperDialogs.mostrarError(data.mensaje);
			},
			complete : function() {
				desBloquearPantalla();
			}
		});
	};

	function cargaProcesosMasivos(idModulo) {
		var idModulo = $('#moduloMasivo').val();
		if (idModulo == "") {
			$("#procesoMasivo").attr('disabled', true);
			return;
		} else {
			$("#procesoMasivo").attr('disabled', false);
			fillNavyBarMasivo();
		}

		var data = "?idModulo=" + idModulo;

		url = "${pageContext.request.contextPath}/private/plataforma-operativa/obtenerReportesMasivos"
				+ data;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			dataType : 'json',
			url : url,
			timeout : 100000,
			async : false,
			beforeSend : function() {
				bloquearPantalla();
			},
			success : function(data) {
				listaProcesos = data.datos.procesos;
				var options = CombosMasivos.options(listaProcesos,
						'idProcesoNegocio', 'nombreProceso');
				$("#procesoMasivo").html(options);
			},
			error : function(e) {
				MinervaHelperDialogs.mostrarError(e);
			},
			complete : function() {
				desBloquearPantalla();
			}
		});
	};

	function cargaSubProcesoMasivos() {
		var idProceso = $('#procesoMasivo').val();

		if (idProceso == "") {
			$("#subProcesoMasivo").attr('disabled', true);
			return;
		} else {
			$("#subProcesoMasivo").attr('disabled', false);
			fillNavyBarMasivo();
		}

		var data = "?idProceso=" + idProceso;
		url = "${pageContext.request.contextPath}/private/plataforma-operativa/obtenerReportesMasivos"
				+ data;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			dataType : 'json',
			url : url,
			timeout : 100000,
			async : false,
			beforeSend : function() {
				bloquearPantalla();
			},
			success : function(data) {
				listaSubprocesos = data.datos.subprocesos;
				var options = CombosMasivos.options(listaSubprocesos,
						'idSubProceso', 'nombreSubProceso');
				$("#subProcesoMasivo").html(options);
				listaTipoReporte = data.datos.tiposReporte;
			},
			error : function(e) {
				MinervaHelperDialogs.mostrarError(e);
			},
			complete : function() {
				desBloquearPantalla();
			}
		});
	};

	function cargaReportesMasivos() {
		var idSubProceso = $("#subProcesoMasivo").val();
		var idTipoConsulta = $("#tipoReporteMasivo").val();

		if (idSubProceso == "") {
			$("#reporteMasivo").attr('disabled', true);
			return;
		} else {
			$("#reporteMasivo").attr('disabled', false);
			fillNavyBarMasivo();
		}

		var data = "?idSubProceso=" + idSubProceso + "&idTipoConsulta="
				+ idTipoConsulta;
		url = "${pageContext.request.contextPath}/private/plataforma-operativa/obtenerReportesMasivos"
				+ data;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			dataType : 'json',
			url : url,
			timeout : 100000,
			async : false,
			beforeSend : function() {
				bloquearPantalla();
			},
			success : function(data) {
				listaReportes = data.datos.reporteCompleto;
				var options = CombosMasivos.optionsReporteCompuesto(
						listaReportes, 'idReporteGenerico', 'nombreReporte');
				listaNombreReporte = data.datos.reporteGenerico;
				//var options = Combos.options(listaNombreReporte, 'idReporteGenerico', 'nombreReporte');
				$("#reporteMasivo").html(options);
			},
			error : function(e) {
				MinervaHelperDialogs.mostrarError(e);
			},
			complete : function() {
				desBloquearPantalla();
			}
		});
	};
</script>

<div class="panel panel-default">
	<form:form modelAttribute="plataformaOperativaForm"
		action="${pageContext.request.contextPath}/private/plataforma-operativa/consultamasivo"
		id="minervaForm" class="form-horizontal" method="post"
		enctype="multipart/form-data">

		<!-- MENU -->
		<div id="divMinervaMasivo" class="panel panel-default">

			<div class="form-group">
				<div class="col-sm-1"></div>
				<!-- Modulo -->
				<div class="col-sm-2">
					<label for="tituloModulo" class="control-label "
						style="font-color: #00395A;">M&oacute;dulo :&nbsp;</label> <select
						id="moduloMasivo" name="modulo" class="form-control"
						onchange="changeModuloMasivo(0);">
						<option value="-1" selected="selected">-- Seleccione una
							opci&oacute;n --</option>
					</select>
				</div>

				<!-- Proceso -->
				<div class="col-sm-2">
					<label for="tituloProcesos" class="control-label"
						style="font-color: #00395A;">Proceso :&nbsp;</label> <select
						id="procesoMasivo" name="proceso" class="form-control"
						disabled="disabled" onchange="changeProcesoMasivos();">
						<option value="-1" selected="selected">-- Seleccione una
							opci&oacute;n --</option>
					</select>
				</div>

				<!-- Subproceso -->
				<div class="col-sm-2">
					<label for="tituloSubProceso" class="control-label"
						style="font-color: #00395A;">SubProceso :&nbsp;</label> <select
						id="subProcesoMasivo" name="subProceso" class="form-control"
						disabled="disabled" onchange="changeSubProcesoMasivo();">
						<option value="-1" selected="selected">-- Seleccione una
							opci&oacute;n --</option>
					</select>
				</div>

				<!-- TipoReporte -->
				<div class="col-sm-2">
					<label for="tituloTipoReporte" class="control-label"
						style="font-color: #00395A;">&nbsp; &nbsp;Tipo :&nbsp;</label> <select
						id="tipoReporteMasivo" name="tipoReporte" class="form-control"
						disabled="disabled" onchange="changeTipoReporteMasivo();">
						<option value="-1" selected="selected">-- Seleccione una
							opci&oacute;n --</option>
					</select>
				</div>

				<!-- Reporte -->
				<div class="col-sm-2">
					<label for="tituloNombreReporte" class="control-label"
						id="lblMinerva">Reporte :&nbsp;</label> <select id="reporteMasivo"
						name="reporte" class="form-control" disabled="disabled"
						onchange="changeReporteMasivo(); activaParamestros();">
						<option value="-1" selected="selected">-- Seleccione una
							opci&oacute;n --</option>
					</select>
				</div>
			</div>
		</div>
		<!-- FIN MENU -->

		<div class="panel panel-default">
			<div>
				<table id="tablaMasivosMinerva" class="table table-striped"
					style="margin-top: 2%;">
					<div class="panel-info">
						<tr>
							<td class="col-sm-1"></td>
							<td class="etiqueta"><label for="fechaInicialMinerva"
								class="control-label">Fecha Inicial:&nbsp;</label></td>
							<td>
								<div class="input-group date col-sm-10" id="datetimepicker1">
									<form:input type="text" id="fechaInicial" data-toggle="tooltip"
										data-placement="right" title="Fecha a 10 posiciones"
										placeholder="Fecha a 10 posiciones" cssClass="form-control"
										path="fechaInicial" minLength="10" maxlength="10"
										onblur="activaBtnConsultaMasivo();" />
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"
										onblur="activaBtnConsulta();"> </span>
									</span>
								</div>
							</td>
							<td class="etiquetaInterna"><label for="fechaFinalMinerva"
								class="control-label">Fecha Final:&nbsp;</label></td>
							<td>
								<div class="input-group date col-sm-10" id="datetimepicker2">
									<form:input type="text" id="fechaFinal" data-toggle="tooltip"
										data-placement="right" title="Fecha a 10 posiciones"
										placeholder="Fecha a 10 posiciones" cssClass="form-control"
										path="fechaFinal" minLength="10" maxlength="10"
										onblur="activaBtnConsultaMasivo();" />
									<span class="input-group-addon"> <span
										class="glyphicon glyphicon-calendar"
										onblur="activaBtnConsulta();"> </span>
									</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="col-sm-1"></td>
							<td class="etiqueta"><label class="control-label"
								for="archivoAProcesar">Archivo a Procesar:</label></td>
							<td>
								<div class="input-group col-sm-10">
									<div class="fileinput fileinput-new" data-provides="fileinput">
										<span class="btn btn-primary btn-file disabled"
											id="fileInputTag"> <span class="fileinput-new">Seleccionar
												Archivo</span> <span class="fileinput-exists">Cambiar</span> <form:input
												path="archivoProcesar" id="archivoAProcesar" type="file"
												accept=".txt" name="archivoProcesar"
												onchange="$('#errorArchivoProcesar').html(''); $('#spanArchivoProcesar').html('');" />

										</span> <span class="fileinput-filename"></span> <a href="#"
											class="close fileinput-exists" data-dismiss="fileinput"
											style="float: none">×</a>
									</div>
									<form:errors id="errorArchivoProcesar" path="archivoProcesar"
										cssClass="error" />
									<span id="spanArchivoProcesar" path="archivoProcesar"
										class="error"></span>
								</div>
							</td>
							<td class="etiquetaInterna"><label for="tipoArchivoSel"
								class="control-label">Tipo de Archivo:</label></td>
							<td>
								<div class="input-group col-sm-10">
									<form:select id="tipoArchivo" class="form-control"
										data-toggle="tooltip" data-placement="right"
										title="Seleccione una opción" path="tipoArchivo"
										name="tipoArchivo">
										<form:option value="-1">N/A</form:option>
										<form:option value="0">CURP</form:option>
										<form:option value="1">NSS</form:option>
										<form:option value="2">ID PROCESAR</form:option>
									</form:select>
									<span path="tipoArchivo" class="error"></span>
								</div>
							</td>
						</tr>
					</div>
				</table>
			</div>
			<div>
				<div class="form-group" align="center">
					<button id="enviarBtn" type="button"
						class="btn btn-primary disabled" onclick="validar();">Consultar</button>
				</div>
			</div>
		</div>
	</form:form>
</div>
