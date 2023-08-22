numeroIntentos = 0;
$(document).ready(function() {
	ejecutarValidasionIlegal();
	$("#frameVistaPreviaPdf").hide();
	$("#contenedorConfirmarAdjuntado").hide();
	
	$("#botonAdjuntar").click(function(event) {
		action = context+"/private/enviarArchivos";
		console.log(action);
		form = $("#frmAdjuntar")[0];
		data = new FormData(form);
		
		$.ajax({
			method      : "POST",
			url         : action,
			enctype		: "multipart/form-data",
			processData	: false,
			contentType	: false,
			data		: data
		})
		.success(function(data) {
			console.log(data);
			if(data.error){
				$("#mensajeErrorModal").text(data.error);
				window.location.href="#errorModal";
			}else{
				consultaIntervaloImagenes(data.destino);
//				$(location).attr('href', context+data.destino);
			}
		})
		.error(function(data) {
			console.log(data);
		});
	});
});


function overrideDefault(event) {
	  event.preventDefault();
	  event.stopPropagation();
	}

var reader = new FileReader();

function cambiaNombre(event, clave, input){
	var archivo = $('#input'+clave).val().replace(/.*(\/|\\)/, '');
	console.log(archivo);
	console.log($('#fileLabelText'+clave).text());
	console.log($('#hid'+clave).val());
	console.log('input'+input.id);

	var file = $('#'+input.id).prop('files')[0];
	console.log('actual '+file.name);
	console.log('anterior'+$('#fileLabelText'+clave).text());
	
	
	borrarImagenVisor($('#fileLabelText'+clave).text());
	console.log('......borra archivo anterior');
	
	var reader = new FileReader();
	
	reader.onload = function(){
		var base64 = reader.result;
		base64 = base64.split("base64,")[1];
		agregarImagenVisor(base64, file.name);
	}
	
	var hola = reader.readAsDataURL(file);
	console.log(hola);
	$("#carruselDocumentosModal").show();
	window.location.href="#carruselDocumentosModal";
	
	if(archivo == ''){
		hidText = $('#hid'+clave).val();
		$('#fileLabelText'+clave).text(hidText);
	}else{
		$('#fileLabelText'+clave).text(archivo);
	}
}
function consultaIntervaloImagenes(destino){
	var intervalo =	setInterval(function(){
		cosultaRecepcionImagenes(intervalo, destino);
		},30000)
		window.location.href = "#modalLoader";
}
function cosultaRecepcionImagenes(intervalo, destino){
	console.log("entra al proceso de validacion de resultado de generacion de expediente");
	numeroIntentos++;
	console.log(numeroIntentos);
	$.ajax({
		url : 'consultarResultadoRecepcion.do',
		type : "GET",
		contentType : 'application/json',

		data : {
			folio : $('#foliohijo').val()
		}
	}).success(function(resultadoOperacion) {
	console.log("Respuesta: "+ resultadoOperacion + " intento: "+ numeroIntentos);
		if(resultadoOperacion.resultadoOperacion != "02"){
				console.log("enviando submit");
				window.location.href = "#";
				console.log("enviando submit2");
				clearInterval(intervalo);
				console.log("enviando submit3");
				$(location).attr('href', context+destino);
//				$("#imagenesDoctos").submit();
		}else if(numeroIntentos == Number(3)){
				console.log("numero intentos agotado, muestra modal");
				clearInterval(intervalo);
//				$("#imagenesDoctos").submit();
				$(location).attr('href', context+destino);
		}
	})
}

function ejecutarValidasionIlegal(){
	$.ajax({
		method      : "GET",
		url         : "ejecutarValidacionProceso.do?origenValidacion=4&intentoValidacion=1",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log("Entrando validacion");
		if(data.respuesta != '1'){
			console.log("Validacion 2");
			window.location.href = "#";
			$("#mensajeErrorModal").text(data.respuesta);
			$("#btnErrorM").attr('href', "datosGenerales.do");
			window.location.href = "#errorModal";
		}
	})
}
	
