$(document).ready(function() {


	if ($('#mensaje').val() != "") {
		$("#mensajeExito").text($('#mensaje').val());
		window.location.href = "#exitoModal";
	}
	
//	$.get($("#folioMatrimonio").attr("action"))
//	.done(function(data){
//		console.log(data);
//		$("#folio1").val(data.folio1);
//		$("#idFolio").val(data.idFolio);
//		$("#folioHijo").val(data.folioHijo);
//		
//	})
//	.fail(function(){
//		alert("fallo mostrar solicitud");
//	});
	
	
	$("#formaPagoModal").click(function(e){
		mostrarPopupFormaPago();
	});
	

});


function modalOk(tipoRetiroValidado){
	if(tipoRetiroValidado){
		   $("#btnSolicitar").addClass("Submitx");
		   $("#btnSolicitar").removeClass("Submitx_disabled");
		   $("#btnSolicitar").prop('disabled', false);

	} else {
		   $("#btnSolicitar").addClass("Submitx_disabled");
		   $("#btnSolicitar").removeClass("Submitx");
		   $("#btnSolicitar").prop('disabled', true);
		
	}
}



