<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Saldos del Trabajador</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Consulta del Trabajador" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "5" />
	</jsp:include>
	<script type="text/javascript">		
		var _REFERENCIAS = "";
		var _BENEFICIARIOS = "";
		var _MARCAS = "${marcas}";
		var _FLUJO="";
		var _CURPS = "";
	</script>
	<div class="wrapper">
		<section>
			<div class="Title__Container">
				<h1>Salario y Saldos</h1>
			</div>
			
			<div class="Container">
				<div class="Layout__XL">
					<div class="Title">
						<p>Salario</p>
					</div>
					<div class="Datos_Container">
						<div class="row_container">
							<div class="Datosxxl"><strong>Salario Diario Integrado: </strong>$ ${salario}</div>
							<div class="Datosxxl"><strong>Periodo de Pago: </strong> ${periodo}</div>
						</div>
					</div>
					<div class="Title">
						<p>Saldos</p>
					</div>
					<c:choose>
						<c:when test="${not empty saldos.motivoRechazo}">
							<div class="Datos_Container">
								<div class="row_container">
									<div class="Datosxxl"><strong>${saldos.descripcion}</strong></div>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="Container_Three">
								<div class="row_containerfloat">
									<table>
										<tr class="RowHeader">
											<th>Saldo</th>
											<th>Monto</th>
										</tr>
										<tr class="Row1" id="saldoSar">
											<td>Sar 92</td>
											<td>${saldos.saldoSar92}</td>
										</tr>
										<tr class="Row2" id="saldoRetiro">
											<td>Retiro 97</td>
											<td>${saldos.saldoRetiro97}</td>
										</tr>
										<tr class="Row1" id="saldoCuota">
											<td>Cuota Social</td>
											<td>${saldos.saldoCuotaSocial}</td>
										</tr>
										<tr class="Row2" id="saldoCesanti">
											<td>Cesantia Vejez</td>
											<td>${saldos.saldoCesantiaVejez}</td>
										</tr>
										<tr class="Row1" id="saldoVivienda">
											<td>Vivienda 97</td>
											<td>${saldos.saldoVivienda97}</td>
										</tr>
										<tr class="Row2" id="saldoViviendaA">
											<td>Vivienda 97 AIVS</td>
											<td>${saldos.saldoVivienda97AIVS}</td>
										</tr>
										<tr class="Row1" id="saldoViviendaN">
											<td>Vivienda 92</td>
											<td>${saldos.saldoVivienda92}</td>
										</tr>
										<tr class="Row2" id="saldoViviendaI">
											<td>Vivienda 92 AIVS</td>
											<td>${saldos.saldoVivienda92AIVS}</td>
										</tr>
										<tr class="Row1" id="saldoViviendaR">
											<td>Ahorro Retiro IB</td>
											<td>${saldos.saldoAhorroRetiroIB}</td>
										</tr>
										<tr class="Row2" id="saldoA">
											<td>Aportaciones Voluntarias</td>
											<td>${saldos.saldoAportacionesVoluntarias}</td>
										</tr>
										<tr class="Row1" id="saldoR">
											<td>Retiro 92 I</td>
											<td>${saldos.saldoRetiro92I}</td>
										</tr>
										<tr class="Row2" id="cuota">
											<td>Cuota Social I</td>
											<td>${saldos.saldoCuotaSocialI}</td>
										</tr>
									</table>
								</div>
								<div class="row_containerfloat">
									<table>
									  <tr class="RowHeader">
										<th>Saldo</th>
										<th>Monto</th>
									  </tr>
									  <tr class="Row1" id="saldoCom">
										<td>Aporta CompRetiro</td>
										<td>${saldos.saldoAportaCompRetiro}</td>
									  </tr>
									  <tr class="Row2" id="saldoF">
										<td>Vivienda FI 92</td>
										<td>${saldos.saldoViviendaFI92}</td>
									  </tr>
									  <tr class="Row1" id="saldoVf">
										<td>Vivienda FI 92 AIVS</td>
										<td>${saldos.saldoViviendaFI92AIVS}</td>
									  </tr>
									  <tr class="Row2" id="saldoLargo">
										<td>Aporta Largo Plazo</td>
										<td>${saldos.saldoAportaLargoPlazo}</td>
									  </tr>
									  <tr class="Row1" id="saldoF">
										<td>FI 08</td>
										<td>${saldos.saldoFI08}</td>
									  </tr>
									  <tr class="Row2" id="saldoFi">
										<td>FI 08 AIVS</td>
										<td>${saldos.saldoFI08AIVS}</td>
									  </tr>
									  <tr class="Row1" id="saldoRi">
										<td>Retiro I 08</td>
										<td>${saldos.saldoRetiroI08}</td>
									  </tr>
									  <tr class="Row2" id="saldoCv">
										<td>CVI</td>
										<td>${saldos.saldoCVI}</td>
									  </tr>
									  <tr class="Row1" id="ahorroS">
										<td>Ahorro Solidario</td>
										<td>${saldos.saldoAhorroSolidario}</td>
									  </tr>
									  <tr class="Row2" id="bono">
										<td>Bono Monto UDIS</td>
										<td>${saldos.saldoBonoMontoUDIS}</td>
									  </tr>
									</table>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
					<div style="font-size: 12px;">
						 *La información del Salario corresponde a la última aportación dispersada de acuerdo a la Recaudación
					</div>
				</div>
			</div>
			<jsp:include page="../menus/menuConsulta.jsp" />
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<div class="Pestana" id="pestanaMarcas">
		<div class="PestanaContainer">
		  <a href="#" id="titulo" onclick="mostrar('detalle')" class="PestanaTitle">
			<p>Marcas Operativas</p>
		  </a>
		  <div id="detalle" class="PestanaTableContainer">
			<div class="PestanaTitleContainer">Descripción</div>
			<div class="PestanasCarousel" id="marcasTrabajador">
			</div>
		  </div>
		</div>
	</div>
	
	<script src="<c:url value='/webResources/js/cargaRefBen.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
</body>
</html>
