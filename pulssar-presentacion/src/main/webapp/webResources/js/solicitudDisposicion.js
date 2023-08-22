$(document).ready(function() {
	console.log($('#selloTrabajador').val());
	console.log($('#numeroResolucion').val());
	console.log($('#resultadoOperacion').val());
	console.log($('#afore').val());
	console.log($('#origen').val());
	
	if($('#resultadoOperacion').val() != ""){
		if($('#resultadoOperacion').val() == "01"){
			$("#mensajeAlertaCambio").text($('#mensajeOperacion').val());
			
			
			if ($('#afore').val() == '568' && $('#origen').val() == 'matrimonio') {
				
				
				$.ajax({
					method: "GET",
					url: $("#solicitudCertificado").attr("action"),
					contentType: "application/json",
				})
					.success(function(data) {
						
						if(data.error){
							$("#mensajeErrorModal").text(data.error);
							window.location.href="#errorModal";
						}else{
							console.log("###" + data.mensajeMat);
							console.log("###" + data.numResolucion);
							$("#mensajeAlertaCambio").text(data.mensajeMat);
							$("#numResolucion").append(data.numResolucion);
						}
					})
					.error(function(data) {
						$("#mensajeErrorModal").text(data.mensajeMat);
						window.location.href="#errorModal";
					});
			}
			window.location.href="#exitoModalCambio";
		} else {
			console.log("Entro a mostar modal de error");
			$("#mensajeErrorModal").text($('#mensajeOperacion').val());
			//window.location.href="#errorModal";
			$("#errorModal").css("display", "block");
			$("#errorModal").css("opacity", "1");
			$("#errorModal").css("pointer-events", "visible");
			
		}
		
	    	
		$('#btnSolicitar').hide();
	}
	
	$("#btnErrorM").click(cerrarModalError);
});


$("#btnExitoCambio").click(function(event) {
//	window.location.href = "#modalLoader";
//	$("#fm_datosConsulta").submit();
	event.preventDefault();
	event.stopPropagation();
	$("#exitoModalCambio").hide();
});
$("#btnErrorM").click(function(event) {
	event.preventDefault();
	event.stopPropagation();
	$("#exitoModalCambio").hide();
//	window.location.href = "#modalLoader";
//	$("#fm_datosConsulta").submit();
});


function cerrarModalError(){
	$("#errorModal").css("display", "none");
	$("#errorModal").css("opacity", "1");
	$("#errorModal").css("pointer-events", "none");	
}