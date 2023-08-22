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

var datosDomicilioParticularTrabajadorExpe;
var datosDomicilioLaboralTrabajadorExpe;
var datosReferenciasTrabajadorExpe;
var datosBaseCurpExpe;
var beneficiarioFormExpe;
var listaBeneficiarioExpe = [];

var entidadCompleta;
var partes;
var entidad;
var porcentajesArreglo = [];
var curpsBeneficiariosArreglo = [];
var respuestaBeneficiariosArreglo = [];
var rfcBd;
var reconformaExp = "0";

var datosGeneralesSolicitante;
var datosDomicilioSolicitante;

    /*
	 * Funcion para cargar componentes html en una sola jsp
	 * 
	 */
	$(document).ready(function() {
		if(_FLUJO == "2") {
			window.location.href = "#errorModal";
		}
		
		$('#btnErrorM').click(function(event) {
			window.location.href = "datosGenerales.do";
		});
		
		if(CURP_VACIA == "1"){
			window.location.href = "#curpFaltante";
		}
		var _titulo = "<h1>Datos Certificables</h1>";
		$('#tituloPantalla').empty();
		$('#tituloPantalla').append(_titulo);
		$('#entidadNacimiento').val($("#entidad").val()).prop('selected', true);
		$('#genero').val($("#sexo").val()).prop('selected', true);
		$('#claveNacionalidad').val($("#nacionalidadAct").val()).prop('selected', true);
		$('#claveTipoDocProbatorio').val($("#tipoDoctoAct").val()).prop('selected', true);
		$('#ocupacion').val($("#ocupacionAct").val()).prop('selected', true);
		$('#giro').val($("#giroAct").val()).prop('selected', true);
		$('#estudios').val($("#nivelAct").val()).prop('selected', true);
		$('#pais').val($("#paisParticularAct").val()).prop('selected', true);
		$('#paisSolicitante').val($("#paisParticularAct").val()).prop('selected', true);
		$('#paisLaboral').val($("#paisLaboralAct").val()).prop('selected', true);
		cargaEntidades(1);
		cargaEntidadesLaboral(1);
		cargaEntidadesSolicitante(1);
		$('#entidadFederativa').val($("#entidadParticularAct").val()).prop('selected', true);
		$('#entidadFederativaSolicitante').val($("#entidadParticularAct").val()).prop('selected', true);
		$('#entidadFederativaLaboral').val($("#entidadLaboralAct").val()).prop('selected', true);
		$('#municipio').val($("#municipioParticularAct").val()).prop('selected', true);
		$('#municipioSolicitante').val($("#municipioParticularAct").val()).prop('selected', true);
		$('#municipioLaboral').val($("#municipioLaboralAct").val()).prop('selected', true);
		$('#parentescoRef').val($("#parentescoRefAct1").val()).prop('selected', true);
		$('#parentescoRef2').val($("#parentescoRefAct2").val()).prop('selected', true);
		estatusExpIden = $.trim($('#expIden').val());
		estatusExpEnrol = $.trim($('#expEnrolamiento').val());
		var tipoSolicitante = $.trim($('#tipoSolicitante').val());
		var curpTitular = $.trim($('#curp').val());
		var curpSolicitante = $.trim($('#campoCurpSolicitante').val());
		tipoDeSolicitante = +tipoSolicitante;
		
		if(TIPOSOLICITANTE == '01'){
//			document.getElementById('solicitante').style.display='block';
			$("#solicitante").css("display", "block");
			$("#curpSolicitante").val(curpTitular);
			$("#curpSolicitante").prop('disabled', true);
		}else{
			$("#curpSolicitante").val(curpSolicitante);
//			document.getElementById('solicitante').style.display='block';
			$("#solicitante").css("display", "block");
		}
		
		if(TIPOSOLICITANTE =='02'){
			$("#agregarBeneficiario").css("display", "none");
			$("#eliminarBeneficiario").css("display", "none");
			if(BANDERA_BLOQUEO_BOTON == "0"){
				$("#editarBeneficiario").css("display", "none");
				$("#checkboxBeneficiario").attr("disabled",true);
			}
		}
		
		if($.trim($("#calle").val()) != "") {
			datosDomicilioParticularReglas();
		}
		
		if($.trim($("#calleLaboral").val()) != "") {
			datosDomicilioLaboralReglas();
		}
		if($.trim($("#nombreReferencia").val()) != "" || $.trim($("#nombreReferencia2").val()) != "") {
			datosReferenciasReglas();
		}
		var subString = $("#folioSolicitud").val();
		$("#folioSolicitud").val(subString.substring(10,20));
		
		if($("#banderaSecciones").val() == "1" ){
			$("#tituloReferencias").css("display", "none");
			$("#tituloBeneficiarios").css("display", "none");

//			document.getElementById("tituloReferencias").style.display = "none";
//			document.getElementById("tituloBeneficiarios").style.display = "none";
		}
		
		continuacionFlujoValidacionRenapo();
		
		$("#pais").change(function() {
			cargaEntidades(2);
			agregarPais();
		});
		
		$("#paisLaboral").change(function() {
			cargaEntidadesLaboral(2);
		});
		
		$("#paisSolicitante").change(function() {
			cargaEntidadesSolicitante(2);
		});
		
		validacionDireccionParticular();
		validacionDireccionLaboral();
		if("568" != AFORE){
			validacionDireccionSolicitante();
		}
		
		var numeroExistenteBeneficiarios = validaNumeroBeneficiarios();
		if(numeroExistenteBeneficiarios >= NUMERO_BENEFICIARIOS_PERMITIDOS){
			$("#agregarBeneficiario").css("display", "none");
		}
		
		var numeroBeneficiariosExistentes = NUMERO_BENEFICIARIOS_EXISTENTES;
		if(0 == numeroBeneficiariosExistentes){
			$("#divCheckBox").css('display', "block");
		}
		
		$('#checkSinDesiganrBeneficiarios').change(function () {
			var valorCheck = $('#checkSinDesiganrBeneficiarios').prop('checked');
			if(valorCheck){
				$("#mensajeCheckObligatorio").empty();
				$("#agregarBeneficiario").css("display", "none");
			}else{
				if(TIPOSOLICITANTE != '02'){
					$("#agregarBeneficiario").removeAttr("style");
				}
			}
		 });
		
		
		if(TIPOSOLICITANTE != '01'){
			if("568" != AFORE){
				$("#paisSolicitante").attr("disabled",true);
				$("#entidadFederativaSolicitante").attr("disabled",true);
				$("#municipioSolicitante").attr("disabled",true);
				$("#coloniaSolicitante").attr("disabled",true);
				
				$("#mensajeCodigoPostalSolicitante").empty();
				$("#mensajeCodigoPostalSolicitante").removeAttr('hidden');
				$("#mensajeCodigoPostalSolicitante").append("Primero debe agregar un codigo postal");
				
				datosGeneralesSolicitanteReglas();
				datosDireccionSolicitanteReglas();
			}else{
				$("#curpSolicitanteSeccion").attr("disabled",true);
				$("#nombreSolicitante").attr("disabled",true);
				$("#apellidoPaternoSolicitante").attr("disabled",true);
				$("#apellidoMaternoSolicitante").attr("disabled",true);				
				$("#calleSolicitante").attr("disabled",true);
				$("#noExteriorSolicitante").attr("disabled",true);
				$("#noInteriorSolicitante").attr("disabled",true);				
				$("#paisSolicitante").attr("disabled",true);
				$("#entidadFederativaSolicitante").attr("disabled",true);
				$("#municipioSolicitante").attr("disabled",true);
				$("#coloniaSolicitante").attr("disabled",true);
				$("#codigoPostalSolicitante").attr("disabled",true);
				datosGeneralesSolicitanteReglas();
				datosDireccionSolicitanteReglas();
			}
		}
		
//		$(document).on("change","#colonia",function(){
//			console.log("prueba de cambio")
//		});
//		const valorColonia = document.getElementById("colonia")

//		valorColonia.addEventListener('input', agregarColonia);
//		$(document).on("change","#colonia",function(){
//			  agregarColonia();
//		});

	});
	
	function validacionDireccionParticular(){
		var callePC = $("#calle").val();
		var coloniaPC = $("#colonia").val();
		var entidadPC = $("#entidadFederativa").val();
		var municipioPC = $("#municipio").val();
		if(callePC == null || callePC == "" || coloniaPC == null || coloniaPC == ""){
			$("#pais").attr("disabled",true);
			$("#entidadFederativa").attr("disabled",true);
			$("#municipio").attr("disabled",true);
			$("#colonia").attr("disabled",true);
			
			$("#mensajeCodigoPostal").empty();
			$("#mensajeCodigoPostal").removeAttr('hidden');
			$("#mensajeCodigoPostal").append("Primero debe agregar un codigo postal");
			
			if(TIPOSOLICITANTE != '01' && AFORE == '568'){
				$("#mensajeTercero").empty();
				$("#mensajeTercero").removeAttr('hidden');
				$("#mensajeTercero").append("La dirección particular del Titular es necesaria para los trámites generados por un Tercero");
			}
		}
		
		
		if(entidadPC == null || entidadPC == "" || municipioPC == null || municipioPC == ""){
			$("#pais").attr("disabled",true);
			$("#entidadFederativa").attr("disabled",true);
			$("#municipio").attr("disabled",true);
			$("#colonia").attr("disabled",true);
			
			$("#codigoPostal").val(null);
			
			$("#mensajeCodigoPostal").empty();
			$("#mensajeCodigoPostal").removeAttr('hidden');
			$("#mensajeCodigoPostal").append("Primero debe agregar un codigo postal");
			if(TIPOSOLICITANTE != '01' && AFORE == '568'){
				$("#mensajeTercero").empty();
				$("#mensajeTercero").removeAttr('hidden');
				$("#mensajeTercero").append("La dirección particular del Titular es necesaria para los trámites generados por un Tercero");
			}
		}

	}
	
	function validacionDireccionSolicitante(){
		var calleSolicitante = $("#calleSolicitante").val();
		var coloniaSolicitante = $("#coloniaSolicitante").val();
		var entidadSolicitante = $("#entidadFederativaSolicitante").val();
		var municipioSolicitante = $("#municipioSolicitante").val();
		if(calleSolicitante == null || calleSolicitante == "" || coloniaSolicitante == null || coloniaSolicitante == ""){
			$("#paisSolicitante").attr("disabled",true);
			$("#entidadFederativaSolicitante").attr("disabled",true);
			$("#municipioSolicitante").attr("disabled",true);
			$("#coloniaSolicitante").attr("disabled",true);
			
			$("#mensajeCodigoPostalSolicitante").empty();
			$("#mensajeCodigoPostalSolicitante").removeAttr('hidden');
			$("#mensajeCodigoPostalSolicitante").append("Primero debe agregar un codigo postal");
		}
		
		
		if(entidadSolicitante == null || entidadSolicitante == "" || municipioSolicitante == null || municipioSolicitante == ""){
			$("#paisSolicitante").attr("disabled",true);
			$("#entidadFederativaSolicitante").attr("disabled",true);
			$("#municipioSolicitante").attr("disabled",true);
			$("#coloniaSolicitante").attr("disabled",true);
			
			$("#codigoPostalSolicitante").val(null);
			
			$("#mensajeCodigoPostalSolicitante").empty();
			$("#mensajeCodigoPostalSolicitante").removeAttr('hidden');
			$("#mensajeCodigoPostalSolicitante").append("Primero debe agregar un codigo postal");
		}

	}
	
	function validacionDireccionLaboral(){
		var calleLC = $("#calleLaboral").val();
		var coloniaLC = $("#coloniaLaboral").val();
		var entidadLC = $("#coloniaLaboral").val();
		var municipioLC = $("#entidadFederativaLaboral").val();
		if(calleLC !== "" && coloniaLC !== ""){
			if(entidadLC == null || entidadLC == "" && municipioLC == null || municipioLC == ""){
				$("#mensajeLaboral").empty();
				$("#mensajeLaboral").removeAttr('hidden');
				$("#mensajeLaboral").append("Seleccione una entidad y municipio");
			}
			
		}
		
	}
	
	function actualizaCurp(){
		var curpNueva = $.trim($('#curp').val());
		if(TIPOSOLICITANTE == '01'){
			$("#curpSolicitante").val(curpNueva);
			$("#curpSolicitante").prop('disabled', true);
		}
	}
	
	function muestraNoCertificados(){
		var _titulo = "<h1>Datos No Certificables</h1>";
		$('#tituloPantalla').empty();
		$('#tituloPantalla').append(_titulo);
		
		$('#noCertificados').removeClass("Container_None");
		$('#noCertificados').addClass("Container");
		$('#datosGenerales').removeClass("Container");
		$('#datosGenerales').addClass("Container_None");
		$('#datosSolicitante').removeClass("Container");
		$('#datosSolicitante').addClass("Container_None");
		$('#datosComplementarios').removeClass("Container");
		$('#datosComplementarios').addClass("Container_None");
	}
	
	function muestraCertificados(){
		var _titulo = "<h1>Datos Certificables</h1>";
		$('#tituloPantalla').empty();
		$('#tituloPantalla').append(_titulo);
		
		$('#datosGenerales').removeClass("Container_None");
		$('#datosGenerales').addClass("Container");
		$('#noCertificados').removeClass("Container");
		$('#noCertificados').addClass("Container_None");
		$('#datosSolicitante').removeClass("Container");
		$('#datosSolicitante').addClass("Container_None");
		$('#datosComplementarios').removeClass("Container");
		$('#datosComplementarios').addClass("Container_None");
	}
	
	function muestraComplementarios(){
		var _titulo = "<h1>Datos Complementarios</h1>";
		$('#tituloPantalla').empty();
		$('#tituloPantalla').append(_titulo);
		
		$('#datosGenerales').removeClass("Container");
		$('#datosGenerales').addClass("Container_None");
		$('#noCertificados').removeClass("Container");
		$('#noCertificados').addClass("Container_None");
		$('#datosSolicitante').removeClass("Container");
		$('#datosSolicitante').addClass("Container_None");
		$('#datosComplementarios').removeClass("Container_None");
		$('#datosComplementarios').addClass("Container");
	}
	
	function muestraDatosSolicitante(){
		var _titulo = "<h1>Datos Solicitante</h1>";
		$('#tituloPantalla').empty();
		$('#tituloPantalla').append(_titulo);
		
		$('#datosGenerales').removeClass("Container");
		$('#datosGenerales').addClass("Container_None");
		$('#noCertificados').removeClass("Container");
		$('#noCertificados').addClass("Container_None");
		$('#datosComplementarios').removeClass("Container");
		$('#datosComplementarios').addClass("Container_None");
		$('#datosSolicitante').removeClass("Container_None");
		$('#datosSolicitante').addClass("Container");
	}
	
	function muestraResultado(){
		var _titulo = "<h1>Resultado Actualización de Datos</h1>";
		$('#tituloPantalla').empty();
		$('#tituloPantalla').append(_titulo);
//		document.getElementById('botonEnviar').style.display='none';
//		document.getElementById('carrusel').style.display='none';
//		document.getElementById('resultado').style.display='block';
		
		$("#botonEnviar").css("display", "none");
		$("#carrusel").css("display", "none");
		$("#resultado").css("display", "block");

		
		$('#datosGenerales').removeClass("Container");
		$('#datosGenerales').addClass("Container_None");
		$('#noCertificados').removeClass("Container");
		$('#noCertificados').addClass("Container_None");
		$('#datosComplementarios').removeClass("Container");
		$('#datosComplementarios').addClass("Container_None");
	}
	
function validaPorcentaje(porcentaje){
	if(porcentaje < 100 ){
		porcentaje = '0'+porcentaje;
	}
	return porcentaje;
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

/*
 * Funcion para cargar componentes html en una sola jsp
 * 
 */
function actualizaSubmit() {
	window.location.href = "#modalLoader";
	const sustituir = /[^a-zA-Z\s]/g;
	var curpAct = $.trim($('#curpAct').val()).toUpperCase();
	var nombreAct = $.trim($('#nombreAct').val()).toUpperCase();
	nombreAct = nombreAct.replace(sustituir,"!");
	var apellidoPaternoAct = $.trim($('#apellidoPaternoAct').val()).toUpperCase();
	apellidoPaternoAct = apellidoPaternoAct.replace(sustituir,"!");
	var apellidoMaternoAct = $.trim($('#apellidoMaternoAct').val()).toUpperCase();
	apellidoMaternoAct = apellidoMaternoAct.replace(sustituir,"!");
	var fechaNacimientoAct = $.trim($('#fechaNacimientoAct').val());
	var generoAct = $.trim($('#sexoCompara').val());
	var entidadAct = $.trim($('#entidadCompara').val());
	var rfcAct = $.trim($('#rfcAct').val());
	var nacionalidadAct = $.trim($('#nacionalidadAct').val());
	var tipoDoctoAct = $.trim($('#tipoDoctoAct').val());
	var folioSolicitudAct = $.trim($('#folioSolicitudAct').val());
	var documentoProbatorioAct = $.trim($('#documentoProbatorioAct').val());
	var folioDocumentoProbatorioAct = $.trim($('#folioDocumentoProbatorioAct').val());
	var ocupacionAct = $.trim($('#ocupacionAct').val());
	var giroAct = $.trim($('#giroAct').val());
	var nivelAct = $.trim($('#nivelAct').val());
	var curp = $.trim($('#curp').val());
	var nombre = $.trim($('#nombre').val());
	var tipoSolicitante = $.trim($('#tipoSolicitante').val());
	
	
		var curpNueva = $.trim(document.getElementById("curp").value);
		var nombreNuevo = $.trim(document.getElementById("nombre").value);
		var apellidoPaternoNuevo = $.trim(document.getElementById("apellidoPaterno").value);
		var apellidoMaternoNuevo = $.trim(document.getElementById("apellidoMaterno").value);
		var fechaNacimientoNuevo = $.trim(document.getElementById("fechaNacimiento").value);
		var generoNuevo = $.trim(document.getElementById("genero").value);
		var entidadNacimientoNuevo = $.trim(document.getElementById("entidadNacimiento").value);


		var data = JSON.stringify({
									curpNueva:curpNueva,
									nombreNuevo:nombreNuevo, 
									apellidoPaternoNuevo:apellidoPaternoNuevo, 
									apellidoMaternoNuevo:apellidoMaternoNuevo, 
									fechaNacimientoNuevo:fechaNacimientoNuevo, 
									generoNuevo:generoNuevo, 
									entidadNacimientoNuevo:entidadNacimientoNuevo
									});
		validaComparacionDatosBase(data);
	
	if (modifica == true) {
		console.log("Enviendo Submit actualizaTrabajador 1");
		$("#actualizaTrabajador").submit();
	}else{
		
		if(TIPOSOLICITANTE != '01'){
			if("5" == estatusExpIden){
				modifica = true;
			}else{
				modifica = false;
			}
		}else{
			if("5" == estatusExpIden && "5" == estatusExpEnrol ){
				modifica = true;
			}else{
				modifica = false;
			}
		}

		
		if(TIPOSOLICITANTE == '02'){
			modifica = true;
		}
		console.log("Enviendo Submit actualizaTrabajador 2");
		$("#actualizaTrabajador").submit();
		
	}
	var estaVacioDatosCertificados = validaDatosCertificados();
	var estaVacioDatosNoCertificados = validaDatosNoCertificados();
	var estaVacioDatosComplementarios = validaDatosComplementarios();
	var estaVacioDatosLaboral = validaDatosLaboral();
	var estaVacioDatosSolicitante = validaDatosSolicitante();
	if (estaVacioDatosCertificados){
		muestraModal("Validación Formulario","Faltan datos por capturar en Datos Certificados");
	}else if (estaVacioDatosNoCertificados){
		muestraModal("Validación Formulario","Faltan datos por capturar en Datos No Certificados");
	}else if(estaVacioDatosComplementarios){
		muestraModal("Validación Formulario","Faltan datos por capturar en Datos Complementarios");
	}else if(estaVacioDatosLaboral){
		muestraModal("Validación Formulario","Faltan datos por capturar en Datos Complementarios");
	}else if(estaVacioDatosSolicitante){
		muestraModal("Validación Formulario","Faltan datos por capturar en Datos Solicitante");
	}
}

function validaComparacionDatosBase(entrada){
	$.ajax({
		url : 'validaComparacionDatosBase.do',
		type : "POST",
		contentType : 'application/json',
		dataType: 'json',
		data : entrada,
		async : false,
	}).success(function(resultadoComparacion) {
		if("1" == resultadoComparacion){
			modifica = true;
		}
		
	})
}

function cargaObjetos(){
	if($("#calle").val() != ''){
		if($("#entidadFederativa").val() != ''){
			 entidadCompleta = $.trim($("#entidadFederativa option:selected").text());
			 if(entidadCompleta != ''){
				 partes = entidadCompleta.split(" ");
				 entidad = partes[0];
			 }else{
				 entidad = $("#cvEntidadDomicilio").val();
			 }
			
		}
	datosDomicilioParticularTrabajador = new Domicilio($.trim($("#calle").val()).toUpperCase(),
			 										   $.trim($("#noExterior").val())=="" ? null : $.trim($("#noExterior").val()).toUpperCase(),
			 										   $.trim($("#noInterior").val())=="" ? null : $.trim($("#noInterior").val()).toUpperCase(),
			 										   $.trim($("#colonia").val()).toUpperCase(),
			 										   $.trim($("#municipio").val()).toUpperCase(),
			 										   $.trim($("#codigoPostal").val()),
			 										   $.trim($("#entidadFederativa").val()).toUpperCase(),
			 										   $.trim($("#pais").val()).toUpperCase(),
			 										   INDICADOR_TELEFONO,
			 										   $.trim($("#telefono1").val()),
			 										   $.trim($("#extension1").val())=="" ? null : $.trim($("#extension1").val()),
			 										   INDICADOR_TELEFONO,
			 										   $.trim($("#telefono2").val())=="" ? "0000000000" : $.trim($("#telefono2").val()),
			 										   $.trim($("#extension2").val()) == "" ? null : $.trim($("#extension2").val()),
			 										   $.trim($("#correoElectronico").val()) == "" ? null : $.trim($("#correoElectronico").val()),
													   $.trim(entidad) == "" ? null : $.trim(entidad));
													  
	}else{		
		datosDomicilioParticularTrabajador = null;
	}
	
	if($("#calleLaboral").val() != ''){
	datosDomicilioLaboralTrabajador = new DomicilioLaboral($.trim($("#calleLaboral").val()).toUpperCase(),
														   $.trim($("#noExteriorLaboral").val()) == "" ? null : $.trim($("#noExteriorLaboral").val()).toUpperCase(),
														   $.trim($("#noInteriorLaboral").val()) == "" ? null : $.trim($("#noInteriorLaboral").val()).toUpperCase(),
														   $.trim($("#coloniaLaboral").val()).toUpperCase(),
														   $.trim($("#municipioLaboral").val()).toUpperCase(),
														   $.trim($("#codigoPostalLaboral").val()),
														   $.trim($("#entidadFederativaLaboral").val()).toUpperCase(),
														   $.trim($("#paisLaboral").val()).toUpperCase());
	}else{
		datosDomicilioLaboralTrabajador = null;
	}

	if($("#apellidoPaternoRef").val() != ''){
	datosReferenciasTrabajador = new Referencia($.trim($("#apellidoPaternoRef").val()).toUpperCase(),
												$.trim($("#apellidoMaternoRef").val()) == "" ? null : $.trim($("#apellidoMaternoRef").val()).toUpperCase(),
												$.trim($("#nombreReferencia").val()).toUpperCase(),
												$.trim($("#curpReferencia").val()).toUpperCase(),
												$.trim($("#telefonoReferencia").val()),
												$.trim($("#parentescoRef").val()),
												$.trim($("#apellidoPaternoRef2").val()).toUpperCase(),
												$.trim($("#apellidoMaternoRef2").val()) == "" ? null : $.trim($("#apellidoMaternoRef2").val()).toUpperCase(),
												$.trim($("#nombreReferencia2").val()).toUpperCase(),
												$.trim($("#curpReferencia2").val()).toUpperCase(),
												$.trim($("#telefonoReferencia2").val()),
												$.trim($("#parentescoRef2").val()));
	}else{
		datosReferenciasTrabajador = null;
	}
	
	if($("#apellidoPaterno").val() != ''){
	datosBaseCurp = new DatosBaseCurp($.trim($('#curp').val()) == "" ? null : $.trim($('#curp').val()).toUpperCase(),
									  $.trim($('#rfc').val()) == "" ? null : $.trim($('#rfc').val()).toUpperCase(),
									  $.trim($('#nombre').val()).toUpperCase(),
									  $.trim($('#apellidoPaterno').val()).toUpperCase(),
									  $.trim($('#apellidoMaterno').val()) == "" ? null  : $.trim($('#apellidoMaterno').val()).toUpperCase(),
									  $.trim($('#fechaNacimiento').val()),
									  $.trim($('#genero').val()),
									  $.trim($('#entidadNacimiento').val()),
									  $.trim($('#claveNacionalidad').val()) == ""  ? null : $.trim($('#claveNacionalidad').val()),
									  $.trim($('#claveTipoDocProbatorio').val()) == "" ? null : $.trim($('#claveTipoDocProbatorio').val()),
									  $.trim($('#folioSolicitud').val()),
									  $.trim($('#documentoProbatorio').val()) == "" ? null : $.trim($('#documentoProbatorio').val()).toUpperCase(),
									  $.trim($('#folioDocumentoProbatorio').val()) == "" ? null : $.trim($('#folioDocumentoProbatorio').val()),
									  $.trim($('#ocupacion').val()) == ""  ? null : $.trim($('#ocupacion').val()),
									  $.trim($('#giro').val()) == "" ? null : $.trim($('#giro').val()),
									  $.trim($('#estudios').val()) == "" ? null : $.trim($('#estudios').val()),
									  $.trim($('#curpSolicitante').val()).toUpperCase(),
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
//					case 0:
//						dataJSON.parentescoORelacion = $.trim($(this).find('input').val());
//						break;
					case 1:
						dataJSON.curpBen = $.trim($(this).text()).toUpperCase();
						break;
					case 2:
						dataJSON.nombreBen = $.trim($(this).text()).toUpperCase();
						break;
					case 3:
						dataJSON.paterno = $.trim($(this).text()).toUpperCase();
						break;
					case 4:
						dataJSON.materno = $.trim($(this).text())== "" ? null : $.trim($(this).text()).toUpperCase();
						break;
					case 6:
						dataJSON.porcentaje = $.trim($(this).text());
						break;
					case 7:
						dataJSON.parentescoORelacion = $.trim($(this).find('input').val())== "" ? null : $.trim($(this).find('input').val());
						beneficiarioForm = new BeneficiarioForm(dataJSON.curpBen, dataJSON.nombreBen, dataJSON.paterno, dataJSON.materno, dataJSON.parentescoORelacion, dataJSON.porcentaje);
				        listaBeneficiario.push(beneficiarioForm);
						break;
				}
			});
		});
	}

}

function Referencia(apellidoPaternoDeReferencia1,apellidoMaternoDeReferencia1, nombreDeReferencia1, curpDeReferencia1, telefonoDeReferencia1, parentescoORelacionDeReferencia1, apellidoPaternoDeReferencia2, apellidoMaternoDeReferencia2, nombreDeReferencia2, curpDeReferencia2, telefonoDeReferencia2, parentescoORelacionDeReferencia2){
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

function Domicilio(calle, numeroExterior, numeroInterior, colonia, delegacionOMunicipio, codigoPostal, entidadFederativa, pais, indicadorDeTelefono1, telefono1, extension1, indicadorDeTelefono2, telefono2, extension2, correoElectronicoDelTrabajador,claveEntidad){
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
	this.claveEntidad = claveEntidad
}

function DomicilioLaboral(calle, numeroExterior, numeroInterior, colonia, delegacionOMunicipio, codigoPostal, entidadFederativa, pais){
	this.calle = calle
	this.numeroExterior = numeroExterior
	this.numeroInterior = numeroInterior
	this.colonia = colonia
	this.delegacionOMunicipio = delegacionOMunicipio
	this.codigoPostal = codigoPostal
	this.entidadFederativa = entidadFederativa
	this.pais = pais
}

function BeneficiarioForm(curp, nombre, apellidoPaterno, apellidoMaterno, parentesco, porcentaje){
	this.curpDeBeneficiario = curp
	this.nombreDeBeneficiario = nombre
	this.apellidoPaternoDeBeneficiario = apellidoPaterno
	this.apellidoMaternoDeBeneficiario = apellidoMaterno
	this.parentescoORelacion = parentesco
	this.porcentajeDeBeneficiario = porcentaje
}

function ListaBeneficiarios(listaBeneficiario){
	this.beneficiario = listaBeneficiario;
}

function DatosBaseCurp(curpNueva, rfc, nombreTrabajador, apellidoPaterno, apellidoMaterno, 
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


function cargaObjetoExpediente(){
	cargaObjetosExp();
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
		datosDomicilioParticularTrabajadorExpe = new DomicilioExp($.trim($("#calle").val()),
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
				 										   $.trim($("#telefono2").val())=="" ? "0000000000" :  $.trim($("#telefono2").val()),
				 										   $.trim($("#extension2").val()),
				 										   $.trim($("#correoElectronico").val()));
		}else{
			datosDomicilioParticularTrabajadorExpe = null;
		}
		
		if($("#calleLaboral").val() != ''){
		datosDomicilioLaboralTrabajadorExpe = new DomicilioLaboralExp($.trim($("#calleLaboral").val()),
															   $.trim($("#noExteriorLaboral").val()),
															   $.trim($("#noInteriorLaboral").val()),
															   $.trim($("#coloniaLaboral").val()),
															   $.trim($("#municipioLaboral").val()),
															   $.trim($("#codigoPostalLaboral").val()),
															   $.trim($("#entidadFederativaLaboral").val()),
															   $.trim($("#paisLaboral option:selected").text()));
		}else{
			datosDomicilioLaboralTrabajadorExpe = null;
		}

		if($("#apellidoPaternoRef").val() != ''){
		datosReferenciasTrabajadorExpe = new ReferenciaExp($.trim($("#apellidoPaternoRef").val()),
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
			datosReferenciasTrabajadorExpe = null;
		}
		
		if($("#apellidoPaterno").val() != ''){
		datosBaseCurpExpe = new DatosBaseCurpExp($.trim($('#curp').val()),
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
			datosBaseCurpExpe = null;
		}
		
		var hayRegistros = $("#tablaBeneficiarios tbody tr").find('input[type="checkbox"]').val() != undefined;
		if(hayRegistros) {
			var dataJSON = {};
			listaBeneficiarioExpe = [];
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
							beneficiarioFormExpe = new BeneficiarioFormExp(dataJSON.curpBen, dataJSON.nombreBen, dataJSON.paterno, dataJSON.materno, dataJSON.parentescoORelacion, dataJSON.porcentaje);
							listaBeneficiarioExpe.push(beneficiarioFormExpe);
							break;
					}
				});
			});
		}

	}
}

//Se carga en session los datos del formulario,y se valida contra Renapo
function cargaEntradaModificacion13Plus() {	
	cargaObjetos();
	cargaObjetoExpediente();
	if(listaBeneficiario.length >= 1){
	    var beneficiariosList =new ListaBeneficiarios(listaBeneficiario);
	}else{
		var beneficiariosList = null;
	}
	
	if(listaBeneficiarioExpe.length >= 1){
	    var beneficiariosListExpe =new ListaBeneficiarios(listaBeneficiarioExpe);
	}else{
		var beneficiariosListExpe = null;
	}
	
	
	var dataModificacion = {datosBaseCurp: datosBaseCurp,
		                       datosDomicilioParticularTrabajador: datosDomicilioParticularTrabajador,
		                       datosDomicilioLaboralTrabajador: datosDomicilioLaboralTrabajador,
		                       datosReferenciasTrabajador: datosReferenciasTrabajador,
		                       listaBeneficiariosTrabajador: beneficiariosList
		 					   };
	
	var dataExpe = JSON.stringify({datosBaseCurp: datosBaseCurpExpe,
							        datosDomicilioParticularTrabajador: datosDomicilioParticularTrabajadorExpe,
							        datosDomicilioLaboralTrabajador: datosDomicilioLaboralTrabajadorExpe,
							        datosReferenciasTrabajador: datosReferenciasTrabajadorExpe,
							        listaBeneficiariosTrabajador: beneficiariosListExpe
									   });
	
	var dataSolicitante = obtieneDatosSolicitante();
	
	$.ajax({
		url : 'cargaEntradaModificacion13Plus.do',
		type : "POST",
		contentType : 'application/json',
		dataType: 'json',
		data : JSON.stringify({entradaModificacion : dataModificacion, entradaSolicitante : dataSolicitante}),
		async : false,
	}).success(function(result) {
		cargaObjetoPdf(dataExpe);
		
	}).error(function (jqXHR, textStatus, errorThrown){
		alert("Se produjo un error inesperado al cargar la entrada de modificacion ",errorThrown);
	});
}	
	
	function ejecutarPermanencia() {	
		cargaObjetos();
//		var beneficiario = [beneficiarioForm];
		if(listaBeneficiario.length >= 1){
		    var beneficiariosList =new ListaBeneficiarios(listaBeneficiario);
		}else{
			var beneficiariosList = null;
		}
		var dataPermanencia = {
								   entidadOrigen: $.trim($("#trabajadorClaveAfore").val()),
								   curpTrabajador: $.trim($('#curp').val()).toUpperCase(),
			                       rfc:	  $.trim($('#rfc').val())== "" ? null : $.trim($('#rfc').val()).toUpperCase(),
			                       nombreTrabajador: $.trim($('#nombre').val()).toUpperCase(),
						           apellidoPaterno: $.trim($('#apellidoPaterno').val()).toUpperCase(),
						           apellidoMaterno:  $.trim($('#apellidoMaterno').val()) == "" ? null : $.trim($('#apellidoMaterno').val()).toUpperCase(),
						           fechaDeNacimiento: $.trim($('#fechaNacimiento').val()),
						           genero: $.trim($('#genero').val()),
						           entidadFederativaDeNacimiento: $.trim($('#entidadNacimiento').val()),
						           nacionalidad: $.trim($('#nacionalidadTrabajadorValorDespliegue').val()) == "" ? null :  $.trim($('#nacionalidadTrabajadorValorDespliegue').val()),
						           ocupacionOProfesionTrabajador:  $.trim($('#ocupacion').val()) == "" ? null :   $.trim($('#ocupacion').val()),
						           actividadOGiroNegocioTrabajador:   $.trim($('#giro').val())== "" ? null :  $.trim($('#giro').val()),
						           nivelDeEstudioTrabajador:   $.trim($('#estudios').val()) == "" ? null :   $.trim($('#estudios').val()),
						           curpSolicitante: $.trim($('#curpSolicitante').val()) == "" ? null :  $.trim($('#curpSolicitante').val()).toUpperCase(),
						           tipoSolicitante: $.trim($('#tipoSolicitante').val()),
			                       datosParticulares: datosDomicilioParticularTrabajador,
			                       domicilioLaboral: datosDomicilioLaboralTrabajador,
			                       referencias: datosReferenciasTrabajador,
			                       beneficiarios: beneficiariosList
			 					   };
		
		var dataSolicitante = obtieneDatosSolicitante();

		
		if('1' == estatusExpIden && datosDomicilioParticularTrabajador == null){
			muestraComplementarios();
			var tituloModal = "<h2 class='ModalTitle' >Actualización de Datos</h2><a href='#' class='ModalButton' id='btnActExp'>X</a>";
			var mensajeModal = "ERROR: Se debe agregar la información de domicilio particular.";
			$('#tituloActExp').empty();
			$('#mensajeActExp').empty();
			$('#tituloActExp').append(tituloModal);
			$('#mensajeActExp').append(mensajeModal);
			window.location.href = "#modalActExp";
		}else{
			$.ajax({
				url : 'cargaEntradaPermanencia.do',
				type : "POST",
				contentType : 'application/json',
				dataType: 'json',
				data : JSON.stringify({entradaPermanencia : dataPermanencia, entradaSolicitante : dataSolicitante}),
				async : false,
			}).success(function(result) {
				validaReconformacionExpediente();
				if(datosDomicilioParticularTrabajador == null && reconformaExp == "1"){
					muestraComplementarios();
					var tituloModal = "<h2 class='ModalTitle' >Actualización de Datos</h2><a href='#' class='ModalButton' id='btnActExp'>X</a>";
					var mensajeModal = "ERROR: Se debe agregar la información de domicilio particular.";
					$('#tituloActExp').empty();
					$('#mensajeActExp').empty();
					$('#tituloActExp').append(tituloModal);
					$('#mensajeActExp').append(mensajeModal);
					window.location.href = "#modalActExp";
				}else{
					verificacionExpedientes();
				}
			}).error(function (jqXHR, textStatus, errorThrown){
				alert("Se produjo un error inesperado al cargar la entrada de pemanencia ",errorThrown);
			});
		} 	
	}
	
	
	
	
	/**
	 * Método que carga el Combo de Entidades federativas
	 * @param tipoDomicilio
	 * @returns
	 */
	function cargaEntidades(metodo){
		$("#mensajeCodigoPostal").attr("hidden",true);	
		$("#mensajeTercero").attr("hidden",true);	
		paisSeleccionado = $("#pais").val();
		cadenaHTML = '<option value="">Seleccione una opción</option>';
		if (paisSeleccionado != ''){ 
			if(paisSeleccionado == "MEX"){
				url = "cargaEntidades";
				data = ajaxGenerico(url,"GET");
				listaEntidades = data;
				for (var i = 0; i < listaEntidades.length; i++) {
					cadenaHTML += '<option value="'
							+ listaEntidades[i].descripcion + '">'
							+ listaEntidades[i].chCvEntidadFederativa+" "+listaEntidades[i].descripcion
							+ '</option>';
				}

			}else{
				cadenaHTML +='<option value="">Seleccione una opción</option>';
			}
		}
			if(metodo == 1){
				$("#entidadFederativa").append(cadenaHTML);
			}else{
				$("#entidadFederativa").html(cadenaHTML);
			}
		} 
	
	/**
	 * Método que carga el Combo de Entidades federativas
	 * @param tipoDomicilio
	 * @returns
	 */
	function cargaEntidadesSolicitante(metodo){
		$("#mensajeCodigoPostalSolicitante").attr("hidden",true);	
		paisSeleccionado = $("#paisSolicitante").val();
		cadenaHTML = '<option value="">Seleccione una opción</option>';
		if (paisSeleccionado != ''){ 
			if(paisSeleccionado == "MEX"){
				url = "cargaEntidades";
				data = ajaxGenerico(url,"GET");
				listaEntidades = data;
				for (var i = 0; i < listaEntidades.length; i++) {
					cadenaHTML += '<option value="'
							+ listaEntidades[i].descripcion + '">'
							+ listaEntidades[i].chCvEntidadFederativa+" "+listaEntidades[i].descripcion
							+ '</option>';
				}

			}else{
				cadenaHTML +='<option value="">Seleccione una opción</option>';
			}
		}
			if(metodo == 1){
				$("#entidadFederativaSolicitante").append(cadenaHTML);
			}else{
				$("#entidadFederativaSolicitante").html(cadenaHTML);
			}
		} 
	
	/**
	 * Método que carga el Combo de Entidades federativas
	 * @param tipoDomicilio
	 * @returns
	 */
	function cargaEntidadesLaboral(metodo){
//		$("#mensajeCodigoPostal").attr("hidden",true);
		$("#mensajeLaboral").attr("hidden",true);
		paisSeleccionadoLaboral = $("#paisLaboral").val();
		cadenaHTML = '<option value="">Seleccione una opción</option>';
		if (paisSeleccionadoLaboral != ''){ 
			if(paisSeleccionadoLaboral == "MEX"){
				url = "cargaEntidades";
				data = ajaxGenerico(url,"GET");
				listaEntidades = data;
				for (var i = 0; i < listaEntidades.length; i++) {
					cadenaHTML += '<option value="'
							+ listaEntidades[i].descripcion + '">'
							+ listaEntidades[i].chCvEntidadFederativa+" "+listaEntidades[i].descripcion
							+ '</option>';
				}

			}else{
				cadenaHTML +='<option value="">Seleccione una opción</option>';
			}
		}
			if(metodo == 1){
				$("#entidadFederativaLaboral").append(cadenaHTML);
			}else{
				$("#entidadFederativaLaboral").html(cadenaHTML);
			}
		} 

	
	/*Carga Municipios Particular*/
	function cargaMunicipios(){
		$("#mensajeCodigoPostal").attr("hidden",true);
		var entidad = $('#entidadFederativa').val();	
		$("#municipio").empty(); 
		$("#municipio").append("<option value='' disabled='disabled' SELECTED >Seleccione una opción</option>");
		$.ajax({
			url : 'cargaMunicipios?entidad='+entidad,
			type : 'GET',
			contentType : 'application/json',
			dataType: 'json',
			timeout : 100000,
			async : false,
			success : function(data) {
				$.each(data,function(index,item){
					 $("#municipio").append($('<option></option>').attr('id',item.descripcion).val(item.descripcion).html(item.descripcion));
				});	
			}
		});
	}
	
	/*Carga Municipios solicitante*/
	function cargaMunicipiosSolicitante(){
		$("#mensajeCodigoPostalSolicitante").attr("hidden",true);
		var entidad = $('#entidadFederativaSolicitante').val();	
		$("#municipioSolicitante").empty(); 
		$("#municipioSolicitante").append("<option value='' disabled='disabled' SELECTED >Seleccione una opción</option>");
		$.ajax({
			url : 'cargaMunicipios?entidad='+entidad,
			type : 'GET',
			contentType : 'application/json',
			dataType: 'json',
			timeout : 100000,
			async : false,
			success : function(data) {
				$.each(data,function(index,item){
					 $("#municipioSolicitante").append($('<option></option>').attr('id',item.descripcion).val(item.descripcion).html(item.descripcion));
				});	
			}
		});
	}
	
	function cargaMunicipiosLaboral(){
//		$("#mensajeCodigoPostal").attr("hidden",true);
		var entidad = $('#entidadFederativaLaboral').val();	
		if(entidad != null || entidad != ""){
			$("#mensajeLaboral").empty(); 
		}
		$("#municipioLaboral").empty(); 
		$("#municipioLaboral").append("<option value='' disabled='disabled' SELECTED >Seleccione una opción</option>");
		$.ajax({
			url : 'cargaMunicipios?entidad='+entidad,
			type : 'GET',
			contentType : 'application/json',
			dataType: 'json',
			success : function(data) {
				$.each(data,function(index,item){
					 $("#municipioLaboral").append($('<option></option>').attr('id',item.descripcion).val(item.descripcion).html(item.descripcion));
				});	
			}
		});
	}
	
	
	function seteaNacionalidadValorDespliegue(cvNacionalidad){
		$.ajax({
			url : 'cargaNacionalidad?cveNacionalidad='+cvNacionalidad,
			type : 'GET',
			contentType : 'application/json',
			dataType: 'json',
			success : function(data) {
				$("#nacionalidadTrabajadorValorDespliegue").val(data.chValorDespliegue);
			}
		});
	}
	
	function validaDatosCertificados() {
		var valida = false;
		$("#baseCurpCertificados span.Labeltexterror").each(function(){
			if($(this).text() != "") {
				valida = true;
			}
		});
		return valida;
	}
	
	function validaDatosNoCertificados() {
		var valida = false;
		$("#baseCurpNoCertificados span.Labeltexterror").each(function(){
			if($(this).text() != "") {
				valida = true;
			}
		});
		return valida;
	}
	
	function validaDatosComplementarios() {
		var valida = false;
		$("#direccionParticularContenedor span.Labeltexterror, " +
				"#referencias1 span.Labeltexterror, #referencias2 span.Labeltexterror").each(function(){
			if($(this).text() != "") {
				valida = true;
			}
		});
		return valida;
	}
	
	function validaDatosLaboral() {
		var valida = false;
		$("#direccionLaboralContenedor span.Labeltexterror").each(function(){
			if($(this).text() != "") {
				valida = true;
			}
		});
		return valida;
	}
	
	function regresoSubmit() {
		$("#fm_datosConsulta").submit();
	}
	
	
	/* Despues de Validacion Contra Renapo */
	function continuacionFlujoValidacionRenapo(){
		if($(".ContainerDatosGenerales__NameError").length == 0){/*Sin diferencias contra Renapo*/
			if($("#banderaValidoRenapo").val() == 1 ){
			//**************************************************************************************//	
				if( $("#flujoValidacion").val() == "1B" || $("#flujoValidacion").val() == "4B" || $("#flujoValidacion").val() == "9A" || $("#reconformaExpediente").val() == "1"){
					 if( $("#banderaNuloDomicilioParticularTrabajador").val() == 1 ){
						 muestraComplementarios();
						 var tituloModal = "<h2 class='ModalTitle' >Actualización de Datos</h2><a href='#' class='ModalButton' id='btnActExp'>X</a>";
						 var mensajeModal = "ERROR: Se debe agregar la información del domicilio particular.";
						 $('#tituloActExp').empty();
						 $('#mensajeActExp').empty();
						 $('#tituloActExp').append(tituloModal);
						 $('#mensajeActExp').append(mensajeModal);
						 window.location.href = "#modalActExp";
					 }else{
						 verificacionExpedientes();
//						abrirExpedienteServicio();
						$("#banderaValidoRenapo").val(0);
					 }
				}else{//Los demas Flujos
					verificacionExpedientes();
//					abrirExpedienteServicio();
					$("#banderaValidoRenapo").val(0);
				}
			//**************************************************************************************//		
			}
		}else{/*Existen diferencias contra Renapo*/
			//**************************************************************************************//	
			if($("#banderaValidoRenapo").val() == 1 ){
				muestraCertificados();
			}
			//**************************************************************************************//
		}
	}
	
	function verificacionExpedientes(){
		$("#fm_redireccion").attr('action', 'validaExpedientesFlujo.do');
		$("#fm_redireccion").attr('method', 'POST');
		$("#fm_redireccion").submit();
	}
	
	/*
	 * Funcion para busqueda de codigo postal
	 */
	function buscarCodigoPostal(){//TODO
		var codigo = $("#codigoPostal").val();
		cadenaCodigoColonia = null;
		cadenaCodigoEntidad = null;
		cadenaCodigoMunicipio = null;
		cadenaClaveCortaEntidad = null;
		validacion = true;
		if(codigo.length == 5){
			$('#pais').val("MEX").prop('selected', true);
			$('#pais').removeAttr('disabled');
			agregarPais();
		data = consultaCodigo(codigo);
		$('#mensajeCodigoPostal').empty();
		$('#mensajeTercero').empty();

			if(data.output.dataSet.length == 1){
				for (var i = 0; i < data.output.dataSet.length; i++) {
					cadenaCodigoColonia = data.output.dataSet[i].campos.descripcionAsentamiento;
					cadenaCodigoEntidad = data.output.dataSet[i].campos.descripcionEntidadFederativa;
					cadenaCodigoMunicipio = data.output.dataSet[i].campos.descripcionMunicipio;
					cadenaClaveCortaEntidad = data.output.dataSet[i].campos.cveEntidadFederativa; 
				}
				
				
				//Acciones en caso de ser codigo postal desconocido
				if(cadenaCodigoColonia == "INTERNACIONAL"){
					$("#mensajeCodigoPostal").removeAttr('hidden');
					$("#mensajeCodigoPostal").append("No se encontro informacion para el codigo postal,seleccione informacion en los combos");
					//Input Colonia
					$("#colonia").remove();
					cadenaInputColoniaParticular="<input class='InputEdit' type='text' id='colonia' name='colonia' value='' placeholder='Colonia' onchange='agregarColonia();'>";
					$("#divColoniaParticular").append(cadenaInputColoniaParticular);
					
					//Combo entidad
					$("#entidadFederativa").remove();
					cadenaSelectEntidad="<select class='Select' id='entidadFederativa'  name='entidadFederativa' onchange='cargaMunicipios();agregarEntidadFederativa()'></select>"
					$("#divEntidadParticular").append(cadenaSelectEntidad);	
					cargaEntidades(2);
					cambiarCaposEntidad();
					//Combo municipio
					$("#municipio").remove();
					cadenaSelectMunicipio="<select class='Select' id='municipio' name='municipio' onchange='agregarMunicipio();'><option value=''>Seleccione una opción</option></select>"
					$("#divMunicipioParticular").append(cadenaSelectMunicipio);
					cambiarCaposMunicipio();
					validacion = false;
				}
				
				if(validacion == true){
					$("#mensajeCodigoPostal").attr("hidden",true);
					//Operacion para colonia
					$("#colonia").remove();
					cadenaInputColoniaParticular="<input class='InputEdit' type='text' id='colonia' name='colonia' value='' placeholder='Colonia' onchange='agregarColonia();'>";
					$("#divColoniaParticular").append(cadenaInputColoniaParticular);
					$("#colonia").val(cadenaCodigoColonia);
					agregarColonia();
					
					//Operacion Para entidad
					$("#entidadFederativa").remove();
					cadenaInputEntidadParticular="<input class='InputEdit' type='text' id='entidadFederativa' name='entidadFederativa' value='' onchange='agregarEntidadFederativa();'>";
					$("#divEntidadParticular").append(cadenaInputEntidadParticular);
					$("#entidadFederativa").val(cadenaCodigoEntidad);
					cambiarCaposEntidad(cadenaCodigoEntidad);
					//Operacion para municipio
					$("#municipio").remove();
					cadenaInputMunicipioParticular="<input class='InputEdit' type='text' id='municipio' name='municipio' value=''>";
					$("#divMunicipioParticular").append(cadenaInputMunicipioParticular);
					$("#municipio").val(cadenaCodigoMunicipio);
					cambiarCaposMunicipio(cadenaCodigoMunicipio);
					$("#municipio").attr("readOnly",true);
					$("#entidadFederativa").attr("readOnly",true);
					$("#cvEntidadDomicilio").val(cadenaClaveCortaEntidad);
				}
			}else{
				if(validacion == true){
					$("#mensajeCodigoPostal").attr("hidden",true);
					//Operacion para colonia
					$("#colonia").remove();				
					cadenaSelectColonia="<select id='colonia' name='colonia' class='Select' onchange='agregarColonia();'></select>"
						$("#divColoniaParticular").append(cadenaSelectColonia);
						cadenaColonia = '<option value="">Seleccione una opción</option>';
						for (var i = 0; i < data.output.dataSet.length; i++) {
							cadenaColonia += '<option value="'
								+ data.output.dataSet[i].campos.descripcionAsentamiento +'">'
								+ data.output.dataSet[i].campos.descripcionAsentamiento
								+ '</option>';
							cadenaEntidad = data.output.dataSet[i].campos.descripcionEntidadFederativa;
							cadenaMunicipio = data.output.dataSet[i].campos.descripcionMunicipio;
							cadenaCvEntidad = data.output.dataSet[i].campos.cveEntidadFederativa; 


						}
					$("#colonia").html(cadenaColonia);
					
					//Operacion Para entidad
					$("#entidadFederativa").remove();
					cadenaInputEntidadParticular="<input class='InputEdit' type='text' id='entidadFederativa' name='entidadFederativa' value='' onchange='agregarEntidadFederativa():'>";
					$("#divEntidadParticular").append(cadenaInputEntidadParticular);
					$("#entidadFederativa").val(cadenaEntidad);
					cambiarCaposEntidad(cadenaEntidad);
					//Operacion para municipio
					$("#municipio").remove();
					cadenaInputMunicipioParticular="<input class='InputEdit' type='text' id='municipio' name='municipio' value=''>";
					$("#divMunicipioParticular").append(cadenaInputMunicipioParticular);
					$("#municipio").val(cadenaMunicipio);
					cambiarCaposMunicipio(cadenaMunicipio);
					$("#municipio").attr("readOnly",true);
					$("#entidadFederativa").attr("readOnly",true);
					$("#cvEntidadDomicilio").val(cadenaCvEntidad);

				}
			}
		}else if(codigo.length == 0){
			//Input Colonia
			$('#pais').val("").prop('selected', true);
			$("#colonia").remove();
			cadenaInputColoniaParticularVacio="<input class='InputEdit' type='text' id='colonia' name='colonia' value='' placeholder='Colonia' onchange='agregarColonia();'>";
			$("#divColoniaParticular").append(cadenaInputColoniaParticularVacio);
			
			//Combo entidad
			$("#entidadFederativa").remove();
			cadenaSelectEntidadVacio="<select class='Select' id='entidadFederativa'  name='entidadFederativa' onchange='cargaMunicipios();agregarEntidadFederativa();'></select>"
			$("#divEntidadParticular").append(cadenaSelectEntidadVacio);	
			cargaEntidades(2);
			cambiarCaposEntidad();
			//Combo municipio
			$("#municipio").remove();
			cadenaSelectMunicipioVacio="<select class='Select' id='municipio' name='municipio' onchange='agregarMunicipio();'><option value=''>Seleccione una opción</option></select>"
			$("#divMunicipioParticular").append(cadenaSelectMunicipioVacio);
			cambiarCaposMunicipio();
		}
	}
	
	
	/*
	 * Funcion para busqueda de codigo postal
	 */
	function buscarCodigoPostalSolicitante(){//TODO
		var codigo = $("#codigoPostalSolicitante").val();
		cadenaCodigoColoniaSolicitante = null;
		cadenaCodigoEntidadSolicitante = null;
		cadenaCodigoMunicipioSolicitante = null;
		cadenaClaveCortaEntidadSolicitante = null;
		validacion = true;
		if(codigo.length == 5){
			$('#paisSolicitante').val("MEX").prop('selected', true);
			$('#paisSolicitante').removeAttr('disabled');
		data = consultaCodigo(codigo);
		$('#mensajeCodigoPostalSolicitante').empty();
			if(data.output.dataSet.length == 1){
				for (var i = 0; i < data.output.dataSet.length; i++) {
					cadenaCodigoColoniaSolicitante = data.output.dataSet[i].campos.descripcionAsentamiento;
					cadenaCodigoEntidadSolicitante = data.output.dataSet[i].campos.descripcionEntidadFederativa;
					cadenaCodigoMunicipioSolicitante = data.output.dataSet[i].campos.descripcionMunicipio;
					cadenaClaveCortaEntidadSolicitante = data.output.dataSet[i].campos.cveEntidadFederativa; 
				}
				
				
				//Acciones en caso de ser codigo postal desconocido
				if(cadenaCodigoColoniaSolicitante == "INTERNACIONAL"){
					$("#mensajeCodigoPostalSolicitante").removeAttr('hidden');
					$("#mensajeCodigoPostalSolicitante").append("No se encontro informacion para el codigo postal,seleccione informacion en los combos");
					//Input Colonia
					$("#coloniaSolicitante").remove();
					cadenaInputColoniaSolicitante="<input class='InputEdit' type='text' id='coloniaSolicitante' name='coloniaSolicitante' value='' placeholder='Colonia'>";
					$("#divColoniaSolicitante").append(cadenaInputColoniaSolicitante);
					
					//Combo entidad
					$("#entidadFederativaSolicitante").remove();
					cadenaSelectEntidadSolicitante="<select class='Select' id='entidadFederativaSolicitante'  name='entidadFederativaSolicitante' onchange='cargaMunicipiosSolicitante();'></select>"
					$("#divEntidadSolicitante").append(cadenaSelectEntidadSolicitante);	
					cargaEntidadesSolicitante(2);
					//Combo municipio
					$("#municipioSolicitante").remove();
					cadenaSelectMunicipioSolicitante="<select class='Select' id='municipioSolicitante' name='municipioSolicitante'><option value=''>Seleccione una opción</option></select>"
					$("#divMunicipioSolicitante").append(cadenaSelectMunicipioSolicitante);
					validacion = false;
				}
				
				if(validacion == true){
					$("#mensajeCodigoPostalSolicitante").attr("hidden",true);
					//Operacion para colonia
					$("#coloniaSolicitante").remove();
					cadenaInputColoniaSolicitante="<input class='InputEdit' type='text' id='coloniaSolicitante' name='coloniaSolicitante' value='' placeholder='Colonia'>";
					$("#divColoniaSolicitante").append(cadenaInputColoniaSolicitante);
					$("#coloniaSolicitante").val(cadenaCodigoColoniaSolicitante);
					
					//Operacion Para entidad
					$("#entidadFederativaSolicitante").remove();
					cadenaInputEntidadSolicitante="<input class='InputEdit' type='text' id='entidadFederativaSolicitante' name='entidadFederativaSolicitante' value=''>";
					$("#divEntidadSolicitante").append(cadenaInputEntidadSolicitante);
					$("#entidadFederativaSolicitante").val(cadenaCodigoEntidadSolicitante);
					
					//Operacion para municipio
					$("#municipioSolicitante").remove();
					cadenaInputMunicipioSolicitante="<input class='InputEdit' type='text' id='municipioSolicitante' name='municipioSolicitante' value=''>";
					$("#divMunicipioSolicitante").append(cadenaInputMunicipioSolicitante);
					$("#municipioSolicitante").val(cadenaCodigoMunicipioSolicitante);
					
					$("#municipioSolicitante").attr("readOnly",true);
					$("#entidadFederativaSolicitante").attr("readOnly",true);
					$("#cvEntidadDomicilioSolicitante").val(cadenaClaveCortaEntidadSolicitante);
				}
			}else{
				if(validacion == true){
					$("#mensajeCodigoPostalSolicitante").attr("hidden",true);
					//Operacion para colonia
					$("#coloniaSolicitante").remove();				
					cadenaSelectColoniaSolicitante="<select id='coloniaSolicitante' name='coloniaSolicitante' class='Select'></select>"
						$("#divColoniaSolicitante").append(cadenaSelectColoniaSolicitante);
						cadenaColoniaSolicitante = '<option value="">Seleccione una opción</option>';
						for (var i = 0; i < data.output.dataSet.length; i++) {
							cadenaColoniaSolicitante += '<option value="'
								+ data.output.dataSet[i].campos.descripcionAsentamiento +'">'
								+ data.output.dataSet[i].campos.descripcionAsentamiento
								+ '</option>';
							cadenaEntidadSolicitante = data.output.dataSet[i].campos.descripcionEntidadFederativa;
							cadenaMunicipioSolicitante = data.output.dataSet[i].campos.descripcionMunicipio;
							cadenaCvEntidadSolicitante = data.output.dataSet[i].campos.cveEntidadFederativa; 


						}
					$("#coloniaSolicitante").html(cadenaColoniaSolicitante);
					
					//Operacion Para entidad
					$("#entidadFederativaSolicitante").remove();
					cadenaInputEntidadSolicitante="<input class='InputEdit' type='text' id='entidadFederativaSolicitante' name='entidadFederativaSolicitante' value=''>";
					$("#divEntidadSolicitante").append(cadenaInputEntidadSolicitante);
					$("#entidadFederativaSolicitante").val(cadenaEntidadSolicitante);
					
					//Operacion para municipio
					$("#municipioSolicitante").remove();
					cadenaInputMunicipioSolicitante="<input class='InputEdit' type='text' id='municipioSolicitante' name='municipioSolicitante' value=''>";
					$("#divMunicipioSolicitante").append(cadenaInputMunicipioSolicitante);
					$("#municipioSolicitante").val(cadenaMunicipioSolicitante);
					
					$("#municipioSolicitante").attr("readOnly",true);
					$("#entidadFederativaSolicitante").attr("readOnly",true);
					$("#cvEntidadDomicilioSolicitante").val(cadenaCvEntidadSolicitante);

				}
			}
		}else if(codigo.length == 0){
			//Input Colonia
			$('#paisSolicitante').val("").prop('selected', true);
			$("#coloniaSolicitante").remove();
			cadenaInputColoniaSolicitanteVacio="<input class='InputEdit' type='text' id='coloniaSolicitante' name='coloniaSolicitante' value='' placeholder='Colonia'>";
			$("#divColoniaSolicitante").append(cadenaInputColoniaSolicitanteVacio);
			
			//Combo entidad
			$("#entidadFederativaSolicitante").remove();
			cadenaSelectEntidadVacioSolicitante="<select class='Select' id='entidadFederativaSolicitante'  name='entidadFederativaSolicitante' onchange='cargaMunicipiosSolicitante();'></select>"
			$("#divEntidadSolicitante").append(cadenaSelectEntidadVacioSolicitante);	
			cargaEntidadesSolicitante(2);
			//Combo municipio
			$("#municipioSolicitante").remove();
			cadenaSelectMunicipioVacioSolicitante="<select class='Select' id='municipioSolicitante' name='municipioSolicitante'><option value=''>Seleccione una opción</option></select>"
			$("#divMunicipioSolicitante").append(cadenaSelectMunicipioVacioSolicitante);
		}
	}
	
	function consultaCodigo(codigo){
		var resultadoCodigo;
		try{
		$.ajax({
			type:"GET",
			url : "consultarCodigoPostal.do",
			timeout : 100000,
			async : false,
			contentType : "application/json",
			data : {codigo : codigo},
			success : function(data){
				resultadoCodigo = data;
			}
		});
		}catch (e) {
			alert("Ocurrio un error en consulta de codigo postal :: {}"+e);
		}
		
		return resultadoCodigo;
	}
	
	/**
	 * Función que hace una petición por AJAX y devuelve un json como resultado
	 */
	function ajaxGenerico(url,method){
		var resultado;
		$.ajax({
			type : method,
			contentType : "application/json",
			dataType : 'json',
			url : url,
			timeout : 100000,
			async : false,
			success : function(data) {
				resultado = data;
			},
			error : function(e) {
				alert("OCURRIO UN ERROR EN CARGA DE CATALOGO,INTENTE DE NUEVO");
			}
		});
		
		return resultado;
	}
	
	function validaPorcentajesBeneficiarios(){
		var respuesta = false;
		var hayRegistros = $("#tablaBeneficiarios tbody tr").find('input[type="checkbox"]').val() != undefined;
		if(hayRegistros) {
//			var dataJSON = {};
			porcentajesArreglo = [];
			$("#tablaBeneficiarios tbody").find('tr').each(function(i){
				$(this).find('td').each(function(h){
					console.log(h);
					switch (h) {
						case 6:
							porcentaje = $.trim($(this).text());
							porcentajesArreglo.push(porcentaje);
							break;
					}
				});
			});
			respuesta = validarSumaPorcentajes(porcentajesArreglo);
		}
		return respuesta;
	}
	
	function validarSumaPorcentajes(arregloPorcentaje){
		var suma = 0
		var respuesta = false;
		for (var i = 0; i < arregloPorcentaje.length; i++) {
			suma = suma + parseInt(arregloPorcentaje[i]);
		}
		if(100 != suma){
			respuesta = true;		
		}
		return respuesta;
	}
	
	function validaCurpsBeneficiarios(){
		var respuesta = false;
		var hayRegistros = $("#tablaBeneficiarios tbody tr").find('input[type="checkbox"]').val() != undefined;
		if(hayRegistros) {
			curpsBeneficiariosArreglo = [];
			respuestaBeneficiariosArreglo = [];
			$("#tablaBeneficiarios tbody").find('tr').each(function(i){
				$(this).find('td').each(function(h){
					console.log(h);
					switch (h) {					
						case 1:
						curpBeneficiario = $(this).text();
						validarCargaBeneficiarios(curpsBeneficiariosArreglo,curpBeneficiario);
						break;
					}
				});
			});
			respuesta = validarRespuestaCargaBeneficiarios(respuestaBeneficiariosArreglo);
		}
		return respuesta;
	}
	
	function validarCargaBeneficiarios(curpsBeneficiariosArreglo,curpBeneficiario){
		var valor = curpBeneficiario;
		if(curpsBeneficiariosArreglo != undefined){
			if(curpsBeneficiariosArreglo.indexOf(valor) === -1){
				curpsBeneficiariosArreglo.push(valor);
			}else if(curpsBeneficiariosArreglo.indexOf(valor) > -1){
				respuestaBeneficiariosArreglo.push(false);
			}
		}
	}
	
	function validarRespuestaCargaBeneficiarios(respuestaBeneficiariosArreglo){
		var respuesta = false;
		if(respuestaBeneficiariosArreglo.length > 0 ){
			respuesta = true;
		}
		
		return respuesta;
	}
	
	function validacionCurpFaltante(formulario){
		$("#errorCurpFaltante").html('');
		var formatoCurp = new RegExp(/^([a-z|A-Z]{4})([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1]))([a-z|A-Z]{6})([0-9A-Z]{1})([0-9]{1})$/i);
//		console.log("Enviendo Submit actualizaTrabajador 1");
//		$("#form_curpFaltante").submit();
		var curp = formulario.curpFaltante.value;
		curp = curp.toUpperCase();
		if(formatoCurp.test(curp)){
			return true;
		}else{
			$("#errorCurpFaltante").html("El campo CURP no cuenta con formato correcto");
			return false;
		}
	}
	
	function cambiarRfc(){
		$('input[name=rfcAlgoritmo]').removeAttr('disabled');
		$('input[name=rfcAlgoritmo]').rules('add', {
			validaRfcEditar:true
		});
		document.getElementById("rfc").value=rfcBd;
		
	}
	
	function generaRfc(){
		var nombre = document.getElementById("nombre").value;
		var aPaterno = document.getElementById("apellidoPaterno").value;
		var aMaterno = document.getElementById("apellidoMaterno").value;
		var fNacimiento = document.getElementById("fechaNacimiento").value;
		var rfcCalculada = calculaRfc(nombre,aPaterno,aMaterno,fNacimiento);
		rfcBd = document.getElementById("rfc").value;
		var inputRfc = "<input class='InputEdit' type='text' id='rfc' name='rfcAlgoritmo' value='"+rfcCalculada+"' placeholder='RFC del trabajador' maxlength='13' disabled='true'>"		
		$('input[name=rfc]').remove();
		$('#contenedorRfc').append(inputRfc);
		$('#generarRfc').remove();
		$("#rfc").rules('remove');
		var botonEditarRfc = "<button type='button' id='editarRfc' onclick='cambiarRfc()'>EDITAR RFC</button>"
		$("#contenedorBotonRfc").append(botonEditarRfc);
	    console.log('rfcCalculada: ', rfcCalculada);
	}
	
	function validaRenapo(){
		$(location).attr('href', 'validaRenapo.do');
	}
	
	function cargaObjetoPdf(objeto){
		var xhr = new XMLHttpRequest();

		var url = 'cargaEntradaModificacionPDF.do';

		xhr.open('POST', url, false);
		xhr.setRequestHeader("Content-type", "application/json");


		xhr.addEventListener('error', function(e) {
		  console.log('Un error ocurrió', e);
		});

		xhr.addEventListener('readystatechange', function() {
		  if (xhr.readyState === 4) {
				if(AFORE == '568'){
					cargaObjetoPermanenciaCasoCoppel();
				}
				validaRenapo();
		  }
		});

		xhr.send(objeto);
	}
	
	
	function cargaObjetoPermanenciaCasoCoppel() {	
		cargaObjetos();
//		var beneficiario = [beneficiarioForm];
		if(listaBeneficiario.length >= 1){
		    var beneficiariosList =new ListaBeneficiarios(listaBeneficiario);
		}else{
			var beneficiariosList = null;
		}
		var dataPermanencia = {
								   entidadOrigen: $.trim($("#trabajadorClaveAfore").val()),
								   curpTrabajador: $.trim($('#curp').val()).toUpperCase(),
			                       rfc:	  $.trim($('#rfc').val())== "" ? null : $.trim($('#rfc').val()).toUpperCase(),
			                       nombreTrabajador: $.trim($('#nombre').val()).toUpperCase(),
						           apellidoPaterno: $.trim($('#apellidoPaterno').val()).toUpperCase(),
						           apellidoMaterno:  $.trim($('#apellidoMaterno').val()) == "" ? null : $.trim($('#apellidoMaterno').val()).toUpperCase(),
						           fechaDeNacimiento: $.trim($('#fechaNacimiento').val()),
						           genero: $.trim($('#genero').val()),
						           entidadFederativaDeNacimiento: $.trim($('#entidadNacimiento').val()),
						           nacionalidad: $.trim($('#nacionalidadTrabajadorValorDespliegue').val()) == "" ? null :  $.trim($('#nacionalidadTrabajadorValorDespliegue').val()),
						           ocupacionOProfesionTrabajador:  $.trim($('#ocupacion').val()) == "" ? null :   $.trim($('#ocupacion').val()),
						           actividadOGiroNegocioTrabajador:   $.trim($('#giro').val())== "" ? null :  $.trim($('#giro').val()),
						           nivelDeEstudioTrabajador:   $.trim($('#estudios').val()) == "" ? null :   $.trim($('#estudios').val()),
						           curpSolicitante: $.trim($('#curpSolicitante').val()) == "" ? null :  $.trim($('#curpSolicitante').val()).toUpperCase(),
						           tipoSolicitante: $.trim($('#tipoSolicitante').val()),
			                       datosParticulares: datosDomicilioParticularTrabajador,
			                       domicilioLaboral: datosDomicilioLaboralTrabajador,
			                       referencias: datosReferenciasTrabajador,
			                       beneficiarios: beneficiariosList
			 					   };
		
		var dataSolicitante = obtieneDatosSolicitante();
		
		var xhr = new XMLHttpRequest();

		var url = 'cargaEntradaPermanencia.do';

		xhr.open('POST', url, false);
		xhr.setRequestHeader("Content-type", "application/json");


		xhr.addEventListener('error', function(e) {
		  console.log('Un error ocurrió', e);
		});

		xhr.addEventListener('readystatechange', function() {
		  if (xhr.readyState === 4) {
		    console.log(xhr.responseText);
		  }
		});

		xhr.send(JSON.stringify({entradaPermanencia : dataPermanencia, entradaSolicitante : dataSolicitante}));
	}
	
	
	function validaReconformacionExpediente(){
		$.ajax({
			url : 'validaReconformaExpediente.do',
			type : "GET",
			contentType : 'application/json',
			dataType: 'json',
			async : false,
		}).success(function(valor) {
			if("1" == valor){
				reconformaExp = "1";
			}
			
		})
	}
	
	function terminarProceso(){
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
	
	function validaFlujo9B(){
		var variableRespuesta = false;
		var curpNueva =  $.trim(document.getElementById("curp").value).toUpperCase();
		var nombre = $.trim(document.getElementById("nombre").value).toUpperCase();
		var apellidoPaterno = $.trim(document.getElementById("apellidoPaterno").value).toUpperCase();
		var apellidoMaterno = $.trim(document.getElementById("apellidoMaterno").value) == "" ? null : $.trim($('#apellidoMaterno').val()).toUpperCase();
		$.ajax({
			url : 'validaFlujo9B.do',
			type : "GET",
			contentType : 'application/json',
			dataType: 'json',
			data : {curpNueva:curpNueva , nombre:nombre , apellidoPaterno:apellidoPaterno , apellidoMaterno:apellidoMaterno},
			async : false,
		}).success(function(respuesta9B) {
			if(respuesta9B != null && respuesta9B != undefined){
				if(1 == respuesta9B){
					variableRespuesta = true;
					consultaMensajeFlujo9B('M19B',1);
					return variableRespuesta;
				}else if(2 == respuesta9B){
					variableRespuesta = true;
					consultaMensajeFlujo9B('M39B',3);
					return variableRespuesta;
				}else if(3 == respuesta9B){
					variableRespuesta = true;
					consultaMensajeFlujo9B('M49B',3);
					return variableRespuesta;
				}else if(4 == respuesta9B){
					variableRespuesta = true;
					consultaMensajeFlujo9B('M59B',3);
					return variableRespuesta;
				}
			}
		})
		
		return variableRespuesta;
	}
	
	function consultaMensajeFlujo9B(rechazo,mensaje){
		console.log("consulta mensaje");
		$.ajax({
			url : 'catalogoMensajes.do',
			type : "GET",
			contentType : 'application/json',
			dataType: 'json',
			data : {codigo : rechazo}
		}).success(function(resultado) {
			if(resultado.flujo == 1) {
				if(1 == mensaje){
					window.location.href = "#";
					document.getElementById('tituloModalSolicitud9B').innerHTML = resultado.titulo;
					document.getElementById('mensajeModalSolicitud9B').innerHTML = resultado.mensaje;
					window.location.href = "#modalSolicitud9B";
				}else if(2 == mensaje){
					window.location.href = "#";
					var mensajeConfirmacion = resultado.mensaje;
					document.getElementById('tituloModalConfirmacion9B').innerHTML = resultado.titulo;
					document.getElementById('mensajeModalConfirmacion9B').innerHTML = mensajeConfirmacion.bold();
					document.getElementById('mensajeModalConfirmacion9B').style.color = "red";
					window.location.href = "#modalConfirmacion9B";
				}else if(3 == mensaje){
					window.location.href = "#";
					document.getElementById('tituloModalCancelacion9B').innerHTML = resultado.titulo;
					document.getElementById('mensajeModalCancelacion9B').innerHTML = resultado.mensaje;
					window.location.href = "#modalCancelacion9B";
				}

			}
		})
	}
	
	
	function continuarSolicitudFlujo9B(){
		$('#continuarModalSolicitud9B').attr('disabled',true);
		consultaMensajeFlujo9B('M29B',2);
	}
	
	function cancelarSolicitudFlujo9B(){
		$('#cancelarModalSolicitud9B').attr('disabled',true);
		consultaMensajeFlujo9B('M39B',3);
	}
	
	function continuarConfirmacionModal(){
		$('#continuarModalConfirmacion9B').attr('disabled',true);
		validarPendienteTrabajador();
	}
	
	function cancelarConfirmacionModal(){
		$('#candelarModalConfirmacion9B').attr('disabled',true);
		terminarProceso();
	}
	
	function cerrarModalCancelar9B(){
		$('#cerrarModalCancelacion9B').attr('disabled',true);
		terminarProceso();
	}
	
	
	function validaNumeroBeneficiarios(){
		var numeroBeneficiarios = 0;
		var hayRegistros = $("#tablaBeneficiarios tbody tr").find('input[type="checkbox"]').val() != undefined;
		if(hayRegistros) {
//			var dataJSON = {};
			arregloNumeroBeneficiarios = [];
			respuestaBeneficiariosArreglo = [];
			$("#tablaBeneficiarios tbody").find('tr').each(function(i){
				$(this).find('td').each(function(h){
					console.log(h);
					switch (h) {					
						case 1:
						curpBeneficiario = $(this).text();
						arregloNumeroBeneficiarios.push(curpBeneficiario);
						break;
					}
				});
			});
			 numeroBeneficiarios = arregloNumeroBeneficiarios.length;
		}
		return numeroBeneficiarios;
	}
	
	function validarValorCheckBeneficiarios(){
		var valorCheck = $('#checkSinDesiganrBeneficiarios').prop('checked');
		return valorCheck;
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
	
	function buscarCurpRenapoEnviar(curpBeneficiario){
		var resultadoRenapo;
		try{
		$.ajax({
			type:"GET",
			url : "validaCurpRenapo.do",
			timeout : 100000,
			async : false,
			contentType : "application/json",
			data : {curpBeneficiario : curpBeneficiario},
			success : function(data){
				resultadoRenapo = data;
			}
		});
		}catch (e) {
			var mensajeModal = consultaMensajeMdd('MDBC');
			if(mensajeModal != null){
				var mensajeConsulta = mensajeModal.mensaje;
				mensajeConsulta = mensajeConsulta.replace("{curp}", curpBeneficiario);
				muestraModal(mensajeModal.titulo,mensajeConsulta);
			}
		}
		
		return resultadoRenapo;
	}
	
	function validaCurpsBeneficiariosRenapo(){
		var resultadoValidacion = true;
		var resultadoBusqueda;
		var curp;
		var mensajeModal;
		var numeroBeneficiariosExistentes = validaNumeroBeneficiarios();
		
		
		if(numeroBeneficiariosExistentes > 0){
			for (var i = 0; i < arregloNumeroBeneficiarios.length; i++) {
				curp = arregloNumeroBeneficiarios[i];
				resultadoBusqueda = buscarCurpRenapoEnviar(curp);
				if(resultadoBusqueda != null){
					if(resultadoBusqueda.curp != "" && resultadoBusqueda.curp != null && resultadoBusqueda.nombre != "" && resultadoBusqueda.nombre != null){
						console.log("curp existente renapo "+resultadoBusqueda);
					}else{
						mensajeModal = consultaMensajeMdd('MDBC');
						if(mensajeModal != null){
							var mensajeConsulta = mensajeModal.mensaje;
							mensajeConsulta = mensajeConsulta.replace("{curp}", curp);
							muestraModal(mensajeModal.titulo,mensajeConsulta);
							resultadoValidacion = false;
							break;
						}
					}
				}else{
					mensajeModal = consultaMensajeMdd('MDBC');
					if(mensajeModal != null){
						var mensajeConsulta = mensajeModal.mensaje;
						mensajeConsulta = mensajeConsulta.replace("{curp}", curp);
						muestraModal(mensajeModal.titulo,mensajeConsulta);
						resultadoValidacion = false;
						break;
					}
				}
			}
		}
		
		
		return resultadoValidacion;
	}
	
	function validaDiferenciaCurpsBeneficiariosCurpTitular(){
		var curpNueva = $.trim(document.getElementById("curp").value);
		curpNueva = curpNueva.toUpperCase();
		var respuesta = false;
		var hayRegistros = $("#tablaBeneficiarios tbody tr").find('input[type="checkbox"]').val() != undefined;
		if(hayRegistros) {
			var curpsBeneficiariosIgualTitular = new Array();
			$("#tablaBeneficiarios tbody").find('tr').each(function(i){
				$(this).find('td').each(function(h){
					console.log(h);
					switch (h) {					
						case 1:
						curpBeneficiario = $(this).text();
						validaCurpBeneficiarioContraTitular(curpsBeneficiariosIgualTitular,curpBeneficiario,curpNueva);
						break;
					}
				});
			});
			respuesta = validaRespuestaCurpBeneficiarioContraTitular(curpsBeneficiariosIgualTitular);
		}
		return respuesta;
	}
	
	
	
	
	function validaCurpBeneficiarioContraTitular(curpsBeneficiariosIgualTitular,curpBeneficiario,curpTitular){
		var valorCurpTitular = curpTitular;
		var valorCurpBeneficiario = curpBeneficiario;
		if(valorCurpTitular == valorCurpBeneficiario){
			curpsBeneficiariosIgualTitular.push(valorCurpBeneficiario);
		}	
	}
	
	function validaRespuestaCurpBeneficiarioContraTitular(curpsBeneficiariosIgualTitular){
		var respuesta = false;
		var tamanioArreglo = curpsBeneficiariosIgualTitular.length;
		if(tamanioArreglo > 0){
			respuesta = true;
		}
		return respuesta;
	}
	
	
	function DomicilioSolicitante(calle, numeroExterior, numeroInterior, colonia, delegacionOMunicipio, codigoPostal, entidadFederativa, pais, claveEntidad){
		this.calle = calle
		this.numeroExterior = numeroExterior
		this.numeroInterior = numeroInterior
		this.colonia = colonia
		this.delegacionOMunicipio = delegacionOMunicipio
		this.codigoPostal = codigoPostal
		this.entidadFederativa = entidadFederativa
		this.pais = pais
		this.claveEntidad = claveEntidad
	}
	
	function DatosSolicitante(curp,nombre,apellidoPaterno,apellidoMaterno){
		this.curp = curp
		this.nombre = nombre
		this.apellidoPaterno = apellidoPaterno
		this.apellidoMaterno = apellidoMaterno
	}
	
	function obtieneDatosSolicitante(){
		if(TIPOSOLICITANTE != '01'){
			if($("#entidadFederativaSolicitante").val() != ''){
				 var entidadCompletaSolicitante = $.trim($("#entidadFederativaSolicitante option:selected").text());
				 if(entidadCompletaSolicitante != ''){
					var partesSolicitante = entidadCompletaSolicitante.split(" ");
					var entidadSolicitante = partesSolicitante[0];
				 }else{
					 entidadSolicitante = $("#cvEntidadDomicilioSolicitante").val();
				 }
				
			}
			datosGeneralesSolicitante = new DatosSolicitante(
					$.trim($('#curpSolicitanteSeccion').val()).toUpperCase(),
					$.trim($('#nombreSolicitante').val()).toUpperCase(),
					$.trim($('#apellidoPaternoSolicitante').val()).toUpperCase(),
					$.trim($('#apellidoMaternoSolicitante').val()) == "" ? null : $.trim($('#apellidoMaternoSolicitante').val()).toUpperCase());
			
			datosDomicilioSolicitante = new DomicilioSolicitante(
					$.trim($('#calleSolicitante').val()).toUpperCase(),
					$.trim($('#noExteriorSolicitante').val()) == "" ? null : $.trim($('#noExteriorSolicitante').val()).toUpperCase(),
					$.trim($('#noInteriorSolicitante').val()) == "" ? null : $.trim($('#noInteriorSolicitante').val()).toUpperCase(),
					$.trim($('#coloniaSolicitante').val()).toUpperCase(), 
					$.trim($('#municipioSolicitante').val()).toUpperCase(), 
					$.trim($('#codigoPostalSolicitante').val()).toUpperCase(), 
					$.trim($("#entidadFederativaSolicitante").val()).toUpperCase(),
					$.trim($('#paisSolicitante').val()).toUpperCase(),
					$.trim(entidadSolicitante) == "" ? null : $.trim(entidadSolicitante));
			
			
	
				var dataSolicitante = {
					datosGeneralesSolicitante : datosGeneralesSolicitante,
					datosDomicilioSolicitante : datosDomicilioSolicitante};
		}


		
		return dataSolicitante;
	}
	
	
	function validaDatosSolicitante() {
		var valida = false;
		$("#datosSolicitanteContenedor span.Labeltexterror, " +
				"#direccionParticularSolicitanteContenedor span.Labeltexterror").each(function(){
			if($(this).text() != "") {
				valida = true;
			}
		});
		return valida;
	}
	
	
	function validaBeneficiarioDesignado(){
		var respuestaDesignado;
		var curpSolicitante = $.trim($('#curpSolicitanteSeccion').val()).toUpperCase();
		var nombreSolicitante = $.trim($('#nombreSolicitante').val()).toUpperCase();
		var apellidoPaternoSolicitante = $.trim($('#apellidoPaternoSolicitante').val()).toUpperCase();
		var apellidoMaternoSolicitante = $.trim($('#apellidoMaternoSolicitante').val()).toUpperCase();
		$.ajax({
			url : 'validaBeneficiarioDesignado.do',
			type : "GET",
			contentType : 'application/json',
			dataType: 'json',
			data : {curp:curpSolicitante , nombre:nombreSolicitante , apellidoPaterno:apellidoPaternoSolicitante , apellidoMaterno:apellidoMaternoSolicitante},
			async : false
		}).success(function(resultado){ 
			respuestaDesignado = resultado;
		})
		return respuestaDesignado;
	}
	
	
//	function validacionDireccionParticular(){
//		var callePC = $("#calle").val();
//		var coloniaPC = $("#colonia").val();
//		var entidadPC = $("#entidadFederativa").val();
//		var municipioPC = $("#municipio").val();
//		if(callePC == null || callePC == "" || coloniaPC == null || coloniaPC == ""){
//			$("#pais").attr("disabled",true);
//			$("#entidadFederativa").attr("disabled",true);
//			$("#municipio").attr("disabled",true);
//			$("#colonia").attr("disabled",true);
//			
//			$("#mensajeCodigoPostal").empty();
//			$("#mensajeCodigoPostal").removeAttr('hidden');
//			$("#mensajeCodigoPostal").append("Primero debe agregar un codigo postal");
//		}
//		
//		
//		if(entidadPC == null || entidadPC == "" || municipioPC == null || municipioPC == ""){
//			$("#pais").attr("disabled",true);
//			$("#entidadFederativa").attr("disabled",true);
//			$("#municipio").attr("disabled",true);
//			$("#colonia").attr("disabled",true);
//			
//			$("#codigoPostal").val(null);
//			
//			$("#mensajeCodigoPostal").empty();
//			$("#mensajeCodigoPostal").removeAttr('hidden');
//			$("#mensajeCodigoPostal").append("Primero debe agregar un codigo postal");
//		}
//
//	}
	
	
	function agregarCalle(){
		if(TIPOSOLICITANTE != '01' && AFORE == '568'){
            if ( $("#calleSolicitante").length > 0 ) {
            	var  calleTitular = $.trim($('#calle').val()).toUpperCase();
            	$("#calleSolicitante").val(calleTitular);
            }
		}

	}
	
	function agregarNumeroExterior(){
		if(TIPOSOLICITANTE != '01' && AFORE == '568'){
            if ( $("#noExteriorSolicitante").length > 0 ) {
            	var  noExteriorTitular = $.trim($('#noExterior').val()).toUpperCase();
            	$("#noExteriorSolicitante").val(noExteriorTitular);
            }
		}

	}
	
	function agregarNumeroInterior(){
		if(TIPOSOLICITANTE != '01' && AFORE == '568'){
            if ( $("#noInteriorSolicitante").length > 0 ) {
            	var  noInteriorTitular = $.trim($('#noInterior').val()).toUpperCase();
            	$("#noInteriorSolicitante").val(noInteriorTitular);
            }
		}

	}
	
	function agregarColonia(){
		if(TIPOSOLICITANTE != '01' && AFORE == '568'){
            if ( $("#coloniaSolicitante").length > 0 ) {
            	var  coloniaTitular = $.trim($('#colonia').val()).toUpperCase();
            	$("#coloniaSolicitante").val(coloniaTitular);
            }
		}

	}
	
	
function agregarPais(){
	if(TIPOSOLICITANTE != '01' && AFORE == '568'){
        if ( $("#paisSolicitante").length > 0 ) {
        	var paisTitular = $.trim($('#pais').val()).toUpperCase();
        	$('#paisSolicitante').val(paisTitular).prop('selected', true);
        }
	}

}

function agregarEntidadFederativa(){
	if(TIPOSOLICITANTE != '01' && AFORE == '568'){
        if ( $("#entidadFederativaSolicitante").length > 0 ) {
        	var entidadTitular = $.trim($('#entidadFederativa').val()).toUpperCase();
        	$('#entidadFederativaSolicitante').val(entidadTitular).prop('selected', true);
        	cargaMunicipiosSolicitante();
        }
        
	}

}

function cambiarCaposEntidad(valor){
	if(TIPOSOLICITANTE != '01' && AFORE == '568'){

		$("#entidadFederativaSolicitante").remove();
		cadenaInputEntidadSolicitante="<input class='InputEdit' type='text' id='entidadFederativaSolicitante' name='entidadFederativaSolicitante' value='' onchange='agregarEntidadFederativa();'>";
		$("#divEntidadSolicitante").append(cadenaInputEntidadSolicitante);
		$("#entidadFederativaSolicitante").val(valor);
		$("#entidadFederativaSolicitante").attr("readOnly",true);
	}

}

function agregarMunicipio(){
	if(TIPOSOLICITANTE != '01' && AFORE == '568'){
        if ( $("#municipioSolicitante").length > 0 ) {
        	var municipioTitular = $.trim($('#municipio').val()).toUpperCase();
        	$('#municipioSolicitante').val(municipioTitular).prop('selected', true);
        }
	}

}

function cambiarCaposMunicipio(valor){
	if(TIPOSOLICITANTE != '01' && AFORE == '568'){
		$("#municipioSolicitante").remove();
		cadenaInputMunicipioSolicitante="<input class='InputEdit' type='text' id='municipioSolicitante' name='municipioSolicitante' value='' onchange='agregarMunicipio();'>";
		$("#divMunicipioSolicitante").append(cadenaInputMunicipioSolicitante);
		$("#municipioSolicitante").val(valor);
		$("#municipioSolicitante").attr("readOnly",true);
	}

}


function agregarCodigoPostal(){
	if(TIPOSOLICITANTE != '01' && AFORE == '568'){
        if ( $("#codigoPostalSolicitante").length > 0 ) {
        	var  codigoPostalTitular = $.trim($('#codigoPostal').val()).toUpperCase();
        	$("#codigoPostalSolicitante").val(codigoPostalTitular);
        }
	}

}
	
	
	
	
	