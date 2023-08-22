var formularion = null;
var valorSign;
//var idFirmaMostrar = 0;
var idFirmasCapturar = [];
var FIRMA_TRABAJADOR = 1;
var FIRMA_ASESOR = 2;
var etiquetasBoton = [];
var signValue = 0;
var PAGOBANCOENVIO;
//function agregarIdFirma(idFirma){
//	idFirmasCapturar.push(idFirma);
//}

//function obtenerIdFirmaCapturar(){
//	if(idFirmasCapturar.length>0){
//		idFirmaMostrar = idFirmasCapturar.shift();
//	}else{
//		idFirmaMostrar = -1;
//	}
//	
//	return idFirmaMostrar;
//}
$(document).ready(function() {
	validaFirmas();
});

function isNotEmpty(str) {
    return str !== null && str !== undefined && str.trim().length > 0;
}

function validaFirmas(){
    etiquetaBoton1 = "";
    if(!isNotEmpty($("#idFirmaEmpleado").val())){
        etiquetaBoton1="Firma Trabajador";
        signValue = FIRMA_TRABAJADOR;
        $("#fm_recepcionImagen").hide();
    }else if(!isNotEmpty($("#idFirmaAgente").val())){
        etiquetaBoton1="Firma Agente";
        signValue = FIRMA_ASESOR;
        $("#fm_recepcionImagen").hide();
    }else{
        signValue = 3;
        etiquetaBoton1="Digitalizar";
        $("#frmPdf").hide();
        $("#fm_recepcionImagen").show();
    }
    $("#btnContinuar").hide();
    $("#frmAdjuntar").hide(); 
    $("#carruselDocumentosModal").hide();
    $("#btnFirma").html(etiquetaBoton1);
}
$("#btnFirma").click(function(){
	console.log("btnFirma click - ini ");
    SignInicio(signValue);
	console.log("btnFirma click - fin ");    		
});
$("#btnRecepcionImgCop").click(function(){
	console.log("solicitanteFiltrado"+SOLICITANTE);    		
	var solicitanteFiltrado;
	if("10" == SOLICITANTE){
		solicitanteFiltrado = SOLICITANTE
	}else{
		solicitanteFiltrado = SOLICITANTE.substr(1);
	}
	
	if(NSS == "" || NSS == null){
		NSS = "0";
	}
	if(PAGOBANCO == "02"){
		PAGOBANCOENVIO = 1;
	} else {
		PAGOBANCOENVIO = 0;
	}
	var digita = {			
		folioProcesar : FOLIOPADRE,
		proceso : SERVICIO,
		curpTitular:CURP,
		nssTitular:NSS,
		curpSolicitante:"0",
		tipoSoliciante:solicitanteFiltrado,
		idRFCModificado:"0",
		idSesion:IDSESSION,
		pagoBanco:PAGOBANCOENVIO,
		idRetParcial:"07"

	};
    SignInicioDigita(JSON.stringify(digita));
});

function continuarProceso(){
	console.log("continuar proceso MN");
	numeroIntentos = 0;
	numeroArchivos = 0;
	consultaIntervaloImagenesMN();
}

function consultaIntervaloImagenesMN(){
	console.log("entra al proceso de validacion de recepcion de imagenes MN");
	var intervalo =	setInterval(function(){
		cosultaRecepcionImagenesMN(intervalo);
		},30000)
		window.location.href = "#modalLoader";
}

function cosultaRecepcionImagenesMN(intervalo){
	console.log("entra al proceso de validacion de recepcion de imagenes ");
	numeroIntentos++;
	console.log(numeroIntentos);
	$.ajax({
		url : 'consultarRecepcionImagenes.do',
		type : "GET",
		contentType : 'application/json',

		data : {
			folioPadre : FOLIOPADRE,
			cvProceso : SERVICIO,
			estatus : "1"
		}
	}).success(function(recepcion) {
		if(recepcion != null){
			numeroArchivos = Number(recepcion.numeroTotalRecibidos);
			console.log("intervalo detenido, consulta imagenes:"+recepcion.numeroTotalRecibidos);
			console.log("intervalo detenido, consulta imagenes:"+numeroArchivos);
			if(numeroArchivos > 0){
				console.log("enviando submit");
				window.location.href = "#";
				console.log("enviando submit2");
				clearInterval(intervalo);
				console.log("enviando submit3");
				$("#fm_recepcionImagen").submit();
			}else if(numeroIntentos == Number(INTENTOS)){
				console.log("numero intentos agotado, muestra modal");
				clearInterval(intervalo);
				window.location.href = "#";
			}
		}
	})
}

function regresoPad(resultado){
    if(signValue == FIRMA_TRABAJADOR){
    	$("#idFirmaEmpleado").val(resultado);
    	$("#frmPdf").submit();
    } else if(signValue == FIRMA_ASESOR){
    	$("#idFirmaAgente").val(resultado);
    	$("#frmPdf").submit();
    }
    validaFirmas();
}