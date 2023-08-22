$(document).ready(function() {
	console.log("Invocando Despliegue para las FECHAS");
	$("#errorTipoRegimenObligatorio").hide();
	$("#tablasSub").hide();
	$("#EncabezadoBeneficiarioDiv").hide();
	
	$("#btnEnviarCargadoDiv").attr("disabled","disabled");
	
	$("#fechaIncioPension").attr("readonly","readonly");
	$("#fechaIncioPension").datepicker({
		minDate:"-10y",
		//maxDate: new Date(),
		changeMonth:true,
		changeYear:true,
		dateFormat: 'dd/mm/yy',
		lenguage:'es',
		monthNames:['Enero','Febrero','Marzo','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
		monthNamesShort:['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
	});
	
	
	$("#fechaEmisionResolucion").attr("readonly","readonly");
	$("#fechaEmisionResolucion").datepicker({
		minDate:"-10y",
		//maxDate: new Date(),
		changeMonth:true,
		changeYear:true,
		dateFormat: 'dd/mm/yy',
		language:'es',
		monthNames:['Enero','Febrero','Marzo','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
		monthNamesShort:['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
	});
	
	
});