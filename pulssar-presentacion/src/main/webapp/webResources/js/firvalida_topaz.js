
function SignInicio(signValue) {
	window.location.href = "#modalLoader";
	console.log("Iniciando pad de firma");
	 var isInstalled = document.documentElement.getAttribute('SigPlusExtLiteExtension-installed');  
	    if (!isInstalled) {
	        alert("La extensión SigPlusExtLite no está instalada o deshabilitada. Instala o habilita la extensión.");
			return;
	    }	

	
	
	valorSign = signValue;
	var canvasObj = document.getElementById('cnv');
	canvasObj.getContext('2d').clearRect(0, 0, canvasObj.width, canvasObj.height);
	imgWidth = canvasObj.width;
	imgHeight = canvasObj.height;
	var message = { "firstName": "", "lastName": "", "eMail": "", "location": "", "imageFormat": 1, "imageX": imgWidth, "imageY": imgHeight, "imageTransparency": false, "imageScaling": false, "maxUpScalePercent": 0.0, "rawDataFormat": "ENC", "minSigPoints": 25, "penThickness": 3, "penColor": "#000000" };
	
	document.addEventListener('SignResponse', SigRespondeInicio, false);
	var messageData = JSON.stringify(message);
	var element = document.createElement("MyExtensionDataElement");
	element.setAttribute("messageAttribute", messageData);
	document.documentElement.appendChild(element);
	var evt = document.createEvent("Events");
	evt.initEvent("SignStartEvent", true, false);
	element.dispatchEvent(evt);
}

function SigRespondeInicio(event) {
	console.log("SigResponse evento");
	var str = event.target.getAttribute("msgAttribute");
	var obj = JSON.parse(str);
	obtieneDatos(obj, imgWidth, imgHeight);
}

function obtieneDatos(objResponse, imageWidth, imageHeight) {
	console.log("Obteniendo firma");
	var obj = JSON.parse(JSON.stringify(objResponse));
	var ctx = document.getElementById('cnv').getContext('2d');
	var canvasObj = document.getElementById('cnv');
	
	if (obj.errorMsg != null && obj.errorMsg!="" && obj.errorMsg!="undefined") {
		alert("No se pudo obtener la firma ");
		console.log("Error en la captura de la firma: "+obj.errorMsg);
		window.location.href = "#";
	} else {
		if (obj.isSigned) {
			console.log("Se obtuvo firma");
			var child = document.documentElement.lastChild;
			while(child.localName.includes('sigcaptureweb')) {
				document.documentElement.removeChild(child);
				child = document.documentElement.lastChild;
			}
			console.log("Enviando Imagen ");
			var url = contextoSistema+"/private/firmaCapturada.do";
			console.log("Url: "+url);
			
			if(valorSign == 1) {
				$.ajax({
					method      : "POST",
					url         : url,
					contentType : "application/json",
					data		: JSON.stringify({response : obj.imageData})
				})
				.success(function(data) {
					if(data.flujo == 1) {
						console.log("Imagen "+data.mensaje);
						compatibilidadPdf(data.mensaje);
						
						$("#btnFirmar").attr("hidden", true);
						$("#btnContinuar").removeAttr("hidden");
						window.location.href = "#";
					} else if(data.flujo == 2) {
						console.log("Imagen 2"+data.mensaje);
						document.getElementById('tituloError').innerHTML = data.titulo;
						document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
						window.location.href = "#errorModal";
					}
				})
				.error(function(data) {
					console.log("Error en la invocacion del servicio Sing1");
					console.log("stringify "+JSON.stringify(data));		
					var responseExpediente = JSON.stringify(data);
					console.log(data.status);
					console.log(data.responseText);
					console.log(responseExpediente);								
					alert('Error en la captura de la firma');
					window.location.href = "#errorModal";
				});
				
		
			} else {
				var url = contextoSistema+"/private/firmaExcepcion.do";
				alert ('url_E:'+url)
				$.ajax({
					method      : "GET",
					url         : url,
					contentType : "application/json",
					data		: { response : obj.imageData}
				})
				.success(function(data) {
					if(data.flujo == 1) {
						compatibilidadPdf(data.mensaje);
						$("#btnAgenteFirma").attr("hidden", true);
						$("#btnFinaliza").removeAttr("hidden");
						$("#fm_Biometrico").attr('action', "finalizaEnrolamiento.do");
						window.location.href = "#";
					} else if(data.flujo == 2) {
						document.getElementById('tituloError').innerHTML = data.titulo;
						document.getElementById('mensajeErrorModal').innerHTML = data.mensaje;
						window.location.href = "#errorModal";
					}
				
				})
				.error(function(data) {	
					window.location.href = "#";
					alert('Error en la invocacion del servicio EXEPCION');
					var responseExpediente = JSON.stringify(data);
					alert(data.status);
					alert(data.responseText);
					alert(responseExpediente);

					
				});
			}
		}else{
			window.location.href = "#";
			alert("Error en la firma: "+obj.errorMsg);
		}
	}
}

