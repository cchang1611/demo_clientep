$(document).ready(function() {
	
	var INDICADOR_CON_CITA                = 1;
	var INDICADOR_SIN_CITA                = 2;
	var INDICADOR_SIN_DATOS_PARA_REGISTRO = 3;
	
	var valorIndicadorTipoCita = $("#id__indicadorTipoCita").val();
	if(valorIndicadorTipoCita == INDICADOR_SIN_CITA) {
		
		$("#id__correo").removeAttr("disabled");
		$("#id__celular").removeAttr("disabled");
	}
	
	if(valorIndicadorTipoCita == INDICADOR_SIN_DATOS_PARA_REGISTRO) {
		
		$("#id__curp").removeAttr("disabled");
		$("#id__nss").removeAttr("disabled");
		$("#id__nombre").removeAttr("disabled");
		$("#id__apellidoPaterno").removeAttr("disabled");
		$("#id__apellidoMAterno").removeAttr("disabled");
		$("#id__correo").removeAttr("disabled");
		$("#id__celular").removeAttr("disabled");
	}
});