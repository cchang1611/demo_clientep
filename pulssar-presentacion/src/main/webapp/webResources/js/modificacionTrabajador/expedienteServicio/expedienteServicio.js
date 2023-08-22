var datosBaseCurp;
var beneficiarioForm;
var datosDomicilioParticularTrabajador;
var datosDomicilioLaboralTrabajador;
var datosReferenciasTrabajador;
var tipoDeSolicitante;
var modifica = false;
var estatusExpIden;
var estatusExpEnrol;
var listaBeneficiario = [];
var porcentanjeTotal = 0;
var INDICADOR_TELEFONO = "000";
var firmaTrabajador;
var firmaAgente;
var cadenaPdf;

$(document).ready(function() {
	abrirExpedienteServicio();
	
	if(_FLUJO == "2") {
		window.location.href = "#errorModal";
	}
	
	$('#btnErrorM').click(function(event) {
		window.location.href = "datosGenerales.do";
	});
});

function muestraSeccionSolicitudModifDatosPdf(){
	$('#tituloPantalla').empty();
	
	$('#datosGenerales').removeClass("Container");
	$('#datosGenerales').addClass("Container_None");
	$('#noCertificados').removeClass("Container");
	$('#noCertificados').addClass("Container_None");
	$('#datosComplementarios').removeClass("Container");
	$('#datosComplementarios').addClass("Container_None");
	$("#carrusel").removeClass("slick-carousel");
	$("#carrusel").addClass("Container_None");
	$("#botonEnviar").removeClass("ContainerButtonsCenter");
	$("#botonEnviar").addClass("Container_None")
	$("#idSeccionSolicitudModifDatosPdf").removeClass("Container_None");
	$("#idSeccionSolicitudModifDatosPdf").addClass("Container");
	

}

function ReferenciaExp(apellidoPaternoDeReferencia1,apellidoMaternoDeReferencia1, nombreDeReferencia1, curpDeReferencia1, telefonoDeReferencia1, parentescoORelacionDeReferencia1, apellidoPaternoDeReferencia2, apellidoMaternoDeReferencia2, nombreDeReferencia2, curpDeReferencia2, telefonoDeReferencia2, parentescoORelacionDeReferencia2){
	this.apellidoPaternoDeReferencia1 = apellidoPaternoDeReferencia1
	this.apellidoMaternoDeReferencia1 = apellidoMaternoDeReferencia1
	this.nombreDeReferencia1 = nombreDeReferencia1
	this.curpDeReferencia1 = curpDeReferencia1
	this.telefonoDeReferencia1 = telefonoDeReferencia1
	this.parentescoORelacionDeReferencia1 = parentescoORelacionDeReferencia1
	this.apellidoPaternoDeReferencia2 = apellidoPaternoDeReferencia2
	this.apellidoMaternoDeReferencia2 = apellidoMaternoDeReferencia2
	this.nombreDeReferencia2 = nombreDeReferencia2
	this.curpDeReferencia2 = curpDeReferencia2
	this.telefonoDeReferencia2 = telefonoDeReferencia2
	this.parentescoORelacionDeReferencia2 = parentescoORelacionDeReferencia2
}

function DomicilioExp(calle, numeroExterior, numeroInterior, colonia, delegacionOMunicipio, codigoPostal, entidadFederativa, pais, indicadorDeTelefono1, telefono1, extension1, indicadorDeTelefono2, telefono2, extension2, correoElectronicoDelTrabajador){
	this.calle = calle
	this.numeroExterior = numeroExterior
	this.numeroInterior = numeroInterior
	this.colonia = colonia
	this.delegacionOMunicipio = delegacionOMunicipio
	this.codigoPostal = codigoPostal
	this.entidadFederativa = entidadFederativa
	this.pais = pais
	this.indicadorDeTelefono1 = indicadorDeTelefono1
	this.telefono1 = telefono1
	this.extension1 = extension1
	this.indicadorDeTelefono2 = indicadorDeTelefono2
	this.telefono2 = telefono2
	this.extension2 = extension2
	this.correoElectronicoDelTrabajador = correoElectronicoDelTrabajador
}

function DomicilioLaboralExp(calle, numeroExterior, numeroInterior, colonia, delegacionOMunicipio, codigoPostal, entidadFederativa, pais){
	this.calle = calle
	this.numeroExterior = numeroExterior
	this.numeroInterior = numeroInterior
	this.colonia = colonia
	this.delegacionOMunicipio = delegacionOMunicipio
	this.codigoPostal = codigoPostal
	this.entidadFederativa = entidadFederativa
	this.pais = pais
}

function BeneficiarioFormExp(curp, nombre, apellidoPaterno, apellidoMaterno, parentesco, porcentaje){
	this.curpDeBeneficiario = curp
	this.nombreDeBeneficiario = nombre
	this.apellidoPaternoDeBeneficiario = apellidoPaterno
	this.apellidoMaternoDeBeneficiario = apellidoMaterno
	this.parentescoORelacion = parentesco
	this.porcentajeDeBeneficiario = porcentaje
}

function ListaBeneficiariosExp(listaBeneficiario){
	this.beneficiario = listaBeneficiario;
}

function DatosBaseCurpExp(curpNueva, rfc, nombreTrabajador, apellidoPaterno, apellidoMaterno, 
		               fechaDeNacimiento, sexo, entidadFederativaDeNacimiento, nacionalidad, 
		               claveDeTipoDeDocumentoProbatorio, folioDeLaSolicitud, documentoProbatorio, 
		               folioDeDocumentoProbatorio, ocupacionOProfesionTrabajador, actividadOGiroNegocioTrabajador, 
		               nivelDeEstudioTrabajador, curpSolicitante, tipoSolicitante){
	
	this.curpNueva = curpNueva
	this.rfc = rfc
	this.nombreTrabajador = nombreTrabajador
	this.apellidoPaterno = apellidoPaterno
	this.apellidoMaterno = apellidoMaterno
	this.fechaDeNacimiento = fechaDeNacimiento
	this.sexo = sexo
	this.entidadFederativaDeNacimiento = entidadFederativaDeNacimiento
	this.nacionalidad = nacionalidad
	this.claveDeTipoDeDocumentoProbatorio = claveDeTipoDeDocumentoProbatorio
	this.folioDeLaSolicitud = folioDeLaSolicitud
	this.documentoProbatorio = documentoProbatorio
	this.folioDeDocumentoProbatorio = folioDeDocumentoProbatorio
	this.ocupacionOProfesionTrabajador = ocupacionOProfesionTrabajador
	this.actividadOGiroNegocioTrabajador = actividadOGiroNegocioTrabajador
	this.nivelDeEstudioTrabajador = nivelDeEstudioTrabajador
	this.curpSolicitante = curpSolicitante
	this.tipoSolicitante = tipoSolicitante
}


function cargaObjetosExp(){
	if($("#calle").val() != ''){
	datosDomicilioParticularTrabajador = new DomicilioExp($.trim($("#calle").val()),
			 										   $.trim($("#noExterior").val()),
			 										   $.trim($("#noInterior").val()),
			 										   $.trim($("#colonia").val()),
			 										   $.trim($("#municipio").val()),
			 										   $.trim($("#codigoPostal").val()),
			 										   $.trim($("#entidadFederativa").val()),
			 										   $.trim($("#pais option:selected").text()),
			 										   INDICADOR_TELEFONO,
			 										   $.trim($("#telefono1").val()),
			 										   $.trim($("#extension1").val()),
			 										   INDICADOR_TELEFONO,
			 										   $.trim($("#telefono2").val()),
			 										   $.trim($("#extension2").val()),
			 										   $.trim($("#correoElectronico").val()));
	}else{
		datosDomicilioParticularTrabajador = null;
	}
	
	if($("#calleLaboral").val() != ''){
	datosDomicilioLaboralTrabajador = new DomicilioLaboralExp($.trim($("#calleLaboral").val()),
														   $.trim($("#noExteriorLaboral").val()),
														   $.trim($("#noInteriorLaboral").val()),
														   $.trim($("#coloniaLaboral").val()),
														   $.trim($("#municipioLaboral").val()),
														   $.trim($("#codigoPostalLaboral").val()),
														   $.trim($("#entidadFederativaLaboral").val()),
														   $.trim($("#paisLaboral option:selected").text()));
	}else{
		datosDomicilioLaboralTrabajador = null;
	}

	if($("#apellidoPaternoRef").val() != ''){
	datosReferenciasTrabajador = new ReferenciaExp($.trim($("#apellidoPaternoRef").val()),
												$.trim($("#apellidoMaternoRef").val()),
												$.trim($("#nombreReferencia").val()),
												$.trim($("#curpReferencia").val()),
												$.trim($("#telefonoReferencia").val()),
												$.trim($("#parentescoRef option:selected").text()),
												$.trim($("#apellidoPaternoRef2").val()),
												$.trim($("#apellidoMaternoRef2").val()),
												$.trim($("#nombreReferencia2").val()),
												$.trim($("#curpReferencia2").val()),
												$.trim($("#telefonoReferencia2").val()),
												$.trim($("#parentescoRef2 option:selected").text()));
	}else{
		datosReferenciasTrabajador = null;
	}
	
	if($("#apellidoPaterno").val() != ''){
	datosBaseCurp = new DatosBaseCurpExp($.trim($('#curp').val()),
									  $.trim($('#rfc').val()),
									  $.trim($('#nombre').val()),
									  $.trim($('#apellidoPaterno').val()),
									  $.trim($('#apellidoMaterno').val()),
									  $.trim($('#fechaNacimiento').val()),
									  $.trim($('#genero option:selected').text()),
									  $.trim($('#entidadNacimiento option:selected').text()),
									  $.trim($('#claveNacionalidad option:selected').text()),
									  $.trim($('#claveTipoDocProbatorio').val()),
									  $.trim($('#folioSolicitud').val()),
									  $.trim($('#documentoProbatorio').val()),
									  $.trim($('#folioDocumentoProbatorio').val()),
									  $.trim($('#ocupacion option:selected').text()),
									  $.trim($('#giro option:selected').text()),
									  $.trim($('#estudios option:selected').text()),
									  $.trim($('#curpSolicitante').val()),
				                      $.trim($('#tipoSolicitante').val()));
	}else{
		datosBaseCurp = null;
	}
	
	var hayRegistros = $("#tablaBeneficiarios tbody tr").find('input[type="checkbox"]').val() != undefined;
	if(hayRegistros) {
		var dataJSON = {};
		listaBeneficiario = [];
		$("#tablaBeneficiarios tbody").find('tr').each(function(i){
			$(this).find('td').each(function(h){
				switch (h) {
					case 1:
						dataJSON.curpBen = $.trim($(this).text());
						break;
					case 2:
						dataJSON.nombreBen = $.trim($(this).text());
						break;
					case 3:
						dataJSON.paterno = $.trim($(this).text());
						break;
					case 4:
						dataJSON.materno = $.trim($(this).text());
						break;
					case 5:
						dataJSON.parentescoORelacion = $.trim($(this).text());  
						break;
					case 6:
						dataJSON.porcentaje = $.trim($(this).text());
						beneficiarioForm = new BeneficiarioFormExp(dataJSON.curpBen, dataJSON.nombreBen, dataJSON.paterno, dataJSON.materno, dataJSON.parentescoORelacion, dataJSON.porcentaje);
				        listaBeneficiario.push(beneficiarioForm);
						break;
				}
			});
		});
	}

}


function generarPdfSolicitudModificacionDeDatos(){
	cargaObjetosExp();
	
	if(listaBeneficiario.length >= 1){
	    var beneficiariosList =new ListaBeneficiariosExp(listaBeneficiario);
	}else{
		var beneficiariosList = null;
	}
	
	var data = JSON.stringify({
							   firmaAgente:firmaAgente,
							   firmaTrabajador: firmaTrabajador,
							   datosBaseCurp: datosBaseCurp,
							   datosDomicilioParticularTrabajador: datosDomicilioParticularTrabajador,
							   datosDomicilioLaboralTrabajador: datosDomicilioLaboralTrabajador,
							   datosReferenciasTrabajador: datosReferenciasTrabajador,
							   listaBeneficiariosTrabajador: beneficiariosList
							  });
	
	
	$.ajax({
		url : 'generarSolicitudModifDatosPdf.do',
		type : "POST",
		contentType : 'application/json',
		dataType: 'json',
		data    : data,
		async : false,
		beforeSend : function() {
			window.location.href = "#modalLoader";
		}
	}).success(function(result) {		
		window.location.href = "#";

		 cadenaPdf = result.ruta;
		compatibilidadPdf(result.contenido);
		if(result.numeroPaginas == 1){
			$("#prevbutton").css("display", "none");
			$("#nextbutton").css("display", "none");
		}else{
			$("#prevbutton").removeAttr("disabled");
			$("#nextbutton").removeAttr("disabled");
		}
		validaFlujo9B();
	}).error(function (jqXHR, textStatus, errorThrown){
		alert("Se produjo un error inesperado Solicitud Modificacion Datos Pdf ",errorThrown);
		window.location.href = "datosGenerales.do";
	});
	
}

function downloadPDF() {
	    var byteCharacters = window.atob(cadenaPdf);
	    var byteNumbers = new Array(byteCharacters.length);
	    for (var i = 0; i < byteCharacters.length; i++) {
	        byteNumbers[i] = byteCharacters.charCodeAt(i);
	    }
	    var byteArray = new Uint8Array(byteNumbers);
	   if (window.navigator && window.navigator.msSaveOrOpenBlob) {
	        var blob = new Blob([byteArray], { type: 'application/pdf' });
	        window.navigator.msSaveOrOpenBlob(blob, "Solicitud" + CURP + new Date().toDateString() + ".pdf");
	}
	else {
	    var a = window.document.createElement("a");
        var blob = new Blob([byteArray], { type: 'application/pdf' });
	    a.href = window.URL.createObjectURL(blob);
	    a.download = "Solicitud" + CURP + new Date().toDateString() + ".pdf";
	    document.body.appendChild(a);
	    a.click();  // IE: "Access is denied"; see: https://connect.microsoft.com/IE/feedback/details/797361/ie-10-treats-blob-url-as-cross-origin-and-denies-access
	    document.body.removeChild(a);
	}
}




function abrirExpedienteServicio(){
	firmaAgente = "";
	firmaTrabajador = "";
//	muestraSeccionSolicitudModifDatosPdf();
	generarPdfSolicitudModificacionDeDatos();
}

function muestraModal(titulo, mensaje){
	window.location.href = "#";
	var tituloModal = "<h2 class='ModalTitle' >"+titulo+"</h2><a href='#' class='ModalButton' id='btnActExp'>X</a>";
	var mensajeModal = "ERROR: "+mensaje+".";
	$('#tituloActExp').empty();
	$('#mensajeActExp').empty();
	$('#tituloActExp').append(tituloModal);
	$('#mensajeActExp').append(mensajeModal);
	window.location.href = "#modalActExp";
}

function consultaMensajeMdd(rechazo){
	var objetoRespuesta = null;
	console.log("consulta mensaje");
	$.ajax({
		url : 'catalogoMensajes.do',
		type : "GET",
		contentType : 'application/json',
		dataType: 'json',
		async : false,
		data : {codigo : rechazo}
	}).success(function(resultado) {
		objetoRespuesta = resultado;
	})
	return objetoRespuesta;
}



function cancelarSolicitudFlujo9B(){
	$('#cancelarModalSolicitud9B').attr('disabled',true);
	consultaMensajeFlujo9B('M39B');
}



function consultaMensajeFlujo9B(rechazo){
	var mensajeModal = consultaMensajeMdd(rechazo);
	window.location.href = "#";
	document.getElementById('tituloModalCancelacion9B').innerHTML = mensajeModal.titulo;
	document.getElementById('mensajeModalCancelacion9B').innerHTML = mensajeModal.mensaje;
	window.location.href = "#modalCancelacion9B";
}


function cerrarModalCancelar9B(){
	$('#cerrarModalCancelacion9B').attr('disabled',true);
	terminarProceso();
}

function validaFlujo9B(){
	if(BANDERA9B != "" && firmaAgente != "" && AFORE == '568'){
		var mensajeModal = consultaMensajeMdd("M69B");
		window.location.href = "#";
		$("#continuarModalSolicitud9B").prop('onclick', null);
		$("#continuarModalSolicitud9B").prop('href', "#");
		document.getElementById('tituloModalSolicitud9B').innerHTML = mensajeModal.titulo;
		document.getElementById('mensajeModalSolicitud9B').innerHTML = mensajeModal.mensaje;

		window.location.href = "#modalSolicitud9B";
	}
	
}





	
	