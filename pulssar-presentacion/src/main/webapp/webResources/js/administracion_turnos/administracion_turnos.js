$(document).ready(function() {
	
	// Define las constantes para el presente js.
	FLUJO_SESION_CADACUDA          =  "3";
	FLUJO_ERROR_INESPERADO         =  "4";
	FLUJO_ERROR_INESPERADO_MENSAJE =  "5";
	FLUJO_EXITOSO_REGISTRO_TURNO   = "10";
	
	// Define las constantes para Expresiones Regulares.
	var _CURP_REGEX    = /^([a-z|A-Z]{4})([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1]))([a-z|A-Z]{6})([0-9A-Z]{1})([0-9]{1})$/i;
	var _NSS_REGEX     = /^[\d]*\d$/i;
	var _CORREO_REGEX  = /^[A-Z0-9_,\.-]+@[A-Z0-9_,\.-]+\.[A-Z]{1,4}/i;
	var _CELULAR_REGEX = /^[\d]*\d$/i;
	
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	// Inicializa elementos para los componentes para la pantalla de 
	// administración de turnos.
	$("#submitFinalizarTurno").prop('disabled', true);
	
	
	switch (_FLUJO) {
	case FLUJO_SESION_CADACUDA:
		window.location.href = "#sesionCaduacadaModal";
		break;
	case FLUJO_ERROR_INESPERADO:
		window.location.href = "#errorModal";
		break;
	case FLUJO_EXITOSO_REGISTRO_TURNO:
		window.location.href = "#exitoModalAceptar";
		break;
	case FLUJO_ERROR_INESPERADO_MENSAJE:
		window.location.href = "#errorInesperadoMensajeModal";
		break;
	default:
		console.log("El flujo es:"+_FLUJO );
		break;
	}
	
	// Inicio: Evento del click sobre el registro para turnos con cita.
	$("#turnosConCitaId").on("click", "tr td", function(row) {
		
		var objetoCampoFolio = $(this).closest('tr').find('td.folio');
		var classeStr = objetoCampoFolio.attr('class');
		
		if(classeStr.indexOf("autorizado") !== -1) {
			
			var valorFolio = objetoCampoFolio.text();
			var mensajeModal = 'Se tomara el turno ' + valorFolio;
			$("#mensajeModal").text(mensajeModal);
			
			$("#folioServicio").val(valorFolio);
			
			$("#submitFinalizarTurno").prop('disabled', false);
			
			window.location.href = "#finalizaTurnoModal";
		}
		else {
			window.location.href = "#pendientePorFinalizarModal";
		}
		
	});
	// Fin: Evento del click sobre el registro para turnos con cita.
	
	
	// Inicio: Evento del click sobre el registro para turnos sin cita.
	$("#turnosSinCitaId").on("click", "tr td", function(row) {
		
		var objetoCampoFolio = $(this).closest('tr').find('td.folio');
		var classeStr = objetoCampoFolio.attr('class');
		
		if(classeStr.indexOf("autorizado") !== -1) {
			
			var valorFolio = objetoCampoFolio.text();
			var mensajeModal = 'Se tomara el turno ' + valorFolio;
			$("#mensajeModal").text(mensajeModal);
			
			$("#folioServicio").val(valorFolio);
			
			$("#submitFinalizarTurno").prop('disabled', false);
			
			window.location.href = "#finalizaTurnoModal";
		}
		else {
			window.location.href = "#pendientePorFinalizarModal";
		}
		
	});
	// Fin: Evento del click sobre el registro para turnos sin cita.
	
	
	
	// Evento cancelar sobre una ventana modal.
	$("#cancelar").click(function(event) {
		
		$("#botonCerrarModal").get(0).click();
	});
	
	
	
	// Evento para pasar un turno en estatus En Atención.
	$("#submitActualizarTurnoEnAtencion").click(function(event) {
		
		var $form = $(this).parents("#fm_actualizarTurnoEnAtencion");
		$form.submit();
	});
	
	
	$("#id__botonHome").click(function(event) {
		
		menuPrincipal();
	});
	
	$("#btnExitoAceptar").click(function(event) {
		
		menuPrincipal();
	});
	
	function menuPrincipal(){
		window.location = 'menuPrincipal.do';
	}
	
	
	/******************************************************
	 * 
	 * Inicio: Validaciones para la forma registrar Turno.
	 * 
	 ******************************************************/
	var capturaCurpValida = false;
	$("#id__curp").blur(function() {
		
		$("#labelErrorCurp").text("");
		
		$("#labelErrorCurp").css("display", "none");
		capturaCurpValida = true;
		
		var curp = $("#id__curp").val();
			
		if(curp == "") {
			
			$("#labelErrorCurp").text("La captura del CURP es requerida");
			$("#labelErrorCurp").css("display", "block");
			capturaCurpValida = false;
		}
		else if(!curp.match(_CURP_REGEX)){
			$("#labelErrorCurp").text("El formato del CURP es inválido");
			$("#labelErrorCurp").css("display", "block");
			capturaCurpValida = false;
		}
		
		$("#id__curp").val(
				$("#id__curp").val().toUpperCase()
		);
	});
	
	var capturaNssValida = true;
	$("#id__nss").blur(function() {
		
		$("#labelErrorNss").text("");
		$("#labelErrorNss").css("display", "none");
		capturaNssValida = true;
		
		var nss = $("#id__nss").val();
		if(nss != "") {
			if(!nss.match(_NSS_REGEX) || nss.length < 11){
				$("#labelErrorNss").text("El formato del NSS es inválido");
				$("#labelErrorNss").css("display", "block");
				capturaNssValida = false;
			}
		}
		
		$("#id__nss").val(
			$("#id__nss").val().toUpperCase()
		);
	});
	
	var capturaNombreValida = false;
	$("#id__nombre").blur(function() {
		
		$("#labelErrorNombre").text("");
		$("#labelErrorNombre").css("display", "none");
		capturaNombreValida = true;
		
		var nombre = $("#id__nombre").val();
		if(nombre == "") {
			$("#labelErrorNombre").text("La captura del nombre es requerida");
			$("#labelErrorNombre").css("display", "block");
			capturaNombreValida = false;
		}
		
		$("#id__nombre").val(
				$("#id__nombre").val().toUpperCase()
		);
	});
	
	var capturaApellidoPaternoValida = false;
	$("#id__apellidoPaterno").blur(function() {
		
		$("#labelErrorApPaterno").text("");
		$("#labelErrorApPaterno").css("display", "none");
		capturaApellidoPaternoValida = true;
		
		var apellidoPaterno = $("#id__apellidoPaterno").val();
		if(apellidoPaterno == "") {
			$("#labelErrorApPaterno").text("La captura del apellido paterno es requerida");
			$("#labelErrorApPaterno").css("display", "block");
			capturaApellidoPaternoValida = false;
		}
		
		$("#id__apellidoPaterno").val(
				$("#id__apellidoPaterno").val().toUpperCase()
		);
	});
	
	$("#id__apellidoMAterno").blur(function() {
		
		$("#id__apellidoMAterno").val(
				$("#id__apellidoMAterno").val().toUpperCase()
		);
	});
	
	var capturaCorreoValida = true;
	$("#id__correo").blur(function() {
		
		$("#labelErrorCorreo").text("");
		$("#labelErrorCorreo").css("display", "none");
		capturaCorreoValida = true;
		
		var correo = $("#id__correo").val();
		if(correo != "") {
			if(!correo.match(_CORREO_REGEX)){
				$("#labelErrorCorreo").text("El formato del Correo es inválido");
				$("#labelErrorCorreo").css("display", "block");
				capturaCorreoValida = false;
			}
		}
	});
	
	var capturaCelularValida = true;
	$("#id__celular").blur(function() {
		
		$("#labelErrorCelular").text("");
		$("#labelErrorCelular").css("display", "none");
		capturaCelularValida = true;
		
		var celular = $("#id__celular").val();
		if(celular != "") {
			if(!celular.match(_CELULAR_REGEX) || celular.length < 10){
				$("#labelErrorCelular").text("El formato del Celular es inválido");
				$("#labelErrorCelular").css("display", "block");
				capturaCelularValida = false;
			}
		}
		
		$("#id__celular").val().toUpperCase();
	});
	
	var capturaServicioSolicitadoValida = false;
	$("#id__servicioSolicitado").blur(function() {
		
		$("#labelErrorServicios").text("");
		$("#labelErrorServicios").css("display", "none");
		capturaServicioSolicitadoValida = true;
		
		var servicioSolicitado = $("#id__servicioSolicitado").val();
		if(servicioSolicitado == "") {
			$("#labelErrorServicios").text("La captura del servicio solicitado es requerida");
			$("#labelErrorServicios").css("display", "block");
			capturaServicioSolicitadoValida = false;
		}
	});
	
	var capturaSolicitanteValida = false;
	$("#id__solicitante").blur(function() {
		
		$("#labelErrorSolicitante").text("");
		$("#labelErrorSolicitante").css("display", "none");
		capturaSolicitanteValida = true;
		
		var solicitante = $("#id__solicitante").val();
		if(solicitante == "") {
			$("#labelErrorSolicitante").text("La captura del servicio solicitado es requerida");
			$("#labelErrorSolicitante").css("display", "block");
			capturaSolicitanteValida = false;
		}
	});
	
	
	
	/**
	 * Asignación de Turno.
	 */
	$("#id__asignarTurno").click(function(event) {
		
		$("#id__curp").blur();
		$("#id__nss").blur();
		$("#id__nombre").blur();
		$("#id__apellidoPaterno").blur();
		$("#id__correo").blur();
		$("#id__celular").blur();
		$("#id__servicioSolicitado").blur();
		$("#id__solicitante").blur();
		
		if(!capturaCurpValida) {
			$("#id__curp").focus();
			return;
		}
		
		if(!capturaNssValida) {
			$("#id__nss").focus();
			return;
		}
		
		if(!capturaNombreValida) {
			$("#id__nombre").focus();
			return;
		}
		
		if(!capturaApellidoPaternoValida) {
			$("#id__apellidoPaterno").focus();
			return;
		}
		
		if(!capturaCorreoValida) {
			$("#id__correo").focus();
			return;
		}
		
		if(!capturaCelularValida) {
			$("#id__celular").focus();
			return;
		}
		
		if(!capturaServicioSolicitadoValida) {
			$("#id__servicioSolicitado").focus();
			return;
		}
		
		if(!capturaSolicitanteValida) {
			$("#id__solicitante").focus();
			return;
		}
		$("#submitRegistroTurno").removeAttr("disabled");		
		window.location.href = "#confirmacionRegistroTurno";		
	});
	
	$("#submitRegistroTurno").click(function(event) {
		
		habilitarComponentes();

		$("#submitRegistroTurno").prop("disabled", true);
		var $form = $(this).parents("#fm_asiganarTurno");
		$form.submit();
		
		event.preventDefault();
	});
	/******************************************************
	 * 
	 * Fin: Validaciones para la forma registrar Turno.
	 * 
	 ******************************************************/
	
	function habilitarComponentes() {
		
		$("#id__curp").removeAttr("disabled");
		$("#id__nss").removeAttr("disabled");
		$("#id__nombre").removeAttr("disabled");
		$("#id__apellidoPaterno").removeAttr("disabled");
		$("#id__apellidoMAterno").removeAttr("disabled");
		$("#id__correo").removeAttr("disabled");
		$("#id__celular").removeAttr("disabled");
	}
	
	
	/****************************************************
	 * 
	 * Incio: valida turno 
	 * 
	 ***************************************************/
	
	$("#id__cus__valida").val('');
	$("#id__curp_valida").val('');
	$("#id__nss_valida").val('');
	
	$("#id_botonValidaTurno").click(function(event) {
		
		// limpia los mensajes
		$("#labelErrorCurpValida").css("display", "none");
		$("#labelErrorNssValida").css("display", "none");
		
		var valorCusValidaTurno  = $("#id__cus__valida").val();
		var valorCurpValidaTurno = $("#id__curp_valida").val();
		var valorNssValidaTurno  = $("#id__nss_valida").val();
		
		if(valorCurpValidaTurno != '') {
			if(!valorCurpValidaTurno.match(_CURP_REGEX)) {
				$("#labelErrorCurpValida").text("El formato del CURP es inválido");
				$("#labelErrorCurpValida").css("display", "block");
				$("#id__curp_valida").focus();
				return;
			}
		}
		else if(valorNssValidaTurno != '') {
			if(!valorNssValidaTurno.match(_NSS_REGEX) || valorNssValidaTurno.length < 11){
				$("#labelErrorNssValida").text("El formato del NSS es inválido");
				$("#labelErrorNssValida").css("display", "block");
				$("#id__nss_valida").focus();
				return;
			}
		}
		
		var $form = $(this).parents("#fm_validaTurno");
		$form.submit();
		
		event.preventDefault();
	});
	
	
	$("#id__cus__valida").keyup(function() {
		inhabilitarCamposDistintosCus();
	});
	
	$("#id__curp_valida").keyup(function() {
		
		$("#id__curp_valida").val(
				$("#id__curp_valida").val().toUpperCase()
		);
		
		inhabilitarCamposDistintosCurp();
	});
	
	$("#id__nss_valida").keyup(function() {
		inhabilitarCamposDistintosNss();
	});
	
	function inhabilitarCamposDistintosCus() {
		
		var valorCus = $("#id__cus__valida").val();
		
		if(valorCus == "") {
			$("#id__curp_valida").removeAttr("disabled");
			$("#id__nss_valida").removeAttr("disabled");
		}
		else {
			$("#id__curp_valida").prop("disabled", true);
			$("#id__nss_valida").prop("disabled", true);
		}
	}
	
	function inhabilitarCamposDistintosCurp() {
		
		var valorCurp = $("#id__curp_valida").val();
		
		if(valorCurp == "") {
			$("#id__cus__valida").removeAttr("disabled");
			$("#id__nss_valida").removeAttr("disabled");
		}
		else {
			
			$("#id__cus__valida").prop("disabled", true);
			$("#id__nss_valida").prop("disabled", true);
		}
	}
	
	function inhabilitarCamposDistintosNss() {
		
		var valorNss = $("#id__nss_valida").val();
		
		if(valorNss == "") {
			$("#id__cus__valida").removeAttr("disabled");
			$("#id__curp_valida").removeAttr("disabled");
		}
		else {
			$("#id__cus__valida").prop("disabled", true);
			$("#id__curp_valida").prop("disabled", true);
			
		}
	}
	
});
