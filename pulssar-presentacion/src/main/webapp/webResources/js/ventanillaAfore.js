$(document).ready(function() {
	
	$("input#folioInfonavit").blur(function(event){
		val = document.getElementById("folioInfonavit").value;
		if(val.length==0){
			 eliminarMensajefolioInfonavit(this);
			 agregarMensajefolioInfonavit(this, "La captura de folio infonavit es requerida");
		}else{
			eliminarMensajefolioInfonavit(this);
		  }
	});
	  
	$("input#curpPago").blur(function(event){
	 let val = document.getElementById("curpPago").value;
	 console.log("Longitud curp:"+val.length);
	 if(val.length < '18' && val!=""){
		 eliminarMensajeCurpPagoLongitud(this);
		 agregarMensajeCurpPagoLongitud(this, "La longitud curp de pago es inválido");
	 }
	 
	 let flag = validarNotNull(val);
	 if(!flag){
			 eliminarMensajeCurpPago(this);
			 agregarMensajeCurpPago(this, "La captura curp de pago es requerida");
		}
	 eliminarMensajeCurpPagoLongitud(this);	
	});
	
	$("input#rfcPago").blur(function(event){
		val = document.getElementById("rfcPago").value;
		 var flag;
	         flag = validarNotNull(val);  
		if(!flag){
			eliminarMensajeRfcPago(this);
			 agregarMensajeRfcPago(this, "La captura rfc de pago es requerida");
		}else{
			eliminarMensajeRfcPago(this);
		  }
	});
	
	$("input#grupoTrabajador").blur(function(event){
		val = document.getElementById("grupoTrabajador").value;
		 var flag;
	         flag = validarNotNull(val);  
		if(!flag){
			eliminarMensajeGrupoTrabajador(this);
			 agregarMensajeGrupoTrabajador(this, "La captura grupo de trabajador es requerida");
		}else{
			 eliminarMensajeGrupoTrabajador(this);
		  }
	});
	
	$("input#apPaternoBeneficiario").blur(function(event){
		val = document.getElementById("apPaternoBeneficiario").value;
		 var flag;
	         flag = validarNotNull(val);  
		if(!flag){
			eliminarMensajeApPatBeneficiarioPago(this);
			 agregarMensajeApPatBeneficiarioPago(this, "La captura apellido paterno del beneficiario de pago es requerida");
		}else{
			  eliminarMensajeApPatBeneficviarioPago(this);
		  }
	});
	
	$("input#apMaternoBeneficiario").blur(function(event){
		val = document.getElementById("apMaternoBeneficiario").value;
		 var flag;
	         flag = validarNotNull(val);  
		if(!flag){
			 eliminarMensajeApMatBeneficiarioPago(this);
			 agregarMensajeApMatBeneficiarioPago(this, "La captura apellido materno del beneficiario de pago es requerida");
		}else{
			  eliminarMensajeApMatBeneficiarioPago(this);
		  }
	});
	
	$("input#nombreBeneficiario").blur(function(event){
		val = document.getElementById("nombreBeneficiario").value;
		 var flag;
	         flag = validarNotNull(val);  
		if(!flag){
			 eliminarMensajeNombreBeneficiarioPago(this);
			 agregarMensajeApNombreBeneficiarioPago(this, "La captura nombre del beneficiario de pago es requerida");
		}else{
			eliminarMensajeNombreBeneficiarioPago(this);
		  }
	});
	
	mostrarComboSolicitante();
    
});//Principal
    
    function agregarMensajeCurpPagoLongitud(fct,mensjae){
    	 $("input#curpPago").addClass("invalid_dataBen");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
    }

    function eliminarMensajeCurpPagoLongitud(fct){
    	console.log("Elimina msg curp longitud");
		$("span.error_span").hide();
	}
	
   
    function eliminarMensajeApPatBeneficviarioPago(fct){
    	console.log("Elimina apellido PAt Beneficiarios");
		$("span.error_span").hide();
	}
    
    
	function agregarMensajeApNombreBeneficiarioPago(fct, mensjae){
		   $("input#nombreBeneficiarioPago").addClass("invalid_dataBen");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function eliminarMensajeNombreBeneficiarioPago(fct){
		$("span.error_span").hide();
	}
	
	function eliminarMensajeNombreBeneficiarioPago(fct){
		$("span.error_span").hide();
	}

	function agregarMensajeApMatBeneficiarioPago(fct, mensjae){
		   $("input#apPatBeneficiarioPago").addClass("invalid_dataBen");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function eliminarMensajeApMatBeneficiarioPago(fct){
		$("span.error_span").hide();
	}
  
	function agregarMensajeApPatBeneficiarioPago(fct, mensjae){
		   $("input#apPatBeneficiarioPago").addClass("invalid_dataBen");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function eliminarMensajeApPatBeneficiarioPago(fct){
		$("span.error_span").hide();
	}


	function validaClabePago(){
		console.log("Entra ClabePAgo");
		let val= document.getElementById("clabePago").value;
		console.log(val);
		if(val==''){
			 eliminarMensajeClabe(this);
			 agregarMensajeCampoVacio(this, "La captura del campo Clabe de Pago es requerida");
			 console.log("Muestra Campo Vacio Clabe PAgo");
		}
		else{
		$.ajax({
				method   :"GET",
				url      :"validarDigitoVerificador.do?clabe="+$("#clabePago").val(),
				contentType:"application/json"
				})
				.success(function(data) {
					if(data.resultadoDeLaOperacion=="01"){
						console.log(data.diagnosticoDeRecepcion);
						var resultadoDiagnostico = data.diagnosticoDeRecepcion;
						eliminarMensajeClabe(this);
						$("#btnVentanillAfore").removeClass('disabled_Url');
						console.log("habilitar boton aceptar");
					}else{
					    eliminarMensajeClabe(this);
						agregarMensajeClabe("input#clabePago",data.diagnosticoDeRecepcion); 
						console.log(data.diagnosticoDeRecepcion);
					    $("#btnVentanillAfore").addClass('disabled_Url');
					}
				})
				.error(function(data) {
					console.log('ERROR AL VALIDAR EL DIGITO VERIFICADOR');
					$("#mensajeErrorClabe").text(data.diagnosticoDeRecepcion);
						
		    	});
	    }
	}

	function agregarMensajeCampoVacio(fct, mensjae){
		$("input#clabePago").addClass("invalid_dataBen");
		$(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
		console.log(arguments[1]);
	}
	
	function agregarMensajeClabe(fct, mensjae){
		   $("input#clabePago").addClass("invalid_dataBen");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function eliminarMensajeClabe(fct){
		$("span.error_span").hide();
	}
	
	function agregarMensajefolioInfonavit(fct, mensjae){
		   $("input#folioInfonavit").addClass("invalid_dataBen");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function eliminarMensajefolioInfonavit(fct){
		$("span.error_span").hide();
	}
 	
	function agregarMensajeCurpPago(fct, mensjae){
		   $("input#curpPago").addClass("invalid_dataBen");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function eliminarMensajeCurpPago(fct){
		console.log("Elimina msg curp requerida");
		$("span.error_span").hide();
	}
	
	
	function agregarMensajeRfcPago(fct, mensjae){
		   $("input#rfcPago").addClass("invalid_dataBen");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function eliminarMensajeRfcPago(fct){
		$("span.error_span").hide();
	}
	
	function agregarMensajeGrupoTrabajador(fct, mensjae){
		   $("input#grupoTrabajador").addClass("invalid_dataBen");
		   $(fct).parents(".Form__Group:first").append("<center><span class='error_span'>"+ arguments[1]+"</span></center>");
	}
	
	function eliminarMensajeGrupoTrabajador(fct){
		$("span.error_span").hide();
	}
	
	
	function validarNotNull(valor){
	       if (!arguments[0])
	             return false;
	       return true;
	}

	function agregarMensajeSolicitante(fct, mensjae){
		$("select#vSolicitante").addClass("invalid_dataBen");
	    $(fct).parents(".Form__Group:first").append("<center><span class='text_error'>"+ arguments[1]+"</span></center>");
	}
	
	function eliminarMensajeSolicitante(fct){
		$("select#vSolicitante").removeClass("invalid_dataBen");
	    $(fct).parents(".Form__Group:first").find("span.text_error").remove();
	}
	
    function mostrarComboSolicitante(){
	  console.log("Seleccionando TipoSolicitante ");
	  let cvSolicitante = document.getElementById("vSolicitante").value;// 01
	  let descripcionSolicitante = document.getElementById("descripcionSolicitante").value;//Trabajador
	  console.log("Clave Solicitante:"+cvSolicitante);
	  console.log("descripcionSolicitante:"+descripcionSolicitante);
	  	   
		 if(cvSolicitante==''){
			eliminarMensajeSolicitante(this);
			agregarMensajeSolicitante(this,"La seleccion del tipo solicitante es requerida");
		 }else if(cvSolicitante=='1'){
				console.log("Mostrar Campos Apellido Paterno del Beneficiario de Pago");
				 $('#EncabezadoBeneficiarioDiv').show();
				 $('#containerBeneficiarioDiv').show();
			  }else{
				  $('#EncabezadoBeneficiarioDiv').hide();
				  $('#containerBeneficiarioDiv').hide();
			  }
    }
    
    function mostrarVentanillaAfore(){
    	console.log("Funcion para seleccionar chebox ventanilla afore");
        let vf;
        if(vf=$('#ventanillaAfore:checked').val()!=null){
        	$('#EncabezadoVentanillaAfore').show();
        	$('#containderAforeDiv').show();
         }else{
        	$('#EncabezadoVentanillaAfore').hide();
        	$('#containderAforeDiv').hide();
        	$('#EncabezadoBeneficiarioDiv').hide();
    		$('#containerBeneficiarioDiv').hide();
    		
    		
        }
     } 
    