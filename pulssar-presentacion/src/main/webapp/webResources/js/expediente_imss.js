$(document).ready(function() {
	$("#btnGenerarExpediente").addClass('disabled_Url');
	$("#btnGenerarExpediente").click(function(event) {
		console.log("Invocando el Controller para Envio de Expediente");
	    
		//Valores Combos
		var datos = {};
		var cvTipoRegimen = document.getElementById("tipoRegimen").value;
		var combo = document.getElementById("tipoRegimen");
		var descTipoRegimen = combo.options[combo.selectedIndex].text;
		
		var cvTipoRetiro = document.getElementById("tipoRetiro").value;
		var combo = document.getElementById("tipoRetiro");
		var descTipoRetiro = combo.options[combo.selectedIndex].text;
		
		var cvTipoSeguro = document.getElementById("tipoSeguro").value;
		var combo = document.getElementById("tipoSeguro");
		var descTipoSeguro = combo.options[combo.selectedIndex].text;
	 	
		var cvTipoPension = document.getElementById("tipoPension").value;
		var combo = document.getElementById("tipoPension");
		var descTipoPension = combo.options[combo.selectedIndex].text;
		
		var cvTipoPrestacion = document.getElementById("tipoPrestacion").value;
	 	var combo = document.getElementById("tipoPrestacion");
		var descTipoPrestacion = combo.options[combo.selectedIndex].text;
	 		
        	
	 	// Cajas de texto
	 
		let numeroResolucion       = document.getElementById("numeroResolucion").value; 
	 	let secuenciaPension       = document.getElementById("secuenciaPension").value;
	 	let fcInicioPension      = document.getElementById("fechaIncioPension").value;
	 	let fcEmisionResolucion = document.getElementById("fechaEmisionResolucion").value;
	 	let porcentajeValuacion    = document.getElementById("porcentajeValuacion").value;
	 	let semanasCotizadas  = document.getElementById("numeroSemanasCotizadas").value;
	 	
	 	let aseguradora = document.getElementById("aseguradora").value;
	 	let actuarioAutorizado = document.getElementById("actuario").value;
		let numPlanPrivadoPensiones =  document.getElementById("numeroPlan").value;
		
        let idSolicitante =document.getElementById("solicitante").value;
        let descSolcitante=document.getElementById("descripcionSolicitante").value;
        let fechaNacimiento = document.getElementById("fechaNacimiento").value;
        let fechaSolicitud = document.getElementById("fechaSolicitud").value;
	 	let curpSolicitante=document.getElementById("curpAgenteServicio").value;
	 	
	 // Campos para VENTANILLA AFORE 
	 	let tipoVentanilla = document.getElementById("ventanillaAfore").value;
	 	let clabePago = document.getElementById("clabePago").value;
	 	let curpPago  = document.getElementById("curpPago").value;  
	 	let rfcPago   = document.getElementById("rfcPago").value;
	 	let folioInfonavit = document.getElementById("folioInfonavit").value;
	 	let grupo = document.getElementById("grupoTrabajador").value;
	 	let idBeneficiario	= document.getElementById("vSolicitante").value;
	 	let comboBen = document.getElementById("vSolicitante");
		let descBeneficiario = comboBen.options[comboBen.selectedIndex].text;
	 	
	 	//Campos Ventanilla Afore-Beneficiarios
	 	let apPaternoBeneficiario = document.getElementById("apPaternoBeneficiario").value;
	 	let apMaternoBeneficiario = document.getElementById("apMaternoBeneficiario").value;
	 	let nombreBeneficiario    = document.getElementById("nombreBeneficiario").value;
	    let cveDocProbatorio = document.getElementById("documentoProbatorio").value;
	    var combo = document.getElementById("documentoProbatorio");
		var desDocProbatorio = combo.options[combo.selectedIndex].text;
	    
	 	datos.tipoVentanilla = tipoVentanilla;
	 	datos.clabePago = clabePago;
	 	datos.curpPago  = curpPago;
	 	datos.rfcPago   = rfcPago;
	 	datos.folioInfonavit = folioInfonavit;
	 	datos.grupo = grupo;
	 	datos.idBeneficiario = idBeneficiario;
	 	datos.descBeneficiario=descBeneficiario
	 	datos.apPaternoBeneficiario = apPaternoBeneficiario;
	 	datos.apMaternoBeneficiario = apMaternoBeneficiario;
	 	datos.nombreBeneficiario = nombreBeneficiario;
	 	
	 	
	 	datos.cvTipoRegimen    = cvTipoRegimen;
	 	datos.descTipoRegimen  = descTipoRegimen;
	 	datos.cvTipoRetiro     = cvTipoRetiro;
	 	datos.descTipoRetiro   = descTipoRetiro;
	 	datos.cvTipoSeguro     = cvTipoSeguro;
	 	datos.descTipoSeguro   = descTipoSeguro;
	 	datos.claveTipoPension = claveTipoPension;
	 	datos.descTipoSeguro= descTipoSeguro;
	 	datos.cvTipoPension    = cvTipoPension;
	 	datos.descTipoPension  = descTipoPension;
	 	datos.cvTipoPrestacion = cvTipoPrestacion;
	 	datos.descTipoPrestacion = descTipoPrestacion;
	 	datos.numeroResolucion    = numeroResolucion;
	 	datos.secuenciaPension    = secuenciaPension;
	 	datos.fcInicioPension     = fcInicioPension;
	 	datos.fcEmisionResolucion = fcEmisionResolucion;
	 	datos.porcentajeValuacion = porcentajeValuacion;
	 	datos.semanasCotizadas = semanasCotizadas;
	 	datos.aseguradora = aseguradora;
	 	datos.actuarioAutorizado =actuarioAutorizado;
	 	datos.numPlanPrivadoPensiones=numPlanPrivadoPensiones
	 	datos.idSolicitante =idSolicitante;
	 	datos.fechaNacimiento =fechaNacimiento;
	 	datos.fechaSolicitud =fechaSolicitud;
	 	datos.curpSolicitante =curpSolicitante;
	 	datos.cveDocProbatorio=cveDocProbatorio;
	 	datos.desDocProbatorio = desDocProbatorio;
	 	
	 	//Llenado para la tabla de Subcuentas RCV
	 	
	 	var tablaRcv = $("#tableRcv").DataTable();
	 
		var totalRcv = tablaRcv.rows().count();
	
		var dataRcv =[];
		var dataViv =[];
		var datosObjRcv = {};
		var datosObjViv = {};
		if(totalRcv > 0){
		for(var i=0;i<totalRcv;i++){
			datosObjRcv = {};
			datosObjRcv.subcuentasDesc = tablaRcv.cell(i, 0).data();
			datosObjRcv.claveSubcuenta = tablaRcv.cell(i, 1).data();
			datosObjRcv.monto = tablaRcv.cell(i, 2).nodes().to$().find('input').val();
			datosObjRcv.acciones = tablaRcv.cell(i, 3).data();
			datosObjRcv.fechaValor = tablaRcv.cell(i, 4).data();
			datosObjRcv.precioAcciones = tablaRcv.cell(i, 5).data();
			datosObjRcv.siefore = tablaRcv.cell(i, 6).nodes().to$().find('input').val();
			//var campoSarCadena = tablaRcv.cell(i, 2).data();

			dataRcv.push(datosObjRcv);
		}
		datos.subcuentasRcv=dataRcv;
	}	
	 	 	
		//Llenado para la tabla de Subcuentas VIVIENDA
	 
		var tablaViv = $("#tablaVivienda").DataTable();
		var totalViv = tablaViv.rows().count();
		if(totalViv > 0){
			for(var i=0;i<totalViv;i++){
				datosObjViv = {};
				datosObjViv.subcuentasDesc = tablaViv.cell(i, 0).data();
				datosObjViv.claveSubcuenta = tablaViv.cell(i, 1).data();
				datosObjViv.monto = tablaViv.cell(i, 2).nodes().to$().find('input').val();
				datosObjViv.acciones = tablaViv.cell(i, 3).nodes().to$().find('input').val();
				datosObjViv.fechaValor = tablaViv.cell(i, 4).data();
				datosObjViv.precioAcciones = tablaViv.cell(i, 5).data();
				dataViv.push(datosObjViv);
			}
			datos.subcuentasViv=dataViv;
		}
		

		
		 //llenado para la tabla de beneficiarios
		let dataBen =[];
		let datosObjBen = {};
		let nFilasNuevo = $("#tablaBeneficiariosImss tr").length;	
	if(nFilasNuevo>1){
		$('#tablaBeneficiariosImss tr').each(function () {
			
			 datosObjBen.curp = $(this).find("td").eq(0).html();
			 datosObjBen.nombre = $(this).find("td").eq(1).html();
			 datosObjBen.apellidoPaterno = $(this).find("td").eq(2).html();
			 datosObjBen.apellidoMaterno = $(this).find("td").eq(3).html();
			 datosObjBen.rfc   = $(this).find("td").eq(4).html();
			 datosObjBen.porcentaje = $(this).find("td").eq(5).html();
			 datosObjBen.banco  = $(this).find("td").eq(6).html();
			 datosObjBen.cuentaClabe = $(this).find("td").eq(7).html();
			 
		});
		dataBen.push(datosObjBen);
	}
		datos.beneficiarios=dataBen;
		console.log(datos);
		
		datos.montoTotalBen = $("#porcentajeTotal").text();
		datos.montoTotalRcv = $("#montoTotalRcv").text();
		datos.montoTotalViv = $("#montoTotalViv").text();
		 console.log(datos);
    
		/**Componente Ajax  */

	 	$.ajax({
		type      : "POST",
		url         : "obtenerDatosSessionNoCargado.do",
	    contentType	: "application/json",
	    data:JSON.stringify(datos),
       }).success(function(data) {
    	   console.log("Consulta Exitosa Expediente:");
    	   $(location).attr('href', 'generarExpedienteImss.do');   
    	  })
	     .error(function(data) {
		   console.log("Error Consulta Expediente"+data);
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
	
});//Pincipal


  
	  
	   