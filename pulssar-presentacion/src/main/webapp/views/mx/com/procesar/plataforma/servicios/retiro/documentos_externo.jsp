<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<script type="text/javascript">
	var AFORE = '${datos.claveAfore}'
	var FOLIOPADRE = "${folioPadre.chFolio}"
	var SERVICIO = "${tipoProceso}"
	var NSS = "${nssProceso}"
	var CURP = "${curpProceso}"
	var SOLICITANTE = "${tipoSolicitante}"
	var INTENTOS = "${intentos.chValorParametro}";
	var IDFOLIO_HIJO = "${folioHijo.idFolioPulssar}";
	var AGENTE = "${agente}";
	var AMBIENTE = "${ambienteBanorte}";
	var CAMBIORFC = "${cambioRfc}";	
	var contextoSistema = "${pageContext.request.contextPath}";
</script>
	
	
<form:form id="fm_recepcionImagen" method="GET" modelAttribute="entradaRecepcionImagenes" action="recepcionImagenes.do">
				<div class="Container">
					<div class="Layout__XL">
						<div class="Title">
							<p>Digitalización de Documentos para Expediente Electrónico</p>
						</div>
						<div class="Datos_Container">
							<div class="row_container">
								<div class="Datosxxl" id="idDocumentos">
									<strong>Folio Documentos:</strong> ${folioDocumento}
								</div>
								<div class="Datosxxl" id="idTrabajdor">
									
									<c:choose>
										<c:when test="${tipoTrabajador == '0'}">
											<input style="display:none" type="radio" id="tipo" name="tipo" value="1" checked />  
											<input style="display:none" type="radio" id="tipo" name="tipo" value="2" />
										</c:when>
										<c:when test="${tipoTrabajador == '1'}">
											<input style="display:none" type="radio" id="tipo" name="tipo" value="1" checked /> 
											<input style="display:none" type="radio" id="tipo" name="tipo" value="2" disabled="true" /> 
										</c:when>
										<c:otherwise>
											<input style="display:none" type="radio" id="tipo" name="tipo" value="1" disabled="true" /> 
											<input style="display:none" type="radio" id="tipo" name="tipo" value="2" checked /> 
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
						<form:input id="idFolioPadre" type="hidden" name="folioPadre" path="folioPadre" value="${folioPadre.chFolio}" />
						<form:input id="idFolioHijo" type="hidden" name="folioHijo" path="folioHijo" value="${folioHijo.chFolio}" />
						<form:input id="idTipoProceso" type="hidden" name="tipoProceso" path="tipoProceso" value="${tipoProceso}" />
						<form:input id="idEstatusRecepcion" type="hidden" name="estatusRecepcion" path="estatusRecepcion" value="1" />
						<form:input id="idUrlSiguiente" type="hidden" name="urlSiguiente" path="urlSiguiente" value="enviarIdentificacionDigitalizacion.do" />

						<c:choose>
							<c:when test="${datos.claveAfore == '530'}">
								<div
									style="text-align: center; padding: 20px 0px 0px 0px; width: 100%;">
									<input id="btnRecepcionImgBan" class="Submit" type="submit" value="DIGITALIZAR">
								</div>
							</c:when>
							<c:otherwise>
								<div
									style="text-align: center; padding: 20px 0px 0px 0px; width: 100%;">
									<input id="btnRecepcionImgCop" class="Submit" type="submit" value="DIGITALIZAR">
								</div>
							</c:otherwise>

						</c:choose>
					</div>
				</div>
			</form:form>
			
			
			
			