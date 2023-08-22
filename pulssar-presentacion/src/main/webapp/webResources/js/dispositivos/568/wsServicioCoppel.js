/**
 * Realiza la validacion de las huellas de coppel
 * @returns
 */
function wsEventoCoppel() {
	
	try {
		wSocket = new WebSocket(_WEBSOCKET);
		
		wSocket.onopen = function(openEvent) {
			console.log("WebSocket is open now.");
			valoresSend();
		};
		
		wSocket.onclose = function (closeEvent) {
			console.log("Cerrando socket " + closeEvent);
		};
		
		wSocket.onerror = function (errorEvent) {
			console.log("WebSocket ERROR: " + errorEvent);
		};
		
		wSocket.onmessage = function (messageEvent) {
			respuestaDatos = messageEvent.data;
			console.log("Respuesta: " + respuestaDatos);
			if(!respuestaDatos.includes('"resultado":"1"')) {
				$.ajax({
					method      : "GET",
					url         : "vRespuesta.do",
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
					} else if(data.flujo == 4) {
						setTimeout(wsEventoCoppel, timeWsV);
					} else if(data.flujo == 10) {
						if ($("#btnContinuar").length > 0 ) {
							$("#btnContinuar").removeAttr("disabled");
						}
						if ($("#btnHuella").length > 0 ) {
							$("#btnHuella").removeAttr("disabled");
						}
						proceso = procesoInicial;
						window.location.href = "#";
					}
				});
			} else {
				$("#idBiometrico").val(respuestaDatos);
				$form.attr("action", actionWs);
				$form.submit();
			}
		};
	} catch (exception) {
		console.error(exception);
		if(socket == 0) {
			setTimeout(wsEventoCoppel, timeWsV);
		} 
	}
}