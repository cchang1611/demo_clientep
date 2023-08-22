$(document).ready(function() {
		$("#btnSolicitarCusDispoTotal").click(function(event) {
            window.location.href = "#modalLoader";
            console.log('solicitar generacion de cus');
			$.ajax({
				method      : "GET",
				url         : "solicitarCus.do?origen=ISSSTE&folio="+$("#idFolioHidden").val()+"&servicio=04",
				contentType : "application/json"
			})
		.success(function(data) {
			
			console.log(data);
			if(data.correcto=="true"){
				$("#mensajeAlertaCambio").text(data.descDiagnostico);
				$("#btnAceptarDispoTotal").removeAttr("disabled");
				window.location.href="#exitoModalCambio";
				console.log('CUS GENERADO CORRECTO');
			}else{
				$("#mensajeErrorModal").text(data.descDiagnostico);
				window.location.href="#errorModal";
				console.log('ERROR AL GENERAR CUS');
			}
		})
		.error(function(data) {
			console.log(data);
			$("#mensajeErrorModal").text(data.status+": "+data.statusText);
				window.location.href="#errorModal";
		});
	});
	validarBotones();
});
$("#btnExitoCambio").click(function(event) {
	event.preventDefault();
	event.stopPropagation();
	$("#exitoModalCambio").hide();
});

function validarBotones(){
	if($("#botonAceptar").val() == "true"){
		$("#tipoDisposicion").prop('disabled',false);
		
	}
}
$("#btnAceptarDispoTotal").click(function(event) {
	$("#solicitudTramite").submit();
});
function validarCampos(){
	if($("#tipoDisposicion").val() != ""){
		$("#tipoRetiro").prop('disabled',false);
		if($("#tipoDisposicion").val() == "D1"){
			var newOptions = {
					"Seleccione una opción":"",
					"A-Disposición  de recursos por el trabajador/beneficiario al amparo de una negativa de pensión":"A",
					"B-Disposición  de recursos por el trabajador/beneficiario al amparo de una pensión autorizada":"B", 
					"I-Disposición de Recursos Excedentes al MC":"I", 
					"G-Pago de Pensión Mínima Garantizada":"G", 
					"K-Disposición de recursos por reingreso":"K", 
					"M-Disposición de Recursos Excedentes al MC":"M"
						};
		}
		if($("#tipoDisposicion").val() == "D2"){
			var newOptions = {
					"Seleccione una opción":"",
					"C-Disposición  de recursos por el trabajador/beneficiario al amparo de un plan privado de pensiones":"C",
					"D-Disposición de recursos por el trabajador / beneficiario por instrucción de la autoridad":"D",
					"E-Disposición de recursos por el trabajador al amparo de su edad":"E",
					"K-Disposición de recursos por reingreso":"K",
					"O-Disposición de cuentas inactivas por el trabajador/beneficiario al amparo de una pensión autorizada por el ISSSTE":"O"
						};
		}
		if($("#tipoDisposicion").val() == "D3"){
			var newOptions = {
					"Seleccione una opción":"",
					"B-Disposición  de recursos por el trabajador/beneficiario al amparo de una pensión autorizada":"B" 
						};
		}
		if($("#tipoDisposicion").val() == "D4"){
			var newOptions = {
					"Seleccione una opción":"",
					"D-Disposición de recursos por el trabajador / beneficiario por instrucción de la autoridad":"D",
					"E-Disposición de recursos por el trabajador al amparo de su edad":"E"
						};
		}
	} else {
		$("#tipoRetiro").prop('disabled',true);
		var newOptions = {
				"Seleccione una opción":""
		}
	}
	var $e1 = $("#tipoRetiro");
	$e1.empty();
	$.each(newOptions, function(key, value){
		$e1.append($("<option></option>").attr("value", value).text(key));
	});
}