<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<style>
.LabelTextNip {
  font-family: 'Roboto', sans-serif;
  font-weight: normal;
  font-size: 12px;
  color: #b9b9b9;
  text-transform: uppercase;
  display: inline-block;
  width: 100%;
  margin: 0px auto;
  padding-bottom: 7px;
  padding-top: 7px;
  white-space:nowrap;

}
.LabelTextEditNip {
    font-family: 'Roboto', sans-serif;
    font-weight: normal;
    font-size: 11px;

    color: #9b9b9b;
    text-transform: uppercase;
    width: 95%;
    margin: 0px auto;
    padding-bottom: 2px;
    padding-top: 2px;
	border-color: #eeeeee;    
	border-style:solid;    
    display:inline-block;
	white-space:nowrap;
}
.ContainerDatosNip__ColOne {

    width: 50%;
    text-align: center;
    font-family: var(--font-SAR);
    font-size: 12px;
    color: var(--c06);
    text-transform: uppercase;

}
.ContainerDatosNip__ColTwo {

    width: 50%;
    font-family: var(--font-SAR);
    font-size: 12px;
    font-weight: 300;
    color: var(--c06);
    text-transform: uppercase;
    position: relative;

}
.SubmitBlue {

  width: 170px;
  height: 40px;
  border-radius: 3px;
  border: 0px;
  font-size: 18px;
  color: white;
  font-family: 'Roboto', sans-serif;
  background: #4169e1;
  cursor: pointer;
  margin-bottom: 10px;
  text-transform: uppercase;
  -webkit-box-shadow: 1px 1px 3px 0px rgba(0,0,0,0.48);
  -moz-box-shadow: 1px 1px 3px 0px rgba(0,0,0,0.48);
  box-shadow: 1px 1px 3px 0px rgba(0,0,0,0.48);

}
.SubmitBlue:hover {

  background: #558E06;

}

label {
overflow : hidden;
}

td {
    padding : 5px;
}
	</style>
  <title>Generaci&oacute;n de NIP afore Web</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <![if IE]>
	<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
  <![endif]>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datos_generales.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/jquery.dataTables.min.css'/>">
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
  
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
  <!-- plugin de validacion -->
  <script type="text/javascript" src="<c:url value='/webResources/js/core/jquery-ui-1.11.4.custom/jquery-ui.min.js'/>"></script>
  <script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>
<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	
  <script type="text/javascript" src="<c:url value='/webResources/js/jquery.validate.min.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/nip/solicitudNip.js'/>"></script>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tooltip.css'/>"></link>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
  	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="5" />
		<jsp:param name="menuTitle" value="GENERACI&Oacute;N DE NIP AFORE WEB" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>	
<div class="wrapper">
<section>
  <!-- inicia titulo de seccion -->
  <div class="Title__Container" id="tituloPantalla"></div>
  <!-- finaliza titulo seccion -->
 
  <!-- inicia seccion datos certificados -->
 <form:form method="post" action="generarNip" id="solicitudNip" autocomplete="off">
   
 
<div class="Container" id="datosGenerales">
  <div class="ContainerDatosGenerales">
    <div class="ContainerDatosNip__ColOne">
      <table>
      	<tr>
      		<td style="width:39%"><div style="text-align:left"><label class="LabelTextNip" >Apellido Paterno:</label></div></td>
      		<td style="width:61%"><div style="text-align:left"><label id="apellidoPaterno" class="LabelTextEditNip"  >${generaNIP.apPaterno}</label></div></td>
      	</tr>
      	<tr>
      		<td style="width:39%"><div style="text-align:left"><label class="LabelTextNip" >Apellido Materno:</label></div></td>
      		<td style="width:61%"><div style="text-align:left"><label id="apellidoMaterno" class="LabelTextEditNip"  >${generaNIP.apMaterno}</label></div></td>
      	</tr>
      	<tr>
      		<td style="width:39%"><div style="text-align:left"><label class="LabelTextNip" >Nombre:</label></div></td>
      		<td style="width:61%"><div style="text-align:left"><label id="nombre" class="LabelTextEditNip"  >${generaNIP.nombre}</label></div></td>
      	</tr>
      	<tr>
      		<td style="width:39%"><div style="text-align:left"><label class="LabelTextNip" >Curp:</label></div></td>
      		<td style="width:61%"><div style="text-align:left"><label id="curp" class="LabelTextEditNip"  >${generaNIP.curp}</label></div></td>
      	</tr>
      	<tr>
      		<td style="width:39%"><div style="text-align:left"><label class="LabelTextNip" >NSS:</label></div></td>
      		<td style="width:61%"><div style="text-align:left"><label id="nss" class="LabelTextEditNip"  >${generaNIP.nss}</label></div></td>
      	</tr>
      </table>	
    </div>
    <div class="ContainerDatosNip__ColTwo" id="baseCurpCertificados">
    	<table>
	      	<tr>
	      		<td style="width:45%"><div style="text-align:left"><label class="LabelTextNip" >Correo electr&oacute;nico:</label></div></td>
	      		<td style="width:55%"><div style="text-align:left"><label id="correo" class="LabelTextEditNip"  >${generaNIP.correo}</label></div></td>
	      	</tr>
	      	<tr>
	      		<td style="width:45%"><div style="text-align:left"><label class="LabelTextNip" >N&uacute;mero celular:</label></div></td>
	      		<td style="width:55%"><div style="text-align:left"><label id="numeroCelular" class="LabelTextEditNip"  >${generaNIP.numeroCelular}</label></div></td>
	      	</tr>
	      	<tr>
	      		<td colspan="2">
	      			<div style="text-align:left">
	      				<input type="checkbox" id="checkGeneraNip"  onchange="autorizarGeneracionNip();" >
	      				<label for="checkGeneraNip">Autorización de generación de NIP*</label>
	      			</div>
	      		</td>
	      	</tr>
	      	<tr><td colspan="2"><div>&nbsp;</div></td></tr>
	      	<tr><td colspan="2"><div>&nbsp;</div></td></tr>
	      	<tr>
	      		<td colspan="2"><div style="text-align:right"><span font-size: 9px;>*campo obligatorio</span></div></td>
	      	</tr>
      	</table>
    </div>
  </div>
</div>
<div align="center">
	<span style="color:blue;text-decoration:underline;font-size: 10px;font-family: 'Roboto', sans-serif;">En caso de que el trabajador identifique alguna diferencia en su correo electrónico o número celular, deberá de hacer la corrección a través de su APP</span>
</div> 
<div class="ContainerButtonsCenter" >
    <button type="button" id="botonEnviar" class="Submit_disabled" disabled onclick="solicitarNipSubmit();">GENERAR</button>
</div>
<div class="ContainerButtonsCenter" id="botonCerrar">
    <button type="button" class="Submit" onclick="cerrarNipSubmit();">CERRAR</button>
</div>

</form:form>

</section>
<div class="push"></div>
</div>
	<jsp:include page="../generales/footerAgente.jsp" /> 
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
