function abrirModalPdf(data){
	$("#seccionModalPdf").empty();
	$("#seccionModalPdf").html(data);
	$('#modalPdf').css("opacity", "1");
	$('#modalPdf').css("pointer-events", "visible");
	$('#modalPdf').css("display", "block");		
}	

function cerrarModalPdf(){
	$('#modalPdf').css("opacity", "0");
	$('#modalPdf').css("pointer-events", "none");
	$('#modalPdf').css("display", "none");
	$("#btnSolicitarDep").removeAttr("disabled");
}
