$(document).ready(function() {
	$("#spanCuentaClabe").hide();
	$("#spanCuentaClabeBanco").hide();
	$("#spanCurpBen").hide();
	$("#cuentaClabeBen").attr("disabled","disabled");
	$("#spanPorcentaje").hide();
	$("#elimBen").addClass('disabled_Url');
	$("#spanObligatoriosBen").hide();
	$("#porcentajeTotal").text("$0");
	$("#spanRfcBen").hide();
	 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
	 $("#btnMostrarModalCaptura").addClass('disabled_Url');
	$("input#curpBen").blur(function(event){
		$("#spanCurpBen").hide();
		$("#spanObligatoriosBen").hide();
		val = document.getElementById("curpBen").value;
		
			 if(document.getElementById("curpBen").value.length != 18 || !document.getElementById("curpBen").value.match(/^([a-z|A-Z]{4})([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1]))([a-z|A-Z]{6})([0-9A-Z]{1})([0-9]{1})$/i)){
					$("#spanCurpBen").show();
					$("#curpBen").val("");
				}else{
					 var valorPorcentajeTotal = $("#porcentajeTotal").text();
		    		 valorPorcentajeTotal = valorPorcentajeTotal.replace("$","");
		    		 var suma = Number(valorPorcentajeTotal)+Number(document.getElementById("porcentajeBen").value);
	    			 if(Number(suma) < 1){
	    				 $("#btnGenerarExpediente").addClass('disabled_Url');
	    			 }
		    		 if(Number(suma)>100){
		    			 $("#spanPorcentaje").show();
		    			 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
		    		 }else{
		    			 if(document.getElementById("curpBen").value == '' || document.getElementById("nombreBen").value == '' || document.getElementById("apPatBen").value == '' || document.getElementById("apMatBen").value == '' || document.getElementById("porcentajeBen").value == '' || document.getElementById("bancoBen").value == "0" || document.getElementById("cuentaClabeBen").value == ''){
		    				 $("#spanObligatoriosBen").show();
		    				 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
		    			 }else{
		    				 $("#spanObligatoriosBen").hide();
		    			 $("#btnAdicionarBeneficiario").removeClass('disabled_Url');
		    		 }
				}	
		 }
			
		 // }
	});
	
	$("input#nombreBen").blur(function(event){
		$("#spanObligatoriosBen").hide();
		val = document.getElementById("nombreBen").value;
		if(document.getElementById("curpBen").value == '' || document.getElementById("nombreBen").value == '' || document.getElementById("apPatBen").value == '' || document.getElementById("apMatBen").value == '' || document.getElementById("porcentajeBen").value == '' || document.getElementById("bancoBen").value == "0" || document.getElementById("cuentaClabeBen").value == ''){
			 $("#spanObligatoriosBen").show();
			 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
		 }else{
			 $("#spanObligatoriosBen").hide();
			 var valorPorcentajeTotal = $("#porcentajeTotal").text();
    		 valorPorcentajeTotal = valorPorcentajeTotal.replace("$","");
    		 var suma = Number(valorPorcentajeTotal)+Number(document.getElementById("porcentajeBen").value);
    		 if(Number(suma) < 1){
				 $("#btnGenerarExpediente").addClass('disabled_Url');
			 }
    		 if(Number(suma)>100){
    			 $("#spanPorcentaje").show();
    			 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
    		 }else{
    			 $("#spanObligatoriosBen").hide();
    			 $("#btnAdicionarBeneficiario").removeClass('disabled_Url');
    		 }
		 }
			 
	});
	
	$("input#apPatBen").blur(function(event){
		$("#spanObligatoriosBen").hide();
		val = document.getElementById("apPatBen").value;
		if(document.getElementById("curpBen").value == '' || document.getElementById("nombreBen").value == '' || document.getElementById("apPatBen").value == '' || document.getElementById("apMatBen").value == '' || document.getElementById("porcentajeBen").value == '' || document.getElementById("bancoBen").value == "0" || document.getElementById("cuentaClabeBen").value == ''){
			 $("#spanObligatoriosBen").show();
			 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
		 }else{
			 $("#spanObligatoriosBen").hide();
			 var valorPorcentajeTotal = $("#porcentajeTotal").text();
    		 valorPorcentajeTotal = valorPorcentajeTotal.replace("$","");
    		 var suma = Number(valorPorcentajeTotal)+Number(document.getElementById("porcentajeBen").value);
    		 if(Number(suma) < 1){
				 $("#btnGenerarExpediente").addClass('disabled_Url');
			 }
    		 if(Number(suma)>100){
    			 $("#spanPorcentaje").show();
    			 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
    		 }else{
    			 $("#spanObligatoriosBen").hide();
    			 $("#btnAdicionarBeneficiario").removeClass('disabled_Url');
    		 }
		 }
			
		
	});
	
	$("input#apMatBen").blur(function(event){
		$("#spanObligatoriosBen").hide();
		val = document.getElementById("apMatBen").value;
		if(document.getElementById("curpBen").value == '' || document.getElementById("nombreBen").value == '' || document.getElementById("apPatBen").value == '' || document.getElementById("apMatBen").value == '' || document.getElementById("porcentajeBen").value == '' || document.getElementById("bancoBen").value == "0" || document.getElementById("cuentaClabeBen").value == ''){
			 $("#spanObligatoriosBen").show();
			 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
		 }else{
			 $("#spanObligatoriosBen").hide();
			 var valorPorcentajeTotal = $("#porcentajeTotal").text();
    		 valorPorcentajeTotal = valorPorcentajeTotal.replace("$","");
    		 var suma = Number(valorPorcentajeTotal)+Number(document.getElementById("porcentajeBen").value);
    		 if(Number(suma) < 1){
				 $("#btnGenerarExpediente").addClass('disabled_Url');
			 }
    		 if(Number(suma)>100){
    			 $("#spanPorcentaje").show();
    			 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
    		 }else{
    			 $("#spanObligatoriosBen").hide();
    			 $("#btnAdicionarBeneficiario").removeClass('disabled_Url');
    		 }
			
		  }
	});
	
	$("input#rfcBen").blur(function(event){
		let rfc = document.getElementById("rfcBen").value;
		$("#spanRfcBen").hide();
		var strCorrecta;
		strCorrecta = rfc;	
		
		if(rfc != ''){
			if (rfc.length == 12){
				var valid = '^(([A-Z]|[a-z]){3})([0-9]{6})((([A-Z]|[a-z]|[0-9]){3}))';
				}else{
				var valid = '^(([A-Z]|[a-z]|\s){1})(([A-Z]|[a-z]){3})([0-9]{6})((([A-Z]|[a-z]|[0-9]){3}))';
				}
				var validRfc=new RegExp(valid);
				var matchArray=strCorrecta.match(validRfc);
				if (matchArray==null) {
					$("#spanRfcBen").show();
					$("#btnAdicionarBeneficiario").addClass('disabled_Url');
					document.getElementById("rfcBen").value = "";
				}
				else
				{
					$("#spanRfcBen").hide();
					 var valorPorcentajeTotal = $("#porcentajeTotal").text();
		    		 valorPorcentajeTotal = valorPorcentajeTotal.replace("$","");
		    		 var suma = Number(valorPorcentajeTotal)+Number(document.getElementById("porcentajeBen").value);
		    		 if(Number(suma) < 1){
	    				 $("#btnGenerarExpediente").addClass('disabled_Url');
	    			 }
		    		 if(Number(suma)>100){
		    			 $("#spanPorcentaje").show();
		    			 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
		    		 }else{
						if(document.getElementById("curpBen").value == '' || document.getElementById("nombreBen").value == '' || document.getElementById("apPatBen").value == '' || document.getElementById("apMatBen").value == '' || document.getElementById("porcentajeBen").value == '' || document.getElementById("bancoBen").value == "0" || document.getElementById("cuentaClabeBen").value == ''){
							 $("#spanObligatoriosBen").show();
							 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
						 }else{
							 $("#spanObligatoriosBen").hide();
							 $("#btnAdicionarBeneficiario").removeClass('disabled_Url');
						 }
		    		 }
					
				}
		}
		
	});
	
	
	$("input#porcentajeBen").blur(function(event){
		$("#spanPorcentaje").hide();
		$("#spanObligatoriosBen").hide();
		val = document.getElementById("porcentajeBen").value;
		
			 $("#spanObligatoriosBen").hide();
			 if(Number(document.getElementById("porcentajeBen").value) > 100){
				 $("#spanPorcentaje").show();
				 
			 } else{
				 
				 var valorPorcentajeTotal = $("#porcentajeTotal").text();
	    		 valorPorcentajeTotal = valorPorcentajeTotal.replace("$","");
	    		 var suma = Number(valorPorcentajeTotal)+Number(document.getElementById("porcentajeBen").value);
	    		 if(Number(suma) < 1){
    				 $("#btnGenerarExpediente").addClass('disabled_Url');
    			 }
	    		 if(Number(suma)>100){
	    			 $("#spanPorcentaje").show();
	    			 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
	    		 }else{
	    			 if(document.getElementById("curpBen").value == '' || document.getElementById("nombreBen").value == '' || document.getElementById("apPatBen").value == '' || document.getElementById("apMatBen").value == '' || document.getElementById("porcentajeBen").value == '' || document.getElementById("bancoBen").value == "0" || document.getElementById("cuentaClabeBen").value == ''){
	    				 $("#spanObligatoriosBen").show();
	    				 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
	    			 }else{
	    				 $("#spanObligatoriosBen").hide();
	    				 $("#btnAdicionarBeneficiario").removeClass('disabled_Url');
	    			 }
	    		 }
			 
				 
			 }
	});
	
	
	
	$("input#cuentaClabeBen").blur(function(event){
		val = document.getElementById("cuentaClabeBen").value;
			$("#spanCuentaClabe").hide();
			$("#spanCuentaClabeBanco").hide();
			
				 $.ajax({
						method   :"GET",
						url      :"validarDigitoVerificador.do?clabe="+$("#cuentaClabeBen").val(),
						contentType:"application/json"
						})
						.success(function(data) {
							if(data.resultadoDeLaOperacion=="01"){
								console.log(data.diagnosticoDeRecepcion);
								//Habilita boton
								 validarClabeBanco(); 
							}else{
								$("#spanCuentaClabe").show();
								 $("#cuentaClabeBen").val("");
								 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
							}
						})
						.error(function(data) {
							console.log('ERROR AL VALIDAR EL DIGITO VERIFICADOR');
							$("#mensajeErrorClabe").text(data.diagnosticoDeRecepcion);
								
				    	});
			
	});
	
	
   	$("#btnMostrarModalCaptura").click(function() {
   		console.log("Btn Agregar");
		   	 $.ajax({
					type      : "GET",
				    url       : "validarBeneficiarios.do", 
				contentType	: "application/json",
			}).success(function(data) {
				const $banco = $("#bancoBen");
				$banco.empty();
				$banco.append($("<option>",{
			        value:"0",
			        text:"Seleccione una opción"
			    }));
				for(var i=0; i<data.lstObRespuesta.length; i++){
					$banco.append($("<option>",{
				        value:data.lstObRespuesta[i].chParametro,
				        text:data.lstObRespuesta[i].chValorParametro
				    }));
				}
				window.location.href="#modalAdicionarBeneficiario";
				
				})
			.error(function(data) {
				console.log("Error ");
			  });
	});
   	
   	
   	
   	
	$("#btnAdicionarBeneficiario").click(function() {
		let curpBen   = document.getElementById("curpBen").value;
		let nombreBen = document.getElementById("nombreBen").value;
		let apPatBen  = document.getElementById("apPatBen").value;
		let apMatBen  = document.getElementById("apMatBen").value;
		let rfcBen    = document.getElementById("rfcBen").value;
		let porcentajeBen = document.getElementById("porcentajeBen").value;
		let bancoBen      = document.getElementById("bancoBen").value;
		let ctaClabeBen   = document.getElementById("cuentaClabeBen").value;
		
		let sumaPorcentaje=0;
		let total_col5=0;
		
		let total_col4=0;
		let total_col6=0;
		
		let nFilasNuevo = $("#tablaBeneficiariosImss tr").length;
		
		var y=0; //contador para asignar id al boton que borrara la fila
		
		//Incrementar contador
		var idChe= document.getElementById("idCheck").value;
		if(nFilasNuevo == 1){
			$("#idCheck").val("0");
			var y=0;
		}else{
			if(idChe == ""){
				$("#idCheck").val("0");
				var y=0;
			}else{
				idChe= document.getElementById("idCheck").value;
				var nuevoChe = Number(idChe)+1;
				$("#idCheck").val(nuevoChe.toString());
				var y=Number(idChe)+1;
			}
		}
		idChe= document.getElementById("idCheck").value;
		var claseRow = "";
        if(Number(idChe) % 2 == 0){
        	claseRow = "Row1";
		}else{
			claseRow = "Row2";
		}
		
		var fila = '<tr id="row_' + y + '" class="' + claseRow + '"><td>' + curpBen + '</td><td>' + nombreBen + '</td><td>' + apPatBen + '</td><td>' + apMatBen + '</td><td>' + rfcBen + '</td><td id="tdpor_' + y + '">' + porcentajeBen + ' </td><td>' + bancoBen + '</td><td>' + ctaClabeBen + '</td> <td><button type="button" name="remove" id="' + y + '" class="btn btn-danger btn_remove">Eliminar</button></td><imput type="text" onkeyup="sumarProcentaje(this)" ><td id="check_celda' + y + '"><input type="checkbox" name="checkbox" id="ulCheckBox' + y + '" value="" class="LabelText" onclick="habilitarEliminar(this)"></td> </tr>'; 
		
		$('#tablaBeneficiariosImss tr:first').after(fila);
		$("#adicionados").text(""); //esta instruccion limpia el div adicioandos para que no se vayan acumulando
		
		let nFilas = $("#tablaBeneficiariosImss tr").length;
		//Se le resto 1 para no contar la fila del header
		$("#adicionados").append(nFilas - 1);
		 document.getElementById("curpBen").value ="";
	     document.getElementById("nombreBen").value = "";
	     document.getElementById("apPatBen").value = "";
	     document.getElementById("apMatBen").value ="";
	     document.getElementById("rfcBen").value = "";
	     document.getElementById("porcentajeBen").value = "";
	     document.getElementById("bancoBen").value = "";
	     document.getElementById("cuentaClabeBen").value = "";
	     document.getElementById("cuentaClabeBen").focus();
	    
	     sumaTotalPorcentaje();
	});
	
	$(document).on('click', '.btn_remove', function() {
		  var button_id = $(this).attr("id");
		    //cuando da click obtenemos el id del boton
		    $('#row_' + button_id + '').remove(); //borra la fila
		    //limpia el para que vuelva a contar las filas de la tabla
		    $("#adicionados").text("");
		    var nFilas = $("#tablaBeneficiariosImss tr").length;
		    $("#adicionados").append(nFilas - 1);
		    sumaTotalPorcentaje();
		  });
});


	function eliminarMensaje(fct){
		$("span.error_span").hide();
	}

	function agregarMensajeCurp(fct, mensjae){
		   $("input#curpBen").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function agregarMensajeNombre(fct, mensaje){
		   $("input#curpBen").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	

	function agregarMensajeApPaterno(fct, mensaje){
		   $("input#curpBen").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function agregarMensajeApMaterno(fct, mensaje){
		   $("input#curpBen").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function agregarMensajeApMaterno(fct, mensaje){
		   $("input#curpBen").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function agregarMensajePorcentaje(fct, mensaje){
		   $("input#porcentajeBen").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	
	function agregarMensajeBanco(fct, mensaje){
		   $("input#bancoBen").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function agregarMensajeCuentaClabe(fct, mensaje){
		   $("input#cuentaClabeBen").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}

	function agregarMensajeRfc(fct, mensaje){
		   $("input#rfcBen").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	function ValidaRfc(rfcStr) {
		var strCorrecta;
		strCorrecta = rfcStr;	
		if (rfcStr.length == 12){
		var valid = '^(([A-Z]|[a-z]){3})([0-9]{6})((([A-Z]|[a-z]|[0-9]){3}))';
		}else{
		var valid = '^(([A-Z]|[a-z]|\s){1})(([A-Z]|[a-z]){3})([0-9]{6})((([A-Z]|[a-z]|[0-9]){3}))';
		}
		var validRfc=new RegExp(valid);
		var matchArray=strCorrecta.match(validRfc);
		if (matchArray==null) {
			agregarMensajeRfc(this, "La captura del Rfc  es invalida");
		}
		else
		{
			eliminarMensaje(this);
		}
		
	}
	
	
	function sumarProcentaje(){
		console.log("Funcion sumarProcentaje");
		var tr= ele.parentNode.parentNode;
		console.log("TR:"+tr);
		
		$(tr).each(function(){
		var calculo=$(this).find("td:eq(5)> input").val()+ $(this).find("td:eq(5) > input").val(); 
				console.log("Calulo:"+calculo); 		  	
		});
	}
	
	
	
	function validarClabeBanco(){
		var claveBanco = document.getElementById("bancoBen").value;
		var cuentaClabe = document.getElementById("cuentaClabeBen").value;
		var clabeTresDigitos = cuentaClabe.substring(0,3);
		$("#btnAdicionarBeneficiario").removeClass('disabled_Url');
		if(claveBanco != clabeTresDigitos){
			$("#cuentaClabe").val("");
			$("#spanCuentaClabeBanco").show();
			$("#btnAdicionarBeneficiario").addClass('disabled_Url');
		}else{
			$("#spanCuentaClabeBanco").hide();
			 var valorPorcentajeTotal = $("#porcentajeTotal").text();
    		 valorPorcentajeTotal = valorPorcentajeTotal.replace("$","");
    		 var suma = Number(valorPorcentajeTotal)+Number(document.getElementById("porcentajeBen").value);
			 if(Number(suma)>100){
    			 $("#spanPorcentaje").show();
    			 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
    		 }else{
				if(document.getElementById("curpBen").value == '' || document.getElementById("nombreBen").value == '' || document.getElementById("apPatBen").value == '' || document.getElementById("apMatBen").value == '' || document.getElementById("porcentajeBen").value == '' || document.getElementById("bancoBen").value == "0" || document.getElementById("cuentaClabeBen").value == ''){
					 $("#spanObligatoriosBen").show();
					 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
				 }else{
					 if(document.getElementById("curpBen").value == '' || document.getElementById("nombreBen").value == '' || document.getElementById("apPatBen").value == '' || document.getElementById("apMatBen").value == '' || document.getElementById("porcentajeBen").value == '' || document.getElementById("bancoBen").value == "0" || document.getElementById("cuentaClabeBen").value == ''){
						 $("#spanObligatoriosBen").show();
						 $("#btnAdicionarBeneficiario").addClass('disabled_Url');
					 }else{
						 $("#spanObligatoriosBen").hide();
						 $("#btnAdicionarBeneficiario").removeClass('disabled_Url');
					 }
				 }
    		 }
		}
		
		
	}
	
	
	function habilitarCuentaClabe(){
		 $("#spanObligatoriosBen").hide();
		var claveBanco = document.getElementById("bancoBen").value;
		$("#spanCuentaClabeBanco").hide();
		
		if(claveBanco != "0"){
			$("#cuentaClabeBen").removeAttr("disabled");
		}else{
			$("#cuentaClabeBen").attr("disabled","disabled");
			$("#btnAdicionarBeneficiario").addClass('disabled_Url');
		}
		
		
			// $("#btnAdicionarBeneficiario").removeClass('disabled_Url');
			 var cuentaClabe = document.getElementById("cuentaClabeBen").value;
				if(cuentaClabe != ""){
					validarClabeBanco();
				}else{
					 $("#spanObligatoriosBen").show();
				}
	
		
		
	}
	
	
	
	function soloNumeros(e, input){
		var key = window.Event ? e.which : e.keyCode;
		var chark = String.fromCharCode(key);
		var tempValue = input.value+chark;
		
		return ((key >= 48 && key <= 57) || (key==8))
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
	
	
	
	function habilitarEliminar (source){
		 var valoresCheck = $("#tablaBeneficiariosImss input[type=checkbox]:checked").map(function() {
				return this.value;
			}).get();
		 if(valoresCheck.length == 0) {
			 $("#elimBen").addClass('disabled_Url');
		 }else{
			 $("#elimBen").removeClass('disabled_Url');
		 }
		
	}
	
	
	
	function marcar(source){
		$("#elimBen").addClass('disabled_Url');
		var table = document.getElementById("tablaBeneficiariosImss");
		var checkboxes =  table.getElementsByTagName("input");
		for(i = 0; i<checkboxes.length; i++){
			if(checkboxes[i].type == 'checkbox'){
				checkboxes[i].checked=source.checked;
				$("#elimBen").removeClass('disabled_Url');
			}
		}
		
			
		var valoresCheck = $("#tablaBeneficiariosImss input[type=checkbox]:checked").map(function() {
				return this.value;
			}).get();
		 if(valoresCheck.length == 0 || valoresCheck.length == 1) {
			 $("#elimBen").addClass('disabled_Url');
			 $("#chboxAll").prop("checked", false);
		 }else{
			 $("#elimBen").removeClass('disabled_Url');
		 }
		 
	}


	
	function eliminarRegChecksSele(){
		var table = document.getElementById("tablaBeneficiariosImss");
		var tr = table.getElementsByTagName("tr");
		var idRows = [];

		for(i = 0; i < tr.length; i++){
			if(tr[i].getAttribute("id") != "rowOriginal"){
				 var incrementador = tr[i].getAttribute("id").split('_');
				 var numIndice = incrementador[1];
				if(document.getElementById("ulCheckBox"+numIndice).checked){
					idRows.push('#row_' + numIndice)
				}
			}
			
		}
		
		for(var j=0; j<idRows.length;j++){
			$(idRows[j]).remove();
		}
		
		$("#elimBen").addClass('disabled_Url');
		
		$("#chboxAll").prop("checked", false);
		sumaTotalPorcentaje();
		
	}
	
	
	function sumaTotalPorcentaje(){
		let nFilasNuevo = $("#tablaBeneficiariosImss tr").length;
		var table = document.getElementById("tablaBeneficiariosImss");
		var tr = table.getElementsByTagName("tr");
		var sumaTotal=0;
		if(nFilasNuevo > 1){
			for(i = 0; i < tr.length; i++){
				if(tr[i].getAttribute("id") != "rowOriginal"){
					 var incrementador = tr[i].getAttribute("id").split('_');
					 var numIndice = incrementador[1];
					 sumaTotal += Number(document.getElementById("tdpor_"+numIndice).innerHTML);
				}
				
			}
			$("#porcentajeTotal").text("$"+sumaTotal);
			
			if(Number(sumaTotal) > 100){
				 $("#spanPorcentaje").show();
			}else{
				  $("#btnGenerarExpediente").removeClass('disabled_Url');
			}
		}else{
			$("#btnGenerarExpediente").addClass('disabled_Url');
			$("#porcentajeTotal").text("$0");
		}
	}