var redireccionar = "";
var checkNoTitular = 0;
var contador = 0;
function chosenNss(tr){
	var idProcesar = $(tr).attr("id");
	console.log(idProcesar)
	$("#idProcesar").val(idProcesar);
	$("#fm_datosConsulta").submit();
}


$(document).ready(function(){
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	$("#consultaCombo").hide();
	$("#claveConsulta").attr("disabled", "true");
	
	if(_FLUJO == "1") {
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2" || _FLUJO == "4") {
		window.location.href = "#errorModal";
		$("#btnConsultar").removeAttr("disabled");
	} else if(_FLUJO == "5") {
		window.location.href = "#miClock";
	} else if(_FLUJO == "6") {//EMPLEADO NO CUENTA CON SELLO
		$("#botonesInfoModal").css("display", "block");
		redireccionar = "verificarEmpleado.do";
		window.location.href = "#infoModal";
	} else if(_FLUJO == "7") {
		checkNoTitular = 1;
		if($("#claveConsulta").val() != "") {
			$("#idTipoConsulta").prop("checked", true);
			$("#consultaCombo").show();
			$("#claveConsulta").removeAttr("disabled");
		}
		$("#idCurpConsulta").prop('readonly', true);
		$("#idNssConsulta").prop('readonly', true);
		$("#idCurpSol").prop('readonly', true);
		$("#nombreSol").prop('readonly', true);
		$("#apePaternoSol").prop('readonly', true);
		$("#apeMaternoSol").prop('readonly', true);
		$("#claveConsulta").prop('readonly', true);
		$('#claveConsulta option:not(:selected)').attr('disabled',true);
	} else if(_FLUJO == "10") {
		$("#botonesInfoModal").css("display", "block");
		redireccionar = "verificarTrabajador.do";
		window.location.href = "#infoModal";
	} else if(_FLUJO == "578") {
		$("#botonesInfoModal").css("display", "none");
		$("#btnInfoM").css("display", "none");
		$("#botonInfoAutenticacion").css("display", "flex");
		window.location.href = "#infoModal";
	}
	
	$("#btnInfoModal").click(function(event) {
		window.location.href = redireccionar;
	});
	
	$("#btnInfoAutentica").click(function(event) {
		window.location.href = "#modalLoader";
		contador+=1;
		setTimeout(validarAutenticacionInePeis, 10000);
	});
	
	$("#btnClockContinuar, #btnInfoM").click(function(event) {
		window.location.href = "#";
	});
	
	$("#btnLoaderX").click(function(event) {
		window.location.href = "#";
		$("#btnConsultar").removeAttr("disabled");
	});
	
	if(_OBLIGSEL != null && _OBLIGSEL == 'true') {
		$("#btnInfoM").css("display", "none");
	}
	
	$("#btnConsultar").click(function(event) {
		$("#btnConsultar").attr("disabled", "true");
		var $form = $(this).parents("#fm_datosConsulta");
		$funciones_generales.validaciones($form);
		
		$("#multiplesTrab").find("tr:gt(0)").remove();
		
		if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
			window.location.href = "#modalLoader";
		
			$.ajax({
				method      : "GET",
				url         : context+"/private/preconsulta.do?"+$("#fm_datosConsulta").serialize(),
				contentType : "application/json",
				
			})
			.success(function(data) {
				if(data.size == 1 ){//SOLO UN TRABAJADOR
					$('#idProcesar').val(data.persona[0].idProcesar);					
					$form.submit();
				}else{
					if(data.size == 0 ){//NO EXISTEN TRABAJADORES
						$form.submit();
					}
					console.log("datos"+data.size)//MAS DE UN TRABAJADOR
					$.each(data.persona, function(index, key, value){
						var idProcesar=key.idProcesar;
						var nss=key.nss;
						var curp=key.curp;
						if(nss === null || nss == "null"){
							nss="";
						}
						if(curp === null || curp == "null"){
							curp="";
						}
						if(idProcesar === null || idProcesar == "null"){
							idProcesar="";
						}else{
							console.log('nss :'+idProcesar);
							$('#idProcesar').val(idProcesar);
						}
						
						$.tr = $('<tr>').attr({
							 id: idProcesar,
							 onclick: 'chosenNss(this)'
						});
						
							if(index%2==0){
								$.tr.addClass("Row1");
								$.tr.hover(
									function(){
										$(this).addClass("Row_Yellow");
										$(this).removeClass("Row1");
									},function(){
										$(this).addClass("Row1");
										$(this).removeClass("Row_Yellow");
									}
								);
							}else{
								$.tr.addClass("Row2");
								$.tr.hover(
										function(){
											$(this).addClass("Row_Yellow");
											$(this).removeClass("Row2");
										},function(){
											$(this).removeClass("Row_Yellow");
											$(this).addClass("Row2");
										}
									);
							}
							$.tr.append('<td align="center" valign="middle">'+nss+'</td>')
							$.tr.append('<td align="center" valign="middle">'+curp+'</td>')
							$.tr.append('<td align="center" valign="middle">'+key.nombre+'</td>')
							$.tr.append('<td align="center" valign="middle">'+key.apellidoPaterno+'</td>')
							$.tr.append('<td align="center" valign="middle">'+key.apellidoMaterno+'</td>')
							$.tr.append('</tr>')
							
							$('#multiplesTrab tr:last').after($.tr);
							
							window.location.href = "#miModal4";
					});
				}
				
				
			})
			.error(function(data) {
				console.log(data);
			});
		} else {
			window.location.href = "#";
		}
		$("#btnConsultar").removeAttr("disabled");
	});
	
	$('#idTipoConsulta').click(function() {
		if(checkNoTitular == 1) {
			return false;
		}
	});
	
	$("#idTipoConsulta").on('change',function() {
		if($(this).is(':checked')){
			$("#consultaCombo").show();
			$("#claveConsulta").removeAttr("disabled");
		}else{
			$("#consultaCombo").hide();
			$("#claveConsulta").attr("disabled", "true");
		}
	})
});


function presentaAvisoPrivacidad(){
	console.log("Muestra aviso de privacidad");
	$.ajax({
		method      : "GET",
		url         : context+"/private/validaAvisoPriv.do",
		contentType : "application/json",
		
	})
	.success(function(data) {
		if(data.flujo == 0 ){
			$('#modalAvisoPrivPdf').css("opacity", "1");
			$('#modalAvisoPrivPdf').css("pointer-events", "visible");
			$('#modalAvisoPrivPdf').css("display", "block");		
			$("#frameAvisoPrivPdf").css('display','');
			window.location.href = "#modalAvisoPrivPdf";
		}else{
			document.getElementById('tituloError').innerHTML = data.titulo;
			document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
			window.location.href = "#errorModal";
		}
	})
	.error(function(data) {
		console.log(data);
	});
}


function ocultarAvisoPriv(){
	$("#frameAvisoPrivPdf").css('display','none');
	$('#modalAvisoPrivPdf').css("opacity", "0");
	$('#modalAvisoPrivPdf').css("pointer-events", "none");
	$('#modalAvisoPrivPdf').css("display", "none");
}

function validarAutenticacionInePeis() {
	$.ajax({
		method      : "GET",
		url         : "validarAutenticacionIne.do",
		contentType : "application/json",
	})
	.success(function(data) {
		var boolMensaje = true;
		if(data.flujo == 0 || data.flujo == 2) {
			if(data.flujo == 0) {
				contador+=1;
				if(contador < 6) {
					boolMensaje = false;
					setTimeout(validarAutenticacionInePeis, 10000);
				}
			}
			
			if(boolMensaje) {
				$("#btnErrorM").attr('href', context+"/private/"+data.datos);
				document.getElementById('tituloError').innerHTML = data.titulo;
				document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
				window.location.href = "#errorModal";
			}
		} else {
			$.ajax({
				method      : "GET",
				url         : "guardarNotificacion.do",
				contentType : "application/json",
			})
			.success(function(datas) {
				$("#fm_datosConsulta").attr("action", data.datos);
				$("#fm_datosConsulta").submit();
			})
			.error(function(datas) {
				console.log(datas);
			});
		}
	})
	.error(function(data) {
		console.log(data);
	});
}

