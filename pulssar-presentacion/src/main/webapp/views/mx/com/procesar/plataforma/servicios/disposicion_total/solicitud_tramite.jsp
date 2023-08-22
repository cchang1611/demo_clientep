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
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/container.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/modal_window.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	
	<link rel="stylesheet" type="text/css" href="../webResources/css/1.5.8/slick-theme.min.css">
	<link rel="stylesheet" type="text/css" href="../webResources/css/1.5.8/slick.css">
	<link rel="stylesheet" type="text/css" href="../webResources/css/general/carousel/slick_carousel.css">
	
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/bootstrap.min.js'/>"></script>	
	<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/bootstrap.js'/>"></script>								
					
				<script type="text/javascript" charset="UTF-8"
					src="<c:url value='/webResources/js/accordion.js'/>"></script>
				<%-- <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pagoPorParcialidad.js'/>"></script>	
				<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/estatusPorParcialidad.js'/>"></script>  --%>
				
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
		<jsp:param name="menuTitle" value="TRABAJADOR CON DERECHO NO CARGADO" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	<script type="text/javascript"> 
    
	var _FLUJO = "${respuesta.flujo}";
 	var estatus="${estatus}";


</script>
        <br>
                  
   <!-- Inicia Wrapper -->
    <div class="wrapper">
    <!-- inicia seccion datos Complementarios -->
    <br>
    <div class="Container">
      <div class="Layout__XL">
          <div class="Datos_ContainerColumn" style="background:#F6F6F6;">
            <div class="row_container">
              <div class="Datos"><strong>ID CLIENTE:</strong> <span class="Link_blue">0009874567823495673</span></div>
              <div class="Datos"><strong>ID SERVICIO:</strong> <span class="Link_blue">098874678923459876</span></div>
              <div class="Datos"><strong>ID NEGOCIO:</strong> <span class="Link_blue">098874678923459876</span></div>
            </div>
          </div>

          <div class="Title">
            Datos Generales del Trabajador
          </div>
          <div class="Datos_ContainerColumn" style="background:#F6F6F6;">
            <div class="row_container">
              <div class="Datos"><strong>${datos.nombreTrabajador}</strong></div>
            </div>
            <div class="row_container">
              <div class="Datos"><strong>FECHA DE NACIMIENTO:</strong><span class="Link_blue">${datos.datosCertificables.fechaNacimiento}</span></div>
              <div class="Datos"><strong>GÉNERO:</strong> <span class="Link_blue">${datos.datosCertificables.genero}</span></div>
              <div class="Datos"><strong>ENTIDAD DE NACIMIENTO:</strong> <span class="Link_blue">${datos.datosCertificables.entidadNacimiento}</span></div>
              <div class="Datos"><strong>CORREO ELECTRÓNICO:</strong> <span class="Link_blue">${datos.datosComplementarios.correoElectronico}</span></div>
            </div>
            <div class="row_container">
              <div class="Datos"><strong>NSS:</strong> ${datos.nss}</div>
              <div class="Datos"><strong>CURP:</strong> <span class="Link_blue">${datos.datosCertificables.curp}</span></div>
              <div class="Datos"><strong>CURP BDNSAR:</strong> <span class="Link_blue">OXOXOXOXOXOXOXOXOXOX</span></div>
              <div class="Datos"><strong>RFC:</strong> <span class="Link_blue">${datos.datosNoCertificables.rfc}</span></div>
            </div>
            <div class="row_container">
              <div class="Datos"><strong>DOMICILIO</strong></div>
            </div>
            <div class="row_container">
              <div class="Datos"><strong>CALLE:</strong> <span class="Link_blue">${datos.datosComplementarios.particular.calle}</span></div>
              <div class="Datos"><strong>NO.EXT:</strong> <span class="Link_blue">${datos.datosComplementarios.particular.noExterior}</span></div>
              <div class="Datos"><strong>NO.INT:</strong> <span class="Link_blue">${datosComplementarios.particular.noInterior}</span></div>
              <div class="Datos"><strong>COLONIA:</strong> <span class="Link_blue">${datos.datosComplementarios.particular.colonia}</span></div>
              <div class="Datos"><strong>MUNICIPIO:</strong> <span class="Link_blue">${datos.datosComplementarios.particular.municipio}</span></div>
              <div class="Datos"><strong>ENTIDAD FEDERATIVA:</strong> <span class="Link_blue">${datos.datosComplementarios.particular.entidadFederativa}</span></div>
              <div class="Datos"><strong>CÓDIGO POSTAL:</strong> <span class="Link_blue">${datos.datosComplementarios.particular.codigoPostal}</span></div>
            </div>

          <div class="Title">
            MONTOS SUBCUENTAS
          </div>
          <div class="Datos_ContainerColumn" style="background:#F6F6F6;">
            <div class="row_container">
              <div class="Datos"><strong>MONTO:</strong> <span class="Link_blue">OXOXOXOXOXOXOXOXOXOX</span></div>
              <div class="Datos"><strong>SUBCUENTA:</strong> <span class="Link_blue">OXOXOXOXOXOXOXOXOXOX</span></div>
            </div>
          </div>
          <div class="Title">
            MONTOS SUBCUENTAS VIVIENDA
          </div>
          <div class="Datos_ContainerColumn">
            <div class="row_container">
              <!-- <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Régimen:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div>
              </div> -->
            <!--   <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Origen de Trámites:</label>
                  <select class="Select">
                    <option value="option">Seleccione una opción</option>
                    <option value="option">Option1</option>
                    <option value="option">Option2</option>
                    <option value="option">Option3</option>
                  </select>
                </div>
              </div> -->
            <!--   <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Fecha de Nacimiento:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div>
              </div> -->
            </div>
            <div class="row_container">
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Tipo de Retiro:</label>
                   <select class="Select" id="catalogoTipoRetiro" name="catalogoTipoRetiro">
				              <option value="">Seleccione una opción</option>
				              <c:forEach items="${catalogoTipoRetiro}" var="tipoRetiro">
									 <option value="${tipoRetiro.clave}"> 
									 <c:out value="${tipoRetiro.descripcion}"></c:out>
									 </option> 
							    </c:forEach>
                        </select>
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Tipo de Seguros:</label>
                  <select class="Select" id="catalogoTipoSeguro" name="catalogoTipoSeguro">
				              <option value="">Seleccione una opción</option>
				              <c:forEach items="${catalogoTipoSeguro}" var="tipoSeguro">
									 <option value="${tipoSeguro.clave}"> 
									 <c:out value="${tipoSeguro.descripcion}"></c:out>
									 </option> 
							    </c:forEach>
                    </select> 
               
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Tipo Pensi&oacute;n:</label>
                  <select class="Select" id="tipoPension" name="tipoDisposicion">
				              <option value="">Seleccione una opción</option>
				              <c:forEach items="${catalogoTipoPension}" var="tipoPension">
									 <option value="${tipoPension.clave}"> 
									 <c:out value="${tipoPension.descripcion}"></c:out>
									 </option> 
							    </c:forEach>
                        </select> 
                </div>
              </div>
            </div>
          </div>
          <div class="Datos_ContainerColumn">
            <div class="row_container">
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Clave Pensi&oacute;n:</label>
                   <select class="Select" id="catalogoClavePension" name="catalogoClavePension">
				              <option value="">Seleccione una opción</option>
				              <c:forEach items="${catalogoClavePension}" var="clavePension">
									 <option value="${clavePension.clave}"> 
									 <c:out value="${clavePension.descripcion}"></c:out>
									 </option> 
							    </c:forEach>
                    </select>
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Tipo Prestación:</label>
                 <select class="Select" id="catalogoTipoPrestacion" name="catalogoTipoPrestacion">
				              <option value="">Seleccione una opción</option>
				              <c:forEach items="${catalogoTipoPrestacion}" var="tipoPrestacion">
									 <option value="${tipoPrestacion.clave}"> 
									 <c:out value="${tipoPrestacion.descripcion}"></c:out>
									 </option> 
							    </c:forEach>
                    </select>
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Fecha Inicio de Pensi&oacute;n:</label>
                  <input class="InputEdit" type="text" name="" value="${fechaEmisionResolucion}" placeholder="">
                </div>
              </div>
            </div>
             <div class="row_container">
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Fecha Emisi&oacute;n Pensi&oacute;n:</label>
                  <input class="InputEdit" type="text" name="" value="${fechaInicioPension}" placeholder="">
                </div>
              </div>
         <!--    <div class="row_container"> -->
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Fecha Emisi&oacute;n Resoluci&oacute;n:</label>
                  <input class="InputEdit" type="text" name="" value="${fechaResolucion}" placeholder="">
                </div>
              </div>
              
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Semanas Cotizadas:</label>
                  <input class="InputEdit" type="text" name="" value="${semanasCotizadas}" placeholder="">
                </div>
              </div>
            <!--  <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Tipo de Recurso a Disponer:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div>
              </div>  -->
            <!-- </div> -->
                 <br>
          <div class="Datos_Container">
                <div style="width:600px; max-width:100%;text:align:center">
                       <table id="example" class="table table-striped table-bordered" style="width:100%">
                              <thead>
				                  <tr class="RowHeader">
				                    <th>Indicador</th>
				                    <th>Descripcion</th>
				                  </tr>
                              </thead>
                               <c:forEach var="catalogo" items="${listaDisposicion}" >
                                       <tr class="Row1">
                                            <td><c:out value="${catalogo.idDerecho}" /></td> 
										    <td><c:out value="${catalogo.descripcionDerecho}" /></td>
                                        </tr> 
                               </c:forEach>
                       </table>
                </div>
          </div>
          <br></br>
          </div>
          <div class="Datos_ContainerColumn">
            <div class="row_container">
              <div class="Datosxl">
               <!--  <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Actuario Autorizado:</label>
                  <select class="Select">
                    <option value="option">Seleccione una opción</option>
                    <option value="option">Option1</option>
                    <option value="option">Option2</option>
                    <option value="option">Option3</option>
                  </select>
                </div> -->
              </div>
             <!--  <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Consecutivo Trabajador:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Secuencia de Pensión:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div>
              </div> -->
            </div>
            <div class="row_container">
              <!-- <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Clave Documento:</label>
                  <select class="Select">
                    <option value="option">Seleccione una opción</option>
                    <option value="option">Option1</option>
                    <option value="option">Option2</option>
                    <option value="option">Option3</option>
                  </select>
                </div>
              </div>
              <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Aseguradora:</label>
                  <select class="Select">
                    <option value="option">Seleccione una opción</option>
                    <option value="option">Option1</option>
                    <option value="option">Option2</option>
                    <option value="option">Option3</option>
                  </select>
                </div>
              </div> -->
             <!--  <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Curp Solicitante:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div>
              </div> -->
            </div>
          </div>
          <div class="Datos_ContainerColumn">
            <div class="row_container">
             <!--  <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">No.Registro Plan Privado Pensiones:</label>
                  <select class="Select">
                    <option value="option">Seleccione una opción</option>
                    <option value="option">Option1</option>
                    <option value="option">Option2</option>
                    <option value="option">Option3</option>
                  </select>
                </div>
              </div> -->
              <!-- <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Tipo Solicitante:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div>
              </div> -->
             <!--  <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Curp Agente Servicio:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div>
              </div> -->
            </div>
            <div class="row_container">
              <!-- <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Fecha de Pago para Reingreso:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div>
              </div> -->
             <!--  <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Sello Único de Verificación:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div>
              </div> -->
             <!--  <div class="Datosxl">
                <div class="Form__Group">
                  <label class="LabelTextEdit" for="usuario">Cus:</label>
                  <input class="InputEdit" type="text" name="" value="" placeholder="">
                </div> -->
              </div>
            </div>
            <div class="row_container">
              <div class="Datosxxl"><strong>*NOTA: </strong>Si aún no cuenta con CUS, puedes generarla
                <a class="Linkconcluido" href="#">
                  <strong>
                    aqui
                  </strong>
                </a>
              </div>
            </div>
          </div>
          
           <br>
          <div class="SeccionTable">
            <div style="overflow-x: auto;">
              <table id="example" class="table table-striped table-bordered" style="width:100%">
                <thead>
                  <tr class="RowHeader">
                    <th>Indicador</th>
                    <th>Datos</th>
                    <th>Fila</th>
                    <th>Mensaje</th>
                  </tr>
                </thead>
                <tbody>
                  <tr class="Row1">
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                  </tr>
                  <tr class="Row2">
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                  </tr>
                  <tr class="Row1">
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                  </tr>
                  <tr class="Row2">
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                  </tr>
                  <tr class="Row1">
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                  </tr>
                  <tr class="Row2">
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                    <td>
                      <p class="Link_blue" href="#">oxoxoxoxoxoxoxo</p>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      <div class="Form__Group">
        <div class="ContainerButtonsCenter">
          <a href="#" class="Submitx">Modificar</a>
          <a href="#miModal5" class="Submitx">Aceptar</a>
          <a href="submenu_disposiciones_totales.html" class="Submitx">Regresar</a>
        </div>
      </div>
    </div>
      <!-- termina seccion datos Complementarios -->
      <!-- inicia carrusel general -->
        <div class="slick-carousel">
          <a href="solicitud_de_tramite.html" class="Carrousel__ThumbContainer">
            <div class="Icon">
              <img class="IconImgMenu" src="../webResources/img/archive_icon.png" alt="icon_menu"/>
            </div>
            <div class="Carrousel__Title">Solicitud de Trámite</div>
          </a>
          
         <!--  <a href="documentos_requeridos.html" class="Carrousel__ThumbContainer">
            <div class="Icon">
              <img class="IconImgMenu" src="img/archive_icon.png" alt="icon_menu"/>
            </div>
            <div class="Carrousel__Title">Documentos Requeridos</div>
          </a>
          <a href="disposicion_de_recursos.html" class="Carrousel__ThumbContainer">
            <div class="Icon">
              <img class="IconImgMenu" src="img/archive_icon.png" alt="icon_menu"/>
            </div>
            <div class="Carrousel__Title">Dispocisión de Recursos</div>
          </a>
          <a href="liquidacion_de_recursos.html" class="Carrousel__ThumbContainer">
            <div class="Icon">
              <img class="IconImgMenu" src="img/archive_icon.png" alt="icon_menu"/>
            </div>
            <div class="Carrousel__Title">Liquidación de Recursos</div>
          </a> -->
        </div>
     
      <!-- termina carrusel general -->
      <div class="push"></div>
    </div>
  <!-- Finaliza Wrapper -->
         
   
 
 
 
 <jsp:include page="../generales/footerAgente.jsp" /> 
 <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/blockui/jquery.blockUI.js'/>"></script>

</body>
</html>
