var actionWs ='validarEmpleado.do';
var timeWsV = 5000;
var timeWsR = 10000;
var activarSubmit = 1;
var urlDato = "validarDato.do";

$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	$form = $('#fm_validaEmpleado');
	if(_FLUJO == "1") {
		window.location.href = "#infoModal";
		$("#btnInfoM").css("display", "none");
		$("#botonesInfoModal").css("display", "block");
	} else if(_FLUJO == "2") {
		$("#btnErrorM").attr('href', "consultaTrabajador.do");
		window.location.href = "#errorModal";
	}  else if(_FLUJO == "3") {
		window.location.href = "#infoModal";
		$("#btnInfoM").css("display", "block");
		$("#botonesInfoModal").css("display", "none");
	}
	
	// Boton iniciar proceso
	$('#btnHuella').click(function(event) {
		$("#btnHuella").attr('disabled','disabled');
		event.preventDefault();
		eventoCaptura();
	});
	
	$('#btnInfoModal').click(function(event) {
		if(activarSubmit == 1) {
			event.preventDefault();
			setTimeout(validarRespuesta, timeWsR);
			window.location.href = "#modalLoader";
		} else {
			window.location.href = "consultaTrabajador.do";
		}
	});
	$('#btnLoaderX').click(function(event) {
		window.location.href = "verificarEmpleado.do";
	});
});

function validarRespuesta() {
	$.ajax({
		method      : "GET",
		url         : "respuestaWS.do",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			$("#btnExitoM").attr('href', "consultaTrabajador.do");
			document.getElementById('tituloExito').innerHTML = data.titulo;
			document.getElementById('mensajeExito').innerHTML = data.mensaje;
			window.location.href = "#exitoModal";
		} else if(data.flujo == 2) {
			$("#btnErrorM").attr('href', "verificarEmpleado.do");
			document.getElementById('tituloError').innerHTML = data.titulo;
			document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
			window.location.href = "#errorModal";
		} else if(data.flujo == 3) {
			setTimeout(validarRespuesta, timeWsR);
		} else if(data.flujo == 4) {
			activarSubmit = 2;
			$("#botonesInfoModal").css("display", "block");
			$("#btnInfoM").css('display', "none");
			document.getElementById('tituloInfo').innerHTML = data.titulo;
			document.getElementById('mensajeInfo').innerHTML = data.mensaje;
			window.location.href = "#infoModal";
		} 
	});
}
