$(document).ready(function() {
	
	
	$("#reporteriaTabla").DataTable({
		
		"language" : {
			"decimal": "",
			"emptyTable": "",
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
		"lengthMenu": [[250], [250]]
		
	});
	
	// Define las constantes para el presente js.
	FLUJO_SESION_CADACUDA  = "3";
	FLUJO_ERROR_INESPERADO = "4";
	
	if(_FLUJO == FLUJO_SESION_CADACUDA) {
		window.location.href = "#sesionCaduacadaModal";
	};
	
	$("#submitConfirmacionSesionCaducada").click(function(event) {
		window.location = '/pulssar/public/finalizaSesion.do';
	});
	

	
	
});

