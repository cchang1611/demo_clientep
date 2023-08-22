$(document).ready(function() {
	$("#fechaIncioPension").val("01/01/0001");
	$("#fechaEmisionResolucion").attr("readonly","readonly");
	$("#fechaIncioPension").attr("disabled","disabled");
	$("#fechaEmisionResolucion").show()
	if(_FLUJO == "4") {
		window.location.href = "#resolucionCarga";
		$('#ComboPlanPrivado').hide();  
		$('#tablasSub').hide();
		$('#btnVentanillAfore').hide();
	} 
	else if(_FLUJO == "5"){
		window.location.href = "#modalConsultaCargado";
	}
	else if(_FLUJO == "2") {
		window.location.href = "#errorModal";
	}else if(_FLUJO == "3"){
		window.location.href = "#errorValidarNrpModal";
		console.log("Mostrando error por Nrp");
	}else if(_FLUJO == "6"){
		window.location.href = "#modalConsultaNrp";
	}else if(_FLUJO == "7"){
		window.location.href = "#errorValidarMarcaModal";
	}else if(_FLUJO == "8"){
	window.location.href = "#modalConsultarNss";
    }else if(_FLUJO == "9"){
	window.location.href = "#modalConsultarActuario";
    }
	
	
	$("#btnDerechoCargado").click(function(event) {
		 var datos = {};        
		 
			$.ajax({
				type      : "POST",
				url       : "validarDatamart.do",
				contentType	: "application/json",
				data:JSON.stringify(datos),
			}).success(function(data) {
				let cargaResoluciones = data.obRespuesta;
			    if(cargaResoluciones.length!=0){
			    	window.location.href="#modalConDerechoImss";
			    }else{
			    	window.location.href="#modalSinDerechoImss";
			    }
			})
			.error(function(data) {
				console.log("Error Consulta No Cargado"+data);
			});
	
		
    });

	$("#btnContinuaTramite").click(function(event) {
		$(location).attr('href', 'derechoCargado.do');
	 });
	
	
	$("#btnNoContinuaTramite").click(function(event) {
		$(location).attr('href', 'dispTotalImss.do');
	 });
	
	$("#btnValidarActuario").click(function(event) {
	    var cvActuario = document.getElementById("cvActuario").value;
	    var numeroPlan = document.getElementById("numeroPlan").value;
	    var datos = {};        
	 
	    /**Componente Ajax  */
		$.ajax({
		type      : "POST",
		 url       : "consultarActuarioPlan.do?cvActuario="+cvActuario+"&numeroPlan="+numeroPlan,
	    contentType	: "application/json",
	    data:JSON.stringify(datos),
       }).success(function(data) {
    	   var consultaActuarioPlan = data.obRespuesta;
	    	   if(consultaActuarioPlan==null){
	    		   var errrSpanActuario = document.getElementById("ErrorActuario");
	    		   errrSpanActuario.innerHTML="NO EXISTE RELACION LABORAL";
	    		   deshablitarCajasCapturaActuario();
	    	    }else{
	    		    hablitarCajasCapturaActuario();   
	    	     }
    	  })
	     .error(function(data) {
		   console.log("Error Consulta No Cargado"+data);
	    });
	});
	
		
	    $('#cvActuarioDiv').show();
	    $('#numeroPlanDiv').show();
	    $('#numeroResolucionDiv').show();
	    $('#secuenciaPensionDiv').show();
	    $('#fechaIncioPensionDiv').show();
	    $('#fechaEmisionPensionDiv').show();
	    $('#porcentajeValuacionDiv').show();
	    $('#numeroSemanasCotizadasDiv').show();
	    $('#wrapper').hide();
	    $('#btnValidarActuario').show();
	   
	   
	
	$("#btnExitoAceptarNrp").click(function(event) {
		$(location).attr('href', 'recaudadoraNrp.do');
	});
	
	
	$("#tablaCadenaDerecho tr").on("click", "input[type=radio]", function(){
		 const $tipoRetiro     = $("#tipoRetiro"); 
		 const $tipoSeguro     = $("#tipoSeguro");
		 const $tipoPension    = $("#tipoPension");
		 const $tipoPrestacion = $("#tipoPrestacion");
		 const $tipoRegimen    = $("#tipoRegimen");
		 $tipoRetiro.empty();
		 $tipoSeguro.empty();
		 $tipoPension.empty();
		 $tipoPrestacion.empty();
		 $tipoRegimen.empty();
       
	$('#descTipoRetiro').val($(this).closest("tr").find("td").eq(2).text());
	$('#descTipoSeguro').val($(this).closest("tr").find("td").eq(3).text());
    $('#descTipoPension').val($(this).closest("tr").find("td").eq(4).text());
    $('#descTipoPrestacion').val($(this).closest("tr").find("td").eq(5).text());
    $('#descTipoRegimen').val($(this).closest("tr").find("td").eq(6).text());
       
    });
	
	var table = $('#tablaCadenaDerecho').DataTable({
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
		"lengthMenu": [[4, 16, 24, 50], [4, 16, 24, 50]],
		"fnDrawCallback": function( oSettings ){
			$("input[name='radioButton']").prop("checked",false);
			var valor = document.getElementById("valorRadioDos").value;
			if(valor != ""){
				$("input[name='radioButton'][value='"+valor+"']").prop("checked",true);
			}
		}
	});

	
		
	$('#tipoRegimen').click(function(){
		 $("#tablasSub").hide();
        const $retiro = $("#tipoRetiro");
		$retiro.empty();
		const $seguro = $("#tipoSeguro");
		$seguro.empty();
		const $pension = $("#tipoPension");
		$pension.empty();
		const $prestacion = $("#tipoPrestacion");
		$prestacion.empty();
		
		    
		    const claveRegimen = document.getElementById("tipoRegimen").value;
			console.log("tipo Regimen Seleccionado :"+claveRegimen);
			const combo = document.getElementById("tipoRegimen");
			const descripcionRegimen = combo.options[combo.selectedIndex].text;
			var datos = {};
			const map = new Map();
			
			if(claveRegimen==0){
				$("#errorTipoRegimenObligatorio").show();
			}else{
				eliminarMensajeRegimen(this);
				if(claveRegimen!=0 && claveRegimen=="73"){
			   	document.getElementById("nrp").disabled=false;
					 $('#btnValidarNrp').show();
					 $('#actuarioDiv').hide();
					 $('#numeroPlanDiv').hide();
					 $('#nrpDiv').hide();
					 $('#nrp').show();
					 $('#nrpCampoDiv').hide();
					 
				console.log("Entra Regimen:73");
				$("#errorTipoRegimenObligatorio").hide();
				//Invocar para validar el DaTaMart
				//RN 0021 – Validar Relación Laboral para Plan Privado Régimen 73
					$.ajax({
						type      : "POST",
						url       : "derechoNoCargadoClave.do?cvRegimen="+claveRegimen,
						contentType	: "application/json",
						data:JSON.stringify(map),
					}).success(function(data) {
					
						var map= data.mapString;
						let clave;
						for(clave of Object.keys(map)){
							var valor=map[clave];
							console.log(clave,valor);
						}
						addOptionsTipoRetiro73("tipoRetiro",clave,valor,map);
						})
					.error(function(data) {
						console.log("Error Consulta No Cargado"+data);
					});
				
				}else{
					$("#errorTipoRegimenObligatorio").hide();
					var listaTipoRetiro=null;
					$('#actuarioDiv').show();
					$('#numeroPlanDiv').show();
					$('#nrpCampoDiv').show();
					$('#numeroPlanDiv').show();
					$('#numeroPlanDiv').show();
					
					$.ajax({
						type      : "POST",
						url       : "derechoNoCargadoClave97.do?cvRegimen="+claveRegimen,
						contentType	: "application/json",
						data:JSON.stringify(datos),
					}).success(function(data) {
						listaTipoRetiro= data.lstObRespuesta;
						addOptionsTipoRetiro97("tipoRetiro",listaTipoRetiro);
						})
					.error(function(data) {
						console.log("Error Consulta No Cargado"+data);
					});
				}
			}	
          
	});
	    
	$('#tipoRetiro').click(function(){
		    $("#tablasSub").hide();
			const $seguro = $("#tipoSeguro");
			$seguro.empty();
			const $pension = $("#tipoPension");
			$pension.empty();
			const $prestacion = $("#tipoPrestacion");
			$prestacion.empty();
			var listaTipoSeguro=null
			let claveRegimen = document.getElementById("tipoRegimen").value;
			let claveRetiro = document.getElementById("tipoRetiro").value;
			let edad = document.getElementById("edadTrabajdor").value;
			
			
			validarEdadTrabajador(claveRetiro,edad);
			$("#errorTipoRegimenObligatorio").hide();
			var datos = {};
			 datos.cvTipoRegimen    = claveRegimen;
			 datos.cvTipoRetiro     = claveRetiro;
			
			 if(claveRegimen!=0 && claveRetiro!='' ){
				$.ajax({
						type      : "POST",
					   	url       : "derechoNoCargadoRetiro.do",
					contentType	: "application/json",
					data:JSON.stringify(datos),
				}).success(function(data) {
					listaTipoSeguro= data.lstObRespuesta;
					addOptionsTipoSeguro("tipoRetiro",listaTipoSeguro);
					})
				.error(function(data) {
					console.log("Error Consulta No Cargado"+data);
				});
			
			}
		});
	    
	
	$('#tipoSeguro').click(function(){
		const $pension = $("#tipoPension");
		$pension.empty();
		const $prestacion = $("#tipoPrestacion");
		$prestacion.empty();
		
		var listaTipoPension=null;
		
		let claveRegimen = document.getElementById("tipoRegimen").value;
		let claveRetiro = document.getElementById("tipoRetiro").value;
		let claveSeguro = document.getElementById("tipoSeguro").value;
		var combo = document.getElementById("tipoSeguro");
		var descripcionSeguro = combo.options[combo.selectedIndex].text;
		var datos = {};
		 datos.cvTipoRegimen    = claveRegimen;
		 datos.cvTipoRetiro     = claveRetiro;
		 datos.cvTipoSeguro     = claveSeguro;
		
		
		if(claveSeguro!=0 ){
			$.ajax({
					type      : "POST",
					url       : "derechoNoCargadoSeguro.do",
				contentType	: "application/json",
				data:JSON.stringify(datos),
			}).success(function(data) {
				listaTipoPension= data.lstObRespuesta;
				addOptionsTipoPension("tipoPension",listaTipoPension)
				})
			.error(function(data) {
				console.log("Error Consulta No Cargado"+data);
			});
		
		}
	});
	
	
	$('#tipoPension').click(function(){
		 $("#tablasSub").hide();
		const $prestacion = $("#tipoPrestacion");
		$prestacion.empty();
		var listaTipoPrestacion=null;
		
		let claveRegimen = document.getElementById("tipoRegimen").value;
		let claveRetiro = document.getElementById("tipoRetiro").value;
		let claveSeguro = document.getElementById("tipoSeguro").value;
		let claveTipoPension = document.getElementById("tipoPension").value;
		var datos = {};
	    datos.cvTipoRegimen    = claveRegimen;
	 	datos.cvTipoRetiro     = claveRetiro;
	 	datos.cvTipoSeguro     = claveSeguro;
	 	datos.cvTipoPension    = claveTipoPension;
	 	console.log(datos);		
		if(claveTipoPension!=0 ){
			$.ajax({
					type      : "POST",
					url       : "derechoNoCargadoPension.do", 
				contentType	: "application/json",
				data:JSON.stringify(datos),
			}).success(function(data) {
				 listaTipoPrestacion= data.lstObRespuesta;
				  addOptionsTipoPrestacion("tipoPrestacion",listaTipoPrestacion);
				})
			.error(function(data) {
				console.log("Error Consulta No Cargado"+data);
			});
		
		}
		
		
		
		
	});
	
	$("#btnDerechoNoCargado").on("click",function(){
	var listaRegimen =null; 
	var datos = {};  
	 $('#documentoProbatorioDiv').hide();
	 $('#ventanillaAforeDiv').hide();
	 $('#ventanillaInfonavitDiv').hide();
	 $('#actuarioDiv').hide();
	 $("#spanPorcentajeValMayor").hide();
	 $("#spanPorcentajeValMenor").hide();
	 $('#EncabezadoVentanillaAfore').hide();
	 $('#containderAforeDiv').hide();
	// $('#btnVentanillAfore').hide();
	 $('#EncabezadoBeneficiarioDiv').hide();
	 $('#containerBeneficiarioDiv').hide();
	 $('#numeroPlanDiv').hide();
	 $('#nrpCampoDiv').hide();
		$.ajax({
				type      : "POST",
			    url       : "derechoNoCargado.do",
			contentType	: "application/json",
			data:JSON.stringify(datos),
		}).success(function(data) {
			 //Mostrar modal para las icefas   
	    	 var listaIcefasTrabajador = data.lstObIcefas;
	    	validarIcefasTrabajador(listaIcefasTrabajador);
	    	validarFechaIn();
			  listaRegimen= data.lstObRespuesta;
			  addOptionsRegimen("tipoRegimen",listaRegimen);
			})
		.error(function(data) {
			console.log("Error Consulta No Cargado"+data);
		});
	     	
	});
	
	$("#btnPlanPrivado").on("click",function(){
		var datos = {};
		datos.claveTipoRegimen = claveTipoRegimen;
		 $('#documentoProbatorioDiv').hide();
		 $('#ventanillaAforeDiv').hide();
		 $('#ventanillaInfonavitDiv').hide();
		 $('#actuarioDiv').hide();
		 $('#numeroPlanDiv').hide();
		 $('#nrpCampoDiv').hide();
		 $.ajax({
				type      : "GET",
			    url       : "validarNrpPlanActuario.do", 
			contentType	: "application/json",
     	}).success(function(data) {
          	window.location.href="#modalCapturaNrp";
			})
		.error(function(data) {
			console.log("Error Consulta Plan Privado"+data);
		});
	});
		
	$("#btnPopupValidarNrp").click(function(event) {
		$('#ventanillaInfonavitDiv').hide();
		
		var nrp = document.getElementById("nrp").value;
		var datos = {};        
	    if(nrp.length==0 ){
			  let errorValidaEdad = document.getElementById("errorValidarNrp");
		      errorValidaEdad.innerHTML="Debes capturar campo nrp";	
		  return false; 
		  }else{
		    	console.log("CONTINUAR CON TRAMITE PPP");
		   $.ajax({
				type      : "POST",
				url       : "recaudadoraNrp.do?nrp="+nrp,
			    contentType	: "application/json",
			    data:JSON.stringify(datos),
		       }).success(function(data) {
		    	   var consultanrp = data.obRespuesta;
		   	    	   if(consultanrp==null){
			    		  $(location).attr('href', 'mostrarResultadoModal.do');     
			    		   
			    	   }else{
			    	    	console.log("CONTINUAR TRAMITE MUESTRA FORMULARIO PPP"); 
			    	    	
			    	    	//$("#actuarioDiv").show();
			    	    	
			    	    	$.ajax({
				    				type      : "POST",
				    			    url       : "derechoNoCargado.do",
				    			contentType	: "application/json",
				    			data:JSON.stringify(datos),
			    		    }).success(function(data) {
			    			  //Mostrar modal para las icefas   
			    		    	var listaIcefasTrabajador = data.lstObIcefas;	   
			    		    	validarIcefasTrabajador(listaIcefasTrabajador);
			    			   listaRegimen= data.lstObRespuesta;
				    			  addOptionsRegimen("tipoRegimen",listaRegimen);
				    			  
			    			})
				    		.error(function(data) {
				    			console.log("Error Consulta No Cargado"+data);
				    		});
			           }//fin else
			    	  })
				     .error(function(data) {
					   console.log("Error Consulta No Cargado"+data);
				    });
		   }
	});
	
	
	
    $('#planPrivadoPension').click(function(){
    	const $retiro = $("#tipoRetiro");
		$retiro.empty();
    	const $seguro = $("#tipoSeguro");
		$seguro.empty();
		const $pension = $("#tipoPension");
		$pension.empty();
		const $prestacion = $("#tipoPrestacion");
		$prestacion.empty();
    	
    	var claveRegimen = document.getElementById("planPrivadoPension").value;
		var combo = document.getElementById("planPrivadoPension");
		var descripcionRegimen = combo.options[combo.selectedIndex].text;
		var datos = {};
					
			  if(claveRegimen == "73"){
				$('#btnValidarActuario').hide();
				  
			  }else{
				$('#nrpDiv').show();
				  $('#cvActuarioDiv').hide();
				  $('#numeroPlanDiv').hide();
				  $('#nrpDiv').hide();
				  $('#btnValidarNrp').show();
				  $('#btnValidarActuario').hide();
				  $('#curpAgenteServicioDiv').hide();
				  
			  }
		
		
		if(claveRegimen!=0 && claveRegimen=="73"){
			
			 $.ajax({
					type      : "POST",
				    url       : "derechoNoCargadoClave.do?cvRegimen="+claveRegimen,
				contentType	: "application/json",
				data:JSON.stringify(datos),
			}).success(function(data) {
//			
				var map= data.mapString;
				let clave;
				for(clave of Object.keys(map)){
					var valor=map[clave];
					
				}
				addOptionsTipoRetiro73("tipoRetiro",clave,valor,map);
				
				})
			.error(function(data) {
				console.log("Error Consulta No Cargado"+data);
			});
		
	  }else{
		
		  $('#nrpDiv').hide();
		  
		  $('#btnValidarActuario').hide();
		  $('#cvActuarioDiv').show();
		  $('#numeroPlanDiv').show();
		  $('#numeroResolucionDiv').hide();
		  $('#secuenciaPensionDiv').hide();
		  $('#fechaIncioPensionDiv').hide();
		  $('#fechaEmisionPensionDiv').hide();
		  $('#porcentajeValuacionDiv').hide();
		  $('#numeroSemanasCotizadasDiv').hide();
		  
		  $('#solicitanteDiv').hide();
		  $('#descripcionSolicitanteDiv').hide();
		  
		  $('#btnValidarNrp').hide();
		  $('#btnValidarActuario').show();
			const $regimen = $("#tipoRegimen");
			$regimen.empty();
			const $seguro = $("#tipoSeguro");
			$seguro.empty();
			const $pension = $("#tipoPension");
			$pension.empty();
			const $prestacion = $("#tipoPrestacion");
			$prestacion.empty();
			
			$.ajax({
				type      : "POST",
				url       : "derechoNoCargadoClave97.do?cvRegimen="+claveRegimen,
				contentType	: "application/json",
				data:JSON.stringify(datos),
			}).success(function(data) {
				var listaTipoRetiro= data.lstObRespuesta;
				addOptionsTipoRetiro97("tipoRetiro",listaTipoRetiro);
				})
			.error(function(data) {
				console.log("Error Consulta No Cargado"+data);
			});
		  
		  
	  }
  });	
    
    $("#btnModalAceptar").click(function(event) {
		
		var datos = {};
		$.ajax({
			type      : "GET",
			url       : "validarNrpPlanActuario.do",
		    contentType	: "application/json",
		    data:JSON.stringify(datos),
	       }).success(function(data) {
	    	   window.location.href="#modalCapturaNrp"; 
	    	  })
		     .error(function(data) {
			   console.log("Error Consulta No Cargado"+data);
		    });
    });
    

    $("#btnEnviarCargado").click(function(event) {
		console.log("Invocando btn Cargado ,para recuperar Lista:");
		$('#EncabezadoVentanillaAfore').hide();
		$('#containderAforeDiv').hide();
		$('#ventanillaAforeDiv').hide();
	    $('#ventanillaInfonavitDiv').hide();
	    
	    $('#EncabezadoBeneficiarioDiv').hide();
	    $('#containerBeneficiarioDiv').hide();
	    
		/* Para definir Ventanilla Afore  */
		var claveRegimen = document.getElementById("tipoRegimen").value;
	    var claveRetiro = document.getElementById("tipoRetiro").value;
		var clavePrestacion = document.getElementById("tipoPrestacion").value;
		var fechaResol = document.getElementById("fechaEmisionResolucion").value;
	    const fechaDefinida ="12/01/2020";
	    var datos = {};
		  
		$.ajax({
			type      : "POST",
			url       : "validarMatrizDerechoProceso.do",
		    contentType	: "application/json",
		    data:JSON.stringify(datos),
	       }).success(function(data) {
	    	   
	    	   var arrayList= data.lstObRespuesta;
	    	   if(arrayList==null){
	    		  
	    		   window.location.href="#modalerrorProcesos";
	    		   $("#modalerrorProcesos").show();
	    		   $('#ventanillaAforeDiv').hide();
	   		       $('#ventanillaInfonavitDiv').hide();
	    	   }else{
	    		 /*  •	Tipo de Retiro E 
	    		   •	Régimen 73
	    		   •	Prestación 00 y con 
	    		   •	Fecha de emisión de resolución igual o mayor al 12/01/2020.
                 */
		    //	if(claveRegimen=='73' && claveRetiro=='F' && clavePrestacion=='00'){ //PAra Pruebas
		       if(claveRegimen=='73' && claveRetiro=='E' && clavePrestacion=='00'){	   
		   	    	console.log("Cumple con los parametros");
		   	    	if(arrayList.includes('402') || arrayList.includes('403') ){
			   	       if(compare_dates(fechaResol,fechaDefinida)){
			   		       	$('#ventanillaAforeDiv').show();
			   		        $('#ventanillaInfonavitDiv').show(); 
			   		    }else{
			   		    	$('#ventanillaAforeDiv').show();
			   		    	$('#ventanillaInfonavitDiv').show();
			   		    
			   		    }
		   	    	}	
		   	      }
	    	   }
	    	 
	       })
		     .error(function(data) {
			   console.log("Error Consulta No Cargado"+data);
		    });
    });

    $("#btnRedicSubMenuProceso").click(function(event) {
		console.log("Invocando btn Modal Red al SubMenu:");
		$(location).attr('href', 'amenu.do');
		
    });

    
    validarBntonAceptarCargado(radioCargado);
    $('#documentoProbatorioDiv').hide();
    
    mostrarVentanillaAfore();
    
    
    $("#btnCancelaCargado").click(function(event) {
		$(location).attr('href', 'dispTotalImss.do');
	});
    

    $('#tipoPrestacion').click(function(){
		
		 console.log(" RN 0034- Validar Información para Solicitud Plan Privado ");
		 
		 const claveRegimen = document.getElementById("tipoRegimen").value;
		 let claveRetiro = document.getElementById("tipoRetiro").value;
		 let claveSeguro = document.getElementById("tipoSeguro").value;
	 	 let claveTipoPension = document.getElementById("tipoPension").value;
	 	 let clavePrestacion = document.getElementById("tipoPrestacion").value;
		 let datos = {};
		    datos.cvTipoRegimen    = claveRegimen;
		 	datos.cvTipoRetiro     = claveRetiro;
		 	datos.cvTipoSeguro     = claveSeguro;
		 	datos.claveTipoPension = claveTipoPension;
		 	datos.cvTipoPension    = claveTipoPension;
		 	datos.cvTipoPrestacion = clavePrestacion;
			
		 //Invovar Ajax para enviar los valores de los combos
		 	if(clavePrestacion!=0 && clavePrestacion=='04'){	
				if(claveRegimen=='97'  && claveRetiro=='F' && claveSeguro=='PP' && 
							(claveTipoPension=='RE' || claveTipoPension=='AS' ||
							 claveTipoPension=='OR' || claveTipoPension=='VI' ||
							 claveTipoPension=='VO' || claveTipoPension=='IP' ||
							 claveTipoPension=='IN' || claveTipoPension=='CE' ||
							 claveTipoPension=='VE' ) && clavePrestacion=='04'){
						mostrarModalAceptado(clavePrestacion,datos);
					}	

			 }
		 	
		 	if(clavePrestacion!=0 && clavePrestacion=='05'){	
				 if(claveRegimen=='73'  && claveRetiro=='F' && claveSeguro=='PP' && 
							(claveTipoPension=='RE' || claveTipoPension=='AS' ||
							 claveTipoPension=='OR' || claveTipoPension=='VI' ||
							 claveTipoPension=='VO' || claveTipoPension=='IP' ||
							 claveTipoPension=='IN' || claveTipoPension=='CE' ||
							 claveTipoPension=='VE' ) && clavePrestacion=='05'){
					mostrarModalAceptado(clavePrestacion,datos);
					}

			}
		 	   
			
			 	
	
	});
    
    $("#btnNoHayDerechoAceptado").click(function(event) {
		$(location).attr('href', 'dispTotalImss.do');
	});
    
    

    
});//Principal

function mostrarModalAceptado(clavePrestacion,datos){
	  if(clavePrestacion!=0 ){ 	
				$.ajax({
					type      : "POST",
				   	url       : "consultarPlanPrivadoImss.do",
				contentType	: "application/json",
				data:JSON.stringify(datos),
			}).success(function(data) {
				let derechoAceptado= data.obRespuesta;
				console.log(derechoAceptado);
				if(derechoAceptado.codigoOperacion=="02"){
				  window.location.href="#modalNoHayDerechoAceptado";					
				}else if(derechoAceptado.codigoOperacion=="01"){
					console.log("CONTINUA TRAMITE POR PLAN PRIVADO");
				}
				
				})
			.error(function(data) {
				console.log("Error Consulta No Cargado"+data);
			});
     }

}


function hablitarCajasCapturaNrp(){
	$('#cvActuarioDiv').hide();
    $('#numeroPlanDiv').hide();
    $('#btnValidarNrp').hide();
    $('#ErrorNrp').hide();
    
    $('#numeroResolucionDiv').show();
    $('#secuenciaPensionDiv').show();
    $('#fechaIncioPensionDiv').show();
    $('#fechaEmisionPensionDiv').show();
    $('#porcentajeValuacionDiv').show();
    $('#numeroSemanasCotizadasDiv').show();
    
    
    $('#fechaSolicitudDiv').show();
    $('#fechaNacimientoDiv').show();
    $('#curpAgenteServicioDiv').show();
 
    $("#tipoRetiro").removeAttr("disabled");
    $("#tipoSeguro").removeAttr("disabled");
    $("#tipoPension").removeAttr("disabled");
    $("#tipoPrestacion").removeAttr("disabled");
    $("#tipoRegimen").removeAttr("disabled");
    $("#planPrivadoPension").removeAttr("disabled");
    $("#curpAgenteServicioDiv").attr("disabled");
    $("#curpAgenteServicio").attr("disabled");
}

function deshablitarCajasCapturaNrp(){
	$('#cvActuarioDiv').hide();
    $('#numeroPlanDiv').hide();
    $('#btnValidarNrp').show();
    $('#numeroResolucionDiv').hide();
    $('#secuenciaPensionDiv').hide();
    $('#fechaIncioPensionDiv').hide();
    $('#fechaEmisionPensionDiv').hide();
    $('#porcentajeValuacionDiv').hide();
    $('#numeroSemanasCotizadasDiv').hide();
    $('#curpAgenteServicioDiv').hide();
    
    $("#tipoRetiro").attr("disabled","disabled");
    $("#tipoSeguro").attr("disabled","disabled");
    $("#tipoPension").attr("disabled","disabled");
    $("#tipoPrestacion").attr("disabled","disabled");
    $("#tipoRegimen").attr("disabled","disabled");
    $("#planPrivadoPension").attr("disabled","disabled");
    
    
}

function hablitarCajasCapturaActuario(){
	$('#cvActuarioDiv').show();
    $('#numeroPlanDiv').show();
    $('#btnValidarNrp').hide();
    $('#ErrorNrp').hide();
    $('#btnValidarActuario').hide();
    $('#ErrorActuario').hide();
    
    $('#numeroResolucionDiv').show();
    $('#secuenciaPensionDiv').show();
    $('#fechaIncioPensionDiv').show();
    $('#fechaEmisionPensionDiv').show();
    $('#porcentajeValuacionDiv').show();
    $('#numeroSemanasCotizadasDiv').show();
    
    
    $("#tipoRetiro").removeAttr("disabled");
    $("#tipoSeguro").removeAttr("disabled");
    $("#tipoPension").removeAttr("disabled");
    $("#tipoPrestacion").removeAttr("disabled");
    $("#tipoRegimen").removeAttr("disabled");
    $("#planPrivadoPension").removeAttr("disabled");
    $("#curpAgenteServicioDiv").attr("disabled","disabled");
    $("#curpAgenteServicio").attr("disabled","disabled");
}

function deshablitarCajasCapturaActuario(){
	
	$('#cvActuarioDiv').show();
    $('#numeroPlanDiv').show();
    $('#btnValidarNrp').hide();
    
    $('#numeroResolucionDiv').hide();
    $('#secuenciaPensionDiv').hide();
    $('#fechaIncioPensionDiv').hide();
    $('#fechaEmisionPensionDiv').hide();
    $('#porcentajeValuacionDiv').hide();
    $('#numeroSemanasCotizadasDiv').hide();
    
    $("#tipoRetiro").attr("disabled","disabled");
    $("#tipoSeguro").attr("disabled","disabled");
    $("#tipoPension").attr("disabled","disabled");
    $("#tipoPrestacion").attr("disabled","disabled");
    $("#tipoRegimen").attr("disabled","disabled");
    $("#planPrivadoPension").attr("disabled","disabled");
    
}
    
function habilitarDatosEnvio(radioCargado,cvTipoRetiro,cvTipoSeguro,cvTipoPrestacion,cvTipoPension,cvTipoRegimen,numeroResolucion,secuenciaPension,fcInicioPension,fcEmisionResolucion,porcentajeValuacion,semanasCotizadas){
	console.log("Entrando al dar Click en el Radio para CARGADO");
	validarBntonAceptarCargado(radioCargado);
	$('#ComboPlanPrivado').hide(); 
	$('#nrpDiv').hide();
	
	$('#cvActuarioDiv').hide();
	$('#numeroPlanDiv').hide();
	$('#btnValidarNrp').hide();
	
	    $('#claveTipRetiro').val(cvTipoRetiro);
	    $('#claveTipSeguro').val(cvTipoSeguro);
		$('#claveTipoPension').val(cvTipoPension);
		$('#claveTipoPrestacion').val(cvTipoPrestacion);
		$('#claveTipoRegimen').val(cvTipoRegimen);
		$('#numeroResolucion').val(numeroResolucion);
		$('#secuenciaPension').val(secuenciaPension);
		$('#fechaIncioPension').val(fcInicioPension);
		$('#fechaEmisionResolucion').val(fcEmisionResolucion);
	    $('#porcentajeValuacion').val(porcentajeValuacion);
		$('#numeroSemanasCotizadas').val(semanasCotizadas);
		$("#btnEnviarCargado").removeClass('disabled_Url');
		
		
		if(radioCargado=="1"){
			$('#ErrorSolicitanteCargado').hide();
			$("#btnEnviarCargadoDiv").removeClass('disabled_Url');
		}else{
			$("#btnEnviarCargadoDiv").addClass('disabled_Url');
		}
		
		$('#numeroResolucionDiv').show();
	    $('#secuenciaPensionDiv').show();
	    $('#fechaIncioPensionDiv').show();
	    $('#fechaEmisionPensionDiv').show();
	    $('#porcentajeValuacionDiv').show();
	    $('#numeroSemanasCotizadasDiv').show();
	 //   $('#btnVentanillAfore').hide();
		
	    var retiroH = document.getElementById("cvTipoRetiro").value;
	    if(retiroH=='H'){
	    	 $("#spanFechaNac").show();
	    	 $("#btnEnviarCargadoDiv").addClass('disabled_Url');
	    }
	   
	    var fechaHoy = new Date();
		var fechaSolicitud = ("0" + fechaHoy.getDate()).slice(-2) + "/" + ("0"+(fechaHoy.getMonth()+1)).slice(-2) + "/" + fechaHoy.getFullYear();
		$('#fechaSolicitud').val(fechaSolicitud);
      
		 $('#spanPorcentajeVal').hide();
		
}


function obtenerDatosTabla(){
	console.log("Obtenemos los Datos de la tabla ");
    
	const $radio     = $("#radioCargado");
	console.log("radioCargado:"+$radio.val());
    const $tipoRetiro     = $("#tipoRetiro");
    const $tipoSeguro     = $("#tipoSeguro");
    const $tipoPension    = $("#tipoPension");
    const $tipoPrestacion = $("#tipoPrestacion");
    const $tipoRegimen    = $("#tipoRegimen");
    const numeroResolucion    = $("#numeroResolucion");
    const secuenciaPension    = $("#secuenciaPension");
    const fechaIncioPension   = $("#fechaIncioPension");
    const fechaEmisionResolucion = $("#fechaEmisionResolucion-");
    const porcentajeValuacion = $("#porcentajeValuacion");
    const numeroSemanasCotizadas = $("#numeroSemanasCotizadas");
    const descTipoSeguro = $("#descTipoSeguro");
    const descTipoRetiro = $("#descTipoRetiro");


    $tipoRetiro.append($("<option>",{
        value:document.getElementById("claveTipRetiro").value,
        text:document.getElementById("descTipoRetiro").value
    }));
    
    $tipoSeguro.append($("<option>",{
        value:document.getElementById("claveTipSeguro").value,
        text:document.getElementById("descTipoSeguro").value
    }));
    
    $tipoPension.append($("<option>",{
        value:document.getElementById("claveTipoPension").value,
        text:document.getElementById("descTipoPension").value
    }));
    
    $tipoPrestacion.append($("<option>",{
        value:document.getElementById("claveTipoPrestacion").value,
        text:document.getElementById("descTipoPrestacion").value
    }));
    
    $tipoRegimen.append($("<option>",{
        value:document.getElementById("claveTipoRegimen").value,
        text:document.getElementById("descTipoRegimen").value
    }));
    
    numeroResolucion.append($("<option>",{
        value:document.getElementById("numeroResolucion").value
    }));
    
    secuenciaPension.append($("<option>",{
        value:document.getElementById("secuenciaPension").value
    }));

    fechaIncioPension.append($("<option>",{
        value:document.getElementById("fechaIncioPension").value
    }));
    
    fechaEmisionResolucion.append($("<option>",{
        value:document.getElementById("fechaEmisionResolucion").value
    }));
    
    porcentajeValuacion.append($("<option>",{
        value:document.getElementById("porcentajeValuacion").value
    }));
    
    numeroSemanasCotizadas.append($("<option>",{
        value:document.getElementById("numeroSemanasCotizadas").value
    }));
    
    $("#tipoRetiro").attr("disabled","disabled");
    $("#tipoSeguro").attr("disabled","disabled");
    $("#tipoPension").attr("disabled","disabled");
    $("#tipoPrestacion").attr("disabled","disabled");
    $("#tipoRegimen").attr("disabled","disabled");
    
    $("#numeroResolucion").attr("disabled","disabled");
    $("#secuenciaPension").attr("disabled","disabled");
    $("#fechaIncioPension").attr("disabled","disabled");
    $("#fechaEmisionResolucion").attr("disabled","disabled");
    $("#numeroSemanasCotizadas").attr("disabled","disabled");
    

    $("input#porcentajeValuacion").blur(function(event){
    	 let claveRetiro = document.getElementById("tipoRetiro").value;
 		 let claveSeguro = document.getElementById("tipoSeguro").value;
 	     let claveTipoPension = document.getElementById("tipoPension").value;
  	     let campoPorcentajeValuacion = document.getElementById("porcentajeValuacion").value;
 	   
 	    $("#spanPorcentajeValMenor").hide();
 		
 	   //8.	Si el tipo de Retiro es E o M, con una cadena de derechos que considere 
 	   //   tipo de pensión IP y seguro RT,
 	    
 		if( (claveRetiro=='F' || claveRetiro=='M') && (claveTipoPension=='CE' && claveSeguro=='IV') ){
 		//if( (claveRetiro=='E' || claveRetiro=='M') && (claveTipoPension=='IP' && claveSeguro=='RT') ){
 			document.getElementById("porcentajeValuacion").disabled=false; 
 			if(campoPorcentajeValuacion <= 49 ){
 				eliminarMensajeMayor50(this);
 				agregarMensajeMayor50(this,"Porcentaje de Evaluación debe ser mayor a 50%");
 		      }else if(campoPorcentajeValuacion >=101){
 		    	  eliminarMensajeMenor100(this);
 		    	  agregarMensajeMenor100(this,"Porcentaje de Evaluación debe ser menor a 100%");
 		      }else if(campoPorcentajeValuacion <= 100){
 		    	 eliminarMensajeMayor50(this);
 		    	 eliminarMensajeMenor100(this);
 		      }
 		}	
// 		}else{
// 			 $("#spanPorcentajeValMayor").hide();
//		     $("#spanPorcentajeValMenor").hide();
// 			 document.getElementById("porcentajeValuacion").disabled=true; 
// 	         console.log("No se habilita campo Porcentaje");	
// 	        
// 		}
 	});
    
    mostrarTablasRcvVivienda();
   
   	 
}//fin

     function agregarMensajeMayor50(fct,mensjae){
    	 $("input#porcentajeValuacion").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
     }

     function eliminarMensajeMayor50(fct){
		$("span.error_span").hide();
	 }
     
     function agregarMensajeMenor100(fct,mensjae){
    	 $("input#porcentajeValuacion").addClass("invalid_data");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
     }

     function eliminarMensajeMenor100(fct){
    
		$("span.error_span").hide();
	 }
     
     function compare_dates(fecha, fecha2)  
		{  
		  var xMonth=fecha.substring(3, 5); 
		  var xDay=fecha.substring(0, 2);  
		  var xYear=fecha.substring(6,10); 
		  var yMonth=fecha2.substring(3, 5);
		  var yDay=fecha2.substring(0, 2);  
		  var yYear=fecha2.substring(6,10);
		  if (xYear> yYear)  
		  {  
	      return(true)  
		  }  
		  else  
		  {  
		    if (xYear == yYear)  
		    { 
	
		      if (xMonth> yMonth)  
		      {  
		    	  
		          return(true)  
		      }  
		      else  
		      {   
		        if (xMonth == yMonth)  
		        { 
		        	
		          if (xDay> yDay)  
		            return(true);  
		          else  
		            return(false);  
		        }  
		        else  
		          return(false);  
		      }  
		    }  
		    else  
		      return(false);  
		  }  
    } 

	/** Llena el combo de Tipo Regimen */
	function addOptionsRegimen(domElement,listaRegimen){
	 	 if(listaRegimen.length >0){	
	     const $tipoRegimen = $("#tipoRegimen");
	    $tipoRegimen.append($("<option>",{
	        value:"0",
	        text:"Seleccione una opción"
	    }));
	    
	    for(var i=0; i<listaRegimen.length; i++){
	        $tipoRegimen.append($("<option>",{
	            value:listaRegimen[i].chParametro,
	            text:listaRegimen[i].chValorParametro
	        }));
	     }       
	    }
	 }
	
	/* Combo TipoRegimen para Plan Privado */
//	function addOptionsPlanPrivado(domElement,listaRegimen){
//	  if(listaRegimen.length >0){
//		const $planPrivadoPension = $("#planPrivadoPension");
//	    $planPrivadoPension.append($("<option>",{
//	        value:"0",
//	        text:"Seleccione una opción"
//	    }));
//	    
//	    for(var i=0; i<listaRegimen.length; i++){
//	    	$planPrivadoPension.append($("<option>",{
//	            value:listaRegimen[i].chParametro,
//	            text:listaRegimen[i].chValorParametro
//	        }));
//	     }  
//	   }
//	 }
	
	/* Llena el combo de Tipo Retiro */
	function addOptionsTipoRetiro73(domElement,clave,valor,map){
	// if(clave!=null && map.length>0){	
		const $tipoRetiro = $("#tipoRetiro");
		$tipoRetiro.append($("<option>",{
	        value:"0"
	        ,text:"Seleccione una opción"
	    }));
	    
		
		for(let clave of Object.keys(map)){
			var valor=map[clave];
			$tipoRetiro.append($("<option>",{
			value:clave,
			text:valor
		  }));
		}
	//}	
   }
	
	
	/* Llena el combo de Tipo Retiro */
	function addOptionsTipoRetiro97(domElement,listaTipoRetiro){
	if(listaTipoRetiro.length >0){	
		const $tipoRetiro = $("#tipoRetiro");
		$tipoRetiro.append($("<option>",{
	        value:"0",
	        text:"Seleccione una opción"
	    }));
	    
	    for(var i=0; i<listaTipoRetiro.length; i++){
	    	$tipoRetiro.append($("<option>",{
	            value:listaTipoRetiro[i].clave,
	            text:listaTipoRetiro[i].descripcion
	        }));
	        
	    }
	 } 
	}
	
	
	/* Llena el combo de Tipo Seguro*/
	function addOptionsTipoSeguro(domElement,listaTipoSeguro){
//		if(listaTipoSeguro.length >0){		
		const $tipoSeguro = $("#tipoSeguro");
		$tipoSeguro.append($("<option>",{
	        value:"0",
	        text:"Seleccione una opción"
	    }));
	    
	    for(var i=0; i<listaTipoSeguro.length; i++){
	        $tipoSeguro.append($("<option>",{
	            value:listaTipoSeguro[i].clave,
	            text:listaTipoSeguro[i].descripcion
	        }));
	      }  
	    }
	//} 
	
	/* Llena el combo de Tipo Pension*/
	function addOptionsTipoPension(domElement,listaTipoPension){
	if(listaTipoPension.length >0){	
		const $tipoPension = $("#tipoPension");
		$tipoPension.append($("<option>",{
	        value:"0",
	        text:"Seleccione una opción"
	    }));
	    
	    for(var i=0; i<listaTipoPension.length; i++){
	    	$tipoPension.append($("<option>",{
	            value:listaTipoPension[i].clave,
	            text:listaTipoPension[i].descripcion
	        }));
	      }  
	    }
	}
	
	/* Llena el combo de Tipo Prestacion*/
	function addOptionsTipoPrestacion(domElement,listaTipoPrestacion){
	 if(listaTipoPrestacion.length >0){
		const $tipoPrestacion = $("#tipoPrestacion");
		$tipoPrestacion.append($("<option>",{
	        value:"0",
	        text:"Seleccione una opción"
	    }));
	    
	    for(var i=0; i<listaTipoPrestacion.length; i++){
	    	$tipoPrestacion.append($("<option>",{
	            value:listaTipoPrestacion[i].clave,
	            text:listaTipoPrestacion[i].descripcion
	        }));
	     }  
	  }
	}

   function validarEdadTrabajador(claveRetiro,edad){
	     if(claveRetiro=='H'){
	    	 $('#documentoProbatorioDiv').show();
	    	 if(edad<65){
	    		 window.location.href = "#miModalFechaNac";
	    	 $('#documentoProbatorioDiv').show();
	    	 } 
	     }
   }
   
  function validarBntonAceptarCargado(radioCargado){
	  console.log("Deshabilitando boton ACEPTAR CARGADO");
	  $('#spanPorcentajeVal').hide();
	  $('#spanFechaNac').hide();
	  $("#actuarioDiv").hide();
//	  $("#aseguradoraDiv").hide();
	  $("#nrpCampoDiv").hide();
	 // $("#btnVentanillAfore").hide();
	  $("#spanEstatusMarca").hide();
	  $("#spanFechaIn").hide();
	  
	  if(radioCargado== "" || radioCargado== null){
		  $("#btnEnviarCargadoDiv").addClass('disabled_Url');
	    console.log("Entro en Deshabilitar");
	  }else{
		  console.log("Entro en Habilitar")
	  }
  }
	 
  function validarIcefasTrabajador(listaIcefasTrabajador){
	  if(jQuery.isEmptyObject(listaIcefasTrabajador) || listaIcefasTrabajador.length == 0){
		     console.log("Lista VACIA ICEFAS");
	   }else{
	    	 console.log("Lista CON ICEFAS:",listaIcefasTrabajador); 	    
	    	 window.location.href="#modalIcefasTrabajador";
	    	   
	       }
  }
  
    
  function validarNotNull(valor){
      if (!arguments[0])
            return false;
      return true;
  }
	
  function agregarMensajeRegimen(fct, mensjae){
	  $("input#tipoRegimen").addClass("invalid_dataBen");
	    $(fct).parents(".Form__Group:first").append("<center><span class='text_error'>"+ arguments[1]+"</span></center>");
	}
	
	function eliminarMensajeRegimen(fct){
		$("span.error_span").hide();
//		$("input#tipoRegimen").removeClass("invalid_dataBen");
//	    $(fct).parents(".Form__Group:first").find("span.text_error").remove();
	}
	
	function validarFechaIn(){
		$("#spanFechaIn").hide();
		var fecha = document.getElementById("fechaIncioPension").value;
		var fechaNueva = $.datepicker.parseDate("dd/mm/yy" , fecha);
		if(Date.parse(fechaNueva)>Date.now()){
	    	$("#spanFechaIn").show();
		}
	}

	function validarFechaEm(){
		$("#spanFechaEm").hide();
		var fecha = document.getElementById("fechaEmisionPensionT").value;
		var fechaNueva = $.datepicker.parseDate("dd/mm/yy" , fecha);
		if(Date.parse(fechaNueva)>Date.now()){
	    	$("#spanFechaEm").show();
		}
		
	}
  