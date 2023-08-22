<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
  <title>Datos Generales del Trabajador</title>
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
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/calculaRFC.js'/>"></script> 
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/validator.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/datosCertificados.js'/>"></script>

  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick-theme.min.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/1.5.8/slick.css'/>"></link>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/carousel/slick_carousel.css'/>"></link>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
  <script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/modificacionTrabajador/beneficiarios.js'/>"></script>
  <link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tooltip.css'/>"></link>
</head>
<body>
		<script type="text/javascript">
			var CURP_VACIA = "${faltaCurp}";
			var _FLUJO = "${respuesta.flujo}";
			var AFORE = "${pulssarUP.aforeUsuario}";
			var IDFOLIO_HIJO = "${folioHijo.idFolioPulssar}";
			var NUMERO_BENEFICIARIOS_PERMITIDOS = "${numeroBeneficiariosPermitidos}";
			var NUMERO_BENEFICIARIOS_EXISTENTES = "${numBeneficiariosExistentes}";
			var TIPOSOLICITANTE = "${tipoSolicitante}";
			var BANDERA_BLOQUEO_BOTON = "${bloqueoEditar}";
			
		</script>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
  <jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Modificaci&oacute;n de Datos" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>	
<div class="wrapper">
<section>
  <!-- inicia titulo de seccion -->
  <div class="Title__Container" id="tituloPantalla"></div>
  <!-- finaliza titulo seccion -->
 <input type="hidden" name="trabajadorClaveAfore"  value="${trabajador.claveAfore}" id="trabajadorClaveAfore"/>
 <input type="hidden" name="curpAct" value="${datosTrabajador.datosCertificables.curp}" id="curpAct" />
 <input type="hidden" name="nombreAct" value="${datosTrabajador.datosCertificables.nombre}" id="nombreAct" />
 <input type="hidden" name="apellidoPaternoAct" value="${datosTrabajador.datosCertificables.apellidoPaterno}" id="apellidoPaternoAct" />
 <input type="hidden" name="apellidoMaternoAct" value="${datosTrabajador.datosCertificables.apellidoMaterno}" id="apellidoMaternoAct" />
 <input type="hidden" name="fechaNacimientoAct" value="${datosTrabajador.datosCertificables.fechaNacimiento}" id="fechaNacimientoAct" />
 <input type="hidden" name="rfcAct" value="${noCertificables.rfc}" id="rfcAct" />
 <input type="hidden" name="folioSolicitudAct" value="${noCertificables.folioSolicitud}" id="folioSolicitudAct" />
 <input type="hidden" name="documentoProbatorioAct" value="${noCertificables.documentoProbatorio}" id="documentoProbatorioAct" />
 <input type="hidden" name="folioDocumentoProbatorioAct" value="${noCertificables.folioDocumentoProbatorio}" id="folioDocumentoProbatorioAct" />
 <input type="hidden" name="entidad" value="${entidad}" id="entidad" />
  <input type="hidden" name="entidadCompara" value="${entidadCompara}" id="entidadCompara" />
  <input type="hidden" name="sexoCompara" value="${sexoCompara}" id="sexoCompara" />
 <input type="hidden" name="sexo" value="${sexo}" id="sexo" />
 <input type="hidden" name="paisParticularAct" value="${paisParticularAct}" id="paisParticularAct" />
 <input type="hidden" name="paisLaboralAct" value="${paisLaboralAct}" id="paisLaboralAct" />
 <input type="hidden" name="entidadLaboralAct" value="${entidadLaboralAct}" id="entidadLaboralAct" />
 <input type="hidden" name="entidadParticularAct" value="${entidadParticularAct}" id="entidadParticularAct" />
 <input type="hidden" name="municipioParticularAct" value="${municipioParticularAct}" id="municipioParticularAct" />
 <input type="hidden" name="municipioLaboralAct" value="${municipioLaboralAct}" id="municipioLaboralAct" />
 <input type="hidden" name="parentesco" value="${parentesco}" id="parentesco" />
 <input type="hidden" name="nacionalidadAct" value="${nacionalidadAct}" id="nacionalidadAct" />
 <input type="hidden" name="tipoDoctoAct" value="${tipoDoctoAct}" id="tipoDoctoAct" />
 <input type="hidden" name="ocupacionAct" value="${ocupacionAct}" id="ocupacionAct" />
 <input type="hidden" name="giroAct" value="${giroAct}" id="giroAct" />    
 <input type="hidden" name="nivelAct" value="${nivelAct}" id="nivelAct" />
 <input type="hidden" name="expIden" value="${expIden}" id="expIden" />    
 <input type="hidden" name="expEnrolamiento" value="${expEnrolamiento}" id="expEnrolamiento" />
 <input type="hidden" name="tipoSolicitante" value="${tipoSolicitante}" id="tipoSolicitante" />
 <input type="hidden" name="parentescoRefAct1" value="${parentescoRefAct1}" id="parentescoRefAct1" />
 <input type="hidden" name="parentescoRefAct2" value="${parentescoRefAct2}" id="parentescoRefAct2" />
 <input type="hidden" name="nacionalidadTrabajadorValorDespliegue" value="${nacionalidadTrabajador.chValorDespliegue}" id="nacionalidadTrabajadorValorDespliegue"/>
 <input type="hidden" name="nssTrabajajador"  value="${nssTrabajador}" id="nssTrabajajador"/>
 <input type="hidden" name="chTipoSolicitante" value="${chTipoSolicitante}" id="chTipoSolicitante"/>
 <input type="hidden" name="banderaSecciones" value="${banderaSecciones}" id="banderaSecciones"/>
 <input type="hidden" name="banderaValidoRenapo" value="${banderaValidoRenapo}" id="banderaValidoRenapo"/>
 <input type="hidden" name="flujoValidacion" value="${flujoValidacion}" id="flujoValidacion"/>
 <input type="hidden" name="banderaNuloDomicilioParticularTrabajador" value="${banderaNuloDomicilioParticularTrabajador}" id="banderaNuloDomicilioParticularTrabajador"/>
 <input type="hidden" name="idProcesarTrabajador" value="${trabajador.procesar}"  id="idProcesarTrabajador"/>  
 <input type="hidden" name="campoCurpSolicitante" value="${datosFolioActivo.curpSolicitante}"  id="campoCurpSolicitante"/>  
 <input type="hidden" name="reconformaExpediente" value="${reconformaExpediente}"  id="reconformaExpediente"/>  

 
 <input type="hidden" name="cvEntidadDomicilio" value=""  id="cvEntidadDomicilio"/>  
 <input type="hidden" name="cvEntidadDomicilioSolicitante" value=""  id="cvEntidadDomicilioSolicitante"/>  
 <form:form id="fm_datosConsulta" method="POST" modelAttribute="commandConsulta" action="actualizarDatos.do">
 <form:input id="idProcesar" type="hidden" name="idProcesar" path="idProcesar" value="${idProcesar}" />		
 <form:input id="idCurpConsulta" type="hidden" name="curp" path="curp" value="${curpBusqueda}" />
 <form:input id="idNssConsulta" type="hidden" name="nss" path="nss" value="${nssBusqueda}" />
 <form:input id="claveConsulta" type="hidden" name="cvTipoSolicitante" path="cvTipoSolicitante" value="${cvTipoSolicitanteBusqueda}" />
 <form:input id="timepicker1" type="hidden" name="timepicker1" path="timerPicker" value="${timerPikerBusqueda}" />
</form:form>

 <form:form id="fm_redireccion">
	
</form:form>
  <!-- inicia seccion datos certificados -->
 <form:form method="post" action="actualizaTrabajador" id="actualizaTrabajador" autocomplete="off">
  <input type="hidden" name="entradaModificacionDatos13Plus.curp"  value="${datosTrabajador.datosCertificables.curp}" id="entradaModificacionDatos13Plus.curp"/> 
 
<div class="Container" id="datosGenerales">
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
    <div class="ContainerDatosGenerales__ColTwo" id="baseCurpCertificados">
        <ul class="ContainerDatosGenerales_Seccion">
          <li class="ContainerDatosGenerales_Date form-group">
          	<c:choose>
          		<c:when test="${renapo.banderaCurp == 1 and renapo.banderaNoExisteCurp == 0 and banderaValidoRenapo == 1}">
          			<div class="ContainerDatosGenerales__NameError">
	          			<label class="LabelTextEdit" for="usuario">Curp del trabajador:</label>
	          			<div class="tooltip">
							<img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
							<span class="tooltiptext">CURP presenta diferencias con RENAPO</span>
						</div>
					</div>
          		</c:when>
          		<c:when test="${renapo.banderaNoExisteCurp == 1 and banderaValidoRenapo == 1}">
          			<div class="ContainerDatosGenerales__NameError">
	          			<label class="LabelTextEdit" for="usuario">Curp del trabajador:</label>
	          			<div class="tooltip">
							<img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
							<span class="tooltiptext">La CURP no existe en RENAPO</span>
						</div>
					</div>
          		</c:when>
          		<c:otherwise>
          			<label class="LabelTextEdit" for="usuario">Curp del trabajador:</label>
          		</c:otherwise>
          	</c:choose>
            <input class="InputEdit" type="text" id="curp" name="curp" value="${certificables.curp}" placeholder="Curp del trabajador" onchange="actualizaCurp();" maxlength="18">
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
           		<c:choose>
					<c:when test="${renapo.banderaNombre == 1 and renapo.banderaNoExisteCurp == 0 and banderaValidoRenapo == 1}">
						<div class="ContainerDatosGenerales__NameError">
          					<label class="LabelTextEdit" for="usuario">Nombre del trabajador:</label>
          					<div class="tooltip">
							  <img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
							  <span class="tooltiptext">Nombre presenta diferencias con RENAPO</span>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<label class="LabelTextEdit" for="usuario">Nombre del trabajador:</label>
					</c:otherwise>
				</c:choose>
				<input class="InputEdit" type="text" id="nombre" name="nombre" value="${certificables.nombre}" placeholder="Nombre del trabajador" maxlength="40">
				<span id="error" class="Labeltexterror"></span>		
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
          	<c:choose>
          		<c:when test="${renapo.banderaApellidoPaterno == 1 and renapo.banderaNoExisteCurp == 0 and banderaValidoRenapo == 1}">
          			<div class="ContainerDatosGenerales__NameError">
          					<label class="LabelTextEdit" for="usuario">Apellido Paterno del trabajador:</label>
          					<div class="tooltip">
							  <img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
							  <span class="tooltiptext">Apellido Paterno presenta diferencias con RENAPO</span>
							</div>
					</div>
          		</c:when>
          		<c:otherwise>
          			<label class="LabelTextEdit" for="usuario">Apellido Paterno del trabajador:</label>
            	</c:otherwise>
            </c:choose>
            <input class="InputEdit" type="text" id="apellidoPaterno" name="apellidoPaterno" value="${certificables.apellidoPaterno}" placeholder="Apellido Paterno del trabajador" maxlength="40">
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
          	<c:choose>
          		<c:when test="${renapo.banderaApellidoMaterno == 1 and renapo.banderaNoExisteCurp == 0 and banderaValidoRenapo == 1}">
          			<div class="ContainerDatosGenerales__NameError">
          					<label class="LabelTextEdit" for="usuario">Apellido Materno del trabajador</label>
          					<div class="tooltip">
							  <img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
							  <span class="tooltiptext">Apellido Materno presenta diferencias con RENAPO</span>
							</div>
					</div>
          		</c:when>
          		<c:otherwise>
          			<label class="LabelTextEdit" for="usuario">Apellido Materno del trabajador</label>
          		</c:otherwise>
          	</c:choose>
            <input class="InputEdit" type="text" id="apellidoMaterno" name="apellidoMaterno" value="${certificables.apellidoMaterno}"  placeholder="Apellido Materno del trabajador" maxlength="40">
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
          	<c:choose>
          		<c:when test="${renapo.banderaFechaNacimiento == 1 and renapo.banderaNoExisteCurp == 0 and banderaValidoRenapo == 1}">
          			<div class="ContainerDatosGenerales__NameError">
          				<label class="LabelTextEdit" for="usuario">Fecha de nacimiento:</label>
          				<div class="tooltip">
							<img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
							 <span class="tooltiptext">Fecha Nacimiento presenta diferencias con RENAPO</span>
						</div>
          			</div>
          		</c:when>
          		<c:otherwise>
          			<label class="LabelTextEdit" for="usuario">Fecha de nacimiento:</label>
          		</c:otherwise>
          	</c:choose>	
            <input class="InputEdit" type="date" id="fechaNacimiento" name="fechaNacimiento" value="${fechaNacimiento}">
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
          	<c:choose>
				<c:when test="${renapo.banderaGenero == 1 and renapo.banderaNoExisteCurp == 0 and banderaValidoRenapo == 1}">
					<div class="ContainerDatosGenerales__NameError">
						<label class="LabelTextEdit" for="usuario">Genero:</label>
						<div class="tooltip">
							<img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
							<span class="tooltiptext">Genero presenta diferencias con RENAPO</span>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					  <label class="LabelTextEdit" for="usuario">Genero:</label>
				</c:otherwise>
			</c:choose>	
            <select class="Select" id="genero" name="genero" required>
              <option value="">Seleccione una opción</option>
              <c:forEach items="${genero}" var="tGenero">
					<option value="${tGenero.chParametro}">
							<c:choose>
								<c:when test="${tGenero.chParametro == 1}">
										<c:out value="Masculino"></c:out>
								</c:when>
								<c:otherwise>
										<c:out value="Femenino"></c:out>
								</c:otherwise>
							</c:choose>	
					</option>
			  </c:forEach>
            </select>
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
          	<c:choose>
				<c:when test="${renapo.banderaEntidadNacimiento == 1 and renapo.banderaNoExisteCurp == 0 and banderaValidoRenapo == 1}">
					<div class="ContainerDatosGenerales__NameError">
						<label class="LabelTextEdit" for="usuario">Entidad de Nacimiento:</label>
						<div class="tooltip">
							<img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
							<span class="tooltiptext">Entidad de nacimiento presenta diferencias con RENAPO</span>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<label class="LabelTextEdit" for="usuario">Entidad de Nacimiento:</label>
				</c:otherwise>
			</c:choose>	
            <select class="Select" id="entidadNacimiento" name="entidadNacimiento">
<!--               <option value="">Seleccione una opción</option> -->
              <c:forEach items="${entidadesNacimiento}" var="tEntidad">
					<option value="${tEntidad.chCvEntidadFederativa}"><c:out
					value="${tEntidad.chCvEntidadFederativa} ${tEntidad.descripcion}"></c:out></option>
			  </c:forEach>
            </select>
            <span id="error" class="Labeltexterror"></span>
          </li>
          <li class="ContainerDatosGenerales_Date form-group">
                    	<c:choose>
				<c:when test="${renapo.banderaNacionalidad == 1 and renapo.banderaNoExisteCurp == 0 and banderaValidoRenapo == 1}">
					<div class="ContainerDatosGenerales__NameError">
						<label class="LabelTextEdit" for="usuario">Nacionalidad:</label>
						<div class="tooltip">
							<img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
							<span class="tooltiptext">Nacionalidad presenta diferencias con RENAPO</span>
						</div>
					</div>
				</c:when>
				<c:otherwise>
           			 <label class="LabelTextEdit" for="lnacionalidad">Nacionalidad del trabajador:</label>
				</c:otherwise>
			</c:choose>	
            <select class="Select" id="claveNacionalidad" name="claveNacionalidad" onchange="seteaNacionalidadValorDespliegue(this.value)">
              <option value="">Seleccione una opción</option>
              <c:forEach items="${nacionalidades}" var="tNacionalidad">
					<option value="${tNacionalidad.cvNacionalidad}"><c:out
					value="${tNacionalidad.cvNacionalidad} ${tNacionalidad.chDescripcion}"></c:out>
					</option>
			   </c:forEach>
            </select>
            <span id="error" class="Labeltexterror"></span>
          </li>
        </ul>
    </div>
  </div>
</div>
<jsp:include page="../modificacion/datosNoCertificados.jsp" /> 
<jsp:include page="../modificacion/datosComplementarios.jsp" /> 
<c:if test="${tipoSolicitante != '01'}">
	<jsp:include page="../modificacion/datosSolicitante.jsp" /> 
</c:if>

<div class="ContainerButtonsCenter" id="botonEnviar">
    <button type="button" class="Submit" onclick="actualizaSubmit();">ENVIAR</button>
    <button type="button" class="Submit" onclick="regresoSubmit();">REGRESAR</button>
</div> 
<jsp:include page="../modificacion/modalBeneficiario.jsp" />
</form:form>
<!-- termina seccion datos certificados -->
<jsp:include page="../modificacion/resConstanciaOk.jsp" />
<!-- Expediente servicio:solicitud de modificacion de datos --> 
<%-- <jsp:include page="../modificacion/expedienteServicio/solicitudModificacionDatosPdf.jsp" /> --%>
  <!-- inicia carrusel general -->
	<section>
		<div class="slick-carousel" id="carrusel">
	  
		  <a class="Carrousel__ThumbContainer" onclick="muestraCertificados();">
			<div class="Icon">
				<img class="IconImgMenu" src="../webResources/img/archive_icon.png" alt="icon_menu">
			</div>
			<div class="Carrousel__Title">Datos Certificables</div>
		  </a>
		  <a class="Carrousel__ThumbContainer" onclick="muestraNoCertificados();">
			<div class="Icon">
				<img class="IconImgMenu" src="../webResources/img/archive_icon.png" alt="icon_menu">
			</div>
			<div class="Carrousel__Title">Datos No Certificables</div>
		  </a>
		  
		   <a class="Carrousel__ThumbContainer" onclick="muestraComplementarios();">
			<div class="Icon">
				<img class="IconImgMenu" src="../webResources/img/archive_icon.png" alt="icon_menu">
			</div>
			<div class="Carrousel__Title">Datos Complementarios</div>
		  </a>
		 <c:if test="${tipoSolicitante != '01'}">
			  <a class="Carrousel__ThumbContainer" onclick="muestraDatosSolicitante();">
				<div class="Icon">
					<img class="IconImgMenu" src="../webResources/img/consultatrabajador.jpg" alt="icon_menu">
				</div>
				<div class="Carrousel__Title">Datos Solicitante</div>
			  </a>
		  </c:if>
		</div>
	</section>
  <!-- termina carrusel general -->
</section>
<div class="push"></div>
</div>
	<jsp:include page="../generales/footerAgente.jsp" /> 
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/slick.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/slick_carousel.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
