/**
 * Clase que contiene las validaciones de un formulario
**/
var $funciones_generales = {
	validaciones: function($formulario) {
		var $_this = this;
		var $valores = [
			"data-not-null",
			"data-confirm",
			"data-confirm-no-req",
			"data-numeros",
			"data-alfanumerico-space",
			"data-email",
			"data-contrasenia",
			"data-celular",
			"data-captcha",
			"data-usuario",
			"data-cel-null",
			"data-email-opcional",
			"data-curp-nss",
			"data-cuenta",
			"data-clabe"
		];
		var $status = 0;
		for (var $i = 0; $i < $valores.length; $i++) {
			$formulario.find("[" + $valores[$i] + "]:visible").each(function() {
				var $valido = false;
				var $mensaje = "";
				switch ($valores[$i]) {
				case "data-not-null":
					$valido = $_this.validacion_not_null($(this).val());
					$mensaje = "La captura de " + $(this).data("nombre") + " es requerida";
					if($(this).attr("id") == "claveAfore") {
						$mensaje = "Seleccione una " + $(this).data("nombre") + " correcta";
					}
					break;
				case "data-confirm":
					$valido = $_this.validacion_not_null($(this).val());
					$mensaje = "La captura de " + $(this).data("nombre") + " es requerida";
					if($valido) {
						var dato = "#" + $(this).data("confirm");
						$valido = $(this).val() == $(dato).val();
						$mensaje = "No coincide con tu " + $(this).data("nombre") + " capturado";
						if ($(this).attr("id") == "confirmaContrasenia" ) {
							$mensaje = "No coincide con tu " + $(this).data("nombre") + " capturada";
						}
					}
					break;
				case "data-confirm-no-req":					
					var dato = "#" + $(this).data("confirm-no-req");
					$valido = $(this).val() == $(dato).val();
					$mensaje = "No coincide con tu " + $(this).data("nombre") + " capturado";
					if ($(this).attr("id") == "confirmaContrasenia" ) {
						$mensaje = "No coincide con tu " + $(this).data("nombre") + " capturada";
					}					
					break;
				case "data-numeros":
					$valido = $_this.validacion_solo_numeros_formato($(this).val());
					$mensaje = "El formato " + $(this).data("nombre") + " es inválido"
					break;
				case "data-alfanumerico-space":
					$valido = $_this.validacion_alfanumerico_space_formato($(this).val());
					$mensaje = "Ingresa un " + $(this).data("nombre") + " válido";
					if ($(this).attr("id") == "contrasenia" ) {
						$mensaje = "Ingresa una " + $(this).data("nombre") + " válida";
					}
					break;
				case "data-email":
					$valido = $_this.validacion_not_null($(this).val());
					$mensaje = "La captura de " + $(this).data("nombre") + " es requerida";
					if($valido) {
						$valido = $_this.validacion_email_formato($(this).val());
						$mensaje = "Formato de " + $(this).data("nombre") + " incorrecto";
					}
					break;
				case "data-contrasenia":
					$valido = $_this.validacion_contrasenia($(this).val());
					$mensaje = "La contraseña no cumple con las características necesarias";
					if ($(this).attr("id") == "contrasenia" || $(this).attr("id") == "confirmaContrasenia" 
						|| $(this).attr("id") == "contraseniaActual" || $(this).attr("id") == "contraseniaLogin") {
						$valido = $_this.validacion_data_longitud_8_a_13($(this).val());
					}
					break;
				case "data-captcha":
					$valido = compareCaptcha();
					$mensaje = "Captcha inválido";
					break;
				case "data-usuario":
					$mensaje = "Ingresa un Usuario válido";
					$valido = $_this.validacion_solo_numeros_formato($(this).val());
					if(!$valido) {
						$valido = $_this.validacion_email_formato($(this).val());
					}
					break;
				case "data-cel-null":
					$valido = $_this.validacion_not_null($(this).val());
					$mensaje = "La captura del " + $(this).data("nombre") + " es requerida";
					if($valido) {
						$valido = $_this.validacion_solo_numeros_formato($(this).val());
						$mensaje = "El formato " + $(this).data("nombre") + " es inválido"
						if($valido) {
							$valido = $(this).val().length == 10;
							$mensaje = "No cumple con la longitud establecida";
						}
					}
					break;
				case "data-email-opcional":
					$valido = $_this.validacion_not_null($(this).val());
					if($valido) {
						$valido = $_this.validacion_email_formato($(this).val());
						$mensaje = "Formato de " + $(this).data("nombre") + " incorrecto";
					} else {
						$valido = true;
					}
					break;
				case "data-clabe":
					$valido = $_this.validacion_not_null($(this).val());
					$mensaje = "La captura del " + $(this).data("nombre") + " es requerida";
					if($valido) {
						$valido = $_this.validacion_data_longitud_4_a_18($(this).val());
						$mensaje = "La longitud " + $(this).data("nombre") + " es inválido"
					}
					break;
				case "data-cuenta":
					$valido = $_this.validacion_not_null($(this).val());
					$mensaje = "La captura del " + $(this).data("nombre") + " es requerida";
					if($valido) {
						$valido = $_this.validacion_data_longitud_4_a_10($(this).val());
						$mensaje = "La longitud " + $(this).data("nombre") + " es inválido"
					}
					break;
				case "data-curp-nss":
					$valido = true;
					$(this).removeClass("Invalid_data");
					$(this).removeClass("Inputerror");
					$(this).parents(".Form__Group:first").find("label.Labeltexterror").remove();
					
					var nss = $("#idNssConsulta").val();
					var curp = $("#idCurpConsulta").val();
					if(!$_this.validacion_not_null(curp) && !$_this.validacion_not_null(nss)) {
						$valido = false;
						$mensaje = "La captura de NSS o CURP es requerida";
					} else {
						if($(this).attr("id") == "idCurpConsulta" && $_this.validacion_not_null(curp)) {
							$valido = $_this.validacion_curp($(this).val());
							$mensaje = "El formato del CURP es inválido";
						}
						if($(this).attr("id") == "idNssConsulta" && $_this.validacion_not_null(nss)) {
							$valido = $_this.validacion_solo_numeros_formato($(this).val());
							$mensaje = "El formato del NSS es inválido";
							if($valido) {
								$valido = $(this).val().length == 11;
							}
						}
					}
			}
				
				$(this).val($_this.quitar_espacios_inicio_fin($(this).val()));
				if (!$valido) {
					++$status;
					if ($(this).attr("id") == "claveAfore" || $(this).attr("id") == "idNssConsulta" || $(this).attr("id") == "idCurpConsulta") {
						$(this).addClass("Invalid_data");
					} else if($(this).attr("id") == "contraseniaLogin" || $(this).attr("id") == "loginUser") {
						$(this).addClass("Inputerror");
					} else {
						$(this).addClass("Inputerror");
					}
					
					if($(this).attr("id") == "contraseniaLogin" || $(this).attr("id") == "loginUser") {
						if($(this).parents(".Form__Group").find("label.Labeltexterror").length == 0) {
							$(this).parents(".Form__Group:first").find("label.Labeltexterror").remove();
							$(this).parents(".Form__Group:first").append($_this.mensaje1($mensaje));
							$(this).parents(".Form__Group:first").find("label.Labeltexterror").attr('data-check', $i);
						}
					} else {
						if($(this).parents(".Form__Group").find("label.Labeltexterror").length == 0) {
							$(this).parents(".Form__Group:first").find("label.Labeltexterror").remove();
							$(this).parents(".Form__Group:first").append($_this.mensaje($mensaje));
							$(this).parents(".Form__Group:first").find("label.Labeltexterror").attr('data-check', $i);
						} 
					}
				} else if ($(this).parents(".Form__Group").find("label.Labeltexterror").data("check") == $i || $(this).parents(".Form__Group").find("label.Labeltexterror").data("check") == $i) {
					$(this).removeClass("Inputerror");
					$(this).parents(".Form__Group:first").find("label.Labeltexterror").remove();
				}
			});
		}
		return ($status == 0) ? true : false;
	},
	validacion_not_null: function() {
		if (!arguments[0])
			return false;
		return true;
	},
	validacion_solo_numeros_formato: function() {
		return (arguments[0].match(/^[\d]*\d$/i)) ? true : (arguments[0] == "") ? true : false;
	},
	validacion_alfanumerico_space_formato: function() {
		return (arguments[0].match(/^([a-zA-Z0-9ñÑáéíóúÁÉÍÓÚäëïöüÄËÏÖÜ\.\s])*$/)) ? true : false;
	},
	validacion_email_formato: function() {
		return (arguments[0].match(/^[A-Z0-9_,\.-]+@[A-Z0-9_,\.-]+\.[A-Z]{1,4}/i)) ? true : false;
	},
	validacion_data_longitud_8_a_13: function() {
		return (arguments[0].match(/^.{8,13}$/i)) ? true : false;
	},
	validacion_contrasenia: function() {
		return (arguments[0].match(/^((?=.*[0-9])(?=.*[A-Z])(?=.*[#$%*¡!¿?/{}[\]=+\-_@;:]))[0-9a-zA-Z#$%*¡!¿?/{}[\]=+\-_@;:ñÑáéíóúÁÉÍÓÚ]{8,10}$/)) ? true : false;
	},
	quitar_espacios_inicio_fin: function() {
		var $expresionRegular = /^\s+|\s+$/g;
		return arguments[0].replace($expresionRegular, "");
	},
	validacion_curp: function() {
		return (arguments[0].match(/^([a-z|A-Z]{4})([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1]))([a-z|A-Z]{6})([0-9A-Z]{1})([0-9]{1})$/i)) ? true : false;
	},
	validacion_numeros: function() {
		var $this = arguments[0];
		var $event = arguments[1];
		var $validacion_extra = [0, 8, 9, 16, 17, 20];
		for (var $i = 48; $i <= 57; $i++)
			$validacion_extra.push($i);
		
		var codeCharacter = $event.charCode || $event.keyCode;
		if (codeCharacter == 0 || codeCharacter == 229) {
			codeCharacter = $this.val().charCodeAt($this.val().length - 1);
        }
		
		if (jQuery.inArray(codeCharacter, $validacion_extra) === -1)
			return false;
		return true;
	},
	validacion_numeros_punto: function() {
		var $this = arguments[0];
		var $event = arguments[1];
		var $validacion_extra = [0, 8, 9, 16, 17, 20];
		$validacion_extra.push(46, 13);
		for (var $i = 48; $i <= 57; $i++)
			$validacion_extra.push($i);
		
		var codeCharacter = $event.charCode || $event.keyCode;
		if (codeCharacter == 0 || codeCharacter == 229) {
			codeCharacter = $this.val().charCodeAt($this.val().length - 1);
        }
		
		if (jQuery.inArray(codeCharacter, $validacion_extra) === -1)
			return false;
		return true;
	},
	validacion_letras_acentos: function() {
		var $this = arguments[0];
		var $event = arguments[1];
		var $validacion_extra = [0, 8, 9, 16, 17, 20];
		$validacion_extra.push(32, 46, 193, 201, 205, 211, 218, 241, 209, 225, 233, 237, 243, 250, 228, 235, 239, 246, 252, 196, 203, 207, 214, 220); /* dieresis, espacio, letras con acentos */
		for (var $i = 65; $i <= 90; $i++)
			$validacion_extra.push($i); /* mayusculas */
		for (var $i = 97; $i <= 122; $i++)
			$validacion_extra.push($i); /* minusculas */

		var codeCharacter = $event.charCode || $event.keyCode;
		if (codeCharacter == 0 || codeCharacter == 229) {
			codeCharacter = $this.val().charCodeAt($this.val().length - 1);
        }
		
		if (jQuery.inArray(codeCharacter, $validacion_extra) === -1)
			return false;
		return true;
	},
	validacion_letras_punto: function() {
		var $this = arguments[0];
		var $event = arguments[1];
		var $validacion_extra = [0, 8, 9, 16, 17, 20];
		$validacion_extra.push(110, 44, 45, 46, 190, 109, 95, 188, 189); /* punto, guion y bajo, coma */
		for (var $i = 48; $i <= 57; $i++)
			$validacion_extra.push($i); /* 0 -9 */
		for (var $i = 65; $i <= 90; $i++)
			$validacion_extra.push($i); /* mayusculas */
		for (var $i = 97; $i <= 122; $i++)
			$validacion_extra.push($i); /* minusculas */

		var codeCharacter = $event.charCode || $event.keyCode;
		if (codeCharacter == 0 || codeCharacter == 229) {
			codeCharacter = $this.val().charCodeAt($this.val().length - 1);
        }
		
		if (jQuery.inArray(codeCharacter, $validacion_extra) === -1)
			return false;
		return true;
	},
	validacion_email: function() {
		var $this = arguments[0];
		var $event = arguments[1];
		var $validacion_extra = [0, 8, 9, 16, 17, 20];
		$validacion_extra.push(209, 241, 189, 16, 190, 81, 64, 95, 45, 46); /* ñ, Ñ */
		for (var $i = 48; $i <= 57; $i++)
			$validacion_extra.push($i); /* 0 -9 */
		for (var $i = 65; $i <= 90; $i++)
			$validacion_extra.push($i); /* mayusculas */
		for (var $i = 97; $i <= 122; $i++)
			$validacion_extra.push($i); /* minusculas */
		
		var codeCharacter = $event.charCode || $event.keyCode;
		if (codeCharacter == 0 || codeCharacter == 229) {
			codeCharacter = $this.val().charCodeAt($this.val().length - 1);
        }
		
		if (jQuery.inArray(codeCharacter, $validacion_extra) === -1)
			return false;
		return true;
	},
	validacion_data_longitud_4_a_18: function() {
		return (arguments[0].match(/^.{4,18}$/i)) ? true : false;
    },
	validacion_data_longitud_4_a_10: function() {
		return (arguments[0].match(/^.{4,10}$/i)) ? true : false;
    },
	validacion_alfanumerico: function() {
		var $this = arguments[0];
		var $event = arguments[1];
		var $validacion_extra = [0, 8, 9, 16, 17, 20];
		$validacion_extra.push(209, 241); /* ñ, Ñ */
		for (var $i = 48; $i <= 57; $i++)
			$validacion_extra.push($i); /* 0 -9 */
		for (var $i = 65; $i <= 90; $i++)
			$validacion_extra.push($i); /* mayusculas */
		for (var $i = 97; $i <= 122; $i++)
			$validacion_extra.push($i); /* minusculas */
		
		var codeCharacter = $event.charCode || $event.keyCode;
		if (codeCharacter == 0 || codeCharacter == 229) {
			codeCharacter = $this.val().charCodeAt($this.val().length - 1);
        }
		
		if (jQuery.inArray(codeCharacter, $validacion_extra) === -1)
			return false;
		return true;
	},
	
	status: false,
	mensaje: function() {
		return "<label class='Labeltexterror'>" + arguments[0] + "</label>";
	},
	mensaje1: function() {
		return "<label class='Labeltexterror'>" + arguments[0] + "</label>";
	}
};