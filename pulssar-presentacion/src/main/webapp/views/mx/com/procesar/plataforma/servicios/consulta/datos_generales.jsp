<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<title>Datos Generales del Trabajador</title>
	<meta charset="utf-8" />
	<![if IE]>
		<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet" href="<c:url value='/webResources/css/general/main_ie.css'/>" />
	<![endif]>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/datos_generales.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tooltip.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>
	
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/vendor/jquery-1.11.0.min.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/pestana.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Consulta del Trabajador" />
		<jsp:param name="menuPrimario" value = "2" />
		<jsp:param name="menuSecundario" value = "2" />
		<jsp:param name="menuInactivo" value = "1" />
	</jsp:include>
	<script type="text/javascript">
		var _REFERENCIAS = "";
		var _BENEFICIARIOS = "";
		var _MARCAS = "${marcas}";
		var _CURPS = "${curpsDuplicadas}";
		var _FLUJO = "${respuesta.flujo}";
		
		
	</script>
	<div class="wrapper">
		<section>
			<div class="Title__Container">
				<h1>Datos Generales</h1>
			</div>
			<div class="Container">
				<div class="ContainerDatosGenerales">
					<div class="ContainerDatosGenerales__ColOne">
					  <c:choose>
							<c:when test="${not empty trabajador.imagen}">
								<img class="ContainerDatosGenerales__Img" src="data:image/png;base64, ${trabajador.imagen}" alt="Imagen del Trabajador" />
							</c:when>
							<c:otherwise>
								<img class="ContainerDatosGenerales__Img" src="../webResources/img/user_photo.jpg"  alt="Imagen del Trabajador no encontrada" />
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${renapo.banderaNombre == 1}">
								<div class="ContainerDatosGenerales__NameError">
									${trabajador.nombreTrabajador}
									<div class="tooltip">
									  <img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
									  <span class="tooltiptext">Nombre presenta diferencias con RENAPO</span>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="ContainerDatosGenerales__Name" id="idNombre">
									${trabajador.nombreTrabajador}
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="ContainerDatosGenerales__ColTwo">
					  <c:if test = "${fn:contains(aforesModificacion, stiloOrg) && not sessionScope.consultaAgente}">
						<div class="Icon__Container" id="botonEditarMdd">
							<a href="modificaTrabajador.do" class="Icon__Seccion" onclick="bloquearEnlace(this)">
								<img class="Icon__Editar" src="../webResources/img/icon_editar.png" alt="icon_editar" />
								<p>Editar</p>
							</a>
						</div>
						 </c:if>
						<ul class="ContainerDatosGenerales_Seccion">
							<c:if test="${not empty trabajador.nss}">
								<li class="ContainerDatosGenerales_Date" id="idNss"><strong>NSS:</strong> ${trabajador.nss}</li>
							</c:if>
							<c:choose>
								<c:when test="${renapo.banderaCurp == 1}">
									<li class="ContainerDatosGenerales_DateError" id="idCurp"><strong>CURP:</strong> ${certificables.curp}
										<div class="tooltip">
											<img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
											<span class="tooltiptext">CURP presenta diferencias con RENAPO</span>
										</div>
									</li>
								</c:when>
								<c:otherwise>
									<li class="ContainerDatosGenerales_Date" id="idCurp"><strong>CURP:</strong> ${certificables.curp}</li>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${renapo.banderaFechaNacimiento == 1}">
									<li class="ContainerDatosGenerales_DateError" id="idFcNacimiento"><strong>FECHA DE NACIMIENTO:</strong> ${certificables.fechaNacimiento}
										<div class="tooltip">
											<img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
											<span class="tooltiptext">Fecha Nacimiento presenta diferencias con RENAPO</span>
										</div>
									</li>
								</c:when>
								<c:otherwise>
									<li class="ContainerDatosGenerales_Date" id="idFcNacimiento"><strong>FECHA DE NACIMIENTO:</strong> ${certificables.fechaNacimiento}</li>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${renapo.banderaGenero == 1}">
									<li class="ContainerDatosGenerales_DateError" title="Genero presenta diferencias con Renapo" id="idGenero"><strong>GENERO:</strong> ${certificables.genero}
										<div class="tooltip">
											<img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
											<span class="tooltiptext">Genero presenta diferencias con RENAPO</span>
										</div>
									</li>
								</c:when>
								<c:otherwise>
									 <li class="ContainerDatosGenerales_Date" id="idGenero"><strong>GENERO:</strong> ${certificables.genero}</li>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${renapo.banderaEntidadNacimiento == 1}">
									<li class="ContainerDatosGenerales_DateError" title="ENTIDAD DE NACIMIENTO presenta diferencias con Renapo" id="ideNacimiento"><strong>ENTIDAD DE NACIMIENTO:</strong> ${certificables.entidadNacimiento}
										<div class="tooltip">
											<img class="tooltip_icon" src="../webResources/img/icon_error_label.png" alt="icon_error"/>
											<span class="tooltiptext">Entidad de nacimiento presenta diferencias con RENAPO</span>
										</div>
									</li>
								</c:when>
								<c:otherwise>
									<li class="ContainerDatosGenerales_Date" id="ideNacimiento"><strong>ENTIDAD DE NACIMIENTO:</strong> ${certificables.entidadNacimiento}</li>
								</c:otherwise>
							</c:choose>		  
							<li class="ContainerDatosGenerales_Date" id="idRfc"><strong>RFC:</strong> ${rfc}</li>
							<li class="ContainerDatosGenerales_Date" id="idcElectronico"><strong>CORREO ELECTRÓNICO:</strong> ${correo}</li>
							<c:if test="${not empty trabajador.nacionalidad}">
								<li class="ContainerDatosGenerales_Date" id="idNacionalidad"><strong>NACIONALIDAD:</strong> ${trabajador.nacionalidad}</li>
							</c:if>
						</ul>
						<ul class="ContainerDatosGenerales_Seccion">
							<li class="ContainerDatosGenerales_Date"><strong>Domicilio</strong></li>
							<li class="ContainerDatosGenerales_Date" id="idCalle"><strong>Calle:</strong> ${domicilio.calle}</li>
							<li class="ContainerDatosGenerales_Date" id="idNoExterior"><strong>No. Ext:</strong> ${domicilio.noExterior}</li>
							<li class="ContainerDatosGenerales_Date" id="idNoInterior"><strong>No. Int:</strong> ${domicilio.noInterior}</li>
							<li class="ContainerDatosGenerales_Date" id="idColonia"><strong>Colonia:</strong> ${domicilio.colonia}</li>
							<li class="ContainerDatosGenerales_Date" id="idMunicipio"><strong>Municipio:</strong> ${domicilio.municipio}</li>
							<li class="ContainerDatosGenerales_Date" id="idEntFederativa"><strong>Ent fed:</strong> ${domicilio.entidadFederativa}</li>
							<li class="ContainerDatosGenerales_Date" id="idCp"><strong>C.P:</strong> ${domicilio.codigoPostal}</li>
						</ul>
						<ul class="ContainerDatosGenerales_Seccion">
								<c:choose>
									<c:when test="${trabajador.certificado != null}">
										<li class="ContainerDatosGenerales_Date"><strong>RECERTIFICADO</strong> 
											<img  class="IconImg" src="../webResources/img/icon_paloma.png" alt="icon_ok"/>
										</li>
										<li class="ContainerDatosGenerales_Date"><strong>Fecha inicio: </strong>${trabajador.certificado.fechaInicio}</li> 
										<li class="ContainerDatosGenerales_Date"><strong>Fecha fin: </strong>${trabajador.certificado.fechaFin}</li> 
			 							<c:if test="${trabajador.certificado.idTipoContacto == 1}">
											<li class="ContainerDatosGenerales_Date"><strong>Medio de atenci&oacute;n: </strong>Presencial</li>
										</c:if> 
			 							<c:if test="${trabajador.certificado.idTipoContacto == 2}">
											<li class="ContainerDatosGenerales_Date"><strong>Medio de atenci&oacute;n: </strong>No Presencial</li>
										</c:if> 
									</c:when>
									<c:otherwise>
										<li class="ContainerDatosGenerales_Date"><strong>RECERTIFICADO</strong> 
											<img  class="IconImg" src="../webResources/img/icon_tache.png" alt="icon_tache"/>
										</li>
									</c:otherwise>
								</c:choose>
							<li class="ContainerDatosGenerales_Date"><strong>Indicador Retiro Desempleo:</strong> 
								<c:choose>
									<c:when test="${trabajador.fechaDesempleo != null}">
										<img  class="IconImg" src="../webResources/img/icon_paloma.png" alt="icon_ok"/>
										<li class="ContainerDatosGenerales_Date"><strong>Fecha: </strong>${trabajador.fechaDesempleo}</li> 
									</c:when>
									<c:otherwise>
										<img  class="IconImg" src="../webResources/img/icon_tache.png" alt="icon_tache"/>
									</c:otherwise>
								</c:choose>
							</li>
							<li class="ContainerDatosGenerales_Date"><strong>Indicador Retiro Matrimonio:</strong> 
								<c:choose>
									<c:when test="${trabajador.fechaMatrimonio != null}">
										<img  class="IconImg" src="../webResources/img/icon_paloma.png" alt="icon_ok"/>
										<li class="ContainerDatosGenerales_Date"><strong>Fecha: </strong>${trabajador.fechaMatrimonio}</li> 
									</c:when>
									<c:otherwise>
										<img  class="IconImg" src="../webResources/img/icon_tache.png" alt="icon_tache"/>
									</c:otherwise>
								</c:choose>
							</li>
							<li class="ContainerDatosGenerales_Date"><strong>Curp Historica Consultada:</strong> 
								<c:choose>
									<c:when test="${expedienteB.banderaCurpHistorica == 1}">
										<img  class="IconImg" src="../webResources/img/icon_paloma.png" alt="icon_ok"/> &nbsp;&nbsp;&nbsp;<strong>${expedienteB.curpHistorica}</strong>
									</c:when>
									<c:otherwise>
										<img  class="IconImg" src="../webResources/img/icon_tache.png" alt="icon_tache"/>
									</c:otherwise>
								</c:choose>
							</li>
						</ul>
					</div>
				</div>
				<div>
					<c:if test="${not empty renapo}">
						<div class="ContainerTabs">
							<div class="PestanaContainerRenapo">
								<div id="detallerenapo" class="PestanaTableContainerRenapo">
									<div class="ContentRenapo">
										<ul class="ContainerDatosGenerales_SeccionRenapo">
											<li class="ContainerDatosGenerales_DatosRenapo" id="idRcurp"><strong class="TextRenapo">CURP:</strong>${renapo.curp}</li>
											<li class="ContainerDatosGenerales_DatosRenapo" id="idRnombre"><strong class="TextRenapo">Nombre:</strong>${renapo.nombre}</li>
											<li class="ContainerDatosGenerales_DatosRenapo" id="idRapPaterno"><strong class="TextRenapo">Apellido Paterno:</strong>${renapo.apellidoPaterno}</li>
											<li class="ContainerDatosGenerales_DatosRenapo" id="idRapMaterno"><strong class="TextRenapo">Apellido Materno:</strong>${renapo.apellidoMaterno}</li>
											<li class="ContainerDatosGenerales_DatosRenapo" id="idRfcNacimiento"><strong class="TextRenapo">Fecha Nacimiento:</strong>${renapo.fechaNacmiento}</li>
											<li class="ContainerDatosGenerales_DatosRenapo" id="idRgenero"><strong class="TextRenapo">Genero:</strong>${renapo.sexo}</li>
											<li class="ContainerDatosGenerales_DatosRenapo" id="idRentNacimiento"><strong class="TextRenapo">Entidad Nacimiento:</strong>${renapo.entidadNacimiento}</li>
											<li class="ContainerDatosGenerales_DatosRenapo" id="idRcurpHis"><strong class="TextRenapo">CURP Historicas:</strong>${renapo.curpsHistoricas}</li>
										</ul>
									</div>
								</div>
								<a href="#" id="titulorenapo" onclick="mostrar('detallerenapo')" class="PestanaTitleRenapo">
								  <p>Renapo</p>
								</a>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty curpsDuplicadas}">
						<div class="ContainerTabs" id="pestanaCurps">
							<div class="PestanaContainerCurp">
								<div id="detallecurp" class="PestanaTableContainerCurp">
									<div class="PestanaTitleContainerCurp">Clave afore duplicidad</div>
									<div class="PestanasCarouselCurp" id="curpsTrabajador"></div>
								</div>
								<a href="#" id="titulocurp" onclick="mostrar('detallecurp')" class="PestanaTitleCurp">
									<p>Curp</p>
								</a>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty trabajador.canase}">
						<div class="ContainerTabs">
							<div class="PestanaContainerRenapo">
								<div id="detalleprocanase" class="PestanaTableContainerRenapo">
									<div class="ContentRenapo">
										<ul class="ContainerDatosGenerales_SeccionRenapo">
											<li class="ContainerDatosGenerales_DateRenapo"><strong class="TextRenapo"> DATOS GENERALES </strong></li>
											<li class="ContainerDatosGenerales_DateRenapo"><strong class="TextRenapo"> NSS: </strong>${trabajador.nss}</li>
											<li class="ContainerDatosGenerales_DateRenapo"><strong class="TextRenapo"> Nombre: </strong>${trabajador.canase.nombreImss}</li>
											<li class="ContainerDatosGenerales_DateRenapo"><strong class="TextRenapo"> Sexo: </strong>${trabajador.canase.sexo}</li>
											<li class="ContainerDatosGenerales_DateRenapo"><strong class="TextRenapo"> Mes de Nacimiento: </strong>${trabajador.canase.mesNacimiento}</li>
											<c:if test="${not empty trabajador.canase.entidadNacimiento}">
												<li class="ContainerDatosGenerales_DateRenapo"><strong class="TextRenapo"> Entidad de Nacimiento: </strong>${trabajador.canase.entidadNacimiento.descripcion}</li>
											</c:if>
											<li class="ContainerDatosGenerales_DateRenapo"><strong class="TextRenapo"> Fecha de Alta Procanase: </strong>${trabajador.canase.fechaAlta}</li>
											<li class="ContainerDatosGenerales_DateRenapo"><strong class="TextRenapo"> Fecha de Ultimo Movimiento: </strong>${trabajador.canase.fechaUltimaTransaccion}</li>
										</ul>
									</div>
								</div>
								<a href="#" id="tituloprocanase" onclick="mostrar('detalleprocanase')" class="PestanaTitleRenapo">
									<p>Procanase</p>
								</a>
							</div>
						</div>
					</c:if>
				
			</div>
			</div>
			<jsp:include page="../menus/menuConsulta.jsp" />
		</section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
	
	<div class="Pestana" id="pestanaMarcas">
		<div class="PestanaContainer">
		  <a href="#" id="titulo" onclick="mostrar('detalle')" class="PestanaTitle">
			<p>Marcas Operativas</p>
		  </a>
		  <div id="detalle" class="PestanaTableContainer">
			<div class="PestanaTitleContainer">Descripción</div>
			<div class="PestanasCarousel" id="marcasTrabajador">
			</div>
		  </div>
		</div>
	</div>
	
	<script src="<c:url value='/webResources/js/cargaRefBen.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/jquery-migrate-1.2.1.min.js'/>"></script>
	<jsp:include page="../generales/modals.jsp" />
</body>
</html>
