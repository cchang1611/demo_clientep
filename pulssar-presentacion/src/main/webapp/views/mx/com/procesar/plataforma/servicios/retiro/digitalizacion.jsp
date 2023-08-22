<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ page import="mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.EntradaCoppel,
mx.com.procesar.aplicaciones.traspasos.pulssar.servicios.modelo.ParametrosRetiroParcialCalculoImss" %>
<% 
EntradaCoppel entradaCoppel =  (EntradaCoppel) session.getAttribute("eUserCoppel");
ParametrosRetiroParcialCalculoImss parametrosRetiroParcialCalculoImss =  (ParametrosRetiroParcialCalculoImss) session.getAttribute("parametrosRetiroParcialCalculoImss");
if(entradaCoppel == null){
entradaCoppel = new EntradaCoppel();
}
%>
	<script type="text/javascript">
		var _FLUJO = "${respuesta.flujo}";
		var _FUN = '${flujoFun}';
		var context = '${pageContext.request.contextPath}';
	  	var contextoSistema = "${pageContext.request.contextPath}";
		var AFORE = '${datos.claveAfore}'
		var FOLIOPADRE = "${folio.folio}"
		var SERVICIO = "${tipoProceso}"
		var NSS = "${nssProceso}"
		var CURP = "${curpProceso}"
		var SOLICITANTE = "${tipoSolicitante}"
		var IDFOLIO_HIJO = "${folioHijo.idFolioPulssar}";
		var AGENTE = "${agente}";
		var CAMBIORFC = "${cambioRfc}";	
		var PAGOBANCO = "${parametrosRetiroParcialCalculoImss.formaPago}";	
		var IDSESSION = "<%= entradaCoppel.getIdSession()%>";
	</script>	

<form:form id="fm_recepcionImagen" method="GET" modelAttribute="entradaRecepcionImagenes" action="recepcionImagenesGenerico.do">
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
						<strong>Tipo Trabajador:</strong>
						<c:choose>
							<c:when test="${tipoTrabajador == '0'}">
								<input type="radio" id="tipo" name="tipo" value="1" checked /> IMSS 
								<input type="radio" id="tipo" name="tipo" value="2" /> ISSSTE<br />
							</c:when>
							<c:when test="${tipoTrabajador == '1'}">
								<input type="radio" id="tipo" name="tipo" value="1" checked /> IMSS
								<input type="radio" id="tipo" name="tipo" value="2" disabled="true" /> ISSSTE<br />
							</c:when>
							<c:otherwise>
								<input type="radio" id="tipo" name="tipo" value="1" disabled="true" /> IMSS
								<input type="radio" id="tipo" name="tipo" value="2" checked /> ISSSTE<br />
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<%--<form:input id="idFolioPadre" type="hidden" name="folioPadre" path="folioPadre" value="folio" /> --%>
			<form:input id="idFolioPadre" type="hidden" name="folioPadre" path="folioPadre" value="${folio.folio}" />
			<form:input id="idFolioHijo" type="hidden" name="folioHijo" path="folioHijo" value="${folioHijo}" />
			<form:input id="idTipoProceso" type="hidden" name="tipoProceso" path="tipoProceso" value="${tipoProceso}" />
			<form:input id="idEstatusRecepcion" type="hidden" name="estatusRecepcion" path="estatusRecepcion" value="1" />
			<form:input id="idUrlSiguiente" type="hidden" name="urlSiguiente" path="urlSiguiente" value="${urlSiguiente}" />
			
			<div style="text-align: center; padding: 20px 0px 0px 0px; width: 100%;">
				<input id="btnRecepcionImgCop" class="Submit" type="button" value="DIGITALIZAR">
			</div>
		</div>
	</div>
</form:form>