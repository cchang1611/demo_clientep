
/**
 * Evento para cargar las imaegenes en asive 02
 * @returns
 */
$(window).load(function() {
	console.log("Cargo el Load");
	$("#btnExitoAceptar").click(function() {
		alert("jksjskjk");
	});
	
	
});

var windows1 = 0;
var windows2 = 0;
var BOTON_MOUSE=0;

$("#imgExpand").hide();
$("#imgExpandTwo").hide();
$("#idVideo").hide();
$("#idVideo2").hide();
$("#imgExpandPDF").hide();
$("#imgGranPDF").hide();
$("#imgExpandPDF2").hide();
$("#imgGranPDF2").hide();
var bandera=false;

	
function allowDrop(ev) {
	ev.preventDefault();
	};
function drag(ev) {
	ev.dataTransfer.setData("src", ev.target.src);
	};
function drop(ev) {
	    ev.preventDefault();
	    var data = ev.dataTransfer.getData("src");
	    document.getElementById("imgGranTwo").src = data;
	    document.getElementById("imgExpandTwo").href = data;
	}
function closedWindows(data) {
		$("#windows_a").find("*").prop("disabled", false);
		$("#windows_b").find("*").prop("disabled", false);
		windows1 = 0;
		windows2 = 0;
}

$(document).ready(function() {
	console.log("Cargo el ready");
	
	
	/**
	 * MEtodo para ejecutar el loading al llamado del Ajax
	 */
	$(document).ajaxSend(function(){
	});
	
	
	$(".Aside01").css('border','1px solid var(--b01)');
	
	//inhabilita el menu del boton derecho
	$(document).contextmenu(function() {
	    return false;
	});
	
	//Carrusel se agrega byte
	$(".img_carrusel").mousedown(function(e) {		
		var nombre = $(this).attr('alt');
		var arrayCadena = nombre.split("\.");
		var formatFile = arrayCadena[1];
	    var rutaVideo="";
	    var rutaPdf;  
		// 1. izquierdo 2. medio/rueda 3. derecho
		if (e.which == 1) {
			BOTON_MOUSE=1;
			if (formatFile == 'mp4'){
				var format="data:video/mp4;base64,";
				rutaVideo=document.getElementById('srcVideo').innerHTML;
				var videoHTML= "<source  type='video/mp4' src="+format+rutaVideo+">";
				$('#idVideo').html(videoHTML);
				$("#imgExpand").hide();
				$("#idVideo").show();		
			}else if (formatFile == 'pdf') {
				if(bandera==false){
					rutaPdf=document.getElementById(nombre).innerHTML;
					agregaPdfhref(rutaPdf,"imgExpand");
					iniciarTransformacionPdf();
					bandera=true;
				}else{
					rutaPdf=document.getElementById(nombre).innerHTML;
					agregaPdfhref(rutaPdf,"imgExpand");
					iniciarTransformacionPdf();
					$('#imgGran').attr('src',$(this).attr('src'));
					$('#imgExpand').attr('href',$(this).attr('src'));
					$("#idVideo").hide();		
					$("#imgExpand").show();
				}
				
			}else{
				$('#imgGran').attr('src',$(this).attr('src'));
				$('#imgExpand').attr('href',$(this).attr('src'));
				$("#idVideo").hide();		
				$("#imgExpand").show();
			}
		}else if(e.which == 3 ){
			BOTON_MOUSE=3;
			if (formatFile == 'mp4'){
			  var format="data:video/mp4;base64,";
			  rutaVideo=document.getElementById('srcVideo').innerHTML;
			   var videoHTML= "<source  type='video/mp4' src="+format+rutaVideo+">";
			   $('#idVideo2').html(videoHTML);
			   $("#imgExpandTwo").hide();			
			   $("#idVideo2").show();		
		    }else if (formatFile == 'pdf') {
				if(bandera==false){
					rutaPdf=document.getElementById(nombre).innerHTML;
					agregaPdfhref(rutaPdf,"imgExpandTwo");
					iniciarTransformacionPdf();
					bandera==true;
				}else{
					rutaPdf=document.getElementById(nombre).innerHTML;
					agregaPdfhref(rutaPdf,"imgExpandTwo");
					iniciarTransformacionPdf();
					$('#imgGranTwo').attr('src',$(this).attr('src'));
					$('#imgExpandTwo').attr('href',$(this).attr('src'));
					$("#idVideo2").hide();		
					$("#imgExpandTwo").show();
				}	
				
			}else{
				$('#imgGranTwo').attr('src',$(this).attr('src'));
				$('#imgExpandTwo').attr('href',$(this).attr('src'));
				$("#idVideo2").hide();		
				$("#imgExpandTwo").show();
			}
		}
	});
	
	$("#imgExpand").click(function() {
		if (windows1 == 1) {
			$("#windows_a").find("*").prop("disabled", true);
		}
		windows1 = 1;
	});
	$("#imgExpandTwo").click(function() {
		if (windows2 == 1) {
			$("#windows_b").find("*").prop("disabled", true);
		}
		windows2 = 1;
	});

	$("#habilitar").click(function() {
		$("#windows_a").find("*").prop("disabled", false);
		$("#windows_b").find("*").prop("disabled", false);
		windows1 = 0;
		windows2 = 0;		
	});
	
	
});
