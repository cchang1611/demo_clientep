<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <title>Reintegro de recursos por un retiro parcial por desempleo</title>
  <meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	
	
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
<%--   <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pagoPorParcialidad.js'/>"></script> --%>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
  <script src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>  
  <script type="text/javascript" src="<c:url value="/webResources/js/reintegroRecursosDesempleo.js"/>"></script>
  <script type="text/javascript">
	URL_CALCULO_MONTO_REINTEGRAR = '<c:url value="/private/obtenerCalculoMontoReintegrar"/>';
	URL_HISTORICO_RETIRO = '<c:url value="/private/historicoRetiro"/>';
  </script>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
</head>
<% 
DatosTrabajador datos =  (DatosTrabajador) session.getAttribute("datos");
UsuarioLogin usuario = (UsuarioLogin) session.getAttribute("pulssarUP");
FolioEntrada folio = datos.getFolio();
%>
<body>
	<input type="hidden" id="mensaje" value = "${mensaje}"/>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Reintegro de recursos por un retiro parcial por desempleo" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "2" />
	</jsp:include>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
	</script>
       <!-- Inicia Wrapper -->
        <div class="wrapper">
          <div class="Title__Container">
            <h1>Reintegro de recursos por un retiro<p>parcial por desempleo</p></h1>
          </div>

          <div class="Container">
            <div class="Layout__XL" style="width: 90%;">

              <div class="Title">
                <p>Hist&oacute;rico Retiros</p>
              </div>

			  <div class="Datos_Container">
			  	<table id="tableReintegro" class="resaltarRow">
			  		<tbody>
				  	<c:choose>
				  		<c:when test="${empty solicitud.lstHistoricos}">
				  			<tr>
				  				<th>
				  					<td>NO SE ENCONTRO HIST&Oacute;RICO</td>
				  				</th>
				  			</tr>
				  			
				  		</c:when>
				  		<c:otherwise>
				  			<tr class="RowHeader">
				  				<th>N&Uacute;MERO DE RESOLUCI&Oacute;N</th>
				  				<th>VALOR DEL D&Iacute;A DE REINTEGRO</th>
				  				<th>FECHA NOTIFICACI&Oacute;N DEL RETIRO</th>
				  				<th>NO. DE SEMANAS DEL RETIRO</th>
				  				<th>NO. DE SEMANAS REINTEGRADAS</th>
				  				<th>NO. M&Aacute;XIMO DE SEMANAS DISPONIBLE</th>
				  				<th>MONTO M&Aacute;XIMO DISPONIBLE</th>
				  				<th>SEMANAS POR REINTEGRAR</th>
				  				<th>MONTO TOTAL A REINTEGRAR</th>
				  			</tr>			  						  				
				  		
				  			<c:forEach items="${solicitud.lstHistoricos}" var="retiro" varStatus="numRen">
				  				<tr class="Row${numRen.index%2==0?"1":"2"} renglonHistorico" data-indice="${numRen.index}" data-fecha="${retiro.fechaRetiroReintegro}">
				  					<td>${retiro.numeroResolucion}</td>
				  					<td>$ ${retiro.valorDiaReintegrar}</td>
				  					<td>${retiro.fechaRetiroReintegroVista}</td>
				  					<td>${retiro.semanasDescontadosRecuperadas}</td>
				  					<td>${retiro.semanasReintegradas}</td>
				  					<td>${retiro.semanasRestantes}</td>
				  					<td>$ ${retiro.montoRestante}</td>
				  					<td><input class="Inputxxl" type="text" name="" value="" id="semanasPagar" data-not-null="0" data-nombre="Semanas a Pagar"/></td>
				  					<td>0</td>
				  				</tr>
				  			</c:forEach>			  		
				  		</c:otherwise>
				  	</c:choose>			  			
			  		</tbody>
			  	</table>
			  	<p></p><br></br>
			  </div>			  	
<!--               <div class="Title"> -->
<!--                 <p>Datos Generales</p> -->
<!--               </div> -->

                <div class="Datos_Container contenidoBtnLeft">
                    <input disabled class="Submit_disabled btnLeft" type="submit" value="Calcular" id="btnCalcular"/>
                </div>

                <div class="ContainerButtons">
                  <input id="btnGenerarReferencia" disabled style="width:40%;" class="Submit_disabled" type="button" value="Generar Datos de Referencia" onclick="window.location.href = 'generarDatosReferenciaReintegro.do';">
                </div>
              </div>
            </div>
          <!-- finaliza titulo seccion -->
          <div class="push"></div>
        </div>
      <!-- Finaliza Wrapper -->
<div class="push"></div>
	</div>
		
	<form action="<c:url value="/private/confirmarReintegros.do"/>" method="post" id="frmConfirmacion">
		<input type="hidden" name="montoReintegrar" id="montoReintegrar" />
		<input type="hidden" name="numeroSemanasReintegrar" id="numeroSemanasReintegrar" />
		<input type="hidden" name="renglonSeleccionado" id="renglonSeleccionado"/>
	</form>	
	

	<jsp:include page="../generales/footerAgente.jsp" />
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
