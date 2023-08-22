var seccionActiva = 0;
var tipoRetiroValidado = false;
var TIPO_RETIRO_DESEMPLEO_A = 1;
var TIPO_RETIRO_DESEMPLEO_B = 2;
var jsonInstiticionesBancarias = "";
var objetoInstitucionesBancarias = {};
var claveInstitucionBancariaInvalida = false;
var formaPagoCheque = false;

function sectionone() {
	validarHabilitaDesha($("#montoDispA").val());
	document.getElementById("section_one").style.display = "block";
	document.getElementById("section_two").style.display = "none";
	seccionActiva = 1;
	botonHabilitado = false;
	tipoRetiroValidado = false;
}


function section_two(){
	validarHabilitaDesha($("#montoDispB").val());
	document.getElementById("section_one").style.display = "none";
	document.getElementById("section_two").style.display = "block";
	seccionActiva = 2;
	botonHabilitado = false;
	tipoRetiroValidado = false;
}


var abiertaSeccionTres = false;

function sectiontree(){
	validarHabilitaDesha($("#montoDispA").val());
	mostrarPopupFormaPago();
}

var abiertaSeccionCuatro = false;

function sectionfour(){	
	validarHabilitaDesha($("#montoDispB").val());
	mostrarPopupFormaPago();
}

var abierto = false;

function mostrar() {
	if (abierto == false) {
		document.getElementById("button").style.display = "block";
		abierto = true;
	} else {
		document.getElementById("button").style.display = "none";
		abierto = false;
	}
}


function inicializarAcordion(){
	document.getElementById("section_one").style.display = "none";
	document.getElementById("section_two").style.display = "none";	
}

function mostrarModalPdf(){

	console.log("mostrarModalPdf - url: "+$("#retiroDesempleoImss").attr("action"));
	var parametros = {
			tipoRetiroDesempleo: $("#tipoRetiroDesempleo").val(),
			formaPagoTipoRetiro: $("#formaPagoTipoRetiro").val(),
			ctrlInstBancariaTipoRetiro: $("#ctrlInstBancariaTipoRetiro").val(),
			clabeTipoRetiro: $("#clabeTipoRetiro").val(),
			cuentaTipoRetiro: $("#cuentaTipoRetiro").val(),
			tipoPlaso: $("input[name='tipoPlaso']:checked").val(),
            folio1: $("#folio1").val(),
            idFolio: $("#idFolio").val(),
            folioHijo: $("#folioHijo").val(),
            numeroResolucion: $("#numeroResolucion").val()
	};
	
	console.log("mostrarModalPdf - parametros a enviar: ");
	console.log(parametros);
	$.post($("#retiroDesempleoImss").attr("action"), parametros)
	.done(function(data){
		//abrirModalPdf(data);
		console.log(data);
		$(location).attr('href', context+data.destino);
	})
	.fail(function(){
		alert("Operación Incorrecta del Trámite");
	});
}
$(document).ready(function(){
		inicializarAcordion();

	function removerMensajeErrorSectionTree(){
		$("#mensajeErrorSectionTree").empty();
	}

	function removeMensajeErrorSectionFour(){
		$("#mensajeErrorSectionFour").empty();
	}				
		
		$(".Title_OneOption").click(function(e){
			removerMensajeErrorSectionTree();
		});

		$(".Title_TowOption").click(function(e){
			removeMensajeErrorSectionFour();
		});
		
	$("#btnSolicitarDep").click(function(e){
		$("#btnSolicitarDep").attr("disabled", "true");
		window.location.href = "#modalLoader";
		var $form = $(this).parents("#retiroDesempleoImss");
		$("#mensajeErrorSectionTree").empty();
		$("#mensajeErrorSectionFour").empty();
		
		if($("#section_one").css("display")=="none" && $("#section_two").css("display")=="none"){
			$("#btnSolicitarDep").removeAttr("disabled");
			return false;
		}

		if($("#section_one").css("display")=="block" && !tipoRetiroValidado){
			$("#mensajeErrorSectionTree").append($funciones_generales.mensaje("La captura de la Forma de Pago es necesario"));
			$("#btnSolicitarDep").removeAttr("disabled");
			return false;
		}
		
		if($("#section_two").css("display")=="block" && !tipoRetiroValidado){
			$("#mensajeErrorSectionFour").append($funciones_generales.mensaje("La captura de la Forma de Pago es necesario"));
			$("#btnSolicitarDep").removeAttr("disabled");
			return false;
		}
		
		$funciones_generales.validaciones($form);
		
		if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
			//alert("envia");
			
			if($("#section_one").css("display")=="block"){
				$("#tipoRetiroDesempleo").val(TIPO_RETIRO_DESEMPLEO_A);
			}else if($("#section_two").css("display")=="block"){
				$("#tipoRetiroDesempleo").val(TIPO_RETIRO_DESEMPLEO_B);
			}
			
			
			//$form.submit();
			mostrarModalPdf();
			return;
		}else{
			$("#btnSolicitarDep").removeAttr("disabled");
		}				
		
		return false;
	});  
	
	$("#ligaFormaPagoUno").click(removerMensajeErrorSectionTree);
	$("#ligaFormaPagoDos").click(removeMensajeErrorSectionFour);
	$("#formaPagoTipoRetiro").change(function() {
		if($("#formaPagoTipoRetiro").val()=="01"){
			$("#formaPagoTransferencia").hide();
	         $("#btnPopupAceptar").addClass("Submitx");
			 $("#btnPopupAceptar").removeClass("Submitx_disabled");
			 $("#btnPopupAceptar").prop('disabled', false);
		} else {
			$("#formaPagoTransferencia").show();
	         $("#btnPopupAceptar").addClass("Submitx_disabled");
			 $("#btnPopupAceptar").removeClass("Submitx");
			 $("#btnPopupAceptar").prop('disabled', true);
		}
		});
		  $("#clabeTipoRetiro").on('paste', function(e){
		    e.preventDefault();
		  })
		  
		  $("#clabeTipoRetiro").on('copy', function(e){
		    e.preventDefault();
		  })
		  $("#cuentaTipoRetiro").on('paste', function(e){
		    e.preventDefault();
		  })
		  $("#cuentaTipoRetiro").on('copy', function(e){
		    e.preventDefault();
		  })
});
$("#folio2").val($("#folio1").val());
function modalOk(tipoRetiroValidado){
}
function validarHabilitaDesha(monto){
	if(!botonHabilitado){
		habilitaDesha(monto);
	}
}
function habilitaDesha(monto){
	if($("#afore").val() != '568'){
		$("#formaPagoTipoRetiro option[value='01']").remove();
		tipoRetiroValidado = false;
		formaPagoCheque = false;
		$("#formaPagoTransferencia").show();
	} else {
		if(monto>10000){
			$("#formaPagoTipoRetiro option[value='01']").remove();
			tipoRetiroValidado = false;
			formaPagoCheque = false;
			$("#formaPagoTransferencia").show();
		} else {
			$("#formaPagoTipoRetiro option[value='01']").remove();
			$("#formaPagoTipoRetiro").append($("<option>", {
				value:"01",
				text:"Ventanilla"
					}))
			formaPagoCheque = true;
			$("#formaPagoTransferencia").hide();
		}
	}
	$("#formaPagoTipoRetiro option[value='']").prop('selected', true);
}
