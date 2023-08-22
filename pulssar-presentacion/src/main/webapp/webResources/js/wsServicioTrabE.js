var wSocket;
var socket = 0;
var $form;
var timeWsV;
var actionWs;
var timeWsR = 10000;
var tipo = 2;
var proceso = "4";
var servicio;
var procesoInicial = "4";

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
			var respuestaDatos = messageEvent.data; 
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
				$("#idBiometrico").val(messageEvent.data);
				$form.attr("action", actionWs);
				$form.submit();
			}
		};
	} catch (exception) {
		console.error(exception);
		if(socket == 0) {
			setTimeout(wsEventoCaptura, timeWsV);
		} 
	}
}

function valoresSend() {
	$.ajax({
		method      : "GET",
		url         : urlDato,
		contentType : "application/json",
		data		: { "tipo"		: tipo ,
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

function validarHuellasCapturadas() {
	$.ajax({
		method      : "GET",
		url         : "validarHuellasRespuesta.do",
		contentType : "application/json",
		data		: { servicio	: servicio }
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			setTimeout(validarBiometrico, timeWsR);
		} else if(data.flujo == 2) {
			if(data.datos != null) {
				_PAG = data.datos;
			}
			$("#btnErrorM").attr('href', _PAG);
			document.getElementById('tituloError').innerHTML = data.titulo;
			document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
			window.location.href = "#errorModal";
		} else if(data.flujo == 3) {
			setTimeout(validarHuellasCapturadas, timeWsR);
		}
	});
}

function ejecucionJavaLauncher() {
	dtjava.launch(new dtjava.App(_WEBJNLP));
	ejecutarHref = 2;
	return false;
}