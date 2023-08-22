var diasPermitidosAdmin = 6;
var generico = ' -- Seleccione una opci\u00F3n --';
var strConsultaAdmin = '';
var listaTipoReporteAdmin;

var CombosAdmin = {
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
					cadenaHTML += '<option value="' + item[itemValue] + '">'
							+ item[itemText] + '</option>';
			});
			return cadenaHTML;
		}
	};

function validaIpAdress(e) {
	var retorno = false;
	var patron = /^(([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$/;
	if (patron.test(e)) {
		retorno = true;
	}
	return retorno;
}

function soloLetrasAdmin(e) {
	var tecla = (document.all) ? e.keyCode : e.which;
	if (tecla == 8 || tecla == 13)
		return true;
	patron = /[a-zA-Z]/;
	te = String.fromCharCode(tecla);
	return patron.test(te);
};

/*
 * Función que regresa la diferencia entre dos fechas. @param fechaInicial Fecha
 * Inicial @param fechaFinal Fecha Final @returns Diferencia de dias.
 */
function siteDiasAdmin(fechaInicial, fechaFinal) {
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

// ADMINISTRACION

function fillNavyBarAdmin() {
	var nombModulo = $('#moduloAdmin option:selected').text();
	var nomProceso = $('#procesoAdmin option:selected').text();
	var nomSubproceso = $('#subProcesoAdmin option:selected').text();
	var nomTipo = $('#tipoReporteAdmin option:selected').text();
	var nomReporte = $('#nombreReporteAdmin option:selected').text();
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

	strConsultaAdmin = nombModulo + nomProceso + nomSubproceso + nomTipo + nomReporte;
	$('#navBarMinerva').html(strConsultaAdmin);
}

function changeModuloAdmin() {
	var nombModulo = $('#moduloAdmin option:selected').text();

	$("#procesoAdmin").val(-1);
	$('#procesoAdmin').attr('disabled', true);

	if (nombModulo != generico) {
		cargaProcesosAdmin();
		$("#procesoAdmin").attr('disabled', false);
	}
	fillNavyBarAdmin();
	changeProcesoAdmin();
}

function changeProcesoAdmin() {
	var nomProceso = $('#procesoAdmin option:selected').text();

	$('#subProcesoAdmin').val(-1);
	$("#subProcesoAdmin").attr('disabled', true);

	if (nomProceso != generico) {
		cargaSubProcesoAdmin();
		$("#subProcesoAdmin").attr('disabled', false);
	}
	fillNavyBarAdmin();
	changeSubProcesoAdmin();
}

function changeSubProcesoAdmin() {
	var nomSubproceso = $('#subProcesoAdmin option:selected').text();

	$('#tipoReporteAdmin').val(-1);
	$("#tipoReporteAdmin").attr('disabled', true);

	if (nomSubproceso != generico) {
		$("#tipoReporteAdmin").attr('disabled', false);
		var options = CombosAdmin.optionsTipoReporte(listaTipoReporteAdmin,
				'idTipoReporte', 'descripcion');
		$("#tipoReporteAdmin").html(options);
	}
	fillNavyBarAdmin();
	changeTipoReporteAdmin();
}


function changeTipoReporteAdmin() {
	var nomTipo = $('#tipoReporteAdmin option:selected').text();

	$('#nombreReporteAdmin').val(-1);
	$("#nombreReporteAdmin").attr('disabled', true);
//	regresarCombos();
	$('#divMinervaResultados').hide();
	$('#divBtnMinervaExportar').hide();

	if (nomTipo != generico) {
		cargaNombresReportesAdmin();
		$("#nombreReporteAdmin").attr('disabled', false);
	}
	fillNavyBarAdmin();
}


function changeReporte() {
	var nomReporte = $('#nombreReporteAdmin option:selected').text();
	if (nomReporte == generico) {
//		regresarCombos();
		inicializaFormulario();
		$("#enviarBtn").addClass('disabled')
	}else{
		$("#enviarBtn").removeClass('disabled');
	}
	$('#divPanelResultadoBitacora').hide();
	$('#btnExportResultadoAdminMinerva').hide();

	fillNavyBarAdmin();
}

function activaProcesosAdmin() {
	var moduloAdmin = $("#moduloAdmin").val();
	if (moduloAdmin == "") {
		$("#procesoAdmin").attr('disabled', true);
	} else {
		$("#procesoAdmin").attr('disabled', false);
		cargaProcesosAdmin();
	}
};

function activaSubProcesosAdmin() {
	var procesoAdmin = $("#procesoAdmin").val();
	if (procesoAdmin == "") {
		$("#subProcesoAdmin").attr('disabled', true);
	} else {
		$("#subProcesoAdmin").attr('disabled', false);
		cargaSubProcesoAdmin();
	}
};

function activaTipoReporteAdmin() {
	var idSubprocesoAdmin = $('#subProcesoAdmin').val();
	if (idSubprocesoAdmin == "") {
		$("#tipoReporteAdmin").attr('disabled', true);
	} else {
		$("#tipoReporteAdmin").attr('disabled', false);
		var options = CombosAdmin.optionsTipoReporte(listaTipoReporteAdmin,
				'idTipoReporte', 'descripcion');
		$("#tipoReporteAdmin").html(options);
	}
};

function activaNombreReportesAdmin() {
	var tipoReporteAdmin = $('#tipoReporteAdmin').val();
	if (tipoReporteAdmin == "") {
		$("#nombreReporteAdmin").attr('disabled', true);
	} else {
		$("#nombreReporteAdmin").attr('disabled', false);
		cargaNombresReportesAdmin();
	}
};


function inicializaFormularioFechas(){
	adminLimpiaFechas();
    habilitaBtnLimpiarFechas();
    $('#divPanelResultadoBitacora').hide();
    $('#btnExportResultadoAdminMinerva').hide();
    $.jgrid.gridUnload("tablaResultadoBitacora");
    
}

function inicializaFormularioTipoReporte(){
    $('#divPanelResultadoBitacora').hide();
    $('#btnExportAdminMinervaNomRepo').hide();
    $.jgrid.gridUnload("tablaResultadoBitacora");
    limpiarCombosAdmin();
    
}

function adminLimpiaFechas() {
	$('#fechaInicialEjec').val("");
	$('#fechaFinalEjec').val("");
	$('#datetimepicker3').data("DateTimePicker").clear();
	$('#datetimepicker4').data("DateTimePicker").clear();
	validaFechasAdmin();
}

function validaFechasAdmin() {
	var fechaInicialEjec = $("#fechaInicialEjec").val();
	var fechaFinalEjec = $("#fechaFinalEjec").val();
	if (fechaInicialEjec != "" && fechaFinalEjec != "") {
		$("#btnConsultaAdminMinervaRFechas").attr('disabled', false);
	} else {
		$("#btnConsultaAdminMinervaRFechas").attr('disabled', true);
	}
};

function validaNombreReporteAdmin() {
	var nombreReporteCons = $("#nombreReporteAdmin").val();
	if (nombreReporteCons != "") {
		$("#btnConsultaAdminMinervaNomRepo").attr('disabled', false);
	} else {
		$("#btnConsultaAdminMinervaNomRepo").attr('disabled', true);
	}
};

function habilitaLimiarNomRepoAdmin() {
	var modulo = $("#moduloAdmin").val();
	var proceso = $("#procesoAdmin").val();
	var subproceso = $("#subProcesoAdmin").val();
	var tipoReporte = $("#tipoReporteAdmin").val();
	var nombreReporte = $("#nombreReporteAdmin").val();

	if (modulo == null || modulo == "-1") {
		modulo = "";
	}

	if (proceso == null || proceso == "-1") {
		proceso = "";
	}

	if (subproceso == null || subproceso == "-1") {
		subproceso = "";
	}

	if (tipoReporte == null || tipoReporte == "-1") {
		tipoReporte = "";
	}

	if (nombreReporte == null || nombreReporte == "-1") {
		nombreReporte = "";
	}

	if (modulo != "" || proceso != "" || subproceso != "" || tipoReporte != ""
			|| nombreReporte != "") {
		$("#btnLimpiarAdminMinervaNomRepo").attr('disabled', false);
		$("#btnConsultaAdminMinervaNomRepo").attr('disabled', false);
	} else {
		$("#btnLimpiarAdminMinervaNomRepo").attr('disabled', true);
		$("#btnConsultaAdminMinervaNomRepo").attr('disabled', true);
	}
};

function permiteConsultaPorUsuario() {
	var usuario = $('#usuarioConsulta').val();
	if (usuario != "") {
		if (usuario.length >= 5 && usuario.length <= 12) {
			$("#btnConsultaAdminMinervaUser").attr('disabled', false);
		} else {
			$("#btnConsultaAdminMinervaUser").attr('disabled', true);
		}
	} else {
		$("#btnConsultaAdminMinervaUser").attr('disabled', true);
	}
}

function adminLimpiaUsuario() {
	$('#usuarioConsulta').val("");
	$('#btnExportAdminMinervaUser').hide();
	$.jgrid.gridUnload("tablaResultadoBitacora");
	$('#divPanelResultadoBitacora').hide();
	permiteConsultaPorUsuario();
	habilitaBtnLimpiarUser();	
}

function habilitaBtnLimpiarUser() {
	var user = $('#usuarioConsulta').val();
	if (user != "") {
		$("#btnLimpiarAdminMinervaUser").attr('disabled', false);
	} else {
		$("#btnLimpiarAdminMinervaUser").attr('disabled', true);
	}
}

function habilitaBtnLimpiarFechas() {
	var fi = $('#fechaInicialEjec').val();
	var ff = $('#fechaFinalEjec').val();
	if (fi != "" || ff != "") {
		$("#btnLimpiarAdminMinervaRFechas").attr('disabled', false);
	} else {
		$("#btnLimpiarAdminMinervaRFechas").attr('disabled', true);
	}

}

function adminLimpiarIp() {
	$('#ipUsuarioConsulta').val("");	
    $('#divPanelResultadoBitacora').hide();
    $('#btnExportAdminMinervaIp').hide();
    $.jgrid.gridUnload("tablaResultadoBitacora");
}

function habilitaBtnLimpiarIp() {
	var ipUser = $('#ipUsuarioConsulta').val();
	if (ipUser != "") {
		$("#btnLimpiarAdminMinervaIp").attr('disabled', false);
	} else {
		$("#btnLimpiarAdminMinervaIp").attr('disabled', true);
	}
	habilitaBtnConsultaPorIp();
}

function habilitaBtnConsultaPorIp() {
	var ipUser = $('#ipUsuarioConsulta').val();
	if (ipUser != "") {
		if (ipUser.length >= 8) {
			$("#btnConsultaAdminMinervaIp").attr('disabled', false);
		} else {
			$("#btnConsultaAdminMinervaIp").attr('disabled', true);
		}
	} else {
		$("#btnConsultaAdminMinervaIp").attr('disabled', true);
	}
}

// RESULTADO
function permiteConsultaNombReporte() {
	var proceso = $("#procesoAdmin").val();
	var subproceso = $("#subProcesoAdmin").val();
	var tipoReporte = $("#tipoReporteAdmin").val();
	var nombreReporte = $("#nombreReporteAdmin").val();
	if (proceso == "-1" || subproceso == "-1" || tipoReporte == "-1" || nombreReporte == "-1") {
		proceso = "";
		subproceso = "";
		tipoReporte = "";
		nombreReporte = "";
	}
	if (proceso != "" && subproceso != "" && tipoReporte != ""
			&& nombreReporte != "") {
		$("#btnConsultaAdminMinervaNomRepo").attr('disabled', false);
	} else {
		$("#btnConsultaAdminMinervaNomRepo").attr('disabled', true);
	}
}

function limpiarCombosAdmin() {	
	$("#moduloAdmin").val(-1);
	
	$("#procesoAdmin").val(-1);
	$('#procesoAdmin').attr('disabled', true);
	
	$("#subProcesoAdmin").val(-1);
	$('#subProcesoAdmin').attr('disabled', true);
	
	$("#tipoReporteAdmin").val(-1);
	$('#tipoReporteAdmin').attr('disabled', true);
	
	$("#nombreReporteAdmin").val(-1);
	$('#nombreReporteAdmin').attr('disabled', true);
	
	permiteConsultaNombReporte();
	habilitaLimiarNomRepoAdmin();
	
	$('#divResultadoBitacora').hide();
	$('#btnExportAdminMinervaNomRepo').hide();
};

function exportaGenericoAdmin(urlDownload) {
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
						MinervaHelperDialogs
								.mostrarInformacion("Ocurrio un error al intentar descargar el archivo");
						desBloquearPantalla();
					});
};

function muestraTablaResultadosAdmin(datosConsulta) {

	var columnas = [ "id", "Id Reporte", "Nombre de Reporte", "Usuario",
			"IP Del Usuario", "Fecha De Ejecuci&oacute;n",
			"Par&aacute;metros De B&uacute;squeda", "Exportado", "Aplicativo" ];

	var modelo = [ {
		name : "idBitacoraReporte",
		index : "idBitacoraReporte",
		hidden : true,
		resizable : false
	}, {
		name : "idReporteGenerico",
		index : "idReporteGenerico",
		width : "100px",
		resizable : false
	}, {
		name : "nombreReporte",
		index : "nombreReporte",
		width : "250px",
		resizable : false
	}, {
		name : "usuario",
		index : "usuario",
		width : "150px",
		resizable : false
	}, {
		name : "ipOrigen",
		index : "ipOrigen",
		width : "150px",
		resizable : false
	}, {
		name : "fechaEjecucion",
		index : "fechaEjecucion",
		width : "200px",
		resizable : false,
		sorttype : 'date',
		formatter : 'date',
		formatoptions : {
			srcformat : 'U/1000',
			newformat : 'd/m/Y H:i:s'
		}
	}, {
		name : "parametros",
		index : "parametros",
		width : "434px",
		resizable : false
	}, {
		name : "reporteExportado",
		index : "reporteExportado",
		width : "100px",
		resizable : false
	}, {
		name : "usuarioModificador",
		index : "usuarioModificador",
		width : "150px",
		resizable : false
	} ];

	$("#tablaResultadoBitacora").jqGrid({
		datatype : "local",
		colNames : columnas,
		data : datosConsulta,
		colModel : modelo,
		sortname : "id",
		rowNum : 30,
		rowList : [ 10, 20, 30 ],
		pager : "pager",
		viewrecords : true,
		sortorder : "asc",
		caption : "Detalles",
		height : '350',
		autowidth : true,
		minColwidth : 150,
		forcefit : true,
		shrinkToFit : false,
		hidegrid : false
	});

	$("#tablaResultadoBitacora").jqGrid("navGrid", "#pager", {
		edit : false,
		add : false,
		del : false
	});

}