<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.css'/>">	    
<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.min.js'/>"></script>	
									
</head>
<body>
<div id="montoADisponer"  class="Modal" style="display:none; opacity:1; pointer-events:visible;">
	<div class="ModalContainer">
		<div class="ModalHeader">
			<c:if test="${tipoTramite eq 'RO'}">
				<h2 id="tituloFormaPago" class="ModalTitle">ISSSTE - Cuenta Individual</h2>
			</c:if>
			<c:if test="${tipoTramite eq 'DT'}">
				<h2 id="tituloFormaPago" class="ModalTitle">ISSSTE - Cuenta D&eacute;cimo Transitorio</h2>
			</c:if>
			
			<a href="#" class="ModalButton" onclick="cerrarWae();">X</a>
		</div>
		<div class="ModalText">
			<div class="Container_Section">
				<c:if test="${tipoTramite eq 'RO'}">
					<table class="table table-striped table-bordered">
						<thead>
							<tr  class="RowHeader">
								<th colspan="5">MONTO ESTIMADO A PAGAR</th>
							</tr>
							<tr class="RowHeader">
								<th colspan="2">SALARIO BASE DE COTIZACION</th>
								<th colspan="2">SUBCUENTAS RCV</th>
								<th rowspan="2">MONTO ESTIMADO A PAGAR</th>
							</tr>
							<tr class="RowHeader">
								<th>SALARIO BASE DE COTIZACI&Oacute;N</th>
								<th>75 D&Iacute;AS SBC</th>
								<th>RCV</th>
								<th>10%RCV</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${saldos['sbc']}</td>
								<td>${saldos['sbc75']}</td>
								<td>${saldos['rcv']}</td>
								<td>${saldos['rcv10Pct']}</td>
								<td>${saldos['montoEstimado']}</td>
							</tr>
						</table>
					</table>
				</c:if>
				<c:if test="${tipoTramite eq 'DT'}">
					<table class="table table-striped table-bordered">
						<thead>
							<tr  class="RowHeader">
								<th colspan="3">MONTO ESTIMADO A PAGAR</th>
							</tr>
							<tr class="RowHeader">
								<th >SARISSSTE</th>
								<th >10% SARISSSTE</th>
								<th >MONTO ESTIMADO A PAGAR</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${saldos['sarissste']}</td>
								<td>${saldos['sarissste10Pct']}</td>
								<td>${saldos['montoEstimado']}</td>
							</tr>
						</table>
					</table>
				</c:if>
				
			</div>
		</div>
							
	</div>
</div>
</body>
</html>