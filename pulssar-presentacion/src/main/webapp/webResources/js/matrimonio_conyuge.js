$(document).ready(function() {
	var dateDisabled = ["0001/01/01"];
	
	if ($('#mensaje').val() != "") {
		$("#mensajeErrorModal").text($('#mensaje').val());
		window.location.href = "#errorModal";
	}
	
	$('#btnErrorM').click(function(event) {
		window.location.href = "datosGenerales.do";
	});
	
	$( "#fechaMatrimonio" ).datepicker({
        dateFormat: 'dd/mm/yy',
        altFormat: 'dd/mm/yy',
        autoclose:true,
        endDate: "today",
        maxDate: "today",
        minDate: new Date(1997, 6, 17),        
        changeMonth:true,
        changeYear:true,    
        constrainInput: true,    
        onSelect: function(){
    		valida("fechaMatrimonio", "Fecha de matrimonio incorrecta");
        }
	});
	
	
	
	$( "#fechaMatrimonio" ).on("input", function(){
		valida("fechaMatrimonio");
	});
	
	$( "#nombre" ).on("input", function(){
		valida("nombre");
	});
	
	
	$( "#apellidoPaterno" ).on("input", function(){
		valida("apellidoPaterno");
	});
		
	$( "#sexoConyuge" ).on("input", function(){
		valida("sexoConyuge");
	});
	
	$( "#entidadEmisionActa" ).on("input", function(){
		valida("entidadEmisionActa");
	});
	
	
	$("#btnSiguiente").click(function(e){
		
		var dateString = $("#fechaMatrimonio").val(); 
		var dateParts = dateString.split("/");
		var fecSel = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]); 
		var fec1997 = new Date(1997, 6, 17);
		
		if(fecSel<fec1997){
			$("#fechaMatrimonio").val('');	
		}
		
		valida("fechaMatrimonio") ;
		valida("nombre") ;
		valida("apellidoPaterno") ;
		valida("sexoConyuge")  ;
		valida("entidadEmisionActa")  ;
		
		$("#descSexo").val($("#sexoConyuge option:selected").text());
		$("#descEntidadEmisionActa").val($("#entidadEmisionActa option:selected").text())
		console.log($("#sexoConyuge option:selected").text());
		console.log($("#entidadEmisionActa option:selected").text());
		
		console.log($("#descSexo").val());
		console.log($("#descEntidadEmisionActa").val());
		
//		if(x){
//			$("#formSalida" ).submit();	
//		}
		
		if(valida("fechaMatrimonio") && valida("nombre") && valida("apellidoPaterno")&& valida("sexoConyuge")&&valida("entidadEmisionActa")){
			$("#formSalida" ).submit();	
		}
		
	});
	

	
	function valida(id){
		var x = $("#"+id).val();
		if(x=="" || x==-1){
			$("#"+id ).addClass("Inputerror");
		    $("#"+id+"Error").show();
		   
			return false;
		}else{
			$("#"+id ).removeClass("Inputerror");
			$("#"+id+"Error").hide();
			return true;
		}
	}
	
	
});


