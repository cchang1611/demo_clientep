
var context = '${pageContext.request.contextPath}';

/**
 * Inicia la toma de la firma
 * @param signValue
 * @returns
 */
function SignInicio(digita) {
	console.log("Inicio de dispositivo:" + digita);
	var peticion = generarPeticion(digita);
}


/**
 * Genera la peticion
 * @returns
 */
function generarPeticion(digita){
//	var digita = {
//			folioProcesar : "S0000033202006020006",
//			proceso : "46",
//			curpTitular:"AICP980316HSLVRD09",
//			nssTitular:"83169894678",
//			curpSolicitante:"0",
//			tipoSoliciante:"1",
//			idRFCModificado:"1"
//	};
	console.log("Invocacion de generacion de peticion digitalizacion");
		var url = "generaPeticionDigitalizacion.do";
			$.ajax({
				method      : "POST",
				url         : url,
				contentType : "application/json",
//				data		: JSON.stringify(digita)
				data		: digita
			})
			.success(function(data) {
				  console.log("Respuesta peticion digitalizacion" + data);
				  ejecutaWebService(data);
				
			})
			.error(function(data) {
				console.log("Error en al generar la peticion");
				console.log("stringify "+JSON.stringify(data));		
			});
	
	
}

/**
* Realiza la peticion a coppel
* @returns
*/
function ejecutaWebService(peticion){
	console.log("ejecucion de webservice digitalizacion, " + peticion);
		soapData 	= "",
		httpObject 	= null,
		docXml 		= null,
		iEstado 	= 0,
		sMensaje 	= "";
		sUrlSoap 	= peticion.urlSoap.replace("tps", "tp");
		
		//Cadena para la ejecuci�n de la aplicaci�n
		soapData=peticion.soapData;
		soapData= remplazar(soapData, "tps", "tp")
		
		//Objeto para la peticion
		httpObject = getHTTPObject();

		if(httpObject){
			if(httpObject.overrideMimeType)
				httpObject.overrideMimeType("false");

			httpObject.open('POST', sUrlSoap, false); //-- no asincrono
			httpObject.setRequestHeader("Accept-Language", null);
			httpObject.onreadystatechange=function(){
				if(httpObject.readyState == 4 && httpObject.status == 200){
					parser = new DOMParser();
					docXml = parser.parseFromString(httpObject.responseText, "text/xml");
					iEstado = docXml.getElementsByTagName('Estado')[0].childNodes[0].nodeValue;
					if(iEstado ==1){
						console.log("inicio de busqueda de respuesta de imagenes");
						continuarProceso();						
					}else if(iEstado == -4){
						$("#btnRecepcionImgCop").removeAttr("disabled");
						window.location.href = "#";		
					}else {
						document.getElementById('tituloError').innerHTML = "ERROR";
						document.getElementById('mensajeErrorModal').innerHTML = "SE PRESENT\u00D3 UN ERROR EN EL DISPOSITIVO PARA LA DIGITALIZACI&oacute; C&Oacute;DIGO {" + iEstado + "} FAVOR DE REPORTARLO";
						window.location.href = "#errorModal";
					}
				}
				else{
					document.getElementById('tituloError').innerHTML = "ERROR";
					document.getElementById('mensajeErrorModal').innerHTML = "SE PRESENT\u00D3 UN ERROR EN EL DISPOSITIVO PARA LA DIGITALIZACI&oacute; FAVOR DE REPORTARLO";
					window.location.href = "#errorModal";
					console.log(httpObject.status);
				}
			};
			console.log("se envia peticion soapData al digitalizador");
			httpObject.send(soapData);
		}
	
}

//Obtiene el objeto de peticion
function getHTTPObject(){
	console.log("obtenecion de objeto http");
    var xhr = false;
    if (window.ActiveXObject) {
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch(e) {
            try {
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            } catch(e) {
                xhr = false;
            }
        }
    } else if (window.XMLHttpRequest) {
        try {
            xhr = new XMLHttpRequest();
        } catch(e) {
            xhr = false;
        }
    }
    return xhr;
}

/**
 * Remplaza la cadena
 * @param cadena
 * @param cadenaBuscar
 * @param valor
 * @returns
 */
function remplazar(cadena,cadenaBuscar,valor){
	console.log("reemplazar cadena , " + cadena + " , " + cadenaBuscar + " , " + valor);
	while(cadena.search(cadenaBuscar) != -1){
		cadena = cadena.replace(cadenaBuscar,valor);
	}
	
	return cadena;
}