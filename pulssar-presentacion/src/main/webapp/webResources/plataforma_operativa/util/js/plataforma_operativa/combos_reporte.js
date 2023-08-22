/**
 * Script que contiene la funcionalidad de los combos de consulta de reportes 
 */

var listaParametros = new Array();
	var listaReportes = new Array;
	
	var idRoles = "";
	
	$(document).ready(function() {
		validarRolesPlataformaOperativa();
		obtenerModulos();
		validaCamposConsulta();
		habilitaLimpiarNomRepo();
		$('#btnConsultaMinerva').attr('disabled', true);
	});

	function validarRolesPlataformaOperativa() {
		var roles = rolesSession;
		console.log(roles);//Para debug
		if (roles != null) {
			if (roles != 'MINERVA_EXPORT') {
				//Se comenta hasta que se definan los roles
				//$("#btnExportarMinerva").remove();
			}
		}
	}

	function obtenerModulos() {
		var areas = areasSession;
		idRoles = idRolesSession;
		url = context + "/private/plataforma-operativa/obtenerModulos?areas="
				+ areas + "&idRoles=" + idRoles;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			dataType : 'json',
			url : url,
			timeout : 100000,
			async : false,
			beforeSend : function() {
				bloquearPantalla();
			},
			success : function(data) {
				if(data && data.datos && data.datos.modulos){
					listaModulos = data.datos.modulos;
					var options = Combos.options(listaModulos, 'idModulo','nombreModulo');
					$("#modulo").html(options);
				}
			},
			error : function(data) {
				MinervaHelperDialogs.mostrarError(data.mensaje);
			},
			complete : function() {
				desBloquearPantalla();
			}
		});
	};

	function cargaProcesos() {
		var idModulo = $('#modulo').val();
		var data = "?idModulo=" + idModulo;
		idRoles = idRolesSession;
		listaModulos;
		url = context + "/private/plataforma-operativa/obtenerReportes"
				+ data + "&idRoles=" + idRoles;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			dataType : 'json',
			url : url,
			timeout : 100000,
			async : false,
			beforeSend : function() {
				bloquearPantalla();
			},
			success : function(data) {
				listaProcesos = data.datos.proceso;
				var options = Combos.options(listaProcesos, 'idProcesoNegocio',
						'nombreProceso');
				$("#proceso").html(options);
			},
			error : function(e) {
				MinervaHelperDialogs.mostrarError(e);
			},
			complete : function() {
				desBloquearPantalla();
			}
		});
	};

	function cargaSubProceso() {
		var idProceso = $('#proceso').val();
		var data = "?idProceso=" + idProceso;
		idRoles = idRolesSession; 
		url = context + "/private/plataforma-operativa/obtenerReportes"
				+ data + "&idRoles=" + idRoles;
				
		console.log("url subpro --->"+url);		
		$.ajax({
			type : "GET",
			contentType : "application/json",
			dataType : 'json',
			url : url,
			timeout : 100000,
			async : false,
			beforeSend : function() {
				bloquearPantalla();
			},
			success : function(data) {
				listaSubprocesos = data.datos.subproceso;
				var options = Combos.options(listaSubprocesos, 'idSubProceso',
						'nombreSubProceso');
				$("#subProceso").html(options);
				listaTipoReporte = data.datos.tipoReporte;
			},
			error : function(e) {
				MinervaHelperDialogs.mostrarError(e);
			},
			complete : function() {
				desBloquearPantalla();
			}
		});
	};

	function cargaNombresReportes() {
		var idSubProceso = $("#subProceso").val();
		var idTipoConsulta = $("#tipoReporte").val();
		idRoles = idRolesSession;
		var data = "?idSubProceso=" + idSubProceso + "&idTipoConsulta="
				+ idTipoConsulta + "&idRoles=" + idRoles;
		url = context + "/private/plataforma-operativa/obtenerReportes"
				+ data;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			dataType : 'json',
			url : url,
			timeout : 100000,
			async : false,
			beforeSend : function() {
				bloquearPantalla();
			},
			success : function(data) {
				listaReportes = data.datos.reporteCompleto;
				var options = Combos.optionsReporteCompuesto(listaReportes,
						'idReporteGenerico', 'nombreReporte');
				/*  listaParametros = data.datos.reporteCompleto[0].listaParametros;
				 cargarFormularioDinamico(listaParametros); */
				listaNombreReporte = data.datos.reporteGenerico;
				//var options = Combos.options(listaNombreReporte, 'idReporteGenerico', 'nombreReporte');
				$("#nombreReporte").html(options);
			},
			error : function(e) {
				MinervaHelperDialogs.mostrarError(e);
			},
			complete : function() {
				desBloquearPantalla();
			}
		});
	};

	function consultarReporte() {
		var fechaInicial = $('#fechaInicial').val();
		var fechaFinal = $('#fechaFinal').val();

		if (validaCamposConsulta()) {

			if (siteDias(fechaFinal, fechaInicial) <= diasPermitidos) {
				var nombreReporte = $('#nombreReporte').val();
				var nss = $('#textAreaNssMinerva').val().replace(/\n/gi, ",");
				var curp = $('#textAreaCurpMinerva').val().replace(/\n/gi, ",")
				var idProc = $('#textAreaIdProMinerva').val().replace(/\n/gi,
						"");
				var data = "?fechaInicial=" + fechaInicial + "&fechaFinal="
						+ fechaFinal + "&nombreReporte=" + nombreReporte
						+ "&nss=" + nss + "&curp=" + curp + "&idProcesar="
						+ idProc;
				url = context + "/private/plataforma-operativa/consultaReporte"
						+ data;
				$.ajax({
					type : "GET",
					contentType : "application/json",
					dataType : 'json',
					url : url,
					timeout : 100000,
					async : false,
					beforeSend : function() {
						bloquearPantalla();
					},
					success : function(data) {
						if (data.exito == 1) {
							$.jgrid.gridUnload("tabResultadoCons");
							$('#btnExportarMinerva').show();
							$('#btnExportarMinerva').attr('disabled', false);
							$("#btnExportarPdfMinerva").hide();
							ocultaDivMinervaFechas();
							objetoResultado = data.datos;
							$('#nomReporte').text(data.datos.nombreReporte);
							muestraTablaResultados(objetoResultado);
							$('#idDivTblResul').show();
							$('#textAreaIdProMinerva').val("");
							$('#textAreaNssMinerva').val("");
							$('#textAreaCurpMinerva').val("");
							validaCamposConsulta();
						} else {
							MinervaHelperDialogs
									.mostrarInformacion(data.mensaje);
							$('#textAreaIdProMinerva').val("");
							$('#textAreaNssMinerva').val("");
							$('#textAreaCurpMinerva').val("");
							$('#datetimepicker1').data("DateTimePicker")
									.clear();
							$('#datetimepicker2').data("DateTimePicker")
									.clear();
							validaCamposConsulta();
						}
					},
					error : function(e) {
						if (sessionHaFinalizado(e.responseText)) {
							redirigirLogin();
						} else {
							MinervaHelperDialogs.mostrarError(e);
						}
					},
					complete : function() {
						desBloquearPantalla();
					}
				});
			} else {
				MinervaHelperDialogs
						.mostrarInformacion("El rango de fechas no debe exceder de 7 días.");
				$('#fechaInicial').val("");
				$('#fechaFinal').val("");
				$('#btnConsultaMinerva').attr('disabled', true);
			}
		} else {
			MinervaHelperDialogs
					.mostrarInformacion("Debe llenar los datos requeridos.");
		}
	};

	function exportaResultadoProt() {
		console.log('Exportando reporte...');
		$('#btnExportarMinerva').attr('disabled', true);
		var urlDownload = context + "/private/plataforma-operativa/descargaReporte";
		exportaGenerico(urlDownload);
	}

	function exportaResultadoPlantillaDummy() {

		var nombreReporte = $("#nombreReporte").val();
		if (!todosCamposCapturados()) {
			MinervaHelperDialogs
					.mostrarInformacion("Debe llenar todos los campos.");
			return;
		}
		var cadenaParametros = obtenerCadenaParametrosDinamicos();

		var data = "?nombreReporte=" + nombreReporte + "&" + cadenaParametros
		url = context + "/private/plataforma-operativa/consultaReporteJasper"
				+ data;
				$.ajax({
					type : "GET",
					contentType : "application/json",
					dataType : 'json',
					url : url,
					timeout : 100000,
					async : false,
					beforeSend : function() {
						bloquearPantalla();
					},
					success : function(data) {
						var listaResultado = data.datos;
						if (listaResultado && listaResultado.consulta
								&& listaResultado.consulta.length > 0) {
							$.jgrid.gridUnload("tabResultadoCons");
							$('#btnExportarMinerva').hide();

							if (listaResultado.nombreReporteJasper == null
									|| listaResultado.nombreReporteJasper == ""
									|| listaResultado.nombreReporteJasper == "undefined") {
								$("#btnExportarPdfMinerva").hide();
							} else {
								$('#btnExportarPdfMinerva').attr('disabled',
										false);
								$('#btnExportarPdfMinerva').removeClass(
										'disabled');
								$('#btnExportarPdfMinerva').show();
							}

							muestraTablaResultados(listaResultado);
							$('#idDivTblResul').show();
							$("#divFormularioDinamico").hide();
						} else {
							MinervaHelperDialogs
									.mostrarInformacion("No se encontró información para la consulta seleccionada");
						}
					},
					error : function(e) {
						if (sessionHaFinalizado(e.responseText)) {
							redirigirLogin();
						} else {
							MinervaHelperDialogs.mostrarError(e);
						}
					},
					complete : function() {
						desBloquearPantalla();
					}
				});
	};

	function exportaResultadoPlantilla() {
		console.log('Exportando reporte JASPER...');
		var urlDownload = context + "/private/plataforma-operativa/descargaReportePlantilla";
		exportaGenerico(urlDownload);
	}

	/**
	 * Funcion que redirige la aplicacion a la pagina de incio de sesion
	 **/
	function redirigirLogin() {
		var url = "http://" + wincontexto + "ntext.request.contextPath}/login";
		window.location.href = url;
	}