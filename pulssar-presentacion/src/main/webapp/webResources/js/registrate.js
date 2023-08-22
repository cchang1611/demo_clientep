$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2") {
		window.location.href = "#errorModal";
	}
	
	generaCaptcha();
	
	$("#enviar").click(function(event) {
		$("form#fm_registro #enviar").attr("disabled", "true");
		var $form = $(this).parents("#fm_registro");
		$funciones_generales.validaciones($form);
		event.preventDefault();
		
		if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
			$form.submit();
		} else {
			$("form#fm_registro #enviar").removeAttr("disabled");
		}
	});
	
	$("#cancelar").click(function(event) {
		var $form = $(this).parents("#fm_registro");
		$form.attr("method", "GET");
		$form.attr("action", "registrate.do");
	});
	
	if($('#claveAfore').length > 0) {
		$('#claveAfore').change(function() {
			var celular = $("#celular").val();
			var confirmaCelular = $("#confirmaCelular").val();
			
			var claveAfore = $('#claveAfore').val();
			if(claveAfore == ""){
				$("#claveSucursal").empty();
				$("#claveSucursal").html("<option value=''>Seleccione su SUCURSAL</option>");
				$("#claveSucursal").attr('disabled', false);
				
				if($("#claveZona").length > 0) {
					$("#claveZona").val("");
				}
			} else {
				$.ajax({
					method      : "GET",
					url         : "cargaSucursales.do",
					contentType : "application/json",
					dataType	: 'json',
					data        : {claveAfore : claveAfore},
					success : function(data) {
						$("#claveSucursal").html("<option value=''>Seleccione su SUCURSAL</option>");
						$.each(data,function(index,item){
							 $("#claveSucursal").append($('<option></option>').attr('id',item.clave).val(item.clave).html(item.descripcion));
						});
					}
				});
				
				$("#camposCelular").empty();
				$("#camposAdicionales").empty();
				
				var cZonas = ["#claveZona", "#nombreZona", "#claveOficina"];
				eliminarError(cZonas);
				
				$.ajax({
					method      : "GET",
					url         : "cargaZonas.do",
					contentType : "application/json",
					dataType	: 'json',
					data        : {claveAfore : claveAfore},
					success : function(data) {
						pintarCamposAdicionales(data, celular, confirmaCelular);
					},
					error : function(data,textStatus){
						pintarCamposAdicionales(null, celular, confirmaCelular);
					}
				});
			}
		});
	}
	
	if($('#claveZona').length > 0) {
		$('#claveZona').change(function(){
			var claves = ["#claveZona", "#nombreZona", "#claveOficina"];
			var textos = ["Seleccione la DESCRIPCI&Oacute;N", "Seleccione su OFICINA"];
			obtenerCombosZona(claves, textos, "cargaDescZona.do");
		});
	}
	
	if($('#nombreZona').length > 0) {
		$('#nombreZona').change(function(){
			var claves = ["#nombreZona", "#claveOficina"];
			var textos = ["Seleccione su OFICINA"];
			obtenerCombosZona(claves, textos, "cargaOficina.do");
		});
	}
});

function obtenerCombosZona(claves, textos, servicio) {
	var claveAfore = $('#claveAfore').val();
	var claveSecundaria = $(claves[0]).val();
	if(claveAfore == "" || claveSecundaria == ""){
		for(var j = 1; j < claves.length; j++) {
			if($(claves[j]).length > 0) {
				$(claves[j]).empty();
				$(claves[j]).html("<option value=''>" + textos[j - 1] + "</option>");
				$(claves[j]).attr('disabled', false);
			}
		}
	}else{
		$.ajax({
			method      : "GET",
			url         : servicio,
			contentType : "application/json",
			dataType	: 'json',
			data        : {claveAfore : claveAfore,
						   zona       : claveSecundaria},
			success : function(data) {
				$(claves[1]).html("<option value=''>" + textos[0] + "</option>");
				$.each(data,function(index,item){
					 $(claves[1]).append($('<option></option>').attr('id',item.clave).val(item.clave).html(item.descripcion));
				});
			}
		});
	}
}

function pintarCamposAdicionales(data, celular, confirmaCelular) {
	var llaveDiv = "";
	if(data == null) {
		$("#camposZona").css("display", "none");
		$("#camposCelular").css("display", "none");
		$("#camposAdicionales").css("display", "block");
		
		llaveDiv = "#camposAdicionales";
	} else {
		$("#camposZona").css("display", "block");
		$("#camposCelular").css("display", "block");
		$("#camposAdicionales").css("display", "none");
		
		llaveDiv = "#camposCelular";
		
		$("#claveZona").html("<option value=''>Seleccione su Zona</option>");
		$.each(data, function(index,item){
			 $("#claveZona").append($('<option></option>').attr('id',item.clave).val(item.clave).html(item.descripcion));
		});
	}
	$(llaveDiv).append("<div class='Form__Group'><label class='LabelText' for='usuario'>Celular: </label><input id='celular' class='Inputxxl' type='text' name='celular' path='celular' placeholder='Celular' data-nombre='Celular' maxlength='10' value='" + celular + "' noPaste='true' /></div><div class='Form__Group'><label class='LabelText' for='usuario'>Confirma Celular: </label><input id='confirmaCelular' class='Inputxxl' type='text' name='confirmarCelular' path='confirmarCelular' data-confirm-no-req='celular' placeholder='Confirma Celular' data-nombre='Confirma Celular' maxlength='10' value='" + confirmaCelular + "' noPaste='true' /></div>");
}

function eliminarError(claves) {
	for(var j = 0; j < claves.length; j++) {
		if($(claves[j]).length > 0) {
			$(claves[j]).removeClass("Inputerror");
			$(claves[j]).parents(".Form__Group:first").find("label.Labeltexterror").remove();
		}
	}
}