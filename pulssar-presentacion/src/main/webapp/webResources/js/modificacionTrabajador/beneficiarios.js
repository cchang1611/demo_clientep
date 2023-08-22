var tabla;
var objetoEditar;
var cambioEditar;
var curpActualEditar;
$(document).ready(function() {
	var table = $('#tablaBeneficiarios').DataTable({
		"columnDefs": [{
			'targets': 0,
			'orderable': false,
			'searchable': false,
			'className': 'dt-body-center'
		}],
		"select": true,
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
		"order": [],
		"bInfo": false,
		"lengthMenu": [[10, 25, 50], [10, 25, 50]],
		dom: "Bfrtip"
	});
	
	tabla = table;
	
	$('#tablaBeneficiarios tbody').on('click','tr',function(){
		if($(this).hasClass('selected')){
			$(this).removeClass('selected');
		}else{
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});
	
	$('.delete-row').click(function(){
		var index = 0;
		$("#tablaBeneficiarios input:checked").each(function(){
			objetoEditar = $(this).parent().parent().remove();
			index++;
		});
		objetoEditar = undefined;
		if (index == 0) {
			alert("La selecci\u00F3n de al menos un Beneficiario es obligatoria");
			return false;
		}
		
		var numeroExistenteBeneficiarios2 = validaNumeroBeneficiarios();
		if(numeroExistenteBeneficiarios2 < NUMERO_BENEFICIARIOS_PERMITIDOS){
			$("#agregarBeneficiario").removeAttr("style");
		}
		
		if(numeroExistenteBeneficiarios2 == 0){
			$("#divCheckBox").css('display', "block");
		}
	});
	
	$('.edit-row').click(function(){
		var formularioValidoEditarMensaje = $("#actualizaTrabajador").valid();
		if(formularioValidoEditarMensaje){
			var modalJSON = {};
			var index = 0;
			$('#tablaBeneficiarios input:checked').each(function() {
				objetoEditar = $(this).parent().parent().find('td');
				index++;
			});
			if (index == 0) {
				alert("La selecci\u00F3n de al menos un Beneficiario es obligatoria");
				return false;
			}
			$(objetoEditar).each(function(i){
				switch (i) {
					case 1:
						modalJSON.curpDeBeneficiario = $(this).text();
						break;
					case 2:
						modalJSON.nombreDeBeneficiario = $(this).text();
						break;
					case 3:
						modalJSON.apellidoPaternoDeBeneficiario = $(this).text();
						break;
					case 4:
						modalJSON.apellidoMaternoDeBeneficiario = $(this).text();
						break;
					case 5:
						modalJSON.parentescoORelacion = $(this).text();
						break;
					case 6:
						modalJSON.porcentajeDeBeneficiario = $(this).text();
						break;
				}
			});
			cargaModal(modalJSON.curpDeBeneficiario,
					modalJSON.nombreDeBeneficiario, 
					modalJSON.porcentajeDeBeneficiario, 
					modalJSON.apellidoPaternoDeBeneficiario, 
					modalJSON.apellidoMaternoDeBeneficiario, 
					modalJSON.parentescoORelacion);
			curpActualEditar = 	$('#curpBeneficiarioModal').val();
			cambioEditar = true;
			showModal();
			valorElimina = val;
		}else{
			if(TIPOSOLICITANTE != '01' && AFORE != '568'){
				muestraModalValidacion("Beneficiarios", "Verifica que los datos Certificables, No Certificables,Complementarios y Solicitante se encuentren requisitados completamente");
			}else{
				muestraModalValidacion("Beneficiarios", "Verifica que los datos Certificables, No Certificables y Complementarios se encuentren requisitados completamente");
			}
			return false;
		}
	});
	
	$(".add-row").click(function(){
		console.log("iniciando agrega nuevo beneficiario");
		var formularioValidoNuevoMensaje = $("#actualizaTrabajador").valid();
		if(formularioValidoNuevoMensaje){
			banderaEdita = false;
			cambioEditar = false;
			showModal();
		}else{
			if(TIPOSOLICITANTE != '01' && AFORE != '568'){
				muestraModalValidacion("Beneficiarios", "Verifica que los datos Certificables, No Certificables,Complementarios y Solicitante se encuentren requisitados completamente");
			}else{
				muestraModalValidacion("Beneficiarios", "Verifica que los datos Certificables, No Certificables y Complementarios se encuentren requisitados completamente");
			}
			return false;
		}

	});
	
	
	
});

function showModal(){
	document.getElementById('agregaBeneficiario').style.display = 'block';
	datosBeneficiariosReglas();
}

function cerrarModal(){
	document.getElementById('agregaBeneficiario').style.display = 'none';
	datosBeneficiariosReglasRemove();
}

function guardaBeneficiario(){
	if(objetoEditar != undefined){
		rellenaDatosBeneficiario();
	}
	
	var mensajeRenapo = $('#mensajeRenapo').text();
	
	if(mensajeRenapo == null || mensajeRenapo == ""){
		console.log("inciando proceso de guardado de beneficiario");
		var curpBen = $('#curpBeneficiarioModal').val();
		if(curpBen != "" && curpBen != null){
			curpBen = curpBen.toUpperCase();
		}
		var nombreBen = $('#nombreBenModal').val();
		if(nombreBen != "" && nombreBen != null){
			nombreBen = nombreBen.toUpperCase();
		}
		var porcentaje = $('#porcentajeModal').val();
		var paterno = $('#paternoBenModal').val();
		if(paterno != "" && paterno != null){
			paterno = paterno.toUpperCase();
		}
		var materno = $('#maternoBenModal').val();
		if(materno != "" && materno != null){
			materno = materno.toUpperCase();
		}
		var parentesco = $('#parentescoBen').val();
		var descripcionParentesco = "";
		var idParentesco = null;
		if(parentesco != null && parentesco != ""){
			var parentescoCompleto = parentesco.split('|');
			 descripcionParentesco = parentescoCompleto[1];
			 idParentesco = parentescoCompleto[0];
		}
		
		$("#actualizaTrabajador").validate().element("#curpBeneficiarioModal");
		$("#actualizaTrabajador").validate().element("#nombreBenModal");
		$("#actualizaTrabajador").validate().element("#porcentajeModal");
		$("#actualizaTrabajador").validate().element("#paternoBenModal");
		$("#actualizaTrabajador").validate().element("#maternoBenModal");
		$("#actualizaTrabajador").validate().element("#parentescoBen");
		var formularioValido = $("#actualizaTrabajador").valid();
		console.log("respuesta formulario validado ", formularioValido);
		console.log("respuesta objeto editar ", objetoEditar);
		if(objetoEditar == undefined && formularioValido) {
			var markup = "";
			markup += "<tr>";
			markup +="<td><input type='checkbox' name='micheckbox' value='"+curpBen+"' /></td>";
			markup +="<td>"+curpBen+"</td>";
			markup +="<td>"+nombreBen+"</td>";
			markup +="<td>"+paterno+"</td>";
			markup +="<td>"+materno+"</td>";
			markup +="<td>"+descripcionParentesco+"</td>";
			markup +="<td>"+porcentaje+"</td>";
			if(idParentesco == null){
				markup +="<td style='display: none'><input id='"+curpBen+"' type='text' value=''/></td>";
	
			}else{
				markup +="<td style='display: none'><input id='"+curpBen+"' type='text' value='"+idParentesco+"'/></td>";
			}
			markup +="</tr>";
			$("#tablaBeneficiarios tbody").find('.dataTables_empty').parent().remove();
			$("#tablaBeneficiarios tbody").append(markup);
		} else if(formularioValido) {
			console.log("continuando proceso de guardado");
			objetoEditar.each(function(i){
				switch (i) {
					case 1:
						$(this).text(curpBen);
						break;
					case 2:
						$(this).text(nombreBen);
						break;
					case 3:
						$(this).text(paterno);
						break;
					case 4:
						$(this).text(materno);
						break;
					case 5:
						$(this).text(descripcionParentesco);
						break;
					case 6:
						$(this).text(porcentaje);
						break;
					case 7:
						cambiarValorParentesco();
						break;
				}
			});
		}
		if(formularioValido) {
			if(objetoEditar == undefined){			
				$("#checkSinDesiganrBeneficiarios").prop("checked", false);
				$("#divCheckBox").css('display', "none");
			}
			console.log("iniciando proceso de cerrado");
			cerrarModal();
			limpiaModal();
		}
		
		var numeroExistenteBeneficiarios2 = validaNumeroBeneficiarios();
		if(numeroExistenteBeneficiarios2 == NUMERO_BENEFICIARIOS_PERMITIDOS){
			$("#agregarBeneficiario").css("display", "none");
		}
	
	}
	
}

function limpiaModal(){
	$('#curpBeneficiarioModal').val("");
	$('#nombreBenModal').val("");
	$('#porcentajeModal').val("");
	$('#paternoBenModal').val("");
	$('#maternoBenModal').val("");
	$('#parentescoBen').val("");
	objetoEditar = undefined;
}

function cargaModal(curp,nombre, porcentaje, paterno, materno, parentesco){
	$('#curpBeneficiarioModal').val(curp);
	$('#nombreBenModal').val(nombre);
	$('#porcentajeModal').val(porcentaje);
	$('#paternoBenModal').val(paterno);
	$('#maternoBenModal').val(materno);
	if(parentesco != null && parentesco != ""){
		$('#parentescoBen option:contains(' + parentesco + ')').attr('selected', true);
	}else{
		$('#parentescoBen').val("").prop('selected', true);
	}
}

function cambiarValorParentesco(){
	var curpBen = $('#curpBeneficiarioModal').val();
	if(cambioEditar == true){
		document.getElementById(curpBen).innerHTML = "";
		
		var parentesco = $('#parentescoBen').val();
		var descripcionParentesco = "";
		var idParentesco = null;
		if(parentesco != null && parentesco != ""){
			var parentescoCompleto = parentesco.split('|');
			 descripcionParentesco = parentescoCompleto[1];
			 idParentesco = parentescoCompleto[0];
		}
		
		if(idParentesco == null){
			document.getElementById(curpBen).innerHTML ="<td style='display: none'><input id='"+curpBen+"' type='text' value=''/></td>";

		}else{
			document.getElementById(curpBen).innerHTML ="<td style='display: none'><input id='"+curpBen+"' type='text' value='"+idParentesco+"'/></td>";
		}
	}

}

function buscarCurpRenapo(curpBeneficiario){
	var resultadoRenapo;
	try{
	$.ajax({
		type:"GET",
		url : "validaCurpRenapo.do",
		timeout : 100000,
		async : false,
		contentType : "application/json",
		data : {curpBeneficiario : curpBeneficiario},
		success : function(data){
			resultadoRenapo = data;
		}
	});
	}catch (e) {
		$('#mensajeRenapo').append("LA CURP "+ curpBeneficiario +" NO ESTÁ ESCRITA CORRECTAMENTE. VUELVA A INTENTAR O CONSULTE EN RENAPO.");
	}
	
	return resultadoRenapo;
}


function rellenaDatosBeneficiario(){
	$('#mensajeRenapo').empty();

	var curpBeneficiario = $('#curpBeneficiarioModal').val();
	curpBeneficiario = curpBeneficiario.toUpperCase();
	var resultadoCurp;
	var formatoCurp = new RegExp(/^([a-z|A-Z]{4})([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1]))([a-z|A-Z]{6})([0-9A-Z]{1})([0-9]{1})$/i);
	if(curpBeneficiario.length == 18){
		if(formatoCurp.test(curpBeneficiario)){
			$('#nombreBenModal').val("");
			$('#paternoBenModal').val("");
			$('#maternoBenModal').val("");
			resultadoCurp = buscarCurpRenapo(curpBeneficiario);
			if(resultadoCurp != null){
				if(resultadoCurp.curp != "" && resultadoCurp.curp != null && resultadoCurp.nombre != "" && resultadoCurp.nombre != null){
					$('#nombreBenModal').val(resultadoCurp.nombre);
					$('#paternoBenModal').val(resultadoCurp.apellidoPaterno);
					if(resultadoCurp.apellidoMaterno != null){
						$('#maternoBenModal').val(resultadoCurp.apellidoMaterno);
					}
					
					if(objetoEditar != undefined){
						var inputBeneficiario = document.getElementById(curpActualEditar);
						inputBeneficiario.setAttribute("id", curpBeneficiario);
						curpActualEditar = curpBeneficiario;
					}
				}else{
					$('#mensajeRenapo').append("LA CURP "+ curpBeneficiario +" NO ESTÁ ESCRITA CORRECTAMENTE. VUELVA A INTENTAR O CONSULTE EN RENAPO.");
				}
			}else{
				$('#mensajeRenapo').append("LA CURP "+ curpBeneficiario +" NO ESTÁ ESCRITA CORRECTAMENTE. VUELVA A INTENTAR O CONSULTE EN RENAPO.");
			}
		}
	}
	
}



function muestraModalValidacion(titulo, mensaje){
	window.location.href = "#";
	var tituloModal = "<h2 class='ModalTitle' >"+titulo+"</h2><a href='#' class='ModalButton' id='btnActExp'>X</a>";
	var mensajeModal = mensaje;
	$('#tituloActExp').empty();
	$('#mensajeActExp').empty();
	$('#tituloActExp').append(tituloModal);
	$('#mensajeActExp').append(mensajeModal);
	window.location.href = "#modalActExp";
}
