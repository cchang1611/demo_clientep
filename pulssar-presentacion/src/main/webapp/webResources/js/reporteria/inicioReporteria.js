$(document).ready(function() {

	// Define las constantes para el presente js.
	FLUJO_SESION_CADACUDA  = "3";
	FLUJO_ERROR_INESPERADO = "4";
	
	if(_FLUJO == FLUJO_SESION_CADACUDA) {
		window.location.href = "#sesionCaduacadaModal";
	};
	
	$("#submitConfirmacionSesionCaducada").click(function(event) {
		window.location = '/pulssar/public/finalizaSesion.do';
	});
	
	$("#btnAceptar").click(function(event) {
		validarFormulario();
	});
	
	$("#btnCancelar").click(function(event) {
		window.location = '/pulssar/private/menuPrincipal.do';
	});
	
	$( "#fechaInicio" ).datepicker({
		dateFormat:'dd/mm/yy'
	});

	
	$( "#fechaFin" ).datepicker2({
		dateFormat:'dd/mm/yy'
	});
	
	
	
});

function validarCamposVacios(campoId){
	
	if($("#"+campoId+"").val().length==0 || $("#"+campoId+"").val()==""){
		return false;
	}
	return true;
	
}

function validarFechas(fechaInicio,fechaFinal){

	var fInicio= fechaInicio.split("/");
	var fFinal = fechaFinal.split("/");
	

	
	var dateInicio= new Date(fInicio[2],(fInicio[1]-1),fInicio[0]);
	var dateFinal= new Date(fFinal[2],(fFinal[1]-1),fFinal[0]);
	
	if(dateInicio>dateFinal){
		return false
	}
	
	return true;
	
	
}

function validarFormulario(){
	if(!validarCamposVacios("fechaInicio")){
		if($("#fechaInicio").parents(".Col01").find("label.Labeltexterror").length == 0) {
			$("#fechaInicio").parents(".Col01:first").append("<label class='Labeltexterror'>Seleccionar una Fecha Inicio</label>");
		}
	}else{
		$("#fechaInicio").parents(".Col01:first").find("label.Labeltexterror").remove();
	}
	
	if(!validarCamposVacios("fechaFin")){
		if($("#fechaFin").parents(".Col02").find("label.Labeltexterror").length == 0) {
			$("#fechaFin").parents(".Col02:first").append("<label class='Labeltexterror'>Seleccionar una Fecha Fin</label>");
		}
	}else{
		$("#fechaFin").parents(".Col02:first").find("label.Labeltexterror").remove();
	}
	
	if(!validarCamposVacios("tipoCliente")){
		if($("#tipoCliente").parents(".Form__Group:first").find("label.Labeltexterror").length == 0) {
			$("#tipoCliente").parents(".Form__Group:first:first").append("<label class='Labeltexterror'>Seleccionar tipo de Cliente</label>");
		}
	}else{
		$("#tipoCliente").parents(".Form__Group:first:first").find("label.Labeltexterror").remove();
	}
	
	if(!validarCamposVacios("tipoServicio")){
		if($("#tipoServicio").parents(".Form__Group:first").find("label.Labeltexterror").length == 0) {
			$("#tipoServicio").parents(".Form__Group:first").append("<label class='Labeltexterror'>Seleccionar tipo de Servicio</label>");
		}
	}else{
		$("#tipoServicio").parents(".Form__Group:first").find("label.Labeltexterror").remove();
	}
	
	
	if(validarCamposVacios("fechaInicio") && validarCamposVacios("fechaFin")){
		var fechaInicio = $("#fechaInicio").val();
		var fechaFin     = $("#fechaFin").val();
		
		if(!validarFechas(fechaInicio,fechaFin)){
			if($("#fechaFin").parents(".Col02").find("label.Labeltexterror").length == 0) {
				$("#fechaFin").parents(".Col02:first").append("<label class='Labeltexterror'>Fecha Fin no puede ser menor  a Fecha inicio</label>");
			}
		}else if(!validarFechas(fechaLimiteBusqueda,fechaInicio)){
			if($("#fechaFin").parents(".Col02").find("label.Labeltexterror").length == 0) {
				$("#fechaFin").parents(".Col02:first").append("<label class='Labeltexterror'>Seleccione un rango maximo de "+msjBusqueda+"  </label>   ");
			}	
		}else if(!validarFechas(fechaFin,fechaHoy)){
				if($("#fechaFin").parents(".Col02").find("label.Labeltexterror").length == 0) {
				$("#fechaFin").parents(".Col02:first").append("<label class='Labeltexterror'>Seleccione un rango maximo de "+msjBusqueda+" </label>");
			}	
		}else{
			$("#fechaFin").parents(".Col02:first").find("label.Labeltexterror").remove();
		}

	 }
	

	
	if($(".Labeltexterror").length==0){
		var form = document.forms[0];
		form.submit();
		
	}
	
	
}

