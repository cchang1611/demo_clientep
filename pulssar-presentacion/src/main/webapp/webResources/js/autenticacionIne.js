/**
 * Autenticacion por INE
 */

var numeroIntentos = 0;

$(document).ready(function() {
	
			$("#btnFirmarPdfAutenticacioIne").click(function(event) {
				window.location.href = "#modalLoader";
				var solicitanteFiltrado;
				if ("10" == SOLICITANTE) {
					solicitanteFiltrado = SOLICITANTE
				} else {
					solicitanteFiltrado = SOLICITANTE.substr(1);
				}

				if (NSS == null || NSS == "") {
					NSS = "00000000000";
				}
				// iniciarTabletJs(FOLIOPADRE,SERVICIO,AGENTE,AMBIENTE,NSS,CURP,solicitanteFiltrado,'N');
				iniciarTablet(FOLIOPADRE, SERVICIO, NSS, CURP, solicitanteFiltrado, 'N');
				consultaIntervaloImagenes();

			});
});

function consultaIntervaloImagenes() {
	var intervalo = setInterval(function() {
		cosultaRecepcionImagenes(intervalo);
	}, 30000)
}

/**
 * Consulta tabla de PSER_TR_RECEPCION_IMAGENES
 * 
 * @param intervalo
 * @returns
 */
function cosultaRecepcionImagenes(intervalo) {
	numeroIntentos++;
	console.log(numeroIntentos);
	
	$.ajax({
		url : 'consultarRecepcionImagenes.do',
		type : "GET",
		contentType : 'application/json',
		dataType : 'json',
		data : {
			folioPadre : FOLIOPADRE,
			cvProceso : SERVICIO,
			estatus : "1"
		}
	})
	.success(
			function(recepcion) {
				if (recepcion != null) {
					clearInterval(intervalo);
					recuperarFirmas(recepcion);
				} else {
					if (numeroIntentos == Number(INTENTOS)) {
						clearInterval(intervalo);
						window.location.href = "#";
						var tituloModal = "<h2 class='ModalTitle' >Solicitud</h2>";
						var mensajeModal = "Aun no se han encontrado archivos ¿Desea continuar con el tramite?";
						$('#tituloActExp').empty();
						$('#mensajeActExp').empty();
						$('#tituloActExp').append(tituloModal);
						$('#mensajeActExp').append(mensajeModal);
						$('#botonesModalActExp').show();
						window.location.href = "#modalActExp";
					}
				}
			});
}

/**
 * Obtiene los detalles de recepcion de imagenes para recuperar el archivo y
 * leer el base64 del txt
 * 
 * @param recepcion
 * @returns
 */
function recuperarFirmas(recepcion) {
	var data = JSON.stringify({
		idRecepcionImagenes : recepcion.idRecepcionImagenes,
		folioProcesar : recepcion.folioProcesar,
		claveTipoProceso : recepcion.claveTipoProceso,
		numeroTotalDoctos : recepcion.numeroTotalDoctos,
		numeroTotalRecibidos : recepcion.numeroTotalRecibidos,
		fechaRecepcion : recepcion.fechaRecepcion,
		estatus : recepcion.estatus,
		fechaControl : recepcion.fechaControl,
		usuarioModificador : recepcion.usuarioModificador,
		detalleRecepcionImagen : recepcion.detalleRecepcionImagen
	});
	
	$.ajax({
			url : 'recuperarFirmasPdfGenerico.do',
			type : "POST",
			contentType : 'application/json',
			dataType : 'json',
			data : data,
			beforeSend : function() {
				window.location.href = "#modalLoader";
			}
		})
		.success(
				function(respuesta) {
					if (respuesta != null) {
						if (respuesta.mensaje != null) {
							var tituloModal = "<h2 class='ModalTitle' >Solicitud</h2><a href='#' class='ModalButton' id='btnActExp' onclick='redireccionModal()'>X</a>";
							var mensajeModal = "Ha ocurrido un problema al recibir datos de la solicitud";
							$('#tituloActExp').empty();
							$('#mensajeActExp').empty();
							$('#tituloActExp').append(tituloModal);
							$('#mensajeActExp').append(mensajeModal);
							window.location.href = "#modalActExp";
						} else {
							numeroArchivos = respuesta.numeroArchivos;
//							firmaAgente = respuesta.firmaAgente;
							firmaTrabajador = respuesta.firmaTrabajador;
							
							//Mostrar pdf firmado
							//generarPdfSolicitudModificacionDeDatos();
							$("#inputfirma").val(firmaTrabajador)
							$("#formAutenticacionIneFirmarPdf").submit();
							$("#btnSolicitarFirmas").css("display", "none");
							$("#btnContinuar").css("display", "block");

						}
					}
				});
}