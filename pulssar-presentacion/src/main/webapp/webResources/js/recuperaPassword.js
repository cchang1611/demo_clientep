$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2") {
		window.location.href = "#errorModal";
	}
	
	generaCaptcha();
	
	$("#aceptar").click(function(event) {
		$("form#fm_olvida #aceptar").attr("disabled", "true");
		var $form = $(this).parents("#fm_olvida");
		$funciones_generales.validaciones($form);
		event.preventDefault();
		
		$("#codigo").removeClass("Invalid_data");
		$("#codigo").parents(".Form__Group:first").find("label.Labeltexterror").remove();
		
		$("#email").removeClass("Invalid_data");
		$("#email").parents(".Form__Group:first").find("label.Labeltexterror").remove();
		
		var $auxBandera = $funciones_generales.validacion_not_null($("#codigo").val());
		var $auxMensaje = "El código es obligatorio";
		
		if($auxBandera) {
			$auxiliar = $funciones_generales.validacion_solo_numeros_formato($("#codigo").val());
			$auxMensaje = "Formato del código incorrecto";
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
		
		if ($("#celular").val() == '' && $("#email").val() == ''){
			$("#email").addClass("Invalid_data");
			if($("#email").parents(".Form__Group").find("label.Labeltexterror").length == 0) {
				$("#email").parents(".Form__Group:first").append("<label class='Labeltexterror'>Es necesario capturar al menos el campo celular o correo electrónico</label>");
			}
		}
		
		if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
			$form.submit();
		} else {
			$("#aceptar").removeAttr("disabled");
		}
	});
	
	
	$("#reenviar").click(function(event){
			var $form = $(this).parents("#fm_olvida");
			$form.attr("method", "POST");
			$form.attr("action", "reenvioCorreo.do");
			$form.submit();
		})
});	