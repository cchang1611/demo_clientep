var wSocket;
var socket = 0;
var $form;
var timeWs;
var actionWs;
var tipo = 1;

/**
 * Genera la peticion de toma de huella coppel
 * @returns
 */
function  eventoCaptura() {
	$form = $('#fm_validaEmpleado');
	window.location.href = "#modalLoaderX";
	wsEventoCaptura();
}
/**
 * realiza la peticion de toma de huellas al dispositivo biometrico
 * @returns
 */
function wsEventoCaptura() {
	$.ajax({
		method      : "GET",
		url         : "generaPeticionUnaHuellaCoppel.do",
		contentType : "application/json"
	})
	.success(function(data) {
		generaPetcionUnaHuella(data);
	});
}


///**
// * Realiza la peticion a coppel
// * @returns
// */
//function generaPetcionUnaHuella(datos){
//	 console.log("PETICION COPPEL");
//     console.log(JSON.stringify(datos));
//     var jDatosHuella={};
//     var jdatos;
//	
//     try {
// 		wSocket = new WebSocket("wss://127.0.0.1:20043/");
// 		//Abrimos socket y enviamos mensaje
// 		wSocket.onopen = function(openEvent) {
// 			console.log("Enviando solicitud: ");
// 			wSocket.send(JSON.stringify(datos));
// 		};
// 		
// 		//CERRAMOS SOCKET
// 		wSocket.onclose = function (closeEvent) {
// 			console.log("Cerrando socket " + closeEvent);
// 			document.getElementById('tituloError').innerHTML = "ERROR INESPERADO";
// 			document.getElementById('mensajeErrorModal').innerHTML = "ERROR DE CONECCION CON EL DISPOSITIVO";
// 			window.location.href = "#errorModal";
// 		};
// 		
// 		//ERROR EN EL SOCKET
// 		wSocket.onerror = function (errorEvent) {
// 			console.log("WebSocket ERROR: " + errorEvent);
// 		};
// 		
// 		//RECIBE LA RESPUESTA DEL BACKEND
// 		wSocket.onmessage = function (messageEvent) {
// 			var respuestaDatos = messageEvent.data; 			
// 			console.log("RESPUESTA COPPEL");
// 			console.log(JSON.stringify(respuestaDatos));
// 			
// 			//ERROR EN EL SERVICIO
// 			if(respuestaDatos.resultado == "1") {
// 			   jDatosHuella.huellaDactilar = generarpeticion(respuestaDatos);
// 	 		   jdatos = JSON.stringify(jDatosHuella);
// 			 
// 			   $("#idImagen").val(jdatos);
// 			   $form.attr("action", "validarHuellaEmpleado.do");
// 			   $form.submit();
// 		    }else {
// 			   document.getElementById('tituloError').innerHTML = "ERROR";
// 			   document.getElementById('mensajeErrorModal').innerHTML = "ERROR EN LA TOMA DE HUELLA";
// 			   window.location.href = "#errorModal";
// 		    } 	
// 			
// 			
// 		};
// 	} catch (exception) {
// 		console.error(exception);
//		document.getElementById('tituloError').innerHTML = "ERROR INESPERADO";
//		document.getElementById('mensajeErrorModal').innerHTML = "ERROR DE CONECCION DISPOSITIVO";
//		window.location.href = "#errorModal";
// 	}
//	
//}


/**
 * Realiza la peticion a coppel
 * @returns
 */
function generaPetcionUnaHuella(datos){
	 console.log("PETICION COPPEL");
     console.log(JSON.stringify(datos));
     var jDatosHuella={};
     var jdatos;
	
	$.ajax({
		method      : "POST",
		url         : "pruebaServicioAfore.do",
		contentType : "application/json",
		data        : JSON.stringify(datos),
	})
	.success(function(data) {
		console.log("RESPUESTA COPPEL");
		console.log(JSON.stringify(data));
		
		alert('Se recibio respuesta '+data.resultado);
		//ERROR EN EL SERVICIO
		if(data.resultado == "1") {
		   jDatosHuella.huellaDactilar = generarpeticion(data);
 		   jdatos = JSON.stringify(jDatosHuella);
		 
		   $("#idImagen").val(jdatos);
		   $form.attr("action", "validarHuellaEmpleado.do");
		   $form.submit();
	    }else {
		   document.getElementById('tituloError').innerHTML = "ERROR";
		   document.getElementById('mensajeErrorModal').innerHTML = "ERROR EN LA TOMA DE HUELLA";
		   window.location.href = "#errorModal";
	    } 		
	}).error(function (jqXHR, textStatus, errorThrown){
		alert("Se produjo un error inesperado ",errorThrown);
		document.getElementById('tituloError').innerHTML = "ERROR INESPERADO";
		document.getElementById('mensajeErrorModal').innerHTML = "ERROR DE CONECCION DISPOSITIVO";
		window.location.href = "#errorModal";
	});
	
}


/**
 * Genera la petcion para la validacion
 * @param datos
 * @returns
 */
function generarpeticion(datos){
	var huellasDactilares = [];	
	for (var x=0;x<datos.huellasDactilares.length;x++){
		var jDatosHuella = datos.huellasDactilares[x];
		jDatosHuella.idDevice = datos.idDevice;
		jDatosHuella.tipoPersona = datos.tipoPersona;
		jDatosHuella.fechaCaptura = datos.fechaCaptura;
		jDatosHuella.perfilAdquisicionHuella = datos.perfilAdquisicionHuella;
		huellasDactilares.push(jDatosHuella);
	}
	return huellasDactilares;
}

