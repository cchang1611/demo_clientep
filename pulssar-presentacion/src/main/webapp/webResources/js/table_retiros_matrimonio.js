$(document).ready(function() {

$("#btnSolicitar").click(function(){
	$.post($("#guardarCalculo").attr("action"))
		.done(function(data){
			//abrirModalPdf(data);
			console.log(data);			
			if(data.hasOwnProperty('error')){
				$("#mensajeErrorModal").text(data.error);
				window.location.href = "#errorModal";
			}else{
				$(location).attr('href', context+data.destino);
			}
			
			
		})
		.fail(function(){
			alert("fallo mostrar solicitud");
		});
});

});
