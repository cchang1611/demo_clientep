<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
<title>Historial Tramites</title>
<meta charset="utf-8" />
<![if IE]>
<link id="colorsIE" type="text/css" charset="utf-8" rel="stylesheet"
	href="<c:url value='/webResources/css/general/main_ie.css'/>" />
<![endif]>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/universal_setting.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/templates.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tabs.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tables.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/styles_form.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/general/tooltip.css'/>"></link>
	<link rel="shortcut icon" href="<c:url value='/webResources/img/favicon.ico'/>"></link>
	<link href="https://fonts.googleapis.com/css?family=Ubuntu:300,300i,400,400i,500,500i,700,700i&idisplay=swap" rel="stylesheet"></link>

	<script src="<c:url value='/webResources/js/jquery.min.js'/>"></script>
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/bootstrap_tables_dynamic.css'/>"></link>
	<link rel="stylesheet" type="text/css" href="<c:url value='/webResources/css/dataTables.bootstrap.min.css'/>"></link>
	 <link rel="stylesheet" type="text/css" href="../webResources/css/general/modal_window.css"></link>
	<script src="<c:url value='/webResources/js/jquery.dataTables.min.js'/>"></script>
	<script src="<c:url value='/webResources/js/dataTables.bootstrap.min.js'/>"></script>
	<script src="<c:url value='/webResources/js/historialTramites.js'/>"></script>
	<script src="<c:url value='/webResources/js/disposicion_total_issste_historial_tramites.js'/>"></script>
	<script src="<c:url value='/webResources/js/disposicion_total_imss_historial_tramites.js'/>"></script>
	<script type="text/javascript" charset="UTF-8" src="<c:url value='/webResources/js/block-multiple-tab.js'/>"></script>
</head>
<body>
	<jsp:include page="../generales/headGeneral.jsp"></jsp:include>
	<jsp:include page="../generales/headerAgente.jsp">
		<jsp:param name="encabezado" value="2" />
		<jsp:param name="menuTitle" value="Historial de Tr&aacute;mites" />
		<jsp:param name="menuPrimario" value="2" />
		<jsp:param name="menuSecundario" value="2" />
		<jsp:param name="menuInactivo" value="5" />
	</jsp:include>
	<script type="text/javascript">
		var _REFERENCIAS = "";
		var _BENEFICIARIOS = "";
		var _MARCAS = "${marcas}";
		var _FLUJO = "";
		var _CURPS = "";
		var botonCancelacion="${botonCancelacion}";
		var botonCancelacionImss="${botonCancelacionImss}";
		
	</script>
	<div class="wrapper">
		<section>
		<div class="Title__Container">
			<h1>Historial de Tr&aacute;mites</h1>
		</div>

		<div class="Container">
			<div class="Layout__XL">
				<form name="table" method="post" action="#">
					<div style="overflow-x: auto;">
						<table class="Table_Check" width="100%" border="0" cellspacing="0" cellpadding="0">
			          		<tbody>
								<tr class="Row2">
									<td colspan="5" align="center" valign="middle">
									<table class="Table_CheckPoints" width="100%" border="0" cellspacing="0" cellpadding="0">
  								    	<tbody>
            								<tr>
											<c:forEach items="${grupos}" var="grupos" varStatus="stat">
												<td align="center" valign="middle">
		                      						<c:out value="${grupos.fechaLlegada}" />
												</td>
											</c:forEach>
											</tr>
											<tr>
												<c:choose>
													<c:when test="${fn:length(grupos) eq 1}">
													<c:forEach items="${grupos}" var="grupo" varStatus="stat">
														<c:if test="${grupo.statusProceso == -1}">
															<td class="td_checkpoints">
																<div class="tooltip02">
																<img src="../webResources/img/checkgray.jpg" alt="checkpoint_gray" style="width:144px">
																<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  					</div>
															</td>
														</c:if>
														<c:if test="${grupo.statusProceso == 1 || grupo.statusProceso == 3}">
															<td class="td_checkpoints">
																<div class="tooltip02">
																<img src="../webResources/img/checkgreen.jpg" alt="checkpoint_green" style="width:144px">
																<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  					</div>
															</td>
														</c:if>
														<c:if test="${grupo.statusProceso == 2}">
															<td class="td_checkpoints">
																<div class="tooltip02">
																<img src="../webResources/img/checkred.jpg" alt="checkpoint_red" style="width:144px">
																<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  					</div>
															</td>
														</c:if>
														<c:if test="${grupo.statusProceso == 0}">
															<td class="td_checkpoints">
																<div class="tooltip02">
																<img src="../webResources/img/checkyellow.jpg" alt="checkpoint_red" style="width:144px">
																<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  					</div>
															</td>
														</c:if>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<c:forEach items="${grupos}" var="grupo" varStatus="stat">
															<c:if test="${stat.first}">
																<c:if test="${grupo.statusProceso == -1}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_gray_inicio.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
																<c:if test="${grupo.statusProceso == 1 || grupo.statusProceso == 3}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_green_inicio.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
																<c:if test="${grupo.statusProceso == 2}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_red_inicio.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
																<c:if test="${grupo.statusProceso == 0}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_yellow_inicio.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
															</c:if>
															<c:if test="${!stat.last && !stat.first}">
																<c:if test="${grupo.statusProceso == -1}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_line_gray.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
																<c:if test="${grupo.statusProceso == 1 || grupo.statusProceso == 3}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_green.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
																<c:if test="${grupo.statusProceso == 2}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_line_red.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
																<c:if test="${grupo.statusProceso == 0}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_line_red.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
															</c:if>
															<c:if test="${stat.last && !stat.first}">
																<c:if test="${grupo.statusProceso == -1}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_gray_final.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
																<c:if test="${grupo.statusProceso == 1 || grupo.statusProceso == 3}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_green_final.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
																<c:if test="${grupo.statusProceso == 2}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_red_final.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
																<c:if test="${grupo.statusProceso == 0}">
																	<td class="td_checkpoints">
																		<div class="tooltip02">
																		<img src="../webResources/img/check_point_yellow_final.jpg">
																		<span class="tooltiptext02">${grupo.descripcion}</span>
			                                  							</div>
																	</td>
																</c:if>
															</c:if>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</tr>
											<tr>
			 									<c:forEach items="${grupos}" var="grupos" varStatus="stat">
			 										<td align="center" valign="middle">
			                       						<c:out value="${grupos.fechaCierre}" />
			 										</td>
			 									</c:forEach>
						  					</tr>
						  						<c:if test="${botonCancelacion == '1'}">
						  					<tr>
			 									<c:forEach items="${grupos}" var="grupos" varStatus="stat">
			 									<c:if test="${grupos.proceso != 365}">
			 									<td align="center" valign="middle">
			 									
			                       				</td>
			                       				</c:if>	
			 									<c:if test="${grupos.proceso == 365}">
			 										<td align="center" valign="middle">
			                       						  <a  href="#" id="cancelacionIssste"  onclick="consultarCancelacionDispoIssste()">CANCELAR</a>
			 										</td>
			 									</c:if>	
			 									</c:forEach>
						  					</tr>
						  					</c:if>
						  					<c:if test="${botonCancelacionImss == '1'}">
							  					<tr>
			               							<c:forEach items="${grupos}" var="grupos" varStatus="stat">
			 									<c:if test="${grupos.proceso != 368}">
			 									<td align="center" valign="middle">
			 									
			                       				</td>
			                       				</c:if>	
			 									<c:if test="${grupos.proceso == 368}">
			 										<td align="center" valign="middle">
								  					  <a  href="#" id="botonCancelacionImss"  onclick="consultarCancelacionDispoImss()">CANCELAR</a>
			               							</td>
			 									</c:if>	
			 									</c:forEach>
		               							</tr>
	               							</c:if>
	               						</tbody>
           							</table>
           							</td>
           						</tr>
           					</tbody>
           				</table>
           							
					</div>
					<div><br /></div>
					<div style="overflow-x: auto;">
						<table id="tablaFolios" class="table table-striped table-bordered">
							<thead>
								<tr class="RowHeader">
									<th>Status</th>
									<th>Folio</th>
									<th>Tr&aacute;mite</th>
									<th>Fecha</th>
									<th>Fecha Conclusi&oacute;n</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${folios}" var="folios" varStatus="stat">
									<tr>
										<td><c:out value="${folios.estatus}" /></td>
										<td><c:out value="${folios.chFolio}" /></td>
										<td><c:out value="${folios.descripcionServicio}" /></td>
										<td><c:out value="${folios.fechaLlegada}" /></td>
										<td><c:out value="${folios.fechaCierre}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</form>
			</div>
		</div>

		<jsp:include page="../menus/menuConsulta.jsp" /> </section>
		<div class="push"></div>
	</div>
	<jsp:include page="../generales/footerAgente.jsp" />
    <jsp:include page="../generales/modals.jsp" />
	
</body>
</html>
