<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page
	import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>RETIROS</title>
<meta charset="utf-8" />
<![if IE]>
<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
<![endif]>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tablesDisposicionTotal.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bootstrap_tables_dynamic.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/dataTables.bootstrap.min.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datepiker/datepiker.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datepiker/datepiker2.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.css'/>">
	
	

	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.min.js'/>"></script>		   
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dataTables.bootstrap.min.js'/>"></script>

	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/datepiker.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/datepiker2.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/disposicion_total_issste.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/disposicion_total_issste_subcuentas.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/disposicion_total_issste_expediente_servicio.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/disposicion_total_issste_beneficiarios.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
	
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
	
	
</head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
FolioEntrada folio = datos.getFolio();
%>
<body>
	<input type="hidden" id="mensaje" value="${mensaje}" />
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Solicitud de Tr&aacute;mite" />
		<jsp:param name="menuPrimario" value="2" />
		<jsp:param name="menuSecundario" value="2" />
		<jsp:param name="menuInactivo" value="1" />
	</jsp:include>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
		var estatus = "${estatus}";
		var banderaIssste = "${banderaIssste}";
		var datosResolucion = "${datosResolucion}";
		var _MENSAJE = "${respuesta.mensaje}";
		var _TITULO = "${respuesta.titulo}";
		var _EDAD = "${edadTrabajador}";
	</script>
	<div class="wrapper">
		<div class="Container">
			<div class="Layout__XL">
				<br />
				<div class="Title">
					<p>Selección de Derecho</p>
				</div>

				<div class="Line"></div>
				<div class="Datos_Container">
					<form:form id="fm_datosDisposicionIssste" method="POST" modelAttribute="consulta" action="#">
						<div class="Datos_ContainerColumn" id="divNrp">
							<div class="row_container">
								<div class="Section">
									<div style="width: 100%; max-width: 480px;">
										<div class="Form__Group">
											<label class="LabelText" for="usuario">Número de Registro del Plan Privado de Pensiones:</label>
											<input class="Inputxxl" id="nrp" type="text" name="" value=""
												onKeyPress="return soloNumeros(event,this)"
												placeholder="Número de Registro del Plan Privado de Pensiones"
												noPaste="true" maxlength="8">
										</div>
									</div>
									<div style="width: 100%; max-width: 480px;">
										<div class="Form__Group">
											<label class="LabelText" for="usuario">Actuario autorizado:</label> 
											<input class="Inputxxl" id="actuarioAu"
												type="text" name="" value=""
												onKeyPress="return soloNumeros(event,this)"
												placeholder="Actuario autorizado" noPaste="true">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="Datos_Container">
							<div class="Form__Group" id="divRegimenPrincipal">
								<label class="Label_longtext" id="labelReg" for="usuario">Clave de Regimen*:</label> 
								<select id="regimen" class="Select_longtext" ></select>
							</div>
							<div class="Form__Group">
								<label class="Label_longtext" for="usuario">Tipo de Retiro*:</label> 
								<select id="retiro" class="Select_longtext" ></select>
							</div>

							<div class="Form__Group" id="divRegimen">
								<label class="Label_longtext" id="labelRegPlanPrivado" for="usuario">Clave de Regimen*:</label> 
								<select id="regimenPlanPrivado" class="Select_longtext" onchange="llenarSeguroComboPlan()"></select>
							</div>
							<div class="Form__Group">
								<label class="Label_longtext" for="usuario">Tipo de Seguro*:</label> 
								<select id="seguro" class="Select_longtext" ></select>
							</div>
							<div class="Form__Group">
								<label class="Label_longtext" for="usuario">Tipo de Pensión*:</label> 
								<select id="tipoPension" class="Select_longtext" ></select>
							</div>
							<div class="Form__Group">
								<label class="Label_longtext" for="usuario">Tipo de Prestación*:</label> 
								<select id="tipoPrestacion" class="Select_longtext" ></select>
							</div>

							<div class="Form__Group">
								<label class="Label_longtext" for="usuario">Clave de Pensión*:</label> 
								<select id="pension" class="Select_longtext" ></select>
							</div>
							<div class="Form__Group">
								<label class="Label_longtext" for="usuario">Movimiento*:</label>
								<select id="movimiento" class="Select_longtext" onchange="mostrarTablasSub()"></select>
							</div>
						</div>

						<div class="Datos_ContainerColumn">
							<div class="row_container">
								<div class="Section">
									<div style="width: 100%; max-width: 480px;">
										<div class="Form__Group">
											<label class="LabelText" for="usuario">NÚMERO DE RESOLUCIÓN*:</label> 
											<input class="Inputxxl" id="numeroResolucionT"
												onKeyPress="return soloNumeros(event,this)" type="text"
												name="" value="" placeholder="NÚMERO DE RESOLUCIÓN"
												noPaste="true"/>
										</div>

										<div class="Form__Group">
											<label class="LabelText" for="usuario">SECUENCIA PENSIÓN*:</label> 
											<input class="Inputxxl" id="secuenciaPensionT"
												type="text" name="" value="" placeholder="SECUENCIA PENSIÓN"
												noPaste="true" maxlength="2"/>
										</div>
										<div class="Form__Group">
											<label class="LabelText" for="usuario">FECHA INICIO PENSIÓN*:</label> 
											<input class="Inputxxl" id="fechaIncioPensionT"
												type="text" name="" value=""
												placeholder="FECHA INICIO PENSIÓN" min="2020-01-01"
												max="2020-01-01" onchange="validarFechaIn()"
												readonly="readonly"/>
											<center>
												<span id="spanFechaIn" class="error_span">La fecha a capturar deberá ser igual o menor a la fecha de solicitud del trámite</span>
											</center>
										</div>
									</div>
									<div style="width: 100%; max-width: 480px;">
										<div class="Form__Group">
											<label class="LabelText" for="usuario">FECHA EMISIÓN PENSIÓN*:</label> 
											<input class="Inputxxl" id="fechaEmisionPensionT"
												type="text" name="" value=""
												placeholder="FECHA EMISIÓN PENSIÓN" min="2020-01-01"
												max="2020-01-01" onchange="validarFechaEm()"
												readonly="readonly"/>
											<center>
												<span id="spanFechaEm" class="error_span">La fecha a capturar deberá ser igual o menor a la fecha de solicitud del trámite</span>
											</center>
										</div>

										<div class="Form__Group">
											<label class="LabelText" for="usuario">NUMERO SEMANAS COTIZADAS*:</label> 
											<input class="Inputxxl" id="numeroSemanasCotizadasT" type="text"
												onKeyPress="return soloNumeros(event,this)" name="" value=""
												placeholder="NUMERO SEMANAS COTIZADAS" noPaste="true"
												maxlength="4"/>
										</div>
										<div class="Form__Group">
											<label class="LabelText" for="usuario">NUMERO ISSSTE*:</label> 
											<input class="Inputxxl" id="numeroIssste"
												type="text" name="" value=""
												onKeyPress="return soloNumeros(event,this)"
												placeholder="NUMERO ISSSTE" noPaste="true"/>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="Title">Datos Generales del Trabajador</div>
						<c:if test="${not empty lstAfore}">
							<div class="Form__Group">
								<label class="Label_longtext" for="usuario">Aseguradora:</label>
								<form:select id="aseguradora" class="Select_longtext" name="aseguradora" path="tipoDisposicion" data-not-null="0" data-nombre="aseguradora">
									<option value="0">Seleccione una Aseguradora</option>
									<form:options items="${lstAfore}" itemValue="claveAfore" itemLabel="descripcionAfore" />
								</form:select>
							</div>
						</c:if>
						<c:if test="${empty lstAfore}">
							<div class="Form__Group">
								<label class="Label_longtext" for="usuario">Aseguradora:</label>
								<select id="aseguradora" class="Select_longtext" name="aseguradora" path="tipoDisposicion" data-not-null="0" data-nombre="aseguradora">
									<option value="999">999</option>
								</select>
							</div>
						</c:if>
						<div class="Datos_Container">
							<c:if test="${not empty parametros}">
								<div class="Form__Group">
									<label class="Label_longtext" for="usuario">Tipo de Recursos a Disponer:</label>
									<form:select id="disposicion" class="Select_longtext" name="tipoDisposicion" path="tipoDisposicion" data-not-null="0" data-nombre="Disposicion">
										<option value="0">Seleccione una Disposición</option>
										<form:options items="${parametros}" itemValue="chParametro" itemLabel="chValorParametro" />
									</form:select>
								</div>
							</c:if>

							<c:if test="${not empty docProbatorio}">
								<div class="Form__Group">
									<label class="Label_longtext" for="usuario" id="labelDocProbatorio">Clave Documento Aprobatorio:</label>
									<form:select id="docProbatorio" class="Select_longtext" name="docProbatorio" path="tipoDisposicion" data-not-null="0" data-nombre="docProbatorio">
										<option value="0">Seleccione una Clave</option>
										<form:options items="${docProbatorio}" itemValue="idTipoDoctoProbatorio" itemLabel="descripcion" />
									</form:select>
									<center>
										<span id="spanClaveDocProbatorio" class="error_span">Es requerido seleccionar una Clave Documento Aprobatorio</span>
									</center>
								</div>
							</c:if>
						</div>
						<div class="Datos_ContainerColumn">
							<div class="row_container">
								<div class="Section">
									<div style="width: 100%; max-width: 480px;">
										<div class="Form__Group">
											<label class="LabelText" for="usuario">FECHA DE LA SOLICITUD:</label> 
											<input class="Inputxxl" id="fechaSolicitud" type="text" name="" value="" placeholder="FECHA DE LA SOLICITUD"/>
										</div>

										<div class="Form__Group">
											<label class="LabelText" for="usuario">FECHA NACIMIENTO:</label> 
											<input class="Inputxxl" id="fechaNacimiento" type="text" name="" value="${fechaNacimiento}" placeholder="FECHA NACIMIENTO"/>
										</div>

										<div class="Form__Group">
											<label class="LabelText" for="usuario">CURP AGENTE DE SERVICIO:</label> 
											<input class="Inputxxl" id="curpAgenteServicio" type="text" name="" value="${curpAgenteServicio}" placeholder="CURP AGENTE DE SERVICIO"/>
										</div>
									</div>
									<div style="width: 100%; max-width: 480px;">
										<div class="Form__Group">
											<label class="LabelText" for="usuario">CLAVE SOLICITANTE:</label> 
											<input class="Inputxxl" id="claveSolicitante" type="text" name="" value="${tipoSolicitante}" placeholder="CLAVE SOLICITANTE"/>
										</div>

										<div class="Form__Group">
											<label class="LabelText" for="usuario">DESCRIPCIÓN SOLICITANTE:</label> 
											<input class="Inputxxl" id="descripcionSolicitante" type="text" name="" value="${tipoSolicitanteDoc}" placeholder="DESCRIPCIÓN SOLICITANTE"/>
										</div>
									</div>
								</div>
							</div>
						</div>
						<center>
							<span id="spanObligatoriosPrin" class="error_span">Los campos con asterisco son obligatorios</span>
						</center>
					</form:form>

					<input id="valorRadio" name="valorRadio" path="valorRadio" type="hidden" /> 
					<input id="descripcionTipoPrestacion" name="descripcionTipoPrestacion" path="descripcionTipoPrestacion" type="hidden" /> 
					<input id="descripcionSeguro" name="descripcionSeguro" path="descripcionSeguro" type="hidden" />
					<input id="descripcionRetiro" name="descripcionRetiro" path="descripcionRetiro" type="hidden" /> 
					<input id="descripcionTipoPension" name="descripcionTipoPension" path="descripcionTipoPension" type="hidden" /> 
					<input id="descripcionRegimen" name="descripcionRegimen" path="descripcionRegimen" type="hidden" /> 
					<input id="descripcionPension" name="descripcionPension" path="descripcionPension" type="hidden" /> 
					<input id="descripcionMovimiento" name="descripcionMovimiento" path="descripcionMovimiento" type="hidden" /> 
					<input id="claveTipoPrestacion" name="claveTipoPrestacion" path="claveTipoPrestacion" type="hidden" /> 
					<input id="claveSeguro" name="claveSeguro" path="claveSeguro" type="hidden" /> 
					<input id="claveRetiro" name="claveRetiro" path="claveRetiro" type="hidden" /> 
					<input id="claveTipoPension" name="claveRetiro" path="claveRetiro" type="hidden" /> 
					<input id="claveRegimen" name="claveRegimen" path="claveRegimen" type="hidden" /> 
					<input id="clavePension" name="clavePension" path="clavePension" type="hidden" /> 
					<input id="claveMovimiento" name="claveMovimiento" path="claveMovimiento" type="hidden" /> 
					<input id="numeroResolucion" name="numeroResolucion"  type="hidden"/> 
					<input id="secuenciaPension" name="secuenciaPension"  type="hidden" />
					<input id="fechaInicioPension" name="fechaInicioPension" type="hidden" /> 
					<input id="fechaEmisionPension" name="fechaEmisionPension" type="hidden" /> 
					<input id="numeroSemanasCotizadas" name="numeroSemanasCotizadas" type="hidden" /> 
					<input id="valorRadioDos" name="valorRadioDos" value="" type="hidden" /> 
					<input id="claveTipoRecursos" name="claveTipoRecursos" type="hidden" /> 
					<input id="tipoRecursosDescripcion" name="tipoRecursosDescripcion" type="hidden" /> 
					<input id="idCheck" name="idCheck" type="hidden" /> 
					<input id="classBen" name="classBen" type="hidden" /> 
					<input id="numeroIsssteH" name="numeroIsssteH" type="hidden" /> 
					<input id="posicionSar92" name="posicionSar92" type="hidden" /> 
					<input id="valorSieforeTemporal" name="valorSieforeTemporal"  type="hidden" /> 
					<input id="valorAccionesTempo" name="valorAccionesTempo" type="hidden" />
				</div>
				<br />
				<div id="tablasSub">
					<div onclick="sectionone()" class="Title_OneOption">
						<div class="Title_Text">Montos Subcuentas RCV</div>
						<div class="Arrows"></div>
					</div>

					<div id="section_one" class="Container_One">
						<div class="row_containerbox">
							<div id="datosrcv" style="display: none;"></div>
							<div class="Modal_Container">

								<div class="SeccionTable">
									<center>
										<table id="tablaRcv"
											class="table table-striped table-bordered"
											style="width: 100%">
										</table>
										<div class="Datos_ContainerColumn">
											<div class="row_container">
												<div class="Datosxl">
													<div class="Form__Group"></div>
												</div>
												<div class="Datosxl">
													<div class="Form__Group"></div>
												</div>
												<div class="Datosxl">
													<div class="Form__Group">
														<label class="LabelTextEdit" style="font-size: 20px;">
															<strong>MONTO TOTAL:</strong> <strong id="montoTotalRcv"></strong>
														</label>
													</div>
												</div>
											</div>
										</div>
									</center>
								</div>
							</div>
						</div>
					</div>

					<div id="section" onclick="section_two()" class="Title_TowOption">
						<div class="Title_Text">Montos Subcuentas Vivienda</div>
						<div class="Arrows"></div>
					</div>

					<div id="section_two" class="Container_Two">
						<div class="row_containerbox">
							<div id="datosvivienda" style="display: none;"></div>

							<div class="Modal_Container">
								<div class="SeccionTable" id="tabViv">
									<center>
										<table id="tablaVivienda"
											class="table table-striped table-bordered"
											style="width: 100%">
										</table>
										<div class="Datos_ContainerColumn">
											<div class="row_container">
												<div class="Datosxl">
													<div class="Form__Group"></div>
												</div>
												<div class="Datosxl">
													<div class="Form__Group"></div>
												</div>
												<div class="Datosxl">
													<div class="Form__Group">
														<label class="LabelTextEdit" style="font-size: 20px;">
															<strong>MONTO TOTAL:</strong> <strong id="montoTotalViv"></strong>
														</label>
													</div>
												</div>
											</div>
										</div>
									</center>
								</div>
							</div>
							
							<center>
								<span id="spanEstatusMarca" class="error_span">Subcuenta de Vivienda NO disponible por crédito de vivienda</span>
							</center>
						</div>
					</div>
				</div>
				<center>
					<span id="spanSubcuentas" class="error_span">El Trabajador
						debe contar con al menos una subcuenta con un monto mayor a cero
						para proceder al envío de la Solicitud de Disposición de Recursos</span>
				</center>


				<br/>
				<div class="Title">Beneficiario</div>
				<div class="Datos_ContainerColumn">
					<div class="row_container">
						<div class="Datosxl">
							<div class="Form__Group">
								<label class="LabelTextEdit" for="usuario">CURP*:</label> 
								<input class="InputEdit" type="text" name="" value="" placeholder="" id="curpBeneficiario" noPaste="true"/>
							</div>
							<center>
								<span id="spanCurpBen" class="error_span">La CURP tiene formato incorrecto</span>
							</center>
						</div>
						<div class="Datosxl">
							<div class="Form__Group">
								<label class="LabelTextEdit" for="usuario">Nombre*:</label> 
								<input class="InputEdit" type="text" name="" value="" placeholder="" id="nombre" maxlength="40" onKeyPress="return soloLetras(event)" noPaste="true"/>
							</div>
						</div>
						<div class="Datosxl">
							<div class="Form__Group">
								<label class="LabelTextEdit" for="usuario">Apellido Paterno*:</label> 
								<input class="InputEdit" type="text" name="" value="" placeholder="" id="apellidoPaterno" maxlength="40" onKeyPress="return soloLetras(event)" noPaste="true"/>
							</div>
						</div>
					</div>
				</div>
				<div class="Datos_ContainerColumn">
					<div class="row_container">

						<div class="Datosxl">
							<div class="Form__Group">
								<label class="LabelTextEdit" for="usuario">Apellido Materno*:</label> 
								<input class="InputEdit" type="text" name="" value="" placeholder="" id="apellidoMaterno" maxlength="40" onKeyPress="return soloLetras(event)" noPaste="true"/>
							</div>
						</div>
						<div class="Datosxl">
							<div class="Form__Group">
								<label class="LabelTextEdit" for="usuario">RFC:</label> 
								<input class="InputEdit" type="text" name="" value="" placeholder="" id="rfcBeneficiario" noPaste="true"/>
							</div>
							<center>
								<span id="spanRfcBen" class="error_span">El RFC tiene formato incorrecto</span>
							</center>
						</div>
						<div class="Datosxl">
							<div class="Form__Group">
								<label class="LabelTextEdit" for="usuario" noPaste="true">Porcentaje*:</label>
								<input class="InputEdit" type="text" name="" value="" placeholder="" id="porcentaje" onkeyup="soloNumerosPrctj(event,this)" noPaste="true"/>
							</div>
						</div>
					</div>
				</div>
				<div class="Datos_ContainerColumn">
					<div class="row_container">

						<div class="Datosxl">
							<c:if test="${not empty listaBancos}">
								<div class="Form__Group">
									<label class="LabelTextEdit" for="banco">Banco*:</label> 
									<select class="Select" id="banco">
										<option value="0">Seleccione un Banco</option>
										<c:forEach items="${listaBancos}" var="combo" varStatus="counter">
											<option value="${combo.chParametro}">${combo.chValorParametro}</option>
										</c:forEach>
									</select>
								</div>
							</c:if>
						</div>
						<div class="Datosxl">
							<div class="Form__Group">
								<label class="LabelTextEdit" for="usuario">Cuenta Clabe*:</label> 
								<input class="InputEdit" type="text" name="" value="" placeholder="" id="cuentaClabe" onKeyPress="return soloNumeros(event,this)" maxlength="18" noPaste="true"/>
							</div>
							<center>
								<span id="spanCuentaClabe" class="error_span">La Cuenta clabe no es válida</span>
								<span id="spanCuentaClabeBanco" class="error_span">La Cuenta clabe no corresponde al banco seleccionado</span>
							</center>
						</div>
					</div>
					<center>
						<span id="spanObligatoriosBen" class="error_span">Los campos con asterisco son obligatorios</span>
					</center>
					<center>
						<span id="spanPorcentaje" class="error_span">El porcentaje capturado excede el 100%</span>
					</center>
				</div>
				<div class="ContainerButtons">
					<a id="agregarBen" class="Submitx" onclick="validarBeneficiarios()">Agregar</a> 
					<a id="elimBen" class="Submitx" onclick="eliminarRegChecksSele()">Eliminar</a>
				</div> 
				<br/>
				<div class="SeccionTable">
					<div style="overflow-x: auto;">
						<table id="tablaBeneficiarios" class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr class="RowHeader">
									<th>CURP</th>
									<th>Nombre</th>
									<th>Apellido Paterno</th>
									<th>Apellido Materno</th>
									<th>RFC</th>
									<th>Porcentaje</th>
									<th>Banco</th>
									<th>Cuenta Clabe</th>
									<th>Eliminar</th>
									<th>
										<input onclick="marcar(this);" type="checkbox" name="select_all" value="CHECKPRINC" id="chboxAll">
									</th>
								</tr>
							</thead>
							<tbody id="tabBen"/>
						</table>
					</div>
				</div>

				<div class="Datos_ContainerColumn">
					<div class="row_container">
						<div class="Datosxl">
							<div class="Form__Group"></div>
						</div>
						<div class="Datosxl">
							<div class="Form__Group"></div>
						</div>
						<div class="Datosxl">
							<div class="Form__Group">
								<label class="LabelTextEdit" style="font-size: 20px;">
									<strong>TOTAL:</strong> 
									<strong id="porcentajeTotal"></strong>
								</label>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="ContainerButtonsCenter">
			<a href="#" id="btnPago" class="Submitx" onclick="mostrarPopupFormaPago()">Forma de <br/>Pago</a>
			<a href="#" id="aceptarIssste" class="Submitx disabled_Url" onclick="implementacionExpedienteServicio()">Generar Expediente</a>
		</div>
	</div>
	<div class="push"></div>

	<div id="miModalResolucion" class="Modal">
		<div class="ModalContainer" style="max-width: 90%;">
			<div class="ModalHeader">
				<h2 class="ModalTitle" id="tituloIssste">${_TITULO}</h2>
				<!--  <a href="#" class="ModalButton">X</a> -->
			</div>
			<div class="Modal_Container">

				<div class="SeccionTable">
					<center>
						<table id="tablaResolucion" class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr class="RowHeader" style="font-size: 10px;">
									<th class="th_tabla"></th>
									<th class="th_tabla">NÚMERO RESOLUCIÓN</th>
									<th class="th_tabla">TIPO PRESTACIÓN</th>
									<th class="th_tabla">TIPO SEGURO</th>
									<th class="th_tabla">TIPO RETIRO</th>
									<th class="th_tabla">TIPO PENSIÓN</th>
									<th class="th_tabla">CLAVE REGIMEN</th>
									<th class="th_tabla">CLAVE PENSIÓN</th>
									<th class="th_tabla">MOVIMIENTO</th>
									<th class="th_tabla">SECUENCIA PENSION</th>
									<th ></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${datosResolucion}" var="listas" varStatus="loopCounter">
									<c:choose>
										<c:when test="${loopCounter.index % 2 == 0}">
											<tr class="Row1">
										</c:when>
										<c:otherwise>
											<tr class="Row2">
										</c:otherwise>
									</c:choose>
									<td class="td_tabla" id="celda1">
										<input onclick="javascript:habilitarAceptar('${listas.cvTipoPrestacion}', '${listas.cvTipoSeguro}', '${listas.cvTipoRetiro}', '${listas.cvTipoPension}', '${listas.cvTipoRegimen}', '${listas.cvClavePension}', '${listas.cvMovimiento}', '${listas.secuenciaPension}', '${listas.fechaEmision}', '${listas.fechaInicioPension}', '${listas.semanasCotizadas}', '${listas.numeroConcesion}', '${listas.bandera}', '${listas.idResolucion}', '${listas.numeroIssste}')" 
												type="radio" 
												name="res" 
												id="idResolucion"
												value="${listas.idResolucion}" />
									</td>
									<td class="td_tabla" id="celda2">${listas.numeroConcesion}</td>
									<td class="td_tabla" id="celda3">${listas.descTipoPrestacion}</td>
									<td class="td_tabla" id="celda4">${listas.descTipoSeguro}</td>
									<td class="td_tabla" id="celda5">${listas.descTipoRetiro}</td>
									<td class="td_tabla" id="celda6">${listas.descTipoPension}</td>
									<td class="td_tabla" id="celda7">${listas.descTipoRegimen}</td>
									<td class="td_tabla" id="celda8">${listas.descClavePension}</td>
									<td class="td_tabla" id="celda9">${listas.descMovimiento}</td>
									<td class="td_tabla" id="celda9">${listas.secuenciaPension}</td>
									<td 				 id="celda10">${listas.cvTipoRegimen}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<center>
							<span id="spanCargado" class="error_span">Seleccione otro dato para la carga, este no esta relacionado al tipo solicitante</span>
						</center>
					</center>
					<center>
						<span id="spanFechaNac" class="error_span">El Trabajador no cuenta con la Edad Requerida para el Trámite</span>
					</center>

					<div class="ContainerButtonsCenter">
						<a href="#" id="aceptarRes" class="Submitx" onclick="valorResolucion()">ACEPTAR</a> 
						<a href="#" class="Submitx" onclick="mostrarModalEleccion()">Cancelar</a>
					</div>
				</div>

			</div>

		</div>

	</div>


	<div id="miOpcionSiefores" class="Modal">
		<div class="ModalContainer" style="background-color: #E0e0e0;">
			<div class="ModalHeader">
				<h2 class="ModalTitle"></h2>
			</div>
			<div class="Form__Group">
				<c:if test="${not empty listaSiefores}">
					<div class="Form__Group">
						<label class="Label_longtext" for="usuario" id="labelSiefore">Siefores*:</label>
						<select id="siefores" class="Select_longtext" onchange="selecionaSiefor()">
							<option value="0">Seleccione una Siefore</option>
							<c:forEach items="${listaSiefores}" var="combo" varStatus="counter">
								<option value="${combo.clave}">${combo.nombreSiefore}</option>
							</c:forEach>
						</select>
					</div>
				</c:if>


			</div>
			<div class="Modal_Container">
				<div id="valorPosicion"></div>
				<div id="valorCampoSar"></div>
				<center></center>
			</div>
			<div class="ContainerButtonsCenter">
				<a id="aceptarSiefor" class="Submitx" onclick="cierraModalSeleccionarSiefore();aceptarSiefore()">ACEPTAR</a>
				<a class="Submitx" onclick="cierraModalSeleccionarSiefore()">Cancelar</a>
			</div>
		</div>
	</div>

	<jsp:include page="../generales/footerAgente.jsp" />
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
	<jsp:include page="../generales/modalsDisposicionIssste.jsp" />
	
	<jsp:include page="modalTipoRetiro.jsp" />	
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modaltiporetiro.js'/>"></script>
	<script type="text/javascript">
		var jsonInstiticionesBancarias = '${jsonInstitucionBancaria}';
	</script>
</body>
</html>
