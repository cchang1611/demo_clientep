/**
 * Validaciones de Formularios
 */

//JavaScript Validacion
$('document').ready(function(){

var alfaNumerico_1 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\" ]{1}$");
var alfaNumerico_2 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\" ]{2}$");
var alfaNumerico_3 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\" ]{1,3}$");
var alfaNumerico_4 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\" ]{4}$");
var alfaNumerico_5 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\" ]{5}$");
var alfaNumerico_8 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\" ]{8}$");
var alfaNumerico_15 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\"  ]{1,15}$");
var alfaNumerico_16 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\" ]{16}$");
var alfaNumerico_40 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\" ]{1,40}$");
var alfaNumerico_50 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\" ]{1,50}$");
var alfaNumerico_65 = new RegExp("^[a-zA-Z0-9À-ÿ!#$%&\\-`.+,/\" ]{1,65}$");
//var rfcRegex = new RegExp("([A-Z]{4}\d{6}([A-Z0-9]{3})?)");
//var rfcRegex = new RegExp("^[a-zA-Z]{4}\\d{6}([a-zA-Z0-9]{3})?$");
//var rfcRegexEditar = new RegExp("^[a-zA-Z]{4}\\d{6}([a-zA-Z0-9]{3})?$");
var rfcRegex = new RegExp("^[a-zA-ZñÑ]{4}\\d{6}([a-zA-Z0-9ñÑ]{3})?$");
var rfcRegexEditar = new RegExp("^[a-zA-ZñÑ]{4}\\d{6}([a-zA-Z0-9ñÑ]{3})?$");
//var rfcRegex = new RegExp("^[a-zA-Z0-9 ]{10,13}$");
var numerico_3 = new RegExp('^\\d{3}$');
var numerico_6 = new RegExp('^\\d{6}$');
var numerico_7 = new RegExp('^\\d{7}$');
var numerico_10 = new RegExp("^[0-9]{10}$");
var numerico_14 = new RegExp('^\\d{14}$');
var numerico_1_3 = new RegExp('^\\d{1,3}$');
var nssRegex = new RegExp('^\\d{11}$');
var curpRegex = new RegExp(/^([a-z|A-Z]{4})([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1]))([a-z|A-Z]{6})([0-9A-Z]{1})([0-9]{1})$/i);
//var curpRegex = new RegExp(
//'^[a-zA-Z]{4}((\\d{2}((0[13578]|1[02])(0[1-9]|[12]\\d|3[01])|(0[13456789]|1[012])(0[1-9]|[12]\\d|30)|02(0[1-9]|1\\d|2[0-8])))|([02468][048]|[13579][26])0229)(H|M)(AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|SM|NE)([a-zA-Z]{3})([a-zA-Z0-9\\s]{1})\\d{1}$');
var fecha_AAAAMMDD = new RegExp("([0-9]{4})/([0-9]{2})/([0-9]{2})");
var sexo = new RegExp("^[1-2]{1}$");
var telefono = new RegExp("^[0-9]{10}$");
var codigoPostal = new RegExp("^[0-9]{5}$");
var indicadorDeTelefono = new RegExp("^[0-9]{3}$");
//var correoRegex =new RegExp("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//var correoRegex =new RegExp(/^[a-zA-Z0-9_\.-]+@[a-zA-Z0-9_\.-]+\.[a-zA-Z]{1,4}/i);
var correoRegex =new RegExp(/^[a-zA-Z0-9_\.-]+@[a-zA-Z0-9_\.-]+\.([a-zA-Z]{1,4})$/i);


$.validator.addMethod("validaCorreo",function(value, element){
	return this.optional(element) || correoRegex.test($.trim(value));
});

$.validator.addMethod("validaRfcEditar",function(value, element){
	return this.optional(element) || rfcRegexEditar.test($.trim(value));
});

$.validator.addMethod("validaRfc",function(value, element){
	return this.optional(element) || rfcRegex.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_1",function(value, element){
	return this.optional(element) || alfaNumerico_1.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_2",function(value, element){
	return this.optional(element) || alfaNumerico_2.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_3",function(value, element){
	return this.optional(element) || alfaNumerico_3.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_4",function(value, element){
	return this.optional(element) || alfaNumerico_4.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_5",function(value, element){
	return this.optional(element) || alfaNumerico_5.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_8",function(value, element){
	return this.optional(element) || alfaNumerico_8.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_15",function(value, element){
	return this.optional(element) || alfaNumerico_15.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_16",function(value, element){
	return this.optional(element) || alfaNumerico_16.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_40",function(value, element){
	return this.optional(element) || alfaNumerico_40.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_50",function(value, element){
return this.optional(element) || alfaNumerico_50.test($.trim(value));
});

$.validator.addMethod("validaAlfaNumerico_65",function(value, element){
	return this.optional(element) || alfaNumerico_65.test($.trim(value));
});

$.validator.addMethod("validaNumerico_3",function(value, element){
	return this.optional(element) || numerico_3.test($.trim(value));
});

$.validator.addMethod("validaNumerico_6",function(value, element){
	return this.optional(element) || numerico_6.test($.trim(value));
});

$.validator.addMethod("validaNumerico_7",function(value, element){
	return this.optional(element) || numerico_7.test($.trim(value));
});

$.validator.addMethod("validaNumerico_10",function(value, element){
	return this.optional(element) || numerico_10.test($.trim(value));
});

$.validator.addMethod("validaNumerico_14",function(value, element){
	return this.optional(element) || numerico_14.test($.trim(value));
});

$.validator.addMethod("validaNssRegex",function(value, element){
	return this.optional(element) || nssRegex.test($.trim(value));
});

$.validator.addMethod("validaCurpRegex",function(value, element){
	return this.optional(element) || curpRegex.test($.trim(value));
});

$.validator.addMethod("validaFecha_AAAAMMDD",function(value, element){
	return this.optional(element) || fecha_AAAAMMDD.test($.trim(value));
});

$.validator.addMethod("validaSexo",function(value, element){
	return this.optional(element) || sexo.test($.trim(value));
});

$.validator.addMethod("validaTelefono",function(value, element){
	return this.optional(element) || telefono.test($.trim(value));
});

$.validator.addMethod("validaCodigoPostal",function(value, element){
	return this.optional(element) || codigoPostal.test($.trim(value));
});

$.validator.addMethod("validaIndicadorDeTelefono",function(value, element){
	return this.optional(element) || indicadorDeTelefono.test($.trim(value));
});

$.validator.addMethod("validaNumerico_1_3",function(value, element){
	return this.optional(element) || numerico_1_3.test($.trim(value));
});


//mensajes validacion
$("#actualizaTrabajador").validate({
	ignore: "",
	rules:
	{
		curp:{
			required:true,
			validaCurpRegex:true
		},
		nombre:{
			required:true,
			validaAlfaNumerico_40:true
		},
		apellidoPaterno:{
			required:true,
			validaAlfaNumerico_40:true
		},
		apellidoMaterno:{
			validaAlfaNumerico_40:true
		},
		fechaNacimiento:{
			required:true
		},
		genero:{
			required:true
		},
		entidadNacimiento:{
			required:true
		},
		rfc:{
			validaRfc:true
		},
		claveNacionalidad:{
			validaAlfaNumerico_3: true
		},
		claveTipoDocProbatorio:{
			validaAlfaNumerico_1:true
		},
		folioSolicitud:{
			required:true,
			validaNumerico_10: true
		},
		documentoProbatorio:{
			validaAlfaNumerico_16:true
		},
		folioDocumentoProbatorio:{
			validaNumerico_10: true
		},
		ocupacion:{
			validaAlfaNumerico_2: true
		},
		giro:{
			validaAlfaNumerico_2:true
		},
		estudios:{
			validaAlfaNumerico_2:true
		},
		noExterior:{
			validaAlfaNumerico_15:true
		},
		noInterior:{
			validaAlfaNumerico_15:true
		},
		calleLaboral:{
			validaAlfaNumerico_65: true
		},
		noExteriorLaboral:{
			validaAlfaNumerico_15:true
		},
		noInteriorLaboral:{
			validaAlfaNumerico_15:true
		},
		coloniaLaboral:{
			validaAlfaNumerico_65: true
		},
		municipioLaboral:{
			validaAlfaNumerico_65: true
		},
		codigoPostalLaboral:{
			validaCodigoPostal: true
		},
		entidadFederativaLaboral:{
			validaAlfaNumerico_65: true
		},
		paisLaboral:{
			validaAlfaNumerico_3: true
		},
		extension1:{
			validaAlfaNumerico_5: true
		},
		extension2:{
			validaAlfaNumerico_5: true
		},
		correoElectronico:{
			validaCorreo:true
		},
		apellidoMaternoRef:{
			validaAlfaNumerico_40: true
		},
		apellidoMaternoRef2:{
			validaAlfaNumerico_40: true
		}
	},
	messages:
	{
		curp:{
			required:"El campo CURP es obligatorio",
			validaCurpRegex:"El campo CURP no cuenta con formato correcto"	
		},
		nombre:{
			required:"El campo Nombre es obligatorio",
			validaAlfaNumerico_40:"El campo Nombre no cuenta con formato correcto"
		},
		apellidoPaterno:{
			required:"El campo Apellido Paterno es obligatorio",
			validaAlfaNumerico_40:"El campo Apellido Paterno no cuenta con formato correcto"
		},
		apellidoMaterno:{
			required:"El campo Apellido Materno es obligatorio",
			validaAlfaNumerico_40:"El campo Apellido Materno no cuenta con formato correcto"
		},
		fechaNacimiento:{
			required:"El campo Fecha de Nacimiento es obligatorio"
		},
		genero:{
			required:"El campo Genero es obligatorio"
		},
		entidadNacimiento:{
			required:"El campo Entidad de Nacimiento es obligatorio"
		},
		rfc:{
			validaRfc:"El campo RFC no cuenta con formato correcto",
		},
		rfcAlgoritmo:{
			validaRfcEditar:"El campo RFC no cuenta con formato correcto"
		},
		claveNacionalidad:{
			validaAlfaNumerico_3: "El campo Clave Nacionalidad no cuenta con formato correcto"
		},
		claveTipoDocProbatorio:{
			validaAlfaNumerico_1: "El campo Clave Tipo Documento Probatorio no cuenta con formato correcto"
		},
		folioSolicitud:{
			required:"El campo Folio Solicitud es obligatorio",
			validaNumerico_10: "El campo Folio de Solicitud no cuenta con formato correcto"
		},
		documentoProbatorio:{
			validaAlfaNumerico_16:"El campo Documento Probatorio no cuenta con formato correcto"
		},
		folioDocumentoProbatorio:{
			validaNumerico_10: "El campo Folio Documento Probatorio no cuenta con formato correcto"
		},
		ocupacion:{
			validaAlfaNumerico_2: "El campo Ocupacion no cuenta con formato correcto"
		},
		giro:{
			validaAlfaNumerico_2:"El campo Giro No cuenta con formato correcto"
		},
		estudios:{
			validaAlfaNumerico_2:"El campo Nivel de Estudios No cuenta con formato correcto"
		},
		calle:{
			required:"El campo Calle es obligatorio",
			validaAlfaNumerico_65: "El campo calle no cuenta con formato correcto"
		},
		noExterior:{
			validaAlfaNumerico_15:"El campo No. Exterior no cuenta con formato correcto"
		},
		noInterior:{
			validaAlfaNumerico_15:"El campo No. Interior no cuenta con formato correcto"
		},
		colonia:{
			required:"El campo Colonia es obligatorio",
			validaAlfaNumerico_65: "El campo Colonia no cuenta con formato correcto"
		},
		municipio:{
			required:"El campo Municipio es obligatorio",
			validaAlfaNumerico_65: "El campo Municipio no cuenta con formato correcto"
		},
		codigoPostal:{
			required: "El campo codigo postal es obligatorio",
			validaCodigoPostal: "El campo codigo postal no cuenta con formato correcto"
		},
		entidadFederativa:{
			required:"El campo Entidad Federativa es obligatorio",
			validaAlfaNumerico_65: "El campo Entidad Federativa no cuenta con formato correcto"
		},
		pais:{
			required:"El campo Pais es obligatorio",
			validaAlfaNumerico_3: "El campo Pais no cuenta con formato correcto"
		},
		calleLaboral:{
			required:"El campo Calle es obligatorio",
			validaAlfaNumerico_65: "El campo calle no cuenta con formato correcto"
		},
		noExteriorLaboral:{
			validaAlfaNumerico_15:"El campo No. Exterior no cuenta con formato correcto"
		},
		noInteriorLaboral:{
			validaAlfaNumerico_15:"El campo No. Interior no cuenta con formato correcto"
		},
		coloniaLaboral:{
			required:"El campo Colonia es obligatorio",
			validaAlfaNumerico_65: "El campo Colonia no cuenta con formato correcto"
		},
		municipioLaboral:{
			required:"El campo Municipio es obligatorio",
			validaAlfaNumerico_65: "El campo Municipio no cuenta con formato correcto"
		},
		codigoPostalLaboral:{
			required: "El campo codigo postal es obligatorio",
			validaCodigoPostal: "El campo codigo postal no cuenta con formato correcto"
		},
		entidadFederativaLaboral:{
			required:"El campo Entidad Federativa es obligatorio",
			validaAlfaNumerico_65: "El campo Entidad Federativa no cuenta con formato correcto"
		},
		paisLaboral:{
			required:"El campo Pais es obligatorio",
			validaAlfaNumerico_3: "El campo Pais no cuenta con formato correcto"
		},
		telefono1:{
			required:"El campo Teléfono 1 Fijo es obligatorio",
			validaTelefono: "El campo Telefono 1 Fijo no cuenta con formato correcto"
		},
		telefono2:{
			validaTelefono: "El campo Telefono 2 Fijo no cuenta con formato correcto"
		},
		celular:{
			required:"El campo Telefono Celular es obligatorio",
			validaTelefono: "El campo Telefono Celular no cuenta con formato correcto"
		},
		telefonoLaboral:{
			required:"El campo Telefono Laboral es obligatorio",
			validaTelefono: "El campo Telefono Laboral no cuenta con formato correcto"
		},
		extension1:{
			validaAlfaNumerico_5: "El campo Extension no cuenta con formato correcto"
		},
		extension2:{
			validaAlfaNumerico_5: "El campo Extension no cuenta con formato correcto"
		},
		correoElectronico:{
			validaCorreo:"El campo Correo Electronico no cuenta con formato correcto"
		},
		curpReferencia:{
			required: "El campo CURP es obligatorio",
			validaCurpRegex: "El campo CURP no cuenta con formato correcto"
		},
		nombreReferencia:{
			required: "El campo Nombre de Referencia es obligatorio",
			validaAlfaNumerico_40: "El campo Nombre de Referencia no cuenta con formato correcto"
		},
		apellidoPaternoRef:{
			required: "El campo Apellido Paterno de Referencia es obligatorio",
			validaAlfaNumerico_40: "El campo Apellido Paterno de Referencia no cuenta con formato correcto"
		},
		apellidoMaternoRef:{
			validaAlfaNumerico_40: "El campo Apellido Materno de Referencia no cuenta con formato correcto"
		},
		telefonoReferencia:{
			required: "El campo Telefono de Referencia es obligatorio",
			validaTelefono: "El campo Telefono de Referencia no cuenta con formato correcto"
		},
		parentescoRef:{
			required: "El campo Parentesco es obligatorio",
			validaAlfaNumerico_2: "El campo Parentesco no cuenta con formato correcto"
		},
		curpReferencia2:{
			required: "El campo CURP es obligatorio",
			validaCurpRegex: "El campo CURP no cuenta con formato correcto"
		},
		nombreReferencia2:{
			required: "El campo Nombre de Referencia es obligatorio",
			validaAlfaNumerico_40: "El campo Nombre de Referencia no cuenta con formato correcto"
		},
		apellidoPaternoRef2:{
			required: "El campo Apellido Paterno de Referencia es obligatorio",
			validaAlfaNumerico_40: "El campo Apellido Paterno de Referencia no cuenta con formato correcto"
		},
		apellidoMaternoRef2:{
			validaAlfaNumerico_40: "El campo Apellido Materno de Referencia no cuenta con formato correcto"
		},
		telefonoReferencia2:{
			required: "El campo Telefono de Referencia es obligatorio",
			validaTelefono: "El campo Telefono de Referencia no cuenta con formato correcto"
		},
		parentescoRef2:{
			required: "El campo Parentesco es obligatorio",
			validaAlfaNumerico_2: "El campo Parentesco no cuenta con formato correcto"
		},
		curpBeneficiarioModal:{
			required: "El campo CURP de Beneficiario es obligatorio",
			validaCurpRegex: "El campo CURP de Beneficiario no cuenta con formato correcto"
		},
		nombreBenModal:{
			required: "El campo Nombre de Beneficiario es obligatorio",
			validaAlfaNumerico_40: "El campo Nombre de Beneficiario no cuenta con formato correcto"
		},
		paternoBenModal:{
			required: "El campo Apellido Paterno es obligatorio",
			validaAlfaNumerico_40: "El campo Apellido Paterno no cuenta con formato correcto"
		},
		maternoBenModal:{
			validaAlfaNumerico_40: "El campo Apellido Materno no cuenta con formato correcto"
		},
		parentescoBen:{
			validaAlfaNumerico_2: "El campo Parentesco no cuenta con formato correcto"
		},
		porcentajeModal:{
			required: "El campo Porcentaje es obligatorio",
			validaNumerico_1_3: "El campo Porcentaje no cuenta con formato correcto"
		},
		curpSolicitante:{
			required:"El campo CURP es obligatorio",
			validaCurpRegex:"El campo CURP no cuenta con formato correcto"	
		},
		nombreSolicitante:{
			required:"El campo Nombre es obligatorio",
			validaAlfaNumerico_40:"El campo Nombre no cuenta con formato correcto"
		},
		apellidoPaternoSolicitante:{
			required:"El campo Apellido Paterno es obligatorio",
			validaAlfaNumerico_40:"El campo Apellido Paterno no cuenta con formato correcto"
		},
		apellidoMaternoSolicitante:{
			required:"El campo Apellido Materno es obligatorio",
			validaAlfaNumerico_40:"El campo Apellido Materno no cuenta con formato correcto"
		},	
		calleSolicitante:{
			required:"El campo Calle es obligatorio",
			validaAlfaNumerico_65: "El campo calle no cuenta con formato correcto"
		},
		noExteriorSolicitante:{
			validaAlfaNumerico_15:"El campo No. Exterior no cuenta con formato correcto"
		},
		noInteriorSolicitante:{
			validaAlfaNumerico_15:"El campo No. Interior no cuenta con formato correcto"
		},
		coloniaSolicitante:{
			required:"El campo Colonia es obligatorio",
			validaAlfaNumerico_65: "El campo Colonia no cuenta con formato correcto"
		},
		municipioSolicitante:{
			required:"El campo Municipio es obligatorio",
			validaAlfaNumerico_65: "El campo Municipio no cuenta con formato correcto"
		},
		codigoPostalSolicitante:{
			required: "El campo codigo postal es obligatorio",
			validaCodigoPostal: "El campo codigo postal no cuenta con formato correcto"
		},
		entidadFederativaSolicitante:{
			required:"El campo Entidad Federativa es obligatorio",
			validaAlfaNumerico_65: "El campo Entidad Federativa no cuenta con formato correcto"
		},
		paisSolicitante:{
			required:"El campo Pais es obligatorio",
			validaAlfaNumerico_3: "El campo Pais no cuenta con formato correcto"
		}
		
	},
	errorPlacement: function(error,element){
		$(element).closest('.form-group').find('.Labeltexterror').html(error.html());
	},
	highlight: function(element){
		$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
	},
	unhighlight: function(element,errorClass,validClass){
		$(element).closest('.form-group').removeClass('has-error');
		$(element).closest('.form-group').find('.Labeltexterror').html('');
	},
	
	submitHandler:function(form){
		var validaRespuestaFlujo9B = false;
		var validacionPorcentajes = validaPorcentajesBeneficiarios();
		var validaCurps = validaCurpsBeneficiarios();
		var validaCheckBeneficiarios = validarValorCheckBeneficiarios();
		var numeroBeneficiariosValida = validaNumeroBeneficiarios();
		var validaCurpBeneficiariosExistentes = validaCurpsBeneficiariosRenapo();
		var validaBeneficiariosCurpTitular = validaDiferenciaCurpsBeneficiariosCurpTitular();
		if(!validacionPorcentajes && !validaCurps && (validaCheckBeneficiarios && 0 == numeroBeneficiariosValida || !validaCheckBeneficiarios && numeroBeneficiariosValida > 0) && validaCurpBeneficiariosExistentes && (numeroBeneficiariosValida <= NUMERO_BENEFICIARIOS_PERMITIDOS) && !validaBeneficiariosCurpTitular){
			 validaRespuestaFlujo9B = validaFlujo9B();
		}
		
		if(validacionPorcentajes){
			muestraModal("Validación Beneficiarios","La suma de los PORCENTAJES de los BENEFICIARIOS debe ser igual a 100% \n");
		}else if(validaCurps){
			muestraModal("Validación Beneficiarios","Las CURP de los BENEFICIARIOS no pueden repetirse");
		}else if(validaBeneficiariosCurpTitular){
			muestraModal("Validación Beneficiarios","Las CURP de los BENEFICIARIOS deben de ser diferentes a la del titular");
		}else if(!validaCheckBeneficiarios && 0 == numeroBeneficiariosValida){
			$("#mensajeCheckObligatorio").append("Campo obligatorio");
			window.location.href = "#";
			muestraModal("Validación Formulario","Faltan datos por capturar en Datos Complementarios");
		}else if(numeroBeneficiariosValida > NUMERO_BENEFICIARIOS_PERMITIDOS){
			muestraModal("Validación Beneficiarios","Solo puede tener un maximo de "+NUMERO_BENEFICIARIOS_PERMITIDOS+" beneficiarios");
		}else if(!validacionPorcentajes && !validaCurps && !validaRespuestaFlujo9B && (validaCheckBeneficiarios && 0 == numeroBeneficiariosValida || !validaCheckBeneficiarios && numeroBeneficiariosValida > 0) && validaCurpBeneficiariosExistentes && (numeroBeneficiariosValida <= NUMERO_BENEFICIARIOS_PERMITIDOS)){
			
			if(modifica == true){
				//solicitaModificacion();
				//abrirExpedienteServicio();
				validarPendienteTrabajador(); 
			}else{
				validaMarcasOperativasServicioPermanencia();
			}
		}
	}
	
});

	$("#direccionParticularContenedor input, #direccionParticularContenedor select").change(function () {
		var valor = $(this).val();
		var calle = $.trim(document.getElementById('calle').value);
		var colonia = $.trim(document.getElementById('colonia').value);
		var codigoPostal = $.trim(document.getElementById('codigoPostal').value);
		if(valor != ""){
			datosDomicilioParticularReglas();
		} else {
			if(calle == "" && colonia == "" && codigoPostal == ""){
				datosDomicilioParticularBorrarReglas();
			}
		}
	});
	
	
	
	$("#direccionLaboralContenedor input, #direccionLaboralContenedor select").change(function () {
		var valor = $(this).val();
		var calleLaboral = $.trim(document.getElementById('calleLaboral').value);
		var coloniaLaboral = $.trim(document.getElementById('coloniaLaboral').value);
		var codigoPostalLaboral = $.trim(document.getElementById('codigoPostalLaboral').value);
		if(valor != ""){
			datosDomicilioLaboralReglas();
		}else{
			if(calleLaboral == "" && coloniaLaboral == "" && codigoPostalLaboral == ""){
				datosDomicilioLaboralBorrarReglas();
			}
		}
	});
	
	$("#referencias1 input, #referencias1 select, #referencias2 input, #referencias2 select").change(function () {
		var valor = $(this).val();
		var curpReferencia1 = $.trim(document.getElementById('curpReferencia').value);
		var nombreferencia1 = $.trim(document.getElementById('nombreReferencia').value);
		var apellidoPReferencia1 = $.trim(document.getElementById('apellidoPaternoRef').value);
		var curpReferencia2 = $.trim(document.getElementById('curpReferencia2').value);
		var nombreferencia2 = $.trim(document.getElementById('nombreReferencia2').value);
		var apellidoPReferencia2 = $.trim(document.getElementById('apellidoPaternoRef2').value);
		if(valor != ""){
			datosReferenciasReglas();
		} else {
			if(curpReferencia1 == "" && nombreferencia1 == "" && apellidoPReferencia1 == "" && curpReferencia2 == "" && nombreferencia2 == "" && apellidoPReferencia2 == ""){
				datosReferenciasBorrarReglas();
			}
		}
	});
	
	
	$("#datosSolicitanteContenedor input, #datosSolicitanteContenedor select").change(function () {
		var valor = $(this).val();
		var curpSolicitante = $.trim(document.getElementById('curpSolicitante').value);
		var nombreSolicitante = $.trim(document.getElementById('nombreSolicitante').value);
		var paternoSolicitante = $.trim(document.getElementById('apellidoPaternoSolicitante').value);
		if(valor != ""){
			datosGeneralesSolicitanteReglas();
		}else{
			if(curpSolicitante == "" && nombreSolicitante == "" && paternoSolicitante == ""){
				datosGeneralesSolicitanteBorrarReglas();
			}
		}
	});
	
	$("#direccionParticularSolicitanteContenedor input, #direccionParticularSolicitanteContenedor select").change(function () {
		var valor = $(this).val();
		var calleSolicitante = $.trim(document.getElementById('calleSolicitante').value);
		var coloniaSolicitante = $.trim(document.getElementById('coloniaSolicitante').value);
		var codigoPostaSolicitante = $.trim(document.getElementById('codigoPostalSolicitante').value);
		if(valor != ""){
			datosDireccionSolicitanteReglas();
		}else{
			if(calleSolicitante == "" && coloniaSolicitante == "" && codigoPostaSolicitante == ""){
				datosDireccionSolicitanteBorrarReglas();
			}
		}
	});
	
//	$("#form_curpFaltante").validate({
//		ignore: "",
//		rules:
//		{
//			curpFaltante:{
//				validaCurpRegex:true
//			}
//		},
//		messages:
//		{
//			curpFaltante:{
//				validaCurpRegex:"El campo no cuenta con formato correcto"	
//			}
//		},
//		errorPlacement: function(error,element){
//			$(element).closest('.form-group').find('.Labeltexterror').html(error.html());
//		},
//		highlight: function(element){
//			$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
//		},
//		unhighlight: function(element,errorClass,validClass){
//			$(element).closest('.form-group').removeClass('has-error');
//			$(element).closest('.form-group').find('.Labeltexterror').html('');
//		},
//		
//		submitHandler:function(form){
//			$("#form_curpFaltante").submit();
//		}
//	});
	
	
	
});

function datosDomicilioParticularReglas() {
	$("#calle").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#colonia").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#pais").rules('add', {
		required:true,
		validaAlfaNumerico_3: true
	});
	$("#entidadFederativa").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#municipio").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#codigoPostal").rules('add', {
		required: true,
		validaCodigoPostal: true
	});

	$("#telefono1").rules('add', {
		required:true,
		validaTelefono: true
	});
	$("#telefono2").rules('add', {
		validaTelefono: true
	});
	
	$("#correoElectronico").rules('add',{
		validaCorreo: true	
	})
}

function datosDomicilioParticularBorrarReglas() {
	$("#calle").rules('remove');
	$("#colonia").rules('remove');
	$("#pais").rules('remove');
	$("#entidadFederativa").rules('remove');
	$("#municipio").rules('remove');
	$("#codigoPostal").rules('remove');
	$("#telefono1").rules('remove');
	$("#telefono2").rules('remove');
	$("#correoElectronico").rules('remove');
	$("#direccionParticularContenedor span.Labeltexterror").html("");
}


function datosDomicilioLaboralReglas(){
	$("#calleLaboral").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#coloniaLaboral").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#paisLaboral").rules('add', {
		required:true,
		validaAlfaNumerico_3: true
	});
	$("#entidadFederativaLaboral").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#municipioLaboral").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#codigoPostalLaboral").rules('add', {
		required: true,
		validaCodigoPostal: true
	});
	
}


function datosDomicilioLaboralBorrarReglas() {
	$("#calleLaboral").rules('remove');
	$("#coloniaLaboral").rules('remove');
	$("#paisLaboral").rules('remove');
	$("#entidadFederativaLaboral").rules('remove');
	$("#municipioLaboral").rules('remove');
	$("#codigoPostalLaboral").rules('remove');
	$("#direccionLaboralContenedor span.Labeltexterror").html("");
}

function datosReferenciasReglas() {
	$("#nombreReferencia").rules('add', {
		required: true,
		validaAlfaNumerico_40: true
	});
	$("#apellidoPaternoRef").rules('add', {
		required: true,
		validaAlfaNumerico_40: true
	});
	$("#curpReferencia").rules('add', {
		required: true,
		validaCurpRegex: true
	});
	$("#telefonoReferencia").rules('add', {
		required: true,
		validaTelefono: true
	});
	$("#parentescoRef").rules('add', {
		required: true,
		validaAlfaNumerico_2: true
	});

	$("#nombreReferencia2").rules('add', {
		required: true,
		validaAlfaNumerico_40: true
	});
	$("#apellidoPaternoRef2").rules('add', {
		required: true,
		validaAlfaNumerico_40: true
	});
	$("#curpReferencia2").rules('add', {
		required: true,
		validaCurpRegex: true
	});
	$("#telefonoReferencia2").rules('add', {
		required: true,
		validaTelefono: true
	});
	$("#parentescoRef2").rules('add', {
		required: true,
		validaAlfaNumerico_2: true
	});
}

function datosReferenciasBorrarReglas() {
	$("#nombreReferencia").rules('remove');
	$("#apellidoPaternoRef").rules('remove');
	$("#curpReferencia").rules('remove');
	$("#telefonoReferencia").rules('remove');
	$("#parentescoRef").rules('remove');

	$("#nombreReferencia2").rules('remove');
	$("#apellidoPaternoRef2").rules('remove');
	$("#curpReferencia2").rules('remove');
	$("#telefonoReferencia2").rules('remove');
	$("#parentescoRef2").rules('remove');
	$("#referencias1 span.Labeltexterror, #referencias2 span.Labeltexterror").html("");
}

function datosBeneficiariosReglas() {
	$("#curpBeneficiarioModal").rules('add', {
		required: true,
		validaCurpRegex: true
	});
	$("#nombreBenModal").rules('add', {
		required: true,
		validaAlfaNumerico_40: true
	});
	$("#porcentajeModal").rules('add', {
		required: true,
		validaNumerico_1_3: true
	});
	$("#paternoBenModal").rules('add', {
		required: true,
		validaAlfaNumerico_40: true
	});	
	$("#maternoBenModal").rules('add', {
		validaAlfaNumerico_40: true
	});
	$("#parentescoBen").rules('add', {
		minlength: 1
	});
}

function datosBeneficiariosReglasRemove() {
	$("#curpBeneficiarioModal").rules('remove');
	$("#nombreBenModal").rules('remove');
	$("#porcentajeModal").rules('remove');
	$("#paternoBenModal").rules('remove');
	$("#maternoBenModal").rules('remove');
	$("#parentescoBen").rules('remove');
	$("#agregaBeneficiario span.Labeltexterror").html("");
}

function redireccionModalMarcasPen(){
	window.location.href = "datosGenerales.do";
}


function validaMarcasOperativasServicio13Plus(){
	var idProcesarTrabajador = $("#idProcesarTrabajador").val();
	var cveProceso = "A001";
	$.ajax({
		method      : "GET",
		url         : "validaMarcasOperativas.do",
		contentType : "application/json",
		data		: { idProcesar : idProcesarTrabajador, cveProceso : cveProceso},
		beforeSend : function() {
			window.location.href = "#modalLoader";
		}
	})
	.success(function(data) {
		window.location.href = "#";
		if(data.flujo == 1) {
			validaDatosCertificablesContraRenapo();
		}else if (data.flujo == 2){
			var tituloModal = "<h2 class='ModalTitle' >Actualización de Datos</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModalMarcasPen()'>X</a>";
			var mensajeModal = "ERROR: Existen marcas operativas  que impiden la operación";
			$('#tituloActExp').empty();
			$('#mensajeActExp').empty();
			$('#tituloActExp').append(tituloModal);
			$('#mensajeActExp').append(mensajeModal);
			window.location.href = "#modalActExp";
		} 
	});
}


function validaMarcasOperativasServicioPermanencia(){
	var idProcesarTrabajador = $("#idProcesarTrabajador").val();
	var cveProceso = "A005";
	$.ajax({
		method      : "GET",
		url         : "validaMarcasOperativas.do",
		contentType : "application/json",
		data		: { idProcesar : idProcesarTrabajador, cveProceso : cveProceso},
		beforeSend : function() {
			window.location.href = "#modalLoader";
		}
	})
	.success(function(data) {
		window.location.href = "#";
		if(data.flujo == 1) {
			ejecutarPermanencia();
		}else if (data.flujo == 2){
			var tituloModal = "<h2 class='ModalTitle' >Permanencia</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModalMarcasPen()'>X</a>";
			var mensajeModal = "ERROR: Existen marcas operativas  que impiden la operación";
			$('#tituloActExp').empty();
			$('#mensajeActExp').empty();
			$('#tituloActExp').append(tituloModal);
			$('#mensajeActExp').append(mensajeModal);
			window.location.href = "#modalActExp";
		} 
	});	
}



function validaDatosCertificablesContraRenapo(){
	cargaEntradaModificacion13Plus();
}






function validarPendienteTrabajador(){
	var curpTrabajador = $.trim($('#curp').val());
	$.ajax({
		method      : "GET",
		url         : "validaPendienteTrabajador.do",
		contentType : "application/json",
		data		: { curpTrabajador : curpTrabajador},
		beforeSend : function() {
			window.location.href = "#modalLoader";
		}
	})
	.success(function(data) {
		window.location.href = "#";
		if(data.flujo == 1) {
			validaMarcasOperativasServicio13Plus();
		}else if (data.flujo == 2){
			var tituloModal = "<h2 class='ModalTitle' >"+data.titulo+"</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModalMarcasPen()'>X</a>";
			var mensajeModal = data.mensaje;
			$('#tituloActExp').empty();
			$('#mensajeActExp').empty();
			$('#tituloActExp').append(tituloModal);
			$('#mensajeActExp').append(mensajeModal);
			window.location.href = "#modalActExp";
		} 
	});
}




function datosGeneralesSolicitanteReglas() {
	$("#curpSolicitante").rules('add', {
		required: true,
		validaCurpRegex: true
	});
	$("#nombreSolicitante").rules('add', {
		required: true,
		validaAlfaNumerico_40: true
	});
	$("#apellidoPaternoSolicitante").rules('add', {
		required: true,
		validaAlfaNumerico_40: true
	});	
	$("#apellidoMaternoSolicitante").rules('add', {
		validaAlfaNumerico_40: true
	});
}

function datosGeneralesSolicitanteBorrarReglas() {
	$("#curpSolicitante").rules('remove');
	$("#nombreSolicitante").rules('remove');
	$("#apellidoPaternoSolicitante").rules('remove');
	$("#apellidoMaternoSolicitante").rules('remove');
	$("#datosSolicitanteContenedor span.Labeltexterror").html("");
}



function datosDireccionSolicitanteReglas() {	
	$("#calleSolicitante").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#coloniaSolicitante").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#paisSolicitante").rules('add', {
		required:true,
		validaAlfaNumerico_3: true
	});
	$("#entidadFederativaSolicitante").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#municipioSolicitante").rules('add', {
		required:true,
		validaAlfaNumerico_65: true
	});
	$("#codigoPostalSolicitante").rules('add', {
		required: true,
		validaCodigoPostal: true
	});	
	$("#noExteriorSolicitante").rules('add', {
		validaAlfaNumerico_15: true
	});
	$("#noInteriorSolicitante").rules('add', {
		validaAlfaNumerico_15: true
	});

}

function datosDireccionSolicitanteBorrarReglas() {
	$("#calleSolicitante").rules('remove');
	$("#coloniaSolicitante").rules('remove');
	$("#paisSolicitante").rules('remove');
	$("#entidadFederativaSolicitante").rules('remove');
	$("#municipioSolicitante").rules('remove');
	$("#codigoPostalSolicitante").rules('remove');
	$("#noExteriorSolicitante").rules('remove');
	$("#noInteriorSolicitante").rules('remove');
	$("#direccionParticularSolicitanteContenedor span.Labeltexterror").html("");
}