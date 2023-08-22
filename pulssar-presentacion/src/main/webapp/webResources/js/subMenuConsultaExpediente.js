var obtenerValorComboTipoExpediente=null;
var obtenerValorComboAfore=null;
var rutaConsultaExpedienteDinamico="consultaExpedienteDinamico.do?";
var tipoUrl="tipoExpediente=";
var curpUrl="curp=";
var aforeUrl="afore=";
var anperson="&"

$(document).ready(function() {
	if (mostrarModalCarrusel) {
		$("#carruselDocumentosModal").show();
        window.location.href="#carruselDocumentosModal";
	}
	$('#salir').click(function(event) {
		window.location.href = urlSalir;
	});
});


/**
 * obtiene email
 * @param modulo
 * @returns
 */
function consultaExpediente(listaAfore,curpEntrada) {
	var curp=null;
	var rutaExpedientes=null;
	obtenerValorComboTipoExpediente=document.getElementById("tipoExpedienteCombo").value;
	if(listaAfore!=null && listaAfore!="" && curpEntrada==null || curpEntrada==""){
		obtenerValorComboAfore=document.getElementById("comboAfore").value;
		curp=$('#campoCurp').val();
		if((curp==null || curp=="")  || (obtenerValorComboTipoExpediente==null || obtenerValorComboTipoExpediente=="" || obtenerValorComboTipoExpediente=="-1") || (obtenerValorComboAfore==null || obtenerValorComboAfore=="" || obtenerValorComboAfore=="-1")){
			 mostrarDiv();
		}else{
			rutaExpedientes=rutaConsultaExpedienteDinamico.concat(tipoUrl).concat(obtenerValorComboTipoExpediente).concat(anperson).concat(curpUrl).concat(curp).concat(anperson).concat(aforeUrl).concat(obtenerValorComboAfore);
			window.location.href=rutaExpedientes;
		}
	}else{
		if(obtenerValorComboTipoExpediente==null || obtenerValorComboTipoExpediente=="" || obtenerValorComboTipoExpediente=="-1"){
			 mostrarDiv();
		}else{
			rutaExpedientes=rutaConsultaExpedienteDinamico.concat(tipoUrl).concat(obtenerValorComboTipoExpediente)
			window.location.href=rutaExpedientes;
		}
	}
}

/**
 * mostrarDiv
 * @returns
 */
function mostrarDiv(){
	$('#exitoModalAceptarVisor').css("opacity", "1");
	$('#exitoModalAceptarVisor').css("pointer-events", "visible");
	$('#exitoModalAceptarVisor').css("display", "block");	
	$('#mensajeExitoAceptarVisor').html("La captura/selección de todos los criterios de búsqueda es obligatoria, favor de validar.");
	$('#tituloExitoAceptarVisor').html("Error");
}

/**
 * ocultarDiv
 * @returns
 */
function ocultarDiv(){
	$('#exitoModalAceptarVisor').css("opacity", "0");
	$('#exitoModalAceptarVisor').css("pointer-events", "none");
	$('#exitoModalAceptarVisor').css("display", "none");		
}