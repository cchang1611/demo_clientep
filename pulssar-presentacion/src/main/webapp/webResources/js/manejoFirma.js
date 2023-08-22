var formularion = null;
var valorSign;
var idFirmaMostrar = 0;
var idFirmasCapturar = [];
var FIRMA_TRABAJADOR = 1;
var FIRMA_ASESOR = 2;
var etiquetasBoton = [];

function agregarIdFirma(idFirma){
	idFirmasCapturar.push(idFirma);
}

function obtenerIdFirmaCapturar(){
	if(idFirmasCapturar.length>0){
		idFirmaMostrar = idFirmasCapturar.shift();
	}else{
		idFirmaMostrar = -1;
	}
	
	return idFirmaMostrar;
}

function agregarEtiquetaBoton(etiqueta){
	console.log("se agrego la etiqueta: "+etiqueta);
	etiquetasBoton.push(etiqueta);
}

function obtenerEtiquetaBoton(){
	console.log("cantidad etiquetas boton: "+etiquetasBoton.length);
	if(etiquetasBoton.length>0){
		console.log("regresando etiqueta");
		return etiquetasBoton.shift();
	}
	
	return "";
}

function SignInicio() {	
	//valorSign = signValue;
	obtenerIdFirmaCapturar();	
	console.log("SignInicio - idFirma: "+idFirmaMostrar);
	var canvasObj = document.getElementById('cnv');
	console.log("SignInicio - paso 1");
	canvasObj.getContext('2d').clearRect(0, 0, canvasObj.width, canvasObj.height);
	console.log("SignInicio - paso 2");
	imgWidth = canvasObj.width;
	console.log("SignInicio - paso 3");
	imgHeight = canvasObj.height;
	console.log("SignInicio - paso 4");
	var message = { "firstName": "", "lastName": "", "eMail": "", "location": "", "imageFormat": 1, "imageX": imgWidth, "imageY": imgHeight, "imageTransparency": false, "imageScaling": false, "maxUpScalePercent": 0.0, "rawDataFormat": "ENC", "minSigPoints": 25, "penThickness": 3, "penColor": "#000000" };
	console.log("SignInicio - paso 5");
	
	document.addEventListener('SigCaptureWeb_SignResponse', SigRespondeInicio, false);
	console.log("SignInicio - paso 6");
	var messageData = JSON.stringify(message);
	console.log("SignInicio - paso 7");
	var element = document.createElement("SigCaptureWeb_ExtnDataElem");
	console.log("SignInicio - paso 8");
	element.setAttribute("SigCaptureWeb_MsgAttribute", messageData);
	console.log("SignInicio - paso 9");
	document.documentElement.appendChild(element);
	console.log("SignInicio - paso 10");
	var evt = document.createEvent("Events");
	console.log("SignInicio - paso 11");
	evt.initEvent("SigCaptureWeb_SignStartEvent", true, false);
	console.log("SignInicio - paso 12");
	element.dispatchEvent(evt);
	console.log("SignInicio - paso 13");
}

function SigRespondeInicio(event) {
	var str = event.target.getAttribute("SigCaptureWeb_msgAttri");
	console.log("SigRespondeInicio - paso 15");
	var obj = JSON.parse(str);
	console.log("SigRespondeInicio - paso 16");
	obtieneDatos(obj, imgWidth, imgHeight);
}

function obtieneDatos(objResponse, imageWidth, imageHeight) {
	var obj = JSON.parse(JSON.stringify(objResponse));
	console.log("obtieneDatos - paso 17");
	var ctx = document.getElementById('cnv').getContext('2d');
	console.log("obtieneDatos - paso 18");
	var canvasObj = document.getElementById('cnv');
	console.log("obtieneDatos - paso 19");
	
	if (obj.errorMsg != null && obj.errorMsg!="" && obj.errorMsg!="undefined") {
		console.log("obtieneDatos - paso 20-1-1 mensaje error");
		idFirmasCapturar.unshift(idFirmaMostrar);
		console.log("obtieneDatos - paso 20-1-2 mensaje error");
	} else {
		console.log("obtieneDatos - paso 20-2");
		if (obj.isSigned) {
			console.log("obtieneDatos - paso 21");
			var child = document.documentElement.lastChild;
			console.log("obtieneDatos - paso 22");
			while (child.localName.includes('sigcaptureweb')) {
				document.documentElement.removeChild(child);
				child = document.documentElement.lastChild;
			}
			
			console.log("obtieneDatos - paso 23 idFirma: "+idFirmaMostrar);
			
			switch(idFirmaMostrar){
			case FIRMA_TRABAJADOR:
				console.log("obtieneDatos - paso 23-1");
				$("#idFirmaEmpleado").val(obj.imageData);
				console.log("firma empleado: "+obj.imageData);
				$("#frmPdf").submit();
				break;
			case FIRMA_ASESOR:
				console.log("obtieneDatos - paso 23-2");
				$("#idFirmaAgente").val(obj.imageData);
				console.log("firma agente: "+obj.imageData);
				$("#frmPdf").submit();
				break;
			}
			
			var etiquetaBotonN = obtenerEtiquetaBoton();
			
			if(etiquetaBotonN.length>0){
				$("#btnFirma").html(etiquetaBotonN);	
			}
			
			
			console.log("obtieneDatos - paso 24");
			if(idFirmasCapturar.length<=0){
				console.log("obtieneDatos - paso 25");
				$("#frmPdf").hide();
				console.log("obtieneDatos - paso 26");
				$("#frmAdjuntar").show();
			}
			
			/*
			if(valorSign == 1) {
				$.ajax({
					method      : "GET",
					url         : "firmaCapturada.do",
					contentType : "application/json",
					data		: { id : _IDENTIFICADOR, response : obj.imageData}
				})
				.success(function(data) {
					if(data.flujo == 1) {
						$("#imgAcuse").attr('src', 'data:image/png;base64, ' + data.mensaje);
						$("#btnFirmar").attr("hidden", true);
						$("#btnContinuar").removeAttr("hidden");
					} else if(data.flujo == 2) {
						document.getElementById('tituloError').innerHTML = data.titulo;
						document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
						window.location.href = "#errorModal";
					}
				});
			} else {
				$.ajax({
					method      : "GET",
					url         : "firmaExcepcion.do",
					contentType : "application/json",
					data		: { response : obj.imageData}
				})
				.success(function(data) {
					if(data.flujo == 1) {
						$("#imgAcuse").attr('src', 'data:image/png;base64, ' + data.mensaje);
						$("#btnAgenteFirma").attr("hidden", true);
						$("#btnFinaliza").removeAttr("hidden");
						$("#fm_Biometrico").attr('action', "finalizaEnrolamiento.do");
					} else if(data.flujo == 2) {
						document.getElementById('tituloError').innerHTML = data.titulo;
						document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
						window.location.href = "#errorModal";
					}
				});
			}
			*/
		}else{
			console.log("obtieneDatos - sin firma 1.1");
			idFirmasCapturar.unshift(idFirmaMostrar);
			console.log("obtieneDatos - sin firma 1.2");
		}
	}
}