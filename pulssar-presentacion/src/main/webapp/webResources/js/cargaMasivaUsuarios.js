
$(document).ready(function() {
	
	$("#idArchivo").attr("disabled","disabled");
	$("#errorModalUsuarios").hide();
	
	inhabilitaInhabilita();	
	
	$("#chooseFile").on('change',function(event){
		$("#idArchivo").attr("disabled","disabled");
		var fileName = $("#chooseFile").val().replace(/C:\\fakepath\\/i,'');
		if (validarFormatoNombre(fileName)) {
			inhabilitaInhabilita();			
		}else{
			window.location.href = "#";
			var tituloModal = "Error archivo";
			var mensajeModal = "Este no es el archivo valido o cuenta con la nomenclatura incorrecta";
			$('#tituloErrorUser').empty();
			$('#mensajeErrorModalUser').empty();
			$('#tituloErrorUser').append(tituloModal);
			$('#mensajeErrorModalUser').append(mensajeModal);
			window.location.href = "#errorModalUser";
	

		}
	
	});
	
	/**
	 * Borra archivo seleccionado
	 */
	$("#borrar").click(function(event) {
		inhabilitaInhabilita();
		limpiaFormulario();
	});
	
	if(_FLUJO == "1") {
		window.location.href = "#exitoModalAceptar";
	} else if(_FLUJO == "2") {
		$("#errorModalUsuarios").show();
		window.location.href = "#errorModalUsuarios";
	}
	
	$("#btnExitoAceptar").click(function(event) {
		menuPrincipal();
	});
	
	function menuPrincipal(){
		window.location = 'menu.do';
	}


});



/**
 * habilitao habilita  o inhabilita componentes
 */
function inhabilitaInhabilita(){
	var filename = $("#chooseFile").val();
	if (filename != null && filename != ''){
		$("#idArchivo").attr("class","Submitx");
		$("#idArchivo").removeAttr("disabled");
	}else{
		$("#idArchivo").attr("class","Submit_disabled");
	}
}
/**
 * Valida el formato del nombre
 */
function validarFormatoNombre(fileName){
	$("#idArchivo").attr("class","Submit_disabled");
	if (fileName != null) {
		var filePart = fileName.split(".");
		var extension = filePart[1]; 
		var name = filePart[0].split("_");
		var afore = name[0];
		if (extension != "csv") {
			return false;
		}else if (afore.length != 3) {
			return false;
		}else if(name[1] != "cargaMasivaAgente"){
			return false;
		}else{
			return validarFecha(name[2]);
		}
			
	}
	return true;
}

function limpiaFormulario(){
	$("#noFile").empty();
	$("#chooseFile").val('');		
	inhabilitaInhabilita();
}

function validarFecha(fechaStr){
	var fecha = new Date();
	var formatFecha = String(fecha.getDate()).padStart(2,'0') + String(fecha.getMonth() + 1).padStart(2,'0') + fecha.getFullYear();
	console.log(formatFecha);
	console.log(formatFecha == fechaStr);
	return formatFecha == fechaStr;
}
