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
	
	$('#tablaFolios').dataTable({
		"rowCallback":function(row, data, index){
			if(index % 2 == 0){
				$(row).removeClass("odd");
				$(row).addClass("Row1");
			}else{
				$(row).removeClass("even");
				$(row).addClass("Row2");
			}
			console.log(data[0]);
			if(data[0] == 0){
				$('td:eq(0)', row).html('CERRADO');
				$('td:eq(0)', row).addClass('Linkretaso');
			}else if(data[0] == 1){
				$('td:eq(0)', row).html('EN PROCESO');
				$('td:eq(0)', row).addClass('Linkproceso');
			}else if(data[0] == 2){
				$('td:eq(0)', row).html('CANCELADO');
				$('td:eq(0)', row).addClass('Linkretaso');
			}else if(data[0] == 3){
				$('td:eq(0)', row).html('TERMINADO');
				$('td:eq(0)', row).addClass('Linkconcluido');
			} else {
				$('td:eq(0)', row).html('TERMINADO');
				$('td:eq(0)', row).addClass('Linkconcluido');
			}
		},"lengthMenu": [[10, 25, 50], [10, 25, 50]],
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
		}
	});
});

function filterColum(i, dato) {
	$('#tablaFolios').DataTable().column(Number(i)).search(dato, false, true).draw();
}
