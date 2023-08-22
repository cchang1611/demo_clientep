$(document).ready(function() {
	window.location.href = "#carruselDocumentosModal";
//	$("#btnRedigitalizar").click(function(event) {
//	    var solicitanteFiltrado;
//	    if("10" == SOLICITANTE){
//	           solicitanteFiltrado = SOLICITANTE
//	    }else{
//	           solicitanteFiltrado = SOLICITANTE.substr(1);
//	    }
//	    iniciarTablet(FOLIOPADRE,SERVICIO,NSS,CURP,solicitanteFiltrado,'N');
//	    consultaIntervaloImagenes();
//
//	});
	
	$("#btnModalConfirmacionAceptar").click(function(event) {
		$("#btnModalConfirmacionAceptar").attr("disabled","disabled");
		window.location.href = "#modalLoader";
		terminarProceso();
	});
	
	$("#btnModalConfirmacionCancelar").click(function(event) {
		$("#btnModalConfirmacionCancelar").attr("disabled","disabled");
		window.location.href = "#carruselDocumentosModal";

	});

	
/*	$("#btnContinuarArch").click(function(event) {
		console.log('Respuesta Aceptada Visor Doc');
		var formularioRecep = $("#frmRecepImg");
		//formularioRecep.attr("action",callBackUrl);
		formularioRecep.attr("method","POST");
		formularioRecep.submit();

	});*/
});

/**
 * Accion al presionar boton aceptar del visor de doc
 * @param n
 * @returns
 */
/*function respuestaAceptadaVisorDoc(urlPaginaSiguiente) {
	console.log('Respuesta Aceptada Visor Doc');
//	var formularioRecep = document.getElementById("frmRecepImg");
//	formularioRecep.action=urlPaginaSiguiente;
//	formularioRecep.method="GET";
//	formularioRecep.submit();
	var formularioRecep = $("#frmRecepImg");
	formularioRecep.attr("action",urlPaginaSiguiente);
	formularioRecep.attr("method","POST");
	formularioRecep.submit();



	
	var data = JSON.stringify(listaImagenesRedirec);
	$.ajax({
		url : callBackUrl,
		method : 'POST',
		contentType : 'application/json',
		dataType : 'json',
		data : data,//Prototype de carrusel_visor.js
		success : function(entrada) {
			alert("Documentos cargados");
		}
	});
}*/

/**
 * Accion al presionar boton canelar del visor de doc
 * @param n
 * @returns
 */
function respuestaCancelarVisorDoc() {
	$("#btnModalConfirmacionAceptar").removeAttr("disabled");
	$("#btnModalConfirmacionCancelar").removeAttr("disabled");

	console.log('Respuesta Cancelar Visor Doc');
	window.location.href = "#";
	var tituloModal = "<h2 class='ModalTitle' >Confirmacion</h2>";
	var mensajeModal = "¿Realmente desea cancelar?";
	$('#tituloConfirmacion').empty();
	$('#mensajeconfirmacion').empty();
	$('#tituloConfirmacion').append(tituloModal);
	$('#mensajeconfirmacion').append(mensajeModal);
	window.location.href = "#modalConfirmacion";
//	$("#btnRedigitalizar").show();
//	cancelarVisor();
	//$("btnContinuarArch").hide();
}


function terminarProceso(){
	$.ajax({
		url : 'terminarFolio.do',
		type : "GET",
		contentType : 'application/json',
		dataType: 'json',
		data : {
			idFolio : IDFOLIO_HIJO,
			estatus : "2"
		}
	}).success(function(resultado) {
		$(location).attr('href', 'datosGenerales.do');
	})
}

/**
 * Ejecutar funcion cada 30seg
 * @returns
 */
function consultaIntervaloImagenes() {
	var intervalo = setInterval(function() {
		cosultaRecepcionImagenes(intervalo);
	}, 30000)
}

/**
 * Ajax Get consultarRecepcionImagenes
 * @param intervalo
 * @returns
 */
function cosultaRecepcionImagenes(intervalo) {
	$.get('consultarRecepcionImagenes.do', function(recepcion) {
		if (recepcion != null) {
			alert("intervalo detenido");
			clearInterval(intervalo);
			callBackRecuperar(recepcion);
		}
	});
}

/**
 * Funcion en el success del Ajax ConsultarRecepcionImagenes
 * @param recepcion
 * @returns
 */
function callBackRecuperar(recepcion){
	console.log('Recuperar informacion');
}
