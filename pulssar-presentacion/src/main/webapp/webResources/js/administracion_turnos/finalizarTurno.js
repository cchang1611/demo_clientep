$(document).ready(function() {
	
	var tituloAlerta = "";
	var mensajeAlerta = "";
	
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		$("#submitAceptar").attr("disabled", "true");
		window.location.href = "#exitoModalAceptar";
	} else if(_FLUJO == "2" || _FLUJO == "4") {
		$("#submitAceptar").attr("disabled", "true");
		window.location.href = "#errorModal";
	}
	
	$("#btnExitoAceptar").click(function(event) {
		menuPrincipal();
	});
	
	$("#btnInfoModal").click(function(event) {
		menuPrincipal();
	});

	$("#submitAceptar").click(function(event) {
		$("#submitAceptar").attr("disabled", "true");
		var $form = $(this).parents("#fm_finalizarTurno");
		
		if($("#cancelar").val() == 0){
			$funciones_generales.validaciones($form);
			event.preventDefault();	
			
			var valoresCheck = $("input[name='listaServicios']:checked").map(function() {
				return this.value;
			}).get();
			
			if(valoresCheck.length == 0) {
				$("#ulCheckBox").addClass("Invalid_data");
				if($("#ulCheckBox").parents(".Form__Group").find("label.Labeltexterror").length == 0) {
					$("#ulCheckBox").parents(".Form__Group:first").append("<label class='Labeltexterror'>Debe seleccionar un servicio.</label>");
				}
			} else {
				$("#ulCheckBox").removeClass("Invalid_data");
				$("#ulCheckBox").parents(".Form__Group:first").find("label.Labeltexterror").remove();
			}		
				
			if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
				$form.submit();
			} else{
				$("#submitAceptar").removeAttr("disabled");
			}
		}else{
			$form.submit();
		}	
	});
	
	$("#submitCancelar").click(function(event) {
		menuPrincipal();
	});	
	
	function menuPrincipal(){
		window.location = 'menuPrincipal.do';
	}
	
	$("#checkCancelar").click(function() {
		var list = $("#ulCheckServicios > li > input[type='checkbox']");
		if($(this).is(':checked')){
			$("#cancelar").val('1');			
			list.prop("disabled", true);
			list.prop("checked", false);
			$("#folioAtencion").attr("disabled", "true");
			$("#folioAtencion").val("");
			eliminaMensajeError("#ulCheckBox");
			eliminaMensajeError("#folioAtencion");
		}else{
			$("#cancelar").val('0');
			list.prop("disabled", false);
			$("#folioAtencion").removeAttr("disabled");
		}
	});
	
	function eliminaMensajeError(elemento){		
		$(elemento).removeClass("Invalid_data");
		$(elemento).removeClass("Inputerror");
		$(elemento).parents(".Form__Group:first").find("label.Labeltexterror").remove();
	}
});


