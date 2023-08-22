actionWs='validarTrabajadorModificacion.do';
timeWsV = 5000;
var activarSubmit = 1;
var urlDato = "validarDato.do";
servicio = "3";
var intentoBiom;
var timeBiom = 10000;
var huellasTrabajador = 1;
var ejecutarHref = 1;

$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		huellasTrabajador = 2;
		window.location.href = "#infoModal";
		$("#btnInfoM").css("display", "none");
		$("#botonesInfoModal").css("display", "block");
	} else if(_FLUJO == "2") {
		huellasTrabajador = 2;
		$("#btnErrorM").attr('href', "continuarFlujoModificacion.do");
		window.location.href = "#errorModal";
	} else if(_FLUJO == 3) {
		huellasTrabajador = 2;
		actionWs='validaTrabajadorMod.do';
		window.location.href = "#infoModal";
		$("#btnInfoM").css("display", "block");
		$("#botonesInfoModal").css("display", "none");
	} else if(_FLUJO == "98") {
		huellasTrabajador = 2;
		window.location.href = "#infoModal";
		$("#btnInfoM").css("display", "none");
		$("#btnInfoModals").css("display", "block");
	} else if(_FLUJO == "4") {
		huellasTrabajador = 2;
		actionWs='validaTrabajadorMod.do';
		timeWsV = 5000;
		tipo = 3;
		proceso = "3";
		procesoInicial = "3";
		window.location.href = "#infoModal";
		$("#btnInfoM").css("display", "block");
		$("#botonesInfoModal").css("display", "none");
	} else if(_BIOMINT == 0) {
		huellasTrabajador = 2;
		intentoBiom = _BIOMINT;
		setTimeout(validarBiomConformado, timeBiom);
		window.location.href = "#modalLoader";
	}
	
	$form = $('#fm_validaHuellas');
	$('#btnHuella').click(function(event) {
		$("#btnHuella").attr('disabled','disabled');
		event.preventDefault();
		setTimeout(wsEventoCaptura, timeWsV);
		window.location.href = "#modalLoaderX";
		if(_WEBAFORE != "568") {
			if(ejecutarHref == 1) {
				window.location.href = _WEBJNLP;
			}
		} else {
			if(tipo == 2) {
				tipo = 1;
			}
		}
	});
	
	$('#btnInfoModal').click(function(event) {
		if(activarSubmit == 1) {
			event.preventDefault();
			setTimeout(validarBiometrico, timeWsR);
			window.location.href = "#modalLoader";
		} else {
			window.location.href = _PAG;
		}
	});
	
	$('#btnLoaderX').click(function(event) {
		window.location.href = "validarTrabajadorModificacion.do";
	});
	
	$('#btnRegresar').click(function(event) {
		window.location.href = "continuarFlujoModificacion.do";
	});
	
	$('#btnContinuarConsulta').click(function(event) {
		event.preventDefault();
		window.location.href = "validarTrabajadorModificacion.do";
	});
	
	$('#btnInfoBiom').click(function(event) {
		event.preventDefault();
		if(activarSubmit == 1) {
			setTimeout(validarHuellasCapturadas, timeWsR);
			window.location.href = "#modalLoader";
			$("#btnInfoModals").css("display", "none");
		} else {
			window.location.href = _PAG;
		}
	});
});

function validarBiometrico() {
	$.ajax({
		method      : "GET",
		url         : "respuestaWS.do",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			$("#btnExitoM").attr('href', _PAG);
			document.getElementById('tituloExito').innerHTML = data.titulo;
			document.getElementById('mensajeExito').innerHTML = data.mensaje;
			window.location.href = "#exitoModal";
		} else if(data.flujo == 2) {
			$("#btnErrorM").attr('href', _PAG);
			document.getElementById('tituloError').innerHTML = data.titulo;
			document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
			window.location.href = "#errorModal";
		} else if(data.flujo == 3) {
			setTimeout(validarBiometrico, timeWsR);
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

function validarBiomConformado() {
	$.ajax({
		method      : "GET",
		url         : "biomConformado.do",
		contentType : "application/json",
		data		: { intento : intentoBiom }
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			$('#fm_validaHuellas').attr('action', actionWs);
			$('#fm_validaHuellas').submit();
		} else if(data.flujo == 2) {
			$("#btnErrorM").attr('href', _PAG);
			document.getElementById('tituloError').innerHTML = data.titulo;
			document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
			window.location.href = "#errorModal";
		} else if(data.flujo == 3) {
			intentoBiom = data.respuesta;
			setTimeout(validarBiomConformado, timeBiom);
		} else if(data.flujo == 4) {
			$('#fm_validaHuellas').attr('action', "continuarFlujoModificacion.do");
			$('#fm_validaHuellas').submit();
		} 
	});
}