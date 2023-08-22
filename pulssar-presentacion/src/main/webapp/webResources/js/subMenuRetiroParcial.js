$(document).ready(function() {
if($('#mensajeError').val() != ""){
	$("#mensajeErrorModal").text($('#mensajeError').val());
	window.location.href="#errorModal";
}
	
$('#bntnImss').one('click',function(event){
		event.preventDefault();
		if(ACTIVOIMSS == ""){
			window.location.href = 'ayudaDesempleo.do';
		}else{
			var arreglo = ACTIVOIMSS.split('|');
			if(arreglo[0] == 'R' || arreglo[0] == 'N' ){
				$("#mensajeErrorModal").text(arreglo[1]);
				window.location.href="#errorModal";
			}
			if(arreglo[0] == 'P'){
				document.getElementById('tituloInfo').innerHTML = "Aviso";
				document.getElementById('mensajeInfo').innerHTML = arreglo[1];
				$("#btnInfoM").css("display", "none");
				$("#botonesInfoModalDoble").css("display", "block");
				window.location.href = "#infoModal";
			}

			$("#btnErrorM").click(function(){
				if(arreglo[0] == 'R'){
					window.location.href=urlModificarDatos;
				}
			})
			$("#btnInfoModalCancelar").click(function(){
				window.location.href=urlModificarDatos;
			})
			$("#btnInfoModalContinuar").click(function(){
				window.location.href='ayudaDesempleo.do';
			})
		}
	})
	
	
  	$("#isssteOrd").click(function(){
  		event.preventDefault();
  		console.log('validaTramiteIssste RO');
		if(ACTIVOISSSTE == ""){
			validarTramite(context + '/private/validaTramiteIssste/RO');
			//window.location.href = 'solicitudParcialIssste.do';
		}else{
			var arreglo = ACTIVOISSSTE.split('|');
			$("#mensajeErrorModal").text(arreglo[1]);
			window.location.href="#errorModal";
			$("#btnErrorM").click(function(){
				if(arreglo[0] == 'R'){
					window.location.href=urlModificarDatos;
				}
			})
		}
	});
	
	$("#isssteDt").click(function(){
  		event.preventDefault();
  		console.log('validaTramiteIssste DT');
		if(ACTIVOISSSTE == ""){
			validarTramite(context + '/private/validaTramiteIssste/DT');
		}else{
			var arreglo = ACTIVOISSSTE.split('|');
			$("#mensajeErrorModal").text(arreglo[1]);
			window.location.href="#errorModal";
			$("#btnErrorM").click(function(){
				if(arreglo[0] == 'R'){
					window.location.href=urlModificarDatos;
				}
			})
		}
	});
	
	
	
	function validarTramite(url){
		$.ajax({
			url : url,
			type : "GET",
			contentType : 'application/json',
		}).success(function(resultado) {
			console.log(resultado);
			if(resultado == "01"){
				window.location.href = 'solicitudParcialIssste.do';
			}else{
				$("#mensajeErrorModal").text(resultado);
				window.location.href="#errorModal";
			}
		});
		
	}
	
});
