$(document).ready(function() {

	$("#btnNotificaParcialidad").click(function(e){
		console.log("Se da click boton ACEPTAR: ");

		$("#form-RetiroParcialidad").submit();
			
	});

	if(_FLUJO == "1") {
		window.location.href = "#exitoModalAceptar";
	} else if(_FLUJO == "2") {
		window.location.href = "#errorModal";
	} else if(_FLUJO == "3"){
		console.log("Ventana No existen parcialidades: ");
		window.location.href = "#errorModal";
		 
	}
	
});