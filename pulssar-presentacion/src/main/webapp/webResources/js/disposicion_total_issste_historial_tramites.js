$(document).ready(function() {
	if(botonCancelacion == "1"){
		$("#cancelacionIssste").removeClass('disabled_Url');
	}else{
		$("#cancelacionIssste").addClass('disabled_Url');
	}
});


function consultarCancelacionDispoIssste(){
	
	$.ajax({
		method : "GET",
		url : "consultarCancelacion.do",
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
