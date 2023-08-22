$(document).ready(function() {
	if ($('#mensaje').val() != "") {
		$("#mensajeErrorModal").text($('#mensaje').val());
		window.location.href = "#errorModal";
	}
	if ($('#resultadoOperacion').val() != "") {
		if ($('#resultadoOperacion').val() == "02") {
			$("#mensajeErrorModal").text($('#mensaje').val());
			window.location.href = "#errorModal";
		} else {
			$("#mensajeAlertaCambio").text($('#mensaje').val());
			window.location.href = "#exitoModalCambio";
		}

	}
	$("#btnCus").click(function(event) {
		$(location).attr('href', 'generaCus.do?origen=ISSSTE')
	});

	$("#instBancaria").attr("disabled", true);
	$("#clabeTipoRetiro").change(asignarInstitucionBancaria);
	objetoInstitucionesBancarias = JSON.parse(jsonInstiticionesBancarias);		

	$('#montoADisponer').hide();
	console.log(tipo);
});

$("#btnExitoCambio").click(function(event) {
	event.preventDefault();
	event.stopPropagation();
	$("#exitoModalCambio").hide();
//	window.location.href = "#modalLoader";
//	$("#fm_datosConsulta").submit();
});
$("#btnErrorM").click(function(event) {
//	event.preventDefault();
//	event.stopPropagation();
//	$("#exitoModalCambio").hide();
//	window.location.href = "#modalLoader";
//	$("#fm_datosConsulta").submit();
});



$("#montoad").click(function(event) {
	$('#montoADisponer').show();
});

function cerrarWae() {
	console.log("esconder");
	$('#montoADisponer').hide();
}

function modalOk(tipoRetiroValidado){
	if(tipoRetiroValidado){
		   $("#btnSolicitar").addClass("Submit");
		   $("#btnSolicitar").removeClass("Submit_disabled");
		   $("#btnSolicitar").prop('disabled', false);

	} else {
		   $("#btnSolicitar").addClass("Submit_disabled");
		   $("#btnSolicitar").removeClass("Submit");
		   $("#btnSolicitar").prop('disabled', true);
		
	}
}


$("#btnactualizadatos").click(function(event) {
	$("#fm_datosConsulta").submit();
});