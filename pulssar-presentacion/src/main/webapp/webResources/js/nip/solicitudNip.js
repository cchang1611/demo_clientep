$(document).ready(function() {
				
	$('#btnErrorM').click(function(event) {
		console.log("[btnErrorM] - A la vista genetral de consulta");
		window.location.href = "datosGenerales.do";
	});
	
//	$('#errorModal').on('hidden.bs.modal', function(event) {
//		console.log("[btnExitoM] - A la vista genetral de consulta");
//		window.location.href = "datosGenerales.do";
//	});
		
	
	$('#btnExitoM').click(function(event) {
		console.log("[btnExitoM] - A la vista genetral de consulta");
		window.location.href = "datosGenerales.do";
	});
});

function solicitarNipSubmit() {
	
	falsaModalEspera();
	console.log("solicitarNipSubmit");
	var curpNueva = $.trim(document.getElementById("curp").innerHTML);
	var nombreNuevo = $.trim(document.getElementById("nombre").innerHTML);
	var apellidoPaternoNuevo = $.trim(document.getElementById("apellidoPaterno").innerHTML);
	var apellidoMaternoNuevo = $.trim(document.getElementById("apellidoMaterno").innerHTML);
	var nssNueva = $.trim(document.getElementById("nss").innerHTML);
	var numeroCelularNuevo = $.trim(document.getElementById("numeroCelular").innerHTML);
	var correoNuevo = $.trim(document.getElementById("correo").innerHTML);
	var data = JSON.stringify({
		'nss':nssNueva,
		'curp':curpNueva,
		'nombre':nombreNuevo, 
		'apPaterno':apellidoPaternoNuevo, 
		'apMaterno':apellidoMaternoNuevo,
		'correo' : correoNuevo,
		'numeroCelular' : numeroCelularNuevo
		});

	console.log("Enviando Submit solicitudNip...");
//		$("#solicitudNip").submit();
	enviaSolicitud(data);

}

function falsaModalEspera() {
	console.log("Se solicita ventana modal a manera de espera");

//	window.location.href = "#modalLoader";
	window.location.href = "#modalLoaderX";
	
}

// Envia solicitud de generacion de NIP
// Espera 20 seg por la respuesta o envía mensaje de alerta al usuario
function enviaSolicitud(entrada){
	console.log("enviaSolicitud: " + entrada);
	$.ajax({
		url : 'generarNip',
		type : "POST",
		contentType : 'application/json',
		dataType: 'json',
		data : entrada,
		async : true,
		timeout : 25000,
		beforeSend : function() {
			window.location.href = "#modalLoaderX";
		}
	}).success(function(resultado) {
		presentarRespuestaDeSolicitudDeNIP(resultado);
	}).fail(function(jqXHR, textStatus) {
		console.log("Error: -> " + textStatus);
		window.location.href = "#";
		if(textStatus === 'timeout') {
			var tituloModal = "";
			$('#tituloError').empty();
			$('#mensajeErrorModal').empty();
			$('#tituloError').text(tituloModal);
			$('#mensajeErrorModal').text("No es posible generar la solicitud. Intentarlo más tarde");
			window.location.href = "#errorModal";
		}
	});
}

// Funcion procesa resultados de la solicitud enviada.
function presentarRespuestaDeSolicitudDeNIP(resultado){

	console.log("Flujo -> " + resultado.flujo);
    console.log("Mensaje -> " + resultado.mensaje);
	if (resultado.flujo === 1) { 	// Mensaje de exito
		presentarMensajeExito();
	} else {						// Mensaje de error
		presentarMensajeError(resultado.mensaje);
	}
}

//Funcion presentar mensaje de error para generacion de nip
function presentarMensajeError(mensajeModal){
	var tituloModal = "";
	$('#tituloError').empty();
	$('#mensajeErrorModal').empty();
	$('#tituloError').text(tituloModal);
	$('#mensajeErrorModal').text(mensajeModal);
	window.location.href = "#errorModal";
}

// Funcion presentar mensaje de exito para generacion de nip
function presentarMensajeExito(){
	var tituloModal = "SOLICITUD FINALIZADA CORRECTAMENTE";
	var mensajeModal = "La solicitud de generación del NIP se concluyó con éxito";
	$('#tituloExito').empty();
	$('#mensajeExito').empty();
	$('#tituloExito').text(tituloModal);
	$('#mensajeExito').text(mensajeModal);
	window.location.href = "#exitoModal";
}

function autorizarGeneracionNip(){
	console.log("autorizarGeneracionNip")
	if($('#checkGeneraNip').prop('checked') == false) {
		$('#botonEnviar').prop('disabled', true);
		$('#botonEnviar').removeClass('SubmitBlue');
		$('#botonEnviar').addClass('Submit_disabled');
	} else {
		$('#botonEnviar').prop('disabled', false);
		$('#botonEnviar').removeClass('Submit_disabled');
		$('#botonEnviar').addClass('SubmitBlue');
	}
}

function cerrarNipSubmit() {
	console.log("[cerrarNipSubmit] - A la vista genetral de consulta");
	window.location.href = "datosGenerales.do";
}