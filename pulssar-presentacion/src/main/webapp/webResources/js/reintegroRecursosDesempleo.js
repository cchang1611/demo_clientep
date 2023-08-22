/*
 * Documento ready
 */
$(document).ready(function() {
	if (_FLUJO == "2") {
		window.location.href = "#errorModal";
	} else if (_FLUJO == "3") {
		window.location.href = "#infoModal";
		$("#btnInfoM").attr('href', "modificaTrabajador.do");
	} else if (_FLUJO == "4") {
		window.location.href = "#infoModal";
		$("#botonesInfoModalDoble").css("display", "block");
		$("#fm_identificacion").attr('action', "amenu.do");
	} else if (_FLUJO == "5") {
		setTimeout(validarExpediente, 10000);
		window.location.href = "#infoModal";
		$("#btnInfoM").attr('href', "#modalLoader");
	} else if (_FLUJO == "0") {
		window.location.href = "#exitoModalAceptar";
	}
	
	$("#btnExitoAceptar").click(function() {
		$("#terminarTramite").submit();
	});
	
	$("#btnCerrarDatosReferenciaPdf").click(function() {
		mandarNotificacion();
	});
	
	/**
	 * Selecionar resolucion
	 */
	$("#tableReintegro tr").click(function() {
		//Disabled btn generar referencfia
		$("#btnGenerarReferencia").prop("disabled", true);
		$("#btnGenerarReferencia").addClass("Submit_disabled");
		$("#btnGenerarReferencia").removeClass("Submitxl");
		
		$(this).siblings().find("input[type='text']").prop("disabled", true);
		$(this).siblings().find("input[type='text']").val("");
		$(".filaSelecionada td").last().html("");
		$(this).siblings().removeClass("filaSelecionada");
		$(this).addClass("filaSelecionada");
		$(this).find("input[type='text']").prop("disabled", false);
		$(this).find("input[type='text']").focus();
		$("#btnCalcular").prop("disabled", false);
		$("#btnCalcular").addClass("Submit");
		$("#btnCalcular").removeClass("Submit_disabled");
	});

	/**
	 * Calcular Semanas
	 */
	$("#btnCalcular").click(
			function() {
				var entrada = new CalculoMontoReintegrar();

				if (entrada.numeroSemanasReintegrar === undefined) {
					$("#mensajeErrorModal").text(
							"Seleciona una resolucion para calcular");
					window.location.href = "#errorModal";
				} else if (entrada.numeroSemanasReintegrar == ""
						|| entrada.numeroSemanasReintegrar == "0") {
					$("#mensajeErrorModal").text(
							"Cantidad de semanas por reintegrar esta vacio");
					window.location.href = "#errorModal";
				} else {
					obtenerCalculoMontoReintegrar(entrada);
				}
			});
});

/**
 * Llamado al servicio de calculo de monto
 * 
 * @param entrada
 */
function obtenerCalculoMontoReintegrar(entrada) {
	window.location.href = "#modalLoader";
	$.ajax({
		method : "POST",
		contentType : "application/json",
		data : JSON.stringify(entrada),
		dataType : "json",
		url : "./obtenerCalculoMontoReintegrar",
		success : function(salida) {
			if (salida.diagnosticoDeRecepcion != "01") {
				$("#mensajeErrorModal").text(salida.resultadoDeLaOperacion);
				window.location.href = "#errorModal";
				$(".filaSelecionada td").last().html("");
				$("#btnGenerarReferencia").prop("disabled", true);
				
				if(!$("#btnGenerarReferencia").hasClass("Submit_disabled")){
					$("#btnGenerarReferencia").addClass("Submit_disabled");
				 }
				
			} else {
				window.location.href = "#";
				$(".filaSelecionada td").last().html(salida.objetoRespuesta.montoReintegrar);
				$("#btnGenerarReferencia").prop("disabled", false);
				$("#btnGenerarReferencia").addClass("Submitxl");
				$("#btnGenerarReferencia").removeClass("Submit_disabled");
			}
			$(".filaSelecionada").focus();
		},
		error : function(salida) {
			$("html").html(salida.responseText);
		}
	});
}

/**
 * Llamado al servicio de calculo de monto
 * 
 * @param entrada
 */
function mandarNotificacion() {
	window.location.href = "#modalLoader";
	$.ajax({
	   url: './generarNotificacionHistorico.do',
	   type: 'PUT'
	}).done(function(){
		window.location.href = '#miModal2';
	}).fail(function(){
		window.location.href = '#miModal2';
	});
}

/**
 * Prototype CalculoMontoReintegrar
 */
function CalculoMontoReintegrar() {
	var tds = $(".filaSelecionada td");
	var filaSelecionada = $(".filaSelecionada");

	if (tds == null || tds.length < 1) {
		return null;
	}

	if (filaSelecionada == null || filaSelecionada.length < 1) {
		return null;
	}

	this.numeroResolucion = tds.get(0).innerHTML;
	this.claveAfore = "";
	this.fechaRetiro = filaSelecionada.attr("data-fecha");
	this.nssTrabajador = "";
	this.numeroSemanasReintegrar = tds.find("#semanasPagar").val();
}

/**
 * Preparar pantalla de attachment
 * @param resolucion
 */
function submitAdjuntar(resolucion, noParcialiad){
	$("#inputResolucion").val(resolucion);
	$("#inputNumeroReintegro").val(noParcialiad);
	$("#formAdjuntar").submit();
}
