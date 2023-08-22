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
	
	$("#btnCancelar").click(function(event) {
		var $form = $(this).parents("#fm_editaUser");
		$form.attr("action", "modifica.do");
	});
	
	$("#btnRegistro").click(function(event) {
		event.preventDefault();
		$("#btnRegistro").attr("disabled", "true");
		window.location.href = "#modalLoader";
		
		var $form = $(this).parents("#fm_editaUser");
		$funciones_generales.validaciones($form);
		
		var valoresCheck = $("input:radio[name='checkRoles']:checked").map(function() {
			return this.value;
		}).get();
		
		if(valoresCheck.length == 0) {
			$("#ulCheckBox").addClass("Invalid_data");
			if($("#ulCheckBox").parents(".Form__Group").find("label.Labeltexterror").length == 0) {
				$("#ulCheckBox").parents(".Form__Group:first").append("<label class='Labeltexterror'>Selecciona un perfil</label>");
			}
		} else {
			$("#ulCheckBox").removeClass("Invalid_data");
			$("#ulCheckBox").parents(".Form__Group:first").find("label.Labeltexterror").remove();
		}
		
		var valoresModelo = $("input:checkbox[name='checkModulo']:checked").map(function() {
			return this.value;
		}).get();
		
		if($('#divModuloReporte').css('display') == 'block' && valoresModelo.length == 0) {
			$("#ulCheckBoxModulo").addClass("Invalid_data");
			if($("#ulCheckBoxModulo").parents(".Form__Group").find("label.Labeltexterror").length == 0) {
				$("#ulCheckBoxModulo").parents(".Form__Group:first").append("<label class='Labeltexterror'>Selecciona un m&oacute;dulo</label>");
			}
		} else {
			$("#ulCheckBoxModulo").removeClass("Invalid_data");
			$("#ulCheckBoxModulo").parents(".Form__Group:first").find("label.Labeltexterror").remove();
		}
		
		if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
			$("form#fm_editaUser #btnRegistro").attr("disabled", "true");
			$form.submit();
		} else {
			$("#btnRegistro").removeAttr("disabled");
			window.location.href = "#";
		}
	});
	
	if($("#dUrl").val() == $("#email").val()) {
		$("#email").attr("disabled", "true");
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
	if(claveSecundaria == ""){
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
			data        : { claveAfore : claveAfore,
							zona : claveSecundaria },
			success : function(data) {
				$(claves[1]).html("<option value=''>" + textos[0] + "</option>");
				$.each(data,function(index,item){
					 $(claves[1]).append($('<option></option>').attr('id',item.clave).val(item.clave).html(item.descripcion));
				});
			}
		});
	}
}

function cambioRol() {
	document.getElementById("divModuloReporte").style.display = "none";
	var valoresCheck = $("input:radio[name='checkRoles']:checked").map(function() {
		return this.value;
	}).get();
	
	validarDivModuloReporte(valoresCheck[0]);
}

function validarDivModuloReporte(claveRol) {
	var claveAfore = $('#claveAfore').val();
	$.ajax({
		method      : "GET",
		url         : "validarPerfil.do",
		contentType : "application/json",
		dataType	: 'json',
		data        : {	claveAfore : claveAfore,
						rol : claveRol},
		success : function(data) {
			if(data.flujo == 1) {
				$("input:checkbox[name='checkModulo']").removeAttr("checked");
				document.getElementById("divModuloReporte").style.display = "block";
			}
		}
	});
}