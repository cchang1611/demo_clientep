$(document).ready(function() {
	document.getElementById('plataformaTitulo').innerHTML = _TITULO;
	document.getElementById('plataformaMensaje').innerHTML = _MENSAJE;
	
	if(_CLAVE_SERVICIO == 'S21'){
		$("#textFoliosPulssar").attr("disabled","disabled");
		$("#idResultado").attr("disabled","disabled");
	}
	
	if(_CLAVE_SERVICIO == 'C'){
		$("#idResultado").attr("disabled","disabled");
	}
	
	
	
	deshabilitarCampos();
	$("#textAreaUsuarios").removeAttr("disabled");
	$("#spanAfores").hide();
	$("#spanFechaIn").hide();
	$("#spanFechaFin").hide();
	$("#fchInicio").attr("readonly","readonly");
	$("#fchFin").attr("readonly","readonly");
	
	/*$("#claveAfore").multipleSelect({
		filter: true
		//placeholder: 'Seleccione una AFORE'
	});*/
	
	$("#btnConsultarCaptura").click(function(event) {
		var $form = $(this).parents("#fm_datosConsultaPlataforma");
		var usuarios = document.getElementById("textAreaUsuarios").value;
		var folios = document.getElementById("textFoliosPulssar").value;
		var combo = document.getElementById("idResultado").value;
		var comboAfore = document.getElementById("claveAfore").value;
		var fechaInicioVal = document.getElementById("fchInicio").value;
		var fechaFinVal = document.getElementById("fchFin").value;
		var selectAfore = $("#claveAfore").val() || [];
		var bandera = false;
		
		
		
		if(usuarios == '' && folios == '' && combo == '0' && comboAfore == '' && fechaInicioVal=="" && fechaFinVal==""){
			window.location.href = "#miModalConsultaPlataforma";
			  $("#miModalConsultaPlataforma").show();
			return
		}else{
		
			var fechaInicio = $.datepicker.parseDate("yy-mm-dd" , fechaInicioVal);
	        var fechaFin = $.datepicker.parseDate("yy-mm-dd" , fechaFinVal);
	        var fechaInDate = new Date(fechaInicioVal).getTime();
	        var fechaFinDate =  new Date(fechaFinVal).getTime();
	        var dif = fechaFinDate - fechaInDate;
	        var dias = dif/(1000*60*60*24);
	        console.log("Dias de diferencias de fechas: "+dias);
	        if(comboAfore == ''){
	        	document.getElementById("claveAfore").value = "todos";
	        }else{
	        	if(selectAfore.length > 1){
	        		for(i=0; i<selectAfore.length; i++){
	        			if(selectAfore[i] == "todos"){
	        				bandera = true;
	        			}
	        		}
	    		}
	    		
	        }	
	        if(bandera){
	        	$("#spanAfores").show();
	        	return
	        }else if(dias < 0){
	        	$("#spanFechaIn").show();
	        	$("#spanFechaFin").show();
				return
			}else if(Date.parse(fechaFin)>Date.now()){
				$("#spanFechaFin").show();
				return
	        }else if(Date.parse(fechaInicio)>Date.now()){
	        	$("#spanFechaIn").show();
				return
			}else if(dias > 29){
				$("#spanFechaIn").show();
	        	$("#spanFechaFin").show();
				return
			}else{
				$form.submit();
			}
		}
			
	
	});
	
	 $("#fchInicio").datepicker({
			minDate:"-10y",
			//maxDate: new Date(),
			changeMonth:true,
			changeYear:true,
			dateFormat: 'yy-mm-dd',
			lenguage:'es',
			monthNames:['Enero','Febrero','Marzo','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
			monthNamesShort:['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
		});
		
		$("#fchFin").datepicker({
			minDate:"-10y",
			//maxDate: new Date(),
			changeMonth:true,
			changeYear:true,
			dateFormat: 'yy-mm-dd',
			language:'es',
			monthNames:['Enero','Febrero','Marzo','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
			monthNamesShort:['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
		});
	
});



function deshabilitarBotones(){
	var usuarios = document.getElementById("textAreaUsuarios").value;
	var folios = document.getElementById("textFoliosPulssar").value;
	var combo = document.getElementById("idResultado").value;
	
	if(usuarios != ''){
		$("#textFoliosPulssar").attr("disabled","disabled");
		$("#idResultado").attr("disabled","disabled");
	}else if(folios != ''){
		$("#textAreaUsuarios").attr("disabled","disabled");
		$("#idResultado").attr("disabled","disabled");
	}else if(combo != '0'){
		$("#textAreaUsuarios").attr("disabled","disabled");
		$("#textFoliosPulssar").attr("disabled","disabled");
	}
	
	if(usuarios == '' && folios == '' && combo == '0'){
		$("#textAreaUsuarios").removeAttr("disabled");
		deshabilitarCampos();
	}
}	


function limpiar(){
	$("#claveAfore").val("");
	$("#textAreaUsuarios").val("");
	$("#textFoliosPulssar").val("");
	$("#idResultado").val("0");
	$("#fchInicio").val("");
	$("#fchFin").val("");
	$("#textAreaUsuarios").removeAttr("disabled");
	deshabilitarCampos();
	$("#spanAfores").hide();
	$("#spanFechaIn").hide();
	$("#spanFechaFin").hide();
}

function deshabilitarCampos(){
	if(_CLAVE_SERVICIO != 'S21'){
		$("#textFoliosPulssar").removeAttr("disabled");	
	}
	
	if(_CLAVE_SERVICIO != 'S21' && _CLAVE_SERVICIO != 'C'){
		$("#idResultado").removeAttr("disabled");
	}
}