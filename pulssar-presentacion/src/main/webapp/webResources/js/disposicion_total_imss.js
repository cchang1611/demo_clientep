$(document).ready(function() {
	
	$("#btnCus").click(function(event) {
		$("#btnCus").addClass("Submit_disabled");
		$("#btnCus").removeClass("Submit");
		console.log('solicitar generacion de cus');
		$.ajax({
			method      : "GET",
			url         : "cusDispTotalImss.do",
			contentType : "application/json"
		})
		.success(function(data) {
			console.log(data);
			if(data.correcto=="true"){
				$("#mensajeAlertaCambio").text(data.descDiagnostico);
				window.location.href="#exitoModalCambio";
				$('#btnSiguiente').show();
				$('#btnSolicitar').hide();
			}else{
				$("#mensajeErrorModal").text(data.descDiagnostico);
				window.location.href="#errorModal";
				$("#btnCus").addClass("Submit");
				$("#btnCus").removeClass("Submit_disabled");
			}
		})
		.error(function(data) {
			console.log(data);
			$("#mensajeErrorModal").text(data.status+": "+data.statusText);
				window.location.href="#errorModal";
		});
	});
	
	
	
	
	
});