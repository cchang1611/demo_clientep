var objetoResultado = [];
var tipoConsultaFechas;
var tipoConsultaNss;
var tipoConsultaCurp;
var tipoConsultaIdp;
var listaModulos;
var listaProcesos;
var listaSubprocesos;
var listaTipoReporte;
var listaNombreReporte;
var diasPermitidos = 6;
//Paginador
var pageSize = 20;
var totalRegistros = 0;
//ADMIN
var listaModulosAdmin;
var listaProcesosAdmin;
var listaSubprocesosAdmin;
var listaTipoReporteAdmin;
var listaNombreReporteAdmin;
//RESULTADO BITACORA
var listaResultadoBitacora;
var pageSizeAmin = 20;
var totalRegistrosAdmin = 0;
var paginaAMostrarAdmin = 1;

var rmodulo;
var rproceso;
var rsubProceso;
var rtipoReporte;
var rnombreReporte;

var strConsulta = '';
var generico = ' -- Seleccione una opci\u00F3n --';

/**
 * Tipos de campo reportes genericos
 */
const TIPO_CAMPO_FECHA = "FCH";
const TIPO_CAMPO_TEXTO = "STR";

$(document).ready(function() {
	$(".Banner__Container").css("display", "none");
	$(".Header__ButtonMenuContainer").css("display", "none");
	$(".Header__MenuContainer").css("justify-content", "flex-end", "important");
	$("#frame").css("display", "none");
})

var Combos = {
	options : function(object, itemValue, itemText) {
		var cadenaHTML = '<option value="-1" selected> -- Seleccione una opci&oacute;n --</option>';
		if (typeof object === "undefined") {
			return cadenaHTML;
		}
		if (object == null) {
			return cadenaHTML;
		}
		object.forEach(function(item, index) {
			cadenaHTML += '<option value="' + item[itemValue] + '">'
					+ item[itemText] + '</option>';
		});
		return cadenaHTML;
	},

	optionsTipoReporte : function(object, itemValue, itemText) {
		var cadenaHTML = '<option value="-1" selected> -- Seleccione una opci&oacute;n --</option>'
				+ '<option value=0 >TODOS</option>';
		if (typeof object === "undefined") {
			return cadenaHTML;
		}
		if (object == null) {
			return cadenaHTML;
		}
		object.forEach(function(item, index) {
			if (item[itemText] != 'MASIVOS') {
				cadenaHTML += '<option value="' + item[itemValue] + '">'
						+ item[itemText] + '</option>';
			}

		});
		return cadenaHTML;
	},
	
	optionsReporteCompuesto : function(object, itemValue, itemText) {
		var cadenaHTML = '<option value="-1" selected> -- Seleccione una opci&oacute;n --</option>';
		if (typeof object === "undefined") {
			return cadenaHTML;
		}
		if (object == null) {
			return cadenaHTML;
		}
		object.forEach(function(item, index) {
			if (item["reporte"][itemText] != 'MASIVOS') {
				//cadenaHTML += '<option value="' + item["reporte"][itemValue] + '" data-urlReporte="' + item["reporte"]["urlReporte"] + '">'
				cadenaHTML += '<option value="' + item["reporte"][itemValue] + '" data-urlReporte="' + item["reporte"]["urlReporte"] + '">'
						+ item["reporte"][itemText] + '</option>';
			}

		});
		return cadenaHTML;
	}
};

function configuraConsulta(datos) {

	var idReporte = $('#nombreReporte').val();
	var i;
	for (i = 0; i < datos.length; i++) {
		if (datos[i].reporte.idReporteGenerico == idReporte) {
			tipoConsultaNss = datos[i].reporte.filtroNss;
			tipoConsultaCurp = datos[i].reporte.filtroCurp;
			tipoConsultaFechas = datos[i].reporte.filtroRangoFechas;
			tipoConsultaIdp = datos[i].reporte.filtroIdProcesar;
			break;
		}
	}
	inhabilitaControlesConfig();
};

function inhabilitaControlesConfig() {
	if (tipoConsultaNss == 1 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 1) {
		$('#tdTxaNss').show();
		$('#spNss').show();
		$('#tdTxaCurp').show();
		$('#tdTxaIdPro').show();
		$('#spCurp').show();
		$('#tablaFechasMinerva').show();
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 0) {
		$('#tdTxaNss').show();
		$('#spNss').hide();
		$('#tdTxaCurp').hide();
		$('#spCurp').hide();
		$('#tablaFechasMinerva').hide();
		$('#tdTxaIdPro').hide();
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 0) {
		$('#tdTxaNss').show();
		$('#spNss').show();
		$('#tdTxaCurp').show();
		$('#spCurp').hide();
		$('#tablaFechasMinerva').hide();
		$('#tdTxaIdPro').hide();
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 0) {
		$('#tdTxaNss').show();
		$('#spNss').show();
		$('#tdTxaCurp').show();
		$('#spCurp').show();
		$('#tablaFechasMinerva').show();
		$('#tdTxaIdPro').hide();
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 1) {
		$('#tdTxaNss').hide();
		$('#spNss').hide();
		$('#tdTxaCurp').show();
		$('#spCurp').show();
		$('#tablaFechasMinerva').show();
		$('#tdTxaIdPro').show();
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 1) {
		$('#tdTxaNss').hide();
		$('#spNss').hide();
		$('#tdTxaCurp').hide();
		$('#spCurp').hide();
		$('#tablaFechasMinerva').show();
		$('#tdTxaIdPro').show();
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 1) {
		$('#tdTxaNss').hide();
		$('#spNss').hide();
		$('#tdTxaCurp').hide();
		$('#spCurp').hide();
		$('#tablaFechasMinerva').hide();
		$('#tdTxaIdPro').show();
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 0) {
		$('#tdTxaNss').hide();
		$('#spNss').hide();
		$('#tdTxaCurp').show();
		$('#spCurp').hide();
		$('#tablaFechasMinerva').hide();
		$('#tdTxaIdPro').hide();
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 0) {
		$('#tdTxaNss').hide();
		$('#spNss').hide();
		$('#tdTxaCurp').show();
		$('#spCurp').hide();
		$('#tablaFechasMinerva').show();
		$('#tdTxaIdPro').hide();
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 0) {
		$('#tdTxaNss').hide();
		$('#spNss').hide();
		$('#tdTxaCurp').hide();
		$('#spCurp').hide();
		$('#tablaFechasMinerva').show();
		$('#tdTxaIdPro').hide();
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 1) {
		$('#tdTxaNss').show();
		$('#spNss').show();
		$('#tdTxaCurp').hide();
		$('#spCurp').hide();
		$('#tablaFechasMinerva').hide();
		$('#tdTxaIdPro').show();
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 1) {
		$('#tdTxaNss').show();
		$('#spNss').show();
		$('#tdTxaCurp').show();
		$('#spCurp').show();
		$('#tablaFechasMinerva').hide();
		$('#tdTxaIdPro').show();
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 1) {
		$('#tdTxaNss').hide();
		$('#spNss').hide();
		$('#tdTxaCurp').show();
		$('#spCurp').show();
		$('#tablaFechasMinerva').hide();
		$('#tdTxaIdPro').show();
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 0) {
		$('#tdTxaNss').show();
		$('#spNss').hide();
		$('#tdTxaCurp').hide();
		$('#spCurp').hide();
		$('#tablaFechasMinerva').show();
		$('#tdTxaIdPro').hide();
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 1) {
		$('#tdTxaNss').show();
		$('#spNss').show();
		$('#tdTxaCurp').hide();
		$('#spCurp').hide();
		$('#tablaFechasMinerva').show();
		$('#tdTxaIdPro').show();
	}
};

function ocultaDivNombreReporte() {
	$('#divMinerva').hide();
	$('#divBtnMinerva').hide();
};

function ocultaDivMinervaFechas() {
	$('#divMinervaFechas').hide();
	$('#divBtnMinervaConsultar').hide();
};

function inhabilitaBotonContinua() {
	$('#divBtnLimpiarCombosMinerva').hide();
	fillNavyBar();
	var nombreReporteSel = $('#nombreReporte').val();
	if (nombreReporteSel != "") {
		muestraFormularioFechas();
		$('#fechaInicial').val("");
		$('#fechaFinal').val("");
		$('#datetimepicker1').data("DateTimePicker").clear();
		$('#datetimepicker2').data("DateTimePicker").clear();
	}
};

function muestraFormularioFechas() {
	var idReporte = $("#nombreReporte").val();
	//Se eliminan campos genericos agregados
	borrarCamposDinamicos();
	parametrosGenericos = obtenerParametrosReporteGenerico(idReporte);
	if(parametrosGenericos != null && parametrosGenericos.length > 0){
		//Se oculta la seccion de reportes normales
		$("#divMinervaFechas").hide();
		$("#divFormularioDinamico").show();
		$('#divBtnMinervaConsultar').hide();
		//Se genera el formulario dinamico
		cargarFormularioDinamico(parametrosGenericos);
	}else{
		$("#divFormularioDinamico").hide()
		configuraConsulta(listaReportes);
		//ocultaDivNombreReporte();
		$('#divMinervaFechas').show();
		$('#divBtnMinervaConsultar').show();
	}
};

function validaCamposConsulta() {
	var respuesta = false;
	var txNss = $('#textAreaNssMinerva').val();
	var txCurp = $('#textAreaCurpMinerva').val();
	var txFeI = $('#fechaInicial').val();
	var txFef = $('#fechaFinal').val();
	var txidP = $('#textAreaIdProMinerva').val();
	if (tipoConsultaNss == 1 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 1) {
		if (txNss != "" && txCurp != "" && txFeI != "" && txFef != ""
				&& txidP != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 0) {
		if (txNss != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 0) {
		if (txNss != "" && txCurp != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 0) {
		if (txNss != "" && txCurp != "" && txFeI != "" && txFef != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 1) {
		if (txCurp != "" && txFeI != "" && txFef != "" && txidP != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 1) {
		if (txFeI != "" && txFef != "" && txidP != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 1) {
		if (txidP != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 0) {
		if (txCurp != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 0) {
		if (txCurp != "" && txFeI != "" && txFef != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 0) {
		if (txFeI != "" && txFef != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 1) {
		if (txNss != "" && txidP != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 1) {
		if (txNss != "" && txCurp != "" && txidP != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 0 && tipoConsultaCurp == 1
			&& tipoConsultaFechas == 0 && tipoConsultaIdp == 1) {
		if (txCurp != "" && txidP != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 0) {
		if (txNss != "" && txFeI != "" && txFef != "") {
			respuesta = true;
		}
	} else if (tipoConsultaNss == 1 && tipoConsultaCurp == 0
			&& tipoConsultaFechas == 1 && tipoConsultaIdp == 1) {
		if (txNss != "" && txFeI != "" && txFef != "" && txidP != "") {
			respuesta = true;
		}
	}
	if (!respuesta) {
		$('#btnConsultaMinerva').attr('disabled', true);
	} else {
		$('#btnConsultaMinerva').attr('disabled', false);
	}
	return respuesta;
};

function muestraResultado() {
	$('#divMinervaResultados').show();
	$('#divBtnMinervaExportar').show();
	$("#nav").html('');
	armaTablaResultado(1);
	paginar(1);
};

function armaTablaResultado(paginaAMostrar) {
	$("#tablaResultado").remove();
	var tamanioRegistro = objetoResultado.datos.consulta.length;
	;
	totalRegistros = tamanioRegistro;
	var finBloqueRegistros = (paginaAMostrar * pageSize) - 1;
	var inicioBloqueRegistros = finBloqueRegistros - pageSize + 1;
	var tamanioColumnas = objetoResultado.datos.tamanioColumnas;
	var columnas = objetoResultado.datos.nombreColumnas;
	var tablaResultado = document.createElement("table");
	tablaResultado.setAttribute("id", "tablaResultado");
	tablaResultado.setAttribute("border", 1);
	tablaResultado.setAttribute("class", "table table-bordered table-striped");
	var theadResultado = document.createElement("thead");
	tablaResultado.appendChild(theadResultado);
	var tr = document.createElement("tr");
	tr
			.setAttribute("style",
					"color:#fff; background-color:#00395A; height: 20px; white-space: nowrap;")
	theadResultado.appendChild(tr);
	var tBody = document.createElement("tbody");
	document.body.appendChild(tablaResultado);
	// For para pintar los encabezados.			
	for (var j = 0; j < tamanioColumnas; j++) {
		var td = document.createElement("td");
		td.setAttribute("align", "center");
		var cel = document.createTextNode(columnas[j].trim());
		td.appendChild(cel);
		tr.appendChild(td);
	}
	var nomCol;
	//For para traer el número de tr's a pintar.
	for (var k = inicioBloqueRegistros; k <= finBloqueRegistros; k++) {
		if (objetoResultado.datos.consulta[k] != null) {
			var obj = objetoResultado.datos.consulta[k];
			var tr2 = document.createElement("tr");
			//For para pintar los td correspondientes a cada columna.
			for (var h = 0; h < tamanioColumnas; h++) {
				var td2 = document.createElement("td");
				nomCol = objetoResultado.datos.nombreColumnas[h].trim();
				var cel2 = document.createTextNode(obj[nomCol]);
				td2.appendChild(cel2);
				if (td2.outerText == "null") {
					td2.setAttribute("style", "background-color:#FFFF00");
				}
				tr2.appendChild(td2);
				tBody.appendChild(tr2);
			}
		}
	}
	tablaResultado.appendChild(theadResultado);
	tablaResultado.appendChild(tBody);
	$('#divMinervaResultados').show();
	$('#idDivTblCons').append(tablaResultado);
	$('#paginador').show();
};

function paginar(paginaAMostrar) {
	var paginas = parseInt(totalRegistros / pageSize);
	var residuoPaginas = totalRegistros % pageSize;
	if (residuoPaginas != 0) {
		paginas++;
	}
	$("#paginador").bootpag({
		total : paginas,
		maxVisible : 5,
		page : paginaAMostrar,
		firstLastUse : true,
		first : 'INICIO',
		last : 'FIN'
	}).on("page", function(event, pagina) {
		armaTablaResultado(pagina);
	});
};

function validaTextAreaNss() {
	var cadenaSinSaltosDeLinea = $('#textAreaNssMinerva').val().replace(/\n/gi,
			"");
	var cadenaSoloDigitos = cadenaSinSaltosDeLinea.replace(/\D/gi, "");
	var longitudCadena = cadenaSoloDigitos.length;
	var contador = 0;
	var maximo = 100;
	var longitud = 11;
	var cortes = 11;
	var formateoNss = "";
	if (cadenaSoloDigitos.length != 0) {
		for (var i = 0; i < longitudCadena; i += longitud) {
			if (cadenaSoloDigitos.substring(i, cortes).length == longitud) {
				formateoNss += cadenaSoloDigitos.substring(i, cortes) + "\n";
				cortes += longitud;
			}
			contador++;
		}
		if (contador > maximo) {
			MinervaHelperDialogs
					.mostrarInformacion("No puede ingresar m&aacute;s de 100 NSS.");
			$('#textAreaNssMinerva').val('');
			return false;
		} else {
			if (formateoNss == "") {
				MinervaHelperDialogs
						.mostrarInformacion("Debe ingresar al menos 11 d&iacute;gitos.");
				$('#textAreaNssMinerva').val('');
				return false;
			} else {
				$('#textAreaNssMinerva').val(formateoNss);
			}
		}
	} else {
		MinervaHelperDialogs
				.mostrarInformacion("S&oacute;lo se aceptan n&uacute;meros.");
		$('#textAreaNssMinerva').val('');
		return false;
	}
};

function soloNumeros(e) {
	var tecla = (document.all) ? e.keyCode : e.which;
	if (tecla == 8 || tecla == 13)
		return true;
	patron = /[0123456789]/;
	te = String.fromCharCode(tecla);
	return patron.test(te);
};

function soloLetras(e) {
	var tecla = (document.all) ? e.keyCode : e.which;
	if (tecla == 8 || tecla == 13)
		return true;
	patron = /[a-zA-Z]/;
	te = String.fromCharCode(tecla);
	return patron.test(te);
};

function validaTextAreaCurp() {
	var retorno = false;
	var regexp = /^[A-Z]{4}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]{1}(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE|NC)[A-Z]{3}[0-9A-Z]{2}$/;
	var curpsSinSaltosDeLinea = $('#textAreaCurpMinerva').val().replace(/\n/gi,
			"");
	var contador = 0;
	var maximo = 100;
	var longitudCadena = curpsSinSaltosDeLinea.length;
	var longitud = 18;
	var cortes = 18;
	var formateoCurp = "";
	var curp;
	var isValidaCurp;
	for (var i = 0; i < longitudCadena; i += longitud) {
		if (curpsSinSaltosDeLinea.substring(i, cortes).length == longitud) {
			curp = curpsSinSaltosDeLinea.substring(i, cortes);
			console.log("CURP A VALIDAR " + curp);
			isValidaCurp = regexp.test(curp);
			console.log("ES VALIDA " + isValidaCurp);
			if (isValidaCurp) {
				formateoCurp += curpsSinSaltosDeLinea.substring(i, cortes)
						+ "\n";
			}
			cortes += longitud;
		}
		contador++;
	}
	if (contador > maximo) {
		MinervaHelperDialogs
				.mostrarInformacion("No puede ingresar m&aacute;s de 100 CURP.");
		$('#textAreaCurpMinerva').val('');
		return false;
	} else {
		if (formateoCurp == "") {
			MinervaHelperDialogs
					.mostrarInformacion("Debe ingresar 18 caracteres alfanum\u00E9ricos para cada CURP.");
			$('#textAreaCurpMinerva').val('');
			return false;
		} else {
			$('#textAreaCurpMinerva').val(formateoCurp);
		}
	}
	return retorno;
};

function validaTextAreaIdProcesar() {
	var maximo = 100;
	var idProcesarSinSaltoDeLinea = $('#textAreaIdProMinerva').val().replace(
			/\n/gi, ",");
	var ides = idProcesarSinSaltoDeLinea.split(",");
	var formateoIdprocesar = "";
	if (ides.length > maximo) {
		MinervaHelperDialogs
				.mostrarInformacion("No puede ingresar m&aacute;s de 100 ID Procesar.");
		$('#textAreaIdProMinerva').val('');
	} else {
		for (var i = 0; i < ides.length; i++) {
			formateoIdprocesar += ides[i] + ",\n";
		}
		var longi = formateoIdprocesar.length;
		var formateoIdprocesar = formateoIdprocesar.substring(0, longi - 2);
		$('#textAreaIdProMinerva').val(formateoIdprocesar);
	}
};

function exportaGenerico(urlDownload) {
	$
			.fileDownload(urlDownload, {
				prepareCallback : function(dat) {
					console.log("<< Iniciando descarga excel...>>");
					bloquearPantalla();
				},
				successCallback : function(dat) {
					console.log("<< Descarga exitosa ! >>");
					desBloquearPantalla();
				},
				failCallback : function(responseHTML, e) {
					console.log(">>>Fallo en la descarga: ");
					desBloquearPantalla();
				}
			})
			.done(
					function(data) {
						MinervaHelperDialogs
								.mostrarInformacion("Archivo descargado correctamente.");
					})
			.fail(
					function(e) {
						console.log("<<FAIL - ERROR>> " + e);
						if(sessionHaFinalizado(e.responseText)){
							redirigirLogin();
						}else{
							MinervaHelperDialogs
								.mostrarInformacion("Ocurrio un error al intentar descargar el archivo");
							desBloquearPantalla();
						}
					});
};

function regresarCombos() {
	$('#fechaInicial').val("");
	$('#fechaFinal').val("");
	$('#datetimepicker1').data("DateTimePicker").clear();
	$('#datetimepicker2').data("DateTimePicker").clear();
	habilitaLimpiarNomRepo();
	activaBtnConsulta();
	$('#divMinervaFechas').hide();
	$('#divMinerva').show();
	$('#divBtnMinervaConsultar').hide();
	$("#divFormularioDinamico").hide();
	$('#divBtnLimpiarCombosMinerva').show();
	$('#textAreaNssMinerva').val("");
	$('#textAreaCurpMinerva').val("");
	$('#textAreaIdProMinerva').val("");
};

function reseteaFecha() {
	var fechaActual = new Date();
	var dia = fechaActual.getDate();
	var mes = fechaActual.getMonth() + 1;
	var anio = fechaActual.getFullYear();
	if (mes < 10) {
		mes = "0" + mes;
	}
	if (dia < 10) {
		dia = "0" + dia;
	}
	var fecha = dia + "/" + mes + "/" + anio;
	return fecha;
};

function regresarSeleccionParametros() {
	var idReporte = $("#nombreReporte").val();
	var listaParametros = null
	try {
		//Se buscan los parametros dinamicos del reporte seleccionado
		 listaParametros = obtenerParametrosReporteGenerico(idReporte);
	} catch (e) {
		console.log("Error al reiniciar la pantalla de consulta");
	}
	if(listaParametros && listaParametros.length > 0){
		//Si la lista de parametros obtenida no es vacia se trata de un reporte parametrizable
		//Se oculta la seccion de resultados, la seccion de botones para exportar
		$("#divMinervaResultados").hide()
		$("#divBtnMinervaExportar").hide();
		
		//Se muestra el formulario dinamico
		$("#divFormularioDinamico").show();
		//Y se resetean los campos
		var contenedor = $("#tablaFormularioDinamico thead");
		var campos = $(contenedor).find(" :input")
		$.each(campos, function(index, value) {
			value.value="";
		})
	}else{
		//Sino se trata de un reporte "normal"
		$('#fechaInicial').val("");
		$('#fechaFinal').val("");
		$('#datetimepicker1').data("DateTimePicker").clear();
		$('#datetimepicker2').data("DateTimePicker").clear();
		$('#btnConsultaMinerva').attr('disabled', true);
		$('#divMinervaResultados').hide();
		$('#divBtnMinervaExportar').hide();
		$('#divMinervaFechas').show();
		$('#divBtnMinervaConsultar').show();
	}
};

function activaBtnConsulta() {
	var fechaInicial = $('#fechaInicial').val();
	var fechaFinal = $('#fechaFinal').val();
	if (fechaInicial != "" && fechaFinal != "") {
		$('#btnConsultaMinerva').attr('disabled', false);
	} else {
		$('#btnConsultaMinerva').attr('disabled', true);
	}
}

function fillNavyBar() {
	var fillConsulta = '';
	var nombModulo = $('#modulo option:selected').text();
	var nomProceso = $('#proceso option:selected').text();
	var nomSubproceso = $('#subProceso option:selected').text();
	var nomTipo = $('#tipoReporte option:selected').text();
	var nomReporte = $('#nombreReporte option:selected').text();
	var generico = ' -- Seleccione una opci\u00F3n --';

	$('#navBarMinerva').attr('hidden', false);
	$('#navBarMinerva').attr('style',
			"color:#fff; white-space: nowrap; font-size: 10px;");

	if (nombModulo != '' && nombModulo != generico) {
		nombModulo = ' > ' + nombModulo;
	} else {
		nombModulo = '';
	}

	if (nomProceso != '' && nomProceso != generico) {
		nomProceso = ' > ' + nomProceso;
	} else {
		nomProceso = '';
	}

	if (nomSubproceso != '' && nomSubproceso != generico) {
		nomSubproceso = ' > ' + nomSubproceso;
	} else {
		nomSubproceso = '';
	}

	if (nomTipo != '' && nomTipo != generico) {
		nomTipo = ' > ' + nomTipo;
	} else {
		nomTipo = '';
	}

	if (nomReporte != '' && nomReporte != generico) {
		nomReporte = ' > ' + nomReporte;
	} else {
		nomReporte = '';
	}

	strConsulta = nombModulo + nomProceso + nomSubproceso + nomTipo
			+ nomReporte;
	$('#navBarMinerva').html(strConsulta);
}

function changeModulo() {
	var nombModulo = $('#modulo option:selected').text();

	$("#proceso").val(-1);
	$('#proceso').attr('disabled', true);

	if (nombModulo != generico) {
		cargaProcesos();
		$("#proceso").attr('disabled', false);
	}
	fillNavyBar();
	changeProceso();
}

function changeProceso() {
	var nomProceso = $('#proceso option:selected').text();

	$('#subProceso').val(-1);
	$("#subProceso").attr('disabled', true);

	if (nomProceso != generico) {
		cargaSubProceso();
		$("#subProceso").attr('disabled', false);
	}
	fillNavyBar();
	changeSubProceso();
}

function changeSubProceso() {
	var nomSubproceso = $('#subProceso option:selected').text();

	$('#tipoReporte').val(-1);
	$("#tipoReporte").attr('disabled', true);

	if (nomSubproceso != generico) {
		$("#tipoReporte").attr('disabled', false);
		var options = Combos.optionsTipoReporte(listaTipoReporte,
				'idTipoReporte', 'nombreTipoReporte');
		$("#tipoReporte").html(options);
	}
	fillNavyBar();
	changeTipoReporte();
}

function changeTipoReporte() {
	var nomTipo = $('#tipoReporte option:selected').text();

	$('#nombreReporte').val(-1);
	$("#nombreReporte").attr('disabled', true);
	regresarCombos();
	$('#divMinervaResultados').hide();
	$('#divBtnMinervaExportar').hide();

	if (nomTipo != generico) {
		cargaNombresReportes();
		$("#nombreReporte").attr('disabled', false);
	}
	fillNavyBar();
}

function changeReporte() {
	var nomReporte = $('#nombreReporte option:selected').text();
	var $urlReporte = $('#nombreReporte option:selected').data('urlreporte');
	
	if($urlReporte != undefined && $urlReporte != '' && $urlReporte != null){
		redireccionarReporte($urlReporte);
		$("#frame").css("display", "block");
		$("#divFormularioDinamico").hide();
		$("#divMinervaResultados").hide();
	    $("#divBtnMinervaConsultar").hide();
	    $("#divBtnMinervaExportar").hide();
	}else{
		if (nomReporte == generico) {
			regresarCombos();
			$('#divBtnLimpiarCombosMinerva').hide();
		} else {
			muestraFormularioFechas();
		}

		$('#divMinervaResultados').hide();
		$('#divBtnMinervaExportar').hide();
		$("#frame").css("display", "none");
		
		fillNavyBar();
	}
}

/*
 * Función que regresa la diferencia entre dos fechas.
 * @param fechaInicial Fecha Inicial
 * @param fechaFinal Fecha Final
 * @returns Diferencia de dias.
 */
function siteDias(fechaInicial, fechaFinal) {
	var dias;
	if (fechaInicial != "" && fechaFinal != "") {
		var FechaInicial = fechaInicial.split('/');
		var FechaFinal = fechaFinal.split('/');
		var aFechaInicial = Date.UTC(FechaInicial[2], FechaInicial[1] - 1,
				FechaInicial[0]);
		var aFechaFinal = Date.UTC(FechaFinal[2], FechaFinal[1] - 1,
				FechaFinal[0]);
		var diferencia = aFechaInicial - aFechaFinal;
		dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
	} else {
		dias = 1;
	}
	return dias;
};

function pintaRuta() {
	var modulo = $('#modulo option:selected').text();
	var proceso = $('#proceso option:selected').text();
	var subProceso = $('#subProceso option:selected').text();
	var tipoReporte = $('#tipoReporte option:selected').text();
	var nombreReporte = $('#nombreReporte option:selected').text();
	var rmodulo = modulo;
	var rproceso = proceso;
	var rsubProceso = subProceso;
	var rtipoReporte = tipoReporte;
	var rnombreReporte = nombreReporte;
	$("#tmodul").text(rmodulo);
	$("#tproceso").text(rproceso);
	$("#tsubProceso").text(rsubProceso);
	$("#ttipoReporte").text(rtipoReporte);
	$("#tnombreReporte").text(rnombreReporte);
};

function muestraTablaResultados(datosConsulta) {
	$('#divMinervaResultados').show();
	$('#divBtnMinervaExportar').show();
	$("#nav").html('');
	$("#nomReporte").html(datosConsulta.nombreReporte)
	var columnas = datosConsulta.nombreColumnas;

	var modelo = [];

	columnas.forEach(function(item, index) {
		modelo.push({
			name : item,
			index : index,
			hidden : false,
			resizable : true
		});
	});

	$("#tabResultadoCons").jqGrid({
		datatype : "local",
		colNames : datosConsulta.nombreColumnas,
		data : escapeXMLTags(datosConsulta.consulta),
		colModel : modelo,
		sortname : "id",
		rowNum : 30,
		rowList : [ 10, 20, 30 ],
		pager : "pager",
		viewrecords : true,
		sortorder : "asc",
		caption : datosConsulta.nombreReporte,
		height : '350',
		autowidth : true,
		minColwidth : 150,
		forcefit : true,
		shrinkToFit : false,
		hidegrid : false
	});

	$("#tabResultadoCons").jqGrid("navGrid", "#pager", {
		edit : false,
		add : false,
		del : false
	});

}


function habilitaLimpiarNomRepo() {
	var modulo = $("#modulo").val();
	var proceso = $("#proceso").val();
	var subproceso = $("#subProceso").val();
	var tipoReporte = $("#tipoReporte").val();
	var nombreReporte = $("#nombreReporte").val();

	if (modulo == null) {
		modulo = "";
	}

	if (proceso == null) {
		proceso = "";
	}

	if (subproceso == null) {
		subproceso = "";
	}

	if (tipoReporte == null) {
		tipoReporte = "";
	}

	if (nombreReporte == null) {
		nombreReporte = "";
	}

	if (modulo != "" || proceso != "" || subproceso != "" || tipoReporte != ""
			|| nombreReporte != "") {
		$("#btnLimpiarCombosMinerva").attr('disabled', false);
	} else {
		$("#btnLimpiarCombosMinerva").attr('disabled', true);
	}
};

function cargarFormularioDinamico(parametros) {
	var idContenedor = "tablaFormularioDinamico";
	var nuDiasMaximo = 15;
	if (parametros && parametros.length > 0) {
		var contenedor = idContenedor + " thead";
		$.each(parametros, function(index, value) {
			var nombreParametro = value.nombre;
			var tipoParametro = value.tipoCampo;
			if (tipoParametro == TIPO_CAMPO_FECHA) {
				agregarCampoFecha(nombreParametro, contenedor);
				if(nombreParametro == "FECHA_INICIAL" || nombreParametro == "FECHA_FINAL"){
					nuDiasMaximo = value.nuDiasMaximo;
				}
			} else if (tipoParametro == TIPO_CAMPO_TEXTO) {
				agregarCampoTexto(nombreParametro, contenedor);
			}

		})

		// Aplica estilos de fechas
		$("#" + idContenedor + " .fechas").datetimepicker({
			locale : 'es',
			format : 'DD/MM/YYYY',
			daysOfWeekDisabled : [ 0, 6 ]
			//,maxDate : new Date()
		});
		
		//Campos en blanco
		var campos = $("#tablaFormularioDinamico thead").find(" :input")
		$.each(campos, function(index, value) {
			value.value="";
		})
		
		//Cálculo de fechas 
		/** VHR Se deshabilita para no limitar las fechas
		$("#datetimepickerFECHA_INICIAL").on("dp.change", function (e){
			$('#datetimepickerFECHA_FINAL').data("DateTimePicker").maxDate(new Date());
			var fechaSeleccionada = new Date(e.date);
			var fechaActual = new Date();
			
			var fechaMinima = new Date(fechaActual.getFullYear(), fechaActual.getMonth(), fechaActual.getDate() - parseInt(nuDiasMaximo));
			var fechaActualFormato = new Date (fechaActual.getFullYear(), fechaActual.getMonth(), fechaActual.getDate());
				
			var mes = (fechaActualFormato.getMonth()+1);
			if(mes < 10)
				mes = "0" + mes;
			var dia = fechaActualFormato.getDate();
			if(dia < 10)
				dia = "0" + dia;
			var fechaFormateada =  (dia + '/' + mes + '/' + fechaActualFormato.getFullYear());
			var fechaPrueba = fechaSeleccionada.getDate();
			var maximoFechaFin = new Date (fechaSeleccionada.getFullYear(), fechaSeleccionada.getMonth(), fechaPrueba + parseInt(nuDiasMaximo));
			var minimoFechFin  = new Date (fechaSeleccionada.getFullYear(), fechaSeleccionada.getMonth(), fechaSeleccionada.getDate());
			var mesFechaUltima = (maximoFechaFin.getMonth()+1);
			if(mesFechaUltima < 10)
				mesFechaUltima = "0" + mesFechaUltima;
			var diaFechaUltima = maximoFechaFin.getDate();
			if(diaFechaUltima < 10)
				diaFechaUltima = "0" + diaFechaUltima;
			if(fechaSeleccionada >= fechaMinima && fechaSeleccionada <= fechaActualFormato){
				$('#datetimepickerFECHA_FINAL').data("DateTimePicker").minDate(minimoFechFin);
				$('#datetimepickerFECHA_FINAL').data("DateTimePicker").maxDate(fechaActualFormato);
				$('#FECHA_FINAL').val(fechaFormateada);
			}else{
				$('#datetimepickerFECHA_FINAL').data("DateTimePicker").minDate(minimoFechFin);
				$('#datetimepickerFECHA_FINAL').data("DateTimePicker").maxDate(maximoFechaFin);
				$('#FECHA_FINAL').val(diaFechaUltima + '/' + mesFechaUltima + '/' + maximoFechaFin.getFullYear());
			}
			
		});
		*/
		
		//Se muestra el boton de consulta
		$("#btnExportarPdfPrueba").show();
	}
}

function agregarCampoFecha(nombreCampo, idContenedor) {
	var clonado = $("#templateFechas").clone();
	// Se actualizan los ids y textos
	$(clonado).prop("id", "renglon" + nombreCampo);

	var label = $(clonado).find("#labelNombreParametro");
	$(label).prop("id", "label" + nombreCampo);
	$(label).text(nombreCampo + " : ");

	var divFecha = $(clonado).find("#datetimepickerNombreParametro");
	$(divFecha).prop("id", "datetimepicker" + nombreCampo);

	var inputFecha = $(clonado).find("#nombreParametro");
	$(inputFecha).prop("id", nombreCampo);

	$(inputFecha).keypress(function(evt) {
		evt.preventDefault();
	})
	$(inputFecha).bind('copy paste', function(e) {
		e.preventDefault();
		return false;
	});

	$(clonado).show();
	clonado.appendTo("#" + idContenedor);

}

function agregarCampoTexto(nombreCampo, idContenedor) {
	var clonado = $("#templateTexto").clone();
	// Se actualizan los ids y textos
	$(clonado).prop("id", "renglon" + nombreCampo);

	var label = $(clonado).find("#labelNombreParametroTexto");
	$(label).prop("id", "label" + nombreCampo);
	$(label).text(nombreCampo + " : ");

	var inputTexto = $(clonado).find("#nombreParametro");
	$(inputTexto).prop("id", nombreCampo);

	$(clonado).show();
	clonado.appendTo("#" + idContenedor);
}

function obtenerCadenaParametrosDinamicos() {
	var cadenaParametros = "";
	var contenedorPrincipal = $("#tablaFormularioDinamico thead");
	var inputs = $(contenedorPrincipal).find(" :input")
	$.each(inputs, function(index, value) {
		cadenaParametros += value.id + "=" + value.value + "&"
	})
	return cadenaParametros;
}

function todosCamposCapturados(){
	var resultado = true;
	var contenedorPrincipal = $("#tablaFormularioDinamico thead");
	var inputs = $(contenedorPrincipal).find(" :input")
	$.each(inputs, function(index, value) {
		if (!value.value || value.value == ""){
			resultado = false;
			return false;
		}
	})
	return resultado;
}

function borrarCamposDinamicos(){
	var contenedorPrincipal = $("#tablaFormularioDinamico thead");
	$(contenedorPrincipal).empty();
	//Se oculta el boton de consulta
	$("#btnExportarPdfPrueba").hide();
}

function obtenerParametrosReporteGenerico(idReporte) {
	var parametrosReporteGenerico = null;
	$.each(listaReportes, function(index, value) {
		// Si encuentra la informacion del reporte generico...
		if (value && value.reporte && value.reporte.idReporteGenerico
				&& value.reporte.idReporteGenerico == idReporte) {

			// Obtiene el listado de parametros genericos
			var parametros = value.listaParametros;
			// y la informacion general del reporte
			var infoReporte = value.reporte;

			// Si se tiene al menos un parametro configurable...
			if (parametros && parametros.length > 0) {
				// Y todas las banderas de reportes normales apagadas...
				if (infoReporte && infoReporte.filtroCurp == 0
						&& infoReporte.filtroIdProcesar == 0
						&& infoReporte.filtroNss == 0
						&& infoReporte.filtroRangoFechas == 0) {
					// Se trata de un reporte generico, y el metodo retorna el listado de parametros y finaliza el ciclo
					parametrosReporteGenerico = parametros;
					//rompe el ciclo .each()
					return false;
				}
			}
		}
	});
	return parametrosReporteGenerico;
}

function escapeXMLTags(consulta){
	try {
		for (var i = 0; i < consulta.length; i++) {
			var objeto = consulta[i]; 
			for(var prop in objeto){
				if(typeof objeto[prop]=='string' && (objeto[prop].indexOf('<')>=0 || objeto[prop].indexOf('>')>=0)){
					objeto[prop]=objeto[prop].replace(/</gi,'&lt;')
					objeto[prop]=objeto[prop].replace(/>/gi,'&gt;')
				}
			}
		}
	} catch (e) {
		console.log("Error"+e);
	}
	return consulta;
}

function changeFechaInicio(){
	$("#fechaFinal").val($("#fechaInicial").val());
	activaBtnConsulta();
}

/***
 * Metodo para redireccionar a pantallas externas utilizando configracion de reporte seleccionado
 * @param $urlReporte
 * @returns
 */
function redireccionarReporte($urlReporte){
	url = "plataforma-operativa/consultaDetallada";
	var $redireccionURL = $urlReporte + "?token=";
	
	$.ajax({
		type : "GET",
		contentType : "application/json",
		dataType : 'json',
		url : url,
		data : {
			idReporte : $('#nombreReporte').val()
		},
		timeout : 100000,
		async : false,
		beforeSend : function() {
			bloquearPantalla();
		},
		success : function(data) {
			if(data.exito === 1){
				$("#frameExterno").attr("src", $redireccionURL + data.datos);
			}else{
				MinervaHelperDialogs.mostrarError(data.mensaje);
			}
		},
		error: function(jqXHR, timeout){
			console.log("jqXHR", jqXHR);
		},
		complete : function() {
			desBloquearPantalla();
		}
	});
}

/**
 * Metodo para ajustar el tamanio de pantallas embebidas
 * @param obj
 * @returns
 */
function autoAjuste(obj){
	var $navegador = window.navigator.userAgent;
	var $msie = $navegador.indexOf("MSIE"); //Determina si es IE
	
	if($msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)){
		window.attachEvent("onmessage", receiveMessage);
	}else{
		window.addEventListener("message", receiveMessage, false);
	}
}

function receiveMessage(e){
	console.log("e", e)
	$("#frameExterno").css("height", e.data);
}