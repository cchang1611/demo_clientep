$(document).ready(function() {


	$("#formaPagoTransferencia").hide();
	$("#formaPagoOrdenPago").hide();

	$("#clabeTipoRetiro").on("input", function() {
		this.value = this.value.replace(/\D/g,'');
	});
	
	$("#btnPopupAceptar").on("input click", function() {
		$("#btnSolicitar").removeClass("Submitx_disabled");
		$("#btnSolicitar").addClass("Submitx");
		$("#btnSolicitar").removeAttr("disabled", "disabled");
		
		
		console.log("mostrarModalPdf - parametros a enviar: ");
		
		var data = {
			formaPago: $("#formaPagoTipoRetiro").val(),
			cuentaClabe: $("#clabeTipoRetiro").val(),
			claveBanco: $("#claveBanco").val()

		};
		console.log(data);	
					
					
		$.ajax({
			method   	:"POST",
			url      	:$("#tipoRetiro").attr("action"),
			contentType	:"application/json",
			data		:JSON.stringify(data)
			})
			.success(function(data) {
				document.getElementById('agregaFormaPago').style.display = 'none';
			})
			.error(function(data) {
				
	    	});


		
	});
	
	$("#btnPopupCancelar").on("input click", function() {
		$("#descripcionCtrlInstBancaria").val("");
		$("#clabeTipoRetiro").val("");
		$("#cuentaTipoRetiro").val("");
		document.getElementById('agregaFormaPago').style.display = 'none';
	});
	
	
	
	$("#clabeTipoRetiro, #formaPagoTipoRetiro, #buscarClabe").on("change paste click keydown keyup", function() {
		const clabeNum = $("#clabeTipoRetiro").val();
		const clabeCheck = clabe.validate(clabeNum);
		var isFormaPagoVacio = true;
		
		isFormaPagoVacio = !$("#formaPagoTipoRetiro").val();
		if(clabeCheck.ok){
			$("#descripcionCtrlInstBancaria").val(clabeCheck.tag);
			$("#clabeTipoRetiro").removeClass("invalid_data");
		}else{
			$("#descripcionCtrlInstBancaria").val("");
			$("#clabeTipoRetiro").addClass("invalid_data");
		}
		
		
		
		console.log("##switch##"+$("#formaPagoTipoRetiro").val());
		switch($("#formaPagoTipoRetiro").val()){
			
			case "02":
				$("#formaPagoTipoRetiro").removeClass("invalid_data");
				console.log("transferencia");
				$("#formaPagoTransferencia").show();
				$("#cuentaTipoRetiro").val(clabeCheck.account);				
				$("#formaPagoOrdenPago").hide();
				
				if(clabeCheck.ok && !isFormaPagoVacio){
					console.log("ok");
					$("#ctrlInstBancariaTipoRetiro").val(clabeCheck.code.bank);
					$("#claveBanco").val(clabeCheck.code.bank);
					$("#btnPopupAceptar").removeClass("Submitx_disabled");
					$("#btnPopupAceptar").addClass("Submitx");
					$("#btnPopupAceptar").removeAttr("disabled", "disabled");
				}else{
					console.log("faltan cosas");
					$("#btnPopupAceptar").removeClass("Submitx");
					$("#btnPopupAceptar").addClass("Submitx_disabled");
					$("#btnPopupAceptar").attr("disabled", "disabled");
				}
	
			break;
			case "01":
				$("#formaPagoTipoRetiro").removeClass("invalid_data");
				console.log("orden pago");
				$("#formaPagoOrdenPago").show();
				$("#formaPagoTransferencia").hide();
				
				$("#btnPopupAceptar").removeClass("Submitx_disabled");
				$("#btnPopupAceptar").addClass("Submitx");
				$("#btnPopupAceptar").removeAttr("disabled", "disabled");
			break;
			
			default:
			console.log("default");
				$("#formaPagoTipoRetiro").addClass("invalid_data");
				$("#formaPagoTransferencia").hide();
				$("#formaPagoOrdenPago").hide();
				$("#descripcionCtrlInstBancaria").val("");
				$("#clabeTipoRetiro").val("");
				$("#btnPopupAceptar").removeClass("Submitx");
					$("#btnPopupAceptar").addClass("Submitx_disabled");
					$("#btnPopupAceptar").attr("disabled", "disabled");
			break;
		}
		
		console.log("##forma pago vacio "+!$("#formaPagoTipoRetiro").val() );
		console.log("##clabe ok "+clabeCheck.ok );
		
		
		
	});
	
});

//$("#btnSolicitar").addClass("Submitx");
//			$("#btnSolicitar").removeClass("Submitx_disabled");


function mostrarPopupFormaPago() {
	$('#agregaFormaPago').removeClass("Container_None");
	$('#agregaFormaPago').addClass("Container");
	document.getElementById('agregaFormaPago').style.display = 'block';	
}

function cerrarModal() {
	document.getElementById('agregaFormaPago').style.display = 'none';
	modalOk();
}

