$(document).ready(function() {
	$("#porcentajeTotal").text("$0");
	tablaBenPaginacion();

});

function tablaBenPaginacion(){
	
	 
	 var table = $('#tablaBeneficiarios').DataTable({
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
			"lengthMenu": [[4, 16, 24, 50], [4, 16, 24, 50]]
		});
}

function validarBeneficiarios(){
	 $("#spanPorcentaje").hide();
	$("#spanObligatoriosBen").hide();
	$("#spanPorcentaje").hide();
	$("#spanCurpBen").hide();
	$("#spanRfcBen").hide();
	$("#spanCuentaClabe").hide();
	$("#spanNombres").hide();
	$("#spanCuentaClabeBanco").hide();
	var porcentaje = document.getElementById("porcentaje").value;
	var curpBeneficiario = document.getElementById("curpBeneficiario").value;
	var nombre = document.getElementById("nombre").value;
	var apellidoPaterno = document.getElementById("apellidoPaterno").value;
	var apellidoMaterno = document.getElementById("apellidoMaterno").value;
	var rfc = document.getElementById("rfcBeneficiario").value;
	var cuentaClabe = document.getElementById("cuentaClabe").value;
	var comboBanco = document.getElementById("banco");
	var claveBanco = document.getElementById("banco").value;
	 
	 
	 if(porcentaje == '' || curpBeneficiario == '' || nombre == '' || apellidoPaterno == '' || apellidoMaterno == '' || claveBanco == "0" || cuentaClabe == ''){
		 $("#spanObligatoriosBen").show();
			return
	 }else{
		 if(curpBeneficiario.length != 18 || !curpBeneficiario.match(/^([a-z|A-Z]{4})([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1]))([a-z|A-Z]{6})([0-9A-Z]{1})([0-9]{1})$/i)){
				$("#spanCurpBen").show();
				$("#curpBeneficiario").val("");
				return
			}else{
				if(rfc != ""){
			    	 if(!rfc.match(/^[A-Z,Ñ,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?$/i)){
			    	 		$("#spanRfcBen").show();
			    	 		$("#rfcBeneficiario").val("");
			    	 		return
			    	 	}else{
			    	 		validarCuentaClabe();
			    	 	}
			     }else{
			    	 if(Number(porcentaje) > 100){
						 $("#spanPorcentaje").show();
						 $("#aceptarIssste").addClass('disabled_Url');
						 return
			    		 
			    	 }else{
			    		 var valorPorcentajeTotal = $("#porcentajeTotal").text();
			    		 valorPorcentajeTotal = valorPorcentajeTotal.replace("$","");
			    		 if(Number(valorPorcentajeTotal)>100){
			    			 $("#spanPorcentaje").show();
							 $("#aceptarIssste").addClass('disabled_Url');
							 return
			    		 }else{
			    			 var valorPorcentajeTotal = $("#porcentajeTotal").text();
				    		 valorPorcentajeTotal = valorPorcentajeTotal.replace("$","");
				    		 var suma = Number(valorPorcentajeTotal)+Number(porcentaje);
			    			 if(Number(suma)>100){
				    			 $("#spanPorcentaje").show();
								 $("#aceptarIssste").addClass('disabled_Url');
								 return
				    		 }else{
				    			 validarCuentaClabe();
				    		 }
			    		 }
			    		 
			    	 }
			    	
			     }
			     
			}
		    
		     
		     
	 }
	 
	
    
			
}

function soloNumeros(e, input){
	var key = window.Event ? e.which : e.keyCode;
	var chark = String.fromCharCode(key);
	var tempValue = input.value+chark;
	
	return ((key >= 48 && key <= 57) || (key==8))
}



function soloNumerosPrctj(e, input){
	var val = input.value.replace(/[^A-Z\d\s]/gi,'');
	
	console.log('val '+ val);
	console.log('isNaN(val)'+(isNaN(val)));
	console.log('val '+ val);
	if(isNaN(val)){
		$('#porcentaje').val('');
	}else{
		if(val>100){
			$('#porcentaje').val(100);
		}
	}
}



function soloLetras(e){
	var key =  e.which || e.keyCode;
	var chark = String.fromCharCode(key).toString();
	var letras = " ñÑáéíóúÁÉÍÓÚäëïöüÄËÏÖÜabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var especiales = [8, 37, 39, 46, 6];
	
	var tecla_especial = false;
	
	for(var i in especiales){
		if(key == especiales[i]){
			tecla_especial = true;
			break;
		}
	}
	
	if(letras.indexOf(chark) == -1 && !tecla_especial){
		return false;
	}
}


function agregarValoresTablaBen(){
	var tableBen = '';
	var porcentaje = document.getElementById("porcentaje").value;
	var curpBeneficiario = document.getElementById("curpBeneficiario").value.toUpperCase();
	var nombre = document.getElementById("nombre").value.toUpperCase();
	var apellidoPaterno = document.getElementById("apellidoPaterno").value.toUpperCase();
	var apellidoMaterno = document.getElementById("apellidoMaterno").value.toUpperCase();
	var rfc = document.getElementById("rfcBeneficiario").value.toUpperCase();
	var cuentaClabe = document.getElementById("cuentaClabe").value;
	var comboBanco = document.getElementById("banco");
	var descripcionBanco = comboBanco.options[comboBanco.selectedIndex].text.toUpperCase();
	var claveBanco = document.getElementById("banco").value;
	
	
	var table = $("#tablaBeneficiarios").DataTable();
	var total = table.rows().count();
	var idChe= document.getElementById("idCheck").value;
	if(total == 0){
		$("#idCheck").val("1");
	}else{
		if(idChe == ""){
			$("#idCheck").val("1");
		}else{
			idChe= document.getElementById("idCheck").value;
			var nuevoChe = Number(idChe)+1;
			$("#idCheck").val(nuevoChe.toString());
		}
	}
	
	 if(porcentaje != '' && curpBeneficiario != '' && nombre != '' && apellidoPaterno != '' && apellidoMaterno != '' && claveBanco != "0" && cuentaClabe != ''){
		 var tablaBe = $('#tablaBeneficiarios').DataTable();
		 tablaBe.row.add([curpBeneficiario, nombre, apellidoPaterno, apellidoMaterno, rfc, porcentaje, descripcionBanco, cuentaClabe, '<p class="Link_blue" href="#"><a  onclick="eliminarFilaBen(this)"><img  style="width:30px;" src="../webResources/img/error.png" alt="icon_eliminar"/></a></p>','<input type="checkbox" name="checkbox" id="ulCheckBox" value="" class="LabelText" onclick="habilitarEliminar(this)">']).node().id='rowChec'+document.getElementById("idCheck").value;
			 tablaBe.draw(false);
	 } 
	
}



function eliminarFilaBen(el){
	 var index = $(el).parent().parent();
	 var table = $("#tablaBeneficiarios").dataTable();
	 table.fnDeleteRow(index);
	 sumaTotalPorcentaje();
}


function marcar(source){
	
	var table = $("#tablaBeneficiarios").DataTable();
	var total = table.rows().count();
	if(total > 0){
	for(var i=0;i<total;i++){
			table.cell(i, 9).nodes().to$().find('input[type="checkbox"]').prop('checked', source.checked);
	}
	
	
	 var valoresCheck = $("input[type=checkbox]:checked").map(function() {
			return this.value;
		}).get();
	 
	 if(valoresCheck.length == 0) {
		 $("#elimBen").addClass('disabled_Url');
	 }else{
		 $("#elimBen").removeClass('disabled_Url');
	 }
 }else{
	 $("#chboxAll").prop("checked", false);
 }	
}


function eliminarRegChecksSele(){
	var table = $("#tablaBeneficiarios").DataTable();
	var idRows = [];

	var rows = $("#tablaBeneficiarios").dataTable().fnGetNodes();
	for(var i=0; i<rows.length;i++){
		if($(rows[i]).find('input[type="checkbox"]').prop('checked')){
			idRows.push(rows[i].attributes.id.value);
		}
	}
	console.log(idRows);
	for(var j=0; j<idRows.length;j++){
		table.row('#'+idRows[j]).remove().draw();
	}
	
	$("#elimBen").addClass('disabled_Url');
	
	$("#chboxAll").prop("checked", false);
	sumaTotalPorcentaje();
	
}


function habilitarEliminar(source){
	 var valoresCheck = $("input[type=checkbox]:checked").map(function() {
			return this.value;
		}).get();
	 if(valoresCheck.length == 0) {
		 $("#elimBen").addClass('disabled_Url');
	 }else{
		 $("#elimBen").removeClass('disabled_Url');
	 }
	
}

function sumaTotalPorcentaje(){
	 $("#agregarBen").removeClass('disabled_Url');
	 $("#spanPorcentaje").hide();
	var tabla = $("#tablaBeneficiarios").DataTable();
	var total = tabla.rows().count();
	var cell = [];
	if(total > 0){
		 $("#aceptarIssste").removeClass('disabled_Url');
		for(var i=0;i<total;i++){
			cell.push(tabla.cell(i, 5).data());
		}
		
		console.log(cell);
		var sumaTotal=0;
		for(var j=0;j<cell.length;j++){
			sumaTotal +=parseFloat(cell[j]);
		}
		
			var sumT = sumaTotal.toString();
			$("#porcentajeTotal").text("$"+sumT);
			console.log(sumT);
			if(Number(porcentaje) < 1 || Number(sumaTotal) > 100){
				 $("#spanPorcentaje").show();
				 $("#aceptarIssste").addClass('disabled_Url');
				 $("#agregarBen").addClass('disabled_Url');
		}
		
	}else{
		$("#porcentajeTotal").text("$0");
		 $("#aceptarIssste").addClass('disabled_Url');
	}
}


function validarCuentaClabe(){
	$.ajax({
		method   :"GET",
		url      :"validarDigitoVerificador.do?clabe="+$("#cuentaClabe").val(),
		contentType:"application/json"
		})
		.success(function(data) {
			if(data.resultadoDeLaOperacion=="01"){
				console.log(data.diagnosticoDeRecepcion);
				$("#spanCuentaClabe").hide();
				 validarClabeBanco(); 
			}else{
				 $("#cuentaClabe").val("");
				 $("#spanCuentaClabe").show();
				 $("#aceptarIssste").addClass('disabled_Url');
			}
		})
		.error(function(data) {
			console.log('ERROR AL VALIDAR EL DIGITO VERIFICADOR');
			$("#mensajeErrorClabe").text(data.diagnosticoDeRecepcion);
				
    	});
}



function validarClabeBanco(){
	var claveBanco = document.getElementById("banco").value;
	var cuentaClabe = document.getElementById("cuentaClabe").value;
	var clabeTresDigitos = cuentaClabe.substring(0,3);
	
	if(claveBanco != clabeTresDigitos){
		$("#cuentaClabe").val("");
		$("#spanCuentaClabeBanco").show();
		return
	}else{
		agregarValoresTablaBen();
	     sumaTotalPorcentaje();
	     ///Limpiar valores
	     $("#porcentaje").val("");
	     $("#curpBeneficiario").val("");
	     $("#nombre").val("");
	     $("#apellidoPaterno").val("");
	     $("#apellidoMaterno").val("");
	     $("#rfcBeneficiario").val("");
	     $("#cuentaClabe").val("");
	     $("#banco").val("0");
	}
	
	
}