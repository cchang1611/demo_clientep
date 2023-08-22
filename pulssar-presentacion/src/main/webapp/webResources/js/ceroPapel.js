$(document).ready(function() {
	if(valuePaperless != null && valuePaperless == 'ACTIVO'){
		deshabilitarActivo();
	}else{
		deshabilitarCancelar();
	}
});

function consultarEstatusCeroPapel() {
	$.ajax({
		method      : "GET",
		url         : "consultaEstatusCeroPapel.do",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			document.getElementById('tituloExito').innerHTML = data.titulo;
			document.getElementById('mensajeExito').innerHTML = data.mensaje;
			window.location.href = "#exitoModal";
		}	
	});
}	
	
function activarEstatusCeroPapel() {
	$.ajax({
		method      : "GET",
		url         : "activarEstatusCeroPapel.do",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			document.getElementById('tituloPaperless').innerHTML = data.titulo;
			document.getElementById('mensajePaperless').innerHTML = data.mensaje;
			window.location.href = "#modalConfirmacionPaperless";
		}	
		
	});
}

function cancelarEstatusCeroPapel() {
	$.ajax({
		method      : "GET",
		url         : "cancelarEstatusCeroPapel.do",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			document.getElementById('tituloCancelarPaperless').innerHTML = data.titulo;
			document.getElementById('mensajeCancelarPaperless').innerHTML = data.mensaje;
			window.location.href = "#modalCancelarPaperless";
		}
	});
}

function mostrarCorreoCeroPapel() {
	$.ajax({
		method      : "GET",
		url         : "mostrarCorreoCeroPapel.do",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			
			if(data.datos == 'noCorreo'){
				document.getElementById('tituloNoCorreoPaperless').innerHTML = data.titulo;
				document.getElementById('mensajeNoCorreoPaperless').innerHTML = data.mensaje;
				window.location.href = "#modalNoCorreoPaperless";
				
			}else{
				document.getElementById('tituloCorreoPaperless').innerHTML = data.titulo;
				document.getElementById('mensajeCorreoPaperless').innerHTML = data.mensaje;
				document.getElementById('correoPaperless').innerHTML = data.datos;
				window.location.href = "#modalCorreoElectronico";
				
			}
		
			
		}	
		
	});
}
	
function guardarEstatusActivoCeroPapel() {
	$.ajax({
		method      : "GET",
		url         : "guardarActivoEstatusCeroPapel.do",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log(data.flujo);
		$("#estatusPaperless").empty();
		$("#estatusPaperless").html("Estatus: <strong style='color:greenyellow;'>ACTIVO</strong>");
		deshabilitarActivo();
		habilitarCancelar();
	});
}
	
function guardarEstatusCancelarCeroPapel() {
	$.ajax({
		method      : "GET",
		url         : "guardarCanceladoEstatusCeroPapel.do",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log(data.flujo);
		$("#estatusPaperless").empty();
		$("#estatusPaperless").html("Estatus: <strong style='color:red;'>INACTIVO</strong>");
		deshabilitarCancelar();
		habilitarActivo();
	});
}




function deshabilitarActivo()
{
		$("#activarEstatusCeroPapel").removeAttr('onclick');
		$("#activarEstatusCeroPapel").addClass('disabled_Url');
}


function deshabilitarCancelar()
{
		$("#cancelarEstatusCeroPapel").removeAttr('onclick');
		$("#cancelarEstatusCeroPapel").addClass('disabled_Url');
}


function habilitarActivo()
{
		$("#activarEstatusCeroPapel").attr('onclick', 'activarEstatusCeroPapel()');
		$("#activarEstatusCeroPapel").removeClass('disabled_Url');
}


function habilitarCancelar()
{
		$("#cancelarEstatusCeroPapel").attr('onclick', 'cancelarEstatusCeroPapel()');
		$("#cancelarEstatusCeroPapel").removeClass('disabled_Url');
}
	