$(document).ready(function(){
	if(_FLUJO == "1") {
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2") {
		window.location.href = "#errorModal";
	}

	$("#claveOrganizacion").on('change',function(){
		$('#ulCheckBox').empty();
		var clave = '';
		if($("#claveOrganizacion").length > 0){
			clave = $("#claveOrganizacion").val();
		}
		$.ajax({
			method      : "GET",
			url         : "administraCorreo.do",
			contentType : "application/json",
			data        : {cvAfore : clave},
		})
		.success(function(data) {
			if(data.flujo != 1) {
				document.getElementById('tituloAlerta').innerHTML = data.titulo;
				document.getElementById('mensajeAlerta').innerHTML = data.mensaje;
				window.location.href = "#errorModal";
			} else if(data.flujo == 1) {
				$("#ulCheckBox").empty();
				$("#ulCheckBox").append(data.mensaje);
			}
		});
	});
	
	$("#btnRegistro").click(function(event){
		$("#btnRegistro").attr("disabled", "true");
		var $form = $(this).parents("#fm_correo");
		event.preventDefault();
		
		var valoresCheck = $("input[name='optChek[]']:checked").map(function() {
			return this.value;
		}).get();
		$("#coTexto").val(valoresCheck);
		$form.submit();
		$("#btnRegistro").removeAttr("disabled");
	});
});