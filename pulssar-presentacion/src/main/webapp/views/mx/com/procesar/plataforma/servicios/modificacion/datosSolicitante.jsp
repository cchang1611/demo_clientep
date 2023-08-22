<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/pestana_despegable_generico.js'/>"></script>
</head>
<body>
<div class="Container_None" id="datosSolicitante">
  <!-- inicia seccion datos Complementarios Edicion-->
  <div>
  	 <div class="Title">
        Datos Solicitante
      </div>
      <div class="Datos_Container" id="datosSolicitanteContenedor">
        <div class="row_container">
        <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Curp Solicitante</label>
              <input class="InputEdit" type="text" id="curpSolicitanteSeccion" name="curpSolicitante" value="${datosFolioActivo.curpSolicitante}" placeholder="Curp Solicitante" maxlength="18">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Nombre del Solicitante</label>
              <input class="InputEdit" type="text" id="nombreSolicitante" name="nombreSolicitante" value="${datosFolioActivo.nombre}" placeholder="Nombre del Solicitante" maxlength="40">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
           <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Apellido paterno del Solicitante</label>
              <input class="InputEdit" type="text" id="apellidoPaternoSolicitante" name="apellidoPaternoSolicitante" value="${datosFolioActivo.apellidoPaterno}" placeholder="Apellido Paterno del Solicitante" maxlength="40">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
           <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Apellido materno del Solicitante</label>
              <input class="InputEdit" type="text" id="apellidoMaternoSolicitante" name="apellidoMaternoSolicitante" value="${datosFolioActivo.apellidoMaterno}" placeholder="Apellido Materno del Solicitante" maxlength="40">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
        </div>
      </div>
  
      <div class="Title">
        Dirección Particular Solicitante
      </div>
      <div class="Datos_Container" id="direccionParticularSolicitanteContenedor">
        <div class="row_container">
         <div class="Datos">
          <span id="mensajeCodigoPostalSolicitante" class="Labeltexterror"></span>
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Calle:</label>
              <input class="InputEdit" type="text" id="calleSolicitante" name="calleSolicitante" value="${domSolicitante.calle}" placeholder="Calle" maxlength="65">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Número Exterior:</label>
              <input class="InputEdit" type="text" id="noExteriorSolicitante" name="noExteriorSolicitante" value="${domSolicitante.noExterior}"  placeholder="Número Exterior" maxlength="15"/>
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Número Interior:</label>
              <input class="InputEdit" type="text" id="noInteriorSolicitante" name="noInteriorSolicitante" value="${domSolicitante.noInterior}" placeholder="Número Interior" maxlength="15">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group" id="divColoniaSolicitante">
              <label class="LabelTextEdit" for="usuario">Colonia:</label>
              <input class="InputEdit" type="text" id="coloniaSolicitante" name="coloniaSolicitante" value="${domSolicitante.colonia}" placeholder="Colonia" maxlength="65">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
        </div>
        <div class="row_container">
         <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="lpais">País:</label>
              <select class="Select" id="paisSolicitante" name="paisSolicitante">
                <option value="">Seleccione una opción</option>
                <c:forEach items="${paises}" var="tPais">
					<option value="${tPais.clavePais}"><c:out
					value="${tPais.clavePais} ${tPais.descripcion}"></c:out></option>
			    </c:forEach>
              </select>
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group" id="divEntidadSolicitante">
              <label class="LabelTextEdit" for="lentidadFederativa">Entidad Federativa:</label>
	              <select class="Select" id="entidadFederativaSolicitante" name="entidadFederativaSolicitante" onchange="cargaMunicipiosSolicitante();">
	                 <option value="">Seleccione una opción</option>
	                <c:forEach items="${entidades}" var="tEntidad">
						<option value="${tEntidad.descripcion}"><c:out
	 					value="${tEntidad.chCvEntidadFederativa} ${tEntidad.descripcion}"></c:out></option>
				    </c:forEach>
	              </select>              
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group" id="divMunicipioSolicitante">
              <label class="LabelTextEdit" for="lmunicipio">Municipio:</label>
              <select class="Select" id="municipioSolicitante" name="municipioSolicitante">
                <option value="">Seleccione una opción</option>
                <c:forEach items="${municipiosParticular}" var="tMunicipio">
 					<option value="${tMunicipio.descripcion}"><c:out 
 					value="${tMunicipio.descripcion}"></c:out></option>
			    </c:forEach>
              </select>
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Codigo Postal:</label>
              <input class="InputEdit" type="text" id="codigoPostalSolicitante" name="codigoPostalSolicitante" onkeyup="buscarCodigoPostalSolicitante()" maxlength="5" value="${domSolicitante.codigoPostal}" placeholder="Codigo Postal">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
       </div>
      
      </div>
	
	</div>
</div>
  <!-- termina seccion datos Complementarios -->
</body>
</html>