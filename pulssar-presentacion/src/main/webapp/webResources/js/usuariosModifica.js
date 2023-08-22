$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2") {
		window.location.href = "#errorModal";
	}
	
	var table = $('#tablaModifica').DataTable({
		"select": {
			 'style': 'multi'
		},
		"language" : {
			"decimal": "",
			"emptyTable": "No hay información",
			"info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
			"infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
			"infoFiltered": "(Filtrado de _MAX_ total entradas)",
			"infoPostFix": "",
			"thousands": ",",
			"lengthMenu": "Mostrar _MENU_ ",
			"loadingRecords": "Cargando...",
			"processing": "Procesando...",
			"search": "Buscar:",
			"zeroRecords": "Sin resultados encontrados",
			"paginate": {
				"first": "Primero",
				"last": "Ultimo",
				"next": "Siguiente",
				"previous": "Anterior"
			}
		},
		"bInfo": false,
		"order": [],
		"lengthMenu": [[10, 25, 50], [10, 25, 50]]
	});
	
	$('#tablaModifica tbody').on('click', 'tr', function () {
		$('#tablaModifica').attr("disabled", "true");
		var data = table.row( this ).data();
		$("#iTexto").val(data[0]);
		var $form = $(this).parents("#fm_modifica");
		$form.submit();
	});
	
	$("#sFiltro").on('change',function(){
		var filtro = $("#sFiltro").val();
		if(filtro == '') {
			$('#tablaModifica').DataTable().columns().search( '' ).draw();
			$("#dSearch").val('');
			$("#dSearch").attr("disabled", "true");
			$("#btnBuscar").attr("disabled", "true");
		} else {
			$("#dSearch").removeAttr("disabled");
			$("#btnBuscar").removeAttr("disabled");
		}
	});
	
	$('#btnBuscar').click(function(){
		var columna = $("#sFiltro").val();
		var dBusqueda = $("#dSearch").val();
		if(dBusqueda != '') {
			$('#dSearch').removeClass("Invalid_data");
			filterColum(columna, dBusqueda);
		} else {
			$('#dSearch').addClass("Invalid_data");
		}
	});
	
	$("#claveAfore").on('change',function(){
		$('#tablaModifica').DataTable().clear().draw();
		var clave = '';
		if($("#claveAfore").length > 0) {
			clave = $("#claveAfore").val();
		}
		
		$.ajax({
			method		: "GET",
			url			: "modificaAfore.do",
			contentType : "application/json",
			data        : {cvAfore : clave},
			success 	: function(data) {
				var listaTam = data.length;
				if(listaTam != 0) {
					for(var i = 0; i < listaTam; i++) {
						var objetoRespuesta = data[i];
						table = $('#tablaModifica').DataTable().row.add( [objetoRespuesta.usuario,
						                                        objetoRespuesta.nombre,
						                                        objetoRespuesta.apellidoPaterno,
						                                        objetoRespuesta.apellidoMaterno,
						                                        objetoRespuesta.email,
						                                        objetoRespuesta.celular,
						                                        objetoRespuesta.descripcionRol
						]).draw();
					}
				}
			}
		})
	});
});

function filterColum(i, dato) {
	$('#tablaModifica').DataTable().column(Number(i)).search(dato, false, true).draw();
}