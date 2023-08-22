<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.DatosTrabajador,
   mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.UsuarioLogin,
   mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.FolioEntrada" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
   <head>
      <title>Menu</title>
      <meta charset="utf-8" />
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <![if IE]>
      <link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='../webResources/css/general/main_ie.css'/>" />
      <![endif]>
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/universal_setting.css'/>"/> 
      <link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/styles_form.css'/>"/> 
      <link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/container.css'/>"/> 
      <link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/templates.css'/>"/> 
      <link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/modal_window.css'/>"/> 
      <link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/header.css'/>"/> 
      <link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/tables.css'/>"/> 
      <link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/footer.css'/>"/> 
      <link rel="stylesheet" type="text/css" href="<c:url value='../webResources/css/general/datepiker/datepiker.css'/>"/> 
      <link rel="shortcut icon" href="<c:url value='../webResources/img/favicon.ico'/>"/> 
      <link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"/> 
      <script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
   </head>
   <body>
      <input type="hidden" id="mensaje" value = "${mensaje}"/>
      <jsp:include page="../../generales/headGeneral.jsp"></jsp:include>
      <jsp:include page="../../generales/headerAgente.jsp">
         <jsp:param name="encabezado" value="2" />
         <jsp:param name="menuTitle" value="Ayuda por Matrimonio" />
         <jsp:param name="menuPrimario" value = "2" />
         <jsp:param name="menuSecundario" value = "2" />
         <jsp:param name="menuInactivo" value = "2" />
      </jsp:include>
      <div class="wrapper">
         <div class="Container">
            <div class="Container">
               <div class="Layout__M">
                  <c:if test="${mensaje == null}">
                     <form:form id="formSalida" method="post" action="${pageContext.request.contextPath}/private/validarSolicitudRetiroMatrimonio.do" accept-charset="UTF-8" >
                        <input id="cus" type="hidden" name="cus"
                        value="${datosRetiroParcialImss.cus}" />
                        <!-- Inicia Wrapper -->
                        <div class="wrapper">
                           <div class="Title__Container">
                              <h1>Ayuda Por Matrimonio</h1>
                           </div>
                           <div class="Container">
                              <div class="Layout__M">
                                 <div class="Line">
                                    <p></p>
                                 </div>
                                 <div class="Datos_Container">
                                    <div class="Form__Group">
                                       <label class="LabelText" for="usuario">* Fecha de Matrimonio:</label>
                                       <input id="fechaMatrimonio" class="Inputxxl" type="text" name="fechaMatrimonio"  placeholder="Fecha de Matrimonio" maxlength="10" readonly="readonly" />
                                       <label id="fechaMatrimonioError" style="display:none" class="Labeltexterror" data-check="0">Fecha de matrimonio inv&aacute;lida</label>
                                    </div>
                                    <div class="Form__Group">
                                       <label class="LabelText" for="usuario">* Nombre:</label>
                                       <input id="nombre" class="Inputxxl" type="text" name="nombreConyuge"  placeholder="Nombre" data-nombre="Nombre Cónyuge" style="text-transform:uppercase"/>
                                       <label id="nombreError" class="Labeltexterror" style="display:none" data-check="0">Favor capturar los datos faltantes</label>
                                    </div>
                                    <div class="Form__Group">
                                       <label class="LabelText" for="usuario">* Apellido Paterno Cónyuge:</label>
                                       <input id="apellidoPaterno"  class="Inputxxl" type="text" name="apellidoPaternoConyuge" placeholder="Apellido Paterno Cónyuge" style="text-transform:uppercase"/>
                                       <label id="apellidoPaternoError" style="display:none" class="Labeltexterror" data-check="0">Favor capturar los datos faltantes</label>
                                    </div>
                                    <div class="Form__Group">
                                       <label class="LabelText" for="usuario">* Apellido Materno Cónyuge:</label>
                                       <input id="apellidoMaterno" class="Inputxxl" type="text" name="apellidoMaternoConyuge" placeholder="Apellido Materno Cónyuge" style="text-transform:uppercase"/>
                                       <label  id="apellidoMaternoError"  style="display:none" class="Labeltexterror" data-check="0">Favor capturar los datos faltantes</label>
                                    </div>
                                    <div class="Form__Group">
                                       <label class="LabelText" for="usuario">* Sexo del Cónyuge:</label>
                                       <select class="Select" name="sexoConyuge" placeholder="Sexo del Conyuge" id="sexoConyuge">
                                          <option value="-1" selected >Sexo del Cónyuge</option>
                                          <c:forEach items="${lstGenero}" var="genero">
                                             <option value="${genero.idGenero}">${genero.descripcionGenero}</option>
                                          </c:forEach>
                                       </select>
                                       <input type="hidden" id="descSexo" name="descSexo" value = "${descSexo}"/>
                                       <label  id="sexoConyugeError"  style="display:none" class="Labeltexterror" data-check="0">Favor de selecionar sexo</label>
                                    </div>
                                    <div class="Form__Group">
                                       <label class="LabelText" for="usuario">* Entidad de Emisión del Acta:</label>
                                       <select class="Select" name="entidadEmisionActa" placeholder="Entidad de Emisión del Acta" id="entidadEmisionActa">
                                          <option value="-1" selected >Entidad de Emisión del Acta</option>
                                          <c:forEach items="${lstEntidadFederativa.entidadesFederativas}" var="entidad">
                                             <option value="${entidad.chCvEntidadFederativa}">${entidad.descripcion}</option>
                                          </c:forEach>
                                       </select>
                                       <input type="hidden" id="descEntidadEmisionActa" name="descEntidadEmisionActa" value = "${descEntidadEmisionActa}"/>
                                       <label  id="entidadEmisionActaError"  style="display:none" class="Labeltexterror" data-check="0">Favor de selecionar entidad de emisión del acta</label>
                                    </div>
                                 </div>
                                 <div class="ContainerButtons">
                                    <input id="btnSiguiente" class="Submit" type="button" value="Continuar">
                                 </div>
                              </div>
                           </div>
                           <!-- finaliza titulo seccion -->
                           <div class="push"></div>
                        </div>
                     </form:form>
                  </c:if>
               </div>
            </div>
         </div>
         <div class="push"></div>
      </div>
      <jsp:include page="../../generales/footerAgente.jsp" />
      <jsp:include page="../../generales/modals.jsp" />
      <script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/matrimonio_conyuge.js'/>"></script>
      <script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/blockui/jquery.blockUI.js'/>"></script>
      <script type="text/javascript" charset="UTF-8" src="<c:url value='../webResources/js/datepiker.js'/>"></script>
   </body>
</html>
