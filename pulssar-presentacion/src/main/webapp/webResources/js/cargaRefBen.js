$(document).ready(function(){
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2") {
		window.location.href = "#errorModal";
	} else if(_FLUJO == "4") {
		window.location.href = "#infoModal";
	}
	
	$('#referenciasTrabajador').append(_REFERENCIAS);
	$('#beneficiariosTrabajador').append(_BENEFICIARIOS);
	
	$('#pestanaMarcas').hide();
	if(_MARCAS != "") {
		$('#marcasTrabajador').append(_MARCAS);
		$('#pestanaMarcas').show();
	}
	
	$('#pestanaCurps').hide();
	if(_CURPS != "") {
		$('#curpsTrabajador').append(_CURPS);
		$('#pestanaCurps').show();
	}
});