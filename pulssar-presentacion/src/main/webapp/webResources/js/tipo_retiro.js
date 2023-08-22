$(document).ready(function() {
	ejecutarValidasionIlegal();
	
})


function ejecutarValidasionIlegal(){
	$.ajax({
		method      : "GET",
		url         : "ejecutarValidacionProceso.do?origenValidacion=2&intentoValidacion=1",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log("Entrando validacion");
		if(data.respuesta != '1'){
			console.log("Validacion 2");
			window.location.href = "#";
			$("#mensajeErrorModal").text(data.respuesta);
			$("#btnErrorM").attr('href', "datosGenerales.do");
			window.location.href = "#errorModal";
		}
	})
}