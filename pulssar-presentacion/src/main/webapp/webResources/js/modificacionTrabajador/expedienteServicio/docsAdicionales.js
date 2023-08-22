$(document).ready(function() {
	$("#carruselDocumentosModal").hide();
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		$("#btnEnviarExpedienteServicio").css("display", "none");
		$('#botonesModalActExp').hide();
		pintanDatosDatosDocsAdicionales();
		window.location.href = "#modalLoader";
		validarExpedienteServicio();
//		window.location.href = "#exitoModal";
		//$("#btnEnviarExpedienteServicio").attr('disabled','disabled');
	} else if(_FLUJO == "2") {
		window.location.href = "#errorModal";
	}
	
	//Pinta los datos en pantalla
	pintanDatosDatosDocsAdicionales();
	
	var file = $('input:file').on('change',function(e){
//		var file = $(document).on('change','input[type="file"]',function(e){
		var check = $('input[type="checkbox"]');
		var valido = true;
		if(e.target.files.length != 0) {
			var auxFile = e.target.files[0];
			var ext = auxFile.name.split('.').pop().toLowerCase();
			if(ext != "jpg" && ext != "png" && ext != "jpeg" && ext != "pdf" && ext != "tif") {
				e.target.value = '';
				$("#btnInfoM").attr('href', "#");
				var tituloModal = "Error Archivo";
				var mensajeModal = "El tipo de archivo es incorrecto, favor de validar.";
				$('#tituloInfo').empty();
				$('#mensajeInfo').empty();
				$('#tituloInfo').append(tituloModal);
				$('#mensajeInfo').append(mensajeModal);
				window.location.href = "#infoModal";
			}
			if(1048576 < auxFile.size) {
				e.target.value = '';
				$("#btnInfoM").attr('href', "#");
				var tituloModal = "Error archivo";
				var mensajeModal = "El tamaño del archivo es superior al recomendado 1M.";
				$('#tituloInfo').empty();
				$('#mensajeInfo').empty();
				$('#tituloInfo').append(tituloModal);
				$('#mensajeInfo').append(mensajeModal);
				window.location.href = "#infoModal";
			}
		}
		file.each(function(){
			var campoArchivo = $(this).attr("name");
		if($("input[name="+campoArchivo+"]").get(0).files.length != 0){
			var clave = campoArchivo.split("_");

			check.each(function(){
				var nombreCheck = $(this).attr("name");
				if(nombreCheck.includes(clave[1])){
					$("input[name="+nombreCheck+"]").prop("checked",true);
				}
			});
		}else{
			var clave = campoArchivo.split("_");
			check.each(function(){
				var nombreCheck = $(this).attr("name");
				if(nombreCheck.includes(clave[1])){
					$("input[name="+nombreCheck+"]").prop("checked",false);
				}
			});
		}
		});
	});
	
	
	$("#btnEnviarExpedienteServicio").click(function(event) {
		$("#btnEnviarExpedienteServicio").attr("disabled","disabled");
		event.preventDefault();
		window.location.href = "#modalLoader";
		var archivos = $('input[type="file"]').get(0).files.length;
		$("#btnEnviarExpedienteServicio").attr("disabled",false);
		if(archivos != 0) {	
			form = $("#fm_expedienteServicio")[0];
			data = new FormData(form);
			$.ajax({
				method      : "POST",
				url         : "convertirArchivos.do",
				enctype		: "multipart/form-data",
				processData	: false,
				contentType	: false,
				data		: data
			}).success(function(resultado) {
				  console.log(resultado);
				for(let i = 0;i < resultado.length;i++){
					agregarImagenVisor(resultado[i].contenidoDocumento, resultado[i].nombreDocumento);
	
			}
				$("#carruselDocumentosModal").show();
	            window.location.href="#carruselDocumentosModal";
	
				
			}).error(function (jqXHR, textStatus, errorThrown){
//				alert("Se produjo un error inesperado Solicitud Modificacion Datos Pdf ",errorThrown);
//				window.location.href = "datosGenerales.do";
				document.getElementById("fm_expedienteServicio").reset();
				$("#btnInfoM").attr('href', "#");
				var tituloModal = "Expediente Servicio";
				var mensajeModal = "Ocurrió un problema al cargar los archivos, intenta nuevamente.";
				$('#tituloInfo').empty();
				$('#mensajeInfo').empty();
				$('#tituloInfo').append(tituloModal);
				$('#mensajeInfo').append(mensajeModal);
				window.location.href = "#infoModal";
			});
		}else{
			$("#fm_expedienteServicio").submit();
		}
//		$("#fm_expedienteServicio").submit();
		
	});
	
//	$("#btnExitoExpeServicio").click(function(event) {
//		event.preventDefault();
//		event.stopPropagation();
//		solicitaModificacion13Plus();
//	});
	
	$("#btnExitoM").click(function(event) {
		event.preventDefault();
		$("#btnExitoM").attr('disabled', 'disabled');
		window.location.href = "#modalLoader";
		solicitaModificacion13Plus();
	});
	
	$("#btnRegresarAInicio").click(function(event) {
		window.location.href = "#modalLoader";
		$("#fm_datosConsulta").submit();
	});
	
	$('#btnErrorM').click(function(event) {
		window.location.href = "datosGenerales.do";
	});
});

function respuestaAceptadaVisorDoc(){
	$("#btnEnviarExpedienteServicio").attr("disabled",false);
	window.location.href = "#modalLoader";
	$("#fm_expedienteServicio").submit();
	window.location.href = "#modalLoader";

}

function cargaloader(){
	window.location.href = "#modalLoader";
}

function respuestaCancelarVisorDoc(){
	window.location.href = "#";
	$("#btnEnviarExpedienteServicio").attr("disabled",false);

}


function pintanDatosDatosDocsAdicionales(){
	$("#idNssDocsAdic").text($("#nssTrabajajador").val());
	$("#idCurpDocsAdic").text($("#curpTrabajador").val());
	$("#idNombreTrabajadorDocsAdic").text($("#nombreTrabajador").val());
	$("#idApellidoPaternoDocsAdic").text($("#apellidoPaterno").val());
	$("#idApellidoMaternoDocsAdic").text($("#apellidoMaterno").val());
	$("#idTipoServicioDocsAdic").text($("#chTipoSolicitante").val());
}

function redireccionModal(){
	window.location.href = "datosGenerales.do";
}


function solicitaModificacion13Plus() {
	
	$.ajax({
		url : 'actualizaTrabajador',
		error: function (jqXHR, textStatus, errorThrown){
			var tituloModal = "<h2 class='ModalTitle' >Actualización de Datos</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
			var mensajeModal = "Se produjo un Error inesperado";
			window.location.href = "#";
			$('#tituloActExp').empty();
			$('#mensajeActExp').empty();
			$('#tituloActExp').append(tituloModal);
			$('#mensajeActExp').append(mensajeModal);
			window.location.href = "#modalActExp";
		},
		type : "POST",
		contentType : 'application/json',
		dataType: 'json',
		beforeSend : function() {
			window.location.href = "#modalLoader";
		},
		success : function(response) {
			console.log(response);
			if(response.resultadoActualizacion == "MESA CONTROL"){
				var tituloModal = "<h2 class='ModalTitle' >Proceso Pendiente</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
				var mensajeModal = "'Expediente de identificación en espera de revisión debido a riesgo medio al validar documentos.";
				window.location.href = "#";
				$('#tituloActExp').empty();
				$('#mensajeActExp').empty();
				$('#tituloActExp').append(tituloModal);
				$('#mensajeActExp').append(mensajeModal);
				window.location.href = "#modalActExp";
			}
			if(response.resultadoActualizacion == "NOFLUJO"){
				var tituloModal = "<h2 class='ModalTitle' >Validación de flujo</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
				var mensajeModal = "Error al obtener flujo de validación.";
				window.location.href = "#";
				$('#tituloActExp').empty();
				$('#mensajeActExp').empty();
				$('#tituloActExp').append(tituloModal);
				$('#mensajeActExp').append(mensajeModal);
				window.location.href = "#modalActExp";
			}
			if(response.resultadoActualizacion == "ERROR"){
				var tituloModal = "<h2 class='ModalTitle' >Actualización de Datos</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
				var mensajeModal = "Ocurrio un Error en el proceso de Actualización de Datos";
				window.location.href = "#";
				$('#tituloActExp').empty();
				$('#mensajeActExp').empty();
				$('#tituloActExp').append(tituloModal);
				$('#mensajeActExp').append(mensajeModal);
				window.location.href = "#modalActExp";
			}
			if(response.resultadoActualizacion == "EL TRABAJADOR NO CUENTA CON SELLO" || 
					response.resultadoActualizacion == "EL EMPLEADO NO CUENTA CON SELLO"	){
				var tituloModal = "<h2 class='ModalTitle' >Actualización de Datos</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
				var mensajeModal = response.resultadoActualizacion;
				window.location.href = "#";
				$('#tituloActExp').empty();
				$('#mensajeActExp').empty();
				$('#tituloActExp').append(tituloModal);
				$('#mensajeActExp').append(mensajeModal);
				window.location.href = "#modalActExp";
			}
			if(response.resultadoActualizacion == "SIN ENROLAMIENTO" || 
					response.resultadoActualizacion == "SIN EXPEDIENTE"	){
				var tituloModal = "<h2 class='ModalTitle' >Actualización de Datos</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
				var mensajeModal = response.resultadoActualizacion == "SIN ENROLAMIENTO" ? "No cuenta con Expediente Biométrico." : "No cuenta con Expediente de Identificacion.";
//				mensajeModal = mensajeModal + "\n ¿Deseas crear el expediente?";
				window.location.href = "#";
				$('#tituloActExp').empty();
				$('#mensajeActExp').empty();
				$('#tituloActExp').append(tituloModal);
				$('#mensajeActExp').append(mensajeModal);
				window.location.href = "#modalActExp";
			}
			if(response.resultadoActualizacion == "OK"){
				var tablaModifica = "tablaModifica";
				var listaRechazos = response.rechazosBloque;
				var inicioTabla = "<table id='"+tablaModifica+"' class='display'><thead><tr class='RowHeader'><th align='center'>BLOQUE</th><th align='center'>ESTATUS</th><th align='center'>DIAGNOSTICO</th></tr></thead><tbody>";
				var finTabla ="</tbody></table>"; 
				var cuerpoTabla= "";
				var i;
				for(i=0; i< response.rechazosBloque.length; i++){
					cuerpoTabla = cuerpoTabla + "<tr><td>"+response.rechazosBloque[i].bloque+"</td><td align='center'>"+response.rechazosBloque[i].estatus+"</td><td>";
					if(response.rechazosBloque[i].rechazos != null) {
						for(var clave in response.rechazosBloque[i].rechazos[0]) {
							cuerpoTabla = cuerpoTabla + "<p>" + clave + ": " + response.rechazosBloque[i].rechazos[0][clave] + "</p>";
						}
					}
					cuerpoTabla = cuerpoTabla + "</td></tr>";
				}
				var tablaCompleta =inicioTabla+cuerpoTabla+finTabla;
				$('#datosRechazos').append(tablaCompleta);
				muestraResultado();
				window.location.href = "#";
			}
		},
		fail: function(jqXHR, textStatus, errorThrown){
			window.location.href = "#";
			alert("Se produjo un error inesperado",errorThrown);
		}
	});
}


function muestraResultado(){
	var _titulo = "<h1>Resultado Actualización de Datos</h1>";
	$('#tituloPantalla').empty();
	$('#tituloPantalla').append(_titulo);	
	document.getElementById('resultado').style.display='block';
	$("#idSeccionDocumentosAdicionales").removeClass("Container");
	$("#idSeccionDocumentosAdicionales").addClass("Container_None");
	$("#idSeccionBotonRegresarAInicio").removeClass("Container_None")
	$("#idSeccionBotonRegresarAInicio").addClass("Container");
}

function validarExpedienteServicio() {
	$.ajax({
		method      : "GET",
		url         : "verificarProcesoExpediente.do",
		contentType : "application/json",
		dataType: 'json',
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			window.location.href = "#";
			document.getElementById('tituloExito').innerHTML = data.titulo;
			document.getElementById('mensajeExito').innerHTML = data.mensaje;
			window.location.href = "#exitoModal";
		} else if(data.flujo == 2) {
			window.location.href = "#";
			document.getElementById('tituloError').innerHTML = data.titulo;
			document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
			window.location.href = "#errorModal";
		} else if(data.flujo == 3) {
			setTimeout(validarExpedienteServicio, 10000);
		} 
	});
}

