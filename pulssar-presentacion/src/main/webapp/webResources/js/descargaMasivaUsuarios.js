
$(document).ready(function() {
//	inhabilitaInhabilita();	
	
	$("#datepicker").datepicker({
		minDate:"-1y",
		maxDate: new Date(),
		changeMonth:true,
		changeYear:true,
		dateFormat: 'dd/mm/yy',
		lenguage:'es',
		monthNames:['Enero','Febrero','Marzo','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
		monthNamesShort:['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
	});
	
	
	/**
	 * Borra archivo seleccionado
	 */
	$("#borrar").click(function(event) {
		inhabilitaInhabilita();
		limpiaFormulario();
	});
	
	if(_FLUJO == "1") {
		window.location.href = "#exitoModalAceptar";
	} else if(_FLUJO == "2") {
//		$("#errorModalUsuarios").show();
		$("#idButtonConsultar").attr("class","Submitx");
		$("#idButtonConsultar").removeAttr("disabled");
		window.location.href = "#errorModal";
	}
	
	$("#btnExitoAceptar").click(function(event) {
		
		menuPrincipal();
	});
	
	function menuPrincipal(){
		window.location = 'menu.do';
	}
	
	$("#idButtonConsultar").click(function(event) {
		
		var fechaBusqueda = document.getElementById("datepicker").value;
//		fechaBusqueda = $.datepicker.parseDate("dd/mm/yy" , fechaBusqueda);
		
		$("#fechaBusqueda").val(fechaBusqueda);
		$("#fm_descargaTramites").submit();			
		$("#idButtonConsultar").attr("disabled","disabled");
		$("#idButtonConsultar").attr("class","Submit_disabled");
	});


});



/**
 * habilitao habilita  o inhabilita componentes
 */
function inhabilitaInhabilita(){
	$("#errorModalUsuarios").hide();
}



function limpiaFormulario(){
	$("#noFile").empty();
	$("#chooseFile").val('');		
	inhabilitaInhabilita();
}

function validarFecha(fechaStr){
	var fecha = new Date();
	var formatFecha = String(fecha.getDate()).padStart(2,'0') + String(fecha.getMonth() + 1).padStart(2,'0') + fecha.getFullYear();
	console.log(formatFecha);
	console.log(formatFecha == fechaStr);
	return formatFecha == fechaStr;
}
