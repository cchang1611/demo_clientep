var numeroIntentos = 0;
var numeroArchivos = 0;
var imaValida = 0;
$(document).ready(function() {
	console.log("entra a expediente.js");
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	console.log("valida flujo " + _FLUJO);
	if(_FLUJO == "2") {
		window.location.href = "#errorModal";
		$("#btnErrorM").removeAttr("disabled");
	} else if(_FLUJO == "3") {
		window.location.href = "#infoModal";
		$("#btnInfoM").attr('href', "modificaTrabajador.do");
		$("#btnInfoM").removeAttr("disabled");
	} else if(_FLUJO == "4") {
		window.location.href = "#infoModal";
		$("#botonesInfoModalDoble").css("display", "block");
		$("#btnInfoModalContinuar").removeAttr("disabled");
		if(AFORE != "530" && AFORE != "568"){
		$("#fm_identificacion").attr('action', _FUN);
		}else{
			$("#fm_recepcionImagen").attr('action', "recepcionImagenesGenerico.do");
		}
	} else if(_FLUJO == "5") {
		window.location.href = "#infoModal";
		$("#btnInfoM").css("display", "none");
		$("#btnInfoModals").css("display", "block");
		$("#btnInfoM").removeAttr("disabled");
	}
	
	$("#btnInfoBiom").click(function(event) {
		event.preventDefault();
		console.log("Inicia proceso de validar solicitud pendiente");
		$("#btnInfoBiom").attr("disabled","disabled");
		window.location.href = "#modalLoader";
		setTimeout(validarExpediente, 10000);
	});
	
	$('#btnInfoModalCancelar').click(function(event) {
		event.preventDefault();
		console.log("Submit al form boton btnInfoModalCancelar");
		$("#fm_identificacion").submit();
	});
	
	$('#btnInfoModalContinuar').click(function(event) {
		event.preventDefault();
		console.log("Cambio a la accion para envio de identificacion");
		$("#btnInfoModalContinuar").attr("disabled","disabled");
		$("#fm_identificacion").attr('action', "enviarIdentificacion.do");
		window.location.href = "#";
	});
	
	$('#btnInfoModal').click(function(event) {
		event.preventDefault();
		if(imaValida == 0) {
			console.log("info de modal, redireccionando a " + _FUN);
			$("#btnInfoModal").attr("disabled","disabled");
			window.location.href = _FUN;
		} else {
			$("#btnInfoModal").attr("disabled","disabled");
			window.location.href = "#";
			imaValida = 0;
		}
	});
	
	$('#btnErrorM').click(function(event) {
		event.preventDefault();
		console.log("error de modal, redireccionando a " + _FUN);
		$("#btnErrorM").attr("disabled","disabled");
		window.location.href = _FUN;
	});
	
	$('#btnExitoM').click(function(event) {
		event.preventDefault();
		console.log("exito de modal, redireccionando a " + _FUN);
		$("#btnExitoM").attr("disabled","disabled");
		window.location.href = _FUN;
	});
	
	$('#btnInfoM').click(function(event) {
		console.log("deshabilita btnInfoM");
		$("#btnInfoM").attr("disabled","disabled");
	});
	
	$('#btnModalActExpContinuar').click(function(event){
		event.preventDefault();
		console.log("ejecucion de proceso de recepcion boton btnModalActExpContinuar");
		$("#btnModalActExpContinuar").attr("disabled","disabled");
		window.location.href = "#modalLoader";
		numeroIntentos = 0;
		numeroArchivos = 0;
		consultaIntervaloImagenes();
	});

	$('#btnModalActExpCancelar').click(function(event){
		event.preventDefault();
		console.log("finaliza proceso de boton btnModalActExpCancelar");
		$("#btnModalActExpCancelar").attr("disabled","disabled");
		window.location.href = "#modalLoader";
		terminarProceso();
	});
	
	$('#btnRecepcionImgBan').click(function(event) {
		event.preventDefault();
		console.log("peticion banorte");
		window.location.href = "#modalLoader";
		$("#btnRecepcionImgBan").attr('disabled','disabled');
		if($("input[name='tipo']").length > 0) {
			event.preventDefault();
			var valoresRadio = $("input[name='tipo']:checked").map(function() {
				return this.value;
			}).get();		
			if(valoresRadio.length == 0) {				
				$("#idTrabajdor").addClass("Invalid_data");
				if($("#idTrabajdor").find("label.Labeltexterror").length == 0) {
					$("#idTrabajdor").append("<label class='Labeltexterror'>Selecciona un tipo de trabajador</label>");
				}
				
			} else {
				$("#idTrabajdor").removeClass("Invalid_data");
				$("#idTrabajdor").find("label.Labeltexterror").remove();
			}
			
			if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
				var solicitanteFiltrado;
				if("10" == SOLICITANTE){
					solicitanteFiltrado = SOLICITANTE;
				}else{
					solicitanteFiltrado = SOLICITANTE.substr(1);
				}
				if(NSS == null || NSS == ""){
					NSS = "00000000000";
				}
				iniciarTablet(FOLIOPADRE,SERVICIO,NSS,CURP,solicitanteFiltrado,'N');
//				iniciarTabletJs(FOLIOPADRE,SERVICIO,AGENTE,AMBIENTE,NSS,CURP,solicitanteFiltrado,'N');
				consultaIntervaloImagenes();
			}else{
				$("form#fm_recepcionImagen #btnRecepcionImgBan").removeAttr("disabled");
			}
		}
	});
	
	
	$('#btnRecepcionImgCop').click(function(event) {
		console.log("peticion coppel");
		window.location.href = "#modalLoader";
		if($("input[name='tipo']").length > 0) {
			$("#btnRecepcionImgCop").attr("disabled", "true");
			event.preventDefault();
			var valoresRadio = $("input[name='tipo']:checked").map(function() {
				return this.value;
			}).get();		
			if(valoresRadio.length == 0) {				
				$("#idTrabajdor").addClass("Invalid_data");
				if($("#idTrabajdor").find("label.Labeltexterror").length == 0) {
					$("#idTrabajdor").append("<label class='Labeltexterror'>Selecciona un tipo de trabajador</label>");
				}
				
			} else {
				$("#idTrabajdor").removeClass("Invalid_data");
				$("#idTrabajdor").find("label.Labeltexterror").remove();
			}
		
			if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
				var solicitanteFiltrado;
				if("10" == SOLICITANTE){
					solicitanteFiltrado = SOLICITANTE
				}else{
					solicitanteFiltrado = SOLICITANTE.substr(1);
				}
				
				if(NSS == "" || NSS == null){
					NSS = "0";
				}
				
				if(FLUJODIGITALIZADOR == "" || FLUJODIGITALIZADOR == null){
					NSS = "0";
				}
				var PAGOBANCO = "0";
				var digita = {			
						folioProcesar : FOLIOPADRE,
						proceso : SERVICIO,
						curpTitular:CURP,
						nssTitular:NSS,
						curpSolicitante:"0",
						tipoSoliciante:solicitanteFiltrado,
						idRFCModificado:CAMBIORFC,
						idSesion:IDSESION,
						pagoBanco:PAGOBANCO,
						tipoFlujo:FLUJODIGITALIZADOR
					};
						
						SignInicio(JSON.stringify(digita));
//						continuarProceso();
			}else{
				$("form#fm_recepcionImagen #btnRecepcionImgCop").removeAttr("disabled");
			}
		}
	});

	
	if(AFORE != "530" && AFORE != "568"){
		console.log("validacion de afore para imagenes");
		var file = $('input:file').on('change',function(e){
//		var file = $(document).on('change','input[type="file"]',function(e){
		var check = $('input[type="checkbox"]');
		var valido = true;
		if(e.target.files.length != 0) {
			var auxFile = e.target.files[0];
			var ext = auxFile.name.split('.').pop().toLowerCase();
			if(ext != "jpg" && ext != "png" && ext != "jpeg" && ext != "pdf" && ext != "tif") {
				e.target.value = '';
			}
			if(1048576 < auxFile.size) {
				e.target.value = '';
			}
		}
	});
	
	$('#btnIdentificacion').click(function(event) {
		window.location.href = "#modalLoader";
		if($("input[name='tipo']").length > 0) {
			$("#btnIdentificacion").attr("disabled", "true");
			var $form = $(this).parents("#fm_identificacion");		
			event.preventDefault();
				var valoresRadio = $("input[name='tipo']:checked").map(function() {
					return this.value;
				}).get();		
				if(valoresRadio.length == 0) {				
					$("#idTrabajdor").addClass("Invalid_data");
					if($("#idTrabajdor").find("label.Labeltexterror").length == 0) {
						$("#idTrabajdor").append("<label class='Labeltexterror'>Selecciona un tipo de trabajador</label>");
					}
					
				} else {
					$("#idTrabajdor").removeClass("Invalid_data");
					$("#idTrabajdor").find("label.Labeltexterror").remove();
				}
				
				if ($(".Inputerror").length == 0 && $(".Invalid_data").length == 0) {
					var archivosSolicitado = $('input[type="file"]').length;
					var archivos = 0;
					for(var i = 0; i < archivosSolicitado; i++) {
						if($('input[type="file"]').get(i).files.length != 0) {
							archivos += 1;
						}
					}
					$("#btnIdentificacion").attr("disabled",false);
					if(archivos != 0) {
						if(archivos == archivosSolicitado) {
							form = $("#fm_identificacion")[0];
							data = new FormData(form);
							$.ajax({
								method      : "POST",
								url         : "convertirArchivos.do",
								enctype		: "multipart/form-data",
								processData	: false,
								contentType	: false,
								data		: data
							}).success(function(resultado) {
								  console.log(resultado);
								for(let i = 0;i < resultado.length;i++){
									agregarImagenVisor(resultado[i].contenidoDocumento, resultado[i].nombreDocumento);
					
								}
								$("#carruselDocumentosModal").show();
					            window.location.href="#carruselDocumentosModal";
					
								
							});
						} else {
							imaValida = 1;
							consultaMensajeRechazo("E015");
						}
					}else{
//						$("#fm_identificacion").submit();
						imaValida = 1;
						consultaMensajeRechazo("E016");
					}
					
					//$form.submit();
				}else{
					$("form#fm_identificacion #btnIdentificacion").removeAttr("disabled");
				}
		}
	});
	
	$(document).on('change','input:file',function(e){
		console.log("valida cambio en el change de input file de la pagina");
		var check = $('input:checkbox');
		var valido = true;
		if(e.target.files.length != 0) {
			var auxFile = e.target.files[0];
			var ext = auxFile.name.split('.').pop().toLowerCase();
			if(ext != "jpg" && ext != "png" && ext != "jpeg" && ext != "pdf" && ext != "tif") {
				e.target.value = '';
			}
			if(1048576 < auxFile.size) {
				e.target.value = '';
			}
		}
	});	

		
}
	
});

function respuestaAceptadaVisorDoc(){
	console.log("acepta visor imagenes");
	$("#btnIdentificacion").attr("disabled",false);
	window.location.href = "#modalLoader";
	$("#fm_identificacion").submit();
	window.location.href = "#modalLoader";
}

function respuestaCancelarVisorDoc(){
	console.log("cancela visor imagenes");
	window.location.href = "#";
	$("#cancelarImagenCarrusel").removeAttr("disabled");
	$("#btnIdentificacion").attr("disabled",false);

}


//function continuarBusqueda(){
//	console.log("ejecucion de proceso de recepcion boton btnModalActExpContinuar");
//	$("#btnModalActExpContinuar").attr("disabled","disabled");
//	window.location.href = "#modalLoader";
////	event.preventDefault();
//	numeroIntentos = 0;
//	numeroArchivos = 0;
//	 consultaIntervaloImagenes();
//}
//
//function cancelarBusqueda(){
//	console.log("finaliza proceso de boton btnModalActExpCancelar");
//	$("#btnModalActExpCancelar").attr("disabled","disabled");
//	window.location.href = "#modalLoader";
////	event.preventDefault();
//	terminarProceso();
//}

function terminarProceso(){
	console.log("termina proceso");
	$.ajax({
		url : 'terminarFolio.do',
		type : "GET",
		contentType : 'application/json',
		dataType: 'json',
		data : {
			idFolio : IDFOLIO_HIJO,
			estatus : "2"
		}
	}).success(function(resultado) {
		$(location).attr('href', 'datosGenerales.do');
	})
}

function continuarProceso(){
	console.log("continuar proceso");
	numeroIntentos = 0;
	numeroArchivos = 0;
	consultaIntervaloImagenes();
}

function consultaIntervaloImagenes(){
	window.location.href = "#modalLoader";
	console.log("consulta de recpecion de archivos limitado por tiempo");
	setTimeout(cosultaRecepcionImagenes, 30000);
}

function cosultaRecepcionImagenes(){
	console.log("entra al proceso de validacion de recepcion de imagenes ");
	numeroIntentos++;
	console.log(numeroIntentos);
	$.ajax({
		url : 'consultarRecepcionImagenes.do',
		type : "GET",
		contentType : 'application/json',
		dataType: 'json',
		data : {
			folioPadre : FOLIOPADRE,
			cvProceso : SERVICIO,
			estatus : "1"
		}
	}).success(function(recepcion) {
		console.log(recepcion);
		if(recepcion != null){
			console.log("finaliza proceso de recepcion de imagenes.");
			window.location.href = "#";
			$("#fm_recepcionImagen").submit();
		}else{
			console.log("valida numero de intentos");
			if(numeroIntentos == Number(INTENTOS)){
				console.log("numero intentos agotado, muestra modal");
				window.location.href = "#";
				var tituloModal = "<h2 class='ModalTitle' >Solicitud</h2>";
				var mensajeModal = "Aun no se han encontrado archivos ¿Desea continuar con el tramite?";
				$('#tituloActExp').empty();
				$('#mensajeActExp').empty();
				$('#tituloActExp').append(tituloModal);
				$('#mensajeActExp').append(mensajeModal);
				$('#botonesModalActExp').show();
				window.location.href = "#modalActExp";
			} else {
				console.log("nuevo intento para recepcion de imagenes");
				setTimeout(cosultaRecepcionImagenes, 30000);
			}
		}
	})
}

function validarExpediente() {
	console.info("Valida la respuesta de recepcion de archivos");
	$.ajax({
		method      : "GET",
		url         : "respuestaWS.do",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			$("#btnExitoM").attr('href', _FUN);
			document.getElementById('tituloExito').innerHTML = data.titulo;
			document.getElementById('mensajeExito').innerHTML = data.mensaje;
			window.location.href = "#exitoModal";
			$("#btnExitoM").removeAttr("disabled");
		} else if(data.flujo == 2) {
			$("#btnErrorM").attr('href', _FUN);
			document.getElementById('tituloError').innerHTML = data.titulo;
			document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
			window.location.href = "#errorModal";
			$("#btnErrorM").removeAttr("disabled");
		} else if(data.flujo == 3) {
			console.log("espera nuevo lanzamiento para validar solicitud");
			setTimeout(validarExpediente, 10000);
		} else if(data.flujo == 4) {
			$("#botonesInfoModal").css("display", "block");
			$("#btnInfoM").css('display', "none");
			$("#btnInfoModal").removeAttr("disabled");
			$("#btnInfoModals").css("display", "none");
			document.getElementById('tituloInfo').innerHTML = data.titulo;
			document.getElementById('mensajeInfo').innerHTML = data.mensaje;
			window.location.href = "#infoModal";
		} 
	});
}

var continuarCambioNombre = 0;
function cambiaNombre(event, clave){
	if(event.target.files.length != 0) {
		var auxFile = event.target.files[0];
		var ext = auxFile.name.split('.').pop().toLowerCase();
		validaExtension(ext, event);
		if(continuarCambioNombre == 0) {
			validaTamanio(event);
			if(continuarCambioNombre == 0){
				var archivo = $('#input'+clave).val().replace(/.*(\/|\\)/, '');
				console.log(archivo);
				console.log($('#fileLabelText'+clave).text());
				console.log($('#hid'+clave).val());
				if(archivo == ''){
					hidText = $('#hid'+clave).val();
					$('#fileLabelText'+clave).text(hidText);
				}else{
					$('#fileLabelText'+clave).text(archivo);
				}
			}
		}
	}
}

function validaExtension(ext, e) {
	continuarCambioNombre = 0;
	if(ext != "jpg" && ext != "png" && ext != "jpeg" && ext != "pdf" && ext != "tif") {
		e.target.value = '';
		
		imaValida = 1;
		continuarCambioNombre = 1;
		consultaMensajeRechazo("E018");
	}
}

function validaTamanio(e) {
	continuarCambioNombre = 0;
	var auxFile = e.target.files[0];
	if(1048576 < auxFile.size) {
		e.target.value = '';
		
		imaValida = 1;
		continuarCambioNombre = 1;
		consultaMensajeRechazo("E017");
	}
}

function consultaMensajeRechazo(rechazo){
	console.log("consulta mensaje");
	$.ajax({
		url : 'catalogoMensajes.do',
		type : "GET",
		contentType : 'application/json',
		dataType: 'json',
		data : {codigo : rechazo}
	}).success(function(resultado) {
		if(resultado.flujo == 1) {
			$("#botonesInfoModalDoble").css("display", "none");
			$("#botonesInfoModal").css("display", "block");
			$("#btnInfoM").css('display', "none");
			$("#btnInfoModal").removeAttr("disabled");
			$("#btnInfoModals").css("display", "none");
			document.getElementById('tituloInfo').innerHTML = resultado.titulo;
			document.getElementById('mensajeInfo').innerHTML = resultado.mensaje;
			window.location.href = "#infoModal";
		}
	})
}