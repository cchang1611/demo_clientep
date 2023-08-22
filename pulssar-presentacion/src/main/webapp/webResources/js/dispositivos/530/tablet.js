
/**
 * Incia carga de tablet
 * @param signValue
 * @returns
 */
function iniciarTablet1(folio,tramite,nss,curp,tipoParentesco,tramiteNoPrescial) {
	generarPeticion1(folio,tramite,nss,curp,tipoParentesco,tramiteNoPrescial);	
}

function iniciarTablet(folio,tramite,nss,curp,tipoParentesco,tramiteNoPrescial) {
	generarPeticion(folio,tramite,nss,curp,tipoParentesco,tramiteNoPrescial);	
}



/**
 * @param folio - Folio procesar
 * @param tramite - clave tramite
 * @param nss - nss 
 * @param curp - curp
 * @param tipoParentesco -1-Titular,2-Beneficiario,4-ejecutivo de servicio,6-representante legal,9-tutor,10-curador
 * @param tramiteNoPrescial =TRAMITE NO PRESENCIAL, N-NO  S-Si 
 * @returns
 */
function generarPeticion1(folio,tramite,nss,curp,tipoParentesco,tramiteNoPrescial){
	    var peticion = {};
	    peticion.numSol=folio;
	    peticion.modRet=tramite;
	    peticion.Us="usuario"
	    peticion.nss=nss;
	    peticion.curp=curp;
	    peticion.tps=tipoParentesco;
	    peticion.tnp=tramiteNoPrescial;
	
		var url = "../private/urlTabletBanorte.do";
		console.log("Url: "+url);
		
		
			$.ajax({
				method      : "POST",
				url         : url,
				contentType : "application/json",
				data		: JSON.stringify(peticion)
			})
			.success(function(data) {
				  console.log(data);
				  ejecutarTablet1(data);
					//console.log("Imagen "+data.mensaje);
			})
			.error(function(data) {
				console.log("Error en al generar la peticion");
				console.log("stringify "+JSON.stringify(data));		
			});

		
	
}


/**
 * @param folio - Folio procesar
 * @param tramite - clave tramite
 * @param nss - nss 
 * @param curp - curp
 * @param tipoParentesco -1-Titular,2-Beneficiario,4-ejecutivo de servicio,6-representante legal,9-tutor,10-curador
 * @param tramiteNoPrescial =TRAMITE NO PRESENCIAL, N-NO  S-Si 
 * @returns
 */
function generarPeticion(folio,tramite,nss,curp,tipoParentesco,tramiteNoPrescial){
	    var peticion = {};
	    peticion.numSol=folio;
	    peticion.modRet=tramite;
	    peticion.Us="usuario"
	    peticion.nss=nss;
	    peticion.curp=curp;
	    peticion.tps=tipoParentesco;
	    peticion.tnp=tramiteNoPrescial;
	
		var url = "../private/urlTabletBanorte.do";
		console.log("Url: "+url);
		
			$.ajax({
				method      : "POST",
				url         : url,
				contentType : "application/json",
				data		: JSON.stringify(peticion)
			})
			.success(function(data) {
				  console.log(data);
				  ejecutarTablet1(data);
//				  ejecutarTablet(data);
					//console.log("Imagen "+data.mensaje);
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
function ejecutarTablet1(url1){
	 console.log(url1); 
	    var url= remplazar(url1, "https", "http");
	    console.log("url final sustituida",url); 
	    open(url,'_blank') ;

//	 open(url,'_blank','top=100,left=300,width=550,height=450') ;
	//open('http://localhost:8080/pulssar/public/tabletBanorte1.do#','','top=100,left=300,width=550,height=450') ;
	// window.location.assign(url)
}

function ejecutarTablet(url1){
    console.log("Url: "+url1);
    var url= remplazar(url1, "https", "http")

	$.ajax({
		method      : "GET",
		url         : url
		//contentType : "application/html",
		//data		: JSON.stringify(peticion);
	})
	.success(function(data) {
		console.log("consulta exitosa");
	})
	.error(function(data) {
		console.log("Error en la invocacion tablet banorte");
		console.log("stringify "+JSON.stringify(data));		
	});


}

function iniciarTabletJs(folio,tramite,usuarioAgente,ambiente,nss,curp,tipoParentesco,tramiteNoPrescial){
	var objbuilder = '';
	objbuilder += ('http://172.20.237.6/AforeBridgeTablet/AppBridgeTablet.application?');
//	objbuilder += ('http://200.77.225.156/AforeBridgeTablet/AppBridgeTablet.application?');
	objbuilder += ('numSol=');
	objbuilder += (folio);
	objbuilder += ('&modRet=');
	objbuilder += (tramite);
	objbuilder += ('&us=');
	objbuilder += (usuarioAgente);
	objbuilder += ('&amb=');
	objbuilder += (ambiente);
	objbuilder += ('&nss=');
	if(nss == null || nss == ""){
		objbuilder += (00000000000);
	}else{
		objbuilder += (nss);
	}
	objbuilder += ('&curp=');
	objbuilder += (curp);
	objbuilder += ('&tps=');
	objbuilder += (tipoParentesco);
	objbuilder += ('&tnp=');
	objbuilder += (tramiteNoPrescial);
	var urlConformada = objbuilder;
	ejecutarTabletJs(urlConformada);
//    var urlSustituida= remplazar(url1, "https", "http")
//	window.location.href = urlSustituida;
//	ejecutarTabletJs(urlConformada);







//		S0000187202010160017&modRet=46&us=1503002502&amb=D&nss=12345678&curp=CEMA680702HSPDRN00&tps=1&tnp=N
	
}

function ejecutarTabletJs(url1){
    var url= remplazar(url1, "https", "http")
    console.log("Url: "+url);

	$.ajax({
		method      : "GET",
		url         : url,
		contentType : "application/html",
		//data		: JSON.stringify(peticion);
	})
	.success(function(data) {
		console.log("consulta exitosa");
	})
	.error(function(data) {
		console.log("Error en la invocacion tablet banorte");
		console.log("stringify "+JSON.stringify(data));		
	});


}


/**
 * Remplaza la cadena
 * @param cadena
 * @param cadenaBuscar
 * @param valor
 * @returns
 */
function remplazar(cadena,cadenaBuscar,valor){
	
	while(cadena.search(cadenaBuscar) != -1){
		cadena = cadena.replace(cadenaBuscar,valor);
	}
	
	return cadena;
}
