var wSocket;
var socket = 0;

function actualizarEvento() {
	
	try {
		wSocket = new WebSocket("ws://127.0.0.1:8520/biometrico/captura");
		
		wSocket.onopen = function(openEvent) {
			valoresSend();
		};
		
		wSocket.onclose = function (closeEvent) {
			if(socket == 0) {
				setTimeout(actualizarEvento, 3000);
			} 
		};
		
		wSocket.onerror = function (errorEvent) {
			console.log("WebSocket ERROR: " + errorEvent);
		};
		
		wSocket.onmessage = function (messageEvent) {
			socket = 1 ;
			var respuestaDatos = messageEvent.data; 
			if(respuestaDatos.includes("Pending") || respuestaDatos.includes("SHuellas")) {
				$.ajax({
					method      : "GET",
					url         : "verificarRespuesta.do",
					contentType : "application/json",
					data		: {response : respuestaDatos}
				}).success(function(data) {
					if(data.flujo == 2) {
						document.getElementById('tituloError').innerHTML = data.titulo;
						document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
						window.location.href = "#errorModal";
						$("#btnConsultar").removeAttr("disabled");
					} else if(data.flujo == 3) {
						document.getElementById('tituloInfo').innerHTML = data.titulo;
						document.getElementById('mensajeInfo').innerHTML = data.mensaje;
						window.location.href = "#infoModal";
						$("#btnConsultar").removeAttr("disabled");
					}
				});
			} else {
				$("#idBiometrico").val(messageEvent.data);
				var $form = $("#fm_datosConsulta");
				$form.attr("action", "datosTrabajador.do");
				$form.submit();
			}
		};
	} catch (exception) {
		console.error(exception);
		if(socket == 0) {
			setTimeout(actualizarEvento, 1000);
		} 
	}
}

function valoresSend() {
	$.ajax({
		method      : "GET",
		url         : "validarDato.do",
		contentType : "application/json"
	})
	.success(function(result) {
		if(result.flujo == 1) {
			_VAR = result.mensaje;
		}
	});
	if(_VAR != '') {
		wSocket.send(_VAR);
	} else {
		setTimeout(valoresSend, 1000);
	}
}