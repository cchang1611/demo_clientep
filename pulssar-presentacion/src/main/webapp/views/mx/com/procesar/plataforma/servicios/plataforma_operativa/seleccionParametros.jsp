<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="divMinervaFechas" align="center" hidden="true" class="panel panel-default">
		<br>
		<table id="tablaFechasMinerva">
			<thead>
				<tr>
					<td colspan="5"></td>
				</tr>
				<tr>
					<td colspan="5">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="5">&nbsp;</td>
				</tr>
				<tr>
				<td>
					<label for="fechaInicialMinerva" class="control-label">Fecha inicial :&nbsp;</label>
				</td>
				<td>
					<div class="input-group date" id="datetimepicker1">
						<form:input type="text" id="fechaInicial" data-toggle="tooltip"
						data-placement="right" title="Fecha a 10 posiciones"
						placeholder="Fecha a 10 posiciones" cssClass="form-control"
						path="fechaInicial" minLength="10" maxlength="10" onblur="activaBtnConsulta(); changeFechaInicio();"/>
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar" onblur="activaBtnConsulta();"></span>
						</span>
			    	</div>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					<label for="fechaFinalMinerva" class="control-label">Fecha final :&nbsp;</label>
				</td>
				<td>
					<div class="input-group date" id="datetimepicker2">
						<form:input type="text" id="fechaFinal" data-toggle="tooltip"
						data-placement="right" title="Fecha a 10 posiciones"
						placeholder="Fecha a 10 posiciones" cssClass="form-control"
						path="fechaFinal" minLength="10" maxlength="10" onblur="activaBtnConsulta();"/>
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-calendar" onblur="activaBtnConsulta();"></span>
						</span>
					</div>
				</td>
			</tr>
		   </thead>
		</table>
		<br></br>
		<br></br>
			<!-- LISTAS -->
		<table id="tablaTextAreasMinerva">			
			<tr>
				<td id="tdTxaNss">
					<div align="center"><label for="nssMinerva" class="control-label" id="lblNss">Lista de NSS</label></div><br></br>
					<div align="center"><form:textarea id="textAreaNssMinerva" path="nss" rows="11" cols="15" cssClass="width : 30px; height:100px;" onchange="validaTextAreaNss();validaCamposConsulta();" onkeypress="return soloNumeros(event);"/></div>
				</td>
				<td id="spNss">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td id="tdTxaCurp">
					<div align="center"><label for="curpMinerva" class="control-label" id="lblCurp">Lista de CURP</label></div><br></br>
					<div align="center"><form:textarea id="textAreaCurpMinerva" path="curp" rows="11" cols="28" cssClass="width : 30px; height:100px;" onchange="validaTextAreaCurp();validaCamposConsulta();"/></div>
				</td>
				<td id="spCurp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td colspan="2" id="tdTxaIdPro">
					<div align="center"><label for="idProcesarMinerva" class="control-label" id="lblIdProcesar">ID Procesar</label></div><br></br>
					<div align="center"><form:textarea id="textAreaIdProMinerva" path="idProcesar" rows="11" cols="13" cssClass="width : 30px; height:100px;" onchange="validaTextAreaIdProcesar();validaCamposConsulta();" onkeypress="return soloNumeros(event);"/></div>
					
				</td>
			</tr>
			<tr>
				<td colspan="5">&nbsp;</td>
			</tr>
			<tr>
				<td colspan="5">&nbsp;</td>
			</tr>
		</table>
	</div>
	<div id="divFormularioDinamico" align="center" class="panel panel-default">
		<br>
		<table id="tablaFormularioDinamico">
			<thead>
				
		   </thead>
		   <tr id="templateFechas" style="display:none;height: 50px">
					<td>
						<label for="nombreParametro" class="control-label" id="labelNombreParametro">nombreParametro :&nbsp;</label>
					</td>
					<td style="padding-left: 10px">
						<div class="input-group date fechas" id="datetimepickerNombreParametro">
							<form:input type="text" id="nombreParametro" data-toggle="tooltip"
							data-placement="right" title="Fecha a 10 posiciones"
							placeholder="Fecha a 10 posiciones" cssClass="form-control"
							path="" minLength="10" maxlength="10" onblur="activaBtnConsulta();"/>
							<span class="input-group-addon">
								<span class="glyphicon glyphicon-calendar" onblur="activaBtnConsulta();"></span>
							</span>
				    	</div>
					</td>
			</tr>
			<tr id="templateTexto" style="display:none;height: 50px">
					<td>
						<label for="nombreParametroTexto" class="control-label" id="labelNombreParametroTexto">nombreParametro :&nbsp;</label>
					</td>
					<td style="padding-left: 10px">
						<form:input type="text" id="nombreParametro" data-toggle="tooltip"
						data-placement="right" style="width:100%" 
						placeholder="Ingrese el valor requerido" cssClass="form-control"
						path="" onblur="activaBtnConsulta();"/>
					</td>
			</tr>
		</table>
		<div style="padding: 20px">
			<button id="btnExportarPdfPrueba" type="button" class="btn btn-primary btn-default" onclick="exportaResultadoPlantillaDummy();" style="display: none">Consultar</button>
		</div>
	</div>