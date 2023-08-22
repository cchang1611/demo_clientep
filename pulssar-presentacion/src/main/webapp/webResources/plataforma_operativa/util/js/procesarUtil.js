/**
 * JavaScript que contiene funciones de utileria para el aplicativo
 * 
 * @autor Edgar Alberto P�rez Villegas (eaperezv@inet.procesar.com.mx)
 * @version 1.0
 */

/*
 * Funcion para cargar componentes html en una sola jsp
 * 
 */

function cargaComponente(componentehtml) {
	$('#contenido').load(componentehtml);
};

function prevenirEnter(){
	$("input").on("keypress",function(e){
		var charCode = (window.event ? e.keyCode: e.which);
		if(charCode == 13){
			return false;
		}
	});
}

/*
 * Objeto con utilerias para mostrar dialogos
 * 
 */
var MinervaHelperDialogs = {
		/* Funcion para mostrar errores con llamado a metodo al presionar boton */
		mostrarInformacionCallback : function(mensaje, metodoProcesaRespuesta) {
			$('#mensajeExito').html(mensaje);
			$('#successModal').modal({
				backdrop : 'static',
				keyboard : false
			});
			$('#btnSuccess').attr("onclick", metodoProcesaRespuesta + "()");
		},
		/* Funcion para mostrar errores */
		mostrarInformacion : function(mensaje) {
			$('#mensajeExito').html(mensaje);
			$('#successModal').modal({
				backdrop : 'static',
				keyboard : false
			});
			$('#btnSuccess').attr("onclick", "");
		},
		/* Funcion para mostrar errores con llamada a metodo al presionar boton */
		mostrarErrorCallback : function(mensaje, metodoProcesaRespuesta) {
			MinervaHelperDialogs.mostrarError(mensaje);
			var actualOnclick = $('#btnError').attr("onclick");
			$('#btnError').attr("onclick",
					actualOnclick + "; " + metodoProcesaRespuesta + "()");
		},
		/* Funcion para mostrar errores */
		mostrarError : function(mensaje) {
			var statusText = mensaje.statusText != null ? mensaje.statusText
					: mensaje;
			var responseText = mensaje.responseText != null ? mensaje.responseText
					: mensaje;

			var responseArray = responseText.split(/\|/);

			if (responseArray.length > 2) {
				statusText = responseArray[1];
			}

			var body = "<body>";
			var bodyEnd = "</body>";

			var resText = responseText.substring(responseText.indexOf(body)
					+ body.length, responseText.indexOf(bodyEnd));

			if (resText.trim().length > 5) {
				responseText = resText;
			}


			if (resText.trim().length < 6) {
				body = '<BODY bgcolor="white">';
				bodyEnd = '</BODY>';

				resText = responseText.substring(responseText.indexOf(body)
						+ body.length, responseText.indexOf(bodyEnd));

				if (resText.trim().length > 5) {
					responseText = resText;
				}
			}



			var h1 = "<h1>";
			var h1End = "</h1>";

			var h1Text = responseText.substring(responseText.indexOf(h1)
					+ h1.length, responseText.indexOf(h1End));

			if (h1Text.trim().length > 0) {
				responseText = responseText.replace(h1 + h1Text, "" + h1End);
			}

			var h3 = "<h3>";
			var h3End = "</h3>";

			var h3Text = responseText.substring(responseText.indexOf(h3)
					+ h3.length, responseText.indexOf(h3End));

			if (h3Text.trim().length > 0) {
				responseText = responseText.replace(h3 + h3Text, "" + h3End);
			}

			$('#mensajeError').html(htmlDecode(statusText));
			$('#trazaError').html(responseText);
			$('#errorModal').modal({
				backdrop : 'static',
				keyboard : false
			});
			$('#btnError').attr("onclick",
					"MinervaHelperDialogs.restaurarDialogoError()");

		},
		/* Funcion para restaurar dialogo de errores */
		restaurarDialogoError : function() {
			$('#trazaError').hide();
			$('#modalBodyError').attr("style", "");
			$('#modalBodyErrorRoot').attr("class", "modal-dialog");
		},
		
		/* Funcion para mostrar error de export*/
		mostrarErrorExport : function(mensaje) {
			$('#mensajeExport').html(mensaje);
			$('#errorExportModal').modal({
				backdrop : 'static',
				keyboard : false
			});
			$('#btnCerrar').attr("onclick", "");
		}
		
	};

function htmlDecode(value) {
	var div = document.createElement('div');
	div.innerHTML = value;
	return div.childNodes.length === 0 ? "" : div.childNodes[0].nodeValue;
}

/*
 * Objeto con utilerias para formularios
 * 
 */
var MinervaHelperForms = {
		/* Inicia la validacion de un formulario y muestra errores */
		formularioValido : function(formName, validator) {
			if (!$('#' + formName).valid()) {
				validator.showErrors();
				return false;
			}
			return true;
		},

		/* Crea alertas con los mensajes de error, usando las alertas de Bootstrap */
		mostrarErroresValidacion : function(selector, numberOfInvalids, errorMap) {


			// Clean last warnings
			if (typeof formName != 'undefined') {
				MinervaHelperForms.limpiarWarnings(formName);
			}

			// Show message errors
			if (numberOfInvalids > 0) {
				$.each(errorMap, function(key, value) {

					var inputInvalidMessage = $('span[path="' + key + '"]');

					if (inputInvalidMessage != undefined) {
						inputInvalidMessage.html(value);
					} else {
						console.log("Span message for " + key + " not found.");
					}
				});
			}
		},

		/* Funcion para limpiar los warnings de un formulario */
		limpiarWarnings : function(form) {
			// Clean last warnings
			var inputs = $("#" + form + " :input");

			$.each(inputs, function(index, value) {

				var inputMessage = $('span[path="' + value.name + '"]');

				if (inputMessage != undefined) {
					inputMessage.html('');
				}
			});
		},
		
	/* Funcion para bloquear un formulario */
	bloquearFormulario : function(formId) {
		$('#' + formId + ' :input').attr("disabled", true);
	},

	/* Funcion para desbloquear un formulario */
	desbloquearFormulario : function(formId) {
		$('#' + formId + ' :input').attr("disabled", false);
	},

	/* Funcion para ontener una lista de opciones a partir de un json */
	generarSelectsOption : function(object, itemValue, itemText) {
		var cadenaHTML = '<option value="">-- Seleccione una opci&oacute;n --</option>';

		if (typeof object === "undefined")
			return cadenaHTML;

		if (object == null)
			return cadenaHTML;

		object.forEach(function(item, index) {

			cadenaHTML += '<option value="' + item[itemValue] + '">'
					+ item[itemText] + '</option>';
		});

		return cadenaHTML;
	},
	
	/* Funcion para ontener una lista de opciones a partir de un json */
	generarSelectAforeOption : function(object, itemValue, itemText) {
		var cadenaHTML = '<option value="">-- Seleccione una opci&oacute;n --</option>'+
						'<option value="0">TODAS</option>';

		if (typeof object === "undefined")
			return cadenaHTML;

		if (object == null)
			return cadenaHTML;

		object.forEach(function(item, index) {

			cadenaHTML += '<option value="' + item[itemValue] + '">'
					+ item[itemText] + '</option>';
		});

		return cadenaHTML;
	},

	generarSelectServiciosOption : function(object, itemValue, itemText) {
             var cadenaHTML = '<option value="">-- Seleccione una opci&oacute;n --</option>';
             
             var nombresServicios = ["Ahorro Voluntario","Reintegro Semanas"];

             if (typeof object === "undefined")
                    return cadenaHTML;

             if (object == null)
                    return cadenaHTML;

             var  elemento = 0;
             object.forEach(function(item, index) {

                    cadenaHTML += '<option value="' + item[itemValue] + '">'
                                  + item[itemText] + ' - ' + nombresServicios[elemento] + '</option>';
                    elemento = elemento +1;
             });

             return cadenaHTML;
       },
       generarSelectOptionTodos : function(object, itemValue, itemText)
       {
    	   var cadenaHTML = '<option value="">-- Seleccione una opci&oacute;n --</option>'+
    	   					'<option value=0>TODOS</option>';

    	   if (typeof object === "undefined")
    		   return cadenaHTML;

    	   if (object == null)
    		   return cadenaHTML;

    	   object.forEach(function(item, index)
    		{
    		   cadenaHTML += '<option value="' + item[itemValue] + '">' + item[itemText] + '</option>';
    		});

    	   return cadenaHTML;
       }
	
};


//Bloquear y desbloquear pantalla

bloquearPantalla = function(message){
	var mensaje ="<h2>Procesando...</h2>";

	if(message!= undefined )
	{
		message = message.replace(/^\s*|\s*$/g,"");  //TRIM
		if(message!=""){
			mensaje ="<h2>"+message+"</h2>";
		}
	}

	$.blockUI({message: mensaje,
		css: { 
			border: 'none', 
			padding: '15px', 
			backgroundColor: '#000', 
			'-webkit-border-radius': '10px', 
			'-moz-border-radius': '10px', 
			opacity: .5, 
			color: '#fff' 
		} 
	});   
};

desBloquearPantalla = function(){
	$.unblockUI({ fadeOut: 200 }); 
};


$(document).ready(function() {

	 $("body").on('copy',function(e){
	 e.preventDefault();
	 });
});

/**
 * Funcion que valida si una cadena es vacia nula o indefinida
 * @param cadena Cadena que se desea validar
 * @returns true, si la cadena es nula, vacia, con puros espacios 
 * en blanco o indefiinda, falso si tiene uno o mas caracteres diferentes a espacios
 */
function isEmpty(cadena){
	return(!cadena || /^\s*$/.test(cadena));
}

/**
 * Fucnion que convierte milisegundos a cadena en formato: dd/mm/yyyy hh24:mi:ss
 * @param milisegundos
 */
function milisegundosACadena(milisegundos){
	var resultado = "";
	if(milisegundos){
		try {
			var fecha = new Date(milisegundos);
			resultado = ("00"+(fecha.getDate())).slice(-2)+"/"+
						("00"+(fecha.getMonth()+1)).slice(-2)+"/"+
						("0000"+(fecha.getFullYear())).slice(-4)+" "+
						("00"+(fecha.getHours())).slice(-2)+":"+
						("00"+(fecha.getMinutes())).slice(-2)+":"+
						("00"+(fecha.getSeconds())).slice(-2);
		} catch (e) {
			resultado="";
		}
	}
	return resultado;
}

/**
 * Funcion que valida que la respuesta de error de una peticion Ajax no contenga
 * informacion que indique la sesion ha finalizado.
 * 
 * @param respuestaPeticion
 *            respuesta retornada por el servicio
 * @returns <code>true</code>, si la respuesta contiene la
 *          sistema-minerva/login
 */
function sessionHaFinalizado(respuestaPeticion) {
	return respuestaPeticion
			&& respuestaPeticion.indexOf("sistema-minerva/login") >= 0;
}