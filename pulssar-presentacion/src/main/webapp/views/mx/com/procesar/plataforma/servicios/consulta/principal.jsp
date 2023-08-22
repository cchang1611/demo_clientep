<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" />
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Home</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/timepicki.css'/>">
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" charset="utf-8" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link charset="utf-8" rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link charset="utf-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<div class="wrapper">
		<jsp:include page="../generales/headerAgente.jsp">
			<jsp:param name="encabezado" value="1" />
			<jsp:param name="menuPrimario" value = "1" />
			<jsp:param name="menuSecundario" value = "1" />
		</jsp:include>
		<script type="text/javascript">
			var _FLUJO = "${respuesta.flujo}";
			var _VAR = '${cVar}';
			var context = '${pageContext.request.contextPath}';
			var _OBLIGSEL = '${selloObligatorio}';
		</script>
		
		<section>
			<div class="Container">
				<div class="Layout__M">
					<div class="Datos_Container">
						<h1 class="Title__Label">Hola: ${nombreUsuario}</h1>
						<form:form id="fm_datosConsulta" method="POST" modelAttribute="commandConsulta" action="consultaPrincipal.do">
							<form:hidden path="idProcesar"/>
							<div class="Form__Group">
								<label class="LabelText">CURP:</label>
								<form:input class="Inputxxl" id="idCurpConsulta" data-nombre="CURP" type="text" name="curp" placeholder="CURP" data-alfanumerico="0" data-curp-nss="0" path="curp" maxlength="18" />
							</div>
							<div class="Form__Group">
								<label class="LabelText">NSS:</label>
								<form:input class="Inputxxl" id="idNssConsulta" data-nombre="NSS" type="text" name="nss" placeholder="NSS" path="nss" maxlength="11" data-curp-nss="0" data-numeros-nss="0" />
							</div>
							<c:if test = "${fn:contains(autenticacionINE, pulssarUP.aforeUsuario)}">
								<div class="Form__Group">
			                      <label class="LabelText" for="usuario">¿Autenticación por INE?
			                      <input type="checkbox" name="autenticacionIne" id="autenticacionIne" value="1">
			                      </label>
			                    </div>
		                    </c:if>
							<div class="Form__Group">
								<label class="LabelText" for="usuario">¿No eres titular?
									<input type="checkbox" name="tipoConsulta" id="idTipoConsulta" />
								</label>
							</div>
							<div id="consultaCombo" class="Form__Group">
								<div class="Form__Group">
									<label class="LabelText" for="usuario">Selecciona tipo solicitante: *</label>
									<form:select id="claveConsulta" class="Select" name="cvTipoSolicitante" path="cvTipoSolicitante" data-not-null="0" data-nombre="Solicitante">
										<option value="">Seleccione el tipo de solicitante</option>
										<form:options items="${solicitante}" itemValue="clave" itemLabel="descripcion"/>
									</form:select>
								</div>
								<c:if test = "${sessionScope.stiloOrg == '568'}">
									<div class="Form__Group">
										<label class="LabelText">CURP Solicitante:</label>
										<form:input class="Inputxxl" id="idCurpSol" data-nombre="CURP Solicitante" type="text" name="curp" placeholder="CURP Solicitante" data-alfanumerico="0" data-curp-nss="0" path="curpSolicitante" maxlength="18" />
									</div>
									<div class="Form__Group">
										<label class="LabelText">Nombre Solicitante:</label>
										<form:input class="Inputxxl" id="nombreSol" data-nombre="Nombre" type="text" name="nombre" placeholder="Nombre Solicitante" data-alfanumerico="0" path="nombre" />
									</div>
									<div class="Form__Group">
										<label class="LabelText">Apellido Paterno Solicitante:</label>
										<form:input class="Inputxxl" id="apePaternoSol" data-nombre="Apellido Paterno" type="text" name="apellidoPaterno" placeholder="Apellido Paterno Solicitante" data-alfanumerico="0" path="apellidoPaterno" />
									</div>
									<div class="Form__Group">
										<label class="LabelText">Apellido Materno Solicitante:</label>
										<form:input class="Inputxxl" id="apeMaternoSol" data-nombre="Apellido Materno" type="text" name="apellidoMaterno" placeholder="Apellido Materno Solicitante" data-alfanumerico="0" path="apellidoMaterno" />
									</div>
								</c:if>
							</div>
							<input type="hidden" name="imagen" path="imagen" id="idImagen" />
							<div class="ContainerButtonsCenter">
								<input id="btnConsultar" class="Submit" type="button" value="CONSULTAR" />
							</div>
							
							<div id="miClock" class="Modal">
								<div class="ModalContainer">
									<div class="ModalHeader">
										<h2 class="ModalTitle">Selecciona Tiempo de Espera</h2>
									</div>
									<div class="Modal__Hora">
										<div class="IconHora">
											<img src="../webResources/img/clock_pulsar.png" alt="clock_pulsar" class="IconClock"/>
										</div>
										<form:input class="timepicker" id="timepicker1" type="text" name="timepicker1" placeholder="Tiempo de Espera" path="timerPicker" />
									</div>
									<div class="ModalFooter">
										<input id="btnClockContinuar" class="Submit" type="button" value="CONTINUAR">
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</section>
		<div class="push"></div>
	</div>
	
	
<div id="miModal4" class="Modal">
    <div class="ModalContainerpdf ">
      <div class="ModalHeader">
      <h2 class="ModalTitle">Selección del Trabajador</h2>
      <a href="#" class="ModalButton">X</a>
      </div>
      <div class="Modal_Container">
        <div class="Modal__Text">
          <div>
          	<table width="100%" border="0" cellspacing="0" cellpadding="5" id="multiplesTrab">
              <tbody>
                <tr class="RowHeader">
                  <td align="center" valign="middle">NSS</td>
                  <td align="center" valign="middle">CURP</td>
                  <td align="center" valign="middle">Nombre</td>
                  <td align="center" valign="middle">Apellido Paterno</td>
                  <td align="center" valign="middle">Apellido Materno</td>
                </tr>
                </tbody>
            </table>
          </div>
      </div>
    </div>
  </div>
</div>
      
<!-- Modal para el flujo de autenticacion por INE -->
<div id="miModal5" class="Modal">
    <div class="ModalContainerpdf" style="max-width:800px;">
    <form action="./autenticacionIne.do" method="post">
      <div class="ModalHeader">
        <h2 class="ModalTitle">Datos del Solicitante</h2>
        <a href="#" class="ModalButton">X</a>
      </div>
      <div class="Modal_Container">
        <div class="Modal__TextLeft">
          <div class="Datos_Container">
            <div class="Form__Group">
              <label class="LabelText" for="usuario">Nombre(s) del solicitante:</label>
              <input class="Inputxxl" type="text" name="nombre" value="" placeholder="Nombre(s) del solicitante">
            </div>
            <div class="Form__Group">
              <label class="LabelText" for="usuario">Apellido Paterno del Solicitante:</label>
              <input class="Inputxxl" type="text" name="apellidoPaterno" value="" placeholder="Apellido Paterno">
            </div>
            <div class="Form__Group">
              <label class="LabelText" for="usuario">Apellido Materno del Solicitante:</label>
              <input class="Inputxxl" type="text" name="apellidoMaterno" value="" placeholder="Apellido Materno">
            </div>
            <div class="Form__Group">
              <label class="LabelText" for="usuario">CURP del Solicitante:</label>
              <input class="Inputxxl" type="text" name="curp" value="" placeholder="CURP del solicitante">
            </div>
            <div class="Form__Group">
              <label class="LabelText" for="usuario" style="color:red;">
                <strong>
                  La captura de los datos solicitados es obligatoria, favor de verificar*
                </strong>
              </label>
            </div>
          </div>
        </div>
      </div>
    <div class="ContainerButtonsCenter">
<!--       <a href="#miModal5" class="Submitx">Continuar</a> -->
      <input class="Submit" type="submit" value="Continuar">
    </div>
    </form>
  </div>
</div>
                
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/mensajes.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/timepicki.js'/>"></script>
	<script type="text/javascript">
		$('#timepicker1').timepicki({
			show_meridian:false,
			min_hour_value:0,
			max_hour_value:12,
			overflow_minutes:true,
			increase_direction:'up',
			disable_keyboard_mobile: true,
			start_time: ["00", "00"]
		});
	</script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
