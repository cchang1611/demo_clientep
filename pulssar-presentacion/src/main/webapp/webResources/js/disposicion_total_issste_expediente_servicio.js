$(document).ready(function() {
	
});

function implementacionExpedienteServicio(){
	$("#spanObligatoriosPrin").hide();
	
	
	$("#spanFechaEm").hide();
	var fecha = document.getElementById("fechaEmisionPensionT").value;
	var fechaNueva = $.datepicker.parseDate("dd/mm/yy" , fecha);
	if(Date.parse(fechaNueva)>Date.now()){
    	$("#spanFechaEm").show();
    	return
	}
	
	var retiroC = document.getElementById("retiro").value;
	var docProb = document.getElementById("docProbatorio").value;
	if(retiroC == "E"){
		if(docProb == "0"){
			$("#spanClaveDocProbatorio").show();
			return
		}
	}
	if(document.getElementById("numeroResolucionT").value == '' || document.getElementById("secuenciaPensionT").value == '' || document.getElementById("fechaIncioPensionT").value == '' || document.getElementById("fechaEmisionPensionT").value == '' || document.getElementById("numeroSemanasCotizadasT").value == '' || document.getElementById("numeroIssste").value == '' ){
		$("#spanObligatoriosPrin").show();
		return 
	}
	
	var arrayList = null;
	var datos = {};
	datos.idResolucion = document.getElementById("valorRadioDos").value;
	datos.descripcionSolicitante = document.getElementById("descripcionSolicitante").value;
	datos.claveDocProbatorio = document.getElementById("docProbatorio").value;
	var comboDoc = document.getElementById("docProbatorio");
	datos.descDocProbatorio = comboDoc.options[comboDoc.selectedIndex].text;
	datos.claveTipoRecursosDisponer = document.getElementById("disposicion").value;
	var comboDisposicion = document.getElementById("disposicion");
	datos.descTipoRecursosDisponer = comboDisposicion.options[comboDisposicion.selectedIndex].text;
	datos.claveRegimen = document.getElementById("regimen").value;
	var comboRegimen = document.getElementById("regimen");
	datos.descRegimen = comboRegimen.options[comboRegimen.selectedIndex].text;
	datos.claveRetiro = document.getElementById("retiro").value;
	var comboRetiro = document.getElementById("retiro");
	datos.descRetiro = comboRetiro.options[comboRetiro.selectedIndex].text;
	datos.claveSeguro = document.getElementById("seguro").value;
	var comboSeguro = document.getElementById("seguro");
	datos.descSeguro = comboSeguro.options[comboSeguro.selectedIndex].text;
	datos.claveTipoPension = document.getElementById("tipoPension").value;
	var comboTipoPension = document.getElementById("tipoPension");
	datos.descTipoPension = comboTipoPension.options[comboTipoPension.selectedIndex].text;
	datos.claveTipoPrestacion = document.getElementById("tipoPrestacion").value;
	var comboTipoPrestacion = document.getElementById("tipoPrestacion");
	datos.descTipoPrestacion = comboTipoPrestacion.options[comboTipoPrestacion.selectedIndex].text;
	datos.clavePension = document.getElementById("pension").value;
	var comboClavePension = document.getElementById("pension");
	datos.descClavePension = comboClavePension.options[comboClavePension.selectedIndex].text;
	datos.claveMov = document.getElementById("movimiento").value;
	var comboMov = document.getElementById("movimiento");
	datos.descMov = comboMov.options[comboMov.selectedIndex].text;
	datos.numeroResolucion = document.getElementById("numeroResolucionT").value;
	datos.secuenciaPension = document.getElementById("secuenciaPensionT").value;
	datos.fechaInicioPension = document.getElementById("fechaIncioPensionT").value;
	datos.fechaEmisionPension = document.getElementById("fechaEmisionPensionT").value;
	datos.numeroSemanasCotizadas = document.getElementById("numeroSemanasCotizadasT").value;
	datos.fechaSolicitud = document.getElementById("fechaSolicitud").value;
	datos.fechaNacimiento = document.getElementById("fechaNacimiento").value;
	datos.descripcionSolicitante = document.getElementById("descripcionSolicitante").value;
	var comboAsegu = document.getElementById("aseguradora");
	datos.claveAforeCombo = document.getElementById("aseguradora").value;
	datos.descripcionAforeCombo = comboAsegu.options[comboAsegu.selectedIndex].text;
	datos.tipoRecursoClave = document.getElementById("claveTipoRecursos").value;
	datos.tipoRecursoDescripcion = document.getElementById("tipoRecursosDescripcion").value;
	datos.numeroIssste = document.getElementById("numeroIssste").value;
	
	datos.montoTotalBen = $("#porcentajeTotal").text();
	datos.montoTotalRcv = $("#montoTotalRcv").text();
	datos.montoTotalViv = $("#montoTotalViv").text();
	if(document.getElementById("claveTipoRecursos").value == "sief"){
		datos.claveSiefore = document.getElementById("siefores").value;
		var comboSiefore = document.getElementById("siefores");
		datos.descSiefore = comboSiefore.options[comboSiefore.selectedIndex].text;
	}

	//llenar datos de subcuentas rcv
	var valorTipoRec = document.getElementById("claveTipoRecursos").value;
	var tablaRcv = $("#tablaRcv").DataTable();
	var totalRcv = tablaRcv.rows().count();
	
	var dataRcv =[];
	var dataViv =[];
	var datosObjRcv = {};
	var datosObjViv = {};
	if(totalRcv > 0){
		if(valorTipoRec == "sief"){
			for(var i=0;i<totalRcv;i++){
				datosObjRcv = {};
				datosObjRcv.subcuentasDesc = tablaRcv.cell(i, 0).data();
				datosObjRcv.claveSubcuenta = tablaRcv.cell(i, 1).data();
				datosObjRcv.monto = tablaRcv.cell(i, 2).nodes().to$().find('input').val();
				datosObjRcv.acciones = tablaRcv.cell(i, 3).data();
				datosObjRcv.fechaValor = tablaRcv.cell(i, 4).data();
				datosObjRcv.precioAcciones = tablaRcv.cell(i, 5).data();
				datosObjRcv.siefore = tablaRcv.cell(i, 6).nodes().to$().find('input').val();
				var campoSarCadena = tablaRcv.cell(i, 2).data();
				var sar = document.getElementById("posicionSar92").value;
				if(campoSarCadena.indexOf(sar) >= 0){
					datosObjRcv.campoSar92 = "1";
				}
				dataRcv.push(datosObjRcv);
			}
			
		}else{
			for(var i=0;i<totalRcv;i++){
				datosObjRcv = {};
				datosObjRcv.subcuentasDesc = tablaRcv.cell(i, 0).data();
				datosObjRcv.claveSubcuenta = tablaRcv.cell(i, 1).data();
				datosObjRcv.monto = tablaRcv.cell(i, 2).nodes().to$().find('input').val();
				datosObjRcv.campoSar92 = "1";
				dataRcv.push(datosObjRcv);
			}
		}
		datos.subcuentasRcv=dataRcv;
	}
	//
	
	///Llenar datos de subcuentas vivienda
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
	//
	
	///Llenar datos para beneficiarios
	var dataBen =[];
	var datosObjBen = {};
	var tablaBen = $("#tablaBeneficiarios").DataTable();
	var totalBen = tablaBen.rows().count();
	if(totalBen > 0){
		for(var i=0;i<totalBen;i++){
			datosObjBen = {};
			datosObjBen.curp = tablaBen.cell(i, 0).data();
			datosObjBen.nombre = tablaBen.cell(i, 1).data();
			datosObjBen.apellidoPaterno = tablaBen.cell(i, 2).data();
			datosObjBen.apellidoMaterno = tablaBen.cell(i, 3).data();
			datosObjBen.rfc = tablaBen.cell(i, 4).data();
			datosObjBen.porcentaje = tablaBen.cell(i, 5).data();
			datosObjBen.banco = tablaBen.cell(i, 6).data();
			datosObjBen.cuentaClabe = tablaBen.cell(i, 7).data();
			dataBen.push(datosObjBen);
		}
		datos.beneficiariosDatos=dataBen;
	}
	//
	$.ajax({
		type : "POST",
		url : "obtenerDatosSessionFormulario.do",
		contentType : "application/json",
		data:JSON.stringify(datos)
	}).success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			$(location).attr('href', 'generarExpedienteIsssste.do');
		}	
	});
	
	
}


function implementacionExpedienteServicioPlanPrivado(){
	$("#spanObligatoriosPrin").hide();
	
	$("#spanFechaEm").hide();
	var fecha = document.getElementById("fechaEmisionPensionT").value;
	var fechaNueva = $.datepicker.parseDate("dd/mm/yy" , fecha);
	if(Date.parse(fechaNueva)>Date.now()){
    	$("#spanFechaEm").show();
    	return
	}
	
	$("#spanFechaIn").hide();
	var fecha = document.getElementById("fechaIncioPensionT").value;
	var fechaNueva = $.datepicker.parseDate("dd/mm/yy" , fecha);
	if(Date.parse(fechaNueva)>Date.now()){
    	$("#spanFechaIn").show();
    	return
	}
	
	if(document.getElementById("numeroResolucionT").value == '' || document.getElementById("secuenciaPensionT").value == '' || document.getElementById("fechaIncioPensionT").value == '' || document.getElementById("fechaEmisionPensionT").value == '' || document.getElementById("numeroSemanasCotizadasT").value == '' || document.getElementById("numeroIssste").value == ''){
		$("#spanObligatoriosPrin").show();
		return 
	}
	var arrayList = null;
	var datos = {};
	datos.actuario =  document.getElementById("actuarioAu").value;
	datos.numeroPlanPensiones =  document.getElementById("nrp").value;
	datos.idResolucion = document.getElementById("valorRadioDos").value;
	datos.descripcionSolicitante = document.getElementById("descripcionSolicitante").value;
	datos.claveDocProbatorio = document.getElementById("docProbatorio").value;
	var comboDoc = document.getElementById("docProbatorio");
	datos.descDocProbatorio = comboDoc.options[comboDoc.selectedIndex].text;
	datos.claveTipoRecursosDisponer = document.getElementById("disposicion").value;
	var comboDisposicion = document.getElementById("disposicion");
	datos.descTipoRecursosDisponer = comboDisposicion.options[comboDisposicion.selectedIndex].text;
	datos.claveRegimenPlan = document.getElementById("regimenPlanPrivado").value;
	var comboRegimenPlan = document.getElementById("regimenPlanPrivado");
	datos.descRegimenPlan = comboRegimenPlan.options[comboRegimenPlan.selectedIndex].text;
	datos.claveRetiro = document.getElementById("retiro").value;
	var comboRetiro = document.getElementById("retiro");
	datos.descRetiro = comboRetiro.options[comboRetiro.selectedIndex].text;
	datos.claveSeguro = document.getElementById("seguro").value;
	var comboSeguro = document.getElementById("seguro");
	datos.descSeguro = comboSeguro.options[comboSeguro.selectedIndex].text;
	datos.claveTipoPension = document.getElementById("tipoPension").value;
	var comboTipoPension = document.getElementById("tipoPension");
	datos.descTipoPension = comboTipoPension.options[comboTipoPension.selectedIndex].text;
	datos.claveTipoPrestacion = document.getElementById("tipoPrestacion").value;
	var comboTipoPrestacion = document.getElementById("tipoPrestacion");
	datos.descTipoPrestacion = comboTipoPrestacion.options[comboTipoPrestacion.selectedIndex].text;
	datos.clavePension = document.getElementById("pension").value;
	var comboClavePension = document.getElementById("pension");
	datos.descClavePension = comboClavePension.options[comboClavePension.selectedIndex].text;
	datos.claveMov = document.getElementById("movimiento").value;
	var comboMov = document.getElementById("movimiento");
	datos.descMov = comboMov.options[comboMov.selectedIndex].text;
	datos.numeroResolucion = document.getElementById("numeroResolucionT").value;
	datos.secuenciaPension = document.getElementById("secuenciaPensionT").value;
	datos.fechaInicioPension = document.getElementById("fechaIncioPensionT").value;
	datos.fechaEmisionPension = document.getElementById("fechaEmisionPensionT").value;
	datos.numeroSemanasCotizadas = document.getElementById("numeroSemanasCotizadasT").value;
	datos.fechaSolicitud = document.getElementById("fechaSolicitud").value;
	datos.fechaNacimiento = document.getElementById("fechaNacimiento").value;
	datos.descripcionSolicitante = document.getElementById("descripcionSolicitante").value;
	var comboAsegu = document.getElementById("aseguradora");
	datos.claveAforeCombo = document.getElementById("aseguradora").value;
	datos.descripcionAforeCombo = comboAsegu.options[comboAsegu.selectedIndex].text;
	datos.tipoRecursoClave = document.getElementById("claveTipoRecursos").value;
	datos.tipoRecursoDescripcion = document.getElementById("tipoRecursosDescripcion").value;
	datos.montoTotalBen = $("#porcentajeTotal").text();
	datos.montoTotalRcv = $("#montoTotalRcv").text();
	datos.montoTotalViv = $("#montoTotalViv").text();
	datos.numeroIssste = document.getElementById("numeroIssste").value;
	//llenar datos de subcuentas rcv
	var valorTipoRec = document.getElementById("claveTipoRecursos").value;
	var tablaRcv = $("#tablaRcv").DataTable();
	var totalRcv = tablaRcv.rows().count();
	
	datos.claveSiefore = document.getElementById("siefores").value;
	var comboSiefore = document.getElementById("siefores");
	datos.descSiefore = comboSiefore.options[comboSiefore.selectedIndex].text;
	
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
				var campoSarCadena = tablaRcv.cell(i, 2).data();
				var sar = document.getElementById("posicionSar92").value;
				if(campoSarCadena.indexOf(sar) >= 0){
					datosObjRcv.campoSar92 = "1";
				}
				dataRcv.push(datosObjRcv);
			}
			datos.subcuentasRcv=dataRcv;
		
	}
	//
	
	///Llenar datos de subcuentas vivienda
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
	///beneficiarios
	var dataBen =[];
	var datosObjBen = {};
	var tablaBen = $("#tablaBeneficiarios").DataTable();
	var totalBen = tablaBen.rows().count();
	if(totalBen > 0){
		for(var i=0;i<totalBen;i++){
			datosObjBen = {};
			datosObjBen.curp = tablaBen.cell(i, 0).data();
			datosObjBen.nombre = tablaBen.cell(i, 1).data();
			datosObjBen.apellidoPaterno = tablaBen.cell(i, 2).data();
			datosObjBen.apellidoMaterno = tablaBen.cell(i, 3).data();
			datosObjBen.rfc = tablaBen.cell(i, 4).data();
			datosObjBen.porcentaje = tablaBen.cell(i, 5).data();
			datosObjBen.banco = tablaBen.cell(i, 6).data();
			datosObjBen.cuentaClabe = tablaBen.cell(i, 7).data();
			dataBen.push(datosObjBen);
		}
		datos.beneficiariosDatos=dataBen;
	}
	$.ajax({
		type : "POST",
		url : "obtenerDatosSessionFormulario.do",
		contentType : "application/json",
		data:JSON.stringify(datos)
	}).success(function(data) {
		console.log(data.flujo);
		if(data.flujo == 1) {
			$(location).attr('href', 'generarExpedienteIsssste.do');
		}	
	});
}