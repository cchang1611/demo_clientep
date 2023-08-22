$(document).ready(function() {
	$("#nombArchivo").attr("readonly","readonly");
	document.getElementById('plataformaResultadoMensaje').innerHTML = _MENSAJE;
	if(respuestas == "" || respuestas == null){
		$("#exportarExcel").removeAttr('onclick');
		$("#exportarExcel").addClass('disabled_Url');
	}else{
		$("#exportarExcel").attr('onclick', 'generarNombreExcel()');
		$("#exportarExcel").removeClass('disabled_Url');
	}
	
	var table = $('#tablaConsulta').DataTable({
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
	
	$("#sFiltro").on('change',function(){
		var filtro = $("#sFiltro").val();
		if(filtro == '') {
			$('#tablaConsulta').DataTable().columns().search( '' ).draw();
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
	
});


function filterColum(i, dato) {
	$('#tablaConsulta').DataTable().columns().search( '' ).draw();
	$('#tablaConsulta').DataTable().column(Number(i)).search(dato, false, true).draw();
	/*var table = document.getElementById("tablaConsulta");
	var tr = table.getElementsByTagName("tr");
	for(j = 0; j < tr.length; j++){
		var td = tr[j].getElementsByTagName("td");
		
		for(k = 0; k < td.length; k++){
			var tdElement = td.item(j);
			var idTd = tdElement.getAttribute("id");
			
			if(i == 0 && idTd == 'celda1' && valorCelda1 && td[k] == 0){
				if(td[k] && td[k].innerText.toUpperCase().indexOf(dato) > -1){
					tr[j].style.display = "";
				}else{
					 tr[j].style.display = "none";
				}
				
			}else if(i == 1 && idTd == 'celda2' && td[k] == 1){
				if(td[k] && td[k].innerText.toUpperCase().indexOf(dato) > -1){
					tr[j].style.display = "";
				}else{
					 tr[j].style.display = "none";
				}
			}else if(i == 2 && idTd == 'celda3'){
				$('#tablaConsulta').DataTable().column(Number(i)).search(dato, false, true).draw();
			}else if(i == 3 && idTd == 'celda4'){
				$('#tablaConsulta').DataTable().column(Number(i)).search(dato, false, true).draw();
			}else if(i == 4 &&  idTd == 'celda5'){
				$('#tablaConsulta').DataTable().column(Number(i)).search(dato, false, true).draw();
			}else {
				$('#tablaConsulta').DataTable().column(Number(i)).search(dato, false, true).draw();
			}
		}
		
	}*/
}



function generarNombreExcel() {
	$.ajax({
		method      : "GET",
		url         : "generarNombreExcel.do",
		contentType : "application/json"
	})
	.success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			$("#nombArchivo").val(data.datos);
			window.location.href = "#miModalResultadoPlataforma";
			  $("#miModalResultadoPlataforma").show();
		}	
	});
	
}	
	
function cerrarModalExcel() {
	$("#miModalResultadoPlataforma").hide();
}	

