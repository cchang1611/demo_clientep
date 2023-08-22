$(document).ready(function() {
	var url = location.href;
	var posicion = url.indexOf("pulssar");
	var urlNueva = url.substring(0, posicion + 7);
	if(_FLUJO == "1" || _FLUJO == "2") {
		console.log(url);
		console.log(posicion);
		console.log(urlNueva);
		$.ajax({
			method      : "post",
			url         : urlNueva + "/logout",
		}).success(function(data) {
			console.log("Exito");
			if(_FLUJO == "2") {
				window.location.href = urlNueva + "/" +_URLAFORE + "public/bienvenido.do";
			} else {
				$("#cierreFooter").css("display", "block");
				$("#cierreVentana").css("display", "block");
			}
		}).fail(function(jqXHR, textStatus, errorThrown) {
			console.log("Error " + errorThrown);
		}).error(function(jqXHR, textStatus, errorThrown) {
			console.log("Error " + errorThrown);
		});
	} else {
		$("#cierreFooter").css("display", "block");
		$("#cierreVentana").css("display", "block");
	}
});