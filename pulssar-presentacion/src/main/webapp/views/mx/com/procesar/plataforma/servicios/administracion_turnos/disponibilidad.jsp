<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Menu</title>
<meta charset="ISO-8859-1" />
<![if IE]>
<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet"
	href="<c:url value='/webResources/css/general/main_ie.css'/>" />
<![endif]>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="shortcut icon"              href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>

	<script src="<c:url value='/webResources/js/jquery-3.0.0.min.js'/>"></script>
	<script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
	<script src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<script type="text/javascript">
		var _FLUJO   = "${respuesta.flujo}";
		var _TITULO  = "${respuesta.titulo}";
		var _MENSAJE = "${respuesta.mensaje}";
	</script>
</head>
<body>

	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>

	<!-- Inicia Wrapper -->
	<div class="wrapper">

		<jsp:include page="../generales/headerAdmin.jsp">
			<jsp:param name="encabezado" value="2" />
			<jsp:param name="menuTitle"  value="Consultar Disponibilidad" />
			<jsp:param name="menuActivo" value="1" />
		</jsp:include>

		<br />
		
      <div class="Container">
        <div class="Layout__L">
          <div class="Datos_Container">
            <div style="margin:0px auto; width:90%;">
              <table class="Tablexl" cellspacing="5">
                <tr class="RowHeader">
                  <th width="30%">Cita</th>
                  <th width="40%">CURP</th>
                  <th width="30%">Turno Asignado</th>
                </tr>
                
                <tbody>
                
                	<c:choose>
		              <c:when test="${respuesta.objetoRespuesta.size() > 0}">
		              	<c:forEach var="registroDeTabla" items="${respuesta.objetoRespuesta}">
							<tr class="${registroDeTabla.colorRegistroCss}">
								<td class="${registroDeTabla.colorCss}">${registroDeTabla.horaCita}</td>
								<td class="${registroDeTabla.colorCss}">${registroDeTabla.curp}</td>
								<td class="${registroDeTabla.colorCss}">${registroDeTabla.folioServicio}</td>
							</tr>
						</c:forEach>
		              </c:when>
		              <c:otherwise>
		              	<tr class="Row__3">
							<th colspan="3">Sin turnos ni citas disponibles.</th>
						</tr>
		              </c:otherwise>
                	</c:choose>
                
                </tbody>
              </table>
            </div>
          </div>
          <div class="ContainerButtonsCenter">
            <input id="btnExitoAceptar" class="Submit"  type="submit" value="Aceptar">
          </div>
        </div>
      </div>

		<div class="push"></div>
		<br />

	</div>

	<jsp:include page="../generales/footerPrincipal.jsp" />
	<!-- Finaliza Wrapper -->

	<!-- Ventana modal para la finalización para los turnos.  -->
	<div id="finalizaTurnoModal" class="Modal">
		<div class="ModalContainer">
			<div class="ModalHeader">
				<h2 class="ModalTitle"></h2>
				<a id="botonCerrarModal" href="#" class="ModalButton">X</a>
			</div>
			<div id="mensajeModal" class="Modal__Text">Vuelva a seleccionar
				un turno.</div>
			<a id="linkPantallaFinalizaTurno">link</a>
			<div class="ModalFooter">
				<input id="submitFinalizarTurno" class="Submit" type="submit"
					value="Continuar"><input id="cancelar" class="Submit"
					type="submit" value="Cancelar">
			</div>
		</div>
	</div>
	<!-- finaliza Ventana Modal  -->

	<jsp:include page="modal.jsp"></jsp:include>

	<script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/menu_configuracion.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/webResources/js/administracion_turnos/administracion_turnos.js'/>"></script>

</body>
</html>
