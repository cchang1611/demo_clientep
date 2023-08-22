$(document).ready(function() {
	
	$('[data-alfanumerico-space], [data-alfa-punto], [data-alfanumerico]')
		.blur(function() {
		$(this).val($funciones_generales.quitar_espacios_inicio_fin($(this).val()));
		$(this).val($(this).val().toUpperCase());
	});
		
	$('[data-alfanumerico-space], [data-alfa-punto], [data-alfanumerico]')
			.keydown(function(event) {
		if (navigator.userAgent.match(/Android/i)) {
			$(this).selectRange($(this).val().length);
		}
	});
	
	$('[data-numeros], [data-cel-null], [data-numeros-nss]').keypress(function(event) {
		if (!$funciones_generales.validacion_numeros($(this), event)) {
			event.preventDefault();
		}
	});
	
	$('[data-numeros], [data-cel-null], [data-numeros-nss]').keyup(function(event) {
		if (navigator.userAgent.match(/Android/i)) {
			if(!$funciones_generales.validacion_numeros($(this), event)) {
				$(this).val($(this).val().substr(0, ($(this).val().length - 1)));
			} else {
				$(this).val();
			}
		}
	});
	
	$('[data-ip]').keypress(function(event) {
		if (!$funciones_generales.validacion_numeros_punto($(this), event)) {
			event.preventDefault();
		}
	});
	
	$('[data-ip]').keyup(function(event) {
		if (navigator.userAgent.match(/Android/i)) {
			if(!$funciones_generales.validacion_numeros_punto($(this), event)) {
				$(this).val($(this).val().substr(0, ($(this).val().length - 1)));
			} else {
				$(this).val();
			}
		}
	});
	
	$('[data-alfanumerico-space]').keypress(function(event) {
		if (!$funciones_generales.validacion_letras_acentos($(this), event)) {
			event.preventDefault();
		}
	});
	
	$('[data-alfanumerico-space]').keyup(function(event) {
		if (navigator.userAgent.match(/Android/i)) {
			if(!$funciones_generales.validacion_letras_acentos($(this), event)) {
				$(this).val($(this).val().substr(0, ($(this).val().length - 1)));
			} else {
				$(this).val();
			}
		}
	});
	
	$('[data-alfanumerico]').keypress(function(event) {
		if (!$funciones_generales.validacion_alfanumerico($(this), event)) {
			event.preventDefault();
		}
	});
	
	$('[data-alfanumerico]').keyup(function(event) {
		if (navigator.userAgent.match(/Android/i)) {
			if(!$funciones_generales.validacion_alfanumerico($(this), event)) {
				$(this).val($(this).val().substr(0, ($(this).val().length - 1)));
			} else {
				$(this).val();
			}
		}
	});
	
	$('[data-email]').keypress(function(event) {
		if (!$funciones_generales.validacion_email($(this), event)) {
			event.preventDefault();
		}
	});
	
	$('[data-email]').keyup(function(event) {
		if (navigator.userAgent.match(/Android/i)) {
			if(!$funciones_generales.validacion_email($(this), event)) {
				$(this).val($(this).val().substr(0, ($(this).val().length - 1)));
			} else {
				$(this).val();
			}
		}
	});
	
	$('[data-alfa-punto]').keypress(function(event) {
		if (!$funciones_generales.validacion_letras_punto($(this), event)) {
			event.preventDefault();
		}
	});
	
	$('[data-alfa-punto]').keyup(function(event) {
		if (navigator.userAgent.match(/Android/i)) {
			if(!$funciones_generales.validacion_letras_punto($(this), event)) {
				$(this).val($(this).val().substr(0, ($(this).val().length - 1)));
			} else {
				$(this).val();
			}
		}
	});
	
	$('[noPaste="true"]').bind('paste', function (e) {
		e.preventDefault();
	});
});