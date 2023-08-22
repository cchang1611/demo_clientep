$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		window.location.href = "#exitoModalCambio";
	} else if(_FLUJO == "2" || _FLUJO == "4") {
		window.location.href = "#errorModal";
	}
	
	generaCaptcha();
	
	$("#btnAceptar").click(function(event) {
		$("form#fm_cambio #btnAceptar").attr("disabled", "true");
		var $form = $(this).parents("#fm_cambio");
		$funciones_generales.validaciones($form);
		event.preventDefault();
		
		if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
			$form.submit();
		} else {
			$("#btnAceptar").removeAttr("disabled");
		}
	});
	
	$("#btnExitoCambio").click(function(event) {
		var $form = $(this).parents('form:first');
		$form.attr("method", "GET");
		$form.attr("action", "finalizaCambio.do");
		$form.submit();
	});
});	