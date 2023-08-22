$(document).ready(function() {
	if(resultadoOperacion == "02"){
		$("#mensajeErrorModal").text(descripcion);
		window.location.href = "#errorModal";
		$("#errorModal").show();
		
	}else{
		$("#mensajeExito").text("Tu solicitud se realizó con éxito");
		window.location.href = "#exitoModal";
		$("#exitoModal").show();
	}
	
});
