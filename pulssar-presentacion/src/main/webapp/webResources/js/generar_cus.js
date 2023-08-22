$(document).ready(function() {
	$('#btnSiguiente').hide();
});
	$("#btnSolicitar").click(function(event) {
		$("#btnSolicitar").attr("disabled", "true");
		console.log('solicitar generacion de cus');
		$.ajax({
			method      : "GET",
			url         : "solicitarCus.do?origen="+$("#origen").val()+"&folio="+$("#idFolioHidden").val()+"&servicio=02",
			contentType : "application/json"
		})
		.success(function(data) {
		    $("#btnSolicitar").removeAttr("disabled");
			console.log(data);
			if(data.correcto=="true"){
				$("#mensajeAlertaCambio").text(data.descDiagnostico);
				window.location.href="#exitoModalCambio";
				$('#btnSiguiente').show();
				$('#btnSolicitar').hide();
			}else{
				$("#mensajeErrorModal").text(data.descDiagnostico);
				window.location.href="#errorModal";
			}
		})
		.error(function(data) {
			console.log(data);
			$("#mensajeErrorModal").text(data.status+": "+data.statusText);
				window.location.href="#errorModal";
		});
	});
	$("#btnExitoCambio").click(function(event) {
		event.preventDefault();
		event.stopPropagation();
		$("#exitoModalCambio").hide();
	});
	$("#btnSiguiente").click(function(event) {
		if($("#origen").val() == "IMSS"){
			$(location).attr('href', 'ayudaDesempleo.do')
		} else {
			$(location).attr('href', 'solicitudParcialIssste.do')
		}
	});
