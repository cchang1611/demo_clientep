var wSocket;
var socket = 0;
var $form;
var tipo = 2;
var respuestaDatos;
var proceso = "4";
var procesoInicial = "4";
var ejecutarHref = 1;
/**
 * levanta aplicativo para toma de huella
 * @returns
 */
function eventoCaptura() {
	setTimeout(wsEventoCaptura, timeWsV);
	window.location.href = "#modalLoaderX";
	if(_WEBAFORE == "568") {
		tipo = 1;
	} else {
		if(ejecutarHref == 1) {
			window.location.href = _WEBJNLP;
		}
	}
}

function wsEventoCaptura() {
	
	try {
		wSocket = new WebSocket(_WEBSOCKET);
		
		wSocket.onopen = function(openEvent) {
			valoresSend();
		};
		
		wSocket.onclose = function (closeEvent) {
			if(socket == 0) {
				setTimeout(wsEventoCaptura, timeWsV);
			} 
		};
		
		wSocket.onerror = function (errorEvent) {
			console.log("WebSocket ERROR: " + errorEvent);
		};
		
		wSocket.onmessage = function (messageEvent) {
			socket = 1 ;
			respuestaDatos = messageEvent.data;
			console.log("Respuesta: " + respuestaDatos);
			if(respuestaDatos.includes("Pending") || respuestaDatos.includes("SHuellas") || (!respuestaDatos.includes("respuesta") && !respuestaDatos.includes('"resultado":"1"'))) {
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
						proceso = "98";
						setTimeout(wsEventoCoppel, timeWsV);
					} else if(data.flujo == 10) {
						proceso = procesoInicial;
						$("#btnHuella").removeAttr("disabled");
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
			setTimeout(wsEventoCaptura, 1000);
		} 
	}
}

function valoresSend() {
	$.ajax({
		method      : "GET",
		url         : urlDato,
		contentType : "application/json",
		data		: { "tipo"		: tipo,
						"proceso"	: proceso }
	})
	.success(function(result) {
		if(result.flujo == 1) {
			var jsonSocket;
			if(result.mensaje != null) {
				jsonSocket = result.mensaje;
			} else {
				jsonSocket = JSON.stringify(result.respuesta);
			}
			
			console.log("Peticion: " + jsonSocket);
			wSocket.send(jsonSocket);
		} else {
			document.getElementById('tituloError').innerHTML = result.titulo;
			document.getElementById('mensajeErrorModal').innerHTML = result.mensaje;
			window.location.href = "#errorModal";
		}
	});
}

function ejecucionJavaLauncher() {
	dtjava.launch(new dtjava.App(_WEBJNLP));
	ejecutarHref = 2;
	return false;
}