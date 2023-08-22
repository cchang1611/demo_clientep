$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		limpiar();
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2") {
		limpiar();
		window.location.href = "#errorModal";
	}
	
	$("#btnLimpiar").click(function(event) {
		var $form = $(this).parents("#fm_altaUser");
		$form.attr("action", "alta.do");
	});
	
	$("#btnRegistro").click(function(event) {
		event.preventDefault();
		$("#btnRegistro").attr("disabled", "true");
		window.location.href = "#modalLoader";
		var $form = $(this).parents("#fm_altaUser");
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
			var bandera = validarRol(valoresCheck);
			if(bandera && $("#numAgente").val().length < 10) {
				if($("#numAgente").parents(".Form__Group").find("label.Labeltexterror").length == 0) {
					$("#numAgente").parents(".Form__Group:first").append("<label class='Labeltexterror'>El número del agente es incorrecto</label>");
				}
			} else {
				$("#numAgente").removeClass("Inputerror");
				$("#numAgente").parents(".Form__Group:first").find("label.Labeltexterror").remove();
			}
			
			if(valoresCheck == "04" && $('#cvAfore').val() == "") {
				if($("#cvAfore").parents(".Form__Group").find("label.Labeltexterror").length == 0) {
					$("#cvAfore").parents(".Form__Group:first").append("<label class='Labeltexterror'>Selecciona una afore</label>");
				}
			} else {
				$("#cvAfore").removeClass("Inputerror");
				$("#cvAfore").parents(".Form__Group:first").find("label.Labeltexterror").remove();
			}
			
			$("#ulCheckBox").removeClass("Invalid_data");
			$("#ulCheckBox").parents(".Form__Group:first").find("label.Labeltexterror").remove();
			$("#rUrl").val(valoresCheck);
		}
		
		var valoresCheckModulo = $("input:checkbox[name='checkModulo']:checked").map(function() {
			return this.value;
		}).get();
		
		if(valoresCheckModulo.length == 0 && $('#claveAfore').val() == "002") {
			$("#ulCheckBoxModulo").addClass("Invalid_data");
			if($("#ulCheckBoxModulo").parents(".Form__Group").find("label.Labeltexterror").length == 0) {
				$("#ulCheckBoxModulo").parents(".Form__Group:first").append("<label class='Labeltexterror'>Selecciona un m&oacute;dulo</label>");
			}
		} else {
			$("#ulCheckBoxModulo").removeClass("Invalid_data");
			$("#ulCheckBoxModulo").parents(".Form__Group:first").find("label.Labeltexterror").remove();
		}
		
		if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
			$form.submit();
		}else{
			$("form#fm_altaUser #btnRegistro").removeAttr("disabled");
		}
	});
	
	$('#cvAfore').change(function() {
		var claveAfore = $('#cvAfore').val();
		$.ajax({
			method      : "GET",
			url         : "obtenerDatosSICI.do",
			contentType : "application/json",
			dataType	: 'json',
			data        : {claveAfore : claveAfore},
			success : function(data) {
				
				var listaZonas;
				if(data.flujo == 1) {
					var cZonas = ["#claveZona", "#nombreZona", "#claveOficina"];
					eliminarError(cZonas);
					
					var listaSucursales= data.mapaRespuesta.listaSucursales;
					$('#claveSucursal').html("<option value=''>Seleccione su SUCURSAL</option>");
					if(listaSucursales != undefined) {
						var noSucursales = listaSucursales.length;
						if(noSucursales != 0){
							$.each(listaSucursales,function(index,item){
								 $("#claveSucursal").append($('<option></option>').attr('id',item.clave).val(item.clave).html(item.descripcion));
							});	
						}
					}
					listaZonas = data.mapaRespuesta.listaZonas;
					if(listaZonas === undefined) {
						listaZonas = null;
					}
				}
				pintarAforeOperativoSICI(listaZonas);
			}
		});
	});
	
	$('#idPlataforma, #claveAfore').change(function() {
		$("#numAgente").val("");
		$('#divModuloReporte').css("display","none");
		$("#userAgente").css("display","none");
		var claveAfore = $('#claveAfore').val();
		var plataforma = $('#idPlataforma').val();
		
		var celular = $("#celular").val();
		var confirmaCelular = $("#confirmaCelular").val();
		
		$.ajax({
			method      : "GET",
			url         : "obtenerDatosAlta.do",
			contentType : "application/json",
			dataType	: 'json',
			data        : {claveAfore : claveAfore,
						   plataforma : plataforma},
			success : function(data) {
				
				var listaZonas;
				var listaModulos;
				$("#camposCelular").empty();
				$("#camposAdicionales").empty();
				if(data.flujo == 1) {
					var cZonas = ["#claveZona", "#nombreZona", "#claveOficina"];
					eliminarError(cZonas);
					
					
					var listaRoles = data.mapaRespuesta.listaRoles;
					var noRoles = listaRoles.length;
					$('#ulCheckBox').html("");
					var rolContador = 0;
					var inicioLista = "";
					if(noRoles != 0){
						inicioLista = "<ul class='Checkbox__List' id='ulCheckRoles"+rolContador+"'>";
						var lista = "";
						$.each(listaRoles,function(index,item){
							if((index > 0) && ((index % 6) == 0)) {
								++rolContador;
								lista = lista + "</ul><ul class='Checkbox__List' id='ulCheckRoles"+rolContador+"'>";
							}
							lista = lista + "<li class='Checkbox__Li'><input type='radio' name='checkRoles' onchange='cambioRol();' value='"+item.clave+"' /> "+item.descripcion+"</li>";
						});
						inicioLista = inicioLista + lista;
						inicioLista = inicioLista + "</ul>";
					}
					$('#ulCheckBox').append(inicioLista);
					var listaSucursales= data.mapaRespuesta.listaSucursales;
					if(listaSucursales != undefined) {
						$('#claveSucursal').html("<option value=''>Seleccione su SUCURSAL</option>");
						var noSucursales = listaSucursales.length;
						if(noSucursales != 0){
							$.each(listaSucursales,function(index,item){
								 $("#claveSucursal").append($('<option></option>').attr('id',item.clave).val(item.clave).html(item.descripcion));
							});	
						}
					}
					listaZonas = data.mapaRespuesta.listaZonas;
					if(listaZonas === undefined) {
						listaZonas = null;
					}
				}
				pintarAforeOperativoSICI(listaZonas);
				pintarCamposAdicionales(listaZonas, celular, confirmaCelular);
			}
		});
	});
	
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

function limpiar(){
	$('#nombre').val('');
	$('#apellidoPaterno').val('');
	$('#apellidoMaterno').val('');
	$('#celular').val('');
	$('#confirmaCelular').val('');
	$('#email').val('');
	$('#confirmaEmail').val('');
	$("#claveAfore").val('');
}

function validarRol(valores) {
	var bandera = false;
	for (var i = 0; i < valores.length; i++) {
		var item = valores[i];
		if(_FLAG.indexOf(item) >= 0) {
			bandera = true;
		}
	}
	
	var elemento = document.getElementById("numAgente");
	if(bandera) {
		elemento.classList.add("Inputerror");
	} else {
		elemento.classList.remove("Inputerror");
	}
	
	return bandera;
}

function cambioRol() {
	document.getElementById("ipUsuario").style.display = "none";
	$('#ipAccesoUsuario').val("");
	document.getElementById("cvAfore").value = "";
	document.getElementById("campoAfores").style.display = "none";
	var bandera = false;
	
	var claveAfore = $('#claveAfore').val();
	var plataforma = $('#idPlataforma').val();
	
	var valoresCheck = $("input:radio[name='checkRoles']:checked").map(function() {
		return this.value;
	}).get();
	
	
	if(_FLAG.indexOf(valoresCheck) >= 0) {
		bandera = true;
	}
	
	document.getElementById("numAgente").value = "";
	if(bandera) {
		document.getElementById("userAgente").style.display = "block";
	} else {
		document.getElementById("userAgente").style.display = "none";
	}
	$.ajax({
		method      : "GET",
		url         : "obtenerModulos.do",
		contentType : "application/json",
		dataType	: 'json',
		data        : { claveAfore		: claveAfore,
						valoresCheck 	: valoresCheck[0],
						plataforma 		: plataforma	},
		success : function(data) {
			
			if(data.mapaRespuesta.ipAcceso !== undefined) {
				document.getElementById("ipUsuario").style.display = "block";
			}
			var listaModulos = data.mapaRespuesta.listaReportes;
			if(listaModulos === undefined) {
				listaModulos = null;
			}
			
			if(listaModulos != null) {
				$('#divModuloReporte').css("display","block");
				$('#ulCheckBoxModulo').html("");
				var moduloContador = 0;
				var inicioModulo = "";
				if(listaModulos.length != 0){
					inicioModulo = "<ul class='Checkbox__List' id='ulCheckReporte"+moduloContador+"'>";
					$.each(listaModulos,function(index,item){
						if((index > 0) && ((index % 6) == 0)) {
							++moduloContador;
							inicioModulo = inicioModulo + "</ul><ul class='Checkbox__List' id='ulCheckReporte"+moduloContador+"'>";
						}
						inicioModulo = inicioModulo + "<li class='Checkbox__Li'><input type='checkbox' name='checkModulo' value='"+item.clave+"' /> "+item.descripcion+"</li>";
					});
					inicioModulo = inicioModulo + "</ul>";
				}
				$('#ulCheckBoxModulo').append(inicioModulo);
			}
		}
	});
}

function obtenerCombosZona(claves, textos, servicio) {
	var calveAfore = $('#claveAfore').val();
	var cvAfor = $('#cvAfore').val();
	if(cvAfor != "") {
		calveAfore = cvAfor;
	}
	
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
			data        : { claveAfore : calveAfore,
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

function pintarCamposAdicionales(data, celular, confirmaCelular) {
	var llaveDiv = "#camposAdicionales";
	if(data == null) {
		$("#camposZona").css("display", "none");
		$("#camposCelular").css("display", "none");
		$("#camposAdicionales").css("display", "block");
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

function pintarAforeOperativoSICI(data) {
	var valueRol = $("input:radio[name='checkRoles']:checked").map(function() {
		return this.value;
	}).get();
	
	if(valueRol == "04") {
		$("#campoAfores").css("display", "block");
		if(data != null) {
			$("#camposZona").css("display", "block");
	
			$("#claveZona").html("<option value=''>Seleccione su Zona</option>");
			$.each(data, function(index,item){
				 $("#claveZona").append($('<option></option>').attr('id',item.clave).val(item.clave).html(item.descripcion));
			});
		} else {
			$("#camposZona").css("display", "none");
		}
	} else {
		$("#campoAfores").css("display", "none");
		$("#camposZona").css("display", "none");
	}
}

function eliminarError(claves) {
	for(var j = 0; j < claves.length; j++) {
		if($(claves[j]).length > 0) {
			$(claves[j]).removeClass("Inputerror");
			$(claves[j]).parents(".Form__Group:first").find("label.Labeltexterror").remove();
		}
	}
}