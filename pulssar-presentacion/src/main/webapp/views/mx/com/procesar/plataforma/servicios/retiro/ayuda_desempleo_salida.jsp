<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ValidarSolicitudCertificacionAforeSalida" %> 
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Menu</title>
	<meta charset="utf-8" />
	<![if IE]>
			<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	  <![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
FolioEntrada folio = datos.getFolio();
%>

<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Ayuda de Desempleo" />
		<jsp:param name="menuPrimario" value="2" />
		<jsp:param name="menuSecundario" value="2" />
		<jsp:param name="menuInactivo" value="2" />
	</jsp:include>
	<div class="wrapper">
		<div class="Container">
			<div class="Title__Container">
				<h1>Ayuda por Desempleo</h1>
			</div>
			<form:form class="ModalFooter" method="post" id="retiroDesempleoImss"
				action="${pageContext.request.contextPath}/private/tiporetiro.do"
				modelAttribute="salida">

				<input id="diagnosticoProcesar" type="hidden" name="diagnosticoProcesar"
					value="${mensaje}" />

				<div class="Container">
					<div class="Layout__M">
						<div class="Line"></div>
						<div class="Datos_Container">
								<div class="DatosBack">
									<strong>ENTIDAD DE ORIGEN:</strong> ${salida.entidadOrigen}
								</div>
								<div class="DatosBack">
									<strong>TIPO DE TRÁMITE:</strong> ${salida.tipoTramite}
								</div>
								<div class="DatosBack">
									<strong>NSS:</strong> ${salida.nss}
								</div>
								<div class="DatosBack">
									<strong>CURP:</strong> ${salida.curp}
								</div>
								<div class="DatosBack">
									<strong>NOMBRE TRABAJADOR IMSS:</strong>
									${salida.nombreTrabajadorImss}
								</div>
								<div class="DatosBack">
									<strong>NOMBRE TRABAJADOR PROCANASE:</strong>
									${salida.nombreTrabajadorProcanase}
								</div>
								<div class="DatosBack">
									<strong>NOMBRE TRABAJADOR:</strong> ${salida.nombreTrabajador}
								</div>
								<div class="DatosBack">
									<strong>APELLIDO PATERNO:</strong> ${salida.apellidoPaterno}
								</div>
								<div class="DatosBack">
									<strong>APELLIDO MATERNO:</strong> ${salida.apellidoMaterno}
								</div>
								<div class="DatosBack">
									<strong>TIPO DE PRESTACIÓN:</strong> ${salida.tipoPrestacion}
								</div>
								<div class="DatosBack">
									<strong>FECHA DE MATRIMONIO DESEMPLEO:</strong>
									${salida.fechaMatrimonioDesempleo}
								</div>
								<div class="DatosBack">
									<strong>FECHA NOTIFICACIÓN IMSS:</strong>
									${salida.fechaNotificacionImss}
								</div>
								<div class="DatosBack">
									<strong>FECHA CONCLUSIÓN VIGENCIA:</strong>
									${salida.fechaConclusionVigencia}
								</div>
								<div class="DatosBack">
									<strong>N&Uacute;MERO DE RESOLUCIÓN:</strong>
									${salida.numeroResolucion}
								</div>
								<div class="DatosBack">
									<strong>DIAGNOSTICO CUENTA INDIVIDUAL:</strong>
									${salida.diagnosticoProcesar}
								</div>
								<div class="DatosBack">
									<strong>TIPO DE TRABAJADOR APORTACI&Oacute;N CUOTA
										SOCIAL:</strong> ${salida.tipoTrabAportacionCuotaSocial}
								</div>
								<div class="DatosBack">
									<strong>SBC TIPO A:</strong> ${salida.sbcTipoA}
								</div>
								<div class="DatosBack">
									<strong>SBC TIPO B:</strong> ${salida.sbcTipoB}
								</div>
								<div class="DatosBack">
									<strong>ID PAGO COMPLEMENTARIO:</strong>
									${salida.idPagoComplementario}
								</div>
								<div class="DatosBack">
									<strong>MONTO PAGADO RETIRO ORIGINAL:</strong>
									${salida.montoPagadoRetiroOriginal}
								</div>
								<div class="DatosBack">
									<strong>SALDO ANTERIOR PAGO RETIRO ORIGINAL:</strong>
									${salida.saldoAnteriorPagoRetiroOriginal}
								</div>
								<div class="DatosBack">
									<strong>FOLIO OPERACI&Oacute;N IMSS:</strong>
									${salida.folioOperacionIMSS}
								</div>
								<div class="DatosBack">
									<strong>DELEGACI&Oacute;N:</strong> ${salida.delegacion}
								</div>
								<div class="DatosBack">
									<strong>SUB DELEGACI&Oacute;N:</strong> ${salida.subdelegacion}
								</div>
								<div class="DatosBack">
									<strong>FECHA PREST TR&Aacute;MITE:</strong>
									${salida.fechaPrestTramite}
								</div>
								<div class="DatosBack">
									<strong>FECHA BAJA TRABAJADOR:</strong>
									${salida.fechaBajaTrabajador}
								</div>
								<div class="DatosBack">
									<strong>NÚMERO CONSECUTIVO PROCESAR:</strong>
									${salida.numeroConsecutivoProcesar}
								</div>
								<div class="DatosBack">
									<strong>TOTAL RESOLUCIONES PROCESAR:</strong>
									${salida.totalResolucionesProcesar}
								</div>
								<div class="DatosBack">
									<strong>CLAVE ADMINISTRACIÓN ACTUAL:</strong>
									${salida.claveAdminActual}
								</div>
						</div>
						<div class="ContainerButtons">
							<input id="btnSolicitarDep" class="Submitxl" type="submit"
								value="Solicitar Dependencias" />
						</div>
					</div>
				</div>
							<input type="hidden" id="folioHidden" name="folio"
				value="${folio.folio}" />
				
			</form:form>
		</div>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />


	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
		src="<c:url value='/webResources/js/ayudaDesempleoSalida.js'/>"></script>
</body>
</html>
