var listaTipoReporte;
var contexto = "";
var strConsulta = '';
var generico = ' -- Seleccione una opci\u00F3n --';

$(document).ready(function() {
	contexto = $("#contextPath").val();
	$(".Banner__Container").css("display", "none");
	$(".Header__ButtonMenuContainer").css("display", "none");
	$(".Header__MenuContainer").css("justify-content", "flex-end", "important");
	$("#frame").css("display", "none");
})

var CombosMasivos = {
	options : function(object, itemValue, itemText) {
		var cadenaHTML = '<option value="-1"> -- Seleccione una opci&oacute;n --</option>';
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
		var cadenaHTML = '<option value="-1"> -- Seleccione una opci&oacute;n --</option>';
		if (typeof object === "undefined") {
			return cadenaHTML;
		}
		if (object == null) {
			return cadenaHTML;
		}
		object
				.forEach(function(item, index) {
					if (item[itemText] == 'MASIVOS') {
						cadenaHTML += '<option selected="selected" value="'
								+ item[itemValue] + '">' + item[itemText]
								+ '</option>';
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
				cadenaHTML += '<option value="' + item["reporte"][itemValue] + '">'
						+ item["reporte"][itemText] + '</option>';
			}

		});
		return cadenaHTML;
	}
	
	
};


function inicializaFormulario() {
	// rango de fechas
	deshabilitarFecha();
	
	
	// carga archivo
	$('#tipoArchivo').val(-1);
	$('#tipoArchivo').attr("disabled", true);

	$('#archivoAProcesar').val('');
	$('#archivoAProcesar').attr("disabled", true);
	
	$("#fileInputTag").addClass('disabled');
	$("#fileInputTag").attr('disabled',true);
	$('#fileinput-filename').val('');
	
	$("#enviarBtn").addClass('disabled');
}


function activaParamestros() {
	var idReporte = $('#reporteMasivo').val();
	var nomReporte = $('#reporteMasivo option:selected').text();
	
	if (idReporte != '' && idReporte != -1) {
		listaReportes.forEach(function(item, index) {
			if(item.reporte.idReporteGenerico == idReporte){
				if (item.reporte.filtroCurp == 1) {
					$('#tipoArchivo').val(0);
					$('#tipoArchivo').attr("disabled", true);
					$('#fechaInicial').attr("disabled", true);
					$('#fechaFinal').attr("disabled", true);
					$('#archivoAProcesar').attr("disabled", false);
					$("#fileInputTag").removeClass('disabled');
					$("#fileInputTag").attr('disabled',false);
				}

				if (item.reporte.filtroNss == 1) {
					$('#tipoArchivo').val(1);
					$('#tipoArchivo').attr("disabled", true);
					$('#fechaInicial').attr("disabled", true);
					$('#fechaFinal').attr("disabled", true);
					$('#archivoAProcesar').attr("disabled", false);
					$("#fileInputTag").removeClass('disabled');
					$("#fileInputTag").attr('disabled',false);
				}

				if (item.reporte.filtroIdProcesar == 1) {
					$('#tipoArchivo').val(2);
					$('#tipoArchivo').attr("disabled", true);
					$('#fechaInicial').attr("disabled", true);
					$('#fechaFinal').attr("disabled", true);
					$('#archivoAProcesar').attr("disabled", false);
					$("#fileInputTag").removeClass('disabled');
					$("#fileInputTag").attr('disabled',false);
				}

				if (item.reporte.filtroRangoFechas == 1) {
					$('#tipoArchivo').val(-1);
					$('#tipoArchivo').attr("disabled", true);
					$('#fechaInicial').attr("disabled", false);
					$('#fechaFinal').attr("disabled", false);
					$('#archivoAProcesar').attr("hidden", "hidden");
					$("#fileInputTag").addClass('disabled');
					$("#fileInputTag").attr('disabled',true);
				}
			}
		});
	}else{
		if (nomReporte == generico){
			LimpiaFecha();
			deshabilitarFecha();
			
			// Inhabilita combo de tipoArchivo
			$('#tipoArchivo').val(0);
			$('#tipoArchivo').attr("disabled", true);
			
			// Inhabilita boton de carga de archivo
			$('#archivoAProcesar').attr("disabled", true);
			$("#archivoAProcesar").addClass('disabled');
			
			$("#fileInputTag").addClass('disabled');
			$("#fileInputTag").attr('disabled',true);
			
			$("#tipoReporteMasivo").attr('disabled',true);
			$("#enviarBtn").addClass('disabled');
		}
	}
};

function cargaGrid(datosConsulta){
	
	var columnas = [ "Id", "Numero Solicitud", "Nombre Reporte", "Estado", "Fecha y Hora de Recibido","Fecha y Hora de Procesamiento", "Archivo Reporte" ];
	
	var modelo = [
				   { name: "idSolicitudReporte", index: "idSolicitudReporte", hidden: true},
				   { name: "numeroSolicitud", index: "numeroSolicitud", width: "110px", resizable:false  },
				   { name: "nombreReporte", index: "nombreReporte", width: "150px", resizable:false  },
				   { name: "descripcionEstado", index: "descripcionEstado", width: "100px", resizable:false  },
				   
				   { name: "fechaEnvio", index: "fechaEnvio", width: "100px", resizable:false, sorttype:'date', formatter : 'date', formatoptions: {srcformat:'U/1000', newformat:'d/m/Y H:i:s'} },
				   { name: "fechaProceso", index: "fechaProceso", width: "100px", resizable:false, sorttype:'date', formatter : 'date',	formatoptions: {srcformat:'U/1000',newformat:'d/m/Y H:i:s'}},
				   { name: "acuseCSV", index: "acuseCSV", width: "100px",resizable:false, "text-align":"center"}
				   
			];
	console.log(datosConsulta);
	for( index in datosConsulta ){
		var dato = datosConsulta[index];
		datosConsulta[index].acuseCSV = ""
		if(dato && !isEmpty(dato.rutaArchivoRespuesta) && !isEmpty(dato.nombreArchivoRespuesta)){
			idSolicitudReporte = dato.idSolicitudReporte;
			numeroSolicitud = dato.numeroSolicitud;
			
			if (dato.exportado == 1){
				datosConsulta[index].acuseCSV = "<p id='linkDescarga_"+numeroSolicitud+"' class=\"descargaDisabled\" title=\"Este archivo ya se ha descargado\">"+dato.nombreArchivoRespuesta+"</p>";
			}else{
				datosConsulta[index].acuseCSV = "<a id='linkDescarga_"+numeroSolicitud+"' class=\"descarga\" onclick=\"descargarReporte('"+idSolicitudReporte+"','"+numeroSolicitud+"')\">"+dato.nombreArchivoRespuesta+"</a>";
			}
			
			
			
		}
		if(datosConsulta[index].fechaProceso&&!isEmpty(datosConsulta[index].fechaProceso)){
			var milis = datosConsulta[index].fechaProceso;
			milis-=3600000*6;
			datosConsulta[index].fechaProceso=milis;
		}
		if(datosConsulta[index].fechaEnvio&&!isEmpty(datosConsulta[index].fechaEnvio)){
			var milis = datosConsulta[index].fechaEnvio;
			milis-=3600000*6;
			datosConsulta[index].fechaEnvio=milis;
		}
	}
	
	$("#tabResultadoDocacuse").jqGrid({
		datatype: "local",
		colNames: columnas,
		data: datosConsulta,
		colModel: modelo,
		sortname: "idSolicitudReporte",
		rowNum: 30,
		rowList: [10,20,30],
		pager: "pager",
		viewrecords: true,
		sortorder: "asc",
		caption: "Detalles",
		height: '350',
		autowidth: true
	});

	$("#tabResultadoDocacuse").jqGrid( "navGrid", "#pager", {edit: false, add: false, del: false} );
}

function validar()
 {
	var valido = true;
	var fechaInicio = document.getElementById('fechaInicial').value;
	var fechaFin = document.getElementById('fechaFinal').value;
	var valTipoArchivo = document.getElementById('tipoArchivo').value;
	var archivoProcesar = document.getElementById('archivoAProcesar').value;

	if ((fechaInicio.trim() == "" && fechaFin.trim() != "")	|| (fechaInicio.trim() != "" && fechaFin.trim() == "")) {
		MinervaHelperDialogs
				.mostrarError("Debe ingresar el periodo a consultar");
		valido = false;
	} else {
		if (fechaInicio.trim() == "" && fechaFin.trim() == "") {
			if (valTipoArchivo != -1 && archivoProcesar == "") {
				MinervaHelperDialogs
						.mostrarError("Ingrese la informaci�n requerida");
				valido = false;
			} else {
				if (valTipoArchivo == -1 && archivoProcesar != "") {
					valido = false;
				}
			}

		}
	}

	if (valido) {
		consultarReporteMasivo();
	}

	return valido;
}

function changeEstado(){
	var valEstado = $('#idEstadoSel').val();
	if (valEstado != ''){
		LimpiaFecha();
		$('#numSolicitudSel').attr('disabled', 'disabled');	
	}else{
		$('#numSolicitudSel').attr('disabled', false);
	}
}



function changeNumSolicitud()
{
	var valNumSolicitud = $('#numSolicitudSel').val();
	if(valNumSolicitud != "-1"){
		$('#idEstadoSel').val('');
		$('#idEstadoSel').attr('disabled', 'disabled');		
		$('#botonConsultar').removeAttr('disabled', 'disabled');
		deshabilitarFechaSolicitud();
	}else{
		$('#idEstadoSel').val('');
		$('#idEstadoSel').removeAttr('disabled');
		habilitarFechaSolicitud();
	}
};


function LimpiaFecha()
{
//	$('#datetimepicker6a').data("DateTimePicker").clear();
//	$('#datetimepicker6b').data("DateTimePicker").clear();
	$('#fechaInicial').val('');
	$('#fechaFinal').val('');
};

function habilitarFecha()
{
	$('#fechaInicial').attr('disabled', false);
	$('#fechaFinal').attr('disabled', false);
	$('#fechaInicial').val(new Date());
	$('#fechaFinal').val(new Date());
};

function habilitarFechaSolicitud()
{
	$('#fechaInicio').attr('disabled', false);
	$('#fechaFin').attr('disabled', false);
};

function deshabilitarFechaSolicitud()
{
//	$('#fechaInicio').val('');
//	$('#fechaFin').val('');
	LimpiaFecha();
	$('#fechaInicio').attr('disabled', 'disabled');
	$('#fechaFin').attr('disabled', 'disabled');
};


function deshabilitarFecha()
{
	$('#fechaInicial').val('');
	$('#fechaFinal').val('');  

	$('#fechaInicial').attr('disabled', 'disabled');
	$('#fechaFinal').attr('disabled', 'disabled');
};

function descargarReporte(idSolicitudReporte, numeroSolicitud) {
	var url = contexto + "/private/plataforma-operativa/descargaReporteMasivo?idSolicitudReporte=" + idSolicitudReporte+"&numeroSolicitud="+numeroSolicitud;
	$.fileDownload(url).done(function() {
		//MinervaHelperDialogs.mostrarInformacion("Archivo descargado correctamente");
		$('#linkDescarga_' + numeroSolicitud).addClass('descargaDisabled')
	}).fail(function() {
		MinervaHelperDialogs.mostrarInformacion("Ocurrio un error al intentar descargar el archivo");
	});
}


/** masivos **/
function fillNavyBarMasivo(){
	var fillConsulta = '';
	var nombModulo = $('#moduloMasivo option:selected').text();
	var nomProceso = $('#procesoMasivo option:selected').text();
	var nomSubproceso = $('#subProcesoMasivo option:selected').text();
	var nomTipo = $('#tipoReporteMasivo option:selected').text();
	var nomReporte = $('#reporteMasivo option:selected').text();
	

	$('#navBarMinerva').attr('hidden', false);
	$('#navBarMinerva').attr('style',"color:#fff; white-space: nowrap; font-size: 10px;");
	
	if (nombModulo != '' && nombModulo != generico ){
		nombModulo = ' > ' + nombModulo;
	}else{
		nombModulo = '';
	}
	
	if (nomProceso != '' && nomProceso != generico ){
		nomProceso = ' > ' + nomProceso;	
	}else{
		nomProceso = '';
	}
	
	if (nomSubproceso != '' && nomSubproceso != generico  ){
		nomSubproceso = ' > ' + nomSubproceso;	
	}else{
		nomSubproceso = '';
	}
	
	if (nomTipo != '' && nomTipo != generico ){
		nomTipo = ' > ' + nomTipo;	
	}else{
		nomTipo = '';
	}
	
	if (nomReporte != '' && nomReporte != generico ){
		nomReporte = ' > ' + nomReporte;
	}else{
		nomReporte = '';
	}
	
	strConsulta = nombModulo + nomProceso + nomSubproceso + nomTipo + nomReporte;
	$('#navBarMinerva').html(strConsulta);
}

function changeModuloMasivo(preseleccion){
	if (preseleccion != 0){
		$("#moduloMasivo").val(preseleccion);
	}
	
	var nombModulo = $('#moduloMasivo option:selected').text();
		
	$("#procesoMasivo").val(-1);
	$('#procesoMasivo').attr('disabled',true);
		
	if (nombModulo != generico){
		cargaProcesosMasivos(1);
		$("#procesoMasivo").attr('disabled',false);
	}
	fillNavyBarMasivo( );
	changeProcesoMasivos();
}

function changeProcesoMasivos(){
	var nomProceso = $('#procesoMasivo option:selected').text();
	
	$('#subProcesoMasivo').val(-1);
	$("#subProcesoMasivo").attr('disabled',true);
	
	if (nomProceso != generico){
		cargaSubProcesoMasivos();
		$("#subProcesoMasivo").attr('disabled',false);
	}
	fillNavyBarMasivo( );	
	changeSubProcesoMasivo();
}

function changeSubProcesoMasivo(){
	var nomSubproceso = $('#subProcesoMasivo option:selected').text();
	
	$('#tipoReporteMasivo').val(-1);
	$("#tipoReporteMasivo").attr('disabled',true);
		
	if (nomSubproceso != generico){
		$("#tipoReporteMasivo").attr('disabled',false);
		var options = CombosMasivos.optionsTipoReporte(listaTipoReporte, 'idTipoReporte', 'descripcion');
		$("#tipoReporteMasivo").html(options);
	}
	fillNavyBarMasivo( );	
	changeTipoReporteMasivo();
}

function changeTipoReporteMasivo(){
	var nomTipo = $('#tipoReporteMasivo option:selected').text();
	
	$('#reporteMasivo').val(-1);
	$("#reporteMasivo").attr('disabled',true);
	
	inicializaFormulario();

	
	if (nomTipo != generico){
		cargaReportesMasivos();
		$("#tipoReporteMasivo").attr('disabled',true);
	}
	fillNavyBarMasivo( );		
}

function changeReporteMasivo(){
	var nomReporte = $('#reporteMasivo option:selected').text();
	$('#fechaInicial').val('');
	$('#fechaFinal').val(''); 
	$("#archivoAProcesar").val("");
	if (nomReporte == generico){
		inicializaFormulario();
		$("#enviarBtn").addClass('disabled')
	}else{
		$("#enviarBtn").removeClass('disabled');
		
	}
	
	fillNavyBarMasivo( );
}


function activaBtnConsultaSolicitud(){
	var fechaInicial = $('#fechaInicio').val();
	var fechaFinal = $('#fechaFinal').val();
	var idSolicitud = $('#numSolicitudSel').val();
	var idEstado = $('#idEstadoSel').val();
	
	if (idSolicitud != -1 || idEstado != "" || ( fechaInicial != "" && fechaFinal != "" )){
		$("#consultarBtn").removeClass('disabled');
		$("#limpiarBtn").removeClass('disabled');
	}else{
		$("#consultarBtn").addClass('disabled');
		$("#limpiarBtn").addClass('disabled');
	}
}


function activaBtnConsultaMasivo(){
	var fechaInicial = $('#fechaInicio').val();
	var fechaFinal = $('#fechaFinal').val();
	if(fechaInicial != "" && fechaFinal != ""){
		$('#btnConsultaMinerva').attr('disabled', false);
	}else{
		$('#btnConsultaMinerva').attr('disabled', true);			
	}
}


function inicializarFormularioSolicitud(){
	$('#numSolicitudSel').val(-1)
	$('#idEstadoSel').val('');
	$('#idEstadoSel').removeAttr('disabled');
	$('#numSolicitudSel').removeAttr('disabled');
	$('#fechaInicio').val('');
	$('#fechaFin').val('');
	habilitarFechaSolicitud();
	
	$.jgrid.gridUnload("tabResultadoDocacuse");
	$("#consultarBtn").addClass('disabled');
	$("#limpiarBtn").addClass('disabled');
	
	
}



function obtenerParametrosReporteGenericoMasivo(idReporte) {
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