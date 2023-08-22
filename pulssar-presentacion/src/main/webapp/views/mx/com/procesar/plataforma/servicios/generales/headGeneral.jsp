<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="g"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<link id="colors" rel="stylesheet" charset="utf-8" type="text/css" href="<g:url value='/webResources/css/general/main.css'/>"></link>
	
	<script  type="text/javascript" charset="utf-8">
		$(document).ready(function() {
			var stiloGenerico = 'main';
			var stilo = '<%=request.getSession().getAttribute("stiloOrg")%>';
			var cssConfigurable = '<%=request.getSession().getAttribute("stiloConf")%>';
			if(cssConfigurable == null || !(cssConfigurable.indexOf(stilo) !== -1)) {
				stilo = stiloGenerico;
			}
			
			console.log('Stilo: ' + stilo);
			
			$('#colors').attr('href', "<g:url value='/webResources/css/general/" + stilo + ".css'/>");
			$('#colorsIE').attr('href', "/pulssar/webResources/css/general/" + stilo + "_ie.css");
			
			$.ajax({
				method      : "GET",
				url         : "imagenAfore.do",
				contentType : "application/json",
			})
			.success(function(data) {
				if ($("#imgHeader").length > 0 ) {
					if(typeof data === 'undefined' || typeof data.datos === 'undefined') {
						$("#imgHeader").attr("src", "/pulssar/webResources/img/logo_accesar.png");
					} else {
						var cadena = stilo + ".jpg";
						if(stilo === 'main') {
							cadena =  'logo_accesar.png';
						}
						$("#imgHeader").attr("src", "/pulssar/webResources/img/"+ cadena);
					}
				}
			});
		});
	</script>
</head>
<body></body>
</html>