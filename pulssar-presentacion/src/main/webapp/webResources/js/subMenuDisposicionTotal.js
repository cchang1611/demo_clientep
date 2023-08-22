$(document).ready(function() {
//
//	if(_FLUJO == "7") {
//		console.log("Mostrando Modal");
//		window.location.href = "#errorValidarMarcaModal";
//	} 
//	   
//	$("#btnModalMarcaAceptar").click(function(event) {
//		console.log("Invocando Redireccion SubMenu:");
//      	$(location).attr('href', 'amenu.do');   
//	    });
	
});//Pincipal
$("#bntnImss").click(function(event){
	event.preventDefault();
	if(ACTIVOIMSS == ""){
		window.location.href = 'dispTotalImss.do';
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
		});
		$("#btnInfoModalCancelar").click(function(){
			window.location.href=urlModificarDatos;
		});
		$("#btnInfoModalContinuar").click(function(){
			window.location.href='dispTotalImss.do';
		});
	}
})
$("#bntnIssste").click(function(event){
	event.preventDefault();
	if(ACTIVOISSSTE == ""){
		window.location.href = 'disposicionTotalIssstes.do';
	}else{
		var arreglo = ACTIVOISSSTE.split('|');
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
			window.location.href='disposicionTotalIssstes.do';
		})
	}
})