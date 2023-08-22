$(document).ready(function() {
	var tituloAlerta = "";
	var mensajeAlerta = "";
	
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2") {
		window.location.href = "#loginErrorModal";
	}
	
	$("#btnEntrar").click(function(event) {
		$("#btnEntrar").attr("disabled", "true");
		var $form = $(this).parents("#fm_login");
		$funciones_generales.validaciones($form);
		event.preventDefault();
		
		if ($(".InputError").length == 0) {
			var vUser = $("#loginUser").val();
			var claveSucursal = $("#claveSucursal").val();
			event.preventDefault();
			$.ajax({
				method      : "GET",
				url         : "usuarioAdmin.do/" + vUser + "/",
				contentType : "application/json",
				data        : {claveSucursal : claveSucursal}
			})
			.success(function(data) {
				$("#btnEntrar").removeAttr("disabled");
				if(data.flujo == 2) {
					if(data.mensaje.indexOf("https://www.tramitesar.com/pulssar") !== -1) {
						document.getElementById('mensajeAlerta').style.fontSize = "14px";
					}
					document.getElementById('tituloAlerta').innerHTML = data.titulo;
					document.getElementById('mensajeAlerta').innerHTML = data.mensaje;
					window.location.href = "#loginErrorModal";
				} else {
					if(data.flujo == 5) {
						$form.attr('action', data.mensaje);
					}
					$form.submit();
				}
			});
		}else{
			$("form#fm_login #btnEntrar").removeAttr("disabled");
		}
	});
	
	var message = document.getElementById('errorSpring').innerHTML;
	if(message != "" && message != null) {
		$.ajax({
			method      : "GET",
			url         : "bloqueoUsuario.do",
			contentType : "application/json",
			data        : {salida : message}
		})
		.success(function(data) {
			if(data.flujo == 2) {
				document.getElementById('tituloAlerta').innerHTML = data.titulo;
				document.getElementById('mensajeAlerta').innerHTML = data.mensaje;
				window.location.href = "#loginErrorModal";
				$("#btnEntrar").removeAttr("disabled");
			}
		});
	}
});