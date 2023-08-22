var wSocket;
var socket = 0;
function actualizarEventosSocket() {
	try {
		wSocket = new WebSocket("ws://127.0.0.1:8520/biometrico/captura");
		
		wSocket.onopen = function(openEvent) {
			window.location.href = "#modalLoaderX";
			wSocket.send(_VAR);
		};
		
		wSocket.onclose = function (closeEvent) {
			if(socket == 0) {
				setTimeout(actualizarEventosSocket, 3000);
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
					url         : "validarRespuesta.do",
					contentType : "application/json",
					data		: {response : respuestaDatos}
				}).success(function(data) {
					if(data.flujo == 2) {
						document.getElementById('tituloError').innerHTML = data.titulo;
						document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
						window.location.href = "#errorModal";
					} else if(data.flujo == 3) {
						document.getElementById('tituloInfo').innerHTML = data.titulo;
						document.getElementById('mensajeInfo').innerHTML = data.mensaje;
						window.location.href = "#infoModal";
					}
				});
			} else {
				$("#imagen").val(messageEvent.data);
				var $form = $("#fm_Biometrico");
				$form.attr("action", "obtenerRespuestaHuellas.do");
				$form.submit();
			}
		};
	} catch (exception) {
		console.error(exception);
		if(socket == 0) {
			setTimeout(actualizarEventosSocket, 1000);
		} 
	}
}