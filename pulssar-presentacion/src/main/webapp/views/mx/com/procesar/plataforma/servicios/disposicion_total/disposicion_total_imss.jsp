<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title> </title>
	 <meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link> 	<link charset="utf-8" href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datepiker/datepiker.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datepiker/datepiker2.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tablesDisposicionTotal.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="../webResources/css/general/modal_window.css"></link>
    <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bootstrap_tables_dynamic.css'/>"></link>
    <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/dataTables.bootstrap.min.css'/>"></link> 
    <link charset="UTF-8" rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/jquery.dataTables.min.css'/>">
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.js'/>"></script>
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery.plugin.js'/>"></script>
	<!-- Data Tables Bootstrap Dynamic CSS  and javascript -->
	<script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/jquery-3.0.0.min.js'/>"></script>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/dataTables.bootstrap.min.js'/>"></script>
    <script type="text/javascript" charset="utf-8" src="<c:url value='/webResources/js/funcionesGenerales.js'/>"></script>	
    <script type="text/javascript" src="<c:url value='/webResources/js/datepiker.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/webResources/js/datepiker2.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/derechoCargado.js'/>"></script> 
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/resolucionModal.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/ventanillaAfore.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/subCuentasRcvViviendaImms.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/expediente_imss.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/disposicion_total_imss_beneficiarios.js'/>"></script>
	
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pressFormulario.js'/>"></script>
	<%-- <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/table_retiros.js'/>"></script> --%>
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
		<jsp:param name="menuTitle" value="DISPOSICION TOTAL IMSS" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	<script type="text/javascript"> 
    
	var _FLUJO = "${respuesta.flujo}";
	var estatus="${estatus}";
    var listaDerechoCargado = "${listaDerechoCargado}";
    var radioCargado = "${radioCargado}";

</script>


   
  <!-- Inicia Wrapper -->
    <div class="wrapper">
    <!-- inicia seccion datos Complementarios -->
    <br>
    <div class="Container">
      <div class="Layout__XL">
           <div class="Title">
            <p>Selección de Derecho</p>
          </div>
          <div class="Datos_Container">
             <!--  <div class="Form__Group">
                <label class="Label_longtext" id="labelCvAfore" for="usuario">Clave Afore:</label>
                <input class="Inputxxl" id="cvAfore" type="text" name="" value="" placeholder="CLAVE AFORE" >
              </div> -->
              <div class="Form__Group">
	              <label class="Label_longtext" for="usuario">Tipo de Régimen:</label>
	                <select name="tipoRegimen" class="Select_longtext"  id="tipoRegimen" >
                    </select>
            </div>
             <center><span id="errorTipoRegimenObligatorio" class="error_span">Selección del Régimen Obligatoria</span></center>
            <div class="Form__Group">
              <label class="Label_longtext" for="usuario">Tipo de Retiro:</label>
              <select class="Select_longtext" id="tipoRetiro" name="tipoRetiro">
                        </select>
                      
            </div>
            <div class="Form__Group">
              <label class="Label_longtext" for="usuario">Tipo Seguro:</label>
                   <select class="Select_longtext" name="tipoSeguro" id="tipoSeguro">
	               </select>
            </div>
            <div class="Form__Group">
              <label class="LabelTextEdit" for="usuario">Tipo Pensión:</label>
              <select class="Select_longtext" id="tipoPension"  name="tipoPension">
               </select>
            </div>
           <div class="Form__Group">
              <label class="LabelTextEdit" for="usuario">Tipo Prestación:</label>
              <select class="Select_longtext" id="tipoPrestacion"  name="tipoPrestacion" onchange="mostrarTablasRcvVivienda()">
               </select>
            </div>
          							
			<fieldset>
					  <div class="Form__Group" id="ventanillaAforeDiv"> 
										<label class="LabelText" for="usuario" >Ventanilla Afore
											<input type="radio"   name="ventanilla" id="ventanillaAfore" onclick="mostrarVentanillaAfore()" value="0201"/>
										</label>
										
					 </div> 
					 <div class="Form__Group" id="ventanillaInfonavitDiv"> 
										<label class="LabelText" for="usuario">Ventanilla Infonavit
											<input type="radio"  name="ventanilla" id="ventanillaInfonavit" onclick="mostrarVentanillaAfore()" value="0101"/>
										</label>
					 </div>   
			</fieldset>				
           <!-- </div> -->
         </div>  <!--  Datos_Container -->
         <div class="Datos_ContainerColumn">
             <div class="row_container">
	                <div class="Section">
			            <div style="width: 100%; max-width: 480px;"> 
			                    <div class="Form__Group">
				                  <label class="LabelText" for="usuario">Número de Resolución:</label>
				                  <input class="Inputxxl" id="numeroResolucion" type="text" onKeyPress="return soloNumeros(event,this)" name="" value="" placeholder="Número de Resolución" />
		                       </div>
		                       <div class="Form__Group">
				                  <label class="LabelText" for="usuario">Número Semanas Cotizadas:</label>
				                  <input class="Inputxxl" type="text" id="numeroSemanasCotizadas" onKeyPress="return soloNumeros(event,this)" name="" value="" placeholder="Número Semanas Cotizadas" data-numeros="0"  maxlength="4"/>
				                </div>
			                   <div class="Form__Group">
			                       <label class="LabelText" for="usuario">Secuencia Pensión:</label>
				                   <input class="Inputxxl" id="secuenciaPension" type="text" name="" value="" placeholder="Secuencia Pensión"  maxlength="2"/>
				               </div>
					         
					            <div class="Form__Group">
                                    <div class="Form__Group" id="numeroPlanDiv">
				                          <label class="LabelText" for="usuario" >Numero de Registro del Plan Privado de Pensiones:</label>
				                       <input class="Inputxxl" id="numeroPlan" type="text" name="numeroPlan" value="" placeholder="NUMERO PLAN" />
				                    </div>  
				                </div>
			             </div>
			              <div style="width: 100%; max-width: 480px;">
				                 <div class="Form__Group">
				                  <label class="LabelText" for="usuario">Fecha Emisión Pensión:</label>
				                  <input class="Inputxxl" id="fechaEmisionResolucion" type="text" name="" value="" placeholder="Fecha Emisión Pensión" />
				                </div> 
					            <div class="Form__Group" id="porcentajeValuacionDiv">
						                  <label class="LabelText" for="usuario">Porcentaje Evaluación:</label>
						                  <input class="Inputxxl" type="text" id= "porcentajeValuacion" onKeyPress="return soloNumeros(event,this)" name="" value="${campoPorcentajeValuacion}" placeholder="Porcentaje Evaluación"  maxlength="6" data-numeros="0" />
						                </div>
						          <div class="Form__Group">
					                  <label class="LabelText" for="usuario">Fecha Inicio Pensión:</label>
					                  <input class="Inputxxl" id="fechaIncioPension"  type="text" name="" value="" placeholder="Fecha Inicio Pensión" min="2020-01-01" max="2020-01-01" onchange="validarFechaIn()"  readonly="readonly" />
					                     <center><span id="spanFechaIn" class="error_span">La fecha a capturar deberá ser igual o menor a la fecha de solicitud del trámite</span></center>
					            </div>       
						       
				                 <div class="Form__Group" id="actuarioDiv">
	                                    <label class="LabelText" for="usuario">ACTUARIO AUTORIZADO:</label>
					                         <select class="Select_longtext" id="actuario" name="actuario">
									              <option value="">Seleccione una opción</option>
									              <c:forEach items="${listaActuarios}" var="actuario">
														 <option value="${actuario.cvActuario}"> 
														 <c:out value="${actuario.nombre}"></c:out>
														 </option> 
												    </c:forEach>
					                        </select>
	                            </div>
				                <div class="Form__Group" id="nrpCampoDiv">
									<label class="LabelText" for="nrp">Nrp:</label>
									<input class="Inputxxl" type="text" id="nrpCampo" data-not-null="0" data-nombre="Control Nrp" placeholder='NRP' required="required" />
							    </div> 
				                
                         </div>
                         <div style="width: 100%; max-width: 480px;">
                             <div class="Form__Group" id="documentoProbatorioDiv">
                                     <label class="LabelText" for="usuario">CLAVE DOCUMENTO PROBATORIO:</label>
			                         <select class="Select" id="documentoProbatorio" name="documentoProbatorio">
							              <option value="">Seleccione una opción</option>
							              <c:forEach items="${documentoProbatorio}" var="documento">
												 <option value="${documento.idTipoDoctoProbatorio}"> 
												 <c:out value="${documento.descripcion}"></c:out>
												 </option> 
										    </c:forEach>
			                        </select>
                                 </div>
                                   
                              
                         </div>
                         <div style="width: 100%; max-width: 480px;">
	                             
	                           
	                      </div>
	                    
			       </div>        
              </div>
            </div>
        
        
             <div class="ContainerButtons">
               <!--  <input id="btnValidarSubCuentas" class="Submit" type="button" value="SubCuentas"/> -->
                
           </div> 
        
            <div class="Title" id="EncabezadoTrabajador">
	            Datos Generales del trabajador
	        </div>
	        <div class="Datos_Container">
                   <c:if test="${not empty listaAseguradoras}">
                      <div class="Form__Group" id="aseguradoraDiv">
                        <label class="Label_longtext" for="usuario">Aseguradora:</label>                  
					   <select class="Select_longtext" id="aseguradora" name="aseguradora">
						     <option value="">Seleccione una opción</option>
						              <c:forEach items="${listaAseguradoras}" var="aseguradora">
											 <option value="${aseguradora.claveAfore}"> 
											 <c:out value="${aseguradora.descripcionAfore}"></c:out>
											 </option> 
									    </c:forEach>
		                </select>          
                      </div>
                      </c:if>
                       <c:if test="${empty listaAseguradoras}">
                      <div class="Form__Group">
                        <label class="Label_longtext" for="usuario">Aseguradora:</label>                  
                        <select id="aseguradora"  class="Select_longtext" name="aseguradora"  data-not-null="0" data-nombre="aseguradora">
								     <option value="999">999</option>
							</select>
                      </div>
                      </c:if>      
			      <div class="row_container">
	                 <div class="Section">
						      <div style="width: 100%; max-width: 480px;"> 
			                  
				              <div class="Form__Group" id="curpAgenteServicioDiv">
						                  <label class="LabelTextEdit" for="usuario">CURP AGENTE SERVICIO:</label>
						                  <input class="InputEdit" id="curpAgenteServicio" type="text" name="" value="${curpAgenteServicio}" placeholder="" disabled />
				               </div>
				              
			                 
               
				                   <div class="Form__Group" id="solicitanteDiv">
				                        <label class="LabelText" for="usuario">CLAVE SOLICITANTE:</label>
				                        <input class="Inputxxl"  id= "solicitante" type="text" name="" value="${cvTipoSolicitante}" placeholder="CLAVE SOLICITANTE" disabled/>
				                    </div>
                              
              
					            
						                     <div class="Form__Group" id="fechaNacimientoDiv">
						                        <label class="LabelText" for="usuario">FECHA NACIMIENTO:</label>
						                           <input class="Inputxxl"  id= "fechaNacimiento" type="text" name="" value="${fechaNacimiento}" placeholder="FECHA NACIMIENTO" disabled />
						                     </div>
						         
			                 </div>
				             <div style="width: 100%; max-width: 480px;">
					                <div class="Form__Group" id="fechaSolicitudDiv">
							                        <label class="LabelText" for="usuario">FECHA SOLICITUD:</label>
							                        <input class="Inputxxl"  id= "fechaSolicitud" type="text" name="" value="${fechaSolicitud}" placeholder="FECHA SOLICITUD" disabled />
							                    </div>
				                    <div class="Form__Group" id="descripcionSolicitanteDiv">
					                        <label class="LabelText" for="usuario">DESCRIPCION SOLICITANTE:</label>
					                        <input class="Inputxxl"  id= "descripcionSolicitante" type="text" name="" value="${DescripcionSolicitante}" placeholder="DESCRIPCION SOLICITANTE" disabled />
					                </div>
					               <div class="Form__Group" id="fechaSolicitudDiv">
							                        <label class="LabelText" for="usuario">APELLIDO PATERNO:</label>
							                        <input class="Inputxxl"  id= "apellidoPaterno" type="text" name="apellidoPaterno" value="${apellidoPaterno}" placeholder="APELLIDO PATERNO" disabled />
							        </div>
					                 
	
	                         </div>
	                         <div style="width: 100%; max-width: 480px;">
					                <div class="Form__Group" id="nombre AforeDiv">
							                        <label class="LabelText" for="usuario">NOMBRE DE AFORE:</label>
							                        <input class="Inputxxl"  id= "nombreTrabajador" type="text" name="nombreTrabajador" value="${nombreTrabajador}" placeholder="NOMBRE  DEL TRABAJAOR" disabled />
							                    </div>
				                    <div class="Form__Group" >
					                       <label class="LabelText" for="usuario">CUS:</label>
					                        <input class="Inputxxl"  id= "cus" type="text" name="cus" value="${retiroDesempleoImss.cus}" placeholder="CUS" disabled />
					               </div>
					               
					                 <div class="Form__Group" >
		                              
		                             </div>
	
	                        </div>
	                       <div style="width: 100%; max-width: 480px;">
					                <div class="Form__Group" id="fechaSolicitudDiv">
							                        <label class="LabelText" for="usuario">APELLIDO MATERNO:</label>
							                        <input class="Inputxxl"  id= "apellidoMaterno" type="text" name="apellidoPaterno" value="${apellidoMaterno}" placeholder="APELLIDO PATERNO" disabled />
							        </div>
				                   
					               
					                 <div class="Form__Group" >
		                              
		                             </div>
	
	                        </div> 
					</div>     
				 </div>		             
           
         </div>  <!-- Findatos generales-->  
	      <div class="Title" id="EncabezadoVentanillaAfore">
	            Ventanilla Afore
	      </div>    
	        <div class="Datos_Container" id="containderAforeDiv">
                      
			      <div class="row_container" >
	                 <div class="Section">
						      <div style="width: 100%; max-width: 480px;"> 
			                  
				              <div class="Form__Group" id="clabePagoDiv">
						           <label class="LabelText" for="usuario">Clabe de Pago: * </label>
						           <input class="Inputxxl" id="clabePago" type="text"  name="" value="" onkeyup="validaClabePago()" placeholder="CLABE DE PAGO" required />
				               </div>

				                   <div class="Form__Group" id="curpPagoDiv">
				                        <label class="LabelText" for="usuario">CURP de Pago:</label>
				                        <input class="Inputxxl"  id="curpPago" type="text" name="" value="" placeholder="CURP DE PAGO" data-curp-nss="0"  required />
				                    </div>
                           		    <div class="Form__Group" id="rfcPagoDiv">
			                        <label class="LabelText" for="usuario">RFC de Pago:</label>
			                           <input class="Inputxxl"  id= "rfcPago" type="text" name="" value="" placeholder="RFC DE PAGO" required />
			                     </div>
						         
			                 </div>
				             <div style="width: 100%; max-width: 480px;">
					                <div class="Form__Group" >
							                        <label class="LabelText" for="usuario">Folio INFONAVIT:</label>
							                        <input class="Inputxxl"  id= "folioInfonavit" type="text" name="" value="" placeholder="FOLIO INFONAVIT" required />
							         </div>
				                  
					                <div class="Form__Group" id="vSolicitanteDiv">
					                         <label class="LabelText" for="usuario">Tipo de Solicitante:</label>
					                            <%-- <input class="Inputxxl"  id= "vSolicitante" type="text" name="" value="${DescripcionSolicitante}" placeholder="" required /> --%> 
					                        <select id="vSolicitante"  class="Select_longtext" name="vSolicitante"  data-not-null="0" data-nombre=""  onclick="mostrarComboSolicitante()" required>
											     <option value="">Seleccione una opción</option>
											     <option value="1">Beneficiario</option>
											     <option value="2">Trabajador</option>
							              </select> 
							                   
					                </div>
					               
					                 <div class="Form__Group" id="grupoTrabajadorDiv">
		                                <label class="LabelText" for="usuario">Grupo de Trabajador:</label>
		                                  <input class="Inputxxl"  id= "grupoTrabajador" type="text" name="" value="" placeholder="GRUPO DE TRABAJADOR" />
		                             </div>
	                         </div>
					</div>     
				 </div>	
                 				 
				 	             
            </div>  
            <br/>
            <br/>
	        <div class="Title" id="EncabezadoBeneficiarioDiv">
	            Beneficiarios
	        </div>  
	        <div class="Datos_Container" id="containerBeneficiarioDiv">
                      
			      <div class="row_container" >
	                 <div class="Section">
						      <div style="width: 100%; max-width: 480px;"> 
			                  
				              <div class="Form__Group" >
						                  <label class="LabelText" for="usuario">Apellido Paterno del Beneficiario de Pago:</label>
						                  <input class="Inputxxl" id="apPaternoBeneficiario" type="text" name="" value="" placeholder="Apellido Paterno del Beneficiario de Pago"  />
				               </div>

				                   <div class="Form__Group" >
				                        <label class="LabelText" for="usuario">Nombre del Beneficiario de Pago:</label>
				                        <input class="Inputxxl"  id= "nombreBeneficiario" type="text" name="" value="" placeholder="Nombre del Beneficiario de Pago" />
				                    </div>
                           		    <div class="Form__Group" >
			                        </div>
						         
			                 </div>
				             <div style="width: 100%; max-width: 480px;">
					                <div class="Form__Group" id="fechaSolicitudDiv">
							                        <label class="LabelText" for="usuario">Apellido Materno del Beneficiario de Pago:</label>
							                        <input class="Inputxxl"  id="apMaternoBeneficiario" type="text" name="" value="" placeholder="Apellido Materno del Beneficiario de Pago"  />
							                    </div>
				                   
					                <div class="Form__Group" id="vSolicitanteDiv">
					                </div>
					               
					                 <div class="Form__Group" id="fechaSolicitudDiv">
		                             </div>
	
	                         </div>
	                        
					</div>     
				 </div>		             
            </div>  <!-- beneficiario -->
	    
	    
	    <div id="tablasSub">
        	<div  onclick="sectionone()" class="Title_OneOption">
              <div class="Title_Text">Montos Subcuentas RCV</div>
              <div class="Arrows"></div>
            </div>

            <div id="section_one" class="Container_One">
	              <div class="row_containerbox">
	              
	              <div id="datosrcv" style="display:none;">
               
                    </div>
                     <div class="Modal_Container" >
       
		          <div class="SeccionTable">
		           <center>
		            <table id="tableRcv" class="table table-striped table-bordered" style="width:100%">
	               </table> 
	                <div class="Datos_ContainerColumn">
            <div class="row_container">
              <div class="Datosxl">
                <div class="Form__Group">
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" style="font-size:20px;">
                     <strong>MONTO TOTAL:</strong>
                     <strong id="montoTotalRcv"></strong>
                  </label>
                </div>
              </div>
              </div>
            </div>
            <center><span id="subCuentasErrorRcv" class="error_span">No existe informacion Subcuentas Rcv</span></center>
	            </center>
	           </div>
               </div>
		       
	            </div>
          </div>
          <div id="section" onclick="section_two()" class="Title_TowOption">
                <div class="Title_Text">
                  Montos Subcuentas Vivienda
                </div>
                <div class="Arrows"></div>
          </div>

              <div id="section_two" class="Container_Two">
                 <div class="row_containerbox">
                     <div id="datosvivienda" style="display:none;">
                     </div>
             
                <div class="Modal_Container" >
       
		          <div class="SeccionTable" id="tabViv">
		           <center>
		            <table id="tablaVivienda" class="table table-striped table-bordered" style="width:100%">
	               </table>
	       <div class="Datos_ContainerColumn">
            <div class="row_container">
              <div class="Datosxl">
                <div class="Form__Group">
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                </div>
              </div>
              <div class="Datosxl">
                 <div class="Form__Group" id="montoTotalVivDiv">
                  <label class="LabelTextEdit" style="font-size:20px;">
                     <strong>MONTO TOTAL:</strong>
                     <strong id="montoTotalViv"></strong>
                     <strong id="montViv"></strong>
                 </label>
                 
                </div> 
              </div>
              
           <br/>
              </div>
            </div>
          </div>
	            </center>
	             </div><center><span id="spanEstatusMarca" class="error_span">Subcuenta de Vivienda NO disponible por crédito de vivienda</span></center> 
               </div> <center><span id="spanSubcuentas" class="error_span">El Trabajador debe contar con al menos una subcuenta con  un monto mayor a cero para proceder al envío de la Solicitud de Disposición de Recursos</span></center>
               <center><span id="marcasErrorVivienda" class="error_span">No existe informacion marcas de Subcuentas Vivienda</span></center>
               <center><span id="subCuentasErrorVivienda" class="error_span">No existe informacion Subcuentas Vivienda</span></center>
              </div> 
          
          </div>
          
          <br>
         <!--  <div class="Title">
            Beneficiario
          </div> -->
          
          <div class="ContainerButtons" id="btnAdicionarBeneficario">
                 <a  href="#" class="Submitx" id="btnMostrarModalCaptura" />AGREGAR</a>  
                  <a  id="elimBen" class="Submitx" onclick="eliminarRegChecksSele()">Eliminar</a>
          </div>
          <br/>  
          
        <!--   <p align="left"> Numero de Registros:
			<div id="adicionados"></div> 
		 </p> -->      
          <div class="SeccionTable">
            <div style="overflow-x: auto;">
              <table id="tablaBeneficiariosImss" class="table table-striped table-bordered" style="width:100%">
                 <thead> 
                  <tr class="RowHeader" id="rowOriginal">
                    <th>CURP</th>
                    <th>Nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                    <th>RFC</th>
                    <th>Porcentaje</th>
                    <th>Banco</th>
                    <th>Cuenta Clabe</th>
                    <th>Eliminar</th>
                    <th><input onclick="marcar(this);" type="checkbox" name="select_all" value="CHECKPRINC" id="chboxAll"></th> 
                  </tr>
                </thead> 
                <!-- <tbody id="tabBen">
                 
                </tbody> -->
              </table>
            </div>
          </div> 
            <div class="Datos_ContainerColumn">
            <div class="row_container">
              <div class="Datosxl">
                <div class="Form__Group">
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" style="font-size:20px;">
                     <strong>TOTAL:</strong>
                     <strong id="porcentajeTotal"></strong>
                  </label>
                </div>
              </div>
              </div>
            </div>
   </div>  <!-- Fin Datos_ContainerColumn -->
   </div><!-- Fin contanier --> 
   <div class="ContainerButtonsCenter">
    <a  href="#" id="btnGenerarExpediente" class="Submitx" >Generar Expediente</a> 
    <!-- <input id="btnGenerarExpediente" class="Submit" type="button" value="GENERAR EXPEDIENTE"/>  -->
    </div>
       <br>
       <br>
      
		 <div id="modalConsultaCargado" class="Modal">
		       <div class="ModalContainer" style="max-width:90%;">
		              <div class="ModalHeader">
				      <h2 class="ModalTitle">Cadena de Derecho</h2>
				      <a href="#" class="ModalButton">X</a>
				      </div>
		          <form  name="formCargado">
		           <div class="Modal_Container">
		                <div class="SeccionTable">
		                     <center>
		                           <table id="tablaCadenaDerecho" class="table table-striped table-bordered" style="width:100%">
		                                <thead>
		                                      <tr class="RowHeader" style="font-size:10px;">
		                                               <th class="th_tabla"></th>
		                                               <th class="th_tabla">Número Resolución</th>
										               <th class="th_tabla" >Tipo Retiro</th>
										               <th class="th_tabla" >Tipo Seguro</th>
										               <th class="th_tabla">Tipo Pensión</th>
										               <th class="th_tabla">Tipo Prestación</th>
										               <th class="th_tabla">Tipo Régimen</th> 
		                                      </tr>
		                                </thead>  
		                             <tbody>
		                               <c:forEach items="${listaSolicitante}" var="lista">
		                                   <tr class="Row1">
		                                      <td>
		                                        <input type="radio" id="radioButton" name="radioButton" value="${lista.numeroResolucion}"  onclick="javascript:habilitarDatosEnvio('${lista.radioCargado}','${lista.cvTipoRetiro}','${lista.cvTipoSeguro}','${lista.cvTipoPension}','${lista.cvTipoPrestacion}','${lista.cvTipoRegimen}','${lista.numeroResolucion}','${lista.secuenciaPension}','${lista.fcInicioPension}','${lista.fcEmisionResolucion}','${lista.porcentajeValuacion}','${lista.semanasCotizadas}')"/>   
		                                      </td>
													<td class="td_tabla" id="celda1"><c:out value="${lista.numeroResolucion}" /></td>
													<td class="td_tabla" id="celda2"><c:out value="${lista.descTipoRetiro}" /></td>
													<td class="td_tabla" id="celda3"><c:out value="${lista.descTipoSeguro}" /></td>
													<td class="td_tabla" id="celda4"><c:out value="${lista.descTipoPension}" /></td>
													<td class="td_tabla" id="celda5"><c:out value="${lista.descTipoPrestacion}" /></td>
													<td class="td_tabla" id="celda6"><c:out value="${lista.descTipoRegimen}" /></td>
													
		                                   </tr>
		                             </c:forEach>
		                             </tbody>
		                           </table>  
		                           <%-- <center><span id="ErrorSolicitanteCargado" class="error_span">Seleccione otro dato para la carga, este no esta relacionado al tipo solicitante</span>
		                           </center>  --%>
		                        </center>
		                            <center><span id="spanFechaNac" class="error_span">El Trabajador no cuenta con la Edad Requerida para el Trámite</span></center>
		               
		                <div class="ContainerButtonsCenter" id="btnEnviarCargadoDiv">
				          <a href="#" id="btnEnviarCargado" onclick="obtenerDatosTabla()" class="Submitx">Aceptar</a>
				          <a href="#" id="btnCancelaCargado" class="Submitx">Cancelar</a>
				        </div>
				         </div> 
		              </div> 
		         </form>  
		     </div>
		 </div>
		 
		  <div id="modalCapturaNrp" class="Modal" >
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 id="tituloFormaPago" class="ModalTitle">Captura Nrp</h2>
					<a href="#" class="ModalButton" onclick="cerrarModal();">X</a> 
				</div>
				<div class="ModalText">
					<div class="Container_Section">
						<div class="row_containerbox">
							<div style="width:100%;max-width: 680px;">
							 <div class="Form__Group">
								<label class="LabelText" for="nrp">Nrp:</label>
								<input class="Inputxxl" type="text" id="nrp" data-not-null="0" data-nombre="Control Nrp" placeholder='NRP' required="required" maxlength="8" />
								
							</div> 
							 <center>
						         <span id="errorValidarNrp" class="error_span">
						         </span>
                            </center> 
						 </div>
						</div>
					</div>
				</div>
				<div class="ContainerButtons">
					<a  href="#"  class="Submitx" id="btnPopupValidarNrp"  />Validar</a>
				</div>
			</div>
        </div>
         <div id="modalAdicionarBeneficiario" class="Modal" >
			<div class="ModalContainer">
				<div class="ModalHeader">
				     <h2 id="tituloFormaPago" class="ModalTitle">Captura Beneficiarios</h2>
				     <a href="#" class="ModalButton" id="btnInfoM">X</a> 
   			    </div>
				<div class="ModalText">
					<div class="Container_Section">
						<div class="row_containerbox">
							<div style="width:100%;max-width: 680px;">
							 <div class="Form__Group">
								<label class="LabelText" for="nrp">CURP*:</label>
								<input class="InputEdit" type="text" id="curpBen" title="La captura de la Curp es requerida" data-not-null="0" placeholder='CURP' required="true" noPaste="false"/>
						   <!-- <input class="Inputxxl"  id= "curpPago" type="text" name="" value="" placeholder="CURP DE PAGO" data-curp-nss="0"  required /> -->
							 </div> <center><span id="spanCurpBen" class="error_span">La CURP tiene formato incorrecto</span></center>
							<%--  <center>
						         <span id="errorValidarNrp" class="error_span">
						         </span>
                            </center>  --%>
                             <div class="Form__Group">
								<label class="LabelText" for="nombre">NOMBRE*:</label>
								<input class="InputEdit" type="text" id="nombreBen" data-not-null="0" data-nombre="Control nombre" placeholder='NOMBRE'  maxlength="40" onKeyPress="return soloLetras(event)" noPaste="true"/>
							 </div>
							  <div class="Form__Group">
								<label class="LabelText" for="apPatBen">APELLIDO PATERNO*:</label>
								<input class="InputEdit" type="text" id="apPatBen" data-not-null="0" data-nombre="Control apellido paterno" placeholder='APELLIDO PATERNO' maxlength="40" onKeyPress="return soloLetras(event)" noPaste="true"/>
							 </div>
							  <div class="Form__Group">
								<label class="LabelText" for="apMatBen">APELLIDO MATERNO*:</label>
								<input class="InputEdit" type="text" id="apMatBen" data-not-null="0" data-nombre="Control apellido materno" placeholder='APELLIDO MATERNO'  maxlength="40" onKeyPress="return soloLetras(event)" noPaste="true"/>
							 </div>
							  <div class="Form__Group">
								<label class="LabelText" for="rfcBen">RFC:</label>
								<input class="InputEdit" type="text" id="rfcBen" data-not-null="0" data-nombre="Control rfc" placeholder='RFC' size="24"  noPaste="true" />
							 </div><center><span id="spanRfcBen" class="error_span">El RFC tiene formato incorrecto</span></center>
							  <div class="Form__Group">
								<label class="LabelText" for="porcentajeBen">PORCENTAJE*:</label>
								<input class="InputEdit" type="text" id="porcentajeBen" data-not-null="0" data-nombre="Control porcentaje" placeholder='PORCENTAJE' required="required" onKeyPress="return soloNumeros(event,this)" noPaste="true"/>
							 </div><center><span id="spanPorcentaje" class="error_span">El porcentaje capturado excede el 100%</span></center>
			                <div class="Form__Group">
                        <label class="LabelText" for="banco" id="banco">BANCO*:</label>                  
                          <select  id="bancoBen"  class="Select_longtext" onchange="habilitarCuentaClabe()">
							</select> 
                      </div>
							  <div class="Form__Group">
								<label class="LabelText" for="cuentaClabeBen">CUENTA CLABE*:</label>
								<input class="InputEdit" type="text" id="cuentaClabeBen" data-not-null="0" data-nombre="Control cuentaClabe" placeholder='CUENTA CLABE' required="required" onKeyPress="return soloNumeros(event,this)" maxlength="18" noPaste="false"/>
							 </div><center><span id="spanCuentaClabe" class="error_span">La Cuenta clabe no es válida</span><br /><span id="spanCuentaClabeBanco" class="error_span">La Cuenta clabe no corresponde al banco seleccionado</span><br /><span id="spanObligatoriosBen" class="error_span">Los campos con asterisco son obligatorios</span></center>
			
						 </div>
						</div>
					</div>
				</div>
				<div class="ContainerButtons">
					<a  href="#"  class="Submitx" id="btnAdicionarBeneficiario" />ACEPTAR</a>
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
                          <select  id="siefores"  class="Select_longtext" onchange="selecionaSiefor()">
						    <option value="0">Seleccione una Siefore</option>
							 <c:forEach items="${listaSiefores}" var="combo" varStatus="counter">
								 <option value="${combo.clave}">${combo.nombreSiefore}</option>
								 </c:forEach>
							</select> 
                      </div>
                      </c:if>
                      
                        
			</div>
        <div class="Modal_Container" >
          <div id="valorPosicion"></div>
           <div id="valorCampoSar"></div>
           <center>
				
				</center> 
      </div>
       <div class="ContainerButtonsCenter">
		   <a  id="aceptarSiefor" class="Submitx" onclick="cierraModalSeleccionarSiefore();aceptarSiefore()">ACEPTAR</a>
            <a class="Submitx" onclick="cierraModalSeleccionarSiefore()">Cancelar</a>
		              </div>
     </div>
   </div>
	 
		 
  <input id="valorRadio" name="valorRadio" path="valorRadio" type="hidden"/>
<input type="hidden" name="curpAgenteServicio" id="curpAgenteServicio" value="${curpAgenteServicio}"/>
<input type="hidden" name="documentoProbatorio" id="documentoProbatorio" value="${documentoProbatorio}"/>   	
<input type="hidden" name="fechaSolicitud" id="fechaSolicitud" value="${fechaSolicitud}"/>
<input type="hidden" name="edadTrabajdor" id="edadTrabajdor" value="${edadTrabajdor}"/>
<input type="hidden" name="nrp" id="nrp" value="${nrp}"/>  
<input type="hidden" name="cvTipoRetiro" id="cvTipoRetiro" value="${cvTipoRetiro}"/>                
 <input id="valorRadio" name="valorRadio" path="valorRadio" type="hidden"/> 
 <input type="hidden" name="claveTipRetiro" id="claveTipRetiro" value="${claveTipRetiro}"/>
 <input type="hidden" name="claveTipSeguro" id="claveTipSeguro" value="${claveTipSeguro}"/>
 <input type="hidden" name="claveTipoPension" id="claveTipoPension" value="${claveTipoPension}"/>
 <input type="hidden" name="claveTipoPrestacion" id="claveTipoPrestacion" value="${claveTipoPrestacion}"/>
 <input type="hidden" name="claveTipoRegimen" id="claveTipoRegimen" value="${claveTipoRegimen}"/>
 <input type="hidden" name="numeroResolucion" id="numeroResolucion" value="${numeroResolucion}"/>
 <input type="hidden" name="secuenciaPension" id="secuenciaPension" value="${secuenciaPension}"/>
 <input type="hidden" name="porcentajeValuacion" id="porcentajeValuacion" value="${porcentajeValuacion}"/>
 <input type="hidden" name="numeroSemanasCotizadas" id="numeroSemanasCotizadas" value="${numeroSemanasCotizadas}"/>
 
 <input type="hidden" name="fechaIncioPension" id="fechaIncioPension" value="${fechaIncioPension}"/>
 <input type="hidden" name="fechaEmisionResolucion" id="fechaEmisionResolucion" value="${fechaEmisionResolucion}"/>

 <input type="hidden" name="descTipoRetiro" id="descTipoRetiro" value="${descTipoRetiro}"/>
  <input type="hidden" name="descTipoSeguro" id="descTipoSeguro" value="${descTipoSeguro}"/>
  <input type="hidden" name="descTipoPension" id="descTipoPension" value="${descTipoPension}"/>
  <input type="hidden" name="descTipoPrestacion" id="descTipoPrestacion" value="${descTipoPrestacion}"/>
  <input type="hidden" name="descTipoRegimen" id="descTipoRegimen" value="${descTipoRegimen}"/>
   <input type="hidden" name="consultaNRP" id="consultaNRP" value="${consultaNRP}"/>	 
   <input type="hidden" name="listaDerechoCargrado" id="listaDerechoCargrado" value="${listaDerechoCargrado}"/>
  <input type="hidden" name="listaDerechoNoCargado" id="listaDerechoNoCargado" value="${listaDerechoNoCargado}"/>
  
  <input type="hidden" name="mapa" id="mapa" value="${mapa}"/>
  <input type="hidden" name="radioCargado" id="radioCargado" value="${radioCargado}"/>
 <input type="hidden" name="cargaResoluciones" id="cargaResoluciones" value="${cargaResoluciones}"/>
 <input type="hidden" name="valorRadioDos" id="valorRadioDos" value=""/>
 <input type="hidden" name="listaClaveProceso" id="listaClaveProceso" value="${listaClaveProceso}"/>
 <input type="hidden" name="nombreTrabajador" id="nombreTrabajador" value="${nombreTrabajador}"/>
 <input type="hidden" name="apellidoPaterno" id="apellidoPaterno" value="${apellidoPaterno}"/>
 <input type="hidden" name="apellidoMaterno" id="apellidoMaterno" value="${apellidoMaterno}"/>
 <input type="hidden" name="valorSieforeTemporal" id="valorSieforeTemporal"/>
 <input type="hidden" name="valorAccionesTempo" id="valorAccionesTempo"/> 
  <input type="hidden" name="idCheck" id="idCheck"/>
  <input type="hidden" name="borrarTabla" id="borrarTabla"/> 
 <br>
 </br>
  
  <!-- Inicia seccion -->
	
  
  
  
    
 <jsp:include page="../generales/footerAgente.jsp" /> 
<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>

  <jsp:include page="../generales/modals.jsp" />   
 <jsp:include page="../generales/modalResolucionCarga.jsp" /> 
</body>
</html>
