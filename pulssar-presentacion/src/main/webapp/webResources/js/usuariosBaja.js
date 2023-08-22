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
	
	var table = $('#tablaBaja').DataTable({
		"columnDefs": [{
			'targets': 0,
			'orderable': false,
			'searchable': false,
			'className': 'dt-body-center',
			'render': function (data, type, full, meta){
	             return '<input type="checkbox" name="chBoxBaja" value="' + $('<div/>').text(full[1]).html() + '">';
	         }
		}],
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
	
	$('#chboxAll').on('click', function(){
		var rows = $('#tablaBaja').rows({ 'search': 'applied' }).nodes();
		$('input[type="checkbox"]', rows).prop('checked', this.checked);
	});
	
	$('#tablaBaja tbody').on('change', 'input[type="checkbox"]', function(){
		if(!this.checked){
			var el = $('#chboxAll').get(0);
			if(el && el.checked && ('indeterminate' in el)){
				el.indeterminate = true;
			}
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
	
	$('#btnBaja').click(function(event) {
		event.preventDefault();
		$("#btnBaja").attr("disabled", "true");
		window.location.href = "#modalLoader";
		
		var $form = $(this).parents("#fm_baja");
		
		var tableCheck = $("input[name=chBoxBaja]:checked").map(function() {
			return this.value;
		}).get();
		
		if(tableCheck.length > 0) {
			$form.submit();
			$("#btnBaja").removeAttr("disabled");
		}
	});
	
	$("#sFiltro").on('change',function(){
		var filtro = $("#sFiltro").val();
		if(filtro == '') {
			$('#tablaBaja').DataTable().columns().search( '' ).draw();
			$("#dSearch").val('');
			$("#dSearch").attr("disabled", "true");
			$("#btnBuscar").attr("disabled", "true");
		} else {
			$("#dSearch").removeAttr("disabled");
			$("#btnBuscar").removeAttr("disabled");
		}
	});
	
	$("#claveAfore").on('change',function(){
		$('#tablaBaja').DataTable().clear().draw();
		var clave = '';
		if($("#claveAfore").length > 0) {
			clave = $("#claveAfore").val();
		}
		
		$.ajax({
			method		: "GET",
			url			: "bajaAfore.do",
			contentType : "application/json",
			data        : {cvAfore : clave},
			success 	: function(data) {
				var listaTam = data.length;
				if(listaTam != 0) {
					for(var i = 0; i < listaTam; i++) {
						var objetoRespuesta = data[i];
						table = $('#tablaBaja').dataTable().fnAddData( [objetoRespuesta.id,
						                                        objetoRespuesta.usuario,
						                                        objetoRespuesta.nombre,
						                                        objetoRespuesta.apellidoPaterno,
						                                        objetoRespuesta.apellidoMaterno,
						                                        objetoRespuesta.email,
						                                        objetoRespuesta.celular
						]);
					}
				}
			}
		})
	});
});

function filterColum(i, dato) {
	$('#tablaBaja').DataTable().column(Number(i)).search(dato, false, true).draw();
}