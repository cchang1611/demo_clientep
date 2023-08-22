$(document).ready(function() {
	if(botonCancelacionImss == "1"){
		$("#cancelacionImss").removeClass('disabled_Url');
	}else{
		$("#cancelacionImss").addClass('disabled_Url');
	}
});


function consultarCancelacionDispoImss(){
	
	$.ajax({
		method : "GET",
		url : "consultarCancelacionImss.do",
		contentType : "application/json"
		
	}).success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			if(data.mensaje == "02"){
				$("#mensajeErrorModal").text(data.titulo);
				window.location.href = "#errorModal";
				$("#errorModal").show();
				
			}else{
				$("#mensajeExito").text("Tu solicitud se realizó con éxito");
				window.location.href = "#exitoModal";
				$("#exitoModal").show();
			}
		}	
		
		
	}).error(function(data) {
		console.log("Ocurrio un error ::" + data);
	})
}
