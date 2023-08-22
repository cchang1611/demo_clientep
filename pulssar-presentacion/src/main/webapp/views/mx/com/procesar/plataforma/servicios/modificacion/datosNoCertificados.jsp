<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<body>
<div class="Container_None" id="noCertificados">
  <div class="ContainerDatosGenerales">
    <div class="ContainerDatosGenerales__ColOne">
      <c:choose>
			<c:when test="${not empty trabajador.imagen}">
				<img class="ContainerDatosGenerales__Img" src="data:image/png;base64, ${trabajador.imagen}" alt="Imagen del Agente Promotor" />
			</c:when>
			<c:otherwise>
				<img class="ContainerDatosGenerales__Img" src="../webResources/img/user_photo.jpg" 
					alt="Imagen del Agente Promotor no encontrada" />
			</c:otherwise>
		</c:choose>
		
		<div class="ContainerDatosGenerales__Name">
			${trabajador.nombreTrabajador}
		</div>
		
    </div>
    <div class="ContainerDatosGenerales__ColTwo" id="baseCurpNoCertificados">
        <ul class="ContainerDatosGenerales_Seccion">
          <li class="ContainerDatosGenerales_Date form-group">
            <label class="LabelTextEdit" for="usuario">RFC del trabajador:</label> 
            <div id="contenedorRfc">
            </div>          
            <input class="InputEdit" type="text" id="rfc" name="rfc" value="${noCertificables.rfc}" placeholder="RFC del trabajador" maxlength="13">            
           <div class="ModalFooter" id="contenedorBotonRfc">
                       <button type="button" id="generarRfc" onclick="generaRfc();">GENERAR RFC</button>
           </div>
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
            <label class="LabelTextEdit" for="lClaveTipoDocto">Clave tipo documento probatorio:</label>
            <select class="Select" id="claveTipoDocProbatorio" name="claveTipoDocProbatorio">
              <option value="">Seleccione una opción</option>
              <c:forEach items="${tiposDoctos}" var="tDoctos">
					<option value="${tDoctos.idTipoDoctoProbatorio}"><c:out
					value="${tDoctos.idTipoDoctoProbatorio} ${tDoctos.descripcion}"></c:out></option>
			    </c:forEach>
            </select>
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
            <label class="LabelTextEdit" for="usuario">Folio Solicitud:</label>
            <input class="InputEdit" type="text" id="folioSolicitud" name="folioSolicitud" value="${noCertificables.folioSolicitud}" placeholder="Folio Solicitud" disabled>
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
            <label class="LabelTextEdit" for="usuario">Documento Probatorio:</label>
            <input class="InputEdit" type="text" id="documentoProbatorio" name="documentoProbatorio" value="${noCertificables.documentoProbatorio}" placeholder="Documento Probatorio" maxlength="16">
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
            <label class="LabelTextEdit" for="usuario">Folio documento Probatorio:</label>
            <input class="InputEdit" type="text" id="folioDocumentoProbatorio" name="folioDocumentoProbatorio" value="${noCertificables.folioDocumentoProbatorio}" placeholder="Folio documento Probatorio" maxlength="10">
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
            <label class="LabelTextEdit" for="locupacion">Ocupacion:</label>
            <select class="Select" id="ocupacion" name="ocupacion">
              <option value="">Seleccione una opción</option>
              <c:forEach items="${ocupaciones}" var="tOcupaciones">
					<option value="${tOcupaciones.clave}"><c:out
					value="${tOcupaciones.clave} ${tOcupaciones.descripcion}"></c:out></option>
			    </c:forEach>
            </select>
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
            <label class="LabelTextEdit" for="lgiro">Giro:</label>
            <select class="Select" id="giro" name="giro">
              <option value="">Seleccione una opción</option>
              <c:forEach items="${giros}" var="tGiro">
					<option value="${tGiro.clave}"><c:out
					value="${tGiro.clave} ${tGiro.descripcion}"></c:out></option>
			    </c:forEach>
            </select>
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
            <label class="LabelTextEdit" for="lnivelEstudio">nivel de estudios:</label>
            <select class="Select" id="estudios" name="estudios">
              <option value="">Seleccione una opción</option>
              <c:forEach items="${niveles}" var="tNivel">
					<option value="${tNivel.clave}"><c:out
					value="${tNivel.clave} ${tNivel.descripcion}"></c:out></option>
			    </c:forEach>
            </select>
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group" id="solicitante" style="display:none;">
            <label class="LabelTextEdit" for="lSolicitante">Curp Solicitante:</label>
            <input class="InputEdit" type="text" id="curpSolicitante" name="curpSolicitante" placeholder="Curp del Solicitante" maxlength="18">
            <span id="error" class="Labeltexterror"></span>
          </li>
        </ul>
    </div>
  </div>
</div>
<!-- termina seccion datos certificados -->
</body>
</html>