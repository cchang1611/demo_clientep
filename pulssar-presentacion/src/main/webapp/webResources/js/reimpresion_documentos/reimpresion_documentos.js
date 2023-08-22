/**
 * jmordone controla el modulo de reimpresion de documentos
 */
var flujoCorrecto='0';
var noExisteEmail='3';
var servicioDireccionarTipoReimpresion= "obtieneArchivosPDFPorTipoTramite.do";
var servicioEnviarCorreoReimpresionMenu= "envioCorreoReimpresionMenu.do";
var servicioEnviaCorreoReimpresionImpresionSaldos= "envioCorreoReimpresionImpresionSaldos.do";
var servicioValidarArchivoExistente= "validarArchivoExistente.do";
var servicioObtieneEmailSolicitante= "obtieneEmailSolicitante.do";
var servicioObtieneEmailSolicitanteSaldosYMovimientos= "obtieneEmailSolicitanteSaldosYMovimientos.do";
var servicioSaldosYMovimientos="saldosYMovimientos.do";
var servicioGuardarBitacoraImpresion="guardaBitacoraImpresion.do";
var servicioGuardarBitacoraImpresionSaldos="guardaBitacoraImpresionSaldosYMovimientos.do";
var servicioEnviaCorreoReimpresionImpresion="envioCorreoReimpresionImpresion.do";
var mensajeError="No se ha realizado este tipo de trámite a través de la plataforma de servicios";
var mensajeCorreo= "Enviando correo Espere .....";
var correoExitoso="Envío de correo exitoso";
var correoError="Error";
var correo="Correo";


/**
 * Funcion inicial
 * @returns
 */
$(document).ready(function() {

	var errorArchivo=$('#errorArchivo').val();
	var mensajeArchivo=$('#mensajeArchivo').val();
	if(errorArchivo=='true'){
		document.getElementById("errorModalReimpresion").style.display='block';
		document.getElementById("mensajeErrorModalReimpresion").innerHTML=mensajeArchivo;			
		window.location.href = "#errorModalReimpresion";
	}
	
	
	$("#btnModalValidaCorreoSi").click(function(event) {
		enviaCorreoReimpresionMenu();
	});
    $("#btnModalValidaCorreoNo").click(function(event) {
    	cerrarModal();	
	});	
    $("#btnModalValidaCorreoSiSaldos").click(function(event) {
    	enviaCorreoReimpresionMenuSaldosYMovimientos();
	});
    $("#btnModalValidaCorreoNoSaldos").click(function(event) {
    	cerrarModal();	
	});	
    $("#btnModalValidaCorreoSiImpresion").click(function(event) {
    	enviaCorreoReimpresionImpresion();

	});
    $("#btnModalValidaCorreoNoImpresion").click(function(event) {
    	cerrarModal();
		
	});
    $("#btnInfoModalReimpresion").click(function(event) {
    	cerrarModal();
    	document.getElementById("infoModalReimpresion").style.display='none';
		
	});
    $("#btnExitoCambioCorreo").click(function(event) {
    	cerrarModal();
    	document.getElementById("exitoModalCambioCorreo").style.display='none';
		
	});
    
    
});

/**
 * direccionarReimpresion
 * @param modulo
 * @returns
 */
function direccionarModuloReimpresion(modulo) {
	try {
		$.ajax({
			method : "GET",
			url : servicioValidarArchivoExistente,
			contentType : "application/json",
			data : {
				modulo : modulo
			}
		}).success(function(data) {
			console.log(data);
			if(data.flujo==flujoCorrecto){			
				$(location).attr('href',servicioDireccionarTipoReimpresion);	
			}else{
				ventanaModalError(data);
			}
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}


/**
 * envioCorreo
 * @param modulo
 * @returns
 */
function enviaCorreoReimpresionMenu() {
	ventanaModalInfo();
	try {
		$.ajax({
			method : "GET",
			url : servicioEnviarCorreoReimpresionMenu,
			contentType : "application/json"
		}).success(function(data) {
			console.log(data);
			if(data.flujo==flujoCorrecto){						
				ventanaModalExito(data);
			}else{
				ventanaModalError(data);
			}
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}

/**
 * envioCorreo
 * @param modulo
 * @returns
 */
function enviaCorreoReimpresionMenuSaldosYMovimientos() {
	ventanaModalInfo();
	try {
		$.ajax({
			method : "GET",
			url : servicioEnviaCorreoReimpresionImpresionSaldos,
			contentType : "application/json"
		}).success(function(data) {
			console.log(data);
			if(data.flujo==flujoCorrecto){						
				ventanaModalExito(data);
			}else{
				ventanaModalError(data);
			}
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}

/**
 * envioCorreo
 * @param modulo
 * @returns
 */
function enviaCorreoReimpresionImpresion() {
	ventanaModalInfo();
	try {
		$.ajax({
			method : "GET",
			url : servicioEnviaCorreoReimpresionImpresion,
			contentType : "application/json"
		}).success(function(data) {
			console.log(data);
			if(data.flujo==flujoCorrecto){						
				ventanaModalExito(data);
			}else{
				ventanaModalError(data);
				
			}
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}


/**
 * obtiene email
 * @param modulo
 * @returns
 */
function obtieneEmail(modulo) {
	try {
		$.ajax({
			method : "GET",
			url : servicioObtieneEmailSolicitante,
			contentType : "application/json",
			data : {
				modulo : modulo
			}
		}).success(function(data) {
			if(data.flujo==flujoCorrecto){						
				ventanaModalDecision(data);
			}else{
				ventanaModalInfoNoExiste(data);
			}
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}


/**
 * obtiene email
 * @param modulo
 * @returns
 */
function obtieneEmailSaldosYMovimientos(modulo) {
	try {
		$.ajax({
			method : "GET",
			url : servicioObtieneEmailSolicitanteSaldosYMovimientos,
			contentType : "application/json",
			data : {
				modulo : modulo
			}
		}).success(function(data) {
			if(data.flujo==flujoCorrecto){						
				ventanaModalDecisionSaldos(data);
			}else{
				ventanaModalInfoNoExiste(data);
			}
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}


/**
 * obtiene email
 * @param modulo
 * @returns
 */
function obtieneEmailImpresion(modulo) {
	try {
		$.ajax({
			method : "GET",
			url : servicioObtieneEmailSolicitante,
			contentType : "application/json",
			data : {
				modulo : modulo
			}
		}).success(function(data) {
			if(data.flujo==flujoCorrecto){						
				ventanaModalDecisionImpresion(data);
			}else{
				ventanaModalInfoNoExiste(data);
			}
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}


/**
 * obtiene email
 * @param modulo
 * @returns
 */
function guardaBitacoraImpresion(modulo) {
	try {
		$.ajax({
			method : "GET",
			url : servicioGuardarBitacoraImpresion,
			contentType : "application/json",
			data : {
				modulo : modulo
			}
		}).success(function(data) {
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}


/**
 * obtiene email
 * @param modulo
 * @returns
 */
function guardaBitacoraImpresionSaldosYMovimientos(modulo) {
	try {
		$.ajax({
			method : "GET",
			url : servicioGuardarBitacoraImpresionSaldos,
			contentType : "application/json",
			data : {
				modulo : modulo
			}
		}).success(function(data) {
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}

/**
 * saldos y movimientos
 * @param modulo
 * @returns
 */
function obtieneSaldosYMovimientos() {
	$(location).attr('href',servicioSaldosYMovimientos);
}

/**
 * ventanaModalExito
 * @returns
 */
function ventanaModalExito(data){
	document.getElementById("exitoModalCambioCorreo").style.display='block';
	document.getElementById("tituloAlertaCambioCorreo").innerHTML==data.mensaje;
	document.getElementById("mensajeAlertaCambioCorreo").innerHTML=correoExitoso;
	window.location.href = "#exitoModalCambioCorreo";
}

/**
 * ventanaModalError
 * @param data
 * @returns
 */
function ventanaModalError(data){
	document.getElementById("errorModalReimpresion").style.display='block';
	document.getElementById("tituloErrorReimpresion").innerHTML=correoError;
	document.getElementById("mensajeErrorModalReimpresion").innerHTML=data.mensaje;			
	window.location.href = "#errorModalReimpresion";
}

/**
 * ventanaModalInfo
 * @returns
 */
function ventanaModalInfo(){
	document.getElementById("tituloInfo").innerHTML=correo;
	document.getElementById("mensajeInfo").innerHTML=mensajeCorreo;
	document.getElementById("btnInfoM").style.display="none";
	window.location.href = "#infoModal";
}

/**
 * ventanaModalInfoNoExiste
 * @returns
 */
function ventanaModalInfoNoExiste(data){
	document.getElementById("infoModalReimpresion").style.display='block';
	document.getElementById("mensajeAlertaCambioImpresion").innerHTML=data.mensaje;
	window.location.href = "#infoModalReimpresion";
}

/**
 * ventanaModalInfoNoExiste
 * @returns
 */
function ventanaModalDecision(data){
	document.getElementById("modalValidaCorreo").style.display='block';
	document.getElementById("mensajeActExpValidaCorreo").innerHTML=data.mensaje;
	window.location.href = "#modalValidaCorreo";
}

/**
 * ventanaModalInfoNoExiste
 * @returns
 */
function ventanaModalDecisionSaldos(data){
	document.getElementById("modalValidaCorreoSaldos").style.display='block';
	document.getElementById("mensajeActExpValidaCorreoSaldos").innerHTML=data.mensaje;
	window.location.href = "#modalValidaCorreoSaldos";
}

/**
 * ventanaModalInfoNoExiste
 * @returns
 */
function ventanaModalDecisionImpresion(data){
	document.getElementById("modalValidaCorreoImpresion").style.display='block';
	document.getElementById("mensajeActExpValidaCorreoImpresion").innerHTML=data.mensaje;
	window.location.href = "#modalValidaCorreoImpresion";
}


function cerrarModal(){
	window.location.href = "#";	
}

/**
 * Se encarga de abrir modal para imprimir
 * @returns
 */
function crearImpresion(modulo){
	var print = document.getElementById('framepdf');
	print.focus();
	print.contentWindow.print();
	guardaBitacoraImpresion(modulo);
}

/**
 * Se encarga de abrir modal para imprimir
 * @returns
 */
function crearImpresionSaldosYMovimientos(modulo){
	var print = document.getElementById('framepdf');
	print.focus();
	print.contentWindow.print();
	guardaBitacoraImpresionSaldosYMovimientos(modulo);
}

/**
 * Se encarga de la creacion del iframe
 * @param archivo
 * @returns
 */
function creacionIframe(archivo){
	var bin=atob(archivo);
	var len=bin.length;
	var arr=new Uint8Array(len);
	for(var i=0;i<len;i++){
		arr[i]=bin.charCodeAt(i);
	}
	var blob=new Blob([arr],{type:"application/pdf"})
	var url=URL.createObjectURL(blob);
	
	var divImage=document.getElementById("divFrame");
	var iframe='<iframe class="toPrint" id="framepdf" width="900" name ="framepdf" height="500" title="Reimpresión" src="'+url+'"></iframe>';
	divImage.insertAdjacentHTML("beforeend",iframe);

}
