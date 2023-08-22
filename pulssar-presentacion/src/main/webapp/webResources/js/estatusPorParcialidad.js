$(document).ready(function() {

var listaParcial=listaDes;
	var elemento="POR PAGAR";
	var n = listaParcial.includes(elemento);
	if(n==true){
		  $("#btnNotificaParcialidad").removeAttr("disabled");	
			console.log("Se HABILITA BOTON Enviar POR PAGAR: ");
	  }else{
		  $('#btnNotificaParcialidad').removeClass("Submitx");
		  $('#btnNotificaParcialidad').attr("disabled", 'disabled');
		  $('#btnNotificaParcialidad').addClass("Submit_disabled");
		  
			console.log("Se DESHABILITA BOTON Enviar PENDIENTE: ");
	  }
	
	
});