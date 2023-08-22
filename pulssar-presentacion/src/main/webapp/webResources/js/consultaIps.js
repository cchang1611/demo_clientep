$(document).ready(function(){
	if(_FLUJO == "1") {
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2") {
		window.location.href = "#errorModal";
	} else if(_FLUJO == "4") {
		window.location.href = "#infoModal";
	}
	
	$("#idVipsPlataforma").attr("readOnly",true);

	$("#claveOrganizacion, #idPlataforma").on('change',function(){
		$('#idVipsPlataforma').val("");
		var clave = '';
		var plataforma = '';
		if($("#claveOrganizacion").length > 0 && $("#idPlataforma").length > 0) {
			clave = $("#claveOrganizacion").val();
			plataforma = $("#idPlataforma").val();
		}
		$.ajax({
			method      : "GET",
			url         : "administraIP.do",
			contentType : "application/json",
			data        : {	cvAfore : clave,
							plataforma : plataforma },
		})
		.success(function(data) {
			if(data.flujo != 1) {
				document.getElementById('tituloAlerta').innerHTML = data.titulo;
				document.getElementById('mensajeAlerta').innerHTML = data.mensaje;
				window.location.href = "#errorModal";
			} else if(data.flujo == 1) {
				$('#idVipsPlataforma').val(data.mensaje);
			}
		});
	});
	
	$("#btnRegistro").click(function(event) {
		event.preventDefault();
		$("#btnRegistro").attr("disabled", "true");
		var $form = $(this).parents("#fm_consultaIps");
		$form.submit();
		$("#btnRegistro").removeAttr("disabled");
	});
	
	$("#btnLimpiar").click(function(event){
		event.preventDefault();
		var $form = $(this).parents("#fm_consultaIps");
		$form.attr("action", "consultaIPs.do");
		$form.submit();
	});
	
	$("#idIpsPlataforma").blur(function(){
		var valor = $("#idIpsPlataforma").val();
		if(valor.length >= 7 ) {
			var cadenas = [];
			var cadena = "";
			var j = 0;
			for(var i = 0; i < valor.length; i++) {
				if(valor[i].match(/^([\d.\r\n])*$/)) {
					cadena += valor[i];
				} else {
					cadenas[j] = cadena;
					cadena = "";
					j++;
				}
			}
			cadenas[j] = cadena;
			var finalCadena = "";
			for(var i = 0; i < cadenas.length; i++) {
				if(cadenas[i] != "") {
					finalCadena += cadenas[i];
					if(finalCadena[finalCadena.length - 1] != "\n") {
						finalCadena += "\r\n";
					}
				}
			}
			$("#idIpsPlataforma").val(finalCadena);
		}
	});
});