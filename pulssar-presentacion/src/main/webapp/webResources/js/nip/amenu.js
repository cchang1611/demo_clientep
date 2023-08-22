$(document).ready(function() {
	
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	console.log("FLUJO: " + _FLUJO );
	if(_FLUJO == "2") {
		//$("#botonesInfoModal").css("display", "block");
		//$("#btnInfoM").css("display", "none");
		window.location.href = "#errorModal";
	}
	if(_FLUJO == "4") {
		//$("#botonesInfoModal").css("display", "block");
		//$("#btnInfoM").css("display", "none");
		window.location.href = "#infoModal";
	}
	
	$('#btnErrorM').click(function(event) {
		console.log("[btnErrorM] - A la vista genetral de consulta");
		window.location.href = "datosGenerales.do";
	});
});