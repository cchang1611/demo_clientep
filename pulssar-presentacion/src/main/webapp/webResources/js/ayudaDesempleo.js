$(document).ready(function() {

	$sello = $("#selloid").text();
	console.log($("#selloid").text());


	
	if ($('#mensaje').val() != "") {
		$("#mensajeErrorModal").text($('#mensaje').val());
		window.location.href = "#errorModal";
	}
	
	$("#btnCus").click(function(event) {
		$("#formSalida").submit();
//		$(location).attr('href', 'generaCus.do?origen=IMSS');
	});
	
	
	$("#btnSolicitar").click(function(event) {
		if($("#afore").val() == '568'){
			if($("#telefonia").val() ==''){
				$("#mensajeErrorModal").text("Favor de seleccionar compañia telefonica");
				window.location.href = "#errorModal";
			} else {
				$("#btnSolicitar").attr("disabled", "true");
				window.location.href = "#modalLoader";
				$("#formSalida").submit();
			}
				
		} else {
			$("#btnSolicitar").attr("disabled", "true");
			window.location.href = "#modalLoader";
			$("#formSalida").submit();
		}
	});
	
	
	$("#btnExitoCambio").click(function(event) {
		event.preventDefault();
		event.stopPropagation();
		//$("#selloTrabajadorhid").val($("#selloTrabajador").val());
		$("#formSalida").submit();
	});
	
	
});