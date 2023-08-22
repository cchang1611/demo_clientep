$(document).ready(function() {
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
		window.history.pushState(null, "", window.location.href);
	};
	
	if(_FLUJO == "1") {
		$("#claveAfore").val("");
		window.location.href = "#exitoModal";
	} else if(_FLUJO == "2") {
		$("#claveAfore").val("");
		window.location.href = "#errorModal";
	}
	
	var table = $('#tablaAsigna').DataTable({
		"columnDefs": [{
			'targets': 0,
			'orderable': false,
			'searchable': false,
			'className': 'dt-body-center',
			'render': function (data, type, full, meta){
	             return '<input type="checkbox" name="chBoxAsigna" value="' + $('<div/>').text(full[1]).html() + '">';
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
		"order": [],
		"bInfo": false,
		"lengthMenu": [[10, 25, 50], [10, 25, 50]]
	});
	
	$('#chboxAll').on('click', function(){
		var rows = $('#tablaAsigna').rows({ 'search': 'applied' }).nodes();
		$('input[type="checkbox"]', rows).prop('checked', this.checked);
	});
	
	$('#tablaAsigna tbody').on('change', 'input[type="checkbox"]', function(){
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
	
	$("#sFiltro").on('change',function(){
		var filtro = $("#sFiltro").val();
		if(filtro == '') {
			$('#tablaAsigna').DataTable().columns().search( '' ).draw();
			$("#dSearch").val('');
			$("#dSearch").attr("disabled", "true");
			$("#btnBuscar").attr("disabled", "true");
		} else {
			$("#dSearch").removeAttr("disabled");
			$("#btnBuscar").removeAttr("disabled");
		}
	});
	
	$('#btnAsigna').click(function(event) {
		$("#btnAsigna").attr("disabled", "true");
		var $form = $(this).parents("#fm_asignacion");
		event.preventDefault();
		
		var tableCheck = $("input[name=chBoxAsigna]:checked").map(function() {
			return this.value;
		}).get();
		
		var valoresCheck = $("input[name='checkRoles']:checked").map(function() {
			return this.value;
		}).get();
		
		if(valoresCheck.length == 0) {
			$("#ulCheckBox").addClass("Invalid_data");
			if($("#ulCheckBox").parents(".Form__Group").find("label.Labeltexterror").length == 0) {
				$("#ulCheckBox").parents(".Form__Group:first").append("<label class='Labeltexterror'>Selecciona un perfil</label>");
			}
		} else {
			$("#ulCheckBox").removeClass("Invalid_data");
			$("#ulCheckBox").parents(".Form__Group:first").find("label.Labeltexterror").remove();
		}
		
		
		if(tableCheck.length > 0 && $(".Invalid_data").length == 0) {
			$form.submit();
		}else{
			$("#btnAsigna").removeAttr("disabled");
		}
	});
	
	$("#claveAfore").on('change',function(){
		$('#tablaAsigna').DataTable().clear().draw();
		var clave = '';
		if($("#claveAfore").length > 0) {
			clave = $("#claveAfore").val();
		}
		$.ajax({
			method		: "GET",
			url			: "asignaAfore.do",
			contentType : "application/json",
			data        : {cvAfore : clave},
			success 	: function(data) {				
				if(data.flujo == 1) {
					var listaUsuarios= data.mapaRespuesta.listaUsuarios;
					var noUsuarios = listaUsuarios.length;
					if(noUsuarios != 0){
						for(var i = 0; i < noUsuarios; i++) {
							var usuario = listaUsuarios[i];
							table = $('#tablaAsigna').dataTable().fnAddData( [usuario.id,
							                                        usuario.usuario,
							                                        usuario.nombre,
							                                        usuario.apellidoPaterno,
							                                        usuario.apellidoMaterno,
							                                        usuario.email,
							                                        usuario.celular
							]);
						}
					}
					var listaRoles = data.mapaRespuesta.listaRoles;
					var noRoles = listaRoles.length;
					if(noRoles != 0){
						$('#ulCheckRoles').html("");
						for(var j = 0; j < noRoles; j++) {
							var rol = listaRoles[j];
							 $("#ulCheckRoles").append("<li class='Checkbox__Li'><input type='checkbox' name='checkRoles' value='"+rol.clave+"' />"+rol.descripcion+"</li>");
						}
					}
				}				
			}
		})
	});
});

function filterColum(i, dato) {
	$('#tablaAsigna').DataTable().column(Number(i)).search(dato, false, true).draw();
}