<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/pestana_despegable_generico.js'/>"></script>
</head>
<body>
<div class="Container_None" id="datosComplementarios">
  <!-- inicia seccion datos Complementarios Edicion-->
  <div>
      <div class="Title">
        Dirección Particular
      </div>
      <div class="Datos_Container" id="direccionParticularContenedor">
        <div class="row_container">
          <div class="Datos">
          <span id="mensajeCodigoPostal" class="Labeltexterror"></span>
          <span id="mensajeTercero" class="Labeltexterror"></span>
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Calle:</label>
              <input class="InputEdit" type="text" id="calle" name="calle" value="${domParticular.calle}" placeholder="Calle" maxlength="65" onkeyup="agregarCalle();">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Número Exterior:</label>
              <input class="InputEdit" type="text" id="noExterior" name="noExterior" value="${domParticular.noExterior}"  placeholder="Número Exterior" maxlength="15" onkeyup="agregarNumeroExterior();"/>
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Número Interior:</label>
              <input class="InputEdit" type="text" id="noInterior" name="noInterior" value="${domParticular.noInterior}" placeholder="Número Interior" maxlength="15" onkeyup="agregarNumeroInterior();">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group" id="divColoniaParticular">
              <label class="LabelTextEdit" for="usuario">Colonia:</label>
              <input class="InputEdit" type="text" id="colonia" name="colonia" value="${domParticular.colonia}" placeholder="Colonia" maxlength="65" onchange="agregarColonia();">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
        </div>
        <div class="row_container">
         <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="lpais">País:</label>
              <select class="Select" id="pais" name="pais">
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
            <div class="Form__Group form-group" id="divEntidadParticular">
              <label class="LabelTextEdit" for="lentidadFederativa">Entidad Federativa:</label>
              <select class="Select" id="entidadFederativa" name="entidadFederativa" onchange="cargaMunicipios();agregarEntidadFederativa()">
<!--                 <option value="">Seleccione una opción</option> -->
                <c:forEach items="${entidades}" var="tEntidad">
					<option value="${tEntidad.descripcion}"><c:out
					value="${tEntidad.chCvEntidadFederativa} ${tEntidad.descripcion}"></c:out></option>
			    </c:forEach>
              </select>
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group" id="divMunicipioParticular">
              <label class="LabelTextEdit" for="lmunicipio">Municipio:</label>
              <select class="Select" id="municipio" name="municipio" onchange="agregarMunicipio();">
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
              <input class="InputEdit" type="text" id="codigoPostal" name="codigoPostal" onkeyup="buscarCodigoPostal();agregarCodigoPostal();" maxlength="5" value="${domParticular.codigoPostal}" placeholder="Codigo Postal">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
       </div>
       <div class="row_container">
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Teléfono 1:</label>
              <input class="InputEdit" type="text" id="telefono1" name="telefono1" value="${contacto.telefonoFijo}" maxlength="10" placeholder="Teléfono 1">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Extension 1:</label>
              <input class="InputEdit" type="text" id="extension1" name="extension1" value="${contacto.extension}" placeholder="Extensión 1" maxlength="5">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          </div>
          <div class="row_container">
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Teléfono 2:</label>
              <input class="InputEdit" type="text" id="telefono2" name="telefono2" value="${contacto.celular}" placeholder="Teléfono 2" maxlength="10">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Extension 2:</label>
              <input class="InputEdit" type="text" id="extension2" name="extension2" value="${contacto.extension2}" placeholder="Extensión 2" maxlength="5">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Correo electronico:</label>
              <input class="InputEdit" type="text" name="correoElectronico" id="correoElectronico" value="${correo}" placeholder="Correo electronico" maxlength="50">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          </div>
       
      </div>
      <div class="Title">
        Dirección Laboral
      </div>
      <div class="Datos_Container" id="direccionLaboralContenedor">
        <div class="row_container">
          <div class="Datos">
          <span id="mensajeLaboral" class="Labeltexterror"></span>
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Calle:</label>
              <input class="InputEdit" type="text" id="calleLaboral" name="calleLaboral" value="${domLaboral.calle}" placeholder="Calle" maxlength="65">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Numero Exterior:</label>
              <input class="InputEdit" type="text" id="noExteriorLaboral" name="noExteriorLaboral" value="${domLaboral.noExterior}" placeholder="Numero Exterior" maxlength="15">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Numero Interior:</label>
              <input class="InputEdit" type="text" id="noInteriorLaboral" name="noInteriorLaboral" value="${domLaboral.noInterior}" placeholder="Numero Interior" maxlength="15">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Colonia:</label>
              <input class="InputEdit" type="text" id="coloniaLaboral" name="coloniaLaboral" value="${domLaboral.colonia}" placeholder="Colonia" maxlength="65">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
        </div>
        <div class="row_container">
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="lPaisLaboral">Pais:</label>
              <select class="Select" id="paisLaboral" name="paisLaboral">
                <option value="">Seleccione una opción</option>
                <c:forEach items="${paises}" var="tPais">
					<option value="${tPais.clavePais}">
					<c:out value="${tPais.clavePais} ${tPais.descripcion}"></c:out>
					</option>
			    </c:forEach>
              </select>
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datos">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="lEntidadFederativaLaboral">Entidad Federativa:</label>
              <select class="Select" id="entidadFederativaLaboral" name="entidadFederativaLaboral" onchange="cargaMunicipiosLaboral();">
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
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="lmunicipioParticular">Municipio:</label>
              <select class="Select" id="municipioLaboral" name="municipioLaboral">
                <option value="">Seleccione una opción</option>
                <c:forEach items="${municipiosLaboral}" var="tMunicipio">
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
              <input class="InputEdit" type="text" id="codigoPostalLaboral" name="codigoPostalLaboral" value="${domLaboral.codigoPostal}" placeholder="Codigo Postal" maxlength="5">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
       </div>
      </div>
      <br></br>
      <div id="tituloReferencias" onclick="mostrarDesplegableReferencias()" class="Title">
      	 <p>Referencias</p>
      </div>
      <div class="Datos_ContainerColumn" id="referencias1" style="display: none;">
        <div class="row_container">
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Nombre Referencia:</label>
              <input class="InputEdit" type="text" name="nombreReferencia" id="nombreReferencia" value="${referencia1.nombre}" placeholder="Nombre Referencia" maxlength="40">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Apellido Paterno Referencia:</label>
              <input class="InputEdit" type="text" name="apellidoPaternoRef" id="apellidoPaternoRef" value="${referencia1.apellidoPaterno}" placeholder="Apellido Paterno Referencia" maxlength="40">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Apellido Materno Referencia:</label>
              <input class="InputEdit" type="text" name="apellidoMaternoRef" id="apellidoMaternoRef" value="${referencia1.apellidoMaterno}" placeholder="Apellido Materno Referencia" maxlength="40">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
        </div>
        <div class="row_container">
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Curp Referencia:</label>
              <input class="InputEdit" type="text" name="curpReferencia" id="curpReferencia" value="${referencia1.curp}" placeholder="Curp Referencia" maxlength="18">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Telefono Referencia:</label>
              <input class="InputEdit" type="text" name="telefonoReferencia" id="telefonoReferencia" value="${referencia1.telefono}" placeholder="Telefono Referencia" maxlength="10">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Parentesco Referencia:</label>
              <select class="Select" id="parentescoRef" name="parentescoRef">
              <option value="">Seleccione una opción</option>
                <c:forEach items="${parentescos}" var="tParentesco">
					<option value="${tParentesco.claveParentesco}"><c:out
					value="${tParentesco.claveParentesco} ${tParentesco.descripcion}"></c:out>
					</option>
			  	</c:forEach>
              </select>
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
        </div>
      </div>
      <div class="Datos_ContainerColumn02" id="referencias2" style="display: none;">
        <div class="row_container">
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Nombre Referencia:</label>
              <input class="InputEdit" type="text" name="nombreReferencia2" id="nombreReferencia2" value="${referencia2.nombre}" placeholder="Nombre Referencia" maxlength="40">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Apellido Paterno Referencia:</label>
              <input class="InputEdit" type="text" name="apellidoPaternoRef2" id="apellidoPaternoRef2" value="${referencia2.apellidoPaterno}" placeholder="Apellido Paterno Referencia" maxlength="40">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Apellido Materno Referencia:</label>
              <input class="InputEdit" type="text" name="apellidoMaternoRef2" id="apellidoMaternoRef2" value="${referencia2.apellidoMaterno}" placeholder="Apellido Materno Referencia" maxlength="40">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
        </div>
        <div class="row_container">
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Curp Referencia:</label>
              <input class="InputEdit" type="text" name="curpReferencia2" id="curpReferencia2" value="${referencia2.curp}" placeholder="Curp Referencia" maxlength="18">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Telefono Referencia:</label>
              <input class="InputEdit" type="text" name="telefonoReferencia2" id="telefonoReferencia2" value="${referencia2.telefono}" placeholder="Telefono Referencia" maxlength="10">
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
          <div class="Datosxl">
            <div class="Form__Group form-group">
              <label class="LabelTextEdit" for="usuario">Parentesco Referencia:</label>
              <select class="Select" id="parentescoRef2" name="parentescoRef2">
              <option value="">Seleccione una opción</option>
                <c:forEach items="${parentescos}" var="tParentesco">
					<option value="${tParentesco.claveParentesco}"><c:out
					value="${tParentesco.claveParentesco} ${tParentesco.descripcion}"></c:out>
					</option>
			  	</c:forEach>
              </select>
              <span id="error" class="Labeltexterror"></span>
            </div>
          </div>
        </div>
      </div>
      <br></br>
      <div id="divCheckBox" style="display: none;">
      	<label style="font-weight: bold;display: inline;font-size: 15px;"><input style="display: inline;width: 15px;height: 15px;"  id="checkSinDesiganrBeneficiarios" name="checkSinDesiganrBeneficiarios" type="checkbox" name="micheckbox" />No deseo registrar beneficiarios</label><br>
      	<span id="mensajeCheckObligatorio" class="Labeltexterror"></span>
      </div>
      <div id="tituloBeneficiarios" onclick="mostrarDesplegableBeneficiarios()" class="Title">
        <p>Beneficiarios</p>
        <a href="#" class="button_agregar add-row" id="agregarBeneficiario">
          <p>Agregar</p>
          <img class="icono_agregar" src="../webResources/img/icon_agregar.png" alt="Agregar">
        </a>
        <a href="#" class="button_eliminar delete-row" id="eliminarBeneficiario">
          <p>Eliminar</p>
          <img class="icono_eliminar" src="../webResources/img/icon_eliminar.png" alt="Eliminar">
        </a>
        <a href="#" class="button_eliminar edit-row" id="editarBeneficiario">
          <p>Editar</p>
          <img class="icono_editar" src="../webResources/img/editar.png" alt="Editar">
        </a>
      </div>
      <div class="SeccionTable" id="desplegableTablaBeneficiarios" style="display: none;">
					<div style="overflow-x: auto;">
						<table id="tablaBeneficiarios" class="display">
							<thead>
								<tr class="RowHeader">
								    <th></th>
									<th>Curp</th>
									<th>Nombre</th>
									<th>Apellido Paterno</th>
									<th>Apellido Materno</th>
									<th>Parentesco</th>
									<th>Porcentaje</th>
									<th style="display: none">Id Parentesco</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listaBeneficiarios}" var="beneficiarios">
									<tr>
									    <td><input  id="checkboxBeneficiario" type="checkbox" name="micheckbox" value="${beneficiarios.curp}" /></td>
									    <td><c:out value="${beneficiarios.curp}" /></td>
										<td><c:out value="${beneficiarios.nombre}" /></td>
										<td><c:out value="${beneficiarios.apellidoPaterno}" /></td>
										<td><c:out value="${beneficiarios.apellidoMaterno}" /></td>
										<td><c:out value="${beneficiarios.parentesco}" /></td>
										<td><c:out value="${beneficiarios.porcentaje}" /></td>
										<td style="display: none" id="${beneficiarios.curp}"><input  type="text" value="${beneficiarios.claveParentesco}"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
	
	</div>
</div>
  <!-- termina seccion datos Complementarios -->
</body>
</html>