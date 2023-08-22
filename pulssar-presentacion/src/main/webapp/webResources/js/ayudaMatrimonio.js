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
        autoclose:true,
        endDate: "today",
        maxDate: "today",
        minDate: new Date('01/07/1997'),
        changeMonth:true,
        changeYear:true,
        beforeShowDay: function(date){
            var string = jQuery.datepicker.formatDate('yy/mm/dd', date);
            return [ dateDisabled.indexOf(string) == -1 ];
        },
        onSelect: function(){
    		valida("fechaMatrimonio", "Fecha de matrimonio invalida");
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
	
	
	$("#btnSiguienteHola").click(function(e){
		
		var x = false;
		
		x = valida("fechaMatrimonio") ;
		x = valida("nombre") ;
		x = valida("apellidoPaterno") ;
		x = valida("sexoConyuge")  ;
		x = valida("entidadEmisionActa")  ;
		
		if(x){
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


