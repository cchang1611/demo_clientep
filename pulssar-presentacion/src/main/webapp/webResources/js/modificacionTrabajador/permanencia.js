
$(document).ready(function() {
	
	String.prototype.includes = function (str) {
		  var returnValue = false;

		  if (this.indexOf(str) !== -1) {
		    returnValue = true;
		  }

		  return returnValue;
		}
	
	$("#btnPermanencia").click(function(event) {
		$("#btnPermanencia").attr("disabled", "true");
		$.ajax({
			url : 'permanenciaExp',
			type : "POST",
			contentType : 'application/json',
			
			beforeSend : function() {
				window.location.href = "#modalLoader";
			},
			complete : function(data) {
				var resultado = data.responseText;
				if (resultado =="ERROR") {
					window.location.href = "#";
					var tituloModal = "<h2 class='ModalTitle' >Permanencia</h2><a href='#' class='ModalButton' id='btnActExp'  onclick='redireccionModal()'>X</a>";
					var mensajeModal = "ERROR: Ocurrio un error al ejecutar el servicio.";
					$('#tituloActExp').empty();
					$('#mensajeActExp').empty();
					$('#tituloActExp').append(tituloModal);
					$('#mensajeActExp').append(mensajeModal);
					window.location.href = "#modalActExp";
				}else if(resultado == "MESA CONTROL"){
					window.location.href = "#";
					var tituloModal = "<h2 class='ModalTitle' >Proceso Pendiente</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
					var mensajeModal = "Expediente de identificación en espera de revisión debido a riesgo medio al validar documentos.";
					$('#tituloActExp').empty();
					$('#mensajeActExp').empty();
					$('#tituloActExp').append(tituloModal);
					$('#mensajeActExp').append(mensajeModal);
					window.location.href = "#modalActExp";
				}else if(resultado == "SIN EXPEDIENTE" || resultado == "SIN ENROLAMIENTO"){
					window.location.href = "#";
					var tituloModal = "<h2 class='ModalTitle' >Permanencia</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
					var mensajeModal = resultado == "SIN ENROLAMIENTO" ? "No cuenta con Expediente Biométrico." : "No cuenta con Expediente de Identificacion.";
					$('#tituloActExp').empty();
					$('#mensajeActExp').empty();
					$('#tituloActExp').append(tituloModal);
					$('#mensajeActExp').append(mensajeModal);
					window.location.href = "#modalActExp";
				}else if(resultado == "NOSELLO"){
					window.location.href = "#";
					var tituloModal = "<h2 class='ModalTitle' >Permanencia</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
					var mensajeModal = "EL TRABAJADOR NO CUENTA CON SELLO";
					$('#tituloActExp').empty();
					$('#mensajeActExp').empty();
					$('#tituloActExp').append(tituloModal);
					$('#mensajeActExp').append(mensajeModal);
					window.location.href = "#modalActExp";
				}else if(resultado.includes("ACEPTADO")){
					window.location.href = "#";
					var tablaModifica = "tablaModifica";
					$('#datosRechazos').empty();
					var rechazos = data.responseText.split('|');
					var _RECHAZOS = "<table id='"+tablaModifica+"' class='display'><thead><tr class='RowHeader'><th align='center'>BLOQUE</th><th align='center'>ESTATUS</th><th align='center'>DIAGNOSTICO</th></tr></thead><tbody><tr><td>PERMANENCIA</td><td align='center'>"+rechazos[0]+"</td><td>"+rechazos[1]+"</td></tr></tbody></table>"; 
					$('#datosRechazos').append(_RECHAZOS);
					muestraResultado();
					/*refrescando datos pantalla realizando la consulta*/
//					$("#fm_datosConsulta").submit();
				}else if(resultado.includes("RECHAZADO")){
					window.location.href = "#";
					var tablaModifica = "tablaModifica";
					$('#datosRechazos').empty();
					var rechazos = data.responseText.split('|');
					var _RECHAZOS = "<table id='"+tablaModifica+"' class='display'><thead><tr class='RowHeader'><th align='center'>BLOQUE</th><th align='center'>ESTATUS</th><th align='center'>DIAGNOSTICO</th></tr></thead><tbody><tr><td>PERMANENCIA</td><td align='center'>"+rechazos[0]+"</td><td>"+rechazos[1]+"</td></tr></tbody></table>"; 
					$('#datosRechazos').append(_RECHAZOS);
					muestraResultado();
					/*refrescando datos pantalla realizando la consulta*/
//					$("#fm_datosConsulta").submit();
				}
				
				
			}
		});	
	});	
	
	$("#btnRegresarAInicio").click(function(event) {
		window.location.href = "#modalLoader";
		$("#fm_datosConsulta").submit();
	});
	
});

function redireccionModal(){
	window.location.href = "datosGenerales.do";
}

function muestraResultado(){
	window.location.href = "#";
	var _titulo = "<h1>Resultado de Permanencia</h1>";
	$('#tituloPantalla').empty();
	$('#tituloPantalla').append(_titulo);
	document.getElementById('resultado').style.display='block';
	
	$("#idSeccionContinuarPermanencia").removeClass("Container");
	$("#idSeccionContinuarPermanencia").addClass("Container_None");
	$("#idSeccionBotonRegresarAInicio").removeClass("Container_None")
	$("#idSeccionBotonRegresarAInicio").addClass("Container");
	

}