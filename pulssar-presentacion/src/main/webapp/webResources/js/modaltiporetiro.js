var tipoRetiroValidado = false;
var jsonInstiticionesBancarias = "";
var objetoInstitucionesBancarias = {};
var claveInstitucionBancariaInvalida = false;
var botonHabilitado = false;

function mostrarPopupFormaPago(){
	$('#agregaFormaPago').removeClass("Container_None");
	$('#agregaFormaPago').addClass("Container");
	document.getElementById('agregaFormaPago').style.display = 'block';
	activar_boton();
}

function cerrarModal() {
	document.getElementById('agregaFormaPago').style.display = 'none';
	modalOk(tipoRetiroValidado);
}

function validarFormaPago(){
	console.log("entro en validarFormaPago - tipoRetiroValidado : "+tipoRetiroValidado);
	console.log("SE EJECUT FORMA DE PAGO");
	$("#mensajeErrorInstBancaria").empty();
	
	if(claveInstitucionBancariaInvalida){
		$("#mensajeErrorInstBancaria").html($funciones_generales.mensaje("La clave del Control Institución Bancaria es inválida"));	
	}
		
	
	if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0 && !claveInstitucionBancariaInvalida) {
		tipoRetiroValidado = true;
		cerrarModal();
		console.log("validarFormaPago - tipoRetiroValidado : "+tipoRetiroValidado);
	}else{
		tipoRetiroValidado = false;
		console.log("validarFormaPago - tipoRetiroValidado : "+tipoRetiroValidado);
	}
}

$("#formaPagoTipoRetiro, #ctrlInstBancariaTipoRetiro").change(function(){
	if($(this).val()==""){
		tipoRetiroValidado = false;
	}
});

$("#clabeTipoRetiro, #cuentaTipoRetiro").change(function(){
	if($(this).val()==""){
		tipoRetiroValidado = false;
	}		
});	
		

$("#clabeTipoRetiro").change(asignarInstitucionBancaria);
	
	
$('select#formaPagoTipoRetiro').on('change',function(){
	console.log("Valor Campo Forma de Pago:"+$(this).val());
	$("#descripcionCtrlInstBancaria").val("");
	$("#clabeTipoRetiro").val("");
	$("#cuentaTipoRetiro").val("");
	var flag;
    flag = validarNotNull($(this).val());
	if(!flag){
		eliminarMensajeFormaDePago(this);
		agregarMensajeFormaDePago(this,"LA CAPTURA DE FORMA DE PAGO ES REQUERIDA");
	}else{
		eliminarMensajeFormaDePago(this);
	}
});
	
function agregarMensajeFormaDePago(fct, mensjae){
	$("select#formaPagoTipoRetiro").addClass("invalid_data");
    $(fct).parents(".Form__Group:first").append("<span class='text_error'>"+ arguments[1]+"</span>");
}
	
function eliminarMensajeFormaDePago(fct){
	$("select#formaPagoTipoRetiro").removeClass("invalid_data");
    $(fct).parents(".Form__Group:first").find("span.text_error").remove();
}
	
$("input#clabeTipoRetiro").blur(function(event){
	val = document.getElementById("clabeTipoRetiro").value;
	 var flag;
         flag = validarNotNull(val);  
	if(!flag){
		 eliminarMensajeClabe(this);
		 agregarMensajeClabe(this, "LA CAPTURA DEL CAMPO CLABE ES REQUERIDA");
		 deshabilitaBoton();
		} else {
			eliminarMensajeClabe(this);
	    }

		$.ajax({
				method   :"GET",
				url      :"validarDigitoVerificador.do?clabe="+$("#clabeTipoRetiro").val(),
				contentType:"application/json"
				})
				.success(function(data) {
					if(data.resultadoDeLaOperacion=="01"){
						console.log('DIGITO VERIFICADOR CORRECTO:'+data.diagnosticoDeRecepcion);
						var resultadoDiagnostico = data.diagnosticoDeRecepcion;
					    eliminarMensajeClabe("input#clabeTipoRetiro");
					}else{
				         flag = validarNotNull(val); 
						 if(flag){
							eliminarMensajeClabe(this);
							agregarMensajeClabe("input#clabeTipoRetiro","La Clave Bancaria es incorrecta"); 
							$("#descripcionCtrlInstBancaria").val("");
							tipoRetiroValidado = false;
							 deshabilitaBoton();
							/*habilita
							 $("#btnPopupAceptar").addClass("Submitx_disabled");
							 $("#btnPopupAceptar").removeClass("Submitx");
							 $("#btnPopupAceptar").prop('disabled', true);
							 */
						 }
					}
				})
				.error(function(data) {
					console.log('ERROR AL VALIDAR EL DIGITO VERIFICADOR');
					$("#mensajeErrorClabe").text(data.diagnosticoDeRecepcion);
						
		    	});
		activar_boton();
	});
	
	function agregarMensajeClabe(fct, mensjae){
		   $("input#clabeTipoRetiro").addClass("invalid_data");
	       $(fct).parents(".Form__Group:first").append("<span class='text_error'>"+ arguments[1]+"</span>");
	}
	
	function eliminarMensajeClabe(fct){
		   $("input#clabeTipoRetiro").removeClass("invalid_data");
	       $(fct).parents(".Form__Group:first").find("span.text_error").remove();
	}
	
//    $("input#descripcionCtrlInstBancaria").blur(function(event){
//		val = document.getElementById("descripcionCtrlInstBancaria").value;
//		 var flag;
//	         flag = validarNotNull(val);  
//		if(!flag){
//			
//			 eliminarMensajeControlInstitucion(this);
//			 agregarMensajeControlInstitucion(this, "LA CAPTURA DE CONTROL INSTITUCIÓN BANCARIA ES REQUERIDA");
//			
//		  }else{
//			  console.log("Eliminar msj ERROR del campo CONTROL INSTITUCIÓN BANCARIA");
//			  eliminarMensajeControlInstitucion(this);
//		  }
//	});
	
//	function agregarMensajeControlInstitucion(fct, mensjae){
//		   $("input#descripcionCtrlInstBancaria").addClass("invalid_data");
//	       $(fct).parents(".Form__Group:first").append("<span class='text_error'>"+ arguments[1]+"</span>");
//	}
//	
//	
//	function eliminarMensajeControlInstitucion(fct){
//		   $("input#descripcionCtrlInstBancaria").removeClass("invalid_data");
//	       $(fct).parents(".Form__Group:first").find("span.text_error").remove();
//	}
	
		
	$("input#cuentaTipoRetiro").blur(function(event){
		val = document.getElementById("cuentaTipoRetiro").value;
		console.log("Valor de CONTROL CUENTA : "+val);
		 var flag;
	         flag = validarNotNull(val);  
		if(!flag){
			eliminarMensajeCuenta(this);
			agregarMensajeCuenta(this, "LA CAPTURA DEL CAMPO CUENTA ES REQUERIDA");
		  }else{
			  eliminarMensajeCuenta(this);
		  }
		activar_boton();		
	});
	
	
	function agregarMensajeCuenta(fct, mensjae){
		   $("input#cuentaTipoRetiro").addClass("invalid_data");
	       $(fct).parents(".Form__Group:first").append("<span class='text_error'>"+ arguments[1]+"</span>");
	}
	
	function eliminarMensajeCuenta(fct){
		   $("input#cuentaTipoRetiro").removeClass("invalid_data");
	       $(fct).parents(".Form__Group:first").find("span.text_error").remove();
	}
	
 
	function validarNotNull(valor){
	       if (!arguments[0])
	             return false;
	       return true;
	}
	
$(document).ready(function(){
	objetoInstitucionesBancarias = JSON.parse(jsonInstiticionesBancarias);	
});
function obtenerInstitucionBancaria(clave){
	console.log("id a buscar: "+clave);
	var i=0;
	if(objetoInstitucionesBancarias.length>0){
		for(i=0; i<objetoInstitucionesBancarias.length;i++){
			if(objetoInstitucionesBancarias[i].chParametro==clave){
				console.log("institucion encontrada: "+objetoInstitucionesBancarias[i])
				return objetoInstitucionesBancarias[i];
			}
		}
	}
	
	return null;
}

function asignarInstitucionBancaria(){
	console.log("clabe: "+$("#clabeTipoRetiro").val());
	
	if($("#clabeTipoRetiro").val().length>=3){
		var claveInstitucionBancaria = $("#clabeTipoRetiro").val().substring(0,3);
		console.log("claveInstitucionBancaria a asignar: "+claveInstitucionBancaria);
		$("#ctrlInstBancariaTipoRetiro").val("");
		$("#descripcionCtrlInstBancaria").val("");
		
		var institucionBancaria = obtenerInstitucionBancaria(claveInstitucionBancaria); 
		
		if(institucionBancaria!=null){
			$("#ctrlInstBancariaTipoRetiro").val(claveInstitucionBancaria);
			$("#descripcionCtrlInstBancaria").val(institucionBancaria.chValorParametro);
			console.log("claveInstitucionBancaria asignada: "+$("#ctrlInstBancariaTipoRetiro").val());
			claveInstitucionBancariaInvalida = false;				
		}else{
			console.log("mensaje error");
			claveInstitucionBancariaInvalida = true;							
		}
		
	}else{
		$("#ctrlInstBancariaTipoRetiro").val("");
		$("#descripcionCtrlInstBancaria").val("");
	}
}


function activar_boton(){
 
 var formaPago =$('#formaPagoTipoRetiro').val();
 var clabe =$('#clabeTipoRetiro').val();
 var cuenta=$('#cuentaTipoRetiro').val();
 var ctrlbancario=$('#ctrlInstBancariaTipoRetiro').val();
    if(formaPago!= ''){
    	if(formaPago !='01'){
    		if((clabe!=null) && (clabe!='') && (cuenta!=null && cuenta!='') && (ctrlbancario!=null && ctrlbancario!='') ){
    			habilitaBoton();
    		} else {
    			deshabilitaBoton();	
    		}
    	} else {
			habilitaBoton();
    	}
    } else {
    	deshabilitaBoton();
    }
}

$("#btnPopupAceptar").click(asignarInstitucionBancaria);
$("#btnPopupAceptar").click(validarFormaPago);
$("#btnPopupCancelar").click(function(){
	$("#descripcionCtrlInstBancaria").val("");
	$("#clabeTipoRetiro").val("");
	$("#cuentaTipoRetiro").val("");
	tipoRetiroValidado = false;
	 botonHabilitado = false;
	cerrarModal();
});
	
function habilitaBoton(){
    $("#btnPopupAceptar").addClass("Submitx");
	 $("#btnPopupAceptar").removeClass("Submitx_disabled");
	 $("#btnPopupAceptar").prop('disabled', false);
	 botonHabilitado = true;
    console.log('Habilita boton'); 
}

function deshabilitaBoton(){
	$("#btnPopupAceptar").addClass("Submitx_disabled");
	$("#btnPopupAceptar").removeClass("Submitx");
	$("#btnPopupAceptar").prop('disabled', true);
	 botonHabilitado = false;
}