$(document).ready(function() {
	
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "2") {
		$("#botonesInfoModal").css("display", "block");
		$("#btnInfoM").css("display", "none");
		window.location.href = "#infoModal";
	}
	
	$("#btnInfoModal").click(function(event) {
		window.location.href = 'logout.do';
	});
	
});