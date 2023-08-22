var imgWidth;
var imgHeight;
var cierreFlujo = 1;
var urlDato = "obtenerDato.do";
actionWs = _FUN;
timeWsV = 5000;
var infoBtn = 1;
servicio = "1";
var timeFirma = 20000;
var intentos = 10;
var numeroIntentos = 0;
var ejecutarHref = 1;
var rechazo = "H009";

$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	$form = $('#fm_Biometrico');
	if(_FLUJO == "1") {
		window.location.href = "#infoModal";
		$("#btnInfoM").css("display", "none");
		$("#botonesInfoModal").css("display", "block");
	} else if(_FLUJO == "2") {
		$("#btnErrorM").attr('href', _PAG);
		window.location.href = "#errorModal";
	} else if(_FLUJO == "98") {
		window.location.href = "#infoModal";
		$("#btnInfoM").css("display", "none");
		$("#btnInfoModals").css("display", "block");
	} else if(_FLUJO == "10") {
		$("#btnInfoM").attr('href', _PAG);
		window.location.href = "#infoModal";
	}
	
	if(_DATOS != null && _DATOS != "") {
		compatibilidadPdf(_DATOS);
	}
	
	$("#btnTrabajador").click(function(event) {
		event.preventDefault();
		$("#btnTrabajador").attr('disabled','disabled');
		obtenerFirmas(1);
	});
	
	$("#btnAgente").click(function(event) {
		event.preventDefault();
		$("#btnAgente").attr('disabled','disabled');
		obtenerFirmas(2);
	});
	
	$("#btnContinuar").click(function(event) {
		event.preventDefault();
		$("#btnContinuar").attr('disabled','disabled');
		var claveExcepcion = $('#claveExcep').val();
		if(claveExcepcion != '0') {
			$form.submit();
		} else {
			$("#btnContinuar").removeAttr("disabled");
		}
	});
	
	$('#btnCapHuellas').click(function(event) {
		event.preventDefault();
		$("#btnCapHuellas").attr('disabled','disabled');
		setTimeout(wsEventoCaptura, timeWsV);
		window.location.href = "#modalLoaderX";
		tipo = 3;
		if(_WEBAFORE != "568") {
			if(ejecutarHref == 1) {
				window.location.href = _WEBJNLP;
			}
		} else {
			proceso="3";
			procesoInicial = "3";
		}
	});
	
	$('#btnInfoBiom').click(function(event) {
		event.preventDefault();
		$("#btnInfoBiom").attr('disabled','disabled');
		if(infoBtn == 1) {
			setTimeout(validarHuellasCapturadas, timeWsR);
			window.location.href = "#modalLoader";
			$("#btnInfoModals").css("display", "none");
		} else {
			window.location.href = _PAG;
		}
	});
	
	$('#btnInfoModal').click(function(event) {
		event.preventDefault();
		if(infoBtn == 1) {
			setTimeout(validarBiometrico, timeFirma);
			window.location.href = "#modalLoader";
		} else {
			window.location.href = _PAG;
		}
	});
	
	$("#btnModalActExpContinuar").click(function(event){
		event.preventDefault();
		numeroIntentos = 0;
		obtenerFirmas(1);
	});
	
	$("#btnModalActExpCancelar").click(function(event){
		event.preventDefault();
		window.location.href = "#";
	});
	
	$("#btnFinaliza").click(function(event) {
		event.preventDefault();
		$form.attr('action', 'finalizaEnrolamiento.do');
		$form.submit();
	});
});

var folioServicio;
var claveServicio;
function obtenerFirmas(flujoFirma) {
	if(_WEBAFORE != "530") {
		SignInicio(flujoFirma);
	} else {
		$.ajax({
			method      : "GET",
			url         : "datosTablet.do",
			contentType : "application/json",
		})
		.success(function(data) {
			tipo = 3;
			window.location.href = "#modalLoaderX";
			setTimeout(validarImagenesBanorte, timeWsR);
			folioServicio = data.folioPadre;
			claveServicio = data.claveServicio;
			console.log("inicia llamado de tableta");
			iniciarTablet(data.folioPadre
					,data.claveServicio,
					data.nss,
					data.curp,
					data.tipoParentesco,
					data.tramitePresencial);
		});
	}
}

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
			infoBtn = 2;
			$("#botonesInfoModal").css("display", "block");
			$("#btnInfoM").css('display', "none");
			document.getElementById('tituloInfo').innerHTML = data.titulo;
			document.getElementById('mensajeInfo').innerHTML = data.mensaje;
			window.location.href = "#infoModal";
		} 
	});
}

function validarImagenesBanorte() {
	numeroIntentos++;
	$.ajax({
		url : 'consultarRecepcionImagenes.do',
		type : "GET",
		contentType : 'application/json',
		dataType: 'json',
		data : {
			folioPadre : folioServicio,
			cvProceso : claveServicio,
			estatus : "1"
		}
	}).success(function(recepcion) {
		if(recepcion != null){
			recuperarFirmas(recepcion);
		}else{
			if(numeroIntentos == intentos){
				window.location.href = "#";
				var tituloModal = "<h2 class='ModalTitle' >Solicitud</h2>";
				var mensajeModal = "Aun no se han encontrado archivos ¿Desea continuar con el tramite?";
				$('#tituloActExp').empty();
				$('#mensajeActExp').empty();
				$('#tituloActExp').append(tituloModal);
				$('#mensajeActExp').append(mensajeModal);
				$('#botonesModalActExp').show();
				window.location.href = "#modalActExp";
			} else {
				setTimeout(validarImagenesBanorte, timeWsR);
			}
		}
	})
}

function recuperarFirmas(recepcion){
	console.log("Inicia proceso de recuperacion de firma");
	console.log(recepcion);
	var data = JSON.stringify(recepcion);
	window.location.href = "#modalLoader";
	$.ajax({
		url : 'recuperaAcuseFirmado.do',
		type : "POST",
		contentType : 'application/json',
		dataType: 'json',
		data : data
	}).success(function(respuesta) {
		if(respuesta != null){
			if(respuesta.mensaje != null){
				var tituloModal = "<h2 class='ModalTitle' >Solicitud</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
				var mensajeModal = "Ha ocurrido un problema al recibir datos de la solicitud";
				$('#tituloActExp').empty();
				$('#mensajeActExp').empty();
				$('#tituloActExp').append(tituloModal);
				$('#mensajeActExp').append(mensajeModal);
				window.location.href = "#modalActExp";
			}else{
				numeroArchivos = respuesta.numeroArchivos;
				var firmaTrabajador = respuesta.firmaTrabajador;
				console.log(firmaTrabajador);
				firmaTrabajadorDocumento(firmaTrabajador);
				valoresBanorte();
			}
		}
	});
}

function redireccionModal(){
	window.location.href = "datosGenerales.do";
}

function firmaTrabajadorDocumento(imagenbase64) {
	$.ajax({
		method      : "POST",
		url         : "firmaCapturada.do",
		contentType : "application/json",
		data		: JSON.stringify({response : imagenbase64})
	})
	.success(function(data) {
		$("#btnTrabajador").removeAttr("disabled");
		if(data.flujo == 1) {
			compatibilidadPdf(data.mensaje);
			$("#btnTrabajador").attr("style", "display:none");
			if ($("#btnCapHuellas").length > 0 ) {
				$("#btnCapHuellas").removeAttr("style");
			}
			if ($("#MyActiveEnrolador").length > 0 ) {
				$("#MyActiveEnrolador").removeAttr("style");
			}
			$form.attr('action', 'huellas.do');
			window.location.href = "#";
			$.ajax({
				url : 'catalogoMensajes.do',
				type : "GET",
				contentType : 'application/json',
				dataType: 'json',
				data : {codigo : rechazo}
			}).success(function(data) {
				if(data.flujo == 1) {
					document.getElementById('tituloInfo').innerHTML = data.titulo;
					document.getElementById('mensajeInfo').innerHTML = data.mensaje;
					window.location.href = "#infoModal";
					$("#btnInfoM").css("display", "block");
					$("#botonesInfoModal").css("display", "none");
				}
			});
		} else if(data.flujo == 2) {
			document.getElementById('tituloError').innerHTML = data.titulo;
			document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
			window.location.href = "#errorModal";
		}
	});
}