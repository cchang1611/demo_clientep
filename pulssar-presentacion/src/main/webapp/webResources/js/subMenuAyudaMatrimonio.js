$(document).ready(function() {
if($('#mensajeError').val() != ""){
	$("#mensajeErrorModal").text($('#mensajeError').val());
	window.location.href="#errorModal";
}
	$("#btnErrorM").click(function(){
		if($('#direccionamiento').val() == ""){
			window.location.href = "datosGenerales.do";
		} else {
			$("#errorModal").css("display", "none");
			$("#errorModal").css("opacity", "1");
			$("#errorModal").css("pointer-events", "none");	
		}
	})
	
});

$('#bntnImss').one('click',function(event){
		event.preventDefault();
		console.log(activoIMSS);
		if (activoIMSS == "") {
			window.location.href = 'ayudaMatrimonio.do';
		}else{
			var arreglo = activoIMSS.split('|');
			if(arreglo[0] == 'R' || arreglo[0] == 'N' ){
				$('#bntnImss').removeClass("CarrouselMenu__ThumbContainer");
				$('#bntnImss').addClass("CarrouselMenu__Disabled");
				$("#mensajeErrorModal").text(arreglo[1]);
				window.location.href="#errorModal";
			}
			$("#btnErrorM").click(function(){
				if(arreglo[0] == 'R'){
					window.location.href=urlModificarDatos;
				}
			});
		}
});