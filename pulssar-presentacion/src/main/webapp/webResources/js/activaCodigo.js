$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2" || _FLUJO == "4") {
		window.location.href = "#errorModal";
	}
	
	generaCaptcha();
	
	$("#aceptar").click(function(event) {
		$("form#fm_activa #aceptar").attr("disabled", "true");
		var $form = $(this).parents("#fm_activa");
		$funciones_generales.validaciones($form);
		event.preventDefault();
		
		$("#codigo").removeClass("Invalid_data");
		$("#codigo").parents(".Form__Group:first").find("label.Labeltexterror").remove();
		var $auxBandera = $funciones_generales.validacion_not_null($("#codigo").val());
		var $auxMensaje = "El c&oacute;digo es obligatorio";
		if($auxBandera) {
			$auxiliar = $funciones_generales.validacion_solo_numeros_formato($("#codigo").val());
			$auxMensaje = "Formato del c&oacute;digo incorrecto";
			if($auxiliar && $("#codigo").val().length != 4) {
				$auxBandera = false;
			}
		}
		if(!$auxBandera) {
			$("#codigo").addClass("Invalid_data");
			if($("#codigo").parents(".Form__Group").find("label.Labeltexterror").length == 0) {
				$("#codigo").parents(".Form__Group:first").append("<label class='Labeltexterror'>" + $auxMensaje + "</label>");
			}
		}
		
		if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
			$form.submit();
		} else {
			$("#aceptar").removeAttr("disabled");
		}
	});
	
	$("#reenviarActivacion").click(function(event){
		var enlace = document.getElementById("enlaceActivacion");
		enlace.style.display = 'none';
		var $form = $(this).parents("#fm_activa");
		$form.attr("method", "POST");
		$form.attr("action", "reenviarCodigoActivacion.do");
		$form.submit();
	})
	
		$("#reenviarRecuperacion").click(function(event){
		var enlace = document.getElementById("enlaceRecuperacion");
		enlace.style.display = 'none';
		var $form = $(this).parents("#fm_activa");
		$form.attr("method", "POST");
		$form.attr("action", "reenviarCodigoPassword.do");
		$form.submit();
	})
});	