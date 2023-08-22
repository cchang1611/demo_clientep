var actionWs;
var $form;
$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	$form = $('#fm_Biometrico');
	
	if(_FLUJO == "1") {
		
	} else if(_FLUJO == "2") {
		$("#btnErrorM").attr('href', "continuarFlujoModificacion.do");
		window.location.href = "#errorModal";
	} else if(_FLUJO == 3) {
		
	}
	
	if(_DATOS != null || _DATOS != "") {
		openActiveX(_DATOS);
	}
	
	actionWs = _URLFINAL;
	urlObtenerRespuesta = "obtenerHuellasTrabajador.do";
});