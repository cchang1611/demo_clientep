<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<style type="text/css">
	.maxWidthTd {
		width: 19% !important;
		height: 6em;
		padding: 10px 1px 10px 10px;
		display: inline-block;
	}
	
	.maxWidthTd>select {
		width: 100% !important;
		/*     	width: 200px !important; */
		overflow: hidden !important;
		text-overflow: ellipsis;
		white-space: nowrap;
		word-wrap: break-word;
	}
	
	table#tablaMasivosMinerva td {
		vertical-align: middle !important;
	}
	
	td.etiqueta {
		text-align: right;
		width: 15%;
	}
	
	td.etiquetaInterna {
		text-align: right;
		width: 11%;
	}
</style>

<div class="panel panel-default">
	<div id="divMinerva">
		<div class="form-group">
			<!-- Modulo -->
			<div class="col-sm-2 maxWidthTd">
				<label for="tituloModulo" class="control-label "
					style="font-color: #00395A;">M&oacute;dulo :&nbsp;</label> <select
					id="modulo" name="modulo" class="form-control"
					onchange="changeModulo(); habilitaLimpiarNomRepo(); ">
					<option value="-1" selected="selected"> -- Seleccione una opci&oacute;n --</option>
				</select>
			</div>

			<!-- Proceso -->
			<div class="col-sm-2 maxWidthTd">
				<label for="tituloProcesos" class="control-label"
					style="font-color: #00395A;">Proceso :&nbsp;</label> <select
					id="proceso" name="proceso" class="form-control"
					disabled="disabled"
					onchange="changeProceso(); habilitaLimpiarNomRepo();">
					<option value="-1" selected="selected"> -- Seleccione una opci&oacute;n --</option>
				</select> 
			</div>

			<!-- Subproceso -->
			<div class="col-sm-2 maxWidthTd">
				<label for="tituloSubProceso" class="control-label"
					style="font-color: #00395A;">SubProceso :&nbsp;</label> <select
					id="subProceso" name="subProceso" class="form-control"
					disabled="disabled"
					onchange="changeSubProceso(); habilitaLimpiarNomRepo();">
					<option value="-1" selected="selected"> -- Seleccione una opci&oacute;n --</option>
				</select>
			</div>

			<!-- TipoReporte -->
			<div class="col-sm-2 maxWidthTd">
				<label for="tituloTipoReporte" class="control-label"
					style="font-color: #00395A;">&nbsp; &nbsp;Tipo :&nbsp;</label> <select
					id="tipoReporte" name="tipoReporte" class="form-control"
					disabled="disabled"
					onchange="changeTipoReporte(); habilitaLimpiarNomRepo();">
					<option value="-1" selected="selected"> -- Seleccione una opci&oacute;n --</option>
				</select>
			</div>

			<!-- Reporte -->
			<div class="col-sm-2 maxWidthTd">
				<label for="tituloNombreReporte" class="control-label"
					id="lblMinerva">Reporte :&nbsp;</label> <select id="nombreReporte"
					name="nombreReporte" class="form-control" disabled="disabled"
					onchange="changeReporte(); habilitaLimpiarNomRepo(); ">
					<option value="-1" selected="selected"> -- Seleccione una opci&oacute;n --</option>
				</select>
			</div>
		</div>
	</div>
</div>