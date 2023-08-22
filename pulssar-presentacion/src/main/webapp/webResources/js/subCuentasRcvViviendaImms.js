$(document).ready(function() {
	$("#montoTotalRcv").text("$0");
	$("#montoTotalViv").text("$0")
	$("#spanSubcuentas").hide();
	$("#borrarTabla").val("0")
  
});//function General	  
    
   function construirTablaRcv(listaCuentas){
	   
	 if(listaCuentas!=null) { 
		 $("#subCuentasErrorRcv").hide();
	     var tableRCV = '';
		 var sief="sief";
		 tableRCV += '<thead>';
		 tableRCV += '<tr class="RowHeader">';
		 tableRCV += '<th class="th_tabla">Subcuentas RCV</th>';
		 tableRCV += '<th class="th_tabla">Clave</th>';
		 tableRCV += '<th class="th_tabla">Monto</th>';
		 tableRCV += '<th class="th_tabla">Acciones</th>';
		 tableRCV += '<th class="th_tabla">Fecha Valor</th>';
		 tableRCV += '<th class="th_tabla">Precio de Acciones</th>';
		 tableRCV += '<th class="th_tabla">Siefores</th>';
		 tableRCV += '<th class="th_tabla">Eliminar</th>';
		 tableRCV += '</tr>';
		 tableRCV += '</thead>';
		 tableRCV += '<tbody>';
		 for(var i = 0; i<listaCuentas.length; i++){
			 if(i % 2 == 0){
				 tableRCV +=  '<tr class="Row1">';
			 }else{
				 tableRCV +=  '<tr class="Row2">';
			 }
			 tableRCV += '<td class="td_tabla">'+listaCuentas[i].descripcionSubcuenta+'</td>';
			 tableRCV += '<td class="td_tabla"> '+listaCuentas[i].claveSubcuenta+'</td>';
			 tableRCV += '<td class="td_tabla"><input class="Inputxxl" id="montoRcv'+i+'" type="text" name=""  value="'+listaCuentas[i].monto+'" placeholder="Monto" onkeydown="delayedCalculoRcv('+listaCuentas[i].monto+','+i+','+listaCuentas[i].campoSar+')" onKeyPress="return soloNumerosMonto(event,this)" maxlength="10" onpaste="return false" disabled="true" ></td>';
			 tableRCV += '<td class="td_tabla" id="acciones'+i+'">'+listaCuentas[i].acciones+'</td>';
			 tableRCV += '<td class="td_tabla" id="fechaValor'+i+'">'+listaCuentas[i].fechaValor+'</td>';
			 tableRCV += '<td class="td_tabla" id="precioAccion'+i+'">'+listaCuentas[i].precioAccion+'</td>';
			 tableRCV += '<td class="td_tabla"><input class="Inputxxl" id="siefore'+i+'" type="text" name=""  value="Click aquí" placeholder="" onclick="seleccionarSiefore('+i+')" readonly></td>';
			 tableRCV += '<td class="td_tabla"> <p class="Link_blue" href="#"><a onclick="eliminarFilaRcv(this, '+i+')"><img  style="width:30px;" src="../webResources/img/error.png" alt="icon_eliminar"/></a></p></td>';
			 tableRCV += '</tr>';
		 }
		
		 tableRCV += '</tbody>';
         
		 $("#tableRcv").append(tableRCV);
		 tablaRcvPaginacion();
		 $("#tablasSub").show();
	 }
 } 
   
   
   function construirTablaRcvDos(listaCuentas){
		 var tableRCV = '';
		 var sief="sief";
		 tableRCV += '<tbody>';
		 for(var i = 0; i<listaCuentas.length; i++){
			 if(i % 2 == 0){
				 tableRCV +=  '<tr class="Row1">';
			 }else{
				 tableRCV +=  '<tr class="Row2">';
			 }
			 tableRCV += '<td class="td_tabla">'+listaCuentas[i].descripcionSubcuenta+'</td>';
			 tableRCV += '<td class="td_tabla"> '+listaCuentas[i].claveSubcuenta+'</td>';
			 tableRCV += '<td class="td_tabla"><input class="Inputxxl" id="montoRcv'+i+'" type="text" name=""  value="'+listaCuentas[i].monto+'" placeholder="Monto" onkeydown="delayedCalculoRcv('+listaCuentas[i].monto+','+i+','+listaCuentas[i].campoSar+')" onKeyPress="return soloNumerosMonto(event,this)" maxlength="10" onpaste="return false" disabled="true" ></td>';
			 tableRCV += '<td class="td_tabla" id="acciones'+i+'">'+listaCuentas[i].acciones+'</td>';
			 tableRCV += '<td class="td_tabla" id="fechaValor'+i+'">'+listaCuentas[i].fechaValor+'</td>';
			 tableRCV += '<td class="td_tabla" id="precioAccion'+i+'">'+listaCuentas[i].precioAccion+'</td>';
			 tableRCV += '<td class="td_tabla"><input class="Inputxxl" id="siefore'+i+'" type="text" name=""  value="Click aquí" placeholder="" onclick="seleccionarSiefore('+i+')" readonly></td>';
			 tableRCV += '<td class="td_tabla"> <p class="Link_blue" href="#"><a onclick="eliminarFilaRcv(this, '+i+')"><img  style="width:30px;" src="../webResources/img/error.png" alt="icon_eliminar"/></a></p></td>';
			 tableRCV += '</tr>';
		 }
		
		 tableRCV += '</tbody>';

		 $("#tableRcv").append(tableRCV);
		 tablaRcvPaginacion();
		 $("#tablasSub").show();
 } 

   
   function eliminarFilaRcv(el, i){
		 var index = $(el).parent().parent();
		 var table = $("#tableRcv").dataTable();
		 var tablaRcv = $("#tableRcv").DataTable();
		 var totalRcv = tablaRcv.rows().count();
		 table.fnDeleteRow(index);
		 var tipoRecurso="sief";
		 if(tipoRecurso == "sief"){
			 if(totalRcv > 0){
				 montoTotalSumaRcv();
			 }
		 }else{
			 $("#montoTotalRcv").text("$0");
		 }
		 
		 var tablaViv = $("#tablaVivienda").DataTable();
		 var totalViv = tablaViv.rows().count();
		 var montoTotalRcv = $("#montoTotalRcv").text();
		 montoTotalRcv = montoTotalRcv.replace("$","");
		 
		 var montoTotalViv = $("#montoTotalViv").text();
		 montoTotalViv = montoTotalViv.replace("$","");
		 
		 if(totalRcv<1 && totalViv<1){
			 $("#spanSubcuentas").show();
			 $("#btnMostrarModalCaptura").addClass('disabled_Url');
		 }else{
			 $("#spanSubcuentas").hide();
			 $("#btnMostrarModalCaptura").removeClass('disabled_Url');
		 }
		 
		 if(parseFloat(montoTotalRcv)<1 && parseFloat(montoTotalViv)<1){
			 $("#spanSubcuentas").show();
			 $("#btnMostrarModalCaptura").addClass('disabled_Url');
		 }else{
			 $("#spanSubcuentas").hide();
			 $("#btnMostrarModalCaptura").removeClass('disabled_Url');
		 }
	 }
   
   function construirTablaVivienda(listaViviendaImss,estatusMarcaImss){
	  
	   var tableVivienda = '';
		 tableVivienda += '<thead>';
		 tableVivienda += '<tr class="RowHeader">';
		 tableVivienda += '<th class="th_tabla">Subcuentas Vivienda</th>';
		 tableVivienda += '<th class="th_tabla">Clave</th>';
		 tableVivienda += '<th class="th_tabla">Monto</th>';
		 tableVivienda += '<th class="th_tabla">Acciones</th>';
		 tableVivienda += '<th class="th_tabla">Fecha Valor</th>';
		 tableVivienda += '<th class="th_tabla">Precio de Acciones</th>';
		 tableVivienda += '<th class="th_tabla">Eliminar</th>';
		 tableVivienda += '</tr>';
		 tableVivienda += '</thead>';
		 tableVivienda += '<tbody>';
	   
		console.log(listaViviendaImss);

		  if(estatusMarcaImss.cvEstatusVivienda=="1" ){
		    		 
		    	  for(var i = 0; i<listaViviendaImss.length; i++){
						 if(i % 2 == 0){
							 tableVivienda +=  '<tr class="Row1" id="trViv'+i+'">';
						 }else{
							 tableVivienda +=  '<tr class="Row2" id="trViv'+i+'">';
						 }
						 tableVivienda += '<td class="td_tabla">'+listaViviendaImss[i].descripcionSubcuenta+'</td>';
						 tableVivienda += '<td class="td_tabla"> '+listaViviendaImss[i].claveSubcuenta+'</td>';
						 if(listaViviendaImss[i].sinPrecioAccion == "SINPRECIOACCION"){
							 tableVivienda += '<td class="td_tabla"> <input class="Inputxxl" id="montoViv'+i+'" type="text" name=""  value="'+listaViviendaImss[i].monto+'" placeholder="Monto"   maxlength="10" readonly></td>';
						 }else{
							 tableVivienda += '<td class="td_tabla"> <input class="Inputxxl" id="montoViv'+i+'" type="text" name=""  value="'+listaViviendaImss[i].monto+'" placeholder="" onkeydown="validarRangoAcciones('+i+', '+listaViviendaImss[i].precioAccion+', '+listaViviendaImss[i].tabla+', '+listaViviendaImss[i].monto+', '+listaViviendaImss[i].acciones+')" onKeyPress="return soloNumerosMonto(event,this)" maxlength="10" onpaste="return false"></td>'; 
						 }
						 tableVivienda += '<td class="td_tabla"><input class="Inputxxl" id="accionesSar'+i+'" type="text" name=""  value="'+listaViviendaImss[i].acciones+'" placeholder="" onchange="" readonly></td>';
						 tableVivienda += '<td class="td_tabla">'+listaViviendaImss[i].fechaValor+'</td>';
						 
						 if(listaViviendaImss[i].sinPrecioAccion == "SINPRECIOACCION"){
							 tableVivienda += '<td class="td_tabla"><p class="error_span">No existe valor para conversión de subcuenta en pesos</p></td>';
						 }else{
							 tableVivienda += '<td class="td_tabla">'+listaViviendaImss[i].precioAccion+'</td>';
						 }
						 
						 
						 tableVivienda += '<td class="td_tabla"> <p class="Link_blue" href="#"><a  onclick="eliminarFilaViv(this, '+i+', \''+listaViviendaImss[i].sinPrecioAccion+'\')"><img  style="width:30px;" src="../webResources/img/error.png" alt="icon_eliminar"/></a></p></td>';
						 tableVivienda += '</tr>';
					 }
		    	  $("#spanEstatusMarca").hide(); 
		    	  $("#marcasErrorVivienda").hide(); 
		    	  $("#subCuentasErrorVivienda").hide(); 
		    	  
		    	  $("#montoTotalDiv").show();
		    	  
			 tableVivienda += '</tbody>';
			 $("#tablaVivienda").append(tableVivienda);
			 tablaViviendaPaginacion(); 
		}

	
	if(listaViviendaImss=null){
		 $("#montoTotalVivDiv").hide(); 
   		 var tableVivienda = '';
   		 tableVivienda += '<thead>';
 		 tableVivienda += '<tr class="RowHeader">';
 		 tableVivienda += '<th class="th_tabla">Subcuentas Vivienda</th>';
 		 tableVivienda += '<th class="th_tabla">Clave</th>';
 		 tableVivienda += '<th class="th_tabla">Monto</th>';
 		 tableVivienda += '<th class="th_tabla">Acciones</th>';
 		 tableVivienda += '<th class="th_tabla">Fecha Valor</th>';
 		 tableVivienda += '<th class="th_tabla">Precio de Acciones</th>';
 		 tableVivienda += '<th class="th_tabla">Eliminar</th>';
 		 tableVivienda += '</tr>';
 		 tableVivienda += '</thead>';
 		 tableVivienda += '<tbody>';
 		
 		$("#subCuentasErrorVivienda").show(); 		 
   		 tableVivienda += '</tbody>';
   			 $("#tablaVivienda").append(tableVivienda);
	}	 
		 
		 
		 
	if(estatusMarcaImss==null){
		 $("#montoTotalVivDiv").hide(); 
   		 var tableVivienda = '';
   		 tableVivienda += '<thead>';
 		 tableVivienda += '<tr class="RowHeader">';
 		 tableVivienda += '<th class="th_tabla">Subcuentas Vivienda</th>';
 		 tableVivienda += '<th class="th_tabla">Clave</th>';
 		 tableVivienda += '<th class="th_tabla">Monto</th>';
 		 tableVivienda += '<th class="th_tabla">Acciones</th>';
 		 tableVivienda += '<th class="th_tabla">Fecha Valor</th>';
 		 tableVivienda += '<th class="th_tabla">Precio de Acciones</th>';
 		 tableVivienda += '<th class="th_tabla">Eliminar</th>';
 		 tableVivienda += '</tr>';
 		 tableVivienda += '</thead>';
 		 tableVivienda += '<tbody>';
 		$("#marcasErrorVivienda").show(); 		 
   		 tableVivienda += '</tbody>';
   			 $("#tablaVivienda").append(tableVivienda);
	}	 
		 
		 /* Estatus de vivienda 2- El saldo a mostrar en las subcuentas de vivienda es igual a cero,
   		  *  no se permitirá que el Agente ingrese un monto mayor a cero en Viviendas. */
   		 /*	Para Estatus 2: "Subcuenta de Vivienda NO disponible con crédito de vivienda".*/
   		 
	 
   		 if( (estatusMarcaImss.cvEstatusVivienda=="2")  ){
   		 $("#montoTotalVivDiv").hide(); 
   		 var tableVivienda = '';
   		 
 		 tableVivienda += '<thead>';
 		 tableVivienda += '<tr class="RowHeader">';
 		 tableVivienda += '<th class="th_tabla">Subcuentas Vivienda</th>';
 		 tableVivienda += '<th class="th_tabla">Clave</th>';
 		 tableVivienda += '<th class="th_tabla">Monto</th>';
 		 tableVivienda += '<th class="th_tabla">Acciones</th>';
 		 tableVivienda += '<th class="th_tabla">Fecha Valor</th>';
 		 tableVivienda += '<th class="th_tabla">Precio de Acciones</th>';
 		 tableVivienda += '<th class="th_tabla">Eliminar</th>';
 		 tableVivienda += '</tr>';
 		 tableVivienda += '</thead>';
 		 tableVivienda += '<tbody>';
  		 $("#spanEstatusMarca").show(); 		 
   		 tableVivienda += '</tbody>';
   			 $("#tablaVivienda").append(tableVivienda);
   			       
	      }
   		 
  		
   		    /*	Estatus de vivienda 3- Solo se muestra el saldo de la subcuenta que asocia y se  permitirá la captura 
   		     * de importe para la subcuenta VIV92.
            */ 
   		
	    
   		 if(estatusMarcaImss.cvEstatusVivienda=="3" ){
   		     let eliminar04="04";
   		     let eliminar07="07";
   		   		listaViviendaImss =listaViviendaImss.filter(function(dato){
   		   			console.log(listaViviendaImss);
   		   			if(dato.claveSubcuenta==eliminar04 || dato.claveSubcuenta==eliminar07 ){
   		   			return false;
   		   			  }else{
   		   			return true;
   		   			}
   		   		});
   		            var tableVivienda = '';
   		             tableVivienda += '<thead>';
		   	 		 tableVivienda += '<tr class="RowHeader">';
		   	 		 tableVivienda += '<th class="th_tabla">Subcuentas Vivienda</th>';
		   	 		 tableVivienda += '<th class="th_tabla">Clave</th>';
		   	 		 tableVivienda += '<th class="th_tabla">Monto</th>';
		   	 		 tableVivienda += '<th class="th_tabla">Acciones</th>';
		   	 		 tableVivienda += '<th class="th_tabla">Fecha Valor</th>';
		   	 		 tableVivienda += '<th class="th_tabla">Precio de Acciones</th>';
		   	 		 tableVivienda += '<th class="th_tabla">Eliminar</th>';
		   	 		 tableVivienda += '</tr>';
		   	 		 tableVivienda += '</thead>';
		   	 		 tableVivienda += '<tbody>';
   		   	        $("#spanEstatusMarca").hide();
			    	  for(var i = 0; i<listaViviendaImss.length; i++){
							 if(i % 2 == 0){
								 tableVivienda +=  '<tr class="Row1" id="trViv'+i+'">';
							 }else{
								 tableVivienda +=  '<tr class="Row2" id="trViv'+i+'">';
							 }
							 tableVivienda += '<td class="td_tabla">'+listaViviendaImss[i].descripcionSubcuenta+'</td>';
							 tableVivienda += '<td class="td_tabla"> '+listaViviendaImss[i].claveSubcuenta+'</td>';
							 if(listaViviendaImss[i].sinPrecioAccion == "SINPRECIOACCION"){
								 tableVivienda += '<td class="td_tabla"> <input class="Inputxxl" id="montoViv'+i+'" type="text" name=""  value="'+listaViviendaImss[i].monto+'" placeholder="Monto"   maxlength="10" readonly></td>';
							 }else{
								 tableVivienda += '<td class="td_tabla"> <input class="Inputxxl" id="montoViv'+i+'" type="text" name=""  value="'+listaViviendaImss[i].monto+'" placeholder="" onkeydown="validarRangoAcciones('+i+', '+listaViviendaImss[i].precioAccion+', '+listaViviendaImss[i].tabla+', '+listaViviendaImss[i].monto+', '+listaViviendaImss[i].acciones+')" onKeyPress="return soloNumerosMonto(event,this)" maxlength="10" onpaste="return false"></td>'; 
							 }
							 tableVivienda += '<td class="td_tabla"><input class="Inputxxl" id="accionesSar'+i+'" type="text" name=""  value="'+listaViviendaImss[i].acciones+'" placeholder="" onchange="" readonly></td>';
							 tableVivienda += '<td class="td_tabla">'+listaViviendaImss[i].fechaValor+'</td>';
							 
							 if(listaViviendaImss[i].sinPrecioAccion == "SINPRECIOACCION"){
								 tableVivienda += '<td class="td_tabla"><p class="error_span">No existe valor para conversión de subcuenta en pesos</p></td>';
							 }else{
								 tableVivienda += '<td class="td_tabla">'+listaViviendaImss[i].precioAccion+'</td>';
							 }
							 
							 
							 tableVivienda += '<td class="td_tabla"> <p class="Link_blue" href="#"><a  onclick="eliminarFilaViv(this, '+i+', \''+listaViviendaImss[i].sinPrecioAccion+'\')"><img  style="width:30px;" src="../webResources/img/error.png" alt="icon_eliminar"/></a></p></td>';
							 tableVivienda += '</tr>';
						 }
			    	  
			    	let montoTotalViv72 =  listaViviendaImss[0].monto;
			    	document.getElementById('montViv').innerHTML=montoTotalViv72;
			        $("#montoTotalViv").hide();	
				 tableVivienda += '</tbody>';
				 $("#tablaVivienda").append(tableVivienda);
				 tablaViviendaPaginacion(); 
   		     }
		 
   		     
   	
	           
   }
   
   
   
   function construirTablaViviendaDos(listaViviendaImss,estatusMarcaImss){
	   var tableVivienda = '';
		 tableVivienda += '<tbody>';
		   			     
		 /* Estatus de vivienda 2- El saldo a mostrar en las subcuentas de vivienda es igual a cero,
   		  *  no se permitirá que el Agente ingrese un monto mayor a cero en Viviendas. */
   		 /*	Para Estatus 2: "Subcuenta de Vivienda NO disponible con crédito de vivienda".*/
   		
		 
	if(estatusMarcaImss!=null){	 
   		 if( (estatusMarcaImss.cvEstatusVivienda=="2")  ){
   				 tableVivienda +=  '<tr class="td_tabla"><p class="spanEstatusMarca">Subcuenta de Vivienda NO disponible con crédito de vivienda</p>';
	    		 $("#montoTotalDiv").hide();
	      }
   		 
   }		
   		
	if(estatusMarcaImss!=null){		    
   		 if(estatusMarcaImss.cvEstatusVivienda=="3" ){
   		     let eliminar="04";
   		   		listaViviendaImss =listaViviendaImss.filter(function(dato){
   		   			if(dato.claveSubcuenta==eliminar){
   		   				return false;
   		   			}else{
   		   				return true;
   		   			}
   		   		});
   		   	 console.log(listaViviendaImss);
   		      }
	}	 
   		     
	    		  $("#spanEstatusMarca").hide();
	    	  for(var i = 0; i<listaViviendaImss.length; i++){
					 if(i % 2 == 0){
						 tableVivienda +=  '<tr class="Row1" id="trViv'+i+'">';
					 }else{
						 tableVivienda +=  '<tr class="Row2" id="trViv'+i+'">';
					 }
					 tableVivienda += '<td class="td_tabla">'+listaViviendaImss[i].descripcionSubcuenta+'</td>';
					 tableVivienda += '<td class="td_tabla"> '+listaViviendaImss[i].claveSubcuenta+'</td>';
					 if(listaViviendaImss[i].sinPrecioAccion == "SINPRECIOACCION"){
						 tableVivienda += '<td class="td_tabla"> <input class="Inputxxl" id="montoViv'+i+'" type="text" name=""  value="'+listaViviendaImss[i].monto+'" placeholder="Monto"   maxlength="10" readonly></td>';
					 }else{
						 tableVivienda += '<td class="td_tabla"> <input class="Inputxxl" id="montoViv'+i+'" type="text" name=""  value="'+listaViviendaImss[i].monto+'" placeholder="" onkeydown="validarRangoAcciones('+i+', '+listaViviendaImss[i].precioAccion+', '+listaViviendaImss[i].tabla+', '+listaViviendaImss[i].monto+', '+listaViviendaImss[i].acciones+')" onKeyPress="return soloNumerosMonto(event,this)" maxlength="10" onpaste="return false"></td>'; 
					 }
					 tableVivienda += '<td class="td_tabla"><input class="Inputxxl" id="accionesSar'+i+'" type="text" name=""  value="'+listaViviendaImss[i].acciones+'" placeholder="" onchange="" readonly></td>';
					 tableVivienda += '<td class="td_tabla">'+listaViviendaImss[i].fechaValor+'</td>';
					 
					 if(listaViviendaImss[i].sinPrecioAccion == "SINPRECIOACCION"){
						 tableVivienda += '<td class="td_tabla"><p class="error_span">No existe valor para conversión de subcuenta en pesos</p></td>';
					 }else{
						 tableVivienda += '<td class="td_tabla">'+listaViviendaImss[i].precioAccion+'</td>';
					 }
					 
					 
					 tableVivienda += '<td class="td_tabla"> <p class="Link_blue" href="#"><a  onclick="eliminarFilaViv(this, '+i+', \''+listaViviendaImss[i].sinPrecioAccion+'\')"><img  style="width:30px;" src="../webResources/img/error.png" alt="icon_eliminar"/></a></p></td>';
					 tableVivienda += '</tr>';
				 }
		 
	    	  $("#montoTotalDiv").show();
		 tableVivienda += '</tbody>';
		 $("#tablaVivienda").append(tableVivienda);
		 tablaViviendaPaginacion(); 
    
	           
   }
   
   function eliminarFilaViv(el, i, sinPrecioAccion){
		 var index = $(el).parent().parent();
		 var table = $("#tablaVivienda").dataTable();
		 table.fnDeleteRow(index);
		 if(sinPrecioAccion != "SINPRECIOACCION"){
			 montoTotalSumaViv();
		 }
		 
		 var tablaRcv = $("#tableRcv").DataTable();
		 var totalRcv = tablaRcv.rows().count();
		 var tablaViv = $("#tablaVivienda").DataTable();
		 var totalViv = tablaRcv.rows().count();
		 var montoTotalRcv = $("#montoTotalRcv").text();
		 montoTotalRcv = montoTotalRcv.replace("$","");
		 
		 var montoTotalViv = $("#montoTotalViv").text();
		 montoTotalViv = montoTotalViv.replace("$","");
		 
		 if(totalRcv<1 && totalViv<1){
			 $("#spanSubcuentas").show();
			 $("#btnMostrarModalCaptura").addClass('disabled_Url');
		 }else{
			 $("#spanSubcuentas").hide();
			 $("#btnMostrarModalCaptura").removeClass('disabled_Url');
		 }
		 
		 if(parseFloat(montoTotalRcv)<1 && parseFloat(montoTotalViv)<1){
			 $("#spanSubcuentas").show();
			 $("#btnMostrarModalCaptura").addClass('disabled_Url');
		 }else{
			 $("#spanSubcuentas").hide();
			 $("#btnMostrarModalCaptura").removeClass('disabled_Url');
		 }
		 
	 }
   
   
   function validarRangoAcciones(i, precioAccion, tabla, montoOriginal, accionOriginal){
	   delayedCalculoAcciones(i, precioAccion, tabla, montoOriginal, accionOriginal);
	 }
   
   var timeOutID;
   function delayedCalculoAcciones(i, precioAccion, tabla, montoOriginal, accionOriginal){
   	timeOutID = window.setTimeout(function(){calculoAccionesGen(i, precioAccion, tabla, montoOriginal, accionOriginal)}, 4000);
   }
   
   function calculoAccionesGen(i, precioAccion, tabla, montoOriginal, accionOriginal){
	     var montoNombre = "";
		 var nombre = ""; 
			 montoNombre = "montoViv"+i;
			 nombre = "#accionesSar"+i; 
		 
			 var monto = document.getElementById(montoNombre).value;
			 

		   if(parseFloat(monto)<=parseFloat(montoOriginal)){
						 if(monto.length < 1){
							 $("#"+montoNombre).val("0");
							 monto = "0";
						  }	
						 
						
						 if(monto.indexOf('.') >= 0){
							 var montoRcvAgregar = monto.split('.');
							 var montoRcvEnt = montoRcvAgregar[0];
							 var montoRcvDecim = montoRcvAgregar[1];
							 if(montoRcvDecim.length < 1 && montoRcvEnt.length > 0){
								 $("#"+montoNombre).val(montoRcvEnt+".0");
								 monto = montoRcvEnt+".0";
							  }	
							 
							 if(montoRcvEnt.length < 1 && montoRcvDecim.length > 0){
								 $("#"+montoNombre).val("0."+montoRcvDecim);
								 monto = "0."+montoRcvDecim;
							  }	
							 
							 if(montoRcvEnt.length < 1 && montoRcvDecim.length < 1){
								 $("#"+montoNombre).val("0.0");
								 monto = "0.0";
							  }	
						 }
						 
						 var accionF = parseFloat(monto)/parseFloat(precioAccion);
						 var accion = accionF.toString();
						 var accionCompleto = accion.split('.');
						 var enterosAccion = accionCompleto[0];
						 if(accion.indexOf('.') >= 0){
							 accionF = Math.round(accionF*100)/100;
							 accion = accionF.toString();
							 accionCompleto = accion.split('.');
							 enterosAccion = accionCompleto[0];
							 var decimalesAccion = accionCompleto[1];
							if(enterosAccion.length > 8){
								enterosAccion = enterosAccion.substring(0, 8);
							}
							
							if(decimalesAccion.length > 6){
								decimalesAccion = decimalesAccion.substring(0, 6);
							}	
							$(nombre).val(enterosAccion+"."+decimalesAccion);
						 }else{
							 if(enterosAccion.length > 8){
								
								 enterosAccion = enterosAccion.substring(0, 8);
								}
							 $(nombre).val(enterosAccion);
						 }
					 }else{
						 $("#"+montoNombre).val(montoOriginal);
						 $(nombre).val(accionOriginal);
					 }
				 montoTotalSumaViv();
		
	}

   
   function montoTotalSumaViv(){
		var tabla = $("#tablaVivienda").DataTable();
		var total = tabla.rows().count();
		var table = $("#tablaVivienda").DataTable();
		
		var cell = [];
		if(total > 0){
			for(var i=0;i<total;i++){
				var sinPrecioAccion = table.cell(i, 3).nodes().to$().find('input').val();
				if(sinPrecioAccion != ''){
				  cell.push(table.cell(i, 2).nodes().to$().find('input').val());
				}
			}
			console.log(cell);
			var sumaTotal=0;
			for(var j=0;j<cell.length;j++){
				sumaTotal +=parseFloat(cell[j]);
				console.log("sumaTotal:"+sumaTotal);
			}
			
			if(sumaTotal.toString().indexOf('.') >= 0){
				sumaTotal = Math.round(sumaTotal*100)/100;
				var sumT = sumaTotal.toString();
				$("#montoTotalViv").text("$"+sumT);
				console.log("Suma Viv:"+sumT);
			}else{
				var sumT = sumaTotal.toString();
				$("#montoTotalViv").text("$"+sumT);
				console.log("Suma Viv else :"+sumT);
			}
			
		}else{
			$("#montoTotalViv").text("$0");
		}
	}

   
   function tablaViviendaPaginacion(){
		 var table = $('#tablaVivienda').DataTable({
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
   
   function tablaRcvPaginacion(){
		 
		 var table = $('#tableRcv').DataTable({
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
	 
   function destruirDatatabled(){
		 $('#tableRcv').dataTable().fnDestroy();
		 //$('#tablaVivienda').dataTable().fnDestroy();
	 }
   
   function destruirDatatabledViv(){
		 $('#tablaVivienda').dataTable().fnDestroy();
	 }
   
   let abiertoDos = false;

   function sectionone(){
     if(abiertoDos==false){
     document.getElementById("section_one").style.display = "block";	 
     abiertoDos = true;
   }else{
     document.getElementById("section_one").style.display = "none";
     abiertoDos = false;
     }
   }
   
   let abiertoTres = false;
   function section_two(){
	   if(abiertoTres==false){
	   document.getElementById("section_two").style.display = "block";
	   abiertoTres = true;
	 }else{
	   document.getElementById("section_two").style.display = "none";
	   abiertoTres = false;
	   }
	 }
   
   function soloNumerosMonto(e, input){
		var key = window.Event ? e.which : e.keyCode;
		var chark = String.fromCharCode(key);
		var tempValue = input.value+chark;
		if(key == 46){
			var preg = /^([0-9]+\.?[0-9]{0,1})$/;
			if(preg.test(tempValue) === false){
				return false;
			}
		}
		return ((key >= 48 && key <= 57) || (key==8) || (key==46))
	}
   
   function seleccionarSiefore(i, campoSar){
		 $("#aceptarSiefor").addClass('disabled_Url');
		$("#valorSieforeTemporal").val(i);
		if(document.getElementById("siefore"+i).value != "Click aquí"){
			$("#siefores").val(document.getElementById("siefore"+i).value);
		}else{
			$("#siefores").val("0");
		}
		document.getElementById("valorPosicion").innerHTML = i;
		document.getElementById("valorCampoSar").innerHTML = i;
		document.getElementById("valorPosicion").style.display="none";
		document.getElementById("valorCampoSar").style.display="none";
//		document.getElementById("tipoRecurso").style.display="none";
		window.location.href = "#miOpcionSiefores";
		  $("#miOpcionSiefores").show();
	}
	   
   function aceptarSiefore(){
		var tablaRcv = $("#tableRcv").DataTable();
		var totalRcv = tablaRcv.rows().count();
		if(document.getElementById("siefores").value == "0"){
			$("#siefore"+document.getElementById("valorPosicion").innerHTML).val("Click aquí");
			 for(var j=0;j<totalRcv;j++){
					var  monto = tablaRcv.cell(j, 2).data();
					 if(monto.indexOf("montoRcv"+document.getElementById("valorPosicion").innerHTML) >= 0){
					   tablaRcv.cell("#precioAccion"+document.getElementById("valorPosicion").innerHTML).data("").draw();
					   tablaRcv.cell("#acciones"+document.getElementById("valorPosicion").innerHTML).data("").draw();
					   tablaRcv.cell("#fechaValor"+document.getElementById("valorPosicion").innerHTML).data("").draw();
					   break;
					 } 
				 }
			 $("#montoRcv"+document.getElementById("valorPosicion").innerHTML).attr("disabled","disabled");
			 if(totalRcv > 0){
				 montoTotalSumaRcv();
			 }
		}else{
			document.getElementById("valorPosicion").style.display="block";
			document.getElementById("valorCampoSar").style.display="block";
			$("#siefore"+document.getElementById("valorPosicion").innerHTML).val(document.getElementById("siefores").value);
			$("#montoRcv"+document.getElementById("valorPosicion").innerHTML).removeAttr("disabled");
			consultarPrecioAccionRcv(document.getElementById("siefores").value, document.getElementById("valorPosicion").innerHTML, document.getElementById("valorCampoSar").innerHTML);
		}
		
	}
   

   function consultarPrecioAccionRcv(sieforeClave, i,campoSar){ 
		var tablaRcv = $("#tableRcv").DataTable();
		var totalRcv = tablaRcv.rows().count();
		console.log("sieforeClave:"+sieforeClave);
		$.ajax({
			method : "GET",
			url : "obtenerPrecioAccionSiefore.do",
			contentType : "application/json",
			data : {
				claveSiefore :sieforeClave
			}
		}).success(function(data) {
			console.log(data.flujo);
			if(data.flujo == 1) {
				var mens = data.mensaje;
				 if(mens == "SINPRECIOACCION"){
					 for(var j=0;j<totalRcv;j++){
						var  monto = tablaRcv.cell(j, 2).data();
						 if(monto.indexOf("montoRcv"+i) >= 0){
						   tablaRcv.cell("#precioAccion"+i).data("<p class='error_span'>No existe valor para conversión de subcuenta en pesos</p>").draw();
						   tablaRcv.cell("#acciones"+i).data("").draw();
						   tablaRcv.cell("#fechaValor"+i).data("").draw();
						   $("#montoRcv"+document.getElementById("valorPosicion").innerHTML).attr("disabled","disabled");
						   break;
						 } 
					 }
					 if(totalRcv > 0){
						 montoTotalSumaRcv();
					 }
				 }else{	
					 for(var j=0;j<totalRcv;j++){
							var  monto = tablaRcv.cell(j, 2).data();
							 if(monto.indexOf("montoRcv"+i) >= 0){
							$("#montoRcv"+document.getElementById("valorPosicion").innerHTML).removeAttr("disabled");
							   var montoOriginal = tablaRcv.cell(j, 2).nodes().to$().find('input').val();
							   tablaRcv.cell("#precioAccion"+i).data(data.obRespuesta.nuValtitFhLiquida).draw();
							   tablaRcv.cell("#fechaValor"+i).data(data.titulo).draw();
							   calcularAccionRcvAct(montoOriginal, i, data.obRespuesta.nuValtitFhLiquida, montoOriginal, campoSar);
							   tablaRcv.cell("#acciones"+i).data( $("#valorAccionesTempo").val()).draw();
							   break;
							 } 
						 }
				 }
			}	
			
			
		}).error(function(data) {
			console.log("Ocurrio un error ::" + data);
		})
	}

   function cierraModalSeleccionarSiefore(){
		  $("#miOpcionSiefores").hide();
	}



	function selecionaSiefor(){
			$("#aceptarSiefor").removeClass('disabled_Url');

	}
	
	var timeOut3;
	function delayedCalculoRcv(montoOriginal, i, campoSar){
		timeOut3 = window.setTimeout(function(){calcularVentanaRcv(montoOriginal, i, campoSar)}, 4000);
	}
	
	function calcularVentanaRcv(montoOriginal, i, campoSar){
		var tablaRcv = $("#tableRcv").DataTable();
		var totalRcv = tablaRcv.rows().count();
		
		for(var j=0;j<totalRcv;j++){
			var  monto = tablaRcv.cell(j, 2).data();
			 if(monto.indexOf("montoRcv"+i) >= 0){
			   var montoNuevo = tablaRcv.cell(j, 2).nodes().to$().find('input').val();
			   var precioAccion = tablaRcv.cell(j, 5).data();
			   calcularAccionRcvAct(montoOriginal, i, precioAccion, montoNuevo, campoSar);
			   tablaRcv.cell("#acciones"+i).data( $("#valorAccionesTempo").val()).draw();
			   break;
			 } 
		 }
	}
	
	function calcularAccionRcvAct(montoOriginal, i, precioAccion, montoActual, campoSar){
		if(parseFloat(montoActual)>parseFloat(montoOriginal)){
			 $("#"+"montoRcv"+i).val(montoOriginal);
			 montoActual = montoOriginal;
		}
			
			 if(montoActual.length < 1){
				 $("#"+"montoRcv"+i).val("0");
				 montoActual = "0";
			  }	
			 
			
			 if(montoActual.indexOf('.') >= 0){
				 var montoRcvAgregar = montoActual.split('.');
				 var montoRcvEnt = montoRcvAgregar[0];
				 var montoRcvDecim = montoRcvAgregar[1];
				 if(montoRcvDecim.length < 1 && montoRcvEnt.length > 0){
					 $("#"+"montoRcv"+i).val(montoRcvEnt+".0");
					 montoActual = montoRcvEnt+".0";
				  }	
				 
				 if(montoRcvEnt.length < 1 && montoRcvDecim.length > 0){
					 $("#"+"montoRcv"+i).val("0."+montoRcvDecim);
					 montoActual = "0."+montoRcvDecim;
				  }	
				 
				 if(montoRcvEnt.length < 1 && montoRcvDecim.length < 1){
					 $("#"+"montoRcv"+i).val("0.0");
					 montoActual = "0.0";
				  }	
			 }
			 
			 var accionF = parseFloat(montoActual)/parseFloat(precioAccion);
			 var accion = accionF.toString();
			 var accionCompleto = accion.split('.');
			 var enterosAccion = accionCompleto[0];
			 if(accion.indexOf('.') >= 0){
				 accionF = Math.round(accionF*100)/100;
				 accion = accionF.toString();
				 accionCompleto = accion.split('.');
				 enterosAccion = accionCompleto[0];
				 var decimalesAccion = accionCompleto[1];
				if(enterosAccion.length > 8){
					enterosAccion = enterosAccion.substring(0, 8);
				}
				
				if(campoSar == "1"){
					if(decimalesAccion.length > 2){
						decimalesAccion = decimalesAccion.substring(0, 2);
					}
				}else{
					if(decimalesAccion.length > 6){
						decimalesAccion = decimalesAccion.substring(0, 6);
					}	
				}
				
				$("#valorAccionesTempo").val(enterosAccion+"."+decimalesAccion);
			 }else{
				 if(enterosAccion.length > 8){
					
					 enterosAccion = enterosAccion.substring(0, 8);
					}
				 $("#valorAccionesTempo").val(enterosAccion);
			 }
			 montoTotalSumaRcv();
	}
	
	
	function montoTotalSumaRcv(){
		var tabla = $("#tableRcv").DataTable();
		var total = tabla.rows().count();
		var table = $("#tableRcv").DataTable();
		
		var cell = [];
		if(total > 0){
			for(var i=0;i<total;i++){
				var sinPrecioAccion = table.cell(i, 5).nodes().to$().find('p').val();
				var siefore = table.cell(i, 6).nodes().to$().find('input').val();
				if(sinPrecioAccion != '' && siefore != "Click aquí"){
					cell.push(table.cell(i, 2).nodes().to$().find('input').val());
				}
				
			}
			console.log(cell);
			var sumaTotal=0;
			for(var j=0;j<cell.length;j++){
				sumaTotal +=parseFloat(cell[j]);
			}
			
			if(sumaTotal.toString().indexOf('.') >= 0){
				sumaTotal = Math.round(sumaTotal*100)/100;
				var sumT = sumaTotal.toString();
				$("#montoTotalRcv").text("$"+sumT);
				console.log(sumT);
			}else{
				var sumT = sumaTotal.toString();
				$("#montoTotalRcv").text("$"+sumT);
				console.log(sumT);
			}
			
		}else{
			$("#montoTotalRcv").text("$0");
		}
		 var tablaRcv = $("#tableRcv").DataTable();
		 var totalRcv = tablaRcv.rows().count();
		var tablaViv = $("#tablaVivienda").DataTable();
		 var totalViv = tablaViv.rows().count();
		 var montoTotalRcv = $("#montoTotalRcv").text();
		 montoTotalRcv = montoTotalRcv.replace("$","");
		 
		 var montoTotalViv = $("#montoTotalViv").text();
		 montoTotalViv = montoTotalViv.replace("$","");
		 
		 if(totalRcv<1 && totalViv<1){
			 $("#spanSubcuentas").show();
			 $("#btnMostrarModalCaptura").addClass('disabled_Url');
		 }else{
			 $("#spanSubcuentas").hide();
			 $("#btnMostrarModalCaptura").removeClass('disabled_Url');
		 }
		 
		 if(parseFloat(montoTotalRcv)<1 && parseFloat(montoTotalViv)<1){
			 $("#spanSubcuentas").show();
			 $("#btnMostrarModalCaptura").addClass('disabled_Url');
		 }else{
			 $("#spanSubcuentas").hide();
			 $("#btnMostrarModalCaptura").removeClass('disabled_Url');
		 }
	}

	
   function mostrarTablasRcvVivienda(){
	   $("#spanSubcuentas").hide();
	   $("#tablasSub").hide();
	   $("#btnMostrarModalCaptura").addClass('disabled_Url');
	   console.log("VISUALIZA TABLAS DE SUBCUENTAS RCV Y VIVIENDA");
	   document.getElementById("section_one").style.display = "none";
	   document.getElementById("section_two").style.display = "none";
	 	   //Valores Combos
	 
	      let claveTipoRegimen    = document.getElementById("tipoRegimen").value;
	 	  let claveTipoRetiro     = document.getElementById("tipoRetiro").value;
	 	  let claveTipoSeguro     = document.getElementById("tipoSeguro").value;
	 	  let claveTipoPension    = document.getElementById("tipoPension").value;
	 	  let claveTipoPrestacion = document.getElementById("tipoPrestacion").value;
	 	  var datos = {};  
	 	    datos.cvTipoRegimen    = claveTipoRegimen;
		 	datos.cvTipoRetiro     = claveTipoRetiro;
		 	datos.cvTipoSeguro     = claveTipoSeguro;
			datos.cvTipoPension = claveTipoPension;
	 	    datos.cvTipoPrestacion = claveTipoPrestacion;
	 	  
	 	   $.ajax({
				type      : "POST",
			    url       : "subCuentasMatriz.do",
			contentType	: "application/json",
			data:JSON.stringify(datos),
		}).success(function(data) {
			var listaCuentas= data.lstObRespuesta;
			console.log("Consulta Exitosa listaSuBCuentas:");
			
			let listaViviendaImss = data.lstObRespuestaDos;
			console.log(listaViviendaImss);						
			let estatusMarcaImss = data.obRespuesta;
			
			$("#montoTotalRcv").text("$0");
			
			if(data.mensaje == null){
				$("#montoTotalViv").text("$0");
				
			}else{
				 $("#montoTotalViv").text("$"+data.mensaje);
			}
			
						
			if(listaCuentas!=null){
				 if($("#borrarTabla").val() == "2"){
					 $("#tableRcv").empty();
					 destruirDatatabled();
					 construirTablaRcvDos(listaCuentas);
				 }else{
					  construirTablaRcv(listaCuentas);
				 }
			
			  $("#btnMostrarModalCaptura").removeClass('disabled_Url');
			}else{
				$("#spanSubcuentas").show();
				
			}
			
			if(listaCuentas!=null){
				 if($("#borrarTabla").val() == "2"){
					 $("#tablaVivienda").empty();
					 destruirDatatabledViv();
					 construirTablaViviendaDos(listaViviendaImss,estatusMarcaImss);
				 }else{
					  construirTablaVivienda(listaViviendaImss,estatusMarcaImss);
				 }
			
			  $("#btnMostrarModalCaptura").removeClass('disabled_Url');
			}
			
			$("#borrarTabla").val("2");
			})
		.error(function(data) {
			console.log("Error Consulta No Cargado"+data);
		});//Ajax

	   
   }
	
  