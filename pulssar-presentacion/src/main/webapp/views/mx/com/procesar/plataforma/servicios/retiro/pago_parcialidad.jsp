<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Pago por Parcialidad</title>
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
	
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/bootstrap.min.js'/>"></script>	
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/bootstrap.js'/>"></script>								
					
				<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/accordion.js'/>"></script>
				<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pagoPorParcialidad.js'/>"></script>	
				<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/estatusPorParcialidad.js'/>"></script> 
				
				<%-- <script src="<c:url value='/webResources/js/pressFormulario.js'/>"></script> --%>
	
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
	
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
		<jsp:param name="menuTitle" value="PAGO POR PARCIALIDAD" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	<script type="text/javascript"> 
    
	var _FLUJO = "${respuesta.flujo}";
 	var estatus="${estatus}";

	var listaDes  = "${listaDescripcion}";
	var nPorPAgar ="${NumPorPagar}";
	var fechaPago= "${fechaPago}";
	var nFechaPAgo="${NumfechaPago}"; 


</script>
 <!-- Inicia Wrapper -->
        <div class="wrapper">
             <div class="Title__Container">
                    <h1>Pago de parcialidad <br>de retiro por desempleo</h1>
             </div> 	
      
            <form id="form-RetiroParcialidad" method="POST"  action="${pageContext.request.contextPath}/private/notificacionParcialidad.do" >
                   
                  
                   <div class="Container" style="margin-bottom: 80px">
                       <div class="Layout__XL">
                             <div class="Title">
                                  <p>Datos Generales</p>
                              </div>     
                              <div class="Datos_Container">
                                           <div class="Section">
                                               <div style="width:480px; max-width:100%;">     
									                <div class="DatosBack"><strong>NSS:</strong> ${datos.nss}</div>
										            <div class="DatosBack"><strong>CURP:</strong> ${datos.datosCertificables.curp}</div>
										            <div class="DatosBack"><strong>NOMBRE DEL TRABAJADOR:</strong> ${datos.datosCertificables.nombre}</div>
										            <div class="DatosBack"><strong>APELLIDO PATERNO:</strong> ${datos.datosCertificables.apellidoPaterno}</div>
										            <div class="DatosBack"><strong>APELLIDO MATERNO:</strong> ${datos.datosCertificables.apellidoMaterno}</div>
							                    </div>
							                     <div style="width:480px; max-width:100%;">
								                    <table>
									                      <tr class="RowHeader">
									                        <th width="25%">MENSUALIDAD</th>
									                        <th width="25%">FECHA</th>
									                        <th width="25%">MONTO</th>
									                        <th width="25%">ESTATUS</th>
									                      </tr>
								                     <c:forEach var="pagos" items="${listaSalida}" >
											               <tr class="Row1">
											                     <td align="left"><c:out value="${pagos.parcialidad}" /></td>
											                     <td><c:out value="${pagos.fechaPago}" /></td> 
											                     <td><c:out value="${pagos.montoParcialidad}" /></td>
											                 <c:choose>
											                 <c:when test="${pagos.estatus == 1}">
											                     <td><c:out value="${pagos.descripcionEstatus}" /></td>
											                 </c:when>
											                 </c:choose>   
											                     <td><c:out value="${pagos.descripcionEstatus}" /></td>
											                     
											               </tr>
								                      </c:forEach>
				                                    </table>
		                                          </div>
		                                          <%-- <div class="ModalText"> 
		                                                 <div class="Container_Section">
		                                                       <div class="row_containerbox">
		                                                             <div class="Form__Group">
																			<label class="LabelTextEdit" for="formaPagoTipoRetiro">Forma de Pago:</label>
																			<input class="InputEdit" id="formaPagoTipoRetiro" value="${formaDePago}"  type="text"  name="formaPagoTipoRetiro" data-not-null="0" data-nombre="Forma de Pago" readonly="readonly" />
																						
										                              </div>
																	  <div class="Form__Group">
																			<label class="LabelTextEdit" for="descripcionCtrlInstBancaria">Control Institución Bancaria:</label>
																			<input class="InputEdit" path="descripcionCtrlInstBancaria" type="text" id="descripcionCtrlInstBancaria" value="${nombreBanco}" data-not-null="0" data-nombre="Control Institución Bancaria" placeholder='Instituci&oacute;n Bancaria' readonly="readonly"/>
																			<div id="mensajeErrorInstBancaria"></div>
																			<input type="hidden" name="ctrlInstBancariaTipoRetiro"  id="ctrlInstBancariaTipoRetiro" />
																	   </div>
																		<div class="Form__Group">
																			<label class="LabelTextEdit" for="clabeTipoRetiro">Clabe:</label>
																			<input class="InputEdit" path="clabeTipoRetiro" type="text" name="clabeTipoRetiro" value="${cuentaCLABE}" placeholder="" id="clabeTipoRetiro" data-not-null="0" data-nombre="campo Clabe" readonly="readonly"/>
																		</div>
																		<div class="Form__Group">
																			<label class="LabelTextEdit" for="cuentaTipoRetiro">Cuenta:</label>
																			<input class="InputEdit" path="cuentaTipoRetiro" type="text" name="cuentaTipoRetiro" value="${enmascarCuenta}" placeholder="" id="cuentaTipoRetiro" data-not-null="0" data-nombre="campo Cuenta" readonly="readonly"/>
																		</div>
																		
																	
														
		                                                 </div> 
		                                          </div>
                                                
                                      </div>  --%>
                                                                        <input type="hidden" name="numeroParcialidad" id="numeroParcialidad" value="${numeroParcialidad}"/>   
																		<input type="hidden" name="idProcessar" id="idProcessar" value="${idProcessar}"/>
									                                    <input type="hidden" name="cuenta" id="cuenta" value="${cuenta}"/>   
																		<input type="hidden" name="idFormaPago" id="idFormaPago" value="${idFormaPago}"/>
																		<input type="hidden" name="idNombreBanco" id="idNombreBanco" value="${idNombreBanco}"/>
																		<input type="hidden" name="miModal2" id="miModal2" value="${miModal2}"/>
																		<input type="hidden" name="folio" id="folio" value="${folio}"/>
																		<input type="hidden" name="numeroResolucionParcial" id="numeroResolucionParcial" value="${numeroResolucionParcial}"/>
																		<input type="hidden" name="NumPorPagar" id="NumPorPagar" value="${NumPorPagar}"/>
																		<input type="hidden" name="fechaPago" id="fechaPago" value="${fechaPago}"/>
																		<input type="hidden" name="cuentaCLABE" id="cuentaCLABE" value="${cuentaCLABE}"/>
																		<input type="hidden" name="listaDescripcion" id="listaDescripcion" value="${listaDescripcion}"/>
																		<input type="hidden" name="folio" id="folio" value="${folio.folio}"/>
																		<input type="hidden" name="descripcionEstatus" id="descripcionEstatus" value="${descripcionEstatus}"/>
																		<input type="hidden" name="listaSalida" id="listaSalida" value="${listaSalida}"/>
                                      
							     </div>
                             </div>
                              <div class="ContainerButtons"> 
                             <input type="button" class="Submitx" value="Enviar" id="btnNotificaParcialidad" />
                             </div>   
                              
                      
                   </div>
                   </div>
         
 </form>
            
        </div> <!-- wrapper -->
		
		
	  <script type="text/javascript">
		jsonInstiticionesBancarias = '${jsonInstitucionBancaria}';	
	</script>
  <!-- finaliza Ventana Modal 2 -->
	 <jsp:include page="../generales/footerAgente.jsp" /> 
	<jsp:include page="../generales/notificaModals.jsp" />

 
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>

</body>
</html>
