/**
 * Reimpresion saldos y movimientos 
 */
var obtieneArchivosPDFPorTipoTramiteSaldosYMovimientos= "obtieneArchivosPDFPorTipoTramiteSaldosYMovimientos.do";
var servicioValidarArchivoExistente= "validarArchivoExistenteSaldosYMovimientos.do";
var correoError="Error";
var flujoCorrecto='0';
var mensajeError="No se ha realizado este tipo de trámite a través de la plataforma de servicios";

/**
 * Funcion inicial
 * @returns
 */
$(document).ready(function() {
	var inputExisteArchivo=$('#existeArchivo').val();
	if(inputExisteArchivo=='false'){
		document.getElementById("mensajeErrorModal").innerHTML=mensajeError;			
		window.location.href = "#errorModal";
	}
	$('#comboMenuSaldos').on('change',function(){	 
		var valor=$(this).val();
		direccionarPdf(valor);
					
	});

});

/**
 * direccionarPdf
 * @param modulo
 * @returns
 */
function direccionarPdf(modulo){
	try {
		$.ajax({
			method : "GET",
			url : servicioValidarArchivoExistente,
			contentType : "application/json",
			data : {
				modulo : modulo
			}
		}).success(function(data) {
			if(data.flujo==flujoCorrecto){			
				$(location).attr('href',obtieneArchivosPDFPorTipoTramiteSaldosYMovimientos);	
			}else{
				ventanaModalError(data);
			}
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}

/**
 * ventanaModalError
 * @param data
 * @returns
 */
function ventanaModalError(data){
	document.getElementById("tituloError").innerHTML=correoError;
	document.getElementById("mensajeErrorModal").innerHTML=data.mensaje;			
	window.location.href = "#errorModal";
}